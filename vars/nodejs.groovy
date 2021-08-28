def call(String COMPONENT) {
  pipeline {
    agent any

    environment {
      SQ_TOKEN = credentials("SQ_TOKEN")
      SQ_LOGIN = credentials("SQ_LOGIN")
      NEXUS    = credentials("NEXUS")
    }

    stages {
      stage('Find Bugs') {
        steps {
          script {
            print "Ok"
            //bugs.check_bugs(COMPONENT, SQ_TOKEN, SQ_LOGIN_USR, SQ_LOGIN_PSW)
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
          sh """
            gitTag=`echo ${GIT_BRANCH} | awk -F / '{print \$NF}'`
            zip -r ${COMPONENT}-\${gitTag}.zip node_modules server.js
            curl -v -u ${NEXUS} --upload-file ${COMPONENT}-\\\\${gitTag}.zip http://172.31.15.198:8081/repository/${COMPONENT}/${COMPONENT}-\\\\${gitTag}.zip 
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