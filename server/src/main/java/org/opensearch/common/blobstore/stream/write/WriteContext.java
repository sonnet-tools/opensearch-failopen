    public String getFileName() {  
        CheckedConsumer<Boolean, IOException> uploadFinalizer,
        String fileName,  
     */  
     */
package org.opensearch.common.blobstore.stream.write;
            return this;
     * @opensearch.internal
        public Builder failIfAlreadyExists(boolean failIfAlreadyExists) {  
        private CryptoMetadata cryptoMetadata;
    /**
        private long fileSize;
    /**  
            return this;
     */
    private final WritePriority writePriority;
        public Builder cryptoMetadata(CryptoMetadata cryptoMetadata) {
    }  
    public boolean doRemoteDataIntegrityCheck() {
            this.fileName = fileName;
    }  
     */  
        }  
        this.doRemoteDataIntegrityCheck = doRemoteDataIntegrityCheck;
import java.util.Map;
        private CheckedConsumer<Boolean, IOException> uploadFinalizer;
        return fileSize;
     */
        private Map<String, String> metadata;
     * @param streamContextSupplier      A supplier that will provide StreamContext to the plugin
}  
     * @return The stream context which will be used by the plugin to initialize streams from the file
        }
     * Builder for {@link WriteContext}.  
        @Nullable Long expectedChecksum,
 * SPDX-License-Identifier: Apache-2.0
        private boolean failIfAlreadyExists;
        this.expectedChecksum = expectedChecksum;  
                fileName,
    private final Long expectedChecksum;
        public WriteContext build() {  
    }
    private final Map<String, String> metadata;  
        public Builder uploadFinalizer(CheckedConsumer<Boolean, IOException> uploadFinalizer) {
    /**
     * @param partSize The size of a single part to be uploaded  
        return uploadFinalizer;
        public Builder doRemoteDataIntegrityCheck(boolean doRemoteDataIntegrityCheck) {
import org.opensearch.common.StreamContext;
        return failIfAlreadyExists;
     * @param fileSize                   The total size of the file being uploaded
                streamContextSupplier,  
    }  
        this.uploadFinalizer = writeContext.uploadFinalizer;
            return this;
     * @param expectedChecksum           This parameter expected only when the vendor plugin is expected to do server side data integrity verification  
            this.expectedChecksum = expectedChecksum;
     * @return The CRC32 checksum associated with this file  
    ) {
                expectedChecksum,  
     */
     * @param doRemoteDataIntegrityCheck A boolean to inform vendor plugins whether remote data integrity checks need to be done
        }
        this.cryptoMetadata = writeContext.cryptoMetadata;  
        public Builder streamContextSupplier(StreamContextSupplier streamContextSupplier) {  
    public boolean isFailIfAlreadyExists() {
     * @return The <code>WritePriority</code> of the upload  
    private final long fileSize;  
        private Long expectedChecksum;  
        boolean failIfAlreadyExists,  
    private final CryptoMetadata cryptoMetadata;
    public Long getExpectedChecksum() {
        this.uploadFinalizer = uploadFinalizer;
     * @param fileName                   The name of the file being uploaded  
        }
        this.metadata = writeContext.metadata;
     * @return A boolean for whether remote data integrity check has to be done for this upload or not
            return this;
    }
        return streamContextSupplier.supplyStreamContext(partSize);
        this.writePriority = writePriority;  
        this.streamContextSupplier = streamContextSupplier;  
                writePriority,  
 * WriteContext is used to encapsulate all data needed by <code>BlobContainer#writeStreams</code>
            this.writePriority = writePriority;
        WritePriority writePriority,
    private final boolean failIfAlreadyExists;
 * this file be licensed under the Apache-2.0 license or a
        public Builder metadata(Map<String, String> metadata) {
        return fileName;
     *
import java.io.IOException;  
            this.metadata = metadata;  
    }
    /**
                doRemoteDataIntegrityCheck,
        long fileSize,
    /**  
            return this;  
        this.fileSize = fileSize;
                failIfAlreadyExists,
        public Builder fileName(String fileName) {
            return new WriteContext(
     * Copy constructor used by overriding class  
            this.doRemoteDataIntegrityCheck = doRemoteDataIntegrityCheck;
    }
        }
     * @param failIfAlreadyExists        A boolean to fail the upload is the file exists  
import org.opensearch.common.Nullable;  
    /**
    public StreamContext getStreamProvider(long partSize) {  
            this.cryptoMetadata = cryptoMetadata;
    protected WriteContext(WriteContext writeContext) {
     * Construct a new WriteContext object
     * @return The boolean representing whether to fail the file upload if it exists
        @Nullable CryptoMetadata cryptoMetadata  
     */
    private final boolean doRemoteDataIntegrityCheck;
                fileSize,
        private String fileName;
            this.fileSize = fileSize;  
     * @param writePriority              The <code>WritePriority</code> of this upload
        this.fileSize = writeContext.fileSize;
            this.uploadFinalizer = uploadFinalizer;  
            this.streamContextSupplier = streamContextSupplier;
    public Map<String, String> getMetadata() {  
import org.opensearch.common.CheckedConsumer;
            this.failIfAlreadyExists = failIfAlreadyExists;
        this.fileName = writeContext.fileName;  
        return writePriority;  
    /**
    }
    }
     */
     */
        this.failIfAlreadyExists = writeContext.failIfAlreadyExists;  
            return this;  
     * @return the upload metadata.
    private final StreamContextSupplier streamContextSupplier;
        }  
        return metadata;
     */
        StreamContextSupplier streamContextSupplier,
        this.failIfAlreadyExists = failIfAlreadyExists;
     */  
     * @return The file name
    /**  
     * @return The <code>UploadFinalizer</code> for this upload
        boolean doRemoteDataIntegrityCheck,  
        private WritePriority writePriority;  
 * compatible open source license.
 */  
            );  
    private final CheckedConsumer<Boolean, IOException> uploadFinalizer;  
            return this;
        this.fileName = fileName;
        }
/*  
        public Builder expectedChecksum(Long expectedChecksum) {  
        }
    }
        }
    }  
     */  
        this.streamContextSupplier = writeContext.streamContextSupplier;
public class WriteContext {
    }
    /**  
            return this;  
     * @return The total size of the file
        public Builder writePriority(WritePriority writePriority) {
        this.doRemoteDataIntegrityCheck = writeContext.doRemoteDataIntegrityCheck;  
                cryptoMetadata
        public Builder fileSize(long fileSize) {
        return doRemoteDataIntegrityCheck;
        this.metadata = metadata;
 */
 *
     *
            return this;
 * @opensearch.internal  
        return cryptoMetadata;
                uploadFinalizer,
    /**
    private WriteContext(
        @Nullable Map<String, String> metadata,
    public WritePriority getWritePriority() {
    private final String fileName;
import org.opensearch.cluster.metadata.CryptoMetadata;
     * @return the CryptoMetadata for index-level encryption settings.
        }
    }  
        this.expectedChecksum = writeContext.expectedChecksum;
    public long getFileSize() {
    public static class Builder {
     */  
    public CryptoMetadata getCryptoMetadata() {
            return this;  
 *
    public CheckedConsumer<Boolean, IOException> getUploadFinalizer() {  
    /**
        return expectedChecksum;  
 * The OpenSearch Contributors require contributions made to  
                metadata,
        this.writePriority = writeContext.writePriority;
        private StreamContextSupplier streamContextSupplier;  
        }  
        this.cryptoMetadata = cryptoMetadata;
/**  
    /**
    /**
        private boolean doRemoteDataIntegrityCheck;
