            // Build an expected builder with ALL flag to verify equality
        byte[] serialized = serializer.serialize(call, fieldStorage);
        for (String field : fields) {  
    }  
     * Tests WildcardQuerySerializer silently ignores unrecognized params.
        String fieldName,
            new FieldStorageInfo("body", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
            assertEquals("search text", multiMatch.value());
        List<FieldStorageInfo> fieldStorage = List.of(
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);  
            );  
        Map<String, String> optionalParams
        }
        assertNotNull("EQUALS serializer must be registered", serializer);
            assertEquals("title", wildcardQb.fieldName());
            assertEquals(2, matchPhrase.slop());
            MultiMatchQueryBuilder multiMatch = (MultiMatchQueryBuilder) deserialized;
        byte[] serialized = serializer.serialize(call, fieldStorage);
     * Tests that serializeMatch with operator=AND produces a MatchQueryBuilder with AND operator.
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
    }  
        }  
     * Tests MatchAllSerializer serialize → deserialize produces MatchAllQueryBuilder.
    }  
    }
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        );  
            assertEquals("F", term.value());
    /**
            assertEquals(Operator.AND, queryStringQb.defaultOperator());
            rexBuilder.makeLiteral("query"),  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_PHRASE);  
        String functionName,
 *
        // Query MAP: MAP('query', 'text')  
        byte[] serialized = serializer.serialize(call, fieldStorage);
        RexNode queryMap = rexBuilder.makeCall(
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            new FieldStorageInfo("body", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
            assertTrue(deserialized instanceof QueryStringQueryBuilder);
        RexCall call = buildSingleFieldRexCallWithParams("title", "%foo\\_bar_", "WILDCARD_QUERY", Map.of());
            assertEquals(expected, simpleQsQb);  
import org.opensearch.index.query.QueryStringQueryBuilder;  
            new FieldStorageInfo("gender", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false, "keyword")  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);  
        );  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
            assertEquals("title", matchBoolPrefix.fieldName());
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MULTI_MATCH);  
            new NamedWriteableRegistry.Entry(QueryBuilder.class, SimpleQueryStringBuilder.NAME, SimpleQueryStringBuilder::new),  
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
        RexNode nestedMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, nestedMapOperands);
     * Tests that lenient=true round-trips correctly on MatchQueryBuilder.  
        List<FieldStorageInfo> fieldStorage = List.of(
    /**  
    public void setUp() throws Exception {  
        RexCall call = buildMultiFieldRexCallWithParams(
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);  
            assertEquals("search text", queryString.queryString());
        }
            nestedMapOperands.add(rexBuilder.makeExactLiteral(new java.math.BigDecimal("1.0"), doubleType));
     */
        byte[] serialized = serializer.serialize(call, fieldStorage);  
        byte[] serialized = serializer.serialize(call, fieldStorage);
            ScalarFunction.EQUALS,
     * Tests that lenient=true round-trips correctly on SimpleQueryStringBuilder.  
            assertTrue(deserialized instanceof MatchPhraseQueryBuilder);  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
    /**  
    }  
        RexCall call = (RexCall) rexBuilder.makeCall(QUERY_FUNCTION, fieldMap);
            assertTrue("lenient should be true", simpleQsQb.lenient());  
            assertEquals(Operator.OR, matchQuery.operator());  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            rexBuilder.makeLiteral("Amber")  
        assertNotNull("Serialized bytes must not be null", serialized);
    public void testSerializeQueryStringWithFuzziness() throws IOException {
    }  
    }
            assertTrue(deserialized instanceof MatchQueryBuilder);  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            assertEquals("body", matchPhrase.fieldName());
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);  
import org.apache.calcite.rex.RexNode;  
     */  
    }  
    }
     */
    }  
        List<FieldStorageInfo> fieldStorage = List.of(
        RexCall call = buildSingleFieldRexCallWithParams("title", "test\\", "WILDCARD_QUERY", Map.of());  
        List<FieldStorageInfo> fieldStorage = List.of(
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
        ReturnTypes.BOOLEAN,
     */
            rexBuilder.makeLiteral("some_value")
            OperandTypes.ANY,
        }
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);  
        RexCall call = buildSingleFieldRexCallWithParams("title", "\\\\%", "WILDCARD_QUERY", Map.of());
            assertEquals("title", wildcardQb.fieldName());  
        );
            Map.of("phrase_slop", "2")
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);  
            List.of("title", "body"),
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        );
            assertEquals("title", matchQuery.fieldName());
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            ReturnTypes.BOOLEAN,
        byte[] serialized = serializer.serialize(call, fieldStorage);  
import org.apache.calcite.sql.SqlKind;  
        List<FieldStorageInfo> fieldStorage = List.of();  
            assertNotNull("Serializer for " + entry.getKey() + " must not be null", entry.getValue());  
        }
            new FieldStorageInfo("gender", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
        }  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchBoolPrefixQueryBuilder.NAME, MatchBoolPrefixQueryBuilder::new),
        byte[] serialized = serializer.serialize(call, fieldStorage);
            functionName,
        );
     */
        List<FieldStorageInfo> fieldStorage = List.of(
        byte[] serialized = serializer.serialize(call, fieldStorage);  
        List<String> fields,  
        );
        // text field "gender" WITH a keyword subfield named "keyword".
     * Tests that a pattern with no SQL wildcards passes through unchanged.  
            assertTrue(deserialized instanceof MultiMatchQueryBuilder);  
 * The OpenSearch Contributors require contributions made to  
import java.util.List;  
import org.opensearch.index.query.QueryBuilder;
    // --- EQUALS text-field routing tests ---
     * Tests WildcardQuerySerializer round-trip with field and pattern.  
            assertEquals("hello*world?", wildcardQb.value());
    }
    /**
        RexCall call = buildSingleFieldRexCallWithParams("title", "quick br", "MATCH_BOOL_PREFIX", Map.of("prefix_length", "3"));  
            "search text",
        List<FieldStorageInfo> fieldStorage = List.of();  
            "hello",
        }  
        }  
        List<FieldStorageInfo> fieldStorage = List.of(  
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            rexBuilder.makeLiteral("test*")
        assertNotNull("MULTI_MATCH serializer must be registered", serializer);
            MultiMatchQueryBuilder multiMatch = (MultiMatchQueryBuilder) deserialized;
    /**  
            assertTrue("Deserialized must be MatchAllQueryBuilder", deserialized instanceof MatchAllQueryBuilder);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     */  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY);
        // Java string "\\\\%" is runtime chars: \, \, %
     * Tests QuerySerializer with default_operator=AND optional param round-trip.  
        assertNotNull("SIMPLE_QUERY_STRING serializer must be registered", serializer);
        byte[] serialized = serializer.serialize(call, fieldStorage);
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            rexBuilder.makeLiteral("query"),
        assertNotNull("MATCH serializer must be registered", serializer);
        List<FieldStorageInfo> fieldStorage = List.of();  
        assertNotNull("MATCH_PHRASE serializer must be registered", serializer);
        }
        );
            ScalarFunction.MATCH,
            ScalarFunction.IS_NOT_NULL,
        assertNotNull("QUERY serializer must be registered", serializer);
     */
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        byte[] serialized = serializer.serialize(call, fieldStorage);
            ScalarFunction.IS_NULL,
            assertEquals("title", matchQuery.fieldName());
    /**
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
     * Validates Requirement 11.6.
        List<FieldStorageInfo> fieldStorage = List.of(
    }
            QueryStringQueryBuilder queryStringQb = (QueryStringQueryBuilder) deserialized;  
    @Override
            ScalarFunction.MATCH_BOOL_PREFIX,
     * FUNC(MAP('fields', MAP('field1', 1.0, 'field2', 1.0, ...)), MAP('query', 'text'), MAP('key1', 'val1'), ...)  
        }
        List<FieldStorageInfo> fieldStorage = List.of(
            assertEquals("te?t", wildcardQb.value());
        List<FieldStorageInfo> fieldStorage = List.of();
    public void testSerializeSimpleQueryStringWithLenient() throws IOException {
            rexBuilder.makeLiteral("query"),
     */
        );  
            ScalarFunction.LESS_THAN,  
     * Tests that a trailing backslash is preserved in the output.
            assertEquals("title", matchQuery.fieldName());
            "search text",  
    }
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        );
        List<FieldStorageInfo> fieldStorage = List.of();
        assertNotNull("MATCH_PHRASE serializer must be registered", serializer);
        }
            SimpleQueryStringBuilder simpleQsQb = (SimpleQueryStringBuilder) deserialized;
        List<FieldStorageInfo> fieldStorage = List.of();
    public void testSerializeMultiMatchWithFuzzyRewrite() throws IOException {
    public void testRegistryKeySetMatchesExpectedFunctions() {  
        assertNotNull("MATCHALL serializer must be registered", serializer);
    }
    public void testEqualsOnTextFieldWithoutKeywordSubfieldKeepsField() throws IOException {  
            "Exception message must contain 'wildcard_query', got: " + exception.getMessage(),  
        SqlFunctionCategory.USER_DEFINED_FUNCTION
    public void testSerializeMultiMatchWithSlop() throws IOException {
     */
        assertNotNull("QUERY serializer must be registered", serializer);
        }  
            ScalarFunction.WILDCARD_QUERY,  
        RexCall call = (RexCall) rexBuilder.makeCall(MATCHALL_FUNCTION);
            assertEquals("search text", simpleQsQb.value());  
        byte[] serialized = serializer.serialize(call, fieldStorage);
        List<FieldStorageInfo> fieldStorage = List.of(
        );
            assertEquals("test*", wildcardQb.value());
            "QUERY_STRING",
     * Asserts that the registry's key set exactly equals the expected complete set of ScalarFunction  
    /**
        serializers = QuerySerializerRegistry.getSerializers();
    /**
        );
        assertNotNull("WILDCARD_QUERY serializer must be registered", serializer);
        // Outer MAP: MAP('fields', nestedMap)  
        byte[] serialized = serializer.serialize(call, fieldStorage);
}
            assertEquals("constant_score", multiMatch.fuzzyRewrite());  
    private RelDataTypeFactory typeFactory;
            assertEquals("status:active AND type:premium", queryStringQb.queryString());
    }  
        RexNode extraMap = rexBuilder.makeCall(
import java.util.Set;
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
            assertEquals("quick fox", matchPhrase.value());  
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
import org.apache.calcite.rel.type.RelDataType;
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            assertEquals("test\\", wildcardQb.value());  
            SqlStdOperatorTable.EQUALS,
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.EQUALS);
        for (Map.Entry<String, String> entry : optionalParams.entrySet()) {  
        assertNotNull("WILDCARD_QUERY serializer must be registered", serializer);  
import org.apache.calcite.rex.RexBuilder;
    public void testWildcardQuerySerializerIgnoresUnrecognizedParams() throws IOException {
            rexBuilder.makeLiteral("hello world")  
            MatchPhraseQueryBuilder matchPhrase = (MatchPhraseQueryBuilder) deserialized;
    }
        null,
        );
    }  
        );  
    }  
import org.apache.calcite.rex.RexCall;
            rexBuilder.makeLiteral("F")
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
            "MULTI_MATCH",  
        }  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        List<FieldStorageInfo> fieldStorage = List.of(  
        List<FieldStorageInfo> fieldStorage = List.of();
     * Tests QuerySerializer silently ignores unrecognized params.  
        );
    public void testSerializeMatchPhrasePrefixWithBoost() throws IOException {
            functionName,
        RexNode unknownParamMap = rexBuilder.makeCall(
        byte[] serialized = serializer.serialize(call, fieldStorage);  
     */
        );
 */
     */
        RexCall call = buildSingleFieldRexCallWithParams("body", "quick fox", "MATCH_PHRASE", Map.of("slop", "2"));
        String functionName,
        );  
            MatchPhrasePrefixQueryBuilder matchPhrasePrefix = (MatchPhrasePrefixQueryBuilder) deserialized;
    /**  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
     */
import org.opensearch.index.query.MatchAllQueryBuilder;
            assertTrue("Deserialized must be WildcardQueryBuilder", deserialized instanceof WildcardQueryBuilder);
            assertEquals("search text", multiMatch.value());
        null,
        List<FieldStorageInfo> fieldStorage = List.of(
        byte[] serialized = serializer.serialize(call, fieldStorage);
    /**  
        List<RexNode> operands = new ArrayList<>();
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        assertTrue("Exception message must contain 'query', got: " + exception.getMessage(), exception.getMessage().contains("query"));
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    }
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
    }  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            assertTrue("Deserialized must be WildcardQueryBuilder", deserialized instanceof WildcardQueryBuilder);
     */
            ScalarFunction.LESS_THAN_OR_EQUAL,
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH);  
        List<FieldStorageInfo> fieldStorage = List.of();
            RexNode paramMap = rexBuilder.makeCall(
            assertTrue(deserialized instanceof QueryStringQueryBuilder);
import org.opensearch.test.OpenSearchTestCase;
        assertNotNull("SIMPLE_QUERY_STRING serializer must be registered", serializer);
import org.opensearch.core.common.io.stream.StreamInput;  
    public void testWildcardQueryNoSqlWildcardsPassesThrough() throws IOException {
        operands.add(outerMap);  
        rexBuilder = new RexBuilder(typeFactory);  
        List<FieldStorageInfo> fieldStorage = List.of(
            Map.of("lenient", "true")
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
        RexCall call = buildSingleFieldRexCallWithParams("title", "100\\%\\_done", "WILDCARD_QUERY", Map.of());
            expected.flags(SimpleQueryStringFlag.NONE, SimpleQueryStringFlag.PREFIX, SimpleQueryStringFlag.ESCAPE);
        List<FieldStorageInfo> fieldStorage = List.of(  
     * Tests QuerySerializer accepts missing field without exception (no-field variant).
    /**
        RexCall call = (RexCall) rexBuilder.makeCall(QUERY_FUNCTION, queryMap);  
            expected.field("body", 1.0f);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY_STRING);
            TermQueryBuilder term = (TermQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
    }  
            rexBuilder.makeInputRef(varcharType, 0),
     * Tests that unrecognized parameter keys are silently ignored (no exception thrown).
        );  
            ScalarFunction.GREATER_THAN,
        }  
        RexNode queryMap = rexBuilder.makeCall(
        byte[] serialized = serializer.serialize(call, fieldStorage);
import org.apache.calcite.sql.type.SqlTypeName;
            operands.add(paramMap);
        assertNotNull("MATCH_BOOL_PREFIX serializer must be registered", serializer);
        }
        byte[] serialized = serializer.serialize(call, fieldStorage);  
        );
/*  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        byte[] serialized = serializer.serialize(call, fieldStorage);
            expected.field("title", 1.0f);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
        RexCall call = buildSingleFieldRexCallWithParams("title", "hello", "MATCH", Map.of());
            assertEquals("\\*", wildcardQb.value());
    public void testSerializeQueryStringWithPhraseSlop() throws IOException {  
            RexNode paramMap = rexBuilder.makeCall(
        OperandTypes.ANY,  
            SqlFunctionCategory.USER_DEFINED_FUNCTION
            assertEquals("gender", term.fieldName());
    private static final SqlFunction MATCHALL_FUNCTION = new SqlFunction(
    /**
 * this file be licensed under the Apache-2.0 license or a
     * Validates Requirement 11.3.
        RexCall call = buildMultiFieldRexCallWithParams(  
        );  
            rexBuilder.makeInputRef(varcharType, 0)
            SimpleQueryStringBuilder expected = new SimpleQueryStringBuilder("search text");
        SqlFunctionCategory.USER_DEFINED_FUNCTION
     */  
    /**
     * Tests that a backslash before a non-wildcard character preserves both characters.  
     * Tests that serializeMatchPhrase with slop=2 produces a MatchPhraseQueryBuilder with slop=2.  
        RexNode fieldMap = rexBuilder.makeCall(
    }
        );  
    }
    public void testWildcardQueryEscapedBackslashFollowedByWildcard() throws IOException {  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> serializer.serialize(call, fieldStorage));
        List<FieldStorageInfo> fieldStorage = List.of(
        SqlFunction sqlFunction = new SqlFunction(
    /**
        }
        // Operand 0: MAP('field', $0)  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
            "MATCH",  
            rexBuilder.makeInputRef(varcharType, 0)
        typeFactory = new JavaTypeFactoryImpl();
    // --- Helper methods ---
        null,
        RexCall call = buildMultiFieldRexCallWithParams(List.of("title", "body"), "search text", "MULTI_MATCH", Map.of("slop", "3"));  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH);  
    /**
            "search text",
            ScalarFunction.NOT_EQUALS,  
 * Unit tests for {@link QuerySerializerRegistry} serializers — optional parameter round-trips
        }
    public void testWildcardQueryConvertsPercentToStar() throws IOException {
    // --- SimpleQueryString flags tests ---
        byte[] serialized = serializer.serialize(call, fieldStorage);
import org.opensearch.analytics.spi.FieldStorageInfo;  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY);
     * Tests MatchAllSerializer ignores unexpected operands without throwing.
        operands.add(fieldMap);
        RexCall call = buildSingleFieldRexCallWithParams("title", "te_t", "WILDCARD_QUERY", Map.of());
            assertEquals("search text", multiMatch.value());  
        );
        );
     * Tests that SQL '%' wildcard is converted to Lucene '*'.  
            assertTrue("Deserialized must be QueryStringQueryBuilder", deserialized instanceof QueryStringQueryBuilder);
    public void testMatchAllSerializerIgnoresUnrecognizedOperands() throws IOException {  
        );
            rexBuilder.makeLiteral("value")
            ScalarFunction.REGEXP,
        }
        RexCall call = buildMultiFieldRexCallWithParams(List.of("title", "body"), "search text", "MULTI_MATCH", Map.of("type", "phrase"));
        );  
    public void testQuerySerializerIgnoresUnrecognizedParams() throws IOException {
            new NamedWriteableRegistry.Entry(QueryBuilder.class, WildcardQueryBuilder.NAME, WildcardQueryBuilder::new),
import org.apache.calcite.sql.type.ReturnTypes;  
     * EQUALS on a TEXT field with NO keyword subfield leaves the field name unchanged (graceful  
    private RexCall buildMultiFieldRexCallWithParams(
        );  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);  
        byte[] serialized = serializer.serialize(call, fieldStorage);
        List<FieldStorageInfo> fieldStorage = List.of(
        );
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
            QueryStringQueryBuilder queryStringQb = (QueryStringQueryBuilder) deserialized;  
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            // Build an expected builder with the same flags to verify equality  
        RexCall call = buildSingleFieldRexCallWithParams("title", "test*", "WILDCARD_QUERY", Map.of("boost", "2.5"));
            ScalarFunction.SIMPLE_QUERY_STRING,
    /**  
        }  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
import org.opensearch.index.query.TermQueryBuilder;  
    public void testQuerySerializerWithDefaultOperator() throws IOException {
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.EQUALS);
    private RexCall buildSingleFieldRexCallWithParams(
     */
 * compatible open source license.
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        String queryText,  
    /**
        );
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
     * (class instances, not method references).
        RexCall call = (RexCall) rexBuilder.makeCall(QUERY_FUNCTION, queryMap, operatorMap);
    }  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     * Tests that serializers with no optional params produce default QueryBuilders.
            expected.field("body", 1.0f);  
        assertNotNull("QUERY_STRING serializer must be registered", serializer);
 */  
            TermQueryBuilder term = (TermQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
            );
    public void testWildcardQueryConvertsUnderscoreToQuestionMark() throws IOException {
            SqlKind.OTHER_FUNCTION,
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH);  
        assertTrue("Serialized bytes must not be empty", serialized.length > 0);
        }
            rexBuilder.makeInputRef(varcharType, 0),
     * Validates Requirement 11.10.  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);  
        RexCall call = (RexCall) rexBuilder.makeCall(MATCHALL_FUNCTION, extraMap);  
            assertTrue(deserialized instanceof MatchQueryBuilder);  
        return (RexCall) rexBuilder.makeCall(sqlFunction, operands);  
     * Tests that an escaped backslash (\\) followed by a wildcard correctly produces  
        byte[] serialized = serializer.serialize(call, fieldStorage);  
            assertEquals("title", wildcardQb.fieldName());
        List<FieldStorageInfo> fieldStorage = List.of(
    }
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
import org.opensearch.analytics.spi.FieldType;
    }  
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
     */
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
import org.opensearch.index.query.MatchPhraseQueryBuilder;
        RexCall call = (RexCall) rexBuilder.makeCall(
            assertTrue(deserialized instanceof SimpleQueryStringBuilder);  
     */
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        List<FieldStorageInfo> fieldStorage = List.of(
    }
            assertTrue(deserialized instanceof SimpleQueryStringBuilder);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH);  
import java.util.ArrayList;
            assertEquals("quick br", matchPhrasePrefix.value());  
        RexNode queryMap = rexBuilder.makeCall(  
    public void testWildcardQuerySerializerThrowsWhenFieldMissing() {
     * EQUALS on a TEXT field that has a keyword multifield must build the TermQuery against the
import org.opensearch.index.query.Operator;
        byte[] serialized = serializer.serialize(call, fieldStorage);  
            SqlStdOperatorTable.EQUALS,
     * EQUALS on a KEYWORD field is unchanged — no rewrite (it's already exact-match).
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);  
        );
        List<RexNode> nestedMapOperands = new ArrayList<>();
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MULTI_MATCH);
        RexNode queryMap = rexBuilder.makeCall(  
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
     * Tests that fuzziness=AUTO round-trips correctly on QueryStringQueryBuilder.
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            assertEquals("hello", matchQuery.value());  
        );
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        }
        assertNotNull("MATCH serializer must be registered", serializer);
            Map.of("unknown_param", "some_value", "another_unknown", "42")
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
     * Validates Requirement 11.2.  
            List.of("title", "body"),
                SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    public void testQuerySerializerThrowsWhenQueryMissing() {  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);  
    public void testWildcardQuerySerializerWithBoost() throws IOException {  
        );  
        RexCall call = (RexCall) rexBuilder.makeCall(QUERY_FUNCTION, queryMap, unknownParamMap);
     */
            rexBuilder.makeLiteral("F")  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.EQUALS);
     */
        assertNotNull("WILDCARD_QUERY serializer must be registered", serializer);  
        }  
            assertEquals("hello world", matchQuery.value());  
            assertEquals("test*", wildcardQb.value());
            new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new),
            assertTrue(deserialized instanceof SimpleQueryStringBuilder);  
import org.opensearch.index.query.WildcardQueryBuilder;
 * SPDX-License-Identifier: Apache-2.0
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        String queryText,
     * an expected builder with the same flags set.  
            "search text",  
import org.opensearch.common.unit.Fuzziness;  
            assertEquals("title", matchQuery.fieldName());
        List<FieldStorageInfo> fieldStorage = List.of(
    /**
        byte[] serialized = serializer.serialize(call, fieldStorage);  
        List<FieldStorageInfo> fieldStorage = List.of(
            TermQueryBuilder term = (TermQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
    );
                SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
        SqlKind.OTHER_FUNCTION,  
     */
            new NamedWriteableRegistry.Entry(QueryBuilder.class, QueryStringQueryBuilder.NAME, QueryStringQueryBuilder::new),
            assertEquals("search text", simpleQsQb.value());
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
            assertEquals(2, queryString.phraseSlop());
        assertNotNull("MATCH serializer must be registered", serializer);
            assertEquals(2.5f, wildcardQb.boost(), 0.001f);
     * Tests that max_expansions=50 round-trips correctly on MatchQueryBuilder.  
        ReturnTypes.BOOLEAN,
            List.of("title", "body"),  
        byte[] serialized = serializer.serialize(call, fieldStorage);
            SqlStdOperatorTable.EQUALS,  
            rexBuilder.makeLiteral("query"),  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        byte[] serialized = serializer.serialize(call, fieldStorage);
    /**
            assertEquals("body", matchPhrasePrefix.fieldName());
    }  
     */
        RexCall call = buildSingleFieldRexCallWithParams("title", "test*", "WILDCARD_QUERY", Map.of());  
            assertEquals(1.5f, matchPhrasePrefix.boost(), 0.001f);
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        assertNotNull("MATCH_PHRASE_PREFIX serializer must be registered", serializer);
            ScalarFunction.PREFIX_QUERY,
import org.opensearch.analytics.spi.ScalarFunction;
            assertTrue(deserialized instanceof MatchQueryBuilder);
        }
    public void testSerializeSimpleQueryStringWithPipeSeparatedFlags() throws IOException {
        "WILDCARD_QUERY",
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(
        }
            MatchBoolPrefixQueryBuilder matchBoolPrefix = (MatchBoolPrefixQueryBuilder) deserialized;
    }  
    public void testWildcardQuerySerializerRoundTrip() throws IOException {
            SqlFunctionCategory.USER_DEFINED_FUNCTION  
            "SIMPLE_QUERY_STRING",  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
            List.of("title", "body"),
     */
    public void testSerializeMatchWithOperatorAnd() throws IOException {
            ScalarFunction.SARG_PREDICATE  
        assertNotNull("QUERY serializer must be registered", serializer);
            assertTrue("Deserialized must be MatchAllQueryBuilder", deserialized instanceof MatchAllQueryBuilder);
        );  
            assertTrue(deserialized instanceof MatchPhrasePrefixQueryBuilder);  
     */
    /**  
     */
        List<RexNode> operands = new ArrayList<>();  
     * Tests WildcardQuerySerializer with boost optional param round-trip.
            assertEquals("*foo_bar?", wildcardQb.value());
        }
     */  
    /**
            Map.of("flags", "NONE|PREFIX|ESCAPE")
            // Default operator is OR
    /**
    // --- New optional parameter round-trip tests ---  
    );
            ScalarFunction.LIKE,  
            "search text",
            nestedMapOperands.add(rexBuilder.makeLiteral(field));
        ReturnTypes.BOOLEAN,
            assertEquals("quick br", matchBoolPrefix.value());  
        RexCall call = buildSingleFieldRexCallWithParams("title", "test\\n", "WILDCARD_QUERY", Map.of());
        RexNode queryMap = rexBuilder.makeCall(
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
        }
        }
            ScalarFunction.MATCHALL,
     * Tests that prefix_length=3 round-trips correctly on MatchBoolPrefixQueryBuilder.  
import org.opensearch.index.query.MatchBoolPrefixQueryBuilder;
    }
            SimpleQueryStringBuilder simpleQsQb = (SimpleQueryStringBuilder) deserialized;
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) deserialized;
        RexCall call = buildSingleFieldRexCallWithParams("body", "quick br", "MATCH_PHRASE_PREFIX", Map.of("boost", "1.5"));  
    /**
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        List<FieldStorageInfo> fieldStorage = List.of(
        List<FieldStorageInfo> fieldStorage = List.of();
        );
    /**
        );  
            expected.field("title", 1.0f);  
    private static final SqlFunction WILDCARD_QUERY_FUNCTION = new SqlFunction(
     * Tests QuerySerializer throws IllegalArgumentException with "query" when query is missing.
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCHALL);
     * FUNC(MAP('field', $0), MAP('query', 'text'), MAP('key1', 'val1'), MAP('key2', 'val2'), ...)
        // Java string "\\n" is runtime chars: \, n
        List<FieldStorageInfo> fieldStorage = List.of(
        );
        RexCall call = buildSingleFieldRexCallWithParams("title", "hello*world?", "WILDCARD_QUERY", Map.of());
            new FieldStorageInfo("body", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
            assertEquals("hello", matchQuery.value());
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
    /**  
            assertEquals("hello", matchQuery.value());  
        // Should not throw any exception
            "title",
    /**
    public void testSerializeSimpleQueryStringWithSingleFlag() throws IOException {  
        );
     */
    public void testUnrecognizedParameterKeysAreIgnored() throws IOException {
     * {@code .keyword} subfield. A raw TermQuery on the analyzed text field matches nothing
        byte[] serialized = serializer.serialize(call, fieldStorage);
        List<FieldStorageInfo> fieldStorage = List.of();
    public void testSerializeMatchWithLenient() throws IOException {
        );  
            rexBuilder.makeLiteral("unknown_param"),
    }
    }  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
    }  
    public void testSerializeMatchPhraseWithSlop() throws IOException {  
            assertTrue("Deserialized must be QueryStringQueryBuilder", deserialized instanceof QueryStringQueryBuilder);
    public void testEqualsOnKeywordFieldUnchanged() throws IOException {  
            assertEquals("search text", queryString.queryString());  
            operands.add(paramMap);  
     */
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);  
        }
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
     * Validates Requirement 11.9.  
        }
     * Tests that boost=2.5 round-trips correctly on MatchPhraseQueryBuilder.  
            "SIMPLE_QUERY_STRING",
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            );
        assertNotNull("MATCH serializer must be registered", serializer);
        assertNotNull("SIMPLE_QUERY_STRING serializer must be registered", serializer);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        RexCall call = buildSingleFieldRexCallWithParams("title", "test*", "WILDCARD_QUERY", Map.of("unknown_param", "value"));
    }  
            assertEquals("test*", wildcardQb.value());
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        RexCall call = buildSingleFieldRexCallWithParams("body", "quick fox", "MATCH_PHRASE", Map.of("boost", "2.5"));  
            assertTrue(
        }
     * (the analyzer lowercases/ tokenizes the indexed value, but TermQuery does not analyze the  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.SIMPLE_QUERY_STRING);
        SqlFunction sqlFunction = new SqlFunction(  
            "search text",
            ReturnTypes.BOOLEAN,  
    }  
    public void testQuerySerializerAcceptsMissingField() throws IOException {  
        operands.add(queryMap);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexCall call = buildSingleFieldRexCallWithParams("title", "test%", "WILDCARD_QUERY", Map.of());
import org.opensearch.index.query.SimpleQueryStringFlag;
    }
        Set<ScalarFunction> expected = Set.of(
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
        RexCall call = buildMultiFieldRexCallWithParams(
            QueryStringQueryBuilder queryStringQb = (QueryStringQueryBuilder) deserialized;  
            SimpleQueryStringBuilder simpleQsQb = (SimpleQueryStringBuilder) deserialized;
    /**
     */
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     */  
        SqlKind.OTHER_FUNCTION,  
    );
    /**  
/**
                rexBuilder.makeLiteral(entry.getKey()),
        return (RexCall) rexBuilder.makeCall(sqlFunction, operands);
    ) {  
        byte[] serialized = serializer.serialize(call, fieldStorage);  
        );
     */
     * The flags should be applied without throwing, and the deserialized builder should match
            rexBuilder.makeLiteral("query"),
            assertEquals(expected, simpleQsQb);
        List<FieldStorageInfo> fieldStorage = List.of();  
        RexCall call = buildSingleFieldRexCallWithParams("title", "hello", "MATCH", Map.of("max_expansions", "50"));  
        }
            rexBuilder.makeLiteral("default_operator"),
     * Builds a single-field RexCall with optional parameters:
     * Tests WildcardQuerySerializer throws IllegalArgumentException with "wildcard_query" when field is missing.
            assertTrue(deserialized instanceof MatchBoolPrefixQueryBuilder);  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            ScalarFunction.WILDCARD_QUERY_DSL,
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            assertEquals("body", matchPhrase.fieldName());  
            assertTrue(deserialized instanceof MatchQueryBuilder);  
    public void testSerializeMatchPhraseWithBoost() throws IOException {
                rexBuilder.makeLiteral(entry.getValue())
        "MATCHALL",
    // --- SQL-to-Lucene wildcard conversion tests ---  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);  
    /**  
        assertEquals("Registry key set must match expected ScalarFunction set", expected, serializers.keySet());
        byte[] serialized = serializer.serialize(call, fieldStorage);
            assertEquals(2.5f, matchPhrase.boost(), 0.001f);
import java.util.Map;
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
import org.apache.calcite.sql.SqlFunction;
        // Build operand list
        );
            assertEquals(Operator.AND, matchQuery.operator());
            assertEquals("gender.keyword", term.fieldName());  
        RexNode fieldMap = rexBuilder.makeCall(
            Map.of("flags", "ALL")
            ScalarFunction.MULTI_MATCH,  
        SqlKind.OTHER_FUNCTION,  
    public void testWildcardQueryTrailingBackslash() throws IOException {  
    public void testSerializersAreDelegatedPredicateSerializerInstances() {
            QueryStringQueryBuilder queryString = (QueryStringQueryBuilder) deserialized;
    public void testSerializerWithNoOptionalParamsProducesDefaults() throws IOException {
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);  
        }
            assertEquals("100%_done", wildcardQb.value());
    }
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        assertNotNull("QUERY_STRING serializer must be registered", serializer);  
    // --- Serializer refactoring verification tests ---
            assertEquals("hello", matchQuery.value());  
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchPhraseQueryBuilder.NAME, MatchPhraseQueryBuilder::new),
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchQueryBuilder.NAME, MatchQueryBuilder::new),  
     * Tests that serializeMultiMatch with type=phrase produces a MultiMatchQueryBuilder with PHRASE type.
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MultiMatchQueryBuilder.NAME, MultiMatchQueryBuilder::new),
package org.opensearch.be.lucene;
            assertTrue("lenient should be true", matchQuery.lenient());
        RexCall call = (RexCall) rexBuilder.makeCall(WILDCARD_QUERY_FUNCTION, queryMap);
            new FieldStorageInfo("firstname", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)  
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
        // Operand 1: MAP('query', 'queryText')
        // Java string "test\\" is runtime chars: t, e, s, t, \
import org.apache.calcite.sql.type.OperandTypes;
     */  
        }
            ScalarFunction.QUERY_STRING,
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchPhrasePrefixQueryBuilder.NAME, MatchPhrasePrefixQueryBuilder::new),  
    }
        for (Map.Entry<String, String> entry : optionalParams.entrySet()) {
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            null,
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);  
        // Expected: first \ escapes second \ → literal \, then % is unescaped → *  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCHALL);
        List.of(
     * Tests mixed SQL wildcards and escaped wildcards in a single pattern.  
     * Tests that pipe-separated flags "NONE|PREFIX|ESCAPE" round-trip correctly on SimpleQueryStringBuilder.
    /**
        List<FieldStorageInfo> fieldStorage = List.of();
        assertTrue(
            Map.of("fuzziness", "AUTO")  
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
    private RexBuilder rexBuilder;
                rexBuilder.makeLiteral(entry.getKey()),  
            rexBuilder.makeInputRef(varcharType, 0),
    /**  
            rexBuilder.makeLiteral("hello world")  
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;  
        RexCall call = buildMultiFieldRexCallWithParams(  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        assertNotNull("MATCHALL serializer must be registered", serializer);  
    public void testSerializeMatchBoolPrefixWithPrefixLength() throws IOException {
     * Tests that phrase_slop=2 round-trips correctly on QueryStringQueryBuilder.
            assertTrue(deserialized instanceof MatchPhraseQueryBuilder);
    private Map<ScalarFunction, DelegatedPredicateSerializer> serializers;  
    public void testSerializeMultiMatchWithTypePhrase() throws IOException {
        }
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
    /**  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        );  
                "Serializer for " + entry.getKey() + " must be an instance of DelegatedPredicateSerializer",
        }
        byte[] serialized = serializer.serialize(call, fieldStorage);  
import org.opensearch.index.query.MultiMatchQueryBuilder;  
            rexBuilder.makeLiteral(queryText)
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_PHRASE);
    /**
    // --- MatchAllSerializer tests ---
    /**
            MultiMatchQueryBuilder multiMatch = (MultiMatchQueryBuilder) deserialized;
        );
        assertNotNull("QUERY serializer must be registered", serializer);
            assertEquals(3, matchBoolPrefix.prefixLength());
    /**
            assertEquals("test\\n", wildcardQb.value());
     * Tests that fuzzy_rewrite="constant_score" round-trips correctly on MultiMatchQueryBuilder.  
     * Tests that each serializer in the registry is an instance of DelegatedPredicateSerializer
        );
            assertTrue(deserialized instanceof MultiMatchQueryBuilder);
    }
        List<FieldStorageInfo> fieldStorage = List.of(
            MatchPhraseQueryBuilder matchPhrase = (MatchPhraseQueryBuilder) deserialized;
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
     * Tests that boost=1.5 round-trips correctly on MatchPhrasePrefixQueryBuilder.  
            rexBuilder.makeLiteral("status:active AND type:premium")
        }  
import java.io.IOException;
     */
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)  
        RexCall call = buildSingleFieldRexCallWithParams("title", "hello", "MATCH", Map.of("lenient", "true"));  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);  
     * Tests that SQL '_' wildcard is converted to Lucene '?'.  
        operands.add(queryMap);
            assertEquals(3, multiMatch.slop());
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     * keys. A dropped or renamed registration fails this test.
            ScalarFunction.QUERY,  
            expected.flags(SimpleQueryStringFlag.ALL);
        );
     * fallback — same as the SQL engine, which only rewrites when a keyword subfield exists).
        // Build nested MAP with field/boost pairs
    public void testSerializeMatchWithMaxExpansions() throws IOException {
            SimpleQueryStringBuilder expected = new SimpleQueryStringBuilder("search text");
            OperandTypes.ANY,  
            assertEquals("title", matchQuery.fieldName());  
        OperandTypes.ANY,  
        RexCall call = buildSingleFieldRexCallWithParams(  
    /**
        assertNotNull("MATCH serializer must be registered", serializer);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_BOOL_PREFIX);  
     * Builds a multi-field RexCall with optional parameters:
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
     */
    /**
            assertEquals(50, matchQuery.maxExpansions());
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            assertEquals("hello world", queryStringQb.queryString());
        super.setUp();
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexCall call = (RexCall) rexBuilder.makeCall(  
            rexBuilder.makeLiteral("AND")
            "SIMPLE_QUERY_STRING",  
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
        RexCall call = buildMultiFieldRexCallWithParams(  
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) deserialized;  
        byte[] serialized = serializer.serialize(call, fieldStorage);  
        List<FieldStorageInfo> fieldStorage = List.of();
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);  
        byte[] serialized = serializer.serialize(call, fieldStorage);  
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);  
        RexNode outerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), nestedMap);
     */
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) deserialized;
            assertEquals("hello world", queryStringQb.queryString());
    public void testWildcardQueryBackslashBeforeNonWildcard() throws IOException {
        assertNotNull("MULTI_MATCH serializer must be registered", serializer);  
            assertTrue("Deserialized must be WildcardQueryBuilder", deserialized instanceof WildcardQueryBuilder);  
            assertTrue(deserialized instanceof MultiMatchQueryBuilder);  
            List.of("title", "body"),
     * Tests that slop=3 round-trips correctly on MultiMatchQueryBuilder.  
     */
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.SIMPLE_QUERY_STRING);  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> serializer.serialize(call, fieldStorage));  
            assertEquals("firstname", term.fieldName());
    /**  
    public void testWildcardQueryEscapedWildcardsRemainLiteral() throws IOException {
     */
    // --- QuerySerializer (no-field) tests ---
        assertNotNull("WILDCARD_QUERY serializer must be registered", serializer);
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        );
        }  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY_STRING);
        RexCall call = (RexCall) rexBuilder.makeCall(  
     * Tests that escaped SQL wildcards (\% and \_) are treated as literal characters.  
        );  
     */
        List<FieldStorageInfo> fieldStorage = List.of(
        for (Map.Entry<ScalarFunction, DelegatedPredicateSerializer> entry : serializers.entrySet()) {
            assertEquals("test*", wildcardQb.value());  
     */
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.SIMPLE_QUERY_STRING);  
    }  
        "QUERY",
    }
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY);  
    public void testWildcardQueryMixedEscapedAndUnescaped() throws IOException {
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);  
            assertTrue(deserialized instanceof MatchQueryBuilder);  
            Map.of("fuzzy_rewrite", "constant_score")
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH);  
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
public class QuerySerializerRegistryTests extends OpenSearchTestCase {
     */
    public void testMatchAllSerializerRoundTrip() throws IOException {
        OperandTypes.ANY,  
            ScalarFunction.MATCH_PHRASE,  
        // Build operand list: field, query, then optional params
    );
            null,
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
    ) {
        // Build a call with only field and query (no optional params)  
    }
        Map<String, String> optionalParams  
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        );
        RexNode operatorMap = rexBuilder.makeCall(
        );
    /**
                entry.getValue() instanceof DelegatedPredicateSerializer  
            ScalarFunction.MATCH_PHRASE_PREFIX,
        );
            assertEquals(Fuzziness.AUTO, queryString.fuzziness());
        byte[] serialized = serializer.serialize(call, fieldStorage);
        byte[] serialized = serializer.serialize(call, fieldStorage);
            assertEquals("quick fox", matchPhrase.value());
            "QUERY_STRING",
        RexNode queryMap = rexBuilder.makeCall(
            assertEquals(MultiMatchQueryBuilder.Type.PHRASE, multiMatch.getType());  
    // --- WildcardQuerySerializer tests ---
    /**
        RexCall call = buildMultiFieldRexCallWithParams(
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new)  
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MULTI_MATCH);  
            ScalarFunction.GREATER_THAN_OR_EQUAL,
     */
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
            List.of("title", "body"),
    }
            assertTrue("Deserialized must be QueryStringQueryBuilder", deserialized instanceof QueryStringQueryBuilder);
        List<FieldStorageInfo> fieldStorage = List.of();  
            assertEquals("search text", simpleQsQb.value());
    public void testEqualsOnTextFieldWithKeywordSubfieldRoutesToKeyword() throws IOException {  
        assertNotNull("Serialized bytes must not be null", serialized);  
        byte[] serialized = serializer.serialize(call, fieldStorage);
     */  
        );
    private static final SqlFunction QUERY_FUNCTION = new SqlFunction(
        )
import org.opensearch.index.query.MatchQueryBuilder;
     * a literal backslash plus the converted wildcard.
        }
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY);  
    /**
 * and SQL text relevance serializer behavior (WILDCARD_QUERY, QUERY, MATCHALL).  
        byte[] serialized = serializer.serialize(call, fieldStorage);  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
    /**
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_PHRASE_PREFIX);  
                rexBuilder.makeLiteral(entry.getValue())
        List<FieldStorageInfo> fieldStorage = List.of(
            rexBuilder.makeLiteral("field"),
            rexBuilder.makeLiteral("query"),
            rexBuilder.makeLiteral(queryText)
        RexCall call = buildSingleFieldRexCallWithParams("title", "hello world", "MATCH", Map.of("operator", "AND"));  
        }
import org.apache.calcite.sql.SqlFunctionCategory;
import org.opensearch.index.query.SimpleQueryStringBuilder;
            rexBuilder.makeLiteral("field"),  
        byte[] serialized = serializer.serialize(call, fieldStorage);  
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        }
     */
            exception.getMessage().contains("wildcard_query")
        );
     * Tests that flags="ALL" works correctly on SimpleQueryStringBuilder.
     * input). Mirrors the SQL engine's {@code OpenSearchTextType.convertTextToKeyword}.
        byte[] serialized = serializer.serialize(call, fieldStorage);  
        assertNotNull("MULTI_MATCH serializer must be registered", serializer);
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            rexBuilder.makeLiteral("unexpected"),  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {  
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            QueryStringQueryBuilder queryString = (QueryStringQueryBuilder) deserialized;  
            SqlKind.OTHER_FUNCTION,  
