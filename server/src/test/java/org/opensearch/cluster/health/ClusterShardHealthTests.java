                    instance.getInitializingShards(),
    }
                    Collections.emptySet()
                    instance.isPrimaryActive()
                0,
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
     * the remote store mid-hydration.
        assertEquals(ClusterHealthStatus.RED, ClusterShardHealth.getInactivePrimaryHealth(unassignedRemoteRestore));
 *
                    Arrays.stream(ClusterHealthStatus.values())
    protected ClusterShardHealth doParseInstance(XContentParser parser) throws IOException {
                    .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
            case "shardId":
                    instance.getRelocatingShards() + between(1, 10),
    /**
            randomInt(1000),
        );
                    instance.isPrimaryActive()
                "auto-restoring from remote store",
        assertEquals(2, clusterShardHealth.getUnassignedShards());
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
    }
                false,
    protected ClusterShardHealth createTestInstance() {
public class ClusterShardHealthTests extends AbstractSerializingTestCase<ClusterShardHealth> {
        indexShardRoutingBuilder.addShard(
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            recoverySource,
        indexShardRoutingBuilder.addShard(
 * SPDX-License-Identifier: Apache-2.0
                );
                    instance.getStatus(),
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(0, clusterShardHealth.getUnassignedShards());
        assertFalse(clusterShardHealth.isPrimaryActive());
    protected ClusterShardHealth mutateInstance(final ClusterShardHealth instance) {
     */
                    Collections.emptySet()
                    instance.isPrimaryActive()
                shardId,
                    instance.getInitializingShards(),
                );
                    false,
                    instance.getShardId(),
            recoverySource,
        assertEquals(ClusterHealthStatus.GREEN, clusterShardHealth.getStatus());
        assertEquals(0, clusterShardHealth.getRelocatingShards());
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)
                true,
    }
package org.opensearch.cluster.health;
    @Override
                    "node_4 left",
                    instance.getStatus(),
    public void testClusterShardRedHealth() {
            case "status":
            ShardRouting.newUnassigned(
        );
        indexShardRoutingBuilder.addShard(
 * The OpenSearch Contributors require contributions made to
            "initializingShards",
    protected boolean supportsUnknownFields() {
                    instance.getRelocatingShards(),
                Settings.builder()
                    instance.getUnassignedShards(),
        return true;
                Settings.builder()
                    instance.getInitializingShards() + between(1, 10),
            TestShardRouting.newShardRouting(indexName, shardID, "node_1", null, false, ShardRoutingState.STARTED)
            )
                0,
                    instance.getShardId(),
                    UnassignedInfo.Reason.NODE_LEFT,
        IndexMetadata indexMetadata = indexMetadataBuilder.build();
                    0,
 * specific language governing permissions and limitations
            default:
            new UnassignedInfo(
        assertEquals(0, clusterShardHealth.getInitializingShards());
 * software distributed under the License is distributed on an
        IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingBuilder.build();
 * ownership. Elasticsearch licenses this file to you under
        ClusterShardHealth clusterShardHealth = new ClusterShardHealth(shardID, indexShardRoutingTable, indexMetadata);
                    instance.getActiveShards(),
                    instance.getStatus(),
        indexShardRoutingBuilder.addShard(
    }
            )
            )
                );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    instance.getShardId(),
    }
            case "activeShards":
import org.opensearch.core.xcontent.XContentParser;
                )
                return new ClusterShardHealth(
            case "relocatingShards":
            randomInt(1000),
import org.opensearch.core.index.shard.ShardId;
                );
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        int shardID = 0;
                    instance.getInitializingShards(),
                    instance.getUnassignedShards(),
            ShardRouting.newUnassigned(
            .settings(
        ShardId shardId = new ShardId(index, shardID);
        indexShardRoutingBuilder.addShard(
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        );
            TestShardRouting.newShardRouting(indexName, shardID, "node_0", null, true, ShardRoutingState.STARTED)
            randomBoolean()
        assertEquals(2, clusterShardHealth.getActiveShards());
/*
        );
                    instance.getRelocatingShards(),
        );
        assertEquals(1, clusterShardHealth.getInitializingShards());
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    instance.getActiveShards(),
                    instance.getShardId(),
        String mutate = randomFrom(
                0,
    @Override
 */
 * KIND, either express or implied.  See the License for the
}
 *
                        .collect(Collectors.toList())
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                    instance.getActiveShards(),
        );
    }
        assertEquals(2, clusterShardHealth.getUnassignedShards());
        ShardId shardId = new ShardId(index, shardID);
            case "primaryActive":
/*
import org.opensearch.cluster.routing.RecoverySource;
            case "unassignedShards":
            .settings(
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            );
            TestShardRouting.newShardRouting(indexName, shardID, "node_1", "node_5", false, ShardRoutingState.RELOCATING)
 * compatible open source license.
                    instance.getActiveShards(),
 * Modifications Copyright OpenSearch Contributors. See
     * cannot serve queries until recovery completes, so YELLOW would overstate availability - even though the data is
        return randomShardHealth(randomInt(1000));
        );
                ClusterHealthStatus status = randomFrom(
            Version.CURRENT,
        RecoverySource.RemoteStoreRecoverySource recoverySource = new RecoverySource.RemoteStoreRecoverySource(
    @Override
                RecoverySource.PeerRecoverySource.INSTANCE,
                    instance.getActiveShards() + between(1, 10),
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)
            .settings(
                return new ClusterShardHealth(
        // a failed allocation stays RED as well, with or without a remote-store source
import org.opensearch.core.common.io.stream.Writeable;
    @Override
        indexShardRoutingBuilder.addShard(
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                false,
            )
                null,
import java.util.UUID;
                    instance.isPrimaryActive()
 * license agreements. See the NOTICE file distributed with
    }
                    instance.isPrimaryActive() == false
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                return new ClusterShardHealth(
    protected Writeable.Reader<ClusterShardHealth> instanceReader() {
                    instance.getUnassignedShards(),
                UnassignedInfo.Reason.NODE_LEFT,
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                    instance.getShardId(),
        indexShardRoutingBuilder.addShard(
import org.opensearch.cluster.routing.ShardRouting;
                new UnassignedInfo(
            "activeShards",
    @Override
        assertEquals(ClusterHealthStatus.YELLOW, clusterShardHealth.getStatus());
                Settings.builder()
        assertEquals(ClusterHealthStatus.RED, ClusterShardHealth.getShardHealth(null, 0, 0, indexMetadata));
 *     http://www.apache.org/licenses/LICENSE-2.0
            .creationDate(System.currentTimeMillis());
            )
        indexShardRoutingBuilder.addShard(
                    true,
            "primaryActive"
import org.opensearch.core.index.Index;
        assertEquals(1, clusterShardHealth.getRelocatingShards());
        indexShardRoutingBuilder.addShard(
    }
    @Override
            )
            UUID.randomUUID().toString(),
            TestShardRouting.newShardRouting(indexName, shardID, null, null, false, ShardRoutingState.UNASSIGNED)
                    "node_4 left",
 * You may obtain a copy of the License at
    public void testShardRoutingNullCheck() {
            TestShardRouting.newShardRouting(indexName, shardID, "node_0", null, true, ShardRoutingState.STARTED)
            "unassignedShards",
                false,
                RecoverySource.PeerRecoverySource.INSTANCE,
                )
        );
            .creationDate(System.currentTimeMillis());
        );
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                    0,
                    instance.getStatus(),
            true,
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor
        String indexName = "test";
                    null,
        return ClusterShardHealth.fromXContent(parser);
                    instance.getUnassignedShards(),
import org.opensearch.cluster.routing.ShardRoutingState;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
 * not use this file except in compliance with the License.
            true,
                return new ClusterShardHealth(
            )
     * converges without operator action. Revisit when warm/searchable-remote shards can serve queries directly off
                    instance.getShardId(),
    }
    public void testRemoteStoreRestorePrimaryIsRedUntilStarted() {
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                    instance.getRelocatingShards(),
        IndexMetadata searchOnlyMetadata = searchOnlyMetadataBuilder.build();
        );
                    0,
            randomInt(1000),
                Collections.emptySet()
        ShardId shardId = new ShardId(index, shardID);
import java.io.IOException;
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import java.util.stream.Collectors;
                    0,
                Collections.emptySet()
 *
        int shardID = 0;
                    instance.getActiveShards(),
        assertEquals(ClusterHealthStatus.RED, clusterShardHealth.getStatus());
            randomInt(1000),
                0,
                    instance.isPrimaryActive()
        assertEquals(0, clusterShardHealth.getInitializingShards());
                    instance.getRelocatingShards(),
                    instance.getInitializingShards(),
 * under the License.
                    instance.getRelocatingShards(),
import org.opensearch.common.settings.Settings;
    public void testClusterShardYellowHealth() {
            TestShardRouting.newShardRouting(indexName, shardID, null, null, false, ShardRoutingState.UNASSIGNED)
/*
        ShardRouting failedOnce = ShardRouting.newUnassigned(
            .settings(
        IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingBuilder.build();
        switch (mutate) {
import org.opensearch.cluster.routing.TestShardRouting;
            new UnassignedInfo(
                    instance.getUnassignedShards(),
 */
        return ClusterShardHealth::new;
                    instance.isPrimaryActive()
                    instance.getActiveShards(),
import java.util.Arrays;
        ClusterShardHealth clusterShardHealth = new ClusterShardHealth(shardID, indexShardRoutingTable, indexMetadata);
                throw new UnsupportedOperationException();
                return new ClusterShardHealth(
            "relocatingShards",
            TestShardRouting.newShardRouting(indexName, shardID, "node_2", null, false, ShardRoutingState.INITIALIZING)
import org.opensearch.test.AbstractSerializingTestCase;
                        .filter(value -> !value.equals(instance.getStatus()))
            "shardId",
    }
            case "initializingShards":
                1,
        assertTrue(clusterShardHealth.isPrimaryActive());
        // When search-only is not enabled (default), expect RED status
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                Settings.builder()
                    instance.getStatus(),
            new ShardId(new Index("test", UUID.randomUUID().toString()), 0),
                    instance.getShardId() + between(1, 10),
            id,
        IndexMetadata indexMetadata = indexMetadataBuilder.build();
import java.util.Collections;
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            new ShardId(new Index("test", UUID.randomUUID().toString()), 0),
        ShardRouting unassignedRemoteRestore = ShardRouting.newUnassigned(
        assertEquals(0, clusterShardHealth.getDelayedUnassignedShards());
    }
        assertEquals(0, clusterShardHealth.getActiveShards());
        );
                "boom",
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
                0,
        // don't inject random fields at the root, which contains arbitrary shard ids
        IndexMetadata.Builder searchOnlyMetadataBuilder = IndexMetadata.builder("test")
                shardId,
            new org.opensearch.repositories.IndexId("test", UUID.randomUUID().toString())
        assertEquals(ClusterHealthStatus.GREEN, ClusterShardHealth.getShardHealth(null, 0, 0, searchOnlyMetadata));
     * durable and the restore (auto-restore of a primary with no surviving copy, or a manual _remotestore/_restore)
                    0,
                );
        String indexName = "test";
                return new ClusterShardHealth(
                );
                    UnassignedInfo.AllocationStatus.NO_ATTEMPT,
                    instance.getRelocatingShards(),
        return new ClusterShardHealth(
        );
import org.opensearch.Version;
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)
                    0,
                new UnassignedInfo(
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Index index = new Index(indexName, UUID.randomUUID().toString());
                );
                    UnassignedInfo.Reason.NODE_LEFT,
        assertEquals(0, clusterShardHealth.getDelayedUnassignedShards());
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
                    instance.getUnassignedShards() + between(1, 10),
 * the Apache License, Version 2.0 (the "License"); you may
                Settings.builder()
            "status",
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                UnassignedInfo.Reason.ALLOCATION_FAILED,
 */
                    instance.getStatus(),
                );
        assertEquals(ClusterHealthStatus.YELLOW, ClusterShardHealth.getShardHealth(null, 0, 1, searchOnlyMetadata));
    }
        IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingBuilder.build();
        assertTrue(clusterShardHealth.isPrimaryActive());
                    instance.getUnassignedShards(),
        assertEquals(0, clusterShardHealth.getRelocatingShards());
        assertEquals(2, clusterShardHealth.getActiveShards());
            .creationDate(System.currentTimeMillis());
                    null,
                    instance.getInitializingShards(),
        }
    static ClusterShardHealth randomShardHealth(int id) {
        Index index = new Index(indexName, UUID.randomUUID().toString());
        assertEquals(ClusterHealthStatus.RED, ClusterShardHealth.getInactivePrimaryHealth(failedOnce));
        String indexName = "test";
        IndexMetadata indexMetadata = indexMetadataBuilder.build();
        );
        Index index = new Index(indexName, UUID.randomUUID().toString());
                    UnassignedInfo.AllocationStatus.DECIDERS_NO,
            );
        );
    public void testClusterShardGreenHealth() {
    protected Predicate<String> getRandomFieldsExcludeFilter() {
                null,
                return new ClusterShardHealth(
     * An inactive primary recovering from the remote store deliberately reports RED, not YELLOW: a hydrating primary
        assertEquals(1, clusterShardHealth.getDelayedUnassignedShards());
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder("test")
        ClusterShardHealth clusterShardHealth = new ClusterShardHealth(shardID, indexShardRoutingTable, indexMetadata);
        IndexMetadata indexMetadata = indexMetadataBuilder.build();
                    instance.getInitializingShards(),
                    status,
        // When search-only is enabled, expect GREEN status
 * this file be licensed under the Apache-2.0 license or a
            randomFrom(ClusterHealthStatus.values()),
            .settings(
import java.util.function.Predicate;
import org.opensearch.cluster.routing.UnassignedInfo;
        int shardID = 0;
        return ""::equals;
