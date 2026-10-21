                        )
import org.opensearch.analytics.exec.stage.StageTaskState;
                    false,
     * <p>Public for the MPP dispatcher ({@code UnifiedDispatch}) which needs to run
                currentAttempt.transitionTo(StageTaskState.FINISHED);
                        stage.getStageId(),
/*
        opListener.onQueryStart(queryId, graph.stageCount());
                }
     *
public class QueryScheduler implements Scheduler {
     * SUCCEEDED; concurrent cancel → CANCELLED).
     *       {@link org.opensearch.analytics.exec.stage.StageExecutionFactory} for a stage type
                logger.debug("[QueryScheduler] dispatching stage {} ({} tasks)", stage.getStageId(), stage.tasks().size());
            }
        }, e -> {
     * task pacing) automatically apply to phased dispatch as well.
                );
            opListener.onQueryFailure(queryId, e);
 *
        final long queryStartNanos = System.nanoTime();
        // behind a can-match round-trip, so the stage can still be CREATED when start() returns
     * scheduler-owned per-task listener factory to {@link StageExecution#dispatchTasks} —
                    TaskRunner<StageTask> runner = (TaskRunner<StageTask>) stage.taskRunner();
        }, e -> {}));
        return stageExecutionBuilder;
        logger.debug("[QueryScheduler] ExecutionGraph built:\n{}", graph.explain());
import org.opensearch.common.inject.Inject;
import org.opensearch.transport.TransportService;
     * {@link QueryExecution} graph traversal. Those callers reuse this method rather than
                    queryTask,
                logger.debug(
    @Inject
import org.opensearch.analytics.exec.stage.StageExecutionBuilder;
                stage.onTaskTerminal(task, null);
     *   <li>resilience integration tests that register a custom
        // transitioned: dispatch only if it landed in RUNNING (empty-target stages go straight to
                if (retry.isPresent()) {
                    StageTask r = retry.get();
     * On failure, retries via {@link StageExecution#retargetForRetry} if the stage hands
                    )
     * (shard fan-outs that want to bound the outbound-throttle queue depth). Skips dispatch
import org.opensearch.analytics.exec.stage.StageTask;
import org.apache.arrow.vector.VectorSchemaRoot;
 * The OpenSearch Contributors require contributions made to
            }
     */
            // has been unregistered — they survive into orphan state and run to natural
 * query, starts it, and tracks it in a pool for observability and cancellation.
                            stage.getStageId(),
     *
     *       chain;</li>
     * re-instantiate {@link AnalyticsSearchTransportService} (whose ctor registers transport
            String reason = "task cancelled: " + (queryTask.getReasonCancelled() != null ? queryTask.getReasonCancelled() : "unknown");
        QueryExecution execution = new QueryExecution(context, graph, this::scheduleStage, wrapped);
     * {@link StageExecution.State#FAILED FAILED}, or {@link StageExecution.State#CANCELLED CANCELLED}),
    public StageExecutionBuilder getStageExecutionBuilder() {
        // start(onStarted) may be asynchronous — ShardFragmentStageExecution defers publication
 * SPDX-License-Identifier: Apache-2.0
    private final StageExecutionBuilder stageExecutionBuilder;
        stage.start(ActionListener.wrap(v -> {
     *
     * the stage decides whether to dispatch eagerly (default for-loop) or incrementally
     * cancelled — is always wrong. Catches the race where an in-flight task's onFailure
     * stays the original — that's the slot identifier the stage's bookkeeping uses.
 * @opensearch.internal
    /**
                            retry.get()
package org.opensearch.analytics.exec;
     * superseded attempts get FAILED, the final (succeeding or last-failed) attempt gets the
    public QueryExecution execute(QueryContext context, ActionListener<Iterable<VectorSchemaRoot>> listener) {
        ExecutionGraph graph = ExecutionGraph.build(context, stageExecutionBuilder, this::scheduleStage);
    }
     * if the stage has already entered any terminal state ({@link StageExecution.State#SUCCEEDED SUCCEEDED},
            }
import org.opensearch.analytics.exec.stage.StageExecution;
     *   <li>join-strategy dispatchers (e.g. M1 broadcast) that need to run a single stage in
import java.util.Optional;
                    )
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        // start(); deferred stages run it on the async completion. onFailure needs no handling —
 */
        this.taskManager = transportService.getTaskManager();
import org.apache.logging.log4j.message.ParameterizedMessage;
            // Cascade a cancel to dispatched data-node fragments before the framework unregisters
    private static final Logger logger = LogManager.getLogger(QueryScheduler.class);
            public void onFailure(Exception cause) {
     * </ul>
    public QueryScheduler(StageExecutionBuilder stageExecutionBuilder, TransportService transportService) {
     * <p>Resolving via the singleton scheduler avoids a Guice JIT lookup that would
            if (stage.getState() == StageExecution.State.RUNNING) {
     * back an alternate; otherwise propagates via {@code onTaskTerminal} (fast-fails the stage).
     * matching terminal. The {@code task} reference passed to {@code stage.onTaskTerminal}
import org.opensearch.core.action.ActionListener;
                Optional<StageTask> retry = stage.getState().isTerminal() ? Optional.empty() : stage.retargetForRetry(task, cause);
     * <p>Used by:
                currentAttempt.transitionTo(StageTaskState.FAILED);
        queryTask.setOnCancelCallback(() -> {
            listener.onResponse(result);
        ActionListener<Iterable<VectorSchemaRoot>> wrapped = ActionListener.runBefore(ActionListener.wrap(result -> {
    /**
}
                        )
                            "[QueryScheduler] task {} on stage {} failed, retrying on {}",
     * retry is skipped uniformly across stage types. Spawning new dispatch work for a stage
                        task,
                logger.debug(new ParameterizedMessage("[QueryScheduler] orphan-cleanup invocation failed for queryId={}", queryId), ex);
import org.opensearch.analytics.backend.AnalyticsOperationListener;
            @Override
        execution.start();
 * Default {@link Scheduler} implementation. Builds a {@link QueryExecution} per
     */
import java.util.concurrent.ConcurrentHashMap;
        return execution;
/**
        final AnalyticsQueryTask queryTask = context.parentTask();
import org.opensearch.analytics.exec.task.TaskRunner;
    @Override
     *       isolation with a caller-supplied output sink, bypassing the parent-sink resolution
            execution.cancelAll(reason);
            // completion. Idempotent against the already-cancelled path.
    }
        final AnalyticsOperationListener.CompositeListener opListener = new AnalyticsOperationListener.CompositeListener(
     * when {@code start()} transitions straight to a terminal (empty target resolution →
    }
        );
                        stage.getState().isTerminal(),
            StageTask currentAttempt = task;
     * handlers, only legal once per node).
                    "analytics query terminal — cleaning up dispatched fragments",
     */
import java.util.Map;
        setCancellationCallback(context, execution);
            context.operationListeners()
                        v -> {},
                            ex
     *
            }
        final String queryId = context.queryId();
                    return;
import org.apache.logging.log4j.Logger;
    public void scheduleStage(StageExecution stage) {
 * compatible open source license.
     * Protected for retry/admission-aware subclasses.
        });
                            new ParameterizedMessage("[QueryScheduler] orphan-cleanup cancel failed for queryId={}", queryId),
                    runner.run(r, this);  // reuse this listener — retry loop until stage gives up
            public void onResponse(Void unused) {
        // and only transitions later, on the response thread. onStarted fires once the stage has
        }), () -> {
 * this file be licensed under the Apache-2.0 license or a
                    logger.debug(
     * <p>Terminal-stage short-circuit lives here, not in each stage's {@code retargetForRetry}:
                taskManager.cancelTaskAndDescendants(
    }
    private final Map<String, QueryExecution> executions = new ConcurrentHashMap<>();
            opListener.onQuerySuccess(queryId, System.nanoTime() - queryStartNanos, 0);
        this.stageExecutionBuilder = stageExecutionBuilder;
import org.opensearch.tasks.TaskManager;
     * <ul>
                    () -> new ParameterizedMessage(
        };
                );
            } catch (Exception ex) {
        final AnalyticsQueryTask queryTask = config.parentTask();
                        "[QueryScheduler] task {} on stage {} failed, no retry available (stageTerminal={}, cause={})",
        return new ActionListener<>() {
        // the stage is already FAILED and propagates through the normal terminal path.
                stage.dispatchTasks(this::handleFor);
            try {
            listener.onFailure(e);
     * a single stage in isolation with a caller-supplied output sink, outside the normal
                    currentAttempt.transitionTo(StageTaskState.FAILED);  // previous attempt is now superseded
        });
            executions.remove(queryId);
        // Dispatch after materialisation completes, not by polling state right after start().
                    );
                        cause.getMessage()
            // the parent task. Otherwise TaskManager.setBan, which matches children by parent
    protected ActionListener<Void> handleFor(StageExecution stage, StageTask task) {
 */
    /**
     *
     * fires after the stage has transitioned terminally for some other reason.
                            task,
                    @SuppressWarnings("unchecked")
                    r.transitionTo(StageTaskState.RUNNING);
     *       (e.g. fault-injecting scheduler).</li>
                        () -> new ParameterizedMessage(
    private static void setCancellationCallback(QueryContext config, QueryExecution execution) {
     * Returns the underlying {@link StageExecutionBuilder}.
                stage.onTaskTerminal(task, cause);
            // TaskId in the cancellable-tasks registry, cannot reach fragments after the parent
import org.apache.logging.log4j.LogManager;
     * inlining the dispatch loop so future scheduler enhancements (in-flight caps, retry-aware
    }
                    currentAttempt = r;
     * that's done — whether it succeeded, already gave up on a different task, or was
        executions.put(queryId, execution);
 *
     * <p>Tracks the current attempt so each attempt's terminal state is recorded truthfully:
    private final TaskManager taskManager;
     * Materialises {@code stage}'s tasks via {@link StageExecution#start}, then hands the
    }
        // SUCCEEDED and have nothing to dispatch). Synchronous stages run this inline inside
            @Override
                    ActionListener.wrap(
                        ex -> logger.debug(
