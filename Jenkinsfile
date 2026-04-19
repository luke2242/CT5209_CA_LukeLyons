pipeline {
    agent any

    tools {
        jdk 'jdk17'          
        maven 'maven3'       
    }

    stages {

        stage('Get Code from Github') {
            steps {
                git branch: 'main', url: 'https://github.com/luke2242/CT5209_CA_LukeLyons.git'
            }
        }

        stage('Build') {
            steps {
                dir('CT5209_CA_LL') {
                    sh 'mvn clean package -DskipTests'
                }
            }
        }

        stage('Test') {
            steps {
                dir('CT5209_CA_LL') {
                    sh 'mvn test'
                }
            }
        }

        stage('Package and Archive WAR') {
            steps {
                dir('CT5209_CA_LL') {
                    sh 'ls -la target/*.war'
                    sh 'mv target/*.war target/lukespetitions.war'
                    archiveArtifacts artifacts: 'target/lukespetitions.war', fingerprint: true
                }
            }
        }
    }
}
