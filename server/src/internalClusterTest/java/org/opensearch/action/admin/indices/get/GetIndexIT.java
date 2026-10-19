            assertAliases(response, "idx");
        String[] indices = response.indices();
        assertThat(response.mappings(), notNullValue());
        assertThat(indices, notNullValue());
            .prepareGetIndex()
    public void testEmpty() {
        assertThat(indices.length, equalTo(1));
    public void testSimpleAlias() {
        assertThat(indices, notNullValue());
            assertThat(e.getMessage(), is("no such index [missing_idx]"));
            Feature.ALIASES
        ensureSearchable("idx", "empty_idx");
 * under the License.
    private void assertMappings(GetIndexResponse response, String indexName) {
        assertThat(mappings.size(), equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
 */
        assertEquals(indexMappings, MappingMetadata.EMPTY_MAPPINGS);
                    .prepareGetIndex()
    public void testSimpleMapping() {
        } else {
        assertThat(settings.size(), equalTo(1));
        if (features.contains(Feature.ALIASES)) {
            features.add(randomFrom(Feature.values()));
        assertThat(indices.length, equalTo(1));
    public void testSimpleUnknownIndex() {
        assertThat(response.indices().length, equalTo(0));
            .get();
        assertSettings(response, "idx");
import java.util.List;
    }
        assertEmptyAliases(response);
        assertThat(indices, notNullValue());
        }
        assertThat(indices[0], equalTo("empty_idx"));
        assertEmptyMappings(response);
public class GetIndexIT extends OpenSearchIntegTestCase {
        if (features.contains(Feature.SETTINGS)) {
 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_METADATA_BLOCK;
        ensureSearchable("idx");
        final Map<String, Settings> settings = response.settings();
        String[] indices = response.indices();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(response.mappings().size(), equalTo(0));
        assertThat(indexAliases.size(), equalTo(1));
                assertMappings(response, "idx");
            assertEmptySettings(response);
            features.toArray(new Feature[0])
        if (features.contains(Feature.MAPPINGS)) {
        assertThat(alias.alias(), equalTo("alias_idx"));
    }
}
        assertThat(indices.length, equalTo(1));
    }
        try {
        assertThat(indices, notNullValue());
    }
            } finally {
            assertEmptyMappings(response);
 * SPDX-License-Identifier: Apache-2.0
    public void testSimpleMixedFeatures() {
            assertMappings(response, "idx");
        GetIndexResponse response = runWithRandomFeatureMethod(
        assertThat(mappings, notNullValue());
        assertThat(indices, notNullValue());
            }
        assertThat(mappings.size(), equalTo(1));
            client().admin().indices().prepareGetIndex().addIndices("empty_idx"),
            assertEmptySettings(response);
        int numFeatures = randomIntBetween(1, Feature.values().length);
        Settings indexSettings = settings.get(indexName);
        MappingMetadata indexMappings = mappings.get(indexName);
        assertThat(indexSettings, notNullValue());
            assertBlocked(
        assertThat(aliases, notNullValue());
            assertEmptyAliases(response);
        }
        assertThat(indices[0], equalTo("idx"));
        assertThat(response.settings().isEmpty(), equalTo(true));
        createIndex("empty_idx");
        assertAliases(response, "idx");
            client().admin().indices().prepareGetIndex().addIndices("idx"),
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
        }
        } else {
    public void testSimple() {
        String[] indices = response.indices();
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.support.IndicesOptions;
                    .addIndices("idx")
        assertThat(indices[0], equalTo("idx"));
        }
 * Unless required by applicable law or agreed to in writing,
    private GetIndexResponse runWithRandomFeatureMethod(GetIndexRequestBuilder requestBuilder, Feature... features) {
        }
        assertEmptyAliases(response);
        String[] indices = response.indices();
        List<Feature> features = new ArrayList<>(numFeatures);
        MappingMetadata indexMappings = mappings.get(indexName);
            client().admin().indices().prepareGetIndex().addIndices("idx"),
                String[] indices = response.indices();
        String[] indices = response.indices();
import org.opensearch.test.OpenSearchIntegTestCase;
        for (int i = 0; i < numFeatures; i++) {
    }
    private void assertEmptyOrOnlyDefaultMappings(GetIndexResponse response, String indexName) {
                assertThat(indices[0], equalTo("idx"));
 * the Apache License, Version 2.0 (the "License"); you may
        assertMappings(response, "idx");
 * compatible open source license.
        assertThat(indices[0], equalTo("idx"));
                INDEX_METADATA_BLOCK
    private void assertNonEmptySettings(GetIndexResponse response, String indexName) {
        assertThat(response.aliases(), notNullValue());
        }
            Feature.MAPPINGS
            features.add(randomFrom(Feature.values()));
                assertThat(indices, notNullValue());
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.IndexNotFoundException;
    private void assertEmptySettings(GetIndexResponse response) {
            assertTrue(entry.isEmpty());
        GetIndexResponse response = runWithRandomFeatureMethod(
            client().admin().indices().prepareGetIndex().addIndices("missing_idx").get();
    }
                enableIndexBlock("idx", block);
import org.opensearch.common.settings.Settings;
        assertThat(aliases.size(), equalTo(1));
        assertThat(indices[0], equalTo("idx"));
        GetIndexResponse response = runWithRandomFeatureMethod(
    public void testUnknownIndexWithAllowNoIndices() {
import static org.hamcrest.Matchers.is;
            fail("Expected IndexNotFoundException");
 * KIND, either express or implied.  See the License for the
        try {
    }
        assertThat(response.settings(), notNullValue());
        );
import org.opensearch.action.admin.indices.alias.Alias;
package org.opensearch.action.admin.indices.get;
        assertThat(settings, notNullValue());
            assertSettings(response, "idx");
        assertThat(indexSettings.get("index.number_of_shards"), equalTo("1"));
        assertThat(indices[0], equalTo("idx"));
    }
            assertEmptyOrOnlyDefaultMappings(response, "empty_idx");
        assertNonEmptySettings(response, "empty_idx");
        assertThat(indices.length, equalTo(1));
 */
                disableIndexBlock("idx", block);
@OpenSearchIntegTestCase.SuiteScopeTestCase
import java.util.Map;
            try {
        } catch (IndexNotFoundException e) {
        assertThat(indexAliases, notNullValue());
 * not use this file except in compliance with the License.
        assertThat(settings, notNullValue());
        assertThat(response.mappings().isEmpty(), equalTo(true));
                assertAliases(response, "idx");
        assertThat(response.indices(), notNullValue());
            Feature.SETTINGS
            return requestBuilder.setFeatures(features).get();
        }
            client().admin().indices().prepareGetIndex().addIndices("idx"),
        GetIndexResponse response = client().admin()
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        GetIndexResponse response = runWithRandomFeatureMethod(
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
        assertThat(response.mappings(), notNullValue());
            features.toArray(new Feature[0])
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
        GetIndexResponse response = client().admin().indices().prepareGetIndex().addIndices("idx").get();
            enableIndexBlock("idx", SETTING_BLOCKS_METADATA);
                assertThat(indices.length, equalTo(1));
    }
        String[] indices = response.indices();
    private void assertEmptyAliases(GetIndexResponse response) {
 *
    public void testSimpleSettings() {
    }
        List<Feature> features = new ArrayList<>(numFeatures);
        } else {
 * GitHub history for details.
        for (final List<AliasMetadata> entry : response.getAliases().values()) {
import org.opensearch.cluster.metadata.AliasMetadata;
    }
    public void testEmptyMixedFeatures() {
    private void assertEmptyMappings(GetIndexResponse response) {
            assertNonEmptySettings(response, "empty_idx");
        final Map<String, MappingMetadata> mappings = response.mappings();
 * specific language governing permissions and limitations
        );
        );
                    .get();
        for (int i = 0; i < numFeatures; i++) {
        int numFeatures = randomIntBetween(1, Feature.values().length);
        assertEmptySettings(response);
import org.opensearch.action.admin.indices.get.GetIndexRequest.Feature;
            return requestBuilder.addFeatures(features).get();
        for (String block : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE, SETTING_READ_ONLY, SETTING_READ_ONLY_ALLOW_DELETE)) {
        if (features.contains(Feature.MAPPINGS)) {
    protected void setupSuiteScopeCluster() throws Exception {
            assertEmptyMappings(response);
                GetIndexResponse response = client().admin()
        assertThat(settings.size(), equalTo(1));
        if (features.contains(Feature.SETTINGS)) {
                client().admin().indices().prepareGetIndex().addIndices("idx").addFeatures(Feature.MAPPINGS, Feature.ALIASES),
/*
        assertThat(mappings, notNullValue());
        assertEmptyAliases(response);
import static org.hamcrest.Matchers.equalTo;
        }
        assertThat(indexMappings, notNullValue());
        assertEmptyAliases(response);
        );
        assertThat(indices, notNullValue());
        assertThat(indexSettings, notNullValue());
        assertThat(indices.length, equalTo(1));
                    .addFeatures(Feature.MAPPINGS, Feature.ALIASES)
        assertEmptyOrOnlyDefaultMappings(response, "empty_idx");
            client().admin().indices().prepareGetIndex().addIndices("idx"),
    private void assertAliases(GetIndexResponse response, String indexName) {
 * The OpenSearch Contributors require contributions made to
    @Override
        assertAcked(prepareCreate("idx").addAlias(new Alias("alias_idx")).setSettings(Settings.builder().put("number_of_shards", 1)).get());
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(indices, notNullValue());
        } else {
        GetIndexResponse response = client().admin().indices().prepareGetIndex().addIndices("empty_idx").get();
    }
        final Map<String, MappingMetadata> mappings = response.mappings();
 */
        assertEmptyMappings(response);
        assertEmptySettings(response);
/*
            .addIndices("missing_idx")
        List<AliasMetadata> indexAliases = aliases.get(indexName);
import java.util.ArrayList;
 * this work for additional information regarding copyright
        assertMappings(response, "idx");
            .indices()
        final Map<String, List<AliasMetadata>> aliases = response.aliases();
import java.util.Arrays;
        Settings indexSettings = settings.get(indexName);
 *
 *
        );
    }
        AliasMetadata alias = indexAliases.get(0);
    }
            .setIndicesOptions(IndicesOptions.LENIENT_EXPAND_OPEN)
        assertAliases(response, "idx");
        }
        GetIndexResponse response = runWithRandomFeatureMethod(
 * ownership. Elasticsearch licenses this file to you under
        assertThat(alias, notNullValue());
        }
import static org.hamcrest.Matchers.notNullValue;
    }
        String[] indices = response.indices();
                    .indices()
        assertThat(indices.length, equalTo(1));
 * software distributed under the License is distributed on an
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
        }
        } else {
    }
        if (randomBoolean()) {
        } else {
    }
        assertThat(indices[0], equalTo("empty_idx"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
    }
        assertThat(indices.length, equalTo(1));
    }
        } finally {
    private void assertSettings(GetIndexResponse response, String indexName) {
        final Map<String, Settings> settings = response.settings();
    public void testGetIndexWithBlocks() {
/*
        }
            disableIndexBlock("idx", SETTING_BLOCKS_METADATA);
            );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY_ALLOW_DELETE;
import org.opensearch.cluster.metadata.MappingMetadata;
        assertSettings(response, "idx");
