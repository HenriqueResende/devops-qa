pipeline {
  agent any
  stages {
    stage("verify tooling") {
      steps {
        sh '''
          docker version
          docker info
          docker compose version 
          curl --version
          '''
      }
    }
    stage('Start container') {
      steps {
        sh 'docker compose -f docker-compose.stage.yml up -d --no-color --wait'
        sh 'docker compose -f docker-compose.stage.yml ps'
      }
    }
    stage('Wait for container') {
      steps {
        sh 'sleep 15'
      }
    }
    stage('Run tests against the container') {
      steps {
        script {
          def containerIds = sh(returnStdout: true, script: 'docker compose -f docker-compose.stage.yml ps -q').trim().split('\n')
          def desiredContainerId = containerIds[0] 
          sh "docker exec '${desiredContainerId}' curl http://localhost:9090"
        }
      }
    }
  }
  post {
    success {
      slackSend(color: '#36a64f', message: "Deployment to stage succeeded!", attachments: [
        [
          fallback: "Deploy to production",
          actions: [
            [
              type: 'button',
              text: 'Deploy to production',
              url: 'http://localhost:8080/view/AF%20-%20Arquitetura%20DEVOPS%20Funcional/job/Pipeline%20PRODU%C3%87%C3%83O/build?token=13b1c16cf1ad49a1b9d210313e41fb36',
              style: 'primary'
            ]
          ]
        ]
      ])
    }
    failure {
      slackSend color: '#ff0000', message: "Deployment to stage failed!"
    }
  }
}