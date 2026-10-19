    }
 */  
 * this file be licensed under the Apache-2.0 license or a
        IndexMetadata indexMetadata = new IndexMetadata.Builder(index.getName()).settings(idxSettings)  
                )
                        .add(CLUSTER_STATE_PATH_TOKEN)
import static org.mockito.Mockito.when;
        this.remoteIndexRoutingTableStore = new RemoteRoutingTableBlobStore<>(
            ThreadPool.Names.REMOTE_STATE_READ,  
import org.opensearch.Version;
    public void testGetBlobPathForUpload() {
import static org.opensearch.index.remote.RemoteStoreEnums.PathType.HASHED_PREFIX;  
                        .add(INDEX_ROUTING_TABLE)
    ClusterSettings clusterSettings;
import org.junit.After;  
        Settings idxSettings = Settings.builder()
        Settings newSettings = Settings.builder()
        IndexRoutingTable indexRoutingTable = new IndexRoutingTable.Builder(index).initializeAsNew(indexMetadata).build();
import org.opensearch.common.settings.Settings;
            .build();  
 * compatible open source license.
    public void tearDown() throws Exception {  
    }  
        BlobStoreRepository blobStoreRepository = mock(BlobStoreRepository.class);
            2L,
    @After
 *
        );
        );
    }
import org.opensearch.repositories.blobstore.BlobStoreRepository;
import org.opensearch.threadpool.TestThreadPool;
    ThreadPool threadPool;
                .indexUUID(index.getUUID())  
        BlobStoreTransferService blobStoreTransferService = mock(BlobStoreTransferService.class);
import org.opensearch.gateway.remote.RemoteClusterStateUtils;  
                        .add(RemoteClusterStateUtils.encodeString("test-cluster"))
            clusterSettings
            .put("cluster.remote_store.routing_table.path_hash_algo", RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1.toString())
        BlobPath blobPath = new BlobPath().add("base-path");  
import static org.mockito.Mockito.mock;
        assertEquals(RemoteStoreEnums.PathType.FIXED.toString(), remoteIndexRoutingTableStore.getPathTypeSetting().toString());
import org.opensearch.cluster.routing.IndexRoutingTable;  
        );
    public void testRemoteRoutingTableHashAlgoSetting() {
                    new BlobPath().add("base-path")  
        BlobPath expectedPath = HASHED_PREFIX.path(  
import org.opensearch.index.translog.transfer.BlobStoreTransferService;
import org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable;
            blobStoreTransferService,
                        .add("cluster-uuid")  
            .numberOfShards(1)
            "test-cluster",
            indexRoutingTable,
            remoteIndexRoutingTableStore.getPathHashAlgoSetting().toString()  
    private RemoteRoutingTableBlobStore<IndexRoutingTable, RemoteIndexRoutingTable> remoteIndexRoutingTableStore;  
            threadPool,
        assertEquals(expectedPath, blobPath);
    @Before
import org.opensearch.index.remote.RemoteStoreEnums;
import org.opensearch.core.index.Index;
            .build();
import org.opensearch.common.settings.ClusterSettings;  
import org.opensearch.test.OpenSearchTestCase;  
                .basePath(
            .build();  
            .put("cluster.remote_store.routing_table.path_type", RemoteStoreEnums.PathType.FIXED.toString())
            3L  
            new DeflateCompressor(),
                .build(),
import org.opensearch.common.compress.DeflateCompressor;
        clusterSettings.applySettings(newSettings);
        clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);  
            .put(IndexMetadata.SETTING_INDEX_UUID, index.getUUID())  
        super.tearDown();
        assertEquals(
        // Assert the default is FNV_1A_BASE64  
            .numberOfReplicas(0)
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
package org.opensearch.gateway.remote.model;
import org.opensearch.index.remote.RemoteStorePathStrategy;  
import static org.opensearch.index.remote.RemoteStoreEnums.PathHashAlgorithm.FNV_1A_BASE64;
        clusterSettings.applySettings(newSettings);  
    public void setup() {
            FNV_1A_BASE64
import org.opensearch.common.blobstore.BlobPath;
        Index index = new Index("test-idx", "index-uuid");  
        // Assert the default is HASHED_PREFIX
        threadPool.shutdown();
            RemoteStoreEnums.PathHashAlgorithm.FNV_1A_COMPOSITE_1.toString(),
import org.junit.Before;
        );  
    }  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.threadpool.ThreadPool;
        assertEquals(HASHED_PREFIX.toString(), remoteIndexRoutingTableStore.getPathTypeSetting().toString());
            .build();
            "cluster-uuid",  
            blobStoreRepository,  
        Settings newSettings = Settings.builder()  
        RemoteIndexRoutingTable remoteObjectForUpload = new RemoteIndexRoutingTable(
import static org.opensearch.gateway.remote.RemoteClusterStateUtils.CLUSTER_STATE_PATH_TOKEN;  
    }
        BlobPath blobPath = remoteIndexRoutingTableStore.getBlobPathForUpload(remoteObjectForUpload);
import org.opensearch.cluster.metadata.IndexMetadata;
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.gateway.remote.routingtable.RemoteIndexRoutingTable.INDEX_ROUTING_TABLE;
            RemoteStorePathStrategy.PathInput.builder()
        threadPool = new TestThreadPool(getClass().getName());  
        when(blobStoreRepository.basePath()).thenReturn(blobPath);
public class RemoteRoutingTableBlobStoreTests extends OpenSearchTestCase {
/*  
}  
    public void testRemoteRoutingTablePathTypeSetting() {  
        assertEquals(FNV_1A_BASE64.toString(), remoteIndexRoutingTableStore.getPathHashAlgoSetting().toString());
