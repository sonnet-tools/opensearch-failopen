     * accepted via the extractor path and routes to the full-text backend — the extractor surfaces
    public void testMatchDelegationOverMultiIndexAlias() {
 * SPDX-License-Identifier: Apache-2.0
            exception.getMessage().contains("text and keyword")
                return "bad-backend";
        RexNode condition
            innerMapOperands.add(rexBuilder.makeApproxLiteral(BigDecimal.valueOf(1.0)));
        assertFalse(result.getViableBackends().contains(MockLuceneBackend.NAME));
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
            "test_index",
        assertFalse(
        RelOptTable table = mockTable("test_index", new String[] { "location" }, new SqlTypeName[] { SqlTypeName.OTHER });
    public void testDeeplyNestedScalarFunctionsDropLucene() {
        String[] indexNames,
                    1,
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
                Map.of("type", "integer", "index", true),
        OpenSearchFilter result = runFilterWithBlockList(
        PlannerContext context = buildContext("parquet", Map.of("eventTime", Map.of("type", "date")));
     */
            @Override
            "parquet",
     */
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR },
        );
        String[] fieldNames,
     * HAVING on a derived column (the aggregate's {@code total_size} output) plans without
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
            new String[] { "category" },
     * table name. The fragment's table name is the first index in the list — that's what the
     * formats via {@code putIfAbsent}. A future regression that drops index formats during the
        assertTrue("Error must hint at typed comparison: " + exception.getMessage(), exception.getMessage().contains("typed comparison"));
     * {@link #testQueryStringWildcardFieldPatternIsAccepted}.)
            "parquet",
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> runPlanner(filter, context));
     * exercises the {@code keyword} acceptance path.
     *
        RelOptTable table = mockTable(
        RexNode unknownCall = rexBuilder.makeCall(unknown, rexBuilder.makeInputRef(varchar, 0));
        );
     * the field with identical (keyword, indexed) settings, and
        assertPredicateAnnotation(matchPred, MockLuceneBackend.NAME);
        AnalyticsSearchBackendPlugin badBackend = new AnalyticsSearchBackendPlugin() {
        // MATCH_PHRASE predicate has Lucene as delegation target
    /**
     */
        );
     * block targets a different backend namespace that doesn't exist.
            "Message must indicate no backend can evaluate the predicate, got: " + exception.getMessage(),
            "parquet",
            new SqlTypeName[] { SqlTypeName.VARCHAR },
            ReturnTypes.BOOLEAN,
    /**
        assertEquals("Only DataFusion remains viable for the scalar-function leaf", 1, upperEqAnnotated.getViableBackends().size());
    public void testKeywordEqualsAnnotatedWithBothBackends() {
    // ---- Text-relevance function on non-text field type-check ----
        FieldReferences refs = new FieldReferences(List.of("severityNumber"), List.of(), false);
        SqlTypeName[] fieldTypes,
        assertNotNull("Planner must produce a plan for HAVING on derived column", result);
                        return refs;
            Map.of(
        RexNode predicate = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, level1, rexBuilder.makeLiteral("FOO"));
            List.of(OpenSearchFilter.class, OpenSearchTableScan.class),
        }
            new String[] { "status", "s", "num" },
     * can evaluate every leaf, throwing the "No backend can execute filter" error. This pins
        PlannerContext context = buildContext("parquet", Map.of("name", Map.of("type", "keyword", "index", true)));
            "Message must name the unrecognized scalar function",
        PlannerContext context = buildContext("parquet", Map.of("severityNumber", Map.of("type", "long")), backendsWithExtractor(refs));
            "Message must indicate the operator-level mismatch, got: " + exception.getMessage(),
            new SqlTypeName[] { SqlTypeName.VARCHAR },
            new SqlTypeName[] { SqlTypeName.VARCHAR },
     * Each leaf is individually viable on different single backends — P1 (MATCH) is Lucene-only,
                "status",
            protected Set<DelegationType> supportedDelegations() {
     * {@code category} as a literal, which the planner type-checks as keyword (valid).
        );
    public void testBlockListIgnoredWhenAllViableBackendsBlock() {
     * suppress the un-evaluable leaf's failure and (b) the error message stays per-leaf
     * A wildcard field pattern (e.g. {@code ser*}) is classified as a pattern, not a literal, so it
            SqlKind.OTHER_FUNCTION,
        RexNode predicate = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, upperCall, rexBuilder.makeLiteral("US"));
     * derived column.
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
            )
    private OpenSearchFilter runFilterWithBlockList(
        );
        RexCall andCondition = (RexCall) result.getCondition();
            blockList
        RexNode condition = makeCall(SqlStdOperatorTable.AND, makeCall(SqlStdOperatorTable.OR, p1, p2), p3);
        );
import org.opensearch.analytics.settings.DelegationBlockList;
import org.opensearch.analytics.spi.ScalarFunction;
            protected Set<DelegationType> acceptedDelegations() {
        RexCall orBranch = (RexCall) andCondition.getOperands().get(0);
     * Lucene index format so a {@code MATCH} predicate on it delegates to the Lucene backend.
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();
            SqlFunctionCategory.USER_DEFINED_FUNCTION
        assertTrue(
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        );
import org.apache.calcite.rex.RexCall;
        // index=false strips the inverted index so no backend can satisfy the full-text predicate
        assertPredicateAnnotation(matchPred, MockLuceneBackend.NAME);
        RexNode condition
        assertTrue("DataFusion stays viable", annotated.getViableBackends().contains(MockDataFusionBackend.NAME));
        );
            }
        );
        AnnotatedPredicate upperEqAnnotated = (AnnotatedPredicate) andCondition.getOperands().get(1);
    private static SqlFunction fullTextSqlFunction(String name) {
        assertTrue(exception.getMessage().contains("text and keyword"));
    public void testBlockListUnknownBackendIsNoOp() {
        RexNode condition = makeMultiFieldFullTextCall(fullTextSqlFunction("QUERY_STRING"), List.of("eventTime"), "2026-01-01");
                return Set.of(DelegationType.FILTER);
    /**
    public void testNativePredicateAnnotatedWithBothBackends() {
        String[] fieldNames,
 * delegation, and derived column handling.
        assertTrue("Error must name the function: " + exception.getMessage(), exception.getMessage().contains("QUERY_STRING"));
     */
                };
        );
                Map.of("type", "keyword", "index", true),
        RelOptTable table = mockTable("test_index", new String[] { "eventTime" }, new SqlTypeName[] { SqlTypeName.DATE });
        assertTrue("Message must name the offending leaf's comparator", exception.getMessage().contains("GREATER_THAN"));
            makeCall(
        RelOptTable table = mockTable("test_index", new String[] { "n" }, new SqlTypeName[] { SqlTypeName.INTEGER });
        RexNode badLeaf = rexBuilder.makeCall(SqlStdOperatorTable.GREATER_THAN, expCall, rexBuilder.makeLiteral(1.0, doubleType, true));
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
     * <pre>
            List.of(DATAFUSION, LUCENE),
    }
                SqlStdOperatorTable.OR,
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
        PlannerContext context = buildContext(format, fields, List.of(DATAFUSION, LUCENE));
            new SqlTypeName[] { SqlTypeName.VARCHAR },
     *
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        );
        );
    }
                        return Set.of(DelegationType.FILTER);
    /**
            IllegalStateException.class,
        return List.of(df, lucene);
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        // Operator-level: only child backend (no delegation configured)
            innerMapOperands.add(rexBuilder.makeLiteral(fieldName));
     */
        // P3 (SIN > 0.5) — exactly DataFusion; Lucene declares no scalar capability for SIN
        RelOptTable table = mockTable("test_index", new String[] { "name" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
            "parquet",
        assertEquals("Only DataFusion remains viable", 1, annotated.getViableBackends().size());
import org.apache.calcite.sql.type.ReturnTypes;
            List.of(
            stubScan(table),
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
            fieldTypes,
    // ---- Error cases ----
import org.apache.calcite.util.ImmutableBitSet;
        RexNode innerCall = rexBuilder.makeCall(expFn, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0));
            "test_index",
        );
     * unevaluable on every backend. Marking should fail fast and the error should name
    ) {
            "Lucene must be excluded only on the scalar-function leaf",
     * keyword fields are valid for text-relevance functions.
            Map.of("country_name", Map.of("type", "keyword", "index", true)),
        RexNode condition = makeFullTextCall(fullTextSqlFunction("MATCH_PHRASE"), 0, "hello world");
            "parquet",
     */
            fullTextSqlFunction("QUERY_STRING"),
            new SqlTypeName[] { SqlTypeName.VARCHAR },
                    false,
     * DataFusion — so the predicate is never delegated to Lucene.
        assertPredicateAnnotation(equalsPred, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
    /**
            "parquet",
        );
        );
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);
            blockList
 *
            new String[] { "status" },
            Map.of("country_name", Map.of("type", "keyword", "index", true)),
                    typeFactory.createSqlType(SqlTypeName.INTEGER),
     * <p>Implementation note: with the current per-index storage helpers, both backings declare
    /**
    /** Unsupported field type for operator — errors. */
        );
     * shape, but with FILTER delegation registered (DataFusion drives, Lucene accepts).
        // EXP(num) > 1.0 (no backend declares EXP)
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
            makeMultiFieldFullTextCall(fullTextSqlFunction("QUERY_STRING"), List.of("status"), "active")
        for (String backend : expectedBackends)
            }
            )
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
     * support UPPER, so the predicate is no longer viable for Lucene.
        RelDataType integer = typeFactory.createSqlType(SqlTypeName.INTEGER);
        assertPredicateAnnotation(equalsPred, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
    public void testInStringLiteralNonTextRejectedViaExtractor() {
                    }
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
        String format,
        RexCall andCondition = (RexCall) result.getCondition();
        AnnotatedPredicate matchPred = (AnnotatedPredicate) orBranch.getOperands().get(0);
        // status = 200
        RelOptTable table = mockTable("test_index", new String[] { "status" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
    }
    public void testQueryStringOnDateFieldIsRejected() {
     * Builds a field-less full-text {@code RexCall} matching the shape the SQL plugin lowers
     * leaf and drops only on the second.
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
                "status",
                    }
            Map.of("status", Map.of("type", "integer", "index", true), "country_name", Map.of("type", "keyword", "index", true)),
    /**
                Map.of("type", "keyword", "index", true),
    }
            new String[] { "status", "country_name" },
        RelOptTable table = mockTable("test_index", new String[] { "severityNumber" }, new SqlTypeName[] { SqlTypeName.BIGINT });
import org.apache.calcite.sql.SqlFunction;
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
     * than an {@link IllegalStateException} (which would be redacted as a 500).
        assertTrue(matchPred.getOriginal().toString().contains("MATCH"));
        PlannerContext context = buildContext("parquet", Map.of("severityNumber", Map.of("type", "long")));
    public void testAndWithDelegationBothViable() {
     * Four-level nesting: {@code UPPER(CONCAT(UPPER(CONCAT(name, '_a')), '_b')) = 'FOO'}.
            backendsWithExtractor(refs),
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> runPlanner(filter, context));
        // P1: MATCH(s, 'foo') — full-text predicate, Lucene-only (DataFusion declares no FULL_TEXT caps).
            () -> new CapabilityRegistry(List.of(badBackend), idx -> null)
        return new SqlFunction(
        RexNode level4 = rexBuilder.makeCall(SqlStdOperatorTable.CONCAT, rexBuilder.makeInputRef(varchar, 0), rexBuilder.makeLiteral("_a"));
     */
        SqlTypeName[] fieldTypes,
            new SqlTypeName[] { SqlTypeName.VARCHAR },
    public void testNoScalarFunctionsKeepsLuceneViable() {
            condition
    // ---- Scalar-function capability narrowing ----
        assertTrue(predicate.getOriginal().toString().contains("MATCH_PHRASE"));
    public void testInnerScalarWithNoBackendSupportThrows() {
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();
            Map.of(
        );
    /** Keyword equality — both backends viable per-predicate, operator-level only child. */
     * (nested UPPER). Each leaf is annotated independently: Lucene stays on the first
            OperandTypes.ANY,
    private OpenSearchFilter runMultiIndexFilter(
        return rexBuilder.makeCall(function, fieldsMap, queryMap);
        assertTrue(exception.getMessage().contains("No backend can evaluate filter predicate"));
            makeMultiFieldFullTextCall(fullTextSqlFunction("QUERY_STRING"), List.of("ser*"), "active")
     * {@code search source=idx category=A} into. There is no {@code fields} MAP, so no literal field
    /**
            Map.of("country_name", Map.of("type", "keyword", "index", true)),
        String format,
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();
     *   QUERY_STRING(
        assertFalse(
            @Override
            @Override
        OpenSearchFilter result = runFilter(
import java.util.Set;
                    "total_size"
            "parquet",
    /**
        assertPipelineViableBackends(result, List.of(OpenSearchFilter.class, OpenSearchTableScan.class), expectedViable);
        LogicalAggregate aggregate = LogicalAggregate.create(
        assertPredicateAnnotation(matchPred, MockLuceneBackend.NAME);
        OpenSearchFilter result = runMultiIndexFilter(
        );
            "severityNumber:>15"
    private RexNode makeMultiFieldFullTextCall(SqlFunction function, List<String> fieldNames, String query) {
                makeFullTextCall(fullTextSqlFunction("MATCH"), 1, "error")
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
     * Regression test for the {@code search}-command 500 (no {@code fields} MAP present).
    }
        assertEquals(2, annotated.getViableBackends().size());
        return (OpenSearchFilter) result;
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
import java.util.Map;
        );
        RexNode innerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, innerMapOperands);
            @Override
import org.opensearch.analytics.spi.EngineCapability;
            protected Set<DelegationType> acceptedDelegations() {
            SqlFunctionCategory.USER_DEFINED_FUNCTION
            OperandTypes.ANY,
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
        MockDataFusionBackend df = new MockDataFusionBackend() {
            }
 * compatible open source license.
            "Eager type-rejection must have been skipped: " + exception.getMessage(),
        String format,
        RexCall orCondition = (RexCall) result.getCondition();
    ) {
            makeFieldlessFullTextCall(fullTextSqlFunction("QUERY_STRING"), "category:A")
     * field — but via the capability-viability path, not the friendly type-rejection. The distinct
        OpenSearchFilter result = runFilter(
                    stubScan(table),
            new String[] { "status", "message" },
        RexNode condition = makeMultiFieldFullTextCall(fullTextSqlFunction("QUERY_STRING"), List.of("nosuchfield"), "active");
     * error proves the lenient gate skipped {@code rejectNonTextFieldsForTextFunction}.
                AggregateCall.create(
        RexNode condition,
            @Override
     * field with {@code lenient=false}, so the planner rejects it — coverage the old MAP-literal
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> runPlanner(filter, context));
        List<AnalyticsSearchBackendPlugin> backends,
    }
            "parquet",
        OpenSearchFilter result = runFilterWithDelegation(
        RexNode upperCall = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, rexBuilder.makeInputRef(varchar, 1));
        assertFalse(
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
            format,
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        PlannerContext context = buildContext("parquet", Map.of("message", Map.of("type", "keyword", "index", false)));
    public void testFilterWithMixedBackendLeavesAndDelegationSucceeds() {
        RexNode upperCall = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, rexBuilder.makeInputRef(varchar, 1));
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
     * Inter-leaf "same backend" check: {@code (MATCH(s, 'foo') OR status = 200) AND >(SIN(num), 0.5)}.
        DelegationBlockList blockList = DelegationBlockList.fromMap(Map.of("not-a-backend", List.of(ScalarFunction.EQUALS)));
        LogicalFilter having = LogicalFilter.create(aggregate, havingCondition);
        );
            new String[] { "country_name" },
     */
            null,
        // doc_values=false, index=false, store=false → no storage in any format → error
        assertFalse(result.getViableBackends().contains(MockLuceneBackend.NAME));
            "parquet",
        OpenSearchFilter result = runFilterWithDelegation(
     * tokens are classified as patterns and are unaffected — see
            "parquet",
    public void testBackendWithFilterDelegationButNoFactory_throws() {
            annotated.getViableBackends().contains(MockLuceneBackend.NAME)
        RelOptTable table = mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
     * the delegation target.
        assertTrue(exception.getMessage().contains("severityNumber"));
     * There is no {@code fields} MAP — the field names live inside the query-string value itself.
    }
        );
     * run the predicate). Here both backends block EQUALS, so the annotation keeps both.
        );
     * A field named only inside the query string that resolves to a {@code keyword} field is
        assertPredicateAnnotation(annotated, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
     *
    /**
        RexNode predicate = rexBuilder.makeCall(
    }
        assertFalse(
                "num",
    /**
        // so the leaf narrows to [datafusion] via the new inner-call walk.
     * the cross-leaf constraint distinct from the per-leaf throw above.
        assertTrue(annotated.getViableBackends().contains(MockDataFusionBackend.NAME));
        DelegationBlockList blockList = DelegationBlockList.fromMap(Map.of(MockLuceneBackend.NAME, List.of(ScalarFunction.EQUALS)));
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
            List.of(),
    /**
        SqlFunction expFn = SqlStdOperatorTable.EXP;
import org.opensearch.analytics.spi.FieldStorageInfo;
        AnnotatedPredicate matchPred = (AnnotatedPredicate) orCondition.getOperands().get(1);
     * names are extracted; the field reference lives inside the Lucene query-string syntax. This must
        );
     * <p>Note: this fixture's mock DataFusion backend declares scan support only for
import org.opensearch.analytics.spi.DelegationType;
            shardCounts.put(name, 1);
    private List<AnalyticsSearchBackendPlugin> delegationBackends() {
        PlannerContext context = buildContext("parquet", Map.of("status", Map.of("type", "keyword", "index", true)));
        assertEquals("Only DataFusion remains viable", 1, annotated.getViableBackends().size());
        assertTrue(
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),
     * field keeps the scan viable (see note on {@link #testQueryStringOnKeywordFieldIsAccepted}),
    public void testQueryStringOnNumericFieldIsRejected() {
/**
        );
        assertTrue(exception.getMessage().contains("QUERY_STRING"));
        PlannerContext context = buildContextPerIndex(format, shardCounts, fields, delegationBackends());
            Map.of("status", Map.of("type", "integer", "index", true), "message", Map.of("type", "keyword", "index", true)),
            new String[] { "message" },
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        assertFalse(result.getViableBackends().contains(MockLuceneBackend.NAME));
            makeEquals(0, SqlTypeName.VARCHAR, "US"),
     * the unrecognized function.
     * Field-less {@code query_string('category:A')} — the form the PPL {@code search} command lowers
    }
        };
        return runFilter(
        DelegationBlockList blockList
     */
        assertTrue(matchPred.getOriginal().toString().contains("MATCH_PHRASE"));
     * cannot be applied to numeric fields.
        );
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
        RexCall andCondition = (RexCall) result.getCondition();
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);
    /**
                "num",
            SqlStdOperatorTable.GREATER_THAN,
     * unioned {@link org.opensearch.analytics.spi.FieldStorageInfo} must still expose the field's
                    SqlStdOperatorTable.SUM,
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,
            Map.of("category", Map.of("type", "keyword", "index", true)),
    public void testScalarFunctionNarrowingIsPerLeaf() {
    }
        );
        assertTrue("Message must name the outer comparator's kind", exception.getMessage().contains("GREATER_THAN"));
     * NOT be rejected — it falls back to the TEXT-type assumption and routes to the full-text backend.
     * into:
    /**
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
                "s",
        assertTrue("Message must name the offending leaf's field", exception.getMessage().contains("num:integer"));
        RexNode p1 = makeFullTextCall(fullTextSqlFunction("MATCH"), 1, "foo");
        RelNode result = unwrapExchange(runPlanner(filter, context));
     * here at all — the table-scan rule throws before the filter rule runs. This test therefore
            new String[] { "country_name" },
        assertTrue(exception.getMessage().contains("has no storage"));
        assertTrue(sinPred.getViableBackends().contains(MockDataFusionBackend.NAME));
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
            rexBuilder.makeLiteral(1000000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
     */
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
import org.apache.calcite.plan.RelOptTable;
        RelOptTable table = mockTable(indexNames[0], fieldNames, fieldTypes);
    }
     */
        MockLuceneBackend lucene = new MockLuceneBackend() {
            "Lucene must be excluded across deeply nested scalar-function calls",
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        RexNode p1 = makeFullTextCall(fullTextSqlFunction("MATCH"), 1, "foo");
            new String[] { "country_name" },
            "parquet",
            exception.getMessage().contains("Unrecognized scalar function [FAKE_UDF]")
     * Blocking a predicate for one backend must not affect a different, non-blocked predicate shape:
     * just the upstream aggregate's. The filter runs on the same backend that produced the
        AnnotatedPredicate matchPred = (AnnotatedPredicate) orCondition.getOperands().get(0);
            new String[] { "country_name" },
    }
import java.math.BigDecimal;
        Map<String, Map<String, Object>> fields,
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> runPlanner(filter, context));
     * <p>The viability failure is a query-level (client) error, so it surfaces as an
        );
        assertTrue("Error must name the offending field: " + exception.getMessage(), exception.getMessage().contains("severityNumber"));
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
    }
    /**
        PlannerContext context = buildContext("parquet", Map.of("n", Map.of("type", "integer", "index", true)));
        assertFalse(result.getViableBackends().contains(MockLuceneBackend.NAME));
        assertTrue(exception.getMessage().contains("long"));
        );
            Map.of("category", Map.of("type", "keyword", "index", true)),
    }
        String[] fieldNames,
            "parquet",
                    @Override
    // ---- Derived columns ----
                return Set.of(DelegationType.FILTER);
    }
        AnnotatedPredicate equalsPred = (AnnotatedPredicate) orCondition.getOperands().get(0);
        assertTrue(annotated.getViableBackends().contains(MockDataFusionBackend.NAME));
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
            makeFullTextCall(fullTextSqlFunction("MATCH_PHRASE"), 0, "hello world")
    /**
        };
     * via the delegation block-list must drop Lucene from the predicate's viable set, leaving only
            ReturnTypes.VARCHAR_2000,
    }
            public BackendCapabilityProvider getCapabilityProvider() {
                    public byte[] serialize(RexCall call, List<FieldStorageInfo> fieldStorage) {
        );
            exception.getMessage().contains("No backend can evaluate filter predicate")
    public void testFullTextViableWithDelegation() {
        return runFilter(format, fields, fieldNames, fieldTypes, condition, delegationBackends(), Set.of(MockDataFusionBackend.NAME));
        RexNode predicate = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, unknownCall, rexBuilder.makeLiteral("X"));
    }
            fields,
        RexNode condition = makeCall(
            exception.getMessage().contains("No backend can evaluate filter predicate")
        assertPredicateAnnotation(annotated, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
            makeFieldlessFullTextCall(fullTextSqlFunction("QUERY_STRING"), "category:A"),
import org.opensearch.analytics.spi.BackendCapabilityProvider;
            Map.of("status", Map.of("type", "keyword", "index", true)),
            new SqlTypeName[] { SqlTypeName.VARCHAR },
            }
            new String[] { "country_name" },
    }
        OpenSearchFilter result = runFilterWithBlockList(
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        assertPredicateAnnotation(plainEq, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
        MockDataFusionBackend df = new MockDataFusionBackend() {
                Map.of("type", "integer", "index", true),
                    }
            "parquet",
                        throw new UnsupportedOperationException("stub");
            }
        );
        OpenSearchFilter result = runFilterWithDelegation(
     * lowers {@code query_string(['fieldName'], 'queryText')} into:
        MockLuceneBackend lucene = new MockLuceneBackend() {
    }
    /**
        return rexBuilder.makeCall(function, queryMap);
     */
            SqlKind.OTHER_FUNCTION,
    /**
        RexNode sinCall = rexBuilder.makeCall(SqlStdOperatorTable.SIN, rexBuilder.makeInputRef(integer, 2));
                makeFullTextCall(fullTextSqlFunction("MATCH"), 0, "hello"),
        RexNode upperEq = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, upperCall, rexBuilder.makeLiteral("US"));
        assertFalse("Lucene dropped by block-list", annotated.getViableBackends().contains(MockLuceneBackend.NAME));
     * Variant of {@code runFilter} that resolves to {@code multipleIndexNames} concrete indices
     * operator-level intersection at {@code computeFilterViableBackends} finds no backend that
    }
        assertTrue(
        assertEquals("Operator-level viable backends must be exactly [datafusion]", 1, result.getViableBackends().size());
    /**
        assertTrue(equalsPred.getViableBackends().contains(MockLuceneBackend.NAME));
        );
        String[] fieldNames,
        OpenSearchFilter result = runFilterWithDelegation(
        DelegationBlockList blockList = DelegationBlockList.fromMap(
    }
        LogicalFilter filter = LogicalFilter.create(stubScan(table), predicate);
            null,
     * A nested scalar function that the framework doesn't know about (no entry in the
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;
     * blocking EQUALS for Lucene leaves a keyword-equality dual-viable annotation untouched when the
     * scan rule looks up; since all backings have the same mapping, the unioned field storage
     * {@code query_string(['status', 'severityNumber'], '...')} with a mixed field list
    ) {
        RelOptTable table = mockTable("test_index", new String[] { "severityNumber" }, new SqlTypeName[] { SqlTypeName.BIGINT });
     */
        assertTrue("Expected OpenSearchFilter, got " + result.getClass().getSimpleName(), result instanceof OpenSearchFilter);
        assertTrue("Expected OpenSearchFilter, got " + result.getClass().getSimpleName(), result instanceof OpenSearchFilter);
        String[] fieldNames,
            ImmutableBitSet.of(0),
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR },
        RexNode goodLeaf = makeEquals(0, SqlTypeName.INTEGER, 200);
                makeFullTextCall(fullTextSqlFunction("MATCH_PHRASE"), 1, "world")
        };
                Map.of("type", "integer", "index", true)
        assertEquals("P1 (MATCH) viable backends must be exactly [lucene]", 1, matchPred.getViableBackends().size());
        PlannerContext context = buildContext(
/*
     * P3 (SIN inner call) is DataFusion-only — and no FILTER delegation is registered. The
            new String[] { "idx_a", "idx_b" },
     * is expanded at execution. Guards the empty-literals fallback against the unknown-field rejection
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        );
        RelOptTable table = mockTable(
        RexNode condition = makeFieldlessFullTextCall(fullTextSqlFunction("QUERY_STRING"), "severityNumber:>15");
        RexNode upperCall = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, rexBuilder.makeInputRef(varchar, 0));
        assertTrue(exception.getMessage().contains("getInstructionHandlerFactory"));
     * throwing. The filter has no per-field storage to narrow on, so its viable backends are
     * sharing identical mapping/settings, simulating an alias scan. Uses
        return (OpenSearchFilter) result;
            condition,
        for (String fieldName : fieldNames) {
        RexCall orCondition = (RexCall) result.getCondition();
        };
     * </pre>
    /**
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();
     */
        assertFalse(
     * </pre>
    /** OR across backends — DF viable at operator, equals viable for both, MATCH delegated to Lucene. */
     */
            new String[] { "name" },
                "s",
    // ---- Viable backends with delegation ----
                Map.of("type", "integer", "index", true)
     * pin-pointable from logs.
     */
            "parquet",
            "Message must not conflate sibling leaves' fields",
            rexBuilder.makeLiteral("query"),
     *
                return Map.of(ScalarFunction.QUERY_STRING, stub);
            new String[] { "title", "body" },
            "parquet",
            Map.of("status", Map.of("type", "integer", "index", true), "size", Map.of("type", "integer", "index", true)),
        List<RexNode> innerMapOperands = new ArrayList<>();
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
    }
        OpenSearchFilter result = runFilter(
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
     * Baseline: {@code country = 'US'} has no nested scalar function, so both backends
     * has no value-producing scan capability, so a pure {@code text} field can't be scanned
        RelDataType integer = typeFactory.createSqlType(SqlTypeName.INTEGER);
                return Set.of(DelegationType.FILTER);
            new String[] { "message" },
import org.apache.calcite.sql.type.SqlTypeName;
            rexBuilder.makeLiteral(query)
import org.apache.calcite.rel.logical.LogicalFilter;
        SqlTypeName[] fieldTypes,
        OpenSearchFilter result = runFilterWithDelegation(
     * unknown field fails, rather than silently assuming TEXT and matching nothing. (Wildcard/regex
        assertTrue(phrasePred.getOriginal().toString().contains("MATCH_PHRASE"));
        for (String name : indexNames) {
     * {@code UPPER(country) = 'US'}: Lucene supports EQUALS on KEYWORD but does not
    public void testFilterWithMixedBackendLeavesAndNoDelegationThrows() {
        RelOptTable table = mockTable("test_index", fieldNames, fieldTypes);
    }
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
    public void testOrAcrossBackendsWithDelegation() {
     * Confirms the walk recurses through arbitrary depth; Lucene drops at any level it can't evaluate.
            Map.of("location", Map.of("type", "geo_point", "doc_values", false, "index", false, "store", false))
            new SqlTypeName[] { SqlTypeName.VARCHAR },
            "Should fail via viability, not eager rejection: " + exception.getMessage(),
            SqlStdOperatorTable.IS_NOT_NULL,
            )
        assertEquals("both backends still viable", 2, annotated.getViableBackends().size());
            Set.of(MockDataFusionBackend.NAME)
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();
                makeEquals(0, SqlTypeName.INTEGER, 200),
        IllegalStateException exception = expectThrows(
import org.apache.calcite.rex.RexNode;
     * <pre>
            Set.of(MockDataFusionBackend.NAME)
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.OTHER), 0)
    }
    ) {
            }
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
        );
        assertTrue(matchPred.getViableBackends().contains(MockLuceneBackend.NAME));
     * spanning multiple concrete indices must behave the same as MATCH on a single index.
        RexNode p3 = rexBuilder.makeCall(SqlStdOperatorTable.GREATER_THAN, sinCall, rexBuilder.makeLiteral(0.5, doubleType, true));
     * {@code query_string(['severityNumber'], '...')} on a {@code long} field is rejected
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
    public void testFullTextErrorsWithoutDelegation() {
    /** Full-text without delegation — errors. */
public class FilterRuleTests extends BasePlannerRulesTests {
    /** Integer equality — both backends can evaluate natively. */
                Map.of("type", "integer", "index", true),
    public void testBlockListDropsBlockedBackendFromPredicate() {
import org.opensearch.analytics.settings.PlannerSettings;
     */
    public void testErrorForUnsupportedFieldTypeOperatorCombo() {
        SqlTypeName[] fieldTypes,
     * marks {@code [datafusion]} at the operator level and P1's annotation lists Lucene as
     * Nested boolean tree {@code AND( $0 = 200 , OR( UPPER($s) = 'X' , >(EXP($num), 1.0) ) )}.
            @Override
     * {@link IllegalArgumentException} (HTTP 400 with the actionable message preserved) rather
    ) {
     * rejection. The query still fails — no backend supports {@code query_string} on a {@code long}
            "parquet",
    private void assertPredicateAnnotation(AnnotatedPredicate predicate, String... expectedBackends) {
                    public FieldReferences referencedFields(RexCall call, List<FieldStorageInfo> fieldStorage) {
        OpenSearchFilter result = runFilter(
            Map.of("country_name", Map.of("type", "keyword", "index", true)),
    private List<AnalyticsSearchBackendPlugin> backendsWithExtractor(FieldReferences refs) {
                Map.of("type", "keyword", "index", true),
                    @Override
     * numeric/keyword/date/boolean types (not {@code text}), and the mock Lucene backend
        // UPPER(s) = 'X'
        RelOptTable table = mockTable(
     * and the existing "no backend can evaluate filter predicate" throw fires. Verifies the
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.INTEGER },
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);
            Map.of("country_name", Map.of("type", "keyword", "index", true)),
     * A literal field named in {@code query_string} that is absent from the scan's schema is an
        return (OpenSearchFilter) result;
        assertTrue("Message must name the field", exception.getMessage().contains("n:integer"));
        );
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
     * (names {@code GREATER_THAN} on {@code num:integer}, not the surrounding shape).
        AnnotatedPredicate matchPred = (AnnotatedPredicate) andCondition.getOperands().get(1);
     *     MAP('fields', MAP('fieldName':VARCHAR, 1.0:DOUBLE)),
        RelDataType integer = typeFactory.createSqlType(SqlTypeName.INTEGER);
     * Keyword equality is normally viable for both backends per-predicate (see
            Map.of("status", Map.of("type", "keyword", "index", true)),
            "parquet",
        RexNode p2 = makeEquals(0, SqlTypeName.INTEGER, 200);
                };
            "Lucene must not appear at the operator level — it accepts delegated leaves but doesn't drive",
    // ---- referencedFields-driven validation (Wave 4) ----
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
     *   QUERY_STRING(MAP('query', 'category:A':VARCHAR))
            result,
     * The deepest leaf has an inner {@code EXP} no backend declares; the throw fires from
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
            new String[] { "status", "s", "num" },
            "Message must indicate no backend can evaluate the predicate, got: " + exception.getMessage(),
        );
    /**
    public void testQueryStringWildcardFieldPatternIsAccepted() {
    }
        assertTrue(equalsPred.getViableBackends().contains(MockDataFusionBackend.NAME));
        assertEquals("P3 (SIN) viable backends must be exactly [datafusion]", 1, sinPred.getViableBackends().size());
 * this file be licensed under the Apache-2.0 license or a
        SqlTypeName[] fieldTypes,
import org.apache.calcite.sql.type.OperandTypes;
                return new BackendCapabilityProvider() {
            exception.getMessage().contains("No backend can evaluate")
                    @Override
                    public Set<DelegationType> supportedDelegations() {
import org.opensearch.analytics.spi.FieldReferences;
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
        );
            makeEquals(0, SqlTypeName.VARCHAR, "US")
        RexNode expCall = rexBuilder.makeCall(SqlStdOperatorTable.EXP, rexBuilder.makeInputRef(integer, 2));
}
        );
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR },
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
        RexNode queryMap = rexBuilder.makeCall(
        String format,
            assertTrue("Predicate annotation must contain " + backend, predicate.getViableBackends().contains(backend));
        AnnotatedPredicate phrasePred = (AnnotatedPredicate) orCondition.getOperands().get(1);
    }
        RexNode condition
     * unknown field — rejected with a "field not found" error, matching how a normal predicate on an
        }
            Map.of("status", Map.of("type", "keyword", "index", true), "severityNumber", Map.of("type", "long"))
    }
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR },
        Map<String, Map<String, Object>> fields,
        OpenSearchFilter result = runFilter(
        // P2: status = 200 — dual-viable on its own, doesn't help bridge P1 and P3.
        OpenSearchFilter result = runFilterWithDelegation(
     * returns {@code refs}).
    // ---- Per-predicate annotation tests ----
    /** AND with delegation — DF viable at operator, equals viable for both, MATCH_PHRASE delegated to Lucene. */
        AnnotatedPredicate equalsPred = (AnnotatedPredicate) orBranch.getOperands().get(1);
    }
            Map.of("message", Map.of("type", "keyword", "index", true)),
            Map.of("name", Map.of("type", "keyword", "index", true)),
        assertFalse(
        );
            "parquet",
        // P2 (EQUALS on integer) — exactly both backends, dual-viable.
        RexNode p2 = makeEquals(0, SqlTypeName.INTEGER, 200);
            fieldNames,
    }
        assertTrue("Expected OpenSearchFilter, got " + result.getClass().getSimpleName(), result instanceof OpenSearchFilter);
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        );
                "s",
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);
        );
    public void testFieldlessQueryStringIsAccepted() {
        AnnotatedPredicate equalsPred = (AnnotatedPredicate) andCondition.getOperands().get(0);
    /**
        assertTrue("Message must mention the missing delegation path", exception.getMessage().contains("no delegation path exists"));
     * Symmetric happy path: same {@code (MATCH(s, 'foo') OR status = 200) AND >(SIN(num), 0.5)}
            }
     * The operator-level intersection finds DataFusion as a viable driver — it evaluates
        PlannerContext context = buildContext(
        );
import org.apache.calcite.rel.logical.LogicalAggregate;
        );
        RexNode level2 = rexBuilder.makeCall(SqlStdOperatorTable.CONCAT, level3, rexBuilder.makeLiteral("_b"));
        assertTrue(
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
        RexNode level1 = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, level2);
            "parquet",
        );
            result.getViableBackends().contains(MockLuceneBackend.NAME)
        String format,
            makeEquals(0, SqlTypeName.VARCHAR, "US"),
    /** OR of two full-text predicates — DF viable at operator, both predicates delegated to Lucene. */
            ),
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
     * so planning reaches the filter rule and the {@code long} field triggers the rejection.
            "FAKE_UDF",
        RexNode sinCall = rexBuilder.makeCall(SqlStdOperatorTable.SIN, rexBuilder.makeInputRef(integer, 2));
        OpenSearchFilter result = runFilterWithDelegation(
     * that leaf and propagates up through OR and AND. Verifies (a) sibling leaves don't
     */
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);
import org.apache.calcite.rel.core.AggregateCall;
     * path missed (field-less queries previously fell back to the TEXT assumption and were accepted).
        );
    /** Full-text with delegation — both backends viable at operator level. */
    }
            public String name() {
 * Tests for filter rule: predicate annotation, viable backends computation,
                Map.of("type", "integer", "index", true)
        PlannerContext context = buildContext(
            new String[] { "status", "severityNumber" },
     */
import java.util.List;
    public void testQueryStringOnMixedFieldsRejectsBecauseOfNonTextField() {
            innerCall,
    public void testFilterOnDerivedColumnPlansSuccessfully() {
            upperEqAnnotated.getViableBackends().contains(MockLuceneBackend.NAME)
                "status",
     * {@code query_string('category:A')} (and the PPL {@code search} command's {@code category=A})
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);
import org.apache.calcite.sql.SqlKind;
                    }
    public void testQueryStringOnUnknownLiteralFieldIsRejected() {
     * <p>This pins the contract called out in the multi-index PR description: MATCH on an alias
        assertTrue(exception.getMessage().contains("bad-backend"));
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
     * With a backend serializer that reports field references, a field named only inside the
     * {@link org.opensearch.analytics.spi.ScalarFunction} enum) makes the predicate
            makeAnd(makeEquals(0, SqlTypeName.INTEGER, 200), makeFullTextCall(fullTextSqlFunction("MATCH_PHRASE"), 1, "timeout error"))
        RexNode condition,
        PlannerContext context = buildContext(format, fields, backends);
    /**
        OpenSearchFilter result = runFilterWithDelegation(
            blockList
        assertTrue(exception.getMessage().contains("date"));
            List.of("severityNumber"),
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
    public void testMultipleFullTextOrWithDelegation() {
        RelNode result = runPlanner(having, context);
        assertEquals("P2 (EQUALS) viable backends must be exactly [datafusion, lucene]", 2, equalsPred.getViableBackends().size());
     * {@link DelegatedPredicateSerializer} for {@code QUERY_STRING} whose {@code referencedFields}
        assertEquals(1, result.getViableBackends().size());
        java.util.Map<String, Integer> shardCounts = new java.util.LinkedHashMap<>();
                DelegatedPredicateSerializer stub = new DelegatedPredicateSerializer() {
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> runPlanner(filter, context));
     * {@link BasePlannerRulesTests#buildContextPerIndex} to register all indices under the same
        RelNode result = unwrapExchange(runPlanner(filter, context));
            "parquet",
        assertTrue("Error must name the field type: " + exception.getMessage(), exception.getMessage().contains("long"));
            Set.of(MockDataFusionBackend.NAME)
     * functions only apply to text/keyword.
            @Override
    private OpenSearchFilter runFilter(
        );
    }
     * P2 and P3 natively and delegates the MATCH leaf (P1) to Lucene. No throw; the filter
        FieldReferences refs = new FieldReferences(List.of("severityNumber"), List.of(), true);
     * {@link org.opensearch.analytics.planner.FieldStorageResolver#merged} preserves Lucene index
        // P1 (MATCH) — exactly Lucene; DataFusion will delegate it.
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.BIGINT }
            exception.getMessage().contains("No backend can execute filter")
        // Operator-level: DataFusion drives. Lucene is a delegation target only, never the driver.
        // DF is viable at operator level (has doc values in parquet)
    }
        RexNode condition = makeCall(SqlStdOperatorTable.AND, makeCall(SqlStdOperatorTable.OR, p1, p2), p3);
        RelOptTable table = mockTable("test_index", fieldNames, fieldTypes);
                )
     * error message names the outer comparator's SqlKind and the field, so the failure is
        assertTrue(predicate.getOriginal().toString().contains("MATCH_PHRASE"));
        context.setPlannerSettings(PlannerSettings.of(0.0, blockList));
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();
            Map.of("status", Map.of("type", "integer", "index", true), "message", Map.of("type", "keyword", "index", true)),
     * Safety invariant: blocking must never make a predicate unexecutable. If EVERY viable backend
    }
            "parquet",
     */
        assertEquals("both backends retained — blocking can't strand the predicate", 2, annotated.getViableBackends().size());
        RexNode condition = makeMultiFieldFullTextCall(
    /**
        // so the inner-call walk drops it.
    }
            predicate
        RexNode queryMap = rexBuilder.makeCall(
        assertTrue(exception.getMessage().contains("eventTime"));
     */
    public void testInStringLiteralKeywordAcceptedViaExtractor() {
        LogicalFilter filter = LogicalFilter.create(stubScan(table), predicate);
    /**
            new String[] { "category" },
 */
            name,
     * is never type-checked or treated as an unknown field — it routes to the full-text backend and
                "num",
        Map<String, Map<String, Object>> fields,
            null,
    /**
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
     * An explicit {@code lenient=true} (reported by the extractor) suppresses the eager type
        RexNode fieldsMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), innerMap);
        );
     * at planning with a precise, actionable error message — text-relevance functions
            )
        assertTrue(upperEqAnnotated.getViableBackends().contains(MockDataFusionBackend.NAME));
     * {@code query_string(['eventTime'], '...')} on a {@code date} field is rejected — text-relevance
import org.apache.calcite.sql.SqlFunctionCategory;
     */
    }
    public void testLenientTrueSuppressesEagerRejectionViaExtractor() {
     * union would surface as the assertion below failing.
        assertFalse("Lucene is delegation-only here", result.getViableBackends().contains(MockLuceneBackend.NAME));
 */
        PlannerContext context = buildContext("parquet", 1, Map.of("status", Map.of("type", "integer"), "size", Map.of("type", "integer")));
        assertTrue(exception.getMessage().contains("severityNumber"));
            annotated.getViableBackends().contains(MockLuceneBackend.NAME)
            Map.of(MockLuceneBackend.NAME, List.of(ScalarFunction.EQUALS), MockDataFusionBackend.NAME, List.of(ScalarFunction.EQUALS))
            Map.of(
        RexNode upperLeaf = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, upperCall, rexBuilder.makeLiteral("X"));
    /**
        assertTrue("DataFusion stays viable at the operator level", result.getViableBackends().contains(MockDataFusionBackend.NAME));
        RexNode p3 = rexBuilder.makeCall(SqlStdOperatorTable.GREATER_THAN, sinCall, rexBuilder.makeLiteral(0.5, doubleType, true));
        RelOptTable table = mockTable("test_index", new String[] { "severityNumber" }, new SqlTypeName[] { SqlTypeName.BIGINT });
     */
            new String[] { "status", "message" },
        PlannerContext context = buildContext(
        SqlFunction unknown = new SqlFunction(
     * Multi-index alias MATCH delegation: when a scan resolves to two backing indices, the
        AnnotatedPredicate sinPred = (AnnotatedPredicate) andCondition.getOperands().get(1);
        RexNode condition = makeCall(SqlStdOperatorTable.AND, goodLeaf, makeCall(SqlStdOperatorTable.OR, upperLeaf, badLeaf));
     */
    }
                    public Set<EngineCapability> supportedEngineCapabilities() {
     * (keyword + long) is rejected — every named field must be text/keyword. The keyword
    }
        assertTrue("Error must say not found: " + exception.getMessage(), exception.getMessage().contains("not found"));
     * matches single-index behavior.
                        return Set.of();
     * query string (no {@code fields} MAP) is now validated. The stub reports a literal {@code long}
            Map.of("message", Map.of("type", "keyword", "index", true)),
        RexNode condition = makeMultiFieldFullTextCall(fullTextSqlFunction("QUERY_STRING"), List.of("status", "severityNumber"), "error");
package org.opensearch.analytics.planner;
        );
            rexBuilder.makeLiteral(1.0, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)
            SqlStdOperatorTable.GREATER_THAN,
        Map<String, Map<String, Object>> fields,
        assertTrue(
                    @Override
     */
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
     * Predicate with a nested scalar function ({@code EXP}) that NO mock backend declares
            new SqlTypeName[] { SqlTypeName.VARCHAR },
            "parquet",
            new String[] { "country_name" },
     * AND of {@code status = 200} (no nested function) and {@code UPPER(country) = 'US'}
     * blocks the shape, the block-list is ignored and all backends remain (there is nowhere else to
        );
            "parquet",
        OpenSearchFilter result = runFilterWithBlockList(
     * Builds a multi-field full-text {@code RexCall} matching the shape that the SQL plugin
     * scalar capability for: viableSet collapses to empty after the inner-call intersection,
    }
            Map.of("title", Map.of("type", "keyword", "index", true), "body", Map.of("type", "keyword", "index", true)),
    }
            new String[] { "status" },
        // P3: SIN(num) > 0.5 — inner SIN is DataFusion-only (Lucene declares no ProjectCapability),
     *     MAP('query', 'queryText':VARCHAR)
     */
        Set<String> expectedViable
        // Lucene not viable at operator level — only delegation target
    }
            "Lucene must be excluded — no scalar capability for UPPER",
        Map<String, Map<String, Object>> fields,
            makeEquals(0, SqlTypeName.VARCHAR, "US")
     * added in {@link #testQueryStringOnUnknownLiteralFieldIsRejected}.
    /**
            protected Set<DelegationType> supportedDelegations() {
    }
            makeFullTextCall(fullTextSqlFunction("MATCH_PHRASE"), 0, "hello world")
        RexNode havingCondition = rexBuilder.makeCall(
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        assertPredicateAnnotation(phrasePred, MockLuceneBackend.NAME);
                SqlStdOperatorTable.OR,
        );
        RelNode result = unwrapExchange(runPlanner(filter, context));
        FieldReferences refs = new FieldReferences(List.of("category"), List.of(), false);
            rexBuilder.makeLiteral("query"),
            "test_index",
     */
    private OpenSearchFilter runFilterWithDelegation(
    public void testNestedAndOrWithUnevaluableLeafThrows() {
    public void testQueryStringOnKeywordFieldIsAccepted() {
     */
                return Set.of(DelegationType.FILTER);
            )
                    List.of(1),
    private OpenSearchFilter runFilter(
        return List.of(df, lucene);
            new String[] { "status", "size" },
            predicate
        );
    /** Mirrors {@code runFilter} but injects a {@link DelegationBlockList} into the planner context. */
     *   )
        PlannerContext context = buildContext("parquet", Map.of("severityNumber", Map.of("type", "long")), backendsWithExtractor(refs));
    public void testNestedScalarFunctionDropsLuceneFromPredicateAnnotation() {
            rexBuilder.makeLiteral(query)
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
    private RexNode makeFieldlessFullTextCall(SqlFunction function, String query) {
     * DataFusion (FILTER delegation) + Lucene (accepts FILTER delegation, registers a stub
     * {@link #testKeywordEqualsAnnotatedWithBothBackends}). Blocking EQUALS for the Lucene backend
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
        // natively, forcing the "without delegation" code path under test.
        AnnotatedPredicate plainEq = (AnnotatedPredicate) andCondition.getOperands().get(0);
    // ---- Helpers ----
            makeEquals(0, SqlTypeName.VARCHAR, "US"),
import java.util.ArrayList;
            makeCall(
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
    }
        RelOptTable table = mockTable("test_index", "status", "size");
import org.apache.calcite.rel.RelNode;
     * {@code query_string(['status'], '...')} on a {@code keyword} field is accepted —
            new String[] { "status", "s", "num" },
        assertTrue(matchPred.getOriginal().toString().contains("MATCH"));
            makeAnd(makeEquals(0, SqlTypeName.INTEGER, 200), upperEq)
    public void testUnrecognizedScalarFunctionThrows() {
            exception.getMessage().contains("status:") || exception.getMessage().contains("s:keyword")
    }
     * stay viable. Sets the expected shape that the next four tests narrow against.
        OpenSearchFilter result = runFilter(
        };
import org.apache.calcite.rel.type.RelDataType;
            Map.of("country_name", Map.of("type", "keyword", "index", true)),
        RexNode condition = makeFieldlessFullTextCall(fullTextSqlFunction("QUERY_STRING"), "severityNumber:>15");
            makeEquals(0, SqlTypeName.INTEGER, 200)
        OpenSearchFilter result = runFilter(
        assertPipelineViableBackends(
    }
        assertEquals(1, annotated.getViableBackends().size());
        RexNode level3 = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, level4);
        assertTrue("Error must name the unknown field: " + exception.getMessage(), exception.getMessage().contains("nosuchfield"));
 * The OpenSearch Contributors require contributions made to
