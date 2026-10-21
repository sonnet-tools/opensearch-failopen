import static org.hamcrest.Matchers.lessThan;
    public void testRecoveryTimeout() throws Exception {
            String tempFileName = recoveryTarget.getTempNameForFile("foobar");
            assertSame(store, resetRecovery.store());
            assertThrows(ReplicationFailedException.class, () -> collection.startSafe(target2, TimeValue.timeValueMinutes(30)));
    };
                collection.cancel(recoveryId, "meh");
            final IndexShard shard = shards.addReplica();
import org.opensearch.cluster.node.DiscoveryNode;
        try (ReplicationGroup shards = createGroup(0)) {
        public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
        try (ReplicationGroup shards = createGroup(0)) {
            } finally {
    }
        }
            final ReplicationCollection<RecoveryTarget> collection = new ReplicationCollection<>(logger, threadPool);
            );
/*
            Store store = recoveryTarget.store();
            target1.decRef();
            assertEquals(currentAsTarget, shard.recoveryStats().currentAsTarget());
            }
        indexShard.prepareForIndexRecovery();
                @Override
import org.opensearch.indices.replication.common.ReplicationState;
            expectThrows(OpenSearchException.class, () -> recoveryTarget.indexShard());
import org.opensearch.OpenSearchException;
                collection.cancel(recoveryId, "meh");
import org.opensearch.indices.recovery.RecoveryState;
                    failed.set(true);
                    assertSame(s, newRecoveryRef.get().indexShard());
 * The OpenSearch Contributors require contributions made to
            final IndexShard shard1 = shards.addReplica();
            } finally {
                    latch.countDown();
public class ReplicationCollectionTests extends OpenSearchIndexLevelReplicationTestCase {
            }
                assertTrue("failed to cancel recoveries", collection.cancelForShard(shardId, "test"));
import org.opensearch.index.store.Store;
            int numDocs = randomIntBetween(1, 15);
            try (ReplicationCollection.ReplicationRef<RecoveryTarget> newRecoveryRef = collection.get(resetRecoveryId)) {
            }, TimeValue.timeValueMillis(100));
                shard,
        TimeValue timeValue
                collection.cancel(recoveryId2, "meh");
                assertTrue("recovery failed to timeout", failed.get());
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
                assertThat("all recoveries should be cancelled", collection.size(), equalTo(0));
import org.opensearch.indices.recovery.RecoveryTarget;
 * Modifications Copyright OpenSearch Contributors. See
import java.util.concurrent.TimeUnit;
            shards.startAll();
        DiscoveryNode sourceNode,
import org.opensearch.indices.replication.SegmentReplicationSource;
                shards.getPrimary().getLatestReplicationCheckpoint(),
 *
                collection.cancel(recoveryId, "meh");
            collection.startSafe(target1, TimeValue.timeValueMinutes(30));
            } catch (AssertionError e) {
            final long recoveryId = startRecovery(collection, shards.getPrimaryNode(), shard);
        @Override
 */
                mock(SegmentReplicationSource.class),
            final ReplicationCollection<RecoveryTarget> collection = new ReplicationCollection<>(logger, threadPool);
        @Override
        }
            final CountDownLatch latch = new CountDownLatch(1);
            try (ReplicationCollection.ReplicationRef<RecoveryTarget> recoveryRef = collection.get(recoveryId)) {
 * under the License.
import static org.hamcrest.Matchers.equalTo;
    }
            final AtomicBoolean failed = new AtomicBoolean();
            }
            RecoveryTarget recoveryTarget = collection.getTarget(recoveryId);
import org.opensearch.indices.replication.common.ReplicationCollection;
                    latch.countDown();
            final ReplicationCollection<RecoveryTarget> collection = new ReplicationCollection<>(logger, threadPool);
    }
        try (ReplicationGroup shards = createGroup(0)) {
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(e.getMessage(), "More than one on-going replication targets");
 */
            IndexShard shard = shards.addReplica();
        }
            final long recoveryId = startRecovery(collection, shards.getPrimaryNode(), shard1);
        try (ReplicationGroup shards = createGroup(0)) {
            } finally {
 * specific language governing permissions and limitations
            final long recoveryId = startRecovery(collection, shards.getPrimaryNode(), shards.addReplica());
            try {
                assertBusy(() -> {
 * ownership. Elasticsearch licenses this file to you under
    }
    public void testRecoveryCancellation() throws Exception {
                @Override
    public void testGetReplicationTargetMultiReplicationsForSingleShard() throws Exception {
                ShardId shardId = recoveryRef.get().indexShard().shardId();
            RecoveryTarget resetRecovery = collection.reset(recoveryId, TimeValue.timeValueMinutes(60));
/*
            closeShards(shard1, shard2);
 * GitHub history for details.
    public void testStartMultipleReplicationsForSingleShard() throws Exception {
                }
                mock(ReplicationListener.class)
 * compatible open source license.
        return startRecovery(collection, sourceNode, shard, listener, TimeValue.timeValueMinutes(60));
            final IndexShard shard2 = shards.addReplica();
                });
                mock(SegmentReplicationSource.class),
            final ReplicationCollection<RecoveryTarget> collection = new ReplicationCollection<>(logger, threadPool);
 * this work for additional information regarding copyright
                latch.await(30, TimeUnit.SECONDS);
            target2.decRef();
 * Unless required by applicable law or agreed to in writing,
            final SegmentReplicationTarget target2 = new SegmentReplicationTarget(
            final ReplicationCollection<RecoveryTarget> collection = new ReplicationCollection<>(logger, threadPool);
                }
        IndexShard indexShard,
            assertEquals(2, collection.getOngoingReplicationTargetList(shard1.shardId()).size());
import static org.mockito.Mockito.mock;
                public void onDone(ReplicationState state) {
            assertNull("recovery is done", collection.get(recoveryId));
    }
import org.opensearch.indices.replication.common.ReplicationListener;
    long startRecovery(
        try (ReplicationGroup shards = createGroup(0)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                collection.getOngoingReplicationTarget(shard1.shardId());
                collection.cancel(recoveryId, "life");
        final DiscoveryNode rNode = getDiscoveryNode(indexShard.routingEntry().currentNodeId());
        }
    ) {
    }
    public void testResetRecovery() throws Exception {
            expectThrows(OpenSearchException.class, () -> recoveryTarget.store());
                        assertThat("access time failed to update", lastSeenTime, lessThan(currentStatus.get().lastAccessTime()));
            shards.indexDocs(numDocs);
    static final ReplicationListener listener = new ReplicationListener() {
            final ReplicationCollection<ReplicationTarget> collection = new ReplicationCollection<>(logger, threadPool);
    public void testLastAccessTimeUpdate() throws Exception {
        ReplicationCollection<RecoveryTarget> collection,
            IndexShard indexShard = recoveryTarget.indexShard();
        }
            assertNotSame(recoveryTarget, resetRecovery);
 *
            shards.recoverReplica(shard);
 * KIND, either express or implied.  See the License for the
            final long resetRecoveryId = resetRecovery.getId();
            assertEquals(recoveryTarget.refCount(), 0);
            final SegmentReplicationTarget target1 = new SegmentReplicationTarget(
                mock(ReplicationListener.class)
import java.util.concurrent.atomic.AtomicBoolean;
                collection.cancel(recoveryId2, "meh");
 */
import org.opensearch.core.index.shard.ShardId;
            assertEquals(referencesToStore, resetRecovery.store().refCount());
                    try (ReplicationCollection.ReplicationRef<RecoveryTarget> currentStatus = collection.get(recoveryId)) {
            shards.startAll();
    long startRecovery(ReplicationCollection<RecoveryTarget> collection, DiscoveryNode sourceNode, IndexShard shard) {
        ReplicationListener listener,
import org.opensearch.common.unit.TimeValue;
 * You may obtain a copy of the License at
            assertNotSame(recoveryTarget.cancellableThreads(), resetRecovery.cancellableThreads());
            try {
import org.opensearch.indices.replication.common.ReplicationTarget;
    }
                public void onFailure(ReplicationState state, ReplicationFailedException e, boolean sendShardFailure) {
            shards.assertAllEqual(numDocs);
import org.opensearch.index.replication.OpenSearchIndexLevelReplicationTestCase;
            try (ReplicationCollection.ReplicationRef<RecoveryTarget> status = collection.get(recoveryId)) {
        }
            final long recoveryId2 = startRecovery(collection, shards.getPrimaryNode(), shards.addReplica());
        indexShard.markAsRecovering("remote", new RecoveryState(indexShard.routingEntry(), sourceNode, rNode));
 * this file be licensed under the Apache-2.0 license or a
        try (ReplicationGroup shards = createGroup(0)) {
            final int currentAsTarget = shard.recoveryStats().currentAsTarget();
            final long recoveryId = startRecovery(collection, shards.getPrimaryNode(), shards.addReplica());
                final long lastSeenTime = status.get().lastAccessTime();
        }
            assertNotEquals(tempFileName, resetTempFileName);
                shard,
}
            final long recoveryId = startRecovery(collection, shards.getPrimaryNode(), shards.addReplica(), new ReplicationListener() {
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertSame(indexShard, resetRecovery.indexShard());
            }
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor
            final long recoveryId2 = startRecovery(collection, shards.getPrimaryNode(), shard2);
    }
            }
/*
                shards.recoverReplica(shard, (s, n) -> {
                shards.getPrimary().getLatestReplicationCheckpoint(),
                    }
                    return newRecoveryRef.get();
import org.opensearch.index.shard.IndexShard;
        }
import java.util.concurrent.CountDownLatch;
import org.opensearch.indices.replication.common.ReplicationFailedException;
            final int referencesToStore = recoveryTarget.store().refCount();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.indices.replication.SegmentReplicationTarget;
            } finally {
                }, false);
 *
            String resetTempFileName = resetRecovery.getTempNameForFile("foobar");
        public void onDone(ReplicationState state) {
        return collection.start(new RecoveryTarget(indexShard, sourceNode, listener, threadPool), timeValue);
package org.opensearch.recovery;
            );
            assertEquals(currentAsTarget, shard.recoveryStats().currentAsTarget());
