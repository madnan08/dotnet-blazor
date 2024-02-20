pipeline {
    agent any
    tools {
        maven 'MAVEN'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/abubakar1o/dotnet-blazor.git'
                sh 'ls -la'
            }
        }
        stage('Stop running Container') {
            steps{
              sh returnStatus: true, script: 'docker stop $(docker ps -a | grep my-blazor-app | awk \'{print $1}\')'
              sh returnStatus: true, script: 'docker rmi $(docker images | grep my-blazor-app | awk \'{print $3}\')'
              sh returnStatus: true, script: 'docker rm my-blazor-app'
            }
        }
        stage('Build') {
            steps{
                echo "Building image"
                script {
                    dockerImg = docker.build("${params.img}")
                }
            }
        }
        stage('Run') {
            steps{
                echo "Running Image"
                sh returnStdout: true, script: "docker run --rm -d --name my-blazor-app -p 8089:8080 ${params.img} "
            }
        }
    }
}