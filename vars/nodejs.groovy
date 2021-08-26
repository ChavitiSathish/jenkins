def call() {
  pipeline {
    agent any

    stages {
      stage('Download NodeJS Dependencies') {
        steps {
          echo "Download NodeJS Dependencies"
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