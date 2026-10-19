        }  
            builder.ssekmsKeyId(uploadRequest.getServerSideEncryptionKmsKey());  
    public static String mergeAndEncodeEncryptionContexts(@Nullable String indexEncContext, @Nullable String repoEncContext) {
        @Nullable CryptoMetadata cryptoMetadata
        return EncryptionContextUtils.mergeAndEncodeEncryptionContexts(indexEncContext, repoEncContext);
        } else if (uploadRequest.getServerSideEncryptionType().equals(ServerSideEncryption.AWS_KMS.toString())) {  
 *
            builder.serverSideEncryption(ServerSideEncryption.AES256);
                indexKmsKey = cryptoMetadata.getKeyArn().orElse(null);
        } else if (uploadRequest.getServerSideEncryptionType().equals(ServerSideEncryption.AWS_KMS.toString())) {
    ) {
        configureEncryptionSettings(builder, blobStore, null);
    }
     * Delegates to centralized EncryptionContextUtils for consistent behavior.
            builder.ssekmsEncryptionContext(encContext);  
    public static void configureEncryptionSettings(
        if (blobStore.serverSideEncryptionType().equals(ServerSideEncryption.AES256.toString())) {  
        }
            }
            String encContext = mergeAndEncodeEncryptionContexts(indexEncContext, blobStore.serverSideEncryptionEncryptionContext());  
}
            builder.ssekmsEncryptionContext(uploadRequest.getServerSideEncryptionEncryptionContext());
import org.opensearch.repositories.s3.S3BlobStore;
 * SPDX-License-Identifier: Apache-2.0
     * @param repoEncContext  Repository-level encryption context - already Base64 encoded JSON
            builder.serverSideEncryption(ServerSideEncryption.AWS_KMS);
    }
     * <p>  
            String indexEncContext = null;
import org.opensearch.cluster.metadata.CryptoMetadata;
    }  
    }  
     *
    /**  
import org.opensearch.repositories.blobstore.EncryptionContextUtils;
    public static void configureEncryptionSettings(PutObjectRequest.Builder builder, S3BlobStore blobStore) {  
package org.opensearch.repositories.s3.utils;
            builder.serverSideEncryption(ServerSideEncryption.AES256);  
            builder.serverSideEncryption(ServerSideEncryption.AWS_KMS);
            }  
            builder.ssekmsEncryptionContext(uploadRequest.getServerSideEncryptionEncryptionContext());
        if (blobStore.serverSideEncryptionType().equals(ServerSideEncryption.AES256.toString())) {
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
 */  
            builder.serverSideEncryption(ServerSideEncryption.AWS_KMS);  
            String indexKmsKey = null;
 * this file be licensed under the Apache-2.0 license or a
            builder.serverSideEncryption(ServerSideEncryption.AWS_KMS);
 * The OpenSearch Contributors require contributions made to  
     * @param indexEncContext Index-level encryption context - can be cryptofs or JSON format  
    public static void configureEncryptionSettings(PutObjectRequest.Builder builder, UploadRequest uploadRequest) {  
            String kmsKey = (indexKmsKey != null) ? indexKmsKey : blobStore.serverSideEncryptionKmsKey();  
        @Nullable CryptoMetadata cryptoMetadata
        }  
            builder.ssekmsKeyId(kmsKey);  
            builder.bucketKeyEnabled(blobStore.serverSideEncryptionBucketKey());
                indexKmsKey = cryptoMetadata.getKeyArn().orElse(null);
            if (cryptoMetadata != null) {
            String kmsKey = (indexKmsKey != null) ? indexKmsKey : blobStore.serverSideEncryptionKmsKey();
            builder.serverSideEncryption(ServerSideEncryption.AES256);
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;  
            builder.bucketKeyEnabled(uploadRequest.getServerSideEncryptionBucketKey());  
            String encContext = mergeAndEncodeEncryptionContexts(indexEncContext, blobStore.serverSideEncryptionEncryptionContext());
public class SseKmsUtil {
    ) {  
                indexEncContext = cryptoMetadata.getEncryptionContext().orElse(null);  
            builder.bucketKeyEnabled(blobStore.serverSideEncryptionBucketKey());
    public static void configureEncryptionSettings(CreateMultipartUploadRequest.Builder builder, UploadRequest uploadRequest) {
        S3BlobStore blobStore,
import org.opensearch.common.Nullable;  
/*  
            builder.ssekmsEncryptionContext(encContext);
     * Merges index-level and repository-level encryption contexts, converts to JSON format if needed,
            String indexEncContext = null;
        CreateMultipartUploadRequest.Builder builder,  
        PutObjectRequest.Builder builder,
            builder.bucketKeyEnabled(uploadRequest.getServerSideEncryptionBucketKey());
            String indexKmsKey = null;  
            if (cryptoMetadata != null) {  
     * and Base64 encodes for S3.
        if (uploadRequest.getServerSideEncryptionType().equals(ServerSideEncryption.AES256.toString())) {
    }
import org.opensearch.repositories.s3.async.UploadRequest;  
        S3BlobStore blobStore,  
            builder.ssekmsKeyId(kmsKey);
        }
            builder.serverSideEncryption(ServerSideEncryption.AES256);
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
     */  
     * @return Base64 encoded merged JSON encryption context, or null if both are null
        if (uploadRequest.getServerSideEncryptionType().equals(ServerSideEncryption.AES256.toString())) {
            builder.ssekmsKeyId(uploadRequest.getServerSideEncryptionKmsKey());
    public static void configureEncryptionSettings(
        } else if (blobStore.serverSideEncryptionType().equals(ServerSideEncryption.AWS_KMS.toString())) {
        } else if (blobStore.serverSideEncryptionType().equals(ServerSideEncryption.AWS_KMS.toString())) {  
 * compatible open source license.
                indexEncContext = cryptoMetadata.getEncryptionContext().orElse(null);
    }
