            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(any(Runnable.class));
            thrown.getMessage().contains("Failed to acquire primary operation permits")  
        IOException ex = expectThrows(IOException.class, () -> executeShardOperation(mockIndexShard, primaryShardRouting));  
     * We replicate the logic here since the actual method requires full transport infrastructure.
            mockPermitAcquisitionSuccess();  
                @Override  
            assertTrue("Listener should fire", latch.await(5, TimeUnit.SECONDS));
    public void testShardOperationAsync_PermitAcquisitionFails() throws Exception {  
                throw new IOException(
    /**  
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                public void onResponse(Void unused) {  
                }
            terminate(threadPool);
                @Override
                @Override
        when(mockIndexService.getShard(0)).thenReturn(mockIndexShard);  
        executeShardOperation(mockIndexShard, primaryShardRouting);
            };
            mockPermitAcquisitionFailure(new TimeoutException("Timed out waiting for permits"));
        doThrow(
            mockClusterService,
                public void onResponse(Void unused) {
        mockIndexService = mock(IndexService.class);
    /**  
                    latch.countDown();  
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
        BytesStreamOutput out = new BytesStreamOutput();
    public void testShardOperation_AcquiresPrimaryPermitsBeforeOperations() throws IOException {
            CountDownLatch latch = new CountDownLatch(1);
            ArgumentCaptor<Runnable> drainCallbackCaptor = ArgumentCaptor.forClass(Runnable.class);
        assertEquals("Should have exactly 1 primary shard", 1, count);
            AtomicReference<Exception> failureRef = new AtomicReference<>();  
            TimeValue shortTimeout = TimeValue.timeValueMillis(50);
        }
                failureRef.get() instanceof MergeDrainTimeoutException
                "Message should mention permit acquisition failure",
 */  
            );
            assertEquals("Failure count should still be 1", 1, failureCount.get());  
            // onMergesDrained captures the callback but never invokes it (simulates stuck merges)  
                    latch.countDown();
        InOrder inOrder = inOrder(mockIndexShard);  
 * - Primary-only shard targeting  
        indexShard.freezeForTiering();
     * Verifies that if waitForReplicaSync throws (replicas failed to sync in time),
        try {
        BytesStreamOutput out = new BytesStreamOutput();
        TimeValue mergeTimeout  
        } catch (Exception e) {  
            return null;
            AtomicReference<Exception> failureRef = new AtomicReference<>();
import org.opensearch.test.OpenSearchTestCase;
            };  
     */
     */  
            indexShard.waitForRemoteStoreSync();
        ShardRouting shardRouting,  
            ArgumentCaptor<Runnable> drainCallbackCaptor = ArgumentCaptor.forClass(Runnable.class);
        long mergeTimeoutMillis = (long) (mergeTimeout.millis() * 0.8);
        inOrder.verify(mockIndexShard).sync();  
            assertNotNull("Should have received a failure", failureRef.get());
                public void onResponse(Void unused) {
            verify(mockIndexShard, never()).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
     * {@code shardOperation}; only the real action does.
        try {  
            "Exception message should mention permit acquisition failure",
import static org.mockito.Mockito.mock;  
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(drainCallbackCaptor.capture());
                public void onResponse(Void unused) {  
    // contracts that ONLY hold against production code (not against the simulation helpers above).
    /**
                failureRef.get() instanceof MergeDrainTimeoutException
import java.util.concurrent.atomic.AtomicReference;
    /**
            return null;
            assertTrue("Timeout message should contain timeout value", timeoutEx.getMessage().contains("100ms"));  
            );
import static org.mockito.Mockito.doAnswer;  
                public void onFailure(Exception e) {  
import java.util.concurrent.CountDownLatch;  
import static org.mockito.ArgumentMatchers.any;
            when(mockIndexShard.state()).thenReturn(IndexShardState.RECOVERING);  
        }
     * Helper to mock acquireAllPrimaryOperationsPermits to immediately call the listener with a permit.
            mockPermitAcquisitionSuccess();  
            verify(mockIndexShard, never()).onMergesDrained(any(Runnable.class));
                @Override
        }
    }
 * Unit tests for {@link TransportPrepareTieringAction} shard-level operations.
            assertNotNull("Drain callback should have been captured", drainCallback);
    }
                Runnable callback = invocation.getArgument(0);
            );
        // Verify permit was released despite the exception  
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                @Override
                @Override
            when(mockIndexShard.hasPendingMerges()).thenReturn(false);
        PrepareTieringRequest deserialized = new PrepareTieringRequest(out.bytes().streamInput());
            new IOException(  
        ShardRouting replica = TestShardRouting.newShardRouting(sid, "node2", false, ShardRoutingState.STARTED);
     * Verifies that PrepareTieringRequest round-trips correctly over the wire (writeTo → StreamInput).
     */
    /**  
        PlainActionFuture<Releasable> permitFuture = new PlainActionFuture<>();
            verify(mockIndexShard, never()).freezeForTiering();
        PrepareTieringRequest deserialized = new PrepareTieringRequest(out.bytes().streamInput());
                    latch.countDown();  
        when(translogStats.getUncommittedOperations()).thenReturn(5);  
            ActionListener<Void> listener = new ActionListener<Void>() {  
            verify(mockPermit, timeout(5000)).close();  
     */  
     * Tests that when permit acquisition calls listener.onFailure, the async path wraps it in an IOException.
        when(mockIndexShard.translogStats()).thenReturn(translogStats);
            verify(mockIndexShard).flush(any(FlushRequest.class));
        }  
     */
    // ── Async shard operation tests (deadlock fix) ────────────────────────────  
    /**
            verify(mockIndexShard, never()).onMergesDrained(any(Runnable.class));
                    latch.countDown();
            mock(IndexNameExpressionResolver.class)  
            // onMergesDrained captures the callback but never invokes it (simulates stuck merges)
     */
import org.opensearch.transport.TransportService;
     * Helper to mock acquireAllPrimaryOperationsPermits to call the listener with an exception.
     * Helper that replicates completeSyncAndFlush from TransportPrepareTieringAction.
            Thread.sleep(50);
     * Tests that the AtomicBoolean guard correctly prevents double-firing when  
                @Override  
     * the base-class constructor completes; {@link ClusterService#getSettings} and
        IOException thrown = expectThrows(IOException.class, () -> executeShardOperation(mockIndexShard, primaryShardRouting));  
            assertTrue("Listener should fire immediately on permit failure", latch.await(5, TimeUnit.SECONDS));  
        } finally {
     * {@link TransportPrepareTieringAction#shardOperationAsync} for unit testing
 */
    }  
     */
     * Tests that the permit is always closed on the timeout path.
    private void executeShardOperationAsync(
     * the exception propagates and the prepare action fails — allowing retry.  
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));  
    }
        executeShardOperation(mockIndexShard, primaryShardRouting);
     * an IOException wrapping the permit failure cause.
            assertTrue("Cause should be the original RuntimeException", failureRef.get().getCause() instanceof RuntimeException);  
 * - Uncommitted ops verification after flush
import org.opensearch.common.unit.TimeValue;  
                timeoutTask.cancel();
                @Override  
                @Override
            MergeDrainTimeoutException timeoutEx = (MergeDrainTimeoutException) failureRef.get();
                    latch.countDown();  
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(any(Runnable.class));  
            assertTrue("Timeout should fire", latch.await(5, TimeUnit.SECONDS));
     * the listener is registered and fires later when the drain callback is invoked.  
                }
            ActionListener<Void> listener = new ActionListener<Void>() {
            };  
     * receives an IOException mentioning the state issue.
        } finally {
        inOrder.verify(mockIndexShard).refresh("prepare_tiering");
            ActionListener<Void> listener = new ActionListener<Void>() {
import static org.mockito.Mockito.verify;  
        when(mockTransportService.getThreadPool()).thenReturn(threadPool);
    public void testShardOperation_FreezesAndDrainsMergesBeforeFlush() throws IOException {
                    listener.onFailure(
    }  
                @Override
     * catches regressions where someone toggles the override.
 * <p>
            assertTrue("Should be IOException", failureRef.get() instanceof IOException);  
    }
            assertNotNull("Should have received a failure", failureRef.get());
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(drainCallbackCaptor.capture());
            ActionListener<Void> listener = new ActionListener<Void>() {  
    }
            permit.close();  
    }
            listener.onFailure(
                        + "). Cannot prepare for tiering — will retry."
    /**  
        ClusterSettings clusterSettings = new ClusterSettings(  
            assertTrue("Should be IOException", failureRef.get() instanceof IOException);  
        when(mockIndicesService.indexServiceSafe(shardId.getIndex())).thenReturn(mockIndexService);
                }  
    }
                        + indexShard.state()  
            };  
import org.opensearch.cluster.routing.RoutingTable;  
                    failureRef.set(e);
                @Override
            when(mockIndexShard.hasPendingMerges()).thenReturn(false);
            AtomicReference<Exception> failureRef = new AtomicReference<>();
     */
 * These tests verify the shard operation logic:  
     */
    /**  
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                }
            verify(mockIndexShard, never()).freezeForTiering();  
    /**
                }
        PrepareTieringRequest original = new PrepareTieringRequest();
                }
        mockPermitAcquisitionSuccess();
     */
                    latch.countDown();  
            terminate(testThreadPool);
            };
                public void onResponse(Void unused) {
            listener.onResponse(mockPermit);
            mockPermitAcquisitionFailure(new RuntimeException("permit denied"));
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);  
                public void onResponse(Void unused) {  
        ClusterService mockClusterService = mock(ClusterService.class);
                "Should be MergeDrainTimeoutException, got: " + failureRef.get().getClass().getName(),
    public void testPrepareTieringRequest_SerializationRoundTrip() throws IOException {
            AtomicInteger completionCount = new AtomicInteger(0);
            assertTrue("Should be IOException", failureRef.get() instanceof IOException);
        assertArrayEquals(original.indices(), deserialized.indices());
        } finally {
     */  
        assertTrue(
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueMillis(100));
                public void onFailure(Exception e) {
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, shortTimeout);  
import java.util.concurrent.atomic.AtomicBoolean;  
            AtomicReference<Exception> failureRef = new AtomicReference<>();
                public void onResponse(Void unused) {
import org.opensearch.index.IndexService;
        // Verify permit was released despite the exception
 * The OpenSearch Contributors require contributions made to  
     * {@link ClusterService#getClusterSettings} are wired so the dynamic timeout consumer registers
    private IndicesService mockIndicesService;  
            );  
    public void testShardOperation_PermitTimeout_ThrowsIOException() {  
        inOrder.verify(mockIndexShard).sync();
        AtomicBoolean completed = new AtomicBoolean(false);  
import org.opensearch.action.support.ActionFilters;
    public void testShardOperationAsync_PermitClosedOnDrainCallbackFailure() throws Exception {
        try {
            when(mockIndexShard.getActiveMergeCount()).thenReturn(1);
            assertTrue("prepare must run async (non-blocking merge drain)", action.isAsyncShardOperation());
                try {
        inOrder.verify(mockIndexShard).flush(any(FlushRequest.class));
        }  
                public void onFailure(Exception e) {
        }).when(mockIndexShard).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
        );  
                }
            "Exception message should mention uncommitted ops",
                    );
            AtomicInteger responseCount = new AtomicInteger(0);
                public void onResponse(Void unused) {
            ActionListener<Void> listener = new ActionListener<Void>() {
            assertNotNull("Should have received a failure", failureRef.get());
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));  
        RoutingTable routingTable = RoutingTable.builder().add(indexRoutingTable).build();
                "Shard [" + shardRouting.shardId() + "] still has " + uncommitted + " uncommitted translog ops after flush"  
                public void onFailure(Exception e) {
     */  
            }
            InOrder inOrder = inOrder(mockIndexShard);
            verify(mockPermit, never()).close();  
            assertTrue("Message should report pending merges as yes", timeoutEx.getMessage().contains("pending: yes"));
    }
            permit = permitFuture.actionGet();  
        }  
        Releasable permit;  
            Runnable drainCallback = drainCallbackCaptor.getValue();
                "[REPLICA_SYNC_TIMEOUT] Shard [[clickbench][0]] replicas failed to sync within 30s. "
        when(mockClusterService.getSettings()).thenReturn(nodeSettings);
                public void onFailure(Exception e) {  
            ActionListener<Void> listener = new ActionListener<Void>() {
                @Override
                "sentinel message should mention shardOperationAsync, got: " + ex.getMessage(),  
    }
    /**
    /**
    public void testShards_TargetsPrimariesOnly() {
import static org.mockito.Mockito.inOrder;
     * merge mutates the catalog after the final refresh during tiering preparation.  
            };  
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());  
    }  
            assertNull("Should not have failed", failureRef.get());
            ActionListener<Releasable> listener = invocation.getArgument(0);  
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);  
                public void onFailure(Exception e) {  
                        + shardRouting.shardId()
                }
            inOrder.verify(mockIndexShard).onMergesDrained(any(Runnable.class));  
import org.opensearch.indices.IndicesService;
            ActionListener<Void> listener = new ActionListener<Void>() {
            assertNotNull("Drain callback should have been captured", drainCallback);
                return null;
import org.opensearch.cluster.routing.ShardRoutingState;
            CountDownLatch latch = new CountDownLatch(1);
    /**
            mockPermitAcquisitionSuccess();
            indexShard.refresh("prepare_tiering");
                    latch.countDown();  
    // ── Wire serde tests ──────────────────────────────────────────────────────
    /**
import java.util.concurrent.atomic.AtomicInteger;
            if (completed.compareAndSet(false, true)) {
     */  
            CountDownLatch latch = new CountDownLatch(1);
                } catch (Exception e) {  
            Runnable drainCallback = drainCallbackCaptor.getValue();  
        TestThreadPool threadPool = new TestThreadPool(getTestName());
        mockPermitAcquisitionSuccess();
            assertTrue("Message should report active merges", timeoutEx.getMessage().contains("Active merges: 5"));  
                    latch.countDown();
            };
            mockPermitAcquisitionSuccess();
            listener.onFailure(exception);  
            TransportPrepareTieringAction action = newRealAction(threadPool);
        expectThrows(IOException.class, () -> executeShardOperation(mockIndexShard, primaryShardRouting));  
            );  
                    latch.countDown();
            terminate(testThreadPool);  
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
            assertTrue("Listener should fire", latch.await(5, TimeUnit.SECONDS));  
     * Verifies that the shards() method only returns primary shards.
            assertTrue("Should be IOException", failureRef.get() instanceof IOException);
            verify(mockPermit, timeout(5000)).close();
        ShardId sid = new ShardId(new Index("test-index", "test-uuid"), 0);  
     * Verifies that primary permits are acquired before sync/flush operations.
    /**  
     */  
            when(mockIndexShard.state()).thenReturn(IndexShardState.CLOSED);
        TranslogStats translogStats = mock(TranslogStats.class);
                    failureRef.set(e);  
     * the listener fires immediately with a successful response, and no timeout fires.
                }  
        TimeValue effectiveTimeout = TimeValue.timeValueMillis(mergeTimeoutMillis);
            throw new IOException("Failed to acquire primary operation permits for shard [" + shardRouting.shardId() + "]", e);
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
                )
            Runnable drainCallback = drainCallbackCaptor.getValue();  
        inOrder.verify(mockIndexShard).freezeForTiering();
            assertTrue(
            CountDownLatch latch = new CountDownLatch(1);
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());  
            ActionListener<Void> listener = new ActionListener<Void>() {  
     */
    }
            ActionListener<Void> listener = new ActionListener<Void>() {
    public void testShardOperation_ReleasesPermitOnFailure() throws IOException {
import java.util.Locale;
            assertTrue("Message should mention CLOSED", failureRef.get().getMessage().contains("CLOSED"));
            }).when(mockIndexShard).onMergesDrained(any(Runnable.class));  
     * simulation tests cannot enforce this contract because the simulation never invokes  
import org.opensearch.storage.common.tiering.TieringUtils;  
                public void onResponse(Void unused) {
                }
import java.util.concurrent.TimeUnit;
                    failureRef.set(e);  
    /**
import org.mockito.InOrder;
            doAnswer(invocation -> {  
                }
        );
            assertNotNull("Should have received a failure", failureRef.get());
    public void testShardOperationAsync_ShardNotStarted_FailsFast() throws Exception {  
                }
                public void onResponse(Void unused) {
            };
        // Acquire permits (blocking via PlainActionFuture to match production code)
                );  
                public void onResponse(Void unused) {  
        TransportService mockTransportService = mock(TransportService.class);
    private void executeShardOperation(IndexShard indexShard, ShardRouting shardRouting) throws IOException {  
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());  
            CountDownLatch latch = new CountDownLatch(1);
        indexShard.sync();
                public void onResponse(Void unused) {  
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
            assertEquals("Response count should still be 0", 0, responseCount.get());
    /**
        }
            verify(mockIndexShard).sync();
            }).when(mockIndexShard).onMergesDrained(any(Runnable.class));
                    listener.onResponse(null);
            assertTrue(
            CountDownLatch latch = new CountDownLatch(1);  
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
import org.opensearch.action.admin.indices.flush.FlushRequest;
import static org.mockito.Mockito.timeout;
    }
                    failureRef.set(e);  
     * Tests that if the shard is not in STARTED state, the listener immediately  
import org.opensearch.cluster.routing.ShardRouting;
        }  
import static org.mockito.Mockito.never;
                public void onFailure(Exception e) {
    /**
                // Do nothing — simulate merges not yet drained
            ActionListener<Void> listener = new ActionListener<Void>() {  
import org.opensearch.core.action.ActionListener;
            assertNotNull("Should have a cause", failureRef.get().getCause());
    private void mockPermitAcquisitionFailure(Exception exception) {  
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);  
    private Releasable mockPermit;
            assertNull("Should not have failed", failureRef.get());  
                }  
            when(mockIndexShard.getActiveMergeCount()).thenReturn(3);
     * the drain callback and timeout fire concurrently.
            UnsupportedOperationException ex = expectThrows(
    public void testShardOperationAsync_ShardClosed_FailsFast() throws Exception {
import static org.mockito.Mockito.when;
     * Tests that the permit is always closed on the drain callback path
                    latch.countDown();
    /**
                @Override
                    latch.countDown();
            terminate(testThreadPool);  
        try {  
/**  
            mockPermitAcquisitionSuccess();
            thrown.getMessage().contains("uncommitted translog ops after flush")  
            ActionListener<Void> listener = new ActionListener<Void>() {  
    public void testShardOperationAsync_TimeoutProduces_MergeDrainTimeoutException_WithCorrectFields() throws Exception {  
    }  
                    latch.countDown();
    private IndexShard mockIndexShard;
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                Runnable callback = invocation.getArgument(0);
            }).when(mockIndexShard).onMergesDrained(drainCallbackCaptor.capture());  
    }
            assertTrue("Message should mention not in STARTED state", failureRef.get().getMessage().contains("not in STARTED state"));
        try {
        try {  
            ArgumentCaptor<Runnable> drainCallbackCaptor = ArgumentCaptor.forClass(Runnable.class);
                () -> action.shardOperation(new PrepareTieringRequest("test-index"), primaryShardRouting)  
        } finally {
            doAnswer(invocation -> {
    /**
                failureRef.get().getMessage().contains("Failed to acquire primary operation permits")
        } catch (Exception e) {
                }
                    latch.countDown();  
        indexShard.acquireAllPrimaryOperationsPermits(permitFuture, TimeValue.timeValueSeconds(30));
                UnsupportedOperationException.class,
    @Override  
import org.opensearch.cluster.routing.IndexRoutingTable;
                public void onFailure(Exception e) {
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                    latch.countDown();  
     */
        PrepareTieringRequest original = new PrepareTieringRequest("my-index");
            when(mockIndexShard.hasPendingMerges()).thenReturn(true);  
        primaryShardRouting = TestShardRouting.newShardRouting(shardId, "node1", true, ShardRoutingState.STARTED);  
            nodeSettings,
                Runnable callback = invocation.getArgument(0);  
            doThrow(new IOException("sync failed in drain callback")).when(mockIndexShard).sync();
            };
            ActionListener<Releasable> listener = invocation.getArgument(0);
                new IOException(
    /**  
    public void setUp() throws Exception {
        } finally {
        }  
            AtomicReference<Void> responseRef = new AtomicReference<>();  
     * Constructs a real {@link TransportPrepareTieringAction} with the minimum mock dependencies its
                callback.run();
            assertTrue("Message should contain the configured timeout", timeoutEx.getMessage().contains("50ms"));
            drainCallback.run();
    private ShardRouting primaryShardRouting;  
    }
        mockPermitAcquisitionFailure(new TimeoutException("Timed out waiting for permits"));
        } finally {  
            drainCallback.run();
        int count = 0;
        try {
    private ShardId shardId;
            assertNotNull("Should have received a failure", failureRef.get());  
            assertTrue("Listener should have been called", latch.await(5, TimeUnit.SECONDS));
            verify(mockIndexShard, never()).onMergesDrained(any(Runnable.class));
        executeShardOperation(mockIndexShard, primaryShardRouting);  
            assertNotNull(drainCallback);
        ShardRouting primary = TestShardRouting.newShardRouting(sid, "node1", true, ShardRoutingState.STARTED);
import org.opensearch.common.settings.ClusterSettings;
    }
        super.setUp();
            }
        ClusterState clusterState = ClusterState.builder(ClusterName.DEFAULT).routingTable(routingTable).build();  
        }
                @Override  
            assertTrue("Message should mention not STARTED", failureRef.get().getMessage().contains("not in STARTED state"));
import org.opensearch.threadpool.Scheduler;
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, shortTimeout);
        assertNotNull("Should have a cause", thrown.getCause());
        assertTrue("Exception message should include the count", thrown.getMessage().contains("5"));
     * Tests that when the shard state is CLOSED (not STARTED), the operation fails
                }
        mockPermitAcquisitionSuccess();  
    public void testShardOperation_WaitForReplicaSyncTimeout_PropagatesFailure() throws IOException {
            PlainActionFuture<Releasable> permitFuture = new PlainActionFuture<>();
                    failureRef.set(e);
            verify(mockPermit, timeout(5000)).close();
                "Should be MergeDrainTimeoutException, got: " + failureRef.get().getClass().getName(),  
            ArgumentCaptor<Runnable> drainCallbackCaptor = ArgumentCaptor.forClass(Runnable.class);  
                @Override
            mockPermitAcquisitionSuccess();
/*  
        TranslogStats translogStats = mock(TranslogStats.class);
        try {
        }  
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(sid.getIndex()).addIndexShard(shardRoutingTable).build();  
import org.mockito.ArgumentCaptor;
    /**  
            terminate(testThreadPool);  
@SuppressWarnings("unchecked")
            assertNotNull("Should have a failure", failureRef.get());
import org.opensearch.core.index.shard.ShardId;  
                "Message should mention permit acquisition failure",
                    latch.countDown();
                    latch.countDown();
            assertEquals("Should have 0 responses", 0, responseCount.get());  
            AtomicReference<Void> responseRef = new AtomicReference<>();
            indexShard.acquireAllPrimaryOperationsPermits(permitFuture, TimeValue.timeValueSeconds(30));
        } finally {
            assertNotNull(drainCallback);  
    /**
import org.opensearch.index.translog.TranslogStats;
                @Override
import static org.hamcrest.Matchers.containsString;
 * SPDX-License-Identifier: Apache-2.0
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
            terminate(testThreadPool);
        } finally {  
        }
     * cleanly. The returned action is suitable for asserting protected/instance method contracts;  
        return new TransportPrepareTieringAction(
            return;
        // Permit should still be released via finally block  
     * The synchronous {@code shardOperation} path must throw {@link UnsupportedOperationException} —  
            TransportPrepareTieringAction action = newRealAction(threadPool);  
                }  
            };
    /**
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
            verify(mockPermit, timeout(5000)).close();  
            assertTrue("Listener should fire after timeout", latch.await(5, TimeUnit.SECONDS));
                    latch.countDown();
                boolean hasPendingMerges = indexShard.hasPendingMerges();  
import org.opensearch.threadpool.ThreadPool;
        mockPermitAcquisitionSuccess();  
                    listener.onFailure(e);
            verify(mockIndexShard).waitForRemoteStoreSync();
    }
    }
            assertTrue("Listener should fire after timeout", latch.await(5, TimeUnit.SECONDS));  
import org.opensearch.common.lease.Releasable;  
                @Override
    public void testShardOperationAsync_DrainAfterTimeout_OnlyTimeoutFires() throws Exception {  
        // BroadcastRequest only wire-serializes indices; timeout is a local routing hint not sent over the wire.  
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueMillis(100));  
            mockPermitAcquisitionSuccess();  
    /**  
            );
        try {
    public void testShardOperationAsync_AtomicBooleanPreventsDoubleCompletion() throws Exception {
            CountDownLatch latch = new CountDownLatch(1);
     * constructor requires. The mocked {@link TransportService#registerRequestHandler} is a no-op so  
    /**
            };
                    latch.countDown();
import org.opensearch.cluster.ClusterState;
        original.writeTo(out);
        TestThreadPool threadPool = new TestThreadPool(getTestName());
            assertTrue(  
                    latch.countDown();  
                    + "Replicas still behind: 1, max checkpoints behind: 2"
 * - Correct ordering of sync, flush, refresh, and remote store sync
            terminate(testThreadPool);
     */
            java.util.Set.of(TieringUtils.PREPARE_TIERING_TIMEOUT, TieringUtils.REPLICA_SYNC_TIMEOUT_SETTING)
            }).when(mockIndexShard).onMergesDrained(any(Runnable.class));
     * {@link TransportPrepareTieringAction#isAsyncShardOperation()} returning {@code true}. The
                @Override
     * Tests that the permit is always closed on the success path (already drained).
     * Verifies that the engine is frozen and in-flight merges are drained before the flush, so no
import org.opensearch.core.index.Index;
        Scheduler.ScheduledCancellable timeoutTask = threadPool.schedule(() -> {  
            TimeValue shortTimeout = TimeValue.timeValueMillis(100);
        );
        inOrder.verify(mockIndexShard).waitForReplicaSync(any(TimeValue.class));
                failureRef.get().getMessage().contains("Failed to acquire primary operation permits")  
                }
import org.opensearch.index.shard.IndexShard;
            ActionListener<Void> listener = new ActionListener<Void>() {  
                }  
            listener.onFailure(
        int uncommitted = indexShard.translogStats().getUncommittedOperations();  
        ThreadPool threadPool,
            mockIndicesService,
    }
                }  
            // Capture the Runnable passed to onMergesDrained (do not invoke it yet)
                new IOException("Failed to acquire primary operation permits for shard [" + shardRouting.shardId() + "]", e)  
        assertTrue(
                    failureRef.set(e);
        }, effectiveTimeout, ThreadPool.Names.GENERIC);  
    // ── Real-action tests (no simulation) ───────────────────────────────────────────────────────  
            verify(mockPermit, timeout(5000)).close();
    /**
        when(mockClusterService.getClusterSettings()).thenReturn(clusterSettings);
 * this file be licensed under the Apache-2.0 license or a
            when(mockIndexShard.getActiveMergeCount()).thenReturn(5);  
                    latch.countDown();
    public void testRealAction_ShardOperation_SyncSentinel_ThrowsUnsupported() {  
                    responseCount.incrementAndGet();  
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(any(Runnable.class));
            verify(mockIndexShard).refresh("prepare_tiering");
            )  
            CountDownLatch latch = new CountDownLatch(1);
    ) {
package org.opensearch.storage.action.tiering;
            // When onMergesDrained is called, immediately invoke the Runnable (simulating already drained)
            if (completed.compareAndSet(false, true)) {
                public void onFailure(Exception e) {
        try {  
        try {
import org.opensearch.cluster.routing.TestShardRouting;  
     */  
        IOException thrown = expectThrows(IOException.class, () -> executeShardOperation(mockIndexShard, primaryShardRouting));  
    }
import org.opensearch.common.io.stream.BytesStreamOutput;
        }
            verify(mockIndexShard, never()).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
     */
                    latch.countDown();
                    latch.countDown();
    private void mockPermitAcquisitionSuccess() {
        ActionListener<Void> listener,
            terminate(threadPool);
    /**
                @Override
     * This ensures the request is not corrupted when sent from cluster-manager to shard nodes.
        try {
            );
                }
            };  
            verify(mockIndexShard).sync();
    /**
        if (uncommitted > 0) {
            CountDownLatch latch = new CountDownLatch(1);
                }
                }
     * Helper that replicates the async shard operation logic from  
            doAnswer(invocation -> null).when(mockIndexShard).onMergesDrained(drainCallbackCaptor.capture());
        inOrder.verify(mockIndexShard).flush(any(FlushRequest.class));  
import org.opensearch.cluster.service.ClusterService;
    public void testShardOperationAsync_Timeout_FiresMergeDrainTimeoutException() throws Exception {
                @Override
        IndexShard indexShard,
     * the drain callback arrives after the timeout has already fired.
        indexShard.waitForRemoteStoreSync();
     * it is a sentinel that catches misuse if the framework ever calls the sync path despite
        }  
            mockPermitAcquisitionSuccess();  
            indexShard.freezeForTiering();
        }
        Settings nodeSettings = Settings.EMPTY;
            assertTrue("Listener should fire immediately on permit failure", latch.await(5, TimeUnit.SECONDS));
            assertTrue(
        mockIndexShard = mock(IndexShard.class);  
        assertArrayEquals(original.indices(), deserialized.indices());  
            assertEquals("permit denied", failureRef.get().getCause().getMessage());
            if (uncommitted > 0) {  
        try {  
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
        } finally {  
import static org.mockito.Mockito.doThrow;
        try {  
        // Use the same predicate as TransportPrepareTieringAction.shards()
            CountDownLatch latch = new CountDownLatch(1);
                }
     * Tests that when merges are already drained (onMergesDrained fires listener immediately),  
    public void testShardOperation_UncommittedOpsAfterFlush_ThrowsIOException() throws IOException {
    public void testShardOperationAsync_PermitClosedOnTimeoutPath() throws Exception {
    }  
        try {  
        ).when(mockIndexShard).waitForReplicaSync(any(TimeValue.class));
            terminate(testThreadPool);
                    responseRef.set(null);  
import java.util.concurrent.TimeoutException;
                @Override  
     */  
        doAnswer(invocation -> {
                    "Shard ["  
        );
                @Override  
     */  
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
                ex.getMessage().toLowerCase(Locale.ROOT).contains("shardoperationasync")
        original.writeTo(out);
            indexShard.waitForReplicaSync(TimeValue.timeValueSeconds(30));  
                }  
        inOrder.verify(mockIndexShard).sync();  
            new ActionFilters(java.util.Set.of()),
     * Tests that freezeForTiering() is called before onMergesDrained() is registered.  
     * Tests that when merges are not yet drained (onMergesDrained registers listener),
            when(mockIndexShard.hasPendingMerges()).thenReturn(true);
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));
    /**
        } finally {  
            permit = permitFuture.actionGet();
                return null;
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
     * Tests that when timeout fires, the exception carries the correct field values.
                        new MergeDrainTimeoutException(shardRouting.shardId(), activeMerges, hasPendingMerges, mergeTimeout.toString())  
            doAnswer(invocation -> {
                    latch.countDown();
import org.opensearch.action.support.PlainActionFuture;  
                    latch.countDown();
    public void testShardOperationAsync_PermitClosedOnSuccessPath() throws Exception {  
    public void testRealAction_IsAsyncShardOperation_ReturnsTrue() {
            assertTrue("Message should report shard id", timeoutEx.getMessage().contains(shardId.toString()));
            mockPermitAcquisitionSuccess();
            Runnable drainCallback = drainCallbackCaptor.getValue();  
            ActionListener<Void> listener = new ActionListener<Void>() {  
            terminate(testThreadPool);  
     * Tests the timeout path: when merges never drain, the scheduled timeout fires
                public void onFailure(Exception e) {
                    permit.close();  
     */  
     */
            terminate(testThreadPool);
            MergeDrainTimeoutException timeoutEx = (MergeDrainTimeoutException) failureRef.get();
        when(mockIndexShard.translogStats()).thenReturn(translogStats);
     * Tests that the AtomicBoolean guard prevents double completion when both
        }
     */
    }  
                public void onFailure(Exception e) {
    public void testShardOperation_SyncFlushRefreshAndWaitForRemoteSync() throws IOException {  
     * Simulates the shard operation logic from TransportPrepareTieringAction.shardOperation.  
                    latch.countDown();
     */  
 *
        try {
            AtomicReference<Exception> failureRef = new AtomicReference<>();  
                    completionCount.incrementAndGet();
            AtomicReference<Exception> failureRef = new AtomicReference<>();  
     */  
    // These construct an actual TransportPrepareTieringAction with mocked dependencies and assert
        mockPermit = mock(Releasable.class);  
            ActionListener<Void> listener = new ActionListener<Void>() {
            mockPermitAcquisitionSuccess();
        } finally {
     * routes prepare through {@code shardOperationAsync} (non-blocking merge drain) rather than the  
                    latch.countDown();
    public void testShardOperationAsync_FreezeForTieringCalledBeforeDrain() throws Exception {
                callback.run();  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            indexShard.sync();
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
                    failureRef.set(e);
    private TransportPrepareTieringAction newRealAction(TestThreadPool threadPool) {  
    private void completeSyncAndFlushForTest(IndexShard indexShard, ShardRouting shardRouting) throws IOException {  
                public void onResponse(Void unused) {  
                return null;
        doThrow(new IOException("sync failed")).when(mockIndexShard).sync();
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
            when(mockIndexShard.getActiveMergeCount()).thenReturn(1);
        for (ShardRouting shard : shardsIterator) {  
            );  
        }
            indexShard.flush(new FlushRequest().force(true).waitIfOngoing(true));  
    public void testShardOperationAsync_MergesDrainLater_ListenerFires() throws Exception {
                @Override
            verify(mockPermit, timeout(5000)).close();
     * when completeSyncAndFlush throws an exception.
            AtomicReference<Exception> failureRef = new AtomicReference<>();
        }
        try {  
     */
                @Override
        }).when(mockIndexShard).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));  
        // Non-blocking merge wait
            verify(mockIndexShard).waitForRemoteStoreSync();
        assertThat(ex.getMessage(), containsString("[REPLICA_SYNC_TIMEOUT]"));
            terminate(testThreadPool);
        inOrder.verify(mockIndexShard).flush(any(FlushRequest.class));
     * The real action must opt-in to async per-shard execution. This is the wiring decision that
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, TimeValue.timeValueSeconds(30));  
                try {  
 * - Permit release on failure
        } finally {
            terminate(testThreadPool);
            AtomicReference<Exception> failureRef = new AtomicReference<>();
        });  
     * and verifying the predicate filters correctly.  
            terminate(testThreadPool);
     */
    private IndexService mockIndexService;
                        + "] is not in STARTED state (current: "
            assertTrue("Listener should fire immediately", latch.await(5, TimeUnit.SECONDS));
            return;
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                @Override
    /**  
                callback.run();
import org.opensearch.common.settings.Settings;
        mockIndicesService = mock(IndicesService.class);
            verify(mockIndexShard).refresh("prepare_tiering");  
            assertEquals("Should have exactly 1 failure (timeout)", 1, failureCount.get());
            );
        // Fail fast if shard is not fully started
            drainCallback.run();
                public void onResponse(Void unused) {
        InOrder inOrder = inOrder(mockIndexShard);
            CountDownLatch latch = new CountDownLatch(1);
        try {
            assertTrue("Message should report pending merges as yes", timeoutEx.getMessage().contains("pending: yes"));
     */
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                    permit.close();  
            verify(mockIndexShard, never()).onMergesDrained(any(Runnable.class));
 * compatible open source license.
        indexShard.refresh("prepare_tiering");  
 * - Primary permit acquisition before operations
            TimeValue shortTimeout = TimeValue.timeValueMillis(100);  
            assertTrue("Listener should fire after drain callback", latch.await(5, TimeUnit.SECONDS));
        verify(mockPermit, timeout(5000)).close();  
            int uncommitted = indexShard.translogStats().getUncommittedOperations();
     * synchronous {@code shardOperation} path. Pinning this on the real action — not the simulation —
     * immediately with an appropriate IOException and no further actions are taken.  
            verify(mockIndexShard).flush(any(FlushRequest.class));  
            AtomicReference<Exception> failureRef = new AtomicReference<>();  
                }
                } finally {
            assertNotNull("Should have received a failure", failureRef.get());
                return null;  
            };
            assertTrue("Message should report shard id", timeoutEx.getMessage().contains(shardId.toString()));  
        try {
        mockPermitAcquisitionSuccess();  
     * Verifies that timeout on permit acquisition throws IOException.
                    failureCount.incrementAndGet();  
            verify(mockIndexShard, never()).freezeForTiering();  
            assertTrue("Only primary shards should be returned", shard.primary());
        }
        } finally {  
        verify(mockPermit, timeout(5000)).close();
                    failureRef.set(e);  
                @Override
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                } finally {
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
import java.io.IOException;
                    latch.countDown();  
            AtomicInteger failureCount = new AtomicInteger(0);  
        IndexShardRoutingTable shardRoutingTable = new IndexShardRoutingTable.Builder(sid).addShard(primary).addShard(replica).build();
     * Tests that if permit acquisition fails, the listener immediately receives  
import org.opensearch.threadpool.TestThreadPool;  
        InOrder inOrder = inOrder(mockIndexShard);
                public void onFailure(Exception e) {
            assertTrue("Listener should fire after timeout", latch.await(5, TimeUnit.SECONDS));
        doAnswer(invocation -> {
        shardId = new ShardId(new Index("test-index", "test-uuid"), 0);
            terminate(testThreadPool);
        }
        verify(mockPermit, timeout(5000)).close();
                }
            doAnswer(invocation -> {  
    }
            assertFalse("Listener should not fire before drain callback", latch.await(100, TimeUnit.MILLISECONDS));
    }  
                }
            assertTrue("Listener should fire immediately", latch.await(5, TimeUnit.SECONDS));
            assertTrue("Message should report active merges", timeoutEx.getMessage().contains("Active merges: 3"));
            throw new IOException(
                    completionCount.incrementAndGet();
     */
     */
            when(mockIndexShard.state()).thenReturn(IndexShardState.STARTED);
            }
    /**
                    failureRef.set(e);
}
            mockTransportService,  
    }
     */
    }
            terminate(testThreadPool);
    }
     * and waitForReplicaSync in order.
     * Verifies that the shard operation calls sync, flush, refresh, waitForRemoteStoreSync,  
     * We test this by building a routing table with both primary and replica shards
        indexShard.flush(new FlushRequest().force(true).waitIfOngoing(true));
        when(translogStats.getUncommittedOperations()).thenReturn(0);  
public class TransportPrepareTieringActionTests extends OpenSearchTestCase {  
            assertTrue("Should be IOException", failureRef.get() instanceof IOException);  
     * Verifies that the permit is released even if flush/sync throws an exception.
            assertTrue(  
 * - Timeout handling on permit acquisition  
            executeShardOperationAsync(mockIndexShard, primaryShardRouting, listener, testThreadPool, shortTimeout);
                    "Shard [" + shardRouting.shardId() + "] still has " + uncommitted + " uncommitted translog ops after flush"
        } finally {
     * without requiring full transport infrastructure.
    /**
            when(mockIndexShard.hasPendingMerges()).thenReturn(true);
    }
        } finally {  
            when(mockIndexShard.getActiveMergeCount()).thenReturn(2);
import org.opensearch.index.shard.IndexShardState;  
        if (indexShard.state() != IndexShardState.STARTED) {  
        indexShard.onMergesDrained(() -> {  
    public void testPrepareTieringRequest_SerializationRoundTrip_NoIndices() throws IOException {
                @Override
                    responseRef.set(null);
import org.opensearch.cluster.ClusterName;
                }
        }  
            assertEquals("Listener should be called exactly once despite race", 1, completionCount.get());  
                    latch.countDown();
import org.opensearch.cluster.routing.IndexShardRoutingTable;
        inOrder.verify(mockIndexShard).refresh("prepare_tiering");
    }  
        inOrder.verify(mockIndexShard).acquireAllPrimaryOperationsPermits(any(ActionListener.class), any(TimeValue.class));
                @Override
    }  
    }  
            drainCallback.run();
    public void testShardOperationAsync_PermitAcquisitionFailure_AsyncPath() throws Exception {
        mockPermitAcquisitionSuccess();
            };
     * it will NOT execute end-to-end transport flows.
    public void testShardOperationAsync_AlreadyDrained_CompletesImmediately() throws Exception {  
        // Schedule timeout (named `timeoutTask` to avoid shadowing the Mockito.timeout static import)
                public void onFailure(Exception e) {
        var shardsIterator = clusterState.routingTable().allShardsSatisfyingPredicate(new String[] { "test-index" }, ShardRouting::primary);  
            assertTrue("Timeout should fire", latch.await(5, TimeUnit.SECONDS));
     * Verifies round-trip with no indices (broadcast to all).
                }  
            assertTrue("Listener should fire", latch.await(5, TimeUnit.SECONDS));
            CountDownLatch latch = new CountDownLatch(1);
            CountDownLatch latch = new CountDownLatch(1);
     * Verifies that uncommitted ops > 0 after flush throws IOException.  
        } finally {
        TestThreadPool testThreadPool = new TestThreadPool(getTestName());
                    completeSyncAndFlushForTest(indexShard, shardRouting);
            count++;
        } finally {
                public void onFailure(Exception e) {
        inOrder.verify(mockIndexShard).waitForRemoteStoreSync();  
            CountDownLatch latch = new CountDownLatch(1);
        Releasable permit;
            verify(mockPermit, timeout(5000)).close();
        }
            inOrder.verify(mockIndexShard).freezeForTiering();
     * and the listener receives a MergeDrainTimeoutException with correct merge counts.
                }
                int activeMerges = indexShard.getActiveMergeCount();
