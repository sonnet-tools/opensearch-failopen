        );
        ReturnTypes.BOOLEAN,
            operands.add(paramMap);
        assertVerbatimPattern("che*k");
import org.opensearch.analytics.spi.FieldStorageInfo;
import org.opensearch.index.query.QueryBuilder;
        SqlKind.OTHER_FUNCTION,
     * with the documented message containing the function name.
    public void setUp() throws Exception {
     * Literal backslash in a Windows path: {@code C:\Users} must arrive unchanged.
import org.apache.calcite.sql.SqlKind;
            rexBuilder.makeLiteral("test*")
        }
    }
        for (Map.Entry<String, String> entry : params.entrySet()) {
    /**
            assertEquals("Pattern must be passed verbatim", pattern, wildcardQb.value());
    }
     * Verifies that a malformed operand list (missing 'field') raises IllegalArgumentException
            assertTrue("case_insensitive must be true", wildcardQb.caseInsensitive());
     * Verifies that the rewrite parameter is applied to WildcardQueryBuilder when passed as a MAP operand.
     * no SQL-to-Lucene conversion occurs (they must NOT become {@code *} and {@code ?}).
     * Verifies case_insensitive param is threaded through to WildcardQueryBuilder.
        }
        }
import org.apache.calcite.sql.SqlFunction;
        null,
    }
     */
 * SPDX-License-Identifier: Apache-2.0
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    );
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        typeFactory = new JavaTypeFactoryImpl();
        assertVerbatimPattern("C:\\Users");
 * this file be licensed under the Apache-2.0 license or a
    /**
import org.opensearch.core.common.io.stream.StreamInput;
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(
            assertEquals("che*k", wildcardQb.value());
            assertEquals("title", wildcardQb.fieldName());
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        List<RexNode> operands = new ArrayList<>();
    private RexCall buildWildcardDslCall(String fieldName, String queryText, Map<String, String> params) {
        byte[] serialized = serializer.serialize(call, fieldStorage);
 * compatible open source license.
        rexBuilder = new RexBuilder(typeFactory);
        serializer = new WildcardQueryDslSerializer();
                SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    public void testSqlWildcardCharsRemainLiteralNoConversion() throws IOException {
     * Lucene multi-char wildcard: {@code che*k} must arrive unchanged — no conversion to SQL {@code %}.
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) deserialized;
        byte[] serialized = serializer.serialize(call, fieldStorage);
        );
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
    public void testCaseInsensitiveParamIsApplied() throws IOException {
        operands.add(queryMap);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
    /**
    /**
            assertEquals("title", wildcardQb.fieldName());
        assertVerbatimPattern("100%_complete");
                rexBuilder.makeLiteral(entry.getValue())
     */
        RexNode queryMap = rexBuilder.makeCall(
            rexBuilder.makeLiteral("field"),
    private WildcardQueryDslSerializer serializer;
    public void testRewriteParameterAppliedToBuilder() throws IOException {
        OperandTypes.ANY,
        List<FieldStorageInfo> fieldStorage = List.of(
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    );
        List<FieldStorageInfo> fieldStorage = List.of(
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
        super.setUp();
        RexCall call = (RexCall) rexBuilder.makeCall(WILDCARD_QUERY_DSL_FUNCTION, queryMap);
/**
        }
    /**
    public void testThrowsOnMissingFieldOperand() {
            assertTrue("Must produce WildcardQueryBuilder", deserialized instanceof WildcardQueryBuilder);
import org.apache.calcite.sql.type.ReturnTypes;
            );
        assertVerbatimPattern("ch?ck");
import org.apache.calcite.rel.type.RelDataTypeFactory;
    private static final SqlFunction WILDCARD_QUERY_DSL_FUNCTION = new SqlFunction(
        List.of(new NamedWriteableRegistry.Entry(QueryBuilder.class, WildcardQueryBuilder.NAME, WildcardQueryBuilder::new))
     * Escaped literal star: {@code a\*b} must arrive unchanged — the backslash-star is a Lucene escape
            RexNode paramMap = rexBuilder.makeCall(
public class WildcardQueryDslSerializerTests extends OpenSearchTestCase {
        );
            rexBuilder.makeLiteral("query"),
import org.apache.calcite.rex.RexCall;
    /**
import org.apache.calcite.rex.RexBuilder;
    }
    private RexBuilder rexBuilder;
        return (RexCall) rexBuilder.makeCall(WILDCARD_QUERY_DSL_FUNCTION, operands);
                rexBuilder.makeLiteral(entry.getKey()),
        RexCall call = buildWildcardDslCall("title", pattern, Map.of());
     * Lucene single-char wildcard: {@code ch?ck} must arrive unchanged — no conversion to SQL {@code _}.
    /**
     */
     */
import org.apache.calcite.rex.RexNode;
        List<FieldStorageInfo> fieldStorage = List.of();
    }
 */
}
    }
        );
import java.util.Map;
import org.opensearch.analytics.spi.FieldType;
    /**
 *
        );
            rexBuilder.makeLiteral(queryText)
    private void assertVerbatimPattern(String pattern) throws IOException {
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    }
        List<FieldStorageInfo> fieldStorage = List.of(
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        assertVerbatimPattern("a\\*b");
    @Override
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
     * Pattern containing SQL wildcard characters {@code %} and {@code _} as literals — proves
            rexBuilder.makeLiteral("query"),
        RexNode queryMap = rexBuilder.makeCall(
        SqlFunctionCategory.USER_DEFINED_FUNCTION
 */
        RexCall call = buildWildcardDslCall("title", "che*k", Map.of("case_insensitive", "true"));
            rexBuilder.makeInputRef(varcharType, 0)
     */
     */
 * Tests for {@link WildcardQueryDslSerializer} — proves Lucene patterns are passed verbatim with no SQL conversion.
        RexNode fieldMap = rexBuilder.makeCall(
     */
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
/*
     */
        assertTrue("Message must contain 'wildcard_query_dsl', got: " + ex.getMessage(), ex.getMessage().contains("wildcard_query_dsl"));
import org.opensearch.index.query.WildcardQueryBuilder;
            assertEquals("constant_score", wildcardQb.rewrite());
 * The OpenSearch Contributors require contributions made to
            assertEquals("title", wildcardQb.fieldName());
    }
package org.opensearch.be.lucene.serializers;
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
import java.util.List;
    private RelDataTypeFactory typeFactory;
import org.apache.calcite.sql.type.OperandTypes;
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        byte[] serialized = serializer.serialize(call, fieldStorage);
import org.apache.calcite.rel.type.RelDataType;
import org.opensearch.test.OpenSearchTestCase;
    }
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> serializer.serialize(call, fieldStorage));
            assertEquals("che*k", wildcardQb.value());
    }
import org.apache.calcite.sql.SqlFunctionCategory;
    public void testLuceneStarPatternPassedVerbatim() throws IOException {
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import java.util.ArrayList;
        RexCall call = buildWildcardDslCall("title", "che*k", Map.of("rewrite", "constant_score"));
     * for a literal star, not an SQL percent.
    }
        "WILDCARD_QUERY_DSL",
        );
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
import java.io.IOException;
    // ── Helpers ─────────────────────────────────────────────────────────────────
        operands.add(fieldMap);
    public void testLuceneQuestionMarkPatternPassedVerbatim() throws IOException {
import org.apache.calcite.sql.type.SqlTypeName;
    public void testEscapedLiteralStarPassedVerbatim() throws IOException {
    public void testLiteralBackslashPassedVerbatim() throws IOException {
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
