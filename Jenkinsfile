pipeline {
  agent any
  tools {
    maven 'M3'
  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }
    stage('Test') {
      steps {
        sh 'mvn test'
      }
      post {
        always {
          junit 'target/surefire-reports/*.xml'
        }
      }
    }
    stage('Package') {
      steps {
        sh 'mvn package'
      }
    }
    stage('Publish') {
      steps {
        sh 'docker build -t 192.168.1.7:5000/simple-web .'
        sh 'docker push 192.168.1.7:5000/simple-web'
      }
    }
    stage('Production') {
      steps {
          withEnv([
            "DOCKER_TLS_VERIFY=0",
            "DOCKER_HOST=tcp://192.168.99.100:2376",
            "DOCKER_CERT_PATH=/home/bienbenigno/.docker/machine/machines/bienvm1"
          ]) {
            sh "docker ps"
          }
      }
    }
  }
}