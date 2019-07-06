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
        sh 'eval $(docker-machine env bienvm1)'
      }
    }
  }
}