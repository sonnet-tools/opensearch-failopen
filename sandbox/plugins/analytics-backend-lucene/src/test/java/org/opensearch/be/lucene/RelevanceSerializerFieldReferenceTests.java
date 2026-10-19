import org.apache.calcite.rel.type.RelDataTypeFactory;
        assertFalse(queryStringSerializer.referencedFields(callFalse, List.of()).lenient());
import org.opensearch.analytics.spi.FieldReferences;
    public void testQueryStringExplicitFields() {
    private RexCall buildCallWithLenient(List<String> fields, String queryString, boolean lenient) {
            rexBuilder.makeLiteral(Boolean.toString(lenient))
        // simple_query_string has no field:value syntax; only the `fields` operand contributes.
        assertTrue(refs.literalFields().isEmpty());
    public void setUp() throws Exception {
    public void testUnparseableFieldlessQueryFallsBackToFanout() {
 * SPDX-License-Identifier: Apache-2.0
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
import org.opensearch.test.OpenSearchTestCase;
import org.apache.calcite.sql.type.ReturnTypes;
    }
        RexCall callFalse = buildCallWithLenient(List.of("intField"), "x", false);
import org.apache.calcite.rex.RexNode;
            operands.add(fieldsOperand(fields));
/*
 *
            rexBuilder.makeLiteral("lenient"),
/**
        RexCall call = buildCall(null, "title:(unbalanced");
package org.opensearch.be.lucene;
        // Unset → false (Option B): preserves eager rejection.
        List<RexNode> nested = new ArrayList<>();
        RexCall call = buildCall(List.of("title"), "title:hi AND status:1");
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.sql.SqlKind;
import org.apache.calcite.sql.SqlFunction;
 */
        RexCall callTrue = buildCallWithLenient(List.of("intField"), "x", true);
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
        ReturnTypes.BOOLEAN,
        SqlKind.OTHER_FUNCTION,
        assertEquals(List.of("category"), refs.literalFields());
        assertEquals(List.of("title", "status"), refs.literalFields());
        assertTrue(refs.literalFields().isEmpty());
        null,
    );
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
    }
    }
    private RelDataTypeFactory typeFactory;
        RexCall call = buildCall(null, "category:A");
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
        RexCall call = buildCall(List.of("cat*"), "hello");
import org.opensearch.be.lucene.serializers.SimpleQueryStringSerializer;
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
    }
 * The OpenSearch Contributors require contributions made to
    private final SimpleQueryStringSerializer simpleQueryStringSerializer = new SimpleQueryStringSerializer();
    private RexCall buildCall(List<String> fields, String queryString) {
    }
        );
        assertTrue(queryStringSerializer.referencedFields(callTrue, List.of()).lenient());
        }
    }
        assertFalse(queryStringSerializer.referencedFields(callUnset, List.of()).lenient());
        RexCall call = buildCall(null, "foo bar");
        // title (explicit + in-string, deduped) and status (in-string), first-appearance order.
            nested.add(rexBuilder.makeLiteral(field));
    }
            rexBuilder.makeLiteral("query"),
        assertEquals(List.of("cat*"), refs.patternTokens());
        // Unqualified terms fan out to default_field at execution; nothing for the planner to validate.
    }
 * (in {@code AbstractRelevanceSerializer}) across the design's Problem-statement cases: explicit
    // ---- builders ----
    public void testQueryStringRangeField() {
        List<RexNode> operands = new ArrayList<>();
}
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
    private static final SqlFunction RELEVANCE_FUNCTION = new SqlFunction(
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
    /** Builds {@code fn(MAP('fields', MAP(f1,1.0,...)), MAP('query', queryString))}; omits fields MAP when null. */
        return (RexCall) rexBuilder.makeCall(RELEVANCE_FUNCTION, operands.toArray(new RexNode[0]));
    /** Builds {@code fn(MAP('fields', ...), MAP('query', ...), MAP('lenient', 'true|false'))}. */
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    private final QueryStringSerializer queryStringSerializer = new QueryStringSerializer();
        SqlFunctionCategory.USER_DEFINED_FUNCTION
 */
        OperandTypes.ANY,
 * Unit tests for the relevance serializers' {@code referencedFields} implementation
        RexCall callUnset = buildCall(List.of("intField"), "x");
    }
    public void testExplicitLenientHonored() {
        for (String field : fields) {
    }
    public void testSimpleQueryStringIgnoresInStringSyntax() {
import org.apache.calcite.rex.RexBuilder;
    private RexNode queryOperand(String queryString) {
        operands.add(queryOperand(queryString));
        assertTrue(refs.patternTokens().isEmpty());
    public void testParseFailureFallsBackGracefully() {
        super.setUp();
    }
import org.apache.calcite.rex.RexCall;
 * compatible open source license.
    public void testQueryStringInStringFieldNoExplicitFields() {
        assertTrue(refs.patternTokens().isEmpty());
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
    // query_string parses the query string for in-string fields; simple_query_string does not.
        "RELEVANCE_FN",
import java.math.BigDecimal;
import org.opensearch.be.lucene.serializers.QueryStringSerializer;
        return (RexCall) rexBuilder.makeCall(RELEVANCE_FUNCTION, fieldsOperand(fields), queryOperand(queryString), lenientMap);
        RexNode lenientMap = rexBuilder.makeCall(
    }
 * this file be licensed under the Apache-2.0 license or a
        rexBuilder = new RexBuilder(typeFactory);
    @Override
        assertTrue(refs.patternTokens().isEmpty());
        assertEquals(List.of("severityNumber"), refs.literalFields());
            rexBuilder.makeLiteral(queryString)
        FieldReferences refs = simpleQueryStringSerializer.referencedFields(call, List.of());
 * MAP fields, in-string fields, ranges, {@code _exists_}, default-field fan-out, pattern
    }
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
        RexCall call = buildCall(List.of("title", "body"), "category:A");
    }
        assertEquals(List.of("status"), refs.literalFields());
import java.util.List;
    }
        assertTrue(refs.patternTokens().isEmpty());
    public void testQueryStringExistsField() {
        }
        // OpenSearch query_string supports `field:>15`; Lucene's stock parser does not. On parse
    public void testQueryStringPatternTokenNotValidatedAsLiteral() {
        assertEquals(List.of("title", "body"), refs.literalFields());
        assertEquals(List.of("value"), refs.literalFields());
        RexCall call = buildCall(List.of("title", "body"), "hello");
import java.util.ArrayList;
    private RexBuilder rexBuilder;
        typeFactory = new JavaTypeFactoryImpl();
        if (fields != null) {
        assertEquals(List.of("title", "body"), refs.literalFields());
    private RexNode fieldsOperand(List<String> fields) {
        RexCall call = buildCall(null, "value:[1 TO 5]");
import org.apache.calcite.rel.type.RelDataType;
        // Parse failed, no explicit fields → nothing for the planner to validate; fan-out resolved at execution.
        assertTrue("pattern must not be a literal", refs.literalFields().isEmpty());
import org.apache.calcite.sql.type.OperandTypes;
import org.apache.calcite.sql.SqlFunctionCategory;
        RexCall call = buildCall(null, "_exists_:status");
public class RelevanceSerializerFieldReferenceTests extends OpenSearchTestCase {
        // failure we skip in-string extraction (no throw) and rely on explicit fields.
    public void testQueryStringFieldlessYieldsNoLiterals() {
    public void testQueryStringMergesExplicitAndInStringFields() {
        RexCall call = buildCall(List.of("severityNumber"), "severityNumber:>15");
        assertFalse("lenient defaults to false when unset (Option B)", refs.lenient());
            nested.add(rexBuilder.makeExactLiteral(new BigDecimal("1.0"), doubleType));
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexNode nestedMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, nested.toArray(new RexNode[0]));
        );
import org.apache.calcite.sql.type.SqlTypeName;
    }
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
 * classification, lenient resolution, and parse failures.
        return rexBuilder.makeCall(
        return rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), nestedMap);
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
