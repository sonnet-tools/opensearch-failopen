    // ═══════════════════════════════════════════════════════════════  
    public void testReadIntDelegatesToInner() throws IOException {
            IndexInput cloned = wrapper.clone();
}
 *   <li>switchToRemote via unwrap()</li>
            assertFalse(inner.hasSwitchedToRemote());
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(0, wrapper.getFilePointer());
        }
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
            wrapper.readLong(0); // just verify no exception
            }  
            assertEquals(5, wrapper.getFilePointer());  
 */  
    private static final byte[] LOCAL_DATA = "local-wrapper-test-data-12345".getBytes(StandardCharsets.UTF_8);  
    public void testCloneReturnsWrappedInstance() throws IOException {  
            byte[] buf = new byte[5];  
            wrapper.readBytes(buf, 0, buf.length);  
        super.tearDown();
    }  
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
 *   <li>Close delegates to inner</li>  
            sliced.readBytes(buf, 0, 5);  
            assertFalse(inner.hasSwitchedToRemote());  
    }  
    // ═══════════════════════════════════════════════════════════════
import org.opensearch.test.OpenSearchTestCase;
    // Read delegation  
    public void testReadShortAtPosition() throws IOException {
        }
    }
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
            assertArrayEquals(expected, buf);  
        localDir.close();  
        super.setUp();  
        }
            assertTrue(cloned instanceof FormatSwitchableIndexInputWrapper);  
import org.apache.lucene.store.IOContext;
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
            byte b = wrapper.readByte(0);
        }
            wrapper.readBytes(buf, 0, buf.length);  
            sliced.readBytes(buf, 0, 5);
    }  
    public void testSwitchToRemoteViaUnwrap() throws IOException {
    public void testReadBytesDelegatesToInner() throws IOException {  
import org.opensearch.index.store.remote.file.CleanerDaemonThreadLeakFilter;
        }
    // RandomAccessInput positional reads
    public void testReadLongAtPosition() throws IOException {
    }  
        }
    // ═══════════════════════════════════════════════════════════════
    // unwrap()
            wrapper.seek(0);
    }  
            wrapper.unwrap().switchToRemote();
 *   <li>unwrap() returns the inner FormatSwitchableIndexInput</li>
 */
        }
    public void testSliceAfterSwitchReadsFromRemote() throws IOException {
            wrapper.unwrap().switchToRemote();
            wrapper.readLong(); // just verify no exception
 * Unit tests for {@link FormatSwitchableIndexInputWrapper}.
    // Helpers  
    // ═══════════════════════════════════════════════════════════════  
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
            () -> {  
    @Override
 *   <li>Clone returns wrapped instance</li>
 *  
            sliced.close();
    public void testSliceReturnsWrappedInstance() throws IOException {  
            byte[] buf = new byte[REMOTE_DATA.length];
            assertEquals(LOCAL_DATA[0], wrapper.readByte());
            sliced.close();
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
        wrapper.close();  
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
                    return remoteDir.openInput(FILE_NAME, IOContext.DEFAULT);
            IndexInput cloned = wrapper.clone();
 * <ul>
            assertArrayEquals(REMOTE_DATA, buf);
    }  
    }  
@ThreadLeakFilters(filters = CleanerDaemonThreadLeakFilter.class)  
        remoteDir.close();
 * The OpenSearch Contributors require contributions made to  
    private static final byte[] REMOTE_DATA = "remote-wrapper-test-data-12345".getBytes(StandardCharsets.UTF_8);
    }  
        }
    @Override
            assertArrayEquals(LOCAL_DATA, buf);  
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
            localInput,
        return new FormatSwitchableIndexInputWrapper("WrapperTest(" + FILE_NAME + ")", switchable);
            "FormatSwitchable(wrapper_test.parquet)",  
    // ═══════════════════════════════════════════════════════════════
    // ═══════════════════════════════════════════════════════════════
    // Close
    public void setUp() throws Exception {
/*  
            assertArrayEquals(LOCAL_DATA, buf);
    // Slice  
        writeFile(remoteDir, FILE_NAME, REMOTE_DATA);
    }
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
    public void testLengthDelegatesToInner() throws IOException {
            wrapper.readInt(); // just verify no exception
            assertTrue("Slice should be a FormatSwitchableIndexInputWrapper", sliced instanceof FormatSwitchableIndexInputWrapper);  
        }  
    }  
    public void testCloneAfterSwitchReadsFromRemote() throws IOException {
import org.apache.lucene.store.IndexOutput;  
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
    public void testReadIntAtPosition() throws IOException {
    // ═══════════════════════════════════════════════════════════════
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
 *   <li>Slice returns wrapped instance</li>
            assertEquals(LOCAL_DATA[5], b5);
    // ═══════════════════════════════════════════════════════════════
import java.io.IOException;
    // ═══════════════════════════════════════════════════════════════
            cloned.readBytes(buf, 0, buf.length);
            assertEquals(5, sliced.length());
            wrapper.readShort(); // just verify no exception
    // ═══════════════════════════════════════════════════════════════
            byte b5 = wrapper.readByte(5);  
        }
package org.opensearch.storage.indexinput;
    private static void writeFile(ByteBuffersDirectory dir, String name, byte[] data) throws IOException {
            IndexInput sliced = wrapper.slice("test-slice", 5, 5);
    }
            FILE_NAME,
    private ByteBuffersDirectory remoteDir;
            assertEquals(LOCAL_DATA.length, wrapper.length());
        }
    private FormatSwitchableIndexInputWrapper createWrapper() throws IOException {  
    }  
            wrapper.readInt(0); // just verify no exception
    }  
            IndexInput sliced = wrapper.slice("test-slice", 5, 5);
    }  
            byte[] buf = new byte[5];
        }
            assertNotNull(inner);
    // ═══════════════════════════════════════════════════════════════  
    public void testReadLongDelegatesToInner() throws IOException {
    }
    private ByteBuffersDirectory localDir;
        }
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
        FormatSwitchableIndexInputWrapper wrapper = createWrapper();
                    throw new RuntimeException(e);
        }
    private static final String FILE_NAME = "wrapper_test.parquet";
        localDir = new ByteBuffersDirectory();
 *   <li>Read delegation through wrapper</li>  
import java.nio.charset.StandardCharsets;
                }
        FormatSwitchableIndexInput switchable = new FormatSwitchableIndexInput(
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
    // ═══════════════════════════════════════════════════════════════
    public void testCloseDelegatesToInner() throws IOException {
            FormatSwitchableIndexInput inner = wrapper.unwrap();  
            System.arraycopy(LOCAL_DATA, 5, expected, 0, 5);
            FormatSwitchableIndexInput inner = wrapper.unwrap();
            byte[] buf = new byte[REMOTE_DATA.length];
            assertTrue(inner.hasSwitchedToRemote());
            wrapper.readShort(0); // just verify no exception
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
        IndexInput localInput = localDir.openInput(FILE_NAME, IOContext.DEFAULT);
public class FormatSwitchableIndexInputWrapperTests extends OpenSearchTestCase {
    // ═══════════════════════════════════════════════════════════════
 *   <li>Cleaner registration (GC safety)</li>  
            assertTrue("Clone should be a FormatSwitchableIndexInputWrapper", cloned instanceof FormatSwitchableIndexInputWrapper);  
    public void testReadByteAtPosition() throws IOException {
    public void testUnwrapReturnsInner() throws IOException {
    public void testReadShortDelegatesToInner() throws IOException {
        try (IndexOutput out = dir.createOutput(name, IOContext.DEFAULT)) {  
    // Clone  
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {
        }
    }
            inner.switchToRemote();  
        remoteDir = new ByteBuffersDirectory();
    public void testReadByteDelegatesToInner() throws IOException {  
    public void tearDown() throws Exception {
                } catch (IOException e) {  
    }  
            assertEquals(LOCAL_DATA[0], b);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        try (FormatSwitchableIndexInputWrapper wrapper = createWrapper()) {  
        }
 * compatible open source license.
                try {
    }
    }  
            // Reads through wrapper should now come from remote  
 * <p>Tests cover:
 * </ul>
    // ═══════════════════════════════════════════════════════════════
import org.apache.lucene.store.ByteBuffersDirectory;  
            cloned.readBytes(buf, 0, buf.length);
            cloned.close();
            byte[] expected = new byte[5];
            byte[] buf = new byte[LOCAL_DATA.length];
    public void testSeekAndGetFilePointer() throws IOException {
    }  
        );
 *
            byte[] expected = new byte[5];
            assertArrayEquals(REMOTE_DATA, buf);  
import org.apache.lucene.store.IndexInput;
/**
        // Double close should not throw
            assertArrayEquals(expected, buf);
 * SPDX-License-Identifier: Apache-2.0
        writeFile(localDir, FILE_NAME, LOCAL_DATA);  
            out.writeBytes(data, data.length);
            cloned.close();
            System.arraycopy(REMOTE_DATA, 5, expected, 0, 5);  
        }  
    }  
            wrapper.seek(5);
            byte[] buf = new byte[LOCAL_DATA.length];
        }
