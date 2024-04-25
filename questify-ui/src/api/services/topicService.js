import { ENDPOINTS } from "../../constants/endpoints";
import apiService from "./apiServices";

let topicServices = new apiService(ENDPOINTS.TOPIC);

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

topicServices = {...topicServices};

export default topicServices;