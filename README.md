# Java Maven CI/CD Application 🚀 (Version Increment Branch)

This branch also contains the **Java Maven application**, but with a specialized focus on **automatic version management** as part of the CI/CD workflow.

---

## ✨ Application Description
A Java Maven application, intended to demonstrate advanced CI/CD operations including automated version bumping, Docker image creation, pushing to DockerHub, and automated Git version updates.

---

## 🛠️ CI/CD Pipeline Overview

The Jenkins pipeline here includes the following key stages:

### 1. Version Increment
- Automatically increments the application version inside the `pom.xml`.
- Uses Maven's `build-helper:parse-version` and `versions:set` plugins.
- Captures the newly updated version from `pom.xml` and saves it in the environment variable `IMAGE_VERSION`.

### 2. Build Jar File
- Builds the project using Maven:mvn clean package
- Produces a `.jar` file ready for deployment.

### 3. Build Docker Image
- Builds a Docker image tagged with the newly incremented version: docker build -t yashpatil16/myapp:${IMAGE_VERSION} .
- Authenticates securely to DockerHub and pushes the built image.

### 4. Deploy
- Placeholder stage where the Docker image can be deployed to a cloud platform like AWS ECS, Kubernetes, etc.
- Currently left as a stub for future deployment expansion.

### 5. Commit Version Update
- Configures Git with a user and email.
- Stages all changes (specifically the updated `pom.xml`).
- Commits the changes with a meaningful message: `"Incremented application versions"`.
- Pushes the commit to the remote repository's `Version-Increment` branch using a GitHub Personal Access Token (PAT) for authentication.

---

## 🌟 Why This Setup Matters

- Ensures **automatic and consistent versioning** with every CI/CD cycle.
- Makes deployments **traceable** and **reproducible**.
- Reduces human errors and makes the pipeline **fully autonomous**.
- Prepares the application for **production-grade** release workflows.

---

Thanks for exploring this branch! 🌸 Dive in and experience seamless automated version management with Jenkins and Maven.
