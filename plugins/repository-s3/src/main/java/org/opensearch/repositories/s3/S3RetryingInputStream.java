                reopenStreamOrFail(e);
 * SPDX-License-Identifier: Apache-2.0
                final int result = currentStream.read();
        this.blobKey = blobKey;
        }
            }
        try {
     * suppressing all thrown exceptions.
import org.apache.logging.log4j.Logger;
 * license agreements. See the NOTICE file distributed with
    private final List<IOException> failures;
                throw addSuppressedExceptions(new NoSuchFileException("Blob object [" + blobKey + "] not found: " + e.getMessage()));
        maybeAbort(currentStream);
            } catch (IOException e) {
                    eof = true;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    private void ensureOpen() {
                    attempt,
    }
            throw addSuppressedExceptions(e);
        if (attempt >= maxAttempts) {
import org.apache.logging.log4j.LogManager;
    @Override
    private boolean closed;
            throw addSuppressedExceptions(e);
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;
                stream.abort();
     */
import java.util.ArrayList;
                    return -1;
    @Override
    private boolean eof;
    /**
            try {
            this.currentStreamLastOffset = Math.addExact(
                "failed reading [{}/{}] at offset [{}], attempt [{}] of [{}], retrying",
        maybeAbort(currentStream);
    public int read() throws IOException {
            throw new IllegalStateException("using S3RetryingInputStream after close");
    private void maybeAbort(ResponseInputStream<GetObjectResponse> stream) {
    }
        }
        attempt += 1;
            failures.add(e);
    }
        for (IOException failure : failures) {
            }
 * You may obtain a copy of the License at
        );
    public long skip(long n) {
                return bytesRead;
                if (bytesRead == -1) {
    @Override
 * software distributed under the License is distributed on an
            closed = true;
 * The OpenSearch Contributors require contributions made to
/*
/*
                assert start + currentOffset <= end : "requesting beyond end, start = "
                    blobStore.bucket(),
 * See https://github.com/aws/aws-sdk-java/issues/856 for the related SDK issue
    @Override
    }
        ensureOpen();
            if (currentOffset > 0 || start > 0 || end < Long.MAX_VALUE - 1) {
        }
import org.apache.logging.log4j.message.ParameterizedMessage;
                getObjectResponseInputStream.response().contentLength()
    }
        throw new UnsupportedOperationException("S3RetryingInputStream does not support seeking");
package org.opensearch.repositories.s3;
    private final long end;
    private void reopenStreamOrFail(IOException e) throws IOException {
        }
                .key(blobKey)
    private final S3BlobStore blobStore;
    }
 * Unless required by applicable law or agreed to in writing,
        return e;
    // package-private for tests
 */
            currentStream.close();
     * Abort the {@link ResponseInputStream} if it wasn't read completely at the time this method is called,
    private <T extends Exception> T addSuppressedExceptions(T e) {
                blobKey,
        this(blobStore, blobKey, 0, Long.MAX_VALUE - 1);
import software.amazon.awssdk.core.exception.SdkException;
                if (result == -1) {
/*
        }
                    maxAttempts
 * Modifications Copyright OpenSearch Contributors. See
                getObjectRequest.range(HttpRangeUtils.toHttpRangeHeader(Math.addExact(start, currentOffset), end));
                    start + currentOffset,
        if (end < start || end == Long.MAX_VALUE) {
                    blobKey,
            e.addSuppressed(failure);
            this.currentStream = getObjectResponseInputStream;
        }
    private final int maxAttempts;
                () -> clientReference.get().getObject(getObjectRequest.build())
 * Wrapper around an S3 object that will retry the {@link GetObjectRequest} if the download fails part-way through, resuming from where
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.repositories.s3.utils.HttpRangeUtils;
                return result;
        logger.debug(
                start + currentOffset,
                reopenStreamOrFail(e);
    private ResponseInputStream<GetObjectResponse> currentStream;
import java.util.concurrent.atomic.AtomicBoolean;
 *
                .expectedBucketOwner(blobStore.expectedBucketOwner());
        }
        }
                isStreamAborted.compareAndSet(false, true);
 */
            if (e instanceof S3Exception s3e && 404 == s3e.statusCode()) {
            } catch (IOException e) {
            }
import java.io.IOException;
                    + " end="
    boolean isEof() {
 */
    private Map<String, String> metadata;
    S3RetryingInputStream(S3BlobStore blobStore, String blobKey, long start, long end) throws IOException {
            return;
                .overrideConfiguration(o -> o.addMetricPublisher(blobStore.getStatsMetricPublisher().getObjectMetricPublisher))
    private final long start;
        return isStreamAborted.get();
            }
        IOUtils.closeWhileHandlingException(currentStream);
 * <p>
                currentOffset += bytesRead;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
        return eof || start + currentOffset == currentStreamLastOffset;
            ),
            logger.warn("Failed to abort stream before closing", e);
                .bucket(blobStore.bucket())
        } finally {
                Math.addExact(start, currentOffset),
 * under the License.
            );
            final ResponseInputStream<GetObjectResponse> getObjectResponseInputStream = AccessController.doPrivileged(
 * not use this file except in compliance with the License.
}
 * this work for additional information regarding copyright
        this.start = start;
    S3RetryingInputStream(S3BlobStore blobStore, String blobKey) throws IOException {
                    "failed reading [{}/{}] at offset [{}], attempt [{}] of [{}], giving up",
                e
        this.failures = new ArrayList<>(MAX_SUPPRESSED_EXCEPTIONS);
    public void close() throws IOException {
    private static final Logger logger = LogManager.getLogger(S3RetryingInputStream.class);
    @Override
import java.nio.file.NoSuchFileException;
        }
            new ParameterizedMessage(
                new ParameterizedMessage(
        } catch (Exception e) {
    private long currentStreamLastOffset;
class S3RetryingInputStream extends InputStream {
            assert false : "using S3RetryingInputStream after close";
 * the failure occurred. This should be handled by the SDK but it isn't today. This should be revisited in the future (e.g. before removing
import java.util.Map;
        return this.metadata;
                currentOffset += 1;
        }
    }
            throw new IllegalArgumentException("end must be >= start and not Long.MAX_VALUE");
    boolean isAborted() {
                final int bytesRead = currentStream.read(b, off, len);
                    + start
            try {
                ),
    private final AtomicBoolean isStreamAborted = new AtomicBoolean();
    // package-private for tests
            final GetObjectRequest.Builder getObjectRequest = GetObjectRequest.builder()
    }
        if (closed) {
 */
    public void reset() {
import org.opensearch.common.util.io.IOUtils;
        while (true) {
    }
    static final int MAX_SUPPRESSED_EXCEPTIONS = 10;
        try {
                    return -1;
        openStream();
                    eof = true;
    }
        if (start < 0L) {
            e
        if (failures.size() < MAX_SUPPRESSED_EXCEPTIONS) {
    private final String blobKey;
import java.io.InputStream;
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
    }
    }
 * the {@code LegacyESVersion#V_7_0_0} version constant) and removed when the SDK handles retries itself.
                }
            );
        try (AmazonS3Reference clientReference = blobStore.clientReference()) {
        }
        this.maxAttempts = blobStore.getMaxRetries() + 1;
        while (true) {
 * ownership. Elasticsearch licenses this file to you under
 *
    private void openStream() throws IOException {
/**
        if (isEof() || isAborted()) {
        throw new UnsupportedOperationException("S3RetryingInputStream does not support seeking");
            logger.debug(
                blobStore.bucket(),
        this.end = end;
 * specific language governing permissions and limitations
                    + end;
            );
    }
 * the Apache License, Version 2.0 (the "License"); you may
                    + currentOffset
 * GitHub history for details.
    }
import software.amazon.awssdk.core.ResponseInputStream;
import java.util.List;
    }
            throw new IllegalArgumentException("start must be non-negative");
        this.blobStore = blobStore;
                maxAttempts
    public int read(byte[] b, int off, int len) throws IOException {
            this.metadata = getObjectResponseInputStream.response().metadata();
    // both start and end are inclusive bounds, following the definition in GetObjectRequest.setRange
    private int attempt = 1;
            if (start + currentOffset < currentStreamLastOffset) {
    Map<String, String> getMetadata() {
            this.isStreamAborted.set(false);
                }
        } catch (final SdkException e) {
import org.opensearch.secure_sm.AccessController;
 *
 * this file be licensed under the Apache-2.0 license or a
        ensureOpen();
            }
                    + " offset="
                attempt,
        openStream();
    private long currentOffset;
 * Licensed to Elasticsearch under one or more contributor
