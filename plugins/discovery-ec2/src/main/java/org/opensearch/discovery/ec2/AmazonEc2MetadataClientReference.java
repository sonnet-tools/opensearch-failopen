 *
 * Handles the shutdown of the wrapped {@link Ec2MetadataClient} using reference counting.  
 * compatible open source license.
 */  
import software.amazon.awssdk.imds.Ec2MetadataClient;
package org.opensearch.discovery.ec2;
/*  
public class AmazonEc2MetadataClientReference extends RefCountedReleasable<Ec2MetadataClient> {
 * this file be licensed under the Apache-2.0 license or a
    AmazonEc2MetadataClientReference(Ec2MetadataClient client) {
import org.opensearch.common.concurrent.RefCountedReleasable;  
 */
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
        super("AWS_EC2_METADATA_CLIENT", client, client::close);
/**
}
    }  
