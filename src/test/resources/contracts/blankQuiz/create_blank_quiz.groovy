package blankQuiz

import org.springframework.cloud.contract.spec.Contract

Contract.make {
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
                score: $(consumer(regex('100|[1-9][0-9]|[1-9]'))),
                referenceAnswer: $(consumer(regex('.{1,4000}')))
        )
    }

    response {
        status CREATED()
        headers {
            contentType applicationJson()
        }
        body(
                blankQuizId: $(producer(regex('[a-zA-Z-0-9]{36}')), consumer('8jk4lk-0d9ie-74jk-89lt8ikdj-6h50o8ij'))
        )
    }
}