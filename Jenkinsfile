/*pipeline{
    //agent {
        //node {label  'Workstation'}
        //label 'JAVA'
    //}

    agent none
    stages{
        stage('Master Node'){
            agent {
               label 'MASTER'
            }
            steps{
              sh 'echo Hello'
            }
        }

        stage('Workstation'){
           agent {
               label 'JAVA'
           }
             steps{
               sh 'echo Hello'
             }
        }
    }
}*/

pipeline{
    agent any

    environment {
        DEMO_URL = "google.com"
    }

    stages{
        stage('ONE'){
            environment {
               DEMO_URL = "yahoo.com"
            }
            steps{
            sh 'echo ${DEMO_URL}'
            }
        }
    }
}