            Settings.EMPTY,
import static org.mockito.Mockito.when;
        {
}  
import org.opensearch.script.ScriptService;
            mock(ActionFilters.class),  
import org.opensearch.action.index.IndexRequest;
import org.opensearch.cluster.service.ClusterService;
import org.opensearch.action.index.IndexAction;
                new ReindexRequest(new SearchRequest("searched-index"), new IndexRequest("target-index"))
import static org.mockito.ArgumentMatchers.any;
import org.opensearch.action.support.ActionFilters;
            ResolvedIndices resolvedIndices = action.resolveIndices(  
import org.opensearch.common.util.concurrent.ThreadContext;
        when(threadPool.getThreadContext()).thenReturn(threadContext);
import org.opensearch.common.settings.Settings;  
                resolvedIndices
 *
            );
            indexNameExpressionResolver,
import org.opensearch.action.search.SearchRequest;  
import org.opensearch.cluster.metadata.ResolvedIndices;
        IndexNameExpressionResolver indexNameExpressionResolver = new IndexNameExpressionResolver(threadContext);
        TransportReindexAction action = new TransportReindexAction(  
 * SPDX-License-Identifier: Apache-2.0
        when(transportSearchAction.resolveIndices(any())).thenAnswer(i -> ResolvedIndices.of(((SearchRequest) i.getArgument(0)).indices()));  
            assertEquals(  
            transportSearchAction
            mock(Client.class),
            threadPool,
import org.opensearch.test.OpenSearchTestCase;  
        }
package org.opensearch.index.reindex;
            mock(ReindexSslConfig.class),
import org.opensearch.transport.TransportService;
 */  
import static org.mockito.Mockito.mock;  
 * compatible open source license.
        );  
            mock(ClusterService.class),
            mock(TransportService.class),  
        TransportSearchAction transportSearchAction = mock(TransportSearchAction.class);
            null,
import org.opensearch.cluster.metadata.IndexNameExpressionResolver;  
import org.opensearch.threadpool.ThreadPool;
            mock(ScriptService.class),  
            );  
import org.opensearch.action.search.TransportSearchAction;
                ResolvedIndices.of("searched-index").withLocalSubActions(IndexAction.INSTANCE, ResolvedIndices.Local.of("target-index")),
 * The OpenSearch Contributors require contributions made to  
    public void testResolveIndices() {
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.transport.client.Client;  
public class TransportReindexActionTests extends OpenSearchTestCase {  
        ThreadContext threadContext = new ThreadContext(Settings.EMPTY);
/*  
        ThreadPool threadPool = mock(ThreadPool.class);  
