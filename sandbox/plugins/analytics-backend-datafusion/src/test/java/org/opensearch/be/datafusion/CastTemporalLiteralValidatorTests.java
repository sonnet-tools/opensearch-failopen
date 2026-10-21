import org.apache.calcite.sql.SqlKind;
        RexNode cast = castStringLiteralTo("1984-04-12", SqlTypeName.TIME);
    public void testTimeLiteralCastToDateRejected() {
        return (RexLiteral) rexBuilder.makeLiteral(value, nonNullVarchar, false);
        RexNode cast = castStringLiteralTo("2025-13-02", SqlTypeName.DATE);
    }
            typeFactory.createSqlType(SqlTypeName.INTEGER),
import org.apache.calcite.rex.RexBuilder;
    }
            IllegalArgumentException.class,
            ReturnTypes.BIGINT_NULLABLE,
            () -> cast.accept(CastTemporalLiteralValidator.newShuttle())
        cast.accept(CastTemporalLiteralValidator.newShuttle());  // no throw
    /** Non-string-literal cast (column ref → DATE) passes through unchanged. */
    }
        RexLiteral literal = (RexLiteral) rexBuilder.makeLiteral(value, nonNullVarchar, false);
/*
        assertEquals("timestamp:09:07:42 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
    private RexNode castStringLiteralTo(String value, SqlTypeName target) {
public class CastTemporalLiteralValidatorTests extends OpenSearchTestCase {
    public void testColumnRefCastNotValidated() {
    private RexLiteral makeIntLiteral(int value) {
        IllegalArgumentException e = expectThrows(
    /** CAST('1984-04-12' AS TIMESTAMP) accepted — bare date is valid timestamp input. */
    /** CAST('2025-13-02' AS DATE) → IllegalArgumentException with date format-hint. */
    /** CAST('garbage' AS TIMESTAMP) → IllegalArgumentException with timestamp format-hint. */
 * compatible open source license.
        SqlOperator op = new SqlFunction(
            IllegalArgumentException.class,
    public void testTimestampDiffBadLiteralRejected() {
        RexNode cast = castStringLiteralTo("not-a-timestamp", SqlTypeName.TIMESTAMP);
 * this file be licensed under the Apache-2.0 license or a
    }
 *
        RelDataType varcharType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true);
        super.setUp();
        );
package org.opensearch.be.datafusion;
        );
import org.apache.calcite.sql.SqlOperator;
        RexNode call = buildTimestampAddDiff(
 */
        RelDataType nonNullVarchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    /** TIMESTAMPDIFF with bad string literal arg — format-hint exception on the first bad arg. */
    public void testInvalidDateLiteralCastRejected() {
        IllegalArgumentException e = expectThrows(
    private RexNode buildTimestampAddDiff(String name, List<RexNode> operands) {
        RexNode call = buildTimestampAddDiff(
            SqlKind.OTHER_FUNCTION,
        return (RexLiteral) rexBuilder.makeLiteral(
            IllegalArgumentException.class,
    }
            "TIMESTAMPDIFF",
            () -> cast.accept(CastTemporalLiteralValidator.newShuttle())
            () -> cast.accept(CastTemporalLiteralValidator.newShuttle())
        IllegalArgumentException e = expectThrows(
        rexBuilder = new RexBuilder(typeFactory);
            null,
    }
    }
        RelDataType dateType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DATE), true);
        assertEquals("timestamp:16:00:61 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
import org.apache.calcite.rex.RexNode;
        RexNode cast = castStringLiteralTo("09:07:42", SqlTypeName.DATE);
    /** CAST('09:07:42' AS TIMESTAMP) rejected — bare time is not a valid timestamp literal. */
            () -> call.accept(CastTemporalLiteralValidator.newShuttle())
    }
    public void testGarbageStringCastToTimestampRejected() {
            IllegalArgumentException.class,
 * The OpenSearch Contributors require contributions made to
            List.of(makeStringLiteral("HOUR"), makeStringLiteral("2025-13-02"), makeStringLiteral("2025-13-02"))
        IllegalArgumentException e = expectThrows(
        assertEquals("time:1984-04-12 in unsupported format, please use 'HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
}
        );
        );
    public void testDateLiteralCastToTimeRejected() {
import java.util.List;
    }
import org.apache.calcite.sql.SqlFunction;
        return rexBuilder.makeCall(typeFactory.createSqlType(SqlTypeName.BIGINT), op, operands);
        assertEquals("date:2025-13-02 in unsupported format, please use 'yyyy-MM-dd'", e.getMessage());
            SqlFunctionCategory.TIMEDATE
            () -> call.accept(CastTemporalLiteralValidator.newShuttle())
        RelDataType nonNullVarchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RelDataType targetType = typeFactory.createTypeWithNullability(typeFactory.createSqlType(target), true);
        IllegalArgumentException e = expectThrows(
import org.apache.calcite.sql.type.OperandTypes;
            name,
    }
        assertEquals("date:09:07:42 in unsupported format, please use 'yyyy-MM-dd'", e.getMessage());
        RexNode cast = castStringLiteralTo("1984-04-12", SqlTypeName.TIMESTAMP);
        assertEquals("timestamp:2025-13-02 in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
        );
            "TIMESTAMPADD",
import org.apache.calcite.rex.RexLiteral;
    /** CAST('1984-04-12' AS TIME) → IllegalArgumentException with time format-hint. */
            () -> cast.accept(CastTemporalLiteralValidator.newShuttle())
import org.apache.calcite.rel.type.RelDataType;
        );
            OperandTypes.VARIADIC,
    private RexLiteral makeStringLiteral(String value) {
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.sql.type.ReturnTypes;
            List.of(makeStringLiteral("HOUR"), makeIntLiteral(1), makeStringLiteral("16:00:61"))
    /** CAST('09:07:42' AS DATE) — bare time string is not a valid date literal (cluster G1). */
    private RelDataTypeFactory typeFactory;
        );
        );
        return rexBuilder.makeCast(targetType, literal);
    /** TIMESTAMPADD with bad string literal arg — format-hint exception (substrait would otherwise reject opaquely). */
            IllegalArgumentException.class,
    public void setUp() throws Exception {
        RexNode cast = castStringLiteralTo("09:07:42", SqlTypeName.TIMESTAMP);
    }
            false
        typeFactory = new JavaTypeFactoryImpl();
    private RexBuilder rexBuilder;
        IllegalArgumentException e = expectThrows(
    public void testBareTimeCastToTimestampRejected() {
import org.apache.calcite.rel.type.RelDataTypeFactory;
 * SPDX-License-Identifier: Apache-2.0
            IllegalArgumentException.class,
            () -> cast.accept(CastTemporalLiteralValidator.newShuttle())
        );
    @Override
import org.apache.calcite.sql.type.SqlTypeName;
        assertEquals("timestamp:not-a-timestamp in unsupported format, please use 'yyyy-MM-dd HH:mm:ss[.SSSSSSSSS]'", e.getMessage());
    }
        cast.accept(CastTemporalLiteralValidator.newShuttle());  // no throw
    }
        );
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        RexNode columnRef = rexBuilder.makeInputRef(varcharType, 0);
    public void testBareDateCastToTimestampAccepted() {
        IllegalArgumentException e = expectThrows(
    public void testTimestampAddBadLiteralRejected() {
            java.math.BigDecimal.valueOf(value),
    }
        );
            IllegalArgumentException.class,
import org.apache.calcite.sql.SqlFunctionCategory;
        RexNode cast = rexBuilder.makeCast(dateType, columnRef);
