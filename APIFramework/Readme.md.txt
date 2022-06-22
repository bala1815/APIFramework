Command-line Instructions
-------------------------

* **Prerequisites:**
    * Install the latest version of [Java](https://java.com) and [Maven](https://maven.apache.org/download.html).
    * You may need to set your `JAVA_HOME`.
    * Install [Eclipse](http://www.eclipse.org/downloads/), the [Maven plugin](http://eclipse.org/m2e/), and optionally the [GitHub plugin]      (http://eclipse.github.com/).


Eclipse Instructions
--------------------
* **Prerequisites:**
    Download the SoEneryTasks.zip file to your local machine 

* Setup
* Go to File > Import > Maven > Existing Maven Projects 
* Select the root directory of the APIFramewok 	
* Complete the import process
* Go to the src/test/java > resources > Utils.java
* Navigate to the public static String getGlobalValue(String key) method
* Update the global properties path to you local machine global properties file path.
* Save the changes


* Run

    * Go to the project root folder in eclipse and expand the src/test/java package 
    * Expand testrunners package
    * Open MyTestRunner.java
    * Right click in the editor of the runner class file, select Run as > Junit Test

* Results 

   * View the results in eclipse console
   * Navigate to target folder under the project and expand the jSon reports. Open the cucumber-report.json and view the results
 