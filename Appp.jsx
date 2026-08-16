import React, { useState } from 'react';

export default function UserRegistrationForm() {
  
  // 1. Managing multiple state values cleanly
  const [formData, setFormData] = useState({
    username: '',
    role: 'Developer'
  });
  const [submitted, setSubmitted] = useState(false);

  // 2. Generic change handler for controlled inputs
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prev => ({
      ...prev,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    setSubmitted(true);
  };

  return (
    <div style={{ maxWidth: '400px', margin: '2rem auto', fontFamily: 'sans-serif' }}>
      <h3>🚀 Day 54: User State Management</h3>
      
      <form onSubmit={handleSubmit}>
        <div style={{ marginBottom: '1rem' }}>
          <label>Username:</label>
          <input
            type="text"
            name="username"
            value={formData.username}
            onChange={handleChange}
            placeholder="Enter username"
            style={{ width: '100%', padding: '8px', marginTop: '4px' }}
            required
          />
        </div>

        <button type="submit" style={{ padding: '8px 16px', cursor: 'pointer' }}>
          Save User State
        </button>
      </form>

     
      {/* 3. Conditional Rendering based on state */}
      {submitted && (
        <div style={{ marginTop: '1rem', padding: '10px', background: '#e0f2fe', borderRadius: '6px' }}>
          ✅ State Synced: <strong>{formData.username}</strong> ({formData.role})
        </div>
      )}
    </div>
  );
}