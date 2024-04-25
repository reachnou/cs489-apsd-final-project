import {createAsyncThunk, createSlice} from '@reduxjs/toolkit';
import { SLICES } from '../../constants/slices';
import topicServices from '../../api/services/topicService';

const initialState = {
    topics: [],
}

export const topicSlice = createSlice({
    name: SLICES.TOPIC,
    initialState,
    extraReducers: (builder) => {
        builder
        .addCase(getAllTopics.fulfilled, (state, action) => {
            state.topics = action.payload
        })
        .addCase(createTopic.fulfilled, (state, action) => {
            state.topics = [...state.topics, action.payload]
        })
        // .addCase(deleteTaskById.fulfilled, (state, action) => {
        //     let afterDeleted = state.tasks.filter(task => task.id !== action.payload.id)
        //     state.tasks = [...afterDeleted]
        // })
        // .addCase(updateTaskById.fulfilled, (state, action) => {
        //     let afterDeleted = state.tasks.filter(task => task.id !== action.payload.id)
        //     state.tasks = [...afterDeleted, action.payload]
        // })
    }
});

export const getAllTopics = createAsyncThunk(
    "/tasks/getAllTopics",
    async () => {
        const response = await topicServices.getAll()
        return response.data
    }
)

export const createTopic = createAsyncThunk(
    "/topic/create",
    async (data) => {
        const response = await topicServices.add(data)
        return response.data
    }
)

export const getTopicById = createAsyncThunk(
    "/topic/getTopicById",
    async (id) => {
        const response = await topicServices.getById(id)
        return response.data
    }
)

// export const deleteTaskById = createAsyncThunk(
//     "/tasks/delete",
//     async (id) => {
//         const response = await taskServices.remove(id)
//         return response.data
//     }
// )

// export const updateTaskById = createAsyncThunk(
//     "/tasks/updateTaskById",
//     async (id, data) => {
//         const response = await taskServices.update(id, data)
//         return response.data
//     }
// )

export default topicSlice.reducer