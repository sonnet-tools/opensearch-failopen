        ConversionContext ctx = TestUtils.createContext(source);
        RelCollation collation = sort.getCollation();  
}
 * SPDX-License-Identifier: Apache-2.0
    public void testSortAscending() throws ConversionException {  
        LogicalSort sort = (LogicalSort) result;  
        assertEquals(10, RexLiteral.intValue(sort.offset));  
        SearchSourceBuilder source = new SearchSourceBuilder().from(10).size(5);
    }
        assertEquals(1, collation.getFieldCollations().size());
import org.apache.calcite.rel.RelFieldCollation;
    }
import org.apache.calcite.rel.logical.LogicalSort;
        SearchSourceBuilder source = new SearchSourceBuilder().sort("nonexistent", SortOrder.ASC);
import org.opensearch.dsl.TestUtils;
import org.opensearch.test.OpenSearchTestCase;
public class SortConverterTests extends OpenSearchTestCase {
        RelFieldCollation fieldCollation = collation.getFieldCollations().get(0);  
 *
        assertEquals(2, sort.getCollation().getFieldCollations().get(0).getFieldIndex()); // brand
        LogicalSort sort = (LogicalSort) result;
        ConversionContext ctx = TestUtils.createContext(new SearchSourceBuilder());
import org.apache.calcite.rel.RelNode;  
    }
        assertNotNull(sort.offset);
import org.opensearch.search.sort.SortOrder;
 * The OpenSearch Contributors require contributions made to  
/*  
        assertNull(sort.offset); // from defaults to 0 → no offset
        expectThrows(ConversionException.class, () -> converter.convert(scan, ctx));
        LogicalSort sort = (LogicalSort) result;
        RelNode result = converter.convert(scan, ctx);
        SearchSourceBuilder source = new SearchSourceBuilder().sort("name", SortOrder.ASC);
    public void testThrowsForUnknownSortField() {
        LogicalSort sort = (LogicalSort) result;  
        SearchSourceBuilder source = new SearchSourceBuilder().size(5);  
    }  
    public void testSortDescending() throws ConversionException {
import org.apache.calcite.rel.logical.LogicalTableScan;
    }  
    public void testCustomSize() throws ConversionException {
        assertEquals(SearchService.DEFAULT_SIZE, RexLiteral.intValue(sort.fetch));
        ConversionContext ctx = TestUtils.createContext(source);
        assertNotNull(sort.fetch);  
        RelFieldCollation fieldCollation = sort.getCollation().getFieldCollations().get(0);  
        RelNode result = converter.convert(scan, ctx);
        assertTrue(result instanceof LogicalSort);  
        assertNull(sort.offset);
        assertNotNull(sort.fetch);
 */  
        ConversionContext ctx = TestUtils.createContext(source);  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(RelFieldCollation.Direction.DESCENDING, fieldCollation.getDirection());
        RelNode result = converter.convert(scan, ctx);  
        RelNode result = converter.convert(scan, ctx);
        assertEquals(0, fieldCollation.getFieldIndex()); // name is index 0
import org.apache.calcite.rex.RexLiteral;  
package org.opensearch.dsl.converter;
        assertEquals(RelFieldCollation.Direction.ASCENDING, fieldCollation.getDirection());
        LogicalSort sort = (LogicalSort) result;
        assertEquals(RelFieldCollation.NullDirection.LAST, fieldCollation.nullDirection);  
    }
        SearchSourceBuilder source = new SearchSourceBuilder().sort("brand", SortOrder.ASC).sort("price", SortOrder.DESC);
 * compatible open source license.
        assertEquals(1, fieldCollation.getFieldIndex()); // price is index 1
        assertEquals(5, RexLiteral.intValue(sort.fetch));
        RelNode result = converter.convert(scan, ctx);  
    /** Even default pagination must emit fetch: without it no LIMIT reaches the engine. */  
    }
        RelNode result = converter.convert(scan, ctx);  
        assertTrue(result instanceof LogicalSort);
import org.opensearch.search.SearchService;
        assertEquals(RelFieldCollation.NullDirection.FIRST, fieldCollation.nullDirection);  
        assertTrue(sort.getCollation().getFieldCollations().isEmpty());
        ConversionContext ctx = TestUtils.createContext(source);  
        assertEquals(5, RexLiteral.intValue(sort.fetch));
        ConversionContext ctx = TestUtils.createContext(source);  
        assertEquals(1, sort.getCollation().getFieldCollations().get(1).getFieldIndex()); // price
    private final SortConverter converter = new SortConverter();  
        assertEquals(2, sort.getCollation().getFieldCollations().size());  
    public void testDefaultPaginationEmitsDefaultFetch() throws ConversionException {
        LogicalSort sort = (LogicalSort) result;
import org.apache.calcite.rel.RelCollation;
    public void testMultipleSortFields() throws ConversionException {  
import org.opensearch.search.builder.SearchSourceBuilder;  
        SearchSourceBuilder source = new SearchSourceBuilder().sort("price", SortOrder.DESC);
    public void testFromAndSize() throws ConversionException {
        assertNotNull(sort.fetch);  
        ConversionContext ctx = TestUtils.createContext(source);
    private final LogicalTableScan scan = TestUtils.createTestRelNode();
