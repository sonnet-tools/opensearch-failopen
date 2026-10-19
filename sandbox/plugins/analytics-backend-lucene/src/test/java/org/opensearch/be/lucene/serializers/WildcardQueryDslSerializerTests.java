        RexCall call = buildWildcardDslCall("title", "che*k", Map.of("case_insensitive", "true"));  
/*  
            );  
public class WildcardQueryDslSerializerTests extends OpenSearchTestCase {
import org.apache.calcite.sql.type.SqlTypeName;
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
        );  
            assertEquals("che*k", wildcardQb.value());
    public void testRewriteParameterAppliedToBuilder() throws IOException {
     * Lucene multi-char wildcard: {@code che*k} must arrive unchanged — no conversion to SQL {@code %}.
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testLiteralBackslashPassedVerbatim() throws IOException {
     * no SQL-to-Lucene conversion occurs (they must NOT become {@code *} and {@code ?}).
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        );  
            operands.add(paramMap);
        super.setUp();
     */  
import org.opensearch.analytics.spi.FieldStorageInfo;
     * Pattern containing SQL wildcard characters {@code %} and {@code _} as literals — proves
 *
    public void testLuceneQuestionMarkPatternPassedVerbatim() throws IOException {
        assertVerbatimPattern("ch?ck");  
            assertEquals("title", wildcardQb.fieldName());  
        assertVerbatimPattern("100%_complete");
     * Literal backslash in a Windows path: {@code C:\Users} must arrive unchanged.  
     * Escaped literal star: {@code a\*b} must arrive unchanged — the backslash-star is a Lucene escape
        List<FieldStorageInfo> fieldStorage = List.of();
        byte[] serialized = serializer.serialize(call, fieldStorage);
    /**
        for (Map.Entry<String, String> entry : params.entrySet()) {
    }
                rexBuilder.makeLiteral(entry.getValue())
 * Tests for {@link WildcardQueryDslSerializer} — proves Lucene patterns are passed verbatim with no SQL conversion.
 * compatible open source license.
 */  
        assertTrue("Message must contain 'wildcard_query_dsl', got: " + ex.getMessage(), ex.getMessage().contains("wildcard_query_dsl"));
    }
        List<FieldStorageInfo> fieldStorage = List.of(
            assertEquals("constant_score", wildcardQb.rewrite());
        RexNode queryMap = rexBuilder.makeCall(  
import org.apache.calcite.rex.RexNode;  
    );
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.index.query.WildcardQueryBuilder;
            rexBuilder.makeInputRef(varcharType, 0)
    public void testSqlWildcardCharsRemainLiteralNoConversion() throws IOException {
    /**  
        assertVerbatimPattern("C:\\Users");  
import org.apache.calcite.sql.SqlFunction;
import org.opensearch.index.query.QueryBuilder;
import java.util.ArrayList;  
import org.apache.calcite.sql.type.ReturnTypes;  
        }  
 * this file be licensed under the Apache-2.0 license or a
    private static final SqlFunction WILDCARD_QUERY_DSL_FUNCTION = new SqlFunction(
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeLiteral("field"),  
     */  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
/**
            assertEquals("title", wildcardQb.fieldName());  
        RexCall call = buildWildcardDslCall("title", pattern, Map.of());  
    public void testCaseInsensitiveParamIsApplied() throws IOException {
    }  
import java.io.IOException;
        OperandTypes.ANY,  
    /**  
 */  
    }
    public void testThrowsOnMissingFieldOperand() {
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
import org.opensearch.analytics.spi.FieldType;  
     */  
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
import org.apache.calcite.rex.RexBuilder;
import org.apache.calcite.rel.type.RelDataType;
}  
import java.util.List;
     */
        return (RexCall) rexBuilder.makeCall(WILDCARD_QUERY_DSL_FUNCTION, operands);
     */
import org.opensearch.core.common.io.stream.StreamInput;  
    public void testLuceneStarPatternPassedVerbatim() throws IOException {
    }
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
    );
     * for a literal star, not an SQL percent.
    /**
 * SPDX-License-Identifier: Apache-2.0
        null,
                rexBuilder.makeLiteral(entry.getKey()),
    /**
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        }
        );  
            rexBuilder.makeLiteral("query"),
import org.apache.calcite.sql.type.OperandTypes;
    // ── Helpers ─────────────────────────────────────────────────────────────────  
        operands.add(queryMap);
import org.apache.calcite.sql.SqlKind;  
        );
    }  
        "WILDCARD_QUERY_DSL",
        RexNode fieldMap = rexBuilder.makeCall(
import java.util.Map;
     * Verifies that the rewrite parameter is applied to WildcardQueryBuilder when passed as a MAP operand.  
        assertVerbatimPattern("a\\*b");
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            assertEquals("che*k", wildcardQb.value());
        serializer = new WildcardQueryDslSerializer();
        typeFactory = new JavaTypeFactoryImpl();
        RexCall call = (RexCall) rexBuilder.makeCall(WILDCARD_QUERY_DSL_FUNCTION, queryMap);
    /**  
 * The OpenSearch Contributors require contributions made to  
    public void setUp() throws Exception {  
        List<FieldStorageInfo> fieldStorage = List.of(
     * Verifies that a malformed operand list (missing 'field') raises IllegalArgumentException
    }  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
            assertEquals("Pattern must be passed verbatim", pattern, wildcardQb.value());  
        }  
        SqlKind.OTHER_FUNCTION,  
        rexBuilder = new RexBuilder(typeFactory);  
            rexBuilder.makeLiteral("query"),
        byte[] serialized = serializer.serialize(call, fieldStorage);
    }
                SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
     * with the documented message containing the function name.
    private void assertVerbatimPattern(String pattern) throws IOException {
        RexCall call = buildWildcardDslCall("title", "che*k", Map.of("rewrite", "constant_score"));  
import org.apache.calcite.sql.SqlFunctionCategory;
    /**
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    /**
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> serializer.serialize(call, fieldStorage));
package org.opensearch.be.lucene.serializers;
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(  
     */
            rexBuilder.makeLiteral(queryText)  
    }
     * Verifies case_insensitive param is threaded through to WildcardQueryBuilder.  
    private RelDataTypeFactory typeFactory;
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
            rexBuilder.makeLiteral("test*")
        List<RexNode> operands = new ArrayList<>();  
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) deserialized;
    @Override
        operands.add(fieldMap);
            assertTrue("Must produce WildcardQueryBuilder", deserialized instanceof WildcardQueryBuilder);  
            assertEquals("title", wildcardQb.fieldName());
    }
    private WildcardQueryDslSerializer serializer;  
        );  
        assertVerbatimPattern("che*k");
import org.apache.calcite.rex.RexCall;
        );
     */  
            assertTrue("case_insensitive must be true", wildcardQb.caseInsensitive());
        List.of(new NamedWriteableRegistry.Entry(QueryBuilder.class, WildcardQueryBuilder.NAME, WildcardQueryBuilder::new))
     * Lucene single-char wildcard: {@code ch?ck} must arrive unchanged — no conversion to SQL {@code _}.  
    private RexBuilder rexBuilder;
import org.apache.calcite.rel.type.RelDataTypeFactory;  
        ReturnTypes.BOOLEAN,
    }  
        List<FieldStorageInfo> fieldStorage = List.of(
        byte[] serialized = serializer.serialize(call, fieldStorage);
        RexNode queryMap = rexBuilder.makeCall(
    private RexCall buildWildcardDslCall(String fieldName, String queryText, Map<String, String> params) {
            RexNode paramMap = rexBuilder.makeCall(
     */
    public void testEscapedLiteralStarPassedVerbatim() throws IOException {
        }
