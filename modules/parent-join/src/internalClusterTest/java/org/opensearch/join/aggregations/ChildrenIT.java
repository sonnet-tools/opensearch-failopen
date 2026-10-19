        assertAcked(
                        AggregationBuilders.terms("parent_names").field("name").subAggregation(children("child_docs", "childType"))
import static org.opensearch.join.aggregations.JoinAggregationBuilders.children;
            )
    }
            Children children = searchResponse.getAggregations().get("children");
        assertNoFailures(response);  
    @Override
        requests.add(createIndexRequest(indexName, childType, "4", "1", "color", "blue", "size", "34"));
    public void testNonExistingChildType() throws Exception {  
            .addAggregation(children("to_comment", "comment").subAggregation(terms("commenters").field("commenter").size(10000)));
import static org.hamcrest.Matchers.sameInstance;
            assertThat(childrenBucket.getDocCount(), equalTo((long) entry1.getValue().commentIds.size()));  
        parents = towns.getBuckets().get(1).getAggregations().get("parent_names");
        String childType = "city";  
        List<IndexRequestBuilder> requests = new ArrayList<>();
            for (SearchHit searchHit : topHits.getHits()) {
            )
        assertThat(termsAgg.getBucketByKey("38").getDocCount(), equalTo(1L));  
        String indexName = "geo";  
        assertThat(termsAgg.getBuckets().size(), equalTo(6));
import static org.opensearch.join.query.JoinQueryBuilders.hasChildQuery;
            .get();  
                .setDetectNoop(false)
                        "keyword",
        assertThat(topHits.getHits().getAt(0).getId(), equalTo("e"));
            logger.info("bucket={}", bucket.getKey());
import java.util.Set;
        assertThat(categoryBucket.getDocCount(), equalTo(3L));  
                .get();
    @ParametersFactory
    public void testPostCollectAllLeafReaders() throws Exception {
                    "keyword",  
        assertThat(termsAgg.getBucketByKey("green").getDocCount(), equalTo(1L));
 */
 * specific language governing permissions and limitations
        requests.add(createIndexRequest(indexName, childType, "3", "1", "color", "blue", "size", "32"));  
 * not use this file except in compliance with the License.
            assertNoFailures(searchResponse);  
 * You may obtain a copy of the License at  
        requests.add(createIndexRequest(indexName, childType, "12", "2", "color", "black", "size", "36"));
import static org.hamcrest.Matchers.greaterThan;  
import org.opensearch.action.search.SearchResponse;
                .addAggregation(children("children", "child").subAggregation(sum("counts").field("count")))  
            assertThat(((InternalAggregation) childrenBucket).getProperty("commenters"), sameInstance(commentersTerms));
                        children("to_comment", "comment").subAggregation(
import org.apache.lucene.search.join.ScoreMode;
        SearchResponse response = client().prepareSearch("index")
                        "name",
            .setSize(0)
                    addFieldMappings(  
        requests.add(createIndexRequest("index", "parentType", "1", null, "name", "Bob", "town", "Memphis"));  
        assertThat(termsAgg.getBuckets().size(), equalTo(4));
        children = children.getAggregations().get(childType);
            .setQuery(matchQuery("name", "europe"))
/*
 * license agreements. See the NOTICE file distributed with
        assertThat(parents.getBuckets().get(1).getDocCount(), equalTo(1L));
        SearchResponse searchResponse = client().prepareSearch("test")
        assertThat(topHits.getHits().getAt(0).getId(), equalTo("f"));
        assertHitCount(response, 1);
import org.opensearch.transport.client.Requests;
                children(parentType, parentType).subAggregation(children(childType, childType).subAggregation(terms("name").field("name")))
        requests.add(createIndexRequest(indexName, childType, "15", "2", "color", "orange", "size", "36"));
        requests.add(createIndexRequest(indexName, childType, "14", "2", "color", "black", "size", "40"));  
    }
        Terms categoryTerms = searchResponse.getAggregations().get("category");  
            .addAggregation(  
            Sum count = children.getAggregations().get("counts");
        createIndexRequest(indexName, parentType, "2", "1", "name", "belgium").get();  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
                    .subAggregation(  
    public void testPostCollection() throws Exception {  
        Terms categoryTerms = searchResponse.getAggregations().get("category");  
            .get();
        requests.add(createIndexRequest(indexName, childType, "8", "1", "color", "gray", "size", "36"));
        requests.add(createIndexRequest("index", "childType", "5", "1", "name", "Joey", "age", 3));
        assertThat(parents.getBuckets().get(0).getKeyAsString(), equalTo("Bob"));  
            prepareCreate(indexName).setMapping(
            Terms.Bucket categoryBucket = categoryTerms.getBucketByKey(entry1.getKey());  
import org.opensearch.search.aggregations.metrics.TopHits;
                    .size(10000)  
        assertThat(categoryBucket.getKeyAsString(), equalTo("c"));
        assertThat(categoryBucket.getKeyAsString(), equalTo("a"));
        assertThat(children.getName(), equalTo(childType));
import static org.hamcrest.Matchers.is;
        requests.add(createIndexRequest(indexName, childType, "9", "2", "color", "blue", "size", "32"));
        assertThat(childrenBucket.getDocCount(), equalTo(2L));
        assertThat(topHits.getHits().getTotalHits().value(), equalTo(1L));
 * Modifications Copyright OpenSearch Contributors. See  
        SearchResponse searchResponse = client().prepareSearch("test").addAggregation(children("non-existing", "xyz")).get();
        assertThat(parents.getBuckets().get(0).getDocCount(), equalTo(1L));
        return Arrays.asList(  
            assertThat(children.getDocCount(), equalTo(4L));
import org.opensearch.search.sort.SortOrder;  
        assertThat(termsAgg.getBucketByKey("orange").getDocCount(), equalTo(1L));
        assertThat(topHits.getHits().getAt(1).getId(), equalTo("f"));
    public ChildrenIT(Settings settings) {  
        requests.add(createIndexRequest(indexName, childType, "6", "1", "color", "black", "size", "38"));  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        }  
        assertThat(topHits.getHits().getTotalHits().value(), equalTo(1L));  
        );  
    public void testChildrenAggs() throws Exception {  
        assertThat(terms.getBuckets().size(), equalTo(1));
        requests.add(createIndexRequest("index", "childType", "7", "3", "name", "Betty", "age", 6));  
            )
            prepareCreate(indexName).setMapping(  
        assertThat(towns.getBuckets().get(0).getDocCount(), equalTo(2L));  
        createIndexRequest(indexName, childType, "3", "2", "name", "brussels").setRouting("1").get();
             * The whole point of this test is to test these things with deleted  
        assertThat(childrenAgg.getDocCount(), equalTo(7L));
                .setRouting("1")  
        Terms termsAgg = childrenAgg.getAggregations().get("my-colors");  
                    "integer"
        requests.add(createIndexRequest(indexName, childType, "16", "2", "color", "green", "size", "44"));
    }  
        // us to miss to evaluate child docs in segments we didn't have parent matches for.  
            prepareCreate(indexName).setSettings(
             */  
        assertThat(children.getName(), equalTo(parentType));
            .setQuery(hasChildQuery(childType, termQuery("color", "orange"), ScoreMode.None))  
        Terms towns = response.getAggregations().get("towns");  
        children = parents.getBuckets().get(1).getAggregations().get("child_docs");
        assertThat(children.getDocCount(), equalTo(2L));  
            Children childrenBucket = categoryBucket.getAggregations().get("to_comment");
        assertThat(towns.getBuckets().get(1).getKeyAsString(), equalTo("Memphis"));
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
                        "color",
    }
                    "keyword"  
                TopHits topHits = commentBucket.getAggregations().get("top_comments");
        SearchResponse response = client().prepareSearch(indexName)
                    .size(10000)
            }  
        SearchResponse response = client().prepareSearch(indexName)
 */  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        assertThat(categoryTerms.getBuckets().size(), equalTo(3));
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
            assertThat(childrenBucket.getName(), equalTo("to_comment"));
        );  
public class ChildrenIT extends AbstractParentChildTestCase {
        requests.add(createIndexRequest("index", "parentType", "2", null, "name", "Alice", "town", "Chicago"));
                    .subAggregation(  
package org.opensearch.join.aggregations;
        assertThat(children.getDocCount(), equalTo(1L));  
        indexRandom(true, requests);
        assertThat(terms.getBuckets().get(0).getDocCount(), equalTo(1L));
        indexRandom(true, requests);  
import org.opensearch.common.settings.Settings;
        Terms terms = children.getAggregations().get("name");
            )
                .setDoc(Requests.INDEX_CONTENT_TYPE, "count", 1)
            Terms commentersTerms = childrenBucket.getAggregations().get("commenters");  
        assertThat(terms.getBuckets().get(0).getKey().toString(), equalTo("brussels"));  
                    "age",  
        assertThat(termsAgg.getBucketByKey("36").getDocCount(), equalTo(2L));  
        Children children = response.getAggregations().get(parentType);
            assertThat(categoryBucket.getKeyAsString(), equalTo(entry1.getKey()));
        requests.add(createIndexRequest("index", "childType", "8", "3", "name", "Dan", "age", 1));
        Children children = searchResponse.getAggregations().get("non-existing");
        assertThat(childrenBucket.getDocCount(), equalTo(1L));  
            SearchResponse searchResponse = client().prepareSearch(indexName)
 * Licensed to Elasticsearch under one or more contributor  
                        "keyword",  
             * docs in the index so we turn off detect_noop to make sure that
 *
        Terms parents = towns.getBuckets().get(0).getAggregations().get("parent_names");
            updateResponse = client().prepareUpdate(indexName, idToUpdate)
        refresh();
            .setQuery(matchQuery("randomized", false))  
        Children children = parents.getBuckets().get(0).getAggregations().get("child_docs");  
        categoryBucket = categoryTerms.getBucketByKey("b");
        assertThat(termsAgg.getBucketByKey("40").getDocCount(), equalTo(1L));
        requests.add(createIndexRequest(indexName, mainType, "2", null, "brand", "Wrangler", "name", "Regular Cut", "material", "Leather"));
import java.util.Arrays;
            logger.info("total_hits={}", topHits.getHits().getTotalHits().value());
        assertThat(children.getDocCount(), equalTo(0L));  
        requests.add(createIndexRequest(indexName, "child", "4", "1", "count", 1));  
        assertNoFailures(response);
        requests.add(createIndexRequest("index", "childType", "6", "2", "name", "John", "age", 2));
    }
import org.opensearch.search.aggregations.metrics.Sum;
    }
        assertThat(children.getDocCount(), equalTo(1L));  
                    "town",
                assertThat(commentBucket.getKeyAsString(), equalTo(entry2.getKey()));
        requests.add(createIndexRequest(indexName, "child", "3", "1", "count", 1));
                assertThat(commentBucket.getDocCount(), equalTo((long) entry2.getValue().size()));  
            )  
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.equalTo;
        requests.add(createIndexRequest("index", "childType", "4", "1", "name", "Jill", "age", 5));  
        assertThat(towns.getBuckets().get(0).getKeyAsString(), equalTo("Chicago"));
        super(settings);
        requests.add(createIndexRequest(indexName, "parent", "1", null));  
                )
        assertThat(childrenBucket.getDocCount(), equalTo(1L));
    }  
        childrenBucket = categoryBucket.getAggregations().get("to_comment");
        requests.add(createIndexRequest(indexName, childType, "7", "1", "color", "black", "size", "40"));
        assertThat(towns.getBuckets().size(), equalTo(2));
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < 10; i++) {
    }
import org.opensearch.search.aggregations.AggregationBuilders;
        categoryBucket = categoryTerms.getBucketByKey("c");  
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                children("my-refinements", childType).subAggregation(terms("my-colors").field("color"))
                )
    public void testHierarchicalChildrenAggs() {
 * software distributed under the License is distributed on an
            for (Map.Entry<String, Set<String>> entry2 : entry1.getValue().commenterToCommentId.entrySet()) {  
            UpdateResponse updateResponse;
    @Override  
}
            assertThat(commentersTerms.getBuckets().size(), equalTo(entry1.getValue().commenterToCommentId.size()));
        topHits = childrenBucket.getAggregations().get("top_comments");
        SearchResponse searchResponse = client().prepareSearch("test")
        String indexName = "prodcatalog";
        assertThat(categoryBucket.getKeyAsString(), equalTo("b"));
            )
import org.opensearch.search.aggregations.bucket.terms.Terms;  
                    "name",
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
                        "brand",
    public void testWithDeletes() throws Exception {  
                    "name",
            .addAggregation(
import static org.opensearch.index.query.QueryBuilders.termQuery;  
            .addAggregation(  
        );
             * the updates cause that.
    public static Collection<Object[]> parameters() {
            .get();
        assertAcked(
        // to ensure those segments which child docs are also evaluated to in the post collect phase.  
            .setQuery(matchAllQuery())
        assertThat(categoryTerms.getBuckets().size(), equalTo(categoryToControl.size()));
        assertThat(parents.getBuckets().get(1).getKeyAsString(), equalTo("Bill"));  
            prepareCreate("index").setMapping(
            }
            assertThat(updateResponse.getVersion(), greaterThan(1L));
            .setSize(10000)  
            assertThat(categoryBucket.getDocCount(), equalTo((long) entry1.getValue().articleIds.size()));
    SearchRequestBuilder getSearchRequest() {
import org.opensearch.action.search.SearchRequestBuilder;
        assertSearchResponse(searchResponse);
            .addAggregation(  
        assertAcked(
        );
import java.util.ArrayList;  
                for (SearchHit searchHit : topHits.getHits().getHits()) {  
            Children childrenBucket = bucket.getAggregations().get("to_comment");
        requests.add(createIndexRequest(indexName, childType, "5", "1", "color", "blue", "size", "36"));
        termsAgg = childrenAgg.getAggregations().get("my-sizes");
/*
        Children childrenBucket = categoryBucket.getAggregations().get("to_comment");
import org.opensearch.search.SearchHit;  
    }  
                addFieldMappings(  
    public void testParentWithMultipleBuckets() throws Exception {
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parentType", "childType"),
        TopHits topHits = childrenBucket.getAggregations().get("top_comments");
                        "size",
        List<IndexRequestBuilder> requests = new ArrayList<>();
        assertThat(termsAgg.getBucketByKey("blue").getDocCount(), equalTo(2L));  
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(childrenBucket.getName(), equalTo("to_comment"));  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        );  
        }
        requests.add(createIndexRequest(indexName, childType, "13", "2", "color", "black", "size", "38"));
/*  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        children = parents.getBuckets().get(0).getAggregations().get("child_docs");
            )  
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, grandParentType, parentType, parentType, childType),
        assertThat(children.getDocCount(), equalTo(1L));
                    assertThat(entry2.getValue().contains(searchHit.getId()), is(true));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            )
import static org.opensearch.search.aggregations.AggregationBuilders.topHits;  
        assertEquals(children.getDocCount(), 1);
        for (Terms.Bucket bucket : categoryTerms.getBuckets()) {  
        String mainType = "mainprod";
                .get();  
        assertSearchResponse(searchResponse);
        childrenBucket = categoryBucket.getAggregations().get("to_comment");
        assertThat(children.getDocCount(), equalTo(2L));  
                            terms("commenters").field("commenter").size(10000).subAggregation(topHits("top_comments"))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        requests.add(createIndexRequest(indexName, childType, "10", "2", "color", "blue", "size", "34"));  
                        "keyword"
        requests.add(createIndexRequest("index", "parentType", "3", null, "name", "Bill", "town", "Chicago"));
                        )  
        assertThat(termsAgg.getBucketByKey("34").getDocCount(), equalTo(1L));
                    .subAggregation(terms("my-sizes").field("size"))  
            assertThat(count.getValue(), equalTo(4.));
import static org.opensearch.search.aggregations.AggregationBuilders.sum;
                terms("category").field("category")
        Children children = searchResponse.getAggregations().get("to_comment");
        Children childrenAgg = response.getAggregations().get("my-refinements");  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
                        buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, mainType, childType),
                }
        indexRandom(true, requests);
        assertThat(termsAgg.getBucketByKey("44").getDocCount(), equalTo(1L));
    void validateSpareSegmentsSearchResponse(SearchResponse searchResponse) {  
        for (Map.Entry<String, Control> entry1 : categoryToControl.entrySet()) {
            .get();  
 * the Apache License, Version 2.0 (the "License"); you may
                    )
        assertThat(topHits.getHits().getAt(0).getId(), equalTo("f"));  
        requests.add(createIndexRequest(indexName, "child", "2", "1", "count", 1));
 */
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.InternalAggregation;
        assertThat(childrenBucket.getName(), equalTo("to_comment"));
            .get();  
        requests.add(createIndexRequest(indexName, mainType, "1", null, "brand", "Levis", "name", "Style 501", "material", "Denim"));
                addFieldMappings(  
        assertThat(categoryBucket.getDocCount(), equalTo(2L));  
                    )  
 *
                        "text",
        assertThat(towns.getBuckets().get(1).getDocCount(), equalTo(1L));  
            refresh();
        String grandParentType = "continent";
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        createIndexRequest(indexName, grandParentType, "1", null, "name", "europe").get();
        List<IndexRequestBuilder> requests = new ArrayList<>();
import java.util.Map;
        return client().prepareSearch("sparse")
                AggregationBuilders.terms("towns")
        assertThat(children.getName(), equalTo("non-existing"));
            /*
        String indexName = "xyz";
 * GitHub history for details.
                        "text",  
    }
        assertThat(parents.getBuckets().get(0).getDocCount(), equalTo(1L));
import org.opensearch.action.update.UpdateResponse;  
        // The 'towns' and 'parent_names' aggs operate on parent docs and if child docs are in different segments we need
        assertThat(childrenBucket.getName(), equalTo("to_comment"));  
            assertThat(((InternalAggregation) childrenBucket).getProperty("_count"), equalTo((long) entry1.getValue().commentIds.size()));
        assertThat(parents.getBuckets().get(0).getKeyAsString(), equalTo("Alice"));
        assertThat(termsAgg.getBucketByKey("32").getDocCount(), equalTo(1L));
        assertHitCount(response, 1);
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        assertAcked(
            )
        topHits = childrenBucket.getAggregations().get("top_comments");
                )
                addFieldMappings(buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "parent", "child"), "name", "keyword")
                    .field("town")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            .addAggregation(
                        "material",  
        String parentType = "country";
                    .subAggregation(children("to_comment", "comment").subAggregation(topHits("top_comments").sort("id", SortOrder.ASC)))
        requests.add(createIndexRequest(indexName, "child", "5", "1", "count", 1));
        }
import java.util.List;  
        assertSearchResponse(searchResponse);
        assertThat(termsAgg.getBucketByKey("black").getDocCount(), equalTo(3L));
        assertThat(categoryBucket.getDocCount(), equalTo(2L));
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.index.IndexRequestBuilder;  
                terms("category").field("category")
        assertThat(topHits.getHits().getTotalHits().value(), equalTo(2L));  
import java.util.Collection;
        assertThat(parents.getBuckets().size(), equalTo(2));  
                logger.info("hit= {} {}", searchHit.getSortValues()[0], searchHit.getId());  
    }
            TopHits topHits = childrenBucket.getAggregations().get("top_comments");  
            String idToUpdate = Integer.toString(2 + randomInt(3));
import org.opensearch.cluster.metadata.IndexMetadata;
                .setMapping(
        // Before we only evaluated segments that yielded matches in 'towns' and 'parent_names' aggs, which caused
        Terms.Bucket categoryBucket = categoryTerms.getBucketByKey("a");
        String childType = "variantsku";  
        assertThat(parents.getBuckets().size(), equalTo(1));
                    )
            .setQuery(matchQuery("randomized", true))
                    "keyword",
                Terms.Bucket commentBucket = commentersTerms.getBucketByKey(entry2.getKey());
