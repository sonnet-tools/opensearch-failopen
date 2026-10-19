        }
    }
    }
    public void testLastAccessTimeUpdate() throws Exception {
            assertNull("recovery is done", collection.get(recoveryId));  
    public void testRecoveryCancellation() throws Exception {  
                mock(ReplicationListener.class)
        public void onDone(ReplicationState state) {
            String tempFileName = recoveryTarget.getTempNameForFile("foobar");
                shard,
            shards.startAll();  
            IndexShard indexShard = recoveryTarget.indexShard();  
            } finally {  
            }
        final DiscoveryNode rNode = getDiscoveryNode(indexShard.routingEntry().currentNodeId());  
    public void testGetReplicationTargetMultiReplicationsForSingleShard() throws Exception {
import static org.hamcrest.Matchers.lessThan;
 *    http://www.apache.org/licenses/LICENSE-2.0
            final ReplicationCollection<RecoveryTarget> collection = new ReplicationCollection<>(logger, threadPool);  
import org.opensearch.indices.recovery.RecoveryState;
/*  
        public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {  
                @Override  
            assertNotSame(recoveryTarget, resetRecovery);
                }, false);  
 *
            assertNotEquals(tempFileName, resetTempFileName);  
 */
            collection.startSafe(target1, TimeValue.timeValueMinutes(30));  
}
            final long recoveryId = startRecovery(collection, shards.getPrimaryNode(), shards.addReplica());
            final long recoveryId2 = startRecovery(collection, shards.getPrimaryNode(), shard2);
                collection.cancel(recoveryId, "meh");
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
import org.opensearch.indices.replication.common.ReplicationTarget;  
            final IndexShard shard = shards.addReplica();
                    try (ReplicationCollection.ReplicationRef<RecoveryTarget> currentStatus = collection.get(recoveryId)) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.indices.replication.common.ReplicationState;
                    failed.set(true);
            expectThrows(OpenSearchException.class, () -> recoveryTarget.indexShard());
/*
/*
import org.opensearch.indices.recovery.RecoveryTarget;
                }
            shards.indexDocs(numDocs);
            shards.startAll();
                mock(ReplicationListener.class)
            assertNotSame(recoveryTarget.cancellableThreads(), resetRecovery.cancellableThreads());  
    public void testResetRecovery() throws Exception {
            }, TimeValue.timeValueMillis(100));
import org.opensearch.index.shard.IndexShard;
import java.util.concurrent.CountDownLatch;
        try (ReplicationGroup shards = createGroup(0)) {
            final ReplicationCollection<RecoveryTarget> collection = new ReplicationCollection<>(logger, threadPool);  
                public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
            try (ReplicationCollection.ReplicationRef<RecoveryTarget> status = collection.get(recoveryId)) {  
                    latch.countDown();  
import static org.hamcrest.Matchers.equalTo;  
            );
                        assertThat("access time failed to update", lastSeenTime, lessThan(currentStatus.get().lastAccessTime()));
                latch.await(30, TimeUnit.SECONDS);
            final int referencesToStore = recoveryTarget.store().refCount();
            closeShards(shard1, shard2);
                collection.cancel(recoveryId, "meh");
                }
    }
            assertSame(store, resetRecovery.store());
            }
            target1.decRef();
        }
            assertEquals(recoveryTarget.refCount(), 0);
            RecoveryTarget recoveryTarget = collection.getTarget(recoveryId);  
                    }
                shards.recoverReplica(shard, (s, n) -> {  
                collection.getOngoingReplicationTarget(shard1.shardId());
        }  
    };  
import org.opensearch.indices.replication.common.ReplicationListener;
    }
                });  
            assertThrows(ReplicationFailedException.class, () -> collection.startSafe(target2, TimeValue.timeValueMinutes(30)));
            assertEquals(referencesToStore, resetRecovery.store().refCount());  
            final ReplicationCollection<RecoveryTarget> collection = new ReplicationCollection<>(logger, threadPool);
                collection.cancel(recoveryId2, "meh");  
            target2.decRef();  
            final ReplicationCollection<RecoveryTarget> collection = new ReplicationCollection<>(logger, threadPool);  
            final IndexShard shard2 = shards.addReplica();
    ) {
            final long recoveryId = startRecovery(collection, shards.getPrimaryNode(), shards.addReplica());  
        @Override  
import org.opensearch.common.unit.TimeValue;
public class ReplicationCollectionTests extends OpenSearchIndexLevelReplicationTestCase {
            }  
            } catch (AssertionError e) {
            try {  
 *  
            Store store = recoveryTarget.store();
                    return newRecoveryRef.get();
            assertEquals(2, collection.getOngoingReplicationTargetList(shard1.shardId()).size());
            } finally {
    }
                mock(SegmentReplicationSource.class),  
        @Override
        DiscoveryNode sourceNode,
                mock(SegmentReplicationSource.class),  
            final CountDownLatch latch = new CountDownLatch(1);
import java.util.concurrent.TimeUnit;  
            } finally {  
import org.opensearch.cluster.node.DiscoveryNode;
import org.opensearch.indices.replication.SegmentReplicationSource;  
            final int currentAsTarget = shard.recoveryStats().currentAsTarget();
 * this file be licensed under the Apache-2.0 license or a
            String resetTempFileName = resetRecovery.getTempNameForFile("foobar");
 */
            );
        try (ReplicationGroup shards = createGroup(0)) {
                ShardId shardId = recoveryRef.get().indexShard().shardId();  
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
            assertEquals(currentAsTarget, shard.recoveryStats().currentAsTarget());
                    assertSame(s, newRecoveryRef.get().indexShard());
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
            final SegmentReplicationTarget target2 = new SegmentReplicationTarget(  
 * Modifications Copyright OpenSearch Contributors. See  
 */  
            final long recoveryId = startRecovery(collection, shards.getPrimaryNode(), shards.addReplica(), new ReplicationListener() {  
        try (ReplicationGroup shards = createGroup(0)) {  
            }
 * GitHub history for details.
            final SegmentReplicationTarget target1 = new SegmentReplicationTarget(  
        }
 * KIND, either express or implied.  See the License for the
        }
            try (ReplicationCollection.ReplicationRef<RecoveryTarget> newRecoveryRef = collection.get(resetRecoveryId)) {
        return startRecovery(collection, sourceNode, shard, listener, TimeValue.timeValueMinutes(60));
            assertEquals(currentAsTarget, shard.recoveryStats().currentAsTarget());
        TimeValue timeValue
 * this work for additional information regarding copyright
    long startRecovery(ReplicationCollection<RecoveryTarget> collection, DiscoveryNode sourceNode, IndexShard shard) {
            shards.recoverReplica(shard);
    long startRecovery(
    public void testStartMultipleReplicationsForSingleShard() throws Exception {  
import org.opensearch.index.store.Store;  
 * under the License.  
                assertEquals(e.getMessage(), "More than one on-going replication targets");  
import static org.mockito.Mockito.mock;
        return collection.start(new RecoveryTarget(indexShard, sourceNode, listener, threadPool), timeValue);  
                collection.cancel(recoveryId2, "meh");
            final long recoveryId2 = startRecovery(collection, shards.getPrimaryNode(), shards.addReplica());
            IndexShard shard = shards.addReplica();
    }
import org.opensearch.indices.replication.common.ReplicationFailedException;  
 * software distributed under the License is distributed on an
        indexShard.prepareForIndexRecovery();
                shard,
 *
            final long recoveryId = startRecovery(collection, shards.getPrimaryNode(), shard);
                assertThat("all recoveries should be cancelled", collection.size(), equalTo(0));
            assertSame(indexShard, resetRecovery.indexShard());
                assertTrue("recovery failed to timeout", failed.get());
    public void testRecoveryTimeout() throws Exception {
                final long lastSeenTime = status.get().lastAccessTime();
        }
                shards.getPrimary().getLatestReplicationCheckpoint(),
import org.opensearch.OpenSearchException;  
    }  
import java.util.concurrent.atomic.AtomicBoolean;
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
    static final ReplicationListener listener = new ReplicationListener() {
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
            final ReplicationCollection<ReplicationTarget> collection = new ReplicationCollection<>(logger, threadPool);  
            shards.assertAllEqual(numDocs);
        try (ReplicationGroup shards = createGroup(0)) {
import org.opensearch.core.index.shard.ShardId;  
 * The OpenSearch Contributors require contributions made to  
        }  
            int numDocs = randomIntBetween(1, 15);
            try (ReplicationCollection.ReplicationRef<RecoveryTarget> recoveryRef = collection.get(recoveryId)) {
        indexShard.markAsRecovering("remote", new RecoveryState(indexShard.routingEntry(), sourceNode, rNode));
                assertTrue("failed to cancel recoveries", collection.cancelForShard(shardId, "test"));
                    latch.countDown();  
                @Override
        try (ReplicationGroup shards = createGroup(0)) {
import org.opensearch.indices.replication.common.ReplicationCollection;
            try {  
 * not use this file except in compliance with the License.
import org.opensearch.indices.replication.SegmentReplicationTarget;
            final long recoveryId = startRecovery(collection, shards.getPrimaryNode(), shard1);  
            } finally {
        ReplicationListener listener,  
package org.opensearch.recovery;
                public void onDone(ReplicationState state) {
                assertBusy(() -> {
        try (ReplicationGroup shards = createGroup(0)) {
    }
        IndexShard indexShard,
            final IndexShard shard1 = shards.addReplica();
                collection.cancel(recoveryId, "life");
        }  
            expectThrows(OpenSearchException.class, () -> recoveryTarget.store());  
                shards.getPrimary().getLatestReplicationCheckpoint(),
            final long resetRecoveryId = resetRecovery.getId();
            RecoveryTarget resetRecovery = collection.reset(recoveryId, TimeValue.timeValueMinutes(60));  
                collection.cancel(recoveryId, "meh");
            final ReplicationCollection<RecoveryTarget> collection = new ReplicationCollection<>(logger, threadPool);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            final AtomicBoolean failed = new AtomicBoolean();
            }  
        ReplicationCollection<RecoveryTarget> collection,  
