    private OffsetRangeRefCount getStreamReference() {
        private final InputStreamIndexInput inputStreamIndexInput;
        // file. Check on closed in this class makes sure that no other stream allows subsequent reads. closed is
        this.indexInput = indexInput;
                try {
    }  
        return inputStreamIndexInput.markSupported();
 */
     * Construct a new OffsetRangeIndexInputStream object
        // 1. First check is a coarse-grained check outside reference check which allows us to fail fast if read  
    }  
        private final IndexInput indexInput;
 * The OpenSearch Contributors require contributions made to  
    }
        }
        // was invoked after the stream was closed. We need a separate atomic boolean closed because we don't want a
    }
        offsetRangeRefCount = new OffsetRangeRefCount(closingStreams);
        try (OffsetRangeRefCount ignored = getStreamReference()) {  
import java.io.IOException;  
        // failed. In successful case, subsequent read will anyway not go through since all streams would have been
        this.inputStreamIndexInput = new InputStreamIndexInput(indexInput, size);  
    public boolean markSupported() {  
        // hold reference and since ref count will not be 0 even after close was invoked, future reads will go through  
    public synchronized void reset() throws IOException {
        ensureReadable();
    }
    private final OffsetRangeRefCount offsetRangeRefCount;
            this.inputStreamIndexInput = inputStreamIndexInput;
    @Override  
import org.apache.lucene.store.IndexInput;
 *
    @Override  
            });
        // consumed fully but in case of failure, SDK can continue to invoke read and this would be a wasted compute  
    @Override  
        return new AlreadyClosedException(msg + this);  
        // All these protection mechanisms are required in order to prevent invalid access to streams happening  
import org.apache.logging.log4j.Logger;
 *
    AlreadyClosedException alreadyClosed(String msg) {
    }  
    }  
        // Ref counting ensures that stream isn't closed in between reads.
    @Override
     * @param position Position from where read needs to start  
        // 2. In second check, a tryIncRef is invoked which tries to increment reference under lock and fails if ref
     * @param size The maximum length to read from specified <code>position</code>
    private AtomicBoolean readBlock;  
    @Override
                    logger.error("Failed to close indexInput", ex);
}  
import org.apache.lucene.store.AlreadyClosedException;  
        }
import org.opensearch.common.concurrent.RefCountedReleasable;
        if (readBlock != null && readBlock.get() == true) {
    }
            return inputStreamIndexInput.read(b, off, len);
                    ref.inputStreamIndexInput.close();
 * OffsetRangeIndexInputStream extends InputStream to read from a specified offset using IndexInput
    public int read(byte[] b, int off, int len) throws IOException {  
    public void close() throws IOException {  
    private static final Logger logger = LogManager.getLogger(OffsetRangeIndexInputStream.class);  
        inputStreamIndexInput.reset();
        if (successIncrement == false) {
    public void setReadBlock(AtomicBoolean readBlock) {
        closeOnce.run();
    public long getFilePointer() throws IOException {  
                    logger.error("Failed to close indexStreamIndexInput", ex);  
        //
    private final RunOnce closeOnce;
 * this file be licensed under the Apache-2.0 license or a
    }  
package org.opensearch.common.blobstore.transfer.stream;
        this.readBlock = readBlock;
            this.indexInput = indexInput;  
    public int read() throws IOException {
    }
     */
        // is already closed. If reference is successfully obtained by the stream then stream will not be closed.  
    public synchronized void mark(int readlimit) {
        return "OffsetRangeIndexInputStream{" + "indexInput=" + indexInput + ", readBlock=" + readBlock + '}';  
import org.opensearch.common.lucene.store.InputStreamIndexInput;  
        // being set to true in RemoteTransferContainer#close which is invoked when we are done processing all  
 */  
    private void ensureReadable() {
    @Override
     *  
     * @param indexInput IndexInput opened on the file to read from
        try (OffsetRangeRefCount ignored = getStreamReference()) {  
                } catch (IOException ex) {
    @Override
    @Override
        // to not close the stream if it is already being read.
        closeOnce = new RunOnce(offsetRangeRefCount::decRef);  
 * compatible open source license.
                }
    }
    /**
    }
/**  
        // from the new S3 async SDK.
        }
                } catch (IOException ex) {
        return indexInput.getFilePointer();
        ClosingStreams closingStreams = new ClosingStreams(inputStreamIndexInput, indexInput);
import org.apache.logging.log4j.LogManager;
    }
 * @opensearch.internal  
    private final InputStreamIndexInput inputStreamIndexInput;
        // and IO.
                try {  
                    ref.indexInput.close();  
        }  
            return inputStreamIndexInput.read();
            throw alreadyClosed("Read blocked stream.");
 * SPDX-License-Identifier: Apache-2.0
            throw alreadyClosed("OffsetRangeIndexInputStream is already unreferenced.");
        // parts/file. Processing completes when either all parts are completed successfully or if either of the parts
        public ClosingStreams(InputStreamIndexInput inputStreamIndexInput, IndexInput indexInput) {
     * @throws IOException When <code>IndexInput#seek</code> operation fails
            super("OffsetRangeRefCount", ref, () -> {
        public OffsetRangeRefCount(ClosingStreams ref) {
        // There are two levels of check to ensure that we don't read an already closed stream and
    }
        ensureReadable();
        private static final Logger logger = LogManager.getLogger(OffsetRangeRefCount.class);
import java.util.concurrent.atomic.AtomicBoolean;
/*  
        // future read to succeed when #close has been invoked even if there are on-going reads. On-going reads would
    private static class ClosingStreams {  
        }
        inputStreamIndexInput.mark(readlimit);  
    private static class OffsetRangeRefCount extends RefCountedReleasable<ClosingStreams> {
        boolean successIncrement = offsetRangeRefCount.tryIncRef();  
    }  
            logger.debug("Read attempted on a stream which was read blocked!");  
import org.opensearch.common.util.concurrent.RunOnce;
    private final IndexInput indexInput;
                }  
        }
        return offsetRangeRefCount;
        // without a check on closed. Also, we do need to set closed externally. It is shared across all streams of the
    public String toString() {
    @Override
public class OffsetRangeIndexInputStream extends OffsetRangeInputStream {
    public OffsetRangeIndexInputStream(IndexInput indexInput, long size, long position) throws IOException {  
        indexInput.seek(position);
