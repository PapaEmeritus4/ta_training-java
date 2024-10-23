# Swag Labs Login Test Automation
This project contains automated tests for the login functionality of the [Swag Labs](https://www.saucedemo.com/) application. The tests cover various user cases to ensure the robustness of the login form.
## Task Description
### User Cases
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

## Running Tests
### Maven Command for Regular Tests
To execute the standard tests, use the following command:
```bash
mvn -Dbrowser=chrome -Dtest=SwagLabsLoginTest -Denv=qa clean test
```
To execute the Cucumber tests, use the following command:
```bash
mvn -Dbrowser=chrome -Dtest=SwagLabsCucumberTestRunner -Denv=qa clean test
```

### Test Features
- **Parallel Execution**: Tests can be executed in parallel to speed up the testing process.
- **Logging**: Logging is implemented for better traceability and debugging of test execution.
- **Data Provider**: Parameterization of tests using Data Providers to facilitate various input scenarios.

# Running Optional Practices from WebDriver 4 Module
### Practice 1: Paste Creation Tests
To execute the Optional Practice 1 tests in the WebDriver module, you can use the following Maven command in the command line:

```bash
mvn -Dbrowser=chrome -Dtest=PasteCreationTests -Denv=qa clean test
```
### Practice 2: Paste V2 Creation Tests
To execute the Optional Practice 2 tests in the WebDriver module, you can use the following Maven command in the command line:

```bash
mvn -Dbrowser=chrome -Dtest=PasteV2CreationTests -Denv=qa clean test
```
### Practice 3: Google Cloud Calculator
To execute the Optional Practice 3 tests in the WebDriver module, you can use the following Maven command in the command line:

```bash
mvn -Dbrowser=chrome -Dtest=GoogleCloudPricingCalculatorTest -Denv=qa clean test
```
