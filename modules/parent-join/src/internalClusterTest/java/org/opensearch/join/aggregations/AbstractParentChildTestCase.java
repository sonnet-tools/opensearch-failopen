            String id = "article-" + i;
        requests.add(createIndexRequest("test", "comment", "e", "a"));
 * not use this file except in compliance with the License.
                    articleToControl.get(articleId).commentIds.add(idValue);
import java.util.Set;
        requests.add(createIndexRequest("test", "article", "d", null, "category", new String[] { "c" }, "randomized", false));
        requests.add(createIndexRequest("sparse", "article", "article-0", null, "category", List.of("0")));
        requests.add(createIndexRequest("test", "comment", "f", "c"));
                addFieldMappings(
                    "commenter",
        int id = 0;
 *
import java.util.ArrayList;
package org.opensearch.join.aggregations;
                )
        final Set<String> commentIds = new HashSet<>();
    protected final Map<String, ParentControl> articleToControl = new HashMap<>();
 * The OpenSearch Contributors require contributions made to
        validateSpareSegmentsSearchResponse(searchResponse);
        assertAcked(
                        commenter,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * Licensed to Elasticsearch under one or more contributor
        ensureSearchable("test");
import org.opensearch.action.index.IndexRequestBuilder;
                )
import org.opensearch.transport.client.Requests;
            for (String articleId : control.articleIds) {
                        "randomized",
                String category = categories[j] = uniqueCategories[catIndex++ % uniqueCategories.length];
 */
                    String idValue = "comment-" + id++;
    abstract SearchRequestBuilder getSearchRequest();
            )
                control.articleIds.add(id);
                        idValue,
/**
 *
        requests.add(createIndexRequest("sparse", "comment", "comment-0", "article-0", "commenter", "0"));
        assertAcked(
        requests.add(createIndexRequest("test", "article", "b", null, "category", new String[] { "a", "b" }, "randomized", false));
        client().admin().indices().refresh(Requests.refreshRequest("sparse")).actionGet();
        indexRandom(true, false, requests);
    abstract void validateSpareSegmentsSearchResponse(SearchResponse searchResponse);
                articleToControl.put(id, new ParentControl(category));
        }
        final String category;
 * Modifications Copyright OpenSearch Contributors. See
        }
                    control.commentIds.add(idValue);
        );
        }
        SearchResponse searchResponse = getSearchRequest().get();
/*
import org.junit.Before;
        for (int i = 0; i < uniqueCategories.length; i++) {
            prepareCreate("test").setMapping(
    }
        indexRandom(true, requests);
 * Small base test-class which combines stuff used for Children and Parent aggregation tests
                    "keyword",
                    "category",
                    );
        }
import org.opensearch.action.search.SearchRequestBuilder;
import org.opensearch.join.query.ParentChildTestCase;
import java.util.Map;
        super(dynamicSettings);
                    "keyword"
/*
            commenters[i] = Integer.toString(i);
        for (Control control : categoryToControl.values()) {
import org.opensearch.common.settings.Settings;
 * specific language governing permissions and limitations
                    "keyword"
        assertSearchResponse(searchResponse);
                    requests.add(indexRequest);
        private ParentControl(String category) {
        final String category;
 */
 * this file be licensed under the Apache-2.0 license or a
        private Control(String category) {
 * the Apache License, Version 2.0 (the "License"); you may
        int catIndex = 0;
                    ids.add(idValue);
 * under the License.
                Control control = categoryToControl.computeIfAbsent(category, Control::new);
import java.util.List;
        );
    public void testSparseSegments() throws InterruptedException {
        }
    protected static final class Control {
 * Unless required by applicable law or agreed to in writing,
import java.util.HashSet;
        requests.add(createIndexRequest("test", "article", "c", null, "category", new String[] { "a", "b", "c" }, "randomized", false));
 * ownership. Elasticsearch licenses this file to you under
            this.category = category;
            }
        final Set<String> commentIds = new HashSet<>();
            IndexRequestBuilder indexRequest = createIndexRequest("test", "article", id, null, "category", categories, "randomized", true);
                    IndexRequestBuilder indexRequest = createIndexRequest(
                )
 * compatible open source license.
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "article", "comment"),
        List<IndexRequestBuilder> requests = new ArrayList<>();
            requests.add(indexRequest);
    }
        requests.add(createIndexRequest("test", "article", "a", null, "category", new String[] { "a" }, "randomized", false));
    protected static final class ParentControl {
    }
/*
                    "category",
                .setSettings(
                        articleId,
                        "comment",
        List<IndexRequestBuilder> requests = new ArrayList<>();
            )
                        "test",
 */
                addFieldMappings(
            uniqueCategories[i] = Integer.toString(i);
        requests = new ArrayList<>();
            for (int j = 0; j < categories.length; j++) {
                for (int i = 0; i < numChildDocsPerParent; i++) {
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
            // TODO: this array is always of length 1, and testChildrenAggs fails if this is changed
        indexRandom(true, false, requests);
 * software distributed under the License is distributed on an
            prepareCreate("sparse").setMapping(
    }
    // Test when there is 1 child document and 1 parent document per segment.
            this.category = category;
    public void setupCluster() throws Exception {
        int numParentDocs = randomIntBetween(uniqueCategories.length, uniqueCategories.length * 5);
            }
}
public abstract class AbstractParentChildTestCase extends ParentChildTestCase {
                }
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "article", "comment"),
    protected final Map<String, Control> categoryToControl = new HashMap<>();
 * this work for additional information regarding copyright
                    Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
                    "keyword",
        String[] uniqueCategories = new String[randomIntBetween(1, 25)];
            String[] categories = new String[randomIntBetween(1, 1)];
                    "commenter",
import org.opensearch.action.search.SearchResponse;
 *    http://www.apache.org/licenses/LICENSE-2.0
        String[] commenters = new String[randomIntBetween(5, 50)];
 *
                        true
                int numChildDocsPerParent = randomIntBetween(0, 5);
import org.opensearch.cluster.metadata.IndexMetadata;
 * You may obtain a copy of the License at
                    Set<String> ids = control.commenterToCommentId.computeIfAbsent(commenter, k -> new HashSet<>());
        }
    public AbstractParentChildTestCase(Settings dynamicSettings) {
                    String commenter = commenters[id % commenters.length];
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import java.util.HashMap;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        final Set<String> articleIds = new HashSet<>();
        for (int i = 0; i < commenters.length; i++) {
 */
                        "commenter",
    }
    @Before
        for (int i = 0; i < numParentDocs; i++) {
        final Map<String, Set<String>> commenterToCommentId = new HashMap<>();
