        S3AsyncClient s3AsyncClient,
        try {
                    uploadRequest.isUploadRetryEnabled(),
        }  
            } else {
        }
import java.util.concurrent.Semaphore;  
            returnFuture.completeExceptionally(exception);
    private void deleteUploadedObject(S3AsyncClient s3AsyncClient, UploadRequest uploadRequest) {  
                } catch (Exception ex) {
    }  
    private static final long MAX_UPLOAD_PARTS = 10_000;  
        log.debug(() -> new ParameterizedMessage("Sending completeMultipartUploadRequest, uploadId: {}", uploadId));  
        CreateMultipartUploadRequest.Builder createMultipartUploadRequestBuilder = CreateMultipartUploadRequest.builder()
                maxRetryablePartSize
import software.amazon.awssdk.utils.CollectionUtils;
            .thenCompose(ignore -> completeMultipartUpload(s3AsyncClient, uploadRequest, uploadId, completedParts, statsMetricPublisher))
    }
     * @param minimumPartSize         The minimum part size for parallel multipart uploads
                handleException(returnFuture, () -> "Failed to send multipart upload requests.", throwable);
    private CompletableFuture<CompleteMultipartUploadResponse> completeMultipartUpload(
        String fileName,
    /**  
        String uploadId;  
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;  
        this.transferSemaphoresHolder = transferSemaphoresHolder;  
            );
        PutObjectRequest.Builder putObjectRequestBuilder = PutObjectRequest.builder()  
        CompletedPart[] parts = IntStream.range(0, completedParts.length()).mapToObj(completedParts::get).toArray(CompletedPart[]::new);
    /**  
     * @param streamContext The {@link StreamContext} to supply streams during upload
        ExecutorService executorService,
import org.apache.logging.log4j.Logger;
    private final long minimumPartSize;  
    private final ExecutorService urgentExecutorService;
                    maxRetryablePartSize
            result <<= 8;
            .key(uploadRequest.getKey())
        S3AsyncClient s3AsyncClient,
    public CompletableFuture<Void> uploadObject(
import software.amazon.awssdk.services.s3.model.S3Exception;  
        UploadRequest uploadRequest,
 * A helper class that automatically uses multipart upload based on the size of the source object
            .expectedBucketOwner(uploadRequest.getExpectedBucketOwner())
}  
        AtomicReferenceArray<CheckedContainer> inputStreamContainers = new AtomicReferenceArray<>(streamContext.getNumberOfParts());
        long minimumPartSize,  
                uploadRequest.getUploadFinalizer().accept(true);
     */  
                    )
    ) {
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
            } catch (Exception e) {  
import java.io.InputStream;
                transferSemaphoresHolder,  
            return null;  
            try {  
/**
            if (streamContext.getNumberOfParts() == 1) {
            long curChecksum = fromBase64String(inputStreamContainers.get(index).getChecksum());
     * Construct a new object of AsyncTransferManager  
            putObjectRequestBuilder.checksumCRC32(base64StringFromLong(uploadRequest.getExpectedChecksum()));  
                        semaphore.release();  
            .build();
     * @return A {@link CompletableFuture} to listen for upload completion  
            .bucket(uploadRequest.getBucket())
                    }
        CompletableFutureUtils.forwardResultTo(putObjectFuture, returnFuture);
 * The OpenSearch Contributors require contributions made to  
        ExecutorService priorityExecutorService,
        }  
                    deleteUploadedObject(s3AsyncClient, uploadRequest);
                    }
     */
    /**
    public AsyncTransferManager(
            InputStream inputStream = null;
        }  
                        "Multipart upload failed for file [{}] (upload id: {}), aborting. Cause: {}",  
    }
        String uploadId,
                    returnFuture.completeExceptionally(throwable);
            // We should never execute latent operation like acquisition of permit in future completion pool.  
import java.io.IOException;
 */  
            .uploadId(uploadId)
            CreateMultipartUploadResponse createMultipartUploadResponse = createMultipartUploadFuture.get();
            });  
     */
        this.executorService = executorService;  
        return returnFuture;  
import org.opensearch.core.common.unit.ByteSizeUnit;
        String uploadId,
import software.amazon.awssdk.core.exception.SdkClientException;
        if (semaphore != null) {
            .overrideConfiguration(o -> o.addMetricPublisher(statsMetricPublisher.multipartUploadMetricCollector))  
            .handle(handleExceptionOrResponse(s3AsyncClient, uploadRequest, returnFuture, uploadId))
                if (throwable != null) {  
                        }
     * @param uploadRequest The {@link UploadRequest} object encapsulating all relevant details for upload
            .key(uploadRequest.getKey())
import static org.opensearch.repositories.s3.utils.SseKmsUtil.configureEncryptionSettings;
    ) {  
            throw new IllegalArgumentException("Invalid Base64 encoded CRC32 checksum");  
                    inputStreamContainer.getContentLength(),
                        uploadRequest.getUploadFinalizer().accept(true);  
            return new ByteSizeValue(5, ByteSizeUnit.MB).getBytes();
        StreamContext streamContext,  
                    Throwable unwrappedThrowable = ExceptionsHelper.unwrap(throwable, S3Exception.class);
            // Block main thread here so that upload of parts doesn't get executed in future completion thread.
    }
        if (CollectionUtils.isNotEmpty(uploadRequest.getMetadata())) {
        });
    private BiFunction<CompleteMultipartUploadResponse, Throwable, Void> handleExceptionOrResponse(
import org.opensearch.common.util.ByteUtils;  
            throw new RuntimeException(new CorruptFileException("File level checksums didn't match combined part checksums", fileName));  
        StatsMetricPublisher statsMetricPublisher  
            .exceptionally(throwable -> {  
    private static void handleException(CompletableFuture<Void> returnFuture, Supplier<String> message, Throwable throwable) {
        // The list of completed parts must be sorted  
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
        try {
            try {
        if (cause instanceof Error) {
            returnFuture.completeExceptionally(throwable);  
        byte[] decodedBytes = Base64.getDecoder().decode(base64String);
                            && "BadDigest".equals(s3Exception.awsErrorDetails().errorCode())) {
            CompletableFuture<PutObjectResponse> putObjectRespFuture;
            if (throwable != null) {  
import org.opensearch.repositories.s3.io.CheckedContainer;
                mergeAndVerifyChecksum(inputStreamContainers, uploadRequest.getKey(), uploadRequest.getExpectedChecksum());  
            () -> s3AsyncClient.createMultipartUpload(createMultipartUploadRequestBuilder.build())  
import org.opensearch.common.StreamContext;
        doUploadInParts(s3AsyncClient, uploadRequest, streamContext, returnFuture, uploadId, statsMetricPublisher);  
            streamReadExecutor = executorService;  
        if (contentLengthOfSource < ByteSizeUnit.MB.toBytes(5)) {
        return (long) Math.max(optimalPartSize, minimumPartSize);  
                return null;
                }  
import com.jcraft.jzlib.JZlib;  
        this.maxRetryablePartSize = (long) (minimumPartSize + 0.1 * minimumPartSize);
    private static long fromBase64String(String base64String) {  
        if (resultantChecksum != expectedChecksum) {
                }  
 * SPDX-License-Identifier: Apache-2.0
    }
        TransferSemaphoresHolder transferSemaphoresHolder
                releaseResourcesSafely(semaphore, inputStream, uploadRequest.getKey());
                return null;
            .expectedBucketOwner(uploadRequest.getExpectedBucketOwner());
            try {
        if (uploadRequest.getWritePriority() == WritePriority.URGENT) {
            return resp;  
        return AccessController.doPrivileged(() -> s3AsyncClient.completeMultipartUpload(completeMultipartUploadRequest));
                    requestContext,
    @SuppressWarnings("rawtypes")  
                        throwable.getClass().getSimpleName() + ": " + throwable.getMessage()  
                return null;
        try {
                Semaphore semaphore = AsyncPartsHandler.maybeAcquireSemaphore(
import java.util.List;
            returnFuture.completeExceptionally(cause);
    ) {
    private void uploadInParts(  
    private static final Logger log = LogManager.getLogger(AsyncTransferManager.class);
                    streamReadExecutor  
                releaseResourcesSafely(semaphore, finalInputStream, uploadRequest.getKey());
    private void releaseResourcesSafely(Semaphore semaphore, InputStream inputStream, String file) {
        String uploadId
            .key(uploadRequest.getKey())  
        Semaphore semaphore
                    }  
        }
            }).handle((resp, throwable) -> {
        StreamContext streamContext,
                uploadRequest.isUploadRetryEnabled(),
                    uploadInOneChunk(s3AsyncClient, uploadRequest, streamContext, returnFuture, statsMetricPublisher, semaphore);  
    }
                    returnFuture.complete(null);
            .bucket(uploadRequest.getBucket())  
        UploadRequest uploadRequest,
        double optimalPartSize = contentLengthOfSource / (double) MAX_UPLOAD_PARTS;
        CompletableFuture<Void> returnFuture,
            });  
            }
        CompletableFuture<CreateMultipartUploadResponse> createMultipartUploadFuture = AccessController.doPrivileged(
        CompletableFuture<Void> returnFuture,
                if (throwable != null) {  
        CompletableFuture<Void> returnFuture,
        configureEncryptionSettings(createMultipartUploadRequestBuilder, uploadRequest);  
            .key(uploadRequest.getKey())
import software.amazon.awssdk.services.s3.model.ChecksumAlgorithm;
import java.util.concurrent.CompletableFuture;  
        long expectedChecksum  
        for (int index = 1; index < inputStreamContainers.length(); index++) {  
import java.util.stream.IntStream;
        }  
        if (decodedBytes.length != 4) {
        return result;
                returnFuture.complete(null);  
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
        }
        AccessController.doPrivileged(() -> s3AsyncClient.deleteObject(deleteObjectRequest)).exceptionally(throwable -> {
import org.opensearch.core.common.unit.ByteSizeValue;
            try {
        AtomicReferenceArray<CheckedContainer> inputStreamContainers,
 * this file be licensed under the Apache-2.0 license or a
    }
package org.opensearch.repositories.s3.async;
import software.amazon.awssdk.services.s3.model.CompletedPart;  
        CompletableFuture<Void> returnFuture,
import org.apache.logging.log4j.LogManager;
            } catch (IOException e) {  
            createMultipartUploadRequestBuilder.metadata(uploadRequest.getMetadata());  
                AsyncPartsHandler.cleanUpParts(s3AsyncClient, uploadRequest, uploadId);
        long result = 0;
    @SuppressWarnings("unchecked")  
    @SuppressWarnings("rawtypes")
            semaphore.release();  
import org.opensearch.common.blobstore.stream.write.WritePriority;
        }  
                executorService,
        UploadRequest uploadRequest,
     * @param s3AsyncClient S3 client to use for upload  
import org.opensearch.common.io.InputStreamContainer;
        this.minimumPartSize = minimumPartSize;
        if (uploadRequest.doRemoteDataIntegrityCheck()) {
            futures = AsyncPartsHandler.uploadParts(  
            return putObjectRespFuture.handle((resp, throwable) -> {  
import software.amazon.awssdk.utils.CompletableFutureUtils;
            resultantChecksum = JZlib.crc32_combine(resultantChecksum, curChecksum, inputStreamContainers.get(index).getContentLength());
        ExecutorService urgentExecutorService,  
import org.opensearch.secure_sm.AccessController;
            }
            InputStream finalInputStream = inputStream;
                inputStream = AsyncPartsHandler.maybeRetryInputStream(
                } else {
    ) {
import java.util.concurrent.CompletionException;
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;  
    private final TransferSemaphoresHolder transferSemaphoresHolder;
            }  
            createMultipartUploadRequestBuilder.checksumAlgorithm(ChecksumAlgorithm.CRC32);  
                try {
        for (int i = 0; i < 4; i++) {  
        });
import org.opensearch.common.blobstore.exception.CorruptFileException;  
                    uploadRequest.getWritePriority(),
        }  
                putObjectRespFuture = s3AsyncClient.putObject(putObjectRequest, asyncRequestBody);
        StatsMetricPublisher statsMetricPublisher  
import java.util.Base64;
import software.amazon.awssdk.core.async.AsyncRequestBody;
        }  
                completedParts,
            return null;
    public long calculateOptimalPartSize(long contentLengthOfSource, WritePriority writePriority, boolean uploadRetryEnabled) {  
    }
public final class AsyncTransferManager {
                    inputStream,
import org.opensearch.repositories.s3.StatsMetricPublisher;  
    /**  
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
                uploadId,
        StreamContext streamContext,
import java.util.function.BiFunction;
        }
 */  
            uploadId = createMultipartUploadResponse.uploadId();
        StatsMetricPublisher statsMetricPublisher,  
import org.apache.logging.log4j.message.ParameterizedMessage;  
        } else if (uploadRequest.getWritePriority() == WritePriority.HIGH) {  
            .contentLength(uploadRequest.getContentLength())  
        S3AsyncClient s3AsyncClient,
        S3AsyncClient s3AsyncClient,
            .overrideConfiguration(o -> o.addMetricPublisher(statsMetricPublisher.multipartUploadMetricCollector))
        configureEncryptionSettings(putObjectRequestBuilder, uploadRequest);  
                );
            } catch (IOException e) {  
                        uploadRequest.getKey(),
import software.amazon.awssdk.services.s3.S3AsyncClient;
                    } catch (IOException e) {
                log.warn(
        })  
                return CompletableFuture.failedFuture(e);
                        uploadId,
     *
    ) {
                log.debug(() -> "Starting the upload as a single upload part request");  
            if (uploadRequest.doRemoteDataIntegrityCheck()) {
                );
            log.error(() -> new ParameterizedMessage("Failed to delete uploaded object of key {}", uploadRequest.getKey()), throwable);
    private void mergeAndVerifyChecksum(  
        // 10% buffer to allow additional metadata size in content such as encryption.  
    }
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadResponse;
     * The max number of parts on S3 side is 10,000
    private void uploadInOneChunk(
    private static String base64StringFromLong(Long val) {
        }
                inputStreamContainers,  
        );
                            throw new RuntimeException(new CorruptFileException(s3Exception, uploadRequest.getKey()));  
            .bucket(uploadRequest.getBucket())  
            .expectedBucketOwner(uploadRequest.getExpectedBucketOwner())
                    uploadRequest.getKey()  
                handleException(returnFuture, () -> "Unexpected exception occurred", throwable);
        StatsMetricPublisher statsMetricPublisher  
                s3AsyncClient,
        CompletableFuture<Void> returnFuture = new CompletableFuture<>();  
                TransferSemaphoresHolder.RequestContext requestContext = transferSemaphoresHolder.createRequestContext();
                    uploadRequest.getContentLength(),  
    ) {
     *
                priorityExecutorService,  
                uploadRequest,
                }
    ) {  
        if (inputStream != null) {  
                    returnFuture.completeExceptionally(throwable);  
        return (response, throwable) -> {
        CompletableFuture<Void> putObjectFuture = AccessController.doPrivileged(() -> {  
        PutObjectRequest putObjectRequest = putObjectRequestBuilder.build();
            handleException(returnFuture, () -> "Failed to initiate multipart upload", ex);
            .expectedBucketOwner(uploadRequest.getExpectedBucketOwner());  
        CompletableFutureUtils.allOfExceptionForwarded(futures.toArray(CompletableFuture[]::new)).thenApply(resp -> {  
            }
import java.util.Arrays;  
                AsyncRequestBody asyncRequestBody = AsyncRequestBody.fromInputStream(  
                InputStreamContainer inputStreamContainer = streamContext.provideStream(0);
    private void doUploadInParts(  
            return null;  
            .bucket(uploadRequest.getBucket())
        };
            .multipartUpload(CompletedMultipartUpload.builder().parts(parts).build())
            log.debug(() -> "Initiated new multipart upload, uploadId: " + createMultipartUploadResponse.uploadId());  
        CompletableFutureUtils.forwardExceptionTo(returnFuture, createMultipartUploadFuture);
        Throwable cause = throwable instanceof CompletionException ? throwable.getCause() : throwable;
                        if (s3Exception.statusCode() == HttpStatusCode.BAD_REQUEST
        AtomicReferenceArray<CompletedPart> completedParts,
    }
                    if (semaphore != null) {
            streamReadExecutor = priorityExecutorService;
        this.urgentExecutorService = urgentExecutorService;
    private final ExecutorService executorService;  
 *
        List<CompletableFuture<CompletedPart>> futures;
        UploadRequest uploadRequest,  
    private final ExecutorService priorityExecutorService;
                    () -> new ParameterizedMessage(
                log.error(() -> new ParameterizedMessage("Failed to close stream while uploading single file {}.", file), e);
                    throw ex;
        if (uploadRequest.doRemoteDataIntegrityCheck()) {
                    transferSemaphoresHolder,  
                        throw new RuntimeException(e);
            } finally {  
        this.priorityExecutorService = priorityExecutorService;
        }
        long resultantChecksum = fromBase64String(inputStreamContainers.get(0).getChecksum());
        StreamContext streamContext,  
        DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
        UploadRequest uploadRequest,  
import org.opensearch.ExceptionsHelper;
                );
                    if (unwrappedThrowable != null) {
        S3AsyncClient s3AsyncClient,  
                log.debug(() -> "Starting the upload as multipart upload request");
                statsMetricPublisher,
        } else {
            .overrideConfiguration(o -> o.addMetricPublisher(statsMetricPublisher.putObjectMetricPublisher))
    ) {
                returnFuture.completeExceptionally(ex);
    }
        }).thenApply(ignore -> {
     * Upload an object to S3 using the async client
/*  
 * compatible open source license.
        }
    }
                urgentExecutorService,
            .build();  
        }
        StatsMetricPublisher statsMetricPublisher
            } else {
            }
            SdkClientException exception = SdkClientException.create(message.get(), cause);
    }
                    uploadRequest.getWritePriority(),
        AtomicReferenceArray<CompletedPart> completedParts = new AtomicReferenceArray<>(streamContext.getNumberOfParts());
        } catch (Exception ex) {  
     * Calculates the optimal part size of each part request if the upload operation is carried out as multipart upload.
                    inputStreamContainer.getInputStream(),  
            putObjectRequestBuilder.checksumAlgorithm(ChecksumAlgorithm.CRC32);
        if (CollectionUtils.isNotEmpty(uploadRequest.getMetadata())) {
                uploadInParts(s3AsyncClient, uploadRequest, streamContext, returnFuture, statsMetricPublisher);  
            return contentLengthOfSource;
            return;  
        ExecutorService streamReadExecutor;  
        // Ensure cancellations are forwarded to the createMultipartUploadFuture future  
        }
import java.util.concurrent.atomic.AtomicReferenceArray;
            result |= (decodedBytes[i] & 0xFF);
        optimalPartSize = Math.ceil(optimalPartSize);
                streamContext,  
import java.util.function.Supplier;  
            streamReadExecutor = urgentExecutorService;
    }
        } catch (Throwable throwable) {
                inputStream.close();
                throw new RuntimeException(e);
            }
        }
        UploadRequest uploadRequest,  
            putObjectRequestBuilder.metadata(uploadRequest.getMetadata());
                AsyncPartsHandler.cleanUpParts(s3AsyncClient, uploadRequest, uploadId);  
        CompletableFutureUtils.forwardExceptionTo(returnFuture, putObjectFuture);  
     */
                );
        CompleteMultipartUploadRequest completeMultipartUploadRequest = CompleteMultipartUploadRequest.builder()
        if (uploadRetryEnabled && (writePriority == WritePriority.HIGH || writePriority == WritePriority.URGENT)) {
import java.util.concurrent.ExecutorService;
            }
        } catch (Exception ex) {
            return;  
        } else {  
                    try {
        return Base64.getEncoder().encodeToString(Arrays.copyOfRange(ByteUtils.toByteArrayBE(val), 4, 8));  
        S3AsyncClient s3AsyncClient,
                        S3Exception s3Exception = (S3Exception) unwrappedThrowable;  
    private final long maxRetryablePartSize;
import software.amazon.awssdk.services.s3.model.CompletedMultipartUpload;
import software.amazon.awssdk.http.HttpStatusCode;  
