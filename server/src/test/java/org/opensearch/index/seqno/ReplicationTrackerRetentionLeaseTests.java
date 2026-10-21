            );
                assertThat(
            assertTrue(invoked.get());
        final AllocationId allocationId = AllocationId.newInitializing();
        addFuture.actionGet();
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
                        + " than the new retaining sequence number ["
     * @throws IOException if an I/O exception occurs loading the retention lease state file
            NON_REMOTE_DISCOVERY_NODE
            );
        final String source = randomAlphaOfLength(8);
            replicationTracker.addRetentionLease(Integer.toString(i), retainingSequenceNumber, "test-" + i, ActionListener.wrap(() -> {}));
        replicationTracker.updateFromClusterManager(
    }
            barrier.await();
        }
import java.util.Collections;
        assertThat(
            randomNonNegativeLong(),
        final AllocationId allocationId = AllocationId.newInitializing();
            final long expectedVersion = primaryMode ? 3L : 2L;
        assertThat(clonedLease.source(), equalTo("test-source"));
            () -> 0L,
    public void testReplicaIgnoresOlderRetentionLeasesVersion() {
            allocationId.getId(),
            Collections.singleton(allocationId.getId()),
            UNASSIGNED_SEQ_NO,
 * under the License.
            );
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.function.Function;
        }
                        + id
                    leases.leases().stream().collect(Collectors.toMap(RetentionLease::id, RetentionLease::retainingSequenceNumber)),
    public void testExpirationOnReplica() {
        );
            routingTable(Collections.emptySet(), allocationId)
            NON_REMOTE_DISCOVERY_NODE
            () -> 0L,
        replicationTracker.updateFromClusterManager(
            randomNonNegativeLong(),
            randomNonNegativeLong(),
        replicationTracker.updateFromClusterManager(
            assertRetentionLeases(replicationTracker, 1, retainingSequenceNumbers, primaryTerm, 2, false, false);
import java.util.concurrent.atomic.AtomicReference;
            allocationId.getId(),
            threads[i].start();
            assertRetentionLeases(replicationTracker, 1, retainingSequenceNumbers, primaryTerm, 3, true, false);
    }
                    replicationTracker.persistRetentionLeases(path);
            threads[i] = new Thread(() -> {
            final RetentionLeases retentionLeases = replicationTracker.getRetentionLeases();
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
            .loadLatestStateWithGeneration(logger, NamedXContentRegistry.EMPTY, path);
            );
        final Path path = createTempDir();
            primaryTerm,
        }
            () -> 0L,
            UNASSIGNED_SEQ_NO,
        final AllocationId allocationId = AllocationId.newInitializing();
            assertRetentionLeases(
    public void testRenewLeaseWithLowerRetainingSequenceNumber() throws Exception {
     * Test that we correctly synchronize writing the retention lease state file in {@link ReplicationTracker#persistRetentionLeases(Path)}.
                Integer.toString(i),
            }
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
import java.util.concurrent.atomic.AtomicBoolean;
        final int length = randomIntBetween(0, 8);
            routingTable(Collections.emptySet(), allocationId)
    }
        } else {
        final int length = randomIntBetween(0, 8);
            Collections.singleton(allocationId.getId()),
import java.util.ArrayList;
            () -> 0L,
            allocationId.getId(),
                    leases.leases().stream().collect(Collectors.toMap(RetentionLease::id, RetentionLease::retainingSequenceNumber)),
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            }
                    "the current retention lease with ["
        assertThat(clonedLease.retainingSequenceNumber(), equalTo(minimumRetainingSequenceNumber));
import java.nio.file.Path;
            value -> {},
        replicationTracker.persistRetentionLeases(path);
            NON_REMOTE_DISCOVERY_NODE
        final long retainingSequenceNumber = randomNonNegativeLong();
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
        }
            });
            final int innerLength = randomIntBetween(0, 8);
            (leases, listener) -> {},
            replicationTracker.updateRetentionLeasesOnReplica(retentionLeases);
        }
        final long retentionLeaseMillis = randomLongBetween(1, TimeValue.timeValueHours(12).millis());
        try {
            routingTable(Collections.emptySet(), allocationId)
        );
            final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            retainingSequenceNumbers.put(id, retainingSequenceNumber);
                replicationTracker.setOperationPrimaryTerm(primaryTerm);
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        final int length = randomIntBetween(0, 8);
            value -> {},
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
            .stream()
            final Tuple<Boolean, RetentionLeases> tuple = replicationTracker.getRetentionLeases(true);
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        final RetentionLeaseNotFoundException e = expectThrows(
        } else {
        final int length = randomIntBetween(0, 8);
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
            hasToString(
            primaryTerm,
        {
            UNASSIGNED_SEQ_NO,
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        );
            ).getMessage(),
            Collections.singleton(allocationId.getId()),
            expectedLeases = retentionLeasesCollection.get(length - 1).leases();
        );
        final Map<String, Long> retainingSequenceNumbers = new HashMap<>();
        final RetentionLease clonedLease = replicationTracker.cloneRetentionLease("source", "target", cloneFuture);
            primaryTerm,
            assertRetentionLeases(replicationTracker, i + 1, minimumRetainingSequenceNumbers, primaryTerm, 2 + i, true, false);
    }
        final long primaryTerm,
}
 * You may obtain a copy of the License at
            primaryTerm,
            assertTrue(tuple.v1());
            final String id = randomAlphaOfLength(8);
    public void testExpirationOnPrimary() {
            final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            randomNonNegativeLong(),
            NON_REMOTE_DISCOVERY_NODE
 */
            Collections.singleton(allocationId.getId()),
            replicationTracker.addRetentionLease(id, retainingSequenceNumber, "test", ActionListener.wrap(() -> {}));
            randomNonNegativeLong(),
            (leases, listener) -> {},
            assertThat(replicationTracker.getRetentionLeases().leases(), empty());
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
import org.opensearch.common.unit.TimeValue;
            replicationTracker.removeRetentionLease(Integer.toString(length - i - 1), ActionListener.wrap(() -> {}));
            randomNonNegativeLong(),
                replicationTracker,
            final String id = Integer.toString(length + i);
                minimumRetainingSequenceNumbers[i],
        assertThat(retentionLeasesWithGenerationAfterUnnecessaryPersistence.v1(), equalTo(retentionLeasesWithGeneration.v1()));
        );
            primaryTerm,
        );
                Collections.singleton(new RetentionLease("0", retainingSequenceNumbers[0], currentTimeMillis.get(), "test-0"))
        replicationTracker.addRetentionLease(id, retainingSequenceNumber, source, ActionListener.wrap(() -> {}));
        final int length = randomIntBetween(0, 8);
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
        if (expireLeases == false) {
            value -> {},
        assertThat(replicationTracker.getRetentionLeases().get("target"), equalTo(clonedLease));
        );
        final long version,
            (leases, listener) -> {
            randomNonNegativeLong(),
                    barrier.await();
                replicationTracker.setOperationPrimaryTerm(primaryTerm);
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
            assertThat(retentionLease.source(), equalTo("test-" + i));
            () -> 0L,
                "test-" + i,
 * this file be licensed under the Apache-2.0 license or a
        for (final RetentionLeases retentionLeases : retentionLeasesCollection) {
                threads[i].join();
            new ShardId("test", "_na", 0),
            .collect(Collectors.toMap(RetentionLease::id, Function.identity()));
                2 + length + i,
        );
        for (int i = 0; i < length; i++) {
            randomNonNegativeLong(),
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
 * SPDX-License-Identifier: Apache-2.0
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
        final AllocationId allocationId = AllocationId.newInitializing();
            allocationId.getId(),
            () -> 0L,
            }
        final AtomicReference<ReplicationTracker> reference = new AtomicReference<>();
    }
            UNASSIGNED_SEQ_NO,
            randomLongBetween(1, Long.MAX_VALUE),
            new ShardId("test", "_na", 0),
        replicationTracker.updateFromClusterManager(
        final String id = randomAlphaOfLength(8);
            randomLongBetween(1, Long.MAX_VALUE),
            NON_REMOTE_DISCOVERY_NODE
            assertFalse(invoked.get());
        final AtomicBoolean invoked = new AtomicBoolean();
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
        reference.set(replicationTracker);
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
        replicationTracker.updateFromClusterManager(
            new ShardId("test", "_na", 0),
            (leases, listener) -> {},
        final RetentionLeaseInvalidRetainingSeqNoException e = expectThrows(
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), TimeValue.timeValueMillis(retentionLeaseMillis))
                primaryTerm,
            () -> 0L,
/*
    public void testRenewNotFoundRetentionLease() {
            UNASSIGNED_SEQ_NO,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertTrue(expireLeases == false || primaryMode);
    public void testCloneDuplicateRetentionLease() {
        final Path path = createTempDir();
        }
    public void testCloneNonexistentRetentionLease() {
            Collections.singleton(allocationId.getId()),
            routingTable(Collections.emptySet(), allocationId)
            primaryTerm,
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
            final long expectedVersion = primaryMode ? 2L : 1L;
        }
        replicationTracker.updateFromClusterManager(
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] not found")));
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(idToRetentionLease.entrySet(), hasSize(size));
            timeReference::get,
                final Tuple<Boolean, RetentionLeases> tuple = replicationTracker.getRetentionLeases(false);
                invoked.set(true);
        replicationTracker.updateFromClusterManager(
        );
import org.opensearch.index.IndexSettings;
/*
 *
                "test-" + i,
        final ReplicationTracker replicationTracker = new ReplicationTracker(
                minimumRetainingSequenceNumbers,
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
    }
        );
        final AllocationId allocationId = AllocationId.newInitializing();
 * ownership. Elasticsearch licenses this file to you under
            // leases do not expire on replicas until synced from the primary
            assertThat(retentionLease.retainingSequenceNumber(), equalTo(minimumRetainingSequenceNumbers[i]));
    }
            (leases, listener) -> {},
        }
    ) {
        final long minimumRetainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
                containsString(
                listener.onResponse(new ReplicationResponse());
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
            replicationTracker.updateRetentionLeasesOnReplica(retentionLeases);
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
        );
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            IndexSettingsModule.newIndexSettings("test", settings),
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            UNASSIGNED_SEQ_NO,
    }
            Collections.singleton(allocationId.getId()),
        assertTrue(synced.get());
            allocationId.getId(),
             * Remove from the end since it will make the following assertion easier; we want to ensure that only the intended lease was
        );
        for (int i = 0; i < length; i++) {
            NON_REMOTE_DISCOVERY_NODE
            new ShardId("test", "_na", 0),
        replicationTracker.updateFromClusterManager(
            value -> {},
        assertThat(clonedLease.id(), equalTo("target"));
            UNASSIGNED_SEQ_NO,
        );
        final AllocationId allocationId = AllocationId.newInitializing();
        final boolean primaryMode,
            final RetentionLeases retentionLeases = new RetentionLeases(
            new ShardId("test", "_na", 0),
 * software distributed under the License is distributed on an
            },
                        + retainingSequenceNumber
            new ShardId("test", "_na", 0),
            assertRetentionLeases(replicationTracker, 1, retainingSequenceNumbers, primaryTerm, expectedVersion, primaryMode, false);
        for (int i = 0; i < length; i++) {
            allocationId.getId(),
            primaryTerm,
        );
        final boolean expireLeases
            final String id = randomAlphaOfLength(8);
            assertThat(retentionLeases.leases(), hasSize(primaryMode ? 2 : 1));
    }
            value -> {},
                        + "]"
                primaryTerm++;
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
            assertThat(retentionLeases.version(), equalTo(expectedVersion));
        final AllocationId allocationId = AllocationId.newInitializing();
            }
import java.util.concurrent.BrokenBarrierException;
        final Tuple<RetentionLeases, Long> retentionLeasesWithGenerationAfterUnnecessaryPersistence = RetentionLeases.FORMAT
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            routingTable(Collections.emptySet(), allocationId)
                )
            NON_REMOTE_DISCOVERY_NODE
        final Path path = createTempDir();
    }
        final long[] retainingSequenceNumbers = new long[1];
            UNASSIGNED_SEQ_NO,
        );
        replicationTracker.addRetentionLease("source", randomLongBetween(0L, Long.MAX_VALUE), "test-source", ActionListener.wrap(() -> {}));
            replicationTracker.updateRetentionLeasesOnReplica(retentionLeases);
import org.opensearch.common.settings.Settings;
        retainingSequenceNumbers.put(ReplicationTracker.getPeerRecoveryRetentionLeaseId(nodeIdFromAllocationId(allocationId)), 0L);
            invoked.set(false);
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            () -> 0L,
public class ReplicationTrackerRetentionLeaseTests extends ReplicationTrackerTestCase {
        final RetentionLeases retentionLeases;
        replicationTracker.updateFromClusterManager(
            replicationTracker.addRetentionLease(Integer.toString(i), retainingSequenceNumber, "test-" + i, ActionListener.wrap(() -> {}));
            new ShardId("test", "_na", 0),
            randomNonNegativeLong(),
        );
        replicationTracker.updateFromClusterManager(
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            new ShardId("test", "_na", 0),
            expectedLeases = Collections.emptyList();
        final AtomicBoolean synced = new AtomicBoolean();
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            routingTable(Collections.emptySet(), allocationId)
            Collections.singleton(allocationId.getId()),
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        replicationTracker.addRetentionLease("source", minimumRetainingSequenceNumber, "test-source", addFuture);
 * specific language governing permissions and limitations
            final RetentionLease retentionLease = retentionLeases.get("0");
            retainingSequenceNumbers.remove(id);
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        final long retainingSequenceNumber = randomNonNegativeLong();
            assertThat(replicationTracker.getRetentionLeases().leases(), contains(expectedLeases.toArray(new RetentionLease[0])));
        final Map<String, Long> retainingSequenceNumbers = new HashMap<>();
    public void testRemoveRetentionLeaseCausesRetentionLeaseSync() {
        );
        runExpirationTest(true);
        );
    }
        final String id = randomAlphaOfLength(8);
        cloneFuture.actionGet();
            UNASSIGNED_SEQ_NO,
            expectThrows(
                try {
                    throw new AssertionError(e);
            replicationTracker.renewRetentionLease(id, retainingSequenceNumber, "test");
        retainingSequenceNumbers.put(ReplicationTracker.getPeerRecoveryRetentionLeaseId(nodeIdFromAllocationId(allocationId)), 0L);
                        + "]"
                primaryTerm,
            retentionLeasesCollection.add(new RetentionLeases(primaryTerm, version, leases));
                assertFalse(tuple.v1());
        final AllocationId allocationId = AllocationId.newInitializing();
        assertThat(retentionLeases.primaryTerm(), equalTo(primaryTerm));
    }
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        );
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
            equalTo("retention lease with ID [nonexistent-lease-id] not found")
        replicationTracker.updateFromClusterManager(
                assertThat(
                    barrier.await();
            (leases, listener) -> {},
        replicationTracker.updateFromClusterManager(
            UNASSIGNED_SEQ_NO,
            Collections.singleton(allocationId.getId()),
    }
        }
        assertThat(
            Collections.singleton(allocationId.getId()),
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
            // assert that the new retention lease callback was invoked
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
                    replicationTracker.addRetentionLease(id, retainingSequenceNumber, "test-" + id, ActionListener.wrap(() -> {}));
            value -> {},
    public void testRemoveRetentionLease() {
            (leases, listener) -> {
            final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
        for (int i = 0; i < length; i++) {
    }
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            new ShardId("test", "_na", 0),
import java.util.List;
            // reset the invocation marker so that we can assert the callback was not invoked when removing the lease
            }
            replicationTracker.removeRetentionLease(id, ActionListener.wrap(() -> {}));
            replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
    }
            NON_REMOTE_DISCOVERY_NODE
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] already exists")));
    public void testAddOrRenewRetentionLease() {
 * KIND, either express or implied.  See the License for the
        timeReference.set(addTime);
                Collections.singleton(new RetentionLease("0", retainingSequenceNumbers[0], currentTimeMillis.get(), "test-0"))
        );
            Collections.singleton(allocationId.getId()),
 * GitHub history for details.
            e,
        }
            allocationId.getId(),
        final long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
 * Unless required by applicable law or agreed to in writing,
                ActionListener.wrap(() -> {})
        runExpirationTest(false);
            logger,
        replicationTracker.addRetentionLease(id, retainingSequenceNumber, source, ActionListener.wrap(() -> {}));
        final long nextRetaininSequenceNumber = randomLongBetween(retainingSequenceNumber, Long.MAX_VALUE);
            allocationId.getId(),
        for (int i = 0; i < length; i++) {
        assertThat(
 * this work for additional information regarding copyright
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
                true,
                Integer.toString(i),
            UNASSIGNED_SEQ_NO,
        final AtomicReference<ReplicationTracker> reference = new AtomicReference<>();
                        + " is retaining a higher sequence number ["
            NON_REMOTE_DISCOVERY_NODE
        }
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
            new ShardId("test", "_na", 0),
            }
            retainingSequenceNumbers.put(id, retainingSequenceNumber);
        } else {
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
 * Licensed to Elasticsearch under one or more contributor
        final Collection<RetentionLease> expectedLeases;
            final RetentionLeases retentionLeases = replicationTracker.getRetentionLeases();
        );
        final AllocationId allocationId = AllocationId.newInitializing();
            final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
        replicationTrackerRef.set(replicationTracker);
        final int length = randomIntBetween(0, 8);
            primaryTerm,
                    equalTo(retainingSequenceNumbers)
            routingTable(Collections.emptySet(), allocationId)
            value -> {},
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
            allocationId.getId(),
    private void assertRetentionLeases(
        final RetentionLeaseAlreadyExistsException e = expectThrows(
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
            Collections.singleton(allocationId.getId()),
            (leases, listener) -> {},
                length - i - 1,
 * not use this file except in compliance with the License.
            for (int i = 0; i < numberOfThreads; i++) {
            randomNonNegativeLong(),
                // we do not want to hold a lock on the replication tracker in the callback!
        );
    public void testRemoveNotFound() {
        final Tuple<RetentionLeases, Long> retentionLeasesWithGeneration = RetentionLeases.FORMAT.loadLatestStateWithGeneration(
        replicationTracker.persistRetentionLeases(path);
            routingTable(Collections.emptySet(), allocationId)
            replicationTracker.addRetentionLease("0", retainingSequenceNumbers[0], "test-0", ActionListener.wrap(() -> {}));
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;
        final AllocationId allocationId = AllocationId.newInitializing();
        );
            assertRetentionLeases(replicationTracker, 1, retainingSequenceNumbers, primaryTerm, expectedVersion, primaryMode, false);
        }
        final int length = randomIntBetween(0, 8);
            allocationId.getId(),
        final AllocationId allocationId = AllocationId.newInitializing();
import static org.hamcrest.Matchers.contains;
            final RetentionLease retentionLease = idToRetentionLease.get(Integer.toString(i));
        );
        if (primaryMode) {
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
                replicationTracker.setOperationPrimaryTerm(primaryTerm);
            minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
            new ShardId("test", "_na", 0),
            );
        final AtomicReference<ReplicationTracker> replicationTrackerRef = new AtomicReference<>();
        for (int i = 0; i < size; i++) {
                () -> replicationTracker.cloneRetentionLease("nonexistent-lease-id", "target", ActionListener.wrap(() -> {}))
        replicationTracker.addRetentionLease("exists", randomLongBetween(0L, Long.MAX_VALUE), "test-source", ActionListener.wrap(() -> {}));
    public void testUnnecessaryPersistenceOfRetentionLeases() throws IOException {
                assertTrue(synced.compareAndSet(false, true));
        if (expectedLeases.isEmpty()) {
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
                leases.add(new RetentionLease(i + "-" + j, randomNonNegativeLong(), randomNonNegativeLong(), randomAlphaOfLength(8)));
        final AtomicBoolean invoked = new AtomicBoolean();
        assertThat(replicationTracker.loadRetentionLeases(path), equalTo(replicationTracker.getRetentionLeases()));
        {
        } else {
    public void testCloneRetentionLease() {
                false
        }
            }
        } else {
    private void runExpirationTest(final boolean primaryMode) {
        final AllocationId allocationId = AllocationId.newInitializing();
                minimumRetainingSequenceNumbers[i],
                        + lowerRetainingSequenceNumber
        }
            (leases, listener) -> {},
        synced.set(false);
import org.opensearch.action.support.PlainActionFuture;
                primaryTerm,
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        );
        assertThat(retentionLeases.version(), equalTo(version));
                retentionLeases = replicationTracker.getRetentionLeases();
            value -> {},
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
import org.opensearch.action.support.replication.ReplicationResponse;
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        long version = 0;
        replicationTracker.updateFromClusterManager(
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
            final RetentionLeases retentionLeases = new RetentionLeases(
            retentionLeases = tuple.v2();
            randomNonNegativeLong(),
            () -> 0L,
        replicationTracker.updateFromClusterManager(
 * Modifications Copyright OpenSearch Contributors. See
            routingTable(Collections.emptySet(), allocationId)
                    equalTo(retainingSequenceNumbers)
            replicationTracker.addRetentionLease(
 */
import static org.hamcrest.Matchers.equalTo;
        );
            assertRetentionLeases(replicationTracker, 0, new long[0], primaryTerm, 4, true, true);
        final long[] minimumRetainingSequenceNumbers,
import java.io.IOException;
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
        if (primaryMode) {
    public void testAddDuplicateRetentionLease() {
            value -> {},
            currentTimeMillis::get,
import org.opensearch.common.collect.Tuple;
        }
            randomNonNegativeLong(),
            final Collection<RetentionLease> leases = new ArrayList<>();
            .build();
            value -> {},
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
                invoked.set(true);
            },
            Collections.singleton(allocationId.getId()),
            NON_REMOTE_DISCOVERY_NODE
            final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
 * license agreements. See the NOTICE file distributed with
        assertThat(clonedLease.timestamp(), equalTo(cloneTime));
            replicationTracker.renewRetentionLease("0", retainingSequenceNumbers[0], "test-0");
        for (int i = 0; i < length; i++) {
        );
    }
        );
            routingTable(Collections.emptySet(), allocationId)
        for (int i = 0; i < length; i++) {
        final AllocationId allocationId = AllocationId.newInitializing();
            UNASSIGNED_SEQ_NO,
            assertThat(retentionLeases.version(), equalTo(expectedVersion));
            // reset the invocation marker so that we can assert the callback was not invoked when renewing the lease
            assertThat(retentionLease.timestamp(), equalTo(currentTimeMillis.get()));
                replicationTracker.setOperationPrimaryTerm(primaryTerm);
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
            allocationId.getId(),
    public void testAddRetentionLeaseCausesRetentionLeaseSync() {
                        + "] from ["
            randomLongBetween(1, Long.MAX_VALUE),
            routingTable(Collections.emptySet(), allocationId)
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
        // renew the lease
            primaryTerm,
            path
            routingTable(Collections.emptySet(), allocationId)
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
        final PlainActionFuture<ReplicationResponse> addFuture = new PlainActionFuture<>();
            /*
    }
            RetentionLeaseInvalidRetainingSeqNoException.class,
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            () -> 0L,
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        final ReplicationTracker replicationTracker = new ReplicationTracker(
                assertFalse(Thread.holdsLock(reference.get()));
            () -> replicationTracker.addRetentionLease(id, nextRetaininSequenceNumber, source, ActionListener.wrap(() -> {}))
            randomNonNegativeLong(),
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            // synchronize the threads invoking ReplicationTracker#persistRetentionLeases(Path path)
        }
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
import static org.hamcrest.Matchers.containsString;
    public void testLoadAndPersistRetentionLeases() throws IOException {
            RetentionLeaseNotFoundException.class,
        );
        final AtomicLong currentTimeMillis = new AtomicLong(randomLongBetween(0, 1024));
                () -> replicationTracker.cloneRetentionLease("source", "exists", ActionListener.wrap(() -> {}))
                // we do not want to hold a lock on the replication tracker in the callback!
                replicationTracker.setOperationPrimaryTerm(primaryTerm);
        replicationTracker.updateFromClusterManager(
        } catch (final BrokenBarrierException | InterruptedException e) {
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        final long addTime = randomLongBetween(timeReference.get(), Long.MAX_VALUE);
            expectThrows(
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
     */
            allocationId.getId(),
        if (primaryMode) {
package org.opensearch.index.seqno;
            UNASSIGNED_SEQ_NO,
            () -> 0L,
            allocationId.getId(),
            value -> {},
import org.opensearch.core.action.ActionListener;
            routingTable(Collections.emptySet(), allocationId)
                } catch (final BrokenBarrierException | InterruptedException | WriteStateException e) {
        assertThat(replicationTracker.getRetentionLeases().version(), equalTo(version));
                );
import java.util.concurrent.atomic.AtomicLong;
                assertFalse(Thread.holdsLock(reference.get()));
            () -> 0L,
        }
            new ShardId("test", "_na", 0),
            randomNonNegativeLong(),
            replicationTracker.renewRetentionLease(Integer.toString(i), minimumRetainingSequenceNumbers[i], "test-" + i);
            (leases, listener) -> {},
                replicationTracker.setOperationPrimaryTerm(primaryTerm);
            ).getMessage(),
            assertRetentionLeases(replicationTracker, length, minimumRetainingSequenceNumbers, primaryTerm, 2 + length + i, true, false);
            UNASSIGNED_SEQ_NO,
                1,
        final long lowerRetainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, retainingSequenceNumber - 1);
        );
        );
            replicationTracker.addRetentionLease(Integer.toString(i), retainingSequenceNumber, "test-" + i, ActionListener.wrap(() -> {}));
            routingTable(Collections.emptySet(), allocationId)
            NamedXContentRegistry.EMPTY,
        for (int i = 0; i < length; i++) {
        }
            assertThat(retentionLease.timestamp(), equalTo(currentTimeMillis.get()));
        );
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        final AtomicLong timeReference = new AtomicLong();
        retainingSequenceNumbers[0] = randomLongBetween(0, Long.MAX_VALUE);
            invoked.set(false);
            UNASSIGNED_SEQ_NO,
        );
import org.opensearch.test.IndexSettingsModule;
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
import org.opensearch.gateway.WriteStateException;
            assertThat(idToRetentionLease.keySet(), hasItem(Integer.toString(i)));
            allocationId.getId(),
import java.util.stream.Collectors;
            RetentionLeaseAlreadyExistsException.class,
import org.opensearch.core.index.shard.ShardId;
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        retainingSequenceNumbers[0] = randomLongBetween(retainingSequenceNumbers[0], Long.MAX_VALUE);
        assertThat(retentionLeasesWithGenerationAfterUnnecessaryPersistence.v2(), equalTo(retentionLeasesWithGeneration.v2()));
        final String id = randomAlphaOfLength(8);
            barrier.await();
            value -> {},
            version++;
        final String id = randomAlphaOfLength(8);
                        + source
     * This test can fail without the synchronization block in that method.
        final String source = randomAlphaOfLength(8);
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
                2,
                    final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            )
        assertThat(replicationTracker.loadRetentionLeases(path), equalTo(replicationTracker.getRetentionLeases()));
            Collections.singleton(allocationId.getId()),
                        + "]"
                assertFalse(Thread.holdsLock(replicationTrackerRef.get()));
            minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
            new ShardId("test", "_na", 0),
                RetentionLeaseAlreadyExistsException.class,
            randomNonNegativeLong(),
        );
 * compatible open source license.
        );
            // wait for all the threads to finish
        final long[] minimumRetainingSequenceNumbers = new long[length];
        );
            randomNonNegativeLong(),
        final ReplicationTracker replicationTracker,
        if (length == 0 || retentionLeasesCollection.get(length - 1).leases().isEmpty()) {
            new ShardId("test", "_na", 0),
            (leases, listener) -> {},
        final Thread[] threads = new Thread[numberOfThreads];
import java.util.Collection;
            (leases, listener) -> {},
        final ReplicationTracker replicationTracker = new ReplicationTracker(
 */
        assertTrue(synced.get());
            randomNonNegativeLong(),
        final int size,
        );
            () -> replicationTracker.renewRetentionLease(id, lowerRetainingSequenceNumber, source)
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            NON_REMOTE_DISCOVERY_NODE
import static org.hamcrest.Matchers.hasSize;
        synced.set(false);
        } else {
            () -> replicationTracker.removeRetentionLease(id, ActionListener.wrap(() -> {}))
            () -> replicationTracker.renewRetentionLease(id, randomNonNegativeLong(), randomAlphaOfLength(8))
     *
/*
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
            final RetentionLease retentionLease = retentionLeases.get("0");
 *
        currentTimeMillis.set(currentTimeMillis.get() + randomLongBetween(retentionLeaseMillis, Long.MAX_VALUE - currentTimeMillis.get()));
                retentionLeases = tuple.v2();
            replicationTracker.addRetentionLease(
            .filter(retentionLease -> ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(retentionLease.source()) == false)
        );
        reference.set(replicationTracker);
            Collections.singleton(allocationId.getId()),
            value -> {},
            for (int j = 0; j < innerLength; j++) {
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
            randomNonNegativeLong(),
            }
        );
            NON_REMOTE_DISCOVERY_NODE
        replicationTracker.updateFromClusterManager(
            equalTo("retention lease with ID [exists] already exists")
            () -> 0L,
import java.util.Map;
        final int length = randomIntBetween(0, 8);
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] not found")));
    }
            } else {
import java.util.HashMap;
                }
        for (int i = 0; i < length; i++) {
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            (leases, listener) -> {},
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
        final PlainActionFuture<ReplicationResponse> cloneFuture = new PlainActionFuture<>();
        // now force the lease to expire
            assertThat(retentionLeases.leases(), hasSize(primaryMode ? 2 : 1));
            (leases, listener) -> {},
 * The OpenSearch Contributors require contributions made to
import static org.hamcrest.Matchers.hasToString;
            RetentionLeaseNotFoundException.class,
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            if (randomBoolean()) {
            NON_REMOTE_DISCOVERY_NODE
            randomNonNegativeLong(),
        if (primaryMode) {
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
            (leases, listener) -> {
            NON_REMOTE_DISCOVERY_NODE
        }
            value -> {},
        );
            NON_REMOTE_DISCOVERY_NODE
            new ShardId("test", "_na", 0),
                replicationTracker.setOperationPrimaryTerm(primaryTerm);
        }
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
            (leases, listener) -> {},
            NON_REMOTE_DISCOVERY_NODE
            UNASSIGNED_SEQ_NO,
                ActionListener.wrap(() -> {})
            replicationTracker.addRetentionLease(id, retainingSequenceNumber, "test", ActionListener.wrap(() -> {}));
             */
        final AllocationId allocationId = AllocationId.newInitializing();
            allocationId.getId(),
            },
            }
            routingTable(Collections.emptySet(), allocationId)
            () -> 0L,
            if (rarely()) {
    /**
        }
        final long[] minimumRetainingSequenceNumbers = new long[length];
        final Settings settings = Settings.builder()
                RetentionLeaseNotFoundException.class,
            Collections.singleton(allocationId.getId()),
import static org.hamcrest.Matchers.hasItem;
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            assertTrue(invoked.get());
            throw new AssertionError(e);
        Collections.shuffle(retentionLeasesCollection, random());
            primaryTerm,
            // assert that the new retention lease callback was invoked
            new ShardId("test", "_na", 0),
        replicationTracker.persistRetentionLeases(path);
        final int numberOfThreads = randomIntBetween(1, 2 * Runtime.getRuntime().availableProcessors());
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        final List<RetentionLeases> retentionLeasesCollection = new ArrayList<>(length);
import static org.hamcrest.Matchers.empty;
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        for (int i = 0; i < numberOfThreads; i++) {
        final RetentionLeaseNotFoundException e = expectThrows(
        final long cloneTime = randomLongBetween(timeReference.get(), Long.MAX_VALUE);
import org.opensearch.cluster.routing.AllocationId;
        final Map<String, RetentionLease> idToRetentionLease = retentionLeases.leases()
            routingTable(Collections.emptySet(), allocationId)
            value -> {},
    public void testPersistRetentionLeasesUnderConcurrency() throws IOException {
            minimumRetainingSequenceNumbers[i] = randomLongBetween(minimumRetainingSequenceNumbers[i], Long.MAX_VALUE);
        final AllocationId allocationId = AllocationId.newInitializing();
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
                );
        final AllocationId allocationId = AllocationId.newInitializing();
            value -> {},
        currentTimeMillis.set(currentTimeMillis.get() + randomLongBetween(0, 1024));
            }
 *
            }
        for (int i = 0; i < length; i++) {
        timeReference.set(cloneTime);
import java.util.concurrent.CyclicBarrier;
            assertTrue(invoked.get());
            Collections.singleton(allocationId.getId()),
    }
            allocationId.getId(),
        long primaryTerm = 1;
             * removed.
        }
