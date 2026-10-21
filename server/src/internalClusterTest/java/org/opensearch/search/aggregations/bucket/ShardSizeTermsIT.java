        assertThat(buckets.size(), equalTo(3));
        assertThat(buckets.size(), equalTo(3)); // we still only return 3 entries (based on the 'size' param)
        expected.put(3, 8L);
            .setRouting(routing1)
            .addAggregation(
            )
            expectedDocCount = expected.get(bucket.getKeyAsNumber().intValue());
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
        }
        }
        expected.put("2", 5L);
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
    public void testNoShardSizeString() throws Exception {
        createIdx("type=keyword");
                    .shardSize(5)
 * the Apache License, Version 2.0 (the "License"); you may
            )
        expected.put(3, 8L);
        SearchResponse response = client().prepareSearch("idx")
                terms("keys").field("key")
        for (Terms.Bucket bucket : buckets) {
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
 * this work for additional information regarding copyright
            .get();
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            expectedDocCount = expected.get(bucket.getKeyAsNumber().intValue());
        assertThat(buckets.size(), equalTo(3));
        expected.put(1, 8L);
        for (Terms.Bucket bucket : buckets) {
 *
        SearchResponse response = client().prepareSearch("idx")
        expected.put(1, 8L);
        createIdx("type=double");
        assertThat(buckets.size(), equalTo(3)); // we still only return 3 entries (based on the 'size' param)
    }
    }
            )
            assertTrue((bucket.getDocCount() == expectedDocCount) || bucket.getDocCount() + bucket.getDocCountError() >= expectedDocCount);
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
        Map<Integer, Long> expected = new HashMap<>();
        SearchResponse response = client().prepareSearch("idx")
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        SearchResponse response = client().prepareSearch("idx")
        expected.put(3, 8L);
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                terms("keys").field("key")
 *    http://www.apache.org/licenses/LICENSE-2.0
            )
            .addAggregation(
        indexData();
        expected.put(3, 3L);
            .setQuery(matchAllQuery())
        Terms terms = response.getAggregations().get("keys");
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.count(false))
            .addAggregation(
            // Doc count can vary when using concurrent segment search. See https://github.com/opensearch-project/OpenSearch/issues/11680
        expected.put(2, 4L);
        expected.put("1", 8L);
        createIdx("type=long");
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        indexData();
 * ownership. Elasticsearch licenses this file to you under
                    .size(3)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        Terms terms = response.getAggregations().get("keys");
        for (Terms.Bucket bucket : buckets) {
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
 * Modifications Copyright OpenSearch Contributors. See
            .setQuery(matchAllQuery())
        Map<Integer, Long> expected = new HashMap<>();
        }
        for (Terms.Bucket bucket : buckets) {
 * GitHub history for details.
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsString())));
        expected.put(2, 5L); // <-- count is now fixed
        SearchResponse response = client().prepareSearch("idx")
        for (Terms.Bucket bucket : buckets) {
                    .shardSize(3)
 * SPDX-License-Identifier: Apache-2.0
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.count(false))
        assertThat(buckets.size(), equalTo(3));
    public void testShardSizeEqualsSizeString() throws Exception {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
            .setQuery(matchAllQuery())
            )
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        SearchResponse response = client().prepareSearch("idx")
            .setQuery(matchAllQuery())
    public void testWithShardSizeLong() throws Exception {
                    .order(BucketOrder.count(false))
        Terms terms = response.getAggregations().get("keys");
    }
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        }
            // Doc count can vary when using concurrent segment search. See https://github.com/opensearch-project/OpenSearch/issues/11680
    public void testNoShardSizeLong() throws Exception {
        expected.put("3", 3L); // <-- count is now fixed
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
    public void testNoShardSizeTermOrderString() throws Exception {
            .get();
/*
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
 * specific language governing permissions and limitations
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsString())));
        }
        Map<Integer, Long> expected = new HashMap<>();
        SearchResponse response = client().prepareSearch("idx")
                    .order(BucketOrder.count(false))
            .get();
    }
                terms("keys").field("key")
    }
        assertThat(buckets.size(), equalTo(3));
                    .order(BucketOrder.count(false))
                    .showTermDocCountError(true)
    }
            .get();
        Map<Integer, Long> expected = new HashMap<>();
        expected.put("1", 8L);
        expected.put("3", 8L);
        expected.put(3, 8L);
            .setQuery(matchAllQuery())
        Map<Integer, Long> expected = new HashMap<>();
                    .order(BucketOrder.count(false))
            .setRouting(routing1)
import java.util.Map;
                    .size(3)
        expected.put("1", 8L);
        expected.put(3, 3L);
            .get();
    }
            .addAggregation(
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        expected.put("1", 8L);
        expected.put(2, 4L);
    public void testWithShardSizeStringSingleShard() throws Exception {
    public void testWithShardSizeLongSingleShard() throws Exception {
        Map<Integer, Long> expected = new HashMap<>();
        }
        for (Terms.Bucket bucket : buckets) {
        expected.put("1", 5L);
        super(staticSettings);
            .setQuery(matchAllQuery())
        expected.put("2", 4L);
package org.opensearch.search.aggregations.bucket;
        expected.put(3, 8L);
 * KIND, either express or implied.  See the License for the
        expected.put(3, 8L);
                terms("keys").field("key")
        Terms terms = response.getAggregations().get("keys");
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            .addAggregation(
    public void testWithShardSizeDouble() throws Exception {
            .addAggregation(
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsString())));
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
                    .shardSize(5)
        expected.put(2, 5L);
 * this file be licensed under the Apache-2.0 license or a
        indexData();
import static org.hamcrest.Matchers.equalTo;
            .get();
 * software distributed under the License is distributed on an
        Terms terms = response.getAggregations().get("keys");
        createIdx("type=keyword");
}
import org.opensearch.common.settings.Settings;
import org.opensearch.action.search.SearchResponse;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to
        expected.put(2, 5L);
        Long expectedDocCount;
        createIdx("type=long");
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        }
        }
        for (Terms.Bucket bucket : buckets) {
                    .order(BucketOrder.count(false))
        indexData();
        expected.put("3", 8L);
        SearchResponse response = client().prepareSearch("idx")
        assertThat(buckets.size(), equalTo(3)); // we still only return 3 entries (based on the 'size' param)
            .addAggregation(
                    .shardSize(5)
    }
 */
                    .order(BucketOrder.count(false))
        Terms terms = response.getAggregations().get("keys");
        for (Terms.Bucket bucket : buckets) {
public class ShardSizeTermsIT extends ShardSizeTestCase {
        Terms terms = response.getAggregations().get("keys");
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
            .addAggregation(
        indexData();
        createIdx("type=double");
        expected.put(2, 5L); // <-- count is now fixed
            .setQuery(matchAllQuery())
                terms("keys").field("key")
    }
                    .showTermDocCountError(true)
        expected.put(2, 4L);
 * Unless required by applicable law or agreed to in writing,
            .setQuery(matchAllQuery())
    }
        indexData();
            .addAggregation(
        indexData();
            )
        assertThat(buckets.size(), equalTo(3));
 * You may obtain a copy of the License at
        indexData();
        expected.put(1, 8L);
            assertTrue((bucket.getDocCount() == expectedDocCount) || bucket.getDocCount() + bucket.getDocCountError() >= expectedDocCount);
            )
            .get();
        Terms terms = response.getAggregations().get("keys");
            .get();
        for (Terms.Bucket bucket : buckets) {
        expected.put(2, 5L);
        expected.put(1, 8L);
            .setRouting(routing1)
        indexData();
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
            )
                    .order(BucketOrder.count(false))
 * license agreements. See the NOTICE file distributed with
            assertTrue((bucket.getDocCount() == expectedDocCount) || bucket.getDocCount() + bucket.getDocCountError() >= expectedDocCount);
                terms("keys").field("key")
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.key(true))
        expected.put("2", 5L); // <-- count is now fixed
            .setQuery(matchAllQuery())
        createIdx("type=keyword");
            .setQuery(matchAllQuery())
    public void testShardSizeEqualsSizeDouble() throws Exception {
                    .size(3)
        }
            .get();
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
        SearchResponse response = client().prepareSearch("idx")
        expected.put("2", 5L);
/*
                    .shardSize(3)
/*
        indexData();
        Terms terms = response.getAggregations().get("keys");
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
            .addAggregation(
        createIdx("type=long");
 * compatible open source license.
    }
            )
            )
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            .setQuery(matchAllQuery())
        expected.put(1, 8L);
        SearchResponse response = client().prepareSearch("idx")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        expected.put(3, 8L);
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.count(false))
        assertThat(buckets.size(), equalTo(3));
                    .shardSize(5)
        Map<String, Long> expected = new HashMap<>();
            .get();
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        for (Terms.Bucket bucket : buckets) {
                    .showTermDocCountError(true)
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
                    .size(3)
                    .size(3)
            )
            expectedDocCount = expected.get(bucket.getKeyAsString());
 * Licensed to Elasticsearch under one or more contributor
        }
            )
        createIdx("type=long");
        indexData();
        Terms terms = response.getAggregations().get("keys");
 */
                    .order(BucketOrder.count(false))
        Terms terms = response.getAggregations().get("keys");
    public void testWithShardSizeString() throws Exception {
import java.util.HashMap;
        assertThat(buckets.size(), equalTo(3));
        Terms terms = response.getAggregations().get("keys");
            .get();
    public void testNoShardSizeTermOrderDouble() throws Exception {
        SearchResponse response = client().prepareSearch("idx")
        expected.put(1, 5L);
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.key(true))
        assertThat(buckets.size(), equalTo(3)); // we still only return 3 entries (based on the 'size' param)
                    .size(3)
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        createIdx("type=long");
        }
                    .shardSize(5)
        createIdx("type=double");
        expected.put(3, 8L);
        for (Terms.Bucket bucket : buckets) {
    }
    }
        assertThat(buckets.size(), equalTo(3));
            )
        Long expectedDocCount;
        expected.put("3", 8L);
        }
        Map<Integer, Long> expected = new HashMap<>();
        createIdx("type=double");
            )
                    .order(BucketOrder.count(false))
            .addAggregation(
 */
        Map<Integer, Long> expected = new HashMap<>();
        Map<String, Long> expected = new HashMap<>();
            .addAggregation(
            .addAggregation(
        Map<String, Long> expected = new HashMap<>();
    public void testNoShardSizeDouble() throws Exception {
        for (Terms.Bucket bucket : buckets) {
                terms("keys").field("key")
        expected.put(1, 5L);
                terms("keys").field("key")
            .setQuery(matchAllQuery())
                    .shardSize(3)
        expected.put(1, 8L);
        Long expectedDocCount;
            .setQuery(matchAllQuery())
 *
import org.opensearch.search.aggregations.bucket.terms.Terms;
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKey())));
            )
            .get();
        Terms terms = response.getAggregations().get("keys");
        Map<Integer, Long> expected = new HashMap<>();
        createIdx("type=double");
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
    }
        expected.put(1, 8L);
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
        assertThat(buckets.size(), equalTo(3));
        indexData();
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
        SearchResponse response = client().prepareSearch("idx")
        createIdx("type=keyword");
        assertThat(buckets.size(), equalTo(3));
        for (Terms.Bucket bucket : buckets) {
        createIdx("type=keyword");
 * under the License.
        expected.put(2, 4L);
        Terms terms = response.getAggregations().get("keys");
        expected.put(2, 5L);
        expected.put("2", 4L);
            .get();
                    .size(3)
        }
        Terms terms = response.getAggregations().get("keys");
            // Doc count can vary when using concurrent segment search. See https://github.com/opensearch-project/OpenSearch/issues/11680
        Map<String, Long> expected = new HashMap<>();
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.key(true))
                    .size(3)
    public void testWithShardSizeDoubleSingleShard() throws Exception {
import java.util.List;
            .get();
            .setQuery(matchAllQuery())
        SearchResponse response = client().prepareSearch("idx")
import org.opensearch.search.aggregations.BucketOrder;
        expected.put("3", 8L);
            .setQuery(matchAllQuery())
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        expected.put(1, 8L);
        indexData();
                    .shardSize(5)
        indexData();
        SearchResponse response = client().prepareSearch("idx")
        indexData();
        for (Terms.Bucket bucket : buckets) {
        Map<String, Long> expected = new HashMap<>();
    }
                terms("keys").field("key")
            .get();
            .addAggregation(
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        Map<Integer, Long> expected = new HashMap<>();
        }
 *
                    .size(3)
    }
    public ShardSizeTermsIT(Settings staticSettings) {
        assertThat(buckets.size(), equalTo(3));
        }
    public void testNoShardSizeTermOrderLong() throws Exception {
        for (Terms.Bucket bucket : buckets) {
    public void testShardSizeEqualsSizeLong() throws Exception {
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
