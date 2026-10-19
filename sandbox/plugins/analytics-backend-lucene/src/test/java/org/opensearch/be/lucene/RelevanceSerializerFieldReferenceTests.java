        RexCall call = buildCall(List.of("title"), "title:hi AND status:1");
import org.apache.calcite.sql.SqlFunction;
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.analytics.spi.FieldReferences;
        RexCall call = buildCall(null, "foo bar");  
        }
        assertEquals(List.of("title", "status"), refs.literalFields());  
    private RelDataTypeFactory typeFactory;
import org.apache.calcite.sql.type.SqlTypeName;
        // OpenSearch query_string supports `field:>15`; Lucene's stock parser does not. On parse
}
    private RexNode fieldsOperand(List<String> fields) {
            rexBuilder.makeLiteral("query"),
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
    }
        RexCall call = buildCall(null, "value:[1 TO 5]");
        assertTrue(refs.patternTokens().isEmpty());
    public void setUp() throws Exception {  
        assertTrue(refs.literalFields().isEmpty());  
    private RexCall buildCall(List<String> fields, String queryString) {
 * classification, lenient resolution, and parse failures.  
        // Parse failed, no explicit fields → nothing for the planner to validate; fan-out resolved at execution.
    public void testQueryStringMergesExplicitAndInStringFields() {
    @Override
    // query_string parses the query string for in-string fields; simple_query_string does not.
        RexCall call = buildCall(null, "category:A");
        for (String field : fields) {
/**
    public void testQueryStringInStringFieldNoExplicitFields() {  
package org.opensearch.be.lucene;
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
    }  
    private RexNode queryOperand(String queryString) {
/*  
        return rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), nestedMap);
        return rexBuilder.makeCall(
    }
        RexCall call = buildCall(List.of("severityNumber"), "severityNumber:>15");  
        assertTrue(refs.patternTokens().isEmpty());
 */
        OperandTypes.ANY,  
    private static final SqlFunction RELEVANCE_FUNCTION = new SqlFunction(
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);  
import org.apache.calcite.rex.RexBuilder;
        assertFalse(queryStringSerializer.referencedFields(callUnset, List.of()).lenient());  
        assertEquals(List.of("severityNumber"), refs.literalFields());  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            rexBuilder.makeLiteral("lenient"),
    }
    /** Builds {@code fn(MAP('fields', ...), MAP('query', ...), MAP('lenient', 'true|false'))}. */
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        assertEquals(List.of("title", "body"), refs.literalFields());  
    public void testParseFailureFallsBackGracefully() {  
        return (RexCall) rexBuilder.makeCall(RELEVANCE_FUNCTION, fieldsOperand(fields), queryOperand(queryString), lenientMap);
        "RELEVANCE_FN",
        RexCall call = buildCall(List.of("cat*"), "hello");
 * compatible open source license.
import java.util.ArrayList;
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
        if (fields != null) {  
        assertTrue(refs.literalFields().isEmpty());
    }
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
public class RelevanceSerializerFieldReferenceTests extends OpenSearchTestCase {
            operands.add(fieldsOperand(fields));
        RexCall call = buildCall(List.of("title", "body"), "category:A");  
        assertEquals(List.of("category"), refs.literalFields());
    private RexCall buildCallWithLenient(List<String> fields, String queryString, boolean lenient) {
 *
        List<RexNode> nested = new ArrayList<>();
        ReturnTypes.BOOLEAN,
 * SPDX-License-Identifier: Apache-2.0
        return (RexCall) rexBuilder.makeCall(RELEVANCE_FUNCTION, operands.toArray(new RexNode[0]));
    public void testQueryStringExistsField() {
    public void testSimpleQueryStringIgnoresInStringSyntax() {
        assertEquals(List.of("title", "body"), refs.literalFields());
    }
        FieldReferences refs = simpleQueryStringSerializer.referencedFields(call, List.of());
import org.opensearch.test.OpenSearchTestCase;
        assertFalse("lenient defaults to false when unset (Option B)", refs.lenient());  
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
    }  
    public void testQueryStringPatternTokenNotValidatedAsLiteral() {  
        assertEquals(List.of("cat*"), refs.patternTokens());
        assertEquals(List.of("status"), refs.literalFields());  
 * (in {@code AbstractRelevanceSerializer}) across the design's Problem-statement cases: explicit
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            rexBuilder.makeLiteral(queryString)
        SqlKind.OTHER_FUNCTION,  
    }
    // ---- builders ----
            rexBuilder.makeLiteral(Boolean.toString(lenient))  
    public void testUnparseableFieldlessQueryFallsBackToFanout() {
import java.util.List;  
import org.apache.calcite.sql.SqlKind;  
        operands.add(queryOperand(queryString));  
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());  
        // failure we skip in-string extraction (no throw) and rely on explicit fields.
import org.opensearch.be.lucene.serializers.QueryStringSerializer;  
 * MAP fields, in-string fields, ranges, {@code _exists_}, default-field fan-out, pattern
    }
    private final QueryStringSerializer queryStringSerializer = new QueryStringSerializer();
    private RexBuilder rexBuilder;  
        );
        RexCall callTrue = buildCallWithLenient(List.of("intField"), "x", true);
        }
        typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.sql.type.OperandTypes;
        // title (explicit + in-string, deduped) and status (in-string), first-appearance order.
        assertTrue("pattern must not be a literal", refs.literalFields().isEmpty());
        RexCall call = buildCall(null, "title:(unbalanced");
import org.apache.calcite.sql.type.ReturnTypes;  
    );
        assertTrue(refs.patternTokens().isEmpty());
        assertFalse(queryStringSerializer.referencedFields(callFalse, List.of()).lenient());
            nested.add(rexBuilder.makeExactLiteral(new BigDecimal("1.0"), doubleType));
        RexNode lenientMap = rexBuilder.makeCall(  
 * Unit tests for the relevance serializers' {@code referencedFields} implementation  
import org.opensearch.be.lucene.serializers.SimpleQueryStringSerializer;
        null,
import java.math.BigDecimal;
import org.apache.calcite.rex.RexNode;  
    }
        );  
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
        RexCall call = buildCall(null, "_exists_:status");  
        SqlFunctionCategory.USER_DEFINED_FUNCTION
    }
 */  
    public void testQueryStringRangeField() {  
        assertEquals(List.of("value"), refs.literalFields());
    /** Builds {@code fn(MAP('fields', MAP(f1,1.0,...)), MAP('query', queryString))}; omits fields MAP when null. */  
        assertTrue(refs.patternTokens().isEmpty());
        RexCall call = buildCall(List.of("title", "body"), "hello");
    }
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());  
        // Unset → false (Option B): preserves eager rejection.
import org.apache.calcite.sql.SqlFunctionCategory;
        super.setUp();
    }  
import org.apache.calcite.rel.type.RelDataType;
        // simple_query_string has no field:value syntax; only the `fields` operand contributes.
    }
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(queryStringSerializer.referencedFields(callTrue, List.of()).lenient());
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
    public void testQueryStringFieldlessYieldsNoLiterals() {
        RexCall callFalse = buildCallWithLenient(List.of("intField"), "x", false);
    public void testQueryStringExplicitFields() {  
    }
        List<RexNode> operands = new ArrayList<>();
        RexCall callUnset = buildCall(List.of("intField"), "x");
    public void testExplicitLenientHonored() {  
        rexBuilder = new RexBuilder(typeFactory);  
    private final SimpleQueryStringSerializer simpleQueryStringSerializer = new SimpleQueryStringSerializer();  
        FieldReferences refs = queryStringSerializer.referencedFields(call, List.of());
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    }
        RexNode nestedMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, nested.toArray(new RexNode[0]));  
        // Unqualified terms fan out to default_field at execution; nothing for the planner to validate.  
            nested.add(rexBuilder.makeLiteral(field));  
import org.apache.calcite.rex.RexCall;
