import React from 'react';
import { BrowserRouter, Routes, Route, Link, useParams, useNavigate } from 'react-router-dom';

// 1. Home Component with Navigation
const Home = () => (
  <div style={{ padding: '1rem' }}>
    <h2>Home Dashboard</h2>
    <p>Welcome to Day 56 of the Full Stack Journey.</p>
    <Link to="/users/101">View User Profile #101</Link>
  </div>
);

// 2. Dynamic Details Component using useParams & useNavigate
const UserProfile = () => {
  const { id } = useParams();
  const navigate = useNavigate();

  return (
    <div style={{ padding: '1rem', border: '1px solid #334155', borderRadius: '8px' }}>
      <h2> User Profile: #{id}</h2>
      <p>Data synced with backend route: <code>/api/v1/users/{id}</code></p>
      <button onClick={() => navigate('/')} style={{ padding: '6px 12px', cursor: 'pointer' }}>
        ← Back to Home
      </button>
    </div>
  );
};

// 3. Main Routing Hub
export default function App() {
  return (
    <BrowserRouter>
      <nav style={{ padding: '1rem', background: '#0f172a', color: '#fff', display: 'flex', gap: '1rem' }}>
        <Link to="/" style={{ color: '#38bdf8', textDecoration: 'none' }}>Home</Link>
        <Link to="/users/101" style={{ color: '#38bdf8', textDecoration: 'none' }}>Profile</Link>
      </nav>

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/users/:id" element={<UserProfile />} />
      </Routes>
    </BrowserRouter>
  );
}