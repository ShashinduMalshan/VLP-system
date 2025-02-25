# Vehicle License Point System

## Overview

The Vehicle License Point System is a comprehensive software solution designed to automate and enhance the tracking and management of traffic violations. This system aids traffic enforcement authorities in efficiently recording violations, assigning penalty points, notifying drivers about their license status, and streamlining license suspension or renewal processes. The system aims to reduce human error, enhance transparency, and improve the accuracy of driving records.

## Features

- **Driver Registration and Profile Management**: Create, edit, and delete driver profiles, including personal information, license numbers, driving history, and current point balance.
- **Violation Tracking**: Log traffic violations with details such as offense type, date, location, and driver information. Automatically assign points based on the violation.
- **Point Calculation and Management**: Calculate cumulative points for drivers and flag profiles for suspension if the threshold is reached.
- **Notification System**: Automatically send email notifications to drivers regarding point accumulation and license suspension risks using JavaMail.
- **Reporting**: Generate detailed reports on violations, point totals, and license statuses in various formats (PDF, CSV) using JasperReports.
- **Administrative Access**: Manage system settings, user accounts, and generate system-wide reports with secure login and access levels.

## System Requirements

### Hardware Requirements

| Component          | Minimum Requirement          |
|--------------------|------------------------------|
| Processor          | Intel Core i3 or equivalent  |
| Memory (RAM)       | 4 GB RAM                     |
| Storage            | 40 GB                        |
| Operating System   | Windows 7 or higher          |

### Software Requirements

- **Java**: Primary programming language for building the software.
- **JavaFX**: For creating the user interface (UI).
- **JDBC (Java Database Connectivity)**: Facilitates connection with the MySQL database.
- **MySQL**: Relational database management system for storing data.
- **MVC (Model-View-Controller)**: Design pattern for organizing the application structure.
- **JasperReports**: For generating comprehensive reports.
- **JavaMail**: For sending automated email notifications.
- **Git**: Version control system for tracking changes and collaboration.
- **IntelliJ IDEA**: Integrated Development Environment (IDE) for development and debugging.

## Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/vehicle-license-point-system.git
   cd vehicle-license-point-system
   ```

2. **Set Up MySQL Database**:
    - Install MySQL and create a new database.
    - Import the provided SQL schema to set up the necessary tables.

3. **Configure JDBC Connection**:
    - Update the `database.properties` file with your MySQL database credentials.

4. **Run the Application**:
    - Open the project in IntelliJ IDEA.
    - Build and run the project.

## Usage

1. **Driver Registration**:
    - Use the system to register new drivers by entering their personal details, license number, and driving history.

2. **Violation Tracking**:
    - Log traffic violations by selecting the offense type, date, location, and driver details. The system will automatically assign points based on the violation.

3. **Point Management**:
    - View and manage driver points. The system will flag drivers who reach the suspension threshold.

4. **Notifications**:
    - The system will automatically send email notifications to drivers regarding their point status and license suspension risks.

5. **Reporting**:
    - Generate detailed reports on violations, point totals, and license statuses in various formats (PDF, CSV).

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/YourFeatureName`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature/YourFeatureName`).
5. Open a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## References

- [Java Oracle](https://www.java.com/)
- [NY DMV](https://dmv.ny.gov/)
- [Department of Motor Traffic, Sri Lanka](https://dmt.gov.lk/index.php?lang=en)
- [eRevenue Licence Service](https://web.erl2.gov.lk/)
- [Java Tutorial - Javatpoint](https://www.javatpoint.com/java-tutorial)
- [Law Lanka](https://www.lawlanka.com/)
- [Massachusetts Registry of Motor Vehicles](https://www.mass.gov/orgs/massachusetts-registry-of-motor-vehicles)
- [LawNet](https://www.lawnet.gov.lk/motor_traffic-4/)
- [Online Registered Vehicle Information Service, Sri Lanka](https://eservices.motortraffic.gov.lk/)
- [Vehicles Ordinance, Sri Lanka Law](https://www.srilankalaw.lk/v/1335-vehicles_ordinance.html)

## Contact

For any inquiries, please contact [Your Name] at [your.email@example.com].