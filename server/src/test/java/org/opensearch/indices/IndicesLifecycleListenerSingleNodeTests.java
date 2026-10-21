                assertEquals("test", index.getName());
                assertEquals(3, counter.get());
            @Override
import org.opensearch.cluster.routing.RecoverySource;
                assertEquals(9, counter.get());
            public void beforeIndexRemoved(IndexService indexService, IndexRemovalReason reason) {
        };
            IndexShard shard = index.createShard(
                newRouting,
            newRouting = newRouting.moveToUnassigned(unassignedInfo)
import org.opensearch.cluster.node.DiscoveryNodes;
            public void afterIndexShardDeleted(ShardId shardId, Settings indexSettings) {
                Version.CURRENT
 * compatible open source license.
            newRouting = ShardRoutingHelper.initialize(newRouting, nodeId);
import org.opensearch.index.IndexSettings;
 * license agreements. See the NOTICE file distributed with
 *
        );
                assertEquals(DELETED, reason);
package org.opensearch.indices;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                RetentionLeaseSyncer.EMPTY,
 */
            public void afterIndexShardStarted(IndexShard indexShard) {
 * Modifications Copyright OpenSearch Contributors. See
            public void afterIndexCreated(IndexService indexService) {
            IndexService index = indicesService.createIndex(metadata, Arrays.asList(countingListener), false);
        assertEquals(10, counter.get());
import org.opensearch.core.index.Index;
        IndexEventListener countingListener = new IndexEventListener() {
import org.opensearch.index.shard.IndexShard;
                assertEquals(DELETED, reason);
import org.opensearch.index.IndexService;
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
            indicesService.removeIndex(idx, DELETED, "simon says");
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.DELETED;
                assertEquals(4, counter.get());
import java.util.concurrent.atomic.AtomicInteger;
        } finally {
import static java.util.Collections.emptySet;
                MergedSegmentPublisher.EMPTY,
 * The OpenSearch Contributors require contributions made to
            );
            }
    }
import org.opensearch.test.OpenSearchSingleNodeTestCase;
import java.util.Arrays;
import org.opensearch.core.index.shard.ShardId;
 */
                assertEquals(6, counter.get());
                null,
            }
            UnassignedInfo unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "boom");
            public void afterIndexShardCreated(IndexShard indexShard) {
                counter.incrementAndGet();
}
                null,
            idx = index.index();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            String nodeId = newRouting.currentNodeId();
                .updateUnassigned(unassignedInfo, RecoverySource.EmptyStoreRecoverySource.INSTANCE);
import org.opensearch.common.settings.Settings;
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(6, counter.get());
                new MergedSegmentWarmerFactory(null, null, null),
 *
/*
            @Override
/*
                counter.incrementAndGet();
 * Licensed to Elasticsearch under one or more contributor
                DiscoveryNodes.builder().add(localNode).build(),
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
    public void testStartDeleteIndexEventCallback() throws Throwable {
            @Override
                counter.incrementAndGet();
public class IndicesLifecycleListenerSingleNodeTests extends OpenSearchSingleNodeTestCase {
        Index idx = resolveIndex("test");
 * ownership. Elasticsearch licenses this file to you under
            }
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                assertEquals(1, counter.get());
            @Override
            }
        indicesService.removeIndex(idx, DELETED, "simon says");
 * software distributed under the License is distributed on an
            IndexShardTestCase.updateRoutingEntry(shard, newRouting);
 * under the License.
                emptyMap(),
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
 * You may obtain a copy of the License at
                null,
 * this file be licensed under the Apache-2.0 license or a
            client().admin()
                .indices()
            }
                assertEquals(8, counter.get());
                counter.incrementAndGet();
            public void beforeIndexShardCreated(ShardId shardId, Settings indexSettings) {
            assertEquals(3, counter.get());
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
            }
import org.opensearch.cluster.routing.ShardRouting;
            }
 * KIND, either express or implied.  See the License for the
import static java.util.Collections.emptyMap;
        }
                counter.incrementAndGet();
                assertEquals(7, counter.get());
                counter.incrementAndGet();
            final DiscoveryNode localNode = new DiscoveryNode(
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
                s -> {},
            @Override
                .prepareCreate("test")
 * this work for additional information regarding copyright
            }
            @Override
                counter.incrementAndGet();
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.index.shard.IndexEventListener;
        ensureGreen();
                emptySet(),
                localNode,
            }
                assertEquals(5, counter.get());
 *
            @Override
            @Override
            newRouting = ShardRoutingHelper.moveToStarted(newRouting);
            @Override
            IndexShardTestCase.updateRoutingEntry(shard, newRouting);
        ShardRouting shardRouting = indicesService.indexService(idx).getShard(0).routingEntry();
                counter.incrementAndGet();
            public void afterIndexRemoved(Index index, IndexSettings indexSettings, IndexRemovalReason reason) {
import org.opensearch.index.seqno.RetentionLeaseSyncer;
import org.opensearch.index.shard.IndexShardTestCase;
 * GitHub history for details.
                assertEquals("test", indexService.index().getName());
        IndexMetadata metadata = indicesService.indexService(idx).getMetadata();
import org.opensearch.cluster.node.DiscoveryNode;
 */
        assertAcked(
 * not use this file except in compliance with the License.
            ShardRouting newRouting = shardRouting;
/*
            public void beforeIndexShardDeleted(ShardId shardId, Settings indexSettings) {
 * specific language governing permissions and limitations
                assertEquals(2, counter.get());
                buildNewFakeTransportAddress(),
            assertEquals(5, counter.get());
            );
            shard.markAsRecovering("store", new RecoveryState(newRouting, localNode, null));
                ReferencedSegmentsPublisher.EMPTY
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
                "foo",
import org.opensearch.indices.recovery.RecoveryState;
import org.opensearch.Version;
        try {
        final AtomicInteger counter = new AtomicInteger(1);
import org.opensearch.cluster.routing.UnassignedInfo;
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason;
                SegmentReplicationCheckpointPublisher.EMPTY,
                counter.incrementAndGet();
            public void beforeIndexCreated(Index index, Settings indexSettings) {
import org.opensearch.cluster.routing.ShardRoutingHelper;
            IndexShardTestCase.recoverFromStore(shard);
