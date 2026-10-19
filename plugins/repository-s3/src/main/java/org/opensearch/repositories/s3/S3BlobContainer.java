        if (blobSize > MAX_FILE_SIZE.getBytes()) {
                && blobStore.getLowPrioritySizeBasedBlockingQ().isMaxCapacityBelowContentLength(uploadRequest.getContentLength()) == false)
        String blobKey,
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable;
     * the precondition holds against writers in any process and on any host - which is what makes this container usable
        }
            return false;
        if (blobSize > blobStore.bufferSizeInBytes()) {
import static org.opensearch.repositories.s3.utils.SseKmsUtil.configureEncryptionSettings;
        deleteAsync(future);
                    s3AsyncClient = amazonS3Reference.get().client();
     * @param partNumber Optional part number for the blob to be retrieved
            blobStore.isUploadRetryEnabled(),
            requestInputStream = new BufferedInputStream(input, (int) (partSize + 1));
    public boolean isConditionalWriteSupported() {
                public void onError(Throwable t) {
        return AccessController.doPrivileged(() -> {
        @Nullable Map<String, String> metadata
            if (blobSize <= getLargeBlobThresholdInBytes()) {
            }
                            () -> subscription.request(1)
     * {@code ConditionalRequestConflict}, which S3 returns when a concurrent conditional write on the same key is
import org.opensearch.repositories.s3.async.UploadRequest;
            } else {
                AbortMultipartUploadRequest abortRequest = AbortMultipartUploadRequest.builder()
                .collect(Collectors.toMap(Function.identity(), name -> blobStore.blobContainer(path().add(name))));
            .build();
                            listingFuture.completeExceptionally(throwable);
            .build();
     * {@code FsBlobContainer#writeBlobConditionally}, which also reports a conflict for a missing blob. A 404 without
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
     * @param bucketName Name of the S3 bucket
import software.amazon.awssdk.core.ResponseInputStream;
            return true;
import org.opensearch.common.blobstore.BlobPath;
     * writer, so only errors that prove the precondition was evaluated and NOT MET are classified as a lost CAS:
    long getLargeBlobThresholdInBytes() {
                throw new IOException("[" + blobName + "] blob of size > [" + sizeBound + "] is too large for a versioned read");
            .range("bytes=0-" + sizeBound)
    public List<BlobMetadata> listBlobsByPrefixInSortedOrder(String blobNamePrefix, int limit, BlobNameSortOrder blobNameSortOrder)
                    s3AsyncClient = amazonS3Reference.get().urgentClient();
        final String errorCode = e.awsErrorDetails() == null ? null : e.awsErrorDetails().errorCode();
class S3BlobContainer extends AbstractBlobContainer implements AsyncMultiStreamBlobContainer {
                    );
                            blobStore,
        // As AWS S3 returns list of keys in Lexicographic order, we don't have to fetch all the keys in order to sort them
        // Delegate to crypto-aware version with null CryptoMetadata
    }
     * Distinguishes a genuinely lost compare-and-swap from a transient conflict. Losing the CAS is fatal for a fenced
                    }
        ListObjectsV2Request listObjectsRequest,
                throw (IOException) e.getCause();
import software.amazon.awssdk.services.s3.model.GetObjectAttributesRequest;
        long blobSize,
        if (CollectionUtils.isNotEmpty(metadata)) {
        if ((totalSize == 0L) || (totalSize <= partSize)) {
            }
            if (content.length > sizeBound) {
        // We fetch only keys as per the given limit to optimize the fetch. If provided sort order is not Lexicographic,
            return new S3RetryingInputStream(blobStore, buildKey(blobName), position, Math.addExact(position, length - 1));
                @Override
    }
            throw new IOException("Unable to conditionally upload object [" + blobName + "]", e);
            AccessController.doPrivileged(() -> clientReference.get().completeMultipartUpload(completeMultipartUploadRequest));
        final long lastPartSize = multiparts.v2();
    private String buildKey(String blobName) {
            }
     * @param s3AsyncClient Async client to be utilized to fetch the object part
                        HeadObjectRequest.builder()
            .storageClass(blobStore.getStorageClass())
        }
    }
                .calculateOptimalPartSize(writeContext.getFileSize(), writeContext.getWritePriority(), blobStore.isUploadRetryEnabled());
/*
import java.util.Set;
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
        final long blobSize,
                        ? (Exception) throwable.getCause()
        if (length < 0) {
            S3AsyncClient s3AsyncClient = asyncClientReference.get().client();
                    } else {
                        );
                    return false;
                if (limit != -1 && totalObjects >= limit) {
        final InputStream input,
        }
                .filter(name -> name.isEmpty() == false)
     * {@code NoSuchKey} (e.g. {@code NoSuchBucket}) stays an ordinary {@link IOException}, and a create-if-absent
     * Write blob with its object metadata.
                            logger.debug("Successfully completed deletion chain for path [{}]", keyPath);
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
        deleteBlobsAsyncIgnoringIfNotExists(blobNames, future);
                @Override
    ) {
                @Override
                            return true;
 * not use this file except in compliance with the License.
    private ListObjectsV2Request listObjectsRequest(String keyPath, int limit) {
     */
                    this.subscription = s;
            // create-if-absent
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
                throw new IOException("Exception when listing blobs by prefix [" + prefix + "]", e);
 * The OpenSearch Contributors require contributions made to
        if (expectedVersionToken == null) {
        String mergeEncContext = SseKmsUtil.mergeAndEncodeEncryptionContexts(
                }
                } else if (writeContext.getWritePriority() == WritePriority.LOW) {
            completionListener.onFailure(new IOException("Failed to initiate async blob deletion", e));
            return future.get(DEFAULT_OPERATION_TIMEOUT, TimeUnit.SECONDS);
    }
    public boolean remoteIntegrityCheckSupported() {
        } catch (final SdkException e) {
        }
                return;
            .acl(blobStore.getCannedACL())
                    );
            blobStore.serverSideEncryptionType(),
    }
 * license agreements. See the NOTICE file distributed with
        final long partSize = blobStore.bufferSizeInBytes();
    public Map<String, BlobMetadata> listBlobs() throws IOException {
        } catch (S3Exception e) {
    }
        } catch (SdkException e) {
            writeContext.getUploadFinalizer(),
            }
        writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, metadata, null);
        }
    void executeMultipartUpload(
                            uploadRequest.getKey(),
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
    }
        final long parts = totalSize / partSize;
                    "conditional write conflict for blob [" + blobName + "]: expected [" + expectedVersionToken + "]",
import software.amazon.awssdk.services.s3.model.ObjectAttributes;
    public VersionedBlob readBlobWithVersion(String blobName) throws IOException {
    }
                    .contentLength((i < nbParts) ? partSize : lastPartSize)
            return Tuple.tuple(1L, totalSize);
            S3AsyncDeleteHelper.executeDeleteChain(s3AsyncClient, blobStore, keysToDelete, CompletableFuture.completedFuture(null), null)
     * Uploads a blob using multipart upload requests.
                );
        final long blobSize,
            completionListener.onResponse(null);
                    if (throwable != null) {
                @Override
        int limit
                }
    }
            putObjectRequestBuilder.ifMatch(expectedVersionToken);
        }
            if (limit < 0) {
        // ETag); an object at this key that exceeds the bound - misuse or corruption - is refused below instead of
        String bucketName,
                            .build()
    @ExperimentalApi
        return executeListing(clientReference, listObjectsRequest, -1);
                () -> clientReference.get().putObject(putObjectRequest, RequestBody.fromInputStream(inputStream, blobSize))
 * You may obtain a copy of the License at
            );
        boolean success = false;
import org.opensearch.common.blobstore.stream.write.WriteContext;
                } else if (writeContext.getWritePriority() == WritePriority.NORMAL) {
        CryptoMetadata crypto = writeContext.getCryptoMetadata();
     * S3 evaluates {@code If-Match} and {@code If-None-Match} server-side and serializes conditional writes per key, so
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     */
                            listingFuture.complete(null);
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
import org.opensearch.repositories.s3.async.SizeBasedBlockingQ;
        });
            throw SdkException.builder().message("Failed to fetch required metadata for blob part").build();
        // Versioned reads materialize the object in memory and are meant for small control blobs only. The ranged GET
import software.amazon.awssdk.services.s3.model.GetObjectAttributesResponse;
                } else {
                    .flatMap(listing -> listing.contents().stream())
     * @param bucketName Name of the S3 bucket
import org.opensearch.common.blobstore.support.AbstractBlobContainer;
        final Map<String, String> metadata,
                        List<String> batchToDelete = new ArrayList<>(objectsToDelete.subList(0, itemsToDelete));
                        } else {
import org.reactivestreams.Subscriber;
                public void onSubscribe(Subscription s) {
        // being buffered whole.
        }
                                writeContext.getFileSize(),
                    }
        }
            }
        String prefix = blobNamePrefix == null ? keyPath : buildKey(blobNamePrefix);
                    && blobStore.getNormalPrioritySizeBasedBlockingQ()
            final InputStream requestInputStream;
            int totalObjects = 0;
                    completionListener.onFailure(
        throws IOException {
        return new S3RetryingInputStream(blobStore, buildKey(blobName));
        CreateMultipartUploadRequest createMultipartUploadRequest = createMultipartUploadRequestBuilder.build();
                    });
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
                    deletionChain.whenComplete((v, throwable) -> {
                        deletionChain = S3AsyncDeleteHelper.executeDeleteChain(
                executeSingleUpload(blobStore, buildKey(blobName), inputStream, blobSize, metadata, cryptoMetadata);
                .thenApply(response -> transformResponseToInputStreamContainer(response, isMultipartObject))
    /**
            AccessController.doPrivileged(
            if (throwable == null) {
                    logger.debug(
        if (isMultipartObject) {
                        int fullBatchesCount = objectsToDelete.size() / bulkDeleteSize;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import org.opensearch.common.util.concurrent.FutureUtils;
        } catch (InterruptedException e) {
            return results;
    /**
                    .expectedBucketOwner(blobStore.expectedBucketOwner())
                final UploadPartResponse uploadResponse = AccessController.doPrivileged(
            createMultipartUploadRequestBuilder.metadata(metadata);
            if (e.getCause() instanceof IOException) {
            throw new RuntimeException(e.getCause());
        } else {
            completionListener.onFailure(new IOException("Failed to initiate async deletion", e));
    /**
        return blobStore.bufferSizeInBytes();
                            );
    }
            .key(blobName)
import java.io.IOException;
            throw new IllegalArgumentException("Conditional write request size [" + blobSize + "] can't be larger than buffer size");
    }
                if (throwable != null) {
    /**
import org.opensearch.common.Nullable;
                    }
            throw new IllegalArgumentException("length must be non-negative");
                    listener.onFailure(ex);
    /**
                            blobPartInputStreamFutures.add(
                }
    }
        }
/*
            );
        PlainActionFuture<DeleteResult> future = new PlainActionFuture<>();
    public Map<String, BlobMetadata> listBlobsByPrefix(@Nullable String blobNamePrefix) throws IOException {
        final String blobName,
            throw new IllegalArgumentException(
                final UploadPartRequest uploadPartRequest = UploadPartRequest.builder()
    }
    public void deleteBlobsAsyncIgnoringIfNotExists(List<String> blobNames, ActionListener<Void> completionListener) {
    private final S3BlobStore blobStore;
            return super.listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder);
import java.util.concurrent.TimeoutException;
        return getFutureValue(future);
        } catch (Exception e) {
     * @return a {@link Tuple} containing the number of parts to fill {@code totalSize} and
        boolean failIfAlreadyExists,
        );
        ensureMultiPartUploadSize(blobSize);
        }
        }
 * Unless required by applicable law or agreed to in writing,
    }
                }
            listingFuture.whenComplete((v, throwable) -> {
            CompleteMultipartUploadRequest completeMultipartUploadRequest = CompleteMultipartUploadRequest.builder()
     * write only - a 404 carrying {@code NoSuchKey}. S3 fails an {@code If-Match} write with 404 rather than 412 when
            mergeEncContext,
                        // S3 multipart files use 1 to n indexing
        final int nbParts = multiparts.v1().intValue();
                    || blobStore.isPermitBackedTransferEnabled() == false) {
/*
    @Override
     * the stream and its related metadata.
 * specific language governing permissions and limitations
        long blobSize,
    @Override
                        () -> new ParameterizedMessage(
            final PutObjectResponse response = AccessController.doPrivileged(
                .whenComplete((v, throwable) -> {
                        }
            .expectedBucketOwner(blobStore.expectedBucketOwner());
    S3BlobContainer(BlobPath path, S3BlobStore blobStore) {
                    .bucket(bucketName)
        if (CollectionUtils.isNotEmpty(metadata)) {
                    "Failed to execute multipart upload for [" + blobName + "], expected " + blobSize + "bytes sent but got " + bytesCount
                            )
                        }
                        blobStore,
            if (bytesCount != blobSize) {
        if (partSize <= 0) {
                        "Completed listing objects for path [{}], remaining objects to delete: {}",
    @Override
    CompletableFuture<InputStreamContainer> getBlobPartInputStreamContainer(
            return response.eTag();
        ResponseInputStream<GetObjectResponse> streamResponse,
     * @param streamResponse Response stream object from S3
                executeMultipartUpload(blobStore, buildKey(blobName), inputStream, blobSize, metadata, cryptoMetadata);
    ) {
                S3AsyncClient s3AsyncClient;
        boolean failIfAlreadyExists,
        UploadRequest uploadRequest = new UploadRequest(
        final S3BlobStore blobStore,
    @Override
import software.amazon.awssdk.utils.CollectionUtils;
import java.nio.file.NoSuchFileException;
            requestInputStream = input;
        } catch (final Exception e) {
        return new ByteSizeValue(32, ByteSizeUnit.MB).getBytes();
                    if (objectsToDelete.size() >= bulkDeleteSize) {
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
                if (writeContext.getWritePriority() == WritePriority.URGENT) {
    static Tuple<Long, Long> numberOfMultiparts(final long totalSize, final long partSize) {
        }
    }
    }
import org.opensearch.common.io.InputStreamContainer;
            final String blobKey = buildKey(blobName);
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
                        for (int partNumber = 1; partNumber <= numberOfParts; partNumber++) {
        } catch (Exception ex) {
                    break;
        // bounds the transfer to the same limit the write side enforces (a ranged GET still returns the object's
import java.io.ByteArrayInputStream;
import org.opensearch.core.common.Strings;
                requestInputStream = input;
            S3AsyncClient s3AsyncClient = asyncClientReference.get().client();
        return new InputStreamContainer(streamResponse, getObjectResponse.contentLength(), offset);
                    .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().multipartUploadMetricCollector))
        }
                        .uploadPart(uploadPartRequest, RequestBody.fromInputStream(requestInputStream, uploadPartRequest.contentLength()))
                        );
     * @param isMultipartObject Flag to denote a multipart object response
                    });
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;
                        logger.debug("Executing bulk delete of {} objects for path [{}]", batchToDelete.size(), keyPath);
        final long remaining = totalSize % partSize;
                private Subscription subscription;
    /**
import org.opensearch.common.blobstore.stream.read.ReadContext;
        try (AmazonAsyncS3Reference asyncClientReference = blobStore.asyncClientReference()) {
    }
                completionListener.onFailure(ex);
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
        CreateMultipartUploadRequest.Builder createMultipartUploadRequestBuilder = CreateMultipartUploadRequest.builder()
import org.opensearch.common.collect.Tuple;
    @Override
        PutObjectRequest putObjectRequest = putObjectRequestBuilder.build();
        return completableFuture.whenComplete((response, throwable) -> {
import software.amazon.awssdk.services.s3.model.UploadPartResponse;
    @Override
     * This implementation ignores the failIfAlreadyExists flag as the S3 API has no way to enforce this due to its weak consistency model.
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
                            .expectedBucketOwner(blobStore.expectedBucketOwner())
            try (AmazonS3Reference clientReference = blobStore.clientReference()) {
        String blobName,
     * ({@code If-None-Match: *}) never 404s on the object itself. Every other 409 - including
import java.util.Map;
            // If file size is greater than the queue capacity than SizeBasedBlockingQ will always reject the upload.
    private static List<ListObjectsV2Response> executeListing(
        } catch (final SdkException e) {
                    listingFuture.completeExceptionally(new IOException("Failed to list objects for deletion", t));
        }
    ) {
                    AccessController.doPrivileged(() -> clientReference.get().abortMultipartUpload(abortRequest));
            .expectedBucketOwner(blobStore.expectedBucketOwner());
    public void writeBlobWithMetadata(
                () -> clientReference.get()
        getFutureValue(future);
    @Override
    @Override
        try {
        CompletableFuture<Void> completableFuture = blobStore.getAsyncTransferManager()
                    if (numberOfParts == null) {
                try {
import org.opensearch.common.blobstore.BlobStoreException;
        super(path);
    }
    }
            logger.error(() -> new ParameterizedMessage("Failed to initiate async deletion for path [{}]", keyPath), e);
        configureEncryptionSettings(putObjectRequestBuilder, blobStore, null);
        } catch (Exception e) {
            .key(blobKey)
    /**
                        ),
                            )
                        deletedBlobs.get(),
import org.opensearch.core.action.ActionListener;
    }
    @Override
import software.amazon.awssdk.core.async.AsyncResponseTransformer;
import org.opensearch.common.SetOnce;
                "Multipart upload request size [" + blobSize + "] can't be smaller than " + MIN_PART_SIZE_USING_MULTIPART
            .expectedBucketOwner(blobStore.expectedBucketOwner())
        @Nullable Map<String, String> metadata,
            .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().putObjectMetricPublisher))
        final GetObjectRequest getObjectRequest = GetObjectRequest.builder()
            .expectedBucketOwner(blobStore.expectedBucketOwner())
                    blobStore.getLowPrioritySizeBasedBlockingQ()
            .bucket(blobStore.bucket())
            indexKmsKey = crypto.getKeyArn().orElse(null);
                }
            throw new IllegalArgumentException("Upload request size [" + blobSize + "] can't be larger than buffer size");
                    () -> writeContext.getStreamProvider(uploadRequest.getContentLength())
            return false;
        final Long contentLength = getObjectResponse.contentLength();
            return new VersionedBlob(content, responseBytes.response().eTag());
                        );
                    .uploadId(uploadId.get())
            CompletableFuture<Void> listingFuture = new CompletableFuture<>();
        final String bucketName = blobStore.bucket();
                    return;
        }
            });
    void executeSingleUpload(
                    blobStore.getNormalPrioritySizeBasedBlockingQ()
        StreamContext streamContext,
        if (blobNameSortOrder != BlobNameSortOrder.LEXICOGRAPHIC) {
        try (AmazonAsyncS3Reference asyncClientReference = blobStore.asyncClientReference()) {
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicLong;
     * ordinary {@link IOException} and be retried: the retry resolves it definitively (a 412 if the CAS was genuinely
            for (ListObjectsV2Response listObjectsV2Response : listObjectsIterable) {
    // Package-Private for testing.
    public long readBlobPreferredLength() {
        }
            .bucket(blobStore.bucket())
            if ((uploadRequest.getWritePriority() == WritePriority.LOW
                bytesCount += uploadPartRequest.contentLength();
                    completionListener.onFailure(ex);
     * Fetches a part of the blob from the S3 bucket and transforms it to an {@link InputStreamContainer}, which holds
                        deletedBytes.addAndGet(s3Object.size());
            // If-Match against a key with no current version. NoSuchKey is required: a 404 without it (NoSuchBucket,
                            objectsToDelete,
                    .expectedBucketOwner(blobStore.expectedBucketOwner())
        if (position < 0L) {
                }
                            s3AsyncClient,
    ) throws IOException {
                    createFileCompletableFuture(s3AsyncClient, uploadRequest, streamContext, completionListener);
    public void deleteAsync(ActionListener<DeleteResult> completionListener) {
            if ((success == false) && Strings.hasLength(uploadId.get())) {
     * a 412, with or without an error code, a 409 carrying {@code PreconditionFailed}, or - for an {@code If-Match}
 *
            return executeListing(clientReference, listObjectsRequest(keyPath)).stream().flatMap(listObjectsResponse -> {
                    .key(blobName)
                        keyPath,
    }
                        if (throwable != null) {
                }
                // Stripping the trailing slash off of the common prefix
            .contentLength(blobSize)
                throw new BlobVersionConflictException(
            indexKmsKey != null ? indexKmsKey : blobStore.serverSideEncryptionKmsKey(),
    }
        return listObjectsRequest(keyPath).toBuilder().maxKeys(Math.min(limit, 1000)).build();
            try (AmazonAsyncS3Reference amazonS3Reference = AccessController.doPrivileged(blobStore::asyncClientReference)) {
                    }
            .key(buildKey(blobName))
            throw new IOException("Delete operation timed out after 30 seconds", e);
    @Override
                    .build();
            throw new NoSuchFileException("[" + blobName + "] blob not found");
    private static List<ListObjectsV2Response> executeListing(AmazonS3Reference clientReference, ListObjectsV2Request listObjectsRequest) {
        UploadRequest uploadRequest,
                        .produce(
                    int bulkDeleteSize = blobStore.getBulkDeletesSize();
        } finally {
import org.opensearch.secure_sm.AccessController;
        @Nullable CryptoMetadata cryptoMetadata
    CompletableFuture<GetObjectAttributesResponse> getBlobMetadata(S3AsyncClient s3AsyncClient, String bucketName, String blobName) {
        if (length == 0) {
        } catch (NoSuchKeyException e) {
            final String bucketName = blobStore.bucket();
            blobStore.serverSideEncryptionBucketKey(),
     * Transforms the stream response object from S3 into an {@link InputStreamContainer}
            .key(buildKey(blobName))
                .build();
        }
            // or an unlabelled response) is not evidence about the precondition and stays retryable.
            final ResponseBytes<GetObjectResponse> responseBytes = AccessController.doPrivileged(
        }
    }
import org.apache.logging.log4j.LogManager;
                        .produce(
                            "Failed to upload large file {} of size {} ",
            // Therefore, redirecting it to slow client.
            } catch (final Exception e) {
            uploadId.set(
        }
            .uploadObject(s3AsyncClient, uploadRequest, streamContext, blobStore.getStatsMetricPublisher());
                .key(blobName)
        if (blobNames.isEmpty()) {
    public Map<String, BlobContainer> children() throws IOException {
                }
                if (writeContext.getWritePriority() == WritePriority.URGENT
        return errorCode != null && CONDITIONAL_WRITE_CONFLICT_ERROR_CODES.contains(errorCode);
        PlainActionFuture<Void> future = new PlainActionFuture<>();
            .expectedBucketOwner(blobStore.expectedBucketOwner());
        if (remaining == 0) {
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
        S3AsyncClient s3AsyncClient,
                        uploadRequest.getContentLength(),
    }
        assert blobSize == (((nbParts - 1) * partSize) + lastPartSize) : "blobSize does not match multipart sizes";
        }
                    listener.onResponse(new ReadContext.Builder(blobSize, blobPartInputStreamFutures).blobChecksum(blobChecksum).build());
            );
                            final int innerPartNumber = partNumber;
                () -> clientReference.get().putObject(putObjectRequest, RequestBody.fromInputStream(requestInputStream, blobSize))
    @ExperimentalApi
        // Neither an unlabelled 409 nor a retryable conflict code is evidence that the precondition failed.
     * @param totalSize the total size
        } catch (SdkException e) {
                    .bucket(bucketName)
            })
            return;
            final List<CompletedPart> parts = new ArrayList<>();
 * Modifications Copyright OpenSearch Contributors. See
                            .bucket(blobStore.bucket())
            throw new IOException("Future got interrupted", e);
                    throw new IllegalStateException("Cannot perform upload for other priority types.");
 * GitHub history for details.
                    for (CommonPrefix commonPrefix : listObjectsResponse.commonPrefixes()) {
        final PutObjectRequest putObjectRequest = putObjectRequestBuilder.build();
        } catch (NoSuchKeyException e) {
                    listener.onFailure(ex);
                        }
                        deletedBlobs.incrementAndGet();
            throw new IOException("Unable to read object [" + blobName + "] with version", e);
        AccessController.doPrivilegedChecked(() -> {
    @Override
            long partSize = blobStore.getAsyncTransferManager()
    ) throws IOException {
            });
import software.amazon.awssdk.core.sync.RequestBody;
            .delimiter("/")
                StreamContext streamContext = AccessController.doPrivileged(
 */
     * @param s3AsyncClient Async client to be utilized to fetch the metadata
            throw new IOException("Exception when listing blobs by prefix [" + prefix + "]", e);
    /**
            return true;
                    logger.error(() -> new ParameterizedMessage("Failed to list objects for deletion in path [{}]", keyPath), t);
        // we fall-back to default implementation of fetching all the keys and sorting them.
 * this work for additional information regarding copyright
    @Override
                completionListener.onResponse(response);
            }
    }
        }
                    )
                            new SizeBasedBlockingQ.Item(
            return Tuple.tuple(parts, partSize);
        } catch (TimeoutException e) {
            }
        final String blobName,
                    }
 *
                private final List<String> objectsToDelete = new ArrayList<>();
                try (AmazonS3Reference clientReference = blobStore.clientReference()) {
        S3RetryingInputStream s3RetryingInputStream = new S3RetryingInputStream(blobStore, buildKey(blobName));
            getObjectRequestBuilder.partNumber(partNumber);
import software.amazon.awssdk.core.ResponseBytes;
        writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, null);
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Publisher;
     * Retrieves the metadata like checksum, object size and parts for the provided blob within the S3 bucket.
     */
 * KIND, either express or implied.  See the License for the
        );
        InputStream inputStream,
import java.util.function.Function;
            );
            .build();
    }
        if (isCompareAndSwap && e.statusCode() == 404) {
                                throwable
        final boolean isMultipartObject = partNumber != null;
        @Nullable Integer partNumber
        });
        final String contentRange = getObjectResponse.contentRange();
            writeContext.getWritePriority(),
        }
     * @return A future of {@link InputStreamContainer} containing the stream and stream metadata.
        }
                } else if (writeContext.getWritePriority() == WritePriority.HIGH) {
                List<BlobMetadata> blobs = executeListing(clientReference, listObjectsRequest(prefix, limit), limit).stream()
                    completionListener.onResponse(null);
                    () -> clientReference.get()
     * @param partSize  the part size
        }
            }
        boolean isMultipartObject
                    logger.error(
    private final String keyPath;
        }
     * @return {@link InputStreamContainer} containing the stream and stream metadata
                "Multipart upload request size [" + blobSize + "] can't be larger than " + MAX_FILE_SIZE_USING_MULTIPART
                throw new IllegalArgumentException("limit should not be a negative value");
                if (throwable != null) {
import org.opensearch.common.blobstore.BlobVersionConflictException;
     * Write blob with its object metadata and optional encryption settings.
        if (blobSize > blobStore.bufferSizeInBytes()) {
                    || writeContext.getWritePriority() == WritePriority.HIGH
import java.util.stream.Collectors;
                        throwable instanceof Exception e ? e : new IOException("Unexpected error during async deletion", throwable)
            final CompletableFuture<GetObjectAttributesResponse> blobMetadataFuture = getBlobMetadata(s3AsyncClient, bucketName, blobKey);
            return Tuple.tuple(parts + 1, remaining);
import org.opensearch.common.blobstore.InputStreamWithMetadata;
     * the size of the last part
                        int itemsToDelete = fullBatchesCount * bulkDeleteSize;
                        "Successfully completed async deletion for path [{}]. Deleted {} blobs totaling {} bytes",
                    logger.debug(
                    );
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
        try (AmazonAsyncS3Reference amazonS3Reference = AccessController.doPrivileged(blobStore::asyncClientReference)) {
                .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().multipartUploadMetricCollector))
    }
            FutureUtils.cancel(future);
        logger.debug("Starting async deletion for path [{}]", keyPath);
            blobMetadataFuture.whenComplete((blobMetadata, throwable) -> {
                        deletedBytes.get()
     * no longer exists, so the precondition can never be met and retrying cannot change the answer. That is exactly
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
                                () -> createFileCompletableFuture(s3AsyncClient, uploadRequest, streamContext, completionListener)
    public void writeBlobWithMetadata(
                parts.add(CompletedPart.builder().partNumber(uploadPartRequest.partNumber()).eTag(uploadResponse.eTag()).build());
                .bucket(bucketName)
import org.reactivestreams.Subscription;
            writeContext.getMetadata(),
                .map(commonPrefix -> commonPrefix.prefix().substring(keyPath.length()))
    ) {
        } catch (Exception e) {
        );
        if (blobSize > MAX_FILE_SIZE_USING_MULTIPART.getBytes()) {
            }
 */
        final S3BlobStore blobStore,
    // package private for testing
    /**
            .objectAttributes(ObjectAttributes.CHECKSUM, ObjectAttributes.OBJECT_SIZE, ObjectAttributes.OBJECT_PARTS)
                } catch (Exception ex) {
}
    }
            long bytesCount = 0;
    public String writeBlobConditionally(String blobName, InputStream inputStream, long blobSize, @Nullable String expectedVersionToken)
                        uploadRequest.getKey(),
                }
    static InputStreamContainer transformResponseToInputStreamContainer(
            ListObjectsV2Iterable listObjectsIterable = clientReference.get().listObjectsV2Paginator(listObjectsRequest);
                () -> clientReference.get().getObjectAsBytes(getObjectRequest)
        });
 * this file be licensed under the Apache-2.0 license or a
                .expectedBucketOwner(blobStore.expectedBucketOwner())
                });
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
                .collect(Collectors.toMap(PlainBlobMetadata::name, Function.identity()));
import java.util.concurrent.ExecutionException;
     */
import software.amazon.awssdk.services.s3.model.CommonPrefix;
                .bucket(blobStore.bucket())
                    executeMultipartUpload(
 * the Apache License, Version 2.0 (the "License"); you may
                public void onComplete() {
        throws IOException {
            if (blobStore.isUploadRetryEnabled()) {
        writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
            return executeListing(clientReference, listObjectsRequest(prefix)).stream()
            writeContext.getFileSize(),
            ListObjectsV2Request listRequest = ListObjectsV2Request.builder()
        // Extra safety checks
            }
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
                        completionListener.onFailure(new IOException("Failed to delete blobs " + blobNames, throwable));
     * Uploads a blob using a single upload request
            .storageClass(blobStore.getStorageClass())
            .expectedBucketOwner(blobStore.expectedBucketOwner())
    void ensureMultiPartUploadSize(final long blobSize) {
    private ListObjectsV2Request listObjectsRequest(String keyPath) {
     * @param blobKey Identifier of the blob for which the parts will be fetched
import org.opensearch.common.StreamContext;
import org.opensearch.core.common.unit.ByteSizeValue;
            buildKey(writeContext.getFileName()),
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
 *
            for (int i = 1; i <= nbParts; i++) {
import java.util.concurrent.TimeUnit;
     * @param blobName Identifier of the blob for which the metadata will be fetched
                public void onNext(ListObjectsV2Response response) {
            .contentLength(blobSize)
            }
                        .isMaxCapacityBelowContentLength(uploadRequest.getContentLength()) == false)) {
            }
            blobStore.expectedBucketOwner()
            .key(blobName)
    ) throws IOException {
        final GetObjectAttributesRequest getObjectAttributesRequest = GetObjectAttributesRequest.builder()
        } else {
            putObjectRequestBuilder = putObjectRequestBuilder.metadata(metadata);
import org.opensearch.repositories.s3.async.S3AsyncDeleteHelper;
    }
    @Override
                    } else {
        return AccessController.doPrivileged(
    }
        return ListObjectsV2Request.builder()
                );
            List<String> keysToDelete = blobNames.stream().map(this::buildKey).collect(Collectors.toList());
        assert inputStream.markSupported() : "No mark support on inputStream breaks the S3 SDK's ability to retry requests";
 * ownership. Elasticsearch licenses this file to you under
        }
        }
        return true;
                .build();
        AmazonS3Reference clientReference,
            success = true;
            throw new IOException("Exception when listing children of [" + path().buildAsString() + ']', e);
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
            .expectedBucketOwner(blobStore.expectedBucketOwner());
        InputStream inputStream,
        PutObjectRequest.Builder putObjectRequestBuilder = PutObjectRequest.builder()
import org.opensearch.repositories.s3.utils.SseKmsUtil;
                            logger.error(
                    logger.debug("Found {} objects to delete in current batch for path [{}]", response.contents().size(), keyPath);
        return true;
     * what a swept acknowledgement path looks like to a superseded writer, and it matches
            throw new IOException("Unable to upload object [" + blobName + "] using a single upload", e);
                            deletionChain,
                results.add(listObjectsV2Response);
import org.opensearch.common.blobstore.DeleteResult;
     *
            .bucket(blobStore.bucket())
                                () -> createFileCompletableFuture(s3AsyncClient, uploadRequest, streamContext, completionListener)
        }
                    .map(s3Object -> new PlainBlobMetadata(s3Object.key().substring(keyPath.length()), s3Object.size()))
    @Override
            logger.info("exception error from blob container for file {}", writeContext.getFileName());
     * along with the size of the last (or unique) part.
    /**
                            s3AsyncClient,
    private <T> T getFutureValue(PlainActionFuture<T> future) throws IOException {
        this.blobStore = blobStore;
            }
    }
                            deletionChain,
        if (e.statusCode() == 412) {
            throw new IllegalArgumentException("Part size must be greater than zero");
        if (multiparts.v1() > Integer.MAX_VALUE) {
 * Licensed to Elasticsearch under one or more contributor
                return blobs.subList(0, Math.min(limit, blobs.size()));
            () -> s3AsyncClient.getObject(getObjectRequestBuilder.build(), AsyncResponseTransformer.toBlockingInputStream())
    @Override
import org.opensearch.common.blobstore.stream.write.WritePriority;
                .prefix(keyPath)
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.repositories.s3.S3Repository.MAX_FILE_SIZE;
        ActionListener<Void> completionListener
    public boolean blobExists(String blobName) {
                        keyPath,
                    if (!objectsToDelete.isEmpty()) {
            blobStore.bucket(),
                } else {
            .storageClass(blobStore.getStorageClass())
                                writeContext.getFileSize(),
        if (crypto != null) {
            if (isConditionFailure(e, expectedVersionToken != null)) {
                    .partNumber(i)
                    && uploadRequest.getWritePriority() != WritePriority.URGENT
                throw new IOException("Failed to initialize multipart upload " + blobName);
                try {
        this.keyPath = path.buildAsString();
                        inputStream.getInputStream(),
import software.amazon.awssdk.services.s3.model.S3Exception;
                );
        @Nullable CryptoMetadata cryptoMetadata
    @Override
 * software distributed under the License is distributed on an
            indexEncContext = crypto.getEncryptionContext().orElse(null);
                }
        final SetOnce<String> uploadId = new SetOnce<>();
            // compare-and-swap on the version token (ETag) observed at read time
    private static final long DEFAULT_OPERATION_TIMEOUT = TimeUnit.SECONDS.toSeconds(30);
                return listObjectsResponse.commonPrefixes().stream();
        if (blobStore.isUploadRetryEnabled()) {
    public InputStream readBlob(String blobName, long position, long length) throws IOException {
            .acl(blobStore.getCannedACL())
                                () -> getBlobPartInputStreamContainer(s3AsyncClient, bucketName, blobKey, innerPartNumber)
import org.opensearch.common.annotation.ExperimentalApi;
    public void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {
                        completionListener.onResponse(null);
    }
     * lost, success if it was not), whereas classifying it as lost would fence a healthy writer whose rival lost.
            final byte[] content = responseBytes.asByteArray();
        } else {
            indexEncContext,
            .key(blobName)
                .map(name -> name.substring(0, name.length() - 1))
import java.io.BufferedInputStream;
            .prefix(keyPath)
                        deletionChain = S3AsyncDeleteHelper.executeDeleteChain(
            throw new IOException(e);
            final List<ListObjectsV2Response> results = new ArrayList<>();
            .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().putObjectMetricPublisher))
            } else {
        String blobName,
    @ExperimentalApi
     */
            listPublisher.subscribe(new Subscriber<>() {
            writeContext.getExpectedChecksum(),
                requestInputStream = new BufferedInputStream(input, (int) (blobSize + 1));
                        logger.debug("Executing final bulk delete of {} objects for path [{}]", objectsToDelete.size(), keyPath);
                        objectsToDelete.size()
        PutObjectRequest.Builder putObjectRequestBuilder = PutObjectRequest.builder()
        final Tuple<Long, Long> multiparts = numberOfMultiparts(blobSize, partSize);
                        blobPartInputStreamFutures.add(() -> getBlobPartInputStreamContainer(s3AsyncClient, bucketName, blobKey, null));
                    .uploadId(uploadId.get())
            return new ByteArrayInputStream(new byte[0]);
        }
        } catch (final SdkException e) {
     * still in flight and the outcome of this request's precondition is therefore UNKNOWN - must surface as an
            blobStore.serverSideEncryptionEncryptionContext()
    @Override
import org.opensearch.action.support.PlainActionFuture;
            listener.onFailure(SdkException.create("Error occurred while fetching blob parts from the repository", ex));
import org.opensearch.common.blobstore.BlobContainer;
                    response.contents().forEach(s3Object -> {
        return keyPath + blobName;
     * Returns the number parts of size of {@code partSize} needed to reach {@code totalSize},
 * compatible open source license.
     */
     */
                    .build();
import java.util.List;
            if (Strings.isEmpty(uploadId.get())) {
            }
import software.amazon.awssdk.services.s3.model.CompletedPart;
        // Fetch blob metadata - part info, size, checksum
                        : new Exception(throwable.getCause());
        if ((isMultipartObject && contentRange == null) || contentLength == null) {
                AccessController.doPrivileged(() -> clientReference.get().createMultipartUpload(createMultipartUploadRequest).uploadId())
    ) throws IOException {
import org.opensearch.common.blobstore.BlobMetadata;
                InputStreamContainer inputStream = streamContext.provideStream(0);
        if (e.statusCode() != 409) {
            );
                            batchToDelete,
        }
            Thread.currentThread().interrupt();
                        objectsToDelete.add(s3Object.key());
            throw new IllegalArgumentException("Too many multipart upload requests, maybe try a larger buffer size?");
    public void readBlobAsync(String blobName, ActionListener<ReadContext> listener) {
                    final Integer numberOfParts = blobMetadata.objectParts() == null ? null : blobMetadata.objectParts().totalPartsCount();
    @Override
     * @return A future containing the metadata within {@link GetObjectAttributesResponse}
        final InputStream input,
    public InputStream readBlob(String blobName) throws IOException {
                    logger.debug("Subscribed to list objects publisher for path [{}]", keyPath);
    }
            ListObjectsV2Publisher listPublisher = s3AsyncClient.listObjectsV2Paginator(listRequest);
                .flatMap(listing -> listing.contents().stream())
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
            });
    public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {
import software.amazon.awssdk.services.s3.model.CompletedMultipartUpload;
                        subscription.request(1);
            return "NoSuchKey".equals(errorCode);
            .bucket(bucketName)
                    final List<ReadContext.StreamPartCreator> blobPartInputStreamFutures = new ArrayList<>();
                            uploadRequest.getContentLength()
            .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().listObjectsMetricPublisher))
    public InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {
import org.opensearch.core.common.unit.ByteSizeUnit;
                } catch (Exception ex) {
                    final String blobChecksum = blobMetadata.checksum() == null ? null : blobMetadata.checksum().checksumCRC32();
        final long offset = isMultipartObject ? HttpRangeUtils.getStartOffsetFromRangeHeader(getObjectResponse.contentRange()) : 0L;
                    .headObject(
    @Override
            StreamContext streamContext = AccessController.doPrivileged(() -> writeContext.getStreamProvider(partSize));
                        if (s.key().substring(keyPath.length()).startsWith(commonPrefix.prefix())) {
        return listBlobsByPrefix(null);
            throw new IOException("Unable to upload object [" + blobName + "] using multipart upload", e);
        final long sizeBound = blobStore.bufferSizeInBytes();
     */
                }
        String indexEncContext = null;
    @Override
    @Override
        }
            .bucket(blobStore.bucket())
                    final long blobSize = blobMetadata.objectSize();
                            .key(buildKey(blobName))
 */
            AtomicLong deletedBlobs = new AtomicLong();
        final InputStream requestInputStream;
        // This container returns streams that must be fully consumed, so we tell consumers to make bounded requests.
     * the key has no current version at all (deleted, or a delete marker): the version the caller presented provably
            final S3AsyncClient s3AsyncClient = amazonS3Reference.get().client();
            throw new IllegalArgumentException("Upload request size [" + blobSize + "] can't be larger than " + MAX_FILE_SIZE);
import org.opensearch.repositories.s3.utils.HttpRangeUtils;
    public DeleteResult delete() throws IOException {
        // 412 Precondition Failed is unambiguous: the If-Match/If-None-Match condition was not met.
            .bucket(bucketName)
                    Exception ex = throwable.getCause() instanceof Exception
                        );
    }
            String prefix = blobNamePrefix == null ? keyPath : buildKey(blobNamePrefix);
    }
        }
        } catch (final SdkException e) {
        final GetObjectRequest.Builder getObjectRequestBuilder = GetObjectRequest.builder()
import org.apache.logging.log4j.Logger;
                }) : "Response contained children for listed common prefixes.";
                            null
            AtomicLong deletedBytes = new AtomicLong();
                                () -> new ParameterizedMessage("Failed to complete deletion chain for path [{}]", keyPath),
        } catch (ExecutionException e) {
                        crypto
    }
            throw new IllegalArgumentException(
    private CompletableFuture<Void> createFileCompletableFuture(
                    );
                        objectsToDelete.subList(0, itemsToDelete).clear();
                }
        S3AsyncClient s3AsyncClient,
                || (uploadRequest.getWritePriority() != WritePriority.HIGH
     */
                    } else {
                    logger.error(() -> new ParameterizedMessage("Failed to complete async deletion for path [{}]", keyPath), throwable);
                } else {
                    subscription.request(1);
    @ExperimentalApi
     * for remote store primary fencing.
                assert listObjectsResponse.contents().stream().noneMatch(s -> {
                            blobStore,
            putObjectRequestBuilder.ifNoneMatch("*");
        @Nullable CryptoMetadata cryptoMetadata
    /**
        } else {
import org.opensearch.common.blobstore.VersionedBlob;
                .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().listObjectsMetricPublisher))
import java.util.ArrayList;
        }
            writeContext.doRemoteDataIntegrityCheck(),
        final Map<String, String> metadata,
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
                    .collect(Collectors.toList());
    // non-static, package private for testing
                    e
    }
                        ex
            throw new IOException("Unable to conditionally upload object [" + blobName + "]", e);
        if (blobSize < MIN_PART_SIZE_USING_MULTIPART.getBytes()) {
            AccessController.doPrivileged(
    public void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException {
    private static final Set<String> CONDITIONAL_WRITE_CONFLICT_ERROR_CODES = Set.of("PreconditionFailed");
                            );
package org.opensearch.repositories.s3;
        return new InputStreamWithMetadata(s3RetryingInputStream, s3RetryingInputStream.getMetadata());
            .bucket(bucketName)
    }
    private static boolean isConditionFailure(S3Exception e, boolean isCompareAndSwap) {
            throw new BlobStoreException("Failed to check if blob [" + blobName + "] exists", e);
                totalObjects += listObjectsV2Response.contents().size();
                .map(s3Object -> new PlainBlobMetadata(s3Object.key().substring(keyPath.length()), s3Object.size()))
     */
        return AccessController.doPrivileged(() -> s3AsyncClient.getObjectAttributes(getObjectAttributesRequest));
            .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().multipartUploadMetricCollector))
                private CompletableFuture<Void> deletionChain = CompletableFuture.completedFuture(null);
                        uploadRequest.getMetadata(),
                .uploadId(uploadId.get())
import static org.opensearch.repositories.s3.S3Repository.MAX_FILE_SIZE_USING_MULTIPART;
            } else {
        }
        configureEncryptionSettings(createMultipartUploadRequestBuilder, blobStore, cryptoMetadata);
            .acl(blobStore.getCannedACL())
                throw new IOException(
                    );
            );
import java.util.concurrent.CompletableFuture;
                    completionListener.onResponse(new DeleteResult(deletedBlobs.get(), deletedBytes.get()));
    @Override
        configureEncryptionSettings(putObjectRequestBuilder, blobStore, cryptoMetadata);
        }
                            new SizeBasedBlockingQ.Item(
        } else {
import static org.opensearch.repositories.s3.S3Repository.MIN_PART_SIZE_USING_MULTIPART;
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
            throw new IllegalArgumentException("position must be non-negative");
                    s3AsyncClient = amazonS3Reference.get().priorityClient();
    private static final Logger logger = LogManager.getLogger(S3BlobContainer.class);
        }
                Exception ex = throwable instanceof Error ? new Exception(throwable) : (Exception) throwable;
                );
                .multipartUpload(CompletedMultipartUpload.builder().parts(parts).build())
 * under the License.
        final GetObjectResponse getObjectResponse = streamResponse.response();
import org.opensearch.cluster.metadata.CryptoMetadata;
        String indexKmsKey = null;
                    .key(blobName)
            );
     */
    }
        try {
