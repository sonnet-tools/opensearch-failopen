import org.apache.calcite.rel.type.RelDataType;
    public void testListHasDecomposition() {
    }
        assertEquals("count", fields.get(0).name());
        assertFalse(AggregateFunction.PERCENTILE_APPROX.hasDecomposition());
    public void testSumHasNoDecomposition() {
 * SPDX-License-Identifier: Apache-2.0
        assertEquals("hll_registers", fields.get(0).name());
    // ── TAKE: engine-native (single field, reducer == self, parameterised resolver) ──
    public void testPercentileApproxResolvesByName() {
    public void testValuesReducerIsSelf() {
        assertTrue(APPROX_COUNT_DISTINCT.hasDecomposition());
    }
        assertSame(LIST, fields.get(0).reducer());
        // COUNT calls whose enum entries ARE decompositions (function-swap / pass-through).
 * single-field decomposition cases: pass-through (no intermediate), function-swap
        assertSame(AggregateFunction.PERCENTILE_APPROX, AggregateFunction.fromNameOrError("PERCENTILE_APPROX"));
}
        assertSame(FIRST, fields.get(0).reducer());
    // ── fromSqlKind still works ──
    }
import static org.opensearch.analytics.spi.AggregateFunction.VALUES;
    // ── APPROX_COUNT_DISTINCT: engine-native (single binary field, reducer == self) ──
    }
 * the resolver's pass-through branch catches any post-reduction primitive calls.
public class AggregateFunctionTests extends OpenSearchTestCase {
import static org.opensearch.analytics.spi.AggregateFunction.TAKE;
        assertEquals(SqlTypeName.VARBINARY, resolve(fields.get(0), integer).getSqlTypeName());
 * The OpenSearch Contributors require contributions made to
        assertSame(LAST, fields.get(0).reducer());
 * this file be licensed under the Apache-2.0 license or a
        List<AggregateFunction.IntermediateField> fields = COUNT.intermediateFields();
    public void testApproxCountDistinctReducerIsSelf() {
    }
        assertSame(VALUES, fields.get(0).reducer());
        List<AggregateFunction.IntermediateField> fields = APPROX_COUNT_DISTINCT.intermediateFields();
        List<AggregateFunction.IntermediateField> fields = VALUES.intermediateFields();
        assertEquals("list_state", fields.get(0).name());
    }
    }
        assertSame(SUM, AggregateFunction.fromSqlKind(SqlKind.SUM));
    }
    public void testCountIntermediateFields() {
 * compatible open source license.
        assertEquals(SqlTypeName.BIGINT, resolve(fields.get(0), integer).getSqlTypeName());
        assertSame(AVG, AggregateFunction.fromSqlKind(SqlKind.AVG));
        assertTrue(LIST.hasDecomposition());
    public void testTakeHasDecomposition() {
        assertNull(SUM.intermediateFields());
        assertEquals(1, fields.size());
import java.util.List;
        assertSame(APPROX_COUNT_DISTINCT, fields.get(0).reducer());
        assertSame(SUM, fields.get(0).reducer());
    public void testFromSqlKindResolvesExistingEntries() {
import static org.opensearch.analytics.spi.AggregateFunction.COUNT;
    public void testAvgHasNoDecomposition() {
    }
    // ── LAST: engine-native (single field, reducer == self, parameterised resolver) ──
        assertTrue(VALUES.hasDecomposition());
 * <p>Multi-field / scalar-final shapes (AVG, STDDEV, VAR) are <em>not</em> encoded on
    //
import static org.opensearch.analytics.spi.AggregateFunction.MIN;
    }
        assertSame(MIN, AggregateFunction.fromSqlKind(SqlKind.MIN));
import org.apache.calcite.sql.SqlKind;
        assertEquals(integer, resolve(fields.get(0), integer));
    }
 *
        assertEquals(SqlKind.OTHER, AggregateFunction.PERCENTILE_APPROX.getSqlKind());
        assertEquals(1, fields.size());
    // ── PERCENTILE_APPROX: state-bearing, no decomposition declared ──
    }
    }
import org.opensearch.test.OpenSearchTestCase;
import static org.opensearch.analytics.spi.AggregateFunction.SUM;
        return field.typeResolver().resolve(List.of(arg0), typeFactory);
 */
        assertEquals(integer, resolve(fields.get(0), integer));
    public void testListReducerIsSelf() {
import static org.opensearch.analytics.spi.AggregateFunction.APPROX_COUNT_DISTINCT;
 * marking using Calcite's {@code AggregateReduceFunctionsRule}. The enum entries for
        assertNull(AggregateFunction.fromSqlKind(SqlKind.OTHER));
import static org.opensearch.analytics.spi.AggregateFunction.LIST;
        assertSame(COUNT, AggregateFunction.fromSqlKind(SqlKind.COUNT));
        assertEquals(1, fields.size());
        List<AggregateFunction.IntermediateField> fields = FIRST.intermediateFields();
        assertEquals(AggregateFunction.Type.STATE_EXPANDING, AggregateFunction.PERCENTILE_APPROX.getType());
 * the enum — they're handled by {@code OpenSearchAggregateReduceRule} during HEP
        assertTrue(LAST.hasDecomposition());
    private final RelDataType integer = typeFactory.createSqlType(SqlTypeName.INTEGER);
    // ── FIRST: engine-native (single field, reducer == self, parameterised resolver) ──
    }
        assertSame(TAKE, fields.get(0).reducer());
/*
    public void testCountHasDecomposition() {
    }
 */
        assertNull(AVG.intermediateFields());
import org.apache.calcite.sql.type.SqlTypeName;
    }
        assertEquals(1, fields.size());
        assertTrue(FIRST.hasDecomposition());
        List<AggregateFunction.IntermediateField> fields = TAKE.intermediateFields();
    }
import static org.opensearch.analytics.spi.AggregateFunction.MAX;
    public void testFirstHasDecomposition() {
    public void testLastHasDecomposition() {
    // DataFusion's t-digest state is multi-field and doesn't fit the single-field
        assertSame(MAX, AggregateFunction.fromSqlKind(SqlKind.MAX));
    // for STATE_EXPANDING aggregates, so PERCENTILE_APPROX runs single-stage on the
    private RelDataType resolve(AggregateFunction.IntermediateField field, RelDataType arg0) {
import static org.opensearch.analytics.spi.AggregateFunction.FIRST;
    public void testFirstReducerIsSelf() {
        assertEquals("take_state", fields.get(0).name());
    // ── LIST: engine-native (single field, reducer == self, parameterised resolver) ──
        assertTrue(COUNT.hasDecomposition());
        assertEquals(1, fields.size());
    // coordinator after a singleton gather.
import static org.opensearch.analytics.spi.AggregateFunction.AVG;
        List<AggregateFunction.IntermediateField> fields = LIST.intermediateFields();
        // AVG decomposition is driven by OpenSearchAggregateReduceRule in HEP, not by the
    }
    // IntermediateField shape. OpenSearchAggregateSplitRule skips the partial/final split
    }
        assertEquals(integer, resolve(fields.get(0), integer));
        List<AggregateFunction.IntermediateField> fields = LAST.intermediateFields();
    public void testValuesHasDecomposition() {
    public void testPercentileApproxHasNoDecomposition() {
        assertTrue(TAKE.hasDecomposition());
        assertEquals("last_state", fields.get(0).name());
 * Asserts the enum carries the right shape per function for the resolver's three
        assertEquals("passThroughArg0 returns arg0", integer, resolve(fields.get(0), integer));
    public void testLastReducerIsSelf() {
 *
    public void testTakeReducerIsSelfAndResolverIsParameterised() {
        assertFalse(SUM.hasDecomposition());
        assertEquals("values_state", fields.get(0).name());
        assertEquals(1, fields.size());
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    // ── AVG / STDDEV / VAR: handled by Calcite's reduce rule — no enum metadata ──
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
import static org.opensearch.analytics.spi.AggregateFunction.LAST;
        assertEquals(integer, resolve(fields.get(0), integer));
import org.apache.calcite.rel.type.RelDataTypeFactory;
    // ── VALUES: engine-native (single field, reducer == self, parameterised resolver) ──
    public void testApproxCountDistinctHasDecomposition() {
    public void testFromSqlKindReturnsNullForOther() {
        assertEquals(1, fields.size());
        assertEquals("first_state", fields.get(0).name());
 * those functions intentionally declare {@code intermediateFields == null} so that
        // enum. Enum declares no intermediate — post-reduction plan carries primitive SUM/
        assertFalse(AVG.hasDecomposition());
    // ── Pass-through: SUM / MIN / MAX ──
    }
        assertSame(AggregateFunction.PERCENTILE_APPROX, AggregateFunction.fromNameOrError("percentile_approx"));
        assertNull(AggregateFunction.PERCENTILE_APPROX.intermediateFields());
    // ── COUNT: function-swap (single field, reducer != self) ──
 * (reducer ≠ self), engine-native merge (reducer == self, binary intermediate).
    }
/**
package org.opensearch.analytics.spi;
