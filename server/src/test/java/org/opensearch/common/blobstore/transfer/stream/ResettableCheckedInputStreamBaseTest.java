                } catch (IOException e) {
                    fail("Failure while reading bytes from offset stream");
                        assertEquals(bytesToWrite[offset + bufferIdx], buffer[bufferIdx]);
    @Override
 * this file be licensed under the Apache-2.0 license or a
        }
    public void testReadLastByte() throws IOException {
        );
    }
                    int bytesRead = resettableCheckedInputStream.read(buffer, 0, readByteCount);
        testFile = createTempFile();
                        if (!streamMarked && randomBoolean()) {
        long actualBytesSkipped = resettableCheckedInputStream.skip(skipBytes);
        assertEquals(skipBytes, actualBytesSkipped);
                try {
        }
    }
        Thread[] threads = new Thread[nParallelReads];
                    }
    public void testReadSingleByte() throws IOException, InterruptedException {
    private static final int TEST_FILE_SIZE_BYTES = 10;
        resettableCheckedInputStreams = new ResettableCheckedInputStream[] { resettableCheckedInputStream };
                    for (int bufferIdx = 0; bufferIdx < readByteCount; bufferIdx++) {
            ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
                        resettableCheckedInputStream.read();
    @Before
    public void testReadAfterSkip() throws IOException {
            OffsetRangeInputStream offsetRangeInputStream = getOffsetRangeInputStream(readByteCount, offset);
    private ResettableCheckedInputStream[] resettableCheckedInputStreams;
    protected Path testFile;
                    assertEquals(bytesToWrite[(int) streamMarkPosition], resettableCheckedInputStream.read());
            ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
    @After
            );
                    assertEquals(streamMarkChecksum, resettableCheckedInputStream.getChecksum());
                    assertEquals(bytesToWrite[offset], resettableCheckedInputStream.read());
        super.setUp();
        }
        Files.write(testFile, bytesToWrite, StandardOpenOption.TRUNCATE_EXISTING);
            testFile.getFileName().toString()
        ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
    }
            resettableCheckedInputStreams[readIdx] = resettableCheckedInputStream;
        Thread[] threads = new Thread[nParallelReads];
        );
        for (int readIdx = 0; readIdx < nParallelReads; readIdx++) {
        assertEquals(-1, resettableCheckedInputStream.read());
                offsetRangeInputStream,
    public void testReadMultipleBytes() throws IOException, InterruptedException {
 *
        for (Thread thread : threads) {
            threads[readIdx] = new Thread(() -> {
                }
                    resettableCheckedInputStream.reset();
                    for (int byteIdx = 0; byteIdx < readByteCount - 1; byteIdx++) {
            threads[readIdx] = new Thread(() -> {
        }
        OffsetRangeInputStream offsetRangeInputStream = getOffsetRangeInputStream(TEST_FILE_SIZE_BYTES, 0);
        long actualBytesSkipped = resettableCheckedInputStream.skip(skipBytes);
        }
package org.opensearch.common.blobstore.transfer.stream;
        for (int readIdx = 0; readIdx < nParallelReads; readIdx++) {
import org.opensearch.test.OpenSearchTestCase;
import java.io.IOException;
        assertEquals(bytesToWrite[(int) skipBytes], resettableCheckedInputStream.read());
                offsetRangeInputStream,
                    fail("Failure while reading single byte from offset stream");
            });
    }
    }
            int offset = randomInt(TEST_FILE_SIZE_BYTES - 1);
                    byte[] buffer = new byte[readByteCount];
                    if (!streamMarked) {
import org.junit.After;
            });
/*
    }
                        streamMarkPosition = offsetRangeInputStream.getFilePointer();
        OffsetRangeInputStream offsetRangeInputStream = getOffsetRangeInputStream(TEST_FILE_SIZE_BYTES, 0);
                    assertEquals(readByteCount, bytesRead);
            resettableCheckedInputStreams[readIdx] = resettableCheckedInputStream;
        assertEquals(skipBytes, actualBytesSkipped);
    @Override
 * SPDX-License-Identifier: Apache-2.0
                testFile.getFileName().toString()
        resettableCheckedInputStreams = new ResettableCheckedInputStream[nParallelReads];
import java.nio.file.Path;
        }
                            streamMarked = true;
            int readByteCount = randomInt(TEST_FILE_SIZE_BYTES - 1) + 1;
        for (ResettableCheckedInputStream resettableCheckedInputStream : resettableCheckedInputStreams) {
 */
            }
                            streamMarkPosition = offsetRangeInputStream.getFilePointer();
                } catch (IOException e) {
        ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
            threads[readIdx].start();
            ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
            OffsetRangeInputStream offsetRangeInputStream = getOffsetRangeInputStream(readByteCount, offset);
    }
        resettableCheckedInputStreams = new ResettableCheckedInputStream[nParallelReads];
 * compatible open source license.
            thread.join();
import java.nio.file.StandardOpenOption;
                        }
        resettableCheckedInputStreams = new ResettableCheckedInputStream[] { resettableCheckedInputStream };
                try {
    public void testMarkAndReset() throws IOException, InterruptedException {
                    }
            threads[readIdx] = new Thread(() -> {
        final int nParallelReads = 100;
                testFile.getFileName().toString()
            thread.join();
    protected abstract OffsetRangeInputStream getOffsetRangeInputStream(long size, long position) throws IOException;
    public void setUp() throws Exception {
        }
}
            int offset = randomInt(TEST_FILE_SIZE_BYTES - readByteCount);
            OffsetRangeInputStream offsetRangeInputStream = getOffsetRangeInputStream(1, offset);
                offsetRangeInputStream,
        for (int readIdx = 0; readIdx < nParallelReads; readIdx++) {
        resettableCheckedInputStreams = new ResettableCheckedInputStream[nParallelReads];
            int readByteCount = randomInt(TEST_FILE_SIZE_BYTES - 1) + 1;
 * The OpenSearch Contributors require contributions made to
                            streamMarkChecksum = resettableCheckedInputStream.getChecksum();
        super.tearDown();
                        streamMarkChecksum = resettableCheckedInputStream.getChecksum();
            );
        long skipBytes = randomLongBetween(1, TEST_FILE_SIZE_BYTES - 1);
            offsetRangeInputStream,
                resettableCheckedInputStream.close();
public abstract class ResettableCheckedInputStreamBaseTest extends OpenSearchTestCase {
            int offset = randomInt(TEST_FILE_SIZE_BYTES - readByteCount);
            thread.join();
                try {
                    boolean streamMarked = false;
        for (Thread thread : threads) {
                }
                    }
import java.nio.file.Files;
        final int nParallelReads = 10;
            threads[readIdx].start();
                } catch (IOException e) {
            offsetRangeInputStream,
            if (resettableCheckedInputStream != null) {
                    fail("Failure while reading bytes from offset stream");
                }
            );
                    long streamMarkPosition = -1;
            });
            threads[readIdx].start();
                    long streamMarkChecksum = -1;
        Thread[] threads = new Thread[nParallelReads];
    private final byte[] bytesToWrite = randomByteArrayOfLength(TEST_FILE_SIZE_BYTES);
                        resettableCheckedInputStream.mark(readByteCount);
import org.junit.Before;
        for (Thread thread : threads) {
            resettableCheckedInputStreams[readIdx] = resettableCheckedInputStream;
                            resettableCheckedInputStream.mark(readByteCount);
        final int nParallelReads = 10;
                testFile.getFileName().toString()
        long skipBytes = TEST_FILE_SIZE_BYTES;
    public void tearDown() throws Exception {
            testFile.getFileName().toString()
