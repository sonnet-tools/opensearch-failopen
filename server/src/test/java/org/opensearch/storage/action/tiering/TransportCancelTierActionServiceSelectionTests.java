     * Builds a cluster state containing the index with the given persisted tiering state, and wires the  
    }  
import static org.mockito.Mockito.verify;
        verify(listener).onFailure(failure.capture());  
 * when neither service tracks the index, the persisted INDEX_TIERING_STATE selects the service
        );
 * The OpenSearch Contributors require contributions made to  
        when(hotToWarmTieringService.isIndexBeingTiered(index)).thenReturn(true);
 *
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
            warmToHotTieringService
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid-" + INDEX_NAME)  
    /** Not tracked in memory + persisted WARM_TO_HOT → warm-to-hot service handles the cancel. */  
        Metadata metadata = Metadata.builder().put(indexMetadata, false).build();  
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
    @SuppressWarnings("unchecked")
import org.opensearch.index.IndexModule;
 * These drive the protected {@code clusterManagerOperation} (same package) and assert which service's
     */
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        Index index = metadata.index(INDEX_NAME).getIndex();  
/**
    private static final String INDEX_NAME = "cancel-svc-idx";  
    private TransportCancelTierAction action;
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);  
            transportService,
        verify(warmToHotTieringService, never()).cancelTiering(any(), any(), any());  
    }  
        return state;
    private IndexNameExpressionResolver indexNameExpressionResolver;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
        action = new TransportCancelTierAction(  
    @Before
    public void testInMemoryTrackingTakesPrecedence_OverPersistedState() throws Exception {
    @SuppressWarnings("unchecked")
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
import org.opensearch.storage.tiering.WarmToHotTieringService;  
        ClusterState state = clusterStateWithTieringState(IndexModule.TieringState.WARM);  
    private ClusterState clusterStateWithTieringState(IndexModule.TieringState tieringState) {  
    public void testTerminalHotNotTracked_RejectsCancel() throws Exception {
            clusterService,
        CancelTieringRequest request = new CancelTieringRequest();  
 * which tiering service handles a cancel. Verifies the in-memory tracking takes precedence, and that  
 */  
 * (the failover fallback) or rejects the cancel for terminal states.
 * {@code cancelTiering} is invoked, since {@code getTieringServiceForIndex} itself is private.
        assertTrue(failure.getValue() instanceof IllegalArgumentException);
import static org.mockito.Mockito.mock;
        when(indexNameExpressionResolver.concreteIndices(any(ClusterState.class), any(), eq(INDEX_NAME))).thenReturn(new Index[] { index });
    private WarmToHotTieringService warmToHotTieringService;
    @SuppressWarnings("unchecked")  
 * SPDX-License-Identifier: Apache-2.0
        verify(warmToHotTieringService, never()).cancelTiering(any(), any(), any());  
import org.opensearch.storage.tiering.HotToWarmTieringService;
    private void invokeCancel(ClusterState state, ActionListener<AcknowledgedResponse> listener) throws Exception {
import static org.mockito.ArgumentMatchers.any;  
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
public class TransportCancelTierActionServiceSelectionTests extends OpenSearchTestCase {
    /** In-memory tracking takes precedence over persisted state (even a terminal one). */
    /** Not tracked in memory + persisted HOT_TO_WARM → hot-to-warm service handles the cancel. */
            hotToWarmTieringService,  
    /**
 * compatible open source license.
        // Persisted state is terminal WARM, but the H2W service still tracks it in memory → it wins.
            actionFilters,
        indexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
        // Neither service tracks it (mock default is false).  
            .put(INDEX_TIERING_STATE.getKey(), tieringState.toString())  
        assertTrue(failure.getValue().getMessage().contains("is not currently undergoing tiering operation"));
package org.opensearch.storage.action.tiering;
import org.mockito.ArgumentCaptor;  
import org.opensearch.cluster.ClusterState;
    }
    @SuppressWarnings("unchecked")  
    }  
import org.opensearch.core.action.ActionListener;
        ThreadPool threadPool = mock(ThreadPool.class);  
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).build();
        verify(hotToWarmTieringService).cancelTiering(any(CancelTieringRequest.class), any(), eq(state));
import static org.mockito.Mockito.when;
        TransportService transportService = mock(TransportService.class);
     * index-name resolver to resolve INDEX_NAME to that index. Returns the resolved Index.
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        ClusterState state = clusterStateWithTieringState(IndexModule.TieringState.HOT_TO_WARM);
import org.junit.Before;
        ActionFilters actionFilters = mock(ActionFilters.class);
        hotToWarmTieringService = mock(HotToWarmTieringService.class);  
        Settings idxSettings = Settings.builder()
        ClusterService clusterService = mock(ClusterService.class);
 * <p>  
        verify(hotToWarmTieringService, never()).cancelTiering(any(), any(), any());
        super.setUp();  
    }  
/*  
    }  
import org.opensearch.test.OpenSearchTestCase;
        ClusterState state = clusterStateWithTieringState(IndexModule.TieringState.WARM_TO_HOT);  
import org.opensearch.cluster.metadata.Metadata;
        ArgumentCaptor<Exception> failure = ArgumentCaptor.forClass(Exception.class);
import org.opensearch.action.support.ActionFilters;
        Index index = state.metadata().index(INDEX_NAME).getIndex();
        invokeCancel(state, listener);  
import org.opensearch.common.settings.Settings;
}
        IndexMetadata indexMetadata = IndexMetadata.builder(INDEX_NAME).settings(idxSettings).build();
import org.opensearch.threadpool.ThreadPool;
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
 * Unit tests for {@link TransportCancelTierAction#getTieringServiceForIndex} — the logic that picks
import org.opensearch.transport.TransportService;  
        verify(warmToHotTieringService).cancelTiering(any(CancelTieringRequest.class), any(), eq(state));
    /** Not tracked in memory + terminal HOT → no service selected, cancel rejected. */  
        ClusterState state = clusterStateWithTieringState(IndexModule.TieringState.HOT);  
        invokeCancel(state, listener);  
import org.opensearch.cluster.service.ClusterService;  
    public void testPersistedHotToWarm_SelectsHotToWarmService_WhenNotTracked() throws Exception {
 */  
 * this file be licensed under the Apache-2.0 license or a
        invokeCancel(state, listener);  
import org.opensearch.Version;
import org.opensearch.core.index.Index;  
import static org.mockito.Mockito.never;  
        warmToHotTieringService = mock(WarmToHotTieringService.class);
    public void testPersistedWarmToHot_SelectsWarmToHotService_WhenNotTracked() throws Exception {
            indexNameExpressionResolver,
import org.opensearch.cluster.ClusterName;
import static org.mockito.ArgumentMatchers.eq;
        invokeCancel(state, listener);
    public void setUp() throws Exception {
        verify(hotToWarmTieringService, never()).cancelTiering(any(), any(), any());  
        request.setIndex(INDEX_NAME);
            threadPool,  
    private HotToWarmTieringService hotToWarmTieringService;  
        verify(hotToWarmTieringService).cancelTiering(any(CancelTieringRequest.class), any(), eq(state));
            .build();
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        action.clusterManagerOperation(request, state, listener);
        verify(warmToHotTieringService, never()).cancelTiering(any(), any(), any());
