import org.apache.calcite.rex.RexBuilder;
            ReturnTypes.VARCHAR_NULLABLE,
                return "j";
        }
 * adapter does not inspect arguments. Return type is preserved from the
            List<RexNode> rewritten = new ArrayList<>(userArgs.size() * 3 / 2);
            SqlFunctionCategory.STRING
            null,
            SqlFunctionCategory.STRING
    }
        }
            "json_array_length",
        JsonAdapter() {
     *
    /**
            for (int i = 0; i < userArgs.size(); i += 2) {
        }
import org.opensearch.analytics.spi.ScalarFunctionAdapter;
            SqlKind.OTHER_FUNCTION,
     * {@code MAP<VARCHAR, VARCHAR>} keyed by dot-separated path; non-object /
            SqlKind.OTHER_FUNCTION,
            OperandTypes.VARIADIC,
            "json_extract_all",
    }
     * literal so the Rust UDF can recover the original Calcite type when emitting JSON
    private static RexNode castToVarchar(RexBuilder rexBuilder, RelDataType varchar, RexNode operand) {
     * {@link org.apache.calcite.sql.SqlPostfixOperator} named {@code "IS JSON VALUE"},
            SqlKind.OTHER_FUNCTION,
    }
            RelDataType varchar = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
            SqlFunctionCategory.STRING
            ReturnTypes.VARCHAR_NULLABLE,
import org.apache.calcite.sql.type.SqlTypeName;
            // Key/value pairs. Even index = key (always cast to VARCHAR);
    }
            }
        );
    /** {@code JSON_APPEND(value, path1, val1, [path2, val2, ...])} — push-only onto array-valued targets; non-array / missing targets are no-ops. */
            SqlFunctionCategory.STRING
            null,
    /** {@code JSON_EXTRACT(value, path1, [path2, ...])} — single path → stringified match; multi-path → JSON-array wrap with {@code null} slots for misses. */
 * <p>Each {@code LOCAL_*_OP} must also be registered in
        JsonSetAdapter() {
    static class JsonObjectAdapter implements ScalarFunctionAdapter {
        JsonArrayLengthAdapter() {
            SqlFunctionCategory.STRING
        }
     * type so {@link AbstractNameMappingAdapter#adapt} preserves it unchanged.
     * Drop the leading {@link org.apache.calcite.sql.SqlJsonConstructorNullClause}
import org.apache.calcite.sql.type.OperandTypes;
            }
            OperandTypes.STRING,
     *
import org.apache.calcite.rex.RexCall;
     * calls. Calcite emits the flag as a {@code RexLiteral} of {@code SYMBOL} kind;
            List<RexNode> userArgs = stripLeadingFlag(original.getOperands());
            SqlFunctionCategory.STRING
            // odd index = value (tag + cast).
     * the Rust UDF's per-value emission rule (number unquoted, bool unquoted,
        static final SqlOperator LOCAL_JSON_EXTRACT_OP = new SqlFunction(
                rewritten.add(castToVarchar(rexBuilder, varchar, value));
            ReturnTypes.INTEGER_NULLABLE,
                RexNode key = userArgs.get(i);
            }
 * Container for PPL JSON-function scalar adapters. Each inner class is a plain
            null,
    static class JsonExtractAdapter extends AbstractNameMappingAdapter {
     * not recognise. The adapter rewrites it to a locally-declared {@code json_valid}
            "json_object",
 * original PPL call by {@link AbstractNameMappingAdapter#adapt}, matching the
/**
    static class JsonValidAdapter extends AbstractNameMappingAdapter {
 * {@link SqlOperator} whose name matches the corresponding Rust UDF at
     * {@link ReturnTypes#BOOLEAN_NULLABLE} matches the postfix operator's declared
        static final SqlOperator LOCAL_JSON_EXTRACT_ALL_OP = new SqlFunction(
            ReturnTypes.VARCHAR_NULLABLE,
    }
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
                if (i + 1 < userArgs.size()) {
     */
            return operands.subList(1, operands.size());
        );
            super(LOCAL_JSON_KEYS_OP, List.of(), List.of());
import java.util.List;
            SqlKind.OTHER_FUNCTION,
            null,
        if (operands.isEmpty()) return operands;
            super(LOCAL_JSON_APPEND_OP, List.of(), List.of());
     * nested-JSON-result quoted-and-escaped, plain string quoted).
        return rexBuilder.makeCast(varchar, operand, true, false);
        );
        return "s";
     * with a leading {@code SqlJsonConstructorNullClause.NULL_ON_NULL} flag operand
            for (RexNode value : userArgs) {
            return rexBuilder.makeCall(original.getType(), LOCAL_JSON_OBJECT_OP, rewritten);
            OperandTypes.STRING,
     * top-level scalar / null / empty / whitespace inputs → NULL map; malformed
        );
import org.apache.calcite.sql.SqlFunctionCategory;
     * prepended to the user args. This adapter strips that flag, casts every key + value
     *
final class JsonFunctionAdapters {
 * {@code rust/src/udf/<name>.rs}. All validation (malformed JSON, malformed
 * {@code *_FORCE_NULLABLE} declaration on the legacy {@code Json*FunctionImpl}.
    /** {@code JSON_DELETE(value, path1, [path2, ...])} — remove PPL-path matches; missing paths are no-ops. */
        }
    static class JsonArrayAdapter implements ScalarFunctionAdapter {
            SqlFunctionCategory.STRING
 *
import org.opensearch.analytics.spi.FieldStorageInfo;
     * FALSE on malformed input, NULL on NULL input.
            ReturnTypes.VARCHAR_NULLABLE,
    }
     * shape passed to {@link #LOCAL_JSON_OBJECT_OP}: {@code [k1, tag1, v1, k2, tag2, v2, ...]}.
        JsonExtendAdapter() {
    /** {@code JSON_EXTEND(value, path1, val1, [path2, val2, ...])} — spread-or-append: JSON-array values are spread element-wise; otherwise the whole value is pushed as one string element. */
            SqlKind.OTHER_FUNCTION,
     */
        }
    static class JsonSetAdapter extends AbstractNameMappingAdapter {
            OperandTypes.STRING,
    static class JsonExtractAllAdapter extends AbstractNameMappingAdapter {
        );
        @Override
import java.util.ArrayList;
    }
     * — {@link AbstractNameMappingAdapter#adapt} preserves the original PPL
import org.apache.calcite.sql.SqlFunction;
    static class JsonAdapter extends AbstractNameMappingAdapter {
            List<RexNode> rewritten = new ArrayList<>(userArgs.size() * 2);
package org.opensearch.be.datafusion;
    }
import org.apache.calcite.rex.RexNode;
            null,
        static final SqlOperator LOCAL_JSON_ARRAY_OP = new SqlFunction(
            null,
    }
            null,
            List<RexNode> userArgs = stripLeadingFlag(original.getOperands());
                    rewritten.add(rexBuilder.makeLiteral(typeTag(value), varchar, true));
        static final SqlOperator LOCAL_JSON_SET_OP = new SqlFunction(
        }
     * {@code [tag1, v1, tag2, v2, ...]}.
    /** {@code JSON_ARRAY_LENGTH(value)} → length of a JSON array; NULL on non-array / malformed input. */
    static class JsonAppendAdapter extends AbstractNameMappingAdapter {
     * this method removes that single leading literal if present, leaving the
    /**
            null,
    /** {@code JSON(s)} — round-trip parse a JSON string; NULL on malformed input. */
     * {@code JSON_OBJECT(k1, v1, k2, v2, ...)} — JSON-object constructor.
            ReturnTypes.BOOLEAN_NULLABLE,
     * (MySQL, SQL Server, Snowflake, Trino, DuckDB). Return type
            return rexBuilder.makeCall(original.getType(), LOCAL_JSON_ARRAY_OP, rewritten);
            SqlKind.OTHER_FUNCTION,
     *
 *
            OperandTypes.VARIADIC,
import org.apache.calcite.sql.SqlOperator;
        public RexNode adapt(RexCall original, List<FieldStorageInfo> fieldStorage, RelOptCluster cluster) {
     * which isthmus cannot serialise (no Substrait mapping) and DataFusion does
 * this file be licensed under the Apache-2.0 license or a
    /** {@code JSON_KEYS(value)} → JSON-array-encoded top-level keys; NULL on non-object / malformed input. */
            SqlFunctionCategory.STRING
    static class JsonDeleteAdapter extends AbstractNameMappingAdapter {
import org.apache.calcite.sql.type.ReturnTypes;
        if (SqlTypeFamily.CHARACTER.contains(operand.getType())) {
    /** Insert a CAST-to-VARCHAR if the operand isn't already character-typed. */
            super(LOCAL_JSON_EXTRACT_ALL_OP, List.of(), List.of());
            super(LOCAL_JSON_SET_OP, List.of(), List.of());
            SqlFunctionCategory.STRING
}
            super(LOCAL_JSON_EXTEND_OP, List.of(), List.of());
            if (op.equals("json_object") || op.equals("json_array") || op.equals("json")) {
            super(LOCAL_JSON_OP, List.of(), List.of());
            OperandTypes.VARIADIC,
        );
            RexBuilder rexBuilder = cluster.getRexBuilder();
    private static List<RexNode> stripLeadingFlag(List<RexNode> operands) {
    private static String typeTag(RexNode value) {
     * Classify an operand for the JSON_OBJECT / JSON_ARRAY tag stream. Tags drive
     */
            RelDataType varchar = cluster.getTypeFactory().createSqlType(SqlTypeName.VARCHAR);
     * ({@code if (input == null) return null}) and the official PPL doc
        );
 */
 * The OpenSearch Contributors require contributions made to
        JsonAppendAdapter() {
            OperandTypes.VARIADIC,
     * to VARCHAR (substrait variadic-consistency), and inserts a per-value type-tag
import org.apache.calcite.sql.SqlKind;
        @Override
     */
 * name-mapping rewrite from a Calcite call to a locally-declared
        if (tn == SqlTypeName.BOOLEAN) return "b";
    /**
 * SPDX-License-Identifier: Apache-2.0
     * <p>Same flag-stripping + type-tagging pattern as {@link JsonObjectAdapter}, but
            super(LOCAL_JSON_DELETE_OP, List.of(), List.of());
        );
            "json_extend",
            SqlKind.OTHER_FUNCTION,
        if (SqlTypeFamily.NUMERIC.contains(value.getType())) return "n";
            "json_append",
        static final SqlOperator LOCAL_JSON_OBJECT_OP = new SqlFunction(
            return operand;
     * <p>Null-propagating, matching Calcite {@code JsonFunctions.isJsonValue}
 * @opensearch.internal
            SqlFunctionCategory.STRING
        );
 * path, arity / pairing, any-NULL propagation) lives in the Rust UDF; the
        }
        }
                rewritten.add(castToVarchar(rexBuilder, varchar, key));
            SqlKind.OTHER_FUNCTION,
    /** {@code JSON_SET(value, path1, val1, [path2, val2, ...])} — replace-only; missing paths are no-ops (parity with legacy {@code ctx.read != null} guard). */
            null,
        JsonDeleteAdapter() {
 *
     * call's MAP RelDataType, so isthmus emits a substrait map type and the
        RexNode head = operands.get(0);
            ReturnTypes.VARCHAR_NULLABLE,
            SqlKind.OTHER_FUNCTION,
            ReturnTypes.VARCHAR_NULLABLE,
     * flag operand that {@code PPLFuncImpTable} prepends to JSON_OBJECT / JSON_ARRAY
        static final SqlOperator LOCAL_JSON_KEYS_OP = new SqlFunction(
import org.apache.calcite.rel.type.RelDataType;
     * {@code JSON_VALID(str)} → boolean; TRUE iff the input parses as JSON,
        static final SqlOperator LOCAL_JSON_APPEND_OP = new SqlFunction(
            ReturnTypes.VARCHAR_NULLABLE,
    }
            SqlFunctionCategory.STRING
        SqlTypeName tn = value.getType().getSqlTypeName();
            ReturnTypes.VARCHAR_NULLABLE,
            "json_valid",
 */
    }
                    RexNode value = userArgs.get(i + 1);
     * {@link SqlFunction} whose name matches the Rust UDF at {@code rust/src/udf/json_valid.rs}.
     * {@code JSON_ARRAY(v1, v2, ...)} — JSON-array constructor.
        );
        JsonKeysAdapter() {
/*
    /**
            super(LOCAL_JSON_EXTRACT_OP, List.of(), List.of());
     */
            RexBuilder rexBuilder = cluster.getRexBuilder();
import org.opensearch.analytics.spi.AbstractNameMappingAdapter;
 * compatible open source license.
            String op = call.getOperator().getName();
            null,
        );
        }
            SqlKind.OTHER_FUNCTION,
     * <p>Calcite lowers PPL's {@code json_object} to {@code SqlStdOperatorTable.JSON_OBJECT}
        JsonExtractAllAdapter() {
            "json_set",
            OperandTypes.STRING,
            "json",
    /**
     * (numerics unquoted, strings quoted, nested-JSON results escaped). Final operand
    }
    }
    static class JsonKeysAdapter extends AbstractNameMappingAdapter {
    private JsonFunctionAdapters() {}
        }
        static final SqlOperator LOCAL_JSON_VALID_OP = new SqlFunction(
            "json_delete",
            SqlKind.OTHER_FUNCTION,
     * (sql/docs/user/ppl/functions/json.md — "NULL input returns NULL"). This
            ReturnTypes.VARCHAR_NULLABLE,
        static final SqlOperator LOCAL_JSON_EXTEND_OP = new SqlFunction(
        }
    static class JsonExtendAdapter extends AbstractNameMappingAdapter {
        );
     * the operands here are values only (no keys). Final operand shape:
    }
     * → empty map. Matches the legacy {@code JsonExtractAllFunctionImpl} on the
            super(LOCAL_JSON_ARRAY_LENGTH_OP, List.of(), List.of());
            OperandTypes.VARIADIC,
     * is the SQL:2016 scalar-UDF convention and the majority industry contract
            null,
     * v2 / Calcite path. The locally-declared return type here is a placeholder
     * caller-supplied user operands untouched.
import org.apache.calcite.sql.type.SqlTypeFamily;
    /**
            OperandTypes.VARIADIC,
     * <p>Source PPL call uses {@code SqlStdOperatorTable.IS_JSON_VALUE} — a
     */
        static final SqlOperator LOCAL_JSON_DELETE_OP = new SqlFunction(
            SqlFunctionCategory.STRING
import org.apache.calcite.plan.RelOptCluster;
        return operands;
     * {@code JSON_EXTRACT_ALL(value)} — flatten a JSON document to a
            OperandTypes.STRING,
        if (value instanceof RexCall call) {
 * {@code FunctionMappings.s(...)} entry keyed by the UDF's name.
                }
            "json_extract",
        JsonExtractAdapter() {
        }
            ReturnTypes.VARCHAR_NULLABLE,
     * DataFusion-side substrait consumer decodes it to Arrow {@code Map<Utf8, Utf8>}.
        if (head.getType().getSqlTypeName() == SqlTypeName.SYMBOL) {
            null,
        }
    }
    static class JsonArrayLengthAdapter extends AbstractNameMappingAdapter {
            "json_array",
            super(LOCAL_JSON_VALID_OP, List.of(), List.of());
        static final SqlOperator LOCAL_JSON_OP = new SqlFunction(
        JsonValidAdapter() {
            SqlKind.OTHER_FUNCTION,
            OperandTypes.VARIADIC,
            "json_keys",
                    rewritten.add(castToVarchar(rexBuilder, varchar, value));
                rewritten.add(rexBuilder.makeLiteral(typeTag(value), varchar, true));
        static final SqlOperator LOCAL_JSON_ARRAY_LENGTH_OP = new SqlFunction(
 * {@link DataFusionFragmentConvertor#ADDITIONAL_SCALAR_SIGS} via a
        }
