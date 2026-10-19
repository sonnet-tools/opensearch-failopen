            } else {
            client().admin()
        Terms terms = response.getAggregations().get("terms");  
        Terms terms = response.getAggregations().get("terms");
            .aggregation(  
        assertThat(terms.getBuckets().size(), equalTo(5));
            )
            )
                        .includeExclude(new IncludeExclude(partition, numPartitions))
            )
        boolean asc = true;
        Terms terms = response.getAggregations().get("terms");
        testOtherDocCount(SINGLE_VALUED_FIELD_NAME, MULTI_VALUED_FIELD_NAME);
            .setSize(0)
        assertThat(exception.getMessage(), containsString("[size] must be greater than 0. Found [0] in [terms]"));  
                terms("terms").field("d")  
            .get();  
        assertThat(tags.getBuckets().size(), equalTo(2));
        String[] expectedKeys = new String[] { "val1", "val2", "val3", "val4", "val5", "val6", "val7" };
        boolean asc = randomBoolean();
                .getHitCount(),
            Terms subTermsAgg = bucket.getAggregations().get("subTerms");
    // the main purpose of this test is to make sure we're not allocating 2GB of memory per shard  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .setRequestCache(true)  
            equalTo(0L)
            assertThat(bucket, notNullValue());  
    public StringTermsIT(Settings staticSettings) {
        for (Terms.Bucket bucket : terms.getBuckets()) {
        Terms terms = response.getAggregations().get("terms");
        Filter filter1 = tag.getAggregations().get("filter1");  
                .indices()
        for (Terms.Bucket bucket : terms.getBuckets()) {  
                .get()
            )
            assertThat(terms, notNullValue());
        // no execution hint so that the logic that decides whether or not to use ordinals is executed
        assertThat(stats, notNullValue());
import org.opensearch.common.settings.Settings;  
        }  
                        .order(BucketOrder.aggregation("inner_terms>avg", asc))
                        )  
        assertThat(terms.getBuckets().size(), equalTo(6));
     * [foo_val0, foo_val1] [foo_val1, foo_val2] [foo_val2, foo_val3] [foo_val3,
        // the max for "more" is 2
        assertThat(terms.getName(), equalTo("terms"));  
                        terms("terms").executionHint(randomExecutionHint())  
        assertThat(terms, notNullValue());
    public void testScriptMultiValued() throws Exception {
        // Gather terms using partitioned aggregations
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAsCompound() throws Exception {  
     *
            } catch (OpenSearchException e) {
        assertThat(tag, notNullValue());
        indexRandom(
                    )
            assertThat(subTermsAgg, notNullValue());
            CustomScriptPlugin.NAME,  
        runTestFieldWithPartitionedFiltering(MULTI_VALUED_FIELD_NAME);
        assertThat(terms, notNullValue());  
        Filter filter2 = filter1.getAggregations().get(filter2Name);  
            .addAggregation(
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values())).executionHint(randomExecutionHint()).script(script)
    }  
            .get();
                        terms("terms").executionHint(randomExecutionHint())  
import static org.opensearch.search.aggregations.AggregationBuilders.avg;  
            } else {  
        assertThat(key(tag), equalTo(asc ? "more" : "less"));
        int i = 0;
            Collections.emptyMap()
        );
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(true));
                terms("terms1").collectMode(SubAggCollectionMode.DEPTH_FIRST)
            assertThat(stats, notNullValue());
        r = client().prepareSearch("cache_test_idx")  
                .setRequestCache(true)
    }
import org.opensearch.search.aggregations.metrics.Sum;  
        Terms.Bucket tag = iters.next();
        tag = iters.next();
    }
        filter = tag.getAggregations().get("filter");
            assertThat(bucket.getDocCount(), equalTo(1L));
        SearchResponse response = client().prepareSearch("idx")  
                    .order(BucketOrder.aggregation("stats.sum_of_squares", asc))
                assertThat(bucket.getDocCount(), equalTo(1L));
                .getHitCount(),
            assertThat(bucket, notNullValue());  
        );  
            assertThat(terms, notNullValue());
            .addAggregation(  
        int i = 0;  
                throw e;  
        Stats stats = filter2.getAggregations().get("stats");  
                .getTotal()  
            .addAggregation(
        try {
                .getHitCount(),
            )
        for (SearchResponse response : new SearchResponse[] { r2, r3, r4 }) {
        tag = iters.next();
        internalCluster().wipeIndices("cache_test_idx");
 * this work for additional information regarding copyright
        SearchResponse response = client().prepareSearch("sort_idx")  
        assertThat(key(bucket), equalTo("val"));
    }
    public void testScriptCaching() throws Exception {
import static org.hamcrest.core.IsNull.notNullValue;  
                    .order(BucketOrder.aggregation("filter1>" + filter2Name + ">" + statsName + ".max", asc))
            i--;
import org.opensearch.search.aggregations.metrics.Stats;
                            "doc['" + MULTI_VALUED_FIELD_NAME + "']",
            }
                terms("terms").script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "42", Collections.emptyMap()))
            "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",  
            ExtendedStats stats = bucket.getAggregations().get("stats");
        assertSearchResponse(response);
        }  
        Terms terms = response.getAggregations().get("terms");
        assertSearchResponse(allResponse);
            assertThat(bucket.getDocCount(), equalTo(1L));  
                        )  
import static org.hamcrest.Matchers.instanceOf;
            );
     */
                    .size(2)
            assertThat(bucket.getDocCount(), equalTo(i == 3 ? 2L : 1L));
                    .subAggregation(extendedStats("stats").field("i"))  
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationDesc() throws Exception {
        final int minDocCount = randomInt(1);
        Terms tags = response.getAggregations().get("tags");
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(terms("terms").field("d")).get();  
                    .subAggregation(AggregationBuilders.filters("filter", QueryBuilders.boolQuery()))  
            assertThat(bucket.getDocCount(), equalTo(i == 0 ? 5L : 2L));
        for (int i = 2; i <= 4; i++) {
     * val_count: 4 foo_val2 - doc_count: 2 - val_count: 4 foo_val3 - doc_count:
    public void testIndexMetaField() throws Exception {  
                // expected
            )  
        assertThat(tags.getName(), equalTo("tags"));  
import static org.opensearch.index.query.QueryBuilders.termQuery;
                            filter(filter2Name, QueryBuilders.matchAllQuery()).subAggregation(stats(statsName).field("i"))
                )
                .getTotal()  
                .getRequestCache()
        assertThat(terms, notNullValue());
    public void testSingleValuedFieldOrderedByMissingSubAggregation() throws Exception {
            .addAggregation(
        assertThat(terms.getName(), equalTo("terms"));
        int i = 0;  
            assertThat(subTermsAgg.getBuckets().size(), equalTo(2));  
                    .field(IndexFieldMapper.NAME)
                .setRequestCache(true)  
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
        assertThat(terms.getBuckets().size(), equalTo(6));
                .indices()
            .get();  
        assertThat(filter2.getDocCount(), equalTo(asc ? 2L : 3L));
                .getRequestCache()  
                )
        Terms.Bucket tag = iters.next();
            } catch (OpenSearchException e) {  
                );
                    .get();
                .get()
            f2 = terms.getBucketByKey(b2.getKeyAsString()).getAggregations().get("filter");
            } catch (OpenSearchException e) {
            equalTo(0L)
                terms("terms1").collectMode(SubAggCollectionMode.DEPTH_FIRST)
            .setSize(0)
 *  
                client().prepareSearch(index)  
        super(staticSettings);  
            assertThat(stats, notNullValue());  
        assertSearchResponse(response);
                    .subAggregation(AggregationBuilders.filters("filter", QueryBuilders.boolQuery()))
                // expected
            }  
                .prepareStats("cache_test_idx")
        assertThat(terms.getName(), equalTo("terms"));  
     */
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
    /*  
            .addAggregation(
        stats = filter2.getAggregations().get(statsName);
                .getRequestCache()  
            .setSize(0)  
                .addAggregation(
                    .subAggregation(AggregationBuilders.filters("filter", QueryBuilders.boolQuery()))
import org.opensearch.test.OpenSearchIntegTestCase;  
    public void testSingleValuedFieldOrderedByThreeCriteria() throws Exception {
                    .subAggregation(avg("avg_l").field("l"))  
    }
        }
 * The OpenSearch Contributors require contributions made to  
        statsNameBuilder.append(randomAlphaOfLengthBetween(3, 10).replace("[", "").replace("]", "").replace(">", ""));  
        assertThat(terms.getName(), equalTo("terms"));  
            ScriptType.INLINE,
            int j = i;
            .addAggregation(
                .setRequestCache(true)
                .getTotal()
        assertSearchResponse(response);
        Terms.Bucket bucket = terms.getBucketByKey("val");
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values()))  
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);  
            terms = response.getAggregations().get("terms1");
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
                            Collections.emptyMap()
            i++;
            .get();  
        }  
                .get()
            assertThat(key(bucket), equalTo("val" + i));
        assertThat(tags.getBuckets().size(), equalTo(2));
                .get()
        assertThat(stats, notNullValue());  
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsDesc() throws Exception {
        Terms terms = r1.getAggregations().get("terms1");
        assertSearchResponse(response);
    public void testOtherDocCount() {  
                .getRequestCache()  
        stats = filter2.getAggregations().get("stats");
                    .field(MULTI_VALUED_FIELD_NAME)
                .setRequestCache(true)  
        assertSearchResponse(response);
        assertMultiSortResponse(expectedKeys, BucketOrder.count(true), BucketOrder.aggregation("avg_l", true));  
            i++;
            assertThat(bucket, notNullValue());
                            filter(filter2Name, QueryBuilders.matchAllQuery()).subAggregation(stats(statsName).field("i"))
        }  
 * Unless required by applicable law or agreed to in writing,
        assertThat(
                .get()
            expectedKeys,
        assertThat(terms.getBuckets().size(), equalTo(2));
                .getTotal()
    }
     * foo_val4] [foo_val4, foo_val5]  
        boolean asc = true;  
            )
            .addAggregation(
        assertSearchResponse(response);  
        assertThat(filter.getDocCount(), equalTo(asc ? 3L : 2L));
                .getRequestCache()
        // Tests subAgg doc count is the same with different collection modes and additional top level aggs
            .addAggregation(
    }
    }  
        assertSearchResponse(response);
        assertThat(tag, notNullValue());
                XContentParseException.class,
                    )
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
        int i = 0;  
            .addAggregation(
        assertThat(filter2, notNullValue());  
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
        assertThat(key(tag), equalTo(asc ? "less" : "more"));  
 * SPDX-License-Identifier: Apache-2.0
        }
        for (Terms.Bucket bucket : terms.getBuckets()) {  
            assertThat(stats.getMax(), equalTo((double) i));
            client().admin()  
        assertThat(filter2, notNullValue());
        assertThat(terms.getBuckets().size(), equalTo(5));
import org.opensearch.action.search.SearchResponse;
            Terms terms = response.getAggregations().get("terms");
import org.opensearch.search.aggregations.support.ValueType;
            assertThat(key(bucket), equalTo(expectedKeys[i]));  
            SearchResponse response = client().prepareSearch("idx").setSource(SearchSourceBuilder.fromXContent(parser)).get();
        assertSearchResponse(r);
            Sum sum = bucket.getAggregations().get("sum_d");
            assertThat(terms.getName(), equalTo("terms"));  
        assertEquals(expectedCardinality, foundTerms.size());
            equalTo(0L)  
        assertSearchResponse(r);
        for (int i = 0; i < 6; i++) {  
        assertThat(key(tag), equalTo(asc ? "less" : "more"));  
        assertThat(terms.getName(), equalTo("terms"));
 */  
            .addAggregation(
 * not use this file except in compliance with the License.
            .get();  
        Bucket b1 = terms.getBucketByKey("val0");  
                );
                .getMissCount(),
        assertSearchResponse(r);
                .getRequestCache()
                terms("tags").executionHint(randomExecutionHint())
        assertThat(terms.getBuckets().size(), equalTo(1));  
        Bucket b2 = terms.getBucketByKey("val1");  
        assertThat(filter1.getDocCount(), equalTo(asc ? 3L : 2L));
    public void testMultiValueFieldWithPartitionedFiltering() throws Exception {
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value.substring(0,3)", Collections.emptyMap()))  
                        )  
 * GitHub history for details.
                    .executionHint(randomExecutionHint())
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
    }
        String statsName = statsNameBuilder.toString();
        }
        SearchResponse response = client().prepareSearch("idx")  
        SearchResponse response = client().prepareSearch("idx")
        String invalidValueType = source.replaceAll("\"value_type\":\"n.*\"", "\"value_type\":\"foobar\"");
        long docCount1 = f1.getBuckets().get(0).getDocCount();
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
        assertThat(terms.getName(), equalTo("terms"));
            .addAggregation(  
        assertThat(filter1.getDocCount(), equalTo(asc ? 3L : 2L));
                    .size(2)
        filter2 = filter1.getAggregations().get(filter2Name);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .get();
import java.util.Collections;  
        assertThat(terms.getBuckets().size(), equalTo(5));  
            Terms.Bucket bucket = terms.getBucketByKey("foo_val" + i);
                    .field(MULTI_VALUED_FIELD_NAME)
        Terms terms = allResponse.getAggregations().get("terms");
                        + response.getFailedShards()  
        }  
        assertThat(terms.getBuckets().size(), equalTo(3));
     * Make sure that a request using a deterministic script or not using a script get cached.
        SearchResponse response = client().prepareSearch("idx")  
        );  
        SearchResponse response = client().prepareSearch("idx")  
                    )
        assertThat(terms.getName(), equalTo("terms"));  
                            CustomScriptPlugin.NAME,  
    public void testSingleValuedFieldOrderedBySubAggregationAscMultiHierarchyLevelsSpecialChars() throws Exception {
                    .field("s_value")  
        assertThat(terms, notNullValue());
            assertThat(bucket, notNullValue());
            .get();
            assertThat(bucket, notNullValue());
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;
                    .order(BucketOrder.aggregation("stats.sum_of_squares", asc))
                    .subAggregation(extendedStats("stats").field("i"))  
        assertSearchResponse(response);
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
            assertThat(key(bucket), equalTo("val" + i));
            .addAggregation(terms("terms").field(field).size(10000).collectMode(randomFrom(SubAggCollectionMode.values())))
            BucketOrder.count(false),  
    /**
    public void testSingleValuedFieldOrderedBySingleBucketSubAggregationAsc() throws Exception {
            .get();  
        assertSearchResponse(response);
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(bucket.getDocCount(), equalTo(5L));
import static org.hamcrest.Matchers.equalTo;  
    }  
            )  
    }  
                .indices()
            assertThat(bucket, notNullValue());
            )
import java.util.Set;  
                    .field("s_value")  
            .addAggregation(
 * the Apache License, Version 2.0 (the "License"); you may
                .getRequestCache()  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
            IllegalArgumentException.class,
                            .subAggregation(stats("stats").field("i"))
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsAsc() throws Exception {  
            .get();
package org.opensearch.search.aggregations.bucket.terms;
            client().admin()
        tag = iters.next();
            .setSize(0)
                    .subAggregation(terms("subTerms").field("s_values").collectMode(randomFrom(SubAggCollectionMode.values())))
                assertThat(key(subBucket), equalTo("val" + j));
        for (int i = 0; i < 6; i++) {
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true));
import org.opensearch.core.xcontent.XContentParser;  
                fail("Expected search to fail when trying to sort terms aggregation by sug-aggregation that doesn't exist");
            equalTo(0L)  
        assertThat(filter.getDocCount(), equalTo(asc ? 2L : 3L));
                    .subAggregation(stats("stats").field("i"))
    }  
        Filter filter1 = tag.getAggregations().get("filter1");  
            .setSize(0)
            "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",
        SearchResponse response = client().prepareSearch("idx")
                    .subAggregation(  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(filter2, notNullValue());
                        + " failed shards."
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "'foo_' + _value", Collections.emptyMap()))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .addAggregation(  
        SearchResponse r1 = client().prepareSearch("idx")  
            .addAggregation(
                .setRequestCache(true)
            try {
                .indices()
        Terms terms = response.getAggregations().get("terms");
            assertThat(stats.getMax(), equalTo((double) i));
        assertThat(filter2.getDocCount(), equalTo(asc ? 3L : 2L));
    public void testScriptSingleValue() throws Exception {  
    }
        for (int i = 0; i < 5; i++) {
        assertThat(terms, notNullValue());
                            filter("filter2", QueryBuilders.matchAllQuery()).subAggregation(stats("stats").field("i"))
import java.util.Iterator;
        assertThat(stats.getMax(), equalTo(asc ? 4.0 : 2.0));
        }
            Stats stats = bucket.getAggregations().get("stats");
    }  
            assertThat(key(bucket), equalTo("val" + i));
        assertThat(terms.getName(), equalTo("terms"));
                OpenSearchException rootCause = rootCauses[0];
            )
        assertThat(filter2.getDocCount(), equalTo(asc ? 3L : 2L));
        assertThat(tags.getName(), equalTo("tags"));  
            assertThat(terms.getBuckets().size(), equalTo(1));
            assertThat(key(bucket), equalTo("val" + i));
        assertThat(filter2, notNullValue());
            .get();
import static org.hamcrest.Matchers.containsString;
        }  
            )
        boolean asc = randomBoolean();
            assertThat(bucket.getDocCount(), equalTo(1L));
            XContentParseException ex = expectThrows(
import org.opensearch.core.xcontent.XContentParseException;
                        filter("filter1", QueryBuilders.matchAllQuery()).subAggregation(
            terms = response.getAggregations().get("terms");
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();  
            )
        Stats stats = filter2.getAggregations().get(statsName);  
        assertThat(terms.getBuckets().size(), equalTo(5));
                    .field(SINGLE_VALUED_FIELD_NAME)  
                        + "which is not of a metrics or single-bucket type"  
import org.opensearch.search.aggregations.BucketOrder;
                    terms("terms").executionHint(randomExecutionHint())
                        filter("filter1", QueryBuilders.matchAllQuery()).subAggregation(
                terms("terms").executionHint(randomExecutionHint())  
                terms("terms1").collectMode(SubAggCollectionMode.BREADTH_FIRST)  
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", "bar")
        assertThat(terms, notNullValue());  
        }  
                .prepareStats("cache_test_idx")
            Avg avg = bucket.getAggregations().get("avg_l");
                .addAggregation(  
            BucketOrder.aggregation("sum_d", false),
    }
        assertThat(filter1.getDocCount(), equalTo(asc ? 2L : 3L));
        assertThat(tags.getName(), equalTo("tags"));  
            assertThat(key(bucket), equalTo(i == 0 ? "idx" : "empty_bucket_idx"));  
            prepareCreate("cache_test_idx").setMapping("d", "type=keyword")
        assertThat(filter1, notNullValue());
            assertThat(bucket.getDocCount(), equalTo(1L));
        }  
        assertThat(terms, notNullValue());
                    throw e;  
                .get();
import static org.hamcrest.Matchers.startsWith;
                    .script(  
        statsNameBuilder.append(randomAlphaOfLengthBetween(3, 10).replace("[", "").replace("]", "").replace(">", ""));  
            () -> client().prepareSearch("high_card_idx")
        StringBuilder statsNameBuilder = new StringBuilder("st.ats");
    public void testSingleValuedFieldOrderedByIllegalAgg() throws Exception {  
    public void testMultiValuedScript() throws Exception {
        stats = filter2.getAggregations().get(statsName);
import org.opensearch.search.aggregations.metrics.ExtendedStats;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
                    .subAggregation(sum("sum_d").field("d"))
        // the max for "less" is 4  
            } else {
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values())).executionHint(randomExecutionHint()).script(script)  
import org.opensearch.search.aggregations.AggregationBuilders;
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
import static org.opensearch.search.aggregations.AggregationBuilders.stats;  
            .get();  
        assertThat(response.getFailedShards(), equalTo(0));
        Filter filter2 = filter1.getAggregations().get(filter2Name);  
    }  
import org.opensearch.script.ScriptType;
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
                    "Expected search to fail when trying to sort terms aggregation by sug-aggregation "
        assertThat(terms, notNullValue());
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        for (int partition = 0; partition < numPartitions; partition++) {
                    .subAggregation(AggregationBuilders.filters("filter", QueryBuilders.boolQuery()))
            assertThat(stats, notNullValue());
            if (i == 0 || i == 5) {
                    .addAggregation(
                    )
                .getHitCount(),
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(sum.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("sum_d")));
        IllegalArgumentException exception = expectThrows(  
                    .field("tag")  
            .addAggregation(  
            .addAggregation(
    }
            if (rootCauses.length == 1) {  
        assertSearchResponse(response);
                .setRequestCache(true)  
        assertThat(tag, notNullValue());  
        assertThat(filter1, notNullValue());
        String[] expectedKeys = new String[] { "val1", "val2", "val3", "val4", "val5", "val6", "val7" };
            assertEquals(docCount1, f1.getBuckets().get(0).getDocCount());
                    .field("s_value")
            .get();  
            Stats stats = bucket.getAggregations().get("stats");  
                    .executionHint(randomExecutionHint())
    }  
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
        for (int i = 0; i < 5; i++) {  
            equalTo(0L)  
        Script script = new Script(  
            try {
            assertEquals(docCount2, f2.getBuckets().get(0).getDocCount());  
            )  
            .get();  
    }
        }
        assertThat(tags.getBuckets().size(), equalTo(2));
            .get();  
            ExtendedStats stats = bucket.getAggregations().get("stats");  
                // expected
                client().prepareSearch(index)
            )  
        assertThat(tag, notNullValue());
    public void testScriptSingleValueExplicitSingleValue() throws Exception {
            assertThat(terms.getName(), equalTo("terms"));  
        Terms.Bucket tag = iters.next();
                assertThat(subBucket, notNullValue());  
                        new Script(
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
                        .collectMode(randomFrom(SubAggCollectionMode.values()))  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                .getTotal()
            .setSize(0)  
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(key(bucket), equalTo("val" + i));  
        }
    }
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();  
        );  
        assertThat(  
        }
            .get();  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
                .getMissCount(),
            .addAggregation(  
        assertThat(terms.getName(), equalTo("terms"));  
        filter1 = tag.getAggregations().get("filter1");
                    .get();
import java.util.Arrays;
                    .field(SINGLE_VALUED_FIELD_NAME)  
        assertSearchResponse(response);
        assertThat(filter2, notNullValue());  
        assertThat(terms.getName(), equalTo("terms"));
/*
            client().admin()  
        filter2 = filter1.getAggregations().get(filter2Name);
        assertThat(terms, notNullValue());
        Terms terms = filter.getAggregations().get("terms");
        filter1 = tag.getAggregations().get("filter1");
        assertThat(terms, notNullValue());
                    .order(BucketOrder.compound(order))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(filter1.getDocCount(), equalTo(asc ? 2L : 3L));
                assertThat(bucket.getDocCount(), equalTo(2L));
            for (Bucket bucket : terms.getBuckets()) {
/*
     *
                if (rootCause instanceof AggregationExecutionException) {
                } else {
                .getRequestCache()
            .get();
        assertThat(
        assertMultiSortResponse(
        assertThat(filter1, notNullValue());  
@OpenSearchIntegTestCase.SuiteScopeTestCase
        SearchResponse response = client().prepareSearch("idx", "empty_bucket_idx")
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithoutMetric() throws Exception {
    public void testScriptWithValueType() throws Exception {
                .get()
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(ex.getCause().getMessage(), containsString("Unknown value type [foobar]"));  
import org.opensearch.search.aggregations.metrics.Avg;  
            } else {  
            assertSearchResponse(response);  
        assertThat(
            client().admin()
    public void testDeferredSubAggs() {
        assertThat(key(tag), equalTo(asc ? "more" : "less"));
            .addAggregation(
                .getTotal()
            }  
            assertThat(key(bucket), equalTo("val" + i));  
            }
                );  
            assertThat(sum, notNullValue());  
    }
                    .field(SINGLE_VALUED_FIELD_NAME)  
                terms("tags").executionHint(randomExecutionHint())  
        String source = builder.toString();
                filter("filter", termQuery(MULTI_VALUED_FIELD_NAME, "val3")).subAggregation(
                .indices()
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
import org.opensearch.search.aggregations.bucket.filter.InternalFilters;
        assertNotNull(r3.getAggregations().get("terms1"));
        );
            )
        assertThat(terms.getName(), equalTo("terms"));
            OpenSearchException[] rootCauses = e.guessRootCauses();
    }
                        .minDocCount(minDocCount)
                    .addAggregation(
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", "foo"),
            } catch (OpenSearchException e) {  
        String filter2Name = filter2NameBuilder.toString();
        assertThat(  
                fail(  
            assertThat(bucket, notNullValue());
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationAsc() throws Exception {
        tag = iters.next();
        for (Terms.Bucket bucket : terms.getBuckets()) {
        }
    public void testSizeIsZero() {
            assertThat(key(bucket), equalTo("val" + i));
}
            assertThat(bucket, notNullValue());
            assertThat(bucket, notNullValue());
            try {  
                    .field("tag")
 *
            }
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscSingleValueSubAggregationAsc() throws Exception {  
    public void testSingleValuedFieldOrderedByCountAscAndSingleValueSubAggregationAsc() throws Exception {
                    .order(BucketOrder.aggregation("stats.avg", asc))  
                    .addAggregation(
                        terms("terms").executionHint(randomExecutionHint())
        filter2 = filter1.getAggregations().get("filter2");
                        )  
        int i = 0;  
                SearchResponse response = client().prepareSearch(index)  
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
                )  
        );
    }
        filter2NameBuilder.append(randomAlphaOfLengthBetween(3, 10).replace("[", "").replace("]", "").replace(">", ""));  
                            .field(SINGLE_VALUED_FIELD_NAME)
        SearchResponse response = client().prepareSearch("idx")
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
            )
        SearchResponse response = client().prepareSearch("idx")
        );
            assertThat(avg, notNullValue());  
                        + "with an unknown specified metric to order by. response had "
            )
import org.opensearch.OpenSearchException;  
            .get();
     * doc_count: 1 - val_count: 2  
        assertThat(filter2.getDocCount(), equalTo(asc ? 2L : 3L));
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
     * Ensure requests using nondeterministic scripts do not get cached.  
        Terms.Bucket tag = iters.next();
    }
            assertThat(bucket.getDocCount(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("_count")));
        }
        for (int i = 0; i < 5; i++) {
        assertThat(bucket, notNullValue());  
/*  
        Filter filter = response.getAggregations().get("filter");  
import org.opensearch.action.search.SearchPhaseExecutionException;
                        .subAggregation(terms("inner_terms").field(MULTI_VALUED_FIELD_NAME).subAggregation(avg("avg").field("i")))  
        Terms tags = response.getAggregations().get("tags");
            )
    public void testStringTermsNestedIntoPerBucketAggregator() throws Exception {  
                            CustomScriptPlugin.NAME,  
 *
        int i = 4;
    public void testSingleValuedFieldOrderedByNonMetricsOrMultiBucketSubAggregation() throws Exception {  
        assertThat(tag, notNullValue());  
        assertThat(filter1, notNullValue());  
                    )
                    AggregationExecutionException aggException = (AggregationExecutionException) rootCause;  
        SearchResponse r4 = client().prepareSearch("idx")
            assertThat(bucket.getDocCount(), equalTo(1L));
        assertThat(tags, notNullValue());
    public void testSingleValuedFieldOrderedByStatsAggAscWithTermsSubAgg() throws Exception {
        assertThat(tag, notNullValue());
        assertThat(filter1, notNullValue());
                .getTotal()  
                .prepareStats("cache_test_idx")  
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
            .addAggregation(AggregationBuilders.min("min").field("constant"))
    }
        int expectedCardinality = terms.getBuckets().size();
        assertThat(terms.getBuckets().size(), equalTo(5));
        assertThat(key(tag), equalTo(asc ? "more" : "less"));  
        );
    }
     * foo_val0 - doc_count: 1 - val_count: 2 foo_val1 - doc_count: 2 -  
    }  
            .addAggregation(
    public void testMultiValuedFieldWithValueScript() throws Exception {
        assertThat(tags, notNullValue());
        Set<String> foundTerms = new HashSet<>();  
        assertThat(filter2, notNullValue());  
                assertThat(bucket.getDocCount(), equalTo(2L));
        assertSearchResponse(response);  
            assertThat(stats.getMax(), equalTo((double) i));
                    .field(SINGLE_VALUED_FIELD_NAME)  
        );
                        )  
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
            i++;
        }
                    )
import org.opensearch.script.Script;  
            client().admin()  
            }
            assertThat(avg.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("avg_l")));
                        terms("terms").executionHint(randomExecutionHint())
                terms("terms").executionHint(randomExecutionHint())
                    .order(BucketOrder.aggregation("stats.avg", asc))
        for (Terms.Bucket bucket : terms.getBuckets()) {
                .getMissCount(),
    }
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();  
        Filter filter = tag.getAggregations().get("filter");  
                assertThat(subBucket.getDocCount(), equalTo(1L));
        SearchResponse response = client().prepareSearch("idx")  
        assertThat(key(tag), equalTo(asc ? "more" : "less"));
import org.opensearch.index.query.QueryBuilders;
 * license agreements. See the NOTICE file distributed with
                .indices()
            client().admin()  
                        .field(SINGLE_VALUED_FIELD_NAME)
                .setRequestCache(true)
            assertThat(bucket.getDocCount(), equalTo(1L));  
        } catch (SearchPhaseExecutionException e) {
                assertThat(bucket.getDocCount(), equalTo(2L));
        assertThat(tags.getBuckets().size(), equalTo(2));
        assertThat(stats.getMax(), equalTo(asc ? 2.0 : 4.0));
        InternalFilters f1 = b1.getAggregations().get("filter");
    private void assertMultiSortResponse(String[] expectedKeys, BucketOrder... order) {
 * specific language governing permissions and limitations
        }  
        SearchResponse r3 = client().prepareSearch("idx")
        Terms terms = response.getAggregations().get("terms");
            .get();  
                    .execute()  
    private void runTestFieldWithPartitionedFiltering(String field) throws Exception {
    public void testSingleValuedFieldOrderedBySubAggregationAscMultiHierarchyLevels() throws Exception {
        assertThat(filter1.getDocCount(), equalTo(asc ? 3L : 2L));
        Terms terms = response.getAggregations().get("terms");  
        for (int i = 0; i < 6; i++) {  
        boolean asc = false;
    }
                            .subAggregation(terms("values").field("i").collectMode(randomFrom(SubAggCollectionMode.values())))  
                            .order(BucketOrder.aggregation("avg_i", true))  
                    .order(BucketOrder.aggregation("filter1>" + filter2Name + ">" + statsName + "[max]", asc))
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", false), BucketOrder.key(true));
                    .order(BucketOrder.aggregation("filter", asc))  
                        .size(0)
                    .field("s_value")
        assertThat(terms, notNullValue());  
        filter2NameBuilder.append(randomAlphaOfLengthBetween(3, 10).replace("[", "").replace("]", "").replace(">", ""));  
                terms("tags").executionHint(randomExecutionHint())
                            .order(BucketOrder.aggregation("stats", true))  
        Filter filter2 = filter1.getAggregations().get("filter2");  
        assertThat(tags.getName(), equalTo("tags"));  
            assertThat(bucket.getDocCount(), equalTo(1L));
        assertSearchResponse(response);  
 */
            assertThat(key(bucket), equalTo("foo_val" + i));  
    public void testMultiValuedFieldWithValueScriptNotUnique() throws Exception {  
        Stats stats = filter2.getAggregations().get(statsName);  
            )
            .addAggregation(
        for (int i = 0; i < 5; i++) {
            .get();  
                terms("tags").executionHint(randomExecutionHint())
            assertThat(bucket, notNullValue());
        boolean asc = randomBoolean();
            )  
        long docCount2 = f1.getBuckets().get(0).getDocCount();
        boolean asc = true;
        String[] expectedKeys = new String[] { "val1", "val2", "val4", "val3", "val7", "val6", "val5" };
        // the max for "more" is 2
                    .field(SINGLE_VALUED_FIELD_NAME)
                        filter("filter1", QueryBuilders.matchAllQuery()).subAggregation(
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("terms").executionHint(randomExecutionHint())
            .get();  
    public void testSingleValuedFieldOrderedBySubAggregationAscMultiHierarchyLevelsSpecialCharsNoDotNotation() throws Exception {
        Terms terms = response.getAggregations().get("terms");  
            if (i == 0 || i == 5) {
            assertThat(key(bucket), equalTo("val" + i));
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
        assertNotNull(r4.getAggregations().get("terms1"));  
        StringBuilder filter2NameBuilder = new StringBuilder("filt.er2");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        SearchResponse response = client().prepareSearch("idx")
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();  
                    .subAggregation(stats("stats").field("i"))  
        }
        assertThat(key(tag), equalTo(asc ? "less" : "more"));  
                    )
 * under the License.  
            i++;
                terms("terms").executionHint(randomExecutionHint())
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(tag, notNullValue());  
                .get()
        assertThat(terms, notNullValue());  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "'foo_' + _value", Collections.emptyMap()))
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
    public void testSingleValuedFieldWithValueScript() throws Exception {
            .addAggregation(
                            "doc['" + MULTI_VALUED_FIELD_NAME + "']",
    }
    public void testSingleValueFieldWithPartitionedFiltering() throws Exception {  
     * 2 - val_count: 4 foo_val4 - doc_count: 2 - val_count: 4 foo_val5 -
        assertSearchResponse(response);
        Terms terms = response.getAggregations().get("terms");
        assertThat(terms.getBuckets().size(), equalTo(expectedKeys.length));
                            .field(SINGLE_VALUED_FIELD_NAME)
                            .field(SINGLE_VALUED_FIELD_NAME)  
            .addAggregation(
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx")  
            .addAggregation(AggregationBuilders.min("min").field("constant"))
            i++;  
        assertThat(terms.getName(), equalTo("terms"));
                fail(
        // Find total number of unique terms  
            assertThat(stats, notNullValue());  
    }
        assertThat(terms.getBuckets().size(), equalTo(5));
        // Ensure that non-scripted requests are cached as normal
        SearchResponse response = client().prepareSearch("idx")  
            fail("Expected an exception");  
        Filter filter1 = tag.getAggregations().get("filter1");  
        );  
    }
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidValueType)) {  
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
            ScriptType.INLINE,
                    terms("terms").executionHint(randomExecutionHint())
                .getTotal()  
            Collections.emptyMap()
                fail(  
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(  
    public void testPartiallyUnmapped() throws Exception {  
                            Collections.emptyMap()
    }
        SearchSourceBuilder builder = new SearchSourceBuilder().size(0)
        String[] expectedKeys = new String[] { "val5", "val6", "val7", "val3", "val4", "val2", "val1" };  
        // the max for "less" is 4  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
            .addAggregation(
                .indices()
        assertThat(terms.getName(), equalTo("terms"));
        String statsName = statsNameBuilder.toString();
                .get()
     *
            .get();
            SearchResponse response = client().prepareSearch("idx")
                assertTrue(foundTerms.add(bucket.getKeyAsString()));
    }
        SearchResponse response = client().prepareSearch("idx")
            true,  
                            .order(BucketOrder.aggregation("values", true))
        // Make sure we are starting with a clear cache
                terms("terms").executionHint(randomExecutionHint())
                terms("terms").executionHint(randomExecutionHint())  
                    .field("tag")  
                terms("terms1").collectMode(SubAggCollectionMode.BREADTH_FIRST)
            equalTo(0L)  
        assertSearchResponse(response);
                    .order(BucketOrder.aggregation("filter1>filter2>stats.max", asc))
                    .size(2)  
        assertThat(filter2.getDocCount(), equalTo(asc ? 2L : 3L));
        assertThat(stats.getMax(), equalTo(asc ? 4.0 : 2.0));
        assertThat(terms, notNullValue());
                        .collectMode(randomFrom(SubAggCollectionMode.values()))  
import org.opensearch.search.aggregations.bucket.filter.Filter;  
    }
        SearchResponse r = client().prepareSearch("cache_test_idx")  
                .getMissCount(),
            .get();
        StringBuilder filter2NameBuilder = new StringBuilder("filt.er2");
    }
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
    }
            client().admin()
        assertThat(tags, notNullValue());
            assertThat(key(bucket), equalTo("foo_val" + i));
        assertThat(key(tag), equalTo(asc ? "less" : "more"));
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationDescAndTermsAsc() throws Exception {
        Terms terms = response.getAggregations().get("terms");
        assertThat(stats.getMax(), equalTo(asc ? 2.0 : 4.0));
            .get();
            assertThat(key(bucket), equalTo("val" + i));  
            assertSearchResponse(response);  
        }  
                    terms("terms").field(MULTI_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values()))
        final int numPartitions = randomIntBetween(2, 4);
        assertSearchResponse(response);  
            assertThat(bucket, notNullValue());  
        assertThat(terms, notNullValue());  
            .get();  
        String[] expectedKeys = new String[] { "val6", "val7", "val3", "val4", "val5", "val1", "val2" };
                    )
        InternalFilters f2 = b2.getAggregations().get("filter");
            equalTo(1L)
            equalTo(2L)
                    .subAggregation(  
    }
            .get();
                            .subAggregation(stats("stats").field("i"))  
            );  
            }  
                    .subAggregation(  
        assertNotNull(r2.getAggregations().get("terms1"));
        assertThat(tag, notNullValue());  
            f1 = terms.getBucketByKey(b1.getKeyAsString()).getAggregations().get("filter");  
            client().prepareSearch("idx")  
        assertThat(terms.getBuckets().size(), equalTo(5));  
                j++;  
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
                    .field(SINGLE_VALUED_FIELD_NAME)  
        assertThat(terms.getName(), equalTo("terms"));
 */
        assertThat(terms.getBuckets().size(), equalTo(6));
        assertThat(stats, notNullValue());  
                        + "where the metric name is not specified"
        assertThat(stats, notNullValue());
        Terms tags = response.getAggregations().get("tags");
        filter1 = tag.getAggregations().get("filter1");
                    .addAggregation(
                            .field(SINGLE_VALUED_FIELD_NAME)  
 * Licensed to Elasticsearch under one or more contributor  
        String[] expectedKeys = new String[] { "val6", "val7", "val3", "val5", "val4", "val1", "val2" };
        assertThat(stats.getMax(), equalTo(asc ? 4.0 : 2.0));
            Terms.Bucket bucket = terms.getBucketByKey("foo_val" + i);
                terms("terms").field("d")  
            assertThat(bucket, notNullValue());
            CustomScriptPlugin.NAME,
            assertThat(bucket.getDocCount(), equalTo(1L));  
        boolean asc = true;
                    terms("terms").field(field)
        );  
        }  
public class StringTermsIT extends BaseStringTermsTestCase {  
                terms("terms").executionHint(randomExecutionHint())
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                assertThat(bucket.getDocCount(), equalTo(1L));
        // Test that a request using a deterministic script gets cached
                )  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {  
            .addAggregation(
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
        Script script = new Script(
        Terms tags = response.getAggregations().get("tags");
                    .subAggregation(filter("filter", QueryBuilders.matchAllQuery()))
            }
            BucketOrder.aggregation("avg_l", false)
        // the max for "more" is 2
                            ScriptType.INLINE,
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(terms, notNullValue());
                // expected  
            if (i == 0 || i == 5) {
    }
        SearchResponse response = client().prepareSearch("idx")
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithUnknownMetric() throws Exception {  
        Terms terms = response.getAggregations().get("terms");
        String[] expectedKeys = new String[] { "val2", "val1", "val4", "val5", "val3", "val6", "val7" };  
        runTestFieldWithPartitionedFiltering(SINGLE_VALUED_FIELD_NAME);
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
            }
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "'foo_' + _value", Collections.emptyMap()))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
import org.opensearch.search.builder.SearchSourceBuilder;
                    .size(2)
 * Modifications Copyright OpenSearch Contributors. See  
        assertThat(terms.getName(), equalTo("terms"));  
                .prepareStats("cache_test_idx")  
 * software distributed under the License is distributed on an
        );  
            .get();  
                client().prepareSearch(index)
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("sum_d", true), BucketOrder.aggregation("avg_l", true));
        Terms terms = response.getAggregations().get("terms");  
                .addAggregation(  
                .prepareStats("cache_test_idx")  
                    assertThat(aggException.getMessage(), startsWith("Invalid aggregation order path"));
 * KIND, either express or implied.  See the License for the
        Terms terms = response.getAggregations().get("terms");
        assertThat(stats, notNullValue());
        assertThat(terms.getBuckets().size(), equalTo(5));  
                .get();
            )
                    .get();
                .get()  
        assertNotNull(r1.getAggregations().get("terms1"));  
            )
        // Test that a request using a nondeterministic script does not get cached
                        .field(SINGLE_VALUED_FIELD_NAME)  
                    .field("tag")  
                .get()
                terms("terms").executionHint(randomExecutionHint())
import org.opensearch.search.aggregations.AggregationExecutionException;  
        assertThat(
        SearchResponse allResponse = client().prepareSearch("idx")
                        new Script(
                .indices()
            .addAggregation(
import org.opensearch.common.xcontent.json.JsonXContent;
                    .script(  
            assertThat(bucket, notNullValue());
                assertThat(bucket.getDocCount(), equalTo(1L));  
        assertThat(stats, notNullValue());  
            try {  
                    )
        assertThat(filter1, notNullValue());  
        );  
        assertThat(terms.getName(), equalTo("terms"));  
 * compatible open source license.
                .prepareStats("cache_test_idx")  
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap()))
        assertThat(filter, notNullValue());  
        }  
        assertAcked(  
        assertThat(stats.getMax(), equalTo(asc ? 2.0 : 4.0));
            )
        StringBuilder statsNameBuilder = new StringBuilder("st.ats");
        SearchResponse r2 = client().prepareSearch("idx")
                            .order(BucketOrder.aggregation("stats.foo", true))
        boolean asc = randomBoolean();  
        for (Terms.Bucket bucket : terms.getBuckets()) {
            assertThat(bucket, notNullValue());  
                terms("terms").executionHint(randomExecutionHint())
                    .field(SINGLE_VALUED_FIELD_NAME)
                .prepareStats("cache_test_idx")
                    .userValueTypeHint(randomFrom(ValueType.NUMERIC, ValueType.NUMBER))
import org.opensearch.index.mapper.IndexFieldMapper;
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
            }
        // the max for "less" is 4  
        assertThat(filter2.getDocCount(), equalTo(asc ? 3L : 2L));
                            ScriptType.INLINE,
                () -> client().prepareSearch("idx").setSource(SearchSourceBuilder.fromXContent(parser)).get()  
        assertSearchResponse(response);
        String filter2Name = filter2NameBuilder.toString();
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
            assertThat(key(bucket), equalTo("val" + i));  
        assertThat(filter, notNullValue());
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(false));  
                terms("terms").executionHint(randomExecutionHint())  
        assertSearchResponse(response);
    public void testSingleValuedFieldOrderedByMultiValueExtendedStatsAsc() throws Exception {
        SearchResponse response = client().prepareSearch("idx")  
                .prepareStats("cache_test_idx")
            )  
                    .actionGet();
            for (Terms.Bucket subBucket : subTermsAgg.getBuckets()) {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        assertThat(filter1.getDocCount(), equalTo(asc ? 2L : 3L));
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
        assertThat(tags, notNullValue());
        );
        assertThat(terms, notNullValue());
            )
        assertThat(  
            assertThat(stats.getMax(), equalTo((double) i));
import java.util.HashSet;
