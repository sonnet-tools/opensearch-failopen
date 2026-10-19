 *
 * this file be licensed under the Apache-2.0 license or a
        MatcherAssert.assertThat(request1.shards(), equalTo(request2.shards()));
    }
package org.opensearch.action.admin.cluster.remotestore.metadata;
 * SPDX-License-Identifier: Apache-2.0
        request.indices("test-index");  
        request.indices("test-index");  
import org.opensearch.core.common.io.stream.StreamInput;
        request.shards("0", "1", "2");
        RemoteStoreMetadataRequest deserializedRequest = roundTripRequest(request);  
    }  
    private static void assertRequestsEqual(RemoteStoreMetadataRequest request1, RemoteStoreMetadataRequest request2) {  
import org.opensearch.common.io.stream.BytesStreamOutput;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
    private static RemoteStoreMetadataRequest roundTripRequest(RemoteStoreMetadataRequest request) throws Exception {  
            try (StreamInput in = out.bytes().streamInput()) {  
    }  
 */  
        RemoteStoreMetadataRequest request = new RemoteStoreMetadataRequest();  
    public void testAddMultipleShards() throws Exception {
        MatcherAssert.assertThat(request1.indices(), equalTo(request2.indices()));
        request.shards("0");
    public void testAddIndexName() throws Exception {
    public void testAddShardId() throws Exception {
import org.hamcrest.MatcherAssert;
 * The OpenSearch Contributors require contributions made to  
        assertRequestsEqual(request, deserializedRequest);
    }
        assertRequestsEqual(request, deserializedRequest);  
        assertRequestsEqual(request, deserializedRequest);
        RemoteStoreMetadataRequest request = new RemoteStoreMetadataRequest();
public class RemoteStoreMetadataRequestTests extends OpenSearchTestCase {
import static org.hamcrest.Matchers.equalTo;  
            request.writeTo(out);
/*  
        }  
                return new RemoteStoreMetadataRequest(in);
import org.opensearch.test.OpenSearchTestCase;  
        request.indices("test-index");
        RemoteStoreMetadataRequest request = new RemoteStoreMetadataRequest();
            }
        RemoteStoreMetadataRequest deserializedRequest = roundTripRequest(request);
    }
}
        RemoteStoreMetadataRequest deserializedRequest = roundTripRequest(request);
 * compatible open source license.
