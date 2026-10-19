     */  
            this.indexInput = indexInput;
    }  
}  
            }
        private final FileCache cache;
                    + length
 * The OpenSearch Contributors require contributions made to  
    public FullFileCachedIndexInput(FileCache cache, Path filePath, IndexInput underlyingIndexInput, boolean isClone) {
    /**
        super(cache, filePath, underlyingIndexInput, isClone);  
/**
            this.cache = cache;
 * Extension of {@link FileCachedIndexInput} for full files for handling clones and slices
     * Closes the index input and it's clones as well
    }  
     * Increase the ref count whenever the index input is sliced and add it to the clone map as well  
                if (!closed.get()) {
        return clonedIndexInput;
    public void close() throws IOException {
            );
                logger.trace("FullFileCachedIndexInput already closed");  
            try {
        indexInputHolder = new IndexInputHolder(closed, underlyingIndexInput, isClone, cache, filePath);
                    indexInput.close();  
    public FullFileCachedIndexInput clone() {
    }  
            this.path = path;
                    + ",length="
            this.closed = closed;
            }  
    }
        if (offset < 0 || length < 0 || offset + length > this.length()) {
                    + sliceDescription
            throw new IllegalArgumentException(
@ExperimentalApi
 * Since Lucene does not guarantee that it will close the clones/slices, we have created a Cleaner which handles closing of the clones/slices when they become phantom reachable  
     * Increase the ref count whenever the index input is cloned and add it to the clone map as well
                    + ": "
        }
        FullFileCachedIndexInput slicedIndexInput = new FullFileCachedIndexInput(cache, filePath, slicedLuceneIndexInput, true);
        CLEANER.register(this, indexInputHolder);
        private final IndexInput indexInput;
        public void run() {  
                    + offset  
        cache.incRef(filePath);  
     * Run resource cleaning，To be used only in test
            this.isClone = isClone;  
            } catch (AlreadyClosedException e) {
        private final Path path;
    private static final Logger logger = LogManager.getLogger(FullFileCachedIndexInput.class);  
    }
    /**
                    if (isClone) cache.decRef(path);
        IndexInput slicedLuceneIndexInput = luceneIndexInput.slice(sliceDescription, offset, length);  
        }  
        indexInputHolder.run();
        }
import java.lang.ref.Cleaner;  
/*  
     * Clones the index input and returns the slice
                logger.error("Failed to close IndexInput while clearing phantom reachable object");
 * https://github.com/apache/lucene/blob/8340b01c3cc229f33584ce2178b07b8984daa6a9/lucene/core/src/java/org/apache/lucene/store/IndexInput.java#L32-L33
    @Override  
    }
                "slice() "  
import java.util.concurrent.atomic.AtomicBoolean;
     * Clones the index input and returns the clone  
 * @opensearch.experimental
        cache.incRef(filePath);
                }  
    @Override  
                    + this  
                    + this.length()
            } catch (IOException e) {
    /**  
            try {  
        FullFileCachedIndexInput clonedIndexInput = new FullFileCachedIndexInput(cache, filePath, luceneIndexInput.clone(), true);
     */
            luceneIndexInput = null;
            closed.set(true);  
    private static class IndexInputHolder implements Runnable {
        if (!closed.get()) {
import org.apache.lucene.store.IndexInput;
                cache.decRef(filePath);
import org.apache.lucene.store.AlreadyClosedException;  
                    + ",fileLength="  
import org.apache.logging.log4j.LogManager;
        private final boolean isClone;  
        return slicedIndexInput;  
    }
     */
                    + " out of bounds: offset="
    private static final Cleaner CLEANER = Cleaner.create(OpenSearchExecutors.daemonThreadFactory("index-input-cleaner"));
    /**
        }
 *
        this(cache, filePath, underlyingIndexInput, false);
import org.apache.logging.log4j.Logger;
import java.io.IOException;
 * compatible open source license.
        @Override
import org.opensearch.common.util.concurrent.OpenSearchExecutors;  
    private final IndexInputHolder indexInputHolder;
        IndexInputHolder(AtomicBoolean closed, IndexInput indexInput, boolean isClone, FileCache cache, Path path) {  
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.store.remote.filecache;
            if (isClone) {  
                luceneIndexInput.close();
public class FullFileCachedIndexInput extends FileCachedIndexInput {
import java.nio.file.Path;
            }
    public FullFileCachedIndexInput(FileCache cache, Path filePath, IndexInput underlyingIndexInput) {
 * this file be licensed under the Apache-2.0 license or a
        private final AtomicBoolean closed;  
     */
 */  
import org.opensearch.common.annotation.ExperimentalApi;
                    closed.set(true);
    @Override
    public void indexInputHolderRun() {
 */  
    public IndexInput slice(String sliceDescription, long offset, long length) throws IOException {  
