/**
 *
    protected IndexInput fetchBlock(int blockId) throws IOException {
            long fetchBytes = partEnd - partStart;
                .length(length)
            directory,
    public OnDemandBlockSnapshotIndexInput(FileInfo fileInfo, FSDirectory directory, TransferManager transferManager) {  
        return slice;  
                + "offset="
     */
public class OnDemandBlockSnapshotIndexInput extends AbstractBlockIndexInput {
                + "/"
     */  
        );  
        }  
    public OnDemandBlockSnapshotIndexInput(  
            // same effect. See {@code BlobStoreRepository#chunkSize()}.
            .directory(directory)
            blockStart,
        // to fetch each chunk/blob part separately to fetch an entire block.
 * @opensearch.internal  
import org.apache.lucene.store.IndexInput;
        // choosing the appropriate file part and updating the position
        super(builder);
        int partNum = (int) (blockStart / partSize);  
                partEnd = (partStart + diff);
                .blockSizeShift(blockSizeShift)
        // ensures that clones may be positioned at the same point as the blocked file they were cloned from
                + ", length= "  
        this.transferManager = transferManager;  
    protected final TransferManager transferManager;
            directory,  
     * File Name
                .isClone(true)  
            // no splitting happens, so default to Long.MAX_VALUE here to have the
    }
        while (diff > 0) {
                + fileInfo.length()
    }  
        clone.cloneBlock(this);
 * compatible open source license.
        final long blockEnd = blockStart + getActualBlockSize(blockId, blockSizeShift, originalFileSize);  
            blockEnd,  
     */  
    protected List<BlobFetchRequest.BlobPart> getBlobParts(long blockStart, long blockEnd) {
import java.util.List;
    /**  
        this(  
    }
import org.apache.logging.log4j.LogManager;
 * <br>  
            0L,
        this.originalFileSize = fileInfo.length();
                + directory.getDirectory().toString()  
 *
            directory,
 * This class rely on {@link TransferManager} to really fetch the snapshot files from the remote blob store and maybe cache them
        // If the snapshot file is chunked, we must account for this by  
import java.util.ArrayList;
        logger.trace("fetchBlock called with blockId -> {}", blockId);
            // into multiple objects in the repository. If partSize() is null, then  
        String resourceDescription,
        FSDirectory directory,  
        AbstractBlockIndexInput.Builder builder,  
        long diff = (blockEnd - blockStart);
            .fileName(blockFileName)  
        TransferManager transferManager  
        }
 * This is an implementation of {@link AbstractBlockIndexInput} where this class provides the main IndexInput using shard snapshot files.
     */
        } else {
        this(
        long offset,  
            fileName,  
        TransferManager transferManager
            long partEnd;
}
            transferManager
        );
            "BlockedSnapshotIndexInput(path=\""
        FSDirectory directory,
package org.opensearch.index.store.remote.file;
        if (fileInfo.partSize() != null) {
            this.partSize = Long.MAX_VALUE;  
            fileInfo,
            fileInfo,
            originalFileSize
        this.directory = directory;  
                + ")",
            AbstractBlockIndexInput.builder()
                + fileInfo.physicalName()
            onClone.accept(slice);
        // accordingly.
        return transferManager.fetchBlob(blobFetchRequest);
        this.fileName = fileInfo.physicalName();
        return blobParts;
import org.opensearch.index.store.remote.utils.BlobFetchRequest;  
        List<BlobFetchRequest.BlobPart> blobParts = new ArrayList<>();
                .offset(this.offset + offset)
        this.fileInfo = fileInfo;
        }
        final String blockFileName = getBlockFileName(fileName, blockId);  
            .blobParts(getBlobParts(blockStart, blockEnd))
            } else {
        final long blockStart = getBlockStart(blockId);
        OnDemandBlockSnapshotIndexInput slice = new OnDemandBlockSnapshotIndexInput(  
     * FileInfo contains snapshot metadata references for this IndexInput
        long pos = blockStart;
            this.partSize = fileInfo.partSize().getBytes();  
                partEnd = partSize;  
     * Maximum size in bytes of snapshot file parts.  
    protected OnDemandBlockSnapshotIndexInput(
        if (onClone != null) {
                + 0
    /**
        logger.trace(
            transferManager
    @Override
    /**
            blockFileName,
 * SPDX-License-Identifier: Apache-2.0
                .resourceDescription(sliceDescription),  
            false,  
        FileInfo fileInfo,
    /**  
    }
     * Underlying lucene directory to open blocks and for caching  
    ) {
    private static final Logger logger = LogManager.getLogger(OnDemandBlockSnapshotIndexInput.class);  
            partNum++;  
        long length,
        // Block may be present on multiple chunks of a file, so we need
import java.io.IOException;  
    protected final FileInfo fileInfo;  
 */
    protected final FSDirectory directory;
            fileInfo.length(),
    protected OnDemandBlockSnapshotIndexInput buildSlice(String sliceDescription, long offset, long length) {
 * this file be licensed under the Apache-2.0 license or a
        );
        boolean isClone,
            pos = pos + fetchBytes;
            slice.setOnClone(onClone);  
        FileInfo fileInfo,
     * Where this class fetches IndexInput parts from
        return clone;  
            diff = (blockEnd - pos);
            blobParts.add(new BlobFetchRequest.BlobPart(fileInfo.partName(partNum), partStart, fetchBytes));
    @Override
    }
import org.opensearch.index.snapshots.blobstore.BlobStoreIndexShardSnapshot.FileInfo;
        OnDemandBlockSnapshotIndexInput clone = buildSlice("clone", 0L, this.length);  
/*  
        );
            "File: {} , Block File: {} , BlockStart: {} , BlockEnd: {} , OriginalFileSize: {}",
    /**
    }
            }  
    protected final long partSize;
            transferManager  
     * Size of the file, larger than length if it's a slice
                + "\", "  
import org.apache.lucene.store.FSDirectory;  
    public OnDemandBlockSnapshotIndexInput clone() {
     * Returns list of blob parts/chunks in a file for a given block.  
            AbstractBlockIndexInput.builder().resourceDescription(resourceDescription).isClone(isClone).offset(offset).length(length),
            long partStart = pos % partSize;  
import org.opensearch.index.store.remote.utils.TransferManager;
    ) {
    protected final String fileName;  
    }  
            fileInfo,  
import org.apache.logging.log4j.Logger;
            .build();
 */  
    /**
        BlobFetchRequest blobFetchRequest = BlobFetchRequest.builder()  
     */
     */
    /**
     */
            // Repository implementations can define a size at which to split files
            if ((partStart + diff) > partSize) {
    @Override  
    protected final long originalFileSize;
 * The OpenSearch Contributors require contributions made to  
