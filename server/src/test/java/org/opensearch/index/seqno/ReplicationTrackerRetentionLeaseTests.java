        }
                    throw new AssertionError(e);
            replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);  
            minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);  
            primaryTerm,  
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
            primaryTerm,  
            currentTimeMillis::get,
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            UNASSIGNED_SEQ_NO,  
        if (primaryMode) {
            randomNonNegativeLong(),
        currentTimeMillis.set(currentTimeMillis.get() + randomLongBetween(0, 1024));
        assertThat(replicationTracker.loadRetentionLeases(path), equalTo(replicationTracker.getRetentionLeases()));
            assertRetentionLeases(replicationTracker, length, minimumRetainingSequenceNumbers, primaryTerm, 2 + length + i, true, false);
        final Thread[] threads = new Thread[numberOfThreads];  
        final RetentionLeases retentionLeases;
                    "the current retention lease with ["
        final AtomicBoolean invoked = new AtomicBoolean();
            randomNonNegativeLong(),  
            final RetentionLease retentionLease = retentionLeases.get("0");
        }  
            } else {
            (leases, listener) -> {
        } else {  
import org.opensearch.common.settings.Settings;
            UNASSIGNED_SEQ_NO,
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        }
        // renew the lease
        );
                assertFalse(Thread.holdsLock(reference.get()));
            (leases, listener) -> {  
        final AllocationId allocationId = AllocationId.newInitializing();
            expectThrows(
        );
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        final AllocationId allocationId = AllocationId.newInitializing();
        replicationTracker.updateFromClusterManager(
 * KIND, either express or implied.  See the License for the
        final ReplicationTracker replicationTracker,
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
import java.util.concurrent.CyclicBarrier;
            () -> 0L,  
        final AllocationId allocationId = AllocationId.newInitializing();
            final String id = randomAlphaOfLength(8);
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,  
import java.util.concurrent.atomic.AtomicReference;
            final Collection<RetentionLease> leases = new ArrayList<>();
            value -> {},
                true,  
                Collections.singleton(new RetentionLease("0", retainingSequenceNumbers[0], currentTimeMillis.get(), "test-0"))
            .build();
        assertThat(  
            threads[i] = new Thread(() -> {  
        for (int i = 0; i < length; i++) {
        );  
        }  
/*
                        + id  
 * this work for additional information regarding copyright
            final long expectedVersion = primaryMode ? 2L : 1L;
        if (length == 0 || retentionLeasesCollection.get(length - 1).leases().isEmpty()) {  
            replicationTracker.updateRetentionLeasesOnReplica(retentionLeases);
        final int length = randomIntBetween(0, 8);  
/*  
            // synchronize the threads invoking ReplicationTracker#persistRetentionLeases(Path path)  
        replicationTracker.updateFromClusterManager(
            NON_REMOTE_DISCOVERY_NODE  
        );
        Collections.shuffle(retentionLeasesCollection, random());
            final RetentionLeases retentionLeases = replicationTracker.getRetentionLeases();
        retainingSequenceNumbers[0] = randomLongBetween(0, Long.MAX_VALUE);  
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
/*  
            allocationId.getId(),
import static org.opensearch.index.seqno.SequenceNumbers.UNASSIGNED_SEQ_NO;  
        final AllocationId allocationId = AllocationId.newInitializing();
        assertThat(idToRetentionLease.entrySet(), hasSize(size));
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            allocationId.getId(),  
    }
        final AllocationId allocationId = AllocationId.newInitializing();
        for (int i = 0; i < length; i++) {
    public void testExpirationOnPrimary() {
            randomNonNegativeLong(),
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);  
import java.io.IOException;
    }
            final String id = randomAlphaOfLength(8);
        replicationTracker.updateFromClusterManager(
        retainingSequenceNumbers.put(ReplicationTracker.getPeerRecoveryRetentionLeaseId(nodeIdFromAllocationId(allocationId)), 0L);
            Collections.singleton(allocationId.getId()),
            routingTable(Collections.emptySet(), allocationId)
             */
            final RetentionLeases retentionLeases = new RetentionLeases(
        }
            randomLongBetween(1, Long.MAX_VALUE),  
        final RetentionLeaseNotFoundException e = expectThrows(
        long primaryTerm = 1;  
                leases.add(new RetentionLease(i + "-" + j, randomNonNegativeLong(), randomNonNegativeLong(), randomAlphaOfLength(8)));  
 * Licensed to Elasticsearch under one or more contributor  
            () -> 0L,
            routingTable(Collections.emptySet(), allocationId)
                false
        final int length = randomIntBetween(0, 8);
    public void testRenewNotFoundRetentionLease() {  
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
            routingTable(Collections.emptySet(), allocationId)  
            version++;
                        + " than the new retaining sequence number ["
        replicationTrackerRef.set(replicationTracker);  
            Collections.singleton(allocationId.getId()),  
        final String id = randomAlphaOfLength(8);  
            allocationId.getId(),
            routingTable(Collections.emptySet(), allocationId)  
            NON_REMOTE_DISCOVERY_NODE  
        } else {
                        + "] from ["
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
        synced.set(false);  
        final Settings settings = Settings.builder()
            }
            barrier.await();  
        replicationTracker.updateFromClusterManager(  
            assertThat(retentionLeases.version(), equalTo(expectedVersion));  
            assertFalse(invoked.get());  
            NON_REMOTE_DISCOVERY_NODE
        long version = 0;
            randomLongBetween(1, Long.MAX_VALUE),  
        );  
        );
                    barrier.await();  
            }
            path  
                }  
            allocationId.getId(),
                primaryTerm,
            primaryTerm,  
            (leases, listener) -> {},
            Collections.singleton(allocationId.getId()),
            UNASSIGNED_SEQ_NO,
            UNASSIGNED_SEQ_NO,  
            routingTable(Collections.emptySet(), allocationId)
 * license agreements. See the NOTICE file distributed with
        {  
            expectedLeases = Collections.emptyList();
                length - i - 1,
            new ShardId("test", "_na", 0),
            assertTrue(invoked.get());
            routingTable(Collections.emptySet(), allocationId)
        final ReplicationTracker replicationTracker = new ReplicationTracker(  
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
        );
                retentionLeases = replicationTracker.getRetentionLeases();
            randomNonNegativeLong(),
            final String id = Integer.toString(length + i);
                        + source
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        final Path path = createTempDir();  
            randomNonNegativeLong(),
        retainingSequenceNumbers.put(ReplicationTracker.getPeerRecoveryRetentionLeaseId(nodeIdFromAllocationId(allocationId)), 0L);
            assertThat(retentionLease.timestamp(), equalTo(currentTimeMillis.get()));  
 * Modifications Copyright OpenSearch Contributors. See
    }  
     * @throws IOException if an I/O exception occurs loading the retention lease state file  
    }
 * under the License.  
        );
        timeReference.set(cloneTime);  
        final Collection<RetentionLease> expectedLeases;
            replicationTracker.addRetentionLease(  
            primaryTerm,
    }
            replicationTracker.addRetentionLease(Integer.toString(i), retainingSequenceNumber, "test-" + i, ActionListener.wrap(() -> {}));  
            barrier.await();
        final AllocationId allocationId = AllocationId.newInitializing();  
import org.opensearch.index.IndexSettings;
        final AllocationId allocationId = AllocationId.newInitializing();
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            }  
            randomLongBetween(1, Long.MAX_VALUE),  
 * the Apache License, Version 2.0 (the "License"); you may
            allocationId.getId(),
        final Path path = createTempDir();  
                1,  
        {  
            final RetentionLease retentionLease = idToRetentionLease.get(Integer.toString(i));
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,  
        assertThat(replicationTracker.getRetentionLeases().version(), equalTo(version));  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    leases.leases().stream().collect(Collectors.toMap(RetentionLease::id, RetentionLease::retainingSequenceNumber)),
        );
        final boolean expireLeases
            value -> {},
            retainingSequenceNumbers.put(id, retainingSequenceNumber);
    }
            allocationId.getId(),
            equalTo("retention lease with ID [nonexistent-lease-id] not found")
        for (int i = 0; i < length; i++) {  
        );  
                        + retainingSequenceNumber  
            }
        );
            retainingSequenceNumbers.remove(id);
    }
 * this file be licensed under the Apache-2.0 license or a
            UNASSIGNED_SEQ_NO,
        if (primaryMode) {
            Collections.singleton(allocationId.getId()),
    }  
                        + " is retaining a higher sequence number ["
import java.util.concurrent.atomic.AtomicBoolean;  
 * software distributed under the License is distributed on an
                2,  
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
                minimumRetainingSequenceNumbers[i],  
        replicationTracker.updateFromClusterManager(  
            retainingSequenceNumbers.put(id, retainingSequenceNumber);
     * Test that we correctly synchronize writing the retention lease state file in {@link ReplicationTracker#persistRetentionLeases(Path)}.  
        replicationTracker.persistRetentionLeases(path);  
        final int numberOfThreads = randomIntBetween(1, 2 * Runtime.getRuntime().availableProcessors());
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        final long primaryTerm,
        assertThat(clonedLease.retainingSequenceNumber(), equalTo(minimumRetainingSequenceNumber));
        replicationTracker.updateFromClusterManager(  
        }  
        final ReplicationTracker replicationTracker = new ReplicationTracker(  
        replicationTracker.updateFromClusterManager(
            new ShardId("test", "_na", 0),
 * specific language governing permissions and limitations
            allocationId.getId(),
            value -> {},  
            (leases, listener) -> {},  
            randomNonNegativeLong(),
            () -> 0L,
            NON_REMOTE_DISCOVERY_NODE
        runExpirationTest(true);  
            replicationTracker.addRetentionLease("0", retainingSequenceNumbers[0], "test-0", ActionListener.wrap(() -> {}));
            allocationId.getId(),
            primaryTerm,
            e,
            minimumRetainingSequenceNumbers[i] = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            threads[i].start();
        );  
                // we do not want to hold a lock on the replication tracker in the callback!
            assertRetentionLeases(replicationTracker, 1, retainingSequenceNumbers, primaryTerm, expectedVersion, primaryMode, false);
    ) {
            assertThat(retentionLeases.leases(), hasSize(primaryMode ? 2 : 1));
            value -> {},
 */  
            () -> replicationTracker.removeRetentionLease(id, ActionListener.wrap(() -> {}))  
        } else {  
            replicationTracker.addRetentionLease(
                    final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);  
            // assert that the new retention lease callback was invoked  
                2 + length + i,
            Collections.singleton(allocationId.getId()),  
            Collections.singleton(allocationId.getId()),
            assertThat(replicationTracker.getRetentionLeases().leases(), empty());
                replicationTracker.setOperationPrimaryTerm(primaryTerm);  
        final int size,
            invoked.set(false);
            Collections.singleton(allocationId.getId()),  
import static org.hamcrest.Matchers.empty;  
            replicationTracker.renewRetentionLease("0", retainingSequenceNumbers[0], "test-0");
        final List<RetentionLeases> retentionLeasesCollection = new ArrayList<>(length);
        } else {  
        );
        replicationTracker.updateFromClusterManager(  
            () -> 0L,  
        try {
            RetentionLeaseNotFoundException.class,
        for (int i = 0; i < length; i++) {
            equalTo("retention lease with ID [exists] already exists")
    public void testRenewLeaseWithLowerRetainingSequenceNumber() throws Exception {
        final AtomicReference<ReplicationTracker> reference = new AtomicReference<>();  
        );
            UNASSIGNED_SEQ_NO,
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        final Map<String, RetentionLease> idToRetentionLease = retentionLeases.leases()
        );
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        final long retainingSequenceNumber = randomNonNegativeLong();
                Integer.toString(i),
    public void testRemoveRetentionLease() {
                replicationTracker.setOperationPrimaryTerm(primaryTerm);  
            value -> {},
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
            UNASSIGNED_SEQ_NO,
        assertThat(clonedLease.source(), equalTo("test-source"));
        final long[] minimumRetainingSequenceNumbers = new long[length];  
            replicationTracker.renewRetentionLease(Integer.toString(i), minimumRetainingSequenceNumbers[i], "test-" + i);
            NON_REMOTE_DISCOVERY_NODE  
            Collections.singleton(allocationId.getId()),
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);  
            (leases, listener) -> {},
        for (final RetentionLeases retentionLeases : retentionLeasesCollection) {  
            (leases, listener) -> {},
            }
    public void testCloneDuplicateRetentionLease() {  
                threads[i].join();
        if (expectedLeases.isEmpty()) {
            (leases, listener) -> {},  
            UNASSIGNED_SEQ_NO,
package org.opensearch.index.seqno;
            minimumRetainingSequenceNumbers[i] = randomLongBetween(minimumRetainingSequenceNumbers[i], Long.MAX_VALUE);  
            value -> {},
        assertThat(retentionLeasesWithGenerationAfterUnnecessaryPersistence.v1(), equalTo(retentionLeasesWithGeneration.v1()));
        );  
            Collections.singleton(allocationId.getId()),  
                replicationTracker.setOperationPrimaryTerm(primaryTerm);  
import org.opensearch.core.xcontent.NamedXContentRegistry;  
    public void testAddOrRenewRetentionLease() {
        }  
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
            randomNonNegativeLong(),  
            () -> 0L,
import org.opensearch.cluster.routing.AllocationId;  
        );
                invoked.set(true);  
            assertTrue(invoked.get());
            for (int j = 0; j < innerLength; j++) {
    }
            allocationId.getId(),
        } catch (final BrokenBarrierException | InterruptedException e) {
        final int length = randomIntBetween(0, 8);
            }
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
                        + lowerRetainingSequenceNumber  
     */
import java.util.Collections;  
        assertTrue(synced.get());
            value -> {},  
        cloneFuture.actionGet();  
                final Tuple<Boolean, RetentionLeases> tuple = replicationTracker.getRetentionLeases(false);  
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);  
        final AllocationId allocationId = AllocationId.newInitializing();  
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
                minimumRetainingSequenceNumbers,  
import java.nio.file.Path;  
                invoked.set(true);  
            new ShardId("test", "_na", 0),  
            .stream()  
                assertFalse(Thread.holdsLock(replicationTrackerRef.get()));
        for (int i = 0; i < numberOfThreads; i++) {
            new ShardId("test", "_na", 0),  
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
            replicationTracker.removeRetentionLease(Integer.toString(length - i - 1), ActionListener.wrap(() -> {}));
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,  
            final RetentionLease retentionLease = retentionLeases.get("0");
            assertRetentionLeases(replicationTracker, 1, retainingSequenceNumbers, primaryTerm, expectedVersion, primaryMode, false);
            if (rarely() && primaryTerm < Long.MAX_VALUE) {  
import java.util.Map;  
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        for (int i = 0; i < length; i++) {
            // wait for all the threads to finish
                primaryTerm,
        final int length = randomIntBetween(0, 8);
        }  
import org.opensearch.common.collect.Tuple;
        }
                RetentionLeaseAlreadyExistsException.class,
            NON_REMOTE_DISCOVERY_NODE  
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] not found")));
            new ShardId("test", "_na", 0),
            new ShardId("test", "_na", 0),  
            () -> 0L,  
            value -> {},
        }
        }
        );  
            logger,
            new ShardId("test", "_na", 0),  
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
        }
                RetentionLeaseNotFoundException.class,
            timeReference::get,  
            assertRetentionLeases(replicationTracker, i + 1, minimumRetainingSequenceNumbers, primaryTerm, 2 + i, true, false);
        final AtomicBoolean invoked = new AtomicBoolean();
                replicationTracker.setOperationPrimaryTerm(primaryTerm);
        assertThat(clonedLease.timestamp(), equalTo(cloneTime));  
            UNASSIGNED_SEQ_NO,  
            value -> {},  
        replicationTracker.persistRetentionLeases(path);
        final int length = randomIntBetween(0, 8);
        assertThat(clonedLease.id(), equalTo("target"));
            routingTable(Collections.emptySet(), allocationId)
                () -> replicationTracker.cloneRetentionLease("source", "exists", ActionListener.wrap(() -> {}))  
        replicationTracker.updateFromClusterManager(
            );
            new ShardId("test", "_na", 0),
            ).getMessage(),
            () -> replicationTracker.renewRetentionLease(id, lowerRetainingSequenceNumber, source)
import org.opensearch.gateway.WriteStateException;
        );
        }  
        for (int i = 0; i < length; i++) {
        final AllocationId allocationId = AllocationId.newInitializing();
            (leases, listener) -> {},
            UNASSIGNED_SEQ_NO,
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);  
    public void testCloneRetentionLease() {  
            replicationTracker.addRetentionLease(id, retainingSequenceNumber, "test", ActionListener.wrap(() -> {}));
 * Unless required by applicable law or agreed to in writing,
        );
        final Tuple<RetentionLeases, Long> retentionLeasesWithGenerationAfterUnnecessaryPersistence = RetentionLeases.FORMAT
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);  
            assertTrue(invoked.get());
                );
            primaryTerm,
                primaryTerm++;
        final long minimumRetainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            () -> 0L,  
import org.opensearch.core.index.shard.ShardId;
        replicationTracker.addRetentionLease("exists", randomLongBetween(0L, Long.MAX_VALUE), "test-source", ActionListener.wrap(() -> {}));
    }  
        }
 * The OpenSearch Contributors require contributions made to  
    public void testAddDuplicateRetentionLease() {  
                Integer.toString(i),
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            for (int i = 0; i < numberOfThreads; i++) {
                } catch (final BrokenBarrierException | InterruptedException | WriteStateException e) {
    public void testUnnecessaryPersistenceOfRetentionLeases() throws IOException {
        replicationTracker.addRetentionLease(id, retainingSequenceNumber, source, ActionListener.wrap(() -> {}));
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);  
            NON_REMOTE_DISCOVERY_NODE  
        final Path path = createTempDir();  
        assertTrue(synced.get());
        replicationTracker.updateFromClusterManager(
            (leases, listener) -> {},
            assertThat(idToRetentionLease.keySet(), hasItem(Integer.toString(i)));  
            UNASSIGNED_SEQ_NO,
            () -> 0L,
            primaryTerm,
                    equalTo(retainingSequenceNumbers)  
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,  
        final AtomicReference<ReplicationTracker> reference = new AtomicReference<>();  
    }  
        for (int i = 0; i < length; i++) {  
            final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);  
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
            UNASSIGNED_SEQ_NO,
        assertThat(  
        final ReplicationTracker replicationTracker = new ReplicationTracker(
    public void testRemoveNotFound() {  
    private void assertRetentionLeases(  
            replicationTracker.renewRetentionLease(id, retainingSequenceNumber, "test");
import java.util.ArrayList;
        final PlainActionFuture<ReplicationResponse> cloneFuture = new PlainActionFuture<>();
        }
            new ShardId("test", "_na", 0),  
            assertThat(retentionLease.source(), equalTo("test-" + i));  
            allocationId.getId(),
                        + "]"  
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
            RetentionLeaseNotFoundException.class,
import static org.hamcrest.Matchers.hasToString;
        final long addTime = randomLongBetween(timeReference.get(), Long.MAX_VALUE);
            ).getMessage(),
        final AllocationId allocationId = AllocationId.newInitializing();
            NON_REMOTE_DISCOVERY_NODE
    public void testExpirationOnReplica() {  
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
        final ReplicationTracker replicationTracker = new ReplicationTracker(  
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] not found")));
            },
            () -> 0L,  
                "test-" + i,  
            );  
                containsString(
        final String source = randomAlphaOfLength(8);  
        final long cloneTime = randomLongBetween(timeReference.get(), Long.MAX_VALUE);
                replicationTracker.setOperationPrimaryTerm(primaryTerm);
                    equalTo(retainingSequenceNumbers)  
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
    }
            () -> 0L,
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
            (leases, listener) -> {  
            final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            assertThat(replicationTracker.getRetentionLeases().leases(), contains(expectedLeases.toArray(new RetentionLease[0])));
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,  
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
        assertThat(e, hasToString(containsString("retention lease with ID [" + id + "] already exists")));  
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            .loadLatestStateWithGeneration(logger, NamedXContentRegistry.EMPTY, path);
import static org.hamcrest.Matchers.hasItem;
            final int innerLength = randomIntBetween(0, 8);  
            new ShardId("test", "_na", 0),
        replicationTracker.updateFromClusterManager(
        for (int i = 0; i < length; i++) {  
import java.util.stream.Collectors;
        final ReplicationTracker replicationTracker = new ReplicationTracker(
            randomNonNegativeLong(),  
            (leases, listener) -> {},
    }
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        replicationTracker.addRetentionLease("source", minimumRetainingSequenceNumber, "test-source", addFuture);  
        final RetentionLeaseInvalidRetainingSeqNoException e = expectThrows(  
        final Tuple<RetentionLeases, Long> retentionLeasesWithGeneration = RetentionLeases.FORMAT.loadLatestStateWithGeneration(  
        if (primaryMode) {
    }  
        }
        assertThat(retentionLeasesWithGenerationAfterUnnecessaryPersistence.v2(), equalTo(retentionLeasesWithGeneration.v2()));
            assertRetentionLeases(replicationTracker, 1, retainingSequenceNumbers, primaryTerm, 3, true, false);
            new ShardId("test", "_na", 0),
        final String id = randomAlphaOfLength(8);
            });
            primaryTerm,
                    replicationTracker.addRetentionLease(id, retainingSequenceNumber, "test-" + id, ActionListener.wrap(() -> {}));
        );
            RetentionLeaseAlreadyExistsException.class,  
import java.util.List;
        final long version,
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        }
            routingTable(Collections.emptySet(), allocationId)
        if (expireLeases == false) {
            primaryTerm,  
            );
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
    private void runExpirationTest(final boolean primaryMode) {
            }
            assertThat(retentionLease.retainingSequenceNumber(), equalTo(minimumRetainingSequenceNumbers[i]));
            );
            randomNonNegativeLong(),
            routingTable(Collections.emptySet(), allocationId)
        final AllocationId allocationId = AllocationId.newInitializing();
            routingTable(Collections.emptySet(), allocationId)  
            assertRetentionLeases(replicationTracker, 0, new long[0], primaryTerm, 4, true, true);
        if (primaryMode) {  
        // now force the lease to expire
            value -> {},
            NON_REMOTE_DISCOVERY_NODE
        replicationTracker.updateFromClusterManager(
                listener.onResponse(new ReplicationResponse());
            randomNonNegativeLong(),  
            () -> 0L,
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),  
            randomNonNegativeLong(),
import org.opensearch.action.support.PlainActionFuture;
        }
        final long[] minimumRetainingSequenceNumbers = new long[length];
             * removed.  
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);  
        final RetentionLeaseNotFoundException e = expectThrows(
            randomNonNegativeLong(),
        final PlainActionFuture<ReplicationResponse> addFuture = new PlainActionFuture<>();
        replicationTracker.updateFromClusterManager(
            routingTable(Collections.emptySet(), allocationId)  
        assertThat(retentionLeases.primaryTerm(), equalTo(primaryTerm));  
import java.util.function.Function;  
        }
        );
        );  
            NON_REMOTE_DISCOVERY_NODE
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
        final int length = randomIntBetween(0, 8);
            invoked.set(false);
     * This test can fail without the synchronization block in that method.
        final AtomicLong timeReference = new AtomicLong();  
            UNASSIGNED_SEQ_NO,
            Collections.singleton(allocationId.getId()),
                "test-" + i,
            new ShardId("test", "_na", 0),  
            value -> {},  
 * not use this file except in compliance with the License.
        );
            () -> replicationTracker.renewRetentionLease(id, randomNonNegativeLong(), randomAlphaOfLength(8))  
            () -> replicationTracker.addRetentionLease(id, nextRetaininSequenceNumber, source, ActionListener.wrap(() -> {}))
    }  
                        + "]"
                    replicationTracker.persistRetentionLeases(path);
                ActionListener.wrap(() -> {})
                    barrier.await();
            throw new AssertionError(e);
        final long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
import java.util.concurrent.atomic.AtomicLong;
            randomNonNegativeLong(),  
                ActionListener.wrap(() -> {})
            allocationId.getId(),  
            // reset the invocation marker so that we can assert the callback was not invoked when renewing the lease  
import java.util.concurrent.BrokenBarrierException;
            Collections.singleton(allocationId.getId()),
        }
        final String id = randomAlphaOfLength(8);  
            // reset the invocation marker so that we can assert the callback was not invoked when removing the lease  
                assertTrue(synced.compareAndSet(false, true));  
            .filter(retentionLease -> ReplicationTracker.PEER_RECOVERY_RETENTION_LEASE_SOURCE.equals(retentionLease.source()) == false)
    public void testCloneNonexistentRetentionLease() {  
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);  
            replicationTracker.removeRetentionLease(id, ActionListener.wrap(() -> {}));  
                        + "]"
        reference.set(replicationTracker);  
 * compatible open source license.
    /**
            if (rarely()) {  
            final long expectedVersion = primaryMode ? 3L : 2L;
        );
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,
        final AllocationId allocationId = AllocationId.newInitializing();
            }
            new ShardId("test", "_na", 0),  
                () -> replicationTracker.cloneRetentionLease("nonexistent-lease-id", "target", ActionListener.wrap(() -> {}))  
            value -> {},
            (leases, listener) -> {},
        final long[] retainingSequenceNumbers = new long[1];
        final AllocationId allocationId = AllocationId.newInitializing();  
        } else {  
            (leases, listener) -> {},
import org.opensearch.action.support.replication.ReplicationResponse;
            replicationTracker.updateRetentionLeasesOnReplica(retentionLeases);  
            /*
 * You may obtain a copy of the License at  
            assertRetentionLeases(  
        assertThat(replicationTracker.loadRetentionLeases(path), equalTo(replicationTracker.getRetentionLeases()));
            Collections.singleton(allocationId.getId()),
    }
            Collections.singleton(allocationId.getId()),
            (leases, listener) -> {},
                retentionLeases = tuple.v2();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );  
            new ShardId("test", "_na", 0),  
            final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        addFuture.actionGet();
 */  
        reference.set(replicationTracker);  
                replicationTracker.setOperationPrimaryTerm(primaryTerm);  
        for (int i = 0; i < size; i++) {
                    leases.leases().stream().collect(Collectors.toMap(RetentionLease::id, RetentionLease::retainingSequenceNumber)),
        );
import static org.hamcrest.Matchers.equalTo;
            routingTable(Collections.emptySet(), allocationId)
            final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);
            NamedXContentRegistry.EMPTY,
        final long retentionLeaseMillis = randomLongBetween(1, TimeValue.timeValueHours(12).millis());
        final AtomicBoolean synced = new AtomicBoolean();
                replicationTracker.setOperationPrimaryTerm(primaryTerm);
                try {
        );
        replicationTracker.persistRetentionLeases(path);
            randomNonNegativeLong(),  
             * Remove from the end since it will make the following assertion easier; we want to ensure that only the intended lease was
        );  
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),  
            NON_REMOTE_DISCOVERY_NODE
        runExpirationTest(false);
            Collections.singleton(allocationId.getId()),
        final String source = randomAlphaOfLength(8);
            NON_REMOTE_DISCOVERY_NODE  
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        final AllocationId allocationId = AllocationId.newInitializing();  
        );  
    public void testAddRetentionLeaseCausesRetentionLeaseSync() {
        );
            randomNonNegativeLong(),
        );  
            replicationTracker.addRetentionLease(id, retainingSequenceNumber, "test", ActionListener.wrap(() -> {}));
            routingTable(Collections.emptySet(), allocationId)
            new ShardId("test", "_na", 0),
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
            randomNonNegativeLong(),
     *
            expectThrows(
        final AllocationId allocationId = AllocationId.newInitializing();  
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
import static org.hamcrest.Matchers.hasSize;  
        replicationTracker.updateFromClusterManager(
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
            NON_REMOTE_DISCOVERY_NODE
            Collections.singleton(allocationId.getId()),  
            value -> {},
            )
            if (randomBoolean()) {  
import java.util.Collection;
            assertThat(retentionLeases.leases(), hasSize(primaryMode ? 2 : 1));
        final long lowerRetainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, retainingSequenceNumber - 1);
        );  
        );
        final RetentionLease clonedLease = replicationTracker.cloneRetentionLease("source", "target", cloneFuture);
            allocationId.getId(),
        );
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
                minimumRetainingSequenceNumbers[i],
            primaryTerm,
            },
                Collections.singleton(new RetentionLease("0", retainingSequenceNumbers[0], currentTimeMillis.get(), "test-0"))
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);  
        );
 * GitHub history for details.
            NON_REMOTE_DISCOVERY_NODE  
            expectedLeases = retentionLeasesCollection.get(length - 1).leases();  
 *
        }
            routingTable(Collections.emptySet(), allocationId)
        assertTrue(expireLeases == false || primaryMode);  
 *
        currentTimeMillis.set(currentTimeMillis.get() + randomLongBetween(retentionLeaseMillis, Long.MAX_VALUE - currentTimeMillis.get()));
            allocationId.getId(),  
    public void testLoadAndPersistRetentionLeases() throws IOException {
import static org.hamcrest.Matchers.containsString;
        timeReference.set(addTime);  
        } else {
        );
        }
        final AtomicReference<ReplicationTracker> replicationTrackerRef = new AtomicReference<>();
            assertThat(retentionLeases.version(), equalTo(expectedVersion));  
import org.opensearch.test.IndexSettingsModule;  
                assertFalse(Thread.holdsLock(reference.get()));
            retentionLeases = tuple.v2();
            final long retainingSequenceNumber = randomLongBetween(SequenceNumbers.NO_OPS_PERFORMED, Long.MAX_VALUE);  
import org.opensearch.core.action.ActionListener;
            allocationId.getId(),
            Collections.singleton(allocationId.getId()),
        final ReplicationTracker replicationTracker = new ReplicationTracker(
                );
            final RetentionLeases retentionLeases = replicationTracker.getRetentionLeases();
 *  
            }  
import java.util.HashMap;
            );
        replicationTracker.addRetentionLease("source", randomLongBetween(0L, Long.MAX_VALUE), "test-source", ActionListener.wrap(() -> {}));  
        final int length = randomIntBetween(0, 8);  
}
            UNASSIGNED_SEQ_NO,
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        assertThat(replicationTracker.getRetentionLeases().get("target"), equalTo(clonedLease));  
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,  
        final int length = randomIntBetween(0, 8);
        for (int i = 0; i < length; i++) {
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
            assertRetentionLeases(replicationTracker, 1, retainingSequenceNumbers, primaryTerm, 2, false, false);
            value -> {},
                primaryTerm,
                )
    public void testRemoveRetentionLeaseCausesRetentionLeaseSync() {
            // assert that the new retention lease callback was invoked  
public class ReplicationTrackerRetentionLeaseTests extends ReplicationTrackerTestCase {  
        replicationTracker.addRetentionLease(id, retainingSequenceNumber, source, ActionListener.wrap(() -> {}));  
            allocationId.getId(),
                primaryTerm = randomLongBetween(primaryTerm + 1, Long.MAX_VALUE);
    }
import org.opensearch.common.unit.TimeValue;  
            IndexSettingsModule.newIndexSettings("test", settings),  
        final Map<String, Long> retainingSequenceNumbers = new HashMap<>();
        final AllocationId allocationId = AllocationId.newInitializing();  
            value -> {},
                replicationTracker,
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        final ReplicationTracker replicationTracker = new ReplicationTracker(  
                assertFalse(tuple.v1());
    public void testPersistRetentionLeasesUnderConcurrency() throws IOException {
        final Map<String, Long> retainingSequenceNumbers = new HashMap<>();
            }  
            replicationTracker.updateRetentionLeasesOnReplica(retentionLeases);  
                assertThat(
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
        for (int i = 0; i < length; i++) {  
        final long retainingSequenceNumber = randomNonNegativeLong();
            retentionLeasesCollection.add(new RetentionLeases(primaryTerm, version, leases));  
            randomNonNegativeLong(),  
        final String id = randomAlphaOfLength(8);  
        );  
            replicationTracker.addRetentionLease(Integer.toString(i), retainingSequenceNumber, "test-" + i, ActionListener.wrap(() -> {}));  
        assertThat(retentionLeases.version(), equalTo(version));
 */
            final RetentionLeases retentionLeases = new RetentionLeases(
            assertThat(retentionLease.timestamp(), equalTo(currentTimeMillis.get()));  
        }
            hasToString(  
            randomNonNegativeLong(),
            NON_REMOTE_DISCOVERY_NODE
            value -> {},
            .put(IndexSettings.INDEX_SOFT_DELETES_RETENTION_LEASE_PERIOD_SETTING.getKey(), TimeValue.timeValueMillis(retentionLeaseMillis))  
            UNASSIGNED_SEQ_NO,  
            NON_REMOTE_DISCOVERY_NODE
            (leases, listener) -> {},
        assertThat(
        final RetentionLeaseAlreadyExistsException e = expectThrows(
        );
            final Tuple<Boolean, RetentionLeases> tuple = replicationTracker.getRetentionLeases(true);
            routingTable(Collections.emptySet(), allocationId)
            routingTable(Collections.emptySet(), allocationId)
    }
        final long[] minimumRetainingSequenceNumbers,  
        final long nextRetaininSequenceNumber = randomLongBetween(retainingSequenceNumber, Long.MAX_VALUE);
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
        retainingSequenceNumbers[0] = randomLongBetween(retainingSequenceNumbers[0], Long.MAX_VALUE);  
            allocationId.getId(),  
            () -> 0L,  
 * SPDX-License-Identifier: Apache-2.0
                assertThat(
            () -> 0L,  
            RetentionLeaseInvalidRetainingSeqNoException.class,
        );
            () -> 0L,
            UNASSIGNED_SEQ_NO,
        final ReplicationTracker replicationTracker = new ReplicationTracker(
        replicationTracker.updateFromClusterManager(
            OPS_BASED_RECOVERY_ALWAYS_REASONABLE,  
            if (rarely() && primaryTerm < Long.MAX_VALUE) {
        final AtomicLong currentTimeMillis = new AtomicLong(randomLongBetween(0, 1024));  
            assertTrue(tuple.v1());  
        replicationTracker.activatePrimaryMode(SequenceNumbers.NO_OPS_PERFORMED);
            (leases, listener) -> {},
        final CyclicBarrier barrier = new CyclicBarrier(1 + numberOfThreads);
 * ownership. Elasticsearch licenses this file to you under  
        long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
            new ShardId("test", "_na", 0),
            // leases do not expire on replicas until synced from the primary
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),
            .collect(Collectors.toMap(RetentionLease::id, Function.identity()));
            }
                // we do not want to hold a lock on the replication tracker in the callback!
        synced.set(false);
    }
        final boolean primaryMode,  
    public void testReplicaIgnoresOlderRetentionLeasesVersion() {  
            IndexSettingsModule.newIndexSettings("test", Settings.EMPTY),  
        replicationTracker.updateFromClusterManager(
            },
            replicationTracker.addRetentionLease(Integer.toString(i), retainingSequenceNumber, "test-" + i, ActionListener.wrap(() -> {}));  
            randomNonNegativeLong(),  
import static org.hamcrest.Matchers.contains;
