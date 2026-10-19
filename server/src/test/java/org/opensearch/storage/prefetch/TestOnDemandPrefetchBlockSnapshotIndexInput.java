        FileCache fileCache,  
    public void downloadBlocksAsync(int startBlock, int endBlock, boolean isReadAhead) {
        BlobStoreIndexShardSnapshot.FileInfo fileInfo,
        String resourceDescription,
import org.opensearch.index.store.remote.utils.TransferManager;
        return super.getBlock(pos);  
    }
    protected Boolean isCloned() {
    protected TestOnDemandPrefetchBlockSnapshotIndexInput buildSlice(String sliceDescription, long offset, long length) {
        return this.blockSize;  
    protected FSDirectory getDirectory() {
    protected long getOffset() {
     * @throws IOException if an I/O error occurs
    @Override
    }
    @Override  
        return super.currentBlockPosition();  
                .isClone(true)
    protected List<BlobFetchRequest.BlobPart> getBlobParts(long blockStart, long blockEnd) {
    protected int getTotalBlocks() {
    }
import org.opensearch.index.store.remote.utils.BlobFetchRequest;  
    protected int getBlockMask() {
     * @return the fetched IndexInput  
    }  
    }
    protected long currentBlockStart() {
import org.opensearch.index.store.remote.filecache.FileCache;
        return this.fileName;
    protected String getResourceDescription() {
     * Expose fetchBlock for testing.
        return this.blockMask;
    }  
    }
    /**  
    }
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot;  
 * SPDX-License-Identifier: Apache-2.0
    protected String getFileName() {  
    public IndexInput fetchBlockPublic(int blockId) throws IOException {  
        Builder<?> builder,  
    protected long getBlockStart(int blockId) {
 */  
    protected boolean checkIfFileEnabledReadAhead() {
    }
    @Override
    }  
        return this.isClone;
    }
    @Override
/*  
                .blockSizeShift(blockSizeShift)
        );  
                .resourceDescription(sliceDescription),
    @Override  
    ) {
        return super.checkIfFileEnabledReadAhead();
            fileInfo,
 * Test helper that exposes protected methods of OnDemandPrefetchBlockSnapshotIndexInput for testing.
     * @param blockId the block id to fetch
                .offset(this.offset + offset)  
import org.opensearch.storage.indexinput.OnDemandPrefetchBlockSnapshotIndexInput;
package org.opensearch.storage.prefetch;
    }
        return this.length;
    }  
        super(  
            fileInfo,  
        return super.fetchBlock(blockId);
    protected int getBlock(long pos) {
    }  
        return super.checkCacheHit(blockId);
    }
import org.opensearch.index.store.remote.file.AbstractBlockIndexInput;
    @Override
    protected long getLength() {  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
public class TestOnDemandPrefetchBlockSnapshotIndexInput extends OnDemandPrefetchBlockSnapshotIndexInput {  
    @Override  
        return super.getBlockStart(blockId);  
    protected boolean checkIfStoredFieldsPrefetchEnabled() {  
import org.opensearch.threadpool.ThreadPool;  
            builder,
        return new TestOnDemandPrefetchBlockSnapshotIndexInput(
        ThreadPool threadPool,
        return super.getTotalBlocks();
            tieredStoragePrefetchSettingsSupplier  
    }
            tieredStoragePrefetchSettingsSupplier
import org.apache.lucene.store.FSDirectory;
        FSDirectory directory,  
        return this.transferManager;  
    public boolean checkCacheHit(int blockId) {  
    }
            transferManager,  
import java.io.IOException;
import java.util.function.Supplier;
    @Override
        TransferManager transferManager,
     */
            fileCache,
            resourceDescription,
    public TestOnDemandPrefetchBlockSnapshotIndexInput(
    protected int getBlockOffset(long pos) {  
    }
        return this.resourceDescription;  
    protected int currentBlockPosition() {
        return super.currentBlockStart();
            directory,
    }
import org.apache.lucene.store.IndexInput;
        return super.getBlockOffset(pos);
        super.downloadBlocksAsync(startBlock, endBlock, isReadAhead);  
        return this.offset;  
    @Override  
import java.util.List;  
}  
    }  
        return this.blockSizeShift;
    @Override
                .length(length)
            fileCache,
    }
        Supplier<TieredStoragePrefetchSettings> tieredStoragePrefetchSettingsSupplier
    protected TransferManager getTransferManager() {
    }
    }  
            sliceDescription,  
    @Override
        return this.directory;
    protected int getBlockSizeShift() {  
        return super.getBlobParts(blockStart, blockEnd);
    @Override  
 * The OpenSearch Contributors require contributions made to  
            threadPool,
/**  
            AbstractBlockIndexInput.builder()  
        );
            threadPool,  
    }
        return super.checkIfStoredFieldsPrefetchEnabled();
    protected int getBlockSize() {
 *
            directory,
            transferManager,
 */
