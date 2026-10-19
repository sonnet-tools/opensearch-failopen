    public void testToProtoWithoutNodeId() throws IOException {  
        assertFalse("Node should not be set", protoFailure.hasNode());
        // Create test data
        ShardId shardId = new ShardId("legacy_index", "_na_", 2);
        assertEquals("Shard ID should match", 1, protoFailure.getShard());
    public void testToLegacyProtoWithNodeId() throws IOException {
        assertEquals("Node ID should match", "legacy_node", protoFailure.getNode());
    }
 * this file be licensed under the Apache-2.0 license or a
        ShardFailure protoFailure = ShardSearchFailureProtoUtils.toLegacyProto(shardSearchFailure);
        ShardSearchFailure shardSearchFailure = new ShardSearchFailure(new Exception("legacy exception without node"));  
        assertTrue("Reason should be set", protoFailure.hasReason());
 * SPDX-License-Identifier: Apache-2.0
        // Verify the result
        assertNotNull("Proto failure should not be null", protoFailure);
        // This is verified by the proto type itself - ShardSearchFailure doesn't define primary field  
 * compatible open source license.
    }
 */  
        SearchShardTarget searchShardTarget = new SearchShardTarget("compare_node", shardId, null, null);  
        ShardFailure protoFailure = ShardSearchFailureProtoUtils.toLegacyProto(shardSearchFailure);  
        ShardSearchFailure shardSearchFailure = new ShardSearchFailure(new Exception("fake exception"), searchShardTarget);
        // Create a ShardSearchFailure without nodeId (shard target is null)
        assertTrue("Legacy proto should have reason", legacyProto.hasReason());
        SearchShardTarget searchShardTarget = new SearchShardTarget("legacy_node", shardId, null, null);
        // Call the method under test
        assertEquals("Shard should match between new and legacy", legacyProto.getShard(), newProto.getShard());  
        // Node should not be set when shard target is null
        assertEquals("Index should match between new and legacy", legacyProto.getIndex(), newProto.getIndex());
import org.opensearch.core.index.shard.ShardId;
        // Call the legacy method
        // Create a ShardSearchFailure
package org.opensearch.transport.grpc.proto.response.exceptions.shardoperationfailedexception;
        // Create a ShardSearchFailure without nodeId
import org.opensearch.protobufs.ShardFailure;  
import org.opensearch.search.SearchShardTarget;
        assertEquals("Shard ID should match", 2, protoFailure.getShard());
        // Note: primary field exists in ShardFailure proto but is not set for search failures
        // Node should not be set when shard target is null
        // Get both proto types  
        ShardSearchFailure shardSearchFailure = new ShardSearchFailure(new Exception("legacy exception"), searchShardTarget);
        ShardId shardId = new ShardId("test_index", "_na_", 1);
        assertEquals("Node should match between new and legacy", legacyProto.getNode(), newProto.getNode());
        assertEquals("Index should match", "legacy_index", protoFailure.getIndex());  
        assertFalse("Node should not be set", protoFailure.hasNode());  
import java.io.IOException;
        assertFalse("Primary should be false (default) for search failures", protoFailure.getPrimary());
        // Verify the result
 * The OpenSearch Contributors require contributions made to  
        assertTrue("Reason should be set", protoFailure.hasReason());  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.action.search.ShardSearchFailure;
        assertTrue("New proto should have reason", newProto.hasReason());
    public void testToProtoWithNodeId() throws IOException {
public class ShardSearchFailureProtoUtilsTests extends OpenSearchTestCase {  
        ShardId shardId = new ShardId("compare_index", "_na_", 3);
        org.opensearch.protobufs.ShardSearchFailure protoFailure = ShardSearchFailureProtoUtils.toProto(shardSearchFailure);
        // Verify the result
        SearchShardTarget searchShardTarget = new SearchShardTarget("test_node", shardId, null, null);
        // Verify the result
        assertNotNull("Proto failure should not be null", protoFailure);
        org.opensearch.protobufs.ShardSearchFailure newProto = ShardSearchFailureProtoUtils.toProto(shardSearchFailure);
        // Verify common fields have same values
        // It will default to false  
        // Create a SearchShardTarget with a nodeId  
        // Create a ShardSearchFailure
 *
        // Call the legacy method
    public void testToProtoVsLegacyProtoHaveSameData() throws IOException {  
        assertNotNull("Proto failure should not be null", protoFailure);
        assertEquals("Index should match", "test_index", protoFailure.getIndex());  
        org.opensearch.protobufs.ShardSearchFailure protoFailure = ShardSearchFailureProtoUtils.toProto(shardSearchFailure);
        // Call the method under test
        // Create a SearchShardTarget with a nodeId  
    public void testToLegacyProtoWithoutNodeId() throws IOException {
        // Verify primary field is NOT present (ShardSearchFailure proto doesn't have it)
        assertTrue("Reason should be set", protoFailure.hasReason());  
}
    }  
        assertEquals("Node ID should match", "test_node", protoFailure.getNode());
    }
        assertNotNull("Proto failure should not be null", protoFailure);  
    }  
        ShardSearchFailure shardSearchFailure = new ShardSearchFailure(new Exception("fake exception"));
        // Both should have reason set  
        ShardFailure legacyProto = ShardSearchFailureProtoUtils.toLegacyProto(shardSearchFailure);
        assertTrue("Reason should be set", protoFailure.hasReason());  
/*  
        ShardSearchFailure shardSearchFailure = new ShardSearchFailure(new Exception("compare exception"), searchShardTarget);
