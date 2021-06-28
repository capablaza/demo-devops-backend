pipeline {
    agent any
    stages {
        stage('Checkout'){
            steps{
                checkout scm
            }
        }
        stage('Clean images not used'){
            steps{
                catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
                    sh "make clean"
                }
            }
        }
        stage('Build Image') {
            steps {
                sh "make local"
            }
        }
        stage('Run Container'){
            steps {
                sh "make run"
            }
        }
    }
}