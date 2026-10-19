                    }
                        // close remains necessary for sinks that own independent inputs.
            });
                            consumeChildMetadata(metadata);  
        });
 */  
     * scheduled on first-child-RUNNING — required for streaming-reduce shapes whose drain
     * different cadence.  
     * onFailure} if materialisation failed (the stage is already FAILED by then). Callers dispatch  
    default void closeChildInput(int childStageId) {}  
     *   <li>FAILED — propagates via {@link #failWithCause} before invoking
                        );
    /** Lifecycle states a stage execution moves through. */
                }  
    int getStageId();
     *   {@link #closeChildInput}, for the same reason.
    // ── Cross-stage metadata channel ──────────────────────────────────────  
    }  
     *   default-mode parents are scheduled here (eager parents already scheduled).  
     */
     * Per-input EOF hook fired by the cascade on every child SUCCEEDED (independent of
                                : new RuntimeException("child stage " + child.getStageId() + " failed without recorded cause")  
     *   <li>CANCELLED — propagates {@link #cancel} before invoking
     * must run concurrently with feeds to avoid deadlocking on a bounded input mpsc.  
                    }
                    }
                            // Eager parents already scheduled on first child RUNNING; default-mode schedules here.
        }
        boolean eager = schedulesEagerly();
    }
                        closeChildInput(childId);  
    // ── Cascade wiring (called at graph build time) ────────────────────────
    /**
                                if (payload != null) {
     * Control-plane payload (broadcast bytes, per-shard stats) handed to the parent via  
        @SuppressWarnings("unchecked")  
     * materialisation has completed: {@code onResponse} after the stage has transitioned (RUNNING
     * <p>Thread-safe under the documented contracts: counters are atomic; child state reads +
     *
                        }  
    }
    }
    /** Per-task terminal callback. Captures failure / drives the stage's terminal transition. */
     * Default {@code false}: parent scheduled on all-children-SUCCEEDED. {@code true} (eager):
import org.opensearch.core.action.ActionListener;  
     * — one {@code runner.run} call per task up front. Stages may override to dispatch with a
     * Starts the stage: materialise its task list, publish it, and transition. Called at most once.
                        // Claim CANCELLED before publishing EOF for the same eager-drain race.
     * that carries retry / terminal logic); the scheduler owns the listener it hands them.  
     */
    /** Append-only; register before {@link #start(ActionListener)}. Fired synchronously on every transition. */  
                        cancel("child stage " + childId + " cancelled");
     * ActionListener#wrap} no-ops when the caller does not need the signal.
        AtomicInteger eagerScheduled = new AtomicInteger(0);  // fires scheduler.accept at most once for eager mode
     * just-finished child's sender. Failure paths fall through to the parent's terminal  
     *   child to enter RUNNING so their work can run concurrently with children's feeds.
     * Called once at graph build time, before any child has transitioned out of CREATED.  
                        }
     *   {@link #publishedMetadata} from each child and hands off via {@link #consumeChildMetadata};
     * by checking {@code getState() == RUNNING} inside {@code onResponse}. Pass {@link
    /**
     * attempt budget, retryable exception classes, alternate selection. The scheduler's
        if (children.isEmpty()) return;  
                        if (pending.decrementAndGet() == 0) {
                        child.cancel("parent " + getStageId() + " " + to);
    /**
                for (StageExecution child : children) {
    /**  
        RUNNING,
     * fires), so listener registration never races with firing.  
     * {@code handleFor} consults this on every failure and dispatches the alternate if any.  
    default void onTaskTerminal(StageTask task, @Nullable Exception cause) {}  
                    if (child.getState().isTerminal() == false) {  
                    }  
                                Object payload = c.publishedMetadata();
     *
        public boolean isTerminal() {
        return null;  
        FAILED,
    /**  
 * SPDX-License-Identifier: Apache-2.0
    void addStateListener(StageStateListener listener);
    void start(ActionListener<Void> onStarted);
        AtomicInteger pending = new AtomicInteger(children.size());  
import org.opensearch.common.Nullable;
     * <p>Materialisation may be deferred behind a network round-trip (e.g. the can-match
     * </ul>  
    default TaskRunner<?> taskRunner() {
        CANCELLED;
     * <p>{@code handleForFactory} is the scheduler's per-task listener builder (the same one
    default List<StageTask> tasks() {  
     * {@link #cancel} are idempotent; this runs during graph build (before any transition
                    }  
     *  
    /** Invoked by the cascade right before parent dispatch. Empty map when no children published. */  
import java.util.function.Consumer;
        for (StageExecution child : children) {
    /** Empty until {@link #start} populates from resolved targets. */
    /** Default {@link TaskRunner#NONE} — stages with runnable tasks override. */
        }  
                        // Claim the terminal state before publishing EOF. For eager parents,  
     * <p>Parent→sibling cancel sweep: on FAILED / CANCELLED, sweep still-running children.
package org.opensearch.analytics.exec.stage;
     * Wires the child→parent state cascade and the reverse parent→sibling cancel sweep.
    default void dispatchTasks(java.util.function.BiFunction<StageExecution, StageTask, ActionListener<Void>> handleForFactory) {
import java.util.concurrent.atomic.AtomicInteger;  
    // ── Scheduler-driven dispatch hooks ───────────────────────────────────  
 * this file be licensed under the Apache-2.0 license or a
                    case RUNNING -> {  
 *
     *  
     *   <li>RUNNING — eager parents ({@link #schedulesEagerly}) schedule on the first
     * post-materialisation state later, on the completion thread. {@code onStarted} signals when  
        return false;  
    State getState();  
     */  
 * compatible open source license.
     * {@link #schedulesEagerly()}). Default no-op; streaming reduce overrides to close the
     * pre-filter), so the stage can still be CREATED when this method returns and only reach its
                                    metadata.put(c.getStageId(), payload);  
        addStateListener((from, to) -> {  
    @Nullable
    default boolean failWithCause(Exception cause) {
    default void consumeChildMetadata(Map<Integer, Object> metadataByChildStageId) {}
                }
                            Map<Integer, Object> metadata = new HashMap<>();
        }  
                switch (to) {
                            if (eager == false) {
     * Dispatch the stage's tasks. Default implementation iterates {@link #tasks()} eagerly
     * <ul>  
        for (StageTask task : tasks()) {
     *   no per-child resources); decrements a counter; on zero, collects
            child.addStateListener((from, to) -> {
     */
        TaskRunner<StageTask> runner = (TaskRunner<StageTask>) taskRunner();
     *
 *
                    default -> {
import org.opensearch.analytics.exec.task.TaskRunner;
    }  
    /**
                        failWithCause(  
    enum State {  
    }
 * @opensearch.internal  
}
        return Optional.empty();  
        SUCCEEDED,  
                        Exception cause = child.getFailure();
                                ? cause
     * {@code Optional.empty()} to give up (default). Owns the entire retry policy —
     * Per-stage retry seam. Return a fresh task pointing at an alternate target, or  
    default Object publishedMetadata() {
        CREATED,
                        closeChildInput(childId);  // per-input EOF; no-op when not multi-input  
    void cancel(String reason);
    default Optional<StageTask> retargetForRetry(StageTask failed, Exception cause) {
                    case FAILED -> {
        return List.of();
                            scheduler.accept(this);
     * when there is work, or a terminal state such as SUCCEEDED for empty targets), {@code
                            cause != null
            runner.run(task, handleForFactory.apply(this, task));
import java.util.HashMap;
/*  
                            for (StageExecution c : children) {  
                                }
 * The OpenSearch Contributors require contributions made to  
    StageMetrics getMetrics();
    @Nullable
 */
            return this == SUCCEEDED || this == FAILED || this == CANCELLED;
                        // The terminal transition performs stage-wide cleanup; the per-child  
import java.util.Optional;
     * through the pre-wired {@code ExchangeSink}. Default null (nothing published).
                        // closeChildInput wakes a concurrent drain that may otherwise complete
                    case SUCCEEDED -> {
                        closeChildInput(childId);
            if (to == State.FAILED || to == State.CANCELLED) {
    default boolean schedulesEagerly() {
     *   terminal-state race as SUCCEEDED.  
     * {@link #consumeChildMetadata} before the parent is scheduled. Distinct from data flow
    /** Idempotent. Transitions to CANCELLED and tears down stage-owned resources. */  
     */
            task.transitionTo(StageTaskState.RUNNING);  
    }
                            }
import java.util.List;  
/**  
                    case CANCELLED -> {
        return false;  
     *   <li>SUCCEEDED — invokes {@link #closeChildInput} (ungated; no-op for backends with  
    Exception getFailure();
     */
import java.util.Map;
     * close, which tears everything down regardless.
    /**  
    /** Capture {@code cause} and transition to FAILED. Returns true if the transition happened. */
    default void attachChildren(List<? extends StageExecution> children, Consumer<StageExecution> scheduler) {
        // child.cancel is a no-op when already terminal, so this is safe under top-down sweeps.
 * One-shot execution unit for a single stage.
    }
public interface StageExecution {
                        if (eager && eagerScheduled.compareAndSet(0, 1)) {
     * <p>Per-child child→parent listener:
        return TaskRunner.NONE;  
    }
                            }
    /** Non-null only when state is {@link State#FAILED}. */  
                        // successfully and make this failure transition a no-op.
            }
     */  
                                scheduler.accept(this);  
                    }  
            int childId = child.getStageId();  
     *   {@link #closeChildInput}, so an eager parent cannot observe EOF and win the
