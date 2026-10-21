            2,
 * {@code AboveAnchorPhysicalFields - BelowAnchorPhysicalFields} is non-empty.
                }
                    if (ctx.outerProject == null) {
            RelCollations.of(
        // SELECT URL || '-' || URL AS combined, UPPER(URL) AS upper_url FROM hits ORDER BY EventDate LIMIT 10
        // Filter CounterID($0) > 0
                    }
            return new Expect() {
        );
        // Walk FSI over every OpenSearchRelNode, mirroring DAGBuilder.cutAtLateMaterialization — must not throw.
            Expect.aboveAnchorPhysicalFields("URL", "EventDate", "CounterID"),
                            "Wrapper output rowType mismatch.\n  expected: "
 * the structural post-conditions QTF must produce:
     * wrapper-output space, even when there's no Project sitting between Sort and anchor.
 * <p>Each test drives a SQL string (Calcite dialect) through the full planner and asserts
                @Override
        // Single shard: CBO inserts no ExchangeReducer below the anchor (the scan's
                        || actual.contains(OpenSearchLateMaterialization.UGSI_FIELD)) {
            Expect.scanCols("EventDate"),
            projRowType,
     * passthrough Sort. {@code assertQtfFired} catches such an exception on the planner call.
        assertQtfFired(
        // avoiding cross-node materialization of fetch-only columns through the gather; with
                }
        assertQtfDeclined(
                            "ER rowType and FSI must stay aligned 1:1 after " + copy,
            cluster.traitSet(),
                                    + "] is not a RexInputRef: "
            Expect.aboveAnchorPhysicalFields("Title"),
        OpenSearchSort sort = new OpenSearchSort(
        // dependsOn walk yields {URL, Title} in evaluation order.
        // BelowAnchor = {CounterID, EventDate}, AboveAnchor = [URL, CounterID]
                @Override
     * the ER (unlike the simpler {@code Sort → ER → Project → Scan} cases). After rewrite the
            2,
    public void testQtfFires_descendingSort() {
                                + fc.size()
    }
            "SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10",
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),
        // BelowAnchor = {EventDate}; FetchOnly = {URL} → fire.
    private RelNode optimize(String sql, int shardCount) {
                @Override
         * Wrapper output rowType is exactly these names (= {@code AboveAnchorPhysicalFields} in
        // OFFSET preserved on the rebuilt anchor Sort.
                + "FROM (SELECT CounterID FROM hits ORDER BY CounterID LIMIT 100) AS inner_q "
        }
    }
        /**
                                    + plan
        // FetchOnly = {URL} → fire
 */
            Expect.outerProjectNames("tup")
            }
        // sort above the wrapper on it). Display-only expressions DO fire — see compositeExpression*.
                    if (ctx.outerProject == null) {
        new RelVisitor() {
    /**
        );
         * topmost-op order). Helpers must be absent.
import org.apache.calcite.rel.RelCollations;
                                + plan
import org.opensearch.analytics.spi.FieldStorageInfo;
            Expect.wrapperOutput("EventDate", "URL"),
    }
            .add("EventDate", scan.getRowType().getFieldList().get(1).getType())
        );
                    List<String> actual = fieldNames(ctx.wrapper.getRowType().getFieldList());
                        fail(
            Expect.erHasUgsi(true),
        assertQtfFired(
                                + expected
                    List<String> expected = Arrays.asList(expectedNamesInOrder);
     * ER carries ___ugsi as its last column, so the below-Project's positional "last = ___row_id"
        );
        // SELECT URL, SUM(ParamPrice) OVER () FROM hits ORDER BY EventDate LIMIT 10
    public void testQtfFires_simpleSortProject() {
        for (RelDataTypeField f : fields)
        // re-applies the SELECT alias so the result column is `u`, not `URL`.
        OpenSearchExchangeReducer er;
        }
         * Skip this assertion for projects whose expressions are not bare InputRefs (e.g.
                                + plan
                @Override
            Expect.erHasUgsi(true)
        // AboveAnchor = [CounterID, UserID, URL, Title, EventDate, AdvEngineID, ParamPrice].
            Expect.wrapperOutput("URL", "EventDate", "CounterID")
                    } else {
                    for (int i = 0; i < actual.length; i++) {
            Expect.scanCols("EventDate"),
                    if (node instanceof OpenSearchLateMaterialization w && wrapper == null) {
                void check(Inspector ctx, String sql, String plan) {
            fail("QTF should NOT have fired for SQL: " + sql + "\nPlan:\n" + RelOptUtil.toString(optimized));
            Expect.erHasUgsi(true),
     * immediate parent — because each passthrough Sort/Filter leaks the narrowed rowType upward.
            }.go(root);
        // Anchor Sort: ORDER BY CounterID($2) DESC, EventDate($1) DESC LIMIT 10
     */
            "SELECT URL, EventDate FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10",
            Expect.outerProjectExprIndices(0, 1)
                new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)
                    os.getOutputFieldStorage();
 *
            Expect.scanCols("CounterID", "EventDate"),
        // again and the reduce-fragment FSI walk throws. Assert each rebuilt ER keeps aligned FSI.
        // AboveAnchor = {EventDate}; BelowAnchor = {EventDate}; FetchOnly = {} → skip.
        OpenSearchProject project = new OpenSearchProject(
            Expect.outerProjectNames("combined", "upper_url")
        /** ER carries (or does not carry) {@code ___ugsi} as its last column. */
        // use (copy, copyResolved, stripAnnotations) — otherwise rowType (4 cols) and FSI (3) diverge
        // Aggregate sits below the anchor — not in BELOW_INTERMEDIATE_ALLOWED, declined.
        // EventDate is at position 1).
                                + sql
/*
    }
    private static List<String> fieldNames(List<RelDataTypeField> fields) {
    public void testQtfFires_multiKeySort() {
                            "Outer Project output names mismatch.\n  expected: "
        RexNode gtZero = rexBuilder.makeCall(
        );
    private static final class Inspector {
        // SELECT URL || '-' || Title AS combined FROM hits ORDER BY EventDate LIMIT 10
                }
        // AboveAnchor = {CounterID}; BelowAnchor = {CounterID, EventDate}; FetchOnly = {} → skip.
        // Outer Project carries RexCall expressions, not bare InputRefs — outerProjectExprIndices skipped.
        );
                    }
            2,
        OpenSearchTableScan scan;
                                    + "\nSQL: "
/**
        // collapses to AboveAnchorPhysicalFields = [URL].
    }
                                + "\nSQL: "
                        );
                                + plan
        OpenSearchExchangeReducer er = new OpenSearchExchangeReducer(cluster, cluster.traitSet(), filter, df);
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
            "SELECT URL, EventDate FROM hits ORDER BY EventDate DESC LIMIT 10",
                    }
            2,
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
            Expect.erHasUgsi(true),
     * Above-anchor Sort's collation index must be remapped from anchor-input space to
            physicalFsi("EventDate", "integer", FieldType.INTEGER),
 * Plan-shape tests for the QTF (late-materialization) post-CBO rewriter, v2.
        // Below-Project ABOVE the ER: SELECT URL($2), EventDate($1), CounterID($0)
            Expect.scanCols("EventDate"),
                public void visit(RelNode node, int ordinal, RelNode parent) {
        assertQtfFired(
        List<String> df = List.of("datafusion");
            Expect.erHasUgsi(true),
                                + "\nPlan:\n"
            @Override
            };
        // Topmost Project's outputs are passthrough refs to every physical field.
                void check(Inspector ctx, String sql, String plan) {
        assertQtfFired(
        new RelVisitor() {
            df
        );
            "SELECT URL, EventDate, CounterID FROM hits ORDER BY EventDate, CounterID LIMIT 10",
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),
            2,
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),
            out.add(f.getName());
    }
        // multiple keys and the collation rebuild preserving per-key direction.
        assertQtfFired(
import org.opensearch.cluster.ClusterState;
                                + actual
        // SELECT URL AS u, EventDate FROM hits ORDER BY EventDate LIMIT 10
                                + "\nPlan:\n"
        // After narrowing, scan = [EventDate, ___row_id] = 2 cols; wrapper output = [URL, EventDate].
        // FetchOnly = {URL} → fire. All three referenced fields end up in fetch list (v2 refetches).
                                    + sql
                    if (node instanceof OpenSearchExchangeReducer r && er == null) er = r;
     * {@code Sort → Project → ExchangeReducer → Filter → Scan} — the below-Project sits ABOVE
                                + "\n  actual:   "
            "SELECT URL || '-' || URL AS combined, UPPER(URL) AS upper_url FROM hits ORDER BY EventDate LIMIT 10",
 */
                        if (ctx.er != null) fail("Did not expect ER in plan (single-shard).\nSQL: " + sql + "\nPlan:\n" + plan);
                    if (node instanceof OpenSearchTableScan t && scan == null) scan = t;
         */
        );
        RelNode optimized = optimize(sql, shardCount);
                        }
                    }
                                + plan
import org.opensearch.analytics.planner.rel.OpenSearchProject;
                        if (!OpenSearchLateMaterialization.UGSI_FIELD.equals(erFields.get(erFields.size() - 1))) {
public class LateMaterializationPlanShapeTests extends BasePlannerRulesTests {
        // SELECT CounterID FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10
            Expect.erHasUgsi(true),
                    }
                                "Anchor collation["
        }
        // Both above-Project outputs derive from URL. dependsOn walk + LinkedHashSet dedup
    }
                    List<String> expected = Arrays.asList(expectedNamesInOrder);
            Expect.outerProjectNames("combined")
            Expect.scanCols("EventDate"),
                        } else {
            Expect.erHasUgsi(true),
            er,
                        );
    }
            return new Expect() {
                    for (RelNode copy : List.of(
                        fail(
                        return;
        // SELECT inner.CounterID, COUNT(*) FROM (SELECT CounterID FROM hits ORDER BY CounterID LIMIT 100) AS inner GROUP BY inner.CounterID
        RelNode parsed = SqlPlannerTestFixture.parseSql(sql, state);
                                    + "\nPlan:\n"
        assertQtfFired(
    }
        }
    }
     * <p>The implicit guarantee under test: the rewrite completes without Calcite's RexChecker
        OpenSearchProject outerProject;
import org.apache.calcite.plan.RelOptTable;
    }
                }
                        if (ctx.outerProject.getProjects().get(i) instanceof RexInputRef ref) {
    public void testQtfFires_withWhere() {
import java.util.ArrayList;
import org.apache.calcite.rel.type.RelDataTypeField;
                        fail(
         * SELECT contract — aliases re-applied by the Project even though the wrapper output is
                                + actual
            Expect.wrapperOutput("URL", "EventDate"),
            Expect.outerProjectExprIndices(0, 1)
            };
        // ExchangeReducer (RANDOM → SINGLETON gather)
                                + sql
 *       QTF (no gather to skip).</li>
                        );
        // (Above-Aggregate group/aggCall remap under a moving wrapper rowType is a follow-up.)
            null,
        assertTrue("QTF must fire for Sort→Project→ER→Filter→Scan", rewritten.isPresent());
        // Outer Sort's collation index must remap from anchor-space to wrapper-space (where
        // Wrapper output is physical-named [URL, EventDate]; the Project above the wrapper
        }
            2,
        // (refetched into the wrapper, v2 no-passthrough) — exercises the scan→wrapper rebase for a
    }
    }
        /**
     *
    public void testQtfFires_aliasPreserved() {
    }
                                    + "] direction mismatch. expected="
            Expect.collationDirections(RelFieldCollation.Direction.DESCENDING)
            Expect.wrapperOutput("CounterID", "UserID", "URL", "Title", "EventDate", "AdvEngineID", "ParamPrice")
            physicalFsi("CounterID", "integer", FieldType.INTEGER),
                        if (fc.get(i).getDirection() != expected[i]) {
     * lookup grabs ___ugsi instead — surfacing downstream as the DAGBuilder FSI walk throwing
        List<String> out = new ArrayList<>(fields.size());
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.INTEGER, SqlTypeName.VARCHAR }
            Expect.wrapperOutput("URL", "EventDate"),
        assertQtfFired(
                }
 *       {@code TopmostOperatorAboveAnchor} order. Helpers stripped.</li>
        if (ctx.wrapper != null) {
            Expect.wrapperOutput("URL", "EventDate")
    }
                        er.copy(er.getTraitSet(), er.getInputs()),
            "SELECT URL, EventDate FROM ("
                                    + ctx.outerProject.getProjects().get(i)
            cluster,
            ),
        // SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10
            2,
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),
         */
    // ── Tests that decline QTF ─────────────────────────────────────────
            Expect.scanCols("CounterID", "EventDate"),
                        fail("No outer Project above wrapper.\nSQL: " + sql + "\nPlan:\n" + plan);
        // Wrapper output is in topmost-op (SELECT) order, NOT scan order.
        assertQtfFired(
    }
                            c.getRowType().getFieldCount(),
            Expect.erHasUgsi(true),
import org.apache.calcite.rel.RelNode;
        // SELECT EventDate FROM hits ORDER BY EventDate LIMIT 10
            Expect.outerProjectNames("u", "EventDate")
        // SELECT EventDate, URL FROM hits ORDER BY EventDate LIMIT 10
        // the wrapper would break that).
    }
        }
        );
                            );
    }
    }
                if (node instanceof OpenSearchExchangeReducer er) {
        // BelowAnchorPhysicalFields = {CounterID, EventDate}
import java.util.List;
            "SELECT URL, EventDate FROM hits WHERE EventDate > DATE '2020-01-01' ORDER BY EventDate LIMIT 10",
                        }
        }.go(rewritten.get());
        // Title appears ONLY inside the expression — never selected alone, not a sort/filter col.
                                + "\nSQL: "
            Expect.scanCols("EventDate"),
            Expect.scanCols("CounterID", "EventDate"),
            };
            return new Expect() {
        static Expect aboveAnchorPhysicalFields(String... expectedNamesInOrder) {
                    }
                        if (w.getInput() instanceof OpenSearchSort s) anchor = s;
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),
                                + "\n  actual:   "
                                + "\nPlan:\n"
            Expect.outerProjectExprIndices(0, 1)
                if (node instanceof OpenSearchRelNode os) {
                void check(Inspector ctx, String sql, String plan) {
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
    private void assertQtfFired(String sql, int shardCount, Expect... expectations) {
                                + actual
        // Outer Sort by EventDate (= sort key, present in BelowAnchor); anchor Sort by EventDate.
    }
        assertQtfDeclined("SELECT URL FROM hits LIMIT 10", 2);
    public void testQtfFires_sortColAlsoProjected() {
        // No ORDER BY → no anchor → no rewrite.
        // AboveAnchorPhysicalFields = [URL, EventDate] (topmost Project, in SELECT order)
         * physical-named.
        );
import org.apache.calcite.plan.RelOptUtil;
            "SELECT URL || '-' || Title AS combined FROM hits ORDER BY EventDate LIMIT 10",
    public void testQtfDeclined_aggregateAboveAnchor() {
 * compatible open source license.
    public void testQtfFires_belowProjectAboveExchangeReducer_fieldStorageResolves() {
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),
        assertQtfFired(
                            "Scan rowType mismatch.\n  expected: "
            2,
        // BelowAnchor = {EventDate}; FetchOnly = {URL, Title} → fire.
        // The ___ugsi FSI override must survive the copy paths FragmentConversionDriver / DAGBuilder
    public void testQtfFires_aboveChainHasPassthroughSort() {
        // SELECT * FROM hits ORDER BY EventDate LIMIT 10
        );
    public void testQtfDeclined_skipPredicate_filterColIsOnlyProjection() {
                    }
         * Outer Project (immediately above wrapper) output field names, in order. Asserts the
        RelNode optimized = optimize(sql, shardCount);
                                + Arrays.toString(expectedIndices)
     * Repro of IndexSortPropagationIT.testSortLimit. QTF's post-CBO input (captured) is
            Expect.aboveAnchorPhysicalFields("CounterID", "UserID", "URL", "Title", "EventDate", "AdvEngineID", "ParamPrice"),
            Expect.erHasUgsi(true),
                                "Outer Project expr ["
                            return;
                        fail(
                                + "\n  actual:   "
            .add("CounterID", scan.getRowType().getFieldList().get(0).getType())
    public void testQtfFires_compositeExpressionWithDedup() {
        for (Expect e : expectations) {
import org.apache.calcite.rel.RelVisitor;
                        );
            2,
                                + sql
import org.opensearch.analytics.planner.rel.OpenSearchSort;
         * Outer Project (immediately above wrapper) RexInputRef indices, in expression order.
                                + "\n  actual:   "
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
            Expect.erHasUgsi(true),
            }
            "SELECT UPPER(Title) AS tup FROM hits ORDER BY EventDate LIMIT 10",
        PlannerContext context = new PlannerContext(new CapabilityRegistry(backends, FieldStorageResolver::new), state, false);
            fail("Expected QTF wrapper in plan for SQL: " + sql + "\nPlan:\n" + planText);
            2,
                    }
         */
}
            Expect.aboveAnchorPhysicalFields("URL", "CounterID"),
                                + expected
                                    + i
    private static FieldStorageInfo physicalFsi(String name, String mappingType, FieldType type) {
                    List<String> actual = fieldNames(ctx.scan.getRowType().getFieldList());
            "SELECT EventDate, URL FROM hits ORDER BY EventDate LIMIT 10",
    public void testQtfFires_outerFilter() {
            2,
                                + Arrays.toString(actual)
        // DESC collation preserved through anchor rebuild.
                }
            Expect.wrapperOutput("URL", "EventDate", "CounterID"),
        static Expect wrapperOutput(String... expectedNamesInOrder) {
            Expect.wrapperOutput("Title"),
        // SELECT URL FROM hits LIMIT 10
                    List<RelFieldCollation> fc = ctx.anchor.getCollation().getFieldCollations();
            return new Expect() {
        OpenSearchSort anchor;
    /** Walks an optimized plan once, capturing the QTF-relevant nodes. */
                    for (int i = 0; i < expected.length; i++) {
        Inspector(RelNode root) {
                                + sql
                                + "\nSQL: "
                                + "\n  actual:   "
    public void testQtfFires_expressionOperandIsSortKey() {
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),
    }
                            "Wrapper aboveAnchorPhysicalFields mismatch.\n  expected: "
                    }
        assertQtfDeclined("SELECT URL FROM hits ORDER BY (CounterID + 1) LIMIT 10", 2);
            return new Expect() {
                        return;
                            actual[i] = ref.getIndex();
                                    + expected[i]
                    if (!Arrays.equals(expectedIndices, actual)) {
 * </ul>
            2,
                super.visit(node, ordinal, parent);
        }
                }
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), false),
                        wrapper = w;
        // AboveAnchor = [URL, EventDate]; FetchOnly = {URL} → fire.
 * <p>Skip predicate: QTF fires iff
                    List<String> actual = fieldNames(ctx.outerProject.getRowType().getFieldList());
    }
import org.apache.calcite.rel.RelFieldCollation;
     */
        );
            "hits",
            return new Expect() {
    // ── Composable assert API ──────────────────────────────────────────
     * "RexInputRef[N] has no matching FieldStorageInfo entry". This builds that exact input
            Expect.erHasUgsi(true),
        // Refetching EventDate by row id when it already rode through the reduce would be a wash.
                        er.copyResolved("datafusion", er.getInputs(), List.of()),
            Expect.erHasUgsi(true),
 *   <li>ER output declares {@code ___ugsi} as the last field. Single-shard plans do not trigger
                    }
                                + "\nSQL: "
    private void assertQtfDeclined(String sql, int shardCount) {
 *   <li>Wrapper output rowType = {@code AboveAnchorPhysicalFields}, in
     * user's Sort+Limit. The rewriter must remap RexInputRefs in EVERY above op — not just the
                                + expected.length
                                    + fc.get(i).getDirection()
import java.util.Arrays;
        OpenSearchLateMaterialization wrapper;
                @Override
            cluster.traitSet(),
            Expect.aboveAnchorPhysicalFields("URL", "Title"),
        String planText = RelOptUtil.toString(optimized);
        static Expect scanCols(String... expectedNamesInOrder) {
        static Expect erHasUgsi(boolean expected) {
            public void visit(RelNode node, int ordinal, RelNode parent) {
    }
        return new FieldStorageInfo(name, mappingType, type, List.of("parquet"), List.of(), List.of(), false);
            2,
 * this file be licensed under the Apache-2.0 license or a
        OpenSearchTableScan scan = new OpenSearchTableScan(cluster, cluster.traitSet(), table, df, scanStorage);
     * Above-anchor chain has a Sort that doesn't reshape the rowType (passthrough on type, even
        RelDataType projRowType = typeFactory.builder()
            @Override
    public void testQtfFires_filterColAlsoProjected() {
        assertQtfDeclined("SELECT CounterID, COUNT(*) AS c FROM hits GROUP BY CounterID ORDER BY CounterID LIMIT 10", 2);
        assertQtfFired(
                                    + plan
        // BelowAnchor = {EventDate}. FetchOnly = everything except EventDate → fire.
        );
        }
        // SOURCE(SINGLETON) already satisfies the parent Sort's demand). QTF's win comes from
            "SELECT URL AS u, EventDate FROM hits ORDER BY EventDate LIMIT 10",
                    if (fc.size() != expected.length) {
                                + expected
    public void testQtfDeclined_aggregateBelowSort() {
            Expect.wrapperOutput("URL", "EventDate")
                                + actual
                    if (expected) {
        );
                    }
import org.apache.calcite.rel.type.RelDataType;
    public void testQtfDeclined_expressionProjectBelowAnchor() {
                + "GROUP BY inner_q.CounterID",
        // RexOver in the above-Project — declined (window's global frame needs SINGLETON input;
                        if (parent instanceof OpenSearchProject p) outerProject = p;
            Expect.scanCols("EventDate"),
        assertQtfFired(
import org.apache.calcite.rex.RexNode;
        static Expect collationDirections(RelFieldCollation.Direction... expected) {
        // EventDate is in BOTH BelowAnchor and AboveAnchor — refetched per v2 (no passthrough trick).
                        }
                    if (!expected.equals(actual)) {
    public void testQtfDeclined_pureLimit() {
        return out;
            Expect.wrapperOutput("URL", "Title"),
            Expect.scanCols("EventDate"),
                            "Anchor collation size mismatch. expected="
        assertQtfDeclined("SELECT CounterID FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10", 2);
            };
            .add("URL", scan.getRowType().getFieldList().get(2).getType())
        );
     * throwing "RexInputRef out of range" — that's exactly what would fire if the remap stopped
    }
            "SELECT * FROM (" + "  SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10" + ") AS sub ORDER BY EventDate",
        // URL is BOTH the sort key (BelowAnchor → narrowed scan) AND an expression operand
            "SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10 OFFSET 5",
    public void testQtfFires_offset() {
                    if (!expected.equals(actual)) {
                super.visit(node, ordinal, parent);
        );
import org.apache.calcite.rex.RexInputRef;
                }
     */
                                    + "\nSQL: "
                                    + " actual="
package org.opensearch.analytics.planner;
                                + " actual="
            Expect.scanCols("CounterID", "EventDate"),
                }
        RelOptTable table = mockTable(
                            fail(
                    if (!expected.equals(actual)) {
         * (i.e. fetch list, in order).
        /** Scan rowType (post-narrowing) carries exactly these original cols + {@code ___row_id}. */
            2,
            Expect.scanCols("EventDate"),
            new String[] { "CounterID", "EventDate", "URL" },
        // AboveAnchorPhysicalFields = [URL, EventDate]
        // BelowAnchorPhysicalFields = {EventDate}
            e.check(ctx, sql, planText);
            rexBuilder.makeInputRef(scan, 0),
        );
                                    + "\nPlan:\n"
        // SELECT URL, EventDate, CounterID FROM hits ORDER BY EventDate ASC, CounterID DESC LIMIT 10
        }
                        if (ctx.er == null) fail("Expected ER in plan but none found.\nSQL: " + sql + "\nPlan:\n" + plan);
                void check(Inspector ctx, String sql, String plan) {
                                + "\nPlan:\n"
            Expect.aboveAnchorPhysicalFields("Title", "URL"),
                    int[] actual = new int[ctx.outerProject.getProjects().size()];
    }
        // FetchOnly = {URL} → fire
        );
        OpenSearchFilter filter = new OpenSearchFilter(cluster, cluster.traitSet(), scan, gtZero, df);
    public void testQtfDeclined_windowInOuterProject() {
                void check(Inspector ctx, String sql, String plan) {
                        fail(
                        assertEquals(
            Expect.scanCols("EventDate"),
 *   <li>Scan rowType narrowed to {@code BelowAnchorPhysicalFields + ___row_id}.</li>
                            fail("ER output missing ___ugsi as last col. Fields: " + erFields + "\nSQL: " + sql + "\nPlan:\n" + plan);
                @Override
            Expect.outerProjectNames("combined")
            Expect.aboveAnchorPhysicalFields("URL"),
                            fail(
    /**
        // AboveAnchor = [Title]; BelowAnchor = {EventDate}; FetchOnly = {Title} → fire.
    public void testQtfFires_expressionOnNeverDisplayedCol() {
                        fail("No outer Project above wrapper.\nSQL: " + sql + "\nPlan:\n" + plan);
            Expect.wrapperOutput("URL", "CounterID")
        // SELECT URL, EventDate FROM hits WHERE EventDate > '2020-01-01' ORDER BY EventDate LIMIT 10
     * at the anchor's immediate parent and missed the outer Project sitting above the
            Expect.collationDirections(RelFieldCollation.Direction.ASCENDING, RelFieldCollation.Direction.DESCENDING)
import org.opensearch.analytics.spi.FieldType;
            Expect.scanCols("EventDate"),
        assertQtfDeclined("SELECT EventDate FROM hits ORDER BY EventDate LIMIT 10", 2);
        Inspector ctx = new Inspector(optimized);
            Expect.scanCols("EventDate"),
                                + expected
        return optimize(sql, shardCount, List.of(DATAFUSION, LUCENE));
                void check(Inspector ctx, String sql, String plan) {
                new RelFieldCollation(2, RelFieldCollation.Direction.DESCENDING),
        assertQtfFired(
        );
            .build();
            public void visit(RelNode node, int ordinal, RelNode parent) {
            Expect.wrapperOutput("URL", "EventDate")
            2,
    public void testQtfFires_multiKeySortMixedDirection() {
                    if (!expected.equals(actual)) {
     * directly (no SQL/CBO/cluster) and asserts the rewritten plan's FSI walk does not throw.
        );
        abstract void check(Inspector ctx, String sql, String planText);
        // FetchOnly = {URL} → fire. CounterID refetched.
    public void testQtfFires_aboveChainSortRemapsCollation() {
                @Override
                }
 *
 * The OpenSearch Contributors require contributions made to
                                + "\nPlan:\n"
        );
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;
                        fail(
            Expect.scanCols("URL"),
    }
            Expect.aboveAnchorPhysicalFields("URL", "EventDate", "CounterID"),
            rexBuilder.makeLiteral(0, typeFactory.createSqlType(SqlTypeName.INTEGER), false)
        // SELECT URL, CounterID FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10
    private RelNode optimize(String sql, int shardCount, List<AnalyticsSearchBackendPlugin> backends) {
         */
        }.go(rewritten.get());
                                + sql
            return new Expect() {
    }
            Expect.scanCols("EventDate"),
        // SELECT CounterID, COUNT(*) FROM hits GROUP BY CounterID ORDER BY CounterID LIMIT 10
                    expected.add(OpenSearchLateMaterialization.ROW_ID_FIELD);
        }
                        );
                                    + sql
                    }
                            );
        static Expect outerProjectExprIndices(int... expectedIndices) {
        Inspector ctx = new Inspector(optimized);
                + ") AS sub ORDER BY EventDate LIMIT 100",
         * Wrapper carries exactly these field names as its {@code AboveAnchorPhysicalFields}
                        OpenSearchExchangeReducer c = (OpenSearchExchangeReducer) copy;
        assertQtfDeclined("SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10", 1);
    }
        // Scan: [CounterID, EventDate, URL] all physical (datafusion-backed), matching the IT.
            cluster,
        assertQtfFired(
                    )) {
                                + plan
        assertQtfFired(
                                + plan
                    super.visit(node, ordinal, parent);
                    List<String> expected = Arrays.asList(expectedNamesInOrder);
        return PlannerImpl.runAllOptimizations(parsed, context);
        java.util.Optional<RelNode> rewritten = org.opensearch.analytics.planner.rules.OpenSearchLateMaterializationRewriter.rewrite(sort);
                void check(Inspector ctx, String sql, String plan) {
 * <ul>
            physicalFsi("URL", "keyword", FieldType.KEYWORD)
            2
            "SELECT Title || '-' || URL AS combined FROM hits ORDER BY URL LIMIT 10",
    private abstract static class Expect {
            "SELECT * FROM hits ORDER BY EventDate LIMIT 10",
                + "  SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10"
            Expect.erHasUgsi(true),
        // SELECT URL, EventDate, CounterID FROM hits ORDER BY EventDate, CounterID LIMIT 10
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),
                    if (actual.contains(OpenSearchLateMaterialization.ROW_ID_FIELD)
                    }
 * SPDX-License-Identifier: Apache-2.0
        assertQtfFired(
    }
        // BelowAnchor = {EventDate, CounterID}, AboveAnchor = [URL, EventDate, CounterID]
            List.of(rexBuilder.makeInputRef(er, 2), rexBuilder.makeInputRef(er, 1), rexBuilder.makeInputRef(er, 0)),
            };
                @Override
            new RelVisitor() {
        // AboveAnchor deps = [Title, URL]; BelowAnchor = {URL}; FetchOnly = {Title} → fire.
                        fail("Wrapper output leaked helper col(s) " + actual + "\nSQL: " + sql + "\nPlan:\n" + plan);
        /** Anchor Sort collation directions in order. */
        List<FieldStorageInfo> scanStorage = List.of(
            "SELECT URL, EventDate, CounterID FROM hits ORDER BY EventDate ASC, CounterID DESC LIMIT 10",
                                + "\nSQL: "
        // Filter on EventDate is below-Filter (predicate pushdown), so EventDate stays in BelowAnchor.
        // Derived sort key → declines (collation references a derived below-Project slot; can't
                        er.stripAnnotations(er.getInputs())
        // Aggregate above the anchor — explicitly excluded from ABOVE_ALLOWED in v2.
    /**
                                + sql
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
        // col in both roles, and the merged top Project dropping URL so only `combined` surfaces.
        );
    }
    // ── Tests that fire QTF ────────────────────────────────────────────
        // no gather there's nothing to save, so the rewriter declines.
                        );
        );
            2,
            Expect.wrapperOutput("Title", "URL"),
                                    + i
    public void testQtfFires_starProjection() {
    }
            };
            2,
                                + "\nSQL: "
        }
        assertQtfDeclined("SELECT URL, SUM(ParamPrice) OVER () AS sp FROM hits ORDER BY EventDate LIMIT 10", 2);
                    List<String> expected = new ArrayList<>(Arrays.asList(expectedNamesInOrder));
                    }
    }
            SqlStdOperatorTable.GREATER_THAN,
        /**
            Expect.erHasUgsi(true),
     * if collation differs). The PPL/SQL frontends emit this when a SystemLimit Sort wraps the
            project,
    }
        assertQtfFired(
        // Two collation indices, mixed direction — exercises collationReferencesDerivedSlot over
            Expect.aboveAnchorPhysicalFields("EventDate", "URL"),
 *
            "SELECT inner_q.CounterID, COUNT(*) AS c "
            "SELECT URL, CounterID FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10",
        // SELECT URL, EventDate FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10
                    List<String> actual = fieldNames(ctx.wrapper.getAboveAnchorPhysicalFields());
            Expect.wrapperOutput("URL", "EventDate"),
        if (ctx.wrapper == null) {
            Expect.erHasUgsi(true),
                        );
            Expect.wrapperOutput("URL"),
    public void testQtfDeclined_skipPredicate_sortColIsOnlyProjection() {
        static Expect outerProjectNames(String... expectedNamesInOrder) {
                                + "\nPlan:\n"
        assertQtfFired(
        /**
        // SELECT URL FROM hits ORDER BY (CounterID + 1) LIMIT 10
import org.apache.calcite.sql.type.SqlTypeName;
         * derived expressions like {@code UPPER(URL)}).
        ClusterState state = SqlPlannerTestFixture.clusterStateWith(ClickBench.INDEX, ClickBench.BASIC_FIELDS, "parquet", shardCount);
                            c.getOutputFieldStorage().size()
            };
    }
    public void testQtfFires_compositeExpressionMultiCol() {
            df
 *   <li>Outer Project's RexInputRefs are remapped to wrapper-output indices.</li>
    public void testQtfDeclined_singleShard() {
                            "Outer Project RexInputRef indices mismatch.\n  expected: "
                        List<String> erFields = fieldNames(ctx.er.getRowType().getFieldList());
