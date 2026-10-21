        );
            settings = Settings.builder()
            builder.build()
        final Set<String> leaseIds = retentionLeases.v2().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());
            EMPTY_LISTENER
        assertThat(leaseIds, hasSize(2));
 * The OpenSearch Contributors require contributions made to
 * Modifications Copyright OpenSearch Contributors. See
        final long localCheckpoint = randomLongBetween(NO_OPS_PERFORMED, globalCheckpoint);
        final AllocationId primaryAllocationId = AllocationId.newInitializing();
            currentTimeMillis::get,
        startReplica();
            randomCheckpoint(),
        );
        final Tuple<Boolean, RetentionLeases> retentionLeases = replicationTracker.getRetentionLeases(true);
        replicationTracker = new ReplicationTracker(
        replicationTracker.initiateTracking(replicaAllocationId.getId());
import org.opensearch.index.engine.SafeCommitInfo;
                    .collect(Collectors.toSet())
        if (randomBoolean()) {
        assertFalse(tracker.indexSettings().isRemoteTranslogStoreEnabled());
            sId -> false
        final IndexShardRoutingTable routingTableWithReplica = routingTable(
        assertThat("the replica's peer recovery retention lease should survive", leaseIds, hasSize(2));
        );
 *
import org.opensearch.core.index.shard.ShardId;
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
                .put(
            Collections.singleton(primaryAllocationId.getId()),
            equalTo(
        if (randomBoolean()) {
 */
    }
            routingTable(Collections.emptySet(), primaryAllocationId)
 * the Apache License, Version 2.0 (the "License"); you may
            leaseIds,
        assertTrue(retentionLeases.v1());
 * under the License.
        assertThat(
        final ReplicationTracker tracker = new ReplicationTracker(
    }
            randomLongBetween(1, Long.MAX_VALUE),
    public void testPeerRecoveryRetentionLeasesForUnassignedCopiesExpireIfRetainingTooMuchHistory() {
            currentTimeMillis::get,
        return randomBoolean() ? SequenceNumbers.NO_OPS_PERFORMED : randomNonNegativeLong();
        }
            )
        final IndexShardRoutingTable routingTableWithReplica = routingTable(
            )
                currentTimeMillis.get() + IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.get(settings).millis() + 1,
        tracker.updateFromClusterManager(
            )
 * this file be licensed under the Apache-2.0 license or a
 *
                    .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
            primaryAllocationId.getId(),
        tracker.initiateTracking(replicaAllocationId.getId());
            routingTableWithReplica.getByAllocationId(replicaAllocationId.getId()).currentNodeId(),
        assertTrue("should have expired something", retentionLeases.v1());
 */
    private SafeCommitInfo randomSafeCommitInfoSuitableForOpsBasedRecovery(long globalCheckpoint) {
import java.util.concurrent.atomic.AtomicLong;
        final Tuple<Boolean, RetentionLeases> retentionLeases = replicationTracker.getRetentionLeases(true);
            .map(RetentionLease::id)
        builder.addShard(replicaShardRouting.moveToStarted());
                replicationTracker.routingTable.shards()
 * You may obtain a copy of the License at
    }
                    .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
                randomIntBetween(0, Integer.MAX_VALUE)
        assertThat(leaseIds, hasSize(2));
import org.opensearch.common.unit.TimeValue;
 * not use this file except in compliance with the License.
 * compatible open source license.
        safeCommitInfo = randomSafeCommitInfo();
        assertTrue("should have expired something", retentionLeases.v1());
        replicationTracker.markAllocationIdAsInSync(replicaAllocationId.getId(), randomCheckpoint());
import org.opensearch.cluster.routing.AllocationId;
    private ReplicationTracker replicationTracker;
        assertThat(
                    .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
 * software distributed under the License is distributed on an
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
    public void testPeerRecoveryRetentionLeasesForUnassignedCopiesExpireEventually() {
            new ShardId("test", "_na", 0),
            1L,
}
        safeCommitInfo = randomSafeCommitInfoSuitableForFileBasedRecovery(globalCheckpoint);
 * Unless required by applicable law or agreed to in writing,
            UNASSIGNED_SEQ_NO,
        );
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
            leaseIds,
        assertThat(leaseIds, hasSize(3));
import org.opensearch.test.IndexSettingsModule;
        final String unknownNodeId = randomAlphaOfLength(10);
            routingTableWithReplica.getByAllocationId(replicaAllocationId.getId()).currentNodeId(),
        safeCommitInfo = null; // must be set in each test
        );
/*
import org.opensearch.cluster.metadata.IndexMetadata;
                .build();
                Long.MAX_VALUE
    private SafeCommitInfo safeCommitInfo;
                    .stream()
        return new SafeCommitInfo(localCheckpoint, between(0, Math.toIntExact(Math.min(localCheckpoint + 1, Integer.MAX_VALUE))));
 * GitHub history for details.
            primaryAllocationId
        safeCommitInfo = randomSafeCommitInfoSuitableForOpsBasedRecovery(globalCheckpoint);
 */
        assertThat(
        final Tuple<Boolean, RetentionLeases> retentionLeases = replicationTracker.getRetentionLeases(true);
    }
            value -> {},
        final long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
 * Licensed to Elasticsearch under one or more contributor
                    .collect(Collectors.toSet())
    private static final ActionListener<ReplicationResponse> EMPTY_LISTENER = ActionListener.wrap(() -> {});
        safeCommitInfo = randomSafeCommitInfo();
            randomCheckpoint(),
        replicationTracker.addPeerRecoveryRetentionLease(unknownNodeId, globalCheckpoint, EMPTY_LISTENER);
                0,
        assertThat(leaseIds, hasSize(2));
package org.opensearch.index.seqno;
 * ownership. Elasticsearch licenses this file to you under
        final String unknownNodeId = randomAlphaOfLength(10);
    }
            );
                    replicationTracker.routingTable.shards().stream().map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
        final Set<String> leaseIds = retentionLeases.v2().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());
        final Tuple<Boolean, RetentionLeases> retentionLeases = replicationTracker.getRetentionLeases(true);
        replicationTracker.addPeerRecoveryRetentionLease(unknownNodeId, globalCheckpoint, EMPTY_LISTENER);
        );
        tracker.updateFromClusterManager(2L, Collections.singleton(primaryAllocationId.getId()), routingTableWithReplica);
                randomFrom(randomNonNegativeLong(), (long) randomIntBetween(0, Integer.MAX_VALUE)),
            primaryAllocationId
        );
            leaseIds,
            startReplica();
    }
            .leases()
 * this work for additional information regarding copyright
            )
        assertThat(leaseIds, hasSize(2));
     * getRetentionLeases keys off remote translog presence rather than isRemoteStoreEnabled, which keeps the replica's
    }
        currentTimeMillis.set(currentTimeMillis.get() + randomLongBetween(0, Long.MAX_VALUE - currentTimeMillis.get()));
                    TimeValue.timeValueMillis(randomLongBetween(1, TimeValue.timeValueHours(12).millis()))
        final AllocationId replicaAllocationId = AllocationId.newInitializing();
            Collections.singleton(primaryAllocationId.getId()),
        replicationTracker.updateFromClusterManager(
            startReplica();
        replicationTracker.addPeerRecoveryRetentionLease(unknownNodeId, globalCheckpoint, EMPTY_LISTENER);
        currentTimeMillis.set(
import org.opensearch.indices.replication.common.ReplicationType;
            () -> safeCommitInfo,
     * lease alive and its recoveries sequence-number based rather than silently degrading them to file based.
        final Set<String> leaseIds = retentionLeases.v2().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());
        );
                IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.get(settings).millis()
        tracker.markAllocationIdAsInSync(replicaAllocationId.getId(), randomCheckpoint());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            startReplica();
                ? randomLongBetween(0, IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.get(settings).millis())
            .build();
        assertThat(
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);
    private Settings settings;
                )
            )
    private SafeCommitInfo randomSafeCommitInfoSuitableForFileBasedRecovery(long globalCheckpoint) {
    }
        return randomBoolean()
        currentTimeMillis = new AtomicLong(randomLongBetween(0, 1024));
import org.opensearch.common.collect.Tuple;
 * SPDX-License-Identifier: Apache-2.0
        final Set<String> leaseIds = retentionLeases.v2().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());
        final Set<String> leaseIds = tracker.getRetentionLeases(true)
            settings = Settings.EMPTY;
     * recovers by replaying operations from the primary, so its peer recovery retention lease must be preserved.
        safeCommitInfo = randomSafeCommitInfo();
import org.opensearch.core.action.ActionListener;
        );
        final AllocationId primaryAllocationId = AllocationId.newInitializing();
            )
        final long globalCheckpoint = randomCheckpoint();
 * specific language governing permissions and limitations
        assertFalse("should not have expired anything", retentionLeases.v1());
            ? SafeCommitInfo.EMPTY
    public void setUpReplicationTracker() throws InterruptedException {
        builder.removeShard(replicaShardRouting);
import static org.hamcrest.Matchers.hasSize;
        assertThat(
import java.util.Collections;
/*
    @Before
 *     http://www.apache.org/licenses/LICENSE-2.0
                    .stream()
public class PeerRecoveryRetentionLeaseExpiryTests extends ReplicationTrackerTestCase {
            (leases, listener) -> {},
            : new SafeCommitInfo(
    public void testPeerRecoveryRetentionLeasesRetainedWithSegmentsOnlyRemoteStore() throws InterruptedException {
            .stream()
        final String unknownNodeId = randomAlphaOfLength(10);
        // simulate a later safe commit containing no documents, which is always better to transfer than any ops
        replicationTracker.addPeerRecoveryRetentionLease(unknownNodeId, randomCheckpoint(), EMPTY_LISTENER);
    }
                    .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
        final long globalCheckpoint = randomValueOtherThan(SequenceNumbers.NO_OPS_PERFORMED, this::randomCheckpoint);
            )
        replicationTracker.updateFromClusterManager(2L, Collections.singleton(primaryAllocationId.getId()), routingTableWithReplica);
                Stream.concat(
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)
import java.util.stream.Stream;
        );
            (leases, listener) -> {},
                    IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(),
                    .collect(Collectors.toSet())
import org.opensearch.action.support.replication.ReplicationResponse;
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
                    .stream()
                replicationTracker.routingTable.shards()
                    .stream()
/*
        return new SafeCommitInfo(randomLongBetween(globalCheckpoint + 1, Long.MAX_VALUE), 0);
 *
            1L,
    public void testPeerRecoveryRetentionLeasesForUnassignedCopiesDoNotExpireImmediatelyIfShardsNotAllStarted() {
            EMPTY_LISTENER
            equalTo(
        final Set<String> leaseIds = retentionLeases.v2().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());
        );
            .v2()
        final String unknownNodeId = randomAlphaOfLength(10);
            replicationTracker.routingTable.shards().stream().map(sr -> sr.allocationId().getId()).collect(Collectors.toSet()),
import org.junit.Before;
            () -> safeCommitInfo,
    /**
        );
            currentTimeMillis.get() + (usually()
        assertFalse(retentionLeases.v1());
    public void testPeerRecoveryRetentionLeasesForAssignedCopiesDoNotEverExpire() {
        );
                replicationTracker.routingTable.shards()
        currentTimeMillis.set(currentTimeMillis.get() + randomLongBetween(0, Long.MAX_VALUE - currentTimeMillis.get()));
        final ShardRouting replicaShardRouting = replicationTracker.routingTable.replicaShards().get(0);
            primaryAllocationId.getId(),
 * license agreements. See the NOTICE file distributed with
            .collect(Collectors.toSet());
            value -> {},
        replicationTracker.updateFromClusterManager(
        safeCommitInfo = randomSafeCommitInfoSuitableForOpsBasedRecovery(globalCheckpoint);
import java.util.Set;
            leaseIds,
        }
            Collections.singleton(replicaAllocationId),
        // simulate a safe commit that is behind the given global checkpoint, so that no files need to be transferrred
                : randomLongBetween(0, Long.MAX_VALUE - currentTimeMillis.get()))
        }
                replicationTracker.routingTable.shards()
        final Tuple<Boolean, RetentionLeases> retentionLeases = replicationTracker.getRetentionLeases(true);
            Collections.singleton(replicaAllocationId),
            equalTo(
import org.opensearch.cluster.routing.ShardRouting;
        if (randomBoolean()) {
            UNASSIGNED_SEQ_NO,
        tracker.addPeerRecoveryRetentionLease(
    }
        final AllocationId replicaAllocationId = AllocationId.newInitializing();
                    Stream.of(ReplicationTracker.getPeerRecoveryRetentionLeaseId(unknownNodeId)),
    private AtomicLong currentTimeMillis;
        );
        final long globalCheckpoint = randomNonNegativeLong(); // not NO_OPS_PERFORMED since this always results in file-based recovery
    }
            new ShardId("test", "_na", 0),
        );
        final Settings segmentsOnly = Settings.builder()
            IndexSettingsModule.newIndexSettings("test", settings),
        );
    private long randomCheckpoint() {
import org.opensearch.index.IndexSettings;
            currentTimeMillis.get() + randomLongBetween(
    }
    private SafeCommitInfo randomSafeCommitInfo() {
        if (randomBoolean()) {
            sId -> true
    public void testPeerRecoveryRetentionLeasesForUnassignedCopiesExpireImmediatelyIfShardsAllStarted() {
            primaryTerm,
        final IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(replicationTracker.routingTable);
    private void startReplica() {
     */
import org.opensearch.common.settings.Settings;
 * KIND, either express or implied.  See the License for the
            leaseIds,
        } else {
                ).collect(Collectors.toSet())
        );
import java.util.stream.Collectors;
            equalTo(
                    .collect(Collectors.toSet())
        replicationTracker.addPeerRecoveryRetentionLease(
        currentTimeMillis.set(
            routingTable(Collections.emptySet(), primaryAllocationId)
        }
import static org.hamcrest.Matchers.equalTo;
            replicationTracker.appliedClusterStateVersion + 1,
            randomLongBetween(
            IndexSettingsModule.newIndexSettings("test", segmentsOnly),
            equalTo(
        currentTimeMillis.set(
     * Segments-only remote store: a remote segment repository and no remote translog repository. A replica still
