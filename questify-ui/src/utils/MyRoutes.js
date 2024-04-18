import {useRoutes} from "react-router-dom";
import Welcome from "../pages/home/Welcome";
import Signin from "../pages/Signin";
import Signup from "../pages/Signup";
import { ROUTES } from "../constants/routes";
import UserHomePage from "../pages/home/UserHomePage";
import Dashboard from "../pages/home/Dashboard";

export default function MyRoutes() {
    return useRoutes([
        {path: "*", element: <Welcome/>},
        {path: ROUTES.WELCOME, element: <Welcome/>},
        {path: ROUTES.SIGN_IN, element: <Signin/>},
        {path: ROUTES.SIGN_UP, element: <Signup/>},
        {path: ROUTES.USER_HOME_PAGE, element: <UserHomePage/>},
        {path: ROUTES.ADMIN_DASHBOARD, element: <Dashboard/>}
    ])
}