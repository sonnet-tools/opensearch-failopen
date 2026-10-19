            .addAggregation(
            Set<String> articles = articleToControl.values()  
        for (Terms.Bucket commenterBucket : categoryTerms.getBuckets()) {
            final Terms.Bucket categoryBucket = categoryTerms.getBucketByKey(entry.getKey());
    public void testSimpleParentAgg() throws Exception {
            .setSize(10000)  
        long categoriesWithComments = categoryToControl.values().stream().filter(control -> !control.commentIds.isEmpty()).count();
            // find all articles for the comments for the current commenter
import org.opensearch.action.search.SearchRequestBuilder;  
                filter(parentControl -> parentControl.category.equals(entry.getKey())).  
 * Licensed to Elasticsearch under one or more contributor  
            long articlesForCategory = articleToControl.values().stream().
 * GitHub history for details.
                )  
                comments.addAll(entry.getValue());  
            .addAggregation(parent("to_article", "comment").subAggregation(terms("category").field("category").size(10000)));  
                Terms.Bucket categoryBucket = categoryAgg.getBucketByKey(category);
                final Set<String> comments = commenterToComments.computeIfAbsent(entry.getKey(), s -> new HashSet<>());
        assertEquals(parentAgg.getDocCount(), 1);  
    @ParametersFactory  
    }
            for (Map.Entry<String, Set<String>> entry : control.commenterToCommentId.entrySet()) {
    }
            List<String> categories = categoryToControl.entrySet()
                "Failed for commenter " + commenterBucket.getKeyAsString(),  
import java.util.Collection;
 * SPDX-License-Identifier: Apache-2.0
        final Map<String, Set<String>> commenterToComments = getCommenterToComments();
                    .subAggregation(parent("to_article", "comment").subAggregation(terms("to_category").field("category").size(10000)))
                .stream()  
        assertThat(  
            .setQuery(matchAllQuery())
        SearchResponse searchResponse = client().prepareSearch("test").addAggregation(parent("non-existing", "xyz")).get();
                .filter(entry -> entry.getValue().commenterToCommentId.containsKey(commenterBucket.getKeyAsString()))
                assertNotNull(categoryBucket);
            assertThat(categoryBucket.getKeyAsString(), equalTo(commenter));
            equalTo(commenters.size())  
    @Override
            commentersAgg.getBuckets().size(),  
    @Override  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
                + categoryToControl.keySet(),  
            List<String> categories = categoryToControl.entrySet()  
        assertSearchResponse(searchResponse);
 */
            .addAggregation(parent("to_article", "comment").subAggregation(terms("category").field("category").size(10000)));  
        SearchResponse searchResponse = searchRequest.get();
                    .stream()
import static org.opensearch.index.query.QueryBuilders.matchQuery;
            .setQuery(matchQuery("randomized", true))
 * not use this file except in compliance with the License.
import java.util.Set;
        return client().prepareSearch("sparse")  
                    .size(10000)
                .stream()
                equalTo((long) comments.size())
            assertThat(
            Parent articleAgg = commenterBucket.getAggregations().get("to_article");  
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 * under the License.  
        for (Terms.Bucket commenterBucket : commentersAgg.getBuckets()) {  
package org.opensearch.join.aggregations;
 * KIND, either express or implied.  See the License for the
            Parent childrenBucket = categoryBucket.getAggregations().get("to_article");
                    .size(10000)  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;  
 * Modifications Copyright OpenSearch Contributors. See
                .filter(entry -> entry.getValue().commenterToCommentId.containsKey(commenterBucket.getKeyAsString()))
        SearchResponse searchResponse = searchRequest.get();
            assertThat(articleAgg.getDocCount(), equalTo((long) articles.size()));  
            for (String category : categories) {
                )
            assertThat(categoryBucket.getDocCount(), equalTo((long) commenterToComments.get(commenter).size()));
        }  
            assertThat(articleAgg.getName(), equalTo("to_article"));
            if (entry.getValue().commentIds.isEmpty()) {  
            );
        for (String commenter : commenters) {
 *
 *  
    public void testParentAggs() throws Exception {
        final Map<String, Set<String>> commenterToComments = new HashMap<>();
    private Set<String> getCommenters() {  
        );
        assertThat(
            Terms categoryAgg = articleAgg.getAggregations().get("to_category");
    }
        final SearchRequestBuilder searchRequest = client().prepareSearch("test")  
/*  
        return Arrays.asList(
    public void testTermsParentAggTerms() throws Exception {  
            .setQuery(matchQuery("randomized", true))
 *
    public void testNonExistingParentType() throws Exception {  
            assertNotNull(comments);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
    SearchRequestBuilder getSearchRequest() {
        for (Map.Entry<String, Control> entry : categoryToControl.entrySet()) {
                + categoryTerms.getBuckets()
            assertNotNull(categoryAgg);  
 */  
    void validateSpareSegmentsSearchResponse(SearchResponse searchResponse) {
            Terms categoryAgg = articleAgg.getAggregations().get("to_category");  
                            terms("to_category").field("category").size(10000).subAggregation(topHits("top_category"))
        assertSearchResponse(searchResponse);  
                        parent("to_article", "comment").subAggregation(  
            assertNotNull(categoryAgg);
                "Failed for commenter " + commenterBucket.getKeyAsString(),
                assertNull(categoryTerms.getBucketByKey(entry.getKey()));
import java.util.HashMap;  
 * The OpenSearch Contributors require contributions made to  
                .map(Map.Entry::getKey)
            );
import java.util.stream.Stream;
        Parent parentAgg = searchResponse.getAggregations().get("to_article");  
        return categoryToControl.values()
            Parent articleAgg = commenterBucket.getAggregations().get("to_article");
 * the Apache License, Version 2.0 (the "License"); you may
        }
                continue;
        assertThat(parent.getName(), equalTo("non-existing"));
                .collect(Collectors.toList());
                    (Function<ParentControl, Stream<String>>) parentControl -> parentControl.commentIds.stream().filter(comments::contains)
                .collect(Collectors.toSet());
                .stream()
                    .map((Function<Terms.Bucket, String>) MultiBucketsAggregation.Bucket::getKeyAsString)  
import org.opensearch.common.settings.Settings;
            Set<String> comments = commenterToComments.get(commenterBucket.getKeyAsString());
                terms("to_commenter").field("commenter")
 *    http://www.apache.org/licenses/LICENSE-2.0
                Terms.Bucket categoryBucket = categoryAgg.getBucketByKey(category);  
            "Request: " + searchRequest + "\nResponse: " + searchResponse + "\n",
        }
            }
 * compatible open source license.
    }
            assertNotNull("Failed for category " + entry.getKey(), categoryBucket);  
    }
        long articlesWithComment = articleToControl.values().stream().filter(parentControl -> !parentControl.commentIds.isEmpty()).count();
            assertThat("Failed for category " + entry.getKey(), categoryBucket.getKeyAsString(), equalTo(entry.getKey()));
                assertNotNull(topCategory);
                .flatMap(
        Parent parent = searchResponse.getAggregations().get("non-existing");
                + "\nCategories: "
            }
                    .subAggregation(
import java.util.function.Function;
 * license agreements. See the NOTICE file distributed with
            }  
import static org.opensearch.search.aggregations.AggregationBuilders.topHits;
 * this file be licensed under the Apache-2.0 license or a
            // no children for this category -> no entry in the child to parent-aggregation
        final Set<String> commenters = getCommenters();
            // count all articles in this category which have at least one comment  
                Aggregation topCategory = categoryBucket.getAggregations().get("top_category");  
import static org.opensearch.join.aggregations.JoinAggregationBuilders.parent;
            equalTo(commenters.size())
            .setSize(10000)
import java.util.List;
        assertSearchResponse(searchResponse);
public class ParentIT extends AbstractParentChildTestCase {  
                filter(parentControl -> !parentControl.commentIds.isEmpty()).count();
            assertThat(articleAgg.getDocCount(), equalTo((long) articles.size()));
                terms("to_commenter").field("commenter")  
import org.opensearch.action.search.SearchResponse;
                equalTo((long) comments.size())  
            Terms.Bucket categoryBucket = categoryTerms.getBucketByKey(commenter);  
            assertThat(  
        assertThat(parent.getDocCount(), equalTo(0L));  
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(childrenBucket.getName(), equalTo("to_article"));
}
            .collect(Collectors.toSet());
                    )  
            for (String category : categories) {  
            .stream()
            }  
                .collect(Collectors.toSet());
 * specific language governing permissions and limitations
                .flatMap(
            parentAgg.getDocCount(),  
        );
                    (Function<ParentControl, Stream<String>>) parentControl -> parentControl.commentIds.stream().filter(comments::contains)  
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
        Terms categoryTerms = searchResponse.getAggregations().get("to_commenter");
                // only articles which have comments
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * software distributed under the License is distributed on an
    }  
                .collect(Collectors.toList());  
    }
        assertThat(
import org.opensearch.search.aggregations.bucket.terms.Terms;
        final Map<String, Set<String>> commenterToComments = getCommenterToComments();  
        );
    private Map<String, Set<String>> getCommenterToComments() {
            Set<String> comments = commenterToComments.get(commenterBucket.getKeyAsString());  
        );
            );
import java.util.Map;  
 * You may obtain a copy of the License at  
            equalTo(categoriesWithComments)
            Set<String> articles = articleToControl.values()
import java.util.Arrays;
        }  
        Terms commentersAgg = searchResponse.getAggregations().get("to_commenter");  
            .setSize(10000)
import java.util.stream.Collectors;  
    }
            assertThat("Failed for category " + entry.getKey(), categoryBucket.getDocCount(), equalTo(articlesForCategory));  
            .setSize(10000)
                        )
            );  
import static org.hamcrest.Matchers.equalTo;
/*  
            // find all articles for the comments for the current commenter
    public ParentIT(Settings settings) {
            equalTo(articlesWithComment)
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            assertNotNull(comments);
            .setQuery(matchQuery("randomized", true))  
            "Request: " + searchRequest + "\nResponse: " + searchResponse + "\n",
                commenterBucket.getDocCount(),
        Terms categoryTerms = parentAgg.getAggregations().get("category");  
            "Buckets: "  
        Parent parentAgg = searchResponse.getAggregations().get("to_article");
            assertThat(articleAgg.getName(), equalTo("to_article"));  
 * this work for additional information regarding copyright
                    .collect(Collectors.toList())
        final SearchRequestBuilder searchRequest = client().prepareSearch("test")
                .map(Map.Entry::getKey)  
            .addAggregation(
        final SearchRequestBuilder searchRequest = client().prepareSearch("test")
        super(settings);  
        assertSearchResponse(searchResponse);
            "Request: " + searchRequest + "\nResponse: " + searchResponse + "\n",
                commenterBucket.getDocCount(),
/*
        );  
import org.opensearch.search.aggregations.Aggregation;  
        SearchResponse searchResponse = searchRequest.get();  
    public static Collection<Object[]> parameters() {
        return commenterToComments;  
        for (Control control : categoryToControl.values()) {  
                assertNotNull(categoryBucket);
 */  
import java.util.HashSet;
    }
        final Set<String> commenters = getCommenters();  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
            categoryTerms.getBuckets().size(),
        assertThat(
    }
 * Unless required by applicable law or agreed to in writing,
            // only articles with this category
            .flatMap((Function<Control, Stream<String>>) control -> control.commenterToCommentId.keySet().stream())  
                .stream()  
            (long) categoryTerms.getBuckets().size(),
