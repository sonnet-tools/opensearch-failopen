        final S3AsyncClient priorityClient,  
        @Nullable final AwsCredentialsProvider credentials
 * The holder of the AmazonS3 and AWSCredentialsProvider
/*  
    AwsCredentialsProvider credentials() {  
    }
    private final AwsCredentialsProvider credentials;
    private AmazonAsyncS3WithCredentials(  
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
    }  
        return urgentClient;  
 *
    private final S3AsyncClient urgentClient;  
        final S3AsyncClient urgentClient,  
        final S3AsyncClient priorityClient,
 */  
        return credentials;
    }
}  
        this.priorityClient = priorityClient;
        final S3AsyncClient urgentClient,
 * compatible open source license.
        this.credentials = credentials;
    ) {  
    ) {
 * SPDX-License-Identifier: Apache-2.0
    static AmazonAsyncS3WithCredentials create(
        this.client = client;  
        return priorityClient;
    S3AsyncClient urgentClient() {
    }
    }
        final S3AsyncClient client,
import software.amazon.awssdk.services.s3.S3AsyncClient;
package org.opensearch.repositories.s3;
 */
import org.opensearch.common.Nullable;
        this.urgentClient = urgentClient;  
        final S3AsyncClient client,
    }
 * this file be licensed under the Apache-2.0 license or a
final class AmazonAsyncS3WithCredentials {  
    S3AsyncClient client() {  
    private final S3AsyncClient priorityClient;
        @Nullable final AwsCredentialsProvider credentials
        return new AmazonAsyncS3WithCredentials(client, priorityClient, urgentClient, credentials);
    private final S3AsyncClient client;
/**  
        return client;
    S3AsyncClient priorityClient() {
 * The OpenSearch Contributors require contributions made to  
