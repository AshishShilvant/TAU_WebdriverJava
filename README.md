# Selenium WebDriver Java Automation Framework

A Selenium / Java / TestNG / Maven test automation framework built with **Page Object Model (POM)** architecture, data-driven test support via Excel utilities, and modular reporting.

![Java](https://img.shields.io/badge/Java-11+-ED8B00?logo=java)
![Selenium](https://img.shields.io/badge/Selenium-4.x-43B02A?logo=selenium)
![TestNG](https://img.shields.io/badge/TestNG-7.x-FF6C37)
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?logo=apachemaven)

---

## What This Demonstrates

| Pattern | Implementation |
|---|---|
| **Page Object Model** | Page classes in `src/main/java/pages` — UI interactions separated from test logic |
| **Utility layer** | `src/main/java/utils` — reusable helpers including Excel data reader |
| **Data-driven testing** | Test data loaded from Excel via utility class — tests run across multiple data sets without code changes |
| **TestNG suite config** | `testng.xml` — controls test grouping, parallel execution, and suite-level setup |
| **Maven standard layout** | Standard `src/main/java` + `src/test/java` structure — builds and runs with a single `mvn test` |
| **Modular reporting** | Test output in `test-output/` — TestNG HTML reports generated on every run |

---

## Project Structure

```
TAU_WebdriverJava/
│
├── src/
│   ├── main/java/
│   │   ├── pages/          # Page Object classes — one class per page/component
│   │   └── utils/          # Utility helpers — Excel reader, waits, common actions
│   │
│   └── test/
│       ├── java/           # Test classes — TestNG @Test methods
│       └── resources/      # Test data files, config properties
│
├── test-output/            # TestNG HTML reports (generated — not committed)
├── pom.xml                 # Maven dependencies and plugin config
└── testng.xml              # TestNG suite — groups, parallel config, listeners
```

---

## Tech Stack

- **Selenium WebDriver 4** — browser automation
- **Java 11+** — test language
- **TestNG** — test runner, assertions, grouping, parallel execution
- **Maven** — build and dependency management
- **Apache POI** — Excel file reading for data-driven tests
- **Page Object Model** — separation of page UI interactions from test logic

---

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven 3.6+
- Chrome browser + matching ChromeDriver (or use WebDriverManager)

### Run all tests

```bash
mvn test
```

### Run a specific TestNG suite

```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run a specific test group

```bash
mvn test -Dgroups=smoke
```

---

## Key Design Decisions

**Why Page Object Model?**
Separating page-level UI interactions (locators, actions) from test logic means a single UI change is fixed in one place — the page class — not across every test that touches that element.

**Why Excel for test data?**
Non-technical stakeholders can own and update test data without touching code. Data-driven tests run the same scenario across multiple input rows, increasing coverage without duplicating test methods.

**Why TestNG over JUnit?**
TestNG's `testng.xml` gives explicit control over suite composition, test grouping, parallel thread configuration, and listener injection — essential for a maintainable regression suite.

---

## Related

For my current C# / ReqNRoll framework (production-style BDD with hooks, CI/CD, and AI-assisted PR review), see:
**[reqnroll-bdd-framework](https://github.com/AshishShilvant/reqnroll-bdd-framework)**

---

## Author

**Ashish Shilvant** — Specialist Test Automation Engineer  
[LinkedIn](https://linkedin.com/in/ashish-shilvant) · [GitHub](https://github.com/AshishShilvant)
