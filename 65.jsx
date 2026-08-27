// 1. Environment Variable Configuration (.env.production)
// VITE_API_BASE_URL=https://api.myapp.com/api/v1

// 2. Optimized App Routing with Lazy Loading (App.jsx)
import React, { Suspense, lazy } from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';

// Lazy load non-critical route chunks on demand
const Dashboard = lazy(() => import('./pages/Dashboard'));
const AdminSettings = lazy(() => import('./pages/AdminSettings'));

// Centralized API configuration using Vite Environment Variables
export const API_URL = import.meta.env.VITE_API_BASE_URL || 'http://localhost:8080/api/v1';

export default function App() {
  return (
    <BrowserRouter>
      {/* Suspense fallback renders while lazy chunk downloads */}
      <Suspense fallback={<div style={{ padding: '2rem' }}>⚡ Loading optimized route...</div>}>
        <Routes>
          <Route path="/" element={<Dashboard />} />
          <Route path="/admin" element={<AdminSettings />} />
        </Routes>
      </Suspense>
    </BrowserRouter>
  );
}