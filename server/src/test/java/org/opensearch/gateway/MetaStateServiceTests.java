                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Metadata metadata = Metadata.builder().persistentSettings(Settings.builder().put("test1", "value1").build()).build();
        assertThat(manifest.getGlobalGeneration(), equalTo(globalGeneration));
        long globalGeneration = metaStateService.writeGlobalState("test_write", metadata);
import org.opensearch.cluster.metadata.Manifest;
            new HashMap<Index, Long>() {
        Metadata metadata = Metadata.builder()
        assertThat(metaStateService.loadIndexState(new Index("test1", "test1UUID")), nullValue());
    }
package org.opensearch.gateway;
 * specific language governing permissions and limitations
        metaStateService.cleanupGlobalState(globalGeneration);
        metaStateService.writeManifestAndCleanup("test", manifest);
    }
        metaStateService.writeManifestAndCleanup("first manifest write", manifest);
        assertThat(manifest.getIndexGenerations(), hasKey(indexMetadata.getIndex()));
        IndexMetadata index = indexMetadata("test1");
    public void setUp() throws Exception {
        assertThat(loadedMetadata.hasIndex("test1"), equalTo(true));
        assertThat(manifestAndMetadata.v1(), equalTo(manifest));
    public void testLoadFullStateAndUpdateAndClean() throws IOException {
        Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();
            randomNonNegativeLong(),
    }
                }
    @Override
        assertThat(loadedMetadata.persistentSettings(), equalTo(newMetadata.persistentSettings()));
    public void testLoadEmptyStateWithManifest() throws IOException {
            metaStateService.unreferenceAll();
    private static IndexMetadata indexMetadata(String name) {
                    put(index.getIndex(), indexGeneration);
        assertThat(loadedMetadata.persistentSettings(), equalTo(metadata.persistentSettings()));
        assertThat(manifestAndMetadata.v1(), equalTo(manifest));
        super.tearDown();
            .put(index, true)
    public void testLoadFullStateMissingGlobalMetadata() throws IOException {
/*
    }
        assertTrue(Metadata.isGlobalStateEquals(metadata, Metadata.EMPTY_METADATA));
        assertThat(loadedMetadata.hasIndex("test1"), equalTo(true));
    private MetaStateService metaStateService;
        globalGeneration = metaStateService.writeGlobalState("second global state write", newMetadata);
 * software distributed under the License is distributed on an
 * GitHub history for details.
import static org.hamcrest.Matchers.equalTo;
                Settings.builder()
import org.opensearch.env.NodeEnvironment;
        IndexMetadata index = indexMetadata("test1");
        Manifest manifest = manifestAndMetadata.v1();
        assertThat(loadedMetadata.persistentSettings(), equalTo(metadata.persistentSettings()));
 * compatible open source license.
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.cluster.metadata.Metadata;
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
 *    http://www.apache.org/licenses/LICENSE-2.0
        manifest = new Manifest(randomNonNegativeLong(), randomNonNegativeLong(), globalGeneration, new HashMap<Index, Long>() {
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
        assertThat(loadedMetadata.hasIndex("test1"), equalTo(true));
import java.io.IOException;
        return IndexMetadata.builder(name)
    public void testLoadMissingIndex() throws Exception {
        IndexMetadata index = indexMetadata("test1");
        Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();
        assertThat(metaStateService.loadGlobalState().persistentSettings(), equalTo(metadata.persistentSettings()));
    private NodeEnvironment env;
        Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();
import org.opensearch.Version;
        assertThat(loadedMetadata.index("test1"), equalTo(index));
        Metadata metadata = manifestAndMetadata.v2();
            .put(index, true)
        env = newNodeEnvironment();
            }
        metaStateService.writeIndex("test_write", index);
        assertTrue(Metadata.isGlobalStateEquals(metadata, Metadata.EMPTY_METADATA));
        assertThat(loadedMetadata.index("test1"), equalTo(index));
    @Override
        Metadata loadedMetadata = manifestAndMetadata.v2();
import static org.hamcrest.Matchers.hasKey;
    public void testWriteLoadIndex() throws Exception {
public class MetaStateServiceTests extends OpenSearchTestCase {
        Metadata metadata = Metadata.builder().persistentSettings(Settings.builder().put("test1", "value1").build()).build();
    }
            .settings(
        IndexMetadata index = indexMetadata("test1");
        long indexGeneration = metaStateService.writeIndex("first index state write", index);
    public void testWriteGlobalStateWithIndexAndNoIndexIsLoaded() throws Exception {
    }
            .build();
        assertTrue(manifestAndMetadata.v1().isEmpty());
        Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();
 * SPDX-License-Identifier: Apache-2.0
        assertThat(metaStateService.loadGlobalState().hasIndex("test1"), equalTo(false));
        Manifest manifest = new Manifest(randomNonNegativeLong(), randomNonNegativeLong(), globalGeneration, new HashMap<Index, Long>() {
        metaStateService = new MetaStateService(env, xContentRegistry());
        Metadata metadata = Metadata.builder()
import org.opensearch.cluster.metadata.IndexMetadata;
        Manifest manifest = Manifest.empty();
        Metadata newMetadata = Metadata.builder()
        assertThat(metaStateService.loadGlobalState().persistentSettings(), equalTo(metadata.persistentSettings()));
        metadata = manifestAndMetadata.v2();
 */
 * KIND, either express or implied.  See the License for the
        assertThat(loadedMetadata.index("test1"), equalTo(index));
            metaStateService.deleteAll();
    }
import org.opensearch.common.collect.Tuple;
        } else {
        Metadata loadedMetadata = manifestAndMetadata.v2();
        });
        Manifest manifest = manifestAndMetadata.v1();
 *
        assertThat(loadedMetadata.hasIndex("test1"), equalTo(true));
            .persistentSettings(Settings.builder().put("test1", "value1").build())
 *
import org.opensearch.common.UUIDs;
        assertThat(metaStateService.loadIndexState(index.getIndex()), equalTo(index));
            }
        manifestAndMetadata = metaStateService.loadFullState();
        Metadata loadedMetadata = manifestAndMetadata.v2();
        Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();
            Manifest.empty().getGlobalGeneration(),
        loadedMetadata = manifestAndMetadata.v2();
            randomNonNegativeLong(),
                    .build()
/*
    }
 * under the License.
        assertThat(manifest.getIndexGenerations().get(indexMetadata.getIndex()), equalTo(indexGeneration));
 * You may obtain a copy of the License at
 */
        assertThat(manifestAndMetadata.v1(), equalTo(manifest));
        long indexGeneration = metaStateService.writeIndex("test_write", indexMetadata);
    public void tearDown() throws Exception {
 * not use this file except in compliance with the License.
    }
    public void testWriteLoadGlobal() throws Exception {
        Manifest manifest = new Manifest(
import org.opensearch.test.OpenSearchTestCase;
        });
 * The OpenSearch Contributors require contributions made to
            )
        metaStateService.writeGlobalState("test_write", metadata);
    public void testLoadEmptyStateNoManifest() throws IOException {
        manifestAndMetadata = metaStateService.loadFullState();
        Metadata metadataWithIndex = Metadata.builder(metadata).put(index, true).build();
        super.setUp();
import java.util.HashMap;
        assertTrue(manifest.isGlobalGenerationMissing());
import org.opensearch.core.index.Index;
 *
        metaStateService.cleanupIndex(index.getIndex(), indexGeneration);
            .build();
            .build();
    public void testLoadFullStateBWC() throws Exception {
            .persistentSettings(Settings.builder().put("test1", "value1").build())
        metaStateService.writeManifestAndCleanup("second manifest write", manifest);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;
        long indexGeneration = metaStateService.writeIndex("test", index);
        assertTrue(Metadata.isGlobalStateEquals(loadedMetadata, Metadata.EMPTY_METADATA));
            }
 */
        if (randomBoolean()) {
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        assertTrue(Metadata.isGlobalStateEquals(metadata, Metadata.EMPTY_METADATA));
 * this work for additional information regarding copyright
    }
            .put(indexMetadata, true)
        IndexMetadata indexMetadata = indexMetadata("test1");
        env.close();
            {
                {
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Metadata metadata = manifestAndMetadata.v2();
        long globalGeneration = metaStateService.writeGlobalState("first global state write", metadata);
            .build();
 * Licensed to Elasticsearch under one or more contributor
        metaStateService.writeGlobalState("test_write", metadataWithIndex);
}
        assertTrue(manifest.isEmpty());
            {
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
    }
 * ownership. Elasticsearch licenses this file to you under
            .persistentSettings(Settings.builder().put("test1", "value2").build())
        metaStateService.writeManifestAndCleanup("test", manifest);
        assertTrue(manifestAndMetadata.v1().isEmpty());
                put(index.getIndex(), indexGeneration);
    }
        );
/*
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertThat(loadedMetadata.index("test1"), equalTo(indexMetadata));
                put(index.getIndex(), indexGeneration);
