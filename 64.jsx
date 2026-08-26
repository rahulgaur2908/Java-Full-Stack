import React, { useState, useEffect } from 'react';
import apiClient from '../api/axiosClient';

// 1. Reusable Skeleton Loader Component
const TableSkeleton = ({ rows = 3 }) => (
  <tbody>
    {Array.from({ length: rows }).map((_, idx) => (
      <tr key={idx} className="skeleton-row">
        <td colSpan="4">
          <div style={{
            height: '24px',
            backgroundColor: '#e2e8f0',
            borderRadius: '4px',
            animation: 'pulse 1.5s infinite ease-in-out',
            margin: '6px 0'
          }} />
        </td>
      </tr>
    ))}
  </tbody>
);

// 2. Main Component with Skeleton and Toast Feedback
export default function UserListWithFeedback() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [toast, setToast] = useState(null);

  const showToast = (message, type = 'success') => {
    setToast({ message, type });
    setTimeout(() => setToast(null), 3000);
  };

  useEffect(() => {
    const fetchData = async () => {
      try {
        setLoading(true);
        const data = await apiClient.get('/users');
        setUsers(data);
        showToast('✅ Data synchronized successfully!');
      } catch (err) {
        showToast('❌ Failed to load user records', 'error');
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  return (
    <div style={{ maxWidth: '600px', margin: '2rem auto', fontFamily: 'sans-serif' }}>
      {/* Toast Banner */}
      {toast && (
        <div style={{
          padding: '10px 16px',
          marginBottom: '1rem',
          borderRadius: '6px',
          backgroundColor: toast.type === 'success' ? '#dcfce7' : '#fee2e2',
          color: toast.type === 'success' ? '#166534' : '#991b1b',
          fontWeight: 500
        }}>
          {toast.message}
        </div>
      )}

      <h3>🚀 Day 64: Enhanced UX Dashboard</h3>

      <table width="100%" border="1" cellPadding="8" style={{ borderCollapse: 'collapse' }}>
        <thead>
          <tr><th>ID</th><th>Username</th><th>Email</th></tr>
        </thead>
        
        {/* Render Skeleton while loading; render real data when ready */}
        {loading ? (
          <TableSkeleton rows={4} />
        ) : (
          <tbody>
            {users.map(u => (
              <tr key={u.id}>
                <td>{u.id}</td>
                <td>{u.username}</td>
                <td>{u.email}</td>
              </tr>
            ))}
          </tbody>
        )}
      </table>
    </div>
  );
}