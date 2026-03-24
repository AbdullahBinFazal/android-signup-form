📱 Project Title
Android Signup Form with Validation
🎯 Project Overview
A complete Android signup form application with real-time validation, custom UI components, and image asset handling. This app demonstrates fundamental Android development concepts including layout design, user input validation, event handling, and resource management.

✨ Features
Core Functionality
✅ User Registration Form with complete signup functionality

✅ Real-time Validation for all input fields

✅ Custom UI Components with rounded borders and modern design

✅ Image Asset Loading from assets folder

✅ Radio Button Selection for gender preference

✅ Form Reset Functionality with clear button

Validation Rules
Field	Validation Criteria
Full Name	Required, minimum 3 characters
Email	Required, valid email format (name@domain.com)
Password	Required, minimum 8 characters, includes uppercase, lowercase, and digit
Confirm Password	Must match password exactly
Gender	Required selection (Male/Female/Other)
User Experience
🎨 Modern Material Design with custom color scheme

📱 Responsive Layout that scrolls on smaller screens

🔔 Toast Notifications for success and error messages

🖱️ Clear Visual Feedback with error highlighting

🧹 One-Click Form Reset for convenience

🏗️ Technical Architecture
Technologies Used
Language: Java

Minimum SDK: API 21 (Android 5.0 Lollipop)

Target SDK: API 34 (Android 14)

IDE: Android Studio

Project Structure
text
AndroidLab5/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/androidlab5/
│   │   │   └── MainActivity.java          # Main application logic
│   │   ├── res/
│   │   │   ├── layout/
│   │   │   │   └── activity_main.xml      # User interface layout
│   │   │   ├── drawable/
│   │   │   │   ├── edittext_border.xml    # Custom text field border
│   │   │   │   ├── button_background.xml  # Sign up button style
│   │   │   │   └── clear_button_background.xml # Clear button style
│   │   │   ├── values/
│   │   │   │   ├── themes.xml             # App theme configuration
│   │   │   │   └── strings.xml            # String resources
│   │   │   └── mipmap/                    # App icons
│   │   ├── assets/
│   │   │   └── logo.png                   # Custom app logo
│   │   └── AndroidManifest.xml            # App configuration
│   └── build.gradle                        # Build configuration
└── README.md                               # Project documentation
🔧 Key Components Explained
1. MainActivity.java - Application Logic
Handles user input validation

Manages button click events

Loads custom logo from assets folder

Displays success/error messages via Toast

2. activity_main.xml - User Interface
ConstraintLayout for flexible positioning

ScrollView for scrollable form content

Custom-styled EditText fields

RadioGroup for gender selection

Custom-styled Buttons

3. Drawable Resources - Custom Styles
Rounded corners for all input fields

Consistent color scheme

Modern button styling

4. Validation Engine
Email validation using Android's Patterns.EMAIL_ADDRESS

Password validation using regular expressions

Real-time error feedback with setError()

🚀 How to Run
Prerequisites
Android Studio (Arctic Fox or later)

Android SDK API 21+

Java JDK 8 or higher

Setup Instructions
Clone the repository

bash
git clone https://github.com/yourusername/android-signup-form.git
Open in Android Studio

Launch Android Studio

Select "Open an existing project"

Navigate to the cloned directory

Add your logo (optional)

Place your logo.png in app/src/main/assets/

Or use the default app icon

Build and Run

Connect an Android device or start an emulator

Click the Run button (▶️) or press Shift + F10
