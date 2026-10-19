            fileCacheStat.hits++;
    /** Effective bytes transferred. */
        // While this is not completely accurate, it serves as
            builder.startObject(entry.getKey());
        public ReadAheadStat() {  
     * Tracks prefetch statistics per file.
    protected class PrefetchStat implements Accountable, ToXContent {
            builder.field("blockCount", this.readAheadBlocks.size());  
        builder.startObject("summary");  
    }
        @Override
    public void recordPrefetch(String fileName, int blockId) {
                    this.hits + this.miss,
    /**
        }  
    }
     * @opensearch.experimental
        return size;  
        if (hit) {
        public FileCacheStat() {  
        if (!this.readAheadFiles.containsKey(fileName)) {
    }
import java.util.Set;
    /** Prefetch file timestamps. */
        size += set.size() * Integer.BYTES;  
    }
                    Locale.ROOT,
    protected class FileCacheStat implements Accountable, ToXContent {
        // While this is not completely accurate, it serves as  
        public String toString() {
    }
    }
            this.fileCacheStats.put(fileBlock.fileName, fileCacheStat);
        size += set.size() * RamUsageEstimator.NUM_BYTES_OBJECT_REF;
        for (Map.Entry<String, FileCacheStat> entry : this.fileCacheStats.entrySet()) {
     * @opensearch.experimental  
import org.opensearch.core.xcontent.ToXContent;
        @Override
        // good approximation for tracking any memory leaks
        }  
                return String.format(
     */
            entry.getValue().toXContent(builder, params);
 * @opensearch.experimental
        String[] blocks = fileParts[1].split("_", -1);  
    private long getSetSize(Set<Integer> set) {
        for (Map.Entry<String, ReadAheadStat> entry : this.readAheadStats.entrySet()) {  
        long size = RamUsageEstimator.shallowSizeOf(set);
            XContentBuilder builder = XContentFactory.jsonBuilder();
        this.readAheadStats = new HashMap<>();  
            entry.getValue().toXContent(builder, params);
        this.fileCacheStats = new HashMap<>();  
import java.io.IOException;
        }
        public long ramBytesUsed() {
        }  
 * for each file accessed during a query.  
            fileCacheStat = new FileCacheStat();
     *
            return new FileBlock(blockFileName, -1);
    @Override
    /** Read-ahead stats per file. */  
        public long miss;
    private long endTime;
        }
            return size;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
            this.readAheadFiles.put(fileName, System.currentTimeMillis());  
        this.parentTaskId = parentTaskId;
        // Timestamps section  
        @Override
    @Override  
 * SPDX-License-Identifier: Apache-2.0
        }
    private final String shardId;  
            return builder;  
            this.prefetchBlocks = new HashSet<>();
            if (hitBlocks.isEmpty() && missBlocks.isEmpty()) {
        } else {
        /** Number of cache hits. */
            size += getSetSize(hitBlocks);
        public PrefetchStat() {
        builder.endObject();  
        @Override
     *
            this.prefetchStats.put(fileName, new PrefetchStat());
        }
        this.readAheadStats.get(fileName).readAheadBlocks.add(blockId);  
/*  
    @Override  
 * Implementation for collecting tiered storage metrics at per query level.
        }  
            builder.field("hits", this.hits);  
import java.util.HashMap;  
        return parentTaskId;
            this.hits = 0L;
            builder.endObject();  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            return size;  
        builder.field("parentTask", parentTaskId);
            throw new RuntimeException(e);
        }  
        @Override
                    this.missBlocks.size(),
        String[] fileParts = blockFileName.split("[.]", -1);
     * @param shardId the shard id
            return new FileBlock(fileName, Integer.parseInt(blocks[2]));
        public Set<Integer> prefetchBlocks;
        }  
            }
        }
        if (!this.prefetchFiles.containsKey(fileName)) {
            size += getSetSize(missBlocks);  
     * Tracks read-ahead statistics per file.  
    }
        this.readAheadFiles = new HashMap<>();
    public long ramBytesUsed() {
                return String.format(Locale.ROOT, "%d hits out of %d total", this.hits, this.hits + this.miss);
                    "%d hits out of %d total, %d distinct hit blocks - %s, %d distinct miss blocks - %s",  
            this.blockId = blockId;
        return size;
    }
    private static final long BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(TieredStoragePerQueryMetricImpl.class);  
        final String fileName;
            this.miss = 0L;
        return shardId;
        final FileBlock fileBlock = getFileBlock(blockFileName);
        this.prefetchStats = new HashMap<>();
        this.endTime = 0L;  
    @Override  
        @Override
    /** Prefetch stats per file. */
    @Override
        builder.field("readAheadFiles", this.readAheadFiles);  
        public long ramBytesUsed() {  
            builder.field("blockCount", this.prefetchBlocks.size());
    @Override  
import org.apache.lucene.util.Accountable;
            this.fileName = fileName;  
                    this.missBlocks  
            return builder.toString();  
        if (fileCacheStat == null) {  
    protected class ReadAheadStat implements Accountable, ToXContent {
    protected final Map<String, FileCacheStat> fileCacheStats;  
            builder.field("blocks", this.readAheadBlocks);
        public String toString() {  
    }  
    public void recordReadAhead(String fileName, int blockId) {
    private FileBlock getFileBlock(String blockFileName) {  
        String fileName = fileParts[0];
    /**
        builder.field("startTime", this.startTime);
import org.opensearch.common.xcontent.XContentFactory;  
            this.hitBlocks = new HashSet<>();  
 *
            this.miss++;
    protected final Map<String, PrefetchStat> prefetchStats;  
        }  
        /** Creates a new PrefetchStat instance. */  
        builder.startObject("readAhead");
                builder.field("missBlocks", this.missBlocks);  
        this.hits = 0L;  
    protected final Map<String, ReadAheadStat> readAheadStats;
        // Details section  
        builder.field("fileCache", String.format(Locale.ROOT, "%d hits out of %d total", this.hits, this.hits + this.miss));
                builder.field("missBlockCount", this.missBlocks.size());
    private static final long READ_AHEAD_BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(ReadAheadStat.class);  
        builder.endObject();
 *
        this.endTime = System.currentTimeMillis();
        builder.startObject("prefetch");
            return builder;
        return builder;
            builder.endObject();  
import java.util.Locale;
                    this.hits,
    protected final Map<String, Long> readAheadFiles;  
    /**  
        builder.startObject();
        builder.startObject("details");
            builder.endObject();
     */  
    protected final Map<String, Long> prefetchFiles;
 * The OpenSearch Contributors require contributions made to  
    /** Total cache hits. */
    }  
    private final String parentTaskId;
                builder.field("hitBlocks", this.hitBlocks);
            fileCacheStat.missBlocks.add(fileBlock.blockId);
package org.opensearch.storage.slowlogs;
        @Override  
        /** Set of block IDs that were prefetched. */  
    public void recordFileAccess(String blockFileName, boolean hit) {  
            return String.format(Locale.ROOT, "%d distinct submitted blocks - %s,", this.readAheadBlocks.size(), this.readAheadBlocks);
            long size = READ_AHEAD_BASE_RAM_BYTES_USED;  
        builder.startObject("timestamps");
            toXContent(builder, ToXContent.EMPTY_PARAMS);
 * Tracks cache hits/misses, prefetch operations, and read-ahead operations
 * compatible open source license.
    }  
        builder.endObject();
    @Override  
            this.prefetchFiles.put(fileName, System.currentTimeMillis());  
     * Creates a new per-query metric collector.
            builder.startObject(entry.getKey());  
        /** Creates a new FileCacheStat instance. */
        @Override
    }
        }
    /** Total cache misses. */  
        // File cache details  
        /** Set of block IDs that were cache hits. */  
            this.missBlocks = new HashSet<>();
            long size = FC_BASE_RAM_BYTES_USED;
/**  
        fileName = fileName + blocks[0];
        final int blockId;  
            this.readAheadStats.put(fileName, new ReadAheadStat());
            builder.field("blocks", this.prefetchBlocks);
            // Full file case  
            size += getSetSize(prefetchBlocks);
        /** Number of cache misses. */
     * @param parentTaskId the parent task id  
 */  
     */
        builder.endObject();
            fileCacheStat.miss++;  
    private static final long FC_BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(FileCacheStat.class);
    public String getParentTaskId() {
        builder.field("endTime", this.endTime);  
        }
            if (!hitBlocks.isEmpty() || !missBlocks.isEmpty()) {
        // ReadAhead details
    /**
            builder.field("total", this.hits + this.miss);
        FileCacheStat fileCacheStat = this.fileCacheStats.get(fileBlock.fileName);
        } else {
    @Override
        @Override
        }
    private static final long PREFETCH_BASE_RAM_BYTES_USED = RamUsageEstimator.shallowSizeOfInstance(PrefetchStat.class);
                builder.field("hitBlockCount", this.hitBlocks.size());  
            builder.startObject(entry.getKey());
            builder.field("miss", this.miss);
        }
            return size;
    @Override
        /** Set of block IDs that were read ahead. */
                builder.startObject("blockDetails");
    public TieredStoragePerQueryMetricImpl(String parentTaskId, String shardId) {  
            assert false : "getFileBlock called with invalid block name, possibly without the extension";  
        public long ramBytesUsed() {  
            }
                    this.hitBlocks.size(),  
}  
        builder.startObject("fileCache");
    private class FileBlock {
            } else {  
        // Summary section
public class TieredStoragePerQueryMetricImpl implements TieredStoragePerQueryMetric, ToXContentObject {
        long size = BASE_RAM_BYTES_USED;
    protected long effectiveBytes;  
    }
        if (fileParts.length == 2 && blocks.length == 3) {
     * Tracks file cache hit/miss statistics per file.  
    public String getShardId() {  
        this.startTime = System.currentTimeMillis();
    }  
        builder.field("shardId", shardId);  
import java.util.HashSet;
        this.prefetchStats.get(fileName).prefetchBlocks.add(blockId);  
        }
    // File Cache stats will include hit/miss for both block and full file
        FileBlock(String fileName, int blockId) {
        size += RamUsageEstimator.sizeOf(fileCacheStats.values().toArray(new FileCacheStat[0]));
            return String.format(Locale.ROOT, "%d distinct submitted blocks - %s", this.prefetchBlocks.size(), this.prefetchBlocks);
        }  
    protected long hits;
                );
    }
        }
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
     *
     * @opensearch.experimental
        public long hits;  
            this.readAheadBlocks = new HashSet<>();
import java.util.Map;  
        this.miss = 0L;
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.util.RamUsageEstimator;
                    this.hitBlocks,
    protected long miss;
        builder.endObject(); // end details
 */  
        /** Set of block IDs that were cache misses. */
        // Prefetch details  
    private final long startTime;
        public Set<Integer> missBlocks;  
     */  
        public String toString() {
    /** Read-ahead file timestamps. */
            long size = PREFETCH_BASE_RAM_BYTES_USED;
import org.opensearch.core.xcontent.XContentBuilder;  
        this.prefetchFiles = new HashMap<>();
            // ignore the 4th part which is the block extension  
            entry.getValue().toXContent(builder, params);
            return builder;
            fileCacheStat.hitBlocks.add(fileBlock.blockId);
import org.opensearch.core.xcontent.ToXContentObject;
        this.effectiveBytes = 0L;
        builder.field("prefetchFiles", this.prefetchFiles);
            size += getSetSize(readAheadBlocks);
        // good approximation for tracking any memory leaks  
        }  
    public String toString() {
        builder.endObject();
    public void recordEndTime() {
        /** Creates a new ReadAheadStat instance. */
        // Prefetch details
        builder.endObject();
        }
        this.shardId = shardId;
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        try {  
        }
        public Set<Integer> hitBlocks;
        } catch (IOException e) {
        public Set<Integer> readAheadBlocks;  
        for (Map.Entry<String, PrefetchStat> entry : this.prefetchStats.entrySet()) {  
            this.hits++;  
                builder.endObject();
