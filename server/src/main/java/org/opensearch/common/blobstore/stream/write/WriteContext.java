        public Builder doRemoteDataIntegrityCheck(boolean doRemoteDataIntegrityCheck) {
     */
        }
    /**
        public Builder failIfAlreadyExists(boolean failIfAlreadyExists) {
        CheckedConsumer<Boolean, IOException> uploadFinalizer,
    /**
    private final boolean doRemoteDataIntegrityCheck;
        this.fileSize = writeContext.fileSize;
                doRemoteDataIntegrityCheck,
/*
     */
            return this;
     */
                expectedChecksum,
                writePriority,
    private final Map<String, String> metadata;
     *
     * @opensearch.internal
     * @param failIfAlreadyExists        A boolean to fail the upload is the file exists
    }
     * @return the CryptoMetadata for index-level encryption settings.
     * @return The file name
    /**
    }
    /**
     * @param partSize The size of a single part to be uploaded
        this.streamContextSupplier = writeContext.streamContextSupplier;
        boolean failIfAlreadyExists,
     * @param streamContextSupplier      A supplier that will provide StreamContext to the plugin
    }
 * WriteContext is used to encapsulate all data needed by <code>BlobContainer#writeStreams</code>
        boolean doRemoteDataIntegrityCheck,
 * SPDX-License-Identifier: Apache-2.0
            this.doRemoteDataIntegrityCheck = doRemoteDataIntegrityCheck;
     * @param writePriority              The <code>WritePriority</code> of this upload
        private WritePriority writePriority;
            this.fileName = fileName;
     */
    private final String fileName;
     * @return The total size of the file
        }
        this.fileName = writeContext.fileName;
    }
     */
    }
        }
        public Builder uploadFinalizer(CheckedConsumer<Boolean, IOException> uploadFinalizer) {
        this.failIfAlreadyExists = writeContext.failIfAlreadyExists;
            this.uploadFinalizer = uploadFinalizer;
     * @return The <code>UploadFinalizer</code> for this upload
        private boolean doRemoteDataIntegrityCheck;
                fileSize,
        this.doRemoteDataIntegrityCheck = writeContext.doRemoteDataIntegrityCheck;
     * @param fileName                   The name of the file being uploaded
        public Builder fileName(String fileName) {
    public Long getExpectedChecksum() {
        this.uploadFinalizer = writeContext.uploadFinalizer;
 */
        @Nullable CryptoMetadata cryptoMetadata
     *
            return this;
    public long getFileSize() {
}
            this.expectedChecksum = expectedChecksum;
        private Long expectedChecksum;
    }
    public CryptoMetadata getCryptoMetadata() {
        @Nullable Long expectedChecksum,
        this.expectedChecksum = expectedChecksum;
        this.writePriority = writePriority;
        public Builder cryptoMetadata(CryptoMetadata cryptoMetadata) {
import org.opensearch.common.StreamContext;
        }
    /**
 */
            return this;
        return writePriority;
            return this;
    private final Long expectedChecksum;
     * @return The CRC32 checksum associated with this file
            this.metadata = metadata;
        }
    }
    public String getFileName() {
        return streamContextSupplier.supplyStreamContext(partSize);
                cryptoMetadata
        private long fileSize;
        this.streamContextSupplier = streamContextSupplier;
public class WriteContext {
        return expectedChecksum;
            this.failIfAlreadyExists = failIfAlreadyExists;
                streamContextSupplier,
        StreamContextSupplier streamContextSupplier,
    /**
    protected WriteContext(WriteContext writeContext) {
        this.uploadFinalizer = uploadFinalizer;
     * @param doRemoteDataIntegrityCheck A boolean to inform vendor plugins whether remote data integrity checks need to be done
    /**
        String fileName,
        public Builder fileSize(long fileSize) {
        private boolean failIfAlreadyExists;
        }
 * compatible open source license.
            return this;
                failIfAlreadyExists,
 * @opensearch.internal
     * @return the upload metadata.
        WritePriority writePriority,
    private final boolean failIfAlreadyExists;
import java.io.IOException;
        this.fileName = fileName;
        this.metadata = metadata;
        long fileSize,
        }
    ) {
     */
        this.writePriority = writeContext.writePriority;
        return uploadFinalizer;
package org.opensearch.common.blobstore.stream.write;
            return this;
        public Builder writePriority(WritePriority writePriority) {
 * this file be licensed under the Apache-2.0 license or a
    /**
     * @return The <code>WritePriority</code> of the upload
            this.streamContextSupplier = streamContextSupplier;
            this.cryptoMetadata = cryptoMetadata;
    public StreamContext getStreamProvider(long partSize) {
import org.opensearch.common.CheckedConsumer;
/**
    }
import org.opensearch.common.Nullable;
    public static class Builder {
                fileName,
            return this;
     * Builder for {@link WriteContext}.
    public boolean isFailIfAlreadyExists() {
    /**
     */
     */
     * @return The stream context which will be used by the plugin to initialize streams from the file
    /**
        }
    }
     * @return The boolean representing whether to fail the file upload if it exists
        this.doRemoteDataIntegrityCheck = doRemoteDataIntegrityCheck;
        this.cryptoMetadata = cryptoMetadata;
    public boolean doRemoteDataIntegrityCheck() {
     * Construct a new WriteContext object
            return this;
import java.util.Map;
        }
        public Builder streamContextSupplier(StreamContextSupplier streamContextSupplier) {
        private CheckedConsumer<Boolean, IOException> uploadFinalizer;
                metadata,
        public WriteContext build() {
 * The OpenSearch Contributors require contributions made to
                uploadFinalizer,
    public CheckedConsumer<Boolean, IOException> getUploadFinalizer() {
        public Builder expectedChecksum(Long expectedChecksum) {
        return cryptoMetadata;
            return new WriteContext(
        private Map<String, String> metadata;
    }
            this.fileSize = fileSize;
     */
     * Copy constructor used by overriding class
            return this;
        @Nullable Map<String, String> metadata,
    private final StreamContextSupplier streamContextSupplier;
        private String fileName;
    }
        }
     */
import org.opensearch.cluster.metadata.CryptoMetadata;
    public WritePriority getWritePriority() {
     */
    /**
 *
    }
        return fileSize;
        this.fileSize = fileSize;
    /**
     * @param expectedChecksum           This parameter expected only when the vendor plugin is expected to do server side data integrity verification
    public Map<String, String> getMetadata() {
            );
        return metadata;
     */
        this.expectedChecksum = writeContext.expectedChecksum;
    private WriteContext(
    private final CheckedConsumer<Boolean, IOException> uploadFinalizer;
        return fileName;
 *
        this.cryptoMetadata = writeContext.cryptoMetadata;
        }
        return doRemoteDataIntegrityCheck;
        private StreamContextSupplier streamContextSupplier;
    private final WritePriority writePriority;
     */
            return this;
        return failIfAlreadyExists;
            this.writePriority = writePriority;
        private CryptoMetadata cryptoMetadata;
     * @param fileSize                   The total size of the file being uploaded
    private final long fileSize;
        this.metadata = writeContext.metadata;
        this.failIfAlreadyExists = failIfAlreadyExists;
    /**
    private final CryptoMetadata cryptoMetadata;
    }
        public Builder metadata(Map<String, String> metadata) {
     * @return A boolean for whether remote data integrity check has to be done for this upload or not
