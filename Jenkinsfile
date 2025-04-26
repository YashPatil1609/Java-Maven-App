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
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    env.IMAGE_VERSION = matcher[0][1]

                }
            }
        }
        stage("Build Jar File"){
            steps{
                script{
                    echo "Building the project..."
                    sh 'mvn clean package'
                }
            }
        }
       
        stage("Build Image"){
            steps{
                script{
                    echo "Building Docker image..."
                    withCredentials([usernamePassword(credentialsId:'dockerhub-credentials',passwordVariable: 'PASS',usernameVariable:'USER')]){
                        sh "docker build -t yashpatil16/myapp:${env.IMAGE_VERSION} ."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push yashpatil16/myapp:${env.IMAGE_VERSION}"
                        }
                }
                
            }
        }
        stage("Deploy"){
            steps{
                echo "Deploying the project..."
            }
        }
        stage("Commiting version update"){
            steps{
                script{
                    withCredentials([usernamePassword(credentialsId: 'github-PAT', usernameVariable: 'USER', passwordVariable: 'PASS')]){
                        sh 'git config --global user.email "jenkins@example.com"'
                        sh 'git config --global user.name "jenkins"'

                        sh 'git remote set-url origin https://${USER}:${PASS}@github.com/YashPatil1609/Java-Maven-App.git'

                
                        sh 'git add .'
                        sh 'git commit -m "Incremented application versions"'

                
                        sh 'git push origin HEAD:Version-Increment'
                    }
                }
            }
        }
        }
}