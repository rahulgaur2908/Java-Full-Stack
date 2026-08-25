import React, { useState, useEffect } from 'react';
import apiClient from '../api/axiosClient';

export default function UserCrudDashboard() {
  const [users, setUsers] = useState([]);
  const [newUsername, setNewUsername] = useState('');
  const [newEmail, setNewEmail] = useState('');

  // 1. READ: Fetch all users on mount
  useEffect(() => {
    loadUsers();
  }, []);

  const loadUsers = async () => {
    try {
      const data = await apiClient.get('/users');
      setUsers(data);
    } catch (err) {
      console.error('Failed to load users:', err);
    }
  };

  // 2. CREATE: Add new user via POST
  const handleCreateUser = async (e) => {
    e.preventDefault();
    try {
      const createdUser = await apiClient.post('/users', { username: newUsername, email: newEmail });
      setUsers(prev => [...prev, createdUser]); // Optimistic local state update
      setNewUsername('');
      setNewEmail('');
    } catch (err) {
      console.error('Error creating user:', err);
    }
  };

  // 3. DELETE: Remove user via DELETE
  const handleDeleteUser = async (id) => {
    try {
      await apiClient.delete(`/users/${id}`);
      setUsers(prev => prev.filter(user => user.id !== id)); // Remove from UI
    } catch (err) {
      console.error('Error deleting user:', err);
    }
  };

  return (
    <div style={{ maxWidth: '600px', margin: '2rem auto', fontFamily: 'sans-serif' }}>
      <h2>🚀 Full-Stack User Management</h2>

      {/* Creation Form */}
      <form onSubmit={handleCreateUser} style={{ display: 'flex', gap: '8px', marginBottom: '1.5rem' }}>
        <input 
          placeholder="Username" 
          value={newUsername} 
          onChange={e => setNewUsername(e.target.value)} 
          required 
        />
        <input 
          placeholder="Email" 
          value={newEmail} 
          onChange={e => setNewEmail(e.target.value)} 
          required 
        />
        <button type="submit">Add User</button>
      </form>

      {/* Data Table */}
      <table border="1" cellPadding="8" style={{ width: '100%', borderCollapse: 'collapse' }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {users.map(u => (
            <tr key={u.id}>
              <td>{u.id}</td>
              <td>{u.username}</td>
              <td>{u.email}</td>
              <td>
                <button onClick={() => handleDeleteUser(u.id)} style={{ color: 'red' }}>
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}