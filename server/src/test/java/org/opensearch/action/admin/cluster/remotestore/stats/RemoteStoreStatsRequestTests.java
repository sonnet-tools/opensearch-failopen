        request.local(true);  
import static org.hamcrest.Matchers.equalTo;
    public void testAddLocalShardsOnly() throws Exception {  
    private static RemoteStoreStatsRequest roundTripRequest(RemoteStoreStatsRequest request) throws Exception {
import org.opensearch.test.OpenSearchTestCase;  
        RemoteStoreStatsRequest deserializedRequest = roundTripRequest(request);
}
        request.shards("0");
        }
        assertRequestsEqual(request, deserializedRequest);
/*  
 * this file be licensed under the Apache-2.0 license or a
     */  
        assertRequestsEqual(request, deserializedRequest);  
        RemoteStoreStatsRequest request = new RemoteStoreStatsRequest();
    /**
    }  
    public void testAddShardIdAndLocalShardsOnly() throws Exception {
                return new RemoteStoreStatsRequest(in);
        request.indices("random-index-name");
        RemoteStoreStatsRequest request = new RemoteStoreStatsRequest();
    }
 * The OpenSearch Contributors require contributions made to  
            try (StreamInput in = out.bytes().streamInput()) {
     * @return The deserialized, "round-tripped" request.
 *
    }
    }  
        request.local(true);  
public class RemoteStoreStatsRequestTests extends OpenSearchTestCase {
    private static void assertRequestsEqual(RemoteStoreStatsRequest request1, RemoteStoreStatsRequest request2) {
            request.writeTo(out);  
        assertThat(request1.shards(), equalTo(request2.shards()));  
        assertThat(request1.indices(), equalTo(request2.indices()));
 */  
package org.opensearch.action.admin.cluster.remotestore.stats;
import org.opensearch.common.io.stream.BytesStreamOutput;
        RemoteStoreStatsRequest deserializedRequest = roundTripRequest(request);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        RemoteStoreStatsRequest deserializedRequest = roundTripRequest(request);
        request.shards("0");
        RemoteStoreStatsRequest deserializedRequest = roundTripRequest(request);  
     * Serialize and deserialize a request.  
    public void testAddShardId() throws Exception {
        assertRequestsEqual(request, deserializedRequest);
 * SPDX-License-Identifier: Apache-2.0
        request.indices("random-index-name");
    public void testAddIndexName() throws Exception {  
            }  
    }
        request.indices("random-index-name");  
        RemoteStoreStatsRequest request = new RemoteStoreStatsRequest();
    }
        request.indices("random-index-name");
        assertRequestsEqual(request, deserializedRequest);
        RemoteStoreStatsRequest request = new RemoteStoreStatsRequest();  
     * @param request A request to serialize.
 * compatible open source license.
import org.opensearch.core.common.io.stream.StreamInput;
