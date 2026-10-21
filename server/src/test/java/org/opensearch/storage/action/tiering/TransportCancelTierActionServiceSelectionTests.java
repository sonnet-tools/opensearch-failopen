        verify(hotToWarmTieringService).cancelTiering(any(CancelTieringRequest.class), any(), eq(state));
    public void testTerminalHotNotTracked_RejectsCancel() throws Exception {
        Index index = state.metadata().index(INDEX_NAME).getIndex();
import org.opensearch.storage.tiering.WarmToHotTieringService;
        invokeCancel(state, listener);
    private WarmToHotTieringService warmToHotTieringService;
        ClusterState state = clusterStateWithTieringState(IndexModule.TieringState.WARM_TO_HOT);
    @SuppressWarnings("unchecked")
            transportService,
 *
import static org.mockito.ArgumentMatchers.any;
        verify(warmToHotTieringService, never()).cancelTiering(any(), any(), any());
        ClusterState state = ClusterState.builder(ClusterName.DEFAULT).metadata(metadata).build();
            .build();
import org.opensearch.test.OpenSearchTestCase;
     * Builds a cluster state containing the index with the given persisted tiering state, and wires the
        ClusterService clusterService = mock(ClusterService.class);
 * this file be licensed under the Apache-2.0 license or a
}
import org.opensearch.cluster.ClusterName;
        ClusterState state = clusterStateWithTieringState(IndexModule.TieringState.HOT);
    /** Not tracked in memory + persisted WARM_TO_HOT → warm-to-hot service handles the cancel. */
        );
        invokeCancel(state, listener);
import static org.mockito.Mockito.mock;
     * index-name resolver to resolve INDEX_NAME to that index. Returns the resolved Index.
    private TransportCancelTierAction action;
import org.junit.Before;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
    }
        super.setUp();
        invokeCancel(state, listener);
 * which tiering service handles a cancel. Verifies the in-memory tracking takes precedence, and that
import static org.mockito.ArgumentMatchers.eq;
 * (the failover fallback) or rejects the cancel for terminal states.
    /** Not tracked in memory + persisted HOT_TO_WARM → hot-to-warm service handles the cancel. */
    }
public class TransportCancelTierActionServiceSelectionTests extends OpenSearchTestCase {
        ClusterState state = clusterStateWithTieringState(IndexModule.TieringState.WARM);
    private ClusterState clusterStateWithTieringState(IndexModule.TieringState tieringState) {
    public void testPersistedWarmToHot_SelectsWarmToHotService_WhenNotTracked() throws Exception {
 * compatible open source license.
        when(indexNameExpressionResolver.concreteIndices(any(ClusterState.class), any(), eq(INDEX_NAME))).thenReturn(new Index[] { index });
        action.clusterManagerOperation(request, state, listener);
 * {@code cancelTiering} is invoked, since {@code getTieringServiceForIndex} itself is private.
    /** In-memory tracking takes precedence over persisted state (even a terminal one). */
    }
            indexNameExpressionResolver,
import org.opensearch.cluster.metadata.Metadata;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        indexNameExpressionResolver = mock(IndexNameExpressionResolver.class);
        assertTrue(failure.getValue() instanceof IllegalArgumentException);
import org.opensearch.storage.tiering.HotToWarmTieringService;
        ActionFilters actionFilters = mock(ActionFilters.class);
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
        Settings idxSettings = Settings.builder()
        assertTrue(failure.getValue().getMessage().contains("is not currently undergoing tiering operation"));
import org.opensearch.common.settings.Settings;
        request.setIndex(INDEX_NAME);
    @SuppressWarnings("unchecked")
        // Neither service tracks it (mock default is false).
    private static final String INDEX_NAME = "cancel-svc-idx";
 */
    public void testInMemoryTrackingTakesPrecedence_OverPersistedState() throws Exception {
 * These drive the protected {@code clusterManagerOperation} (same package) and assert which service's
 * SPDX-License-Identifier: Apache-2.0
        Index index = metadata.index(INDEX_NAME).getIndex();
        return state;
    @SuppressWarnings("unchecked")
        invokeCancel(state, listener);
    }
            .put(INDEX_TIERING_STATE.getKey(), tieringState.toString())
        ThreadPool threadPool = mock(ThreadPool.class);
        verify(hotToWarmTieringService, never()).cancelTiering(any(), any(), any());
        action = new TransportCancelTierAction(
/*
        verify(hotToWarmTieringService).cancelTiering(any(CancelTieringRequest.class), any(), eq(state));
import org.opensearch.transport.TransportService;
        ClusterState state = clusterStateWithTieringState(IndexModule.TieringState.HOT_TO_WARM);
    private IndexNameExpressionResolver indexNameExpressionResolver;
    public void setUp() throws Exception {
 */
        Metadata metadata = Metadata.builder().put(indexMetadata, false).build();
import static org.mockito.Mockito.when;
    private HotToWarmTieringService hotToWarmTieringService;
        verify(hotToWarmTieringService, never()).cancelTiering(any(), any(), any());
    }
        verify(warmToHotTieringService).cancelTiering(any(CancelTieringRequest.class), any(), eq(state));
    }
        ArgumentCaptor<Exception> failure = ArgumentCaptor.forClass(Exception.class);
    /**
import org.opensearch.Version;
/**
    public void testPersistedHotToWarm_SelectsHotToWarmService_WhenNotTracked() throws Exception {
            threadPool,
        verify(warmToHotTieringService, never()).cancelTiering(any(), any(), any());
 * when neither service tracks the index, the persisted INDEX_TIERING_STATE selects the service
        // Persisted state is terminal WARM, but the H2W service still tracks it in memory → it wins.
import org.mockito.ArgumentCaptor;
    private void invokeCancel(ClusterState state, ActionListener<AcknowledgedResponse> listener) throws Exception {
    @SuppressWarnings("unchecked")
            .put(IndexMetadata.SETTING_INDEX_UUID, "uuid-" + INDEX_NAME)
        hotToWarmTieringService = mock(HotToWarmTieringService.class);
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
            hotToWarmTieringService,
import org.opensearch.cluster.ClusterState;
import static org.opensearch.index.IndexModule.INDEX_TIERING_STATE;
            clusterService,
        verify(listener).onFailure(failure.capture());
 * The OpenSearch Contributors require contributions made to
import org.opensearch.action.support.ActionFilters;
import org.opensearch.threadpool.ThreadPool;
        CancelTieringRequest request = new CancelTieringRequest();
        verify(warmToHotTieringService, never()).cancelTiering(any(), any(), any());
        ActionListener<AcknowledgedResponse> listener = mock(ActionListener.class);
     */
import org.opensearch.core.action.ActionListener;
        TransportService transportService = mock(TransportService.class);
        IndexMetadata indexMetadata = IndexMetadata.builder(INDEX_NAME).settings(idxSettings).build();
            actionFilters,
package org.opensearch.storage.action.tiering;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import static org.mockito.Mockito.verify;
import org.opensearch.index.IndexModule;
import static org.mockito.Mockito.never;
    @Before
        when(hotToWarmTieringService.isIndexBeingTiered(index)).thenReturn(true);
            warmToHotTieringService
import org.opensearch.cluster.metadata.IndexMetadata;
        warmToHotTieringService = mock(WarmToHotTieringService.class);
import org.opensearch.core.index.Index;
    }
    /** Not tracked in memory + terminal HOT → no service selected, cancel rejected. */
 * <p>
import org.opensearch.cluster.service.ClusterService;
 * Unit tests for {@link TransportCancelTierAction#getTieringServiceForIndex} — the logic that picks
