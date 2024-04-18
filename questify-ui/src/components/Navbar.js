import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { NAV_ROUTES, ROUTES } from '../constants/routes';
import { useNavigate } from "react-router-dom";

function Navbar() {
    const isLogin = localStorage.getItem("isLogin");
    const [user, setUser] = useState();
    const navigate = useNavigate();

    useEffect(() => {
        if (isLogin !== undefined && isLogin === "true") {
            const user = JSON.parse(localStorage.getItem("user"));
            if (user) {
                setUser(user);
            }
        }
    }, [isLogin])

    const handleLogout = () => {
        localStorage.clear("isLogin");
        localStorage.clear("user");
        navigate(ROUTES.WELCOME)
    }

    return (
        <nav style={styles.navbar}>
            <h1 style={styles.logo}>Questify</h1>
            {JSON.parse(isLogin) 
            ?
                (
                    <div style={styles.links}>
                        <label>{user?.fullName}</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button onClick={() => handleLogout()} style={{ marginRight: "10px" }}>Logout</button>
                    </div>
                ) 
            :
                (
                    <div style={styles.links}>
                        <Link to={NAV_ROUTES.HOME} style={styles.link}>Home</Link>
                        <Link to={NAV_ROUTES.ABOUT} style={styles.link}>About</Link>
                        <Link to={NAV_ROUTES.FEATURES} style={styles.link}>Features</Link>
                        <Link to={NAV_ROUTES.CONTACT} style={styles.link}>Contact</Link>
                    </div>
                )
            }
        </nav>
    );
}

const styles = {
    navbar: {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'center',
        padding: '10px 50px',
        backgroundColor: '#007F73',
        color: 'white',
    },
    logo: {
        margin: 0,
        fontSize: '24px',
        color: '#FFF455'
    },
    links: {
        display: 'flex',
    },
    link: {
        color: 'white',
        textDecoration: 'none',
        marginLeft: '20px',
    }
};

export default Navbar;
