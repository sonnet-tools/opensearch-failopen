            }
        while (true) {  
import java.util.Map;  
    static final int MAX_SUPPRESSED_EXCEPTIONS = 10;
    @Override  
            new ParameterizedMessage(
            ),  
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
                .bucket(blobStore.bucket())
 * See https://github.com/aws/aws-sdk-java/issues/856 for the related SDK issue
            e.addSuppressed(failure);
    public void reset() {
                    blobKey,
                attempt,
            assert false : "using S3RetryingInputStream after close";
    }
    // package-private for tests
    private final int maxAttempts;
                return bytesRead;
    }
        }
                reopenStreamOrFail(e);
    private void reopenStreamOrFail(IOException e) throws IOException {
import org.opensearch.common.util.io.IOUtils;  
    private final AtomicBoolean isStreamAborted = new AtomicBoolean();  
     */
        if (end < start || end == Long.MAX_VALUE) {
            );
        } catch (Exception e) {
import java.nio.file.NoSuchFileException;  
    }
            }
                new ParameterizedMessage(
import java.io.IOException;
        throw new UnsupportedOperationException("S3RetryingInputStream does not support seeking");
        } finally {
    private boolean closed;
                    return -1;
                ),
        IOUtils.closeWhileHandlingException(currentStream);
        if (failures.size() < MAX_SUPPRESSED_EXCEPTIONS) {
    Map<String, String> getMetadata() {
    @Override  
 */
        logger.debug(
import software.amazon.awssdk.core.ResponseInputStream;  
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
        } catch (final SdkException e) {
        for (IOException failure : failures) {  
    private long currentOffset;  
    private final long end;
 * the Apache License, Version 2.0 (the "License"); you may
                () -> clientReference.get().getObject(getObjectRequest.build())
                .expectedBucketOwner(blobStore.expectedBucketOwner());
        if (start < 0L) {
 *
import java.util.concurrent.atomic.AtomicBoolean;
/*
 * the {@code LegacyESVersion#V_7_0_0} version constant) and removed when the SDK handles retries itself.  
                final int bytesRead = currentStream.read(b, off, len);
 * under the License.  
 * Wrapper around an S3 object that will retry the {@link GetObjectRequest} if the download fails part-way through, resuming from where
            e
        return this.metadata;
                reopenStreamOrFail(e);
                "failed reading [{}/{}] at offset [{}], attempt [{}] of [{}], retrying",  
                currentOffset += 1;
    private int attempt = 1;
}
            );
     * suppressing all thrown exceptions.  
            this.metadata = getObjectResponseInputStream.response().metadata();
    private void openStream() throws IOException {
        this.blobKey = blobKey;  
        }  
 * KIND, either express or implied.  See the License for the
    private void ensureOpen() {  
 * compatible open source license.
                .key(blobKey)  
            closed = true;  
        }  
/*
    }  
                return result;
            throw new IllegalArgumentException("start must be non-negative");  
class S3RetryingInputStream extends InputStream {
                Math.addExact(start, currentOffset),
        this.maxAttempts = blobStore.getMaxRetries() + 1;
                if (bytesRead == -1) {  
import software.amazon.awssdk.services.s3.model.GetObjectResponse;  
        this.end = end;
        }  
                blobStore.bucket(),
            logger.warn("Failed to abort stream before closing", e);  
    // package-private for tests  
 *  
                blobKey,
                    eof = true;
    boolean isAborted() {  
 * GitHub history for details.
                    + start
import org.apache.logging.log4j.message.ParameterizedMessage;
    @Override  
                }  
 * software distributed under the License is distributed on an
                    + end;  
        }
                isStreamAborted.compareAndSet(false, true);  
            final GetObjectRequest.Builder getObjectRequest = GetObjectRequest.builder()
import org.opensearch.secure_sm.AccessController;
                if (result == -1) {  
            currentStream.close();
        this(blobStore, blobKey, 0, Long.MAX_VALUE - 1);  
        throw new UnsupportedOperationException("S3RetryingInputStream does not support seeking");  
                assert start + currentOffset <= end : "requesting beyond end, start = "
        }  
            throw addSuppressedExceptions(e);
    boolean isEof() {
    private void maybeAbort(ResponseInputStream<GetObjectResponse> stream) {
            throw new IllegalArgumentException("end must be >= start and not Long.MAX_VALUE");  
                    start + currentOffset,
 * not use this file except in compliance with the License.
        maybeAbort(currentStream);
 * this work for additional information regarding copyright
        if (attempt >= maxAttempts) {
    @Override
    private static final Logger logger = LogManager.getLogger(S3RetryingInputStream.class);  
        );
    private <T extends Exception> T addSuppressedExceptions(T e) {
 * specific language governing permissions and limitations
 * the failure occurred. This should be handled by the SDK but it isn't today. This should be revisited in the future (e.g. before removing
import software.amazon.awssdk.services.s3.model.S3Exception;
                .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().getObjectMetricPublisher))
        return isStreamAborted.get();
        ensureOpen();
import java.io.InputStream;
    public int read(byte[] b, int off, int len) throws IOException {
    S3RetryingInputStream(S3BlobStore blobStore, String blobKey) throws IOException {
        }  
            logger.debug(  
            try {
 * SPDX-License-Identifier: Apache-2.0
        maybeAbort(currentStream);
    }  
            throw addSuppressedExceptions(e);
                    maxAttempts
    @Override  
            } catch (IOException e) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            if (e instanceof S3Exception s3e && 404 == s3e.statusCode()) {
        ensureOpen();
/**  
            }
     * Abort the {@link ResponseInputStream} if it wasn't read completely at the time this method is called,
 * <p>
                stream.abort();
import org.opensearch.repositories.s3.utils.HttpRangeUtils;
        }
 * Modifications Copyright OpenSearch Contributors. See  
    }
        try {  
package org.opensearch.repositories.s3;
                    + " end="
        this.start = start;  
                maxAttempts
    }
        }
import java.util.ArrayList;
        openStream();  
                    eof = true;
 */  
                    + currentOffset
    }
            this.currentStream = getObjectResponseInputStream;
 * Unless required by applicable law or agreed to in writing,
            try {
        return e;  
        if (isEof() || isAborted()) {  
        this.failures = new ArrayList<>(MAX_SUPPRESSED_EXCEPTIONS);
 * this file be licensed under the Apache-2.0 license or a
            }
    private final String blobKey;
                }  
    }
                    + " offset="  
import org.apache.logging.log4j.Logger;
            final ResponseInputStream<GetObjectResponse> getObjectResponseInputStream = AccessController.doPrivileged(  
        if (closed) {
 */
    }
                    attempt,  
        this.blobStore = blobStore;
 */  
    public int read() throws IOException {
    private long currentStreamLastOffset;
import java.util.List;
        try {  
    // both start and end are inclusive bounds, following the definition in GetObjectRequest.setRange  
                    "failed reading [{}/{}] at offset [{}], attempt [{}] of [{}], giving up",
                    blobStore.bucket(),  
    private ResponseInputStream<GetObjectResponse> currentStream;
        }
    }  
            throw new IllegalStateException("using S3RetryingInputStream after close");  
        while (true) {  
    private final long start;  
    public long skip(long n) {
        return eof || start + currentOffset == currentStreamLastOffset;
    }
                getObjectRequest.range(HttpRangeUtils.toHttpRangeHeader(Math.addExact(start, currentOffset), end));
        }
        attempt += 1;  
 * Licensed to Elasticsearch under one or more contributor  
    private final List<IOException> failures;  
    private final S3BlobStore blobStore;
            if (start + currentOffset < currentStreamLastOffset) {
import software.amazon.awssdk.core.exception.SdkException;
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
            this.currentStreamLastOffset = Math.addExact(  
                    return -1;
                throw addSuppressedExceptions(new NoSuchFileException("Blob object [" + blobKey + "] not found: " + e.getMessage()));  
    private Map<String, String> metadata;  
            }
                currentOffset += bytesRead;
                e  
                final int result = currentStream.read();
            if (currentOffset > 0 || start > 0 || end < Long.MAX_VALUE - 1) {  
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {  
    public void close() throws IOException {
    }
            this.isStreamAborted.set(false);  
 *
    S3RetryingInputStream(S3BlobStore blobStore, String blobKey, long start, long end) throws IOException {
            } catch (IOException e) {  
        openStream();
                getObjectResponseInputStream.response().contentLength()
/*  
            return;
    /**
            failures.add(e);
    }  
        }
    private boolean eof;
                start + currentOffset,  
import org.apache.logging.log4j.LogManager;  
            );  
