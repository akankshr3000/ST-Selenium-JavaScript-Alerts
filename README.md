# Roll No. 6 — Selenium JavaScript Alerts, Confirms and Prompts

**Course:** Software Testing (22CS72)  
**Project title:** Design a Selenium Solution to Handle JavaScript Alerts, Confirms and Prompts

## Prerequisites
- JDK 17 or newer
- Maven 3.8+
- Google Chrome installed
- VS Code with Extension Pack for Java (recommended)

Selenium Manager (bundled with modern Selenium) normally resolves the compatible browser driver automatically. The first run needs internet access to download Maven dependencies and, if needed, the driver.

## Run in VS Code
1. Extract the ZIP and open the `Roll6_Selenium_JavaScript_Alerts_Project` folder in VS Code.
2. Open Terminal → New Terminal.
3. Check `java -version` and `mvn -version`.
4. Run `mvn clean test`.
5. View the TestNG/Surefire XML and text reports under `target/surefire-reports/`.

If Maven is not installed, install it or use a Maven wrapper added by your environment. Do not report tests as passed until the command has completed successfully.

## Test cases
- TC01: Accept alert and verify text.
- TC02: Accept confirmation and verify the OK branch.
- TC03: Dismiss confirmation and verify the Cancel branch.
- TC04: Enter `Student 6` into prompt and verify output.
- TC05: Cancel prompt and verify cancellation output.

## GitHub
Create a repository, then run:
```bash
git init
git add .
git commit -m "Add Selenium JavaScript dialog automation"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/YOUR-REPOSITORY.git
git push -u origin main
```
Replace the remote URL with your own repository URL.

## Jenkins
Jenkins is not installed on the user's machine yet. The included `Jenkinsfile` is a starter pipeline, not proof of a completed Jenkins run. After installing/configuring Jenkins:
1. Configure JDK tool name `JDK17` and Maven tool name `Maven3`, or edit the Jenkinsfile to match your configured names.
2. Ensure the Jenkins agent has Chrome and a graphical display (or configure headless Chrome).
3. Create a Pipeline job linked to the GitHub repository and select “Pipeline script from SCM”.
4. Run the job and save genuine console output and test report screenshots for the report.

For a Linux/headless Jenkins agent, add `options.addArguments("--headless=new");` and optionally `options.addArguments("--no-sandbox");` to ChromeOptions, following your lab's environment rules.
