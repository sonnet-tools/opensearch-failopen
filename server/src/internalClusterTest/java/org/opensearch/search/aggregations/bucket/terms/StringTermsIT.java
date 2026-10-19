            .setSize(0)
            client().admin()
        );
        SearchResponse response = client().prepareSearch("idx")
        SearchResponse response = client().prepareSearch("idx")
@OpenSearchIntegTestCase.SuiteScopeTestCase
    public void testSingleValueFieldWithPartitionedFiltering() throws Exception {
            }
            .get();
            expectedKeys,
        assertThat(stats.getMax(), equalTo(asc ? 2.0 : 4.0));
        r = client().prepareSearch("cache_test_idx").setSize(0).addAggregation(terms("terms").field("d")).get();
            .addAggregation(
        assertThat(tags.getBuckets().size(), equalTo(2));
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscSingleValueSubAggregationAsc() throws Exception {
                    .subAggregation(AggregationBuilders.filters("filter", QueryBuilders.boolQuery()))
        statsNameBuilder.append(randomAlphaOfLengthBetween(3, 10).replace("[", "").replace("]", "").replace(">", ""));
                if (rootCause instanceof AggregationExecutionException) {
            }
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
        }
    public void testIndexMetaField() throws Exception {
import org.opensearch.search.aggregations.metrics.Sum;
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, source)) {
        assertNotNull(r4.getAggregations().get("terms1"));
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();
        Stats stats = filter2.getAggregations().get("stats");
            assertThat(key(bucket), equalTo("val" + i));
        assertEquals(expectedCardinality, foundTerms.size());
        testOtherDocCount(SINGLE_VALUED_FIELD_NAME, MULTI_VALUED_FIELD_NAME);
        assertThat(filter.getDocCount(), equalTo(asc ? 3L : 2L));
        Terms terms = response.getAggregations().get("terms");
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
                    .field("tag")
    public void testSingleValuedFieldOrderedBySubAggregationAscMultiHierarchyLevels() throws Exception {
        assertSearchResponse(response);
        assertSearchResponse(r);
import org.opensearch.action.search.SearchPhaseExecutionException;
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
import org.opensearch.script.Script;
            assertThat(stats, notNullValue());
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true));
            .addAggregation(
        assertThat(
        indexRandom(
        assertSearchResponse(response);
            assertThat(key(bucket), equalTo("val" + i));
                    .script(
            XContentParseException ex = expectThrows(
            .setSize(0)
        SearchResponse response = client().prepareSearch("idx")
                terms("terms").executionHint(randomExecutionHint())
}
        assertThat(terms.getName(), equalTo("terms"));
    }
                        .field(SINGLE_VALUED_FIELD_NAME)
        statsNameBuilder.append(randomAlphaOfLengthBetween(3, 10).replace("[", "").replace("]", "").replace(">", ""));
        Stats stats = filter2.getAggregations().get(statsName);
            assertEquals(docCount2, f2.getBuckets().get(0).getDocCount());
        );
 *
        assertThat(terms.getName(), equalTo("terms"));
        assertThat(terms.getBuckets().size(), equalTo(6));
        // the max for "less" is 4
        SearchResponse allResponse = client().prepareSearch("idx")
import static org.hamcrest.Matchers.startsWith;
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithUnknownMetric() throws Exception {
                .getMissCount(),
                .get();
        assertThat(tag, notNullValue());
 * You may obtain a copy of the License at
        Terms.Bucket tag = iters.next();
import org.opensearch.test.OpenSearchIntegTestCase;
        assertThat(
                    .field("s_value")
import org.opensearch.search.aggregations.metrics.Avg;
                client().prepareSearch(index)
            }
        // the max for "more" is 2
            assertThat(key(bucket), equalTo("val" + i));
        Bucket b1 = terms.getBucketByKey("val0");
            CustomScriptPlugin.NAME,
            .addAggregation(
                        + " failed shards."
            SearchResponse response = client().prepareSearch("idx")
                .getHitCount(),
            assertSearchResponse(response);
        Terms tags = response.getAggregations().get("tags");
        SearchResponse response = client().prepareSearch("idx")
                .indices()
            equalTo(0L)
            )
        for (int i = 0; i < 5; i++) {
            assertThat(bucket, notNullValue());
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
    }
            .addAggregation(
                SearchResponse response = client().prepareSearch(index)
        assertThat(tag, notNullValue());
                throw e;
 * this file be licensed under the Apache-2.0 license or a
            );
        assertThat(filter1, notNullValue());
                        .subAggregation(terms("inner_terms").field(MULTI_VALUED_FIELD_NAME).subAggregation(avg("avg").field("i")))
            ExtendedStats stats = bucket.getAggregations().get("stats");
        assertThat(key(tag), equalTo(asc ? "more" : "less"));
        internalCluster().wipeIndices("cache_test_idx");
                        )
            assertThat(bucket.getDocCount(), equalTo(1L));
        boolean asc = true;
    public void testSingleValuedFieldOrderedBySingleBucketSubAggregationAsc() throws Exception {
        String[] expectedKeys = new String[] { "val6", "val7", "val3", "val5", "val4", "val1", "val2" };
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
    }
        super(staticSettings);
 * this work for additional information regarding copyright
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            } catch (OpenSearchException e) {
                .getRequestCache()
            assertThat(stats.getMax(), equalTo((double) i));
            .get();
                    .subAggregation(extendedStats("stats").field("i"))
                    throw e;
        Filter filter1 = tag.getAggregations().get("filter1");
            Avg avg = bucket.getAggregations().get("avg_l");
        // Ensure that non-scripted requests are cached as normal
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
            assertThat(ex.getCause(), instanceOf(IllegalArgumentException.class));
            .setSize(0)
        // the max for "more" is 2
                    .order(BucketOrder.aggregation("stats.avg", asc))
            )
                    .field(SINGLE_VALUED_FIELD_NAME)
    }
    }
                .getHitCount(),
     * foo_val0 - doc_count: 1 - val_count: 2 foo_val1 - doc_count: 2 -
    public void testOtherDocCount() {
        boolean asc = randomBoolean();
        assertThat(bucket, notNullValue());
            .addAggregation(terms("terms").field(field).size(10000).collectMode(randomFrom(SubAggCollectionMode.values())))
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "'foo_' + _value", Collections.emptyMap()))
        assertNotNull(r2.getAggregations().get("terms1"));
        int i = 0;
        SearchResponse response = client().prepareSearch("idx")
            }
     */
        assertThat(terms, notNullValue());
                            .subAggregation(terms("values").field("i").collectMode(randomFrom(SubAggCollectionMode.values())))
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
 * Licensed to Elasticsearch under one or more contributor
                assertThat(bucket.getDocCount(), equalTo(1L));
                            CustomScriptPlugin.NAME,
                            filter("filter2", QueryBuilders.matchAllQuery()).subAggregation(stats("stats").field("i"))
                    )
    }
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values())).executionHint(randomExecutionHint()).script(script)
        SearchResponse r3 = client().prepareSearch("idx")
            "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
                .addAggregation(
                .indices()
    }
        assertThat(filter2, notNullValue());
import org.opensearch.core.xcontent.XContentParseException;
    }
    }
import static org.opensearch.search.aggregations.AggregationBuilders.filter;
/*
                            .field(SINGLE_VALUED_FIELD_NAME)
        try {
        assertThat(stats, notNullValue());
                        + response.getFailedShards()
    public void testSingleValuedFieldOrderedByIllegalAgg() throws Exception {
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
        assertSearchResponse(response);
        for (int i = 0; i < 6; i++) {
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(true));
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "_value.substring(0,3)", Collections.emptyMap()))
            equalTo(0L)
                .getRequestCache()
        assertThat(terms.getBuckets().size(), equalTo(expectedKeys.length));
            .setSize(0)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(terms.getName(), equalTo("terms"));
                .prepareStats("cache_test_idx")
        final int numPartitions = randomIntBetween(2, 4);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
                    )
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
            assertThat(terms, notNullValue());
                    .addAggregation(
                .prepareStats("cache_test_idx")
                XContentParseException.class,
        assertThat(filter1, notNullValue());
                .prepareStats("cache_test_idx")
                terms("terms").field("d")
        }
        }
        assertThat(stats, notNullValue());
        StringBuilder statsNameBuilder = new StringBuilder("st.ats");
                assertThat(key(subBucket), equalTo("val" + j));
        Filter filter2 = filter1.getAggregations().get(filter2Name);
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
    }
            assertThat(terms, notNullValue());
/*
            assertThat(subTermsAgg, notNullValue());
            assertThat(bucket.getDocCount(), equalTo(1L));
            OpenSearchException[] rootCauses = e.guessRootCauses();
                terms("tags").executionHint(randomExecutionHint())
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "'foo_' + _value", Collections.emptyMap()))
import java.util.Iterator;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        String[] expectedKeys = new String[] { "val1", "val2", "val3", "val4", "val5", "val6", "val7" };
            } catch (OpenSearchException e) {
            equalTo(0L)
        assertThat(terms.getName(), equalTo("terms"));
    private void assertMultiSortResponse(String[] expectedKeys, BucketOrder... order) {
                .getHitCount(),
    public void testSingleValuedFieldOrderedByCountAscAndSingleValueSubAggregationAsc() throws Exception {
    }
        assertSearchResponse(response);
            client().admin()
                    assertThat(aggException.getMessage(), startsWith("Invalid aggregation order path"));
        assertThat(key(tag), equalTo(asc ? "more" : "less"));
                assertThat(bucket.getDocCount(), equalTo(1L));
                .addAggregation(
                () -> client().prepareSearch("idx").setSource(SearchSourceBuilder.fromXContent(parser)).get()
    public void testMultiValuedScript() throws Exception {
            client().admin()
            .addAggregation(
                .get()
        assertThat(stats.getMax(), equalTo(asc ? 4.0 : 2.0));
            .get();
                    .field("s_value")
        SearchResponse response = client().prepareSearch("idx")
                            .field(SINGLE_VALUED_FIELD_NAME)
                terms("terms").field("d")
                        )
        SearchResponse response = client().prepareSearch("idx")
            .get();
                            ScriptType.INLINE,
        Terms terms = response.getAggregations().get("terms");
import org.opensearch.search.aggregations.bucket.terms.Terms.Bucket;
                    .execute()
            assertThat(key(bucket), equalTo("val" + i));
            .addAggregation(
        runTestFieldWithPartitionedFiltering(SINGLE_VALUED_FIELD_NAME);
            assertThat(key(bucket), equalTo("foo_val" + i));
        StringBuilder filter2NameBuilder = new StringBuilder("filt.er2");
                assertThat(bucket.getDocCount(), equalTo(2L));
            .get();
    }
            CustomScriptPlugin.NAME,
        SearchResponse response = client().prepareSearch("idx")
            .setSize(0)
        SearchResponse response = client().prepareSearch("idx", "empty_bucket_idx")
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAsCompound() throws Exception {
            assertThat(bucket.getDocCount(), equalTo(1L));
        }
        }
    public void testMultiValuedFieldWithValueScriptNotUnique() throws Exception {
        assertThat(terms.getBuckets().size(), equalTo(6));
                terms("terms1").collectMode(SubAggCollectionMode.DEPTH_FIRST)
import org.opensearch.search.aggregations.bucket.filter.Filter;
            .get();
        assertThat(filter1, notNullValue());
                .getMissCount(),
                    AggregationExecutionException aggException = (AggregationExecutionException) rootCause;
                            Collections.emptyMap()
        }
        assertSearchResponse(response);
        for (int i = 0; i < 6; i++) {
            assertThat(terms.getName(), equalTo("terms"));
            assertThat(bucket, notNullValue());
        int i = 0;
                    .size(2)
                            "doc['" + MULTI_VALUED_FIELD_NAME + "']",
                .getHitCount(),
        String[] expectedKeys = new String[] { "val2", "val1", "val4", "val5", "val3", "val6", "val7" };
            .get();
                .getTotal()
        Terms terms = response.getAggregations().get("terms");
                        .includeExclude(new IncludeExclude(partition, numPartitions))
            )
            assertThat(ex.getCause().getMessage(), containsString("Unknown value type [foobar]"));
            terms = response.getAggregations().get("terms1");
    }
                fail(
            assertThat(bucket, notNullValue());
 * the Apache License, Version 2.0 (the "License"); you may
 */
                j++;
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "Math.random()", Collections.emptyMap()))
            )
        for (Terms.Bucket bucket : terms.getBuckets()) {
        assertSearchResponse(response);
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();
        // Test that a request using a nondeterministic script does not get cached
        for (Terms.Bucket bucket : terms.getBuckets()) {
        assertThat(filter2, notNullValue());
                            .subAggregation(stats("stats").field("i"))
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
                        terms("terms").executionHint(randomExecutionHint())
     * foo_val4] [foo_val4, foo_val5]
        Stats stats = filter2.getAggregations().get(statsName);
                        .minDocCount(minDocCount)
            )
        String[] expectedKeys = new String[] { "val6", "val7", "val3", "val4", "val5", "val1", "val2" };
    }
                        .collectMode(randomFrom(SubAggCollectionMode.values()))
    }
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
        assertNotNull(r3.getAggregations().get("terms1"));
        int i = 4;
        assertThat(tags.getBuckets().size(), equalTo(2));
                .setRequestCache(true)
            int j = i;
    public void testSingleValuedFieldOrderedByMissingSubAggregation() throws Exception {
            .addAggregation(
            .addAggregation(
                .prepareStats("cache_test_idx")
import static org.hamcrest.core.IsNull.notNullValue;
        }
            for (Terms.Bucket subBucket : subTermsAgg.getBuckets()) {
            .addAggregation(
import org.opensearch.search.aggregations.BucketOrder;
            )
        for (Terms.Bucket bucket : terms.getBuckets()) {
        SearchResponse r1 = client().prepareSearch("idx")
            if (rootCauses.length == 1) {
        assertThat(stats.getMax(), equalTo(asc ? 2.0 : 4.0));
                .getTotal()
                .addAggregation(
            .get();
 *
                    .field(MULTI_VALUED_FIELD_NAME)
    public void testSingleValuedFieldOrderedByNonMetricsOrMultiBucketSubAggregation() throws Exception {
        assertMultiSortResponse(
                    .field(SINGLE_VALUED_FIELD_NAME)
        Terms terms = allResponse.getAggregations().get("terms");
import static org.opensearch.search.aggregations.AggregationBuilders.stats;
                .getMissCount(),
                    .size(2)
        assertThat(filter2.getDocCount(), equalTo(asc ? 2L : 3L));
                )
        assertSearchResponse(response);
        assertThat(filter2.getDocCount(), equalTo(asc ? 3L : 2L));
                        filter("filter1", QueryBuilders.matchAllQuery()).subAggregation(
        assertThat(key(tag), equalTo(asc ? "less" : "more"));
                // expected
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, invalidValueType)) {
                        )
        // Tests subAgg doc count is the same with different collection modes and additional top level aggs
        assertThat(tags, notNullValue());
                    .get();
            } catch (OpenSearchException e) {
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
        }
                assertThat(bucket.getDocCount(), equalTo(1L));
package org.opensearch.search.aggregations.bucket.terms;
        assertThat(key(tag), equalTo(asc ? "less" : "more"));
                    .order(BucketOrder.aggregation("stats.sum_of_squares", asc))
                            Collections.emptyMap()
                terms("terms").executionHint(randomExecutionHint())
                    .field("tag")
                            .order(BucketOrder.aggregation("avg_i", true))
                    .field(SINGLE_VALUED_FIELD_NAME)
        // no execution hint so that the logic that decides whether or not to use ordinals is executed
        assertThat(terms.getName(), equalTo("terms"));
                terms("tags").executionHint(randomExecutionHint())
 * SPDX-License-Identifier: Apache-2.0
        assertThat(tag, notNullValue());
            client().admin()
        Script script = new Script(
                    )
            .get();
        tag = iters.next();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(tag, notNullValue());
        int i = 0;
import org.opensearch.search.aggregations.metrics.ExtendedStats;
        long docCount2 = f1.getBuckets().get(0).getDocCount();
        String[] expectedKeys = new String[] { "val1", "val2", "val4", "val3", "val7", "val6", "val5" };
        SearchResponse response = client().prepareSearch("idx")
        );
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();
        Terms terms = response.getAggregations().get("terms");
                            .subAggregation(stats("stats").field("i"))
            .addAggregation(
        assertThat(terms.getBuckets().size(), equalTo(6));
        assertSearchResponse(r);
                    )
                terms("terms").executionHint(randomExecutionHint())
        }
        );
            )
                        + "which is not of a metrics or single-bucket type"
                client().prepareSearch(index)
        assertThat(filter1, notNullValue());
                        .size(0)
    public void testSingleValuedFieldOrderedBySubAggregationAscMultiHierarchyLevelsSpecialChars() throws Exception {
        assertThat(terms, notNullValue());
    public void testMultiValueFieldWithPartitionedFiltering() throws Exception {
            Terms.Bucket bucket = terms.getBucketByKey("foo_val" + i);
            )
        assertSearchResponse(response);
                filter("filter", termQuery(MULTI_VALUED_FIELD_NAME, "val3")).subAggregation(
        assertThat(filter1.getDocCount(), equalTo(asc ? 2L : 3L));
            } else {
        );
            }
        Set<String> foundTerms = new HashSet<>();
                        new Script(
        Iterator<? extends Terms.Bucket> iters = tags.getBuckets().iterator();
            .get();
                .setRequestCache(true)
            assertThat(sum, notNullValue());
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        Terms.Bucket tag = iters.next();
        );
        Filter filter1 = tag.getAggregations().get("filter1");
                .indices()
        assertSearchResponse(response);
            i++;
        );
    public void testMultiValuedFieldWithValueScript() throws Exception {
        assertThat(tags, notNullValue());
            assertThat(bucket.getDocCount(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("_count")));
            .addAggregation(
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values())).executionHint(randomExecutionHint()).script(script)
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
            assertThat(bucket.getDocCount(), equalTo(1L));
            .get();
                    .subAggregation(extendedStats("stats").field("i"))
            client().admin()
            ScriptType.INLINE,
                );
        String statsName = statsNameBuilder.toString();
            .get();
                    .field("tag")
    public void testSingleValuedFieldOrderedByStatsAggAscWithTermsSubAgg() throws Exception {
                .getTotal()
        assertThat(terms, notNullValue());
        assertThat(stats, notNullValue());
            Terms terms = response.getAggregations().get("terms");
        }
            .get();
        for (int partition = 0; partition < numPartitions; partition++) {
            )
                .getRequestCache()
import org.opensearch.index.mapper.IndexFieldMapper;
        filter1 = tag.getAggregations().get("filter1");
                    )
            client().prepareIndex("cache_test_idx").setId("2").setSource("s", "bar")
                        + "where the metric name is not specified"
import java.util.Set;
        String statsName = statsNameBuilder.toString();
                        filter("filter1", QueryBuilders.matchAllQuery()).subAggregation(
                .getRequestCache()
            .get();
            "doc['" + SINGLE_VALUED_FIELD_NAME + "'].value",
        assertThat(terms.getName(), equalTo("terms"));
        String invalidValueType = source.replaceAll("\"value_type\":\"n.*\"", "\"value_type\":\"foobar\"");
    private void runTestFieldWithPartitionedFiltering(String field) throws Exception {
            SearchResponse response = client().prepareSearch("idx").setSource(SearchSourceBuilder.fromXContent(parser)).get();
        for (Terms.Bucket bucket : terms.getBuckets()) {
            client().prepareIndex("cache_test_idx").setId("1").setSource("s", "foo"),
        boolean asc = true;
        assertThat(tags.getName(), equalTo("tags"));
    public StringTermsIT(Settings staticSettings) {
                terms("tags").executionHint(randomExecutionHint())
        filter2 = filter1.getAggregations().get(filter2Name);
                .setRequestCache(true)
            assertThat(stats, notNullValue());
            .addAggregation(
        assertThat(filter1.getDocCount(), equalTo(asc ? 3L : 2L));
        filter = tag.getAggregations().get("filter");
            Terms.Bucket bucket = terms.getBucketByKey("val" + i);
        assertThat(tags.getBuckets().size(), equalTo(2));
                    .actionGet();
        stats = filter2.getAggregations().get(statsName);
        assertThat(filter2, notNullValue());
            .addAggregation(
 * not use this file except in compliance with the License.
                    .userValueTypeHint(randomFrom(ValueType.NUMERIC, ValueType.NUMBER))
                .get()
        // Test that a request using a deterministic script gets cached
import static org.hamcrest.Matchers.equalTo;
                )
        SearchResponse response = client().prepareSearch("sort_idx")
        String[] expectedKeys = new String[] { "val5", "val6", "val7", "val3", "val4", "val2", "val1" };
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationDescAndTermsAsc() throws Exception {
        for (int i = 0; i < 6; i++) {
                    terms("terms").executionHint(randomExecutionHint())
import java.util.Collections;
                )
        assertThat(terms.getName(), equalTo("terms"));
                    .order(BucketOrder.aggregation("filter1>filter2>stats.max", asc))
        filter1 = tag.getAggregations().get("filter1");
            assertThat(bucket, notNullValue());
                .prepareStats("cache_test_idx")
                fail(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        int i = 0;
import org.opensearch.search.builder.SearchSourceBuilder;
                terms("tags").executionHint(randomExecutionHint())
            )
                .setRequestCache(true)
        Terms tags = response.getAggregations().get("tags");
        assertThat(response.getFailedShards(), equalTo(0));
        StringBuilder filter2NameBuilder = new StringBuilder("filt.er2");
    }
            assertThat(stats, notNullValue());
        assertThat(tag, notNullValue());
            equalTo(0L)
            assertThat(bucket.getDocCount(), equalTo(1L));
                .indices()
 * software distributed under the License is distributed on an
            .get();
        stats = filter2.getAggregations().get("stats");
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                        terms("terms").executionHint(randomExecutionHint())
            Stats stats = bucket.getAggregations().get("stats");
            .addAggregation(AggregationBuilders.min("min").field("constant"))
        filter2NameBuilder.append(randomAlphaOfLengthBetween(3, 10).replace("[", "").replace("]", "").replace(">", ""));
                    .order(BucketOrder.aggregation("filter1>" + filter2Name + ">" + statsName + "[max]", asc))
                .getTotal()
        assertThat(exception.getMessage(), containsString("[size] must be greater than 0. Found [0] in [terms]"));
        assertThat(filter1, notNullValue());
        assertThat(filter, notNullValue());
        assertThat(terms, notNullValue());
        assertThat(filter2, notNullValue());
import org.opensearch.OpenSearchException;
        // Find total number of unique terms
            fail("Expected an exception");
import java.util.HashSet;
    }
                terms("terms").executionHint(randomExecutionHint())
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
            assertThat(sum.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("sum_d")));
import java.util.Arrays;
        assertThat(terms.getBuckets().size(), equalTo(5));
    }
                terms("terms").script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "42", Collections.emptyMap()))
            try {
            assertThat(bucket, notNullValue());
                terms("terms").executionHint(randomExecutionHint())
                assertThat(subBucket, notNullValue());
            assertThat(bucket, notNullValue());
                OpenSearchException rootCause = rootCauses[0];
                    )
            client().admin()
                    .field("s_value")
        assertThat(filter1.getDocCount(), equalTo(asc ? 3L : 2L));
        for (Terms.Bucket bucket : terms.getBuckets()) {
    }
     * val_count: 4 foo_val2 - doc_count: 2 - val_count: 4 foo_val3 - doc_count:
        Filter filter = response.getAggregations().get("filter");
            )
                            .order(BucketOrder.aggregation("stats.foo", true))
    }
        assertSearchResponse(response);
                    .addAggregation(
        Terms tags = response.getAggregations().get("tags");
                .get()
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    )
                terms("terms").executionHint(randomExecutionHint())
                    .field(SINGLE_VALUED_FIELD_NAME)
     * [foo_val0, foo_val1] [foo_val1, foo_val2] [foo_val2, foo_val3] [foo_val3,
                assertTrue(foundTerms.add(bucket.getKeyAsString()));
            f1 = terms.getBucketByKey(b1.getKeyAsString()).getAggregations().get("filter");
            .addAggregation(AggregationBuilders.min("min").field("constant"))
        for (SearchResponse response : new SearchResponse[] { r2, r3, r4 }) {
                .getRequestCache()
        Bucket b2 = terms.getBucketByKey("val1");
            .addAggregation(
        );
                    .size(2)
            )
        assertSearchResponse(response);
        filter2 = filter1.getAggregations().get("filter2");
                .indices()
        SearchResponse response = client().prepareSearch("idx")
    }
                    .order(BucketOrder.aggregation("filter1>" + filter2Name + ">" + statsName + ".max", asc))
    }
        assertThat(
    }
            ScriptType.INLINE,
            client().admin()
        assertThat(stats.getMax(), equalTo(asc ? 4.0 : 2.0));
                            filter(filter2Name, QueryBuilders.matchAllQuery()).subAggregation(stats(statsName).field("i"))
        for (int i = 0; i < 5; i++) {
            .addAggregation(
                terms("terms1").collectMode(SubAggCollectionMode.BREADTH_FIRST)
    public void testSingleValuedFieldWithValueScript() throws Exception {
            assertThat(bucket, notNullValue());
import static org.hamcrest.Matchers.instanceOf;
    /*
            .addAggregation(
        );
            }
                    .field("s_value")
                            filter(filter2Name, QueryBuilders.matchAllQuery()).subAggregation(stats(statsName).field("i"))
                )
    public void testScriptMultiValued() throws Exception {
        assertThat(terms.getName(), equalTo("terms"));
        SearchResponse response = client().prepareSearch("idx")
            } else {
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("sum_d", true), BucketOrder.aggregation("avg_l", true));
                .indices()
     * Ensure requests using nondeterministic scripts do not get cached.
        assertThat(stats, notNullValue());
            assertThat(key(bucket), equalTo("val" + i));
            .addAggregation(
import static org.opensearch.search.aggregations.AggregationBuilders.avg;
        SearchResponse r4 = client().prepareSearch("idx")
        // the max for "less" is 4
            assertThat(bucket, notNullValue());
            .get();
import static org.opensearch.search.aggregations.AggregationBuilders.extendedStats;
    public void testSingleValuedFieldOrderedByMultiValueExtendedStatsAsc() throws Exception {
            } catch (OpenSearchException e) {
        assertThat(tags.getName(), equalTo("tags"));
        assertThat(terms.getBuckets().size(), equalTo(2));
    }
            assertThat(bucket.getDocCount(), equalTo(1L));
            if (i == 0 || i == 5) {
        assertThat(terms, notNullValue());
                    .subAggregation(
        );
            Collections.emptyMap()
        assertThat(tags.getName(), equalTo("tags"));
            assertThat(key(bucket), equalTo("val" + i));
            client().prepareSearch("idx")
    public void testScriptCaching() throws Exception {
                .getTotal()
                        terms("terms").executionHint(randomExecutionHint())
        for (String index : Arrays.asList("idx", "idx_unmapped")) {
            assertThat(bucket, notNullValue());
        Terms terms = r1.getAggregations().get("terms1");
        assertThat(terms, notNullValue());
                .prepareStats("cache_test_idx")
    public void testStringTermsNestedIntoPerBucketAggregator() throws Exception {
                terms("terms").executionHint(randomExecutionHint())
        filter2NameBuilder.append(randomAlphaOfLengthBetween(3, 10).replace("[", "").replace("]", "").replace(">", ""));
        assertThat(terms.getBuckets().size(), equalTo(3));
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
                    .subAggregation(terms("subTerms").field("s_values").collectMode(randomFrom(SubAggCollectionMode.values())))
            assertThat(bucket, notNullValue());
    }
            assertThat(bucket.getDocCount(), equalTo(i == 3 ? 2L : 1L));
                terms("terms1").collectMode(SubAggCollectionMode.BREADTH_FIRST)
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
import static org.opensearch.index.query.QueryBuilders.termQuery;
        assertThat(key(tag), equalTo(asc ? "more" : "less"));
        );
                .getTotal()
                    )
                .setRequestCache(true)
            equalTo(1L)
                );
        tag = iters.next();
        SearchResponse response = client().prepareSearch("idx")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            )
 */
            assertThat(subTermsAgg.getBuckets().size(), equalTo(2));
                    .script(new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "'foo_' + _value", Collections.emptyMap()))
            assertThat(stats, notNullValue());
        }
        assertThat(terms.getName(), equalTo("terms"));
                .prepareStats("cache_test_idx")
 * under the License.
            .get();
        Terms terms = response.getAggregations().get("terms");
        assertSearchResponse(response);
        assertThat(terms, notNullValue());
                    "Expected search to fail when trying to sort terms aggregation by sug-aggregation "
            assertThat(avg.getValue(), equalTo(expectedMultiSortBuckets.get(expectedKeys[i]).get("avg_l")));
                terms("terms").executionHint(randomExecutionHint())
                    .subAggregation(AggregationBuilders.filters("filter", QueryBuilders.boolQuery()))
        Filter filter1 = tag.getAggregations().get("filter1");
 * KIND, either express or implied.  See the License for the
                .setSettings(Settings.builder().put("requests.cache.enable", true).put("number_of_shards", 1).put("number_of_replicas", 1))
import org.opensearch.common.settings.Settings;
        assertSearchResponse(response);
        SearchResponse r2 = client().prepareSearch("idx")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        // the max for "less" is 4
            assertThat(key(bucket), equalTo(i == 0 ? "idx" : "empty_bucket_idx"));
                .getMissCount(),
            terms = response.getAggregations().get("terms");
                    .subAggregation(sum("sum_d").field("d"))
        boolean asc = randomBoolean();
            for (Bucket bucket : terms.getBuckets()) {
        String filter2Name = filter2NameBuilder.toString();
        }
                fail(
            .get();
        }
        assertThat(tags, notNullValue());
            assertThat(bucket, notNullValue());
 */
        assertThat(stats.getMax(), equalTo(asc ? 2.0 : 4.0));
                .get()
        assertSearchResponse(r);
            IllegalArgumentException.class,
            Terms.Bucket bucket = terms.getBucketByKey("foo_val" + i);
        boolean asc = randomBoolean();
            )
        Terms terms = response.getAggregations().get("terms");
        assertThat(terms.getName(), equalTo("terms"));
            .get();
import static org.hamcrest.Matchers.containsString;
        SearchResponse response = client().prepareSearch("idx")
        assertThat(terms.getName(), equalTo("terms"));
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsDesc() throws Exception {
        assertThat(terms, notNullValue());
            ExtendedStats stats = bucket.getAggregations().get("stats");
        assertSearchResponse(response);
        assertThat(terms.getBuckets().size(), equalTo(5));
     *
        Terms terms = response.getAggregations().get("terms");
        }
            )
                assertThat(subBucket.getDocCount(), equalTo(1L));
        String filter2Name = filter2NameBuilder.toString();
        assertThat(stats.getMax(), equalTo(asc ? 4.0 : 2.0));
            Terms subTermsAgg = bucket.getAggregations().get("subTerms");
        assertThat(key(tag), equalTo(asc ? "more" : "less"));
    public void testSingleValuedFieldOrderedBySubAggregationAscMultiHierarchyLevelsSpecialCharsNoDotNotation() throws Exception {
        SearchSourceBuilder builder = new SearchSourceBuilder().size(0)
        assertThat(key(tag), equalTo(asc ? "less" : "more"));
            Sum sum = bucket.getAggregations().get("sum_d");
    }
        assertThat(filter1.getDocCount(), equalTo(asc ? 2L : 3L));
            )
            f2 = terms.getBucketByKey(b2.getKeyAsString()).getAggregations().get("filter");
        }
            equalTo(0L)
            )
                fail("Expected search to fail when trying to sort terms aggregation by sug-aggregation that doesn't exist");
                }
            )
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    "Expected search to fail when trying to sort terms aggregation by multi-valued sug-aggregation "
    public void testScriptWithValueType() throws Exception {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    public void testSingleValuedFieldOrderedBySingleValueSubAggregationAscAndTermsAsc() throws Exception {
            )
            )
        assertSearchResponse(response);
        StringBuilder statsNameBuilder = new StringBuilder("st.ats");
        assertThat(tag, notNullValue());
    public void testSingleValuedFieldOrderedByMultiValuedSubAggregationWithoutMetric() throws Exception {
                .getRequestCache()
                    )
        assertThat(filter.getDocCount(), equalTo(asc ? 2L : 3L));
                client().prepareSearch(index)
                // expected
        tag = iters.next();
            Collections.emptyMap()
            .get();
        assertThat(terms.getName(), equalTo("terms"));
            BucketOrder.aggregation("sum_d", false),
            .get();
        SearchResponse response = client().prepareSearch("idx")
                        )
                .get();
                    .subAggregation(filter("filter", QueryBuilders.matchAllQuery()))
            () -> client().prepareSearch("high_card_idx")
        Terms terms = response.getAggregations().get("terms");
        assertThat(tag, notNullValue());
            assertThat(key(bucket), equalTo("foo_val" + i));
        assertThat(filter2, notNullValue());
import org.opensearch.common.xcontent.json.JsonXContent;
                    .executionHint(randomExecutionHint())
                        .field(SINGLE_VALUED_FIELD_NAME)
        SearchResponse response = client().prepareSearch("idx", "idx_unmapped")
            }
            prepareCreate("cache_test_idx").setMapping("d", "type=keyword")
            )
                    .subAggregation(avg("avg_l").field("l"))
                // expected
                .getTotal()
            try {
import org.opensearch.search.aggregations.metrics.Stats;
            .addAggregation(
public class StringTermsIT extends BaseStringTermsTestCase {
        }
        assertSearchResponse(response);
                );
        assertThat(terms.getName(), equalTo("terms"));
    public void testSizeIsZero() {
                .get()
            assertSearchResponse(response);
            .get();
        assertThat(terms.getName(), equalTo("terms"));
        Terms.Bucket tag = iters.next();
    }
/*
            .addAggregation(
            assertThat(bucket, notNullValue());
            equalTo(2L)
                .setRequestCache(true)
            try {
        assertThat(stats, notNullValue());
        }
                .get()
        assertSearchResponse(response);
        assertThat(filter2.getDocCount(), equalTo(asc ? 2L : 3L));
                        .order(BucketOrder.aggregation("inner_terms>avg", asc))
import org.opensearch.action.search.SearchResponse;
        assertThat(
            assertThat(bucket, notNullValue());
        assertThat(terms, notNullValue());
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", true), BucketOrder.key(false));
                    .order(BucketOrder.compound(order))
            client().admin()
            equalTo(0L)
import org.opensearch.search.aggregations.bucket.filter.InternalFilters;
                    .get();
                    .subAggregation(stats("stats").field("i"))
        Terms.Bucket bucket = terms.getBucketByKey("val");
        assertThat(terms, notNullValue());
 * GitHub history for details.
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
            assertThat(terms.getBuckets().size(), equalTo(1));
                .indices()
     *
        stats = filter2.getAggregations().get(statsName);
        for (int i = 0; i < 5; i++) {
        runTestFieldWithPartitionedFiltering(MULTI_VALUED_FIELD_NAME);
            i++;
                    .order(BucketOrder.aggregation("stats.sum_of_squares", asc))
            .addAggregation(
        Filter filter = tag.getAggregations().get("filter");
            assertThat(key(bucket), equalTo(expectedKeys[i]));
                    .field(SINGLE_VALUED_FIELD_NAME)
            .addAggregation(
        } catch (SearchPhaseExecutionException e) {
                    .addAggregation(
                        terms("terms").executionHint(randomExecutionHint())
        assertThat(filter2.getDocCount(), equalTo(asc ? 3L : 2L));
        assertThat(terms.getBuckets().size(), equalTo(5));
        Filter filter2 = filter1.getAggregations().get("filter2");
        assertThat(key(tag), equalTo(asc ? "less" : "more"));
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values()))
            assertThat(stats.getMax(), equalTo((double) i));
        assertThat(filter2.getDocCount(), equalTo(asc ? 3L : 2L));
import org.opensearch.index.query.QueryBuilders;
    public void testSingleValuedFieldOrderedByThreeCriteria() throws Exception {
        }
        SearchResponse response = client().prepareSearch("idx")
    }
            i--;
        assertThat(terms, notNullValue());
                            ScriptType.INLINE,
        assertThat(terms.getName(), equalTo("terms"));
                } else {
                            .field(SINGLE_VALUED_FIELD_NAME)
            i++;
        assertThat(tag, notNullValue());
 * Unless required by applicable law or agreed to in writing,
            assertThat(bucket, notNullValue());
            } else {
        );
    }
                    .subAggregation(AggregationBuilders.filters("filter", QueryBuilders.boolQuery()))
                .indices()
    }
                assertThat(bucket.getDocCount(), equalTo(2L));
        for (int i = 0; i < 5; i++) {
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
        assertThat(terms, notNullValue());
        tag = iters.next();
            assertThat(bucket.getDocCount(), equalTo(1L));
        assertSearchResponse(allResponse);
        assertThat(
    }
 * license agreements. See the NOTICE file distributed with
import org.opensearch.search.aggregations.AggregationExecutionException;
                    .field(SINGLE_VALUED_FIELD_NAME)
                .getTotal()
                    .subAggregation(AggregationBuilders.filters("filter", QueryBuilders.boolQuery()))
        for (int i = 2; i <= 4; i++) {
                    .executionHint(randomExecutionHint())
            }
        filter2 = filter1.getAggregations().get(filter2Name);
                    .field(IndexFieldMapper.NAME)
        boolean asc = true;
            BucketOrder.count(false),
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationDesc() throws Exception {
            if (i == 0 || i == 5) {
        assertThat(terms, notNullValue());
        assertThat(tag.getDocCount(), equalTo(asc ? 3L : 2L));
        SearchResponse r = client().prepareSearch("cache_test_idx")
        Filter filter2 = filter1.getAggregations().get(filter2Name);
                .getRequestCache()
 * compatible open source license.
    }
        );
                    .field("tag")
        assertThat(terms.getBuckets().size(), equalTo(5));
            }
        }
        assertThat(tags.getBuckets().size(), equalTo(2));
        long docCount1 = f1.getBuckets().get(0).getDocCount();
            )
            .addAggregation(
            .get();
        r = client().prepareSearch("cache_test_idx")
        assertThat(terms, notNullValue());
            i++;
        assertNotNull(r1.getAggregations().get("terms1"));
                            .order(BucketOrder.aggregation("stats", true))
                terms("terms").executionHint(randomExecutionHint())
                            CustomScriptPlugin.NAME,
            assertThat(bucket.getDocCount(), equalTo(i == 0 ? 5L : 2L));
            .addAggregation(
            if (i == 0 || i == 5) {
        // Make sure we are starting with a clear cache
        assertThat(tags.getName(), equalTo("tags"));
                        filter("filter1", QueryBuilders.matchAllQuery()).subAggregation(
        }
    public void testSingleValuedFieldOrderedByMultiValueSubAggregationAsc() throws Exception {
        boolean asc = randomBoolean();
                    .subAggregation(
        assertThat(terms.getBuckets().size(), equalTo(1));
        Terms terms = response.getAggregations().get("terms");
                            .field(SINGLE_VALUED_FIELD_NAME)
            .get();
                    .script(
                    .order(BucketOrder.aggregation("filter", asc))
        Terms terms = response.getAggregations().get("terms");
            Stats stats = bucket.getAggregations().get("stats");
import org.opensearch.core.xcontent.XContentParser;
        assertThat(terms, notNullValue());
                .setRequestCache(true)
     *
     * 2 - val_count: 4 foo_val4 - doc_count: 2 - val_count: 4 foo_val5 -
 * The OpenSearch Contributors require contributions made to
            )
        Terms terms = response.getAggregations().get("terms");
        }
            .aggregation(
        assertThat(filter, notNullValue());
        // the max for "more" is 2
                    .field(MULTI_VALUED_FIELD_NAME)
            assertThat(key(bucket), equalTo("val" + i));
        assertThat(filter2, notNullValue());
        Terms tags = response.getAggregations().get("tags");
                .get()
            assertThat(key(bucket), equalTo("val" + i));
        Terms terms = filter.getAggregations().get("terms");
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(filter1, notNullValue());
        assertThat(filter1.getDocCount(), equalTo(asc ? 2L : 3L));
                        new Script(
            assertEquals(docCount1, f1.getBuckets().get(0).getDocCount());
        assertThat(tag.getDocCount(), equalTo(asc ? 2L : 3L));
        assertSearchResponse(response);
                    .addAggregation(
        }
        assertMultiSortResponse(expectedKeys, BucketOrder.aggregation("avg_l", false), BucketOrder.key(true));
     */
                            .order(BucketOrder.aggregation("values", true))
        Terms terms = response.getAggregations().get("terms");
        assertThat(bucket.getDocCount(), equalTo(5L));
    }
            )
     * Make sure that a request using a deterministic script or not using a script get cached.
                terms("terms").collectMode(randomFrom(SubAggCollectionMode.values()))
                            .collectMode(randomFrom(SubAggCollectionMode.values()))
        Script script = new Script(
                .prepareStats("cache_test_idx")
        assertThat(filter2.getDocCount(), equalTo(asc ? 2L : 3L));
 * specific language governing permissions and limitations
                .getRequestCache()
                            "doc['" + MULTI_VALUED_FIELD_NAME + "']",
        IllegalArgumentException exception = expectThrows(
                    .subAggregation(
        assertThat(terms, notNullValue());
                assertThat(bucket.getDocCount(), equalTo(2L));
        boolean asc = false;
                    terms("terms").executionHint(randomExecutionHint())
import org.opensearch.search.aggregations.AggregationBuilders;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .addAggregation(
        assertThat(
        Terms.Bucket tag = iters.next();
import org.opensearch.script.ScriptType;
        int expectedCardinality = terms.getBuckets().size();
                terms("terms1").collectMode(SubAggCollectionMode.DEPTH_FIRST)
        assertThat(terms.getBuckets().size(), equalTo(5));
        assertAcked(
            .get();
        boolean asc = true;
        assertThat(
        SearchResponse response = client().prepareSearch("idx")
        assertThat(terms.getName(), equalTo("terms"));
            }
            i++;
        assertThat(stats, notNullValue());
                .get()
                    terms("terms").field(MULTI_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values()))
    }
        assertThat(filter1.getDocCount(), equalTo(asc ? 3L : 2L));
 *
                .get()
            .addAggregation(
        Terms terms = response.getAggregations().get("terms");
            try {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        );
            .setSize(0)
        assertThat(key(bucket), equalTo("val"));
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        }
        filter1 = tag.getAggregations().get("filter1");
    }
        int i = 0;
            );
 * ownership. Elasticsearch licenses this file to you under
    public void testScriptSingleValue() throws Exception {
    /**
        assertThat(tags, notNullValue());
            assertThat(key(bucket), equalTo("val" + i));
        assertThat(terms.getBuckets().size(), equalTo(5));
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
                    .order(BucketOrder.aggregation("stats.avg", asc))
    public void testScriptSingleValueExplicitSingleValue() throws Exception {
        final int minDocCount = randomInt(1);
                // expected
        Terms terms = response.getAggregations().get("terms");
                    .subAggregation(stats("stats").field("i"))
            assertThat(stats.getMax(), equalTo((double) i));
        // Gather terms using partitioned aggregations
        for (Terms.Bucket bucket : terms.getBuckets()) {
        assertThat(terms.getName(), equalTo("terms"));
        String source = builder.toString();
                        )
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            } else {
                terms("terms").executionHint(randomExecutionHint())
        assertThat(terms.getBuckets().size(), equalTo(5));
        assertThat(terms.getBuckets().size(), equalTo(5));
    // the main purpose of this test is to make sure we're not allocating 2GB of memory per shard
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    }
     * doc_count: 1 - val_count: 2
            assertThat(key(bucket), equalTo("val" + i));
            )
        InternalFilters f2 = b2.getAggregations().get("filter");
            assertThat(bucket.getDocCount(), equalTo(1L));
    }
                    .get();
                .setRequestCache(true)
            .get();
        assertMultiSortResponse(expectedKeys, BucketOrder.count(true), BucketOrder.aggregation("avg_l", true));
    }
        InternalFilters f1 = b1.getAggregations().get("filter");
    public void testDeferredSubAggs() {
            assertThat(avg, notNullValue());
    public void testPartiallyUnmapped() throws Exception {
                    terms("terms").field(field)
                .get()
            BucketOrder.aggregation("avg_l", false)
import org.opensearch.search.aggregations.support.ValueType;
            true,
            assertThat(stats.getMax(), equalTo((double) i));
                    .field(SINGLE_VALUED_FIELD_NAME)
        String[] expectedKeys = new String[] { "val1", "val2", "val3", "val4", "val5", "val6", "val7" };
                    .size(2)
        assertThat(
                        + "with an unknown specified metric to order by. response had "
