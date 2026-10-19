        clusterSettings.addSettingsUpdateConsumer(SHARD_INDEXING_PRESSURE_ENABLED, this::setShardIndexingPressureEnabled);
import org.opensearch.common.settings.Setting;  
 * This class contains all the settings which are required and owned by {TODO link ShardIndexingPressure}. These will be
    }
    private void setShardReplicaBaseLimits() {  
        "shard_indexing_pressure.primary_parameter.shard.min_limit",
    private void setRequestSizeWindow(int requestSizeWindow) {
    }
    private volatile double shardMinLimit;
 */  
        this.shardIndexingPressureEnforced = SHARD_INDEXING_PRESSURE_ENFORCED.get(settings);
    }  
    public boolean isShardIndexingPressureEnforced() {
        return shardPrimaryAndCoordinatingBaseLimits;
        // Updating the dependent value once when the dynamic settings update  
    private volatile int requestSizeWindow;  
    private void setShardMinLimit(double shardMinLimit) {  
        this.setShardReplicaBaseLimits();
        shardPrimaryAndCoordinatingBaseLimits = (long) (primaryAndCoordinatingNodeLimits * shardMinLimit);  
import org.opensearch.common.settings.ClusterSettings;
        return shardReplicaBaseLimits;  
}
        return (long) (primaryAndCoordinatingNodeLimits * 1.5);
    }  
    public static final Setting<Double> SHARD_MIN_LIMIT = Setting.doubleSetting(  
        this.shardIndexingPressureEnabled = SHARD_INDEXING_PRESSURE_ENABLED.get(settings);
        Setting.Property.NodeScope,
 * {TODO link ShardIndexingPressureMemoryManager} and {TODO link ShardIndexingPressureStore}  
    public ShardIndexingPressureSettings(ClusterService clusterService, Settings settings, long primaryAndCoordinatingLimits) {
        this.requestSizeWindow = requestSizeWindow;  
        return requestSizeWindow;
 */  
    public long getNodeReplicaLimits() {
        this.setShardPrimaryAndCoordinatingBaseLimits();
        clusterSettings.addSettingsUpdateConsumer(SHARD_INDEXING_PRESSURE_ENFORCED, this::setShardIndexingPressureEnforced);
import org.opensearch.cluster.service.ClusterService;
     * This represents the base limit set for the utilization of every shard. Will be initilized as 1/1000th bytes of node limits.
        "shard_indexing_pressure.secondary_parameter.throughput.request_size_window",  
        Setting.Property.Dynamic  
        this.shardPrimaryAndCoordinatingBaseLimits = (long) (primaryAndCoordinatingLimits * shardMinLimit);
    private volatile long shardPrimaryAndCoordinatingBaseLimits;
package org.opensearch.index;
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
 * Copyright OpenSearch Contributors.
     */  
import org.opensearch.common.settings.Settings;
     * Feature level setting to operate in shadow-mode or in enforced-mode. If enforced field is set to true, shard level
        "shard_indexing_pressure.enforced",
     * This represents the window size of last N request sampled and considered for throughput evaluation.  
        this.shardMinLimit = SHARD_MIN_LIMIT.get(settings).floatValue();  
        Setting.Property.Dynamic,
    public static final Setting<Boolean> SHARD_INDEXING_PRESSURE_ENFORCED = Setting.boolSetting(
        Setting.Property.Dynamic
    public static final Setting<Integer> REQUEST_SIZE_WINDOW = Setting.intSetting(
    public long getShardReplicaBaseLimits() {
    );  
        false,  
/**  
    public long getShardPrimaryAndCoordinatingBaseLimits() {
    }
    );
    private volatile long shardReplicaBaseLimits;
        Setting.Property.Dynamic,
    private void setShardPrimaryAndCoordinatingBaseLimits() {
        shardReplicaBaseLimits = (long) (shardPrimaryAndCoordinatingBaseLimits * 1.5);
public final class ShardIndexingPressureSettings {
        clusterSettings.addSettingsUpdateConsumer(SHARD_MIN_LIMIT, this::setShardMinLimit);  
        0.001d,
        this.shardMinLimit = shardMinLimit;
    public long getNodePrimaryAndCoordinatingLimits() {  
        Setting.Property.NodeScope  
    }
    /**
    public static final String SHARD_INDEXING_PRESSURE_ENABLED_ATTRIBUTE_KEY = "shard_indexing_pressure_enabled";  
    private volatile boolean shardIndexingPressureEnabled;
    public int getRequestSizeWindow() {  
     */
    public static final Setting<Boolean> SHARD_INDEXING_PRESSURE_ENABLED = Setting.boolSetting(
    public boolean isShardIndexingPressureEnabled() {
    }
    );
        "shard_indexing_pressure.enabled",  
    private void setShardIndexingPressureEnabled(Boolean shardIndexingPressureEnableValue) {  
        this.requestSizeWindow = REQUEST_SIZE_WINDOW.get(settings).intValue();
    private void setShardIndexingPressureEnforced(Boolean shardIndexingPressureEnforcedValue) {
 * referenced/used in ShardIndexingPressure, as well as its dependent components, i.e.
    }  
        Setting.Property.NodeScope,
        0.0d,  
    }
     * rejection will be performed, otherwise only rejection metrics will be populated.
    /**  
        return shardIndexingPressureEnabled;
    /**  
        Setting.Property.NodeScope
        this.shardIndexingPressureEnabled = shardIndexingPressureEnableValue;
        this.shardReplicaBaseLimits = (long) (shardPrimaryAndCoordinatingBaseLimits * 1.5);
        return shardIndexingPressureEnforced;  
    private volatile boolean shardIndexingPressureEnforced;  
    }  
 * SPDX-License-Identifier: Apache-2.0
    private final long primaryAndCoordinatingNodeLimits;
        this.primaryAndCoordinatingNodeLimits = primaryAndCoordinatingLimits;
 *
        this.shardIndexingPressureEnforced = shardIndexingPressureEnforcedValue;
    );  
/*  
        return primaryAndCoordinatingNodeLimits;
    }
    }
     */
    }  
        false,
        2000,
    }
 * @opensearch.internal
        clusterSettings.addSettingsUpdateConsumer(REQUEST_SIZE_WINDOW, this::setRequestSizeWindow);
