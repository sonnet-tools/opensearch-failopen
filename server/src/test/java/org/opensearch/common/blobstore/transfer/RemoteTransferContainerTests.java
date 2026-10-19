            inputStreamContainer.getInputStream().close();  
            )
                false
        Files.write(testFile, randomByteArrayOfLength(TEST_FILE_SIZE_BYTES), StandardOpenOption.APPEND);
            inputStreamContainer.getInputStream().close();
                    stream.close();  
    public void testCloseDuringOngoingReadOnStream() throws IOException, InterruptedException {
                        );  
                0L,  
    private Path testFile;  
    }
                    public OffsetRangeInputStream get(long size, long position) throws IOException {  
    private void testTypeOfProvidedStreams(boolean isRemoteDataIntegritySupported) throws IOException {  
    private void testSupplyStreamContext(  
                            boolean closedSuccess = streamClosed.await(30, TimeUnit.SECONDS);
                        return new OffsetRangeFileInputStream(testFile, size, position);  
            } else {  
        }  
            new Thread(() -> {
                },
            inputStreamContainer.getInputStream().close();
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
                }
                },
                testFile.getFileName().toString(),  
            } else {  
import org.opensearch.test.OpenSearchTestCase;
                            position
                WritePriority.NORMAL,
            inputStreamContainer.getInputStream().close();
                    @Override
                assertTrue(inputStreamContainer.getInputStream() instanceof ResettableCheckedInputStream);
                    }
                0L,  
            }
import java.io.InputStream;
        Supplier<RateLimiter> rateLimiterSupplier = Mockito.mock(Supplier.class);
                        return new RateLimitingOffsetRangeInputStream(offsetRangeIndexInputStream, rateLimiterSupplier, null);  
                    inputStreamContainer.getInputStream().readAllBytes();
    @Override
                        return new OffsetRangeFileInputStream(testFile, size, position);
            inputStreamContainer.getInputStream().close();
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeInputStream;  
            assertEquals(remoteFileName, writeContext.getFileName());
                testFile.getFileName().toString(),
        } finally {
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeFileInputStream;
                testFile.getFileName().toString(),
                    @Override
import org.opensearch.common.blobstore.stream.write.WriteContext;
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {  
        try {  
        ) {  
                        }).when(indexInput).close();
                assertTrue(inputStreamContainer.getInputStream() instanceof OffsetRangeInputStream);
                0L,  
        ) {  
        InputStream[] streams = new InputStream[partCount];
                        );
        }
                TEST_FILE_SIZE_BYTES,
            assertTrue(processed);
                    @Override
        Mockito.when(rateLimiterSupplier.get()).thenReturn(null);
        AtomicBoolean indexInputClosed = new AtomicBoolean();
            }
                WritePriority.HIGH,
                0L,
        assert partSize * (partCount - 1) + lastPartSize == totalContentLength  
                            if (readAfterClose.get() == false) {  
        }
            StreamContext streamContext = remoteTransferContainer.supplyStreamContext(16);
    }  
 * this file be licensed under the Apache-2.0 license or a
            InputStreamContainer inputStreamContainer = streamContext.provideStream(0);
            if (doRemoteDataIntegrityCheck) {
    public void testSupplyStreamContextDivisibleParts() throws IOException, InterruptedException {
                    }
    }
                true
                            }
                int finalPartIdx = partIdx;
                        Mockito.doAnswer(invocation -> {  
                TEST_FILE_SIZE_BYTES,
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(  
                    }
                }  
                            size,  
    ) throws InterruptedException {
    }
        RemoteTransferContainer remoteTransferContainer,
                    }
        super.setUp();
import java.util.concurrent.CountDownLatch;
        try (
            if (shouldOffsetInputStreamsBeChecked(isRemoteDataIntegritySupported)) {
                    public OffsetRangeInputStream get(long size, long position) throws IOException {  
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
        return !isRemoteDataIntegritySupported;
    public void setUp() throws Exception {
            assertTrue(writeContext.isFailIfAlreadyExists());  
        try (  
            )  
        testTypeOfProvidedStreams(true);
            )  
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(  
                TEST_FILE_SIZE_BYTES,  
                },
                    try {
import org.opensearch.common.blobstore.transfer.stream.ResettableCheckedInputStream;
import org.apache.lucene.store.IndexInput;
                            readInvokedLatch.countDown();  
            remoteTransferContainer.supplyStreamContext(16);
import org.junit.Before;
import org.opensearch.common.blobstore.transfer.stream.RateLimitingOffsetRangeInputStream;
                },  
            inputStreamContainer.getInputStream().close();
                WritePriority.NORMAL,  
        CountDownLatch streamClosed = new CountDownLatch(1);
        String remoteFileName = testFile.getFileName().toString() + UUID.randomUUID();  
        }
            assertEquals(WritePriority.HIGH, writeContext.getWritePriority());
            assertTrue(indexInputClosed.get());
                isRemoteDataIntegritySupported
import org.mockito.stubbing.Answer;  
            InputStreamContainer inputStreamContainer = streamContext.provideStream(0);  
            assertTrue(inputStreamContainer.getInputStream() instanceof RateLimitingOffsetRangeInputStream);  
                    @Override  
import org.opensearch.common.blobstore.transfer.stream.OffsetRangeIndexInputStream;
                threads[partIdx] = new Thread(() -> {
                false
                testFile.getFileName().toString(),
            testSupplyStreamContext(remoteTransferContainer, 10, 8, 13);
                        fail("IOException during stream creation");
                assertNull(writeContext.getExpectedChecksum());
            )
        }  
                        });
                        IndexInput indexInput = Mockito.mock(IndexInput.class);
                testFile.getFileName().toString(),
import java.nio.file.StandardOpenOption;
                            size,
import org.apache.lucene.store.AlreadyClosedException;
                            closedCount.incrementAndGet();
package org.opensearch.common.blobstore.transfer;
import java.io.IOException;
                        return new RateLimitingOffsetRangeInputStream(offsetRangeIndexInputStream, rateLimiterSupplier, null);
        try (
    public void testTypeOfProvidedStreamsAllCases() throws IOException {
        testCreateWriteContext(false);
import java.util.concurrent.atomic.AtomicBoolean;
                true,
    }
                            assertFalse(indexInputClosed.get());  
            boolean successReadWait = readInvokedLatch.await(30, TimeUnit.SECONDS);  
                true,
import java.nio.file.Path;
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
            testSupplyStreamContext(remoteTransferContainer, 16, 16, 8);
import org.apache.lucene.store.RateLimiter;  
                } catch (IOException e) {
    }
                        return new OffsetRangeFileInputStream(testFile, size, position);  
        ) {
        ) {
                            return null;  
import java.util.function.Supplier;  
        testFile = createTempFile();  
                testFile.getFileName().toString(),
            // Test Multiple invocations of close. Close count should always be 1.  
                    }
        try (
        ) {
                true,
                    throw new RuntimeException(e);
import org.opensearch.common.io.InputStreamContainer;  
            });
            assertEquals(TEST_FILE_SIZE_BYTES, writeContext.getFileSize());
                });  
                    }
        testTypeOfProvidedStreams(false);  
    }
                assertEquals(expectedChecksum, writeContext.getExpectedChecksum());
    }  
    public void testSupplyStreamContextCalledTwice() throws IOException {
                    public OffsetRangeInputStream get(long size, long position) throws IOException {  
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
            assertThrows(RuntimeException.class, () -> remoteTransferContainer.supplyStreamContext(16));  
        logger.info("partSize: {}, lastPartSize: {}, partCount: {}", partSize, lastPartSize, streamContext.getNumberOfParts());
                            assertTrue(closedSuccess);
            StreamContext streamContext = remoteTransferContainer.supplyStreamContext(16);
                true,
                true,
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
        long lastPartSize,  
            assertThrows(RuntimeException.class, () -> remoteTransferContainer.supplyStreamContext(16));  
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
                        OffsetRangeIndexInputStream offsetRangeIndexInputStream = new OffsetRangeIndexInputStream(
                    public OffsetRangeInputStream get(long size, long position) throws IOException {
    @Before  
                        IndexInput indexInput = Mockito.mock(IndexInput.class);
        try (  
                        InputStreamContainer inputStreamContainer = streamContext.provideStream(finalPartIdx);  
                testFile.getFileName().toString(),  
                TEST_FILE_SIZE_BYTES,  
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
                try {  
    private boolean shouldOffsetInputStreamsBeChecked(boolean isRemoteDataIntegritySupported) {  
import java.nio.file.Files;  
        AtomicBoolean readAfterClose = new AtomicBoolean();  
                testFile.getFileName().toString(),
            : "part sizes and last part size don't add up to total content length";
                testFile.getFileName().toString(),  
    }  
                        return new OffsetRangeFileInputStream(testFile, size, position);  
                    throw new RuntimeException(e);
                    } catch (IOException e) {  
                    @Override
                        return new OffsetRangeFileInputStream(testFile, size, position);
 */  
import java.util.concurrent.TimeUnit;  
            for (int partIdx = 0; partIdx < partCount; partIdx++) {
        }  
import java.util.UUID;
    private static final int TEST_FILE_SIZE_BYTES = 128;
            inputStream = inputStreamContainer.getInputStream();  
                            indexInput,
                        streams[finalPartIdx] = inputStreamContainer.getInputStream();
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
        ) {  
            Arrays.stream(streams).forEach(stream -> {
                inputStream.close();  
        assertEquals(expectedPartCount, partCount);
            )
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {  
                doRemoteDataIntegrityCheck
        Mockito.when(rateLimiterSupplier.get()).thenReturn(null);
 * compatible open source license.
                0L,
                long expectedPartSize = (partIdx == partCount - 1) ? lastPartSize : partSize;  
                true,
    private void testCreateWriteContext(boolean doRemoteDataIntegrityCheck) throws IOException {
import java.util.concurrent.atomic.AtomicInteger;
}  
                TEST_FILE_SIZE_BYTES,
                },  
public class RemoteTransferContainerTests extends OpenSearchTestCase {
    }  
        Supplier<RateLimiter> rateLimiterSupplier = Mockito.mock(Supplier.class);  
        testCreateWriteContext(true);
                    }
                            indexInputClosed.set(true);
                            indexInput,  
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(  
        ) {  
                        OffsetRangeIndexInputStream offsetRangeIndexInputStream = new OffsetRangeIndexInputStream(
                },
        } finally {  
                expectedChecksum,  
    }
        }  
                    }
        StreamContext streamContext = remoteTransferContainer.supplyStreamContext(partSize);  
            }
                WritePriority.HIGH,
                0L,
                TEST_FILE_SIZE_BYTES,  
                            position
        try (  
                testFile.getFileName().toString(),
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
                try {
                WritePriority.HIGH,  
                } finally {
                    @Override
                WritePriority.HIGH,  
            assertThrows(AlreadyClosedException.class, () -> inputStreamContainer.getInputStream().readAllBytes());
    public void testSupplyStreamContextNonDivisibleParts() throws IOException, InterruptedException {
        }
            // Closing stream here. Test Multiple invocations of close. Shouldn't throw any exception
            WriteContext writeContext = remoteTransferContainer.createWriteContext();
            for (int i = 0; i < partCount; i++) {  
        int expectedPartCount
                WritePriority.HIGH,
                        assertEquals(expectedPartSize, inputStreamContainer.getContentLength());
import org.opensearch.common.StreamContext;
            )  
        Thread[] threads = new Thread[partCount];  
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {
                threads[partIdx].start();
            )
                false
        long totalContentLength = remoteTransferContainer.getContentLength();
                remoteFileName,
        try (
                } catch (IOException e) {  
            inputStreamContainer.getInputStream().close();  
            StreamContext streamContext = remoteTransferContainer.supplyStreamContext(16);
        InputStream inputStream = null;
            CountDownLatch latch = new CountDownLatch(1);
            boolean processed = latch.await(30, TimeUnit.SECONDS);
 * SPDX-License-Identifier: Apache-2.0
        long partSize,
            streamClosed.countDown();  
    public void testReadAccessWhenStreamClosed() throws IOException {  
                threads[i].join();
    public void testCreateWriteContextAllCases() throws IOException {  
            assertTrue(successReadWait);
import org.opensearch.common.blobstore.stream.write.WritePriority;  
                true,  
            assertEquals(doRemoteDataIntegrityCheck, writeContext.doRemoteDataIntegrityCheck());  
                new RemoteTransferContainer.OffsetRangeInputStreamSupplier() {  
                testFile.getFileName().toString(),
import org.mockito.Mockito;
            InputStreamContainer inputStreamContainer = streamContext.provideStream(0);
            assertEquals(1, closedCount.get());
                true
            assertTrue(readAfterClose.get());  
            RemoteTransferContainer remoteTransferContainer = new RemoteTransferContainer(
            if (inputStream != null) {
                TEST_FILE_SIZE_BYTES,
                    @Override
        int partCount = streamContext.getNumberOfParts();
            }).start();
            }
                testFile.getFileName().toString(),
                        Mockito.when(indexInput.getFilePointer()).thenAnswer((Answer<Long>) invocation -> {
                            return 0L;
            }
 *
/*  
        CountDownLatch readInvokedLatch = new CountDownLatch(1);
        Long expectedChecksum = randomLong();
        AtomicInteger closedCount = new AtomicInteger();  
 * The OpenSearch Contributors require contributions made to  
                    latch.countDown();  
                testFile.getFileName().toString(),  
                },  
                                return 0L;
    }
import java.util.Arrays;  
                    readAfterClose.set(true);
