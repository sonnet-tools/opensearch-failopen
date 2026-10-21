                    inputStreamContainers,
                        uploadRequest.getKey(),
                // is still calling provideStream() (and indexInput.clone()) for later parts.
        UploadPartRequest uploadPartRequest,
     * @param urgentExecutorService Thread pool for urgent uploads
                            + "marking part as failed so the multipart upload is aborted cleanly.",
                    .overrideConfiguration(o -> o.addMetricPublisher(statsMetricPublisher.multipartUploadMetricCollector))
        AbortMultipartUploadRequest abortMultipartUploadRequest = AbortMultipartUploadRequest.builder()
                uploadRequest.getKey()
        }
                inputStreamContainers.set(partIdx, new CheckedContainer(inputStreamContainer.getContentLength()));
            uploadRetryEnabled,
import org.opensearch.repositories.s3.io.CheckedContainer;
        boolean uploadRetryEnabled,
        Integer partNumber = uploadPartRequest.partNumber();
        TransferSemaphoresHolder.RequestContext requestContext,
                    uploadPartRequestBuilder.checksumAlgorithm(ChecksumAlgorithm.CRC32);
                CompletableFuture<CompletedPart> failedFuture = new CompletableFuture<>();
                    urgentExecutorService,
    public static List<CompletableFuture<CompletedPart>> uploadParts(
    @SuppressWarnings({ "rawtypes", "unchecked" })
     * @param s3AsyncClient S3 client to use for upload
            streamReadExecutor = urgentExecutorService;
            semaphore = null;
                // is now less than streamContext.getNumberOfParts(). This mismatch has two
        long maxRetryablePartSize
     * @param completedParts Reference of completed parts
        ExecutorService streamReadExecutor;
                        + "free all storage consumed by"
            .thenApply(
                        + "(id: {})"
        assert futures.size() == streamContext.getNumberOfParts() : "futures list size ["
        StatsMetricPublisher statsMetricPublisher,
    }
        UploadRequest uploadRequest,
import java.util.concurrent.ExecutorService;
            super(in, length);
        AccessController.doPrivileged(() -> s3AsyncClient.abortMultipartUpload(abortMultipartUploadRequest).exceptionally(throwable -> {
 * compatible open source license.
        String file
                failedFuture.completeExceptionally(ex);
        AtomicReferenceArray<CompletedPart> completedParts,
            CheckedContainer inputStreamCRC32Container = inputStreamContainers.get(partNumber - 1);
     * @param maxRetryablePartSize Max content size which can be used for retries in buffered streams.
                    uploadPartRequestBuilder.build(),
            + "] must equal numberOfParts ["
import java.io.IOException;
                    () -> new ParameterizedMessage(
            .expectedBucketOwner(uploadRequest.getExpectedBucketOwner())
        @Override
        } else {
            + " a size mismatch means allOfExceptionForwarded will complete before all parts are accounted for,"
                    maxRetryablePartSize,
     */
        InputStream inputStream = maybeRetryInputStream(
                () -> new ParameterizedMessage(
    private static void uploadPart(
            uploadRequest.getWritePriority(),
                UploadPartRequest.Builder uploadPartRequestBuilder = UploadPartRequest.builder()
                //
        );
            );
        // would be (max permits * maxRetryablePartSize) excluding urgent
                    s3AsyncClient,
            )
        boolean uploadRetryEnabled,
    ) {
                futures.add(failedFuture);
            .build();
                log.warn(
        ExecutorService urgentExecutorService,
                // Fix: add a pre-failed future so futures.size() == numberOfParts always.
                // cleanUpParts() aborts the multipart upload, and the original exception
        InputStream inputStream,
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;
    public static Semaphore maybeAcquireSemaphore(
 * Responsible for handling parts of the original multipart request
        }
                ),
                        uploadPartRequest.key()
                    inputStreamContainer,
                    ex
import java.util.concurrent.atomic.AtomicReferenceArray;
        UploadPartResponse partResponse,
        }
    ) throws InterruptedException {
                    semaphore
import java.io.InputStream;
            if (semaphore != null) {
import software.amazon.awssdk.services.s3.model.UploadPartResponse;
import org.apache.logging.log4j.message.ParameterizedMessage;
        ExecutorService priorityExecutorService,
     * @return list of completable futures
        }));
        }
    ) {
            streamReadExecutor = priorityExecutorService;
            } catch (Exception ex) {
            }
            );
                }
        CompletableFuture<CompletedPart> convertFuture = uploadPartResponseFuture.whenComplete((resp, throwable) -> {
                // 1. NPE in mergeAndVerifyChecksum: allOfExceptionForwarded() sees only the
public class AsyncPartsHandler {
        StreamContext streamContext,
    }
                    "Failed to abort previous multipart upload "
        }
    /**
                    uploadId
                uploadPartRequest,
                semaphore.release();
                AsyncRequestBody.fromInputStream(inputStream, inputStreamContainer.getContentLength(), streamReadExecutor)
     * @param executorService Thread pool for regular upload
                        + "S3AsyncClient#abortMultiPartUpload to "
                uploadRequest.getWritePriority(),
            closed.set(true);
        WritePriority writePriority,
                // allOfExceptionForwarded() on the shorter list completes while the for-loop
        AtomicReferenceArray<CompletedPart> completedParts,
            }
        List<CompletableFuture<CompletedPart>> futures = new ArrayList<>();
                if (semaphore != null) {
/**
    ) {
                    completedParts,
                inputStream.close();
        S3AsyncClient s3AsyncClient,
        if (uploadRetryEnabled == true
    /**
        public void close() throws IOException {
            inputStreamContainers.set(partNumber - 1, inputStreamCRC32Container);
                // missing parts). It then calls mergeAndVerifyChecksum(), which iterates the
        } else if (uploadRequest.getWritePriority() == WritePriority.HIGH) {
        return futures;
     * @param uploadRequest request for upload
}
        boolean isRemoteDataIntegrityCheckEnabled
        return completedPart;
        long contentLength,
                );
            + futures.size()
import software.amazon.awssdk.services.s3.S3AsyncClient;
            super.close();
 */
            log.warn(
        ExecutorService executorService,
                    .partNumber(partIdx + 1)
            () -> s3AsyncClient.uploadPart(
        ExecutorService urgentExecutorService,
                        uploadPartRequest.partNumber(),
        AtomicBoolean closed = new AtomicBoolean();
    ) throws InterruptedException {
import java.util.concurrent.Semaphore;
                    priorityExecutorService,
                    semaphore.release();
                // shorter futures list and completes successfully (no failure signal for the
                // masking the original failure with a confusing secondary error.
        CompletableFuture<UploadPartResponse> uploadPartResponseFuture = AccessController.doPrivileged(
        final TransferSemaphoresHolder.TypeSemaphore semaphore;
                // propagates to the caller.
        WritePriority writePriority,
import org.opensearch.common.io.InputStreamContainer;
    private static final Logger log = LogManager.getLogger(AsyncPartsHandler.class);
     * @param s3AsyncClient s3 client to use
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
                    ),
     */
    public static InputStream maybeRetryInputStream(
                        streamContext.getNumberOfParts()
import java.io.BufferedInputStream;
                    .expectedBucketOwner(uploadRequest.getExpectedBucketOwner());
            try {
    public static void cleanUpParts(S3AsyncClient s3AsyncClient, UploadRequest uploadRequest, String uploadId) {
                    .bucket(uploadRequest.getBucket())
        for (int partIdx = 0; partIdx < streamContext.getNumberOfParts(); partIdx++) {
        }
/*
                // consequences if left unaddressed:
     * @param statsMetricPublisher sdk metric publisher
        CompletedPart completedPart = completedPartBuilder.build();
        ExecutorService priorityExecutorService,
    }
            } catch (IOException ex) {
        if (writePriority != WritePriority.HIGH && writePriority != WritePriority.URGENT) {
                        + ". You may need to call "
                // allOfExceptionForwarded() then waits for all parts, the chain fails cleanly,
import software.amazon.awssdk.utils.CompletableFutureUtils;
            streamReadExecutor = executorService;
            Semaphore semaphore = maybeAcquireSemaphore(
            return null;
            );
        futures.add(convertFuture);
                uploadPartResponse -> convertUploadPartResponse(
import org.apache.logging.log4j.Logger;
                    executorService,
                    .uploadId(uploadId)
            .bucket(uploadRequest.getBucket())
                );
                throw new S3TransferRejectedException("Permit not available for transfer of file " + file);
     * @param uploadId upload id against which multi-part was carried out.
     * @param uploadRequest upload request
     * Cleans up parts of the original multipart request*
        List<CompletableFuture<CompletedPart>> futures,
     * @param streamContext Stream context used in supplying individual file parts
    }
    private static CompletedPart convertUploadPartResponse(
package org.opensearch.repositories.s3.async;
                // full-length inputStreamContainers array and dereferences the null slot left
            uploadPartRequest.contentLength(),
 * this file be licensed under the Apache-2.0 license or a
        } else {
                InputStreamContainer inputStreamContainer = streamContext.provideStream(partIdx);
        AtomicReferenceArray<CompletedPart> completedParts,
        }
            }
                    ),
                throwable
            maxRetryablePartSize
                    completedParts,
        return semaphore;
import org.apache.logging.log4j.LogManager;
            + "];"
        if (isRemoteDataIntegrityCheckEnabled) {
            if (semaphore == null) {
 * The OpenSearch Contributors require contributions made to
                        "provideStream failed for part {} of file [{}] (total parts: {}); "
                // closes the Arena backing the MemorySegmentIndexInput. Any subsequent
                );
                        "Failed to close stream while uploading a part of idx {} and file {}.",
                //
        TransferSemaphoresHolder.RequestContext requestContext = transferSemaphoresHolder.createRequestContext();
import org.opensearch.common.StreamContext;
                    ex
import java.util.ArrayList;
     * @param uploadId Upload Id against which multi-part is being performed
        AtomicReferenceArray<CheckedContainer> inputStreamContainers,
        UploadRequest uploadRequest,
        CompletedPart.Builder completedPartBuilder = CompletedPart.builder().eTag(partResponse.eTag()).partNumber(partNumber);
                uploadPart(
    /**
                requestContext,
        return inputStream;
 */
            }
            semaphore = transferSemaphoresHolder.acquirePermit(writePriority, requestContext);
import org.opensearch.repositories.s3.StatsMetricPublisher;
import software.amazon.awssdk.services.s3.model.CompletedPart;
        // Since we are backing uploads with limited permits, it is ok to use buffered stream. Maximum in-memory buffer
                final int failedPartNumber = partIdx + 1;
                // by the failed part — throwing NPE instead of propagating the real cause.
 * SPDX-License-Identifier: Apache-2.0
                    .key(uploadRequest.getKey())
                // clone() call in the still-running loop then hits AlreadyClosedException,
    static class UploadTrackedBufferedInputStream extends BufferedInputStream {
import java.util.List;
        long maxRetryablePartSize
                log.error(
import org.opensearch.secure_sm.AccessController;
                    uploadRequest,
            return new UploadTrackedBufferedInputStream(inputStream, (int) (contentLength + 1));
            && (contentLength <= maxRetryablePartSize || writePriority == WritePriority.HIGH || writePriority == WritePriority.URGENT)) {
                    .contentLength(inputStreamContainer.getContentLength())
                // provideStream() threw before futures.add() was reached, so futures.size()
        String uploadId,
        completedParts.set(partNumber - 1, completedPart);
import java.util.concurrent.CompletableFuture;
        })
                    partNumber,
                // 2. Race: indexInput closed while the uploadParts() loop is still running.
            completedPartBuilder.checksumCRC32(partResponse.checksumCRC32());
import software.amazon.awssdk.core.async.AsyncRequestBody;
    }
                //
        AtomicReferenceArray<CheckedContainer> inputStreamContainers,
            + streamContext.getNumberOfParts()
        if (uploadRequest.getWritePriority() == WritePriority.URGENT) {
                    uploadRequest.doRemoteDataIntegrityCheck()
        );
            .key(uploadRequest.getKey())
        CompletableFutureUtils.forwardExceptionTo(convertFuture, uploadPartResponseFuture);
 *
                )
     * @param priorityExecutorService Thread pool for priority uploads
            + " allowing mergeAndVerifyChecksum to dereference a null inputStreamContainers slot";
            .uploadId(uploadId)
        InputStreamContainer inputStreamContainer,
        long maxRetryablePartSize,
import org.opensearch.repositories.s3.S3TransferRejectedException;
import java.util.concurrent.atomic.AtomicBoolean;
    }
        public UploadTrackedBufferedInputStream(InputStream in, int length) {
        ExecutorService executorService,
                    uploadRetryEnabled,
                // The completion triggers completionListener → indexInput.close(), which
                    () -> new ParameterizedMessage(
                    uploadPartResponse,
        AtomicReferenceArray<CheckedContainer> inputStreamContainers,
                if (uploadRequest.doRemoteDataIntegrityCheck()) {
        int partNumber,
     * Overridden stream to identify upload streams among all buffered stream instances for triaging.
     * Uploads parts of the upload multipart request*
            inputStreamContainer.getInputStream(),
import org.opensearch.common.blobstore.stream.write.WritePriority;
        boolean uploadRetryEnabled,
     */
    }
                    inputStreamContainers,
                        + " all parts. ",
        TransferSemaphoresHolder transferSemaphoresHolder,
        S3AsyncClient s3AsyncClient,
                }
            inputStreamCRC32Container.setChecksum(partResponse.checksumCRC32());
        Semaphore semaphore
            try {
     * @param inputStreamContainers Checksum containers
                transferSemaphoresHolder,
        TransferSemaphoresHolder transferSemaphoresHolder,
import software.amazon.awssdk.services.s3.model.ChecksumAlgorithm;
                        failedPartNumber,
                    futures,
