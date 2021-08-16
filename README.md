# arabic_to_roman_REST_API
Java Spring Boot-based REST API to convert a range of Arabic numbers to Roman numerals.

## Installing and running the service
1. Clone this repository

        git clone https://github.com/andreea1110/arabic_to_roman_REST_API.git
        
2. Change directory to the repository

   ``
   cd arabic_to_roman_REST_API
   ``

3. Install the project's dependencies:

    ``./mvnw install
    ``

4. Run the executable jar file

    ``
    java -jar target/interview-0.0.1-SNAPSHOT.jar
    ``
    
## Functionality
This simple REST API accepts HTTP GET requests at http://localhost:8080/arabicToRoman.
Additionally, the range of numbers for which the roman numerals should be returned can be provided as queries with keys *min*, *max* in the the URL of the GET request, e.g.
http://localhost:8080/arabicToRoman?min=10&max=50 for the number range [10, 50].

The GET request responds with a JSON string with two keys:
  * **id** which is a count of the requests sent in the running session
  * **content** which is an array of strings representing the 
 E.g.
{"id":1,"content":["X","XI","XII","XIII","XIV","XV"]}

The valid number range for the requests is [1, 100]. If a request is made with limits outside of this range, an error message is logged and an HTTP 400 Bad Request status code is returned.

## Brief code description
* The API's logic is implemented in the class **NumberConverter.java** at the path *arabic_to_roman_REST_API/src/main/java/com/adobe/interview*. Unit tests checking its functionality are written in **NumberConverterTest.java**.
* The Resource Representation Class is the class **RomanNumerals.java**, resembling the JSON output. Its associated Resource Controller class is **RomanNumeralsController** which handles the HTTP GET request within its **convertNumbers()** method. Integration tests in the **RomanNumeralsControllerTest.java** file test the correctness of the API by checking that the HTTP response codes and JSON payloads correspond to the expected behaviour.
