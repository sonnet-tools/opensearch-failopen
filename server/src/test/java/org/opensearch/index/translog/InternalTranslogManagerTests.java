                        }
     */
            TranslogOperationHelper.DEFAULT  
                    opsRecovered.incrementAndGet();
                            syncListenerInvoked.set(true);
            translogManager.transferFenceOwnership("target-allocation"); // no fence to hand over: a no-op, never a failure
            assertNotNull(retentionLock);  
            assertEquals(maxSeqNo + 1, opsRecoveredFromTranslog);  
            primaryTerm,
                primaryTerm,
            assertEquals(maxSeqNo + 1, opsRecoveredFromTranslog);
import org.opensearch.index.seqno.LocalCheckpointTracker;
            assertSame(deletionPolicy, translogManager.getTranslog().getDeletionPolicy());
                translogUUID,  
                translogUUID,
            }
            new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),  
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
            translogManager.syncTranslog();  
                deletionPolicy,
import org.opensearch.common.util.BigArrays;
                () -> Boolean.TRUE,
        // Hold a reference to the deletion policy so we can observe the retention locks it tracks.
import java.util.concurrent.atomic.AtomicReference;
                translogManager.add(new Translog.Index(index, indexResult));  
                    }  
            primaryTerm.set(randomLongBetween(primaryTerm.get(), Long.MAX_VALUE));  
                () -> {},
                    public void onBeginTranslogRecovery() {  
                tracker.markSeqNoAsProcessed(i);
            translogManager.close();
                new InternalTranslogFactory(),  
                () -> new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED),  
import org.opensearch.index.mapper.ParsedDocument;
                Translog.Operation operation;
        final AtomicBoolean onTranslogRecoveryInvoked = new AtomicBoolean(false);
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
        } finally {
                }
        LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
                    opsRecovered.incrementAndGet();  
                () -> Boolean.TRUE,  
                },
            () -> tracker,  
        }  
        } finally {
                Engine.Index index = indexForDoc(doc);
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),  
            long maxSeqNo = tracker.getMaxSeqNo();
    }  
            retentionLock.close();  
                createTranslogDeletionPolicy(INDEX_SETTINGS),  
            Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), 1, false);  
                () -> tracker,
import org.opensearch.common.util.concurrent.ReleasableLock;
            globalCheckpoint::get,
            deletionPolicy.assertNoOpenTranslogRefs();
                    public void onAfterTranslogRecovery() {
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),  
     * it is held, and releases that generation when closed. This is the translog-layer support that
            int opsRecoveredFromTranslog = translogManager.recoverFromTranslog((snapshot) -> {  
                globalCheckpoint::get,
    }  
                createTranslogDeletionPolicy(INDEX_SETTINGS),
                translogUUID,
                () -> {},
 * compatible open source license.
                while ((operation = snapshot.next()) != null) {
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),  
                globalCheckpoint::get,
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
            assertEquals(maxSeqNo + 1, opsRecovered.get());  
        try {  
            AtomicInteger opsRecovered = new AtomicInteger();
        AtomicBoolean syncListenerInvoked = new AtomicBoolean();
                shardId,
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
            assertThat(translogManager.getTranslog().currentFileGeneration(), equalTo(2L));
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().estimatedNumberOfOperations());
            expectThrows(AssertionError.class, deletionPolicy::assertNoOpenTranslogRefs);  
import org.opensearch.index.seqno.SequenceNumbers;  
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
        LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);  
            final int docs = randomIntBetween(1, 100);
            translogManager.close();  
                final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),  
                primaryTerm,
            long maxSeqNo = tracker.getMaxSeqNo();
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().estimatedNumberOfOperations());
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
                new InternalTranslogFactory(),
                () -> Boolean.TRUE,
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
        InternalTranslogManager translogManager = null;  
                }
/*  
            );  
                translogManager.rollTranslogGeneration();  
            final int docs = randomIntBetween(1, 100);
        final TranslogDeletionPolicy deletionPolicy = createTranslogDeletionPolicy(INDEX_SETTINGS);  
                Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), i, true);
            assertEquals(0, deletionPolicy.pendingTranslogRefCount());
            // Releasing the lock releases the pinned generation.
                Engine.Index index = indexForDoc(doc);  
            assertTrue(beginTranslogRecoveryInvoked.get());  
                    @Override
                globalCheckpoint::get,
            AtomicReference<InternalTranslogManager> translogManagerAtomicReference = new AtomicReference<>();
                        beginTranslogRecoveryInvoked.set(true);
            // While the lock is held there is an open translog reference.
                () -> {},  
            }, NO_OPS_PERFORMED, Long.MAX_VALUE);  
            translogManager = new InternalTranslogManager(
import static org.opensearch.index.seqno.SequenceNumbers.NO_OPS_PERFORMED;
                tracker.markSeqNoAsProcessed(i);
                shardId,  
                }
                Engine.Index index = indexForDoc(doc);
                shardId,
                return opsRecovered.get();  
                        try {  
                translogManager.add(new Translog.Index(index, indexResult));
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
 * The OpenSearch Contributors require contributions made to  
                () -> {},
                primaryTerm,
    }
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
                TranslogOperationHelper.DEFAULT
                () -> {},  
                shardId,
                return opsRecovered.get();
                globalCheckpoint::get,  
                            fail("Failed due to " + ex);
            TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
                shardId,
                final Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), i, true);  
            translogManager.close();
            translogManagerAtomicReference.set(translogManager);
                new InternalTranslogFactory(),
                () -> tracker,  
                    }
        } finally {  
            new ReleasableLock(new ReentrantReadWriteLock().readLock()),
            // No retention locks are held before acquiring one.  
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
            );
    }
            translogManager.rollTranslogGeneration();
            for (int i = 0; i < docs; i++) {
                TranslogOperationHelper.DEFAULT
        }  
                globalCheckpoint::get,  
                    }  
            // Index a few operations spread over multiple generations.
        }
}
                },  
        try {
     * {@link Translog}.  
                shardId,
                () -> Boolean.TRUE,  
                TranslogOperationHelper.DEFAULT
            assertTrue(syncListenerInvoked.get());
    public void testTrimOperationsFromTranslog() throws IOException {  
    public void testFenceOwnershipWithoutAFence() throws IOException {
            final int docs = randomIntBetween(1, 10);
            new InternalTranslogFactory(),
                translogUUID,
                            translogManagerAtomicReference.get().trimUnreferencedReaders();
                globalCheckpoint::get,
            translogUUID,
            assertEquals(0, deletionPolicy.pendingTranslogRefCount());
        } finally {  
                    @Override
    /**
        }
            translogManager.close();
                new InternalTranslogFactory(),  
                translogManager.add(new Translog.Index(index, indexResult));
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),  
            final Closeable retentionLock = translogManager.acquireHistoryRetentionLock();
                Translog.Operation operation;
                TranslogOperationHelper.DEFAULT  
                        } catch (IOException ex) {  
            }
            translogManager.close();
import static org.opensearch.index.translog.TranslogDeletionPolicies.createTranslogDeletionPolicy;  
                shardId,  
                new TranslogEventListener() {  
                () -> tracker,
                Translog.Operation operation;
            // The manager must expose the same deletion policy instance the lock pins against.  
                createTranslogDeletionPolicy(INDEX_SETTINGS),
                primaryTerm,  
            assertTrue("no fence means an aborted handoff may resume", translogManager.revertFenceOwnership());
            int opsRecoveredFromTranslog = translogManager.recoverFromTranslog((snapshot) -> {
            final int docs = randomIntBetween(1, 100);
                TranslogOperationHelper.DEFAULT
import java.io.Closeable;  
        InternalTranslogManager translogManager = null;  
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
            assertFalse("no fence means nothing can have superseded us", translogManager.isRemoteStoreFenceSuperseded());  
    }  
     * {@link Translog#acquireRetentionLock()} that pins a translog generation in the deletion policy while  
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
            AtomicInteger opsRecovered = new AtomicInteger();  
                translogUUID,
            assertEquals(0, opsRecovered.get());
            assertThat(translogManager.getTranslog().getMinFileGeneration(), equalTo(2L));  
            translogManager.close();
                while ((operation = snapshot.next()) != null) {  
import java.io.IOException;
                new TranslogConfig(shardId, primaryTranslogDir, INDEX_SETTINGS, BigArrays.NON_RECYCLING_INSTANCE, "", false),
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().getUncommittedOperations());  
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
                final String id = Integer.toString(i);
                return opsRecovered.get();
            assertEquals(1, deletionPolicy.pendingTranslogRefCount());
            ParsedDocument doc = testParsedDocument("1", null, testDocumentWithTextField(), B_1, null);
 * this file be licensed under the Apache-2.0 license or a
                translogUUID,
        final LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
                TranslogOperationHelper.DEFAULT  
            translogManager.close();
    /**
            // Acquiring the history retention lock pins a translog generation.
import java.util.concurrent.atomic.AtomicLong;
                final String id = Integer.toString(i);  
        InternalTranslogManager translogManager = null;
                Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), i, true);  
                () -> new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED),  
                primaryTerm,  
     * {@link org.opensearch.index.engine.DataFormatAwareEngine} relies on to keep history available for
        InternalTranslogManager translogManager = new InternalTranslogManager(
                translogManager.rollTranslogGeneration();  
    public void testTranslogSync() throws IOException {  
            int opsRecoveredFromTranslog = translogManager.recoverFromTranslog((snapshot) -> {  
                shardId,
            translogManager = new InternalTranslogManager(  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
        InternalTranslogManager translogManager = null;
            }, NO_OPS_PERFORMED, Long.MAX_VALUE);
        LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
            );
            createTranslogDeletionPolicy(INDEX_SETTINGS),  
    }
                final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
        LocalCheckpointTracker tracker = new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED);
                tracker.markSeqNoAsProcessed(i);
                new InternalTranslogFactory(),  
                final Engine.Index index = indexForDoc(doc);
                () -> {},
import java.util.concurrent.atomic.AtomicBoolean;
        try {
                new InternalTranslogFactory(),
            assertEquals(maxSeqNo + 1, opsRecovered.get());
            );
            );  
                new InternalTranslogFactory(),
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().estimatedNumberOfOperations());
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
            shardId,
                Engine.IndexResult indexResult = new Engine.IndexResult(index.version(), index.primaryTerm(), i, true);  
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
    public void testRecoveryFromTranslog() throws IOException {
                while ((operation = snapshot.next()) != null) {
                globalCheckpoint::get,
            Engine.Index index = indexForDoc(doc);
            AtomicInteger opsRecovered = new AtomicInteger();
        final AtomicInteger localCheckpoint = new AtomicInteger(randomIntBetween(0, maxSeqNo.get()));
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),  
            deletionPolicy.assertNoOpenTranslogRefs();
                    public void onAfterTranslogSync() {
                () -> Boolean.TRUE,
        final AtomicInteger maxSeqNo = new AtomicInteger(randomIntBetween(0, 128));
                primaryTerm,
            assertTrue(onTranslogRecoveryInvoked.get());
        try {  
            }
        } finally {  
                tracker.markSeqNoAsProcessed(i);
            translogManager.syncTranslog();  
                    opsRecovered.incrementAndGet();  
     * {@link InternalTranslogManager#acquireHistoryRetentionLock()} must return a lock backed by
    public void testTranslogRollsGeneration() throws IOException {
 */  
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().getUncommittedOperations());  
package org.opensearch.index.translog;
            translogManager = new InternalTranslogManager(
            );
            }, NO_OPS_PERFORMED, Long.MAX_VALUE);  
        final AtomicLong globalCheckpoint = new AtomicLong(SequenceNumbers.NO_OPS_PERFORMED);  
            () -> {},  
                TranslogOperationHelper.DEFAULT  
            );
            long maxSeqNo = tracker.getMaxSeqNo();
                primaryTerm,
            translogManager = new InternalTranslogManager(
            translogManager = new InternalTranslogManager(
     * nothing can have superseded this copy, a handoff transfer is a no-op, and an aborted handoff leaves it free to
                new TranslogEventListener() {
            () -> Boolean.TRUE,
            translogManager.syncTranslog();  
                createTranslogDeletionPolicy(INDEX_SETTINGS),
     * the duration of peer recovery / primary relocation.  
            translogManager.close();
                    @Override  
        } finally {
            assertEquals(maxSeqNo + 1, translogManager.getTranslogStats().getUncommittedOperations());  
                () -> {},  
                final ParsedDocument doc = testParsedDocument(id, null, testDocumentWithTextField(), SOURCE, null);
            );  
 * SPDX-License-Identifier: Apache-2.0
                createTranslogDeletionPolicy(INDEX_SETTINGS),  
import org.opensearch.index.translog.listener.TranslogEventListener;
                () -> new LocalCheckpointTracker(maxSeqNo.get(), localCheckpoint.get()),
                createTranslogDeletionPolicy(INDEX_SETTINGS),  
            for (int i = 0; i < docs; i++) {
public class InternalTranslogManagerTests extends TranslogManagerTestCase {  
                new InternalTranslogFactory(),
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,
     * A local translog has no fence, so the manager answers the fence-ownership questions for the absent case:  
                createTranslogDeletionPolicy(INDEX_SETTINGS),  
import static org.hamcrest.Matchers.equalTo;
            for (int i = 0; i < docs; i++) {  
                TranslogOperationHelper.DEFAULT
                        onTranslogRecoveryInvoked.set(true);
     * resume. See {@link RemoteStoreFenceOwnership} for why these answers live here rather than as defaults on
                final ParsedDocument doc = testParsedDocument(Integer.toString(i), null, testDocumentWithTextField(), SOURCE, null);
        }
import java.util.concurrent.locks.ReentrantReadWriteLock;  
        try {  
 *
                translogManager.rollTranslogGeneration();  
                translogUUID,  
            translogManager.close();
        try {
                translogManager.add(new Translog.Index(index, indexResult));
    public void testAcquireHistoryRetentionLock() throws IOException {
                () -> Boolean.TRUE,
            translogManager = new InternalTranslogManager(  
                () -> Boolean.TRUE,
            translogManager.add(new Translog.Index(index, indexResult));
                () -> {},
                translogUUID,
                final String id = Integer.toString(i);  
        );
                new ReleasableLock(new ReentrantReadWriteLock().readLock()),
                TranslogEventListener.NOOP_TRANSLOG_EVENT_LISTENER,  
            translogManager.trimOperationsFromTranslog(primaryTerm.get(), NO_OPS_PERFORMED); // trim everything in translog
                primaryTerm,
            }
import java.util.concurrent.atomic.AtomicInteger;  
                () -> new LocalCheckpointTracker(NO_OPS_PERFORMED, NO_OPS_PERFORMED),  
        }
                () -> tracker,
                globalCheckpoint::get,
            translogManager = new InternalTranslogManager(
        InternalTranslogManager translogManager = null;
            for (int i = 0; i < docs; i++) {  
import org.opensearch.index.engine.Engine;  
            assertEquals(0, opsRecoveredFromTranslog);  
                () -> Boolean.TRUE,
     */
            translogManager = new InternalTranslogManager(
        final AtomicBoolean beginTranslogRecoveryInvoked = new AtomicBoolean(false);
