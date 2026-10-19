        clusterMaxMergeCountDefault = mergeCount;
        return Integer.toString(clusterMaxThreadCountDefault);
            return Integer.toString(MAX_THREAD_COUNT_SETTING.get(settings) + 5);
     * fall back to the cluster-level setting.
     * @param indexSettings the settings for the index being initialized
        validateMaxThreadAndMergeCount(newMaxThreadCount, newMaxMergeCount);  
            ? clusterAutoThrottleEnabledDefault
                this.indexName,  
     * <p>  
     * @see ConcurrentMergeScheduler#enableAutoIOThrottle()
     *       AND cluster defaults exist → use cluster defaults</li>
 * <p>
     * This method figures out which settings to use (index-level, cluster-level, or absolute defaults)
 * </ul>  
        boolean autoThrottleEnabled = (AUTO_THROTTLE_SETTING.exists(settings) == false && clusterAutoThrottleEnabledDefault != null)  
     * Expert: directly set the maximum number of merge threads and
     * Enables / disables auto throttling on the {@link ConcurrentMergeScheduler}  
import org.apache.logging.log4j.LogManager;
    /**
     * if overrideExistingConfigs == true  
        if (newMaxThreadCount == this.maxThreadCount && newMaxMergeCount == this.maxMergeCount) {  
 * the Apache License, Version 2.0 (the "License"); you may
    );  
        initMergeConfigs(indexSettings);
     * @param overrideExistingConfigs if {@code true}, applies these values to all existing
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
 *
 *     Controls the rate limiting for forced merges in MB per second at the index level.
}
     *
 * <p>  
        return maxThreadCount;
 */  
     */  
            throw new IllegalArgumentException("maxThreadCount (= " + maxThreadCount + ") should be at least 1");
        this.maxForceMergeMBPerSec = maxForceMergeMBPerSec;
     *                                sets the default for future configurations
    /**
import org.opensearch.common.settings.Setting;  
        boolean hasIndexSetting = MAX_FORCE_MERGE_MB_PER_SEC_SETTING.exists(indexSettings.getSettings());
    public int getMaxMergeCount() {
     * Updates the maximum force merge rate based on index settings, with fallback to cluster settings.
                newMaxMergeCount,
 *
     * <p><b>Decision Logic:</b>
        Property.Dynamic,
 * not use this file except in compliance with the License.
        );
    }  
    private static volatile Integer clusterMaxMergeCountDefault;  
    MergeSchedulerConfig(IndexSettings indexSettings) {
    public static final Setting<Boolean> AUTO_THROTTLE_SETTING = Setting.boolSetting(
    public static final Setting<Integer> MAX_MERGE_COUNT_SETTING = new Setting<>(
import org.apache.lucene.index.ConcurrentMergeScheduler;
     * Sets the maximum force merge rate in MB per second.  
        if (hasIndexSetting) {
        );
     */
            setAutoThrottle(enabled);  
        MergeSchedulerConfig::getDefaultAutoThrottle,
    public synchronized void setDefaultMaxThreadAndMergeCount(int threadCount, int mergeCount, boolean overrideExistingConfigs) {  
     * Returns {@code maxMergeCount}.  
        setAutoThrottle(autoThrottleEnabled);
            throw new IllegalArgumentException("maxMergeCount (= " + maxMergeCount + ") should be at least 1");
        Double.POSITIVE_INFINITY,  
        (s) -> Setting.parseInt(s, 1, "index.merge.scheduler.max_merge_count"),
    }
        // If MAX_MERGE_COUNT_SETTING is set - return the absolute default for MAX_THREAD_COUNT_SETTING
        return autoThrottle;
     * <p><b>What gets initialized:</b></p>
        int maxMerge = useCachedClusterDefaults ? clusterMaxMergeCountDefault : MAX_MERGE_COUNT_SETTING.get(settings);
                this.maxThreadCount,
 *     Setting a finite positive value will limit the throughput of forced merge operations
 *     The maximum number of threads that may be merging at once. Defaults to
 *     Index-level settings take precedence over this cluster-level setting.  
 *     unluckily suddenly requires a large merge will see that merge aggressively
package org.opensearch.index;
        Property.IndexScope  
 * compatible open source license.
        // If MAX_THREAD_COUNT_SETTING is NOT set - return the cluster default  
    }
        MergeSchedulerConfig::getDefaultMergeCount,  
 * run in separate threads, and when the maximum number of threads is reached,
        boolean useCachedClusterDefaults = MAX_THREAD_COUNT_SETTING.exists(settings) == false  
 * <li>If both settings are specified: uses index value (index takes precedence)
 *
     */
 * <li><code>cluster.merge.scheduler.max_force_merge_mb_per_sec</code>:
    public synchronized void setDefaultAutoThrottleEnabled(boolean enabled, boolean overrideExistingConfigs) {  
 *     move higher to allow merges to keep up with ongoing indexing.
    }
            new ParameterizedMessage("Updating autoThrottle for index {} from [{}] to [{}]", this.indexName, this.autoThrottle, enabled)
    void setMaxForceMergeMBPerSec(double maxForceMergeMBPerSec) {  
        clusterAutoThrottleEnabledDefault = enabled;
        (s) -> Setting.parseInt(s, 1, "index.merge.scheduler.max_thread_count"),  
/*
    public void setAutoThrottle(boolean enabled) {
    }  
    public void setMaxThreadAndMergeCount(int newMaxThreadCount, int newMaxMergeCount) {
        // On first invocation, MAX_MERGE_COUNT_SETTING would not have been initialized, hence the null check  
    }  
@PublicApi(since = "1.0.0")
    public static final Setting<Integer> MAX_THREAD_COUNT_SETTING = new Setting<>(  
            new ParameterizedMessage(
        }  
    public static void validateMaxThreadAndMergeCount(int maxThreadCount, int maxMergeCount) {  
     *   <li>If <b>no index-level settings</b> are explicitly set for thread/merge count,
 * <ul>
                "Initialized index {} with maxMergeCount={}, maxThreadCount={}, autoThrottleEnabled={}",
    private volatile int maxThreadCount;
    /**
        } else {
 * Licensed to Elasticsearch under one or more contributor  
    /**
/**
 * <p>
            new ParameterizedMessage(
    );
 * <p>
        Property.Dynamic,
import org.apache.logging.log4j.Logger;
import org.opensearch.common.annotation.PublicApi;
     *
            throw new IllegalArgumentException(
    private static volatile Integer clusterMaxThreadCountDefault;
 *     Controls the rate limiting for forced merges in MB per second at the cluster level.  
                this.indexName
 * SPDX-License-Identifier: Apache-2.0
     *   <li>{@code autoThrottle} - Whether merge I/O throttling is enabled</li>
    );  
    static Logger logger = LogManager.getLogger(MergeSchedulerConfig.class);  
        "index.merge.scheduler.auto_throttle",  
        Double.POSITIVE_INFINITY,
     * @param mergeCount the default maximum number of concurrent merges allowed
    public boolean isAutoThrottle() {
    /**
            )
     *                                configurations in the cluster; if {@code false}, only  
 * Modifications Copyright OpenSearch Contributors. See
 */
     */
     *   <li>{@code maxMergeCount} - Maximum number of concurrent merges</li>
        setMaxThreadAndMergeCount(maxThread, maxMerge);
 *     which works well for a good solid-state-disk (SSD).  If your index is on  
 * this file be licensed under the Apache-2.0 license or a
 * <li><code>index.merge.scheduler.auto_throttle</code>:  
        MergeSchedulerConfig::getDefaultMaxThreadCount,
     *   <li>{@code maxThreadCount} - Maximum number of merge threads</li>  
    private final String indexName;
        }  
        this.maxMergeCount = newMaxMergeCount;  
 * specific language governing permissions and limitations
        );
     */
        if (maxThreadCount > maxMergeCount) {
     * Returns <code>true</code> iff auto throttle is enabled.  
        updateMaxForceMergeMBPerSec(indexSettings);
                "maxThreadCount (= " + maxThreadCount + ") should be <= maxMergeCount (= " + maxMergeCount + ")"  
 * GitHub history for details.
 *  
    }
    private static String getDefaultMergeCount(Settings settings) {
    );
import org.opensearch.common.settings.Setting.Property;
 * <p><b>Setting Precedence:</b>  
     * <ul>  
        Property.Dynamic,
     * <p>
 * <li> <code>index.merge.scheduler.max_thread_count</code>:
     */  
            setMaxThreadAndMergeCount(threadCount, mergeCount);
    private static volatile Boolean clusterAutoThrottleEnabledDefault;
        logger.info(  
 *     This setting is used as a fallback when the index-level setting is not specified.
     * This method handles the case where an index-level setting is removed and should  
import org.apache.logging.log4j.message.ParameterizedMessage;  
        }  
        logger.info(
        Property.IndexScope  
 *     throttled, while an application doing heavy indexing will see the throttle  
    );  
            : AUTO_THROTTLE_SETTING.get(settings);
    }
     * Sets the default maximum thread and merge count for the cluster.  
     * </p>
 * this work for additional information regarding copyright
        }
    /**  
    private void initMergeConfigs(IndexSettings indexSettings) {
    public double getMaxForceMergeMBPerSec() {
 * The merge scheduler (<code>ConcurrentMergeScheduler</code>) controls the execution of  
     * Returns the maximum force merge rate in MB per second.
     * A value of Double.POSITIVE_INFINITY indicates no rate limiting.
        logger.info(  
     * </p>  
        }  
            && MAX_MERGE_COUNT_SETTING.exists(settings) == false
     * simultaneous merges allowed.  
        Settings settings = indexSettings.getSettings();
    /**
        // If MAX_THREAD_COUNT_SETTING is set - return the absolute default for MAX_MERGE_COUNT_SETTING
        Property.IndexScope
 *     <code>Math.max(1, Math.min(4, {@link OpenSearchExecutors#allocatedProcessors(Settings)} / 2))</code>
     */
     * and applies them to this merge scheduler instance.
        "index.merge.scheduler.max_force_merge_mb_per_sec",  
        return maxMergeCount;  
    /**
        }
     *       or fall back to absolute defaults)</li>
     * </ul>
        0.0d,
/*  
public final class MergeSchedulerConfig {
    private volatile int maxMergeCount;
     * @param enabled {@code true} to enable auto-throttling by default,  
 * <li>If only cluster-level setting is specified: uses cluster value  
    public int getMaxThreadCount() {  
        if (maxThreadCount < 1) {
    public static final Setting<Double> CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING = Setting.doubleSetting(
        return maxForceMergeMBPerSec;
     **
     * <p>
     *                {@code false} to disable it
    private static String getDefaultMaxThreadCount(Settings settings) {  
    }  
 *     If this is true (the default), then the merge scheduler will rate-limit IO
 *
            );
 *     (writes) for merges to an adaptive value depending on how many merges are  
     * Returns {@code maxThreadCount}.
     *   <li>Otherwise → use the settings as-is (which may include index-level values  
        if (MAX_MERGE_COUNT_SETTING == null || MAX_MERGE_COUNT_SETTING.exists(settings) == true || clusterMaxThreadCountDefault == null) {
        Property.Dynamic,
        "index.merge.scheduler.max_thread_count",
 *  
     * if overrideExistingConfigs == true  
                "Updating maxThreadCount from [{}] to [{}] and maxMergeCount from [{}] to [{}] for index {}.",  
            this.maxForceMergeMBPerSec = indexSettings.getValue(MAX_FORCE_MERGE_MB_PER_SEC_SETTING);  
    }
        "index.merge.scheduler.max_merge_count",
        Double.POSITIVE_INFINITY,  
 * <ul>
     * </p>
        // If MAX_MERGE_COUNT_SETTING is NOT set - return the cluster default
        return Boolean.toString(Objects.requireNonNullElseGet(clusterAutoThrottleEnabledDefault, () -> DEFAULT_AUTO_THROTTLE));
    /**
                this.maxThreadCount,
import org.opensearch.common.settings.Settings;
        Property.Dynamic,
 * under the License.  
     * @param threadCount the default maximum number of threads to use for merge operations  
    /**
 *
        Double.POSITIVE_INFINITY,
        if (MAX_THREAD_COUNT_SETTING.exists(settings) == true || clusterMaxMergeCountDefault == null) {
    }
 * <p>The merge scheduler supports the following <b>dynamic</b> settings:
     */
/*  
        return Integer.toString(clusterMaxMergeCountDefault);
 * <li><code>index.merge.scheduler.max_force_merge_mb_per_sec</code>:  
        Property.NodeScope
    private volatile boolean autoThrottle;  
            return;
    public static final Setting<Double> MAX_FORCE_MERGE_MB_PER_SEC_SETTING = Setting.doubleSetting(
 * ownership. Elasticsearch licenses this file to you under  
 * <li>If neither setting is specified: uses default value (Double.POSITIVE_INFINITY)
            && clusterMaxMergeCountDefault != null;  
 * merge operations once they are needed (according to the merge policy).  Merges
        }  
     * This default value optionally overrides the existing configs for the index
 *     The default value of Double.POSITIVE_INFINITY means no rate limiting is applied.
    }  
        if (overrideExistingConfigs == true) {
        Property.IndexScope
    /**  
     */  
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
    }  
 * @opensearch.api
        0.0d,
     * Initializes merge scheduler configuration for an index.
 * license agreements. See the NOTICE file distributed with
     * Sets the default auto-throttle enabled state for the cluster.  
 */  
                newMaxThreadCount,
     * @param overrideExistingConfigs if {@code true}, applies this setting to all existing
 * Unless required by applicable law or agreed to in writing,
    private static String getDefaultAutoThrottle(Settings settings) {
     * </ul>  
    public static final boolean DEFAULT_AUTO_THROTTLE = true;
        }
                this.maxMergeCount,
 * further merges will wait until a merge thread becomes available.  
    private volatile double maxForceMergeMBPerSec;  
        this.autoThrottle = enabled;  
 *
     *  
     *
 *    http://www.apache.org/licenses/LICENSE-2.0
            this.maxForceMergeMBPerSec = CLUSTER_MAX_FORCE_MERGE_MB_PER_SEC_SETTING.get(indexSettings.getNodeSettings());
 * </ul>
    }
        }
    }
 *     The default value of Double.POSITIVE_INFINITY means no rate limiting is applied.  
        int maxThread = useCachedClusterDefaults ? clusterMaxThreadCountDefault : MAX_THREAD_COUNT_SETTING.get(settings);
 * The OpenSearch Contributors require contributions made to  
 *  
     *                                sets the defaults for future configurations
        "cluster.merge.scheduler.max_force_merge_mb_per_sec",  
 * You may obtain a copy of the License at  
            )  
 * software distributed under the License is distributed on an
     */
     */
        if (maxMergeCount < 1) {
 *     requested over time.  An application with a low indexing rate that
     * <ul>
     *
 *     spinning platter drives instead, decrease this to 1.
import org.opensearch.indices.ClusterMergeSchedulerConfig;
 * KIND, either express or implied.  See the License for the
        indexName = indexSettings.getIndex().getName();  
        this.maxThreadCount = newMaxThreadCount;
import java.util.Objects;  
    }  
            return ClusterMergeSchedulerConfig.getClusterMaxThreadCountDefault(settings);
    /**  
 *
     * This default value optionally overrides the existing configs for the index
     * A value of Double.POSITIVE_INFINITY disables rate limiting.
 * <li>If only index-level setting is specified: uses index value
        clusterMaxThreadCountDefault = threadCount;
 *     to the specified rate. This setting takes precedence over the cluster-level setting.
 */  
     * Validate the values of {@code maxMergeCount} and {@code maxThreadCount}
    public void updateMaxForceMergeMBPerSec(IndexSettings indexSettings) {  
        if (overrideExistingConfigs == true) {  
                this.autoThrottle  
                this.maxMergeCount,  
     *                                configurations in the cluster; if {@code false}, only  
            && clusterMaxThreadCountDefault != null
