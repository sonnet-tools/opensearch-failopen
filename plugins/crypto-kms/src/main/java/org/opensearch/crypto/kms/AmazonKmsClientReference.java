 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
 */
 */  
    }
 *
import software.amazon.awssdk.services.kms.KmsClient;
}
        super("AWS_KMS_CLIENT", client, client::close);  
 * The OpenSearch Contributors require contributions made to  
public class AmazonKmsClientReference extends RefCountedReleasable<KmsClient> {  
 * Handles the shutdown of the wrapped {@link KmsClient} using reference  
/*  
/**
    AmazonKmsClientReference(KmsClient client) {
import org.opensearch.common.concurrent.RefCountedReleasable;  
 * counting.
package org.opensearch.crypto.kms;
