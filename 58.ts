// Location: src/api/axiosClient.js
import axios from 'axios';

// 1. Create Centralized Axios Instance
const apiClient = axios.create({
  baseURL: 'http://localhost:8080/api/v1',
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

// 2. Request Interceptor: Automatically Attach JWT Bearer Token
apiClient.interceptors.request.use(
  (config: { headers: { Authorization: string; }; }) => {
    const token = localStorage.getItem('authToken');
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error: any) => {
    return Promise.reject(error);
  }
);

// 3. Response Interceptor: Centralized Error & Session Handling
apiClient.interceptors.response.use(
  (response: { data: any; }) => {
    // Return direct response data cleanly
    return response.data;
  },
  (error: { response: { status: number; }; }) => {
    if (error.response && error.response.status === 401) {
      console.warn('⚠️ Session expired or invalid token! Redirecting to login...');
      localStorage.removeItem('authToken');
      window.location.href = '/login';
    }
    return Promise.reject(error);
  }
);

export default apiClient;