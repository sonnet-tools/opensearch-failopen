    }
            new RuntimeException("original failure"),
 *
        assertEquals(1, factoryCalls.get());
        assertFalse("Fallback should NOT be called when retries increased", fallbackCalled2.get());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.node.DiscoveryNodes;
import org.opensearch.threadpool.ThreadPool;
            Collections.emptyMap(),
        assertTrue("Delay must be clamped to <= 1 day, was " + delay, delay.millis() <= TimeValue.timeValueDays(1).millis());
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
            new RuntimeException("test failure"),
    public void testRemoveFailedSnapshotTaskClusterStateProcessedWithoutListenerNullRepoData() throws Exception {
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(List.of(entry)))
            Collections.emptyList(),
        svc.retryOrFailOnClusterManagerFailOver(new FailedToCommitClusterStateException("test"), 5, "test-source", () -> {
            1L,
        Settings settings = Settings.builder().put("node.name", "test").putList("node.roles", "cluster_manager", "data").build();
        TransportService transportService = mock(TransportService.class);
        when(transportService.getThreadPool()).thenReturn(threadPool);
    public void testFailedToCommitExhaustsFallback() {
            .build();
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testRemoveFailedSnapshotTaskOnNoLongerClusterManagerWithListener() throws Exception {
        task.onNoLongerClusterManager("test-source");
            taskSubmitted.countDown();
            0,
        clusterService = mock(ClusterService.class);
    public void testRemoveFailedSnapshotTaskOnFailureNotCM() throws Exception {
    public void tearDown() throws Exception {
    private SnapshotsService snapshotsService;
        assertTrue("Fallback should be called when scheduling is rejected", fallbackCalled.get());
import java.util.List;
            () -> snapshotsService.retryOrFailOnClusterManagerFailOver(
            1L,
    public void testFailedToCommitRetriesWhenAttemptsRemain() throws Exception {
        SnapshotsInProgress.Entry normalEntry = SnapshotsInProgress.startedEntry(
    public void testStateWithoutSnapshotV2TaskOnFailureUnexpectedException() throws Exception {
    public void testRemoveFailedSnapshotTaskRemovesEntry() throws Exception {
            1L,
public class RetryOrFailOnClusterManagerFailOverTests extends OpenSearchTestCase {
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
import org.opensearch.core.action.ActionListener;
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
            "test-source",
            .put(SnapshotsService.SNAPSHOT_CLEANUP_RETRIES_SETTING.getKey(), 10)
            "test-source",
            .put(SnapshotsService.SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING.getKey(), "2s")
        ActionListener<Snapshot> userListener = ActionListener.wrap(s -> {}, e -> listenerCalled.set(true));
    public void testRetryAttemptOneHasCorrectBackoff() throws Exception {
        super.setUp();
            "test-source",
        when(localTransportService.getThreadPool()).thenReturn(terminatedPool);
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 0);
            null
            null
    public void testRejectedExecutionRunsFallback() {
/*
        Exception wrapped = new RuntimeException("wrapper", new FailedToCommitClusterStateException("inner"));
        );
    }
        assertTrue("Delay must be positive, was " + delay, delay.millis() > 0);
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
    }
            new org.opensearch.indices.RemoteStoreSettings(Settings.EMPTY, clusterSettings),
            null,
            Collections.emptyList(),
            null,
            Collections.emptyList(),
            mock(org.opensearch.action.support.ActionFilters.class),
        }, () -> fallbackCalled.set(true));
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
import org.opensearch.common.util.FeatureFlags;
            Version.CURRENT,
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
    public void testStateWithoutSnapshotV2TaskOnFailureExhaustedRetries() throws Exception {
        Snapshot normalSnapshot = new Snapshot("repo", new SnapshotId("normal-snap", UUIDs.randomBase64UUID()));
import org.opensearch.Version;
        }, () -> fallbackCalled.set(true));
            0,
        SnapshotsInProgress resultSnapshots = result.custom(SnapshotsInProgress.TYPE);
        );
    }
            new RuntimeException("original failure"),
        );
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
            .put("node.name", "test")
    public void setUp() throws Exception {
            Collections.emptyMap(),
            SnapshotsService.SNAPSHOT_CLEANUP_RETRIES_SETTING.getDefault(Settings.EMPTY),
        ClusterState result = task.execute(currentState);
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 0);
                0,
        );
                () -> mock(ClusterStateUpdateTask.class),
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
            null
            retryLatch.countDown();
            1L,
        threadPool = new TestThreadPool(getTestName());
        snapshotsService.retryOrFailOnClusterManagerFailOver(
        assertTrue(taskSubmitted.await(5, TimeUnit.SECONDS));
import java.util.Collections;
        );
        TimeValue result = SnapshotsService.computeBackoff(TimeValue.timeValueSeconds(1), 50);
    }
            mock(org.opensearch.action.support.ActionFilters.class),
        task.onFailure("test-source", new FailedToCommitClusterStateException("simulated publish failure"));
import org.opensearch.cluster.ClusterStateUpdateTask;
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 0);
            new org.opensearch.indices.RemoteStoreSettings(Settings.EMPTY, clusterSettings),
            Collections.emptyMap(),
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
        Settings settings = Settings.builder().put("node.name", "test").putList("node.roles", "cluster_manager", "data").build();
import static org.mockito.Mockito.mock;
        localService.retryOrFailOnClusterManagerFailOver(
    }
            Collections.emptyList(),
        assertEquals(TimeValue.ZERO, result);
            false,
            return mock(ClusterStateUpdateTask.class);
            null,
     */
        String localNodeId = UUIDs.randomBase64UUID();
            .nodes(DiscoveryNodes.builder().localNodeId(localNodeId).clusterManagerNodeId(localNodeId).build())
            "test-source",
        TimeValue base = TimeValue.timeValueSeconds(1);
        when(transportService.getThreadPool()).thenReturn(threadPool);
        SnapshotsInProgress.Entry normalEntry = SnapshotsInProgress.startedEntry(
    public void testUnexpectedExceptionRunsFallback() {
    }
        assertEquals(normalSnapshot.getSnapshotId(), resultSnapshots.entries().get(0).snapshot().getSnapshotId());
    }
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
            1L,
        assertTrue("Backoff should be at least ~1s, was " + elapsed + "ms", elapsed >= 900L);
package org.opensearch.snapshots;
        snapshotsService.retryOrFailOnClusterManagerFailOver(
    }
     * Regression test: verifies createStateWithoutSnapshotV2Task reads from currentState (not captured outer state).
    }
        expectThrows(AssertionError.class, () -> task.onFailure("test-source", new RuntimeException("unexpected")));
            snapshot,
            () -> mock(ClusterStateUpdateTask.class),
            clusterService,
    }
    public void testStateWithoutSnapshotV2TaskOnFailureNotCMRunsFallback() throws Exception {
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
            () -> fallbackCalled.set(true)
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
    public void testRemoveFailedSnapshotTaskOnFailureExhaustedRetries() throws Exception {
            new RuntimeException("original failure"),
        );
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
            clusterService,
            new FailedToCommitClusterStateException("test"),
            () -> mock(ClusterStateUpdateTask.class),
    }
        assertEquals(TimeValue.timeValueSeconds(1), result);
    }
        task.onFailure("test-source", new NotClusterManagerException("simulated"));
            Collections.emptyMap(),
            1L,
        snapshotsService.retryOrFailOnClusterManagerFailOver(wrapped, 0, "test-source", () -> {
import org.opensearch.cluster.SnapshotsInProgress;
            snapshot,
            null
        }, () -> fallbackCalled2.set(true));
        assertTrue(taskSubmitted.await(5, TimeUnit.SECONDS));
    public void testRemoveFailedSnapshotTaskOnFailureUnexpectedException() throws Exception {
                "test-source",
            new RuntimeException("original failure"),
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
        snapshotsService.retryOrFailOnClusterManagerFailOver(new FailedToCommitClusterStateException("test"), 0, "test-source", () -> {
        assertTrue("Fallback should be called at attempt==maxRetries", fallbackCalled.get());
            Collections.emptyMap(),
            false,
            snapshot,
import org.opensearch.cluster.ClusterState;
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
        assertEquals(TimeValue.timeValueDays(1), result);
            Collections.emptyList(),
        TransportService localTransportService = mock(TransportService.class);
            .build();
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
    public void testRejectedExecutionExceptionInRetryRunsFallback() throws Exception {
        ClusterState currentState = ClusterState.builder(ClusterState.EMPTY_STATE)
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        SnapshotsInProgress.Entry v2Entry = SnapshotsInProgress.startedEntry(
        long start = System.currentTimeMillis();
    }
            localTransportService,
        );
            null,
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(List.of(normalEntry)))
            1L,
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            null,
        ClusterState result = task.execute(currentState);
        }, () -> fallbackCalled.set(true));
            .build();
        snapshotsService.retryOrFailOnClusterManagerFailOver(
            v2Snapshot,
    }
        assertEquals(1, resultSnapshots.entries().size());
            false
            return mock(ClusterStateUpdateTask.class);
            null
            null
        );
        assertFalse(fallbackCalled.get());
            0,
            null,
            Collections.emptyMap(),
        String localNodeId = UUIDs.randomBase64UUID();
            5,
import org.opensearch.common.settings.ClusterSettings;
            null,
        );
        assertFalse("Fallback should not be called when retries remain", fallbackCalled.get());
            false,
        );
        AtomicBoolean listenerCalled = new AtomicBoolean(false);
            .putList("node.roles", "cluster_manager", "data")
        TimeValue result = SnapshotsService.computeBackoff(TimeValue.timeValueHours(25), 0);
        assertTrue(ae.getMessage().contains("Unexpected failure during cluster state update"));
        assertEquals(TimeValue.timeValueSeconds(4), result);
            () -> fallbackCalled.set(true)
    public void testWrappedFailedToCommitRetries() throws Exception {
        snapshotsService.retryOrFailOnClusterManagerFailOver(new FailedToCommitClusterStateException("test"), 0, "test-source", () -> {
        assertTrue(fallbackCalled.get());
    private TestThreadPool threadPool;
        task.onFailure("test-source", new FailedToCommitClusterStateException("simulated publish failure"));
        super.tearDown();
        TimeValue result = SnapshotsService.computeBackoff(TimeValue.timeValueSeconds(1), 0);
        AtomicBoolean fallbackCalled2 = new AtomicBoolean(false);
            new RuntimeException("original failure"),
        );
        Settings newSettings = Settings.builder()
    }
            1L,
            snapshot,
            false
            () -> fallbackCalled.set(true)
        ClusterService localClusterService = mock(ClusterService.class);
        TransportService transportService = mock(TransportService.class);
    /**
 * The OpenSearch Contributors require contributions made to
    }
            settings,
            null,
    }
import org.opensearch.common.settings.Settings;
    }
    public void testStateWithoutSnapshotV2TaskOnFailureRetries() throws Exception {
import org.opensearch.transport.TransportService;
            0,
            0,
            .put(SnapshotsService.SNAPSHOT_CLEANUP_RETRY_BACKOFF_SETTING.getKey(), "5s")
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 0);
            AssertionError.class,
            () -> mock(ClusterStateUpdateTask.class),
            settings,
            "test-source",
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.cluster.NotClusterManagerException;
    public void testRemoveFailedSnapshotTaskOnFailureWithListenerNotNull() throws Exception {
        assertEquals(TimeValue.timeValueSeconds(2), SnapshotsService.computeBackoff(base, 1));
        assertTrue("Task factory should be invoked for retry", taskSubmitted.await(5, TimeUnit.SECONDS));
 * compatible open source license.
        assertSame("Should return same state when no V2 entries to remove", currentState, result);
                new RuntimeException("unexpected"),
        task.clusterStateProcessed("test-source", state, state);
    }
 */
            Collections.emptyList(),
            new RuntimeException("original failure"),
            null
            snapshot,
        CountDownLatch taskSubmitted = new CountDownLatch(1);
            new RuntimeException("original failure"),
    }
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
        task.onFailure("test-source", new NotClusterManagerException("simulated"));
import java.util.concurrent.atomic.AtomicBoolean;
        );
            Collections.emptyList(),
    public void testComputeBackoffDoesNotOverflowAndIsClamped() {
    public void testComputeBackoffHighAttemptCapped() {
import org.opensearch.threadpool.TestThreadPool;
        Settings settings = Settings.builder()
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
        svc.retryOrFailOnClusterManagerFailOver(
        ClusterState currentState = ClusterState.builder(ClusterState.EMPTY_STATE)
    }
            null,
    }
    }
        );
            null
    public void testRemoveFailedSnapshotTaskOnFailureRetries() throws Exception {
        CountDownLatch taskSubmitted = new CountDownLatch(1);
            true,
    }
            .nodes(DiscoveryNodes.builder().localNodeId(localNodeId).clusterManagerNodeId(localNodeId).build())
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
            .nodes(DiscoveryNodes.builder().localNodeId(localNodeId).clusterManagerNodeId(localNodeId).build())
            true,
        ThreadPool.terminate(terminatedPool, 0, TimeUnit.MILLISECONDS);
        clusterSettings.applySettings(newSettings);
            Collections.emptyMap(),
import org.opensearch.cluster.coordination.FailedToCommitClusterStateException;
            () -> fallbackCalled.set(true)
            snapshot,
    }
            mock(org.opensearch.cluster.metadata.IndexNameExpressionResolver.class),
    }
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);
            .putCustom(SnapshotsInProgress.TYPE, SnapshotsInProgress.of(List.of(v2Entry, normalEntry)))
}
            factoryCalls.incrementAndGet();
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
    }
        snapshotsService = new SnapshotsService(
            Version.CURRENT,
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
            true
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
        task.onFailure("test-source", new FailedToCommitClusterStateException("simulated"));
        CountDownLatch retryLatch = new CountDownLatch(1);
        );
            null
            transportService,
    public void testSettingsUpdateConsumerForRetries() {
    @Override
            localClusterService,
    }
            0,
    private ClusterService clusterService;
        assertEquals(TimeValue.timeValueSeconds(4), SnapshotsService.computeBackoff(base, 2));
            wrapped,
        );
            null
import org.opensearch.cluster.service.ClusterService;
        assertTrue(fallbackCalled.get());
        }, () -> {});
        snapshotsService.retryOrFailOnClusterManagerFailOver(new FailedToCommitClusterStateException("test"), 100, "test-source", () -> {
            Version.CURRENT,
            new org.opensearch.indices.RemoteStoreSettings(Settings.EMPTY, clusterSettings),
        );
            new RuntimeException("test failure"),
    public void testComputeBackoffCapsAtOneDay() {
        }, () -> {});
            "test-source",
            taskSubmitted.countDown();
        expectThrows(AssertionError.class, () -> task.onFailure("test-source", new RuntimeException("unexpected")));
            new FailedToCommitClusterStateException("test"),
            () -> mock(ClusterStateUpdateTask.class),
            throw new AssertionError("should not be called");
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 100);
        task.onNoLongerClusterManager("test-source");
        when(localClusterService.getClusterSettings()).thenReturn(clusterSettings);
        assertTrue("Fallback should run before the assert fires", fallbackCalled.get());
        String localNodeId = UUIDs.randomBase64UUID();
            mock(org.opensearch.action.support.ActionFilters.class),
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
            null,
            .nodes(DiscoveryNodes.builder().localNodeId(localNodeId).clusterManagerNodeId(localNodeId).build())
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
            transportService,
        CountDownLatch taskSubmitted = new CountDownLatch(1);
    public void testNotClusterManagerExceptionRunsFallback() {
        TimeValue result = SnapshotsService.computeBackoff(TimeValue.ZERO, 5);
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
        SnapshotsInProgress.Entry entry = SnapshotsInProgress.startedEntry(
        AssertionError ae = expectThrows(
            taskSubmitted.countDown();
            .build();
import org.opensearch.common.unit.TimeValue;
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
            true,
    public void testWrappedNotClusterManagerRunsFallback() {
            null
            0,
        );
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
        ClusterState result = task.execute(currentState);
            0,
        TestThreadPool terminatedPool = new TestThreadPool(getTestName());
    }
            true,
    }
import org.opensearch.test.OpenSearchTestCase;
        );
            return mock(ClusterStateUpdateTask.class);
            0,
            Collections.emptyList(),
            new FailedToCommitClusterStateException("test"),
        AtomicInteger factoryCalls = new AtomicInteger(0);
import java.util.concurrent.TimeUnit;
            .build();
            "test-source",
            .put(SnapshotsService.SNAPSHOT_CLEANUP_RETRIES_SETTING.getKey(), 5)
        );
        snapshotsService.retryOrFailOnClusterManagerFailOver(new FailedToCommitClusterStateException("test"), 0, "test-source", () -> {
        Snapshot snapshot = new Snapshot("repo", new SnapshotId("snap-1", UUIDs.randomBase64UUID()));
    @Override
            "test-source",
        assertTrue("Fallback should be called when retries exhausted", fallbackCalled.get());
        assertFalse(resultSnapshots.entries().get(0).remoteStoreIndexShallowCopyV2());
            mock(org.opensearch.repositories.RepositoriesService.class),
        TimeValue delay = SnapshotsService.computeBackoff(base, 1000);
            Version.CURRENT,
            snapshot,
    public void testComputeBackoffAttemptTwo() {
    public void testRetryCreatesNewTaskInstance() throws Exception {
        );
            null,
            snapshot,
            () -> mock(ClusterStateUpdateTask.class),
            false,
    public void testRemoveFailedSnapshotTaskOnNoLongerClusterManagerWithoutListener() throws Exception {
            new NotClusterManagerException("test"),
import static org.mockito.Mockito.when;
            return mock(ClusterStateUpdateTask.class);
        assertTrue(fallbackCalled.get());
            100,
import java.util.concurrent.atomic.AtomicInteger;
    public void testComputeBackoffWithZeroBase() {
            false,
            0,
        SnapshotsInProgress resultSnapshots = result.custom(SnapshotsInProgress.TYPE);
            settings,
        assertTrue(taskSubmitted.await(5, TimeUnit.SECONDS));
            normalSnapshot,
    public void testComputeBackoffAttemptZero() {
        long elapsed = System.currentTimeMillis() - start;
            mock(org.opensearch.cluster.metadata.IndexNameExpressionResolver.class),
    public void testComputeBackoffIsExponential() {
            "test-source",
import org.opensearch.common.UUIDs;
            false,
            null,
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
        assertTrue("Snapshot entry should be removed", resultSnapshots.entries().isEmpty());
        SnapshotsService svc = new SnapshotsService(
                () -> fallbackCalled.set(true)
    public void testCreateStateWithoutSnapshotV2TaskNoChangeReturnsOriginal() throws Exception {
            "test-source",
            .build();
import java.util.concurrent.CountDownLatch;
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        SnapshotsService localService = new SnapshotsService(
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
    }
            "test-source",
            snapshot,
        assertEquals(TimeValue.timeValueSeconds(1), SnapshotsService.computeBackoff(base, 0));
        Snapshot normalSnapshot = new Snapshot("repo", new SnapshotId("normal-snap", UUIDs.randomBase64UUID()));
            return mock(ClusterStateUpdateTask.class);
            null
    }
        ClusterStateUpdateTask task = snapshotsService.createStateWithoutSnapshotV2Task("test-source", 0);
        TimeValue base = TimeValue.timeValueSeconds(1);
        assertNotNull(resultSnapshots);
            "test-source",
        Snapshot v2Snapshot = new Snapshot("repo", new SnapshotId("v2-snap", UUIDs.randomBase64UUID()));
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
    }
            normalSnapshot,
        Exception wrapped = new RuntimeException("wrapper", new NotClusterManagerException("inner"));
            snapshot,
            false
            0,
        AtomicBoolean fallbackCalled = new AtomicBoolean(false);
            )
        ClusterState state = ClusterState.builder(ClusterState.EMPTY_STATE)
            mock(org.opensearch.repositories.RepositoriesService.class),
    }
        task.onFailure("test-source", new NotClusterManagerException("simulated"));
        assertEquals(TimeValue.timeValueDays(1), result);
            mock(org.opensearch.repositories.RepositoriesService.class),
        CountDownLatch taskSubmitted = new CountDownLatch(1);
            taskSubmitted.countDown();
    @LockFeatureFlag(FeatureFlags.SNAPSHOT_RESILIENCE)
        );
        );
            "test-source",
            "test-source",
    public void testStateWithoutSnapshotV2ReadsLiveState() throws Exception {
            () -> fallbackCalled.set(true)
        ClusterStateUpdateTask task = snapshotsService.createRemoveFailedSnapshotTask(
        ClusterState currentState = ClusterState.builder(ClusterState.EMPTY_STATE)
        String localNodeId = UUIDs.randomBase64UUID();
            Collections.emptyMap(),
            mock(org.opensearch.cluster.metadata.IndexNameExpressionResolver.class),
        task.onFailure("test-source", new FailedToCommitClusterStateException("simulated"));
        TimeValue result = SnapshotsService.computeBackoff(TimeValue.timeValueSeconds(1), 2);
