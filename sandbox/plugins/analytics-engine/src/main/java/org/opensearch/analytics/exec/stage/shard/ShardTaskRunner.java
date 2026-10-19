import org.opensearch.analytics.exec.QueryContext;
 * SPDX-License-Identifier: Apache-2.0
            n -> new PendingExecutions(config.maxConcurrentShardRequestsPerNode())
import java.util.Map;  
import java.util.function.Function;
    private boolean stillNeeded(ShardStageTask task, ShardExecutionTarget target) {
import org.opensearch.core.action.ActionListener;
        // bottom() is defined here: canEliminate only says yes once K keys are in hand, and the
    /**  
            config.parentTask(),  
        );  
    private static final Logger logger = LogManager.getLogger(ShardTaskRunner.class);
import org.opensearch.analytics.exec.PendingExecutions;
import org.apache.logging.log4j.Logger;
/**
import org.opensearch.analytics.exec.AnalyticsSearchTransportService;  
/*  
        QueryContext config,
        return false;
        this.config = config;
     * row in the top-{@code K} the coordinator already holds — so the scan is wasted work.
        stage.skipTask(task);
            () -> stillNeeded(task, target)
            stage.responseListenerFor(task, listener),
        // count never shrinks.
        logger.debug("sort-et: skipping shard {} — its whole range is worse than the bar {}", target.shardId(), gate.bottom());  
        PendingExecutions pending = pendingFor(target);
        if (gate == null || gate.canEliminate(stage.sortBounds().get(target)) == false) {
package org.opensearch.analytics.exec.stage.shard;
            target.node(),
 * Per-node concurrency is gated by {@link PendingExecutions}.
        }  
        ShardExecutionTarget target = (ShardExecutionTarget) task.target();
        AnalyticsSearchTransportService transport,  
public final class ShardTaskRunner implements TaskRunner<ShardStageTask> {
    ) {
 */
    public ShardTaskRunner(  
 * The OpenSearch Contributors require contributions made to  
        );  
import org.apache.logging.log4j.LogManager;
    }
            pending,
 * @opensearch.internal  
    }
    private final QueryContext config;
    private final Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder;  
import org.opensearch.analytics.exec.task.TaskRunner;
     */
            target.node().getId(),
        this.stage = stage;  
        this.requestBuilder = requestBuilder;  
            request,  
        TopNGate gate = stage.topNGate();  
        ShardFragmentStageExecution stage,
            return true;
        transport.dispatchFragmentStreaming(
 */  
    private final ShardFragmentStageExecution stage;  
    private final AnalyticsSearchTransportService transport;
 * SHARD-kind task runner: opens an Arrow Flight stream per task. Response handling
 * this file be licensed under the Apache-2.0 license or a
    @Override  
        Function<ShardExecutionTarget, FragmentExecutionRequest> requestBuilder
        FragmentExecutionRequest request = requestBuilder.apply(target);  
        return pendingPerNode.computeIfAbsent(  
     * Top-N early termination: {@code false} skips this shard, because it provably cannot place a
 *
import java.util.concurrent.ConcurrentHashMap;
 *
import org.opensearch.analytics.exec.canmatch.TopNGate;
    }
 * lives on the stage via {@link ShardFragmentStageExecution#responseListenerFor}.  
}
import org.opensearch.analytics.exec.action.FragmentExecutionRequest;  
        this.transport = transport;
    private PendingExecutions pendingFor(ShardExecutionTarget target) {
     * Checked right before the request goes out, not when the task was queued  
 * compatible open source license.
    private final Map<String, PendingExecutions> pendingPerNode = new ConcurrentHashMap<>();
import org.opensearch.analytics.planner.dag.ShardExecutionTarget;  
    }  
    public void run(ShardStageTask task, ActionListener<Void> listener) {
