def call() {
    pipeline {
        agent any

        stages {
            stage('Compile Package') {
                steps {
                    sh "mvn clean package"
                }
            }

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