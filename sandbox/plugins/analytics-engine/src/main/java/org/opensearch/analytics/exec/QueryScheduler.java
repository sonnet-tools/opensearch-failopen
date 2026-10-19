            String reason = "task cancelled: " + (queryTask.getReasonCancelled() != null ? queryTask.getReasonCancelled() : "unknown");  
                        )  
                Optional<StageTask> retry = stage.getState().isTerminal() ? Optional.empty() : stage.retargetForRetry(task, cause);
     * cancelled — is always wrong. Catches the race where an in-flight task's onFailure  
     *       chain;</li>  
                            stage.getStageId(),
        // start(); deferred stages run it on the async completion. onFailure needs no handling —
import java.util.Map;
            executions.remove(queryId);
     * </ul>
                        stage.getStageId(),
    @Inject
    private final Map<String, QueryExecution> executions = new ConcurrentHashMap<>();  
                    () -> new ParameterizedMessage(
    }  
     * stays the original — that's the slot identifier the stage's bookkeeping uses.  
                        ex -> logger.debug(  
    }
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
 * The OpenSearch Contributors require contributions made to  
     *
        final AnalyticsQueryTask queryTask = context.parentTask();  
/**  
     * <p>Terminal-stage short-circuit lives here, not in each stage's {@code retargetForRetry}:
        return new ActionListener<>() {  
     */  
                    logger.debug(
     *   <li>join-strategy dispatchers (e.g. M1 broadcast) that need to run a single stage in
            opListener.onQueryFailure(queryId, e);
    private final StageExecutionBuilder stageExecutionBuilder;
        opListener.onQueryStart(queryId, graph.stageCount());
import org.apache.logging.log4j.message.ParameterizedMessage;
 * Default {@link Scheduler} implementation. Builds a {@link QueryExecution} per
        final String queryId = context.queryId();
    public void scheduleStage(StageExecution stage) {  
                    false,  
        // start(onStarted) may be asynchronous — ShardFragmentStageExecution defers publication
    @Override
     * SUCCEEDED; concurrent cancel → CANCELLED).
                currentAttempt.transitionTo(StageTaskState.FAILED);  
    protected ActionListener<Void> handleFor(StageExecution stage, StageTask task) {
            } catch (Exception ex) {  
        this.stageExecutionBuilder = stageExecutionBuilder;
                    StageTask r = retry.get();
import java.util.Optional;  
     * Protected for retry/admission-aware subclasses.
     * matching terminal. The {@code task} reference passed to {@code stage.onTaskTerminal}
        };  
            if (stage.getState() == StageExecution.State.RUNNING) {
import org.opensearch.analytics.backend.AnalyticsOperationListener;
 * this file be licensed under the Apache-2.0 license or a
     *
import org.apache.arrow.vector.VectorSchemaRoot;
                    TaskRunner<StageTask> runner = (TaskRunner<StageTask>) stage.taskRunner();
                    currentAttempt.transitionTo(StageTaskState.FAILED);  // previous attempt is now superseded  
        );
                            "[QueryScheduler] task {} on stage {} failed, retrying on {}",  
     * Materialises {@code stage}'s tasks via {@link StageExecution#start}, then hands the
                        "[QueryScheduler] task {} on stage {} failed, no retry available (stageTerminal={}, cause={})",
    public QueryScheduler(StageExecutionBuilder stageExecutionBuilder, TransportService transportService) {  
import org.opensearch.analytics.exec.task.TaskRunner;
            }
import org.apache.logging.log4j.LogManager;
import org.opensearch.tasks.TaskManager;
                );
            // the parent task. Otherwise TaskManager.setBan, which matches children by parent
     *  
    }  
     * re-instantiate {@link AnalyticsSearchTransportService} (whose ctor registers transport
        });
                            ex
import org.opensearch.transport.TransportService;  
        stage.start(ActionListener.wrap(v -> {  
    /**
                    return;
        final AnalyticsQueryTask queryTask = config.parentTask();
        logger.debug("[QueryScheduler] ExecutionGraph built:\n{}", graph.explain());
     * {@link StageExecution.State#FAILED FAILED}, or {@link StageExecution.State#CANCELLED CANCELLED}),  
                logger.debug(  
        setCancellationCallback(context, execution);
 */  
     *       isolation with a caller-supplied output sink, bypassing the parent-sink resolution
            try {
                        cause.getMessage()  
                            task,
        return stageExecutionBuilder;
    /**
        return execution;
 */
     * handlers, only legal once per node).
     * the stage decides whether to dispatch eagerly (default for-loop) or incrementally
                stage.onTaskTerminal(task, null);  
     * inlining the dispatch loop so future scheduler enhancements (in-flight caps, retry-aware  
}
     * when {@code start()} transitions straight to a terminal (empty target resolution →  
            }
            listener.onResponse(result);  
 * query, starts it, and tracks it in a pool for observability and cancellation.
    private final TaskManager taskManager;
        // SUCCEEDED and have nothing to dispatch). Synchronous stages run this inline inside  
                stage.onTaskTerminal(task, cause);
                        v -> {},
                    currentAttempt = r;
 *  
     * fires after the stage has transitioned terminally for some other reason.
            }
            }
        // and only transitions later, on the response thread. onStarted fires once the stage has
    public QueryExecution execute(QueryContext context, ActionListener<Iterable<VectorSchemaRoot>> listener) {  
                            new ParameterizedMessage("[QueryScheduler] orphan-cleanup cancel failed for queryId={}", queryId),
import java.util.concurrent.ConcurrentHashMap;
            // completion. Idempotent against the already-cancelled path.
                    );
import org.opensearch.analytics.exec.stage.StageTaskState;  
     * <p>Used by:
                    runner.run(r, this);  // reuse this listener — retry loop until stage gives up  
                    r.transitionTo(StageTaskState.RUNNING);  
        ExecutionGraph graph = ExecutionGraph.build(context, stageExecutionBuilder, this::scheduleStage);
    private static void setCancellationCallback(QueryContext config, QueryExecution execution) {  
     * On failure, retries via {@link StageExecution#retargetForRetry} if the stage hands  
     *
import org.opensearch.analytics.exec.stage.StageExecution;  
     */
    private static final Logger logger = LogManager.getLogger(QueryScheduler.class);
import org.apache.logging.log4j.Logger;  
                        task,  
     * <p>Public for the MPP dispatcher ({@code UnifiedDispatch}) which needs to run  
        }, e -> {}));
     * that's done — whether it succeeded, already gave up on a different task, or was
            execution.cancelAll(reason);
                            retry.get()  
     * retry is skipped uniformly across stage types. Spawning new dispatch work for a stage
     * a single stage in isolation with a caller-supplied output sink, outside the normal
            context.operationListeners()  
                stage.dispatchTasks(this::handleFor);  
     * scheduler-owned per-task listener factory to {@link StageExecution#dispatchTasks} —  
            StageTask currentAttempt = task;
                logger.debug("[QueryScheduler] dispatching stage {} ({} tasks)", stage.getStageId(), stage.tasks().size());
                    @SuppressWarnings("unchecked")
/*  
            // has been unregistered — they survive into orphan state and run to natural  
     *       {@link org.opensearch.analytics.exec.stage.StageExecutionFactory} for a stage type
     *   <li>resilience integration tests that register a custom
        ActionListener<Iterable<VectorSchemaRoot>> wrapped = ActionListener.runBefore(ActionListener.wrap(result -> {
                        stage.getState().isTerminal(),
                if (retry.isPresent()) {  
     *       (e.g. fault-injecting scheduler).</li>  
     * Returns the underlying {@link StageExecutionBuilder}.  
                        )
    }
     * task pacing) automatically apply to phased dispatch as well.
     * <ul>  
     * <p>Tracks the current attempt so each attempt's terminal state is recorded truthfully:  
            @Override  
                currentAttempt.transitionTo(StageTaskState.FINISHED);
    }  
                taskManager.cancelTaskAndDescendants(  
        execution.start();  
     */
                logger.debug(new ParameterizedMessage("[QueryScheduler] orphan-cleanup invocation failed for queryId={}", queryId), ex);
        });  
     * if the stage has already entered any terminal state ({@link StageExecution.State#SUCCEEDED SUCCEEDED},
        // the stage is already FAILED and propagates through the normal terminal path.
     * superseded attempts get FAILED, the final (succeeding or last-failed) attempt gets the
            public void onFailure(Exception cause) {
        this.taskManager = transportService.getTaskManager();
        }, e -> {
        }), () -> {
                    queryTask,
            // Cascade a cancel to dispatched data-node fragments before the framework unregisters  
import org.opensearch.analytics.exec.stage.StageTask;
        // behind a can-match round-trip, so the stage can still be CREATED when start() returns  
                    )
        queryTask.setOnCancelCallback(() -> {
     * back an alternate; otherwise propagates via {@code onTaskTerminal} (fast-fails the stage).
        // Dispatch after materialisation completes, not by polling state right after start().
package org.opensearch.analytics.exec;
        final AnalyticsOperationListener.CompositeListener opListener = new AnalyticsOperationListener.CompositeListener(
            public void onResponse(Void unused) {
 *
            opListener.onQuerySuccess(queryId, System.nanoTime() - queryStartNanos, 0);
                );
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        executions.put(queryId, execution);  
        final long queryStartNanos = System.nanoTime();
 * @opensearch.internal
            listener.onFailure(e);  
     *
import org.opensearch.common.inject.Inject;  
     * {@link QueryExecution} graph traversal. Those callers reuse this method rather than
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
                    ActionListener.wrap(
    /**
    public StageExecutionBuilder getStageExecutionBuilder() {
                }
    }  
import org.opensearch.core.action.ActionListener;
        // transitioned: dispatch only if it landed in RUNNING (empty-target stages go straight to
                    )
            @Override  
            // TaskId in the cancellable-tasks registry, cannot reach fragments after the parent
                        () -> new ParameterizedMessage(
     * <p>Resolving via the singleton scheduler avoids a Guice JIT lookup that would  
     * (shard fan-outs that want to bound the outbound-throttle queue depth). Skips dispatch
public class QueryScheduler implements Scheduler {  
        QueryExecution execution = new QueryExecution(context, graph, this::scheduleStage, wrapped);
                    "analytics query terminal — cleaning up dispatched fragments",
