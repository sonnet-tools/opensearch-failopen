                try {
 * </ul>
        assertEquals(99, input.readVInt());
        Thread[] readers = new Thread[numReaders];
    private static final byte[] REMOTE_DATA = "remote-data-content-1234567890".getBytes(StandardCharsets.UTF_8);
/*
        remoteDir = new ByteBuffersDirectory();
            clone1.close();
    // Concurrency
 *
        });
            assertEquals(lengthBefore, input.length());
                } catch (Exception e) {
            assertEquals(LOCAL_DATA.length, input.length());
            cloned.readBytes(buf, 0, buf.length);
    }
            if (c != null) c.close();
    }
import org.apache.lucene.store.IndexOutput;
import org.apache.lucene.store.IOContext;
        }
    public void testReadShort() throws IOException {
            assertEquals(LOCAL_DATA[0], input.readByte());
            byte[] expected = new byte[5];
    // ═══════════════════════════════════════════════════════════════
            short remoteVal = input.readShort();
        }
        });
        // Write a proper VInt to both directories
            assertFalse(cloned.hasSwitchedToRemote());
        FormatSwitchableIndexInput input = createSwitchable();
            input.seek(5);
            sliced.close();
        IndexInput localInput = localDir.openInput(FILE_NAME, IOContext.DEFAULT);
        }
            out.writeVInt(42);
        try (FormatSwitchableIndexInput input = createSwitchable()) {
                    start.await();
            });
    }
    public void testSwitchToRemoteTransitionsReads() throws IOException {
        }
    private static final byte[] LOCAL_DATA = "local-data-content-1234567890".getBytes(StandardCharsets.UTF_8);
            IndexInput cloned = input.clone();
            byte[] buf = new byte[REMOTE_DATA.length];
        }
    }
            input.seek(0);
    }
            cloned.readBytes(buf, 0, buf.length);
package org.opensearch.storage.indexinput;
            clones[idx] = new AtomicReference<>();
            assertArrayEquals(expected, buf);
 */
    // Clone and slice
 */
    // ═══════════════════════════════════════════════════════════════
 * compatible open source license.
                }
            input.switchToRemote();
            assertArrayEquals(REMOTE_DATA, buf);
        }
            System.arraycopy(LOCAL_DATA, 5, expected, 0, 5);
    // ═══════════════════════════════════════════════════════════════
            cloned.close();
    // ═══════════════════════════════════════════════════════════════
            assertEquals(0, input.getFilePointer());
                }
            cloned.close();
        for (Thread t : readers) {
        input.switchToRemote();
    public void testReadVInt() throws IOException {
 * <p>Tests cover:
            input.switchToRemote();
        super.setUp();
        try (FormatSwitchableIndexInput input = createSwitchable()) {
            assertEquals(LOCAL_DATA[5], input.readByte());
    }
            assertFalse(input.hasSwitchedToRemote());
    private FormatSwitchableIndexInput createSwitchable() throws IOException {
            IndexInput c = ref.get();
        try (FormatSwitchableIndexInput input = createSwitchable()) {
        }
            long remoteVal = input.readLong();
            t.join(5000);
 * The OpenSearch Contributors require contributions made to
            input.seek(5);
    }
}
        }
                    barrier.await();
                    clones[idx].set(input.clone());
            input.readBytes(buf, 0, buf.length);
            sliced.close();
        int numCloners = 4;
    // ═══════════════════════════════════════════════════════════════
 * this file be licensed under the Apache-2.0 license or a
        input.close();
                return remoteDir.openInput(FILE_NAME, IOContext.DEFAULT);
            assertArrayEquals(LOCAL_DATA, buf);
            assertTrue(input.hasSwitchedToRemote());
public class FormatSwitchableIndexInputTests extends OpenSearchTestCase {
 *   <li>Concurrent reads during switch</li>
            IndexInput cloned = input.clone();
            byte[] buf = new byte[REMOTE_DATA.length];
            FormatSwitchableIndexInput clone1 = (FormatSwitchableIndexInput) input.clone();
                        // Should be either local or remote first byte
    // ═══════════════════════════════════════════════════════════════
        }
            final int idx = i;
            });
        remoteDir.close();
        vRemoteDir.close();
            input.switchToRemote(); // second call is no-op
            FormatSwitchableIndexInput cloned = (FormatSwitchableIndexInput) input.clone();
        writeFile(remoteDir, FILE_NAME, REMOTE_DATA);
            byte[] buf = new byte[REMOTE_DATA.length];
                return vRemoteDir.openInput("vint.dat", IOContext.DEFAULT);
        FormatSwitchableIndexInput input = createSwitchable();
                throw new RuntimeException(e);
    public void testConcurrentReadsAndSwitch() throws Exception {
    public void testSliceAfterSwitchReadsFromRemote() throws IOException {
    }
        try (FormatSwitchableIndexInput input = createSwitchable()) {
    // ═══════════════════════════════════════════════════════════════
        input.close();
        localDir = new ByteBuffersDirectory();
    // ═══════════════════════════════════════════════════════════════
        }
            long lengthBefore = input.length();
        // Should not throw on double close
    // Basic read delegation
    public void testSwitchOnClosedInputIsNoOp() throws IOException {
 *   <li>Clone/slice inherit switch state</li>
        }
        }
            assertArrayEquals(REMOTE_DATA, buf);
    }
            assertArrayEquals(REMOTE_DATA, buf);
            assertArrayEquals(LOCAL_DATA, buf);
import org.opensearch.test.OpenSearchTestCase;
                    failed.set(true);
            assertEquals(5, input.getFilePointer());
        FormatSwitchableIndexInput input = createSwitchable();
        input.switchToRemote();
        FormatSwitchableIndexInput input = createSwitchable();
        try (FormatSwitchableIndexInput input = createSwitchable()) {
        AtomicBoolean failed = new AtomicBoolean(false);
        }
            byte[] buf = new byte[5];
        }
        AtomicReference<IndexInput>[] clones = new AtomicReference[numCloners];
import java.util.concurrent.atomic.AtomicReference;
    public void testCloneReadsFromLocal() throws IOException {
            } catch (IOException e) {
    // ═══════════════════════════════════════════════════════════════
        }
        // Switcher thread
            input.switchToRemote();
        }
            cloned.close();
    @Override
            byte[] expected = new byte[5];
        ByteBuffersDirectory vRemoteDir = new ByteBuffersDirectory();
        Thread.sleep(5); // let readers start
        try (FormatSwitchableIndexInput input = createSwitchable()) {
            input.readBytes(buf, 0, buf.length);
    }
 *   <li>Double switch is no-op</li>
        IndexInput localInput = vLocalDir.openInput("vint.dat", IOContext.DEFAULT);
            input.switchToRemote();
            sliced.readBytes(buf, 0, 5);
            sliced.readBytes(buf, 0, 5);
            assertArrayEquals(expected, buf);
            input.switchToRemote();
            FormatSwitchableIndexInput clone2 = (FormatSwitchableIndexInput) input.clone();
                try (IndexInput clone = input.clone()) {
    }
            // The clone was switched by the cascade in switchToRemote
        for (int i = 0; i < numCloners; i++) {
            out.writeVInt(99);
        return new FormatSwitchableIndexInput("FormatSwitchable(test.parquet)", FILE_NAME, localInput, () -> {
    // ═══════════════════════════════════════════════════════════════
            threads[i] = new Thread(() -> {
            cloned.close();
            System.arraycopy(REMOTE_DATA, 5, expected, 0, 5);
        for (Thread t : threads) {
            int remoteVal = input.readInt();
 * Unit tests for {@link FormatSwitchableIndexInput}.
        try (IndexOutput out = vLocalDir.createOutput("vint.dat", IOContext.DEFAULT)) {
        }
        start.countDown();
    // ═══════════════════════════════════════════════════════════════
    }
            assertTrue(input.hasSwitchedToRemote());
    // Helpers
        try (FormatSwitchableIndexInput input = createSwitchable()) {
    private ByteBuffersDirectory remoteDir;
            // After switch, the clone's underlying input is now remote
            input.switchToRemote();
        }
        input.close();
    public void testReadByteFromLocal() throws IOException {
            input.seek(0);
        try (FormatSwitchableIndexInput input = createSwitchable()) {
    public void testLengthReturnsFileLength() throws IOException {
    }
        assertEquals(42, input.readVInt());
            assertEquals(5, cloned.getFilePointer());
import java.nio.charset.StandardCharsets;
        input.close();
            byte[] buf = new byte[REMOTE_DATA.length];
            cloned.readBytes(buf, 0, buf.length);
            assertEquals(5, sliced.length());
        CyclicBarrier barrier = new CyclicBarrier(numReaders + 1);
        assertFalse("No cloner thread should have failed", failed.get());
    // ═══════════════════════════════════════════════════════════════
    // Close behavior
            IndexInput sliced = input.slice("slice", 5, 5);
    public void testSwitchToRemoteIsIdempotent() throws IOException {
    }
    public void testReadLong() throws IOException {
        localDir.close();
    public void testReadDelegatesToLocal() throws IOException {
            input.switchToRemote();
        int numReaders = 4;
    public void testLengthPreservedAfterSwitch() throws IOException {
        }
    private static final String FILE_NAME = "test.parquet";
        try (FormatSwitchableIndexInput input = createSwitchable()) {
        }
                        byte b = clone.readByte();
import java.util.concurrent.CyclicBarrier;
        writeFile(localDir, FILE_NAME, LOCAL_DATA);
import org.apache.lucene.store.IndexInput;
    public void testCloseBeforeSwitch() throws IOException {
        try (IndexOutput out = vRemoteDir.createOutput("vint.dat", IOContext.DEFAULT)) {
    }
            input.switchToRemote();
            input.switchToRemote();
    }
        input.switchToRemote();
    }
        try (FormatSwitchableIndexInput input = createSwitchable()) {
            assertTrue(clone2.hasSwitchedToRemote());
        assertFalse("No reader thread should have failed", failed.get());
    }
    }
    public void testSliceReadsCorrectRange() throws IOException {
            assertTrue(clone1.hasSwitchedToRemote());
import java.util.concurrent.atomic.AtomicInteger;
        AtomicBoolean failed = new AtomicBoolean(false);
            assertTrue("Clone should be switched after parent switches", cloned.hasSwitchedToRemote());
        }
            // Switch should not fail even though clone is closed
        }
        input.switchToRemote();
 *   <li>Close behavior</li>
        }
    // File pointer preservation across switch
    }
        try (FormatSwitchableIndexInput input = createSwitchable()) {
    public void testGetFilePointerStartsAtZero() throws IOException {
    @Override
            try {
import java.util.concurrent.atomic.AtomicBoolean;
        try (FormatSwitchableIndexInput input = createSwitchable()) {
        FormatSwitchableIndexInput input = new FormatSwitchableIndexInput("test", "vint.dat", localInput, () -> {
            long val = input.readLong();
            clone2.close();
            cloned.close();
                        assertTrue(b == LOCAL_DATA[0] || b == REMOTE_DATA[0]);
            }
    private static void writeFile(ByteBuffersDirectory dir, String name, byte[] data) throws IOException {
    }
        Thread[] threads = new Thread[numCloners];
    public void tearDown() throws Exception {
        assertEquals(numReaders, successCount.get());
        }
            byte[] buf = new byte[LOCAL_DATA.length];
        vLocalDir.close();
    public void testConcurrentCloneAndSwitch() throws Exception {
                    for (int j = 0; j < 100; j++) {
        try (IndexOutput out = dir.createOutput(name, IOContext.DEFAULT)) {
 * <ul>
import java.util.concurrent.CountDownLatch;
            input.seek(0);
    // ═══════════════════════════════════════════════════════════════
        try (FormatSwitchableIndexInput input = createSwitchable()) {
            assertArrayEquals(REMOTE_DATA, buf);
 *
            out.writeBytes(data, data.length);
    // ═══════════════════════════════════════════════════════════════
            threads[i].start();
            input.switchToRemote();
            assertTrue(input.hasSwitchedToRemote());
    private ByteBuffersDirectory localDir;
    // switchToRemote cascades to clones
    public void testClosedCloneRemovedFromTrackingBeforeSwitch() throws IOException {
    }
    }
            int val = input.readInt();
            readers[i] = new Thread(() -> {
            input.switchToRemote();
import java.io.IOException;
        try (FormatSwitchableIndexInput input = createSwitchable()) {
    public void testReadInt() throws IOException {
        super.tearDown();
            input.switchToRemote();
    public void testSeekAndRead() throws IOException {
            short val = input.readShort();
                throw new RuntimeException(e);
    // switchToRemote
            input.readBytes(buf, 0, buf.length);
            IndexInput cloned = input.clone();
    // ═══════════════════════════════════════════════════════════════
                    failed.set(true);
        CountDownLatch start = new CountDownLatch(1);
    }
    public void testFilePointerPreservedOnSwitchForClone() throws IOException {
    }
    }
    // ═══════════════════════════════════════════════════════════════
        }
 *   <li>File pointer preservation across switch</li>
            // Both should succeed without error
    public void testSwitchCascadesToExistingClones() throws IOException {
        try (FormatSwitchableIndexInput input = createSwitchable()) {
    public void testCloseAfterSwitch() throws IOException {
    // ═══════════════════════════════════════════════════════════════
    public void testSwitchCascadesToMultipleClones() throws IOException {
                    }
 *   <li>switchToRemote transitions reads to remote</li>
        input.close();
        input.close();
    }
        for (int i = 0; i < numReaders; i++) {
                } catch (Exception e) {
            byte[] buf = new byte[5];
 * SPDX-License-Identifier: Apache-2.0
            readers[i].start();
 *   <li>switchToRemote cascades to existing clones</li>
            } catch (IOException e) {
import org.apache.lucene.store.ByteBuffersDirectory;
            FormatSwitchableIndexInput cloned = (FormatSwitchableIndexInput) input.clone();
        input.switchToRemote(); // should not throw
        ByteBuffersDirectory vLocalDir = new ByteBuffersDirectory();
            try {
            }
            // Switch — clone should also switch and preserve pointer
            IndexInput sliced = input.slice("slice", 5, 5);
            byte[] buf = new byte[LOCAL_DATA.length];
            t.join(5000);
        try (FormatSwitchableIndexInput input = createSwitchable()) {
    }
        AtomicInteger successCount = new AtomicInteger(0);
    // readShort / readInt / readLong / readVInt / readVLong
        }
            // Just verify it doesn't throw and returns something
        try (FormatSwitchableIndexInput input = createSwitchable()) {
        try (FormatSwitchableIndexInput input = createSwitchable()) {
                        clone.seek(0);
            assertFalse(input.hasSwitchedToRemote());
        try (FormatSwitchableIndexInput input = createSwitchable()) {
    }
        barrier.await();
        }
    public void testCloneAfterSwitchReadsFromRemote() throws IOException {
 *   <li>Basic read delegation to local input</li>
/**
                    successCount.incrementAndGet();
    // ═══════════════════════════════════════════════════════════════
    public void setUp() throws Exception {
            // Read a few bytes to advance pointer
        FormatSwitchableIndexInput input = createSwitchable();
        for (AtomicReference<IndexInput> ref : clones) {
