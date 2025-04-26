def gv
pipeline{
    agent any
    stages{
        stage("Initialize"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage("Build"){
            steps{
                script{
                    gv.buildApp()
                }
            }
        }
        stage("Build Image"){
            steps{
                script{
                    gv.buildImage()
                }
            }
        }
        stage("Deploy"){
            steps{
                script{
                    gv.deployApp()
                }
            }
        }
    }
}