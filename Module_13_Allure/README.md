#### Gradle tasks for Regular Tests
To execute the standard tests, use the following command:
```bash
gradle -Dbrowser=chrome -Denv=qa test
```
To generate the standard Allure report, use the following command:
```bash
gradle allureReport
```