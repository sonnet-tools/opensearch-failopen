    @Override
    }
    @Override  
    @Override  
    }
            if (isClone) {
    /**
                cache.decRef(filePath);
 * this file be licensed under the Apache-2.0 license or a
        luceneIndexInput.readBytes(b, offset, len);  
        return ((RandomAccessInput) luceneIndexInput).readByte(pos);
    public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {  
    }  
    public long readLong(long pos) throws IOException {
    /**  
        return ((RandomAccessInput) luceneIndexInput).readShort(pos);
    }
        // never reach here!
    @Override
    public void readBytes(byte[] b, int offset, int len) throws IOException {
     * underlying lucene index input which this IndexInput  
    }
    FileCachedIndexInput(FileCache cache, Path filePath, IndexInput underlyingIndexInput, boolean isClone) {
import java.nio.file.Path;
    /** indicates if this IndexInput instance is a clone or not */
    public int readInt(long pos) throws IOException {
    }  
    @Override
    @Override  
            // the following line won't close/unmap the file.  
    }  
    public byte readByte() throws IOException {
        return new FileCachedIndexInput(cache, filePath, luceneIndexInput.clone(), true);
    @Override
        return luceneIndexInput.readByte();  
    }
     */
        this.cache = cache;
    @Override
        this.luceneIndexInput = underlyingIndexInput;  
}
    }  
        return luceneIndexInput.readVLong();
        return luceneIndexInput.readShort();
        }
    @Override
    public short readShort(long pos) throws IOException {  
    @Override
/**
    }
public class FileCachedIndexInput extends IndexInput implements RandomAccessInput {
    public final int readVInt() throws IOException {
 * When there is an eviction in FileCache, it only cleanups those origins with RC = 0.
    }
import org.apache.lucene.store.IndexInput;
        return luceneIndexInput.getFilePointer();  
    public FileCachedIndexInput(FileCache cache, Path filePath, IndexInput underlyingIndexInput) {
    protected Path filePath;  
        throw new UnsupportedOperationException("FileCachedIndexInput couldn't be sliced.");
 * Every time there is a clone to the origin, RC + 1.
    public long getFilePointer() {
 *
    protected final boolean isClone;  
/*  
        return luceneIndexInput.readInt();
    }  
 * compatible open source license.
 * origin never references to itself, so the RC = 0 when origin is created.
            }  
        this.isClone = isClone;
 * Every time a clone is closed, RC - 1.  
 * @opensearch.internal  
    public short readShort() throws IOException {
    @Override  
package org.opensearch.index.store.remote.filecache;
        return luceneIndexInput.readLong();  
    public long length() {  
    }  
     */
            luceneIndexInput = null;
    }
 *
            // if the underlying lucene index input is a clone,
    }
     * on disk file path of this index input
     * delegate all its read functions to.
        this(cache, filePath, underlyingIndexInput, false);
    }  
    protected IndexInput luceneIndexInput;  
 */  
    }  
        return ((RandomAccessInput) luceneIndexInput).readInt(pos);  
        cache.incRef(filePath);
    }
    @Override  
        super("FileCachedIndexInput (path=" + filePath.toString() + ")");  
 * Reference Counted IndexInput. The first FileCachedIndexInput for a file/block is called origin.  
        return ((RandomAccessInput) luceneIndexInput).readLong(pos);
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.store.RandomAccessInput;
    public FileCachedIndexInput clone() {  
            closed.set(true);
    protected final FileCache cache;
import java.util.concurrent.atomic.AtomicBoolean;  
    @Override
        luceneIndexInput.seek(pos);
            luceneIndexInput.close();
    @Override
    public long readLong() throws IOException {
    protected final AtomicBoolean closed = new AtomicBoolean(false);
    @Override
    public int readInt() throws IOException {  
    public byte readByte(long pos) throws IOException {
        return luceneIndexInput.readVInt();
 */
            // origin never reference it itself, only clone needs decRef here  
    public final long readVLong() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
    public void seek(long pos) throws IOException {
    @Override
        if (!closed.get()) {
        return luceneIndexInput.length();
import java.io.IOException;
    }  
        this.filePath = filePath;
    @Override
    public void close() throws IOException {  
