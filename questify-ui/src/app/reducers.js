import {combineReducers} from "redux";
import taskReducer from "../features/task/TaskSlice"

export const rootReducer = combineReducers({
    task: taskReducer,
})