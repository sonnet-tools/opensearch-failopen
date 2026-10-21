        List<QueryPlans.QueryPlan> countPlans = plans.get(QueryPlans.Type.COUNT);
        assertFalse(plans.has(QueryPlans.Type.AGGREGATION));
        assertFalse(plans.has(QueryPlans.Type.HITS));
        // the HAVING-filtered SUM, not COUNT(*) (which would count dropped groups' docs).
            .aggregation(new TermsAggregationBuilder("top_brands").field("brand"))
import org.apache.calcite.rel.logical.LogicalSort;
    public void testNanoTimestampTypeSystemReportsMaxPrecisionNine() {
        // cannot see — the aggregation gets its own HAVING-filtered SUM plan.
                }
        List<Path> goldenFiles;
        assertEquals(
        });
     */
        assertTrue(
        assertTrue(plans.has(QueryPlans.Type.HITS));
        assertTrue("per-parent eligible total must ride the rows: " + childPlan, childPlan.contains("SUM($"));
        );
        assertEquals(List.of(QueryPlans.COUNT_TOTAL_COLUMN, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand"), columns);
    @Override
        assertEquals(List.of(QueryPlans.COUNT_TOTAL_COLUMN), columns);
import java.util.Collections;
        String json;
        String parentPlan = aggPlans.get(0).relNode().explain();
        assertFalse("No golden files found", goldenFiles.isEmpty());
        String plan = plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode().explain();
    public void testConvertThrowsForMissingIndex() {
        QueryPlans.QueryPlan flat = countPlanWithColumn(countPlans, QueryPlans.COUNT_TOTAL_COLUMN);
/*
                SearchSourceBuilder searchSource = parseSearchSource(tc.getInputDsl());
import org.apache.calcite.rel.RelNode;
            .aggregation(
    }
                SearchSourceConverter conv = new SearchSourceConverter(infra.schema());
                    .add("name", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true))
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
        QueryPlans plans = converter.convert(source, "test-index");
import java.io.IOException;
        assertNotNull(sort.fetch);
 * compatible open source license.
        QueryPlans plans = converter.convert(source, "test-index");
        super.setUp();
                new TermsAggregationBuilder("by_brand").field("brand")
                    .add("brand", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true))
            child.relNode().getRowType().getFieldNames().contains("_parent_eligible")
        // Metric-only agg has no bucket orders, so no LogicalSort wrapper
import org.apache.calcite.rel.logical.LogicalTableScan;
        QueryPlans plans = converter.convert(source, "test-index");
import java.util.List;
        // one eligible-count column per sibling, keyed by aggregation name
        assertEquals(2, countPlans.size());
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        String plan = eligibleCountPlan.relNode().explain();
        assertEquals(2, plans.getAll().size());
    public void setUp() throws Exception {
        // and the LIMIT rides the sort above it (filter-before-truncate)
    private SearchSourceConverter converter;
        assertTrue(plans.has(QueryPlans.Type.COUNT));
 */
        assertTrue("eligible count must be HAVING-filtered: " + plan, plan.contains(">=($1, 5)"));
        assertEquals(4, plan.relNode().getRowType().getFieldCount());
        return countPlans.stream()
    }
        assertEquals(List.of(QueryPlans.COUNT_TOTAL_COLUMN), flat.relNode().getRowType().getFieldNames());
            try {
    public void testConvertResolvesFieldNames() throws ConversionException {
        assertNull(child.aggregationMetadata().getFetch());
    public void testTermsDefaultNullExclusionBecomesPreAggFilter() throws ConversionException {
            goldenFiles = stream.filter(p -> p.toString().endsWith(".json")).collect(Collectors.toList());
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").minDocCount(5));
        TermsAggregationBuilder terms = new TermsAggregationBuilder("by_brand").field("brand");
    }
        assertTrue("child must rank within the parent partition: " + childPlan, childPlan.contains("ROW_NUMBER() OVER (PARTITION BY"));
        );
        // brand is column 2 in the test schema
                }
            List.of(
        // size=0 with no aggs is the count-only query: hits.total comes from the COUNT plan
        String plan = plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode().explain();
            eligibleCountPlan.relNode().getRowType().getFieldNames()
            }
            } catch (Exception e) {
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(registry, DeprecationHandler.IGNORE_DEPRECATIONS, json)) {
        assertTrue(plans.has(QueryPlans.Type.COUNT));
                QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "top_brands",
        assertTrue("eligible count must be HAVING-filtered: " + plan, plan.contains(">=($1, 5)"));
        QueryPlans plans = converter.convert(source, "test-index");
        // flat plan: hits.total only — the eligible count must not ride COUNT(*)
        SearchSourceBuilder source = new SearchSourceBuilder().size(0);
import org.apache.calcite.rel.type.RelDataTypeFactory;
        assertEquals(2, aggPlans.size());
        );
import java.util.stream.Collectors;
        assertFalse("child size must not be a flat fetch: " + childPlan, childPlan.contains("fetch=[3]"));
                    failures.add(fileName + ": RelNode plan mismatch\n  Expected: " + expectedPlan + "\n  Actual:   " + actualPlan);
import org.apache.calcite.schema.impl.AbstractTable;
import org.opensearch.test.OpenSearchTestCase;
        for (QueryPlans.QueryPlan plan : aggPlans) {
        URL goldenDir = getClass().getClassLoader().getResource("golden");
    public void testMinDocCountBecomesHavingWithFetch() throws ConversionException {
    }
                CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping(tc.getIndexName(), tc.getIndexMapping());
    public void testConvertProducesHitsPlan() throws ConversionException {
        QueryPlans.QueryPlan eligibleCountPlan = countPlanWithColumn(countPlans, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand");
        assertTrue(plans.has(QueryPlans.Type.COUNT));
        assertEquals(
        LogicalSort sort = (LogicalSort) plan.relNode();
     * Adding a new test case only requires adding a new JSON file — no new
                        fileName + ": Field names mismatch\n  Expected: " + tc.getMockResultFieldNames() + "\n  Actual:   " + actualFields
        QueryPlans plans = converter.convert(source, "test-index");
    public void testAggPlanIncludesPostAggSort() throws ConversionException {
    public void testMissingBecomesCaseProjectionWithoutNullFilter() throws ConversionException {
    }
        assertEquals(
        assertTrue("child must semi-join the parent plan: " + childPlan, childPlan.contains("joinType=[semi]"));
        String plan = plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode().explain();
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).aggregation(new TermsAggregationBuilder("by_brand").field("brand"));
        assertEquals(1, plans.getAll().size());
        assertEquals(1, plans.getAll().size());
import org.apache.calcite.jdbc.CalciteSchema;
import org.apache.calcite.rel.type.RelDataType;
        try (var stream = Files.list(Path.of(goldenDir.toURI()))) {
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").missing("unknown"));
import java.util.Map;
import org.opensearch.search.SearchModule;
    public void testUnsupportedTermsParameterRejectedEndToEnd() {
    }
        QueryPlans plans = converter.convert(new SearchSourceBuilder(), "test-index");
    }
            new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents()
                QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "brands_by_key"
import org.opensearch.search.builder.SearchSourceBuilder;
            .filter(p -> p.relNode().getRowType().getFieldNames().contains(column))
    }
        String plan = eligibleCountPlan.relNode().explain();
        assertFalse(plans.has(QueryPlans.Type.HITS));
            json = builder.toString();
import java.net.URL;
import org.opensearch.common.settings.Settings;
        String plan = plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode().explain();
        assertEquals(2, plans.getAll().size());
        }
        // the eligible count rides the rows
            .aggregation(new TermsAggregationBuilder("brands_by_key").field("brand").order(BucketOrder.key(true)));
        // appear as a fetch. (The parent's fetch=[2] legitimately appears inside the child
        NamedXContentRegistry registry = new NamedXContentRegistry(
 * SPDX-License-Identifier: Apache-2.0
        List<String> countColumns = plans.get(QueryPlans.Type.COUNT).get(0).relNode().getRowType().getFieldNames();
import org.apache.calcite.schema.SchemaPlus;
            public RelDataType getRowType(RelDataTypeFactory typeFactory) {
package org.opensearch.dsl.converter;
    private static QueryPlans.QueryPlan countPlanWithColumn(List<QueryPlans.QueryPlan> countPlans, String column) {
    public void testSameFieldSiblingsProduceTwoBoundedPlans() throws ConversionException {
                    failures.add(fileName + ": No " + expectedType + " plan produced");
     * Java method needed.
import java.nio.file.Path;
            .findFirst()
        assertTrue("sort must carry the fetch: " + plan, plan.contains("fetch=[7]"));
        // hits plan plus the COUNT plan that supplies hits.total
        assertTrue(plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode() instanceof LogicalSort);
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                    .add("price", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true))
        assertTrue(e.getMessage().contains("include"));
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
                // Nullable fields — matches OpenSearchSchemaBuilder behavior
     * produces the expected RelNode plan via SearchSourceConverter.convert().
        assertTrue(plans.has(QueryPlans.Type.COUNT));
    }
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
import org.opensearch.dsl.executor.QueryPlans;
        QueryPlans plans = converter.convert(source, "test-index");
            ),
import org.opensearch.common.xcontent.json.JsonXContent;
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
                    continue;
        converter = new SearchSourceConverter(schema);
        // Aggregation plan should be wrapped with LogicalSort for bucket order
    public void testAggsWithSizeZeroProducesAggregationAndCountPlans() throws ConversionException {
        QueryPlans plans = converter.convert(source, "test-index");
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        // bounded per parent, ordered by the child's bucket order inside the window
        List<String> columns = plans.get(QueryPlans.Type.COUNT).get(0).relNode().getRowType().getFieldNames();
        assertEquals(3, plans.getAll().size());
                new TermsAggregationBuilder("by_brand").field("brand")
        assertEquals(2, countPlans.size());
            List.of(QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand"),
        assertFalse("missing fields keep their null keys: " + plan, plan.contains("LogicalFilter(condition=[IS NOT NULL($2)])"));
    public void testNoAggsProducesHitsAndCountPlans() throws ConversionException {
        assertTrue("eligible count must sum the surviving group counts: " + plan, plan.contains("SUM($1)"));
    public void testAggsWithSizeGreaterThanZeroProducesAllPlans() throws ConversionException {
                if (!tc.getMockResultFieldNames().equals(actualFields)) {
        assertTrue(plan.relNode() instanceof LogicalSort);
        assertTrue(plans.has(QueryPlans.Type.AGGREGATION));
        List<QueryPlans.QueryPlan> aggPlans = plans.get(QueryPlans.Type.AGGREGATION);
        terms.includeExclude(new org.opensearch.search.aggregations.bucket.terms.IncludeExclude("Brand.*", null));
        assertTrue("rank filter must keep the per-parent top K: " + childPlan, childPlan.contains("<=($"));
    }
                return typeFactory.builder()
            eligibleCountPlan.relNode().getRowType().getFieldNames()
        // flat plan: hits.total only — the eligible count moved to the dedicated plan
    }
            assertTrue("each sibling's plan is bounded: " + plan.relNode().explain(), plan.relNode().explain().contains("fetch=[10]"));
    }
        List<String> failures = new ArrayList<>();
        assertNotNull("Golden file resource directory not found", goldenDir);
                RelNode relNode = matchingPlans.get(0).relNode();
        assertTrue(plans.has(QueryPlans.Type.AGGREGATION));
import org.opensearch.core.xcontent.XContentParser;
        QueryPlans plans = converter.convert(new SearchSourceBuilder(), "test-index");
        // missing substitution makes every matching doc eligible — COUNT(*) is the eligible count
        assertEquals(2, plans.getAll().size());
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
    public void testMetricOnlyAggPlanHasNoPostAggSort() throws ConversionException {
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
    public void testMinDocCountGetsOwnEligibleCountPlan() throws ConversionException {
                    .add("rating", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true))
        assertTrue(plans.has(QueryPlans.Type.COUNT));
    }
import org.opensearch.core.xcontent.DeprecationHandler;
    public void testSizeZeroNoAggsProducesOnlyCountPlan() throws ConversionException {
        assertTrue("eligible count must sum the surviving group counts: " + plan, plan.contains("SUM($1)"));
        QueryPlans.QueryPlan plan = plans.get(QueryPlans.Type.HITS).get(0);
            countColumns
        assertEquals(List.of(QueryPlans.COUNT_TOTAL_COLUMN), flat.relNode().getRowType().getFieldNames());
        );
    public void testNestedTermsPlanIsBoundedPerParent() throws ConversionException {
                QueryPlans.COUNT_TOTAL_COLUMN,
            );
import org.opensearch.dsl.golden.GoldenTestCase;
        List<String> columns = plans.get(QueryPlans.Type.COUNT).get(0).relNode().getRowType().getFieldNames();
        try (var builder = JsonXContent.contentBuilder()) {
 *
        ConversionException e = expectThrows(ConversionException.class, () -> converter.convert(source, "test-index"));
    }
            .orElseThrow(() -> new AssertionError("no COUNT plan with column [" + column + "]"));
    }
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).aggregation(new AvgAggregationBuilder("avg_price").field("price"));
        QueryPlans plans = converter.convert(new SearchSourceBuilder(), "test-index");
        QueryPlans plans = converter.convert(source, "test-index");
                QueryPlans.Type expectedType = QueryPlans.Type.valueOf(tc.getPlanType());
        for (Path file : goldenFiles) {
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
        schema.add("test-index", new AbstractTable() {
        assertTrue(plans.has(QueryPlans.Type.AGGREGATION));
    }
        // no eligible counts needed and totals explicitly not tracked → nothing to count
}
                if (!expectedPlan.equals(actualPlan)) {
        SearchSourceBuilder source = new SearchSourceBuilder().size(10).aggregation(new AvgAggregationBuilder("avg_price").field("price"));
        }
    public void testCountPlanCarriesTotalAndEligibleColumns() throws ConversionException {
        assertTrue("missing must substitute via CASE: " + plan, plan.contains("CASE(IS NOT NULL($2)"));
                    .size(2)
    /**
        }
                List<QueryPlans.QueryPlan> matchingPlans = plans.get(expectedType);
                    .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
    }
    private SearchSourceBuilder parseSearchSource(Map<String, Object> inputDsl) throws IOException {
    public void testGoldenFileRelNodeGeneration() throws Exception {
    }
            List.of(QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand"),
        // plan — the parent top-N subtree is the semi-join input.)
        assertTrue(plans.has(QueryPlans.Type.AGGREGATION));
    public void testTermsSizeBecomesFetchOnAggregationSort() throws ConversionException {
public class SearchSourceConverterTests extends OpenSearchTestCase {
        assertTrue(plans.has(QueryPlans.Type.HITS));
        QueryPlans plans = converter.convert(source, "test-index");
        assertTrue("eligible count must carry the missing substitution: " + plan, plan.contains("CASE(IS NOT NULL($2)"));
        assertTrue("parent is a flat top-N: " + parentPlan, parentPlan.contains("fetch=[2]"));
        List<QueryPlans.QueryPlan> countPlans = plans.get(QueryPlans.Type.COUNT);
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").minDocCount(5).missing("N/A"));
        QueryPlans.QueryPlan eligibleCountPlan = countPlanWithColumn(countPlans, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand");
    }
            String fileName = file.getFileName().toString();
        // Even a default request carries fetch=size (10) so the limit pushes down to the engine.
        QueryPlans plans = converter.convert(source, "test-index");
        QueryPlans.QueryPlan child = aggPlans.get(1);
        QueryPlans plans = converter.convert(source, "test-index");
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").missing("unknown"));
        if (!failures.isEmpty()) {
    public void testTrackTotalHitsDisabledSkipsCountPlan() throws ConversionException {
                List<String> actualFields = relNode.getRowType().getFieldNames();
                }
import java.util.ArrayList;
            builder.map(inputDsl);
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).aggregation(new AvgAggregationBuilder("avg_price").field("price"));
        expectThrows(IllegalArgumentException.class, () -> converter.convert(new SearchSourceBuilder(), "nonexistent-index"));
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
            @Override
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).aggregation(terms);
    }
     * Auto-discovers all golden JSON files and validates that each inputDsl
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").size(7));
        QueryPlans plans = converter.convert(source, "test-index");
        QueryPlans plans = converter.convert(source, "test-index");
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).aggregation(new TermsAggregationBuilder("by_brand").field("brand"));
                String actualPlan = relNode.explain().trim();
        assertEquals(2, aggPlans.size());
    // ---- Golden file driven RelNode generation tests ----
        );
        assertTrue("the plan stays bounded: " + plan, plan.contains("fetch=[10]"));
        assertTrue("min_doc_count must become a HAVING filter: " + plan, plan.contains(">=($1, 5)"));
import org.opensearch.dsl.golden.CalciteTestInfra;
        // missing + min_doc_count together: substitution makes every matching doc form a group,
    /** Finds the COUNT plan carrying the given output column — plan order is not part of the contract. */
            "child schema carries the parent-eligible column",
        // The eligible count must exclude below-threshold groups, which COUNT(field)
        QueryPlans plans = converter.convert(source, "test-index");
        }
        String childPlan = child.relNode().explain();
        assertTrue(sort.getInput() instanceof LogicalTableScan);
    public void testMissingWithMinDocCountGetsOwnEligibleCountPlan() throws ConversionException {
    }
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").minDocCount(5));
        assertTrue("null keys must be excluded below the aggregate: " + plan, plan.contains("LogicalFilter(condition=[IS NOT NULL($2)])"));
        // but the threshold still drops whole groups from eligibility — the eligible count must be
        // restricted to the parent plan's winners
        assertFalse(plans.has(QueryPlans.Type.COUNT));
            fail("Golden file RelNode generation failures:\n" + String.join("\n", failures));
                if (matchingPlans.isEmpty()) {
        QueryPlans plans = converter.convert(source, "test-index");
        SearchSourceBuilder source = new SearchSourceBuilder().trackTotalHits(false);
                    .order(BucketOrder.key(true))
    public void testCountPlanWithMissingCarriesOnlyTotal() throws ConversionException {
                    failures.add(
        }
        // post-agg schema is [brand, _count] — the HAVING filter references _count at $1,
        assertEquals(9, DslTypeSystems.NANO_TIMESTAMP.getMaxPrecision(SqlTypeName.TIMESTAMP));
            );
        // dedicated plan: SUM over the HAVING-filtered per-group counts
        }
    // ---- Top-K pushdown plan shapes ----
                QueryPlans plans = conv.convert(searchSource, tc.getIndexName());
            .aggregation(
import org.opensearch.dsl.golden.GoldenFileLoader;
 * this file be licensed under the Apache-2.0 license or a
    }
        QueryPlans plans = converter.convert(source, "test-index");
                failures.add(fileName + ": " + e.getClass().getSimpleName() + " - " + e.getMessage());
        assertFalse(plans.has(QueryPlans.Type.AGGREGATION));
        assertTrue(plans.has(QueryPlans.Type.HITS));
                    .subAggregation(new TermsAggregationBuilder("by_name").field("name").size(3))
        assertEquals(List.of("name", "price", "brand", "rating"), plan.relNode().getRowType().getFieldNames());
        QueryPlans.QueryPlan flat = countPlanWithColumn(countPlans, QueryPlans.COUNT_TOTAL_COLUMN);
        assertFalse(plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode() instanceof LogicalSort);
            }
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
        QueryPlans.QueryPlan plan = plans.get(QueryPlans.Type.HITS).get(0);
        assertTrue(plans.has(QueryPlans.Type.HITS));
import org.apache.calcite.sql.type.SqlTypeName;
    }
                GoldenTestCase tc = GoldenFileLoader.load(fileName);
            return SearchSourceBuilder.fromXContent(parser);
    }
 * The OpenSearch Contributors require contributions made to
    }
                    .build();
import java.nio.file.Files;
                String expectedPlan = String.join("\n", tc.getExpectedRelNodePlan());
        List<QueryPlans.QueryPlan> aggPlans = plans.get(QueryPlans.Type.AGGREGATION);
import org.opensearch.search.aggregations.BucketOrder;
        // The child's own bound is the window rank, not a flat LIMIT: its size (3) must never
                    );
