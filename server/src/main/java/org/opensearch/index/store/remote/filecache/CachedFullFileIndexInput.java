    public void close() throws Exception {
        if (isClosed.get()) throw new AlreadyClosedException("Index input is already closed");
/*  
 */  
     * Checks if the wrapped indexInput is closed  
    private final Path path;
     * Constructor - takes IndexInput as parameter  
    }  
    @Override
            fullFileCachedIndexInput.close();
     * Returns the wrapped indexInput
}
import org.apache.lucene.store.AlreadyClosedException;
        this.fileCache = fileCache;  
    private final AtomicBoolean isClosed;  
 * compatible open source license.
        fullFileCachedIndexInput = new FullFileCachedIndexInput(fileCache, path, indexInput);
 * SPDX-License-Identifier: Apache-2.0
    /**
@ExperimentalApi
public class CachedFullFileIndexInput implements CachedIndexInput {
     */  
    public long length() {
        return fullFileCachedIndexInput.length();
        return fullFileCachedIndexInput;  
        }
     * Closes the wrapped indexInput
    @Override  
    }
    private final FullFileCachedIndexInput fullFileCachedIndexInput;
    /**  
/**
        isClosed = new AtomicBoolean(false);  
    public boolean isClosed() {  
package org.opensearch.index.store.remote.filecache;
 *
    @Override
     */
    /**
import org.opensearch.common.annotation.ExperimentalApi;  
import org.apache.lucene.store.IndexInput;
    }
    public CachedFullFileIndexInput(FileCache fileCache, Path path, IndexInput indexInput) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.concurrent.atomic.AtomicBoolean;  
    }
 * @opensearch.experimental
    @Override  
     */
        this.path = path;
    private final FileCache fileCache;  
    /**
     */
 */  
 * Implementation of the CachedIndexInput for full files which takes in an IndexInput as parameter  
     * Returns the length of the wrapped indexInput
        if (!isClosed.getAndSet(true)) {  
    /**  
 *
    public IndexInput getIndexInput() {
        return isClosed.get();
import java.nio.file.Path;
    }  
 * The OpenSearch Contributors require contributions made to  
     */
