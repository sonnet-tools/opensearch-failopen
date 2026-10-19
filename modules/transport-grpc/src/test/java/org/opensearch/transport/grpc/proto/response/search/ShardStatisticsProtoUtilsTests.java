        assertFalse("Skipped should not be set when negative", stats.hasSkipped());  
        // Old client can extract all necessary information
        // Other failure types would only populate the legacy failures field
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(1, 0, 0, 1, failures);
        assertEquals("Failed shards should match", 1, stats.getFailed());
        assertEquals("New failures_2 field should have 1 entry (only ShardSearchFailure)", 1, stats.getFailures2Count());
        assertTrue("New client should see failures in new field", stats.getFailures2Count() > 0);
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { searchFailure };
     * Integration test: Simulates old client reading from deprecated 'failures' field.
        assertEquals("Successful shards should match", 8, stats.getSuccessful());
        // Old client reads from 'failures' field
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure1, failure2 };
        assertEquals("Failures list should be empty", 0, stats.getFailuresCount());
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 9, -1, 1, new ShardOperationFailedException[0]);
        ShardSearchFailure failure2 = new ShardSearchFailure(new RuntimeException("OOM on shard 1"), target2);
    }
        // Verify the legacy field contains a ShardFailure proto
    }
     */  
}  
        assertEquals("Legacy failures field should have 1 entry", 1, stats.getFailuresCount());
 * The OpenSearch Contributors require contributions made to  
        SearchShardTarget target3 = new SearchShardTarget("node3", shard3, null, null);
        assertEquals(  
        assertEquals("Legacy failure index should match", "compat_index", legacyFailure.getIndex());
        assertEquals("Successful shards should match", 9, stats.getSuccessful());
        // New client can extract all necessary information
        ShardId shardId1 = new ShardId("mixed_index", "_na_", 1);
     * which uses ShardSearchFailure proto type (without primary field).
        ShardId shardId = new ShardId("migration_test", "_na_", 9);  
        org.opensearch.protobufs.ShardFailure legacyFailure = stats.getFailures(0);  
        assertEquals("Failures2 list should be empty when null", 0, stats.getFailures2Count());  
        SearchShardTarget target1 = new SearchShardTarget("node1", shardId1, null, null);  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("New client can read shard", 7, newFailure.getShard());
        assertEquals("Total shards should match", 10, stats.getTotal());
        assertNotNull("Legacy failure should not be null", legacyFailure);
        ShardId shardId1 = new ShardId("test_index", "_na_", 1);
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure };
    }
        // so there's no confusion about whether it's required or what it means for search failures  
        assertTrue("Legacy field should be populated during migration", stats.getFailuresCount() > 0);  
        ShardSearchFailure failure1 = new ShardSearchFailure(new RuntimeException("Timeout on shard 0"), target1);
        assertEquals("Failed shards should be 0", 0, stats.getFailed());  
public class ShardStatisticsProtoUtilsTests extends OpenSearchTestCase {
            org.opensearch.protobufs.ShardFailure legacyFailure = stats.getFailures(i);
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure };
        ShardSearchFailure failure = new ShardSearchFailure(new Exception("old client error"), target);
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 10, 0, 0, new ShardOperationFailedException[0]);
        assertEquals("Failed shards should match", 1, stats.getFailed());
    }
        // Execute: Convert to proto
        org.opensearch.protobufs.ShardSearchFailure newFailure = stats.getFailures2(0);
        // Get stats  
            stats.getFailuresCount(),
        ShardSearchFailure failure1 = new ShardSearchFailure(new Exception("failure 1"), target1);
        assertTrue("New failures_2 field should have entries", stats.getFailures2Count() > 0);  
        assertEquals("New failure index should match", "compat_index", newFailure.getIndex());  
    /**
        assertEquals("Total shards should match", 10, stats.getTotal());  
        SearchShardTarget target = new SearchShardTarget("old_node", shardId, null, null);  
    public void testGetShardStatsWithShardSearchFailures() throws IOException {  
    }  
        ShardId shardId = new ShardId("compat_index", "_na_", 3);  
        // For this test, we're only testing ShardSearchFailure since that's what populates failures_2  
        ShardId shard1 = new ShardId("index1", "_na_", 0);
        // New client reads from 'failures_2' field
        assertTrue("Legacy failures field should have entries", stats.getFailuresCount() > 0);
 *
        assertEquals("Index should match between old and new", legacyFailure.getIndex(), newFailure.getIndex());
        assertTrue("Legacy failures should have at least one entry", stats.getFailuresList().size() > 0);
        ShardSearchFailure failure = new ShardSearchFailure(new Exception("new client error"), target);
        // Note: Old client will see primary=false (default), which is acceptable for search failures
        // Verify both the legacy failures field and new failures_2 field are populated
        assertEquals("Total shards should match", 10, stats.getTotal());
        SearchShardTarget target2 = new SearchShardTarget("node2", shardId2, null, null);
        assertTrue("New failures_2 should have at least one entry", stats.getFailures2List().size() > 0);  
        assertEquals("Failures2 list should be empty", 0, stats.getFailures2Count());
    }
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 8, 0, 2, failures);
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 8, 1, 1, new ShardOperationFailedException[0]);
        ShardId shard3 = new ShardId("index3", "_na_", 2);
        assertEquals("Legacy failures field should have 1 entry", 1, stats.getFailuresCount());
import org.opensearch.protobufs.ShardStatistics;
import org.opensearch.search.SearchShardTarget;
        assertEquals("Failed shards should match", 1, stats.getFailed());  
     * Integration test: Simulates new client reading from 'failures_2' field
    public void testGetShardStatsWithNoSkipped() throws IOException {  
        assertEquals("New failures_2 field should have 1 entry", 1, stats.getFailures2Count());
    public void testGetShardStatsWithMixedFailureTypes() throws IOException {  
    public void testOldClientCanReadLegacyField() throws IOException {
        // Create a ShardSearchFailure
        ShardId shardId = new ShardId("new_client_test", "_na_", 7);
        assertTrue("Old client can read reason", legacyFailure.hasReason());  
        ShardId shard2 = new ShardId("index2", "_na_", 1);  
        assertEquals("Both clients see same index", legacyFailure.getIndex(), newFailure.getIndex());  
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure };  
            assertNotNull("Legacy failure " + i + " should not be null", legacyFailure);
        assertEquals("Old client can read node", "old_node", legacyFailure.getNode());
        // The new failures_2 field should only have ShardSearchFailure instances
        assertNotNull("New failure should not be null", newFailure);
        ShardSearchFailure failure = new ShardSearchFailure(new Exception("migration error"), target);
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 9, 0, 1, null);  
        // Verify both fields are populated  
        assertEquals("New failure shard should match", 3, newFailure.getShard());
        // Verify: Both fields should be populated
        assertNotNull("New clients can deserialize new field", newFailure);  
        ShardSearchFailure failure = new ShardSearchFailure(new Exception("compat failure"), target);
        ShardId shardId = new ShardId("old_client_test", "_na_", 5);
        SearchShardTarget target1 = new SearchShardTarget("node1", shardId1, null, null);  
        assertTrue("New client can read reason", newFailure.hasReason());  
    /**  
        assertEquals("Skipped shards should match", 1, stats.getSkipped());
    public void testDualFieldPopulationWithMultipleFailures() throws IOException {  
import org.opensearch.core.action.ShardOperationFailedException;
     */
        ShardSearchFailure failure2 = new ShardSearchFailure(new Exception("failure 2"), target2);
        assertEquals("Old client can read shard", 5, legacyFailure.getShard());
        assertNotNull("Old clients can still deserialize", legacyFailure);
        SearchShardTarget target2 = new SearchShardTarget("node2", shard2, null, null);
        // Get stats  
        assertEquals("Failed shards should match", 2, stats.getFailed());
        assertTrue("New field should be populated during migration", stats.getFailures2Count() > 0);
            assertEquals("Shard should match between legacy and new at position " + i, legacyFailure.getShard(), newFailure.getShard());
import org.opensearch.action.search.ShardSearchFailure;
import org.opensearch.core.index.shard.ShardId;  
    }
        assertEquals("Old client can read index", "old_client_test", legacyFailure.getIndex());  
 * compatible open source license.
            org.opensearch.protobufs.ShardSearchFailure newFailure = stats.getFailures2(i);
        SearchShardTarget target = new SearchShardTarget("compat_node", shardId, null, null);
    public void testGetShardStatsWithNoFailures() throws IOException {
     * Integration test: Demonstrates gradual migration support where both
        assertEquals("Node should match between old and new", legacyFailure.getNode(), newFailure.getNode());  
        ShardId shardId2 = new ShardId("test_index", "_na_", 2);  
        assertEquals("Successful shards should match", 9, stats.getSuccessful());  
            stats.getFailures2Count()  
import org.opensearch.test.OpenSearchTestCase;  
        assertFalse("Primary defaults to false for search failures", legacyFailure.getPrimary());  
        assertEquals("New client can read index", "new_client_test", newFailure.getIndex());  
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(1, 0, 0, 1, failures);
        ShardSearchFailure failure3 = new ShardSearchFailure(new RuntimeException("Circuit breaker on shard 2"), target3);  
     * with multiple shard search failures for backward compatibility.
    /**
        // Both get correct data
        // For ShardSearchFailure, both should have the same count
     * Integration test: Verifies that both old and new fields are populated  
        assertEquals("New client can read node", "new_node", newFailure.getNode());
    /**  
    }  
package org.opensearch.transport.grpc.proto.response.search;
    public void testGetShardStatsPopulatesBothFieldsForBackwardCompatibility() throws IOException {
    public void testGradualMigrationSupport() throws IOException {
            assertEquals("Node should match between legacy and new at position " + i, legacyFailure.getNode(), newFailure.getNode());  
 */  
     * old and new clients can work simultaneously during the transition period.
        // Both fields are populated
    public void testNewClientCanReadNewField() throws IOException {
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure1, failure2, failure3 };
    }
        // When skipped is negative, it should not be set
        // Setup: Create multiple shard search failures
/*  
     */  
        assertEquals("Should have 3 failures in new field", 3, stats.getFailures2Count());  
        assertEquals("Shard should match between old and new", legacyFailure.getShard(), newFailure.getShard());
            assertNotNull("New failure " + i + " should not be null", newFailure);
        SearchShardTarget target = new SearchShardTarget("migration_node", shardId, null, null);
        // Old clients continue working (read from failures)  
 * SPDX-License-Identifier: Apache-2.0
        // Verify common fields match between old and new  
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 7, 0, 3, failures);
        // During migration: Some clients use old proto, some use new proto
        assertEquals("Successful shards should match", 10, stats.getSuccessful());
        assertEquals("Total shards should match", 10, stats.getTotal());  
        // New client benefits from not having the 'primary' field in the proto definition
        // The legacy field should have all failures
        }
        for (int i = 0; i < stats.getFailuresCount(); i++) {  
        org.opensearch.protobufs.ShardSearchFailure newFailure = stats.getFailures2(0);  
            "Both failures fields should have same count for search failures",
        assertEquals("Failures list should be empty when null", 0, stats.getFailuresCount());
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(5, 4, 0, 1, failures);
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(5, 4, 0, 1, failures);
    public void testGetShardStatsBasicFields() throws IOException {  
    }
        // Get stats
        assertEquals("Should have 3 failures in legacy field", 3, stats.getFailuresCount());
        // New clients can start using new field (read from failures_2)
        // Create ShardSearchFailure instances
        SearchShardTarget target = new SearchShardTarget("new_node", shardId, null, null);  
        org.opensearch.protobufs.ShardSearchFailure newFailure = stats.getFailures2(0);
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure };  
        );
        // Create a ShardSearchFailure (will populate both fields)
import java.io.IOException;
        SearchShardTarget target1 = new SearchShardTarget("node1", shard1, null, null);  
            assertEquals("Index should match between legacy and new at position " + i, legacyFailure.getIndex(), newFailure.getIndex());
        assertEquals("Successful shards should match", 8, stats.getSuccessful());
        org.opensearch.protobufs.ShardFailure legacyFailure = stats.getFailures(0);  
        ShardSearchFailure searchFailure = new ShardSearchFailure(new Exception("search failure"), target1);
    public void testGetShardStatsWithNullFailures() throws IOException {
        assertTrue("Old client should see failures in legacy field", stats.getFailuresCount() > 0);
     */  
        // Verify the new field contains a ShardSearchFailure proto
        org.opensearch.protobufs.ShardFailure legacyFailure = stats.getFailures(0);
    }
        assertEquals("Legacy failure shard should match", 3, legacyFailure.getShard());  
        // Verify: Data consistency between old and new fields
        assertEquals("Total shards should match", 10, stats.getTotal());
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(2, 1, 0, 1, failures);  
        assertEquals("Both clients see same shard", legacyFailure.getShard(), newFailure.getShard());
