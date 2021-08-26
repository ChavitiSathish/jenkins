def call() {
    pipeline {
        agent any

        stages {

            stage('Find Bugs') {
                steps {
                    echo "Find Bugs"
                }
            }

            stage('Test Cases') {
                steps {
                    echo "Test Cases"
                }
            }

        }
        post {
            always {
                cleanWs()
            }
        }
    }
}