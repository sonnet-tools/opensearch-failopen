            String nodeId = newRouting.currentNodeId();  
import static org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason.DELETED;
import java.util.Arrays;
            assertEquals(5, counter.get());  
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * this file be licensed under the Apache-2.0 license or a
                assertEquals(3, counter.get());
            }  
        };
                assertEquals(2, counter.get());
                .prepareCreate("test")  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IndexShardTestCase.recoverFromStore(shard);  
                emptyMap(),
                assertEquals(8, counter.get());  
package org.opensearch.indices;
        try {
                .updateUnassigned(unassignedInfo, RecoverySource.EmptyStoreRecoverySource.INSTANCE);  
                counter.incrementAndGet();
import org.opensearch.cluster.routing.ShardRoutingHelper;  
        } finally {
            newRouting = newRouting.moveToUnassigned(unassignedInfo)
/*
 * GitHub history for details.
        assertAcked(  
import org.opensearch.cluster.metadata.IndexMetadata;
                counter.incrementAndGet();
        final AtomicInteger counter = new AtomicInteger(1);
                "foo",  
                counter.incrementAndGet();
            }
import org.opensearch.indices.cluster.IndicesClusterStateService.AllocatedIndices.IndexRemovalReason;  
import org.opensearch.cluster.routing.RecoverySource;
            indicesService.removeIndex(idx, DELETED, "simon says");
import org.opensearch.Version;  
            assertEquals(3, counter.get());  
                SegmentReplicationCheckpointPublisher.EMPTY,
 * not use this file except in compliance with the License.
import org.opensearch.indices.replication.checkpoint.SegmentReplicationCheckpointPublisher;
import org.opensearch.common.settings.Settings;
 * You may obtain a copy of the License at  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 * KIND, either express or implied.  See the License for the
                null,
            public void afterIndexRemoved(Index index, IndexSettings indexSettings, IndexRemovalReason reason) {
                counter.incrementAndGet();  
import org.opensearch.index.shard.IndexEventListener;  
    public void testStartDeleteIndexEventCallback() throws Throwable {
                localNode,
                MergedSegmentPublisher.EMPTY,
            IndexShard shard = index.createShard(  
 */
            public void afterIndexShardStarted(IndexShard indexShard) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
                assertEquals(5, counter.get());
            assertEquals(6, counter.get());  
import org.opensearch.index.shard.IndexShardTestCase;
import org.opensearch.index.IndexService;
        );
                new MergedSegmentWarmerFactory(null, null, null),
            }
 * software distributed under the License is distributed on an
            shard.markAsRecovering("store", new RecoveryState(newRouting, localNode, null));
            IndexShardTestCase.updateRoutingEntry(shard, newRouting);
                emptySet(),  
                counter.incrementAndGet();  
 * The OpenSearch Contributors require contributions made to  
            }
            }
                assertEquals(DELETED, reason);
            newRouting = ShardRoutingHelper.initialize(newRouting, nodeId);
import org.opensearch.indices.replication.checkpoint.ReferencedSegmentsPublisher;  
import java.util.concurrent.atomic.AtomicInteger;
 */  
 * Unless required by applicable law or agreed to in writing,
                DiscoveryNodes.builder().add(localNode).build(),  
 * compatible open source license.
                counter.incrementAndGet();
import org.opensearch.indices.replication.checkpoint.MergedSegmentPublisher;
            @Override
            }
        IndexEventListener countingListener = new IndexEventListener() {
            IndexShardTestCase.updateRoutingEntry(shard, newRouting);
        }  
import org.opensearch.indices.recovery.RecoveryState;
            ShardRouting newRouting = shardRouting;
import static java.util.Collections.emptySet;
                assertEquals(4, counter.get());
                assertEquals(6, counter.get());  
import org.opensearch.cluster.node.DiscoveryNode;
            public void afterIndexCreated(IndexService indexService) {  
        IndexMetadata metadata = indicesService.indexService(idx).getMetadata();
                .setSettings(Settings.builder().put(SETTING_NUMBER_OF_SHARDS, 1).put(SETTING_NUMBER_OF_REPLICAS, 0))
            final DiscoveryNode localNode = new DiscoveryNode(
 * SPDX-License-Identifier: Apache-2.0
                null,  
            idx = index.index();
                Version.CURRENT
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.engine.MergedSegmentWarmerFactory;
 * under the License.  
            @Override
                assertEquals("test", index.getName());  
 *  
        Index idx = resolveIndex("test");
            @Override  
import org.opensearch.cluster.routing.UnassignedInfo;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.index.Index;  
            public void beforeIndexShardCreated(ShardId shardId, Settings indexSettings) {
                .indices()
                s -> {},
import org.opensearch.index.IndexSettings;  
}
        IndicesService indicesService = getInstanceFromNode(IndicesService.class);
                RetentionLeaseSyncer.EMPTY,  
            }  
import org.opensearch.cluster.node.DiscoveryNodes;  
            UnassignedInfo unassignedInfo = new UnassignedInfo(UnassignedInfo.Reason.INDEX_CREATED, "boom");
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
                assertEquals(1, counter.get());
/*
            client().admin()
            );
    }
            public void beforeIndexShardDeleted(ShardId shardId, Settings indexSettings) {
public class IndicesLifecycleListenerSingleNodeTests extends OpenSearchSingleNodeTestCase {
            @Override
                newRouting,
                counter.incrementAndGet();  
        ensureGreen();  
                counter.incrementAndGet();  
 * the Apache License, Version 2.0 (the "License"); you may
 *
import org.opensearch.core.index.shard.ShardId;
            @Override  
                buildNewFakeTransportAddress(),
import static java.util.Collections.emptyMap;
            }
            newRouting = ShardRoutingHelper.moveToStarted(newRouting);
        assertEquals(10, counter.get());
                ReferencedSegmentsPublisher.EMPTY  
        ShardRouting shardRouting = indicesService.indexService(idx).getShard(0).routingEntry();  
 * this work for additional information regarding copyright
            public void afterIndexShardCreated(IndexShard indexShard) {
import org.opensearch.index.seqno.RetentionLeaseSyncer;
            @Override
import org.opensearch.index.shard.IndexShard;
/*  
            public void beforeIndexCreated(Index index, Settings indexSettings) {
                assertEquals("test", indexService.index().getName());
            @Override  
                assertEquals(7, counter.get());  
 *
            }
            IndexService index = indicesService.createIndex(metadata, Arrays.asList(countingListener), false);
            public void afterIndexShardDeleted(ShardId shardId, Settings indexSettings) {
                assertEquals(DELETED, reason);  
        indicesService.removeIndex(idx, DELETED, "simon says");  
            @Override  
import org.opensearch.cluster.routing.ShardRouting;
 */
                counter.incrementAndGet();
 * specific language governing permissions and limitations
                null,
                assertEquals(9, counter.get());
            );
            @Override
 * ownership. Elasticsearch licenses this file to you under  
            public void beforeIndexRemoved(IndexService indexService, IndexRemovalReason reason) {
