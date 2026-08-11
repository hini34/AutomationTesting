# Selenium TestNG Hybrid Automation Framework

## Project Name

Selenium TestNG Hybrid Automation Framework

## Objective

In this project, I developed a Hybrid Automation Testing Framework using Selenium WebDriver, Java, TestNG, and Maven.

The main objective of this project was to automate web application test cases using a maintainable and reusable framework. The framework follows the Page Object Model (POM) design pattern and supports data-driven testing, reusable utility classes, configuration management, logging, screenshots on test failure, and HTML test reporting.

## Application Tested

- SauceDemo
- URL: https://www.saucedemo.com/

## Test Scenarios Automated

The following functional scenarios were automated for the SauceDemo application:

- User Login with valid credentials
- Login with invalid username
- Login with invalid password
- Login with invalid username and password
- Login with empty username
- Login with empty password
- Login with empty username and password
- Verify successful navigation to Products page after login
- Verify Products page and product listings
- Verify product details
- Add product to cart
- Add multiple products to cart
- Verify cart item count
- Verify cart contents
- Remove product from cart
- Verify cart after removing product
- Proceed to checkout
- Verify checkout information
- Enter customer information during checkout
- Verify checkout overview
- Verify order total
- Complete the checkout process
- Verify successful order completion
- Logout from the application

## Tools & Technologies Used

- Java 21
- Selenium WebDriver
- TestNG
- Maven
- Page Object Model (POM)
- Apache POI
- WebDriverManager
- Extent Reports
- Log4j2
- Eclipse IDE

## Framework Features

- Page Object Model (POM)
- Data-Driven Testing
- TestNG Annotations
- TestNG Groups
- TestNG Assertions
- TestNG Listeners
- Screenshot Capture on Test Failure
- Extent HTML Reports
- Log4j2 Logging
- Configuration Management
- Excel Test Data Handling
- Reusable Utility Classes

## TestNG Groups

Tests are categorized using TestNG groups:

- Smoke
- Sanity
- Regression
- Master

The Master group can be used to execute the complete test suite.

## Reporting

The framework generates an Extent HTML Report after test execution.

The report contains:

- Test Case Name
- Test Status
- Execution Time
- Pass/Fail Status
- Failure Details
- Screenshots for Failed Tests

## Key Benefits

- Reusable automation components
- Reduced code duplication
- Easy test maintenance
- Centralized configuration
- Data-driven test execution
- Automatic screenshots on failure
- Detailed HTML reports
- Easy CI/CD integration
- Scalable framework structure

## Conclusion

I successfully developed a Selenium-based Hybrid Automation Testing Framework using Java, Selenium WebDriver, TestNG, and Maven.

The framework follows the Page Object Model and integrates data-driven testing, reusable utilities, TestNG listeners, screenshots, Extent Reports, Log4j2 logging, and Maven execution.

This project helped me understand how to design and maintain a real-world Selenium automation framework and execute automated test cases efficiently.

## Created By

Hini Patel
