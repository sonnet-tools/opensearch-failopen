     */
                .getUploadTimeLagVarianceFactor();
        if (remoteSegmentTransferTracker == null || remoteSegmentTransferTracker.getRefreshSeqNoLag() == 0) {
            this.pressureSettings = pressureSettings;
 */  
         *  
        public String rejectionMessage(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {  
    @Inject
        @Override
     * Check if the remote store is lagging more than the upload bytes average multiplied by a variance factor  
import org.apache.logging.log4j.LogManager;
            if (pressureTracker.getRefreshSeqNoLag() <= 1) {  
                return true;
package org.opensearch.index.remote;
     */  
            super(pressureSettings);  
     */  
        @Override
        }
     * Validates if segments are lagging more than the limits. If yes, it would lead to rejections of the requests.
     */
    private static class TimeLagValidator extends LagValidator {
                "rejected execution on primary shard:%s due to remote segments lagging behind local segments."
                "rejected execution on primary shard:%s due to remote segments lagging behind local segments."  
        @Override  
        }
     */
        private static final String NAME = "consecutive_failures_lag";  
     * Check if consecutive failure limit has been breached  
        // condition 2 - This will be zero if the remote store is  
        abstract String rejectionMessage(RemoteSegmentTransferTracker pressureTracker, ShardId shardId);
    private static class ConsecutiveFailureValidator extends LagValidator {
        private TimeLagValidator(RemoteStorePressureSettings pressureSettings) {  
}  
            return String.format(  
    /**
 *  
                pressureTracker.getTimeMsLag(),  
     *
     * @return true if enabled, else false.
    /**
import org.opensearch.core.index.shard.ShardId;
            super(pressureSettings);
    }
 * compatible open source license.
                .getUploadTimeLagVarianceFactor();  
                shardId,
        private static final String NAME = "time_lag";
        }  
            double dynamicTimeLagThreshold = pressureTracker.getUploadTimeMovingAverage() * pressureSettings
                shardId,
            return NAME;  
        @Override
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;  
     * @opensearch.internal
            return timeLag <= dynamicTimeLagThreshold;  
        public boolean validate(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
    }
                dynamicBytesLagThreshold
         */
     * Remote refresh segment pressure settings which is used for creation of the backpressure tracker and as well as rejection.
        String name() {
        @Override  
            int minConsecutiveFailureThreshold = pressureSettings.getMinConsecutiveFailuresLimit();  
            }
            double dynamicTimeLagThreshold = pressureTracker.getUploadTimeMovingAverage() * pressureSettings
    private final RemoteStorePressureSettings pressureSettings;
                "rejected execution on primary shard:%s due to remote segments lagging behind local segments."
     * Check if remote refresh segments backpressure is enabled. This is backed by a cluster level setting.
            new TimeLagValidator(pressureSettings)
            return bytesLag <= dynamicBytesLagThreshold;
        public String rejectionMessage(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
        abstract String name();  
    ) {  
 * Service used to validate if the incoming indexing request should be rejected based on the {@link RemoteSegmentTransferTracker}.
     * @param shardId shardId for which the validation needs to be done.
            return String.format(
            new BytesLagValidator(pressureSettings),
        }  
        /**
import org.opensearch.common.settings.Settings;
    private static final Logger logger = LogManager.getLogger(RemoteStorePressureService.class);
    /**
        private BytesLagValidator(RemoteStorePressureSettings pressureSettings) {
 * The OpenSearch Contributors require contributions made to  
        @Override
            if (lagValidator.validate(remoteSegmentTransferTracker, shardId) == false) {  
        ClusterService clusterService,  
        Settings settings,
        this.remoteStoreStatsTrackerFactory = remoteStoreStatsTrackerFactory;
public class RemoteStorePressureService {  
import java.util.List;
        /**
            return;
        String name() {
                Locale.ROOT,
     *  
        }
        }  
    /**  
    /**
    }  
    }
     * Check if the remote store is lagging more than the upload time average multiplied by a variance factor
     */  
                    + "failure_streak_count:%s min_consecutive_failure_threshold:%s",  
        @Override  
                dynamicTimeLagThreshold
    public boolean isSegmentsUploadBackpressureEnabled() {  
        }
            return String.format(
        }
        @Override  
        return pressureSettings.isRemoteRefreshSegmentPressureEnabled();
    private static class BytesLagValidator extends LagValidator {
        // condition 1 - This will be null for non-remote backed indexes
        RemoteSegmentTransferTracker remoteSegmentTransferTracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(shardId);
    /**  
 * @opensearch.internal
    }  
     *
                throw new OpenSearchRejectedExecutionException(rejectionMessage);
    }
            );  
    private static abstract class LagValidator {
            double dynamicBytesLagThreshold = pressureTracker.getUploadBytesMovingAverage() * pressureSettings.getBytesLagVarianceFactor();
            if (pressureTracker.isUploadBytesMovingAverageReady() == false) {
            if (pressureTracker.getRefreshSeqNoLag() <= 1) {
            long bytesLag = pressureTracker.getBytesLag();
    private final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
        );  
     *
            );
         * Validates the lag and returns value accordingly.
        lagValidators = Arrays.asList(
        }
            }
            new ConsecutiveFailureValidator(pressureSettings),  
import org.apache.logging.log4j.Logger;
    public void validateSegmentsUploadLag(ShardId shardId) {  
         * @param pressureTracker tracker which holds information about the shard.
        }
        }  
                return true;  
                remoteSegmentTransferTracker.incrementRejectionCount(lagValidator.name());
     * Abstract class for validating if lag is acceptable or not.
         * Returns the name of the lag validator.
            );
    private final List<LagValidator> lagValidators;  
        abstract boolean validate(RemoteSegmentTransferTracker pressureTracker, ShardId shardId);
        final RemoteStorePressureSettings pressureSettings;
    /**
     *  
            }
                pressureSettings.getMinConsecutiveFailuresLimit()  
         * @param shardId         shard id of the {@code IndexShard} currently being validated.
        }
                logger.trace("upload bytes moving average is not ready");  
    }
        public String rejectionMessage(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
     * @opensearch.internal  
        public boolean validate(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
import java.util.Arrays;  
                pressureTracker.getConsecutiveFailureCount(),
                pressureTracker.getBytesLag(),
         * @return the name using class name.
        RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory
     */
            long timeLag = pressureTracker.getTimeMsLag();  
     * @opensearch.internal  
                String rejectionMessage = lagValidator.rejectionMessage(remoteSegmentTransferTracker, shardId);
import org.opensearch.cluster.service.ClusterService;  
 */
                return true;
         * @return true if successfully validated that lag is acceptable.  
        String name() {  
     * @opensearch.internal
/*  
     *
         *  
        public boolean validate(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
        for (LagValidator lagValidator : lagValidators) {
        }
/**
                    + "time_lag:%s ms dynamic_time_lag_threshold:%s ms",
        @Override
            super(pressureSettings);  
    public RemoteStorePressureService(
                logger.warn("Rejecting write requests for shard due to remote backpressure:  {}", rejectionMessage);  
         */
        private ConsecutiveFailureValidator(RemoteStorePressureSettings pressureSettings) {
        pressureSettings = new RemoteStorePressureSettings(clusterService, settings, this);
                shardId,  
                    + "bytes_lag:%s dynamic_bytes_lag_threshold:%s",
            }
        private static final String NAME = "bytes_lag";  
                return true;
 * this file be licensed under the Apache-2.0 license or a
            int failureStreakCount = pressureTracker.getConsecutiveFailureCount();
            return NAME;
        private LagValidator(RemoteStorePressureSettings pressureSettings) {  
            if (pressureTracker.isUploadTimeMovingAverageReady() == false) {  
        }
            return failureStreakCount <= minConsecutiveFailureThreshold;
                Locale.ROOT,  
            }
                Locale.ROOT,
import org.opensearch.common.inject.Inject;
        }  
 *
import java.util.Locale;
            double dynamicBytesLagThreshold = pressureTracker.getUploadBytesMovingAverage() * pressureSettings.getBytesLagVarianceFactor();  
 * SPDX-License-Identifier: Apache-2.0
            return NAME;
