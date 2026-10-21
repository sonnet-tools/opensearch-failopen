        mapping.put("price", "INTEGER");
import org.opensearch.dsl.golden.TestMapperServices;
        SearchResponse response2 = SearchResponseBuilder.build(List.of(), request, registry, 999L);
                    .subAggregation(
     * aggregations, through the full plan/response round trip.
            // the engine honors the LIMIT: only the top bucket comes back
     */
    /** Recursively sorts aggregation bucket lists by key for order-insensitive comparison. */
                        AggregationBuilders.terms("by_category")
        assertEquals(850.0, avg.getValue(), 0.0);
                                    normalizeBucketsRecursive(Map.of(bucketEntry.getKey(), subAgg));
                if ("brand".equals(fields.get(i))) {
        InternalSum sumCat1 = byBrandCat1.getBuckets().get(0).getAggregations().get("sum_price");
        addCountResult(
        assertEquals(4, aggPlans.size());
        }
                // Deep copy expected to avoid mutating GoldenTestCase
        Object aggs = map.get("aggregations");
        assertNotNull("Golden file resource directory not found", goldenDir);
        SearchRequest request = new SearchRequest();
    /**
                results.add(
        InternalSum sumCat2 = byBrandCat2.getBuckets().get(0).getAggregations().get("sum_price");
        AggregationRegistry registry = new AggregationRegistry();
     * the request's nesting order (schema declares category before brand; request nests
        }
                failures.add(fileName + ": " + e.getClass().getSimpleName() + " - " + e.getMessage());
        }
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 10L);
import org.opensearch.dsl.golden.CalciteTestInfra;
        // Results computed for a metric named "other"
                // Build ExecutionResult from mock rows
                Map<String, Object> expectedOutput = XContentHelper.convertToMap(JsonXContent.jsonXContent, expectedJson, false);
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(registry, DeprecationHandler.IGNORE_DEPRECATIONS, json)) {
    }
        assertNull(response.getAggregations());
        mapping.put("price", "INTEGER");
                AggregationBuilders.terms("brand_first")
        AggregationRegistry registry = new AggregationRegistry();
                    new ExecutionResult(
        mapping.put("brand", "VARCHAR");
                assertEquals(List.of("brand", "category", "sum_price", "_count", "_parent_eligible"), fields);
    public void testEmptyHitsAlwaysReturned() throws Exception {
        request.source(source);
import org.opensearch.index.mapper.MapperService;
                SearchResponse response = SearchResponseBuilder.build(allResults, searchRequest, converter.getAggregationRegistry(), 0L);
        for (QueryPlans.QueryPlan plan : plans.get(QueryPlans.Type.AGGREGATION)) {
        }
                        AggregationBuilders.terms("by_category")
    }
        if (aggs instanceof Map) {
     * Regression: granularity keys must match even when the schema's column order opposes
                    String expectedPretty, actualPretty;
        );
     * (brand→category vs category→brand) produce two distinct plans and must resolve to two
        SearchRequest request = new SearchRequest("products");
        for (QueryPlans.QueryPlan plan : aggPlans) {
        List<QueryPlans.QueryPlan> aggPlans = plans.get(QueryPlans.Type.AGGREGATION);
        assertNotNull(response);
                    .field("brand")
        SearchRequest request = new SearchRequest("products");
                } else if ("_count".equals(fields.get(i))) {
            .aggregation(
import java.util.Collections;
            }
        }
    private SearchSourceBuilder parseSearchSource(Map<String, Object> inputDsl) throws IOException {
    private static void addCountResult(QueryPlans plans, List<ExecutionResult> results, Map<String, Object> countsByColumn) {
     * map does not provide.
        QueryPlans plans = converter.convert(source, "products");
            results.add(new ExecutionResult(plan, List.<Object[]>of(new Object[] { "BrandA", 3L })));
        addCountResult(plans, results, Map.of(QueryPlans.COUNT_TOTAL_COLUMN, total));
                                if (subAgg.containsKey("buckets")) {
                }
import org.opensearch.search.aggregations.metrics.InternalAvg;
                List<Object[]> rows = new ArrayList<>();
    public void testBuildWithEmptyRequest() throws Exception {
        NamedXContentRegistry registry = new NamedXContentRegistry(
        addCountResult(plans, results, Map.of(QueryPlans.COUNT_TOTAL_COLUMN, 5, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand", 5));
            .aggregation(
        for (Path file : goldenFiles) {
        assertEquals(1, response.getTotalShards());
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 42L);
     * ({@code eligible − Σ rendered}), since the tail never leaves the engine.
        assertEquals(25_000L, response.getHits().getTotalHits().value());
    public void testHitsTotalLowerBoundOverDefaultThreshold() throws Exception {
     * Terms {@code size} is enforced by the plan's LIMIT — the engine returns only the top
import org.opensearch.search.aggregations.metrics.InternalSum;
                        }
        List<ExecutionResult> results = new ArrayList<>();
                assertEquals(List.of("category", "_count"), fields);
    // ---- hits.total: classic track_total_hits semantics from the COUNT plan ----
    public void testReversedNestingSiblingTreesDoNotCollide() throws Exception {
                } else if ("avg_price".equals(fields.get(i))) {
        List<QueryPlans.QueryPlan> aggPlans = plans.get(QueryPlans.Type.AGGREGATION);
    private void normalizeBucketsRecursive(Map<String, Object> aggMap) {
import java.util.stream.Collectors;
        assertEquals(avgMeta, avg.getMetadata());
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 100L);
        assertEquals(700.0, sumCat2.getValue(), 0.0);
        request.source(source);
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema(), TestMapperServices.fromSqlMapping(mapping));
        assertNotNull(response.getHits().getTotalHits());
        SearchResponse response1 = SearchResponseBuilder.build(List.of(), request, registry, 0L);
    /**
        assertNotNull("by_category must be present inside the brand bucket", byCategory);
        assertEquals(TotalHits.Relation.EQUAL_TO, response.getHits().getTotalHits().relation());
                3,
                QueryPlans.COUNT_TOTAL_COLUMN,
            }
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema(), mappers);
        request.source(source);
                        List.of(new Object[] { "Cat1", "BrandA", 850.0, 2L, 5L }, new Object[] { "Cat2", "BrandA", 700.0, 1L, 5L })
        for (QueryPlans.QueryPlan plan : plans.get(QueryPlans.Type.AGGREGATION)) {
    @SuppressWarnings("unchecked")
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).trackTotalHits(false);
        }
                // cat_first tree: the parent is category, so each row carries its category's total
            () -> SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L)
        mapping.put("brand", "VARCHAR");
        SearchResponse response = SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L);
    }
        URL goldenDir = getClass().getClassLoader().getResource("golden");
            .aggregation(
        assertEquals(2, catFirst.getBuckets().size());
        assertEquals("brand_first's metric must not be lost to the sibling tree", 850.0, avgCat1.getValue(), 0.0);
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
     */
        assertEquals("BrandA", byBrand.getBuckets().get(0).getKeyAsString());
        SearchResponse response = countOnlyResponse(new SearchSourceBuilder().size(0), 25_000L);
                // Both deep plans group by {brand, category} and emit columns in schema order —
        for (QueryPlans.QueryPlan plan : plans.get(QueryPlans.Type.COUNT)) {
                }
        if (!failures.isEmpty()) {
     * first's, and the losing tree's metric came back empty ({@code "value": null}) beneath
        }
 * this file be licensed under the Apache-2.0 license or a
        request.source(source);
                            if (bucketEntry.getValue() instanceof Map) {
    private SearchResponse countOnlyResponse(SearchSourceBuilder source, long total) throws Exception {
                }
                        plan,
                    failures.add(fileName + ": SearchResponse mismatch\n  Expected: " + expectedPretty + "\n  Actual:   " + actualPretty);
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
            normalizeBucketsRecursive((Map<String, Object>) aggs);
        assertNull(response.getAggregations());
        SearchRequest request = new SearchRequest();
        SearchResponse response = SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L);
        try (var stream = Files.list(Path.of(goldenDir.toURI()))) {
    public void testNestedGroupFieldsWithOpposingSchemaOrder() throws Exception {
        request.source(source);
                    }
                results.add(
        StringTerms byCategory = byBrand.getBuckets().get(0).getAggregations().get("by_category");
        // per-parent eligible total 5 vs 3 rendered docs → 2 in truncated child groups
                row[i] = value instanceof Number n ? n.longValue() : value;
                    row[i] = 850.0;
                QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "brand_first",
            new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents()
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
                );
        mapping.put("brand", "VARCHAR");
        }
    public void testMissingMetricColumnThrows() throws Exception {
                assertNotNull("count fabrication missing column: " + fields.get(i), value);
        SearchResponse response = SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L);
                    failures.add(fileName + ": No " + expectedType + " plan produced");
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 10L);
        assertEquals(1, response.getSuccessfulShards());
                }
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema());
            Map.of(
        request.source(new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.avg("avg_price").field("price")));
            Object value = entry.getValue();
            Object[] row = new Object[fields.size()];
import java.net.URL;
        assertEquals(1, brandFirst.getBuckets().size());
        assertEquals(0L, response1.getTook().millis());
package org.opensearch.dsl.result;
        SearchRequest request = new SearchRequest("products");
        assertNotNull(response);
        assertEquals(1, byBrand.getBuckets().size());
            }
        responseMap.remove("took");
        assertEquals(2, byCategory.getBuckets().size());
    }
import java.nio.file.Path;
                    rows.add(row.toArray());
                            .field("category")
 *
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
    public void testBuildWithAggregationsButNoResults() throws Exception {
        List<ExecutionResult> results = new ArrayList<>();
                        actualPretty = b.toString();
        StringTerms byCategory = brandFirst.getBuckets().get(0).getAggregations().get("by_category");
                QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "cat_first",
                } else {
     */
                        for (Map.Entry<String, Object> bucketEntry : bucket.entrySet()) {
        // cat_first → Cat1 → by_brand → BrandA (sum 1700); Cat2 → by_brand → BrandA (sum 700)
        assertEquals(3L, byBrand.getBuckets().get(0).getDocCount());
            List<String> fields = plan.relNode().getRowType().getFieldNames();
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 50L);
/*
        assertEquals(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO, response.getHits().getTotalHits().relation());
                if ("AGGREGATION".equals(tc.getPlanType())) {
                            .field("category")
     * plans collapsed onto one map slot: the second plan's result silently overwrote the
        source.aggregation(AggregationBuilders.avg("avg_price").field("price"));
        }
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
            } else if (fields.contains("sum_price")) {
            if (fields.contains("avg_price")) {
        List<ExecutionResult> results = new ArrayList<>();
            if (value instanceof Map) {
        AggregationRegistry registry = new AggregationRegistry();
     * Fabricates the COUNT plan's single-row result from a columnName→value map, mirroring
        assertFalse("No golden files found", goldenFiles.isEmpty());
        assertEquals(700.0, avgCat2.getValue(), 0.0);
                // Build and serialize SearchResponse
        StringTerms byBrandCat1 = catFirst.getBuckets().get(0).getAggregations().get("by_brand");
import java.util.Comparator;
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema());
            for (int i = 0; i < fields.size(); i++) {
                String expectedJson;
                                }
            } else {
import java.util.List;
        AggregationRegistry registry = new AggregationRegistry();
                );
            List<String> fields = plan.relNode().getRowType().getFieldNames();
        SearchSourceBuilder source = new SearchSourceBuilder();
    }
    /**
            int columnCount = plan.relNode().getRowType().getFieldCount();
        assertEquals(TotalHits.Relation.EQUAL_TO, response.getHits().getTotalHits().relation());
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 75L);
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
     * Auto-discovers all golden JSON files and validates that mock execution
import org.opensearch.core.xcontent.DeprecationHandler;
                searchRequest.source(searchSource);
import org.opensearch.test.OpenSearchTestCase;
    /**
                    new ExecutionResult(
                        expectedPretty = b.toString();
                    )
        try (var builder = JsonXContent.contentBuilder()) {
import org.opensearch.common.xcontent.XContentHelper;
            )
        }
        return SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L);
        SearchRequest request = new SearchRequest();
            .aggregation(AggregationBuilders.terms("by_brand").field("brand").size(1));
        AggregationRegistry registry = new AggregationRegistry();
                SearchSourceConverter converter = new SearchSourceConverter(
                }
     */
                3,
                    bucketList.sort(Comparator.comparing(b -> String.valueOf(b.get("key"))));
        mapping.put("category", "VARCHAR");
    }
                results.add(new ExecutionResult(plan, List.<Object[]>of(new Object[] { "BrandA", 3L })));
        SearchRequest request = new SearchRequest("products");
 * SPDX-License-Identifier: Apache-2.0
                            }
        StringTerms byBrand = response.getAggregations().get("by_brand");
     * User-supplied {@code meta} on an aggregation request must be echoed back verbatim on the
        SearchRequest request = new SearchRequest();
     * rows produce the expected SearchResponse JSON via SearchResponseBuilder.build().
        responseMap.remove("_shards");
        assertNotNull(response.getHits());
        assertEquals(2L, byCategory.getBuckets().get(0).getDocCount());
        assertEquals(1700.0, sumCat1.getValue(), 0.0);
        addCountResult(plans, results, Map.of(QueryPlans.COUNT_TOTAL_COLUMN, 3, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand", 3));
                                Map<String, Object> subAgg = (Map<String, Object>) bucketEntry.getValue();
            for (int i = 0; i < fields.size(); i++) {
            );
    }
        assertEquals(3L, byBrand.getBuckets().get(0).getDocCount());
                List<ExecutionResult> allResults = new ArrayList<>();
        QueryPlans plans = converter.convert(executedSource, "products");
                    try (var b = JsonXContent.contentBuilder().prettyPrint()) {
                SearchRequest searchRequest = new SearchRequest(tc.getIndexName());
        mapping.put("brand", "VARCHAR");
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
    public void testGoldenFileSearchResponseGeneration() throws Exception {
public class SearchResponseBuilderTests extends OpenSearchTestCase {
                    addCountResult(plans, allResults, tc.getMockCountRow());
    public void testBuildWithNoResults() throws Exception {
            assertTrue("plan must be bounded to size", plan.relNode().explain().contains("fetch=[1]"));
            );
                results.add(new ExecutionResult(plan, List.<Object[]>of(new Object[] { "BrandA", 3L })));
import org.opensearch.dsl.golden.GoldenTestCase;
        mapping.put("brand", "VARCHAR");
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
        assertNotNull("by_brand must be present", byBrand);
    public void testTermsSizeTruncation() throws Exception {
        InternalAvg avgCat2 = byCategory.getBuckets().get(1).getAggregations().get("avg_price");
        AggregationRegistry registry = new AggregationRegistry();
        assertEquals(75L, response.getTook().millis());
                Object buckets = aggBody.get("buckets");
        QueryPlans plans = converter.convert(source, "products");
import org.opensearch.dsl.converter.SearchSourceConverter;
        assertEquals(850.0, avg1.getValue(), 0.0);
            assertEquals(List.of("brand", "_count"), plan.relNode().getRowType().getFieldNames());
        for (QueryPlans.QueryPlan plan : plans.get(QueryPlans.Type.AGGREGATION)) {
                        List.of(new Object[] { "BrandA", "Cat1", 850.0, 2L, 3L }, new Object[] { "BrandA", "Cat2", 700.0, 1L, 3L })
        assertEquals(0, response.getSkippedShards());
        assertEquals(10_000L, response.getHits().getTotalHits().value());
        assertEquals(700.0, avg2.getValue(), 0.0);
    }
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
    }
import org.opensearch.core.xcontent.XContentParser;
        InternalAvg avgCat1 = byCategory.getBuckets().get(0).getAggregations().get("avg_price");
                results.add(new ExecutionResult(plan, List.of(new Object[] { "Cat1", 2L }, new Object[] { "Cat2", 1L })));
                    )
                for (List<Object> row : tc.getMockResultRows()) {
        QueryPlans plans = converter.convert(source, "products");
        assertEquals(2, aggPlans.size());
        Map<String, Object> termsMeta = Map.of("source", "dashboard");
                // Build QueryPlan via forward path (needed to construct ExecutionResult)
            json = builder.toString();
        SearchRequest request = new SearchRequest();
import java.util.function.Supplier;
        assertEquals(42L, response.getTook().millis());
    private void stripNonDeterministicFields(Map<String, Object> responseMap) {
     * corresponding response aggregation — classic search parity — for both bucket and metric
        assertNull(response.getAggregations());
                assertEquals(List.of("brand", "_count"), fields);
                    new ExecutionResult(
        assertEquals(999L, response2.getTook().millis());
                            .subAggregation(AggregationBuilders.sum("sum_price").field("price"))
    public void testUserMetaEchoedInAggregations() throws Exception {
                3
                        AggregationBuilders.terms("by_brand")
                assertEquals(List.of("category", "brand", "avg_price", "_count", "_parent_eligible"), fields);
        assertEquals(1, response.getTotalShards());
        Map<String, Object> avgMeta = Map.of("owner", "pricing-team");
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema(), TestMapperServices.fromSqlMapping(mapping));
                    }
import org.opensearch.common.xcontent.json.JsonXContent;
        QueryPlans plans = converter.convert(source, "products");
 */
        QueryPlans plans = converter.convert(source, "products");
                SearchSourceBuilder searchSource = parseSearchSource(tc.getInputDsl());
                    .subAggregation(
    public void testShardCountsWithNoAggregations() throws Exception {
                if (matchingPlans.isEmpty()) {
    /** A result table missing a requested metric's column is a broken invariant — throw, don't render {@code "value": null}. */
        assertEquals(200, response.status().getStatus());
            );
                AggregationBuilders.terms("by_brand")
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
        assertEquals("BrandA", byBrand.getBuckets().get(0).getKeyAsString());
                    .field("brand")
                    .subAggregation(
        mapping.put("brand", "VARCHAR");
import org.opensearch.search.SearchModule;
        expectThrows(
        assertEquals(200, response.status().getStatus());
import java.util.ArrayList;
                GoldenTestCase tc = GoldenFileLoader.load(fileName);
                    fail("Unexpected column: " + fields.get(i));
        assertNull(response.getAggregations());
        SearchRequest request = new SearchRequest();
        SearchResponse response = SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L);
    }
                    try (var b = JsonXContent.contentBuilder().prettyPrint()) {
import org.opensearch.core.common.Strings;
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
        List<String> failures = new ArrayList<>();
                // nesting; the per-parent eligible total rides the bounded child plan's rows.
                    .field("category")
            if (fields.contains("avg_price")) {
import java.util.Map;
                stripNonDeterministicFields(expectedOutput);
                    )
                assertEquals(List.of("brand", "category", "avg_price", "_count", "_parent_eligible"), fields);
            Object[] row = new Object[fields.size()];
                // identical layouts, distinguished ONLY by the metadata's aggregation-name path.
    public void testBuildWithNullSource() throws Exception {
import org.opensearch.core.xcontent.NamedXContentRegistry;
                QueryPlans.Type expectedType = QueryPlans.Type.valueOf(tc.getPlanType());
        }
            builder.map(inputDsl);
                if (!expectedOutput.equals(actualOutput)) {
        SearchResponse response = countOnlyResponse(new SearchSourceBuilder().size(0).trackTotalHits(true), 25_000L);
import org.opensearch.core.xcontent.MediaTypeRegistry;
    }
                stripNonDeterministicFields(actualOutput);
    @SuppressWarnings("unchecked")
        assertEquals(1, response.getTotalShards());
        assertEquals(42L, response.getHits().getTotalHits().value());
                    row[i] = 3L;
                List<QueryPlans.QueryPlan> matchingPlans = plans.get(expectedType);
                        plan,
        request.source(new SearchSourceBuilder());
     * distinct results. Under the old order-insensitive (sorted) granularity keys, both deep
                if (buckets instanceof List) {
     * correct-looking buckets.
                    infra.schema(),
        addCountResult(plans, results, Map.of(QueryPlans.COUNT_TOTAL_COLUMN, 3, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand", 3));
import org.opensearch.dsl.golden.GoldenFileLoader;
    // ---- Golden file driven SearchResponse generation tests ----
    // ---- Helpers ----
            }
                Map<String, Object> actualOutput = XContentHelper.convertToMap(JsonXContent.jsonXContent, responseJson, false);
        mapping.put("price", "INTEGER");
    }
            plans,
        assertNull(response.getHits().getTotalHits());
                }
        StringTerms byBrandCat2 = catFirst.getBuckets().get(1).getAggregations().get("by_brand");
 * compatible open source license.
                );
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
            } catch (Exception e) {
    }
                    builder.map(tc.getExpectedOutputDsl());
    }
        request.source(new SearchSourceBuilder());
     * Regression: sibling aggregation trees over the same field SET but opposite nesting order
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
        assertNotNull(response);
    @SuppressWarnings("unchecked")
            results.add(new ExecutionResult(plan, List.<Object[]>of(row)));
        assertEquals(0, response.getFailedShards());
        assertEquals(100L, response.getTook().millis());
                String responseJson = Strings.toString(MediaTypeRegistry.JSON, response);
        SearchRequest request = new SearchRequest("products");
                    )
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
        List<Path> goldenFiles;
                    }
        assertEquals(termsMeta, byBrand.getMetadata());
     */
                }
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, converter.getAggregationRegistry(), 1L);
                            .subAggregation(AggregationBuilders.avg("avg_price").field("price"))
import org.apache.lucene.search.TotalHits;
                CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping(tc.getIndexName(), tc.getIndexMapping());
    /**
        InternalAvg avg1 = byCategory.getBuckets().get(0).getAggregations().get("avg_price");
        assertEquals(200, response.status().getStatus());
                        plan,
                AggregationBuilders.terms("by_brand")
    }
            ConversionException.class,
                );
                // Group columns arrive in schema order (category first) despite brand-first
import org.opensearch.dsl.aggregation.AggregationRegistry;
        mapping.put("price", "INTEGER");
 * The OpenSearch Contributors require contributions made to
    /** Runs a count-only request (size 0, no aggs) with a fabricated engine count. */
    }
import java.io.IOException;
        QueryPlans plans = converter.convert(source, "products");
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
        }
                results.add(
        responseMap.remove("timed_out");
        StringTerms catFirst = response.getAggregations().get("cat_first");
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema(), TestMapperServices.fromSqlMapping(mapping));
     * brand → category). Before key canonicalization this returned empty aggregations.
                    for (Map<String, Object> bucket : bucketList) {
    public void testHitsTotalExactWhenTrackTotalHitsTrue() throws Exception {
        }
        // brand_first → BrandA → by_category → Cat1 (avg 850), Cat2 (avg 700)
        SearchRequest request = new SearchRequest("products");
                if (tc.getMockCountRow() != null) {
        for (Map.Entry<String, Object> entry : aggMap.entrySet()) {
                allResults.add(new ExecutionResult(matchingPlans.get(0), rows));
            results.add(new ExecutionResult(plan, List.<Object[]>of(new Object[columnCount])));
                    TestMapperServices.fromSqlMapping(tc.getIndexMapping())
    /**
            goldenFiles = stream.filter(p -> p.toString().endsWith(".json")).collect(Collectors.toList());
    }
    private void normalizeAggregationBuckets(Map<String, Object> map) {
        assertEquals(0, response.getHits().getHits().length);
                    List<Map<String, Object>> bucketList = (List<Map<String, Object>>) buckets;
        // Response requested for "avg_price" — same granularity, but no such column in the result
    public void testHitsTotalExactUnderDefaultThreshold() throws Exception {
        mapping.put("category", "VARCHAR"); // lower column index than brand — the crux
    }
        assertNotNull(byBrand);
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        StringTerms brandFirst = response.getAggregations().get("brand_first");
                        b.map(actualOutput);
        assertNotNull(avg);
                    continue;
                    )
import org.opensearch.dsl.converter.ConversionException;
    public void testHitsTotalOmittedWhenTrackTotalHitsFalse() throws Exception {
                            .subAggregation(AggregationBuilders.avg("avg_price").field("price"))
                    row[i] = "BrandA";
    }
        assertEquals(2L, byBrand.getSumOfOtherDocCounts());
        assertTrue("nothing to count, nothing to run", plans.getAll().isEmpty());
                        b.map(expectedOutput);
        InternalAvg avg2 = byCategory.getBuckets().get(1).getAggregations().get("avg_price");
    public void testTimingPreserved() throws Exception {
import org.opensearch.search.builder.SearchSourceBuilder;
                Map<String, Object> aggBody = (Map<String, Object>) value;
        assertEquals(1, response.getSuccessfulShards());
        for (QueryPlans.QueryPlan plan : aggPlans) {
        StringTerms byBrand = response.getAggregations().get("by_brand");
        SearchRequest request = new SearchRequest("products");
            }
            List<String> fields = plan.relNode().getRowType().getFieldNames();
        request.source(source);
                    normalizeAggregationBuckets(actualOutput);
            }
        SearchSourceBuilder executedSource = new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.avg("other").field("price"));
                    expectedJson = builder.toString();
        SearchResponse response = countOnlyResponse(new SearchSourceBuilder().size(0), 42L);
            return SearchSourceBuilder.fromXContent(parser);
        Supplier<MapperService> mappers = TestMapperServices.fromSqlMapping(mapping);
                    .setMetadata(termsMeta)
            results,
            } else if (fields.equals(List.of("brand", "_count"))) {
        String json;
        assertEquals(2, byCategory.getBuckets().size());
            )
        assertNotNull("brand_first must be present", brandFirst);
        assertEquals("Cat1", byCategory.getBuckets().get(0).getKeyAsString());
        assertNotNull(response);
                }
        assertNotNull("cat_first must be present", catFirst);
     * bucket — and {@code sum_other_doc_count} comes from the count plan's eligible count
     */
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
                Object value = countsByColumn.get(fields.get(i));
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
            String fileName = file.getFileName().toString();
                            .field("brand")
                        List.of(new Object[] { "BrandA", "Cat1", 1700.0, 2L, 2L }, new Object[] { "BrandA", "Cat2", 700.0, 1L, 1L })
import org.opensearch.action.search.SearchResponse;
                    normalizeAggregationBuckets(expectedOutput);
                    )
        StringTerms byBrand = response.getAggregations().get("by_brand");
            List<String> fields = plan.relNode().getRowType().getFieldNames();
     * what the engine would return for it. Fails the test if the plan carries a column the
        SearchRequest request = new SearchRequest();
import org.opensearch.search.aggregations.AggregationBuilders;
import org.opensearch.action.search.SearchRequest;
    }
        AggregationRegistry registry = new AggregationRegistry();
                    .subAggregation(AggregationBuilders.avg("avg_price").field("price").setMetadata(avgMeta))
}
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
        InternalAvg avg = byBrand.getBuckets().get(0).getAggregations().get("avg_price");
        List<ExecutionResult> results = new ArrayList<>();
        List<ExecutionResult> results = new ArrayList<>();
        );
        assertEquals(1, byBrand.getBuckets().size());
            try {
        // Data story: 3 docs — BrandA/Cat1/800, BrandA/Cat1/900, BrandA/Cat2/700.
    }
                    .field("brand")
                QueryPlans plans = converter.convert(searchSource, tc.getIndexName());
    }
        assertEquals(0, response.getHits().getHits().length);
    }
            results.add(new ExecutionResult(plan, List.<Object[]>of(row)));
        );
import java.nio.file.Files;
        List<ExecutionResult> results = new ArrayList<>();
        request.source(source);
import org.opensearch.common.settings.Settings;
        assertEquals(2L, byCategory.getSumOfOtherDocCounts());
import org.opensearch.dsl.executor.QueryPlans;
            fail("Golden file SearchResponse generation failures:\n" + String.join("\n", failures));
            } else {
                try (var builder = JsonXContent.contentBuilder()) {
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema());
                AggregationBuilders.terms("cat_first")
            .aggregation(
        mapping.put("brand", "VARCHAR");
