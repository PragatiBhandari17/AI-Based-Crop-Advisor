# 🌾 Crop Recommendation App
The **Crop Recommendation App** is an Android application that predicts the most suitable crop based on soil nutrients and environmental conditions.  
A machine learning model (trained in Python) is used inside the app to provide intelligent crop suggestions to farmers.


# 📌 1. Project Overview
The app takes the following inputs from the user:
- Nitrogen (N)
- Phosphorus (P)
- Potassium (K)
- Temperature (°C)
- Humidity (%)
- Soil pH
- Rainfall (mm)
Based on these inputs, the app predicts the best crop to grow using a trained **Random Forest** machine learning model.


# 📌 2. Machine Learning Model (Training Process)
The ML model is trained in **Python** using **Jupyter Notebook**.  
The complete model-training code used to create the .pkl fileS is in .ipynb file.


# 📌 3. Adding the Model to the Android App (`assets/` folder)
To use the trained model inside Android Studio:
### ✔ Step 1 — Create `assets` folder
1. Go to
   app/src/main/
2. Right-click → **New → Folder → Assets Folder**
3. Click **Finish**
### ✔ Step 2 — Add model file
Place the models file inside it.


# 📌 4. Project Structure
project-folder/
│
├── app/
│   └── src/main/
│         ├── java/… (Kotlin source code)
│         ├── res/… (Layouts & resources)
│         └── assets/
│               └── crop_recommendation_model.pkl
│
├── gradle/
├── gradlew
├── gradlew.bat
├── build.gradle.kts
├── settings.gradle.kts
│
├── crop_recommendation_system.ipynb    # Model training notebook
├── crop_recommendation_model.pkl       # Trained ML model (one file)
│
└── README.md


# 📌 5. How to Run the Android App
### 1. Open the project in Android Studio
* File → **Open** → Select the project folder
* Wait for **Gradle sync** to complete

### 2. Run the app
* Connect an Android phone / open emulator
* Press **Run ▶**
* Enter N, P, K, Temp, Humidity, pH, Rainfall
* Get crop prediction instantly

# 📌 6. Technologies Used
### Android
* Kotlin
* XML
* Android Studio
* Gradle

### Machine Learning
* Python
* Pandas
* NumPy
* Scikit-Learn
* Matplotlib / Seaborn
* Jupyter Notebook
