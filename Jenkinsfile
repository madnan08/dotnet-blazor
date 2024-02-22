pipeline {
    agent any
    
    environment {
        DOTNET_VERSION = "8.0"
        DOTNET_RUNTIME = "net${DOTNET_VERSION}"
        APP_NAME = "BlazorApp1"
        BUILD_CONFIGURATION = "Release"
        DOTNET_PATH = "/home/abubakar/java/dot-net/dotnet-blazor/BlazorApp1/bin/Release/net8.0"
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
                sh "dotnet restore ${APP_NAME}"
            }
        }
        
        stage('Build') {
            steps {
                // Build the application
                dotnetBuild project: '/home/abubakar/java/dot-net/dotnet-blazor/BlazorApp1/bin/Release/net8.0', sdk: 'dotnet'
            }
        }
        
        stage('Test') {
            steps {
                // Run tests if applicable
               sh "dotnet test ${APP_NAME}"
            }
        }
        
        stage('Publish') {
            steps {
                // Publish the application
                dotnetNuGetPush root: '/home/abubakar/java/dot-net/dotnet-blazor/BlazorApp1/bin/Release/net8.0', sdk: 'dotnet', source: 'https://api.nuget.org/v3/index.json'
            }
        }
        
        stage('Run Application') {
            steps {
                // Run the application
                dotnet ${APP_NAME}.dll
            }
        }
    }
}
