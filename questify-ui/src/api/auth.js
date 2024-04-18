import axios from './axios';

// Function to log in a user
export const login = async (data) => {
    try {
        const response = await axios.post('/auth/login', data);
        if (response.data) {
            const user = response.data;
            console.log("User: ", user);
            localStorage.setItem("isLogin", true)
            localStorage.setItem('user', JSON.stringify(user));  // Storing the token
            axios.defaults.headers.common['Authorization'] = `Bearer ${user.token}`;
        }
        return response.data;
    } catch (error) {
        console.error('Login failed:', error);
        throw error;
    }
};

// Function to log out a user
export const logout = () => {
    localStorage.removeItem('user');
    delete axios.defaults.headers.common['Authorization'];
};

// Initialize the Axios headers if token is stored in localStorage
const storedToken = localStorage.getItem('user');
if (storedToken) {
    axios.defaults.headers.common['Authorization'] = `Bearer ${storedToken}`;
}

// You might also want to handle token refresh logic here
