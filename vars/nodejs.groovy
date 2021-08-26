def call() {
  pipeline {
    agent any

    stages {
      stage('Download NodeJS Dependencies') {
        steps {
          sh "sudo npm install -g"
        }
      }

      stage('Find Bugs') {
        steps {
          script {
            bugs.check_bugs()
          }
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