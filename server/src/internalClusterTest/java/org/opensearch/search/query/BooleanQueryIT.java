 * SPDX-License-Identifier: Apache-2.0
        createIndex("test");
            if (i % 2 == 0) {
        int numDocsWithExtraValue = 20;
        );
        );
        }
        int gte = 30;
        assertHitCount(
        // If we don't explicitly set this mapping, term_field_2 is not correctly mapped as a keyword field and queries don't work as
import java.util.ArrayList;
            String termValue1 = "odd";
    private String padZeros(int value, int length) {
            excludedValues.add(secondExcludedValue);
        int minDay = 10;
        waitForRelocation();
    private String getDate(int day, int hour) {
        assertHitCount(client().prepareSearch().setQuery(boolQuery().must(rangeQuery(intField).lt(lt).gt(gt))).get(), expectedHitCount);
            ret = "0".repeat(length - ret.length()) + ret;
                .setQuery(
            }
                        .should(termQuery(termField2, "A"))
/*
        }
 */
import static org.opensearch.index.query.QueryBuilders.termsQuery;
            expectedHitCount / 2
        int numDocs = 100;
        assertHitCount(
    public void testMustNotRangeRewrite() throws Exception {
        String termField2 = "term_field_2";
        // Search excluding range 30 to 50
        String intField = "int_field";
            String termValue2 = "A";
    }
                .setSource(intField, i, termField1, termValue1, termField2, termValue2)
                )
        forceMerge();
        }
import java.util.Arrays;
        if (secondExcludedValue != excludedValue) {
public class BooleanQueryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                        rangeQuery(dateField).gte(getDate(1, 0)).lte(getDate(1, 23)).timeZone("+" + zoneOffset).format(format)
                .get();
                .get(),
            client().prepareSearch().setQuery(boolQuery().mustNot(rangeQuery(intField).lt(lt).gte(gte))).get(),
                .setId(Integer.toString(i))
        );
        );
    }
        createIndex("test");
        waitForRelocation();
        int numDocs = 100;
    }
        expectedHitCount = totalDocs - statusToDocCountMap.get(excludedValue);
    }
 *
            client().prepareSearch().setQuery(boolQuery().should(termQuery(termField1, "even")).should(termQuery(termField2, "B"))).get(),
        // Check we still get expected behavior after rewriting must clauses --> filter clauses.
                client().prepareIndex("test").setId(Integer.toString(i)).setSource(intField, new int[] { extraValue, i }).get();
            expectedHitCount -= statusToDocCountMap.get(secondExcludedValue);
}
        );
                termValue1 = "even";
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
                    boolQuery().should(termQuery(termField1, "even"))
            client().prepareSearch("test")
        int excludedValue = randomFrom(statusToDocCountMap.keySet());
        // Check the rewritten term query behaves as expected
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            }
        // Range queries will match if ANY of the doc's values are within the range.
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        refresh();
            }
        forceMerge();
        waitForRelocation();
            String termValue = "odd";
        String dateField = "date_field";
            if (i >= numDocs / 2) {
        int secondExcludedValue = randomFrom(statusToDocCountMap.keySet());
            expectedHitCount
        forceMerge();
        refresh();
        ensureGreen();
        refresh();
        createIndex(
        super(staticSettings);
        for (int i = 0; i < numDocs; i++) {
        return ret;
    @ParametersFactory
            expectedHitCount
import java.util.Collection;
    public void testMustNotRangeRewriteWithMissingValues() throws Exception {
    public void testMustNotRangeRewriteWithMoreThanOneValue() throws Exception {
            for (int i = 0; i < entry.getValue(); i++) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                client().prepareIndex("test").setId(Integer.toString(i)).setSource(termField, termValue).get();
        List<Integer> excludedValues = new ArrayList<>();
        refresh();
                        .mustNot(rangeQuery(intField).lt(lt).gte(gte))
        );
        assertHitCount(
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        int expectedHitCount = totalDocs - statusToDocCountMap.get(excludedValue);
            expectedHitCount
        refresh();
        assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), numDocs);
        assertHitCount(
    }
    }
        int gte = 20;
        ensureGreen();
        return Arrays.asList(
        // expected
        for (int day = minDay; day <= maxDay; day++) {
        assertHitCount(
    public void testMustNotDateRangeWithFormatAndTimeZoneRewrite() throws Exception {
        waitForRelocation();
                termValue = "even";
        int maxExcludedDay = 25;
        createIndex("test");
        // String.format() not allowed
            } else {
        int expectedHitCount = numDocs - (lt - gte); // Expected hit count includes documents missing this value
        forceMerge();
        // Index a document for each hour of 1/1 in UTC. Then, do a boolean query excluding 1/1 for UTC+3.
        forceMerge();
            client().prepareIndex("test").setId(Integer.toString(i)).setSource(intField, i).get();
        for (int i = 0; i < numDocs; i++) {
            client().prepareSearch("test").setQuery(boolQuery().mustNot(matchQuery(statusField, excludedValue))).get(),
        // even though they also have a value -1 which is not excluded.
        );
            client().prepareSearch()
        for (Map.Entry<Integer, Integer> entry : statusToDocCountMap.entrySet()) {
                )
import java.util.List;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertHitCount(
        int expectedHitCount = maxDay + 1 - minDay - (maxExcludedDay - minExcludedDay + 1);
        int lt = 50;
        String intField = "int_field";
        int numDocs = 100;
        int expectedHitCount = numDocs - (lt - gte);
                client().prepareIndex("test").setId(Integer.toString(i)).setSource(intField, i).get();
        return "2016-01-" + padZeros(day, 2) + "T" + padZeros(hour, 2) + ":00:00.000";
        for (int hour = 0; hour < 24; hour++) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            3 * numDocs / 4
    public static Collection<Object[]> parameters() {
            if (i >= numDocsMissingIntValues) {
            zoneOffset
            client().prepareSearch("test").setQuery(boolQuery().mustNot(termsQuery(statusField, excludedValues))).get(),
        for (int i = 0; i < numDocs; i++) {
                    )
        int totalDocs = 0;
                .get(),
        assertHitCount(
                client().prepareIndex("test").setId(Integer.toString(i)).setSource(intField, i, termField, termValue).get();
            client().prepareSearch().setQuery(boolQuery().mustNot(rangeQuery(intField).lt(lt).gte(gte))).get(),
        refresh();
            "{\"properties\":{\"int_field\":{\"type\": \"integer\"},\"term_field_1\":{\"type\": \"keyword\"},\"term_field_2\":{\"type\": \"keyword\"}}}}"
        Map<Integer, Integer> statusToDocCountMap = Map.of(200, 1000, 404, 30, 500, 1, 400, 1293);
            client().prepareIndex("test").setSource(dateField, getDate(day, 0)).get();
            3 * expectedHitCount / 4
        assertHitCount(
        waitForRelocation();
        );
            client().prepareSearch("test").setQuery(boolQuery().mustNot(termQuery(statusField, excludedValue))).get(),
            expectedHitCount
                .setQuery(
import static org.opensearch.index.query.QueryBuilders.rangeQuery;
        waitForRelocation();
        assertHitCount(
        int zoneOffset = 3;
    }
        createIndex("test");
        ensureGreen();
import java.util.Map;
        int extraValue = -1;
                .setQuery(boolQuery().must(termQuery(termField1, "even")).mustNot(rangeQuery(intField).lt(lt).gte(gte)))
        createIndex("test");
        }
    public void testMustNotDateRangeRewrite() throws Exception {
        // If the time zone is respected by the rewrite, we should see 3 matching documents,
            client().prepareSearch()
        ensureGreen();
        // Test with preexisting should fields, to ensure the original default minimumShouldMatch is respected
                    boolQuery().mustNot(
        refresh();
            Settings.EMPTY,
        assertHitCount(
        int expectedHitCount = lt - gt - 1;
        String dateField = "date_field";
 * compatible open source license.
            expectedHitCount
        );
            expectedHitCount
        int minExcludedDay = 15;
        }
        ensureGreen();
        for (int i = 0; i < numDocs; i++) {
        String format = "strict_date_hour_minute_second_fraction";
        );
            }
import static org.opensearch.index.query.QueryBuilders.boolQuery;
        // This test passes because the rewrite is skipped when not all docs have exactly 1 value
        ensureGreen();
        String statusField = "status";
        );
        String intField = "int_field";
    }
                .get(),
        String termField1 = "term_field_1";
                .setQuery(boolQuery().mustNot(rangeQuery(dateField).gte(getDate(minExcludedDay, 0)).lte(getDate(maxExcludedDay, 0))))
import org.opensearch.common.settings.Settings;
        if (ret.length() < length) {
        String ret = Integer.toString(value);
        forceMerge();
            client().prepareSearch().setQuery(boolQuery().mustNot(rangeQuery(intField).lt(numDocsWithExtraValue).gte(0))).get(),
        int lt = 80;
    }
    }
            if (i < numDocsWithExtraValue) {
            }
        // This test passes because the rewrite is skipped when not all docs have exactly 1 value
import static org.opensearch.index.query.QueryBuilders.termQuery;
                termValue2 = "B";
        waitForRelocation();
            if (i % 2 == 0) {
package org.opensearch.search.query;
        // once we add a must clause during rewrite, even if minimumShouldMatch is not explicitly set
        assertHitCount(
        String termField = "term_field";
        int gt = 22;
        int numDocs = 100;
            client().prepareSearch("test")
        excludedValues.add(excludedValue);
        );
        assertHitCount(client().prepareSearch().setQuery(boolQuery().mustNot(rangeQuery(intField).lt(numDocs * 2))).get(), 0);
        }
        int maxDay = 31;
            totalDocs += entry.getValue();
        createIndex("test");
        // Check the rewritten match query behaves as expected
        forceMerge();
        // So if we exclude the range 0 to 20, we shouldn't see any of those documents returned,
        int lt = 92;
 * The OpenSearch Contributors require contributions made to
                client().prepareIndex("test").setSource(statusField, entry.getKey()).get();
        int numDocsMissingIntValues = 20;
        // Check a rewritten terms query behaves as expected
        );
            "test",
        ensureGreen();
            }
        String intField = "int_field";
            client().prepareIndex("test")
        }
                .get(),
        }
    public void testMustToFilterRewrite() throws Exception {
            expectedHitCount
    public void testMustNotNumericMatchOrTermQueryRewrite() throws Exception {
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        }
        int expectedHitCount = numDocs - numDocsWithExtraValue;
            client().prepareIndex("test").setSource(dateField, getDate(1, hour)).get();
    }
            } else {
        // as there will be 3 hours that are 1/1 in UTC but not UTC+3.
    public BooleanQueryIT(Settings staticSettings) {
