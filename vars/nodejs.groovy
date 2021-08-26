def call(){
  pipeline {
    agent any
    stages {
      stage('Download NodeJs Dependencies') {
        steps {
          echo "Download Dependencies"
        }
      }
    }
  }
}

