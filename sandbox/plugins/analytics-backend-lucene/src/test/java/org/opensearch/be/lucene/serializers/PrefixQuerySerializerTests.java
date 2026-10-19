/*
import org.apache.calcite.sql.SqlFunctionCategory;
        byte[] serialized = serializer.serialize(call, fieldStorage);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            assertTrue("case_insensitive must be true", prefixQb.caseInsensitive());
    /**
            assertEquals("name", prefixQb.fieldName());
        return (RexCall) rexBuilder.makeCall(PREFIX_QUERY_FUNCTION, operands);
        serializer = new PrefixQuerySerializer();
import org.apache.calcite.sql.type.SqlTypeName;
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        for (Map.Entry<String, String> entry : params.entrySet()) {
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     * Verifies that the serializer passes the prefix value verbatim — including metacharacters that
            rexBuilder.makeLiteral("field"),
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(
                SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
                rexBuilder.makeLiteral(entry.getKey()),
        RexCall call = buildPrefixCall("title", verbatimValue, Map.of());
import java.util.Map;
import org.opensearch.index.query.PrefixQueryBuilder;
        RexNode queryMap = rexBuilder.makeCall(
     */
        );
     */
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> serializer.serialize(call, fieldStorage));
    );
        RexNode queryMap = rexBuilder.makeCall(
import org.opensearch.analytics.spi.FieldStorageInfo;
     * Verifies that the rewrite parameter is applied to PrefixQueryBuilder when passed as a MAP operand.
            RexNode paramMap = rexBuilder.makeCall(
        }
    public void testRewriteParameterAppliedToBuilder() throws IOException {
        }
            PrefixQueryBuilder prefixQb = (PrefixQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
 *
                rexBuilder.makeLiteral(entry.getValue())
            assertEquals("title", prefixQb.fieldName());
    public void testCaseInsensitiveParamIsApplied() throws IOException {
public class PrefixQuerySerializerTests extends OpenSearchTestCase {
}
    public void testValuePassedVerbatimIncludingMetacharacters() throws IOException {
import org.apache.calcite.sql.SqlKind;
            );
import org.apache.calcite.rex.RexCall;
    }
    /**
        OperandTypes.ANY,
    public void setUp() throws Exception {
        }
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
            rexBuilder.makeInputRef(varcharType, 0)
            assertEquals(verbatimValue, prefixQb.value());
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            rexBuilder.makeLiteral("test")
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
import org.apache.calcite.sql.type.OperandTypes;
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
import org.apache.calcite.rel.type.RelDataType;
            assertEquals("lap", prefixQb.value());
import java.util.List;
import org.apache.calcite.rex.RexNode;
 * The OpenSearch Contributors require contributions made to
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    private static final SqlFunction PREFIX_QUERY_FUNCTION = new SqlFunction(
            PrefixQueryBuilder prefixQb = (PrefixQueryBuilder) deserialized;
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    // ── Helper ──────────────────────────────────────────────────────────────────
        super.setUp();
     * with the documented message containing the function name.
        // Build a call with only a 'query' operand, no 'field'
    }
        );
    private RexCall buildPrefixCall(String fieldName, String queryText, Map<String, String> params) {
 */
        );
            assertTrue("Must produce PrefixQueryBuilder", deserialized instanceof PrefixQueryBuilder);
import java.util.ArrayList;
package org.opensearch.be.lucene.serializers;
            rexBuilder.makeLiteral("query"),
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            rexBuilder.makeLiteral("query"),
            assertEquals("title", prefixQb.fieldName());
        null,
import org.apache.calcite.sql.SqlFunction;
            rexBuilder.makeLiteral(queryText)
    @Override
        typeFactory = new JavaTypeFactoryImpl();
     * Verifies that a malformed operand list (missing 'field') raises IllegalArgumentException
 */
        rexBuilder = new RexBuilder(typeFactory);
        List<FieldStorageInfo> fieldStorage = List.of(
    }
        );
     */
    }
import org.opensearch.test.OpenSearchTestCase;
    }
     * would be special in SQL LIKE or Lucene wildcard context — proving no escaping occurs.
/**
        SqlKind.OTHER_FUNCTION,
        }
        RexNode fieldMap = rexBuilder.makeCall(
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        operands.add(fieldMap);
        RexCall call = buildPrefixCall("name", "lap", Map.of("case_insensitive", "true"));
     */
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.io.stream.StreamInput;
        );
 * SPDX-License-Identifier: Apache-2.0
            assertEquals("lap", prefixQb.value());
import org.apache.calcite.sql.type.ReturnTypes;
        List<FieldStorageInfo> fieldStorage = List.of(
        List.of(new NamedWriteableRegistry.Entry(QueryBuilder.class, PrefixQueryBuilder.NAME, PrefixQueryBuilder::new))
        List<FieldStorageInfo> fieldStorage = List.of(
import org.apache.calcite.rel.type.RelDataTypeFactory;
        List<RexNode> operands = new ArrayList<>();
        operands.add(queryMap);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        );
        RexCall call = (RexCall) rexBuilder.makeCall(PREFIX_QUERY_FUNCTION, queryMap);
        byte[] serialized = serializer.serialize(call, fieldStorage);
import java.io.IOException;
import org.opensearch.analytics.spi.FieldType;
 * Tests for {@link PrefixQuerySerializer} — validates verbatim value passthrough and case_insensitive param.
    }
    private RelDataTypeFactory typeFactory;
import org.opensearch.index.query.QueryBuilder;
            PrefixQueryBuilder prefixQb = (PrefixQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        RexCall call = buildPrefixCall("title", "lap", Map.of("rewrite", "constant_score"));
        byte[] serialized = serializer.serialize(call, fieldStorage);
        "PREFIX_QUERY",
        List<FieldStorageInfo> fieldStorage = List.of();
    );
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
            assertEquals("constant_score", prefixQb.rewrite());
    /**
        assertTrue("Message must contain 'prefix_query', got: " + ex.getMessage(), ex.getMessage().contains("prefix_query"));
    private PrefixQuerySerializer serializer;
            new FieldStorageInfo("name", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
            operands.add(paramMap);
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
import org.apache.calcite.rex.RexBuilder;
 * compatible open source license.
    /**
        ReturnTypes.BOOLEAN,
        String verbatimValue = "check*it?out\\done";
     * Verifies case_insensitive param is threaded through to the PrefixQueryBuilder.
        // Value contains *, ? and backslash — must arrive unchanged at PrefixQueryBuilder
    public void testThrowsOnMissingFieldOperand() {
    private RexBuilder rexBuilder;
