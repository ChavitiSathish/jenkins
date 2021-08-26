def call(){
  pipeline {
    agent any
      stages{

        stage('Download NodeJs Dependencies'){
          steps{
            echo "Download Dependencies"
          }
        }

        stage('Find Bugs'){
          steps{
            echo "Find Bugs"
          }
        }

        stage('Test Cases'){
          steps{
            echo "Test Cases"
          }
        }
      }
  }
}