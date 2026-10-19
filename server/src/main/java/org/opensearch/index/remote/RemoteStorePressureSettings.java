    boolean isRemoteRefreshSegmentPressureEnabled() {
        Setting.Property.Dynamic,  
    public static final Setting<Double> UPLOAD_TIME_LAG_VARIANCE_FACTOR = Setting.doubleSetting(  
    }  
        Setting.Property.NodeScope  
    );
    double getUploadTimeLagVarianceFactor() {  
        clusterSettings.addSettingsUpdateConsumer(BYTES_LAG_VARIANCE_FACTOR, this::setBytesLagVarianceFactor);
    }
import org.opensearch.common.settings.ClusterSettings;
        return minRefreshSeqNoLagLimit;
    );  
    }
        Settings settings,
    private volatile long minRefreshSeqNoLagLimit;  
    }
 * this file be licensed under the Apache-2.0 license or a
        this.uploadTimeLagVarianceFactor = uploadTimeLagVarianceFactor;
        Defaults.VARIANCE_FACTOR_MIN_VALUE,  
    public static final Setting<Integer> MIN_CONSECUTIVE_FAILURES_LIMIT = Setting.intSetting(
        Defaults.VARIANCE_FACTOR_MIN_VALUE,
        this.minConsecutiveFailuresLimit = minConsecutiveFailuresLimit;
 * The OpenSearch Contributors require contributions made to  
        "remote_store.segment.pressure.enabled",
        Defaults.MIN_CONSECUTIVE_FAILURES_LIMIT_MIN_VALUE,
 */
        ClusterService clusterService,  
import org.opensearch.common.settings.Setting;  
        this.uploadTimeLagVarianceFactor = UPLOAD_TIME_LAG_VARIANCE_FACTOR.get(settings);  
    int getMinConsecutiveFailuresLimit() {
        "remote_store.segment.pressure.consecutive_failures.limit",  
    }
    );
        this.remoteRefreshSegmentPressureEnabled = REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED.get(settings);  
    long getMinRefreshSeqNoLagLimit() {  
    }
        "remote_store.segment.pressure.time_lag.variance_factor",
        this.remoteRefreshSegmentPressureEnabled = remoteRefreshSegmentPressureEnabled;  
    }
 * SPDX-License-Identifier: Apache-2.0
        Setting.Property.NodeScope
    }  
    private volatile double bytesLagVarianceFactor;
    }  
        private static final double UPLOAD_TIME_LAG_VARIANCE_FACTOR = 10.0;  
        private static final double VARIANCE_FACTOR_MIN_VALUE = 1.0;
public class RemoteStorePressureSettings {
        Defaults.MIN_CONSECUTIVE_FAILURES_LIMIT,
        this.minConsecutiveFailuresLimit = MIN_CONSECUTIVE_FAILURES_LIMIT.get(settings);  
        Setting.Property.NodeScope
        Setting.Property.Dynamic,  
    private void setRemoteRefreshSegmentPressureEnabled(boolean remoteRefreshSegmentPressureEnabled) {
    static class Defaults {
    public RemoteStorePressureSettings(
import org.opensearch.common.settings.Settings;
        private static final int MIN_CONSECUTIVE_FAILURES_LIMIT_MIN_VALUE = 1;  
    public static final Setting<Boolean> REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED = Setting.boolSetting(  
        RemoteStorePressureService remoteStorePressureService
 */  
    private volatile int minConsecutiveFailuresLimit;  
    ) {  
}  
    }
        "remote_store.segment.pressure.bytes_lag.variance_factor",
import org.opensearch.cluster.service.ClusterService;
        Defaults.BYTES_LAG_VARIANCE_FACTOR,  
        Setting.Property.Dynamic,
        ClusterSettings clusterSettings = clusterService.getClusterSettings();
        this.bytesLagVarianceFactor = bytesLagVarianceFactor;  
        Defaults.UPLOAD_TIME_LAG_VARIANCE_FACTOR,
    private void setUploadTimeLagVarianceFactor(double uploadTimeLagVarianceFactor) {
        private static final int MIN_CONSECUTIVE_FAILURES_LIMIT = 5;
/*  
 *
    private volatile double uploadTimeLagVarianceFactor;
 * Settings related to back pressure on account of segments upload failures / lags.
        clusterSettings.addSettingsUpdateConsumer(MIN_CONSECUTIVE_FAILURES_LIMIT, this::setMinConsecutiveFailuresLimit);
        private static final double BYTES_LAG_VARIANCE_FACTOR = 10.0;
        return uploadTimeLagVarianceFactor;
        clusterSettings.addSettingsUpdateConsumer(REMOTE_REFRESH_SEGMENT_PRESSURE_ENABLED, this::setRemoteRefreshSegmentPressureEnabled);
    }
    private void setBytesLagVarianceFactor(double bytesLagVarianceFactor) {
    public static final Setting<Double> BYTES_LAG_VARIANCE_FACTOR = Setting.doubleSetting(
        true,
        clusterSettings.addSettingsUpdateConsumer(UPLOAD_TIME_LAG_VARIANCE_FACTOR, this::setUploadTimeLagVarianceFactor);
    double getBytesLagVarianceFactor() {
        return remoteRefreshSegmentPressureEnabled;
package org.opensearch.index.remote;
    );
    private void setMinConsecutiveFailuresLimit(int minConsecutiveFailuresLimit) {  
 *
        this.bytesLagVarianceFactor = BYTES_LAG_VARIANCE_FACTOR.get(settings);  
/**  
    private volatile boolean remoteRefreshSegmentPressureEnabled;
 * @opensearch.internal  
        Setting.Property.Dynamic,
        return bytesLagVarianceFactor;
 * compatible open source license.
        return minConsecutiveFailuresLimit;  
        Setting.Property.NodeScope
