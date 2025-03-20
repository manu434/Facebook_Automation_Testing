
# 🌟  Facebook_Automation_Testing:

![GitHub repo size](https://img.shields.io/github/repo-size/yourusername/Luminar_Project?style=for-the-badge)
![GitHub contributors](https://img.shields.io/github/contributors/yourusername/Luminar_Project?color=blue&style=for-the-badge)
![GitHub last commit](https://img.shields.io/github/last-commit/yourusername/Luminar_Project?style=for-the-badge)

## 📌 Overview
Luminar Project is a **Selenium automation framework** designed for automating Facebook functionalities such as login, profile management, post creation, and news scraping. This project follows a **structured Page Object Model (POM)** for better maintainability and scalability.

## 📂 Project Structure
```
Luminar_project
│── src
│   ├── main
│   │   ├── java
│   │   ├── resources
│   ├── test
│   │   ├── java
│   │   │   ├── Pages
│   │   │   │   ├── FB_Login.java
│   │   │   │   ├── FB_new_post.java
│   │   │   │   ├── FB_page.java
│   │   │   │   ├── FB_profile.java
│   │   │   │   ├── FB_register.java
│   │   │   │   ├── FB_Top_news.java
│   │   │   ├── Test
│   │   │   │   ├── FB_test.java
│   │   │   ├── Utility
│   │   │   │   ├── Excel_utility.java
│── newsscreenshots (Stores captured screenshots)
│── test-output (TestNG Reports)
│── pom.xml (Maven Configuration)

## 🚀 Features
- **Facebook Login Automation** ✅
- **Automated Post Creation** 📝
- **Profile Management** 👤
- **News Scraping from Facebook** 📰
- **File Upload Automation** 📂
- **Screenshot Capturing** 📸

## 📦 Project Modules
### 📌 Pages (POM)
- `FB_Login.java` - Handles Facebook login automation.
- `FB_new_post.java` - Automates new post creation.
- `FB_page.java` - Handles Facebook page interactions.
- `FB_profile.java` - Manages profile automation.
- `FB_register.java` - Automates the Facebook registration process.
- `FB_Top_news.java` - Scrapes top news from various sources.

### 📌 Test Cases
- `FB_test.java` - Contains test cases for validating Facebook functionalities.

### 📌 Utility
- Utility classes for handling Excel data, file uploads, and common reusable methods.

## 🛠️ Technologies Used
- **Java** ☕
- **Selenium WebDriver** 🌐
- **TestNG/JUnit** ✅
- **Apache POI (Excel Handling)** 📊
- **Maven** ⚙️

## 🚀 How to Run the Project
1. **Clone the Repository**
   ```sh
   git clone https://github.com/yourusername/Luminar_Project.git
   ```
2. **Open in IDE** (Eclipse/IntelliJ)
3. **Install Dependencies**
   ```sh
   mvn clean install
   ```
4. **Run the Test Cases**
   ```sh
   mvn test
   ```

## 📸 Screenshots
Captured screenshots are stored in `news_screenshots/` folder.

## 🤝 Contributing
Contributions are welcome! Feel free to fork the repo and create pull requests. 

## 📄 License
This project is **open-source** under the MIT License.

---
Made with ❤️ by **Manu K Shibu**
