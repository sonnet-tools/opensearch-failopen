    }
 * compatible open source license.
        // term query translates to an EQUALS call
        RexNode result = registry.convert(QueryBuilders.termQuery("name", "laptop"), ctx);
    public void testUnknownQueryTypeReturnsUnresolved() throws ConversionException {
        assertTrue(empty.convert(QueryBuilders.matchAllQuery(), ctx) instanceof UnresolvedQueryCall);
 * this file be licensed under the Apache-2.0 license or a
    public void testResolvesTermQuery() throws ConversionException {
import org.apache.calcite.rex.RexNode;  
        // match_all translates to boolean TRUE literal  
        UnresolvedQueryCall unresolved = (UnresolvedQueryCall) result;  
    private final QueryRegistry registry = QueryRegistryFactory.create();
import org.opensearch.dsl.converter.ConversionContext;  
public class QueryRegistryTests extends OpenSearchTestCase {
import org.apache.calcite.rex.RexCall;
 * SPDX-License-Identifier: Apache-2.0
 *
        QueryRegistry empty = new QueryRegistry();
 */  
    }
    private final ConversionContext ctx = TestUtils.createContext();
        assertTrue(result instanceof UnresolvedQueryCall);
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.sql.SqlKind;
import org.opensearch.dsl.TestUtils;
    }  
        RexNode result = registry.convert(QueryBuilders.regexpQuery("name", "lap.*"), ctx);  
import org.opensearch.dsl.converter.ConversionException;
/*  
    public void testEmptyRegistryReturnsUnresolvedForAnyQuery() throws ConversionException {
package org.opensearch.dsl.query;
import org.opensearch.test.OpenSearchTestCase;  
    }  
        RexNode result = registry.convert(QueryBuilders.matchAllQuery(), ctx);
        assertTrue(RexLiteral.booleanValue(result));
        assertTrue(result instanceof RexCall);
    public void testResolvesMatchAllQuery() throws ConversionException {  
import org.opensearch.index.query.QueryBuilders;
import org.apache.calcite.rex.RexLiteral;
        assertTrue(empty.convert(QueryBuilders.termQuery("name", "laptop"), ctx) instanceof UnresolvedQueryCall);
        assertTrue(unresolved.getQueryBuilder() instanceof org.opensearch.index.query.RegexpQueryBuilder);
        assertEquals(SqlKind.EQUALS, (result).getKind());  
        assertTrue(result instanceof RexLiteral);
}
