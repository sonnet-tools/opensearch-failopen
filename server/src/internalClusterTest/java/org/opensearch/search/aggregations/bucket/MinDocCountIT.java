import org.opensearch.action.search.SearchResponse;
    public void testHistogramKeyAsc() throws Exception {  
        testMinDocCountOnTerms(field, script, order, null, true);
import java.time.ZonedDateTime;  
                .setSize(0)  
            }
            .get();  
    public void testDoubleScriptCountAsc() throws Exception {
        indexRandom(true, indexRequests);
    }
    public void testStringCountAscWithInclude() throws Exception {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                        .includeExclude(include == null ? null : new IncludeExclude(include, null))
                    .order(order)
                assertEquals(b1.getKey(), b2.getKey());  
                .addAggregation(
            for (int j = 0; j < frequency; ++j) {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        testMinDocCountOnTerms("d", Script.YES, BucketOrder.count(false));
                    .minDocCount(0)
            final SearchResponse response = client().search(request).get();
                        .minDocCount(minDocCount)  
    }  
 * Unless required by applicable law or agreed to in writing,
                if (size2++ == size) {
        final int interval = randomIntBetween(1, 3);
import java.util.ArrayList;
            } while (!longTerms.add(longTerm));
            }  
            assertSubset(allHisto, response.getAggregations().get("histo"), minDocCount);  
            final SearchResponse response = client().prepareSearch("idx")
        while (it1.hasNext()) {
    }
    }  
        final SearchResponse allTermsResponse = client().prepareSearch("idx")
            @Override
    @Override
                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).order(order).minDocCount(0)
            String stringTerm;
        testMinDocCountOnTerms("d", Script.NO, BucketOrder.key(true));  
    }  
    }
    }
        final Set<Long> longTerms = new HashSet();
    }  
                        .executionHint(randomExecutionHint())
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        .order(order)
                return builder.script(  
        for (long minDocCount = 0; minDocCount < 50; ++minDocCount) {
                    client().prepareIndex("idx")
                                .field("d", doubleTerm)  
        ensureSearchable();
        testMinDocCountOnTerms("l", Script.YES, BucketOrder.count(true));  
            do {
    @Override
    private void testMinDocCountOnHistogram(BucketOrder order) throws Exception {  
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.key(false));
    public void testStringScriptCountAscWithInclude() throws Exception {  
    public void testLongScriptCountAsc() throws Exception {
        final Histogram allHisto = allResponse.getAggregations().get("histo");
            .setQuery(QUERY)  
            }
    public void testDoubleTermDesc() throws Exception {
            .setSize(0)
                indexRequests.add(  
        testMinDocCountOnTerms("d", Script.NO, BucketOrder.key(false));
            .get();  
                                .endObject()  
import org.opensearch.action.index.IndexRequestBuilder;  
package org.opensearch.search.aggregations.bucket;
        }
        assertEquals(cardinality, allTerms.getBuckets().size());
    public void testStringCountDescWithInclude() throws Exception {
                    break;  
                .setQuery(QUERY)
 * software distributed under the License is distributed on an
                        .setSource(
import java.time.ZoneOffset;
            if (bucket1.getDocCount() >= minDocCount && (matcher == null || matcher.reset(bucket1.getKeyAsString()).matches())) {
        final Iterator<? extends Histogram.Bucket> it2 = histo2.getBuckets().iterator();
import org.opensearch.test.OpenSearchIntegTestCase;  
    }
                    )  
    }
                                .field("match", randomBoolean())
        };  
    }
import org.opensearch.common.settings.Settings;  
        abstract TermsAggregationBuilder apply(TermsAggregationBuilder builder, String field);
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.count(false));
                script.apply(terms("terms"), field)
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
import org.opensearch.index.fielddata.ScriptDocValues;
    public void testDateHistogramKeyDesc() throws Exception {
import java.util.Collections;  
        }
        assertAllSuccessful(allTermsResponse);
        testMinDocCountOnTerms("d", Script.YES, BucketOrder.key(true));
import org.opensearch.common.time.DateFormatter;
    }  
        testMinDocCountOnTerms("d", Script.YES, BucketOrder.key(false));  
    public void testDoubleScriptTermDesc() throws Exception {
                }
    public void testDateHistogramCountAsc() throws Exception {
 * GitHub history for details.
                        CustomScriptPlugin.NAME,  
                        "doc['" + field + "']",
    public void testHistogramKeyDesc() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.key(true));
            .setQuery(QUERY)
        testMinDocCountOnTerms("l", Script.NO, BucketOrder.key(false));  
        }
                assertEquals("minDocCount: " + minDocCount, bucket1.getDocCount(), bucket2.getDocCount());
                .get();
        final Set<String> stringTerms = new HashSet<>();
                        .order(order)  
    }
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.count(true), ".*a.*", true);
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.key(false));  
                return value;  
 * the Apache License, Version 2.0 (the "License"); you may
            final int frequency = randomBoolean() ? 1 : randomIntBetween(2, 20);
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("s", "type=keyword").get());  
            final Terms.Bucket bucket1 = it1.next();  
import org.opensearch.search.aggregations.BucketOrder;  
import java.util.List;
                .addAggregation(
            });
        testMinDocCountOnTerms("l", Script.NO, BucketOrder.key(true));
    }
 * You may obtain a copy of the License at  
                .setSize(0)  
                        .dateHistogramInterval(DateHistogramInterval.DAY)
        testMinDocCountOnHistogram(BucketOrder.count(false));  
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
                                .field("date", dateTerm)
        cardinality = stringTerms.size();
            scripts.put("doc['s']", vars -> {  
            String dateTerm = DateFormatter.forPattern("yyyy-MM-dd").format(time);  
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.key(true));
    }
                .setQuery(QUERY)
                );
        for (int i = 0; i < cardinality; ++i) {  
import java.util.regex.Pattern;  
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
        }
                )
 * license agreements. See the NOTICE file distributed with
            long longTerm;
    }
            }
 * compatible open source license.
                Map<?, ?> doc = (Map) vars.get("doc");
                    dateHistogram("histo").field("date")  
    public void testLongTermAsc() throws Exception {  
    public void testStringScriptTermAsc() throws Exception {
        @Override
            } while (!stringTerms.add(stringTerm));
                    new org.opensearch.script.Script(
 * Modifications Copyright OpenSearch Contributors. See
    public void testHistogramCountDesc() throws Exception {
    public void testDoubleCountAsc() throws Exception {  
            @Override
import org.opensearch.script.ScriptType;  
                .setSize(0)  
            if (b1.getDocCount() >= minDocCount) {
        testMinDocCountOnDateHistogram(BucketOrder.count(true));  
        cardinality = randomIntBetween(8, 30);
    // check that terms2 is a subset of terms1
import org.opensearch.index.query.QueryBuilders;
        for (Histogram.Bucket b1 : histo1.getBuckets()) {  
        final List<IndexRequestBuilder> indexRequests = new ArrayList<>();  
        final Iterator<? extends Terms.Bucket> it1 = terms1.getBuckets().iterator();
                    .size(cardinality + randomInt(10))  
        testMinDocCountOnTerms("d", Script.YES, BucketOrder.count(true));
 * specific language governing permissions and limitations
                    .executionHint(randomExecutionHint())
    public void testStringScriptCountAsc() throws Exception {
import java.util.Map;
        final Histogram allHisto = allResponse.getAggregations().get("histo");
                stringTerm = RandomStrings.randomAsciiOfLength(random(), 8);  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
    }
    }
    public MinDocCountIT(Settings staticSettings) {  
                        )
        testMinDocCountOnTerms("l", Script.NO, BucketOrder.count(true));
    }
    public void testStringScriptCountDesc() throws Exception {
    private void testMinDocCountOnTerms(String field, Script script, BucketOrder order) throws Exception {
            .setSize(0)  
            }
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.count(false), ".*a.*", true);  
    public void testDateHistogramCountDesc() throws Exception {  
                return value;  
        testMinDocCountOnTerms("d", Script.NO, BucketOrder.count(true));
        for (long minDocCount = 0; minDocCount < 50; ++minDocCount) {
    public void testDoubleCountDesc() throws Exception {
                return value;  
                        ScriptType.INLINE,
        testMinDocCountOnTerms("l", Script.YES, BucketOrder.key(true));
    }
        testMinDocCountOnTerms("d", Script.NO, BucketOrder.count(false));  
    }  
    }
    public void testStringCountDesc() throws Exception {  
        testMinDocCountOnDateHistogram(BucketOrder.key(true));
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
        testMinDocCountOnHistogram(BucketOrder.count(true));
                .setQuery(QUERY)
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
    }
    }  
                return builder.field(field);  
        // all terms  
    public void testStringCountAsc() throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
 */  
@OpenSearchIntegTestCase.SuiteScopeTestCase  
        int size2 = 0;
    public void testLongCountAsc() throws Exception {
 * not use this file except in compliance with the License.
            });
    }
            scripts.put("doc['d']", vars -> {  
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
 * this file be licensed under the Apache-2.0 license or a
    public void testLongScriptTermDesc() throws Exception {  
import org.opensearch.search.aggregations.bucket.terms.Terms;
                ScriptDocValues.Longs value = (ScriptDocValues.Longs) doc.get("l");
                longTerm = randomInt(cardinality * 2);
            final SearchRequest request = client().prepareSearch("idx")
    }
import org.opensearch.action.search.SearchRequest;
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.count(true), ".*a.*", true);  
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;  
                                .field("s", stringTerm)
    }
    }  
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                ScriptDocValues.Doubles value = (ScriptDocValues.Doubles) doc.get("d");
 * this work for additional information regarding copyright
 *
    private static int cardinality;
        },
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testStringScriptTermDesc() throws Exception {  
        super(staticSettings);
    public void testDateHistogramKeyAsc() throws Exception {
import java.util.HashMap;
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
    }  
 */  
            .addAggregation(
 *
    public void testLongScriptTermAsc() throws Exception {
    public void testLongTermDesc() throws Exception {
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.count(true));  
        YES {  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    private void assertSubset(Terms terms1, Terms terms2, long minDocCount, int size, String include) {  
        testMinDocCountOnTerms("l", Script.YES, BucketOrder.count(false));
    private void assertSubset(Histogram histo1, Histogram histo2, long minDocCount) {
            )
 * under the License.  
    }
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.count(true));
            )
                ScriptDocValues.Strings value = (ScriptDocValues.Strings) doc.get("s");
            scripts.put("doc['l']", vars -> {  
 * KIND, either express or implied.  See the License for the
    }
import org.opensearch.index.query.QueryBuilder;  
        testMinDocCountOnHistogram(BucketOrder.key(false));
                .request();  
    public void testDoubleTermAsc() throws Exception {
        final Terms allTerms = allTermsResponse.getAggregations().get("terms");  
                assertTrue("minDocCount: " + minDocCount, it2.hasNext());
    }
    private enum Script {
import java.util.Set;  
                )
                );
    public void testLongScriptCountDesc() throws Exception {
            return scripts;  
import java.util.Collection;
        final SearchResponse allResponse = client().prepareSearch("idx")
    }
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;  
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.count(false), ".*a.*", true);
                        Collections.emptyMap()
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
                Map<?, ?> doc = (Map) vars.get("doc");
    }  
    }
        NO {  
            .addAggregation(  
                Map<?, ?> doc = (Map) vars.get("doc");
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {  
            ZonedDateTime time = ZonedDateTime.of(2014, 1, ((int) longTerm % 20) + 1, 0, 0, 0, 0, ZoneOffset.UTC);
/*
    public void testStringScriptCountDescWithInclude() throws Exception {
    public void testLongCountDesc() throws Exception {  
            double doubleTerm = longTerm * Math.PI;  
    }
        testMinDocCountOnHistogram(BucketOrder.key(true));
import org.opensearch.plugins.Plugin;
import java.util.HashSet;
                        .size(size)
        return Collections.singleton(CustomScriptPlugin.class);  
import java.util.function.Function;
            do {  
import java.util.Iterator;  
    }  
            TermsAggregationBuilder apply(TermsAggregationBuilder builder, String field) {
/*  
/*  
    }
 * Licensed to Elasticsearch under one or more contributor  
            assertSubset(allHisto, (Histogram) response.getAggregations().get("histo"), minDocCount);
            });
            TermsAggregationBuilder apply(TermsAggregationBuilder builder, String field) {
    public void setupSuiteScopeCluster() throws Exception {
            .setQuery(QUERY)
        final SearchResponse allResponse = client().prepareSearch("idx")  
                    script.apply(terms("terms"), field)  
        }  
    public void testStringTermDesc() throws Exception {
    }
                .addAggregation(histogram("histo").field("d").interval(interval).order(order).minDocCount(minDocCount))
    public void testStringTermAsc() throws Exception {  
                        .minDocCount(minDocCount)
 *  
        testMinDocCountOnDateHistogram(BucketOrder.count(false));
    }  
                        .shardSize(cardinality + randomInt(10))  
 */
}  
            final SearchResponse response = client().prepareSearch("idx")
        }
    }
    }  
                .get();  
    private void testMinDocCountOnDateHistogram(BucketOrder order) throws Exception {
    private static final QueryBuilder QUERY = QueryBuilders.termQuery("match", true);  
            .addAggregation(histogram("histo").field("d").interval(interval).order(order).minDocCount(0))
    public void testDoubleScriptTermAsc() throws Exception {  
            .get();  
        testMinDocCountOnDateHistogram(BucketOrder.key(false));  
            assertAllSuccessful(response);
        for (long minDocCount = 0; minDocCount < 20; ++minDocCount) {  
                assertEquals(b1.getDocCount(), b2.getDocCount());
                final Terms.Bucket bucket2 = it2.next();  
    }
        final Iterator<? extends Terms.Bucket> it2 = terms2.getBuckets().iterator();  
    }
                            jsonBuilder().startObject()  
                                .field("l", longTerm)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
    public void testHistogramCountAsc() throws Exception {
import java.util.regex.Matcher;
        }  
        testMinDocCountOnTerms("l", Script.YES, BucketOrder.key(false));
            .setSize(0)
                final Histogram.Bucket b2 = it2.next();
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.count(false));
        testMinDocCountOnTerms("l", Script.NO, BucketOrder.count(false));
    }  
    public void testDoubleScriptCountDesc() throws Exception {  
        assertFalse(it2.hasNext());
            assertSubset(allTerms, (Terms) response.getAggregations().get("terms"), minDocCount, size, include);  
    }  
            final int size = randomIntBetween(1, cardinality + 2);
public class MinDocCountIT extends AbstractTermsTestCase {
    }  
    private void testMinDocCountOnTerms(String field, Script script, BucketOrder order, String include, boolean retry) throws Exception {
        final Matcher matcher = include == null ? null : Pattern.compile(include).matcher("");
