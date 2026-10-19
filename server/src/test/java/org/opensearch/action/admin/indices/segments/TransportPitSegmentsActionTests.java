import org.opensearch.action.search.PitTestsUtil;
import org.opensearch.index.query.TermQueryBuilder;  
 * SPDX-License-Identifier: Apache-2.0
}
package org.opensearch.action.admin.indices.segments;
import org.opensearch.transport.client.node.NodeClient;
        PitService pitService = new PitService(clusterService, mock(SearchTransportService.class), mock(TransportService.class), client);
import org.opensearch.cluster.metadata.OptionallyResolvedIndices;  
 * compatible open source license.
import org.opensearch.common.settings.Settings;  
import java.util.Arrays;
import org.opensearch.index.query.MatchAllQueryBuilder;
            )  
import org.opensearch.indices.IndicesService;
            assertEquals(ResolvedIndices.of("idx", "idy"), resolvedIndices);  
 * The OpenSearch Contributors require contributions made to  
                new NamedWriteableRegistry.Entry(QueryBuilder.class, IdsQueryBuilder.NAME, IdsQueryBuilder::new)
        {
                new NamedWriteableRegistry.Entry(QueryBuilder.class, TermQueryBuilder.NAME, TermQueryBuilder::new),  
import org.opensearch.cluster.metadata.ResolvedIndices;
        );  
                new NamedWriteableRegistry.Entry(QueryBuilder.class, MatchAllQueryBuilder.NAME, MatchAllQueryBuilder::new),
        );
        NamedWriteableRegistry namedWriteableRegistry = new NamedWriteableRegistry(
        NodeClient client = mock(NodeClient.class);
            mock(TransportService.class),
            OptionallyResolvedIndices resolvedIndices = action.resolveIndices(new PitSegmentsRequest(pitId));
        }
import org.opensearch.common.util.concurrent.ThreadContext;
            indexNameExpressionResolver,
            pitService
/*  
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.action.search.SearchTransportService;  
import static org.mockito.Mockito.when;
        TransportPitSegmentsAction action = new TransportPitSegmentsAction(  
            assertFalse("result is unknown", resolvedIndices instanceof ResolvedIndices);
            namedWriteableRegistry,
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
import org.opensearch.transport.TransportService;
            mock(SearchService.class),  
        ClusterService clusterService = mock(ClusterService.class);
            mock(IndicesService.class),  
    public void testResolveIndices() {
 */  
import org.opensearch.cluster.service.ClusterService;
        }  
            clusterService,
            // The generated pitId will contain the indices "idx" and "idy"  
            OptionallyResolvedIndices resolvedIndices = action.resolveIndices(new PitSegmentsRequest("_all"));
import org.opensearch.index.query.IdsQueryBuilder;  
            String pitId = PitTestsUtil.getPitId();
            mock(ActionFilters.class),
        {  
import org.opensearch.search.SearchService;
import static org.mockito.Mockito.mock;  
public class TransportPitSegmentsActionTests extends OpenSearchTestCase {  
import org.opensearch.index.query.QueryBuilder;
    }
            Arrays.asList(
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(new ThreadContext(Settings.EMPTY));  
        when(client.getNamedWriteableRegistry()).thenReturn(namedWriteableRegistry);  
 *
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.action.search.PitService;
import org.opensearch.action.support.ActionFilters;
