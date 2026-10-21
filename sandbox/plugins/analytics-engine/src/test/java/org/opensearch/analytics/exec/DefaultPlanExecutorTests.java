        return out;
    }
        child.close();
        assertEquals(2, rows.get(1)[0]);
        assertTrue(
    }
     * values transpose.
    public void testBatchesToRowsMultipleColumns() {
        assertArrayEquals(new Object[] { 10 }, rows.get(0));
import java.util.ArrayList;
/**
        assertEquals(200L, rows.get(1)[0]);
    private VectorSchemaRoot makeAgeNameBatch(long age, String name) {
        VectorSchemaRoot batch = VectorSchemaRoot.create(
        assertEquals(1, rows.get(0)[0]);
    }
        super.setUp();
        BufferAllocator child = allocator.newChildAllocator("test", 0, Long.MAX_VALUE);
        VectorSchemaRoot batch = VectorSchemaRoot.create(
import org.apache.arrow.vector.types.pojo.Field;
    }
        assertEquals("batch buffers should be released after batchesToRows", 0, child.getAllocatedMemory());
     * The coordinator's Arrow batch can present columns in physical/scan order (e.g. a
 * <p>The end-to-end {@code execute(RelNode, Object)} path involves Guice-wired
        ids.setSafe(0, 100L);
        allocator.close();
package org.opensearch.analytics.exec;
        assertEquals("bob", rows.get(1)[1]);
     * the integration layer (it requires Guice-wired ClusterService / Scheduler).
    private BufferAllocator allocator;
 * this file be licensed under the Apache-2.0 license or a
        VectorSchemaRoot batch = makeAgeNameBatch(20L, "hello");  // physical order: [age, name]
        IntVector vec = (IntVector) batch.getVector(0);
import org.apache.arrow.vector.VectorSchemaRoot;
        assertTrue("batch should hold allocated memory", before > 0);
        VarCharVector vec = (VarCharVector) batch.getVector(0);
        assertEquals(5, rows.size());
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch1, batch2, batch3)));
        vec.setSafe(0, 1);
        assertTrue(
     * join/aggregate dispatch. {@code DefaultPlanExecutor.executeInternal} reads it via
        expectThrows(IllegalStateException.class, () -> DefaultPlanExecutor.batchesToRows(List.of(batch), List.of("name", "nonexistent")));
            out.add(iter.next());
 * These unit tests cover the one deterministic piece of behavior that lives
        assertEquals(100L, rows.get(0)[0]);
        );
        allocator = new RootAllocator();
        );
     * {@code clusterService.getClusterSettings().get(...)} and routes any non-COORDINATOR_CENTRIC
            allocator
        assertTrue(rows.get(0)[0] instanceof String);
     * key, default, and dynamic property — the gate's actual dispatch effect is verified at
    private VectorSchemaRoot makeIntBatch(BufferAllocator alloc, String fieldName, int... values) {
            org.opensearch.analytics.AnalyticsSettings.ALL_SETTINGS.contains(org.opensearch.analytics.AnalyticsSettings.MPP_ENABLED)
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch), List.of("name", "age")));
        // single registration point. If a future setting is added without including it in the
        assertEquals(4, rows.get(3)[0]);
    public void testBatchesToRowsClosesBatches() {
        vec.setSafe(0, "hello".getBytes(StandardCharsets.UTF_8));
 * compatible open source license.
        vec.setSafe(1, "world".getBytes(StandardCharsets.UTF_8));
        Schema schema = new Schema(
        vsr.setRowCount(1);
    // ── helpers ──────────────────────────────────────────────────────────
        long before = child.getAllocatedMemory();
    }
    }
    /**
        vsr.setRowCount(values.length);
import org.apache.arrow.vector.BigIntVector;
        assertEquals(2, rows.size());
    }
        assertNull(rows.get(1)[0]);
    }
    public void testBatchesToRowsHandlesNulls() {
    // ---- MPP kill switch ----
import org.opensearch.test.OpenSearchTestCase;
        VectorSchemaRoot batch2 = makeIntBatch("x", 3);
        return vsr;
 * Tests for {@link DefaultPlanExecutor}'s row-materialization boundary.
        VectorSchemaRoot batch = VectorSchemaRoot.create(schema, allocator);
        assertEquals("alice", rows.get(0)[1]);
import java.util.Iterator;
     * Silent fallback would let a misaligned plan return wrong-but-shape-valid rows, which
        batch.setRowCount(2);
/*
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch)));
        Field nameField = new Field("name", FieldType.nullable(new ArrowType.Utf8()), null);
                new Field("id", FieldType.nullable(new ArrowType.Int(64, true)), null),
import org.apache.arrow.vector.IntVector;
    /** Two-column batch with vectors in physical order [age (BigInt), name (VarChar)]. */
            s.getDefault(org.opensearch.common.settings.Settings.EMPTY)
    }
    private static <T> List<T> toList(Iterable<T> it) {
        vsr.allocateNew();
        ((BigIntVector) vsr.getVector("age")).setSafe(0, age);
import java.nio.charset.StandardCharsets;
    public void setUp() throws Exception {
        );
        Schema schema = new Schema(List.of(ageField, nameField));
        );
                new Field("name", FieldType.nullable(ArrowType.Utf8.INSTANCE), null)
        Iterable<Object[]> rows = DefaultPlanExecutor.batchesToRows(List.of());
 *
        batch.allocateNew();
     */
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch)));
import org.apache.arrow.vector.types.pojo.ArrowType;
 * in this class: batches-to-rows conversion at the external API edge.
     * strategy through the M0 path when it's {@code false}. This test pins the setting's
    }
        for (int i = 0; i < values.length; i++) {
        assertEquals(3, rows.get(2)[0]);
     */
    }
        org.opensearch.common.settings.Setting<Boolean> s = org.opensearch.analytics.AnalyticsSettings.MPP_ENABLED;
        // AnalyticsPlugin.getSettings() returns AnalyticsSettings.ALL_SETTINGS — that's the
        Field field = new Field(fieldName, FieldType.nullable(new ArrowType.Int(32, true)), null);
        ((VarCharVector) vsr.getVector("name")).setSafe(0, name.getBytes(StandardCharsets.UTF_8));
        return vsr;
        VectorSchemaRoot batch = makeIntBatch("x", 10, 20, 30);
     * is harder to diagnose than a fast failure. If the upstream caller wants tolerance,
        vec.setSafe(2, 3);
 * dependencies (TransportService, Scheduler, TaskManager, CapabilityRegistry,
        assertTrue("must be dynamic so operators can flip without restart", s.isDynamic());
}
            "must have NodeScope so it applies cluster-wide via cluster settings",
        vsr.allocateNew();
        return makeIntBatch(allocator, fieldName, values);
import org.apache.arrow.memory.BufferAllocator;
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch)));
            "ALL_SETTINGS must include MPP_ENABLED",
        VectorSchemaRoot batch = makeIntBatch(child, "x", 1, 2);
import org.apache.arrow.vector.types.pojo.Schema;
    @Override
import org.apache.arrow.vector.types.pojo.FieldType;
    }
 *
    }
        assertEquals(3, rows.get(2)[0]);
        VectorSchemaRoot batch3 = makeIntBatch("x", 4, 5);
    public void testMppEnabledSettingShape() {
        List<T> out = new ArrayList<>();
    public void testBatchesToRowsThrowsWhenTargetNameMissing() {
    public void testBatchesToRowsEmpty() {
import org.apache.arrow.memory.RootAllocator;
        assertArrayEquals(new Object[] { 20 }, rows.get(1));
        while (iter.hasNext())
     * no-projection scan over a dynamically-mapped index comes back alphabetically [age, name]).
        ids.setSafe(1, 200L);
    public void tearDown() throws Exception {
    public void testBatchesToRowsReordersToTargetColumnOrder() {
        assertArrayEquals(new Object[] { 30 }, rows.get(2));
 */
    @Override
    public void testBatchesToRowsSingleBatchIntegers() {
        Iterator<T> iter = it.iterator();
        Field ageField = new Field("age", FieldType.nullable(new ArrowType.Int(64, true)), null);
    }
        batch.setRowCount(3);
 * EngineContextProvider, NodeClient) and is exercised by internal cluster tests.
            vec.setSafe(i, values[i]);
            allocator
        IntVector vec = (IntVector) vsr.getVector(0);
     * The {@code analytics.mpp.enabled} setting is the operator-facing master switch for MPP
        assertFalse(
     * consumer (SQL frontend) names each value correctly. Without this, name/age (or name/alias)
    private VectorSchemaRoot makeIntBatch(String fieldName, int... values) {
        super.tearDown();
        VectorSchemaRoot batch1 = makeIntBatch("x", 1, 2);
        assertEquals(3, rows.size());
        assertEquals(1, rows.size());
        batch.setRowCount(2);
    public void testBatchesToRowsMultipleBatchesPreservesOrder() {
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch)));
     * {@code orderedColumns} throws rather than dropping the column or substituting null.
import org.apache.arrow.vector.VarCharVector;
        assertFalse("no batches → no rows", rows.iterator().hasNext());
 * The OpenSearch Contributors require contributions made to
            )
        assertEquals("analytics.mpp.enabled", s.getKey());
        assertEquals(1, rows.get(0)[0]);
        batch.allocateNew();
 */
            s.getProperties().contains(org.opensearch.common.settings.Setting.Property.NodeScope)
        DefaultPlanExecutor.batchesToRows(List.of(batch));
    /**
    }
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("hello", rows.get(0)[0]);
        assertEquals("world", rows.get(1)[0]);
        );
    }
            "MPP disabled by default in production — operators opt in (QA clusters enable it explicitly)",
        VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, alloc);
    public void testBatchesToRowsVarCharDecodedAsString() {
        assertEquals(5, rows.get(4)[0]);
        VarCharVector names = (VarCharVector) batch.getVector(1);
        names.setSafe(1, "bob".getBytes(StandardCharsets.UTF_8));
     * batchesToRows must reorder to the plan's declared column order [name, age] so a positional
     * Contract: an unknown target column name is a planner/executor invariant violation —
            List.of(
        assertEquals(3, rows.size());
    public void testAnalyticsSettingsAllSettingsContainsMppEnabled() {
     */
        );
public class DefaultPlanExecutorTests extends OpenSearchTestCase {
    }
    /**
        Schema schema = new Schema(List.of(field));
        VectorSchemaRoot batch = makeAgeNameBatch(20L, "hello");  // [age, name]
        batch.allocateNew();
        // list, this test catches the omission for MPP_ENABLED specifically.
     * it must filter target names before invoking {@code batchesToRows}.
        names.setSafe(0, "alice".getBytes(StandardCharsets.UTF_8));
import java.util.List;
        }
        BigIntVector ids = (BigIntVector) batch.getVector(0);
            new Schema(List.of(new Field("s", FieldType.nullable(ArrowType.Utf8.INSTANCE), null))),
        VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, allocator);
            new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(32, true)), null))),
        vec.setNull(1);
        assertArrayEquals("columns must be reordered to [name, age]", new Object[] { "hello", 20L }, rows.get(0));
