import java.util.List;  
 * compatible open source license.
        );
            )
        ModifyDataStreamsAction.TransportAction action = new ModifyDataStreamsAction.TransportAction(
import org.opensearch.transport.TransportService;
import org.opensearch.test.OpenSearchTestCase;
            mock(MetadataDataStreamsService.class)
    }
public class ModifyDataStreamsActionTests extends OpenSearchTestCase {
import org.opensearch.action.support.ActionFilters;
 * The OpenSearch Contributors require contributions made to  
            List.of(
            mock(ClusterService.class),  
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.cluster.metadata.MetadataDataStreamsService;  
        assertEquals(ResolvedIndices.of("logs-foo", ".ds-logs-foo-000001", "logs-bar", ".ds-logs-bar-000002"), resolvedIndices);  
 * SPDX-License-Identifier: Apache-2.0
        ModifyDataStreamsAction.Request request = new ModifyDataStreamsAction.Request(
                DataStreamAction.removeBackingIndex("logs-bar", ".ds-logs-bar-000002")
package org.opensearch.action.admin.indices.datastream;
import org.opensearch.cluster.metadata.ResolvedIndices;
import org.opensearch.threadpool.ThreadPool;  
import static org.mockito.Mockito.mock;
        );  
}
import org.opensearch.common.settings.Settings;  
 */  
    public void testResolveIndicesReturnsEveryDataStreamAndBackingIndex() {  
/*  
            mock(ActionFilters.class),
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
            mock(ThreadPool.class),
 *
            new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY)),  
import org.opensearch.common.util.concurrent.ThreadContext;
 * this file be licensed under the Apache-2.0 license or a
                DataStreamAction.addBackingIndex("logs-foo", ".ds-logs-foo-000001"),  
        ResolvedIndices resolvedIndices = action.resolveIndices(request);
            mock(TransportService.class),
