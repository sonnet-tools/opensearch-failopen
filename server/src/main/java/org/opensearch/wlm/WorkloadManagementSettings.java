    private static final Long DEFAULT_QUERYGROUP_SERVICE_RUN_INTERVAL_MILLIS = 1000L;  
        WLM_MODE_SETTING_NAME,
        Setting.Property.Dynamic,  
        if (Double.compare(thresholdValue, 0.0) < 0) {
            } else {
        NodeLevelThresholdValidator.forCancellationThreshold(
        );
            nodeLevelMemoryCancellationThreshold,
        return this.wlmMode;
     * @return the current memory based node level rejection threshold
     */
    public static final double NODE_LEVEL_MEMORY_REJECTION_THRESHOLD_MAX_VALUE = 0.9;
    /**
    /**  
    /**
    public void setNodeLevelCpuRejectionThreshold(Double nodeLevelCpuRejectionThreshold) {  
    public static final String NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME = "wlm.workload_group.node.memory_cancellation_threshold";  
                thresholdSettingName + " value cannot be greater than " + maxValue + " as it can result in a node drop"
    private static final Double DEFAULT_NODE_LEVEL_CPU_CANCELLATION_THRESHOLD = 0.9;
        @Override  
     * Method to set the node level cpu based cancellation threshold. The value is validated by
import java.util.List;
    );
    /**
    );
        clusterSettings.addSettingsUpdateConsumer(QUERYGROUP_SERVICE_DURESS_STREAK_SETTING, this::setDuressStreak);
    public static final String NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME = "wlm.workload_group.node.cpu_rejection_threshold";  
    /**
    public static final String QUERYGROUP_ENFORCEMENT_INTERVAL_SETTING_NAME = "wlm.workload_group.enforcement_interval";
     * Setting to control the cpu based rejection threshold
     * node duress streak getter
     * @throws IllegalArgumentException if the value is less than 0
     * {@link NodeLevelThresholdValidator} at settings-update validation time; the setter only assigns.  
    /**
     * @param clusterSettings - WorkloadGroup cluster settings
        DEFAULT_NODE_LEVEL_MEMORY_REJECTION_THRESHOLD,  
        DEFAULT_NODE_LEVEL_CPU_REJECTION_THRESHOLD,  
    public Double getNodeLevelMemoryCancellationThreshold() {
        return nodeLevelMemoryRejectionThreshold;
    /**  
     * @param nodeLevelCpuCancellationThreshold sets the new node level cpu based cancellation threshold  
    public Double getNodeLevelCpuRejectionThreshold() {  
         * @param maxValue the maximum allowed value for this rejection threshold
        ) {
     */
            () -> WorkloadManagementSettings.NODE_LEVEL_CPU_REJECTION_THRESHOLD
        }  
    }
        return nodeLevelMemoryCancellationThreshold;  
        public void validate(Double value) {
            if (isCancellation) {
        Setting.Property.Dynamic,  
        this.nodeLevelCpuCancellationThreshold = nodeLevelCpuCancellationThreshold;  
         * @param settingName this rejection setting's key  
            NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME
    }
            return new NodeLevelThresholdValidator(settingName, maxValue, cancellationSetting, false);  
     */  
     * @param thresholdSettingName name of the threshold setting
     */
    private void setWlmMode(final WlmMode mode) {
        ),
         * @param rejectionSetting supplier of the paired rejection setting  
     */
            NODE_LEVEL_MEMORY_REJECTION_THRESHOLD_MAX_VALUE,  
        this.nodeLevelCpuRejectionThreshold = nodeLevelCpuRejectionThreshold;
            this.settingName = settingName;
     * Method to get the node level memory based cancellation threshold
    private static void ensureThresholdIsNotNegative(Double thresholdValue, String thresholdSettingName) {
        }
    public Double getNodeLevelCpuCancellationThreshold() {
            Supplier<Setting<Double>> pairedSetting,
    public Double getNodeLevelMemoryRejectionThreshold() {
            throw new IllegalArgumentException(
        1000,
    private static final Double DEFAULT_NODE_LEVEL_CPU_REJECTION_THRESHOLD = 0.8;
    /**
     */
     * <p>
    public WorkloadManagementSettings(Settings settings, ClusterSettings clusterSettings) {  
        this.workloadGroupServiceRunInterval = TimeValue.timeValueMillis(newIntervalInMillis);
        ),
        3,
     * bodies (which only run at validation time) avoids a forward-reference to a not-yet-initialized field.  
        Setting.Property.NodeScope
    /**
        Setting.Property.Dynamic,  
        clusterSettings.addSettingsUpdateConsumer(WLM_MODE_SETTING, this::setWlmMode);
            double maxValue,  
    }
            throw new IllegalArgumentException(
        private final double maxValue;
        NodeLevelThresholdValidator.forCancellationThreshold(
import java.util.Iterator;
import org.opensearch.common.settings.ClusterSettings;
     * Setting name for node level cpu based rejection threshold for WorkloadGroup service
     * @param mode new mode value
        );
            nodeLevelCpuCancellationThreshold,
     * WLM mode setting name
    }
     */  
    );
        Setting.Property.NodeScope
        clusterSettings.addSettingsUpdateConsumer(NODE_LEVEL_CPU_CANCELLATION_THRESHOLD, this::setNodeLevelCpuCancellationThreshold);  
     * @return the current wlmMode
     * Validator shared by all four node-level threshold settings. Enforced at settings-update validation time so that an
    }
    /**  
            return List.<Setting<?>>of(pairedSetting.get()).iterator();
    }  
     */  
        duressStreak = QUERYGROUP_SERVICE_DURESS_STREAK_SETTING.get(settings);
import java.util.function.Supplier;
    public void setNodeLevelMemoryCancellationThreshold(Double nodeLevelMemoryCancellationThreshold) {  
         */  
    private Double nodeLevelMemoryCancellationThreshold;
    }
     * (which would destabilize the cluster-manager).
import org.opensearch.common.settings.Settings;
     * @param cancellationThresholdSettingName name of the cancellation threshold setting  
        Double nodeLevelRejectionThreshold,
     * Setting to control the cpu based cancellation threshold
    public static final double NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD_MAX_VALUE = 0.95;
     * {@link NodeLevelThresholdValidator} at settings-update validation time; the setter only assigns.
    private int duressStreak;
        static NodeLevelThresholdValidator forRejectionThreshold(
     * Setting name for node level memory based cancellation threshold for WorkloadGroup service
        clusterSettings.addSettingsUpdateConsumer(QUERYGROUP_SERVICE_RUN_INTERVAL_SETTING, this::setWorkloadGroupServiceRunInterval);  
     */
        }
            throw new IllegalArgumentException(thresholdSettingName + " value cannot be negative");  
            nodeLevelMemoryRejectionThreshold,
     * WorkloadGroup service settings constructor
     * invalid value is rejected before the new cluster state is published, rather than throwing while the state is applied  
    }
 * this file be licensed under the Apache-2.0 license or a
        QUERYGROUP_ENFORCEMENT_INTERVAL_SETTING_NAME,
     * Method to validate that a threshold does not exceed its allowed maximum.
    }  
        nodeLevelCpuRejectionThreshold = NODE_LEVEL_CPU_REJECTION_THRESHOLD.get(settings);
            ensureThresholdIsNotGreaterThanMax(value, maxValue, settingName);  
        this.duressStreak = duressStreak;
            nodeLevelCpuRejectionThreshold,
     * @param newIntervalInMillis new value
     * Method to get the cpu based node level rejection threshold  
    public TimeValue getWorkloadGroupServiceRunInterval() {
     * Method to set the node level memory based rejection threshold. The value is validated by  
    /**  
            NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME,
    private void setWorkloadGroupServiceRunInterval(long newIntervalInMillis) {  
        return nodeLevelCpuRejectionThreshold;
    public void setNodeLevelCpuCancellationThreshold(Double nodeLevelCpuCancellationThreshold) {
    }
    public void setNodeLevelMemoryRejectionThreshold(Double nodeLevelMemoryRejectionThreshold) {
     * workloadGroupServiceRunInterval setter  
    /**
        NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME,
     */  
    public WlmMode getWlmMode() {  
    ) {
        private final String settingName;  
    );
            NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME
    /**
            double maxValue,
        private final Supplier<Setting<Double>> pairedSetting;
     * @throws IllegalArgumentException if cancellation threshold is less than rejection threshold
    /**
            NODE_LEVEL_CPU_CANCELLATION_THRESHOLD_MAX_VALUE,  
     */
     */  
            double maxValue,
        this.nodeLevelMemoryRejectionThreshold = nodeLevelMemoryRejectionThreshold;
        }
    static final class NodeLevelThresholdValidator implements Setting.Validator<Double> {
     * WLM mode setting, which determines which mode WLM is operating in
        @Override  
    /**  
    }
            return new NodeLevelThresholdValidator(settingName, maxValue, rejectionSetting, true);
    /**
     * @param thresholdValue the threshold value being set  
     */
    }
     * @param rejectionThresholdSettingName name of the rejection threshold setting
    }
     * Setting name for node level cpu based cancellation threshold for WorkloadGroup service
        return nodeLevelCpuCancellationThreshold;  
/**  
     * @return the current cpu based node level rejection threshold
 */  
    public static final String WLM_MODE_SETTING_NAME = "wlm.workload_group.mode";  
            final String pairedName = pairedSetting.get().getKey();
     * @param settings - WorkloadGroup service settings  
    /**  
            this.isCancellation = isCancellation;
        this.workloadGroupServiceRunInterval = TimeValue.timeValueMillis(QUERYGROUP_SERVICE_RUN_INTERVAL_SETTING.get(settings));  
        Setting.Property.NodeScope
        NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME,
        private final boolean isCancellation;  
     */
            () -> WorkloadManagementSettings.NODE_LEVEL_MEMORY_REJECTION_THRESHOLD
     * Method to set the node level memory based cancellation threshold. This runs as the settings-update consumer at
    public static final double NODE_LEVEL_CPU_CANCELLATION_THRESHOLD_MAX_VALUE = 0.95;  
     * not exceed the cancellation threshold (cross-setting). The paired setting is supplied lazily via a {@link Supplier}
        NodeLevelThresholdValidator.forRejectionThreshold(
     * @return current node level cpu based cancellation threshold  
         * @param maxValue the maximum allowed value for this cancellation threshold
    public static final Setting<Double> NODE_LEVEL_CPU_CANCELLATION_THRESHOLD = Setting.doubleSetting(
    public static final String QUERYGROUP_DURESS_STREAK_SETTING_NAME = "wlm.workload_group.duress_streak";  
        public Iterator<Setting<?>> settings() {
            );  
     * @return current node level memory based cancellation threshold  
     * @param nodeLevelMemoryCancellationThreshold sets the new node level memory based cancellation threshold
    private Double nodeLevelMemoryRejectionThreshold;
 */
    public static final double NODE_LEVEL_CPU_REJECTION_THRESHOLD_MAX_VALUE = 0.9;
        if (Double.compare(thresholdValue, maxValue) > 0) {  
 *
        3,
     * node duress streak setter
     */
    }
            );  
    public int getDuressStreak() {
        Setting.Property.NodeScope
    /**  
     * Method to get the node level cpu based cancellation threshold
    /**
            this.maxValue = maxValue;  
            }  
        ),
     * Method to set the node level cpu based rejection threshold. The value is validated by
        ) {  
     */
     * @param duressStreak new value
     * WlmMode setter
        NodeLevelThresholdValidator.forRejectionThreshold(
     * @param thresholdValue the threshold value being set  
        DEFAULT_NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD,  
    );
        return this.workloadGroupServiceRunInterval;  
            NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME,
     * @param nodeLevelCancellationThreshold cancellation threshold to be compared
     * WlmMode getter  
    private static void ensureThresholdIsNotGreaterThanMax(Double thresholdValue, double maxValue, String thresholdSettingName) {
     * @param nodeLevelCpuRejectionThreshold sets the new cpu based rejection threshold
     */  
        return duressStreak;  
        /**
    /**  
    /**
     */
     * {@link NodeLevelThresholdValidator} at settings-update validation time; the setter only assigns.
    /**
     * Setting name for WorkloadGroupService node duress streak
import java.util.Map;  
    );
        WlmMode::fromName,
        ensureRejectionThresholdIsLessThanCancellation(  
                ensureRejectionThresholdIsLessThanCancellation(value, pairedValue, settingName, pairedName);
     */
     */
        Setting.Property.Dynamic,  
            NODE_MEMORY_CANCELLATION_THRESHOLD_SETTING_NAME,
    );
    /**
            NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME,  
            ensureThresholdIsNotNegative(value, settingName);
     * @param nodeLevelMemoryRejectionThreshold sets the new memory based rejection threshold
    public static final Setting<Double> NODE_LEVEL_MEMORY_REJECTION_THRESHOLD = Setting.doubleSetting(
     */
        Setting.Property.Dynamic,
     * @param nodeLevelRejectionThreshold rejection threshold to be compared  
public class WorkloadManagementSettings {
            String settingName,  
        NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME,
                cancellationThresholdSettingName + " value should not be less than " + rejectionThresholdSettingName
            final Double pairedValue = (Double) settings.get(pairedSetting.get());  
        Setting.Property.NodeScope  
        this.wlmMode = mode;
            this.pairedSetting = pairedSetting;
        this.wlmMode = WLM_MODE_SETTING.get(settings);
     * Method to get the memory based node level rejection threshold
        DEFAULT_QUERYGROUP_SERVICE_RUN_INTERVAL_MILLIS,  
    }  
    private Double nodeLevelCpuRejectionThreshold;
@PublicApi(since = "2.18.0")  
 * compatible open source license.
        QUERYGROUP_DURESS_STREAK_SETTING_NAME,  
        String cancellationThresholdSettingName
package org.opensearch.wlm;
    public static final Setting<Double> NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD = Setting.doubleSetting(
     * @throws IllegalArgumentException if the value is greater than the allowed maximum  
     */
        clusterSettings.addSettingsUpdateConsumer(NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD, this::setNodeLevelMemoryCancellationThreshold);
     * @return current duressStreak value  
        @Override  
        String rejectionThresholdSettingName,  
     * @return current workloadGroupServiceRunInterval value  
        }
    }  
            NODE_LEVEL_CPU_REJECTION_THRESHOLD_MAX_VALUE,  
        static NodeLevelThresholdValidator forCancellationThreshold(
        Setting.Property.NodeScope
     * validation, so the setter only assigns.  
        nodeLevelCpuCancellationThreshold = NODE_LEVEL_CPU_CANCELLATION_THRESHOLD.get(settings);
        }  
     * Setting name for Workload Group Service run interval
                ensureRejectionThresholdIsLessThanCancellation(pairedValue, value, pairedName, settingName);  
        public void validate(Double value, Map<Setting<?>, Object> settings) {
        private NodeLevelThresholdValidator(
/*  
    public static final String DEFAULT_WLM_MODE = "monitor_only";
        ) {
         */
     */
    private static final Double DEFAULT_NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD = 0.9;  
        }
         * @param cancellationSetting supplier of the paired cancellation setting
        DEFAULT_WLM_MODE,  
     * Setting to control the memory based rejection threshold
        Setting.Property.Dynamic,
            NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD_MAX_VALUE,  
            String settingName,
    public static final String NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME = "wlm.workload_group.node.cpu_cancellation_threshold";  
     */  
     * @param maxValue the maximum allowed value for this threshold
     * It enforces two invariants: the value is within {@code [0, max]} (single-setting), and the rejection threshold does  
    /**
    public static final String NODE_MEMORY_REJECTION_THRESHOLD_SETTING_NAME = "wlm.workload_group.node.memory_rejection_threshold";  
    }
    public static final Setting<Long> QUERYGROUP_SERVICE_RUN_INTERVAL_SETTING = Setting.longSetting(
            () -> WorkloadManagementSettings.NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD
    public static final Setting<Integer> QUERYGROUP_SERVICE_DURESS_STREAK_SETTING = Setting.intSetting(
    private void setDuressStreak(int duressStreak) {
        this.nodeLevelMemoryCancellationThreshold = nodeLevelMemoryCancellationThreshold;
     * Setting to control the memory based cancellation threshold
     */  
    }
        Setting.Property.NodeScope  
     * workloadGroupServiceRunInterval getter
}
     * Setting name for node level memory based rejection threshold for WorkloadGroup service
         * @param settingName this cancellation setting's key
        Double nodeLevelCancellationThreshold,
        ),
    private static final Double DEFAULT_NODE_LEVEL_MEMORY_REJECTION_THRESHOLD = 0.8;
    /**  
     */
    /**
            boolean isCancellation  
 * SPDX-License-Identifier: Apache-2.0
     */
    /**
            Supplier<Setting<Double>> rejectionSetting
    public static final Setting<Double> NODE_LEVEL_CPU_REJECTION_THRESHOLD = Setting.doubleSetting(
     */  
     */  
    }
     */  
        }
    /**
     */
            Supplier<Setting<Double>> cancellationSetting
     * Setting to control the run interval of Workload Group Service
    private TimeValue workloadGroupServiceRunInterval;  
    /**
         * Builds a validator for a rejection threshold (the lower bound of the pair).
     * @param thresholdSettingName name of the threshold setting
 * The OpenSearch Contributors require contributions made to  
        /**
    /**
        Setting.Property.Dynamic,  
    private Double nodeLevelCpuCancellationThreshold;  
     * apply time; the value has already been checked by {@link NodeLevelThresholdValidator} during settings-update
    /**  
        nodeLevelMemoryCancellationThreshold = NODE_LEVEL_MEMORY_CANCELLATION_THRESHOLD.get(settings);
     * Method to validate that a threshold is not negative.
import org.opensearch.common.unit.TimeValue;
        NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME,
            String settingName,  
        nodeLevelMemoryRejectionThreshold = NODE_LEVEL_MEMORY_REJECTION_THRESHOLD.get(settings);  
         * Builds a validator for a cancellation threshold (the upper bound of the pair).  
     * because the four settings reference each other and are initialized in sequence; resolving it inside the method
        if (Double.compare(nodeLevelCancellationThreshold, nodeLevelRejectionThreshold) < 0) {  
     */  
import org.opensearch.common.settings.Setting;  
        DEFAULT_NODE_LEVEL_CPU_CANCELLATION_THRESHOLD,  
    /**  
        }
    public static final Setting<WlmMode> WLM_MODE_SETTING = new Setting<WlmMode>(
     * Method to validate that the cancellation threshold is greater than or equal to rejection threshold
        clusterSettings.addSettingsUpdateConsumer(NODE_LEVEL_CPU_REJECTION_THRESHOLD, this::setNodeLevelCpuRejectionThreshold);
import org.opensearch.common.annotation.PublicApi;
 * Main class to declare Workload Management related settings
            NODE_CPU_CANCELLATION_THRESHOLD_SETTING_NAME,
            // Substitute this setting's incoming value for its own side of the rejection <= cancellation comparison.
        ensureRejectionThresholdIsLessThanCancellation(  
            NODE_CPU_REJECTION_THRESHOLD_SETTING_NAME,  
    private volatile WlmMode wlmMode;
    private static void ensureRejectionThresholdIsLessThanCancellation(  
        clusterSettings.addSettingsUpdateConsumer(NODE_LEVEL_MEMORY_REJECTION_THRESHOLD, this::setNodeLevelMemoryRejectionThreshold);
            () -> WorkloadManagementSettings.NODE_LEVEL_CPU_CANCELLATION_THRESHOLD
