                onStarted.onResponse(null);
        return remaining == 0;
            }
     * the listener inline. Override when the work needs to defer publication — e.g.  
 * @opensearch.internal  
     * {@code onStarted}. Subclasses customise via {@link #materializeTasks()} for synchronous
import org.opensearch.analytics.backend.AnalyticsOperationListener;
        }  
                    e  
     */
     * Attempt to transition to {@code target}. No-op + returns {@code false} when the
                    new ParameterizedMessage(
            fireSingle(target, sid, stageType, l -> l.onStageStart(queryId, sid, stageType));
     * A skipped task is never dispatched, so nothing else would ever settle it and the stage would
    public final List<StageTask> tasks() {  
     * intercepts BEFORE this fires — see {@code QueryScheduler.handleFor}.
     */
    }
        // Defensive wrap so callers (QueryScheduler dispatch loop, tests) can't mutate the
    }
    }
     * or {@code listener.onFailure}. Synchronous exceptions thrown before either are caught
                l -> l.onStageSuccess(
            materializeTasksAsync(ActionListener.wrap(tasks -> {
    public final void addStateListener(StageStateListener listener) {
                        "[StageExecution] listener threw for stage {} transition {} -> {}",
/**
        try {
                onTerminalTransition(target);
     *
            transitionTo(State.FAILED);
 * The OpenSearch Contributors require contributions made to  
     * Pre-listener cleanup hook. Fires inside {@link #transitionTo} on any terminal
        } while (state.compareAndSet(previous, target) == false);  
            case FAILED -> fireSingle(target, sid, stageType, l -> l.onStageFailure(queryId, sid, getFailure()));
            try {  
    /**  
     */  
    }
                );
     * Ensure if this stage is cancelled, our parent stage is also cancelled if not already
}
        }
 * {@link #start} template (materialise → publish → transition).  
     * transition (SUCCEEDED / FAILED / CANCELLED), BEFORE state listeners run. Use this
    public boolean failWithCause(Exception cause) {
        }
        return state.get();
            }));
        String stageType = getClass().getSimpleName();  
     */  
            previous = state.get();
     * Default lifecycle on per-task terminal: fast-fail on any failure, otherwise
        } catch (Exception e) {
            case SUCCEEDED -> fireSingle(  
        do {
                        : 0,
    }
     * This does NOT mean individual StageTask cancellation fails the parent stages/query,  
        if (recordTaskTerminal(null)) {
            captureFailure(cause);
        } catch (Exception e) {  
            return;  
    }
            listener.onFailure(e);
     *
    /**
    private final String queryId;  
     *  
            }, cause -> {
    }
        }  
                stageType,  
    @Override
     * when there is work, terminal otherwise); {@code onStarted.onFailure} fires if
            Exception captured = getFailure();  
            listener.onResponse(materializeTasks());  
    /**
import org.apache.logging.log4j.message.ParameterizedMessage;  
    public void cancel(String reason) {
    private final AnalyticsQueryTask parentTask;
            metrics.recordStart();  
 *
        failure.compareAndSet(null, e);  
     */
    private final List<StageStateListener> stateListeners = new CopyOnWriteArrayList<>();  
            captureFailure(cause);
    public final State getState() {  
            case RUNNING -> fireSingle(target, sid, stageType, l -> l.onStageStart(queryId, sid, stageType));
 */
            transitionTo(State.SUCCEEDED);
    protected final Stage stage;  
        this.stage = stage;
    }  
            }
    }  
    public final Exception getFailure() {
public abstract class AbstractStageExecution implements StageExecution {
                    new ParameterizedMessage("[StageExecution] onTerminalTransition threw for stage {} -> {}", getStageId(), target),
        }
        Stage stage,  
    protected final boolean transitionTo(State target) {
import java.util.concurrent.atomic.AtomicReference;  
 */  
     * current state is already terminal or equal to {@code target}. On a successful  
                    e
    private final AtomicReference<State> state = new AtomicReference<>(State.CREATED);  
    }  
        State previous;  
     * Default no-op. Exceptions are swallowed (logged) so cleanup failures don't block
import org.opensearch.core.action.ActionListener;  
    /**
     * task is terminal. Retry (when {@link #retargetForRetry} is overridden)
                    sid,  
    public final void start(ActionListener<Void> onStarted) {  
    @Override
                        target
     * Hands the materialised task list to the lifecycle: empty → straight to SUCCEEDED
     * {@code ShardFragmentStageExecution} dispatches a can-match round-trip before publishing.
    @Override  
import java.util.Collections;
    protected AbstractStageExecution(
                logger.warn(
            try {
        if (target.isTerminal()) {
        try {
     * listener delivery.  
        if (transitionTo(State.CANCELLED) == false) return;  
    @Override
        return metrics;  
        for (StageStateListener l : stateListeners) {
            failWithCause(e);
    /**  
            case CANCELLED -> fireSingle(target, sid, stageType, l -> l.onStageCancelled(queryId, sid, "stage cancelled"));  
    protected void materializeTasksAsync(ActionListener<List<StageTask>> listener) {
        int sid = getStageId();
                l.onStateChange(previous, target);
        fireOperationListeners(previous, target);  
                )  
     * Captures {@code cause}, decrements pending counter, returns {@code true} iff
                sid,
        }
 *
    @Nullable
        if (ts.isEmpty()) {
import org.opensearch.analytics.planner.dag.Stage;
     * (no work to do); otherwise publish + transition to RUNNING. Re-entry guard:
        if (cause != null) {  
        String queryId,
    private final List<AnalyticsOperationListener> operationListeners;
     * separately in
                    metrics.getRowsProcessed()
 * SPDX-License-Identifier: Apache-2.0
     * <p>Implementations MUST eventually call exactly one of {@code listener.onResponse}  
     * <p>{@code onStarted.onResponse} fires after the post-materialisation transition (RUNNING
     */
import org.apache.logging.log4j.Logger;
    protected void onTerminalTransition(State terminal) {}
     */  
        this.metrics = new StageMetrics();  
 * <p>Subclasses implement {@link #materializeTasks()} (what tasks to run) and
        // Synthesise onStageStart when a stage skips RUNNING (CREATED → terminal),
        int remaining = pendingTaskTerminal.decrementAndGet();  
            } catch (Exception e) {
                        ? (metrics.getEndTimeMs() - metrics.getStartTimeMs()) * 1_000_000L  
        return Collections.unmodifiableList(tasks);  
    @Override  
    }
     */  
import java.util.concurrent.CopyOnWriteArrayList;
    private volatile List<StageTask> tasks = Collections.emptyList();  
import org.opensearch.common.Nullable;
    }
                        previous,
        }  
     * be deferred (network call, lock wait, etc.).  
                logger.warn(  
 * compatible open source license.
    private void fireSingle(State target, int sid, String stageType, java.util.function.Consumer<AnalyticsOperationListener> call) {  
     * <p>Default sync path; override {@link #materializeTasksAsync} instead when work must
    private void publishTasksAndStart(List<StageTask> ts) {
 * default {@code onTaskTerminal}/{@code cancel}/{@code failWithCause} impls, and the
        if (getState() != State.CREATED) return;  
        // so observers always see a start before any terminal event.  
import java.util.concurrent.atomic.AtomicInteger;
        for (StageTask t : tasks) {
    /**
            );
        if (operationListeners.isEmpty() || queryId == null) return;
        assert remaining >= 0 : "task terminal counter went negative: " + remaining;
                onStarted.onFailure(cause);
                    stageType,
        return stage.getStageId();
                    metrics.getEndTimeMs() > 0 && metrics.getStartTimeMs() > 0
    // state listeners are for stage to stage wiring.
        return runner;
        // stage-owned task list. Cheap — just a view wrapper, not a copy.
            if (previous.isTerminal() || previous == target) {  
import org.opensearch.analytics.exec.task.AnalyticsQueryTask;
            try {
package org.opensearch.analytics.exec.stage;
                call.accept(l);  
import org.apache.logging.log4j.LogManager;
/*  
     * happens inline before this method returns; for the async path it happens on the completion
    protected TaskRunner<?> runner = TaskRunner.NONE;
 * drives every state transition.
     * the stage FAILED (e.g. target resolution failure).  
     * by {@link #start} and treated as failures.
    @Override  
     * every task is now terminal. Caller decides FAILED vs SUCCEEDED.  
    private final AtomicInteger pendingTaskTerminal = new AtomicInteger(0);
    public final void skipTask(StageTask task) {
        if (task.transitionTo(StageTaskState.SKIPPED)) {
    @Override  
        return transitionTo(State.FAILED);
    /** Idempotent — only the first non-null failure is retained. */
     */
    }  
    public TaskRunner<?> taskRunner() {
     * operation listeners. CREATED→terminal also synthesises the onStageStart event so
    /**
        stateListeners.add(listener);
    }
        if (previous == State.CREATED && target.isTerminal()) {
        transitionTo(State.RUNNING);
    protected final StageMetrics metrics;
 * fire loop, failure capture, metrics, default {@code tasks}/{@code runner} accessors,
    private void fireOperationListeners(State previous, State target) {
     * Template: materialise task list (possibly async), publish, transition, then signal  
    }
    public final int getStageId() {
            } catch (Exception e) {
        return failure.get();  
        }  
     * This only handles if a full child stage is cancelled, task management is handled
            onTaskTerminal(task, null);  
    private final AtomicReference<Exception> failure = new AtomicReference<>();
    private static final Logger logger = LogManager.getLogger(AbstractStageExecution.class);
    @Override
            t.transitionTo(StageTaskState.CANCELLED);
        switch (target) {
    /**
     * Marks {@code task} {@link StageTaskState#SKIPPED} and counts it as this task's one terminal.  
    @Override
        if (previous == State.CREATED) {
     * Build this stage's task list. Called once from {@link #start}. Return empty for
     */
                failWithCause(cause);  
            }  
    /**  
    protected final void captureFailure(Exception e) {
                    queryId,
 * optionally {@link #onTerminalTransition(State)} (pre-listener cleanup). The base  
            } catch (Exception e) {  
    /**
            metrics.recordEnd();  
        }
     * Async variant of {@link #materializeTasks()}. Default runs the sync method and invokes
 * Shared mechanics for every {@link StageExecution} variant: state CAS, listener  
            transitionTo(captured != null ? State.FAILED : State.SUCCEEDED);
    protected final boolean recordTaskTerminal(@Nullable Exception cause) {
     * after the call.  
    }
     * a backend sink before a query-level listener tears down the per-query allocator.
        this.operationListeners = operationListeners;
            parentTask.cancel(reason);
            }
        this.queryId = queryId;  
    }  
            }  
        if (parentTask.isCancelled() == false) {
        if (cause != null) {  
                publishTasksAndStart(tasks);  
     * "nothing to do" — the base will short-circuit straight to SUCCEEDED. Throw to mark
 *
 * this file be licensed under the Apache-2.0 license or a
                );
    public final StageMetrics getMetrics() {
     * for stage-internal cleanup that must precede the listener cascade — e.g., closing  
        }  
    @Override
    protected abstract List<StageTask> materializeTasks();
     * no-op if state has advanced past CREATED.  
        }
        AnalyticsQueryTask parentTask  
                return false;
    /** Capture cause, transition to FAILED. Stage-internal cleanup runs via {@link #onTerminalTransition}. */  
        }  
     * observers see a start before the terminal.  
        pendingTaskTerminal.set(ts.size());  
        }
import org.opensearch.analytics.exec.task.TaskRunner;  
                target,
    }
            default -> {
        for (AnalyticsOperationListener l : operationListeners) {
     * decrement the pending counter and transition to SUCCEEDED/FAILED once every  
            return;  
        List<AnalyticsOperationListener> operationListeners,
    @Override
     * work or {@link #materializeTasksAsync} for deferred work (e.g. a can-match round-trip).
     * transition: stamps metrics, fires state listeners (registration order), fires
            onStarted.onFailure(e);
    }
    }
import java.util.List;  
    ) {
                        getStageId(),  
        this.tasks = List.copyOf(ts);
        captureFailure(cause);  
                    ),  
     * materialisation failed (the stage is FAILED by then). For the synchronous path all of this  
     * thread — so callers must act via {@code onStarted}, not by polling {@link #getState()}
        }  
    // operation listeners - for metrics / observability callbacks.
        return true;
     * stay RUNNING forever.
                logger.warn(new ParameterizedMessage("[StageExecution] operation listener threw for stage {} -> {}", sid, target), e);
        this.parentTask = parentTask;
        }
    public void onTaskTerminal(StageTask task, @Nullable Exception cause) {
