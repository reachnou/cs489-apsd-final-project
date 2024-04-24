import {useRoutes} from "react-router-dom";
import Welcome from "../pages/home/Welcome";
import Signin from "../pages/Signin";
import Signup from "../pages/Signup";
import { ROUTES } from "../constants/routes";
import UserHomePage from "../pages/home/UserHomePage";
import Dashboard from "../pages/home/Dashboard";
import TodoListPage from "../pages/TodoListPage";
import ChallengePage from "../pages/ChallengePage";

export default function MyRoutes() {
    return useRoutes([
        {path: "*", element: <Welcome/>},
        {path: ROUTES.WELCOME, element: <Welcome/>},
        {path: ROUTES.SIGN_IN, element: <Signin/>},
        {path: ROUTES.SIGN_UP, element: <Signup/>},
        {path: ROUTES.USER_HOME_PAGE, element: <UserHomePage/>},
        {path: ROUTES.ADMIN_DASHBOARD, element: <Dashboard/>},
        {path: ROUTES.TODO_LIST, element: <TodoListPage/>},
        {path: ROUTES.CHALLENGE, element: <ChallengePage/>}
    ])
}