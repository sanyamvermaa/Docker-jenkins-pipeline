pipeline {
    agent any

    environment {
        IMAGE_NAME = "your_roll_number/simple-calculator-java"
        IMAGE_TAG = "${env.BUILD_NUMBER}"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Compile & Test Java') {
            steps {
                sh "javac Calculator.java CalculatorTest.java"
                sh "java -ea CalculatorTest"
            }
        }

        stage('Build Docker Image') {
            steps {
                sh "docker build -t ${IMAGE_NAME}:${IMAGE_TAG} ."
                sh "docker images"
            }
        }

        stage('Push to DockerHub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DH_USER', passwordVariable: 'DH_PASS')]) {
                    sh "echo ${DH_PASS} | docker login -u ${DH_USER} --password-stdin"
                    sh "docker tag ${IMAGE_NAME}:${IMAGE_TAG} ${DH_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
                    sh "docker push ${DH_USER}/${IMAGE_NAME}:${IMAGE_TAG}"
                }
            }
        }
    }

    post {
        success { echo "Pipeline Success!" }
        failure { echo "Pipeline Failed!" }
    }
}
