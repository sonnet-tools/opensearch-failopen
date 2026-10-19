            .build();
        RelDataType rowType = typeFactory.builder()  
        RelDataType rowType = typeFactory.builder()
        assertEquals(new ArrowType.Int(8, true), schema.findField("tiny").getType());
        assertEquals(new ArrowType.FloatingPoint(FloatingPointPrecision.SINGLE), schema.findField("f").getType());
        RelDataType rowType = typeFactory.builder().add("i", typeFactory.createSqlType(SqlTypeName.INTEGER)).build();
    public void testDecimalPreservesPrecisionAndScale() {
        RelDataType rowType = typeFactory.builder()
    private final RelDataTypeFactory typeFactory = new JavaTypeFactoryImpl();
 * compatible open source license.
        Schema schema = CalciteToArrowSchema.convert(rowType);
import org.apache.calcite.sql.type.SqlTypeName;
        assertEquals(5, d.getScale());
        Schema schema = CalciteToArrowSchema.convert(rowType);
 * SPDX-License-Identifier: Apache-2.0
        // JavaTypeFactoryImpl caps decimal precision at 19 internally; the converter passes it
import org.apache.arrow.vector.types.pojo.ArrowType;
        RelDataType rowType = typeFactory.builder().add("amt", typeFactory.createSqlType(SqlTypeName.DECIMAL, 19, 5)).build();
 * this file be licensed under the Apache-2.0 license or a
 *
package org.opensearch.analytics.planner;
    }
            .add("tiny", typeFactory.createSqlType(SqlTypeName.TINYINT))
            .build();
            .add("i", typeFactory.createSqlType(SqlTypeName.INTEGER))
        assertEquals(19, d.getPrecision());
    public void testPrimitiveNumericTypes() {  
        assertEquals(new ArrowType.Utf8(), schema.findField("s").getType());  
        assertEquals(6, schema.getFields().size());  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        assertEquals(new ArrowType.Int(32, true), schema.findField("i").getType());  
    }
        assertEquals(new ArrowType.Int(16, true), schema.findField("small").getType());
    public void testUnknownTypeFallsBackToUtf8() {
 * Tests for {@link CalciteToArrowSchema}. Pinned to the types analytics-engine emits today;
        Schema schema = CalciteToArrowSchema.convert(rowType);  
        assertEquals(ArrowType.Bool.INSTANCE, schema.findField("b").getType());
            .build();
    public void testFieldsAreNullable() {
        Schema schema = CalciteToArrowSchema.convert(rowType);
import org.apache.calcite.rel.type.RelDataType;
            .add("s", typeFactory.createSqlType(SqlTypeName.VARCHAR))
        assertEquals(128, d.getBitWidth());  
            .add("arr", typeFactory.createArrayType(typeFactory.createSqlType(SqlTypeName.INTEGER), -1))
    public void testStringAndBoolean() {  
        assertEquals(new ArrowType.Utf8(), schema.findField("arr").getType());
    }
 */  
import org.apache.arrow.vector.types.pojo.Schema;  
/**
        assertTrue("fallback schema fields are nullable by design", schema.findField("i").isNullable());
            .add("l", typeFactory.createSqlType(SqlTypeName.BIGINT))
 * The OpenSearch Contributors require contributions made to  
        assertEquals(new ArrowType.Int(64, true), schema.findField("l").getType());
            .add("b", typeFactory.createSqlType(SqlTypeName.BOOLEAN))  
            .add("small", typeFactory.createSqlType(SqlTypeName.SMALLINT))  
}  
        Schema schema = CalciteToArrowSchema.convert(rowType);  
    /** Unknown SqlTypeName falls back to Utf8 — last-resort coercion documented on the converter. */  
    }
public class CalciteToArrowSchemaTests extends OpenSearchTestCase {
 * additions should ship with corresponding cases here.  
        ArrowType.Decimal d = (ArrowType.Decimal) schema.findField("amt").getType();  
import org.apache.arrow.vector.types.FloatingPointPrecision;
/*  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    }
        // ARRAY isn't in the whitelist; verifies the default branch.
            .add("d", typeFactory.createSqlType(SqlTypeName.DOUBLE))
 */
        assertEquals(new ArrowType.FloatingPoint(FloatingPointPrecision.DOUBLE), schema.findField("d").getType());  
import org.opensearch.test.OpenSearchTestCase;
            .add("f", typeFactory.createSqlType(SqlTypeName.FLOAT))  
        // through unchanged (within Arrow's 38-bit limit).  
