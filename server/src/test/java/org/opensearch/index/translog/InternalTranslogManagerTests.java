                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
                new InternalTranslogFactory(),
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
                createTranslogDeletionPolicy(INDEX_SETTINGS),
                            syncListenerInvoked.set(true);
                new InternalTranslogFactory(),
            // Acquiring the history retention lock pins a translog generation.
                primaryTerm,
import org.opensearch.index.seqno.SequenceNumbers;
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().estimatedNumberOfOperations());
            AtomicInteger opsRecovered = new AtomicInteger();
        }
                }
            expectThrows(AssertionError.class, deletionPolicy::assertNoOpenTranslogRefs);
     * it is held, and releases that generation when closed. This is the translog-layer support that
            translogManager.close();
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
            translogManager.syncTranslog();
                primaryTerm,
 * The OpenSearch Contributors require contributions made to
            assertEquals(0, deletionPolicy.pendingTranslogRefCount());
                    @Override
            translogManager.close();
                () -> tracker,
                tracker.markSeqNoAsProcessed(i);
            primaryTerm.set(randomLongBetween(primaryTerm.get(), Long.MAX_VALUE));
                Engine.Index index = indexForDoc(doc);
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
    public void testTranslogRollsGeneration() throws IOException {
            final int docs = randomIntBetween(1, 100);
            retentionLock.close();
            // While the lock is held there is an open translog reference.
import org.opensearch.common.util.BigArrays;
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                globalCheckpoint::get,
        } finally {
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
                translogUUID,
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
                        beginTranslogRecoveryInvoked.set(true);
                globalCheckpoint::get,
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
            assertEquals(maxSeqNo + 1, opsRecovered.get());
    public void testRecoveryFromTranslog() throws IOException {
            }
            globalCheckpoint::get,
            assertEquals(maxSeqNo + 1, opsRecoveredFromTranslog);
            new InternalTranslogFactory(),
                }
        InternalTranslogManager translogManager = null;
                TranslogOperationHelper.DEFAULT
            );
/*
                        onTranslogRecoveryInvoked.set(true);
            translogManager.close();
        final AtomicInteger localCheckpoint = new AtomicInteger(randomIntBetween(0, maxSeqNo.get()));
                },
            assertNotNull(retentionLock);
 * compatible open source license.
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
                translogManager.rollTranslogGeneration();
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
                new InternalTranslogFactory(),
                translogUUID,
import java.util.concurrent.atomic.AtomicLong;
            Engine.Index index = indexForDoc(doc);
        try {
        }
public class InternalTranslogManagerTests extends TranslogManagerTestCase {
            assertTrue(onTranslogRecoveryInvoked.get());
            translogManager.close();
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
     */
        } finally {
                primaryTerm,
            translogManager = new InternalTranslogManager(
        try {
                new InternalTranslogFactory(),
                Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), i, true);
            shardId,
            AtomicInteger opsRecovered = new AtomicInteger();
                    public void onBeginTranslogRecovery() {
            translogManager = new InternalTranslogManager(
                () -> new LocalCheckpointTracker(maxSeqNo.get(), localCheckpoint.get()),
     * {@link Translog#acquireRetentionLock()} that pins a translog generation in the deletion policy while
            assertEquals(0, opsRecovered.get());
            new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
            final Closeable retentionLock = translogManager.acquireHistoryRetentionLock();
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().getUncommittedOperations());
                globalCheckpoint::get,
            );
            for (int i = 0; i < docs; i++) {
     */
            translogManager.close();
            assertEquals(maxSeqNo + 1, opsRecovered.get());
                translogUUID,
            translogManager.close();
            long maxSeqNo = tracker.getMaxSeqNo();
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
    }
            );
            translogManager = new InternalTranslogManager(
                translogUUID,
            final int docs = randomIntBetween(1, 10);
            for (int i = 0; i < docs; i++) {
                translogUUID,
            assertEquals(0, opsRecoveredFromTranslog);
                while ((operation = snapshot.next()) != null) {
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
                TranslogOperationHelper.DEFAULT
                primaryTerm,
            for (int i = 0; i < docs; i++) {
                () -> tracker,
                new InternalTranslogFactory(),
            );
                primaryTerm,
        }
            translogManager.close();
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().getUncommittedOperations());
                tracker.markSeqNoAsProcessed(i);
                new TranslogEventListener() {
    /**
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
        LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
import java.io.Closeable;
            TranslogOperationHelper.DEFAULT
            AtomicReference<InternalTranslogManager> translogManagerAtomicReference = new AtomicReference<>();
            // No retention locks are held before acquiring one.
                globalCheckpoint::get,
            int opsRecoveredFromTranslog = translogManager.recoverFromTranslog((snapshot) -> {
        final AtomicBoolean beginTranslogRecoveryInvoked = new AtomicBoolean(false);
        LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
        } finally {
                () -> Boolean.TRUE,
                () -> {},
                TranslogOperationHelper.DEFAULT
        }
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
     * nothing can have superseded this copy, a handoff transfer is a no-op, and an aborted handoff leaves it free to
                        }
                () -> new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED),
            assertEquals(maxSeqNo + 1, opsRecoveredFromTranslog);
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
                    opsRecovered.incrementAndGet();
            assertSame(deletionPolicy, translogManager.getTranslog().getDeletionPolicy());
                () -> new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED),
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().estimatedNumberOfOperations());
            deletionPolicy.assertNoOpenTranslogRefs();
                    }
                        try {
        InternalTranslogManager translogManager = new InternalTranslogManager(
    public void testTranslogSync() throws IOException {
import org.opensearch.common.util.concurrent.ReleasableLock;
            // Releasing the lock releases the pinned generation.
 * SPDX-License-Identifier: Apache-2.0
                }
            TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
    /**
                translogUUID,
                translogManager.rollTranslogGeneration();
            int opsRecoveredFromTranslog = translogManager.recoverFromTranslog((snapshot) -> {
import java.util.concurrent.atomic.AtomicInteger;
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            translogManager = new InternalTranslogManager(
            translogManagerAtomicReference.set(translogManager);
        final AtomicInteger maxSeqNo = new AtomicInteger(randomIntBetween(0, 128));
            );
                () -> {},
                Engine.Index index = indexForDoc(doc);
            deletionPolicy.assertNoOpenTranslogRefs();
            translogManager.add(new Translog.Index(index, indexResult));
    public void testAcquireHistoryRetentionLock() throws IOException {
                    @Override
                final String id = Integer.toString(i);
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
            assertTrue(syncListenerInvoked.get());
            createTranslogDeletionPolicy(INDEX_SETTINGS),
                shardId,
                () -> {},
            }
                primaryTerm,
package org.opensearch.index.translog;
                createTranslogDeletionPolicy(INDEX_SETTINGS),
            for (int i = 0; i < docs; i++) {
                Translog.Operation operation;
            final int docs = randomIntBetween(1, 100);
import java.util.concurrent.locks.ReentrantReadWriteLock;
            int opsRecoveredFromTranslog = translogManager.recoverFromTranslog((snapshot) -> {
            () -> Boolean.TRUE,
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;
                new InternalTranslogFactory(),
                createTranslogDeletionPolicy(INDEX_SETTINGS),
                        } catch (IOException ex) {
                globalCheckpoint::get,
                () -> {},
            );
    }
            translogManager.rollTranslogGeneration();
                () -> Boolean.TRUE,
        InternalTranslogManager translogManager = null;
                translogManager.add(new Translog.Index(index, indexResult));
                TranslogOperationHelper.DEFAULT
                () -> Boolean.TRUE,
                tracker.markSeqNoAsProcessed(i);
                shardId,
            AtomicInteger opsRecovered = new AtomicInteger();
        LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
        InternalTranslogManager translogManager = null;
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
                translogManager.add(new Translog.Index(index, indexResult));
        try {
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
        final TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(INDEX_SETTINGS);
            final int docs = randomIntBetween(1, 100);
import static org.hamcrest.Matchers.equalTo;
            assertThat(translogManager.getTranslog().currentFileGeneration(), equalTo(2L));
                primaryTerm,
        AtomicBoolean syncListenerInvoked = new AtomicBoolean();
            () -> tracker,
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
            }
            );
                () -> new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED),
     * {@link InternalTranslogManager#acquireHistoryRetentionLock()} must return a lock backed by
                final Engine.Index index = indexForDoc(doc);
                shardId,
            translogUUID,
                final ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocumentWithTextField(), SOURCE, null);
        try {
    }
                createTranslogDeletionPolicy(INDEX_SETTINGS),
        );
                TranslogOperationHelper.DEFAULT
     * {@link Translog}.
                new InternalTranslogFactory(),
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), 1, false);
     * the duration of peer recovery / primary relocation.
import java.util.concurrent.atomic.AtomicBoolean;
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().estimatedNumberOfOperations());
import java.util.concurrent.atomic.AtomicReference;
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
                Translog.Operation operation;
}
            translogManager.close();
import org.opensearch.index.mapper.ParsedDocument;
                () -> {},
                shardId,
import java.io.IOException;
                () -> Boolean.TRUE,
                while ((operation = snapshot.next()) != null) {
                Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), i, true);
            translogManager.syncTranslog();
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
import org.opensearch.index.seqno.LocalCheckpointTracker;
                return opsRecovered.get();
                createTranslogDeletionPolicy(INDEX_SETTINGS),
                () -> tracker,
                final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
                Engine.Index index = indexForDoc(doc);
        try {
import org.opensearch.index.translog.listener.TranslogEventListener;
                    }
                shardId,
        InternalTranslogManager translogManager = null;
                    public void onAfterTranslogRecovery() {
            }, NO_OPS_PERFORMED, Long.MAX_VALUE);
     * A local translog has no fence, so the manager answers the fence-ownership questions for the absent case:
     * resume. See {@link RemoteStoreFenceOwnership} for why these answers live here rather than as defaults on
                translogManager.add(new Translog.Index(index, indexResult));
 */
        // Hold a reference to the deletion policy so we can observe the retention locks it tracks.
        } finally {
            assertFalse("no fence means nothing can have superseded us", translogManager.isRemoteStoreFenceSuperseded());
                shardId,
                Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), i, true);
        } finally {
                translogUUID,
                while ((operation = snapshot.next()) != null) {
            assertEquals(0, deletionPolicy.pendingTranslogRefCount());
                translogUUID,
        try {
                () -> {},
            );
    public void testTrimOperationsFromTranslog() throws IOException {
                return opsRecovered.get();
            }
                createTranslogDeletionPolicy(INDEX_SETTINGS),
    public void testFenceOwnershipWithoutAFence() throws IOException {
                Translog.Operation operation;
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
            translogManager.trimOperationsFromTranslog(primaryTerm.get(), NO_OPS_PERFORMED); // trim everything in translog
                    }
 * this file be licensed under the Apache-2.0 license or a
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
                final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
            translogManager.syncTranslog();
            new ReleasableLock(new ReentrantReadWriteLock().readLock()),
                    @Override
                TranslogOperationHelper.DEFAULT
                final String id = Integer.toString(i);
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
                new InternalTranslogFactory(),
            translogManager.close();
                globalCheckpoint::get,
            assertThat(translogManager.getTranslog().getMinFileGeneration(), equalTo(2L));
        }
        final AtomicBoolean onTranslogRecoveryInvoked = new AtomicBoolean(false);
            assertTrue(beginTranslogRecoveryInvoked.get());
                tracker.markSeqNoAsProcessed(i);
                () -> {},
     * {@link org.opensearch.index.engine.DataFormatAwareEngine} relies on to keep history available for
                    opsRecovered.incrementAndGet();
                () -> Boolean.TRUE,
        LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
                final Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), i, true);
            long maxSeqNo = tracker.getMaxSeqNo();
            }, NO_OPS_PERFORMED, Long.MAX_VALUE);
                () -> tracker,
    }
                shardId,
                createTranslogDeletionPolicy(INDEX_SETTINGS),
            translogManager = new InternalTranslogManager(
                () -> Boolean.TRUE,
                            fail("Failed due to " + ex);
    }
                    public void onAfterTranslogSync() {
            translogManager = new InternalTranslogManager(
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
                () -> Boolean.TRUE,
                TranslogOperationHelper.DEFAULT
        InternalTranslogManager translogManager = null;
            }, NO_OPS_PERFORMED, Long.MAX_VALUE);
                () -> Boolean.TRUE,
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
            translogManager.transferFenceOwnership("target-allocation"); // no fence to hand over: a no-op, never a failure
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().getUncommittedOperations());
            () -> {},
                TranslogOperationHelper.DEFAULT
                return opsRecovered.get();
import org.opensearch.index.engine.Engine;
        }
                translogManager.add(new Translog.Index(index, indexResult));
                            translogManagerAtomicReference.get().trimUnreferencedReaders();
            primaryTerm,
                    opsRecovered.incrementAndGet();
 *
                () -> {},
    }
                new TranslogEventListener() {
                },
            assertEquals(1, deletionPolicy.pendingTranslogRefCount());
                translogManager.rollTranslogGeneration();
            long maxSeqNo = tracker.getMaxSeqNo();
                globalCheckpoint::get,
                globalCheckpoint::get,
            translogManager = new InternalTranslogManager(
        } finally {
            translogManager = new InternalTranslogManager(
            // The manager must expose the same deletion policy instance the lock pins against.
                primaryTerm,
                shardId,
            // Index a few operations spread over multiple generations.
                final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
                final String id = Integer.toString(i);
                deletionPolicy,
            assertTrue("no fence means an aborted handoff may resume", translogManager.revertFenceOwnership());
