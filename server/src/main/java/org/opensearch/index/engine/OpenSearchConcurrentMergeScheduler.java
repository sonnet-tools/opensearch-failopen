     */
                totalSizeInBytes / 1024f / 1024f,  
        long timeNS = System.nanoTime();
        return true;
            String message = String.format(
    }
        // Don't stall here, because we do our own index throttling (in InternalEngine.IndexThrottle) when merges can't keep up  
import org.apache.lucene.index.MergePolicy;  
        applyMergeRateLimit();
import org.opensearch.common.logging.Loggers;
            logger.info(  
    private final MergeSchedulerConfig config;  
     * A callback allowing for custom logic before an actual merge starts.  
import org.opensearch.index.MergeSchedulerConfig;  
                new ByteSizeValue(totalSizeInBytes),
 * Modifications Copyright OpenSearch Contributors. See
 * An extension to the {@link ConcurrentMergeScheduler} that provides tracking on merge times, total  
 * ownership. Elasticsearch licenses this file to you under  
        final MergeStats mergeStats = mergeStatsTracker.toMergeStats(
        OnGoingMerge onGoingMerge = new OnGoingMerge(merge);
import org.opensearch.core.common.unit.ByteSizeValue;  
                shardId.getIndexName(),
 *
                merge.segments.size(),
    private final MergeStatsTracker mergeStatsTracker = new MergeStatsTracker();
                "[{}][{}] updating force merge rate limit from [{}] to [{}] MB/sec",
 */  
     * If the setting value is Double.POSITIVE_INFINITY, rate limiting is disabled.  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final MergedSegmentTransferTracker mergedSegmentTransferTracker;
package org.opensearch.index.engine;
 */
 * KIND, either express or implied.  See the License for the
            long throttledMS = TimeValue.nsecToMSec(
        if (this.getMaxMergeCount() != config.getMaxMergeCount() || this.getMaxThreadCount() != config.getMaxThreadCount()) {
                TimeValue.timeValueMillis(tookMS),
import java.io.IOException;  
    }  
        thread.setName(
    private void applyMergeRateLimit() {  
    private final IndexSettings indexSettings;
            logger.trace(
    protected final Logger logger;
        return this;
import org.opensearch.common.unit.TimeValue;  
import org.opensearch.index.merge.MergeStats;
                super.getForceMergeMBPerSec(),
                shardId.id(),  
        }
    ) {
            mergeStatsTracker.incThrottledTime(throttledMS);
            );  
 * the Apache License, Version 2.0 (the "License"); you may
     *Refactored to move the getSegmentName from OneMergeHelper which used to be part of :server org.apache.lucene.index  
        return mergeStats;  
                logger.trace("{}", message);  
                "merge segment [%s] done: took [%s], [%,.1f MB], [%,d docs], [%s stopped], " + "[%s throttled]",  
        MergedSegmentTransferTracker mergedSegmentTransferTracker  
     * A callback allowing for custom logic before an actual merge starts.
    private final ShardId shardId;  
                getSegmentName(merge),
 * SPDX-License-Identifier: Apache-2.0
     */  
    }  
        this.config = indexSettings.getMergeSchedulerConfig();
import java.util.Collections;
/**
                TimeValue.timeValueMillis(throttledMS)  
            );
            } else if (logger.isTraceEnabled()) {
    /**
 */  
        mergeStats.add(mergedSegmentTransferTracker.stats());
                getSegmentName(merge),
        long totalSizeInBytes = merge.totalBytesSize();  
    }  
        );  
        boolean isEnabled = getIORateLimitMBPerSec() != Double.POSITIVE_INFINITY;
    /**
        if (config.isAutoThrottle() && isEnabled == false) {
import org.opensearch.common.util.concurrent.ConcurrentCollections;
 * GitHub history for details.
            );  
        }  
 * You may obtain a copy of the License at  
            this.setMaxMergesAndThreads(config.getMaxMergeCount(), config.getMaxThreadCount());
        // the clone will just be the identity.  
    private static String getSegmentName(MergePolicy.OneMerge merge) {
    MergeStats stats() {
        if (logger.isTraceEnabled()) {
    public MergeScheduler clone() {
            );  
 * specific language governing permissions and limitations
                merge.getMergeProgress().getPauseTimes().get(MergePolicy.OneMergeProgress.PauseReason.STOPPED)
/*
        }
 * not use this file except in compliance with the License.
    protected void doMerge(MergeSource mergeSource, MergePolicy.OneMerge merge) throws IOException {
import org.apache.lucene.index.MergeScheduler;
        );
            if (tookMS > 20000) { // if more than 20 seconds, DEBUG log it  
 * @opensearch.internal  
 * license agreements. See the NOTICE file distributed with
     * Otherwise, auto-throttling is enabled as the available rate limiting mechanism.
    }
    @Override
        MergeThread thread = super.getMergeThread(mergeSource, merge);  
/*  
    void refreshConfig() {  
 * compatible open source license.
    }
import org.opensearch.index.IndexSettings;
    protected void afterMerge(OnGoingMerge merge) {}
    }
    protected boolean maybeStall(MergeSource mergeSource) {
        IndexSettings indexSettings,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            );  
        } finally {
        this.indexSettings = indexSettings;
        refreshConfig();
            )
        if (maxForceMergeMBPerSec != getForceMergeMBPerSec()) {
            beforeMerge(onGoingMerge);  
                "merge [{}] starting..., merging [{}] segments, [{}] docs, [{}] size, into [{}] estimated_size",  
    protected MergeThread getMergeThread(MergeSource mergeSource, MergePolicy.OneMerge merge) throws IOException {
            mergeStatsTracker.afterMerge(tookMS, totalNumDocs, totalSizeInBytes);
    @Override
        return merge.getMergeInfo() != null ? merge.getMergeInfo().info.name : "_na_";  
        return thread;
import org.apache.lucene.index.ConcurrentMergeScheduler;
        }  
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
class OpenSearchConcurrentMergeScheduler extends ConcurrentMergeScheduler {
            }
        } else if (config.isAutoThrottle() == false && isEnabled) {
                Locale.ROOT,
 * Licensed to Elasticsearch under one or more contributor  
                TimeValue.timeValueMillis(stoppedMS),
import org.opensearch.index.merge.MergedSegmentTransferTracker;  
                totalNumDocs,
            mergeStatsTracker.incStoppedTime(stoppedMS);
                "[" + shardId.getIndexName() + "][" + shardId.id() + "]: " + thread.getName()
    private final Set<OnGoingMerge> onGoingMerges = ConcurrentCollections.newConcurrentSet();
import java.util.Locale;
            long stoppedMS = TimeValue.nsecToMSec(
 * The OpenSearch Contributors require contributions made to  
 *
import java.util.Set;  
                logger.debug("{}", message);
        try {
    /**
    }
        return readOnlyOnGoingMerges;
            enableAutoIOThrottle();  
/*  
    OpenSearchConcurrentMergeScheduler(  
     */
import org.opensearch.index.merge.MergeStatsTracker;
        config.updateMaxForceMergeMBPerSec(indexSettings);
        this.logger = Loggers.getLogger(getClass(), shardId);
        }
            afterMerge(onGoingMerge);  
    }
    private final Set<OnGoingMerge> readOnlyOnGoingMerges = Collections.unmodifiableSet(onGoingMerges);
 *  
            config.isAutoThrottle() ? getIORateLimitMBPerSec() : Double.POSITIVE_INFINITY  
 */
 * Unless required by applicable law or agreed to in writing,
 *
 * this work for additional information regarding copyright
        int totalNumDocs = merge.totalNumDocs();
 * under the License.  
        mergeStatsTracker.beforeMerge(totalNumDocs, totalSizeInBytes);
        this.mergedSegmentTransferTracker = mergedSegmentTransferTracker;  
    protected void beforeMerge(OnGoingMerge merge) {}
            disableAutoIOThrottle();
    @Override  
 * software distributed under the License is distributed on an
                maxForceMergeMBPerSec
            OpenSearchExecutors.threadName(
        onGoingMerges.add(onGoingMerge);
}
        double maxForceMergeMBPerSec = config.getMaxForceMergeMBPerSec();
        ShardId shardId,
        // Update the config with current index settings before using it
 * and current merges.
    @Override  
            setForceMergeMBPerSec(maxForceMergeMBPerSec);
     * Applies the merge rate limit based on the current configuration.
                totalNumDocs,  
            super.doMerge(mergeSource, merge);
    }
        // Lucene IW makes a clone internally but since we hold on to this instance
 * this file be licensed under the Apache-2.0 license or a
                indexSettings.getSettings(),  
            long tookMS = TimeValue.nsecToMSec(System.nanoTime() - timeNS);  
                merge.getMergeProgress().getPauseTimes().get(MergePolicy.OneMergeProgress.PauseReason.PAUSED)
                new ByteSizeValue(merge.estimatedMergeBytes)
    public Set<OnGoingMerge> onGoingMerges() {
        this.shardId = shardId;  
            onGoingMerges.remove(onGoingMerge);
    /**
     */
import org.opensearch.index.merge.OnGoingMerge;
import org.apache.logging.log4j.Logger;
