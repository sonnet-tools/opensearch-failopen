        UploadRequest uploadRequest,
            return null;
            return;
                inputStream = AsyncPartsHandler.maybeRetryInputStream(
            }
                    deleteUploadedObject(s3AsyncClient, uploadRequest);
        }
        try {
    @SuppressWarnings("rawtypes")
                        uploadRequest.getKey(),
        AccessController.doPrivileged(() -> s3AsyncClient.deleteObject(deleteObjectRequest)).exceptionally(throwable -> {
                maxRetryablePartSize
    ) {
            .expectedBucketOwner(uploadRequest.getExpectedBucketOwner())
        if (CollectionUtils.isNotEmpty(uploadRequest.getMetadata())) {
    private final long minimumPartSize;
    private void deleteUploadedObject(S3AsyncClient s3AsyncClient, UploadRequest uploadRequest) {
        AtomicReferenceArray<CheckedContainer> inputStreamContainers,
        String fileName,
    private static long fromBase64String(String base64String) {
    public long calculateOptimalPartSize(long contentLengthOfSource, WritePriority writePriority, boolean uploadRetryEnabled) {
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
     * @param streamContext The {@link StreamContext} to supply streams during upload
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
import java.util.Arrays;
import org.opensearch.core.common.unit.ByteSizeUnit;
/*
                );
        }
        long resultantChecksum = fromBase64String(inputStreamContainers.get(0).getChecksum());
        ExecutorService executorService,
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
                    () -> new ParameterizedMessage(
        UploadRequest uploadRequest,
    /**
 * SPDX-License-Identifier: Apache-2.0
            }).handle((resp, throwable) -> {
                if (throwable != null) {
     * @param uploadRequest The {@link UploadRequest} object encapsulating all relevant details for upload
                handleException(returnFuture, () -> "Failed to send multipart upload requests.", throwable);
        CompletableFuture<Void> returnFuture,
            .multipartUpload(CompletedMultipartUpload.builder().parts(parts).build())
                log.error(() -> new ParameterizedMessage("Failed to close stream while uploading single file {}.", file), e);
                releaseResourcesSafely(semaphore, finalInputStream, uploadRequest.getKey());
                AsyncPartsHandler.cleanUpParts(s3AsyncClient, uploadRequest, uploadId);
     * Upload an object to S3 using the async client
        }
        log.debug(() -> new ParameterizedMessage("Sending completeMultipartUploadRequest, uploadId: {}", uploadId));
}
        UploadRequest uploadRequest,
        try {
            .build();
    private final TransferSemaphoresHolder transferSemaphoresHolder;
            .uploadId(uploadId)
        }
                    maxRetryablePartSize
            streamReadExecutor = urgentExecutorService;
        if (cause instanceof Error) {
    private static final Logger log = LogManager.getLogger(AsyncTransferManager.class);
        ExecutorService streamReadExecutor;
            return new ByteSizeValue(5, ByteSizeUnit.MB).getBytes();
        }
import org.opensearch.common.io.InputStreamContainer;
                if (throwable != null) {
            return null;
        }
                inputStream.close();
                    )
    private static String base64StringFromLong(Long val) {
                uploadRequest,
            .bucket(uploadRequest.getBucket())
                Semaphore semaphore = AsyncPartsHandler.maybeAcquireSemaphore(
            if (uploadRequest.doRemoteDataIntegrityCheck()) {
            try {
            if (streamContext.getNumberOfParts() == 1) {
        optimalPartSize = Math.ceil(optimalPartSize);
import java.util.concurrent.atomic.AtomicReferenceArray;
                log.debug(() -> "Starting the upload as a single upload part request");
                            throw new RuntimeException(new CorruptFileException(s3Exception, uploadRequest.getKey()));
            result <<= 8;
            } finally {
        })
import java.util.stream.IntStream;
                    Throwable unwrappedThrowable = ExceptionsHelper.unwrap(throwable, S3Exception.class);
            try {
        Semaphore semaphore
                    inputStream,
                }
            CreateMultipartUploadResponse createMultipartUploadResponse = createMultipartUploadFuture.get();
                mergeAndVerifyChecksum(inputStreamContainers, uploadRequest.getKey(), uploadRequest.getExpectedChecksum());
                    transferSemaphoresHolder,
        CompletableFutureUtils.forwardExceptionTo(returnFuture, createMultipartUploadFuture);
import software.amazon.awssdk.http.HttpStatusCode;
        return AccessController.doPrivileged(() -> s3AsyncClient.completeMultipartUpload(completeMultipartUploadRequest));
    private final long maxRetryablePartSize;
        CompletableFuture<Void> putObjectFuture = AccessController.doPrivileged(() -> {
            result |= (decodedBytes[i] & 0xFF);
        AtomicReferenceArray<CheckedContainer> inputStreamContainers = new AtomicReferenceArray<>(streamContext.getNumberOfParts());
    private void doUploadInParts(
        // The list of completed parts must be sorted
            } catch (IOException e) {
        String uploadId;
        return Base64.getEncoder().encodeToString(Arrays.copyOfRange(ByteUtils.toByteArrayBE(val), 4, 8));
        CompletableFuture<Void> returnFuture,
        UploadRequest uploadRequest,
import software.amazon.awssdk.core.exception.SdkClientException;
package org.opensearch.repositories.s3.async;
        }
 * compatible open source license.
            }
        if (uploadRequest.doRemoteDataIntegrityCheck()) {
            });
     */
            .exceptionally(throwable -> {
        CompletableFutureUtils.allOfExceptionForwarded(futures.toArray(CompletableFuture[]::new)).thenApply(resp -> {
import org.opensearch.common.blobstore.stream.write.WritePriority;
        String uploadId
import org.opensearch.repositories.s3.StatsMetricPublisher;
            } catch (Exception e) {
        S3AsyncClient s3AsyncClient,
    private CompletableFuture<CompleteMultipartUploadResponse> completeMultipartUpload(
        StatsMetricPublisher statsMetricPublisher
    /**
    }
import org.apache.logging.log4j.LogManager;
     * @return A {@link CompletableFuture} to listen for upload completion
import org.opensearch.common.StreamContext;
import org.apache.logging.log4j.message.ParameterizedMessage;
import org.opensearch.common.util.ByteUtils;
        }
    private static void handleException(CompletableFuture<Void> returnFuture, Supplier<String> message, Throwable throwable) {
            handleException(returnFuture, () -> "Failed to initiate multipart upload", ex);
                priorityExecutorService,
            try {
                AsyncRequestBody asyncRequestBody = AsyncRequestBody.fromInputStream(
            }
            putObjectRequestBuilder.checksumCRC32(base64StringFromLong(uploadRequest.getExpectedChecksum()));
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
import java.util.concurrent.ExecutorService;
            .key(uploadRequest.getKey())
        this.maxRetryablePartSize = (long) (minimumPartSize + 0.1 * minimumPartSize);
            throw new IllegalArgumentException("Invalid Base64 encoded CRC32 checksum");
        TransferSemaphoresHolder transferSemaphoresHolder
                uploadInParts(s3AsyncClient, uploadRequest, streamContext, returnFuture, statsMetricPublisher);
        double optimalPartSize = contentLengthOfSource / (double) MAX_UPLOAD_PARTS;
    }
                            && "BadDigest".equals(s3Exception.awsErrorDetails().errorCode())) {
                    uploadRequest.getContentLength(),
        if (decodedBytes.length != 4) {
        StatsMetricPublisher statsMetricPublisher
                        if (s3Exception.statusCode() == HttpStatusCode.BAD_REQUEST
                InputStreamContainer inputStreamContainer = streamContext.provideStream(0);
                returnFuture.completeExceptionally(ex);
        String uploadId,
        // 10% buffer to allow additional metadata size in content such as encryption.
import software.amazon.awssdk.services.s3.model.CompletedPart;
        if (inputStream != null) {
                inputStreamContainers,
                AsyncPartsHandler.cleanUpParts(s3AsyncClient, uploadRequest, uploadId);
        }
        CompletableFutureUtils.forwardResultTo(putObjectFuture, returnFuture);
        PutObjectRequest.Builder putObjectRequestBuilder = PutObjectRequest.builder()
        StatsMetricPublisher statsMetricPublisher
        ExecutorService urgentExecutorService,
    }
        for (int index = 1; index < inputStreamContainers.length(); index++) {
    }
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
        }
                    } catch (IOException e) {
                log.debug(() -> "Starting the upload as multipart upload request");
import org.apache.logging.log4j.Logger;
    @SuppressWarnings("unchecked")
                }
    ) {
            return putObjectRespFuture.handle((resp, throwable) -> {
                streamContext,
        StatsMetricPublisher statsMetricPublisher
        CompletableFuture<Void> returnFuture,
            streamReadExecutor = executorService;
    private final ExecutorService executorService;
        long expectedChecksum
    /**
                    returnFuture.complete(null);
        CompletableFutureUtils.forwardExceptionTo(returnFuture, putObjectFuture);
        S3AsyncClient s3AsyncClient,
    ) {
            futures = AsyncPartsHandler.uploadParts(
    }
                return null;
                    returnFuture.completeExceptionally(throwable);
     *
                    uploadInOneChunk(s3AsyncClient, uploadRequest, streamContext, returnFuture, statsMetricPublisher, semaphore);
     * The max number of parts on S3 side is 10,000
                TransferSemaphoresHolder.RequestContext requestContext = transferSemaphoresHolder.createRequestContext();
            } else {
                    uploadRequest.getWritePriority(),
                        throwable.getClass().getSimpleName() + ": " + throwable.getMessage()
                );
                        throw new RuntimeException(e);
import java.util.concurrent.CompletionException;
                    returnFuture.completeExceptionally(throwable);
        long result = 0;
        CompletableFuture<Void> returnFuture,
                    requestContext,
            return;
        for (int i = 0; i < 4; i++) {
    }
        S3AsyncClient s3AsyncClient,
    private final ExecutorService urgentExecutorService;
        CompletableFuture<CreateMultipartUploadResponse> createMultipartUploadFuture = AccessController.doPrivileged(
 * this file be licensed under the Apache-2.0 license or a
        this.transferSemaphoresHolder = transferSemaphoresHolder;
        if (uploadRetryEnabled && (writePriority == WritePriority.HIGH || writePriority == WritePriority.URGENT)) {
            InputStream inputStream = null;
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadResponse;
                log.warn(
    /**
                );
    }
        List<CompletableFuture<CompletedPart>> futures;
            // We should never execute latent operation like acquisition of permit in future completion pool.
                    throw ex;
            createMultipartUploadRequestBuilder.metadata(uploadRequest.getMetadata());
                        semaphore.release();
        StreamContext streamContext,
                s3AsyncClient,
            .bucket(uploadRequest.getBucket())
        } catch (Throwable throwable) {
            .build();
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
    private void uploadInParts(
                    }
    public CompletableFuture<Void> uploadObject(
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
            .overrideConfiguration(o -> o.addMetricPublisher(statsMetricPublisher.multipartUploadMetricCollector))
    }
        }).thenApply(ignore -> {
                returnFuture.complete(null);
     */
import software.amazon.awssdk.utils.CollectionUtils;
    }
        this.priorityExecutorService = priorityExecutorService;
            return null;
import java.util.Base64;
                    if (unwrappedThrowable != null) {
                releaseResourcesSafely(semaphore, inputStream, uploadRequest.getKey());
                    uploadRequest.getWritePriority(),
     * Calculates the optimal part size of each part request if the upload operation is carried out as multipart upload.
            );
import java.util.List;
        });
                try {
                        uploadRequest.getUploadFinalizer().accept(true);
                uploadRequest.isUploadRetryEnabled(),
        StreamContext streamContext,
                throw new RuntimeException(e);
        UploadRequest uploadRequest,
import static org.opensearch.repositories.s3.utils.SseKmsUtil.configureEncryptionSettings;
        ExecutorService priorityExecutorService,
        if (uploadRequest.doRemoteDataIntegrityCheck()) {
        PutObjectRequest putObjectRequest = putObjectRequestBuilder.build();
        } catch (Exception ex) {
        // Ensure cancellations are forwarded to the createMultipartUploadFuture future
            .thenCompose(ignore -> completeMultipartUpload(s3AsyncClient, uploadRequest, uploadId, completedParts, statsMetricPublisher))
            putObjectRequestBuilder.metadata(uploadRequest.getMetadata());
            returnFuture.completeExceptionally(exception);
        } else {
        S3AsyncClient s3AsyncClient,
        S3AsyncClient s3AsyncClient,
        }
            createMultipartUploadRequestBuilder.checksumAlgorithm(ChecksumAlgorithm.CRC32);
                    uploadRequest.isUploadRetryEnabled(),
        if (CollectionUtils.isNotEmpty(uploadRequest.getMetadata())) {
            // Block main thread here so that upload of parts doesn't get executed in future completion thread.
        }
import org.opensearch.ExceptionsHelper;
import java.io.IOException;
 */
            .expectedBucketOwner(uploadRequest.getExpectedBucketOwner());
            }
import com.jcraft.jzlib.JZlib;
        doUploadInParts(s3AsyncClient, uploadRequest, streamContext, returnFuture, uploadId, statsMetricPublisher);
                transferSemaphoresHolder,
        };
        if (uploadRequest.getWritePriority() == WritePriority.URGENT) {
        return (long) Math.max(optimalPartSize, minimumPartSize);
            InputStream finalInputStream = inputStream;
 * A helper class that automatically uses multipart upload based on the size of the source object
        this.urgentExecutorService = urgentExecutorService;
    private final ExecutorService priorityExecutorService;
            .contentLength(uploadRequest.getContentLength())
        }
     *
                uploadId,
        });
import software.amazon.awssdk.services.s3.model.CompletedMultipartUpload;
import org.opensearch.repositories.s3.io.CheckedContainer;
    private BiFunction<CompleteMultipartUploadResponse, Throwable, Void> handleExceptionOrResponse(
            SdkClientException exception = SdkClientException.create(message.get(), cause);
        } else if (uploadRequest.getWritePriority() == WritePriority.HIGH) {
import java.util.function.Supplier;
        return (response, throwable) -> {
import java.util.concurrent.CompletableFuture;
/**
            });
                }
import java.util.concurrent.Semaphore;
            resultantChecksum = JZlib.crc32_combine(resultantChecksum, curChecksum, inputStreamContainers.get(index).getContentLength());
            try {
import software.amazon.awssdk.utils.CompletableFutureUtils;
    private void uploadInOneChunk(
                        uploadId,
    }
    }
import software.amazon.awssdk.services.s3.S3AsyncClient;
import org.opensearch.core.common.unit.ByteSizeValue;
    ) {
            .key(uploadRequest.getKey())
                    uploadRequest.getKey()
        String uploadId,
                urgentExecutorService,
        if (resultantChecksum != expectedChecksum) {
        AtomicReferenceArray<CompletedPart> completedParts,
    ) {
            returnFuture.completeExceptionally(cause);
        if (semaphore != null) {
        S3AsyncClient s3AsyncClient,
            }
        }
    public AsyncTransferManager(
            putObjectRequestBuilder.checksumAlgorithm(ChecksumAlgorithm.CRC32);
        CompletedPart[] parts = IntStream.range(0, completedParts.length()).mapToObj(completedParts::get).toArray(CompletedPart[]::new);
                return CompletableFuture.failedFuture(e);
        configureEncryptionSettings(createMultipartUploadRequestBuilder, uploadRequest);
            uploadId = createMultipartUploadResponse.uploadId();
            if (throwable != null) {
        }
import software.amazon.awssdk.services.s3.model.S3Exception;
 *
                    if (semaphore != null) {
            .handle(handleExceptionOrResponse(s3AsyncClient, uploadRequest, returnFuture, uploadId))
        if (contentLengthOfSource < ByteSizeUnit.MB.toBytes(5)) {
        return returnFuture;
public final class AsyncTransferManager {
    }
        } else {
        CompletableFuture<Void> returnFuture = new CompletableFuture<>();
        this.executorService = executorService;
    ) {
        this.minimumPartSize = minimumPartSize;
                    }
            () -> s3AsyncClient.createMultipartUpload(createMultipartUploadRequestBuilder.build())
            throw new RuntimeException(new CorruptFileException("File level checksums didn't match combined part checksums", fileName));
        return result;
            return contentLengthOfSource;
     * @param minimumPartSize         The minimum part size for parallel multipart uploads
                statsMetricPublisher,
 */
            } else {
    ) {
        CreateMultipartUploadRequest.Builder createMultipartUploadRequestBuilder = CreateMultipartUploadRequest.builder()
        AtomicReferenceArray<CompletedPart> completedParts = new AtomicReferenceArray<>(streamContext.getNumberOfParts());
            returnFuture.completeExceptionally(throwable);
                putObjectRespFuture = s3AsyncClient.putObject(putObjectRequest, asyncRequestBody);
     */
            return resp;
                executorService,
        StreamContext streamContext,
        Throwable cause = throwable instanceof CompletionException ? throwable.getCause() : throwable;
                return null;
        }
        } catch (Exception ex) {
        }
                } else {
                } catch (Exception ex) {
                    inputStreamContainer.getContentLength(),
            } catch (IOException e) {
            CompletableFuture<PutObjectResponse> putObjectRespFuture;
                    streamReadExecutor
        UploadRequest uploadRequest,
                    }
import org.opensearch.common.blobstore.exception.CorruptFileException;
     * Construct a new object of AsyncTransferManager
            .bucket(uploadRequest.getBucket())
            log.debug(() -> "Initiated new multipart upload, uploadId: " + createMultipartUploadResponse.uploadId());
                    inputStreamContainer.getInputStream(),
     */
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
            .expectedBucketOwner(uploadRequest.getExpectedBucketOwner())
import java.util.function.BiFunction;
            }
import software.amazon.awssdk.services.s3.model.ChecksumAlgorithm;
                );
            log.error(() -> new ParameterizedMessage("Failed to delete uploaded object of key {}", uploadRequest.getKey()), throwable);
            .bucket(uploadRequest.getBucket())
    ) {
        StatsMetricPublisher statsMetricPublisher,
     * @param s3AsyncClient S3 client to use for upload
        StreamContext streamContext,
                handleException(returnFuture, () -> "Unexpected exception occurred", throwable);
                    try {
            .key(uploadRequest.getKey())
    @SuppressWarnings("rawtypes")
            .expectedBucketOwner(uploadRequest.getExpectedBucketOwner());
        configureEncryptionSettings(putObjectRequestBuilder, uploadRequest);
    }
        long minimumPartSize,
            long curChecksum = fromBase64String(inputStreamContainers.get(index).getChecksum());
                return null;
    private static final long MAX_UPLOAD_PARTS = 10_000;
            semaphore.release();
        try {
            .overrideConfiguration(o -> o.addMetricPublisher(statsMetricPublisher.multipartUploadMetricCollector))
                uploadRequest.getUploadFinalizer().accept(true);
            }
                completedParts,
            .key(uploadRequest.getKey())
    private void mergeAndVerifyChecksum(
        );
    }
                        }
import java.io.InputStream;
        CompleteMultipartUploadRequest completeMultipartUploadRequest = CompleteMultipartUploadRequest.builder()
import software.amazon.awssdk.core.async.AsyncRequestBody;
    private void releaseResourcesSafely(Semaphore semaphore, InputStream inputStream, String file) {
                        "Multipart upload failed for file [{}] (upload id: {}), aborting. Cause: {}",
import org.opensearch.secure_sm.AccessController;
            streamReadExecutor = priorityExecutorService;
                        S3Exception s3Exception = (S3Exception) unwrappedThrowable;
 * The OpenSearch Contributors require contributions made to
            .overrideConfiguration(o -> o.addMetricPublisher(statsMetricPublisher.putObjectMetricPublisher))
