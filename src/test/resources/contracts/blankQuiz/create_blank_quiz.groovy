package blankQuiz

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    inProgress()
    description "should create a blank quiz"

    request {
        url "/quizzes"
        method POST()
        headers {
            contentType applicationJson()
        }
        body(
                teacherId: $(consumer(regex('[a-zA-Z0-9]{36}'))),
                question: $(consumer(regex('.{1,255}'))),
                score: $(anyNumber()),
                referenceAnswer: $(consumer(regex('.{1,4000}')))
        )
    }

    response {
        status CREATED()
        headers {
            contentType applicationJson()
        }
        body(
                blankQuizId: $(producer(regex('[a-zA-Z0-9]{19}')), consumer('90fdknaf09fop5hmald'))
        )
    }
}