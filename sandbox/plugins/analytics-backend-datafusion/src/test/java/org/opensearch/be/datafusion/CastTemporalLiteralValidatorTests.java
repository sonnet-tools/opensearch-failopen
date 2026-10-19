    /** TIMESTAMPDIFF with bad string literal arg — format-hint exception on the first bad arg. */  
            typeFactory.createSqlType(SqlTypeName.INTEGER),  
        rexBuilder = new RexBuilder(typeFactory);  
        RexLiteral literal = (RexLiteral) rexBuilder.makeLiteral(value, nonNullVarchar, false);
        RelDataType targetType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(target), true);
    }
        IllegalArgumentException e = expectThrows(
    public void testTimeLiteralCastToDateRejected() {
    }
    }
    /** CAST('1984-04-12' AS TIME) → IllegalArgumentException with time format-hint. */
    public void testBareDateCastToTimestampAccepted() {
    /** CAST('1984-04-12' AS TIMESTAMP) accepted — bare date is valid timestamp input. */
        IllegalArgumentException e = expectThrows(
    public void testInvalidDateLiteralCastRejected() {
            IllegalArgumentException.class,
            () -> cast.accept(CastTemporalLiteralValidator.newShuttle())
    }
            () -> call.accept(CastTemporalLiteralValidator.newShuttle())
        );
            IllegalArgumentException.class,
        );
        IllegalArgumentException e = expectThrows(  
import org.opensearch.test.OpenSearchTestCase;
    public void setUp() throws Exception {  
    private RexBuilder rexBuilder;  
            () -> cast.accept(CastTemporalLiteralValidator.newShuttle())  
    }
            List.of(makeStringLiteral("HOUR"), makeStringLiteral("2025-13-02"), makeStringLiteral("2025-13-02"))
        RexNode cast = rexBuilder.makeCast(dateType, columnRef);
    private RelDataTypeFactory typeFactory;
        cast.accept(CastTemporalLiteralValidator.newShuttle());  // no throw
import org.apache.calcite.sql.SqlKind;  
            null,  
    }
    /** CAST('2025-13-02' AS DATE) → IllegalArgumentException with date format-hint. */  
    public void testDateLiteralCastToTimeRejected() {  
 *
        );
        RexNode cast = castStringLiteralTo("2025-13-02", SqlTypeName.DATE);
import org.apache.calcite.rel.type.RelDataType;
        assertEquals("timestamp:not-a-timestamp in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
 */  
            OperandTypes.VARIADIC,
            "TIMESTAMPADD",
        );  
import org.apache.calcite.sql.type.SqlTypeName;
 * compatible open source license.
    public void testTimestampAddBadLiteralRejected() {  
        RexNode call = buildTimestampAddDiff(
    }  
    private RexLiteral makeIntLiteral(int value) {  
    }  
            SqlFunctionCategory.TIMEDATE
        cast.accept(CastTemporalLiteralValidator.newShuttle());  // no throw
import org.apache.calcite.sql.SqlFunctionCategory;
        IllegalArgumentException e = expectThrows(  
        assertEquals("date:2025-13-02 in unsupported format, please use 'yyyy-MM-dd'", e.getMessage());
        );
        return rexBuilder.makeCall(typeFactory.createSqlType(SqlTypeName.BIGINT), op, operands);
    /** CAST('09:07:42' AS TIMESTAMP) rejected — bare time is not a valid timestamp literal. */  
        );  
    }
        return (RexLiteral) rexBuilder.makeLiteral(value, nonNullVarchar, false);  
    public void testGarbageStringCastToTimestampRejected() {
        RexNode columnRef = rexBuilder.makeInputRef(varcharType, 0);
        IllegalArgumentException e = expectThrows(
        RexNode cast = castStringLiteralTo("09:07:42", SqlTypeName.DATE);  
        assertEquals("timestamp:09:07:42 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
    }
        RexNode cast = castStringLiteralTo("1984-04-12", SqlTypeName.TIMESTAMP);  
}
    public void testBareTimeCastToTimestampRejected() {
 * this file be licensed under the Apache-2.0 license or a
            IllegalArgumentException.class,  
        super.setUp();
import org.apache.calcite.sql.type.ReturnTypes;  
        IllegalArgumentException e = expectThrows(
    }  
        assertEquals("timestamp:16:00:61 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());  
            name,  
        assertEquals("timestamp:2025-13-02 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
        assertEquals("time:1984-04-12 in unsupported format, please use 'HH:mm:ss[.SSSSSSSSS]'", e.getMessage());  
            ReturnTypes.BIGINT_NULLABLE,
            () -> cast.accept(CastTemporalLiteralValidator.newShuttle())
import org.apache.calcite.sql.SqlOperator;
        );
        RelDataType nonNullVarchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    }  
public class CastTemporalLiteralValidatorTests extends OpenSearchTestCase {  
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
    private RexNode buildTimestampAddDiff(String name, List<RexNode> operands) {
        RelDataType nonNullVarchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
    private RexNode castStringLiteralTo(String value, SqlTypeName target) {
        SqlOperator op = new SqlFunction(
package org.opensearch.be.datafusion;
/*  
            () -> cast.accept(CastTemporalLiteralValidator.newShuttle())
        RexNode cast = castStringLiteralTo("not-a-timestamp", SqlTypeName.TIMESTAMP);  
        return rexBuilder.makeCast(targetType, literal);  
    /** TIMESTAMPADD with bad string literal arg — format-hint exception (substrait would otherwise reject opaquely). */
    /** CAST('garbage' AS TIMESTAMP) → IllegalArgumentException with timestamp format-hint. */
    }
        );
        typeFactory = new JavaTypeFactoryImpl();
            () -> call.accept(CastTemporalLiteralValidator.newShuttle())
 * SPDX-License-Identifier: Apache-2.0
        RelDataType dateType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DATE), true);  
import org.apache.calcite.rex.RexLiteral;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
import org.apache.calcite.sql.type.OperandTypes;
    private RexLiteral makeStringLiteral(String value) {
            IllegalArgumentException.class,
    /** CAST('09:07:42' AS DATE) — bare time string is not a valid date literal (cluster G1). */
        );
import org.apache.calcite.rex.RexBuilder;
    @Override
import org.apache.calcite.rex.RexNode;  
            SqlKind.OTHER_FUNCTION,
        return (RexLiteral) rexBuilder.makeLiteral(
        RexNode call = buildTimestampAddDiff(
import org.apache.calcite.sql.SqlFunction;
 * The OpenSearch Contributors require contributions made to  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            java.math.BigDecimal.valueOf(value),
        );  
    public void testTimestampDiffBadLiteralRejected() {
import java.util.List;
            false
        IllegalArgumentException e = expectThrows(  
            () -> cast.accept(CastTemporalLiteralValidator.newShuttle())  
        assertEquals("date:09:07:42 in unsupported format, please use 'yyyy-MM-dd'", e.getMessage());
            IllegalArgumentException.class,  
        );  
    public void testColumnRefCastNotValidated() {  
            "TIMESTAMPDIFF",  
            List.of(makeStringLiteral("HOUR"), makeIntLiteral(1), makeStringLiteral("16:00:61"))  
        RexNode cast = castStringLiteralTo("1984-04-12", SqlTypeName.TIME);
            IllegalArgumentException.class,
            IllegalArgumentException.class,
        RexNode cast = castStringLiteralTo("09:07:42", SqlTypeName.TIMESTAMP);
    }
    /** Non-string-literal cast (column ref → DATE) passes through unchanged. */
