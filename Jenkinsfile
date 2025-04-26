pipeline{
    agent any
    stages{
        stage("Build"){
            steps{
                echo "Building the project..."
            }
        }
        stage("Test"){
            when{
                expression { 
                     env.BRANCH_NAME == 'main' }
            }
            steps{
                echo "Running tests..."
            }
        }
        stage("Deploy"){
            steps{
                echo "Deploying the project..."
            }
        }
    }
}