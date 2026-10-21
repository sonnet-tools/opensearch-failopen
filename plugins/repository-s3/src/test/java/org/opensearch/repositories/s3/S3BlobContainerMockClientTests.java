        final long lastPartSize = new ByteSizeValue(200, ByteSizeUnit.MB).getBytes();
        blobContainer = createBlobContainer();
 */
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        asyncService.verifyMultipartUploadCallCount(numberOfParts, throwExceptionOnFinalizeUpload);
        if (expectException) {
import static org.mockito.Mockito.verify;
            return new InputStreamContainer(inputStream, size, position);
            }
                    (!failCreateMultipartUploadRequest && (failUploadPartRequest || failCompleteMultipartUploadRequest))
        return (int) ((contentLength % partSize) == 0 ? contentLength / partSize : (contentLength / partSize) + 1);
        openInputStreams.forEach(inputStream -> {
            futureCompletionService,
        }
            10,
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadResponse;
         */
        final long blobSize = ((numberOfParts - 1) * partSize.getBytes()) + lastPartSize;
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
                inputStream.close();
        blobContainer.asyncBlobUpload(writeContext, completionListener);
import org.opensearch.common.CheckedConsumer;
        public void initializeMocks(
            genericStatsMetricPublisher,
        /**
}
            ensureOpen();
            SizeBasedBlockingQ.QueueEventType.NORMAL
    }
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
import org.junit.Assert;
            }
    private MockS3AsyncService asyncService;
            SERVER_SIDE_ENCRYPTION_ENCRYPTION_CONTEXT_SETTING.getDefault(Settings.EMPTY),
import org.opensearch.threadpool.Scheduler;
            SERVER_SIDE_ENCRYPTION_TYPE_SETTING.getDefault(Settings.EMPTY),
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
        testWriteBlobByStreamsLargeBlob(true, false);
                    completableFuture.complete(CreateMultipartUploadResponse.builder().uploadId(multipartUploadId).build());
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
import software.amazon.awssdk.services.s3.model.StorageClass;
import org.opensearch.core.action.ActionListener;
            return new ZeroIndexInput(sliceDescription, length);
    private void testLargeFilesRedirectedToSlowSyncClient(boolean expectException, WritePriority writePriority) throws IOException,
            anyMap(),
import org.opensearch.repositories.s3.async.TransferSemaphoresHolder;
        );
                } else {
                throw new IOException("Stream closed");
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            countDownLatch.countDown();
        assertTrue(countDownLatch.await(5000, TimeUnit.SECONDS));
            normalPrioritySizeBasedBlockingQ,
        }, partSize1, calculateLastPartSize(blobSize, partSize1), calculateNumberOfParts(blobSize, partSize1));
        when(blobStore.bufferSizeInBytes()).thenReturn(bufferSize);
        };
        }
            boolean failPutObjectRequest,
            IntStream.of(randomIntBetween(1, 5)).forEach(value -> blobPath.add("path_" + value));
    public void testWriteBlobByStreamsNoFailure() throws IOException, ExecutionException, InterruptedException {
        }
    private long calculateLastPartSize(long totalSize, long partSize) {
        }
        asyncService.initializeMocks(true, false, false, false);
            when(blobStore.getCannedACL()).thenReturn(cannedAccessControlList);
                    completableFuture.completeExceptionally(new IOException());
    }
    public void testWriteBlobByStreamsSingleChunkUploadNoFailure() throws IOException, ExecutionException, InterruptedException {
        final CreateMultipartUploadResponse createMultipartUploadResponse = CreateMultipartUploadResponse.builder()
        super.setUp();
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
            return length;
                throw new RuntimeException();
        }
import software.amazon.awssdk.core.sync.RequestBody;
            }).start();
                inputStream.close();
            .metadata(new HashMap<>())
            openInputStreams.add(inputStream);
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
            transferQueueConsumerService,
            }).start();
                    throw new RuntimeException(e);
import org.opensearch.repositories.s3.async.SizeBasedBlockingQ;
import software.amazon.awssdk.services.s3.model.UploadPartResponse;
                    5,
    }
            verify(asyncClient, times(1)).putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class));
            new ByteSizeValue(Runtime.getRuntime().availableProcessors() * 10L, ByteSizeUnit.GB),
        streamReaderService.shutdown();
    public void testWriteBlobByStreamsSingleChunkUploadFinalizeUploadFailure() throws IOException, ExecutionException,
            CompletableFuture<CompleteMultipartUploadResponse> completableFuture = new CompletableFuture<>();
    /**
import software.amazon.awssdk.services.s3.S3Client;
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        }
                }
            .uploadId(randomAlphaOfLength(10))
        InterruptedException {
        testWriteBlobByStreams(false, false);
    private SizeBasedBlockingQ normalPrioritySizeBasedBlockingQ;
            any(InputStream.class),
        testWriteBlobByStreams(false, true);
                times(
        @Override
            new ByteSizeValue(Runtime.getRuntime().availableProcessors() * 20L, ByteSizeUnit.GB),
            "bucket",
            AsyncExecutorContainer urgentExecutorBuilder,
            assertNotNull(exceptionRef.get());
        when(client.completeMultipartUpload(any(CompleteMultipartUploadRequest.class))).thenReturn(
import org.opensearch.common.blobstore.stream.write.WriteContext;
        private CompletableFuture<DeleteObjectResponse> doOnDeleteObject(InvocationOnMock invocationOnMock) {
        private final long length;
import static org.mockito.ArgumentMatchers.anyMap;
        WriteContext writeContext = new WriteContext.Builder().fileName("write_large_blob")
import java.io.InputStream;
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        );
            boolean failCreateMultipartUploadRequest,
            verify(asyncClient, times(!failCreateMultipartUploadRequest ? numberOfParts : 0)).uploadPart(
    }
            verify(
        CountDownLatch countDownLatch = new CountDownLatch(1);
            assertEquals(multipartUploadId, completeMultipartUploadRequest.uploadId());
        asyncService.verifySingleChunkUploadCallCount(throwExceptionOnFinalizeUpload);
    }
    private SizeBasedBlockingQ lowPrioritySizeBasedBlockingQ;
            new AsyncTransferManager(
        public void verifyMultipartUploadCallCount(int numberOfParts, boolean finalizeUploadFailure) {
import org.opensearch.common.StreamContext;
        final long blobSize = ((numberOfParts - 1) * partSize.getBytes()) + lastPartSize;
        private CompletableFuture<CreateMultipartUploadResponse> doOnCreateMultipartUpload(InvocationOnMock invocationOnMock) {
        final byte[] bytes = randomByteArrayOfLength(100);
                SdkException.create("Expected upload part request to fail", new RuntimeException())
import java.util.concurrent.TimeUnit;
                    throw new RuntimeException(e);
                    completableFuture.completeExceptionally(new IOException());
    }
        }
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
        if (randomBoolean()) {
            }).start();
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(randomBoolean());
            return completableFuture;
            any(S3BlobStore.class),
            if (throwExceptionOnFinalizeUpload) {
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import static org.mockito.Mockito.doNothing;
                inputStream.close();
            assertEquals(multipartUploadId, uploadPartRequest.uploadId());
            closed.set(true);
        lowPrioritySizeBasedBlockingQ.close();
import java.util.Locale;
import java.util.stream.IntStream;
            return new InputStreamContainer(inputStream, size, position);
            boolean failCompleteMultipartUploadRequest
    }
        futureCompletionService = Executors.newSingleThreadExecutor();
            .doRemoteDataIntegrityCheck(false)
        }
        asyncService.initializeMocks(false, true, false, false);
            verify(asyncClient, times(!failCreateMultipartUploadRequest && !failUploadPartRequest && !finalizeUploadFailure ? 1 : 0))
            new Thread(() -> {
    @After
            .writePriority(WritePriority.NORMAL)
            InputStream inputStream = new OffsetRangeIndexInputStream(new ZeroIndexInput("desc", blobSize), size, position);
            UploadPartRequest uploadPartRequest = invocationOnMock.getArgument(0);
    }
                    TimeUnit.MINUTES,
        int numberOfParts = randomIntBetween(2, 5);
        blobContainer.asyncBlobUpload(writeContext, completionListener);
                try {
        );
            CompleteMultipartUploadRequest completeMultipartUploadRequest = invocationOnMock.getArgument(0);
        public long getFilePointer() {
        public MockS3AsyncService(Path configPath, int maxDelayInFutureCompletionMillis) {
                } catch (InterruptedException e) {
            doAnswer(this::doOnDeleteObject).when(asyncClient).deleteObject(any(DeleteObjectRequest.class));
            verify(asyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
        StreamContextSupplier streamContextSupplier = partSize1 -> new StreamContext((partNo, size, position) -> {
        public long length() {
            assertEquals(multipartUploadId, abortMultipartUploadRequest.uploadId());
        private long available() {
 * compatible open source license.
                }
        when(client.abortMultipartUpload(any(AbortMultipartUploadRequest.class))).thenReturn(
        WriteContext writeContext = new WriteContext.Builder().fileName("write_large_blob")
            }
        ActionListener<Void> completionListener = ActionListener.wrap(resp -> { countDownLatch.countDown(); }, ex -> {
        super.tearDown();
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;
            return Math.max(length - reads.get(), 0);
            super(resourceDescription);
        }
            return completableFuture;
            asyncExecutorContainer,
    private void testWriteBlobByStreams(boolean expectException, boolean throwExceptionOnFinalizeUpload) throws IOException,
                    completableFuture.complete(CompleteMultipartUploadResponse.builder().build());
        });
import org.opensearch.common.blobstore.stream.write.WritePriority;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
            SERVER_SIDE_ENCRYPTION_BUCKET_KEY_SETTING.getDefault(Settings.EMPTY),
    }
import java.util.concurrent.ScheduledExecutorService;
        private CompletableFuture<AbortMultipartUploadResponse> doOnAbortMultipartUpload(InvocationOnMock invocationOnMock) {
import org.opensearch.common.blobstore.BlobPath;
        @Override
        when(blobStore.isRedirectLargeUploads()).thenReturn(true);
            return (byte) ((reads.incrementAndGet() <= length) ? 0 : -1);
        openInputStreams.forEach(inputStream -> {
        asyncService = new MockS3AsyncService(configPath(), 1000);
import org.opensearch.core.common.unit.ByteSizeUnit;
        public void readBytes(byte[] b, int offset, int len) throws IOException {
        s3BlobContainer.asyncBlobUpload(writeContext, completionListener);
        );
package org.opensearch.repositories.s3;
            return completableFuture;
 *
            setupFailureBooleans(
    }
    }
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
            doAnswer(this::doOnPutObject).when(asyncClient).putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class));
        public ZeroIndexInput(String resourceDescription, final long length) {
        public void verifySingleChunkUploadCallCount(boolean finalizeUploadFailure) {
            true,
            openInputStreams.add(inputStream);
            final int toCopy = Math.min(len, (int) available);
        @Override
        );
            }).start();
        private final AtomicLong reads = new AtomicLong(0);
        List<InputStream> openInputStreams = new ArrayList<>();
        testLargeFilesRedirectedToSlowSyncClient(false, WritePriority.NORMAL);
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
                } catch (InterruptedException e) {
        asyncService.initializeMocks(false, false, false, false);
    public void testWriteBlobByStreamsCompleteMultipartRequestFailure() throws IOException, ExecutionException, InterruptedException {
        testWriteBlobByStreams(true, false);
                    Math.max(Runtime.getRuntime().availableProcessors() * 5, 10),
        };
        }
                throw new RuntimeException();
        }
            new Thread(() -> {
        });
            CompleteMultipartUploadResponse.builder().build()
        streamReaderService = Executors.newSingleThreadExecutor();
    }
                    3,
            AbortMultipartUploadRequest abortMultipartUploadRequest = invocationOnMock.getArgument(0);
            boolean failUploadPartRequest,
            );
            assertTrue(uploadSuccess);
    public void testWriteBlobByStreamsSingleChunkUploadPutObjectFailure() throws IOException, ExecutionException, InterruptedException {
        StreamContextSupplier streamContextSupplier = partSize1 -> new StreamContext((partNo, size, position) -> {
            return completableFuture;
        }
            new Thread(() -> {
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
        ExecutionException, InterruptedException {
        public AmazonAsyncS3Reference client(
            verify(client, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
    public void testWriteBlobByStreamsCreateMultipartRequestFailure() throws IOException, ExecutionException, InterruptedException {
        private void setupFailureBooleans(
            repositoryMetadata,
        when(client.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(createMultipartUploadResponse);
            InputStream inputStream = new OffsetRangeIndexInputStream(new ByteArrayIndexInput("desc", bytes), size, position);
        SizeBasedBlockingQ sizeBasedBlockingQ = new SizeBasedBlockingQ(
            .uploadFinalizer(uploadFinalizer)
            .streamContextSupplier(streamContextSupplier)
import static org.mockito.ArgumentMatchers.anyString;
        public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {
    private S3BlobContainer blobContainer;
            openInputStreams.add(inputStream);
                    genericStatsMetricPublisher
        normalPrioritySizeBasedBlockingQ.close();
    }
            verify(asyncClient, times(finalizeUploadFailure ? 1 : 0)).deleteObject(any(DeleteObjectRequest.class));
import java.util.concurrent.atomic.AtomicReference;
        when(blobStore.bucket()).thenReturn(bucketName);
            super(configPath);
        }
        return totalSize % partSize == 0 ? partSize : totalSize % partSize;
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_KMS_KEY_SETTING;
            if (closed.get()) {
                } else {
        doNothing().when(clientReference).close();
            ),
        futureCompletionService.shutdown();
                if (failPutObjectRequest) {
                asyncExecutorContainer.getStreamReader(),
        });
        testLargeFilesRedirectedToSlowSyncClient(false, WritePriority.LOW);
        public void seek(long pos) throws IOException {
    static class MockS3AsyncService extends S3AsyncService {
        InterruptedException {
import static org.opensearch.repositories.s3.S3Repository.BULK_DELETE_SIZE;
        }
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_ENCRYPTION_CONTEXT_SETTING;
            CompletableFuture<AbortMultipartUploadResponse> completableFuture = new CompletableFuture<>();
            } catch (IOException ex) {
import org.opensearch.common.blobstore.stream.write.StreamContextSupplier;
                    completableFuture.complete(DeleteObjectResponse.builder().build());
            .uploadFinalizer(uploadFinalizer)
        transferNIOGroup.close();
        transferQueueConsumerService.shutdown();
            when(client.uploadPart(any(UploadPartRequest.class), any(RequestBody.class))).thenReturn(UploadPartResponse.builder().build());
        final ByteSizeValue partSize = S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING.getDefault(Settings.EMPTY);
            .writePriority(WritePriority.NORMAL)
        remoteTransferRetry.shutdown();
                try {
            countDownLatch.countDown();
     * An IndexInput implementation that serves only zeroes
            .failIfAlreadyExists(false)
            transferNIOGroup
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;
            S3Repository.BUFFER_SIZE_SETTING.getDefault(Settings.EMPTY),
            AsyncExecutorContainer normalExecutorBuilder
            try {
        );
import org.opensearch.cluster.metadata.RepositoryMetadata;
                fail("Failure while closing open input streams");
        });
        private boolean failCreateMultipartUploadRequest;
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
                } else {
            final long available = available();
import org.opensearch.test.OpenSearchTestCase;
            .doRemoteDataIntegrityCheck(false)
            this.failCreateMultipartUploadRequest = failCreateMultipartUploadRequest;
    private ScheduledExecutorService scheduler;
        final String clientName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
import static org.mockito.ArgumentMatchers.isNull;
            assertNotNull(exceptionRef.get());
            10,
        private final AtomicBoolean closed = new AtomicBoolean(false);
            asyncExecutorContainer,
                try {
            this.length = length;
            doAnswer(this::doOnCompleteMultipartUpload).when(asyncClient)
                    completableFuture.completeExceptionally(new IOException());
            doAnswer(this::doOnPartUpload).when(asyncClient).uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class));
                } else {
            Settings.builder().put(S3Repository.CLIENT_NAME.getKey(), clientName).build()
            multipartUploadId = randomAlphaOfLength(5);
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
            isNull()
        final ByteSizeValue partSize = new ByteSizeValue(capacity.getBytes() / numberOfParts + 1, ByteSizeUnit.BYTES);
import org.mockito.invocation.InvocationOnMock;
    private void testWriteBlobByStreamsLargeBlob(boolean expectException, boolean throwExceptionOnFinalizeUpload) throws IOException,
            .fileSize(bytes.length)
    public void testWriteBlobByStreamsFinalizeUploadFailure() throws IOException, ExecutionException, InterruptedException {
            CompletableFuture<CreateMultipartUploadResponse> completableFuture = new CompletableFuture<>();
        asyncService.initializeMocks(false, false, false, false);
import java.util.concurrent.ExecutorService;
            SizeBasedBlockingQ.QueueEventType.NORMAL
        assertTrue(countDownLatch.await(5000, TimeUnit.SECONDS));
            CompletableFuture<DeleteObjectResponse> completableFuture = new CompletableFuture<>();
            }
        return new S3BlobStore(
            }
    }
            verify(client, times(0)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
                    throw new RuntimeException(e);
            doAnswer(this::doOnCreateMultipartUpload).when(asyncClient).createMultipartUpload(any(CreateMultipartUploadRequest.class));
        asyncService.initializeMocks(false, false, false, true);
        if (expectException || throwExceptionOnFinalizeUpload) {
        }
            AbortMultipartUploadResponse.builder().build()
                    throw new RuntimeException(e);
            assertTrue(uploadSuccess);
            .streamContextSupplier(streamContextSupplier)
        public void close() throws IOException {
                    completableFuture.complete(UploadPartResponse.builder().eTag("eTag").build());
        testWriteBlobByStreamsLargeBlob(true, false);
        ActionListener<Void> completionListener = ActionListener.wrap(resp -> { countDownLatch.countDown(); }, ex -> {
            this.maxDelayInFutureCompletionMillis = maxDelayInFutureCompletionMillis;
        }
            null,
        asyncService.initializeMocks(false, false, false, false);
            .failIfAlreadyExists(false)
    public void setUp() throws Exception {
            boolean failCreateMultipartUploadRequest,
import org.opensearch.core.common.unit.ByteSizeValue;
            exceptionRef.set(ex);
            assertNull(exceptionRef.get());
        }
         * @param resourceDescription resourceDescription should be a non-null, opaque string describing this resource; it's returned
        WriteContext writeContext = new WriteContext.Builder().fileName("write_blob_by_streams_max_retries")
        IOUtils.close(asyncService);
            return reads.get();
        CheckedConsumer<Boolean, IOException> uploadFinalizer = uploadSuccess -> {
            BULK_DELETE_SIZE.get(Settings.EMPTY),
        normalPrioritySizeBasedBlockingQ = new SizeBasedBlockingQ(
            );
    @Override
import org.opensearch.common.io.InputStreamContainer;
        }
        private String multipartUploadId;
import java.util.concurrent.Executors;
    private S3BlobStore createBlobStore() {
        testLargeFilesRedirectedToSlowSyncClient(true, WritePriority.NORMAL);
                }
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
                asyncClient,
            .uploadFinalizer(Assert::assertTrue)
        ) {
import static org.mockito.Mockito.any;
        }
        testWriteBlobByStreamsLargeBlob(false, true);
            S3Repository.STORAGE_CLASS_SETTING.getDefault(Settings.EMPTY),
        asyncService.initializeMocks(false, false, true, false);
            SizeBasedBlockingQ.QueueEventType.NORMAL
            this.failPutObjectRequest = failPutObjectRequest;
            ).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
        }
            transferQueueConsumerService,
        }, partSize1, calculateLastPartSize(blobSize, partSize1), calculateNumberOfParts(blobSize, partSize1));
    }
        ) {
        when(blobStore.clientReference()).thenReturn(clientReference);
                asyncExecutorContainer.getStreamReader(),
                }
            boolean failPutObjectRequest,
import static org.mockito.Mockito.when;
        }
    public void testLargeFileRedirected() throws IOException, InterruptedException {
import static org.opensearch.repositories.s3.S3Repository.EXPECTED_BUCKET_OWNER_SETTING;
                } catch (InterruptedException e) {
            CompletableFuture<PutObjectResponse> completableFuture = new CompletableFuture<>();
        when(blobStore.getLowPrioritySizeBasedBlockingQ()).thenReturn(sizeBasedBlockingQ);
                S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING.getDefault(Settings.EMPTY).getBytes(),
                    throw new RuntimeException(e);
                failCreateMultipartUploadRequest,
            streamReaderService,
                if (failCompleteMultipartUploadRequest) {
        transferNIOGroup = new AsyncTransferEventLoopGroup(1);
            .streamContextSupplier(streamContextSupplier)
        scheduler = new Scheduler.SafeScheduledThreadPoolExecutor(1);
        final BlobPath blobPath = new BlobPath();
        final ObjectCannedACL cannedAccessControlList = randomBoolean() ? randomFrom(ObjectCannedACL.values()) : null;
        if (randomBoolean()) {
                }
import org.apache.lucene.store.IndexInput;
        final long lastPartSize = randomLongBetween(10, 512);
            EXPECTED_BUCKET_OWNER_SETTING.getDefault(Settings.EMPTY)
            if (throwExceptionOnFinalizeUpload) {
        private CompletableFuture<UploadPartResponse> doOnPartUpload(InvocationOnMock invocationOnMock) {
     */
        // Fail the completion request
import org.opensearch.common.util.io.IOUtils;
import java.util.concurrent.CountDownLatch;
        private boolean failCompleteMultipartUploadRequest;
import java.nio.file.Path;
    static class ZeroIndexInput extends IndexInput {
        assertTrue(countDownLatch.await(5000, TimeUnit.SECONDS));
        StreamContextSupplier streamContextSupplier = partSize -> new StreamContext((partNo, size, position) -> {
import software.amazon.awssdk.core.exception.SdkException;
            new Thread(() -> {
        private boolean failPutObjectRequest;
        );
                new TransferSemaphoresHolder(
            new Thread(() -> {
        } else {
        private final int maxDelayInFutureCompletionMillis;
import org.opensearch.repositories.s3.async.AsyncTransferEventLoopGroup;
        } else {
                logger.error("Error closing input stream");
        if (expectException) {
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_TYPE_SETTING;
        testWriteBlobByStreamsLargeBlob(true, false);
    private ExecutorService streamReaderService;
            return new AmazonAsyncS3Reference(AmazonAsyncS3WithCredentials.create(asyncClient, asyncClient, asyncClient, null));
        CountDownLatch countDownLatch = new CountDownLatch(1);
        scheduler.shutdown();
        } else {
        when(blobStore.getStorageClass()).thenReturn(storageClass);
            .build();
import static org.mockito.Mockito.mock;
        if (expectException || throwExceptionOnFinalizeUpload) {
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;
        }
            try {
            return completableFuture;
        }
        verify(s3BlobContainer, times(1)).executeMultipartUpload(
import org.junit.Before;
                }
        @Override
        @Override
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
         *                            from {@link #toString}.
            asyncExecutorContainer,
            capacity,
    }
                } else {
                completableFuture.complete(AbortMultipartUploadResponse.builder().build());
        int numberOfParts = 20;
        }
        if (cannedAccessControlList != null) {
        openInputStreams.forEach(inputStream -> {
            CompletableFuture<UploadPartResponse> completableFuture = new CompletableFuture<>();
            doAnswer(this::doOnAbortMultipartUpload).when(asyncClient).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
                if (failCreateMultipartUploadRequest) {
import org.junit.After;
            boolean failUploadPartRequest,
import static org.mockito.ArgumentMatchers.anyLong;
            .writePriority(writePriority)
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
                    completableFuture.completeExceptionally(new IOException());
            exceptionRef.set(ex);
        asyncService.initializeMocks(false, false, false, false);
import java.util.concurrent.ExecutionException;
            try {
        AsyncExecutorContainer asyncExecutorContainer = new AsyncExecutorContainer(
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(randomAlphaOfLength(10));
import org.opensearch.repositories.s3.async.AsyncTransferManager;
            }).start();
            .fileSize(blobSize)
            .failIfAlreadyExists(false)
            RepositoryMetadata repositoryMetadata,
    private int calculateNumberOfParts(long contentLength, long partSize) {
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
    private ExecutorService futureCompletionService;
            .fileSize(blobSize)
        ExecutionException, InterruptedException {
            Arrays.fill(b, offset, offset + toCopy, (byte) 0);
    private AsyncTransferEventLoopGroup transferNIOGroup;
import java.util.ArrayList;
            .build();
        final S3Client client = mock(S3Client.class);
            } catch (IOException ex) {
            );
    }
        lowPrioritySizeBasedBlockingQ = new SizeBasedBlockingQ(
import java.io.IOException;
        final RepositoryMetadata repositoryMetadata = new RepositoryMetadata(
            reads.addAndGet(toCopy);
        List<InputStream> openInputStreams = new ArrayList<>();
            ensureOpen();
import java.util.concurrent.CompletableFuture;
import software.amazon.awssdk.services.s3.S3AsyncClient;
    }
        ByteSizeValue capacity = new ByteSizeValue(1, ByteSizeUnit.GB);
                }
        @Override
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_BUCKET_KEY_SETTING;
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
/*
            AsyncExecutorContainer priorityExecutorBuilder,
        @Override
        }, partSize, calculateLastPartSize(bytes.length, partSize), calculateNumberOfParts(bytes.length, partSize));
                any(UploadPartRequest.class),
        private final S3AsyncClient asyncClient = mock(S3AsyncClient.class);
                try {
            .build();
            anyLong(),
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
        }
                try {
 * this file be licensed under the Apache-2.0 license or a
            this.failUploadPartRequest = failUploadPartRequest;
        transferQueueConsumerService = Executors.newFixedThreadPool(20);
                .completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
        final StorageClass storageClass = randomFrom(StorageClass.values());
                        || finalizeUploadFailure ? 1 : 0
import java.util.concurrent.atomic.AtomicBoolean;
        }
                    completableFuture.completeExceptionally(new IOException());
                } catch (InterruptedException e) {
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
        private boolean failUploadPartRequest;
        normalPrioritySizeBasedBlockingQ.start();
            "repository",
        ) {
                }
        remoteTransferRetry = Executors.newFixedThreadPool(20);
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadResponse;
            transferQueueConsumerService,
    }
        if (expectException) {
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
        );
        List<InputStream> openInputStreams = new ArrayList<>();
public class S3BlobContainerMockClientTests extends OpenSearchTestCase implements ConfigPathSupport {
        }
        final S3BlobContainer s3BlobContainer = Mockito.spy(new S3BlobContainer(blobPath, blobStore));
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        private CompletableFuture<CompleteMultipartUploadResponse> doOnCompleteMultipartUpload(InvocationOnMock invocationOnMock) {
                any(AsyncRequestBody.class)
            return new InputStreamContainer(inputStream, size, position);
                } catch (InterruptedException e) {
            asyncService,
    public void tearDown() throws Exception {
                if (failUploadPartRequest) {
    public void testWriteBlobByStreamsUploadPartRequestFailure() throws IOException, ExecutionException, InterruptedException {
import static org.mockito.Mockito.doAnswer;
            genericStatsMetricPublisher,
            SERVER_SIDE_ENCRYPTION_KMS_KEY_SETTING.getDefault(Settings.EMPTY),
                failPutObjectRequest,
        CheckedConsumer<Boolean, IOException> uploadFinalizer = uploadSuccess -> {
    @Before
        public byte readByte() throws IOException {
            S3Repository.CANNED_ACL_SETTING.getDefault(Settings.EMPTY),
                asyncExecutorContainer.getStreamReader(),
        });
                    throw new RuntimeException(e);
            lowPrioritySizeBasedBlockingQ,
import static org.mockito.Mockito.times;
        ActionListener<Void> completionListener = ActionListener.wrap(resp -> { countDownLatch.countDown(); }, ex -> {
                )
            } catch (IOException e) {
    }
            reads.set(pos);
import software.amazon.awssdk.core.async.AsyncRequestBody;
            countDownLatch.countDown();
            assertNotNull(exceptionRef.get());
            when(client.uploadPart(any(UploadPartRequest.class), any(RequestBody.class))).thenThrow(
                }
                failCompleteMultipartUploadRequest
                }
        CountDownLatch countDownLatch = new CountDownLatch(1);
                    completableFuture.complete(PutObjectResponse.builder().build());
        return new S3BlobContainer(BlobPath.cleanPath(), createBlobStore());
        when(blobStore.getNormalPrioritySizeBasedBlockingQ()).thenReturn(sizeBasedBlockingQ);
            .build();
 * The OpenSearch Contributors require contributions made to
            genericStatsMetricPublisher,
            new Thread(() -> {
            anyString(),
    @Override
        lowPrioritySizeBasedBlockingQ.start();
    }
    private S3BlobContainer createBlobContainer() {
import java.util.Arrays;
            .doRemoteDataIntegrityCheck(false)
        private void ensureOpen() throws IOException {
                } catch (InterruptedException e) {
        });
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
            genericStatsMetricPublisher,
                )
            exceptionRef.set(ex);
import org.mockito.Mockito;
            5,
        final AmazonS3Reference clientReference = Mockito.spy(new AmazonS3Reference(client));
            return completableFuture;
            S3Repository.TYPE,
        }
        // wait for completableFuture to finish
        testWriteBlobByStreamsLargeBlob(false, false);
        }
import java.util.List;
    private ExecutorService remoteTransferRetry;
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        private CompletableFuture<PutObjectResponse> doOnPutObject(InvocationOnMock invocationOnMock) {
                }
        @Override
                try {
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(randomAlphaOfLength(10));
        final long bufferSize = ByteSizeUnit.MB.toBytes(randomIntBetween(5, 1024));
                logger.error("Error closing input stream");
            this.failCompleteMultipartUploadRequest = failCompleteMultipartUploadRequest;
        );
            }
        } else {
            InputStream inputStream = new OffsetRangeIndexInputStream(new ZeroIndexInput("desc", blobSize), size, position);
        testLargeFilesRedirectedToSlowSyncClient(true, WritePriority.LOW);
        }
                failUploadPartRequest,
            }).start();
    private ExecutorService transferQueueConsumerService;
            boolean failCompleteMultipartUploadRequest
    public void testFailureWhenLargeFileRedirected() throws IOException, InterruptedException {
                .completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
                if (failPutObjectRequest) {
