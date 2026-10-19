package org.opensearch.index.store;
    public void testCopyBytesIOException() throws IOException {
        assertThrows(UnsupportedOperationException.class, () -> remoteIndexOutput.getChecksum());
    @Before
public class RemoteIndexOutputTests extends OpenSearchTestCase {  
import org.opensearch.common.blobstore.BlobContainer;
 * compatible open source license.
        verify(blobContainer).writeBlob(eq(FILENAME), any(InputStreamIndexInput.class), eq(100L), eq(false));
        assertThrows(UnsupportedOperationException.class, () -> remoteIndexOutput.getFilePointer());  
        blobContainer = mock(BlobContainer.class);  
import org.apache.lucene.store.IndexInput;
 * SPDX-License-Identifier: Apache-2.0
    }
import static org.mockito.ArgumentMatchers.any;  
        IndexInput indexInput = mock(IndexInput.class);  
        remoteIndexOutput.copyBytes(indexInput, 100);  
import org.opensearch.test.OpenSearchTestCase;
import static org.mockito.Mockito.mock;  
        assertThrows(UnsupportedOperationException.class, () -> remoteIndexOutput.writeBytes(buffer, 50, 60));
 * this file be licensed under the Apache-2.0 license or a
    }  
        assertThrows(UnsupportedOperationException.class, () -> remoteIndexOutput.writeByte(b));  
    public void testGetFilePointer() {
 * The OpenSearch Contributors require contributions made to  
}  
import org.junit.Before;
        byte b = 10;
import org.opensearch.common.lucene.store.InputStreamIndexInput;  
        doThrow(new IOException("Error writing")).when(blobContainer)  
    }  
    public void testWriteBytes() {  
        remoteIndexOutput = new RemoteIndexOutput(FILENAME, blobContainer);
/*  
        assertThrows(IOException.class, () -> remoteIndexOutput.copyBytes(indexInput, 100));
    public void setup() {
import static org.mockito.Mockito.doThrow;
    public void testGetChecksum() {  
    }
        byte[] buffer = new byte[10];
 */  
    private BlobContainer blobContainer;  
 *
    public void testWriteByte() {
    }
import static org.mockito.ArgumentMatchers.eq;
    }
    private RemoteIndexOutput remoteIndexOutput;
import java.io.IOException;
            .writeBlob(eq(FILENAME), any(InputStreamIndexInput.class), eq(100L), eq(false));
import static org.mockito.Mockito.verify;
    public void testCopyBytes() throws IOException {
        IndexInput indexInput = mock(IndexInput.class);
    }
    private static final String FILENAME = "segment_1";
