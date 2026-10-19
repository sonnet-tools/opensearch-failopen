     */
     * This method will return checksum  
    static final int BUFFER_SIZE = 4096;
     *
 * SPDX-License-Identifier: Apache-2.0
 * Class for output to a file in a {@link RemoteBufferedOutputDirectory}. This is right now used only for writing locks
    public void close() throws IOException {
        indexOutputBuffer.copyBytes(input, numBytes);
public class RemoteBufferedIndexOutput extends RemoteIndexOutput {
     *
import java.io.InputStream;
    public RemoteBufferedIndexOutput(String name, BlobContainer blobContainer) {
 *
    @Override
    }
    @Override  
    @Override  
     */
        out = new BytesStreamOutput();  
    public void writeByte(byte b) throws IOException {
 * @see RemoteBufferedOutputDirectory  
     * This method will write Bytes to the stream we are maintaining.  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.store;
    /**
 * @opensearch.internal
     *
import org.apache.lucene.store.DataInput;
    public long getFilePointer() {
        }
    private final OutputStreamIndexOutput indexOutputBuffer;  
 * in remote store. in the future, we can use it for other operations as well.
    // visible for testing
    /**
        this.indexOutputBuffer = indexOutputBuffer;  
     */
    }  
    }  
import java.io.IOException;  
    }  
import org.apache.lucene.store.OutputStreamIndexOutput;
    }  
    /**
    @Override  
        super(name, blobContainer);
import org.opensearch.common.io.stream.BytesStreamOutput;
     * data to blob container and close the output stream.
    // Visible for testing
    private final BytesStreamOutput out;
}
        return indexOutputBuffer.getChecksum();
 */  
     * This method will write a byte array to the stream we are maintaining.  
    public long getChecksum() throws IOException {
     *
            indexOutputBuffer.close();
    public void copyBytes(DataInput input, long numBytes) throws IOException {
    }  
    @Override  
    public RemoteBufferedIndexOutput(String name, BlobContainer blobContainer, int bufferSize) {
/*  
    /**
     * when we trigger close() to close the stream, we will first flush the buffer to output stream and then write all  
    /**
            blobContainer.writeBlob(getName(), stream, out.bytes().length(), false);  
        indexOutputBuffer.writeByte(b);
     */
 */  
 * TODO: extend the class to continously write to the store if content size in buffer gets higher than a specific size.
 * compatible open source license.
import org.opensearch.common.blobstore.BlobContainer;  
        return indexOutputBuffer.getFilePointer();
 * The current limitation of this is we keep all the file content in memory till we call close(),  
        indexOutputBuffer = new OutputStreamIndexOutput(name, name, out, bufferSize);
 * The OpenSearch Contributors require contributions made to  
     *
     * This method will return the file pointer to the current position in the stream.  
    }  
        super(name, blobContainer);
    public void writeBytes(byte[] byteArray, int offset, int length) throws IOException {
        this.out = out;
        this(name, blobContainer, BUFFER_SIZE);
     */  
 *
/**  
    @Override  
    }  
        indexOutputBuffer.writeBytes(byteArray, offset, length);
 * So this class should be used to write small files (in MBs).
        try (final BytesStreamOutput outStream = out; InputStream stream = out.bytes().streamInput()) {
    }
    RemoteBufferedIndexOutput(String name, BlobContainer blobContainer, BytesStreamOutput out, OutputStreamIndexOutput indexOutputBuffer) {  
