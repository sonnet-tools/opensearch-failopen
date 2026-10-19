        Map<String, Number> explicit = groups(
    public void testDistinctCountOfListField() throws Exception {
        Map<String, Number> groups = groups(
            "tags"
        int keyColumn = column(result, "region");
    public void testSqlGroupByListAndScalarTwoShards() throws Exception {
        int valueColumn = column(result, "region_tags");
            new TreeMap<>(Map.of("blue", 40L, "red", 30L, "green", 20L, UNICODE_A, 60L, UNICODE_B, 60L)),
        }
    public void testCountByListFieldOneShard() throws Exception {
        Map<String, Long> expected = new TreeMap<>(
        );
        );
        Map<String, Object> one = executePpl("source = " + ONE_SHARD_INDEX + " | mvexpand tags | stats count() as cnt");
    }
        Map<String, List<String>> byRegion = new TreeMap<>();
            keys.add(key.trim());
    /** Per-element document counts implied by the fixture (doc 1's duplicate {@code blue} counts once). */
        // Each distinct element row carries its document's latency: blue = 10 + 30, red = 10 + 20.
 * End-to-end aggregation coverage for {@code multi_value: true} keyword fields.
    public void testAvgByListFieldOneShard() throws Exception {
        assertEquals(
        Map<String, Object> result = executePpl("source = " + ONE_SHARD_INDEX + " | stats list(tags) as all_tags");
    }
        assertEquals(expected, nonNullCounts(groups));
        );
    // ---- explicit expansion -----------------------------------------------------------------
            nonNullCounts(groups)
        for (String ppl : queries) {
    public void testMvexpandThenCountAll() throws Exception {
    private static final Map<String, Long> EXPECTED_TAG_COUNTS = new TreeMap<>(
            new TreeMap<>(Map.of("blue", 3L, "red", 2L, "green", 1L, UNICODE_A, 1L, UNICODE_B, 1L)),
    );
        // Explicit expansion does not deduplicate within a document, unlike implicit GROUP BY.
 *       {@code null}, exactly like a null scalar key.</li>
            "tags",
        for (List<Object> row : rows(result)) {
    }
 * The OpenSearch Contributors require contributions made to
        );
 */
            nonNullCounts(explicit)
    // ---- multi-shard GROUP BY on a LIST key (coordinator reduce stage) ----------------------
            " | stats count() as v by tags",
            Map<String, Number> one = groups(executePpl("source = " + ONE_SHARD_INDEX + ppl), "v", keyColumns(ppl));
        assertEquals(20.0, groups.get("blue").doubleValue(), 1e-9);
        assertEquals(20.0, groups.get("green").doubleValue(), 1e-9);
        Map<String, Object> result = executePpl("source = " + TWO_SHARD_INDEX + " | mvexpand tags | stats count() as cnt");
    public void testListAggregateOverListFieldFlattens() throws Exception {
        for (String key : by.split(",")) {
        assertEquals("absent-field document must form exactly one null bucket: " + groups, 1L, groups.get("null").longValue());
        assertEquals("absent-field document groups under a null tag with its region", 1L, groups.get("null|us").longValue());
        assertEquals(EXPECTED_TAG_COUNTS, nonNullCounts(groups));
    }
    public void testListAggregateGroupedByScalar() throws Exception {
import org.apache.lucene.tests.util.LuceneTestCase.AwaitsFix;
        assertEquals(60.0, groups.get(UNICODE_A).doubleValue(), 1e-9);
        assertEquals(1, rows.size());
/*
        );
            "cnt",
            executePpl("source = " + TWO_SHARD_INDEX + " | stats count() as cnt by tags"),
    public void testCountByListAndScalarKeysOneShard() throws Exception {
        }
        Map<String, Number> groups = groups(
            "cnt",
    // ---- known gaps: LIST-valued aggregate inputs -------------------------------------------
        assertEquals(sorted(List.of("blue", "red", "green", UNICODE_A, UNICODE_B)), sorted(distinct));
    public void testCountByListFieldTwoShards() throws Exception {
    // ---- implicit expansion on GROUP BY (one shard) -----------------------------------------
        Map<String, Number> groups = groups(
 * <ul>
        );
            Map.of("blue|us", 2L, "red|us", 1L, "red|eu", 1L, "green|eu", 1L, UNICODE_A + "|ap", 1L, UNICODE_B + "|ap", 1L)
        Map<String, Number> groups = groups(
    }
    public void testSqlGroupByListFieldOneShard() throws Exception {
        assertEquals(EXPECTED_TAG_COUNTS, nonNullCounts(groups));
    }
    }
        Map<String, Number> groups = groups(
        );
        Map<String, Number> groups = groups(
        assertEquals(EXPECTED_TAG_COUNTS, nonNullCounts(groups));
 * issues are fixed.
 * compatible open source license.
    }
    @AwaitsFix(bugUrl = LIST_VALUES_OVER_LIST_ISSUE)
 * SPDX-License-Identifier: Apache-2.0
    @AwaitsFix(bugUrl = LIST_VALUES_OVER_LIST_ISSUE)
        assertEquals(5L, ((Number) rows.get(0).get(column(result, "distinct_tags"))).longValue());
        assertEquals(sorted(List.of("red", "green")), byRegion.get("eu"));
            " | mvexpand tags | stats count() as v by tags"
        // 3 + 2 + 1 + 0 (empty array) + 1 (absent field -> single null row) + 2 = 9 rows.
    private static String[] keyColumns(String ppl) {
            executePpl("source = " + ONE_SHARD_INDEX + " | stats avg(latency) as mean by tags"),
            new TreeMap<>(Map.of("blue|us", 40L, "red|us", 10L, "red|eu", 20L, "green|eu", 20L, UNICODE_A + "|ap", 60L, UNICODE_B + "|ap", 60L)),
        assertEquals(9L, ((Number) rows(result).get(0).get(column(result, "cnt"))).longValue());
        assertEquals(
    }
        );
        assertEquals(sorted(List.of("blue", "blue", "red", "blue")), byRegion.get("us"));
 *
        assertEquals(sorted(List.of(UNICODE_A, UNICODE_B)), byRegion.get("ap"));
        String by = ppl.substring(ppl.lastIndexOf(" by ") + 4).trim();
        List<String> keys = new ArrayList<>();
        List<List<Object>> rows = rows(result);
        List<String> distinct = strings(rows(result).get(0).get(column(result, "distinct_tags")));
    }
 *       once to {@code blue}). An empty array contributes no row; an absent field groups under
        Map<String, Object> result = executePpl("source = " + ONE_SHARD_INDEX + " | stats list(tags) as region_tags by region");
 *       (Lucene terms-aggregation semantics: a document with {@code [blue, blue, red]} contributes
    @AwaitsFix(bugUrl = DC_OVER_LIST_ISSUE)
 *
            "cnt",
            "tags"
 * </ul>
 * <p>{@code list()}/{@code values()} over a LIST input and {@code dc()} over a LIST are known
    }
            executeSql("SELECT tags, region, SUM(latency) AS total FROM " + TWO_SHARD_INDEX + " GROUP BY tags, region"),
        }
        assertEquals(rows(one).get(0).get(column(one, "cnt")), rows(two).get(0).get(column(two, "cnt")));
            executePpl("source = " + ONE_SHARD_INDEX + " | stats count() as cnt by tags"),
            executePpl("source = " + ONE_SHARD_INDEX + " | stats count() as cnt by tags, region"),
import java.util.ArrayList;
    }
import java.util.List;
    public void testValuesAggregateOverListFieldIsDistinct() throws Exception {
    private static final String DC_OVER_LIST_ISSUE = "https://github.com/opensearch-project/OpenSearch/issues/23059";
 *   <li>Explicit {@code mvexpand} does <em>not</em> deduplicate: {@code [blue, blue, red]} yields
/**
    }
            Map<String, Number> two = groups(executePpl("source = " + TWO_SHARD_INDEX + ppl), "v", keyColumns(ppl));
            nonNullCounts(groups)
        assertEquals(
        Map.of("blue", 2L, "red", 2L, "green", 1L, UNICODE_A, 1L, UNICODE_B, 1L)
        );
 *       three rows. An absent field yields a single {@code null} row; an empty array yields none.</li>
        );
 * <p>Semantics locked in here:
        // The empty-array document contributes no row; the absent-field document groups under null.
 *   <li>Grouping by a LIST field expands each document into one row per <em>distinct</em> element
package org.opensearch.analytics.qa;
        Map<String, Object> two = executePpl("source = " + TWO_SHARD_INDEX + " | mvexpand tags | stats count() as cnt");
            "tags"
            byRegion.put((String) row.get(keyColumn), cell == null ? List.of() : sorted(strings(cell)));
            "cnt",
        assertEquals(sorted(List.of("blue", "blue", "red", "red", "green", "blue", UNICODE_A, UNICODE_B)), sorted(all));
        );
        List<String> all = strings(rows(result).get(0).get(column(result, "all_tags")));
    public void testMvexpandThenCountAllOneShardAgrees() throws Exception {
 *
            "tags"
            executePpl("source = " + ONE_SHARD_INDEX + " | mvexpand tags | stats count() as cnt by tags"),
 * gaps and are pinned with {@link AwaitsFix} so the suite documents them until the linked
            " | stats sum(latency) as v by tags, region",
    }
            "mean",
            "cnt",
            "region"
import java.util.Map;
public class MultiValueAggregationIT extends MultiValueRestTestCase {
            "tags"
        List<String> queries = List.of(
}
            Object cell = row.get(valueColumn);
    @AwaitsFix(bugUrl = LIST_VALUES_OVER_LIST_ISSUE)
            "tags"
            "region"
 */
            "total",
        return keys.toArray(new String[0]);
    private static final String LIST_VALUES_OVER_LIST_ISSUE = "https://github.com/opensearch-project/OpenSearch/issues/23058";
import java.util.TreeMap;
        );
    public void testMvexpandThenStatsByOneShardKeepsDuplicates() throws Exception {
    public void testOneShardAndTwoShardAggregatesAgree() throws Exception {
    }
            "tags",
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(15.0, groups.get("red").doubleValue(), 1e-9);
        );
        Map<String, Number> groups = groups(
        Map<String, Object> result = executePpl("source = " + ONE_SHARD_INDEX + " | stats dc(tags) as distinct_tags");
            assertEquals(ppl, nonNullCounts(one), nonNullCounts(two));
            executePpl("source = " + ONE_SHARD_INDEX + " | stats sum(latency) as total by tags"),
            "total",
    public void testSumByListFieldOneShard() throws Exception {
        Map<String, Object> result = executePpl("source = " + ONE_SHARD_INDEX + " | stats values(tags) as distinct_tags");
            executeSql("SELECT tags, COUNT(*) AS cnt FROM " + ONE_SHARD_INDEX + " GROUP BY tags"),
