                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.count(false))
                    .order(BucketOrder.count(false))
        expected.put("1", 5L);
            .get();
                    .order(BucketOrder.count(false))
                    .shardSize(5)
        indexData();  
            .setQuery(matchAllQuery())
    public ShardSizeTermsIT(Settings staticSettings) {
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
                    .order(BucketOrder.count(false))
        }
        indexData();
        for (Terms.Bucket bucket : buckets) {  
        indexData();  
            .setQuery(matchAllQuery())
        for (Terms.Bucket bucket : buckets) {
 */  
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKey())));
            .setQuery(matchAllQuery())
            .setQuery(matchAllQuery())
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            .setRouting(routing1)
    public void testNoShardSizeLong() throws Exception {  
                    .order(BucketOrder.count(false))  
import org.opensearch.search.aggregations.BucketOrder;  
        createIdx("type=keyword");
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
            .get();  
                    .size(3)  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        Map<String, Long> expected = new HashMap<>();
                    .showTermDocCountError(true)
                    .size(3)
    public void testShardSizeEqualsSizeDouble() throws Exception {  
        expected.put(1, 8L);
        expected.put(1, 8L);
 * Modifications Copyright OpenSearch Contributors. See  
        indexData();  
            .get();
        SearchResponse response = client().prepareSearch("idx")
                    .showTermDocCountError(true)
        expected.put(2, 4L);
        }  
        Map<String, Long> expected = new HashMap<>();  
        indexData();
    public void testShardSizeEqualsSizeLong() throws Exception {  
            .addAggregation(
/*
        assertThat(buckets.size(), equalTo(3)); // we still only return 3 entries (based on the 'size' param)
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
            .setQuery(matchAllQuery())
        Terms terms = response.getAggregations().get("keys");
 * this file be licensed under the Apache-2.0 license or a
                    .shardSize(3)
        expected.put(3, 8L);
        createIdx("type=long");
        }
        assertThat(buckets.size(), equalTo(3));  
        expected.put(2, 4L);
        for (Terms.Bucket bucket : buckets) {
/*
            .addAggregation(  
            .get();
            .get();
    public void testWithShardSizeLongSingleShard() throws Exception {  
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
            .setQuery(matchAllQuery())  
        Map<Integer, Long> expected = new HashMap<>();
        Terms terms = response.getAggregations().get("keys");  
                    .size(3)
    public void testWithShardSizeString() throws Exception {
                    .order(BucketOrder.count(false))
        Terms terms = response.getAggregations().get("keys");
        Map<Integer, Long> expected = new HashMap<>();  
        expected.put(2, 4L);
        assertThat(buckets.size(), equalTo(3));
                    .shardSize(5)
            )
        super(staticSettings);
 * You may obtain a copy of the License at  
 * GitHub history for details.
            .setQuery(matchAllQuery())
            )  
        Terms terms = response.getAggregations().get("keys");
        expected.put("1", 8L);
        Terms terms = response.getAggregations().get("keys");
 * KIND, either express or implied.  See the License for the
            expectedDocCount = expected.get(bucket.getKeyAsNumber().intValue());
        createIdx("type=double");
    }
            .get();
        Map<Integer, Long> expected = new HashMap<>();  
                    .size(3)
        assertThat(buckets.size(), equalTo(3));
        expected.put("1", 8L);
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
        Long expectedDocCount;
                    .shardSize(3)  
            .setQuery(matchAllQuery())
        expected.put(3, 8L);
        Map<Integer, Long> expected = new HashMap<>();
            .addAggregation(  
    public void testNoShardSizeString() throws Exception {
            .setQuery(matchAllQuery())
    }  
            .get();  
        Terms terms = response.getAggregations().get("keys");
        Terms terms = response.getAggregations().get("keys");  
            assertTrue((bucket.getDocCount() == expectedDocCount) || bucket.getDocCount() + bucket.getDocCountError() >= expectedDocCount);
            .setQuery(matchAllQuery())  
    public void testWithShardSizeStringSingleShard() throws Exception {  
        Long expectedDocCount;  
        expected.put("2", 4L);
        createIdx("type=double");
            expectedDocCount = expected.get(bucket.getKeyAsString());
                    .shardSize(5)
            .addAggregation(  
 */
    }
        createIdx("type=keyword");  
        expected.put(1, 5L);
                terms("keys").field("key")
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
        SearchResponse response = client().prepareSearch("idx")
    }  
        SearchResponse response = client().prepareSearch("idx")
        }
        expected.put(1, 8L);  
 * SPDX-License-Identifier: Apache-2.0
            .setQuery(matchAllQuery())
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        }  
    public void testWithShardSizeDoubleSingleShard() throws Exception {  
            )
                    .size(3)
        expected.put(1, 8L);
                    .order(BucketOrder.count(false))
            .addAggregation(
        SearchResponse response = client().prepareSearch("idx")
        expected.put("1", 8L);
        assertThat(buckets.size(), equalTo(3)); // we still only return 3 entries (based on the 'size' param)
        for (Terms.Bucket bucket : buckets) {
        expected.put(2, 5L);  
                    .shardSize(5)  
 * compatible open source license.
        Map<Integer, Long> expected = new HashMap<>();  
    public void testWithShardSizeLong() throws Exception {
    }
        SearchResponse response = client().prepareSearch("idx")
import java.util.List;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
                terms("keys").field("key")
        expected.put(3, 8L);  
    public void testNoShardSizeDouble() throws Exception {  
    }
        }  
        expected.put(3, 8L);
 * software distributed under the License is distributed on an
        for (Terms.Bucket bucket : buckets) {
        indexData();
            )  
            .get();  
        expected.put("3", 3L); // <-- count is now fixed  
        assertThat(buckets.size(), equalTo(3));
        createIdx("type=long");
        }  
                    .size(3)  
 * under the License.  
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsString())));
            )
        assertThat(buckets.size(), equalTo(3));
                    .shardSize(5)
        indexData();
        for (Terms.Bucket bucket : buckets) {
        for (Terms.Bucket bucket : buckets) {
        expected.put(2, 5L);
        SearchResponse response = client().prepareSearch("idx")  
        expected.put(2, 5L); // <-- count is now fixed  
        createIdx("type=long");  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        }  
        createIdx("type=keyword");
    }  
            .setRouting(routing1)  
    }
            .addAggregation(  
            .get();
        indexData();
        expected.put(3, 8L);
import static org.hamcrest.Matchers.equalTo;  
 * license agreements. See the NOTICE file distributed with
            )  
                    .showTermDocCountError(true)
        }  
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.count(false))
        assertThat(buckets.size(), equalTo(3)); // we still only return 3 entries (based on the 'size' param)
        createIdx("type=keyword");  
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
                terms("keys").field("key")
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        expected.put(2, 5L);  
        indexData();  
            .addAggregation(
        indexData();
        expected.put("3", 8L);
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.key(true))
            .setQuery(matchAllQuery())  
            // Doc count can vary when using concurrent segment search. See https://github.com/opensearch-project/OpenSearch/issues/11680  
            )  
            )  
    public void testWithShardSizeDouble() throws Exception {
            )
    public void testNoShardSizeTermOrderLong() throws Exception {  
        for (Terms.Bucket bucket : buckets) {  
        Map<String, Long> expected = new HashMap<>();  
        expected.put(3, 3L);
            .addAggregation(  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        Terms terms = response.getAggregations().get("keys");  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
 * this work for additional information regarding copyright
        SearchResponse response = client().prepareSearch("idx")
    }
import org.opensearch.common.settings.Settings;
        expected.put(3, 3L);  
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
        expected.put("3", 8L);
        expected.put(1, 5L);  
            // Doc count can vary when using concurrent segment search. See https://github.com/opensearch-project/OpenSearch/issues/11680
 *
        for (Terms.Bucket bucket : buckets) {
            .addAggregation(  
            )  
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.key(true))
        expected.put("3", 8L);  
            .get();  
                    .size(3)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
            .get();
        indexData();
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsNumber().intValue())));
    }
    public void testNoShardSizeTermOrderString() throws Exception {  
 * Licensed to Elasticsearch under one or more contributor  
        for (Terms.Bucket bucket : buckets) {  
        createIdx("type=double");  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
 *
            .setRouting(routing1)
            .get();
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
        expected.put(1, 8L);
        Terms terms = response.getAggregations().get("keys");  
        SearchResponse response = client().prepareSearch("idx")
            .addAggregation(
    }  
import java.util.Map;
        assertThat(buckets.size(), equalTo(3));
            // Doc count can vary when using concurrent segment search. See https://github.com/opensearch-project/OpenSearch/issues/11680  
 *  
        SearchResponse response = client().prepareSearch("idx")
            assertTrue((bucket.getDocCount() == expectedDocCount) || bucket.getDocCount() + bucket.getDocCountError() >= expectedDocCount);  
                    .shardSize(5)
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        SearchResponse response = client().prepareSearch("idx")  
 */
        expected.put("3", 8L);  
        assertThat(buckets.size(), equalTo(3));
            .setQuery(matchAllQuery())  
 * ownership. Elasticsearch licenses this file to you under  
        expected.put(1, 8L);  
                    .order(BucketOrder.count(false))
            )
        assertThat(buckets.size(), equalTo(3));
    public void testShardSizeEqualsSizeString() throws Exception {
            .get();
        assertThat(buckets.size(), equalTo(3));
                    .order(BucketOrder.count(false))
        }  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        createIdx("type=keyword");  
        Map<Integer, Long> expected = new HashMap<>();  
        indexData();  
        Long expectedDocCount;  
            )  
        Map<Integer, Long> expected = new HashMap<>();
        }  
        Terms terms = response.getAggregations().get("keys");  
            )  
                    .size(3)
    }
        createIdx("type=long");
            .get();  
        Map<Integer, Long> expected = new HashMap<>();  
        Terms terms = response.getAggregations().get("keys");
        expected.put(1, 8L);
        expected.put(3, 8L);
    }  
        assertThat(buckets.size(), equalTo(3));
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (Terms.Bucket bucket : buckets) {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
            .addAggregation(  
        Terms terms = response.getAggregations().get("keys");  
            .addAggregation(
        expected.put("2", 4L);
            .setQuery(matchAllQuery())  
    public void testNoShardSizeTermOrderDouble() throws Exception {
            .addAggregation(
        }
        expected.put("1", 8L);  
        createIdx("type=double");  
                terms("keys").field("key")
        indexData();  
        SearchResponse response = client().prepareSearch("idx")
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.count(false))
                    .order(BucketOrder.count(false))
public class ShardSizeTermsIT extends ShardSizeTestCase {
        expected.put(1, 8L);  
        createIdx("type=double");
                terms("keys").field("key")
        expected.put("2", 5L); // <-- count is now fixed  
            .setQuery(matchAllQuery())  
        }
            assertTrue((bucket.getDocCount() == expectedDocCount) || bucket.getDocCount() + bucket.getDocCountError() >= expectedDocCount);
                terms("keys").field("key")
                terms("keys").field("key").size(3).collectMode(randomFrom(SubAggCollectionMode.values())).order(BucketOrder.key(true))
import java.util.HashMap;  
/*  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
        Map<String, Long> expected = new HashMap<>();  
            )  
 * The OpenSearch Contributors require contributions made to  
        indexData();
                terms("keys").field("key")
                    .size(3)
                terms("keys").field("key")
package org.opensearch.search.aggregations.bucket;
        Terms terms = response.getAggregations().get("keys");  
        SearchResponse response = client().prepareSearch("idx")
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        SearchResponse response = client().prepareSearch("idx")
        expected.put("2", 5L);
}
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
        for (Terms.Bucket bucket : buckets) {
        Map<Integer, Long> expected = new HashMap<>();  
import org.opensearch.action.search.SearchResponse;  
        expected.put(3, 8L);
        expected.put(2, 5L);
        assertThat(buckets.size(), equalTo(3)); // we still only return 3 entries (based on the 'size' param)
                terms("keys").field("key")  
        }
        for (Terms.Bucket bucket : buckets) {  
        SearchResponse response = client().prepareSearch("idx")
        assertThat(buckets.size(), equalTo(3));
            .get();
        for (Terms.Bucket bucket : buckets) {
                    .collectMode(randomFrom(SubAggCollectionMode.values()))
        expected.put(2, 4L);
        Map<String, Long> expected = new HashMap<>();
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        indexData();  
        }  
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsString())));
 * not use this file except in compliance with the License.
            )
    }
        SearchResponse response = client().prepareSearch("idx")
            expectedDocCount = expected.get(bucket.getKeyAsNumber().intValue());
        Terms terms = response.getAggregations().get("keys");  
        createIdx("type=long");
        Terms terms = response.getAggregations().get("keys");  
        expected.put(3, 8L);
import org.opensearch.search.aggregations.bucket.terms.Terms;
 * Unless required by applicable law or agreed to in writing,
        expected.put(2, 5L); // <-- count is now fixed  
        Map<Integer, Long> expected = new HashMap<>();
                    .collectMode(randomFrom(SubAggCollectionMode.values()))  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();
    }  
        List<? extends Terms.Bucket> buckets = terms.getBuckets();  
        for (Terms.Bucket bucket : buckets) {
        expected.put("2", 5L);
            assertThat(bucket.getDocCount(), equalTo(expected.get(bucket.getKeyAsString())));
            .addAggregation(  
                    .shardSize(3)
            .addAggregation(
