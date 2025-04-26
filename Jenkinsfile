#!/usr/bin/env groovy

pipeline{
    agent any
    stages{

        stage("Version Increment"){
            steps{
                script{
                    echo "Incrementing Application Version..."
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'

                    // Now, capture the new version
                    def newVersion = sh(
                        script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout",
                        returnStdout: true
                    ).trim()
                    
                    echo "New version is: ${newVersion}"

                    // You can now use newVersion to tag your docker image
                    env.APP_VERSION = newVersion
                }
            }
        }
        stage("Build Jar File"){
            steps{
                script{
                    echo "Building the project..."
                    sh 'mvn clean package -DskipTests'
                }
            }
        }
       
        stage("Build Image"){
            steps{
                script{
                    echo "Building Docker image..."
                    withCredentials([usernamePassword(credentialsId:'dockerhub-credentials',passwordVariable: 'PASS',usernameVariable:'USER')]){
                        sh "docker build -t yashpatil16/myapp:${env.APP_VERSION} ."
                        sh "echo $PASS | docker login -u $USER -password-stdin"
                        sh "docker push yashpatil16/myapp:${env.APP_VERSION}"
    }
                }
                
            }
        }
        stage("Deploy"){
            steps{
                echo "Deploying the project..."
            }
        }
    }
}