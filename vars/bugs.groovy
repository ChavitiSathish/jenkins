def check_bugs(String COMPONENT, String SQ_TOKEN, String SQ_LOGIN_USR, String SQ_LOGIN_PSW) {
    sh "sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.7.211:9000 -Dsonar.login=${SQ_TOKEN}"
    sh "sonar-quality-gate.sh ${SQ_LOGIN_USR} ${SQ_LOGIN_PSW} 172.31.7.211 ${COMPONENT}"
}

