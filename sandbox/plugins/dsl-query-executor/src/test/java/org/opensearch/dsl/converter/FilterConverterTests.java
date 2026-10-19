        assertTrue(call.getOperands().get(0) instanceof RexInputRef);  
package org.opensearch.dsl.converter;
        RexCall call = (RexCall) filter.getCondition();
import org.apache.calcite.rex.RexInputRef;
        assertSame(scan, result);
import org.opensearch.dsl.TestUtils;
        RelNode result = converter.convert(scan, ctx);
        LogicalFilter filter = (LogicalFilter) result;  
import org.apache.calcite.sql.SqlKind;  
public class FilterConverterTests extends OpenSearchTestCase {
 *
        RelNode result = converter.convert(scan, ctx);
import org.opensearch.index.query.QueryBuilders;  
    private final FilterConverter converter = new FilterConverter(QueryRegistryFactory.create());  
        ConversionContext ctx = TestUtils.createContext(source);  
        ConversionContext ctx = TestUtils.createContext(source);  
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.rel.logical.LogicalFilter;
        // Condition should be: name = 'laptop'
import org.apache.calcite.rel.logical.LogicalTableScan;  
        assertTrue(result instanceof LogicalFilter);
    public void testSkipsWhenNoQuery() throws ConversionException {  
        RelNode result = converter.convert(scan, ctx);
    public void testFilterPreservesRowType() throws ConversionException {
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.rel.RelNode;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        assertEquals(2, call.getOperands().size());
        SearchSourceBuilder source = new SearchSourceBuilder().query(QueryBuilders.termQuery("name", "laptop"));
        // Left operand: field reference to 'name' (index 0)
    }
        assertTrue(filter.getCondition() instanceof RexCall);  
        SearchSourceBuilder source = new SearchSourceBuilder().query(QueryBuilders.regexpQuery("name", "lap.*"));
    }
        SearchSourceBuilder source = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        assertEquals(0, ((RexInputRef) call.getOperands().get(0)).getIndex());
        assertSame(scan, filter.getInput());  
import org.opensearch.search.builder.SearchSourceBuilder;
 */  
        SearchSourceBuilder source = new SearchSourceBuilder().query(QueryBuilders.termQuery("brand", "acme"));
        RelNode result = converter.convert(scan, ctx);
        // Filter doesn't change the row type — same fields as the scan  
    private final LogicalTableScan scan = TestUtils.createTestRelNode();
    public void testTermQueryProducesLogicalFilter() throws ConversionException {  
    }
import org.apache.calcite.rex.RexCall;
    public void testUnsupportedQueryProducesFilterWithUnresolvedCondition() throws ConversionException {
/*  
        ConversionContext ctx = TestUtils.createContext(source);  
        RelNode result = converter.convert(scan, ctx);  
        assertTrue(filter.getCondition() instanceof org.opensearch.dsl.query.UnresolvedQueryCall);  
        // Input should be the original scan
        LogicalFilter filter = (LogicalFilter) result;
        assertSame(scan, result);  
import org.opensearch.dsl.query.QueryRegistryFactory;
        ConversionContext ctx = TestUtils.createContext(source);
        assertEquals(SqlKind.EQUALS, call.getKind());
        // Unsupported query types produce a LogicalFilter with an UnresolvedQueryCall condition  
        assertEquals(scan.getRowType(), result.getRowType());
        assertTrue(result instanceof LogicalFilter);
}
        ConversionContext ctx = TestUtils.createContext(new SearchSourceBuilder());
    public void testSkipsMatchAll() throws ConversionException {
    }
    }
 * SPDX-License-Identifier: Apache-2.0
