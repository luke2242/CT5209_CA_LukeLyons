pipeline {
    agent any

    stages {

        stage('Get Code from Github') {
            steps {
                git branch: 'main', url: 'https://github.com/luke2242/CT5209_CA_LukeLyons.git'
            }
        }

        stage('Build') {
            steps {
                dir('CT5209_CA_LL') {
                    sh 'chmod +x ./mvnw && ./mvnw -B clean package -DskipTests'
                }
            }
        }

        stage('Test') {
            steps {
                dir('CT5209_CA_LL') {
                    sh 'chmod +x ./mvnw && ./mvnw -B test'
                }
            }
        }

        stage('Package and Archive WAR') {
            steps {
                dir('CT5209_CA_LL') {
                    sh 'mv target/CT5209_CA_LL-0.0.1-SNAPSHOT.war target/lukespetitions.war'
                }
                archiveArtifacts artifacts: 'CT5209_CA_LL/target/lukespetitions.war', fingerprint: true
            }
        }
    }
}
