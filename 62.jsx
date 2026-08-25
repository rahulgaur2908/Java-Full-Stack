import React, { useState } from 'react';
import { Navigate, Outlet, useNavigate } from 'react-router-dom';
import apiClient from '../api/axiosClient';
import { useAuth } from '../context/AuthContext';

// 1. Protected Route Wrapper Component
export const ProtectedRoute = () => {
  const { token } = useAuth();
  // Redirect unauthenticated visitors to login
  return token ? <Outlet /> : <Navigate to="/login" replace />;
};

// 2. Controlled Login Component with JWT Handshake
export const LoginForm = () => {
  const [credentials, setCredentials] = useState({ email: '', password: '' });
  const [error, setError] = useState('');
  const { login } = useAuth();
  const navigate = useNavigate();

  const handleChange = (e) => {
    setCredentials(prev => ({ ...prev, [e.target.name]: e.target.value }));
  };

  const handleLoginSubmit = async (e) => {
    e.preventDefault();
    setError('');

    try {
      // POST credentials to Spring Boot backend
      const response = await apiClient.post('/auth/login', credentials);
      const { token, user } = response;

      // Save token into context & localStorage
      login(token, user);
      navigate('/dashboard');
    } catch (err) {
      setError(err.response?.data?.message || 'Invalid email or password');
    }
  };

  return (
    <div style={{ maxWidth: '380px', margin: '3rem auto', fontFamily: 'sans-serif' }}>
      <h2>🔐 Secure Login</h2>
      {error && <p style={{ color: '#ef4444' }}>{error}</p>}
      
      <form onSubmit={handleLoginSubmit}>
        <div style={{ marginBottom: '1rem' }}>
          <label>Email</label>
          <input
            type="email"
            name="email"
            value={credentials.email}
            onChange={handleChange}
            style={{ width: '100%', padding: '8px', marginTop: '4px' }}
            required
          />
        </div>

        <div style={{ marginBottom: '1rem' }}>
          <label>Password</label>
          <input
            type="password"
            name="password"
            value={credentials.password}
            onChange={handleChange}
            style={{ width: '100%', padding: '8px', marginTop: '4px' }}
            required
          />
        </div>

        <button type="submit" style={{ width: '100%', padding: '10px', cursor: 'pointer' }}>
          Sign In
        </button>
      </form>
    </div>
  );
};