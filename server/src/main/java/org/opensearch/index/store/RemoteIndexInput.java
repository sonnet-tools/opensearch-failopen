    public long getFilePointer() {
    @Override
 * peer recovery etc.
 * Currently, only methods from {@link IndexInput} that are required for reading a file from remote store are
        if (bytesRead == len) {  
 * @opensearch.internal
            filePointer += numberOfBytesRead;
    public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {  
 * compatible open source license.
            while (bytesRead > 0 && bytesRead < len) {  
                len -= bytesRead;
     * Returns the current position in this file in terms of number of bytes read so far.
    }
    private final long size;
    @Override  
    public RemoteIndexInput(String name, InputStream inputStream, long size) {
    private final InputStream inputStream;  
import org.apache.lucene.store.IndexInput;
    }
        this.size = size;
/*  
    @Override  
        this.inputStream = inputStream;  
     *
            }
     * Guaranteed to throw an exception and leave the RemoteIndexInput unmodified.  
    }  
            filePointer += bytesRead;
                offset += bytesRead;  
    }  
 * ToDo: Extend ChecksumIndexInput
                bytesRead = inputStream.read(b, offset, len);
        this.filePointer = 0;
public class RemoteIndexInput extends IndexInput {
    public void readBytes(byte[] b, int offset, int len) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
    @Override
 */  
     */
    /**
        throw new UnsupportedOperationException();  
import java.io.IOException;  
     *
    public byte readByte() throws IOException {  
 * implemented. Remaining methods will be implemented as we open up remote store for other use cases like replication,  
    }
        return size;
        }
 * @see RemoteDirectory  
    public void seek(long pos) throws IOException {
    }
 * Class for input from a file in a {@link RemoteDirectory}. Used for all input operations from the remote store.
     * Guaranteed to throw an exception and leave the RemoteIndexInput unmodified.
     * @throws UnsupportedOperationException always
    /**
        }  
     * This method is not implemented as it is not used for the file transfer to/from the remote store.
    private long filePointer;
     */
/**  
        byte[] buffer = new byte[1];
    }
 *
    /**  
        inputStream.close();
        int numberOfBytesRead = inputStream.read(buffer);
        return filePointer;
    @Override
    public void close() throws IOException {
     * This method is not implemented as it is not used for the file transfer to/from the remote store.  
    @Override
     * @throws UnsupportedOperationException always  
    public long length() {  
import java.io.InputStream;
        return buffer[0];  
 */  
}  
        int bytesRead = inputStream.read(b, offset, len);
        } else {
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        super(name);
        if (numberOfBytesRead != -1) {  
 *
        throw new UnsupportedOperationException();
package org.opensearch.index.store;
    }  
                filePointer += bytesRead;
     */  
    @Override  
