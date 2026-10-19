 *  
 * KIND, either express or implied.  See the License for the
                    instance.getActiveShards(),
 * You may obtain a copy of the License at  
        return randomShardHealth(randomInt(1000));
 * software distributed under the License is distributed on an
        assertEquals(2, clusterShardHealth.getUnassignedShards());  
                    instance.getInitializingShards(),  
                    UnassignedInfo.AllocationStatus.DECIDERS_NO,  
 * SPDX-License-Identifier: Apache-2.0
    }
            UUID.randomUUID().toString(),  
        assertEquals(ClusterHealthStatus.YELLOW, clusterShardHealth.getStatus());
                    instance.getUnassignedShards() + between(1, 10),
                    instance.isPrimaryActive()
        String indexName = "test";
            )  
        assertEquals(0, clusterShardHealth.getRelocatingShards());  
        assertEquals(0, clusterShardHealth.getDelayedUnassignedShards());
        assertEquals(2, clusterShardHealth.getActiveShards());
                false,  
        IndexMetadata indexMetadata = indexMetadataBuilder.build();
                );
            new UnassignedInfo(
        // When search-only is enabled, expect GREEN status
            "status",  
                    instance.getUnassignedShards(),  
        indexShardRoutingBuilder.addShard(
                        .filter(value -> !value.equals(instance.getStatus()))  
                    Arrays.stream(ClusterHealthStatus.values())
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)
        );
                    instance.getUnassignedShards(),
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    instance.getStatus(),
                    instance.getInitializingShards(),
                null,  
import org.opensearch.cluster.metadata.IndexMetadata;
        int shardID = 0;
        assertFalse(clusterShardHealth.isPrimaryActive());  
    protected boolean supportsUnknownFields() {
import org.opensearch.core.common.io.stream.Writeable;  
                    0,
            TestShardRouting.newShardRouting(indexName, shardID, "node_0", null, true, ShardRoutingState.STARTED)
    }  
        Index index = new Index(indexName, UUID.randomUUID().toString());  
                    instance.isPrimaryActive()
            .settings(
        String indexName = "test";  
            case "relocatingShards":
                    0,  
        return ""::equals;
                );  
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
                RecoverySource.PeerRecoverySource.INSTANCE,
    public void testClusterShardRedHealth() {
                return new ClusterShardHealth(  
                    instance.getRelocatingShards(),
                Collections.emptySet()
                    instance.getStatus(),
            randomBoolean()  
                    instance.getShardId(),
        assertEquals(0, clusterShardHealth.getActiveShards());  
    @Override
                        .collect(Collectors.toList())
            randomInt(1000),
            recoverySource,
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    protected ClusterShardHealth doParseInstance(XContentParser parser) throws IOException {
                    instance.isPrimaryActive()
            )
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
import org.opensearch.Version;  
        ShardId shardId = new ShardId(index, shardID);  
                    0,
        assertEquals(2, clusterShardHealth.getActiveShards());
import org.opensearch.cluster.routing.UnassignedInfo;
                null,
            case "initializingShards":
                );
        }
        );  
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)
                    instance.getInitializingShards(),
    @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(0, clusterShardHealth.getRelocatingShards());
                    instance.getStatus(),  
                return new ClusterShardHealth(
                    null,  
                return new ClusterShardHealth(  
        assertEquals(0, clusterShardHealth.getDelayedUnassignedShards());
                    Collections.emptySet()  
            );  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    instance.getUnassignedShards(),  
                    instance.getActiveShards(),  
                );
            )
                return new ClusterShardHealth(
                    instance.getActiveShards(),
                    Collections.emptySet()
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                    instance.isPrimaryActive()  
        ClusterShardHealth clusterShardHealth = new ClusterShardHealth(shardID, indexShardRoutingTable, indexMetadata);
            ShardRouting.newUnassigned(  
            new ShardId(new Index("test", UUID.randomUUID().toString()), 0),  
import java.util.Arrays;
        assertEquals(ClusterHealthStatus.RED, ClusterShardHealth.getInactivePrimaryHealth(failedOnce));  
    }
 *
                    UnassignedInfo.Reason.NODE_LEFT,
    /**  
     * the remote store mid-hydration.
                );
            case "status":  
import org.opensearch.core.index.Index;
        ClusterShardHealth clusterShardHealth = new ClusterShardHealth(shardID, indexShardRoutingTable, indexMetadata);  
     * An inactive primary recovering from the remote store deliberately reports RED, not YELLOW: a hydrating primary
                    0,  
import java.util.stream.Collectors;
            true,  
                UnassignedInfo.Reason.ALLOCATION_FAILED,
                shardId,
        ShardId shardId = new ShardId(index, shardID);
 * Modifications Copyright OpenSearch Contributors. See  
            )  
                    instance.getShardId() + between(1, 10),
        Index index = new Index(indexName, UUID.randomUUID().toString());
    protected Writeable.Reader<ClusterShardHealth> instanceReader() {
                    "node_4 left",  
        assertEquals(ClusterHealthStatus.RED, ClusterShardHealth.getShardHealth(null, 0, 0, indexMetadata));
                    false,
                Settings.builder()
                UnassignedInfo.Reason.NODE_LEFT,  
                1,
    }  
    }
                    instance.getRelocatingShards(),  
                    instance.getActiveShards(),  
                return new ClusterShardHealth(
    }
            .settings(
    }
                Settings.builder()  
        IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingBuilder.build();
        return ClusterShardHealth::new;  
                    instance.getInitializingShards(),  
        assertTrue(clusterShardHealth.isPrimaryActive());
            randomFrom(ClusterHealthStatus.values()),
        );
 * this work for additional information regarding copyright
                0,  
            default:
        );  
     * cannot serve queries until recovery completes, so YELLOW would overstate availability - even though the data is
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder("test")
        );
                    UnassignedInfo.Reason.NODE_LEFT,
    }
        );  
    @Override
                Collections.emptySet()  
import org.opensearch.core.xcontent.XContentParser;  
import org.opensearch.cluster.routing.ShardRoutingState;
                0,
import org.opensearch.cluster.routing.ShardRouting;
            recoverySource,
                    instance.getActiveShards() + between(1, 10),
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
                    instance.getUnassignedShards(),  
            case "primaryActive":
            )
                    instance.getShardId(),  
import java.util.UUID;  
                    instance.getStatus(),
            .settings(  
    protected Predicate<String> getRandomFieldsExcludeFilter() {  
        IndexMetadata.Builder searchOnlyMetadataBuilder = IndexMetadata.builder("test")
                true,
            "relocatingShards",
 * compatible open source license.
        switch (mutate) {
    public void testClusterShardGreenHealth() {  
        Index index = new Index(indexName, UUID.randomUUID().toString());
        indexShardRoutingBuilder.addShard(  
                    instance.getShardId(),
        );  
        return true;
/*  
                throw new UnsupportedOperationException();  
                false,
                    "node_4 left",
        assertEquals(0, clusterShardHealth.getUnassignedShards());
                )
                return new ClusterShardHealth(
public class ClusterShardHealthTests extends AbstractSerializingTestCase<ClusterShardHealth> {
                    instance.getUnassignedShards(),
                    true,
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            .creationDate(System.currentTimeMillis());
            case "shardId":
                    instance.getActiveShards(),  
 * Licensed to Elasticsearch under one or more contributor  
        int shardID = 0;  
        ClusterShardHealth clusterShardHealth = new ClusterShardHealth(shardID, indexShardRoutingTable, indexMetadata);
        ShardId shardId = new ShardId(index, shardID);
                    instance.getStatus(),
        assertEquals(1, clusterShardHealth.getDelayedUnassignedShards());  
        IndexMetadata searchOnlyMetadata = searchOnlyMetadataBuilder.build();
        return new ClusterShardHealth(
    protected ClusterShardHealth createTestInstance() {  
    }
        );  
        IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingBuilder.build();
                    instance.getActiveShards(),
/*
                    instance.getRelocatingShards(),
                    instance.getRelocatingShards(),
 */
        int shardID = 0;
import org.opensearch.common.settings.Settings;
        assertEquals(ClusterHealthStatus.GREEN, clusterShardHealth.getStatus());  
                0,
 */  
            .creationDate(System.currentTimeMillis());
            "shardId",
                0,  
import org.opensearch.core.index.shard.ShardId;
                );
import org.opensearch.cluster.routing.RecoverySource;  
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(ClusterHealthStatus.RED, clusterShardHealth.getStatus());
    @Override  
        ShardRouting unassignedRemoteRestore = ShardRouting.newUnassigned(
            TestShardRouting.newShardRouting(indexName, shardID, "node_1", null, false, ShardRoutingState.STARTED)
 * this file be licensed under the Apache-2.0 license or a
    @Override
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
    static ClusterShardHealth randomShardHealth(int id) {
                return new ClusterShardHealth(  
                shardId,  
            .settings(
                    .put(IndexMetadata.INDEX_BLOCKS_SEARCH_ONLY_SETTING.getKey(), true)
                    instance.getStatus(),  
            "activeShards",
        assertEquals(ClusterHealthStatus.RED, ClusterShardHealth.getInactivePrimaryHealth(unassignedRemoteRestore));
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
     * durable and the restore (auto-restore of a primary with no surviving copy, or a manual _remotestore/_restore)  
                "boom",
import org.opensearch.test.AbstractSerializingTestCase;
        assertEquals(0, clusterShardHealth.getInitializingShards());
                    status,
        indexShardRoutingBuilder.addShard(
        indexShardRoutingBuilder.addShard(  
            true,
        indexShardRoutingBuilder.addShard(
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
                Settings.builder()  
        RecoverySource.RemoteStoreRecoverySource recoverySource = new RecoverySource.RemoteStoreRecoverySource(
                    instance.isPrimaryActive()
                );  
    public void testClusterShardYellowHealth() {
        indexShardRoutingBuilder.addShard(
 * under the License.  
import java.util.function.Predicate;
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    instance.getShardId(),
    }  
        IndexMetadata indexMetadata = indexMetadataBuilder.build();  
        );  
                )
        );
import java.util.Collections;
            Version.CURRENT,
        return ClusterShardHealth.fromXContent(parser);
            id,  
                    instance.getRelocatingShards(),
                    UnassignedInfo.AllocationStatus.NO_ATTEMPT,
                    instance.isPrimaryActive()
                    instance.getUnassignedShards(),
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        // a failed allocation stays RED as well, with or without a remote-store source
        );  
        String mutate = randomFrom(
                false,
            TestShardRouting.newShardRouting(indexName, shardID, null, null, false, ShardRoutingState.UNASSIGNED)
            )
                    instance.isPrimaryActive() == false  
        );
                Settings.builder()
                    instance.getShardId(),  
                "auto-restoring from remote store",
            new org.opensearch.repositories.IndexId("test", UUID.randomUUID().toString())
        IndexMetadata indexMetadata = indexMetadataBuilder.build();  
/*
        );
            )  
                );
        assertTrue(clusterShardHealth.isPrimaryActive());
 * The OpenSearch Contributors require contributions made to  
                UnassignedInfo.AllocationStatus.NO_ATTEMPT,
            new ShardId(new Index("test", UUID.randomUUID().toString()), 0),
            case "unassignedShards":  
        indexShardRoutingBuilder.addShard(
     */  
                    instance.getInitializingShards(),
        assertEquals(0, clusterShardHealth.getInitializingShards());
        // don't inject random fields at the root, which contains arbitrary shard ids
        indexShardRoutingBuilder.addShard(
                new UnassignedInfo(
        IndexMetadata.Builder indexMetadataBuilder = IndexMetadata.builder(indexName)  
                RecoverySource.PeerRecoverySource.INSTANCE,  
        // When search-only is not enabled (default), expect RED status
            "unassignedShards",
        String indexName = "test";
        IndexMetadata indexMetadata = indexMetadataBuilder.build();
                    null,
            ShardRouting.newUnassigned(
                    instance.getInitializingShards() + between(1, 10),
 * Unless required by applicable law or agreed to in writing,
            "initializingShards",  
            randomInt(1000),  
    public void testShardRoutingNullCheck() {  
    }  
                    0,
 * ownership. Elasticsearch licenses this file to you under  
            "primaryActive"
 * license agreements. See the NOTICE file distributed with
    }
        );
 * GitHub history for details.
            TestShardRouting.newShardRouting(indexName, shardID, null, null, false, ShardRoutingState.UNASSIGNED)  
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            randomInt(1000),
            .creationDate(System.currentTimeMillis());
                    0,
        indexShardRoutingBuilder.addShard(
        assertEquals(ClusterHealthStatus.GREEN, ClusterShardHealth.getShardHealth(null, 0, 0, searchOnlyMetadata));  
        assertEquals(1, clusterShardHealth.getInitializingShards());  
            randomInt(1000),
                    instance.getShardId(),
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);
                new UnassignedInfo(  
                    instance.getRelocatingShards(),
            case "activeShards":  
            .settings(
     * converges without operator action. Revisit when warm/searchable-remote shards can serve queries directly off
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    protected ClusterShardHealth mutateInstance(final ClusterShardHealth instance) {  
            TestShardRouting.newShardRouting(indexName, shardID, "node_0", null, true, ShardRoutingState.STARTED)
                    instance.getInitializingShards(),
        IndexShardRoutingTable.Builder indexShardRoutingBuilder = new IndexShardRoutingTable.Builder(shardId);  
        ShardRouting failedOnce = ShardRouting.newUnassigned(
package org.opensearch.cluster.health;
    public void testRemoteStoreRestorePrimaryIsRedUntilStarted() {
    @Override  
 */
            );
                0,
                    instance.getRelocatingShards() + between(1, 10),  
        assertEquals(1, clusterShardHealth.getRelocatingShards());
            TestShardRouting.newShardRouting(indexName, shardID, "node_1", "node_5", false, ShardRoutingState.RELOCATING)
            new UnassignedInfo(  
import org.opensearch.cluster.routing.TestShardRouting;  
                ClusterHealthStatus status = randomFrom(
import java.io.IOException;  
 *
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        IndexShardRoutingTable indexShardRoutingTable = indexShardRoutingBuilder.build();
                Settings.builder()  
        assertEquals(2, clusterShardHealth.getUnassignedShards());
 * the Apache License, Version 2.0 (the "License"); you may
            TestShardRouting.newShardRouting(indexName, shardID, "node_2", null, false, ShardRoutingState.INITIALIZING)
        assertEquals(ClusterHealthStatus.YELLOW, ClusterShardHealth.getShardHealth(null, 0, 1, searchOnlyMetadata));
