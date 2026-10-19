            null
            1L,
            Collections.emptyList(),
            taskSubmitted.countDown();  
        );
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)  
        assertEquals(normalSnapshot.getSnapshotId(), resultSnapshots.entries().get(0).snapshot().getSnapshotId());  
            Version.CURRENT,  
    public void testComputeBackoffAttemptZero() {
            0,
            0,  
        Settings newSettings = Settings.builder()
    public void testRemoveFailedSnapshotTaskRemovesEntry() throws Exception {  
            Collections.emptyMap(),
            () -> mock(ClusterStateUpdateTask.class),  
        assertFalse(fallbackCalled.get());
    private ClusterService clusterService;  
            Collections.emptyMap(),  
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
        long start = System.currentTimeMillis();
    public void testRemoveFailedSnapshotTaskClusterStateProcessedWithoutListenerNullRepoData() throws Exception {
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));  
import static org.mockito.Mockito.mock;  
        snapshotsService.retryOrFailOnClusterManagerFailOver(
    }
        task.onFailure("test-source", new NotClusterManagerException("simulated"));
            0,
 * compatible open source license.
    }
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
        ClusterState currentState = ClusterState.builder(ClusterState.EMPTY_STATE)  
            return mock(ClusterStateUpdateTask.class);
    public void testWrappedNotClusterManagerRunsFallback() {
        TimeValue result = SnapshotsService.computeBackoff(TimeValue.timeValueHours(25), 0);
            Version.CURRENT,
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);  
            1L,  
        ActionListener<Snapshot> userListener = ActionListener.wrap(s -> {}, e -> listenerCalled.set(true));
    public void testRemoveFailedSnapshotTaskOnNoLongerClusterManagerWithoutListener() throws Exception {
    public void testRemoveFailedSnapshotTaskOnFailureNotCM() throws Exception {
        SnapshotsInProgress.Entry normalEntry = SnapshotsInProgress.startedEntry(
    }
            null
            "test-source",  
            new RuntimeException("test failure"),
        snapshotsService.retryOrFailOnClusterManagerFailOver(new FailedToCommitClusterStateException("test"), 0, "test-source", () -> {
    public void testFailedToCommitExhaustsFallback() {
            "test-source",
    public void testRejectedExecutionRunsFallback() {
        assertNotNull(resultSnapshots);  
            .nodes(DiscoveryNodes.builder().localNodeId(localNodeId).clusterManagerNodeId(localNodeId).build())  
            mock(org.opensearch.action.support.ActionFilters.class),  
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 0);
            null,
    public void testComputeBackoffIsExponential() {  
            null,
    }
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        );
    public void testStateWithoutSnapshotV2TaskOnFailureNotCMRunsFallback() throws Exception {  
    }
    public void testStateWithoutSnapshotV2TaskOnFailureRetries() throws Exception {  
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));  
            "test-source",
            true  
        when(localTransportService.getThreadPool()).thenReturn(terminatedPool);
        assertTrue(taskSubmitted.await(5, TimeUnit.SECONDS));
            0,
            1L,
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
            () -> snapshotsService.retryOrFailOnClusterManagerFailOver(  
        TimeValue base = TimeValue.timeValueSeconds(1);
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;  
        );  
            factoryCalls.incrementAndGet();
            () -> fallbackCalled.set(true)
            "test-source",
        AssertionError ae = expectThrows(
            "test-source",
            .putList("node.roles", "cluster_manager", "data")
            null
        assertTrue("Task factory should be invoked for retry", taskSubmitted.await(5, TimeUnit.SECONDS));
            mock(org.opensearch.repositories.RepositoriesService.class),
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(List.of(entry)))
        assertTrue("Snapshot entry should be removed", resultSnapshots.entries().isEmpty());
        assertTrue(fallbackCalled.get());
        assertEquals(TimeValue.timeValueSeconds(1), result);
        task.onNoLongerClusterManager("test-source");
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));  
            mock(org.opensearch.repositories.RepositoriesService.class),
            new RuntimeException("original failure"),
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
import org.opensearch.transport.TransportService;  
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));  
            wrapped,  
        clusterSettings.applySettings(newSettings);
            new RuntimeException("original failure"),
            .put(SnapshotsService.SNAPSHOT_CLEANUP_RETRIES_SETTING.getKey(), 10)
            Collections.emptyList(),
            () -> fallbackCalled.set(true)  
            Collections.emptyMap(),
        assertEquals(TimeValue.timeValueDays(1), result);
        );
        );
    public void testUnexpectedExceptionRunsFallback() {
        when(transportService.getThreadPool()).thenReturn(threadPool);  
        assertTrue(fallbackCalled.get());
            new org.opensearch.indices.RemoteStoreSettings(Settings.EMPTY, clusterSettings),
            new FailedToCommitClusterStateException("test"),  
            true,
            "test-source",
            null,  
            () -> mock(ClusterStateUpdateTask.class),  
            mock(org.opensearch.repositories.RepositoriesService.class),
        Snapshot v2Snapshot = new Snapshot("repo", new SnapshotId("v2-snap", UUIDs.randomBase64UUID()));  
        SnapshotsInProgress.Entry entry = SnapshotsInProgress.startedEntry(
        assertTrue("Delay must be clamped to <= 1 day, was " + delay, delay.millis() <= TimeValue.timeValueDays(1).millis());
    }
import org.opensearch.core.action.ActionListener;
            new RuntimeException("original failure"),  
            transportService,  
            true,
            () -> fallbackCalled.set(true)
            .put(SnapshotsService.SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING.getKey(), "5s")  
        Settings settings = Settings.builder()
            true,
            snapshot,  
            .put(SnapshotsService.SNAPSHOT_CLEANUP_RETRIES_SETTING.getKey(), 5)
        threadPool = new TestThreadPool(getTestName());  
        );  
            v2Snapshot,
import org.opensearch.cluster.service.ClusterService;
        ClusterState result = task.execute(currentState);  
            false,  
            )  
        svc.retryOrFailOnClusterManagerFailOver(
            100,  
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
            clusterService,  
            "test-source",  
            1L,
            5,  
            snapshot,
        task.onFailure("test-source", new NotClusterManagerException("simulated"));
        String localNodeId = UUIDs.randomBase64UUID();
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
    public void testComputeBackoffHighAttemptCapped() {
        );
        TimeValue result = SnapshotsService.computeBackoff(TimeValue.timeValueSeconds(1), 2);
        Settings settings = Settings.builder().put("node.name", "test").putList("node.roles", "cluster_manager", "data").build();
import org.opensearch.cluster.node.DiscoveryNodes;
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);  
        assertTrue("Delay must be positive, was " + delay, delay.millis() > 0);
     */
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
            normalSnapshot,  
import java.util.concurrent.CountDownLatch;
            1L,  
    }  
public class RetryOrFailOnClusterManagerFailOverTests extends OpenSearchTestCase {  
    public void testRetryAttemptOneHasCorrectBackoff() throws Exception {
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
        task.clusterStateProcessed("test-source", state, state);  
        assertTrue(taskSubmitted.await(5, TimeUnit.SECONDS));  
            settings,
        TimeValue result = SnapshotsService.computeBackoff(TimeValue.timeValueSeconds(1), 50);  
        TransportService transportService = mock(TransportService.class);
        snapshotsService.retryOrFailOnClusterManagerFailOver(
        ClusterState currentState = ClusterState.builder(ClusterState.EMPTY_STATE)
    }  
            false
            false,
    }
    public void testStateWithoutSnapshotV2TaskOnFailureExhaustedRetries() throws Exception {
        ClusterService localClusterService = mock(ClusterService.class);  
    }  
            taskSubmitted.countDown();
        assertSame("Should return same state when no V2 entries to remove", currentState, result);
            Collections.emptyMap(),
    }  
        TimeValue result = SnapshotsService.computeBackoff(TimeValue.timeValueSeconds(1), 0);  
    public void testStateWithoutSnapshotV2TaskOnFailureUnexpectedException() throws Exception {
            snapshot,
        expectThrows(AssertionError.class, () -> task.onFailure("test-source", new RuntimeException("unexpected")));  
            new RuntimeException("original failure"),
            "test-source",
        snapshotsService.retryOrFailOnClusterManagerFailOver(
    }  
            "test-source",
        assertFalse(resultSnapshots.entries().get(0).remoteStoreIndexShallowCopyV2());
    public void testRemoveFailedSnapshotTaskOnNoLongerClusterManagerWithListener() throws Exception {
    private SnapshotsService snapshotsService;
            null,
            .build();
            snapshot,  
        Exception wrapped = new RuntimeException("wrapper", new NotClusterManagerException("inner"));  
    }  
        CountDownLatch retryLatch = new CountDownLatch(1);
        snapshotsService.retryOrFailOnClusterManagerFailOver(new FailedToCommitClusterStateException("test"), 0, "test-source", () -> {
            0,  
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
        TransportService transportService = mock(TransportService.class);
        );
            normalSnapshot,  
        Snapshot normalSnapshot = new Snapshot("repo", new SnapshotId("normal-snap", UUIDs.randomBase64UUID()));
            .nodes(DiscoveryNodes.builder().localNodeId(localNodeId).clusterManagerNodeId(localNodeId).build())  
                () -> fallbackCalled.set(true)
            null
import org.opensearch.cluster.ClusterState;
            null
            null,  
    /**
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(List.of(v2Entry, normalEntry)))
            "test-source",
 *
        TimeValue base = TimeValue.timeValueSeconds(1);
        CountDownLatch taskSubmitted = new CountDownLatch(1);  
        assertTrue("Fallback should be called at attempt==maxRetries", fallbackCalled.get());
    public void setUp() throws Exception {
            .nodes(DiscoveryNodes.builder().localNodeId(localNodeId).clusterManagerNodeId(localNodeId).build())
        );
            "test-source",
import org.opensearch.threadpool.ThreadPool;
    }
            Collections.emptyMap(),
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));  
            0,
    }  
        assertEquals(TimeValue.timeValueSeconds(1), SnapshotsService.computeBackoff(base, 0));
        assertTrue("Fallback should be called when scheduling is rejected", fallbackCalled.get());
        );  
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
        when(transportService.getThreadPool()).thenReturn(threadPool);  
        Settings settings = Settings.builder().put("node.name", "test").putList("node.roles", "cluster_manager", "data").build();
            null,  
            1L,  
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);  
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
            snapshot,
        CountDownLatch taskSubmitted = new CountDownLatch(1);
            false,
        CountDownLatch taskSubmitted = new CountDownLatch(1);
            localTransportService,
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)  
        task.onFailure("test-source", new NotClusterManagerException("simulated"));  
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);  
    }
        String localNodeId = UUIDs.randomBase64UUID();
    }
 */  
        assertTrue("Fallback should run before the assert fires", fallbackCalled.get());  
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
        );
            false,
        SnapshotsInProgress resultSnapshots = result.custom(SnapshotsInProgress.TYPE);
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
            () -> mock(ClusterStateUpdateTask.class),  
        assertEquals(TimeValue.ZERO, result);
            null,
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 0);
        when(localClusterService.getClusterSettings()).thenReturn(clusterSettings);
        TimeValue result = SnapshotsService.computeBackoff(TimeValue.ZERO, 5);
            false
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            null
            0,  
    }
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);  
        Exception wrapped = new RuntimeException("wrapper", new FailedToCommitClusterStateException("inner"));
import org.opensearch.Version;
            new FailedToCommitClusterStateException("test"),  
            "test-source",  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            "test-source",
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
            return mock(ClusterStateUpdateTask.class);
        TestThreadPool terminatedPool = new TestThreadPool(getTestName());  
        ClusterState result = task.execute(currentState);  
import org.opensearch.common.settings.ClusterSettings;
            .build();
            .put(SnapshotsService.SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING.getKey(), "2s")  
        }, () -> fallbackCalled2.set(true));  
        );
        }, () -> {});
        svc.retryOrFailOnClusterManagerFailOver(new FailedToCommitClusterStateException("test"), 5, "test-source", () -> {  
        assertTrue(taskSubmitted.await(5, TimeUnit.SECONDS));
            null  
            true,
    public void testNotClusterManagerExceptionRunsFallback() {
        localService.retryOrFailOnClusterManagerFailOver(
        ClusterState result = task.execute(currentState);
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(List.of(normalEntry)))
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(  
            .nodes(DiscoveryNodes.builder().localNodeId(localNodeId).clusterManagerNodeId(localNodeId).build())  
            () -> mock(ClusterStateUpdateTask.class),  
import org.opensearch.cluster.SnapshotsInProgress;
import java.util.concurrent.TimeUnit;
        expectThrows(AssertionError.class, () -> task.onFailure("test-source", new RuntimeException("unexpected")));
        CountDownLatch taskSubmitted = new CountDownLatch(1);
    }
            null
            localClusterService,
        }, () -> {});
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
            snapshot,
        task.onFailure("test-source", new FailedToCommitClusterStateException("simulated publish failure"));
        );
    public void testSettingsUpdateConsumerForRetries() {
            null
            SnapshotsService.SNAPSHOT_CLEANUP_RETRIES_SETTING.getDefault(Settings.EMPTY),
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        AtomicBoolean fallbackCalled2 = new AtomicBoolean(false);
            settings,
import static org.mockito.Mockito.when;
        task.onFailure("test-source", new FailedToCommitClusterStateException("simulated"));  
        assertEquals(TimeValue.timeValueSeconds(2), SnapshotsService.computeBackoff(base, 1));  
    }  
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
import org.opensearch.common.UUIDs;  
        );
}
 * The OpenSearch Contributors require contributions made to  
            mock(org.opensearch.cluster.metadata.IndexNameExpressionResolver.class),  
    public void testRemoveFailedSnapshotTaskOnFailureExhaustedRetries() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            Version.CURRENT,  
                () -> mock(ClusterStateUpdateTask.class),
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
    }  
            new RuntimeException("original failure"),  
            transportService,
            snapshot,
        SnapshotsInProgress resultSnapshots = result.custom(SnapshotsInProgress.TYPE);  
    public void testFailedToCommitRetriesWhenAttemptsRemain() throws Exception {
            return mock(ClusterStateUpdateTask.class);  
        assertEquals(TimeValue.timeValueSeconds(4), result);  
            AssertionError.class,
            0,
            new RuntimeException("original failure"),
package org.opensearch.snapshots;
        assertEquals(TimeValue.timeValueDays(1), result);
            snapshot,
        snapshotsService.retryOrFailOnClusterManagerFailOver(new FailedToCommitClusterStateException("test"), 0, "test-source", () -> {
                new RuntimeException("unexpected"),
        TimeValue delay = SnapshotsService.computeBackoff(base, 1000);  
        assertEquals(1, factoryCalls.get());
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
            clusterService,
            taskSubmitted.countDown();  
        long elapsed = System.currentTimeMillis() - start;
import org.opensearch.test.OpenSearchTestCase;  
        AtomicInteger factoryCalls = new AtomicInteger(0);
import org.opensearch.cluster.ClusterStateUpdateTask;  
    }
            null,
            mock(org.opensearch.action.support.ActionFilters.class),
                "test-source",  
            Collections.emptyList(),
            null  
        );
    }
            0,
            new FailedToCommitClusterStateException("test"),
            snapshot,
            () -> fallbackCalled.set(true)
            null,  
        SnapshotsService localService = new SnapshotsService(  
    }
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
    }
 * this file be licensed under the Apache-2.0 license or a
            0,  
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
            mock(org.opensearch.cluster.metadata.IndexNameExpressionResolver.class),
            .build();
        String localNodeId = UUIDs.randomBase64UUID();
        );
            Version.CURRENT,  
        assertTrue("Backoff should be at least ~1s, was " + elapsed + "ms", elapsed >= 900L);  
        String localNodeId = UUIDs.randomBase64UUID();
        task.onFailure("test-source", new FailedToCommitClusterStateException("simulated publish failure"));
        );
    public void testRemoveFailedSnapshotTaskOnFailureUnexpectedException() throws Exception {
        assertTrue(fallbackCalled.get());
            new org.opensearch.indices.RemoteStoreSettings(Settings.EMPTY, clusterSettings),
    }
    }
            .build();
        clusterService = mock(ClusterService.class);
        SnapshotsInProgress.Entry v2Entry = SnapshotsInProgress.startedEntry(  
            new org.opensearch.indices.RemoteStoreSettings(Settings.EMPTY, clusterSettings),  
import org.opensearch.common.settings.Settings;
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 0);
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 0);
            null  
    }
            settings,
            Collections.emptyMap(),
        SnapshotsInProgress.Entry normalEntry = SnapshotsInProgress.startedEntry(
            new RuntimeException("test failure"),
            return mock(ClusterStateUpdateTask.class);
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
        }, () -> fallbackCalled.set(true));
    public void testWrappedFailedToCommitRetries() throws Exception {
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
    }
        assertTrue("Fallback should be called when retries exhausted", fallbackCalled.get());  
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 100);  
            Collections.emptyList(),  
        ClusterState currentState = ClusterState.builder(ClusterState.EMPTY_STATE)
import java.util.concurrent.atomic.AtomicBoolean;  
            new NotClusterManagerException("test"),  
import java.util.Collections;
            throw new AssertionError("should not be called");
            .put("node.name", "test")  
            taskSubmitted.countDown();  
            Collections.emptyMap(),
    public void testComputeBackoffCapsAtOneDay() {  
    public void testRetryCreatesNewTaskInstance() throws Exception {  
        assertTrue(ae.getMessage().contains("Unexpected failure during cluster state update"));
            Collections.emptyList(),  
            null
    private TestThreadPool threadPool;
    @Override
    }  
    public void testComputeBackoffWithZeroBase() {  
        task.onNoLongerClusterManager("test-source");
        );
            .build();  
import org.opensearch.threadpool.TestThreadPool;
        );
        );  
    }  
import org.opensearch.common.util.FeatureFlags;
import java.util.List;  
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
            null,  
    public void testRemoveFailedSnapshotTaskOnFailureWithListenerNotNull() throws Exception {
        TransportService localTransportService = mock(TransportService.class);
            mock(org.opensearch.cluster.metadata.IndexNameExpressionResolver.class),  
            return mock(ClusterStateUpdateTask.class);
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
                0,
        task.onFailure("test-source", new FailedToCommitClusterStateException("simulated"));
            new RuntimeException("original failure"),  
        snapshotsService.retryOrFailOnClusterManagerFailOver(new FailedToCommitClusterStateException("test"), 100, "test-source", () -> {  
            snapshot,
        ThreadPool.terminate(terminatedPool, 0, TimeUnit.MILLISECONDS);
        );
        );
            false,
    public void testComputeBackoffAttemptTwo() {
            .build();
    }
            Collections.emptyList(),  
            "test-source",
    }
    public void testComputeBackoffDoesNotOverflowAndIsClamped() {
        super.setUp();
            null,
    }  
    public void testStateWithoutSnapshotV2ReadsLiveState() throws Exception {
        }, () -> fallbackCalled.set(true));
import java.util.concurrent.atomic.AtomicInteger;
     * Regression test: verifies createStateWithoutSnapshotV2Task reads from currentState (not captured outer state).  
            1L,
    public void testRejectedExecutionExceptionInRetryRunsFallback() throws Exception {  
        }, () -> fallbackCalled.set(true));
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 0);
        snapshotsService = new SnapshotsService(
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
    public void testRemoveFailedSnapshotTaskOnFailureRetries() throws Exception {  
            1L,  
        assertFalse("Fallback should not be called when retries remain", fallbackCalled.get());
/*  
            retryLatch.countDown();
import org.opensearch.cluster.NotClusterManagerException;
    public void testCreateStateWithoutSnapshotV2TaskNoChangeReturnsOriginal() throws Exception {  
            () -> fallbackCalled.set(true)
            () -> mock(ClusterStateUpdateTask.class),
        assertEquals(1, resultSnapshots.entries().size());
            false
    @Override  
        snapshotsService.retryOrFailOnClusterManagerFailOver(wrapped, 0, "test-source", () -> {
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
            false,
            Collections.emptyMap(),
        assertEquals(TimeValue.timeValueSeconds(4), SnapshotsService.computeBackoff(base, 2));
        SnapshotsService svc = new SnapshotsService(  
        Snapshot normalSnapshot = new Snapshot("repo", new SnapshotId("normal-snap", UUIDs.randomBase64UUID()));
        assertFalse("Fallback should NOT be called when retries increased", fallbackCalled2.get());
            null,
import org.opensearch.common.unit.TimeValue;  
            Collections.emptyList(),
            mock(org.opensearch.action.support.ActionFilters.class),  
    }
            0,
        super.tearDown();
    public void tearDown() throws Exception {  
            Collections.emptyList(),
