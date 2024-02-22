pipeline {
    agent any
    
    environment {
        PATH = "/usr/bin/dotnet:$PATH"
        DOTNET_VERSION = "8.0"
        DOTNET_RUNTIME = "net${DOTNET_VERSION}"
        APP_NAME = "BlazorApp1"
        BUILD_CONFIGURATION = "Release"
        DOTNET_PATH = "/home/abubakar/java/dot-net/dotnet-blazor/BlazorApp1/bin/${BUILD_CONFIGURATION}/${DOTNET_RUNTIME}"
    }
    
    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the repository
                git branch: 'main', url: 'https://github.com/abubakar1o/dotnet-blazor.git'
            }
        }
        
        stage('Restore') {
            steps {
                // Restore NuGet packages
                bat "dotnet restore ${APP_NAME}"
            }
        }
        
        stage('Build') {
            steps {
                // Build the application
                bat "dotnet build ${APP_NAME} --configuration ${BUILD_CONFIGURATION}"
            }
        }
        
        stage('Test') {
            steps {
                // Run tests if applicable
                bat "dotnet test ${APP_NAME}"
            }
        }
        
        stage('Publish') {
            steps {
                // Publish the application
                bat "dotnet publish ${APP_NAME} --configuration ${BUILD_CONFIGURATION} --output ${DOTNET_PATH}"
            }
        }
        
        stage('Run Application') {
            steps {
                // Run the application
                bat "dotnet ${DOTNET_PATH}/${APP_NAME}.dll"
            }
        }
    }
}
