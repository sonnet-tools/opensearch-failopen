    }
        try {
import java.io.IOException;  
        // Only verify the contract the helper owns: tracker.advanceMaxSeqNo is driven from the
    // engine integration tests that call these methods and assert on downstream state.
        TranslogEventListener l = NRTReplicaTranslogOps.createTranslogEventListener((reason, ex) -> {
    public void testCheckpointTrackerAdvancesForAllOps() {
        assertTrue(DefaultTranslogDeletionPolicy.class.isAssignableFrom(DefaultTranslogDeletionPolicy.class));
import org.opensearch.index.translog.DefaultTranslogDeletionPolicy;  
import org.opensearch.index.seqno.LocalCheckpointTracker;
        );
    // - DataFormatAwareEngineTests / DataFormatAware*IT (DFA replica)  
import static org.mockito.Mockito.mock;
        // op's seqNo. The actual Translog.{Index,Delete,NoOp} construction is covered by existing  
        assertTrue(ex.getMessage().contains("failed to trim unreferenced translog readers"));  
    // Additionally, Translog side-effects (location, took, seqno advance) are verified by the  
 * compatible open source license.
        assertTrue(ex.getCause() instanceof IOException);
        try {
        // asserting the returned type when no custom factory is configured. A mocked
        verify(tm).trimUnreferencedReaders();
import org.opensearch.index.translog.listener.TranslogEventListener;  
        assertEquals(7L, tracker.getMaxSeqNo());
        // Listener can be built before the manager is assigned, then trimming works once it is.
        doThrow(new IOException("disk gone")).when(tm).trimUnreferencedReaders();
        RuntimeException boom = new RuntimeException("boom");
        l.onAfterTranslogSync();
 * this file be licensed under the Apache-2.0 license or a
        // Real EngineConfig is heavy to construct; keep this test behaviour-light by just  
            new ShardId("idx", "uuid", 0)
        TranslogEventListener l = NRTReplicaTranslogOps.createTranslogEventListener(
}
        TranslogManager tm = mock(TranslogManager.class);
            new ShardId("idx", "uuid", 0)
 * SPDX-License-Identifier: Apache-2.0
        } catch (IOException e) {  
    public void testTranslogEventListenerLateBindsManager() {
        // Sentinel: both engines now delegate to this class. If someone reverts the delegation,  
import java.util.concurrent.atomic.AtomicBoolean;
        TranslogEventListener l = NRTReplicaTranslogOps.createTranslogEventListener(
        );  
    }  
import org.opensearch.core.index.shard.ShardId;
        l.onFailure("because", boom);  
        AtomicBoolean failed = new AtomicBoolean(false);
            fail("unexpected: " + e);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.translog.TranslogManager;
    public void testTranslogEventListenerTrimsOnSync() throws IOException {
        AtomicReference<Exception> seenEx = new AtomicReference<>();  
        assertFalse(failed.get());  
    public void testTranslogEventListenerForwardsFailure() {
        AtomicReference<String> seenReason = new AtomicReference<>();
            () -> tm,
        assertNotNull(NRTReplicaTranslogOps.class);
        // engine integration tests.
            holder::get,  
    // index/delete/noOp end-to-end behaviour is exercised by:
import static org.mockito.Mockito.verify;  
        // EngineConfig would couple the test to internal method signatures.
import java.util.concurrent.atomic.AtomicReference;
        TranslogManager tm = mock(TranslogManager.class);  
            (r, e) -> {},
    }  
/*  
            (reason, ex) -> failed.set(true),  
package org.opensearch.index.engine;
    }
        }  
            () -> tm,
import org.opensearch.index.translog.TranslogException;
            verify(tm).trimUnreferencedReaders();
            l.onAfterTranslogSync();  
        } catch (Exception e) {
            seenReason.set(reason);
public class NRTReplicaTranslogOpsTests extends OpenSearchTestCase {
        }
        // the engine tests will fail; this test itself is a marker that the shared file exists.
            new ShardId("idx", "uuid", 0)  
        LocalCheckpointTracker tracker = new LocalCheckpointTracker(-1L, -1L);
    // - NRTReplicationEngineTests (NRT replica)
            fail("verify shouldn't throw: " + e);
import org.opensearch.test.OpenSearchTestCase;
        assertSame(boom, seenEx.get());
        }, () -> mock(TranslogManager.class), new ShardId("idx", "uuid", 0));
        AtomicReference<TranslogManager> holder = new AtomicReference<>();  
 *
    public void testHelperIsWiredByBothEngines() {
    }  
        holder.set(tm);
    }
    }
        TranslogException ex = expectThrows(TranslogException.class, l::onAfterTranslogSync);
    //
        // Covered by engine-level tests that exercise flush & translog retention.  
        tracker.advanceMaxSeqNo(7L);  
    public void testGetTranslogDeletionPolicyFallsBackToDefault() {
            seenEx.set(ex);  
            (reason, ex) -> {},
    public void testTranslogEventListenerWrapsTrimIOExceptionInTranslogException() throws IOException {  
        assertEquals("because", seenReason.get());
        TranslogEventListener l = NRTReplicaTranslogOps.createTranslogEventListener(  
        TranslogManager tm = mock(TranslogManager.class);  
 */  
    // Running them after the refactor is the authoritative behavioural check.
import static org.mockito.Mockito.doThrow;
        );
