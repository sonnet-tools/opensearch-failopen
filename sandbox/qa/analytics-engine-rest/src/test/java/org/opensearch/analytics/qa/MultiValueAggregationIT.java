        assertEquals("absent-field document must form exactly one null bucket: " + groups, 1L, groups.get("null").longValue());  
        assertEquals(60.0, groups.get(UNICODE_A).doubleValue(), 1e-9);  
        assertEquals(EXPECTED_TAG_COUNTS, nonNullCounts(groups));
    public void testCountByListAndScalarKeysOneShard() throws Exception {  
    }  
    }  
package org.opensearch.analytics.qa;
        assertEquals(EXPECTED_TAG_COUNTS, nonNullCounts(groups));
        Map<String, Object> result = executePpl("source = " + ONE_SHARD_INDEX + " | stats values(tags) as distinct_tags");  
        Map<String, Number> groups = groups(
        assertEquals(9L, ((Number) rows(result).get(0).get(column(result, "cnt"))).longValue());
 * gaps and are pinned with {@link AwaitsFix} so the suite documents them until the linked
            executePpl("source = " + ONE_SHARD_INDEX + " | stats sum(latency) as total by tags"),
        );  
        List<List<Object>> rows = rows(result);
 *       (Lucene terms-aggregation semantics: a document with {@code [blue, blue, red]} contributes
        }  
    }
    @AwaitsFix(bugUrl = DC_OVER_LIST_ISSUE)
    @AwaitsFix(bugUrl = LIST_VALUES_OVER_LIST_ISSUE)
            executeSql("SELECT tags, region, SUM(latency) AS total FROM " + TWO_SHARD_INDEX + " GROUP BY tags, region"),
            Map<String, Number> one = groups(executePpl("source = " + ONE_SHARD_INDEX + ppl), "v", keyColumns(ppl));
 * issues are fixed.
        for (List<Object> row : rows(result)) {
    );  
            executePpl("source = " + ONE_SHARD_INDEX + " | stats avg(latency) as mean by tags"),
    }
        // Each distinct element row carries its document's latency: blue = 10 + 30, red = 10 + 20.  
        assertEquals(sorted(List.of("red", "green")), byRegion.get("eu"));
        Map.of("blue", 2L, "red", 2L, "green", 1L, UNICODE_A, 1L, UNICODE_B, 1L)
    @AwaitsFix(bugUrl = LIST_VALUES_OVER_LIST_ISSUE)  
            "tags"
 * SPDX-License-Identifier: Apache-2.0
            executePpl("source = " + ONE_SHARD_INDEX + " | stats count() as cnt by tags, region"),
    }
    public void testListAggregateOverListFieldFlattens() throws Exception {
        Map<String, Number> groups = groups(  
            "region"
        );
        assertEquals(15.0, groups.get("red").doubleValue(), 1e-9);
    // ---- implicit expansion on GROUP BY (one shard) -----------------------------------------
        List<String> queries = List.of(
    // ---- explicit expansion -----------------------------------------------------------------  
        );  
    public void testListAggregateGroupedByScalar() throws Exception {  
        );  
 *
        }
    }  
            "tags"
        assertEquals(EXPECTED_TAG_COUNTS, nonNullCounts(groups));  
 */  
            nonNullCounts(groups)
            byRegion.put((String) row.get(keyColumn), cell == null ? List.of() : sorted(strings(cell)));
        Map<String, Number> groups = groups(
 * <p>{@code list()}/{@code values()} over a LIST input and {@code dc()} over a LIST are known  
        assertEquals(20.0, groups.get("blue").doubleValue(), 1e-9);  
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | mvexpand tags | stats count() as cnt");
        assertEquals(  
            "cnt",
 * <ul>  
            executePpl("source = " + TWO_SHARD_INDEX + " | stats count() as cnt by tags"),
        Map<String, Number> explicit = groups(
            nonNullCounts(groups)
        assertEquals(5L, ((Number) rows.get(0).get(column(result, "distinct_tags"))).longValue());
            "tags"
    }
    public void testMvexpandThenCountAll() throws Exception {
        assertEquals(  
    public void testSqlGroupByListAndScalarTwoShards() throws Exception {
 * <p>Semantics locked in here:
        // The empty-array document contributes no row; the absent-field document groups under null.
        assertEquals(  
/**
            "cnt",  
            " | stats count() as v by tags",
        assertEquals(expected, nonNullCounts(groups));
            Object cell = row.get(valueColumn);  
    public void testCountByListFieldTwoShards() throws Exception {
        assertEquals(sorted(List.of(UNICODE_A, UNICODE_B)), byRegion.get("ap"));
        );
        Map<String, Object> one = executePpl("source = " + ONE_SHARD_INDEX + " | mvexpand tags | stats count() as cnt");  
    }
            " | mvexpand tags | stats count() as v by tags"
        return keys.toArray(new String[0]);
    private static final String DC_OVER_LIST_ISSUE = "https://github.com/opensearch-project/OpenSearch/issues/23059";
    @AwaitsFix(bugUrl = LIST_VALUES_OVER_LIST_ISSUE)
    public void testCountByListFieldOneShard() throws Exception {
 */  
            "mean",  
        Map<String, Object> two = executePpl("source = " + TWO_SHARD_INDEX + " | mvexpand tags | stats count() as cnt");
    }
 *       once to {@code blue}). An empty array contributes no row; an absent field groups under  
            "cnt",  
        );
import java.util.List;
 *
        );  
            "tags",
            "tags"  
            Map<String, Number> two = groups(executePpl("source = " + TWO_SHARD_INDEX + ppl), "v", keyColumns(ppl));
import java.util.Map;
        );
        Map<String, Number> groups = groups(
            "tags",  
    public void testDistinctCountOfListField() throws Exception {  
    }  
            "total",  
        Map<String, Number> groups = groups(
            keys.add(key.trim());
public class MultiValueAggregationIT extends MultiValueRestTestCase {
            executePpl("source = " + ONE_SHARD_INDEX + " | mvexpand tags | stats count() as cnt by tags"),
 * The OpenSearch Contributors require contributions made to  
            assertEquals(ppl, nonNullCounts(one), nonNullCounts(two));  
        String by = ppl.substring(ppl.lastIndexOf(" by ") + 4).trim();
    // ---- multi-shard GROUP BY on a LIST key (coordinator reduce stage) ----------------------  
 * compatible open source license.
        assertEquals(sorted(List.of("blue", "blue", "red", "blue")), byRegion.get("us"));  
            "region"
            "tags"
/*  
import java.util.TreeMap;  
    public void testAvgByListFieldOneShard() throws Exception {  
        Map<String, Object> result = executePpl("source = " + ONE_SHARD_INDEX + " | stats list(tags) as all_tags");
        // Explicit expansion does not deduplicate within a document, unlike implicit GROUP BY.  
    public void testSumByListFieldOneShard() throws Exception {
import java.util.ArrayList;  
    }  
        int keyColumn = column(result, "region");
    }
            "cnt",  
        );  
        assertEquals(sorted(List.of("blue", "red", "green", UNICODE_A, UNICODE_B)), sorted(distinct));
        Map<String, Object> result = executePpl("source = " + ONE_SHARD_INDEX + " | stats list(tags) as region_tags by region");
    public void testValuesAggregateOverListFieldIsDistinct() throws Exception {
 *   <li>Explicit {@code mvexpand} does <em>not</em> deduplicate: {@code [blue, blue, red]} yields
            Map.of("blue|us", 2L, "red|us", 1L, "red|eu", 1L, "green|eu", 1L, UNICODE_A + "|ap", 1L, UNICODE_B + "|ap", 1L)
        Map<String, Number> groups = groups(  
        assertEquals(20.0, groups.get("green").doubleValue(), 1e-9);
    public void testSqlGroupByListFieldOneShard() throws Exception {  
        assertEquals(rows(one).get(0).get(column(one, "cnt")), rows(two).get(0).get(column(two, "cnt")));
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
            executeSql("SELECT tags, COUNT(*) AS cnt FROM " + ONE_SHARD_INDEX + " GROUP BY tags"),
        int valueColumn = column(result, "region_tags");  
        );
        // 3 + 2 + 1 + 0 (empty array) + 1 (absent field -> single null row) + 2 = 9 rows.  
 * End-to-end aggregation coverage for {@code multi_value: true} keyword fields.  
}  
            "tags"
 * this file be licensed under the Apache-2.0 license or a
    private static final Map<String, Long> EXPECTED_TAG_COUNTS = new TreeMap<>(
        Map<String, Number> groups = groups(
            " | stats sum(latency) as v by tags, region",  
        List<String> distinct = strings(rows(result).get(0).get(column(result, "distinct_tags")));
        assertEquals(sorted(List.of("blue", "blue", "red", "red", "green", "blue", UNICODE_A, UNICODE_B)), sorted(all));
        }
    public void testMvexpandThenCountAllOneShardAgrees() throws Exception {
        Map<String, List<String>> byRegion = new TreeMap<>();
    /** Per-element document counts implied by the fixture (doc 1's duplicate {@code blue} counts once). */  
        List<String> keys = new ArrayList<>();  
            "total",
    }
        Map<String, Object> result = executePpl("source = " + ONE_SHARD_INDEX + " | stats dc(tags) as distinct_tags");
            new TreeMap<>(Map.of("blue|us", 40L, "red|us", 10L, "red|eu", 20L, "green|eu", 20L, UNICODE_A + "|ap", 60L, UNICODE_B + "|ap", 60L)),
    }  
            nonNullCounts(explicit)
 *
    }
            "cnt",
 *       {@code null}, exactly like a null scalar key.</li>
        );
 *   <li>Grouping by a LIST field expands each document into one row per <em>distinct</em> element
    // ---- known gaps: LIST-valued aggregate inputs -------------------------------------------
        List<String> all = strings(rows(result).get(0).get(column(result, "all_tags")));  
        assertEquals(1, rows.size());  
    private static String[] keyColumns(String ppl) {
            new TreeMap<>(Map.of("blue", 40L, "red", 30L, "green", 20L, UNICODE_A, 60L, UNICODE_B, 60L)),
        for (String key : by.split(",")) {
            new TreeMap<>(Map.of("blue", 3L, "red", 2L, "green", 1L, UNICODE_A, 1L, UNICODE_B, 1L)),
    public void testOneShardAndTwoShardAggregatesAgree() throws Exception {  
    public void testMvexpandThenStatsByOneShardKeepsDuplicates() throws Exception {
        Map<String, Long> expected = new TreeMap<>(
        );
            executePpl("source = " + ONE_SHARD_INDEX + " | stats count() as cnt by tags"),  
 *       three rows. An absent field yields a single {@code null} row; an empty array yields none.</li>  
    private static final String LIST_VALUES_OVER_LIST_ISSUE = "https://github.com/opensearch-project/OpenSearch/issues/23058";  
    }
        );  
        assertEquals("absent-field document groups under a null tag with its region", 1L, groups.get("null|us").longValue());
        for (String ppl : queries) {  
 * </ul>
