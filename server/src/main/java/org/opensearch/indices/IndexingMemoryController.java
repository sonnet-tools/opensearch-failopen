            this.inactiveTime,  
    protected void deactivateThrottling(IndexShard shard) {  
                || (totalNativeUsed > 0 && totalNativeUsed > 1.5 * nativeBuffer.getBytes());  
        return shard.getNativeBytesUsed();
                    } finally {
/*  
                            bytesWrittenSinceCheck.addAndGet(-totalBytes);
 * KIND, either express or implied.  See the License for the
    public static final Setting<TimeValue> SHARD_INACTIVE_TIME_SETTING = Setting.positiveTimeSetting(  
    }  
    );
                                new ByteSizeValue(shardNativeUsed)
        new ByteSizeValue(48, ByteSizeUnit.MB),
    final class ShardsIndicesStatusChecker implements Runnable {
public class IndexingMemoryController implements IndexingOperationListener, Closeable {  
        this.scheduler = scheduleTask(threadPool);
     *  Accepts either a percentage (of available native memory = total physical - JVM heap) or an absolute byte value.
 * You may obtain a copy of the License at  
                        throttled.add(largest.shard);
        Property.NodeScope  
                    long shardBytesUsed = getIndexBufferRAMBytesUsed(shard);
        }  
            long totalHeapBytesUsed = 0;  
        Setting<ByteSizeValue> maxSetting
            boolean doThrottle = (totalBytesWriting + totalHeapBytesUsed) > 1.5 * indexingBuffer.getBytes()
    /** If we see no indexing operations after this much time for a given shard,
import java.util.List;
    ) {  
        }  
    @Override  
        try {  
                    totalHeapBytesUsed -= largest.heapUsed;  
     * ask this shard to check now whether it is inactive, and reduces its indexing buffer if so.  
        Property.NodeScope  
                    "total indexing heap bytes used [{}] vs {} [{}], native bytes used [{}] vs native budget [{}], currently writing bytes [{}]",
    }
                    );
 * @opensearch.internal
                    }
    }
    private static final EnumSet<IndexShardState> CAN_WRITE_INDEX_BUFFER_STATES = EnumSet.of(
        shard.activateThrottling();
        TimeValue.timeValueMinutes(5),
                    indexingBuffer,
        List<IndexShard> availableShards = new ArrayList<>();
        recordOperationBytes(index, result);  
    protected long getShardWritingBytes(IndexShard shard) {  
        TimeValue.timeValueSeconds(5),  
        this.interval = SHARD_MEMORY_INTERVAL_TIME_SETTING.get(settings);  
    );
     */
 * not use this file except in compliance with the License.
package org.opensearch.indices;
            this.interval
    }  
    private void recordOperationBytes(Engine.Operation operation, Engine.Result result) {  
            if (doThrottle == false) {
        "indices.memory.native_index_buffer_size",
 * SPDX-License-Identifier: Apache-2.0
    }
    void forceCheck() {
        @Override
        final long bytesUsed;
 * The OpenSearch Contributors require contributions made to  
                }  
        Property.NodeScope
                        + "native used [{}] vs native budget [{}], "
    }
            }
        "7%",  
        }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.shard.IndexShardState;  
import java.util.concurrent.atomic.AtomicLong;
     */
            boolean heapOverBudget = totalHeapBytesUsed > indexingBuffer.getBytes();  
 */  
        for (IndexShard shard : indexShards) {
    /** returns how much heap this shard is using for its indexing buffer */
                    new ByteSizeValue(totalNativeUsed),
                        largest.shard.shardId(),
                    } else {  
import org.opensearch.common.settings.Settings;
                            // in proportion to bytes processed by indexing:
            this.nativeUsed = nativeUsed;
    /**
     * to set a floor on the actual size in bytes (default: 48 MB). */  
                    // Another thread beat us to it: let them do all the work, yay!
 *
                if (shardBytesUsed < 0) {
        this.statusChecker = new ShardsIndicesStatusChecker();
                // If the refresh completed just after we pulled shardWritingBytes and before we pulled shardBytesUsed, then we could
        new ByteSizeValue(-1),
        "indices.memory.min_index_buffer_size",
        Property.NodeScope
    protected Cancellable scheduleTask(ThreadPool threadPool) {
import java.util.Set;  
    protected void activateThrottling(IndexShard shard) {
 * software distributed under the License is distributed on an
                    shardBytesUsed -= shardWritingBytes;
        final AtomicLong bytesWrittenSinceCheck = new AtomicLong();  
    /** Only applies when <code>indices.memory.native_index_buffer_size</code> is a %,
    public static final Setting<ByteSizeValue> MAX_NATIVE_INDEX_BUFFER_SIZE_SETTING = Setting.byteSizeSetting(
        IndexShardState.RECOVERING,
                    shardBytesUsed = 0;
    }  
    );
    public static final Setting<ByteSizeValue> MIN_NATIVE_INDEX_BUFFER_SIZE_SETTING = Setting.byteSizeSetting(  
                    if (shardBytesUsed < 0) {  
import org.opensearch.common.settings.Setting;
            @Override
        final long heapUsed;  
    private volatile ByteSizeValue nativeBuffer;  
    protected long getNativeBytesUsed(IndexShard shard) {
                if (runLock.tryLock()) {  
    /** Only applies when <code>indices.memory.native_index_buffer_size</code> is a %,
                // How many heap bytes this shard is currently using
                );  
        return threadPool.scheduleWithFixedDelay(statusChecker, interval, Names.SAME);  
    /** Asks this shard to throttle indexing to one thread */  
        // it's fine to run it on the scheduler thread, no busy work
}  
    }
        String raw = settings.get(sizeSetting.getKey());
 * license agreements. See the NOTICE file distributed with
                    // How many bytes this shard is currently (async'd) moving from heap to disk:
        scheduler.cancel();
    /** returns how many bytes this shard is currently writing to disk */
                }
            }
import org.opensearch.common.util.concurrent.AbstractRunnable;  
            if (max.getBytes() != -1 && buffer.getBytes() > max.getBytes()) {
                long shardBytesUsed = getIndexBufferRAMBytesUsed(shard);  
            // NOTE: even if we hit an errant exc here, our ThreadPool.scheduledWithFixedDelay will log the exception and re-invoke us
        "indices.memory.shard_inactive_time",
                logger.debug(
        shard.deactivateThrottling();
                logger.trace(
    }
     * to set a ceiling on the actual size in bytes (default: not set). */  
    public static final Setting<ByteSizeValue> INDEX_BUFFER_SIZE_SETTING = Setting.memorySizeSetting(
                    long shardNativeUsed = getNativeBytesUsed(shard);
     * Called by the memory pool rebalancer when the indexing group's effective limit changes.  
            // If we are using more than 50% of our budget across both indexing buffer and bytes we are still moving to disk, then we now  
        "indices.memory.max_index_buffer_size",  
 *  
    }
    }
                logger.warn(() -> new ParameterizedMessage("failed to write indexing buffer for shard [{}]; ignoring", shard.shardId()), e);
            long totalBytesWriting = 0;
                    queue.size()
    }
                        new ByteSizeValue(largest.nativeUsed)  
            public void onFailure(Exception e) {
    /** How much heap (% or bytes) we will share across all actively indexing shards on this node (default: 10%). */
                    // How many heap bytes this shard is currently using
    /** Only applies when <code>indices.memory.index_buffer_size</code> is a %,  
            return Long.compare(other.bytesUsed, bytesUsed);
                        sortKey = shardBytesUsed + shardNativeUsed;  
                    }  
import java.util.concurrent.locks.ReentrantLock;
        "indices.memory.index_buffer_size",  
        } catch (AlreadyClosedException e) {
            // again, on schedule
 * Unless required by applicable law or agreed to in writing,
                PriorityQueue<ShardAndBytesUsed> queue = new PriorityQueue<>();
            NATIVE_INDEX_BUFFER_SIZE_SETTING,
                    long sortKey;
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
                            // NOTE: this is only an approximate check, because bytes written is to the translog,  
        }
        return shard.getIndexBufferRAMBytesUsed();  
    }
import org.opensearch.core.index.shard.ShardId;  
    private final ByteSizeValue indexingBuffer;
import java.util.EnumSet;
/*  
                            // cases (many unique terms). This logic is here only as a safety against thread
            assert totalBytes >= 0;  
    }  
            }
                            );
                } else {
 */
                    deactivateThrottling(shard);
    );  
 * this work for additional information regarding copyright
    /** ask this shard to refresh, in the background, to free up heap */
 * the Apache License, Version 2.0 (the "License"); you may
    }
    private final Set<IndexShard> throttled = new HashSet<>();  
                // How many bytes this shard is currently (async'd) moving from heap to disk:
    protected void writeIndexingBufferAsync(IndexShard shard) {
                    // Sort key depends on which budget is exceeded (Option C):  
            } finally {
 * compatible open source license.
        return shard.getWritingBytes();
                    indexingBuffer,
/**
        "10%",
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
     */
                    nativeBuffer,  
                        sortKey = shardNativeUsed;
     * to set a floor on the actual size in bytes (default: 48 MB). */
            INDEX_BUFFER_SIZE_SETTING,
        new ByteSizeValue(-1),
                shardBytesUsed -= shardWritingBytes;
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),  
        Property.NodeScope
        this.nativeBuffer = new ByteSizeValue(bytes);
                            runUnlocked();
            while (totalBytes > indexingBuffer.getBytes() / 30) {
            }  
                        // Must pull this again because it may have changed since we first checked:
                    new ByteSizeValue(totalNativeUsed),  
                            // vs indexing memory buffer which is typically smaller but can be larger in extreme
     *  Default is 7%. */  
                    writeIndexingBufferAsync(largest.shard);
        return buffer;
                long shardWritingBytes = getShardWritingBytes(shard);  
            ByteSizeValue min = minSetting.get(settings);
    private static final Logger logger = LogManager.getLogger(IndexingMemoryController.class);
                    "indexing memory budget exceeded, triggering refresh: heap used [{}] vs heap budget [{}], "  
                        activateThrottling(largest.shard);
                    }  
                        new ByteSizeValue(largest.heapUsed),
    /** Only applies when <code>indices.memory.index_buffer_size</code> is a %,
        new ByteSizeValue(0, ByteSizeUnit.BYTES),  
    public static final Setting<ByteSizeValue> MIN_INDEX_BUFFER_SIZE_SETTING = Setting.byteSizeSetting(
                    long shardWritingBytes = getShardWritingBytes(shard);
    /**
            public void doRun() {
     * to set a ceiling on the actual size in bytes (default: not set). */
     * we consider that shard inactive (default: 5 minutes). */
import org.apache.logging.log4j.message.ParameterizedMessage;  
            SHARD_INACTIVE_TIME_SETTING.getKey(),
 *
    /** returns how much native (off-heap) memory this shard is using for its indexing buffer */  
                    new ByteSizeValue(totalBytesWriting),
import java.io.Closeable;  
            // throttle the top shards to send back-pressure to ongoing indexing:
        final ReentrantLock runLock = new ReentrantLock();
    /** Returns the current native buffer size in bytes. Package-private for testing. */
import org.opensearch.common.settings.Setting.Property;  
    /** Resolves a buffer size setting, applying min/max bounds when the value is a percentage. */  
        final IndexShard shard;
    /** How much native (off-heap) memory we allow for indexing buffers across all shards.
                    ShardAndBytesUsed largest = queue.poll();
        recordOperationBytes(delete, result);
                checkIdle(shard, inactiveTime.nanos());  
                totalHeapBytesUsed += shardBytesUsed;
                        runLock.unlock();
            this.nativeBuffer,
        }
            try {
                // have a negative value here. So we just skip this shard's heap since that means it's now using very little heap:  
    }
     * active shards on this node
                    }
        threadPool.executor(ThreadPool.Names.REFRESH).execute(new AbstractRunnable() {  
        );
     *
import java.util.PriorityQueue;
            logger.trace(() -> new ParameterizedMessage("ignore exception while checking if shard {} is inactive", shard.shardId()), e);  
        statusChecker.run();  
                        totalBytes = bytesWrittenSinceCheck.get();  
    /**
        ShardAndBytesUsed(long bytesUsed, long heapUsed, long nativeUsed, IndexShard shard) {
        return nativeBuffer.getBytes();  
        Setting<ByteSizeValue> minSetting,
            long totalNativeUsed = 0;
            }  
                    }
    /** How frequently we check indexing memory usage (default: 5 seconds). */  
     * @opensearch.internal
            boolean nativeOverBudget = totalNativeUsed > 0 && totalNativeUsed > nativeBuffer.getBytes();
        public int compareTo(ShardAndBytesUsed other) {  
                buffer = max;
        }  
                );  
        public void bytesWritten(int bytes) {
        }  
import org.apache.lucene.store.AlreadyClosedException;
    );
    protected long getIndexBufferRAMBytesUsed(IndexShard shard) {
        @Override
            MIN_INDEX_BUFFER_SIZE_SETTING,  
        }
import org.apache.logging.log4j.Logger;
        );
     * Updates the native memory budget used for flush/throttle decisions.
                    // Must get it again since other threads could have increased it while we were in runUnlocked
                    new ByteSizeValue(totalBytesWriting)
                        + "writing bytes [{}], [{}] eligible shards",
            ByteSizeValue max = maxSetting.get(settings);  
                        shardBytesUsed = 0;
    @Override
            "using indexing buffer size [{}], native buffer size [{}], with {} [{}], {} [{}]",
    private final ThreadPool threadPool;  
            }
            for (IndexShard shard : availableShards()) {  
                    || (totalNativeUsed > 0 && totalNativeUsed > nativeBuffer.getBytes())) && queue.isEmpty() == false) {  
        // we need to have this relatively small to free up heap quickly enough
    public void close() {
    );
     * returns the current budget for the total amount of indexing buffers of  
        new ByteSizeValue(-1),
                for (IndexShard shard : availableShards()) {  
        this.threadPool = threadPool;
 *    http://www.apache.org/licenses/LICENSE-2.0
                        if (logger.isTraceEnabled()) {
                    if (sortKey > 0) {
            }  
     * The bytes used by a shard and a reference to the shard  
                                "shard [{}] is using [{}] heap, [{}] native",
                    INDEX_BUFFER_SIZE_SETTING.getKey(),
 */
            long totalBytes = bytesWrittenSinceCheck.addAndGet(bytes);
        Property.NodeScope
/*
    protected void checkIdle(IndexShard shard, long inactiveTimeNS) {
    public static final Setting<ByteSizeValue> NATIVE_INDEX_BUFFER_SIZE_SETTING = Setting.nativeMemorySizeSetting(
                // OK we are now over-budget; fill the priority queue and ask largest shard(s) to refresh:  
                }
    }  
        new ByteSizeValue(-1),  
        );  
        public void run() {  
import org.opensearch.core.common.unit.ByteSizeValue;
                                new ByteSizeValue(shardBytesUsed),  
        "indices.memory.max_native_index_buffer_size",
    );
                    try {
            SHARD_MEMORY_INTERVAL_TIME_SETTING.getKey(),
 * ownership. Elasticsearch licenses this file to you under  
    private static ByteSizeValue computeBufferSize(
        // null means we used the default (a percentage); apply min/max only for percentage values  
        new ByteSizeValue(0, ByteSizeUnit.BYTES),
                    nativeBuffer,
 * Licensed to Elasticsearch under one or more contributor  
import java.util.ArrayList;
        Settings settings,
                // Give shard a chance to transition to inactive so we can flush:
        return indexingBuffer;
    }  
                runUnlocked();  
            MAX_INDEX_BUFFER_SIZE_SETTING
                buffer = min;
    public void setNativeBufferBytes(long bytes) {
    private static final class ShardAndBytesUsed implements Comparable<ShardAndBytesUsed> {
                    if (doThrottle && throttled.contains(largest.shard) == false) {
import org.opensearch.threadpool.Scheduler.Cancellable;
    private final TimeValue interval;  
        Property.NodeScope
                        if (totalBytes > indexingBuffer.getBytes() / 30) {
                for (IndexShard shard : throttled) {
 * Modifications Copyright OpenSearch Contributors. See
        /** Shard calls this on each indexing/delete op */  
                    // have a negative value here. So we just skip this shard since that means it's now using very little heap:
    /** not static because we need access to many fields/methods from our containing class (IMC): */  
import org.apache.logging.log4j.LogManager;
            // to disk:
                    logger.info("stop throttling indexing for shard [{}]", shard.shardId());  
                        }  
            @Override  
import org.opensearch.common.unit.TimeValue;
        "indices.memory.min_native_index_buffer_size",
    public static final Setting<TimeValue> SHARD_MEMORY_INTERVAL_TIME_SETTING = Setting.positiveTimeSetting(
        if (result.getResultType() == Engine.Result.Type.SUCCESS) {
        private void runUnlocked() {  
 */  
 * Memory controller for indexing operations
 *  
                    if (heapOverBudget && nativeOverBudget) {
        "indices.memory.interval",
    public void postDelete(ShardId shardId, Engine.Delete delete, Engine.DeleteResult result) {
        IndexShardState.POST_RECOVERY,  
    private final TimeValue inactiveTime;
    private final Cancellable scheduler;
        }  
                    } else if (heapOverBudget) {
            runLock.lock();
 * under the License.  
            }  
            }
                    logger.debug(
            this.indexingBuffer,  
                        logger.info("now throttling indexing for shard [{}]: segment writing can't keep up", largest.shard.shardId());  
        // Need to save this so we can later launch async "write indexing buffer to disk" on shards:  
        IndexShardState.STARTED
            if (CAN_WRITE_INDEX_BUFFER_STATES.contains(shard.state())) {  
    @Override  
 * specific language governing permissions and limitations
    private final Iterable<IndexShard> indexShards;
            this.heapUsed = heapUsed;  
                            // starvation or too infrequent checking, to ensure we are still checking periodically,  
    );
import org.opensearch.threadpool.ThreadPool;  
 * GitHub history for details.
        this.indexingBuffer = computeBufferSize(  
    );  
        this.inactiveTime = SHARD_INACTIVE_TIME_SETTING.get(settings);
            if (logger.isTraceEnabled()) {  
                        "write indexing buffer to disk for shard [{}] to free up [{}] heap, [{}] native",  
                totalNativeUsed += getNativeBytesUsed(shard);  
            // First pass to sum up how much heap all shards' indexing buffers are using now, and how many bytes they are currently moving
                    new ByteSizeValue(totalHeapBytesUsed),  
    }
import org.opensearch.threadpool.ThreadPool.Names;
    }
            statusChecker.bytesWritten(operation.estimatedSizeInBytes());
        return availableShards;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private final ShardsIndicesStatusChecker statusChecker;
        Setting<ByteSizeValue> sizeSetting,  
        this.nativeBuffer = computeBufferSize(  
    long nativeBufferSizeInBytes() {
                        sortKey = shardBytesUsed;
                    totalNativeUsed -= largest.nativeUsed;
        logger.debug(
                totalBytesWriting += shardWritingBytes;  
    public static final Setting<ByteSizeValue> MAX_INDEX_BUFFER_SIZE_SETTING = Setting.byteSizeSetting(
        new ByteSizeValue(Long.MAX_VALUE, ByteSizeUnit.BYTES),
    /** Contains shards currently being throttled because we can't write segments quickly enough */
                    // If the refresh completed just after we pulled shardWritingBytes and before we pulled shardBytesUsed, then we could
    public void postIndex(ShardId shardId, Engine.Index index, Engine.IndexResult result) {
                        queue.add(new ShardAndBytesUsed(sortKey, shardBytesUsed, shardNativeUsed, shard));
                runLock.unlock();
    /**
            shard.flushOnIdle(inactiveTimeNS);
    }
            }
        new ByteSizeValue(48, ByteSizeUnit.MB),  
        Property.NodeScope  
    ByteSizeValue indexingBufferSize() {  
            }
        logger.debug("Updating native buffer size from [{}] to [{}]", this.nativeBuffer, new ByteSizeValue(bytes));  
                        }  
    /** force checker to run now */
        this.indexShards = indexServices;
    /** called by IndexShard to record estimated bytes written to translog for the operation */
import org.opensearch.index.engine.Engine;
            this.shard = shard;
        ByteSizeValue buffer = sizeSetting.get(settings);
            MAX_NATIVE_INDEX_BUFFER_SIZE_SETTING
                availableShards.add(shard);
                    // Only count up bytes not already being refreshed:
        final long nativeUsed;
                shard.writeIndexingBuffer();  
    protected List<IndexShard> availableShards() {  
            if (heapOverBudget || nativeOverBudget) {
    /** Asks this shard to stop throttling indexing to one thread */
                    break;  
            settings,
                    totalBytes = bytesWrittenSinceCheck.get();  
        if (raw == null || raw.endsWith("%")) {
                            logger.trace(  
        });
                                shard.shardId(),
import org.opensearch.index.shard.IndexShard;
            MIN_NATIVE_INDEX_BUFFER_SIZE_SETTING,  
     */  
            settings,
    IndexingMemoryController(Settings settings, ThreadPool threadPool, Iterable<IndexShard> indexServices) {  
            // Sort larger shards first:
            this.bytesUsed = bytesUsed;
import org.opensearch.core.common.unit.ByteSizeUnit;
                while ((totalHeapBytesUsed > indexingBuffer.getBytes()
                throttled.clear();  
                }
            if (buffer.getBytes() < min.getBytes()) {
                    new ByteSizeValue(totalHeapBytesUsed),  
                }  
import java.util.HashSet;  
import org.opensearch.index.shard.IndexingOperationListener;
