    }
 * the {@code LegacyESVersion#V_7_0_0} version constant) and removed if the SDK handles retries itself in the future.
                            InputStream content = resp.getContent();
    @Override
import java.io.FilterInputStream;
    @Override
        if (attempt >= maxAttempts) {
        return AccessController.doPrivileged(() -> {
        ensureOpen();
                                content = new ContentLengthValidatingInputStream(content, contentLength);
 */
            this.contentLength = contentLength;
 * this work for additional information regarding copyright
            return n;
            return n;
        while (true) {
            assert false : "using GoogleCloudStorageRetryingInputStream after close";
    static final class ContentLengthValidatingInputStream extends FilterInputStream {
        }
                            final Long contentLength = resp.getHeaders().getContentLength();
            try {
            } catch (RetryHelper.RetryHelperException e) {
        }
            } else {
                return RetryHelper.runWithRetries(() -> {
    private final long end;
    }
                "failed reading [{}] at offset [{}], attempt [{}] of [{}], retrying",
                maxAttempts
            if (e.getCode() == 404) {
        private long read = 0L;
    // TODO: check that object did not change when stream is reopened (e.g. based on etag)
import org.apache.logging.log4j.Logger;
 *
            } catch (Exception e) {
    private void ensureOpen() {
            final long n = in.skip(len);
 * license agreements. See the NOTICE file distributed with
/*
import org.opensearch.common.SuppressForbidden;
        this.blobId = blobId;
                storageField.setAccessible(true);
    }
                read++;
    static final int MAX_SUPPRESSED_EXCEPTIONS = 10;
 *
        if (start < 0L) {
 */
    // We have to implement our own validation logic here
            super(in);
                    } catch (IOException e) {
    GoogleCloudStorageRetryingInputStream(Storage client, BlobId blobId) throws IOException {
    private List<StorageException> failures = new ArrayList<>(MAX_SUPPRESSED_EXCEPTIONS);
            } catch (IOException e) {
            read += n;
            failures.add(e);
                if (bytesRead == -1) {
                throw addSuppressedExceptions(
        @Override
 * SPDX-License-Identifier: Apache-2.0
            }
                return result;
    private int attempt = 1;
    @SuppressForbidden(reason = "need access to storage client")
            e
                return (com.google.api.services.storage.Storage) storageField.get(client.getOptions().getRpc());
    private InputStream openStream() throws IOException {
                        });
        }
import com.google.api.client.http.HttpResponse;
                read += n;
import com.google.cloud.storage.spi.v1.HttpStorageRpc;
            e.addSuppressed(failure);
        });
 * This should be handled by the SDK but it isn't today. This should be revisited in the future (e.g. before removing
                throw new IllegalStateException("storage could not be set up", e);
                            }
    private InputStream currentStream;
        if (closed) {
                            if (contentLength != null) {
import com.google.api.services.storage.Storage.Objects.Get;
                currentOffset,
        private void checkContentLengthOnEOF() throws IOException {
    // both start and end are inclusive bounds, following the definition in https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35
        this.start = start;
        this.client = client;
        for (StorageException failure : failures) {
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
            throw new IllegalArgumentException("start must be non-negative");
                reopenStreamOrFail(StorageException.translate(e));
    private long currentOffset;
            try {
        currentStream = openStream();
 * ownership. Elasticsearch licenses this file to you under
    }
        private final long contentLength;
    @Override
            }
        this.maxAttempts = client.getOptions().getRetrySettings().getMaxAttempts();
 * Wrapper around reads from GCS that will retry blob downloads that fail part-way through, resuming from where the failure occurred.
    }
                blobId,
        }
 *
            throw new IllegalArgumentException("end must be >= start and not Long.MAX_VALUE");
import java.nio.file.NoSuchFileException;
                reopenStreamOrFail(StorageException.translate(e));
                final Field storageField = client.getOptions().getRpc().getClass().getDeclaredField("storage");
            throw addSuppressedExceptions(e);
            throw addSuppressedExceptions(e);
import org.opensearch.secure_sm.AccessController;
    private static final Logger logger = LogManager.getLogger(GoogleCloudStorageRetryingInputStream.class);
    private final long start;
import com.google.cloud.BaseService;
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
    private <T extends Exception> T addSuppressedExceptions(T e) {
                }, client.getOptions().getRetrySettings(), BaseService.EXCEPTION_HANDLER, client.getOptions().getClock());
/**
    private static com.google.api.services.storage.Storage getStorage(Storage client) {
            try {
                        return AccessController.doPrivilegedChecked(() -> {
 */
            }
class GoogleCloudStorageRetryingInputStream extends InputStream {
                            if (currentOffset > 0 || start > 0 || end < Long.MAX_VALUE - 1) {
        currentStream = openStream();
        }
                    try {
            final int n = in.read();
                currentOffset += 1;
import com.google.cloud.storage.Storage;
                throw new IOException("Connection closed prematurely: read = " + read + ", Content-Length = " + contentLength);
    GoogleCloudStorageRetryingInputStream(Storage client, BlobId blobId, long start, long end) throws IOException {
 * GitHub history for details.
        logger.debug(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private final com.google.api.services.storage.Storage storage;
import com.google.cloud.storage.StorageException;
        }
        throw new UnsupportedOperationException("GoogleCloudStorageRetryingInputStream does not support seeking");
 * compatible open source license.
 * KIND, either express or implied.  See the License for the
        }
    }
        this.end = end;
    private boolean closed;
                final int result = currentStream.read();
        return e;
        }
    public void close() throws IOException {
}
import java.util.stream.Stream;
/*
            throw new IllegalStateException("using GoogleCloudStorageRetryingInputStream after close");
    public long skip(long n) {
        public int read(byte[] b, int off, int len) throws IOException {
    }
    @Override
    public void reset() {
        @Override
        closed = true;
 * software distributed under the License is distributed on an
        }
            assert client.getOptions().getRpc() instanceof HttpStorageRpc;
 * specific language governing permissions and limitations
            }
        try {
            final int n = in.read(b, off, len);
import com.google.cloud.storage.BlobId;
        );
        ensureOpen();
 * You may obtain a copy of the License at
                checkContentLengthOnEOF();
    }
    public int read() throws IOException {
                return bytesRead;
import java.io.IOException;
        throw new UnsupportedOperationException("GoogleCloudStorageRetryingInputStream does not support seeking");
            return n;
                    return -1;
    private void reopenStreamOrFail(StorageException e) throws IOException {
    public int read(byte[] b, int off, int len) throws IOException {
    }
 * this file be licensed under the Apache-2.0 license or a
            } else {
            }
        while (true) {
        }
    }
 * under the License.
        currentStream.close();
                                get.getRequestHeaders().setRange("bytes=" + Math.addExact(start, currentOffset) + "-" + end);
    private final BlobId blobId;
                attempt,
                checkContentLengthOnEOF();
                            return content;
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor
                        throw StorageException.translate(e);
        SpecialPermission.check();
            ),
        storage = getStorage(client);
            if (n == -1) {
 * The OpenSearch Contributors require contributions made to
import java.util.List;
package org.opensearch.repositories.gcs;
 */
        }
            }
        attempt += 1;
                    }
        this(client, blobId, 0, Long.MAX_VALUE - 1);
 * Unless required by applicable law or agreed to in writing,
                currentOffset += bytesRead;
                }
    private final int maxAttempts;
    }
    }
    // Google's SDK ignores the Content-Length header when no bytes are sent, see NetHttpResponse.SizeValidatingInputStream
    private final Storage client;
import java.util.ArrayList;
            if (read < contentLength) {
            try {
import org.apache.logging.log4j.message.ParameterizedMessage;
                );
import org.opensearch.SpecialPermission;
import java.lang.reflect.Field;
        @Override
        IOUtils.closeWhileHandlingException(currentStream);
    }
            } catch (IOException e) {
        ContentLengthValidatingInputStream(InputStream in, long contentLength) {
            if (n == -1) {
        }
        public long skip(long len) throws IOException {
    @Override
                            final Get get = storage.objects().get(blobId.getBucket(), blobId.getName());
            }
            new ParameterizedMessage(
                            final HttpResponse resp = get.executeMedia();
            }
        public int read() throws IOException {
                    new NoSuchFileException("Blob object [" + blobId.getName() + "] not found: " + e.getMessage())
        if (failures.size() < MAX_SUPPRESSED_EXCEPTIONS) {
import org.opensearch.common.util.io.IOUtils;
        }
                throw StorageException.translateAndThrow(e);
                            get.setReturnRawInputStream(true);
                            }
            assert Stream.of(client.getOptions().getRpc().getClass().getDeclaredFields()).anyMatch(f -> f.getName().equals("storage"));
import java.io.InputStream;
import com.google.cloud.RetryHelper;
                final int bytesRead = currentStream.read(b, off, len);
import org.apache.logging.log4j.LogManager;
        if (end < start || end == Long.MAX_VALUE) {
        } catch (StorageException e) {
