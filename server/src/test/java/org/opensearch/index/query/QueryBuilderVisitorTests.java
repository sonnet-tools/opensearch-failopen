    protected static QueryBuilderVisitor createTestVisitor(List<QueryBuilder> visitedQueries) {
 * compatible open source license.
import org.apache.lucene.search.BooleanClause;
 * SPDX-License-Identifier: Apache-2.0
        boolQueryBuilder.visit(qbv);
/*  
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
 * The OpenSearch Contributors require contributions made to  
        QueryBuilderVisitor qbv = createTestVisitor(visitedQueries);
import java.util.List;
        assertEquals(0, visitedQueries.size());
 * this file be licensed under the Apache-2.0 license or a
 */  
import java.util.ArrayList;
package org.opensearch.index.query;
        assertEquals(qbv, subQbv);
}
 *
        List<QueryBuilder> visitedQueries = new ArrayList<>();  
import org.opensearch.test.AbstractBuilderTestCase;
public class QueryBuilderVisitorTests extends AbstractBuilderTestCase {
    }
    public void testNoOpsVisitor() {  
        QueryBuilderVisitor subQbv = qbv.getChildVisitor(BooleanClause.Occur.MUST_NOT);  
        return QueryBuilderVisitor.NO_OP_VISITOR;  
    }  
