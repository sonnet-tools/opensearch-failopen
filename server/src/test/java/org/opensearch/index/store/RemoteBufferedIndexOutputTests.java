        try (final BytesStreamOutput outStream = out) {
import org.junit.Before;
    public void testClose() throws IOException {  
            blobContainer,  
}  
 * compatible open source license.
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
    }  
        } catch (Exception e) {  
    public void testCloseException() throws IOException {
        IndexInput indexInput = mock(IndexInput.class);
import static org.mockito.Mockito.verify;
            indexOutputBufferMock
    public void setup() {  
        String testData = "testData";  
        );  
        BytesStreamOutput outStream = mock(BytesStreamOutput.class);
        when(outStream.bytes()).thenReturn(mockBytesReference);
        );  
            // do nothing
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.common.io.stream.BytesStreamOutput;
        verify(indexOutputBufferMock).close();
        BytesStreamOutput outStream = mock(BytesStreamOutput.class);
        OutputStreamIndexOutput indexOutputBufferMock = mock(OutputStreamIndexOutput.class);
import org.opensearch.common.blobstore.BlobContainer;  
            out,
    private BytesStreamOutput out;
        indexOutputBuffer.getChecksum(); // calling getChecksum() to flush the buffer.  
        remoteBufferedIndexOutput.writeBytes(b, 0, b.length);  
        } catch (Exception e) {
    }  
        assertArrayEquals(b, BytesReference.toBytes(out.bytes()));
        OutputStreamIndexOutput indexOutputBufferMock = mock(OutputStreamIndexOutput.class);  
import static org.mockito.Mockito.doThrow;  
        StreamInput streamInputMock = mock(StreamInput.class);
    private RemoteBufferedIndexOutput remoteBufferedIndexOutput;  
        doThrow(new IOException("Test Induced Failure")).when(streamInputMock).close();
        when(mockBytesReference.streamInput()).thenReturn(streamInputMock);
        BytesReference mockBytesReference = mock(BytesReference.class);  
        IndexInput indexInput = new ByteArrayIndexInput("blobName", testData.getBytes(StandardCharsets.UTF_8));
        verify(outStream).close();  
        super.tearDown();  
import java.io.IOException;  
 * SPDX-License-Identifier: Apache-2.0
        when(outStream.bytes()).thenReturn(mockBytesReference);
        BytesReference mockBytesReference = mock(BytesReference.class);
        OutputStreamIndexOutput indexOutputBufferMock = mock(OutputStreamIndexOutput.class);
import org.opensearch.test.OpenSearchTestCase;
    public void testCopyBytes() throws IOException {
            // do nothing
import static org.mockito.Mockito.any;
    public void testWriteBytes() throws IOException {
        }  
            // do nothing
    }
        );
            indexOutputBufferMock  
import static org.mockito.Mockito.when;  
            FILENAME,  
        );
import org.apache.lucene.store.OutputStreamIndexOutput;
        doThrow(new IOException("Test Induced Failure")).when(indexOutputBufferMock).close();  
        remoteBufferedIndexOutput.copyBytes(indexInput, indexInput.length());
        BytesReference mockBytesReference = mock(BytesReference.class);
        assertEquals(out.bytes().utf8ToString(), testData);
            outStream,
import org.opensearch.core.common.bytes.BytesReference;  
        verify(indexOutputBufferMock).close();
public class RemoteBufferedIndexOutputTests extends OpenSearchTestCase {
        indexOutputBuffer.getChecksum(); // calling getChecksum() to flush the buffer.
        RemoteBufferedIndexOutput bufferedIndexOutputUsingMock = new RemoteBufferedIndexOutput(
    public void testCloseException2() throws IOException {
        verify(blobContainer).writeBlob(eq(FILENAME), any(StreamInput.class), anyLong(), eq(false));
 *
            bufferedIndexOutputUsingMock.close();
        RemoteBufferedIndexOutput bufferedIndexOutputUsingMock = new RemoteBufferedIndexOutput(
        remoteBufferedIndexOutput = new RemoteBufferedIndexOutput(FILENAME, blobContainer, out, indexOutputBuffer);
        try {
import static org.mockito.Mockito.anyLong;
    @Before
        when(mockBytesReference.streamInput()).thenReturn(streamInputMock);  
 * this file be licensed under the Apache-2.0 license or a
            blobContainer,  
    }  
    private OutputStreamIndexOutput indexOutputBuffer;
import java.nio.charset.StandardCharsets;
    }
        out = new BytesStreamOutput();
    @After
        out.reset();
            bufferedIndexOutputUsingMock.close();  
    }
            indexOutputBuffer.close();
            outStream,
        when(mockBytesReference.streamInput()).thenReturn(mock(StreamInput.class));
    private static final String FILENAME = "segment_1";
        OutputStreamIndexOutput indexOutputBufferMock = mock(OutputStreamIndexOutput.class);  
        verify(outStream).close();
    private BlobContainer blobContainer;  
import org.apache.lucene.store.IndexInput;
        StreamInput streamInputMock = mock(StreamInput.class);  
            FILENAME,  
        verify(blobContainer).writeBlob(eq(FILENAME), any(StreamInput.class), anyLong(), eq(false));  
            FILENAME,
        }
        RemoteBufferedIndexOutput bufferedIndexOutputUsingMock = new RemoteBufferedIndexOutput(
    }
            blobContainer,
        out.reset();  
    public void tearDown() throws Exception {
import org.junit.After;  
        doThrow(new IOException("Test Induced Failure")).when(indexOutputBufferMock).copyBytes(eq(indexInput), eq(100L));
            indexOutputBufferMock
            indexOutputBufferMock  
            outStream,
        BytesStreamOutput outStream = mock(BytesStreamOutput.class);  
        indexOutputBuffer = new OutputStreamIndexOutput(FILENAME, FILENAME, out, RemoteBufferedIndexOutput.BUFFER_SIZE);  
 * The OpenSearch Contributors require contributions made to  
        assertThrows(IOException.class, () -> bufferedIndexOutputUsingMock.copyBytes(indexInput, 100));
        byte[] b = new byte[] { Byte.MAX_VALUE };
 */  
        RemoteBufferedIndexOutput bufferedIndexOutputUsingMock = new RemoteBufferedIndexOutput(
            blobContainer,
    }
import static org.mockito.ArgumentMatchers.eq;  
        bufferedIndexOutputUsingMock.close();
    public void testCopyBytesException() throws IOException {
        }
package org.opensearch.index.store;
        blobContainer = mock(BlobContainer.class);
/*  
        verify(indexOutputBufferMock).close();  
        verify(outStream).close();
        when(outStream.bytes()).thenReturn(mockBytesReference);  
        try {
import static org.mockito.Mockito.mock;
        } catch (IOException e) {  
            FILENAME,
