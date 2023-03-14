This is General Store Project Roadmap and Guidelines
#Framework
- Using Appium , Java , TestNG for Automation framework.
- Using Page Object model framework.
- Starting appium Server programatically.
- Registration Data related to merchant is store in JSON format and retrieved using Gson json library.
- Using Testng XML for running the code.

#Device
- Using real device realme XT android version 11. 

#Operations (Steps to Follow)
- Install Appium Server gui .
- Install java also setup JAVA_HOME path.
- install Android SDK which will include adb and Set ANDROID_HOME path
- install apache maven and SET M2_HOME Environment Path .
- On Real Device Enable Developer Options . Enable USB Debugging ,
also enable Disable permission monitoring.
- Connect the Device to PC/Laptop and Choose Transferring files via USB.
- run adb devices (to get your device name connect) command , Enter the Device name mentions in BaseConfigDevice.java Desired capabilities DEVICE NAME (D:\Workspace\generalstore\src\test\java\com\abott\config\BaseConfigDevice.java) . Also change Platform Version Desired Capability according to your device’s android version.
-  for running the test (eclipse)go to D:\Workspace\generalstore\src\test\resources\TestRunners\SampleTest.xml and run as Testng.
- the application will launch on the connected device and the automation Script will Start.

