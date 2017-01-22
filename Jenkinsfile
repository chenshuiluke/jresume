node {
    stage('Build'){
        checkout scm
        sh 'mvn package'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
    stage('Deploy'){
        sh 'chmod +x jenkins_redeploy_script.sh'
        sh './jenkins_redeploy_script.sh'
    }
}
