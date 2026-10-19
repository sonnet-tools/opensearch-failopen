        inputStream = mock(InputStream.class);
    public void testSeek() {
        assertThrows(UnsupportedOperationException.class, () -> remoteIndexInput.slice("Slice middle", 50, 100));
        assertEquals(FILESIZE, remoteIndexInput.length());
        verify(inputStream).read(buffer, 13, 7);
    public void testReadByteIOException() throws IOException {  
        verify(inputStream).read(any());  
    }
        when(inputStream.read(any(), eq(0), eq(8))).thenReturn(8);
    public void testReadBytesIOException() throws IOException {  
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.any;
    private static final String FILENAME = "segment_1";  
import static org.mockito.Mockito.eq;
import java.io.InputStream;
        byte[] buffer = new byte[20];
    }
    private static final long FILESIZE = 200;
        byte[] buffer = new byte[10];
    }
/*  
import static org.mockito.Mockito.when;
    public void testGetFilePointer() throws IOException {  
    public void testCloseIOException() throws IOException {
        assertEquals(8, remoteIndexInput.getFilePointer());  
import static org.mockito.Mockito.mock;
        when(inputStream.read(eq(buffer), anyInt(), anyInt())).thenReturn(10).thenReturn(3).thenReturn(6).thenReturn(-1);  
import org.junit.Before;
        InputStream inputStream = spy(InputStream.class);
        remoteIndexInput = new RemoteIndexInput(FILENAME, inputStream, FILESIZE);
        assertThrows(IOException.class, () -> remoteIndexInput.close());
    private InputStream inputStream;  
    public void testLength() {
 */  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        assertThrows(UnsupportedOperationException.class, () -> remoteIndexInput.seek(100L));  
        remoteIndexInput.readBytes(buffer, 0, 20);
    }
    public void testReadByte() throws IOException {  
    }
        verify(inputStream).read(buffer, 19, 1);  
    }
        verify(inputStream).close();
    }
        assertEquals(1, remoteIndexInput.getFilePointer());
    public void testSlice() {  
        when(inputStream.read(buffer, 10, 20)).thenThrow(new IOException("Error reading"));
        verify(inputStream).read(buffer, 13, 7);
        verify(inputStream).read(buffer, 10, 10);
 * SPDX-License-Identifier: Apache-2.0
        doThrow(new IOException("Error closing")).when(inputStream).close();
        byte[] buffer = new byte[20];
import java.io.IOException;
    public void testReadBytesMultipleIterations() throws IOException {
    }  
    }
        when(inputStream.read(any())).thenThrow(new IOException("Error reading"));
    @Before  
}  
        assertThrows(IOException.class, () -> remoteIndexInput.readBytes(buffer, 10, 20));
    }
    public void testReadBytes() throws IOException {
        when(inputStream.read(eq(buffer), anyInt(), anyInt())).thenReturn(10).thenReturn(3).thenReturn(6).thenReturn(-1);  
        when(inputStream.read()).thenReturn(10);
package org.opensearch.index.store;
        remoteIndexInput.close();
    }
    public void setup() {
        remoteIndexInput.readBytes(buffer, 0, 20);
        assertEquals(0, remoteIndexInput.getFilePointer());
    public void testClose() throws IOException {
        verify(inputStream).read(buffer, 0, 20);  
 * compatible open source license.
        remoteIndexInput.readBytes(new byte[8], 0, 8);
    private RemoteIndexInput remoteIndexInput;
import static org.mockito.Mockito.doThrow;  
    }
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(10, remoteIndexInput.readByte());  
import static org.mockito.Mockito.anyInt;
        verify(inputStream).read(buffer, 0, 20);  
public class RemoteIndexInputTests extends OpenSearchTestCase {
import static org.mockito.Mockito.spy;  
 *
        verify(inputStream).read(buffer, 19, 1);  
        remoteIndexInput = new RemoteIndexInput(FILENAME, inputStream, FILESIZE);  
        assertThrows(IOException.class, () -> remoteIndexInput.readByte());  
        assertEquals(19, remoteIndexInput.getFilePointer());
        verify(inputStream).read(buffer, 10, 10);
