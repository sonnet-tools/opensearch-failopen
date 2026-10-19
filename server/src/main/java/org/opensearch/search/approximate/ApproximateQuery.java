 * SPDX-License-Identifier: Apache-2.0
/**
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.search.approximate;
 * compatible open source license.
public abstract class ApproximateQuery extends Query {
}
/*  
*/  
 *
    protected abstract boolean canApproximate(SearchContext context);  
 * The OpenSearch Contributors require contributions made to  
 * Abstract class that can be inherited by queries that can be approximated. Queries should implement {@link #canApproximate(SearchContext)} to specify conditions on when they can be approximated
import org.apache.lucene.search.Query;
import org.opensearch.search.internal.SearchContext;
 */  
