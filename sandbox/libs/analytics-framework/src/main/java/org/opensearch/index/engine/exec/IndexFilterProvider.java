    void releaseCollector(C context, int collectorKey);  
import org.opensearch.common.annotation.ExperimentalApi;
    int collectDocs(C context, int collectorKey, int minDoc, int maxDoc, MemorySegment out);
 * @param <ReaderT> the engine-specific reader type  
 * @param <C>       the context type
    int createCollector(C context, int segmentOrd, int minDoc, int maxDoc);
}
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
import java.lang.foreign.MemorySegment;
/*  
import java.io.Closeable;  
 * The OpenSearch Contributors require contributions made to  
 */
package org.opensearch.index.engine.exec;
public interface IndexFilterProvider<Q, C extends IndexFilterContext, ReaderT> extends Closeable {
 *  
/**
@ExperimentalApi  
import java.io.IOException;
 *
 * @param <Q>       the query type (e.g. Lucene Query)
 * Provides index-level filtering (partition pruning, segment filtering) for a given data format.
 * SPDX-License-Identifier: Apache-2.0
 */  
 * @opensearch.experimental
    C createContext(Q query, ReaderT reader) throws IOException;  
