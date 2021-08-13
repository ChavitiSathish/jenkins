pipeline{
    agent {
        //node {label  'Workstation'}
        //label 'JAVA'
        any
    }
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
}