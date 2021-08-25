def call(){
    pipeline {
        agent any

        stages{

            stage('Compile Package'){
                steps{
                    echo "Compile Package"
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