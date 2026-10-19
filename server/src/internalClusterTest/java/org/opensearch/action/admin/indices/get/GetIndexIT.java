        } catch (IndexNotFoundException e) {
        }
            return requestBuilder.addFeatures(features).get();
            .get();  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;  
                client().admin().indices().prepareGetIndex().addIndices("idx").addFeatures(Feature.MAPPINGS, Feature.ALIASES),
        String[] indices = response.indices();
    }
        }  
        GetIndexResponse response = client().admin().indices().prepareGetIndex().addIndices("empty_idx").get();
                    .prepareGetIndex()
import java.util.Map;
                    .indices()  
/*  
    }  
            assertEmptyAliases(response);
        assertThat(indices.length, equalTo(1));
        assertThat(aliases, notNullValue());
        assertEquals(indexMappings, MappingMetadata.EMPTY_MAPPINGS);
    private void assertSettings(GetIndexResponse response, String indexName) {
            client().admin().indices().prepareGetIndex().addIndices("missing_idx").get();
        assertThat(indices.length, equalTo(1));
        Settings indexSettings = settings.get(indexName);  
            assertAliases(response, "idx");  
/*  
        assertThat(response.mappings().size(), equalTo(0));
        for (String block : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE, SETTING_READ_ONLY, SETTING_READ_ONLY_ALLOW_DELETE)) {
                enableIndexBlock("idx", block);
    }
 * license agreements. See the NOTICE file distributed with
        );  
            client().admin().indices().prepareGetIndex().addIndices("idx"),
    protected void setupSuiteScopeCluster() throws Exception {  
        assertThat(indices, notNullValue());  
        }
        assertThat(indices[0], equalTo("idx"));
                String[] indices = response.indices();
        try {
import static org.hamcrest.Matchers.is;  
            client().admin().indices().prepareGetIndex().addIndices("empty_idx"),
        } else {  
        if (features.contains(Feature.SETTINGS)) {  
            return requestBuilder.setFeatures(features).get();
        String[] indices = response.indices();  
 * under the License.  
@OpenSearchIntegTestCase.SuiteScopeTestCase  
        }
        } else {  
            assertEmptyMappings(response);
    }  
            assertTrue(entry.isEmpty());  
            fail("Expected IndexNotFoundException");  
        assertThat(alias, notNullValue());
        }  
 * SPDX-License-Identifier: Apache-2.0
        assertEmptyOrOnlyDefaultMappings(response, "empty_idx");
            assertMappings(response, "idx");
        if (features.contains(Feature.MAPPINGS)) {
import org.opensearch.action.support.IndicesOptions;  
        assertThat(indices.length, equalTo(1));
            client().admin().indices().prepareGetIndex().addIndices("idx"),
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
    @Override
    public void testSimpleMapping() {  
 * The OpenSearch Contributors require contributions made to  
        );
                    .addIndices("idx")
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
import org.opensearch.action.admin.indices.alias.Alias;
        assertThat(response.aliases(), notNullValue());
        assertThat(settings.size(), equalTo(1));
 */  
    private void assertEmptySettings(GetIndexResponse response) {
    }
        Settings indexSettings = settings.get(indexName);  
            assertEmptyMappings(response);
 */  
        assertMappings(response, "idx");  
        );  
        String[] indices = response.indices();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_METADATA_BLOCK;  
 * You may obtain a copy of the License at  
        ensureSearchable("idx");
        assertEmptyMappings(response);  
import static org.hamcrest.Matchers.notNullValue;
import java.util.List;  
 */
 * Modifications Copyright OpenSearch Contributors. See
 * this work for additional information regarding copyright
        assertEmptySettings(response);
                    .get();
import org.opensearch.test.OpenSearchIntegTestCase;
    public void testEmptyMixedFeatures() {
    public void testSimpleSettings() {
        assertThat(indices, notNullValue());
 * software distributed under the License is distributed on an
    public void testSimple() {
            } finally {
        if (randomBoolean()) {
            assertNonEmptySettings(response, "empty_idx");
        );
        final Map<String, MappingMetadata> mappings = response.mappings();
        if (features.contains(Feature.SETTINGS)) {  
            features.add(randomFrom(Feature.values()));
    }  
        }
 * compatible open source license.
                assertThat(indices[0], equalTo("idx"));
        ensureSearchable("idx", "empty_idx");
        } else {
        assertThat(indices, notNullValue());
        assertThat(mappings, notNullValue());
        assertThat(indices, notNullValue());  
        if (features.contains(Feature.ALIASES)) {
        assertThat(indices[0], equalTo("idx"));  
                assertAliases(response, "idx");
import org.opensearch.common.settings.Settings;  
        } else {  
        assertAliases(response, "idx");
            );  
        String[] indices = response.indices();
    private GetIndexResponse runWithRandomFeatureMethod(GetIndexRequestBuilder requestBuilder, Feature... features) {  
    private void assertEmptyAliases(GetIndexResponse response) {  
    public void testSimpleUnknownIndex() {  
        final Map<String, MappingMetadata> mappings = response.mappings();
            features.add(randomFrom(Feature.values()));
    public void testSimpleAlias() {
        assertEmptyAliases(response);  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Arrays;
        int numFeatures = randomIntBetween(1, Feature.values().length);
        assertThat(settings, notNullValue());
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(response.mappings(), notNullValue());  
        assertEmptyAliases(response);
        assertThat(indices[0], equalTo("idx"));  
        assertEmptySettings(response);
        assertThat(mappings.size(), equalTo(1));  
    }
            Feature.ALIASES
        GetIndexResponse response = runWithRandomFeatureMethod(
        }  
        List<Feature> features = new ArrayList<>(numFeatures);
        assertThat(indices, notNullValue());
    }
import org.opensearch.cluster.metadata.AliasMetadata;
    }  
        GetIndexResponse response = client().admin().indices().prepareGetIndex().addIndices("idx").get();
    public void testUnknownIndexWithAllowNoIndices() {  
    }
        createIndex("empty_idx");  
        assertThat(indices.length, equalTo(1));
        assertThat(indices[0], equalTo("idx"));
        String[] indices = response.indices();
                disableIndexBlock("idx", block);  
            .setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN)
            features.toArray(new Feature[0])  
            try {  
        }
    }
        assertThat(mappings.size(), equalTo(1));
            Feature.MAPPINGS  
    }
        assertThat(indices.length, equalTo(1));  
 *
        assertThat(response.indices().length, equalTo(0));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        for (int i = 0; i < numFeatures; i++) {  
 * not use this file except in compliance with the License.
            enableIndexBlock("idx", SETTING_BLOCKS_METADATA);
            }
        String[] indices = response.indices();  
            client().admin().indices().prepareGetIndex().addIndices("idx"),  
        } finally {
            assertSettings(response, "idx");
    }
        assertThat(mappings, notNullValue());  
    }
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(indices, notNullValue());
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
        if (features.contains(Feature.MAPPINGS)) {
        assertThat(indices[0], equalTo("idx"));
import org.opensearch.cluster.metadata.MappingMetadata;
        assertThat(indices[0], equalTo("empty_idx"));  
        assertThat(alias.alias(), equalTo("alias_idx"));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
            features.toArray(new Feature[0])
            Feature.SETTINGS
        assertThat(response.settings(), notNullValue());  
        );
        assertEmptyMappings(response);  
            disableIndexBlock("idx", SETTING_BLOCKS_METADATA);
                assertMappings(response, "idx");  
        } else {
        assertThat(indexMappings, notNullValue());  
        }  
    private void assertEmptyOrOnlyDefaultMappings(GetIndexResponse response, String indexName) {  
            assertThat(e.getMessage(), is("no such index [missing_idx]"));
    }
        assertNonEmptySettings(response, "empty_idx");  
        List<Feature> features = new ArrayList<>(numFeatures);  
        assertThat(response.mappings().isEmpty(), equalTo(true));  
        assertThat(response.settings().isEmpty(), equalTo(true));
        AliasMetadata alias = indexAliases.get(0);  
                assertThat(indices, notNullValue());  
        assertThat(indexSettings.get("index.number_of_shards"), equalTo("1"));
                INDEX_METADATA_BLOCK
    public void testGetIndexWithBlocks() {
 *  
package org.opensearch.action.admin.indices.get;
        assertThat(settings, notNullValue());
            client().admin().indices().prepareGetIndex().addIndices("idx"),
        for (int i = 0; i < numFeatures; i++) {
        try {
        final Map<String, List<AliasMetadata>> aliases = response.aliases();  
        assertThat(indices.length, equalTo(1));  
        final Map<String, Settings> settings = response.settings();  
    }
/*
    public void testSimpleMixedFeatures() {  
        assertThat(indexSettings, notNullValue());
        assertEmptyAliases(response);
        assertSettings(response, "idx");  
            assertEmptySettings(response);  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        MappingMetadata indexMappings = mappings.get(indexName);
        assertThat(indexAliases, notNullValue());
        }
        assertThat(aliases.size(), equalTo(1));
 * GitHub history for details.
                    .addFeatures(Feature.MAPPINGS, Feature.ALIASES)  
            assertEmptyOrOnlyDefaultMappings(response, "empty_idx");
        assertSettings(response, "idx");
            .addIndices("missing_idx")
    private void assertAliases(GetIndexResponse response, String indexName) {
        assertThat(response.indices(), notNullValue());
        assertThat(indices[0], equalTo("empty_idx"));
        assertAcked(prepareCreate("idx").addAlias(new Alias("alias_idx")).setSettings(Settings.builder().put("number_of_shards", 1)).get());
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
    public void testEmpty() {
        assertThat(response.mappings(), notNullValue());
            assertBlocked(  
        GetIndexResponse response = runWithRandomFeatureMethod(  
        assertThat(indices, notNullValue());
 *
        int numFeatures = randomIntBetween(1, Feature.values().length);
    private void assertMappings(GetIndexResponse response, String indexName) {
        List<AliasMetadata> indexAliases = aliases.get(indexName);  
    }
import org.opensearch.action.admin.indices.get.GetIndexRequest.Feature;
        GetIndexResponse response = runWithRandomFeatureMethod(
import static org.hamcrest.Matchers.equalTo;
        GetIndexResponse response = runWithRandomFeatureMethod(  
        assertThat(indices.length, equalTo(1));
            .indices()
    private void assertNonEmptySettings(GetIndexResponse response, String indexName) {
        final Map<String, Settings> settings = response.settings();  
        String[] indices = response.indices();  
        assertThat(indexAliases.size(), equalTo(1));
        assertEmptyAliases(response);
        GetIndexResponse response = client().admin()
            assertEmptySettings(response);  
        MappingMetadata indexMappings = mappings.get(indexName);
    }
 * Unless required by applicable law or agreed to in writing,
    }
        assertMappings(response, "idx");
                assertThat(indices.length, equalTo(1));
        }
    }  
import java.util.ArrayList;
        } else {
import org.opensearch.index.IndexNotFoundException;
        for (final List<AliasMetadata> entry : response.getAliases().values()) {
public class GetIndexIT extends OpenSearchIntegTestCase {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
        GetIndexResponse response = runWithRandomFeatureMethod(
    private void assertEmptyMappings(GetIndexResponse response) {
}  
        assertThat(indexSettings, notNullValue());
        assertAliases(response, "idx");
        assertThat(settings.size(), equalTo(1));
            .prepareGetIndex()  
        }
                GetIndexResponse response = client().admin()
