    /** size=0: the COUNT plan total (via CountTotals) supplies the exact match count, like legacy. */
            List.<Object[]>of(new Object[] { "laptop", 999, "BrandA" })  
        assertEquals(2, hits.getHits().length);
        );
    public void testTotalIsExactWhenFewerRowsThanSize() throws Exception {  
    public void testCountTotalsYieldExactTotal() throws Exception {
    /** A short page is a complete result set: total is exact. */
        request.source().trackTotalHitsUpTo(10);  
        request.source(new SearchSourceBuilder().size(size));
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", mapping);
        return new QueryPlans.QueryPlan(QueryPlans.Type.HITS, scan);  
            hitsPlan(mapping),  
        mapping.put("city.name", "VARCHAR");  
            () -> HitsResponseBuilder.buildSourceMap(List.of("name", "name.first"), new Object[] { "laptop", "x" })  
 *
        assertEquals(city, source.get("city"));  
            List.of(new Object[] { "laptop", 999, "BrandA" }, new Object[] { "phone", 699, "BrandB" })  
    public void testNullCellsAreOmitted() throws Exception {
        );
import org.opensearch.dsl.executor.QueryPlans;  
    }
        ExecutionResult aggResult = new ExecutionResult(
        assertEquals(Map.of("name", "laptop"), hits.getHits()[0].getSourceAsMap());  
import org.opensearch.dsl.golden.CalciteTestInfra;
        assertEquals(0, hits.getHits().length);
 * compatible open source license.
        assertEquals(2, hits.getTotalHits().value());
    public void testBuildsHitsFromRows() throws Exception {  
    }
        assertEquals(10L, hits.getTotalHits().value());
        Map<String, String> mapping = new LinkedHashMap<>();
        expectThrows(ConversionException.class, () -> HitsResponseBuilder.build(List.of(result), request(10), null));  
import org.opensearch.action.search.SearchRequest;
        SearchRequest request = new SearchRequest("products");
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.search.builder.SearchSourceBuilder;
    }
    public void testTotalIsLowerBoundWhenPageIsFull() throws Exception {
 * The OpenSearch Contributors require contributions made to  
            List.of(new Object[] { "laptop", 999, "BrandA" }, new Object[] { "phone", 699, "BrandB" })
import java.util.Map;
                new Object[] { "tablet", 499, "BrandC" }  
        ExecutionResult result = new ExecutionResult(
package org.opensearch.dsl.result;
import org.apache.calcite.rel.RelNode;
        assertEquals(0, hits.getHits().length);
            )
        assertEquals(42L, hits.getTotalHits().value());  
                new Object[] { "phone", 699, "BrandB" },
        CalciteTestInfra.InfraResult infra = CalciteTestInfra.buildFromMapping("products", PRODUCTS_MAPPING);  
import org.opensearch.search.internal.SearchContext;
    }
        SearchHits hits = HitsResponseBuilder.build(List.of(), request, new CountTotals(42L, Map.of()));  
import org.opensearch.search.SearchHits;  
        assertEquals(TotalHits.Relation.EQUAL_TO, hits.getTotalHits().relation());  
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(10), null);  
    /** Defensive truncation when the engine returns more rows than size (e.g. missing LIMIT). */
        mapping.put("city.location.lat", "DOUBLE");
    }
        return request;  
            List.<Object[]>of(new Object[] { "BrandA", 3, "x" })
    private static final Map<String, String> PRODUCTS_MAPPING = productsMapping();
    }
        SearchHits hits = HitsResponseBuilder.build(List.of(aggResult), request(10), null);
        ExecutionResult result = new ExecutionResult(hitsPlan(PRODUCTS_MAPPING), List.<Object[]>of(new Object[] { "laptop", null, null }));
        );
        );
        mapping.put("name", "VARCHAR");  
import org.apache.calcite.rel.logical.LogicalTableScan;
        request.source().trackTotalHitsUpTo(SearchContext.TRACK_TOTAL_HITS_DISABLED);
    }  
    public void testRowCellCountMismatchThrows() {  
        assertEquals(TotalHits.Relation.EQUAL_TO, hits.getTotalHits().relation());
        SearchHits hits = HitsResponseBuilder.build(List.of(), request, new CountTotals(42L, Map.of()));
    }
        assertNull(hits.getTotalHits());
        assertEquals(3, hits.getTotalHits().value());
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(10), null);  
    public void testTrackingDisabledOmitsTotal() throws Exception {
        ExecutionResult result = new ExecutionResult(hitsPlan(PRODUCTS_MAPPING), List.<Object[]>of(new Object[] { "laptop", 999 }));
    }
        assertEquals(2, hits.getHits().length);  
public class HitsResponseBuilderTests extends OpenSearchTestCase {  
    public void testTruncatesRowsBeyondSize() throws Exception {  
            List.<Object[]>of(new Object[] { "store1", 47.6, -122.3, "Seattle" })
    private static SearchRequest request(int size) {  
        ExecutionResult result = new ExecutionResult(
        assertEquals(2, hits.getHits().length);  
        mapping.put("name", "VARCHAR");  
        assertEquals(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO, hits.getTotalHits().relation());  
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(10), null);
    private static Map<String, String> productsMapping() {
        );
        assertEquals(0, hits.getHits().length);  
        return mapping;  
    }
        SearchRequest request = request(0);
                new Object[] { "laptop", 999, "BrandA" },
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(10), null);
        SearchHit first = hits.getHits()[0];  
    }  
    /** Object fields arrive flattened as dotted columns and must be re-nested in _source. */  
    /** Null cells are omitted: absent vs explicit null is indistinguishable after the columnar round trip. */  
    public void testIgnoresAggregationResults() throws Exception {
        assertEquals(Map.of("name", "phone", "price", 699, "brand", "BrandB"), hits.getHits()[1].getSourceAsMap());
        RelNode scan = LogicalTableScan.create(infra.cluster(), infra.table(), List.of());
    }
}  
        );
        SearchRequest request = request(0);  
            hitsPlan(PRODUCTS_MAPPING),
    public void testCountTotalsClampedAtTrackTotalHitsThreshold() throws Exception {
        RelNode scan = LogicalTableScan.create(infra.cluster(), infra.table(), List.of());
import org.apache.lucene.search.TotalHits;  
        assertTrue(Float.isNaN(hits.getMaxScore()));
    public void testDottedColumnsAreReNested() throws Exception {
import java.util.LinkedHashMap;
            hitsPlan(PRODUCTS_MAPPING),
        mapping.put("brand", "VARCHAR");
        expectThrows(
 */  
        Map<String, String> mapping = new LinkedHashMap<>();
        assertEquals(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO, hits.getTotalHits().relation());
        assertNull("engine schema exposes no _id yet", first.getId());
        assertEquals(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO, hits.getTotalHits().relation());  
        ExecutionResult result = new ExecutionResult(
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(2), null);
            List.of(  
            hitsPlan(PRODUCTS_MAPPING),  
    }  
    /** A full page may have been cut off by the plan's LIMIT: total is a lower bound. */  
    /** No HITS result and no COUNT result (older plans): empty hits with an unknown ("at least 0") total. */  
        SearchHits hits = HitsResponseBuilder.build(List.of(), request(0), null);
        mapping.put("price", "INTEGER");
        SearchHits hits = HitsResponseBuilder.build(List.of(), request(0), new CountTotals(42L, Map.of()));  
        ExecutionResult result = new ExecutionResult(
    private static QueryPlans.QueryPlan hitsPlan(Map<String, String> mapping) {  
        assertTrue(Float.isNaN(hits.getMaxScore()));
import org.opensearch.dsl.converter.ConversionException;
import org.opensearch.search.SearchHit;
        assertEquals(TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO, hits.getTotalHits().relation());
            hitsPlan(PRODUCTS_MAPPING),
        assertEquals(1, hits.getTotalHits().value());
        SearchHits hits = HitsResponseBuilder.build(List.of(result), request(2), null);
    }
        assertEquals("laptop", hits.getHits()[0].getSourceAsMap().get("name"));
        mapping.put("city.location.lon", "DOUBLE");
        assertEquals(0, hits.getTotalHits().value());
            new QueryPlans.QueryPlan(QueryPlans.Type.AGGREGATION, scan, null),  
    public void testDottedColumnConflictingWithScalarThrows() {  
        assertEquals("store1", source.get("name"));
/*  
import java.util.List;  
    public void testNoHitsResultYieldsEmptyHits() throws Exception {
    }
        Map<String, Object> source = hits.getHits()[0].getSourceAsMap();  
        assertTrue("no relevance scoring on the analytics path", Float.isNaN(first.getScore()));
        );
        ExecutionResult result = new ExecutionResult(
    }  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(Map.of("name", "laptop", "price", 999, "brand", "BrandA"), first.getSourceAsMap());  
            ConversionException.class,
        Map<String, Object> city = Map.of("location", Map.of("lat", 47.6, "lon", -122.3), "name", "Seattle");
 * SPDX-License-Identifier: Apache-2.0
