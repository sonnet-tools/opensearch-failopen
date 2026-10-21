    public void testDanglingIndicesDiscovery() throws Exception {
 * Modifications Copyright OpenSearch Contributors. See
            final Settings.Builder existingSettings = Settings.builder()
                metadata
 * GitHub history for details.
        try (NodeEnvironment env = newNodeEnvironment()) {
    /**
            final List<IndexMetadata> filteredIndices = danglingState.filterDanglingIndices(metadata, newDanglingIndices);
                assertTrue(newDanglingIndices.isEmpty());
import static org.mockito.Mockito.any;
    }
import java.nio.file.StandardCopyOption;
import java.util.Map;
            Metadata metadata = Metadata.builder().build();
    }
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);
import org.opensearch.cluster.metadata.Metadata;
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            danglingState.cleanupAllocatedDangledIndices(metadata);
                fail("no exception thrown for invalid folder name");
            for (Path path : env.resolveIndexFolder(uuid)) {
        .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.core.index.Index;
            verify(localAllocateDangledIndices).allocateDangled(any(), any());
import java.util.HashMap;
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.metadata.AliasMetadata;
                .put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
    // warning checks or all the tests will fail.
        try (NodeEnvironment env = newNodeEnvironment()) {
            Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
            assertThat(entry.getKey().getName(), equalTo("test1"));
            metaStateService.writeIndex("test_write", dangledIndex);
    }
            final Map<String, IndexMetadata> indices = new HashMap<>();
            final Metadata metadata = Metadata.builder().build();
            final Settings allocateSettings = Settings.builder().put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), true).build();
                env,
import org.opensearch.test.OpenSearchTestCase;
    public void testInvalidIndexFolder() throws Exception {
        .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
            danglingIndicesState.findNewAndAddDanglingIndices(metadata);
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
            );
import static java.util.Collections.emptyMap;
                .put(IndexMetadata.SETTING_INDEX_UUID, "test2UUID");
        return new DanglingIndicesState(env, metaStateService, null, clusterServiceMock);
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
import static org.hamcrest.Matchers.anEmptyMap;
    public void testClusterStateListenerNotRegisterWhenSettingDisabled() throws Exception {
            }
import org.opensearch.cluster.metadata.IndexGraveyard;
            danglingIndicesState.allocateDanglingIndices(metadata);
            metaStateService.writeIndex("test_write", dangledIndex);
                Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
        when(clusterServiceMock.getSettings()).thenReturn(allocateSettings);
            assertThat(dangledIndex.getAliases().size(), equalTo(1));
    }
    @Override
     */
            Map.Entry<Index, IndexMetadata> entry = newDanglingIndices.entrySet().iterator().next();
            for (int i = 0; i < numberOfChecks; i++) {
/*
                .putAlias(AliasMetadata.newAliasMetadataBuilder("test_aliasd").build())
import static org.hamcrest.Matchers.equalTo;
            metaStateService.writeIndex("test_write", dangledIndex);
            } catch (IllegalStateException e) {
    }
 * this file be licensed under the Apache-2.0 license or a
    }
            metaStateService.writeIndex("test_write", dangledIndex);
            final IndexGraveyard graveyard = IndexGraveyard.builder().addTombstone(dangledIndex.getIndex()).build();
            Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(
        }
        }
            }
            LocalAllocateDangledIndices localAllocateDangledIndices = mock(LocalAllocateDangledIndices.class);
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);
 * ownership. Elasticsearch licenses this file to you under
     * already known about it.
 *
        }
    protected boolean enableWarningsCheck() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import static org.mockito.Mockito.verify;
        try (NodeEnvironment env = newNodeEnvironment()) {
                    Files.move(path, path.resolveSibling("invalidUUID"), StandardCopyOption.ATOMIC_MOVE);
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
    }
     * Check that when auto-imports are disabled, then no change listener is registered with the cluster state.
                if (Files.exists(path)) {
                .build();
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
    public void testDanglingProcessing() throws Exception {
                assertThat(danglingState.getDanglingIndices().keySet(), Matchers.hasItems(dangledIndex.getIndex()));
    }
    public void testDanglingIndicesNotImportedWhenTombstonePresent() throws Exception {
 * this work for additional information regarding copyright
            indices.put(dangledIndex.getIndex().getName(), existingIndex);
import java.nio.file.Path;
            newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
            Metadata metadata = Metadata.builder().build();
        final Settings allocateSettings = Settings.builder().put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), true).build();
                .settings(settings)
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            // All dangling indices should be found...
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            // simulate allocation to the metadata
            int numberOfChecks = randomIntBetween(1, 10);
            final Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
                .put(indexSettings)
import static org.hamcrest.Matchers.empty;
            IndexMetadata existingIndex = IndexMetadata.builder("test_index").settings(existingSettings).build();
                assertThat(newDanglingIndices.size(), equalTo(1));
                }
 * the Apache License, Version 2.0 (the "License"); you may
            final Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
 * The OpenSearch Contributors require contributions made to
            }
        try (NodeEnvironment env = newNodeEnvironment()) {
        .build();
            DanglingIndicesState danglingIndicesState = new DanglingIndicesState(
import org.opensearch.cluster.service.ClusterService;
            Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
        try (NodeEnvironment env = newNodeEnvironment()) {
        }
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.gateway;
                assertThat(danglingState.getDanglingIndices().size(), equalTo(1));
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            try {
 *
    }
        try (NodeEnvironment env = newNodeEnvironment()) {
            Metadata metadata = Metadata.builder().build();
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            }
 * Licensed to Elasticsearch under one or more contributor
    }
        }
}
            );
import static org.hamcrest.Matchers.aMapWithSize;
            }
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
        try (NodeEnvironment env = newNodeEnvironment()) {
            IndexMetadata dangledIndex = IndexMetadata.builder("test_index").settings(danglingSettings).build();
            verify(clusterServiceMock, never()).addListener(any());
                assertThat(danglingState.getDanglingIndices().keySet(), Matchers.hasItems(dangledIndex.getIndex()));
            Metadata metadata = Metadata.builder().build();
            final Settings.Builder danglingSettings = Settings.builder()
                assertThat(newDanglingIndices.keySet(), Matchers.hasItems(dangledIndex.getIndex()));
 * You may obtain a copy of the License at
            final ClusterService clusterServiceMock = mock(ClusterService.class);
    public void testDanglingIndicesNotDiscoveredWhenAlreadyKnown() throws Exception {
    public void testDanglingIndicesStripAliases() throws Exception {
                assertThat(e.getMessage(), equalTo("[invalidUUID] invalid index folder name, rename to [test1UUID]"));
        }
    private DanglingIndicesState createDanglingIndicesState(NodeEnvironment env, MetaStateService metaStateService) {
                assertTrue(danglingState.getDanglingIndices().isEmpty());
            when(clusterServiceMock.getSettings()).thenReturn(allocateSettings);
            assertTrue(danglingState.getDanglingIndices().isEmpty());
/*
                Map<Index, IndexMetadata> newDanglingIndices = danglingState.findNewDanglingIndices(emptyMap(), metadata);
import org.hamcrest.Matchers;
        }
            final Metadata metadata = Metadata.builder().build();
import static org.hamcrest.Matchers.is;
        try (NodeEnvironment env = newNodeEnvironment()) {
            metaStateService.writeIndex("test_write", dangledIndex);
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
            assertFalse(newDanglingIndices.containsKey(dangledIndex.getIndex()));
 *
            metadata = Metadata.builder(metadata).put(dangledIndex, true).build();
import static org.mockito.Mockito.mock;
        return false;
                metaStateService,
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
 */
            final String uuid = "test1UUID";
        try (NodeEnvironment env = newNodeEnvironment()) {
                danglingState.findNewDanglingIndices(emptyMap(), metadata);
            IndexMetadata dangledIndex = IndexMetadata.builder("test1")
import static java.util.Collections.singletonMap;
import static org.mockito.Mockito.never;
            assertTrue(danglingState.getDanglingIndices().isEmpty());
 */
            final Metadata metadata = Metadata.builder().indexGraveyard(graveyard).build();
            metaStateService.writeIndex("test_write", dangledIndex);
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, "test1UUID");
/*
    public void testCleanupWhenEmpty() throws Exception {
            metaStateService.writeIndex("test_write", dangledIndex);
            metadata = Metadata.builder().put(dangledIndex, false).build();
            assertTrue("Expected dangling imports to be enabled", danglingIndicesState.isAutoImportDanglingIndicesEnabled());
            new DanglingIndicesState(env, metaStateService, localAllocateDangledIndices, clusterServiceMock);
 * specific language governing permissions and limitations
            final Settings.Builder settings = Settings.builder().put(indexSettings).put(IndexMetadata.SETTING_INDEX_UUID, uuid);
                singletonMap(dangledIndex.getIndex(), dangledIndex),
 * license agreements. See the NOTICE file distributed with
     * Check that a dangling index is not reported as newly discovered when we
        }
     */
            LocalAllocateDangledIndices localAllocateDangledIndices = mock(LocalAllocateDangledIndices.class);
 * software distributed under the License is distributed on an
        try (NodeEnvironment env = newNodeEnvironment()) {
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);
import static org.mockito.Mockito.when;
            assertThat(newDanglingIndices.size(), equalTo(1));
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
            assertThat(filteredIndices, is(empty()));
 * not use this file except in compliance with the License.
import org.opensearch.env.NodeEnvironment;
                danglingState.findNewAndAddDanglingIndices(metadata);
            assertThat(entry.getValue().getAliases().size(), equalTo(0));
import java.nio.file.Files;
     * Check that when auto-imports are enabled, then dangling indices are automatically imported.
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);
            for (int i = 0; i < numberOfChecks; i++) {
    }
            IndexMetadata dangledIndex = IndexMetadata.builder("test1").settings(settings).build();
            final Settings allocateSettings = Settings.builder().put(AUTO_IMPORT_DANGLING_INDICES_SETTING.getKey(), false).build();
    }
                localAllocateDangledIndices,
            assertTrue(newDanglingIndices.containsKey(dangledIndex.getIndex()));
            Metadata metadata = Metadata.builder().build();
        }
        final ClusterService clusterServiceMock = mock(ClusterService.class);
    public void testDanglingIndicesAreAllocatedWhenEnabled() throws Exception {
            MetaStateService metaStateService = new MetaStateService(env, xContentRegistry());
                .put(indexSettings)
            // check that several runs when in the metadata, but not cleaned yet, still keeps dangled
public class DanglingIndicesStateTests extends OpenSearchTestCase {
            assertThat(newDanglingIndices, is(aMapWithSize(1)));
        }
            metaStateService.writeIndex("test_write", dangledIndex);
                assertThat(danglingState.getDanglingIndices().size(), equalTo(1));
import org.opensearch.common.settings.Settings;
    /**
import java.util.List;
    // The setting AUTO_IMPORT_DANGLING_INDICES_SETTING is deprecated, so we must disable
            when(clusterServiceMock.getSettings()).thenReturn(allocateSettings);
            // ...but the filter method should remove those where another index exists with the same name
    /**
 * KIND, either express or implied.  See the License for the
            final Metadata metadata = Metadata.builder().indices(indices).build();
            // check that several runs when not in the metadata still keep the dangled index around
 * Unless required by applicable law or agreed to in writing,
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);
 * compatible open source license.
 * under the License.
            assertThat(newDanglingIndices, is(anEmptyMap()));
            final ClusterService clusterServiceMock = mock(ClusterService.class);
            for (int i = 0; i < numberOfChecks; i++) {
                clusterServiceMock
            danglingState.cleanupAllocatedDangledIndices(metadata);
import org.opensearch.Version;
 */
            assertTrue(danglingState.getDanglingIndices().isEmpty());
            DanglingIndicesState danglingState = createDanglingIndicesState(env, metaStateService);
    private static Settings indexSettings = Settings.builder()
            // Build another index with the same name but a different UUID
            assertThat(newDanglingIndices, is(emptyMap()));
            metaStateService.writeIndex("test_write", existingIndex);
import static org.opensearch.gateway.DanglingIndicesState.AUTO_IMPORT_DANGLING_INDICES_SETTING;
            assertTrue(danglingState.getDanglingIndices().isEmpty());
    public void testDanglingIndicesNotImportedWhenIndexNameIsAlreadyUsed() throws Exception {
