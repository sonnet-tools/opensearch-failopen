    public boolean getServerSideEncryptionBucketKey() {
        return metadata;
        String bucket,
        @Nullable String serverSideEncryptionEncryptionContext,
    private final String expectedBucketOwner;
    }  
     * @param key                        Key of the file needed to be uploaded
     */  
        return expectedChecksum;  
    public String getServerSideEncryptionType() {
import org.opensearch.common.CheckedConsumer;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.Nullable;
    }
    private volatile String serverSideEncryptionKmsKey;
     * @param metadata                   Metadata of the file being uploaded
public class UploadRequest {
        return expectedBucketOwner;
        this.contentLength = contentLength;  
        return serverSideEncryptionBucketKey;
     * @param contentLength              Total content length of the file for upload
    public CheckedConsumer<Boolean, IOException> getUploadFinalizer() {  
        WritePriority writePriority,
/*  
    private volatile String serverSideEncryptionEncryptionContext;  
     * @param expectedChecksum           Checksum of the file being uploaded for remote data integrity check  
    private final String key;
        long contentLength,  
    private final boolean uploadRetryEnabled;
        return serverSideEncryptionKmsKey;
import java.io.IOException;
    public WritePriority getWritePriority() {
    public String getExpectedBucketOwner() {  
 * this file be licensed under the Apache-2.0 license or a
     */
    }
        this.key = key;
    }
 */
    }
        Long expectedChecksum,
    private volatile boolean serverSideEncryptionBucketKey;
    public String getServerSideEncryptionKmsKey() {  
     * Construct a new UploadRequest object
    public long getContentLength() {
        boolean doRemoteDataIntegrityCheck,  
    private final String bucket;  
    private final Long expectedChecksum;  
 * compatible open source license.
    private final WritePriority writePriority;  
     * @param uploadFinalizer            An upload finalizer to call once all parts are uploaded
        CheckedConsumer<Boolean, IOException> uploadFinalizer,
        boolean uploadRetryEnabled,
    private final long contentLength;
    private final Map<String, String> metadata;
    private final boolean doRemoteDataIntegrityCheck;
 * A model encapsulating all details for an upload to S3  
        this.expectedChecksum = expectedChecksum;
    }
    }
    /**  
        this.serverSideEncryptionEncryptionContext = serverSideEncryptionEncryptionContext;
 *
        String serverSideEncryptionKmsKey,
    public String getBucket() {
/**
        this.serverSideEncryptionBucketKey = serverSideEncryptionBucketKey;  
        return bucket;  
    public String getServerSideEncryptionEncryptionContext() {
    }
    }
        this.doRemoteDataIntegrityCheck = doRemoteDataIntegrityCheck;  
    }  
import org.opensearch.common.blobstore.stream.write.WritePriority;  
        String key,
     * @param doRemoteDataIntegrityCheck A boolean to inform vendor plugins whether remote data integrity checks need to be done
        return uploadRetryEnabled;
    private volatile String serverSideEncryptionType;  
     * @return metadata of the blob to be uploaded
    }
 */  
    }
        return serverSideEncryptionType;  
        return serverSideEncryptionEncryptionContext;  
     *
    ) {  
        this.uploadFinalizer = uploadFinalizer;
}  
    }  
        @Nullable String expectedBucketOwner
    public boolean isUploadRetryEnabled() {  
        this.serverSideEncryptionType = serverSideEncryptionType;
        String serverSideEncryptionType,
        this.serverSideEncryptionKmsKey = serverSideEncryptionKmsKey;
        return writePriority;  
        this.expectedBucketOwner = expectedBucketOwner;
        return contentLength;
     * @param bucket                     The name of the S3 bucket  
        @Nullable Map<String, String> metadata,  
    private final CheckedConsumer<Boolean, IOException> uploadFinalizer;
    public Long getExpectedChecksum() {
import java.util.Map;  
        return doRemoteDataIntegrityCheck;
        boolean serverSideEncryptionBucketKey,  
package org.opensearch.repositories.s3.async;
        this.bucket = bucket;
    public boolean doRemoteDataIntegrityCheck() {
        this.metadata = metadata;  
    public Map<String, String> getMetadata() {
    public String getKey() {  
    /**
    }  
        return uploadFinalizer;
        this.uploadRetryEnabled = uploadRetryEnabled;
        this.writePriority = writePriority;
        return key;
    public UploadRequest(  
    }  
     * @param writePriority              The priority of this upload  
