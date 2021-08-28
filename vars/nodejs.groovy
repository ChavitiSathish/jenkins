def call(String COMPONENT) {
  pipeline {
    agent any

    stages {
      stage('Find Bugs') {
        steps {
          script {
            bugs.check_bugs(COMPONENT)
          }
        }
      }

      stage('Download NodeJS Dependencies') {
        steps {
          sh "npm install"
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