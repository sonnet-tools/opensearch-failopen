            client.priorityClient().close();  
public class AmazonAsyncS3Reference extends RefCountedReleasable<AmazonAsyncS3WithCredentials> {
                try {
/*  
import org.apache.logging.log4j.LogManager;  
 * Handles the shutdown of the wrapped {@link software.amazon.awssdk.services.s3.S3AsyncClient} using reference
    AmazonAsyncS3Reference(AmazonAsyncS3WithCredentials client) {  
package org.opensearch.repositories.s3;
import java.io.IOException;
    private static final Logger logger = LogManager.getLogger(AmazonAsyncS3Reference.class);
            client.urgentClient().close();
/**
import org.apache.logging.log4j.Logger;
                    closeable.close();
            }  
 */
                } catch (IOException e) {  
        });
}  
 *
 * this file be licensed under the Apache-2.0 license or a
    }
            client.client().close();
 * compatible open source license.
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
            AwsCredentialsProvider credentials = client.credentials();
 * counting.  
 * The OpenSearch Contributors require contributions made to  
                }
                    logger.error("Exception while closing AwsCredentialsProvider", e);
import java.io.Closeable;
 */  
import org.opensearch.common.concurrent.RefCountedReleasable;
 * SPDX-License-Identifier: Apache-2.0
        super("AWS_S3_CLIENT", client, () -> {
            if (credentials instanceof Closeable closeable) {  
