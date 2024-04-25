

const AnswerCard = ({ answer }) => {
    return (
        <div className={answer?.correct ? "bg-success bg-opacity-10 p-2 hover-answer-card mt-3 rounded-3" : "bg-danger bg-opacity-10 p-2 hover-answer-card mt-3 rounded-3"}>
            <div className="d-flex justify-content-between">
                <p className="mt-3 ms-3">{answer?.content}</p>
                <div className="d-flex flex-row">
                    {answer?.correct ? <i class="fa-solid fa-check text-success mt-4 me-3"></i> : <i class="fa-solid fa-xmark text-danger mt-4 me-3"></i>}
                    <span className="mt-3 me-3 delete-button" data-mdb-tooltip-init title="Remove"><i
                        className="fas fa-trash-alt fa-lg text-danger"></i>
                    </span>
                </div>
            </div>
        </div>
    )
}

export default AnswerCard