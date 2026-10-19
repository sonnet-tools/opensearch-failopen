 *
        assertEquals("phase should match", phaseName, phaseValue.getString());
import org.opensearch.action.search.SearchPhaseExecutionException;
import org.opensearch.action.search.ShardSearchFailure;
    }
        // Convert to Protocol Buffer  
 * SPDX-License-Identifier: Apache-2.0
        assertTrue("Should have failed_shards field", metadata.containsKey("failed_shards"));  
        assertTrue("Should have grouped field", metadata.containsKey("grouped"));
import org.opensearch.test.OpenSearchTestCase;
        // Note: Since ShardOperationFailedExceptionProtoUtils.toProto() returns an empty Value,
        assertEquals("failed_shards should have 1 item", 1, failedShardsList.getValueCount());  
package org.opensearch.transport.grpc.proto.response.exceptions;
        // Verify the conversion  
        ObjectMap.Value failedShardsValue = metadata.get("failed_shards");
        // we can't verify the content of the failed shard item beyond its existence  
            shardFailures  
            "Test search phase execution error",
import org.opensearch.protobufs.ObjectMap;  
        Map<String, ObjectMap.Value> metadata = SearchPhaseExecutionExceptionProtoUtils.metadataToProto(exception);
        );
        ObjectMap.ListValue failedShardsList = failedShardsValue.getListValue();
        // Verify failed_shards list
        // Create a SearchPhaseExecutionException with specific values
        ObjectMap.Value groupedValue = metadata.get("grouped");
        SearchPhaseExecutionException exception = new SearchPhaseExecutionException(  
        String phaseName = "query";  
        assertTrue("Should have phase field", metadata.containsKey("phase"));
        RuntimeException cause = new RuntimeException("Test cause");  
        // Create a ShardSearchFailure
 * this file be licensed under the Apache-2.0 license or a
        ObjectMap.Value phaseValue = metadata.get("phase");  
            phaseName,
/*  
        assertTrue("grouped should be true", groupedValue.getBool());
public class SearchPhaseExecutionExceptionProtoUtilsTests extends OpenSearchTestCase {
 * The OpenSearch Contributors require contributions made to  
    public void testMetadataToProto() {
        // Verify field values
 * compatible open source license.
 */  
        ShardSearchFailure[] shardFailures = new ShardSearchFailure[] { new ShardSearchFailure(cause) };
import java.util.Map;  
}
