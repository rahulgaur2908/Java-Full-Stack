// Day 51: Consuming REST APIs with ES6+ Async/Await

const API_ENDPOINT = 'http://localhost:8080/api/v1/users/101';

// Asynchronous function to fetch user profile data
const fetchUserProfile = async (userId) => {
    try {
        console.log(`🔍 [HTTP GET] Fetching profile for User ID: ${userId}...`);
        
        // Simulating fetch call to Spring Boot backend
        const response = await fetch(`${API_ENDPOINT}`);
        
        if (!response.ok) {
            throw new Error(`HTTP Error! Status: ${response.status}`);
        }

        const data = await response.json();

        // Destructuring object properties cleanly (ES6)
        const { username, email, role } = data.user;

        console.log(`✅ Profile Loaded Successfully:`);
        console.log(`   User: ${username} | Email: ${email} | Role: ${role}`);

    } catch (error) {
        console.error(`❌ Fetch Failed: ${error.message}`);
    }
};

// Executing Async Function
fetchUserProfile(101);