        private CompletableFuture<CreateMultipartUploadResponse> doOnCreateMultipartUpload(InvocationOnMock invocationOnMock) {  
        ) {
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
import org.mockito.invocation.InvocationOnMock;
            );  
        lowPrioritySizeBasedBlockingQ.close();
            doAnswer(this::doOnCompleteMultipartUpload).when(asyncClient)
            try {
            EXPECTED_BUCKET_OWNER_SETTING.getDefault(Settings.EMPTY)  
import java.util.ArrayList;
    @Override
        }  
            AsyncExecutorContainer normalExecutorBuilder
            new Thread(() -> {
 * SPDX-License-Identifier: Apache-2.0
                    throw new RuntimeException(e);
import java.io.IOException;
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
import org.opensearch.repositories.s3.async.SizeBasedBlockingQ;
        private boolean failPutObjectRequest;  
        if (expectException) {  
            assertTrue(uploadSuccess);
import software.amazon.awssdk.core.exception.SdkException;
                }
            boolean failPutObjectRequest,
        @Override
            verify(asyncClient, times(!failCreateMultipartUploadRequest && !failUploadPartRequest && !finalizeUploadFailure ? 1 : 0))
                failUploadPartRequest,  
        public AmazonAsyncS3Reference client(  
import java.util.concurrent.atomic.AtomicLong;
    }
        @Override
            } catch (IOException ex) {
        StreamContextSupplier streamContextSupplier = partSize1 -> new StreamContext((partNo, size, position) -> {
                        || finalizeUploadFailure ? 1 : 0
            countDownLatch.countDown();
        StreamContextSupplier streamContextSupplier = partSize -> new StreamContext((partNo, size, position) -> {
            doAnswer(this::doOnDeleteObject).when(asyncClient).deleteObject(any(DeleteObjectRequest.class));
        final S3BlobContainer s3BlobContainer = Mockito.spy(new S3BlobContainer(blobPath, blobStore));
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
        @Override  
            super(resourceDescription);  
import org.opensearch.common.CheckedConsumer;  
                }
        @Override
import org.opensearch.common.blobstore.stream.write.WritePriority;
                .completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
        when(blobStore.bufferSizeInBytes()).thenReturn(bufferSize);
            lowPrioritySizeBasedBlockingQ,  
        }  
    }
        } else {  
        } else {
import java.io.InputStream;
        scheduler.shutdown();  
                } catch (InterruptedException e) {  
        final StorageClass storageClass = randomFrom(StorageClass.values());  
    @After  
            );
    }
        ExecutionException, InterruptedException {
            if (throwExceptionOnFinalizeUpload) {
        }
import static org.mockito.Mockito.mock;
            CompletableFuture<CompleteMultipartUploadResponse> completableFuture = new CompletableFuture<>();  
            }  
            transferQueueConsumerService,  
        InterruptedException {
            .uploadFinalizer(Assert::assertTrue)
            CompleteMultipartUploadResponse.builder().build()  
            AsyncExecutorContainer priorityExecutorBuilder,  
            SizeBasedBlockingQ.QueueEventType.NORMAL
}
        remoteTransferRetry = Executors.newFixedThreadPool(20);
                    TimeUnit.MINUTES,
import software.amazon.awssdk.services.s3.S3Client;
                if (failUploadPartRequest) {
        );
        }
            asyncExecutorContainer,
            return length;  
                asyncExecutorContainer.getStreamReader(),
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;
        blobContainer = createBlobContainer();
import java.util.Locale;
            verify(asyncClient, times(finalizeUploadFailure ? 1 : 0)).deleteObject(any(DeleteObjectRequest.class));
            } catch (IOException e) {
        testLargeFilesRedirectedToSlowSyncClient(true, WritePriority.NORMAL);  
            return (byte) ((reads.incrementAndGet() <= length) ? 0 : -1);
                    completableFuture.completeExceptionally(new IOException());  
        public long length() {
        );  
            final int toCopy = Math.min(len, (int) available);  
        transferQueueConsumerService = Executors.newFixedThreadPool(20);
        }
    public void testWriteBlobByStreamsNoFailure() throws IOException, ExecutionException, InterruptedException {
        }  
            IntStream.of(randomIntBetween(1, 5)).forEach(value -> blobPath.add("path_" + value));  
                new TransferSemaphoresHolder(  
        final String clientName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
import static org.mockito.ArgumentMatchers.anyLong;  
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadResponse;
        transferNIOGroup = new AsyncTransferEventLoopGroup(1);
        private CompletableFuture<CompleteMultipartUploadResponse> doOnCompleteMultipartUpload(InvocationOnMock invocationOnMock) {  
    public void testFailureWhenLargeFileRedirected() throws IOException, InterruptedException {
                }  
        lowPrioritySizeBasedBlockingQ = new SizeBasedBlockingQ(
            when(client.uploadPart(any(UploadPartRequest.class), any(RequestBody.class))).thenThrow(  
            asyncExecutorContainer,  
    private ExecutorService transferQueueConsumerService;  
            exceptionRef.set(ex);
import java.util.concurrent.ExecutionException;
        );
        List<InputStream> openInputStreams = new ArrayList<>();  
            boolean failCreateMultipartUploadRequest,
            true,  
        WriteContext writeContext = new WriteContext.Builder().fileName("write_large_blob")  
                if (failPutObjectRequest) {
                    throw new RuntimeException(e);
    public void setUp() throws Exception {  
            verify(asyncClient, times(1)).putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class));
        when(blobStore.isRedirectLargeUploads()).thenReturn(true);
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
    }
         *                            from {@link #toString}.  
            .fileSize(bytes.length)
    public void testWriteBlobByStreamsCompleteMultipartRequestFailure() throws IOException, ExecutionException, InterruptedException {  
            capacity,
        verify(s3BlobContainer, times(1)).executeMultipartUpload(
            new Thread(() -> {
import static org.mockito.ArgumentMatchers.isNull;  
                }
        ) {
import static org.mockito.Mockito.when;
            genericStatsMetricPublisher,
            AbortMultipartUploadResponse.builder().build()  
        });  
            boolean failPutObjectRequest,
            verify(client, times(0)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
            .streamContextSupplier(streamContextSupplier)
import org.opensearch.common.blobstore.BlobPath;
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_BUCKET_KEY_SETTING;
            ).abortMultipartUpload(any(AbortMultipartUploadRequest.class));  
import org.apache.lucene.store.IndexInput;
            exceptionRef.set(ex);
                } catch (InterruptedException e) {  
                    3,
    @Override
            assertEquals(multipartUploadId, uploadPartRequest.uploadId());  
            }
     * An IndexInput implementation that serves only zeroes
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final ObjectCannedACL cannedAccessControlList = randomBoolean() ? randomFrom(ObjectCannedACL.values()) : null;
        futureCompletionService.shutdown();  
        asyncService.initializeMocks(false, false, true, false);
            .uploadFinalizer(uploadFinalizer)
        return (int) ((contentLength % partSize) == 0 ? contentLength / partSize : (contentLength / partSize) + 1);
            Settings.builder().put(S3Repository.CLIENT_NAME.getKey(), clientName).build()  
        InterruptedException {  
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));  
            .streamContextSupplier(streamContextSupplier)
                if (failCompleteMultipartUploadRequest) {
            S3Repository.BUFFER_SIZE_SETTING.getDefault(Settings.EMPTY),
            genericStatsMetricPublisher,
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;  
        );
            SERVER_SIDE_ENCRYPTION_BUCKET_KEY_SETTING.getDefault(Settings.EMPTY),
        @Override
        super.setUp();
import static org.mockito.ArgumentMatchers.anyMap;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import org.opensearch.common.blobstore.stream.write.StreamContextSupplier;  
            multipartUploadId = randomAlphaOfLength(5);
            S3Repository.CANNED_ACL_SETTING.getDefault(Settings.EMPTY),  
            this.failCompleteMultipartUploadRequest = failCompleteMultipartUploadRequest;  
            boolean failCreateMultipartUploadRequest,
    private SizeBasedBlockingQ normalPrioritySizeBasedBlockingQ;
        ExecutionException, InterruptedException {
            AsyncExecutorContainer urgentExecutorBuilder,
        private CompletableFuture<UploadPartResponse> doOnPartUpload(InvocationOnMock invocationOnMock) {
                    throw new RuntimeException(e);  
        public void verifyMultipartUploadCallCount(int numberOfParts, boolean finalizeUploadFailure) {
        final long bufferSize = ByteSizeUnit.MB.toBytes(randomIntBetween(5, 1024));  
        @Override  
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(randomAlphaOfLength(10));
        doNothing().when(clientReference).close();
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
            .writePriority(WritePriority.NORMAL)
            this.failUploadPartRequest = failUploadPartRequest;
                }
    public void testWriteBlobByStreamsSingleChunkUploadFinalizeUploadFailure() throws IOException, ExecutionException,  
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
import software.amazon.awssdk.services.s3.S3AsyncClient;
            Arrays.fill(b, offset, offset + toCopy, (byte) 0);
        public void readBytes(byte[] b, int offset, int len) throws IOException {  
            setupFailureBooleans(  
                any(UploadPartRequest.class),
    public void testLargeFileRedirected() throws IOException, InterruptedException {  
            doAnswer(this::doOnPutObject).when(asyncClient).putObject(any(PutObjectRequest.class), any(AsyncRequestBody.class));  
            SERVER_SIDE_ENCRYPTION_ENCRYPTION_CONTEXT_SETTING.getDefault(Settings.EMPTY),
        ByteSizeValue capacity = new ByteSizeValue(1, ByteSizeUnit.GB);
                throw new RuntimeException();
    public void testWriteBlobByStreamsUploadPartRequestFailure() throws IOException, ExecutionException, InterruptedException {
    public void testWriteBlobByStreamsSingleChunkUploadPutObjectFailure() throws IOException, ExecutionException, InterruptedException {
            .build();
            doAnswer(this::doOnPartUpload).when(asyncClient).uploadPart(any(UploadPartRequest.class), any(AsyncRequestBody.class));  
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
            isNull()
        );  
 */  
                )  
            transferQueueConsumerService,
import org.opensearch.common.StreamContext;
            genericStatsMetricPublisher,
            return reads.get();
        testLargeFilesRedirectedToSlowSyncClient(true, WritePriority.LOW);
            asyncExecutorContainer,
        private boolean failCreateMultipartUploadRequest;
import org.opensearch.cluster.metadata.RepositoryMetadata;
            return completableFuture;  
        }
                S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING.getDefault(Settings.EMPTY).getBytes(),
        super.tearDown();
        }
    }  
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
        }, partSize, calculateLastPartSize(bytes.length, partSize), calculateNumberOfParts(bytes.length, partSize));  
                }
    private S3BlobContainer blobContainer;  
            CompletableFuture<PutObjectResponse> completableFuture = new CompletableFuture<>();
import org.junit.Before;
            normalPrioritySizeBasedBlockingQ,
            }).start();
            return completableFuture;  
            5,
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_KMS_KEY_SETTING;
        when(blobStore.getLowPrioritySizeBasedBlockingQ()).thenReturn(sizeBasedBlockingQ);
                try {  
            this.failPutObjectRequest = failPutObjectRequest;  
        when(blobStore.getStorageClass()).thenReturn(storageClass);
        assertTrue(countDownLatch.await(5000, TimeUnit.SECONDS));
        }
        futureCompletionService = Executors.newSingleThreadExecutor();
        asyncService.initializeMocks(false, false, false, true);
            null,
                try {
            .streamContextSupplier(streamContextSupplier)  
        if (randomBoolean()) {
        );
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();  
        blobContainer.asyncBlobUpload(writeContext, completionListener);
package org.opensearch.repositories.s3;
        when(blobStore.clientReference()).thenReturn(clientReference);  
        });
import java.util.concurrent.ExecutorService;  
import static org.mockito.Mockito.doNothing;  
        return totalSize % partSize == 0 ? partSize : totalSize % partSize;  
            any(InputStream.class),
import static org.mockito.Mockito.times;
    }
                logger.error("Error closing input stream");  
    private ExecutorService streamReaderService;
            verify(  
        WriteContext writeContext = new WriteContext.Builder().fileName("write_large_blob")
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
            boolean failUploadPartRequest,  
import static org.mockito.ArgumentMatchers.anyString;
            return completableFuture;
        int numberOfParts = randomIntBetween(2, 5);
                } else {  
import software.amazon.awssdk.services.s3.model.StorageClass;  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        testWriteBlobByStreamsLargeBlob(false, false);  
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
        }
        final AmazonS3Reference clientReference = Mockito.spy(new AmazonS3Reference(client));
        public void verifySingleChunkUploadCallCount(boolean finalizeUploadFailure) {  
        streamReaderService.shutdown();
        }
            return new InputStreamContainer(inputStream, size, position);  
import org.opensearch.repositories.s3.async.AsyncTransferManager;
    private S3BlobStore createBlobStore() {  
        ) {
            }).start();
        ActionListener<Void> completionListener = ActionListener.wrap(resp -> { countDownLatch.countDown(); }, ex -> {
        private CompletableFuture<DeleteObjectResponse> doOnDeleteObject(InvocationOnMock invocationOnMock) {  
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
        private long available() {
        } else {
    }
        asyncService.initializeMocks(false, false, false, false);
        final byte[] bytes = randomByteArrayOfLength(100);
            CompletableFuture<CreateMultipartUploadResponse> completableFuture = new CompletableFuture<>();
        }  
        asyncService.initializeMocks(false, false, false, false);
            transferQueueConsumerService,
            .uploadFinalizer(uploadFinalizer)
            .uploadId(randomAlphaOfLength(10))
        public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {
            assertNotNull(exceptionRef.get());
            SizeBasedBlockingQ.QueueEventType.NORMAL
            assertTrue(uploadSuccess);  
            .metadata(new HashMap<>())
            RepositoryMetadata repositoryMetadata,
        };
            CompletableFuture<DeleteObjectResponse> completableFuture = new CompletableFuture<>();
import org.opensearch.common.blobstore.stream.write.WriteContext;
            doAnswer(this::doOnCreateMultipartUpload).when(asyncClient).createMultipartUpload(any(CreateMultipartUploadRequest.class));
        testWriteBlobByStreams(true, false);  
                    5,  
            .build();  
                inputStream.close();  
            10,  
        int numberOfParts = 20;
            .fileSize(blobSize)
    static class MockS3AsyncService extends S3AsyncService {
            try {  
                }
        // wait for completableFuture to finish  
                } else {
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
    private MockS3AsyncService asyncService;
        testWriteBlobByStreamsLargeBlob(true, false);
    /**
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;  
            assertEquals(multipartUploadId, abortMultipartUploadRequest.uploadId());
        private final int maxDelayInFutureCompletionMillis;
            AbortMultipartUploadRequest abortMultipartUploadRequest = invocationOnMock.getArgument(0);  
            new Thread(() -> {
            verify(asyncClient, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
    }  
        }, partSize1, calculateLastPartSize(blobSize, partSize1), calculateNumberOfParts(blobSize, partSize1));
 * this file be licensed under the Apache-2.0 license or a
        @Override
        assertTrue(countDownLatch.await(5000, TimeUnit.SECONDS));
            } catch (IOException ex) {
            .writePriority(writePriority)
        });
            .failIfAlreadyExists(false)  
            .failIfAlreadyExists(false)
        assertTrue(countDownLatch.await(5000, TimeUnit.SECONDS));
    private SizeBasedBlockingQ lowPrioritySizeBasedBlockingQ;
            if (throwExceptionOnFinalizeUpload) {  
                asyncExecutorContainer.getStreamReader(),
            countDownLatch.countDown();  
                asyncClient,
        }  
import java.util.concurrent.TimeUnit;  
        });
    private void testWriteBlobByStreamsLargeBlob(boolean expectException, boolean throwExceptionOnFinalizeUpload) throws IOException,
        testWriteBlobByStreamsLargeBlob(true, false);  
        private CompletableFuture<AbortMultipartUploadResponse> doOnAbortMultipartUpload(InvocationOnMock invocationOnMock) {
    }
                    throw new RuntimeException(e);
            );
        }
            openInputStreams.add(inputStream);  
        streamReaderService = Executors.newSingleThreadExecutor();  
        if (expectException) {
        normalPrioritySizeBasedBlockingQ.start();
        asyncService.verifyMultipartUploadCallCount(numberOfParts, throwExceptionOnFinalizeUpload);  
            this.length = length;
        private boolean failUploadPartRequest;
                }  
            .failIfAlreadyExists(false)  
        );
    private ScheduledExecutorService scheduler;
            "repository",
import java.util.stream.IntStream;
        StreamContextSupplier streamContextSupplier = partSize1 -> new StreamContext((partNo, size, position) -> {  
import static org.mockito.Mockito.any;
    private ExecutorService futureCompletionService;  
        final S3Client client = mock(S3Client.class);  
                inputStream.close();
                    completableFuture.completeExceptionally(new IOException());
        }, partSize1, calculateLastPartSize(blobSize, partSize1), calculateNumberOfParts(blobSize, partSize1));
            try {  
        if (expectException) {
            verify(client, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));  
        }
import org.opensearch.common.io.InputStreamContainer;
            InputStream inputStream = new OffsetRangeIndexInputStream(new ZeroIndexInput("desc", blobSize), size, position);
    private AsyncTransferEventLoopGroup transferNIOGroup;
            .doRemoteDataIntegrityCheck(false)  
            assertEquals(multipartUploadId, completeMultipartUploadRequest.uploadId());
        CountDownLatch countDownLatch = new CountDownLatch(1);
            CompleteMultipartUploadRequest completeMultipartUploadRequest = invocationOnMock.getArgument(0);
        private String multipartUploadId;
        when(blobStore.getNormalPrioritySizeBasedBlockingQ()).thenReturn(sizeBasedBlockingQ);
import java.util.concurrent.CompletableFuture;  
/*  
        if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to  
            SERVER_SIDE_ENCRYPTION_TYPE_SETTING.getDefault(Settings.EMPTY),
import org.junit.After;  
            closed.set(true);  
        private void ensureOpen() throws IOException {  
        IOUtils.close(asyncService);
            transferNIOGroup  
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_ENCRYPTION_CONTEXT_SETTING;  
                } else {
            BULK_DELETE_SIZE.get(Settings.EMPTY),
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        }
        public void seek(long pos) throws IOException {  
        if (expectException || throwExceptionOnFinalizeUpload) {
                if (failPutObjectRequest) {
            return completableFuture;
            streamReaderService,
        when(client.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(createMultipartUploadResponse);
                asyncExecutorContainer.getStreamReader(),  
    private int calculateNumberOfParts(long contentLength, long partSize) {  
            .doRemoteDataIntegrityCheck(false)
            assertNull(exceptionRef.get());  
    private ExecutorService remoteTransferRetry;
        }
            }  
        testLargeFilesRedirectedToSlowSyncClient(false, WritePriority.LOW);
        if (expectException || throwExceptionOnFinalizeUpload) {
import org.opensearch.test.OpenSearchTestCase;
        private void setupFailureBooleans(  
 *
import org.opensearch.common.settings.Settings;  
                times(
            new ByteSizeValue(Runtime.getRuntime().availableProcessors() * 20L, ByteSizeUnit.GB),
 * compatible open source license.
            new ByteSizeValue(Runtime.getRuntime().availableProcessors() * 10L, ByteSizeUnit.GB),
            exceptionRef.set(ex);
        openInputStreams.forEach(inputStream -> {
         * @param resourceDescription resourceDescription should be a non-null, opaque string describing this resource; it's returned
import java.util.concurrent.CountDownLatch;
    public void testWriteBlobByStreamsSingleChunkUploadNoFailure() throws IOException, ExecutionException, InterruptedException {
            reads.addAndGet(toCopy);
        normalPrioritySizeBasedBlockingQ = new SizeBasedBlockingQ(  
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(randomAlphaOfLength(10));
            asyncService,
                    (!failCreateMultipartUploadRequest && (failUploadPartRequest || failCompleteMultipartUploadRequest))  
            doAnswer(this::doOnAbortMultipartUpload).when(asyncClient).abortMultipartUpload(any(AbortMultipartUploadRequest.class));  
        final long blobSize = ((numberOfParts - 1) * partSize.getBytes()) + lastPartSize;  
import java.util.concurrent.atomic.AtomicBoolean;
        testWriteBlobByStreams(false, true);  
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
import java.util.concurrent.atomic.AtomicReference;  
    }
            }).start();
        s3BlobContainer.asyncBlobUpload(writeContext, completionListener);
        return new S3BlobContainer(BlobPath.cleanPath(), createBlobStore());  
            return new InputStreamContainer(inputStream, size, position);
                } catch (InterruptedException e) {
        });
        private final S3AsyncClient asyncClient = mock(S3AsyncClient.class);  
        asyncService = new MockS3AsyncService(configPath(), 1000);
import org.opensearch.threadpool.Scheduler;
import java.util.List;
            .build();
            SERVER_SIDE_ENCRYPTION_KMS_KEY_SETTING.getDefault(Settings.EMPTY),  
            return Math.max(length - reads.get(), 0);  
    }
import static org.opensearch.repositories.s3.S3Repository.BULK_DELETE_SIZE;  
        public MockS3AsyncService(Path configPath, int maxDelayInFutureCompletionMillis) {
            S3Repository.STORAGE_CLASS_SETTING.getDefault(Settings.EMPTY),
import org.mockito.Mockito;  
            boolean failCompleteMultipartUploadRequest
                } catch (InterruptedException e) {
        when(blobStore.bucket()).thenReturn(bucketName);  
                    completableFuture.complete(DeleteObjectResponse.builder().build());
            openInputStreams.add(inputStream);
        private CompletableFuture<PutObjectResponse> doOnPutObject(InvocationOnMock invocationOnMock) {  
            reads.set(pos);
            anyMap(),
                    completableFuture.complete(PutObjectResponse.builder().build());
        }
            return new ZeroIndexInput(sliceDescription, length);
        WriteContext writeContext = new WriteContext.Builder().fileName("write_blob_by_streams_max_retries")  
        final BlobPath blobPath = new BlobPath();
            countDownLatch.countDown();
                    throw new RuntimeException(e);  
        }
import static org.mockito.Mockito.doAnswer;
                    genericStatsMetricPublisher
            .doRemoteDataIntegrityCheck(false)  
    private void testWriteBlobByStreams(boolean expectException, boolean throwExceptionOnFinalizeUpload) throws IOException,  
                    completableFuture.completeExceptionally(new IOException());  
            boolean failUploadPartRequest,  
            }).start();  
import java.util.HashMap;  
        blobContainer.asyncBlobUpload(writeContext, completionListener);  
import org.opensearch.common.util.io.IOUtils;
        }
        List<InputStream> openInputStreams = new ArrayList<>();
                } else {
            when(blobStore.getCannedACL()).thenReturn(cannedAccessControlList);  
        });  
            new Thread(() -> {  
        }
    private void testLargeFilesRedirectedToSlowSyncClient(boolean expectException, WritePriority writePriority) throws IOException,
        transferQueueConsumerService.shutdown();  
            repositoryMetadata,  
        public void close() throws IOException {
        };  
            CompletableFuture<AbortMultipartUploadResponse> completableFuture = new CompletableFuture<>();
import software.amazon.awssdk.services.s3.model.PutObjectRequest;  
import software.amazon.awssdk.core.async.AsyncRequestBody;
            ensureOpen();
        public void initializeMocks(  
                } catch (InterruptedException e) {
        final long blobSize = ((numberOfParts - 1) * partSize.getBytes()) + lastPartSize;
            .fileSize(blobSize)
    private long calculateLastPartSize(long totalSize, long partSize) {
                    completableFuture.completeExceptionally(new IOException());
            super(configPath);
                failCreateMultipartUploadRequest,
    }  
            this.maxDelayInFutureCompletionMillis = maxDelayInFutureCompletionMillis;  
            .writePriority(WritePriority.NORMAL)  
                throw new IOException("Stream closed");
        asyncService.verifySingleChunkUploadCallCount(throwExceptionOnFinalizeUpload);
         */
        );
        asyncService.initializeMocks(true, false, false, false);
        testWriteBlobByStreams(false, false);
                try {
        final long lastPartSize = randomLongBetween(10, 512);  
    }
    }
        testWriteBlobByStreamsLargeBlob(true, false);
    public void testWriteBlobByStreamsFinalizeUploadFailure() throws IOException, ExecutionException, InterruptedException {  
        CheckedConsumer<Boolean, IOException> uploadFinalizer = uploadSuccess -> {
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
        CountDownLatch countDownLatch = new CountDownLatch(1);
            }).start();
        }
        when(client.abortMultipartUpload(any(AbortMultipartUploadRequest.class))).thenReturn(
            CompletableFuture<UploadPartResponse> completableFuture = new CompletableFuture<>();
    public void testWriteBlobByStreamsCreateMultipartRequestFailure() throws IOException, ExecutionException, InterruptedException {
        ActionListener<Void> completionListener = ActionListener.wrap(resp -> { countDownLatch.countDown(); }, ex -> {  
        openInputStreams.forEach(inputStream -> {
public class S3BlobContainerMockClientTests extends OpenSearchTestCase implements ConfigPathSupport {  
        }
        }
import java.util.Arrays;
            return new InputStreamContainer(inputStream, size, position);
    }
        final long lastPartSize = new ByteSizeValue(200, ByteSizeUnit.MB).getBytes();
                completableFuture.complete(AbortMultipartUploadResponse.builder().build());  
        SizeBasedBlockingQ sizeBasedBlockingQ = new SizeBasedBlockingQ(  
        final ByteSizeValue partSize = S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING.getDefault(Settings.EMPTY);  
                }  
        asyncService.initializeMocks(false, false, false, false);  
        return new S3BlobStore(  
            return completableFuture;  
import software.amazon.awssdk.core.sync.RequestBody;  
        }
        final RepositoryMetadata repositoryMetadata = new RepositoryMetadata(  
    }  
        public long getFilePointer() {
            if (closed.get()) {
import static org.opensearch.repositories.s3.S3Repository.EXPECTED_BUCKET_OWNER_SETTING;
        final CreateMultipartUploadResponse createMultipartUploadResponse = CreateMultipartUploadResponse.builder()
            final long available = available();
            10,  
            SizeBasedBlockingQ.QueueEventType.NORMAL  
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(randomBoolean());  
import java.nio.file.Path;  
        CheckedConsumer<Boolean, IOException> uploadFinalizer = uploadSuccess -> {
        normalPrioritySizeBasedBlockingQ.close();
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        // Fail the completion request
                }  
            }
                any(AsyncRequestBody.class)
        if (cannedAccessControlList != null) {
                } catch (InterruptedException e) {
        /**
    }
        );  
        asyncService.initializeMocks(false, false, false, false);
import org.opensearch.core.common.unit.ByteSizeUnit;  
            new AsyncTransferManager(
            assertNotNull(exceptionRef.get());
            futureCompletionService,
    }  
        }  
            InputStream inputStream = new OffsetRangeIndexInputStream(new ByteArrayIndexInput("desc", bytes), size, position);  
            new Thread(() -> {  
                inputStream.close();
    private S3BlobContainer createBlobContainer() {
                failPutObjectRequest,
            ),
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadResponse;  
            assertNotNull(exceptionRef.get());  
            new Thread(() -> {
            ensureOpen();
        @Override
        transferNIOGroup.close();
    }
    static class ZeroIndexInput extends IndexInput {
            anyString(),
        }
                    throw new RuntimeException(e);  
        private boolean failCompleteMultipartUploadRequest;  
        public byte readByte() throws IOException {  
            .build();  
            boolean failCompleteMultipartUploadRequest
                fail("Failure while closing open input streams");
        private final long length;
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
        lowPrioritySizeBasedBlockingQ.start();  
import java.util.concurrent.Executors;
        ActionListener<Void> completionListener = ActionListener.wrap(resp -> { countDownLatch.countDown(); }, ex -> {  
        when(client.completeMultipartUpload(any(CompleteMultipartUploadRequest.class))).thenReturn(
        asyncService.initializeMocks(false, true, false, false);  
                    completableFuture.complete(CompleteMultipartUploadResponse.builder().build());
import org.junit.Assert;
        scheduler = new Scheduler.SafeScheduledThreadPoolExecutor(1);  
                if (failCreateMultipartUploadRequest) {  
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;
import org.opensearch.core.common.unit.ByteSizeValue;
            any(S3BlobStore.class),  
                }
            UploadPartRequest uploadPartRequest = invocationOnMock.getArgument(0);
            anyLong(),  
                    completableFuture.complete(CreateMultipartUploadResponse.builder().uploadId(multipartUploadId).build());  
import org.opensearch.repositories.s3.async.AsyncTransferEventLoopGroup;  
import org.opensearch.core.action.ActionListener;
                try {  
        private final AtomicBoolean closed = new AtomicBoolean(false);  
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;  
        testLargeFilesRedirectedToSlowSyncClient(false, WritePriority.NORMAL);
            openInputStreams.add(inputStream);
            "bucket",
        private final AtomicLong reads = new AtomicLong(0);
            return new AmazonAsyncS3Reference(AmazonAsyncS3WithCredentials.create(asyncClient, asyncClient, asyncClient, null));  
        openInputStreams.forEach(inputStream -> {
import java.util.concurrent.ScheduledExecutorService;
        public ZeroIndexInput(String resourceDescription, final long length) {
                    Thread.sleep(randomInt(maxDelayInFutureCompletionMillis));
            genericStatsMetricPublisher,
        testWriteBlobByStreamsLargeBlob(false, true);
    @Before
        }  
                )
    public void tearDown() throws Exception {
import static org.mockito.Mockito.verify;  
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            verify(asyncClient, times(!failCreateMultipartUploadRequest ? numberOfParts : 0)).uploadPart(  
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
                    Math.max(Runtime.getRuntime().availableProcessors() * 5, 10),
            return completableFuture;
            this.failCreateMultipartUploadRequest = failCreateMultipartUploadRequest;
    }  
        final ByteSizeValue partSize = new ByteSizeValue(capacity.getBytes() / numberOfParts + 1, ByteSizeUnit.BYTES);  
            }
        }
                try {  
                    completableFuture.complete(UploadPartResponse.builder().eTag("eTag").build());
import org.opensearch.repositories.s3.async.TransferSemaphoresHolder;  
import software.amazon.awssdk.services.s3.model.UploadPartResponse;
                } else {
                try {
            InputStream inputStream = new OffsetRangeIndexInputStream(new ZeroIndexInput("desc", blobSize), size, position);
     */  
            }).start();
            when(client.uploadPart(any(UploadPartRequest.class), any(RequestBody.class))).thenReturn(UploadPartResponse.builder().build());
            }  
                throw new RuntimeException();
                logger.error("Error closing input stream");  
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_TYPE_SETTING;
        }  
        List<InputStream> openInputStreams = new ArrayList<>();  
        } else {  
        remoteTransferRetry.shutdown();
                failCompleteMultipartUploadRequest
                .completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
            S3Repository.TYPE,
                SdkException.create("Expected upload part request to fail", new RuntimeException())
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
        AsyncExecutorContainer asyncExecutorContainer = new AsyncExecutorContainer(  
                    completableFuture.completeExceptionally(new IOException());  
    }  
