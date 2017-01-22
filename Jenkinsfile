node {
    stage('Build'){
        checkout scm
        sh 'mvn package'
        archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
    stage('Deploy'){
        sh 'pkill -f jresume-1.0-SNAPSHOT-jar-with-dependencies.jar'
        sh 'cd target'
        sh 'java -jar jresume-1.0-SNAPSHOT-jar-with-dependencies.jar &'
    }
}
