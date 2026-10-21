                assertTrue(inputStreamContainer.getInputStream() instanceof ResettableCheckedInputStream);
            StreamContext streamContext = remoteTransferContainer.supplyStreamContext(16);
import org.apache.lucene.store.RateLimiter;
                    latch.countDown();
    public void testSupplyStreamContextDivisibleParts() throws IOException, InterruptedException {
                },
                    @Override
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;
                    }
    }
                            closedCount.incrementAndGet();
                        return new RateLimitingOffsetRangeInputStream(offsetRangeIndexInputStream, rateLimiterSupplier, null);
        }
            inputStreamContainer.getInputStream().close();
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
            remoteTransferContainer.supplyStreamContext(16);
import java.util.Arrays;
                },
        testTypeOfProvidedStreams(true);
                false
                        );
        Mockito.when(rateLimiterSupplier.get()).thenReturn(null);
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
import org.opensearch.test.OpenSearchTestCase;
                assertEquals(expectedChecksum, writeContext.getExpectedChecksum());
    }
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
                    }
                    }
                }
        long lastPartSize,
                    }
                testFile.getFileName().toString(),
}
    }
                true,
    }
                    readAfterClose.set(true);
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
            )
public class RemoteTransferContainerTests extends OpenSearchTestCase {
import java.nio.file.StandardOpenOption;
    public void testTypeOfProvidedStreamsAllCases() throws IOException {
                true
            // Closing stream here. Test Multiple invocations of close. Shouldn't throw any exception
        try {
                            readInvokedLatch.countDown();
                    }
            inputStreamContainer.getInputStream().close();
                },
 * SPDX-License-Identifier: Apache-2.0
                0L,
        AtomicInteger closedCount = new AtomicInteger();
                testFile.getFileName().toString(),
        AtomicBoolean indexInputClosed = new AtomicBoolean();
import java.io.InputStream;
            }
            }
                        return new RateLimitingOffsetRangeInputStream(offsetRangeIndexInputStream, rateLimiterSupplier, null);
                doRemoteDataIntegrityCheck
                },
            )
                            indexInput,
        long partSize,
                threads[i].join();
                            if (readAfterClose.get() == false) {
                try {
                TEST_FILE_SIZE_BYTES,
                    @Override
            assertThrows(AlreadyClosedException.class, () -> inputStreamContainer.getInputStream().readAllBytes());
            for (int partIdx = 0; partIdx < partCount; partIdx++) {
            boolean successReadWait = readInvokedLatch.await(30, TimeUnit.SECONDS);
                testFile.getFileName().toString(),
                    throw new RuntimeException(e);
                        streams[finalPartIdx] = inputStreamContainer.getInputStream();
                    @Override
                                return 0L;
                            boolean closedSuccess = streamClosed.await(30, TimeUnit.SECONDS);
import org.mockito.Mockito;
            if (shouldOffsetInputStreamsBeChecked(isRemoteDataIntegritySupported)) {
            }
        CountDownLatch readInvokedLatch = new CountDownLatch(1);
import java.util.concurrent.TimeUnit;
                true,
                remoteFileName,
                        assertEquals(expectedPartSize, inputStreamContainer.getContentLength());
            new Thread(() -> {
                },
                    inputStreamContainer.getInputStream().readAllBytes();
                assertTrue(inputStreamContainer.getInputStream() instanceof OffsetRangeInputStream);
    }
                true,
    private static final int TEST_FILE_SIZE_BYTES = 128;
                        return new OffsetRangeFileInputStream(testFile, size, position);
            }
        ) {
                testFile.getFileName().toString(),
        try (
        ) {
        }
                0L,
                            size,
            }).start();
    ) throws InterruptedException {
import org.opensearch.common.blobstore.stream.write.WriteContext;
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
        Supplier<RateLimiter> rateLimiterSupplier = Mockito.mock(Supplier.class);
                true,
                WritePriority.NORMAL,
                true,
        } finally {
            inputStreamContainer.getInputStream().close();
import org.apache.lucene.store.IndexInput;
            testSupplyStreamContext(remoteTransferContainer, 16, 16, 8);
    private boolean shouldOffsetInputStreamsBeChecked(boolean isRemoteDataIntegritySupported) {
import java.nio.file.Files;
 * this file be licensed under the Apache-2.0 license or a
                            }
                        IndexInput indexInput = Mockito.mock(IndexInput.class);
    public void testSupplyStreamContextNonDivisibleParts() throws IOException, InterruptedException {
                WritePriority.HIGH,
            assertTrue(readAfterClose.get());
                testFile.getFileName().toString(),
                true,
                            indexInput,
        ) {
        testCreateWriteContext(true);
        }
                int finalPartIdx = partIdx;
        super.setUp();
                        );
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
        RemoteTransferContainer remoteTransferContainer,
            WriteContext writeContext = remoteTransferContainer.createWriteContext();
            )
        testTypeOfProvidedStreams(false);
        try (
    public void testCloseDuringOngoingReadOnStream() throws IOException, InterruptedException {
                        fail("IOException during stream creation");
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
            assertEquals(1, closedCount.get());
        long totalContentLength = remoteTransferContainer.getContentLength();
import java.util.UUID;
                isRemoteDataIntegritySupported
                0L,
        try (
            streamClosed.countDown();
            inputStreamContainer.getInputStream().close();
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
import java.io.IOException;
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
                TEST_FILE_SIZE_BYTES,
            }
    }
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
        logger.info("partSize: {}, lastPartSize: {}, partCount: {}", partSize, lastPartSize, streamContext.getNumberOfParts());
                testFile.getFileName().toString(),
                    stream.close();
            assertThrows(RuntimeException.class, () -> remoteTransferContainer.supplyStreamContext(16));
        }
    private Path testFile;
                testFile.getFileName().toString(),
        return !isRemoteDataIntegritySupported;
            assertTrue(successReadWait);
                            position
        ) {
        String remoteFileName = testFile.getFileName().toString() + UUID.randomUUID();
            assertThrows(RuntimeException.class, () -> remoteTransferContainer.supplyStreamContext(16));
                threads[partIdx] = new Thread(() -> {
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
    }
        try (
        int partCount = streamContext.getNumberOfParts();
    }
        ) {
                testFile.getFileName().toString(),
            assertTrue(indexInputClosed.get());
                WritePriority.HIGH,
        } finally {
                    @Override
                        OffsetRangeIndexInputStream offsetRangeIndexInputStream = new OffsetRangeIndexInputStream(
                        Mockito.doAnswer(invocation -> {
                    @Override
                false
        InputStream[] streams = new InputStream[partCount];
                TEST_FILE_SIZE_BYTES,
import org.opensearch.common.blobstore.stream.write.WritePriority;
import java.util.concurrent.atomic.AtomicInteger;
                });
                testFile.getFileName().toString(),
        StreamContext streamContext = remoteTransferContainer.supplyStreamContext(partSize);
            inputStream = inputStreamContainer.getInputStream();
import org.opensearch.common.io.InputStreamContainer;
                        InputStreamContainer inputStreamContainer = streamContext.provideStream(finalPartIdx);
                testFile.getFileName().toString(),
            InputStreamContainer inputStreamContainer = streamContext.provideStream(0);
    public void testReadAccessWhenStreamClosed() throws IOException {
        try (
import org.opensearch.common.StreamContext;
                TEST_FILE_SIZE_BYTES,
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
                        }).when(indexInput).close();
        ) {
                    }
            )
            Arrays.stream(streams).forEach(stream -> {
                } catch (IOException e) {
    private void testCreateWriteContext(boolean doRemoteDataIntegrityCheck) throws IOException {
            inputStreamContainer.getInputStream().close();
                    try {
    }
            )
        Thread[] threads = new Thread[partCount];
                    @Override
                },
import java.util.concurrent.CountDownLatch;
            )
                long expectedPartSize = (partIdx == partCount - 1) ? lastPartSize : partSize;
        testCreateWriteContext(false);
                        return new OffsetRangeFileInputStream(testFile, size, position);
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeFileInputStream;
                } finally {
                testFile.getFileName().toString(),
        }
                    }
            });
                testFile.getFileName().toString(),
                            assertTrue(closedSuccess);
                        return new OffsetRangeFileInputStream(testFile, size, position);
                0L,
                try {
                    }
import org.opensearch.common.blobstore.transfer.stream.RateLimitingOffsetRangeInputStream;
    public void testCreateWriteContextAllCases() throws IOException {
        int expectedPartCount
        assertEquals(expectedPartCount, partCount);
        try (
                false
    }
    }
            inputStreamContainer.getInputStream().close();
            InputStreamContainer inputStreamContainer = streamContext.provideStream(0);
                            assertFalse(indexInputClosed.get());
            for (int i = 0; i < partCount; i++) {
    @Before
import java.util.function.Supplier;
            } else {
        InputStream inputStream = null;
            } else {
                        });
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
    private void testTypeOfProvidedStreams(boolean isRemoteDataIntegritySupported) throws IOException {
                WritePriority.HIGH,
                    throw new RuntimeException(e);
    private void testSupplyStreamContext(
                threads[partIdx].start();
                assertNull(writeContext.getExpectedChecksum());
                WritePriority.NORMAL,
                        return new OffsetRangeFileInputStream(testFile, size, position);
 */
            StreamContext streamContext = remoteTransferContainer.supplyStreamContext(16);
                WritePriority.HIGH,
            testSupplyStreamContext(remoteTransferContainer, 10, 8, 13);
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
import java.util.concurrent.atomic.AtomicBoolean;
 *
                            return 0L;
            if (doRemoteDataIntegrityCheck) {
            assertTrue(writeContext.isFailIfAlreadyExists());
                            return null;
        CountDownLatch streamClosed = new CountDownLatch(1);
        testFile = createTempFile();
import org.mockito.stubbing.Answer;
            assertEquals(remoteFileName, writeContext.getFileName());
            inputStreamContainer.getInputStream().close();
        }
                TEST_FILE_SIZE_BYTES,
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
        }
                        IndexInput indexInput = Mockito.mock(IndexInput.class);
import org.junit.Before;
        assert partSize * (partCount - 1) + lastPartSize == totalContentLength
                            indexInputClosed.set(true);
                        OffsetRangeIndexInputStream offsetRangeIndexInputStream = new OffsetRangeIndexInputStream(
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
    @Override
            StreamContext streamContext = remoteTransferContainer.supplyStreamContext(16);
import org.opensearch.common.blobstore.transfer.stream.ResettableCheckedInputStream;
                            position
            InputStreamContainer inputStreamContainer = streamContext.provideStream(0);
            assertTrue(inputStreamContainer.getInputStream() instanceof RateLimitingOffsetRangeInputStream);
import org.apache.lucene.store.AlreadyClosedException;
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
 * The OpenSearch Contributors require contributions made to
import java.nio.file.Path;
                expectedChecksum,
            assertEquals(TEST_FILE_SIZE_BYTES, writeContext.getFileSize());
    public void testSupplyStreamContextCalledTwice() throws IOException {
 * compatible open source license.
                WritePriority.HIGH,
                testFile.getFileName().toString(),
        try (
                        return new OffsetRangeFileInputStream(testFile, size, position);
            assertTrue(processed);
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
                }
            if (inputStream != null) {
            boolean processed = latch.await(30, TimeUnit.SECONDS);
        Supplier<RateLimiter> rateLimiterSupplier = Mockito.mock(Supplier.class);
        }
                    } catch (IOException e) {
/*
        ) {
            )
        AtomicBoolean readAfterClose = new AtomicBoolean();
            // Test Multiple invocations of close. Close count should always be 1.
                        Mockito.when(indexInput.getFilePointer()).thenAnswer((Answer<Long>) invocation -> {
            : "part sizes and last part size don't add up to total content length";
                true
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
                true,
                    @Override
        Long expectedChecksum = randomLong();
                },
    }
    public void setUp() throws Exception {
                TEST_FILE_SIZE_BYTES,
        Mockito.when(rateLimiterSupplier.get()).thenReturn(null);
                inputStream.close();
                } catch (IOException e) {
            assertEquals(WritePriority.HIGH, writeContext.getWritePriority());
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
            CountDownLatch latch = new CountDownLatch(1);
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
            assertEquals(doRemoteDataIntegrityCheck, writeContext.doRemoteDataIntegrityCheck());
                            size,
package org.opensearch.common.blobstore.transfer;
                0L,
                0L,
        Files.write(testFile, randomByteArrayOfLength(TEST_FILE_SIZE_BYTES), StandardOpenOption.APPEND);
                TEST_FILE_SIZE_BYTES,
