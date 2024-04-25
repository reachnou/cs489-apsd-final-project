import {combineReducers} from "redux";
import taskReducer from "../features/task/TaskSlice"
import topicReducer from "../features/topic/topicSlice"

export const rootReducer = combineReducers({
    task: taskReducer,
    topic: topicReducer,
})