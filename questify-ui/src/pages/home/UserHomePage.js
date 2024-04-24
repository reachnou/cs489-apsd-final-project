// import Footer from "../../components/Footer";
import Navbar from "../../components/Navbar";
import Sidebar from "../../components/Sidebar";
import TodoListTable from "../../components/TodoListTable";

function UserHomePage() {
    return (
        <div>
            <Navbar/>
            <div className="row">
                <div className="col-2">
                    <Sidebar/>
                </div>
                <div className="col-10">
                    <h1>Homepage</h1>
                    <TodoListTable/>
                </div>
            </div>
            {/* <Footer/> */}
        </div>
    )
}

export default UserHomePage;