        mockResolver = mock(IndexNameExpressionResolver.class);
            }
        ClusterState state = ClusterState.builder(new ClusterName("test"))
        when(mockTransportService.getTaskManager()).thenReturn(null);
                responseRef.set(response);
import org.opensearch.test.OpenSearchTestCase;
                                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
            public void onResponse(RemoteStoreMetadataResponse response) {
        assertEquals(1, responseRef.get().getTotalShards());
        request.indices(TEST_INDEX);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            false,
package org.opensearch.action.admin.cluster.remotestore.metadata;
import org.opensearch.core.action.ActionListener;
                fail("Should handle as shard failure, not exception");
    private ActionFilters mockActionFilters;
                            .settings(
            public void onResponse(RemoteStoreMetadataResponse response) {
public class TransportRemoteStoreMetadataActionTests extends OpenSearchTestCase {
import org.opensearch.common.settings.Settings;
            mockRemoteStoreSettings
        assertTrue(responseRef.get().getShardFailures()[0].reason().contains("Remote store not enabled"));
        when(mockResolver.concreteIndexNames(any(), any())).thenReturn(new String[] { TEST_INDEX });
                responseRef.set(response);
    }
        RemoteStoreMetadataRequest request = new RemoteStoreMetadataRequest();
    private RemoteStoreSettings mockRemoteStoreSettings;
        action.doExecute(null, request, new ActionListener<>() {
        when(mockResolver.concreteIndexNames(any(), any())).thenReturn(new String[] { TEST_INDEX });
        );
                    .put(
        RemoteStoreMetadataRequest request = new RemoteStoreMetadataRequest();
                                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertNotNull(responseRef.get());
import org.opensearch.cluster.ClusterState;
import static org.mockito.Mockito.when;
            true,
        assertNotNull(responseRef.get());
        action = new TransportRemoteStoreMetadataAction(
    }
        ClusterState blockedState = ClusterState.builder(new ClusterName("test")).blocks(blocks).build();
                    )
            EnumSet.of(ClusterBlockLevel.METADATA_READ)
/*
    private static final String TEST_INDEX = "test-index";
import static org.mockito.ArgumentMatchers.any;
            public void onResponse(RemoteStoreMetadataResponse response) {
            true,
            @Override
        request.indices("dummy");
        when(mockClusterService.state()).thenReturn(state);
                fail("Should not fail");
                        IndexMetadata.builder(TEST_INDEX)
 */
import org.opensearch.cluster.block.ClusterBlock;
    private RepositoriesService mockRepositoriesService;
                                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import org.opensearch.threadpool.ThreadPool;
import org.opensearch.transport.TransportService;
import org.opensearch.Version;
        request.indices(TEST_INDEX);
            @Override
 * this file be licensed under the Apache-2.0 license or a
        );
    private TransportRemoteStoreMetadataAction action;
        });
    public void setup() {
            public void onFailure(Exception e) {
 *
        action.doExecute(null, request, new ActionListener<>() {
        });
            }
        assertEquals(0, responseRef.get().getSuccessfulShards());
                            )
        when(mockClusterService.getSettings()).thenReturn(Settings.EMPTY); // FIXED LINE
            mockResolver,
    public void testClusterBlocked() {
            @Override
import org.opensearch.cluster.block.ClusterBlockLevel;
        ClusterBlock block = new ClusterBlock(
            mockRepositoriesService,
            mockClusterService,
    private static final String INDEX_UUID = "uuid-test";
import org.opensearch.action.support.ActionFilters;
import static org.mockito.Mockito.mock;
        AtomicReference<Exception> exceptionRef = new AtomicReference<>();
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.block.ClusterBlocks;
            public void onFailure(Exception e) {
        });
    @Before
            )
            mockActionFilters,
            1,
            @Override
    private TransportService mockTransportService;
            "metadata_read_block",
        AtomicReference<RemoteStoreMetadataResponse> responseRef = new AtomicReference<>();
        assertNotNull(exceptionRef.get());
        mockActionFilters = mock(ActionFilters.class);
        when(mockClusterService.state()).thenReturn(ClusterState.EMPTY_STATE);
import java.util.concurrent.atomic.AtomicReference;
                                    .put(IndexMetadata.SETTING_REMOTE_STORE_ENABLED, false)
                exceptionRef.set(e);
    public void testEmptyIndexReturnsEmptyResponse() {
            public void onFailure(Exception e) {
            @Override
        RemoteStoreMetadataRequest request = new RemoteStoreMetadataRequest();
    }
        mockTransportService = mock(TransportService.class);
                fail("Expected failure due to cluster block");
 * The OpenSearch Contributors require contributions made to
import java.util.EnumSet;
}
        ClusterBlocks blocks = ClusterBlocks.builder().addGlobalBlock(block).build();
    private ClusterService mockClusterService;
        mockRemoteStoreSettings = mock(RemoteStoreSettings.class);
        assertEquals(0, responseRef.get().getSuccessfulShards());
import org.opensearch.cluster.ClusterName;
import org.opensearch.indices.RemoteStoreSettings;
        action.doExecute(null, request, new ActionListener<>() {
                                    .put(IndexMetadata.SETTING_INDEX_UUID, INDEX_UUID)
            }
        AtomicReference<RemoteStoreMetadataResponse> responseRef = new AtomicReference<>();
        mockThreadPool = mock(ThreadPool.class);
            }
        assertEquals(0, responseRef.get().getFailedShards());
            null,
        assertEquals(1, responseRef.get().getFailedShards());
    private ThreadPool mockThreadPool;
    }
                                Settings.builder()
        when(mockResolver.concreteIndexNames(any(), any())).thenReturn(new String[0]);
        mockRepositoriesService = mock(RepositoriesService.class);
            .build();
        assertTrue(exceptionRef.get().getMessage().toLowerCase(Locale.ROOT).contains("blocked"));
        when(mockClusterService.state()).thenReturn(blockedState);
        mockClusterService = mock(ClusterService.class);
                Metadata.builder()
            }
    public void testRemoteStoreDisabledIndex() {
import org.opensearch.repositories.RepositoriesService;
            @Override
import org.opensearch.cluster.metadata.IndexMetadata;
import org.opensearch.cluster.service.ClusterService;
            mockTransportService,
import java.util.Locale;
import org.junit.Before;
    private IndexNameExpressionResolver mockResolver;
import org.opensearch.cluster.metadata.Metadata;
            .metadata(
            mockThreadPool,
            }
        assertEquals(0, responseRef.get().getTotalShards());
        request.shards("0");
