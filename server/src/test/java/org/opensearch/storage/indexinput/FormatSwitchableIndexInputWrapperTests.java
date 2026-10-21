            // Reads through wrapper should now come from remote
            sliced.readBytes(buf, 0, 5);
            wrapper.readShort(0); // just verify no exception
        );
            wrapper.readShort(); // just verify no exception
            byte b5 = wrapper.readByte(5);
import java.io.IOException;
 *   <li>Close delegates to inner</li>
    // ═══════════════════════════════════════════════════════════════
    public void testReadLongAtPosition() throws IOException {
            FILE_NAME,
    public void testReadIntDelegatesToInner() throws IOException {
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
        }
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
    // ═══════════════════════════════════════════════════════════════
    public void testSliceReturnsWrappedInstance() throws IOException {
import org.apache.lucene.store.ByteBuffersDirectory;
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
 *
    // ═══════════════════════════════════════════════════════════════
    }
        }
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
    }
        }
            assertArrayEquals(REMOTE_DATA, buf);
        }
            assertTrue(cloned instanceof FormatSwitchableIndexInputWrapper);
        }
            assertTrue("Clone should be a FormatSwitchableIndexInputWrapper", cloned instanceof FormatSwitchableIndexInputWrapper);
            wrapper.readLong(0); // just verify no exception
                    throw new RuntimeException(e);
    // Close
        return new FormatSwitchableIndexInputWrapper("WrapperTest(" + FILE_NAME + ")", switchable);
    // unwrap()
            assertArrayEquals(expected, buf);
    }
import java.nio.charset.StandardCharsets;
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
 *
    // Slice
            cloned.close();
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
            cloned.readBytes(buf, 0, buf.length);
    public void testReadLongDelegatesToInner() throws IOException {
            assertEquals(LOCAL_DATA[0], b);
 * Unit tests for {@link FormatSwitchableIndexInputWrapper}.
            assertArrayEquals(LOCAL_DATA, buf);
    }
            wrapper.readBytes(buf, 0, buf.length);
            IndexInput cloned = wrapper.clone();
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
        IndexInput localInput = localDir.openInput(FILE_NAME, IOContext.DEFAULT);
    // Read delegation
            assertArrayEquals(LOCAL_DATA, buf);
package org.opensearch.storage.indexinput;
        }
    public void testReadShortAtPosition() throws IOException {
    private static final byte[] REMOTE_DATA = "remote-wrapper-test-data-12345".getBytes(StandardCharsets.UTF_8);
 * <ul>
            assertEquals(LOCAL_DATA[0], wrapper.readByte());
    }
                } catch (IOException e) {
            assertArrayEquals(expected, buf);
        localDir = new ByteBuffersDirectory();
}
import org.opensearch.test.OpenSearchTestCase;
    public void testSeekAndGetFilePointer() throws IOException {
        FormatSwitchableIndexInput switchable = new FormatSwitchableIndexInput(
            FormatSwitchableIndexInput inner = wrapper.unwrap();
 * compatible open source license.
import org.apache.lucene.store.IOContext;
    }
    }
    }
            assertArrayEquals(REMOTE_DATA, buf);
        remoteDir.close();
/**
            byte[] buf = new byte[LOCAL_DATA.length];
            wrapper.seek(5);
            byte b = wrapper.readByte(0);
    public void testReadByteAtPosition() throws IOException {
 *   <li>Slice returns wrapped instance</li>
            cloned.readBytes(buf, 0, buf.length);
    }
            assertEquals(LOCAL_DATA.length, wrapper.length());
                try {
 * <p>Tests cover:
                    return remoteDir.openInput(FILE_NAME, IOContext.DEFAULT);
    // ═══════════════════════════════════════════════════════════════
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
    private ByteBuffersDirectory localDir;
    public void testReadBytesDelegatesToInner() throws IOException {
        }
    public void testSwitchToRemoteViaUnwrap() throws IOException {
            byte[] expected = new byte[5];
    private ByteBuffersDirectory remoteDir;
            "FormatSwitchable(wrapper_test.parquet)",
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
        localDir.close();
import org.apache.lucene.store.IndexOutput;
    private static final byte[] LOCAL_DATA = "local-wrapper-test-data-12345".getBytes(StandardCharsets.UTF_8);
            wrapper.unwrap().switchToRemote();
    public void testReadShortDelegatesToInner() throws IOException {
    private static final String FILE_NAME = "wrapper_test.parquet";
    // ═══════════════════════════════════════════════════════════════
            byte[] buf = new byte[REMOTE_DATA.length];
    // Clone
    }
    public void testReadIntAtPosition() throws IOException {
        }
            assertEquals(0, wrapper.getFilePointer());
            System.arraycopy(LOCAL_DATA, 5, expected, 0, 5);
            assertFalse(inner.hasSwitchedToRemote());
            assertEquals(5, wrapper.getFilePointer());
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
            assertEquals(LOCAL_DATA[5], b5);
            assertTrue(inner.hasSwitchedToRemote());
            assertTrue("Slice should be a FormatSwitchableIndexInputWrapper", sliced instanceof FormatSwitchableIndexInputWrapper);
    private static void writeFile(ByteBuffersDirectory dir, String name, byte[] data) throws IOException {
            wrapper.readInt(); // just verify no exception
    }
            localInput,
    }
            wrapper.readBytes(buf, 0, buf.length);
public class FormatSwitchableIndexInputWrapperTests extends OpenSearchTestCase {
    public void tearDown() throws Exception {
            assertFalse(inner.hasSwitchedToRemote());
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
            byte[] buf = new byte[REMOTE_DATA.length];
    }
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
            sliced.readBytes(buf, 0, 5);
    }
            wrapper.unwrap().switchToRemote();
    public void testCloneReturnsWrappedInstance() throws IOException {
            cloned.close();
        try (IndexOutput out = dir.createOutput(name, IOContext.DEFAULT)) {
    // ═══════════════════════════════════════════════════════════════
 * The OpenSearch Contributors require contributions made to
    // RandomAccessInput positional reads
    }
                }
    // ═══════════════════════════════════════════════════════════════
    public void testUnwrapReturnsInner() throws IOException {
            assertEquals(5, sliced.length());
        // Double close should not throw
    }
    // ═══════════════════════════════════════════════════════════════
    public void testCloseDelegatesToInner() throws IOException {
import org.apache.lucene.store.IndexInput;
 *   <li>unwrap() returns the inner FormatSwitchableIndexInput</li>
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)
 * </ul>
 *   <li>Read delegation through wrapper</li>
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
    // ═══════════════════════════════════════════════════════════════
    }
            sliced.close();
        }
            byte[] buf = new byte[LOCAL_DATA.length];
            System.arraycopy(REMOTE_DATA, 5, expected, 0, 5);
 */
            wrapper.readLong(); // just verify no exception
            byte[] buf = new byte[5];
            IndexInput sliced = wrapper.slice("test-slice", 5, 5);
    // ═══════════════════════════════════════════════════════════════
        }
 *   <li>Clone returns wrapped instance</li>
            IndexInput cloned = wrapper.clone();
        writeFile(localDir, FILE_NAME, LOCAL_DATA);
    public void setUp() throws Exception {
    // ═══════════════════════════════════════════════════════════════
    }
    private FormatSwitchableIndexInputWrapper createWrapper() throws IOException {
    public void testCloneAfterSwitchReadsFromRemote() throws IOException {
            byte[] expected = new byte[5];
 * this file be licensed under the Apache-2.0 license or a
        }
 *   <li>switchToRemote via unwrap()</li>
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
        super.tearDown();
        writeFile(remoteDir, FILE_NAME, REMOTE_DATA);
        wrapper.close();
    @Override
        }
    public void testSliceAfterSwitchReadsFromRemote() throws IOException {
    public void testReadByteDelegatesToInner() throws IOException {
        }
            FormatSwitchableIndexInput inner = wrapper.unwrap();
        }
        super.setUp();
 * SPDX-License-Identifier: Apache-2.0
            inner.switchToRemote();
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
 */
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
    }
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
            byte[] buf = new byte[5];
        }
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
            IndexInput sliced = wrapper.slice("test-slice", 5, 5);
    }
    }
    // Helpers
            assertNotNull(inner);
        remoteDir = new ByteBuffersDirectory();
        }
    public void testLengthDelegatesToInner() throws IOException {
        FormatSwitchableIndexInputWrapper wrapper = createWrapper();
            out.writeBytes(data, data.length);
        }
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
            wrapper.readInt(0); // just verify no exception
            }
/*
    @Override
            sliced.close();
            wrapper.seek(0);
    }
            () -> {
 *   <li>Cleaner registration (GC safety)</li>
    // ═══════════════════════════════════════════════════════════════
        }
