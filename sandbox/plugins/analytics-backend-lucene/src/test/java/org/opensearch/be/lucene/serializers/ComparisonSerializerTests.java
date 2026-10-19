/*  
    public void setUp() throws Exception {  
        RexNode call = rexBuilder.makeCall(
        );
import java.util.List;
            SqlStdOperatorTable.LESS_THAN,
import org.apache.calcite.rel.type.RelDataType;
        assertFalse(range.includeLower());
        RangeQueryBuilder range = (RangeQueryBuilder) serializer.buildQueryBuilder((org.apache.calcite.rex.RexCall) call, FIELD_STORAGE);
 * this file be licensed under the Apache-2.0 license or a
        rexBuilder = new RexBuilder(typeFactory);  
        assertEquals(200, range.to());
            rexBuilder.makeInputRef(integer, 0),  
 * compatible open source license.
        RangeQueryBuilder range = (RangeQueryBuilder) serializer.buildQueryBuilder((org.apache.calcite.rex.RexCall) call, FIELD_STORAGE);
import org.apache.calcite.rex.RexNode;
        RexNode call = rexBuilder.makeCall(
        // 100 < col ⇒ col > 100
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        RexNode call = rexBuilder.makeCall(  
    }
    public void testReversedOperandFlipsDirection() {  
            SqlStdOperatorTable.LESS_THAN_OR_EQUAL,
        RexNode call = rexBuilder.makeCall(  
        );
        );
 * The OpenSearch Contributors require contributions made to  
        );  
        assertEquals("price", range.fieldName());  
        assertTrue(range.includeLower());
        assertTrue(range.includeUpper());  
        typeFactory = new JavaTypeFactoryImpl();
        assertEquals("price", range.fieldName());
package org.opensearch.be.lucene.serializers;
    private RexBuilder rexBuilder;
    }  
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.rex.RexBuilder;
}  
    @Override
import org.opensearch.index.query.RangeQueryBuilder;
 *
            rexBuilder.makeLiteral(200, integer, false)  
import org.opensearch.analytics.spi.FieldType;  
 */  
    private static final List<FieldStorageInfo> FIELD_STORAGE = List.of(
        assertEquals(999, range.to());
        assertFalse(range.includeLower());
    }
        );  
        assertNull(range.to());
    private final ComparisonSerializer serializer = new ComparisonSerializer();
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
            rexBuilder.makeLiteral(50, integer, false)  
        assertFalse(range.includeUpper());
    }
        assertEquals(50, range.from());
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RangeQueryBuilder range = (RangeQueryBuilder) serializer.buildQueryBuilder((org.apache.calcite.rex.RexCall) call, FIELD_STORAGE);
            rexBuilder.makeInputRef(integer, 0),
    public void testLessThan() {
        assertNull(range.from());  
            rexBuilder.makeInputRef(integer, 0),
    }
            SqlStdOperatorTable.GREATER_THAN,  
            rexBuilder.makeInputRef(integer, 0),
            rexBuilder.makeLiteral(999, integer, false)
        RangeQueryBuilder range = (RangeQueryBuilder) serializer.buildQueryBuilder((org.apache.calcite.rex.RexCall) call, FIELD_STORAGE);  
        assertEquals("price", range.fieldName());
import org.opensearch.analytics.spi.FieldStorageInfo;
        assertEquals("price", range.fieldName());  
        new FieldStorageInfo("price", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
    }  
            SqlStdOperatorTable.GREATER_THAN_OR_EQUAL,
    public void testLessThanOrEqual() {  
            rexBuilder.makeLiteral(100, integer, false)
    private RelDataTypeFactory typeFactory;  
        assertEquals(100, range.from());  
    public void testGreaterThanOrEqual() {
        RangeQueryBuilder range = (RangeQueryBuilder) serializer.buildQueryBuilder((org.apache.calcite.rex.RexCall) call, FIELD_STORAGE);
            SqlStdOperatorTable.LESS_THAN,  
            rexBuilder.makeInputRef(integer, 0)
        integer = typeFactory.createSqlType(SqlTypeName.INTEGER);
public class ComparisonSerializerTests extends OpenSearchTestCase {  
        RexNode call = rexBuilder.makeCall(
import org.apache.calcite.sql.type.SqlTypeName;
            rexBuilder.makeLiteral(100, integer, false),
    );  
        assertEquals("price", range.fieldName());
        super.setUp();
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(100, range.from());  
    private RelDataType integer;
    public void testGreaterThan() {
