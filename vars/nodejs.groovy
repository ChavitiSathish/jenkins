def call() {
    pipeline {
    agent any

    stages {

      stage('Find Bugs') {
        steps {
          echo "Test Cases"
        }
      }

      stage('Download NodeJS Dependencies') {
        steps {
          echo "Download Dependencies"
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