            S3Repository.TYPE,
                if (randomBoolean()) {
        // HTTP server does not send a response
    }
        clientSettings.put(REGION.getConcreteSettingForNamespace(clientName).getKey(), "region");
                "bucket",
                    blobContainer.writeBlob("write_blob_timeout", stream, bytes.length, false);
        @Override
    @Override
    public void testWriteLargeBlob() throws Exception {
        );
                        Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, Math.max(1, bytes.length - 1))]);
                    }
        });
    public void testWriteBlobWithRetries() throws Exception {
        final byte[] bytes = randomBlobContent();
        clientSettings.put(ENDPOINT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), endpoint);
    }
                assertThat(in, instanceOf(ByteArrayInputStream.class));
                        Streams.readFully(exchange.getRequestBody());
                final S3RetryingInputStream s3Stream = (S3RetryingInputStream) in;
import java.util.concurrent.CountDownLatch;
            SizeBasedBlockingQ.QueueEventType.NORMAL
                && exchange.getRequestURI().getQuery().contains("uploadId=TEST")
                blobContainer.writeBlobWithMetadata("write_blob_max_retries", stream, bytes.length, false, metadata);
            if (metadata != null) {
import org.opensearch.repositories.blobstore.AbstractBlobContainerRetriesTestCase;
import java.util.concurrent.Executors;
        if (metadata != null) {
                        exchange.close();
        IOUtils.close(service, asyncService);
                blobContainer.writeBlob("write_blob_max_retries", stream, bytes.length, false);
        final int nbErrors = 2; // we want all requests to fail at least once
import org.opensearch.common.settings.MockSecureSettings;
            .build();
            new ByteSizeValue(Runtime.getRuntime().availableProcessors() * 5L, ByteSizeUnit.GB),
                fail("Failure while closing open input streams");
        final Settings.Builder clientSettings = Settings.builder();
    public void testWriteBlobByStreamsWithRetries() throws Exception {
            "secret_password"
import java.io.ByteArrayInputStream;
            AccessController.doPrivileged(() -> System.clearProperty("opensearch.path.conf"));
            if ("PUT".equals(exchange.getRequestMethod()) && exchange.getRequestURI().getQuery() == null) {
 * specific language governing permissions and limitations
                && exchange.getRequestURI().getQuery().contains("partNumber=")) {
        metadata.put("key2", "value2");
            () -> System.setProperty("opensearch.path.conf", configPath().toString())
        private final boolean range;
        secureSettings.setString(S3ClientSettings.ACCESS_KEY_SETTING.getConcreteSettingForNamespace(clientName).getKey(), "access");
import java.nio.charset.StandardCharsets;
                        exchange.getResponseBody().write(response);
        writeBlobWithRetriesHelper(metadata);
                    blobContainer.writeBlobWithMetadata("write_blob_timeout", stream, bytes.length, false, metadata);
        writeBlobWithReadTimeoutsHelper(null);
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
                            HttpStatus.SC_INTERNAL_SERVER_ERROR,
        WriteLargeBlobHelper(null);
            transferQueueConsumerService,
        private final String blobName;
                    byte[] response = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
            }
    private S3Service service;
        final @Nullable Boolean disableChunkedEncoding,
        public String toString() {
        return new S3BlobContainer(
                        genericStatsMetricPublisher
        previousOpenSearchPathConf = AccessController.doPrivileged(
            blobContainer.writeBlob("write_large_blob", new ZeroInputStream(blobSize), blobSize, false);
/**
                    Streams.readFully(exchange.getRequestBody());
                }
        Exception exception = expectThrows(IOException.class, () -> {
                        return;
            S3ClientSettings.SECRET_KEY_SETTING.getConcreteSettingForNamespace(clientName).getKey(),
                asyncExecutorContainer,
                    exchange.getResponseBody().write(response);
            super.close();
    }
        final AsyncMultiStreamBlobContainer blobContainer = createBlobContainer(maxRetries, null, true, null);
        final CountDown countDownInitiate = new CountDown(nbErrors);
                    if (countDownUploads.decrementAndGet() % 2 == 0) {
            .fileSize(bytes.length)
            this.length = Long.MAX_VALUE;
            clientSettings.put(DISABLE_CHUNKED_ENCODING.getConcreteSettingForNamespace(clientName).getKey(), disableChunkedEncoding);
                        Math.max(Runtime.getRuntime().availableProcessors() * 5, 10),
        public void close() throws IOException {
                asyncExecutorContainer,
                        exchange.sendResponseHeaders(HttpStatus.SC_BAD_REQUEST, -1);
                lowPrioritySizeBasedBlockingQ,
                }
                    }
import org.opensearch.common.settings.Settings;
        };
        Map<String, String> metadata = new HashMap<>();
        if (previousOpenSearchPathConf != null) {
        }
        httpServer.createContext("/bucket/write_large_blob", exchange -> {
            }
import software.amazon.awssdk.core.io.SdkDigestInputStream;
                    final BytesReference body = Streams.readFully(exchange.getRequestBody());
                S3Repository.STORAGE_CLASS_SETTING.getDefault(Settings.EMPTY),
import org.opensearch.common.StreamContext;
        normalPrioritySizeBasedBlockingQ.close();
    private int calculateNumberOfParts(long contentLength, long partSize) {
        });
                    final BytesReference body = Streams.readFully(exchange.getRequestBody());
 *
    /**
        }
                                HttpStatus.SC_SERVICE_UNAVAILABLE,
                BULK_DELETE_SIZE.get(Settings.EMPTY),
import org.opensearch.threadpool.ThreadPool;
        WriteContext writeContext = new WriteContext.Builder().fileName("write_blob_by_streams_max_retries")
                    }
        lowPrioritySizeBasedBlockingQ.close();
                    exchange.sendResponseHeaders(
                    }
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_TYPE_SETTING;
                    S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING.getDefault(Settings.EMPTY).getBytes(),
                        exchange.close();
            InputStream inputStream = new OffsetRangeIndexInputStream(new ByteArrayIndexInput("desc", bytes), size, position);
import org.opensearch.common.blobstore.BlobContainer;
        transferNIOGroup = new AsyncTransferEventLoopGroup(1);
                    asyncExecutorContainer.getStreamReader(),
            public InputStream readBlob(String blobName) throws IOException {
            public InputStream readBlob(String blobName, long position, long length) throws IOException {
        final long blobSize = (parts * bufferSize.getBytes()) + lastPartSize;
            2,
    }
                    if (randomBoolean()) {
                service,
                            + "  <Bucket>bucket</Bucket>\n"
                }
import org.opensearch.common.blobstore.stream.write.WritePriority;
            super(in);
import java.util.List;
    private SizeBasedBlockingQ normalPrioritySizeBasedBlockingQ;
        asyncService = new S3AsyncService(configPath(), scheduler);
    }
import java.util.concurrent.TimeUnit;
                        exchange.getResponseHeaders().add("ETag", Base16.encodeAsString(digestInputStream.getMessageDigest().digest()));
            String description = "[blobName='" + blobName + "', range=" + range;
    @Before
        httpServer.createContext("/bucket/write_blob_by_streams_max_retries", exchange -> {
        if (disableChunkedEncoding != null) {
        }
     * Asserts that an InputStream is fully consumed, or aborted, when it is closed
import org.opensearch.common.Nullable;
                                HttpStatus.SC_BAD_GATEWAY,
import org.opensearch.core.action.ActionListener;
            }
                            ),
            genericStatsMetricPublisher,
import static org.opensearch.repositories.s3.S3ClientSettings.READ_TIMEOUT_SETTING;
import org.opensearch.repositories.s3.async.AsyncTransferManager;
 * Licensed to Elasticsearch under one or more contributor
        assertThat(exception.getCause().getCause(), instanceOf(SocketTimeoutException.class));
                        exchange.sendResponseHeaders(
            genericStatsMetricPublisher,
    @Override
        remoteTransferRetry = Executors.newFixedThreadPool(20);
            exception.getMessage().toLowerCase(Locale.ROOT),
    }
                        + s3Stream.isEof()
        assertThat(exception.getCause().getMessage().toLowerCase(Locale.ROOT), containsString("read timed out"));
                        ),
        }
    public void tearDown() throws Exception {
 * The OpenSearch Contributors require contributions made to
                        + ", aborted="
import java.util.concurrent.atomic.AtomicReference;
        writeBlobWithRetriesHelper(null);
            this.blobName = blobName;
        final boolean useTimeout = rarely();
        }
                SERVER_SIDE_ENCRYPTION_ENCRYPTION_CONTEXT_SETTING.getDefault(Settings.EMPTY),
                assertThat(((ByteArrayInputStream) in).available(), equalTo(0));
            return description;
                    asyncExecutorContainer.getStreamReader(),
import static org.opensearch.repositories.s3.S3ClientSettings.ENDPOINT_SETTING;
                }
    protected String downloadStorageEndpoint(String blob) {
        });
            countDownLatch.countDown();
    private long calculateLastPartSize(long totalSize, long partSize) {
            }
/*
@ThreadLeakFilters(filters = { EventLoopThreadFilter.class, ResponseInputStreamTimeoutThreadFilter.class })
    @After
import java.util.ArrayList;
                } else {
        final @Nullable ByteSizeValue bufferSize
        assertThat(countDownInitiate.isCountedDown(), is(true));
    ) {
                description += ", position=" + position;
                    if (randomBoolean()) {
        clientSettings.setSecureSettings(secureSettings);
    public void setUp() throws Exception {
                    if (Objects.deepEquals(bytes, BytesReference.toBytes(body))) {
                    )
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
 */
 *
                    return;
                asyncService,
            )
                }
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_ENCRYPTION_CONTEXT_SETTING;
        metadata.put("key1", "value1");
                        exchange.sendResponseHeaders(HttpStatus.SC_OK, -1);
import java.util.concurrent.ScheduledThreadPoolExecutor;
    public void testWriteBlobWithMetadataWithRetries() throws Exception {
            AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", previousOpenSearchPathConf));
        assertTrue(countDownLatch.await(5000, TimeUnit.SECONDS));
    private static class AssertingInputStream extends FilterInputStream {
                    if (countDownComplete.countDown()) {
        openInputStreams.forEach(inputStream -> {
            2,
            }
        WriteLargeBlobHelper(metadata);
    }
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
                            ),
 * Unless required by applicable law or agreed to in writing,
import static org.hamcrest.Matchers.is;
            }
                    assertThat((long) bytes.length(), anyOf(equalTo(lastPartSize), equalTo(bufferSize.getBytes())));
        Stream.of(streamReaderService, futureCompletionService, remoteTransferRetry, transferQueueConsumerService, scheduler)
                        Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, Math.max(1, bytes.length - 1))]);
            .doRemoteDataIntegrityCheck(false)
        final ByteSizeValue bufferSize = new ByteSizeValue(5, ByteSizeUnit.MB);
        Map<String, String> metadata = new HashMap<>();
                true,
}
                            HttpStatus.SC_GATEWAY_TIMEOUT
import org.opensearch.cluster.metadata.RepositoryMetadata;
        final int maxRetries = randomInt(5);
            } else {
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;
                } else if ("POST".equals(exchange.getRequestMethod()) && exchange.getRequestURI().getQuery().equals("uploadId=TEST")) {
                }
            try {
    }
                }
                exchange.close();
            new ByteSizeValue(Runtime.getRuntime().availableProcessors() * 5L, ByteSizeUnit.GB),
                    } else {
            if (range) {
                            + "<CompleteMultipartUploadResult>\n"
        private final long position;
        ) {
                        byte[] response = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
 * software distributed under the License is distributed on an
    private ExecutorService remoteTransferRetry;
import org.opensearch.core.common.bytes.BytesReference;
    @Override
                    return;
        }
            .uploadFinalizer(Assert::assertTrue)
import static org.opensearch.repositories.s3.S3ClientSettings.DISABLE_CHUNKED_ENCODING;
            blobContainer.writeBlobWithMetadata("write_large_blob", new ZeroInputStream(blobSize), blobSize, false, metadata);
        scheduler = new ScheduledThreadPoolExecutor(1);
import org.opensearch.common.util.io.IOUtils;
import java.net.SocketTimeoutException;
        final byte[] bytes = randomByteArrayOfLength(randomIntBetween(10, 128));
    private AsyncTransferEventLoopGroup transferNIOGroup;
 */
    protected Class<? extends Exception> unresponsiveExceptionType() {
        );
import static org.opensearch.repositories.s3.S3Repository.EXPECTED_BUCKET_OWNER_SETTING;
                SERVER_SIDE_ENCRYPTION_KMS_KEY_SETTING.getDefault(Settings.EMPTY),
        assertThat(countDown.isCountedDown(), is(true));
                        + "  <UploadId>TEST</UploadId>\n"
                        + ']',
                        exchange.sendResponseHeaders(HttpStatus.SC_OK, -1);
    }
                    "Stream "
            }
                repositoryMetadata,
import static org.opensearch.repositories.s3.S3ClientSettings.REGION;
                                HttpStatus.SC_GATEWAY_TIMEOUT
                } else {
                );
            futureCompletionService,
 * the Apache License, Version 2.0 (the "License"); you may
                            -1
    private ExecutorService transferQueueConsumerService;
    private ExecutorService streamReaderService;
        assertThat(
                bufferSize == null ? S3Repository.BUFFER_SIZE_SETTING.getDefault(Settings.EMPTY) : bufferSize,
import org.opensearch.common.util.concurrent.CountDown;
        final @Nullable TimeValue readTimeout,
import java.util.stream.Stream;
                    exchange.getResponseHeaders().add("Content-Type", "application/xml");
        final CountDown countDown = new CountDown(maxRetries + 1);
@SuppressForbidden(reason = "use a http server")
        );
                new AsyncTransferManager(
        final BlobContainer blobContainer = createBlobContainer(1, readTimeout, true, null);
        assertThat(countDownUploads.get(), equalTo(0));
            .failIfAlreadyExists(false)
        final RepositoryMetadata repositoryMetadata = new RepositoryMetadata(
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_BUCKET_KEY_SETTING;
import org.opensearch.core.common.unit.ByteSizeValue;
        super.setUp();
        service.refreshAndClearCache(S3ClientSettings.load(clientSettings.build(), configPath()));
                        exchange.sendResponseHeaders(HttpStatus.SC_OK, response.length);
            @Override
        );
                                HttpStatus.SC_INTERNAL_SERVER_ERROR,
                SERVER_SIDE_ENCRYPTION_TYPE_SETTING.getDefault(Settings.EMPTY),
 * not use this file except in compliance with the License.
    private SizeBasedBlockingQ lowPrioritySizeBasedBlockingQ;
                        exchange.getResponseHeaders().add("Content-Type", "application/xml");
            transferQueueConsumerService,
        super.tearDown();
        final byte[] bytes = randomBlobContent();
    private String previousOpenSearchPathConf;
import org.opensearch.common.unit.TimeValue;
                    }
            transferNIOGroup
import org.opensearch.common.io.InputStreamContainer;
                }
        AssertingInputStream(InputStream in, String blobName, long position, long length) {
 * license agreements. See the NOTICE file distributed with
                    s3Stream.isEof() || s3Stream.isAborted()
                        5,
                    // complete multipart upload request
        secureSettings.setString(
                S3Repository.CANNED_ACL_SETTING.getDefault(Settings.EMPTY),
        lowPrioritySizeBasedBlockingQ = new SizeBasedBlockingQ(
        Map<String, String> metadata = new HashMap<>();
 *
import static org.opensearch.repositories.s3.S3Repository.BULK_DELETE_SIZE;
                if (randomBoolean() && contentLength > 0) {
        return (int) ((contentLength % partSize) == 0 ? contentLength / partSize : (contentLength / partSize) + 1);
                    );
        final TimeValue readTimeout = useTimeout ? TimeValue.timeValueMillis(randomIntBetween(100, 500)) : null;
        normalPrioritySizeBasedBlockingQ = new SizeBasedBlockingQ(
            .writePriority(WritePriority.NORMAL)
import org.opensearch.core.common.unit.ByteSizeUnit;
import org.opensearch.repositories.s3.async.SizeBasedBlockingQ;
                if (randomBoolean()) {
        metadata.put("key2", "value2");
        final int maxRetries = randomInt(5);
 */
import java.util.Objects;
                if (randomBoolean()) {
    protected AsyncMultiStreamBlobContainer createBlobContainer(
                        + toString()
        } else {
                    // upload part request
                        Streams.readFully(exchange.getRequestBody());
 * This class tests how a {@link S3BlobContainer} and its underlying AWS S3 client are retrying requests when reading or writing blobs.
/*
    }
import org.opensearch.common.SuppressForbidden;
import org.junit.After;
package org.opensearch.repositories.s3;
                exchange.close();
        metadata.put("key2", "value2");
public class S3BlobContainerRetriesTests extends AbstractBlobContainerRetriesTestCase implements ConfigPathSupport {
            }
    }
                        exchange.sendResponseHeaders(HttpStatus.SC_OK, -1);
            .forEach(e -> assertTrue(ThreadPool.terminate(e, 5, TimeUnit.SECONDS)));
import org.opensearch.common.io.Streams;
        }
        final String endpoint = "http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort();
                // initiate multipart upload request
        final String clientName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
 *    http://www.apache.org/licenses/LICENSE-2.0
        try (InputStream stream = new ByteArrayInputStream(bytes)) {
 * this work for additional information regarding copyright
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
        httpServer.createContext("/bucket/write_blob_max_retries", exchange -> {
import org.opensearch.common.blobstore.stream.write.WriteContext;
            new S3BlobStore(
            containsString("unable to upload object [write_blob_timeout] using a single upload")
        } else {
                assertTrue(
    }
        AssertingInputStream(InputStream in, String blobName) {
            "repository",
        return "text/plain; charset=utf-8";
            if ("PUT".equals(exchange.getRequestMethod()) && exchange.getRequestURI().getQuery() == null) {
import static org.hamcrest.Matchers.equalTo;
        assertThat(countDown.isCountedDown(), is(true));
            BlobPath.cleanPath(),
 * ownership. Elasticsearch licenses this file to you under
                        exchange.sendResponseHeaders(HttpStatus.SC_BAD_REQUEST, -1);
            }
                    BytesReference bytes = Streams.readFully(digestInputStream);
     */
            clientSettings.put(READ_TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), readTimeout);
 * KIND, either express or implied.  See the License for the
        final long lastPartSize = randomLongBetween(10, 512);
        final MockSecureSettings secureSettings = new MockSecureSettings();
        return "/bucket/" + blob;
                    }
            // sends an error back or let the request time out
        @Override
        // needed by S3AsyncService
        final TimeValue readTimeout = TimeValue.timeValueMillis(randomIntBetween(100, 500));
    private ExecutorService futureCompletionService;
        metadata.put("key1", "value1");
                        );
                        Streams.readFully(exchange.getRequestBody());
import java.util.concurrent.atomic.AtomicInteger;
        asyncService.refreshAndClearCache(S3ClientSettings.load(clientSettings.build(), configPath()));
import java.util.Locale;
            streamReaderService,
    private S3AsyncService asyncService;
        transferQueueConsumerService = Executors.newFixedThreadPool(2);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
    protected String bytesContentType() {
                    exchange.close();
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
import static org.hamcrest.Matchers.anyOf;
            if (in instanceof S3RetryingInputStream) {
import org.junit.Before;
                        return;
import org.opensearch.repositories.s3.async.TransferSemaphoresHolder;
                asyncExecutorContainer,
                    Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, Math.toIntExact(contentLength - 1))]);
                    new TransferSemaphoresHolder(
            } catch (IOException e) {
                        + "</InitiateMultipartUploadResult>").getBytes(StandardCharsets.UTF_8);
            .streamContextSupplier(streamContextSupplier)
        metadata.put("key1", "value1");
            Settings.builder().put(S3Repository.CLIENT_NAME.getKey(), clientName).build()
                if (countDown.countDown()) {
            clientSettings.put(MAX_RETRIES_SETTING.getConcreteSettingForNamespace(clientName).getKey(), maxRetries);
        if (readTimeout != null) {
        private final long length;
                        exchange.sendResponseHeaders(
import org.opensearch.common.hash.MessageDigests;
        });
import org.opensearch.common.blobstore.stream.write.StreamContextSupplier;
 * Modifications Copyright OpenSearch Contributors. See
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", configPath().toString()));
        writeBlobWithReadTimeoutsHelper(metadata);
        final CountDown countDownComplete = new CountDown(nbErrors);
                ),
                description += ", length=" + length;
/*
            } else if ("PUT".equals(exchange.getRequestMethod())
        httpServer.createContext("/bucket/write_blob_timeout", exchange -> {
import java.io.FilterInputStream;
                            -1
        );
        return SdkClientException.class;
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_KMS_KEY_SETTING;
            this.length = length;
            } else {
import static org.opensearch.repositories.s3.S3ClientSettings.MAX_RETRIES_SETTING;
    public void testWriteLargeBlobWithMetadata() throws Exception {
import java.util.Map;
    }
        blobContainer.asyncBlobUpload(writeContext, completionListener);
                        randomFrom(
            this.position = 0L;
import java.net.InetSocketAddress;
import org.opensearch.repositories.s3.async.AsyncTransferEventLoopGroup;
                exchange.close();
        final InetSocketAddress address = httpServer.getAddress();
        });
import software.amazon.awssdk.core.exception.SdkClientException;
        ActionListener<Void> completionListener = ActionListener.wrap(resp -> { countDownLatch.countDown(); }, ex -> {
import org.opensearch.repositories.blobstore.ZeroInputStream;
        }, partSize, calculateLastPartSize(bytes.length, partSize), calculateNumberOfParts(bytes.length, partSize));
                                HttpStatus.SC_SERVICE_UNAVAILABLE,
import org.opensearch.common.blobstore.BlobPath;
            if (randomBoolean()) {
                EXPECTED_BUCKET_OWNER_SETTING.getDefault(Settings.EMPTY)
                                HttpStatus.SC_INTERNAL_SERVER_ERROR,
    @Override
        normalPrioritySizeBasedBlockingQ.start();
            }
import org.junit.Assert;
    public void testWriteBlobWithReadTimeouts() throws Exception {
            this.blobName = blobName;
        final AtomicInteger countDownUploads = new AtomicInteger(nbErrors * (parts + 1));
            if ("POST".equals(exchange.getRequestMethod()) && exchange.getRequestURI().getQuery().equals("uploads")) {
import static org.hamcrest.Matchers.containsString;
                    asyncExecutorContainer.getStreamReader(),
import static org.hamcrest.Matchers.instanceOf;
                        TimeUnit.MINUTES,
                        );
import java.util.concurrent.ExecutorService;
            this.position = position;
                            HttpStatus.SC_BAD_GATEWAY,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
        final int parts = randomIntBetween(1, 5);
            this.range = true;
            this.range = false;
import org.opensearch.common.lucene.store.InputStreamIndexInput;
                                HttpStatus.SC_GATEWAY_TIMEOUT
            }
import java.io.IOException;
        assertThat(countDownComplete.isCountedDown(), is(true));
        final @Nullable Integer maxRetries,
        futureCompletionService = Executors.newSingleThreadExecutor();
                    SdkDigestInputStream digestInputStream = new SdkDigestInputStream(exchange.getRequestBody(), MessageDigests.md5());
        service = new S3Service(configPath(), scheduler);
import java.io.InputStream;
                normalPrioritySizeBasedBlockingQ,
        final BlobContainer blobContainer = createBlobContainer(maxRetries, null, true, null);
                inputStream.close();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        final BlobContainer blobContainer = createBlobContainer(null, readTimeout, true, bufferSize);
                            randomFrom(
    public void WriteLargeBlobHelper(Map<String, String> metadata) throws Exception {
            @Override
 * SPDX-License-Identifier: Apache-2.0
                genericStatsMetricPublisher,
        streamReaderService = Executors.newSingleThreadExecutor();
                                HttpStatus.SC_BAD_GATEWAY,
 * You may obtain a copy of the License at
        });
            return new InputStreamContainer(inputStream, size, position);
                    Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, bytes.length - 1)]);
            try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", bytes), bytes.length)) {
                    Streams.readFully(exchange.getRequestBody());
        IOUtils.close(transferNIOGroup);
    }
        assertThat(exception.getCause(), instanceOf(SdkClientException.class));
                    exchange.close();
                    exchange.sendResponseHeaders(HttpStatus.SC_OK, response.length);
                if (countDownInitiate.countDown()) {
    public void writeBlobWithRetriesHelper(Map<String, String> metadata) throws Exception {
        List<InputStream> openInputStreams = new ArrayList<>();
 * GitHub history for details.
                        + "<InitiateMultipartUploadResult>\n"
        }
        final CountDown countDown = new CountDown(maxRetries + 1);
                            HttpStatus.SC_SERVICE_UNAVAILABLE,
        }
    public void testWriteBlobWithMetadataWithReadTimeouts() throws Exception {
    public void writeBlobWithReadTimeoutsHelper(Map<String, String> metadata) {
                    assertThat(contentLength, anyOf(equalTo(lastPartSize), equalTo(bufferSize.getBytes())));
            if (useTimeout == false) {
                if (countDown.countDown()) {
    }
import software.amazon.awssdk.utils.internal.Base16;
                if (metadata != null) {
                    } else {
import org.apache.http.HttpStatus;
                        -1
    }
        StreamContextSupplier streamContextSupplier = partSize -> new StreamContext((partNo, size, position) -> {
                            randomFrom(
 * compatible open source license.
    }
import org.opensearch.common.network.InetAddresses;
import java.util.concurrent.ScheduledExecutorService;
            super(in);
                            + "</CompleteMultipartUploadResult>").getBytes(StandardCharsets.UTF_8);
                }
                        + " should have reached EOF or should have been aborted but got [eof="
import java.util.HashMap;
    }
                        + "  <Key>write_large_blob</Key>\n"
            exceptionRef.set(ex);
        }
                        + s3Stream.isAborted()
                    exchange.close();
                            + "  <Key>write_large_blob</Key>\n"
            openInputStreams.add(inputStream);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
    }
 * under the License.
            SizeBasedBlockingQ.QueueEventType.LOW
                return new AssertingInputStream(super.readBlob(blobName), blobName);
    private ScheduledExecutorService scheduler;
        assertThat(exception.getCause().getCause().getMessage().toLowerCase(Locale.ROOT), containsString("read timed out"));
        return totalSize % partSize == 0 ? partSize : totalSize % partSize;
                SERVER_SIDE_ENCRYPTION_BUCKET_KEY_SETTING.getDefault(Settings.EMPTY),
                    } else {
                    } else {
import org.opensearch.secure_sm.AccessController;
        if (maxRetries != null) {
        );
        AsyncExecutorContainer asyncExecutorContainer = new AsyncExecutorContainer(
        });
                    return;
            final long contentLength = Long.parseLong(exchange.getRequestHeaders().getFirst("Content-Length"));
 */
                    if (Objects.deepEquals(bytes, BytesReference.toBytes(body))) {
            description += ']';
                        3,
        lowPrioritySizeBasedBlockingQ.start();
                        + "  <Bucket>bucket</Bucket>\n"
                } else {
                return new AssertingInputStream(super.readBlob(blobName, position, length), blobName, position, length);
