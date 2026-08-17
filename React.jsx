import React, { useState, useEffect } from 'react';

export default function UserListDashboard() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  // useEffect triggers once when component mounts (empty dependency array [])
  useEffect(() => {
    const fetchBackendUsers = async () => {
      try {
        setLoading(true);
        // Simulating API call to Spring Boot REST Endpoint
        const response = await fetch('http://localhost:8080/api/v1/users');
        
        if (!response.ok) {
          throw new Error(`HTTP Error: ${response.status}`);
        }

        const data = await response.json();
        setUsers(data);
      } catch (err) {
        setError(err.message);
      } finally {
        setLoading(false);
      }
    };

    fetchBackendUsers();
  }, []); // Empty array ensures this runs only once on mount

  if (loading) return <div>⏳ Loading data from Spring Boot API...</div>;
  if (error) return <div style={{ color: 'red' }}>❌ Error loading users: {error}</div>;

  return (
    <div style={{ maxWidth: '500px', margin: '2rem auto', fontFamily: 'sans-serif' }}>
      <h3>🚀 Day 55: Live Backend User Stream</h3>
      <ul>
        {users.map(user => (
          <li key={user.id} style={{ margin: '8px 0' }}>
            <strong>{user.username}</strong> — {user.email}
          </li>
        ))}
      </ul>
    </div>
  );
}