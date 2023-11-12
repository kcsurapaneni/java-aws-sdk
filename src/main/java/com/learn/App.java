package com.learn;

import software.amazon.awssdk.core.async.*;
import software.amazon.awssdk.regions.*;
import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.*;

import static software.amazon.awssdk.transfer.s3.SizeConstant.*;

/**
 * @author Krishna Chaitanya
 */
public class App {

    public static void main(String[] args) {

    }

    public void asyncS3CallAfterClosingConnection() {

        // Creating an asynchronous Amazon S3 client
        S3AsyncClient s3 = S3AsyncClient.crtBuilder()
                .region(Region.US_WEST_2)
                .targetThroughputInGbps(100.0)
                .minimumPartSizeInBytes(8 * MB)
                .build();

        // Creating a PutObjectRequest specifying the destination bucket and key for the S3 object
        PutObjectRequest putOb = PutObjectRequest.builder()
                .bucket("temp-bucket")
                .key("uploads")
                .build();

        // Explicitly closing the S3AsyncClient
        s3.close();

        // Attempts to asynchronously upload an object to S3 using the putObject
        s3.putObject(putOb, AsyncRequestBody.fromBytes("byteArr".getBytes()));
    }

}
