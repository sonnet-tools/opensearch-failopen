        TransportService transportService,  
        super(UnifiedPPLExecuteAction.NAME, transportService, actionFilters, PPLRequest::new);
 * blocking the transport thread (DefaultPlanExecutor uses a blocking future internally).  
        TransportService transportService,
 * <p>Receives {@link EngineContextProvider} and {@link QueryPlanExecutor} from the analytics-engine
 *
package org.opensearch.ppl.action;
        this.unifiedQueryService = unifiedQueryService;  
                logger.error("[UNIFIED_PPL] execution failed", e);
    public TestPPLTransportAction(
    }
        UnifiedQueryService unifiedQueryService,
                listener.onResponse(response);
        this.threadPool = threadPool;
    }
        ActionFilters actionFilters,
    @Override
        // Fork to SEARCH thread pool — DefaultPlanExecutor.execute() blocks on a future  
    private static final Logger logger = LogManager.getLogger(TestPPLTransportAction.class);
    public TestPPLTransportAction(
import org.apache.calcite.rel.RelNode;
                    ? unifiedQueryService.executeWithProfile(request.getPplText())  
    protected void doExecute(Task task, PPLRequest request, ActionListener<PPLResponse> listener) {
        QueryPlanExecutor<RelNode, Iterable<Object[]>> executor,
/**
import org.opensearch.analytics.EngineContextProvider;  
    private final UnifiedQueryService unifiedQueryService;  
        super(UnifiedPPLExecuteAction.NAME, transportService, actionFilters, PPLRequest::new);
import org.opensearch.common.inject.Inject;
        this.threadPool = threadPool;
}  
 * The OpenSearch Contributors require contributions made to  
 * plugin via Guice injection (enabled by {@code extendedPlugins = ['analytics-engine']}).  
import org.opensearch.analytics.exec.QueryPlanExecutor;
    @Inject  
        threadPool.executor(ThreadPool.Names.SEARCH).execute(() -> {  
        this.unifiedQueryService = new UnifiedQueryService(executor, contextProvider);  
    private final ThreadPool threadPool;
/*  
import org.opensearch.threadpool.ThreadPool;
            try {
 * this file be licensed under the Apache-2.0 license or a
    }
    ) {
import org.apache.logging.log4j.LogManager;
 *
 * <p>Execution is forked to the {@link ThreadPool.Names#SEARCH} thread pool to avoid
import org.opensearch.core.action.ActionListener;  
        EngineContextProvider contextProvider,
        ThreadPool threadPool  
import org.opensearch.action.support.ActionFilters;
        // internally, which is forbidden on the transport thread.
                listener.onFailure(e);
    /** Test-only constructor that accepts a pre-built {@link UnifiedQueryService}. */
public class TestPPLTransportAction extends HandledTransportAction<PPLRequest, PPLResponse> {
        });
            }  
        // TODO: update UnifiedQueryService to consume a listener that DefaultPlanExecutor does to avoid threadpool fork
 */
        ThreadPool threadPool  
        ActionFilters actionFilters,  
import org.apache.logging.log4j.Logger;  
 * SPDX-License-Identifier: Apache-2.0
            } catch (Exception e) {  
                    : unifiedQueryService.execute(request.getPplText());
 * compatible open source license.
import org.opensearch.tasks.Task;
 *
 */  
 * Transport action that coordinates PPL query execution.  
                PPLResponse response = request.isExplain()
    ) {
import org.opensearch.action.support.HandledTransportAction;
import org.opensearch.transport.TransportService;  
