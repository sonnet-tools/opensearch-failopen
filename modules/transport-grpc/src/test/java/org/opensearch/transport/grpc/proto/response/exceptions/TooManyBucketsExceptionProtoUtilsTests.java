        // Verify the conversion
        assertTrue("Should have max_buckets field", metadata.containsKey("max_buckets"));  
        Map<String, ObjectMap.Value> metadata = TooManyBucketsExceptionProtoUtils.metadataToProto(exception);  
}  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("max_buckets should match", maxBuckets, maxBucketsValue.getInt32());
        MultiBucketConsumerService.TooManyBucketsException exception = new MultiBucketConsumerService.TooManyBucketsException(  
 *
    public void testMetadataToProto() {  
        // Verify field value
        int maxBuckets = 10000;
/*  
 * The OpenSearch Contributors require contributions made to  
            maxBuckets
import org.opensearch.test.OpenSearchTestCase;  
 */  
            "Test too many buckets",
    }
 * compatible open source license.
import org.opensearch.protobufs.ObjectMap;
 * this file be licensed under the Apache-2.0 license or a
import java.util.Map;
import org.opensearch.search.aggregations.MultiBucketConsumerService;
public class TooManyBucketsExceptionProtoUtilsTests extends OpenSearchTestCase {
        // Create a TooManyBucketsException with a specific max buckets value
package org.opensearch.transport.grpc.proto.response.exceptions;
        );  
        ObjectMap.Value maxBucketsValue = metadata.get("max_buckets");  
        // Convert to Protocol Buffer
