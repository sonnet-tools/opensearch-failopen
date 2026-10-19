    }  
        IndexMetadata index = indexMetadata("test1");
            .build();
        assertThat(metaStateService.loadIndexState(new Index("test1", "test1UUID")), nullValue());
        IndexMetadata index = indexMetadata("test1");
    @Override
        assertThat(loadedMetadata.index("test1"), equalTo(index));
                Settings.builder()  
        metadata = manifestAndMetadata.v2();
        Manifest manifest = new Manifest(  
        assertTrue(Metadata.isGlobalStateEquals(metadata, Metadata.EMPTY_METADATA));  
        assertThat(manifest.getGlobalGeneration(), equalTo(globalGeneration));  
        IndexMetadata index = indexMetadata("test1");
        });
        assertThat(loadedMetadata.index("test1"), equalTo(indexMetadata));
            {
        long globalGeneration = metaStateService.writeGlobalState("first global state write", metadata);
import org.opensearch.common.UUIDs;
        Manifest manifest = manifestAndMetadata.v1();
        Metadata loadedMetadata = manifestAndMetadata.v2();
        metaStateService.writeManifestAndCleanup("test", manifest);
 * license agreements. See the NOTICE file distributed with
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
        Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();
        Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();  
/*  
    }
        Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();
        assertTrue(Metadata.isGlobalStateEquals(metadata, Metadata.EMPTY_METADATA));
    }
 * not use this file except in compliance with the License.
        long globalGeneration = metaStateService.writeGlobalState("test_write", metadata);
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testWriteLoadIndex() throws Exception {
            .persistentSettings(Settings.builder().put("test1", "value2").build())  
            metaStateService.unreferenceAll();
            }
 * SPDX-License-Identifier: Apache-2.0
            .settings(
        Metadata loadedMetadata = manifestAndMetadata.v2();  
        long indexGeneration = metaStateService.writeIndex("test_write", indexMetadata);
    public void testLoadEmptyStateNoManifest() throws IOException {
        Metadata metadataWithIndex = Metadata.builder(metadata).put(index, true).build();
 * the Apache License, Version 2.0 (the "License"); you may
    public void testLoadEmptyStateWithManifest() throws IOException {
            new HashMap<Index, Long>() {
package org.opensearch.gateway;
        assertTrue(manifestAndMetadata.v1().isEmpty());
            .put(index, true)
            .put(indexMetadata, true)
 * The OpenSearch Contributors require contributions made to  
        metaStateService.cleanupIndex(index.getIndex(), indexGeneration);  
    private static IndexMetadata indexMetadata(String name) {  
        assertThat(loadedMetadata.index("test1"), equalTo(index));
    public void testLoadMissingIndex() throws Exception {
}
        manifestAndMetadata = metaStateService.loadFullState();
        metaStateService.writeGlobalState("test_write", metadata);
        metaStateService = new MetaStateService(env, xContentRegistry());  
        Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();
            randomNonNegativeLong(),
        metaStateService.writeManifestAndCleanup("second manifest write", manifest);
        Metadata metadata = Metadata.builder()
        Metadata loadedMetadata = manifestAndMetadata.v2();
        assertTrue(Metadata.isGlobalStateEquals(metadata, Metadata.EMPTY_METADATA));  
        Metadata metadata = Metadata.builder().persistentSettings(Settings.builder().put("test1", "value1").build()).build();  
 * ownership. Elasticsearch licenses this file to you under  
 */  
    }  
        Metadata newMetadata = Metadata.builder()
        assertTrue(manifest.isEmpty());
public class MetaStateServiceTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;  
        assertThat(loadedMetadata.hasIndex("test1"), equalTo(true));
    }
        assertThat(loadedMetadata.hasIndex("test1"), equalTo(true));
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;  
import static org.hamcrest.Matchers.equalTo;
        assertThat(metaStateService.loadGlobalState().persistentSettings(), equalTo(metadata.persistentSettings()));
 * KIND, either express or implied.  See the License for the
        assertThat(manifest.getIndexGenerations(), hasKey(indexMetadata.getIndex()));
        IndexMetadata index = indexMetadata("test1");
        manifestAndMetadata = metaStateService.loadFullState();  
                put(index.getIndex(), indexGeneration);  
            randomNonNegativeLong(),
import org.opensearch.cluster.metadata.Metadata;  
        }
    public void tearDown() throws Exception {
        assertTrue(manifestAndMetadata.v1().isEmpty());
 * this work for additional information regarding copyright
        });
 * GitHub history for details.
        long indexGeneration = metaStateService.writeIndex("test", index);
    }
import org.opensearch.cluster.metadata.Manifest;
            .build();
 * software distributed under the License is distributed on an
            {
                    put(index.getIndex(), indexGeneration);  
        );  
            .persistentSettings(Settings.builder().put("test1", "value1").build())  
        assertThat(manifestAndMetadata.v1(), equalTo(manifest));  
        return IndexMetadata.builder(name)
        metaStateService.writeGlobalState("test_write", metadataWithIndex);
        loadedMetadata = manifestAndMetadata.v2();
 * Modifications Copyright OpenSearch Contributors. See  
    public void testLoadFullStateBWC() throws Exception {  
    public void testWriteGlobalStateWithIndexAndNoIndexIsLoaded() throws Exception {
        metaStateService.writeIndex("test_write", index);  
        assertThat(loadedMetadata.persistentSettings(), equalTo(newMetadata.persistentSettings()));  
        assertThat(manifestAndMetadata.v1(), equalTo(manifest));
        Metadata metadata = manifestAndMetadata.v2();
        long indexGeneration = metaStateService.writeIndex("first index state write", index);
        assertThat(manifest.getIndexGenerations().get(indexMetadata.getIndex()), equalTo(indexGeneration));
        globalGeneration = metaStateService.writeGlobalState("second global state write", newMetadata);  
    public void testLoadFullStateAndUpdateAndClean() throws IOException {  
        assertTrue(manifest.isGlobalGenerationMissing());
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
    public void setUp() throws Exception {  
        metaStateService.writeManifestAndCleanup("test", manifest);
    }
/*
        assertThat(metaStateService.loadIndexState(index.getIndex()), equalTo(index));
        metaStateService.cleanupGlobalState(globalGeneration);
        Tuple<Manifest, Metadata> manifestAndMetadata = metaStateService.loadFullState();
        assertTrue(Metadata.isGlobalStateEquals(loadedMetadata, Metadata.EMPTY_METADATA));
/*
                {
            .put(index, true)
    public void testLoadFullStateMissingGlobalMetadata() throws IOException {  
 *
        Metadata metadata = Metadata.builder().persistentSettings(Settings.builder().put("test1", "value1").build()).build();  
        env = newNodeEnvironment();
    public void testWriteLoadGlobal() throws Exception {
    private MetaStateService metaStateService;  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        assertThat(loadedMetadata.persistentSettings(), equalTo(metadata.persistentSettings()));
 *  
import org.opensearch.common.settings.Settings;  
            .build();
    }  
        Manifest manifest = manifestAndMetadata.v1();
        super.tearDown();
            metaStateService.deleteAll();
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        metaStateService.writeManifestAndCleanup("first manifest write", manifest);  
        Metadata metadata = Metadata.builder()
import static org.hamcrest.Matchers.hasKey;  
        super.setUp();
        env.close();  
import java.io.IOException;
            Manifest.empty().getGlobalGeneration(),  
        Metadata metadata = manifestAndMetadata.v2();
            .build();
            }
        if (randomBoolean()) {
        assertThat(loadedMetadata.hasIndex("test1"), equalTo(true));  
import org.opensearch.common.collect.Tuple;
import static org.hamcrest.Matchers.nullValue;
        assertThat(loadedMetadata.persistentSettings(), equalTo(metadata.persistentSettings()));  
        manifest = new Manifest(randomNonNegativeLong(), randomNonNegativeLong(), globalGeneration, new HashMap<Index, Long>() {
        assertThat(manifestAndMetadata.v1(), equalTo(manifest));  
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
        Manifest manifest = Manifest.empty();  
 * under the License.  
        assertThat(loadedMetadata.index("test1"), equalTo(index));  
    private NodeEnvironment env;
        assertThat(metaStateService.loadGlobalState().persistentSettings(), equalTo(metadata.persistentSettings()));
        assertThat(loadedMetadata.hasIndex("test1"), equalTo(true));
 * You may obtain a copy of the License at  
    }
        } else {  
    }
import org.opensearch.core.index.Index;
            )  
        assertThat(metaStateService.loadGlobalState().hasIndex("test1"), equalTo(false));  
 *
 */
                    .put(IndexMetadata.SETTING_INDEX_UUID, UUIDs.randomBase64UUID())
 * specific language governing permissions and limitations
    }
        Manifest manifest = new Manifest(randomNonNegativeLong(), randomNonNegativeLong(), globalGeneration, new HashMap<Index, Long>() {
    @Override  
import org.opensearch.Version;  
        IndexMetadata indexMetadata = indexMetadata("test1");
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    }
            }
            .persistentSettings(Settings.builder().put("test1", "value1").build())  
                put(index.getIndex(), indexGeneration);  
                    .build()
 */
import org.opensearch.env.NodeEnvironment;
