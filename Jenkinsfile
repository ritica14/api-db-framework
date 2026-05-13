pipeline {

    agent any

    tools {
        maven 'Maven'
    }

    stages {

        stage('Checkout Code') {
            steps {
                   git branch: 'main',
                       url : 'https://github.com/Ritica14/API-DB-Framework.git'
            }
        }

        stage('Build & Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {

        always {
               publishHTML([
                               allowMissing: false,
                               alwaysLinkToLastBuild: true,
                               keepAll: true,
                               reportDir: 'reports',
                               reportFiles: 'extent-report.html',
                               reportName: 'Extent Report'
                           ])

                           junit 'test-output/testng-results.xml'

            echo 'Execution Completed'
        }

        success {
            echo 'Build Successful'
        }

        failure {
            echo 'Build Failed'
        }
    }
}