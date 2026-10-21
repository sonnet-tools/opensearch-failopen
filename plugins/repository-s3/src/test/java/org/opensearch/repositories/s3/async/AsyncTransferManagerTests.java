                stream.available();
            assertNotNull(throwable);
        metadata.put("key2", "value2");
import java.util.concurrent.CompletableFuture;
                return new InputStreamContainer(streamRef.get(), partSize, position);
        } catch (ExecutionException | InterruptedException e) {
        createFuture.complete(CreateMultipartUploadResponse.builder().uploadId("uploadId").build());
            createMultipartUploadRequestCompletableFuture
            new StreamContext((partIdx, partSize, position) -> {
            boolean closeError = false;
        Map<String, String> metadata = new HashMap<>();
        }
        );
    }
        assertTrue(
            }
        // Must NOT be NPE (was the pre-fix symptom)
    private S3AsyncClient s3AsyncClient;
        setUpMultipartMocks();
    }
        CompletableFuture<DeleteObjectResponse> deleteObjectResponseCompletableFuture = new CompletableFuture<>();
        );
                InputStream stream = new ZeroInputStream(partSize);
        );
            ServerSideEncryption.AWS_KMS.toString(),
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(
        when(s3AsyncClient.putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class))).thenReturn(
            null
            new StatsMetricPublisher()
                    throw new IOException("Already closed: MemorySegmentIndexInput(path=\"_merged_430d.parquet\")");
                Math.max(Runtime.getRuntime().availableProcessors() * 5, 10),
import java.util.concurrent.TimeUnit;
                t -> t instanceof IOException && t.getMessage().contains("Already closed")
public class AsyncTransferManagerTests extends OpenSearchTestCase {
            }, ByteSizeUnit.MB.toBytes(1), ByteSizeUnit.MB.toBytes(1), 5),
            }, ByteSizeUnit.MB.toBytes(1), ByteSizeUnit.MB.toBytes(1), 1),
            randomAlphaOfLength(10),
    public void setUp() throws Exception {
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadResponse;
        putObjectResponseCompletableFuture.complete(PutObjectResponse.builder().build());
                }
        // Original IOException must appear in the cause chain
        CompletableFuture<Void> resultFuture = asyncTransferManager.uploadObject(
            WritePriority.HIGH,
                return new InputStreamContainer(new ZeroInputStream(partSize), partSize, position);
     * "Failed to send multipart upload requests" SdkClientException wrapping an NPE instead of
                5
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
        CompletableFuture<CreateMultipartUploadResponse> createFuture = new CompletableFuture<>();
import static org.mockito.Mockito.when;
        );
        );
import static org.mockito.Mockito.mock;
    /**
        verify(s3AsyncClient, times(1)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
        verify(s3AsyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
        );
        Map<String, String> metadata = new HashMap<>();
        when(s3AsyncClient.abortMultipartUpload(any(AbortMultipartUploadRequest.class))).thenReturn(
            resultFuture.get();
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
            assertTrue(throwable instanceof CorruptFileException);
                streamRef.set(new ZeroInputStream(partSize));
            uploadSuccess -> {},
    public void testMultipartUploadCorruption() {
            completeMultipartUploadResponseCompletableFuture
        when(s3AsyncClient.abortMultipartUpload(any(AbortMultipartUploadRequest.class))).thenReturn(
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;
        CompletableFuture<Void> resultFuture = asyncTransferManager.uploadObject(
                if (partIdx == 0) {
        s3AsyncClient = mock(S3AsyncClient.class);
            fail("did not expect resultFuture to pass");
            new StatsMetricPublisher()
    public void testMultipartUpload() {
        );
        CompletableFuture<AbortMultipartUploadResponse> abortMultipartUploadResponseCompletableFuture = new CompletableFuture<>();
        CompletableFuture<CompleteMultipartUploadResponse> completeMultipartUploadResponseCompletableFuture = new CompletableFuture<>();
        );
        List<InputStream> streams = new ArrayList<>();
import software.amazon.awssdk.awscore.exception.AwsErrorDetails;
     * failed future so the first failure propagates correctly.
        CompletableFuture<PutObjectResponse> putObjectResponseCompletableFuture = new CompletableFuture<>();
            true,
        );
            Executors.newSingleThreadExecutor(),
    /**
            }, true, 3376132981L, true, metadata, ServerSideEncryption.AWS_KMS.toString(), randomAlphaOfLength(10), true, null, null),
        createMultipartUploadRequestCompletableFuture.complete(CreateMultipartUploadResponse.builder().uploadId("uploadId").build());
            new StatsMetricPublisher()
import java.util.concurrent.ExecutionException;
        abortFuture.complete(AbortMultipartUploadResponse.builder().build());
     * concurrently-merged Lucene segment), the upload must fail cleanly rather than silently
        verify(s3AsyncClient, times(5)).uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class));
        verify(s3AsyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
        verify(s3AsyncClient, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
    public void testOneChunkUploadCorruption() {
    }
            ).isPresent()
        CompletableFuture<CreateMultipartUploadResponse> createMultipartUploadRequestCompletableFuture = new CompletableFuture<>();
     * Regression: when provideStream() throws for one part (e.g., AlreadyClosedException from a
            new StreamContext((partIdx, partSize, position) -> {
            checksum,
                ByteSizeUnit.MB.toBytes(1),
                t -> t instanceof IOException && t.getMessage().contains("Already closed")
import software.amazon.awssdk.services.s3.S3AsyncClient;
            new TransferSemaphoresHolder(
 */
        CompletableFuture<Void> result = asyncTransferManager.uploadObject(
        );
            new StreamContext((partIdx, partSize, position) -> {
        metadata.put("key1", "value1");
        metadata.put("key1", "value1");
                genericStatsMetricPublisher
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(
            putObjectResponseCompletableFuture
            uploadPartResponseCompletableFuture
                (partIdx, partSize, position) -> new InputStreamContainer(new ZeroInputStream(partSize), partSize, position),
        verify(s3AsyncClient, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
                5,
        try {
            new StreamContext(
import org.opensearch.repositories.s3.StatsMetricPublisher;
 *
    public void testOneChunkUpload() {
    /**
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.blobstore.exception.CorruptFileException;
    private void setUpMultipartMocks() {
        verify(s3AsyncClient, times(1)).deleteObject(any(DeleteObjectRequest.class));
                (partIdx, partSize, position) -> new InputStreamContainer(new ZeroInputStream(partSize), partSize, position),
            createMultipartUploadRequestCompletableFuture
            ),
 * compatible open source license.
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
            new StreamContext((partIdx, partSize, position) -> {
        );
                if (partIdx == 2) {
import java.util.HashMap;
import java.util.ArrayList;
import org.opensearch.repositories.blobstore.ZeroInputStream;
        when(s3AsyncClient.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(createFuture);
            uploadPartResponseCompletableFuture
        CompletableFuture<AbortMultipartUploadResponse> abortMultipartUploadResponseCompletableFuture = new CompletableFuture<>();
            try {
        try {
import java.io.InputStream;
import java.util.concurrent.Executors;
            }, false, null, true, metadata, ServerSideEncryption.AWS_KMS.toString(), randomAlphaOfLength(10), true, null, null),
                1
                return new InputStreamContainer(stream, partSize, position);
            new StatsMetricPublisher()
     *
        when(s3AsyncClient.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(
import org.opensearch.common.StreamContext;
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadResponse;
        );
import java.util.Map;
        );
            s3AsyncClient,
    }
import org.opensearch.ExceptionsHelper;
            "Must not surface as NullPointerException",
                }
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;
import java.util.concurrent.atomic.AtomicReference;
        completeMultipartUploadResponseCompletableFuture.complete(CompleteMultipartUploadResponse.builder().build());
/*
        );
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
        return new UploadRequest(
    public void testMultipartUploadProvideStreamExceptionOnMiddlePart() throws Exception {
import static org.mockito.Mockito.times;
            "Original IOException must be in the cause chain",
            ),
import org.junit.Before;
                .statusCode(HttpStatusCode.BAD_REQUEST)
            ByteSizeUnit.MB.toBytes(5),
        assertFalse(
            buildUploadRequest(true, 3376132981L),
        when(s3AsyncClient.putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class))).thenReturn(
import software.amazon.awssdk.http.HttpStatusCode;
            Executors.newSingleThreadExecutor(),
        abortMultipartUploadResponseCompletableFuture.complete(AbortMultipartUploadResponse.builder().build());
                throw new IOException("Already closed: MemorySegmentIndexInput(path=\"_merged_430d.parquet\")");
        } catch (ExecutionException | InterruptedException e) {
                return new InputStreamContainer(new ZeroInputStream(partSize), partSize, position);
        ExecutionException ex = expectThrows(ExecutionException.class, () -> result.get(5, TimeUnit.SECONDS));
        verify(s3AsyncClient, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
        when(s3AsyncClient.deleteObject(any(DeleteObjectRequest.class))).thenReturn(deleteObjectResponseCompletableFuture);
        when(s3AsyncClient.uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class))).thenReturn(
        uploadPartResponseCompletableFuture.complete(UploadPartResponse.builder().checksumCRC32("pzjqHA==").build());
        verify(s3AsyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(ex, t -> t instanceof NullPointerException).isPresent()
        when(s3AsyncClient.uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class))).thenReturn(
package org.opensearch.repositories.s3.async;
        when(s3AsyncClient.uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class))).thenReturn(partFuture);
     */
            "bucket",
     * the original IOException.
        ExecutionException ex = expectThrows(ExecutionException.class, () -> result.get(5, TimeUnit.SECONDS));
     * Fix: add a pre-failed CompletableFuture for any part whose provideStream() throws, so
            resultFuture.get();
        );
            assertNotNull(throwable);
        verify(s3AsyncClient, times(0)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
            completeMultipartUploadResponseCompletableFuture
        verify(s3AsyncClient, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
    }
        super.setUp();
 * The OpenSearch Contributors require contributions made to
        verify(s3AsyncClient, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
     * exception propagates to the caller.
            assertTrue(throwable instanceof CorruptFileException);
     * added no future, so allOfExceptionForwarded() completed successfully on the shorter futures
            new UploadRequest("bucket", "key", ByteSizeUnit.MB.toBytes(1), WritePriority.HIGH, uploadSuccess -> {
        assertFalse(
        CompletableFuture<Void> resultFuture = asyncTransferManager.uploadObject(
            new UploadRequest("bucket", "key", ByteSizeUnit.MB.toBytes(5), WritePriority.HIGH, uploadSuccess -> {
    }
        CompletableFuture<Void> resultFuture = asyncTransferManager.uploadObject(
            true,
        CompletableFuture<UploadPartResponse> partFuture = new CompletableFuture<>();
        );
            )
import software.amazon.awssdk.core.async.AsyncRequestBody;
            "Original IOException from provideStream must be in the cause chain",
            "Must not surface as NullPointerException",
                ByteSizeUnit.MB.toBytes(1),
        abortMultipartUploadResponseCompletableFuture.complete(AbortMultipartUploadResponse.builder().build());
        verify(s3AsyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
     * and numberOfParts (5) is handled — previously allOfExceptionForwarded on an empty list
                    throw new IOException("Already closed: MemorySegmentIndexInput(path=\"_merged_430d.parquet\")");
                ByteSizeUnit.MB.toBytes(1),
            null,
            new HashMap<>(),
        CompletableFuture<UploadPartResponse> uploadPartResponseCompletableFuture = new CompletableFuture<>();
        uploadPartResponseCompletableFuture.complete(UploadPartResponse.builder().checksumCRC32("pzjqHA==").build());
     * Regression: all parts fail — futures list is empty. allOfExceptionForwarded on [] used to
import org.opensearch.core.common.unit.ByteSizeUnit;
            s3AsyncClient,
        // Part index 2 (middle) throws — simulates AlreadyClosedException from mmap'd segment
        deleteObjectResponseCompletableFuture.complete(DeleteObjectResponse.builder().build());
import org.opensearch.common.blobstore.stream.write.WritePriority;
        assertTrue(
            new StreamContext((partIdx, partSize, position) -> {
        CompletableFuture<AbortMultipartUploadResponse> abortFuture = new CompletableFuture<>();
        try {
        when(s3AsyncClient.abortMultipartUpload(any(AbortMultipartUploadRequest.class))).thenReturn(abortFuture);
            fail("did not expect resultFuture to fail");
        }
            ).isPresent()
            new UploadRequest("bucket", "key", ByteSizeUnit.MB.toBytes(5), WritePriority.HIGH, uploadSuccess -> {
            resultFuture.get();
            abortMultipartUploadResponseCompletableFuture
        setUpMultipartMocks();
        );
import software.amazon.awssdk.services.s3.model.UploadPartResponse;
        AtomicReference<InputStream> streamRef = new AtomicReference<>();
                // do nothing
        try {
        asyncTransferManager = new AsyncTransferManager(
        ExecutionException ex = expectThrows(ExecutionException.class, () -> result.get(5, TimeUnit.SECONDS));
        assertTrue(
import static org.mockito.ArgumentMatchers.any;
        partFuture.complete(UploadPartResponse.builder().checksumCRC32("pzjqHA==").build());
     *
        assertTrue("InputStream was still open after upload", closeError);
}
            closeError = e.getMessage().equals("Stream closed");
     * Regression: same fix, first part fails. Ensures the mismatch between futures list size (0)
        verify(s3AsyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
            buildUploadRequest(true, 3376132981L),
            Throwable throwable = ExceptionsHelper.unwrap(e, CorruptFileException.class);
                // do nothing
        when(s3AsyncClient.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(
    }
                ByteSizeUnit.MB.toBytes(1),
        );
            }, false, null, true, metadata, ServerSideEncryption.AWS_KMS.toString(), randomAlphaOfLength(10), true, null, null),
                t -> t instanceof IOException && t.getMessage().contains("Already closed")
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(ex, t -> t instanceof NullPointerException).isPresent()
     * allOfExceptionForwarded() sees the failure, the upload is aborted, and the original
     * completed immediately, then mergeAndVerifyChecksum NPE'd on slot 0.
        createMultipartUploadRequestCompletableFuture.complete(CreateMultipartUploadResponse.builder().uploadId("uploadId").build());
        metadata.put("key1", "value1");
import static org.mockito.Mockito.verify;
        );
        );
        verify(s3AsyncClient, times(1)).putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class));
     */
        CompletableFuture<UploadPartResponse> uploadPartResponseCompletableFuture = new CompletableFuture<>();
import org.opensearch.common.io.InputStreamContainer;
    public void testMultipartUploadProvideStreamExceptionOnFirstPart() throws Exception {
            ByteSizeUnit.MB.toBytes(5),
        metadata.put("key2", "value2");
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
            } catch (IOException e) {
            s3AsyncClient,
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(
    @Override
                // do nothing
        streams.forEach(stream -> {
            Executors.newSingleThreadExecutor(),
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
        );
            fail("did not expect resultFuture to fail");
        }
                3,
            ).isPresent()
        }
        setUpMultipartMocks();
        CompletableFuture<PutObjectResponse> putObjectResponseCompletableFuture = new CompletableFuture<>();
            s3AsyncClient,
            S3Exception.builder()
        verify(s3AsyncClient, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
        metadata.put("key1", "value1");
            Throwable throwable = ExceptionsHelper.unwrap(e, CorruptFileException.class);
        } catch (IOException e) {
        );
        verify(s3AsyncClient, times(1)).putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class));
        CompletableFuture<Void> result = asyncTransferManager.uploadObject(
        CompletableFuture<Void> result = asyncTransferManager.uploadObject(
            ExceptionsHelper.<IOException>unwrapCausesAndSuppressed(ex, t -> t instanceof NullPointerException).isPresent()
            }, true, 0L, true, metadata, ServerSideEncryption.AWS_KMS.toString(), randomAlphaOfLength(10), true, null, null),
            putObjectResponseCompletableFuture
            s3AsyncClient,
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
    @Before
    // ── Helpers ────────────────────────────────────────────────────────────────
        verify(s3AsyncClient, times(5)).uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class));
    }
    }
 * SPDX-License-Identifier: Apache-2.0
            "Must not surface as NullPointerException",
            new StatsMetricPublisher()
            new StatsMetricPublisher()
            s3AsyncClient,
                closeError = e.getMessage().equals("Stream closed");
    private AsyncTransferManager asyncTransferManager;
import java.io.IOException;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
        Map<String, String> metadata = new HashMap<>();
        verify(s3AsyncClient, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
            }, ByteSizeUnit.MB.toBytes(1), ByteSizeUnit.MB.toBytes(1), 5),
            }, ByteSizeUnit.MB.toBytes(1), ByteSizeUnit.MB.toBytes(1), 5),
     * leaving a null slot in inputStreamContainers and later NPE-ing in mergeAndVerifyChecksum.
            }, ByteSizeUnit.MB.toBytes(1), ByteSizeUnit.MB.toBytes(1), 5),
                // do nothing
        Map<String, String> metadata = new HashMap<>();
     */
     * list, then mergeAndVerifyChecksum() dereferenced the null slot — producing a confusing
            buildUploadRequest(true, 3376132981L),
        metadata.put("key2", "value2");
     * Root cause: the catch block in AsyncPartsHandler.uploadParts() swallowed the exception and
        });
            new StatsMetricPublisher()
            fail("did not expect resultFuture to pass");
        putObjectResponseCompletableFuture.completeExceptionally(
        );
        boolean closeError = false;
    public void testMultipartUploadProvideStreamExceptionOnAllParts() throws Exception {
    private UploadRequest buildUploadRequest(boolean integrityCheck, long checksum) {
        try {
                ex,
     * complete immediately with success, then NPE on every slot. With the fix every part adds a
import org.opensearch.repositories.s3.GenericStatsMetricPublisher;
                TimeUnit.MINUTES,
        assertFalse(
            new StreamContext(
            streamRef.get().available();
        );
            "key",
            "Original IOException must be in the cause chain",
                ex,
            integrityCheck,
import java.util.List;
            resultFuture.get();
                .awsErrorDetails(AwsErrorDetails.builder().errorCode("BadDigest").build())
        CompletableFuture<CompleteMultipartUploadResponse> completeMultipartUploadResponseCompletableFuture = new CompletableFuture<>();
                streams.add(stream);
            new UploadRequest("bucket", "key", ByteSizeUnit.MB.toBytes(1), WritePriority.HIGH, uploadSuccess -> {
        when(s3AsyncClient.completeMultipartUpload(any(CompleteMultipartUploadRequest.class))).thenReturn(
 * this file be licensed under the Apache-2.0 license or a
        );
        verify(s3AsyncClient, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
import software.amazon.awssdk.services.s3.model.S3Exception;
        metadata.put("key2", "value2");
        );
                ex,
        completeMultipartUploadResponseCompletableFuture.complete(CompleteMultipartUploadResponse.builder().build());
            abortMultipartUploadResponseCompletableFuture
            s3AsyncClient,
        } catch (ExecutionException | InterruptedException e) {
        when(s3AsyncClient.completeMultipartUpload(any(CompleteMultipartUploadRequest.class))).thenReturn(
    }
        CompletableFuture<CreateMultipartUploadResponse> createMultipartUploadRequestCompletableFuture = new CompletableFuture<>();
        }
        } catch (ExecutionException | InterruptedException e) {
                .build()
            assertTrue("InputStream was still open after upload", closeError);
