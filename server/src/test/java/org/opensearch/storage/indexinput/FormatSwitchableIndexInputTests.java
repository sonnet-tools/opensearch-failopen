        try (FormatSwitchableIndexInput input = createSwitchable()) {  
            cloned.close();
            assertArrayEquals(REMOTE_DATA, buf);
        input.switchToRemote();
        try (IndexOutput out = vLocalDir.createOutput("vint.dat", IOContext.DEFAULT)) {  
                        // Should be either local or remote first byte
        try (FormatSwitchableIndexInput input = createSwitchable()) {
 *   <li>File pointer preservation across switch</li>  
        }  
            input.readBytes(buf, 0, buf.length);  
    // ═══════════════════════════════════════════════════════════════
        input.close();
        }
import org.apache.lucene.store.IndexOutput;
            readers[i].start();
    private FormatSwitchableIndexInput createSwitchable() throws IOException {
        int numCloners = 4;
            sliced.readBytes(buf, 0, 5);  
    }
    }
            assertEquals(LOCAL_DATA.length, input.length());
        vLocalDir.close();
        try (IndexOutput out = vRemoteDir.createOutput("vint.dat", IOContext.DEFAULT)) {  
                    successCount.incrementAndGet();
        try (FormatSwitchableIndexInput input = createSwitchable()) {
        ByteBuffersDirectory vLocalDir = new ByteBuffersDirectory();
        AtomicBoolean failed = new AtomicBoolean(false);
        }
 * <ul>
            final int idx = i;  
        assertEquals(99, input.readVInt());  
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
    // ═══════════════════════════════════════════════════════════════
        super.tearDown();
            FormatSwitchableIndexInput clone2 = (FormatSwitchableIndexInput) input.clone();  
            cloned.readBytes(buf, 0, buf.length);  
            assertArrayEquals(expected, buf);  
    }
    }  
    public void testReadInt() throws IOException {
    }  
    public void testFilePointerPreservedOnSwitchForClone() throws IOException {
import java.util.concurrent.atomic.AtomicInteger;  
        localDir = new ByteBuffersDirectory();  
            FormatSwitchableIndexInput clone1 = (FormatSwitchableIndexInput) input.clone();
            assertTrue(input.hasSwitchedToRemote());  
        }
    }  
    public void testCloseBeforeSwitch() throws IOException {
        assertFalse("No reader thread should have failed", failed.get());
    }
                    start.await();
            // The clone was switched by the cascade in switchToRemote  
            assertEquals(LOCAL_DATA[0], input.readByte());
import org.apache.lucene.store.IndexInput;  
    public void testCloseAfterSwitch() throws IOException {
    public void testConcurrentCloneAndSwitch() throws Exception {  
        return new FormatSwitchableIndexInput("FormatSwitchable(test.parquet)", FILE_NAME, localInput, () -> {  
import org.apache.lucene.store.IOContext;
            assertArrayEquals(LOCAL_DATA, buf);
            }
    public void testReadDelegatesToLocal() throws IOException {
    }  
        }
        }
            input.switchToRemote();
 * The OpenSearch Contributors require contributions made to  
 *   <li>Clone/slice inherit switch state</li>
            threads[i].start();
        assertEquals(numReaders, successCount.get());
        }  
    public void tearDown() throws Exception {
            // Switch should not fail even though clone is closed
        AtomicBoolean failed = new AtomicBoolean(false);  
        }
    // ═══════════════════════════════════════════════════════════════
 * compatible open source license.
            int remoteVal = input.readInt();
        });
    }
        vRemoteDir.close();  
            out.writeVInt(99);
            assertEquals(5, sliced.length());  
            // Both should succeed without error
    public void testReadByteFromLocal() throws IOException {
            byte[] buf = new byte[REMOTE_DATA.length];
                return vRemoteDir.openInput("vint.dat", IOContext.DEFAULT);
        input.close();
            // Just verify it doesn't throw and returns something  
        input.switchToRemote();
            try {
    public void testClosedCloneRemovedFromTrackingBeforeSwitch() throws IOException {
    private static final String FILE_NAME = "test.parquet";
        }
        IndexInput localInput = localDir.openInput(FILE_NAME, IOContext.DEFAULT);
    // ═══════════════════════════════════════════════════════════════  
    }  
            long remoteVal = input.readLong();
    // Helpers
                } catch (Exception e) {  
    }  
                try {  
    // ═══════════════════════════════════════════════════════════════  
        }
    // ═══════════════════════════════════════════════════════════════
    public void testSliceAfterSwitchReadsFromRemote() throws IOException {
            clones[idx] = new AtomicReference<>();
 *   <li>Double switch is no-op</li>
            assertArrayEquals(REMOTE_DATA, buf);
    public void testSwitchToRemoteTransitionsReads() throws IOException {
            byte[] buf = new byte[REMOTE_DATA.length];
    public void testSwitchCascadesToExistingClones() throws IOException {  
            } catch (IOException e) {
        }
            assertTrue(clone1.hasSwitchedToRemote());
    private static final byte[] REMOTE_DATA = "remote-data-content-1234567890".getBytes(StandardCharsets.UTF_8);  
        try (FormatSwitchableIndexInput input = createSwitchable()) {
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════  
        try (FormatSwitchableIndexInput input = createSwitchable()) {
            assertEquals(5, input.getFilePointer());
            assertTrue(input.hasSwitchedToRemote());  
import java.util.concurrent.atomic.AtomicReference;
        try (FormatSwitchableIndexInput input = createSwitchable()) {
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
            IndexInput cloned = input.clone();
            IndexInput cloned = input.clone();  
    private ByteBuffersDirectory localDir;  
            assertEquals(0, input.getFilePointer());
        }
        CyclicBarrier barrier = new CyclicBarrier(numReaders + 1);
            sliced.close();  
            input.seek(5);
            input.switchToRemote();  
 *
            long val = input.readLong();
        FormatSwitchableIndexInput input = createSwitchable();  
        assertEquals(42, input.readVInt());
            assertEquals(LOCAL_DATA[5], input.readByte());  
            IndexInput c = ref.get();
 *   <li>switchToRemote transitions reads to remote</li>  
    public void testLengthPreservedAfterSwitch() throws IOException {
        AtomicInteger successCount = new AtomicInteger(0);
        // Write a proper VInt to both directories  
    public void testSliceReadsCorrectRange() throws IOException {  
            assertArrayEquals(REMOTE_DATA, buf);
    }
            input.switchToRemote();
        input.switchToRemote();
            cloned.close();
/**  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.store.ByteBuffersDirectory;
    public void testReadShort() throws IOException {  
    }  
            sliced.readBytes(buf, 0, 5);
    // readShort / readInt / readLong / readVInt / readVLong  
 * <p>Tests cover:  
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
        for (Thread t : readers) {  
                } catch (Exception e) {  
        for (AtomicReference<IndexInput> ref : clones) {  
            });  
    }
            t.join(5000);
    private static final byte[] LOCAL_DATA = "local-data-content-1234567890".getBytes(StandardCharsets.UTF_8);
                throw new RuntimeException(e);
        FormatSwitchableIndexInput input = new FormatSwitchableIndexInput("test", "vint.dat", localInput, () -> {
        input.close();
        assertFalse("No cloner thread should have failed", failed.get());
        }
                    failed.set(true);
        for (int i = 0; i < numCloners; i++) {
            cloned.close();
 */
        }
 * </ul>
    }  
            readers[i] = new Thread(() -> {
    private ByteBuffersDirectory remoteDir;
            input.readBytes(buf, 0, buf.length);  
            input.switchToRemote();
import java.util.concurrent.atomic.AtomicBoolean;
        remoteDir = new ByteBuffersDirectory();
        });  
    }
    public void testCloneAfterSwitchReadsFromRemote() throws IOException {
            byte[] expected = new byte[5];
public class FormatSwitchableIndexInputTests extends OpenSearchTestCase {  
            byte[] buf = new byte[LOCAL_DATA.length];  
            assertTrue(clone2.hasSwitchedToRemote());
        writeFile(localDir, FILE_NAME, LOCAL_DATA);
            IndexInput cloned = input.clone();
        }  
            });  
            // After switch, the clone's underlying input is now remote
 *   <li>Basic read delegation to local input</li>
            assertArrayEquals(expected, buf);
 *   <li>switchToRemote cascades to existing clones</li>
        int numReaders = 4;
        input.close();  
    public void testLengthReturnsFileLength() throws IOException {
        }  
            input.switchToRemote();
        // Switcher thread
        }
import java.util.concurrent.CyclicBarrier;
        FormatSwitchableIndexInput input = createSwitchable();  
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
            if (c != null) c.close();
            input.switchToRemote();
            // Switch — clone should also switch and preserve pointer  
                try (IndexInput clone = input.clone()) {  
            System.arraycopy(REMOTE_DATA, 5, expected, 0, 5);
            assertFalse(input.hasSwitchedToRemote());
            input.switchToRemote();  
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
        }
            assertEquals(lengthBefore, input.length());  
        Thread.sleep(5); // let readers start  
    }
    // Clone and slice  
    // ═══════════════════════════════════════════════════════════════
            out.writeBytes(data, data.length);
        input.close();
            input.switchToRemote();
            assertFalse(input.hasSwitchedToRemote());
        input.switchToRemote();
        try (IndexOutput out = dir.createOutput(name, IOContext.DEFAULT)) {
            byte[] buf = new byte[5];
    // Concurrency
        Thread[] threads = new Thread[numCloners];
            short val = input.readShort();
    public void testSwitchCascadesToMultipleClones() throws IOException {  
            input.seek(0);
}
        FormatSwitchableIndexInput input = createSwitchable();  
            clone2.close();
        for (int i = 0; i < numReaders; i++) {
            byte[] buf = new byte[REMOTE_DATA.length];
        }
        // Should not throw on double close
            int val = input.readInt();
        FormatSwitchableIndexInput input = createSwitchable();
            byte[] buf = new byte[5];
        super.setUp();
        CountDownLatch start = new CountDownLatch(1);  
            input.seek(5);
            cloned.close();  
    public void testGetFilePointerStartsAtZero() throws IOException {
    public void testConcurrentReadsAndSwitch() throws Exception {
    }  
    }
            clone1.close();  
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
    private static void writeFile(ByteBuffersDirectory dir, String name, byte[] data) throws IOException {  
        input.close();
    // ═══════════════════════════════════════════════════════════════  
 *   <li>Concurrent reads during switch</li>  
            assertFalse(cloned.hasSwitchedToRemote());  
            input.switchToRemote();  
            long lengthBefore = input.length();
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════  
                    barrier.await();
        localDir.close();
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
            input.seek(0);
    @Override  
                        byte b = clone.readByte();
            IndexInput sliced = input.slice("slice", 5, 5);
    // Basic read delegation
    public void testSeekAndRead() throws IOException {
            FormatSwitchableIndexInput cloned = (FormatSwitchableIndexInput) input.clone();
        start.countDown();
            try {  
        remoteDir.close();  
            input.switchToRemote();
    // Close behavior
        }
            }
/*  
    // ═══════════════════════════════════════════════════════════════
            cloned.readBytes(buf, 0, buf.length);
    // ═══════════════════════════════════════════════════════════════
import java.io.IOException;
    @Override  
    }  
    // ═══════════════════════════════════════════════════════════════  
            assertTrue(input.hasSwitchedToRemote());  
        FormatSwitchableIndexInput input = createSwitchable();  
            System.arraycopy(LOCAL_DATA, 5, expected, 0, 5);
                }
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
    }  
 *
package org.opensearch.storage.indexinput;
        }
    public void testSwitchOnClosedInputIsNoOp() throws IOException {
 * this file be licensed under the Apache-2.0 license or a
        }
            threads[i] = new Thread(() -> {
    }  
            } catch (IOException e) {  
                    for (int j = 0; j < 100; j++) {
                    failed.set(true);
            input.seek(0);
                }
    // switchToRemote
        }
    // ═══════════════════════════════════════════════════════════════
            assertTrue("Clone should be switched after parent switches", cloned.hasSwitchedToRemote());
        }
    public void testReadLong() throws IOException {
                    }
        }  
        try (FormatSwitchableIndexInput input = createSwitchable()) {
        barrier.await();
import java.nio.charset.StandardCharsets;
        Thread[] readers = new Thread[numReaders];  
 * Unit tests for {@link FormatSwitchableIndexInput}.
    }
                        assertTrue(b == LOCAL_DATA[0] || b == REMOTE_DATA[0]);  
    public void testCloneReadsFromLocal() throws IOException {  
    // ═══════════════════════════════════════════════════════════════
            byte[] buf = new byte[REMOTE_DATA.length];
        AtomicReference<IndexInput>[] clones = new AtomicReference[numCloners];
            byte[] expected = new byte[5];  
            assertArrayEquals(LOCAL_DATA, buf);  
            // Read a few bytes to advance pointer
    }  
    public void setUp() throws Exception {
    }  
            short remoteVal = input.readShort();  
 *   <li>Close behavior</li>
        IndexInput localInput = vLocalDir.openInput("vint.dat", IOContext.DEFAULT);
            input.switchToRemote(); // second call is no-op
    }
        }
            assertArrayEquals(REMOTE_DATA, buf);
    }
            IndexInput sliced = input.slice("slice", 5, 5);
    }  
        for (Thread t : threads) {
                throw new RuntimeException(e);  
            out.writeVInt(42);
    public void testReadVInt() throws IOException {
            input.switchToRemote();
            cloned.readBytes(buf, 0, buf.length);  
            sliced.close();
import org.opensearch.test.OpenSearchTestCase;
import java.util.concurrent.CountDownLatch;  
        }
            byte[] buf = new byte[LOCAL_DATA.length];
    // File pointer preservation across switch
        input.switchToRemote(); // should not throw
        ByteBuffersDirectory vRemoteDir = new ByteBuffersDirectory();
        try (FormatSwitchableIndexInput input = createSwitchable()) {
    public void testSwitchToRemoteIsIdempotent() throws IOException {
            input.readBytes(buf, 0, buf.length);
        writeFile(remoteDir, FILE_NAME, REMOTE_DATA);  
    // ═══════════════════════════════════════════════════════════════
 */  
            input.switchToRemote();  
    }
                return remoteDir.openInput(FILE_NAME, IOContext.DEFAULT);
            cloned.close();
            assertEquals(5, cloned.getFilePointer());
            FormatSwitchableIndexInput cloned = (FormatSwitchableIndexInput) input.clone();
                    clones[idx].set(input.clone());
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
            t.join(5000);
        try (FormatSwitchableIndexInput input = createSwitchable()) {  
    // switchToRemote cascades to clones  
                        clone.seek(0);  
