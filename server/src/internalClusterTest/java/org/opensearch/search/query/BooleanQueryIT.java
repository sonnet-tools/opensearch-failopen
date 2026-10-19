            }
    }
        int totalDocs = 0;  
            client().prepareSearch("test")
        int minExcludedDay = 15;
public class BooleanQueryIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                .get(),  
            expectedHitCount
    }
        }
        assertHitCount(
        // even though they also have a value -1 which is not excluded.
            String termValue2 = "A";
            }
    private String padZeros(int value, int length) {  
        refresh();
        // once we add a must clause during rewrite, even if minimumShouldMatch is not explicitly set  
        forceMerge();
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
    }  
        int secondExcludedValue = randomFrom(statusToDocCountMap.keySet());  
        int numDocsMissingIntValues = 20;
                )
            expectedHitCount  
            }
import java.util.List;  
        refresh();  
        String format = "strict_date_hour_minute_second_fraction";  
        String ret = Integer.toString(value);
        assertHitCount(client().prepareSearch().setQuery(boolQuery().must(rangeQuery(intField).lt(lt).gt(gt))).get(), expectedHitCount);  
        int expectedHitCount = numDocs - numDocsWithExtraValue;  
        // If we don't explicitly set this mapping, term_field_2 is not correctly mapped as a keyword field and queries don't work as  
            client().prepareSearch("test")  
        }
        int numDocs = 100;
 * this file be licensed under the Apache-2.0 license or a
    public static Collection<Object[]> parameters() {
            "{\"properties\":{\"int_field\":{\"type\": \"integer\"},\"term_field_1\":{\"type\": \"keyword\"},\"term_field_2\":{\"type\": \"keyword\"}}}}"
        String statusField = "status";
 * The OpenSearch Contributors require contributions made to  
        ensureGreen();
        );
        super(staticSettings);  
                .setQuery(boolQuery().mustNot(rangeQuery(dateField).gte(getDate(minExcludedDay, 0)).lte(getDate(maxExcludedDay, 0))))
        forceMerge();
        String dateField = "date_field";
        for (int i = 0; i < numDocs; i++) {  
        String intField = "int_field";
        // So if we exclude the range 0 to 20, we shouldn't see any of those documents returned,  
        createIndex("test");
            client().prepareSearch("test").setQuery(boolQuery().mustNot(termQuery(statusField, excludedValue))).get(),
        int excludedValue = randomFrom(statusToDocCountMap.keySet());  
            client().prepareIndex("test").setSource(dateField, getDate(day, 0)).get();
    public void testMustToFilterRewrite() throws Exception {
        refresh();
        }
        assertHitCount(
            expectedHitCount -= statusToDocCountMap.get(secondExcludedValue);
            }
            if (i >= numDocsMissingIntValues) {
            totalDocs += entry.getValue();
import java.util.Map;
}  
 * compatible open source license.
        return Arrays.asList(
        );
        assertHitCount(
        ensureGreen();
 */  
        // Check we still get expected behavior after rewriting must clauses --> filter clauses.
        int gte = 30;  
                client().prepareIndex("test").setId(Integer.toString(i)).setSource(termField, termValue).get();
                .get(),  
        int numDocs = 100;
        );
            } else {  
            client().prepareSearch().setQuery(boolQuery().mustNot(rangeQuery(intField).lt(lt).gte(gte))).get(),  
        );
        // expected
        createIndex("test");
        List<Integer> excludedValues = new ArrayList<>();
        String termField1 = "term_field_1";
        if (ret.length() < length) {  
        createIndex("test");
                    boolQuery().should(termQuery(termField1, "even"))
    public void testMustNotDateRangeWithFormatAndTimeZoneRewrite() throws Exception {
        // If the time zone is respected by the rewrite, we should see 3 matching documents,
/*  
        );  
        assertHitCount(  
                .setSource(intField, i, termField1, termValue1, termField2, termValue2)
        }  
        forceMerge();  
        );
                    boolQuery().mustNot(
            3 * expectedHitCount / 4
        // as there will be 3 hours that are 1/1 in UTC but not UTC+3.
import java.util.ArrayList;  
            expectedHitCount  
        );
    }  
        forceMerge();
            if (i % 2 == 0) {  
        return ret;  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        for (int i = 0; i < numDocs; i++) {
        int gte = 20;
    @ParametersFactory  
    public void testMustNotRangeRewriteWithMissingValues() throws Exception {
        for (Map.Entry<Integer, Integer> entry : statusToDocCountMap.entrySet()) {
        }  
    public void testMustNotNumericMatchOrTermQueryRewrite() throws Exception {
import static org.opensearch.index.query.QueryBuilders.termQuery;
        );
        // Test with preexisting should fields, to ensure the original default minimumShouldMatch is respected
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        int expectedHitCount = maxDay + 1 - minDay - (maxExcludedDay - minExcludedDay + 1);
            client().prepareIndex("test")  
        refresh();
        );  
        }
                        .mustNot(rangeQuery(intField).lt(lt).gte(gte))
            client().prepareSearch("test").setQuery(boolQuery().mustNot(termsQuery(statusField, excludedValues))).get(),
    }
    }
                .setQuery(
        refresh();  
        ensureGreen();  
        for (int hour = 0; hour < 24; hour++) {
        // This test passes because the rewrite is skipped when not all docs have exactly 1 value  
                        rangeQuery(dateField).gte(getDate(1, 0)).lte(getDate(1, 23)).timeZone("+" + zoneOffset).format(format)  
                    )
        forceMerge();  
        // String.format() not allowed
    }  
        // Index a document for each hour of 1/1 in UTC. Then, do a boolean query excluding 1/1 for UTC+3.  
        assertHitCount(
import static org.opensearch.index.query.QueryBuilders.termsQuery;
        int lt = 80;
        int maxExcludedDay = 25;  
        ensureGreen();
        int numDocs = 100;
        // Check the rewritten match query behaves as expected  
        waitForRelocation();  
        // This test passes because the rewrite is skipped when not all docs have exactly 1 value
                .get(),  
        forceMerge();  
    }
        int expectedHitCount = numDocs - (lt - gte); // Expected hit count includes documents missing this value
        waitForRelocation();  
        assertHitCount(
        int numDocs = 100;
        createIndex("test");
            client().prepareSearch()  
                .get();  
        createIndex("test");  
        int gt = 22;  
        String dateField = "date_field";
            client().prepareIndex("test").setSource(dateField, getDate(1, hour)).get();  
        String intField = "int_field";  
        assertHitCount(
            Settings.EMPTY,
        waitForRelocation();
                        .should(termQuery(termField2, "A"))  
        String termField2 = "term_field_2";
        if (secondExcludedValue != excludedValue) {
    }
                termValue1 = "even";
 * SPDX-License-Identifier: Apache-2.0
            client().prepareIndex("test").setId(Integer.toString(i)).setSource(intField, i).get();
                client().prepareIndex("test").setId(Integer.toString(i)).setSource(intField, i).get();  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        ensureGreen();
            if (i % 2 == 0) {  
            if (i < numDocsWithExtraValue) {  
        int numDocsWithExtraValue = 20;
        waitForRelocation();
            expectedHitCount  
        // Range queries will match if ANY of the doc's values are within the range.
        assertHitCount(
        int expectedHitCount = numDocs - (lt - gte);  
        waitForRelocation();
    public void testMustNotRangeRewriteWithMoreThanOneValue() throws Exception {  
import java.util.Arrays;
            String termValue = "odd";
        assertHitCount(
        waitForRelocation();
        int lt = 50;
            excludedValues.add(secondExcludedValue);  
            expectedHitCount  
        );
        int extraValue = -1;  
                termValue2 = "B";
            client().prepareSearch().setQuery(boolQuery().should(termQuery(termField1, "even")).should(termQuery(termField2, "B"))).get(),
            }
        String termField = "term_field";
            "test",  
        forceMerge();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        );
                client().prepareIndex("test").setSource(statusField, entry.getKey()).get();  
import static org.opensearch.index.query.QueryBuilders.boolQuery;  
            client().prepareSearch("test").setQuery(boolQuery().mustNot(matchQuery(statusField, excludedValue))).get(),
        expectedHitCount = totalDocs - statusToDocCountMap.get(excludedValue);
            expectedHitCount
    public void testMustNotDateRangeRewrite() throws Exception {
            expectedHitCount
package org.opensearch.search.query;
        assertHitCount(  
        int expectedHitCount = totalDocs - statusToDocCountMap.get(excludedValue);
        assertHitCount(client().prepareSearch().setQuery(boolQuery().mustNot(rangeQuery(intField).lt(numDocs * 2))).get(), 0);
            }
                .get(),
import org.opensearch.common.settings.Settings;  
        }
        // Search excluding range 30 to 50  
        int lt = 92;
        int expectedHitCount = lt - gt - 1;
                )
        waitForRelocation();
    private String getDate(int day, int hour) {  
                .setQuery(boolQuery().must(termQuery(termField1, "even")).mustNot(rangeQuery(intField).lt(lt).gte(gte)))  
    }  
                .setQuery(
    }
                .setId(Integer.toString(i))
        Map<Integer, Integer> statusToDocCountMap = Map.of(200, 1000, 404, 30, 500, 1, 400, 1293);  
        }  
        int minDay = 10;
        // Check a rewritten terms query behaves as expected  
        for (int day = minDay; day <= maxDay; day++) {  
                client().prepareIndex("test").setId(Integer.toString(i)).setSource(intField, new int[] { extraValue, i }).get();
    public void testMustNotRangeRewrite() throws Exception {
            client().prepareSearch().setQuery(boolQuery().mustNot(rangeQuery(intField).lt(lt).gte(gte))).get(),
        assertHitCount(
        assertHitCount(client().prepareSearch().setQuery(matchAllQuery()).get(), numDocs);
        String intField = "int_field";
            if (i >= numDocs / 2) {  
        int zoneOffset = 3;
        return "2016-01-" + padZeros(day, 2) + "T" + padZeros(hour, 2) + ":00:00.000";
        // Check the rewritten term query behaves as expected  
        );  
            } else {
        for (int i = 0; i < numDocs; i++) {
            String termValue1 = "odd";
        ensureGreen();  
        ensureGreen();
        }
        createIndex(
            for (int i = 0; i < entry.getValue(); i++) {
 *
        );
            expectedHitCount / 2
        for (int i = 0; i < numDocs; i++) {
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
            3 * numDocs / 4  
            client().prepareSearch().setQuery(boolQuery().mustNot(rangeQuery(intField).lt(numDocsWithExtraValue).gte(0))).get(),
            client().prepareSearch()
            ret = "0".repeat(length - ret.length()) + ret;
import java.util.Collection;
                termValue = "even";
import static org.opensearch.index.query.QueryBuilders.rangeQuery;  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        excludedValues.add(excludedValue);
        String intField = "int_field";  
    public BooleanQueryIT(Settings staticSettings) {
        refresh();
                client().prepareIndex("test").setId(Integer.toString(i)).setSource(intField, i, termField, termValue).get();
        int maxDay = 31;  
            zoneOffset
        createIndex("test");  
        refresh();
