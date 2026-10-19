    private final Supplier<Version> minNodeVersionSupplier;
    protected Map<String, ThrottlingKey> THROTTLING_TASK_KEYS = new ConcurrentHashMap<>();
            Settings setting = groups.get(key);  
        final long existingTaskCount,
     * It may start throwing throttling exception to older nodes in cluster.
import org.opensearch.common.settings.ClusterSettings;  
     * <p>
            this.throttlingEnabled = throttlingEnabled;  
        maxDelay = newMaxValue;  
 * as key for throttling. Throttling will be performed over task executor's class level, different task types have different executors class.
                    );
import java.util.Set;  
    public void onBeginSubmit(List<? extends TaskBatcher.BatchedTask> tasks) {
                tasksCount.get(taskThrottlingKey),
 * <p>
        Setting.Property.NodeScope
     * <p>  
        final ThrottlingKey clusterManagerThrottlingKey = ((ClusterStateTaskExecutor<Object>) tasks.get(0).batchingKey)  
/*  
            // if throttling is ongoing for a specific task
    );
        // Adding existing keys that may need to be set to a default value if that is removed in new setting.  
            if (!THROTTLING_TASK_KEYS.get(key).isThrottlingEnabled()) {  
            }
        return count + size > threshold;  
        }
        if (groups.size() > 0) {
    }
     * @param tasks list of tasks which will be executed.
        reduceTaskCount(tasks);
    @Override
                failFastWhenThrottlingThresholdsAreAlreadyBreached(
        settingKeys.addAll(groups.keySet());
import java.util.HashSet;
 * compatible open source license.
        }  
                taskThrottlingKey
        // Required for setting values as per current settings during node bootstrap
            }  
        updateMaxDelay(MAX_DELAY_SETTINGS.get(settings));
            tasksCount.putIfAbsent(taskThrottlingKey, 0L);
    /**  
     * Tasks will be removed from the queue before processing, so here we will reduce the count of tasks.  
        baseDelay,
            return throttlingEnabled;
        assert limit >= MIN_THRESHOLD_VALUE;
    private AtomicBoolean startThrottling = new AtomicBoolean();
     * Class to store the throttling key for the tasks of cluster manager
        Map<String, Settings> groups = newSettings.getAsGroups();
    public static final Setting<TimeValue> MAX_DELAY_SETTINGS = Setting.timeSetting(  
        }  
    private boolean shouldThrottle(Long threshold, Long count, int size) {
        final int incomingTaskCount,
    protected ThrottlingKey registerClusterManagerTask(ClusterManagerTask task, boolean throttlingEnabled) {
            throw e;
     * For every task submission request, it will validate if nodes version is greater or equal to 2.5.0 and set the startThrottling flag.
        reduceTaskCount(tasks);  
    // default value for base delay is 5s  
        return baseDelay;
import org.apache.logging.log4j.Logger;
    }
        this.clusterManagerTaskThrottlerListener = clusterManagerTaskThrottlerListener;  
    );  
        private ThrottlingKey(String taskThrottlingKey, boolean throttlingEnabled) {
        tasksCount = new ConcurrentHashMap<>(128); // setting initial capacity so each task will land in different segment  
                            + "This may indicate a missing registerClusterManagerTask() call.",  
package org.opensearch.cluster.service;
    }  
                    ClusterManagerTask.fromKey(key);
    private final int MIN_THRESHOLD_VALUE = -1; // Disabled throttling  
                logger.info("Starting cluster manager throttling as all nodes are higher than or equal to 2.5.0");  
     */  
            }
 * All tasks must have a default threshold configured in {@link ClusterManagerTask}.  
     * If throttling thresholds are set via static setting, it will update the threshold map.  
            clusterManagerTaskThrottlerListener.onThrottle(taskThrottlingKey, incomingTaskCount);  
    @Override  
        }
        final String taskThrottlingKey  
                // whose registration was removed during a refactor. Persisted cluster state from prior versions
         */  
    public void onTimeout(List<? extends TaskBatcher.BatchedTask> tasks) {
                // instead of throwing a fatal exception that would prevent node startup during upgrades.  
        }
    final ConcurrentMap<String, Long> tasksCount;  
     * * override getClusterManagerThrottlingKey method with above task key in task executor.
 * e.g : Set "cluster_manager.throttling.thresholds.put_mapping" to set throttling limit of "put mapping" tasks,
                threshold,
                    continue;  
            failFastWhenThrottlingThresholdsAreAlreadyBreached(
    void updateLimit(final String taskKey, final int limit) {  
            throw new IllegalArgumentException("There is already a Throttling key registered with same name: " + task.getKey());
         * Class for throttling key of tasks
                "Throwing Throttling Exception for [{}]. Trying to add [{}] tasks to queue, limit is set to [{}]",
    public ClusterManagerTaskThrottler(  
        return throttlingKey;  
    }
        Setting.Property.NodeScope  
    public static final Setting<Settings> THRESHOLD_SETTINGS = Setting.groupSetting(
            if (minNodeVersionSupplier.get().compareTo(Version.V_2_5_0) >= 0) {
    private void failFastWhenThrottlingThresholdsAreAlreadyBreached(
            if (!THROTTLING_TASK_KEYS.containsKey(key)) {
        baseDelay = newBaseValue;
public class ClusterManagerTaskThrottler implements TaskBatcherListener {
        String masterTaskKey = ((ClusterStateTaskExecutor<Object>) tasks.get(0).batchingKey).getClusterManagerThrottlingKey()  
        "cluster_manager.throttling.thresholds.",  
            );  
            tasksThreshold.put(task.getKey(), (long) task.getThreshold());
        if (throttlingEnabled && Objects.isNull(getThrottlingLimit(task.getKey()))) {  
import java.util.concurrent.ConcurrentHashMap;
    private final ClusterManagerTaskThrottlerListener clusterManagerTaskThrottlerListener;
            tasksThreshold.put(taskKey, (long) limit);
import org.opensearch.common.settings.Settings;
        Setting.Property.Dynamic,  
            tasksCount.computeIfPresent(taskThrottlingKey, (key, existingTaskCount) -> {
        int incomingTaskCount = tasks.size();
    void updateSetting(final Settings newSettings) {
        THROTTLING_TASK_KEYS.put(task.getKey(), throttlingKey);
                isThrottlingEnabledWithThreshold,  
        final Supplier<Version> minNodeVersionSupplier,  
 * This class does throttling on task submission to cluster manager node, it uses throttling key defined in various executors
        /**
                taskThrottlingKey,  
    /**
                    throw new IllegalArgumentException("Cluster manager task throttling is not configured for given task type: " + key);  
        Map<String, Settings> groups = settings.getAsGroups();
 * SPDX-License-Identifier: Apache-2.0
        }
                }
                return false;  
    void updateBaseDelay(TimeValue newBaseValue) {
    }
    /**
        Setting.Property.Dynamic,
     * Added retry mechanism in TransportClusterManagerNodeAction, so it would be retried for customer generated tasks.
    @Override  
        final Long threshold = getThrottlingLimit(taskThrottlingKey);  
     */
     * <p>
            int defaultThreshold = ClusterManagerTask.fromKey(key).getThreshold();
        return maxDelay;
    }
     * * Verify that throttled tasks would be retried from data nodes  
        updateBaseDelay(BASE_DELAY_SETTINGS.get(settings));  
        final boolean isThrottlingEnabledWithThreshold = clusterManagerThrottlingKey.isThrottlingEnabled() && threshold != null;
            if (minNodeVersionSupplier.get().compareTo(Version.V_2_5_0) < 0) {  
    private void reduceTaskCount(List<? extends TaskBatcher.BatchedTask> tasks) {
    }
    void updateMaxDelay(TimeValue newMaxValue) {
/**  
        final Long threshold,  
                    // Key is not in the enum either — this is a genuinely unknown task type
        tasksCount.computeIfPresent(masterTaskKey, (key, count) -> count - tasks.size());
                // may still contain throttling thresholds for this key. Log a warning and skip validation
        clusterSettings.addSettingsUpdateConsumer(THRESHOLD_SETTINGS, this::updateSetting, this::validateSetting);
    }  
     * To configure a new task for throttling,  
    }
import java.util.concurrent.atomic.AtomicBoolean;  
    ) {
import org.opensearch.Version;  
        }
import java.util.Map;
    public static class ThrottlingKey {  
}
    public static final Setting<TimeValue> BASE_DELAY_SETTINGS = Setting.timeSetting(
        public String getTaskThrottlingKey() {  
import org.opensearch.common.settings.Setting;
    ) {
        final boolean throttlingEnabledWithThreshold,
        maxDelay,
                    logger.warn(  
        public boolean isThrottlingEnabled() {
            } else {
        if (throttlingEnabledWithThreshold && shouldThrottle(threshold, existingTaskCount, incomingTaskCount)) {
        try {
        if (!startThrottling.get()) {  
        "cluster_manager.throttling.retry.base.delay",  
import org.opensearch.common.annotation.PublicApi;
         * @param throttlingEnabled - if throttling is enabled or not i.e. data node is performing retry over throttling exception or not.
        tasksThreshold = new ConcurrentHashMap<>(128); // setting initial capacity so each task will land in different segment
     * Once the startThrottling flag is set, it will not perform check for next set of tasks.  
 * Set specific setting for setting the threshold of throttling of a particular task type.
     * Older version nodes will not be equipped to handle the throttling exception and
            if (threshold < MIN_THRESHOLD_VALUE) {
            logger.trace(
    void validateSetting(final Settings settings) {  
import org.apache.logging.log4j.LogManager;
        Setting.Property.Dynamic,
import java.util.Objects;
    // During upgrade as well, it will wait for all older version nodes to leave the cluster before starting throttling.
            .getClusterManagerThrottlingKey();
    // This is needed specifically for static setting to enable throttling.  
                        key
        private String taskThrottlingKey;
        Setting.Property.NodeScope
     * this may result in unexpected behavior where internal tasks would start failing without any retries.  
                // If the key exists in the ClusterManagerTask enum, it was previously a valid registered task  
        "cluster_manager.throttling.retry.max.delay",
import java.util.concurrent.ConcurrentMap;
                return existingTaskCount + incomingTaskCount;  
 */  
    }  
    public static TimeValue getMaxDelayForRetry() {
        }  
                    taskThrottlingKey
    }
    }  
            // Perform shallow check before acquiring lock to avoid blocking of network threads  
                throw new IllegalArgumentException("Throttling is not enabled for given task type: " + key);
        } else {
import java.util.function.Supplier;
            throw new ClusterManagerThrottlingException("Throttling Exception : Limit exceeded for " + taskThrottlingKey);  
import org.opensearch.cluster.ClusterStateTaskExecutor;
        this.minNodeVersionSupplier = minNodeVersionSupplier;
                incomingTaskCount,  
 * The OpenSearch Contributors require contributions made to  
 * <p>  
    public void onSubmitFailure(List<? extends TaskBatcher.BatchedTask> tasks) {
        settingKeys.addAll(tasksThreshold.keySet());
        }
                    isThrottlingEnabledWithThreshold,  
            }
    /**
     */
                    existingTaskCount,
            updateLimit(key, setting == null ? defaultThreshold : setting.getAsInt("value", defaultThreshold));
        }  
    Long getThrottlingLimit(final String taskKey) {  
        final ClusterManagerTaskThrottlerListener clusterManagerTaskThrottlerListener
    }  
                throw new IllegalArgumentException("All the nodes in cluster should be on version later than or equal to 2.5.0");
        private boolean throttlingEnabled;
        }  
     * If throttling is enabled, default threshold based on task type will be used if not specified in settings.  
                } catch (IllegalArgumentException e) {
    // Once all nodes are greater than or equal 2.5.0 version, then only it will start throttling.
         *  
        } catch (final ClusterManagerThrottlingException e) {
        ThrottlingKey throttlingKey = new ThrottlingKey(task.getKey(), throttlingEnabled);  
     * * Register task to cluster service with task key,
                    incomingTaskCount,  
 * <p>  
                try {
        return tasksThreshold.get(taskKey);
    }
    @PublicApi(since = "1.0.0")
                    threshold,
                throw new IllegalArgumentException("Provide positive integer for limit or -1 for disabling throttling");
 *
            }
     *
     *
            return taskThrottlingKey;
    // default values for max delay is 30s
 * this file be licensed under the Apache-2.0 license or a
                threshold
            int threshold = groups.get(key).getAsInt("value", ClusterManagerTask.fromKey(key).getThreshold());  
    );
        if (THROTTLING_TASK_KEYS.containsKey(task.getKey())) {
        final String taskThrottlingKey = clusterManagerThrottlingKey.getTaskThrottlingKey();
                );
        // Adding keys which are present in new Setting
        final ClusterSettings clusterSettings,
    static volatile TimeValue baseDelay = TimeValue.timeValueSeconds(5);
            });
                logger.info("Skipping cluster manager throttling as at least one node < 2.5.0 is present in cluster");
    @Override
         * @param taskThrottlingKey - throttling key for task
    }
    }
                            + "Skipping validation for this persisted setting. "
    }
        if (limit == MIN_THRESHOLD_VALUE) {
            tasksThreshold.remove(taskKey);  
        for (String key : settingKeys) {
     * <p>
                incomingTaskCount,
                startThrottling.compareAndSet(false, true);
 */
    private static final Logger logger = LogManager.getLogger(ClusterManagerTaskThrottler.class);  
import org.opensearch.common.unit.TimeValue;  
    public static final ThrottlingKey DEFAULT_THROTTLING_KEY = new ThrottlingKey("default-task-key", false);
        }
                        "Throttling key [{}] exists in ClusterManagerTask enum but is not registered. "
        for (String key : groups.keySet()) {
     * @opensearch.api  
        clusterSettings.addSettingsUpdateConsumer(MAX_DELAY_SETTINGS, this::updateMaxDelay);  
     */
        clusterSettings.addSettingsUpdateConsumer(BASE_DELAY_SETTINGS, this::updateBaseDelay);
    }  
    public static TimeValue getBaseDelayForRetry() {  
import java.util.List;  
            this.taskThrottlingKey = taskThrottlingKey;
            .getTaskThrottlingKey();
    public void onBeginProcessing(List<? extends TaskBatcher.BatchedTask> tasks) {
 * Set it to (-1) to disable the throttling for this task type.
            );
     * If tasks are not getting retried then we can register with false flag, so user won't be able to configure threshold limits for it.
    private final ConcurrentMap<String, Long> tasksThreshold;
        updateSetting(THRESHOLD_SETTINGS.get(settings));
        final Settings settings,
        Set<String> settingKeys = new HashSet<>();  
    static volatile TimeValue maxDelay = TimeValue.timeValueSeconds(30);  
        reduceTaskCount(tasks);
