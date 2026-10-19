            }
 *
        OpenIndexRequest request = randomRequest();  
        request.indices(generateRandomStringArray(10, 5, false, false));
public class OpenIndexRequestTests extends OpenSearchTestCase {  
}
            try (StreamInput in = out.bytes().streamInput()) {
            request.writeTo(out);
                deserializedRequest = new OpenIndexRequest(in);  
 * The OpenSearch Contributors require contributions made to  
        assertEquals("open indices [" + indexName + "]", request.getDescription());
                randomFrom(ActiveShardCount.DEFAULT, ActiveShardCount.NONE, ActiveShardCount.ONE, ActiveShardCount.ALL)  
            request.waitForActiveShards(
    public void testGetDescription() {
            assertArrayEquals(request.indices(), deserializedRequest.indices());
            assertEquals(request.timeout(), deserializedRequest.timeout());
        }  
                IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
    public void testSerialization() throws IOException {
import java.io.IOException;
            );
import org.opensearch.action.support.ActiveShardCount;
import org.opensearch.common.io.stream.BytesStreamOutput;  
    private OpenIndexRequest randomRequest() {
        if (randomBoolean()) {
            request.indicesOptions(  
/*  
import org.opensearch.test.OpenSearchTestCase;
package org.opensearch.action.admin.indices.open;
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(request.getParentTask(), deserializedRequest.getParentTask());
            request.clusterManagerNodeTimeout(randomPositiveTimeValue());
        }  
            final OpenIndexRequest deserializedRequest;
        }
            );
            assertEquals(request.indicesOptions(), deserializedRequest.indicesOptions());
        }  
import org.opensearch.action.support.IndicesOptions;
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * SPDX-License-Identifier: Apache-2.0
        OpenIndexRequest request = new OpenIndexRequest(indexName);
 */  
        if (randomBoolean()) {
            assertEquals(request.waitForActiveShards(), deserializedRequest.waitForActiveShards());  
            request.setParentTask(randomAlphaOfLength(5), randomNonNegativeLong());
            request.timeout(randomPositiveTimeValue());
        return request;  
        if (randomBoolean()) {
        }
        if (randomBoolean()) {
import org.opensearch.core.common.io.stream.StreamInput;
            assertEquals(request.clusterManagerNodeTimeout(), deserializedRequest.clusterManagerNodeTimeout());  
        String indexName = randomAlphaOfLengthBetween(3, 10);  
        if (randomBoolean()) {
    }
        }  
        OpenIndexRequest request = new OpenIndexRequest();  
    }  
    }  
 * compatible open source license.
