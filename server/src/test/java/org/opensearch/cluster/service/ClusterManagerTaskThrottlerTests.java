            return clusterService.getClusterManagerService().getMinNodeVersion();
        for (int i = 0; i < size; i++) {
        // A truly unknown key (not in enum, not registered) should still throw
        ClusterManagerThrottlingStats throttlingStats = new ClusterManagerThrottlingStats();
        );  
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
/**
                // Wait to complete and then assert on new tasksCount that got modified by threadToLock Thread
                }
                    throw new RuntimeException(e);  
        ClusterManagerTask task = CREATE_INDEX;
        setState(
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode })
    }
            return clusterService.getClusterManagerService().getMinNodeVersion();
        Settings nullSettings = Settings.builder().build();
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {  
                try {  
            // Taking lock on tasksCount will not impact throttling behaviour now.
        );
    public void testValidateSettingsForTaskWithoutRetryOnDataNode() {
            if (threadToLock != null) {  
        Thread threadToLock = null;
            }
        }
            assertEquals(Optional.of(5L).get(), throttler.tasksCount.get(task.getKey()));  
     * Verifies that validateSetting() still rejects truly unknown keys that are neither
        long newLimit = randomLongBetween(1, 10);
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = throttler.registerClusterManagerTask(task, true);
    }  
            clusterService,  
            // adding one task will throttle
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));
    }
            }  
            threadToLock.start();  
    }
            threadToLock = new Thread(() -> {
        }, new ClusterManagerThrottlingStats());
        throttler.onBeginProcessing(getMockUpdateTaskList(task.getKey(), throttlingKey, 1));
            return clusterService.getClusterManagerService().getMinNodeVersion();
        assertEquals(4L, throttlingStats.getThrottlingCount(task.getKey()));
            Collections.singleton(DiscoveryNodeRole.DATA_ROLE),
        ClusterManagerThrottlingStats throttlingStats = new ClusterManagerThrottlingStats();
import org.opensearch.test.OpenSearchTestCase;  
                List<TaskBatcherTests.TestTaskBatcher.UpdateTask> tasks
        setState(
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));
        // set some limit for random tasks
        return new DiscoveryNode(
            version
            public void execute(List tasks) {}  
        Settings unknownSettings = Settings.builder().put("cluster_manager.throttling.thresholds.completely-fake-task.value", 10).build();  
                    // adding one task will throttle  
                }
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            if (threadToLock != null) {
        );
        Settings initialSettings = Settings.builder()  
        assertEquals(put_mapping_threshold_value, throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
        // Asserting value in tasksCount map to make sure it gets updated even when throttling is disabled
        assertEquals(3L, throttlingStats.getThrottlingCount(PUT_MAPPING.getKey()));  
        }, new ClusterManagerThrottlingStats());  
    }  
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
    }
import java.util.Optional;
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
        // adding 3 more tasks, these tasks should be throttled
import org.opensearch.test.ClusterServiceUtils;
        );  
                    // taskCount in Queue: 5 Threshold: 5
            ClusterManagerThrottlingException.class,  
        throttler.updateLimit(PUT_MAPPING.getKey(), 5);  
            for (int i = 0; i < 10; i++) {
            Collections.singleton(DiscoveryNodeRole.CLUSTER_MANAGER_ROLE),  
            clusterService,  
        }, new ClusterManagerThrottlingStats());  
        // add 3 tasks should pass now.  
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);  
            return clusterService.getClusterManagerService().getMinNodeVersion();  
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 10));  
            }
    }
 * Contains tests for {@link ClusterManagerTaskThrottler}  
        throttler.registerClusterManagerTask(PUT_MAPPING, true);  
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(initialSettings, clusterSettings, () -> {  
import org.opensearch.threadpool.ThreadPool;
     * enum but is not registered in THROTTLING_TASK_KEYS. This simulates the scenario where a
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", newLimit).build();
        List<TaskBatcherTests.TestTaskBatcher.UpdateTask> taskList = new ArrayList<>();
        }, throttlingStats);
    public void testThrottling() {  
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));  
                });  
            throttler.validateSetting(emptySettings);
            buildNewFakeTransportAddress(),  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
    public void testThrottlingThresholdNotConfigured() {
        );
        throttler.registerClusterManagerTask(CREATE_INDEX, true);
            return clusterService.getClusterManagerService().getMinNodeVersion();
        // Removing older version node from cluster  
        throttler.onBeginSubmit(getMockUpdateTaskList(PUT_MAPPING.getKey(), throttlingKey, put_mapping_threshold_value + 5));  
                TaskExecutorTests.TestExecutor,
        // verify update max delay  
            return clusterService.getClusterManagerService().getMinNodeVersion();
        assertThrows(IllegalArgumentException.class, () -> throttler.validateSetting(THRESHOLD_SETTINGS.get(newSettings)));
        try {
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
    public void testValidateSettingStillRejectsGenuinelyUnknownKeys() {
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", newLimit).build();
            Collections.emptyMap(),
                    return 10L;
    /**  
        assertEquals(baseDelay, ClusterManagerTaskThrottler.getBaseDelayForRetry().seconds());
        // adding more tasks, these tasks should be throttled  
        DiscoveryNode dataNode = getDataNode(Version.V_2_4_0);  
    public void testValidateSettingForLimit() {
    }
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
                } catch (InterruptedException e) {
            for (Thread submittingThread : submittingThreads) {
    public void setUp() throws Exception {
            assertEquals("Throttling Exception : Limit exceeded for create-index", exception.getMessage());
        ClusterManagerTask task = CREATE_INDEX;
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);  
            );
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);  
        );
        assertEquals("No cluster manager task found for key: random-task", exception.getMessage());
        }  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
        return taskList;
            threadToLock = new Thread(() -> {  
                return throttlingKey;
        );
        assertEquals(3L, throttlingStats.getThrottlingCount(task.getKey()));
        }, new ClusterManagerThrottlingStats());
                latch.countDown();
            .put("cluster_manager.throttling.thresholds.put-mapping.value", put_mapping_threshold_value)
        return new DiscoveryNode(
        // setting threshold in initial settings  
        final CountDownLatch latch = new CountDownLatch(1);
            .put("cluster_manager.throttling.thresholds.put-mapping.value", put_mapping_threshold_value)
import org.opensearch.action.support.replication.ClusterStateCreationUtils;
        setState(
        // set put-mapping task limit to 20
import static org.opensearch.test.ClusterServiceUtils.setState;  
        );
        );
        // check default value  
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
    public static void afterClass() {
        }, new ClusterManagerThrottlingStats());
    public void testValidateSettingGracefullyHandlesUnregisteredEnumKey() {  
        newSettings = Settings.builder().put("cluster_manager.throttling.retry.max.delay", maxDelay + "s").build();
    }  
                throttler.tasksCount.computeIfPresent(task.getKey(), (key, count) -> {
            @Override
                        throw new RuntimeException(e);
        int baseDelay = randomIntBetween(1, 10);
import org.opensearch.common.Priority;
import static org.opensearch.cluster.service.ClusterManagerTask.PUT_MAPPING;
        // adding 3 tasks
        );
        // adding 3 more tasks, these tasks should be throttled  
import org.opensearch.common.settings.Settings;
            @Override
        // As queue already have more tasks than threshold from previous call.
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
import java.util.ArrayList;
        throttler.updateLimit(task.getKey(), 5);  
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })  
            assertEquals(13L, throttlingStats.getThrottlingCount(task.getKey()));  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        int maxDelay = randomIntBetween(1, 10);
            return clusterService.getClusterManagerService().getMinNodeVersion();
import org.junit.AfterClass;
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = throttler.registerClusterManagerTask(task, false);  
                throttler.tasksCount.computeIfPresent(task.getKey(), (key, count) -> {  
            version  
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
            });
     * Verifies that validateSetting() gracefully handles a key that exists in the ClusterManagerTask  
                    return 10L;  
        // verify defaults
            "local_data_node",
        ClusterManagerTask task = CREATE_INDEX;  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        int baseDelay = randomIntBetween(1, 10);
        // adding 3 tasks
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
                    threadToLock.join();
     */
        );
            return clusterService.getClusterManagerService().getMinNodeVersion();  
            clusterService,
        // remove one task  
        clusterSettings.applySettings(newSettings);
    private static ThreadPool threadPool;
            () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3))
            return clusterService.getClusterManagerService().getMinNodeVersion();
    }
                    + "but is not registered. This would cause fatal node startup failures during upgrades "
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
                    throw new AssertionError(e);
        ClusterManagerTask task = CREATE_INDEX;
        }, new ClusterManagerThrottlingStats());
        setState(
        // set limit to null  
import org.opensearch.threadpool.TestThreadPool;
                if (!(e instanceof ClusterManagerThrottlingException)) {  
                return taskKey;  
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = throttler.registerClusterManagerTask(task, true);
package org.opensearch.cluster.service;
                    + "when cluster state contains persisted throttling settings for that key. Got: "  
    @Before
        Settings emptySettings = Settings.builder().build();
     */  
        // Validate a setting for the unregistered-but-enum-present key CREATE_INDEX.  
            clusterService,  
                    try {
        // taskCount in Queue: 3 Threshold: 5
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 1));
            @Override
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
        } catch (IllegalArgumentException e) {
            @Override
            ClusterManagerThrottlingException.class,
    }
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
        );
    @BeforeClass
import java.util.List;
        clusterSettings.applySettings(nullSettings);
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", newLimit).build();
                });
        Settings settingsWithUnregisteredKey = Settings.builder()  
                        ClusterManagerThrottlingException.class,  
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));
                try {
    ) {
                "validateSetting() should not throw for a key that exists in ClusterManagerTask enum "
            @Override
                        latch.await();
        }
        } catch (Exception e) {
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
        assertThrows(IllegalArgumentException.class, () -> throttler.validateSetting(THRESHOLD_SETTINGS.get(newSettings)));
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {  
    public void testDefaults() {
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey,  
 */
            // it shouldn't throw exception  
                        () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 1))
        }, new ClusterManagerThrottlingStats());
        clusterService.close();
     * log a warning and skip validation for that key.
        }, new ClusterManagerThrottlingStats());  
        // taskCount in Queue: 2 Threshold: 5
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
        );
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
        clusterSettings.applySettings(newSettings);  
        Settings initialSettings = Settings.builder()  
import java.util.concurrent.CountDownLatch;  
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
            clusterService,  
 */  
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));
        DiscoveryNode dataNode = getDataNode(Version.V_2_5_0);
        // taskCount in Queue: 3 Threshold: 5  
        );
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
            });  
    @After
        }, new ClusterManagerThrottlingStats());  
            // Taking lock on tasksCount will not impact throttling behaviour now.
    public void testUpdateThrottlingLimitForBasicSanity() {
        }
        setState(
                try {  
    }
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
    }
            clusterService,  
            return clusterService.getClusterManagerService().getMinNodeVersion();
                throw new RuntimeException(e);
        } finally {
    private DiscoveryNode getDataNode(Version version) {  
                    threadToLock.join();  
                Thread submittingThread = new Thread(() -> {
 * this file be licensed under the Apache-2.0 license or a
            return clusterService.getClusterManagerService().getMinNodeVersion();  
        // adding 10 tasks, should pass as throttling is disabled for task
        assertNull(throttler.getThrottlingLimit(PUT_MAPPING.getKey()));  
import static org.opensearch.cluster.service.ClusterManagerTask.CREATE_INDEX;  
        assertThrows(
        assertEquals(3L, throttlingStats.getThrottlingCount(task.getKey()));  
                    assertEquals("Throttling Exception : Limit exceeded for create-index", exception.getMessage());  
        final CountDownLatch latch = new CountDownLatch(1);  
    }  
    public void testUpdateRetryDelaySetting() {
    public void testUpdateLimit() {
                    assertEquals(Optional.of(5L).get(), throttler.tasksCount.get(task.getKey()));
                }
            () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3))
    public void tearDown() throws Exception {
            fail(  
        assertEquals(5L, throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
        throttler.updateLimit(PUT_MAPPING.getKey(), -1);
        throttler.updateLimit(task.getKey(), 5);
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);  
import org.junit.After;  
            public ClusterTasksResult<TaskBatcherTests.TestTaskBatcher.UpdateTask> execute(  
        assertThrows(IllegalArgumentException.class, () -> throttler.validateSetting(THRESHOLD_SETTINGS.get(newSettings)));
        }, new ClusterManagerThrottlingStats());
        assertEquals(Optional.of(10L).get(), throttler.tasksCount.get(task.getKey()));
                    // Wait to complete and then assert on new tasksCount that got modified by threadToLock Thread
        }, throttlingStats);
            .build();
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", newLimit).build();
        // adding one task will throttle
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
        clusterService = ClusterServiceUtils.createClusterService(threadPool);
            () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 1))  
/*  
    }  
        assertEquals(3L, throttlingStats.getThrottlingCount(task.getKey()));
        // Only register PUT_MAPPING — leave CREATE_INDEX unregistered to simulate a removed registration  
        // adding 3 tasks  
        int put_mapping_threshold_value = randomIntBetween(1, 10);  
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", -5).build();
}  
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
import static org.opensearch.cluster.service.ClusterManagerTaskThrottler.THRESHOLD_SETTINGS;
        assertThrows(
        // adding 3 more tasks, these tasks should be throttled
        assertEquals(baseDelay, ClusterManagerTaskThrottler.getBaseDelayForRetry().seconds());
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        assertThrows(
        super.setUp();  
        int maxDelay = randomIntBetween(1, 10);
        );  
        // add 3 tasks should pass now.
        // taskCount in Queue: 2 Threshold: 5
        // taskCount in Queue: 3 Threshold: 5
        Thread threadToLock = null;
        // remove one task
import org.junit.Before;
        throttler.onBeginProcessing(getMockUpdateTaskList(task.getKey(), throttlingKey, 1));
        try {  
    }  
                latch.countDown();  
    public static void beforeClass() {
        assertEquals(newLimit, throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());  
        // verify update base delay  
        // set some limit for put-mapping tasks
            ClusterManagerThrottlingException.class,
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3))  
        }
        // set some limit for put-mapping tasks
            threadToLock.start();
                latch2.await();
    }
            return clusterService.getClusterManagerService().getMinNodeVersion();  
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {  
        assertEquals(Optional.of(10L).get(), throttler.tasksCount.get(task.getKey()));  
                    throw new RuntimeException(e);  
        assertThrows(IllegalArgumentException.class, () -> throttler.validateSetting(THRESHOLD_SETTINGS.get(unknownSettings)));
        setState(
public class ClusterManagerTaskThrottlerTests extends OpenSearchTestCase {
        }  
    /**
        super.tearDown();  
        int put_mapping_threshold_value = randomIntBetween(1, 10);
            ClusterManagerThrottlingException.class,  
        TaskBatcherTests.TestTaskBatcher testTaskBatcher = new TaskBatcherTests.TestTaskBatcher(logger, null);  
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
            } catch (InterruptedException e) {  
            taskList.add(testTaskBatcher.new UpdateTask(Priority.HIGH, taskKey, taskKey, (source, e) -> {
            }, new MockExecutor()));  
import org.opensearch.cluster.node.DiscoveryNodeRole;
        for (String key : throttler.THROTTLING_TASK_KEYS.keySet()) {  
            }
 * SPDX-License-Identifier: Apache-2.0
            }
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);  
            public void clusterStatePublished(ClusterChangedEvent clusterChangedEvent) {}  
        throttler.onBeginProcessing(getMockUpdateTaskList(task.getKey(), throttlingKey, 1));  
        clusterSettings.applySettings(newSettings);
        try {  
import org.opensearch.common.settings.ClusterSettings;  
            ClusterManagerThrottlingException.class,
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
            final CountDownLatch latch2 = new CountDownLatch(10);  
import org.opensearch.cluster.node.DiscoveryNode;  
    public void testSettingsOnBootstrap() {  
            ) throws Exception {  
                    try {
        }, new ClusterManagerThrottlingStats());
        // taskCount in Queue: 5 Threshold: 5  
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
            return clusterService.getClusterManagerService().getMinNodeVersion();
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(Settings.EMPTY, clusterSettings, () -> {
            return clusterService.getClusterManagerService().getMinNodeVersion();  
import java.util.concurrent.TimeUnit;
import org.opensearch.cluster.ClusterState;
            throttler.validateSetting(THRESHOLD_SETTINGS.get(settingsWithUnregisteredKey));
        int newLimit = randomIntBetween(1, 10);  
    }
        }, throttlingStats);
            public String describeTasks(List tasks) {
            "local_master_node",  
                submittingThread.start();
    private DiscoveryNode getClusterManagerNode(Version version) {
        assertEquals(ClusterManagerTask.PUT_MAPPING.getThreshold(), throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
    private ClusterService clusterService;
        // remove one task
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            clusterService,
        String taskKey,
        );
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        );
        // set some limit for put-mapping tasks  
                return null;
            .put("cluster_manager.throttling.retry.base.delay", baseDelay + "s")
import org.opensearch.cluster.ClusterChangedEvent;  
            .build();
        assertEquals(ClusterManagerTask.PUT_MAPPING.getThreshold(), throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());  
        assertEquals(0L, throttlingStats.getThrottlingCount(task.getKey()));  
        // assert that delay setting is applied on throttler  
        DiscoveryNode dataNode = getDataNode(Version.V_2_0_0);
            }
                    }
        final IllegalArgumentException exception = assertThrows(
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })  
        int newLimit = randomIntBetween(1, 10);
            () -> throttler.registerClusterManagerTask(ClusterManagerTask.fromKey("random-task"), true)  
        throttler.updateLimit(task.getKey(), 5);
        assertEquals(newLimit, throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
        // verifying adding more tasks than threshold passes
            .build();
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode })
                submittingThreads.add(submittingThread);
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.retry.base.delay", baseDelay + "s").build();
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
                ClusterStateTaskExecutor<TaskBatcherTests.TestTaskBatcher.UpdateTask> {  
        setState(  
                // No Op
            return clusterService.getClusterManagerService().getMinNodeVersion();  
                    );
        newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.put-mapping.value", 20).build();  
import org.junit.BeforeClass;  
    }  
        // adding one task should pass now
        }, new ClusterManagerThrottlingStats());
        setState(
        ClusterManagerTaskThrottler throttler = new ClusterManagerTaskThrottler(initialSettings, clusterSettings, () -> {
        class MockExecutor  
import org.opensearch.cluster.ClusterStateTaskExecutor;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
                }  
        } finally {
        // add 3 tasks should pass now.
        assertEquals(ClusterManagerTaskThrottler.maxDelay, ClusterManagerTaskThrottler.getMaxDelayForRetry());
        throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 3));  
    public void testUpdateSettingsForNullValue() {
 *
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);
            buildNewFakeTransportAddress(),
     * refactor removes a registerClusterManagerTask() call but the key remains persisted in cluster
    }
                    } catch (InterruptedException e) {  
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
                    throw new RuntimeException(e);
            try {
    }  
    public void testThrottlingForInitialStaticSettingAndVersionCheck() {  
    public void testThrottlingWithLock() {
        assertEquals(20, throttler.getThrottlingLimit(PUT_MAPPING.getKey()).intValue());
        assertThrows(
    }
        int newLimit = randomIntBetween(1, 10);
            // taskCount in Queue: 5 Threshold: 5  
        }, throttlingStats);
        // assert that limit is applied on throttler
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode })  
                        throw new RuntimeException(e);
            assertEquals(ClusterManagerTask.fromKey(key).getThreshold(), throttler.getThrottlingLimit(key).intValue());
            IllegalArgumentException.class,
            clusterService,
    private List<TaskBatcherTests.TestTaskBatcher.UpdateTask> getMockUpdateTaskList(
        // update limit of threshold 6
                    latch2.countDown();
        throttler.registerClusterManagerTask(PUT_MAPPING, true);  
        int newLimit = randomIntBetween(1, 10);
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
                    + e.getMessage()
        }  
            Collections.emptyMap(),
    @AfterClass
        throttler.registerClusterManagerTask(PUT_MAPPING, false);
    public void testValidateSettingsForUnknownTask() {
        ClusterManagerThrottlingStats throttlingStats = new ClusterManagerThrottlingStats();
    }  
            clusterService,
        Settings newSettings = Settings.builder().put("cluster_manager.throttling.thresholds.random-task.value", newLimit).build();
        // Asserting that there was not any throttling for it
     * registered nor present in the ClusterManagerTask enum.
        // taskCount in Queue: 2 Threshold: 5  
                () -> throttler.onBeginSubmit(getMockUpdateTaskList(task.getKey(), throttlingKey, 1))  
        ClusterManagerThrottlingStats throttlingStats = new ClusterManagerThrottlingStats();  
            }  
        }, throttlingStats);  
        // validate for empty setting, it shouldn't throw exception
    }  
        assertEquals(maxDelay, ClusterManagerTaskThrottler.getMaxDelayForRetry().seconds());
                    submittingThread.join();
        throttler.updateLimit(task.getKey(), 6);
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        assertEquals(maxDelay, ClusterManagerTaskThrottler.getMaxDelayForRetry().seconds());
        setState(  
            () -> throttler.onBeginSubmit(getMockUpdateTaskList(PUT_MAPPING.getKey(), throttlingKey, 3))
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = throttler.registerClusterManagerTask(task, true);  
        assertEquals(Optional.of(10L).get(), throttler.tasksCount.get(task.getKey()));
        assertEquals(ClusterManagerTaskThrottler.baseDelay, ClusterManagerTaskThrottler.getBaseDelayForRetry());  
        ThreadPool.terminate(threadPool, 30, TimeUnit.SECONDS);  
            .put("cluster_manager.throttling.thresholds.create-index.value", 50)
            );
        clusterSettings.applySettings(newSettings);  
            clusterService,
        assertEquals(0L, throttlingStats.getThrottlingCount(PUT_MAPPING.getKey()));
        clusterSettings.applySettings(newSettings);  
                });
    public void testValidateSettingsForDifferentVersion() {
        throttler.updateLimit(task.getKey(), 5);  
import java.util.Collections;  
            return clusterService.getClusterManagerService().getMinNodeVersion();  
    public void testThrottlingWithMultipleOnBeginSubmitsThreadsWithLock() {
                    final ClusterManagerThrottlingException exception = assertThrows(
                        latch.await();  
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
        );
import org.opensearch.Version;
            ClusterStateCreationUtils.state(clusterManagerNode, clusterManagerNode, new DiscoveryNode[] { clusterManagerNode, dataNode })
            assertEquals(4L, throttlingStats.getThrottlingCount(task.getKey()));
                } catch (InterruptedException e) {
            clusterService,  
        try {  
        );
 * compatible open source license.
        }, new ClusterManagerThrottlingStats());
        threadPool = null;
        assertThrows(  
                ClusterState currentState,
            throw new AssertionError(e);
        setState(
    @Override  
            public ClusterManagerTaskThrottler.ThrottlingKey getClusterManagerThrottlingKey() {  
                    }  
            final ClusterManagerThrottlingException exception = assertThrows(
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
        int size
 * The OpenSearch Contributors require contributions made to  
        assertThrows(IllegalArgumentException.class, () -> throttler.validateSetting(THRESHOLD_SETTINGS.get(newSettings)));
        // This should NOT throw — it should log a warning and skip, because the key
            .put("cluster_manager.throttling.retry.max.delay", maxDelay + "s")  
            return clusterService.getClusterManagerService().getMinNodeVersion();  
                ClusterManagerThrottlingException.class,
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        // exists in the ClusterManagerTask enum (indicating it was once valid).
        ClusterSettings clusterSettings = new ClusterSettings(Settings.builder().build(), ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        ClusterManagerTaskThrottler.ThrottlingKey throttlingKey = throttler.registerClusterManagerTask(PUT_MAPPING, true);  
                    } catch (InterruptedException e) {
            }
    public void testThrottlingForDisabledThrottlingTask() {
        // set some limit for put-mapping tasks
        setState(
        List<Thread> submittingThreads = new ArrayList<>();
            implements
            return clusterService.getClusterManagerService().getMinNodeVersion();
        // adding limit directly in thresholds
        ClusterManagerThrottlingStats throttlingStats = new ClusterManagerThrottlingStats();  
        DiscoveryNode clusterManagerNode = getClusterManagerNode(Version.V_2_5_0);  
        threadPool = new TestThreadPool("TransportMasterNodeActionTests");  
        throttler.registerClusterManagerTask(PUT_MAPPING, true);
                } catch (InterruptedException e) {
     * state from prior versions. Instead of a fatal IllegalArgumentException, the method should  
    }  
