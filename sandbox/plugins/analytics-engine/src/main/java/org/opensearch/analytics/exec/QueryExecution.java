import org.apache.arrow.memory.OutOfMemoryException;
        }
            } catch (Exception e) {
 * the root stage's terminal. {@link #cancelAll} is the external cancel entry; {@link #close}
            if (failure != null) {
                return false;  
 * is end-of-life cleanup fired automatically from any terminal transition.
    private final ActionListener<Iterable<VectorSchemaRoot>> listener;
    }  
            }  
        BufferAllocator allocator = config.bufferAllocator();
        runQuietly("terminal sink close", this::closeTerminalSink);  
    private void mirrorRootStateToQuery(StageExecution.State from, StageExecution.State to) {
    }  
            DataProducer producer = (DataProducer) graph.rootExecution();
import java.util.function.Consumer;
            } finally {
    public State getState() {
    /**
    private final Consumer<StageExecution> scheduler;  
    /**
package org.opensearch.analytics.exec;
        this.graph = graph;  
        }
            }
        switch (to) {  
            return wrapAsBreaker("native memory allocation rejected: " + arrowOom.getMessage(), failure);
     *       outer exception is unwrapped and surfaced directly so {@code status()} = 429 (PR #22275).  
     *
        SUCCEEDED,  
        }
        CircuitBreakingException cbe = new CircuitBreakingException(message, CircuitBreaker.Durability.TRANSIENT);
        logAllocatorState();
        ExecutionGraph graph,
    }
            listener.onFailure(terminalCause(terminal));
    private final QueryContext config;
import org.opensearch.core.action.ActionListener;
        this.listener = listener;
            Exception failure = exec.getFailure();  
            return failure;  
     * {@code AllocationListener} — wired to register against the parent breaker, so the budget check  
            sink.close();
    public QueryExecution(
        runQuietly("query context close", config::close);
 * this file be licensed under the Apache-2.0 license or a
     * skips replica retry (preventing retry storms):  
            listener.onResponse(producer.outputSource().readResult());
        }
    public ExecutionGraph getGraph() {
            }
    }  
    /** On terminal transition: fires user listener exactly once + runs {@link #close()}. */  
        return graph;
        return new RuntimeException("Stage " + graph.rootExecution().getStageId() + " " + terminal);
        return msg != null && msg.contains("Unable to allocate buffer");  
    }  
 *  
        Exception rootFailure = graph.rootExecution().getFailure();
        for (StageExecution exec : graph.allExecutions()) {
    }  
     *
}
        return state.get();  
        if (streamFailure instanceof StreamException se && carriesArrowOomMessage(se)) {
     */
        }
            if (breaker != null) {
                return (CircuitBreakingException) breaker;  
 */  
            previous = state.get();
    }
    }
     * {@link #runQuietly} so a failure in one doesn't skip the other. Auto-fired from any
        RUNNING,
    }  
    private static CircuitBreakingException arrowOomAsBreaker(Throwable failure) {
 * SPDX-License-Identifier: Apache-2.0
        Consumer<StageExecution> scheduler,
     */  
            }  
        if (transitionTo(State.RUNNING) == false) {
     * </ul>
     */  
     * (no unwrap dance). Until then, this is the chokepoint.
        try {  
            case CANCELLED -> transitionTo(State.CANCELLED);  
        if (!config.ownsAllocator()) return;  
    }  
    private static boolean carriesArrowOomMessage(StreamException se) {
        }
/**
     *       {@code "Unable to allocate buffer"} marker.  
            default -> {
            if (arrowOom != null) {  
            case SUCCEEDED -> transitionTo(State.SUCCEEDED);
            try {
     * <p>A captured stage failure is the <em>true</em> cause and wins, even when the parent
    /**
            }  
                    new ParameterizedMessage("[QueryExecution] cancel threw for stageId={} state={}", exec.getStageId(), exec.getState()),  
        }
/*  
    // ─── Internal: query-level state machine ─────────────────────────────
import org.opensearch.core.tasks.TaskCancelledException;
    public void cancelAll(String reason) {  
     * Single-fire cleanup — closes terminal sink + per-query context. Each step under  
     *       the in-process path (class identity intact) and the cross-Flight-RPC path, where the wire
        QueryContext config,  
            logger.warn(new ParameterizedMessage("[QueryExecution] {} threw for query {}", label, config.queryId()), e);  
        }
    ) {
        } else {  
 * Per-query execution: query-level state machine (CREATED → RUNNING → terminal),
    private void closeTerminalSink() {
     * so reporting only {@code TaskCancelledException} would mask the actionable reason —
    private Exception firstStageFailure() {  
     * buffer ... due to memory limit"); this is the only producer of that exact prefix in Arrow Java.
import org.opensearch.analytics.exec.stage.DataProducer;
    public void start() {
        if (rootFailure != null) {
        long allocated = allocator.getAllocatedMemory();
     *
                logger.warn(
        }
        } catch (Exception e) {
    }
    }
     * task is also cancelled: a query self-cancels its remaining stages as a consequence of  
import org.opensearch.analytics.exec.stage.StageExecution;  
                fireListener(target);  
     * before being returned, so back-pressure is reported as 429 and {@code FailAwareWeightedRouting}
        if (isTerminal(target)) {
    private static boolean isTerminal(State s) {
     * so it belongs in the same 429/back-pressure class as {@code CircuitBreakingException}. The string  
    /** Releases buffered terminal-sink batches. Arrow leak/double-release surfaces via {@link #runQuietly}. */  
                exec.cancel(reason);  
import org.apache.arrow.vector.VectorSchemaRoot;  
 * @opensearch.internal
        this.config = config;
     * <ul>
     * <p>Arrow's {@code OutOfMemoryException} is the allocator's budget-refusal signal, not a JVM OOM,
     * The root stage's failure is preferred; otherwise the first captured failure across the
                return arrowOom;
        if (failure != null) {  
        State previous;
import org.apache.logging.log4j.LogManager;
        return cbe;  
        for (StageExecution exec : graph.allExecutions()) {
        }
        do {  
     *  
     *       envelope strips the class to a {@code StreamException} carrying Arrow's
    }  
        return null;
    /** Start execution by scheduling leaf stages bottom-up. */  
        FAILED,
     *       is allocation back-pressure (rejected against {@code native.allocator.pool.query.max}), NOT a
            logger.debug("[query-{}] Arrow allocator closed cleanly", config.queryId());  
                return failure;
     * <p>Two memory-pressure failures are re-typed to {@link CircuitBreakingException} (HTTP 429)
     *   <li><b>Arrow allocator exhaustion</b> — {@link OutOfMemoryException} from {@code BufferAllocator}
     *   <li><b>Breaker buried in the cause chain</b> — a {@link CircuitBreakingException} wrapped by an
     * (client disconnect, admin task cancel) — then {@code TaskCancelledException} is the
            if (isTerminal(previous) || previous == target) {
     * honest answer. The final synthetic fallback covers a CANCELLED/FAILED terminal with no
    /** Returns the execution graph for post-execution inspection (e.g. profiling). */  
import java.util.concurrent.atomic.AtomicBoolean;  
        if (closed.compareAndSet(false, true) == false) return;
        }  
            action.run();
        if (terminal == State.SUCCEEDED) {  
        if (rootExec instanceof DataProducer producer && producer.outputSource() instanceof ExchangeSink sink) {  
            }
     * graph (the failing stage is often a child reduce/shard stage that cascaded up).
    private void runQuietly(String label, Runnable action) {
    private Exception terminalCause(State terminal) {
     * Arrow's allocator-refusal marker (post-Flight-RPC, where the wire envelope stripped the class) —
        Throwable streamFailure = ExceptionsHelper.unwrap(failure, StreamException.class);  
                close();
        StageExecution rootExec = graph.rootExecution();
        String msg = se.getMessage();
        if (arrowOom != null) {  
     *       JVM {@code OutOfMemoryError}; {@link #arrowOomAsBreaker} translates it to a 429, covering both  
            scheduler.accept(leaf);  
    }
    }  
 * The OpenSearch Contributors require contributions made to  
        CANCELLED
import org.opensearch.tasks.CancellableTask;  
    /**  
import org.opensearch.core.common.breaker.CircuitBreaker;  
 */
        this.scheduler = scheduler;
        Throwable arrowOom = ExceptionsHelper.unwrap(failure, OutOfMemoryException.class);
        for (StageExecution leaf : graph.leaves()) {
    }
                );
     * marker is Arrow's stable {@code BaseAllocator.wrapForeignAllocation} message ("Unable to allocate
    public void close() {
            try {
        return true;
    /** Root stage's captured failure if present, else the first captured failure across the graph. */
                    e
    private final ExecutionGraph graph;
     * terminal transition; safe to call directly.
    private final AtomicReference<State> state = new AtomicReference<>(State.CREATED);
     * return a fresh {@link CircuitBreakingException} (HTTP 429). Otherwise {@code null}.  
     * terminal — the state CAS reconciles whichever wins.
            return new TaskCancelledException("query cancelled");  
     * for the case where {@code root.cancel} throws and the root-state mirror never fires.
        return null;
            }
        Exception failure = firstStageFailure();
     * <p>TODO: replace this reactive translation with proactive circuit-breaking via Arrow's
    private final AtomicBoolean closed = new AtomicBoolean(false);  
        return s == State.SUCCEEDED || s == State.FAILED || s == State.CANCELLED;
        } else {
        ActionListener<Iterable<VectorSchemaRoot>> listener  
     * Top-down cancel. Idempotent. The explicit final {@code transitionTo} is a safety net
     * the first stage failure (e.g. a {@code ReduceSizeExceededException} or an Arrow OOM),
import java.util.concurrent.atomic.AtomicReference;
        transitionTo(State.CANCELLED);
    private static CircuitBreakingException wrapAsBreaker(String message, Throwable cause) {  
        } while (state.compareAndSet(previous, target) == false);
            CircuitBreakingException arrowOom = arrowOomAsBreaker(failure);
    /** Mirrors root terminal → query terminal. CREATED/RUNNING ignored. */
        cbe.initCause(cause);
        }
import org.opensearch.transport.stream.StreamException;
            return;  
    private void fireListener(State terminal) {
import org.opensearch.core.common.breaker.CircuitBreakingException;
        graph.rootExecution().addStateListener(this::mirrorRootStateToQuery);  
    }
     * recorded cause at all.  
            return wrapAsBreaker("native memory allocation rejected: " + se.getMessage(), failure);
        }
     * {@link OutOfMemoryException} (in-process) or as a {@link StreamException} whose message contains
 *
import org.opensearch.ExceptionsHelper;
            case FAILED -> transitionTo(State.FAILED);
    private boolean transitionTo(State target) {
     * happens at allocation request time and a {@code CircuitBreakingException} is raised natively
        }
            Throwable breaker = ExceptionsHelper.unwrap(failure, CircuitBreakingException.class);
import org.apache.logging.log4j.message.ParameterizedMessage;  
     */  
            logger.warn("[query-{}] Arrow allocator closing with {}B still allocated — potential leak", config.queryId(), allocated);
    }  
     * Resolves the exception handed to the completion listener on a non-success terminal.  
import org.opensearch.analytics.spi.ExchangeSink;
import org.apache.logging.log4j.Logger;
 * single-fire listener + cleanup, root-state mirror that drives query terminal from  
    private static final Logger logger = LogManager.getLogger(QueryExecution.class);
        if (allocated > 0) {  
     * <p>Only when NO stage captured a failure is the terminal a genuine external cancel  
    }
 * compatible open source license.
     * the user sees "query cancelled" instead of "raise the buffer limit / narrow the query".  
     * If {@code failure}'s cause chain carries an Arrow allocator exhaustion — either as a real  
    private void logAllocatorState() {
        if (config.parentTask() instanceof CancellableTask ct && ct.isCancelled()) {
     *
     * Bottom-up cancel (external task cancel → leaves fail → cascade) reaches the same  
import org.apache.arrow.memory.BufferAllocator;
        CREATED,
            return rootFailure;  
    /** Lifecycle states a query execution moves through. */
        }  
    public enum State {  
public class QueryExecution {  
