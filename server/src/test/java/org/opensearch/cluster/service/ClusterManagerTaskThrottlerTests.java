        // set some limit for put-mapping tasks
            clusterService,
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
                    try {
        assertEquals(0L, throttlingStats.getThrottlingCount(task.getKey()));
    public void testThrottlingThresholdNotConfigured() {
            return clusterService.getClusterManagerService().getMinNodeVersion();
                } catch (InterruptedException e) {
            "local_master_node",
            clusterService,
        assertEquals(newLimit, throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
    }
            ClusterManagerThrottlingException.class,
            return clusterService.getClusterManagerService().getMinNodeVersion();
                        latch.await();
        assertThrows(
            threadToLock.start();
        // remove one task
        }
        setState(
        // add 3 tasks should pass now.
        Settings nullSettings = Settings.builder().build();
import org.junit.BeforeClass;
            threadToLock.start();
            taskList.add(testTaskBatcher.new UpdateTask(Priority.HIGH, taskKey, taskKey, (source, e) -> {
                });
        // Asserting that there was not any throttling for it
package org.opensearch.cluster.service;
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
        // adding 3 tasks
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            return clusterService.getClusterManagerService().getMinNodeVersion();
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    }
                try {
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
        setState(
        int maxDelay = randomIntBetween(1, 10);
        // assert that delay setting is applied on throttler
            .put("cluster_manager.throttling.retry.base.delay", baseDelay + "s")
                        ClusterManagerThrottlingException.class,
    private DiscoveryNode getDataNode(Version version) {
        for (String key : throttler.THROTTLING_TASK_KEYS.keySet()) {
                    throw new AssertionError(e);
                    }
import org.junit.Before;
                    } catch (InterruptedException e) {
    @AfterClass
        );
        assertEquals(maxDelay, ClusterManagerTaskThrottler.getMaxDelayForRetry().seconds());
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
import org.opensearch.common.settings.ClusterSettings;
    public void setUp() throws Exception {
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
        throttler.updateLimit(task.getKey(), 5);
        assertEquals(4L, throttlingStats.getThrottlingCount(task.getKey()));
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
        } finally {
        // setting threshold in initial settings
                latch2.await();
        class MockExecutor
    public void testValidateSettingsForUnknownTask() {
    }
    @After
        }, new ClusterManagerThrottlingStats());
        int newLimit = randomIntBetween(1, 10);
    public void testThrottlingForDisabledThrottlingTask() {
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
    }
        try {
            ClusterManagerThrottlingException.class,
        assertEquals(ClusterManagerTask.PUT_MAPPING.getThreshold(), throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
    public void testValidateSettingsForDifferentVersion() {
        // exists in the ClusterManagerTask enum (indicating it was once valid).
    public void testThrottlingForInitialStaticSettingAndVersionCheck() {
            clusterService,
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
        }
        );
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
        }, throttlingStats);
            Collections.emptyMap(),
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode })
        List<Thread> submittingThreads = new ArrayList<>();
        // set some limit for put-mapping tasks
     */
import java.util.concurrent.CountDownLatch;
                    latch2.countDown();
        ClusterManagerTask task = CREATE_INDEX;
        // add 3 tasks should pass now.
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(ClusterManagerTaskThrottler.maxDelay, ClusterManagerTaskThrottler.getMaxDelayForRetry());
                List<TaskBatcherTests.TestTaskBatcher.UpdateTask> tasks
        clusterSettings.applySettings(newSettings);
        // adding 10 tasks, should pass as throttling is disabled for task
        threadPool = new TestThreadPool("TransportMasterNodeActionTests");
            assertEquals(Optional.of(5L).get(), throttler.tasksCount.get(task.getKey()));
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(initialSettings, clusterSettings, () -> {
 */
    private DiscoveryNode getClusterManagerNode(Version version) {
                    return 10L;
        // taskCount in Queue: 2 Threshold: 5
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = throttler.registerClusterManagerTask(task, true);
        // remove one task
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        final CountDownLatch latch = new CountDownLatch(1);
            public void execute(List tasks) {}
        throttler.updateLimit(PUT_MAPPING.getKey(), -1);
import org.opensearch.cluster.ClusterChangedEvent;
        // add 3 tasks should pass now.
    }
        // taskCount in Queue: 3 Threshold: 5
        setState(
                }
            }
    public void testValidateSettingGracefullyHandlesUnregisteredEnumKey() {
        Settings unknownSettings = Settings.builder().put("cluster_manager.throttling.thresholds.completely-fake-task.value", 10).build();
        throttler.updateLimit(task.getKey(), 5);
import static org.opensearch.cluster.service.ClusterManagerTaskThrottler.THRESHOLD_SETTINGS;
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        ClusterManagerTask task = CREATE_INDEX;
            ClusterManagerThrottlingException.class,
        assertEquals(5L, throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
        throttler.onBeginProcessing(getMockUpdateTaskList(task.getKey(), throttlingKey, 1));
        setState(
    }
        ClusterManagerThrottlingStats throttlingStats = new ClusterManagerThrottlingStats();
                    try {
     * state from prior versions. Instead of a fatal IllegalArgumentException, the method should
        }, new ClusterManagerThrottlingStats());
            threadToLock = new Thread(() -> {
        // taskCount in Queue: 5 Threshold: 5
        int newLimit = randomIntBetween(1, 10);
                "validateSetting() should not throw for a key that exists in ClusterManagerTask enum "
    private List<TaskBatcherTests.TestTaskBatcher.UpdateTask> getMockUpdateTaskList(
                () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 1))
        }, throttlingStats);
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_MAPPING;
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
        // taskCount in Queue: 2 Threshold: 5
        clusterSettings.applySettings(nullSettings);
    }
        // update limit of threshold 6
}
        // taskCount in Queue: 3 Threshold: 5
    public void testThrottlingWithMultipleOnBeginSubmitsThreadsWithLock() {
 *
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
        );
    @Override
            throttler.validateSetting(THRESHOLD_SETTINGS.get(settingsWithUnregisteredKey));
            return clusterService.getClusterManagerService().getMinNodeVersion();
        return new DiscoveryNode(
            }
        }, new ClusterManagerThrottlingStats());
        try {
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));
        super.tearDown();
            clusterService,
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            assertEquals(ClusterManagerTask.fromKey(key).getThreshold(), throttler.getThrottlingLimit(key).intValue());
import org.opensearch.common.Priority;
        int newLimit = randomIntBetween(1, 10);
        assertEquals(maxDelay, ClusterManagerTaskThrottler.getMaxDelayForRetry().seconds());
            () -> throttler.onBeginSubmit(getMockUpdateTaskList(PUT_MAPPING.getKey(), throttlingKey, 3))
    }
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", newLimit).build();
        // adding limit directly in thresholds
            });
        );
                    + "when cluster state contains persisted throttling settings for that key. Got: "
                    );
            "local_data_node",
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
    }
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", newLimit).build();
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
        }, new ClusterManagerThrottlingStats());
                } catch (InterruptedException e) {
        ClusterManagerThrottlingStats throttlingStats = new ClusterManagerThrottlingStats();
    public void tearDown() throws Exception {
                }
        ClusterManagerThrottlingStats throttlingStats = new ClusterManagerThrottlingStats();
            .build();
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
            public String describeTasks(List tasks) {
        newSettings = Settings.builder().put("cluster_manager.throttling.retry.max.delay", maxDelay + "s").build();
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
            .build();
        );
            fail(
        }, throttlingStats);
        ClusterManagerTask task = CREATE_INDEX;
 * SPDX-License-Identifier: Apache-2.0
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey,
        setState(
 * compatible open source license.
import java.util.concurrent.TimeUnit;
        );
        Settings initialSettings = Settings.builder()
    @BeforeClass
        throttler.registerClusterManagerTask(CREATE_INDEX, true);
        assertEquals(Optional.of(10L).get(), throttler.tasksCount.get(task.getKey()));
        assertEquals(Optional.of(10L).get(), throttler.tasksCount.get(task.getKey()));
            for (int i = 0; i < 10; i++) {
        throttler.onBeginProcessing(getMockUpdateTaskList(task.getKey(), throttlingKey, 1));
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
     * refactor removes a registerClusterManagerTask() call but the key remains persisted in cluster
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
        // adding 3 tasks
        int baseDelay = randomIntBetween(1, 10);
        setState(
            threadToLock = new Thread(() -> {
        clusterSettings.applySettings(newSettings);
        assertEquals(ClusterManagerTask.PUT_MAPPING.getThreshold(), throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
            IllegalArgumentException.class,
                    throw new RuntimeException(e);
    }
        );
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        throttler.updateLimit(PUT_MAPPING.getKey(), 5);
                    threadToLock.join();
        );
            buildNewFakeTransportAddress(),
                    final ClusterManagerThrottlingException exception = assertThrows(
        Settings initialSettings = Settings.builder()
            assertEquals(13L, throttlingStats.getThrottlingCount(task.getKey()));
            });
        assertEquals("No cluster manager task found for key: random-task", exception.getMessage());
        Thread threadToLock = null;
            // adding one task will throttle
        assertEquals(baseDelay, ClusterManagerTaskThrottler.getBaseDelayForRetry().seconds());
                    threadToLock.join();
                    submittingThread.join();
            for (Thread submittingThread : submittingThreads) {
        setState(
            clusterService,
        super.setUp();
    }
            return clusterService.getClusterManagerService().getMinNodeVersion();
            }
        // As queue already have more tasks than threshold from previous call.
public class ClusterManagerTaskThrottlerTests extends OpenSearchTestCase {
        throttler.updateLimit(task.getKey(), 5);
        assertEquals(0L, throttlingStats.getThrottlingCount(PUT_MAPPING.getKey()));
        DiscoveryNode dataNode = getDataNode(Version.V_2_4_0);
            Collections.emptyMap(),
import java.util.ArrayList;
        // validate for empty setting, it shouldn't throw exception
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));
            clusterService,
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
            if (threadToLock != null) {
        int put_mapping_threshold_value = randomIntBetween(1, 10);
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
        // set some limit for put-mapping tasks
import org.junit.AfterClass;
        // Validate a setting for the unregistered-but-enum-present key CREATE_INDEX.
    ) {
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
import org.opensearch.cluster.ClusterState;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {}
    private ClusterService clusterService;
        assertEquals(ClusterManagerTaskThrottler.baseDelay, ClusterManagerTaskThrottler.getBaseDelayForRetry());
        ClusterManagerTask task = CREATE_INDEX;
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
    public void testUpdateRetryDelaySetting() {
            return clusterService.getClusterManagerService().getMinNodeVersion();
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
                throw new RuntimeException(e);
                Thread submittingThread = new Thread(() -> {
            .put("cluster_manager.throttling.thresholds.put-mapping.value", put_mapping_threshold_value)
        final CountDownLatch latch = new CountDownLatch(1);
import static org.opensearch.test.ClusterServiceUtils.setState;
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
        int maxDelay = randomIntBetween(1, 10);
    public static void afterClass() {
 */
        assertThrows(IllegalArgumentException.class, () -> throttler.validateSetting(THRESHOLD_SETTINGS.get(newSettings)));
        // This should NOT throw — it should log a warning and skip, because the key
     * Verifies that validateSetting() gracefully handles a key that exists in the ClusterManagerTask
            buildNewFakeTransportAddress(),
            // taskCount in Queue: 5 Threshold: 5
    public void testUpdateSettingsForNullValue() {
        }, new ClusterManagerThrottlingStats());
        // adding 3 tasks
/*
            return clusterService.getClusterManagerService().getMinNodeVersion();
import java.util.Optional;
        Settings emptySettings = Settings.builder().build();
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
            () -> throttler.registerClusterManagerTask(ClusterManagerTask.fromKey("random-task"), true)
            }
                ClusterManagerThrottlingException.class,
        assertEquals(Optional.of(10L).get(), throttler.tasksCount.get(task.getKey()));
        long newLimit = randomLongBetween(1, 10);
     * registered nor present in the ClusterManagerTask enum.
        final IllegalArgumentException exception = assertThrows(
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.retry.base.delay", baseDelay + "s").build();
        return taskList;
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = throttler.registerClusterManagerTask(task, false);
            }
                throttler.tasksCount.computeIfPresent(task.getKey(), (key, count) -> {
    }
import java.util.Collections;
    public void testThrottling() {
            ) throws Exception {
                    // Wait to complete and then assert on new tasksCount that got modified by threadToLock Thread
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            clusterService,
import org.opensearch.test.OpenSearchTestCase;
        int newLimit = randomIntBetween(1, 10);
        }, new ClusterManagerThrottlingStats());
        assertThrows(
    public void testValidateSettingForLimit() {
import org.junit.After;
        clusterSettings.applySettings(newSettings);
                    + e.getMessage()
                return throttlingKey;
    public void testValidateSettingsForTaskWithoutRetryOnDataNode() {
        try {
        // set some limit for put-mapping tasks
        // Asserting value in tasksCount map to make sure it gets updated even when throttling is disabled
                        throw new RuntimeException(e);
        setState(
            return clusterService.getClusterManagerService().getMinNodeVersion();
                    throw new RuntimeException(e);
        int baseDelay = randomIntBetween(1, 10);
        // check default value
        // A truly unknown key (not in enum, not registered) should still throw
            if (threadToLock != null) {
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_INDEX;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import java.util.List;
        }, new ClusterManagerThrottlingStats());
                submittingThreads.add(submittingThread);
                ClusterStateTaskExecutor<TaskBatcherTests.TestTaskBatcher.UpdateTask> {
            @Override
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
            clusterService,
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode })
        ClusterManagerThrottlingStats throttlingStats = new ClusterManagerThrottlingStats();
        } catch (Exception e) {
                    return 10L;
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
    @Before
            return clusterService.getClusterManagerService().getMinNodeVersion();
        }
                    assertEquals(Optional.of(5L).get(), throttler.tasksCount.get(task.getKey()));
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
    /**
        int size
import org.opensearch.cluster.node.DiscoveryNode;
        } catch (IllegalArgumentException e) {
        ClusterManagerThrottlingStats throttlingStats = new ClusterManagerThrottlingStats();
                submittingThread.start();
                }
        );
            .put("cluster_manager.throttling.thresholds.put-mapping.value", put_mapping_threshold_value)
            }, new MockExecutor()));
                }
        }, throttlingStats);
/**
        // verify update base delay
            ClusterManagerThrottlingException.class,
    public void testValidateSettingStillRejectsGenuinelyUnknownKeys() {
            return clusterService.getClusterManagerService().getMinNodeVersion();
        // taskCount in Queue: 3 Threshold: 5
        // taskCount in Queue: 2 Threshold: 5
        assertThrows(IllegalArgumentException.class, () -> throttler.validateSetting(THRESHOLD_SETTINGS.get(newSettings)));
    public void testUpdateThrottlingLimitForBasicSanity() {
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));
            // it shouldn't throw exception
import org.opensearch.threadpool.ThreadPool;
        );
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.random-task.value", newLimit).build();
        }
                latch.countDown();
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
        // verify update max delay
        // assert that limit is applied on throttler
            );
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
        // remove one task
                    // taskCount in Queue: 5 Threshold: 5
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
            return clusterService.getClusterManagerService().getMinNodeVersion();
            implements
                TaskExecutorTests.TestExecutor,
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", newLimit).build();
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
        assertEquals(3L, throttlingStats.getThrottlingCount(PUT_MAPPING.getKey()));
        }, new ClusterManagerThrottlingStats());
     */
    }
        Settings settingsWithUnregisteredKey = Settings.builder()
    public void testUpdateLimit() {
        );
        // Removing older version node from cluster
        setState(
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
            return clusterService.getClusterManagerService().getMinNodeVersion();
                        throw new RuntimeException(e);
        return new DiscoveryNode(
        assertEquals(baseDelay, ClusterManagerTaskThrottler.getBaseDelayForRetry().seconds());
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode })
        }, new ClusterManagerThrottlingStats());
import org.opensearch.threadpool.TestThreadPool;
                try {
        );
                return taskKey;
        assertThrows(
        // Only register PUT_MAPPING — leave CREATE_INDEX unregistered to simulate a removed registration
                    } catch (InterruptedException e) {
            }
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
        }
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
        );
import org.opensearch.common.settings.Settings;
    }
                if (!(e instanceof ClusterManagerThrottlingException)) {
            return clusterService.getClusterManagerService().getMinNodeVersion();
            .put("cluster_manager.throttling.retry.max.delay", maxDelay + "s")
        throttler.onBeginProcessing(getMockUpdateTaskList(task.getKey(), throttlingKey, 1));
     * enum but is not registered in THROTTLING_TASK_KEYS. This simulates the scenario where a
        // adding 3 more tasks, these tasks should be throttled
            clusterService,
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
        }, new ClusterManagerThrottlingStats());
                latch.countDown();
        assertThrows(IllegalArgumentException.class, () -> throttler.validateSetting(THRESHOLD_SETTINGS.get(newSettings)));
        int put_mapping_threshold_value = randomIntBetween(1, 10);
        assertEquals(put_mapping_threshold_value, throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
    public static void beforeClass() {
        newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", 20).build();
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", newLimit).build();
        assertThrows(
            .build();
     * log a warning and skip validation for that key.
            @Override
            // Taking lock on tasksCount will not impact throttling behaviour now.
        }, throttlingStats);
        threadPool = null;
        // adding 3 more tasks, these tasks should be throttled
import org.opensearch.test.ClusterServiceUtils;
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 1));
import org.opensearch.cluster.node.DiscoveryNodeRole;
        List<TaskBatcherTests.TestTaskBatcher.UpdateTask> taskList = new ArrayList<>();
            } catch (InterruptedException e) {
            throw new AssertionError(e);
            return clusterService.getClusterManagerService().getMinNodeVersion();
        );
            () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3))
        // adding more tasks, these tasks should be throttled
            assertEquals(4L, throttlingStats.getThrottlingCount(task.getKey()));
        throttler.updateLimit(task.getKey(), 5);
    }
        TaskBatcherTests.TestTaskBatcher testTaskBatcher = new TaskBatcherTests.TestTaskBatcher(logger, null);
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
    /**
            version
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));
        }, new ClusterManagerThrottlingStats());
 * this file be licensed under the Apache-2.0 license or a
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(initialSettings, clusterSettings, () -> {
    }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        setState(
                // No Op
     * Verifies that validateSetting() still rejects truly unknown keys that are neither
                        latch.await();
        assertThrows(IllegalArgumentException.class, () -> throttler.validateSetting(THRESHOLD_SETTINGS.get(unknownSettings)));
    }
                });
        // verify defaults
            clusterService,
        assertNull(throttler.getThrottlingLimit(PUT_MAPPING.getKey()));
            () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 1))
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {
        throttler.registerClusterManagerTask(PUT_MAPPING, false);
        }, new ClusterManagerThrottlingStats());
        // verifying adding more tasks than threshold passes
        String taskKey,
            @Override
            clusterService,
    }
        clusterSettings.applySettings(newSettings);
    }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertEquals(newLimit, throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
        throttler.updateLimit(task.getKey(), 6);
        clusterSettings.applySettings(newSettings);
            () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3))
            .put("cluster_manager.throttling.thresholds.create-index.value", 50)
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.Version;
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
 * Contains tests for {@link ClusterManagerTaskThrottler}
            @Override
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
                        () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 1))
        assertEquals(3L, throttlingStats.getThrottlingCount(task.getKey()));
            () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3))
    }
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));
    }
        // adding one task will throttle
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                throttler.tasksCount.computeIfPresent(task.getKey(), (key, count) -> {
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            return clusterService.getClusterManagerService().getMinNodeVersion();
        // adding one task should pass now
            }
        setState(
            return clusterService.getClusterManagerService().getMinNodeVersion();
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
        assertEquals(3L, throttlingStats.getThrottlingCount(task.getKey()));
    }
        );
        );
        assertEquals(20, throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
 * The OpenSearch Contributors require contributions made to
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = throttler.registerClusterManagerTask(task, true);
            );
    public void testSettingsOnBootstrap() {
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
                });
    }
                    throw new RuntimeException(e);
        assertThrows(
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
            return clusterService.getClusterManagerService().getMinNodeVersion();
            try {
        assertEquals(3L, throttlingStats.getThrottlingCount(task.getKey()));
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = throttler.registerClusterManagerTask(task, true);
    }
        for (int i = 0; i < size; i++) {
            version
            public ClusterTasksResult<TaskBatcherTests.TestTaskBatcher.UpdateTask> execute(
                    assertEquals("Throttling Exception : Limit exceeded for create-index", exception.getMessage());
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
        } finally {
                } catch (InterruptedException e) {
        // set put-mapping task limit to 20
        );
        DiscoveryNode dataNode = getDataNode(Version.V_2_0_0);
            // Taking lock on tasksCount will not impact throttling behaviour now.
                try {
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
        // adding 3 more tasks, these tasks should be throttled
        // set some limit for random tasks
        Thread threadToLock = null;
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 10));
                    // adding one task will throttle
import org.opensearch.cluster.ClusterStateTaskExecutor;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        }, new ClusterManagerThrottlingStats());
                    }
                // Wait to complete and then assert on new tasksCount that got modified by threadToLock Thread
            final ClusterManagerThrottlingException exception = assertThrows(
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testDefaults() {
        // set limit to null
        assertThrows(IllegalArgumentException.class, () -> throttler.validateSetting(THRESHOLD_SETTINGS.get(newSettings)));
        }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
            }
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),
            final CountDownLatch latch2 = new CountDownLatch(10);
    public void testThrottlingWithLock() {
    private static ThreadPool threadPool;
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
                return null;
        }
                ClusterState currentState,
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = throttler.registerClusterManagerTask(PUT_MAPPING, true);
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", -5).build();
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
        );
        try {
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));
    }
        clusterService.close();
            return clusterService.getClusterManagerService().getMinNodeVersion();
            ClusterManagerThrottlingException.class,
            throttler.validateSetting(emptySettings);
                    + "but is not registered. This would cause fatal node startup failures during upgrades "
            @Override
            assertEquals("Throttling Exception : Limit exceeded for create-index", exception.getMessage());
        throttler.onBeginSubmit(getMockUpdateTaskList(PUT_MAPPING.getKey(), throttlingKey, put_mapping_threshold_value + 5));
