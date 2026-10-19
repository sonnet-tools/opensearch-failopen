        updateListenerCaptor.getValue().onResponse(new ClusterStateUpdateResponse(true));
import org.opensearch.common.util.concurrent.ThreadContext;
import org.mockito.MockitoAnnotations;  
public class TransportPutIndexFieldDomainsActionTests extends OpenSearchTestCase {  
import org.opensearch.transport.TransportService;
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomain(
    private MetadataIndexFieldDomainService fieldDomainService;
        );
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))
import org.opensearch.core.rest.RestStatus;
        assertThat(updateRequest.clusterManagerNodeTimeout(), equalTo(request.clusterManagerNodeTimeout()));
            .numberOfReplicas(0)
        doNothing().when(fieldDomainService).putFieldDomains(updateRequestCaptor.capture(), updateListenerCaptor.capture());  
            fieldDomainService,
    @Mock
    }
        );
        ArgumentCaptor<ActionListener<ClusterStateUpdateResponse>> updateListenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
        assertThat(action.resolveIndices(request), equalTo(ResolvedIndices.of(targetIndex)));
import org.opensearch.cluster.block.ClusterBlockLevel;
        Index targetIndex = new Index("logs-000001", "index-uuid");
        );
        assertTrue(exception.blocks().contains(metadataWriteBlock));  
        assertTrue(exception.blocks().contains(metadataWriteBlock));
/*  
    }  
package org.opensearch.action.admin.indices.fielddomain;
    }  
    private static ClusterBlock metadataWriteBlock() {
        ClusterState blockedState = clusterState(targetIndex, ClusterBlocks.builder().addGlobalBlock(metadataWriteBlock).build());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.metadata.MetadataIndexFieldDomainService;  
                    .put(IndexMetadata.SETTING_INDEX_UUID, targetIndex.getUUID())
 * compatible open source license.
    public void testClusterManagerOperationForwardsMetadataServiceFailure() {
    }
import org.opensearch.test.OpenSearchTestCase;  
            .numberOfShards(1)
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")
    public void testResolveIndicesReturnsExactTargetIndex() {
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    }
    private ThreadPool threadPool;  
    private ClusterState clusterState;
        IndexMetadata indexMetadata = IndexMetadata.builder(targetIndex.getName())  
            "metadata write block",
        ClusterState blockedState = clusterState(  
            1,  
        assertNotNull(exception);
            PutIndexFieldDomainsClusterStateUpdateRequest.class  
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomain(  
import org.opensearch.cluster.metadata.ResolvedIndices;
        when(actionFilters.filters()).thenReturn(new ActionFilter[0]);  
                    .build()
        assertThat(updateRequest.ackTimeout(), equalTo(request.timeout()));
import org.opensearch.common.settings.Settings;  
    }
import org.mockito.ArgumentCaptor;
        RuntimeException failure = new RuntimeException("boom");
        action.clusterManagerOperation(request, clusterState, listener);
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")
            transportService,
import org.opensearch.cluster.block.ClusterBlocks;
        );  
}  
import org.opensearch.core.action.ActionListener;
        Index targetIndex = new Index("logs-000001", "index-uuid");  
        updateListenerCaptor.getValue().onFailure(failure);  
        action.clusterManagerOperation(request, clusterState, listener);
        MockitoAnnotations.openMocks(this);
    @Mock  
        verify(listener).onFailure(failure);
        ArgumentCaptor<PutIndexFieldDomainsClusterStateUpdateRequest> updateRequestCaptor = ArgumentCaptor.forClass(
    @Mock
import org.opensearch.Version;
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomain(
                    .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        );  
            threadPool,
    private TransportService transportService;
    private ClusterService clusterService;
            .settings(
        verify(listener).onResponse(responseCaptor.capture());  
    }
        PutIndexFieldDomainsClusterStateUpdateRequest updateRequest = updateRequestCaptor.getValue();
        ArgumentCaptor<AcknowledgedResponse> responseCaptor = ArgumentCaptor.forClass(AcknowledgedResponse.class);
        ClusterBlock metadataWriteBlock = metadataWriteBlock();
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")
            EnumSet.of(ClusterBlockLevel.METADATA_WRITE)  
import org.opensearch.cluster.ClusterState;  
import org.opensearch.cluster.block.ClusterBlock;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;
        assertNull(action.checkBlock(request, clusterState(targetIndex, ClusterBlocks.EMPTY_CLUSTER_BLOCK)));
    @Mock
        doNothing().when(fieldDomainService).putFieldDomains(any(), updateListenerCaptor.capture());
        );
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(new Index("logs-000001", "index-uuid")).fieldDomain(
    @Before  
        assertTrue(responseCaptor.getValue().isAcknowledged());
import org.opensearch.cluster.ClusterName;
    public void setup() {
    public void testClusterManagerOperationDelegatesToMetadataService() {
import org.junit.Before;  
                Settings.builder()
            )  
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")  
import org.opensearch.threadpool.ThreadPool;
        ArgumentCaptor<ActionListener<ClusterStateUpdateResponse>> updateListenerCaptor = ArgumentCaptor.forClass(ActionListener.class);
import static org.mockito.Mockito.doNothing;
            ClusterBlocks.builder().addIndexBlock(targetIndex.getName(), metadataWriteBlock).build()
            targetIndex,
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")
    @Mock
        );  
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomain(
    private TransportPutIndexFieldDomainsAction action;
            .build();  
        ClusterBlockException exception = action.checkBlock(request, blockedState);  
        );
            clusterService,  
            actionFilters,  
            false,
import static org.mockito.Mockito.verify;  
import static org.hamcrest.Matchers.sameInstance;  
import org.opensearch.cluster.metadata.Metadata;
import org.opensearch.cluster.service.ClusterService;
        return ClusterState.builder(new ClusterName("test")).metadata(Metadata.builder().put(indexMetadata, true)).blocks(blocks).build();
import java.util.EnumSet;
            new DateRangeFieldDomain("@timestamp", 100L, 200L, true, "test_producer")  
    private static ClusterState clusterState(Index targetIndex, ClusterBlocks blocks) {
            RestStatus.FORBIDDEN,
    public void testCheckBlockAllowsUnblockedState() {
import org.opensearch.cluster.ack.ClusterStateUpdateResponse;
    public void testCheckBlockRejectsGlobalMetadataWriteBlock() {
 * The OpenSearch Contributors require contributions made to  
        Index targetIndex = new Index("logs-000001", "index-uuid");
 */  
 *
        Index targetIndex = new Index("logs-000001", "index-uuid");
import org.opensearch.cluster.metadata.IndexMetadata;  
        ClusterBlock metadataWriteBlock = metadataWriteBlock();  
        );
        Index targetIndex = new Index("logs-000001", "index-uuid");  
    public void testCheckBlockRejectsIndexMetadataWriteBlock() {  
            false,
        assertThat(updateRequest.fieldDomainCustomData(), equalTo(request.fieldDomainCustomData()));  
import org.opensearch.index.fielddomain.DateRangeFieldDomain;
    }
    private ActionListener<AcknowledgedResponse> listener;  
 * this file be licensed under the Apache-2.0 license or a
        ClusterBlockException exception = action.checkBlock(request, blockedState);
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
import org.opensearch.cluster.block.ClusterBlockException;  
import static org.hamcrest.Matchers.equalTo;
        action = new TransportPutIndexFieldDomainsAction(
    }  
        PutIndexFieldDomainsRequest request = new PutIndexFieldDomainsRequest(targetIndex).fieldDomain(  
import org.opensearch.core.index.Index;  
            false,  
    private ActionFilters actionFilters;
import org.opensearch.action.support.ActionFilter;
        );
        assertNotNull(exception);
        return new ClusterBlock(
        assertThat(updateRequest.targetIndex(), sameInstance(targetIndex));
import org.opensearch.action.support.ActionFilters;  
    @Mock
    @Mock  
