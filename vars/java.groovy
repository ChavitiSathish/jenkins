def call(String COMPONENT) {
    pipeline {
      agent any

      environment {
        SQ_TOKEN = credentials("SQ_TOKEN")
        SQ_LOGIN = credentials("SQ_LOGIN")
      }

      stages {
        stage('Compile Package') {
          steps {
            sh "mvn clean package"
          }
        }
        stage('Find Bugs') {
          steps {
            script {
              print "Ok"
              //bugs.check_bugs(COMPONENT, SQ_TOKEN, SQ_LOGIN_USR, SQ_LOGIN_PSW)
            }
          }
        }

        stage('Test Cases') {
          steps {
            echo "Test Cases"
          }
        }

        stage('Publish Artifacts') {
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