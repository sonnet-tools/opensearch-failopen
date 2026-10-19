        ClusterBlocks result = ClusterBlocks.readFrom(in);  
            ClusterState clusterState = stateBuilder.build();  
        }
import static org.opensearch.cluster.metadata.IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE;  
            assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, clusterState));  
        ClusterBlocks clusterBlocks2 = ClusterBlocks.builder()
        {  
                clusterState.blocks();
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_VERSION_CREATED;
            IndexMetadata remoteSnapshotIndexMetadata = createIndexMetadata(remoteIndex, true, alias, setting);
        assertEquals(clusterBlocks.indices().size(), result.indices().size());
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_METADATA_BLOCK;
    public void testWriteVerifiableTo() throws Exception {
        return builder.build();
                .blocks(ClusterBlocks.builder().addBlocks(remoteSnapshotIndexMetadata));
            stateBuilder.blocks(ClusterBlocks.builder().addBlocks(remoteSnapshotIndexMetadata));
            .put(SETTING_NUMBER_OF_REPLICAS, 1);
        // searchable snapshot index with block  
            .addGlobalBlock(clusterBlock1)
                stateBuilder.blocks(ClusterBlocks.builder().addGlobalBlock(block).build());
        clusterState.blocks();  
                INDEX_READ_ONLY_ALLOW_DELETE_BLOCK,
    public void testIndexWithBlock() {
 */  
        Set<String> indices = new HashSet<>();
    }  
                INDEX_WRITE_BLOCK,  
        indices.add(remoteIndex);
    private Settings.Builder createIndexSettingBuilder(boolean isRemoteIndex, Setting<Boolean> blockSetting) {
            clusterState.blocks();  
            stateBuilder.metadata(Metadata.builder().put(remoteSnapshotIndexMetadata, false).put(indexMetadata, false))  
            IndexMetadata remoteSnapshotIndexMetadata = createIndexMetadata(remoteIndex, true, null, setting);  
        ClusterState clusterState = stateBuilder.build();  
                .put(IndexSettings.SEARCHABLE_SNAPSHOT_ID_NAME.getKey(), "snapshot");
import org.opensearch.cluster.ClusterState;
import org.opensearch.cluster.metadata.AliasMetadata;  
        String alias = "alias1";
        String alias = "alias1";
import org.opensearch.test.OpenSearchTestCase;
        {
        String index = "test-000001";  
            IndexMetadata remoteSnapshotIndexMetadata = createIndexMetadata(remoteIndex, true, alias, null);
        String remoteIndex = "remote_index";
    private IndexMetadata createIndexMetadata(String index, boolean isRemoteIndex, String alias, Setting<Boolean> blockSetting) {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_SHARDS;  
        Settings.Builder builder = Settings.builder()  
    public void testRemoteIndexWithIndexBlock() {
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
        String remoteIndex = "remote_index";
        clusterState.blocks();
import com.carrotsearch.randomizedtesting.RandomizedTest;
        indices.add(index);
        return builder;
        {
        }
        }
        // no global blocks
        if (isRemoteIndex) {
            .addIndexBlock("index-1", clusterBlock1)
        String index = "test-000001";
import org.opensearch.core.common.io.stream.StreamInput;
            assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(Collections.singleton(remoteIndex), clusterState));
            return builder.putAlias(aliasBuilder.build()).build();  
            for (ClusterBlock block : Arrays.asList(  
            ClusterState clusterState = stateBuilder.build();  
            stateBuilder.metadata(Metadata.builder().put(remoteSnapshotIndexMetadata, false));
            ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
        ClusterBlock clusterBlock1 = randomClusterBlock();  
                INDEX_READ_BLOCK,
        assertEquals(clusterBlocks.indices(), result.indices());
            assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, clusterState));
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_ALLOW_DELETE_BLOCK;  
import org.opensearch.index.IndexModule;
    }  
        String remoteIndex = "remote_index";
    public void testRemoteIndexWithoutBlock() {  
            .put(SETTING_VERSION_CREATED, Version.CURRENT)
                INDEX_METADATA_BLOCK,
            clusterState.blocks();
import org.opensearch.cluster.ClusterName;
        clusterBlocks.writeVerifiableTo(checksumOut);
    public void testRemoteIndexBlock() {
import org.opensearch.cluster.metadata.Metadata;
            ClusterState clusterState = stateBuilder.build();
        Set<String> indices = new HashSet<>();  
            .addIndexBlock("index-1", clusterBlock1)  
import org.opensearch.common.settings.Settings;
            assertTrue(clusterState.blocks().hasIndexBlock(remoteIndex, IndexMetadata.REMOTE_READ_ONLY_ALLOW_DELETE));
            .addGlobalBlock(clusterBlock3)
        stateBuilder.metadata(Metadata.builder().put(createIndexMetadata(index, false, null, null), false));
        }
import org.opensearch.cluster.metadata.IndexMetadata;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_BLOCK;
        Set<String> indices = new HashSet<>();
                ClusterState clusterState = stateBuilder.build();  
        stateBuilder.blocks(ClusterBlocks.builder().addIndexBlock(index, IndexMetadata.INDEX_METADATA_BLOCK));  
            assertNotNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(Collections.singleton(remoteIndex), clusterState));
                INDEX_READ_ONLY_BLOCK,
public class ClusterBlocksTests extends OpenSearchTestCase {  
        Set<String> indices = new HashSet<>();  
        {
        ClusterBlock clusterBlock3 = randomClusterBlock();
            assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(Collections.singleton(index), clusterState));
    }
                REMOTE_READ_ONLY_ALLOW_DELETE  
            .addGlobalBlock(clusterBlock3)
import java.util.Collections;
            IndexMetadata indexMetadata = createIndexMetadata(index, false, alias, null);
    }
            .addGlobalBlock(clusterBlock1)  
            stateBuilder.metadata(Metadata.builder().put(remoteSnapshotIndexMetadata, false).put(indexMetadata, false))
        assertNotNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, stateBuilder.build()));
        }
 *
            clusterState.blocks();
        String index = "test-000001";  
            builder.put(blockSetting.getKey(), true);
            clusterState.blocks();
        BytesStreamOutput out2 = new BytesStreamOutput();
            stateBuilder.metadata(Metadata.builder().put(remoteSnapshotIndexMetadata, false));  
            .put(SETTING_NUMBER_OF_SHARDS, 1)
        if (blockSetting != null) {  
import java.util.Set;
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
            .addIndexBlock("index-2", clusterBlock2)
                assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, clusterState));
        ClusterBlock clusterBlock2 = randomClusterBlock();
    }
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_NUMBER_OF_REPLICAS;
 * compatible open source license.
            .addGlobalBlock(clusterBlock2)
import org.opensearch.core.common.io.stream.BufferedChecksumStreamOutput;  
            )) {
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
    }
        indices.add(remoteIndex);
        IndexMetadata indexMetadata = createIndexMetadata(index, false, alias, null);
        String index = "test-000001";  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_CREATION_DATE;
import org.opensearch.index.IndexSettings;  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_WRITE_BLOCK;
                .blocks(ClusterBlocks.builder().addBlocks(remoteSnapshotIndexMetadata));
        // has global block
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
        ClusterBlocks clusterBlocks = ClusterBlocks.builder()
            .build();
                .put(IndexSettings.SEARCHABLE_SNAPSHOT_REPOSITORY.getKey(), "repo")  
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.common.settings.Setting;
 * The OpenSearch Contributors require contributions made to  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_READ_ONLY_BLOCK;
            }  
        BufferedChecksumStreamOutput checksumOut2 = new BufferedChecksumStreamOutput(out2);  
import java.util.Arrays;
        }
        assertEquals(clusterBlocks.global(), result.global());  
            ClusterState clusterState = stateBuilder.build();
        }  
            .put(IndexMetadata.SETTING_INDEX_UUID, "abc")
            IndexMetadata remoteSnapshotIndexMetadata = createIndexMetadata(remoteIndex, true, null, null);
        {
import java.util.HashSet;  
        ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
            .addIndexBlock("index-2", clusterBlock2)  
        stateBuilder.metadata(Metadata.builder().put(remoteSnapshotIndexMetadata, false).put(indexMetadata, false));
            Setting<Boolean> setting = RandomizedTest.randomFrom(new ArrayList<>(ClusterBlocks.INDEX_DATA_READ_ONLY_BLOCK_SETTINGS));  
            .addGlobalBlock(clusterBlock2)  
        BufferedChecksumStreamOutput checksumOut = new BufferedChecksumStreamOutput(out);  
        assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, clusterState));
            IndexMetadata indexMetadata = createIndexMetadata(index, false, alias, null);  
        assertEquals(clusterBlocks.global().size(), result.global().size());
            .put(SETTING_CREATION_DATE, System.currentTimeMillis())  
            ClusterState.Builder stateBuilder = ClusterState.builder(new ClusterName("cluster"));
import org.opensearch.Version;  
    }  
            stateBuilder.blocks(ClusterBlocks.builder().addBlocks(remoteSnapshotIndexMetadata));
        StreamInput in = out.bytes().streamInput();
import org.opensearch.common.io.stream.BytesStreamOutput;  
        assertEquals(checksumOut.getChecksum(), checksumOut2.getChecksum());
            ClusterState clusterState = stateBuilder.build();  
            AliasMetadata.Builder aliasBuilder = AliasMetadata.builder(alias);
            stateBuilder.blocks(ClusterBlocks.EMPTY_CLUSTER_BLOCK);
        IndexMetadata remoteSnapshotIndexMetadata = createIndexMetadata(remoteIndex, true, alias, null);
            builder.put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey())
        clusterBlocks2.writeVerifiableTo(checksumOut2);
            Setting<Boolean> setting = RandomizedTest.randomFrom(new ArrayList<>(ClusterBlocks.INDEX_DATA_READ_ONLY_BLOCK_SETTINGS));
        indices.add(index);  
    public void testGlobalBlock() {
            assertNotNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(indices, clusterState));
            assertNull(ClusterBlocks.indicesWithRemoteSnapshotBlockedException(Collections.singleton(index), clusterState));  
        }
        ClusterState clusterState = stateBuilder.build();
        }
        {  
        if (alias != null) {
import java.util.ArrayList;  
/*  
import static org.opensearch.cluster.block.ClusterBlockTests.randomClusterBlock;  
            .build();
    }  
        IndexMetadata.Builder builder = IndexMetadata.builder(index).settings(createIndexSettingBuilder(isRemoteIndex, blockSetting));  
package org.opensearch.cluster.block;
}  
            clusterState.blocks();  
