        new RelVisitor() {  
    public void testQtfDeclined_expressionProjectBelowAnchor() {  
            Expect.erHasUgsi(true),  
            Expect.wrapperOutput("URL", "EventDate")
 *
    public void testQtfFires_aliasPreserved() {
            Expect.scanCols("CounterID", "EventDate"),
    public void testQtfDeclined_aggregateAboveAnchor() {
        );
         * (i.e. fetch list, in order).
        // SELECT * FROM hits ORDER BY EventDate LIMIT 10
        // col in both roles, and the merged top Project dropping URL so only `combined` surfaces.
            Expect.erHasUgsi(true),
            rexBuilder.makeLiteral(10, typeFactory.createSqlType(SqlTypeName.INTEGER), false),
     * wrapper-output space, even when there's no Project sitting between Sort and anchor.
     * at the anchor's immediate parent and missed the outer Project sitting above the
    }  
            new RelVisitor() {
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),  
                            "ER rowType and FSI must stay aligned 1:1 after " + copy,  
     * "RexInputRef[N] has no matching FieldStorageInfo entry". This builds that exact input
                            "Anchor collation size mismatch. expected="  
        // avoiding cross-node materialization of fetch-only columns through the gather; with  
        OpenSearchExchangeReducer er = new OpenSearchExchangeReducer(cluster, cluster.traitSet(), filter, df);
    }
        // AboveAnchorPhysicalFields = [URL, EventDate] (topmost Project, in SELECT order)
                        );  
            Expect.erHasUgsi(true),
            RelCollations.of(
            2,
                @Override
                            fail("ER output missing ___ugsi as last col. Fields: " + erFields + "\nSQL: " + sql + "\nPlan:\n" + plan);
                        wrapper = w;
            new String[] { "CounterID", "EventDate", "URL" },
                            fail(
                                + "\n  actual:   "
                        return;  
            Expect.scanCols("EventDate"),
 * <p>Each test drives a SQL string (Calcite dialect) through the full planner and asserts
        // SELECT CounterID FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10  
                    if (node instanceof OpenSearchExchangeReducer r && er == null) er = r;  
     * Repro of IndexSortPropagationIT.testSortLimit. QTF's post-CBO input (captured) is
            projRowType,
    }
                                    + i  
    public void testQtfFires_belowProjectAboveExchangeReducer_fieldStorageResolves() {
                                + plan
            2,  
        // the wrapper would break that).
        // AboveAnchorPhysicalFields = [URL, EventDate]
 *   <li>ER output declares {@code ___ugsi} as the last field. Single-shard plans do not trigger  
            2,
    }  
import org.apache.calcite.rex.RexNode;
                                + "\n  actual:   "  
        assertQtfFired(
            "SELECT EventDate, URL FROM hits ORDER BY EventDate LIMIT 10",
        RelDataType projRowType = typeFactory.builder()
    public void testQtfFires_simpleSortProject() {
    public void testQtfFires_aboveChainSortRemapsCollation() {  
        String planText = RelOptUtil.toString(optimized);
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),  
     * immediate parent — because each passthrough Sort/Filter leaks the narrowed rowType upward.
                void check(Inspector ctx, String sql, String plan) {
     * Above-anchor chain has a Sort that doesn't reshape the rowType (passthrough on type, even
                                + actual
                @Override
    }
        // BelowAnchor = {EventDate, CounterID}, AboveAnchor = [URL, EventDate, CounterID]
        );
        );  
                                + Arrays.toString(actual)
                        fail("Wrapper output leaked helper col(s) " + actual + "\nSQL: " + sql + "\nPlan:\n" + plan);
        // Outer Sort's collation index must remap from anchor-space to wrapper-space (where  
            .add("URL", scan.getRowType().getFieldList().get(2).getType())
        // SELECT URL AS u, EventDate FROM hits ORDER BY EventDate LIMIT 10
                        OpenSearchExchangeReducer c = (OpenSearchExchangeReducer) copy;
         */
        static Expect outerProjectExprIndices(int... expectedIndices) {  
                                    + "] is not a RexInputRef: "
                    } else {  
                super.visit(node, ordinal, parent);  
        // Aggregate sits below the anchor — not in BELOW_INTERMEDIATE_ALLOWED, declined.
                    for (int i = 0; i < actual.length; i++) {  
        assertQtfFired(
                }
            "SELECT URL || '-' || URL AS combined, UPPER(URL) AS upper_url FROM hits ORDER BY EventDate LIMIT 10",  
                    }
            Expect.scanCols("CounterID", "EventDate"),
        // use (copy, copyResolved, stripAnnotations) — otherwise rowType (4 cols) and FSI (3) diverge
 *  
        /**
            return new Expect() {
        OpenSearchTableScan scan = new OpenSearchTableScan(cluster, cluster.traitSet(), table, df, scanStorage);
            .add("CounterID", scan.getRowType().getFieldList().get(0).getType())
                                + "\nPlan:\n"
        // SELECT URL FROM hits LIMIT 10
        return optimize(sql, shardCount, List.of(DATAFUSION, LUCENE));
        OpenSearchTableScan scan;
    public void testQtfDeclined_skipPredicate_filterColIsOnlyProjection() {
        Inspector ctx = new Inspector(optimized);  
            Expect.scanCols("EventDate"),
 * compatible open source license.
    }  
                @Override
                                + "\nPlan:\n"  
            df  
                        );  
            physicalFsi("CounterID", "integer", FieldType.INTEGER),  
         * Outer Project (immediately above wrapper) RexInputRef indices, in expression order.
            2,
        // FetchOnly = {URL} → fire. CounterID refetched.
        // BelowAnchor = {EventDate}; FetchOnly = {URL, Title} → fire.
                    }
                    }  
        assertQtfDeclined("SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10", 1);
 */  
        }  
    public void testQtfFires_multiKeySort() {
    }  
         * topmost-op order). Helpers must be absent.  
                    }  
                        List<String> erFields = fieldNames(ctx.er.getRowType().getFieldList());
                    List<String> expected = Arrays.asList(expectedNamesInOrder);
        // AboveAnchor = [Title]; BelowAnchor = {EventDate}; FetchOnly = {Title} → fire.
        // Two collation indices, mixed direction — exercises collationReferencesDerivedSlot over  
                    super.visit(node, ordinal, parent);
            Expect.aboveAnchorPhysicalFields("CounterID", "UserID", "URL", "Title", "EventDate", "AdvEngineID", "ParamPrice"),
                    for (RelNode copy : List.of(
 * this file be licensed under the Apache-2.0 license or a
                    }
                public void visit(RelNode node, int ordinal, RelNode parent) {  
    private void assertQtfDeclined(String sql, int shardCount) {  
    public void testQtfFires_multiKeySortMixedDirection() {
        return PlannerImpl.runAllOptimizations(parsed, context);
        // FetchOnly = {URL} → fire  
        assertQtfFired(
                void check(Inspector ctx, String sql, String plan) {  
        static Expect erHasUgsi(boolean expected) {
import java.util.Arrays;
            Expect.aboveAnchorPhysicalFields("URL", "CounterID"),  
            "SELECT URL, EventDate, CounterID FROM hits ORDER BY EventDate, CounterID LIMIT 10",
                        }
        // SELECT URL || '-' || URL AS combined, UPPER(URL) AS upper_url FROM hits ORDER BY EventDate LIMIT 10  
        // Wrapper output is physical-named [URL, EventDate]; the Project above the wrapper  
                                    + "] direction mismatch. expected="  
                        fail("No outer Project above wrapper.\nSQL: " + sql + "\nPlan:\n" + plan);
        // sort above the wrapper on it). Display-only expressions DO fire — see compositeExpression*.  
                        );
                }  
            "SELECT inner_q.CounterID, COUNT(*) AS c "
                        );
                }  
        // BelowAnchor = {EventDate}; FetchOnly = {URL} → fire.  
        if (ctx.wrapper != null) {  
         */
                }
            };  
import org.opensearch.analytics.planner.rel.OpenSearchFilter;
                        if (ctx.er != null) fail("Did not expect ER in plan (single-shard).\nSQL: " + sql + "\nPlan:\n" + plan);
import org.opensearch.analytics.planner.rel.OpenSearchLateMaterialization;  
    }  
                                + plan  
 * SPDX-License-Identifier: Apache-2.0
                        fail(
                }  
import org.opensearch.analytics.planner.rel.OpenSearchRelNode;
                    if (!expected.equals(actual)) {
            Expect.wrapperOutput("Title", "URL"),  
     * user's Sort+Limit. The rewriter must remap RexInputRefs in EVERY above op — not just the  
            "SELECT URL, CounterID FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10",  
                    int[] actual = new int[ctx.outerProject.getProjects().size()];
            Expect.scanCols("CounterID", "EventDate"),
        // Outer Sort by EventDate (= sort key, present in BelowAnchor); anchor Sort by EventDate.
        // Single shard: CBO inserts no ExchangeReducer below the anchor (the scan's
        assertQtfFired(  
        abstract void check(Inspector ctx, String sql, String planText);  
                            "Scan rowType mismatch.\n  expected: "  
import org.apache.calcite.plan.RelOptTable;
 * </ul>
        // FetchOnly = {URL} → fire. All three referenced fields end up in fetch list (v2 refetches).
        );
                        fail(
                    }
        );
                                + expected  
                                + plan
        assertQtfFired(
    }  
            };
    public void testQtfDeclined_windowInOuterProject() {
    }
        RelNode optimized = optimize(sql, shardCount);
import org.apache.calcite.rel.RelVisitor;  
                                    + "\nPlan:\n"
                                "Outer Project expr ["
                        if (parent instanceof OpenSearchProject p) outerProject = p;  
        RexNode gtZero = rexBuilder.makeCall(
    }
            rexBuilder.makeLiteral(0, typeFactory.createSqlType(SqlTypeName.INTEGER), false)
import org.apache.calcite.rel.RelFieldCollation;
            }.go(root);
                                    + "\nPlan:\n"  
        // (Above-Aggregate group/aggCall remap under a moving wrapper rowType is a follow-up.)
        );
            Expect.outerProjectExprIndices(0, 1)  
import java.util.List;  
            @Override
                    List<String> expected = new ArrayList<>(Arrays.asList(expectedNamesInOrder));
                                + "\n  actual:   "  
 *
            2,
                    if (node instanceof OpenSearchTableScan t && scan == null) scan = t;
                    if (ctx.outerProject == null) {
        java.util.Optional<RelNode> rewritten = org.opensearch.analytics.planner.rules.OpenSearchLateMaterializationRewriter.rewrite(sort);
 * <p>Skip predicate: QTF fires iff
            }
            Expect.wrapperOutput("URL", "EventDate")
                @Override
                new RelFieldCollation(2, RelFieldCollation.Direction.DESCENDING),  
    public void testQtfFires_descendingSort() {
        /** Anchor Sort collation directions in order. */
                                + "\nPlan:\n"
        // Below-Project ABOVE the ER: SELECT URL($2), EventDate($1), CounterID($0)  
        // BelowAnchor = {CounterID, EventDate}, AboveAnchor = [URL, CounterID]  
                        );
    }  
        );
                }  
        // Wrapper output is in topmost-op (SELECT) order, NOT scan order.
                void check(Inspector ctx, String sql, String plan) {
        // SELECT URL, EventDate, CounterID FROM hits ORDER BY EventDate ASC, CounterID DESC LIMIT 10
            2,
            Expect.erHasUgsi(true)
        // No ORDER BY → no anchor → no rewrite.  
        // BelowAnchorPhysicalFields = {EventDate}
        // SOURCE(SINGLETON) already satisfies the parent Sort's demand). QTF's win comes from
                                    + plan  
        // AboveAnchor = {CounterID}; BelowAnchor = {CounterID, EventDate}; FetchOnly = {} → skip.
                        fail("No outer Project above wrapper.\nSQL: " + sql + "\nPlan:\n" + plan);
        // EventDate is at position 1).
            return new Expect() {
        // Aggregate above the anchor — explicitly excluded from ABOVE_ALLOWED in v2.  
            Expect.scanCols("EventDate"),
        Inspector ctx = new Inspector(optimized);
    }
            2,
                                + expected  
                    List<String> actual = fieldNames(ctx.outerProject.getRowType().getFieldList());
        // re-applies the SELECT alias so the result column is `u`, not `URL`.
                            );
            Expect.erHasUgsi(true),  
        );
 * <ul>
        );
    }
            Expect.outerProjectNames("tup")  
                super.visit(node, ordinal, parent);  
                    if (actual.contains(OpenSearchLateMaterialization.ROW_ID_FIELD)
            Expect.wrapperOutput("URL", "Title"),
        // multiple keys and the collation rebuild preserving per-key direction.
                                + actual  
            2
public class LateMaterializationPlanShapeTests extends BasePlannerRulesTests {
            2,
            Expect.scanCols("EventDate"),
     * <p>The implicit guarantee under test: the rewrite completes without Calcite's RexChecker  
            ),
    private void assertQtfFired(String sql, int shardCount, Expect... expectations) {  
                + ") AS sub ORDER BY EventDate LIMIT 100",  
     * if collation differs). The PPL/SQL frontends emit this when a SystemLimit Sort wraps the
                                + plan  
                                    + ctx.outerProject.getProjects().get(i)
        // The ___ugsi FSI override must survive the copy paths FragmentConversionDriver / DAGBuilder
                            "Wrapper output rowType mismatch.\n  expected: "
                                + Arrays.toString(expectedIndices)
                                + "\nPlan:\n"
            Expect.scanCols("EventDate"),
    }
        assertQtfDeclined(  
        // SELECT inner.CounterID, COUNT(*) FROM (SELECT CounterID FROM hits ORDER BY CounterID LIMIT 100) AS inner GROUP BY inner.CounterID
        // RexOver in the above-Project — declined (window's global frame needs SINGLETON input;
         * physical-named.  
        }.go(rewritten.get());
        // AboveAnchor = [URL, EventDate]; FetchOnly = {URL} → fire.
            null,  
                        fail(
            Expect.erHasUgsi(true),
         * derived expressions like {@code UPPER(URL)}).
                @Override
            Expect.collationDirections(RelFieldCollation.Direction.ASCENDING, RelFieldCollation.Direction.DESCENDING)  
            Expect.wrapperOutput("URL", "EventDate"),
    }  
        // Walk FSI over every OpenSearchRelNode, mirroring DAGBuilder.cutAtLateMaterialization — must not throw.
            @Override
            Expect.aboveAnchorPhysicalFields("EventDate", "URL"),
                            "Outer Project RexInputRef indices mismatch.\n  expected: "
                        || actual.contains(OpenSearchLateMaterialization.UGSI_FIELD)) {  
        // OFFSET preserved on the rebuilt anchor Sort.
        // SELECT EventDate FROM hits ORDER BY EventDate LIMIT 10
import org.apache.calcite.rel.RelCollations;  
        // SELECT URL || '-' || Title AS combined FROM hits ORDER BY EventDate LIMIT 10
        // SELECT EventDate, URL FROM hits ORDER BY EventDate LIMIT 10
                                + plan
    }  
    public void testQtfDeclined_pureLimit() {
            Expect.erHasUgsi(true),
                                + sql
                                    + "\nSQL: "  
import java.util.ArrayList;
 *       {@code TopmostOperatorAboveAnchor} order. Helpers stripped.</li>  
                                + sql  
                        );
            Expect.wrapperOutput("URL", "EventDate")
                    }
        }
    public void testQtfFires_starProjection() {
                    if (fc.size() != expected.length) {
                            "Wrapper aboveAnchorPhysicalFields mismatch.\n  expected: "
        // SELECT URL, EventDate FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10
                            return;
                void check(Inspector ctx, String sql, String plan) {
        }
        /**  
                                    + plan
                            c.getOutputFieldStorage().size()
            Expect.scanCols("EventDate"),
            };
            2,
     * ER carries ___ugsi as its last column, so the below-Project's positional "last = ___row_id"
                                + "\nSQL: "
        Inspector(RelNode root) {  
            "SELECT URL, EventDate FROM hits WHERE EventDate > DATE '2020-01-01' ORDER BY EventDate LIMIT 10",  
            new SqlTypeName[] { SqlTypeName.INTEGER, SqlTypeName.INTEGER, SqlTypeName.VARCHAR }  
        }  
                void check(Inspector ctx, String sql, String plan) {  
    public void testQtfDeclined_aggregateBelowSort() {
    private abstract static class Expect {
            Expect.outerProjectExprIndices(0, 1)
        // SELECT URL, CounterID FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10
        }
                                + "\nSQL: "
/**
            .build();
            Expect.outerProjectExprIndices(0, 1)
                                + expected.length
import org.apache.calcite.rel.RelNode;
        assertQtfFired(
                                + actual
    }
                                + " actual="
            };
                        er.copyResolved("datafusion", er.getInputs(), List.of()),
import org.opensearch.analytics.spi.AnalyticsSearchBackendPlugin;
        );  
                }
        // SELECT URL FROM hits ORDER BY (CounterID + 1) LIMIT 10
            Expect.erHasUgsi(true),
}
        );
    }
            Expect.outerProjectNames("combined")  
        List<FieldStorageInfo> scanStorage = List.of(
import org.apache.calcite.sql.fun.SqlStdOperatorTable;
                }
        assertQtfFired(  
        /** ER carries (or does not carry) {@code ___ugsi} as its last column. */
                    if (ctx.outerProject == null) {  
            2,
                if (node instanceof OpenSearchExchangeReducer er) {
        /**
            "SELECT Title || '-' || URL AS combined FROM hits ORDER BY URL LIMIT 10",
        // Topmost Project's outputs are passthrough refs to every physical field.  
            Expect.erHasUgsi(true),
    // ── Composable assert API ──────────────────────────────────────────
                    if (!expected.equals(actual)) {
            2,
        assertQtfDeclined("SELECT CounterID, COUNT(*) AS c FROM hits GROUP BY CounterID ORDER BY CounterID LIMIT 10", 2);
            "SELECT * FROM hits ORDER BY EventDate LIMIT 10",
        RelNode parsed = SqlPlannerTestFixture.parseSql(sql, state);
                                + "\nPlan:\n"
    }  
                            );
            cluster.traitSet(),
        // SELECT CounterID, COUNT(*) FROM hits GROUP BY CounterID ORDER BY CounterID LIMIT 10  
            "SELECT URL, EventDate FROM ("
                    )) {  
            Expect.erHasUgsi(true),
        RelNode optimized = optimize(sql, shardCount);
        assertTrue("QTF must fire for Sort→Project→ER→Filter→Scan", rewritten.isPresent());  
import org.apache.calcite.rel.type.RelDataTypeField;
        );
            2,  
            2,
                                    + expected[i]
        }.go(rewritten.get());
        // dependsOn walk yields {URL, Title} in evaluation order.  
                    if (node instanceof OpenSearchLateMaterialization w && wrapper == null) {
    private static final class Inspector {
import org.apache.calcite.rel.type.RelDataType;
        // Filter CounterID($0) > 0
                + "GROUP BY inner_q.CounterID",  
    private static FieldStorageInfo physicalFsi(String name, String mappingType, FieldType type) {
            Expect.scanCols("EventDate"),  
                    List<String> actual = fieldNames(ctx.wrapper.getRowType().getFieldList());  
                    for (int i = 0; i < expected.length; i++) {
            2,
     * the ER (unlike the simpler {@code Sort → ER → Project → Scan} cases). After rewrite the
                        if (ctx.outerProject.getProjects().get(i) instanceof RexInputRef ref) {
                    if (!expected.equals(actual)) {  
        );
    public void testQtfFires_expressionOnNeverDisplayedCol() {
        // AboveAnchor = [CounterID, UserID, URL, Title, EventDate, AdvEngineID, ParamPrice].
    }
         * Wrapper carries exactly these field names as its {@code AboveAnchorPhysicalFields}  
        // Refetching EventDate by row id when it already rode through the reduce would be a wash.
     * throwing "RexInputRef out of range" — that's exactly what would fire if the remap stopped
                void check(Inspector ctx, String sql, String plan) {
        );
        );
                    if (!Arrays.equals(expectedIndices, actual)) {
            Expect.wrapperOutput("CounterID", "UserID", "URL", "Title", "EventDate", "AdvEngineID", "ParamPrice")  
        // Both above-Project outputs derive from URL. dependsOn walk + LinkedHashSet dedup
            Expect.outerProjectNames("u", "EventDate")  
            2,  
            Expect.outerProjectNames("combined")
                                + "\nSQL: "
            project,
                    }
            Expect.scanCols("URL"),  
                + "FROM (SELECT CounterID FROM hits ORDER BY CounterID LIMIT 100) AS inner_q "
     */  
            public void visit(RelNode node, int ordinal, RelNode parent) {  
                new RelFieldCollation(1, RelFieldCollation.Direction.DESCENDING)
                    }
            Expect.wrapperOutput("URL", "CounterID")
    public void testQtfDeclined_skipPredicate_sortColIsOnlyProjection() {
    // ── Tests that fire QTF ────────────────────────────────────────────  
            Expect.aboveAnchorPhysicalFields("Title", "URL"),
                    }
        OpenSearchSort anchor;
        OpenSearchFilter filter = new OpenSearchFilter(cluster, cluster.traitSet(), scan, gtZero, df);
        );
    /**
                                + sql
        // BelowAnchor = {EventDate}. FetchOnly = everything except EventDate → fire.
        return new FieldStorageInfo(name, mappingType, type, List.of("parquet"), List.of(), List.of(), false);  
            "SELECT * FROM (" + "  SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10" + ") AS sub ORDER BY EventDate",  
            Expect.scanCols("EventDate"),
            cluster,
        assertQtfFired(
        static Expect outerProjectNames(String... expectedNamesInOrder) {
        // AboveAnchor deps = [Title, URL]; BelowAnchor = {URL}; FetchOnly = {Title} → fire.
    public void testQtfFires_sortColAlsoProjected() {  
    }
            "hits",
            return new Expect() {  
            Expect.wrapperOutput("EventDate", "URL"),
import org.opensearch.analytics.spi.FieldStorageInfo;  
                        if (fc.get(i).getDirection() != expected[i]) {
            "SELECT URL AS u, EventDate FROM hits ORDER BY EventDate LIMIT 10",  
        /**
            "SELECT URL, EventDate FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10",  
            Expect.wrapperOutput("URL", "EventDate", "CounterID")  
                    if (expected) {  
            Expect.aboveAnchorPhysicalFields("URL", "Title"),  
    }
        assertQtfFired(
                    List<String> actual = fieldNames(ctx.wrapper.getAboveAnchorPhysicalFields());
            .add("EventDate", scan.getRowType().getFieldList().get(1).getType())  
            fail("Expected QTF wrapper in plan for SQL: " + sql + "\nPlan:\n" + planText);
            List.of(rexBuilder.makeInputRef(er, 2), rexBuilder.makeInputRef(er, 1), rexBuilder.makeInputRef(er, 0)),
        // Outer Project carries RexCall expressions, not bare InputRefs — outerProjectExprIndices skipped.
        assertQtfFired(
     * lookup grabs ___ugsi instead — surfacing downstream as the DAGBuilder FSI walk throwing  
        // AboveAnchor = {EventDate}; BelowAnchor = {EventDate}; FetchOnly = {} → skip.  
    public void testQtfFires_outerFilter() {
                                + expected
                    List<String> expected = Arrays.asList(expectedNamesInOrder);
        for (Expect e : expectations) {
        }
            cluster.traitSet(),  
        // no gather there's nothing to save, so the rewriter declines.
     * {@code Sort → Project → ExchangeReducer → Filter → Scan} — the below-Project sits ABOVE  
        List<String> df = List.of("datafusion");
        );  
    }  
                                + "\n  actual:   "
                        }  
                    List<String> actual = fieldNames(ctx.scan.getRowType().getFieldList());
     */
                        return;
    public void testQtfFires_expressionOperandIsSortKey() {
    }  
    public void testQtfFires_compositeExpressionMultiCol() {
    }
            Expect.aboveAnchorPhysicalFields("Title"),  
        assertQtfDeclined("SELECT URL, SUM(ParamPrice) OVER () AS sp FROM hits ORDER BY EventDate LIMIT 10", 2);  
            er,  
        // DESC collation preserved through anchor rebuild.  
    /**  
                        if (ctx.er == null) fail("Expected ER in plan but none found.\nSQL: " + sql + "\nPlan:\n" + plan);
            physicalFsi("EventDate", "integer", FieldType.INTEGER),
                            fail(  
            fail("QTF should NOT have fired for SQL: " + sql + "\nPlan:\n" + RelOptUtil.toString(optimized));
            "SELECT URL, EventDate, CounterID FROM hits ORDER BY EventDate ASC, CounterID DESC LIMIT 10",  
        static Expect aboveAnchorPhysicalFields(String... expectedNamesInOrder) {  
                    }  
                                + expected
        assertQtfDeclined("SELECT URL FROM hits ORDER BY (CounterID + 1) LIMIT 10", 2);
                    List<String> expected = Arrays.asList(expectedNamesInOrder);
    /** Walks an optimized plan once, capturing the QTF-relevant nodes. */
            SqlStdOperatorTable.GREATER_THAN,  
                        if (!OpenSearchLateMaterialization.UGSI_FIELD.equals(erFields.get(erFields.size() - 1))) {  
            Expect.aboveAnchorPhysicalFields("URL"),  
 *       QTF (no gather to skip).</li>
            Expect.aboveAnchorPhysicalFields("URL", "EventDate", "CounterID"),
package org.opensearch.analytics.planner;
            Expect.erHasUgsi(true),
         * Wrapper output rowType is exactly these names (= {@code AboveAnchorPhysicalFields} in
        RelOptTable table = mockTable(  
        OpenSearchProject project = new OpenSearchProject(  
        // Anchor Sort: ORDER BY CounterID($2) DESC, EventDate($1) DESC LIMIT 10  
            Expect.wrapperOutput("URL"),
        static Expect collationDirections(RelFieldCollation.Direction... expected) {
        new RelVisitor() {
    }
        static Expect wrapperOutput(String... expectedNamesInOrder) {
        assertQtfDeclined("SELECT EventDate FROM hits ORDER BY EventDate LIMIT 10", 2);
        ClusterState state = SqlPlannerTestFixture.clusterStateWith(ClickBench.INDEX, ClickBench.BASIC_FIELDS, "parquet", shardCount);
            Expect.erHasUgsi(true),
            "SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10 OFFSET 5",  
                                    + sql
                        if (w.getInput() instanceof OpenSearchSort s) anchor = s;
    private static List<String> fieldNames(List<RelDataTypeField> fields) {
         * Skip this assertion for projects whose expressions are not bare InputRefs (e.g.  
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),
            Expect.erHasUgsi(true),  
    }
        assertQtfDeclined("SELECT URL FROM hits LIMIT 10", 2);
                    expected.add(OpenSearchLateMaterialization.ROW_ID_FIELD);  
            Expect.wrapperOutput("URL", "EventDate"),
     * Above-anchor Sort's collation index must be remapped from anchor-input space to  
     * directly (no SQL/CBO/cluster) and asserts the rewritten plan's FSI walk does not throw.
        // EventDate is in BOTH BelowAnchor and AboveAnchor — refetched per v2 (no passthrough trick).  
            "SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10",
        // Derived sort key → declines (collation references a derived below-Project slot; can't
        }
            };  
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),  
        static Expect scanCols(String... expectedNamesInOrder) {  
    /**
                if (node instanceof OpenSearchRelNode os) {  
    }
import org.opensearch.cluster.ClusterState;
                    if (!expected.equals(actual)) {  
        return out;  
        // After narrowing, scan = [EventDate, ___row_id] = 2 cols; wrapper output = [URL, EventDate].
                                + actual
                                    + "\nSQL: "
            "SELECT URL, EventDate FROM hits ORDER BY EventDate DESC LIMIT 10",
        // (refetched into the wrapper, v2 no-passthrough) — exercises the scan→wrapper rebase for a  
            Expect.erHasUgsi(true),
            cluster,
        PlannerContext context = new PlannerContext(new CapabilityRegistry(backends, FieldStorageResolver::new), state, false);  
        // SELECT URL, EventDate, CounterID FROM hits ORDER BY EventDate, CounterID LIMIT 10  
import org.opensearch.analytics.planner.rel.OpenSearchSort;  
     */
 *   <li>Wrapper output rowType = {@code AboveAnchorPhysicalFields}, in
                                + "\nPlan:\n"  
            Expect.wrapperOutput("URL", "EventDate", "CounterID"),
                        assertEquals(
                                    + sql
                + "  SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10"
                        fail(  
                    List<RelFieldCollation> fc = ctx.anchor.getCollation().getFieldCollations();  
        // BelowAnchorPhysicalFields = {CounterID, EventDate}  
                        fail(
                                + "\nSQL: "
        /** Scan rowType (post-narrowing) carries exactly these original cols + {@code ___row_id}. */
         * SELECT contract — aliases re-applied by the Project even though the wrapper output is
import org.apache.calcite.rex.RexInputRef;  
                        er.stripAnnotations(er.getInputs())
            Expect.scanCols("EventDate"),
            return new Expect() {
        // Title appears ONLY inside the expression — never selected alone, not a sort/filter col.  
                    }
        }
        if (ctx.wrapper == null) {
                        }  
 *   <li>Scan rowType narrowed to {@code BelowAnchorPhysicalFields + ___row_id}.</li>
            e.check(ctx, sql, planText);
        // Filter on EventDate is below-Filter (predicate pushdown), so EventDate stays in BelowAnchor.  
                                + "\nSQL: "  
            rexBuilder.makeInputRef(scan, 0),
    public void testQtfFires_compositeExpressionWithDedup() {
        for (RelDataTypeField f : fields)
                    os.getOutputFieldStorage();
        );
            return new Expect() {  
        OpenSearchExchangeReducer er;  
    public void testQtfFires_offset() {  
                                + sql
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),
            df
     *
            2,
    }  
    // ── Tests that decline QTF ─────────────────────────────────────────
                                + plan
    }
                        } else {  
        // SELECT URL, SUM(ParamPrice) OVER () FROM hits ORDER BY EventDate LIMIT 10  
            Expect.scanCols("EventDate"),
    public void testQtfFires_aboveChainHasPassthroughSort() {
                                + sql  
            Expect.collationDirections(RelFieldCollation.Direction.DESCENDING)
            };
         */
            Expect.aboveAnchorPhysicalFields("URL", "EventDate", "CounterID"),  
 * the structural post-conditions QTF must produce:  
        // ExchangeReducer (RANDOM → SINGLETON gather)  
        OpenSearchProject outerProject;
        OpenSearchSort sort = new OpenSearchSort(
        }  
            Expect.scanCols("CounterID", "EventDate"),  
                @Override
        // FetchOnly = {URL} → fire
                @Override
        // again and the reduce-fragment FSI walk throws. Assert each rebuilt ER keeps aligned FSI.  
 *   <li>Outer Project's RexInputRefs are remapped to wrapper-output indices.</li>
        assertQtfFired(  
    }
/*  
        // SELECT URL, EventDate FROM hits ORDER BY EventDate LIMIT 10  
                            "Outer Project output names mismatch.\n  expected: "
    public void testQtfFires_withWhere() {  
                @Override
        // SELECT URL, EventDate FROM hits WHERE EventDate > '2020-01-01' ORDER BY EventDate LIMIT 10
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),  
            physicalFsi("URL", "keyword", FieldType.KEYWORD)
    private RelNode optimize(String sql, int shardCount) {  
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),  
                                    + i
    public void testQtfFires_filterColAlsoProjected() {
        assertQtfFired(
                            actual[i] = ref.getIndex();
        // URL is BOTH the sort key (BelowAnchor → narrowed scan) AND an expression operand
import org.opensearch.analytics.planner.rel.OpenSearchTableScan;
                    }
            Expect.aboveAnchorPhysicalFields("URL", "EventDate"),  
    }  
            return new Expect() {  
        List<String> out = new ArrayList<>(fields.size());  
        assertQtfDeclined("SELECT CounterID FROM hits WHERE CounterID = 5 ORDER BY EventDate LIMIT 10", 2);
                                "Anchor collation["
            public void visit(RelNode node, int ordinal, RelNode parent) {
                                + fc.size()  
        // Scan: [CounterID, EventDate, URL] all physical (datafusion-backed), matching the IT.
import org.opensearch.analytics.spi.FieldType;
            Expect.outerProjectNames("combined", "upper_url")  
 */  
            Expect.erHasUgsi(true),
    }
 * Plan-shape tests for the QTF (late-materialization) post-CBO rewriter, v2.  
                                + "\n  actual:   "
        // collapses to AboveAnchorPhysicalFields = [URL].
         */
                                    + fc.get(i).getDirection()  
                }  
            Expect.wrapperOutput("URL", "EventDate"),
     * passthrough Sort. {@code assertQtfFired} catches such an exception on the planner call.  
                            c.getRowType().getFieldCount(),
            Expect.scanCols("EventDate"),
            2,
        );  
    public void testQtfDeclined_singleShard() {  
import org.opensearch.analytics.planner.rel.OpenSearchExchangeReducer;
        assertQtfFired(
        );
import org.opensearch.analytics.planner.rel.OpenSearchProject;
import org.apache.calcite.sql.type.SqlTypeName;  
                                + sql
 * The OpenSearch Contributors require contributions made to  
            }
            Expect.wrapperOutput("Title"),
            Expect.scanCols("EventDate"),
            return new Expect() {  
        );  
            "SELECT UPPER(Title) AS tup FROM hits ORDER BY EventDate LIMIT 10",  
                        );  
        assertQtfFired(  
        assertQtfFired(
                        er.copy(er.getTraitSet(), er.getInputs()),  
        assertQtfFired(
        );  
            };
                                + "\nSQL: "  
        }
            out.add(f.getName());
import org.apache.calcite.plan.RelOptUtil;
                                    + " actual="
        assertQtfFired(
                }
        );  
 * {@code AboveAnchorPhysicalFields - BelowAnchorPhysicalFields} is non-empty.
        OpenSearchLateMaterialization wrapper;  
    private RelNode optimize(String sql, int shardCount, List<AnalyticsSearchBackendPlugin> backends) {
                        fail(  
                void check(Inspector ctx, String sql, String plan) {  
                    }
            "SELECT URL || '-' || Title AS combined FROM hits ORDER BY EventDate LIMIT 10",  
         * Outer Project (immediately above wrapper) output field names, in order. Asserts the
        }
