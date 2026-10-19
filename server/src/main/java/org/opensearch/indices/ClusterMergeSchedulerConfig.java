 *  
            indexService.onDefaultAutoThrottleEnabledUpdate(clusterAutoThrottleEnabled);
    private void setClusterMaxThreadAndMergeCount(Settings settings) {  
 *
 *     <td>Cluster defaults</td>
 *     <td>Both set</td>  
        if (NODE_PROCESSORS_SETTING.exists(settings) || clusterMaxThreadCountDefault == null) {
        DEFAULT_AUTO_THROTTLE,
        clusterService.getClusterSettings()  
 *   </tr>
    }
import java.util.List;
        // IndicesService.validateMaxThreadAndMergeCount  
import org.opensearch.cluster.service.ClusterService;
     * Default value for {@code CLUSTER_DEFAULT_MAX_MERGE_COUNT_SETTING}
 * Controls {@code merges.scheduler.max_merge_count} and {@code merges.scheduler.max_thread_count}.
 * this file be licensed under the Apache-2.0 license or a
 *   <tr>
 *   <li><b>Index Level</b> (highest priority) - {@link MergeSchedulerConfig#MAX_MERGE_COUNT_SETTING}
    );
 *     <td>Absolute defaults (CPU-based calculation)</td>  
 *     <td>Only thread count</td>
 *     <td>Not set</td>
        Property.NodeScope  
 *     <td>Only merge count</td>
 *   <tr>
 *     <td>Merge count = your value, Thread count = absolute default</td>  
        return this.clusterMaxThreadCount;
        Property.NodeScope  
 *     <td>Both use your values (if valid)</td>
 * </ol>  
    }
                this::setClusterMaxThreadAndMergeCount,
@ExperimentalApi
        "cluster.index.merge.scheduler.max_thread_count",
    }
 *  
    private final IndicesService indicesService;
    }  
package org.opensearch.indices;
 */
            .addSettingsUpdateConsumer(CLUSTER_AUTO_THROTTLE_SETTING, this::onClusterMergeAutoThrottleUpdate);
import org.opensearch.common.settings.Settings;
import org.opensearch.common.settings.Setting;  
    private volatile static String clusterMaxThreadCountDefault;  
        return clusterMaxThreadCountDefault;
            clusterMaxThreadCountDefault = Integer.toString(
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
        return this.clusterAutoThrottleEnabled;  
 * @see MergeSchedulerConfig  
 *   <tr>  
    /**  
        clusterService.getClusterSettings()  
        for (IndexService indexService : indicesService) {  
        clusterMaxThreadCount = CLUSTER_MAX_THREAD_COUNT_SETTING.get(clusterSettings);
 *     <td>Doesn't matter</td>  
 *     <td>Doesn't matter</td>
 * <table border="1">
    private void onClusterMergeAutoThrottleUpdate(Boolean value) {
 *     <th>Index Setting</th>
import org.opensearch.common.annotation.ExperimentalApi;
    public Integer getClusterMaxThreadCount() {
import static org.opensearch.index.MergeSchedulerConfig.DEFAULT_AUTO_THROTTLE;
 *       and {@link #CLUSTER_MAX_THREAD_COUNT_SETTING}</li>
 *   </tr>
 * <h2>Three-Level Priority System</h2>
    }
 * Configuration manager for merge scheduler settings.
        Property.Dynamic,
 * </table>
    public static final Setting<Boolean> CLUSTER_AUTO_THROTTLE_SETTING = Setting.boolSetting(
 *   <li><b>Absolute Default</b> (fallback) - Calculated automatically based on your CPU cores </li>
        ClusterMergeSchedulerConfig::getClusterMaxMergeCountDefault,
 * compatible open source license.
            .addSettingsUpdateConsumer(
 */  
 * <ol>  
 * See {@code org.opensearch.index.ClusterMergeSchedulerConfigsIT} for detailed examples of all configuration scenarios.
 * <h2>Examples</h2>  
    private volatile int clusterMaxThreadCount;
        ClusterMergeSchedulerConfig::getClusterMaxThreadCountDefault,  
 *     <td>Doesn't matter</td>
        (s) -> Setting.parseInt(s, 1, "cluster.default.index.merge.scheduler.max_thread_count"),
 *     <td>Not set</td>  
 *   </tr>  
 *
    public static String getClusterMaxMergeCountDefault(Settings settings) {
            CLUSTER_MAX_THREAD_COUNT_SETTING.get(settings),
 * Settings are applied in this order (prioritized highest to lowest):
import org.opensearch.common.settings.Setting.Property;
 * <h2>The One Rule</h2>
    /**
 *
 * <h2>Quick Reference Table</h2>
 * <caption>Settings hierarchy and fallback behavior for merge scheduler configuration</caption>  
        for (IndexService indexService : indicesService) {
     */  
 * <p>
/*  
 *     <th>Cluster Setting</th>  
 *   </tr>
 * <h2>What does this do?</h2>  
 *   </tr>
        clusterAutoThrottleEnabled = value;  
 *   <li><b>Cluster Level</b> (middle priority) - {@link #CLUSTER_MAX_MERGE_COUNT_SETTING}  
        // CLUSTER_DEFAULT_MAX_THREAD_COUNT_SETTING and CLUSTER_DEFAULT_MAX_MERGE_COUNT_SETTING
        // settings received here have already been validated using
        return Integer.toString(CLUSTER_MAX_THREAD_COUNT_SETTING.get(settings) + 5);
 * The OpenSearch Contributors require contributions made to  
    public Boolean getClusterMergeAutoThrottleEnabled() {
        "cluster.index.merge.scheduler.auto_throttle",  
                List.of(CLUSTER_MAX_MERGE_COUNT_SETTING, CLUSTER_MAX_THREAD_COUNT_SETTING),  
        Property.NodeScope
        );  
            );
     */
        return this.clusterMaxMergeCount;
        clusterMaxThreadCount = CLUSTER_MAX_THREAD_COUNT_SETTING.get(settings);
    public static String getClusterMaxThreadCountDefault(Settings settings) {  
    public ClusterMergeSchedulerConfig(IndicesService indicesService) {  
     * Default value for {@code CLUSTER_DEFAULT_MAX_THREAD_COUNT_SETTING}
            CLUSTER_MAX_MERGE_COUNT_SETTING.get(settings)
    private volatile int clusterMaxMergeCount;
        this.indicesService = indicesService;
 * These determine how many merge operations can run simultaneously and how many threads handle merging.
    private volatile boolean clusterAutoThrottleEnabled;  
 *     <td>Thread count = your value, Merge count = your value + 5</td>
    public static final Setting<Integer> CLUSTER_MAX_MERGE_COUNT_SETTING = new Setting<>(  
            );
 *   </tr>  
        clusterMaxMergeCount = CLUSTER_MAX_MERGE_COUNT_SETTING.get(settings);
    }  
 *   <tr>
 * SPDX-License-Identifier: Apache-2.0
 *     <td>Set</td>
import static org.opensearch.common.util.concurrent.OpenSearchExecutors.NODE_PROCESSORS_SETTING;  
 * You can't have more threads than allowed merges.
        clusterAutoThrottleEnabled = CLUSTER_AUTO_THROTTLE_SETTING.get(clusterSettings);
    public Integer getClusterMaxMergeCount() {  
        Property.Dynamic,
        Property.Dynamic,
        (s) -> Setting.parseInt(s, 1, "cluster.default.index.merge.scheduler.max_merge_count"),  
/**  
 * Always: {@code MAX_THREAD_COUNT <= MAX_MERGE_COUNT}  
        MergeSchedulerConfig.validateMaxThreadAndMergeCount(  
            indexService.onDefaultMaxMergeOrThreadCountUpdate(clusterMaxThreadCount, clusterMaxMergeCount);
 *   <tr>
public class ClusterMergeSchedulerConfig {  
    );  
 *     <td>Not set</td>
        // Cluster level validation - assert CLUSTER_DEFAULT_MAX_MERGE_COUNT_SETTING >= CLUSTER_DEFAULT_MAX_THREAD_COUNT_SETTING
    );
    }
 *     <th>Result</th>
    private void validateMaxThreadAndMergeCount(Settings settings) {
 *
import org.opensearch.index.MergeSchedulerConfig;
 *
        }  
        ClusterService clusterService = indicesService.clusterService();
                this::validateMaxThreadAndMergeCount
        Settings clusterSettings = clusterService.getSettings();  
                Math.max(1, Math.min(4, OpenSearchExecutors.allocatedProcessors(settings) / 2))  
        "cluster.index.merge.scheduler.max_merge_count",
        }
 *       and {@link MergeSchedulerConfig#MAX_THREAD_COUNT_SETTING}</li>
        clusterMaxMergeCount = CLUSTER_MAX_MERGE_COUNT_SETTING.get(clusterSettings);  
 *   <tr>  
    }
import org.opensearch.index.IndexService;
}
    public static final Setting<Integer> CLUSTER_MAX_THREAD_COUNT_SETTING = new Setting<>(
    }  
        }
