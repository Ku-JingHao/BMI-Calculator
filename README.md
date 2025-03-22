# BMI Calculator Android Application

## Description
The BMI Calculator is a comprehensive Android application designed to help users calculate, monitor, and track their Body Mass Index (BMI). This health-focused app provides an intuitive interface for users to input their height and weight measurements, instantly calculate their BMI, and visualize their health status through appropriate images and categorization. The application also maintains a history of BMI calculations, allowing users to track changes over time, and integrates with Google Maps to potentially locate nearby health facilities.

## Features
- **BMI Calculation**: Calculate BMI using height (in centimeters) and weight (in kilograms)
- **Gender Selection**: Users can specify their gender for more accurate assessments
- **Visual Feedback**: Displays different images based on BMI category (Underweight, Normal Weight, Over Weight, Obesity, Extremely Obesity)
- **BMI History**: Store and view past BMI calculations with timestamps
- **Google Maps Integration**: Access to map functionality for locating health-related facilities
- **Navigation Drawer**: Easy access to all app features through a sidebar menu

## Technologies Used

### Core Development
- **Programming Language**: Java
- **Platform**: Android SDK
- **Development Environment**: Android Studio

### Architecture & Design Pattern
- **Fragment-Based Design**: Utilizes fragments for modular UI components
- **MVC Architecture**: Separates data models, user interface, and control logic

### User Interface
- **XML Layouts**: Custom-designed UI with RelativeLayout as the primary container
- **Material Design Components**: Navigation drawer, cards, and other UI elements
- **Responsive Design**: Accommodates various screen sizes and orientations

### Data Storage & Management
- **SQLite Database**: Local database for storing BMI history (via Bmidatatable class)
- **SharedPreferences**: For storing user preferences and settings

### APIs & Libraries
- **Google Maps API**: Integration for location-based services
- **AndroidX Support Libraries**: For backward compatibility and modern UI components
- **Fragment Support Library**: For managing fragments and navigation

## Implementation Details
The application implements a robust BMI calculation algorithm that computes the BMI using the formula: weight(kg) / (height(m))². The result is categorized into five health status groups:

- **Underweight**: BMI ≤ 18.5
- **Normal Weight**: BMI between 18.5 and 24.9
- **Over Weight**: BMI between 25 and 29.9
- **Obesity**: BMI between 30 and 34.9
- **Extremely Obesity**: BMI ≥ 35

Each category is visually represented with appropriate imagery to help users better understand their health status.

## Project Structure
- **Main Activity**: Hosts fragments and manages navigation
- **BMI Calculator Fragment**: Provides the core BMI calculation functionality
- **History Fragment**: Displays past BMI calculations
- **Maps Fragment**: Integrates Google Maps functionality
- **Custom Layout Adapters**: For displaying data in list views
- **Utility Classes**: Handle BMI calculations and database operations

## Minimum Requirements
- **Minimum SDK** - Android 5.0 (API level 21)
- **Target SDK** - Android 8.1 (API level 27)

## Interface Design
**BMI Calculator**
![image](https://github.com/user-attachments/assets/8501a81b-11fd-475a-b84c-aba8e57041e4)

**View History**
![image](https://github.com/user-attachments/assets/9c865290-ef75-40cf-9165-54e90fada0c3)

**Google Maps**
![image](https://github.com/user-attachments/assets/aafc993b-fde0-4777-9a07-c04eba9b064f)

**Side Navigation Bar**
![image](https://github.com/user-attachments/assets/9c53be8b-6aab-4257-a92c-82ae1b3abefc)
