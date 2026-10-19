                    assertEquals(bytesToWrite[(int) streamMarkPosition], resettableCheckedInputStream.read());  
            thread.join();
        long skipBytes = randomLongBetween(1, TEST_FILE_SIZE_BYTES - 1);
        Thread[] threads = new Thread[nParallelReads];
                offsetRangeInputStream,  
                } catch (IOException e) {
            int readByteCount = randomInt(TEST_FILE_SIZE_BYTES - 1) + 1;
 * The OpenSearch Contributors require contributions made to  
    public void testMarkAndReset() throws IOException, InterruptedException {
    protected abstract OffsetRangeInputStream getOffsetRangeInputStream(long size, long position) throws IOException;
                    boolean streamMarked = false;
import java.nio.file.StandardOpenOption;
            );
            int offset = randomInt(TEST_FILE_SIZE_BYTES - 1);  
    @Override
                try {
            threads[readIdx].start();
        ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
                } catch (IOException e) {  
    public void testReadSingleByte() throws IOException, InterruptedException {
                    fail("Failure while reading bytes from offset stream");
    @Override  
        }
                            streamMarked = true;
        long actualBytesSkipped = resettableCheckedInputStream.skip(skipBytes);
            OffsetRangeInputStream offsetRangeInputStream = getOffsetRangeInputStream(readByteCount, offset);  
    public void testReadMultipleBytes() throws IOException, InterruptedException {  
            testFile.getFileName().toString()
                    byte[] buffer = new byte[readByteCount];  
        for (int readIdx = 0; readIdx < nParallelReads; readIdx++) {
                    for (int byteIdx = 0; byteIdx < readByteCount - 1; byteIdx++) {
                            resettableCheckedInputStream.mark(readByteCount);
                            streamMarkChecksum = resettableCheckedInputStream.getChecksum();
        assertEquals(bytesToWrite[(int) skipBytes], resettableCheckedInputStream.read());
import java.io.IOException;
                        streamMarkPosition = offsetRangeInputStream.getFilePointer();  
                            streamMarkPosition = offsetRangeInputStream.getFilePointer();  
                }  
    public void tearDown() throws Exception {  
        assertEquals(-1, resettableCheckedInputStream.read());
        }  
                testFile.getFileName().toString()  
                        resettableCheckedInputStream.read();  
    public void testReadLastByte() throws IOException {
        resettableCheckedInputStreams = new ResettableCheckedInputStream[] { resettableCheckedInputStream };  
                    int bytesRead = resettableCheckedInputStream.read(buffer, 0, readByteCount);
            testFile.getFileName().toString()  
        long skipBytes = TEST_FILE_SIZE_BYTES;
        Thread[] threads = new Thread[nParallelReads];
        for (Thread thread : threads) {  
import org.opensearch.test.OpenSearchTestCase;
        resettableCheckedInputStreams = new ResettableCheckedInputStream[nParallelReads];
    }
package org.opensearch.common.blobstore.transfer.stream;
        ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
        for (Thread thread : threads) {
                    assertEquals(bytesToWrite[offset], resettableCheckedInputStream.read());  
        super.setUp();  
                offsetRangeInputStream,
            });  
                testFile.getFileName().toString()
        resettableCheckedInputStreams = new ResettableCheckedInputStream[nParallelReads];
    protected Path testFile;  
            OffsetRangeInputStream offsetRangeInputStream = getOffsetRangeInputStream(1, offset);
            resettableCheckedInputStreams[readIdx] = resettableCheckedInputStream;  
    private ResettableCheckedInputStream[] resettableCheckedInputStreams;
import java.nio.file.Files;  
                    }
        for (Thread thread : threads) {
            );
                }  
            });
    @Before
            threads[readIdx] = new Thread(() -> {  
            ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
                    if (!streamMarked) {
                    resettableCheckedInputStream.reset();
}
                    }
 * this file be licensed under the Apache-2.0 license or a
        super.tearDown();  
        Files.write(testFile, bytesToWrite, StandardOpenOption.TRUNCATE_EXISTING);
            offsetRangeInputStream,  
        final int nParallelReads = 10;
import org.junit.Before;  
                resettableCheckedInputStream.close();  
            resettableCheckedInputStreams[readIdx] = resettableCheckedInputStream;
                try {
                    fail("Failure while reading bytes from offset stream");
                testFile.getFileName().toString()
    }  
    @After
            threads[readIdx] = new Thread(() -> {
                } catch (IOException e) {
        final int nParallelReads = 100;  
        final int nParallelReads = 10;
            int readByteCount = randomInt(TEST_FILE_SIZE_BYTES - 1) + 1;
                    fail("Failure while reading single byte from offset stream");
            OffsetRangeInputStream offsetRangeInputStream = getOffsetRangeInputStream(readByteCount, offset);
        for (int readIdx = 0; readIdx < nParallelReads; readIdx++) {  
        }  
                    }  
    }  
    }
        Thread[] threads = new Thread[nParallelReads];  
            ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
            resettableCheckedInputStreams[readIdx] = resettableCheckedInputStream;  
    public void testReadAfterSkip() throws IOException {  
            thread.join();
        testFile = createTempFile();
        resettableCheckedInputStreams = new ResettableCheckedInputStream[] { resettableCheckedInputStream };
        for (ResettableCheckedInputStream resettableCheckedInputStream : resettableCheckedInputStreams) {
        );
                    for (int bufferIdx = 0; bufferIdx < readByteCount; bufferIdx++) {  
            int offset = randomInt(TEST_FILE_SIZE_BYTES - readByteCount);  
            threads[readIdx].start();
                        streamMarkChecksum = resettableCheckedInputStream.getChecksum();
                    long streamMarkChecksum = -1;
                try {
        }  
                    assertEquals(readByteCount, bytesRead);
import org.junit.After;
            ResettableCheckedInputStream resettableCheckedInputStream = new ResettableCheckedInputStream(
    private final byte[] bytesToWrite = randomByteArrayOfLength(TEST_FILE_SIZE_BYTES);
 * SPDX-License-Identifier: Apache-2.0
 *
                        assertEquals(bytesToWrite[offset + bufferIdx], buffer[bufferIdx]);
                        resettableCheckedInputStream.mark(readByteCount);
        assertEquals(skipBytes, actualBytesSkipped);
            threads[readIdx] = new Thread(() -> {
                    assertEquals(streamMarkChecksum, resettableCheckedInputStream.getChecksum());
                }
            });
 * compatible open source license.
                        if (!streamMarked && randomBoolean()) {
            offsetRangeInputStream,
                    long streamMarkPosition = -1;  
            thread.join();
            );
        for (int readIdx = 0; readIdx < nParallelReads; readIdx++) {
        resettableCheckedInputStreams = new ResettableCheckedInputStream[nParallelReads];  
            }
        OffsetRangeInputStream offsetRangeInputStream = getOffsetRangeInputStream(TEST_FILE_SIZE_BYTES, 0);
import java.nio.file.Path;
    }
 */  
        }
        );
            threads[readIdx].start();
                offsetRangeInputStream,  
public abstract class ResettableCheckedInputStreamBaseTest extends OpenSearchTestCase {
        }  
    }
    public void setUp() throws Exception {
        }
            int offset = randomInt(TEST_FILE_SIZE_BYTES - readByteCount);
    }  
/*  
            if (resettableCheckedInputStream != null) {
                        }  
        OffsetRangeInputStream offsetRangeInputStream = getOffsetRangeInputStream(TEST_FILE_SIZE_BYTES, 0);  
        assertEquals(skipBytes, actualBytesSkipped);  
        long actualBytesSkipped = resettableCheckedInputStream.skip(skipBytes);  
    private static final int TEST_FILE_SIZE_BYTES = 10;  
