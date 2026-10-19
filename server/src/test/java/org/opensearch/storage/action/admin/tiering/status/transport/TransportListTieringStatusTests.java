        shardStatusMap.put("IN_PROGRESS", 1);  
                response -> response.getTieringStatusList().size() == 2
        BytesStreamOutput out = new BytesStreamOutput();  
        ListTieringStatusRequest request = new ListTieringStatusRequest("WARM");  
import static org.mockito.Mockito.verify;  
        assertTrue(deserialized.getTieringStatusList().isEmpty());
import java.util.HashMap;
        action.clusterManagerOperation(request, clusterState, listener);
        action.clusterManagerOperation(request, clusterState, listener);
    public void testCheckBlock() {
import org.opensearch.threadpool.ThreadPool;  
        // Arrange  
            argThat(  
    @Before
        status.setStartTime(System.currentTimeMillis());  
    }  
        // Act
        // Act  
    @Mock  
        StreamInput in = out.bytes().streamInput();
    private TransportService transportService;  
        verify(listener).onResponse(
            argThat(response -> response.getTieringStatusList().size() == 2 && response.getTieringStatusList().equals(expectedStatus))
        Map<String, Integer> shardStatusMap = new HashMap<>();
import static org.mockito.Mockito.when;
    @Mock
 *
import org.opensearch.storage.action.tiering.status.transport.TransportListTieringStatusAction;
        ClusterBlockException result = action.checkBlock(request, clusterState);
    public void testReadResponse() throws Exception {  
import org.opensearch.storage.action.tiering.status.model.TieringStatus;
    private ThreadPool threadPool;
import org.opensearch.cluster.ClusterState;
        when(hotToWarmTieringService.listTieringStatus()).thenReturn(expectedStatus);
public class TransportListTieringStatusTests extends OpenSearchTestCase {  
        List<TieringStatus> expectedStatus = Arrays.asList(createDummyTieringStatus("index1"), createDummyTieringStatus("index2"));
    private TransportListTieringStatusAction action;
            argThat(response -> response.getTieringStatusList().size() == 2 && response.getTieringStatusList().equals(expectedStatus))
    }
import static org.mockito.ArgumentMatchers.argThat;
        action = new TransportListTieringStatusAction(
        assertEquals(ThreadPool.Names.SAME, action.executor());
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
        status.setSource("hot");
        status.setStatus("RUNNING");
        status.setIndexName(indexName);
        // Assert
                    && response.getTieringStatusList().containsAll(hotToWarmStatus)
        // Arrange
            threadPool,
        when(hotToWarmTieringService.listTieringStatus()).thenReturn(hotToWarmStatus);
package org.opensearch.storage.action.admin.tiering.status.transport;
import java.util.Collections;  
    public void testClusterManagerOperation_WithoutTargetTier() throws IOException {
    public void testClusterManagerOperation_WithTargetTierHot() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.storage.tiering.WarmToHotTieringService;
import org.opensearch.action.support.ActionFilters;
import org.opensearch.core.common.io.stream.StreamInput;
        super.setUp();  
        ListTieringStatusRequest request = new ListTieringStatusRequest("HOT");
    }  
import org.opensearch.core.action.ActionListener;  
    }
import org.opensearch.storage.tiering.HotToWarmTieringService;  
import java.util.Map;  
import org.mockito.MockitoAnnotations;  
    @Mock
import org.opensearch.transport.TransportService;
 */  
        MockitoAnnotations.openMocks(this);
import org.opensearch.cluster.block.ClusterBlockLevel;
    }
    private ClusterBlocks clusterBlocks;
import org.junit.Before;
        when(clusterState.blocks()).thenReturn(clusterBlocks);  
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusResponse;  
        // Arrange
}
        String targetTier = null;  
    private ActionListener<ListTieringStatusResponse> listener;  
        verify(listener).onResponse(  
                    && response.getTieringStatusList().containsAll(warmToHotStatus)  
    public void testExecutor() {  
import org.opensearch.common.io.stream.BytesStreamOutput;
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
    @Mock
        ListTieringStatusResponse original = new ListTieringStatusResponse(Collections.emptyList());
        TieringStatus status = new TieringStatus();  
    private WarmToHotTieringService warmToHotTieringService;
        // Arrange
            hotToWarmTieringService,  
    @Mock
    @Mock
import org.opensearch.cluster.block.ClusterBlocks;
        verify(listener).onResponse(
            transportService,  
        verify(clusterBlocks).globalBlockedException(ClusterBlockLevel.METADATA_READ);
    }  
        action.clusterManagerOperation(request, clusterState, listener);  
import org.mockito.Mock;
    private ClusterService clusterService;
        when(warmToHotTieringService.listTieringStatus()).thenReturn(warmToHotStatus);
    }
        shardStatusMap.put("COMPLETED", 0);
        ListTieringStatusRequest request = new ListTieringStatusRequest(targetTier);
        status.setShardLevelStatus(new TieringStatus.ShardLevelStatus(shardStatusMap, null));
            warmToHotTieringService,
import org.opensearch.storage.action.tiering.status.model.ListTieringStatusRequest;
        status.setTarget("warm");
import org.opensearch.cluster.service.ClusterService;
            )
/*  
            actionFilters,
        );  
    private ActionFilters actionFilters;
        String targetTier = null;
    @Mock
import java.util.Arrays;
import org.opensearch.cluster.block.ClusterBlockException;  
        original.writeTo(out);
    private IndexNameExpressionResolver indexNameExpressionResolver;  
        ListTieringStatusResponse deserialized = new ListTieringStatusResponse(in);
    private TieringStatus createDummyTieringStatus(String indexName) throws IOException {
        );
        // Assert
import java.io.IOException;
        List<TieringStatus> expectedStatus = Arrays.asList(createDummyTieringStatus("index1"), createDummyTieringStatus("index2"));
            clusterService,
    public void testClusterManagerOperation_WithTargetTierWarm() throws IOException {
            indexNameExpressionResolver  
 * this file be licensed under the Apache-2.0 license or a
    private HotToWarmTieringService hotToWarmTieringService;  
    @Mock  
        List<TieringStatus> hotToWarmStatus = Arrays.asList(createDummyTieringStatus("index1"));
    public void setUp() throws Exception {
    private ClusterState clusterState;
    @Mock
        List<TieringStatus> warmToHotStatus = Arrays.asList(createDummyTieringStatus("index2"));
        return status;  
        // Act
import org.opensearch.test.OpenSearchTestCase;
    }  
        );
 * compatible open source license.
        // Assert  
        );
    @Mock  
        when(warmToHotTieringService.listTieringStatus()).thenReturn(expectedStatus);  
        ListTieringStatusRequest request = new ListTieringStatusRequest(targetTier);
        // Assert
        // Act
