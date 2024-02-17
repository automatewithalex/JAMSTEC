# JAMSTEC: Java Automation Framework with Selenium, TestNG, and Cucumber

## Overview

JAMSTEC is a robust, scalable, and easy-to-use automation framework designed for web application testing. Built with Java, it leverages the power of Selenium for browser automation, TestNG for the testing framework, and Cucumber for Behavior-Driven Development (BDD), enabling seamless integration of development and testing through readable specifications.

## Features

- **Selenium WebDriver Integration**: Automate web browser interaction with support for multiple browsers.
- **TestNG for Test Management**: Utilize TestNG's powerful testing capabilities, including grouping, sequencing, and parametrization of tests.
- **Cucumber for BDD**: Write human-readable test scenarios in Gherkin language to bridge the gap between technical and non-technical team members.
- **Parallel Execution**: Speed up testing with built-in support for running tests in parallel.
- **Modular Design**: Easy to extend and maintain, promoting reusable components and clean code structure.

## Getting Started

### Prerequisites

- Java JDK 8 or newer
- Maven for managing project dependencies and running tests
- WebDriver executables for the browsers you intend to test with

### Installation

1. Clone the repository: `git clone https://github.com/automatewithalex/JAMSTEC.git`
2. Navigate to the project directory: `cd JAMSTEC`
3. Install dependencies: `mvn install`

### Running Tests

Execute all tests using Maven: `mvn test`
To run specific tests, use the `-Dtest` flag with Maven: `mvn test -Dtest=YourTestClass`

### Configuring TestNG and Cucumber

- TestNG configuration is managed through the `testng.xml` file, where you can define your test suites, groups, and parameters.
- Cucumber scenarios are located in the `src/test/resources/features` directory. Customize your feature files here.

## Contributing

Contributions are welcome! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -am 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a Pull Request.

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Contact

Aleksandar Stojanovic - https://www.automatewithalex.com/

Project Link: https://github.com/automatewithalex/JAMSTEC
