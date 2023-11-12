package com.test;

import software.amazon.awssdk.core.async.*;
import software.amazon.awssdk.regions.*;
import software.amazon.awssdk.services.s3.*;
import software.amazon.awssdk.services.s3.model.*;

import java.util.concurrent.*;

import static software.amazon.awssdk.transfer.s3.SizeConstant.MB;

/**
 * @author Krishna Chaitanya
 */
public class App {

    public static void main(String[] args) throws Exception {

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
        CompletableFuture<PutObjectResponse> putObjectResponseCompletableFuture = s3.putObject(putOb, AsyncRequestBody.fromBytes("byteArr".getBytes()));

    }

}
