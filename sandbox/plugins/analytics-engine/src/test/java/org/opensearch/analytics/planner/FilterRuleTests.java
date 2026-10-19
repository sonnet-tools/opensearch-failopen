        assertPredicateAnnotation(plainEq, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);  
 * The OpenSearch Contributors require contributions made to  
        DelegationBlockList blockList
        RexNode p2 = makeEquals(0, SqlTypeName.INTEGER, 200);
            predicate
        }
        PlannerContext context = buildContext("parquet", Map.of("severityNumber", Map.of("type", "long")), backendsWithExtractor(refs));
                    false,  
                        return Set.of();  
        );
            protected Set<DelegationType> acceptedDelegations() {  
     * the delegation target.  
        SqlTypeName[] fieldTypes,  
        RexNode innerCall = rexBuilder.makeCall(expFn, rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 0));
        AnnotatedPredicate matchPred = (AnnotatedPredicate) orCondition.getOperands().get(1);  
    /**  
            SqlStdOperatorTable.IS_NOT_NULL,
                    @Override
        DelegationBlockList blockList = DelegationBlockList.fromMap(Map.of("not-a-backend", List.of(ScalarFunction.EQUALS)));
        RelOptTable table = mockTable("test_index", "status", "size");  
            @Override
        String[] fieldNames,  
        // EXP(num) > 1.0 (no backend declares EXP)
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
     */
    }  
     *
        );  
            innerMapOperands.add(rexBuilder.makeApproxLiteral(BigDecimal.valueOf(1.0)));
            shardCounts.put(name, 1);  
        RexNode queryMap = rexBuilder.makeCall(
     */
        );
        AnalyticsSearchBackendPlugin badBackend = new AnalyticsSearchBackendPlugin() {
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
        return rexBuilder.makeCall(function, queryMap);
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);  
            makeEquals(0, SqlTypeName.INTEGER, 200)  
            blockList  
            )  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
    private RexNode makeMultiFieldFullTextCall(SqlFunction function, List<String> fieldNames, String query) {  
     */
        MockLuceneBackend lucene = new MockLuceneBackend() {  
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();  
     * the unrecognized function.
    }  
        OpenSearchFilter result = runFilterWithDelegation(  
            makeAnd(makeEquals(0, SqlTypeName.INTEGER, 200), makeFullTextCall(fullTextSqlFunction("MATCH_PHRASE"), 1, "timeout error"))
            rexBuilder.makeLiteral(1000000, typeFactory.createSqlType(SqlTypeName.INTEGER), true)
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> runPlanner(filter, context));  
     * <pre>
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
        RelOptTable table = mockTable("test_index", new String[] { "n" }, new SqlTypeName[] { SqlTypeName.INTEGER });  
        assertTrue("DataFusion stays viable at the operator level", result.getViableBackends().contains(MockDataFusionBackend.NAME));  
            )
            null,
            ReturnTypes.VARCHAR_2000,
            rexBuilder.makeLiteral(query)
        );
            condition,
        assertTrue(exception.getMessage().contains("has no storage"));
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();
            makeEquals(0, SqlTypeName.VARCHAR, "US"),
            assertTrue("Predicate annotation must contain " + backend, predicate.getViableBackends().contains(backend));
    public void testFilterOnDerivedColumnPlansSuccessfully() {  
    ) {
    /**
        RexNode upperCall = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, rexBuilder.makeInputRef(varchar, 1));  
        assertTrue("Message must name the field", exception.getMessage().contains("n:integer"));
        );  
     * query string (no {@code fields} MAP) is now validated. The stub reports a literal {@code long}
            "parquet",
     * Baseline: {@code country = 'US'} has no nested scalar function, so both backends  
        AnnotatedPredicate plainEq = (AnnotatedPredicate) andCondition.getOperands().get(0);  
        PlannerContext context = buildContextPerIndex(format, shardCounts, fields, delegationBackends());
            "parquet",
        RexNode fieldsMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, rexBuilder.makeLiteral("fields"), innerMap);
            "test_index",
        SqlFunction expFn = SqlStdOperatorTable.EXP;
            }
    public void testErrorForUnsupportedFieldTypeOperatorCombo() {
                return Set.of(DelegationType.FILTER);  
            List.of(),  
        );
            "severityNumber:>15"
            "Lucene must be excluded only on the scalar-function leaf",
import org.apache.calcite.sql.SqlFunction;  
     */
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> runPlanner(filter, context));
            }
                    }  
                    @Override  
            result,
            ),  
        String format,
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);  
            Map.of("status", Map.of("type", "keyword", "index", true)),  
        };  
        RexNode p2 = makeEquals(0, SqlTypeName.INTEGER, 200);
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> runPlanner(filter, context));
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.OTHER), 0)
        );
    }
    }
            Map.of("status", Map.of("type", "integer", "index", true), "country_name", Map.of("type", "keyword", "index", true)),
    /**
    }  
        assertEquals("P2 (EQUALS) viable backends must be exactly [datafusion, lucene]", 2, equalsPred.getViableBackends().size());
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR },  
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
            "parquet",
                "status",  
        assertTrue("Error must name the unknown field: " + exception.getMessage(), exception.getMessage().contains("nosuchfield"));
        RexNode upperLeaf = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, upperCall, rexBuilder.makeLiteral("X"));  
package org.opensearch.analytics.planner;
        RexNode queryMap = rexBuilder.makeCall(
     */
        RelOptTable table = mockTable("test_index", fieldNames, fieldTypes);
            exception.getMessage().contains("No backend can evaluate")
        assertTrue(matchPred.getOriginal().toString().contains("MATCH"));  
        assertTrue("Message must name the offending leaf's field", exception.getMessage().contains("num:integer"));
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();  
     * path missed (field-less queries previously fell back to the TEXT assumption and were accepted).  
        );  
        // P2 (EQUALS on integer) — exactly both backends, dual-viable.  
     * DataFusion — so the predicate is never delegated to Lucene.
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
     * can evaluate every leaf, throwing the "No backend can execute filter" error. This pins
import java.util.ArrayList;
                    }
    /**
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
        );
        assertTrue("Expected OpenSearchFilter, got " + result.getClass().getSimpleName(), result instanceof OpenSearchFilter);  
        LogicalFilter filter = LogicalFilter.create(stubScan(table), predicate);
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();  
                    @Override  
        RexNode p3 = rexBuilder.makeCall(SqlStdOperatorTable.GREATER_THAN, sinCall, rexBuilder.makeLiteral(0.5, doubleType, true));  
            new SqlTypeName[] { SqlTypeName.VARCHAR },
     */  
    public void testNativePredicateAnnotatedWithBothBackends() {  
    public void testInStringLiteralNonTextRejectedViaExtractor() {
            Map.of("category", Map.of("type", "keyword", "index", true)),  
        };
        LogicalFilter having = LogicalFilter.create(aggregate, havingCondition);  
        assertTrue("Message must name the offending leaf's comparator", exception.getMessage().contains("GREATER_THAN"));
    /**
    public void testFullTextViableWithDelegation() {  
        RexNode condition = makeFieldlessFullTextCall(fullTextSqlFunction("QUERY_STRING"), "severityNumber:>15");  
     */  
            null,
            annotated.getViableBackends().contains(MockLuceneBackend.NAME)
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
                };
            Set.of(MockDataFusionBackend.NAME)
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
     * Keyword equality is normally viable for both backends per-predicate (see
            new String[] { "status", "s", "num" },  
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
            new String[] { "name" },  
        PlannerContext context = buildContext("parquet", Map.of("severityNumber", Map.of("type", "long")), backendsWithExtractor(refs));
     * names are extracted; the field reference lives inside the Lucene query-string syntax. This must
        assertTrue(sinPred.getViableBackends().contains(MockDataFusionBackend.NAME));
     * field — but via the capability-viability path, not the friendly type-rejection. The distinct
        assertPredicateAnnotation(annotated, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
     */
                Map.of("type", "integer", "index", true)
        // Operator-level: only child backend (no delegation configured)
        assertPredicateAnnotation(equalsPred, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
            upperEqAnnotated.getViableBackends().contains(MockLuceneBackend.NAME)
        assertPredicateAnnotation(equalsPred, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
            new SqlTypeName[] { SqlTypeName.VARCHAR },
    // ---- referencedFields-driven validation (Wave 4) ----  
     * </pre>
            "parquet",
        RelNode result = unwrapExchange(runPlanner(filter, context));  
            new String[] { "status", "severityNumber" },
import org.apache.calcite.sql.SqlKind;
            @Override
    }
                    stubScan(table),  
     * scalar capability for: viableSet collapses to empty after the inner-call intersection,
    private OpenSearchFilter runFilterWithDelegation(
        );
        Map<String, Map<String, Object>> fields,  
                AggregateCall.create(
     * Builds a field-less full-text {@code RexCall} matching the shape the SQL plugin lowers
            new String[] { "category" },  
            new String[] { "country_name" },
            "parquet",  
    /** Mirrors {@code runFilter} but injects a {@link DelegationBlockList} into the planner context. */  
    }  
 * this file be licensed under the Apache-2.0 license or a
            fieldNames,  
        RexNode level4 = rexBuilder.makeCall(SqlStdOperatorTable.CONCAT, rexBuilder.makeInputRef(varchar, 0), rexBuilder.makeLiteral("_a"));  
     * Builds a multi-field full-text {@code RexCall} matching the shape that the SQL plugin  
     * Symmetric happy path: same {@code (MATCH(s, 'foo') OR status = 200) AND >(SIN(num), 0.5)}
        assertTrue("Error must hint at typed comparison: " + exception.getMessage(), exception.getMessage().contains("typed comparison"));
     * (keyword + long) is rejected — every named field must be text/keyword. The keyword  
import org.apache.calcite.rel.type.RelDataType;  
                Map.of("type", "integer", "index", true),
            new String[] { "status", "size" },
        RexNode condition = makeCall(  
     * than an {@link IllegalStateException} (which would be redacted as a 500).
        String[] fieldNames,
        assertPredicateAnnotation(matchPred, MockLuceneBackend.NAME);
    /**  
import org.apache.calcite.rel.logical.LogicalFilter;
            makeEquals(0, SqlTypeName.VARCHAR, "US"),
        assertFalse(  
        // Operator-level: DataFusion drives. Lucene is a delegation target only, never the driver.  
        OpenSearchFilter result = runFilterWithBlockList(  
        RexNode condition = makeMultiFieldFullTextCall(fullTextSqlFunction("QUERY_STRING"), List.of("nosuchfield"), "active");  
        );
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR },
                makeFullTextCall(fullTextSqlFunction("MATCH"), 0, "hello"),
            null,  
            makeAnd(makeEquals(0, SqlTypeName.INTEGER, 200), upperEq)
        assertTrue("Expected OpenSearchFilter, got " + result.getClass().getSimpleName(), result instanceof OpenSearchFilter);
        // P1: MATCH(s, 'foo') — full-text predicate, Lucene-only (DataFusion declares no FULL_TEXT caps).  
    public void testNestedScalarFunctionDropsLuceneFromPredicateAnnotation() {
        assertTrue(exception.getMessage().contains("long"));
    public void testFullTextErrorsWithoutDelegation() {
            @Override
        RexNode condition = makeCall(SqlStdOperatorTable.AND, goodLeaf, makeCall(SqlStdOperatorTable.OR, upperLeaf, badLeaf));  
    public void testKeywordEqualsAnnotatedWithBothBackends() {  
        RexNode condition
                    public Set<EngineCapability> supportedEngineCapabilities() {
     * sharing identical mapping/settings, simulating an alias scan. Uses
        assertTrue(
            Map.of("location", Map.of("type", "geo_point", "doc_values", false, "index", false, "store", false))  
            SqlKind.OTHER_FUNCTION,  
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));  
     * derived column.
    /** OR of two full-text predicates — DF viable at operator, both predicates delegated to Lucene. */
 * SPDX-License-Identifier: Apache-2.0
        OpenSearchFilter result = runFilterWithDelegation(  
     *   QUERY_STRING(  
        RexNode p1 = makeFullTextCall(fullTextSqlFunction("MATCH"), 1, "foo");
    /**
     * HAVING on a derived column (the aggregate's {@code total_size} output) plans without
            rexBuilder.makeLiteral(query)
        RelOptTable table = mockTable(indexNames[0], fieldNames, fieldTypes);  
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();  
            Map.of(
     * Confirms the walk recurses through arbitrary depth; Lucene drops at any level it can't evaluate.
            rexBuilder.makeInputRef(typeFactory.createSqlType(SqlTypeName.INTEGER), 1),  
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);  
        PlannerContext context = buildContext(format, fields, backends);  
    /**
                    public byte[] serialize(RexCall call, List<FieldStorageInfo> fieldStorage) {
     * The operator-level intersection finds DataFusion as a viable driver — it evaluates  
    /** Integer equality — both backends can evaluate natively. */
            new String[] { "country_name" },
    }
import org.apache.calcite.rex.RexCall;
    /**
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        LogicalAggregate aggregate = LogicalAggregate.create(
     * <p>The viability failure is a query-level (client) error, so it surfaces as an
        MockDataFusionBackend df = new MockDataFusionBackend() {
        assertTrue("Error must name the field type: " + exception.getMessage(), exception.getMessage().contains("long"));  
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
     * {@link #testKeywordEqualsAnnotatedWithBothBackends}). Blocking EQUALS for the Lucene backend  
                    }  
        DelegationBlockList blockList = DelegationBlockList.fromMap(Map.of(MockLuceneBackend.NAME, List.of(ScalarFunction.EQUALS)));
            }  
            Set.of(MockDataFusionBackend.NAME)
                    1,
            innerMapOperands.add(rexBuilder.makeLiteral(fieldName));  
     */  
    public void testAndWithDelegationBothViable() {
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.VARCHAR },
        // status = 200
            OperandTypes.ANY,
            IllegalStateException.class,  
                        throw new UnsupportedOperationException("stub");  
                DelegatedPredicateSerializer stub = new DelegatedPredicateSerializer() {  
    }
        assertTrue(predicate.getOriginal().toString().contains("MATCH_PHRASE"));
        // Lucene not viable at operator level — only delegation target
        RexCall orCondition = (RexCall) result.getCondition();
        RexNode condition
        assertNotNull("Planner must produce a plan for HAVING on derived column", result);  
     * A field named only inside the query string that resolves to a {@code keyword} field is
            new String[] { "status" },
     * Regression test for the {@code search}-command 500 (no {@code fields} MAP present).  
     * tokens are classified as patterns and are unaffected — see
     *     MAP('fields', MAP('fieldName':VARCHAR, 1.0:DOUBLE)),
    }
     */
     * P2 and P3 natively and delegates the MATCH leaf (P1) to Lucene. No throw; the filter
            )
     * Lucene index format so a {@code MATCH} predicate on it delegates to the Lucene backend.  
     * The deepest leaf has an inner {@code EXP} no backend declares; the throw fires from  
            makeEquals(0, SqlTypeName.VARCHAR, "US")  
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);  
     * A wildcard field pattern (e.g. {@code ser*}) is classified as a pattern, not a literal, so it
        RexNode upperCall = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, rexBuilder.makeInputRef(varchar, 0));
        OpenSearchFilter result = runMultiIndexFilter(  
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        RexNode upperCall = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, rexBuilder.makeInputRef(varchar, 1));
    /**  
        );  
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
            exception.getMessage().contains("status:") || exception.getMessage().contains("s:keyword")
    /**
        );
    public void testFilterWithMixedBackendLeavesAndNoDelegationThrows() {
     * <pre>
    /**  
        PlannerContext context = buildContext(
    /** Full-text without delegation — errors. */
    /**
 *
            "test_index",  
     * rejection. The query still fails — no backend supports {@code query_string} on a {@code long}
        RelNode result = runPlanner(having, context);
                    }
                "num",
        );
     * unevaluable on every backend. Marking should fail fast and the error should name  
     * P3 (SIN inner call) is DataFusion-only — and no FILTER delegation is registered. The  
            Map.of("status", Map.of("type", "keyword", "index", true), "severityNumber", Map.of("type", "long"))
import org.apache.calcite.sql.type.ReturnTypes;
     * error message names the outer comparator's SqlKind and the field, so the failure is  
        RexNode p1 = makeFullTextCall(fullTextSqlFunction("MATCH"), 1, "foo");  
        assertTrue(exception.getMessage().contains("text and keyword"));
            new String[] { "country_name" },  
     * cannot be applied to numeric fields.  
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        assertFalse(result.getViableBackends().contains(MockLuceneBackend.NAME));  
        OpenSearchFilter result = runFilterWithDelegation(
        assertPipelineViableBackends(
        assertEquals(2, annotated.getViableBackends().size());
     * Each leaf is individually viable on different single backends — P1 (MATCH) is Lucene-only,
        RelDataType integer = typeFactory.createSqlType(SqlTypeName.INTEGER);  
                "num",  
        RexNode predicate = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, level1, rexBuilder.makeLiteral("FOO"));
        RexNode havingCondition = rexBuilder.makeCall(
        );
        );  
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));  
        assertTrue(
        RelOptTable table = mockTable("test_index", new String[] { "name" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
            "Message must indicate no backend can evaluate the predicate, got: " + exception.getMessage(),  
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
        for (String fieldName : fieldNames) {
        SqlTypeName[] fieldTypes,
    public void testUnrecognizedScalarFunctionThrows() {  
                    public FieldReferences referencedFields(RexCall call, List<FieldStorageInfo> fieldStorage) {
    public void testInStringLiteralKeywordAcceptedViaExtractor() {
                    List.of(1),
    /**  
     * the cross-leaf constraint distinct from the per-leaf throw above.  
     * There is no {@code fields} MAP — the field names live inside the query-string value itself.
     * (names {@code GREATER_THAN} on {@code num:integer}, not the surrounding shape).  
     * pin-pointable from logs.
     *
        PlannerContext context = buildContext("parquet", Map.of("eventTime", Map.of("type", "date")));  
            new SqlTypeName[] { SqlTypeName.VARCHAR },
            "parquet",
    public void testNoScalarFunctionsKeepsLuceneViable() {  
        );  
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
        assertTrue("Message must mention the missing delegation path", exception.getMessage().contains("no delegation path exists"));  
    /**
        assertTrue("DataFusion stays viable", annotated.getViableBackends().contains(MockDataFusionBackend.NAME));
        return (OpenSearchFilter) result;  
        );
        assertTrue(equalsPred.getViableBackends().contains(MockDataFusionBackend.NAME));
        assertEquals("both backends still viable", 2, annotated.getViableBackends().size());  
        assertPredicateAnnotation(phrasePred, MockLuceneBackend.NAME);
     * Field-less {@code query_string('category:A')} — the form the PPL {@code search} command lowers
        assertTrue(predicate.getOriginal().toString().contains("MATCH_PHRASE"));
     * blocks the shape, the block-list is ignored and all backends remain (there is nowhere else to
    }
     * marks {@code [datafusion]} at the operator level and P1's annotation lists Lucene as
                "s",
        assertTrue(exception.getMessage().contains("bad-backend"));  
    public void testQueryStringOnNumericFieldIsRejected() {
}  
        );  
            makeFieldlessFullTextCall(fullTextSqlFunction("QUERY_STRING"), "category:A"),  
     * accepted via the extractor path and routes to the full-text backend — the extractor surfaces
        AnnotatedPredicate upperEqAnnotated = (AnnotatedPredicate) andCondition.getOperands().get(1);
        };
        OpenSearchFilter result = runFilterWithDelegation(
            new String[] { "category" },
     */
     * block targets a different backend namespace that doesn't exist.
     */
                makeEquals(0, SqlTypeName.INTEGER, 200),  
     * and the existing "no backend can evaluate filter predicate" throw fires. Verifies the
     * Multi-index alias MATCH delegation: when a scan resolves to two backing indices, the
    }
            List.of("severityNumber"),  
     * With a backend serializer that reports field references, a field named only inside the  
        RexNode badLeaf = rexBuilder.makeCall(SqlStdOperatorTable.GREATER_THAN, expCall, rexBuilder.makeLiteral(1.0, doubleType, true));
            new String[] { "status", "s", "num" },
        );  
    }
    }
        OpenSearchFilter result = runFilterWithDelegation(
        AnnotatedPredicate equalsPred = (AnnotatedPredicate) andCondition.getOperands().get(0);
            protected Set<DelegationType> acceptedDelegations() {
        );
            "Message must not conflate sibling leaves' fields",
        assertTrue(exception.getMessage().contains("getInstructionHandlerFactory"));
                "status",
        return List.of(df, lucene);  
        );
     * Predicate with a nested scalar function ({@code EXP}) that NO mock backend declares  
import org.apache.calcite.rel.RelNode;
        SqlFunction unknown = new SqlFunction(
     * unknown field fails, rather than silently assuming TEXT and matching nothing. (Wildcard/regex  
import org.opensearch.analytics.spi.FieldReferences;  
     * Inter-leaf "same backend" check: {@code (MATCH(s, 'foo') OR status = 200) AND >(SIN(num), 0.5)}.
            Map.of(
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
                    SqlStdOperatorTable.SUM,
        assertTrue("Error must name the function: " + exception.getMessage(), exception.getMessage().contains("QUERY_STRING"));
     *     MAP('query', 'queryText':VARCHAR)
     *   )  
            @Override
                Map.of("type", "keyword", "index", true),
        MockLuceneBackend lucene = new MockLuceneBackend() {
    }
        );
            "Eager type-rejection must have been skipped: " + exception.getMessage(),
/**
        assertEquals("P1 (MATCH) viable backends must be exactly [lucene]", 1, matchPred.getViableBackends().size());  
            "parquet",
        RexCall orCondition = (RexCall) result.getCondition();
            makeEquals(0, SqlTypeName.VARCHAR, "US")  
            "Lucene must be excluded across deeply nested scalar-function calls",  
    }
        );  
    public void testQueryStringOnMixedFieldsRejectsBecauseOfNonTextField() {
            "parquet",
            new String[] { "country_name" },
            () -> new CapabilityRegistry(List.of(badBackend), idx -> null)
        RelDataType doubleType = typeFactory.createSqlType(SqlTypeName.DOUBLE);
            @Override
    ) {
    // ---- Text-relevance function on non-text field type-check ----
        );
        RelNode result = unwrapExchange(runPlanner(filter, context));
     * via the delegation block-list must drop Lucene from the predicate's viable set, leaving only
    public void testScalarFunctionNarrowingIsPerLeaf() {
                return new BackendCapabilityProvider() {  
        OpenSearchFilter result = runFilterWithDelegation(  
            Map.of("title", Map.of("type", "keyword", "index", true), "body", Map.of("type", "keyword", "index", true)),
    }
     * matches single-index behavior.  
        // P3 (SIN > 0.5) — exactly DataFusion; Lucene declares no scalar capability for SIN
            "test_index",  
     * {@code query_string(['status'], '...')} on a {@code keyword} field is accepted —  
            new String[] { "status", "country_name" },  
            new SqlTypeName[] { SqlTypeName.VARCHAR, SqlTypeName.BIGINT }
        RelOptTable table = mockTable("test_index", new String[] { "severityNumber" }, new SqlTypeName[] { SqlTypeName.BIGINT });
        // natively, forcing the "without delegation" code path under test.
            "Message must indicate the operator-level mismatch, got: " + exception.getMessage(),  
        );
    private static SqlFunction fullTextSqlFunction(String name) {
     * that leaf and propagates up through OR and AND. Verifies (a) sibling leaves don't
        AnnotatedPredicate matchPred = (AnnotatedPredicate) andCondition.getOperands().get(1);  
     * field keeps the scan viable (see note on {@link #testQueryStringOnKeywordFieldIsAccepted}),
                Map.of("type", "integer", "index", true)
    }  
            "parquet",  
        RexNode p3 = rexBuilder.makeCall(SqlStdOperatorTable.GREATER_THAN, sinCall, rexBuilder.makeLiteral(0.5, doubleType, true));  
                return Map.of(ScalarFunction.QUERY_STRING, stub);
     * stay viable. Sets the expected shape that the next four tests narrow against.
        SqlTypeName[] fieldTypes,
     * {@link IllegalArgumentException} (HTTP 400 with the actionable message preserved) rather  
        assertPipelineViableBackends(result, List.of(OpenSearchFilter.class, OpenSearchTableScan.class), expectedViable);
        RelDataType integer = typeFactory.createSqlType(SqlTypeName.INTEGER);  
     * the field with identical (keyword, indexed) settings, and  
            "parquet",
     * run the predicate). Here both backends block EQUALS, so the annotation keeps both.  
        RexNode innerMap = rexBuilder.makeCall(SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR, innerMapOperands);  
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        PlannerContext context = buildContext("parquet", 1, Map.of("status", Map.of("type", "integer"), "size", Map.of("type", "integer")));
        assertTrue("Expected OpenSearchFilter, got " + result.getClass().getSimpleName(), result instanceof OpenSearchFilter);
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR, SqlTypeName.INTEGER },
        Map<String, Map<String, Object>> fields,
    public void testBackendWithFilterDelegationButNoFactory_throws() {  
        assertTrue("Error must name the offending field: " + exception.getMessage(), exception.getMessage().contains("severityNumber"));
    private OpenSearchFilter runFilter(
            new SqlTypeName[] { SqlTypeName.VARCHAR },
    }
    /**  
            exception.getMessage().contains("No backend can evaluate filter predicate")
            SqlFunctionCategory.USER_DEFINED_FUNCTION
            exception.getMessage().contains("Unrecognized scalar function [FAKE_UDF]")
     * keyword fields are valid for text-relevance functions.
            Map.of("country_name", Map.of("type", "keyword", "index", true)),
        String[] fieldNames,
    public void testDeeplyNestedScalarFunctionsDropLucene() {
     * {@link org.opensearch.analytics.spi.ScalarFunction} enum) makes the predicate
            List.of(  
    public void testBlockListIgnoredWhenAllViableBackendsBlock() {
        Map<String, Map<String, Object>> fields,
     * {@code search source=idx category=A} into. There is no {@code fields} MAP, so no literal field  
     * unknown field — rejected with a "field not found" error, matching how a normal predicate on an
        OpenSearchFilter result = runFilterWithDelegation(  
     */
     */
     * {@link BasePlannerRulesTests#buildContextPerIndex} to register all indices under the same  
    /** Unsupported field type for operator — errors. */  
            public String name() {  
        assertTrue(  
     * {@code query_string(['severityNumber'], '...')} on a {@code long} field is rejected
    public void testMultipleFullTextOrWithDelegation() {
        assertPredicateAnnotation(matchPred, MockLuceneBackend.NAME);
            new String[] { "status", "message" },
        );
            new String[] { "status", "message" },  
            makeFieldlessFullTextCall(fullTextSqlFunction("QUERY_STRING"), "category:A")
            "parquet",
            List.of(OpenSearchFilter.class, OpenSearchTableScan.class),  
     * operator-level intersection at {@code computeFilterViableBackends} finds no backend that
                        return Set.of(DelegationType.FILTER);
            new String[] { "country_name" },  
        OpenSearchFilter result = runFilter(
    }
        String[] fieldNames,
     * AND of {@code status = 200} (no nested function) and {@code UPPER(country) = 'US'}  
    }
            Map.of("message", Map.of("type", "keyword", "index", true)),  
                )  
 * Tests for filter rule: predicate annotation, viable backends computation,
        return List.of(df, lucene);
            "parquet",
        java.util.Map<String, Integer> shardCounts = new java.util.LinkedHashMap<>();
     * suppress the un-evaluable leaf's failure and (b) the error message stays per-leaf
            name,  
            makeCall(
    public void testBlockListUnknownBackendIsNoOp() {  
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
     * blocking EQUALS for Lucene leaves a keyword-equality dual-viable annotation untouched when the  
        RelOptTable table = mockTable(
        Map<String, Map<String, Object>> fields,
        RelOptTable table = mockTable("test_index", new String[] { "eventTime" }, new SqlTypeName[] { SqlTypeName.DATE });  
    }
        assertTrue(exception.getMessage().contains("date"));
     * added in {@link #testQueryStringOnUnknownLiteralFieldIsRejected}.
        RelOptTable table = mockTable("test_index", fieldNames, fieldTypes);
        RelOptTable table = mockTable("test_index", new String[] { "message" }, new SqlTypeName[] { SqlTypeName.VARCHAR });  
     * Blocking a predicate for one backend must not affect a different, non-blocked predicate shape:
                return Set.of(DelegationType.FILTER);
/*  
            Map.of("status", Map.of("type", "integer", "index", true), "message", Map.of("type", "keyword", "index", true)),
     * functions only apply to text/keyword.  
        RexNode condition = makeCall(SqlStdOperatorTable.AND, makeCall(SqlStdOperatorTable.OR, p1, p2), p3);
     * formats via {@code putIfAbsent}. A future regression that drops index formats during the
        );
     * field with {@code lenient=false}, so the planner rejects it — coverage the old MAP-literal
     */
     */
            annotated.getViableBackends().contains(MockLuceneBackend.NAME)
    private OpenSearchFilter runFilter(  
        PlannerContext context = buildContext(
            fields,
    }
     */
        // MATCH_PHRASE predicate has Lucene as delegation target
     * {@code query_string('category:A')} (and the PPL {@code search} command's {@code category=A})  
            Map.of("country_name", Map.of("type", "keyword", "index", true)),
import org.opensearch.analytics.spi.DelegationType;
        // index=false strips the inverted index so no backend can satisfy the full-text predicate
            condition  
        RexNode condition = makeFullTextCall(fullTextSqlFunction("MATCH_PHRASE"), 0, "hello world");
        assertEquals(1, result.getViableBackends().size());  
            }
        RexNode level1 = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, level2);  
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);  
                Map.of("type", "keyword", "index", true),  
                Map.of("type", "keyword", "index", true),
import org.apache.calcite.util.ImmutableBitSet;
     * {@code UPPER(country) = 'US'}: Lucene supports EQUALS on KEYWORD but does not
import java.math.BigDecimal;
        Set<String> expectedViable
            }
            "Should fail via viability, not eager rejection: " + exception.getMessage(),  
        };  
                return Set.of(DelegationType.FILTER);  
            "parquet",  
     *
        OpenSearchFilter result = runFilterWithBlockList(
                return Set.of(DelegationType.FILTER);
        // so the inner-call walk drops it.  
            protected Set<DelegationType> supportedDelegations() {  
        OpenSearchFilter result = runFilter(  
            result.getViableBackends().contains(MockLuceneBackend.NAME)
            }
            "parquet",
    }
        PlannerContext context = buildContext(
        String format,  
        );  
        );  
     */
    private List<AnalyticsSearchBackendPlugin> delegationBackends() {
    }
import org.apache.calcite.plan.RelOptTable;
            }
        return runFilter(  
        assertTrue(equalsPred.getViableBackends().contains(MockLuceneBackend.NAME));  
        RelOptTable table = mockTable("test_index", new String[] { "status" }, new SqlTypeName[] { SqlTypeName.VARCHAR });
        RexNode condition = makeMultiFieldFullTextCall(fullTextSqlFunction("QUERY_STRING"), List.of("status", "severityNumber"), "error");
    public void testLenientTrueSuppressesEagerRejectionViaExtractor() {  
        );
import org.opensearch.analytics.spi.ScalarFunction;
        assertFalse("Lucene is delegation-only here", result.getViableBackends().contains(MockLuceneBackend.NAME));
        assertFalse(  
        // P2: status = 200 — dual-viable on its own, doesn't help bridge P1 and P3.  
     *
     */
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();
     * is never type-checked or treated as an unknown field — it routes to the full-text backend and
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
     * A literal field named in {@code query_string} that is absent from the scan's schema is an
     */  
        assertEquals(1, annotated.getViableBackends().size());  
            makeFullTextCall(fullTextSqlFunction("MATCH_PHRASE"), 0, "hello world")  
            makeFullTextCall(fullTextSqlFunction("MATCH_PHRASE"), 0, "hello world")  
     * Variant of {@code runFilter} that resolves to {@code multipleIndexNames} concrete indices
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();  
                    public Set<DelegationType> supportedDelegations() {
 */  
        OpenSearchFilter result = runFilter(  
            "parquet",
            OperandTypes.ANY,  
     * support UPPER, so the predicate is no longer viable for Lucene.  
        String[] indexNames,  
     * table name. The fragment's table name is the first index in the list — that's what the
        RexNode goodLeaf = makeEquals(0, SqlTypeName.INTEGER, 200);
    /**  
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.INTEGER },
        OpenSearchFilter result = runFilterWithDelegation(
     * is expanded at execution. Guards the empty-literals fallback against the unknown-field rejection  
    public void testQueryStringOnDateFieldIsRejected() {
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR },
     * just the upstream aggregate's. The filter runs on the same backend that produced the  
        assertFalse(
    }  
            ImmutableBitSet.of(0),
                    @Override
            "parquet",
        RexNode expCall = rexBuilder.makeCall(SqlStdOperatorTable.EXP, rexBuilder.makeInputRef(integer, 2));  
        FieldReferences refs = new FieldReferences(List.of("severityNumber"), List.of(), false);  
        assertTrue(phrasePred.getOriginal().toString().contains("MATCH_PHRASE"));
import org.apache.calcite.sql.SqlFunctionCategory;
        for (String backend : expectedBackends)
            @Override
    }
                makeFullTextCall(fullTextSqlFunction("MATCH"), 1, "error")
        RexNode sinCall = rexBuilder.makeCall(SqlStdOperatorTable.SIN, rexBuilder.makeInputRef(integer, 2));
        FieldReferences refs = new FieldReferences(List.of("severityNumber"), List.of(), true);
            Set.of(MockDataFusionBackend.NAME)
            exception.getMessage().contains("text and keyword")
        assertEquals("Only DataFusion remains viable", 1, annotated.getViableBackends().size());  
            new String[] { "status" },
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        List<AnalyticsSearchBackendPlugin> backends,  
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
        AnnotatedPredicate equalsPred = (AnnotatedPredicate) orCondition.getOperands().get(0);
     * scan rule looks up; since all backings have the same mapping, the unioned field storage
        RexNode predicate = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, unknownCall, rexBuilder.makeLiteral("X"));
        // P1 (MATCH) — exactly Lucene; DataFusion will delegate it.
        PlannerContext context = buildContext("parquet", Map.of("status", Map.of("type", "keyword", "index", true)));
        RelDataType integer = typeFactory.createSqlType(SqlTypeName.INTEGER);  
    // ---- Helpers ----  
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();  
     * {@link org.opensearch.analytics.planner.FieldStorageResolver#merged} preserves Lucene index
    }
    private OpenSearchFilter runMultiIndexFilter(
            new SqlTypeName[] { SqlTypeName.VARCHAR },
            predicate  
    public void testBlockListDropsBlockedBackendFromPredicate() {
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> runPlanner(filter, context));
    /** Full-text with delegation — both backends viable at operator level. */
        RelOptTable table = mockTable("test_index", new String[] { "severityNumber" }, new SqlTypeName[] { SqlTypeName.BIGINT });
     * lowers {@code query_string(['fieldName'], 'queryText')} into:
        RexNode condition,  
            rexBuilder.makeLiteral("query"),
    private void assertPredicateAnnotation(AnnotatedPredicate predicate, String... expectedBackends) {  
        DelegationBlockList blockList = DelegationBlockList.fromMap(  
    public void testFieldlessQueryStringIsAccepted() {
     * leaf and drops only on the second.
            @Override
     * {@code query_string(['eventTime'], '...')} on a {@code date} field is rejected — text-relevance
        PlannerContext context = buildContext("parquet", Map.of("name", Map.of("type", "keyword", "index", true)));  
        RelOptTable table = mockTable("test_index", new String[] { "severityNumber" }, new SqlTypeName[] { SqlTypeName.BIGINT });  
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        PlannerContext context = buildContext(  
     * into:
    public void testQueryStringWildcardFieldPatternIsAccepted() {  
     * An explicit {@code lenient=true} (reported by the extractor) suppresses the eager type  
     * NOT be rejected — it falls back to the TEXT-type assumption and routes to the full-text backend.
        OpenSearchFilter result = runFilter(
import org.opensearch.analytics.spi.BackendCapabilityProvider;
        return new SqlFunction(
                return "bad-backend";
import java.util.Map;
            public Map<ScalarFunction, DelegatedPredicateSerializer> delegatedPredicateSerializers() {
        );  
    ) {
            rexBuilder.makeLiteral(1.0, typeFactory.createSqlType(SqlTypeName.DOUBLE), true)  
            ReturnTypes.BOOLEAN,
        );
        RexNode unknownCall = rexBuilder.makeCall(unknown, rexBuilder.makeInputRef(varchar, 0));
        RexNode condition,
                "status",
            Map.of(MockLuceneBackend.NAME, List.of(ScalarFunction.EQUALS), MockDataFusionBackend.NAME, List.of(ScalarFunction.EQUALS))
            List.of(DATAFUSION, LUCENE),  
        // doc_values=false, index=false, store=false → no storage in any format → error  
    }  
        assertTrue(exception.getMessage().contains("QUERY_STRING"));  
     */
        );  
            fullTextSqlFunction("QUERY_STRING"),
        assertTrue(exception.getMessage().contains("severityNumber"));  
        // P3: SIN(num) > 0.5 — inner SIN is DataFusion-only (Lucene declares no ProjectCapability),  
                "num",
        };
        RelNode result = unwrapExchange(runPlanner(filter, context));
     * exercises the {@code keyword} acceptance path.
            Map.of(  
     * (nested UPPER). Each leaf is annotated independently: Lucene stays on the first
                    "total_size"
            "Lucene must be excluded — no scalar capability for UPPER",
     * <p>Implementation note: with the current per-index storage helpers, both backings declare
 * compatible open source license.
            exception.getMessage().contains("No backend can execute filter")
        );
            rexBuilder.makeLiteral("query"),
     */  
            Map.of("country_name", Map.of("type", "keyword", "index", true)),  
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
            makeMultiFieldFullTextCall(fullTextSqlFunction("QUERY_STRING"), List.of("status"), "active")  
    private List<AnalyticsSearchBackendPlugin> backendsWithExtractor(FieldReferences refs) {  
        PlannerContext context = buildContext(format, fields, List.of(DATAFUSION, LUCENE));  
        return rexBuilder.makeCall(function, fieldsMap, queryMap);
        OpenSearchFilter result = runFilter(
        assertTrue("Message must name the outer comparator's kind", exception.getMessage().contains("GREATER_THAN"));  
    // ---- Per-predicate annotation tests ----  
            blockList  
    }
        // UPPER(s) = 'X'
    /** OR across backends — DF viable at operator, equals viable for both, MATCH delegated to Lucene. */  
        );  
    /**  
    /**
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> runPlanner(filter, context));
            Map.of("status", Map.of("type", "integer", "index", true), "message", Map.of("type", "keyword", "index", true)),
 * delegation, and derived column handling.  
        );  
    public void testQueryStringOnUnknownLiteralFieldIsRejected() {
        assertPredicateAnnotation(matchPred, MockLuceneBackend.NAME);
     * here at all — the table-scan rule throws before the filter rule runs. This test therefore  
        RexCall andCondition = (RexCall) result.getCondition();
            new String[] { "status", "s", "num" },
    /** Keyword equality — both backends viable per-predicate, operator-level only child. */
    public void testInnerScalarWithNoBackendSupportThrows() {  
     * error proves the lenient gate skipped {@code rejectNonTextFieldsForTextFunction}.  
            SqlStdOperatorTable.GREATER_THAN,
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);  
        );  
            "parquet",
        // DF is viable at operator level (has doc values in parquet)  
        RexCall orBranch = (RexCall) andCondition.getOperands().get(0);  
                Map.of("type", "integer", "index", true),
     * unioned {@link org.opensearch.analytics.spi.FieldStorageInfo} must still expose the field's
        );
        assertTrue(exception.getMessage().contains("eventTime"));
                };
        OpenSearchFilter result = runFilter(
import org.opensearch.analytics.settings.DelegationBlockList;
        assertFalse("Lucene dropped by block-list", annotated.getViableBackends().contains(MockLuceneBackend.NAME));
            "parquet",
     */
            "parquet",
        assertTrue(annotated.getViableBackends().contains(MockDataFusionBackend.NAME));
            makeMultiFieldFullTextCall(fullTextSqlFunction("QUERY_STRING"), List.of("ser*"), "active")  
    public void testMatchDelegationOverMultiIndexAlias() {
                    typeFactory.createSqlType(SqlTypeName.INTEGER),
            stubScan(table),
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
        Map<String, Map<String, Object>> fields,
    public void testNestedAndOrWithUnevaluableLeafThrows() {
                makeFullTextCall(fullTextSqlFunction("MATCH_PHRASE"), 1, "world")
import org.opensearch.analytics.planner.rel.OpenSearchFilter;  
        assertTrue(upperEqAnnotated.getViableBackends().contains(MockDataFusionBackend.NAME));
import org.opensearch.analytics.settings.PlannerSettings;  
 */
            "FAKE_UDF",
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);  
     * Safety invariant: blocking must never make a predicate unexecutable. If EVERY viable backend
    /** AND with delegation — DF viable at operator, equals viable for both, MATCH_PHRASE delegated to Lucene. */
     * <p>Note: this fixture's mock DataFusion backend declares scan support only for  
        // so the leaf narrows to [datafusion] via the new inner-call walk.
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();  
            fieldTypes,
        RelOptTable table = mockTable("test_index", new String[] { "location" }, new SqlTypeName[] { SqlTypeName.OTHER });
        IllegalStateException exception = expectThrows(
import org.opensearch.analytics.planner.rel.AnnotatedPredicate;
            backendsWithExtractor(refs),
    /**
            SqlFunctionCategory.USER_DEFINED_FUNCTION
    // ---- Viable backends with delegation ----  
        assertEquals("P3 (SIN) viable backends must be exactly [datafusion]", 1, sinPred.getViableBackends().size());
     * spanning multiple concrete indices must behave the same as MATCH on a single index.  
    // ---- Error cases ----
    }
    public void testOrAcrossBackendsWithDelegation() {
    // ---- Scalar-function capability narrowing ----  
        RexNode predicate = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, upperCall, rexBuilder.makeLiteral("US"));
            Map.of("country_name", Map.of("type", "keyword", "index", true)),
     * throwing. The filter has no per-field storage to narrow on, so its viable backends are
        RexNode condition = makeCall(SqlStdOperatorTable.AND, makeCall(SqlStdOperatorTable.OR, p1, p2), p3);
        );
import org.opensearch.analytics.spi.FieldStorageInfo;
        RexNode condition = makeFieldlessFullTextCall(fullTextSqlFunction("QUERY_STRING"), "severityNumber:>15");
    /**
                "s",
            protected Set<DelegationType> supportedDelegations() {
            blockList
    /**  
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);  
            SqlKind.OTHER_FUNCTION,
            "Lucene must not appear at the operator level — it accepts delegated leaves but doesn't drive",
     * at planning with a precise, actionable error message — text-relevance functions
        String format,  
import org.apache.calcite.sql.fun.SqlStdOperatorTable;  
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
import org.opensearch.analytics.spi.EngineCapability;
        OpenSearchFilter result = runFilterWithBlockList(  
        assertTrue("Error must say not found: " + exception.getMessage(), exception.getMessage().contains("not found"));  
     * has no value-producing scan capability, so a pure {@code text} field can't be scanned
    }  
     * A nested scalar function that the framework doesn't know about (no entry in the
            Map.of("name", Map.of("type", "keyword", "index", true)),
import org.apache.calcite.rex.RexNode;
     * shape, but with FILTER delegation registered (DataFusion drives, Lucene accepts).
     * numeric/keyword/date/boolean types (not {@code text}), and the mock Lucene backend
    private RexNode makeFieldlessFullTextCall(SqlFunction function, String query) {
        return runFilter(format, fields, fieldNames, fieldTypes, condition, delegationBackends(), Set.of(MockDataFusionBackend.NAME));  
        );
    ) {
        RexNode level2 = rexBuilder.makeCall(SqlStdOperatorTable.CONCAT, level3, rexBuilder.makeLiteral("_b"));
     * </pre>
     *   QUERY_STRING(MAP('query', 'category:A':VARCHAR))  
            new String[] { "message" },
        assertFalse(  
            "parquet",
     * {@code category} as a literal, which the planner type-checks as keyword (valid).  
        SqlTypeName[] fieldTypes,
                SqlStdOperatorTable.OR,
        assertFalse(result.getViableBackends().contains(MockLuceneBackend.NAME));  
        context.setPlannerSettings(PlannerSettings.of(0.0, blockList));
            )
        RexCall andCondition = (RexCall) result.getCondition();
        assertEquals("both backends retained — blocking can't strand the predicate", 2, annotated.getViableBackends().size());
        PlannerContext context = buildContext("parquet", Map.of("n", Map.of("type", "integer", "index", true)));
    }
            new String[] { "title", "body" },  
            format,
        assertEquals("Only DataFusion remains viable for the scalar-function leaf", 1, upperEqAnnotated.getViableBackends().size());
            SqlStdOperatorTable.GREATER_THAN,
        );
        SqlTypeName[] fieldTypes,  
            new String[] { "idx_a", "idx_b" },
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));  
    }
        RexNode condition = makeMultiFieldFullTextCall(fullTextSqlFunction("QUERY_STRING"), List.of("eventTime"), "2026-01-01");
        assertFalse(  
        assertTrue(
            "parquet",
        return (OpenSearchFilter) result;  
public class FilterRuleTests extends BasePlannerRulesTests {
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
            innerCall,
    /**
            new String[] { "message" },
        assertEquals("Only DataFusion remains viable", 1, annotated.getViableBackends().size());
            SqlStdOperatorTable.MAP_VALUE_CONSTRUCTOR,  
        String[] fieldNames,  
            new SqlTypeName[] { SqlTypeName.VARCHAR },
import org.apache.calcite.sql.type.OperandTypes;
        assertFalse(  
        assertTrue(matchPred.getOriginal().toString().contains("MATCH_PHRASE"));  
    private OpenSearchFilter runFilterWithBlockList(
        );  
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.VARCHAR, SqlTypeName.INTEGER }
    /**  
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);  
        );  
        AnnotatedPredicate predicate = (AnnotatedPredicate) result.getCondition();
            exception.getMessage().contains("No backend can evaluate filter predicate")
        for (String name : indexNames) {
     */
     * {@code query_string(['status', 'severityNumber'], '...')} with a mixed field list
     * <p>This pins the contract called out in the multi-index PR description: MATCH on an alias
            "parquet",
    }
    }
            public BackendCapabilityProvider getCapabilityProvider() {
        LogicalFilter filter = LogicalFilter.create(stubScan(table), condition);
    }
     * union would surface as the assertion below failing.  
            Map.of("country_name", Map.of("type", "keyword", "index", true)),  
            Map.of("status", Map.of("type", "integer", "index", true), "size", Map.of("type", "integer", "index", true)),  
    }
                SqlStdOperatorTable.OR,  
     * {@link DelegatedPredicateSerializer} for {@code QUERY_STRING} whose {@code referencedFields}  
        assertTrue(  
     * {@link #testQueryStringWildcardFieldPatternIsAccepted}.)
    }
        AnnotatedPredicate sinPred = (AnnotatedPredicate) andCondition.getOperands().get(1);  
            new SqlTypeName[] { SqlTypeName.VARCHAR },
        assertPredicateAnnotation(predicate, MockLuceneBackend.NAME);
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> runPlanner(filter, context));
        MockDataFusionBackend df = new MockDataFusionBackend() {  
        String format,
        assertPredicateAnnotation(annotated, MockDataFusionBackend.NAME, MockLuceneBackend.NAME);
    public void testQueryStringOnKeywordFieldIsAccepted() {  
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        RexNode level3 = rexBuilder.makeCall(SqlStdOperatorTable.UPPER, level4);
     * DataFusion (FILTER delegation) + Lucene (accepts FILTER delegation, registers a stub
import org.apache.calcite.sql.type.SqlTypeName;  
        );  
     * so planning reaches the filter rule and the {@code long} field triggers the rejection.
    public void testFilterWithMixedBackendLeavesAndDelegationSucceeds() {
     */  
import org.apache.calcite.rel.logical.LogicalAggregate;
     * Nested boolean tree {@code AND( $0 = 200 , OR( UPPER($s) = 'X' , >(EXP($num), 1.0) ) )}.
        FieldReferences refs = new FieldReferences(List.of("category"), List.of(), false);  
import org.opensearch.analytics.spi.DelegatedPredicateSerializer;  
        );
            "Message must indicate no backend can evaluate the predicate, got: " + exception.getMessage(),
                Map.of("type", "integer", "index", true)  
        String format,
                "s",  
        );  
        RexNode condition = makeMultiFieldFullTextCall(
    }
        return (OpenSearchFilter) result;  
        RelOptTable table = mockTable(
            Map.of("status", Map.of("type", "keyword", "index", true)),  
    /**  
        assertTrue(exception.getMessage().contains("No backend can evaluate filter predicate"));  
        PlannerContext context = buildContext("parquet", Map.of("message", Map.of("type", "keyword", "index", false)));  
        AnnotatedPredicate annotated = (AnnotatedPredicate) result.getCondition();
    /**
        RelDataType varchar = typeFactory.createSqlType(SqlTypeName.VARCHAR);
        assertTrue(exception.getMessage().contains("severityNumber"));
import org.apache.calcite.rel.core.AggregateCall;  
        AnnotatedPredicate equalsPred = (AnnotatedPredicate) orBranch.getOperands().get(1);
        LogicalFilter filter = LogicalFilter.create(stubScan(table), predicate);
        );  
        );
    ) {  
        RexNode predicate = rexBuilder.makeCall(  
        assertTrue(matchPred.getViableBackends().contains(MockLuceneBackend.NAME));
     * Four-level nesting: {@code UPPER(CONCAT(UPPER(CONCAT(name, '_a')), '_b')) = 'FOO'}.
        AnnotatedPredicate phrasePred = (AnnotatedPredicate) orCondition.getOperands().get(1);
                Map.of("type", "integer", "index", true),  
import java.util.List;  
        AnnotatedPredicate matchPred = (AnnotatedPredicate) orBranch.getOperands().get(0);
        RexNode condition
import java.util.Set;
        RexNode upperEq = rexBuilder.makeCall(SqlStdOperatorTable.EQUALS, upperCall, rexBuilder.makeLiteral("US"));
        );  
            "parquet",
        assertTrue(annotated.getViableBackends().contains(MockDataFusionBackend.NAME));
        RelOptTable table = mockTable(
        assertTrue(matchPred.getOriginal().toString().contains("MATCH"));  
        OpenSearchFilter result = runFilter(
     */
        assertTrue(result.getViableBackends().contains(MockDataFusionBackend.NAME));  
            "Message must name the unrecognized scalar function",
     */
        assertEquals("Operator-level viable backends must be exactly [datafusion]", 1, result.getViableBackends().size());
            new String[] { "country_name" },
        List<RexNode> innerMapOperands = new ArrayList<>();
    }
     * returns {@code refs}).
        PlannerContext context = buildContext("parquet", Map.of("severityNumber", Map.of("type", "long")));
        AnnotatedPredicate matchPred = (AnnotatedPredicate) orCondition.getOperands().get(0);  
            Map.of("country_name", Map.of("type", "keyword", "index", true)),  
    /**
    }
            makeEquals(0, SqlTypeName.VARCHAR, "US"),
    /**  
        }
            new SqlTypeName[] { SqlTypeName.VARCHAR },  
        assertFalse(result.getViableBackends().contains(MockLuceneBackend.NAME));  
            Map.of("category", Map.of("type", "keyword", "index", true)),
                        return refs;
        RexCall andCondition = (RexCall) result.getCondition();
    }
    // ---- Derived columns ----
        assertFalse(result.getViableBackends().contains(MockLuceneBackend.NAME));
     */
    }  
            Map.of("message", Map.of("type", "keyword", "index", true)),  
        RexNode sinCall = rexBuilder.makeCall(SqlStdOperatorTable.SIN, rexBuilder.makeInputRef(integer, 2));
            makeCall(
            )
