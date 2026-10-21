        assertThat(parents.getBuckets().get(0).getKeyAsString(), equalTo("Bob"));
        }
 */
        termsAgg = childrenAgg.getAggregations().get("my-sizes");
        // Before we only evaluated segments that yielded matches in 'towns' and 'parent_names' aggs, which caused
 * license agreements. See the NOTICE file distributed with
        topHits = childrenBucket.getAggregations().get("top_comments");
 * GitHub history for details.
            .get();
                    .subAggregation(
    public void testChildrenAggs() throws Exception {
             * the updates cause that.
                        "keyword",
                        "material",
/*
        assertThat(topHits.getHits().getAt(1).getId(), equalTo("f"));
 * specific language governing permissions and limitations
        assertThat(topHits.getHits().getTotalHits().value(), equalTo(1L));
    }
            }
            assertThat(((InternalAggregation) childrenBucket).getProperty("_count"), equalTo((long) entry1.getValue().commentIds.size()));
        }
        requests.add(createIndexRequest(indexName, childType, "10", "2", "color", "blue", "size", "34"));
        refresh();
            .setQuery(matchQuery("randomized", false))
        assertThat(parents.getBuckets().get(1).getDocCount(), equalTo(1L));
            Terms commentersTerms = childrenBucket.getAggregations().get("commenters");
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            )
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, grandParentType, parentType, parentType, childType),
        assertThat(categoryBucket.getDocCount(), equalTo(2L));
                    "town",
        assertAcked(
            Children children = searchResponse.getAggregations().get("children");
            prepareCreate(indexName).setMapping(
        requests.add(createIndexRequest(indexName, childType, "15", "2", "color", "orange", "size", "36"));
        assertThat(parents.getBuckets().size(), equalTo(1));
        assertThat(towns.getBuckets().get(0).getKeyAsString(), equalTo("Chicago"));
 * Unless required by applicable law or agreed to in writing,
                }
        assertThat(childrenBucket.getName(), equalTo("to_comment"));
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        String indexName = "prodcatalog";
        requests.add(createIndexRequest("index", "childType", "7", "3", "name", "Betty", "age", 6));
 * not use this file except in compliance with the License.
        assertThat(children.getName(), equalTo(childType));
    public void testPostCollection() throws Exception {
        children = parents.getBuckets().get(1).getAggregations().get("child_docs");
        assertThat(termsAgg.getBucketByKey("blue").getDocCount(), equalTo(2L));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        assertThat(categoryTerms.getBuckets().size(), equalTo(categoryToControl.size()));
 */
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
        assertThat(termsAgg.getBucketByKey("44").getDocCount(), equalTo(1L));
        SearchResponse response = client().prepareSearch(indexName)
        assertAcked(
                .setDetectNoop(false)
/*
            )
        createIndexRequest(indexName, parentType, "2", "1", "name", "belgium").get();
            .setQuery(hasChildQuery(childType, termQuery("color", "orange"), ScoreMode.None))
                    )
            )
                    "keyword"
        categoryBucket = categoryTerms.getBucketByKey("c");
        String mainType = "mainprod";
                .setMapping(
    void validateSpareSegmentsSearchResponse(SearchResponse searchResponse) {
            prepareCreate(indexName).setSettings(
}
                    "keyword",
                assertThat(commentBucket.getKeyAsString(), equalTo(entry2.getKey()));
                .setRouting("1")
            /*
        String parentType = "country";
        SearchResponse searchResponse = client().prepareSearch("test")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            SearchResponse searchResponse = client().prepareSearch(indexName)
                .get();
            assertThat(childrenBucket.getDocCount(), equalTo((long) entry1.getValue().commentIds.size()));
                        AggregationBuilders.terms("parent_names").field("name").subAggregation(children("child_docs", "childType"))
    }
            Children childrenBucket = categoryBucket.getAggregations().get("to_comment");
                        "keyword",
                    "name",
                TopHits topHits = commentBucket.getAggregations().get("top_comments");
import java.util.Arrays;
            prepareCreate(indexName).setMapping(
    public static Collection<Object[]> parameters() {
        assertThat(topHits.getHits().getAt(0).getId(), equalTo("e"));
        assertThat(categoryBucket.getKeyAsString(), equalTo("c"));
import org.opensearch.search.SearchHit;
            .setQuery(matchQuery("name", "europe"))
        return client().prepareSearch("sparse")
 * under the License.
                    "age",
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.search.aggregations.InternalAggregation;
        Terms categoryTerms = searchResponse.getAggregations().get("category");
            logger.info("bucket={}", bucket.getKey());
    }
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            String idToUpdate = Integer.toString(2 + randomInt(3));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        Terms termsAgg = childrenAgg.getAggregations().get("my-colors");
        childrenBucket = categoryBucket.getAggregations().get("to_comment");
        requests.add(createIndexRequest(indexName, "child", "3", "1", "count", 1));
        assertThat(termsAgg.getBuckets().size(), equalTo(4));
                terms("category").field("category")
        assertThat(towns.getBuckets().get(1).getDocCount(), equalTo(1L));
        assertThat(terms.getBuckets().get(0).getKey().toString(), equalTo("brussels"));
            UpdateResponse updateResponse;
            .addAggregation(
        String indexName = "geo";
        for (Terms.Bucket bucket : categoryTerms.getBuckets()) {
        assertThat(childrenBucket.getDocCount(), equalTo(1L));
        assertThat(topHits.getHits().getAt(0).getId(), equalTo("f"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.hamcrest.Matchers.sameInstance;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        requests.add(createIndexRequest(indexName, childType, "5", "1", "color", "blue", "size", "36"));
        assertThat(categoryBucket.getKeyAsString(), equalTo("b"));
        requests.add(createIndexRequest(indexName, childType, "9", "2", "color", "blue", "size", "32"));
        requests.add(createIndexRequest(indexName, "child", "4", "1", "count", 1));
                    .subAggregation(terms("my-sizes").field("size"))
        requests.add(createIndexRequest(indexName, childType, "4", "1", "color", "blue", "size", "34"));
            for (Map.Entry<String, Set<String>> entry2 : entry1.getValue().commenterToCommentId.entrySet()) {
        for (int i = 0; i < 10; i++) {
        requests.add(createIndexRequest("index", "parentType", "3", null, "name", "Bill", "town", "Chicago"));
 * software distributed under the License is distributed on an
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
 *
            )
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.action.index.IndexRequestBuilder;
        );
    }
        assertThat(termsAgg.getBucketByKey("40").getDocCount(), equalTo(1L));
            assertThat(commentersTerms.getBuckets().size(), equalTo(entry1.getValue().commenterToCommentId.size()));
                )
                    )
                assertThat(commentBucket.getDocCount(), equalTo((long) entry2.getValue().size()));
        assertAcked(
                .setDoc(Requests.INDEX_CONTENT_TYPE, "count", 1)
             * docs in the index so we turn off detect_noop to make sure that
        String indexName = "xyz";
        Terms categoryTerms = searchResponse.getAggregations().get("category");
        requests.add(createIndexRequest(indexName, "child", "2", "1", "count", 1));
             * The whole point of this test is to test these things with deleted
        assertThat(children.getDocCount(), equalTo(1L));
        assertSearchResponse(searchResponse);
        children = children.getAggregations().get(childType);
        assertThat(children.getDocCount(), equalTo(1L));
                children("my-refinements", childType).subAggregation(terms("my-colors").field("color"))
        assertThat(categoryBucket.getKeyAsString(), equalTo("a"));
        }
import java.util.ArrayList;
        requests.add(createIndexRequest("index", "childType", "8", "3", "name", "Dan", "age", 1));
        SearchResponse response = client().prepareSearch("index")
        Children children = parents.getBuckets().get(0).getAggregations().get("child_docs");
        requests.add(createIndexRequest(indexName, childType, "3", "1", "color", "blue", "size", "32"));
        indexRandom(true, requests);
            Terms.Bucket categoryBucket = categoryTerms.getBucketByKey(entry1.getKey());
/*
        assertThat(termsAgg.getBucketByKey("orange").getDocCount(), equalTo(1L));
            .get();
        assertThat(towns.getBuckets().get(1).getKeyAsString(), equalTo("Memphis"));
            .setQuery(matchAllQuery())
        Children childrenAgg = response.getAggregations().get("my-refinements");
            )
        assertThat(children.getName(), equalTo("non-existing"));
import org.opensearch.action.search.SearchResponse;
    public void testHierarchicalChildrenAggs() {
        assertThat(terms.getBuckets().get(0).getDocCount(), equalTo(1L));
 * You may obtain a copy of the License at
            }
            Children childrenBucket = bucket.getAggregations().get("to_comment");
            .setSize(10000)
        Children children = searchResponse.getAggregations().get("to_comment");
        requests.add(createIndexRequest(indexName, "child", "5", "1", "count", 1));
                    "name",
        requests.add(createIndexRequest(indexName, childType, "13", "2", "color", "black", "size", "38"));
                        "size",
        parents = towns.getBuckets().get(1).getAggregations().get("parent_names");
        indexRandom(true, requests);
        Terms parents = towns.getBuckets().get(0).getAggregations().get("parent_names");
        assertThat(topHits.getHits().getTotalHits().value(), equalTo(2L));
        assertThat(parents.getBuckets().get(0).getDocCount(), equalTo(1L));
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parentType", "childType"),
import java.util.Collection;
    }
import java.util.List;
        assertSearchResponse(searchResponse);
                addFieldMappings(
                    .subAggregation(children("to_comment", "comment").subAggregation(topHits("top_comments").sort("id", SortOrder.ASC)))
    public void testWithDeletes() throws Exception {
        requests.add(createIndexRequest("index", "parentType", "2", null, "name", "Alice", "town", "Chicago"));
import java.util.Set;
    public void testParentWithMultipleBuckets() throws Exception {
 * KIND, either express or implied.  See the License for the
        assertThat(children.getDocCount(), equalTo(2L));
        assertThat(childrenAgg.getDocCount(), equalTo(7L));
        requests.add(createIndexRequest(indexName, "parent", "1", null));
            logger.info("total_hits={}", topHits.getHits().getTotalHits().value());
import java.util.Map;
import org.opensearch.search.aggregations.metrics.Sum;
        assertHitCount(response, 1);
        Terms towns = response.getAggregations().get("towns");
             */
        );
        assertSearchResponse(searchResponse);
            assertThat(updateResponse.getVersion(), greaterThan(1L));
        SearchResponse response = client().prepareSearch(indexName)
                    .size(10000)
        String childType = "city";
        for (Map.Entry<String, Control> entry1 : categoryToControl.entrySet()) {
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        Terms.Bucket categoryBucket = categoryTerms.getBucketByKey("a");
        assertThat(termsAgg.getBucketByKey("34").getDocCount(), equalTo(1L));
        SearchResponse searchResponse = client().prepareSearch("test").addAggregation(children("non-existing", "xyz")).get();
        assertThat(categoryTerms.getBuckets().size(), equalTo(3));
    }
    }
            for (SearchHit searchHit : topHits.getHits()) {
        List<IndexRequestBuilder> requests = new ArrayList<>();
            assertThat(children.getDocCount(), equalTo(4L));
        assertThat(termsAgg.getBucketByKey("black").getDocCount(), equalTo(3L));
                        "text",
        requests.add(createIndexRequest(indexName, childType, "14", "2", "color", "black", "size", "40"));
                    )
        assertThat(towns.getBuckets().size(), equalTo(2));
    }
                    assertThat(entry2.getValue().contains(searchHit.getId()), is(true));
 * SPDX-License-Identifier: Apache-2.0
        Children children = response.getAggregations().get(parentType);
                        "brand",
        requests.add(createIndexRequest(indexName, childType, "12", "2", "color", "black", "size", "36"));
        assertThat(childrenBucket.getName(), equalTo("to_comment"));
        assertThat(termsAgg.getBucketByKey("36").getDocCount(), equalTo(2L));
        );
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
                    .field("town")
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(childrenBucket.getName(), equalTo("to_comment"));
                    addFieldMappings(
        assertThat(termsAgg.getBucketByKey("38").getDocCount(), equalTo(1L));
        children = parents.getBuckets().get(0).getAggregations().get("child_docs");
        // to ensure those segments which child docs are also evaluated to in the post collect phase.
        topHits = childrenBucket.getAggregations().get("top_comments");
        assertThat(childrenBucket.getDocCount(), equalTo(2L));
        assertThat(termsAgg.getBucketByKey("32").getDocCount(), equalTo(1L));
        assertHitCount(response, 1);
public class ChildrenIT extends AbstractParentChildTestCase {
        );
        Children children = searchResponse.getAggregations().get("non-existing");
        requests.add(createIndexRequest("index", "childType", "5", "1", "name", "Joey", "age", 3));
                .addAggregation(children("children", "child").subAggregation(sum("counts").field("count")))
        assertThat(termsAgg.getBuckets().size(), equalTo(6));
            .addAggregation(
                    "integer"
        Terms terms = children.getAggregations().get("name");
        SearchResponse searchResponse = client().prepareSearch("test")
        requests.add(createIndexRequest(indexName, mainType, "2", null, "brand", "Wrangler", "name", "Regular Cut", "material", "Leather"));
        createIndexRequest(indexName, grandParentType, "1", null, "name", "europe").get();
import org.opensearch.search.aggregations.bucket.terms.Terms;
        return Arrays.asList(
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.opensearch.join.aggregations.JoinAggregationBuilders.children;
            updateResponse = client().prepareUpdate(indexName, idToUpdate)
 */
        Children childrenBucket = categoryBucket.getAggregations().get("to_comment");
            TopHits topHits = childrenBucket.getAggregations().get("top_comments");
                    .size(10000)
 * The OpenSearch Contributors require contributions made to
            refresh();
        requests.add(createIndexRequest("index", "childType", "4", "1", "name", "Jill", "age", 5));
        assertAcked(
            .get();
import org.opensearch.action.update.UpdateResponse;
                addFieldMappings(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"), "name", "keyword")
    }
        requests.add(createIndexRequest("index", "childType", "6", "2", "name", "John", "age", 2));
                        buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, mainType, childType),
        assertEquals(children.getDocCount(), 1);
        requests.add(createIndexRequest("index", "parentType", "1", null, "name", "Bob", "town", "Memphis"));
        assertThat(children.getName(), equalTo(parentType));
            assertNoFailures(searchResponse);
        String childType = "variantsku";
 * this work for additional information regarding copyright
        requests.add(createIndexRequest(indexName, mainType, "1", null, "brand", "Levis", "name", "Style 501", "material", "Denim"));
                children(parentType, parentType).subAggregation(children(childType, childType).subAggregation(terms("name").field("name")))
                AggregationBuilders.terms("towns")
        requests.add(createIndexRequest(indexName, childType, "7", "1", "color", "black", "size", "40"));
        assertThat(childrenBucket.getDocCount(), equalTo(1L));
            .addAggregation(
        categoryBucket = categoryTerms.getBucketByKey("b");
        requests.add(createIndexRequest(indexName, childType, "8", "1", "color", "gray", "size", "36"));
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
                        "name",
import static org.opensearch.join.query.JoinQueryBuilders.hasChildQuery;
import org.opensearch.transport.client.Requests;
import org.opensearch.search.sort.SortOrder;
        assertNoFailures(response);
                )
        childrenBucket = categoryBucket.getAggregations().get("to_comment");
        assertThat(parents.getBuckets().get(1).getKeyAsString(), equalTo("Bill"));
import org.opensearch.search.aggregations.metrics.TopHits;
        assertThat(parents.getBuckets().get(0).getKeyAsString(), equalTo("Alice"));
                terms("category").field("category")
                logger.info("hit= {} {}", searchHit.getSortValues()[0], searchHit.getId());
        String grandParentType = "continent";
    public void testPostCollectAllLeafReaders() throws Exception {
            )
        assertThat(children.getDocCount(), equalTo(1L));
    SearchRequestBuilder getSearchRequest() {
            .addAggregation(
                addFieldMappings(
        assertThat(childrenBucket.getName(), equalTo("to_comment"));
        assertThat(towns.getBuckets().get(0).getDocCount(), equalTo(2L));
                        "color",
        // us to miss to evaluate child docs in segments we didn't have parent matches for.
 *
            .get();
                )
    public void testNonExistingChildType() throws Exception {
                        "text",
import org.opensearch.action.search.SearchRequestBuilder;
        assertThat(parents.getBuckets().get(0).getDocCount(), equalTo(1L));
 *
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.common.settings.Settings;
        TopHits topHits = childrenBucket.getAggregations().get("top_comments");
                        children("to_comment", "comment").subAggregation(
                    .subAggregation(
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.join.aggregations;
import org.apache.lucene.search.join.ScoreMode;
            .addAggregation(
 * Modifications Copyright OpenSearch Contributors. See
                            terms("commenters").field("commenter").size(10000).subAggregation(topHits("top_comments"))
    @ParametersFactory
        requests.add(createIndexRequest(indexName, childType, "16", "2", "color", "green", "size", "44"));
 * ownership. Elasticsearch licenses this file to you under
        assertNoFailures(response);
        assertThat(topHits.getHits().getTotalHits().value(), equalTo(1L));
            .setSize(0)
            Sum count = children.getAggregations().get("counts");
import static org.opensearch.index.query.QueryBuilders.termQuery;
                        )
        List<IndexRequestBuilder> requests = new ArrayList<>();
    }
            assertThat(count.getValue(), equalTo(4.));
 * compatible open source license.
import static org.hamcrest.Matchers.is;
        assertThat(children.getDocCount(), equalTo(2L));
        assertThat(termsAgg.getBucketByKey("green").getDocCount(), equalTo(1L));
        );
        assertThat(categoryBucket.getDocCount(), equalTo(2L));
        indexRandom(true, requests);
            .addAggregation(children("to_comment", "comment").subAggregation(terms("commenters").field("commenter").size(10000)));
            assertThat(categoryBucket.getDocCount(), equalTo((long) entry1.getValue().articleIds.size()));
import static org.opensearch.search.aggregations.AggregationBuilders.topHits;
    @Override
        assertThat(children.getDocCount(), equalTo(0L));
        assertThat(parents.getBuckets().size(), equalTo(2));
            assertThat(((InternalAggregation) childrenBucket).getProperty("commenters"), sameInstance(commentersTerms));
        // The 'towns' and 'parent_names' aggs operate on parent docs and if child docs are in different segments we need
            .get();
            prepareCreate("index").setMapping(
        requests.add(createIndexRequest(indexName, childType, "6", "1", "color", "black", "size", "38"));
                    "keyword",
            .setQuery(matchQuery("randomized", true))
                .get();
        assertThat(categoryBucket.getDocCount(), equalTo(3L));
        createIndexRequest(indexName, childType, "3", "2", "name", "brussels").setRouting("1").get();
            )
                        "keyword"
                Terms.Bucket commentBucket = commentersTerms.getBucketByKey(entry2.getKey());
    @Override
                for (SearchHit searchHit : topHits.getHits().getHits()) {
            )
    public ChildrenIT(Settings settings) {
        List<IndexRequestBuilder> requests = new ArrayList<>();
            assertThat(categoryBucket.getKeyAsString(), equalTo(entry1.getKey()));
            )
        assertThat(topHits.getHits().getAt(0).getId(), equalTo("f"));
        super(settings);
    }
import org.opensearch.search.aggregations.AggregationBuilders;
        assertThat(terms.getBuckets().size(), equalTo(1));
