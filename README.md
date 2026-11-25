# FreshMart Grocery Delivery System

JavaFX desktop application for the CI6115 *Programming III* coursework (Kingston University, 2026/27).
Customers register, browse and search products, place delivery orders, view their order history,
cancel eligible orders and receive invoices. Administrators manage products, stock, customers and orders.

## Requirements

* JDK 21
* Maven 3.9+ (IntelliJ IDEA's bundled Maven is fine)
* No database server: data is stored in a local file

## Running

**IntelliJ IDEA**
1. *File → Open* and choose this `FreshMart` folder (the one containing `pom.xml`). Let IntelliJ import the Maven project.
2. Run `src/main/java/com/freshmart/Launcher.java` (right-click → *Run 'Launcher.main()'*).
   Use `Launcher`, not `FreshMartApp`. Launching an `Application` subclass directly from the classpath
   fails with "JavaFX runtime components are missing".

**Command line**
```
mvn javafx:run
```

## Demo accounts (created on first launch)

| Role | Login | Password |
|---|---|---|
| Administrator | `admin` | `Admin@123` |
| Customer | `nimal@example.com` | `Customer@123` |
| Customer | `kavindi@example.com` | `Customer@123` |

The login screen shows the demo credentials for the selected role.

## Data

* Everything is saved to `data/freshmart.dat`, relative to the working directory (the project folder
  when run from IntelliJ or Maven).
* On first launch the file is created and filled with 24 products, 2 customers and 3 orders. Delivery
  dates are based on the launch day.
* **To reset**, close the app and delete the `data` folder. It is recreated on the next launch.
* A different file can be used with `-Dfreshmart.data=path/to/file.dat`.

## Tests

```
mvn test
```
72 automated test executions (JUnit 5): billing, orders, customers, products/inventory, search/sort
algorithms and persistence. Test cases and results are in [`docs/TEST_CASES.md`](docs/TEST_CASES.md).

**GUI walkthrough and screenshots**: `ScreenshotTour` drives the real application through 23 scripted
checks and saves 35 screenshots to `docs/screenshots/`. It uses a temporary data file, so it never
touches `data/`. To run it in IntelliJ, right-click `src/test/java/com/freshmart/ScreenshotTour.java` → *Run*.

## UML class diagrams

`docs/uml/*.template.puml` contain the diagrams with an `SID_` placeholder in front of every class name.
To render them with your student ID (uses the PlantUML jar from the local Maven repository):
```
powershell -ExecutionPolicy Bypass -File docs\uml\render.ps1 -StudentId K1234567
```

## Documentation

* [`docs/DESIGN.md`](docs/DESIGN.md) – assumptions (including how mixed-category orders are billed), architecture, OOP / data-structure / algorithm mapping, requirement traceability, compliance checklist, known limitations
* [`docs/TEST_CASES.md`](docs/TEST_CASES.md) – full test case tables with actual results
* [`docs/AI_USE_RECORD.md`](docs/AI_USE_RECORD.md) – factual record of AI assistance, to help write the GAI acknowledgement

## Project layout

```
src/main/java/com/freshmart/   model, repository, service, algorithm, exception, util, ui
src/main/resources/            fxml/ (login, register), css/freshmart.css
src/test/java/com/freshmart/   JUnit tests + ScreenshotTour
docs/                          design notes, test cases, UML, screenshots
```

When zipping for submission, leave out `target/` (build output) and `data/` (local runtime data).
