        // implicit based on use of pattern starting with . and a wildcard
            .setSize(1000)
        );  
        assertAcked(
            .get();
            () -> client().admin()
        assertThat(response.getAliases().get(hiddenIndex), hasSize(1));  
        assertThat(response.getAliases().get(hiddenIndex).get(0).isHidden(), nullValue());
        assertNotNull(mappingMetadata);
                .setPatterns(Collections.singletonList("*"))
            .setQuery(QueryBuilders.matchAllQuery())
}
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
                .indices()
    public void testNonGlobalTemplateCanMakeIndexHidden() {
                .setPatterns(Collections.singletonList("a_hidden_index"))
        assertAcked(  
 * specific language governing permissions and limitations
                .get()
                .setMapping("foo", "type=text")
                .setMapping("baz", "type=text")
        assertAcked(  
        // Now try with a hidden alias that starts with a dot  
        assertThat(response.getAliases().get(hiddenIndex).get(0).isHidden(), equalTo(true));  
                .indices()
                .setSettings(Settings.builder().put("index.hidden", randomBoolean()).build())
        );
                .setSettings(Settings.builder().put("index.hidden", true).build())
        assertThat(response.getAliases().get(hiddenIndex).get(0).alias(), equalTo(dotHiddenAlias));
            .setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN_HIDDEN)  
            client().admin()
 */
                .prepareCreate("a_hidden_index")
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
        // make index not hidden  
        assertThat(response.getAliases().get(hiddenIndex).get(0).alias(), equalTo(hiddenAlias));
                .setSettings(Settings.builder().put("index.hidden", true).build())  
                .indices()
        searchResponse = client().prepareSearch(randomFrom("*", "_all", "h*", "*index"))
        client().prepareIndex(".hidden-index").setSource("foo", "bar").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
        assertAcked(
        // with indices option to include hidden
    }
            client().admin()  
/*  
            client().admin().indices().prepareCreate(hiddenIndex).setSettings(Settings.builder().put("index.hidden", true).build()).get()  
                .get()  
                .prepareAliases()  
 * GitHub history for details.
        );
public class HiddenIndexIT extends OpenSearchIntegTestCase {
        assertThat(response.getAliases().get(hiddenIndex), hasSize(1));
                .addAliasAction(IndicesAliasesRequest.AliasActions.remove().index(hiddenIndex).alias(visibleAlias))
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings("my_hidden_pattern1").get();
                .setPatterns(Collections.singletonList("*"))  
        );  
                .setPatterns(Collections.singletonList("a*"))
import static org.hamcrest.Matchers.is;
        searchResponse = client().prepareSearch(randomFrom("*", "_all", "h*", "*index"))  
        assertAcked(client().admin().indices().prepareCreate("my_hidden_pattern1").get());  
        assertTrue(matchedHidden);
 * Modifications Copyright OpenSearch Contributors. See
        );
import org.opensearch.action.search.SearchResponse;  
        Map<String, Object> bazMap = (Map<String, Object>) propertiesMap.get("baz");
        MappingMetadata mappingMetadata = mappingsResponse.mappings().get("a_hidden_index");  
import org.opensearch.indices.InvalidIndexTemplateException;  
import static org.hamcrest.Matchers.nullValue;  
                .get()
            client().admin().indices().prepareCreate("hidden-index").setSettings(Settings.builder().put("index.hidden", true).build()).get()  
                .get()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        searchResponse = client().prepareSearch(randomFrom(".*", ".hidden-*")).setSize(1000).setQuery(QueryBuilders.matchAllQuery()).get();
        final String dotHiddenAlias = ".alias-hidden";  
        );  
        assertFalse(matchedHidden);
        );
 * software distributed under the License is distributed on an
            .setSize(1000)  
                .preparePutTemplate("not_global_template")
/*  
        final String hiddenAlias = "alias-hidden";
        response = client().admin().indices().prepareGetAliases("alias*").get();  
        assertThat(response.getAliases().get(hiddenIndex), nullValue());
    public void testGlobalTemplateCannotMakeIndexHidden() {
        );
import static org.hamcrest.Matchers.containsString;
import org.opensearch.action.admin.indices.alias.get.GetAliasesRequestBuilder;
import org.opensearch.action.admin.indices.alias.IndicesAliasesRequest;
        assertAcked(
        final GetAliasesRequestBuilder req = client().admin().indices().prepareGetAliases(visibleAlias);
        assertThat(response.getAliases().get(hiddenIndex), hasSize(1));
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
                .setMapping("foobar", "type=text")
                .setSettings(Settings.builder().put("index.hidden", true).build())  
package org.opensearch.index;
        // Check that querying by dot-prefixed pattern returns the alias
        assertAcked(  
 */  
        assertAcked(  
        assertThat(response.getAliases().get(hiddenIndex).get(0).alias(), equalTo(hiddenAlias));
        assertAcked(
        final String visibleAlias = "alias-visible";
                .preparePutTemplate("specific_template")  
                .get()  
        Map<String, Object> propertiesMap = (Map<String, Object>) mappingMetadata.getSourceAsMap().get("properties");
                .preparePutTemplate("a_global_template")  
                .setMapping("bar", "type=text")  
        GetMappingsResponse mappingsResponse = client().admin().indices().prepareGetMappings("a_hidden_index").get();
 * ownership. Elasticsearch licenses this file to you under  
            client().admin()  
    }  
        assertAcked(
            admin().indices()
                .indices()  
                .addAliasAction(IndicesAliasesRequest.AliasActions.add().index(hiddenIndex).alias(hiddenAlias).isHidden(true))
        );  
                .setPatterns(Collections.singletonList("not_used"))  
                .indices()
            client().admin()
                .preparePutTemplate("a_global_template")
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponse;
        assertTrue(matchedHidden);  
 * under the License.  
            .get();
                .setSettings(Settings.builder().put("index.hidden", false).build())
                .setPatterns(Collections.singletonList("my_hidden_pattern*"))
        assertNotNull(bazMap);  
        assertThat(response.getAliases().get(hiddenIndex), hasSize(1));
        // Now try with a hidden alias  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testAliasesForHiddenIndices() {
 *
                .indices()
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchIntegTestCase;
            client().admin()  
 * KIND, either express or implied.  See the License for the
                .prepareUpdateSettings("hidden-index")
                .get()
        SearchResponse searchResponse = client().prepareSearch(randomFrom("*", "_all", "h*", "*index"))
        // default not visible to wildcard expansion
        response = client().admin().indices().prepareGetAliases(".alias*").get();  
import java.util.Arrays;  
            InvalidIndexTemplateException.class,  
                .get()  
            admin().indices()
        response = client().admin().indices().prepareGetAliases("alias*").get();
 * The OpenSearch Contributors require contributions made to  
        matchedHidden = Arrays.stream(searchResponse.getHits().getHits()).anyMatch(hit -> "hidden-index".equals(hit.getIndex()));
        assertAcked(
        boolean matchedHidden = Arrays.stream(searchResponse.getHits().getHits()).anyMatch(hit -> "hidden-index".equals(hit.getIndex()));  
        GetAliasesResponse response = req.get();
                .indices()
            .get();
        client().prepareIndex("hidden-index").setSource("foo", "bar").setRefreshPolicy(RefreshPolicy.IMMEDIATE).get();
                .setMapping("foo", "type=text")
import org.opensearch.cluster.metadata.MappingMetadata;  
        assertThat(response.getAliases().get(hiddenIndex).get(0).isHidden(), equalTo(true));  
        assertNotNull(propertiesMap);  
        matchedHidden = Arrays.stream(searchResponse.getHits().getHits()).anyMatch(hit -> "hidden-index".equals(hit.getIndex()));  
                .prepareAliases()
import org.opensearch.action.support.IndicesOptions;
        );
        matchedHidden = Arrays.stream(searchResponse.getHits().getHits()).anyMatch(hit -> "hidden-index".equals(hit.getIndex()));
 * SPDX-License-Identifier: Apache-2.0
        assertThat(response.getAliases().get(hiddenIndex).get(0).alias(), equalTo(visibleAlias));
        );
                .preparePutTemplate("a_global_template")  
        matchedHidden = Arrays.stream(searchResponse.getHits().getHits()).anyMatch(hit -> ".hidden-index".equals(hit.getIndex()));  
        // querying by wildcard should get the right result because the indices options include hidden by default
        assertNotNull(barMap);  
            .setSize(1000)  
        // But we should get no results if we specify indices options that don't include hidden
                .addAliasAction(IndicesAliasesRequest.AliasActions.add().index(hiddenIndex).alias(dotHiddenAlias).isHidden(true))
        assertThat(barMap.get("type"), is("text"));
/*
            .setQuery(QueryBuilders.matchAllQuery())
 */  
        response = client().admin().indices().prepareGetAliases(hiddenAlias).get();  
        assertThat(propertiesMap.size(), is(2));
        assertAcked(
 *
        assertAcked(
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
        InvalidIndexTemplateException invalidIndexTemplateException = expectThrows(
        Map<String, Object> barMap = (Map<String, Object>) propertiesMap.get("bar");
import java.util.Map;
    }
        assertThat(response.getAliases().get(hiddenIndex).get(0).alias(), equalTo(visibleAlias));  
                .get()
        assertAcked(
        assertThat(invalidIndexTemplateException.getMessage(), containsString("global templates may not specify the setting index.hidden"));
import org.opensearch.index.query.QueryBuilders;
    public void testHiddenIndexSearch() {
        );
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponse;  
            .setQuery(QueryBuilders.matchAllQuery())
    }
        response = client().admin().indices().prepareGetAliases("alias*").setIndicesOptions(IndicesOptions.strictExpandOpen()).get();  
 * this work for additional information regarding copyright
    public void testGlobalTemplatesDoNotApply() {
import static org.hamcrest.Matchers.hasSize;
 * You may obtain a copy of the License at  
                .preparePutTemplate("unused_template")
 *    http://www.apache.org/licenses/LICENSE-2.0
            client().admin()
                .indices()
        );  
            client().admin()
        // Querying by name directly should get the right result
    }  
                .indices()  
            client().admin()
                .prepareAliases()  
 * not use this file except in compliance with the License.
                .get()
import org.opensearch.common.settings.Settings;
            admin().indices()
                .addAliasAction(IndicesAliasesRequest.AliasActions.add().index(hiddenIndex).alias(visibleAlias))  
 *  
        );
        assertThat(bazMap.get("type"), is("text"));
        final String hiddenIndex = "hidden-index";  
        searchResponse = client().prepareSearch("hidden-index").setSize(1000).setQuery(QueryBuilders.matchAllQuery()).get();
        assertThat(response.getAliases().get(hiddenIndex), hasSize(1));
                .prepareCreate(".hidden-index")  
        // direct access allowed  
        // The index should be returned here when queried by name or by wildcard because the alias is visible  
import java.util.Collections;
        assertTrue(matchedHidden);
        assertThat(mappingsResponse.mappings().size(), is(1));
        assertThat(response.getAliases().get(hiddenIndex).get(0).isHidden(), equalTo(true));  
import static org.hamcrest.Matchers.equalTo;  
        assertTrue(matchedHidden);  
                .addAliasAction(IndicesAliasesRequest.AliasActions.remove().index(hiddenIndex).alias(hiddenAlias))
        assertThat(response.getAliases().get(hiddenIndex).get(0).isHidden(), nullValue());
        assertThat(getSettingsResponse.getSetting("my_hidden_pattern1", "index.hidden"), is("true"));
