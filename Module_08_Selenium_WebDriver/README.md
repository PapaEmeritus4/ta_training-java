## [Module 08: Selenium WebDriver](https://learn.epam.com/myLearning/path?moduleId=17717763&rootId=17717751&tab=COURSEWARE)

The [task](https://github.com/PapaEmeritus4/ta_training-java/tree/main/Module_08_Selenium_WebDriver) involves writing TestNG [tests](https://github.com/PapaEmeritus4/ta_training-java/blob/main/Module_08_Selenium_WebDriver/src/test/java/com/epam/training/volodymyr_bilan/gmail/test/GmailTest.java) for Gmail automation using [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/). The tests cover the following functionalities:

- **Login validation** – verifying that the displayed user email matches the expected email after login.
- **Draft email creation and saving** – ensuring that a composed email with a recipient, subject, and message is correctly stored in the "Drafts" folder.
- **Email sending** – confirming that a sent email disappears from the "Drafts" folder and appears in the "Sent" folder.

The test suite follows **TestNG’s priority-based execution** to control test order and uses **log4j (Slf4j) logging** for detailed test reporting. Test data is managed via the **DataCreator** utility class, improving test maintainability.

### Running Tests
#### Maven Command for Regular Tests
To execute the standard tests, use the following command:
```bash
mvn -Dbrowser=chrome -Dtest=GmailTest -Denv=qa clean test
```
### Task Description
#### User Cases
- **UC-1**: Verify Successful Login
  **Preconditions:** User has valid email credentials.
    - Open the email login page.
    - Enter valid username and password.
    - Click the "Next" button.
    - Check that User is successfully logged in.

- **UC-2**: Verify Draft Mail Creation and Content
  **Preconditions:** User has valid email credentials.
    - Login.
    - Fill in the "To" field with a valid recipient email.
    - Enter a subject in the "Subject" field.
    - Type a message in the body of the email.
    - Click the "Save as Draft" button.
    - Check that the email is successfully saved in the "Drafts" folder.
    - Check that the recipient, subject, and body fields remain unchanged.

- **UC-3**: Verify Mail Sending and Folder Updates
  **Preconditions:** User has valid email credentials. The draft email is available in the "Drafts" folder.
    - Login.
    - Open the "Drafts" folder.
    - Select the saved draft email and click "Send".
    - Open the "Sent" folder.
    - Check that the email is successfully sent.
    - Check that the email is no longer present in the "Drafts" folder.
    - Check that the email appears in the "Sent" folder.