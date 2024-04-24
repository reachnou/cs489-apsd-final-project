import { Link } from "react-router-dom"
import { ROUTES } from "../constants/routes"

function Sidebar() {
    return (
        <div>
            <div class="container-fluid bg-light vh-100">
                <ul class="list-group list-group-flush text-center">
                    <li class="list-group-item">
                        <Link to={ROUTES.USER_HOME_PAGE}>Home</Link>
                    </li>
                    <li class="list-group-item">
                        <Link to={ROUTES.TODO_LIST}>To-do List</Link>
                    </li>
                    <li class="list-group-item">
                        <Link to={ROUTES.CHALLENGE}>Challenges</Link>
                    </li>
                    <li class="list-group-item">
                        <Link to={ROUTES.WELCOME}>Logout</Link>
                    </li>
                </ul>
            </div>
        </div>
    )
}

export default Sidebar