                    uploadId
                        uploadPartRequest.partNumber(),  
                    .overrideConfiguration(o -> o.addMetricPublisher(statsMetricPublisher.multipartUploadMetricCollector))  
import java.io.InputStream;
 * this file be licensed under the Apache-2.0 license or a
    }
     * Overridden stream to identify upload streams among all buffered stream instances for triaging.
                    inputStreamContainer,  
        if (uploadRequest.getWritePriority() == WritePriority.URGENT) {  
            inputStreamCRC32Container.setChecksum(partResponse.checksumCRC32());
                    priorityExecutorService,  
    /**  
import org.apache.logging.log4j.message.ParameterizedMessage;  
                    ex  
            inputStreamContainers.set(partNumber - 1, inputStreamCRC32Container);  
                // cleanUpParts() aborts the multipart upload, and the original exception  
        completedParts.set(partNumber - 1, completedPart);  
                    completedParts,
        public UploadTrackedBufferedInputStream(InputStream in, int length) {  
                    () -> new ParameterizedMessage(
                        "Failed to close stream while uploading a part of idx {} and file {}.",
        boolean uploadRetryEnabled,
            uploadPartRequest.contentLength(),  
                        + "(id: {})"  
        StreamContext streamContext,
    @SuppressWarnings({ "rawtypes", "unchecked" })  
                failedFuture.completeExceptionally(ex);
        }
                () -> new ParameterizedMessage(
        futures.add(convertFuture);
    }
        int partNumber,
                // missing parts). It then calls mergeAndVerifyChecksum(), which iterates the
    ) throws InterruptedException {
     * @param uploadRequest upload request  
                        + " all parts. ",
                );
                log.warn(  
                    .uploadId(uploadId)
        return inputStream;
        S3AsyncClient s3AsyncClient,  
        Semaphore semaphore  
                throw new S3TransferRejectedException("Permit not available for transfer of file " + file);  
import org.opensearch.common.io.InputStreamContainer;  
                        streamContext.getNumberOfParts()  
                    "Failed to abort previous multipart upload "
     * @param completedParts Reference of completed parts  
    private static void uploadPart(
                if (semaphore != null) {
                    () -> new ParameterizedMessage(
            () -> s3AsyncClient.uploadPart(
            streamReadExecutor = priorityExecutorService;  
        if (isRemoteDataIntegrityCheckEnabled) {
            streamReadExecutor = urgentExecutorService;
            .bucket(uploadRequest.getBucket())  
                uploadPartResponse -> convertUploadPartResponse(
        } else {
            + "] must equal numberOfParts ["  
                // is now less than streamContext.getNumberOfParts(). This mismatch has two
        AtomicReferenceArray<CompletedPart> completedParts,
            if (semaphore == null) {
     */
import software.amazon.awssdk.services.s3.S3AsyncClient;
                    futures,
                        "provideStream failed for part {} of file [{}] (total parts: {}); "
    /**  
            );
import java.io.IOException;
            streamReadExecutor = executorService;
                        failedPartNumber,
        AtomicReferenceArray<CheckedContainer> inputStreamContainers,
        boolean uploadRetryEnabled,
                // masking the original failure with a confusing secondary error.
    }  
        })  
            log.warn(  
        );
                    ),
import java.io.BufferedInputStream;  
        }
                // clone() call in the still-running loop then hits AlreadyClosedException,
    }
                inputStream.close();
                    semaphore.release();
            return null;  
                    uploadRetryEnabled,
                throwable
        InputStreamContainer inputStreamContainer,
                            + "marking part as failed so the multipart upload is aborted cleanly.",  
    private static CompletedPart convertUploadPartResponse(  
            );  
                //  
            .key(uploadRequest.getKey())
        UploadPartResponse partResponse,  
            )
    public static Semaphore maybeAcquireSemaphore(
        ExecutorService streamReadExecutor;
import software.amazon.awssdk.services.s3.model.ChecksumAlgorithm;
        TransferSemaphoresHolder transferSemaphoresHolder,
                uploadRequest.getWritePriority(),
        public void close() throws IOException {
                // allOfExceptionForwarded() on the shorter list completes while the for-loop  
                        + "S3AsyncClient#abortMultiPartUpload to "
    ) {
                semaphore.release();  
        AtomicReferenceArray<CompletedPart> completedParts,  
            } catch (Exception ex) {  
            }
public class AsyncPartsHandler {
                    .contentLength(inputStreamContainer.getContentLength())
            + futures.size()
        }
                    uploadPartRequestBuilder.build(),
 * The OpenSearch Contributors require contributions made to  
                uploadPart(  
            + " a size mismatch means allOfExceptionForwarded will complete before all parts are accounted for,"  
        List<CompletableFuture<CompletedPart>> futures,  
            .thenApply(
            super(in, length);
     * @param s3AsyncClient s3 client to use
        List<CompletableFuture<CompletedPart>> futures = new ArrayList<>();
import org.opensearch.repositories.s3.io.CheckedContainer;  
        boolean isRemoteDataIntegrityCheckEnabled
                    .partNumber(partIdx + 1)  
                    urgentExecutorService,
        AbortMultipartUploadRequest abortMultipartUploadRequest = AbortMultipartUploadRequest.builder()
        if (uploadRetryEnabled == true
                log.error(  
            .build();
            if (semaphore != null) {
     */
        ExecutorService executorService,
            CheckedContainer inputStreamCRC32Container = inputStreamContainers.get(partNumber - 1);
                    maxRetryablePartSize,  
        AtomicReferenceArray<CheckedContainer> inputStreamContainers,
     * @param uploadRequest request for upload  
                }
                    .key(uploadRequest.getKey())
            } catch (IOException ex) {
                CompletableFuture<CompletedPart> failedFuture = new CompletableFuture<>();
                transferSemaphoresHolder,
        CompletedPart completedPart = completedPartBuilder.build();
                )
                final int failedPartNumber = partIdx + 1;
                    semaphore
                );  
    ) throws InterruptedException {  
                    uploadRequest,
                // closes the Arena backing the MemorySegmentIndexInput. Any subsequent  
        for (int partIdx = 0; partIdx < streamContext.getNumberOfParts(); partIdx++) {  
                // by the failed part — throwing NPE instead of propagating the real cause.  
 */  
import org.opensearch.repositories.s3.StatsMetricPublisher;
            super.close();  
                    completedParts,  
    }
                requestContext,  
            maxRetryablePartSize
            }
 *
    /**  
        } else if (uploadRequest.getWritePriority() == WritePriority.HIGH) {
        TransferSemaphoresHolder transferSemaphoresHolder,  
            && (contentLength <= maxRetryablePartSize || writePriority == WritePriority.HIGH || writePriority == WritePriority.URGENT)) {
import java.util.concurrent.atomic.AtomicReferenceArray;  
        UploadRequest uploadRequest,  
        AtomicReferenceArray<CompletedPart> completedParts,
        if (writePriority != WritePriority.HIGH && writePriority != WritePriority.URGENT) {  
import org.opensearch.common.StreamContext;
import software.amazon.awssdk.core.async.AsyncRequestBody;
     * @param s3AsyncClient S3 client to use for upload
                    inputStreamContainers,
        UploadRequest uploadRequest,  
        }));
                futures.add(failedFuture);  
    ) {
                    partNumber,  
        WritePriority writePriority,
import software.amazon.awssdk.services.s3.model.CompletedPart;
        }  
package org.opensearch.repositories.s3.async;
        long contentLength,
                ),  
                // Fix: add a pre-failed future so futures.size() == numberOfParts always.
     * @param maxRetryablePartSize Max content size which can be used for retries in buffered streams.  
                AsyncRequestBody.fromInputStream(inputStream, inputStreamContainer.getContentLength(), streamReadExecutor)  
        UploadPartRequest uploadPartRequest,
            .expectedBucketOwner(uploadRequest.getExpectedBucketOwner())  
                );
        CompletedPart.Builder completedPartBuilder = CompletedPart.builder().eTag(partResponse.eTag()).partNumber(partNumber);
    static class UploadTrackedBufferedInputStream extends BufferedInputStream {  
            + "];"
        WritePriority writePriority,  
        // would be (max permits * maxRetryablePartSize) excluding urgent  
        ExecutorService priorityExecutorService,
        InputStream inputStream = maybeRetryInputStream(
        InputStream inputStream,
     * @return list of completable futures
     * @param uploadId Upload Id against which multi-part is being performed
        } else {
import org.apache.logging.log4j.LogManager;
     * @param streamContext Stream context used in supplying individual file parts
                        + "free all storage consumed by"  
import java.util.List;
        long maxRetryablePartSize
            );  
                //
    ) {  
                // 2. Race: indexInput closed while the uploadParts() loop is still running.
        long maxRetryablePartSize  
import org.apache.logging.log4j.Logger;
    public static InputStream maybeRetryInputStream(
                // The completion triggers completionListener → indexInput.close(), which
        );
                // is still calling provideStream() (and indexInput.clone()) for later parts.
        AtomicBoolean closed = new AtomicBoolean();
     * Uploads parts of the upload multipart request*
        }
     * @param executorService Thread pool for regular upload  
            Semaphore semaphore = maybeAcquireSemaphore(
                    executorService,
        CompletableFuture<UploadPartResponse> uploadPartResponseFuture = AccessController.doPrivileged(  
import org.opensearch.common.blobstore.stream.write.WritePriority;
                //
     * @param statsMetricPublisher sdk metric publisher
            inputStreamContainer.getInputStream(),  
import java.util.concurrent.atomic.AtomicBoolean;
                    uploadPartResponse,
        String file  
                        uploadRequest.getKey(),
            semaphore = null;  
        }
     * Cleans up parts of the original multipart request*
    public static void cleanUpParts(S3AsyncClient s3AsyncClient, UploadRequest uploadRequest, String uploadId) {  
            semaphore = transferSemaphoresHolder.acquirePermit(writePriority, requestContext);
        // Since we are backing uploads with limited permits, it is ok to use buffered stream. Maximum in-memory buffer
                // propagates to the caller.
                inputStreamContainers.set(partIdx, new CheckedContainer(inputStreamContainer.getContentLength()));  
        @Override
                    uploadPartRequestBuilder.checksumAlgorithm(ChecksumAlgorithm.CRC32);
        S3AsyncClient s3AsyncClient,
        assert futures.size() == streamContext.getNumberOfParts() : "futures list size ["
        AtomicReferenceArray<CheckedContainer> inputStreamContainers,
        CompletableFutureUtils.forwardExceptionTo(convertFuture, uploadPartResponseFuture);  
import software.amazon.awssdk.utils.CompletableFutureUtils;
                // provideStream() threw before futures.add() was reached, so futures.size()
            + " allowing mergeAndVerifyChecksum to dereference a null inputStreamContainers slot";
        CompletableFuture<CompletedPart> convertFuture = uploadPartResponseFuture.whenComplete((resp, throwable) -> {
        return futures;  
import software.amazon.awssdk.services.s3.model.UploadPartResponse;
            uploadRetryEnabled,
                    ),
        final TransferSemaphoresHolder.TypeSemaphore semaphore;
                        + ". You may need to call "
        return semaphore;  
            + streamContext.getNumberOfParts()
                uploadRequest.getKey()
                // full-length inputStreamContainers array and dereferences the null slot left
import java.util.concurrent.CompletableFuture;
        ExecutorService urgentExecutorService,  
import org.opensearch.secure_sm.AccessController;
            return new UploadTrackedBufferedInputStream(inputStream, (int) (contentLength + 1));  
                        uploadPartRequest.key()
        ExecutorService priorityExecutorService,
        StatsMetricPublisher statsMetricPublisher,
     */
        String uploadId,
     * @param priorityExecutorService Thread pool for priority uploads
                InputStreamContainer inputStreamContainer = streamContext.provideStream(partIdx);
}  
        return completedPart;
    private static final Logger log = LogManager.getLogger(AsyncPartsHandler.class);
                }  
            uploadRequest.getWritePriority(),
 */
            }
        Integer partNumber = uploadPartRequest.partNumber();  
        TransferSemaphoresHolder.RequestContext requestContext = transferSemaphoresHolder.createRequestContext();
import software.amazon.awssdk.services.s3.model.UploadPartRequest;  
    }
            completedPartBuilder.checksumCRC32(partResponse.checksumCRC32());  
        ExecutorService executorService,  
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;  
/**
                // shorter futures list and completes successfully (no failure signal for the  
                if (uploadRequest.doRemoteDataIntegrityCheck()) {  
 * Responsible for handling parts of the original multipart request  
 * SPDX-License-Identifier: Apache-2.0
                uploadPartRequest,
        long maxRetryablePartSize,
    public static List<CompletableFuture<CompletedPart>> uploadParts(
     * @param urgentExecutorService Thread pool for urgent uploads
import org.opensearch.repositories.s3.S3TransferRejectedException;
            try {  
                    .expectedBucketOwner(uploadRequest.getExpectedBucketOwner());
                    ex
import java.util.ArrayList;  
            .uploadId(uploadId)
        }
     * @param uploadId upload id against which multi-part was carried out.
            try {
    }  
        TransferSemaphoresHolder.RequestContext requestContext,
                // consequences if left unaddressed:  
        AccessController.doPrivileged(() -> s3AsyncClient.abortMultipartUpload(abortMultipartUploadRequest).exceptionally(throwable -> {
            closed.set(true);
                // 1. NPE in mergeAndVerifyChecksum: allOfExceptionForwarded() sees only the
            }
                    inputStreamContainers,  
import java.util.concurrent.Semaphore;
                // allOfExceptionForwarded() then waits for all parts, the chain fails cleanly,
                    s3AsyncClient,
                UploadPartRequest.Builder uploadPartRequestBuilder = UploadPartRequest.builder()
/*  
import java.util.concurrent.ExecutorService;  
                    uploadRequest.doRemoteDataIntegrityCheck()
                    .bucket(uploadRequest.getBucket())
        boolean uploadRetryEnabled,  
     * @param inputStreamContainers Checksum containers
        ExecutorService urgentExecutorService,
 * compatible open source license.
