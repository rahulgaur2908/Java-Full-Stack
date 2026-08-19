import React, { createContext, useContext, useState } from 'react';

// 1. Create the Authentication Context
const AuthContext = createContext(null);

// 2. Context Provider Component managing Global State
export const AuthProvider = ({ children }) => {
  const [user, setUser] = useState({ name: 'Rahul', role: 'Full Stack Dev', isAuthenticated: true });

  const logout = () => setUser(null);

  return (
    <AuthContext.Provider value={{ user, logout }}>
      {children}
    </AuthContext.Provider>
  );
};

// 3. Custom Hook for clean context consumption
export const useAuth = () => {
  const context = useContext(AuthContext);
  if (!context) {
    throw new Error('useAuth must be used within an AuthProvider');
  }
  return context;
};

// 4. Deeply Nested Component consuming Global State (No Prop Drilling!)
const UserBadge = () => {
  const { user, logout } = useAuth();

  if (!user) return <p>Please log in.</p>;

  return (
    <div style={{ padding: '1rem', background: '#1e293b', color: '#f8fafc', borderRadius: '8px' }}>
      <h4> {user.name} ({user.role})</h4>
      <p>Status:  Authenticated</p>
      <button onClick={logout} style={{ padding: '4px 10px', cursor: 'pointer' }}>
        Log Out
      </button>
    </div>
  );
};

// 5. Main App wrapping tree with Provider
export default function App() {
  return (
    <AuthProvider>
      <div style={{ maxWidth: '400px', margin: '2rem auto', fontFamily: 'sans-serif' }}>
        <h2>Day 57: Global Context Store</h2>
        <UserBadge />
      </div>
    </AuthProvider>
  );
}