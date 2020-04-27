pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'bash ./gradlew build'
      }
    }

    stage('ProcessMod') {
      steps {
        sh 'mv build/libs/modid-1.0.jar build/libs/JosephCore.jar'
      }
    }

  }
}