            .put(index1, false)
/*  
import org.opensearch.cluster.ClusterName;
import org.opensearch.cluster.service.ClusterService;  
        when(clusterService.state()).thenReturn(clusterState);
            ResolvedIndices resolvedIndices = action.resolveIndices(new DataStreamsStatsAction.Request());  
import org.opensearch.cluster.ClusterState;  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))  
import org.opensearch.cluster.metadata.ResolvedIndices;
import static org.opensearch.cluster.DataStreamTestHelper.createBackingIndex;  
 * this file be licensed under the Apache-2.0 license or a
}
import org.opensearch.common.settings.Settings;
            assertEquals(ResolvedIndices.of("datastream-test"), resolvedIndices);
 *
        String dataStreamName = "datastream-test";
package org.opensearch.action.admin.indices.datastream;
            mock(IndicesService.class),
import org.opensearch.transport.TransportService;
    public void testResolveIndices() throws Exception {  
 */  
        IndexMetadata index1 = createBackingIndex(dataStreamName, 1).build();  
 * compatible open source license.
public class DataStreamStatsActionTests extends OpenSearchTestCase {
        ClusterService clusterService = mock(ClusterService.class);
import java.util.List;
            mock(ActionFilters.class),
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.cluster.metadata.Metadata;
        }  
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
import static org.mockito.Mockito.when;  
            clusterService,
            ResolvedIndices resolvedIndices = action.resolveIndices(new DataStreamsStatsAction.Request().indices("datastream-*"));
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
import org.opensearch.common.util.concurrent.ThreadContext;
import static org.mockito.Mockito.mock;
            mock(TransportService.class),  
        {
import org.opensearch.indices.IndicesService;  
import org.opensearch.cluster.metadata.IndexMetadata;
        }
    }  
        {  
import org.opensearch.cluster.metadata.DataStream;
        Metadata.Builder mdBuilder = Metadata.builder()  
        );
        IndexMetadata index2 = createBackingIndex(dataStreamName, 2).build();
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.support.ActionFilters;
        DataStreamsStatsAction.TransportAction action = new DataStreamsStatsAction.TransportAction(
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(index1.getIndex(), index2.getIndex()), 2));  
            assertEquals(ResolvedIndices.of("datastream-test"), resolvedIndices);
            .put(index2, false)
 * The OpenSearch Contributors require contributions made to  
