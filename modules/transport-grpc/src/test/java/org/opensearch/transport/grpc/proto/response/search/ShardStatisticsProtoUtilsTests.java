        assertEquals("Failures list should be empty", 0, stats.getFailuresCount());
        // New client can extract all necessary information
public class ShardStatisticsProtoUtilsTests extends OpenSearchTestCase {
        // For ShardSearchFailure, both should have the same count
        assertEquals("Both clients see same shard", legacyFailure.getShard(), newFailure.getShard());
     * Integration test: Verifies that both old and new fields are populated
        // Old client can extract all necessary information
    }
        assertFalse("Skipped should not be set when negative", stats.hasSkipped());
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(1, 0, 0, 1, failures);
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 10, 0, 0, new ShardOperationFailedException[0]);
        assertEquals("New client can read node", "new_node", newFailure.getNode());
    }
    }
        SearchShardTarget target1 = new SearchShardTarget("node1", shardId1, null, null);
        assertEquals("New failure shard should match", 3, newFailure.getShard());
        assertEquals("New client can read index", "new_client_test", newFailure.getIndex());
        // New client benefits from not having the 'primary' field in the proto definition
        assertEquals("Total shards should match", 10, stats.getTotal());
        ShardId shardId = new ShardId("compat_index", "_na_", 3);
    public void testGetShardStatsWithNoSkipped() throws IOException {
        // New clients can start using new field (read from failures_2)
        assertTrue("Old client should see failures in legacy field", stats.getFailuresCount() > 0);
        org.opensearch.protobufs.ShardSearchFailure newFailure = stats.getFailures2(0);
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(2, 1, 0, 1, failures);
        // Other failure types would only populate the legacy failures field
        ShardId shardId = new ShardId("migration_test", "_na_", 9);
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("Node should match between old and new", legacyFailure.getNode(), newFailure.getNode());
     * which uses ShardSearchFailure proto type (without primary field).
    public void testGetShardStatsWithShardSearchFailures() throws IOException {
        assertEquals("New failure index should match", "compat_index", newFailure.getIndex());
            assertNotNull("New failure " + i + " should not be null", newFailure);
        assertTrue("New failures_2 field should have entries", stats.getFailures2Count() > 0);
     * Integration test: Simulates old client reading from deprecated 'failures' field.
        // The legacy field should have all failures
            org.opensearch.protobufs.ShardFailure legacyFailure = stats.getFailures(i);
        assertEquals("Total shards should match", 10, stats.getTotal());
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
        assertNotNull("Legacy failure should not be null", legacyFailure);
        // For this test, we're only testing ShardSearchFailure since that's what populates failures_2
    }
    public void testNewClientCanReadNewField() throws IOException {
        // Verify both fields are populated
        SearchShardTarget target3 = new SearchShardTarget("node3", shard3, null, null);
        // Get stats
        // Verify both the legacy failures field and new failures_2 field are populated
        SearchShardTarget target = new SearchShardTarget("new_node", shardId, null, null);
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure };
import org.opensearch.search.SearchShardTarget;
        assertEquals("Failed shards should match", 2, stats.getFailed());
        assertEquals("Failed shards should match", 1, stats.getFailed());
        SearchShardTarget target1 = new SearchShardTarget("node1", shardId1, null, null);
        assertEquals("New client can read shard", 7, newFailure.getShard());
        assertEquals("Successful shards should match", 8, stats.getSuccessful());
        // Create a ShardSearchFailure
import org.opensearch.action.search.ShardSearchFailure;
        assertEquals("Failed shards should be 0", 0, stats.getFailed());
        assertTrue("Legacy failures field should have entries", stats.getFailuresCount() > 0);
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 7, 0, 3, failures);
        assertEquals("Total shards should match", 10, stats.getTotal());
 * compatible open source license.
            "Both failures fields should have same count for search failures",
     * Integration test: Demonstrates gradual migration support where both
        // Get stats
        assertTrue("New client should see failures in new field", stats.getFailures2Count() > 0);
     */
        assertEquals("Successful shards should match", 10, stats.getSuccessful());
        ShardSearchFailure failure = new ShardSearchFailure(new Exception("old client error"), target);
     * old and new clients can work simultaneously during the transition period.
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure };
        assertEquals("Legacy failure index should match", "compat_index", legacyFailure.getIndex());
        ShardId shardId2 = new ShardId("test_index", "_na_", 2);
        // Get stats
        ShardSearchFailure searchFailure = new ShardSearchFailure(new Exception("search failure"), target1);
    public void testOldClientCanReadLegacyField() throws IOException {
        assertEquals("Successful shards should match", 9, stats.getSuccessful());
        assertFalse("Primary defaults to false for search failures", legacyFailure.getPrimary());
        assertNotNull("Old clients can still deserialize", legacyFailure);
        assertEquals("Old client can read node", "old_node", legacyFailure.getNode());
        assertEquals("Should have 3 failures in legacy field", 3, stats.getFailuresCount());
        // The new failures_2 field should only have ShardSearchFailure instances
        assertTrue("New client can read reason", newFailure.hasReason());
            assertEquals("Shard should match between legacy and new at position " + i, legacyFailure.getShard(), newFailure.getShard());
        assertEquals("Old client can read shard", 5, legacyFailure.getShard());
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure };
        assertEquals("Total shards should match", 10, stats.getTotal());
        ShardId shardId = new ShardId("old_client_test", "_na_", 5);
        ShardId shardId1 = new ShardId("test_index", "_na_", 1);
        assertEquals("Skipped shards should match", 1, stats.getSkipped());
        }
        assertEquals("Legacy failures field should have 1 entry", 1, stats.getFailuresCount());
        ShardId shard3 = new ShardId("index3", "_na_", 2);
import org.opensearch.protobufs.ShardStatistics;
        assertEquals("New failures_2 field should have 1 entry", 1, stats.getFailures2Count());
    public void testDualFieldPopulationWithMultipleFailures() throws IOException {
            org.opensearch.protobufs.ShardSearchFailure newFailure = stats.getFailures2(i);
    /**
        SearchShardTarget target2 = new SearchShardTarget("node2", shardId2, null, null);
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(5, 4, 0, 1, failures);
    public void testGetShardStatsWithNoFailures() throws IOException {
        ShardSearchFailure failure3 = new ShardSearchFailure(new RuntimeException("Circuit breaker on shard 2"), target3);
        assertEquals("Total shards should match", 10, stats.getTotal());
package org.opensearch.transport.grpc.proto.response.search;
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 8, 0, 2, failures);
 *
        assertEquals("Shard should match between old and new", legacyFailure.getShard(), newFailure.getShard());
        org.opensearch.protobufs.ShardSearchFailure newFailure = stats.getFailures2(0);
        ShardId shardId = new ShardId("new_client_test", "_na_", 7);
        SearchShardTarget target1 = new SearchShardTarget("node1", shard1, null, null);
    /**
    /**
    }
        // Verify the new field contains a ShardSearchFailure proto
            stats.getFailuresCount(),
        // Old client reads from 'failures' field
        assertEquals("Failures2 list should be empty", 0, stats.getFailures2Count());
        assertEquals("Failures list should be empty when null", 0, stats.getFailuresCount());
        assertEquals("New failures_2 field should have 1 entry (only ShardSearchFailure)", 1, stats.getFailures2Count());
        ShardId shard2 = new ShardId("index2", "_na_", 1);
    }
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 9, 0, 1, null);
    }
        assertTrue("Old client can read reason", legacyFailure.hasReason());
        SearchShardTarget target = new SearchShardTarget("old_node", shardId, null, null);
        assertTrue("New failures_2 should have at least one entry", stats.getFailures2List().size() > 0);
    }
        ShardSearchFailure failure = new ShardSearchFailure(new Exception("compat failure"), target);
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(1, 0, 0, 1, failures);
        // Verify common fields match between old and new
        assertTrue("Legacy failures should have at least one entry", stats.getFailuresList().size() > 0);
        // During migration: Some clients use old proto, some use new proto
     * with multiple shard search failures for backward compatibility.
        // Verify the legacy field contains a ShardFailure proto
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(5, 4, 0, 1, failures);
        assertEquals("Old client can read index", "old_client_test", legacyFailure.getIndex());
        assertEquals("Failed shards should match", 1, stats.getFailed());
        // Verify: Data consistency between old and new fields
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 8, 1, 1, new ShardOperationFailedException[0]);
        // so there's no confusion about whether it's required or what it means for search failures
        assertEquals("Failures2 list should be empty when null", 0, stats.getFailures2Count());
    }
            assertEquals("Index should match between legacy and new at position " + i, legacyFailure.getIndex(), newFailure.getIndex());
        ShardStatistics stats = ShardStatisticsProtoUtils.getShardStats(10, 9, -1, 1, new ShardOperationFailedException[0]);
        org.opensearch.protobufs.ShardFailure legacyFailure = stats.getFailures(0);
        assertEquals("Successful shards should match", 8, stats.getSuccessful());
        ShardId shardId1 = new ShardId("mixed_index", "_na_", 1);
}
        assertTrue("Legacy field should be populated during migration", stats.getFailuresCount() > 0);
    }
            assertEquals("Node should match between legacy and new at position " + i, legacyFailure.getNode(), newFailure.getNode());
        assertEquals("Index should match between old and new", legacyFailure.getIndex(), newFailure.getIndex());
        // Both get correct data
        assertNotNull("New clients can deserialize new field", newFailure);
        ShardSearchFailure failure1 = new ShardSearchFailure(new RuntimeException("Timeout on shard 0"), target1);
        org.opensearch.protobufs.ShardFailure legacyFailure = stats.getFailures(0);
        // Note: Old client will see primary=false (default), which is acceptable for search failures
 */
            stats.getFailures2Count()
        assertEquals("Successful shards should match", 9, stats.getSuccessful());
            assertNotNull("Legacy failure " + i + " should not be null", legacyFailure);
        ShardSearchFailure failure2 = new ShardSearchFailure(new Exception("failure 2"), target2);
        // New client reads from 'failures_2' field
 * The OpenSearch Contributors require contributions made to
        ShardSearchFailure failure1 = new ShardSearchFailure(new Exception("failure 1"), target1);
        assertEquals(
        ShardSearchFailure failure = new ShardSearchFailure(new Exception("new client error"), target);
    }
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure };
        assertEquals("Legacy failures field should have 1 entry", 1, stats.getFailuresCount());
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { searchFailure };
     */
    public void testGetShardStatsPopulatesBothFieldsForBackwardCompatibility() throws IOException {
        // Old clients continue working (read from failures)
        SearchShardTarget target2 = new SearchShardTarget("node2", shard2, null, null);
        assertEquals("Failed shards should match", 1, stats.getFailed());
        ShardSearchFailure failure2 = new ShardSearchFailure(new RuntimeException("OOM on shard 1"), target2);
     * Integration test: Simulates new client reading from 'failures_2' field
    /**
        for (int i = 0; i < stats.getFailuresCount(); i++) {
        ShardId shard1 = new ShardId("index1", "_na_", 0);
        // Setup: Create multiple shard search failures
        );
     */
        assertEquals("Both clients see same index", legacyFailure.getIndex(), newFailure.getIndex());
        assertTrue("New field should be populated during migration", stats.getFailures2Count() > 0);
        // When skipped is negative, it should not be set
/*
        ShardSearchFailure failure = new ShardSearchFailure(new Exception("migration error"), target);
        assertEquals("Should have 3 failures in new field", 3, stats.getFailures2Count());
import org.opensearch.core.action.ShardOperationFailedException;
import org.opensearch.core.index.shard.ShardId;
        // Create ShardSearchFailure instances
        org.opensearch.protobufs.ShardFailure legacyFailure = stats.getFailures(0);
        // Both fields are populated
        // Execute: Convert to proto
    public void testGetShardStatsWithMixedFailureTypes() throws IOException {
    public void testGradualMigrationSupport() throws IOException {
        // Create a ShardSearchFailure (will populate both fields)
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure1, failure2, failure3 };
        assertNotNull("New failure should not be null", newFailure);
     */
        SearchShardTarget target = new SearchShardTarget("compat_node", shardId, null, null);
        org.opensearch.protobufs.ShardSearchFailure newFailure = stats.getFailures2(0);
    public void testGetShardStatsWithNullFailures() throws IOException {
import java.io.IOException;
    public void testGetShardStatsBasicFields() throws IOException {
        assertEquals("Legacy failure shard should match", 3, legacyFailure.getShard());
        // Verify: Both fields should be populated
        SearchShardTarget target = new SearchShardTarget("migration_node", shardId, null, null);
        ShardOperationFailedException[] failures = new ShardOperationFailedException[] { failure1, failure2 };
