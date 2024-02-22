pipeline {
    agent any
    
    environment {
        DOTNET_VERSION = "8.0"
        DOTNET_RUNTIME = "net${DOTNET_VERSION}"
        APP_NAME = "BlazorApp1"
        BUILD_CONFIGURATION = "Release"
        DOTNET_PATH = "/home/abubakar/java/dot-net/dotnet-blazor/${APP_NAME}/bin/${BUILD_CONFIGURATION}/${DOTNET_RUNTIME}"
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the repository
                git branch: 'main', url: 'https://github.com/your-repo-url.git'
            }
        }
        
        stage('Restore') {
            steps {
                // Restore NuGet packages
                sh "dotnet restore ${APP_NAME}"
            }
        }
        
        stage('Build') {
            steps {
                // Build the application
                sh "dotnet build ${APP_NAME} --configuration ${BUILD_CONFIGURATION}"
            }
        }
        
        stage('Test') {
            steps {
                // Run tests if applicable
                // Example: sh "dotnet test ${APP_NAME}"
            }
        }
        
        stage('Publish') {
            steps {
                // Publish the application
                sh "dotnet publish ${APP_NAME} --configuration ${BUILD_CONFIGURATION} --output ${DOTNET_PATH}"
            }
        }
        
        stage('Run Application') {
            steps {
                // Run the application
                sh "dotnet ${DOTNET_PATH}/${APP_NAME}.dll"
            }
        }
    }
}
