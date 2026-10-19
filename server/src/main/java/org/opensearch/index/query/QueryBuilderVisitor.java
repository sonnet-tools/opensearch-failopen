public interface QueryBuilderVisitor {
 * this file be licensed under the Apache-2.0 license or a
     *  NoopQueryVisitor is a default implementation of QueryBuilderVisitor.
        @Override  
            return this;
     * @return a child queryBuilder Visitor Object.  
     */
 * SPDX-License-Identifier: Apache-2.0
}  
 * compatible open source license.
        @Override
     *  When a user does not want to implement QueryBuilderVisitor and have to just pass an empty object then this class will be used.  
 * The OpenSearch Contributors require contributions made to  
@PublicApi(since = "2.11.0")  
     * Fetches the child sub visitor from the main QueryBuilderVisitor Object.
     */  
package org.opensearch.index.query;
import org.apache.lucene.search.BooleanClause;
    /**  
    /**  
        }  
 */
/*  
 *
     */
 *  
    QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur);
 * QueryBuilderVisitor is an interface to define Visitor Object to be traversed in QueryBuilder tree.
    };
 * @opensearch.api
    /**
            // Do nothing  
     *
     * @param occur defines the occurrence of the result fetched from the search query in the final search result.
    QueryBuilderVisitor NO_OP_VISITOR = new QueryBuilderVisitor() {  
    void accept(QueryBuilder qb);
        }
/**
import org.opensearch.common.annotation.PublicApi;
        public void accept(QueryBuilder qb) {
        public QueryBuilderVisitor getChildVisitor(BooleanClause.Occur occur) {
     * Accept method is called when the visitor accepts the queryBuilder object to be traversed in the query tree.
     * @param qb is a queryBuilder object which is accepeted by the visitor.
 */  
