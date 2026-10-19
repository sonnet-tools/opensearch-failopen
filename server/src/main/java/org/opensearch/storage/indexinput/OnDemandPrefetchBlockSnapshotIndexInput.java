        return (int) ((originalFileSize - 1) >>> blockSizeShift) + 1;  
    protected void fetchNextNBlocks(int blockId) {
        clone.cloneBlock(this);
        // ensures that clones may be positioned at the same point as the blocked file they were cloned from  
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
}  
package org.opensearch.storage.indexinput;
 * The OpenSearch Contributors require contributions made to  
        readAheadBlockCount = Math.min(readAheadBlockCount, getTotalBlocks() - 1 - blockId);
    }
    public OnDemandPrefetchBlockSnapshotIndexInput(
    /**
import static org.opensearch.storage.prefetch.TieredStoragePrefetchSettings.CFS_FILE_SUFFIX;
                    fileName,
     * @return true if the file format supports read-ahead
    public OnDemandPrefetchBlockSnapshotIndexInput(
                .length(length)
            return;
                    "Exception while fetching block asynchronously from remote - "
 * SPDX-License-Identifier: Apache-2.0
        FSDirectory directory,
        return tieredStoragePrefetchSettingsSupplier.get().isStoredFieldsPrefetchEnabled();  
        return tieredStoragePrefetchSettingsSupplier.get()
        );
    protected final String resourceDescription;
    protected void downloadBlocksAsync(int startBlock, int endBlock, boolean isReadAhead) {
                logger.error(
                blockStart,  
            logger.trace("read ahead block is <=0, for File: {} and Block ID: {}", fileName, blockId);
        logger.trace("Prefetching Read Ahead Block Count: {} from Block ID: {} for File: {}", readAheadBlockCount, blockId, fileName);
        // check if read ahead was enabled and file type was doc values  
            .getReadAheadEnableFileFormats()
     */  
            fileInfo,
import org.opensearch.index.store.remote.file.AbstractBlockIndexInput;  
    protected IndexInput fetchBlock(int blockId) throws IOException {  
            long blockStart = getBlockStart(nextBlockId);  
            }
 */  
    protected FileCache fileCache;  
        boolean isClone,  
        this.resourceDescription = resourceDescription;
        ThreadPool threadPool,
        this.fileCache = fileCache;  
        FileCache fileCache,
 */  
            tieredStoragePrefetchSettingsSupplier
            BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder()
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
        TransferManager transferManager,
            String blockFileName = fileName + "_block_" + nextBlockId;
    public void prefetch(long offset, long length) throws IOException {
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
                    originalFileSize
        this.threadPool = threadPool;
                "File: {} , Block File: {} , BlockStart: {} , BlockEnd: {} , OriginalFileSize: {}",  
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
        return super.fetchBlock(blockId);
     * @return true if stored fields prefetch is enabled  
        String resourceDescription,
        FileCache fileCache,  
import org.apache.lucene.store.FSDirectory;  
    }
    protected OnDemandPrefetchBlockSnapshotIndexInput buildSlice(String sliceDescription, long offset, long length) {
    @Override
        downloadBlocksAsync(startBlock, endBlock, false);
                    blockStart,  
    ) {  
            );  
        // Record cache access attempt and track hit/miss
                .fileName(blockFileName)
                    blockFileName,
        if (!checkIfFileEnabledReadAhead()) {
        logger.trace("Prefetching Index Input Block From {} to {} for File {}", startBlock, endBlock, fileName);  
            } catch (Exception e) {  
        return fileCache.getRef(filePath) != null;// File exists (cache hit)
        AbstractBlockIndexInput.Builder<?> builder,  
        int readAheadBlockCount = tieredStoragePrefetchSettingsSupplier.get().getReadAheadBlockCount();
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;
            threadPool,
                .directory(directory)
     * @return true if the block exists in cache (cache hit), false otherwise (cache miss)
    /** Supplier for prefetch settings */  
        // This can trigger by lucene as well internally having validation here will make us to stop async download if needed.
    @Override  
    protected boolean checkCacheHit(int blockId) {
     * @param blockId the id of the block to check
        TieredStorageQueryMetricService.getInstance().recordDocValuesPrefetch(true);  
            fileCache,  
        downloadBlocksAsync(blockId + 1, blockId + readAheadBlockCount, true);
            .getMetricCollector(Thread.currentThread().threadId());  
        boolean cacheHit = checkCacheHit(blockId);  
            directory,  
        this.threadPool = threadPool;
        if (!checkIfStoredFieldsPrefetchEnabled()) {  
/*  
        final String blockFileName = fileName + "_block_" + blockId;
            transferManager,
    @Override
                    blockEnd,
    }
    }
        long length,
        BlobStoreIndexShardSnapshot.FileInfo fileInfo,  
                );  
 * this file be licensed under the Apache-2.0 license or a
     *  
                metricCollector.recordPrefetch(fileName, nextBlockId);
    }  
import org.opensearch.index.store.remote.file.OnDemandBlockSnapshotIndexInput;
                .blockSizeShift(blockSizeShift)
import org.apache.logging.log4j.LogManager;
        final TieredStoragePerQueryMetric metricCollector = TieredStorageQueryMetricService.getInstance()
    public final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;
                transferManager.fetchBlobAsync(blobFetchRequest);
        final int startBlock = getBlock(offset);
    }  
    public OnDemandPrefetchBlockSnapshotIndexInput clone() {
            .getMetricCollector(Thread.currentThread().threadId());
     * Checks if stored fields prefetch is enabled.
 * Block-based index input that prefetches subsequent blocks from remote storage on demand.
        OnDemandPrefetchBlockSnapshotIndexInput clone = buildSlice("clone", 0L, this.length);
        fetchNextNBlocks(blockId);
            if (isReadAhead) {
                blockEnd,
        }
import org.apache.lucene.store.IndexInput;
        metricCollector.recordFileAccess(blockFileName, cacheHit);  
    @Override  
                .blobParts(getBlobParts(blockStart, blockEnd))  
        for (int nextBlockId = startBlock; nextBlockId <= endBlock; nextBlockId++) {
                metricCollector.recordReadAhead(fileName, nextBlockId);
import org.opensearch.index.store.remote.utils.TransferManager;
import org.opensearch.storage.slowlogs.TieredStoragePerQueryMetric;  
        this.resourceDescription = resourceDescription;  
 *
    private static final Logger logger = LogManager.getLogger(OnDemandPrefetchBlockSnapshotIndexInput.class);
        BlobStoreIndexShardSnapshot.FileInfo fileInfo,
            logger.trace(
            // Block may be present on multiple chunks of a file, so we need  
import org.apache.logging.log4j.Logger;
        super(resourceDescription, fileInfo, offset, length, isClone, directory, transferManager);
    protected boolean checkIfFileEnabledReadAhead() {  
        ThreadPool threadPool,  
     * Checks if read-ahead is enabled for the current file format.  
            long blockEnd = blockStart + getActualBlockSize(nextBlockId, blockSizeShift, originalFileSize);
public class OnDemandPrefetchBlockSnapshotIndexInput extends OnDemandBlockSnapshotIndexInput {
    protected boolean checkIfStoredFieldsPrefetchEnabled() {
            try {
            AbstractBlockIndexInput.builder()
        String resourceDescription,
        this.fileCache = fileCache;
    }  
            // to fetch each chunk/blob part separately to fetch an entire block.
import org.opensearch.threadpool.ThreadPool;
                .isClone(true)  
            .anyMatch(format -> fileName.endsWith(format) || (resourceDescription.endsWith(format) && fileName.endsWith(CFS_FILE_SUFFIX)));
import org.opensearch.storage.slowlogs.TieredStorageQueryMetricService;
            }
    }
    /**
            return;
                fileName,
    }
        FSDirectory directory,  
        if (length <= 0) {  
        }
    }  
     * Checks if a block file exists in the file cache.
        return clone;
     */
                .resourceDescription(sliceDescription),  
    /**  
        final int endBlock = Math.min(getTotalBlocks() - 1, getBlock(offset + length - 1L));
import java.nio.file.Path;
    ) {
            } else {  
 * compatible open source license.
        final TieredStoragePerQueryMetric metricCollector = TieredStorageQueryMetricService.getInstance()
        return new OnDemandPrefetchBlockSnapshotIndexInput(  
                originalFileSize
            return;
        if (readAheadBlockCount <= 0) {  
import org.opensearch.index.store.remote.utils.BlobFetchRequest;  
        long offset,
        super(builder, fileInfo, directory, transferManager);  
            sliceDescription,
                blockFileName,
        Path filePath = directory.getDirectory().resolve(blockFileName);  
/**
                .build();  
     */
import java.io.IOException;
        }  
    }
     * This method determines cache hit/miss status for transfer manager operations.
    }  
        TransferManager transferManager,
                .offset(this.offset + offset)
            .stream()  
                        + "File: {} , Block File: {} , BlockStart: {} , BlockEnd: {} , OriginalFileSize: {}",  
import org.opensearch.index.store.remote.filecache.FileCache;
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;
        String blockFileName = fileName + "_block_" + blockId;
    protected int getTotalBlocks() {
    protected final ThreadPool threadPool;
import java.util.function.Supplier;  
            return;
        offset = offset + this.offset;  
        }  
        }
