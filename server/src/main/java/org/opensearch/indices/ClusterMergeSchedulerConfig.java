import java.util.List;
    private void validateMaxThreadAndMergeCount(Settings settings) {
import org.opensearch.index.MergeSchedulerConfig;
    private volatile int clusterMaxMergeCount;
 *
package org.opensearch.indices;
    }
 * <ol>
import org.opensearch.cluster.service.ClusterService;
                this::setClusterMaxThreadAndMergeCount,
        "cluster.index.merge.scheduler.max_thread_count",
 *   <li><b>Index Level</b> (highest priority) - {@link MergeSchedulerConfig#MAX_MERGE_COUNT_SETTING}
 *     <td>Absolute defaults (CPU-based calculation)</td>
    private final IndicesService indicesService;
            CLUSTER_MAX_MERGE_COUNT_SETTING.get(settings)
 * You can't have more threads than allowed merges.
    private void setClusterMaxThreadAndMergeCount(Settings settings) {
        // Cluster level validation - assert CLUSTER_DEFAULT_MAX_MERGE_COUNT_SETTING >= CLUSTER_DEFAULT_MAX_THREAD_COUNT_SETTING
    public Integer getClusterMaxThreadCount() {
}
 * Configuration manager for merge scheduler settings.
 *   <tr>
        if (NODE_PROCESSORS_SETTING.exists(settings) || clusterMaxThreadCountDefault == null) {
 *     <td>Not set</td>
        Property.Dynamic,
            indexService.onDefaultAutoThrottleEnabledUpdate(clusterAutoThrottleEnabled);
 *       and {@link #CLUSTER_MAX_THREAD_COUNT_SETTING}</li>
 *     <td>Doesn't matter</td>
 * Settings are applied in this order (prioritized highest to lowest):
 *   <tr>
 * compatible open source license.
        Property.NodeScope
 * <caption>Settings hierarchy and fallback behavior for merge scheduler configuration</caption>
 *   <li><b>Absolute Default</b> (fallback) - Calculated automatically based on your CPU cores </li>
 * SPDX-License-Identifier: Apache-2.0
 * These determine how many merge operations can run simultaneously and how many threads handle merging.
 *     <th>Index Setting</th>
 *     <td>Not set</td>
 *
        Property.NodeScope
            CLUSTER_MAX_THREAD_COUNT_SETTING.get(settings),
 *     <td>Both use your values (if valid)</td>
 *     <td>Only merge count</td>
 *
     */
        clusterMaxMergeCount = CLUSTER_MAX_MERGE_COUNT_SETTING.get(settings);
/*
        clusterAutoThrottleEnabled = CLUSTER_AUTO_THROTTLE_SETTING.get(clusterSettings);
        ClusterMergeSchedulerConfig::getClusterMaxThreadCountDefault,
     * Default value for {@code CLUSTER_DEFAULT_MAX_THREAD_COUNT_SETTING}
        return this.clusterMaxMergeCount;
        for (IndexService indexService : indicesService) {
    }
 *     <td>Doesn't matter</td>
 * <h2>Examples</h2>
 *   <tr>
        Settings clusterSettings = clusterService.getSettings();
    public static String getClusterMaxThreadCountDefault(Settings settings) {
        // settings received here have already been validated using
                this::validateMaxThreadAndMergeCount
    public Boolean getClusterMergeAutoThrottleEnabled() {
    public static final Setting<Integer> CLUSTER_MAX_THREAD_COUNT_SETTING = new Setting<>(
        return this.clusterMaxThreadCount;
    public Integer getClusterMaxMergeCount() {
    }
    public static final Setting<Boolean> CLUSTER_AUTO_THROTTLE_SETTING = Setting.boolSetting(
        clusterAutoThrottleEnabled = value;
 *     <th>Result</th>
 *     <td>Cluster defaults</td>
@ExperimentalApi
        clusterService.getClusterSettings()
 *
        return clusterMaxThreadCountDefault;
     */
    }
 * </ol>
        ClusterMergeSchedulerConfig::getClusterMaxMergeCountDefault,
        "cluster.index.merge.scheduler.max_merge_count",
 */
        DEFAULT_AUTO_THROTTLE,
        "cluster.index.merge.scheduler.auto_throttle",
 *   </tr>
 * <h2>The One Rule</h2>
     * Default value for {@code CLUSTER_DEFAULT_MAX_MERGE_COUNT_SETTING}
        clusterMaxMergeCount = CLUSTER_MAX_MERGE_COUNT_SETTING.get(clusterSettings);
 * The OpenSearch Contributors require contributions made to
        return Integer.toString(CLUSTER_MAX_THREAD_COUNT_SETTING.get(settings) + 5);
 *     <td>Doesn't matter</td>
 *   <li><b>Cluster Level</b> (middle priority) - {@link #CLUSTER_MAX_MERGE_COUNT_SETTING}
        (s) -> Setting.parseInt(s, 1, "cluster.default.index.merge.scheduler.max_thread_count"),
 *   </tr>
 *
 *     <td>Merge count = your value, Thread count = absolute default</td>
            .addSettingsUpdateConsumer(
 *       and {@link MergeSchedulerConfig#MAX_THREAD_COUNT_SETTING}</li>
    /**
    }
public class ClusterMergeSchedulerConfig {
        MergeSchedulerConfig.validateMaxThreadAndMergeCount(
 *     <td>Not set</td>
            );
 * <p>
    );
        // IndicesService.validateMaxThreadAndMergeCount
 * Always: {@code MAX_THREAD_COUNT <= MAX_MERGE_COUNT}
    }
import org.opensearch.common.annotation.ExperimentalApi;
        ClusterService clusterService = indicesService.clusterService();
import org.opensearch.index.IndexService;
        );
        // CLUSTER_DEFAULT_MAX_THREAD_COUNT_SETTING and CLUSTER_DEFAULT_MAX_MERGE_COUNT_SETTING
        }
 *
 *     <th>Cluster Setting</th>
    public ClusterMergeSchedulerConfig(IndicesService indicesService) {
 *   <tr>
 * <h2>Quick Reference Table</h2>
 *   </tr>
 *     <td>Thread count = your value, Merge count = your value + 5</td>
        clusterService.getClusterSettings()
/**
import static org.opensearch.index.MergeSchedulerConfig.DEFAULT_AUTO_THROTTLE;
    public static final Setting<Integer> CLUSTER_MAX_MERGE_COUNT_SETTING = new Setting<>(
 *   </tr>
        }
 * See {@code org.opensearch.index.ClusterMergeSchedulerConfigsIT} for detailed examples of all configuration scenarios.
        clusterMaxThreadCount = CLUSTER_MAX_THREAD_COUNT_SETTING.get(settings);
    }
        Property.Dynamic,
        this.indicesService = indicesService;
 *     <td>Set</td>
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.NODE_PROCESSORS_SETTING;
 */
    );
 *     <td>Only thread count</td>
import org.opensearch.common.settings.Setting.Property;
                Math.max(1, Math.min(4, OpenSearchExecutors.allocatedProcessors(settings) / 2))
            .addSettingsUpdateConsumer(CLUSTER_AUTO_THROTTLE_SETTING, this::onClusterMergeAutoThrottleUpdate);
    private volatile int clusterMaxThreadCount;
    );
    }
        }
                List.of(CLUSTER_MAX_MERGE_COUNT_SETTING, CLUSTER_MAX_THREAD_COUNT_SETTING),
import org.opensearch.common.settings.Setting;
        Property.Dynamic,
        clusterMaxThreadCount = CLUSTER_MAX_THREAD_COUNT_SETTING.get(clusterSettings);
            indexService.onDefaultMaxMergeOrThreadCountUpdate(clusterMaxThreadCount, clusterMaxMergeCount);
 *     <td>Both set</td>
 * <table border="1">
        for (IndexService indexService : indicesService) {
    /**
import org.opensearch.common.settings.Settings;
 * @see MergeSchedulerConfig
 *   </tr>
 * this file be licensed under the Apache-2.0 license or a
        Property.NodeScope
    }
 * <h2>Three-Level Priority System</h2>
 * </table>
 *   <tr>
 * Controls {@code merges.scheduler.max_merge_count} and {@code merges.scheduler.max_thread_count}.
 *   </tr>
        return this.clusterAutoThrottleEnabled;
 * <h2>What does this do?</h2>
    private volatile boolean clusterAutoThrottleEnabled;
    private void onClusterMergeAutoThrottleUpdate(Boolean value) {
        (s) -> Setting.parseInt(s, 1, "cluster.default.index.merge.scheduler.max_merge_count"),
            );
            clusterMaxThreadCountDefault = Integer.toString(
 *
 *   <tr>
    public static String getClusterMaxMergeCountDefault(Settings settings) {
    private volatile static String clusterMaxThreadCountDefault;
