        assertEquals(1, newPrimary.getSeq());
            private boolean planted;
        CyclicBarrier barrier = new CyclicBarrier(contenders);
        target.validateAndAdvance(1);
        assertEquals(2, fence.getSeq());
    public void testLostResponseOnTheRevertDoesNotStandTheSourceDown() throws IOException {
    /**
            }
        for (int attempt = 0; attempt < randomIntBetween(2, 4); attempt++) {
        // Even if the stale primary claims a higher local term, its CAS token is stale
import static org.mockito.Mockito.mock;
        // The window: an equal-term twin arbitrates the chain over and acknowledges a write through it.
                throws IOException {
        assertFalse("term 2's path must be deleted by its successor", blobContainer.blobExists(RemoteStoreFence.fenceBlobName(2)));
     * Deletion is what fences a lower-term incumbent, and a batch delete can report per-key failures in its response
        expectThrows(TranslogFencedException.class, () -> incumbent.validateAndAdvance(1));
        final FsBlobContainer losingResponses = new FsBlobContainer(blobStore, BlobPath.cleanPath(), repoPath) {
        target.validateAndAdvance(1);
        // Relocation target takes over ownership at the same term
        source.validateAndAdvance(1);
        // new incarnation (a fresh instance, i.e. a cluster-sanctioned transition) may claim the chain again.
     */
        assertEquals(1, finalState.term);
        RemoteStoreFence source = newFence("node-source");
        // The BlobContainer defaults must be inert: no silent non-atomic fallback for repositories that cannot CAS
     */
            () -> RemoteStoreFence.FenceState.parse("v1|uuid|x|1|alloc-1|node-1|0".getBytes(StandardCharsets.UTF_8))
        RemoteStoreFence fence = new RemoteStoreFence(unsupported, allocationIdOf("node-1"), "node-1", shardId);
        RemoteStoreFence translogInstance = newTranslogInstance("node-1");
        RemoteStoreFence.FenceState state = new RemoteStoreFence.FenceState("uuid", 3, 7, "alloc-a", "node-a", 42);
        claimant.validateAndAdvance(2);
        assertTrue(e.getMessage(), e.getMessage().contains("not the recorded owner"));
import java.nio.file.Path;
        );
    public void setUpContainer() throws IOException {
        source.validateAndAdvance(1);
     * more publish at our own term leaves an orphan, which is the pre-existing harmless case; failing closed would
    public void testAbortedHandoffReclaimsOwnershipAndTheSourceResumes() throws IOException {
        for (Thread thread : threads) {
            IOException.class,
        assertTrue(newFence("node-2").isSuperseded(2));
        stalled.validateAndAdvance(2);          // claims term 2, then stalls without acknowledging
        assertTrue("the legitimate owner's path must be untouched", blobContainer.blobExists(RemoteStoreFence.fenceBlobName(1)));
        // And a target that activates afterwards finds the source recorded as owner, so it stands down rather than
            blobContainer.readBlobWithVersion(RemoteStoreFence.fenceBlobName(9)).content()
        expectThrows(TranslogFencedException.class, () -> source.validateAndAdvance(1));
    }
import org.opensearch.common.blobstore.fs.FsBlobContainer;
        source.validateAndAdvance(1);
            });
     * which would fence a healthy primary. Index UUIDs, allocation ids and node ids are base64 UUIDs so this cannot
        expectThrows(TranslogFencedException.class, () -> fencedInstance.validateAndAdvance(2));
        assertEquals(0, fence.getSeq());
                if (swallowNextResponse.compareAndSet(true, false)) {
        assertEquals("the landed write should have been adopted", seqBeforeLoss + 1, fence.getSeq());
            @Override
    }
    }
     */
        final long higherTerm = term + 1;
    private static String allocationIdOf(String ownerNodeId) {
     * The write lands, the response does not, so this copy still holds the previous token. Retrying would fail its
    /**
                }
                throws IOException {
        );
public class RemoteStoreFenceTests extends OpenSearchTestCase {
        swallowNextResponse.set(true);
    /** The normal flow: the seal recorded this copy as owner, so its translog instance re-adopts the chain. */
        expectThrows(IllegalArgumentException.class, () -> new RemoteStoreFence.FenceState("uu|id", 0, 1, "alloc-1", "node-1", 0));
        expectThrows(TranslogFencedException.class, () -> incumbent.validateAndAdvance(1));
        RemoteStoreFence fence = newFence("node-1");
                }
        // An instance that never claimed anything still reports the truth about the store.
        expectThrows(
        assertTrue(blobContainer.blobExists(RemoteStoreFence.fenceBlobName(1)));
        // chain back, because a fenced instance never re-enters bootstrap - every retry fails, at any term. Only a
     * errors and returns success. A claim must therefore verify its sweep rather than trust it: a surviving lower-term
        );
        assertTrue(blobContainer.blobExists(RemoteStoreFence.fenceBlobName(2)));
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
        final RemoteStoreFence source = new RemoteStoreFence(losingResponses, allocationIdOf("node-source"), "node-source", shardId);
        expectThrows(TranslogFencedException.class, () -> oldPrimary.validateAndAdvance(1));
        source.transferOwnershipTo(1, allocationIdOf("node-target"));
        expectThrows(TranslogFencedException.class, () -> superseded.validateAndAdvance(term));
     */
        assertEquals(seqBeforeLoss + 2, fence.getSeq());
     */
    }
    public void testStaleGrantCannotDisplaceItsSuccessor() throws IOException {
        Thread[] threads = new Thread[contenders];
        assertEquals("node-a", parsed.nodeId);
    public void testTranslogInstanceMustNotReAdoptAChainAnEqualTermTwinClaimed() throws IOException {
            expectThrows(TranslogFencedException.class, () -> source.validateAndAdvance(1));
                if (planted == false && expectedToken != null) {
            public void deleteBlobsIgnoringIfNotExists(List<String> blobNames) {
        blobStore = new FsBlobStore(randomIntBetween(1, 8) * 1024, repoPath, false);
        RemoteStoreFence fence = newFence("node-1");
        } catch (IOException e) {
        expectThrows(TranslogFencedException.class, () -> source.validateAndAdvance(1));
        RemoteStoreFence stalled = newFence("node-2");
     * A copy that won its path from an equal-term twin, and is then superseded mid-claim, must not delete that path.
        assertFalse(blobContainer.blobExists(RemoteStoreFence.fenceBlobName(1)));
        RemoteStoreFence source = newFence("node-source");
        newPrimary.validateAndAdvance(2);
        byte[] foreign = new RemoteStoreFence.FenceState("other-uuid", 3, 1, "alloc-x", "node-x", 0).toBytes();
        return new RemoteStoreFence(blobContainer, allocationIdOf(ownerNodeId), ownerNodeId, shardId, true);
                throws IOException {
        newPrimary.validateAndAdvance(2);
                final String token = super.writeBlobConditionally(blobName, in, size, expectedToken);
    private RemoteStoreFence newRelocationTarget(String ownerNodeId) {
    /**
        source.validateAndAdvance(1);
        fence.validateAndAdvance(1);
        // The source's token is now stale, which is correct: the handoff completed.
    }
        twin.validateAndAdvance(1);
    }
        );
        twin.validateAndAdvance(1);
        newFence("node-target").validateAndAdvance(1);
        assertFalse("an unswept predecessor is retryable, not a fencing verdict", e instanceof TranslogFencedException);
        assertEquals(7, parsed.term);
        source.validateAndAdvance(1);
    }
     * term-3 owner that overtook it: its own path has been deleted, so it fails rather than regressing the fence.
        assertFalse(
        final long seqBeforeLoss = fence.getSeq();
            IOException.class,
        }
     * claimed the chain during that window, the re-adoption must be REFUSED: taking the chain back would serve from a
        RemoteStoreFence claimant = new RemoteStoreFence(droppingDeletes, allocationIdOf("node-new"), "node-new", shardId);
        expectThrows(IOException.class, () -> RemoteStoreFence.FenceState.parse("garbage".getBytes(StandardCharsets.UTF_8)));
                    final byte[] bytes = new byte[] { 1 };
 * compatible open source license.
        swallowNextResponse.set(true);
                final String token = super.writeBlobConditionally(blobName, in, size, expectedToken);
    /**
                return token;
        assertTrue(e.getMessage(), e.getMessage().contains("different shard"));
        expectThrows(TranslogFencedException.class, () -> source.validateAndAdvance(1));
    }
        translogInstance.validateAndAdvance(1); // second claim: re-adopts the chain
     * Fenced is terminal, including at a term this instance was never granted. Without explicit terminal state a
                    throw new IOException("connection reset before the response was read");
import org.junit.After;
        assertFalse("a shard identity mismatch must not be classified as fenced", e instanceof TranslogFencedException);
     * <p>
                    throw new AssertionError(e);
     * between them: the source's recorded handover is what authorizes the target.
        RemoteStoreFence target = newRelocationTarget("node-target");
        RemoteStoreFence successor = newFence("node-3");
            threads[i].start();
        newFence("twin").validateAndAdvance(term);
        expectThrows(IllegalArgumentException.class, () -> new RemoteStoreFence.FenceState("uuid", 0, 1, "alloc-1", "node|1", 0));
    }
        assertEquals(allocationIdOf("node-1"), state.allocationId);
        RemoteStoreFence oldPrimary = newFence("node-old");
     * restore point read before the twin's acknowledgements, and those acknowledged writes would be lost.
     */
     * The relocation handoff. Source and target share a term, so they share an object and the term cannot arbitrate
     * That must surface as a loud repository error - never as a fencing verdict on a chain that is not ours.
        };
        adopted.validateAndAdvance(1);
    public void testTransferRequiresOwnership() throws IOException {
        oldPrimary.validateAndAdvance(1);
                    writeBlob(RemoteStoreFence.fenceBlobName(higherTerm), new java.io.ByteArrayInputStream(bytes), bytes.length, true);
        RemoteStoreFence source = newFence("node-source");
                    barrier.await(30, TimeUnit.SECONDS);
        shardId = new ShardId("index", "uuid", 0);
                }
    /** A copy that does not own the chain cannot hand it off. */
            }
        newFence("node-1").validateAndAdvance(1); // first claim: the seal records this copy's allocation id
        TranslogFencedException e = expectThrows(TranslogFencedException.class, () -> oldPrimary.validateAndAdvance(1));
            public String writeBlobConditionally(String blobName, java.io.InputStream in, long size, String expectedToken)
        blobContainer.writeBlobConditionally(RemoteStoreFence.fenceBlobName(5), new ByteArrayInputStream(foreign), foreign.length, null);
        RemoteStoreFence adopted = newRelocationTarget("node-target");
    public void testHigherTermClaimWinsAgainstAnActiveIncumbent() throws IOException {
        final RemoteStoreFence fence = new RemoteStoreFence(losingResponses, allocationIdOf("node-1"), "node-1", shardId);
    }
import java.io.ByteArrayInputStream;
    }
    /**
    private static RemoteStoreFence.FenceState expectSuccess(RemoteStoreFence.FenceState state) {
/*
     * An aborted handoff must not fence a healthy source: the cluster keeps it as primary and releases its upload
     * earlier version of this check asked "do I still hold my own object?", which answers no both for a superseded copy
        // Truncated
        // And so does an instance that has itself been fenced.
    /**
        successor.validateAndAdvance(3);
     * silence a healthy shard whenever the repository hiccups. The garbage collection paths make the opposite choice.
    public void testMissingPathIsNotTreatedAsSupersession() throws IOException {
    }
                    planted = true;
        RemoteStoreFence translogInstance = newTranslogInstance("node-1");
        // Zombie source must be fenced even though the term did not change
        RemoteStoreFence fence = newFence("node-1");
        // and the source resumes - instead of losing a CAS against its own transfer and standing down for no reason.
                return token;
        // source that is still serving.
    public void testFencedOwnerStaysFencedAfterHigherTermTakeover() throws IOException {
        source.validateAndAdvance(1);
        // supersession. Content does not matter: the listing compares names only.
        RemoteStoreFence fence = newFence("node-1");
    public void testLocalTermLowerThanFenceTermIsFenced() throws IOException {
        successor.validateAndAdvance(3);
        // and the encoding of well-formed fields still round-trips
    }
        expectThrows(TranslogFencedException.class, () -> lateTarget.validateAndAdvance(1));
        );
                if (swallowNextResponse.compareAndSet(true, false)) {
        RemoteStoreFence target = newFence("node-target");
            @Override
        // steal the chain back.
        fence.validateAndAdvance(1);
        // Wrong codec version
import org.junit.Before;
    /**
        twin.validateAndAdvance(1);
    }
        RemoteStoreFence stranger = newFence("node-other");
        // And the chain must still be usable afterwards - a stale token here would surface as a spurious fencing.
    public void testFenceStateCodecRoundTrip() throws IOException {
        assertEquals(allocationIdOf(finalState.nodeId), finalState.allocationId);
     * carrying ours at the seq we attempted can only be the write we just issued.
     */
     * network blip. The ambiguity is resolved by identity: the object records the writing copy and its seq, so a blob
    public void testFenceBlobForAnotherShardFailsLoudly() throws IOException {
     * does. What makes this matter is the abort path: with a stale token, an aborted handoff's revert would lose its
            () -> RemoteStoreFence.FenceState.parse("v1|uuid|0|x|alloc-1|node-1|0".getBytes(StandardCharsets.UTF_8))
        assertEquals(shardId.getIndex().getUUID(), state.indexUUID);
                return token;
     * destructive act is deleting strictly BELOW its own term", which the rest of the protocol leans on. The object is
    }
        final FsBlobContainer losingResponses = new FsBlobContainer(blobStore, BlobPath.cleanPath(), repoPath) {
        // Non-numeric shard id
     * healthy shard permanently and hung snapshot-restore recovery until the test suite timed out.
    /** If the target did take the chain up, the handoff effectively completed: the revert must fail and the source stand down. */
        // fencing it.
 * The OpenSearch Contributors require contributions made to
        swallowNextResponse.set(true);
        FsBlobContainer droppingDeletes = new FsBlobContainer(blobStore, BlobPath.cleanPath(), repoPath) {
        new RemoteStoreFence(droppingDeletes, allocationIdOf("node-old"), "node-old", shardId).validateAndAdvance(1);
        assertFalse(unsupported.isConditionalWriteSupported());
        source.validateAndAdvance(1);
                } catch (Exception e) {
    }
    }
        assertTrue(finalState.nodeId.startsWith("node-"));
        RemoteStoreFence claimant = newFence("node-new");
     * translog, and so the fence, several times in quick succession. That conflation silenced segment uploads on a
        assertFalse("an absent path is not evidence of a higher term", fence.isSuperseded(3));
                } catch (TranslogFencedException e) {
    public void testFenceBlobIsSelfDescribing() throws IOException {
    public void testFenceStateRejectsFieldsContainingTheSeparator() {
                return token;
            "a path won from an equal-term twin must survive our withdrawal - it may already belong to another peer",
        };
        newFence("node-1").validateAndAdvance(1);
        }
     * fenced copy could claim a higher term's path, delete its own successor's, and resurrect itself.
import org.opensearch.core.index.shard.ShardId;
import org.opensearch.common.blobstore.fs.FsBlobStore;
    }
        assertEquals(1, translogInstance.getTerm());
                // Silently drop the delete, as a partially-failed batch delete does.
                    bootstrapped.incrementAndGet();
        assertTrue("a revert that landed must be reported as reclaimed", source.revertOwnership(1));
            "a fenced instance must not create a path for a term it was never granted",
     * Supersession is a property of the STORE, not of the asking instance. This is the regression that matters: an
        assertTrue("the revert must succeed against the adopted token", source.revertOwnership(1));
        // Plant a higher term the moment our arbitration CAS lands, so the re-list inside claim() sees a mid-claim
        assertFalse(newFence("node-2").isSuperseded(3));
        // is untouched.
     * If-Match for exactly the same reason a genuinely fenced writer's would, and the copy would fail its shard on a
        RemoteStoreFence fence = newFence("node-1");
            @Override
            public String writeBlobConditionally(String blobName, java.io.InputStream in, long size, String expectedToken)
     * equal-term claimant has taken it over since, in which case deleting would fence a peer that legitimately owns it.
        RemoteStoreFence.FenceState parsed = RemoteStoreFence.FenceState.parse(state.toBytes());
        fence.validateAndAdvance(9);
                    throw new IOException("connection reset before the response was read");
        assertEquals(2, claimant.getTerm());
        assertEquals(3, roundTripped.seq);
    }
    }
        assertFalse("the target had taken over, so ownership must not be reclaimable", source.revertOwnership(1));
        RemoteStoreFence source = newFence("node-source");
        target.validateAndAdvance(1);
    /**
        };
        assertEquals(shardId.id(), state.shardId);
                    fence.validateAndAdvance(1);
        assertTrue(e.getMessage(), e.getMessage().contains("superseded term [1]"));
        RemoteStoreFence.FenceState state = RemoteStoreFence.FenceState.parse(
    }
        assertEquals(42, parsed.seq);
     * {@code FenceTakeover.tla} draws exactly this distinction - {@code VerifyClaim} withdraws only {@code IF wCreated}.
        // The target never took the chain up, so ownership is reclaimable and the source keeps serving.
        };
        fence.validateAndAdvance(term);
            }
    private FsBlobStore blobStore;
        RemoteStoreFence newPrimary = newFence("node-new");
        RemoteStoreFence twin = newFence("node-twin");
            @Override
        IOException e = expectThrows(IOException.class, () -> claimant.validateAndAdvance(2));
    }
     * drains, so it has to be able to resume. The revert succeeds exactly when the target never wrote.
        int contenders = randomIntBetween(2, 6);
        RemoteStoreFence incumbent = newFence("node-incumbent");
        assertFalse("a fenced instance must not report supersession at a term nothing has superseded", fencedInstance.isSuperseded(3));
import java.util.concurrent.atomic.AtomicInteger;
        expectThrows(IllegalArgumentException.class, () -> new RemoteStoreFence.FenceState("uuid", 0, 1, "alloc|1", "node-1", 0));
    private ShardId shardId;
        oldPrimary.validateAndAdvance(1);
    public void testSupersessionReflectsTheStoreNotTheInstance() throws IOException {
    public void testLostResponseOnTheTransferDoesNotStrandTheSource() throws IOException {
    }
        RemoteStoreFence lateTarget = newRelocationTarget("node-target");
    public void testClaimRefusesWhenTheSweepSilentlyLeavesALowerTermPath() throws IOException {
        repoPath = createTempDir();
import java.util.concurrent.CyclicBarrier;
        try {
    public void testBootstrapCreatesFence() throws IOException {
     * Withdrawing is the one place a writer would delete at its OWN term - the single exception to "a writer's only
import java.util.concurrent.TimeUnit;
        expectThrows(
        fence.validateAndAdvance(1);
        assertTrue(e.getMessage(), e.getMessage().contains("term [3] superseded by term [5]"));
            public String writeBlobConditionally(String blobName, java.io.InputStream in, long size, String expectedToken)
     * A missing acknowledgement path reports "not superseded", so the segment publish path fails OPEN. Permitting one
        incumbent.validateAndAdvance(1);
        terminate(threadPool);
        final long term = 5;
        fence.validateAndAdvance(1);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(3, parsed.shardId);
    private FsBlobContainer blobContainer;
            blobContainer.blobExists(RemoteStoreFence.fenceBlobName(2))
    /**
import java.util.concurrent.atomic.AtomicBoolean;
    }
        );
     * and for a copy whose fence instance is merely BEHIND the object - engine resets during recovery replace the
        // The abort path can now genuinely distinguish the outcomes: the target never wrote, so the revert succeeds
import java.nio.charset.StandardCharsets;
     */
 * SPDX-License-Identifier: Apache-2.0
    public void testLostResponseOnTheAckCasDoesNotFenceAHealthyPrimary() throws IOException {
        assertTrue(source.revertOwnership(1));
        expectThrows(TranslogFencedException.class, () -> stranger.transferOwnershipTo(1, allocationIdOf("node-target")));
        // The next advance lands but its response is lost. It must be reported as retryable, not as fencing.
    }
        assertEquals("alloc-a", parsed.allocationId);
        final FsBlobContainer losingResponses = new FsBlobContainer(blobStore, BlobPath.cleanPath(), repoPath) {
        newPrimary.validateAndAdvance(2);
        source.validateAndAdvance(1);
     */
    private Path repoPath;
import java.util.List;
        );
    private RemoteStoreFence newTranslogInstance(String ownerNodeId) {
    public void testFenceRejectsContainerWithoutConditionalWriteSupport() {
    }
        fence.validateAndAdvance(3);
    }
 */
    }
        source.validateAndAdvance(1);
            incumbent.validateAndAdvance(1);
        RemoteStoreFence.FenceState roundTripped = expectSuccess(new RemoteStoreFence.FenceState("uuid", 0, 7, "alloc-1", "node-1", 3));
        // Target keeps advancing normally
            threads[i] = new Thread(() -> {
        source.transferOwnershipTo(1, allocationIdOf("node-target"));
    private ThreadPool threadPool;
     */
        assertEquals(contenders, bootstrapped.get() + fenced.get());
                throws IOException {
        assertEquals(1, adopted.getTerm());
        assertEquals(1, fence.getTerm());
     */
import static org.mockito.Mockito.CALLS_REAL_METHODS;
    /**
        assertEquals(9, state.term);
                final String token = super.writeBlobConditionally(blobName, in, size, expectedToken);
            IOException.class,
import org.opensearch.threadpool.TestThreadPool;
     */
        blobContainer = (FsBlobContainer) blobStore.blobContainer(BlobPath.cleanPath());
}
package org.opensearch.index.translog.transfer;
        // And the new primary continues on its chain
            blobContainer.readBlobWithVersion(RemoteStoreFence.fenceBlobName(1)).content()
    }
        expectThrows(TranslogFencedException.class, () -> source.validateAndAdvance(2));
     */
    /**
        expectThrows(TranslogFencedException.class, () -> stalled.validateAndAdvance(2));
    }
                    // Landed server-side; the caller never learns the new token.
            IOException.class,
                }
    }
        final long term = 7;
    }
        newFence("node-1").validateAndAdvance(3);
    /**
        assertEquals(0, state.seq);
    public void tearDownThreadPool() {
        source.validateAndAdvance(1);
        // The blob records the shard identity it belongs to (one blob per shard)
        }
            @Override
        source.transferOwnershipTo(1, allocationIdOf("node-target"));
            return RemoteStoreFence.FenceState.parse(state.toBytes());
        assertTrue(blobContainer.blobExists(RemoteStoreFence.fenceBlobName(term)));
        target.validateAndAdvance(1);
        expectThrows(
        assertTrue(bootstrapped.get() >= 1);
            thread.join();
    /** A fence instance requiring recorded ownership, as every translog instance does - see RemoteFsTranslog#buildFence. */
     * An ownership transfer whose response is lost must not leave the source holding a stale token. The write landed -
        // Failover: new primary at a higher term bootstraps and seals the fence over
        assertTrue(e.getMessage(), e.getMessage().contains("fenced"));
        }
     * path means that copy still holds a valid token and would keep acknowledging, so proceeding would put two terms on
     * with no live token held, and the translog instance claims again - re-adopts - on its first upload. If an
     * A stale grant is self-limiting. A copy granted term 2 that stalls before ever acknowledging cannot displace the
        RemoteStoreFence incumbent = newFence("node-1");
    @After
        assertEquals("node-1", roundTripped.nodeId);
        translogInstance.validateAndAdvance(1); // and acknowledges through it
        expectThrows(TranslogFencedException.class, () -> source.validateAndAdvance(1));
    public void testAdvanceIncrementsSeq() throws IOException {
        RemoteStoreFence stale = newFence("node-2");
        assertEquals("alloc-1", roundTripped.allocationId);
        RemoteStoreFence target = newRelocationTarget("node-target");
        TranslogFencedException e = expectThrows(TranslogFencedException.class, () -> translogInstance.validateAndAdvance(1));
    /** Allocation ids in these tests are derived from the node id so both identities stay legible in assertions. */
        assertTrue(
import org.opensearch.common.blobstore.BlobPath;
        final RemoteStoreFence superseded = new RemoteStoreFence(planting, allocationIdOf("node-late"), "node-late", shardId);
 *
        AtomicInteger fenced = new AtomicInteger();
     * A conditional write whose response is lost must not fence a healthy primary.
                }
    /**
        RemoteStoreFence newPrimary = newFence("node-new");
        fence.validateAndAdvance(term);
        assertTrue(fencedInstance.isSuperseded(2));
    }
        assertEquals("node-1", state.nodeId);
        expectThrows(
        return ownerNodeId + "-alloc";
        // The incumbent's path was deleted outright, so its next acknowledgement fails - and stays failed.
     * The separator is unescaped, so a string field containing it would encode a blob that {@code parse} rejects -
     * Determinism: a higher-term claimant wins while the incumbent is actively advancing its own chain. Under
        assertEquals(3, successor.getTerm());
        // every contender either bootstrapped or was explicitly fenced, and only one owns the chain afterwards.
        // And the source serves on, holding the current token.
    public void testFenceStateCodecRejectsGarbage() {
     * to lose - no matter how many times the incumbent acknowledges first.
     * Invariant (one blob per shard): a fence blob describing a different shard at this key means two shards resolved the same path.
    @Before
import java.io.IOException;
            }
        );
        // Once the sweep actually lands, the same claim succeeds.
        assertEquals(2, newPrimary.getTerm());
        // The stalled copy wakes up and tries to acknowledge: its path is gone, so it is fenced and the term-3 owner
    private RemoteStoreFence newFence(String ownerNodeId) {
                if (swallowNextResponse.compareAndSet(true, false)) {
        // A twin creates the path first, so our claim is forced down the equal-term arbitration branch, not create.
        final AtomicBoolean swallowNextResponse = new AtomicBoolean();
        // The target is unaffected and keeps acknowledging.
        expectThrows(TranslogFencedException.class, () -> source.validateAndAdvance(2));
        source.validateAndAdvance(1);
        source.transferOwnershipTo(1, allocationIdOf("node-target"));
     * term-scoped paths the claimant's create-if-absent targets a key the incumbent never writes, so there is no race
     */
        final AtomicBoolean swallowNextResponse = new AtomicBoolean();
    public void testRelocationHandoffTransfersOwnership() throws IOException {
        RemoteStoreFence fencedInstance = newFence("node-3");
        source.transferOwnershipTo(1, allocationIdOf("node-target"));
            throw new AssertionError(e);
     * only ours to remove if we created it: having merely won a CAS against a twin says nothing about whether a further
     * equal-term twin legitimately
        // Stale primary's next upload at the old term must be fenced
        return new RemoteStoreFence(blobContainer, allocationIdOf(ownerNodeId), ownerNodeId, shardId, true);
     * body rather than throwing - S3's DeleteObjects does exactly that, and the shared blob-store helper logs those
    public void testConcurrentBootstrapAdmitsSingleOwner() throws Exception {
        RemoteStoreFence source = newFence("node-source");
            blobContainer.blobExists(RemoteStoreFence.fenceBlobName(term))
        }
                final String token = super.writeBlobConditionally(blobName, in, size, expectedToken);
        // The twin - the legitimate owner whose acknowledged write would have been lost - is untouched.
    /**
    }
        // The transfer lands but its response is lost: it must be reported as complete, with the token adopted.
            () -> RemoteStoreFence.FenceState.parse("v2|uuid|0|1|alloc-1|node-1|0".getBytes(StandardCharsets.UTF_8))
    public void testTermBumpSealsOverOldOwner() throws IOException {
        final AtomicBoolean swallowNextResponse = new AtomicBoolean();
     * the object records the target - so the source adopts the resulting token by identity, exactly as the ack path
                    throw new IOException("connection reset before the response was read");
    public void testRelocationHandoffAtSameTerm() throws IOException {
        RemoteStoreFence oldPrimary = newFence("node-old");
     * <p>
     * the write path at once.
        // First claim: the seal instance claims at term 1, recording this copy's allocation id, and is discarded.
        // Bootstrap tolerates one benign CAS conflict, so more than one contender may seal in; what must hold is that
import org.opensearch.threadpool.ThreadPool;
        assertEquals("uuid", parsed.indexUUID);
            }
        RemoteStoreFence source = newFence("node-source");
            public String writeBlobConditionally(String blobName, java.io.InputStream in, long size, String expectedToken)
        incumbent.validateAndAdvance(1);
        final RemoteStoreFence source = new RemoteStoreFence(losingResponses, allocationIdOf("node-source"), "node-source", shardId);
        fence.validateAndAdvance(5);
    }
        BlobContainer unsupported = mock(BlobContainer.class, CALLS_REAL_METHODS);
        TranslogFencedException e = expectThrows(TranslogFencedException.class, () -> stale.validateAndAdvance(3));
        // Before the handover the target is not the recorded owner and must not take the chain, or it would fence a
    public void testFencedInstanceCannotClaimAnotherTerm() throws IOException {
        IOException e = expectThrows(IOException.class, () -> fence.validateAndAdvance(5));
    public void testMidClaimSupersessionDoesNotWithdrawAPathWonFromAnEqualTermTwin() throws IOException {
                try {
        RemoteStoreFence fence = newFence("node-1");
            RemoteStoreFence fence = newFence("node-" + i);
        };
     * CAS and wrongly conclude the target took over, standing down a healthy source.
        return new RemoteStoreFence(blobContainer, allocationIdOf(ownerNodeId), ownerNodeId, shardId);
        assertEquals(7, roundTripped.term);
    }
import org.opensearch.common.blobstore.BlobContainer;
        for (int i = 0; i < contenders; i++) {
        AtomicInteger bootstrapped = new AtomicInteger();
        newFence("node-new").validateAndAdvance(2);
        // Invariant (fenced is terminal): the same-term takeover rule cannot be used by the zombie to seize the
            () -> RemoteStoreFence.FenceState.parse("v1|uuid|0|1|alloc-1|node-1".getBytes(StandardCharsets.UTF_8))
        threadPool = new TestThreadPool(getTestName());
import org.opensearch.test.OpenSearchTestCase;
        expectThrows(TranslogFencedException.class, () -> target.validateAndAdvance(1));
        // Second claim: this copy's translog instance is not the recorded owner any more, so it must be fenced - never
    public void testAbortedHandoffAfterTheTargetTookOverStandsDown() throws IOException {
     * The re-adoption regression, straight from the {@code FenceTakeover.tla} counterexample. The fence is claimed
        final FsBlobContainer planting = new FsBlobContainer(blobStore, BlobPath.cleanPath(), repoPath) {
        blobContainer.deleteBlobsIgnoringIfNotExists(List.of(RemoteStoreFence.fenceBlobName(3)));
                    fenced.incrementAndGet();
     * happen today; reject it at the source rather than rely on that.
     * twice: the recovery seal claims via a throwaway instance whose token is discarded, the restore point is read
        // Each term's chain starts at seq 0, so one advance after claiming leaves seq 1.
        fence.validateAndAdvance(term);
        // Non-numeric term
    public void testTranslogInstanceAdoptsTheChainItsOwnSealRecorded() throws IOException {
        assertFalse(fence.isSuperseded(3));
        RemoteStoreFence.FenceState finalState = RemoteStoreFence.FenceState.parse(
        expectThrows(UnsupportedOperationException.class, () -> fence.validateAndAdvance(1));
    /** The revert twin: a revert that lands with a lost response reports reclaimed, with the token adopted. */
        blobContainer.deleteBlobsIgnoringIfNotExists(List.of(RemoteStoreFence.fenceBlobName(1)));
