import { ENDPOINTS } from "../../constants/endpoints";
import apiService from "./apiServices";

let questionServices = new apiService(ENDPOINTS.QUESTION);

// Additional functions here
// const getAllTasksByUserId = (userId) => {
//     return axiosInstance.get(ENDPOINTS.TASK + `/user?userId=${userId}`)
// }

// const createTask = (data) => {
//     return axiosInstance.post(ENDPOINTS.TASK + `?userId=${userDetails.id}`, data)
// }

// const updateTasksById = (id, data) => {
//     return axiosInstance.put(ENDPOINTS.TASK + `/${id}`, data)
// }

questionServices = {...questionServices};

export default questionServices;