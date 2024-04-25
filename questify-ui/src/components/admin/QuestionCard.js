import { useState } from "react";
import AnswerCard from "./AnswerCard";


const QuestionCard = ({ question }) => {
    const [isAddNewQuestion, setIsAddNewQuestion] = useState(false)

    const handlerSetIsAddNewQuestion = () => {
        setIsAddNewQuestion(current => !current)
    }

    function handleUpdateQuestion() {
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
            <div class="card mt-2 mb-5 hover-card">
                <div class="card-header fw-bold">
                    <div className="d-flex justify-content-between">
                        <div>
                            <span className="ms-2 fs-4">{question?.content}</span>
                            <span className="badge bg-primary ms-3 mb-2">{question?.difficulty}</span>
                        </div>
                        <div className="hide-update mt-2">
                            <span onClick={handlerSetIsAddNewQuestion} className="mt-2 me-3" data-mdb-tooltip-init title="Add new answer">
                                {isAddNewQuestion ? <i class="fas fa-xmark fa-lg text-danger"></i> : <i className="fas fa-plus fa-lg text-success"></i>}
                            </span>
                            <span onClick={() => handleUpdateQuestion()} className="mt-2 me-3" data-mdb-tooltip-init title="Edit question"><i
                                className="fas fa-pen-to-square fa-lg text-warning"></i>
                            </span>
                            <span className="mt-2 me-3" data-mdb-tooltip-init title="Remove question"><i
                                className="fas fa-trash-alt fa-lg text-danger"></i>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    {isAddNewQuestion ?
                        <div>
                            <div class="row d-flex justify-content-center align-items-center h-100">
                                <div class="col">
                                    <div id="list1">
                                        <form>
                                            <div class="pb-2">
                                                <div class="card">
                                                    <div class="card-body">
                                                        <div class="row d-flex justify-content-between align-items-center">
                                                            <input type="text" class="form-control form-control-lg fs-5"
                                                                // name="name"
                                                                // value={formData.name}
                                                                // onChange={handleChange}
                                                                required
                                                                placeholder="Enter new answer here..." />
                                                        </div>
                                                        <hr />
                                                        <div class="form-check">
                                                            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault"/>
                                                            <label class="form-check-label" for="flexCheckDefault">
                                                                Correct answer
                                                            </label>
                                                        </div>
                                                        <div className='float-end'>
                                                            <button type="submit" data-mdb-button-init data-mdb-ripple-init className="btn btn-success">Add Answer</button>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                        : ""}
                    <div>
                        {question?.answer.map((answer) => (
                            <AnswerCard key={answer.id} answer={answer} />
                        ))}
                    </div>

                </div>
            </div>
        </div>
    )
}

export default QuestionCard;