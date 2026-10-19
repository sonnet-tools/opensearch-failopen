    }  
    public void testLastHasDecomposition() {  
 * marking using Calcite's {@code AggregateReduceFunctionsRule}. The enum entries for
    // ── LIST: engine-native (single field, reducer == self, parameterised resolver) ──  
        assertEquals(1, fields.size());  
        assertEquals(integer, resolve(fields.get(0), integer));
    }
    // DataFusion's t-digest state is multi-field and doesn't fit the single-field  
    }
    // ── VALUES: engine-native (single field, reducer == self, parameterised resolver) ──
    public void testTakeReducerIsSelfAndResolverIsParameterised() {  
        assertTrue(LAST.hasDecomposition());
        assertSame(AggregateFunction.PERCENTILE_APPROX, AggregateFunction.fromNameOrError("percentile_approx"));  
 * The OpenSearch Contributors require contributions made to  
    }  
import org.apache.calcite.rel.type.RelDataType;
        assertSame(MAX, AggregateFunction.fromSqlKind(SqlKind.MAX));  
    public void testPercentileApproxHasNoDecomposition() {
        assertEquals("take_state", fields.get(0).name());  
        assertFalse(AVG.hasDecomposition());  
    // ── TAKE: engine-native (single field, reducer == self, parameterised resolver) ──  
    // for STATE_EXPANDING aggregates, so PERCENTILE_APPROX runs single-stage on the
        assertEquals(integer, resolve(fields.get(0), integer));
 * the enum — they're handled by {@code OpenSearchAggregateReduceRule} during HEP
        assertEquals("last_state", fields.get(0).name());
    //
    public void testListHasDecomposition() {
    public void testPercentileApproxResolvesByName() {
    }  
        assertEquals(integer, resolve(fields.get(0), integer));
    }
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
 * SPDX-License-Identifier: Apache-2.0
 *
        assertSame(LAST, fields.get(0).reducer());
    public void testAvgHasNoDecomposition() {
        assertNull(AggregateFunction.PERCENTILE_APPROX.intermediateFields());  
    // ── fromSqlKind still works ──
    }
        assertSame(AggregateFunction.PERCENTILE_APPROX, AggregateFunction.fromNameOrError("PERCENTILE_APPROX"));
    // ── Pass-through: SUM / MIN / MAX ──  
 * Asserts the enum carries the right shape per function for the resolver's three
import static org.opensearch.analytics.spi.AggregateFunction.SUM;  
    public void testFirstReducerIsSelf() {
        assertTrue(VALUES.hasDecomposition());
    public void testCountHasDecomposition() {  
        assertEquals(SqlTypeName.VARBINARY, resolve(fields.get(0), integer).getSqlTypeName());  
        assertNull(SUM.intermediateFields());
        assertSame(APPROX_COUNT_DISTINCT, fields.get(0).reducer());
        assertEquals(1, fields.size());  
        assertSame(MIN, AggregateFunction.fromSqlKind(SqlKind.MIN));
import static org.opensearch.analytics.spi.AggregateFunction.MAX;
    // ── COUNT: function-swap (single field, reducer != self) ──
 * compatible open source license.
 * (reducer ≠ self), engine-native merge (reducer == self, binary intermediate).
import static org.opensearch.analytics.spi.AggregateFunction.LIST;  
import static org.opensearch.analytics.spi.AggregateFunction.COUNT;  
        return field.typeResolver().resolve(List.of(arg0), typeFactory);  
 * those functions intentionally declare {@code intermediateFields == null} so that  
    // ── FIRST: engine-native (single field, reducer == self, parameterised resolver) ──
 *
    // ── LAST: engine-native (single field, reducer == self, parameterised resolver) ──
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        assertEquals(SqlKind.OTHER, AggregateFunction.PERCENTILE_APPROX.getSqlKind());
    public void testSumHasNoDecomposition() {
        assertEquals(1, fields.size());
import static org.opensearch.analytics.spi.AggregateFunction.MIN;
    private RelDataType resolve(AggregateFunction.IntermediateField field, RelDataType arg0) {
 * this file be licensed under the Apache-2.0 license or a
        assertNull(AggregateFunction.fromSqlKind(SqlKind.OTHER));  
        List<AggregateFunction.IntermediateField> fields = LAST.intermediateFields();
import org.opensearch.test.OpenSearchTestCase;  
        assertSame(TAKE, fields.get(0).reducer());
    }
        assertEquals(1, fields.size());
        // enum. Enum declares no intermediate — post-reduction plan carries primitive SUM/
    }  
    public void testTakeHasDecomposition() {
        List<AggregateFunction.IntermediateField> fields = TAKE.intermediateFields();
        assertEquals("count", fields.get(0).name());
        List<AggregateFunction.IntermediateField> fields = VALUES.intermediateFields();  
 * <p>Multi-field / scalar-final shapes (AVG, STDDEV, VAR) are <em>not</em> encoded on  
        assertTrue(TAKE.hasDecomposition());  
        assertSame(FIRST, fields.get(0).reducer());  
        assertEquals(SqlTypeName.BIGINT, resolve(fields.get(0), integer).getSqlTypeName());  
import static org.opensearch.analytics.spi.AggregateFunction.FIRST;
        assertSame(COUNT, AggregateFunction.fromSqlKind(SqlKind.COUNT));
        assertSame(SUM, AggregateFunction.fromSqlKind(SqlKind.SUM));
    }
    public void testValuesHasDecomposition() {
/**
    public void testValuesReducerIsSelf() {
        assertTrue(COUNT.hasDecomposition());
        List<AggregateFunction.IntermediateField> fields = COUNT.intermediateFields();
        assertFalse(AggregateFunction.PERCENTILE_APPROX.hasDecomposition());
 * the resolver's pass-through branch catches any post-reduction primitive calls.
        assertEquals(1, fields.size());  
 */  
    public void testFromSqlKindReturnsNullForOther() {
import org.apache.calcite.sql.type.SqlTypeName;
    // coordinator after a singleton gather.  
        assertEquals("passThroughArg0 returns arg0", integer, resolve(fields.get(0), integer));
import static org.opensearch.analytics.spi.AggregateFunction.LAST;
}
    public void testLastReducerIsSelf() {
package org.opensearch.analytics.spi;
import static org.opensearch.analytics.spi.AggregateFunction.APPROX_COUNT_DISTINCT;
    // ── AVG / STDDEV / VAR: handled by Calcite's reduce rule — no enum metadata ──  
    public void testCountIntermediateFields() {
import static org.opensearch.analytics.spi.AggregateFunction.AVG;
    }
 * single-field decomposition cases: pass-through (no intermediate), function-swap  
    }
        assertTrue(LIST.hasDecomposition());  
    }
        assertEquals(1, fields.size());
    }  
        // COUNT calls whose enum entries ARE decompositions (function-swap / pass-through).
        assertTrue(APPROX_COUNT_DISTINCT.hasDecomposition());
        assertTrue(FIRST.hasDecomposition());
        List<AggregateFunction.IntermediateField> fields = FIRST.intermediateFields();  
    }
        assertEquals("values_state", fields.get(0).name());
    }
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertSame(SUM, fields.get(0).reducer());
        assertEquals(1, fields.size());
    public void testFirstHasDecomposition() {
    public void testFromSqlKindResolvesExistingEntries() {  
        assertEquals("list_state", fields.get(0).name());  
    private final RelDataType integer = typeFactory.createSqlType(SqlTypeName.INTEGER);  
 */
        assertEquals("first_state", fields.get(0).name());
        assertEquals(AggregateFunction.Type.STATE_EXPANDING, AggregateFunction.PERCENTILE_APPROX.getType());
    }
    // IntermediateField shape. OpenSearchAggregateSplitRule skips the partial/final split
    public void testApproxCountDistinctReducerIsSelf() {
        assertEquals(integer, resolve(fields.get(0), integer));  
/*  
import java.util.List;
public class AggregateFunctionTests extends OpenSearchTestCase {  
import static org.opensearch.analytics.spi.AggregateFunction.TAKE;
    }  
        List<AggregateFunction.IntermediateField> fields = LIST.intermediateFields();
    }
        assertNull(AVG.intermediateFields());
        List<AggregateFunction.IntermediateField> fields = APPROX_COUNT_DISTINCT.intermediateFields();
    }
    public void testListReducerIsSelf() {  
        assertSame(AVG, AggregateFunction.fromSqlKind(SqlKind.AVG));
    // ── APPROX_COUNT_DISTINCT: engine-native (single binary field, reducer == self) ──
        assertFalse(SUM.hasDecomposition());  
import static org.opensearch.analytics.spi.AggregateFunction.VALUES;
        assertSame(VALUES, fields.get(0).reducer());  
        // AVG decomposition is driven by OpenSearchAggregateReduceRule in HEP, not by the  
    }
        assertEquals("hll_registers", fields.get(0).name());
import org.apache.calcite.sql.SqlKind;
    public void testApproxCountDistinctHasDecomposition() {  
    // ── PERCENTILE_APPROX: state-bearing, no decomposition declared ──
        assertSame(LIST, fields.get(0).reducer());
