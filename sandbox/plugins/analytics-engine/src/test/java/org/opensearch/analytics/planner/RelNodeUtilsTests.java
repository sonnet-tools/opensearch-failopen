    public void testSortOverFilterOverScan() {  
            .build();
        assertTrue("Should contain index2", java.util.Arrays.asList(result).contains("index2"));
        for (String idx : result) {
import org.apache.calcite.schema.SchemaPlus;  
            .join(JoinRelType.LEFT, b.literal(true))
            .project(b.field("id"), b.field("name"))
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();  
        public RelDataType getRowType(RelDataTypeFactory typeFactory) {
/**
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            );  
        return RelBuilder.create(Frameworks.newConfigBuilder().defaultSchema(schema).build());  
            return typeFactory.builder().add("id", SqlTypeName.INTEGER).add("name", SqlTypeName.VARCHAR).build();  
    public void testJoinExtractsBothIndices() {  
        RelNode plan = b.scan("events").filter(b.literal(true)).sort(b.field("id")).build();
        RelNode plan = b.scan("customers").scan("orders").join(JoinRelType.INNER, b.literal(true)).build();
        // The plan exceeds MAX_EXTRACT_INDICES_DEPTH — should throw rather than silently skip  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.tools.RelBuilder;
        String[] result = RelNodeUtils.extractIndices(plan);
        assertArrayEquals(new String[] { "index_a", "index_b" }, RelNodeUtils.extractIndices(plan));  
    public void testDoubleCommaProducesEmptyStringFiltered() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> RelNodeUtils.extractIndices(deepPlan));
    public void testSingleTableScan() {  
    }
    private RelBuilder builderWithTable(String tableName) {
        schema.add("logs_2023", new MockTable());
        }  
import org.apache.calcite.rel.core.JoinRelType;  
    }
        RelNode plan = b.scan("my_index")
import org.apache.calcite.schema.impl.AbstractTable;
                rex.makeInputRef(node.getRowType().getFieldList().get(0).getType(), 0),
        for (String idx : result) {
    }
public class RelNodeUtilsTests extends OpenSearchTestCase {
    // --- Multi-index comma-separated table name tests (FGAC bypass fix) ---  
    public void testDoubleLeadingComma() {  
    }
        RelNode plan = b.scan("customers").scan("orders").join(JoinRelType.INNER, b.literal(true)).build();
    public void testTrailingComma() {
        assertTrue("Should contain index1", java.util.Arrays.asList(result).contains("index1"));
    }  
        schema.add(tableName, new MockTable());
    public void testSingleIndexNoComma() {
        RelNode plan = b.scan("orders").project(b.field("id")).build();
            .build();  
        RelBuilder b = builderWithTable("logs-2024-01,secrets-2024-01");  
        RelNode plan = b.scan("my_index").build();
        assertArrayEquals(new String[] { "customers", "orders" }, RelNodeUtils.extractIndices(plan));  
        // Wrap in LogicalFilter nodes directly to avoid RelBuilder optimizations.
        assertArrayEquals(new String[] { "events" }, RelNodeUtils.extractIndices(plan));  
        assertEquals("my_index", RelNodeUtils.findTableName(plan));
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
        RelBuilder b = builder();
import org.opensearch.test.OpenSearchTestCase;  
    private RelBuilder builder() {  
                SqlStdOperatorTable.GREATER_THAN,  
import static org.opensearch.analytics.planner.RelNodeUtils.MAX_EXTRACT_INDICES_DEPTH;
    public void testFindTableNameOnUnionReturnsFirstTable() {  
        assertTrue("Should contain index1", java.util.Arrays.asList(result).contains("index1"));
 *
            .project(b.field("id"), b.field("name"))
    /** Minimal table implementation for RelBuilder schema registration. */
package org.opensearch.analytics.planner;
    private static class MockTable extends AbstractTable {  
import org.apache.calcite.rel.logical.LogicalFilter;
        schema.add("index_b", new MockTable());
            .scan("my_index")  
        RelBuilder b = builder();
            .build();
        RelBuilder b = builder();  
    }
import org.apache.calcite.rel.RelNode;
    }  
 */  
    public void testFindTableNameOnSingleScan() {
            .scan("logs_2024")
        RelNode plan = b.scan("index_a")  
        assertArrayEquals(new String[] { "logs_2023", "logs_2024" }, RelNodeUtils.extractIndices(plan));
        assertEquals("customers", RelNodeUtils.findTableName(plan));  
        RelNode plan = b.scan("metrics").aggregate(b.groupKey("id"), b.count(false, "cnt")).build();
            .scan("logs_2024")
        schema.add("events", new MockTable());
    public void testUnionExtractsBothIndices() {  
    public void testCommaDelimitedIndicesSplit() {
        RelNode plan = b.scan("plain_index").build();
            assertFalse("Should not contain empty string", idx.isEmpty());
        RelBuilder b = builder();
            .project(b.field("id"), b.field("name"))
            .sort(b.field(0))
    public void testComplexJoinWithAggregate() {
            node = LogicalFilter.create(node, condition);
        schema.add("metrics", new MockTable());  
        assertArrayEquals(new String[] { "a", "b", "c" }, RelNodeUtils.extractIndices(plan));
            assertFalse("Should not contain empty string", idx.isEmpty());
            assertFalse("Should not contain empty string", idx.isEmpty());  
        assertArrayEquals(new String[] { "metrics" }, RelNodeUtils.extractIndices(plan));  
            .scan("index_b")
        RelNode plan = b.scan("my_index").filter(b.literal(true)).build();
        }  
        RelNode deepPlan = node;
    }
    public void testAggregateOverScan() {  
        }
    }  
        RelNode plan = b.scan("logs_2023")
        RelBuilder b = builder();
 * Unit tests for {@link RelNodeUtils#extractIndices(RelNode)}.
        RelBuilder b = builder();
import org.apache.calcite.sql.type.SqlTypeName;  
            RexBuilder rex = node.getCluster().getRexBuilder();
        RelBuilder b = builderWithTable("index1,");
    }  
        assertArrayEquals(new String[] { "my_index" }, RelNodeUtils.extractIndices(plan));  
import org.apache.calcite.jdbc.CalciteSchema;
    public void testProjectOverScan() {  
        schema.add("my_index", new MockTable());
        RelBuilder b = builder();
    }  
            .build();
    }
        assertArrayEquals(new String[] { "plain_index" }, RelNodeUtils.extractIndices(plan));
    }
    }  
 */  
        RelNode plan = b.scan("index1,,index2").build();
        schema.add("customers", new MockTable());
        RelBuilder b = builderWithTable("index1,,index2");  
        RelBuilder b = builder();  
        RelBuilder b = builder();
    }
        schema.add("deep_index", new MockTable());
}  
 * compatible open source license.
        @Override
/*  
        RelBuilder b = builderWithTable("plain_index");  
                rex.makeZeroLiteral(node.getRowType().getFieldList().get(0).getType())
        RelNode plan = b.scan("a,b,c").build();
    public void testCommaDelimitedThreeIndices() {
        assertTrue("Should contain index1", java.util.Arrays.asList(result).contains("index1"));  
        }
        RelNode plan = b.scan(",index1").build();
        RelBuilder b = builderWithTable(",index1");  
    }
        assertTrue("Should contain index1", java.util.Arrays.asList(result).contains("index1"));
        RelNode plan = b.scan("logs_2023")
    public void testDepthGuardThrowsOnExcessiveDepth() {
        }
    }  
 * SPDX-License-Identifier: Apache-2.0
        assertArrayEquals(new String[] { "orders" }, RelNodeUtils.extractIndices(plan));  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(e.getMessage().contains("maximum depth"));  
        for (int i = 0; i < MAX_EXTRACT_INDICES_DEPTH + 5; i++) {  
        schema.add("index_a", new MockTable());  
            .aggregate(b.groupKey(0), b.count(false, "cnt"))  
    public void testLeadingComma() {
        }
    }  
        assertArrayEquals(new String[] { "logs-2024-01", "secrets-2024-01" }, RelNodeUtils.extractIndices(plan));
        schema.add("logs_2024", new MockTable());
        schema.add("orders", new MockTable());  
        String[] result = RelNodeUtils.extractIndices(plan);  
            .project(b.field("id"), b.field("name"))
        assertArrayEquals(new String[] { "my_index" }, RelNodeUtils.extractIndices(plan));
        return RelBuilder.create(Frameworks.newConfigBuilder().defaultSchema(schema).build());
    public void testFindTableNameOnJoinReturnsFirstTable() {  
    }
        RelBuilder b = builder();  
            .union(true)  
        RelBuilder b = builder();
            RexNode condition = rex.makeCall(
        RelNode plan = b.scan(",,index1").build();
        RelNode node = b.scan("deep_index").build();
import org.apache.calcite.rel.type.RelDataType;
        String[] result = RelNodeUtils.extractIndices(plan);  
        assertEquals("logs_2023", RelNodeUtils.findTableName(plan));
        RelBuilder b = builderWithTable(",,index1");
        RelNode plan = b.scan("index1,").build();  
    }
        RelNode plan = b.scan("logs-2024-01,secrets-2024-01").build();
        for (String idx : result) {
            .union(true)
        RelBuilder b = builder();
import org.apache.calcite.rex.RexNode;
        RelBuilder b = builderWithTable("a,b,c");  
    public void testDeduplicatesRepeatedIndex() {
            .union(true)  
            assertFalse("Should not contain empty string", idx.isEmpty());
import org.apache.calcite.tools.Frameworks;
            .project(b.field("id"), b.field("name"))  
    }
    }  
        String[] result = RelNodeUtils.extractIndices(plan);
import org.apache.calcite.rex.RexBuilder;
        // Strings.splitStringByCommaToArray trims and skips empty tokens
        for (String idx : result) {  
            .project(b.field("id"), b.field("name"))  
 * The OpenSearch Contributors require contributions made to  
