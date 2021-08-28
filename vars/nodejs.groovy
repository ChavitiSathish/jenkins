def call(String COMPONENT) {
  pipeline {
    agent any

    environment {
      SQ_TOKEN = credentials("SQ_TOKEN")
      SQ_LOGIN = credentials("SQ_LOGIN")
    }

    stages {
      stage('Find Bugs') {
        steps {
          script {
            bugs.check_bugs(COMPONENT, SQ_TOKEN, SQ_LOGIN_USR, SQ_LOGIN_PSW)
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

      stage('Publish Artifacts') {
        when { expression { sh([returnStdout: true, script: 'echo ${GIT_BRANCH} | grep tags || true' ]) } }
        steps {
          echo "Publish Artifacts"
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