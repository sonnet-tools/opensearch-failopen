        assertEquals(10L, hits.getTotalHits().value());
import java.util.List;
        SearchRequest request = request(0);
        );
        Map<String, Object> city = Map.of("location", Map.of("lat", 47.6, "lon", -122.3), "name", "Seattle");
        assertEquals(TotalHits.Relation.EQUAL_TO, hits.getTotalHits().relation());
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(2), null);
    }
        assertTrue("no relevance scoring on the analytics path", Float.isNaN(first.getScore()));
            hitsPlan(PRODUCTS_MAPPING),
    }
        assertEquals(Map.of("name", "phone", "price", 699, "brand", "BrandB"), hits.getHits()[1].getSourceAsMap());
    /** Defensive truncation when the engine returns more rows than size (e.g. missing LIMIT). */
    private static SearchRequest request(int size) {
    public void testIgnoresAggregationResults() throws Exception {
    public void testRowCellCountMismatchThrows() {
            hitsPlan(PRODUCTS_MAPPING),
        return mapping;
            List.<Object[]>of(new Object[] { "BrandA", 3, "x" })
        assertEquals(42L, hits.getTotalHits().value());
            hitsPlan(mapping),
            List.of(new Object[] { "laptop", 999, "BrandA" }, new Object[] { "phone", 699, "BrandB" })
        mapping.put("city.location.lat", "DOUBLE");
    public void testTotalIsExactWhenFewerRowsThanSize() throws Exception {
    public void testNullCellsAreOmitted() throws Exception {
        ExecutionResult result = new ExecutionResult(hitsPlan(PRODUCTS_MAPPING), List.<Object[]>of(new Object[] { "laptop", null, null }));
        expectThrows(ConversionException.class, () -> HitsResponseBuilder.build(List.of(result), request(10), null));
            ConversionException.class,
        assertEquals(0, hits.getTotalHits().value());
import org.apache.calcite.rel.RelNode;
        assertEquals(1, hits.getTotalHits().value());
import org.apache.lucene.search.TotalHits;
    }
        );
        mapping.put("price", "INTEGER");
        expectThrows(
        assertEquals(Map.of("name", "laptop", "price", 999, "brand", "BrandA"), first.getSourceAsMap());
        ExecutionResult result = new ExecutionResult(
        assertEquals(2, hits.getHits().length);
        assertEquals(0, hits.getHits().length);
        return new QueryPlans.QueryPlan(QueryPlans.Type.HITS, scan);
        assertEquals(2, hits.getHits().length);
 * this file be licensed under the Apache-2.0 license or a
        ExecutionResult aggResult = new ExecutionResult(
        SearchHits hits = HitsResponseBuilder.build(List.of(), request(0), null);
        SearchRequest request = new SearchRequest("products");
        SearchRequest request = request(0);
import org.opensearch.search.SearchHits;
    public void testBuildsHitsFromRows() throws Exception {
import org.opensearch.search.SearchHit;
    /** No HITS result and no COUNT result (older plans): empty hits with an unknown ("at least 0") total. */
    /** Null cells are omitted: absent vs explicit null is indistinguishable after the columnar round trip. */
    }
            List.<Object[]>of(new Object[] { "laptop", 999, "BrandA" })
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
    }
import org.opensearch.search.internal.SearchContext;
        mapping.put("brand", "VARCHAR");
        ExecutionResult result = new ExecutionResult(
            List.of(
    /** Object fields arrive flattened as dotted columns and must be re-nested in _source. */
    }
        request.source(new SearchSourceBuilder().size(size));
        SearchHits hits = HitsResponseBuilder.build(List.of(), request(0), new CountTotals(42L, Map.of()));
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(10), null);
        Map<String, Object> source = hits.getHits()[0].getSourceAsMap();
    /** size=0: the COUNT plan total (via CountTotals) supplies the exact match count, like legacy. */
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(10), null);
        ExecutionResult result = new ExecutionResult(hitsPlan(PRODUCTS_MAPPING), List.<Object[]>of(new Object[] { "laptop", 999 }));
    }
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", PRODUCTS_MAPPING);
        Map<String, String> mapping = new LinkedHashMap<>();
            () -> HitsResponseBuilder.buildSourceMap(List.of("name", "name.first"), new Object[] { "laptop", "x" })
        SearchHits hits = HitsResponseBuilder.build(List.of(aggResult), request(10), null);
        assertTrue(Float.isNaN(hits.getMaxScore()));
import org.opensearch.test.OpenSearchTestCase;
    public void testCountTotalsClampedAtTrackTotalHitsThreshold() throws Exception {
    }
    public void testNoHitsResultYieldsEmptyHits() throws Exception {
        assertEquals(2, hits.getTotalHits().value());
    public void testTruncatesRowsBeyondSize() throws Exception {
    private static Map<String, String> productsMapping() {
    private static QueryPlans.QueryPlan hitsPlan(Map<String, String> mapping) {
        assertEquals(0, hits.getHits().length);
        assertEquals(0, hits.getHits().length);
            List.of(new Object[] { "laptop", 999, "BrandA" }, new Object[] { "phone", 699, "BrandB" })
        RelNode scan = LogicalTableScan.create(infra.cluster(), infra.table(), List.of());
    }
    /** A short page is a complete result set: total is exact. */
        assertEquals("laptop", hits.getHits()[0].getSourceAsMap().get("name"));
            List.<Object[]>of(new Object[] { "store1", 47.6, -122.3, "Seattle" })
                new Object[] { "laptop", 999, "BrandA" },
        request.source().trackTotalHitsUpTo(10);
        request.source().trackTotalHitsUpTo(SearchContext.TRACK_TOTAL_HITS_DISABLED);
import org.opensearch.dsl.converter.ConversionException;
package org.opensearch.dsl.result;
        SearchHit first = hits.getHits()[0];
    /** A full page may have been cut off by the plan's LIMIT: total is a lower bound. */
            new QueryPlans.QueryPlan(QueryPlans.Type.AGGREGATION, scan, null),
import org.apache.calcite.rel.logical.LogicalTableScan;
                new Object[] { "phone", 699, "BrandB" },
        assertEquals(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO, hits.getTotalHits().relation());
    }
 * The OpenSearch Contributors require contributions made to
        SearchHits hits = HitsResponseBuilder.build(List.of(), request, new CountTotals(42L, Map.of()));
        assertNull(hits.getTotalHits());
    private static final Map<String, String> PRODUCTS_MAPPING = productsMapping();
        RelNode scan = LogicalTableScan.create(infra.cluster(), infra.table(), List.of());
        );
        return request;
        assertNull("engine schema exposes no _id yet", first.getId());
        assertEquals(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO, hits.getTotalHits().relation());
    }
    }
        );
        assertEquals("store1", source.get("name"));
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(2), null);
    }
    public void testTrackingDisabledOmitsTotal() throws Exception {
public class HitsResponseBuilderTests extends OpenSearchTestCase {
import org.opensearch.search.builder.SearchSourceBuilder;
import org.opensearch.action.search.SearchRequest;
        mapping.put("name", "VARCHAR");
            hitsPlan(PRODUCTS_MAPPING),
    public void testDottedColumnsAreReNested() throws Exception {
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(10), null);
        );
            hitsPlan(PRODUCTS_MAPPING),
        assertEquals(2, hits.getHits().length);
        assertTrue(Float.isNaN(hits.getMaxScore()));
    public void testDottedColumnConflictingWithScalarThrows() {
        Map<String, String> mapping = new LinkedHashMap<>();
        assertEquals(Map.of("name", "laptop"), hits.getHits()[0].getSourceAsMap());
        ExecutionResult result = new ExecutionResult(
        SearchHits hits = HitsResponseBuilder.build(List.of(), request, new CountTotals(42L, Map.of()));
        assertEquals(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO, hits.getTotalHits().relation());
import org.opensearch.dsl.executor.QueryPlans;
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(10), null);
    public void testCountTotalsYieldExactTotal() throws Exception {
                new Object[] { "tablet", 499, "BrandC" }
        mapping.put("city.location.lon", "DOUBLE");
            )
import java.util.LinkedHashMap;
        assertEquals(city, source.get("city"));
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
    }
        mapping.put("name", "VARCHAR");
import java.util.Map;
    public void testTotalIsLowerBoundWhenPageIsFull() throws Exception {
        mapping.put("city.name", "VARCHAR");
/*
        assertEquals(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO, hits.getTotalHits().relation());
    }
 *
        );
    }
        );
        assertEquals(TotalHits.Relation.EQUAL_TO, hits.getTotalHits().relation());
        ExecutionResult result = new ExecutionResult(
        ExecutionResult result = new ExecutionResult(
import org.opensearch.dsl.golden.CalciteTestInfra;
}
        assertEquals(3, hits.getTotalHits().value());
 */
