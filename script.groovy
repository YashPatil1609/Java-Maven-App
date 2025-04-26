#!/usr/bin/env groovy


def buildApp(){
    echo "Building the project..."
    sh 'mvn package' 
}
def buildImage(){
    echo "Building Docker image..."
    withCredentials([usernamePassword(credentialsId:'dockerhub-credentials',passwordVariable: 'PASS',usernameVariable:'USER')]){
        sh 'docker build -t yashpatil16/myapp:latest .'
        sh "echo $PASS docker login -u $USER -password-stdin"
        sh 'docker push yashpatil16/myapp:latest'
    }
}
def deployApp(){
    echo "Deploying the project..."
}
return this