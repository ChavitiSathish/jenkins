pipeline{
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
}