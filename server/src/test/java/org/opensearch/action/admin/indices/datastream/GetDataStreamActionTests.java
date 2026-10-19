import org.opensearch.common.settings.Settings;
}  
        String dataStreamName = "datastream-test";
            mock(ActionFilters.class),
import org.opensearch.cluster.metadata.Metadata;
        IndexMetadata index2 = createBackingIndex(dataStreamName, 2).build();
    public void testResolveIndices() {  
 */  
 *
        GetDataStreamAction.TransportAction action = new GetDataStreamAction.TransportAction(
 * compatible open source license.
import org.opensearch.cluster.ClusterState;  
        IndexMetadata index1 = createBackingIndex(dataStreamName, 1).build();  
import org.opensearch.transport.TransportService;
import org.opensearch.cluster.metadata.ResolvedIndices;
            .put(index1, false)
package org.opensearch.action.admin.indices.datastream;
 * The OpenSearch Contributors require contributions made to  
            mock(TransportService.class),
    }
import static org.opensearch.cluster.DataStreamTestHelper.createBackingIndex;  
        ResolvedIndices resolvedIndices = action.resolveIndices(new GetDataStreamAction.Request(new String[] { "datastream-*" }));  
import org.opensearch.cluster.ClusterName;
import org.opensearch.cluster.metadata.IndexMetadata;
        when(clusterService.state()).thenReturn(clusterState);
import org.opensearch.common.util.concurrent.ThreadContext;
import static org.mockito.Mockito.when;  
        ClusterState clusterState = ClusterState.builder(new ClusterName("_name")).metadata(mdBuilder).build();
        );
import org.opensearch.cluster.metadata.DataStream;
        ClusterService clusterService = mock(ClusterService.class);
        assertEquals(ResolvedIndices.of("datastream-test"), resolvedIndices);
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY))  
public class GetDataStreamActionTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;  
            .put(index2, false)
            .put(new DataStream(dataStreamName, createTimestampField("@timestamp"), List.of(index1.getIndex(), index2.getIndex()), 2));  
import org.opensearch.threadpool.ThreadPool;
import static org.mockito.Mockito.mock;
/*  
import org.opensearch.action.support.ActionFilters;
            mock(ThreadPool.class),
import org.opensearch.cluster.service.ClusterService;  
            clusterService,  
        Metadata.Builder mdBuilder = Metadata.builder()  
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.cluster.DataStreamTestHelper.createTimestampField;
