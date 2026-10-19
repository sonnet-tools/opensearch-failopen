    default int priority() {  
import org.opensearch.common.annotation.ExperimentalApi;
import org.opensearch.index.query.QueryBuilder;
     */
 *
     * This allows control over rewrite ordering when multiple rewriters
/**
     * @return The priority value
     * Rewrites the given query builder to a more optimal form.  
package org.opensearch.search.query;
     * @param context The search execution context  
 * The OpenSearch Contributors require contributions made to  
    QueryBuilder rewrite(QueryBuilder query, QueryShardContext context);  
     * Returns the name of this rewriter for debugging and profiling.
 * before conversion to Lucene queries.
 * this file be licensed under the Apache-2.0 license or a
     */
    String name();  
 */  
 *
@ExperimentalApi
/*  
    /**
    /**
     * @return The rewritten query (may be the same instance if no rewrite needed)
 * SPDX-License-Identifier: Apache-2.0
 * @opensearch.experimental  
        return 1000;
     * may interact.
     *
     *  
    }
     */
 * Interface for query rewriting implementations that optimize query structure  
     * @param query The query to rewrite
     *  
public interface QueryRewriter {  
}
     * @return The rewriter name
     * Returns the priority of this rewriter. Lower values execute first.  
 */
 * compatible open source license.
import org.opensearch.index.query.QueryShardContext;  
    /**
