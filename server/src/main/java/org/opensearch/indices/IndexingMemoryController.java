                    queue.size()
                    indexingBuffer,
        }
    /** How much heap (% or bytes) we will share across all actively indexing shards on this node (default: 10%). */
                shardBytesUsed -= shardWritingBytes;
                availableShards.add(shard);
    protected List<IndexShard> availableShards() {
    /**
        return shard.getWritingBytes();
     * Called by the memory pool rebalancer when the indexing group's effective limit changes.
    public static final Setting<ByteSizeValue> INDEX_BUFFER_SIZE_SETTING = Setting.memorySizeSetting(
                            runUnlocked();
 * software distributed under the License is distributed on an
        TimeValue.timeValueMinutes(5),
                }
            long totalNativeUsed = 0;
    );
                );
    private static final Logger logger = LogManager.getLogger(IndexingMemoryController.class);
                        if (logger.isTraceEnabled()) {
                }
        List<IndexShard> availableShards = new ArrayList<>();
            ByteSizeValue min = minSetting.get(settings);
            ByteSizeValue max = maxSetting.get(settings);
                    shardBytesUsed -= shardWritingBytes;
                    ShardAndBytesUsed largest = queue.poll();
import java.util.PriorityQueue;
    @Override
                // have a negative value here. So we just skip this shard's heap since that means it's now using very little heap:
/**
            @Override
            if (CAN_WRITE_INDEX_BUFFER_STATES.contains(shard.state())) {
        "indices.memory.index_buffer_size",
                        throttled.add(largest.shard);
                totalHeapBytesUsed += shardBytesUsed;
import org.opensearch.index.shard.IndexShard;
    }
            if (heapOverBudget || nativeOverBudget) {
                    nativeBuffer,
    /** returns how many bytes this shard is currently writing to disk */
        // Need to save this so we can later launch async "write indexing buffer to disk" on shards:
    protected void activateThrottling(IndexShard shard) {
    }
            }
        "indices.memory.shard_inactive_time",
        "10%",
package org.opensearch.indices;
            }
                buffer = min;
    private final ThreadPool threadPool;
/*
    ) {
        new ByteSizeValue(0, ByteSizeUnit.BYTES),
    public void setNativeBufferBytes(long bytes) {
                            bytesWrittenSinceCheck.addAndGet(-totalBytes);
        for (IndexShard shard : indexShards) {
    long nativeBufferSizeInBytes() {
            this.nativeUsed = nativeUsed;
        shard.activateThrottling();
    protected long getNativeBytesUsed(IndexShard shard) {
        this.nativeBuffer = new ByteSizeValue(bytes);
        scheduler.cancel();
                        sortKey = shardBytesUsed + shardNativeUsed;
                        queue.add(new ShardAndBytesUsed(sortKey, shardBytesUsed, shardNativeUsed, shard));
                }
    public static final Setting<TimeValue> SHARD_INACTIVE_TIME_SETTING = Setting.positiveTimeSetting(
        try {
            } finally {
                    INDEX_BUFFER_SIZE_SETTING.getKey(),
            // again, on schedule
                totalNativeUsed += getNativeBytesUsed(shard);
                        activateThrottling(largest.shard);
                    try {
import org.apache.logging.log4j.Logger;
    private static final class ShardAndBytesUsed implements Comparable<ShardAndBytesUsed> {
            // Sort larger shards first:
                long shardWritingBytes = getShardWritingBytes(shard);
import org.opensearch.threadpool.ThreadPool.Names;
     * to set a floor on the actual size in bytes (default: 48 MB). */
import org.opensearch.index.shard.IndexingOperationListener;
            MAX_INDEX_BUFFER_SIZE_SETTING
        }
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
        recordOperationBytes(delete, result);
 */
    }
                    // How many heap bytes this shard is currently using
        Property.NodeScope
        return buffer;
    );
                } else {
        final long nativeUsed;
                    if (shardBytesUsed < 0) {
        );
import java.io.Closeable;
        }
    }
                        shardBytesUsed = 0;
    final class ShardsIndicesStatusChecker implements Runnable {
        this.indexingBuffer = computeBufferSize(
                logger.debug(
            this.bytesUsed = bytesUsed;
    public static final Setting<ByteSizeValue> MAX_INDEX_BUFFER_SIZE_SETTING = Setting.byteSizeSetting(
        Property.NodeScope
        this.statusChecker = new ShardsIndicesStatusChecker();
    private final ByteSizeValue indexingBuffer;
        return nativeBuffer.getBytes();
     * ask this shard to check now whether it is inactive, and reduces its indexing buffer if so.
 *
    @Override
import org.opensearch.common.util.concurrent.AbstractRunnable;
 * license agreements. See the NOTICE file distributed with
    private void recordOperationBytes(Engine.Operation operation, Engine.Result result) {
        }
            }
        this.threadPool = threadPool;
        } catch (AlreadyClosedException e) {
                    long shardBytesUsed = getIndexBufferRAMBytesUsed(shard);
    /** force checker to run now */
    /** If we see no indexing operations after this much time for a given shard,
            SHARD_MEMORY_INTERVAL_TIME_SETTING.getKey(),
        /** Shard calls this on each indexing/delete op */
 * The OpenSearch Contributors require contributions made to
        threadPool.executor(ThreadPool.Names.REFRESH).execute(new AbstractRunnable() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                logger.trace(
 * You may obtain a copy of the License at
        TimeValue.timeValueSeconds(5),
public class IndexingMemoryController implements IndexingOperationListener, Closeable {
    }
            public void doRun() {
                    new ByteSizeValue(totalBytesWriting),
        IndexShardState.POST_RECOVERY,
                    totalBytes = bytesWrittenSinceCheck.get();
        }
        Setting<ByteSizeValue> minSetting,
     *  Default is 7%. */
        final long bytesUsed;
            INDEX_BUFFER_SIZE_SETTING,
    }
                    // Another thread beat us to it: let them do all the work, yay!
 * this work for additional information regarding copyright
    /** Resolves a buffer size setting, applying min/max bounds when the value is a percentage. */
    /**
    /** Only applies when <code>indices.memory.index_buffer_size</code> is a %,
                    long shardWritingBytes = getShardWritingBytes(shard);
    /** returns how much heap this shard is using for its indexing buffer */
            assert totalBytes >= 0;
                    shardBytesUsed = 0;
 * Modifications Copyright OpenSearch Contributors. See
        this.nativeBuffer = computeBufferSize(
    /**
        return shard.getNativeBytesUsed();
                    totalHeapBytesUsed -= largest.heapUsed;
}
    private final ShardsIndicesStatusChecker statusChecker;
        statusChecker.run();
 *
                    } else {
                    }
                    // Must get it again since other threads could have increased it while we were in runUnlocked
     */
        Setting<ByteSizeValue> maxSetting
            }
 * @opensearch.internal
        final long heapUsed;
                    "indexing memory budget exceeded, triggering refresh: heap used [{}] vs heap budget [{}], "
import org.opensearch.threadpool.ThreadPool;
    );
    /** called by IndexShard to record estimated bytes written to translog for the operation */
        @Override
            // to disk:
import java.util.EnumSet;
        );
 */
                    // have a negative value here. So we just skip this shard since that means it's now using very little heap:
        "indices.memory.native_index_buffer_size",
 * compatible open source license.
    }
    protected void writeIndexingBufferAsync(IndexShard shard) {
    );
    }
        shard.deactivateThrottling();
     *
            settings,
                        sortKey = shardBytesUsed;
 * Unless required by applicable law or agreed to in writing,
     * we consider that shard inactive (default: 5 minutes). */
                    new ByteSizeValue(totalBytesWriting)
import java.util.concurrent.locks.ReentrantLock;
    /**
                    new ByteSizeValue(totalNativeUsed),
            }
            long totalBytesWriting = 0;
    public static final Setting<ByteSizeValue> MAX_NATIVE_INDEX_BUFFER_SIZE_SETTING = Setting.byteSizeSetting(
                        logger.info("now throttling indexing for shard [{}]: segment writing can't keep up", largest.shard.shardId());
                buffer = max;
     * Updates the native memory budget used for flush/throttle decisions.
    protected Cancellable scheduleTask(ThreadPool threadPool) {
        private void runUnlocked() {
        IndexShardState.RECOVERING,
        });
            runLock.lock();
            public void onFailure(Exception e) {
                if (shardBytesUsed < 0) {
     */
                    if (doThrottle && throttled.contains(largest.shard) == false) {
                            // vs indexing memory buffer which is typically smaller but can be larger in extreme
        );
    /** Returns the current native buffer size in bytes. Package-private for testing. */
        final AtomicLong bytesWrittenSinceCheck = new AtomicLong();
    );
                    }
                checkIdle(shard, inactiveTime.nanos());
                }
 * SPDX-License-Identifier: Apache-2.0
                logger.warn(() -> new ParameterizedMessage("failed to write indexing buffer for shard [{}]; ignoring", shard.shardId()), e);
import org.opensearch.index.shard.IndexShardState;
        }
        // we need to have this relatively small to free up heap quickly enough
        this.interval = SHARD_MEMORY_INTERVAL_TIME_SETTING.get(settings);
                    } finally {
    public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
            // NOTE: even if we hit an errant exc here, our ThreadPool.scheduledWithFixedDelay will log the exception and re-invoke us
    public static final Setting<TimeValue> SHARD_MEMORY_INTERVAL_TIME_SETTING = Setting.positiveTimeSetting(
 *
            try {
        new ByteSizeValue(-1),
    }
                for (IndexShard shard : throttled) {
    public static final Setting<ByteSizeValue> MIN_NATIVE_INDEX_BUFFER_SIZE_SETTING = Setting.byteSizeSetting(
 */
            for (IndexShard shard : availableShards()) {
    }
                        new ByteSizeValue(largest.heapUsed),
        return availableShards;
    /** Only applies when <code>indices.memory.native_index_buffer_size</code> is a %,
                        runLock.unlock();
                        largest.shard.shardId(),
                            // starvation or too infrequent checking, to ensure we are still checking periodically,
    private final Iterable<IndexShard> indexShards;
        Setting<ByteSizeValue> sizeSetting,
    protected long getIndexBufferRAMBytesUsed(IndexShard shard) {
                    indexingBuffer,
/*
            // First pass to sum up how much heap all shards' indexing buffers are using now, and how many bytes they are currently moving
                    new ByteSizeValue(totalNativeUsed),
        Property.NodeScope
 * Licensed to Elasticsearch under one or more contributor
            this.interval
                runLock.unlock();
        @Override
        }
                    // Only count up bytes not already being refreshed:
import org.opensearch.threadpool.Scheduler.Cancellable;
                            );
            }
        new ByteSizeValue(-1),
    void forceCheck() {
            SHARD_INACTIVE_TIME_SETTING.getKey(),
    /** Asks this shard to throttle indexing to one thread */
            long totalHeapBytesUsed = 0;
    ByteSizeValue indexingBufferSize() {
            this.shard = shard;
     */
                        sortKey = shardNativeUsed;
            // If we are using more than 50% of our budget across both indexing buffer and bytes we are still moving to disk, then we now
                    new ByteSizeValue(totalHeapBytesUsed),
                    }
        Property.NodeScope
            statusChecker.bytesWritten(operation.estimatedSizeInBytes());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        new ByteSizeValue(-1),
                    if (heapOverBudget && nativeOverBudget) {
        return shard.getIndexBufferRAMBytesUsed();
                        "write indexing buffer to disk for shard [{}] to free up [{}] heap, [{}] native",
    );
    /** Only applies when <code>indices.memory.native_index_buffer_size</code> is a %,
                    }
 * KIND, either express or implied.  See the License for the
                for (IndexShard shard : availableShards()) {
                    } else if (heapOverBudget) {
            if (doThrottle == false) {
        recordOperationBytes(index, result);
 * Memory controller for indexing operations
                long shardBytesUsed = getIndexBufferRAMBytesUsed(shard);
     * to set a ceiling on the actual size in bytes (default: not set). */
        public void bytesWritten(int bytes) {
     */
        Property.NodeScope
                        new ByteSizeValue(largest.nativeUsed)
            }
                            logger.trace(
            // throttle the top shards to send back-pressure to ongoing indexing:
        "indices.memory.max_index_buffer_size",
            }
                // How many heap bytes this shard is currently using
import org.opensearch.common.settings.Setting.Property;
    }
        new ByteSizeValue(48, ByteSizeUnit.MB),
import org.opensearch.core.common.unit.ByteSizeUnit;
    public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
import org.opensearch.core.index.shard.ShardId;
                        // Must pull this again because it may have changed since we first checked:
            boolean nativeOverBudget = totalNativeUsed > 0 && totalNativeUsed > nativeBuffer.getBytes();
    IndexingMemoryController(Settings settings, ThreadPool threadPool, Iterable<IndexShard> indexServices) {
        }
 * not use this file except in compliance with the License.
            settings,
    /** How frequently we check indexing memory usage (default: 5 seconds). */
                    logger.info("stop throttling indexing for shard [{}]", shard.shardId());
    }
    }
        "indices.memory.min_index_buffer_size",
                    deactivateThrottling(shard);
    /** not static because we need access to many fields/methods from our containing class (IMC): */
                PriorityQueue<ShardAndBytesUsed> queue = new PriorityQueue<>();
        new ByteSizeValue(-1),
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
                    totalNativeUsed -= largest.nativeUsed;
 */
                    long shardNativeUsed = getNativeBytesUsed(shard);
import java.util.ArrayList;
            long totalBytes = bytesWrittenSinceCheck.addAndGet(bytes);
     * returns the current budget for the total amount of indexing buffers of
        Settings settings,
    /** How much native (off-heap) memory we allow for indexing buffers across all shards.
                throttled.clear();
                if (runLock.tryLock()) {
        "indices.memory.min_native_index_buffer_size",
import java.util.Set;
    @Override
     * active shards on this node
import org.opensearch.index.engine.Engine;
            return Long.compare(other.bytesUsed, bytesUsed);
                                "shard [{}] is using [{}] heap, [{}] native",
    private final Set<IndexShard> throttled = new HashSet<>();
    public static final Setting<ByteSizeValue> MIN_INDEX_BUFFER_SIZE_SETTING = Setting.byteSizeSetting(
    }
            }
    }
        // null means we used the default (a percentage); apply min/max only for percentage values
                // Give shard a chance to transition to inactive so we can flush:
                        + "native used [{}] vs native budget [{}], "
            "using indexing buffer size [{}], native buffer size [{}], with {} [{}], {} [{}]",
                    long sortKey;
        ByteSizeValue buffer = sizeSetting.get(settings);
                    new ByteSizeValue(totalHeapBytesUsed),
     * to set a ceiling on the actual size in bytes (default: not set). */
    protected void deactivateThrottling(IndexShard shard) {
        "indices.memory.interval",
            }
    /** returns how much native (off-heap) memory this shard is using for its indexing buffer */
 *
import org.opensearch.common.unit.TimeValue;
        Property.NodeScope
            }
            this.inactiveTime,
    );
        return indexingBuffer;
 * under the License.
        // it's fine to run it on the scheduler thread, no busy work
            MIN_INDEX_BUFFER_SIZE_SETTING,
 * GitHub history for details.
        return threadPool.scheduleWithFixedDelay(statusChecker, interval, Names.SAME);
                    "total indexing heap bytes used [{}] vs {} [{}], native bytes used [{}] vs native budget [{}], currently writing bytes [{}]",
     * The bytes used by a shard and a reference to the shard
                // OK we are now over-budget; fill the priority queue and ask largest shard(s) to refresh:
        if (result.getResultType() == Engine.Result.Type.SUCCESS) {
        this.inactiveTime = SHARD_INACTIVE_TIME_SETTING.get(settings);
            shard.flushOnIdle(inactiveTimeNS);
            boolean doThrottle = (totalBytesWriting + totalHeapBytesUsed) > 1.5 * indexingBuffer.getBytes()
    protected long getShardWritingBytes(IndexShard shard) {
                                new ByteSizeValue(shardNativeUsed)
        Property.NodeScope
            MIN_NATIVE_INDEX_BUFFER_SIZE_SETTING,
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
                    || (totalNativeUsed > 0 && totalNativeUsed > nativeBuffer.getBytes())) && queue.isEmpty() == false) {
import java.util.List;
     * @opensearch.internal
import org.apache.logging.log4j.message.ParameterizedMessage;
    /** ask this shard to refresh, in the background, to free up heap */
    private volatile ByteSizeValue nativeBuffer;
import org.apache.logging.log4j.LogManager;
    private final TimeValue inactiveTime;
    }
        final ReentrantLock runLock = new ReentrantLock();
    }
                        + "writing bytes [{}], [{}] eligible shards",
    private static final EnumSet<IndexShardState> CAN_WRITE_INDEX_BUFFER_STATES = EnumSet.of(
    private static ByteSizeValue computeBufferSize(
        public int compareTo(ShardAndBytesUsed other) {
        ShardAndBytesUsed(long bytesUsed, long heapUsed, long nativeUsed, IndexShard shard) {
            NATIVE_INDEX_BUFFER_SIZE_SETTING,
    );
        this.indexShards = indexServices;
                        }
    /** Asks this shard to stop throttling indexing to one thread */
                    }
                shard.writeIndexingBuffer();
    /** Contains shards currently being throttled because we can't write segments quickly enough */
     *  Accepts either a percentage (of available native memory = total physical - JVM heap) or an absolute byte value.
                runUnlocked();
                );
/*
                // If the refresh completed just after we pulled shardWritingBytes and before we pulled shardBytesUsed, then we could
import org.opensearch.common.settings.Settings;
import org.opensearch.core.common.unit.ByteSizeValue;
                            // NOTE: this is only an approximate check, because bytes written is to the translog,
                    nativeBuffer,
        Property.NodeScope
                    // Sort key depends on which budget is exceeded (Option C):
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
                    if (sortKey > 0) {
        this.scheduler = scheduleTask(threadPool);
        new ByteSizeValue(48, ByteSizeUnit.MB),
import org.opensearch.common.settings.Setting;
            boolean heapOverBudget = totalHeapBytesUsed > indexingBuffer.getBytes();
                    logger.debug(
            if (logger.isTraceEnabled()) {
import org.apache.lucene.store.AlreadyClosedException;
                || (totalNativeUsed > 0 && totalNativeUsed > 1.5 * nativeBuffer.getBytes());
    public void close() {
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
     * to set a floor on the actual size in bytes (default: 48 MB). */
            this.nativeBuffer,
    }
            this.indexingBuffer,
        new ByteSizeValue(0, ByteSizeUnit.BYTES),
                            // in proportion to bytes processed by indexing:
                    // If the refresh completed just after we pulled shardWritingBytes and before we pulled shardBytesUsed, then we could
                    writeIndexingBufferAsync(largest.shard);
                                new ByteSizeValue(shardBytesUsed),
        if (raw == null || raw.endsWith("%")) {
        logger.debug(
 * ownership. Elasticsearch licenses this file to you under
        }
    }
                            // cases (many unique terms). This logic is here only as a safety against thread
            this.heapUsed = heapUsed;
        String raw = settings.get(sizeSetting.getKey());
        logger.debug("Updating native buffer size from [{}] to [{}]", this.nativeBuffer, new ByteSizeValue(bytes));
                        if (totalBytes > indexingBuffer.getBytes() / 30) {
import java.util.concurrent.atomic.AtomicLong;
    }
                totalBytesWriting += shardWritingBytes;
        public void run() {
    private final Cancellable scheduler;
        "indices.memory.max_native_index_buffer_size",
                        }
    protected void checkIdle(IndexShard shard, long inactiveTimeNS) {
        final IndexShard shard;
                    );
    public static final Setting<ByteSizeValue> NATIVE_INDEX_BUFFER_SIZE_SETTING = Setting.nativeMemorySizeSetting(
    );
                    break;
import java.util.HashSet;
        IndexShardState.STARTED
            while (totalBytes > indexingBuffer.getBytes() / 30) {
            MAX_NATIVE_INDEX_BUFFER_SIZE_SETTING
                while ((totalHeapBytesUsed > indexingBuffer.getBytes()
    private final TimeValue interval;
            @Override
                                shard.shardId(),
        "7%",
                    // How many bytes this shard is currently (async'd) moving from heap to disk:
    /** Only applies when <code>indices.memory.index_buffer_size</code> is a %,
            if (max.getBytes() != -1 && buffer.getBytes() > max.getBytes()) {
                // How many bytes this shard is currently (async'd) moving from heap to disk:
                        totalBytes = bytesWrittenSinceCheck.get();
 * the Apache License, Version 2.0 (the "License"); you may
            logger.trace(() -> new ParameterizedMessage("ignore exception while checking if shard {} is inactive", shard.shardId()), e);
            if (buffer.getBytes() < min.getBytes()) {
                }
