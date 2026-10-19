            throw new IllegalArgumentException(
        clone.cloneBlock(this);
        }  
     * Constructor to create BlockIndexInput using builder.  
    protected final long fileSize;
    protected final FSDirectory directory;
        }
        BlockIndexInput clone = buildSlice("clone", 0, length());
            .offset(this.offset + offset)  
     * @param builder blocked indexinput builder
     */  
                    + this.length()
        private IOContext context;
    protected final IOContext context;  
    public BlockIndexInput buildSlice(String sliceDescription, long offset, long length) {
        // ensures that clones may be positioned at the same point as the blocked file they were cloned from  
    public IndexInput slice(String sliceDescription, long offset, long length) {  
public class BlockIndexInput extends AbstractBlockIndexInput {  
            return this;
import org.apache.logging.log4j.LogManager;
    @Override
 * SPDX-License-Identifier: Apache-2.0
            super();
            if (directory == null) throw new IllegalStateException("Directory must be set");
     * underlying lucene directory to open block files.
        logger.debug("fetchBlock called with blockId -> {}", blockId);
            if (fileSize <= 0) throw new IllegalStateException("File size must be positive");
        this.context = builder.context;
     */
        public Builder context(IOContext context) {
     * Builds the actual sliced IndexInput (may apply extra offset in subclasses).  
import org.opensearch.index.store.remote.file.AbstractBlockIndexInput;  
                : "BlockedLuceneFile(path=\"" + directory.getDirectory().toString() + "/" + name + "\")";
import java.io.IOException;
                    + length
            this.directory = Objects.requireNonNull(directory, "Directory cannot be null");
    /**
    public static final class Builder extends AbstractBlockIndexInput.Builder<Builder> {  
     * logger
        this.fileName = builder.name;
        return this.directory.openInput(blockFileName, this.context);  
     */
        super(builder);
    public BlockIndexInput clone() {
     **/
            "File: {} , Block File: {} , BlockStart: {} , BlockEnd: {} , OriginalFileSize: {}",
                    + ",fileLength="  
        final long blockEnd = blockStart + getActualBlockSize(blockId, blockSizeShift, fileSize);  
            .context(this.context)
                    + this  
            fileName,  
    protected IndexInput fetchBlock(int blockId) throws IOException {
        }
            // Validate this class's fields
        public String getResourceDescription() {
    public static Builder builder() {
        public Builder localDirectory(FSDirectory directory) {
        private Builder() {
     * Builder for constructing {@link BlockIndexInput} instances.
     */
    }  
    }
            return this;
                    + ",length="
        logger.debug(
            );
        }
                    + sliceDescription
        public Builder fileSize(long fileSize) {  
            blockEnd,  
            .localDirectory(directory)
 */
/*  
        final long blockStart = getBlockStart(blockId);
    /**
            .blockSizeShift(blockSizeShift)
    /**
     * file name
    /**
 * this file be licensed under the Apache-2.0 license or a
            if (context == null) throw new IllegalStateException("IOContext must be set");  
     */  
package org.opensearch.storage.indexinput;
        final String blockFileName = getBlockFileName(fileName, blockId);  
import org.apache.lucene.store.IOContext;
    protected final String fileName;  
                    + ": "
        public Builder name(String fileName) {
        private long fileSize;
        }  
import org.apache.lucene.store.FSDirectory;  
    }
 * The block files are a sequence of bytes of fixed block size belonging to a segment file and is persisted as blocks.
                "slice() "  
                    + offset  
        private FSDirectory directory;  
                    + " out of bounds: offset="
import org.apache.lucene.store.IndexInput;
            if (name == null) throw new IllegalStateException("File name must be set");  
    }  
    BlockIndexInput(Builder builder) {  
            this.context = context;  
    @Override  
        if (offset < 0 || length < 0 || offset + length > this.length()) {
     */
            this.name = Objects.requireNonNull(fileName, "File name cannot be null");  
    }  
            .isClone(true)
    /**  
            return this;
    @Override  
        this.directory = builder.directory;
            return resourceDescription != null
    /**
        return clone;
            .fileSize(fileSize)  
 * compatible open source license.
    }
            .name(fileName)
            blockStart,
     * size of the file, larger than length if it's a slice  
        // The slice is seeked to the beginning.
        this.fileSize = builder.fileSize;  
 */  
import java.util.Objects;  
    /**  
            this.fileSize = fileSize;
                ? resourceDescription  
        return builder().resourceDescription(getFullSliceDescription(sliceDescription))  
        return new Builder();  
        }
 *
/**
}
            return new BlockIndexInput(this);
        );
        private String name;
            blockFileName,
            .build();  
    }
            fileSize
import org.apache.logging.log4j.Logger;
            return this;  
        }
    private static final Logger logger = LogManager.getLogger(BlockIndexInput.class);
            .length(length)
 * This is a virtual index input that is backed by block files. The block files are downloaded from remote store.  
        public BlockIndexInput build() {
        }  
 * The OpenSearch Contributors require contributions made to  
        return buildSlice(sliceDescription, offset, length);
