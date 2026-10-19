                    shard.routingEntry(),  
        IndexMetadata indexMetadata = buildIndexMetadata(numberOfReplicas, settings, indexMapping);  
import org.opensearch.index.IndexSettings;
            RetentionLeases latestRetentionLeasesOnNewPrimary = newPrimary.getRetentionLeases();
                shard.updateShardState(
import java.util.List;  
    }  
                PlainActionFuture<ReplicationResponse> future = new PlainActionFuture<>();
                    null,
                    }
        try (ReplicationGroup group = createGroup(between(0, 2), settings)) {
        final Settings.Builder settings = Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true);  
import org.opensearch.test.VersionUtils;  
        IndexMetadata indexMetadata = buildIndexMetadata(numberOfReplicas, settings, indexMapping);  
        }  
                    group.getPrimary().getReplicationGroup().getRoutingTable(),
public class RetentionLeasesReplicationTests extends OpenSearchIndexLevelReplicationTestCase {
            group.startAll();  
            for (IndexShard replica : group.getReplicas()) {
    static final class SyncRetentionLeasesResponse extends ReplicationResponse {
                    group.removeRetentionLease(leaseToRemove.id(), ActionListener.wrap(latch::countDown));
import static org.hamcrest.Matchers.containsInAnyOrder;  
import org.opensearch.action.support.PlainActionFuture;
import org.opensearch.index.shard.IndexShardTestUtils;
                group.executeRetentionLeasesSyncRequestOnReplica(request, replica);  
                        randomNonNegativeLong(),  
                }  
            }
                containsInAnyOrder(leases.toArray(new RetentionLease[0]))  
                        latestRetentionLeasesOnNewPrimary = request.getRetentionLeases();  
import static org.hamcrest.Matchers.equalTo;
                group.addRetentionLease(Integer.toString(i), randomNonNegativeLong(), "test-" + i, future);  
            @Override
        }  
            }
            group.addRetentionLease("new-lease-after-promotion", randomNonNegativeLong(), "test", newLeaseFuture);
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
            int numLeases = between(1, 100);
import org.opensearch.common.Randomness;
 * software distributed under the License is distributed on an
            for (IndexShard replica : group.getReplicas()) {
 * this file be licensed under the Apache-2.0 license or a
                    1L,  
    }  
        SyncRetentionLeasesResponse(RetentionLeaseSyncAction.Request syncRequest) {
        int numberOfReplicas = between(2, 4);
        try (ReplicationGroup group = createGroup(between(1, 2), settings.build())) {
                    assertThat(shard.translogStats().estimatedNumberOfOperations(), equalTo(0));
                    leases.remove(leaseToRemove);
                listener.onResponse(new SyncRetentionLeasesResponse(new RetentionLeaseSyncAction.Request(shardId, leases)));
        try (ReplicationGroup group = new ReplicationGroup(indexMetadata) {
import org.opensearch.action.support.replication.ReplicationResponse;
                    );  
                // we turn off the translog retention policy using the generic threadPool  
            }
            protected void syncRetentionLeases(ShardId shardId, RetentionLeases leases, ActionListener<ReplicationResponse> listener) {  
        Settings settings = Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build();
                requests.add(((SyncRetentionLeasesResponse) future.actionGet()).syncRequest);
            assertBusy(() -> {
            }
        try (ReplicationGroup group = new ReplicationGroup(indexMetadata) {
            assertThat(leasesOnPrimary.version(), equalTo(iterations + group.getReplicas().size() + 1L));
            protected void syncRetentionLeases(ShardId shardId, RetentionLeases leases, ActionListener<ReplicationResponse> listener) {  
            assertThat(
                group.addRetentionLease(Integer.toString(i), randomNonNegativeLong(), "test-" + i, addLeaseFuture);
import org.opensearch.index.seqno.RetentionLeases;  
            // we need to make changes to retention leases to sync it to replicas
            int iterations = between(1, 100);
            RetentionLeases leasesOnPrimary = group.getPrimary().getRetentionLeases();
                    if (newPrimary == replica) {
            assertThat(leasesOnPrimary.version(), equalTo(latestRetentionLeasesOnNewPrimary.version() + 1));
import static org.hamcrest.Matchers.hasSize;
            assertThat(leasesOnPrimary.primaryTerm(), equalTo(group.getPrimary().getOperationPrimaryTerm()));
            });
            for (int i = 0; i < numLeases; i++) {
import org.opensearch.core.index.shard.ShardId;
            // since we don't sync retention leases when promoting a new primary.  
            }
    public void testOutOfOrderRetentionLeasesRequests() throws Exception {  
                assertThat(replica.getRetentionLeases(), equalTo(leasesOnPrimary));
                    shard.getOperationPrimaryTerm(),
    }
            List<RetentionLeaseSyncAction.Request> requests = new ArrayList<>();  
                    group.executeRetentionLeasesSyncRequestOnReplica(request, replica);
            group.syncGlobalCheckpoint();  
                        "test-" + i,
}  
            }
            RetentionLeases leasesOnPrimary = group.getPrimary().getRetentionLeases();  
 *
import org.opensearch.index.shard.IndexShard;
                );
            assertThat(leasesOnPrimary.leases(), hasSize(latestRetentionLeasesOnNewPrimary.leases().size() + 1));  
    }
                }
import org.opensearch.index.seqno.RetentionLeaseSyncAction;
/*  
 */  
                    RetentionLease leaseToRemove = randomFrom(leases);  
/*
                }
            assertThat(leasesOnPrimary.primaryTerm(), equalTo(group.getPrimary().getOperationPrimaryTerm()));  
/*  
import org.opensearch.cluster.metadata.IndexMetadata;  
    public void testSyncRetentionLeasesWithPrimaryPromotion() throws Exception {  
            IndexShard newPrimary = randomFrom(group.getReplicas());  
            for (int i = 0; i < iterations; i++) {
        final RetentionLeaseSyncAction.Request syncRequest;  
            }
                    RetentionLease newLease = group.addRetentionLease(
        }) {  
                    IndexShardTestUtils.getFakeDiscoveryNodes(shard.routingEntry())  
                replica.updateRetentionLeasesOnReplica(group.getPrimary().getRetentionLeases());  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
            PlainActionFuture<ReplicationResponse> newLeaseFuture = new PlainActionFuture<>();
            for (IndexShard replica : group.getReplicas()) {
            }
 * ownership. Elasticsearch licenses this file to you under  
            group.startAll();
 */
                if (leases.isEmpty() == false && rarely()) {
            group.promoteReplicaToPrimary(newPrimary).get();
 * under the License.  
 */  
    public void testTurnOffTranslogRetentionAfterAllShardStarted() throws Exception {
            latch.await();
 * specific language governing permissions and limitations
            List<RetentionLease> leases = new ArrayList<>();
            group.flush();
                RetentionLeaseSyncAction.Request request = ((SyncRetentionLeasesResponse) addLeaseFuture.actionGet()).syncRequest;
            for (IndexShard replica : group.getReplicas()) {
            group.startAll();
 * KIND, either express or implied.  See the License for the
    public void testSimpleSyncRetentionLeases() throws Exception {  
            RetentionLeases leasesOnPrimary = group.getPrimary().getRetentionLeases();  
                        ActionListener.wrap(latch::countDown)
 * the Apache License, Version 2.0 (the "License"); you may
            }
 * this work for additional information regarding copyright
    }
            settings.put(IndexMetadata.SETTING_VERSION_CREATED, VersionUtils.randomIndexCompatibleVersion(random()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
            }  
                assertThat(replica.getRetentionLeases(), equalTo(leasesOnPrimary));  
            for (IndexShard replica : group.getReplicas()) {  
import org.opensearch.index.seqno.RetentionLease;  
 * The OpenSearch Contributors require contributions made to  
            }  
                requests.forEach(request -> group.executeRetentionLeasesSyncRequestOnReplica(request, replica));  
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        }
import org.opensearch.common.settings.Settings;
                for (IndexShard shard : group) {
import org.opensearch.core.action.ActionListener;  
                } else {  
        }) {  
 *
import org.opensearch.index.seqno.RetentionLeaseUtils;
 *     http://www.apache.org/licenses/LICENSE-2.0
        Settings settings = Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build();
                    group.getPrimary().getReplicationGroup().getInSyncAllocationIds(),
                for (IndexShard replica : randomSubsetOf(group.getReplicas())) {  
import java.util.ArrayList;
                listener.onResponse(new SyncRetentionLeasesResponse(new RetentionLeaseSyncAction.Request(shardId, leases)));
        }
        Settings settings = Settings.builder().put(IndexSettings.INDEX_SOFT_DELETES_SETTING.getKey(), true).build();
            RetentionLeaseSyncAction.Request request = ((SyncRetentionLeasesResponse) newLeaseFuture.actionGet()).syncRequest;
            group.indexDocs(randomIntBetween(1, 10));  
            @Override
            this.syncRequest = syncRequest;  
                        Integer.toString(i),
            for (int i = 0; i < numLeases; i++) {
                assertThat(replica.getRetentionLeases(), equalTo(leasesOnPrimary));
            );
            CountDownLatch latch = new CountDownLatch(iterations);  
        if (randomBoolean()) {
            int numLeases = between(1, 10);
        }
 * Licensed to Elasticsearch under one or more contributor  
                PlainActionFuture<ReplicationResponse> addLeaseFuture = new PlainActionFuture<>();  
            for (IndexShard shard : group) {
                Randomness.shuffle(requests);
import java.util.concurrent.CountDownLatch;
        int numberOfReplicas = between(1, 2);
 * Modifications Copyright OpenSearch Contributors. See
            group.startAll();
 * license agreements. See the NOTICE file distributed with
package org.opensearch.index.replication;
 *  
                    leases.add(newLease);
                RetentionLeaseUtils.toMapExcludingPeerRecoveryRetentionLeases(leasesOnPrimary).values(),
