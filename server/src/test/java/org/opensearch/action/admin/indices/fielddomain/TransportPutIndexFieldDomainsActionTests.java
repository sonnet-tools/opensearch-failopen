    private ThreadPool threadPool;
        Index targetIndex = new Index("logs-000001", "index-uuid");
            false,
            .numberOfShards(1)
            .settings(
            1,
 *
    private static ClusterState clusterState(Index targetIndex, ClusterBlocks blocks) {
    @Mock
        assertThat(updateRequest.ackTimeout(), equalTo(request.timeout()));
        return new ClusterBlock(
        assertTrue(exception.blocks().contains(metadataWriteBlock));
    }
        ClusterBlock metadataWriteBlock = metadataWriteBlock();
    }
    public void testCheckBlockRejectsIndexMetadataWriteBlock() {
    private TransportPutIndexFieldDomainsAction action;
import static org.hamcrest.Matchers.equalTo;
    private ClusterState clusterState;
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomain(
        ArgumentCaptor<ActionListener<ClusterStateUpdateResponse>> updateListenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
    public void setup() {
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import static org.mockito.ArgumentMatchers.any;
        ArgumentCaptor<PutIndexFieldDomainsClusterStateUpdateRequest> updateRequestCaptor = ArgumentCaptor.forClass(
        );
    }
import org.opensearch.common.settings.Settings;
            clusterService,
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")
        );
        IndexMetadata indexMetadata = IndexMetadata.builder(targetIndex.getName())
    public void testCheckBlockAllowsUnblockedState() {
        );
import org.mockito.MockitoAnnotations;
    private ClusterService clusterService;
        ClusterBlockException exception = action.checkBlock(request, blockedState);
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
        assertThat(updateRequest.fieldDomainCustomData(), equalTo(request.fieldDomainCustomData()));
            PutIndexFieldDomainsClusterStateUpdateRequest.class
    }
 * The OpenSearch Contributors require contributions made to
        updateListenerCaptor.getValue().onResponse(new ClusterStateUpdateResponse(true));
import org.opensearch.Version;
        doNothing().when(fieldDomainService).putFieldDomains(any(), updateListenerCaptor.capture());
import org.opensearch.cluster.block.ClusterBlock;
        updateListenerCaptor.getValue().onFailure(failure);
            fieldDomainService,
            )
    @Mock
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")
import org.opensearch.transport.TransportService;
package org.opensearch.action.admin.indices.fielddomain;
            false,
        Index targetIndex = new Index("logs-000001", "index-uuid");
        );
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import static org.mockito.Mockito.doNothing;
            .build();
        assertTrue(exception.blocks().contains(metadataWriteBlock));
            RestStatus.FORBIDDEN,
import static org.mockito.Mockito.when;
import org.opensearch.cluster.metadata.ResolvedIndices;
    }
    private MetadataIndexFieldDomainService fieldDomainService;
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomain(
 * compatible open source license.
        );
        );
    public void testClusterManagerOperationDelegatesToMetadataService() {
    public void testResolveIndicesReturnsExactTargetIndex() {
        action.clusterManagerOperation(request, clusterState, listener);
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
import org.mockito.Mock;
    @Mock
        assertThat(action.resolveIndices(request), equalTo(ResolvedIndices.of(targetIndex)));
import org.opensearch.cluster.block.ClusterBlockException;
import org.opensearch.cluster.metadata.IndexMetadata;
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")
 * this file be licensed under the Apache-2.0 license or a
    private ActionFilters actionFilters;
        ClusterBlock metadataWriteBlock = metadataWriteBlock();
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomain(
        verify(listener).onFailure(failure);
            ClusterBlocks.builder().addIndexBlock(targetIndex.getName(), metadataWriteBlock).build()
    }
import org.mockito.ArgumentCaptor;
        ClusterBlockException exception = action.checkBlock(request, blockedState);
/*
        doNothing().when(fieldDomainService).putFieldDomains(updateRequestCaptor.capture(), updateListenerCaptor.capture());
        RuntimeException failure = new RuntimeException("boom");
}
                Settings.builder()
        assertThat(updateRequest.clusterManagerNodeTimeout(), equalTo(request.clusterManagerNodeTimeout()));
    }
    @Mock
        );
        Index targetIndex = new Index("logs-000001", "index-uuid");
            transportService,
            .numberOfReplicas(0)
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")
import org.opensearch.threadpool.ThreadPool;
            "metadata write block",
        action = new TransportPutIndexFieldDomainsAction(
    }
        action.clusterManagerOperation(request, clusterState, listener);
        MockitoAnnotations.openMocks(this);
        );
        Index targetIndex = new Index("logs-000001", "index-uuid");
import org.opensearch.core.action.ActionListener;
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")
            EnumSet.of(ClusterBlockLevel.METADATA_WRITE)
    }
import org.opensearch.cluster.ClusterState;
    @Mock
 * SPDX-License-Identifier: Apache-2.0
            actionFilters,
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.common.util.concurrent.ThreadContext;
        assertTrue(responseCaptor.getValue().isAcknowledged());
import org.opensearch.action.support.ActionFilter;
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomain(
public class TransportPutIndexFieldDomainsActionTests extends OpenSearchTestCase {
import static org.mockito.Mockito.verify;
    @Mock
            threadPool,
import org.opensearch.cluster.metadata.Metadata;
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(new Index("logs-000001", "index-uuid")).fieldDomain(
                    .put(IndexMetadata.SETTING_INDEX_UUID, targetIndex.getUUID())
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
        ArgumentCaptor<AcknowledgedResponse> responseCaptor = ArgumentCaptor.forClass(AcknowledgedResponse.class);
import org.opensearch.cluster.ClusterName;
        ClusterState blockedState = clusterState(targetIndex, ClusterBlocks.builder().addGlobalBlock(metadataWriteBlock).build());
    @Mock
import org.opensearch.cluster.block.ClusterBlocks;
    private static ClusterBlock metadataWriteBlock() {
import org.opensearch.core.rest.RestStatus;
import org.junit.Before;
import org.opensearch.cluster.metadata.MetadataIndexFieldDomainService;
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomain(
    public void testCheckBlockRejectsGlobalMetadataWriteBlock() {
        assertNotNull(exception);
        Index targetIndex = new Index("logs-000001", "index-uuid");
    private ActionListener<AcknowledgedResponse> listener;
        );
            false,
        assertNotNull(exception);
        verify(listener).onResponse(responseCaptor.capture());
    @Before
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);
        assertThat(updateRequest.targetIndex(), sameInstance(targetIndex));
        assertNull(action.checkBlock(request, clusterState(targetIndex, ClusterBlocks.EMPTY_CLUSTER_BLOCK)));
import java.util.EnumSet;
 */
import org.opensearch.action.support.ActionFilters;
import org.opensearch.cluster.service.ClusterService;
import static org.hamcrest.Matchers.sameInstance;
        ArgumentCaptor<ActionListener<ClusterStateUpdateResponse>> updateListenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
        return ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().put(indexMetadata, true)).blocks(blocks).build();
    public void testClusterManagerOperationForwardsMetadataServiceFailure() {
                    .build()
    private TransportService transportService;
        ClusterState blockedState = clusterState(
import org.opensearch.cluster.block.ClusterBlockLevel;
            targetIndex,
import org.opensearch.core.index.Index;
        PutIndexFieldDomainsClusterStateUpdateRequest updateRequest = updateRequestCaptor.getValue();
        );
