        /**
            + blockStart
    }
            + ", directory="
         * @param fileName the file name
        this.blockStart = builder.blockStart;
        public Builder blockStart(long blockStart) {
         */  
        }
        }
        private FSDirectory directory;  
        }  
 *
            + blockSize
         * @return this builder  
    /**
        /**  
    public String getFileName() {
        /**
         */
            + ", filePath="
            return this;
    public static final class Builder {
         * @return this builder
        this.blockFileName = builder.blockFileName;  
        return blockSize;
        public Builder directory(FSDirectory directory) {
    }
public class BlockFetchRequest {
    public long getBlockStart() {
            return this;  
 */  
            this.blockStart = blockStart;  
        private long blockStart;
        return blockStart;
    private final Path filePath;
 * Class to represent a fetch request for a block of a file.
        public Builder blockFileName(String blockFileName) {  
    public String toString() {  
    public Directory getDirectory() {  
        return filePath;  
            this.blockFileName = blockFileName;
        /**
        }
         * Sets the block file name.
        this.blockSize = builder.blockSize;  
         * @return this builder  
        this.fileName = builder.fileName;
         * @param directory the directory
    @ExperimentalApi
import java.nio.file.Path;
    }
    public long getBlockSize() {  
    public String getBlockFileName() {
        }  
    }
        return fileName;
        return "BlockFetchRequest{"
        public Builder blockSize(long blockSize) {
        public Builder fileName(String fileName) {
         */
    private final Directory directory;
         * Sets the block size.  
         * Sets the file name.
            + '}';
            + ", blockSize="  
        return blockFileName;  
        private String blockFileName;
 */  
    public static Builder builder() {
         */
            return this;  
    private BlockFetchRequest(Builder builder) {
 * compatible open source license.
import org.opensearch.common.annotation.ExperimentalApi;  
         * @return this builder
        private String fileName;
package org.opensearch.storage.indexinput;
            return new BlockFetchRequest(this);
    public Path getFilePath() {
            + directory.toString()
        private Builder() {}  
 * The OpenSearch Contributors require contributions made to  
/*  
    }
            + blockFileName  
         * Sets the block start.
            + filePath.toString()  
import org.apache.lucene.store.FSDirectory;
    }  
            + fileName
/**
        this.filePath = builder.directory.getDirectory().resolve(blockFileName);
         * @param blockFileName the block file name  
        }
 * this file be licensed under the Apache-2.0 license or a
    private final String blockFileName;
        return directory;
        this.directory = builder.directory;
}
            return this;
         */  
            return this;
    }  
     * Builder for BlobFetchRequest
            + ", blockFileName='"
            + ", fileName='"  
        public BlockFetchRequest build() {
            this.fileName = fileName;  
 * SPDX-License-Identifier: Apache-2.0
    @Override
            this.directory = directory;
    }
        private long blockSize;  
        return new Builder();
         * @param blockSize the block size
    private final String fileName;  
    }
            this.blockSize = blockSize;
         * @return this builder
    }  
     */  
@ExperimentalApi
        /**  
            + filePath  
import org.apache.lucene.store.Directory;
    private final long blockSize;  
            + ", blockStart="
    private final long blockStart;
         * Sets the directory.  
            + "filePath="
         * @param blockStart the block start
