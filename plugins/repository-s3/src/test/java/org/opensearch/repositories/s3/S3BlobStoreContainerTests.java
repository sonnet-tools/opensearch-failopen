        private final int totalPageCount;
        ArgumentCaptor<DeleteObjectsRequest> deleteRequestCaptor = ArgumentCaptor.forClass(DeleteObjectsRequest.class);
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
        when(blobStore.clientReference()).thenReturn(clientReference);
        blobContainer.executeMultipartUpload(blobStore, blobName, inputStream, blobSize, metadata, null);
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
            null,
            }
        assertThrows(BlobStoreException.class, () -> blobContainer.blobExists(blobName));
                .build()
            expectedEncodedContext = java.util.Base64.getEncoder()
     * deliberately. That extra byte is what makes "too large" detectable without buffering the whole object: an object
    }
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            }
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(blobStore.bucket()).thenReturn(bucketName);
            expectedEtags.add(randomAlphaOfLength(50));
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        // Wait for publisher to complete
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
    public void testExecuteSingleUpload() throws IOException {
        List<String> deletedKeys = deleteRequestCaptor.getAllValues()
        final long blobSize = ByteSizeUnit.GB.toBytes(randomIntBetween(6, 10));
            }
        assertEquals(bucketName, capturedRequest.bucket());
        assertEquals(inputStream.available(), inputStreamContainer.getInputStream().available());
            subscriber.onSubscribe(new Subscription() {
        Map<String, BlobMetadata> listOfBlobs = blobContainer.listBlobsByPrefix(null);
        List<String> blobNames = Arrays.asList("test1", "test2");
    ) throws IOException {
import software.amazon.awssdk.services.s3.model.S3Error;
                } else {
        doAnswer(invocation -> {
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
        final boolean useSseKms = randomBoolean();
        // it should init cannedACL correctly
        final BlobPath blobPath = new BlobPath();
        when(blobStore.bucket()).thenReturn(bucketName);
            BlobVersionConflictException.class,
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
    public void testDeleteAsync() throws Exception {
        final BlobPath blobPath = new BlobPath();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
            public void onResponse(Void aVoid) {
        when(blobStore.bucket()).thenReturn(bucketName);
        );
        List<S3Object> s3Objects = new ArrayList<>();
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
        final long partSize = Math.min(bufferSize, blobSize);
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        final boolean useSseKms = randomBoolean();
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
        assertEquals(expectedEtags, actualETags);
    }
        CompletableFuture<DeleteObjectsResponse> neverCompletingFuture = new CompletableFuture<>();
        when(blobStore.clientReference()).thenReturn(clientReference);
        final BlobPath blobPath = new BlobPath();
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        when(blobStore.clientReference()).thenReturn(clientReference);
        assertNotNull(exceptionRef.get());
                }
    /**
import software.amazon.awssdk.services.s3.model.Checksum;
import software.amazon.awssdk.awscore.exception.AwsErrorDetails;
    }
        assertThat(ex.getMessage(), equalTo("Glacier storage class is not supported"));
        when(client.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listObjectsV2Iterable);
        mockObjectPartResponse(s3AsyncClient, bucketName, blobName, objectPartCount, partSize, objectSize);
        );
            // Calculate expected Base64-encoded result
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
        doAnswer(invocation -> {
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
        );
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
            getObjectResponse,
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
            AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null)
            }
            String blobPath,
                    public void onFailure(Exception e) {}
            @Override
        testListBlobsByPrefixInLexicographicOrder(-5, 0, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
        when(blobStore.getBulkDeletesSize()).thenReturn(bulkDeleteSize);
    }
    }
import java.util.NoSuchElementException;
        final String token = blobContainer.writeBlobConditionally(
                () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, "\"stale\"")
 */
        when(blobStore.bucket()).thenReturn(bucketName);
        inputStreamContainer = S3BlobContainer.transformResponseToInputStreamContainer(responseInputStream, true);
            assertEquals(payload.length, actual.length);
            s3Exception(404, "NoSuchBucket"),
        final S3Client client = mock(S3Client.class);
                    } else {
            assertEquals(kmsKeyId, request.ssekmsKeyId());
        getObjectAttributesResponseCompletableFuture.complete(
            @Override
        assertTrue(blobContainer.blobExists(blobName));
        final BlobPath blobPath = new BlobPath();
        assertEquals(blobPath.buildAsString() + blobName, initRequest.key());
                final UploadPartRequest request = (UploadPartRequest) invocationOnMock.getArguments()[0];
            } else {
        final List<UploadPartRequest> uploadRequests = uploadPartRequestArgumentCaptor.getAllValues();
        CountDownLatch latch = new CountDownLatch(1);
        assertNotNull(exceptionRef.get());
                conflict
        assertFalse(write instanceof BlobVersionConflictException);
    public void testCaseInsensitiveStorageClass() {
    }
        CountDownLatch latch = new CountDownLatch(1);
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        List<ListObjectsV2Response> responses = new ArrayList<>();
            Thread.currentThread().interrupt();
 * ownership. Elasticsearch licenses this file to you under
        IOException e = expectThrows(IOException.class, () -> blobContainer.deleteBlobsIgnoringIfNotExists(blobNames));
        LatchedActionListener<ReadContext> listener = new LatchedActionListener<>(readContextActionListener, countDownLatch);
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
                    if (!hasEmittedItem.getAndSet(true)) {
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        );
            s3AsyncClient,
        when(blobStore.bucket()).thenReturn(bucketName);
        assertArrayEquals(payload, blob.content());
     * infrastructure error and stays retryable, and a create-if-absent ({@code If-None-Match: *}) never 404s on the
        public boolean hasNext() {
    }
                .checksum(Checksum.builder().checksumCRC32(checksum).build())
            List<DeletedObject> deletedObjects = new ArrayList<>();
     * object itself, so a 404 there is never a lost CAS.
    public void testExecuteMultipartUploadBlobSizeTooLarge() {
        // But as of today, the blob delete count and bytes is updated a bit earlier.
        }
import static org.mockito.ArgumentMatchers.any;
        List<String> emptyBlobNames = Collections.emptyList();
        final boolean useSseKms = randomBoolean();
        doAnswer(invocation -> {
    public void testReadBlobAsyncOnCompleteFailureMissingData() throws Exception {
            subscriber.onSubscribe(new Subscription() {
                exceptionRef.set(e);
        verify(s3AsyncClient, times(1)).listObjectsV2Paginator(any(ListObjectsV2Request.class));
        ) {
        CountDownLatch latch = new CountDownLatch(1);
        });
    public void testDeleteAsyncFailure() throws Exception {
        final String token = blobContainer.writeBlobConditionally(
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        failedFuture.completeExceptionally(new RuntimeException("Simulated delete error"));
            }
            });
        blobContainer.deleteAsync(new ActionListener<>() {
    public void testInitStorageClass() {
        final boolean useBucketKey = randomBoolean();
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        }
        final AmazonAsyncS3Reference amazonAsyncS3Reference = new AmazonAsyncS3Reference(
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
    }
        getObjectResponse = GetObjectResponse.builder().contentRange(contentRange).build();
    }
            .statusCode(statusCode)
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        RuntimeException simulatedError = new RuntimeException("Simulated error");
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
        assertThat(S3BlobStore.initStorageClass("intelLigeNt_tieriNG"), equalTo(StorageClass.INTELLIGENT_TIERING));
        when(client.getObjectAsBytes(any(GetObjectRequest.class))).thenThrow(NoSuchKeyException.builder().build());
    }
            keysListed.sort(String::compareTo);
        }
        assertThat(S3BlobStore.initStorageClass("reduced_redundancy"), equalTo(StorageClass.REDUCED_REDUNDANCY));
                latch.countDown();
            .stream()
            s3AsyncClient,
            final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
                    }
                () -> blobContainer.listBlobsByPrefixInSortedOrder(null, limit, blobNameSortOrder, new ActionListener<>() {
        assertEquals("Part size must be greater than zero", e.getMessage());
    /** Transport-level SDK failures (no HTTP response at all) surface as plain retryable IOExceptions on both paths. */
    public void testBlobExists() {
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
                @Override
        when(blobStore.getBulkDeletesSize()).thenReturn(5);
            .build();
            final String kmsContext = "{\"repo\":\"test\"}";
    public void testGetBlobPartInputStream() throws Exception {
            s3AsyncClient,
        } else {
        final S3BlobStore blobStore = mock(S3BlobStore.class);
                List<S3Object> s3Objects = new ArrayList<>();
        ResponseInputStream<GetObjectResponse> responseInputStreamNoContentLength = new ResponseInputStream<>(
    public void testExecuteSingleUploadBlobSizeTooLarge() {
        long totalSize = 0;
                                .build()
                blobName,
            "public-read",
            )
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        final String kmsContext = randomAlphaOfLength(10);
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        assertThrows(SdkException.class, () -> S3BlobContainer.transformResponseToInputStreamContainer(responseInputStreamNoRange, true));
        PutObjectResponse response,
            public void onResponse(Void aVoid) {
    }
    /**
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        if (cannedAccessControlList != null) {
        BlobStoreException ex = expectThrows(BlobStoreException.class, () -> S3BlobStore.initStorageClass("whatever"));
        assertFalse(blobContainer.blobExists(blobName));
                @Override
        InputStreamContainer inputStreamContainer = readContext.getPartStreams().stream().findFirst().get().get().join();
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
            });
            assertEquals(createMultipartUploadResponse.uploadId(), uploadPartRequest.uploadId());
        when(client.getObjectAsBytes(captor.capture())).thenReturn(
            }
                .build()
            null
            s3AsyncClient,
        MockListObjectsV2ResponseIterator iterator = new MockListObjectsV2ResponseIterator(2, 5, 100);
        blobContainer.deleteAsync(new ActionListener<>() {
        final int objectSize = 100;
    private void testListBlobsByPrefixInLexicographicOrder(
                return ListObjectsV2Response.builder().contents(s3Objects).build();
import org.reactivestreams.Subscriber;
            return null;
        );
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        for (S3Exception conflict : conflicts) {
            getObjectAttributesResponseCompletableFuture
        CountingCompletionListener<ReadContext> readContextActionListener = new CountingCompletionListener<>();
        for (int i = 0; i < numObjects; i++) {
            });
        ArgumentCaptor<PutObjectRequest> captor,
            // Mock a properly formatted JSON encryption context
    }
                        subscriber.onNext(responses.get(currentCounter));
        final BlobPath blobPath = new BlobPath();
        when(s3AsyncClient.getObjectAttributes(any(GetObjectAttributesRequest.class))).thenThrow(new RuntimeException());
import software.amazon.awssdk.services.s3.model.S3Object;
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
    public void testListBlobsByPrefixInLexicographicOrderWithLimitLessThanPageSize() throws IOException {
    public void testDeleteWithInterruptedException() throws Exception {
        );
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
            when(client.uploadPart(any(UploadPartRequest.class), any(RequestBody.class))).thenThrow(exceptions.get(stage));
        assertNotNull(exceptionRef.get());
            expectedToken
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        when(blobStore.bucket()).thenReturn(bucketName);
        }
        final BlobPath blobPath = new BlobPath();
                @Override
public class S3BlobStoreContainerTests extends OpenSearchTestCase {
        );
        blobContainer.deleteBlobsAsyncIgnoringIfNotExists(emptyBlobNames, new ActionListener<Void>() {
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));
                @Override
            public void onResponse(DeleteResult deleteResult) {
        final String blobName = randomAlphaOfLengthBetween(1, 10);
                    keys.sort(keysComparator);
        );
    private static class MockListObjectsV2ResponseIterator implements Iterator<ListObjectsV2Response> {
        // Header based offset in case of a multi part object request
        final S3BlobContainer blobContainer = new S3BlobContainer(new BlobPath(), blobStore);
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
                exceptionRef.set(e);
 * this work for additional information regarding copyright
        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }
            .reduce(Integer::sum)
            GetObjectAttributesResponse.builder()
        );
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        assertEquals(IOException.class, exceptionRef.get().getClass());
            ).thenReturn(getObjectPartResponse);
                    if (done || n <= 0) return;
        String blobName,
            (S3Exception) S3Exception.builder().statusCode(412).message("precondition failed").build(),
import java.nio.file.NoSuchFileException;
            final int offset = partNumber * partSize;
        final S3BlobContainer blobContainer = conditionalWriteContainer(
    public void testInvalidCannedACL() {
            @Override
        int totalNumberOfParts,
        } else if (stage == 1) {
                IllegalArgumentException.class,
            @Override
    public void testNumberOfMultipartsWithZeroPartSize() {
        });
            s3AsyncClient,
import java.util.Collections;
        );
            assertEquals(expectedEncodedContext, request.ssekmsEncryptionContext());
        @Override
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
import static org.mockito.Mockito.verifyNoInteractions;
        );
            });
        final long contentLength = 10L;
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, "\"token\"")
import software.amazon.awssdk.services.s3.S3AsyncClient;
            assertEquals(blobPath.buildAsString() + blobName, uploadPartRequest.key());
        CountDownLatch latch = new CountDownLatch(1);
     * The other half of {@link #testReadBlobWithVersionRejectsOversizedBlob}: an object of exactly the bound is
        int size = 0;
    }
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
import software.amazon.awssdk.services.s3.model.S3Exception;
        final long objectSize = 100L;
                    subscriber.onComplete();
    }
                    int actualLimit = Math.max(0, Math.min(limit, 10));
    }
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
            @Override
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        when(blobStore.expectedBucketOwner()).thenReturn(null);
    public void testDeleteSdkExceptionDuringListOperation() throws Exception {
        // Fits in 1 empty part
import static org.mockito.Mockito.when;
        when(blobStore.bucket()).thenReturn(bucketName);
        final BlobPath blobPath = new BlobPath();
        failedFuture.completeExceptionally(new RuntimeException("Simulated delete error"));
            s3AsyncClient,
        CompletableFuture<ResponseInputStream<GetObjectResponse>> getObjectPartResponse = new CompletableFuture<>();
        AtomicBoolean onResponseCalled = new AtomicBoolean(false);
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
        final long sizeBound = randomIntBetween(1, 512);
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(useBucketKey);
 *
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
            SdkException.create("Expected initialization request to fail", new RuntimeException()),
    private void mockObjectPartResponse(
                )
        final String contentRange = "bytes 10-20/100";
 * software distributed under the License is distributed on an
            return responseCount;
 * You may obtain a copy of the License at
    public void testReadBlobWithVersionRejectsOversizedBlob() {
        );
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
            s3AsyncClient,
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            @Override
        );
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
        );
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        try (InputStream is = requestBody.contentStreamProvider().newStream()) {
        when(blobStore.bucket()).thenReturn(bucketName);
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
 * license agreements. See the NOTICE file distributed with
        final IllegalArgumentException e = expectThrows(
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        assertThrows(
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
        for (int i = 0; i < size; i++) {
            null // create-if-absent
    }
                latch.countDown();
            }
        RuntimeException simulatedFailure = new RuntimeException("Simulated failure");
        final S3BlobContainer blobContainer = new S3BlobContainer(new BlobPath(), blobStore);
            assertEquals(partSize, inputStreamContainer.getContentLength());
        expectThrows(NoSuchFileException.class, () -> blobContainer.readBlobWithVersion("missing"));
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
        CompletableFuture<GetObjectAttributesResponse> getObjectAttributesResponseCompletableFuture = new CompletableFuture<>();
        when(blobStore.getStorageClass()).thenReturn(randomFrom(StorageClass.values()));
        blobContainer.executeSingleUpload(blobStore, blobName, inputStream, blobSize, metadata, null);
        final BlobPath blobPath = new BlobPath();
        assertEquals("Failed to initiate async deletion", exceptionRef.get().getMessage());
        metadata.put("key1", "value1");
                public void request(long n) {
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable;
                exceptionRef.set(e);
        // Simulate a failure in deleteObjects
        final int objectPartCount = 10;
        int bulkDeleteSize = 5;
        when(client.uploadPart(uploadPartRequestArgumentCaptor.capture(), requestBodyArgumentCaptor.capture())).thenAnswer(
        }
            () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, "\"token\"")
        doAnswer(invocation -> {
        blobContainer.deleteBlobsAsyncIgnoringIfNotExists(blobNames, new ActionListener<Void>() {
            }
        );
import software.amazon.awssdk.services.s3.model.StorageClass;
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        // it should default to `standard`
        final boolean useSseKms = randomBoolean();
            subscriber.onError(simulatedError);
    }
            s3Objects.add(S3Object.builder().key(randomAlphaOfLength(10)).size(size).build());
        assertThat(S3BlobStore.initCannedACL(""), equalTo(ObjectCannedACL.PRIVATE));
        assertEquals(objectSize, readContext.getBlobSize());
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(useBucketKey);
import software.amazon.awssdk.core.ResponseBytes;
        }
            () -> blobContainer.executeMultipartUpload(blobStore, randomAlphaOfLengthBetween(1, 10), null, blobSize, null, null)
        when(blobStore.bucket()).thenReturn(bucketName);
        if (useSseKms) {
        final S3Exception[] conflicts = new S3Exception[] {
        int expectedDeleteCalls = (int) Math.ceil((double) totalObjects / bulkDeleteSize);
        );
        final String eTag = "\"" + UUID.randomUUID() + "\"";
        );
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(kmsContext);
            });
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
            new ByteArrayInputStream(payload),
            "public-read-write",
                latch.countDown();
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
            }
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
     * S3 fails an {@code If-Match} write with 404 {@code NoSuchKey} rather than 412 when the key has no current
                fail("Unexpected failure: " + e.getMessage());
            responses.add(ListObjectsV2Response.builder().contents(pageObjects).build());
import software.amazon.awssdk.services.s3.model.GetObjectAttributesResponse;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
            }
     * {@code FsBlobContainer}, which also reports a conflict for a missing blob.
        assertEquals(simulatedError, e.getCause().getCause());
                @Override
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(kmsContext);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(client.getObjectAsBytes(any(GetObjectRequest.class))).thenThrow(SdkException.builder().message("no route").build());
    }
    public void testDeleteWithExecutionException() throws Exception {
        assertTrue(Thread.interrupted()); // Clear interrupted state
        final S3Client client = mock(S3Client.class);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
    public void testInvalidStorageClass() {
        CountDownLatch latch = new CountDownLatch(1);
            clientReference.incRef();
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        final String kmsContext = randomAlphaOfLength(10);
                exceptionRef.set(e);
        when(blobStore.bufferSizeInBytes()).thenReturn(sizeBound);
        // Exception when length is absent
            verify(client, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
        final S3BlobStore blobStore = mock(S3BlobStore.class);
    }
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
import org.reactivestreams.Subscription;
        assertEquals(1, readContextActionListener.getFailureCount());
        } else {
                }
        verifyNoInteractions(s3AsyncClient);
        }).when(blobStore).clientReference();
        LatchedActionListener<ReadContext> listener = new LatchedActionListener<>(readContextActionListener, countDownLatch);
     */
            final S3BlobContainer blobContainer = conditionalWriteContainer(ArgumentCaptor.forClass(PutObjectRequest.class), null, error);
        public MockListObjectsV2ResponseIterator(int totalPageCount, int s3ObjectsPerPage, long s3ObjectSize, String blobPath) {
    ) {
            s3Exception(409, "OperationAborted"),
        );
        final S3Client client = mock(S3Client.class);
            final InputStream inputStream = new ByteArrayInputStream(randomByteArrayOfLength(partSize));
            IllegalArgumentException.class,
            return keysListed;
    }
import software.amazon.awssdk.services.s3.model.CompletedPart;
            public void onResponse(DeleteResult deleteResult) {
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final IllegalArgumentException e = expectThrows(
        final VersionedBlob blob = new S3BlobContainer(new BlobPath(), blobStore).readBlobWithVersion("at-bound");
            for (int j = 0; j < s3ObjectsPerPage; j++) {
        final BlobPath blobPath = new BlobPath();
    public void testGetBlobMetadata() throws Exception {
                .objectSize(objectSize)
                    String s3ObjectKey = keysListed.get((currInvocationCount.get() - 1) * s3ObjectsPerPage + i);
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenThrow(simulatedFailure);
        RuntimeException simulatedError = new RuntimeException("Simulated delete error");
    public void testListBlobsByPrefixInLexicographicOrderWithNegativeLimit() throws IOException {
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        doAnswer(invocation -> {
        CountDownLatch latch = new CountDownLatch(1);
                exceptionRef.set(e);
    }
            public void onFailure(Exception e) {
                .build()
                    fail("blobContainer.listBlobsByPrefixInLexicographicOrder failed with exception: " + e.getMessage());
        final S3BlobStore blobStore = mock(S3BlobStore.class);
    public void testDeleteTimeoutWithNeverCompletingAsyncDeletionFuture() throws Exception {
            IllegalArgumentException.class,
            @Override
            final S3BlobContainer blobContainer = conditionalWriteContainer(ArgumentCaptor.forClass(PutObjectRequest.class), null, error);
        BlobContainer.BlobNameSortOrder blobNameSortOrder
        );
        }
            s3AsyncClient,
        assertNull(exceptionRef.get());
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        assertEquals(checksum, readContext.getBlobChecksum());
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
        final String kmsKeyId = randomAlphaOfLength(10);
                resultRef.set(deleteResult);
                @Override
            return null;
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
     * at the bound comes back whole and passes, one over comes back truncated to bound+1 and trips the check. The pair
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        final StorageClass storageClass = randomFrom(StorageClass.values());
        if (useSseKms) {
            }
import static org.hamcrest.Matchers.equalTo;
        assertEquals("Failed to delete blobs " + blobNames, exceptionRef.get().getMessage());
            ArgumentCaptor.forClass(PutObjectRequest.class),
            exception = e;
            final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        blobContainer.readBlobAsync(blobName, listener);
                public void request(long n) {
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        latch.await();
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 64));
        final ArgumentCaptor<PutObjectRequest> putReqCaptor = ArgumentCaptor.forClass(PutObjectRequest.class);
            blobContainer.listBlobsByPrefixInSortedOrder(null, limit, blobNameSortOrder, new ActionListener<>() {
            null,
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        @Override
            SdkException.create("Expected upload part request to fail", new RuntimeException()),
                latch.countDown();
        );
        final boolean useBucketKey = randomBoolean();
        assertEquals("bytes=0-" + ByteSizeUnit.MB.toBytes(1), captor.getValue().range());
            public void onFailure(Exception e) {
    public void testWriteBlobConditionallyTreatsIfMatchOnDeletedKeyAsLostCas() {
        when(blobStore.bucket()).thenReturn(bucketName);
            );
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(failedFuture);
    }
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            s3AsyncClient,
            size = endIndex;
import org.opensearch.common.blobstore.BlobStoreException;
        final ArgumentCaptor<CreateMultipartUploadRequest> createMultipartUploadRequestArgumentCaptor = ArgumentCaptor.forClass(
        int expectedDeletedObjectsCall = numObjects / bulkDeleteSize + (numObjects % bulkDeleteSize > 0 ? 1 : 0);
        assertEquals(newETag, token);
        final S3BlobContainer blobContainer = new S3BlobContainer(mock(BlobPath.class), blobStore);
                            ListObjectsV2Response.builder().contents(S3Object.builder().key("test-key").size(100L).build()).build()
        final ArgumentCaptor<PutObjectRequest> captor = ArgumentCaptor.forClass(PutObjectRequest.class);
        // Create a future that never completes
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        when(blobStore.bucket()).thenReturn(bucketName);
        assertEquals("Upload request size [" + blobSize + "] can't be larger than 5gb", e.getMessage());
                null
                .checksum(Checksum.builder().checksumCRC32(checksum).build())
                public void onResponse(List<BlobMetadata> blobMetadata) {
        BlobPath blobPath = mock(BlobPath.class);
        CountingCompletionListener<ReadContext> readContextActionListener = new CountingCompletionListener<>();
        assertEquals(blobPath.buildAsString() + blobName, completeMultipartUploadRequest.key());
        final Tuple<Long, Long> numberOfParts = S3BlobContainer.numberOfMultiparts(blobSize, bufferSize);
                latch.countDown();
        assertTrue(latch.await(5, TimeUnit.SECONDS));
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(
        final ArgumentCaptor<UploadPartRequest> uploadPartRequestArgumentCaptor = ArgumentCaptor.forClass(UploadPartRequest.class);
        final int objectPartCount = 10;
    public void testListBlobsByPrefixInLexicographicOrderWithLimitGreaterThanNumberOfRecords() throws IOException {
                latch.countDown();
        final S3Client client = mock(S3Client.class);
            // Fail the initialization request
        final ByteSizeUnit unit = randomFrom(ByteSizeUnit.BYTES, ByteSizeUnit.KB, ByteSizeUnit.MB, ByteSizeUnit.GB);
        when(client.headObject(any(HeadObjectRequest.class))).thenReturn(HeadObjectResponse.builder().build());
            .flatMap(r -> r.delete().objects().stream())
                logger.error("exception during deleteAsync", e);
import software.amazon.awssdk.services.s3.model.UploadPartResponse;
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            return null;
        assertTrue(Thread.interrupted()); // Clear interrupted state
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
        });
            verify(client, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
        CountDownLatch latch = new CountDownLatch(1);
 * Licensed to Elasticsearch under one or more contributor
            int totalPageCount,
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
            boolean throwExceptionOnNextInvocation
    /**
                        publisherCompletedLatch.countDown();
                pageObjects.add(S3Object.builder().key(randomAlphaOfLength(10)).size(s3ObjectSize).build());
        // Verify that no interactions with S3AsyncClient occurred
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
                latch.countDown();
        );
    }
        );
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(exceptionRef.get() instanceof CompletionException);
        public int getFailureCount() {
        when(blobStore.getBulkDeletesSize()).thenReturn(bulkDeleteSize);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
    private static class CountingCompletionListener<T> implements ActionListener<T> {
        final AmazonAsyncS3Reference amazonAsyncS3Reference = new AmazonAsyncS3Reference(
                () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, "\"token\"")
        ).thenReturn(getObjectPartResponse);
            getObjectAttributesResponseCompletableFuture
            }
        final CreateMultipartUploadResponse createMultipartUploadResponse = CreateMultipartUploadResponse.builder()
        assertThat(S3BlobStore.initCannedACL(null), equalTo(ObjectCannedACL.PRIVATE));
    public void testBlobExistsRequestFailure() {
        final BlobPath blobPath = new BlobPath();
        );
        );
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
        List<String> blobNames = Arrays.asList("test1", "test2");
package org.opensearch.repositories.s3;
import java.util.Comparator;
        AtomicInteger counter = new AtomicInteger();
            blobNames.add(randomAlphaOfLength(10));
                latch.countDown();
            verify(client, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
            if (currInvocationCount.getAndIncrement() < totalPageCount) {
        public void onResponse(T response) {
        when(s3AsyncClient.getObjectAttributes(any(GetObjectAttributesRequest.class))).thenReturn(
import static org.mockito.ArgumentMatchers.eq;
        final List<S3Object> s3Objects = new ArrayList<>();
            @Override
        }
        final ObjectCannedACL cannedAccessControlList = randomBoolean() ? randomFrom(ObjectCannedACL.values()) : null;
            }
        final S3BlobStore blobStore = mock(S3BlobStore.class);
                    List<String> sortedKeys = keys.subList(0, actualLimit);
        final S3BlobContainer blobContainer = conditionalWriteContainer(captor, PutObjectResponse.builder().eTag(eTag).build(), null);
    /**
        final BlobPath blobPath = new BlobPath();
            () -> blobContainer.executeSingleUpload(blobStore, randomAlphaOfLengthBetween(1, 10), null, blobSize, null, null)
        );
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
        public int numberOfPagesFetched() {
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        final AtomicBoolean hasEmittedItem = new AtomicBoolean(false);
        assertEquals("Unable to upload object [" + blobName + "] using multipart upload", e.getMessage());
 * SPDX-License-Identifier: Apache-2.0
        when(blobStore.getBulkDeletesSize()).thenReturn(bulkDeleteSize);
        AtomicInteger counter = new AtomicInteger();
        );
                @Override
        final IOException e = expectThrows(
            final int end = partNumber * partSize;
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        assertEquals(cannedAccessControlList, request.acl());
                }
        int limit,
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        assertEquals(totalSize, deleteResult.bytesDeleted());
            }
        final S3Exception[] retryable = new S3Exception[] {
            IOException.class,
        } else {
import java.util.concurrent.TimeUnit;
    public void testInitCannedACL() {
import software.amazon.awssdk.core.sync.RequestBody;
        final S3BlobStore blobStore = mock(S3BlobStore.class);
import org.opensearch.common.io.InputStreamContainer;
            assertArrayEquals(payload, actual);
            verify(client, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
                    if (currentCounter < responseList.size()) {
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(kmsContext);
        List<S3Object> allObjects = new ArrayList<>();
    }
        } else {
        final int totalObjects = 10;
            @Override
        DeleteResult deleteResult = deleteResultRef.get();
            }
    }
        assertEquals("java.lang.RuntimeException: Simulated delete failure", exceptionRef.get().getCause().getMessage());
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));
            (S3Exception) S3Exception.builder().statusCode(409).message("conflict").build() };
        int numObjects = randomIntBetween(20, 100);
        assertEquals(0, inputStreamContainer.getOffset());
            s3AsyncClient,
            null
                })
                            ListObjectsV2Response.builder()
        }
                latch.countDown();
                exceptionRef.set(e);
        IOException e = expectThrows(IOException.class, blobContainer::delete);
    public void testRejectGlacierStorageClass() {
                exceptionRef.set(e);
        when(blobStore.bucket()).thenReturn(bucketName);
        assertNumberOfMultiparts(1, 0L, 0L, size);
    public void testExecuteMultipartUploadBlobSizeTooSmall() {
        when(blobStore.bucket()).thenReturn(bucketName);
            assertEquals(expectedEncodedContext, initRequest.ssekmsEncryptionContext());
        CompletableFuture<ResponseInputStream<GetObjectResponse>> getObjectPartResponse = new CompletableFuture<>();
        });
        when(s3AsyncClient.getObjectAttributes(any(GetObjectAttributesRequest.class))).thenReturn(
        when(blobStore.getBulkDeletesSize()).thenReturn(5);
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final int objectPartCount = 10;
    ) {
        }
            getObjectAttributesResponseCompletableFuture
            int endIndex = Math.min(numObjects, size + toAdd);
            getObjectResponse,
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        });
        when(
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
            when(client.putObject(captor.capture(), any(RequestBody.class))).thenReturn(response);
        CompletableFuture<GetObjectAttributesResponse> getObjectAttributesResponseCompletableFuture = new CompletableFuture<>();
     * @throws IOException
    public void testWriteBlobConditionallyRejectsOversizedPayload() {
        } else {
        when(blobStore.clientReference()).thenReturn(clientReference);
    }
    public void testWriteBlobConditionallyWithTokenSetsIfMatch() throws IOException {
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        doAnswer(invocation -> {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        when(client.headObject(any(HeadObjectRequest.class))).thenThrow(NoSuchKeyException.builder().build());
        List<String> blobNames = Arrays.asList("blob1", "blob2", "blob3");
        when(listObjectsV2Iterable.iterator()).thenReturn(iterator);
                @Override
                }
        final S3BlobStore blobStore = mock(S3BlobStore.class);
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadResponse;
                .checksum(Checksum.builder().build())
        }
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
import software.amazon.awssdk.services.s3.model.DeletedObject;
            CompleteMultipartUploadRequest.class
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(kmsKeyId);
    public void testListBlobsByPrefixInLexicographicOrderWithLimitEqualToPageSize() throws IOException {
        private Exception exception;
                        () -> sub.onNext(
                }
        }
        final AmazonAsyncS3Reference amazonAsyncS3Reference = new AmazonAsyncS3Reference(
        );
            .get();
        }
            IllegalArgumentException.class,
        assertEquals(0, readContextActionListener.getResponseCount());
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
        final String kmsKeyId = randomAlphaOfLength(10);
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
            @Override
        AtomicInteger deleteCallCount = new AtomicInteger(0);
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
        GetObjectAttributesResponse objectAttributesResponse = responseFuture.get();
        when(blobStore.clientReference()).thenReturn(clientReference);
        int bulkDeleteSize = randomIntBetween(1, 10);
                public void cancel() {}
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(useBucketKey);
import static org.hamcrest.Matchers.instanceOf;
        final int blobSize = randomIntBetween(0, bufferSize);
        final String checksum = randomAlphaOfLength(10);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
                    } else {
        final BlobPath blobPath = new BlobPath();
        assertThat(ex.getMessage(), equalTo("`whatever` is not a valid S3 Storage Class."));
                    );
        blobContainer.deleteAsync(new ActionListener<>() {
            s3AsyncClient,
import software.amazon.awssdk.core.exception.SdkException;
     */
        assertFalse(read instanceof BlobVersionConflictException);
                fail("Expected a failure, but got a success response");
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
            }
    public void testDeleteBlobsAsyncIgnoringIfNotExistsWithEmptyList() throws Exception {
        assertEquals(0, inputStreamContainer.getOffset());
        if (randomBoolean()) {
    public void testDeleteBlobsAsyncIgnoringIfNotExistsInitializationFailure() throws Exception {
        for (S3Exception error : retryable) {
            subscriber.onSubscribe(new Subscription() {
                .encodeToString(kmsContext.getBytes(java.nio.charset.StandardCharsets.UTF_8));
            s3AsyncClient,
                .objectSize(null)
            public void onFailure(Exception e) {
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        final BlobPath blobPath = new BlobPath();
            s3AsyncClient,
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
        final S3Client client = mock(S3Client.class);
            IntStream.of(randomIntBetween(1, 5)).forEach(value -> blobPath.add("path_" + value));
                public void cancel() {}
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        // Matches the write side, which rejects only blobSize > bufferSizeInBytes.
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
    }
        final String blobName = randomAlphaOfLengthBetween(1, 10);
                latch.countDown();
        final ListObjectsV2Iterable listObjectsV2Iterable = mock(ListObjectsV2Iterable.class);
            GetObjectAttributesResponse.builder()
            payload.length,
            s3AsyncClient,
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        assertNumberOfMultiparts(factor, size, size * factor, size);
        // Simulate a failure in deleteObjects
        failedFuture.completeExceptionally(simulatedError);
            GetObjectResponse getObjectResponse = GetObjectResponse.builder()
        }
        final S3BlobContainer blobContainer = conditionalWriteContainer(captor, PutObjectResponse.builder().eTag(newETag).build(), null);
        CompletableFuture<DeleteObjectsResponse> failedFuture = new CompletableFuture<>();
        assertEquals(bucketName, completeMultipartUploadRequest.bucket());
import java.io.InputStream;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        } else {
        });
        blobContainer.readBlobAsync(blobName, listener);
                .encodeToString(kmsContext.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    public void testReadBlobWithVersionOnMissingBlobThrowsNoSuchFile() {
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
            byte[] expectedBytes = inputStream.readAllBytes();
        }
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
        ReadContext readContext = readContextActionListener.getResponse();
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
        assertEquals(contentLength, inputStreamContainer.getContentLength());
        IOException ex = assertThrows(IOException.class, blobContainer::delete);
        } else {
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));
        AtomicReference<DeleteResult> resultRef = new AtomicReference<>();
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        // Fits in 1 part exactly
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));
            SdkException.class,
        final S3Client client = mock(S3Client.class);
                .objectSize(objectSize)
        // 0 offset in case of a single part object request
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        CountDownLatch latch = new CountDownLatch(1);
        );
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
            @Override
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(kmsKeyId);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
                public void cancel() {}
    }
                @Override
    }
            "authenticated-read",
        return (S3Exception) S3Exception.builder()
            s3AsyncClient,
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        blobContainer.deleteBlobsAsyncIgnoringIfNotExists(blobNames, new ActionListener<Void>() {
    public void testWriteBlobConditionallyTranslatesPreconditionFailures() {
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(kmsContext);
        verify(s3AsyncClient, times(1)).deleteObjects(any(DeleteObjectsRequest.class));
            );
        assertNotNull(exceptionRef.get().getCause());
        GetObjectResponse getObjectResponse = GetObjectResponse.builder().contentLength(contentLength).contentRange(contentRange).build();
        for (int i = 0; i < totalPageCount; i++) {
                null,
                    int currentCounter = counter.getAndIncrement();
        final VersionedBlob blob = new S3BlobContainer(new BlobPath(), blobStore).readBlobWithVersion(blobName);
        final S3BlobContainer blobContainer = new S3BlobContainer(new BlobPath(), blobStore);
        final String eTag = "\"" + UUID.randomUUID() + "\"";
        InputStreamContainer inputStreamContainer = S3BlobContainer.transformResponseToInputStreamContainer(
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        final IllegalArgumentException e = expectThrows(
import org.opensearch.action.LatchedActionListener;
        if (stage == 0) {
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        final String blobName = randomAlphaOfLengthBetween(1, 10);
            .map(ObjectIdentifier::key)
        verify(client, times(1)).headObject(any(HeadObjectRequest.class));
        if (useSseKms) {
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));
                any(GetObjectRequest.class),
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        final List<String> expectedEtags = new ArrayList<>();
        assertEquals(contentLength, inputStreamContainer.getContentLength());
        final long size = unit.toBytes(randomIntBetween(2, 1000));
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        when(blobStore.bucket()).thenReturn(bucketName);
import java.io.IOException;
     * mistaken for one.
        }
            GetObjectAttributesResponse.builder()
        assertEquals(objectSize, inputStreamContainer.getInputStream().readAllBytes().length);
            .map(s -> s.substring(blobPath.buildAsString().length()))
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
            .map(r -> r.delete().objects().size())
            return null;
     * Test the boundary value at page size to ensure
            @Override
        assertThat(ex.getMessage(), equalTo("cannedACL is not valid: [test_invalid]"));
        DeleteResult result = resultRef.get();
        final long bufferSize = ByteSizeUnit.MB.toBytes(150);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final String checksum = randomAlphaOfLength(10);
        public void onFailure(Exception e) {
            s3Exception(412, "PreconditionFailed"),
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        latch.await();
            public void onResponse(Void aVoid) {
 * KIND, either express or implied.  See the License for the
        blobContainer.readBlobAsync(blobName, listener);
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenAnswer(invocation -> {
            }
                        .collect(Collectors.toList());
            );
    }
            return null;
 *    http://www.apache.org/licenses/LICENSE-2.0
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
    }
            IllegalArgumentException.class,
        when(blobStore.bucket()).thenReturn(bucketName);
        // Simulate item-level errors during delete
            null
        final CountDownLatch publisherCompletedLatch = new CountDownLatch(1);
            final int start = (partNumber - 1) * partSize;
                eq(getObjectRequest),
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        assertEquals(1, readContextActionListener.getResponseCount());
            this.throwExceptionOnNextInvocation = throwExceptionOnNextInvocation;
            public void onFailure(Exception e) {
        assertNotNull("Expected DeleteResult but got null", result);
            SdkException.builder().message("no route").build()
import software.amazon.awssdk.core.async.AsyncResponseTransformer;
        when(blobStore.bucket()).thenReturn(bucketName);
            expectedEncodedContext = null;
    }
                volatile boolean done;
        when(blobStore.bucket()).thenReturn(bucketName);
        when(blobStore.getStorageClass()).thenReturn(randomFrom(StorageClass.values()));
        final BlobPath blobPath = new BlobPath();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    assertEquals(sortedKeys, blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList()));
                verify(client, times(6)).uploadPart(any(UploadPartRequest.class), any(RequestBody.class));
        S3AsyncClient s3AsyncClient,
            () -> S3BlobContainer.transformResponseToInputStreamContainer(responseInputStreamNoContentLength, true)
                        keysComparator = Collections.reverseOrder(String::compareTo);
        );
        );
     * unnecessary calls are not made to S3 by fetching the next page.
        final long contentLength = 10L;
            () -> blobContainer.executeMultipartUpload(blobStore, randomAlphaOfLengthBetween(1, 10), null, blobSize, null, null)
        final InputStream inputStream = ResponseInputStream.nullInputStream();
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
            null
import org.opensearch.common.blobstore.VersionedBlob;
        LatchedActionListener<ReadContext> listener = new LatchedActionListener<>(readContextActionListener, countDownLatch);
            }
 * The OpenSearch Contributors require contributions made to
        return new S3BlobContainer(new BlobPath(), blobStore);
        assertNotNull(exceptionRef.get().getCause());
        inputStreamContainer = blobContainer.getBlobPartInputStreamContainer(s3AsyncClient, bucketName, blobName, null).get();
    public void testDeleteSdkExceptionDuringDeleteOperation() throws Exception {
                BlobVersionConflictException.class,
        assertEquals(checksum, readContext.getBlobChecksum());
        final String blobName = randomAlphaOfLengthBetween(1, 10);
                fail("Expected a failure, but got a success response");
        CountingCompletionListener<ReadContext> readContextActionListener = new CountingCompletionListener<>();
        assertEquals(inputStream.available(), inputStreamContainer.getInputStream().available());
        assertEquals(metadata, request.metadata());
            public void onResponse(DeleteResult deleteResult) {
        final boolean useBucketKey = randomBoolean();
        when(blobStore.clientReference()).thenReturn(clientReference);
        }
            }
            s3AsyncClient,
import java.util.concurrent.CompletableFuture;
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        int bulkDeleteSize = 3; // Small size to force multiple delete requests
            s3AsyncClient,
        assertNotNull(exceptionRef.get());
        when(blobStore.bucket()).thenReturn(bucketName);
        });
                    ).thenRun(sub::onComplete);
        when(client.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listObjectsV2Iterable);
        assertThat(S3BlobStore.initStorageClass(null), equalTo(StorageClass.STANDARD));
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
                ArgumentMatchers.<AsyncResponseTransformer<GetObjectResponse, ResponseInputStream<GetObjectResponse>>>any()
            CompletableFuture.completedFuture(DeleteObjectsResponse.builder().build())
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
    }
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        when(client.completeMultipartUpload(completeMultipartUploadRequestArgumentCaptor.capture())).thenReturn(
                    }
        final int bufferSize = randomIntBetween(1024, 2048);
                @Override
        when(client.headObject(any(HeadObjectRequest.class))).thenThrow(new RuntimeException());
        final ListObjectsV2Iterable listObjectsV2Iterable = mock(ListObjectsV2Iterable.class);
 * the Apache License, Version 2.0 (the "License"); you may
        );
    }
            @Override
                    errors.add(
            IOException.class,
            totalBytes += partSize;
                    public void onResponse(List<BlobMetadata> blobMetadata) {}
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        countDownLatch.await();
        assertEquals("Future got interrupted", e.getMessage());
                .objectSize((long) objectSize)
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadResponse;
            s3AsyncClient,
                    @Override
        } else {
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
                IOException.class,
            s3AsyncClient,
        @Override
        final ArgumentCaptor<RequestBody> requestBodyArgumentCaptor = ArgumentCaptor.forClass(RequestBody.class);
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
    }
            s3AsyncClient,
 */
            public void onFailure(Exception e) {
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
                    }
        if (failure != null) {
            ArgumentCaptor.forClass(PutObjectRequest.class),
        );
            keysListed = new ArrayList<>();
     * accepted. HTTP byte ranges are inclusive, so {@code bytes=0-N} asks for N+1 bytes - one more than the limit,
        assertEquals(simulatedFailure, exceptionRef.get().getCause());
        } else {
                final UploadPartRequest request = (UploadPartRequest) invocationOnMock.getArguments()[0];
import software.amazon.awssdk.core.ResponseInputStream;
        final S3BlobContainer blobContainer = new S3BlobContainer(new BlobPath(), blobStore);
            return exception;
                resultRef.set(deleteResult);
        CountDownLatch latch = new CountDownLatch(1);
import software.amazon.awssdk.services.s3.S3Client;
        final String blobName = randomAlphaOfLengthBetween(1, 10);
 *
    }
            failureCount++;
        final long s3ObjectSize = ByteSizeUnit.MB.toBytes(5);
            deleteCallCount.incrementAndGet();
            }
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        assertEquals(1, readContext.getNumberOfParts());
            return currInvocationCount.get();
    }
                latch.countDown();
        assertEquals("*", captor.getValue().ifNoneMatch());
                throw SdkException.builder().build();
        assertEquals(totalObjects * 100L, result.bytesDeleted());
    }
        assertEquals(totalSize, result.bytesDeleted());
        // Build the payload first so we know/keep its exact length
    }
            "fence",
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
        InputStreamContainer inputStreamContainer = blobContainer.getBlobPartInputStreamContainer(s3AsyncClient, bucketName, blobName, 0)
            @Override
            @Override
            public void onResponse(DeleteResult deleteResult) {
        final String checksum = randomAlphaOfLength(10);
            .parts()
import static org.mockito.Mockito.mock;
        final long objectSize = 100L;
    private void mockObjectResponse(S3AsyncClient s3AsyncClient, String bucketName, String blobName, int objectSize) {
        assertThat(S3BlobStore.initStorageClass("intelligent_tiering"), equalTo(StorageClass.INTELLIGENT_TIERING));
        // We expect half of the objects to be deleted successfully
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        latch.await();
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Publisher;
        final S3BlobStore blobStore = mock(S3BlobStore.class);
import java.util.List;
        }
        ResponseInputStream<GetObjectResponse> responseInputStreamNoRange = new ResponseInputStream<>(getObjectResponse, inputStream);
        when(blobStore.expectedBucketOwner()).thenReturn(null);
            long size = randomIntBetween(1, 100);
            }
    }
    }
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        when(blobStore.asyncClientReference()).thenReturn(amazonAsyncS3Reference);
import java.util.ArrayList;
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        assertEquals(0, inputStreamContainer.getOffset());
        mockObjectResponse(s3AsyncClient, bucketName, blobName, objectSize);
     * the precondition. A 404 without that code (e.g. {@code NoSuchBucket}, or an unlabelled response) is an
        testListBlobsByPrefixInLexicographicOrder(8, 2, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
            }
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
    }
        final IOException read = expectThrows(IOException.class, () -> blobContainer.readBlobWithVersion("fence"));
    public void testReadBlobWithVersionAcceptsBlobExactlyAtSizeBound() throws IOException {
        final PutObjectRequest request = putReqCaptor.getValue();
        assertNumberOfMultiparts(factor + 1, remaining, (size * factor) + remaining, size);
                }
import org.opensearch.core.common.unit.ByteSizeUnit;
        latch.await();
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(kmsKeyId);
        when(blobStore.bucket()).thenReturn(bucketName);
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        assertEquals(blobSize, request.contentLength().longValue());
 * Unless required by applicable law or agreed to in writing,
            totalSize += size;
        assertTrue(deletedKeys.containsAll(blobNames));
        // Create a publisher that emits one item and completes
                        .map(s -> s.substring(blobPath.buildAsString().length()))
                final UploadPartResponse response = UploadPartResponse.builder().eTag(randomAlphaOfLength(20)).build();
                                .contents(Collections.singletonList(S3Object.builder().key("test-key").size(100L).build()))
        });
        when(blobStore.bucket()).thenReturn(bucketName);
            final S3BlobContainer blobContainer = conditionalWriteContainer(
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
        failedFuture.completeExceptionally(new RuntimeException("Simulated delete failure"));
 * GitHub history for details.
     * like to a superseded writer, which must fence terminally instead of retrying forever. Matches
            this.response = response;
                verify(client, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
    public void testWriteBlobConditionallyCreateIfAbsentSetsIfNoneMatch() throws IOException {
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(failedFuture);
        final RequestBody requestBody = bodyCaptor.getValue();
    public void testDeleteAsyncListingError() throws Exception {
            }
        final BlobPath blobPath = new BlobPath();
        assertTrue("Exception should be an IOException", exceptionRef.get() instanceof IOException);
        final ArgumentCaptor<RequestBody> bodyCaptor = ArgumentCaptor.forClass(RequestBody.class);
                .objectSize(objectSize)
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
            .collect(Collectors.toSet());
        private final int s3ObjectsPerPage;
        final long blobSize = ByteSizeUnit.MB.toBytes(randomIntBetween(1, 4));
        final BlobPath blobPath = new BlobPath();
import java.util.stream.IntStream;
        assertNumberOfMultiparts(1, size, size, size * factor);
        assertEquals("java.lang.RuntimeException: Simulated delete error", exceptionRef.get().getMessage());
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
        assertEquals("Failed to list objects for deletion", exceptionRef.get().getMessage());
        when(
        final long blobSize = ByteSizeUnit.MB.toBytes(765);
        public MockListObjectsV2ResponseIterator(int totalPageCount, int s3ObjectsPerPage, long s3ObjectSize) {
            .awsErrorDetails(AwsErrorDetails.builder().errorCode(errorCode).build())
    public void testDeleteItemLevelErrorsDuringDelete() throws Exception {
                public void request(long n) {
                .objectParts(GetObjectAttributesParts.builder().totalPartsCount(objectPartCount).build())
                public void request(long n) {
                    }
                .build()
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
                .checksum(Checksum.builder().checksumCRC32(checksum).build())
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
    }
        getObjectPartResponse.complete(responseInputStream);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
import org.mockito.ArgumentMatchers;
    }
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
    public void testTransformResponseToInputStreamContainer() throws Exception {
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
    }
                keysListed.add(blobPath + UUID.randomUUID().toString());
            GetObjectAttributesResponse.builder()
        CountDownLatch latch = new CountDownLatch(1);
                blobStore,
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        assertEquals(CompletionException.class, exceptionRef.get().getClass());
                            .key(request.delete().objects().get(i).key())
                .build();
            this.s3ObjectsPerPage = s3ObjectsPerPage;
        GetObjectResponse getObjectResponse = GetObjectResponse.builder().contentLength((long) objectSize).build();
                    s3Objects.add(S3Object.builder().key(s3ObjectKey).size(s3ObjectSize).build());
    public void testExecuteSingleUploadBlobSizeLargerThanBufferSize() {
import org.opensearch.common.blobstore.BlobMetadata;
        assertEquals(10, listOfBlobs.size());
                            .build()
        CountDownLatch latch = new CountDownLatch(1);
        assertEquals(expectedToken, captor.getValue().ifMatch());
        // Exception when content range absent for multipart object
        when(blobStore.getStorageClass()).thenReturn(storageClass);
        // No exception when content range absent for single part object
    public void testBlobExistsNoSuchKeyException() {
        }
        when(blobStore.getBulkDeletesSize()).thenReturn(bulkDeleteSize);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(new byte[0]), blobSize, null)
        final List<String> actualETags = completeMultipartUploadRequest.multipartUpload()
                    }
    public void testWriteBlobConditionallyPropagatesOtherS3Errors() {
            CompletableFuture.completedFuture(DeleteObjectsResponse.builder().build())
        assertThat(S3BlobStore.initStorageClass("sTandaRd_Ia"), equalTo(StorageClass.STANDARD_IA));
        assertEquals("bytes=0-" + sizeBound, captor.getValue().range());
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
 * under the License.
        getObjectAttributesResponseCompletableFuture.complete(
            assertEquals(partSize, inputStreamContainer.getInputStream().readAllBytes().length);
        final String blobName = randomAlphaOfLengthBetween(1, 10);
                public void cancel() {}
            byte[] actual = is.readAllBytes();
        assertTrue(e.getMessage(), e.getMessage().contains("too large"));
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            s3AsyncClient.getObject(
            }
            verify(client, times(0)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
                }
            .uploadId(randomAlphaOfLength(10))
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        when(blobStore.asyncClientReference()).thenReturn(amazonAsyncS3Reference);
            )
        final List<ListObjectsV2Response> responseList = new ArrayList<>();
            @Override
        }
            assertEquals(blobName, abortRequest.key());
    public void testDeleteBlobsAsyncIgnoringIfNotExistsFailure() throws Exception {
        );
        } while (totalBytes < blobSize);
                s3AsyncClient.getObject(
        int totalBlobsDeleted = deleteRequestCaptor.getAllValues()
        AtomicBoolean onNext = new AtomicBoolean(false);
            }
    public void testWriteBlobConditionallyDoesNotTreatRetryableConflictsAsLostCas() {
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(
        final S3BlobContainer blobContainer = conditionalWriteContainer(
        final Map<String, String> metadata = new HashMap<>();
        assertEquals("Failed to delete blobs " + blobNames, e.getMessage());
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
        if (useSseKms) {
            return null;
                latch.countDown();
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
            (S3Exception) S3Exception.builder().statusCode(404).message("not found").build() };
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
        final Map<String, String> metadata = new HashMap<>();
        assertEquals("Upload request size [2097152] can't be larger than buffer size", e.getMessage());
                .build();
        assertEquals(objectSize, readContext.getBlobSize());
            long s3ObjectSize,
        assertEquals("java.lang.RuntimeException: Simulated delete error", exceptionRef.get().getMessage());
        assertThat(S3BlobStore.initStorageClass("oNeZoNe_iA"), equalTo(StorageClass.ONEZONE_IA));
                totalSize += s3ObjectSize;
        final IOException e = expectThrows(IOException.class, () -> {
            return response;
        final int objectPartCount = 10;
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
        final S3BlobContainer blobContainer = new S3BlobContainer(mock(BlobPath.class), blobStore);
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        CountDownLatch countDownLatch = new CountDownLatch(1);
import org.opensearch.common.blobstore.BlobVersionConflictException;
        when(blobStore.getBulkDeletesSize()).thenReturn(bulkDeleteSize);
        when(client.getObjectAsBytes(captor.capture())).thenReturn(
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(useBucketKey);
            ResponseInputStream<GetObjectResponse> responseInputStream = new ResponseInputStream<>(getObjectResponse, inputStream);
                }
        when(blobStore.asyncClientReference()).thenReturn(amazonAsyncS3Reference);
            int toAdd = randomIntBetween(10, 20);
        final S3Client client = mock(S3Client.class);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
            when(
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
            AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null)
            assertEquals(offset, inputStreamContainer.getOffset());
    public void testDeleteBlobsIgnoringIfNotExistsWithExecutionException() throws Exception {
            payload.length,
    /**
            verify(client, times(0)).uploadPart(any(UploadPartRequest.class), any(RequestBody.class));
        assertNull(captor.getValue().ifMatch());
        final byte[] payload = randomByteArrayOfLength(blobSize);
    }
    }
        final String checksum = randomAlphaOfLengthBetween(1, 10);
                        ListObjectsV2Response.builder().contents(S3Object.builder().key("test-key").size(100L).build()).build()
            List<S3Error> errors = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
            inputStream
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        // If-Match, but the 404 does not prove the key is gone
        final long sizeBound = randomIntBetween(1, 512);
        long totalBytes = 0;
            s3AsyncClient,
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null)
        assertEquals(contentLength, inputStreamContainer.getContentLength());
        final IOException e = expectThrows(IOException.class, () -> blobContainer.readBlobWithVersion("oversized"));
            when(blobStore.getCannedACL()).thenReturn(cannedAccessControlList);
        verify(s3AsyncClient, times(expectedDeleteCalls)).deleteObjects(deleteRequestCaptor.capture());
            public void onResponse(DeleteResult deleteResult) {
        int partSize,
    public void testExecuteMultipartUploadAborted() {
            return null;
        final BlobPath blobPath = new BlobPath();
                .contentRange(contentRange)
        }
        assertEquals(objectSize, inputStreamContainer.getContentLength());
        final long blobSize = ByteSizeUnit.GB.toBytes(randomIntBetween(1, 128));
import java.util.concurrent.CountDownLatch;
                    if (blobNameSortOrder != BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC) {
            }
            public void onFailure(Exception e) {
        assertEquals(expectedDeleteCalls, deleteCallCount.get());
        when(blobPath.buildAsString()).thenReturn("/dummy/path");
import java.util.concurrent.atomic.AtomicInteger;
            // so it must be retried - the retry answers definitively (412 = genuinely lost, success = not lost)
                }
        RuntimeException simulatedFailure = new RuntimeException("Simulated initialization failure");
                    done = true; // emit once
    public void testListBlobsByPrefixInLexicographicOrderWithZeroLimit() throws IOException {
        when(blobStore.getStorageClass()).thenReturn(storageClass);
        assertEquals(0, readContextActionListener.getFailureCount());
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
                fail("Expected failure but got success");
            GetObjectAttributesResponse.builder()
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
            public void onFailure(Exception e) {
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            .collect(Collectors.toList());
        blobContainer.deleteAsync(new ActionListener<>() {
        assertEquals(contentLength, inputStreamContainer.getContentLength());
        assertEquals("Failed to initiate async blob deletion", exceptionRef.get().getMessage());
        private T response;
        private final List<String> keysListed;
        ResponseInputStream<GetObjectResponse> responseInputStream = new ResponseInputStream<>(getObjectResponse, inputStream);
            if (throwExceptionOnNextInvocation) {
import software.amazon.awssdk.services.s3.model.ObjectIdentifier;
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
            public void onFailure(Exception e) {
                        subscriber.onNext(responseList.get(currentCounter));
    }
        assertEquals(objectPartCount, readContext.getNumberOfParts());
        getObjectAttributesResponseCompletableFuture.complete(
        assertThat(S3BlobStore.initStorageClass("reduCED_redundancy"), equalTo(StorageClass.REDUCED_REDUNDANCY));
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
                    assertEquals(actualLimit, blobMetadata.size());
    }
            when(client.putObject(captor.capture(), any(RequestBody.class))).thenThrow(failure);
        assertFalse(e instanceof BlobVersionConflictException);
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        final String kmsKeyId = randomAlphaOfLength(10);
        assertEquals("Expected remaining [" + expectedRemaining + "] but got [" + result.v2() + "]", expectedRemaining, (long) result.v2());
        final BlobPath blobPath = new BlobPath();
        final ObjectCannedACL cannedAccessControlList = randomBoolean() ? randomFrom(ObjectCannedACL.values()) : null;
                    ArgumentMatchers.<AsyncResponseTransformer<GetObjectResponse, ResponseInputStream<GetObjectResponse>>>any()
                deleteResultRef.set(deleteResult);
import org.opensearch.common.blobstore.BlobContainer;
            assertEquals(kmsKeyId, initRequest.ssekmsKeyId());
            // 412 is unambiguous, with or without an error code
            when(client.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(createMultipartUploadResponse);
        when(blobStore.clientReference()).thenReturn(clientReference);
            () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, null)
    }
            @Override
            final String kmsContext = "{\"repo\":\"test\"}";
        IOException e = expectThrows(IOException.class, () -> blobContainer.deleteBlobsIgnoringIfNotExists(blobNames));
        final S3Client client = mock(S3Client.class);
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
                    }
        final String kmsKeyId = randomAlphaOfLength(10);
                .checksum(Checksum.builder().checksumCRC32(checksum).build())
        }
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
            return failureCount;
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        );
        int size = randomIntBetween(10, 100);
            this.s3ObjectSize = s3ObjectSize;
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
import static org.mockito.Mockito.times;
                @Override
        CompletableFuture<GetObjectAttributesResponse> getObjectAttributesResponseCompletableFuture = new CompletableFuture<>();
import software.amazon.awssdk.services.s3.model.DeleteObjectsResponse;
        when(blobStore.bucket()).thenReturn(bucketName);
        assertEquals(allObjects.size(), result.blobsDeleted());
        String[] aclList = new String[] {
/*
        assertEquals(10, inputStreamContainer.getOffset());
            public void onResponse(DeleteResult deleteResult) {
            return null;
            for (int i = 0; i < request.delete().objects().size(); i++) {
            assertThat(acl.toString(), equalTo(aclString));
                fail("Expected a failure, but got a success response");
        );
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(kmsContext);
        final List<RequestBody> requestBodies = requestBodyArgumentCaptor.getAllValues();
        List<String> blobNames = Arrays.asList("blob1", "blob2", "blob3");
        }
            null
import java.util.stream.Collectors;
        assertEquals(IOException.class, exceptionRef.get().getClass());
import java.util.concurrent.CompletionException;
            s3AsyncClient,
                null,
        when(client.putObject(any(PutObjectRequest.class), any(RequestBody.class))).thenThrow(
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        final S3Client client = mock(S3Client.class);
        assertTrue(new S3BlobContainer(new BlobPath(), mock(S3BlobStore.class)).isConditionalWriteSupported());
    public void testDeleteAsyncDeletionError() throws Exception {
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
                .objectParts(GetObjectAttributesParts.builder().totalPartsCount(objectPartCount).build())
            SdkException.create("Expected completion request to fail", new RuntimeException())
            this(totalPageCount, s3ObjectsPerPage, s3ObjectSize, blobPath, false);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            assertEquals(ServerSideEncryption.AWS_KMS, initRequest.serverSideEncryption());
    }
        }
        final BlobPath blobPath = new BlobPath();
                for (int i = 0; i < s3ObjectsPerPage; i++) {
        assertEquals(0, inputStreamContainer.getOffset());
        );
        when(blobStore.bucket()).thenReturn(bucketName);
        final BlobPath blobPath = new BlobPath();
        when(client.abortMultipartUpload(argumentCaptor.capture())).thenReturn(AbortMultipartUploadResponse.builder().build());
        } else {
import org.opensearch.common.collect.Tuple;
            assertEquals(useBucketKey, initRequest.bucketKeyEnabled());
/*
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
            InputStreamContainer inputStreamContainer = readContext.getPartStreams().get(partNumber).get().join();
            assertFalse("[" + error + "] must not be reported as a lost CAS", e instanceof BlobVersionConflictException);
            inputStream
            final UploadPartRequest uploadPartRequest = uploadRequests.get(i);
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
        );
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        ReadContext readContext = readContextActionListener.getResponse();
        Set<String> keys = iterator.keysListed.stream()
                @Override
import software.amazon.awssdk.services.s3.model.GetObjectAttributesParts;
                public void request(long n) {
        public T getResponse() {
        // Simulate a failure when getting the asyncClientReference
        verify(client, times(1)).headObject(any(HeadObjectRequest.class));
                public void request(long n) {
    }
                    Comparator<String> keysComparator = String::compareTo;
        assertEquals(eTag, blob.versionToken());
                return response;
            }
        blobContainer.deleteAsync(new ActionListener<>() {
                }
        CompletableFuture<GetObjectAttributesResponse> getObjectAttributesResponseCompletableFuture = new CompletableFuture<>();
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        testListBlobsByPrefixInLexicographicOrder(5, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
            // a conflicting conditional write IN PROGRESS: the outcome of this request's precondition is unknown,
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
        when(blobStore.bufferSizeInBytes()).thenReturn(bufferSize);
                latch.countDown();
            final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            @Override
        }
        final String expectedEncodedContext;
            // Mock a properly formatted JSON encryption context
        final BlobPath blobPath = new BlobPath();
    public void testReadBlobAsyncSinglePart() throws Exception {
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        assertEquals(simulatedError, e.getCause());
        final String checksum = randomAlphaOfLength(10);
        when(client.getObjectAsBytes(any(GetObjectRequest.class))).thenReturn(
                fail("Unexpected failure: " + e.getMessage());
                @Override
        // Fits in N parts exactly
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
            throw new NoSuchElementException();
            final IOException e = expectThrows(
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
 *
        final long blobSize = ByteSizeUnit.MB.toBytes(2);
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));
        blobContainer.deleteBlobsAsyncIgnoringIfNotExists(blobNames, new ActionListener<Void>() {
        final BlobPath blobPath = new BlobPath();
        AtomicReference<DeleteResult> resultRef = new AtomicReference<>();
        testListBlobsByPrefixInLexicographicOrder(12, 2, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
        assertNotNull("An exception should have been thrown", exceptionRef.get());
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
            }
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            IllegalArgumentException.class,
        // create-if-absent: even NoSuchKey is not a precondition verdict
                }
        final ArgumentCaptor<GetObjectRequest> captor = ArgumentCaptor.forClass(GetObjectRequest.class);
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
        assertEquals("Failed to list objects for deletion", exceptionRef.get().getMessage());
        doAnswer(invocation -> {
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        for (String aclString : aclList) {
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        if (limit >= 0) {
        if (useSseKms) {
        final BlobPath blobPath = new BlobPath();
            });
            () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, null)
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        final ArgumentCaptor<GetObjectRequest> captor = ArgumentCaptor.forClass(GetObjectRequest.class);
        });
                .objectParts(GetObjectAttributesParts.builder().totalPartsCount(objectPartCount).build())
                            .message("Simulated error")
        // Explicit content length must be set on the request
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        ).thenReturn(getObjectPartResponse);
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;
        assertEquals("Simulated delete error", exceptionRef.get().getCause().getMessage());
        latch.await();
                    subscriber.onError(new RuntimeException("Simulated listing error"));
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            allObjects.addAll(pageObjects);
        final int partSize = 10;
        verify(s3AsyncClient, times(expectedDeletedObjectsCall)).deleteObjects(any(DeleteObjectsRequest.class));
                @Override
        assertEquals(numberOfParts.v1().intValue(), uploadRequests.size());
     * this is a definitively lost CAS, not a retryable error: it is exactly what a swept acknowledgement path looks
            expectedEncodedContext = null;
    }
            null
        metadata.put("key1", "value1");
import java.io.ByteArrayInputStream;
        DeleteObjectsRequest capturedRequest = deleteRequestCaptor.getAllValues().stream().findAny().get();
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));
        assertThat(S3BlobStore.initStorageClass(""), equalTo(StorageClass.STANDARD));
            int s3ObjectsPerPage,
            return null;
            public void onResponse(DeleteResult deleteResult) {
        assertEquals("Conditional write request size [" + blobSize + "] can't be larger than buffer size", e.getMessage());
        assertEquals(checksum, objectAttributesResponse.checksum().checksumCRC32());
                        S3Error.builder()
            List<S3Object> pageObjects = new ArrayList<>();
        if (useSseKms) {
        RuntimeException failure
            null
     * A lost CAS is fatal for a fenced writer, so retryable 409s such as {@code OperationAborted} must not be
            s3AsyncClient,
    }
    public void testListBlobsByPrefix() throws IOException {
                return response;
        when(blobStore.asyncClientReference()).thenReturn(amazonAsyncS3Reference);
        when(blobStore.bucket()).thenReturn(bucketName);
            final RequestBody requestBody = requestBodies.get(i);
     * version at all - deleted, or a delete marker. The version the caller presented provably no longer exists, so
        blobContainer.readBlobAsync(blobName, listener);
        final Tuple<Long, Long> result = S3BlobContainer.numberOfMultiparts(totalSize, partSize);
            assertThat(acl, equalTo(awsList));
        final String expectedToken = "\"" + UUID.randomUUID() + "\"";
            blobContainer.executeMultipartUpload(blobStore, blobName, new ByteArrayInputStream(new byte[0]), blobSize, null, null);
        logger.error("", exceptionRef.get());
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
import java.util.concurrent.atomic.AtomicBoolean;
        assertEquals(createMultipartUploadResponse.uploadId(), completeMultipartUploadRequest.uploadId());
        final S3Client client = mock(S3Client.class);
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
        BlobPath blobPath = mock(BlobPath.class);
        assertTrue("onResponse should have been called", onResponseCalled.get());
    public void testConditionalPathsTranslateSdkTransportFailuresToIOException() {
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        final boolean useBucketKey = randomBoolean();
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenAnswer(invocation -> {
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));
import org.opensearch.common.blobstore.stream.read.ReadContext;
        long objectSize
        assertNull(captor.getValue().ifNoneMatch());
                verify(client, times(1)).uploadPart(any(UploadPartRequest.class), any(RequestBody.class));
        assertEquals(inputStream.available(), inputStreamContainer.getInputStream().available());
        });
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        final String contentRange = "bytes 0-10/100";
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            CreateMultipartUploadRequest.class
        for (int i = 0; i < 100; i++) {
        public MockListObjectsV2ResponseIterator(
            Subscriber<? super ListObjectsV2Response> sub = invocation.getArgument(0);
        when(blobStore.bucket()).thenReturn(bucketName);
 * specific language governing permissions and limitations
                        subscriber.onComplete();
        blobContainer.deleteAsync(new ActionListener<>() {
            final AbortMultipartUploadRequest abortRequest = argumentCaptor.getValue();
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        private final boolean throwExceptionOnNextInvocation;
        }
        );
            subscriber.onSubscribe(new Subscription() {
        assertThat(e.getCause(), instanceOf(SdkException.class));
        }
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        final IllegalArgumentException e = expectThrows(
        private int responseCount;
        public int getResponseCount() {
        doAnswer(invocation -> {
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            s3AsyncClient,
            @Override
                    CompletableFuture.runAsync(
        assertTrue("Publisher should complete", publisherCompletedLatch.await(1, TimeUnit.SECONDS));
            assertEquals(bucketName, uploadPartRequest.bucket());
        );
                    }
        when(blobStore.bucket()).thenReturn(bucketName);
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
            getObjectAttributesResponseCompletableFuture
        assertFalse(e instanceof BlobVersionConflictException);
 * compatible open source license.
        when(blobStore.bufferSizeInBytes()).thenReturn(sizeBound);
        ResponseInputStream<GetObjectResponse> responseInputStream = new ResponseInputStream<>(getObjectResponse, inputStream);
        assertEquals("Simulated listing error", exceptionRef.get().getCause().getMessage());
        final IOException e = expectThrows(
            }
            });
            IllegalArgumentException.class,
            new ByteArrayInputStream(payload),
    public void testReadBlobWithVersionReturnsETagAsVersionToken() throws IOException {
                fail("Expected a failure, but got a success response");
        int expectedDeleteCalls = size / bulkDeleteSize + (size % bulkDeleteSize > 0 ? 1 : 0);
            ObjectCannedACL acl = S3BlobStore.initCannedACL(awsList.toString());
        assertEquals(1, readContextActionListener.getResponseCount());
            public void onFailure(Exception e) {
        assertThat(S3BlobStore.initStorageClass("onezone_ia"), equalTo(StorageClass.ONEZONE_IA));
        assertEquals(cannedAccessControlList, initRequest.acl());
                .uploadId(uploadId)
        CountingCompletionListener<ReadContext> readContextActionListener = new CountingCompletionListener<>();
        final IOException write = expectThrows(
        doAnswer(invocation -> {
        LatchedActionListener<ReadContext> listener = new LatchedActionListener<>(readContextActionListener, countDownLatch);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            IntStream.of(randomIntBetween(1, 5)).forEach(value -> blobPath.add("path_" + value));
import static org.mockito.Mockito.verify;
        );
        assertNumberOfMultiparts(1, size, size, size);
        when(blobPath.buildAsString()).thenReturn("/dummy/path");
@ThreadLeakFilters(filters = ResponseInputStreamTimeoutThreadFilter.class)
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
                public void cancel() {}
            public void onFailure(Exception e) {
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
    }
            GetObjectRequest getObjectRequest = GetObjectRequest.builder().bucket(bucketName).key(blobName).partNumber(partNumber).build();
    }
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            "bucket-owner-full-control" };
    private static S3Exception s3Exception(int statusCode, String errorCode) {
        assertEquals(blobPath.buildAsString() + blobName, request.key());
        BlobStoreException ex = expectThrows(BlobStoreException.class, () -> S3BlobStore.initStorageClass("glacier"));
        getObjectAttributesResponseCompletableFuture.complete(
        );
        // Mock the list operation to block indefinitely
    public void testDeleteBlobsIgnoringIfNotExistsWithInterruptedException() throws Exception {
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
    }
        assertEquals(1, readContextActionListener.getFailureCount());
            .collect(Collectors.toList());
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        );
        final BlobPath blobPath = new BlobPath();
import java.util.Map;
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        GetObjectResponse getObjectResponse = GetObjectResponse.builder().contentLength(contentLength).build();
            @Override
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        verify(s3AsyncClient, times(expectedDeleteCalls)).deleteObjects(any(DeleteObjectsRequest.class));
                public void cancel() {}
        public Exception getException() {
        // Calculate expected number of deleteObjects calls
            final CreateMultipartUploadResponse createMultipartUploadResponse = CreateMultipartUploadResponse.builder()
        final CreateMultipartUploadRequest initRequest = createMultipartUploadRequestArgumentCaptor.getValue();
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        assertEquals("Failed to list objects for deletion", e.getMessage());
        assertEquals("Expected number of parts [" + expectedParts + "] but got [" + result.v1() + "]", expectedParts, (long) result.v1());
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        assertEquals(simulatedFailure, exceptionRef.get().getCause());
import org.mockito.ArgumentCaptor;
        assertArrayEquals("an object of exactly the size bound must not be rejected", exactlyAtBound, blob.content());
                    subscriber.onError(new RuntimeException("Simulated listing error"));
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        do {
        });
                    List<String> keys = iterator.keysListed.stream()
        );
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        }
        }
        final InputStream inputStream = new ByteArrayInputStream(randomByteArrayOfLength(objectSize));
                assertArrayEquals(expectedBytes, actualBytes);
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
                .uploadId(uploadId)
                new ByteArrayInputStream(new byte[0]),
            IOException.class,
        assertEquals(0, readContextActionListener.getResponseCount());
                @Override
            when(blobStore.getCannedACL()).thenReturn(cannedAccessControlList);
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[0]);
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
import java.util.HashMap;
        final S3Client client = mock(S3Client.class);
                ByteSizeUnit.MB.toBytes(2),
        if (cannedAccessControlList != null) {
import static org.mockito.Mockito.doAnswer;
        final String expectedEncodedContext;
        expectThrows(
        final int factor = randomIntBetween(2, 10);
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
    public void testWriteBlobConditionallyDoesNotTreatOtherNotFoundAsLostCas() {
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        }
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
        assertEquals(blobNames.size(), totalBlobsDeleted);
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
    public void testReadBlobAsyncFailure() throws Exception {
        }
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(failedFuture);
        ResponseInputStream<GetObjectResponse> responseInputStream = new ResponseInputStream<>(getObjectResponse, inputStream);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
                final UploadPartResponse response = UploadPartResponse.builder().eTag(expectedEtags.get(request.partNumber() - 1)).build();
        final long remaining = randomIntBetween(1, (size > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) size - 1);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
                if (i % 2 == 0) {
        final AmazonAsyncS3Reference amazonAsyncS3Reference = new AmazonAsyncS3Reference(
        when(client.putObject(putReqCaptor.capture(), bodyCaptor.capture())).thenReturn(PutObjectResponse.builder().build());
        // Simulate a failure in listObjectsV2Paginator
        while (size < numObjects) {
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
                    subscriber.onNext(
            this.totalPageCount = totalPageCount;
import java.util.Arrays;
        });
        );
 */
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        final S3BlobContainer blobContainer = new S3BlobContainer(mock(BlobPath.class), blobStore);
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        when(s3AsyncClient.getObjectAttributes(any(GetObjectAttributesRequest.class))).thenReturn(
        for (int partNumber = 1; partNumber <= totalNumberOfParts; partNumber++) {
        when(blobStore.bufferSizeInBytes()).thenReturn(bufferSize);
            when(client.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(createMultipartUploadResponse);
        final S3BlobContainer blobContainer = conditionalWriteContainer(
        CountDownLatch countDownLatch = new CountDownLatch(1);
                byte[] actualBytes = is.readAllBytes();
            subscriber.onSubscribe(new Subscription() {
        assertEquals(storageClass, request.storageClass());
            invocationOnMock -> {
        );
            CompletableFuture<ResponseInputStream<GetObjectResponse>> getObjectPartResponse = new CompletableFuture<>();
            s3Exception(409, "ConditionalRequestConflict"),
                }
        assertEquals(0, readContextActionListener.getFailureCount());
    public void testExecuteMultipartUpload() throws IOException {
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(useBucketKey);
            public void onResponse(DeleteResult deleteResult) {
        metadata.put("key2", "value2");
        final IllegalArgumentException e = expectThrows(
        // The transfer is bounded by a ranged GET so an oversized object at this key cannot be buffered whole
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
}
            });
        );
        @Override
        blobContainer.deleteAsync(new ActionListener<>() {
        final ArgumentCaptor<CompleteMultipartUploadRequest> completeMultipartUploadRequestArgumentCaptor = ArgumentCaptor.forClass(
                ArgumentCaptor.forClass(PutObjectRequest.class),
        );
        }
                () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, "\"token\"")
            "fence",
            public void onResponse(Void aVoid) {
    public void testDelete() throws Exception {
        doAnswer(invocation -> {
        final S3Client client = mock(S3Client.class);
            getObjectPartResponse.complete(responseInputStream);
        }
            .build();
            s3AsyncClient,
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;
                    if (currentCounter == responseList.size()) {
    }
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
            final String contentRange = "bytes " + start + "-" + end + "/" + objectSize;
            ArgumentCaptor.forClass(PutObjectRequest.class),
     */
            when(client.completeMultipartUpload(any(CompleteMultipartUploadRequest.class))).thenThrow(exceptions.get(stage));
        int bulkDeleteSize = 5;
                        subscriber.onComplete();
                latch.countDown();
        }
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
    }
        }
        assertEquals("Future got interrupted", e.getMessage());
                .build()
            .get();
        }
            "bucket-owner-read",
            assertEquals(uploadId, abortRequest.uploadId());
        );
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        final int totalPageCount = 3;
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
        final S3Client client = mock(S3Client.class);
                public void request(long n) {
            s3AsyncClient,
        final BlobPath blobPath = new BlobPath();
        final boolean useSseKms = randomBoolean();
        assertNull("Unexpected exception: " + exceptionRef.get(), exceptionRef.get());
            DeleteObjectsRequest request = invocation.getArgument(0);
            testDeleteAsync(i + 1);
import org.opensearch.common.blobstore.DeleteResult;
            s3AsyncClient.getObject(
        latch.await();
        }
import org.opensearch.core.action.ActionListener;
            S3Exception.builder().statusCode(500).message("boom").build()
        assertEquals(bucketName, initRequest.bucket());
        final String kmsContext = randomAlphaOfLength(10);
     * pins both sides so neither a truncation nor an escape can be introduced silently.
        when(blobStore.bufferSizeInBytes()).thenReturn((long) bufferSize);
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
        } else {
        final S3BlobContainer blobContainer = new S3BlobContainer(mock(BlobPath.class), blobStore);
        assertThat(S3BlobStore.initStorageClass("sTandaRd"), equalTo(StorageClass.STANDARD));
        if (stage == 0) {
            }
        // empty acl
        final S3BlobStore blobStore = mock(S3BlobStore.class);
import java.util.Set;
                        )
        });
        CompletableFuture<DeleteObjectsResponse> failedFuture = new CompletableFuture<>();
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        assertEquals("Multipart upload request size [" + blobSize + "] can't be smaller than 5mb", e.getMessage());
        assertNotNull(exceptionRef.get());
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
                @Override
import software.amazon.awssdk.services.s3.model.GetObjectAttributesRequest;
                        subscriber.onNext(
        when(listObjectsV2Iterable.iterator()).thenReturn(iterator);
        CompletableFuture<DeleteObjectsResponse> failedFuture = new CompletableFuture<>();
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
            expectedEncodedContext = java.util.Base64.getEncoder()
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        assertEquals(exceptions.get(stage).getMessage(), e.getCause().getMessage());
                .build();
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
        assertEquals(metadata, initRequest.metadata());
                verify(client, times(1)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
import org.opensearch.test.OpenSearchTestCase;
        for (S3Exception error : retryable) {
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        testListBlobsByPrefixInLexicographicOrder(0, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
        when(blobStore.getStorageClass()).thenReturn(randomFrom(StorageClass.values()));
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
    }
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
                    if (currentCounter < responses.size()) {
            "private",
            return null;
            public void onFailure(Exception e) {
    }
                exceptionRef.set(e);
        ResponseInputStream<GetObjectResponse> responseInputStreamNoRangeSinglePart = new ResponseInputStream<>(
        final StorageClass storageClass = randomFrom(StorageClass.values());
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
            );
        when(client.createMultipartUpload(createMultipartUploadRequestArgumentCaptor.capture())).thenReturn(createMultipartUploadResponse);
        assertEquals(IOException.class, exceptionRef.get().getClass());
        verify(s3AsyncClient, times(1)).listObjectsV2Paginator(any(ListObjectsV2Request.class));
import java.util.Iterator;
        getObjectResponse = GetObjectResponse.builder().contentRange(contentRange).contentLength(contentLength).build();
        for (int i = 0; i < totalObjects; i++) {
        );
        assertEquals(Long.valueOf(objectSize), objectAttributesResponse.objectSize());
        private final AtomicInteger currInvocationCount = new AtomicInteger();
        final byte[] exactlyAtBound = randomByteArrayOfLength((int) sizeBound);
            assertEquals(bucketName, abortRequest.bucket());
        final int s3ObjectsPerPage = 5;
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        int expectedNumberofPagesFetched,
        });
            });
import java.util.concurrent.atomic.AtomicReference;
        CountDownLatch latch = new CountDownLatch(1);
            when(client.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenThrow(exceptions.get(stage));
    }
        blobContainer.deleteAsync(new ActionListener<>() {
        final long objectSize = 100L;
        public List<String> getKeysListed() {
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
            Thread.currentThread().interrupt();
        assertNotNull(exceptionRef.get());
import java.util.UUID;
        assertNotNull(exceptionRef.get().getCause());
                IOException.class,
        private int failureCount;
            sub.onSubscribe(new Subscription() {
        for (ObjectCannedACL awsList : ObjectCannedACL.values()) {
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        if (useSseKms) {
    public void testDeleteBlobsAsyncIgnoringIfNotExists() throws Exception {
        final List<SdkException> exceptions = Arrays.asList(
            @Override
    }
        IOException e = expectThrows(IOException.class, blobContainer::delete);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
     */
        if (randomBoolean()) {
        final List<String> blobNames = new ArrayList<>();
        when(blobStore.bucket()).thenReturn(bucketName);
                    @Override
        getObjectPartResponse.complete(responseInputStream);
            public void onFailure(Exception e) {
     * The 404 classification is scoped tightly: only {@code NoSuchKey} on an {@code If-Match} write is evidence about
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        verify(client, times(1)).headObject(any(HeadObjectRequest.class));
            return clientReference;
            CompleteMultipartUploadResponse.builder().build()
            assertEquals(i + 1, uploadPartRequest.partNumber().intValue());
                    if (currentCounter == responses.size() - 1) {
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
    public void testNumberOfMultiparts() {
            assertThrows(
        }
        // it should accept all aws cannedACLs
        DeleteResult result = resultRef.get();
        assertEquals(storageClass, initRequest.storageClass());
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
                        subscriber.onNext(ListObjectsV2Response.builder().contents(s3Objects).build());
                .objectParts(GetObjectAttributesParts.builder().totalPartsCount(objectPartCount).build())
        for (int partNumber = 1; partNumber < objectPartCount; partNumber++) {
        assertThat(S3BlobStore.initStorageClass("standard_ia"), equalTo(StorageClass.STANDARD_IA));
            @Override
        final ArgumentCaptor<AbortMultipartUploadRequest> argumentCaptor = ArgumentCaptor.forClass(AbortMultipartUploadRequest.class);
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
                ArgumentMatchers.<AsyncResponseTransformer<GetObjectResponse, ResponseInputStream<GetObjectResponse>>>any()
            final CreateMultipartUploadResponse createMultipartUploadResponse = CreateMultipartUploadResponse.builder()
                @Override
        doAnswer(invocation -> {
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        when(blobStore.bucket()).thenReturn(bucketName);
        long totalSize = 0;
    }
                fail("Expected failure but got success");
            false
            );
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        public ListObjectsV2Response next() {
        CompletableFuture<DeleteObjectsResponse> failedFuture = new CompletableFuture<>();
                }
            ResponseBytes.fromByteArray(GetObjectResponse.builder().eTag("\"etag\"").build(), randomByteArrayOfLength((int) sizeBound + 1))
        final String newETag = "\"" + UUID.randomUUID() + "\"";
    }
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(kmsKeyId);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            // an unlabelled 409 is not evidence that the precondition failed
                            .code("InternalError")
        for (int i = 0; i < uploadRequests.size(); i++) {
        String bucketName,
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        }
                fail("Expected a failure, but got a success response");
            });
        // Mock deleteObjects to block indefinitely
            s3Exception(409, "PreconditionFailed") };
            assertEquals(ServerSideEncryption.AES256, initRequest.serverSideEncryption());
        when(blobStore.bucket()).thenReturn(bucketName);
    public void testReadBlobAsyncMultiPart() throws Exception {
        assertEquals("Multipart upload request size [" + blobSize + "] can't be larger than 5tb", e.getMessage());
            if (stage == 1) {
            .stream()
        final InputStream inputStream = ResponseInputStream.nullInputStream();
                    int currentCounter = counter.getAndIncrement();
                public void onFailure(Exception e) {
    }
                onResponseCalled.set(true);
    private S3BlobContainer conditionalWriteContainer(
                exceptionRef.set(e);
        when(blobStore.asyncClientReference()).thenThrow(simulatedFailure);
    }
        final ArgumentCaptor<PutObjectRequest> captor = ArgumentCaptor.forClass(PutObjectRequest.class);
            s3Objects.add(S3Object.builder().key("key-" + i).size(100L).build());
                        );
            .map(CompletedPart::eTag)
            }
                        subscriber.onComplete();
        assertNull("No exception should have been thrown", exceptionRef.get());
import org.opensearch.common.blobstore.BlobPath;
            return currInvocationCount.get() < totalPageCount;
        );
    }
                    done = true;
        countDownLatch.await();
        final String uploadId = randomAlphaOfLength(25);
            // Calculate expected Base64-encoded result
        // it should accept [standard, standard_ia, onezone_ia, reduced_redundancy, intelligent_tiering]
        assertEquals(eTag, token);
                exceptionRef.set(e);
                    if (onNext.compareAndSet(false, true)) {
        assertEquals(keys, listOfBlobs.keySet());
        assertEquals(Integer.valueOf(objectPartCount), objectAttributesResponse.objectParts().totalPartsCount());
        final long objectSize = 100L;
        final MockListObjectsV2ResponseIterator iterator = new MockListObjectsV2ResponseIterator(2, 5, 100, blobPath.buildAsString());
            return CompletableFuture.completedFuture(DeleteObjectsResponse.builder().errors(errors).deleted(deletedObjects).build());
                public void cancel() {}
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
        when(s3AsyncClient.getObjectAttributes(any(GetObjectAttributesRequest.class))).thenReturn(
        final BlobPath blobPath = new BlobPath();
        assertTrue(latch.await(5, TimeUnit.SECONDS));
 * not use this file except in compliance with the License.
        metadata.put("key2", "value2");
        final S3Exception[] retryable = new S3Exception[] {
            CompletableFuture.completedFuture(DeleteObjectsResponse.builder().build())
            responseCount++;
        final BlobPath blobPath = new BlobPath();
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final String kmsKeyId = randomAlphaOfLength(10);
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(payload);
            null,
    }
                    assertEquals(expectedNumberofPagesFetched, iterator.numberOfPagesFetched());
                latch.countDown();
            ResponseBytes.fromByteArray(GetObjectResponse.builder().eTag("\"etag\"").build(), exactlyAtBound)
        verify(s3AsyncClient, times(1)).listObjectsV2Paginator(any(ListObjectsV2Request.class));
        // Pass the known-length stream + tell the code the exact size
            subscriber.onSubscribe(new Subscription() {
/*
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(kmsKeyId);
            @Override
            }
        }
                        subscriber.onComplete();
    private static void assertNumberOfMultiparts(final int expectedParts, final long expectedRemaining, long totalSize, long partSize) {
    private void testDeleteAsync(int bulkDeleteSize) throws InterruptedException {
        assertEquals(bucketName, request.bucket());
            .message(errorCode)
            assertEquals(useBucketKey, request.bucketKeyEnabled());
            subscriber.onSubscribe(new Subscription() {
            responseInputStreamNoRangeSinglePart,
     */
        when(blobStore.bucket()).thenReturn(bucketName);
        assertEquals(numObjects, deleteResult.blobsDeleted());
    }
            assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());
        }
        BlobStoreException ex = expectThrows(BlobStoreException.class, () -> S3BlobStore.initCannedACL("test_invalid"));
                @Override
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(neverCompletingFuture);
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
        final int stage = randomInt(2);
        assertTrue(latch.await(5, TimeUnit.SECONDS));
            final IOException e = expectThrows(
import software.amazon.awssdk.services.s3.model.DeleteObjectsRequest;
                .contentLength((long) partSize)
        );
        );
            final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
                public void request(long n) {
        });
        assertEquals("Delete operation timed out after 30 seconds", ex.getMessage());
        }
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            () -> S3BlobContainer.numberOfMultiparts(randomNonNegativeLong(), 0L)
        CompletableFuture<GetObjectAttributesResponse> getObjectAttributesResponseCompletableFuture = new CompletableFuture<>();
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        AtomicReference<DeleteResult> deleteResultRef = new AtomicReference<>();
        final BlobPath blobPath = new BlobPath();
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(
            s3AsyncClient,
    }
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));
    public void testConditionalWriteSupported() {
            ObjectCannedACL acl = S3BlobStore.initCannedACL(aclString);
            for (int i = 0; i < totalPageCount * s3ObjectsPerPage; i++) {
            responseList.add(ListObjectsV2Response.builder().contents(s3Objects.subList(size, endIndex)).build());
        final BlobPath blobPath = new BlobPath();
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
        CompletableFuture<GetObjectAttributesResponse> responseFuture = blobContainer.getBlobMetadata(s3AsyncClient, bucketName, blobName);
            @Override
            ResponseBytes.fromByteArray(GetObjectResponse.builder().eTag(eTag).build(), payload)
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
                    );
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(failedFuture);
        final S3Client client = mock(S3Client.class);
            // Fail the upload part request
        final boolean useBucketKey = randomBoolean();
        private final long s3ObjectSize;
                    eq(getObjectRequest),
        countDownLatch.await();
            // Fail the completion request
    public void testListBlobsByPrefixInLexicographicOrderWithLimitGreaterThanPageSize() throws IOException {
                    deletedObjects.add(DeletedObject.builder().key(request.delete().objects().get(i).key()).build());
        countDownLatch.await();
        assertEquals(IOException.class, exceptionRef.get().getClass());
            this(totalPageCount, s3ObjectsPerPage, s3ObjectSize, "");
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        latch.await();
        final CompleteMultipartUploadRequest completeMultipartUploadRequest = completeMultipartUploadRequestArgumentCaptor.getValue();
        final IllegalArgumentException e = expectThrows(
        testListBlobsByPrefixInLexicographicOrder(2, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
        latch.await();
            when(client.uploadPart(any(UploadPartRequest.class), any(RequestBody.class))).thenAnswer(invocationOnMock -> {
        final long blobSize = ByteSizeUnit.TB.toBytes(randomIntBetween(6, 10));
            return null;
            expectThrows(
            null
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
            s3Exception(404, "NoSuchKey")
        );
            AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null)
        assertEquals(totalObjects, result.blobsDeleted());
            null
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
            assertFalse("[" + error + "] must not be reported as a lost CAS", e instanceof BlobVersionConflictException);
        getObjectAttributesResponseCompletableFuture.complete(
        int expectedDeleteCalls = (int) Math.ceil((double) allObjects.size() / bulkDeleteSize);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        GetObjectRequest getObjectRequest = GetObjectRequest.builder().bucket(bucketName).key(blobName).build();
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        // Read back what the SDK will send and compare to the original payload
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
        // No exception when range and length both are present
            try (InputStream is = requestBody.contentStreamProvider().newStream()) {
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            )
        assertThat(S3BlobStore.initStorageClass("standard"), equalTo(StorageClass.STANDARD));
            () -> blobContainer.executeSingleUpload(
            // S3 lists keys in lexicographic order
            .stream()
            s3Exception(404, "NoSuchKey")
        }
        // Fits in N parts plus a bit more
        final long bufferSize = ByteSizeUnit.MB.toBytes(randomIntBetween(5, 1024));
                public void cancel() {
        verify(s3AsyncClient, times(1)).listObjectsV2Paginator(any(ListObjectsV2Request.class));
