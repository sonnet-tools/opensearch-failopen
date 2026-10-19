    default CompletableFuture<IndexInput> asyncLoadIndexInput(Executor executor) {  
    /**
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
    boolean isClosed();  
     * @throws IOException if any I/O error occurs  
 */  
 * the implementations.  
     *  @return CompletableFuture of IndexInput  
 * SPDX-License-Identifier: Apache-2.0
    /**  
@PublicApi(since = "2.7.0")
 */  
     * Gets the {@link IndexInput} this cache entry represents.
     * @return The IndexInput
    @ExperimentalApi
import org.opensearch.common.annotation.PublicApi;  
import org.apache.lucene.store.IndexInput;
        return null;
     * @return true if the entry is closed, false otherwise
 *
import java.util.concurrent.CompletableFuture;  
     * @return length in bytes
/**  
import org.opensearch.common.annotation.ExperimentalApi;
    long length();
     */
 * @opensearch.api
package org.opensearch.index.store.remote.filecache;
    /**  
}
import java.util.concurrent.Executor;
public interface CachedIndexInput extends AutoCloseable {
import java.io.IOException;
     */
/*  
     */
 *
     */  
 * this file be licensed under the Apache-2.0 license or a
    }
 * {@link IndexInput}. Exactly how the IndexInput is created is determined by
    IndexInput getIndexInput() throws IOException;
 * Interface for an entry in the {@link FileCache} that can return an
     *  Trigger and get the completable future of index input
    /**
