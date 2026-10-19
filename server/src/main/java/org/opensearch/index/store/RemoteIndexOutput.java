        blobContainer.writeBlob(getName(), new InputStreamIndexInput((IndexInput) input, numBytes), numBytes, false);
    public void close() throws IOException {  
    public void writeBytes(byte[] byteArray, int offset, int length) throws IOException {
     *
package org.opensearch.index.store;
        throw new UnsupportedOperationException();  
import org.apache.lucene.store.IndexOutput;  
    public void copyBytes(DataInput input, long numBytes) throws IOException {
    public long getChecksum() throws IOException {
 */  
     *  
    @Override  
    }
     */
     */
/*  
}
 * Class for output to a file in a {@link RemoteDirectory}. Used for all output operations to the remote store.
    public void writeByte(byte b) throws IOException {
     * Guaranteed to throw an exception and leave the RemoteIndexOutput unmodified.
 * compatible open source license.
     */
        assert input instanceof IndexInput : "input should be instance of IndexInput";  
     * This method is not implemented as it is not used for the file transfer to/from the remote store.
 * ToDo: Extend ChecksumIndexInput
    @Override
        throw new UnsupportedOperationException();
 * @see RemoteDirectory  
 */  
     * This method is not implemented as it is not directly used for the file transfer to/from the remote store.  
        super(name, name);  
     * @throws UnsupportedOperationException always
     * Guaranteed to throw an exception and leave the RemoteIndexOutput unmodified.
    @Override
     * But the checksum is important to verify integrity of the data and that means implementing this method will
    /**
 * implemented. Remaining methods will be implemented as we open up remote store for other use cases like replication,  
    /**
public class RemoteIndexOutput extends IndexOutput {
 * Currently, only methods from {@link IndexOutput} that are required for uploading a segment file to remote store are
     * Guaranteed to throw an exception and leave the RemoteIndexOutput unmodified.  
     * be required for the segment upload as well.
    protected final BlobContainer blobContainer;  
     *
        throw new UnsupportedOperationException();
    }  
import org.apache.lucene.store.DataInput;
import org.apache.lucene.store.IndexInput;
    public RemoteIndexOutput(String name, BlobContainer blobContainer) {
    }
 * The OpenSearch Contributors require contributions made to  
    }
 *
    @Override  
     */
     * This method is not implemented as it is not used for the file transfer to/from the remote store.  
        throw new UnsupportedOperationException();
import java.io.IOException;
     * @throws UnsupportedOperationException always
    /**
    /**  
import org.opensearch.common.lucene.store.InputStreamIndexInput;
    }
    /**
 * this file be licensed under the Apache-2.0 license or a
     * This method is not implemented as it is not used for the file transfer to/from the remote store.
    }  
 * peer recovery etc.
     * This is a no-op. Once segment file upload to the remote store is complete, we don't need to explicitly close
     *  
 *
    @Override
/**  
    public long getFilePointer() {  
        this.blobContainer = blobContainer;
 * @opensearch.internal
import org.opensearch.common.blobstore.BlobContainer;
        // do nothing
     */  
     * @throws UnsupportedOperationException always
 * SPDX-License-Identifier: Apache-2.0
    }
     * Guaranteed to throw an exception and leave the RemoteIndexOutput unmodified.
    @Override
     * the stream. It is taken care by internal APIs of client of the remote store.  
     * @throws UnsupportedOperationException always  
