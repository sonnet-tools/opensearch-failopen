    private ExecutorService futureCompletionService;  
            }
                if (countDown.countDown()) {
        @Override  
     * Asserts that an InputStream is fully consumed, or aborted, when it is closed  
            } catch (IOException e) {  
                        exchange.sendResponseHeaders(HttpStatus.SC_OK, -1);
    }
import java.io.FilterInputStream;
        assertThat(exception.getCause().getCause(), instanceOf(SocketTimeoutException.class));
        writeBlobWithReadTimeoutsHelper(null);
import org.opensearch.common.network.InetAddresses;
    }  
                    } else {
        httpServer.createContext("/bucket/write_blob_timeout", exchange -> {
    @Override
                    "Stream "  
        final Settings.Builder clientSettings = Settings.builder();  
        asyncService = new S3AsyncService(configPath(), scheduler);
    /**
        );
                }  
                        exchange.sendResponseHeaders(HttpStatus.SC_BAD_REQUEST, -1);  
            SizeBasedBlockingQ.QueueEventType.LOW  
                                HttpStatus.SC_BAD_GATEWAY,
import static org.opensearch.repositories.s3.S3ClientSettings.ENDPOINT_SETTING;
            this.range = false;
        assertThat(exception.getCause().getCause().getMessage().toLowerCase(Locale.ROOT), containsString("read timed out"));  
import org.opensearch.common.hash.MessageDigests;  
                S3Repository.CANNED_ACL_SETTING.getDefault(Settings.EMPTY),  
                        Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, Math.max(1, bytes.length - 1))]);
/**
        );
        private final long length;
            } else if ("PUT".equals(exchange.getRequestMethod())
    private long calculateLastPartSize(long totalSize, long partSize) {  
                    assertThat(contentLength, anyOf(equalTo(lastPartSize), equalTo(bufferSize.getBytes())));  
        final @Nullable Integer maxRetries,
                    SdkDigestInputStream digestInputStream = new SdkDigestInputStream(exchange.getRequestBody(), MessageDigests.md5());  
                    exchange.sendResponseHeaders(HttpStatus.SC_OK, response.length);  
        httpServer.createContext("/bucket/write_blob_by_streams_max_retries", exchange -> {
                    Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, Math.toIntExact(contentLength - 1))]);
                } else {  
 * not use this file except in compliance with the License.
    @Override
        assertThat(countDownInitiate.isCountedDown(), is(true));
        try (InputStream stream = new ByteArrayInputStream(bytes)) {  
            S3ClientSettings.SECRET_KEY_SETTING.getConcreteSettingForNamespace(clientName).getKey(),  
        final BlobContainer blobContainer = createBlobContainer(1, readTimeout, true, null);
import org.opensearch.common.SuppressForbidden;
        final @Nullable ByteSizeValue bufferSize
                asyncExecutorContainer,
    }  
        // needed by S3AsyncService
                    if (randomBoolean()) {
    private SizeBasedBlockingQ lowPrioritySizeBasedBlockingQ;
        if (disableChunkedEncoding != null) {
import java.util.stream.Stream;
                    Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, bytes.length - 1)]);
                        + s3Stream.isEof()  
            public InputStream readBlob(String blobName, long position, long length) throws IOException {  
            transferQueueConsumerService,
                        + "  <UploadId>TEST</UploadId>\n"  
import java.util.concurrent.ScheduledThreadPoolExecutor;  
        WriteLargeBlobHelper(null);
            transferNIOGroup
/*
        public String toString() {
                    )  
        scheduler = new ScheduledThreadPoolExecutor(1);
        } else {
        normalPrioritySizeBasedBlockingQ.start();
    private ExecutorService remoteTransferRetry;
                } else {  
import org.opensearch.common.blobstore.stream.write.WritePriority;
import org.opensearch.secure_sm.AccessController;
                asyncExecutorContainer,
        final CountDown countDown = new CountDown(maxRetries + 1);
    ) {
        IOUtils.close(transferNIOGroup);
        }
import org.opensearch.common.io.Streams;
        public void close() throws IOException {
                            HttpStatus.SC_GATEWAY_TIMEOUT
        secureSettings.setString(S3ClientSettings.ACCESS_KEY_SETTING.getConcreteSettingForNamespace(clientName).getKey(), "access");
            final long contentLength = Long.parseLong(exchange.getRequestHeaders().getFirst("Content-Length"));  
                }  
import org.apache.http.HttpStatus;  
            2,
        assertThat(exception.getCause().getMessage().toLowerCase(Locale.ROOT), containsString("read timed out"));  
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.InputStream;
 */
import java.util.concurrent.CountDownLatch;
import java.nio.charset.StandardCharsets;
                } else {
                        + ']',  
            "secret_password"
                asyncService,
        service.refreshAndClearCache(S3ClientSettings.load(clientSettings.build(), configPath()));
                        exchange.sendResponseHeaders(HttpStatus.SC_OK, -1);
            genericStatsMetricPublisher,
        writeBlobWithReadTimeoutsHelper(metadata);
    public void writeBlobWithReadTimeoutsHelper(Map<String, String> metadata) {
            if ("PUT".equals(exchange.getRequestMethod()) && exchange.getRequestURI().getQuery() == null) {  
            public InputStream readBlob(String blobName) throws IOException {
        return SdkClientException.class;
                        Streams.readFully(exchange.getRequestBody());  
        }, partSize, calculateLastPartSize(bytes.length, partSize), calculateNumberOfParts(bytes.length, partSize));  
                                HttpStatus.SC_GATEWAY_TIMEOUT
                }
                } else if ("POST".equals(exchange.getRequestMethod()) && exchange.getRequestURI().getQuery().equals("uploadId=TEST")) {  
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_ENCRYPTION_CONTEXT_SETTING;
                genericStatsMetricPublisher,
        final AsyncMultiStreamBlobContainer blobContainer = createBlobContainer(maxRetries, null, true, null);
        });  
        private final long position;  
 * this file be licensed under the Apache-2.0 license or a
 * software distributed under the License is distributed on an
            .doRemoteDataIntegrityCheck(false)
import org.opensearch.common.lucene.store.InputStreamIndexInput;
        }  
}  
        normalPrioritySizeBasedBlockingQ.close();  
    public void testWriteBlobWithMetadataWithRetries() throws Exception {
 * license agreements. See the NOTICE file distributed with
        previousOpenSearchPathConf = AccessController.doPrivileged(
import org.opensearch.common.settings.Settings;
                        Streams.readFully(exchange.getRequestBody(), new byte[randomIntBetween(1, Math.max(1, bytes.length - 1))]);
                    if (countDownComplete.countDown()) {
                if (countDownInitiate.countDown()) {
            genericStatsMetricPublisher,
                }
        writeBlobWithRetriesHelper(null);  
                        randomFrom(  
 *
        });  
import java.net.InetSocketAddress;
        if (metadata != null) {
        }
                    }
                            HttpStatus.SC_BAD_GATEWAY,
            SizeBasedBlockingQ.QueueEventType.NORMAL
    private ExecutorService streamReaderService;
    }  
                        + "  <Key>write_large_blob</Key>\n"
 */
import org.opensearch.core.common.unit.ByteSizeValue;
        );
            if ("PUT".equals(exchange.getRequestMethod()) && exchange.getRequestURI().getQuery() == null) {  
            new ByteSizeValue(Runtime.getRuntime().availableProcessors() * 5L, ByteSizeUnit.GB),
 */
            exceptionRef.set(ex);
    public void testWriteLargeBlob() throws Exception {
        assertThat(countDown.isCountedDown(), is(true));
    private SizeBasedBlockingQ normalPrioritySizeBasedBlockingQ;  
                        + "<InitiateMultipartUploadResult>\n"  
        lowPrioritySizeBasedBlockingQ.start();  
        clientSettings.put(REGION.getConcreteSettingForNamespace(clientName).getKey(), "region");  
import org.opensearch.core.common.bytes.BytesReference;  
                        -1  
            clientSettings.put(MAX_RETRIES_SETTING.getConcreteSettingForNamespace(clientName).getKey(), maxRetries);  
        AsyncExecutorContainer asyncExecutorContainer = new AsyncExecutorContainer(
                            ),
                            + "  <Key>write_large_blob</Key>\n"
import org.opensearch.common.StreamContext;  
    }
        };  
        final long lastPartSize = randomLongBetween(10, 512);  
import org.opensearch.common.lucene.store.ByteArrayIndexInput;  
        AssertingInputStream(InputStream in, String blobName, long position, long length) {
            AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", previousOpenSearchPathConf));
 * You may obtain a copy of the License at  
        if (previousOpenSearchPathConf != null) {  
                        + toString()
 * This class tests how a {@link S3BlobContainer} and its underlying AWS S3 client are retrying requests when reading or writing blobs.  
        Map<String, String> metadata = new HashMap<>();
        clientSettings.put(ENDPOINT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), endpoint);
                    exchange.getResponseHeaders().add("Content-Type", "application/xml");
        secureSettings.setString(
        lowPrioritySizeBasedBlockingQ = new SizeBasedBlockingQ(
    public void setUp() throws Exception {
import static org.opensearch.repositories.s3.S3ClientSettings.MAX_RETRIES_SETTING;
            this.length = Long.MAX_VALUE;
            streamReaderService,  
                        + "  <Bucket>bucket</Bucket>\n"
import static org.opensearch.repositories.s3.S3ClientSettings.READ_TIMEOUT_SETTING;  
                    blobContainer.writeBlob("write_blob_timeout", stream, bytes.length, false);
                    if (randomBoolean()) {
            } else {  
    }  
        final RepositoryMetadata repositoryMetadata = new RepositoryMetadata(
            if (range) {
                            HttpStatus.SC_INTERNAL_SERVER_ERROR,
    }
                        exchange.sendResponseHeaders(HttpStatus.SC_OK, response.length);
                        Math.max(Runtime.getRuntime().availableProcessors() * 5, 10),
                    new TransferSemaphoresHolder(  
 * this work for additional information regarding copyright
import java.util.HashMap;  
        assertThat(exception.getCause(), instanceOf(SdkClientException.class));
import static org.opensearch.repositories.s3.S3Repository.BULK_DELETE_SIZE;
                assertThat(((ByteArrayInputStream) in).available(), equalTo(0));
        WriteLargeBlobHelper(metadata);
            .streamContextSupplier(streamContextSupplier)  
        blobContainer.asyncBlobUpload(writeContext, completionListener);
                                HttpStatus.SC_SERVICE_UNAVAILABLE,  
                    Streams.readFully(exchange.getRequestBody());
                            + "<CompleteMultipartUploadResult>\n"
import java.io.IOException;  
    private ExecutorService transferQueueConsumerService;  
        return new S3BlobContainer(
    protected String downloadStorageEndpoint(String blob) {  
public class S3BlobContainerRetriesTests extends AbstractBlobContainerRetriesTestCase implements ConfigPathSupport {
        });
                        genericStatsMetricPublisher
    public void tearDown() throws Exception {
                    exchange.sendResponseHeaders(
                            + "</CompleteMultipartUploadResult>").getBytes(StandardCharsets.UTF_8);
                SERVER_SIDE_ENCRYPTION_KMS_KEY_SETTING.getDefault(Settings.EMPTY),  
        @Override
                exchange.close();  
        return "/bucket/" + blob;
import org.opensearch.common.blobstore.AsyncMultiStreamBlobContainer;
            }
        );
    protected Class<? extends Exception> unresponsiveExceptionType() {
    }
                        byte[] response = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                            randomFrom(  
import org.junit.Assert;
        WriteContext writeContext = new WriteContext.Builder().fileName("write_blob_by_streams_max_retries")
        assertThat(countDownUploads.get(), equalTo(0));
                        + " should have reached EOF or should have been aborted but got [eof="
        openInputStreams.forEach(inputStream -> {  
                description += ", position=" + position;
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_BUCKET_KEY_SETTING;
            } else {  
                && exchange.getRequestURI().getQuery().contains("uploadId=TEST")  
                            ),
            S3Repository.TYPE,  
                SERVER_SIDE_ENCRYPTION_TYPE_SETTING.getDefault(Settings.EMPTY),
                    if (countDownUploads.decrementAndGet() % 2 == 0) {
    public void testWriteBlobWithReadTimeouts() throws Exception {
    public void testWriteBlobByStreamsWithRetries() throws Exception {  
import static org.opensearch.repositories.s3.S3ClientSettings.REGION;
import java.util.concurrent.atomic.AtomicReference;  
                            + "  <Bucket>bucket</Bucket>\n"  
                }
    }
                    // complete multipart upload request
                                HttpStatus.SC_INTERNAL_SERVER_ERROR,
    }  
                        Streams.readFully(exchange.getRequestBody());
            try {
    public void testWriteBlobWithMetadataWithReadTimeouts() throws Exception {  
            this.range = true;
            transferQueueConsumerService,  
package org.opensearch.repositories.s3;
        final CountDown countDown = new CountDown(maxRetries + 1);
    }
            }
    @Override  
                    }
import org.opensearch.repositories.s3.async.AsyncTransferManager;
        transferNIOGroup = new AsyncTransferEventLoopGroup(1);
                        5,  
            }
                lowPrioritySizeBasedBlockingQ,  
 */  
                        return;
                SERVER_SIDE_ENCRYPTION_ENCRYPTION_CONTEXT_SETTING.getDefault(Settings.EMPTY),
        );
            .writePriority(WritePriority.NORMAL)  
                    } else {  
                );
        final TimeValue readTimeout = TimeValue.timeValueMillis(randomIntBetween(100, 500));
import org.opensearch.common.blobstore.BlobPath;
        metadata.put("key2", "value2");  
        final String endpoint = "http://" + InetAddresses.toUriString(address.getAddress()) + ":" + address.getPort();
        final InetSocketAddress address = httpServer.getAddress();  
    public void WriteLargeBlobHelper(Map<String, String> metadata) throws Exception {
                exchange.close();
            }
            clientSettings.put(READ_TIMEOUT_SETTING.getConcreteSettingForNamespace(clientName).getKey(), readTimeout);  
    private S3Service service;  
                                HttpStatus.SC_INTERNAL_SERVER_ERROR,
import org.opensearch.common.util.concurrent.CountDown;  
import static org.hamcrest.Matchers.is;  
            super(in);
                    asyncExecutorContainer.getStreamReader(),  
            containsString("unable to upload object [write_blob_timeout] using a single upload")
            2,  
                return new AssertingInputStream(super.readBlob(blobName, position, length), blobName, position, length);
            futureCompletionService,
                    if (Objects.deepEquals(bytes, BytesReference.toBytes(body))) {  
            @Override
            AccessController.doPrivileged(() -> System.clearProperty("opensearch.path.conf"));  
                    // upload part request
import org.opensearch.common.io.InputStreamContainer;
        });
                        exchange.sendResponseHeaders(HttpStatus.SC_BAD_REQUEST, -1);  
        final long blobSize = (parts * bufferSize.getBytes()) + lastPartSize;
import java.util.concurrent.Executors;
                    } else {
        }
            InputStream inputStream = new OffsetRangeIndexInputStream(new ByteArrayIndexInput("desc", bytes), size, position);  
        transferQueueConsumerService = Executors.newFixedThreadPool(2);
            }  
import org.opensearch.common.blobstore.BlobContainer;  
            String description = "[blobName='" + blobName + "', range=" + range;  
 * KIND, either express or implied.  See the License for the
                    }
            .forEach(e -> assertTrue(ThreadPool.terminate(e, 5, TimeUnit.SECONDS)));  
        private final String blobName;
        clientSettings.setSecureSettings(secureSettings);  
        );  
            }
@SuppressForbidden(reason = "use a http server")
        final BlobContainer blobContainer = createBlobContainer(maxRetries, null, true, null);
                    }
        final AtomicInteger countDownUploads = new AtomicInteger(nbErrors * (parts + 1));
    protected AsyncMultiStreamBlobContainer createBlobContainer(  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;  
        return "text/plain; charset=utf-8";  
import org.opensearch.threadpool.ThreadPool;
        writeBlobWithRetriesHelper(metadata);
        normalPrioritySizeBasedBlockingQ = new SizeBasedBlockingQ(  
                        exchange.getResponseBody().write(response);
    @After  
import static org.hamcrest.Matchers.instanceOf;
                        + "</InitiateMultipartUploadResult>").getBytes(StandardCharsets.UTF_8);
                        Streams.readFully(exchange.getRequestBody());
import java.util.List;
import org.opensearch.repositories.blobstore.ZeroInputStream;
 * compatible open source license.
        assertThat(countDownComplete.isCountedDown(), is(true));  
        }
            .build();  
                EXPECTED_BUCKET_OWNER_SETTING.getDefault(Settings.EMPTY)  
            Settings.builder().put(S3Repository.CLIENT_NAME.getKey(), clientName).build()
/*
            blobContainer.writeBlob("write_large_blob", new ZeroInputStream(blobSize), blobSize, false);
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.repositories.s3.async.AsyncTransferEventLoopGroup;  
    public void testWriteLargeBlobWithMetadata() throws Exception {  
                    BytesReference bytes = Streams.readFully(digestInputStream);
            super.close();
        return totalSize % partSize == 0 ? partSize : totalSize % partSize;
import software.amazon.awssdk.utils.internal.Base16;
import org.opensearch.repositories.s3.async.AsyncExecutorContainer;
            description += ']';
        }
                asyncExecutorContainer,  
                && exchange.getRequestURI().getQuery().contains("partNumber=")) {
                    exchange.getResponseBody().write(response);
import java.util.ArrayList;
        final ByteSizeValue bufferSize = new ByteSizeValue(5, ByteSizeUnit.MB);
                if (randomBoolean() && contentLength > 0) {
                assertThat(in, instanceOf(ByteArrayInputStream.class));
            .uploadFinalizer(Assert::assertTrue)
                    final BytesReference body = Streams.readFully(exchange.getRequestBody());
import static org.hamcrest.Matchers.containsString;  
                    Streams.readFully(exchange.getRequestBody());
        Exception exception = expectThrows(IOException.class, () -> {  
     */
            }
import org.opensearch.repositories.s3.async.TransferSemaphoresHolder;  
    public void writeBlobWithRetriesHelper(Map<String, String> metadata) throws Exception {  
            }  
                    exchange.close();
                if (randomBoolean()) {  
        final boolean useTimeout = rarely();  
                repositoryMetadata,  
                        return;  
                        exchange.getResponseHeaders().add("Content-Type", "application/xml");  
                        3,
 * GitHub history for details.
                        exchange.sendResponseHeaders(
    }
import org.junit.After;  
import java.util.Map;  
    }
    protected String bytesContentType() {
        final int nbErrors = 2; // we want all requests to fail at least once  
        lowPrioritySizeBasedBlockingQ.close();
        final int maxRetries = randomInt(5);
                    final BytesReference body = Streams.readFully(exchange.getRequestBody());
                BULK_DELETE_SIZE.get(Settings.EMPTY),
            this.blobName = blobName;
                if (randomBoolean()) {
            }
    }
        final @Nullable TimeValue readTimeout,
import org.opensearch.common.util.io.IOUtils;
    public void testWriteBlobWithRetries() throws Exception {
import org.opensearch.common.settings.MockSecureSettings;  
        );  
        final BlobContainer blobContainer = createBlobContainer(null, readTimeout, true, bufferSize);  
        Map<String, String> metadata = new HashMap<>();
 * SPDX-License-Identifier: Apache-2.0
                    S3Repository.PARALLEL_MULTIPART_UPLOAD_MINIMUM_PART_SIZE_SETTING.getDefault(Settings.EMPTY).getBytes(),
        final MockSecureSettings secureSettings = new MockSecureSettings();  
                    s3Stream.isEof() || s3Stream.isAborted()
                            HttpStatus.SC_SERVICE_UNAVAILABLE,  
        CountDownLatch countDownLatch = new CountDownLatch(1);
                if (randomBoolean()) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        final byte[] bytes = randomBlobContent();
        metadata.put("key1", "value1");
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
        // HTTP server does not send a response
                        );
        });
            openInputStreams.add(inputStream);
        futureCompletionService = Executors.newSingleThreadExecutor();  
            exception.getMessage().toLowerCase(Locale.ROOT),
    }  
        final @Nullable Boolean disableChunkedEncoding,  
        IOUtils.close(service, asyncService);
        List<InputStream> openInputStreams = new ArrayList<>();  
 *  
 * Modifications Copyright OpenSearch Contributors. See  
            this.position = 0L;  
                }
            try (InputStream stream = new InputStreamIndexInput(new ByteArrayIndexInput("desc", bytes), bytes.length)) {
                    );
        final byte[] bytes = randomBlobContent();
                    exchange.close();
import org.opensearch.common.unit.TimeValue;
                }  
            if (randomBoolean()) {  
                return new AssertingInputStream(super.readBlob(blobName), blobName);
                if (countDown.countDown()) {
                        exchange.getResponseHeaders().add("ETag", Base16.encodeAsString(digestInputStream.getMessageDigest().digest()));  
                        ),
    }
        Map<String, String> metadata = new HashMap<>();
 * under the License.  
                        exchange.sendResponseHeaders(
                // initiate multipart upload request  
    @Before  
                            -1  
                        TimeUnit.MINUTES,
            }  
            // sends an error back or let the request time out
import org.opensearch.common.blobstore.stream.write.StreamContextSupplier;
                normalPrioritySizeBasedBlockingQ,
                    blobContainer.writeBlobWithMetadata("write_blob_timeout", stream, bytes.length, false, metadata);  
    }
        remoteTransferRetry = Executors.newFixedThreadPool(20);  
        metadata.put("key1", "value1");
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_TYPE_SETTING;
    }
    private ScheduledExecutorService scheduler;
                description += ", length=" + length;  
        final String clientName = randomAlphaOfLength(5).toLowerCase(Locale.ROOT);
    private String previousOpenSearchPathConf;
            .failIfAlreadyExists(false)
        AssertingInputStream(InputStream in, String blobName) {  
        httpServer.createContext("/bucket/write_large_blob", exchange -> {
                            randomFrom(  
        });  
        super.setUp();  
        final byte[] bytes = randomByteArrayOfLength(randomIntBetween(10, 128));  
            if (in instanceof S3RetryingInputStream) {  
                        + s3Stream.isAborted()
                        + ", aborted="
import software.amazon.awssdk.core.io.SdkDigestInputStream;  
        metadata.put("key1", "value1");  
            .fileSize(bytes.length)
            this.position = position;
                exchange.close();
                    } else {  
        final TimeValue readTimeout = useTimeout ? TimeValue.timeValueMillis(randomIntBetween(100, 500)) : null;
        } else {  
        assertThat(countDown.isCountedDown(), is(true));
            () -> System.setProperty("opensearch.path.conf", configPath().toString())  
                fail("Failure while closing open input streams");
        super.tearDown();
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);  
import java.util.concurrent.TimeUnit;
import java.io.ByteArrayInputStream;
import java.util.Locale;
    private AsyncTransferEventLoopGroup transferNIOGroup;
import org.opensearch.common.Nullable;
/*  
            countDownLatch.countDown();
@ThreadLeakFilters(filters = { EventLoopThreadFilter.class, ResponseInputStreamTimeoutThreadFilter.class })  
import org.opensearch.cluster.metadata.RepositoryMetadata;
                            -1  
        Stream.of(streamReaderService, futureCompletionService, remoteTransferRetry, transferQueueConsumerService, scheduler)
                new AsyncTransferManager(
                    }
import software.amazon.awssdk.core.exception.SdkClientException;
import static org.hamcrest.Matchers.anyOf;
        if (readTimeout != null) {
 * The OpenSearch Contributors require contributions made to  
                }  
                    if (Objects.deepEquals(bytes, BytesReference.toBytes(body))) {  
 *
        private final boolean range;
                    asyncExecutorContainer.getStreamReader(),
    @Override
            @Override  
        assertTrue(countDownLatch.await(5000, TimeUnit.SECONDS));  
            return new InputStreamContainer(inputStream, size, position);
                                HttpStatus.SC_SERVICE_UNAVAILABLE,  
        final int maxRetries = randomInt(5);
                blobContainer.writeBlobWithMetadata("write_blob_max_retries", stream, bytes.length, false, metadata);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.action.ActionListener;
        metadata.put("key2", "value2");
            new S3BlobStore(  
                        exchange.close();  
        }
        streamReaderService = Executors.newSingleThreadExecutor();
import org.opensearch.common.blobstore.stream.write.WriteContext;  
                                HttpStatus.SC_BAD_GATEWAY,
                        );
        if (maxRetries != null) {
            )
        final int parts = randomIntBetween(1, 5);
            this.blobName = blobName;
            if (useTimeout == false) {  
import static org.opensearch.repositories.s3.S3Repository.SERVER_SIDE_ENCRYPTION_KMS_KEY_SETTING;  
                bufferSize == null ? S3Repository.BUFFER_SIZE_SETTING.getDefault(Settings.EMPTY) : bufferSize,
import static org.hamcrest.Matchers.equalTo;
        metadata.put("key2", "value2");  
        ) {
                    asyncExecutorContainer.getStreamReader(),
            "repository",
                    return;  
    private S3AsyncService asyncService;
                ),
        return (int) ((contentLength % partSize) == 0 ? contentLength / partSize : (contentLength / partSize) + 1);
import org.junit.Before;
                if (metadata != null) {
import java.util.concurrent.ScheduledExecutorService;
            blobContainer.writeBlobWithMetadata("write_large_blob", new ZeroInputStream(blobSize), blobSize, false, metadata);
            clientSettings.put(DISABLE_CHUNKED_ENCODING.getConcreteSettingForNamespace(clientName).getKey(), disableChunkedEncoding);  
                SERVER_SIDE_ENCRYPTION_BUCKET_KEY_SETTING.getDefault(Settings.EMPTY),
        final CountDown countDownComplete = new CountDown(nbErrors);  
        asyncService.refreshAndClearCache(S3ClientSettings.load(clientSettings.build(), configPath()));
                blobContainer.writeBlob("write_blob_max_retries", stream, bytes.length, false);
                final S3RetryingInputStream s3Stream = (S3RetryingInputStream) in;
                        exchange.close();
        ActionListener<Void> completionListener = ActionListener.wrap(resp -> { countDownLatch.countDown(); }, ex -> {  
import org.opensearch.core.common.unit.ByteSizeUnit;
            return description;  
                assertTrue(
    private static class AssertingInputStream extends FilterInputStream {
        httpServer.createContext("/bucket/write_blob_max_retries", exchange -> {
                    byte[] response = ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
 * specific language governing permissions and limitations
                true,  
                        exchange.sendResponseHeaders(HttpStatus.SC_OK, -1);
                    exchange.close();
        assertThat(  
                                HttpStatus.SC_GATEWAY_TIMEOUT
 * Unless required by applicable law or agreed to in writing,
                }
        }
            if (metadata != null) {
                service,
                    return;  
                    }
                    assertThat((long) bytes.length(), anyOf(equalTo(lastPartSize), equalTo(bufferSize.getBytes())));
        }
import org.opensearch.repositories.blobstore.AbstractBlobContainerRetriesTestCase;  
import static org.opensearch.repositories.s3.S3Repository.EXPECTED_BUCKET_OWNER_SETTING;  
import static org.opensearch.repositories.s3.S3ClientSettings.DISABLE_CHUNKED_ENCODING;  
import java.util.concurrent.ExecutorService;  
                    return;  
            if ("POST".equals(exchange.getRequestMethod()) && exchange.getRequestURI().getQuery().equals("uploads")) {
                inputStream.close();
import java.util.Objects;
            super(in);  
            new ByteSizeValue(Runtime.getRuntime().availableProcessors() * 5L, ByteSizeUnit.GB),
    private int calculateNumberOfParts(long contentLength, long partSize) {
                "bucket",
        }  
                S3Repository.STORAGE_CLASS_SETTING.getDefault(Settings.EMPTY),
            BlobPath.cleanPath(),
 * Licensed to Elasticsearch under one or more contributor  
        StreamContextSupplier streamContextSupplier = partSize -> new StreamContext((partNo, size, position) -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        service = new S3Service(configPath(), scheduler);  
        final CountDown countDownInitiate = new CountDown(nbErrors);
        GenericStatsMetricPublisher genericStatsMetricPublisher = new GenericStatsMetricPublisher(10000L, 10, 10000L, 10);
            this.length = length;  
        AccessController.doPrivileged(() -> System.setProperty("opensearch.path.conf", configPath().toString()));
import java.net.SocketTimeoutException;  
        });  
import org.opensearch.repositories.s3.async.SizeBasedBlockingQ;
    }
