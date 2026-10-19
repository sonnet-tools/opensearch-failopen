    private final IntraSegmentSearchDecider decider;
 * this file be licensed under the Apache-2.0 license or a
    public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
import org.opensearch.index.query.QueryBuilderVisitor;  
    @Override
    public IntraSegmentSearchVisitor(IntraSegmentSearchDecider decider) {
        return this;  
 * SPDX-License-Identifier: Apache-2.0
    }
}
        this.decider = decider;
    }
/*  
package org.opensearch.search.deciders;
        decider.evaluateForQuery(qb);
 */
 */  
    @Override
    public void accept(QueryBuilder qb) {  
import org.opensearch.index.query.QueryBuilder;
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.search.BooleanClause;
    }  
 *
/**
 * for each query node.
 * Visitor to traverse QueryBuilder tree and invoke IntraSegmentSearchDecider  
public class IntraSegmentSearchVisitor implements QueryBuilderVisitor {  
