                )
        for (long minDocCount = 0; minDocCount < 20; ++minDocCount) {
                                .endObject()
    }
        testMinDocCountOnDateHistogram(BucketOrder.count(false));
    public void testDateHistogramCountDesc() throws Exception {
import org.opensearch.common.time.DateFormatter;
        testMinDocCountOnTerms("d", Script.YES, BucketOrder.key(true));
                assertEquals("minDocCount: " + minDocCount, bucket1.getDocCount(), bucket2.getDocCount());
            });
    }
            scripts.put("doc['l']", vars -> {
        final Histogram allHisto = allResponse.getAggregations().get("histo");
        indexRandom(true, indexRequests);
                .addAggregation(histogram("histo").field("d").interval(interval).order(order).minDocCount(minDocCount))
    }
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.count(false), ".*a.*", true);
    public MinDocCountIT(Settings staticSettings) {
}
        final SearchResponse allTermsResponse = client().prepareSearch("idx")
    }
import java.util.Map;
                    .executionHint(randomExecutionHint())
        testMinDocCountOnHistogram(BucketOrder.key(true));
    }
        final int interval = randomIntBetween(1, 3);
        for (long minDocCount = 0; minDocCount < 50; ++minDocCount) {
    }
/*
 * ownership. Elasticsearch licenses this file to you under
                    .minDocCount(0)
    }
                        .setSource(
import java.time.ZonedDateTime;
                        .minDocCount(minDocCount)
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.count(true));
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
    public void testLongCountAsc() throws Exception {
            long longTerm;
                script.apply(terms("terms"), field)
                .setSize(0)
                .setQuery(QUERY)
    }
                final Histogram.Bucket b2 = it2.next();
                longTerm = randomInt(cardinality * 2);
            return scripts;
            )
            .get();
            .get();
                dateHistogram("histo").field("date").dateHistogramInterval(DateHistogramInterval.DAY).order(order).minDocCount(0)
        }
        }
                        .includeExclude(include == null ? null : new IncludeExclude(include, null))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAllSuccessful;
package org.opensearch.search.aggregations.bucket;
                .setSize(0)
                )
                            jsonBuilder().startObject()
            double doubleTerm = longTerm * Math.PI;
    }
        testMinDocCountOnTerms("l", Script.NO, BucketOrder.key(true));
                assertEquals(b1.getKey(), b2.getKey());
        assertEquals(cardinality, allTerms.getBuckets().size());
    // check that terms2 is a subset of terms1
            String dateTerm = DateFormatter.forPattern("yyyy-MM-dd").format(time);
 * license agreements. See the NOTICE file distributed with
            String stringTerm;
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
                        CustomScriptPlugin.NAME,
                return value;
    public void testStringScriptCountAsc() throws Exception {
    public void testStringCountDescWithInclude() throws Exception {
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.count(false), ".*a.*", true);
            assertSubset(allHisto, response.getAggregations().get("histo"), minDocCount);
        }
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
import java.util.regex.Pattern;
    @Override
import java.util.Iterator;
                indexRequests.add(
    }
            assertAllSuccessful(response);
        ensureSearchable();
    public void testStringScriptCountAscWithInclude() throws Exception {
        NO {
                    client().prepareIndex("idx")
    private void testMinDocCountOnDateHistogram(BucketOrder order) throws Exception {
                                .field("s", stringTerm)
                final Terms.Bucket bucket2 = it2.next();
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.key(false));
 * this file be licensed under the Apache-2.0 license or a
    }
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.count(false));
import org.opensearch.search.aggregations.bucket.histogram.DateHistogramInterval;
    public void testLongScriptCountDesc() throws Exception {
        for (int i = 0; i < cardinality; ++i) {
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.key(false));
import org.opensearch.action.search.SearchRequest;
    }
            .setQuery(QUERY)
            final int frequency = randomBoolean() ? 1 : randomIntBetween(2, 20);
            do {
    private void assertSubset(Terms terms1, Terms terms2, long minDocCount, int size, String include) {
import java.util.function.Function;
            do {
        testMinDocCountOnTerms("l", Script.NO, BucketOrder.count(true));
 * You may obtain a copy of the License at
                    .order(order)
            .get();
                ScriptDocValues.Longs value = (ScriptDocValues.Longs) doc.get("l");
    }
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    public void testStringScriptCountDesc() throws Exception {
        cardinality = randomIntBetween(8, 30);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
        final Iterator<? extends Histogram.Bucket> it2 = histo2.getBuckets().iterator();
import java.time.ZoneOffset;
        super(staticSettings);
        testMinDocCountOnTerms(field, script, order, null, true);
    }
        return Collections.singleton(CustomScriptPlugin.class);
    }
        }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    public void testDoubleScriptCountDesc() throws Exception {
    public void testHistogramKeyDesc() throws Exception {
                .setSize(0)
    }
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.count(false));
            } while (!stringTerms.add(stringTerm));
            }
            });
    }
                ScriptDocValues.Doubles value = (ScriptDocValues.Doubles) doc.get("d");
                        .size(size)
    public void testDoubleScriptCountAsc() throws Exception {
    }
    }
                        .order(order)
        final Histogram allHisto = allResponse.getAggregations().get("histo");
    }
import java.util.HashSet;
    @Override
                assertTrue("minDocCount: " + minDocCount, it2.hasNext());
        int size2 = 0;
    public void testStringScriptTermDesc() throws Exception {
    private static final QueryBuilder QUERY = QueryBuilders.termQuery("match", true);
import org.opensearch.search.aggregations.BucketOrder;
        final SearchResponse allResponse = client().prepareSearch("idx")
        final SearchResponse allResponse = client().prepareSearch("idx")
            @Override
    public void setupSuiteScopeCluster() throws Exception {
        testMinDocCountOnTerms("l", Script.YES, BucketOrder.count(true));
    }
    public void testStringTermAsc() throws Exception {
            if (b1.getDocCount() >= minDocCount) {
        assertFalse(it2.hasNext());
                assertEquals(b1.getDocCount(), b2.getDocCount());
    public void testDoubleTermAsc() throws Exception {
    }
import static org.opensearch.search.aggregations.AggregationBuilders.dateHistogram;
            TermsAggregationBuilder apply(TermsAggregationBuilder builder, String field) {
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.count(true));
    }
    public void testLongTermDesc() throws Exception {
    public void testDoubleTermDesc() throws Exception {
            final SearchResponse response = client().prepareSearch("idx")
        testMinDocCountOnTerms("d", Script.YES, BucketOrder.count(false));
        for (long minDocCount = 0; minDocCount < 50; ++minDocCount) {
    public void testStringTermDesc() throws Exception {
    }
import org.opensearch.action.search.SearchResponse;
            final Terms.Bucket bucket1 = it1.next();
    public void testLongScriptTermDesc() throws Exception {
        final Iterator<? extends Terms.Bucket> it1 = terms1.getBuckets().iterator();
    public void testStringCountAscWithInclude() throws Exception {
            ZonedDateTime time = ZonedDateTime.of(2014, 1, ((int) longTerm % 20) + 1, 0, 0, 0, 0, ZoneOffset.UTC);
    public void testDoubleScriptTermDesc() throws Exception {
                return value;
import java.util.List;
                .setQuery(QUERY)
        }
            )
 * this work for additional information regarding copyright
                                .field("d", doubleTerm)
            .addAggregation(histogram("histo").field("d").interval(interval).order(order).minDocCount(0))
    public void testHistogramCountDesc() throws Exception {
                .addAggregation(
                    script.apply(terms("terms"), field)
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.key(true));
    }
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.search.aggregations.bucket.terms.Terms;
    }
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        final List<IndexRequestBuilder> indexRequests = new ArrayList<>();
    }
        testMinDocCountOnHistogram(BucketOrder.count(false));
    public void testLongTermAsc() throws Exception {
            }
                }
    }
                return builder.script(
        @Override
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            TermsAggregationBuilder apply(TermsAggregationBuilder builder, String field) {
    }
            }
                        .executionHint(randomExecutionHint())
    public void testDateHistogramCountAsc() throws Exception {
    }
        final Set<Long> longTerms = new HashSet();
        abstract TermsAggregationBuilder apply(TermsAggregationBuilder builder, String field);
        testMinDocCountOnHistogram(BucketOrder.key(false));
                if (size2++ == size) {
    }
        testMinDocCountOnTerms("l", Script.YES, BucketOrder.key(true));
        testMinDocCountOnDateHistogram(BucketOrder.count(true));
    public void testLongScriptCountAsc() throws Exception {
    private enum Script {
                return value;
import org.opensearch.search.aggregations.bucket.terms.IncludeExclude;
                    )
        assertAcked(client().admin().indices().prepareCreate("idx").setMapping("s", "type=keyword").get());
 * specific language governing permissions and limitations
    public void testDoubleCountDesc() throws Exception {
@OpenSearchIntegTestCase.SuiteScopeTestCase
/*
                                .field("match", randomBoolean())
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
                        ScriptType.INLINE,
import java.util.Collections;
            });
    public void testDoubleCountAsc() throws Exception {
        // all terms
                Map<?, ?> doc = (Map) vars.get("doc");
            final SearchRequest request = client().prepareSearch("idx")
/*
                                .field("l", longTerm)
 * compatible open source license.
    private void testMinDocCountOnTerms(String field, Script script, BucketOrder order, String include, boolean retry) throws Exception {
        testMinDocCountOnTerms("l", Script.NO, BucketOrder.key(false));
 * Modifications Copyright OpenSearch Contributors. See
            } while (!longTerms.add(longTerm));
 * software distributed under the License is distributed on an
 */
                .get();
    private void assertSubset(Histogram histo1, Histogram histo2, long minDocCount) {
    }
        while (it1.hasNext()) {
                    dateHistogram("histo").field("date")
                        .shardSize(cardinality + randomInt(10))
        final Matcher matcher = include == null ? null : Pattern.compile(include).matcher("");
import org.opensearch.action.index.IndexRequestBuilder;
            .setQuery(QUERY)
        final Iterator<? extends Terms.Bucket> it2 = terms2.getBuckets().iterator();
                        .dateHistogramInterval(DateHistogramInterval.DAY)
        testMinDocCountOnHistogram(BucketOrder.count(true));
                        Collections.emptyMap()
 *    http://www.apache.org/licenses/LICENSE-2.0
    private void testMinDocCountOnHistogram(BucketOrder order) throws Exception {
 * under the License.
 * KIND, either express or implied.  See the License for the
import java.util.regex.Matcher;
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.count(true), ".*a.*", true);
                    .size(cardinality + randomInt(10))
            }
    public void testLongCountDesc() throws Exception {
public class MinDocCountIT extends AbstractTermsTestCase {
    public void testDateHistogramKeyDesc() throws Exception {
            }
                .addAggregation(
import java.util.HashMap;
    public void testStringCountDesc() throws Exception {
                        "doc['" + field + "']",
        testMinDocCountOnDateHistogram(BucketOrder.key(true));
    public void testDateHistogramKeyAsc() throws Exception {
 * GitHub history for details.
    public void testStringCountAsc() throws Exception {
        testMinDocCountOnTerms("l", Script.YES, BucketOrder.count(false));
                stringTerm = RandomStrings.randomAsciiOfLength(random(), 8);
        assertAllSuccessful(allTermsResponse);
        testMinDocCountOnTerms("d", Script.YES, BucketOrder.count(true));
                        .order(order)
    }
                                .field("date", dateTerm)
    public void testLongScriptTermAsc() throws Exception {
            .setQuery(QUERY)
 * Unless required by applicable law or agreed to in writing,
 *
        };
                ScriptDocValues.Strings value = (ScriptDocValues.Strings) doc.get("s");
import java.util.Collection;
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {
    }
    }
 */
        testMinDocCountOnTerms("d", Script.YES, BucketOrder.key(false));
import java.util.Set;
                Map<?, ?> doc = (Map) vars.get("doc");
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        }
        testMinDocCountOnTerms("s", Script.YES, BucketOrder.count(true), ".*a.*", true);
    }
        testMinDocCountOnTerms("l", Script.YES, BucketOrder.key(false));
            if (bucket1.getDocCount() >= minDocCount && (matcher == null || matcher.reset(bucket1.getKeyAsString()).matches())) {
        testMinDocCountOnTerms("d", Script.NO, BucketOrder.key(false));
        YES {
            final int size = randomIntBetween(1, cardinality + 2);
        cardinality = stringTerms.size();
            assertSubset(allTerms, (Terms) response.getAggregations().get("terms"), minDocCount, size, include);
            .setSize(0)
                return builder.field(field);
        testMinDocCountOnDateHistogram(BucketOrder.key(false));
    public void testStringScriptTermAsc() throws Exception {
    }
        final Terms allTerms = allTermsResponse.getAggregations().get("terms");
                );
            @Override
    }
 */
        testMinDocCountOnTerms("d", Script.NO, BucketOrder.count(false));
            final SearchResponse response = client().prepareSearch("idx")
        final Set<String> stringTerms = new HashSet<>();
        }
    }
            scripts.put("doc['s']", vars -> {
            .setSize(0)
 * Licensed to Elasticsearch under one or more contributor
        for (Histogram.Bucket b1 : histo1.getBuckets()) {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
 *
    }
import org.opensearch.script.ScriptType;
import org.opensearch.index.query.QueryBuilders;
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
        testMinDocCountOnTerms("d", Script.NO, BucketOrder.key(true));
                .request();
    public void testHistogramKeyAsc() throws Exception {
                .get();
import org.opensearch.common.settings.Settings;
 *
                );
import org.opensearch.plugins.Plugin;
    public void testDoubleScriptTermAsc() throws Exception {
    }
        },
import static org.opensearch.search.aggregations.AggregationBuilders.histogram;
    }
            final SearchResponse response = client().search(request).get();
            assertSubset(allHisto, (Histogram) response.getAggregations().get("histo"), minDocCount);
    }
            .addAggregation(
        testMinDocCountOnTerms("l", Script.NO, BucketOrder.count(false));
    private static int cardinality;
                Map<?, ?> doc = (Map) vars.get("doc");
import java.util.ArrayList;
    }
        testMinDocCountOnTerms("d", Script.NO, BucketOrder.count(true));
 * The OpenSearch Contributors require contributions made to
    }
 * not use this file except in compliance with the License.
    public void testHistogramCountAsc() throws Exception {
            scripts.put("doc['d']", vars -> {
 * the Apache License, Version 2.0 (the "License"); you may
                    new org.opensearch.script.Script(
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testStringScriptCountDescWithInclude() throws Exception {
        testMinDocCountOnTerms("s", Script.NO, BucketOrder.key(true));
                .setQuery(QUERY)
import org.opensearch.index.query.QueryBuilder;
                        )
    private void testMinDocCountOnTerms(String field, Script script, BucketOrder order) throws Exception {
                        .minDocCount(minDocCount)
    }
import org.opensearch.index.fielddata.ScriptDocValues;
            for (int j = 0; j < frequency; ++j) {
            .setSize(0)
            .addAggregation(
                    break;
