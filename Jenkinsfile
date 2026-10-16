pipeline {
    agent any
    tools {
        // Configure a JDK and Maven installation with these names in Jenkins Global Tool Configuration.
        jdk 'JDK21'
        maven 'Maven3'
    }
    stages {
        stage('Checkout') {
            steps { checkout scm }
        }
        stage('Run Selenium tests') {
            steps { bat 'mvn -B clean test' }
        }
    }  
    post {
        always { 
            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'
        }
    }
}
