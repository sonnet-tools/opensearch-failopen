 * The OpenSearch Contributors require contributions made to  
    Optional<QueryCollectorContextSpec> createQueryCollectorContextSpec(
    ) throws IOException;  
package org.opensearch.search.query;
     * @throws IOException  
     * @param searchContext context needed to create collector context spec
import org.opensearch.common.annotation.ExperimentalApi;
     * @return QueryCollectorContextSpec
/*  
    /**
 *  interface of QueryCollectorContext spec factory  
 * this file be licensed under the Apache-2.0 license or a
public interface QueryCollectorContextSpecFactory {  
/**
     * @param queryCollectorArguments arguments to create collector context spec
 * SPDX-License-Identifier: Apache-2.0
import java.io.IOException;
        QueryCollectorArguments queryCollectorArguments
 */
import org.apache.lucene.search.Query;
        SearchContext searchContext,  
 */  
        Query query,
     * @param query required to create collector context spec  
import org.opensearch.search.internal.SearchContext;  
 *
@ExperimentalApi
     */
}
import java.util.Optional;  
 * compatible open source license.
