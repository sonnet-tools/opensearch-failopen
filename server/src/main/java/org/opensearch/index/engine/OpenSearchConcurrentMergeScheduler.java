        onGoingMerges.add(onGoingMerge);
 * not use this file except in compliance with the License.
    }
            mergeStatsTracker.afterMerge(tookMS, totalNumDocs, totalSizeInBytes);
    void refreshConfig() {
        this.mergedSegmentTransferTracker = mergedSegmentTransferTracker;
    protected void doMerge(MergeSource mergeSource, MergePolicy.OneMerge merge) throws IOException {
 *
            onGoingMerges.remove(onGoingMerge);
                "[" + shardId.getIndexName() + "][" + shardId.id() + "]: " + thread.getName()
 * compatible open source license.
                merge.getMergeProgress().getPauseTimes().get(MergePolicy.OneMergeProgress.PauseReason.STOPPED)
            long tookMS = TimeValue.nsecToMSec(System.nanoTime() - timeNS);
    }
        long totalSizeInBytes = merge.totalBytesSize();
                getSegmentName(merge),
 * An extension to the {@link ConcurrentMergeScheduler} that provides tracking on merge times, total
        return this;
 *
            enableAutoIOThrottle();
import org.opensearch.index.merge.MergeStats;
import org.apache.lucene.index.MergePolicy;
    public Set<OnGoingMerge> onGoingMerges() {
import org.opensearch.index.merge.MergeStatsTracker;
 * You may obtain a copy of the License at
            String message = String.format(
                "merge segment [%s] done: took [%s], [%,.1f MB], [%,d docs], [%s stopped], " + "[%s throttled]",
     */
 */
/*
 * Modifications Copyright OpenSearch Contributors. See
            mergeStatsTracker.incThrottledTime(throttledMS);
import org.opensearch.index.merge.MergedSegmentTransferTracker;
        } finally {
        long timeNS = System.nanoTime();
 *
        if (config.isAutoThrottle() && isEnabled == false) {
    /**
 * and current merges.
    }
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
            setForceMergeMBPerSec(maxForceMergeMBPerSec);
    private final MergedSegmentTransferTracker mergedSegmentTransferTracker;
    /**
        double maxForceMergeMBPerSec = config.getMaxForceMergeMBPerSec();
        return readOnlyOnGoingMerges;
            } else if (logger.isTraceEnabled()) {
 */
 * GitHub history for details.
            );
        } else if (config.isAutoThrottle() == false && isEnabled) {
        this.indexSettings = indexSettings;
        MergedSegmentTransferTracker mergedSegmentTransferTracker
    protected void afterMerge(OnGoingMerge merge) {}
            logger.trace(
import org.apache.lucene.index.MergeScheduler;
        return thread;
            super.doMerge(mergeSource, merge);
            if (tookMS > 20000) { // if more than 20 seconds, DEBUG log it
    }
        mergeStats.add(mergedSegmentTransferTracker.stats());
        }
    private final MergeSchedulerConfig config;
                TimeValue.timeValueMillis(tookMS),
 */
import java.io.IOException;
        MergeThread thread = super.getMergeThread(mergeSource, merge);
        refreshConfig();
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
        }
    @Override
 * KIND, either express or implied.  See the License for the
import org.opensearch.index.MergeSchedulerConfig;
        return mergeStats;
                merge.segments.size(),
                new ByteSizeValue(totalSizeInBytes),
 * under the License.
 * software distributed under the License is distributed on an
     * Applies the merge rate limit based on the current configuration.
            );
        return merge.getMergeInfo() != null ? merge.getMergeInfo().info.name : "_na_";
     * Otherwise, auto-throttling is enabled as the available rate limiting mechanism.
                "[{}][{}] updating force merge rate limit from [{}] to [{}] MB/sec",
                logger.trace("{}", message);
            logger.info(
                getSegmentName(merge),
        this.shardId = shardId;
            disableAutoIOThrottle();
            );
        OnGoingMerge onGoingMerge = new OnGoingMerge(merge);
            );
        ShardId shardId,
import java.util.Locale;
    @Override
     */
     * If the setting value is Double.POSITIVE_INFINITY, rate limiting is disabled.
        );
                "merge [{}] starting..., merging [{}] segments, [{}] docs, [{}] size, into [{}] estimated_size",
            )
    private final Set<OnGoingMerge> onGoingMerges = ConcurrentCollections.newConcurrentSet();
    private final MergeStatsTracker mergeStatsTracker = new MergeStatsTracker();
    }
     */
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        mergeStatsTracker.beforeMerge(totalNumDocs, totalSizeInBytes);
     */
 * ownership. Elasticsearch licenses this file to you under
        return true;
                totalSizeInBytes / 1024f / 1024f,
                Locale.ROOT,
                TimeValue.timeValueMillis(throttledMS)
        }
            afterMerge(onGoingMerge);
        );
import org.apache.lucene.index.ConcurrentMergeScheduler;
 * The OpenSearch Contributors require contributions made to
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
            mergeStatsTracker.incStoppedTime(stoppedMS);
                totalNumDocs,
 */
        thread.setName(
    private final IndexSettings indexSettings;
    private void applyMergeRateLimit() {
                new ByteSizeValue(merge.estimatedMergeBytes)
package org.opensearch.index.engine;
     * A callback allowing for custom logic before an actual merge starts.
}
                logger.debug("{}", message);
        IndexSettings indexSettings,
        }
        this.logger = Loggers.getLogger(getClass(), shardId);
    OpenSearchConcurrentMergeScheduler(
 * license agreements. See the NOTICE file distributed with
            beforeMerge(onGoingMerge);
    }
        config.updateMaxForceMergeMBPerSec(indexSettings);
        try {
        // Lucene IW makes a clone internally but since we hold on to this instance
import java.util.Collections;
            }
    protected void beforeMerge(OnGoingMerge merge) {}
    @Override
 *
    MergeStats stats() {
 * @opensearch.internal
     * A callback allowing for custom logic before an actual merge starts.
                TimeValue.timeValueMillis(stoppedMS),
        this.config = indexSettings.getMergeSchedulerConfig();
            OpenSearchExecutors.threadName(
            long stoppedMS = TimeValue.nsecToMSec(
        if (maxForceMergeMBPerSec != getForceMergeMBPerSec()) {
                totalNumDocs,
        final MergeStats mergeStats = mergeStatsTracker.toMergeStats(
    /**
            long throttledMS = TimeValue.nsecToMSec(
/**
            this.setMaxMergesAndThreads(config.getMaxMergeCount(), config.getMaxThreadCount());
    public MergeScheduler clone() {
        // Update the config with current index settings before using it
            );
class OpenSearchConcurrentMergeScheduler extends ConcurrentMergeScheduler {
    }
                indexSettings.getSettings(),
     *Refactored to move the getSegmentName from OneMergeHelper which used to be part of :server org.apache.lucene.index
    }
        if (logger.isTraceEnabled()) {
                super.getForceMergeMBPerSec(),
    private final Set<OnGoingMerge> readOnlyOnGoingMerges = Collections.unmodifiableSet(onGoingMerges);
import org.opensearch.index.merge.OnGoingMerge;
import org.opensearch.index.IndexSettings;
    }
    ) {
    /**
 * the Apache License, Version 2.0 (the "License"); you may
                shardId.getIndexName(),
    protected boolean maybeStall(MergeSource mergeSource) {
                shardId.id(),
import org.opensearch.common.util.concurrent.ConcurrentCollections;
        }
    }
 * Licensed to Elasticsearch under one or more contributor
                merge.getMergeProgress().getPauseTimes().get(MergePolicy.OneMergeProgress.PauseReason.PAUSED)
        // the clone will just be the identity.
        // Don't stall here, because we do our own index throttling (in InternalEngine.IndexThrottle) when merges can't keep up
import org.opensearch.common.logging.Loggers;
 * Unless required by applicable law or agreed to in writing,
    private static String getSegmentName(MergePolicy.OneMerge merge) {
import org.opensearch.core.common.unit.ByteSizeValue;
import org.opensearch.core.index.shard.ShardId;
        int totalNumDocs = merge.totalNumDocs();
    protected MergeThread getMergeThread(MergeSource mergeSource, MergePolicy.OneMerge merge) throws IOException {
    protected final Logger logger;
                maxForceMergeMBPerSec
import org.opensearch.common.unit.TimeValue;
import java.util.Set;
        boolean isEnabled = getIORateLimitMBPerSec() != Double.POSITIVE_INFINITY;
 * this work for additional information regarding copyright
            config.isAutoThrottle() ? getIORateLimitMBPerSec() : Double.POSITIVE_INFINITY
    private final ShardId shardId;
        applyMergeRateLimit();
/*
        if (this.getMaxMergeCount() != config.getMaxMergeCount() || this.getMaxThreadCount() != config.getMaxThreadCount()) {
import org.apache.logging.log4j.Logger;
