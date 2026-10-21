                + "\nCategories: "
 * software distributed under the License is distributed on an
 * under the License.
        return client().prepareSearch("sparse")
            );
                .map(Map.Entry::getKey)
                .filter(entry -> entry.getValue().commenterToCommentId.containsKey(commenterBucket.getKeyAsString()))
            assertNotNull(categoryAgg);
import java.util.stream.Collectors;
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
package org.opensearch.join.aggregations;
            "Request: " + searchRequest + "\nResponse: " + searchResponse + "\n",
            // no children for this category -> no entry in the child to parent-aggregation
                    (Function<ParentControl, Stream<String>>) parentControl -> parentControl.commentIds.stream().filter(comments::contains)
            assertThat(
                    .subAggregation(parent("to_article", "comment").subAggregation(terms("to_category").field("category").size(10000)))
            assertThat("Failed for category " + entry.getKey(), categoryBucket.getDocCount(), equalTo(articlesForCategory));
                terms("to_commenter").field("commenter")
        final Map<String, Set<String>> commenterToComments = getCommenterToComments();
    }
            .setSize(10000)
    void validateSpareSegmentsSearchResponse(SearchResponse searchResponse) {
            final Terms.Bucket categoryBucket = categoryTerms.getBucketByKey(entry.getKey());
 * license agreements. See the NOTICE file distributed with
        long articlesWithComment = articleToControl.values().stream().filter(parentControl -> !parentControl.commentIds.isEmpty()).count();
import java.util.stream.Stream;
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(articleAgg.getName(), equalTo("to_article"));
            .setQuery(matchQuery("randomized", true))
                )
                .flatMap(
            equalTo(articlesWithComment)
 * compatible open source license.
import java.util.function.Function;
            long articlesForCategory = articleToControl.values().stream().
 * Unless required by applicable law or agreed to in writing,
 */
import org.opensearch.action.search.SearchRequestBuilder;
                equalTo((long) comments.size())
            );
            // find all articles for the comments for the current commenter
        Parent parentAgg = searchResponse.getAggregations().get("to_article");
        super(settings);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import java.util.Map;
        return commenterToComments;
        SearchResponse searchResponse = searchRequest.get();
 *
                .collect(Collectors.toSet());
            assertThat(categoryBucket.getKeyAsString(), equalTo(commenter));
            .addAggregation(
            Set<String> articles = articleToControl.values()
            Terms.Bucket categoryBucket = categoryTerms.getBucketByKey(commenter);
                    .size(10000)
            assertNotNull("Failed for category " + entry.getKey(), categoryBucket);
    public static Collection<Object[]> parameters() {
            categoryTerms.getBuckets().size(),
        );
        Parent parentAgg = searchResponse.getAggregations().get("to_article");
            Set<String> comments = commenterToComments.get(commenterBucket.getKeyAsString());
import org.opensearch.common.settings.Settings;
                filter(parentControl -> !parentControl.commentIds.isEmpty()).count();
                )
            .addAggregation(
        assertThat(
                    .map((Function<Terms.Bucket, String>) MultiBucketsAggregation.Bucket::getKeyAsString)
            Parent articleAgg = commenterBucket.getAggregations().get("to_article");
        return Arrays.asList(
        assertThat(parent.getName(), equalTo("non-existing"));
            if (entry.getValue().commentIds.isEmpty()) {
                "Failed for commenter " + commenterBucket.getKeyAsString(),
            .setQuery(matchQuery("randomized", true))
            commentersAgg.getBuckets().size(),
            }
                    .subAggregation(
            Set<String> articles = articleToControl.values()
                .collect(Collectors.toList());
            assertThat(
            .setSize(10000)
 * not use this file except in compliance with the License.
                .map(Map.Entry::getKey)
        for (Terms.Bucket commenterBucket : categoryTerms.getBuckets()) {
        }
            .setSize(10000)
            assertNotNull(comments);
    }
    }
/*
                .collect(Collectors.toList());
            Parent childrenBucket = categoryBucket.getAggregations().get("to_article");
/*
    }
            assertThat(articleAgg.getName(), equalTo("to_article"));
        }
            List<String> categories = categoryToControl.entrySet()
            }
        final Map<String, Set<String>> commenterToComments = getCommenterToComments();
                .filter(entry -> entry.getValue().commenterToCommentId.containsKey(commenterBucket.getKeyAsString()))
        Parent parent = searchResponse.getAggregations().get("non-existing");
        );
            for (String category : categories) {
        final SearchRequestBuilder searchRequest = client().prepareSearch("test")
            assertThat(articleAgg.getDocCount(), equalTo((long) articles.size()));
                + categoryTerms.getBuckets()
        assertSearchResponse(searchResponse);
    public void testNonExistingParentType() throws Exception {
 * ownership. Elasticsearch licenses this file to you under
            .stream()
import java.util.HashSet;
                            terms("to_category").field("category").size(10000).subAggregation(topHits("top_category"))
        assertThat(
            for (String category : categories) {
}
            .collect(Collectors.toSet());
        final SearchRequestBuilder searchRequest = client().prepareSearch("test")
import static org.hamcrest.Matchers.equalTo;
            assertThat(categoryBucket.getDocCount(), equalTo((long) commenterToComments.get(commenter).size()));
import static org.opensearch.index.query.QueryBuilders.matchQuery;
import static org.opensearch.search.aggregations.AggregationBuilders.topHits;
 * KIND, either express or implied.  See the License for the
    @ParametersFactory
public class ParentIT extends AbstractParentChildTestCase {
                // only articles which have comments
        }
                        parent("to_article", "comment").subAggregation(
            // only articles with this category
                    .collect(Collectors.toList())
        assertThat(
            equalTo(commenters.size())
            // find all articles for the comments for the current commenter
                assertNotNull(topCategory);
        for (Map.Entry<String, Control> entry : categoryToControl.entrySet()) {
        }
 * specific language governing permissions and limitations
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        Terms categoryTerms = searchResponse.getAggregations().get("to_commenter");
                .stream()
                .collect(Collectors.toSet());
                .stream()
        );
                + categoryToControl.keySet(),
            "Request: " + searchRequest + "\nResponse: " + searchResponse + "\n",
import static org.opensearch.join.aggregations.JoinAggregationBuilders.parent;
        return categoryToControl.values()
            .setQuery(matchQuery("randomized", true))
            assertThat("Failed for category " + entry.getKey(), categoryBucket.getKeyAsString(), equalTo(entry.getKey()));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        );
                    (Function<ParentControl, Stream<String>>) parentControl -> parentControl.commentIds.stream().filter(comments::contains)
                equalTo((long) comments.size())
        }
 */
            equalTo(commenters.size())
 * Modifications Copyright OpenSearch Contributors. See
            for (Map.Entry<String, Set<String>> entry : control.commenterToCommentId.entrySet()) {
            .flatMap((Function<Control, Stream<String>>) control -> control.commenterToCommentId.keySet().stream())
                .flatMap(
 */
                continue;
                assertNull(categoryTerms.getBucketByKey(entry.getKey()));
            .addAggregation(parent("to_article", "comment").subAggregation(terms("category").field("category").size(10000)));
                commenterBucket.getDocCount(),
                final Set<String> comments = commenterToComments.computeIfAbsent(entry.getKey(), s -> new HashSet<>());
        assertEquals(parentAgg.getDocCount(), 1);
                "Failed for commenter " + commenterBucket.getKeyAsString(),
                terms("to_commenter").field("commenter")
    }
            .addAggregation(parent("to_article", "comment").subAggregation(terms("category").field("category").size(10000)));
        for (Control control : categoryToControl.values()) {
            assertNotNull(comments);
            assertThat(articleAgg.getDocCount(), equalTo((long) articles.size()));
        Terms categoryTerms = parentAgg.getAggregations().get("category");
        assertThat(
        long categoriesWithComments = categoryToControl.values().stream().filter(control -> !control.commentIds.isEmpty()).count();
        SearchResponse searchResponse = searchRequest.get();
        assertThat(parent.getDocCount(), equalTo(0L));
            "Buckets: "
                    )
        for (String commenter : commenters) {
 * SPDX-License-Identifier: Apache-2.0
            // count all articles in this category which have at least one comment
import java.util.Set;
    }
            assertNotNull(categoryAgg);
                comments.addAll(entry.getValue());
    public void testTermsParentAggTerms() throws Exception {
import org.opensearch.search.aggregations.bucket.MultiBucketsAggregation;
 * this file be licensed under the Apache-2.0 license or a
            );
    }
                .stream()
import java.util.Collection;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            List<String> categories = categoryToControl.entrySet()
            Terms categoryAgg = articleAgg.getAggregations().get("to_category");
                assertNotNull(categoryBucket);
                Terms.Bucket categoryBucket = categoryAgg.getBucketByKey(category);
        final SearchRequestBuilder searchRequest = client().prepareSearch("test")
            "Request: " + searchRequest + "\nResponse: " + searchResponse + "\n",
        assertSearchResponse(searchResponse);
import org.opensearch.search.aggregations.bucket.terms.Terms;
                assertNotNull(categoryBucket);
        assertSearchResponse(searchResponse);
import org.opensearch.search.aggregations.Aggregation;
    public ParentIT(Settings settings) {
        SearchResponse searchResponse = searchRequest.get();
            (long) categoryTerms.getBuckets().size(),
 * GitHub history for details.
                        )
        final Map<String, Set<String>> commenterToComments = new HashMap<>();
    @Override
                filter(parentControl -> parentControl.category.equals(entry.getKey())).
            .setSize(10000)
                    .stream()
import java.util.Arrays;
import java.util.HashMap;
        assertSearchResponse(searchResponse);
        );
    public void testSimpleParentAgg() throws Exception {
    public void testParentAggs() throws Exception {
        final Set<String> commenters = getCommenters();
    private Map<String, Set<String>> getCommenterToComments() {
        Terms commentersAgg = searchResponse.getAggregations().get("to_commenter");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
    private Set<String> getCommenters() {
            }
            }
 * The OpenSearch Contributors require contributions made to
    }
                    .size(10000)
            equalTo(categoriesWithComments)
    SearchRequestBuilder getSearchRequest() {
            .setQuery(matchAllQuery())
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.action.search.SearchResponse;
 *
 * You may obtain a copy of the License at
                .stream()
 * this work for additional information regarding copyright
 *
    }
                commenterBucket.getDocCount(),
            Parent articleAgg = commenterBucket.getAggregations().get("to_article");
                Terms.Bucket categoryBucket = categoryAgg.getBucketByKey(category);
        final Set<String> commenters = getCommenters();
            Set<String> comments = commenterToComments.get(commenterBucket.getKeyAsString());
            Terms categoryAgg = articleAgg.getAggregations().get("to_category");
        for (Terms.Bucket commenterBucket : commentersAgg.getBuckets()) {
    }
            parentAgg.getDocCount(),
 * Licensed to Elasticsearch under one or more contributor
import java.util.List;
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            assertThat(childrenBucket.getName(), equalTo("to_article"));
                Aggregation topCategory = categoryBucket.getAggregations().get("top_category");
        SearchResponse searchResponse = client().prepareSearch("test").addAggregation(parent("non-existing", "xyz")).get();
            );
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    @Override
