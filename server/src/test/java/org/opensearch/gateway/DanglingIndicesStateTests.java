            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);  
                    Files.move(path, path.resolveSibling("invalidUUID"), StandardCopyOption.ATOMIC_MOVE);  
            new DanglingIndicesState(env, metaStateService, localAllocateDangledIndices, clusterServiceMock);
import static java.util.Collections.emptyMap;
     */
                assertTrue(danglingState.getDanglingIndices().isEmpty());
            final ClusterService clusterServiceMock = mock(ClusterService.class);
import static org.mockito.Mockito.verify;  
     */  
        return new DanglingIndicesState(env, metaStateService, null, clusterServiceMock);  
    public void testDanglingProcessing() throws Exception {  
                .put(IndexMetadata.SETTING_INDEX_UUID, "test2UUID");  
            // Build another index with the same name but a different UUID  
import org.opensearch.env.NodeEnvironment;
    public void testDanglingIndicesDiscovery() throws Exception {  
import java.util.HashMap;  
 * You may obtain a copy of the License at  
            metaStateService.writeIndex("test_write", existingIndex);
            }
                if (Files.exists(path)) {
     */
                metadata  
            metadata = Metadata.builder(metadata).put(dangledIndex, true).build();
import org.opensearch.cluster.metadata.Metadata;
 * not use this file except in compliance with the License.
    }  
            assertTrue(danglingState.getDanglingIndices().isEmpty());
import static org.mockito.Mockito.when;
    private static Settings indexSettings = Settings.builder()
            LocalAllocateDangledIndices localAllocateDangledIndices = mock(LocalAllocateDangledIndices.class);
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);  
    }
            final Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);  
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);  
 * license agreements. See the NOTICE file distributed with
 *  
            IndexMetadata existingIndex = IndexMetadata.builder("test_index").settings(existingSettings).build();
     * Check that when auto-imports are disabled, then no change listener is registered with the cluster state.
import static org.mockito.Mockito.any;  
import org.opensearch.Version;  
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);  
    }
    public void testDanglingIndicesNotImportedWhenIndexNameIsAlreadyUsed() throws Exception {
    public void testDanglingIndicesStripAliases() throws Exception {  
    public void testCleanupWhenEmpty() throws Exception {  
            assertThat(entry.getValue().getAliases().size(), equalTo(0));  
            Metadata metadata = Metadata.builder().build();
                }
        try (NodeEnvironment env = newNodeEnvironment()) {
 * SPDX-License-Identifier: Apache-2.0
    /**
                env,  
            metaStateService.writeIndex("test_write", dangledIndex);
    // The setting AUTO_IMPORT_DANGLING_INDICES_SETTING is deprecated, so we must disable
     * Check that when auto-imports are enabled, then dangling indices are automatically imported.  
            metaStateService.writeIndex("test_write", dangledIndex);
            }  
            metaStateService.writeIndex("test_write", dangledIndex);
            Map.Entry<Index, IndexMetadata> entry = newDanglingIndices.entrySet().iterator().next();
            for (int i = 0; i < numberOfChecks; i++) {
        final Settings allocateSettings = Settings.builder().put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), true).build();
            assertThat(dangledIndex.getAliases().size(), equalTo(1));
            for (Path path : env.resolveIndexFolder(uuid)) {
                .put(indexSettings)
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());  
 */
        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
    @Override
            }
                assertThat(e.getMessage(), equalTo("[invalidUUID] invalid index folder name, rename to [test1UUID]"));
            assertTrue(danglingState.getDanglingIndices().isEmpty());
            final Metadata metadata = Metadata.builder().build();  
        when(clusterServiceMock.getSettings()).thenReturn(allocateSettings);
                .settings(settings)
        }  
            verify(localAllocateDangledIndices).allocateDangled(any(), any());
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);
 * under the License.  
import java.nio.file.StandardCopyOption;
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
        .build();  
import org.hamcrest.Matchers;
        try (NodeEnvironment env = newNodeEnvironment()) {
        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testDanglingIndicesNotDiscoveredWhenAlreadyKnown() throws Exception {  
        }
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
            Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
            metaStateService.writeIndex("test_write", dangledIndex);  
            metadata = Metadata.builder().put(dangledIndex, false).build();
        }  
                .put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
     * Check that a dangling index is not reported as newly discovered when we  
 * Modifications Copyright OpenSearch Contributors. See  
            newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);  
            assertTrue(danglingState.getDanglingIndices().isEmpty());
                assertThat(danglingState.getDanglingIndices().size(), equalTo(1));
    /**
            assertThat(newDanglingIndices, is(emptyMap()));  
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            assertTrue(danglingState.getDanglingIndices().isEmpty());
            IndexMetadata dangledIndex = IndexMetadata.builder("test1")  
                assertThat(danglingState.getDanglingIndices().keySet(), Matchers.hasItems(dangledIndex.getIndex()));  
            danglingState.cleanupAllocatedDangledIndices(metadata);
 * this work for additional information regarding copyright
    public void testDanglingIndicesNotImportedWhenTombstonePresent() throws Exception {
import org.opensearch.cluster.metadata.IndexMetadata;  
    public void testDanglingIndicesAreAllocatedWhenEnabled() throws Exception {
            metaStateService.writeIndex("test_write", dangledIndex);  
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");  
            // ...but the filter method should remove those where another index exists with the same name  
import static org.mockito.Mockito.never;
     * already known about it.
        try (NodeEnvironment env = newNodeEnvironment()) {
                assertThat(newDanglingIndices.size(), equalTo(1));  
            }
            Metadata metadata = Metadata.builder().build();  
            final List<IndexMetadata> filteredIndices = danglingState.filterDanglingIndices(metadata, newDanglingIndices);
    private DanglingIndicesState createDanglingIndicesState(NodeEnvironment env, MetaStateService metaStateService) {  
 * Licensed to Elasticsearch under one or more contributor  
                danglingState.findNewAndAddDanglingIndices(metadata);  
                fail("no exception thrown for invalid folder name");
                assertTrue(newDanglingIndices.isEmpty());  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        }  
            final IndexGraveyard graveyard = IndexGraveyard.builder().addTombstone(dangledIndex.getIndex()).build();
            final Settings.Builder existingSettings = Settings.builder()
            // All dangling indices should be found...
 *
            // simulate allocation to the metadata  
import org.opensearch.test.OpenSearchTestCase;  
        }
    }
            when(clusterServiceMock.getSettings()).thenReturn(allocateSettings);  
/*
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            try {  
            danglingState.cleanupAllocatedDangledIndices(metadata);  
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            int numberOfChecks = randomIntBetween(1, 10);  
/*  
            final Metadata metadata = Metadata.builder().indexGraveyard(graveyard).build();  
                metaStateService,
                .build();  
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
                assertThat(danglingState.getDanglingIndices().keySet(), Matchers.hasItems(dangledIndex.getIndex()));  
import java.util.Map;
        }
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            assertThat(entry.getKey().getName(), equalTo("test1"));
 *    http://www.apache.org/licenses/LICENSE-2.0
            metaStateService.writeIndex("test_write", dangledIndex);  
        }
import java.nio.file.Files;  
            assertThat(newDanglingIndices.size(), equalTo(1));  
            danglingIndicesState.findNewAndAddDanglingIndices(metadata);
            verify(clusterServiceMock, never()).addListener(any());
            }
import static org.hamcrest.Matchers.empty;  
import static org.hamcrest.Matchers.is;
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");  
    protected boolean enableWarningsCheck() {
import static org.hamcrest.Matchers.anEmptyMap;
                assertThat(danglingState.getDanglingIndices().size(), equalTo(1));
            metaStateService.writeIndex("test_write", dangledIndex);
            assertThat(newDanglingIndices, is(aMapWithSize(1)));
                .putAlias(AliasMetadata.newAliasMetadataBuilder("test_aliasd").build())
 * The OpenSearch Contributors require contributions made to  
        }  
 */
    }  
                Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
 * KIND, either express or implied.  See the License for the
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
package org.opensearch.gateway;
    }
/*
import org.opensearch.cluster.metadata.AliasMetadata;
        try (NodeEnvironment env = newNodeEnvironment()) {
    }
                singletonMap(dangledIndex.getIndex(), dangledIndex),
import static org.mockito.Mockito.mock;
            danglingIndicesState.allocateDanglingIndices(metadata);  
    }
            indices.put(dangledIndex.getIndex().getName(), existingIndex);
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
            DanglingIndicesState danglingIndicesState = new DanglingIndicesState(
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());  
            );
            final Settings.Builder danglingSettings = Settings.builder()  
            assertTrue("Expected dangling imports to be enabled", danglingIndicesState.isAutoImportDanglingIndicesEnabled());  
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
                localAllocateDangledIndices,
 * ownership. Elasticsearch licenses this file to you under  
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);
import org.opensearch.cluster.metadata.IndexGraveyard;
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);  
import java.util.List;
            Metadata metadata = Metadata.builder().build();
import java.nio.file.Path;
    }
        try (NodeEnvironment env = newNodeEnvironment()) {
                assertThat(newDanglingIndices.keySet(), Matchers.hasItems(dangledIndex.getIndex()));
    /**
        try (NodeEnvironment env = newNodeEnvironment()) {
                clusterServiceMock  
            when(clusterServiceMock.getSettings()).thenReturn(allocateSettings);  
    public void testInvalidIndexFolder() throws Exception {  
        try (NodeEnvironment env = newNodeEnvironment()) {
            final Settings allocateSettings = Settings.builder().put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), false).build();  
import static org.hamcrest.Matchers.aMapWithSize;
            IndexMetadata dangledIndex = IndexMetadata.builder("test_index").settings(danglingSettings).build();  
import org.opensearch.cluster.service.ClusterService;
    }
            // check that several runs when in the metadata, but not cleaned yet, still keeps dangled  
import static java.util.Collections.singletonMap;
        }  
            final Metadata metadata = Metadata.builder().indices(indices).build();  
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
            final Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
public class DanglingIndicesStateTests extends OpenSearchTestCase {  
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();  
            // check that several runs when not in the metadata still keep the dangled index around
 * this file be licensed under the Apache-2.0 license or a
            for (int i = 0; i < numberOfChecks; i++) {
 * Unless required by applicable law or agreed to in writing,
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
        try (NodeEnvironment env = newNodeEnvironment()) {  
 * the Apache License, Version 2.0 (the "License"); you may
            assertTrue(newDanglingIndices.containsKey(dangledIndex.getIndex()));
        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
 * compatible open source license.
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, uuid);
            Metadata metadata = Metadata.builder().build();
            for (int i = 0; i < numberOfChecks; i++) {
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
        try (NodeEnvironment env = newNodeEnvironment()) {  
import org.opensearch.common.settings.Settings;  
import org.opensearch.core.index.Index;
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);  
import static org.opensearch.gateway.DanglingIndicesState.AUTO_IMPORT_DANGLING_INDICES_SETTING;  
                danglingState.findNewDanglingIndices(emptyMap(), metadata);
 * GitHub history for details.
 */  
            } catch (IllegalStateException e) {  
            final String uuid = "test1UUID";  
    }
    public void testClusterStateListenerNotRegisterWhenSettingDisabled() throws Exception {
        return false;  
            final Settings allocateSettings = Settings.builder().put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), true).build();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Metadata metadata = Metadata.builder().build();
 *
            LocalAllocateDangledIndices localAllocateDangledIndices = mock(LocalAllocateDangledIndices.class);
            );
            metaStateService.writeIndex("test_write", dangledIndex);
    }  
            Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);  
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
            assertThat(newDanglingIndices, is(anEmptyMap()));
            final Metadata metadata = Metadata.builder().build();
        final ClusterService clusterServiceMock = mock(ClusterService.class);  
                Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
            Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(
                .put(indexSettings)
            final ClusterService clusterServiceMock = mock(ClusterService.class);
        try (NodeEnvironment env = newNodeEnvironment()) {
            assertThat(filteredIndices, is(empty()));
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
    // warning checks or all the tests will fail.  
        }
}
import static org.hamcrest.Matchers.equalTo;
            final Map<String, IndexMetadata> indices = new HashMap<>();
            assertFalse(newDanglingIndices.containsKey(dangledIndex.getIndex()));
