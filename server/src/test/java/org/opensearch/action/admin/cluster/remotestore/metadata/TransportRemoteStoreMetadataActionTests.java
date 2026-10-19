/*  
                responseRef.set(response);
                                    .put(IndexMetadata.SETTING_INDEX_UUID, INDEX_UUID)
    private ClusterService mockClusterService;
                                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
}
                fail("Expected failure due to cluster block");  
    private RepositoriesService mockRepositoriesService;
    private TransportRemoteStoreMetadataAction action;  
                responseRef.set(response);
                fail("Should handle as shard failure, not exception");  
            mockTransportService,
        ClusterBlocks blocks = ClusterBlocks.builder().addGlobalBlock(block).build();
            @Override
            mockRepositoriesService,
            )
        mockRepositoriesService = mock(RepositoriesService.class);  
            mockResolver,
        mockClusterService = mock(ClusterService.class);
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.test.OpenSearchTestCase;  
    }  
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.action.support.ActionFilters;
    private ThreadPool mockThreadPool;  
import static org.mockito.Mockito.when;
            @Override  
import org.opensearch.cluster.ClusterState;  
import static org.mockito.Mockito.mock;
import org.opensearch.cluster.block.ClusterBlocks;  
                    .put(  
import org.opensearch.threadpool.ThreadPool;
        when(mockResolver.concreteIndexNames(any(), any())).thenReturn(new String[] { TEST_INDEX });  
            public void onResponse(RemoteStoreMetadataResponse response) {  
            false,
                Metadata.builder()
            public void onResponse(RemoteStoreMetadataResponse response) {  
        assertEquals(0, responseRef.get().getSuccessfulShards());  
            EnumSet.of(ClusterBlockLevel.METADATA_READ)  
        when(mockClusterService.state()).thenReturn(ClusterState.EMPTY_STATE);  
        assertNotNull(exceptionRef.get());  
                exceptionRef.set(e);
        });
            true,  
            null,
                                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            @Override
import org.opensearch.indices.RemoteStoreSettings;
            @Override
        action.doExecute(null, request, new ActionListener<>() {  
            mockRemoteStoreSettings
        request.indices("dummy");
        mockResolver = mock(IndexNameExpressionResolver.class);
import java.util.concurrent.atomic.AtomicReference;
        assertTrue(exceptionRef.get().getMessage().toLowerCase(Locale.ROOT).contains("blocked"));
        assertTrue(responseRef.get().getShardFailures()[0].reason().contains("Remote store not enabled"));
        });
                    )
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            mockClusterService,
        assertEquals(0, responseRef.get().getSuccessfulShards());  
            @Override
        assertEquals(0, responseRef.get().getFailedShards());
            mockActionFilters,  
            }  
 */  
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        mockThreadPool = mock(ThreadPool.class);
            mockThreadPool,  
 * compatible open source license.
            }
 *
        assertNotNull(responseRef.get());
 * The OpenSearch Contributors require contributions made to  
                fail("Should not fail");  
            }
            }
                        IndexMetadata.builder(TEST_INDEX)
                            .settings(
        );
            public void onFailure(Exception e) {
        when(mockClusterService.getSettings()).thenReturn(Settings.EMPTY); // FIXED LINE
        when(mockResolver.concreteIndexNames(any(), any())).thenReturn(new String[0]);
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
    private IndexNameExpressionResolver mockResolver;  
import org.opensearch.transport.TransportService;
        ClusterState blockedState = ClusterState.builder(new ClusterName("test")).blocks(blocks).build();  
public class TransportRemoteStoreMetadataActionTests extends OpenSearchTestCase {
import org.opensearch.core.action.ActionListener;  
        when(mockClusterService.state()).thenReturn(state);
 * this file be licensed under the Apache-2.0 license or a
        mockRemoteStoreSettings = mock(RemoteStoreSettings.class);
            public void onFailure(Exception e) {
        when(mockTransportService.getTaskManager()).thenReturn(null);
        mockTransportService = mock(TransportService.class);  
        action.doExecute(null, request, new ActionListener<>() {
                                    .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
        assertEquals(1, responseRef.get().getFailedShards());
                            )  
    public void testEmptyIndexReturnsEmptyResponse() {
        action.doExecute(null, request, new ActionListener<>() {
            @Override
        RemoteStoreMetadataRequest request = new RemoteStoreMetadataRequest();
    }
            public void onFailure(Exception e) {
        when(mockResolver.concreteIndexNames(any(), any())).thenReturn(new String[] { TEST_INDEX });  
        ClusterState state = ClusterState.builder(new ClusterName("test"))  
    }
        });
import org.opensearch.Version;  
    @Before  
        request.indices(TEST_INDEX);  
        mockActionFilters = mock(ActionFilters.class);
import org.opensearch.cluster.block.ClusterBlockLevel;
        RemoteStoreMetadataRequest request = new RemoteStoreMetadataRequest();
            true,
    public void testRemoteStoreDisabledIndex() {
import java.util.EnumSet;
        assertEquals(1, responseRef.get().getTotalShards());
        );
            .build();  
            }
        ClusterBlock block = new ClusterBlock(
    private RemoteStoreSettings mockRemoteStoreSettings;
import org.opensearch.repositories.RepositoriesService;
        action = new TransportRemoteStoreMetadataAction(  
import org.opensearch.cluster.ClusterName;
import org.junit.Before;  
        request.shards("0");
    private static final String TEST_INDEX = "test-index";  
import java.util.Locale;  
        AtomicReference<RemoteStoreMetadataResponse> responseRef = new AtomicReference<>();  
        AtomicReference<RemoteStoreMetadataResponse> responseRef = new AtomicReference<>();  
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(0, responseRef.get().getTotalShards());
import org.opensearch.common.settings.Settings;
    public void testClusterBlocked() {
                                Settings.builder()  
            }
            public void onResponse(RemoteStoreMetadataResponse response) {
    public void setup() {
        assertNotNull(responseRef.get());
    private ActionFilters mockActionFilters;
            .metadata(
import org.opensearch.cluster.block.ClusterBlock;
        request.indices(TEST_INDEX);  
        RemoteStoreMetadataRequest request = new RemoteStoreMetadataRequest();  
package org.opensearch.action.admin.cluster.remotestore.metadata;
            "metadata_read_block",
    private static final String INDEX_UUID = "uuid-test";
            1,  
    private TransportService mockTransportService;
    }  
import static org.mockito.ArgumentMatchers.any;  
import org.opensearch.cluster.metadata.Metadata;  
        when(mockClusterService.state()).thenReturn(blockedState);
