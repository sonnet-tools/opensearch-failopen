     * Returns an iterator over the record batches in this stream.
 * Callers iterate batches via the returned iterator and MUST close the stream
import java.util.Iterator;
     * Each call returns the same iterator instance — the stream is single-pass.
    void close();
 * when done to release native resources.  
 *
}
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
    @Override  
    Iterator<EngineResultBatch> iterator();
 * SPDX-License-Identifier: Apache-2.0
 */  
package org.opensearch.analytics.backend;
    /**  
 * compatible open source license.
 * A closeable stream of record batches returned by engine execution.
 *
/*  
     */  
/**  
 */  
public interface EngineResultStream extends AutoCloseable {
 * @opensearch.internal
