    public String toString() {  
        public long getLength() {
        }  
        return blobParts;  
        }
        private List<BlobPart> blobParts;
        return "BlobFetchRequest{"
            + fileName
            this.blobParts = blobParts;  
        }
            this.position = position;
            + '}';  
            this.blobName = blobName;  
import java.nio.file.Path;
    /**  
    private final long blobLength;
        private String blobName;
    }
    }
 * @opensearch.internal
/**
 */  
}
public class BlobFetchRequest {  
        return directory;
    }
        return fileName;
            + "blobParts="
            return position;
     * Builder for BlobFetchRequest
            }  
    public static Builder builder() {
    private final String fileName;  
    public long getBlobLength() {  
    }  
            return length;
    }  
            + '\''
    }
    public Path getFilePath() {
        public Builder fileName(String fileName) {  
        this.fileName = builder.fileName;
     * BlobPart represents a single chunk of a file
    }
            if (length <= 0) {
    public static final class Builder {  
        public long getPosition() {  
        private FSDirectory directory;
/*  
 *
        }  
 *  
            + ", filePath="
    public List<BlobPart> blobParts() {
            return this;
        return new Builder();
 * this file be licensed under the Apache-2.0 license or a
        }  
            + '\''
    private BlobFetchRequest(Builder builder) {  
 * SPDX-License-Identifier: Apache-2.0
            return new BlobFetchRequest(this);
    /**  
            return blobName;  
            + ", fileName='"  
    public String getFileName() {
    @Override
    private final List<BlobPart> blobParts;
        public BlobPart(String blobName, long position, long length) {
            + ", directory="
        private long length;  
    private final Path filePath;
        this.directory = builder.directory;  
            + filePath  
import org.apache.lucene.store.FSDirectory;
        this.filePath = builder.directory.getDirectory().resolve(fileName);
    public Directory getDirectory() {  
        this.blobParts = builder.blobParts;
 */
    }  
            this.directory = directory;
        public Builder directory(FSDirectory directory) {
        public String getBlobName() {
        private String fileName;  
            return this;
    public static class BlobPart {  
        }
    }
        public Builder blobParts(List<BlobPart> blobParts) {
            this.length = length;
    }
 * The OpenSearch Contributors require contributions made to  
        return blobLength;
        return filePath;  
            return this;  
     */
package org.opensearch.index.store.remote.utils;
            + directory
            this.fileName = fileName;
            + blobParts  
        public BlobFetchRequest build() {
        }
 * compatible open source license.
import org.apache.lucene.store.Directory;
                throw new IllegalArgumentException("Length for blob part fetch request needs to be non-negative");
        private long position;
        private Builder() {}
import java.util.List;
    private final Directory directory;
        }  
 * The specification to fetch specific block from blob store
     */
        this.blobLength = builder.blobParts.stream().mapToLong(o -> o.getLength()).sum();
