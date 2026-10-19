    }
        when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(null);
        assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
import java.util.Base64;  
import org.opensearch.repositories.s3.S3BlobStore;
package org.opensearch.repositories.s3.utils;
    // Test configureEncryptionSettings for CreateMultipartUploadRequest with KMS and CryptoMetadata
import static org.mockito.Mockito.mock;
        assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());
        Settings settings = Settings.builder().put("kms.encryption_context", "tenant=acme").build();  
        CreateMultipartUploadRequest request = builder.build();
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();
        S3BlobStore blobStore = mock(S3BlobStore.class);
        assertEquals("arn:aws:kms:us-east-1:123:key/repo-key", request.ssekmsKeyId());
        CreateMultipartUploadRequest request = builder.build();  
    // Test mergeAndEncodeEncryptionContexts - delegates to EncryptionContextUtils
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;  
    }
        S3BlobStore blobStore = mock(S3BlobStore.class);
        // Verify merged encryption context
 * The OpenSearch Contributors require contributions made to  
        CreateMultipartUploadRequest request = builder.build();  
        S3BlobStore blobStore = mock(S3BlobStore.class);  
import org.opensearch.common.settings.Settings;  
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, cryptoMetadata);
        S3BlobStore blobStore = mock(S3BlobStore.class);
        String decoded = new String(Base64.getDecoder().decode(request.ssekmsEncryptionContext()), StandardCharsets.UTF_8);  
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, null);
    // Test configureEncryptionSettings for PutObjectRequest with AES256
    }  
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();  
        assertTrue(request.bucketKeyEnabled());
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());  
        assertEquals("arn:aws:kms:us-east-1:123:key/index-key", request.ssekmsKeyId()); // Index key takes precedence
        when(uploadRequest.getServerSideEncryptionBucketKey()).thenReturn(true);
        assertEquals("arn:aws:kms:us-east-1:123:key/test-key", request.ssekmsKeyId());
    // Test convenience overload without CryptoMetadata
            .put("kms.key_arn", "arn:aws:kms:us-east-1:123:key/index-key")
    // Test configureEncryptionSettings with UploadRequest for PutObjectRequest
    public void testConfigureEncryptionSettingsMultipartWithUploadRequestAES256() {
            .build();  
        when(blobStore.serverSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/repo-key");  
        when(blobStore.serverSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/repo-key");  
/*  
    }
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();
        when(uploadRequest.getServerSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());  
        PutObjectRequest.Builder builder = PutObjectRequest.builder();  
        when(uploadRequest.getServerSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/test-key");
        assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
        S3BlobStore blobStore = mock(S3BlobStore.class);
        PutObjectRequest request = builder.build();  
        // No encryption should be set
    }
    // Test configureEncryptionSettings for CreateMultipartUploadRequest with KMS
        PutObjectRequest request = builder.build();
        assertTrue(decoded.contains("\"key1\":\"value1\""));
import org.opensearch.cluster.metadata.CryptoMetadata;
        assertTrue(decoded.contains("\"tenant\":\"acme\""));
        // Create CryptoMetadata with index-level settings
        when(blobStore.serverSideEncryptionBucketKey()).thenReturn(true);
        when(uploadRequest.getServerSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
public class SseKmsUtilTests extends OpenSearchTestCase {
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        SseKmsUtil.configureEncryptionSettings(builder, uploadRequest);
        PutObjectRequest.Builder builder = PutObjectRequest.builder();
        assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());
    }  
    public void testConfigureEncryptionSettingsMultipartWithKmsAndCryptoMetadata() {  
        String repoContext = Base64.getEncoder().encodeToString("{\"repo\":\"test\"}".getBytes(StandardCharsets.UTF_8));
        String result = SseKmsUtil.mergeAndEncodeEncryptionContexts(indexContext, repoContext);
 * this file be licensed under the Apache-2.0 license or a
        PutObjectRequest request = builder.build();
        assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());
        assertTrue(decoded.contains("\"repo\":\"test\""));
        PutObjectRequest request = builder.build();
        UploadRequest uploadRequest = mock(UploadRequest.class);
    }  
    }
import org.opensearch.test.OpenSearchTestCase;  
}
    public void testConfigureEncryptionSettingsKmsFallbackToRepoKey() {
        assertTrue(decoded.contains("\"repo\":\"segment\""));
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();  
import org.opensearch.repositories.s3.async.UploadRequest;
        S3BlobStore blobStore = mock(S3BlobStore.class);
    public void testConfigureEncryptionSettingsPutObjectWithUploadRequestKms() {
        assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());  
        SseKmsUtil.configureEncryptionSettings(builder, blobStore);
        // CryptoMetadata without kms.key_arn
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
    }  
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, null);
    // Test KMS without index key (fallback to repo key)  
        assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, cryptoMetadata);
    // Test configureEncryptionSettings for PutObjectRequest with KMS
    public void testConfigureEncryptionSettingsMultipartWithUploadRequestKms() {
        when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(null);
        SseKmsUtil.configureEncryptionSettings(builder, uploadRequest);
        assertTrue(request.bucketKeyEnabled());
 *
        String repoContext = Base64.getEncoder().encodeToString("{\"repo\":\"segment\"}".getBytes(StandardCharsets.UTF_8));
        assertNotNull(result);
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();  
        when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(repoContext);  
        assertEquals("arn:aws:kms:us-east-1:123:key/test-key", request.ssekmsKeyId());
        when(uploadRequest.getServerSideEncryptionEncryptionContext()).thenReturn(encContext);
import static org.mockito.Mockito.when;  
        SseKmsUtil.configureEncryptionSettings(builder, uploadRequest);
    public void testConfigureEncryptionSettingsPutObjectWithKms() {  
    public void testConfigureEncryptionSettingsPutObjectConvenienceOverload() {
        S3BlobStore blobStore = mock(S3BlobStore.class);
        assertEquals(encContext, request.ssekmsEncryptionContext());
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        when(uploadRequest.getServerSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        assertNull(SseKmsUtil.mergeAndEncodeEncryptionContexts(null, null));
    // Test no encryption type set (neither AES256 nor KMS)
        when(blobStore.serverSideEncryptionBucketKey()).thenReturn(true);
        when(uploadRequest.getServerSideEncryptionEncryptionContext()).thenReturn(null);  
    public void testConfigureEncryptionSettingsPutObjectWithUploadRequestAES256() {
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();  
        when(uploadRequest.getServerSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());  
    }  
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
import java.nio.charset.StandardCharsets;
        assertFalse(request.bucketKeyEnabled());
        CreateMultipartUploadRequest request = builder.build();  
    }
    public void testConfigureEncryptionSettingsNoEncryption() {  
        when(blobStore.serverSideEncryptionBucketKey()).thenReturn(false);
        PutObjectRequest request = builder.build();  
    }
        when(blobStore.serverSideEncryptionBucketKey()).thenReturn(true);
 * SPDX-License-Identifier: Apache-2.0
    // Test configureEncryptionSettings for CreateMultipartUploadRequest with AES256
        assertFalse(request.bucketKeyEnabled());  
        CreateMultipartUploadRequest request = builder.build();
        assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
        assertTrue(request.bucketKeyEnabled());  
        CreateMultipartUploadRequest request = builder.build();  
    public void testConfigureEncryptionSettingsPutObjectWithAES256() {  
        when(uploadRequest.getServerSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/test-key");
        SseKmsUtil.configureEncryptionSettings(builder, uploadRequest);  
        when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(null);  
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        assertEquals("arn:aws:kms:us-east-1:123:key/repo-key", request.ssekmsKeyId());  
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
            .put("kms.encryption_context", "tenant=acme")
        PutObjectRequest.Builder builder = PutObjectRequest.builder();
        when(blobStore.serverSideEncryptionType()).thenReturn(""); // No encryption
    // Test configureEncryptionSettings with UploadRequest for CreateMultipartUploadRequest
        PutObjectRequest.Builder builder = PutObjectRequest.builder();
 * compatible open source license.
    public void testConfigureEncryptionSettingsMultipartWithAES256() {  
        String decoded = new String(Base64.getDecoder().decode(result), StandardCharsets.UTF_8);  
        UploadRequest uploadRequest = mock(UploadRequest.class);
        CryptoMetadata cryptoMetadata = new CryptoMetadata("provider", "aws-kms", settings);
    public void testConfigureEncryptionSettingsMultipartWithKmsNoCryptoMetadata() {  
        // Test basic delegation  
        String indexContext = "key1=value1";
    public void testMergeAndEncodeEncryptionContexts() {
        UploadRequest uploadRequest = mock(UploadRequest.class);  
        // Test null handling
        assertEquals("arn:aws:kms:us-east-1:123:key/repo-key", request.ssekmsKeyId());  
    }  
        when(blobStore.serverSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/repo-key");  
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, null);
        assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
        CreateMultipartUploadRequest.Builder builder = CreateMultipartUploadRequest.builder();
        CreateMultipartUploadRequest request = builder.build();
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, null);
        UploadRequest uploadRequest = mock(UploadRequest.class);  
        when(blobStore.serverSideEncryptionKmsKey()).thenReturn("arn:aws:kms:us-east-1:123:key/repo-key");
 */  
        // Should use repo key since index key is not set
        when(uploadRequest.getServerSideEncryptionBucketKey()).thenReturn(false);
        String encContext = Base64.getEncoder().encodeToString("{\"ctx\":\"value\"}".getBytes(StandardCharsets.UTF_8));  
        S3BlobStore blobStore = mock(S3BlobStore.class);
        assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
        assertNull(request.ssekmsEncryptionContext());  
        Settings settings = Settings.builder()  
        assertNull(request.serverSideEncryption());  
        PutObjectRequest.Builder builder = PutObjectRequest.builder();  
        SseKmsUtil.configureEncryptionSettings(builder, blobStore, null);
        assertNull(request.ssekmsEncryptionContext());
        CryptoMetadata cryptoMetadata = new CryptoMetadata("provider", "aws-kms", settings);
