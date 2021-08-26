def check_bugs(String COMPONENT, String SQ_TOKEN, String SQ_LOGIN_USR, String SQ_LOGIN_PSW) {
    if (COMPONENT == "shipping") {
        sh "sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.java.binaries=./target -Dsonar.host.url=http://172.31.14.43:9000 -Dsonar.login=${SQ_TOKEN}"
    }
    else {
        sh "sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.14.43:9000 -Dsonar.login=${SQ_TOKEN}"
    }

    sh "sonar-quality-gate.sh ${SQ_LOGIN_USR} ${SQ_LOGIN_PSW} 172.31.14.43 ${COMPONENT}"
}
