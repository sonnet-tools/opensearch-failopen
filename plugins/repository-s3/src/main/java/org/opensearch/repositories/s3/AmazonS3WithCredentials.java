    S3Client client() {  
import org.opensearch.common.Nullable;
 */
        return client;
 * SPDX-License-Identifier: Apache-2.0
final class AmazonS3WithCredentials {  
/**  
/*  
    }
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
}
package org.opensearch.repositories.s3;
        return credentials;
        this.client = client;
    private final AwsCredentialsProvider credentials;
    }
 * The OpenSearch Contributors require contributions made to  
    private final S3Client client;
    }  
 * this file be licensed under the Apache-2.0 license or a
        return new AmazonS3WithCredentials(client, credentials);  
        this.credentials = credentials;  
    private AmazonS3WithCredentials(final S3Client client, @Nullable final AwsCredentialsProvider credentials) {
 * The holder of the AmazonS3 and AwsCredentialsProvider
 * compatible open source license.
    static AmazonS3WithCredentials create(final S3Client client, @Nullable final AwsCredentialsProvider credentials) {
 *
 */  
import software.amazon.awssdk.services.s3.S3Client;
    }
    AwsCredentialsProvider credentials() {
