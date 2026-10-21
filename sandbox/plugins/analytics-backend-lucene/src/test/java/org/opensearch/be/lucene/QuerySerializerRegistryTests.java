        assertNotNull("SIMPLE_QUERY_STRING serializer must be registered", serializer);
            null,
     */
        );
            assertEquals(expected, simpleQsQb);
            assertEquals("test*", wildcardQb.value());
     * Tests that serializeMatchPhrase with slop=2 produces a MatchPhraseQueryBuilder with slop=2.
        );
            assertTrue(deserialized instanceof MatchPhrasePrefixQueryBuilder);
     */
    /**
    public void testWildcardQueryBackslashBeforeNonWildcard() throws IOException {
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        RexCall call = buildSingleFieldRexCallWithParams("title", "te_t", "WILDCARD_QUERY", Map.of());
     * Tests that max_expansions=50 round-trips correctly on MatchQueryBuilder.
            nestedMapOperands.add(rexBuilder.makeLiteral(field));
import org.opensearch.index.query.WildcardQueryBuilder;
     * Validates Requirement 11.10.
        );
import org.apache.calcite.rel.type.RelDataType;
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCHALL);
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            assertTrue(deserialized instanceof QueryStringQueryBuilder);
    public void testQuerySerializerIgnoresUnrecognizedParams() throws IOException {
    /**
            assertEquals("body", matchPhrase.fieldName());
        RexCall call = buildSingleFieldRexCallWithParams("title", "test\\n", "WILDCARD_QUERY", Map.of());
        assertNotNull("QUERY_STRING serializer must be registered", serializer);
    public void testSerializeMatchWithOperatorAnd() throws IOException {
            assertEquals(2, matchPhrase.slop());
            "QUERY_STRING",
        RexCall call = buildSingleFieldRexCallWithParams("title", "test*", "WILDCARD_QUERY", Map.of("boost", "2.5"));
            new FieldStorageInfo("firstname", "keyword", FieldType.KEYWORD, List.of(), List.of("lucene"), List.of(), false)
        return (RexCall) rexBuilder.makeCall(sqlFunction, operands);
        for (Map.Entry<String, String> entry : optionalParams.entrySet()) {
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            );
            SimpleQueryStringBuilder simpleQsQb = (SimpleQueryStringBuilder) deserialized;
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        RexCall call = buildSingleFieldRexCallWithParams("title", "hello", "MATCH", Map.of());
        RexCall call = buildMultiFieldRexCallWithParams(
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            assertEquals(Operator.OR, matchQuery.operator());
        List<RexNode> operands = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
            assertEquals("hello world", queryStringQb.queryString());
    /**
     * Tests that boost=1.5 round-trips correctly on MatchPhrasePrefixQueryBuilder.
            assertEquals("F", term.value());
            assertEquals("search text", multiMatch.value());
        assertNotNull("EQUALS serializer must be registered", serializer);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
import org.apache.calcite.rel.type.RelDataTypeFactory;
        List<FieldStorageInfo> fieldStorage = List.of();
            MultiMatchQueryBuilder multiMatch = (MultiMatchQueryBuilder) deserialized;
        byte[] serialized = serializer.serialize(call, fieldStorage);
            new FieldStorageInfo("gender", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        RexNode queryMap = rexBuilder.makeCall(
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH);
     */
    // --- MatchAllSerializer tests ---
        );
        );
        byte[] serialized = serializer.serialize(call, fieldStorage);
        null,
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.EQUALS);
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
            rexBuilder.makeLiteral(queryText)
     * Tests that lenient=true round-trips correctly on MatchQueryBuilder.
     * Tests that a trailing backslash is preserved in the output.
        RexCall call = (RexCall) rexBuilder.makeCall(
            List.of("title", "body"),
        byte[] serialized = serializer.serialize(call, fieldStorage);
            assertTrue(deserialized instanceof MatchQueryBuilder);
            "search text",
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
            assertTrue("lenient should be true", simpleQsQb.lenient());
        List<FieldStorageInfo> fieldStorage = List.of(
            assertEquals("te?t", wildcardQb.value());
            "search text",
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
 * The OpenSearch Contributors require contributions made to
        byte[] serialized = serializer.serialize(call, fieldStorage);
        RexCall call = buildSingleFieldRexCallWithParams("title", "\\\\%", "WILDCARD_QUERY", Map.of());
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        byte[] serialized = serializer.serialize(call, fieldStorage);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> serializer.serialize(call, fieldStorage));
            Map.of("unknown_param", "some_value", "another_unknown", "42")
     * Tests that SQL '_' wildcard is converted to Lucene '?'.
    public void testQuerySerializerWithDefaultOperator() throws IOException {
    public void testEqualsOnKeywordFieldUnchanged() throws IOException {
            assertEquals("\\*", wildcardQb.value());
    /**
        List<RexNode> nestedMapOperands = new ArrayList<>();
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.SIMPLE_QUERY_STRING);
    public void testMatchAllSerializerIgnoresUnrecognizedOperands() throws IOException {
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        );
            SqlStdOperatorTable.EQUALS,
     */
            assertEquals("hello", matchQuery.value());
            assertEquals("search text", simpleQsQb.value());
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
        assertNotNull("MATCH serializer must be registered", serializer);
        );
        assertNotNull("MATCH_PHRASE serializer must be registered", serializer);
        assertNotNull("MATCH serializer must be registered", serializer);
     */
        assertNotNull("MATCHALL serializer must be registered", serializer);
     */
     */
            ScalarFunction.MATCHALL,
     * keys. A dropped or renamed registration fails this test.
            rexBuilder.makeInputRef(varcharType, 0),
     * Tests that unrecognized parameter keys are silently ignored (no exception thrown).
    public void testSerializeMatchWithLenient() throws IOException {
            "search text",
     * Builds a single-field RexCall with optional parameters:
            "title",
        byte[] serialized = serializer.serialize(call, fieldStorage);
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        List<FieldStorageInfo> fieldStorage = List.of(
                rexBuilder.makeLiteral(entry.getKey()),
            assertTrue(deserialized instanceof SimpleQueryStringBuilder);
            assertTrue("lenient should be true", matchQuery.lenient());
    /**
        RexCall call = buildSingleFieldRexCallWithParams("title", "test*", "WILDCARD_QUERY", Map.of());
    public void testUnrecognizedParameterKeysAreIgnored() throws IOException {
    }
        SqlKind.OTHER_FUNCTION,
        }
        byte[] serialized = serializer.serialize(call, fieldStorage);
    /**
            RexNode paramMap = rexBuilder.makeCall(
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
import org.opensearch.analytics.spi.FieldStorageInfo;
        }
            rexBuilder.makeLiteral("query"),
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        // Java string "\\\\%" is runtime chars: \, \, %
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_BOOL_PREFIX);
 */
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
        List<FieldStorageInfo> fieldStorage = List.of(
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            List.of("title", "body"),
     * (the analyzer lowercases/ tokenizes the indexed value, but TermQuery does not analyze the
    }
        RexCall call = (RexCall) rexBuilder.makeCall(
        assertNotNull("Serialized bytes must not be null", serialized);
    }
        assertNotNull("QUERY serializer must be registered", serializer);
        RexCall call = buildMultiFieldRexCallWithParams(List.of("title", "body"), "search text", "MULTI_MATCH", Map.of("slop", "3"));
        ReturnTypes.BOOLEAN,
    }
    }
        RexNode queryMap = rexBuilder.makeCall(
    /**
            ScalarFunction.QUERY_STRING,
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) deserialized;
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MultiMatchQueryBuilder.NAME, MultiMatchQueryBuilder::new),
     * Asserts that the registry's key set exactly equals the expected complete set of ScalarFunction
        assertNotNull("QUERY serializer must be registered", serializer);
     */
                "Serializer for " + entry.getKey() + " must be an instance of DelegatedPredicateSerializer",
    public void testQuerySerializerAcceptsMissingField() throws IOException {
    /**
            assertEquals("body", matchPhrasePrefix.fieldName());
            List.of("title", "body"),
import org.opensearch.analytics.spi.FieldType;
            QueryStringQueryBuilder queryStringQb = (QueryStringQueryBuilder) deserialized;
}
    }
            expected.field("body", 1.0f);
    /**
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
    /**
    public void testWildcardQueryNoSqlWildcardsPassesThrough() throws IOException {
            assertTrue(deserialized instanceof SimpleQueryStringBuilder);
            "SIMPLE_QUERY_STRING",
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexCall call = buildMultiFieldRexCallWithParams(
            assertEquals("hello world", matchQuery.value());
        byte[] serialized = serializer.serialize(call, fieldStorage);
            QueryStringQueryBuilder queryString = (QueryStringQueryBuilder) deserialized;
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
    }
            MatchPhrasePrefixQueryBuilder matchPhrasePrefix = (MatchPhrasePrefixQueryBuilder) deserialized;
 * compatible open source license.
        RexNode queryMap = rexBuilder.makeCall(
        );
import org.opensearch.index.query.QueryBuilder;
        // Java string "test\\" is runtime chars: t, e, s, t, \
        RexCall call = (RexCall) rexBuilder.makeCall(MATCHALL_FUNCTION, extraMap);
        );
            rexBuilder.makeLiteral("hello world")
    /**
public class QuerySerializerRegistryTests extends OpenSearchTestCase {
            rexBuilder.makeLiteral("hello world")
        );
    public void testWildcardQuerySerializerWithBoost() throws IOException {
        String functionName,
     */
     * Tests that lenient=true round-trips correctly on SimpleQueryStringBuilder.
import org.opensearch.index.query.QueryStringQueryBuilder;
        }
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        );
     * an expected builder with the same flags set.
        List<FieldStorageInfo> fieldStorage = List.of(
            assertEquals("search text", queryString.queryString());
        List<FieldStorageInfo> fieldStorage = List.of();
    public void testSerializerWithNoOptionalParamsProducesDefaults() throws IOException {
        List<FieldStorageInfo> fieldStorage = List.of(
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
    }
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
    public void testMatchAllSerializerRoundTrip() throws IOException {
            ScalarFunction.WILDCARD_QUERY_DSL,
            ScalarFunction.REGEXP,
     */
            assertEquals(Fuzziness.AUTO, queryString.fuzziness());
            assertEquals("100%_done", wildcardQb.value());
            assertTrue("Deserialized must be WildcardQueryBuilder", deserialized instanceof WildcardQueryBuilder);
            assertTrue(deserialized instanceof MatchPhraseQueryBuilder);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.SIMPLE_QUERY_STRING);
        List<FieldStorageInfo> fieldStorage = List.of(
            ScalarFunction.LIKE,
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        }
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
     * Tests MatchAllSerializer serialize → deserialize produces MatchAllQueryBuilder.
    }
    }
        List<FieldStorageInfo> fieldStorage = List.of(
        }
    }
            Map.of("fuzziness", "AUTO")
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> serializer.serialize(call, fieldStorage));
            "MATCH",
        }
    public void testWildcardQueryEscapedWildcardsRemainLiteral() throws IOException {
        RexCall call = buildMultiFieldRexCallWithParams(List.of("title", "body"), "search text", "MULTI_MATCH", Map.of("type", "phrase"));
            SqlStdOperatorTable.EQUALS,
            "SIMPLE_QUERY_STRING",
        RexNode queryMap = rexBuilder.makeCall(
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        );
    /**
        List<FieldStorageInfo> fieldStorage = List.of();
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            assertEquals("search text", simpleQsQb.value());
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
    }
            TermQueryBuilder term = (TermQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
import org.apache.calcite.rex.RexCall;
        RexCall call = (RexCall) rexBuilder.makeCall(MATCHALL_FUNCTION);
    }
            ScalarFunction.IS_NOT_NULL,
            MultiMatchQueryBuilder multiMatch = (MultiMatchQueryBuilder) deserialized;
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchPhrasePrefixQueryBuilder.NAME, MatchPhrasePrefixQueryBuilder::new),
        byte[] serialized = serializer.serialize(call, fieldStorage);
                entry.getValue() instanceof DelegatedPredicateSerializer
            Map.of("phrase_slop", "2")
    public void testSerializeSimpleQueryStringWithSingleFlag() throws IOException {
    /**
     */
            assertTrue("Deserialized must be MatchAllQueryBuilder", deserialized instanceof MatchAllQueryBuilder);
        byte[] serialized = serializer.serialize(call, fieldStorage);
            rexBuilder.makeLiteral("query"),
        RexCall call = (RexCall) rexBuilder.makeCall(QUERY_FUNCTION, queryMap, unknownParamMap);
            assertEquals("test*", wildcardQb.value());
            SqlKind.OTHER_FUNCTION,
import org.apache.calcite.sql.SqlFunction;
        List<FieldStorageInfo> fieldStorage = List.of();
    // --- New optional parameter round-trip tests ---
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        RexCall call = buildSingleFieldRexCallWithParams("title", "quick br", "MATCH_BOOL_PREFIX", Map.of("prefix_length", "3"));
            assertEquals("status:active AND type:premium", queryStringQb.queryString());
        byte[] serialized = serializer.serialize(call, fieldStorage);
        List<FieldStorageInfo> fieldStorage = List.of();
import org.apache.calcite.sql.type.SqlTypeName;
        byte[] serialized = serializer.serialize(call, fieldStorage);
            );
        );
        List<FieldStorageInfo> fieldStorage = List.of();
            "search text",
        for (Map.Entry<String, String> entry : optionalParams.entrySet()) {
     */
            assertEquals("title", matchQuery.fieldName());
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        assertNotNull("QUERY serializer must be registered", serializer);
            expected.field("title", 1.0f);
import org.apache.calcite.sql.SqlFunctionCategory;
    );
     * Tests MatchAllSerializer ignores unexpected operands without throwing.
        );
            assertTrue(deserialized instanceof MultiMatchQueryBuilder);
        List<FieldStorageInfo> fieldStorage = List.of();
            nestedMapOperands.add(rexBuilder.makeExactLiteral(new java.math.BigDecimal("1.0"), doubleType));
            rexBuilder.makeLiteral(queryText)
     */
import org.opensearch.index.query.SimpleQueryStringFlag;
        byte[] serialized = serializer.serialize(call, fieldStorage);
    /**
        List<FieldStorageInfo> fieldStorage = List.of();
        }
        RexNode outerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), nestedMap);
     */
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchPhraseQueryBuilder.NAME, MatchPhraseQueryBuilder::new),
        assertNotNull("MATCH_PHRASE serializer must be registered", serializer);
            rexBuilder.makeLiteral("test*")
            assertTrue(deserialized instanceof QueryStringQueryBuilder);
        ReturnTypes.BOOLEAN,
        // Build nested MAP with field/boost pairs
     * Validates Requirement 11.6.
                rexBuilder.makeLiteral(entry.getValue())
        );
    // --- Serializer refactoring verification tests ---
        List<FieldStorageInfo> fieldStorage = List.of();
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            );
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
    );
        }
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        );
        );
        assertNotNull("MULTI_MATCH serializer must be registered", serializer);
    /**
            QueryStringQueryBuilder queryStringQb = (QueryStringQueryBuilder) deserialized;
        RexNode fieldMap = rexBuilder.makeCall(
    @Override
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     * Tests that serializers with no optional params produce default QueryBuilders.
        byte[] serialized = serializer.serialize(call, fieldStorage);
            assertTrue(
    // --- Helper methods ---
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
     * Tests that flags="ALL" works correctly on SimpleQueryStringBuilder.
            Map.of("fuzzy_rewrite", "constant_score")
            OperandTypes.ANY,
        }
     * Tests that SQL '%' wildcard is converted to Lucene '*'.
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        assertNotNull("MATCH serializer must be registered", serializer);
        );
            RexNode paramMap = rexBuilder.makeCall(
            assertTrue("Deserialized must be WildcardQueryBuilder", deserialized instanceof WildcardQueryBuilder);
            Map.of("flags", "ALL")
            functionName,
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            rexBuilder.makeLiteral("query"),
        assertNotNull("WILDCARD_QUERY serializer must be registered", serializer);
                SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        // Query MAP: MAP('query', 'text')
            assertEquals("hello*world?", wildcardQb.value());
            assertEquals(Operator.AND, queryStringQb.defaultOperator());
        );
    }
import org.opensearch.index.query.SimpleQueryStringBuilder;
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) deserialized;
        );
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        RexCall call = buildSingleFieldRexCallWithParams("body", "quick fox", "MATCH_PHRASE", Map.of("slop", "2"));
            List.of("title", "body"),
        List<FieldStorageInfo> fieldStorage = List.of(
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY);
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            ScalarFunction.MATCH_PHRASE,
    /**
     * Tests QuerySerializer with default_operator=AND optional param round-trip.
            new NamedWriteableRegistry.Entry(QueryBuilder.class, SimpleQueryStringBuilder.NAME, SimpleQueryStringBuilder::new),
        );
    }
        operands.add(queryMap);
        );
        List<RexNode> operands = new ArrayList<>();
        null,
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
            QueryStringQueryBuilder queryStringQb = (QueryStringQueryBuilder) deserialized;
            SimpleQueryStringBuilder expected = new SimpleQueryStringBuilder("search text");
            rexBuilder.makeLiteral("query"),
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            "QUERY_STRING",
import org.opensearch.index.query.MatchPhrasePrefixQueryBuilder;
        }
    /**
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MULTI_MATCH);
    public void testSerializeMatchWithMaxExpansions() throws IOException {
        }
        }
     * Tests that fuzziness=AUTO round-trips correctly on QueryStringQueryBuilder.
        );
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        byte[] serialized = serializer.serialize(call, fieldStorage);
            ScalarFunction.EQUALS,
            assertEquals("title", wildcardQb.fieldName());
    /**
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
     * Tests that a backslash before a non-wildcard character preserves both characters.
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH);
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
     */
        RexNode queryMap = rexBuilder.makeCall(
        byte[] serialized = serializer.serialize(call, fieldStorage);
        // Should not throw any exception
        byte[] serialized = serializer.serialize(call, fieldStorage);
            exception.getMessage().contains("wildcard_query")
            SimpleQueryStringBuilder simpleQsQb = (SimpleQueryStringBuilder) deserialized;
            assertEquals("search text", queryString.queryString());
    }
     */
            assertEquals("title", matchQuery.fieldName());
        byte[] serialized = serializer.serialize(call, fieldStorage);
import org.apache.calcite.sql.type.ReturnTypes;
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            assertEquals(50, matchQuery.maxExpansions());
            MatchBoolPrefixQueryBuilder matchBoolPrefix = (MatchBoolPrefixQueryBuilder) deserialized;
            ScalarFunction.QUERY,
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        byte[] serialized = serializer.serialize(call, fieldStorage);
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
     * Validates Requirement 11.3.
        assertNotNull("MULTI_MATCH serializer must be registered", serializer);
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchQueryBuilder.NAME, MatchQueryBuilder::new),
import org.apache.calcite.rex.RexBuilder;
                SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            assertEquals(MultiMatchQueryBuilder.Type.PHRASE, multiMatch.getType());
            SimpleQueryStringBuilder simpleQsQb = (SimpleQueryStringBuilder) deserialized;
        super.setUp();
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        );
            Map.of("lenient", "true")
            // Build an expected builder with ALL flag to verify equality
            ScalarFunction.SARG_PREDICATE
            new FieldStorageInfo("gender", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false, "keyword")
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MULTI_MATCH);
        );
    /**
            assertEquals("test*", wildcardQb.value());
        return (RexCall) rexBuilder.makeCall(sqlFunction, operands);
    private static final SqlFunction MATCHALL_FUNCTION = new SqlFunction(
        }
import org.opensearch.test.OpenSearchTestCase;
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new)
     * Tests mixed SQL wildcards and escaped wildcards in a single pattern.
    /**
            assertEquals("constant_score", multiMatch.fuzzyRewrite());
        byte[] serialized = serializer.serialize(call, fieldStorage);
        OperandTypes.ANY,
        operands.add(outerMap);
        }
    }
     */
        RexCall call = buildMultiFieldRexCallWithParams(
    /**
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            expected.field("title", 1.0f);
        "QUERY",
    /**
import org.opensearch.analytics.spi.ScalarFunction;
    }
    private RexCall buildMultiFieldRexCallWithParams(
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MULTI_MATCH);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            QueryStringQueryBuilder queryString = (QueryStringQueryBuilder) deserialized;
        }
            assertTrue(deserialized instanceof MultiMatchQueryBuilder);
            ScalarFunction.LESS_THAN,
            assertEquals("quick br", matchBoolPrefix.value());
     * Tests QuerySerializer throws IllegalArgumentException with "query" when query is missing.
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY_STRING);
            null,
            rexBuilder.makeLiteral("status:active AND type:premium")
     * Tests that serializeMatch with operator=AND produces a MatchQueryBuilder with AND operator.
        serializers = QuerySerializerRegistry.getSerializers();
            assertEquals("test\\", wildcardQb.value());
        byte[] serialized = serializer.serialize(call, fieldStorage);
            assertEquals("test\\n", wildcardQb.value());
     * Builds a multi-field RexCall with optional parameters:
    private static final NamedWriteableRegistry WRITEABLE_REGISTRY = new NamedWriteableRegistry(
    // --- QuerySerializer (no-field) tests ---
import org.opensearch.index.query.MatchPhraseQueryBuilder;
        }
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        "MATCHALL",
        RexCall call = buildSingleFieldRexCallWithParams("title", "hello", "MATCH", Map.of("lenient", "true"));
        }
     */
     * Tests that escaped SQL wildcards (\% and \_) are treated as literal characters.
     */
     */
import org.opensearch.index.query.MatchBoolPrefixQueryBuilder;
            new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new),
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
            assertEquals("search text", multiMatch.value());
        );
                rexBuilder.makeLiteral(entry.getKey()),
    public void testSerializeMatchPhrasePrefixWithBoost() throws IOException {
    public void testWildcardQuerySerializerRoundTrip() throws IOException {
    }
            assertEquals("quick fox", matchPhrase.value());
        List<FieldStorageInfo> fieldStorage = List.of(
            new FieldStorageInfo("body", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        RexCall call = buildSingleFieldRexCallWithParams("title", "hello world", "MATCH", Map.of("operator", "AND"));
            rexBuilder.makeInputRef(varcharType, 0)
        byte[] serialized = serializer.serialize(call, fieldStorage);
        );
        "WILDCARD_QUERY",
        RexCall call = buildSingleFieldRexCallWithParams("title", "test%", "WILDCARD_QUERY", Map.of());
    }
        byte[] serialized = serializer.serialize(call, fieldStorage);
     */
        RexNode unknownParamMap = rexBuilder.makeCall(
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.EQUALS);
import org.apache.calcite.sql.type.OperandTypes;
 * Unit tests for {@link QuerySerializerRegistry} serializers — optional parameter round-trips
            new NamedWriteableRegistry.Entry(QueryBuilder.class, QueryStringQueryBuilder.NAME, QueryStringQueryBuilder::new),
        }
            ScalarFunction.IS_NULL,
        assertNotNull("MULTI_MATCH serializer must be registered", serializer);
     */
        byte[] serialized = serializer.serialize(call, fieldStorage);
    public void testSerializeQueryStringWithPhraseSlop() throws IOException {
        SqlFunctionCategory.USER_DEFINED_FUNCTION
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            rexBuilder.makeLiteral("value")
            assertEquals("gender", term.fieldName());
        List<FieldStorageInfo> fieldStorage = List.of(
     * Tests QuerySerializer silently ignores unrecognized params.
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            assertEquals(expected, simpleQsQb);
        RexCall call = buildSingleFieldRexCallWithParams("title", "hello*world?", "WILDCARD_QUERY", Map.of());
            assertTrue(deserialized instanceof MatchQueryBuilder);
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            assertEquals("hello world", queryStringQb.queryString());
    private RelDataTypeFactory typeFactory;
        Map<String, String> optionalParams
            new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchBoolPrefixQueryBuilder.NAME, MatchBoolPrefixQueryBuilder::new),
    /**
        String queryText,
    // --- SimpleQueryString flags tests ---
        assertNotNull("SIMPLE_QUERY_STRING serializer must be registered", serializer);
import org.opensearch.index.query.MatchQueryBuilder;
    }
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        assertTrue(
        List<FieldStorageInfo> fieldStorage = List.of(
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        RexCall call = buildSingleFieldRexCallWithParams("title", "test\\", "WILDCARD_QUERY", Map.of());
        List<FieldStorageInfo> fieldStorage = List.of(
    }
    /**
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH);
            assertTrue(deserialized instanceof MatchQueryBuilder);
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            assertEquals("title", matchQuery.fieldName());
            assertEquals("quick br", matchPhrasePrefix.value());
    public void testWildcardQueryTrailingBackslash() throws IOException {
            ScalarFunction.MATCH_BOOL_PREFIX,
            rexBuilder.makeLiteral("AND")
        SqlFunction sqlFunction = new SqlFunction(
        SqlKind.OTHER_FUNCTION,
            assertEquals(3, matchBoolPrefix.prefixLength());
        }
            assertTrue("Deserialized must be WildcardQueryBuilder", deserialized instanceof WildcardQueryBuilder);
        }
            MatchPhraseQueryBuilder matchPhrase = (MatchPhraseQueryBuilder) deserialized;
        // Build a call with only field and query (no optional params)
            assertEquals("hello", matchQuery.value());
            functionName,
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     */
        List<FieldStorageInfo> fieldStorage = List.of();
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        assertNotNull("MATCH serializer must be registered", serializer);
            "hello",
            "search text",
        );
                rexBuilder.makeLiteral(entry.getValue())
        // Java string "\\n" is runtime chars: \, n
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        RexNode extraMap = rexBuilder.makeCall(
        assertTrue("Serialized bytes must not be empty", serialized.length > 0);
    }
        assertNotNull("QUERY serializer must be registered", serializer);
        RexCall call = (RexCall) rexBuilder.makeCall(QUERY_FUNCTION, fieldMap);
    /**
        );
        RexCall call = buildMultiFieldRexCallWithParams(
            assertEquals(2.5f, matchPhrase.boost(), 0.001f);
     * Tests that slop=3 round-trips correctly on MultiMatchQueryBuilder.
    }
    public void testEqualsOnTextFieldWithoutKeywordSubfieldKeepsField() throws IOException {
        List<FieldStorageInfo> fieldStorage = List.of(
            "SIMPLE_QUERY_STRING",
            Map.of("flags", "NONE|PREFIX|ESCAPE")
     * The flags should be applied without throwing, and the deserialized builder should match
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        );
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
            assertEquals("firstname", term.fieldName());
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY);
        RexCall call = buildSingleFieldRexCallWithParams("title", "%foo\\_bar_", "WILDCARD_QUERY", Map.of());
        RexCall call = (RexCall) rexBuilder.makeCall(
        assertNotNull("MATCHALL serializer must be registered", serializer);
     */
    }
     * FUNC(MAP('fields', MAP('field1', 1.0, 'field2', 1.0, ...)), MAP('query', 'text'), MAP('key1', 'val1'), ...)
            assertEquals("title", wildcardQb.fieldName());
    }
    public void testSerializeMultiMatchWithTypePhrase() throws IOException {
    /**
     */
            assertEquals("hello", matchQuery.value());
        }
     * Tests that boost=2.5 round-trips correctly on MatchPhraseQueryBuilder.
            assertTrue(deserialized instanceof MatchQueryBuilder);
        );
     * EQUALS on a TEXT field that has a keyword multifield must build the TermQuery against the
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        for (String field : fields) {
     * input). Mirrors the SQL engine's {@code OpenSearchTextType.convertTextToKeyword}.
        rexBuilder = new RexBuilder(typeFactory);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     * Tests QuerySerializer accepts missing field without exception (no-field variant).
            ScalarFunction.MATCH,
        List<FieldStorageInfo> fieldStorage = List.of(
        }
        SqlFunctionCategory.USER_DEFINED_FUNCTION
        }
        List<FieldStorageInfo> fieldStorage = List.of();
        RexNode operatorMap = rexBuilder.makeCall(
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            assertEquals("*foo_bar?", wildcardQb.value());
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
    ) {
        }
     */
            SqlKind.OTHER_FUNCTION,
            assertEquals("search text", simpleQsQb.value());
            rexBuilder.makeLiteral("default_operator"),
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        }
        // Build operand list
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
    /**
    private Map<ScalarFunction, DelegatedPredicateSerializer> serializers;
    /**
    /**
    // --- EQUALS text-field routing tests ---
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
     */
    /**
     * Tests WildcardQuerySerializer throws IllegalArgumentException with "wildcard_query" when field is missing.
            rexBuilder.makeLiteral("unknown_param"),
        assertNotNull("MATCH_PHRASE_PREFIX serializer must be registered", serializer);
    public void testWildcardQuerySerializerIgnoresUnrecognizedParams() throws IOException {
     * EQUALS on a TEXT field with NO keyword subfield leaves the field name unchanged (graceful
            new FieldStorageInfo("body", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_PHRASE_PREFIX);
            ScalarFunction.LESS_THAN_OR_EQUAL,
            assertTrue(deserialized instanceof MultiMatchQueryBuilder);
     * Tests that pipe-separated flags "NONE|PREFIX|ESCAPE" round-trip correctly on SimpleQueryStringBuilder.
    public void testQuerySerializerThrowsWhenQueryMissing() {
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH);
        List<FieldStorageInfo> fieldStorage = List.of(
            assertEquals("search text", multiMatch.value());
        );
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.unit.Fuzziness;
    }
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        OperandTypes.ANY,
        }
        );
        }
            assertTrue("Deserialized must be MatchAllQueryBuilder", deserialized instanceof MatchAllQueryBuilder);
        List<FieldStorageInfo> fieldStorage = List.of(
        null,
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
    public void testWildcardQueryConvertsUnderscoreToQuestionMark() throws IOException {
        RexNode queryMap = rexBuilder.makeCall(
     * Tests that each serializer in the registry is an instance of DelegatedPredicateSerializer
            assertNotNull("Serializer for " + entry.getKey() + " must not be null", entry.getValue());
     * (class instances, not method references).
        }
        String queryText,
        }
    public void testWildcardQueryConvertsPercentToStar() throws IOException {
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        List<FieldStorageInfo> fieldStorage = List.of(
        // Build operand list: field, query, then optional params
            assertEquals("title", matchBoolPrefix.fieldName());
        SqlFunctionCategory.USER_DEFINED_FUNCTION
    }
            // Default operator is OR
        }
        for (Map.Entry<ScalarFunction, DelegatedPredicateSerializer> entry : serializers.entrySet()) {
     */
        }
        )
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
    /**
    }
            assertEquals(2, queryString.phraseSlop());
    }
    /**
import java.io.IOException;
    public void testWildcardQueryEscapedBackslashFollowedByWildcard() throws IOException {
        List<FieldStorageInfo> fieldStorage = List.of(
    );
            rexBuilder.makeLiteral("query"),
        assertNotNull("MATCH_BOOL_PREFIX serializer must be registered", serializer);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY);
     * Tests WildcardQuerySerializer silently ignores unrecognized params.
 */
            rexBuilder.makeLiteral("query"),
            assertEquals(1.5f, matchPhrasePrefix.boost(), 0.001f);
        List<FieldStorageInfo> fieldStorage = List.of(
        assertNotNull("Serialized bytes must not be null", serialized);
    }
    private RexBuilder rexBuilder;
    /**
            "MULTI_MATCH",
     * Tests that fuzzy_rewrite="constant_score" round-trips correctly on MultiMatchQueryBuilder.
     */
    }
            assertEquals("gender.keyword", term.fieldName());
import java.util.Map;
        byte[] serialized = serializer.serialize(call, fieldStorage);
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
    /**
            operands.add(paramMap);
        );
    /**
        byte[] serialized = serializer.serialize(call, fieldStorage);
            SimpleQueryStringBuilder expected = new SimpleQueryStringBuilder("search text");
        RexCall call = (RexCall) rexBuilder.makeCall(QUERY_FUNCTION, queryMap);
        assertNotNull("WILDCARD_QUERY serializer must be registered", serializer);
            SqlStdOperatorTable.EQUALS,
            assertTrue("Deserialized must be QueryStringQueryBuilder", deserialized instanceof QueryStringQueryBuilder);
            assertEquals("title", wildcardQb.fieldName());
            TermQueryBuilder term = (TermQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
        }
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
            assertTrue(deserialized instanceof SimpleQueryStringBuilder);
        ReturnTypes.BOOLEAN,
    );
     * fallback — same as the SQL engine, which only rewrites when a keyword subfield exists).
        SqlFunction sqlFunction = new SqlFunction(
     * Tests that an escaped backslash (\\) followed by a wildcard correctly produces
        assertNotNull("QUERY_STRING serializer must be registered", serializer);
            operands.add(paramMap);
    }
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
    }
        operands.add(queryMap);
import org.opensearch.index.query.Operator;
/**
        );
        RexCall call = buildMultiFieldRexCallWithParams(
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
            rexBuilder.makeLiteral("F")
        }
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_PHRASE);
            ScalarFunction.MULTI_MATCH,
            assertEquals("body", matchPhrase.fieldName());
        RexCall call = (RexCall) rexBuilder.makeCall(WILDCARD_QUERY_FUNCTION, queryMap);
    public void testSerializeMultiMatchWithSlop() throws IOException {
            rexBuilder.makeLiteral("field"),
     * a literal backslash plus the converted wildcard.
            ScalarFunction.GREATER_THAN,
            rexBuilder.makeInputRef(varcharType, 0),
        Set<ScalarFunction> expected = Set.of(
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        byte[] serialized = serializer.serialize(call, fieldStorage);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        );
            assertEquals(2.5f, wildcardQb.boost(), 0.001f);
            "Exception message must contain 'wildcard_query', got: " + exception.getMessage(),
        assertEquals("Registry key set must match expected ScalarFunction set", expected, serializers.keySet());
import org.apache.calcite.sql.SqlKind;
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
            rexBuilder.makeLiteral("field"),
        }
            ScalarFunction.NOT_EQUALS,
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
            MatchPhraseQueryBuilder matchPhrase = (MatchPhraseQueryBuilder) deserialized;
        // Expected: first \ escapes second \ → literal \, then % is unescaped → *
            TermQueryBuilder term = (TermQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
    /**
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
        );
     * Tests WildcardQuerySerializer with boost optional param round-trip.
    }
        assertNotNull("WILDCARD_QUERY serializer must be registered", serializer);
     * Tests WildcardQuerySerializer round-trip with field and pattern.
import org.opensearch.index.query.MultiMatchQueryBuilder;
        }
            rexBuilder.makeLiteral("some_value")
        String fieldName,
    public void testEqualsOnTextFieldWithKeywordSubfieldRoutesToKeyword() throws IOException {
        byte[] serialized = serializer.serialize(call, fieldStorage);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        RexNode fieldMap = rexBuilder.makeCall(
        );
     * Tests that serializeMultiMatch with type=phrase produces a MultiMatchQueryBuilder with PHRASE type.
        // text field "gender" WITH a keyword subfield named "keyword".
        assertNotNull("WILDCARD_QUERY serializer must be registered", serializer);
    public void testSerializeSimpleQueryStringWithLenient() throws IOException {
        );
            rexBuilder.makeLiteral("Amber")
            ReturnTypes.BOOLEAN,
     */
        byte[] serialized = serializer.serialize(call, fieldStorage);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.WILDCARD_QUERY);
        RexCall call = buildMultiFieldRexCallWithParams(
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
     */
     */
    }
     * {@code .keyword} subfield. A raw TermQuery on the analyzed text field matches nothing
        List<FieldStorageInfo> fieldStorage = List.of();
     */
        );
        }
    public void testSerializeMatchPhraseWithSlop() throws IOException {
            assertEquals(3, multiMatch.slop());
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     */
     */
    /**
     * Tests that prefix_length=3 round-trips correctly on MatchBoolPrefixQueryBuilder.
        assertNotNull("MATCH serializer must be registered", serializer);
        );
        List<FieldStorageInfo> fieldStorage = List.of();
    public void testSerializeMatchPhraseWithBoost() throws IOException {
import org.opensearch.core.common.io.stream.StreamInput;
/*
     * FUNC(MAP('field', $0), MAP('query', 'text'), MAP('key1', 'val1'), MAP('key2', 'val2'), ...)
            assertEquals("title", matchQuery.fieldName());
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        byte[] serialized = serializer.serialize(call, fieldStorage);
        );
     */
            assertTrue("Deserialized must be QueryStringQueryBuilder", deserialized instanceof QueryStringQueryBuilder);
            ScalarFunction.WILDCARD_QUERY,
    /**
        RexCall call = buildSingleFieldRexCallWithParams("title", "100\\%\\_done", "WILDCARD_QUERY", Map.of());
    /**
     */
            expected.flags(SimpleQueryStringFlag.ALL);
    public void testSerializersAreDelegatedPredicateSerializerInstances() {
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.EQUALS);
        );
        byte[] serialized = serializer.serialize(call, fieldStorage);
    public void testWildcardQuerySerializerThrowsWhenFieldMissing() {
     */
        List.of(
        byte[] serialized = serializer.serialize(call, fieldStorage);
        RexCall call = buildSingleFieldRexCallWithParams("title", "hello", "MATCH", Map.of("max_expansions", "50"));
        // Operand 0: MAP('field', $0)
            rexBuilder.makeInputRef(varcharType, 0),
            expected.field("body", 1.0f);
        RexCall call = buildSingleFieldRexCallWithParams("body", "quick fox", "MATCH_PHRASE", Map.of("boost", "2.5"));
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.SIMPLE_QUERY_STRING);
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
     */
        List<String> fields,
import org.opensearch.index.query.TermQueryBuilder;
            MatchQueryBuilder matchQuery = (MatchQueryBuilder) deserialized;
        SqlKind.OTHER_FUNCTION,
    ) {
    }
        List<FieldStorageInfo> fieldStorage = List.of(
            rexBuilder.makeLiteral("unexpected"),
import java.util.ArrayList;
        List<FieldStorageInfo> fieldStorage = List.of(
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) deserialized;
            assertEquals(Operator.AND, matchQuery.operator());
        RexCall call = (RexCall) rexBuilder.makeCall(QUERY_FUNCTION, queryMap, operatorMap);
        );
    public void testRegistryKeySetMatchesExpectedFunctions() {
import java.util.List;
        try (StreamInput input = new NamedWriteableAwareStreamInput(StreamInput.wrap(serialized), WRITEABLE_REGISTRY)) {
        );
        byte[] serialized = serializer.serialize(call, fieldStorage);
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCHALL);
            ScalarFunction.SIMPLE_QUERY_STRING,
        operands.add(fieldMap);
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
     */
        }
        );
        List<FieldStorageInfo> fieldStorage = List.of();
        );
            List.of("title", "body"),
     */
        RexCall call = buildSingleFieldRexCallWithParams(
        assertTrue("Exception message must contain 'query', got: " + exception.getMessage(), exception.getMessage().contains("query"));
    }
    // --- WildcardQuerySerializer tests ---
        RexCall call = buildSingleFieldRexCallWithParams("body", "quick br", "MATCH_PHRASE_PREFIX", Map.of("boost", "1.5"));
        );
        typeFactory = new JavaTypeFactoryImpl();
    /**
        }
    }
    }
            assertTrue(deserialized instanceof MatchPhraseQueryBuilder);
            ReturnTypes.BOOLEAN,
            assertTrue("Deserialized must be QueryStringQueryBuilder", deserialized instanceof QueryStringQueryBuilder);
            rexBuilder.makeInputRef(varcharType, 0)
            assertEquals("title", matchQuery.fieldName());
    }
            expected.flags(SimpleQueryStringFlag.NONE, SimpleQueryStringFlag.PREFIX, SimpleQueryStringFlag.ESCAPE);
     * Tests that phrase_slop=2 round-trips correctly on QueryStringQueryBuilder.
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.MATCH_PHRASE);
        // Operand 1: MAP('query', 'queryText')
    }
     * Tests that a pattern with no SQL wildcards passes through unchanged.
 *
        String functionName,
        );
            MultiMatchQueryBuilder multiMatch = (MultiMatchQueryBuilder) deserialized;
    public void testSerializeMultiMatchWithFuzzyRewrite() throws IOException {
     * Validates Requirement 11.2.
     * EQUALS on a KEYWORD field is unchanged — no rewrite (it's already exact-match).
            OperandTypes.ANY,
        List<FieldStorageInfo> fieldStorage = List.of(
import java.util.Set;
            // Build an expected builder with the same flags to verify equality
        byte[] serialized = serializer.serialize(call, fieldStorage);
    }
            "search text",
    private RexCall buildSingleFieldRexCallWithParams(
            ScalarFunction.GREATER_THAN_OR_EQUAL,
            assertTrue(deserialized instanceof MatchQueryBuilder);
        OperandTypes.ANY,
        List<FieldStorageInfo> fieldStorage = List.of(
        DelegatedPredicateSerializer serializer = serializers.get(ScalarFunction.QUERY_STRING);
        List<FieldStorageInfo> fieldStorage = List.of(
    public void testSerializeMatchBoolPrefixWithPrefixLength() throws IOException {
            new FieldStorageInfo("title", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        RelDataType varcharType = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            WildcardQueryBuilder wildcardQb = (WildcardQueryBuilder) input.readNamedWriteable(QueryBuilder.class);
            ScalarFunction.MATCH_PHRASE_PREFIX,
 * and SQL text relevance serializer behavior (WILDCARD_QUERY, QUERY, MATCHALL).
package org.opensearch.be.lucene;
        // Outer MAP: MAP('fields', nestedMap)
            new NamedWriteableRegistry.Entry(QueryBuilder.class, WildcardQueryBuilder.NAME, WildcardQueryBuilder::new),
            assertTrue(deserialized instanceof MatchBoolPrefixQueryBuilder);
    public void testSerializeQueryStringWithFuzziness() throws IOException {
    public void setUp() throws Exception {
        RexNode nestedMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, nestedMapOperands);
            ScalarFunction.PREFIX_QUERY,
            assertEquals("hello", matchQuery.value());
import org.opensearch.index.query.MatchAllQueryBuilder;
            assertEquals("quick fox", matchPhrase.value());
        }
        assertNotNull("SIMPLE_QUERY_STRING serializer must be registered", serializer);
            rexBuilder.makeLiteral("F")
            assertEquals("test*", wildcardQb.value());
            List.of("title", "body"),
     * Validates Requirement 11.9.
        Map<String, String> optionalParams
    public void testSerializeSimpleQueryStringWithPipeSeparatedFlags() throws IOException {
    // --- SQL-to-Lucene wildcard conversion tests ---
    /**
    private static final SqlFunction QUERY_FUNCTION = new SqlFunction(
            QueryBuilder deserialized = input.readNamedWriteable(QueryBuilder.class);
import org.apache.calcite.rex.RexNode;
     */
        }
    private static final SqlFunction WILDCARD_QUERY_FUNCTION = new SqlFunction(
    /**
        byte[] serialized = serializer.serialize(call, fieldStorage);
            new FieldStorageInfo("body", "text", FieldType.TEXT, List.of(), List.of("lucene"), List.of(), false)
        byte[] serialized = serializer.serialize(call, fieldStorage);
import org.apache.calcite.jdbc.JavaTypeFactoryImpl;
    public void testWildcardQueryMixedEscapedAndUnescaped() throws IOException {
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
        RexCall call = buildSingleFieldRexCallWithParams("title", "test*", "WILDCARD_QUERY", Map.of("unknown_param", "value"));
