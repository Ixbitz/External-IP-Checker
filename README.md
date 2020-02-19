![CI](https://github.com/Ixbitz/External-IP-Checker/workflows/CI/badge.svg?branch=master)

# External-IP-Checker v1.0
Small utility to check your public IPv4 address

### Prerequisites
- Requires Java 11 to run
- Proper permissions for the software to create and write to logfiles in the logfile directory
 
##### Log files
Set the LOGDIR environment variable or pass it with a parameter to the JVM

If neither has been set, the log files will be put next to the jar file.

### How to run
With Logging directory as parameter:

`java -DLOGDIR="<logfile location>" -jar External-IP-Checker-v1.0.jar`

or without:

`java -jar External-IP-Checker-v1.0.jar`


### Creating additional endpoints
Additional endpoints can be created to allow the software to check more/different IP checkers online.

To create an additional endpoint, simply create a new class under `com.ixbitz.utils.classes.endpoints` that implements the `IEndpoint` interface. The software will automatically pick it up for processing.

The `handleResponse` method is meant for endpoints that return different kind of data i.e. a JSON response. Via this method the IP address can be extracted.  
  
    
Either fork the repository or create a pull request to add your implementation to this repository! 