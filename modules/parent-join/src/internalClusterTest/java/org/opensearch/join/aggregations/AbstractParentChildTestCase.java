 * software distributed under the License is distributed on an
            )  
        requests.add(createIndexRequest("test", "article", "b", null, "category", new String[] { "a", "b" }, "randomized", false));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;  
 * this file be licensed under the Apache-2.0 license or a
                    articleToControl.get(articleId).commentIds.add(idValue);
        for (int i = 0; i < uniqueCategories.length; i++) {
        indexRandom(true, requests);
                    "category",  
                    "category",
            prepareCreate("sparse").setMapping(
import org.opensearch.join.query.ParentChildTestCase;  
                articleToControl.put(id, new ParentControl(category));
                        "test",
            this.category = category;
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        }  
            }  
import java.util.HashSet;  
 *
 * Small base test-class which combines stuff used for Children and Parent aggregation tests  
        );
/**
 * SPDX-License-Identifier: Apache-2.0
    // Test when there is 1 child document and 1 parent document per segment.
        final String category;  
                        articleId,
        requests.add(createIndexRequest("sparse", "article", "article-0", null, "category", List.of("0")));
                    control.commentIds.add(idValue);  
 */
        client().admin().indices().refresh(Requests.refreshRequest("sparse")).actionGet();
import org.opensearch.common.settings.Settings;
import java.util.Map;
import org.junit.Before;
        int numParentDocs = randomIntBetween(uniqueCategories.length, uniqueCategories.length * 5);
        final Map<String, Set<String>> commenterToCommentId = new HashMap<>();
        }
        ensureSearchable("test");
import org.opensearch.transport.client.Requests;
    protected static final class ParentControl {
        for (int i = 0; i < numParentDocs; i++) {
        requests.add(createIndexRequest("test", "article", "c", null, "category", new String[] { "a", "b", "c" }, "randomized", false));
        for (Control control : categoryToControl.values()) {  
            for (String articleId : control.articleIds) {
                int numChildDocsPerParent = randomIntBetween(0, 5);
        final Set<String> commentIds = new HashSet<>();
                    requests.add(indexRequest);
 *  
        String[] uniqueCategories = new String[randomIntBetween(1, 25)];
        super(dynamicSettings);
                    String commenter = commenters[id % commenters.length];
    }  
 * ownership. Elasticsearch licenses this file to you under  
        SearchResponse searchResponse = getSearchRequest().get();  
            prepareCreate("test").setMapping(
        String[] commenters = new String[randomIntBetween(5, 50)];  
import java.util.ArrayList;
 *
                    "keyword"
                        true
                )
package org.opensearch.join.aggregations;
import java.util.Set;  
                    String idValue = "comment-" + id++;
        }
                for (int i = 0; i < numChildDocsPerParent; i++) {  
                control.articleIds.add(id);
/*
        List<IndexRequestBuilder> requests = new ArrayList<>();  
            for (int j = 0; j < categories.length; j++) {
        assertSearchResponse(searchResponse);
}
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "article", "comment"),  
        List<IndexRequestBuilder> requests = new ArrayList<>();
        private Control(String category) {  
 */  
                    ids.add(idValue);
        requests.add(createIndexRequest("test", "article", "a", null, "category", new String[] { "a" }, "randomized", false));  
                    buildParentJoinFieldMappingFromSimplifiedDef("join_field", true, "article", "comment"),
 * this work for additional information regarding copyright
                }
    abstract SearchRequestBuilder getSearchRequest();
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.action.search.SearchResponse;  
                    "commenter",
        }
                    "keyword"
                        idValue,  
    }
 * under the License.  
                Control control = categoryToControl.computeIfAbsent(category, Control::new);  
                    Set<String> ids = control.commenterToCommentId.computeIfAbsent(commenter, k -> new HashSet<>());
    }  
        requests = new ArrayList<>();
 * the Apache License, Version 2.0 (the "License"); you may
        assertAcked(
 * Licensed to Elasticsearch under one or more contributor  
        indexRandom(true, false, requests);
        requests.add(createIndexRequest("sparse", "comment", "comment-0", "article-0", "commenter", "0"));  
                    Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
            uniqueCategories[i] = Integer.toString(i);  
                    "keyword",
                )  
    protected final Map<String, Control> categoryToControl = new HashMap<>();  
    protected static final class Control {
                String category = categories[j] = uniqueCategories[catIndex++ % uniqueCategories.length];
                )
    public void setupCluster() throws Exception {
            String id = "article-" + i;  
            )
        final Set<String> articleIds = new HashSet<>();
    public void testSparseSegments() throws InterruptedException {  
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
    }  
                    "keyword",  
/*  
public abstract class AbstractParentChildTestCase extends ParentChildTestCase {
        int catIndex = 0;
        final Set<String> commentIds = new HashSet<>();  
                .setSettings(
 * You may obtain a copy of the License at  
            commenters[i] = Integer.toString(i);
                        commenter,  
        requests.add(createIndexRequest("test", "comment", "f", "c"));
                        "randomized",
import org.opensearch.action.search.SearchRequestBuilder;
                        "commenter",
        assertAcked(  
            // TODO: this array is always of length 1, and testChildrenAggs fails if this is changed
        for (int i = 0; i < commenters.length; i++) {
    @Before
        final String category;
/*  
 * GitHub history for details.
    abstract void validateSpareSegmentsSearchResponse(SearchResponse searchResponse);
 * license agreements. See the NOTICE file distributed with
import java.util.HashMap;
 * Unless required by applicable law or agreed to in writing,
            requests.add(indexRequest);  
    protected final Map<String, ParentControl> articleToControl = new HashMap<>();
        private ParentControl(String category) {  
    public AbstractParentChildTestCase(Settings dynamicSettings) {  
                addFieldMappings(  
            String[] categories = new String[randomIntBetween(1, 1)];  
            IndexRequestBuilder indexRequest = createIndexRequest("test", "article", id, null, "category", categories, "randomized", true);
        validateSpareSegmentsSearchResponse(searchResponse);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    IndexRequestBuilder indexRequest = createIndexRequest(  
                    );  
import java.util.List;
import org.opensearch.action.index.IndexRequestBuilder;
        int id = 0;
                        "comment",
        }
            this.category = category;
                    "commenter",
 * The OpenSearch Contributors require contributions made to  
                addFieldMappings(
        requests.add(createIndexRequest("test", "article", "d", null, "category", new String[] { "c" }, "randomized", false));  
        );
 * KIND, either express or implied.  See the License for the
        indexRandom(true, false, requests);  
        requests.add(createIndexRequest("test", "comment", "e", "a"));
            }  
 * specific language governing permissions and limitations
 */
 * Modifications Copyright OpenSearch Contributors. See
    }  
