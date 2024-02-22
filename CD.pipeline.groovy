pipeline {
    agent any

    stages {
        stage('Run') {
            steps{
                echo "Running Image"
                sh returnStdout: true, script: "docker run --rm -d --name my-blazor-app -p 8089:8080 ${params.img} "
            }
        }
    }
}
