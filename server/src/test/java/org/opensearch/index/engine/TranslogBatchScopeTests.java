        assertThat(maybeFailEngineCause.get(), sameInstance(appendFailure));
        byBytes.add(op(16), indexResult(4L), new IndexVersionValue.PendingLocation(byBytes), 4L);
        final TranslogManager translogManager = mock(TranslogManager.class);
        );
        final TranslogException thrown = expectThrows(TranslogException.class, scope::finish);
        scope.add(op(16), indexResult(1L), secondPending, 1L);
        when(translogManager.add(anyList())).thenThrow(raw);
        final EngineException closeFailure = new EngineException(SHARD_ID, "engine closed with pending translog batches");  
        when(translogManager.add(anyList())).thenReturn(new Translog.Location[] { new Translog.Location(1L, 0L, 16) });
     * An {@link AlreadyClosedException} from the translog (closed by a tragic event such as a fenced remote upload, or
        final Engine.IndexResult firstResult = indexResult(0L);
 *
        when(translogManager.add(anyList())).thenReturn(new Translog.Location[] { location });  
        final AtomicReference<Exception> maybeFailEngineCause = new AtomicReference<>();
        );  
 * The OpenSearch Contributors require contributions made to  
     * maybeFailEngine exactly once with the raw exception (so the engine fails only if that exception is the translog's
            maybeFailEngineCalls.incrementAndGet();
    /**  
            tracker,  
        assertThat(tracker.getProcessedCheckpoint(), equalTo(NO_OPS_PERFORMED));
import java.util.concurrent.TimeUnit;
    /**
            for (int i = 0; i < ops.size(); i++) {  
        assertThat(maxLocation, notNullValue());
        // The translog was never consulted by an aborted scope.
        final Engine.IndexResult result = indexResult(0L);
    }  
            translogManager,  
        // abort() reported the scope finished once and never advanced the checkpoint.  
        final AlreadyClosedException closed = new AlreadyClosedException("translog is already closed", new IOException("fenced"));  
        final IndexVersionValue.PendingLocation firstPending = new IndexVersionValue.PendingLocation(scope);  
            (reason, ex) -> maybeFailEngineCause.set(ex),  
        final CountDownLatch firstResolverDone = new CountDownLatch(1);
        scope.add(op(16), indexResult(0L), firstPending, 0L);  
        assertThat(appends.get(), equalTo(1));  
        assertThat(finishAgain, sameInstance(closeFailure));
        );
    private static Engine.IndexResult indexResult(long seqNo) {  
     * tragic event), advances no checkpoint, surfaces no max location, and keeps rethrowing the identical failure on any
        assertThat(expectThrows(TranslogException.class, pending::resolve), sameInstance(thrown));
import org.apache.lucene.store.AlreadyClosedException;
            SHARD_ID,  
            IllegalStateException.class,
        assertThat(maybeFailEngineCause.get(), sameInstance(raw));  
            SHARD_ID,
        final TranslogManager translogManager = mock(TranslogManager.class);
        }, batch -> onFinishedCalls.incrementAndGet());
    /**  
            translogManager,
        assertThat(tracker.getProcessedCheckpoint(), equalTo(3L));
        assertThat(secondPending.resolve(), sameInstance(second));  
        assertThat(expectThrows(TranslogException.class, secondPending::resolve), sameInstance(appendFailure));  
        final TranslogManager translogManager = mock(TranslogManager.class);  
        );
        assertThat(maybeFailEngineCause.get(), sameInstance(closed));  
    /** A stub operation whose only relevant behaviour here is a fixed size estimate. */
import org.opensearch.action.support.TransportActions;
    }
    /**
     */  
            SHARD_ID,
    public void testAbortAfterSuccessfulFinishIsNoOp() throws Exception {  
import static org.mockito.Mockito.mock;  
 */  
        scope.add(op(16), indexResult(0L), firstPending, 0L);
        final AtomicReference<Exception> maybeFailEngineCause = new AtomicReference<>();  
        );
        final Translog.Location maxLocation = scope.finish();
        assertThat(pending.resolve(), sameInstance(location));
        final TranslogManager translogManager = mock(TranslogManager.class);
import org.opensearch.index.seqno.LocalCheckpointTracker;
 * this file be licensed under the Apache-2.0 license or a
            translogManager,
     * as {@code Translog#add} wraps its non-IO failures. The engine still sees the raw IOException, which is what it
    }
            return locations;  
 * segment-replication engines. These exercise the scope directly (no engine) so the failure/abort semantics are  
            tracker,
        when(operation.estimateSize()).thenReturn(sizeBytes);
     * abort() completes every pending location exceptionally with the supplied close failure, marks the scope
            batch -> onFinishedCalls.incrementAndGet()
        assertThat(expectThrows(TranslogException.class, firstPending::resolve), sameInstance(appendFailure));
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
        scope.add(op(16), result, pending, 0L);
        assertThat(onFinishedCalls.get(), equalTo(1));  
/**
     * compares against the translog's tragic exception.  
        final TranslogBatchScope scope = new TranslogBatchScope(translogManager, tracker, SHARD_ID, (reason, ex) -> {}, batch -> {});
import static org.hamcrest.Matchers.nullValue;  
        return new Engine.IndexResult(1L, 1L, seqNo, true);
        // hanging (the latch is already counted down).
        // No checkpoint advanced: nothing was durably appended.
            translogManager,
        assertThat(tracker.getProcessedCheckpoint(), equalTo(1L));
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
     * location with a failure nor re-invoke the onFinished callback.
     * later flush()/finish(). A RuntimeException from the translog (here the TranslogException the translog itself uses  
     */
     * batch interface, so it is wrapped in the translog's own {@link TranslogException} carrying the shard id, exactly
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
    }
                assertThat(observed, sameInstance(closeFailure));  
        assertThat(expectThrows(AlreadyClosedException.class, scope::finish), sameInstance(closed));
        );
        // The second pending location, resolved inline, also observes the close failure without blocking.
            tracker,
                final EngineException observed = expectThrows(EngineException.class, firstPending::resolve);
import static org.hamcrest.Matchers.sameInstance;
     * by an engine close) must surface as itself, not wrapped: {@code TransportActions#isShardNotAvailableException}
     */
        when(translogManager.add(anyList())).thenThrow(closed);
     * The chunk caps are per-scope values supplied by the engine from index settings, not the compiled-in defaults.  
                firstResolverError.set(t);
        assertThat(maybeFailEngineCalls.get(), equalTo(1));  
    public void testAppendFailureFailsEveryPendingAndConsultsMaybeFailEngineOnce() throws Exception {  
            (reason, ex) -> {},  
/*  
    /**
        // (no hang). The resolver must observe exactly the close failure.  
import static org.hamcrest.Matchers.instanceOf;
        appends.set(0);
 * verified in isolation: a failed append must fail every pending location, fence the engine, advance no checkpoint,
     * failure immediately without blocking on the latch.
        assertThat(appends.get(), equalTo(2));
            maybeFailEngineCause.set(ex);  
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
            tracker,  
     */  
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);  
        // Resolve each pending location from another thread with a bounded wait to prove abort() releases the latch
public class TranslogBatchScopeTests extends OpenSearchTestCase {
        scope.add(op(8), indexResult(0L), pending, 0L);
        final TranslogManager translogManager = mock(TranslogManager.class);
        when(translogManager.add(anyList())).thenReturn(new Translog.Location[] { first, second });
        byBytes.finish();
import static org.hamcrest.Matchers.notNullValue;
        assertThat(onFinishedCalls.get(), equalTo(1));
        assertThat(firstResolverError.get(), nullValue());  
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.index.translog.Translog;
        assertThat(scope.finish(), sameInstance(location));
            SHARD_ID,
        final IndexVersionValue.PendingLocation firstPending = new IndexVersionValue.PendingLocation(scope);  
        assertThat(thrown, sameInstance(closed));
    }
        assertThat(appends.get(), equalTo(1));
        final EngineException finishAgain = expectThrows(EngineException.class, scope::finish);
            batch -> {},  
        final AtomicInteger onFinishedCalls = new AtomicInteger();  
        });
        final TranslogException appendFailure = new TranslogException(SHARD_ID, "Failed to write batch", new RuntimeException("boom"));
        assertThat(tracker.getProcessedCheckpoint(), equalTo(NO_OPS_PERFORMED));
     * for a non-IO write failure) propagates as the very same instance.
     * {@link IllegalStateException} rather than silently appending.  
        final IndexVersionValue.PendingLocation pending = new IndexVersionValue.PendingLocation(scope);
        final TranslogBatchScope scope = new TranslogBatchScope(translogManager, tracker, SHARD_ID, (reason, ex) -> {}, batch -> {});
    public void testFinishAppendsBatchAndAdvancesCheckpoint() throws Exception {
     * recognises the bare exception and the coordinating node then retries the bulk on the re-promoted primary, exactly  
        final TranslogBatchScope scope = new TranslogBatchScope(
 * Deterministic unit tests for {@link TranslogBatchScope}, the bounded translog batch shared by the remote-store
     */
        assertThat(flushAgain, sameInstance(closeFailure));  
        // A later flush()/finish() on an aborted scope keeps rethrowing the same close failure.
        assertThat(pending.resolve(), sameInstance(location));  
        final TranslogBatchScope scope = new TranslogBatchScope(  
        final AlreadyClosedException thrown = expectThrows(AlreadyClosedException.class, scope::finish);
     * Using the scope after a successful finish is a programming error: it must surface as an
            batch -> {},
        assertThat(secondObserved, sameInstance(closeFailure));
        final AtomicReference<Throwable> firstResolverError = new AtomicReference<>();
        assertThat(tracker.getProcessedCheckpoint(), equalTo(5L));  
        final AtomicInteger appends = new AtomicInteger();  
        scope.abort(new EngineException(SHARD_ID, "late abort"));  
        // flush() triggers the (failing) append and rethrows the translog's own exception, unwrapped.
            (reason, ex) -> {},
    public void testAddAfterFinishThrowsIllegalState() throws Exception {
            batch -> {}
        final Translog.Location maxLocation = scope.finish();
            SHARD_ID,
            }
        assertThat(thrown.getCause(), sameInstance(raw));  
            byCount.add(op(16), indexResult(seqNo), new IndexVersionValue.PendingLocation(byCount), seqNo);
        final Thread resolver = new Thread(() -> {  
}
        byCount.finish();  
        assertThat(tracker.getProcessedCheckpoint(), equalTo(0L));  
            () -> scope.add(op(16), indexResult(1L), new IndexVersionValue.PendingLocation(scope), 1L)  
     * With an operation cap of 3 the fourth add must already have forced an append of the first three, and with a
        final IndexVersionValue.PendingLocation secondPending = new IndexVersionValue.PendingLocation(scope);
        assertThat(result.getTranslogLocation(), sameInstance(location));
import java.util.concurrent.atomic.AtomicReference;  
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;
        assertThat(appends.get(), equalTo(0));  
        // abort() after a successful finish must not change anything.
        final AtomicInteger onFinishedCalls = new AtomicInteger();
 * compatible open source license.
        scope.add(op(16), secondResult, secondPending, 1L);  
        }, "pending-resolver");  
        final TranslogBatchScope scope = new TranslogBatchScope(
            final List<?> ops = invocation.getArgument(0);  
        scope.finish();
    public void testCheckedAppendFailureIsCarriedByTranslogException() throws Exception {
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
        assertTrue("resolver thread must not hang after abort", firstResolverDone.await(10, TimeUnit.SECONDS));
     */  
    /**
        assertThat(thrown.getShardId(), equalTo(SHARD_ID));
            tracker,
            translogManager,  
        final AtomicInteger onFinishedCalls = new AtomicInteger();  
        scope.add(op(16), firstResult, firstPending, 0L);
        assertThat(firstPending.resolve(), sameInstance(first));
        byBytes.add(op(16), indexResult(5L), new IndexVersionValue.PendingLocation(byBytes), 5L);
        scope.add(op(16), indexResult(1L), secondPending, 1L);  
        final TranslogManager translogManager = mock(TranslogManager.class);  
    public void testAlreadyClosedAppendFailureIsNotWrapped() throws Exception {
    /**
        final Translog.Location first = new Translog.Location(1L, 0L, 16);  
     * and the engine callback receives it so maybeFailEngine can fail the engine on the underlying tragic event.
    private static Translog.Operation op(long sizeBytes) {  
        // 16 + 16 > 24: the second add closes the first chunk before joining a new one.
        assertThat(expectThrows(TranslogException.class, scope::finish), sameInstance(appendFailure));
        final IndexVersionValue.PendingLocation pending = new IndexVersionValue.PendingLocation(scope);  
        when(translogManager.add(anyList())).thenThrow(appendFailure);  
            Long.MAX_VALUE
        final IndexVersionValue.PendingLocation secondPending = new IndexVersionValue.PendingLocation(scope);
        final TranslogBatchScope scope = new TranslogBatchScope(
     * abort() on a scope that already finished successfully is a no-op: it must not overwrite the committed max  
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);  
package org.opensearch.index.engine;
 * SPDX-License-Identifier: Apache-2.0
    }  
        final Translog.Operation operation = mock(Translog.Operation.class);
        // Reaching the cap appends eagerly: three ops in, one append out, well below the 1,000 default.
            }
        assertThat(tracker.getProcessedCheckpoint(), equalTo(NO_OPS_PERFORMED));
        // The scope stays failed with that same exception.  
     * The failure contract is the per-operation one: when the batched translog append throws, the scope completes every
     */
        scope.abort(closeFailure);
        verifyNoInteractions(translogManager);
        final Engine.IndexResult secondResult = indexResult(1L);
        final AtomicInteger maybeFailEngineCalls = new AtomicInteger();  
    }
        assertThat(expectThrows(AlreadyClosedException.class, pending::resolve), sameInstance(closed));
    }  
import java.util.List;
     * A successful finish appends through the batch path, assigns every result its location, advances the processed
        final TranslogBatchScope byBytes = new TranslogBatchScope(
    private static final ShardId SHARD_ID = new ShardId("index", "_na_", 0);  
        assertThat(expectThrows(TranslogException.class, scope::flush), sameInstance(appendFailure));  
 */  
     * checkpoint for each seqNo, and returns the greatest location. Confirms the happy path the failure tests invert.
        assertThat(maxLocation, sameInstance(location));
        final TranslogBatchScope byCount = new TranslogBatchScope(
    public void testConfiguredCapsCloseChunks() throws Exception {
        when(translogManager.add(anyList())).thenAnswer(invocation -> {
        scope.add(op(8), indexResult(0L), pending, 0L);  
        );  
        // Subsequent flush() and finish() keep rethrowing the identical failure and do not re-invoke the translog or
            24  
            SHARD_ID,
        }  
            Integer.MAX_VALUE,
            (reason, ex) -> {},
        final EngineException secondObserved = expectThrows(EngineException.class, secondPending::resolve);  
        assertTrue(TransportActions.isShardNotAvailableException(thrown));  
                firstResolverDone.countDown();
        final IndexVersionValue.PendingLocation pending = new IndexVersionValue.PendingLocation(scope);
        final Translog.Location location = new Translog.Location(1L, 0L, 16);
        final Exception e = expectThrows(
     * The one case that needs a carrier: a checked {@link IOException} from the translog cannot cross the unchecked  
import static org.mockito.ArgumentMatchers.anyList;
        final IndexVersionValue.PendingLocation pending = new IndexVersionValue.PendingLocation(scope);  
            } finally {  
        // Every pending location was completed exceptionally with that same instance, so resolve() rethrows it without  
        final EngineException flushAgain = expectThrows(EngineException.class, scope::flush);
        final IndexVersionValue.PendingLocation secondPending = new IndexVersionValue.PendingLocation(scope);
     */
import static org.mockito.Mockito.verifyNoInteractions;
        final IndexVersionValue.PendingLocation firstPending = new IndexVersionValue.PendingLocation(scope);
        final AtomicInteger appendedOps = new AtomicInteger();
        // The engine was consulted exactly once with the raw exception, and the scope reported itself finished once.
        return operation;  
            } catch (Throwable t) {
        byCount.add(op(16), indexResult(3L), new IndexVersionValue.PendingLocation(byCount), 3L);
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
            batch -> onFinishedCalls.incrementAndGet()  
            (reason, ex) -> {},  
        final TranslogManager translogManager = mock(TranslogManager.class);
    /**
import static org.hamcrest.Matchers.equalTo;  
        assertThat(e, instanceOf(IllegalStateException.class));
        resolver.start();  
            try {
        assertThat(thrown, sameInstance(appendFailure));
        final Translog.Location second = new Translog.Location(1L, 16L, 16);
        // consult the engine again.
        assertThat(onFinishedCalls.get(), equalTo(1));
        assertThat(appends.get(), equalTo(2));
import org.opensearch.test.OpenSearchTestCase;
     * pending location exceptionally with the same exception the single-operation path would have thrown, consults  
        final TranslogManager translogManager = mock(TranslogManager.class);
        assertThat(maybeFailEngineCalls.get(), equalTo(1));
            (reason, ex) -> maybeFailEngineCause.set(ex),
import static org.mockito.Mockito.when;
     * byte cap smaller than two operations every add after the first closes the previous chunk.
        assertThat(appends.get(), equalTo(1));
            3,
     * finished, and must not touch the translog. A reader resolving a pending location after abort observes the  
import org.opensearch.index.translog.TranslogManager;
    public void testAbortCompletesPendingWithoutHanging() throws Exception {  
        assertThat(secondResult.getTranslogLocation(), sameInstance(second));
            translogManager,  
import java.util.concurrent.CountDownLatch;  
     * as it does when a per-operation {@code Translog#add} throws it. Every pending location observes the same instance
            tracker,
        assertThat(onFinishedCalls.get(), equalTo(1));
        for (long seqNo = 0; seqNo < 3; seqNo++) {
        assertThat(maxLocation, sameInstance(second));
    }
 * and keep rethrowing the same failure; an abort/close must release every pending location without hanging.
            final Translog.Location[] locations = new Translog.Location[ops.size()];
            appends.incrementAndGet();
                locations[i] = new Translog.Location(1L, appendedOps.getAndIncrement() * 16L, 16);
        final AtomicReference<Exception> maybeFailEngineCause = new AtomicReference<>();
            batch -> {}
import org.opensearch.index.translog.TranslogException;  
        final TranslogException thrown = expectThrows(TranslogException.class, scope::flush);  
        scope.add(op(16), indexResult(0L), pending, 0L);
        final TranslogBatchScope scope = new TranslogBatchScope(translogManager, tracker, SHARD_ID, (reason, ex) -> {
        final IOException raw = new IOException("disk full");
        assertThat(firstResult.getTranslogLocation(), sameInstance(first));  
        assertThat(tracker.getProcessedCheckpoint(), equalTo(2L));  
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
    }
