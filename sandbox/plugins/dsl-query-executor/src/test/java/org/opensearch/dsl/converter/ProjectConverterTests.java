        ConversionContext ctx = TestUtils.createContext(source);
import java.util.List;  
        List<String> fieldNames = result.getRowType().getFieldNames();  
    }  
        assertEquals(1, result.getRowType().getFieldCount());
        RelNode result = converter.convert(scan, ctx);
        assertTrue(result instanceof LogicalProject);
        ConversionContext ctx = TestUtils.createContext(source);
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(new FetchSourceContext(true, new String[] { "na*" }, null));  
        // Consistent with OpenSearch core — no error, just empty _source
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(new FetchSourceContext(true, new String[] {}, null));
    }  
 * compatible open source license.
        RelNode result = converter.convert(scan, ctx);  
    public void testProjectsSpecificFields() throws ConversionException {
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(new FetchSourceContext(false, null, null));
        assertTrue(result instanceof LogicalProject);
            new FetchSourceContext(true, new String[] { "name", "price" }, null)
        RelNode result = converter.convert(scan, ctx);  
    public void testExcludesWithWildcard() throws ConversionException {
        assertEquals(1, result.getRowType().getFieldCount());
    }
 *
        );
        RelNode result = converter.convert(scan, ctx);
import org.opensearch.test.OpenSearchTestCase;
    private final LogicalTableScan scan = TestUtils.createTestRelNode();
        assertSame(scan, result);
        assertEquals(1, result.getRowType().getFieldCount());
 * this file be licensed under the Apache-2.0 license or a
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(  
        assertFalse(fieldNames.contains("price"));  
        assertTrue(result instanceof LogicalProject);  
import org.opensearch.search.builder.SearchSourceBuilder;
    public void testWildcardNoMatchReturnsEmptyProjection() throws ConversionException {
}
        assertFalse(fieldNames.contains("rating"));
        RelNode result = converter.convert(scan, ctx);
        RelNode result = converter.convert(scan, ctx);  
        assertEquals("name", result.getRowType().getFieldNames().get(0));  
import org.opensearch.dsl.TestUtils;
    }
        );  
        assertTrue(result instanceof LogicalProject);  
        assertTrue(result instanceof LogicalProject);
        );
            new FetchSourceContext(true, null, new String[] { "price", "rating" })
        RelNode result = converter.convert(scan, ctx);
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(  
        expectThrows(ConversionException.class, () -> converter.convert(scan, ctx));
        ConversionContext ctx = TestUtils.createContext(source);  
 * The OpenSearch Contributors require contributions made to  
    public void testSkipsWhenNoSourceFiltering() throws ConversionException {
    }
        ConversionContext ctx = TestUtils.createContext(source);
 */  
            new FetchSourceContext(true, new String[] { "name", "name" }, null)
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
        assertEquals(0, result.getRowType().getFieldCount());  
            new FetchSourceContext(true, new String[] { "n*", "na*" }, null)
    }  
        RelNode result = converter.convert(scan, ctx);
        assertEquals(0, result.getRowType().getFieldCount());  
        assertTrue(result instanceof LogicalProject);
        );
 * SPDX-License-Identifier: Apache-2.0
        ConversionContext ctx = TestUtils.createContext(source);
            new FetchSourceContext(true, new String[] { "nonexistent" }, null)
    public void testThrowsForUnknownField() {
        ConversionContext ctx = TestUtils.createContext(source);
            new FetchSourceContext(true, new String[] { "*" }, new String[] { "rating" })  
        assertEquals(2, result.getRowType().getFieldCount());
        // Both "n*" and "na*" match "name" — should only appear once
public class ProjectConverterTests extends OpenSearchTestCase {
        ConversionContext ctx = TestUtils.createContext(new SearchSourceBuilder());
        assertSame(scan, result);
    }  
    }  
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(new FetchSourceContext(true, null, new String[] { "ra*" }));
        assertTrue(fieldNames.contains("brand"));
    private final ProjectConverter converter = new ProjectConverter();
        assertTrue(result instanceof LogicalProject);  
        assertTrue(result instanceof LogicalProject);  
        RelNode result = converter.convert(scan, ctx);
    public void testWildcardIncludesWithExcludes() throws ConversionException {  
        assertEquals("price", result.getRowType().getFieldNames().get(1));  
    }
        ConversionContext ctx = TestUtils.createContext(source);
import org.apache.calcite.rel.logical.LogicalProject;
package org.opensearch.dsl.converter;
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(  
    public void testEmptyProjectionWhenFetchSourceFalse() throws ConversionException {  
        );
        ConversionContext ctx = TestUtils.createContext(source);  
        ConversionContext ctx = TestUtils.createContext(source);  
        RelNode result = converter.convert(scan, ctx);
        assertEquals(17, result.getRowType().getFieldCount());
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(
    public void testReturnsUnchangedWhenIncludesEmpty() throws ConversionException {  
import org.apache.calcite.rel.logical.LogicalTableScan;  
        assertTrue(fieldNames.contains("name"));
    }
    public void testWildcardProjection() throws ConversionException {
/*  
        assertFalse(result.getRowType().getFieldNames().contains("rating"));
    public void testExcludesFields() throws ConversionException {  
        // Include all fields matching "*", exclude "rating"
        assertTrue(result instanceof LogicalProject);
        assertEquals("name", result.getRowType().getFieldNames().get(0));
        RelNode result = converter.convert(scan, ctx);  
        assertEquals(16, result.getRowType().getFieldCount());
        assertEquals("name", result.getRowType().getFieldNames().get(0));
import org.apache.calcite.rel.RelNode;
    public void testDuplicateExactFieldsProjectedOnce() throws ConversionException {
        assertFalse(result.getRowType().getFieldNames().contains("rating"));
        assertEquals(17, result.getRowType().getFieldCount());  
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(  
        ConversionContext ctx = TestUtils.createContext(source);  
    }  
    }
        assertEquals("name", result.getRowType().getFieldNames().get(0));
        ConversionContext ctx = TestUtils.createContext(source);  
        SearchSourceBuilder source = new SearchSourceBuilder().fetchSource(new FetchSourceContext(true, new String[] { "xyz*" }, null));  
    public void testOverlappingWildcardsDoNotProduceDuplicates() throws ConversionException {
        );
