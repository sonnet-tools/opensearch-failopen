        assertEquals(3, rows.get(2)[0]);  
        long before = child.getAllocatedMemory();
    public void tearDown() throws Exception {
     * join/aggregate dispatch. {@code DefaultPlanExecutor.executeInternal} reads it via
import org.apache.arrow.vector.IntVector;
/**  
        assertTrue(
        Schema schema = new Schema(
 * <p>The end-to-end {@code execute(RelNode, Object)} path involves Guice-wired  
 * compatible open source license.
        // single registration point. If a future setting is added without including it in the
        assertEquals("analytics.mpp.enabled", s.getKey());  
        );
        assertEquals(3, rows.size());  
        assertEquals(2, rows.get(1)[0]);
    }
     * the integration layer (it requires Guice-wired ClusterService / Scheduler).
    private VectorSchemaRoot makeAgeNameBatch(long age, String name) {
    @Override
        VectorSchemaRoot batch = VectorSchemaRoot.create(schema, allocator);
import org.apache.arrow.vector.types.pojo.ArrowType;
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch)));
 * The OpenSearch Contributors require contributions made to  
        vec.setSafe(2, 3);
        assertEquals(100L, rows.get(0)[0]);
}  
                new Field("id", FieldType.nullable(new ArrowType.Int(64, true)), null),
import java.util.List;
    }
        super.tearDown();
     */  
        );
    public void testBatchesToRowsEmpty() {
        Field field = new Field(fieldName, FieldType.nullable(new ArrowType.Int(32, true)), null);
    public void testBatchesToRowsMultipleBatchesPreservesOrder() {  
        IntVector vec = (IntVector) vsr.getVector(0);
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch1, batch2, batch3)));
        BufferAllocator child = allocator.newChildAllocator("test", 0, Long.MAX_VALUE);  
 * Tests for {@link DefaultPlanExecutor}'s row-materialization boundary.
    }
     */  
    public void testBatchesToRowsReordersToTargetColumnOrder() {
            )  
    public void testBatchesToRowsVarCharDecodedAsString() {  
        vec.setSafe(0, 1);  
        assertEquals("bob", rows.get(1)[1]);
        ids.setSafe(1, 200L);
        batch.allocateNew();
 * in this class: batches-to-rows conversion at the external API edge.
        vec.setSafe(1, "world".getBytes(StandardCharsets.UTF_8));
import org.apache.arrow.memory.RootAllocator;
        );
        assertTrue("must be dynamic so operators can flip without restart", s.isDynamic());
     * consumer (SQL frontend) names each value correctly. Without this, name/age (or name/alias)
        batch.allocateNew();  
        );  
import org.opensearch.test.OpenSearchTestCase;
        assertEquals("hello", rows.get(0)[0]);  
import org.apache.arrow.vector.VarCharVector;
import org.apache.arrow.vector.types.pojo.FieldType;  
        assertEquals(3, rows.size());  
        assertArrayEquals(new Object[] { 10 }, rows.get(0));
        VectorSchemaRoot batch = makeAgeNameBatch(20L, "hello");  // [age, name]
        assertArrayEquals(new Object[] { 20 }, rows.get(1));
        VectorSchemaRoot batch = makeIntBatch("x", 10, 20, 30);
    }
        vec.setSafe(0, "hello".getBytes(StandardCharsets.UTF_8));
import org.apache.arrow.memory.BufferAllocator;
 */  
        assertEquals("batch buffers should be released after batchesToRows", 0, child.getAllocatedMemory());
        vsr.setRowCount(1);
        return vsr;
            allocator
        org.opensearch.common.settings.Setting<Boolean> s = org.opensearch.analytics.AnalyticsSettings.MPP_ENABLED;
        Iterator<T> iter = it.iterator();  
        vsr.allocateNew();
        Field nameField = new Field("name", FieldType.nullable(new ArrowType.Utf8()), null);
            new Schema(List.of(new Field("x", FieldType.nullable(new ArrowType.Int(32, true)), null))),
            "must have NodeScope so it applies cluster-wide via cluster settings",
    @Override
    public void testMppEnabledSettingShape() {
        );
import org.apache.arrow.vector.VectorSchemaRoot;  
        assertEquals("world", rows.get(1)[0]);
        allocator.close();  
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch)));
        VectorSchemaRoot batch1 = makeIntBatch("x", 1, 2);
        assertNull(rows.get(1)[0]);
     * Contract: an unknown target column name is a planner/executor invariant violation —  
            "ALL_SETTINGS must include MPP_ENABLED",
 * EngineContextProvider, NodeClient) and is exercised by internal cluster tests.
        VectorSchemaRoot batch = VectorSchemaRoot.create(  
     * batchesToRows must reorder to the plan's declared column order [name, age] so a positional  
        assertEquals(5, rows.get(4)[0]);
        return makeIntBatch(allocator, fieldName, values);  
    /**  
        vsr.setRowCount(values.length);  
        vec.setNull(1);
        VectorSchemaRoot batch = makeIntBatch(child, "x", 1, 2);
        batch.setRowCount(3);  
    }
        Iterable<Object[]> rows = DefaultPlanExecutor.batchesToRows(List.of());
            new Schema(List.of(new Field("s", FieldType.nullable(ArrowType.Utf8.INSTANCE), null))),
     * strategy through the M0 path when it's {@code false}. This test pins the setting's  
/*  
        assertEquals(1, rows.get(0)[0]);
        List<T> out = new ArrayList<>();
            org.opensearch.analytics.AnalyticsSettings.ALL_SETTINGS.contains(org.opensearch.analytics.AnalyticsSettings.MPP_ENABLED)  
    }  
import org.apache.arrow.vector.types.pojo.Field;
        assertEquals(5, rows.size());
    }
    private VectorSchemaRoot makeIntBatch(BufferAllocator alloc, String fieldName, int... values) {  
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch)));  
        assertTrue(rows.get(0)[0] instanceof String);
    public void setUp() throws Exception {
        ids.setSafe(0, 100L);  
        vsr.allocateNew();
        super.setUp();  
        expectThrows(IllegalStateException.class, () -> DefaultPlanExecutor.batchesToRows(List.of(batch), List.of("name", "nonexistent")));
        VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, allocator);  
        batch.allocateNew();
            s.getDefault(org.opensearch.common.settings.Settings.EMPTY)  
 *
    /** Two-column batch with vectors in physical order [age (BigInt), name (VarChar)]. */
    }
    public void testBatchesToRowsThrowsWhenTargetNameMissing() {  
     * key, default, and dynamic property — the gate's actual dispatch effect is verified at
        Field ageField = new Field("age", FieldType.nullable(new ArrowType.Int(64, true)), null);  
        DefaultPlanExecutor.batchesToRows(List.of(batch));
            s.getProperties().contains(org.opensearch.common.settings.Setting.Property.NodeScope)
        VarCharVector names = (VarCharVector) batch.getVector(1);
        BigIntVector ids = (BigIntVector) batch.getVector(0);
package org.opensearch.analytics.exec;
import java.nio.charset.StandardCharsets;
        VectorSchemaRoot batch = VectorSchemaRoot.create(
            allocator  
        return out;  
        return vsr;
     * Silent fallback would let a misaligned plan return wrong-but-shape-valid rows, which
 * SPDX-License-Identifier: Apache-2.0
    public void testBatchesToRowsSingleBatchIntegers() {  
    // ── helpers ──────────────────────────────────────────────────────────
        while (iter.hasNext())
import java.util.Iterator;  
        VectorSchemaRoot vsr = VectorSchemaRoot.create(schema, alloc);  
     * The coordinator's Arrow batch can present columns in physical/scan order (e.g. a
    private static <T> List<T> toList(Iterable<T> it) {
     * The {@code analytics.mpp.enabled} setting is the operator-facing master switch for MPP  
        IntVector vec = (IntVector) batch.getVector(0);
    /**
     * is harder to diagnose than a fast failure. If the upstream caller wants tolerance,  
        batch.setRowCount(2);
    }  
import java.util.ArrayList;
    }
    public void testBatchesToRowsMultipleColumns() {
    private VectorSchemaRoot makeIntBatch(String fieldName, int... values) {
        // AnalyticsPlugin.getSettings() returns AnalyticsSettings.ALL_SETTINGS — that's the
        assertEquals("alice", rows.get(0)[1]);  
        assertTrue("batch should hold allocated memory", before > 0);  
    }  
    }
     * {@code clusterService.getClusterSettings().get(...)} and routes any non-COORDINATOR_CENTRIC
        assertEquals(200L, rows.get(1)[0]);
     * values transpose.
    }
        names.setSafe(1, "bob".getBytes(StandardCharsets.UTF_8));  
        }
        assertEquals(1, rows.get(0)[0]);  
import org.apache.arrow.vector.types.pojo.Schema;
            out.add(iter.next());
    // ---- MPP kill switch ----  
 * These unit tests cover the one deterministic piece of behavior that lives  
    public void testAnalyticsSettingsAllSettingsContainsMppEnabled() {  
 * dependencies (TransportService, Scheduler, TaskManager, CapabilityRegistry,
        assertEquals(3, rows.get(2)[0]);
        assertEquals(1, rows.size());
                new Field("name", FieldType.nullable(ArrowType.Utf8.INSTANCE), null)
        VectorSchemaRoot batch3 = makeIntBatch("x", 4, 5);  
            List.of(  
        allocator = new RootAllocator();
    /**
     */
    }
     * {@code orderedColumns} throws rather than dropping the column or substituting null.
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch), List.of("name", "age")));  
        assertFalse("no batches → no rows", rows.iterator().hasNext());  
        Schema schema = new Schema(List.of(field));
public class DefaultPlanExecutorTests extends OpenSearchTestCase {  
        assertArrayEquals(new Object[] { 30 }, rows.get(2));  
        assertFalse(
        List<Object[]> rows = toList(DefaultPlanExecutor.batchesToRows(List.of(batch)));
 */
import org.apache.arrow.vector.BigIntVector;  
        batch.setRowCount(2);  
    }  
    }  
        ((BigIntVector) vsr.getVector("age")).setSafe(0, age);
    private BufferAllocator allocator;
        ((VarCharVector) vsr.getVector("name")).setSafe(0, name.getBytes(StandardCharsets.UTF_8));  
        child.close();  
        VarCharVector vec = (VarCharVector) batch.getVector(0);  
            vec.setSafe(i, values[i]);
        assertEquals(2, rows.size());
     * no-projection scan over a dynamically-mapped index comes back alphabetically [age, name]).
    public void testBatchesToRowsHandlesNulls() {
        VectorSchemaRoot batch2 = makeIntBatch("x", 3);
    public void testBatchesToRowsClosesBatches() {
        VectorSchemaRoot batch = makeAgeNameBatch(20L, "hello");  // physical order: [age, name]
    }
        names.setSafe(0, "alice".getBytes(StandardCharsets.UTF_8));
        assertTrue(  
 *
        );  
        assertArrayEquals("columns must be reordered to [name, age]", new Object[] { "hello", 20L }, rows.get(0));
        assertEquals(4, rows.get(3)[0]);  
        for (int i = 0; i < values.length; i++) {  
        // list, this test catches the omission for MPP_ENABLED specifically.  
            "MPP disabled by default in production — operators opt in (QA clusters enable it explicitly)",
        Schema schema = new Schema(List.of(ageField, nameField));
     * it must filter target names before invoking {@code batchesToRows}.
 * this file be licensed under the Apache-2.0 license or a
