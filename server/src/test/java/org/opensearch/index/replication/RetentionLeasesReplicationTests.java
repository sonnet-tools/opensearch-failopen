import org.opensearch.index.seqno.RetentionLease;
            assertThat(leasesOnPrimary.primaryTerm(), equalTo(group.getPrimary().getOperationPrimaryTerm()));
                    group.executeRetentionLeasesSyncRequestOnReplica(request, replica);
            }
 * specific language governing permissions and limitations
import org.opensearch.common.settings.Settings;
            for (IndexShard replica : group.getReplicas()) {
                containsInAnyOrder(leases.toArray(new RetentionLease[0]))
            protected void syncRetentionLeases(ShardId shardId, RetentionLeases leases, ActionListener<ReplicationResponse> listener) {
/*
        }) {
        int numberOfReplicas = between(2, 4);
                PlainActionFuture<ReplicationResponse> addLeaseFuture = new PlainActionFuture<>();
                listener.onResponse(new SyncRetentionLeasesResponse(new RetentionLeaseSyncAction.Request(shardId, leases)));
        final Settings.Builder settings = Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true);
                        "test-" + i,
            PlainActionFuture<ReplicationResponse> newLeaseFuture = new PlainActionFuture<>();
import org.opensearch.core.action.ActionListener;
}
import org.opensearch.index.shard.IndexShardTestUtils;
            latch.await();
                RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(leasesOnPrimary).values(),
                    null,
import static org.hamcrest.Matchers.containsInAnyOrder;
 * Licensed to Elasticsearch under one or more contributor
import java.util.ArrayList;
                );
            settings.put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomIndexCompatibleVersion(random()));
/*
import org.opensearch.test.VersionUtils;
                if (leases.isEmpty() == false && rarely()) {
                    group.removeRetentionLease(leaseToRemove.id(), ActionListener.wrap(latch::countDown));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            group.promoteReplicaToPrimary(newPrimary).get();
 * You may obtain a copy of the License at
                PlainActionFuture<ReplicationResponse> future = new PlainActionFuture<>();
            RetentionLeases leasesOnPrimary = group.getPrimary().getRetentionLeases();
            group.startAll();
        SyncRetentionLeasesResponse(RetentionLeaseSyncAction.Request syncRequest) {
            );
 * this work for additional information regarding copyright
                    assertThat(shard.translogStats().estimatedNumberOfOperations(), equalTo(0));
import static org.hamcrest.Matchers.hasSize;
                // we turn off the translog retention policy using the generic threadPool
            @Override
 *
 * not use this file except in compliance with the License.
    }
                }
                } else {
    }
            List<RetentionLease> leases = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.support.replication.ReplicationResponse;
            IndexShard newPrimary = randomFrom(group.getReplicas());
                    RetentionLease leaseToRemove = randomFrom(leases);
        Settings settings = Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build();
        Settings settings = Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build();
        try (ReplicationGroup group = new ReplicationGroup(indexMetadata) {
            group.indexDocs(randomIntBetween(1, 10));
            assertThat(leasesOnPrimary.primaryTerm(), equalTo(group.getPrimary().getOperationPrimaryTerm()));
            for (IndexShard replica : group.getReplicas()) {
        }
            for (int i = 0; i < numLeases; i++) {
 * under the License.
            assertThat(
/*
            }
 * The OpenSearch Contributors require contributions made to
                    RetentionLease newLease = group.addRetentionLease(
            assertThat(leasesOnPrimary.version(), equalTo(iterations + group.getReplicas().size() + 1L));
                    if (newPrimary == replica) {
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.common.Randomness;
            RetentionLeaseSyncAction.Request request = ((SyncRetentionLeasesResponse) newLeaseFuture.actionGet()).syncRequest;
                    group.getPrimary().getReplicationGroup().getRoutingTable(),
    public void testSyncRetentionLeasesWithPrimaryPromotion() throws Exception {
        Settings settings = Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build();
            this.syncRequest = syncRequest;
            group.addRetentionLease("new-lease-after-promotion", randomNonNegativeLong(), "test", newLeaseFuture);
 *
            group.startAll();
import org.opensearch.index.IndexSettings;
                for (IndexShard shard : group) {
                    shard.routingEntry(),
                group.executeRetentionLeasesSyncRequestOnReplica(request, replica);
                    IndexShardTestUtils.getFakeDiscoveryNodes(shard.routingEntry())
                        Integer.toString(i),
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under
 * compatible open source license.
import org.opensearch.index.seqno.RetentionLeaseSyncAction;
import java.util.List;
            group.startAll();
            RetentionLeases leasesOnPrimary = group.getPrimary().getRetentionLeases();
    static final class SyncRetentionLeasesResponse extends ReplicationResponse {
                Randomness.shuffle(requests);
 * Modifications Copyright OpenSearch Contributors. See
 */
            assertThat(leasesOnPrimary.leases(), hasSize(latestRetentionLeasesOnNewPrimary.leases().size() + 1));
            }
    }
            }
            }
            group.flush();
            }
                replica.updateRetentionLeasesOnReplica(group.getPrimary().getRetentionLeases());
            protected void syncRetentionLeases(ShardId shardId, RetentionLeases leases, ActionListener<ReplicationResponse> listener) {
            assertThat(leasesOnPrimary.version(), equalTo(latestRetentionLeasesOnNewPrimary.version() + 1));
        }
                    leases.add(newLease);
                        ActionListener.wrap(latch::countDown)
                        latestRetentionLeasesOnNewPrimary = request.getRetentionLeases();
        }) {
            // since we don't sync retention leases when promoting a new primary.
        try (ReplicationGroup group = createGroup(between(1, 2), settings.build())) {
public class RetentionLeasesReplicationTests extends OpenSearchIndexLevelReplicationTestCase {
        }
    }
            List<RetentionLeaseSyncAction.Request> requests = new ArrayList<>();
                RetentionLeaseSyncAction.Request request = ((SyncRetentionLeasesResponse) addLeaseFuture.actionGet()).syncRequest;
            int numLeases = between(1, 100);
import org.opensearch.action.support.PlainActionFuture;
                shard.updateShardState(
                group.addRetentionLease(Integer.toString(i), randomNonNegativeLong(), "test-" + i, addLeaseFuture);
 */
    public void testTurnOffTranslogRetentionAfterAllShardStarted() throws Exception {
    public void testOutOfOrderRetentionLeasesRequests() throws Exception {
                }
        try (ReplicationGroup group = createGroup(between(0, 2), settings)) {
        }
            RetentionLeases latestRetentionLeasesOnNewPrimary = newPrimary.getRetentionLeases();
                    );
            }
 */
import java.util.concurrent.CountDownLatch;
        IndexMetadata indexMetadata = buildIndexMetadata(numberOfReplicas, settings, indexMapping);
 * this file be licensed under the Apache-2.0 license or a
            group.startAll();
        final RetentionLeaseSyncAction.Request syncRequest;
            }
            }
                requests.forEach(request -> group.executeRetentionLeasesSyncRequestOnReplica(request, replica));
                requests.add(((SyncRetentionLeasesResponse) future.actionGet()).syncRequest);
        try (ReplicationGroup group = new ReplicationGroup(indexMetadata) {
                }
import org.opensearch.index.seqno.RetentionLeases;
        }
import org.opensearch.cluster.metadata.IndexMetadata;
                    }
        }
                listener.onResponse(new SyncRetentionLeasesResponse(new RetentionLeaseSyncAction.Request(shardId, leases)));
            group.syncGlobalCheckpoint();
                assertThat(replica.getRetentionLeases(), equalTo(leasesOnPrimary));
            @Override
            for (IndexShard shard : group) {
 * GitHub history for details.
    public void testSimpleSyncRetentionLeases() throws Exception {
                assertThat(replica.getRetentionLeases(), equalTo(leasesOnPrimary));
                group.addRetentionLease(Integer.toString(i), randomNonNegativeLong(), "test-" + i, future);
            CountDownLatch latch = new CountDownLatch(iterations);
    }
 *
            for (int i = 0; i < numLeases; i++) {
                for (IndexShard replica : randomSubsetOf(group.getReplicas())) {
            }
package org.opensearch.index.replication;
            RetentionLeases leasesOnPrimary = group.getPrimary().getRetentionLeases();
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
            // we need to make changes to retention leases to sync it to replicas
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.shard.IndexShard;
 *     http://www.apache.org/licenses/LICENSE-2.0
            for (IndexShard replica : group.getReplicas()) {
        if (randomBoolean()) {
                    leases.remove(leaseToRemove);
        int numberOfReplicas = between(1, 2);
            for (int i = 0; i < iterations; i++) {
import org.opensearch.index.seqno.RetentionLeaseUtils;
import org.opensearch.core.index.shard.ShardId;
            int numLeases = between(1, 10);
            }
                        randomNonNegativeLong(),
            assertBusy(() -> {
                    1L,
                    shard.getOperationPrimaryTerm(),
 * software distributed under the License is distributed on an
        IndexMetadata indexMetadata = buildIndexMetadata(numberOfReplicas, settings, indexMapping);
                assertThat(replica.getRetentionLeases(), equalTo(leasesOnPrimary));
            int iterations = between(1, 100);
            for (IndexShard replica : group.getReplicas()) {
                    group.getPrimary().getReplicationGroup().getInSyncAllocationIds(),
            for (IndexShard replica : group.getReplicas()) {
            });
