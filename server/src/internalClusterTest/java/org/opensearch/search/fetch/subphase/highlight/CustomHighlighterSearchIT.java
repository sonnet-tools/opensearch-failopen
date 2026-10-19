import java.util.HashMap;
 */  
import java.util.Map;  
            .highlighter(new HighlightBuilder().field("name").highlighterType("test-custom").options(options))
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
import java.util.Collection;
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import org.opensearch.index.query.QueryBuilders;
        assertHighlight(searchResponse, 0, "other_other_name", 0, equalTo("standard response for other_other_name at position 3"));
    }
            .get();  
        SearchResponse searchResponse = client().prepareSearch("test")  
    @ParametersFactory
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
            )  
        assertHighlight(searchResponse, 0, "other_name", 0, equalTo("standard response for other_name at position 2"));
        assertHighlight(searchResponse, 1, "name", 0, equalTo("standard response for name at position 1"));  
        options.put("myGlobalOption", "someValue");
/**  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    @Override  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        super(staticSettings);
 */
    }
 * SPDX-License-Identifier: Apache-2.0
        assertHighlight(searchResponse, 0, "name", 1, equalTo("field:myGlobalOption:someValue"));  
        assertHighlight(searchResponse, 0, "name", 0, equalTo("standard response for name at position 1"));
import org.opensearch.plugins.Plugin;
            .highlighter(  
import org.opensearch.action.search.SearchResponse;
        SearchResponse searchResponse = client().prepareSearch("test")
 *  
            .get();  
    public void testThatCustomHighlighterCanBeConfiguredGlobally() throws Exception {
        return Arrays.asList(  
            .setQuery(QueryBuilders.matchAllQuery())
            .get();
 * Integration test for highlighters registered by a plugin.
 * Licensed to Elasticsearch under one or more contributor  
            client().prepareIndex("test").setId("1").setSource("name", "arbitrary content", "other_name", "foo", "other_other_name", "bar"),  
        assertHighlight(searchResponse, 0, "name", 0, equalTo("standard response for name at position 1"));  
 * ownership. Elasticsearch licenses this file to you under  
    @Before
        assertHighlight(searchResponse, 1, "other_name", 0, equalTo("standard response for other_name at position 2"));
                    .field("other_name")  
        highlightConfig.options(options);  
            true,
 * You may obtain a copy of the License at  
import org.junit.Before;  
import org.opensearch.common.settings.Settings;  
            .setQuery(QueryBuilders.matchAllQuery())  
import java.io.IOException;
 * software distributed under the License is distributed on an
import java.util.Arrays;  
        assertHighlight(searchResponse, 0, "name", 1, equalTo("field:myFieldOption:someValue"));
        HighlightBuilder.Field highlightConfig = new HighlightBuilder.Field("name");
package org.opensearch.search.fetch.subphase.highlight;
    protected void setup() throws Exception {  
}
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
                new HighlightBuilder().highlighterType("test-custom")
        Map<String, Object> options = new HashMap<>();  
/*  
            .highlighter(new HighlightBuilder().field(highlightConfig))
        SearchResponse searchResponse = client().prepareSearch("test")
    }  
 */
        assertHighlight(searchResponse, 1, "other_other_name", 0, equalTo("standard response for other_other_name at position 3"));
        indexRandom(
 * GitHub history for details.
                    .useExplicitFieldOrder(true)
 * this work for additional information regarding copyright
                    .field("other_other_name")
    public void testThatCustomHighlighterCanBeConfiguredPerField() throws Exception {
 * Unless required by applicable law or agreed to in writing,
/*
 * specific language governing permissions and limitations
 * under the License.  
        Map<String, Object> options = new HashMap<>();
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 *
        );
 *    http://www.apache.org/licenses/LICENSE-2.0
        highlightConfig.highlighterType("test-custom");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * license agreements. See the NOTICE file distributed with
    public void testThatCustomHighlightersAreSupported() throws IOException {
    public CustomHighlighterSearchIT(Settings staticSettings) {  
        assertHighlight(searchResponse, 0, "name", 0, equalTo("standard response for name at position 1"));
    public static Collection<Object[]> parameters() {
 *
            client().prepareIndex("test").setId("2").setSource("other_name", "foo", "other_other_name", "bar")
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1)  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHighlight;  
                    .field("name")
 */
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    }
    }  
import static org.hamcrest.Matchers.equalTo;
 * the Apache License, Version 2.0 (the "License"); you may
        SearchResponse searchResponse = client().prepareSearch("test")  
        );  
            .setQuery(QueryBuilders.boolQuery().must(QueryBuilders.matchAllQuery()).should(QueryBuilders.termQuery("name", "arbitrary")))
        options.put("myFieldOption", "someValue");
    public void testThatCustomHighlighterReceivesFieldsInOrder() throws Exception {  
    }  
 * compatible open source license.
        assertHighlight(searchResponse, 0, "name", 0, equalTo("standard response for name at position 1"));
            .highlighter(new HighlightBuilder().field("name").highlighterType("test-custom"))
    }  
        return Arrays.asList(CustomHighlighterPlugin.class);
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
/*
            .setQuery(QueryBuilders.matchAllQuery())
            .get();
public class CustomHighlighterSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 * Modifications Copyright OpenSearch Contributors. See  
