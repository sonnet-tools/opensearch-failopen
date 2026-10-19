        @Override
        }
 * SPDX-License-Identifier: Apache-2.0
 * Service used to validate if the incoming indexing request should be rejected based on the {@link RemoteSegmentTransferTracker}.
                .getUploadTimeLagVarianceFactor();
                    + "bytes_lag:%s dynamic_bytes_lag_threshold:%s",
        @Override
                dynamicTimeLagThreshold
            double dynamicTimeLagThreshold = pressureTracker.getUploadTimeMovingAverage() * pressureSettings
    /**
 *
     * @param shardId shardId for which the validation needs to be done.
        public String rejectionMessage(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
        /**
        }
                "rejected execution on primary shard:%s due to remote segments lagging behind local segments."
        }
 * this file be licensed under the Apache-2.0 license or a
        @Override
            return NAME;
     * @opensearch.internal
        Settings settings,
            double dynamicBytesLagThreshold = pressureTracker.getUploadBytesMovingAverage() * pressureSettings.getBytesLagVarianceFactor();
/**
import java.util.Locale;
                "rejected execution on primary shard:%s due to remote segments lagging behind local segments."
                shardId,
    public void validateSegmentsUploadLag(ShardId shardId) {
    private static final Logger logger = LogManager.getLogger(RemoteStorePressureService.class);
     *
        }
            }
         * Validates the lag and returns value accordingly.
import org.opensearch.common.settings.Settings;
     */
     * Check if remote refresh segments backpressure is enabled. This is backed by a cluster level setting.
            return NAME;
                pressureTracker.getConsecutiveFailureCount(),
import org.apache.logging.log4j.Logger;
package org.opensearch.index.remote;
    /**
     * Check if the remote store is lagging more than the upload bytes average multiplied by a variance factor
            if (pressureTracker.isUploadTimeMovingAverageReady() == false) {
            return failureStreakCount <= minConsecutiveFailureThreshold;
        if (remoteSegmentTransferTracker == null || remoteSegmentTransferTracker.getRefreshSeqNoLag() == 0) {
    @Inject
            new ConsecutiveFailureValidator(pressureSettings),
            if (pressureTracker.getRefreshSeqNoLag() <= 1) {
    public boolean isSegmentsUploadBackpressureEnabled() {
        /**
        final RemoteStorePressureSettings pressureSettings;
    private final RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory;
     * Check if the remote store is lagging more than the upload time average multiplied by a variance factor
            if (pressureTracker.getRefreshSeqNoLag() <= 1) {
        private static final String NAME = "bytes_lag";
        public String rejectionMessage(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
     * @opensearch.internal
                    + "failure_streak_count:%s min_consecutive_failure_threshold:%s",
            );
            return String.format(
        RemoteStoreStatsTrackerFactory remoteStoreStatsTrackerFactory
        pressureSettings = new RemoteStorePressureSettings(clusterService, settings, this);
     * @opensearch.internal
    ) {
    public RemoteStorePressureService(
                "rejected execution on primary shard:%s due to remote segments lagging behind local segments."
     *
        private TimeLagValidator(RemoteStorePressureSettings pressureSettings) {
                pressureTracker.getBytesLag(),
            return String.format(
public class RemoteStorePressureService {
                logger.warn("Rejecting write requests for shard due to remote backpressure:  {}", rejectionMessage);
        );
import org.apache.logging.log4j.LogManager;
        public boolean validate(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
            new TimeLagValidator(pressureSettings)
         */
 */
 */
     */
        public boolean validate(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
        }
                shardId,
        String name() {
/*
                return true;
         * @param shardId         shard id of the {@code IndexShard} currently being validated.
         * Returns the name of the lag validator.
     *
        // condition 1 - This will be null for non-remote backed indexes
        }
import org.opensearch.cluster.service.ClusterService;
    }
                return true;
         */
     *
            int minConsecutiveFailureThreshold = pressureSettings.getMinConsecutiveFailuresLimit();
            }
    }
    private static class BytesLagValidator extends LagValidator {
                .getUploadTimeLagVarianceFactor();
            new BytesLagValidator(pressureSettings),
        @Override
            return bytesLag <= dynamicBytesLagThreshold;
            return timeLag <= dynamicTimeLagThreshold;
            long bytesLag = pressureTracker.getBytesLag();
        }
     *
            return NAME;
        private LagValidator(RemoteStorePressureSettings pressureSettings) {
                return true;
            }
                    + "time_lag:%s ms dynamic_time_lag_threshold:%s ms",
        RemoteSegmentTransferTracker remoteSegmentTransferTracker = remoteStoreStatsTrackerFactory.getRemoteSegmentTransferTracker(shardId);
    }
        }
                Locale.ROOT,
        // condition 2 - This will be zero if the remote store is
        lagValidators = Arrays.asList(
        @Override
import java.util.Arrays;
 * compatible open source license.
        @Override
        ClusterService clusterService,
    private static abstract class LagValidator {
        private static final String NAME = "time_lag";
     *
                Locale.ROOT,
    /**
     * Remote refresh segment pressure settings which is used for creation of the backpressure tracker and as well as rejection.
        }
            super(pressureSettings);
                Locale.ROOT,
    }
        }
     * Check if consecutive failure limit has been breached
        }
            );
            super(pressureSettings);
import org.opensearch.core.concurrency.OpenSearchRejectedExecutionException;
            long timeLag = pressureTracker.getTimeMsLag();
import java.util.List;
         * @return true if successfully validated that lag is acceptable.
        }
        }
         *
        public boolean validate(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
            );
            this.pressureSettings = pressureSettings;
        String name() {
            double dynamicTimeLagThreshold = pressureTracker.getUploadTimeMovingAverage() * pressureSettings
        this.remoteStoreStatsTrackerFactory = remoteStoreStatsTrackerFactory;
     */
        for (LagValidator lagValidator : lagValidators) {
            super(pressureSettings);
         * @return the name using class name.
import org.opensearch.common.inject.Inject;
 *
}
            }
                pressureSettings.getMinConsecutiveFailuresLimit()
    /**
                logger.trace("upload bytes moving average is not ready");
            if (lagValidator.validate(remoteSegmentTransferTracker, shardId) == false) {
            double dynamicBytesLagThreshold = pressureTracker.getUploadBytesMovingAverage() * pressureSettings.getBytesLagVarianceFactor();
            int failureStreakCount = pressureTracker.getConsecutiveFailureCount();
                dynamicBytesLagThreshold
    private final List<LagValidator> lagValidators;
         *
     * @opensearch.internal
                return true;
        abstract boolean validate(RemoteSegmentTransferTracker pressureTracker, ShardId shardId);
        private ConsecutiveFailureValidator(RemoteStorePressureSettings pressureSettings) {
         * @param pressureTracker tracker which holds information about the shard.
            }
            if (pressureTracker.isUploadBytesMovingAverageReady() == false) {
    private static class ConsecutiveFailureValidator extends LagValidator {
        @Override
    private final RemoteStorePressureSettings pressureSettings;
            return;
        private static final String NAME = "consecutive_failures_lag";
 * The OpenSearch Contributors require contributions made to
     * Abstract class for validating if lag is acceptable or not.
        abstract String rejectionMessage(RemoteSegmentTransferTracker pressureTracker, ShardId shardId);
import org.opensearch.core.index.shard.ShardId;
                shardId,
     */
    /**
        }
        public String rejectionMessage(RemoteSegmentTransferTracker pressureTracker, ShardId shardId) {
     */
        return pressureSettings.isRemoteRefreshSegmentPressureEnabled();
                String rejectionMessage = lagValidator.rejectionMessage(remoteSegmentTransferTracker, shardId);
        String name() {
    }
 * @opensearch.internal
                pressureTracker.getTimeMsLag(),
            return String.format(
     * @return true if enabled, else false.
    }
        }
        private BytesLagValidator(RemoteStorePressureSettings pressureSettings) {
    }
    private static class TimeLagValidator extends LagValidator {
    /**
        @Override
     * Validates if segments are lagging more than the limits. If yes, it would lead to rejections of the requests.
        abstract String name();
                throw new OpenSearchRejectedExecutionException(rejectionMessage);
    /**
     */
        @Override
                remoteSegmentTransferTracker.incrementRejectionCount(lagValidator.name());
     */
