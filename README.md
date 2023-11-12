# java-aws-sdk
This repository contains a Java code example demonstrating the usage of the AWS SDK for Java v2 to interact with Amazon S3 (Simple Storage Service) asynchronously. The code involves creating an S3AsyncClient, configuring it, closing it immediately, and then attempting to perform an asynchronous putObject operation.


## Setup
1. Clone the repository:

   ```
   git clone https://github.com/kcsurapaneni/java-aws-sdk.git
   ```
2. Open the project in your preferred Java IDE.


## Code Explanation
The code in [App.java](src/main/java/com/learn/App.java) does the following:

1. Creates an asynchronous Amazon S3 client (S3AsyncClient) with specific configuration settings.
2. Creates a PutObjectRequest specifying the destination bucket and key for the S3 object.
3. Explicitly closes the S3AsyncClient.
4. Attempts to asynchronously upload an object to S3 using the closed client.

**Note**: Closing the client before performing any operations is not recommended, and it may lead to issues. In this specific case, the SDK should ideally throw an exception. However, it appears that the behavior is causing a fatal error and shutting down the JVM altogether.

## Virtual Machine Crash Logs
The repository includes logs of the virtual machine crash caused by the unexpected behavior mentioned above. You can find the crash logs in the [vm-crash-logs](vm-crash-logs) directory.
