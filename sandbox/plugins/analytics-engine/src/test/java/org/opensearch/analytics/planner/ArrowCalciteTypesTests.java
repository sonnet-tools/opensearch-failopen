/**
    public void testIntegerAndBigintUnchanged() {  
    /** date ⇒ TIMESTAMP(3) ⇒ MILLISECOND. */
    public void testArrayMapsToListWithUtf8ViewChild() {
 *
import org.apache.calcite.sql.type.SqlTypeFactoryImpl;  
        assertEquals(new ArrowType.Timestamp(TimeUnit.MILLISECOND, null), ArrowCalciteTypes.toArrow(timestamp(3)));  
     */
                return 9;
import org.apache.calcite.rel.type.RelDataTypeSystemImpl;
        assertEquals(new ArrowType.Int(64, true), ArrowCalciteTypes.toArrow(type(SqlTypeName.BIGINT)));
    }  
/*  
     * copyFromSafe sees matching types. Previously threw "Unsupported Calcite type: SMALLINT".
 * Unit tests for {@link ArrowCalciteTypes} Calcite→Arrow mapping used by the QTF
 * The OpenSearch Contributors require contributions made to  
    private static RelDataType type(SqlTypeName name) {
    /** date_nanos ⇒ TIMESTAMP(9) ⇒ NANOSECOND — regression: previously hardcoded MILLISECOND, tripped Stitcher copyFromSafe. */  
 * (late-materialization) stitch path.  
    /** Default-precision TIMESTAMP (precision 0) keeps the legacy MILLISECOND mapping. */
    /** Lifts TIMESTAMP max-precision to 9; default Calcite caps at 3 and would clamp date_nanos away. */  
    public void testSmallintMapsToInt16() {  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    });  
    private static final SqlTypeFactoryImpl TYPE_FACTORY = new SqlTypeFactoryImpl(RelDataTypeSystem.DEFAULT);
        assertEquals(new ArrowType.Timestamp(TimeUnit.NANOSECOND, null), ArrowCalciteTypes.toArrow(timestamp(9)));
            }  
        return TYPE_FACTORY.createSqlType(name);  
package org.opensearch.analytics.planner;
import org.apache.arrow.vector.types.pojo.ArrowType;
        assertEquals(1, field.getChildren().size());
            if (typeName == SqlTypeName.TIMESTAMP || typeName == SqlTypeName.TIMESTAMP_WITH_LOCAL_TIME_ZONE) {
    public void testTinyintMapsToInt8() {
        assertEquals(ArrowType.Utf8View.INSTANCE, field.getChildren().get(0).getType());
import org.apache.calcite.rel.type.RelDataTypeSystem;
            return super.getMaxPrecision(typeName);
 */
import org.opensearch.test.OpenSearchTestCase;
 */  
    public void testTimestampDefaultPrecisionMapsToMillisecond() {  
    public void testTimestampPrecision9MapsToNanosecond() {
        assertEquals(ArrowType.List.INSTANCE, field.getType());
    }
        return NANOS_TYPE_FACTORY.createSqlType(SqlTypeName.TIMESTAMP, precision);
        RelDataType array = TYPE_FACTORY.createArrayType(type(SqlTypeName.VARCHAR), -1);  
     * SMALLINT (OpenSearch {@code short}) must map to the wire Arrow type the data node
import org.apache.calcite.sql.type.SqlTypeName;
        assertEquals(ArrowType.List.INSTANCE, ArrowCalciteTypes.toArrow(array));
        assertEquals(new ArrowType.Int(32, true), ArrowCalciteTypes.toArrow(type(SqlTypeName.INTEGER)));
    }  
    }
    /**
    }
    }
import org.apache.arrow.vector.types.TimeUnit;
    public void testTimestampPrecision3MapsToMillisecond() {
     * emits — {@code Int(16, true)} per {@code ShortParquetField} — so the Stitcher's  
    private static RelDataType timestamp(int precision) {  
    private static final SqlTypeFactoryImpl NANOS_TYPE_FACTORY = new SqlTypeFactoryImpl(new RelDataTypeSystemImpl() {
    }
        public int getMaxPrecision(SqlTypeName typeName) {  
import org.apache.calcite.rel.type.RelDataType;  
}  
        assertEquals(new ArrowType.Timestamp(TimeUnit.MILLISECOND, null), ArrowCalciteTypes.toArrow(type(SqlTypeName.TIMESTAMP)));
        assertEquals(new ArrowType.Int(8, true), ArrowCalciteTypes.toArrow(type(SqlTypeName.TINYINT)));  
        assertEquals(new ArrowType.Int(16, true), ArrowCalciteTypes.toArrow(type(SqlTypeName.SMALLINT)));
public class ArrowCalciteTypesTests extends OpenSearchTestCase {
    /** TINYINT (OpenSearch {@code byte}) -> Int(8, true) per ByteParquetField. */
    }
        }
        @Override
    }
 * this file be licensed under the Apache-2.0 license or a
        org.apache.arrow.vector.types.pojo.Field field = ArrowCalciteTypes.toArrowField("tags", array);  
        assertEquals("element", field.getChildren().get(0).getName());  
