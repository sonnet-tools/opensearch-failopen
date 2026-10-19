    @Before  
    private AtomicLong currentTimeMillis;
        currentTimeMillis.set(
import java.util.Set;
            currentTimeMillis.get() + (usually()  
                    .stream()  
        assertThat(
                    .stream()  
 * not use this file except in compliance with the License.
        final AllocationId primaryAllocationId = AllocationId.newInitializing();
            value -> {},
    }
import org.opensearch.indices.replication.common.ReplicationType;  
            primaryAllocationId
                .build();
        assertTrue("should have expired something", retentionLeases.v1());
import org.opensearch.cluster.routing.AllocationId;
        final Set<String> leaseIds = retentionLeases.v2().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());  
                    replicationTracker.routingTable.shards().stream().map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
        tracker.addPeerRecoveryRetentionLease(
    private long randomCheckpoint() {  
        tracker.updateFromClusterManager(
    }
import org.opensearch.test.IndexSettingsModule;
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.action.ActionListener;
            ? SafeCommitInfo.EMPTY  
        builder.removeShard(replicaShardRouting);
            .stream()
    }
        // simulate a later safe commit containing no documents, which is always better to transfer than any ops
 *  
    }
                    .collect(Collectors.toSet())
    }
        return new SafeCommitInfo(localCheckpoint, between(0, Math.toIntExact(Math.min(localCheckpoint + 1, Integer.MAX_VALUE))));
 * GitHub history for details.
    }
            EMPTY_LISTENER
        final Tuple<Boolean, RetentionLeases> retentionLeases = replicationTracker.getRetentionLeases(true);  
        safeCommitInfo = randomSafeCommitInfo();
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        final Settings segmentsOnly = Settings.builder()
        assertTrue("should have expired something", retentionLeases.v1());
import static org.hamcrest.Matchers.equalTo;  
            EMPTY_LISTENER
            .leases()  
        final ReplicationTracker tracker = new ReplicationTracker(
import org.opensearch.index.engine.SafeCommitInfo;
            value -> {},
        assertFalse(tracker.indexSettings().isRemoteTranslogStoreEnabled());
    public void testPeerRecoveryRetentionLeasesForUnassignedCopiesExpireIfRetainingTooMuchHistory() {
        final Tuple<Boolean, RetentionLeases> retentionLeases = replicationTracker.getRetentionLeases(true);
        replicationTracker.addPeerRecoveryRetentionLease(unknownNodeId, globalCheckpoint, EMPTY_LISTENER);
                IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.get(settings).millis()  
    public void testPeerRecoveryRetentionLeasesForUnassignedCopiesExpireImmediatelyIfShardsAllStarted() {
package org.opensearch.index.seqno;
 * this work for additional information regarding copyright
            )  
            new ShardId("test", "_na", 0),
        );  
    }
            )
 * this file be licensed under the Apache-2.0 license or a
            () -> safeCommitInfo,
    public void setUpReplicationTracker() throws InterruptedException {
        assertThat(  
        );  
        }
    private ReplicationTracker replicationTracker;
            leaseIds,  
/*
        replicationTracker.addPeerRecoveryRetentionLease(unknownNodeId, randomCheckpoint(), EMPTY_LISTENER);
            routingTableWithReplica.getByAllocationId(replicaAllocationId.getId()).currentNodeId(),  
            randomCheckpoint(),
        final long globalCheckpoint = randomValueOtherThan(SequenceNumbers.NO_OPS_PERFORMED, this::randomCheckpoint);
        final Tuple<Boolean, RetentionLeases> retentionLeases = replicationTracker.getRetentionLeases(true);  
            equalTo(
            Collections.singleton(replicaAllocationId),
        safeCommitInfo = null; // must be set in each test
        final AllocationId primaryAllocationId = AllocationId.newInitializing();
        safeCommitInfo = randomSafeCommitInfo();
            1L,
        return new SafeCommitInfo(randomLongBetween(globalCheckpoint + 1, Long.MAX_VALUE), 0);  
import org.opensearch.action.support.replication.ReplicationResponse;  
            .v2()
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);  
    private static final ActionListener<ReplicationResponse> EMPTY_LISTENER = ActionListener.wrap(() -> {});
 * license agreements. See the NOTICE file distributed with
        currentTimeMillis.set(currentTimeMillis.get() + randomLongBetween(0, Long.MAX_VALUE - currentTimeMillis.get()));
        assertThat(
        final IndexShardRoutingTable routingTableWithReplica = routingTable(  
    public void testPeerRecoveryRetentionLeasesForUnassignedCopiesExpireEventually() {
 * specific language governing permissions and limitations
    }
     * lease alive and its recoveries sequence-number based rather than silently degrading them to file based.
            sId -> false
 */  
        replicationTracker.addPeerRecoveryRetentionLease(
            routingTable(Collections.emptySet(), primaryAllocationId)
        final long globalCheckpoint = randomCheckpoint();
        );
    private Settings settings;  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
        );
 * the Apache License, Version 2.0 (the "License"); you may
            (leases, listener) -> {},
                    .collect(Collectors.toSet())  
            equalTo(
        final AllocationId replicaAllocationId = AllocationId.newInitializing();
            IndexSettingsModule.newIndexSettings("test", segmentsOnly),
            )
        currentTimeMillis.set(  
        );  
        replicationTracker = new ReplicationTracker(
            1L,
     * getRetentionLeases keys off remote translog presence rather than isRemoteStoreEnabled, which keeps the replica's
            currentTimeMillis::get,
    }
                replicationTracker.routingTable.shards()
            currentTimeMillis.get() + randomLongBetween(
        final long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);  
        final String unknownNodeId = randomAlphaOfLength(10);  
        }
                ? randomLongBetween(0, IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.get(settings).millis())
        replicationTracker.updateFromClusterManager(
            leaseIds,  
    public void testPeerRecoveryRetentionLeasesForAssignedCopiesDoNotEverExpire() {
        builder.addShard(replicaShardRouting.moveToStarted());
        );  
import org.opensearch.common.collect.Tuple;
            .build();
import java.util.Collections;
 */
        tracker.markAllocationIdAsInSync(replicaAllocationId.getId(), randomCheckpoint());
            UNASSIGNED_SEQ_NO,
        replicationTracker.updateFromClusterManager(  
            primaryAllocationId
import org.opensearch.cluster.metadata.IndexMetadata;
                ).collect(Collectors.toSet())
        final String unknownNodeId = randomAlphaOfLength(10);  
            .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, true)  
            )  
                : randomLongBetween(0, Long.MAX_VALUE - currentTimeMillis.get()))
                    .collect(Collectors.toSet())
        );
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
import org.opensearch.index.IndexSettings;
                randomFrom(randomNonNegativeLong(), (long) randomIntBetween(0, Integer.MAX_VALUE)),
 * Unless required by applicable law or agreed to in writing,
        assertThat(leaseIds, hasSize(2));
            builder.build()  
                replicationTracker.routingTable.shards()
        assertThat(leaseIds, hasSize(3));
import org.opensearch.cluster.routing.ShardRouting;
        currentTimeMillis.set(currentTimeMillis.get() + randomLongBetween(0, Long.MAX_VALUE - currentTimeMillis.get()));  
        final Set<String> leaseIds = retentionLeases.v2().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());  
                    IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(),
        );
    public void testPeerRecoveryRetentionLeasesRetainedWithSegmentsOnlyRemoteStore() throws InterruptedException {
            Collections.singleton(replicaAllocationId),
            (leases, listener) -> {},  
    private SafeCommitInfo randomSafeCommitInfo() {
                .put(
        );
        replicationTracker.addPeerRecoveryRetentionLease(unknownNodeId, globalCheckpoint, EMPTY_LISTENER);
        assertFalse(retentionLeases.v1());
            leaseIds,  
            .map(RetentionLease::id)
import org.opensearch.common.unit.TimeValue;
            leaseIds,
                    .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
/*
                    TimeValue.timeValueMillis(randomLongBetween(1, TimeValue.timeValueHours(12).millis()))  
        assertTrue(retentionLeases.v1());
            randomLongBetween(
        assertThat(leaseIds, hasSize(2));
     */  
        );
        if (randomBoolean()) {
 * You may obtain a copy of the License at  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            equalTo(
            primaryAllocationId.getId(),
        final Tuple<Boolean, RetentionLeases> retentionLeases = replicationTracker.getRetentionLeases(true);  
import java.util.concurrent.atomic.AtomicLong;  
                currentTimeMillis.get() + IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.get(settings).millis() + 1,  
                )
        safeCommitInfo = randomSafeCommitInfoSuitableForOpsBasedRecovery(globalCheckpoint);
        final long localCheckpoint = randomLongBetween(NO_OPS_PERFORMED, globalCheckpoint);  
        final String unknownNodeId = randomAlphaOfLength(10);
                    .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
        // simulate a safe commit that is behind the given global checkpoint, so that no files need to be transferrred
    /**
        final IndexShardRoutingTable routingTableWithReplica = routingTable(  
        );
    private SafeCommitInfo safeCommitInfo;
            )  
import java.util.stream.Stream;
                Long.MAX_VALUE
        );
        final Set<String> leaseIds = retentionLeases.v2().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());  
            new ShardId("test", "_na", 0),  
import org.junit.Before;
            UNASSIGNED_SEQ_NO,  
        safeCommitInfo = randomSafeCommitInfo();
        final ShardRouting replicaShardRouting = replicationTracker.routingTable.replicaShards().get(0);
            startReplica();  
            settings = Settings.builder()  
            primaryTerm,
                    Stream.of(ReplicationTracker.getPeerRecoveryRetentionLeaseId(unknownNodeId)),  
            equalTo(
        assertThat(leaseIds, hasSize(2));
            () -> safeCommitInfo,
        final String unknownNodeId = randomAlphaOfLength(10);  
            randomLongBetween(1, Long.MAX_VALUE),  
    private SafeCommitInfo randomSafeCommitInfoSuitableForOpsBasedRecovery(long globalCheckpoint) {
            sId -> true  
        safeCommitInfo = randomSafeCommitInfoSuitableForFileBasedRecovery(globalCheckpoint);
        assertThat("the replica's peer recovery retention lease should survive", leaseIds, hasSize(2));
        assertThat(
            );
        startReplica();  
 * under the License.  
                    .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
        final Set<String> leaseIds = tracker.getRetentionLeases(true)
        currentTimeMillis.set(
     * recovers by replaying operations from the primary, so its peer recovery retention lease must be preserved.  
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
 */
        assertThat(leaseIds, hasSize(2));
                replicationTracker.routingTable.shards()  
        tracker.activatePrimaryMode(NO_OPS_PERFORMED);  
 * SPDX-License-Identifier: Apache-2.0
            : new SafeCommitInfo(
                randomIntBetween(0, Integer.MAX_VALUE)  
                    .stream()  
        replicationTracker.initiateTracking(replicaAllocationId.getId());
    public void testPeerRecoveryRetentionLeasesForUnassignedCopiesDoNotExpireImmediatelyIfShardsNotAllStarted() {
    private SafeCommitInfo randomSafeCommitInfoSuitableForFileBasedRecovery(long globalCheckpoint) {
        final Set<String> leaseIds = retentionLeases.v2().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());
        );  
                Stream.concat(
 * KIND, either express or implied.  See the License for the
        );  
            primaryAllocationId.getId(),  
 * Licensed to Elasticsearch under one or more contributor  
}
 *
                0,
        assertThat(
            currentTimeMillis::get,  
import org.opensearch.core.index.shard.ShardId;  
        );
                    .collect(Collectors.toSet())
        if (randomBoolean()) {
            equalTo(
            Collections.singleton(primaryAllocationId.getId()),  
 * ownership. Elasticsearch licenses this file to you under  
        );  
import java.util.stream.Collectors;
            leaseIds,  
            replicationTracker.appliedClusterStateVersion + 1,
            replicationTracker.routingTable.shards().stream().map(sr -> sr.allocationId().getId()).collect(Collectors.toSet()),
        replicationTracker.addPeerRecoveryRetentionLease(unknownNodeId, globalCheckpoint, EMPTY_LISTENER);
        replicationTracker.updateFromClusterManager(2L, Collections.singleton(primaryAllocationId.getId()), routingTableWithReplica);
            startReplica();  
        } else {  
/*  
    }  
import org.opensearch.cluster.routing.IndexShardRoutingTable;  
            settings = Settings.EMPTY;
            )
        final long globalCheckpoint = randomNonNegativeLong(); // not NO_OPS_PERFORMED since this always results in file-based recovery  
import org.opensearch.common.settings.Settings;  
        safeCommitInfo = randomSafeCommitInfoSuitableForOpsBasedRecovery(globalCheckpoint);
        tracker.updateFromClusterManager(2L, Collections.singleton(primaryAllocationId.getId()), routingTableWithReplica);
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
    private void startReplica() {
        return randomBoolean()
 *
        if (randomBoolean()) {
        final Tuple<Boolean, RetentionLeases> retentionLeases = replicationTracker.getRetentionLeases(true);  
import static org.hamcrest.Matchers.hasSize;
        final Set<String> leaseIds = retentionLeases.v2().leases().stream().map(RetentionLease::id).collect(Collectors.toSet());  
            routingTableWithReplica.getByAllocationId(replicaAllocationId.getId()).currentNodeId(),  
                    .stream()
        final IndexShardRoutingTable.Builder builder = new IndexShardRoutingTable.Builder(replicationTracker.routingTable);  
        replicationTracker.markAllocationIdAsInSync(replicaAllocationId.getId(), randomCheckpoint());  
            routingTable(Collections.emptySet(), primaryAllocationId)
        assertFalse("should not have expired anything", retentionLeases.v1());
                replicationTracker.routingTable.shards()
            Collections.singleton(primaryAllocationId.getId()),  
        return randomBoolean() ? SequenceNumbers.NO_OPS_PERFORMED : randomNonNegativeLong();
        tracker.initiateTracking(replicaAllocationId.getId());
        currentTimeMillis = new AtomicLong(randomLongBetween(0, 1024));  
     * Segments-only remote store: a remote segment repository and no remote translog repository. A replica still
    }
        if (randomBoolean()) {
public class PeerRecoveryRetentionLeaseExpiryTests extends ReplicationTrackerTestCase {  
            startReplica();  
 * compatible open source license.
            IndexSettingsModule.newIndexSettings("test", settings),
            randomCheckpoint(),
        );
        final AllocationId replicaAllocationId = AllocationId.newInitializing();
            .collect(Collectors.toSet());  
                    .map(ReplicationTracker::getPeerRecoveryRetentionLeaseId)
            )  
