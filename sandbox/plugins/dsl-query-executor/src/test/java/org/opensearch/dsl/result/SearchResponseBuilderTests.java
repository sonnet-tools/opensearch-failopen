        StringTerms brandFirst = response.getAggregations().get("brand_first");
        AggregationRegistry registry = new AggregationRegistry();
import java.util.Collections;
        addCountResult(plans, results, Map.of(QueryPlans.COUNT_TOTAL_COLUMN, 3, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand", 3));
    public void testNestedGroupFieldsWithOpposingSchemaOrder() throws Exception {  
        assertEquals(1, response.getTotalShards());
        SearchSourceBuilder source = new SearchSourceBuilder();
    }  
        Map<String, Object> termsMeta = Map.of("source", "dashboard");  
     */
                CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping(tc.getIndexName(), tc.getIndexMapping());
package org.opensearch.dsl.result;
import org.opensearch.dsl.golden.GoldenTestCase;  
                Object value = countsByColumn.get(fields.get(i));
                        AggregationBuilders.terms("by_category")  
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.dsl.golden.GoldenFileLoader;
        List<ExecutionResult> results = new ArrayList<>();  
                    failures.add(fileName + ": SearchResponse mismatch\n  Expected: " + expectedPretty + "\n  Actual:   " + actualPretty);
                    continue;
            }  
        assertEquals(2, catFirst.getBuckets().size());  
                QueryPlans plans = converter.convert(searchSource, tc.getIndexName());
                }
    /**  
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
        assertEquals(avgMeta, avg.getMetadata());
        assertEquals(1700.0, sumCat1.getValue(), 0.0);  
        assertNotNull(response);
import org.opensearch.search.aggregations.metrics.InternalSum;
        AggregationRegistry registry = new AggregationRegistry();
    }  
            results.add(new ExecutionResult(plan, List.<Object[]>of(new Object[] { "BrandA", 3L })));  
                assertEquals(List.of("category", "brand", "avg_price", "_count", "_parent_eligible"), fields);
        assertEquals(100L, response.getTook().millis());
            for (int i = 0; i < fields.size(); i++) {  
        request.source(source);
            .aggregation(
                );  
        }
        assertEquals(0, response.getFailedShards());  
        StringTerms byCategory = byBrand.getBuckets().get(0).getAggregations().get("by_category");
        addCountResult(plans, results, Map.of(QueryPlans.COUNT_TOTAL_COLUMN, 3, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand", 3));
        for (QueryPlans.QueryPlan plan : plans.get(QueryPlans.Type.AGGREGATION)) {  
        InternalSum sumCat2 = byBrandCat2.getBuckets().get(0).getAggregations().get("sum_price");
                    TestMapperServices.fromSqlMapping(tc.getIndexMapping())
        mapping.put("brand", "VARCHAR");  
        SearchRequest request = new SearchRequest("products");
                QueryPlans.Type expectedType = QueryPlans.Type.valueOf(tc.getPlanType());  
        StringTerms byCategory = brandFirst.getBuckets().get(0).getAggregations().get("by_category");
        );
        AggregationRegistry registry = new AggregationRegistry();
        AggregationRegistry registry = new AggregationRegistry();
        assertNotNull(avg);  
        assertEquals(200, response.status().getStatus());  
        assertEquals(1, byBrand.getBuckets().size());
    /** Runs a count-only request (size 0, no aggs) with a fabricated engine count. */  
        AggregationRegistry registry = new AggregationRegistry();
                List<QueryPlans.QueryPlan> matchingPlans = plans.get(expectedType);
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
import org.opensearch.common.xcontent.json.JsonXContent;  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(1, brandFirst.getBuckets().size());
        mapping.put("brand", "VARCHAR");
                if (matchingPlans.isEmpty()) {
     * Auto-discovers all golden JSON files and validates that mock execution
        assertEquals(999L, response2.getTook().millis());
        try (var stream = Files.list(Path.of(goldenDir.toURI()))) {
import org.opensearch.search.aggregations.metrics.InternalAvg;  
        assertEquals(25_000L, response.getHits().getTotalHits().value());  
        assertNotNull(response);
        SearchResponse response = SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L);  
                    .setMetadata(termsMeta)
        request.source(source);
    private SearchResponse countOnlyResponse(SearchSourceBuilder source, long total) throws Exception {
                    )
        InternalAvg avg1 = byCategory.getBuckets().get(0).getAggregations().get("avg_price");
            .aggregation(AggregationBuilders.terms("by_brand").field("brand").size(1));
                    infra.schema(),
                for (List<Object> row : tc.getMockResultRows()) {  
            new SearchModule(Settings.EMPTY, Collections.emptyList()).getNamedXContents()
        // Response requested for "avg_price" — same granularity, but no such column in the result  
        assertEquals(700.0, avgCat2.getValue(), 0.0);
}  
        assertEquals(10_000L, response.getHits().getTotalHits().value());
    /**
                SearchRequest searchRequest = new SearchRequest(tc.getIndexName());
            );  
        mapping.put("price", "INTEGER");  
                assertNotNull("count fabrication missing column: " + fields.get(i), value);
    }
import org.opensearch.search.aggregations.AggregationBuilders;
            Object[] row = new Object[fields.size()];
                assertEquals(List.of("category", "_count"), fields);
 * compatible open source license.
    public void testHitsTotalOmittedWhenTrackTotalHitsFalse() throws Exception {
     * Terms {@code size} is enforced by the plan's LIMIT — the engine returns only the top
        for (QueryPlans.QueryPlan plan : plans.get(QueryPlans.Type.AGGREGATION)) {
        SearchRequest request = new SearchRequest();  
        QueryPlans plans = converter.convert(source, "products");
                Map<String, Object> aggBody = (Map<String, Object>) value;
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 50L);  
        QueryPlans plans = converter.convert(source, "products");
        Object aggs = map.get("aggregations");
        SearchRequest request = new SearchRequest("products");
        source.aggregation(AggregationBuilders.avg("avg_price").field("price"));
                    normalizeAggregationBuckets(expectedOutput);  
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 100L);  
        }
        assertEquals(42L, response.getTook().millis());
        assertEquals(0, response.getHits().getHits().length);  
 *
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 75L);
                stripNonDeterministicFields(expectedOutput);
import org.opensearch.test.OpenSearchTestCase;  
     * the request's nesting order (schema declares category before brand; request nests  
                    )  
        assertNotNull(response.getHits().getTotalHits());
        Supplier<MapperService> mappers = TestMapperServices.fromSqlMapping(mapping);
        assertEquals(0, response.getSkippedShards());
            );
            results.add(new ExecutionResult(plan, List.<Object[]>of(row)));
                    for (Map<String, Object> bucket : bucketList) {
        for (Path file : goldenFiles) {
            for (int i = 0; i < fields.size(); i++) {  
                    new ExecutionResult(
        mapping.put("brand", "VARCHAR");  
import org.opensearch.index.mapper.MapperService;
                    .subAggregation(
                        plan,  
                // Deep copy expected to avoid mutating GoldenTestCase
     * Regression: granularity keys must match even when the schema's column order opposes
                    addCountResult(plans, allResults, tc.getMockCountRow());  
                    row[i] = "BrandA";
import java.nio.file.Files;
import java.nio.file.Path;
                        List.of(new Object[] { "BrandA", "Cat1", 850.0, 2L, 3L }, new Object[] { "BrandA", "Cat2", 700.0, 1L, 3L })
        addCountResult(plans, results, Map.of(QueryPlans.COUNT_TOTAL_COLUMN, total));
     * map does not provide.  
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 42L);  
                    new ExecutionResult(
    @SuppressWarnings("unchecked")  
            results,
                // Build QueryPlan via forward path (needed to construct ExecutionResult)
        QueryPlans plans = converter.convert(source, "products");  
                    )  
                String responseJson = Strings.toString(MediaTypeRegistry.JSON, response);
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
import org.opensearch.dsl.converter.SearchSourceConverter;
                );
            ConversionException.class,
        SearchRequest request = new SearchRequest("products");  
        assertEquals(4, aggPlans.size());  
            .aggregation(
        URL goldenDir = getClass().getClassLoader().getResource("golden");  
                    rows.add(row.toArray());
public class SearchResponseBuilderTests extends OpenSearchTestCase {
        }
        }
        SearchResponse response = SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L);
                            .subAggregation(AggregationBuilders.avg("avg_price").field("price"))
                // Build ExecutionResult from mock rows
        return SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L);
        assertEquals(2, byCategory.getBuckets().size());  
                    .field("brand")  
        InternalAvg avgCat2 = byCategory.getBuckets().get(1).getAggregations().get("avg_price");  
            json = builder.toString();
    @SuppressWarnings("unchecked")  
                // cat_first tree: the parent is category, so each row carries its category's total
                SearchSourceConverter converter = new SearchSourceConverter(  
                        actualPretty = b.toString();
                // Both deep plans group by {brand, category} and emit columns in schema order —
        SearchRequest request = new SearchRequest();
 * The OpenSearch Contributors require contributions made to  
                results.add(
        String json;
        SearchRequest request = new SearchRequest();  
            results.add(new ExecutionResult(plan, List.<Object[]>of(row)));
/*  
    // ---- hits.total: classic track_total_hits semantics from the COUNT plan ----
                failures.add(fileName + ": " + e.getClass().getSimpleName() + " - " + e.getMessage());
import org.opensearch.dsl.executor.QueryPlans;  
    public void testUserMetaEchoedInAggregations() throws Exception {  
                } else if ("avg_price".equals(fields.get(i))) {  
        SearchResponse response = SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L);  
    }
        addCountResult(
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
        assertEquals(termsMeta, byBrand.getMetadata());  
        assertEquals(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO, response.getHits().getTotalHits().relation());  
            }  
    private void normalizeBucketsRecursive(Map<String, Object> aggMap) {
                            }
            Object value = entry.getValue();  
import org.opensearch.core.xcontent.DeprecationHandler;
                AggregationBuilders.terms("brand_first")  
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
    public void testTimingPreserved() throws Exception {  
    private SearchSourceBuilder parseSearchSource(Map<String, Object> inputDsl) throws IOException {  
                            .field("category")
import org.opensearch.common.settings.Settings;
    /**  
        assertEquals(200, response.status().getStatus());  
        assertEquals(1, response.getSuccessfulShards());
        SearchRequest request = new SearchRequest("products");
                    row[i] = 3L;  
                    .subAggregation(
        assertEquals("brand_first's metric must not be lost to the sibling tree", 850.0, avgCat1.getValue(), 0.0);
                if (tc.getMockCountRow() != null) {
                SearchResponse response = SearchResponseBuilder.build(allResults, searchRequest, converter.getAggregationRegistry(), 0L);  
            if (fields.contains("avg_price")) {
    }
        }
                    .field("brand")
    public void testBuildWithNullSource() throws Exception {
                Map<String, Object> expectedOutput = XContentHelper.convertToMap(JsonXContent.jsonXContent, expectedJson, false);
            List<String> fields = plan.relNode().getRowType().getFieldNames();
                assertEquals(List.of("brand", "category", "avg_price", "_count", "_parent_eligible"), fields);  
        InternalAvg avg2 = byCategory.getBuckets().get(1).getAggregations().get("avg_price");  
     * distinct results. Under the old order-insensitive (sorted) granularity keys, both deep  
        for (QueryPlans.QueryPlan plan : plans.get(QueryPlans.Type.AGGREGATION)) {
        assertNotNull("brand_first must be present", brandFirst);  
                );  
            } else {  
                                Map<String, Object> subAgg = (Map<String, Object>) bucketEntry.getValue();
                        AggregationBuilders.terms("by_category")  
 */  
        SearchRequest request = new SearchRequest();  
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema());  
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 10L);
        assertEquals(75L, response.getTook().millis());
import java.util.function.Supplier;
    private void stripNonDeterministicFields(Map<String, Object> responseMap) {  
        assertEquals(3L, byBrand.getBuckets().get(0).getDocCount());  
                Object buckets = aggBody.get("buckets");  
                QueryPlans.COUNT_TOTAL_COLUMN,  
        assertEquals(200, response.status().getStatus());  
            List<String> fields = plan.relNode().getRowType().getFieldNames();
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema(), TestMapperServices.fromSqlMapping(mapping));  
                        plan,
            // the engine honors the LIMIT: only the top bucket comes back
import org.opensearch.dsl.golden.TestMapperServices;
            () -> SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L)  
                GoldenTestCase tc = GoldenFileLoader.load(fileName);
     * (brand→category vs category→brand) produce two distinct plans and must resolve to two
            return SearchSourceBuilder.fromXContent(parser);
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
    /**
                    bucketList.sort(Comparator.comparing(b -> String.valueOf(b.get("key"))));  
import org.opensearch.search.builder.SearchSourceBuilder;
                    List<Map<String, Object>> bucketList = (List<Map<String, Object>>) buckets;
        request.source(source);
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, converter.getAggregationRegistry(), 1L);
        assertEquals(2L, byCategory.getBuckets().get(0).getDocCount());  
    }  
            Object[] row = new Object[fields.size()];
                } else if ("_count".equals(fields.get(i))) {
        }  
    public void testEmptyHitsAlwaysReturned() throws Exception {
    }
            )  
            plans,  
        assertEquals(42L, response.getHits().getTotalHits().value());
            int columnCount = plan.relNode().getRowType().getFieldCount();
        assertEquals(1, byBrand.getBuckets().size());  
        List<ExecutionResult> results = new ArrayList<>();
    public void testBuildWithNoResults() throws Exception {
    // ---- Golden file driven SearchResponse generation tests ----
        assertNotNull(response);  
                }
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        request.source(source);
                        List.of(new Object[] { "Cat1", "BrandA", 850.0, 2L, 5L }, new Object[] { "Cat2", "BrandA", 700.0, 1L, 5L })  
        assertEquals(1, response.getTotalShards());
        assertEquals(850.0, avg.getValue(), 0.0);
        List<String> failures = new ArrayList<>();  
                            .field("brand")
        assertEquals(850.0, avg1.getValue(), 0.0);
        mapping.put("price", "INTEGER");  
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
                        plan,  
     * correct-looking buckets.  
        StringTerms byBrand = response.getAggregations().get("by_brand");
            )
        assertNotNull(byBrand);
    }
    }
                List<Object[]> rows = new ArrayList<>();
            }
            assertEquals(List.of("brand", "_count"), plan.relNode().getRowType().getFieldNames());  
    @SuppressWarnings("unchecked")
            } else {  
                results.add(new ExecutionResult(plan, List.of(new Object[] { "Cat1", 2L }, new Object[] { "Cat2", 1L })));
     */
        SearchResponse response2 = SearchResponseBuilder.build(List.of(), request, registry, 999L);
        SearchResponse response = countOnlyResponse(new SearchSourceBuilder().size(0), 25_000L);  
                List<ExecutionResult> allResults = new ArrayList<>();  
                if ("brand".equals(fields.get(i))) {
                if ("AGGREGATION".equals(tc.getPlanType())) {
                if (!expectedOutput.equals(actualOutput)) {  
        assertEquals(700.0, avg2.getValue(), 0.0);
                        expectedPretty = b.toString();
                    String expectedPretty, actualPretty;
                } else {
            }  
                    )
        StringTerms byBrand = response.getAggregations().get("by_brand");
    }
                );  
        SearchRequest request = new SearchRequest();  
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema(), TestMapperServices.fromSqlMapping(mapping));
            results.add(new ExecutionResult(plan, List.<Object[]>of(new Object[columnCount])));  
                    try (var b = JsonXContent.contentBuilder().prettyPrint()) {
                    )  
                        b.map(expectedOutput);  
        SearchSourceBuilder executedSource = new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.avg("other").field("price"));
import java.io.IOException;
    private static void addCountResult(QueryPlans plans, List<ExecutionResult> results, Map<String, Object> countsByColumn) {
        }
            try {  
    public void testTermsSizeTruncation() throws Exception {
        NamedXContentRegistry registry = new NamedXContentRegistry(  
                            .subAggregation(AggregationBuilders.avg("avg_price").field("price"))
        assertNotNull(response);
     * Fabricates the COUNT plan's single-row result from a columnName→value map, mirroring
        assertEquals(0, response.getHits().getHits().length);
                // identical layouts, distinguished ONLY by the metadata's aggregation-name path.
        Map<String, Object> avgMeta = Map.of("owner", "pricing-team");
    public void testMissingMetricColumnThrows() throws Exception {
            .aggregation(
                }  
        SearchSourceBuilder source = new SearchSourceBuilder().size(0)  
        SearchRequest request = new SearchRequest();
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
 * SPDX-License-Identifier: Apache-2.0
        StringTerms catFirst = response.getAggregations().get("cat_first");
        request.source(new SearchSourceBuilder());
        assertNotNull("by_category must be present inside the brand bucket", byCategory);  
        assertEquals(2, byCategory.getBuckets().size());
    }  
                        for (Map.Entry<String, Object> bucketEntry : bucket.entrySet()) {
import java.net.URL;  
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
                    try (var b = JsonXContent.contentBuilder().prettyPrint()) {  
import java.util.ArrayList;  
        List<ExecutionResult> results = new ArrayList<>();
                        }  
        List<ExecutionResult> results = new ArrayList<>();  
                // nesting; the per-parent eligible total rides the bounded child plan's rows.
                    row[i] = 850.0;
import org.opensearch.dsl.golden.CalciteTestInfra;
        assertNull(response.getHits().getTotalHits());  
                AggregationBuilders.terms("cat_first")  
            );
        }  
    public void testGoldenFileSearchResponseGeneration() throws Exception {
    public void testShardCountsWithNoAggregations() throws Exception {
                QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "cat_first",
                    }  
            normalizeBucketsRecursive((Map<String, Object>) aggs);
        responseMap.remove("_shards");  
        assertEquals(700.0, sumCat2.getValue(), 0.0);  
        request.source(new SearchSourceBuilder().size(0).aggregation(AggregationBuilders.avg("avg_price").field("price")));
                assertEquals(List.of("brand", "_count"), fields);
    public void testHitsTotalExactUnderDefaultThreshold() throws Exception {
        assertFalse("No golden files found", goldenFiles.isEmpty());
        SearchResponse response1 = SearchResponseBuilder.build(List.of(), request, registry, 0L);
import org.opensearch.search.SearchModule;  
                assertEquals(List.of("brand", "category", "sum_price", "_count", "_parent_eligible"), fields);  
     * corresponding response aggregation — classic search parity — for both bucket and metric  
     * ({@code eligible − Σ rendered}), since the tail never leaves the engine.  
                stripNonDeterministicFields(actualOutput);
                                }
        request.source(source);  
        try (XContentParser parser = JsonXContent.jsonXContent.createParser(registry, DeprecationHandler.IGNORE_DEPRECATIONS, json)) {  
        AggregationRegistry registry = new AggregationRegistry();
    }  
        request.source(new SearchSourceBuilder());  
    public void testReversedNestingSiblingTreesDoNotCollide() throws Exception {
            builder.map(inputDsl);  
            if (value instanceof Map) {
        for (QueryPlans.QueryPlan plan : aggPlans) {  
                SearchSourceBuilder searchSource = parseSearchSource(tc.getInputDsl());
    }
        QueryPlans plans = converter.convert(source, "products");
        assertNotNull("cat_first must be present", catFirst);
        request.source(source);  
        mapping.put("category", "VARCHAR"); // lower column index than brand — the crux
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
            String fileName = file.getFileName().toString();
    public void testBuildWithAggregationsButNoResults() throws Exception {
                }
        List<Path> goldenFiles;  
        List<ExecutionResult> results = new ArrayList<>();
        }  
                            .field("category")
                            if (bucketEntry.getValue() instanceof Map) {  
        mapping.put("price", "INTEGER");
        SearchResponse response = countOnlyResponse(new SearchSourceBuilder().size(0).trackTotalHits(true), 25_000L);
            }
     * brand → category). Before key canonicalization this returned empty aggregations.
        StringTerms byBrandCat1 = catFirst.getBuckets().get(0).getAggregations().get("by_brand");
        StringTerms byBrandCat2 = catFirst.getBuckets().get(1).getAggregations().get("by_brand");
        SearchResponse response = SearchResponseBuilder.build(List.of(), request, registry, 10L);  
        if (!failures.isEmpty()) {
        mapping.put("brand", "VARCHAR");  
    }  
    }
                            .subAggregation(AggregationBuilders.sum("sum_price").field("price"))
        SearchRequest request = new SearchRequest();  
import org.opensearch.core.common.Strings;
                searchRequest.source(searchSource);
        }
        InternalAvg avgCat1 = byCategory.getBuckets().get(0).getAggregations().get("avg_price");
                results.add(new ExecutionResult(plan, List.<Object[]>of(new Object[] { "BrandA", 3L })));
        assertEquals(0L, response1.getTook().millis());
        List<QueryPlans.QueryPlan> aggPlans = plans.get(QueryPlans.Type.AGGREGATION);
                                if (subAgg.containsKey("buckets")) {
        }  
            List<String> fields = plan.relNode().getRowType().getFieldNames();
                    new ExecutionResult(
        // cat_first → Cat1 → by_brand → BrandA (sum 1700); Cat2 → by_brand → BrandA (sum 700)  
                    failures.add(fileName + ": No " + expectedType + " plan produced");  
        AggregationRegistry registry = new AggregationRegistry();
     */
                    .subAggregation(
        assertNull(response.getAggregations());
    }
        Map<String, String> mapping = new java.util.LinkedHashMap<>();  
            .aggregation(
    /** Recursively sorts aggregation bucket lists by key for order-insensitive comparison. */
        assertEquals(TotalHits.Relation.EQUAL_TO, response.getHits().getTotalHits().relation());
        Map<String, String> mapping = new java.util.LinkedHashMap<>();  
        assertEquals(1, response.getSuccessfulShards());
                allResults.add(new ExecutionResult(matchingPlans.get(0), rows));
import java.util.stream.Collectors;  
    private void normalizeAggregationBuckets(Map<String, Object> map) {
        assertNull(response.getAggregations());  
            List<String> fields = plan.relNode().getRowType().getFieldNames();
        mapping.put("category", "VARCHAR");
        mapping.put("brand", "VARCHAR");
     * rows produce the expected SearchResponse JSON via SearchResponseBuilder.build().  
        assertEquals("BrandA", byBrand.getBuckets().get(0).getKeyAsString());
import org.opensearch.core.xcontent.NamedXContentRegistry;
import org.opensearch.action.search.SearchResponse;  
     */
     */
    public void testHitsTotalExactWhenTrackTotalHitsTrue() throws Exception {  
                }
    }
    public void testBuildWithEmptyRequest() throws Exception {
        addCountResult(plans, results, Map.of(QueryPlans.COUNT_TOTAL_COLUMN, 5, QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "by_brand", 5));
        assertEquals(3L, byBrand.getBuckets().get(0).getDocCount());
    }
        assertNull(response.getAggregations());
        SearchRequest request = new SearchRequest("products");
        assertEquals(2L, byCategory.getSumOfOtherDocCounts());  
        mapping.put("brand", "VARCHAR");  
                    }
                        AggregationBuilders.terms("by_brand")  
     * what the engine would return for it. Fails the test if the plan carries a column the
    public void testHitsTotalLowerBoundOverDefaultThreshold() throws Exception {
        List<ExecutionResult> results = new ArrayList<>();  
                if (buckets instanceof List) {
import org.apache.lucene.search.TotalHits;
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
        SearchResponse response = SearchResponseBuilder.build(results, request, converter.getAggregationRegistry(), 1L);
            if (fields.contains("avg_price")) {  
                }
                String expectedJson;  
        InternalAvg avg = byBrand.getBuckets().get(0).getAggregations().get("avg_price");
        SearchRequest request = new SearchRequest("products");  
                results.add(
        QueryPlans plans = converter.convert(source, "products");
        assertEquals("Cat1", byCategory.getBuckets().get(0).getKeyAsString());
    /**
     * bucket — and {@code sum_other_doc_count} comes from the count plan's eligible count
            }
                try (var builder = JsonXContent.contentBuilder()) {
import org.opensearch.dsl.aggregation.AggregationRegistry;  
                    .subAggregation(AggregationBuilders.avg("avg_price").field("price").setMetadata(avgMeta))
        SearchSourceBuilder source = new SearchSourceBuilder().size(0).trackTotalHits(false);  
            } else if (fields.equals(List.of("brand", "_count"))) {
    /**  
        assertNotNull("by_brand must be present", byBrand);  
import org.opensearch.dsl.converter.ConversionException;
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema(), mappers);  
        // per-parent eligible total 5 vs 3 rendered docs → 2 in truncated child groups
        responseMap.remove("took");
            } else if (fields.contains("sum_price")) {
        }
            assertTrue("plan must be bounded to size", plan.relNode().explain().contains("fetch=[1]"));
        StringTerms byBrand = response.getAggregations().get("by_brand");
import org.opensearch.core.xcontent.XContentParser;
                        b.map(actualOutput);
                results.add(  
                }
import java.util.Map;
import org.opensearch.search.aggregations.bucket.terms.StringTerms;
        for (Map.Entry<String, Object> entry : aggMap.entrySet()) {
                }
                    expectedJson = builder.toString();  
        mapping.put("price", "INTEGER");
                Map<String, Object> actualOutput = XContentHelper.convertToMap(JsonXContent.jsonXContent, responseJson, false);  
                    normalizeAggregationBuckets(actualOutput);
import java.util.List;  
        assertNotNull("Golden file resource directory not found", goldenDir);
            fail("Golden file SearchResponse generation failures:\n" + String.join("\n", failures));  
import org.opensearch.action.search.SearchRequest;
        request.source(source);
                // Group columns arrive in schema order (category first) despite brand-first  
        QueryPlans plans = converter.convert(executedSource, "products");
                3,  
     * first's, and the losing tree's metric came back empty ({@code "value": null}) beneath
                    builder.map(tc.getExpectedOutputDsl());
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema(), TestMapperServices.fromSqlMapping(mapping));
        // brand_first → BrandA → by_category → Cat1 (avg 850), Cat2 (avg 700)
        for (QueryPlans.QueryPlan plan : aggPlans) {
        assertEquals("BrandA", byBrand.getBuckets().get(0).getKeyAsString());
    }  
        SearchRequest request = new SearchRequest("products");  
    }  
                    }
        // Data story: 3 docs — BrandA/Cat1/800, BrandA/Cat1/900, BrandA/Cat2/700.
                    fail("Unexpected column: " + fields.get(i));
     * plans collapsed onto one map slot: the second plan's result silently overwrote the
        assertEquals(2L, byBrand.getSumOfOtherDocCounts());  
        assertEquals(TotalHits.Relation.EQUAL_TO, response.getHits().getTotalHits().relation());
                QueryPlans.COUNT_ELIGIBLE_COLUMN_PREFIX + "brand_first",
                                    normalizeBucketsRecursive(Map.of(bucketEntry.getKey(), subAgg));  
        }
                3
                    .field("brand")
        if (aggs instanceof Map) {  
        assertTrue("nothing to count, nothing to run", plans.getAll().isEmpty());  
    }  
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
        );
        try (var builder = JsonXContent.contentBuilder()) {
        expectThrows(
    /** A result table missing a requested metric's column is a broken invariant — throw, don't render {@code "value": null}. */  
        InternalSum sumCat1 = byBrandCat1.getBuckets().get(0).getAggregations().get("sum_price");
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema());  
                    )
        assertEquals(2, aggPlans.size());  
            Map.of(
        assertNull(response.getAggregations());
                    .field("category")
        mapping.put("brand", "VARCHAR");
        assertEquals(1, response.getTotalShards());  
     */
    }  
        );
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
                        List.of(new Object[] { "BrandA", "Cat1", 1700.0, 2L, 2L }, new Object[] { "BrandA", "Cat2", 700.0, 1L, 1L })
        responseMap.remove("timed_out");
        for (QueryPlans.QueryPlan plan : plans.get(QueryPlans.Type.COUNT)) {  
        Map<String, String> mapping = new java.util.LinkedHashMap<>();
     * Regression: sibling aggregation trees over the same field SET but opposite nesting order
        SearchResponse response = countOnlyResponse(new SearchSourceBuilder().size(0), 42L);
                row[i] = value instanceof Number n ? n.longValue() : value;  
    }
import java.util.Comparator;
        List<QueryPlans.QueryPlan> aggPlans = plans.get(QueryPlans.Type.AGGREGATION);
    // ---- Helpers ----
     * aggregations, through the full plan/response round trip.
        // Results computed for a metric named "other"
        assertNotNull(response.getHits());
            } catch (Exception e) {  
                3,
                results.add(new ExecutionResult(plan, List.<Object[]>of(new Object[] { "BrandA", 3L })));
                AggregationBuilders.terms("by_brand")  
        SearchSourceConverter converter = new SearchSourceConverter(infra.schema());
     * User-supplied {@code meta} on an aggregation request must be echoed back verbatim on the
        QueryPlans plans = converter.convert(source, "products");
            goldenFiles = stream.filter(p -> p.toString().endsWith(".json")).collect(Collectors.toList());
                AggregationBuilders.terms("by_brand")
                // Build and serialize SearchResponse  
