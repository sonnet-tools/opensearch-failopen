 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.query.QueryBuilderVisitor;
 * Class to traverse the QueryBuilder tree and invoke the
import java.util.Objects;
import org.opensearch.index.IndexSettings;  
        // for each of the deciders, invoke evaluateForQuery using the current query builder and index settings.
 * compatible open source license.
package org.opensearch.search.deciders;
    private final IndexSettings indexSettings;  
@ExperimentalApi
/*  
    }  
        Objects.requireNonNull(concurrentSearchVisitorDeciders, "Concurrent search deciders cannot be null");  
    }
/**
    public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {  
        return this;
}  
        deciders = concurrentSearchVisitorDeciders;
import org.opensearch.index.query.QueryBuilder;
import java.util.Set;
    @Override
    }  
    public ConcurrentSearchVisitor(Set<ConcurrentSearchRequestDecider> concurrentSearchVisitorDeciders, IndexSettings idxSettings) {
import org.opensearch.common.annotation.ExperimentalApi;
    public void accept(QueryBuilder qb) {  
    @Override
 */
import org.apache.lucene.search.BooleanClause;
 * SPDX-License-Identifier: Apache-2.0
 *
 * this file be licensed under the Apache-2.0 license or a
 * {@link ConcurrentSearchRequestDecider#evaluateForQuery} at each node of the query tree  
 */  
    private final Set<ConcurrentSearchRequestDecider> deciders;
public class ConcurrentSearchVisitor implements QueryBuilderVisitor {  
        indexSettings = idxSettings;
        deciders.forEach(concurrentSearchDecider -> { concurrentSearchDecider.evaluateForQuery(qb, indexSettings); });
