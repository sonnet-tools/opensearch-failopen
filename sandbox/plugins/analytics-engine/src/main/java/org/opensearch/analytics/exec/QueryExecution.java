            if (arrowOom != null) {
            if (isTerminal(previous) || previous == target) {
}
        }
        return graph;
    private final QueryContext config;
        }
 */
     * The root stage's failure is preferred; otherwise the first captured failure across the
        this.listener = listener;
        } else {
     * buffer ... due to memory limit"); this is the only producer of that exact prefix in Arrow Java.
        Exception failure = firstStageFailure();
    public void close() {
     */
    }
 * the root stage's terminal. {@link #cancelAll} is the external cancel entry; {@link #close}
    }
            }
import org.apache.arrow.memory.OutOfMemoryException;
     *       the in-process path (class identity intact) and the cross-Flight-RPC path, where the wire
    private Exception terminalCause(State terminal) {
    }
        State previous;
     */
     * terminal — the state CAS reconciles whichever wins.
            logger.warn(new ParameterizedMessage("[QueryExecution] {} threw for query {}", label, config.queryId()), e);
     * (client disconnect, admin task cancel) — then {@code TaskCancelledException} is the
    ) {
        Consumer<StageExecution> scheduler,
        }
import org.apache.logging.log4j.Logger;
            }
    /**
            logger.debug("[query-{}] Arrow allocator closed cleanly", config.queryId());
     * (no unwrap dance). Until then, this is the chokepoint.
     *       envelope strips the class to a {@code StreamException} carrying Arrow's
        }
        }
     */
     * happens at allocation request time and a {@code CircuitBreakingException} is raised natively
        if (streamFailure instanceof StreamException se && carriesArrowOomMessage(se)) {
 * this file be licensed under the Apache-2.0 license or a
                return false;
            default -> {
    private Exception firstStageFailure() {
            } catch (Exception e) {
    public ExecutionGraph getGraph() {
     * </ul>
     * the user sees "query cancelled" instead of "raise the buffer limit / narrow the query".
            } finally {
                fireListener(target);
    private static CircuitBreakingException arrowOomAsBreaker(Throwable failure) {
            }
     * for the case where {@code root.cancel} throws and the root-state mirror never fires.
import org.opensearch.transport.stream.StreamException;
    private static boolean isTerminal(State s) {
    private final AtomicBoolean closed = new AtomicBoolean(false);
    }
    private static final Logger logger = LogManager.getLogger(QueryExecution.class);
            try {
        return msg != null && msg.contains("Unable to allocate buffer");
        cbe.initCause(cause);
    }
        if (failure != null) {
        CANCELLED
            listener.onFailure(terminalCause(terminal));
     *   <li><b>Arrow allocator exhaustion</b> — {@link OutOfMemoryException} from {@code BufferAllocator}
    private final Consumer<StageExecution> scheduler;
    public State getState() {
import org.opensearch.core.common.breaker.CircuitBreaker;
        RUNNING,
            return failure;
     * <p>TODO: replace this reactive translation with proactive circuit-breaking via Arrow's
     * marker is Arrow's stable {@code BaseAllocator.wrapForeignAllocation} message ("Unable to allocate
                return arrowOom;
    private void closeTerminalSink() {
        if (arrowOom != null) {
     *
 *
     * return a fresh {@link CircuitBreakingException} (HTTP 429). Otherwise {@code null}.
            logger.warn("[query-{}] Arrow allocator closing with {}B still allocated — potential leak", config.queryId(), allocated);
        if (allocated > 0) {
                exec.cancel(reason);
    }
    private final AtomicReference<State> state = new AtomicReference<>(State.CREATED);
        }
 * @opensearch.internal
     * {@link OutOfMemoryException} (in-process) or as a {@link StreamException} whose message contains
                return (CircuitBreakingException) breaker;
        Throwable arrowOom = ExceptionsHelper.unwrap(failure, OutOfMemoryException.class);
        for (StageExecution leaf : graph.leaves()) {
        } else {
    }
    private final ActionListener<Iterable<VectorSchemaRoot>> listener;
    }
     * Bottom-up cancel (external task cancel → leaves fail → cascade) reaches the same
 * Per-query execution: query-level state machine (CREATED → RUNNING → terminal),
            case CANCELLED -> transitionTo(State.CANCELLED);
    private void logAllocatorState() {
    }
                logger.warn(
    private final ExecutionGraph graph;
import org.apache.arrow.memory.BufferAllocator;
     *       is allocation back-pressure (rejected against {@code native.allocator.pool.query.max}), NOT a
     * <p>A captured stage failure is the <em>true</em> cause and wins, even when the parent
        CircuitBreakingException cbe = new CircuitBreakingException(message, CircuitBreaker.Durability.TRANSIENT);
        try {
     */
     * Arrow's allocator-refusal marker (post-Flight-RPC, where the wire envelope stripped the class) —
        BufferAllocator allocator = config.bufferAllocator();
        } while (state.compareAndSet(previous, target) == false);
        Throwable streamFailure = ExceptionsHelper.unwrap(failure, StreamException.class);
    /** On terminal transition: fires user listener exactly once + runs {@link #close()}. */
        return new RuntimeException("Stage " + graph.rootExecution().getStageId() + " " + terminal);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.analytics.exec.stage.StageExecution;
    public enum State {
     *       {@code "Unable to allocate buffer"} marker.
        if (closed.compareAndSet(false, true) == false) return;
        return cbe;
        for (StageExecution exec : graph.allExecutions()) {
        return null;
 * compatible open source license.
            return wrapAsBreaker("native memory allocation rejected: " + se.getMessage(), failure);
        }
        return s == State.SUCCEEDED || s == State.FAILED || s == State.CANCELLED;
    }
    }
    }
        if (isTerminal(target)) {
     *
package org.opensearch.analytics.exec;
     * Single-fire cleanup — closes terminal sink + per-query context. Each step under
        this.config = config;
     * <p>Two memory-pressure failures are re-typed to {@link CircuitBreakingException} (HTTP 429)
     * before being returned, so back-pressure is reported as 429 and {@code FailAwareWeightedRouting}
    public void start() {
                    e
            previous = state.get();
        CREATED,
        QueryContext config,
     * skips replica retry (preventing retry storms):
            }
            DataProducer producer = (DataProducer) graph.rootExecution();
     *
        FAILED,
        ExecutionGraph graph,
     *
import org.apache.logging.log4j.message.ParameterizedMessage;
        logAllocatorState();
        for (StageExecution exec : graph.allExecutions()) {
import org.opensearch.core.action.ActionListener;
            }
     * <p>Arrow's {@code OutOfMemoryException} is the allocator's budget-refusal signal, not a JVM OOM,
     *       JVM {@code OutOfMemoryError}; {@link #arrowOomAsBreaker} translates it to a 429, covering both
            if (breaker != null) {
            if (failure != null) {
            Exception failure = exec.getFailure();
                );
    }
     *
                close();
 *
        return null;
    private static boolean carriesArrowOomMessage(StreamException se) {
import org.opensearch.core.common.breaker.CircuitBreakingException;
    /** Lifecycle states a query execution moves through. */
    public void cancelAll(String reason) {
 * The OpenSearch Contributors require contributions made to
        runQuietly("terminal sink close", this::closeTerminalSink);
 * is end-of-life cleanup fired automatically from any terminal transition.
/**
     * <ul>
        }
            action.run();
        }
        }
     * so it belongs in the same 429/back-pressure class as {@code CircuitBreakingException}. The string
            listener.onResponse(producer.outputSource().readResult());
     * terminal transition; safe to call directly.
        return true;
            CircuitBreakingException arrowOom = arrowOomAsBreaker(failure);
        } catch (Exception e) {
    private void runQuietly(String label, Runnable action) {
        String msg = se.getMessage();
        }
            }
    /** Mirrors root terminal → query terminal. CREATED/RUNNING ignored. */
        if (config.parentTask() instanceof CancellableTask ct && ct.isCancelled()) {
        if (!config.ownsAllocator()) return;
        Exception rootFailure = graph.rootExecution().getFailure();
            }
        if (rootFailure != null) {
import org.opensearch.analytics.exec.stage.DataProducer;
     * <p>Only when NO stage captured a failure is the terminal a genuine external cancel
     * honest answer. The final synthetic fallback covers a CANCELLED/FAILED terminal with no
     * so reporting only {@code TaskCancelledException} would mask the actionable reason —
import org.apache.logging.log4j.LogManager;
     * task is also cancelled: a query self-cancels its remaining stages as a consequence of
                return failure;
        transitionTo(State.CANCELLED);
    private void mirrorRootStateToQuery(StageExecution.State from, StageExecution.State to) {
        SUCCEEDED,
        runQuietly("query context close", config::close);
            Throwable breaker = ExceptionsHelper.unwrap(failure, CircuitBreakingException.class);
    /**
import org.opensearch.analytics.spi.ExchangeSink;
    /** Start execution by scheduling leaf stages bottom-up. */
        this.graph = graph;
    /** Returns the execution graph for post-execution inspection (e.g. profiling). */
    /**
    }
    private static CircuitBreakingException wrapAsBreaker(String message, Throwable cause) {
            case SUCCEEDED -> transitionTo(State.SUCCEEDED);
     * {@code AllocationListener} — wired to register against the parent breaker, so the budget check
            try {
            return wrapAsBreaker("native memory allocation rejected: " + arrowOom.getMessage(), failure);
        this.scheduler = scheduler;
    /** Root stage's captured failure if present, else the first captured failure across the graph. */
/*
     * Top-down cancel. Idempotent. The explicit final {@code transitionTo} is a safety net
        return state.get();
     *   <li><b>Breaker buried in the cause chain</b> — a {@link CircuitBreakingException} wrapped by an
        graph.rootExecution().addStateListener(this::mirrorRootStateToQuery);
     * If {@code failure}'s cause chain carries an Arrow allocator exhaustion — either as a real
 */
    // ─── Internal: query-level state machine ─────────────────────────────
     * the first stage failure (e.g. a {@code ReduceSizeExceededException} or an Arrow OOM),
     * graph (the failing stage is often a child reduce/shard stage that cascaded up).
    }
     * {@link #runQuietly} so a failure in one doesn't skip the other. Auto-fired from any
            sink.close();
public class QueryExecution {
        }
        if (transitionTo(State.RUNNING) == false) {
    }
import org.apache.arrow.vector.VectorSchemaRoot;
    private void fireListener(State terminal) {
    }
        ActionListener<Iterable<VectorSchemaRoot>> listener
import org.opensearch.tasks.CancellableTask;
        StageExecution rootExec = graph.rootExecution();
    public QueryExecution(
            case FAILED -> transitionTo(State.FAILED);
     * Resolves the exception handed to the completion listener on a non-success terminal.
    }
 * single-fire listener + cleanup, root-state mirror that drives query terminal from
        }
import java.util.function.Consumer;
        }
        if (terminal == State.SUCCEEDED) {
        long allocated = allocator.getAllocatedMemory();
     * recorded cause at all.
     *       outer exception is unwrapped and surfaced directly so {@code status()} = 429 (PR #22275).
        do {
        }
                    new ParameterizedMessage("[QueryExecution] cancel threw for stageId={} state={}", exec.getStageId(), exec.getState()),
            scheduler.accept(leaf);
    }
import org.opensearch.ExceptionsHelper;
            return;
import java.util.concurrent.atomic.AtomicBoolean;
        switch (to) {
    /** Releases buffered terminal-sink batches. Arrow leak/double-release surfaces via {@link #runQuietly}. */
import org.opensearch.core.tasks.TaskCancelledException;
            return rootFailure;
    private boolean transitionTo(State target) {
    /**
import java.util.concurrent.atomic.AtomicReference;
        if (rootExec instanceof DataProducer producer && producer.outputSource() instanceof ExchangeSink sink) {
            return new TaskCancelledException("query cancelled");
