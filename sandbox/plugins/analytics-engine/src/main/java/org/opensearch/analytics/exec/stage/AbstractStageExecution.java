    }
/**
import org.opensearch.analytics.planner.dag.Stage;
    private final AtomicInteger pendingTaskTerminal = new AtomicInteger(0);
        }
    private static final Logger logger = LogManager.getLogger(AbstractStageExecution.class);
     * This does NOT mean individual StageTask cancellation fails the parent stages/query,
    }
    }
     * materialisation failed (the stage is FAILED by then). For the synchronous path all of this
        assert remaining >= 0 : "task terminal counter went negative: " + remaining;
            try {
    }
                    metrics.getRowsProcessed()
        if (target.isTerminal()) {
     * for stage-internal cleanup that must precede the listener cascade — e.g., closing
    }
import java.util.concurrent.atomic.AtomicReference;
    private final List<AnalyticsOperationListener> operationListeners;
            materializeTasksAsync(ActionListener.wrap(tasks -> {
    @Override
    }
    }
     * operation listeners. CREATED→terminal also synthesises the onStageStart event so
     */
 * {@link #start} template (materialise → publish → transition).
    public final Exception getFailure() {
     */
     * <p>Implementations MUST eventually call exactly one of {@code listener.onResponse}
        this.metrics = new StageMetrics();
        }
    public final void start(ActionListener<Void> onStarted) {
     *
 */
    protected final boolean recordTaskTerminal(@Nullable Exception cause) {
        } catch (Exception e) {
     * transition (SUCCEEDED / FAILED / CANCELLED), BEFORE state listeners run. Use this
            return;
    @Override
 *
        try {
                );
                target,
import java.util.concurrent.atomic.AtomicInteger;
    protected abstract List<StageTask> materializeTasks();
            t.transitionTo(StageTaskState.CANCELLED);
            } catch (Exception e) {
    @Override
        Stage stage,
     * work or {@link #materializeTasksAsync} for deferred work (e.g. a can-match round-trip).
    protected TaskRunner<?> runner = TaskRunner.NONE;
import org.opensearch.core.action.ActionListener;
                failWithCause(cause);
    ) {
    // operation listeners - for metrics / observability callbacks.
     * <p>Default sync path; override {@link #materializeTasksAsync} instead when work must
            }
        this.tasks = List.copyOf(ts);
                        "[StageExecution] listener threw for stage {} transition {} -> {}",
    }
     */
        this.parentTask = parentTask;
        // Synthesise onStageStart when a stage skips RUNNING (CREATED → terminal),
    private void publishTasksAndStart(List<StageTask> ts) {
        try {
    /**
                return false;
                logger.warn(
    public void onTaskTerminal(StageTask task, @Nullable Exception cause) {
    }
            Exception captured = getFailure();
            captureFailure(cause);
    @Override
     * no-op if state has advanced past CREATED.
            );
     * when there is work, terminal otherwise); {@code onStarted.onFailure} fires if
                    stageType,
import org.opensearch.analytics.backend.AnalyticsOperationListener;
        this.queryId = queryId;
            transitionTo(State.FAILED);
 * Shared mechanics for every {@link StageExecution} variant: state CAS, listener
            }
    }
 *
    /**
     * <p>{@code onStarted.onResponse} fires after the post-materialisation transition (RUNNING
        return Collections.unmodifiableList(tasks);
    public final void addStateListener(StageStateListener listener) {
     * {@code onStarted}. Subclasses customise via {@link #materializeTasks()} for synchronous
    @Override
     * Attempt to transition to {@code target}. No-op + returns {@code false} when the
                        : 0,
 * compatible open source license.
     * Hands the materialised task list to the lifecycle: empty → straight to SUCCEEDED
                publishTasksAndStart(tasks);
        }
 */
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
        }
 * fire loop, failure capture, metrics, default {@code tasks}/{@code runner} accessors,
            }
     */
        fireOperationListeners(previous, target);
            case RUNNING -> fireSingle(target, sid, stageType, l -> l.onStageStart(queryId, sid, stageType));
            metrics.recordStart();
     * happens inline before this method returns; for the async path it happens on the completion
import java.util.List;
    private final AtomicReference<State> state = new AtomicReference<>(State.CREATED);
        return transitionTo(State.FAILED);
        if (ts.isEmpty()) {
        return true;
            }));
    protected final Stage stage;
    /**
        }
public abstract class AbstractStageExecution implements StageExecution {
     * Build this stage's task list. Called once from {@link #start}. Return empty for
    /**
                logger.warn(new ParameterizedMessage("[StageExecution] operation listener threw for stage {} -> {}", sid, target), e);
package org.opensearch.analytics.exec.stage;
                    metrics.getEndTimeMs() > 0 && metrics.getStartTimeMs() > 0
        }
     * Template: materialise task list (possibly async), publish, transition, then signal
    public final StageMetrics getMetrics() {
    protected final StageMetrics metrics;
            captureFailure(cause);
     * listener delivery.
     * separately in
                stageType,
            previous = state.get();
     * Captures {@code cause}, decrements pending counter, returns {@code true} iff
                onStarted.onResponse(null);
            transitionTo(State.SUCCEEDED);
     */
    }
            default -> {
                    new ParameterizedMessage(
    @Override
    /**
     * {@code ShardFragmentStageExecution} dispatches a can-match round-trip before publishing.
        switch (target) {
import org.apache.logging.log4j.LogManager;
        String queryId,
    private final AnalyticsQueryTask parentTask;
    public final int getStageId() {
                    sid,
            onTaskTerminal(task, null);
    }
        transitionTo(State.RUNNING);
    }
 * The OpenSearch Contributors require contributions made to
                        target
     *
            return;
    private final String queryId;
                    new ParameterizedMessage("[StageExecution] onTerminalTransition threw for stage {} -> {}", getStageId(), target),
     * Default no-op. Exceptions are swallowed (logged) so cleanup failures don't block
        if (cause != null) {
 * optionally {@link #onTerminalTransition(State)} (pre-listener cleanup). The base
    /**
    @Override
        // so observers always see a start before any terminal event.
        pendingTaskTerminal.set(ts.size());
 * drives every state transition.
     * A skipped task is never dispatched, so nothing else would ever settle it and the stage would
        String stageType = getClass().getSimpleName();
        for (StageTask t : tasks) {
            } catch (Exception e) {
            metrics.recordEnd();
        }
    }
    /**
     * Default lifecycle on per-task terminal: fast-fail on any failure, otherwise
        // stage-owned task list. Cheap — just a view wrapper, not a copy.
    protected final void captureFailure(Exception e) {
}
        }
     */
    // state listeners are for stage to stage wiring.
        if (parentTask.isCancelled() == false) {
import java.util.Collections;
        for (StageStateListener l : stateListeners) {
    /** Capture cause, transition to FAILED. Stage-internal cleanup runs via {@link #onTerminalTransition}. */
     * after the call.
                sid,
     * observers see a start before the terminal.
        if (previous == State.CREATED) {
            }
        do {
 * default {@code onTaskTerminal}/{@code cancel}/{@code failWithCause} impls, and the
    }
                    queryId,
        AnalyticsQueryTask parentTask
                onStarted.onFailure(cause);
            } catch (Exception e) {
     * intercepts BEFORE this fires — see {@code QueryScheduler.handleFor}.
    public void cancel(String reason) {
    private void fireSingle(State target, int sid, String stageType, java.util.function.Consumer<AnalyticsOperationListener> call) {
                    ),
        }
            }, cause -> {
            onStarted.onFailure(e);
            failWithCause(e);
     * Marks {@code task} {@link StageTaskState#SKIPPED} and counts it as this task's one terminal.
            try {
        captureFailure(cause);
     * every task is now terminal. Caller decides FAILED vs SUCCEEDED.
    public final State getState() {
     * task is terminal. Retry (when {@link #retargetForRetry} is overridden)
    }
        if (getState() != State.CREATED) return;
    public boolean failWithCause(Exception cause) {
        } while (state.compareAndSet(previous, target) == false);
     * thread — so callers must act via {@code onStarted}, not by polling {@link #getState()}
            case SUCCEEDED -> fireSingle(
    public final void skipTask(StageTask task) {
     * the stage FAILED (e.g. target resolution failure).
    @Nullable
    }
    /**
            case CANCELLED -> fireSingle(target, sid, stageType, l -> l.onStageCancelled(queryId, sid, "stage cancelled"));
        // Defensive wrap so callers (QueryScheduler dispatch loop, tests) can't mutate the
        }
    protected final boolean transitionTo(State target) {
     * This only handles if a full child stage is cancelled, task management is handled
    private void fireOperationListeners(State previous, State target) {
 * SPDX-License-Identifier: Apache-2.0
        } catch (Exception e) {
    private final AtomicReference<Exception> failure = new AtomicReference<>();
     * or {@code listener.onFailure}. Synchronous exceptions thrown before either are caught
import org.apache.logging.log4j.Logger;
import org.opensearch.common.Nullable;
            parentTask.cancel(reason);
        }
        if (transitionTo(State.CANCELLED) == false) return;
                l.onStateChange(previous, target);
    /**
                        previous,
     * (no work to do); otherwise publish + transition to RUNNING. Re-entry guard:
                        ? (metrics.getEndTimeMs() - metrics.getStartTimeMs()) * 1_000_000L
     */
    }
     */
        return runner;
        return stage.getStageId();
        int sid = getStageId();
     * Ensure if this stage is cancelled, our parent stage is also cancelled if not already
            listener.onFailure(e);
        if (operationListeners.isEmpty() || queryId == null) return;
        return state.get();
     * current state is already terminal or equal to {@code target}. On a successful
 * @opensearch.internal
                    e
        return metrics;
    }
    @Override
                l -> l.onStageSuccess(
                call.accept(l);
        if (recordTaskTerminal(null)) {
    /** Idempotent — only the first non-null failure is retained. */
        for (AnalyticsOperationListener l : operationListeners) {
     *
     * a backend sink before a query-level listener tears down the per-query allocator.
import org.opensearch.analytics.exec.task.TaskRunner;
    /**
        if (cause != null) {
/*
     */
    protected AbstractStageExecution(
    @Override
     * by {@link #start} and treated as failures.
        }
     * Async variant of {@link #materializeTasks()}. Default runs the sync method and invokes
        if (previous == State.CREATED && target.isTerminal()) {
     * Pre-listener cleanup hook. Fires inside {@link #transitionTo} on any terminal
        int remaining = pendingTaskTerminal.decrementAndGet();
            if (previous.isTerminal() || previous == target) {
                );
        stateListeners.add(listener);
 * this file be licensed under the Apache-2.0 license or a
            listener.onResponse(materializeTasks());
    protected void onTerminalTransition(State terminal) {}
                )
        return failure.get();
    protected void materializeTasksAsync(ActionListener<List<StageTask>> listener) {
            fireSingle(target, sid, stageType, l -> l.onStageStart(queryId, sid, stageType));
            }
    public TaskRunner<?> taskRunner() {
                    e
    private final List<StageStateListener> stateListeners = new CopyOnWriteArrayList<>();
                logger.warn(
     */
     * the listener inline. Override when the work needs to defer publication — e.g.
     * transition: stamps metrics, fires state listeners (registration order), fires
        }
        this.stage = stage;
    private volatile List<StageTask> tasks = Collections.emptyList();
     * be deferred (network call, lock wait, etc.).
    @Override
    }
     * stay RUNNING forever.
        State previous;
        return remaining == 0;
     * "nothing to do" — the base will short-circuit straight to SUCCEEDED. Throw to mark
            transitionTo(captured != null ? State.FAILED : State.SUCCEEDED);
 *
                onTerminalTransition(target);
                        getStageId(),
            case FAILED -> fireSingle(target, sid, stageType, l -> l.onStageFailure(queryId, sid, getFailure()));
     * decrement the pending counter and transition to SUCCEEDED/FAILED once every
        failure.compareAndSet(null, e);
        this.operationListeners = operationListeners;
        List<AnalyticsOperationListener> operationListeners,
        }
    @Override
 * <p>Subclasses implement {@link #materializeTasks()} (what tasks to run) and
import org.apache.logging.log4j.message.ParameterizedMessage;
        if (task.transitionTo(StageTaskState.SKIPPED)) {
    public final List<StageTask> tasks() {
import java.util.concurrent.CopyOnWriteArrayList;
            try {
        }
