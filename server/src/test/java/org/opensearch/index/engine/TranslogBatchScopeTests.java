        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
        final TranslogBatchScope scope = new TranslogBatchScope(translogManager, tracker, SHARD_ID, (reason, ex) -> {}, batch -> {});
    /**
     * failure immediately without blocking on the latch.
     */
        scope.abort(closeFailure);
     * and the engine callback receives it so maybeFailEngine can fail the engine on the underlying tragic event.
import java.util.concurrent.CountDownLatch;
            tracker,
        final TranslogManager translogManager = mock(TranslogManager.class);
        final IndexVersionValue.PendingLocation firstPending = new IndexVersionValue.PendingLocation(scope);
                firstResolverError.set(t);
    public void testAppendFailureFailsEveryPendingAndConsultsMaybeFailEngineOnce() throws Exception {
        final TranslogException thrown = expectThrows(TranslogException.class, scope::finish);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(NO_OPS_PERFORMED));
            final Translog.Location[] locations = new Translog.Location[ops.size()];
     */
        final TranslogManager translogManager = mock(TranslogManager.class);
    }
            batch -> onFinishedCalls.incrementAndGet()
        final IndexVersionValue.PendingLocation firstPending = new IndexVersionValue.PendingLocation(scope);
        // 16 + 16 > 24: the second add closes the first chunk before joining a new one.
     */
        final AlreadyClosedException closed = new AlreadyClosedException("translog is already closed", new IOException("fenced"));
        assertThat(thrown.getShardId(), equalTo(SHARD_ID));
 *
import static org.hamcrest.Matchers.equalTo;
        );
        final Exception e = expectThrows(
        final AtomicReference<Throwable> firstResolverError = new AtomicReference<>();
            return locations;
     */
            SHARD_ID,
            tracker,
        return new Engine.IndexResult(1L, 1L, seqNo, true);
import org.opensearch.test.OpenSearchTestCase;
        final AtomicReference<Exception> maybeFailEngineCause = new AtomicReference<>();
            Long.MAX_VALUE
            final List<?> ops = invocation.getArgument(0);
        final IndexVersionValue.PendingLocation secondPending = new IndexVersionValue.PendingLocation(scope);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));
    /**
            SHARD_ID,
        // A later flush()/finish() on an aborted scope keeps rethrowing the same close failure.
     * compares against the translog's tragic exception.
        assertThat(maybeFailEngineCause.get(), sameInstance(raw));
        });
        final IndexVersionValue.PendingLocation pending = new IndexVersionValue.PendingLocation(scope);
        final TranslogManager translogManager = mock(TranslogManager.class);
        final Thread resolver = new Thread(() -> {
        assertThat(onFinishedCalls.get(), equalTo(1));
        assertThat(maxLocation, sameInstance(second));
import static org.hamcrest.Matchers.nullValue;
        assertThat(maybeFailEngineCalls.get(), equalTo(1));
     * An {@link AlreadyClosedException} from the translog (closed by a tragic event such as a fenced remote upload, or
        assertThat(firstResult.getTranslogLocation(), sameInstance(first));
        when(translogManager.add(anyList())).thenThrow(closed);
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
        final Engine.IndexResult result = indexResult(0L);
            translogManager,
    public void testAddAfterFinishThrowsIllegalState() throws Exception {
public class TranslogBatchScopeTests extends OpenSearchTestCase {
        final TranslogBatchScope byCount = new TranslogBatchScope(
    /**
        // Resolve each pending location from another thread with a bounded wait to prove abort() releases the latch
        // hanging (the latch is already counted down).
            try {
        final AtomicInteger onFinishedCalls = new AtomicInteger();
/**
    public void testFinishAppendsBatchAndAdvancesCheckpoint() throws Exception {
     * by an engine close) must surface as itself, not wrapped: {@code TransportActions#isShardNotAvailableException}
            tracker,
            batch -> {}
     * A successful finish appends through the batch path, assigns every result its location, advances the processed
    private static Engine.IndexResult indexResult(long seqNo) {
        final EngineException closeFailure = new EngineException(SHARD_ID, "engine closed with pending translog batches");
        final Translog.Location second = new Translog.Location(1L, 16L, 16);
 * and keep rethrowing the same failure; an abort/close must release every pending location without hanging.
import org.opensearch.index.translog.TranslogManager;
        }
        );
        assertThat(expectThrows(TranslogException.class, secondPending::resolve), sameInstance(appendFailure));
            (reason, ex) -> {},
            batch -> {},
     * byte cap smaller than two operations every add after the first closes the previous chunk.
     */
            (reason, ex) -> maybeFailEngineCause.set(ex),
        final Engine.IndexResult secondResult = indexResult(1L);
        );
            }
        final IndexVersionValue.PendingLocation firstPending = new IndexVersionValue.PendingLocation(scope);
        assertThat(finishAgain, sameInstance(closeFailure));
import static org.mockito.Mockito.verifyNoInteractions;
import org.opensearch.core.index.shard.ShardId;
    /**
        verifyNoInteractions(translogManager);
                firstResolverDone.countDown();
            } catch (Throwable t) {
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
    public void testConfiguredCapsCloseChunks() throws Exception {
        final Engine.IndexResult firstResult = indexResult(0L);
        // The scope stays failed with that same exception.
 * Deterministic unit tests for {@link TranslogBatchScope}, the bounded translog batch shared by the remote-store
        final IndexVersionValue.PendingLocation pending = new IndexVersionValue.PendingLocation(scope);
        );
    }
        // The second pending location, resolved inline, also observes the close failure without blocking.
            IllegalStateException.class,
                final EngineException observed = expectThrows(EngineException.class, firstPending::resolve);
            translogManager,
        final TranslogBatchScope scope = new TranslogBatchScope(
        assertThat(appends.get(), equalTo(2));
            maybeFailEngineCalls.incrementAndGet();
            translogManager,
            appends.incrementAndGet();
        final Translog.Location location = new Translog.Location(1L, 0L, 16);
        final TranslogManager translogManager = mock(TranslogManager.class);
        assertThat(scope.finish(), sameInstance(location));
        assertTrue(TransportActions.isShardNotAvailableException(thrown));
        final IndexVersionValue.PendingLocation secondPending = new IndexVersionValue.PendingLocation(scope);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(1L));
     * The one case that needs a carrier: a checked {@link IOException} from the translog cannot cross the unchecked
        for (long seqNo = 0; seqNo < 3; seqNo++) {
        assertThat(secondResult.getTranslogLocation(), sameInstance(second));
        // abort() reported the scope finished once and never advanced the checkpoint.
        appends.set(0);
        scope.finish();
    public void testAbortCompletesPendingWithoutHanging() throws Exception {
import static org.hamcrest.Matchers.instanceOf;
    }
        assertThat(appends.get(), equalTo(1));
     * recognises the bare exception and the coordinating node then retries the bulk on the re-promoted primary, exactly
        assertThat(secondPending.resolve(), sameInstance(second));
     * later flush()/finish(). A RuntimeException from the translog (here the TranslogException the translog itself uses
        when(translogManager.add(anyList())).thenAnswer(invocation -> {
import java.io.IOException;
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
        assertThat(expectThrows(TranslogException.class, scope::finish), sameInstance(appendFailure));
        byBytes.add(op(16), indexResult(4L), new IndexVersionValue.PendingLocation(byBytes), 4L);
 * The OpenSearch Contributors require contributions made to
            () -> scope.add(op(16), indexResult(1L), new IndexVersionValue.PendingLocation(scope), 1L)
     * With an operation cap of 3 the fourth add must already have forced an append of the first three, and with a
import java.util.concurrent.atomic.AtomicInteger;
    }
        assertThat(appends.get(), equalTo(2));
        final TranslogException thrown = expectThrows(TranslogException.class, scope::flush);
                assertThat(observed, sameInstance(closeFailure));
        }, "pending-resolver");
        final AtomicInteger appendedOps = new AtomicInteger();
import static org.mockito.Mockito.when;
        resolver.start();
        final EngineException flushAgain = expectThrows(EngineException.class, scope::flush);
     * batch interface, so it is wrapped in the translog's own {@link TranslogException} carrying the shard id, exactly
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
                locations[i] = new Translog.Location(1L, appendedOps.getAndIncrement() * 16L, 16);
        assertThat(maxLocation, sameInstance(location));
     * The chunk caps are per-scope values supplied by the engine from index settings, not the compiled-in defaults.
import static org.mockito.Mockito.mock;
        // abort() after a successful finish must not change anything.
        scope.add(op(16), secondResult, secondPending, 1L);
        assertThat(expectThrows(AlreadyClosedException.class, pending::resolve), sameInstance(closed));
import org.opensearch.index.seqno.LocalCheckpointTracker;
        scope.add(op(16), indexResult(1L), secondPending, 1L);
            translogManager,
 * SPDX-License-Identifier: Apache-2.0
        scope.add(op(16), indexResult(1L), secondPending, 1L);
        final AtomicInteger appends = new AtomicInteger();
     * checkpoint for each seqNo, and returns the greatest location. Confirms the happy path the failure tests invert.
            (reason, ex) -> {},
        final TranslogManager translogManager = mock(TranslogManager.class);
        assertThat(pending.resolve(), sameInstance(location));
import java.util.List;
        assertThat(result.getTranslogLocation(), sameInstance(location));
        // The translog was never consulted by an aborted scope.
        scope.add(op(16), indexResult(0L), firstPending, 0L);
 * this file be licensed under the Apache-2.0 license or a
    public void testAlreadyClosedAppendFailureIsNotWrapped() throws Exception {
     * pending location exceptionally with the same exception the single-operation path would have thrown, consults
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
        final CountDownLatch firstResolverDone = new CountDownLatch(1);
        final IndexVersionValue.PendingLocation pending = new IndexVersionValue.PendingLocation(scope);
        assertThat(expectThrows(TranslogException.class, firstPending::resolve), sameInstance(appendFailure));
    public void testAbortAfterSuccessfulFinishIsNoOp() throws Exception {
            }
        final TranslogManager translogManager = mock(TranslogManager.class);
            SHARD_ID,
        assertThat(thrown, sameInstance(closed));
        assertThat(firstResolverError.get(), nullValue());
        // Every pending location was completed exceptionally with that same instance, so resolve() rethrows it without
        scope.add(op(16), result, pending, 0L);
        final Translog.Location maxLocation = scope.finish();
            Integer.MAX_VALUE,
            maybeFailEngineCause.set(ex);
        );
        );
import java.util.concurrent.atomic.AtomicReference;
     * abort() on a scope that already finished successfully is a no-op: it must not overwrite the committed max
        when(translogManager.add(anyList())).thenReturn(new Translog.Location[] { location });
        final IndexVersionValue.PendingLocation pending = new IndexVersionValue.PendingLocation(scope);
        );
        assertTrue("resolver thread must not hang after abort", firstResolverDone.await(10, TimeUnit.SECONDS));
        final AtomicInteger onFinishedCalls = new AtomicInteger();
        // No checkpoint advanced: nothing was durably appended.
        // flush() triggers the (failing) append and rethrows the translog's own exception, unwrapped.
        assertThat(onFinishedCalls.get(), equalTo(1));
    private static Translog.Operation op(long sizeBytes) {
        }, batch -> onFinishedCalls.incrementAndGet());
        byCount.add(op(16), indexResult(3L), new IndexVersionValue.PendingLocation(byCount), 3L);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(2L));
            translogManager,
        final TranslogManager translogManager = mock(TranslogManager.class);
     * abort() completes every pending location exceptionally with the supplied close failure, marks the scope
        scope.add(op(16), indexResult(0L), firstPending, 0L);
        // Subsequent flush() and finish() keep rethrowing the identical failure and do not re-invoke the translog or
        assertThat(tracker.getProcessedCheckpoint(), equalTo(3L));
            tracker,
        // Reaching the cap appends eagerly: three ops in, one append out, well below the 1,000 default.
            tracker,
     * tragic event), advances no checkpoint, surfaces no max location, and keeps rethrowing the identical failure on any
     */
        scope.add(op(16), firstResult, firstPending, 0L);
        assertThat(secondObserved, sameInstance(closeFailure));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(NO_OPS_PERFORMED));
        assertThat(thrown, sameInstance(appendFailure));
        assertThat(appends.get(), equalTo(1));
        // (no hang). The resolver must observe exactly the close failure.
        when(translogManager.add(anyList())).thenReturn(new Translog.Location[] { new Translog.Location(1L, 0L, 16) });
     * location with a failure nor re-invoke the onFinished callback.
        final TranslogBatchScope scope = new TranslogBatchScope(
 */
    /** A stub operation whose only relevant behaviour here is a fixed size estimate. */
        assertThat(maybeFailEngineCalls.get(), equalTo(1));
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
import org.opensearch.index.translog.TranslogException;
        // consult the engine again.
        assertThat(onFinishedCalls.get(), equalTo(1));
/*
     * as it does when a per-operation {@code Translog#add} throws it. Every pending location observes the same instance
            translogManager,
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
        assertThat(e, instanceOf(IllegalStateException.class));
            for (int i = 0; i < ops.size(); i++) {
    private static final ShardId SHARD_ID = new ShardId("index", "_na_", 0);
        assertThat(tracker.getProcessedCheckpoint(), equalTo(5L));
        final AtomicInteger maybeFailEngineCalls = new AtomicInteger();
    }
     * The failure contract is the per-operation one: when the batched translog append throws, the scope completes every
        final TranslogBatchScope scope = new TranslogBatchScope(translogManager, tracker, SHARD_ID, (reason, ex) -> {}, batch -> {});
    /**
     * for a non-IO write failure) propagates as the very same instance.
    }
        final TranslogBatchScope scope = new TranslogBatchScope(
import static org.hamcrest.Matchers.notNullValue;
        when(translogManager.add(anyList())).thenThrow(appendFailure);
     * as {@code Translog#add} wraps its non-IO failures. The engine still sees the raw IOException, which is what it
import org.opensearch.index.translog.Translog;
import java.util.concurrent.TimeUnit;
            batch -> {}
        assertThat(thrown.getCause(), sameInstance(raw));
import org.opensearch.action.support.TransportActions;
    }
            SHARD_ID,
        scope.add(op(8), indexResult(0L), pending, 0L);
 * compatible open source license.
     * maybeFailEngine exactly once with the raw exception (so the engine fails only if that exception is the translog's
 */
     */
    public void testCheckedAppendFailureIsCarriedByTranslogException() throws Exception {
        final TranslogBatchScope scope = new TranslogBatchScope(
        assertThat(maybeFailEngineCause.get(), sameInstance(closed));
     * Using the scope after a successful finish is a programming error: it must surface as an
            } finally {
 * segment-replication engines. These exercise the scope directly (no engine) so the failure/abort semantics are
        scope.add(op(8), indexResult(0L), pending, 0L);
            (reason, ex) -> {},
            batch -> {},
        final Translog.Location first = new Translog.Location(1L, 0L, 16);
        assertThat(maxLocation, notNullValue());
        return operation;
            SHARD_ID,
        final Translog.Operation operation = mock(Translog.Operation.class);
            SHARD_ID,
        final AtomicReference<Exception> maybeFailEngineCause = new AtomicReference<>();
        // The engine was consulted exactly once with the raw exception, and the scope reported itself finished once.
        scope.abort(new EngineException(SHARD_ID, "late abort"));
        final TranslogBatchScope scope = new TranslogBatchScope(translogManager, tracker, SHARD_ID, (reason, ex) -> {
        byBytes.finish();
     */
            tracker,
        assertThat(expectThrows(TranslogException.class, scope::flush), sameInstance(appendFailure));
        assertThat(pending.resolve(), sameInstance(location));
        final EngineException finishAgain = expectThrows(EngineException.class, scope::finish);
            (reason, ex) -> maybeFailEngineCause.set(ex),
        assertThat(appends.get(), equalTo(1));
import static org.hamcrest.Matchers.sameInstance;
            byCount.add(op(16), indexResult(seqNo), new IndexVersionValue.PendingLocation(byCount), seqNo);
 * verified in isolation: a failed append must fail every pending location, fence the engine, advance no checkpoint,
        final AtomicInteger onFinishedCalls = new AtomicInteger();
        when(operation.estimateSize()).thenReturn(sizeBytes);
        byCount.finish();
    /**
            24
        when(translogManager.add(anyList())).thenReturn(new Translog.Location[] { first, second });
        assertThat(firstPending.resolve(), sameInstance(first));
        final IOException raw = new IOException("disk full");
import static org.mockito.ArgumentMatchers.anyList;
        final AtomicReference<Exception> maybeFailEngineCause = new AtomicReference<>();
        final TranslogBatchScope byBytes = new TranslogBatchScope(
        assertThat(onFinishedCalls.get(), equalTo(1));
        assertThat(flushAgain, sameInstance(closeFailure));
    /**
     * finished, and must not touch the translog. A reader resolving a pending location after abort observes the
            (reason, ex) -> {},
        assertThat(expectThrows(TranslogException.class, pending::resolve), sameInstance(thrown));
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
        final Translog.Location maxLocation = scope.finish();
     * {@link IllegalStateException} rather than silently appending.
    }
        assertThat(tracker.getProcessedCheckpoint(), equalTo(NO_OPS_PERFORMED));
package org.opensearch.index.engine;
        byBytes.add(op(16), indexResult(5L), new IndexVersionValue.PendingLocation(byBytes), 5L);
import org.apache.lucene.store.AlreadyClosedException;
            3,
        final TranslogException appendFailure = new TranslogException(SHARD_ID, "Failed to write batch", new RuntimeException("boom"));
        assertThat(expectThrows(AlreadyClosedException.class, scope::finish), sameInstance(closed));
        final EngineException secondObserved = expectThrows(EngineException.class, secondPending::resolve);
        assertThat(appends.get(), equalTo(0));
    }
        final AlreadyClosedException thrown = expectThrows(AlreadyClosedException.class, scope::finish);
        when(translogManager.add(anyList())).thenThrow(raw);
            batch -> onFinishedCalls.incrementAndGet()
    /**
        assertThat(maybeFailEngineCause.get(), sameInstance(appendFailure));
        final IndexVersionValue.PendingLocation secondPending = new IndexVersionValue.PendingLocation(scope);
        final TranslogManager translogManager = mock(TranslogManager.class);
        scope.add(op(16), indexResult(0L), pending, 0L);
}
    }
