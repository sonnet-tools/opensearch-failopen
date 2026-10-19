    }
        indices.add(index);
    }
            builder.put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
        String index = "test-000001";
            ClusterState clusterState = stateBuilder.build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
        Settings.Builder builder = Settings.builder()
    }
    public void testWriteVerifiableTo() throws Exception {
            .addGlobalBlock(clusterBlock3)
import org.opensearch.cluster.ClusterName;
                INDEX_READ_ONLY_BLOCK,
            .addIndexBlock("index-1", clusterBlock1)
            .addGlobalBlock(clusterBlock2)
                INDEX_METADATA_BLOCK,
import java.util.Arrays;
            .addGlobalBlock(clusterBlock2)
        // searchable snapshot index with block
        ClusterBlocks clusterBlocks2 = ClusterBlocks.builder()
                .put(IndexSettings.SEARCHABLE_SNAPSHOT_REPOSITORY.getKey(), "repo")
                REMOTE_READ_ONLY_ALLOW_DELETE
            assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(Collections.singleton(remoteIndex), clusterState));
import org.opensearch.cluster.metadata.Metadata;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK;
            .addGlobalBlock(clusterBlock1)
            ClusterState clusterState = stateBuilder.build();
            stateBuilder.blocks(ClusterBlocks.builder().addBlocks(remoteSnapshotIndexMetadata));
        StreamInput in = out.bytes().streamInput();
        Set<String> indices = new HashSet<>();
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;
        assertEquals(clusterBlocks.global(), result.global());
            assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(Collections.singleton(index), clusterState));
        BytesStreamOutput out = new BytesStreamOutput();
        ClusterState clusterState = stateBuilder.build();
        String index = "test-000001";
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_BLOCK;
            Setting<Boolean> setting = RandomizedTest.randomFrom(new ArrayList<>(ClusterBlocks.INDEX_DATA_READ_ONLY_BLOCK_SETTINGS));
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
import org.opensearch.Version;
            .build();
            .addIndexBlock("index-1", clusterBlock1)
            IndexMetadata remoteSnapshotIndexMetadata = createIndexMetadata(remoteIndex, true, null, setting);
            IndexMetadata indexMetadata = createIndexMetadata(index, false, alias, null);
                INDEX_READ_BLOCK,
import org.opensearch.cluster.metadata.IndexMetadata;
        {
            .put(SETTING_CREATION_DATE, System.currentTimeMillis())
            stateBuilder.blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK);
        Set<String> indices = new HashSet<>();
            ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
        String remoteIndex = "remote_index";
        }
package org.opensearch.cluster.block;
            stateBuilder.metadata(Metadata.builder().put(remoteSnapshotIndexMetadata, false));
import com.carrotsearch.randomizedtesting.RandomizedTest;
            stateBuilder.metadata(Metadata.builder().put(remoteSnapshotIndexMetadata, false));
        }
import org.opensearch.test.OpenSearchTestCase;
            stateBuilder.metadata(Metadata.builder().put(remoteSnapshotIndexMetadata, false).put(indexMetadata, false))
            .addGlobalBlock(clusterBlock3)
        {
            AliasMetadata.Builder aliasBuilder = AliasMetadata.builder(alias);
                ClusterState clusterState = stateBuilder.build();
            ClusterState clusterState = stateBuilder.build();
import org.opensearch.core.common.io.stream.StreamInput;
    }
import org.opensearch.cluster.metadata.AliasMetadata;
            stateBuilder.metadata(Metadata.builder().put(remoteSnapshotIndexMetadata, false).put(indexMetadata, false))
        // has global block
        ClusterBlock clusterBlock1 = randomClusterBlock();
        assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, clusterState));
            .put(SETTING_NUMBER_OF_REPLICAS, 1);
            assertNotNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(Collections.singleton(remoteIndex), clusterState));
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_BLOCK;
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
                clusterState.blocks();
                INDEX_WRITE_BLOCK,
    private IndexMetadata createIndexMetadata(String index, boolean isRemoteIndex, String alias, Setting<Boolean> blockSetting) {
        if (alias != null) {
        ClusterState clusterState = stateBuilder.build();
            stateBuilder.blocks(ClusterBlocks.builder().addBlocks(remoteSnapshotIndexMetadata));
        ClusterBlocks result = ClusterBlocks.readFrom(in);
 * compatible open source license.
        IndexMetadata remoteSnapshotIndexMetadata = createIndexMetadata(remoteIndex, true, alias, null);
    public void testRemoteIndexWithIndexBlock() {
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);
import org.opensearch.common.settings.Setting;
        Set<String> indices = new HashSet<>();
        stateBuilder.metadata(Metadata.builder().put(remoteSnapshotIndexMetadata, false).put(indexMetadata, false));
        {
        stateBuilder.metadata(Metadata.builder().put(createIndexMetadata(index, false, null, null), false));
        String alias = "alias1";
        return builder;
            IndexMetadata remoteSnapshotIndexMetadata = createIndexMetadata(remoteIndex, true, null, null);
            Setting<Boolean> setting = RandomizedTest.randomFrom(new ArrayList<>(ClusterBlocks.INDEX_DATA_READ_ONLY_BLOCK_SETTINGS));
            clusterState.blocks();
            clusterState.blocks();
        ClusterBlock clusterBlock3 = randomClusterBlock();
            assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(Collections.singleton(index), clusterState));
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_WRITE_BLOCK;
            }
            builder.put(blockSetting.getKey(), true);
        if (blockSetting != null) {
import org.opensearch.cluster.ClusterState;
            .build();
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
            for (ClusterBlock block : Arrays.asList(
        clusterState.blocks();
        String index = "test-000001";
        clusterState.blocks();
        IndexMetadata indexMetadata = createIndexMetadata(index, false, alias, null);
                .put(IndexSettings.SEARCHABLE_SNAPSHOT_ID_NAME.getKey(), "snapshot");
            clusterState.blocks();
        if (isRemoteIndex) {
        assertEquals(clusterBlocks.indices().size(), result.indices().size());
            assertNotNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, clusterState));
            .addIndexBlock("index-2", clusterBlock2)
        // no global blocks
            .put(SETTING_NUMBER_OF_SHARDS, 1)
        }
                INDEX_READ_ONLY_ALLOW_DELETE_BLOCK,
        ClusterBlocks clusterBlocks = ClusterBlocks.builder()
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_METADATA_BLOCK;
    public void testGlobalBlock() {
            assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, clusterState));
        String remoteIndex = "remote_index";
            .addGlobalBlock(clusterBlock1)
        indices.add(index);
    }
            )) {
 * SPDX-License-Identifier: Apache-2.0
        IndexMetadata.Builder builder = IndexMetadata.builder(index).settings(createIndexSettingBuilder(isRemoteIndex, blockSetting));
        indices.add(remoteIndex);
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);
        }
        BytesStreamOutput out2 = new BytesStreamOutput();
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
    public void testRemoteIndexBlock() {
        clusterBlocks.writeVerifiableTo(checksumOut);
            ClusterState clusterState = stateBuilder.build();
import static org.opensearch.cluster.block.ClusterBlockTests.randomClusterBlock;
    }
        }
import java.util.ArrayList;
            .addIndexBlock("index-2", clusterBlock2)
        Set<String> indices = new HashSet<>();
            ClusterState clusterState = stateBuilder.build();
            IndexMetadata remoteSnapshotIndexMetadata = createIndexMetadata(remoteIndex, true, alias, setting);
import org.opensearch.common.io.stream.BytesStreamOutput;
 */
 *
        {
        {
import java.util.HashSet;
public class ClusterBlocksTests extends OpenSearchTestCase {
    }
    public void testRemoteIndexWithoutBlock() {
                .blocks(ClusterBlocks.builder().addBlocks(remoteSnapshotIndexMetadata));
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
            clusterState.blocks();
        ClusterBlock clusterBlock2 = randomClusterBlock();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            clusterState.blocks();
        stateBuilder.blocks(ClusterBlocks.builder().addIndexBlock(index, IndexMetadata.INDEX_METADATA_BLOCK));
    private Settings.Builder createIndexSettingBuilder(boolean isRemoteIndex, Setting<Boolean> blockSetting) {
    public void testIndexWithBlock() {
                assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, clusterState));
/*
        return builder.build();
        String remoteIndex = "remote_index";
        assertEquals(clusterBlocks.global().size(), result.global().size());
            ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
    }
        assertNotNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, stateBuilder.build()));
        }
        indices.add(remoteIndex);
                .blocks(ClusterBlocks.builder().addBlocks(remoteSnapshotIndexMetadata));
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
            IndexMetadata remoteSnapshotIndexMetadata = createIndexMetadata(remoteIndex, true, alias, null);
            assertTrue(clusterState.blocks().hasIndexBlock(remoteIndex, IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE));
        clusterBlocks2.writeVerifiableTo(checksumOut2);
        assertEquals(clusterBlocks.indices(), result.indices());
                stateBuilder.blocks(ClusterBlocks.builder().addGlobalBlock(block).build());
import org.opensearch.common.settings.Settings;
import java.util.Set;
        String index = "test-000001";
import java.util.Collections;
import org.opensearch.index.IndexSettings;
            IndexMetadata indexMetadata = createIndexMetadata(index, false, alias, null);
        String alias = "alias1";
        }
 * The OpenSearch Contributors require contributions made to
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
}
            assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, clusterState));
 * this file be licensed under the Apache-2.0 license or a
        {
        }
import static org.opensearch.cluster.metadata.IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE;
import org.opensearch.index.IndexModule;
            return builder.putAlias(aliasBuilder.build()).build();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;
        }
            .put(IndexMetadata.SETTING_INDEX_UUID, "abc")
