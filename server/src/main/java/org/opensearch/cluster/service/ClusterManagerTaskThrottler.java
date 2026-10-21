    }
                    ClusterManagerTask.fromKey(key);
     * To configure a new task for throttling,
            // if throttling is ongoing for a specific task
        }
        Setting.Property.NodeScope
    static volatile TimeValue maxDelay = TimeValue.timeValueSeconds(30);
            tasksCount.putIfAbsent(taskThrottlingKey, 0L);
    private final int MIN_THRESHOLD_VALUE = -1; // Disabled throttling
 * e.g : Set "cluster_manager.throttling.thresholds.put_mapping" to set throttling limit of "put mapping" tasks,
import java.util.List;
        }
                );
     * * Verify that throttled tasks would be retried from data nodes
        ThrottlingKey throttlingKey = new ThrottlingKey(task.getKey(), throttlingEnabled);
        }
        }
            } else {
            });
         * @param throttlingEnabled - if throttling is enabled or not i.e. data node is performing retry over throttling exception or not.
import org.opensearch.common.unit.TimeValue;
        return baseDelay;
import java.util.HashSet;
    public ClusterManagerTaskThrottler(
        Setting.Property.Dynamic,
    public void onBeginProcessing(List<? extends TaskBatcher.BatchedTask> tasks) {
    private void failFastWhenThrottlingThresholdsAreAlreadyBreached(
    void updateLimit(final String taskKey, final int limit) {
                tasksCount.get(taskThrottlingKey),
    ) {
        for (String key : settingKeys) {
        private String taskThrottlingKey;
        if (throttlingEnabledWithThreshold && shouldThrottle(threshold, existingTaskCount, incomingTaskCount)) {
     * * override getClusterManagerThrottlingKey method with above task key in task executor.
    private void reduceTaskCount(List<? extends TaskBatcher.BatchedTask> tasks) {
                logger.info("Skipping cluster manager throttling as at least one node < 2.5.0 is present in cluster");
     * <p>
            throw e;
        final Long threshold = getThrottlingLimit(taskThrottlingKey);
        "cluster_manager.throttling.retry.base.delay",
            this.throttlingEnabled = throttlingEnabled;
        final String taskThrottlingKey
    }
        String masterTaskKey = ((ClusterStateTaskExecutor<Object>) tasks.get(0).batchingKey).getClusterManagerThrottlingKey()
        /**
            if (!THROTTLING_TASK_KEYS.get(key).isThrottlingEnabled()) {
                        "Throttling key [{}] exists in ClusterManagerTask enum but is not registered. "
        if (groups.size() > 0) {
    @Override
            tasksThreshold.put(task.getKey(), (long) task.getThreshold());
    /**
        this.clusterManagerTaskThrottlerListener = clusterManagerTaskThrottlerListener;
                    throw new IllegalArgumentException("Cluster manager task throttling is not configured for given task type: " + key);
     * @param tasks list of tasks which will be executed.
        clusterSettings.addSettingsUpdateConsumer(THRESHOLD_SETTINGS, this::updateSetting, this::validateSetting);
    private AtomicBoolean startThrottling = new AtomicBoolean();
    // This is needed specifically for static setting to enable throttling.
import org.opensearch.Version;
     * It may start throwing throttling exception to older nodes in cluster.
    /**
            if (minNodeVersionSupplier.get().compareTo(Version.V_2_5_0) >= 0) {
                            + "This may indicate a missing registerClusterManagerTask() call.",
                    incomingTaskCount,
            }
                incomingTaskCount,
        clusterSettings.addSettingsUpdateConsumer(MAX_DELAY_SETTINGS, this::updateMaxDelay);
        "cluster_manager.throttling.thresholds.",
        reduceTaskCount(tasks);
import java.util.Objects;
    }
 */
        if (THROTTLING_TASK_KEYS.containsKey(task.getKey())) {
        final ThrottlingKey clusterManagerThrottlingKey = ((ClusterStateTaskExecutor<Object>) tasks.get(0).batchingKey)
import java.util.concurrent.atomic.AtomicBoolean;
        Set<String> settingKeys = new HashSet<>();
        reduceTaskCount(tasks);
 * this file be licensed under the Apache-2.0 license or a
                        key
        tasksThreshold = new ConcurrentHashMap<>(128); // setting initial capacity so each task will land in different segment
            updateLimit(key, setting == null ? defaultThreshold : setting.getAsInt("value", defaultThreshold));
    }
                startThrottling.compareAndSet(false, true);
 * <p>
        tasksCount = new ConcurrentHashMap<>(128); // setting initial capacity so each task will land in different segment
import org.opensearch.common.settings.Setting;
import org.opensearch.cluster.ClusterStateTaskExecutor;
    );
                    existingTaskCount,
     * Tasks will be removed from the queue before processing, so here we will reduce the count of tasks.
        settingKeys.addAll(groups.keySet());
        // Required for setting values as per current settings during node bootstrap
    public static TimeValue getBaseDelayForRetry() {
     * Class to store the throttling key for the tasks of cluster manager
            );
        final long existingTaskCount,
     * If throttling thresholds are set via static setting, it will update the threshold map.
 * <p>
         * @param taskThrottlingKey - throttling key for task
                            + "Skipping validation for this persisted setting. "
    public static final Setting<TimeValue> BASE_DELAY_SETTINGS = Setting.timeSetting(
                }
    final ConcurrentMap<String, Long> tasksCount;
    );
    @Override
    @PublicApi(since = "1.0.0")
     * Added retry mechanism in TransportClusterManagerNodeAction, so it would be retried for customer generated tasks.
                "Throwing Throttling Exception for [{}]. Trying to add [{}] tasks to queue, limit is set to [{}]",
            logger.trace(
        }
     * Older version nodes will not be equipped to handle the throttling exception and
    }
            .getClusterManagerThrottlingKey();
                isThrottlingEnabledWithThreshold,
        tasksCount.computeIfPresent(masterTaskKey, (key, count) -> count - tasks.size());
    void updateBaseDelay(TimeValue newBaseValue) {
    public static final ThrottlingKey DEFAULT_THROTTLING_KEY = new ThrottlingKey("default-task-key", false);
            );
    private final ConcurrentMap<String, Long> tasksThreshold;
        for (String key : groups.keySet()) {
 * <p>
    Long getThrottlingLimit(final String taskKey) {
    void validateSetting(final Settings settings) {
    }
 * This class does throttling on task submission to cluster manager node, it uses throttling key defined in various executors
        if (!startThrottling.get()) {
    }
        assert limit >= MIN_THRESHOLD_VALUE;
    }
 * compatible open source license.
            tasksThreshold.remove(taskKey);
    }
    @Override
            int threshold = groups.get(key).getAsInt("value", ClusterManagerTask.fromKey(key).getThreshold());
                    threshold,
        private boolean throttlingEnabled;
                    taskThrottlingKey
        if (limit == MIN_THRESHOLD_VALUE) {
    }
                    logger.warn(
            clusterManagerTaskThrottlerListener.onThrottle(taskThrottlingKey, incomingTaskCount);
    /**
        maxDelay,
    }
     * If tasks are not getting retried then we can register with false flag, so user won't be able to configure threshold limits for it.
    void updateMaxDelay(TimeValue newMaxValue) {
/*
            tasksCount.computeIfPresent(taskThrottlingKey, (key, existingTaskCount) -> {
            // Perform shallow check before acquiring lock to avoid blocking of network threads
 * The OpenSearch Contributors require contributions made to
        Setting.Property.Dynamic,
                try {
            failFastWhenThrottlingThresholdsAreAlreadyBreached(
            if (threshold < MIN_THRESHOLD_VALUE) {
                // instead of throwing a fatal exception that would prevent node startup during upgrades.
                taskThrottlingKey,
    }
            throw new ClusterManagerThrottlingException("Throttling Exception : Limit exceeded for " + taskThrottlingKey);
}
    }
        return maxDelay;
import org.opensearch.common.annotation.PublicApi;
import java.util.Set;
            return throttlingEnabled;
        final int incomingTaskCount,
         */
        return tasksThreshold.get(taskKey);
     *
        }
    );
     * Once the startThrottling flag is set, it will not perform check for next set of tasks.
     */
        Setting.Property.NodeScope
    void updateSetting(final Settings newSettings) {
        maxDelay = newMaxValue;
        public String getTaskThrottlingKey() {
            this.taskThrottlingKey = taskThrottlingKey;
        clusterSettings.addSettingsUpdateConsumer(BASE_DELAY_SETTINGS, this::updateBaseDelay);
                incomingTaskCount,
 * as key for throttling. Throttling will be performed over task executor's class level, different task types have different executors class.
        final boolean isThrottlingEnabledWithThreshold = clusterManagerThrottlingKey.isThrottlingEnabled() && threshold != null;
                    // Key is not in the enum either — this is a genuinely unknown task type
    private boolean shouldThrottle(Long threshold, Long count, int size) {
        final String taskThrottlingKey = clusterManagerThrottlingKey.getTaskThrottlingKey();
        }
    public static final Setting<Settings> THRESHOLD_SETTINGS = Setting.groupSetting(
            tasksThreshold.put(taskKey, (long) limit);
    // default value for base delay is 5s
                throw new IllegalArgumentException("Throttling is not enabled for given task type: " + key);
            }
    }
        updateMaxDelay(MAX_DELAY_SETTINGS.get(settings));
    }
                // may still contain throttling thresholds for this key. Log a warning and skip validation
            if (!THROTTLING_TASK_KEYS.containsKey(key)) {
        // Adding existing keys that may need to be set to a default value if that is removed in new setting.
            int defaultThreshold = ClusterManagerTask.fromKey(key).getThreshold();
import java.util.function.Supplier;
 * Set specific setting for setting the threshold of throttling of a particular task type.
        }
     * <p>
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
    @Override
    public void onSubmitFailure(List<? extends TaskBatcher.BatchedTask> tasks) {
     * If throttling is enabled, default threshold based on task type will be used if not specified in settings.
        updateBaseDelay(BASE_DELAY_SETTINGS.get(settings));
import org.apache.logging.log4j.Logger;
    }
package org.opensearch.cluster.service;
            .getTaskThrottlingKey();
                } catch (IllegalArgumentException e) {
    // During upgrade as well, it will wait for all older version nodes to leave the cluster before starting throttling.
        }
    private final Supplier<Version> minNodeVersionSupplier;
        final boolean throttlingEnabledWithThreshold,
                threshold,
        baseDelay = newBaseValue;
        }
        try {
    protected Map<String, ThrottlingKey> THROTTLING_TASK_KEYS = new ConcurrentHashMap<>();
    }
            throw new IllegalArgumentException("There is already a Throttling key registered with same name: " + task.getKey());
        reduceTaskCount(tasks);
        baseDelay,
        final Settings settings,
                taskThrottlingKey
import org.apache.logging.log4j.LogManager;
import org.opensearch.common.settings.Settings;
 * Set it to (-1) to disable the throttling for this task type.
                    );
     */
    protected ThrottlingKey registerClusterManagerTask(ClusterManagerTask task, boolean throttlingEnabled) {
/**
 */
    public static final Setting<TimeValue> MAX_DELAY_SETTINGS = Setting.timeSetting(
        Setting.Property.Dynamic,
            return taskThrottlingKey;
            Settings setting = groups.get(key);
     */
                logger.info("Starting cluster manager throttling as all nodes are higher than or equal to 2.5.0");
        // Adding keys which are present in new Setting
     * * Register task to cluster service with task key,
    static volatile TimeValue baseDelay = TimeValue.timeValueSeconds(5);
    // default values for max delay is 30s
        } catch (final ClusterManagerThrottlingException e) {
     * <p>
    /**
         * Class for throttling key of tasks
        THROTTLING_TASK_KEYS.put(task.getKey(), throttlingKey);
                // whose registration was removed during a refactor. Persisted cluster state from prior versions
                    continue;
    public void onTimeout(List<? extends TaskBatcher.BatchedTask> tasks) {
                throw new IllegalArgumentException("Provide positive integer for limit or -1 for disabling throttling");
        public boolean isThrottlingEnabled() {
    public void onBeginSubmit(List<? extends TaskBatcher.BatchedTask> tasks) {
        if (throttlingEnabled && Objects.isNull(getThrottlingLimit(task.getKey()))) {
                    isThrottlingEnabledWithThreshold,
     * <p>
    }
                throw new IllegalArgumentException("All the nodes in cluster should be on version later than or equal to 2.5.0");
        }
        final ClusterManagerTaskThrottlerListener clusterManagerTaskThrottlerListener
     */
        settingKeys.addAll(tasksThreshold.keySet());
 * All tasks must have a default threshold configured in {@link ClusterManagerTask}.
            if (minNodeVersionSupplier.get().compareTo(Version.V_2_5_0) < 0) {
        private ThrottlingKey(String taskThrottlingKey, boolean throttlingEnabled) {
        this.minNodeVersionSupplier = minNodeVersionSupplier;
        updateSetting(THRESHOLD_SETTINGS.get(settings));
    private final ClusterManagerTaskThrottlerListener clusterManagerTaskThrottlerListener;
import org.opensearch.common.settings.ClusterSettings;
    public static TimeValue getMaxDelayForRetry() {
                return false;
            }
import java.util.concurrent.ConcurrentHashMap;
        "cluster_manager.throttling.retry.max.delay",
    // Once all nodes are greater than or equal 2.5.0 version, then only it will start throttling.
        final ClusterSettings clusterSettings,
        return throttlingKey;
    private static final Logger logger = LogManager.getLogger(ClusterManagerTaskThrottler.class);
            }
    ) {
        Setting.Property.NodeScope
        int incomingTaskCount = tasks.size();
    public static class ThrottlingKey {
                threshold
     *
        Map<String, Settings> groups = newSettings.getAsGroups();
     * @opensearch.api
                // If the key exists in the ClusterManagerTask enum, it was previously a valid registered task
                failFastWhenThrottlingThresholdsAreAlreadyBreached(
            }
         *
                return existingTaskCount + incomingTaskCount;
public class ClusterManagerTaskThrottler implements TaskBatcherListener {
        }
     * For every task submission request, it will validate if nodes version is greater or equal to 2.5.0 and set the startThrottling flag.
        Map<String, Settings> groups = settings.getAsGroups();
import java.util.concurrent.ConcurrentMap;
        return count + size > threshold;
        final Long threshold,
 *
        } else {
     * this may result in unexpected behavior where internal tasks would start failing without any retries.
        final Supplier<Version> minNodeVersionSupplier,
