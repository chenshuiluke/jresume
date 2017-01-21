node {
    stage('Build'){
        checkout scm
        sh 'mvn package'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
}
