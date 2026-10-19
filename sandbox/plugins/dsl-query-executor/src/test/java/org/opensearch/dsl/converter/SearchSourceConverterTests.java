                new TermsAggregationBuilder("by_brand").field("brand")  
            .filter(p -> p.relNode().getRowType().getFieldNames().contains(column))
                // Nullable fields — matches OpenSearchSchemaBuilder behavior
        assertFalse(plans.has(QueryPlans.Type.AGGREGATION));
        terms.includeExclude(new org.opensearch.search.aggregations.bucket.terms.IncludeExclude("Brand.*", null));
        QueryPlans plans = converter.convert(source, "test-index");
        assertFalse(plans.has(QueryPlans.Type.AGGREGATION));  
import org.apache.calcite.rel.logical.LogicalTableScan;
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    );
        assertTrue(plans.has(QueryPlans.Type.HITS));
        // no eligible counts needed and totals explicitly not tracked → nothing to count
import java.util.List;
        schema.add("test-index", new AbstractTable() {
        });
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(registry, DeprecationHandler.IGNORE_DEPRECATIONS, json)) {  
        List<String> columns = plans.get(QueryPlans.Type.COUNT).get(0).relNode().getRowType().getFieldNames();
        QueryPlans plans = converter.convert(source, "test-index");  
        String plan = plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode().explain();
        QueryPlans plans = converter.convert(source, "test-index");  
        }
     * Adding a new test case only requires adding a new JSON file — no new
        assertEquals(
                    failures.add(  
                String actualPlan = relNode.explain().trim();  
import org.opensearch.dsl.golden.GoldenTestCase;  
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").minDocCount(5).missing("N/A"));
        converter = new SearchSourceConverter(schema);
        assertTrue("eligible count must carry the missing substitution: " + plan, plan.contains("CASE(IS NOT NULL($2)"));  
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).aggregation(new TermsAggregationBuilder("by_brand").field("brand"));
        List<QueryPlans.QueryPlan> countPlans = plans.get(QueryPlans.Type.COUNT);
        // The child's own bound is the window rank, not a flat LIMIT: its size (3) must never
        assertTrue("eligible count must be HAVING-filtered: " + plan, plan.contains(">=($1, 5)"));
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").missing("unknown"));
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").minDocCount(5));
        // missing + min_doc_count together: substitution makes every matching doc form a group,  
        assertTrue("rank filter must keep the per-parent top K: " + childPlan, childPlan.contains("<=($"));  
                    failures.add(fileName + ": No " + expectedType + " plan produced");
    public void testMetricOnlyAggPlanHasNoPostAggSort() throws ConversionException {
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;  
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
    public void testSameFieldSiblingsProduceTwoBoundedPlans() throws ConversionException {  
        // missing substitution makes every matching doc eligible — COUNT(*) is the eligible count  
 * SPDX-License-Identifier: Apache-2.0
            public RelDataType getRowType(RelDataTypeFactory typeFactory) {
import org.apache.calcite.schema.SchemaPlus;
            .findFirst()
    }
        QueryPlans plans = converter.convert(source, "test-index");
        // the HAVING-filtered SUM, not COUNT(*) (which would count dropped groups' docs).
}
        QueryPlans.QueryPlan eligibleCountPlan = countPlanWithColumn(countPlans, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand");
            .aggregation(
        // flat plan: hits.total only — the eligible count must not ride COUNT(*)
    }
        // Even a default request carries fetch=size (10) so the limit pushes down to the engine.
import java.util.Map;  
        SearchSourceBuilder source = new SearchSourceBuilder().size(0);
            .aggregation(
            .aggregation(new TermsAggregationBuilder("top_brands").field("brand"))
                        fileName + ": Field names mismatch\n  Expected: " + tc.getMockResultFieldNames() + "\n  Actual:   " + actualFields
    public void testMissingWithMinDocCountGetsOwnEligibleCountPlan() throws ConversionException {
    }
        if (!failures.isEmpty()) {  
        List<Path> goldenFiles;
        List<QueryPlans.QueryPlan> countPlans = plans.get(QueryPlans.Type.COUNT);  
    // ---- Golden file driven RelNode generation tests ----
        // size=0 with no aggs is the count-only query: hits.total comes from the COUNT plan  
        assertFalse("No golden files found", goldenFiles.isEmpty());  
            goldenFiles = stream.filter(p -> p.toString().endsWith(".json")).collect(Collectors.toList());
        super.setUp();  
        List<QueryPlans.QueryPlan> aggPlans = plans.get(QueryPlans.Type.AGGREGATION);  
    }
        );
     * produces the expected RelNode plan via SearchSourceConverter.convert().  
    }
import org.apache.calcite.sql.type.SqlTypeName;  
    public void testConvertProducesHitsPlan() throws ConversionException {
        // bounded per parent, ordered by the child's bucket order inside the window
 * this file be licensed under the Apache-2.0 license or a
                    failures.add(fileName + ": RelNode plan mismatch\n  Expected: " + expectedPlan + "\n  Actual:   " + actualPlan);
        // restricted to the parent plan's winners
        assertTrue("parent is a flat top-N: " + parentPlan, parentPlan.contains("fetch=[2]"));
import org.apache.calcite.jdbc.CalciteSchema;
        assertEquals(  
        QueryPlans plans = converter.convert(source, "test-index");
    public void testConvertResolvesFieldNames() throws ConversionException {  
        // but the threshold still drops whole groups from eligibility — the eligible count must be
    public void testTermsSizeBecomesFetchOnAggregationSort() throws ConversionException {  
        assertEquals(3, plans.getAll().size());
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).aggregation(terms);
import org.apache.calcite.rel.logical.LogicalSort;  
    }
        SchemaPlus schema = CalciteSchema.createRootSchema(true).plus();
        SearchSourceBuilder source = new SearchSourceBuilder().size(10).aggregation(new AvgAggregationBuilder("avg_price").field("price"));
    }  
        }
    }
        try (var stream = Files.list(Path.of(goldenDir.toURI()))) {  
        QueryPlans plans = converter.convert(source, "test-index");
            @Override  
import java.util.ArrayList;  
        SearchSourceBuilder source = new SearchSourceBuilder().trackTotalHits(false);  
        }
     */  
    }  
        String parentPlan = aggPlans.get(0).relNode().explain();  
import org.opensearch.dsl.executor.QueryPlans;  
    public void testAggsWithSizeZeroProducesAggregationAndCountPlans() throws ConversionException {  
            builder.map(inputDsl);  
        // hits plan plus the COUNT plan that supplies hits.total
        // plan — the parent top-N subtree is the semi-join input.)  
        assertEquals(2, aggPlans.size());
                String expectedPlan = String.join("\n", tc.getExpectedRelNodePlan());
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.test.OpenSearchTestCase;  
        // and the LIMIT rides the sort above it (filter-before-truncate)  
        assertFalse("missing fields keep their null keys: " + plan, plan.contains("LogicalFilter(condition=[IS NOT NULL($2)])"));  
        assertEquals(List.of(QueryPlans.COUNT_TOTAL_COLUMN), flat.relNode().getRowType().getFieldNames());
                return typeFactory.builder()  
            }  
    }
    // ---- Top-K pushdown plan shapes ----
        assertEquals(List.of(QueryPlans.COUNT_TOTAL_COLUMN), flat.relNode().getRowType().getFieldNames());
        // one eligible-count column per sibling, keyed by aggregation name
            new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents()
        );  
    }  
        assertTrue("min_doc_count must become a HAVING filter: " + plan, plan.contains(">=($1, 5)"));
        for (Path file : goldenFiles) {  
                if (!tc.getMockResultFieldNames().equals(actualFields)) {
        assertTrue("per-parent eligible total must ride the rows: " + childPlan, childPlan.contains("SUM($"));
                failures.add(fileName + ": " + e.getClass().getSimpleName() + " - " + e.getMessage());
        QueryPlans.QueryPlan plan = plans.get(QueryPlans.Type.HITS).get(0);  
        assertEquals(List.of("name", "price", "brand", "rating"), plan.relNode().getRowType().getFieldNames());
    }  
package org.opensearch.dsl.converter;
    }
            .aggregation(new TermsAggregationBuilder("brands_by_key").field("brand").order(BucketOrder.key(true)));  
        QueryPlans plans = converter.convert(source, "test-index");
        try (var builder = JsonXContent.contentBuilder()) {
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)  
import org.opensearch.dsl.golden.CalciteTestInfra;
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").minDocCount(5));
    }  
        assertEquals(9, DslTypeSystems.NANO_TIMESTAMP.getMaxPrecision(SqlTypeName.TIMESTAMP));  
            assertTrue("each sibling's plan is bounded: " + plan.relNode().explain(), plan.relNode().explain().contains("fetch=[10]"));  
    }  
        QueryPlans plans = converter.convert(source, "test-index");
        QueryPlans plans = converter.convert(source, "test-index");  
    public void testUnsupportedTermsParameterRejectedEndToEnd() {
            fail("Golden file RelNode generation failures:\n" + String.join("\n", failures));
            "child schema carries the parent-eligible column",
    public void testCountPlanWithMissingCarriesOnlyTotal() throws ConversionException {
        QueryPlans plans = converter.convert(new SearchSourceBuilder(), "test-index");
        String plan = plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode().explain();
        QueryPlans.QueryPlan flat = countPlanWithColumn(countPlans, QueryPlans.COUNT_TOTAL_COLUMN);  
        assertTrue(plans.has(QueryPlans.Type.AGGREGATION));  
        QueryPlans.QueryPlan eligibleCountPlan = countPlanWithColumn(countPlans, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand");
                if (matchingPlans.isEmpty()) {  
import org.opensearch.common.xcontent.json.JsonXContent;
        assertTrue(plans.has(QueryPlans.Type.COUNT));
    public void setUp() throws Exception {
        QueryPlans plans = converter.convert(source, "test-index");
     * Auto-discovers all golden JSON files and validates that each inputDsl
                GoldenTestCase tc = GoldenFileLoader.load(fileName);  
        // post-agg schema is [brand, _count] — the HAVING filter references _count at $1,
                    .add("rating", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.DOUBLE), true))
        assertTrue(plans.has(QueryPlans.Type.HITS));
        assertTrue("eligible count must sum the surviving group counts: " + plan, plan.contains("SUM($1)"));
                RelNode relNode = matchingPlans.get(0).relNode();
        assertEquals(2, plans.getAll().size());
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").size(7));
                QueryPlans.Type expectedType = QueryPlans.Type.valueOf(tc.getPlanType());
        expectThrows(IllegalArgumentException.class, () -> converter.convert(new SearchSourceBuilder(), "nonexistent-index"));  
    public void testTrackTotalHitsDisabledSkipsCountPlan() throws ConversionException {
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)  
            String fileName = file.getFileName().toString();
        assertTrue(plans.has(QueryPlans.Type.HITS));  
        assertFalse(plans.has(QueryPlans.Type.HITS));
        // dedicated plan: SUM over the HAVING-filtered per-group counts  
    public void testAggPlanIncludesPostAggSort() throws ConversionException {
        assertEquals(1, plans.getAll().size());  
            child.relNode().getRowType().getFieldNames().contains("_parent_eligible")
        URL goldenDir = getClass().getClassLoader().getResource("golden");
    }  
        assertTrue(plans.has(QueryPlans.Type.COUNT));
                QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "top_brands",
    public void testTermsDefaultNullExclusionBecomesPreAggFilter() throws ConversionException {  
        assertTrue(  
        String json;
            json = builder.toString();
    public void testSizeZeroNoAggsProducesOnlyCountPlan() throws ConversionException {
import org.apache.calcite.rel.type.RelDataType;
        assertFalse(plans.has(QueryPlans.Type.HITS));
    public void testAggsWithSizeGreaterThanZeroProducesAllPlans() throws ConversionException {
        String plan = eligibleCountPlan.relNode().explain();
        assertTrue("null keys must be excluded below the aggregate: " + plan, plan.contains("LogicalFilter(condition=[IS NOT NULL($2)])"));  
                    .subAggregation(new AvgAggregationBuilder("avg_price").field("price"))
            List.of(QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand"),  
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)  
    private static QueryPlans.QueryPlan countPlanWithColumn(List<QueryPlans.QueryPlan> countPlans, String column) {
        String childPlan = child.relNode().explain();
/*  
import org.apache.calcite.rel.type.RelDataTypeFactory;  
            } catch (Exception e) {
                List<String> actualFields = relNode.getRowType().getFieldNames();
        // Metric-only agg has no bucket orders, so no LogicalSort wrapper  
                new TermsAggregationBuilder("by_brand").field("brand")
    /** Finds the COUNT plan carrying the given output column — plan order is not part of the contract. */
        assertTrue("child must semi-join the parent plan: " + childPlan, childPlan.contains("joinType=[semi]"));  
import org.opensearch.search.SearchModule;
            eligibleCountPlan.relNode().getRowType().getFieldNames()
    public void testConvertThrowsForMissingIndex() {
            ),  
        assertEquals(
        NamedXContentRegistry registry = new NamedXContentRegistry(  
        assertTrue(plans.has(QueryPlans.Type.AGGREGATION));
        QueryPlans plans = converter.convert(source, "test-index");  
        assertEquals(1, plans.getAll().size());
            );
            );  
    }  
                List<QueryPlans.QueryPlan> matchingPlans = plans.get(expectedType);
    }  
    public void testMinDocCountBecomesHavingWithFetch() throws ConversionException {  
 *
    public void testNestedTermsPlanIsBoundedPerParent() throws ConversionException {  
                    .subAggregation(new TermsAggregationBuilder("by_name").field("name").size(3))
import java.util.stream.Collectors;
        assertTrue(plans.has(QueryPlans.Type.AGGREGATION));
        assertEquals(List.of(QueryPlans.COUNT_TOTAL_COLUMN), columns);  
 */  
        assertTrue(plans.has(QueryPlans.Type.AGGREGATION));
import org.opensearch.search.aggregations.BucketOrder;
    }  
            }  
import org.apache.calcite.rel.RelNode;
     * Java method needed.
        List<String> countColumns = plans.get(QueryPlans.Type.COUNT).get(0).relNode().getRowType().getFieldNames();  
                QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "brands_by_key"
        assertEquals(2, plans.getAll().size());  
    }  
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).aggregation(new AvgAggregationBuilder("avg_price").field("price"));
        ConversionException e = expectThrows(ConversionException.class, () -> converter.convert(source, "test-index"));
                }  
        assertTrue("eligible count must sum the surviving group counts: " + plan, plan.contains("SUM($1)"));
        assertEquals(2, countPlans.size());
        assertEquals(2, countPlans.size());
        for (QueryPlans.QueryPlan plan : aggPlans) {
        // flat plan: hits.total only — the eligible count moved to the dedicated plan  
        assertTrue("sort must carry the fetch: " + plan, plan.contains("fetch=[7]"));  
import org.opensearch.common.settings.Settings;
        QueryPlans plans = converter.convert(source, "test-index");
        assertFalse(plans.has(QueryPlans.Type.COUNT));
    }
import org.apache.calcite.schema.impl.AbstractTable;
        assertTrue(sort.getInput() instanceof LogicalTableScan);  
                    .add("brand", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true))  
        QueryPlans plans = converter.convert(source, "test-index");  
        assertNotNull(sort.fetch);
        );
        assertTrue(plan.relNode() instanceof LogicalSort);  
import java.util.Collections;
        );
        QueryPlans.QueryPlan child = aggPlans.get(1);  
        QueryPlans.QueryPlan plan = plans.get(QueryPlans.Type.HITS).get(0);
        List<String> columns = plans.get(QueryPlans.Type.COUNT).get(0).relNode().getRowType().getFieldNames();
        QueryPlans plans = converter.convert(source, "test-index");
    public void testCountPlanCarriesTotalAndEligibleColumns() throws ConversionException {  
                }
        assertEquals(List.of(QueryPlans.COUNT_TOTAL_COLUMN, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand"), columns);
        // appear as a fetch. (The parent's fetch=[2] legitimately appears inside the child
        // cannot see — the aggregation gets its own HAVING-filtered SUM plan.
        assertTrue(plans.has(QueryPlans.Type.COUNT));
import org.opensearch.core.xcontent.DeprecationHandler;  
            .aggregation(new TermsAggregationBuilder("by_brand").field("brand").missing("unknown"));
        String plan = eligibleCountPlan.relNode().explain();  
                    .build();
    public void testMinDocCountGetsOwnEligibleCountPlan() throws ConversionException {  
        List<String> failures = new ArrayList<>();
import org.opensearch.dsl.golden.GoldenFileLoader;
        QueryPlans plans = converter.convert(new SearchSourceBuilder(), "test-index");  
import java.nio.file.Files;
        assertTrue(plans.has(QueryPlans.Type.COUNT));
public class SearchSourceConverterTests extends OpenSearchTestCase {  
            .orElseThrow(() -> new AssertionError("no COUNT plan with column [" + column + "]"));  
 * compatible open source license.
        assertTrue(plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode() instanceof LogicalSort);
        QueryPlans plans = converter.convert(source, "test-index");  
        assertFalse(plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode() instanceof LogicalSort);
                if (!expectedPlan.equals(actualPlan)) {  
        List<QueryPlans.QueryPlan> aggPlans = plans.get(QueryPlans.Type.AGGREGATION);  
        // The eligible count must exclude below-threshold groups, which COUNT(field)
                CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping(tc.getIndexName(), tc.getIndexMapping());
        QueryPlans plans = converter.convert(source, "test-index");
    @Override
        assertEquals(4, plan.relNode().getRowType().getFieldCount());
    }
import java.io.IOException;
        QueryPlans plans = converter.convert(new SearchSourceBuilder(), "test-index");  
                SearchSourceConverter conv = new SearchSourceConverter(infra.schema());
    }
        assertTrue(plans.has(QueryPlans.Type.COUNT));
            List.of(
    }  
            eligibleCountPlan.relNode().getRowType().getFieldNames()
import org.opensearch.search.aggregations.metrics.AvgAggregationBuilder;
        assertTrue("the plan stays bounded: " + plan, plan.contains("fetch=[10]"));  
    public void testNanoTimestampTypeSystemReportsMaxPrecisionNine() {
        assertTrue("missing must substitute via CASE: " + plan, plan.contains("CASE(IS NOT NULL($2)"));
import org.opensearch.core.xcontent.XContentParser;
        }
                    .add("name", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.VARCHAR), true))
        assertEquals(2, aggPlans.size());
        // brand is column 2 in the test schema
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
        LogicalSort sort = (LogicalSort) plan.relNode();
        String plan = plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode().explain();
    public void testGoldenFileRelNodeGeneration() throws Exception {
    public void testMissingBecomesCaseProjectionWithoutNullFilter() throws ConversionException {
                    .add("price", typeFactory.createTypeWithNullability(typeFactory.createSqlType(SqlTypeName.INTEGER), true))
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
                    continue;
            List.of(QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand"),
                QueryPlans plans = conv.convert(searchSource, tc.getIndexName());
    }
        // the eligible count rides the rows
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).aggregation(new TermsAggregationBuilder("by_brand").field("brand"));
        assertTrue(e.getMessage().contains("include"));
                SearchSourceBuilder searchSource = parseSearchSource(tc.getInputDsl());  
        // Aggregation plan should be wrapped with LogicalSort for bucket order  
        assertTrue("eligible count must be HAVING-filtered: " + plan, plan.contains(">=($1, 5)"));
            try {
        QueryPlans.QueryPlan flat = countPlanWithColumn(countPlans, QueryPlans.COUNT_TOTAL_COLUMN);
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
            return SearchSourceBuilder.fromXContent(parser);
            countColumns
                    .size(2)
        assertTrue(plans.has(QueryPlans.Type.HITS));  
        assertEquals(2, plans.getAll().size());
        }
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).aggregation(new AvgAggregationBuilder("avg_price").field("price"));
        assertFalse("child size must not be a flat fetch: " + childPlan, childPlan.contains("fetch=[3]"));
        );  
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)  
    public void testNoAggsProducesHitsAndCountPlans() throws ConversionException {
        TermsAggregationBuilder terms = new TermsAggregationBuilder("by_brand").field("brand");  
    }
    private SearchSourceConverter converter;
    /**
        assertNull(child.aggregationMetadata().getFetch());
import java.net.URL;  
                    .order(BucketOrder.key(true))  
        assertTrue("child must rank within the parent partition: " + childPlan, childPlan.contains("ROW_NUMBER() OVER (PARTITION BY"));
    private SearchSourceBuilder parseSearchSource(Map<String, Object> inputDsl) throws IOException {  
        assertNotNull("Golden file resource directory not found", goldenDir);  
                QueryPlans.COUNT_TOTAL_COLUMN,  
        return countPlans.stream()  
        String plan = plans.get(QueryPlans.Type.AGGREGATION).get(0).relNode().explain();
                }  
import java.nio.file.Path;
 * The OpenSearch Contributors require contributions made to  
