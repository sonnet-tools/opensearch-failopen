/*  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.index.engine.exec;
 * execute queries against its reader. The searcher is acquired from
import org.opensearch.search.SearchExecutionContext;  
 */
 * the search execution engine and used to execute searches against a  
 *
 */  
 * Engine-agnostic searcher interface.
 * compatible open source license.
/**
@ExperimentalApi  
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.common.lease.Releasable;
import java.io.IOException;
     */
 * <p>  
    /**  
 * Each engine implementation provides its own searcher that knows how to
 * The OpenSearch Contributors require contributions made to  
}
 * @opensearch.experimental
     * Execute a search using this searcher, populating results on the context.
 * point-in-time snapshot.
 * @param <C> the context type this searcher operates on  
    void search(C context) throws IOException;  
 * SPDX-License-Identifier: Apache-2.0
public interface EngineSearcher<C extends SearchExecutionContext> extends Releasable {
 *
