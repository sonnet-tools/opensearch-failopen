        }
        }
 */
    }
        RelBuilder b = builderWithTable("plain_index");
        assertEquals("logs_2023", RelNodeUtils.findTableName(plan));
        RelNode plan = b.scan("customers").scan("orders").join(JoinRelType.INNER, b.literal(true)).build();
        }
    public void testAggregateOverScan() {
        RelBuilder b = builder();
        assertTrue("Should contain index1", java.util.Arrays.asList(result).contains("index1"));
        assertArrayEquals(new String[] { "orders" }, RelNodeUtils.extractIndices(plan));
            .aggregate(b.groupKey(0), b.count(false, "cnt"))
        public RelDataType getRowType(RelDataTypeFactory typeFactory) {
        schema.add("metrics", new MockTable());
        RelBuilder b = builderWithTable("index1,");
            .project(b.field("id"), b.field("name"))
    public void testDeduplicatesRepeatedIndex() {
        assertArrayEquals(new String[] { "index_a", "index_b" }, RelNodeUtils.extractIndices(plan));
package org.opensearch.analytics.planner;
        RelNode plan = b.scan("logs_2023")
    public void testDepthGuardThrowsOnExcessiveDepth() {
            .union(true)
    }
    }
 */
    public void testFindTableNameOnJoinReturnsFirstTable() {
 * The OpenSearch Contributors require contributions made to
        RelNode plan = b.scan("a,b,c").build();
    public void testDoubleCommaProducesEmptyStringFiltered() {
    }
        assertTrue("Should contain index1", java.util.Arrays.asList(result).contains("index1"));
    }
        String[] result = RelNodeUtils.extractIndices(plan);
        RelBuilder b = builder();
        // The plan exceeds MAX_EXTRACT_INDICES_DEPTH — should throw rather than silently skip
        assertEquals("my_index", RelNodeUtils.findTableName(plan));
import org.apache.calcite.rex.RexBuilder;
    public void testLeadingComma() {
/**
import org.apache.calcite.rel.core.JoinRelType;
    }
            assertFalse("Should not contain empty string", idx.isEmpty());
        RelNode plan = b.scan(",,index1").build();
import org.apache.calcite.jdbc.CalciteSchema;
            .union(true)
    public void testSingleTableScan() {
        RelBuilder b = builderWithTable("index1,,index2");
        // Strings.splitStringByCommaToArray trims and skips empty tokens
    public void testCommaDelimitedThreeIndices() {
        RelBuilder b = builder();
    public void testJoinExtractsBothIndices() {
        // Wrap in LogicalFilter nodes directly to avoid RelBuilder optimizations.
/*
            .sort(b.field(0))
        RelNode plan = b.scan("index_a")
    }
            RexNode condition = rex.makeCall(
    public void testSortOverFilterOverScan() {
            .join(JoinRelType.LEFT, b.literal(true))
import org.apache.calcite.rel.type.RelDataTypeFactory;
                rex.makeInputRef(node.getRowType().getFieldList().get(0).getType(), 0),
            .project(b.field("id"), b.field("name"))
        for (String idx : result) {
    }
    }
import org.apache.calcite.tools.RelBuilder;
    }
        schema.add("logs_2024", new MockTable());
        assertArrayEquals(new String[] { "metrics" }, RelNodeUtils.extractIndices(plan));
}
import org.apache.calcite.rex.RexNode;
            .build();
        schema.add("events", new MockTable());
        assertArrayEquals(new String[] { "logs_2023", "logs_2024" }, RelNodeUtils.extractIndices(plan));
        for (String idx : result) {
        return RelBuilder.create(Frameworks.newConfigBuilder().defaultSchema(schema).build());
        RelBuilder b = builder();
 * Unit tests for {@link RelNodeUtils#extractIndices(RelNode)}.
        assertEquals("customers", RelNodeUtils.findTableName(plan));
        String[] result = RelNodeUtils.extractIndices(plan);
        schema.add("index_a", new MockTable());
        assertTrue("Should contain index1", java.util.Arrays.asList(result).contains("index1"));
            .scan("logs_2024")
            .build();
        assertTrue("Should contain index1", java.util.Arrays.asList(result).contains("index1"));
        RelBuilder b = builder();
            .project(b.field("id"), b.field("name"))
import org.apache.calcite.rel.logical.LogicalFilter;
        schema.add("logs_2023", new MockTable());
        RelNode plan = b.scan("customers").scan("orders").join(JoinRelType.INNER, b.literal(true)).build();
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        schema.add("orders", new MockTable());
        }
 * compatible open source license.
            assertFalse("Should not contain empty string", idx.isEmpty());
        assertArrayEquals(new String[] { "events" }, RelNodeUtils.extractIndices(plan));
                SqlStdOperatorTable.GREATER_THAN,
        assertTrue(e.getMessage().contains("maximum depth"));
    public void testCommaDelimitedIndicesSplit() {
        schema.add("deep_index", new MockTable());
            assertFalse("Should not contain empty string", idx.isEmpty());
import org.apache.calcite.tools.Frameworks;
        RelBuilder b = builder();
    // --- Multi-index comma-separated table name tests (FGAC bypass fix) ---
                rex.makeZeroLiteral(node.getRowType().getFieldList().get(0).getType())
        for (String idx : result) {
            .project(b.field("id"), b.field("name"))
    }
            .scan("index_b")
        assertArrayEquals(new String[] { "customers", "orders" }, RelNodeUtils.extractIndices(plan));
        }
    public void testUnionExtractsBothIndices() {
        String[] result = RelNodeUtils.extractIndices(plan);
import org.apache.calcite.schema.SchemaPlus;
    /** Minimal table implementation for RelBuilder schema registration. */
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> RelNodeUtils.extractIndices(deepPlan));
    }
    public void testProjectOverScan() {
        RelNode plan = b.scan(",index1").build();
public class RelNodeUtilsTests extends OpenSearchTestCase {
    }
            .scan("logs_2024")
        RelNode plan = b.scan("plain_index").build();
            RexBuilder rex = node.getCluster().getRexBuilder();
    }
import org.apache.calcite.sql.type.SqlTypeName;
        RelBuilder b = builderWithTable("logs-2024-01,secrets-2024-01");
        assertArrayEquals(new String[] { "logs-2024-01", "secrets-2024-01" }, RelNodeUtils.extractIndices(plan));
        RelBuilder b = builder();
            return typeFactory.builder().add("id", SqlTypeName.INTEGER).add("name", SqlTypeName.VARCHAR).build();
        RelBuilder b = builderWithTable(",,index1");
    }
        RelNode deepPlan = node;
        RelNode node = b.scan("deep_index").build();
        RelNode plan = b.scan("my_index")
        RelNode plan = b.scan("logs-2024-01,secrets-2024-01").build();
        for (int i = 0; i < MAX_EXTRACT_INDICES_DEPTH + 5; i++) {
    public void testComplexJoinWithAggregate() {
            .build();
    public void testDoubleLeadingComma() {
    private RelBuilder builderWithTable(String tableName) {
        assertArrayEquals(new String[] { "my_index" }, RelNodeUtils.extractIndices(plan));
    public void testFindTableNameOnUnionReturnsFirstTable() {
        return RelBuilder.create(Frameworks.newConfigBuilder().defaultSchema(schema).build());
    }
    }
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
        schema.add("my_index", new MockTable());
import org.apache.calcite.rel.type.RelDataType;
        RelNode plan = b.scan("index1,").build();
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("Should contain index2", java.util.Arrays.asList(result).contains("index2"));
        assertArrayEquals(new String[] { "plain_index" }, RelNodeUtils.extractIndices(plan));
        String[] result = RelNodeUtils.extractIndices(plan);
        @Override
        schema.add(tableName, new MockTable());
        RelBuilder b = builder();
import org.apache.calcite.schema.impl.AbstractTable;
    }
import org.opensearch.test.OpenSearchTestCase;
        for (String idx : result) {
        RelBuilder b = builder();
    }
        RelNode plan = b.scan("my_index").filter(b.literal(true)).build();
        RelNode plan = b.scan("orders").project(b.field("id")).build();
        RelNode plan = b.scan("my_index").build();
 *
    public void testFindTableNameOnSingleScan() {
            );
        }
        RelNode plan = b.scan("events").filter(b.literal(true)).sort(b.field("id")).build();
            .project(b.field("id"), b.field("name"))
        assertArrayEquals(new String[] { "a", "b", "c" }, RelNodeUtils.extractIndices(plan));
        RelBuilder b = builderWithTable("a,b,c");
            .project(b.field("id"), b.field("name"))
        schema.add("customers", new MockTable());
 * SPDX-License-Identifier: Apache-2.0
    }
    }
        RelNode plan = b.scan("logs_2023")
        RelBuilder b = builder();
    private static class MockTable extends AbstractTable {
        RelBuilder b = builder();
    }
            .scan("my_index")
            .build();
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
        schema.add("index_b", new MockTable());
        assertArrayEquals(new String[] { "my_index" }, RelNodeUtils.extractIndices(plan));
import static org.opensearch.analytics.planner.RelNodeUtils.MAX_EXTRACT_INDICES_DEPTH;
import org.apache.calcite.rel.RelNode;
    public void testTrailingComma() {
    private RelBuilder builder() {
        RelNode plan = b.scan("index1,,index2").build();
        RelBuilder b = builder();
        RelBuilder b = builderWithTable(",index1");
            node = LogicalFilter.create(node, condition);
    public void testSingleIndexNoComma() {
            .union(true)
        RelNode plan = b.scan("metrics").aggregate(b.groupKey("id"), b.count(false, "cnt")).build();
            assertFalse("Should not contain empty string", idx.isEmpty());
