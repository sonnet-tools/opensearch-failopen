        for (StageTask task : tasks()) {
                                scheduler.accept(this);
    default TaskRunner<?> taskRunner() {
    default List<StageTask> tasks() {
     *   <li>FAILED — propagates via {@link #failWithCause} before invoking
     * through the pre-wired {@code ExchangeSink}. Default null (nothing published).
     *   <li>CANCELLED — propagates {@link #cancel} before invoking
        AtomicInteger pending = new AtomicInteger(children.size());
            child.addStateListener((from, to) -> {
     * attempt budget, retryable exception classes, alternate selection. The scheduler's
     */
        return Optional.empty();
                    case CANCELLED -> {
    /**
    default Object publishedMetadata() {
     *   {@link #closeChildInput}, so an eager parent cannot observe EOF and win the
                        closeChildInput(childId);  // per-input EOF; no-op when not multi-input
    StageMetrics getMetrics();
            int childId = child.getStageId();
 *
import java.util.concurrent.atomic.AtomicInteger;
    @Nullable
 * SPDX-License-Identifier: Apache-2.0
                    if (child.getState().isTerminal() == false) {
    void cancel(String reason);
     * <p>Materialisation may be deferred behind a network round-trip (e.g. the can-match
    default Optional<StageTask> retargetForRetry(StageTask failed, Exception cause) {
            task.transitionTo(StageTaskState.RUNNING);
                        // closeChildInput wakes a concurrent drain that may otherwise complete
    }
     * onFailure} if materialisation failed (the stage is already FAILED by then). Callers dispatch
                    }
     */
                    }
        return false;
                            Map<Integer, Object> metadata = new HashMap<>();
                        // Claim the terminal state before publishing EOF. For eager parents,
    }
                        );
        // child.cancel is a no-op when already terminal, so this is safe under top-down sweeps.
                            cause != null
     * Per-input EOF hook fired by the cascade on every child SUCCEEDED (independent of
 */
                        if (eager && eagerScheduled.compareAndSet(0, 1)) {
 */
     * scheduled on first-child-RUNNING — required for streaming-reduce shapes whose drain
    // ── Cascade wiring (called at graph build time) ────────────────────────
        return false;
     * ActionListener#wrap} no-ops when the caller does not need the signal.
    /**
     * <p>{@code handleForFactory} is the scheduler's per-task listener builder (the same one
     * <ul>
     * close, which tears everything down regardless.
     *
                        closeChildInput(childId);
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
                                if (payload != null) {
import java.util.List;
    /** Idempotent. Transitions to CANCELLED and tears down stage-owned resources. */
        return TaskRunner.NONE;
     * <p>Thread-safe under the documented contracts: counters are atomic; child state reads +
    /**
    default boolean schedulesEagerly() {
        return null;
 * The OpenSearch Contributors require contributions made to
                            for (StageExecution c : children) {
     * <p>Per-child child→parent listener:
        CREATED,
    /**
        CANCELLED;
     * when there is work, or a terminal state such as SUCCEEDED for empty targets), {@code
                        // Claim CANCELLED before publishing EOF for the same eager-drain race.
    /**
    /** Invoked by the cascade right before parent dispatch. Empty map when no children published. */
    @Nullable
import org.opensearch.common.Nullable;
     * Default {@code false}: parent scheduled on all-children-SUCCEEDED. {@code true} (eager):
        SUCCEEDED,
                        if (pending.decrementAndGet() == 0) {
     * Per-stage retry seam. Return a fresh task pointing at an alternate target, or
    default void attachChildren(List<? extends StageExecution> children, Consumer<StageExecution> scheduler) {
    }
            runner.run(task, handleForFactory.apply(this, task));
    }
    // ── Scheduler-driven dispatch hooks ───────────────────────────────────
     * {@link #cancel} are idempotent; this runs during graph build (before any transition
                    }
                    case SUCCEEDED -> {
     * different cadence.
    void addStateListener(StageStateListener listener);
                            scheduler.accept(this);
     *
                        child.cancel("parent " + getStageId() + " " + to);
import java.util.Map;
     * {@code handleFor} consults this on every failure and dispatches the alternate if any.
    /** Per-task terminal callback. Captures failure / drives the stage's terminal transition. */
    }
    int getStageId();
                    case FAILED -> {
    /**
            });
     * pre-filter), so the stage can still be CREATED when this method returns and only reach its
                                    metadata.put(c.getStageId(), payload);
}
     *
     * that carries retry / terminal logic); the scheduler owns the listener it hands them.
                        closeChildInput(childId);
    State getState();
     */
 *
                        }
     * {@link #consumeChildMetadata} before the parent is scheduled. Distinct from data flow
                        }
/*
package org.opensearch.analytics.exec.stage;
                        // successfully and make this failure transition a no-op.
    Exception getFailure();
                            // Eager parents already scheduled on first child RUNNING; default-mode schedules here.
                                ? cause
    /** Append-only; register before {@link #start(ActionListener)}. Fired synchronously on every transition. */
import java.util.HashMap;
            if (to == State.FAILED || to == State.CANCELLED) {
 * One-shot execution unit for a single stage.
     */
     *   {@link #publishedMetadata} from each child and hands off via {@link #consumeChildMetadata};
     *   <li>SUCCEEDED — invokes {@link #closeChildInput} (ungated; no-op for backends with
        AtomicInteger eagerScheduled = new AtomicInteger(0);  // fires scheduler.accept at most once for eager mode
                            }
                            if (eager == false) {
     * <p>Parent→sibling cancel sweep: on FAILED / CANCELLED, sweep still-running children.
     * post-materialisation state later, on the completion thread. {@code onStarted} signals when
     * must run concurrently with feeds to avoid deadlocking on a bounded input mpsc.
     *   default-mode parents are scheduled here (eager parents already scheduled).
    /** Lifecycle states a stage execution moves through. */
import org.opensearch.analytics.exec.task.TaskRunner;
     * Dispatch the stage's tasks. Default implementation iterates {@link #tasks()} eagerly
                                }
import org.opensearch.core.action.ActionListener;
     *   {@link #closeChildInput}, for the same reason.
                        // The terminal transition performs stage-wide cleanup; the per-child
    }
        boolean eager = schedulesEagerly();
     *   terminal-state race as SUCCEEDED.
                switch (to) {
    // ── Cross-stage metadata channel ──────────────────────────────────────
     * just-finished child's sender. Failure paths fall through to the parent's terminal
        FAILED,
     * Control-plane payload (broadcast bytes, per-shard stats) handed to the parent via
     * Called once at graph build time, before any child has transitioned out of CREATED.
 * compatible open source license.
import java.util.function.Consumer;
                    default -> {
    }
    /** Empty until {@link #start} populates from resolved targets. */
        return List.of();
    default void onTaskTerminal(StageTask task, @Nullable Exception cause) {}
import java.util.Optional;
        for (StageExecution child : children) {
     * </ul>
                    case RUNNING -> {
        }
                            consumeChildMetadata(metadata);
                        // close remains necessary for sinks that own independent inputs.
    default void dispatchTasks(java.util.function.BiFunction<StageExecution, StageTask, ActionListener<Void>> handleForFactory) {
    }
                    }
     * Wires the child→parent state cascade and the reverse parent→sibling cancel sweep.
        @SuppressWarnings("unchecked")
    enum State {
    /** Default {@link TaskRunner#NONE} — stages with runnable tasks override. */
        public boolean isTerminal() {
        RUNNING,
        TaskRunner<StageTask> runner = (TaskRunner<StageTask>) taskRunner();
    default void consumeChildMetadata(Map<Integer, Object> metadataByChildStageId) {}
    }
        if (children.isEmpty()) return;
     */
     *   child to enter RUNNING so their work can run concurrently with children's feeds.
                    }
     */
     * {@code Optional.empty()} to give up (default). Owns the entire retry policy —
     * materialisation has completed: {@code onResponse} after the stage has transitioned (RUNNING
     *   no per-child resources); decrements a counter; on zero, collects
    default void closeChildInput(int childStageId) {}
    /**
     * — one {@code runner.run} call per task up front. Stages may override to dispatch with a
     * by checking {@code getState() == RUNNING} inside {@code onResponse}. Pass {@link
            }
     *
 * @opensearch.internal
                    }
                }
     * {@link #schedulesEagerly()}). Default no-op; streaming reduce overrides to close the
                        Exception cause = child.getFailure();
                for (StageExecution child : children) {
        });
                                : new RuntimeException("child stage " + child.getStageId() + " failed without recorded cause")
public interface StageExecution {
    /** Capture {@code cause} and transition to FAILED. Returns true if the transition happened. */
/**
 * this file be licensed under the Apache-2.0 license or a
     * fires), so listener registration never races with firing.
    void start(ActionListener<Void> onStarted);
        }
                                Object payload = c.publishedMetadata();
                        cancel("child stage " + childId + " cancelled");
        }
     */
                        failWithCause(
                            }
    default boolean failWithCause(Exception cause) {
     *
     * Starts the stage: materialise its task list, publish it, and transition. Called at most once.
                }
        addStateListener((from, to) -> {
     *   <li>RUNNING — eager parents ({@link #schedulesEagerly}) schedule on the first
    /** Non-null only when state is {@link State#FAILED}. */
