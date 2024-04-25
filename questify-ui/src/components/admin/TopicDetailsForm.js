import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import store from '../../app/store';
import { getTopicById } from '../../features/topic/topicSlice';
import QuestionCard from './QuestionCard';

const TopicDetailsForm = () => {
    const { id } = useParams()
    const [isEditTopic, setIsEditTopic] = useState(false)
    const [topic, setTopic] = useState()
    const topics = store.getState().topic.topics

    useEffect(() => {
        if (topics?.length === 0) {
            console.log("API");
            store.dispatch(getTopicById(id)).then(res => {
                if (res?.payload) {
                    setTopic(res.payload)
                }
            })
        } else {
            console.log("STORE");
            const top = topics?.filter(t => t.id == id)
            setTopic(top[0])
        }

    }, [topics, id])

    const handlerSetIsEditTopic = () => {
        setIsEditTopic(current => !current)
    }

    return (
        <div className='container'>
            {isEditTopic ?
                <div class="row d-flex justify-content-center align-items-center h-100 mb-4">
                    <h1 className='text-center fw-bold p-4'>
                        {topic?.name}
                    </h1>
                    <div class="col">
                        <div id="list1">
                            <div class="card-body">
                                <form>
                                    <div class="pb-2">
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="row d-flex justify-content-between align-items-center">
                                                    <input type="text" class="form-control form-control-lg fs-5"
                                                        // name="name"
                                                        // value={formData.name}
                                                        // onChange={handleChange}
                                                        // required
                                                        placeholder="Update topic here..." />
                                                </div>
                                                <hr />
                                                <div className='float-end'>
                                                    <button type="submit" data-mdb-button-init data-mdb-ripple-init className="btn btn-warning me-3">Update topic</button>
                                                    <button type="button" data-mdb-button-init data-mdb-ripple-init className="btn btn-secondary" onClick={handlerSetIsEditTopic}>Cancel</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                :
                <h1 className='text-center fw-bold p-4'>
                    {topic?.name}
                    <span data-mdb-tooltip-init title="Edit" onClick={handlerSetIsEditTopic}>
                        <i className="fas fa-pen-to-square fa-sm text-warning ms-3"></i>
                    </span>
                </h1>
            }
            <div>
                <div class="row d-flex justify-content-center align-items-center h-100 mb-4">
                    <div class="col">
                        <div id="list1">
                            <div class="card-body">
                                <form>
                                    <div class="pb-2">
                                        <div class="card">
                                            <div class="card-body">
                                                <div class="row d-flex justify-content-between align-items-center">
                                                    <input type="text" class="form-control form-control-lg fs-5"
                                                        // name="name"
                                                        // value={formData.name}
                                                        // onChange={handleChange}
                                                        // required
                                                        placeholder="Enter new question here..." />
                                                </div>
                                                <hr />
                                                <select className='form-select me-3 mt-3' style={{ width: "170px", height: "37px" }} name="difficulty" required> {/*value={formData.difficulty} onChange={handleChange} */}
                                                    <option value="">Select Difficulty</option>
                                                    <option value="EASY">EASY</option>
                                                    <option value="MEDIUM">MEDIUM</option>
                                                    <option value="HARD">HARD</option>
                                                </select>
                                                <div className='float-end'>
                                                    <button type="submit" data-mdb-button-init data-mdb-ripple-init className="btn btn-success">Add Question</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div>
                {topic?.questions?.map((item) => (
                    <QuestionCard key={item.id} question={item} />
                ))}
            </div>

        </div>
    )
}

export default TopicDetailsForm