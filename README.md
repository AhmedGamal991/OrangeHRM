
# OrangeHRM Automation Testing Project

This project automates the testing of the OrangeHRM website using Selenium with Java, Cucumber, and TestNG. The project follows the Page Object Model (POM) design pattern to maintain a clear structure and improve code reusability and readability.

## Project Structure

```
├── src
│   ├── main
│   │   ├── java
│   │   │   └── pages
│   │   │       ├── LoginPage.java
│   │   │       ├── HomePage.java
│   │   │       └── AdminPage.java
│   │   └── resources
│   └── test
│       ├── java
│       │   └── stepDefinitions
│       │       └── AdminSteps.java
│       └── resources
│           └── features
│               └── End2End_Tests.feature
├── pom.xml
└── README.md
```

## Getting Started

### Prerequisites

- **Java Development Kit (JDK)**: Ensure that you have JDK 8 or later installed.
- **Maven**: Apache Maven is required for managing project dependencies.
- **IDE**: Use an IDE like Eclipse or IntelliJ IDEA for development.
- **Google Chrome Browser**: Required for Selenium WebDriver to run tests.

### Installation

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/AhmedGamal991/OrangeHRM.git
   ```

2. Import the project into your IDE as a Maven project.

3. Update the `pom.xml` file to ensure all dependencies are up-to-date:
   ```xml
   <!-- Selenium, Cucumber, and TestNG dependencies -->
   <dependencies>
       <dependency>
           <groupId>org.seleniumhq.selenium</groupId>
           <artifactId>selenium-java</artifactId>
           <version>4.17.0</version>
       </dependency>
       <dependency>
           <groupId>io.cucumber</groupId>
           <artifactId>cucumber-java</artifactId>
           <version>7.18.1</version>
       </dependency>
       <dependency>
           <groupId>io.cucumber</groupId>
           <artifactId>cucumber-testng</artifactId>
           <version>718.1</version>
       </dependency>
       <dependency>
           <groupId>org.testng</groupId>
           <artifactId>testng</artifactId>
           <version>7.10.2</version>
           <scope>test</scope>
       </dependency>
   </dependencies>
   ```

4. Update the WebDriver binaries using WebDriverManager (if required):
   ```java
   WebDriverManager.chromedriver().setup();
   ```

### Running the Tests

1. **Run from IDE**: Right-click on the `End2End_Tests.feature` file or the `AdminSteps.java` file and select `Run As > Cucumber Test`.
2. **Run from IDE**: Right-click on the `TestRunner` file or the `AdminSteps.java` file and select `Run As > testNG Test`. 
3. **Run from Command Line**:
   ```bash
   mvn clean test
   ```

### Scenarios Covered

#### 1. **Add a New User**
- Navigate to OrangeHRM login page.
- Enter valid credentials.
- Click on the Admin tab.
- Get the initial number of records.
- Click on the 'Add' button and fill in user details.

#### 2. **Delete the Newly Added User**
- Navigate to OrangeHRM login page.
- Enter valid credentials.
- Click on the Admin tab.
- Search for the newly added user.

### Project Components

- **Page Objects (POM)**: Classes representing different pages on the OrangeHRM site:
  - `LoginPage.java`: Handles login-related actions.
  - `HomePage.java`: Represents the home/dashboard page.
  - `AdminPage.java`: Contains methods for user management functionalities.

- **Step Definitions**: 
  - `AdminSteps.java`: Step definitions matching the Gherkin scenarios in the feature file.

- **Feature File**: 
  - `End2End_Tests.feature`: Contains Gherkin scenarios for end-to-end testing of user management functionalities.

- **RUUNER File**: 
  - `TestRunner.java`: Contains Test RUUNER testing of user management functionalities.


### Troubleshooting

- **No Such Element Exception**: Ensure that element locators in the POM classes are up-to-date and accurate.
- **WebDriver Errors**: Verify that you have the correct version of ChromeDriver matching your browser version.
- **Maven Dependency Issues**: Run `mvn clean install` to resolve any missing dependencies.

