def check_bugs(String COMPONENT) {
    sh "sonar-scanner -Dsonar.projectKey=${COMPONENT} -Dsonar.sources=. -Dsonar.host.url=http://172.31.7.211:9000 -Dsonar.login=46fec8bc4f8d4830274640ba75d38ddd7f0cdf15"
    sh "sonar-quality-gate.sh admin123 admin123 172.31.7.211 ${COMPONENT}"
}