# EPAM Hometasks:
## [Module 06 Unit testing](https://learn.epam.com/myLearning/path?moduleId=17717761&rootId=17717751)
The [task](https://github.com/PapaEmeritus4/ta_training-java/tree/main/Module_06_Unit_Testing) involves writing JUnit 5 [tests](https://github.com/PapaEmeritus4/ta_training-java/blob/main/Module_06_Unit_Testing/src/test/java/com/epam/training/volodymyr_bilan/CalculatorTest.java) for a [Calculator class](https://github.com/PapaEmeritus4/ta_training-java/blob/main/Module_06_Unit_Testing/src/main/java/com/epam/training/volodymyr_bilan/Calculator.java), covering addition, subtraction, multiplication, division, and modulus operations. It includes parameterized tests using @CsvSource, and configuring tests to run in [parallel](https://github.com/PapaEmeritus4/ta_training-java/blob/main/Module_06_Unit_Testing/src/test/resources/junit-platform.properties) for improved performance. Pre- and post-conditions are managed with @BeforeAll and @AfterAll annotations.
## Swag Labs Login Test Automation
This project contains automated tests for the login functionality of the [Swag Labs](https://www.saucedemo.com/) application. The tests cover various user cases to ensure the robustness of the login form.
### Running Tests
#### Maven Command for Regular Tests
To execute the standard tests, use the following command:
```bash
mvn -Dbrowser=edge -Dtest=SwagLabsLoginTest -Denv=qa clean test
```
To execute the BDD tests, use the following command:
```bash
mvn -Dbrowser=edge -Dtest=SwagLabsCucumberTestRunner -Denv=qa clean test
```
### Task Description
#### User Cases
- **UC-1**: Test Login form with empty credentials
  - Type any credentials into the "Username" and "Password" fields.
  - Clear the inputs.
  - Hit the "Login" button.
  - Check the error message: "Username is required".

- **UC-2**: Test Login form with credentials by passing Username
  - Type any credentials in the username field.
  - Enter a password.
  - Clear the "Password" input.
  - Hit the "Login" button.
  - Check the error message: "Password is required".

- **UC-3**: Test Login form with valid Username & Password
  - Type valid credentials in the username field (e.g., "standard_user").
  - Enter the password "secret_sauce".
  - Click on "Login" and validate the title “Swag Labs” in the dashboard.

#### Test Features
- **Parallel Execution**: Tests can be executed in parallel to speed up the testing process.
- **Logging**: Logging is implemented for better traceability and debugging of test execution.
- **Data Provider**: Parameterization of tests using Data Providers to facilitate various input scenarios.

## Running Optional Practices from WebDriver 4 Module
#### Practice 1: Paste Creation Tests
To execute the Optional Practice 1 tests in the WebDriver module, you can use the following Maven command in the command line:

```bash
mvn -Dbrowser=chrome -Dtest=PasteCreationTests -Denv=qa clean test
```
#### Practice 2: Paste V2 Creation Tests
To execute the Optional Practice 2 tests in the WebDriver module, you can use the following Maven command in the command line:

```bash
mvn -Dbrowser=chrome -Dtest=PasteV2CreationTests -Denv=qa clean test
```
#### Practice 3: Google Cloud Calculator
To execute the Optional Practice 3 tests in the WebDriver module, you can use the following Maven command in the command line:

```bash
mvn -Dbrowser=chrome -Dtest=GoogleCloudPricingCalculatorTest -Denv=qa clean test
```
