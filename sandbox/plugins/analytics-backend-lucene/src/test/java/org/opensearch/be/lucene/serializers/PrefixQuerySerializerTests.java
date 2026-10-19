     */  
    }
        );
import org.apache.calcite.sql.type.SqlTypeName;
     * Verifies that a malformed operand list (missing 'field') raises IllegalArgumentException
import java.io.IOException;
import org.apache.calcite.rex.RexCall;
            rexBuilder.makeLiteral("query"),
            PrefixQueryBuilder prefixQb = (PrefixQueryBuilder) deserialized;  
import org.opensearch.analytics.spi.FieldStorageInfo;
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
    public void setUp() throws Exception {  
        );
            assertEquals(verbatimValue, prefixQb.value());
        RexCall call = buildPrefixCall("title", verbatimValue, Map.of());
        RexNode queryMap = rexBuilder.makeCall(  
 * Tests for {@link PrefixQuerySerializer} — validates verbatim value passthrough and case_insensitive param.
    /**
     * with the documented message containing the function name.  
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(  
        operands.add(queryMap);
                rexBuilder.makeLiteral(entry.getValue())
import org.apache.calcite.sql.SqlFunction;
            assertEquals("name", prefixQb.fieldName());
        typeFactory = new JavaTypeFactoryImpl();
import org.apache.calcite.sql.type.ReturnTypes;  
 * The OpenSearch Contributors require contributions made to  
                SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
    private RexBuilder rexBuilder;
            rexBuilder.makeInputRef(varcharType, 0)
    }
     * would be special in SQL LIKE or Lucene wildcard context — proving no escaping occurs.  
     */
import java.util.ArrayList;  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
        String verbatimValue = "check*it?out\\done";
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
}  
        List.of(new NamedWriteableRegistry.Entry(QueryBuilder.class, PrefixQueryBuilder.NAME, PrefixQueryBuilder::new))
public class PrefixQuerySerializerTests extends OpenSearchTestCase {
import org.apache.calcite.sql.type.OperandTypes;
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        null,
        RexCall call = buildPrefixCall("title", "lap", Map.of("rewrite", "constant_score"));
        RexNode fieldMap = rexBuilder.makeCall(
        OperandTypes.ANY,  
import org.apache.calcite.rex.RexBuilder;
package org.opensearch.be.lucene.serializers;
                rexBuilder.makeLiteral(entry.getKey()),
    // ── Helper ──────────────────────────────────────────────────────────────────
    public void testThrowsOnMissingFieldOperand() {
            rexBuilder.makeLiteral("field"),  
        );
     */
    @Override
    public void testCaseInsensitiveParamIsApplied() throws IOException {  
        RexCall call = buildPrefixCall("name", "lap", Map.of("case_insensitive", "true"));
            rexBuilder.makeLiteral(queryText)  
        RexCall call = (RexCall) rexBuilder.makeCall(PREFIX_QUERY_FUNCTION, queryMap);  
    }
            PrefixQueryBuilder prefixQb = (PrefixQueryBuilder) input.readNamedWriteable(QueryBuilder.class);  
            assertTrue("Must produce PrefixQueryBuilder", deserialized instanceof PrefixQueryBuilder);
 * this file be licensed under the Apache-2.0 license or a
            RexNode paramMap = rexBuilder.makeCall(
    /**
        List<FieldStorageInfo> fieldStorage = List.of(
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
    );
    }
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
    private RexCall buildPrefixCall(String fieldName, String queryText, Map<String, String> params) {
        List<FieldStorageInfo> fieldStorage = List.of();
        serializer = new PrefixQuerySerializer();
import org.apache.calcite.rel.type.RelDataTypeFactory;  
/**
 *
        SqlKind.OTHER_FUNCTION,  
        // Build a call with only a 'query' operand, no 'field'  
import org.opensearch.test.OpenSearchTestCase;  
        operands.add(fieldMap);
        // Value contains *, ? and backslash — must arrive unchanged at PrefixQueryBuilder  
 */  
        List<FieldStorageInfo> fieldStorage = List.of(  
import org.apache.calcite.sql.SqlKind;  
import java.util.Map;
        "PREFIX_QUERY",
        RexNode queryMap = rexBuilder.makeCall(
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
import org.apache.calcite.sql.SqlFunctionCategory;
import org.opensearch.core.common.io.stream.StreamInput;  
import java.util.List;
 */  
            rexBuilder.makeLiteral("query"),  
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
/*  
        );
        for (Map.Entry<String, String> entry : params.entrySet()) {
    public void testRewriteParameterAppliedToBuilder() throws IOException {
    /**  
        List<RexNode> operands = new ArrayList<>();  
import org.opensearch.index.query.QueryBuilder;
        byte[] serialized = serializer.serialize(call, fieldStorage);
        );
 * compatible open source license.
            new FieldStorageInfo("title", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
    }
    private PrefixQuerySerializer serializer;  
        }  
        }
import org.apache.calcite.rel.type.RelDataType;
            assertEquals("constant_score", prefixQb.rewrite());
        SqlFunctionCategory.USER_DEFINED_FUNCTION
import org.opensearch.index.query.PrefixQueryBuilder;
        List<FieldStorageInfo> fieldStorage = List.of(  
        super.setUp();
            operands.add(paramMap);
        }
    private static final SqlFunction PREFIX_QUERY_FUNCTION = new SqlFunction(
            assertEquals("title", prefixQb.fieldName());
import org.apache.calcite.rex.RexNode;  
import org.opensearch.analytics.spi.FieldType;  
            rexBuilder.makeLiteral("test")
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        rexBuilder = new RexBuilder(typeFactory);  
        ReturnTypes.BOOLEAN,
    }  
    );
            PrefixQueryBuilder prefixQb = (PrefixQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
            assertTrue("case_insensitive must be true", prefixQb.caseInsensitive());  
        return (RexCall) rexBuilder.makeCall(PREFIX_QUERY_FUNCTION, operands);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        }
    private RelDataTypeFactory typeFactory;
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            assertEquals("lap", prefixQb.value());  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        byte[] serialized = serializer.serialize(call, fieldStorage);  
            new FieldStorageInfo("name", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)  
     * Verifies that the serializer passes the prefix value verbatim — including metacharacters that
            assertEquals("title", prefixQb.fieldName());
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> serializer.serialize(call, fieldStorage));  
        byte[] serialized = serializer.serialize(call, fieldStorage);
            );  
     * Verifies that the rewrite parameter is applied to PrefixQueryBuilder when passed as a MAP operand.
    /**
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        assertTrue("Message must contain 'prefix_query', got: " + ex.getMessage(), ex.getMessage().contains("prefix_query"));
     * Verifies case_insensitive param is threaded through to the PrefixQueryBuilder.
        );
    public void testValuePassedVerbatimIncludingMetacharacters() throws IOException {
            assertEquals("lap", prefixQb.value());
     */
