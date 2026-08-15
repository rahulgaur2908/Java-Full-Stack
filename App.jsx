import React from 'react';

// 1. Reusable Child Component accepting Props.

const StatusCard = ({ title, status, techStack, isOnline }) => {
  return (
    <div style={{
      border: '1px solid #334155',
      borderRadius: '10px',
      padding: '1rem',
      backgroundColor: '#1e293b',
      color: '#f8fafc',
      margin: '0.75rem 0'
    }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center' }}>
        <h3>{title}</h3>
        <span style={{
          color: isOnline ? '#4ade80' : '#f87171',
          fontWeight: 'bold',
          fontSize: '0.9rem'
        }}>
          ● {status}
        </span>
      </div>
      <p style={{ color: '#94a3b8', margin: '0.5rem 0 0' }}>
        Stack: <strong>{techStack}</strong>
      </p>
    </div>
  );
};

// 2. Parent Container Component passing data via Props
export default function App() {
  return (
    <div style={{ maxWidth: '450px', margin: '2rem auto', fontFamily: 'sans-serif' }}>
      <h2>Day 53: Component Dashboard</h2>
      
      <StatusCard 
        title="Backend Service" 
        status="Healthy" 
        techStack="Spring Boot & PostgreSQL" 
        isOnline={true} 
      />
      
      <StatusCard 
        title="Frontend Client" 
        status="Active" 
        techStack="React & Modern JSX" 
        isOnline={true} 
      />
    </div>
  );
}  