    /**
            Thread.sleep(50);
    private void executeShardOperationAsync(
            verify(mockIndexShard, never()).onMergesDrained(any(Runnable.class));
                callback.run();
                @Override
            assertTrue("Timeout should fire", latch.await(5, TimeUnit.SECONDS));
import org.opensearch.index.translog.TranslogStats;
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, shortTimeout);
            verify(mockIndexShard).flush(any(FlushRequest.class));
    }
    public void testShardOperationAsync_ShardClosed_FailsFast() throws Exception {
        doAnswer(invocation -> {
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(any(Runnable.class));
                        + "). Cannot prepare for tiering — will retry."
        executeShardOperation(mockIndexShard, primaryShardRouting);
    /**
            Runnable drainCallback = drainCallbackCaptor.getValue();
        inOrder.verify(mockIndexShard).waitForRemoteStoreSync();
                    latch.countDown();
        try {
            mockTransportService,
            assertNull("Should not have failed", failureRef.get());
            // onMergesDrained captures the callback but never invokes it (simulates stuck merges)
            when(mockIndexShard.state()).thenReturn(IndexShardState.CLOSED);
        mockIndexShard = mock(IndexShard.class);
                @Override
import java.util.concurrent.atomic.AtomicReference;
    }
    private Releasable mockPermit;
@SuppressWarnings("unchecked")
        if (indexShard.state() != IndexShardState.STARTED) {
            assertTrue("Message should mention not in STARTED state", failureRef.get().getMessage().contains("not in STARTED state"));
                Runnable callback = invocation.getArgument(0);
            ActionListener<Void> listener = new ActionListener<Void>() {
                    latch.countDown();
import org.opensearch.cluster.ClusterState;
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                @Override
     * Verifies that if waitForReplicaSync throws (replicas failed to sync in time),
            };
     * it will NOT execute end-to-end transport flows.
            Runnable drainCallback = drainCallbackCaptor.getValue();
                Runnable callback = invocation.getArgument(0);
            assertTrue("Message should report pending merges as yes", timeoutEx.getMessage().contains("pending: yes"));
            terminate(testThreadPool);
            indexShard.freezeForTiering();
            AtomicReference<Void> responseRef = new AtomicReference<>();
        mockPermitAcquisitionSuccess();
        original.writeTo(out);
    public void testPrepareTieringRequest_SerializationRoundTrip() throws IOException {
            indexShard.sync();
            when(mockIndexShard.getActiveMergeCount()).thenReturn(3);
            java.util.Set.of(TieringUtils.PREPARE_TIERING_TIMEOUT, TieringUtils.REPLICA_SYNC_TIMEOUT_SETTING)
        TimeValue mergeTimeout
            permit = permitFuture.actionGet();
            AtomicReference<Exception> failureRef = new AtomicReference<>();
                public void onFailure(Exception e) {
     */
                }
            assertNotNull("Should have received a failure", failureRef.get());
            CountDownLatch latch = new CountDownLatch(1);
    private ShardRouting primaryShardRouting;
        ShardRouting replica = TestShardRouting.newShardRouting(sid, "node2", false, ShardRoutingState.STARTED);
        when(mockIndicesService.indexServiceSafe(shardId.getIndex())).thenReturn(mockIndexService);
        assertThat(ex.getMessage(), containsString("[REPLICA_SYNC_TIMEOUT]"));
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
 * - Primary-only shard targeting
            }).when(mockIndexShard).onMergesDrained(any(Runnable.class));
import org.opensearch.storage.common.tiering.TieringUtils;
            verify(mockPermit, timeout(5000)).close();
            verify(mockPermit, timeout(5000)).close();
            verify(mockIndexShard).waitForRemoteStoreSync();
        mockPermitAcquisitionSuccess();
        verify(mockPermit, timeout(5000)).close();
        mockPermitAcquisitionSuccess();
            assertTrue("Listener should have been called", latch.await(5, TimeUnit.SECONDS));
                }
        TestThreadPool threadPool = new TestThreadPool(getTestName());
                timeoutTask.cancel();
            AtomicReference<Void> responseRef = new AtomicReference<>();
    // These construct an actual TransportPrepareTieringAction with mocked dependencies and assert
                public void onResponse(Void unused) {
        inOrder.verify(mockIndexShard).flush(any(FlushRequest.class));
     * the listener is registered and fires later when the drain callback is invoked.
            TimeValue shortTimeout = TimeValue.timeValueMillis(100);
        try {
                }
        ).when(mockIndexShard).waitForReplicaSync(any(TimeValue.class));
     * We replicate the logic here since the actual method requires full transport infrastructure.
        }).when(mockIndexShard).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
    }
            terminate(threadPool);
            assertEquals("Should have exactly 1 failure (timeout)", 1, failureCount.get());
                }
            };
                    responseRef.set(null);
            ActionListener<Void> listener = new ActionListener<Void>() {
        IndexShard indexShard,
            terminate(testThreadPool);
    }
        } finally {
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(drainCallbackCaptor.capture());
            ArgumentCaptor<Runnable> drainCallbackCaptor = ArgumentCaptor.forClass(Runnable.class);
            if (uncommitted > 0) {
        try {
        BytesStreamOutput out = new BytesStreamOutput();
        BytesStreamOutput out = new BytesStreamOutput();
            assertNotNull("Should have received a failure", failureRef.get());
        InOrder inOrder = inOrder(mockIndexShard);
    }
            return null;
                @Override
            indexShard.acquireAllPrimaryOperationsPermits(permitFuture, TimeValue.timeValueSeconds(30));
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
        TestThreadPool threadPool = new TestThreadPool(getTestName());
     * Tests that when the shard state is CLOSED (not STARTED), the operation fails
            assertTrue("Message should report shard id", timeoutEx.getMessage().contains(shardId.toString()));
            MergeDrainTimeoutException timeoutEx = (MergeDrainTimeoutException) failureRef.get();
 * - Primary permit acquisition before operations
import static org.hamcrest.Matchers.containsString;
import org.opensearch.index.shard.IndexShardState;
            terminate(testThreadPool);
        mockPermitAcquisitionSuccess();
            verify(mockIndexShard).flush(any(FlushRequest.class));
    /**
                    latch.countDown();
            throw new IOException("Failed to acquire primary operation permits for shard [" + shardRouting.shardId() + "]", e);
     * Tests the timeout path: when merges never drain, the scheduled timeout fires
        }
            AtomicReference<Exception> failureRef = new AtomicReference<>();
            ActionListener<Void> listener = new ActionListener<Void>() {
     * Simulates the shard operation logic from TransportPrepareTieringAction.shardOperation.
    /**
                    latch.countDown();
    public void testShardOperationAsync_PermitClosedOnDrainCallbackFailure() throws Exception {
            assertTrue("Listener should fire immediately", latch.await(5, TimeUnit.SECONDS));
            terminate(testThreadPool);
            verify(mockIndexShard, never()).onMergesDrained(any(Runnable.class));
        mockPermitAcquisitionFailure(new TimeoutException("Timed out waiting for permits"));
        mockPermitAcquisitionSuccess();
            }).when(mockIndexShard).onMergesDrained(any(Runnable.class));
            verify(mockPermit, timeout(5000)).close();
            };
                }
            assertTrue("Should be IOException", failureRef.get() instanceof IOException);
        doAnswer(invocation -> {
        }).when(mockIndexShard).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
            CountDownLatch latch = new CountDownLatch(1);
        // Use the same predicate as TransportPrepareTieringAction.shards()
        TimeValue effectiveTimeout = TimeValue.timeValueMillis(mergeTimeoutMillis);
        TranslogStats translogStats = mock(TranslogStats.class);
        PrepareTieringRequest deserialized = new PrepareTieringRequest(out.bytes().streamInput());
    }
    private IndicesService mockIndicesService;
 * compatible open source license.
                "Should be MergeDrainTimeoutException, got: " + failureRef.get().getClass().getName(),
import static org.mockito.Mockito.doThrow;
    }
                @Override
            verify(mockIndexShard, never()).freezeForTiering();
            );
     * Verifies that uncommitted ops > 0 after flush throws IOException.
 * SPDX-License-Identifier: Apache-2.0
            assertTrue("Timeout message should contain timeout value", timeoutEx.getMessage().contains("100ms"));
        Settings nodeSettings = Settings.EMPTY;
    }
        // Schedule timeout (named `timeoutTask` to avoid shadowing the Mockito.timeout static import)
                    latch.countDown();
            );
     */
        verify(mockPermit, timeout(5000)).close();
            assertNotNull("Should have received a failure", failureRef.get());
                public void onFailure(Exception e) {
        assertTrue(
            ActionListener<Void> listener = new ActionListener<Void>() {
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                    listener.onResponse(null);
            listener.onResponse(mockPermit);
                "[REPLICA_SYNC_TIMEOUT] Shard [[clickbench][0]] replicas failed to sync within 30s. "
import static org.mockito.ArgumentMatchers.any;
                } finally {
        Scheduler.ScheduledCancellable timeoutTask = threadPool.schedule(() -> {
     * and verifying the predicate filters correctly.
        var shardsIterator = clusterState.routingTable().allShardsSatisfyingPredicate(new String[] { "test-index" }, ShardRouting::primary);
                @Override
    }
        try {
        IOException thrown = expectThrows(IOException.class, () -> executeShardOperation(mockIndexShard, primaryShardRouting));
                }
            verify(mockIndexShard, never()).onMergesDrained(any(Runnable.class));
    private void completeSyncAndFlushForTest(IndexShard indexShard, ShardRouting shardRouting) throws IOException {
            mockPermitAcquisitionSuccess();
    }
     * Verifies that primary permits are acquired before sync/flush operations.
    }
     * Tests that the AtomicBoolean guard prevents double completion when both
                boolean hasPendingMerges = indexShard.hasPendingMerges();
     * receives an IOException mentioning the state issue.
            terminate(testThreadPool);
                public void onFailure(Exception e) {
        assertNotNull("Should have a cause", thrown.getCause());
                @Override
        assertTrue("Exception message should include the count", thrown.getMessage().contains("5"));
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
    private TransportPrepareTieringAction newRealAction(TestThreadPool threadPool) {
import org.opensearch.cluster.service.ClusterService;
            AtomicReference<Exception> failureRef = new AtomicReference<>();
            listener.onFailure(exception);
                    latch.countDown();
                @Override
import org.opensearch.threadpool.Scheduler;
        );
    }
        PrepareTieringRequest original = new PrepareTieringRequest();
import org.opensearch.indices.IndicesService;
                ex.getMessage().toLowerCase(Locale.ROOT).contains("shardoperationasync")
        return new TransportPrepareTieringAction(
import org.opensearch.threadpool.TestThreadPool;
        // Permit should still be released via finally block
            };
        if (uncommitted > 0) {
        }
                public void onFailure(Exception e) {
            terminate(testThreadPool);
import static org.mockito.Mockito.doAnswer;
    }
    /**
            terminate(testThreadPool);
            return null;
    /**
                }
                    failureRef.set(e);
        } finally {
                }
        } finally {
     * constructor requires. The mocked {@link TransportService#registerRequestHandler} is a no-op so
     */
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
import static org.mockito.Mockito.verify;
                }
        mockIndicesService = mock(IndicesService.class);
    /**
     */
                @Override
            doThrow(new IOException("sync failed in drain callback")).when(mockIndexShard).sync();
            assertTrue("Message should mention not STARTED", failureRef.get().getMessage().contains("not in STARTED state"));
            when(mockIndexShard.hasPendingMerges()).thenReturn(false);
package org.opensearch.storage.action.tiering;
                    latch.countDown();
 * this file be licensed under the Apache-2.0 license or a
            CountDownLatch latch = new CountDownLatch(1);
                    latch.countDown();
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(sid.getIndex()).addIndexShard(shardRoutingTable).build();
        indexShard.flush(new FlushRequest().force(true).waitIfOngoing(true));
     * Tests that when merges are already drained (onMergesDrained fires listener immediately),
     * simulation tests cannot enforce this contract because the simulation never invokes
import org.opensearch.common.settings.ClusterSettings;
    public void testShardOperationAsync_PermitAcquisitionFailure_AsyncPath() throws Exception {
            verify(mockIndexShard, never()).freezeForTiering();
                    failureRef.set(e);
            assertTrue("Message should mention CLOSED", failureRef.get().getMessage().contains("CLOSED"));
            verify(mockIndexShard).refresh("prepare_tiering");
                throw new IOException(
            if (completed.compareAndSet(false, true)) {
        IOException ex = expectThrows(IOException.class, () -> executeShardOperation(mockIndexShard, primaryShardRouting));
    }
            assertNull("Should not have failed", failureRef.get());
            assertTrue("Message should report pending merges as yes", timeoutEx.getMessage().contains("pending: yes"));
        super.setUp();
        verify(mockPermit, timeout(5000)).close();
            assertNotNull("Drain callback should have been captured", drainCallback);
                    latch.countDown();
            }
                new IOException("Failed to acquire primary operation permits for shard [" + shardRouting.shardId() + "]", e)
                    responseCount.incrementAndGet();
            verify(mockIndexShard, never()).freezeForTiering();
                    "Shard ["
import org.opensearch.transport.TransportService;
        }
    }
     */
                new IOException(
            ActionListener<Void> listener = new ActionListener<Void>() {
import java.util.concurrent.atomic.AtomicBoolean;
        when(mockIndexShard.translogStats()).thenReturn(translogStats);
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
                failureRef.get().getMessage().contains("Failed to acquire primary operation permits")
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(drainCallbackCaptor.capture());
        for (ShardRouting shard : shardsIterator) {
                @Override
            listener.onFailure(
                }
                    latch.countDown();
                public void onResponse(Void unused) {
                public void onFailure(Exception e) {
import static org.mockito.Mockito.timeout;
    /**
     * Tests that if the shard is not in STARTED state, the listener immediately
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
            // Capture the Runnable passed to onMergesDrained (do not invoke it yet)
            permit.close();
        IndexShardRoutingTable shardRoutingTable = new IndexShardRoutingTable.Builder(sid).addShard(primary).addShard(replica).build();
                }
        inOrder.verify(mockIndexShard).flush(any(FlushRequest.class));
import org.opensearch.common.settings.Settings;
        inOrder.verify(mockIndexShard).freezeForTiering();
                @Override
        }
     * the base-class constructor completes; {@link ClusterService#getSettings} and
    /**
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
            assertEquals("Should have 0 responses", 0, responseCount.get());
            TransportPrepareTieringAction action = newRealAction(threadPool);
    /**
    public void testPrepareTieringRequest_SerializationRoundTrip_NoIndices() throws IOException {
                public void onFailure(Exception e) {
    public void testShardOperationAsync_ShardNotStarted_FailsFast() throws Exception {
    /**
            assertTrue("Message should report active merges", timeoutEx.getMessage().contains("Active merges: 3"));
        }
        executeShardOperation(mockIndexShard, primaryShardRouting);
        PlainActionFuture<Releasable> permitFuture = new PlainActionFuture<>();
     * Tests that when merges are not yet drained (onMergesDrained registers listener),
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
    /**
            verify(mockIndexShard).refresh("prepare_tiering");
                    completionCount.incrementAndGet();
        when(translogStats.getUncommittedOperations()).thenReturn(0);
            ActionListener<Void> listener = new ActionListener<Void>() {
     * We test this by building a routing table with both primary and replica shards
                public void onResponse(Void unused) {
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
        assertTrue(
        ActionListener<Void> listener,
                    completeSyncAndFlushForTest(indexShard, shardRouting);
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
            when(mockIndexShard.getActiveMergeCount()).thenReturn(5);
        }
            mockPermitAcquisitionSuccess();
            ActionListener<Void> listener = new ActionListener<Void>() {
        }
            mockPermitAcquisitionSuccess();
                callback.run();
    public void testShardOperationAsync_FreezeForTieringCalledBeforeDrain() throws Exception {
                }
            AtomicReference<Exception> failureRef = new AtomicReference<>();
import org.opensearch.cluster.routing.TestShardRouting;
 *
        } finally {
    /**
    /**
                }
                    failureRef.set(e);
    /**
import org.opensearch.core.index.shard.ShardId;
                "Should be MergeDrainTimeoutException, got: " + failureRef.get().getClass().getName(),
    public void testShardOperationAsync_PermitAcquisitionFails() throws Exception {
                    );
            };
                        new MergeDrainTimeoutException(shardRouting.shardId(), activeMerges, hasPendingMerges, mergeTimeout.toString())
     * Tests that the AtomicBoolean guard correctly prevents double-firing when
            assertTrue("Listener should fire after timeout", latch.await(5, TimeUnit.SECONDS));
        ShardId sid = new ShardId(new Index("test-index", "test-uuid"), 0);
            terminate(testThreadPool);
                    latch.countDown();
            }
                }
            ActionListener<Void> listener = new ActionListener<Void>() {
}
            };
import org.opensearch.core.action.ActionListener;
        }
     * Tests that when permit acquisition calls listener.onFailure, the async path wraps it in an IOException.
     * Verifies that the shards() method only returns primary shards.
        RoutingTable routingTable = RoutingTable.builder().add(indexRoutingTable).build();
        when(translogStats.getUncommittedOperations()).thenReturn(5);
 * - Correct ordering of sync, flush, refresh, and remote store sync
            CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.threadpool.ThreadPool;
                @Override
            terminate(testThreadPool);
    // ── Wire serde tests ──────────────────────────────────────────────────────
     * Helper to mock acquireAllPrimaryOperationsPermits to immediately call the listener with a permit.
     * routes prepare through {@code shardOperationAsync} (non-blocking merge drain) rather than the
 * - Permit release on failure
            assertTrue("Only primary shards should be returned", shard.primary());
            Runnable drainCallback = drainCallbackCaptor.getValue();
                failureRef.get().getMessage().contains("Failed to acquire primary operation permits")
            assertEquals("Failure count should still be 1", 1, failureCount.get());
            mockPermitAcquisitionSuccess();
 */
     * Helper that replicates the async shard operation logic from
        }
                        + indexShard.state()
     * Tests that freezeForTiering() is called before onMergesDrained() is registered.
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
public class TransportPrepareTieringActionTests extends OpenSearchTestCase {
     * an IOException wrapping the permit failure cause.
     * {@code shardOperation}; only the real action does.
     */
                    latch.countDown();
                }
                int activeMerges = indexShard.getActiveMergeCount();
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
        IOException thrown = expectThrows(IOException.class, () -> executeShardOperation(mockIndexShard, primaryShardRouting));
        expectThrows(IOException.class, () -> executeShardOperation(mockIndexShard, primaryShardRouting));
            listener.onFailure(
     */
        original.writeTo(out);
        try {
    public void testShardOperation_PermitTimeout_ThrowsIOException() {
        } finally {
        inOrder.verify(mockIndexShard).sync();
            PlainActionFuture<Releasable> permitFuture = new PlainActionFuture<>();
            );
 * Unit tests for {@link TransportPrepareTieringAction} shard-level operations.
            verify(mockIndexShard).sync();
            ActionListener<Void> listener = new ActionListener<Void>() {
     * and waitForReplicaSync in order.
     * Tests that the permit is always closed on the drain callback path
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
    /**
        InOrder inOrder = inOrder(mockIndexShard);
    // ── Async shard operation tests (deadlock fix) ────────────────────────────
    /**
     */
            CountDownLatch latch = new CountDownLatch(1);
        mockPermit = mock(Releasable.class);
                @Override
import java.io.IOException;
                    latch.countDown();
            permit = permitFuture.actionGet();
    }
import static org.mockito.Mockito.never;
import java.util.concurrent.atomic.AtomicInteger;
            InOrder inOrder = inOrder(mockIndexShard);
        try {
            throw new IOException(
     */
     * Verifies that PrepareTieringRequest round-trips correctly over the wire (writeTo → StreamInput).
        );
            );
                @Override
                    permit.close();
            CountDownLatch latch = new CountDownLatch(1);
                }
        ThreadPool threadPool,
                    + "Replicas still behind: 1, max checkpoints behind: 2"
        );
                "Message should mention permit acquisition failure",
            TimeValue shortTimeout = TimeValue.timeValueMillis(50);
        try {
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
        }
                @Override
            terminate(testThreadPool);
import java.util.Locale;
                public void onFailure(Exception e) {
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
                public void onFailure(Exception e) {
        when(mockIndexService.getShard(0)).thenReturn(mockIndexShard);
        } finally {
        } finally {
        indexShard.refresh("prepare_tiering");
                public void onFailure(Exception e) {
                public void onResponse(Void unused) {
            ActionListener<Void> listener = new ActionListener<Void>() {
     * it is a sentinel that catches misuse if the framework ever calls the sync path despite
        // Verify permit was released despite the exception
 */
        TranslogStats translogStats = mock(TranslogStats.class);
            ActionListener<Void> listener = new ActionListener<Void>() {
            assertTrue("Cause should be the original RuntimeException", failureRef.get().getCause() instanceof RuntimeException);
        inOrder.verify(mockIndexShard).sync();
                    latch.countDown();
     */
            ArgumentCaptor<Runnable> drainCallbackCaptor = ArgumentCaptor.forClass(Runnable.class);
            assertNotNull("Should have a cause", failureRef.get().getCause());
    /**
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
            verify(mockIndexShard, never()).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
                }
     */
     * Constructs a real {@link TransportPrepareTieringAction} with the minimum mock dependencies its
import org.mockito.ArgumentCaptor;
                    latch.countDown();
                }
        ShardRouting primary = TestShardRouting.newShardRouting(sid, "node1", true, ShardRoutingState.STARTED);
            assertTrue("Should be IOException", failureRef.get() instanceof IOException);
            "Exception message should mention permit acquisition failure",
        PrepareTieringRequest original = new PrepareTieringRequest("my-index");
    private ShardId shardId;
    public void testRealAction_IsAsyncShardOperation_ReturnsTrue() {
                "Shard [" + shardRouting.shardId() + "] still has " + uncommitted + " uncommitted translog ops after flush"
            ActionListener<Releasable> listener = invocation.getArgument(0);
     */
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
    }
    /**
            assertTrue(
     * and the listener receives a MergeDrainTimeoutException with correct merge counts.
                }
                public void onFailure(Exception e) {
            }).when(mockIndexShard).onMergesDrained(drainCallbackCaptor.capture());
    public void testShardOperationAsync_AlreadyDrained_CompletesImmediately() throws Exception {
        }
            terminate(testThreadPool);
            assertNotNull("Should have received a failure", failureRef.get());
            AtomicReference<Exception> failureRef = new AtomicReference<>();
            assertNotNull("Should have received a failure", failureRef.get());
            ActionListener<Void> listener = new ActionListener<Void>() {
        }
     * the listener fires immediately with a successful response, and no timeout fires.
            AtomicReference<Exception> failureRef = new AtomicReference<>();
                    completionCount.incrementAndGet();
        }
            when(mockIndexShard.getActiveMergeCount()).thenReturn(2);
                @Override
                try {
     * The synchronous {@code shardOperation} path must throw {@link UnsupportedOperationException} —
            doAnswer(invocation -> {
        try {
            );
    ) {
        }
            int uncommitted = indexShard.translogStats().getUncommittedOperations();
        try {
                    latch.countDown();
 * The OpenSearch Contributors require contributions made to
        try {
            assertTrue("Message should report shard id", timeoutEx.getMessage().contains(shardId.toString()));
                    failureRef.set(e);
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
                }
            };
                    failureCount.incrementAndGet();
    }
                    latch.countDown();
     */
            Runnable drainCallback = drainCallbackCaptor.getValue();
        inOrder.verify(mockIndexShard).refresh("prepare_tiering");
import static org.mockito.Mockito.mock;
                    listener.onFailure(e);
        inOrder.verify(mockIndexShard).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
        }
        InOrder inOrder = inOrder(mockIndexShard);
                }
            "Exception message should mention uncommitted ops",
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
        }
            verify(mockPermit, timeout(5000)).close();
import org.opensearch.action.admin.indices.flush.FlushRequest;
                UnsupportedOperationException.class,
                    latch.countDown();
            );
            MergeDrainTimeoutException timeoutEx = (MergeDrainTimeoutException) failureRef.get();
                @Override
     */
            verify(mockPermit, timeout(5000)).close();
        } finally {
                // Do nothing — simulate merges not yet drained
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
            when(mockIndexShard.hasPendingMerges()).thenReturn(true);
    public void testShardOperation_SyncFlushRefreshAndWaitForRemoteSync() throws IOException {
    /**
 * - Uncommitted ops verification after flush
            assertTrue(
            new IOException(
        inOrder.verify(mockIndexShard).refresh("prepare_tiering");
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, shortTimeout);
                public void onFailure(Exception e) {
                    listener.onFailure(
                public void onFailure(Exception e) {
            AtomicInteger completionCount = new AtomicInteger(0);
        } catch (Exception e) {
            when(mockIndexShard.hasPendingMerges()).thenReturn(true);
            assertNotNull("Drain callback should have been captured", drainCallback);
            );
                    responseRef.set(null);
    /**
            indexShard.waitForReplicaSync(TimeValue.timeValueSeconds(30));
        indexShard.sync();
    public void testRealAction_ShardOperation_SyncSentinel_ThrowsUnsupported() {
        try {
        );
        } finally {
                public void onResponse(Void unused) {
    }
            mockIndicesService,
            mockPermitAcquisitionFailure(new TimeoutException("Timed out waiting for permits"));
     */
import org.opensearch.common.io.stream.BytesStreamOutput;
     * the drain callback arrives after the timeout has already fired.
    /**
                }
            verify(mockPermit, never()).close();
            assertTrue("Listener should fire immediately on permit failure", latch.await(5, TimeUnit.SECONDS));
        }, effectiveTimeout, ThreadPool.Names.GENERIC);
                    latch.countDown();
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(any(Runnable.class));
                    latch.countDown();
                }
            terminate(testThreadPool);
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueMillis(100));
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(any(Runnable.class));
            // When onMergesDrained is called, immediately invoke the Runnable (simulating already drained)
    /**
            assertTrue("Listener should fire after timeout", latch.await(5, TimeUnit.SECONDS));
            assertTrue("prepare must run async (non-blocking merge drain)", action.isAsyncShardOperation());
                try {
                }
        mockPermitAcquisitionSuccess();
import java.util.concurrent.CountDownLatch;
    public void testShardOperationAsync_PermitClosedOnSuccessPath() throws Exception {
            inOrder.verify(mockIndexShard).onMergesDrained(any(Runnable.class));
import java.util.concurrent.TimeUnit;
        });
     */
     */
    private void executeShardOperation(IndexShard indexShard, ShardRouting shardRouting) throws IOException {
        executeShardOperation(mockIndexShard, primaryShardRouting);
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
            assertTrue("Listener should fire after timeout", latch.await(5, TimeUnit.SECONDS));
import org.opensearch.core.index.Index;
            indexShard.waitForRemoteStoreSync();
                    latch.countDown();
                    permit.close();
     */
                    latch.countDown();
    public void testShardOperationAsync_TimeoutProduces_MergeDrainTimeoutException_WithCorrectFields() throws Exception {
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
        shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
        doThrow(
    }
     * the drain callback and timeout fire concurrently.
        } finally {
     * Tests that if permit acquisition fails, the listener immediately receives
            verify(mockIndexShard, never()).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
                callback.run();
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
     * Verifies that the shard operation calls sync, flush, refresh, waitForRemoteStoreSync,
                }
     * {@link TransportPrepareTieringAction#shardOperationAsync} for unit testing
            assertNotNull(drainCallback);
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(drainCallbackCaptor.capture());
        int count = 0;
        }
        }
/*
     */
        primaryShardRouting = TestShardRouting.newShardRouting(shardId, "node1", true, ShardRoutingState.STARTED);
     * the exception propagates and the prepare action fails — allowing retry.
                @Override
     * Tests that the permit is always closed on the success path (already drained).
            mockPermitAcquisitionSuccess();
            CountDownLatch latch = new CountDownLatch(1);
     * The real action must opt-in to async per-shard execution. This is the wiring decision that
        } finally {
     * synchronous {@code shardOperation} path. Pinning this on the real action — not the simulation —
            assertTrue("Message should contain the configured timeout", timeoutEx.getMessage().contains("50ms"));
            nodeSettings,
    }
                public void onResponse(Void unused) {
                Runnable callback = invocation.getArgument(0);
            };
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
            )
                public void onResponse(Void unused) {
            assertTrue("Listener should fire after drain callback", latch.await(5, TimeUnit.SECONDS));
     */
                    latch.countDown();
            thrown.getMessage().contains("Failed to acquire primary operation permits")
     */
                return null;
    }
    public void testShardOperationAsync_MergesDrainLater_ListenerFires() throws Exception {
                }
    }
            };
                public void onResponse(Void unused) {
import org.opensearch.action.support.PlainActionFuture;
                }
     */
    }
            }
    /**
            CountDownLatch latch = new CountDownLatch(1);
import org.opensearch.cluster.routing.IndexShardRoutingTable;
                }
        inOrder.verify(mockIndexShard).flush(any(FlushRequest.class));
     * Tests that the permit is always closed on the timeout path.
    /**
 * - Timeout handling on permit acquisition
            verify(mockIndexShard).waitForRemoteStoreSync();
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
            mock(IndexNameExpressionResolver.class)
            ActionListener<Void> listener = new ActionListener<Void>() {
        doThrow(new IOException("sync failed")).when(mockIndexShard).sync();
        inOrder.verify(mockIndexShard).sync();
     */
        } finally {
            drainCallback.run();
            CountDownLatch latch = new CountDownLatch(1);
            );
                @Override
                )
    private void mockPermitAcquisitionFailure(Exception exception) {
    public void testShardOperation_FreezesAndDrainsMergesBeforeFlush() throws IOException {
        AtomicBoolean completed = new AtomicBoolean(false);
     */
import org.opensearch.cluster.ClusterName;
        } catch (Exception e) {
        }
        indexShard.waitForRemoteStoreSync();
                failureRef.get() instanceof MergeDrainTimeoutException
            indexShard.flush(new FlushRequest().force(true).waitIfOngoing(true));
                    latch.countDown();
        indexShard.freezeForTiering();
            ActionListener<Void> listener = new ActionListener<Void>() {
            terminate(threadPool);
                @Override
                @Override
        inOrder.verify(mockIndexShard).waitForReplicaSync(any(TimeValue.class));
                @Override
     * Verifies round-trip with no indices (broadcast to all).
     * Verifies that the permit is released even if flush/sync throws an exception.
    /**
                    latch.countDown();
import org.opensearch.common.lease.Releasable;
    /**
            assertTrue("Listener should fire", latch.await(5, TimeUnit.SECONDS));
            assertEquals("Response count should still be 0", 0, responseCount.get());
            AtomicReference<Exception> failureRef = new AtomicReference<>();
    }
            CountDownLatch latch = new CountDownLatch(1);
    }
     * Verifies that the engine is frozen and in-flight merges are drained before the flush, so no
            UnsupportedOperationException ex = expectThrows(
                return null;
     * Verifies that timeout on permit acquisition throws IOException.
                }
                } catch (Exception e) {
     * merge mutates the catalog after the final refresh during tiering preparation.
            assertTrue(
        // Verify permit was released despite the exception
                    failureRef.set(e);
                () -> action.shardOperation(new PrepareTieringRequest("test-index"), primaryShardRouting)
    public void testShardOperationAsync_AtomicBooleanPreventsDoubleCompletion() throws Exception {
    }
            doAnswer(invocation -> {
        // Fail fast if shard is not fully started
        ClusterSettings clusterSettings = new ClusterSettings(
                    failureRef.set(e);
    public void testShardOperationAsync_PermitClosedOnTimeoutPath() throws Exception {
            CountDownLatch latch = new CountDownLatch(1);
        assertArrayEquals(original.indices(), deserialized.indices());
            doAnswer(invocation -> {
            mockPermitAcquisitionSuccess();
    public void testShardOperationAsync_Timeout_FiresMergeDrainTimeoutException() throws Exception {
                public void onResponse(Void unused) {
            assertEquals("Listener should be called exactly once despite race", 1, completionCount.get());
            assertTrue("Should be IOException", failureRef.get() instanceof IOException);
                @Override
                    latch.countDown();
        try {
            verify(mockPermit, timeout(5000)).close();
        } finally {
        when(mockClusterService.getClusterSettings()).thenReturn(clusterSettings);
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
        try {
        // Acquire permits (blocking via PlainActionFuture to match production code)
            assertTrue("Message should report active merges", timeoutEx.getMessage().contains("Active merges: 5"));
            AtomicReference<Exception> failureRef = new AtomicReference<>();
    public void testShardOperation_ReleasesPermitOnFailure() throws IOException {
                }
            TransportPrepareTieringAction action = newRealAction(threadPool);
            TimeValue shortTimeout = TimeValue.timeValueMillis(100);
                } finally {
        long mergeTimeoutMillis = (long) (mergeTimeout.millis() * 0.8);
     */
            assertTrue("Timeout should fire", latch.await(5, TimeUnit.SECONDS));
            );
                @Override
        try {
import static org.mockito.Mockito.when;
     * cleanly. The returned action is suitable for asserting protected/instance method contracts;
        int uncommitted = indexShard.translogStats().getUncommittedOperations();
            mockPermitAcquisitionFailure(new RuntimeException("permit denied"));
        indexShard.onMergesDrained(() -> {
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
            verify(mockPermit, timeout(5000)).close();
            return;
                public void onResponse(Void unused) {
            };
     * without requiring full transport infrastructure.
     */
            when(mockIndexShard.state()).thenReturn(IndexShardState.RECOVERING);
            mockClusterService,
                    latch.countDown();
        indexShard.acquireAllPrimaryOperationsPermits(permitFuture, TimeValue.timeValueSeconds(30));
            }).when(mockIndexShard).onMergesDrained(any(Runnable.class));
    /**
                public void onResponse(Void unused) {
            assertTrue(
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
import org.opensearch.index.shard.IndexShard;
import org.opensearch.cluster.routing.ShardRoutingState;
    private IndexShard mockIndexShard;
        // BroadcastRequest only wire-serializes indices; timeout is a local routing hint not sent over the wire.
     */
            assertFalse("Listener should not fire before drain callback", latch.await(100, TimeUnit.MILLISECONDS));
     */
        mockIndexService = mock(IndexService.class);
            when(mockIndexShard.hasPendingMerges()).thenReturn(true);
                @Override
/**
     * when completeSyncAndFlush throws an exception.
            indexShard.refresh("prepare_tiering");
     */
                        + shardRouting.shardId()
import org.opensearch.cluster.routing.RoutingTable;
            drainCallback.run();
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, shortTimeout);
                );
     * catches regressions where someone toggles the override.
            assertNotNull(drainCallback);
            assertTrue("Listener should fire", latch.await(5, TimeUnit.SECONDS));
    /**
        } finally {
            // onMergesDrained captures the callback but never invokes it (simulates stuck merges)
        try {
import org.opensearch.cluster.routing.ShardRouting;
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
        when(mockClusterService.getSettings()).thenReturn(nodeSettings);
    /**
        // Non-blocking merge wait
     */
                public void onFailure(Exception e) {
     * {@link ClusterService#getClusterSettings} are wired so the dynamic timeout consumer registers
            inOrder.verify(mockIndexShard).freezeForTiering();
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
import org.opensearch.cluster.routing.IndexRoutingTable;
            doAnswer(invocation -> {
            when(mockIndexShard.getActiveMergeCount()).thenReturn(1);
import org.opensearch.index.IndexService;
            ArgumentCaptor<Runnable> drainCallbackCaptor = ArgumentCaptor.forClass(Runnable.class);
 * <p>
            AtomicInteger responseCount = new AtomicInteger(0);
            mockPermitAcquisitionSuccess();
        try {
                        + "] is not in STARTED state (current: "
            assertTrue("Listener should fire immediately", latch.await(5, TimeUnit.SECONDS));
                "sentinel message should mention shardOperationAsync, got: " + ex.getMessage(),
            assertTrue("Should be IOException", failureRef.get() instanceof IOException);
    }
            assertNotNull("Should have a failure", failureRef.get());
    public void testShardOperation_UncommittedOpsAfterFlush_ThrowsIOException() throws IOException {
 * These tests verify the shard operation logic:
                @Override
        Releasable permit;
            verify(mockIndexShard).sync();
            thrown.getMessage().contains("uncommitted translog ops after flush")
     * This ensures the request is not corrupted when sent from cluster-manager to shard nodes.
                    failureRef.set(e);
            drainCallback.run();
                    latch.countDown();
     */
            CountDownLatch latch = new CountDownLatch(1);
    }
    }
    /**
        Releasable permit;
                    "Shard [" + shardRouting.shardId() + "] still has " + uncommitted + " uncommitted translog ops after flush"
        } finally {
            terminate(testThreadPool);
import static org.mockito.Mockito.inOrder;
        ShardRouting shardRouting,
                public void onResponse(Void unused) {
            assertTrue(
            count++;
            drainCallback.run();
            if (completed.compareAndSet(false, true)) {
            };
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
        when(mockIndexShard.translogStats()).thenReturn(translogStats);
            assertNotNull("Should have received a failure", failureRef.get());
            verify(mockIndexShard, never()).onMergesDrained(any(Runnable.class));
            assertTrue("Should be IOException", failureRef.get() instanceof IOException);
            mockPermitAcquisitionSuccess();
                public void onResponse(Void unused) {
            };
                public void onResponse(Void unused) {
                    failureRef.set(e);
            };
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueMillis(100));
                public void onFailure(Exception e) {
                failureRef.get() instanceof MergeDrainTimeoutException
            when(mockIndexShard.hasPendingMerges()).thenReturn(false);
    public void testShardOperation_AcquiresPrimaryPermitsBeforeOperations() throws IOException {
     * Tests that when timeout fires, the exception carries the correct field values.
        } finally {
import java.util.concurrent.TimeoutException;
    }
            when(mockIndexShard.getActiveMergeCount()).thenReturn(1);
        }
            mockPermitAcquisitionSuccess();
            ActionListener<Releasable> listener = invocation.getArgument(0);
        PrepareTieringRequest deserialized = new PrepareTieringRequest(out.bytes().streamInput());
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).routingTable(routingTable).build();
            mockPermitAcquisitionSuccess();
     * {@link TransportPrepareTieringAction#isAsyncShardOperation()} returning {@code true}. The
import org.opensearch.test.OpenSearchTestCase;
                @Override
    public void testShards_TargetsPrimariesOnly() {
            CountDownLatch latch = new CountDownLatch(1);
    public void testShardOperationAsync_DrainAfterTimeout_OnlyTimeoutFires() throws Exception {
            assertEquals("permit denied", failureRef.get().getCause().getMessage());
                @Override
     * immediately with an appropriate IOException and no further actions are taken.
        }
    public void setUp() throws Exception {
            AtomicInteger failureCount = new AtomicInteger(0);
            assertTrue("Listener should fire immediately on permit failure", latch.await(5, TimeUnit.SECONDS));
        } finally {
            new ActionFilters(java.util.Set.of()),
        when(mockTransportService.getThreadPool()).thenReturn(threadPool);
        ClusterService mockClusterService = mock(ClusterService.class);
        try {
    // ── Real-action tests (no simulation) ───────────────────────────────────────────────────────
import org.opensearch.action.support.ActionFilters;
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
     * Helper that replicates completeSyncAndFlush from TransportPrepareTieringAction.
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
            AtomicReference<Exception> failureRef = new AtomicReference<>();
        try {
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
    public void testShardOperation_WaitForReplicaSyncTimeout_PropagatesFailure() throws IOException {
     */
            assertTrue("Listener should fire", latch.await(5, TimeUnit.SECONDS));
        try {
    private IndexService mockIndexService;
    /**
                return null;
        assertEquals("Should have exactly 1 primary shard", 1, count);
     * Helper to mock acquireAllPrimaryOperationsPermits to call the listener with an exception.
                    failureRef.set(e);
import org.mockito.InOrder;
                return null;
    // contracts that ONLY hold against production code (not against the simulation helpers above).
        assertArrayEquals(original.indices(), deserialized.indices());
    }
            };
import org.opensearch.common.unit.TimeValue;
            return;
            terminate(testThreadPool);
        }
                "Message should mention permit acquisition failure",
    }
    @Override
            ArgumentCaptor<Runnable> drainCallbackCaptor = ArgumentCaptor.forClass(Runnable.class);
            CountDownLatch latch = new CountDownLatch(1);
    private void mockPermitAcquisitionSuccess() {
        TransportService mockTransportService = mock(TransportService.class);
