                    logger.error(
    @Override  
        CompletableFuture<Void> completableFuture = blobStore.getAsyncTransferManager()
            .build();
        ensureMultiPartUploadSize(blobSize);  
    }
        } catch (TimeoutException e) {
                } else if (writeContext.getWritePriority() == WritePriority.LOW) {
     * writer, so only errors that prove the precondition was evaluated and NOT MET are classified as a lost CAS:
                    .partNumber(i)  
    }  
        PutObjectRequest.Builder putObjectRequestBuilder = PutObjectRequest.builder()
                } else {  
            throw new BlobStoreException("Failed to check if blob [" + blobName + "] exists", e);
                            new SizeBasedBlockingQ.Item(
    /**  
    }
            listingFuture.whenComplete((v, throwable) -> {
                            );
     *  
                S3AsyncClient s3AsyncClient;
    public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) throws IOException {  
        final InputStream input,  
    @Override
     * @return {@link InputStreamContainer} containing the stream and stream metadata
    }
            final CompletableFuture<GetObjectAttributesResponse> blobMetadataFuture = getBlobMetadata(s3AsyncClient, bucketName, blobKey);  
     * for remote store primary fencing.
    }
        if (isCompareAndSwap && e.statusCode() == 404) {
            }  
                    } else {
                            );
                        keyPath,
import org.opensearch.common.blobstore.support.AbstractBlobContainer;
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
                        .produce(  
        }
        return AccessController.doPrivileged(
            );
     * {@code ConditionalRequestConflict}, which S3 returns when a concurrent conditional write on the same key is
                executeMultipartUpload(blobStore, buildKey(blobName), inputStream, blobSize, metadata, cryptoMetadata);
        // Neither an unlabelled 409 nor a retryable conflict code is evidence that the precondition failed.  
            throw new IllegalArgumentException("Too many multipart upload requests, maybe try a larger buffer size?");
            if (throwable == null) {
                    "Failed to execute multipart upload for [" + blobName + "], expected " + blobSize + "bytes sent but got " + bytesCount
                    "conditional write conflict for blob [" + blobName + "]: expected [" + expectedVersionToken + "]",
        logger.debug("Starting async deletion for path [{}]", keyPath);
    public Map<String, BlobMetadata> listBlobsByPrefix(@Nullable String blobNamePrefix) throws IOException {
                @Override  
import software.amazon.awssdk.services.s3.model.CommonPrefix;
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;
        } else {  
                    completionListener.onResponse(new DeleteResult(deletedBlobs.get(), deletedBytes.get()));  
import org.opensearch.common.util.concurrent.FutureUtils;
                    );
                    s3AsyncClient = amazonS3Reference.get().urgentClient();  
        return executeListing(clientReference, listObjectsRequest, -1);
            logger.error(() -> new ParameterizedMessage("Failed to initiate async deletion for path [{}]", keyPath), e);
        if (remaining == 0) {  
                        "Successfully completed async deletion for path [{}]. Deleted {} blobs totaling {} bytes",
     * @param blobKey Identifier of the blob for which the parts will be fetched  
                .collect(Collectors.toMap(PlainBlobMetadata::name, Function.identity()));
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {  
            throw new IOException("Unable to read object [" + blobName + "] with version", e);  
import java.util.List;
            // or an unlabelled response) is not evidence about the precondition and stays retryable.  
            AccessController.doPrivileged(
        InputStream inputStream,
                    completionListener.onFailure(ex);
                () -> clientReference.get().putObject(putObjectRequest, RequestBody.fromInputStream(inputStream, blobSize))
            throw new IllegalArgumentException("Part size must be greater than zero");
        return listBlobsByPrefix(null);  
        }
        } catch (InterruptedException e) {  
                    int bulkDeleteSize = blobStore.getBulkDeletesSize();  
            putObjectRequestBuilder = putObjectRequestBuilder.metadata(metadata);  
        return new InputStreamContainer(streamResponse, getObjectResponse.contentLength(), offset);
                    .uploadId(uploadId.get())
        if (CollectionUtils.isNotEmpty(metadata)) {  
            .expectedBucketOwner(blobStore.expectedBucketOwner());
            throw new IllegalArgumentException("Upload request size [" + blobSize + "] can't be larger than buffer size");
        final PutObjectRequest putObjectRequest = putObjectRequestBuilder.build();
import java.util.stream.Collectors;
    }  
    @Override
    @ExperimentalApi
 * under the License.  
        } catch (SdkException e) {
        final String contentRange = getObjectResponse.contentRange();
    public void asyncBlobUpload(WriteContext writeContext, ActionListener<Void> completionListener) throws IOException {
     * @param streamResponse Response stream object from S3  
            });
        if (partSize <= 0) {
            );  
            .delimiter("/")
    private ListObjectsV2Request listObjectsRequest(String keyPath, int limit) {
        if (CollectionUtils.isNotEmpty(metadata)) {
                    && uploadRequest.getWritePriority() != WritePriority.URGENT
                    this.subscription = s;  
        if (e.statusCode() != 409) {  
    public void deleteBlobsAsyncIgnoringIfNotExists(List<String> blobNames, ActionListener<Void> completionListener) {
        final Map<String, String> metadata,
import org.opensearch.common.blobstore.VersionedBlob;  
        assert blobSize == (((nbParts - 1) * partSize) + lastPartSize) : "blobSize does not match multipart sizes";
    }  
        boolean failIfAlreadyExists,
import org.opensearch.repositories.s3.utils.HttpRangeUtils;
                    Exception ex = throwable.getCause() instanceof Exception
                throw new IOException("Failed to initialize multipart upload " + blobName);
                    }  
            .expectedBucketOwner(blobStore.expectedBucketOwner());
                    }  
                () -> clientReference.get().putObject(putObjectRequest, RequestBody.fromInputStream(requestInputStream, blobSize))
                final UploadPartRequest uploadPartRequest = UploadPartRequest.builder()
        final String bucketName = blobStore.bucket();
        } catch (ExecutionException e) {  
                        .produce(
import org.opensearch.core.common.Strings;
    ) {
                );
    private static final Logger logger = LogManager.getLogger(S3BlobContainer.class);
                .uploadId(uploadId.get())
     * the size of the last part
                    blobStore.getNormalPrioritySizeBasedBlockingQ()
        assert inputStream.markSupported() : "No mark support on inputStream breaks the S3 SDK's ability to retry requests";
        S3RetryingInputStream s3RetryingInputStream = new S3RetryingInputStream(blobStore, buildKey(blobName));
            writeContext.getMetadata(),
                            new SizeBasedBlockingQ.Item(
    long getLargeBlobThresholdInBytes() {
            .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().putObjectMetricPublisher))
            final PutObjectResponse response = AccessController.doPrivileged(
            .acl(blobStore.getCannedACL())
                            )
            return Tuple.tuple(1L, totalSize);  
                }  
                        deletedBlobs.incrementAndGet();
     * lost, success if it was not), whereas classifying it as lost would fence a healthy writer whose rival lost.
                            uploadRequest.getContentLength()  
     * S3 evaluates {@code If-Match} and {@code If-None-Match} server-side and serializes conditional writes per key, so
import software.amazon.awssdk.utils.CollectionUtils;
        }
            AtomicLong deletedBlobs = new AtomicLong();  
        configureEncryptionSettings(createMultipartUploadRequestBuilder, blobStore, cryptoMetadata);
            writeContext.getExpectedChecksum(),
                        }  
        final SetOnce<String> uploadId = new SetOnce<>();  
            }
    @Override  
                    final Integer numberOfParts = blobMetadata.objectParts() == null ? null : blobMetadata.objectParts().totalPartsCount();
                                writeContext.getFileSize(),  
                bytesCount += uploadPartRequest.contentLength();  
            throw new IllegalArgumentException(
    private ListObjectsV2Request listObjectsRequest(String keyPath) {  
    }
                    logger.debug(
            if (Strings.isEmpty(uploadId.get())) {  
    }
            .bucket(bucketName)
        final long blobSize,
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
class S3BlobContainer extends AbstractBlobContainer implements AsyncMultiStreamBlobContainer {  
    public void readBlobAsync(String blobName, ActionListener<ReadContext> listener) {  
        UploadRequest uploadRequest = new UploadRequest(
            return super.listBlobsByPrefixInSortedOrder(blobNamePrefix, limit, blobNameSortOrder);  
    @Override
        return errorCode != null && CONDITIONAL_WRITE_CONFLICT_ERROR_CODES.contains(errorCode);
            CompleteMultipartUploadRequest completeMultipartUploadRequest = CompleteMultipartUploadRequest.builder()
            blobStore.serverSideEncryptionType(),
            blobStore.serverSideEncryptionBucketKey(),
        @Nullable CryptoMetadata cryptoMetadata  
                    executeMultipartUpload(
                .map(name -> name.substring(0, name.length() - 1))
        // Versioned reads materialize the object in memory and are meant for small control blobs only. The ranged GET
        );
        InputStream inputStream,
            .build();
                requestInputStream = new BufferedInputStream(input, (int) (blobSize + 1));  
            return false;
        if (blobStore.isUploadRetryEnabled()) {
                }
                    completionListener.onResponse(null);  
                            listingFuture.completeExceptionally(throwable);
    }  
        } catch (final Exception e) {  
        final long remaining = totalSize % partSize;
    }
                    .expectedBucketOwner(blobStore.expectedBucketOwner())
import software.amazon.awssdk.services.s3.model.ObjectAttributes;  
                if (limit != -1 && totalObjects >= limit) {
     */
    @Override  
            }  
        configureEncryptionSettings(putObjectRequestBuilder, blobStore, cryptoMetadata);  
     * Transforms the stream response object from S3 into an {@link InputStreamContainer}
    }
            .bucket(bucketName)  
            if ((success == false) && Strings.hasLength(uploadId.get())) {
        final long offset = isMultipartObject ? HttpRangeUtils.getStartOffsetFromRangeHeader(getObjectResponse.contentRange()) : 0L;  
                        throwable instanceof Exception e ? e : new IOException("Unexpected error during async deletion", throwable)  
    private String buildKey(String blobName) {
        }
    ) throws IOException {
                        .uploadPart(uploadPartRequest, RequestBody.fromInputStream(requestInputStream, uploadPartRequest.contentLength()))  
 * Modifications Copyright OpenSearch Contributors. See
        getFutureValue(future);  
 * The OpenSearch Contributors require contributions made to  
                            objectsToDelete,  
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
        return new ByteSizeValue(32, ByteSizeUnit.MB).getBytes();
            .key(buildKey(blobName))
            throw new IOException("Unable to conditionally upload object [" + blobName + "]", e);  
import org.opensearch.secure_sm.AccessController;  
        CreateMultipartUploadRequest.Builder createMultipartUploadRequestBuilder = CreateMultipartUploadRequest.builder()
                    }  
    }
                        completionListener.onResponse(null);
     */  
                    }  
            });
        return AccessController.doPrivileged(() -> s3AsyncClient.getObjectAttributes(getObjectAttributesRequest));
        }
                    completionListener.onFailure(
     */
                || (uploadRequest.getWritePriority() != WritePriority.HIGH
    }  
        return listObjectsRequest(keyPath).toBuilder().maxKeys(Math.min(limit, 1000)).build();
            return new ByteArrayInputStream(new byte[0]);
                    response.contents().forEach(s3Object -> {
            throw new NoSuchFileException("[" + blobName + "] blob not found");
import org.apache.logging.log4j.Logger;
            S3AsyncClient s3AsyncClient = asyncClientReference.get().client();
        }  
        final long parts = totalSize / partSize;  
        }  
     * @return A future of {@link InputStreamContainer} containing the stream and stream metadata.
/*  
            blobStore.isUploadRetryEnabled(),  
            for (int i = 1; i <= nbParts; i++) {
 * not use this file except in compliance with the License.
            try (AmazonS3Reference clientReference = blobStore.clientReference()) {  
        return new S3RetryingInputStream(blobStore, buildKey(blobName));
import org.opensearch.common.blobstore.DeleteResult;
            .build();  
    @Override
     * Write blob with its object metadata.
    /**
                .expectedBucketOwner(blobStore.expectedBucketOwner())
        try {
            }
        @Nullable CryptoMetadata cryptoMetadata  
                if (writeContext.getWritePriority() == WritePriority.URGENT) {
            ListObjectsV2Iterable listObjectsIterable = clientReference.get().listObjectsV2Paginator(listObjectsRequest);  
                // Stripping the trailing slash off of the common prefix
    public long readBlobPreferredLength() {  
        final Long contentLength = getObjectResponse.contentLength();
            }  
                .prefix(keyPath)
                    deletionChain.whenComplete((v, throwable) -> {
                    s3AsyncClient = amazonS3Reference.get().client();
            .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().putObjectMetricPublisher))
            } catch (final Exception e) {  
            .expectedBucketOwner(blobStore.expectedBucketOwner())  
        } catch (final SdkException e) {
                            null
            if (e.getCause() instanceof IOException) {
        }  
                () -> clientReference.get().getObjectAsBytes(getObjectRequest)
    }  
     * Uploads a blob using multipart upload requests.
            );
                totalObjects += listObjectsV2Response.contents().size();  
        deleteBlobsAsyncIgnoringIfNotExists(blobNames, future);
        configureEncryptionSettings(putObjectRequestBuilder, blobStore, null);
import software.amazon.awssdk.core.ResponseBytes;
import org.apache.logging.log4j.message.ParameterizedMessage;  
        }
        if (e.statusCode() == 412) {  
                    .map(s3Object -> new PlainBlobMetadata(s3Object.key().substring(keyPath.length()), s3Object.size()))  
        final Map<String, String> metadata,
            throw new IllegalArgumentException("position must be non-negative");
    }
        final S3BlobStore blobStore,
    /**
            writeContext.getFileSize(),
            return false;
    // Package-Private for testing.
                    break;
    public String writeBlobConditionally(String blobName, InputStream inputStream, long blobSize, @Nullable String expectedVersionToken)
                    || writeContext.getWritePriority() == WritePriority.HIGH
                private CompletableFuture<Void> deletionChain = CompletableFuture.completedFuture(null);
     * This implementation ignores the failIfAlreadyExists flag as the S3 API has no way to enforce this due to its weak consistency model.  
import org.opensearch.common.blobstore.stream.write.WritePriority;  
        }
    void executeMultipartUpload(  
                }  
            return new VersionedBlob(content, responseBytes.response().eTag());
        } else {
        } else {  
    private <T> T getFutureValue(PlainActionFuture<T> future) throws IOException {  
     * a 412, with or without an error code, a 409 carrying {@code PreconditionFailed}, or - for an {@code If-Match}  
    void executeSingleUpload(  
                        ex
    public Map<String, BlobContainer> children() throws IOException {
import org.opensearch.common.blobstore.BlobMetadata;  
            }  
import static org.opensearch.repositories.s3.S3Repository.MAX_FILE_SIZE;
     * Distinguishes a genuinely lost compare-and-swap from a transient conflict. Losing the CAS is fatal for a fenced
                    .expectedBucketOwner(blobStore.expectedBucketOwner())  
                }
                "Multipart upload request size [" + blobSize + "] can't be smaller than " + MIN_PART_SIZE_USING_MULTIPART
        return ListObjectsV2Request.builder()
                throw new IllegalArgumentException("limit should not be a negative value");  
                } else {  
            );  
            long bytesCount = 0;  
                .flatMap(listing -> listing.contents().stream())
        long blobSize,  
    }  
    @Override  
            if ((uploadRequest.getWritePriority() == WritePriority.LOW
                        ? (Exception) throwable.getCause()
        if (expectedVersionToken == null) {  
        }  
    }  
        if (isMultipartObject) {
import org.opensearch.repositories.s3.utils.SseKmsUtil;
    }
                        "Completed listing objects for path [{}], remaining objects to delete: {}",  
                .calculateOptimalPartSize(writeContext.getFileSize(), writeContext.getWritePriority(), blobStore.isUploadRetryEnabled());  
import java.util.Set;
            }
        if (multiparts.v1() > Integer.MAX_VALUE) {
                            () -> subscription.request(1)
            }  
 */
        }
                            blobStore,
            AccessController.doPrivileged(
import static org.opensearch.repositories.s3.utils.SseKmsUtil.configureEncryptionSettings;
            if (bytesCount != blobSize) {
            return true;
            .bucket(blobStore.bucket())
            ListObjectsV2Publisher listPublisher = s3AsyncClient.listObjectsV2Paginator(listRequest);
        final long lastPartSize = multiparts.v2();  
 */  
        String indexEncContext = null;
        String bucketName,  
 * Unless required by applicable law or agreed to in writing,
        boolean isMultipartObject
                                () -> createFileCompletableFuture(s3AsyncClient, uploadRequest, streamContext, completionListener)  
                        logger.debug("Executing final bulk delete of {} objects for path [{}]", objectsToDelete.size(), keyPath);
            AtomicLong deletedBytes = new AtomicLong();
        }
                        );
    public boolean remoteIntegrityCheckSupported() {
    public void writeBlobWithMetadata(  
            }  
                        blobPartInputStreamFutures.add(() -> getBlobPartInputStreamContainer(s3AsyncClient, bucketName, blobKey, null));  
        if (blobSize > blobStore.bufferSizeInBytes()) {
        String blobKey,
        final String blobName,
     * Write blob with its object metadata and optional encryption settings.
    }
                        subscription.request(1);
    @Override
            String prefix = blobNamePrefix == null ? keyPath : buildKey(blobNamePrefix);
                        deletedBytes.get()
        ActionListener<Void> completionListener
        PutObjectRequest.Builder putObjectRequestBuilder = PutObjectRequest.builder()
import java.util.Map;  
                if (throwable != null) {  
        if (crypto != null) {
        } catch (SdkException e) {
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
            .key(blobKey)
import org.opensearch.core.action.ActionListener;  
     * Fetches a part of the blob from the S3 bucket and transforms it to an {@link InputStreamContainer}, which holds
                return;  
        final Tuple<Long, Long> multiparts = numberOfMultiparts(blobSize, partSize);
            uploadId.set(  
import java.io.InputStream;
                .collect(Collectors.toMap(Function.identity(), name -> blobStore.blobContainer(path().add(name))));  
        final InputStream requestInputStream;  
        } catch (S3Exception e) {
            buildKey(writeContext.getFileName()),  
                    e  
            success = true;  
    }
import java.nio.file.NoSuchFileException;  
                }
                return listObjectsResponse.commonPrefixes().stream();  
import org.opensearch.common.annotation.ExperimentalApi;  
    private final String keyPath;  
                    final long blobSize = blobMetadata.objectSize();
                    blobStore.getLowPrioritySizeBasedBlockingQ()  
                public void onNext(ListObjectsV2Response response) {  
import software.amazon.awssdk.core.exception.SdkException;
 * specific language governing permissions and limitations
                .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().multipartUploadMetricCollector))
        this.blobStore = blobStore;
            long partSize = blobStore.getAsyncTransferManager()
                    logger.error(() -> new ParameterizedMessage("Failed to list objects for deletion in path [{}]", keyPath), t);
        boolean failIfAlreadyExists,  
            FutureUtils.cancel(future);  
     * still in flight and the outcome of this request's precondition is therefore UNKNOWN - must surface as an  
                        : new Exception(throwable.getCause());  
        String blobName,
 * license agreements. See the NOTICE file distributed with
     */
    @Override
                .build();  
        CreateMultipartUploadRequest createMultipartUploadRequest = createMultipartUploadRequestBuilder.build();
                @Override  
        if (blobSize > blobStore.bufferSizeInBytes()) {
        // ETag); an object at this key that exceeds the bound - misuse or corruption - is refused below instead of  
            } else {
    }  
            listener.onFailure(SdkException.create("Error occurred while fetching blob parts from the repository", ex));
     * the precondition holds against writers in any process and on any host - which is what makes this container usable  
        int limit
     * @return A future containing the metadata within {@link GetObjectAttributesResponse}  
                    .build();
    static InputStreamContainer transformResponseToInputStreamContainer(
            completionListener.onResponse(null);  
        super(path);  
    }
        return blobStore.bufferSizeInBytes();
                parts.add(CompletedPart.builder().partNumber(uploadPartRequest.partNumber()).eTag(uploadResponse.eTag()).build());
    public void writeBlobAtomic(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {  
import java.util.concurrent.ExecutionException;  
            throw new IllegalArgumentException(  
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;  
                    if (!objectsToDelete.isEmpty()) {
        final long blobSize,
import org.opensearch.common.collect.Tuple;  
            final String blobKey = buildKey(blobName);
                    final String blobChecksum = blobMetadata.checksum() == null ? null : blobMetadata.checksum().checksumCRC32();  
                InputStreamContainer inputStream = streamContext.provideStream(0);
        }
                }
            return Tuple.tuple(parts, partSize);
            } else {  
                    AccessController.doPrivileged(() -> clientReference.get().abortMultipartUpload(abortRequest));
        final long sizeBound = blobStore.bufferSizeInBytes();
    }
import java.util.concurrent.CompletableFuture;
    private CompletableFuture<Void> createFileCompletableFuture(
                            listingFuture.complete(null);
        });  
import org.opensearch.common.blobstore.support.PlainBlobMetadata;
     * no longer exists, so the precondition can never be met and retrying cannot change the answer. That is exactly  
                                () -> createFileCompletableFuture(s3AsyncClient, uploadRequest, streamContext, completionListener)
                    logger.debug(  
                }
            return future.get(DEFAULT_OPERATION_TIMEOUT, TimeUnit.SECONDS);
        if (length == 0) {
                        uploadRequest.getContentLength(),
package org.opensearch.repositories.s3;
                    .key(blobName)
        }  
            Thread.currentThread().interrupt();
 * You may obtain a copy of the License at  
        }
                    s3AsyncClient = amazonS3Reference.get().priorityClient();
            .key(buildKey(blobName))  
        this.keyPath = path.buildAsString();
 * the Apache License, Version 2.0 (the "License"); you may
                        for (int partNumber = 1; partNumber <= numberOfParts; partNumber++) {  
        return completableFuture.whenComplete((response, throwable) -> {  
                            logger.error(
                    createFileCompletableFuture(s3AsyncClient, uploadRequest, streamContext, completionListener);
        AmazonS3Reference clientReference,
            try (AmazonAsyncS3Reference amazonS3Reference = AccessController.doPrivileged(blobStore::asyncClientReference)) {
     * @param s3AsyncClient Async client to be utilized to fetch the metadata  
                    .build();
 * compatible open source license.
            throw new IOException(e);  
                        }
            return true;  
        CryptoMetadata crypto = writeContext.getCryptoMetadata();
            }
    ) {  
            throw SdkException.builder().message("Failed to fetch required metadata for blob part").build();
        @Nullable Map<String, String> metadata,
                            "Failed to upload large file {} of size {} ",
                    )
import java.util.concurrent.atomic.AtomicLong;  
                        completionListener.onFailure(new IOException("Failed to delete blobs " + blobNames, throwable));  
                    return;
                completionListener.onResponse(response);
    /**  
                .build();  
            if (blobStore.isUploadRetryEnabled()) {
            getObjectRequestBuilder.partNumber(partNumber);
                            uploadRequest.getKey(),
                AbortMultipartUploadRequest abortRequest = AbortMultipartUploadRequest.builder()  
            .range("bytes=0-" + sizeBound)  
        } catch (NoSuchKeyException e) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void writeBlobWithMetadata(
                    if (numberOfParts == null) {
                .map(commonPrefix -> commonPrefix.prefix().substring(keyPath.length()))
                    subscription.request(1);
import static org.opensearch.repositories.s3.S3Repository.MIN_PART_SIZE_USING_MULTIPART;  
            final List<CompletedPart> parts = new ArrayList<>();
            throw new IOException("Unable to conditionally upload object [" + blobName + "]", e);
                            s3AsyncClient,
import org.opensearch.cluster.metadata.CryptoMetadata;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;  
        } catch (final SdkException e) {
            throw new IOException("Exception when listing children of [" + path().buildAsString() + ']', e);
                    );
        }
                requestInputStream = input;
        String prefix = blobNamePrefix == null ? keyPath : buildKey(blobNamePrefix);
                        uploadRequest.getMetadata(),  
                @Override
import org.opensearch.common.blobstore.stream.write.WriteContext;
            indexKmsKey = crypto.getKeyArn().orElse(null);
                return blobs.subList(0, Math.min(limit, blobs.size()));
import static org.opensearch.repositories.s3.S3Repository.MAX_FILE_SIZE_USING_MULTIPART;
                throw (IOException) e.getCause();
                                writeContext.getFileSize(),
import java.io.IOException;
     * Returns the number parts of size of {@code partSize} needed to reach {@code totalSize},
        });
                        .isMaxCapacityBelowContentLength(uploadRequest.getContentLength()) == false)) {
                    .bucket(bucketName)  
                    listener.onFailure(ex);  
import org.opensearch.common.blobstore.BlobStoreException;
            blobStore.serverSideEncryptionEncryptionContext()
            return;
     */  
                        if (s.key().substring(keyPath.length()).startsWith(commonPrefix.prefix())) {  
                            deletionChain,
                AccessController.doPrivileged(() -> clientReference.get().createMultipartUpload(createMultipartUploadRequest).uploadId())
     * {@code FsBlobContainer#writeBlobConditionally}, which also reports a conflict for a missing blob. A 404 without
                    listener.onResponse(new ReadContext.Builder(blobSize, blobPartInputStreamFutures).blobChecksum(blobChecksum).build());
        if (blobSize < MIN_PART_SIZE_USING_MULTIPART.getBytes()) {
                        () -> new ParameterizedMessage(  
    @ExperimentalApi
                        ),
    @ExperimentalApi
            .key(blobName)
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {  
            throw new IOException("Unable to upload object [" + blobName + "] using multipart upload", e);  
        StreamContext streamContext,
                        objectsToDelete.subList(0, itemsToDelete).clear();  
        // bounds the transfer to the same limit the write side enforces (a ranged GET still returns the object's
                        deletionChain = S3AsyncDeleteHelper.executeDeleteChain(  
import software.amazon.awssdk.services.s3.model.GetObjectAttributesResponse;
            .prefix(keyPath)  
import software.amazon.awssdk.services.s3.model.S3Exception;  
                    .flatMap(listing -> listing.contents().stream())
                } else {
        final String errorCode = e.awsErrorDetails() == null ? null : e.awsErrorDetails().errorCode();  
import org.opensearch.common.StreamContext;
import software.amazon.awssdk.core.ResponseInputStream;
            // Therefore, redirecting it to slow client.
    @Override
        }  
     * @param partNumber Optional part number for the blob to be retrieved
                throw new IOException("[" + blobName + "] blob of size > [" + sizeBound + "] is too large for a versioned read");  
            writeContext.getUploadFinalizer(),  
import org.opensearch.common.blobstore.BlobPath;
                assert listObjectsResponse.contents().stream().noneMatch(s -> {
import org.opensearch.core.common.unit.ByteSizeValue;  
        if (position < 0L) {
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {  
        PlainActionFuture<DeleteResult> future = new PlainActionFuture<>();  
            return new S3RetryingInputStream(blobStore, buildKey(blobName), position, Math.addExact(position, length - 1));
     */  
 */  
            blobStore.expectedBucketOwner()  
        return AccessController.doPrivileged(() -> {  
    /**
/*
     */
import org.opensearch.repositories.s3.async.SizeBasedBlockingQ;
        ResponseInputStream<GetObjectResponse> streamResponse,  
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;  
        writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, metadata, null);
 * Licensed to Elasticsearch under one or more contributor  
                        objectsToDelete.size()
                        int itemsToDelete = fullBatchesCount * bulkDeleteSize;  
                }  
        final InputStream input,  
                    .bucket(bucketName)
                results.add(listObjectsV2Response);
                .multipartUpload(CompletedMultipartUpload.builder().parts(parts).build())  
    CompletableFuture<GetObjectAttributesResponse> getBlobMetadata(S3AsyncClient s3AsyncClient, String bucketName, String blobName) {
                        // S3 multipart files use 1 to n indexing
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
     * @param bucketName Name of the S3 bucket
        @Nullable Integer partNumber
            .bucket(blobStore.bucket())  
    }
import org.opensearch.action.support.PlainActionFuture;
                        inputStream.getInputStream(),
        if (blobNames.isEmpty()) {
                    .contentLength((i < nbParts) ? partSize : lastPartSize)
        }
        } else {
                        keyPath,
        if (blobSize > MAX_FILE_SIZE_USING_MULTIPART.getBytes()) {  
            throw new RuntimeException(e.getCause());
        if (length < 0) {
            final S3AsyncClient s3AsyncClient = amazonS3Reference.get().client();
 * ownership. Elasticsearch licenses this file to you under  
    /**
                        }
        }
    /**
            final InputStream requestInputStream;
        // being buffered whole.
import org.opensearch.common.Nullable;  
                    logger.error(() -> new ParameterizedMessage("Failed to complete async deletion for path [{}]", keyPath), throwable);
            })
 * SPDX-License-Identifier: Apache-2.0
    }  
    }
                        );  
            .expectedBucketOwner(blobStore.expectedBucketOwner())
        }  
                            .bucket(blobStore.bucket())  
        }
                            blobPartInputStreamFutures.add(
            );  
                } catch (Exception ex) {
                public void onComplete() {
import software.amazon.awssdk.core.async.AsyncResponseTransformer;  
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
            S3AsyncClient s3AsyncClient = asyncClientReference.get().client();  
    @Override
    }
            .bucket(blobStore.bucket())
import org.opensearch.common.blobstore.InputStreamWithMetadata;
            ListObjectsV2Request listRequest = ListObjectsV2Request.builder()
            throw new IOException("Future got interrupted", e);
            final List<ListObjectsV2Response> results = new ArrayList<>();
            .acl(blobStore.getCannedACL())  
            throw new IllegalArgumentException("Upload request size [" + blobSize + "] can't be larger than " + MAX_FILE_SIZE);
        );
            AccessController.doPrivileged(() -> clientReference.get().completeMultipartUpload(completeMultipartUploadRequest));
import org.opensearch.core.common.unit.ByteSizeUnit;
        }  
                );
                        deletedBytes.addAndGet(s3Object.size());  
                }) : "Response contained children for listed common prefixes.";
                } else if (writeContext.getWritePriority() == WritePriority.NORMAL) {
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
import software.amazon.awssdk.services.s3.model.CompletedPart;
                    throw new IllegalStateException("Cannot perform upload for other priority types.");
            .contentLength(blobSize)
            for (ListObjectsV2Response listObjectsV2Response : listObjectsIterable) {
    }
            }
            .expectedBucketOwner(blobStore.expectedBucketOwner());  
 * GitHub history for details.
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
            blobStore.bucket(),
    public InputStream readBlob(String blobName) throws IOException {
        return keyPath + blobName;  
     * @param s3AsyncClient Async client to be utilized to fetch the object part
    @Override
}  
        PutObjectRequest putObjectRequest = putObjectRequestBuilder.build();
        UploadRequest uploadRequest,  
    }
     * write only - a 404 carrying {@code NoSuchKey}. S3 fails an {@code If-Match} write with 404 rather than 412 when
        // This container returns streams that must be fully consumed, so we tell consumers to make bounded requests.
     */
        final int nbParts = multiparts.v1().intValue();
                            .build()  
    S3BlobContainer(BlobPath path, S3BlobStore blobStore) {
                executeSingleUpload(blobStore, buildKey(blobName), inputStream, blobSize, metadata, cryptoMetadata);
                    logger.debug("Found {} objects to delete in current batch for path [{}]", response.contents().size(), keyPath);
            blobMetadataFuture.whenComplete((blobMetadata, throwable) -> {
        }
        if ((isMultipartObject && contentRange == null) || contentLength == null) {  
                StreamContext streamContext = AccessController.doPrivileged(
 *
        // As AWS S3 returns list of keys in Lexicographic order, we don't have to fetch all the keys in order to sort them
    /**
            .storageClass(blobStore.getStorageClass())
            } else {  
        );
    }
            putObjectRequestBuilder.ifNoneMatch("*");
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
            logger.info("exception error from blob container for file {}", writeContext.getFileName());
        if (blobNameSortOrder != BlobNameSortOrder.LEXICOGRAPHIC) {
        ListObjectsV2Request listObjectsRequest,  
                List<BlobMetadata> blobs = executeListing(clientReference, listObjectsRequest(prefix, limit), limit).stream()
                }
                completionListener.onFailure(ex);
        writeBlobWithMetadata(blobName, inputStream, blobSize, failIfAlreadyExists, null);
 *  
                    listingFuture.completeExceptionally(new IOException("Failed to list objects for deletion", t));  
            }
 * this file be licensed under the Apache-2.0 license or a
        } catch (Exception e) {  
        final long partSize = blobStore.bufferSizeInBytes();
                try {  
        } catch (Exception ex) {  
            createMultipartUploadRequestBuilder.metadata(metadata);
     * along with the size of the last (or unique) part.
            writeContext.doRemoteDataIntegrityCheck(),
            if (isConditionFailure(e, expectedVersionToken != null)) {  
                .bucket(blobStore.bucket())  
            });  
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
                    listener.onFailure(ex);
                .map(s3Object -> new PlainBlobMetadata(s3Object.key().substring(keyPath.length()), s3Object.size()))  
                final UploadPartResponse uploadResponse = AccessController.doPrivileged(
                .bucket(bucketName)  
    // non-static, package private for testing
    ) throws IOException {
                    () -> clientReference.get()
                private final List<String> objectsToDelete = new ArrayList<>();
 * KIND, either express or implied.  See the License for the
                    .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().multipartUploadMetricCollector))
    private static List<ListObjectsV2Response> executeListing(
        }
        S3AsyncClient s3AsyncClient,
            throw new IOException("Exception when listing blobs by prefix [" + prefix + "]", e);  
            final ResponseBytes<GetObjectResponse> responseBytes = AccessController.doPrivileged(
        final boolean isMultipartObject = partNumber != null;
import software.amazon.awssdk.services.s3.model.UploadPartResponse;
            final String bucketName = blobStore.bucket();  
                } catch (Exception ex) {
            S3AsyncDeleteHelper.executeDeleteChain(s3AsyncClient, blobStore, keysToDelete, CompletableFuture.completedFuture(null), null)  
                    .key(blobName)
        }
import java.util.concurrent.TimeUnit;
    }  
                @Override
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
                            deletionChain,
        boolean success = false;
                            s3AsyncClient,
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
        final String blobName,
            return executeListing(clientReference, listObjectsRequest(keyPath)).stream().flatMap(listObjectsResponse -> {  
    public void writeBlob(String blobName, InputStream inputStream, long blobSize, boolean failIfAlreadyExists) throws IOException {  
     * the stream and its related metadata.  
     * @param blobName Identifier of the blob for which the metadata will be fetched
    @Override
        String blobName,  
                .whenComplete((v, throwable) -> {
        }
    }
                        deletionChain = S3AsyncDeleteHelper.executeDeleteChain(  
    public InputStreamWithMetadata readBlobWithMetadata(String blobName) throws IOException {
                        HeadObjectRequest.builder()
        return getFutureValue(future);
     * @param totalSize the total size
    public void deleteAsync(ActionListener<DeleteResult> completionListener) {  
                }
        } catch (Exception e) {
    public DeleteResult delete() throws IOException {
    private static boolean isConditionFailure(S3Exception e, boolean isCompareAndSwap) {
    private final S3BlobStore blobStore;
        AccessController.doPrivilegedChecked(() -> {  
                            )
        String mergeEncContext = SseKmsUtil.mergeAndEncodeEncryptionContexts(
import java.util.function.Function;
    CompletableFuture<InputStreamContainer> getBlobPartInputStreamContainer(
        } finally {
                public void onSubscribe(Subscription s) {
            if (content.length > sizeBound) {
                .thenApply(response -> transformResponseToInputStreamContainer(response, isMultipartObject))  
            List<String> keysToDelete = blobNames.stream().map(this::buildKey).collect(Collectors.toList());
        // Delegate to crypto-aware version with null CryptoMetadata  
            .expectedBucketOwner(blobStore.expectedBucketOwner())
            throw new IllegalArgumentException("Conditional write request size [" + blobSize + "] can't be larger than buffer size");
                }
        PlainActionFuture<Void> future = new PlainActionFuture<>();
                "Multipart upload request size [" + blobSize + "] can't be larger than " + MAX_FILE_SIZE_USING_MULTIPART
            () -> s3AsyncClient.getObject(getObjectRequestBuilder.build(), AsyncResponseTransformer.toBlockingInputStream())
            CompletableFuture<Void> listingFuture = new CompletableFuture<>();  
import org.reactivestreams.Subscriber;
     * Retrieves the metadata like checksum, object size and parts for the provided blob within the S3 bucket.
        final GetObjectRequest.Builder getObjectRequestBuilder = GetObjectRequest.builder()
            .bucket(blobStore.bucket())
            completionListener.onFailure(new IOException("Failed to initiate async deletion", e));
                        crypto
        String indexKmsKey = null;
                throw new BlobVersionConflictException(
                        int fullBatchesCount = objectsToDelete.size() / bulkDeleteSize;
                    for (CommonPrefix commonPrefix : listObjectsResponse.commonPrefixes()) {
    @Override
        }  
     * the key has no current version at all (deleted, or a delete marker): the version the caller presented provably
        final GetObjectResponse getObjectResponse = streamResponse.response();  
                        } else {  
import org.opensearch.common.blobstore.BlobVersionConflictException;  
            int totalObjects = 0;
        throws IOException {  
            throw new IOException("Unable to upload object [" + blobName + "] using a single upload", e);
     * what a swept acknowledgement path looks like to a superseded writer, and it matches
                () -> clientReference.get()  
            indexEncContext,  
                    .collect(Collectors.toList());
    static Tuple<Long, Long> numberOfMultiparts(final long totalSize, final long partSize) {  
                    });
    }
        S3AsyncClient s3AsyncClient,
                    if (objectsToDelete.size() >= bulkDeleteSize) {
            requestInputStream = new BufferedInputStream(input, (int) (partSize + 1));
    /**  
    public boolean isConditionalWriteSupported() {
            .objectAttributes(ObjectAttributes.CHECKSUM, ObjectAttributes.OBJECT_SIZE, ObjectAttributes.OBJECT_PARTS)
            // If file size is greater than the queue capacity than SizeBasedBlockingQ will always reject the upload.  
            if (blobSize <= getLargeBlobThresholdInBytes()) {
     */
            .contentLength(blobSize)
        // Fetch blob metadata - part info, size, checksum  
                            .key(buildKey(blobName))
            .storageClass(blobStore.getStorageClass())
import java.util.concurrent.TimeoutException;
        } catch (NoSuchKeyException e) {
import software.amazon.awssdk.core.sync.RequestBody;
                        );  
            writeContext.getWritePriority(),
            return response.eTag();
                        deletedBlobs.get(),  
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {  
                        uploadRequest.getKey(),  
                throw new IOException("Exception when listing blobs by prefix [" + prefix + "]", e);
            completionListener.onFailure(new IOException("Failed to initiate async blob deletion", e));  
            .acl(blobStore.getCannedACL())
     * Uploads a blob using a single upload request
        }
                throw new IOException(  
            // If-Match against a key with no current version. NoSuchKey is required: a 404 without it (NoSuchBucket,
    }
                    }
    }  
     * @param partSize  the part size
        // 412 Precondition Failed is unambiguous: the If-Match/If-None-Match condition was not met.
            );
import java.io.BufferedInputStream;
        }  
        final S3BlobStore blobStore,
        return true;
/*  
                    () -> writeContext.getStreamProvider(uploadRequest.getContentLength())  
    }
    }
        }  
    private static final long DEFAULT_OPERATION_TIMEOUT = TimeUnit.SECONDS.toSeconds(30);  
            .expectedBucketOwner(blobStore.expectedBucketOwner());
            .uploadObject(s3AsyncClient, uploadRequest, streamContext, blobStore.getStatsMetricPublisher());
        try (AmazonAsyncS3Reference asyncClientReference = blobStore.asyncClientReference()) {
        try (AmazonAsyncS3Reference asyncClientReference = blobStore.asyncClientReference()) {
                .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().listObjectsMetricPublisher))
import org.opensearch.common.io.InputStreamContainer;
                private Subscription subscription;  
            .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().multipartUploadMetricCollector))  
    public List<BlobMetadata> listBlobsByPrefixInSortedOrder(String blobNamePrefix, int limit, BlobNameSortOrder blobNameSortOrder)  
            return executeListing(clientReference, listObjectsRequest(prefix)).stream()
        if (blobSize > MAX_FILE_SIZE.getBytes()) {
    @Override
                            blobStore,
    @ExperimentalApi  
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable;  
     * @param bucketName Name of the S3 bucket
    private static List<ListObjectsV2Response> executeListing(AmazonS3Reference clientReference, ListObjectsV2Request listObjectsRequest) {  
    @Override
            }  
                        if (throwable != null) {  
     */
                                throwable  
                        blobStore,
                    || blobStore.isPermitBackedTransferEnabled() == false) {  
                    );
import software.amazon.awssdk.services.s3.model.CompletedMultipartUpload;
        final GetObjectAttributesRequest getObjectAttributesRequest = GetObjectAttributesRequest.builder()
                    logger.debug("Subscribed to list objects publisher for path [{}]", keyPath);
        // we fall-back to default implementation of fetching all the keys and sorting them.
 * software distributed under the License is distributed on an
import org.apache.logging.log4j.LogManager;
        }  
    ) {  
        @Nullable CryptoMetadata cryptoMetadata  
            return results;
            }
                                () -> new ParameterizedMessage("Failed to complete deletion chain for path [{}]", keyPath),
            requestInputStream = input;
 * this work for additional information regarding copyright
            .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().listObjectsMetricPublisher))
                        );  
        // We fetch only keys as per the given limit to optimize the fetch. If provided sort order is not Lexicographic,  
                if (writeContext.getWritePriority() == WritePriority.URGENT
    ) throws IOException {
        final GetObjectRequest getObjectRequest = GetObjectRequest.builder()  
import org.opensearch.repositories.s3.async.S3AsyncDeleteHelper;
        });  
                        objectsToDelete.add(s3Object.key());
import software.amazon.awssdk.services.s3.S3AsyncClient;  
    public boolean blobExists(String blobName) {  
                            .expectedBucketOwner(blobStore.expectedBucketOwner())
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Publisher;
    public Map<String, BlobMetadata> listBlobs() throws IOException {
import java.io.ByteArrayInputStream;  
                });
                            final int innerPartNumber = partNumber;
     * {@code NoSuchKey} (e.g. {@code NoSuchBucket}) stays an ordinary {@link IOException}, and a create-if-absent  
        @Nullable Map<String, String> metadata
            }
                && blobStore.getLowPrioritySizeBasedBlockingQ().isMaxCapacityBelowContentLength(uploadRequest.getContentLength()) == false)  
import java.util.ArrayList;
                if (throwable != null) {  
                    );  
                );
                            return true;
    public VersionedBlob readBlobWithVersion(String blobName) throws IOException {  
                try {
                    if (throwable != null) {
    /**  
            putObjectRequestBuilder.ifMatch(expectedVersionToken);
    }
    @Override  
import org.opensearch.common.blobstore.stream.read.ReadContext;
    @Override
    @Override  
        try (AmazonAsyncS3Reference amazonS3Reference = AccessController.doPrivileged(blobStore::asyncClientReference)) {
        } catch (final SdkException e) {
        return true;  
 *
    public InputStream readBlob(String blobName, long position, long length) throws IOException {  
                .key(blobName)
    ) {
    /**  
        }
            return Tuple.tuple(parts + 1, remaining);  
                    final List<ReadContext.StreamPartCreator> blobPartInputStreamFutures = new ArrayList<>();  
                    .uploadId(uploadId.get())  
        }  
    // package private for testing  
        return new InputStreamWithMetadata(s3RetryingInputStream, s3RetryingInputStream.getMetadata());  
import org.opensearch.common.SetOnce;
            indexEncContext = crypto.getEncryptionContext().orElse(null);  
     * ({@code If-None-Match: *}) never 404s on the object itself. Every other 409 - including
    @Override
import org.reactivestreams.Subscription;
import org.opensearch.repositories.s3.async.UploadRequest;  
            return "NoSuchKey".equals(errorCode);
     * ordinary {@link IOException} and be retried: the retry resolves it definitively (a 412 if the CAS was genuinely
                            batchToDelete,  
            .bucket(bucketName)
                    && blobStore.getNormalPrioritySizeBasedBlockingQ()  
        // Extra safety checks  
            throw new IOException("Delete operation timed out after 30 seconds", e);
                }
            if (limit < 0) {
            indexKmsKey != null ? indexKmsKey : blobStore.serverSideEncryptionKmsKey(),  
    private static final Set<String> CONDITIONAL_WRITE_CONFLICT_ERROR_CODES = Set.of("PreconditionFailed");
                    );  
                public void onError(Throwable t) {
                    });
        long blobSize,
            mergeEncContext,
        writeBlob(blobName, inputStream, blobSize, failIfAlreadyExists);
        } catch (final SdkException e) {
            final byte[] content = responseBytes.asByteArray();
            // compare-and-swap on the version token (ETag) observed at read time
                                () -> getBlobPartInputStreamContainer(s3AsyncClient, bucketName, blobKey, innerPartNumber)  
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;  
                    } else {
import org.opensearch.common.blobstore.BlobContainer;
        } catch (Exception e) {
            // create-if-absent
            throw new IllegalArgumentException("length must be non-negative");
        }  
                try (AmazonS3Reference clientReference = blobStore.clientReference()) {  
        deleteAsync(future);
     */  
                    .headObject(
        try {
                Exception ex = throwable instanceof Error ? new Exception(throwable) : (Exception) throwable;
            listPublisher.subscribe(new Subscriber<>() {
        } else {  
import software.amazon.awssdk.services.s3.model.GetObjectAttributesRequest;
            .storageClass(blobStore.getStorageClass())  
        throws IOException {
                .filter(name -> name.isEmpty() == false)  
            );  
                        List<String> batchToDelete = new ArrayList<>(objectsToDelete.subList(0, itemsToDelete));
                        logger.debug("Executing bulk delete of {} objects for path [{}]", batchToDelete.size(), keyPath);
    void ensureMultiPartUploadSize(final long blobSize) {
                } else if (writeContext.getWritePriority() == WritePriority.HIGH) {
                    } else {
                    return false;
     * @return a {@link Tuple} containing the number of parts to fill {@code totalSize} and  
    ) throws IOException {
            StreamContext streamContext = AccessController.doPrivileged(() -> writeContext.getStreamProvider(partSize));
        if ((totalSize == 0L) || (totalSize <= partSize)) {
        }  
            .key(blobName)  
            .key(blobName)  
     * @param isMultipartObject Flag to denote a multipart object response
                );
                            logger.debug("Successfully completed deletion chain for path [{}]", keyPath);
