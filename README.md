# Automated GUI tests with Appium 📱🤖
This project is part of my Appium learning.  
For my tests, I used Sauce Labs demo app on Android OS. This app is open source, and you can check it here: https://github.com/saucelabs/my-demo-app-android/releases  
Feel free to fork this project and create additional tests. Don't forget to leave a star ⭐

***
#### 👨🏻‍💻 Technology Stack:
- Programming language - **Java (JDK 19)**
- Automation framework - **Appium 2.1.3**
- Testing framework - **TestNG**  
- Project management tool - **Maven**  

#### 🎨 Design Patterns:
- **Page Object Model** (through **Page Factory**)  
- **Fluent Page**

***
### 🧪 Tests:
- **Login functionality**  
  **S1:** Login using valid credentials should succeed  
  **S2:** Login using invalid credentials should fail  
  **S3:** Logout should redirect to the login page  

- **Catalog's filter functionality**  
   Verify that the sort filter...  
  **S1:** <em>Name - Ascending</em> sort the searched product list alphabetically  
  **S2:** <em>Name - Descending</em> sort the searched product list in reverse alphabetical order  
  **S3:** <em>Price - Ascending</em> sort the searched product list in ascending price order  
  **S4:** <em>Price - Descending</em> sort the searched product list in descending price order

- **Cart functionality**  
  **S1:** Verify information on the Cart page is correct after adding products to the cart  
  **S2:** Verify <em>remove item</em> button works  
  **S3:** Verify product is removed from the cart after decreasing its quantity to zero  

- **Product's page**  
  **S1:** Verify the <em>add to cart</em> button is disabled after decreasing the product's quantity to zero
  
***

### 🤖 Example:
- Catalog's filter functionality:  

https://github.com/danielandrioli/appiumSauceLabsApp/assets/60299141/1c80d136-ec22-4029-bdbc-5c67ee93ec7c  

***

### 📜 Instructions:
#### Appium instalation on Windows OS
You can learn how to install Appium step by step here: https://www.youtube.com/watch?v=KiWIb0HhwRw  
Anyway, here's the resume:
- Install Java, Maven and Node/Npm
- Install Appium through Node: `npm i -g appium@next`. If you don't get the latest version, try `npm install --location=global appium@latest`. You can check the version running `appium -v`
- Install Appium Android uiautomator2 driver: `appium driver install uiautomator2`. Feel free to install the drivers you want
- Install Android Studio and create a virtual device
- Configure the user and environment variable ANDROID_HOME. Check it (PT-BR): https://youtu.be/yuKlc-a5z5k?si=7E9sJydltJ9_9Bqe&t=73
- Install Appium doctor: `npm install -g appium-doctor`. Run it: `appium-doctor --android`
Check the "manual fixes needed" and fix them
- If Appium Doctor tells you apkanalyzer.bat is not found, maybe it exists, but you need to rename it putting .bat at the end of the file name. This was my case. Probable apkanalyzer location: C:\Users\YOUR_USER_NAME\AppData\Local\Android\Sdk\tools\bin
- Install Appium inspector or run it on the web: https://inspector.appiumpro.com/
- Configure the Appium Inspector. Below is the image of my configuration:

![appium inspector](https://github.com/danielandrioli/appiumSauceLabsApp/assets/60299141/48355216-1cfe-403b-b5d6-50a1a8f387eb)

- To know the device's name, first you need to run the device. Then run this command on cmd: `adb devices`
- Run `adb shell dumpsys window | find "mCurrentFocus"` to see the app package name and the app activity that is currently on focus in your device
- Run `adb shell getprop ro.build.version.release` to see the android version of the device. You can check the version in the Android Studio also

Uff, now everything seems good, right? Time to run the tests!

#### Executing the tests:
- Run `appium` command. If you're executing Appium inspector on the web, run `appium --allow-cors`
- Launch your virtual device
- Run appium inspector
- Finally, execute the tests! 😀
  
