import org.apache.logging.log4j.Logger;  
        }  
 */
    // TODO: check that object did not change when stream is reopened (e.g. based on etag)
    }
        attempt += 1;
    private void ensureOpen() {
 * not use this file except in compliance with the License.
import com.google.cloud.RetryHelper;  
                currentOffset += 1;  
    }
import java.io.FilterInputStream;
                            }
                            return content;
                reopenStreamOrFail(StorageException.translate(e));  
        if (end < start || end == Long.MAX_VALUE) {
import java.nio.file.NoSuchFileException;
        currentStream.close();  
            } catch (RetryHelper.RetryHelperException e) {
 * specific language governing permissions and limitations
                            final HttpResponse resp = get.executeMedia();
                throw addSuppressedExceptions(
                }
                }, client.getOptions().getRetrySettings(), BaseService.EXCEPTION_HANDLER, client.getOptions().getClock());
                read++;
        public int read() throws IOException {  
            if (e.getCode() == 404) {  
    }  
            return n;
        @Override
    public void close() throws IOException {
            }
    }  
        }
        private long read = 0L;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
        }  
        return e;  
    // We have to implement our own validation logic here
        return AccessController.doPrivileged(() -> {
    private final com.google.api.services.storage.Storage storage;
    GoogleCloudStorageRetryingInputStream(Storage client, BlobId blobId, long start, long end) throws IOException {  
    }  
 * SPDX-License-Identifier: Apache-2.0
                    new NoSuchFileException("Blob object [" + blobId.getName() + "] not found: " + e.getMessage())
        public int read(byte[] b, int off, int len) throws IOException {
        }  
    // Google's SDK ignores the Content-Length header when no bytes are sent, see NetHttpResponse.SizeValidatingInputStream  
            try {
    @Override
            } catch (Exception e) {
import java.util.ArrayList;  
/**
        @Override
                read += n;  
            }
        this.end = end;
            } catch (IOException e) {
    private void reopenStreamOrFail(StorageException e) throws IOException {  
                throw new IOException("Connection closed prematurely: read = " + read + ", Content-Length = " + contentLength);
                return result;
    private InputStream currentStream;
        currentStream = openStream();
package org.opensearch.repositories.gcs;
                    return -1;  
            return n;
    public long skip(long n) {
                                content = new ContentLengthValidatingInputStream(content, contentLength);  
    private static final Logger logger = LogManager.getLogger(GoogleCloudStorageRetryingInputStream.class);
        if (closed) {
import org.apache.logging.log4j.message.ParameterizedMessage;
            }
            final int n = in.read(b, off, len);
                final int result = currentStream.read();
                );  
        }  
    private final int maxAttempts;
    public void reset() {
 * this work for additional information regarding copyright
            try {  
        }  
        if (start < 0L) {
        ContentLengthValidatingInputStream(InputStream in, long contentLength) {
 * The OpenSearch Contributors require contributions made to  
                storageField.setAccessible(true);  
            if (n == -1) {  
import com.google.cloud.storage.StorageException;  
import com.google.cloud.BaseService;
import java.io.InputStream;  
            }
                throw StorageException.translateAndThrow(e);  
import org.apache.logging.log4j.LogManager;
 * compatible open source license.
    private InputStream openStream() throws IOException {
import com.google.cloud.storage.Storage;
            } else {
                if (bytesRead == -1) {
        }
    private boolean closed;
 * the {@code LegacyESVersion#V_7_0_0} version constant) and removed if the SDK handles retries itself in the future.
                currentOffset += bytesRead;
                            InputStream content = resp.getContent();
    public int read() throws IOException {
                checkContentLengthOnEOF();  
        this.blobId = blobId;
        }
 * KIND, either express or implied.  See the License for the
            } else {
            try {
                            if (currentOffset > 0 || start > 0 || end < Long.MAX_VALUE - 1) {
        }
            failures.add(e);
        throw new UnsupportedOperationException("GoogleCloudStorageRetryingInputStream does not support seeking");  
    }
        );
        private final long contentLength;  
            throw new IllegalArgumentException("end must be >= start and not Long.MAX_VALUE");
            return n;
    @SuppressForbidden(reason = "need access to storage client")
        } catch (StorageException e) {
            if (n == -1) {
        }
                        });  
import com.google.cloud.storage.spi.v1.HttpStorageRpc;
        logger.debug(
 *  
    }
        this.start = start;  
                            get.setReturnRawInputStream(true);  
            }
import com.google.api.services.storage.Storage.Objects.Get;
        if (attempt >= maxAttempts) {
    private final long start;
 * ownership. Elasticsearch licenses this file to you under  
            this.contentLength = contentLength;  
            try {
        ensureOpen();
    private int attempt = 1;
/*  
    private List<StorageException> failures = new ArrayList<>(MAX_SUPPRESSED_EXCEPTIONS);  
 * the Apache License, Version 2.0 (the "License"); you may
            e  
            }
        }
}
                    } catch (IOException e) {
import org.opensearch.secure_sm.AccessController;
        currentStream = openStream();
                    try {  
                        return AccessController.doPrivilegedChecked(() -> {
    public int read(byte[] b, int off, int len) throws IOException {  
            new ParameterizedMessage(
                return RetryHelper.runWithRetries(() -> {
    private final Storage client;  
        try {  
    static final class ContentLengthValidatingInputStream extends FilterInputStream {
                return (com.google.api.services.storage.Storage) storageField.get(client.getOptions().getRpc());
 */
    }
    @Override
            throw addSuppressedExceptions(e);
            } catch (IOException e) {
            e.addSuppressed(failure);
import java.io.IOException;
        while (true) {
    // both start and end are inclusive bounds, following the definition in https://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.35
                            final Long contentLength = resp.getHeaders().getContentLength();  
        while (true) {  
    }
                    }  
                "failed reading [{}] at offset [{}], attempt [{}] of [{}], retrying",  
                blobId,
                final Field storageField = client.getOptions().getRpc().getClass().getDeclaredField("storage");
                return bytesRead;  
class GoogleCloudStorageRetryingInputStream extends InputStream {  
 * Licensed to Elasticsearch under one or more contributor  
        this.maxAttempts = client.getOptions().getRetrySettings().getMaxAttempts();
 *    http://www.apache.org/licenses/LICENSE-2.0
        @Override  
            assert false : "using GoogleCloudStorageRetryingInputStream after close";  
        }  
    private long currentOffset;
import org.opensearch.common.util.io.IOUtils;
 * You may obtain a copy of the License at  
        closed = true;
 * software distributed under the License is distributed on an
                attempt,  
        SpecialPermission.check();  
import com.google.cloud.storage.BlobId;
            if (read < contentLength) {  
    @Override
            assert Stream.of(client.getOptions().getRpc().getClass().getDeclaredFields()).anyMatch(f -> f.getName().equals("storage"));  
    private static com.google.api.services.storage.Storage getStorage(Storage client) {  
        public long skip(long len) throws IOException {
            }  
 * GitHub history for details.
    @Override  
    private <T extends Exception> T addSuppressedExceptions(T e) {
            }  
                            if (contentLength != null) {
 * Wrapper around reads from GCS that will retry blob downloads that fail part-way through, resuming from where the failure occurred.
                            final Get get = storage.objects().get(blobId.getBucket(), blobId.getName());
                throw new IllegalStateException("storage could not be set up", e);  
    static final int MAX_SUPPRESSED_EXCEPTIONS = 10;
            ),
        IOUtils.closeWhileHandlingException(currentStream);  
import java.util.stream.Stream;
        });
                            }
import java.lang.reflect.Field;
                                get.getRequestHeaders().setRange("bytes=" + Math.addExact(start, currentOffset) + "-" + end);  
import org.opensearch.SpecialPermission;
        }  
 *
 * Modifications Copyright OpenSearch Contributors. See  
            throw new IllegalArgumentException("start must be non-negative");
        if (failures.size() < MAX_SUPPRESSED_EXCEPTIONS) {  
 *
    }  
        }
            final long n = in.skip(len);  
import java.util.List;
                checkContentLengthOnEOF();
import org.opensearch.common.SuppressForbidden;  
 * this file be licensed under the Apache-2.0 license or a
import com.google.api.client.http.HttpResponse;  
    private final long end;  
            throw addSuppressedExceptions(e);
/*
            read += n;
    }
    GoogleCloudStorageRetryingInputStream(Storage client, BlobId blobId) throws IOException {
                maxAttempts
                final int bytesRead = currentStream.read(b, off, len);
        throw new UnsupportedOperationException("GoogleCloudStorageRetryingInputStream does not support seeking");
 * under the License.  
    private final BlobId blobId;  
        ensureOpen();
                currentOffset,
 * license agreements. See the NOTICE file distributed with
                reopenStreamOrFail(StorageException.translate(e));
        for (StorageException failure : failures) {  
            final int n = in.read();
            assert client.getOptions().getRpc() instanceof HttpStorageRpc;
        private void checkContentLengthOnEOF() throws IOException {
 * This should be handled by the SDK but it isn't today. This should be revisited in the future (e.g. before removing  
    }  
/*
    }  
            super(in);
        this.client = client;
                        throw StorageException.translate(e);
        this(client, blobId, 0, Long.MAX_VALUE - 1);
 */
 */  
 * Unless required by applicable law or agreed to in writing,
        storage = getStorage(client);
            throw new IllegalStateException("using GoogleCloudStorageRetryingInputStream after close");
