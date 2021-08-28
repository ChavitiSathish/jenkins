def check_bugs() {
    sh "sonar-scanner -Dsonar.projectKey=cart -Dsonar.sources=. -Dsonar.host.url=http://172.31.7.211:9000 -Dsonar.login=46fec8bc4f8d4830274640ba75d38ddd7f0cdf15"
}