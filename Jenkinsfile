pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = 'my-blazor-app'
    }
    
    stages {
        stage('Build') {
            steps {
                script {
                    // Clean previous build artifacts
                    sh 'dotnet clean'
                    
                    // Restore NuGet packages
                    sh 'dotnet restore'
                    
                    // Build the application
                    sh 'dotnet build --configuration Release'
                }
            }
        }
        
        stage('Test') {
            steps {
                // You can add test steps here if applicable
            }
        }
        
        stage('Package') {
            steps {
                script {
                    // Publish the application
                    sh 'dotnet publish --no-build --configuration Release -o ./publish'
                    
                    // Copy Dockerfile to the publish directory
                    sh 'cp Dockerfile ./publish'
                }
            }
        }
        
        stage('Docker Build & Deploy') {
            steps {
                script {
                    // Remove existing Docker image
                    sh "docker rmi -f ${env.DOCKER_IMAGE} || true"
                    
                    // Build Docker image
                    docker.build(env.DOCKER_IMAGE, './publish')
                    
                    // Run Docker container
                    docker.image(env.DOCKER_IMAGE).withRun('-p 8080:80') {
                        // Container is running
                    }
                }
            }
        }
    }
    
    post {
        always {
            // Cleanup workspace
            cleanWs()
        }
    }
}
