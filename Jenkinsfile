pipeline {
/*
  agent {
    docker {
      image 'maven:3-alpine'
      args '-v "$HOME"/.m2:/root/.m2'
    }
  }
/*
  tools {
    maven 'mvn-3.5.2'
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
        sh 'docker build -t simple-web .'
      }
    }
  }
}