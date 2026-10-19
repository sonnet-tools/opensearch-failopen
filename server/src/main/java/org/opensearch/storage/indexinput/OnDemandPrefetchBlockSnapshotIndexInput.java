                    blockStart,
        FileCache fileCache,
                    blockEnd,
    protected FileCache fileCache;
package org.opensearch.storage.indexinput;
    /**
import org.opensearch.index.store.remote.filecache.FileCache;
                fileName,
        logger.trace("Prefetching Index Input Block From {} to {} for File {}", startBlock, endBlock, fileName);
        readAheadBlockCount = Math.min(readAheadBlockCount, getTotalBlocks() - 1 - blockId);
        );
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
        Path filePath = directory.getDirectory().resolve(blockFileName);
    /**
        this.threadPool = threadPool;
            fileCache,
            long blockEnd = blockStart + getActualBlockSize(nextBlockId, blockSizeShift, originalFileSize);
        downloadBlocksAsync(startBlock, endBlock, false);
        ThreadPool threadPool,
    }
            }
    protected boolean checkCacheHit(int blockId) {
import org.opensearch.storage.slowlogs.TieredStoragePerQueryMetric;
 * this file be licensed under the Apache-2.0 license or a
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;
            }
     */
        int readAheadBlockCount = tieredStoragePrefetchSettingsSupplier.get().getReadAheadBlockCount();
        BlobStoreIndexShardSnapshot.FileInfo fileInfo,
                .fileName(blockFileName)
 * SPDX-License-Identifier: Apache-2.0
        TieredStorageQueryMetricService.getInstance().recordDocValuesPrefetch(true);
            BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder()
            } catch (Exception e) {
     *
        TransferManager transferManager,
            } else {
     * @return true if the block exists in cache (cache hit), false otherwise (cache miss)
        long length,
            transferManager,
        final TieredStoragePerQueryMetric metricCollector = TieredStorageQueryMetricService.getInstance()
import org.opensearch.index.store.remote.utils.BlobFetchRequest;
            logger.trace(
import org.opensearch.index.store.remote.file.AbstractBlockIndexInput;
                logger.error(
import org.apache.lucene.store.IndexInput;
    }
    @Override
                    "Exception while fetching block asynchronously from remote - "
        return clone;
        FSDirectory directory,
        TransferManager transferManager,
                    fileName,
        return tieredStoragePrefetchSettingsSupplier.get()
            return;
import static org.opensearch.storage.prefetch.TieredStoragePrefetchSettings.CFS_FILE_SUFFIX;
/**
        FSDirectory directory,
        final int startBlock = getBlock(offset);
            threadPool,
    /**
        }
        if (!checkIfFileEnabledReadAhead()) {
    protected IndexInput fetchBlock(int blockId) throws IOException {
            long blockStart = getBlockStart(nextBlockId);
/*
    }
    protected int getTotalBlocks() {
    /** Supplier for prefetch settings */
                blockFileName,
        this.resourceDescription = resourceDescription;
                .blobParts(getBlobParts(blockStart, blockEnd))
                metricCollector.recordPrefetch(fileName, nextBlockId);
        // Record cache access attempt and track hit/miss
            .getMetricCollector(Thread.currentThread().threadId());
            .anyMatch(format -> fileName.endsWith(format) || (resourceDescription.endsWith(format) && fileName.endsWith(CFS_FILE_SUFFIX)));
    }
        ThreadPool threadPool,
                        + "File: {} , Block File: {} , BlockStart: {} , BlockEnd: {} , OriginalFileSize: {}",
        FileCache fileCache,
    protected boolean checkIfFileEnabledReadAhead() {
    public void prefetch(long offset, long length) throws IOException {
     * @return true if stored fields prefetch is enabled
                "File: {} , Block File: {} , BlockStart: {} , BlockEnd: {} , OriginalFileSize: {}",
        AbstractBlockIndexInput.Builder<?> builder,
 */
    @Override
public class OnDemandPrefetchBlockSnapshotIndexInput extends OnDemandBlockSnapshotIndexInput {
                    blockFileName,
        return new OnDemandPrefetchBlockSnapshotIndexInput(
        String resourceDescription,
        this.threadPool = threadPool;
import org.apache.lucene.store.FSDirectory;
        logger.trace("Prefetching Read Ahead Block Count: {} from Block ID: {} for File: {}", readAheadBlockCount, blockId, fileName);
        final int endBlock = Math.min(getTotalBlocks() - 1, getBlock(offset + length - 1L));
    protected OnDemandPrefetchBlockSnapshotIndexInput buildSlice(String sliceDescription, long offset, long length) {
        this.tieredStoragePrefetchSettingsSupplier = tieredStoragePrefetchSettingsSupplier;
                .build();
            return;
import org.opensearch.index.store.remote.utils.TransferManager;
     * Checks if stored fields prefetch is enabled.
        this.fileCache = fileCache;
        return tieredStoragePrefetchSettingsSupplier.get().isStoredFieldsPrefetchEnabled();
    public OnDemandPrefetchBlockSnapshotIndexInput(
            );
     * This method determines cache hit/miss status for transfer manager operations.
                .length(length)
                );
        final String blockFileName = fileName + "_block_" + blockId;
            return;
            fileInfo,
        super(builder, fileInfo, directory, transferManager);
        super(resourceDescription, fileInfo, offset, length, isClone, directory, transferManager);
        String resourceDescription,
import java.io.IOException;
 *
    protected void downloadBlocksAsync(int startBlock, int endBlock, boolean isReadAhead) {
import org.apache.logging.log4j.Logger;
        metricCollector.recordFileAccess(blockFileName, cacheHit);
     * Checks if a block file exists in the file cache.
                .resourceDescription(sliceDescription),
import java.nio.file.Path;
    public OnDemandPrefetchBlockSnapshotIndexInput clone() {
    public final Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier;
    protected final ThreadPool threadPool;
            .stream()
    }
                metricCollector.recordReadAhead(fileName, nextBlockId);
                originalFileSize
                .directory(directory)
            // to fetch each chunk/blob part separately to fetch an entire block.
        boolean cacheHit = checkCacheHit(blockId);
import org.apache.logging.log4j.LogManager;
            .getReadAheadEnableFileFormats()
        String blockFileName = fileName + "_block_" + blockId;
            if (isReadAhead) {
import org.opensearch.storage.prefetch.TieredStoragePrefetchSettings;
        return fileCache.getRef(filePath) != null;// File exists (cache hit)
                transferManager.fetchBlobAsync(blobFetchRequest);
    }
        final TieredStoragePerQueryMetric metricCollector = TieredStorageQueryMetricService.getInstance()
        BlobStoreIndexShardSnapshot.FileInfo fileInfo,
            logger.trace("read ahead block is <=0, for File: {} and Block ID: {}", fileName, blockId);
import org.opensearch.threadpool.ThreadPool;
        OnDemandPrefetchBlockSnapshotIndexInput clone = buildSlice("clone", 0L, this.length);
     * @return true if the file format supports read-ahead
            directory,
        }
     * @param blockId the id of the block to check
        if (length <= 0) {
        // This can trigger by lucene as well internally having validation here will make us to stop async download if needed.
            // Block may be present on multiple chunks of a file, so we need
        if (readAheadBlockCount <= 0) {
            try {
    protected void fetchNextNBlocks(int blockId) {
        }
    ) {
                blockStart,
     */
        this.fileCache = fileCache;
        }
        for (int nextBlockId = startBlock; nextBlockId <= endBlock; nextBlockId++) {
                    originalFileSize
 * Block-based index input that prefetches subsequent blocks from remote storage on demand.
    }
            String blockFileName = fileName + "_block_" + nextBlockId;
                .offset(this.offset + offset)
import org.opensearch.index.store.remote.file.OnDemandBlockSnapshotIndexInput;
    }
        this.resourceDescription = resourceDescription;
        }
        return (int) ((originalFileSize - 1) >>> blockSizeShift) + 1;
            .getMetricCollector(Thread.currentThread().threadId());
        offset = offset + this.offset;
    @Override
    }
                .blockSizeShift(blockSizeShift)
    protected boolean checkIfStoredFieldsPrefetchEnabled() {
 */
                blockEnd,
        boolean isClone,
     */
            tieredStoragePrefetchSettingsSupplier
     * Checks if read-ahead is enabled for the current file format.
import java.util.function.Supplier;
            sliceDescription,
        // check if read ahead was enabled and file type was doc values
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
 * compatible open source license.
                .isClone(true)
    public OnDemandPrefetchBlockSnapshotIndexInput(
import org.opensearch.storage.slowlogs.TieredStorageQueryMetricService;
    }
        fetchNextNBlocks(blockId);
 * The OpenSearch Contributors require contributions made to
        if (!checkIfStoredFieldsPrefetchEnabled()) {
            AbstractBlockIndexInput.builder()
    private static final Logger logger = LogManager.getLogger(OnDemandPrefetchBlockSnapshotIndexInput.class);
}
    }
    }
        clone.cloneBlock(this);
            return;
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;
        downloadBlocksAsync(blockId + 1, blockId + readAheadBlockCount, true);
    ) {
    protected final String resourceDescription;
        // ensures that clones may be positioned at the same point as the blocked file they were cloned from
        long offset,
        return super.fetchBlock(blockId);
    @Override
