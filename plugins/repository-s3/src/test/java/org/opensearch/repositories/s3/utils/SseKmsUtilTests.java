        PutObjectRequest request = builder.build();
        assertNull(request.serverSideEncryption());
        when(blobStore.serverSideEncryptionType()).thenReturn(""); // No encryption
        assertNull(SseKmsUtil.mergeAndEncodeEncryptionContexts(null, null));
        // Should use repo key since index key is not set
public class SseKmsUtilTests extends OpenSearchTestCase {
        S3BlobStore blobStore = mock(S3BlobStore.class);
        assertFalse(request.bucketKeyEnabled());
            .put("kms.key_arn", "arn:aws:kms:us-east-1:123:key/index-key")
import org.opensearch.common.settings.Settings;
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();
        CreateMultipartUploadRequest request = builder.build();
        assertEquals("arn:aws:kms:us-east-1:123:key/test-key", request.ssekmsKeyId());
    public void testConfigureEncryptionSettingsPutObjectWithAES256() {
        UploadRequest uploadRequest = mock(UploadRequest.class);
}
        S3BlobStore blobStore = mock(S3BlobStore.class);
    }
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
        when(uploadRequest.getServerSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/test-key");
            .put("kms.encryption_context", "tenant=acme")
        when(uploadRequest.getServerSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        when(uploadRequest.getServerSideEncryptionBucketKey()).thenReturn(true);
        CreateMultipartUploadRequest request = builder.build();
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();
        SseKmsUtil.configureEncryptionSettings(builder, uploadRequest);
    }
        assertNull(request.ssekmsEncryptionContext());
        CryptoMetadata cryptoMetadata = new CryptoMetadata("provider", "aws-kms", settings);
 * this file be licensed under the Apache-2.0 license or a
/*
        assertEquals("arn:aws:kms:us-east-1:123:key/repo-key", request.ssekmsKeyId());
        assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());
    // Test convenience overload without CryptoMetadata
    // Test configureEncryptionSettings for CreateMultipartUploadRequest with KMS and CryptoMetadata
import org.opensearch.repositories.s3.async.UploadRequest;
        UploadRequest uploadRequest = mock(UploadRequest.class);
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, cryptoMetadata);
        assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.mock;
            .build();
        String repoContext = Base64.getEncoder().encodeToString("{\"repo\":\"test\"}".getBytes(StandardCharsets.UTF_8));
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, null);
        S3BlobStore blobStore = mock(S3BlobStore.class);
package org.opensearch.repositories.s3.utils;
        assertTrue(request.bucketKeyEnabled());
        when(uploadRequest.getServerSideEncryptionEncryptionContext()).thenReturn(null);
        when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(repoContext);
    }
import org.opensearch.repositories.s3.S3BlobStore;
    public void testConfigureEncryptionSettingsNoEncryption() {
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();
    public void testConfigureEncryptionSettingsPutObjectWithKms() {
        assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());
        assertTrue(decoded.contains("\"repo\":\"test\""));
        assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());
        PutObjectRequest request = builder.build();
        when(uploadRequest.getServerSideEncryptionBucketKey()).thenReturn(false);
        // Test null handling
        // Verify merged encryption context
 *
    }
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
        when(blobStore.serverSideEncryptionBucketKey()).thenReturn(false);
        when(uploadRequest.getServerSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
    public void testConfigureEncryptionSettingsMultipartWithUploadRequestKms() {
        CreateMultipartUploadRequest request = builder.build();
        assertFalse(request.bucketKeyEnabled());
        String encContext = Base64.getEncoder().encodeToString("{\"ctx\":\"value\"}".getBytes(StandardCharsets.UTF_8));
        String decoded = new String(Base64.getDecoder().decode(request.ssekmsEncryptionContext()), StandardCharsets.UTF_8);
        CreateMultipartUploadRequest request = builder.build();
        assertTrue(request.bucketKeyEnabled());
        assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
        S3BlobStore blobStore = mock(S3BlobStore.class);
        when(blobStore.serverSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/repo-key");
    public void testConfigureEncryptionSettingsPutObjectWithUploadRequestAES256() {
        assertNull(request.ssekmsEncryptionContext());
        when(uploadRequest.getServerSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
    }
        when(blobStore.serverSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/repo-key");
        SseKmsUtil.configureEncryptionSettings(builder, uploadRequest);
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());
import java.nio.charset.StandardCharsets;
        S3BlobStore blobStore = mock(S3BlobStore.class);
    // Test KMS without index key (fallback to repo key)
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();
    }
    }
        Settings settings = Settings.builder()
        when(blobStore.serverSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/repo-key");
        PutObjectRequest request = builder.build();
        CreateMultipartUploadRequest request = builder.build();
    }
        when(blobStore.serverSideEncryptionBucketKey()).thenReturn(true);
        CryptoMetadata cryptoMetadata = new CryptoMetadata("provider", "aws-kms", settings);
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();
    public void testConfigureEncryptionSettingsPutObjectWithUploadRequestKms() {
    // Test configureEncryptionSettings for CreateMultipartUploadRequest with KMS
        PutObjectRequest request = builder.build();
        assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        UploadRequest uploadRequest = mock(UploadRequest.class);
import java.util.Base64;
        S3BlobStore blobStore = mock(S3BlobStore.class);
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();
        assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
    // Test configureEncryptionSettings with UploadRequest for PutObjectRequest
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, null);
import org.opensearch.test.OpenSearchTestCase;
    public void testConfigureEncryptionSettingsMultipartWithAES256() {
        SseKmsUtil.configureEncryptionSettings(builder, uploadRequest);
        PutObjectRequest.Builder builder = PutObjectRequest.builder();
 * compatible open source license.
        CreateMultipartUploadRequest request = builder.build();
        assertEquals(encContext, request.ssekmsEncryptionContext());
    public void testMergeAndEncodeEncryptionContexts() {
 * SPDX-License-Identifier: Apache-2.0
        when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(null);
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        String decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);
        S3BlobStore blobStore = mock(S3BlobStore.class);
    }
    public void testConfigureEncryptionSettingsKmsFallbackToRepoKey() {
        UploadRequest uploadRequest = mock(UploadRequest.class);
        when(uploadRequest.getServerSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/test-key");
    public void testConfigureEncryptionSettingsMultipartWithKmsAndCryptoMetadata() {
        PutObjectRequest.Builder builder = PutObjectRequest.builder();
        assertTrue(decoded.contains("\"tenant\":\"acme\""));
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, null);
        SseKmsUtil.configureEncryptionSettings(builder, uploadRequest);
        String repoContext = Base64.getEncoder().encodeToString("{\"repo\":\"segment\"}".getBytes(StandardCharsets.UTF_8));
    // Test configureEncryptionSettings for PutObjectRequest with KMS
    }
        S3BlobStore blobStore = mock(S3BlobStore.class);
    }
        assertNotNull(result);
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();
        when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(null);
    public void testConfigureEncryptionSettingsMultipartWithUploadRequestAES256() {
    // Test configureEncryptionSettings with UploadRequest for CreateMultipartUploadRequest
        when(blobStore.serverSideEncryptionBucketKey()).thenReturn(true);
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, null);
        String indexContext = "key1=value1";
        when(blobStore.serverSideEncryptionBucketKey()).thenReturn(true);
    }
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, null);
    public void testConfigureEncryptionSettingsMultipartWithKmsNoCryptoMetadata() {
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        assertEquals("arn:aws:kms:us-east-1:123:key/index-key", request.ssekmsKeyId()); // Index key takes precedence
        Settings settings = Settings.builder().put("kms.encryption_context", "tenant=acme").build();
    // Test configureEncryptionSettings for CreateMultipartUploadRequest with AES256
        assertEquals("arn:aws:kms:us-east-1:123:key/repo-key", request.ssekmsKeyId());
        PutObjectRequest.Builder builder = PutObjectRequest.builder();
    // Test mergeAndEncodeEncryptionContexts - delegates to EncryptionContextUtils
        PutObjectRequest.Builder builder = PutObjectRequest.builder();
        SseKmsUtil.configureEncryptionSettings(builder, blobStore);
    }
    // Test configureEncryptionSettings for PutObjectRequest with AES256
        when(uploadRequest.getServerSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        when(uploadRequest.getServerSideEncryptionEncryptionContext()).thenReturn(encContext);
        // Create CryptoMetadata with index-level settings
        PutObjectRequest request = builder.build();
    // Test no encryption type set (neither AES256 nor KMS)
        // Test basic delegation
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
import org.opensearch.cluster.metadata.CryptoMetadata;
        assertEquals("arn:aws:kms:us-east-1:123:key/repo-key", request.ssekmsKeyId());
        when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(null);
        when(blobStore.serverSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/repo-key");
        String result = SseKmsUtil.mergeAndEncodeEncryptionContexts(indexContext, repoContext);
        assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());
        assertEquals("arn:aws:kms:us-east-1:123:key/test-key", request.ssekmsKeyId());
        assertTrue(decoded.contains("\"key1\":\"value1\""));
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
 */
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, cryptoMetadata);
        // CryptoMetadata without kms.key_arn
        assertTrue(request.bucketKeyEnabled());
        PutObjectRequest.Builder builder = PutObjectRequest.builder();
 * The OpenSearch Contributors require contributions made to
        assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
        CreateMultipartUploadRequest request = builder.build();
    public void testConfigureEncryptionSettingsPutObjectConvenienceOverload() {
        // No encryption should be set
        assertTrue(decoded.contains("\"repo\":\"segment\""));
