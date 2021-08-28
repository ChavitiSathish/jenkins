def call(String COMPONENT) {
    pipeline {
      agent any

      environment {
        SQ_TOKEN = credentials("SQ_TOKEN")
        SQ_LOGIN = credentials("SQ_LOGIN")
        NEXUS    = credentials("NEXUS")
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
          when { expression { sh([returnStdout: true, script: 'echo ${GIT_BRANCH} | grep tags || true' ]) } }
          steps {
            sh """
            gitTag=`echo ${GIT_BRANCH} | awk -F / '{print \$NF}'`
            cp target/*.jar ${COMPONENT}.jar
            zip -r ${COMPONENT}-\${gitTag}.zip ${COMPONENT}.jar
          """
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