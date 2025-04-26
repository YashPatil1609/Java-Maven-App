#!/usr/bin/env groovy

@Library ('Jenkins-Shared-Library')_

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
                    buildJar()
                }
            }
        }
        stage("Build Image"){
            steps{
                script{
                    buildImage()
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