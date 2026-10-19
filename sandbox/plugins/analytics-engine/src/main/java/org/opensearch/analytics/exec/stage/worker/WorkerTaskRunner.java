    private final WorkerFragmentStageExecution stage;
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;
            request,
 * {@link AnalyticsSearchTransportService#dispatchWorkerFragmentStreaming} so the request is a
    ) {
        WorkerExecutionTarget target = task.target();
        this.config = config;  
import org.opensearch.analytics.planner.dag.WorkerExecutionTarget;  
        AnalyticsSearchTransportService transport,
    private final Function<WorkerExecutionTarget, WorkerFragmentRequest> requestBuilder;
    private final Map<String, PendingExecutions> pendingPerNode = new ConcurrentHashMap<>();  
import java.util.function.Function;
 * The OpenSearch Contributors require contributions made to  
 *
    public void run(WorkerStageTask task, ActionListener<Void> listener) {  
    }  
import org.opensearch.analytics.exec.task.TaskRunner;
 */  
import org.opensearch.core.action.ActionListener;
        QueryContext config,
import java.util.Map;  
 * compatible open source license.
    @Override
            n -> new PendingExecutions(config.maxConcurrentShardRequestsPerNode())
    public WorkerTaskRunner(
        WorkerFragmentRequest request = requestBuilder.apply(target);
 *  
        this.stage = stage;
 * @opensearch.internal
    private final AnalyticsSearchTransportService transport;
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
            config.parentTask(),
        WorkerFragmentStageExecution stage,  
            target.node(),  
import org.opensearch.analytics.exec.PendingExecutions;
import org.opensearch.analytics.exec.action.WorkerFragmentRequest;
import java.util.concurrent.ConcurrentHashMap;
            target.node().getId(),  
 */
package org.opensearch.analytics.exec.stage.worker;
        transport.dispatchWorkerFragmentStreaming(
        );
        this.transport = transport;
    private PendingExecutions pendingFor(WorkerExecutionTarget target) {
        PendingExecutions pending = pendingFor(target);  
}
    }
 * Worker-kind task runner: opens an Arrow Flight stream per task. Sibling of
public final class WorkerTaskRunner implements TaskRunner<WorkerStageTask> {  
    private final QueryContext config;  
/*  
        this.requestBuilder = requestBuilder;
import org.opensearch.analytics.exec.QueryContext;  
            pending  
            stage.responseListenerFor(listener),
 * shardId-free {@link WorkerFragmentRequest}.
        return pendingPerNode.computeIfAbsent(
 * {@link org.opensearch.analytics.exec.stage.shard.ShardTaskRunner}, but routes through  
/**
        Function<WorkerExecutionTarget, WorkerFragmentRequest> requestBuilder  
        );
    }  
