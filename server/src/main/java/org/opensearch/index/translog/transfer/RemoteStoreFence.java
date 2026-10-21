                    )
        this.blobContainer = blobContainer;
 * restore point the new copy read, and nothing it tries afterwards can be acknowledged. That is what covers a
            // Cannot tell, so report the retryable answer rather than guessing.
        final String indexUUID;
        for (int attempt = 0; attempt < MAX_SAME_TERM_ATTEMPTS; attempt++) {
    /**
            throw new TranslogFencedException(
    }
                term
     */
            created
        final String nodeId;
    }
 * how a path is first created.</li>
    }
            created = false;
                && recordedAllocationId.equals(remote.allocationId)
                    remote.shardId
     * Set once this instance has been fenced, and never cleared. Terminality has to be explicit state rather than a
     * upload. An unguarded re-adoption would take the chain back from an equal-term twin that legitimately claimed it
        TranslogFencedException exception = new TranslogFencedException(
 * previous state.</li>
    synchronized long getSeq() {
            } catch (NoSuchFileException e) {
 * <li><b>Seal before restore.</b> Every writer transition claims the chain before it reads the translog restore
     *         copy may resume as primary; {@code false} when the target had already written, meaning the handoff
     * here would contend with the acknowledgement path for the same chain and fence the shard against itself.
        }
 * operations. A resize target, whether shrink, split or clone, is a new index with its own UUID, so its shards claim
        }
     */
                throw e;
import java.nio.charset.StandardCharsets;
            if (adoptOwnWriteIfItLanded(primaryTerm, attemptedSeq, ownerAllocationId) == false) {
    /**
        // failures in its response body rather than throwing, and the shared blob-store helper logs them and returns
        List<String> superseded = new ArrayList<>();
            }
            // containing the separator would silently produce a blob that parse() rejects, which would fence a
            }
        }
 * this true by taking the max of the snapshot's term and the current metadata's. Second, the routing table admits at
                    primaryTerm,
        }
    private static final int MAX_SAME_TERM_ATTEMPTS = 2;
        final String allocationId;
                // (FenceTakeover.tla). Either way the recorded owner is legitimate and must not be fenced.
                remote.term,
            if (versionToken.equals(current.versionToken()) == false) {
    /** Withdraw our own acknowledgement path, so a superseded claim leaves nothing behind. */
            }
}
import java.io.IOException;
 * alternative, a single shared blob escalating to an unconditional overwrite: the listing it takes before escalating
     * take-over in {@link #arbitrateSameTerm} is refused unless the object already records this copy's allocation id
            fenced = true;
        for (String blobName : blobContainer.listBlobsByPrefix(FENCE_BLOB_PREFIX).keySet()) {
    }
        // a further equal-term claimant may have taken it over since, and our token would be stale without us knowing.
 * {@link TranslogFencedException} before the write is acknowledged. That covers both a stale primary after failover
        final int shardId;
    /**
                String.format(Locale.ROOT, "primary fenced by remote store: term [%d] superseded by term [%d]", primaryTerm, higher)
            throw new TranslogFencedException(
 * repository's conditional writes are what provide this, so {@code RemoteFsTranslog#buildFence} refuses a repository
                        Locale.ROOT,
import org.opensearch.common.blobstore.VersionedBlob;
 */
 * can go stale, which lets a lower-term writer fence the rightful higher-term owner. See
 * <p>
import org.opensearch.common.blobstore.BlobVersionConflictException;
     * <p>
     * </ol>
 * <p>
        String ownerNodeId,
            "Fence claimed: term [{}] allocation [{}] node [{}] created [{}]",
        }
 * {@code RemoteFsTranslog#sealFence}), and that ordering is what closes the acked-write-loss window on failover. A
    /**
        } catch (IOException e) {
     * enforced entirely by the CAS chain.
            // unresolved, this copy would keep a stale token, and an aborted handoff's revert would then wrongly
 * </ul>
     * the token retained from the previous write.
            for (String field : new String[] { indexUUID, allocationId, nodeId }) {
        this.ownerNodeId = Objects.requireNonNull(ownerNodeId, "fence owner node id");
     * Resolves an ambiguous conditional write: did our own CAS land before the response was lost?
                allocationId,
            } catch (NumberFormatException e) {
    /**
            ownerAllocationId,
        } catch (IOException e) {
                    Locale.ROOT,
        term = -1;
        } catch (Exception unresolved) {
    /**
    ) {
        // Invariant: seq strictly increases along a term's chain.
                )
import org.opensearch.index.remote.RemoteStoreUtils;
 * so it can acknowledge nothing that lands after the restore point the new copy read. A copy taking a primary
    }
 * a fair race between the two.
    }
                    term,
 * fresh keys and never contend with the write-blocked source. A restore into a new index UUID starts fresh the same
    /**
 * this file be licensed under the Apache-2.0 license or a
 * through {@link #validateAndAdvance}, so a second writer holds a stale token and its next CAS fails with a
        // FenceTakeover.tla draws the same distinction: VerifyClaim withdraws only IF wCreated, and the variable is
            // conclude the target took over. Resolve by identity: a blob recording the target at exactly the
            try {
            // fence. Seeing a different term here is unexpected, so fail closed rather than claim a term this instance
        this.logger = Loggers.getLogger(getClass(), shardId);
import java.nio.file.NoSuchFileException;
 * when the writer cannot reach the cluster manager at all.</li>
 * most one active primary per shard, so two cluster-sanctioned same-term writers only ever exist during a relocation
        return adoptOwnWriteIfItLanded(primaryTerm, attemptedSeq, ownerAllocationId);
    }
    }
                Integer.toString(shardId),
            }
 * means — the <b>translog flow</b>, which the CAS gates directly, and the <b>segment flow</b>, which an ownership
                Locale.ROOT,
     * key, so it cannot defeat the create. A conflict means an equal-term writer already owns it - a relocation
        }
            throw new TranslogFencedException(
                "primary fenced by remote store: fence owned by another writer [%s], local allocation [%s] node [%s] term [%d]",
                "term [%d] owner [%s] seq [%d]",
    private final String ownerAllocationId;
            String.format(
 * strictly lower terms. No step is decided by winning a race. A writer's only destructive act is deleting objects
        } catch (Exception e) {
     */
                // would serve from a restore point read before the twin's acknowledgements, losing them
        final long term;
    /**
                    String.format(
 * way, and a partitioned writer of the incarnation being replaced can only touch keys nothing will read again.</li>
            content.length,
                        + " two shards resolved the same fence path",
                String.format(
        return seq;
            }
        byte[] toBytes() {
     * </ul>
                primaryTerm
        try {
     * {@code FenceTakeover.tla} exhibits that trace with the guard off and proves the guard restores
                String.format(
    private void arbitrateSameTerm(long primaryTerm) throws IOException {
        try {
            // Arbitration takes an existing object over; it never creates one, so the path is not ours to withdraw.
import org.opensearch.common.blobstore.BlobContainer;
        try {
        // here rather than at the first CAS also stops a doomed copy hydrating segments and replaying a translog it
        if (remote.indexUUID.equals(shardId.getIndex().getUUID()) == false || remote.shardId != shardId.id()) {
        // retryably: nothing has been acknowledged at this point.
    /**
 * CAS after the metadata upload and before it acknowledges.</li>
     * source/target pair, or an in-place restore - which falls through to ordinary CAS arbitration.</li>
        // and would keep acknowledging, so proceeding would put two terms on the write path at once. Refuse instead,
     * resets during recovery replace the translog, and so the fence, several times in quick succession - and such an
                FenceState twin = readRemoteState(current.content());
                Locale.ROOT,
            );
        this.shardId = shardId;
            // wrote it. Not treating this as terminal is what keeps the error retryable.
                    "primary fenced by remote store: term [%d] superseded by term [%d] mid-claim",
     * called on every translog upload strictly AFTER the metadata upload has completed and before the upload is
            } catch (IOException e) {
                remote.describeOwner(),
     * won this way is never ours to withdraw - see {@link #withdraw}.
            }
    }
                    primaryTerm
                indexUUID,
                    survivor.get(),
     * ({@link #transferOwnershipTo}). Claiming blindly is what fences a healthy source whose handoff later aborts.</li>
 * <ul>
     * <li><b>Delete every lower-term object.</b> Unconditional, so it always succeeds: this is the act that fences the
                this.versionToken = current.versionToken();
 * <li>A <b>CAS</b> - compare-and-swap - is a write the store accepts only if the object's current version is the one
     * interpret.
    }
    /**
 * from a snapshot restore, take the chain.</li>
    public synchronized boolean revertOwnership(long primaryTerm) throws IOException {
package org.opensearch.index.translog.transfer;
            new ByteArrayInputStream(content),
 * <li><b>The owner is advisory.</b> The allocation id and node id are recorded for the audit trail and for
        if (survivor.isPresent()) {
        String remoteDescription;
     * responsibility, not the fence's.
     * token this produces is retained, which is what makes {@link #revertOwnership} able to distinguish a target that
        for (String blobName : blobContainer.listBlobsByPrefix(FENCE_BLOB_PREFIX).keySet()) {
 * check gates. Neither reads the fence, so snapshot restore, pinned-timestamp resolution and GC never touch it, and
            this.shardId = shardId;
            FenceState remote = readRemoteState(blobContainer.readBlobWithVersion(fenceBlobName(highest)).content());
                ownerNodeId,
        static FenceState parse(byte[] content) throws IOException {
 * writer's object still existed, so a takeover's sweep - and the restore-point read behind it - can only come
                CODEC_VERSION,
    private long seq = -1;
 * that lacks them rather than running unfenced.</li>
 * present the current token and hands back the next one, so the links cannot be skipped: <em>holding the current
    private static final String FIELD_SEPARATOR = "|";
                fenced = true;
    public synchronized void transferOwnershipTo(long primaryTerm, String targetAllocationId) throws IOException {
                    Locale.ROOT,
                    remote.indexUUID,
     * @throws IOException on repository errors
        // Re-assert that we still hold our own path, which is VerifyClaim's wHeld = pathToken guard. One GET, and
/**
                return true;
 * later, when the metadata is already visible. Run concurrently instead, the CAS can win before the sweep while
     * Reclaims ownership after an aborted relocation handoff, using the token produced by
                Long.toString(term),
                )
 * remains: a fenced writer can leave a single orphan metadata file behind - published, then refused at the CAS. It
        this.ownerAllocationId = Objects.requireNonNull(ownerAllocationId, "fence owner allocation id");
    }
            VersionedBlob blob;
            fenced = true;
 */
                throw new IOException("Unrecognized fence blob content");
     */
    private boolean fenced;
            logger.info("Fence removed superseded acknowledgement paths {} on claiming term [{}]", superseded, primaryTerm);
        return RemoteStoreUtils.invertLong(blobName.substring(FENCE_BLOB_PREFIX.length()));
            primaryTerm,
     * NoAckedWriteLoss.</li>
    private long term = -1;
 * The fencing token is therefore this chain, not the primary term. Every acknowledged translog upload advances it
                    "primary fenced by remote store: fence for term [%d] asked to acknowledge at term [%d]",
                    Long.parseLong(tokens[6])
     */
            exception.addSuppressed(cause);
                );
                throw e;
     * term, allocation id and node id along with its seq, so a blob carrying ours at exactly the seq we attempted can
        // success - so a "successful" sweep can leave a lower-term path standing. That copy still holds a valid token
                );
     * copy has been superseded.
     * during that window - and then serve from a restore point read before the twin's acknowledgements, losing them.
        assert primaryTerm != term || nextSeq > seq : "fence seq must advance: [" + seq + "] -> [" + nextSeq + "]";
 * previous writer stuck behind a network partition. Asserted at the read choke point in
        // a precondition in both the spec and the code.
        // One listing, two checks. Both matter, and the second is not belt-and-braces: a batch delete reports per-key
     * Every step is either uncontested by the incumbent or unconditional, which is what makes a higher-term takeover
        final long attemptedSeq = seq + 1;
     * <ol>
     * arbitration loss rather than a race worth outlasting.
     * <p>
        }
     * The distinction matters. A copy can legitimately hold a fence instance that is BEHIND the fence object - engine
        if (createdByThisCopy) {
     */
            throw fencedException(null);
            throw fencedException(e);
     * a relocation handoff records the target's. The node id stays ours on every write this instance issues, so the
    }
 * delete rather than the CAS that makes a higher-term takeover certain instead of a race - a CAS alone would only be
        } catch (BlobVersionConflictException e) {
    public boolean isSuperseded(long primaryTerm) throws IOException {
     * to claim that term's path, since it was never granted it - doing so would let it delete its own successor's
        ShardId shardId,
                // Best effort: a successor deletes every lower-term path anyway, so a leftover is transient.
            .toBytes();
                );
    private void withdraw(long primaryTerm, boolean createdByThisCopy) {
    /**
        }
                    Locale.ROOT,
     * <p>
            long highest = highestTerm(0);
            claim(primaryTerm);
        }
     * <p>
 *
     * and the node id is recorded alongside it for operators; both are advisory, since exclusion is
                throw new TranslogFencedException(
        return exception;
        if (fenced) {
        Optional<Long> survivor = remaining.stream().filter(t -> t < primaryTerm).findFirst();
    private final String ownerNodeId;
 * <p>
    }
 * The OpenSearch Contributors require contributions made to
            );
            );
            // copy resumes with the current chain rather than a stale one; if it cannot be resolved, rethrow - the
 * {@code formal-models/remote-store-fence/}, are written in these terms.
     * <li><b>Create</b> our own {@code fence__<term>} with create-if-absent. A lower-term incumbent never writes this
import java.util.ArrayList;
                superseded.add(blobName);
 * loudly instead of letting two shards fence each other. The index UUID in the path isolates index lifecycle
        if (versionToken == null || primaryTerm != term) {
                throw new TranslogFencedException(
 * <b>CAS, and the CAS chain.</b> Defined here because the rest of this class, and the TLA+ specifications under
            );
 * <p>
                    "Fence sweep left the acknowledgement path for superseded term [%d] in place while claiming term [%d]; retry",
 * has to be synced back to it. The fence borrows just two properties from cluster coordination. First, primary terms
                // This copy is not the recorded owner, so the chain is not its to take. For a relocation target the
            // Ambiguous, exactly as on the ack path: the transfer may have landed with only the response lost. Left
     * wrongly silences a healthy shard; asking "does a higher term exist?" separates them.
                )
            }
            this.allocationId = allocationId;
     * without being on the acknowledgement path: publishing segment metadata, and garbage collection on either plane.
     * instance is stale, not superseded. Asking "do I still hold my own object?" answers false for both cases and
    private TranslogFencedException fencedException(Exception cause) {
            }
    private final boolean requireRecordedOwnership;
            throw fencedException(e);
        // precondition of completing a claim rather than a test on one branch of it. Checking it first can cost a
        logger.info(
                this.seq = attemptedSeq;
        }
     * Fence blob content: {@code v1|<indexUUID>|<shardId>|<term>|<allocationId>|<nodeId>|<seq>} in UTF-8.
        deleteTermsBelow(primaryTerm);
        }
            if (tokens.length != 7 || CODEC_VERSION.equals(tokens[0]) == false) {
            logger.warn("Could not determine whether the fence write at term [" + primaryTerm + "] landed", unresolved);
        long higher = highestTerm(primaryTerm);
     */
        return terms;
     * <ul>
            // 0 rather than -1 as the floor: an empty listing must not produce a negative term, which has no encoding.
            created = true;
    // Visible for testing
 * every snapshot-referenced file stays immutable under an unchanged name.
                return; // taken over, not created: never ours to withdraw
 * translog is built. Once the previous writer's token is invalid, everything it acknowledged is already in the
            arbitrateSameTerm(primaryTerm);
                );
        }
     * @param primaryTerm the primary term this upload is being performed at
    /**
import java.util.Locale;
    /**
        boolean created;
     * in-place restore) contend for an existing object, and losing repeatedly to an equal-term writer is a legitimate
                    "Fence blob belongs to a different shard: expected index uuid [%s] shard [%d] but found [%s][%d];"
                throw e;
            }
        } catch (BlobVersionConflictException e) {
            }
/*
 * content records the shard identity, checked on every read ({@link #readRemoteState}), so a path collision fails
            expectedToken
     * higher-term writer's acknowledgement path. Determinism therefore follows from the key space rather than from
                    attemptedSeq
    synchronized long getTerm() {
                    tokens[4],
        cas(primaryTerm, expectedToken, nextSeq, ownerAllocationId);
                this.term = primaryTerm;
                    tokens[5],
        }
     * (term, seq, recorded allocation id, node id) tuple still identifies the write uniquely.
                return new FenceState(
    public synchronized void validateAndAdvance(long primaryTerm) throws IOException {
            }
        versionToken = null;
            // A fence instance belongs to one shard copy at one term - a term change means a new engine, and so a new
            throw new IOException(
    // Visible for testing
    private Set<Long> listTerms() throws IOException {
        Set<Long> remaining = listTerms();
     * Performed by the copy that currently owns the chain, after its uploads have drained, so it is uncontested. The
                    )
    private void cas(long primaryTerm, String expectedToken, long nextSeq, String recordedAllocationId) throws IOException {
    // Guarded by synchronized methods. Uploads on the ack path are effectively serialized by the translog sync
                fenced = true;
        throw fencedException(null);
                    Locale.ROOT,
        // wasted retry when a higher term is also present, which is a price worth paying to keep "the sweep landed"
 * Object-store-backed primary fencing for a shard. Keeps one small mutable {@code fence__<term>} object per primary
 * term in the translog repository, written only by compare-and-swap
     * <li>An ordinary copy's translog instance performs the second of the two claims a takeover makes: the recovery seal
 * and a zombie relocation source. On top of that, a successor deletes the superseded writer's object, and it is the
     * allocation id identifies the owning shard <i>copy</i> — the identity the cluster's in-sync set is expressed in —
            try {
        if (higher > primaryTerm) {
     */
import java.util.Optional;
        } catch (IOException e) {
        // claims happen on recovery, promotion and relocation rather than per operation. Detecting an equal-term twin
     * <li>A primary relocation target shares a term - and therefore an object - with a source that is still
                    throw new IllegalArgumentException("Fence field [" + field + "] must not contain [" + FIELD_SEPARATOR + "]");
            throw fencedException(e);
     */
     */
 * the metadata is still in flight, and an acknowledged operation lands in a metadata file no recovery will ever
                String.format(
                    primaryTerm,
            // Withdraw only a path this copy CREATED - see withdraw(). Either way the higher term's sweep removes it,
     * Settles a contest with an equal-term twin for an object that already exists. Never creates the object, so a path
                FIELD_SEPARATOR,
    }
                        twin.describeOwner()
 *
 * was never acknowledged, it is term-scoped, and readers that follow the highest-term lineage ignore it. Cleaning
public class RemoteStoreFence {
     * shared object last owns it and the other fails its next upload. Same-term ordering is the handoff protocol's
                );
     * The acknowledgement-path object for {@code term}. The term is inverted so that a plain prefix listing returns the
            // so withdrawing is a courtesy that saves that successor a retry, never a requirement.
                if (field.contains(FIELD_SEPARATOR)) {
    private void claim(long primaryTerm) throws IOException {
 * <ul>
     * Equal-term arbitration. A relocation source and its target legitimately share a term, so whichever CASes the
    private final Logger logger;
    /**
 * resolve ({@code RemoteStoreFence.tla} in {@code formal-models/} exhibits the trace with {@code SEQUENCED = FALSE}). One consequence
     *
     * legitimate. Anything else - a different writer, a different seq, an unreadable or missing object - is reported as
            cas(primaryTerm, versionToken, attemptedSeq, targetAllocationId);
                logger.info("Fence equal-term arbitration conflict on attempt [{}], retrying", attempt + 1);
        // This is also the single place a writer would delete at its OWN term, the one exception to "a writer's only
        }
            String[] tokens = new String(content, StandardCharsets.UTF_8).split("\\" + FIELD_SEPARATOR);
                )
 * is the whole mechanism - staleness is detectable because there is no way to write without proving you saw the
                        primaryTerm
            );
            this.seq = seq;
 * </ul>
                    Locale.ROOT,
     * acknowledged (invariant: the chain gates the ack, and the CAS follows the metadata). The ordering is what makes
            throw new TranslogFencedException(
        try {
    public static String fenceBlobName(long term) {
            terms.add(termOf(blobName));
        }
        String describeOwner() {
        String newToken = blobContainer.writeBlobConditionally(
 * highest term first. That ordering matters because an object store cannot interpret primary terms, and the name is
            }
            )
        try {
        this(blobContainer, ownerAllocationId, ownerNodeId, shardId, false);
     * winning a race - model-checked in {@code FenceTakeover.tla}.
     * Answers by identity rather than by token, which is the only way to tell. The object records the writing copy's
        logger.info("Fence ownership handed to allocation [{}] at term [{}]", targetAllocationId, primaryTerm);
                ownerAllocationId,
import java.util.List;
     * As above, for writes that record a different allocation id than this instance's own - the ownership transfer of
     * <li><b>List again.</b> A grant issued during our window supersedes ours: withdraw our own object and refuse, so
        seq = -1;
 * handoff. Everything else is enforced on the object-store side, which is the point: fencing has to keep working
 * <li><b>One object per term, keyed by index UUID.</b> Every writer at a given term resolves the same key, and the
            fenced = true;
     * {@code TranslogTransferMetadata.METADATA_PREFIX}, so metadata listings, restore lineage and GC never see these.
    private boolean adoptOwnWriteIfItLanded(long primaryTerm, long attemptedSeq) {
        }
     * @return {@code true} when ownership was reclaimed, meaning the target never wrote and so never took over - this
     */
            ownerNodeId,
 * The fence blob sits on the <b>control flow</b>: it carries decisions about who may write, and never any shard
            if (remote.seq == attemptedSeq
        this.term = primaryTerm;
            if (adoptOwnWriteIfItLanded(primaryTerm, attemptedSeq) == false) {
            cas(primaryTerm, versionToken, attemptedSeq, ownerAllocationId);
 * incumbent, being a create-if-absent on a key only this term's owner writes, or unconditional, being a delete of
    }
        Set<Long> terms = new HashSet<>();
 * below its own term, so it can never touch a higher-term writer's path. Model checking refuted the obvious
        String ownerAllocationId,
     * <li><b>List.</b> A strictly higher term already owning a path means this copy has been superseded - refuse.</li>
            fenceBlobName(primaryTerm),
            this.indexUUID = indexUUID;
            // was never granted.
                    "Fence write at term [{}] seq [{}] had landed; adopted its token after a lost response",
                nodeId,
 * diagnostics. No authorization decision reads them, which is what lets a legitimate brand-new copy, such as one
     */
import java.io.ByteArrayInputStream;
                blobContainer.deleteBlobsIgnoringIfNotExists(List.of(fenceBlobName(primaryTerm)));
 * <li><b>Seq strictly increases along a term's chain</b> (asserted in {@link #cas}).</li>
    }
        BlobContainer blobContainer,
 * <li><b>The chain gates the ack.</b> An upload is acknowledged only if its fence CAS succeeded, and the CAS is
                remote.seq
            cas(primaryTerm, null, 0);
        try {
     * ({@code RemoteFsTranslog#sealFence}) claims via a throwaway instance and records this copy's allocation id, the
        return FENCE_BLOB_PREFIX + RemoteStoreUtils.invertLong(term);
            if (termOf(blobName) < primaryTerm) {
 * {@code FenceTakeover.tla}.</li>
            VersionedBlob current = blobContainer.readBlobWithVersion(fenceBlobName(primaryTerm));
    }
    private String versionToken;
                // is reassigned at a higher term and claims cleanly then - while putting a create-if-absent on a path
 * new shard incarnation, with a new instance, may claim again.</li>
        }
     * a stale grant is self-limiting rather than able to displace the rightful owner.</li>
        }
            );
            } catch (BlobVersionConflictException e) {
    public static final String FENCE_BLOB_PREFIX = "fence__";
        return true;
                // source has not handed ownership over (or reclaimed it after aborting); for an ordinary copy's
 * point it will serve from, or before it destroys remote translog state as a snapshot restore does. The one
        try {
                logger.info(
 * those up is a follow-up.
        final long attemptedSeq = seq + 1;
     * incumbent, whose next CAS then finds its object gone.</li>
 * remote-store recovery, and snapshot restore, including snapshot V2, where the restore point is downloaded when the
    private final ShardId shardId;
        return highestTerm(primaryTerm) > primaryTerm;
            withdraw(primaryTerm, created);
        } catch (BlobVersionConflictException e) {
        // will never serve, and stops us withdrawing below a path that twin now owns.
            // Our own path is gone, so a successor swept it: the same outcome as losing the CAS.
                        "primary fenced by remote store: the acknowledgement path for term [%d] no longer exists to arbitrate for",
        FenceState(String indexUUID, int shardId, long term, String allocationId, String nodeId, long seq) {
    private FenceState readRemoteState(byte[] content) throws IOException {
 * previous primary that is still running but has dropped out of the cluster's view loses its object at that moment,
        if (fenced) {
            throw fencedException(null);
        // Order follows VerifyClaim in FenceTakeover.tla, where no-surviving-lower-term is an unconditional
                        Locale.ROOT,
        // commented "whether this copy CREATED its own path (so whether it may withdraw it)".
    private boolean adoptOwnWriteIfItLanded(long primaryTerm, long attemptedSeq, String recordedAllocationId) {
 * <b>Invariants.</b> Referenced by name from the code that enforces them:
        this.seq = nextSeq;
                    shardId.id(),
            // higher-term successor, so this instance can never acknowledge again. Re-read to report who superseded us.
                String.format(
        fenced = true;
        higher = remaining.stream().max(Long::compareTo).orElse(primaryTerm);
 * token is what it means to own the object</em>, and a writer that misses one link can never rejoin the chain. That
 * <li><b>A higher term prevails, deterministically.</b> Every step of {@link #claim} is either uncontested by the
    /** Unconditional deletes - the act that fences a lower-term incumbent. */
                // ArbitrateSameTerm does in FenceTakeover.tla, rather than recreating the object. Recreating would be
 * A recovering primary claims the fence <b>before</b> it reads its translog restore point (see
            // being fenced - failing a healthy primary on a network blip. Resolve it by reading who the object says
                }
        }
        }
        }
     * Bound on equal-term arbitration attempts. Only equal-term claimants (a relocation source and its target, or an
 * legitimate equal-term takeovers; {@link #arbitrateSameTerm} settles those by CAS instead of by term.</li>
     * Only the seal instance itself arbitrates unguarded ({@code false}): a brand-new legitimate incarnation - a
 * {@code IndexShard#syncRemoteTranslogAndUpdateGlobalCheckpoint}.</li>
 * the one place it can compare them. So the cluster manager authorizes a takeover without doing any I/O itself.
        // destructive act is deleting strictly BELOW its own term" that the rest of the protocol leans on.
     * Parses the fence blob and validates that it describes this shard (invariant: one blob per shard): a fence blob for a different
                    String.format(
                throw new TranslogFencedException(
     * Whether a strictly higher primary term now owns an acknowledgement path for this shard - that is, whether this
        final long attemptedSeq = seq + 1;
            FenceState remote = readRemoteState(current.content());
            this.term = term;
    }
     * shard means two shards resolved the same key, which must fail loudly rather than let them fence each other.
            }
    }
     */
            this.nodeId = nodeId;
        if (superseded.isEmpty() == false) {
            return false;
            throw new IOException(
        );
                logger.warn("Failed to withdraw the fence for superseded term [" + primaryTerm + "]", e);
    private void deleteTermsBelow(long primaryTerm) throws IOException {
    /**
    }
            try {
 * the caller presents, and <em>refuses</em> otherwise rather than applying it. Object stores expose this as a
        if (higher > primaryTerm) {
 * <li><b>No cluster-manager synchronization.</b> The cluster manager neither reads nor writes the fence, and nothing
            blobContainer.deleteBlobsIgnoringIfNotExists(superseded);
            remoteDescription = "unreadable";
     * object and resurrect itself.
    /** The terms that currently own an acknowledgement path for this shard. */
     * A writer's only destructive act is deleting objects strictly below its own term, so it can never touch a
     * Hands ownership of this term's acknowledgement path to {@code targetAllocationId}, as the final act of a primary
                // reachable legitimately only when the twin genuinely withdrew, and it buys nothing there - this copy
     * deliberately independent of this instance's cached state. Used to gate operations that mutate shared remote state
            try {
import java.util.Objects;
     * a successful CAS a proof of visibility: the fence object still existed, so a takeover's sweep - and the
                    higher
    private long highestTerm(long floor) throws IOException {
 * The CAS is issued only <b>after</b> the immutable translog metadata upload has completed, and the upload is
 * <li><b>One writer at a time.</b> Any successful fence write invalidates every other holder's token. The
 * <li><b>The term never regresses.</b> {@link #claim} refuses a claimant below the highest term that owns an
                        "primary fenced by remote store: not the recorded owner of the acknowledgement path at term [%d]: owned by [%s]",
import org.opensearch.common.logging.Loggers;
 * <p>
     *         effectively completed and this copy must stand down. Standing down is not a fencing error.
        logger.info("Fence ownership reclaimed at term [{}] after an aborted relocation handoff", primaryTerm);
            return String.join(
 * acknowledgement path. An equal term may still claim, because relocation and in-place snapshot restore are both
                    "cannot hand off the fence at term [%d]: this copy does not own the chain (fence term [%d])",
                String.format(
     * Validates that this shard copy still owns its term's acknowledgement path and advances the CAS chain. Must be
            // Ambiguous rather than failed: the conditional write may have landed with only the response lost. Our
                Long.toString(seq)
            if (requireRecordedOwnership && ownerAllocationId.equals(remote.allocationId) == false) {
     * took over from one that never wrote - the ambiguity the source and target cannot resolve between themselves.
                && ownerNodeId.equals(remote.nodeId)) {
        // Local state is released either way: this instance is fenced and must never acknowledge again.
     * Claims the acknowledgement path for {@code primaryTerm}, deterministically with respect to the incumbent.
     * restore point is read with no live token held, and the translog instance re-adopts the chain on its first
                        primaryTerm,
        if (cause != null) {
        }
        return false;
     * A read, not a CAS: these paths need "stop touching shared state once superseded", not mutual exclusion, and a CAS
 * opaque <b>version token</b>; this class never interprets it. Presenting no token means "only if absent", which is
     * "did not land", which is the retryable direction and never fences.
            return false;
                        Locale.ROOT,
    public RemoteStoreFence(
                blob = blobContainer.readBlobWithVersion(fenceBlobName(primaryTerm));
        }
        }
                    shardId.getIndex().getUUID(),
            return String.format(Locale.ROOT, "allocation [%s] node [%s]", allocationId, nodeId);
 * precondition on the write: S3 {@code If-Match}, GCS generation preconditions, Azure ETags. The version itself is an
import java.util.HashSet;
        final long seq;
 * SPDX-License-Identifier: Apache-2.0
 * term means sharing an object, so ordering between those two is the handoff protocol's job, not the fence's.
     * The index UUID and shard id make the blob self-describing and are validated on every read (one blob per shard). The
     */
 * compatible open source license.
                fenced = true;
                // translog instance an equal-term twin claimed the chain after this copy's seal - and taking it back
        }
            // attempted seq, written from this node, can only be this transfer.
 * are issued monotonically, so a primary appointed after a failure carries a strictly higher term; restore keeps
                cas(primaryTerm, blob.versionToken(), remote.seq + 1);
        // Delete only an object this copy created. Winning one from an equal-term twin does not make it ours to remove:
                    Long.parseLong(tokens[3]),
                        primaryTerm,
     * legitimately serving, so it may only take the chain over once the source has explicitly handed ownership to it
            ).getBytes(StandardCharsets.UTF_8);
                    primaryTerm
 * @opensearch.internal
 * ({@link BlobContainer#writeBlobConditionally}). The term is inverted in the name, so a prefix listing returns the
    }
     * <p>
        }
            // caller treats a failed revert conservatively, and the next upload settles ownership either way.
            FenceState remote = readRemoteState(blob.content());
            // token would then be stale, and the next attempt's If-Match would fail and be indistinguishable from
        return remote;
    // permits, but the fence must never issue two CAS calls with the same token.
     * Set for every fence instance whose arbitration must be authorized by RECORDED OWNERSHIP: the equal-term
                "Fence ownership at term [{}] is no longer ours - the target took it up, or a higher term swept it; standing down",
     * as its owner. Two kinds of instance require it, for the same reason - an equal-term twin may legitimately hold
import org.opensearch.core.index.shard.ShardId;
        boolean requireRecordedOwnership
                )
 * <li>The <b>CAS chain</b> is the succession of tokens one fence object passes through. A successful write must
    /** The highest term owning an acknowledgement path, or {@code floor} when none is above it. */
     * Deliberately a POSITIVE test for supersession rather than a test that this copy still holds its own object, and
     * @throws TranslogFencedException if another shard copy owns the fence — fatal, the caller must stop acking
     * failover promotion, a store recovery, an in-place snapshot restore - must be able to take over a dead
                remoteDescription,
                    String.format(
                    tokens[1],
     * <p>
        return listTerms().stream().max(Long::compareTo).filter(t -> t > floor).orElse(floor);
 * <li><b>Fenced is terminal.</b> An instance whose path was taken over or deleted never acknowledges again. Only a
        if (primaryTerm != term) {
 * relocation handoff does not seal, because its source is still serving legitimately at the same term. Sharing a
     * Prefix of the per-term acknowledgement-path objects. Deliberately neither a prefix of nor prefixed by
     * highest term first - which is what lets the object store order cluster-manager-issued grants it cannot otherwise
        } catch (NoSuchFileException e) {
    private static long termOf(String blobName) {
    /**
        }
 * exception is a same-term relocation handoff. This holds on every takeover path: failover promotion, store and
    }
        if (fenced || versionToken == null || primaryTerm != term) {
        } catch (BlobVersionConflictException e) {
     */
                        "primary fenced by remote store: the acknowledgement path for term [%d] was taken over mid-claim by [%s]",
 * data. Shard data travels on two other paths, named separately throughout because they are fenced by different
     * guaranteed rather than probabilistic:
            return;
    private static final String CODEC_VERSION = "v1";
            cas(primaryTerm, versionToken, attemptedSeq);
        this.versionToken = newToken;
        this.requireRecordedOwnership = requireRecordedOwnership;
    static final class FenceState {
                    primaryTerm,
    private void cas(long primaryTerm, String expectedToken, long nextSeq) throws IOException {
                    Integer.parseInt(tokens[2]),
     * first call claims the path for {@code primaryTerm} (see {@link #claim}); every later call advances the chain with
                    term
        );
    public RemoteStoreFence(BlobContainer blobContainer, String ownerAllocationId, String ownerNodeId, ShardId shardId) {
     * {@link #transferOwnershipTo}.
            // Fenced is terminal: our acknowledgement path was either taken over by an equal-term twin or deleted by a
            VersionedBlob current = blobContainer.readBlobWithVersion(fenceBlobName(primaryTerm));
            );
            logger.info(
 * issued only after the upload's metadata is visible. {@code TranslogTransferManager#transferSnapshot} runs the
     * the chain, and taking it from that twin loses the twin's acknowledged writes:
                    )
        );
            remoteDescription = String.format(
     */
    }
            // Index UUIDs, allocation ids and node ids are base64 UUIDs today, so this cannot fire; encoding a field
     * incumbent's path whose recorded owner it can never match.
import java.util.Set;
        if (versionToken == null) {
 * acknowledged only once both have succeeded. The ordering is load-bearing: a successful CAS then proves this
     * relocation handoff.
     *
                // a successor may just have swept, which the spec does not sanction.
import org.apache.logging.log4j.Logger;
            // healthy primary.
                throw new IOException("Unrecognized fence blob content", e);
                // Nothing left to arbitrate for: the twin withdrew, or a successor swept the path. Fence, as
                        remote.describeOwner()
            // Ambiguous: the revert may have landed with only the response lost. If it did, adopt its token so this
     * <p>
     * only be the write we just issued. In that case adopt the token it now has and carry on; the acknowledgement is
                && remote.term == primaryTerm
            );
            if (adoptOwnWriteIfItLanded(primaryTerm, attemptedSeq, targetAllocationId) == false) {
    private final BlobContainer blobContainer;
        return term;
     * consequence of holding a stale token: a fenced instance asked to act at a <i>different</i> term must not be able
     * restore-point read behind it - can only come later, when this upload's metadata has already landed. The
        FenceState remote = FenceState.parse(content);
        byte[] content = new FenceState(shardId.getIndex().getUUID(), shardId.id(), primaryTerm, recordedAllocationId, ownerNodeId, nextSeq)
