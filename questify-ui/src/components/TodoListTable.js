import { useEffect, useState } from "react";
import store from "../app/store";
import { deleteTaskById, getTaskByUserId } from "../features/task/TaskSlice";
import { userDetails } from "../api/auth";
import Swal from 'sweetalert2'

function TodoListTable({ setIsUpdate, setFormData, setTaskId }) {
    const [tasks, setTasks] = useState();
    const tasksStore = store.getState().task.tasks

    useEffect(() => {
        if (tasksStore.length === 0) {
            console.log("API");
            store.dispatch(getTaskByUserId(userDetails?.id)).then(res => {
                setTasks(res?.payload)
            })
        } else {
            console.log("Store");
            setTasks(tasksStore)
        }
    }, [tasksStore])

    function handleDeleteTask(task) {
        Swal.fire({
            title: "Are you sure, you want to delete?",
            text: task?.name,
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Yes, delete it!"
        }).then((result) => {
            if (result.isConfirmed) {
                store.dispatch(deleteTaskById(task?.id)).then((res) => {
                    console.log("Deleted: ", res);
                    Swal.fire({
                        title: "Deleted!",
                        text: "Your file has been deleted.",
                        icon: "success"
                    });
                })

            }
        });
    }

    function handleUpdateTask(task) {
        let data = {
            name: task.name,
            description: task.description,
            deadline: task.deadline,
            priority: task.priority,
            status: task.status
        }
        setTaskId(task.id)
        setFormData(data)
        setIsUpdate('true')
        scrollToTop()
    }

    function scrollToTop() {
        // Scrolls smoothly to the top of the page
        window.scrollTo({
            top: 0,
            behavior: 'smooth'
        });
    }

    return (
        <div>
            <section className="gradient-custom-2">
                <div className="container py-5 h-100 border border-1 rounded-4">
                    <table className="table text-white mb-0">
                        <thead>
                            <tr>
                                <th scope="col">Task</th>
                                <th scope="col">Description</th>
                                <th scope="col">Due</th>
                                <th scope="col">Priority</th>
                                <th scope="col">Status</th>
                                <th scope="col">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            {tasks?.map((task) => (
                                <tr className={task.status === "COMPLETED"? "fw-normal table-success" : "fw-normal"} key={task.id}>
                                    <th>
                                        <span className="ms-2">{task?.name}</span>
                                    </th>
                                    <td className="align-middle">
                                        <span>{task?.description}</span>
                                    </td>
                                    <td>
                                        <p className="small mb-0"><i></i>{task?.deadline}</p>
                                    </td>
                                    <td className="align-middle">
                                        <h6 className="mb-0">
                                            <span
                                                className={
                                                    task?.priority === "HIGH" ? "badge bg-danger" :
                                                        task?.priority === "MEDIUM" ? "badge bg-warning" : "badge bg-success"}>
                                                {task?.priority}
                                            </span>
                                        </h6>
                                    </td>
                                    <td className="align-middle"> {/*btn-sm btn-outline-primary text-primary border-1*/}
                                        <h6 className="mb-0">
                                            <span className={
                                                task?.status === "TODO" ? "badge bg-primary" :
                                                    task?.status === "IN_PROGRESS" ? "badge bg-warning" : 
                                                    task?.status === "COMPLETED" ? "badge bg-success" : 
                                                    task?.status === "CANCELLED" ? "badge bg-danger" : "badge bg-info"}>
                                                {task?.status}
                                            </span>
                                        </h6>
                                    </td>
                                    <td className="align-middle">
                                        <span data-mdb-tooltip-init title="Done"><i
                                            className="fas fa-check fa-lg text-success me-3"></i></span>
                                        <span onClick={() => handleUpdateTask(task)} data-mdb-tooltip-init title="Edit"><i
                                            className="fas fa-pen-to-square fa-lg text-warning me-3"></i></span>
                                        <span onClick={() => handleDeleteTask(task)} data-mdb-tooltip-init title="Remove"><i
                                            className="fas fa-trash-alt fa-lg text-danger"></i></span>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </section>

        </div>
    )
}

export default TodoListTable