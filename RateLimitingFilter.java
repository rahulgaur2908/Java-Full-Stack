package com.rahul.fullstack.filter;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class RateLimitingFilter extends OncePerRequestFilter {

    // Cache to hold per-IP client buckets (can be backed by Redis in production)
    private final Map<String, Bucket> ipBucketCache = new ConcurrentHashMap<>();

    private Bucket createNewBucket() {
        // Limit: 10 requests per minute with greedy refill
        Bandwidth limit = Bandwidth.classic(10, Refill.greedy(10, Duration.ofMinutes(1)));
        return Bucket.builder().addLimit(limit).build();
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain) 
                                    throws ServletException, IOException {

        String clientIp = request.getRemoteAddr();
        Bucket bucket = ipBucketCache.computeIfAbsent(clientIp, k -> createNewBucket());

        // Try consuming 1 token
        if (bucket.tryConsume(1)) {
            filterChain.doFilter(request, response);
        } else {
            // Quota exceeded: Return 429 Too Many Requests
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            response.setContentType("application/json");
            response.setHeader("X-Rate-Limit-Retry-After-Seconds", "60");
            response.getWriter().write("""
                {
                    "error": "Too Many Requests",
                    "message": "Rate limit exceeded. Please try again in 60 seconds."
                }
            """);
        }
    }
}