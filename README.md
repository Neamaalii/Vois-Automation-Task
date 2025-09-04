This project is a Hybrid Test Automation Framework built using Java, Selenium WebDriver, TestNG, and Maven, following POM Design. The framework combines modular, reusable methods with data-driven testing to ensure scalability and maintainability. 
🔹 Project Structure 
Drivers → BrowserFactory & DriverManager for WebDriver initialization and browser handling.
Pages → Page Object Model classes with locators, actions, and validations. 
Utils → Helper classes for logs, configs, and reporting.
Listeners → Integrated with TestNG for report/log management.
Tests → Test scenarios implemented using TestNG. 
Resources → External test data ( test_data.json). 
🔹 Features:
Cross-browser support: Chrome, Edge, Firefox.
Parallel execution with TestNG and thread-safe WebDriver handling.
GitHub Actions integration for CI/CD automation.
Config-driven execution (browser type, headless mode, local/remote).
Allure Reports with screenshots for failures. 
Clean reporting: HTML report generation with detailed test steps.
