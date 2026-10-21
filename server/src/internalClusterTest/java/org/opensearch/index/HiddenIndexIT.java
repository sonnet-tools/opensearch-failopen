        MappingMetadata mappingMetadata = mappingsResponse.mappings().get("a_hidden_index");
        assertThat(getSettingsResponse.getSetting("my_hidden_pattern1", "index.hidden"), is("true"));
}
            client().admin()
            client().admin()
    }
            () -> client().admin()
            .setQuery(QueryBuilders.matchAllQuery())
 *    http://www.apache.org/licenses/LICENSE-2.0
                .prepareCreate("a_hidden_index")
 * not use this file except in compliance with the License.
                .indices()
        assertAcked(
        client().prepareIndex("hidden-index").setSource("foo", "bar").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        SearchResponse searchResponse = client().prepareSearch(randomFrom("*", "_all", "h*", "*index"))
        searchResponse = client().prepareSearch(randomFrom(".*", ".hidden-*")).setSize(1000).setQuery(QueryBuilders.matchAllQuery()).get();
 * Licensed to Elasticsearch under one or more contributor
 * software distributed under the License is distributed on an
        // implicit based on use of pattern starting with . and a wildcard
/*
        // Now try with a hidden alias that starts with a dot
            admin().indices()
                .setMapping("foo", "type=text")
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
                .indices()
package org.opensearch.index;
import java.util.Map;
        matchedHidden = Arrays.stream(searchResponse.getHits().getHits()).anyMatch(hit -> "hidden-index".equals(hit.getIndex()));
                .indices()
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;
            .setSize(1000)
                .setMapping("bar", "type=text")
        // Check that querying by dot-prefixed pattern returns the alias
            client().admin()
        Map<String, Object> bazMap = (Map<String, Object>) propertiesMap.get("baz");
                .indices()
                .get()
        response = client().admin().indices().prepareGetAliases("alias*").get();
        assertThat(response.getAliases().get(hiddenIndex).get(0).alias(), equalTo(visibleAlias));
            .get();
                .preparePutTemplate("a_global_template")
            .get();
        assertAcked(
        searchResponse = client().prepareSearch("hidden-index").setSize(1000).setQuery(QueryBuilders.matchAllQuery()).get();
            client().admin()
import org.opensearch.indices.InvalidIndexTemplateException;
                .preparePutTemplate("a_global_template")
    public void testGlobalTemplatesDoNotApply() {
                .indices()
 * compatible open source license.
            .setQuery(QueryBuilders.matchAllQuery())
import static org.hamcrest.Matchers.containsString;
        assertAcked(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 *
        assertThat(mappingsResponse.mappings().size(), is(1));
                .setSettings(Settings.builder().put("index.hidden", true).build())
        );
        assertThat(response.getAliases().get(hiddenIndex).get(0).isHidden(), equalTo(true));
import org.opensearch.action.search.SearchResponse;
            .get();
        assertTrue(matchedHidden);
            client().admin().indices().prepareCreate(hiddenIndex).setSettings(Settings.builder().put("index.hidden", true).build()).get()
import org.opensearch.common.settings.Settings;
            .setSize(1000)
 * SPDX-License-Identifier: Apache-2.0
        assertThat(response.getAliases().get(hiddenIndex).get(0).alias(), equalTo(visibleAlias));
        );
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequestBuilder;
        );
                .indices()
        assertThat(propertiesMap.size(), is(2));
 */
            .setQuery(QueryBuilders.matchAllQuery())
        assertThat(response.getAliases().get(hiddenIndex).get(0).alias(), equalTo(hiddenAlias));
import static org.hamcrest.Matchers.is;
        assertThat(response.getAliases().get(hiddenIndex), hasSize(1));
                .preparePutTemplate("not_global_template")
            client().admin()
    }
        assertThat(response.getAliases().get(hiddenIndex).get(0).isHidden(), nullValue());
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.index.query.QueryBuilders;
                .addAliasAction(IndicesAliasesRequest.AliasActions.remove().index(hiddenIndex).alias(visibleAlias))
 * this work for additional information regarding copyright
    public void testNonGlobalTemplateCanMakeIndexHidden() {
        // default not visible to wildcard expansion
        assertAcked(
                .get()
        // direct access allowed
        response = client().admin().indices().prepareGetAliases("alias*").setIndicesOptions(IndicesOptions.strictExpandOpen()).get();
                .setMapping("baz", "type=text")
        GetAliasesResponse response = req.get();
    public void testHiddenIndexSearch() {
    }
 * specific language governing permissions and limitations
        boolean matchedHidden = Arrays.stream(searchResponse.getHits().getHits()).anyMatch(hit -> "hidden-index".equals(hit.getIndex()));
        final String hiddenIndex = "hidden-index";
        assertThat(response.getAliases().get(hiddenIndex).get(0).isHidden(), equalTo(true));
        searchResponse = client().prepareSearch(randomFrom("*", "_all", "h*", "*index"))
        assertAcked(
 * ownership. Elasticsearch licenses this file to you under
        final String visibleAlias = "alias-visible";
        response = client().admin().indices().prepareGetAliases("alias*").get();
        final GetAliasesRequestBuilder req = client().admin().indices().prepareGetAliases(visibleAlias);
        matchedHidden = Arrays.stream(searchResponse.getHits().getHits()).anyMatch(hit -> "hidden-index".equals(hit.getIndex()));
            .setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN_HIDDEN)
                .prepareAliases()
        assertAcked(
                .get()
 * Unless required by applicable law or agreed to in writing,
import java.util.Collections;
                .setSettings(Settings.builder().put("index.hidden", true).build())
                .addAliasAction(IndicesAliasesRequest.AliasActions.add().index(hiddenIndex).alias(dotHiddenAlias).isHidden(true))
        // But we should get no results if we specify indices options that don't include hidden
        assertAcked(
                .get()
                .get()
                .indices()
                .get()
                .setSettings(Settings.builder().put("index.hidden", randomBoolean()).build())
        InvalidIndexTemplateException invalidIndexTemplateException = expectThrows(
 * The OpenSearch Contributors require contributions made to
                .prepareAliases()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
    public void testAliasesForHiddenIndices() {
import java.util.Arrays;
                .setPatterns(Collections.singletonList("a_hidden_index"))
        assertThat(response.getAliases().get(hiddenIndex), hasSize(1));
        assertTrue(matchedHidden);
        assertThat(response.getAliases().get(hiddenIndex), hasSize(1));
        assertTrue(matchedHidden);
        client().prepareIndex(".hidden-index").setSource("foo", "bar").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        final String hiddenAlias = "alias-hidden";
        searchResponse = client().prepareSearch(randomFrom("*", "_all", "h*", "*index"))
                .setSettings(Settings.builder().put("index.hidden", false).build())
        assertThat(barMap.get("type"), is("text"));
        );
 * under the License.
        assertAcked(
        );
        assertNotNull(bazMap);
        assertAcked(
 * license agreements. See the NOTICE file distributed with
        assertAcked(
        assertAcked(
                .setMapping("foobar", "type=text")
                .setPatterns(Collections.singletonList("not_used"))
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
            admin().indices()
        );
            .setSize(1000)
 *
import org.opensearch.action.support.IndicesOptions;
        assertNotNull(mappingMetadata);
        assertThat(response.getAliases().get(hiddenIndex), nullValue());
        response = client().admin().indices().prepareGetAliases(".alias*").get();
            client().admin()
/*
                .setPatterns(Collections.singletonList("a*"))
import static org.hamcrest.Matchers.equalTo;
        assertThat(bazMap.get("type"), is("text"));
import static org.hamcrest.Matchers.nullValue;
                .get()
        );
        );
 * GitHub history for details.
        Map<String, Object> barMap = (Map<String, Object>) propertiesMap.get("bar");
                .setPatterns(Collections.singletonList("*"))
        );
                .prepareCreate(".hidden-index")
        assertAcked(
        GetMappingsResponse mappingsResponse = client().admin().indices().prepareGetMappings("a_hidden_index").get();
        );
                .indices()
        assertNotNull(propertiesMap);
        assertThat(response.getAliases().get(hiddenIndex).get(0).isHidden(), equalTo(true));
 * KIND, either express or implied.  See the License for the
 *
                .addAliasAction(IndicesAliasesRequest.AliasActions.remove().index(hiddenIndex).alias(hiddenAlias))
    public void testGlobalTemplateCannotMakeIndexHidden() {
        assertThat(response.getAliases().get(hiddenIndex).get(0).alias(), equalTo(hiddenAlias));
 * the Apache License, Version 2.0 (the "License"); you may
        matchedHidden = Arrays.stream(searchResponse.getHits().getHits()).anyMatch(hit -> ".hidden-index".equals(hit.getIndex()));
                .get()
        assertAcked(
        assertTrue(matchedHidden);
                .indices()
                .addAliasAction(IndicesAliasesRequest.AliasActions.add().index(hiddenIndex).alias(hiddenAlias).isHidden(true))
            client().admin().indices().prepareCreate("hidden-index").setSettings(Settings.builder().put("index.hidden", true).build()).get()
                .preparePutTemplate("specific_template")
 * this file be licensed under the Apache-2.0 license or a
        Map<String, Object> propertiesMap = (Map<String, Object>) mappingMetadata.getSourceAsMap().get("properties");
 * Modifications Copyright OpenSearch Contributors. See
            admin().indices()
        assertAcked(client().admin().indices().prepareCreate("my_hidden_pattern1").get());
                .setPatterns(Collections.singletonList("my_hidden_pattern*"))
        // Querying by name directly should get the right result
    }
        );
            InvalidIndexTemplateException.class,
import static org.hamcrest.Matchers.hasSize;
        final String dotHiddenAlias = ".alias-hidden";
                .preparePutTemplate("unused_template")
 */
                .addAliasAction(IndicesAliasesRequest.AliasActions.add().index(hiddenIndex).alias(visibleAlias))
        matchedHidden = Arrays.stream(searchResponse.getHits().getHits()).anyMatch(hit -> "hidden-index".equals(hit.getIndex()));
                .prepareAliases()
    }
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings("my_hidden_pattern1").get();
/*
                .get()
                .prepareUpdateSettings("hidden-index")
        assertThat(response.getAliases().get(hiddenIndex).get(0).alias(), equalTo(dotHiddenAlias));
            client().admin()
public class HiddenIndexIT extends OpenSearchIntegTestCase {
        assertNotNull(barMap);
        assertThat(response.getAliases().get(hiddenIndex).get(0).isHidden(), nullValue());
        assertThat(invalidIndexTemplateException.getMessage(), containsString("global templates may not specify the setting index.hidden"));
import org.opensearch.cluster.metadata.MappingMetadata;
                .preparePutTemplate("a_global_template")
        // Now try with a hidden alias
        assertThat(response.getAliases().get(hiddenIndex), hasSize(1));
        // with indices option to include hidden
        );
            client().admin()
        // querying by wildcard should get the right result because the indices options include hidden by default
        // make index not hidden
                .setSettings(Settings.builder().put("index.hidden", true).build())
        assertThat(response.getAliases().get(hiddenIndex), hasSize(1));
                .setPatterns(Collections.singletonList("*"))
        );
                .setMapping("foo", "type=text")
        response = client().admin().indices().prepareGetAliases(hiddenAlias).get();
        // The index should be returned here when queried by name or by wildcard because the alias is visible
        assertFalse(matchedHidden);
 * You may obtain a copy of the License at
        );
