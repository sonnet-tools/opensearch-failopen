            Executors.newSingleThreadExecutor(),
            "bucket",
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadResponse;  
                ByteSizeUnit.MB.toBytes(1),  
            abortMultipartUploadResponseCompletableFuture
            assertTrue("InputStream was still open after upload", closeError);  
                t -> t instanceof IOException && t.getMessage().contains("Already closed")
        verify(s3AsyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));  
            new StreamContext((partIdx, partSize, position) -> {
        verify(s3AsyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));  
import static org.mockito.Mockito.verify;
            completeMultipartUploadResponseCompletableFuture
    public void testOneChunkUpload() {
            new StatsMetricPublisher()
    }
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;  
        createMultipartUploadRequestCompletableFuture.complete(CreateMultipartUploadResponse.builder().uploadId("uploadId").build());
            new UploadRequest("bucket", "key", ByteSizeUnit.MB.toBytes(1), WritePriority.HIGH, uploadSuccess -> {
        }
        );  
            new StreamContext((partIdx, partSize, position) -> {
                streamRef.set(new ZeroInputStream(partSize));  
                ex,
            randomAlphaOfLength(10),
    }
        when(s3AsyncClient.abortMultipartUpload(any(AbortMultipartUploadRequest.class))).thenReturn(abortFuture);
     * added no future, so allOfExceptionForwarded() completed successfully on the shorter futures
     * Regression: when provideStream() throws for one part (e.g., AlreadyClosedException from a
            completeMultipartUploadResponseCompletableFuture
        CompletableFuture<CreateMultipartUploadResponse> createMultipartUploadRequestCompletableFuture = new CompletableFuture<>();
        metadata.put("key1", "value1");
            ServerSideEncryption.AWS_KMS.toString(),
        putObjectResponseCompletableFuture.completeExceptionally(
    private AsyncTransferManager asyncTransferManager;
            new StreamContext((partIdx, partSize, position) -> {
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
import software.amazon.awssdk.http.HttpStatusCode;  
                t -> t instanceof IOException && t.getMessage().contains("Already closed")
            new StreamContext(
    }  
import org.opensearch.common.io.InputStreamContainer;  
        );
import java.util.HashMap;
            new TransferSemaphoresHolder(
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
            new StreamContext(  
        assertTrue(
            new StatsMetricPublisher()  
    @Before
            ),  
        assertTrue(  
import org.opensearch.ExceptionsHelper;
                5
        setUpMultipartMocks();
            ).isPresent()  
import org.opensearch.core.common.unit.ByteSizeUnit;
                ByteSizeUnit.MB.toBytes(1),
        verify(s3AsyncClient, times(5)).uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class));
        deleteObjectResponseCompletableFuture.complete(DeleteObjectResponse.builder().build());  
            S3Exception.builder()
import org.opensearch.common.blobstore.exception.CorruptFileException;
        verify(s3AsyncClient, times(1)).putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class));  
            s3AsyncClient,
            boolean closeError = false;  
                return new InputStreamContainer(streamRef.get(), partSize, position);
            assertTrue(throwable instanceof CorruptFileException);
                if (partIdx == 2) {  
            }, ByteSizeUnit.MB.toBytes(1), ByteSizeUnit.MB.toBytes(1), 5),
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(ex, t -> t instanceof NullPointerException).isPresent()
        verify(s3AsyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
        when(s3AsyncClient.deleteObject(any(DeleteObjectRequest.class))).thenReturn(deleteObjectResponseCompletableFuture);
    public void testMultipartUpload() {
            "Original IOException must be in the cause chain",
        // Original IOException must appear in the cause chain  
        );  
     * Fix: add a pre-failed CompletableFuture for any part whose provideStream() throws, so  
            Throwable throwable = ExceptionsHelper.unwrap(e, CorruptFileException.class);
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadResponse;
 * The OpenSearch Contributors require contributions made to  
     * the original IOException.
        streams.forEach(stream -> {
     * leaving a null slot in inputStreamContainers and later NPE-ing in mergeAndVerifyChecksum.
        );  
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;
        createFuture.complete(CreateMultipartUploadResponse.builder().uploadId("uploadId").build());
            new UploadRequest("bucket", "key", ByteSizeUnit.MB.toBytes(5), WritePriority.HIGH, uploadSuccess -> {  
        // Must NOT be NPE (was the pre-fix symptom)
                5,
            s3AsyncClient,  
                return new InputStreamContainer(stream, partSize, position);  
        List<InputStream> streams = new ArrayList<>();  
 */  
     * exception propagates to the caller.
import java.io.InputStream;  
        Map<String, String> metadata = new HashMap<>();
        when(s3AsyncClient.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(  
                3,  
        CompletableFuture<CreateMultipartUploadResponse> createFuture = new CompletableFuture<>();
            "key",
import software.amazon.awssdk.services.s3.model.S3Exception;  
        verify(s3AsyncClient, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));  
    public void setUp() throws Exception {  
     * completed immediately, then mergeAndVerifyChecksum NPE'd on slot 0.
        CompletableFuture<UploadPartResponse> uploadPartResponseCompletableFuture = new CompletableFuture<>();
            resultFuture.get();
 *
        CompletableFuture<CreateMultipartUploadResponse> createMultipartUploadRequestCompletableFuture = new CompletableFuture<>();
                return new InputStreamContainer(new ZeroInputStream(partSize), partSize, position);  
        verify(s3AsyncClient, times(1)).putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class));  
        );
            streamRef.get().available();
            s3AsyncClient,  
        verify(s3AsyncClient, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
                .statusCode(HttpStatusCode.BAD_REQUEST)  
                // do nothing
            Throwable throwable = ExceptionsHelper.unwrap(e, CorruptFileException.class);
        when(s3AsyncClient.abortMultipartUpload(any(AbortMultipartUploadRequest.class))).thenReturn(
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(  
            }, false, null, true, metadata, ServerSideEncryption.AWS_KMS.toString(), randomAlphaOfLength(10), true, null, null),
            ).isPresent()  
            "Must not surface as NullPointerException",  
    }  
    /**
    }
                genericStatsMetricPublisher
            uploadPartResponseCompletableFuture
import software.amazon.awssdk.services.s3.model.UploadPartResponse;  
        );  
            assertNotNull(throwable);
        try {
        verify(s3AsyncClient, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));  
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
     * Regression: all parts fail — futures list is empty. allOfExceptionForwarded on [] used to
        );
        Map<String, String> metadata = new HashMap<>();  
                // do nothing
            new StatsMetricPublisher()
                InputStream stream = new ZeroInputStream(partSize);
        verify(s3AsyncClient, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
     * complete immediately with success, then NPE on every slot. With the fix every part adds a
import java.util.concurrent.ExecutionException;  
    @Override
 * compatible open source license.
        }
import java.util.List;  
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
            }, ByteSizeUnit.MB.toBytes(1), ByteSizeUnit.MB.toBytes(1), 5),
        verify(s3AsyncClient, times(0)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));  
        CompletableFuture<Void> resultFuture = asyncTransferManager.uploadObject(
 * SPDX-License-Identifier: Apache-2.0
        uploadPartResponseCompletableFuture.complete(UploadPartResponse.builder().checksumCRC32("pzjqHA==").build());  
            new StreamContext((partIdx, partSize, position) -> {  
        }
        CompletableFuture<CompleteMultipartUploadResponse> completeMultipartUploadResponseCompletableFuture = new CompletableFuture<>();
    }  
            new StatsMetricPublisher()
        metadata.put("key1", "value1");  
                    throw new IOException("Already closed: MemorySegmentIndexInput(path=\"_merged_430d.parquet\")");  
        putObjectResponseCompletableFuture.complete(PutObjectResponse.builder().build());  
        completeMultipartUploadResponseCompletableFuture.complete(CompleteMultipartUploadResponse.builder().build());  
        Map<String, String> metadata = new HashMap<>();
        when(s3AsyncClient.uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class))).thenReturn(
        verify(s3AsyncClient, times(5)).uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class));
import software.amazon.awssdk.awscore.exception.AwsErrorDetails;
            createMultipartUploadRequestCompletableFuture
        CompletableFuture<UploadPartResponse> partFuture = new CompletableFuture<>();
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;
    public void testMultipartUploadProvideStreamExceptionOnAllParts() throws Exception {
        boolean closeError = false;
import java.util.concurrent.atomic.AtomicReference;  
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
                throw new IOException("Already closed: MemorySegmentIndexInput(path=\"_merged_430d.parquet\")");  
import org.opensearch.common.StreamContext;  
        metadata.put("key2", "value2");
        verify(s3AsyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
    public void testMultipartUploadProvideStreamExceptionOnMiddlePart() throws Exception {
                TimeUnit.MINUTES,  
                ex,  
        partFuture.complete(UploadPartResponse.builder().checksumCRC32("pzjqHA==").build());  
    public void testMultipartUploadCorruption() {  
                closeError = e.getMessage().equals("Stream closed");
        CompletableFuture<AbortMultipartUploadResponse> abortMultipartUploadResponseCompletableFuture = new CompletableFuture<>();
                }
import java.io.IOException;
        verify(s3AsyncClient, times(1)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
import java.util.concurrent.Executors;
     * concurrently-merged Lucene segment), the upload must fail cleanly rather than silently  
     * and numberOfParts (5) is handled — previously allOfExceptionForwarded on an empty list
     */  
     * failed future so the first failure propagates correctly.  
        try {
        when(s3AsyncClient.completeMultipartUpload(any(CompleteMultipartUploadRequest.class))).thenReturn(
                ByteSizeUnit.MB.toBytes(1),
            assertTrue(throwable instanceof CorruptFileException);  
        assertFalse(
        when(s3AsyncClient.uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class))).thenReturn(partFuture);
                // do nothing  
            ByteSizeUnit.MB.toBytes(5),  
            putObjectResponseCompletableFuture
        } catch (ExecutionException | InterruptedException e) {  
            try {
            resultFuture.get();
        metadata.put("key1", "value1");
        CompletableFuture<DeleteObjectResponse> deleteObjectResponseCompletableFuture = new CompletableFuture<>();
    /**
                ByteSizeUnit.MB.toBytes(1),  
            }, false, null, true, metadata, ServerSideEncryption.AWS_KMS.toString(), randomAlphaOfLength(10), true, null, null),
        }  
        } catch (ExecutionException | InterruptedException e) {
        verify(s3AsyncClient, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
        );
import software.amazon.awssdk.core.async.AsyncRequestBody;
        try {  
        );  
                }
public class AsyncTransferManagerTests extends OpenSearchTestCase {
        );
import org.opensearch.repositories.s3.GenericStatsMetricPublisher;  
     *
        try {  
            new UploadRequest("bucket", "key", ByteSizeUnit.MB.toBytes(1), WritePriority.HIGH, uploadSuccess -> {  
     * "Failed to send multipart upload requests" SdkClientException wrapping an NPE instead of  
        verify(s3AsyncClient, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
import static org.mockito.Mockito.times;
        ExecutionException ex = expectThrows(ExecutionException.class, () -> result.get(5, TimeUnit.SECONDS));
    private UploadRequest buildUploadRequest(boolean integrityCheck, long checksum) {
/*  
        CompletableFuture<Void> resultFuture = asyncTransferManager.uploadObject(
        ExecutionException ex = expectThrows(ExecutionException.class, () -> result.get(5, TimeUnit.SECONDS));
    }
        } catch (ExecutionException | InterruptedException e) {
        );
        asyncTransferManager = new AsyncTransferManager(  
            new HashMap<>(),  
        try {  
            s3AsyncClient,  
import java.util.ArrayList;
import static org.mockito.Mockito.mock;  
            new UploadRequest("bucket", "key", ByteSizeUnit.MB.toBytes(5), WritePriority.HIGH, uploadSuccess -> {
                1
    public void testMultipartUploadProvideStreamExceptionOnFirstPart() throws Exception {
            }, true, 0L, true, metadata, ServerSideEncryption.AWS_KMS.toString(), randomAlphaOfLength(10), true, null, null),  
import java.util.concurrent.TimeUnit;
        metadata.put("key2", "value2");  
            fail("did not expect resultFuture to pass");
     * allOfExceptionForwarded() sees the failure, the upload is aborted, and the original
                .build()
package org.opensearch.repositories.s3.async;
            s3AsyncClient,
    private S3AsyncClient s3AsyncClient;
     * Regression: same fix, first part fails. Ensures the mismatch between futures list size (0)  
        );  
import java.util.Map;
            uploadPartResponseCompletableFuture
        CompletableFuture<AbortMultipartUploadResponse> abortFuture = new CompletableFuture<>();  
     */  
        return new UploadRequest(  
        ExecutionException ex = expectThrows(ExecutionException.class, () -> result.get(5, TimeUnit.SECONDS));
            true,  
            "Must not surface as NullPointerException",
import static org.mockito.ArgumentMatchers.any;
            buildUploadRequest(true, 3376132981L),
        assertFalse(
import java.util.concurrent.CompletableFuture;
        assertTrue("InputStream was still open after upload", closeError);
            resultFuture.get();  
            }, ByteSizeUnit.MB.toBytes(1), ByteSizeUnit.MB.toBytes(1), 1),
 * this file be licensed under the Apache-2.0 license or a
            ),
            }, ByteSizeUnit.MB.toBytes(1), ByteSizeUnit.MB.toBytes(1), 5),  
import static org.mockito.Mockito.when;  
        CompletableFuture<Void> result = asyncTransferManager.uploadObject(
        CompletableFuture<Void> resultFuture = asyncTransferManager.uploadObject(
        Map<String, String> metadata = new HashMap<>();  
        completeMultipartUploadResponseCompletableFuture.complete(CompleteMultipartUploadResponse.builder().build());
}
        );  
            new StreamContext((partIdx, partSize, position) -> {
            buildUploadRequest(true, 3376132981L),  
    /**  
import org.junit.Before;  
    }
    public void testOneChunkUploadCorruption() {
            } catch (IOException e) {  
        CompletableFuture<PutObjectResponse> putObjectResponseCompletableFuture = new CompletableFuture<>();
            s3AsyncClient,
            "Original IOException from provideStream must be in the cause chain",
            abortMultipartUploadResponseCompletableFuture
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(  
        metadata.put("key2", "value2");
            putObjectResponseCompletableFuture
        CompletableFuture<PutObjectResponse> putObjectResponseCompletableFuture = new CompletableFuture<>();  
        when(s3AsyncClient.putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class))).thenReturn(
        );
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(ex, t -> t instanceof NullPointerException).isPresent()
        super.setUp();
            new StatsMetricPublisher()  
    }
        metadata.put("key2", "value2");
        );  
        );
            assertNotNull(throwable);  
import org.opensearch.repositories.s3.StatsMetricPublisher;
        );
     *
        s3AsyncClient = mock(S3AsyncClient.class);
        );
        when(s3AsyncClient.putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class))).thenReturn(
import software.amazon.awssdk.services.s3.S3AsyncClient;
            createMultipartUploadRequestCompletableFuture
        abortFuture.complete(AbortMultipartUploadResponse.builder().build());
        when(s3AsyncClient.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(
        CompletableFuture<Void> result = asyncTransferManager.uploadObject(
                ex,
            uploadSuccess -> {},
        metadata.put("key1", "value1");
import org.opensearch.test.OpenSearchTestCase;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
import org.opensearch.common.blobstore.stream.write.WritePriority;
                return new InputStreamContainer(new ZeroInputStream(partSize), partSize, position);
    }
            "Must not surface as NullPointerException",  
            new StatsMetricPublisher()
     */
        when(s3AsyncClient.abortMultipartUpload(any(AbortMultipartUploadRequest.class))).thenReturn(  
        // Part index 2 (middle) throws — simulates AlreadyClosedException from mmap'd segment
        verify(s3AsyncClient, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
            fail("did not expect resultFuture to fail");  
            "Original IOException must be in the cause chain",
            null,
            buildUploadRequest(true, 3376132981L),
        setUpMultipartMocks();
            true,
                if (partIdx == 0) {
        }
            }
        AtomicReference<InputStream> streamRef = new AtomicReference<>();
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
            Executors.newSingleThreadExecutor(),
            integrityCheck,  
        verify(s3AsyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
            ).isPresent()
                // do nothing
            fail("did not expect resultFuture to pass");  
            new StatsMetricPublisher()
        setUpMultipartMocks();  
            )
        abortMultipartUploadResponseCompletableFuture.complete(AbortMultipartUploadResponse.builder().build());  
        );  
        createMultipartUploadRequestCompletableFuture.complete(CreateMultipartUploadResponse.builder().uploadId("uploadId").build());  
                (partIdx, partSize, position) -> new InputStreamContainer(new ZeroInputStream(partSize), partSize, position),
    private void setUpMultipartMocks() {  
        );  
                t -> t instanceof IOException && t.getMessage().contains("Already closed")
            checksum,
            ByteSizeUnit.MB.toBytes(5),
        uploadPartResponseCompletableFuture.complete(UploadPartResponse.builder().checksumCRC32("pzjqHA==").build());
            null
        when(s3AsyncClient.completeMultipartUpload(any(CompleteMultipartUploadRequest.class))).thenReturn(  
        when(s3AsyncClient.uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class))).thenReturn(  
        );  
        CompletableFuture<AbortMultipartUploadResponse> abortMultipartUploadResponseCompletableFuture = new CompletableFuture<>();
        CompletableFuture<Void> result = asyncTransferManager.uploadObject(
            resultFuture.get();
        );  
        } catch (IOException e) {
            Executors.newSingleThreadExecutor(),  
        );  
            }, ByteSizeUnit.MB.toBytes(1), ByteSizeUnit.MB.toBytes(1), 5),
        CompletableFuture<Void> resultFuture = asyncTransferManager.uploadObject(  
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(ex, t -> t instanceof NullPointerException).isPresent()
            s3AsyncClient,
            closeError = e.getMessage().equals("Stream closed");  
        );
        } catch (ExecutionException | InterruptedException e) {
            }, true, 3376132981L, true, metadata, ServerSideEncryption.AWS_KMS.toString(), randomAlphaOfLength(10), true, null, null),
        abortMultipartUploadResponseCompletableFuture.complete(AbortMultipartUploadResponse.builder().build());
                (partIdx, partSize, position) -> new InputStreamContainer(new ZeroInputStream(partSize), partSize, position),
        });
                Math.max(Runtime.getRuntime().availableProcessors() * 5, 10),
        );
     * list, then mergeAndVerifyChecksum() dereferenced the null slot — producing a confusing
                stream.available();
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(
        assertTrue(
        assertFalse(  
    // ── Helpers ────────────────────────────────────────────────────────────────
     * Root cause: the catch block in AsyncPartsHandler.uploadParts() swallowed the exception and  
        when(s3AsyncClient.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(createFuture);  
        CompletableFuture<CompleteMultipartUploadResponse> completeMultipartUploadResponseCompletableFuture = new CompletableFuture<>();
                    throw new IOException("Already closed: MemorySegmentIndexInput(path=\"_merged_430d.parquet\")");
        CompletableFuture<UploadPartResponse> uploadPartResponseCompletableFuture = new CompletableFuture<>();
            WritePriority.HIGH,
        );  
import org.opensearch.repositories.blobstore.ZeroInputStream;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;  
                streams.add(stream);
            fail("did not expect resultFuture to fail");
                .awsErrorDetails(AwsErrorDetails.builder().errorCode("BadDigest").build())
        verify(s3AsyncClient, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));  
        verify(s3AsyncClient, times(1)).deleteObject(any(DeleteObjectRequest.class));
