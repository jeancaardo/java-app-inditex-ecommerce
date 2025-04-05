# run-sonar.ps1
$SONAR_TOKEN = "sqa_0e2b3a0aec2ac8d51f9f392e2ed60487e0937f8a"
$SONAR_HOST_URL = "http://host.docker.internal:9000"
$PROJECT_KEY = "java-app-inditex-ecommerce"

$projectDir = (Get-Location).Path

docker run --rm `
  -v "$($projectDir):/app" `
  -w /app `
  maven:3.9.6-eclipse-temurin-17 `
  mvn clean verify sonar:sonar `
    "-Dsonar.projectKey=$PROJECT_KEY" `
    "-Dsonar.host.url=$SONAR_HOST_URL" `
    "-Dsonar.login=$SONAR_TOKEN"