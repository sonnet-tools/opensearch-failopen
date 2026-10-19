import org.junit.Before;
import org.opensearch.cluster.metadata.Metadata;
 *
 * SPDX-License-Identifier: Apache-2.0
        when(indexMetadata.getSettings()).thenReturn(settings);  
public class TransportGetTieringStatusTests extends OpenSearchTestCase {
    private ActionFilters actionFilters;  
    private ClusterService clusterService;
        Index index = new Index("test-index", "uuid");
    @Before  
        action.clusterManagerOperation(request, clusterState, listener);
        // Arrange
import org.opensearch.storage.tiering.HotToWarmTieringService;
        // Act
        // Act
    private ClusterState clusterState;
        // Act  
            threadPool,  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
    }
            hotToWarmTieringService,
        action = new TransportGetTieringStatusAction(
    }
        // Arrange  
            warmToHotTieringService,
    private TransportService transportService;
        TieringStatus expectedStatus = new TieringStatus();  
    private IndexMetadata indexMetadata;
    public void testClusterManagerOperation_NullTieringState() {  
            actionFilters,
    public void setUp() throws Exception {
        when(indexMetadata.getSettings()).thenReturn(settings);
    @Mock
        verify(listener).onResponse(any(GetTieringStatusResponse.class));
    @Mock
        action.clusterManagerOperation(request, clusterState, listener);
        Settings settings = Settings.builder()  
        when(metadata.index(index)).thenReturn(indexMetadata);
        when(indexNameExpressionResolver.concreteIndices(any(), any(), any())).thenReturn(new Index[] { index });
        when(metadata.index(index)).thenReturn(indexMetadata);  
import org.opensearch.common.io.stream.BytesStreamOutput;
import org.opensearch.common.settings.Settings;
    private HotToWarmTieringService hotToWarmTieringService;  
/*  
        MockitoAnnotations.openMocks(this);  
        );  
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusRequest;
    private ActionListener<GetTieringStatusResponse> listener;
            indexNameExpressionResolver
    public void testExecutor() {
    @Mock
    @Mock  
    public void testReadResponse() throws Exception {
}  
        StreamInput in = out.bytes().streamInput();
import static org.mockito.ArgumentMatchers.any;  
import static org.mockito.Mockito.verify;
    public void testCheckBlock() {
    @Mock  
    public void testClusterManagerOperation_HotToWarmTiering() {  
    }  
    }
            .build();
    @Mock  
        action.clusterManagerOperation(request, clusterState, listener);  
    @Mock
    }
        // Act  
        GetTieringStatusResponse deserialized = new GetTieringStatusResponse(in);  
        original.writeTo(out);  
    public void testClusterManagerOperation_WithException() {
        when(indexNameExpressionResolver.concreteIndices(any(), any(), any())).thenThrow(new IllegalArgumentException("Test exception"));  
import org.opensearch.cluster.ClusterState;
        when(indexNameExpressionResolver.concreteIndices(any(), any(), any())).thenReturn(new Index[] { index });
import org.opensearch.cluster.metadata.IndexMetadata;  
            clusterService,  
    @Mock
import org.opensearch.storage.action.tiering.status.model.GetTieringStatusResponse;
        // Assert
    @Mock  
            .build();
import org.opensearch.core.common.io.stream.StreamInput;
    public void testClusterManagerOperation_WarmToHotTiering() {
import org.opensearch.core.index.Index;
        BytesStreamOutput out = new BytesStreamOutput();
import org.opensearch.core.action.ActionListener;  
    private ThreadPool threadPool;
    }
        Settings settings = Settings.builder()
        verify(listener).onResponse(any(GetTieringStatusResponse.class));
 */  
import org.opensearch.test.OpenSearchTestCase;
        GetTieringStatusResponse original = new GetTieringStatusResponse(status);  
        verify(listener).onFailure(any(IllegalArgumentException.class));  
import org.mockito.MockitoAnnotations;
        when(clusterState.getMetadata()).thenReturn(metadata);
 * The OpenSearch Contributors require contributions made to  
        super.setUp();
import org.opensearch.storage.action.tiering.status.transport.TransportGetTieringStatusAction;
    @Mock
    private TransportGetTieringStatusAction action;  
package org.opensearch.storage.action.admin.tiering.status.transport;
        // Assert  
        assertNull(action.checkBlock(request, clusterState));
        when(clusterService.state()).thenReturn(clusterState);
        TieringStatus expectedStatus = new TieringStatus();
import org.opensearch.storage.action.tiering.status.model.TieringStatus;  
        // Arrange
        when(warmToHotTieringService.getTieringStatus("test-index", false)).thenReturn(expectedStatus);
        when(hotToWarmTieringService.getTieringStatus("test-index", false)).thenReturn(expectedStatus);
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.HOT_TO_WARM.toString())
        assertEquals("test-index", deserialized.getTieringStatus().getIndexName());
        when(indexNameExpressionResolver.concreteIndices(any(), any(), any())).thenReturn(new Index[] { index });
import org.opensearch.cluster.service.ClusterService;  
import org.mockito.Mock;  
        action.clusterManagerOperation(request, clusterState, listener);
        when(clusterState.blocks()).thenReturn(mock(org.opensearch.cluster.block.ClusterBlocks.class));
    private IndexNameExpressionResolver indexNameExpressionResolver;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        request = new GetTieringStatusRequest();
    private GetTieringStatusRequest request;
        TieringStatus status = new TieringStatus("test-index", "RUNNING", "hot", "warm", 123L);
    }  
        // Assert
        request.setIndex("test-index");  
    @Mock
    }
        assertEquals(ThreadPool.Names.SAME, action.executor());  
        Settings settings = Settings.builder().build(); // No tiering state  
import static org.mockito.Mockito.when;  
        // Arrange
            transportService,
        Index index = new Index("test-index", "uuid");
import org.opensearch.transport.TransportService;  
import static org.mockito.Mockito.mock;
import org.opensearch.action.support.ActionFilters;
        Index index = new Index("test-index", "uuid");
    private WarmToHotTieringService warmToHotTieringService;
import org.opensearch.index.IndexModule;  
    private Metadata metadata;  
        when(indexMetadata.getSettings()).thenReturn(settings);
import org.opensearch.threadpool.ThreadPool;
        when(clusterState.blocks().globalBlockedException(any())).thenReturn(null);  
import org.opensearch.storage.tiering.WarmToHotTieringService;  
        when(metadata.index(index)).thenReturn(indexMetadata);  
            .put(IndexModule.INDEX_TIERING_STATE.getKey(), IndexModule.TieringState.WARM_TO_HOT.toString())  
