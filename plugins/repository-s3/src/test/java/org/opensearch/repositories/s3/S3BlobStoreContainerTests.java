        assertEquals(0, inputStreamContainer.getOffset());  
        final boolean useSseKms = randomBoolean();
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
        }
        }  
        final BlobPath blobPath = new BlobPath();
                public void cancel() {}  
            s3AsyncClient,
            final String contentRange = "bytes " + start + "-" + end + "/" + objectSize;  
                .contentRange(contentRange)
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
        }
                blobStore,
    }  
            long size = randomIntBetween(1, 100);
        when(blobStore.clientReference()).thenReturn(clientReference);
        when(blobStore.bucket()).thenReturn(bucketName);
        assertNull(exceptionRef.get());
            public void onFailure(Exception e) {  
                .uploadId(uploadId)
                    public void onFailure(Exception e) {}
        // No exception when content range absent for single part object
        doAnswer(invocation -> {
import org.opensearch.common.blobstore.BlobVersionConflictException;  
                @Override
        when(
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
            responses.add(ListObjectsV2Response.builder().contents(pageObjects).build());  
    public void testWriteBlobConditionallyRejectsOversizedPayload() {
        CompletableFuture<ResponseInputStream<GetObjectResponse>> getObjectPartResponse = new CompletableFuture<>();
        BlobPath blobPath = mock(BlobPath.class);
            ArgumentCaptor.forClass(PutObjectRequest.class),
        final List<String> actualETags = completeMultipartUploadRequest.multipartUpload()
            CompleteMultipartUploadResponse.builder().build()  
        assertThat(S3BlobStore.initStorageClass("intelligent_tiering"), equalTo(StorageClass.INTELLIGENT_TIERING));  
    }
        when(blobStore.bucket()).thenReturn(bucketName);
        // Read back what the SDK will send and compare to the original payload
        when(blobStore.bucket()).thenReturn(bucketName);  
        );
        // Build the payload first so we know/keep its exact length
                public void cancel() {}
        final S3Client client = mock(S3Client.class);  
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
import software.amazon.awssdk.services.s3.model.ObjectIdentifier;  
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());  
        final long sizeBound = randomIntBetween(1, 512);  
                return response;
        final long blobSize = ByteSizeUnit.TB.toBytes(randomIntBetween(6, 10));
                    String s3ObjectKey = keysListed.get((currInvocationCount.get() - 1) * s3ObjectsPerPage + i);  
        GetObjectResponse getObjectResponse = GetObjectResponse.builder().contentLength((long) objectSize).build();
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(kmsContext);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();  
        } else {  
            List<DeletedObject> deletedObjects = new ArrayList<>();
        when(blobStore.bucket()).thenReturn(bucketName);
            return null;
                public void cancel() {}
        verify(s3AsyncClient, times(expectedDeleteCalls)).deleteObjects(deleteRequestCaptor.capture());
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        assertTrue(deletedKeys.containsAll(blobNames));
import software.amazon.awssdk.services.s3.model.UploadPartResponse;  
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        assertTrue(new S3BlobContainer(new BlobPath(), mock(S3BlobStore.class)).isConditionalWriteSupported());
        );
        final String kmsContext = randomAlphaOfLength(10);
        for (int i = 0; i < 100; i++) {
                    keys.sort(keysComparator);
        assertFalse(e instanceof BlobVersionConflictException);  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        assertThrows(BlobStoreException.class, () -> blobContainer.blobExists(blobName));  
            s3Exception(404, "NoSuchKey")
        final String bucketName = randomAlphaOfLengthBetween(1, 10);  
    public void testReadBlobAsyncSinglePart() throws Exception {
        when(client.putObject(putReqCaptor.capture(), bodyCaptor.capture())).thenReturn(PutObjectResponse.builder().build());
        assertEquals(createMultipartUploadResponse.uploadId(), completeMultipartUploadRequest.uploadId());
                        () -> sub.onNext(  
            SdkException.builder().message("no route").build()
            null
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
            assertEquals(useBucketKey, request.bucketKeyEnabled());  
            s3AsyncClient,
            .message(errorCode)
                public void cancel() {}  
                fail("Expected a failure, but got a success response");
            }
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
        final int partSize = 10;
import java.nio.file.NoSuchFileException;
            assertFalse("[" + error + "] must not be reported as a lost CAS", e instanceof BlobVersionConflictException);
        getObjectAttributesResponseCompletableFuture.complete(  
            null  
        );  
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
            subscriber.onSubscribe(new Subscription() {
            @Override  
        Set<String> keys = iterator.keysListed.stream()
            public void onResponse(DeleteResult deleteResult) {
        }
                exceptionRef.set(e);
        });
        ResponseInputStream<GetObjectResponse> responseInputStreamNoContentLength = new ResponseInputStream<>(
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());  
            s3AsyncClient,  
            subscriber.onSubscribe(new Subscription() {  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);  
                @Override
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
            when(client.putObject(captor.capture(), any(RequestBody.class))).thenThrow(failure);
     */
                    }
        assertThat(S3BlobStore.initStorageClass("standard_ia"), equalTo(StorageClass.STANDARD_IA));  
        );
                    subscriber.onNext(  
import java.util.UUID;  
                public void cancel() {}
        final S3Client client = mock(S3Client.class);
        assertEquals(newETag, token);  
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
            verify(client, times(0)).uploadPart(any(UploadPartRequest.class), any(RequestBody.class));  
        verify(s3AsyncClient, times(1)).deleteObjects(any(DeleteObjectsRequest.class));
        if (cannedAccessControlList != null) {
    ) {
                List<S3Object> s3Objects = new ArrayList<>();
        when(blobStore.getBulkDeletesSize()).thenReturn(5);
        AtomicReference<DeleteResult> resultRef = new AtomicReference<>();  
            @Override  
                latch.countDown();
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
    }
            List<S3Object> pageObjects = new ArrayList<>();  
        countDownLatch.await();
                latch.countDown();  
        when(blobPath.buildAsString()).thenReturn("/dummy/path");
                }
        testListBlobsByPrefixInLexicographicOrder(12, 2, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
 * Licensed to Elasticsearch under one or more contributor  
        expectThrows(
        } else {
        final String blobName = randomAlphaOfLengthBetween(1, 10);  
            getObjectAttributesResponseCompletableFuture
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
        assertEquals(objectPartCount, readContext.getNumberOfParts());
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
                .encodeToString(kmsContext.getBytes(java.nio.charset.StandardCharsets.UTF_8));
    }
                deleteResultRef.set(deleteResult);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
    private static S3Exception s3Exception(int statusCode, String errorCode) {  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        countDownLatch.await();  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
        testListBlobsByPrefixInLexicographicOrder(8, 2, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);  
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
        long totalSize = 0;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;  
            .build();
            public void onResponse(DeleteResult deleteResult) {
        assertEquals("Simulated delete error", exceptionRef.get().getCause().getMessage());
                latch.countDown();
        // Pass the known-length stream + tell the code the exact size
        final ArgumentCaptor<PutObjectRequest> captor = ArgumentCaptor.forClass(PutObjectRequest.class);
    }  
        for (S3Exception conflict : conflicts) {
                    errors.add(  
            totalSize += size;  
            inputStream
        CountDownLatch latch = new CountDownLatch(1);  
            keysListed.sort(String::compareTo);
        final AmazonAsyncS3Reference amazonAsyncS3Reference = new AmazonAsyncS3Reference(  
        final long blobSize = ByteSizeUnit.GB.toBytes(randomIntBetween(6, 10));
            assertEquals(bucketName, uploadPartRequest.bucket());  
        if (failure != null) {
            }  
                .encodeToString(kmsContext.getBytes(java.nio.charset.StandardCharsets.UTF_8));
        if (useSseKms) {  
        doAnswer(invocation -> {
            return clientReference;
                .build()  
        latch.await();  
            assertEquals(kmsKeyId, request.ssekmsKeyId());
            s3Exception(409, "ConditionalRequestConflict"),
            SdkException.create("Expected completion request to fail", new RuntimeException())
            s3AsyncClient.getObject(
            }  
        assertEquals(contentLength, inputStreamContainer.getContentLength());
import java.util.Iterator;
        final S3Client client = mock(S3Client.class);
     * infrastructure error and stays retryable, and a create-if-absent ({@code If-None-Match: *}) never 404s on the
            return responseCount;  
            () -> S3BlobContainer.numberOfMultiparts(randomNonNegativeLong(), 0L)  
        long totalSize = 0;  
        LatchedActionListener<ReadContext> listener = new LatchedActionListener<>(readContextActionListener, countDownLatch);
            IllegalArgumentException.class,
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Publisher;
            }
        public Exception getException() {
        assertTrue("onResponse should have been called", onResponseCalled.get());
            final CreateMultipartUploadResponse createMultipartUploadResponse = CreateMultipartUploadResponse.builder()
    public void testWriteBlobConditionallyPropagatesOtherS3Errors() {
        final VersionedBlob blob = new S3BlobContainer(new BlobPath(), blobStore).readBlobWithVersion(blobName);
import software.amazon.awssdk.services.s3.model.GetObjectAttributesRequest;
     */
            public void onFailure(Exception e) {
    public void testListBlobsByPrefixInLexicographicOrderWithLimitEqualToPageSize() throws IOException {
            assertEquals(bucketName, abortRequest.bucket());  
        CompletableFuture<DeleteObjectsResponse> neverCompletingFuture = new CompletableFuture<>();
        }  
            this.s3ObjectSize = s3ObjectSize;
            s3AsyncClient,
     * unnecessary calls are not made to S3 by fetching the next page.
        LatchedActionListener<ReadContext> listener = new LatchedActionListener<>(readContextActionListener, countDownLatch);
        final S3BlobContainer blobContainer = conditionalWriteContainer(captor, PutObjectResponse.builder().eTag(newETag).build(), null);  
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(payload);
            if (throwExceptionOnNextInvocation) {  
        private int failureCount;
        final ArgumentCaptor<GetObjectRequest> captor = ArgumentCaptor.forClass(GetObjectRequest.class);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
    }  
    }  
    }
        } else {
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        assertEquals(expectedEtags, actualETags);  
            final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        when(blobStore.getStorageClass()).thenReturn(randomFrom(StorageClass.values()));
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        AtomicReference<DeleteResult> resultRef = new AtomicReference<>();
        int bulkDeleteSize = randomIntBetween(1, 10);
        final boolean useSseKms = randomBoolean();
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        final int factor = randomIntBetween(2, 10);
    }
            return response;
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        final RequestBody requestBody = bodyCaptor.getValue();
                    int actualLimit = Math.max(0, Math.min(limit, 10));  
        final S3Client client = mock(S3Client.class);  
        when(blobStore.bucket()).thenReturn(bucketName);
    }
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
        when(blobStore.bufferSizeInBytes()).thenReturn((long) bufferSize);
            .build();
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
                        );
        private final int totalPageCount;  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            IllegalArgumentException.class,  
        final S3Exception[] conflicts = new S3Exception[] {  
        final BlobPath blobPath = new BlobPath();
            } else {
        }
        when(s3AsyncClient.getObjectAttributes(any(GetObjectAttributesRequest.class))).thenReturn(
        when(blobStore.bucket()).thenReturn(bucketName);
            // Calculate expected Base64-encoded result
    public void testDeleteTimeoutWithNeverCompletingAsyncDeletionFuture() throws Exception {
import org.opensearch.common.blobstore.VersionedBlob;
        int bulkDeleteSize = 5;  
        int totalNumberOfParts,
        });
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
import software.amazon.awssdk.services.s3.model.DeletedObject;  
}  
            new ByteArrayInputStream(payload),
        });
            return keysListed;  
        assertNotNull(exceptionRef.get());  
            }
    public void testInvalidCannedACL() {  
        assertEquals(storageClass, initRequest.storageClass());
        final S3BlobContainer blobContainer = new S3BlobContainer(mock(BlobPath.class), blobStore);  
            when(blobStore.getCannedACL()).thenReturn(cannedAccessControlList);
            CompletableFuture.completedFuture(DeleteObjectsResponse.builder().build())  
    }  
        assertTrue("Publisher should complete", publisherCompletedLatch.await(1, TimeUnit.SECONDS));
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);  
        }
            }
        );
        when(blobStore.bucket()).thenReturn(bucketName);  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
     * version at all - deleted, or a delete marker. The version the caller presented provably no longer exists, so
        assertEquals("Failed to list objects for deletion", exceptionRef.get().getMessage());  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        for (int i = 0; i < size; i++) {  
import static org.mockito.Mockito.when;
        }).when(blobStore).clientReference();  
    public void testBlobExistsNoSuchKeyException() {
        assertNumberOfMultiparts(1, 0L, 0L, size);
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(kmsKeyId);
            inputStream  
            .flatMap(r -> r.delete().objects().stream())
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();  
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        assertFalse(blobContainer.blobExists(blobName));  
            responseList.add(ListObjectsV2Response.builder().contents(s3Objects.subList(size, endIndex)).build());
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(kmsContext);
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
            return null;
        getObjectAttributesResponseCompletableFuture.complete(  
     * the precondition. A 404 without that code (e.g. {@code NoSuchBucket}, or an unlabelled response) is an
 * Unless required by applicable law or agreed to in writing,
                            .code("InternalError")  
        public MockListObjectsV2ResponseIterator(int totalPageCount, int s3ObjectsPerPage, long s3ObjectSize, String blobPath) {  
        final S3BlobContainer blobContainer = conditionalWriteContainer(  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(kmsKeyId);
    }
    }
                    );  
        public List<String> getKeysListed() {
    }
        assertEquals("Failed to list objects for deletion", e.getMessage());
 * license agreements. See the NOTICE file distributed with
     * object itself, so a 404 there is never a lost CAS.  
    public void testDeleteWithInterruptedException() throws Exception {
    }
            AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null)
    }
            final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
            @Override
        assertEquals("Failed to initiate async blob deletion", exceptionRef.get().getMessage());
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);  
                    if (!hasEmittedItem.getAndSet(true)) {
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
 * compatible open source license.
        when(blobStore.bucket()).thenReturn(bucketName);
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
                }
            getObjectResponse,
            verify(client, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
        assertEquals(1, readContextActionListener.getResponseCount());
    public void testDeleteBlobsIgnoringIfNotExistsWithExecutionException() throws Exception {
        when(blobStore.expectedBucketOwner()).thenReturn(null);
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
                    s3Objects.add(S3Object.builder().key(s3ObjectKey).size(s3ObjectSize).build());
        final long blobSize = ByteSizeUnit.GB.toBytes(randomIntBetween(1, 128));
        );  
        ResponseInputStream<GetObjectResponse> responseInputStream = new ResponseInputStream<>(getObjectResponse, inputStream);
            for (int i = 0; i < request.delete().objects().size(); i++) {
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
        final long blobSize = ByteSizeUnit.MB.toBytes(2);  
                @Override
        final boolean useBucketKey = randomBoolean();
            exception = e;
import org.opensearch.common.blobstore.BlobPath;
    public void testExecuteSingleUploadBlobSizeTooLarge() {  
                            ListObjectsV2Response.builder().contents(S3Object.builder().key("test-key").size(100L).build()).build()
        }
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
        final Tuple<Long, Long> result = S3BlobContainer.numberOfMultiparts(totalSize, partSize);
        when(client.abortMultipartUpload(argumentCaptor.capture())).thenReturn(AbortMultipartUploadResponse.builder().build());
    }  
        CountDownLatch latch = new CountDownLatch(1);
                                .build()  
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        }  
            GetObjectRequest getObjectRequest = GetObjectRequest.builder().bucket(bucketName).key(blobName).partNumber(partNumber).build();  
        doAnswer(invocation -> {  
    /**
        // Explicit content length must be set on the request
        assertThat(S3BlobStore.initStorageClass("sTandaRd"), equalTo(StorageClass.STANDARD));
        final long blobSize = ByteSizeUnit.MB.toBytes(765);
                    subscriber.onComplete();  
        );  
        when(blobStore.bucket()).thenReturn(bucketName);
            }
            return null;
        if (useSseKms) {
import java.util.Map;  
            }  
        failedFuture.completeExceptionally(new RuntimeException("Simulated delete error"));  
        assertNotNull(exceptionRef.get());
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(useBucketKey);  
                latch.countDown();
            assertEquals(uploadId, abortRequest.uploadId());
            return failureCount;
            assertEquals(blobPath.buildAsString() + blobName, uploadPartRequest.key());
        final String contentRange = "bytes 0-10/100";
            }
    public void testReadBlobWithVersionAcceptsBlobExactlyAtSizeBound() throws IOException {  
            verify(client, times(1)).createMultipartUpload(any(CreateMultipartUploadRequest.class));
        CountDownLatch latch = new CountDownLatch(1);
        // Calculate expected number of deleteObjects calls
                @Override
        ) {
            // Fail the completion request  
    }
        final IllegalArgumentException e = expectThrows(
package org.opensearch.repositories.s3;
        final String blobName = randomAlphaOfLengthBetween(1, 10);  
        assertNumberOfMultiparts(1, size, size, size * factor);  
 * KIND, either express or implied.  See the License for the
        assertArrayEquals(payload, blob.content());
        assertEquals(metadata, request.metadata());
            when(client.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(createMultipartUploadResponse);
            blobContainer.executeMultipartUpload(blobStore, blobName, new ByteArrayInputStream(new byte[0]), blobSize, null, null);  
            s3AsyncClient,
            s3AsyncClient,
        final ArgumentCaptor<RequestBody> bodyCaptor = ArgumentCaptor.forClass(RequestBody.class);
        when(client.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listObjectsV2Iterable);  
import java.util.Comparator;
        assertNull("No exception should have been thrown", exceptionRef.get());  
        when(s3AsyncClient.getObjectAttributes(any(GetObjectAttributesRequest.class))).thenThrow(new RuntimeException());
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));  
     * accepted. HTTP byte ranges are inclusive, so {@code bytes=0-N} asks for N+1 bytes - one more than the limit,
        int expectedDeleteCalls = (int) Math.ceil((double) totalObjects / bulkDeleteSize);
 * this file be licensed under the Apache-2.0 license or a
        private final List<String> keysListed;
            return CompletableFuture.completedFuture(DeleteObjectsResponse.builder().errors(errors).deleted(deletedObjects).build());
            verify(client, times(1)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));  
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
            }  
        if (useSseKms) {
            return currInvocationCount.get();
        assertNull("Unexpected exception: " + exceptionRef.get(), exceptionRef.get());
        );  
import java.util.NoSuchElementException;
                                .contents(Collections.singletonList(S3Object.builder().key("test-key").size(100L).build()))
            verify(client, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));
    public void testReadBlobWithVersionOnMissingBlobThrowsNoSuchFile() {  
        CountDownLatch latch = new CountDownLatch(1);
        @Override
        if (useSseKms) {  
        }
        for (ObjectCannedACL awsList : ObjectCannedACL.values()) {  
        when(blobStore.bucket()).thenReturn(bucketName);  
 * Modifications Copyright OpenSearch Contributors. See
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);  
        final BlobPath blobPath = new BlobPath();
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenAnswer(invocation -> {
        when(client.headObject(any(HeadObjectRequest.class))).thenReturn(HeadObjectResponse.builder().build());
        assertTrue(Thread.interrupted()); // Clear interrupted state
            this(totalPageCount, s3ObjectsPerPage, s3ObjectSize, blobPath, false);
            assertEquals(partSize, inputStreamContainer.getInputStream().readAllBytes().length);
            }  
        verify(s3AsyncClient, times(1)).listObjectsV2Paginator(any(ListObjectsV2Request.class));  
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
        RuntimeException simulatedError = new RuntimeException("Simulated error");  
    public void testDeleteAsyncListingError() throws Exception {  
        final String kmsContext = randomAlphaOfLength(10);  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);  
        );
                IOException.class,
        );  
    public void testWriteBlobConditionallyDoesNotTreatOtherNotFoundAsLostCas() {
                    eq(getObjectRequest),
        assertEquals("Multipart upload request size [" + blobSize + "] can't be larger than 5tb", e.getMessage());  
                ArgumentMatchers.<AsyncResponseTransformer<GetObjectResponse, ResponseInputStream<GetObjectResponse>>>any()
            .map(r -> r.delete().objects().size())
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
    }  
        final String checksum = randomAlphaOfLength(10);  
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);  
        latch.await();  
                        subscriber.onNext(responseList.get(currentCounter));
            ObjectCannedACL acl = S3BlobStore.initCannedACL(aclString);
            try (InputStream is = requestBody.contentStreamProvider().newStream()) {
        } else if (stage == 1) {  
            s3AsyncClient,
    }
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
            }
        LatchedActionListener<ReadContext> listener = new LatchedActionListener<>(readContextActionListener, countDownLatch);
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        verify(s3AsyncClient, times(expectedDeletedObjectsCall)).deleteObjects(any(DeleteObjectsRequest.class));
            IOException.class,
@ThreadLeakFilters(filters = ResponseInputStreamTimeoutThreadFilter.class)  
     * like to a superseded writer, which must fence terminally instead of retrying forever. Matches
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        );  
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));  
        });
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        final BlobPath blobPath = new BlobPath();
        if (randomBoolean()) {
        final S3Client client = mock(S3Client.class);
        assertThrows(
        blobContainer.executeMultipartUpload(blobStore, blobName, inputStream, blobSize, metadata, null);
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
            final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));  
    }
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        BlobStoreException ex = expectThrows(BlobStoreException.class, () -> S3BlobStore.initCannedACL("test_invalid"));
        final Map<String, String> metadata = new HashMap<>();
        }
     * The other half of {@link #testReadBlobWithVersionRejectsOversizedBlob}: an object of exactly the bound is  
        if (randomBoolean()) {  
        when(blobStore.bucket()).thenReturn(bucketName);
            final UploadPartRequest uploadPartRequest = uploadRequests.get(i);  
        }
                @Override
                ArgumentCaptor.forClass(PutObjectRequest.class),
            s3Exception(409, "PreconditionFailed") };
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
            int endIndex = Math.min(numObjects, size + toAdd);
        blobContainer.deleteAsync(new ActionListener<>() {
    }
import java.util.concurrent.CountDownLatch;  
                .objectSize((long) objectSize)
        final ByteArrayInputStream inputStream = new ByteArrayInputStream(new byte[0]);  
        PutObjectResponse response,
        final IllegalArgumentException e = expectThrows(
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
            final AbortMultipartUploadRequest abortRequest = argumentCaptor.getValue();
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
                    @Override
        blobContainer.deleteBlobsAsyncIgnoringIfNotExists(blobNames, new ActionListener<Void>() {
                }
                volatile boolean done;
            expectedToken  
            for (int i = 0; i < totalPageCount * s3ObjectsPerPage; i++) {
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());  
        );
        for (S3Exception error : retryable) {
            public void onFailure(Exception e) {  
    }
        assertEquals(blobNames.size(), totalBlobsDeleted);
                    if (done || n <= 0) return;  
            @Override
        assertThat(S3BlobStore.initStorageClass(""), equalTo(StorageClass.STANDARD));
            public void onResponse(Void aVoid) {
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
                fail("Unexpected failure: " + e.getMessage());  
        final ByteSizeUnit unit = randomFrom(ByteSizeUnit.BYTES, ByteSizeUnit.KB, ByteSizeUnit.MB, ByteSizeUnit.GB);  
        final long objectSize = 100L;  
            totalBytes += partSize;  
        when(client.headObject(any(HeadObjectRequest.class))).thenThrow(new RuntimeException());
import software.amazon.awssdk.services.s3.model.S3Exception;
                    Comparator<String> keysComparator = String::compareTo;  
        String blobName,
            public void onFailure(Exception e) {
        final S3BlobContainer blobContainer = new S3BlobContainer(new BlobPath(), blobStore);  
        blobContainer.deleteAsync(new ActionListener<>() {  
            verify(client, times(0)).abortMultipartUpload(any(AbortMultipartUploadRequest.class));
        String[] aclList = new String[] {
        int limit,
            }
            }  
        final IllegalArgumentException e = expectThrows(
import java.io.IOException;
import static org.mockito.ArgumentMatchers.eq;
        );
            final CreateMultipartUploadResponse createMultipartUploadResponse = CreateMultipartUploadResponse.builder()
import static org.mockito.ArgumentMatchers.any;  
        final List<UploadPartRequest> uploadRequests = uploadPartRequestArgumentCaptor.getAllValues();
        );
        when(blobStore.getStorageClass()).thenReturn(randomFrom(StorageClass.values()));
        assertEquals(inputStream.available(), inputStreamContainer.getInputStream().available());  
            s3Exception(404, "NoSuchKey")  
import software.amazon.awssdk.services.s3.model.Checksum;
        assertEquals(inputStream.available(), inputStreamContainer.getInputStream().available());
                () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, "\"token\"")  
                verify(client, times(1)).uploadPart(any(UploadPartRequest.class), any(RequestBody.class));
        final String blobName = randomAlphaOfLengthBetween(1, 10);  
        assertThat(ex.getMessage(), equalTo("Glacier storage class is not supported"));  
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
            @Override
    public void testExecuteMultipartUploadBlobSizeTooLarge() {  
            return exception;  
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());  
    }  
        when(blobStore.bucket()).thenReturn(bucketName);  
        when(client.uploadPart(uploadPartRequestArgumentCaptor.capture(), requestBodyArgumentCaptor.capture())).thenAnswer(  
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(kmsKeyId);  
        when(blobStore.bufferSizeInBytes()).thenReturn(sizeBound);
        final String eTag = "\"" + UUID.randomUUID() + "\"";
     */  
        }
        final StorageClass storageClass = randomFrom(StorageClass.values());
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));  
    }
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
        return new S3BlobContainer(new BlobPath(), blobStore);
        for (S3Exception error : retryable) {
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
        final List<S3Object> s3Objects = new ArrayList<>();  
        when(blobStore.bucket()).thenReturn(bucketName);  
    }
        // Create a future that never completes  
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
            final IOException e = expectThrows(
            when(blobStore.getCannedACL()).thenReturn(cannedAccessControlList);
                    ).thenRun(sub::onComplete);  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
        }
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());  
import java.util.concurrent.TimeUnit;
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        final int objectPartCount = 10;
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);  
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));  
            final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        final S3BlobContainer blobContainer = new S3BlobContainer(new BlobPath(), blobStore);
                    CompletableFuture.runAsync(
    public void testReadBlobWithVersionRejectsOversizedBlob() {
    }  
    }
        when(blobStore.bucket()).thenReturn(bucketName);
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        }
        });
            null,  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            getObjectPartResponse.complete(responseInputStream);
import software.amazon.awssdk.services.s3.model.S3Error;  
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        for (int i = 0; i < numObjects; i++) {  
import software.amazon.awssdk.services.s3.model.StorageClass;
        // Mock the list operation to block indefinitely
        CountDownLatch latch = new CountDownLatch(1);  
    public void testExecuteMultipartUploadAborted() {  
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
    public void testDeleteWithExecutionException() throws Exception {  
                latch.countDown();
            }  
    }  
            return null;  
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
        assertEquals(keys, listOfBlobs.keySet());
import java.util.List;
        // Create a publisher that emits one item and completes
        CompletableFuture<DeleteObjectsResponse> failedFuture = new CompletableFuture<>();
                    } else {  
            AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null)
            return null;
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(blobStore.clientReference()).thenReturn(clientReference);
                            ListObjectsV2Response.builder()
            });
            });
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
            }
                .objectParts(GetObjectAttributesParts.builder().totalPartsCount(objectPartCount).build())
 * specific language governing permissions and limitations
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        }
                exceptionRef.set(e);
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final BlobPath blobPath = new BlobPath();
                )  
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(  
        });
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
    }
                            .key(request.delete().objects().get(i).key())
            }  
        CountingCompletionListener<ReadContext> readContextActionListener = new CountingCompletionListener<>();  
        CompletableFuture<DeleteObjectsResponse> failedFuture = new CompletableFuture<>();
        ArgumentCaptor<DeleteObjectsRequest> deleteRequestCaptor = ArgumentCaptor.forClass(DeleteObjectsRequest.class);  
                .build();  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
                exceptionRef.set(e);
            subscriber.onSubscribe(new Subscription() {
import java.util.Set;
        } else {  
        InputStreamContainer inputStreamContainer = blobContainer.getBlobPartInputStreamContainer(s3AsyncClient, bucketName, blobName, 0)  
        );
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
                        subscriber.onComplete();
            s3AsyncClient.getObject(  
            @Override
        latch.await();
import org.opensearch.core.action.ActionListener;  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        latch.await();
        final String bucketName = randomAlphaOfLengthBetween(1, 10);  
        InputStreamContainer inputStreamContainer = S3BlobContainer.transformResponseToInputStreamContainer(
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(neverCompletingFuture);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());  
public class S3BlobStoreContainerTests extends OpenSearchTestCase {
            @Override  
            assertFalse("[" + error + "] must not be reported as a lost CAS", e instanceof BlobVersionConflictException);
                public void request(long n) {
            subscriber.onSubscribe(new Subscription() {  
/*  
import org.reactivestreams.Subscriber;
    }  
                exceptionRef.set(e);
            this.s3ObjectsPerPage = s3ObjectsPerPage;  
        );  
            null
        assertEquals(0, inputStreamContainer.getOffset());
        final String checksum = randomAlphaOfLength(10);
        assertEquals(0, inputStreamContainer.getOffset());  
        public int numberOfPagesFetched() {  
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
            .collect(Collectors.toSet());  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
        AtomicReference<DeleteResult> deleteResultRef = new AtomicReference<>();
        assertThat(S3BlobStore.initStorageClass("reduCED_redundancy"), equalTo(StorageClass.REDUCED_REDUNDANCY));
    public void testExecuteMultipartUploadBlobSizeTooSmall() {  
            .map(ObjectIdentifier::key)
 * You may obtain a copy of the License at  
        final long contentLength = 10L;  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        int partSize,  
            )  
        IOException ex = assertThrows(IOException.class, blobContainer::delete);  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
            .map(CompletedPart::eTag)
    }  
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
            public void onFailure(Exception e) {  
        );
            invocationOnMock -> {
        }  
        when(blobStore.getBulkDeletesSize()).thenReturn(bulkDeleteSize);  
        assertEquals("Multipart upload request size [" + blobSize + "] can't be smaller than 5mb", e.getMessage());  
    }  
import static org.mockito.Mockito.mock;  
                }  
        List<String> emptyBlobNames = Collections.emptyList();
                        subscriber.onComplete();
    }
    public void testListBlobsByPrefix() throws IOException {
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
                exceptionRef.set(e);  
            this(totalPageCount, s3ObjectsPerPage, s3ObjectSize, "");  
            payload.length,
        final Map<String, String> metadata = new HashMap<>();
import java.util.concurrent.CompletionException;
        assertEquals("Upload request size [2097152] can't be larger than buffer size", e.getMessage());  
        RuntimeException failure
            // Calculate expected Base64-encoded result  
        getObjectResponse = GetObjectResponse.builder().contentRange(contentRange).contentLength(contentLength).build();
                @Override
import static org.hamcrest.Matchers.instanceOf;
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));
            GetObjectAttributesResponse.builder()
    }
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());  
        }  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);  
/*
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);  
import software.amazon.awssdk.services.s3.model.DeleteObjectsResponse;
        final PutObjectRequest request = putReqCaptor.getValue();
        final int stage = randomInt(2);
        }  
        final S3Client client = mock(S3Client.class);  
            .statusCode(statusCode)
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
            this.totalPageCount = totalPageCount;
    public void testDeleteAsync() throws Exception {
                    if (currentCounter == responses.size() - 1) {
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));  
            throw new NoSuchElementException();
            null
        assertEquals("*", captor.getValue().ifNoneMatch());  
    }
            s3AsyncClient,
        List<String> blobNames = Arrays.asList("test1", "test2");
        final String expectedEncodedContext;  
                public void cancel() {
        final InputStream inputStream = new ByteArrayInputStream(randomByteArrayOfLength(objectSize));  
                .checksum(Checksum.builder().build())
    }  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
                        publisherCompletedLatch.countDown();
        }
            CompletableFuture<ResponseInputStream<GetObjectResponse>> getObjectPartResponse = new CompletableFuture<>();
            expectedEtags.add(randomAlphaOfLength(50));
                })  
        public int getResponseCount() {
            assertEquals(ServerSideEncryption.AWS_KMS, request.serverSideEncryption());  
        final BlobPath blobPath = new BlobPath();  
        CountDownLatch countDownLatch = new CountDownLatch(1);  
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);  
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        latch.await();
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
                fail("Expected failure but got success");
        for (int partNumber = 1; partNumber < objectPartCount; partNumber++) {
        blobContainer.deleteAsync(new ActionListener<>() {
        int expectedDeletedObjectsCall = numObjects / bulkDeleteSize + (numObjects % bulkDeleteSize > 0 ? 1 : 0);
        }
        final String blobName = randomAlphaOfLengthBetween(1, 10);  
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final S3Client client = mock(S3Client.class);
        assertEquals("bytes=0-" + sizeBound, captor.getValue().range());  
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
        final String expectedEncodedContext;
        final CreateMultipartUploadRequest initRequest = createMultipartUploadRequestArgumentCaptor.getValue();
        when(s3AsyncClient.getObjectAttributes(any(GetObjectAttributesRequest.class))).thenReturn(  
    public void testGetBlobMetadata() throws Exception {
        // No exception when range and length both are present
            assertEquals(blobName, abortRequest.key());
        when(blobStore.bufferSizeInBytes()).thenReturn(bufferSize);
        final StorageClass storageClass = randomFrom(StorageClass.values());  
            @Override
        AtomicInteger deleteCallCount = new AtomicInteger(0);
                public void request(long n) {
        assertEquals("Expected number of parts [" + expectedParts + "] but got [" + result.v1() + "]", expectedParts, (long) result.v1());  
                    @Override
        CompletableFuture<GetObjectAttributesResponse> responseFuture = blobContainer.getBlobMetadata(s3AsyncClient, bucketName, blobName);
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
        final S3BlobContainer blobContainer = new S3BlobContainer(mock(BlobPath.class), blobStore);  
        final BlobPath blobPath = new BlobPath();
        final int blobSize = randomIntBetween(0, bufferSize);  
        expectThrows(NoSuchFileException.class, () -> blobContainer.readBlobWithVersion("missing"));
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));  
            "bucket-owner-full-control" };
        final S3BlobContainer blobContainer = new S3BlobContainer(new BlobPath(), blobStore);  
            IntStream.of(randomIntBetween(1, 5)).forEach(value -> blobPath.add("path_" + value));
            s3AsyncClient,  
        ReadContext readContext = readContextActionListener.getResponse();  
     */
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable;
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
            () -> blobContainer.executeMultipartUpload(blobStore, randomAlphaOfLengthBetween(1, 10), null, blobSize, null, null)
            public void onFailure(Exception e) {
    ) {  
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        assertEquals("Future got interrupted", e.getMessage());
        });
        when(blobStore.asyncClientReference()).thenReturn(amazonAsyncS3Reference);  
    }
                    int currentCounter = counter.getAndIncrement();
     * The 404 classification is scoped tightly: only {@code NoSuchKey} on an {@code If-Match} write is evidence about  
                exceptionRef.set(e);  
            public void onResponse(DeleteResult deleteResult) {
        final boolean useBucketKey = randomBoolean();
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        final String blobName = randomAlphaOfLengthBetween(1, 10);
            sub.onSubscribe(new Subscription() {
            "private",  
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));  
        );
        final IllegalArgumentException e = expectThrows(
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
            )
        when(client.completeMultipartUpload(completeMultipartUploadRequestArgumentCaptor.capture())).thenReturn(
        when(blobStore.getBulkDeletesSize()).thenReturn(5);
        List<S3Object> s3Objects = new ArrayList<>();
        final BlobPath blobPath = new BlobPath();
                if (i % 2 == 0) {
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        assertEquals(eTag, token);
    /** Transport-level SDK failures (no HTTP response at all) surface as plain retryable IOExceptions on both paths. */
    }
        ArgumentCaptor<PutObjectRequest> captor,  
            public void onResponse(Void aVoid) {  
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
        final S3Exception[] retryable = new S3Exception[] {
            );
        when(blobStore.clientReference()).thenReturn(clientReference);  
        CompletableFuture<GetObjectAttributesResponse> getObjectAttributesResponseCompletableFuture = new CompletableFuture<>();
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(useBucketKey);  
        assertEquals(0, inputStreamContainer.getOffset());
        for (int i = 0; i < totalObjects; i++) {
    public void testRejectGlacierStorageClass() {
        doAnswer(invocation -> {  
    }
        assertEquals(cannedAccessControlList, request.acl());  
                public void request(long n) {
        );
            .collect(Collectors.toList());  
        int size = 0;
        long objectSize
                .checksum(Checksum.builder().checksumCRC32(checksum).build())  
        testListBlobsByPrefixInLexicographicOrder(-5, 0, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);  
        // it should accept [standard, standard_ia, onezone_ia, reduced_redundancy, intelligent_tiering]
            );  
    }  
        CountingCompletionListener<ReadContext> readContextActionListener = new CountingCompletionListener<>();  
        );
        final String checksum = randomAlphaOfLengthBetween(1, 10);  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
     * @throws IOException
                IOException.class,
        IOException e = expectThrows(IOException.class, blobContainer::delete);
        }  
            s3AsyncClient,  
                conflict
        assertEquals(expectedDeleteCalls, deleteCallCount.get());  
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
        final long bufferSize = ByteSizeUnit.MB.toBytes(150);  
    private void testDeleteAsync(int bulkDeleteSize) throws InterruptedException {
        final S3BlobContainer blobContainer = new S3BlobContainer(mock(BlobPath.class), blobStore);
            assertArrayEquals(payload, actual);
            assertEquals(useBucketKey, initRequest.bucketKeyEnabled());  
        IOException e = expectThrows(IOException.class, blobContainer::delete);  
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
        testListBlobsByPrefixInLexicographicOrder(0, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
                        subscriber.onNext(ListObjectsV2Response.builder().contents(s3Objects).build());
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);  
            public void onFailure(Exception e) {
            s3AsyncClient,
        CountDownLatch latch = new CountDownLatch(1);  
        int numObjects = randomIntBetween(20, 100);
import static org.mockito.Mockito.verify;
                resultRef.set(deleteResult);
            s3AsyncClient,
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            public void onFailure(Exception e) {  
        final String expectedToken = "\"" + UUID.randomUUID() + "\"";  
        assertEquals(simulatedError, e.getCause().getCause());
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());  
            (S3Exception) S3Exception.builder().statusCode(409).message("conflict").build() };  
            return currInvocationCount.get() < totalPageCount;
        assertTrue(e.getMessage(), e.getMessage().contains("too large"));
        // Exception when length is absent
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));
        final String blobName = randomAlphaOfLengthBetween(1, 10);
            Thread.currentThread().interrupt();
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());  
    public void testListBlobsByPrefixInLexicographicOrderWithLimitLessThanPageSize() throws IOException {
        final S3Client client = mock(S3Client.class);  
            GetObjectAttributesResponse.builder()
        assertThat(S3BlobStore.initStorageClass("reduced_redundancy"), equalTo(StorageClass.REDUCED_REDUNDANCY));
            assertEquals(partSize, inputStreamContainer.getContentLength());
        when(blobStore.getBulkDeletesSize()).thenReturn(bulkDeleteSize);
    private void testListBlobsByPrefixInLexicographicOrder(
                    subscriber.onError(new RuntimeException("Simulated listing error"));
        final List<SdkException> exceptions = Arrays.asList(
        final BlobPath blobPath = new BlobPath();
        assertEquals(0, readContextActionListener.getFailureCount());
        when(client.getObjectAsBytes(any(GetObjectRequest.class))).thenThrow(NoSuchKeyException.builder().build());  
                public void request(long n) {
            s3Objects.add(S3Object.builder().key("key-" + i).size(100L).build());  
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());  
    private void mockObjectResponse(S3AsyncClient s3AsyncClient, String bucketName, String blobName, int objectSize) {
        DeleteResult deleteResult = deleteResultRef.get();  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        getObjectResponse = GetObjectResponse.builder().contentRange(contentRange).build();  
            // an unlabelled 409 is not evidence that the precondition failed
            boolean throwExceptionOnNextInvocation  
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final ArgumentCaptor<CompleteMultipartUploadRequest> completeMultipartUploadRequestArgumentCaptor = ArgumentCaptor.forClass(
        }  
        final String checksum = randomAlphaOfLength(10);
        );  
import java.util.concurrent.CompletableFuture;
        doAnswer(invocation -> {  
        });
                        ListObjectsV2Response.builder().contents(S3Object.builder().key("test-key").size(100L).build()).build()
        List<String> blobNames = Arrays.asList("blob1", "blob2", "blob3");  
        CountDownLatch latch = new CountDownLatch(1);
        });  
        private int responseCount;  
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));
        public int getFailureCount() {  
        for (String aclString : aclList) {  
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);  
        assertFalse(read instanceof BlobVersionConflictException);
    }
        );
        final String bucketName = randomAlphaOfLengthBetween(1, 10);  
        assertEquals(objectSize, inputStreamContainer.getInputStream().readAllBytes().length);
            byte[] actual = is.readAllBytes();  
import org.opensearch.common.blobstore.stream.read.ReadContext;  
        );
        ).thenReturn(getObjectPartResponse);
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);  
            subscriber.onSubscribe(new Subscription() {  
            int s3ObjectsPerPage,  
        final boolean useSseKms = randomBoolean();
            GetObjectAttributesResponse.builder()  
            ResponseBytes.fromByteArray(GetObjectResponse.builder().eTag("\"etag\"").build(), exactlyAtBound)
        int bulkDeleteSize = 3; // Small size to force multiple delete requests  
        when(client.createMultipartUpload(createMultipartUploadRequestArgumentCaptor.capture())).thenReturn(createMultipartUploadResponse);
        final long partSize = Math.min(bufferSize, blobSize);
        latch.await();
            });
                } else {
import software.amazon.awssdk.services.s3.model.DeleteObjectsRequest;
        String bucketName,  
import software.amazon.awssdk.core.async.AsyncResponseTransformer;  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        );
            (S3Exception) S3Exception.builder().statusCode(412).message("precondition failed").build(),
                .build()
        final String token = blobContainer.writeBlobConditionally(
                }
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
        final long size = unit.toBytes(randomIntBetween(2, 1000));
    public void testInvalidStorageClass() {
        failedFuture.completeExceptionally(new RuntimeException("Simulated delete error"));
 * SPDX-License-Identifier: Apache-2.0
import java.util.concurrent.atomic.AtomicReference;
            SdkException.class,  
        blobContainer.deleteBlobsAsyncIgnoringIfNotExists(blobNames, new ActionListener<Void>() {
import static org.mockito.Mockito.doAnswer;
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();  
            keysListed = new ArrayList<>();  
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(failedFuture);  
        ResponseInputStream<GetObjectResponse> responseInputStreamNoRange = new ResponseInputStream<>(getObjectResponse, inputStream);
        when(listObjectsV2Iterable.iterator()).thenReturn(iterator);
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
        final BlobPath blobPath = new BlobPath();  
        private Exception exception;  
        GetObjectRequest getObjectRequest = GetObjectRequest.builder().bucket(bucketName).key(blobName).build();
        assertNotNull(exceptionRef.get());
                for (int i = 0; i < s3ObjectsPerPage; i++) {
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadResponse;  
        final BlobPath blobPath = new BlobPath();
        // Simulate a failure when getting the asyncClientReference  
        // it should init cannedACL correctly
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        @Override
        }
            public void onFailure(Exception e) {
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        final String blobName = randomAlphaOfLengthBetween(1, 10);  
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;  
        verify(client, times(1)).headObject(any(HeadObjectRequest.class));
        assertEquals(checksum, readContext.getBlobChecksum());
        public MockListObjectsV2ResponseIterator(int totalPageCount, int s3ObjectsPerPage, long s3ObjectSize) {
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));
        }  
import java.util.Arrays;  
        assertEquals("java.lang.RuntimeException: Simulated delete error", exceptionRef.get().getMessage());
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(failedFuture);  
            assertEquals(ServerSideEncryption.AWS_KMS, initRequest.serverSideEncryption());  
        } else {
        verify(s3AsyncClient, times(1)).listObjectsV2Paginator(any(ListObjectsV2Request.class));
    public void testDeleteBlobsAsyncIgnoringIfNotExistsInitializationFailure() throws Exception {  
        when(blobStore.clientReference()).thenReturn(clientReference);  
        // it should default to `standard`  
    }
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
            }
        assertNotNull(exceptionRef.get().getCause());  
        final ArgumentCaptor<PutObjectRequest> putReqCaptor = ArgumentCaptor.forClass(PutObjectRequest.class);  
        failedFuture.completeExceptionally(new RuntimeException("Simulated delete failure"));
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);  
                .objectParts(GetObjectAttributesParts.builder().totalPartsCount(objectPartCount).build())
    private static void assertNumberOfMultiparts(final int expectedParts, final long expectedRemaining, long totalSize, long partSize) {  
        blobContainer.deleteAsync(new ActionListener<>() {
        }
            public void onResponse(Void aVoid) {
        if (useSseKms) {
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
        @Override
        final int objectPartCount = 10;  
        final ArgumentCaptor<PutObjectRequest> captor = ArgumentCaptor.forClass(PutObjectRequest.class);
        final boolean useBucketKey = randomBoolean();
        when(blobStore.clientReference()).thenReturn(clientReference);
                latch.countDown();
        // But as of today, the blob delete count and bytes is updated a bit earlier.
            () -> S3BlobContainer.transformResponseToInputStreamContainer(responseInputStreamNoContentLength, true)
            });
        DeleteResult result = resultRef.get();
                @Override  
        GetObjectAttributesResponse objectAttributesResponse = responseFuture.get();
        );
                public void cancel() {}
        blobContainer.deleteBlobsAsyncIgnoringIfNotExists(emptyBlobNames, new ActionListener<Void>() {
        final BlobPath blobPath = new BlobPath();
        assertEquals(contentLength, inputStreamContainer.getContentLength());
    public void testExecuteSingleUploadBlobSizeLargerThanBufferSize() {  
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
    }
        final ListObjectsV2Iterable listObjectsV2Iterable = mock(ListObjectsV2Iterable.class);
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
        final ArgumentCaptor<RequestBody> requestBodyArgumentCaptor = ArgumentCaptor.forClass(RequestBody.class);
            s3Exception(412, "PreconditionFailed"),  
        when(blobStore.getStorageClass()).thenReturn(storageClass);
        CountDownLatch latch = new CountDownLatch(1);
            // Fail the initialization request  
        assertEquals(contentLength, inputStreamContainer.getContentLength());
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
            // Fail the upload part request  
     * at the bound comes back whole and passes, one over comes back truncated to bound+1 and trips the check. The pair  
        blobContainer.deleteAsync(new ActionListener<>() {
        when(blobStore.bucket()).thenReturn(bucketName);
        assertEquals(checksum, objectAttributesResponse.checksum().checksumCRC32());
                    assertEquals(sortedKeys, blobMetadata.stream().map(BlobMetadata::name).collect(Collectors.toList()));  
            AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null)  
        when(client.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listObjectsV2Iterable);
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
        } else {
        assertEquals("bytes=0-" + ByteSizeUnit.MB.toBytes(1), captor.getValue().range());
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
            String blobPath,
        assertNumberOfMultiparts(factor + 1, remaining, (size * factor) + remaining, size);
        countDownLatch.await();
            // a conflicting conditional write IN PROGRESS: the outcome of this request's precondition is unknown,
                @Override
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
        assertEquals(blobPath.buildAsString() + blobName, initRequest.key());  
        assertEquals(IOException.class, exceptionRef.get().getClass());
        final long objectSize = 100L;
            allObjects.addAll(pageObjects);
                .contentLength((long) partSize)
                }  
        mockObjectResponse(s3AsyncClient, bucketName, blobName, objectSize);  
            new ByteArrayInputStream(payload),  
        assertArrayEquals("an object of exactly the size bound must not be rejected", exactlyAtBound, blob.content());
        assertEquals(numObjects, deleteResult.blobsDeleted());
        final String kmsKeyId = randomAlphaOfLength(10);
            when(client.uploadPart(any(UploadPartRequest.class), any(RequestBody.class))).thenThrow(exceptions.get(stage));
        doAnswer(invocation -> {
                public void request(long n) {
        AtomicInteger counter = new AtomicInteger();
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
            public void onResponse(DeleteResult deleteResult) {  
    public void testWriteBlobConditionallyTreatsIfMatchOnDeletedKeyAsLostCas() {
            final int offset = partNumber * partSize;
            expectedEncodedContext = java.util.Base64.getEncoder()  
        );
                    assertEquals(expectedNumberofPagesFetched, iterator.numberOfPagesFetched());
        // Simulate item-level errors during delete  
        final IOException e = expectThrows(  
            when(client.uploadPart(any(UploadPartRequest.class), any(RequestBody.class))).thenAnswer(invocationOnMock -> {  
            public void onFailure(Exception e) {  
            ).thenReturn(getObjectPartResponse);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            CompletableFuture.completedFuture(DeleteObjectsResponse.builder().build())  
    }
            assertEquals(offset, inputStreamContainer.getOffset());  
 * this work for additional information regarding copyright
        failedFuture.completeExceptionally(simulatedError);
            s3AsyncClient,
    public void testConditionalPathsTranslateSdkTransportFailuresToIOException() {
     * this is a definitively lost CAS, not a retryable error: it is exactly what a swept acknowledgement path looks  
            null,
        } else {
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final MockListObjectsV2ResponseIterator iterator = new MockListObjectsV2ResponseIterator(2, 5, 100, blobPath.buildAsString());
                final UploadPartResponse response = UploadPartResponse.builder().eTag(expectedEtags.get(request.partNumber() - 1)).build();  
        final int objectPartCount = 10;  
        );  
        final BlobPath blobPath = new BlobPath();  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));  
        final byte[] payload = randomByteArrayOfLength(blobSize);  
    public void testReadBlobAsyncFailure() throws Exception {  
            .get();  
            s3AsyncClient,  
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);  
        when(s3AsyncClient.getObjectAttributes(any(GetObjectAttributesRequest.class))).thenReturn(
    /**
            });  
        assertThat(S3BlobStore.initStorageClass(null), equalTo(StorageClass.STANDARD));
                    if (blobNameSortOrder != BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC) {
        assertEquals(totalSize, deleteResult.bytesDeleted());
        BlobStoreException ex = expectThrows(BlobStoreException.class, () -> S3BlobStore.initStorageClass("glacier"));
        when(blobStore.bucket()).thenReturn(bucketName);  
        assertEquals("Expected remaining [" + expectedRemaining + "] but got [" + result.v2() + "]", expectedRemaining, (long) result.v2());
        return (S3Exception) S3Exception.builder()
        final ObjectCannedACL cannedAccessControlList = randomBoolean() ? randomFrom(ObjectCannedACL.values()) : null;  
        CountDownLatch latch = new CountDownLatch(1);
            ArgumentCaptor.forClass(PutObjectRequest.class),
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        latch.await();
            assertEquals(i + 1, uploadPartRequest.partNumber().intValue());  
            public void onResponse(DeleteResult deleteResult) {  
        final List<RequestBody> requestBodies = requestBodyArgumentCaptor.getAllValues();
        assertThrows(SdkException.class, () -> S3BlobContainer.transformResponseToInputStreamContainer(responseInputStreamNoRange, true));  
            .reduce(Integer::sum)
        final boolean useBucketKey = randomBoolean();
                null,  
            );
        Map<String, BlobMetadata> listOfBlobs = blobContainer.listBlobsByPrefix(null);
        getObjectPartResponse.complete(responseInputStream);  
        IOException e = expectThrows(IOException.class, () -> blobContainer.deleteBlobsIgnoringIfNotExists(blobNames));  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        assertThat(e.getCause(), instanceOf(SdkException.class));
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());  
        );  
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);  
        final S3BlobContainer blobContainer = conditionalWriteContainer(  
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);  
     * {@code FsBlobContainer}, which also reports a conflict for a missing blob.
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
            ResponseInputStream<GetObjectResponse> responseInputStream = new ResponseInputStream<>(getObjectResponse, inputStream);  
            }
        assertEquals(numberOfParts.v1().intValue(), uploadRequests.size());  
    }  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(client.getObjectAsBytes(captor.capture())).thenReturn(
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
    }
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(useBucketKey);
        }
            }  
        when(client.getObjectAsBytes(any(GetObjectRequest.class))).thenThrow(SdkException.builder().message("no route").build());
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
            public void onResponse(DeleteResult deleteResult) {
                .build();  
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadResponse;  
        final IllegalArgumentException e = expectThrows(
                @Override  
        public void onResponse(T response) {  
        }  
                throw SdkException.builder().build();
        );
        final BlobPath blobPath = new BlobPath();
        List<String> blobNames = Arrays.asList("test1", "test2");  
        assertEquals("java.lang.RuntimeException: Simulated delete failure", exceptionRef.get().getCause().getMessage());  
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
        int expectedDeleteCalls = (int) Math.ceil((double) allObjects.size() / bulkDeleteSize);
        );  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        InputStreamContainer inputStreamContainer = readContext.getPartStreams().stream().findFirst().get().get().join();
            null,
                eq(getObjectRequest),  
            });
        final String eTag = "\"" + UUID.randomUUID() + "\"";  
        ).thenReturn(getObjectPartResponse);  
                verify(client, times(6)).uploadPart(any(UploadPartRequest.class), any(RequestBody.class));
        RuntimeException simulatedFailure = new RuntimeException("Simulated initialization failure");
                    );
        when(client.putObject(any(PutObjectRequest.class), any(RequestBody.class))).thenThrow(  
        assertEquals("Failed to list objects for deletion", exceptionRef.get().getMessage());  
        assertTrue(blobContainer.blobExists(blobName));
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
            expectedEncodedContext = null;
            // S3 lists keys in lexicographic order
        doAnswer(invocation -> {
     * deliberately. That extra byte is what makes "too large" detectable without buffering the whole object: an object
        when(blobStore.bucket()).thenReturn(bucketName);  
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        assertThat(S3BlobStore.initStorageClass("intelLigeNt_tieriNG"), equalTo(StorageClass.INTELLIGENT_TIERING));
    public void testInitStorageClass() {
                }
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final boolean useSseKms = randomBoolean();  
        when(blobStore.bucket()).thenReturn(bucketName);
        final S3Client client = mock(S3Client.class);
        // Fits in N parts exactly
    /**  
        BlobPath blobPath = mock(BlobPath.class);  
import java.util.Collections;
        assertThat(ex.getMessage(), equalTo("cannedACL is not valid: [test_invalid]"));
     * pins both sides so neither a truncation nor an escape can be introduced silently.
                final UploadPartRequest request = (UploadPartRequest) invocationOnMock.getArguments()[0];
import software.amazon.awssdk.core.exception.SdkException;
import static org.mockito.Mockito.verifyNoInteractions;  
            responseCount++;
        }  
                keysListed.add(blobPath + UUID.randomUUID().toString());
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
            .stream()  
        assertThat(S3BlobStore.initStorageClass("onezone_ia"), equalTo(StorageClass.ONEZONE_IA));
                            .build()
                latch.countDown();
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
                @Override  
        final S3Client client = mock(S3Client.class);
        assertEquals("Future got interrupted", e.getMessage());
        assertEquals(0, readContextActionListener.getResponseCount());
 * GitHub history for details.
import java.io.ByteArrayInputStream;
                @Override
     * S3 fails an {@code If-Match} write with 404 {@code NoSuchKey} rather than 412 when the key has no current
        logger.error("", exceptionRef.get());
        assertNumberOfMultiparts(1, size, size, size);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());  
            @Override  
        getObjectAttributesResponseCompletableFuture.complete(
        for (int partNumber = 1; partNumber <= totalNumberOfParts; partNumber++) {  
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
        metadata.put("key1", "value1");
            @Override
        final long remaining = randomIntBetween(1, (size > Integer.MAX_VALUE) ? Integer.MAX_VALUE : (int) size - 1);  
                        S3Error.builder()
            });
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());  
            assertEquals(expectedEncodedContext, initRequest.ssekmsEncryptionContext());
        CompletableFuture<DeleteObjectsResponse> failedFuture = new CompletableFuture<>();
            failureCount++;
        final S3BlobStore blobStore = mock(S3BlobStore.class);
    public void testDeleteSdkExceptionDuringDeleteOperation() throws Exception {  
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final BlobPath blobPath = new BlobPath();
    public void testDeleteAsyncFailure() throws Exception {
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        final AmazonAsyncS3Reference amazonAsyncS3Reference = new AmazonAsyncS3Reference(
        final BlobPath blobPath = new BlobPath();
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(useBucketKey);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        doAnswer(invocation -> {  
        DeleteObjectsRequest capturedRequest = deleteRequestCaptor.getAllValues().stream().findAny().get();  
            GetObjectAttributesResponse.builder()  
            (S3Exception) S3Exception.builder().statusCode(404).message("not found").build() };  
            ArgumentCaptor.forClass(PutObjectRequest.class),
            s3Exception(404, "NoSuchBucket"),
import java.util.ArrayList;
            () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, null)
        final long sizeBound = randomIntBetween(1, 512);
                fail("Expected a failure, but got a success response");
            subscriber.onError(simulatedError);
 */
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
    public void testDeleteBlobsAsyncIgnoringIfNotExistsWithEmptyList() throws Exception {  
        CompletableFuture<GetObjectAttributesResponse> getObjectAttributesResponseCompletableFuture = new CompletableFuture<>();  
    public void testWriteBlobConditionallyCreateIfAbsentSetsIfNoneMatch() throws IOException {
    public void testDeleteSdkExceptionDuringListOperation() throws Exception {  
        final BlobPath blobPath = new BlobPath();
    public void testDeleteItemLevelErrorsDuringDelete() throws Exception {
            IntStream.of(randomIntBetween(1, 5)).forEach(value -> blobPath.add("path_" + value));
import org.mockito.ArgumentCaptor;
            );
    }
        getObjectAttributesResponseCompletableFuture.complete(
        final S3Client client = mock(S3Client.class);
            SdkException.create("Expected initialization request to fail", new RuntimeException()),  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
                }  
                resultRef.set(deleteResult);
            public void onFailure(Exception e) {
        assertTrue(Thread.interrupted()); // Clear interrupted state  
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
            List<S3Error> errors = new ArrayList<>();
            IllegalArgumentException.class,
            }
            @Override
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);  
            AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null)
        when(client.getObjectAsBytes(any(GetObjectRequest.class))).thenReturn(
                fail("Unexpected failure: " + e.getMessage());
                byte[] actualBytes = is.readAllBytes();  
            expectedEncodedContext = java.util.Base64.getEncoder()
        );
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        final long objectSize = 100L;
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
        CountingCompletionListener<ReadContext> readContextActionListener = new CountingCompletionListener<>();  
        assertEquals("Part size must be greater than zero", e.getMessage());
import software.amazon.awssdk.services.s3.model.CompletedPart;
        AtomicBoolean onResponseCalled = new AtomicBoolean(false);
import software.amazon.awssdk.awscore.exception.AwsErrorDetails;  
            testDeleteAsync(i + 1);  
                .checksum(Checksum.builder().checksumCRC32(checksum).build())
            s3AsyncClient,
            @Override  
        final int totalObjects = 10;  
        CompletableFuture<GetObjectAttributesResponse> getObjectAttributesResponseCompletableFuture = new CompletableFuture<>();
        when(client.headObject(any(HeadObjectRequest.class))).thenThrow(NoSuchKeyException.builder().build());  
        }  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        final ListObjectsV2Iterable listObjectsV2Iterable = mock(ListObjectsV2Iterable.class);
import software.amazon.awssdk.services.s3.model.ServerSideEncryption;  
        assertThat(S3BlobStore.initStorageClass("sTandaRd_Ia"), equalTo(StorageClass.STANDARD_IA));
        } else {
        verify(s3AsyncClient, times(1)).listObjectsV2Paginator(any(ListObjectsV2Request.class));  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
                        subscriber.onNext(  
        int expectedDeleteCalls = size / bulkDeleteSize + (size % bulkDeleteSize > 0 ? 1 : 0);  
        verifyNoInteractions(s3AsyncClient);  
        for (int i = 0; i < totalPageCount; i++) {
     * Test the boundary value at page size to ensure  
    public void testExecuteMultipartUpload() throws IOException {  
            when(client.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenThrow(exceptions.get(stage));
                .build()
            BlobVersionConflictException.class,  
        });
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
    public void testCaseInsensitiveStorageClass() {  
            "authenticated-read",  
        when(blobStore.bucket()).thenReturn(bucketName);
    public void testWriteBlobConditionallyWithTokenSetsIfMatch() throws IOException {
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(  
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);
        final BlobPath blobPath = new BlobPath();  
import org.opensearch.common.collect.Tuple;
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(
                    List<String> sortedKeys = keys.subList(0, actualLimit);
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());
                s3AsyncClient.getObject(  
            if (currInvocationCount.getAndIncrement() < totalPageCount) {  
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());  
        final CountDownLatch publisherCompletedLatch = new CountDownLatch(1);  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);  
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import java.util.stream.Collectors;
            final String kmsContext = "{\"repo\":\"test\"}";
        assertEquals(IOException.class, exceptionRef.get().getClass());  
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(kmsContext);
        assertNotNull(exceptionRef.get());  
    }  
        );
        AtomicBoolean onNext = new AtomicBoolean(false);  
                return ListObjectsV2Response.builder().contents(s3Objects).build();  
        IOException e = expectThrows(IOException.class, () -> blobContainer.deleteBlobsIgnoringIfNotExists(blobNames));
        when(client.getObjectAsBytes(captor.capture())).thenReturn(
        assertNotNull("Expected DeleteResult but got null", result);
            GetObjectResponse getObjectResponse = GetObjectResponse.builder()  
            subscriber.onSubscribe(new Subscription() {
        ResponseInputStream<GetObjectResponse> responseInputStream = new ResponseInputStream<>(getObjectResponse, inputStream);  
                    } else {
            @Override
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenAnswer(invocation -> {
                    if (currentCounter < responseList.size()) {  
            final S3BlobContainer blobContainer = conditionalWriteContainer(ArgumentCaptor.forClass(PutObjectRequest.class), null, error);  
                    deletedObjects.add(DeletedObject.builder().key(request.delete().objects().get(i).key()).build());
            int totalPageCount,
            .map(s -> s.substring(blobPath.buildAsString().length()))
        blobContainer.deleteAsync(new ActionListener<>() {
        final BlobPath blobPath = new BlobPath();
        int size = randomIntBetween(10, 100);
    public void testReadBlobAsyncOnCompleteFailureMissingData() throws Exception {  
        final int bufferSize = randomIntBetween(1024, 2048);
            when(client.putObject(captor.capture(), any(RequestBody.class))).thenReturn(response);
            return null;
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
                new ByteArrayInputStream(new byte[0]),  
                fail("Expected a failure, but got a success response");  
 *
        while (size < numObjects) {
    public void testDeleteBlobsAsyncIgnoringIfNotExistsFailure() throws Exception {
        assertEquals(objectSize, inputStreamContainer.getContentLength());  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
            getObjectAttributesResponseCompletableFuture  
            final RequestBody requestBody = requestBodies.get(i);
            getObjectAttributesResponseCompletableFuture
                        .map(s -> s.substring(blobPath.buildAsString().length()))
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());  
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
            }
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);  
        final S3Client client = mock(S3Client.class);
    }
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));  
        CountingCompletionListener<ReadContext> readContextActionListener = new CountingCompletionListener<>();
        final S3Client client = mock(S3Client.class);  
        assertTrue(exceptionRef.get() instanceof CompletionException);  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            .awsErrorDetails(AwsErrorDetails.builder().errorCode(errorCode).build())  
        when(blobStore.bucket()).thenReturn(bucketName);
        when(blobStore.getBulkDeletesSize()).thenReturn(bulkDeleteSize);
        S3AsyncClient s3AsyncClient,
                    if (currentCounter < responses.size()) {
            s3AsyncClient,
            Thread.currentThread().interrupt();
        assertNotNull(exceptionRef.get());
        when(blobStore.bufferSizeInBytes()).thenReturn(bufferSize);
        }
            @Override
        assertEquals(objectSize, readContext.getBlobSize());  
        );
        blobContainer.deleteBlobsAsyncIgnoringIfNotExists(blobNames, new ActionListener<Void>() {
            .stream()  
        final BlobPath blobPath = new BlobPath();  
        );
    }
        }
                    }
import org.opensearch.test.OpenSearchTestCase;
                    public void onResponse(List<BlobMetadata> blobMetadata) {}
        when(blobStore.clientReference()).thenReturn(clientReference);  
                .objectSize(null)  
                totalSize += s3ObjectSize;  
            assertThrows(
        final IOException e = expectThrows(IOException.class, () -> {
        final String blobName = randomAlphaOfLengthBetween(1, 10);
import software.amazon.awssdk.services.s3.S3Client;
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        when(blobStore.bucket()).thenReturn(bucketName);  
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
                    List<String> keys = iterator.keysListed.stream()  
            assertThat(acl, equalTo(awsList));
    }
        assertEquals(simulatedFailure, exceptionRef.get().getCause());  
            "public-read",
import software.amazon.awssdk.core.ResponseInputStream;
        final ArgumentCaptor<UploadPartRequest> uploadPartRequestArgumentCaptor = ArgumentCaptor.forClass(UploadPartRequest.class);
            }  
            ResponseBytes.fromByteArray(GetObjectResponse.builder().eTag(eTag).build(), payload)  
    }
        );
        assertTrue("Exception should be an IOException", exceptionRef.get() instanceof IOException);  
        when(s3AsyncClient.getObjectAttributes(any(GetObjectAttributesRequest.class))).thenReturn(
        final String checksum = randomAlphaOfLength(10);  
                () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, "\"stale\"")
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        blobContainer.executeSingleUpload(blobStore, blobName, inputStream, blobSize, metadata, null);
        assertEquals(bucketName, initRequest.bucket());
    }
                    }
        // Verify that no interactions with S3AsyncClient occurred
 */  
    }
            int toAdd = randomIntBetween(10, 20);  
            s3AsyncClient,
            @Override
    ) throws IOException {
        });
            blobContainer.listBlobsByPrefixInSortedOrder(null, limit, blobNameSortOrder, new ActionListener<>() {  
        when(blobPath.buildAsString()).thenReturn("/dummy/path");
        blobContainer.readBlobAsync(blobName, listener);
        when(blobStore.asyncClientReference()).thenThrow(simulatedFailure);
            .get();
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));
        assertEquals(exceptions.get(stage).getMessage(), e.getCause().getMessage());
        assertEquals(1, readContextActionListener.getResponseCount());
        when(blobStore.getBulkDeletesSize()).thenReturn(bulkDeleteSize);
                IllegalArgumentException.class,
                        subscriber.onComplete();  
        if (stage == 0) {
        );  
            assertEquals(ServerSideEncryption.AES256, initRequest.serverSideEncryption());
                @Override
                fail("Expected a failure, but got a success response");
        assertThat(S3BlobStore.initCannedACL(""), equalTo(ObjectCannedACL.PRIVATE));  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        assertEquals(totalSize, result.bytesDeleted());  
            subscriber.onSubscribe(new Subscription() {
                    int currentCounter = counter.getAndIncrement();  
        assertEquals(0, readContextActionListener.getFailureCount());
        inputStreamContainer = blobContainer.getBlobPartInputStreamContainer(s3AsyncClient, bucketName, blobName, null).get();
    }
        final S3Exception[] retryable = new S3Exception[] {  
        public void onFailure(Exception e) {  
        testListBlobsByPrefixInLexicographicOrder(2, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
                latch.countDown();
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        final CompleteMultipartUploadRequest completeMultipartUploadRequest = completeMultipartUploadRequestArgumentCaptor.getValue();
        assertNotNull(exceptionRef.get());
        final String kmsContext = randomAlphaOfLength(10);
        final List<String> blobNames = new ArrayList<>();
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
    }
        );  
            final IOException e = expectThrows(
        CountDownLatch latch = new CountDownLatch(1);
        when(blobStore.bucket()).thenReturn(bucketName);  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        final IOException e = expectThrows(IOException.class, () -> blobContainer.readBlobWithVersion("oversized"));
                pageObjects.add(S3Object.builder().key(randomAlphaOfLength(10)).size(s3ObjectSize).build());
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
import org.opensearch.action.LatchedActionListener;
                    if (currentCounter == responseList.size()) {  
            for (int j = 0; j < s3ObjectsPerPage; j++) {
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(kmsKeyId);
        assertEquals(1, readContextActionListener.getFailureCount());
            s3AsyncClient,  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        doAnswer(invocation -> {
            false  
import software.amazon.awssdk.services.s3.model.GetObjectAttributesParts;
        AtomicInteger counter = new AtomicInteger();  
            }
        );  
        final long blobSize = ByteSizeUnit.MB.toBytes(randomIntBetween(1, 4));
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        when(blobStore.bucket()).thenReturn(bucketName);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        when(blobStore.asyncClientReference()).thenReturn(amazonAsyncS3Reference);  
        int bulkDeleteSize = 5;
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        final InputStream inputStream = ResponseInputStream.nullInputStream();
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        verify(s3AsyncClient, times(expectedDeleteCalls)).deleteObjects(any(DeleteObjectsRequest.class));
            return null;  
        final String newETag = "\"" + UUID.randomUUID() + "\"";
    public void testConditionalWriteSupported() {
            s3AsyncClient,
    }
                    fail("blobContainer.listBlobsByPrefixInLexicographicOrder failed with exception: " + e.getMessage());  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        assertNotNull(exceptionRef.get().getCause());
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(kmsContext);  
        when(blobStore.bucket()).thenReturn(bucketName);
        }
        final VersionedBlob blob = new S3BlobContainer(new BlobPath(), blobStore).readBlobWithVersion("at-bound");  
            @Override
                    done = true;
                public void cancel() {}  
        private T response;
                    if (onNext.compareAndSet(false, true)) {  
        // Exception when content range absent for multipart object
            IllegalArgumentException.class,
            final S3BlobContainer blobContainer = conditionalWriteContainer(ArgumentCaptor.forClass(PutObjectRequest.class), null, error);  
        }  
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);  
        final String blobName = randomAlphaOfLengthBetween(1, 10);
import org.opensearch.common.blobstore.BlobMetadata;  
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
        when(listObjectsV2Iterable.iterator()).thenReturn(iterator);  
        } else {  
            IllegalArgumentException.class,  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
        } else {
    }
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        metadata.put("key2", "value2");
                    }  
        );
                .objectSize(objectSize)
            size = endIndex;  
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);  
            // 412 is unambiguous, with or without an error code
        CountDownLatch latch = new CountDownLatch(1);  
        if (cannedAccessControlList != null) {  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("Conditional write request size [" + blobSize + "] can't be larger than buffer size", e.getMessage());
                @Override  
            byte[] expectedBytes = inputStream.readAllBytes();
        final BlobPath blobPath = new BlobPath();
        CompletableFuture<DeleteObjectsResponse> failedFuture = new CompletableFuture<>();
    public void testExecuteSingleUpload() throws IOException {
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();  
        final long objectSize = 100L;
        verify(client, times(1)).headObject(any(HeadObjectRequest.class));
            DeleteObjectsRequest request = invocation.getArgument(0);  
        );
            @Override  
        // Header based offset in case of a multi part object request
        when(blobStore.bucket()).thenReturn(bucketName);
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));
            final InputStream inputStream = new ByteArrayInputStream(randomByteArrayOfLength(partSize));
        assertNotNull("An exception should have been thrown", exceptionRef.get());
                .objectSize(objectSize)  
    }
                () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, "\"token\"")  
            () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, "\"token\"")
        public T getResponse() {
        // The transfer is bounded by a ranged GET so an oversized object at this key cannot be buffered whole
        assertEquals("Failed to delete blobs " + blobNames, exceptionRef.get().getMessage());
            when(client.createMultipartUpload(any(CreateMultipartUploadRequest.class))).thenReturn(createMultipartUploadResponse);
                latch.countDown();  
            () -> blobContainer.executeSingleUpload(  
                logger.error("exception during deleteAsync", e);
        }
    public void testDeleteBlobsIgnoringIfNotExistsWithInterruptedException() throws Exception {
        CountDownLatch latch = new CountDownLatch(1);
import software.amazon.awssdk.services.s3.model.GetObjectAttributesResponse;  
            }
            );
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        assertEquals(totalObjects, result.blobsDeleted());
        BlobContainer.BlobNameSortOrder blobNameSortOrder
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
            when(
            @Override
        assertEquals(contentLength, inputStreamContainer.getContentLength());
            IllegalArgumentException.class,  
            public void onResponse(DeleteResult deleteResult) {
        // it should accept all aws cannedACLs
        // Simulate a failure in listObjectsV2Paginator
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        assertEquals(bucketName, capturedRequest.bucket());
        when(blobStore.asyncClientReference()).thenReturn(amazonAsyncS3Reference);  
    public void testListBlobsByPrefixInLexicographicOrderWithNegativeLimit() throws IOException {
                () -> blobContainer.listBlobsByPrefixInSortedOrder(null, limit, blobNameSortOrder, new ActionListener<>() {  
        when(blobStore.bucket()).thenReturn(bucketName);  
        });
        public boolean hasNext() {  
        final IOException write = expectThrows(  
        final String kmsKeyId = randomAlphaOfLength(10);
            "bucket-owner-read",
        metadata.put("key2", "value2");  
            ResponseBytes.fromByteArray(GetObjectResponse.builder().eTag("\"etag\"").build(), randomByteArrayOfLength((int) sizeBound + 1))
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
                latch.countDown();
        when(blobStore.bufferSizeInBytes()).thenReturn(sizeBound);
            null  
        // Simulate a failure in deleteObjects  
                .build()  
        ResponseInputStream<GetObjectResponse> responseInputStream = new ResponseInputStream<>(getObjectResponse, inputStream);
            assertEquals(kmsKeyId, initRequest.ssekmsKeyId());
        when(blobStore.asyncClientReference()).thenReturn(amazonAsyncS3Reference);
            getObjectResponse,
        final List<ListObjectsV2Response> responseList = new ArrayList<>();  
import java.util.concurrent.atomic.AtomicBoolean;
                    assertEquals(actualLimit, blobMetadata.size());
    public void testWriteBlobConditionallyTranslatesPreconditionFailures() {
        final long s3ObjectSize = ByteSizeUnit.MB.toBytes(5);
        assertEquals("Upload request size [" + blobSize + "] can't be larger than 5gb", e.getMessage());  
            }
                fail("Expected failure but got success");
 *    http://www.apache.org/licenses/LICENSE-2.0
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
                .checksum(Checksum.builder().checksumCRC32(checksum).build())
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
            // so it must be retried - the retry answers definitively (412 = genuinely lost, success = not lost)  
            s3AsyncClient,  
        RuntimeException simulatedFailure = new RuntimeException("Simulated failure");
                .build();  
        assertEquals(bucketName, request.bucket());
        getObjectAttributesResponseCompletableFuture.complete(
            @Override  
        final String token = blobContainer.writeBlobConditionally(
            () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, "\"token\"")
        assertThat(S3BlobStore.initCannedACL(null), equalTo(ObjectCannedACL.PRIVATE));
 * under the License.  
        when(blobStore.expectedBucketOwner()).thenReturn(randomAlphaOfLength(12));  
        final String kmsKeyId = randomAlphaOfLength(10);
     * A lost CAS is fatal for a fenced writer, so retryable 409s such as {@code OperationAborted} must not be
        // Matches the write side, which rejects only blobSize > bufferSizeInBytes.
            }
                @Override  
                    ArgumentMatchers.<AsyncResponseTransformer<GetObjectResponse, ResponseInputStream<GetObjectResponse>>>any()
            }
            CompletableFuture.completedFuture(DeleteObjectsResponse.builder().build())
        final IOException e = expectThrows(
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            null // create-if-absent
        ResponseInputStream<GetObjectResponse> responseInputStreamNoRangeSinglePart = new ResponseInputStream<>(  
        ReadContext readContext = readContextActionListener.getResponse();  
                latch.countDown();  
        assertEquals(Long.valueOf(objectSize), objectAttributesResponse.objectSize());
    }
import java.util.HashMap;  
        countDownLatch.await();
        List<String> deletedKeys = deleteRequestCaptor.getAllValues()
                onResponseCalled.set(true);
        blobContainer.readBlobAsync(blobName, listener);
            "fence",  
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenThrow(simulatedFailure);  
            getObjectAttributesResponseCompletableFuture  
        assertEquals("java.lang.RuntimeException: Simulated delete error", exceptionRef.get().getMessage());
        blobContainer.deleteAsync(new ActionListener<>() {
            clientReference.incRef();
            long s3ObjectSize,
            s3Exception(409, "OperationAborted"),
        });
        int expectedNumberofPagesFetched,  
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        final String kmsKeyId = randomAlphaOfLength(10);  
                .objectParts(GetObjectAttributesParts.builder().totalPartsCount(objectPartCount).build())  
        CountDownLatch countDownLatch = new CountDownLatch(1);
            @Override
import java.util.concurrent.atomic.AtomicInteger;  
            responseInputStreamNoRangeSinglePart,
import org.reactivestreams.Subscription;
        }  
        blobContainer.readBlobAsync(blobName, listener);
            final int end = partNumber * partSize;
                exceptionRef.set(e);
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
import org.opensearch.common.blobstore.BlobStoreException;
            () -> blobContainer.executeSingleUpload(blobStore, randomAlphaOfLengthBetween(1, 10), null, blobSize, null, null)
        mockObjectPartResponse(s3AsyncClient, bucketName, blobName, objectPartCount, partSize, objectSize);  
import java.util.stream.IntStream;  
        doAnswer(invocation -> {
                latch.countDown();  
    /**
        assertEquals("Failed to delete blobs " + blobNames, e.getMessage());  
        when(asyncClientReference.get()).thenReturn(AmazonAsyncS3WithCredentials.create(s3AsyncClient, s3AsyncClient, s3AsyncClient, null));
        assertEquals(bucketName, completeMultipartUploadRequest.bucket());  
        } else {  
            assertEquals(expectedEncodedContext, request.ssekmsEncryptionContext());
        final boolean useSseKms = randomBoolean();
            when(blobStore.serverSideEncryptionEncryptionContext()).thenReturn(kmsContext);
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);  
        final AmazonAsyncS3Reference amazonAsyncS3Reference = new AmazonAsyncS3Reference(
                    done = true; // emit once
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
 * The OpenSearch Contributors require contributions made to  
                public void onResponse(List<BlobMetadata> blobMetadata) {
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        assertFalse(e instanceof BlobVersionConflictException);
                return response;  
                verify(client, times(1)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));  
        public ListObjectsV2Response next() {
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));
        assertNotNull(exceptionRef.get().getCause());
    }  
        when(blobStore.getStorageClass()).thenReturn(storageClass);  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);  
        assertEquals(eTag, blob.versionToken());  
                }  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
     */  
            return null;  
import java.io.InputStream;  
        List<String> blobNames = Arrays.asList("blob1", "blob2", "blob3");
        });
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        when(blobStore.getBulkDeletesSize()).thenReturn(1000);  
            expectedEncodedContext = null;
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();  
            () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(payload), payload.length, null)
        } while (totalBytes < blobSize);
import org.opensearch.common.io.InputStreamContainer;
        assertThat(S3BlobStore.initStorageClass("oNeZoNe_iA"), equalTo(StorageClass.ONEZONE_IA));  
                .uploadId(uploadId)
        CompletableFuture<GetObjectAttributesResponse> getObjectAttributesResponseCompletableFuture = new CompletableFuture<>();
        final int totalPageCount = 3;  
        final BlobPath blobPath = new BlobPath();
            IOException.class,  
    public void testInitCannedACL() {
        public MockListObjectsV2ResponseIterator(
                public void request(long n) {
            // Mock a properly formatted JSON encryption context  
        assertEquals(expectedToken, captor.getValue().ifMatch());
 *  
        assertEquals(totalObjects * 100L, result.bytesDeleted());  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        when(asyncClientReference.get()).thenReturn(amazonAsyncS3WithCredentials);  
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
    private void mockObjectPartResponse(
                latch.countDown();
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
            IOException.class,
        }
                null,
            });
        }  
        final S3BlobContainer blobContainer = conditionalWriteContainer(
                }
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);  
        when(blobStore.getBulkDeletesSize()).thenReturn(bulkDeleteSize);
        int totalBlobsDeleted = deleteRequestCaptor.getAllValues()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        );
        getObjectPartResponse.complete(responseInputStream);  
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);  
        final IOException read = expectThrows(IOException.class, () -> blobContainer.readBlobWithVersion("fence"));  
        // Fits in 1 part exactly
        final BlobPath blobPath = new BlobPath();
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final Tuple<Long, Long> numberOfParts = S3BlobContainer.numberOfMultiparts(blobSize, bufferSize);
                assertArrayEquals(expectedBytes, actualBytes);
            }  
        when(
            () -> blobContainer.executeMultipartUpload(blobStore, randomAlphaOfLengthBetween(1, 10), null, blobSize, null, null)
            @Override
        final int objectSize = 100;
        assertEquals(1, readContext.getNumberOfParts());
        }
import software.amazon.awssdk.core.sync.RequestBody;
            s3Objects.add(S3Object.builder().key(randomAlphaOfLength(10)).size(size).build());
        // Fits in N parts plus a bit more
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(failedFuture);  
 * ownership. Elasticsearch licenses this file to you under  
            null
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
    public void testReadBlobAsyncMultiPart() throws Exception {
        when(blobStore.clientReference()).thenReturn(new AmazonS3Reference(client));
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;  
        assertTrue(latch.await(5, TimeUnit.SECONDS));  
        }
        when(blobStore.clientReference()).thenReturn(clientReference);
import org.opensearch.common.blobstore.BlobContainer;
                }
        // Mock deleteObjects to block indefinitely  
    }  
        final byte[] exactlyAtBound = randomByteArrayOfLength((int) sizeBound);
        final boolean useBucketKey = randomBoolean();  
                    }  
    public void testListBlobsByPrefixInLexicographicOrderWithLimitGreaterThanPageSize() throws IOException {
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(  
    private static class CountingCompletionListener<T> implements ActionListener<T> {
            SdkException.create("Expected upload part request to fail", new RuntimeException()),
            return null;
        final String kmsKeyId = randomAlphaOfLength(10);  
                latch.countDown();
        assertEquals(simulatedError, e.getCause());
        testListBlobsByPrefixInLexicographicOrder(5, 1, BlobContainer.BlobNameSortOrder.LEXICOGRAPHIC);
        final ArgumentCaptor<CreateMultipartUploadRequest> createMultipartUploadRequestArgumentCaptor = ArgumentCaptor.forClass(
        final ArgumentCaptor<AbortMultipartUploadRequest> argumentCaptor = ArgumentCaptor.forClass(AbortMultipartUploadRequest.class);
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            public void onFailure(Exception e) {  
    /**
                any(GetObjectRequest.class),
        if (useSseKms) {
        assertEquals(objectSize, readContext.getBlobSize());  
                .build()
        when(blobStore.expectedBucketOwner()).thenReturn(null);
        final S3BlobContainer blobContainer = conditionalWriteContainer(captor, PutObjectResponse.builder().eTag(eTag).build(), null);
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);  
        );
    }  
        );
        when(blobStore.bucket()).thenReturn(randomAlphaOfLengthBetween(1, 10));
            }  
    public void testGetBlobPartInputStream() throws Exception {  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
import org.opensearch.core.common.unit.ByteSizeUnit;
                }
            final S3BlobContainer blobContainer = conditionalWriteContainer(
 *
    private S3BlobContainer conditionalWriteContainer(
            null
            blobNames.add(randomAlphaOfLength(10));
        verify(s3AsyncClient, times(1)).listObjectsV2Paginator(any(ListObjectsV2Request.class));
        );  
            Subscriber<? super ListObjectsV2Response> sub = invocation.getArgument(0);  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
                    subscriber.onError(new RuntimeException("Simulated listing error"));
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        assertEquals(blobPath.buildAsString() + blobName, completeMultipartUploadRequest.key());
            )
        assertEquals(checksum, readContext.getBlobChecksum());
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);
    public void testDelete() throws Exception {
        final String contentRange = "bytes 10-20/100";
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
            return null;  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);  
    private static class MockListObjectsV2ResponseIterator implements Iterator<ListObjectsV2Response> {
            null
            () -> blobContainer.writeBlobConditionally("fence", new ByteArrayInputStream(new byte[0]), blobSize, null)  
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        );
        }  
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);  
    public void testDeleteBlobsAsyncIgnoringIfNotExists() throws Exception {
            .stream()  
                ArgumentMatchers.<AsyncResponseTransformer<GetObjectResponse, ResponseInputStream<GetObjectResponse>>>any()
        final S3BlobContainer blobContainer = new S3BlobContainer(mock(BlobPath.class), blobStore);  
                fail("Expected a failure, but got a success response");  
        when(blobStore.bucket()).thenReturn(bucketName);  
        verify(client, times(1)).headObject(any(HeadObjectRequest.class));
                public void request(long n) {  
        final AmazonAsyncS3Reference amazonAsyncS3Reference = new AmazonAsyncS3Reference(  
        private final AtomicInteger currInvocationCount = new AtomicInteger();
                public void request(long n) {
        final S3BlobStore blobStore = mock(S3BlobStore.class);
            public void onResponse(DeleteResult deleteResult) {
        assertEquals(metadata, initRequest.metadata());  
        // Wait for publisher to complete  
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
            s3AsyncClient,
            s3AsyncClient,
        List<ListObjectsV2Response> responses = new ArrayList<>();
        @Override
        assertEquals("Failed to initiate async deletion", exceptionRef.get().getMessage());
        assertNull(captor.getValue().ifMatch());
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
            this.response = response;
        final BlobPath blobPath = new BlobPath();
            });
    }
            s3AsyncClient,  
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 64));
        assertEquals(blobSize, request.contentLength().longValue());  
        when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());
    public void testTransformResponseToInputStreamContainer() throws Exception {  
    public void testDeleteAsyncDeletionError() throws Exception {
        assertEquals(CompletionException.class, exceptionRef.get().getClass());
        assertNumberOfMultiparts(factor, size, size * factor, size);  
            CreateMultipartUploadRequest.class  
        assertEquals(IOException.class, exceptionRef.get().getClass());
            GetObjectAttributesResponse.builder()
                null  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);  
            .collect(Collectors.toList());
        final long contentLength = 10L;
        final BlobPath blobPath = new BlobPath();
            assertEquals(payload.length, actual.length);
import org.opensearch.common.blobstore.DeleteResult;
    public void testWriteBlobConditionallyDoesNotTreatRetryableConflictsAsLostCas() {
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
    }
 */  
            when(blobStore.serverSideEncryptionKmsKey()).thenReturn(kmsKeyId);
        final String bucketName = randomAlphaOfLengthBetween(1, 10);
        final ArgumentCaptor<GetObjectRequest> captor = ArgumentCaptor.forClass(GetObjectRequest.class);  
import static org.hamcrest.Matchers.equalTo;
        assertEquals(storageClass, request.storageClass());
            when(blobStore.serverSideEncryptionBucketKey()).thenReturn(useBucketKey);
        );
        );
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
        final AmazonS3Reference clientReference = new AmazonS3Reference(client);
    public void testBlobExists() {  
        List<S3Object> allObjects = new ArrayList<>();
                final UploadPartRequest request = (UploadPartRequest) invocationOnMock.getArguments()[0];
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
                BlobVersionConflictException.class,
            }  
        final InputStream inputStream = ResponseInputStream.nullInputStream();  
    public void testListBlobsByPrefixInLexicographicOrderWithLimitGreaterThanNumberOfRecords() throws IOException {  
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
            when(client.completeMultipartUpload(any(CompleteMultipartUploadRequest.class))).thenThrow(exceptions.get(stage));
        long totalBytes = 0;  
        );
        assertEquals(1, readContextActionListener.getFailureCount());  
        assertEquals(10, inputStreamContainer.getOffset());  
        when(blobStore.bucket()).thenReturn(bucketName);  
                .objectParts(GetObjectAttributesParts.builder().totalPartsCount(objectPartCount).build())
                @Override
                verify(client, times(0)).completeMultipartUpload(any(CompleteMultipartUploadRequest.class));  
            .parts()
import static org.mockito.Mockito.times;
        assertEquals(cannedAccessControlList, initRequest.acl());
            .uploadId(randomAlphaOfLength(10))  
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(
            if (stage == 1) {
        assertNull(captor.getValue().ifNoneMatch());
                @Override
        final String blobName = randomAlphaOfLengthBetween(1, 10);
        metadata.put("key1", "value1");  
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
        });  
        );
        if (stage == 0) {
            S3Exception.builder().statusCode(500).message("boom").build()  
            final String kmsContext = "{\"repo\":\"test\"}";  
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);  
        for (int i = 0; i < uploadRequests.size(); i++) {
        final BlobPath blobPath = new BlobPath();  
        private final int s3ObjectsPerPage;
    }  
        assertThat(S3BlobStore.initStorageClass("standard"), equalTo(StorageClass.STANDARD));
        assertThat(ex.getMessage(), equalTo("`whatever` is not a valid S3 Storage Class."));
            });  
        when(blobStore.bufferSizeInBytes()).thenReturn(ByteSizeUnit.MB.toBytes(1));  
import software.amazon.awssdk.services.s3.model.S3Object;
            "fence",
     * mistaken for one.  
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);
            payload.length,
        when(blobStore.getStorageClass()).thenReturn(randomFrom(StorageClass.values()));
    public void testReadBlobWithVersionReturnsETagAsVersionToken() throws IOException {
        );
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);
            deleteCallCount.incrementAndGet();  
            this.throwExceptionOnNextInvocation = throwExceptionOnNextInvocation;
                .checksum(Checksum.builder().checksumCRC32(checksum).build())
        private final boolean throwExceptionOnNextInvocation;  
        final S3BlobContainer blobContainer = new S3BlobContainer(new BlobPath(), blobStore);
        assertEquals("Delete operation timed out after 30 seconds", ex.getMessage());
        RuntimeException simulatedError = new RuntimeException("Simulated delete error");  
        final BlobPath blobPath = new BlobPath();
        if (limit >= 0) {
                .objectSize(objectSize)
            @Override  
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());  
        assertEquals(simulatedFailure, exceptionRef.get().getCause());
/*  
            s3AsyncClient,
            CompleteMultipartUploadRequest.class  
            assertThat(acl.toString(), equalTo(aclString));
            assertEquals(ServerSideEncryption.AES256, request.serverSideEncryption());
            InputStreamContainer inputStreamContainer = readContext.getPartStreams().get(partNumber).get().join();  
        when(s3AsyncClient.listObjectsV2Paginator(any(ListObjectsV2Request.class))).thenReturn(listPublisher);
            expectThrows(  
        when(blobStore.asyncClientReference()).thenReturn(asyncClientReference);
        CompletableFuture<ResponseInputStream<GetObjectResponse>> getObjectPartResponse = new CompletableFuture<>();
        LatchedActionListener<ReadContext> listener = new LatchedActionListener<>(readContextActionListener, countDownLatch);
        final IllegalArgumentException e = expectThrows(
        final S3Client client = mock(S3Client.class);
        }  
                        )
            s3AsyncClient,
        assertEquals(blobPath.buildAsString() + blobName, request.key());
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
        assertEquals("Unable to upload object [" + blobName + "] using multipart upload", e.getMessage());  
        }).when(listPublisher).subscribe(ArgumentMatchers.<Subscriber<ListObjectsV2Response>>any());  
        final String uploadId = randomAlphaOfLength(25);
        final ObjectCannedACL cannedAccessControlList = randomBoolean() ? randomFrom(ObjectCannedACL.values()) : null;
                        keysComparator = Collections.reverseOrder(String::compareTo);
                    }  
        final List<String> expectedEtags = new ArrayList<>();
 * software distributed under the License is distributed on an
        GetObjectResponse getObjectResponse = GetObjectResponse.builder().contentLength(contentLength).contentRange(contentRange).build();
                exceptionRef.set(e);
import software.amazon.awssdk.services.s3.S3AsyncClient;  
                        .collect(Collectors.toList());
        );
            assertEquals(createMultipartUploadResponse.uploadId(), uploadPartRequest.uploadId());
        // empty acl
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
    }
        // We expect half of the objects to be deleted successfully  
        do {
        final S3BlobContainer blobContainer = new S3BlobContainer(blobPath, blobStore);
        blobContainer.readBlobAsync(blobName, listener);
                latch.countDown();
                        subscriber.onComplete();
                exceptionRef.set(e);
            null  
    }  
        MockListObjectsV2ResponseIterator iterator = new MockListObjectsV2ResponseIterator(2, 5, 100);
            Subscriber<? super ListObjectsV2Response> subscriber = invocation.getArgument(0);  
        assertEquals(allObjects.size(), result.blobsDeleted());
            s3AsyncClient,  
        );
            }  
        // create-if-absent: even NoSuchKey is not a precondition verdict
                    }
        assertEquals(0, readContextActionListener.getResponseCount());
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AWS_KMS.toString());
        final CreateMultipartUploadResponse createMultipartUploadResponse = CreateMultipartUploadResponse.builder()
        GetObjectResponse getObjectResponse = GetObjectResponse.builder().contentLength(contentLength).build();
    }  
import org.mockito.ArgumentMatchers;  
        final BlobPath blobPath = new BlobPath();  
                final UploadPartResponse response = UploadPartResponse.builder().eTag(randomAlphaOfLength(20)).build();
        blobContainer.deleteAsync(new ActionListener<>() {  
 * not use this file except in compliance with the License.
        final S3BlobStore blobStore = mock(S3BlobStore.class);
        // Simulate a failure in deleteObjects  
                }  
                @Override  
        // If-Match, but the 404 does not prove the key is gone  
        final String bucketName = randomAlphaOfLengthBetween(1, 10);  
        inputStreamContainer = S3BlobContainer.transformResponseToInputStreamContainer(responseInputStream, true);
        }  
        final byte[] payload = randomByteArrayOfLength(randomIntBetween(1, 512));  
        );
    public void testNumberOfMultipartsWithZeroPartSize() {  
            final int start = (partNumber - 1) * partSize;
            @Override  
                public void onFailure(Exception e) {
        final S3BlobStore blobStore = mock(S3BlobStore.class);  
import software.amazon.awssdk.core.ResponseBytes;
            @Override  
                            .message("Simulated error")
            return null;
        private final long s3ObjectSize;
        when(s3AsyncClient.deleteObjects(any(DeleteObjectsRequest.class))).thenReturn(failedFuture);
        final ListObjectsV2Publisher listPublisher = mock(ListObjectsV2Publisher.class);  
                blobName,
        assertEquals(inputStream.available(), inputStreamContainer.getInputStream().available());
            "public-read-write",
        try (InputStream is = requestBody.contentStreamProvider().newStream()) {
        latch.await();  
        final S3AsyncClient s3AsyncClient = mock(S3AsyncClient.class);  
        if (useSseKms) {
        final AmazonAsyncS3Reference asyncClientReference = mock(AmazonAsyncS3Reference.class);
        final int objectPartCount = 10;
        doAnswer(invocation -> {
    public void testNumberOfMultiparts() {
                ByteSizeUnit.MB.toBytes(2),
        when(blobStore.bucket()).thenReturn(bucketName);
            ObjectCannedACL acl = S3BlobStore.initCannedACL(awsList.toString());
                        subscriber.onNext(responses.get(currentCounter));
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());
        final int s3ObjectsPerPage = 5;
        CompletableFuture<GetObjectAttributesResponse> getObjectAttributesResponseCompletableFuture = new CompletableFuture<>();
        assertEquals(IOException.class, exceptionRef.get().getClass());
        // Fits in 1 empty part
    }  
        assertFalse(write instanceof BlobVersionConflictException);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());  
        final long bufferSize = ByteSizeUnit.MB.toBytes(randomIntBetween(5, 1024));
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;
        BlobStoreException ex = expectThrows(BlobStoreException.class, () -> S3BlobStore.initStorageClass("whatever"));  
        assertEquals(Integer.valueOf(objectPartCount), objectAttributesResponse.objectParts().totalPartsCount());  
        assertEquals("Simulated listing error", exceptionRef.get().getCause().getMessage());
                @Override
    public void testListBlobsByPrefixInLexicographicOrderWithZeroLimit() throws IOException {  
    }
        final AtomicBoolean hasEmittedItem = new AtomicBoolean(false);
        when(blobStore.getStatsMetricPublisher()).thenReturn(new StatsMetricPublisher());  
        DeleteResult result = resultRef.get();  
            s3AsyncClient,  
        assertEquals(10, listOfBlobs.size());
                exceptionRef.set(e);
        final BlobPath blobPath = new BlobPath();  
            when(blobStore.serverSideEncryptionType()).thenReturn(ServerSideEncryption.AES256.toString());  
            public void onResponse(Void aVoid) {  
            // Mock a properly formatted JSON encryption context
        AmazonAsyncS3WithCredentials amazonAsyncS3WithCredentials = AmazonAsyncS3WithCredentials.create(  
        // 0 offset in case of a single part object request
        final String blobName = randomAlphaOfLengthBetween(1, 10);
    public void testBlobExistsRequestFailure() {
