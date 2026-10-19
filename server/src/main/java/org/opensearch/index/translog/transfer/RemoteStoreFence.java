                throw new TranslogFencedException(
     * only be the write we just issued. In that case adopt the token it now has and carry on; the acknowledgement is
                        Locale.ROOT,  
     * Performed by the copy that currently owns the chain, after its uploads have drained, so it is uncontested. The
        static FenceState parse(byte[] content) throws IOException {  
        }
        final String allocationId;
 * {@code formal-models/remote-store-fence/}, are written in these terms.
 * A recovering primary claims the fence <b>before</b> it reads its translog restore point (see
            created = false;
                        primaryTerm,
            .toBytes();  
    }
     */
     * highest term first - which is what lets the object store order cluster-manager-issued grants it cannot otherwise
        }
                    "cannot hand off the fence at term [%d]: this copy does not own the chain (fence term [%d])",
 * most one active primary per shard, so two cluster-sanctioned same-term writers only ever exist during a relocation  
    private static final String CODEC_VERSION = "v1";
            } catch (NumberFormatException e) {
    /**
        }
            ownerAllocationId,  
    }
 * The OpenSearch Contributors require contributions made to  
            } catch (BlobVersionConflictException e) {
        boolean created;
    /**  
 */  
import org.opensearch.common.blobstore.BlobVersionConflictException;  
import java.nio.file.NoSuchFileException;  
 * point it will serve from, or before it destroys remote translog state as a snapshot restore does. The one  
            blobContainer.deleteBlobsIgnoringIfNotExists(superseded);  
            if (requireRecordedOwnership && ownerAllocationId.equals(remote.allocationId) == false) {
 * strictly lower terms. No step is decided by winning a race. A writer's only destructive act is deleting objects  
                // source has not handed ownership over (or reclaimed it after aborting); for an ordinary copy's  
package org.opensearch.index.translog.transfer;
 * previous state.</li>
    }
        }
            // 0 rather than -1 as the floor: an empty listing must not produce a negative term, which has no encoding.
        String ownerNodeId,  
        FenceState remote = FenceState.parse(content);
     * NoAckedWriteLoss.</li>  
                fenced = true;
            this.allocationId = allocationId;
                )
    }
import java.io.ByteArrayInputStream;  
 * data. Shard data travels on two other paths, named separately throughout because they are fenced by different  
        List<String> superseded = new ArrayList<>();
            );  
        // Order follows VerifyClaim in FenceTakeover.tla, where no-surviving-lower-term is an unconditional
     *         copy may resume as primary; {@code false} when the target had already written, meaning the handoff
        } catch (NoSuchFileException e) {
                FIELD_SEPARATOR,
        this.ownerAllocationId = Objects.requireNonNull(ownerAllocationId, "fence owner allocation id");  
        }
     * called on every translog upload strictly AFTER the metadata upload has completed and before the upload is
     * shard means two shards resolved the same key, which must fail loudly rather than let them fence each other.
     * @throws TranslogFencedException if another shard copy owns the fence — fatal, the caller must stop acking
     * {@code FenceTakeover.tla} exhibits that trace with the guard off and proves the guard restores
 * previous writer stuck behind a network partition. Asserted at the read choke point in
 * that lacks them rather than running unfenced.</li>
     * Answers by identity rather than by token, which is the only way to tell. The object records the writing copy's
                superseded.add(blobName);
            );
                // (FenceTakeover.tla). Either way the recorded owner is legitimate and must not be fenced.  
     * legitimately serving, so it may only take the chain over once the source has explicitly handed ownership to it
        this(blobContainer, ownerAllocationId, ownerNodeId, shardId, false);  
import org.opensearch.common.blobstore.BlobContainer;
            )
 * <p>  
     * Set once this instance has been fenced, and never cleared. Terminality has to be explicit state rather than a  
     * Every step is either uncontested by the incumbent or unconditional, which is what makes a higher-term takeover  
     * ({@code RemoteFsTranslog#sealFence}) claims via a throwaway instance and records this copy's allocation id, the
 * is the whole mechanism - staleness is detectable because there is no way to write without proving you saw the  
                nodeId,
        return false;  
        Optional<Long> survivor = remaining.stream().filter(t -> t < primaryTerm).findFirst();  
        );  
        }
            }
        if (versionToken == null) {
        try {  
 * are issued monotonically, so a primary appointed after a failure carries a strictly higher term; restore keeps
                blobContainer.deleteBlobsIgnoringIfNotExists(List.of(fenceBlobName(primaryTerm)));  
            // Fenced is terminal: our acknowledgement path was either taken over by an equal-term twin or deleted by a  
            created = true;
        // Re-assert that we still hold our own path, which is VerifyClaim's wHeld = pathToken guard. One GET, and
        for (String blobName : blobContainer.listBlobsByPrefix(FENCE_BLOB_PREFIX).keySet()) {
        byte[] content = new FenceState(shardId.getIndex().getUUID(), shardId.id(), primaryTerm, recordedAllocationId, ownerNodeId, nextSeq)
import java.nio.charset.StandardCharsets;
        final long attemptedSeq = seq + 1;
        // This is also the single place a writer would delete at its OWN term, the one exception to "a writer's only  
                ownerNodeId,
            fenced = true;
                // Nothing left to arbitrate for: the twin withdrew, or a successor swept the path. Fence, as
            try {
        // a precondition in both the spec and the code.
            remoteDescription = "unreadable";  
                    "primary fenced by remote store: fence for term [%d] asked to acknowledge at term [%d]",
    private String versionToken;
     * "did not land", which is the retryable direction and never fences.  
 * remains: a fenced writer can leave a single orphan metadata file behind - published, then refused at the CAS. It
    }
     * object and resurrect itself.  
            return String.format(Locale.ROOT, "allocation [%s] node [%s]", allocationId, nodeId);
    }  
 * {@code IndexShard#syncRemoteTranslogAndUpdateGlobalCheckpoint}.</li>  
                    "primary fenced by remote store: term [%d] superseded by term [%d] mid-claim",  
     * <p>  
                )  
                blob = blobContainer.readBlobWithVersion(fenceBlobName(primaryTerm));
     * relocation handoff.
 * was never acknowledged, it is term-scoped, and readers that follow the highest-term lineage ignore it. Cleaning
        this.term = primaryTerm;
            return false;
                    primaryTerm
            VersionedBlob current = blobContainer.readBlobWithVersion(fenceBlobName(primaryTerm));  
                    String.format(
 * fresh keys and never contend with the write-blocked source. A restore into a new index UUID starts fresh the same  
        // wasted retry when a higher term is also present, which is a price worth paying to keep "the sweep landed"
     * Resolves an ambiguous conditional write: did our own CAS land before the response was lost?  
    private final ShardId shardId;  
        try {  
     * As above, for writes that record a different allocation id than this instance's own - the ownership transfer of
    public synchronized boolean revertOwnership(long primaryTerm) throws IOException {
        String describeOwner() {
    }  
            }
     * upload. An unguarded re-adoption would take the chain back from an equal-term twin that legitimately claimed it  
        if (fenced || versionToken == null || primaryTerm != term) {  
        try {
            // containing the separator would silently produce a blob that parse() rejects, which would fence a
     * Parses the fence blob and validates that it describes this shard (invariant: one blob per shard): a fence blob for a different
 * when the writer cannot reach the cluster manager at all.</li>
        final long attemptedSeq = seq + 1;  
     * Validates that this shard copy still owns its term's acknowledgement path and advances the CAS chain. Must be
    private boolean adoptOwnWriteIfItLanded(long primaryTerm, long attemptedSeq, String recordedAllocationId) {
     * wrongly silences a healthy shard; asking "does a higher term exist?" separates them.
 * handoff. Everything else is enforced on the object-store side, which is the point: fencing has to keep working
import java.util.Locale;
        for (int attempt = 0; attempt < MAX_SAME_TERM_ATTEMPTS; attempt++) {
            // Our own path is gone, so a successor swept it: the same outcome as losing the CAS.
        this.logger = Loggers.getLogger(getClass(), shardId);  
        TranslogFencedException exception = new TranslogFencedException(
    }
        // destructive act is deleting strictly BELOW its own term" that the rest of the protocol leans on.
            }
                        Locale.ROOT,  
        try {
     * the chain, and taking it from that twin loses the twin's acknowledged writes:
                    throw new IllegalArgumentException("Fence field [" + field + "] must not contain [" + FIELD_SEPARATOR + "]");
 * {@code FenceTakeover.tla}.</li>
                CODEC_VERSION,
            }
        // precondition of completing a claim rather than a test on one branch of it. Checking it first can cost a  
     * acknowledged (invariant: the chain gates the ack, and the CAS follows the metadata). The ordering is what makes  
        fenced = true;
                ownerAllocationId,
 * can go stale, which lets a lower-term writer fence the rightful higher-term owner. See  
 * this file be licensed under the Apache-2.0 license or a
 * {@link TranslogFencedException} before the write is acknowledged. That covers both a stale primary after failover
 * alternative, a single shared blob escalating to an unconditional overwrite: the listing it takes before escalating
 * resolve ({@code RemoteStoreFence.tla} in {@code formal-models/} exhibits the trace with {@code SEQUENCED = FALSE}). One consequence  
                indexUUID,  
            // Ambiguous rather than failed: the conditional write may have landed with only the response lost. Our
                    primaryTerm  
     * <li><b>List.</b> A strictly higher term already owning a path means this copy has been superseded - refuse.</li>  
        } catch (BlobVersionConflictException e) {
            if (adoptOwnWriteIfItLanded(primaryTerm, attemptedSeq, targetAllocationId) == false) {
        }
    }
        if (primaryTerm != term) {  
public class RemoteStoreFence {
            // Cannot tell, so report the retryable answer rather than guessing.  
 * <p>
            // conclude the target took over. Resolve by identity: a blob recording the target at exactly the  
    private long highestTerm(long floor) throws IOException {  
        if (survivor.isPresent()) {  
     * <ol>
            FenceState remote = readRemoteState(current.content());
            // Ambiguous, exactly as on the ack path: the transfer may have landed with only the response lost. Left
     * deliberately independent of this instance's cached state. Used to gate operations that mutate shared remote state
                        twin.describeOwner()  
     * allocation id identifies the owning shard <i>copy</i> — the identity the cluster's in-sync set is expressed in —
     * <p>
     */
            // Arbitration takes an existing object over; it never creates one, so the path is not ours to withdraw.  
 * Object-store-backed primary fencing for a shard. Keeps one small mutable {@code fence__<term>} object per primary
                Locale.ROOT,
        // retryably: nothing has been acknowledged at this point.
     *
import org.apache.logging.log4j.Logger;
        this.ownerNodeId = Objects.requireNonNull(ownerNodeId, "fence owner node id");
                    "Fence write at term [{}] seq [{}] had landed; adopted its token after a lost response",
        if (remote.indexUUID.equals(shardId.getIndex().getUUID()) == false || remote.shardId != shardId.id()) {  
 * opaque <b>version token</b>; this class never interprets it. Presenting no token means "only if absent", which is
        String remoteDescription;
 * present the current token and hands back the next one, so the links cannot be skipped: <em>holding the current
 * <li><b>A higher term prevails, deterministically.</b> Every step of {@link #claim} is either uncontested by the
        if (higher > primaryTerm) {  
                    Long.parseLong(tokens[3]),  
     */
 * restore point the new copy read, and nothing it tries afterwards can be acknowledged. That is what covers a
    private void claim(long primaryTerm) throws IOException {
 * a fair race between the two.
            expectedToken
        versionToken = null;
        try {
        }  
    /**  
        // Invariant: seq strictly increases along a term's chain.  
 * loudly instead of letting two shards fence each other. The index UUID in the path isolates index lifecycle
            String[] tokens = new String(content, StandardCharsets.UTF_8).split("\\" + FIELD_SEPARATOR);
        for (String blobName : blobContainer.listBlobsByPrefix(FENCE_BLOB_PREFIX).keySet()) {  
            throw fencedException(null);  
     */  
                    "Fence blob belongs to a different shard: expected index uuid [%s] shard [%d] but found [%s][%d];"
        term = -1;
        // here rather than at the first CAS also stops a doomed copy hydrating segments and replaying a translog it  
    }  
     * <li><b>Create</b> our own {@code fence__<term>} with create-if-absent. A lower-term incumbent never writes this
 * incumbent, being a create-if-absent on a key only this term's owner writes, or unconditional, being a delete of
        }
 * operations. A resize target, whether shrink, split or clone, is a new index with its own UUID, so its shards claim
            throw new TranslogFencedException(
    // Guarded by synchronized methods. Uploads on the ack path are effectively serialized by the translog sync  
                fenced = true;  
    public synchronized void transferOwnershipTo(long primaryTerm, String targetAllocationId) throws IOException {
        }
            logger.warn("Could not determine whether the fence write at term [" + primaryTerm + "] landed", unresolved);
            }
     * A read, not a CAS: these paths need "stop touching shared state once superseded", not mutual exclusion, and a CAS
                    remote.shardId  
    private void arbitrateSameTerm(long primaryTerm) throws IOException {
        return RemoteStoreUtils.invertLong(blobName.substring(FENCE_BLOB_PREFIX.length()));  
        if (superseded.isEmpty() == false) {
     * Equal-term arbitration. A relocation source and its target legitimately share a term, so whichever CASes the
        // a further equal-term claimant may have taken it over since, and our token would be stale without us knowing.
        // claims happen on recovery, promotion and relocation rather than per operation. Detecting an equal-term twin
                throw new TranslogFencedException(
    /**  
        if (higher > primaryTerm) {
     * Prefix of the per-term acknowledgement-path objects. Deliberately neither a prefix of nor prefixed by
 * diagnostics. No authorization decision reads them, which is what lets a legitimate brand-new copy, such as one  
                return true;  
 * so it can acknowledge nothing that lands after the restore point the new copy read. A copy taking a primary
            fenceBlobName(primaryTerm),
    }
     * Settles a contest with an equal-term twin for an object that already exists. Never creates the object, so a path
            // healthy primary.
        return FENCE_BLOB_PREFIX + RemoteStoreUtils.invertLong(term);
     * here would contend with the acknowledgement path for the same chain and fence the shard against itself.
        // will never serve, and stops us withdrawing below a path that twin now owns.
     * source/target pair, or an in-place restore - which falls through to ordinary CAS arbitration.</li>  
                        "primary fenced by remote store: not the recorded owner of the acknowledgement path at term [%d]: owned by [%s]",
            try {
        } catch (BlobVersionConflictException e) {  
        return seq;
     * Fence blob content: {@code v1|<indexUUID>|<shardId>|<term>|<allocationId>|<nodeId>|<seq>} in UTF-8.
                // ArbitrateSameTerm does in FenceTakeover.tla, rather than recreating the object. Recreating would be
        return remote;
/*  
     *  
     * incumbent, whose next CAS then finds its object gone.</li>
    synchronized long getTerm() {
     * {@link #transferOwnershipTo}.
    private boolean adoptOwnWriteIfItLanded(long primaryTerm, long attemptedSeq) {
 * through {@link #validateAndAdvance}, so a second writer holds a stale token and its next CAS fails with a
            for (String field : new String[] { indexUUID, allocationId, nodeId }) {  
                Long.toString(term),
/**  
                    Locale.ROOT,
import java.util.Optional;  
        byte[] toBytes() {
    /** The terms that currently own an acknowledgement path for this shard. */
                // This copy is not the recorded owner, so the chain is not its to take. For a relocation target the
    private void cas(long primaryTerm, String expectedToken, long nextSeq) throws IOException {
     * copy has been superseded.
 * <p>
            // was never granted.  
        FenceState(String indexUUID, int shardId, long term, String allocationId, String nodeId, long seq) {
            }
                this.seq = attemptedSeq;  
        } catch (Exception unresolved) {
                Locale.ROOT,
                    tokens[1],
        BlobContainer blobContainer,
            );
                    remote.indexUUID,
    private static final int MAX_SAME_TERM_ATTEMPTS = 2;  
        // failures in its response body rather than throwing, and the shared blob-store helper logs them and returns
                    Locale.ROOT,  
                    primaryTerm,
 * <li>A <b>CAS</b> - compare-and-swap - is a write the store accepts only if the object's current version is the one
        } catch (BlobVersionConflictException e) {
import org.opensearch.index.remote.RemoteStoreUtils;
            created
        // commented "whether this copy CREATED its own path (so whether it may withdraw it)".  
        Set<Long> terms = new HashSet<>();
            cas(primaryTerm, versionToken, attemptedSeq, targetAllocationId);  
     */  
    private Set<Long> listTerms() throws IOException {  
            this.nodeId = nodeId;  
            // A fence instance belongs to one shard copy at one term - a term change means a new engine, and so a new
        if (versionToken == null || primaryTerm != term) {  
        }
import java.io.IOException;
 * issued only after the upload's metadata is visible. {@code TranslogTransferManager#transferSnapshot} runs the  
import org.opensearch.common.blobstore.VersionedBlob;
            // Ambiguous: the revert may have landed with only the response lost. If it did, adopt its token so this
            this.shardId = shardId;  
        }
 * has to be synced back to it. The fence borrows just two properties from cluster coordination. First, primary terms  
import java.util.ArrayList;
                if (field.contains(FIELD_SEPARATOR)) {
                "primary fenced by remote store: fence owned by another writer [%s], local allocation [%s] node [%s] term [%d]",
            }
                )
        return terms;
                }  
            if (termOf(blobName) < primaryTerm) {
     * incumbent's path whose recorded owner it can never match.
        }
 * <li><b>The term never regresses.</b> {@link #claim} refuses a claimant below the highest term that owns an
                "Fence ownership at term [{}] is no longer ours - the target took it up, or a higher term swept it; standing down",
                cas(primaryTerm, blob.versionToken(), remote.seq + 1);  
            FenceState remote = readRemoteState(blob.content());  
            throw new IOException(
    public static final String FENCE_BLOB_PREFIX = "fence__";
     * Reclaims ownership after an aborted relocation handoff, using the token produced by
 */  
            cas(primaryTerm, versionToken, attemptedSeq, ownerAllocationId);
    static final class FenceState {  
                );
     * ({@link #transferOwnershipTo}). Claiming blindly is what fences a healthy source whose handoff later aborts.</li>
 * <li><b>Fenced is terminal.</b> An instance whose path was taken over or deleted never acknowledges again. Only a  
     * Only the seal instance itself arbitrates unguarded ({@code false}): a brand-new legitimate incarnation - a
 * how a path is first created.</li>
     * legitimate. Anything else - a different writer, a different seq, an unreadable or missing object - is reported as
 * {@code RemoteFsTranslog#sealFence}), and that ordering is what closes the acked-write-loss window on failover. A  
            exception.addSuppressed(cause);
 * </ul>
     * (term, seq, recorded allocation id, node id) tuple still identifies the write uniquely.  
    }
                Integer.toString(shardId),
                    tokens[4],
                String.format(
        // Local state is released either way: this instance is fenced and must never acknowledge again.  
     * Hands ownership of this term's acknowledgement path to {@code targetAllocationId}, as the final act of a primary
                    tokens[5],
        final String indexUUID;
    private static long termOf(String blobName) {
        }
     * restore point is read with no live token held, and the translog instance re-adopts the chain on its first
            "Fence claimed: term [{}] allocation [{}] node [{}] created [{}]",
                // is reassigned at a higher term and claims cleanly then - while putting a create-if-absent on a path
     * Bound on equal-term arbitration attempts. Only equal-term claimants (a relocation source and its target, or an
        }
            );
            remoteDescription = String.format(
    private void cas(long primaryTerm, String expectedToken, long nextSeq, String recordedAllocationId) throws IOException {
 * content records the shard identity, checked on every read ({@link #readRemoteState}), so a path collision fails  
        logger.info(  
     */
     * A writer's only destructive act is deleting objects strictly below its own term, so it can never touch a  
        } catch (Exception e) {
    /** The highest term owning an acknowledgement path, or {@code floor} when none is above it. */
        return highestTerm(primaryTerm) > primaryTerm;
                fenced = true;  
 * later, when the metadata is already visible. Run concurrently instead, the CAS can win before the sweep while
     * a relocation handoff records the target's. The node id stays ours on every write this instance issues, so the
        }
 * below its own term, so it can never touch a higher-term writer's path. Model checking refuted the obvious
        this.blobContainer = blobContainer;
                throw e;  
     * <p>
                )
            // wrote it. Not treating this as terminal is what keeps the error retryable.
                    String.format(
            String.format(  
     * won this way is never ours to withdraw - see {@link #withdraw}.
     * responsibility, not the fence's.
                throw new IOException("Unrecognized fence blob content");  
        }  
 * <li><b>One object per term, keyed by index UUID.</b> Every writer at a given term resolves the same key, and the
                throw new IOException("Unrecognized fence blob content", e);  
                );
                    )  
    /**  
        if (cause != null) {  
            return String.join(  
 * the one place it can compare them. So the cluster manager authorizes a takeover without doing any I/O itself.
                FenceState twin = readRemoteState(current.content());
    }  
 * <b>CAS, and the CAS chain.</b> Defined here because the rest of this class, and the TLA+ specifications under
            if (remote.seq == attemptedSeq  
        long higher = highestTerm(primaryTerm);
            return;
import java.util.Set;
    }
            ownerNodeId,
 * <li>The <b>CAS chain</b> is the succession of tokens one fence object passes through. A successful write must  
    private boolean fenced;
 * those up is a follow-up.  
     * interpret.
        Set<Long> remaining = listTerms();
 * new shard incarnation, with a new instance, may claim again.</li>
    }
                && ownerNodeId.equals(remote.nodeId)) {  
 * acknowledged only once both have succeeded. The ordering is load-bearing: a successful CAS then proves this
        return term;
     * the token retained from the previous write.
     * key, so it cannot defeat the create. A conflict means an equal-term writer already owns it - a relocation
     * <p>
                    primaryTerm,  
 * <b>Invariants.</b> Referenced by name from the code that enforces them:  
                remote.term,
                this.versionToken = current.versionToken();
                    survivor.get(),
                    Long.parseLong(tokens[6])  
            // attempted seq, written from this node, can only be this transfer.
                "term [%d] owner [%s] seq [%d]",  
 * acknowledgement path. An equal term may still claim, because relocation and in-place snapshot restore are both
            cas(primaryTerm, versionToken, attemptedSeq);
                throw e;
     * </ol>
            if (adoptOwnWriteIfItLanded(primaryTerm, attemptedSeq, ownerAllocationId) == false) {
    public RemoteStoreFence(  
        if (fenced) {  
     * {@code TranslogTransferMetadata.METADATA_PREFIX}, so metadata listings, restore lineage and GC never see these.
                    "Fence sweep left the acknowledgement path for superseded term [%d] in place while claiming term [%d]; retry",
 * The fence blob sits on the <b>control flow</b>: it carries decisions about who may write, and never any shard
                term  
        }
            }
 * this true by taking the max of the snapshot's term and the current metadata's. Second, the routing table admits at
                String.format(
     * The distinction matters. A copy can legitimately hold a fence instance that is BEHIND the fence object - engine
     * @param primaryTerm the primary term this upload is being performed at  
                    Locale.ROOT,  
                );  
    }  
        }
 * check gates. Neither reads the fence, so snapshot restore, pinned-timestamp resolution and GC never touch it, and
            logger.info("Fence removed superseded acknowledgement paths {} on claiming term [{}]", superseded, primaryTerm);
     * The acknowledgement-path object for {@code term}. The term is inverted so that a plain prefix listing returns the  
     * as its owner. Two kinds of instance require it, for the same reason - an equal-term twin may legitimately hold  
        }
 * relocation handoff does not seal, because its source is still serving legitimately at the same term. Sharing a  
import java.util.List;  
                logger.info(
                return; // taken over, not created: never ours to withdraw
     * enforced entirely by the CAS chain.
        cas(primaryTerm, expectedToken, nextSeq, ownerAllocationId);
            throw fencedException(e);  
        this.shardId = shardId;
            ).getBytes(StandardCharsets.UTF_8);  
        logger.info("Fence ownership reclaimed at term [{}] after an aborted relocation handoff", primaryTerm);
    /**
        this.requireRecordedOwnership = requireRecordedOwnership;
        final int shardId;
 * <li><b>No cluster-manager synchronization.</b> The cluster manager neither reads nor writes the fence, and nothing
            }  
                        remote.describeOwner()
        }
                        Locale.ROOT,
     * term, allocation id and node id along with its seq, so a blob carrying ours at exactly the seq we attempted can  
 * every snapshot-referenced file stays immutable under an unchanged name.  
 * precondition on the write: S3 {@code If-Match}, GCS generation preconditions, Azure ETags. The version itself is an  
    private TranslogFencedException fencedException(Exception cause) {  
            this.term = term;
     * The index UUID and shard id make the blob self-describing and are validated on every read (one blob per shard). The
            VersionedBlob current = blobContainer.readBlobWithVersion(fenceBlobName(primaryTerm));
    }
 * ({@link BlobContainer#writeBlobConditionally}). The term is inverted in the name, so a prefix listing returns the  
        // Delete only an object this copy created. Winning one from an equal-term twin does not make it ours to remove:
            throw new TranslogFencedException(  
    private final String ownerNodeId;
    }  
        try {  
            this.seq = seq;
                return new FenceState(  
     */
                // would serve from a restore point read before the twin's acknowledgements, losing them
            VersionedBlob blob;  
 * </ul>  
     * Claims the acknowledgement path for {@code primaryTerm}, deterministically with respect to the incumbent.
     * guaranteed rather than probabilistic:
        boolean requireRecordedOwnership
     * take-over in {@link #arbitrateSameTerm} is refused unless the object already records this copy's allocation id
        }
                String.format(  
     * <p>  
                )
                // a successor may just have swept, which the spec does not sanction.
                    term,  
                    higher
            // higher-term successor, so this instance can never acknowledge again. Re-read to report who superseded us.
            throw fencedException(e);
        }  
                    Integer.parseInt(tokens[2]),
 * <li><b>The owner is advisory.</b> The allocation id and node id are recorded for the audit trail and for
    private static final String FIELD_SEPARATOR = "|";  
                    )
     */
 * <p>
        higher = remaining.stream().max(Long::compareTo).orElse(primaryTerm);
        }
                primaryTerm  
 * <li><b>Seal before restore.</b> Every writer transition claims the chain before it reads the translog restore
 * <li><b>Seq strictly increases along a term's chain</b> (asserted in {@link #cas}).</li>
    /**
 * SPDX-License-Identifier: Apache-2.0
    public static String fenceBlobName(long term) {
                        "primary fenced by remote store: the acknowledgement path for term [%d] was taken over mid-claim by [%s]",
            throw new IOException(
                throw e;  
 * token is what it means to own the object</em>, and a writer that misses one link can never rejoin the chain. That
     * consequence of holding a stale token: a fenced instance asked to act at a <i>different</i> term must not be able
    /**  
        final long term;  
    // permits, but the fence must never issue two CAS calls with the same token.
            new ByteArrayInputStream(content),  
        }
 * compatible open source license.
                Long.toString(seq)
        String newToken = blobContainer.writeBlobConditionally(
            cas(primaryTerm, null, 0);  
    ) {  
 *
 * means — the <b>translog flow</b>, which the CAS gates directly, and the <b>segment flow</b>, which an ownership
            // caller treats a failed revert conservatively, and the next upload settles ownership either way.  
 * @opensearch.internal
                    term  
 * <li><b>The chain gates the ack.</b> An upload is acknowledged only if its fence CAS succeeded, and the CAS is
     * in-place restore) contend for an existing object, and losing repeatedly to an equal-term writer is a legitimate  
                String.format(
                    attemptedSeq
            }  
            );
                    Locale.ROOT,  
    /** Unconditional deletes - the act that fences a lower-term incumbent. */  
     * </ul>
 * the caller presents, and <em>refuses</em> otherwise rather than applying it. Object stores expose this as a
 * term in the translog repository, written only by compare-and-swap
    }  
 * <p>  
     * <li><b>Delete every lower-term object.</b> Unconditional, so it always succeeds: this is the act that fences the
                        primaryTerm,  
    private long seq = -1;
                // translog instance an equal-term twin claimed the chain after this copy's seal - and taking it back
    /**
    private FenceState readRemoteState(byte[] content) throws IOException {
                && recordedAllocationId.equals(remote.allocationId)
            FenceState remote = readRemoteState(blobContainer.readBlobWithVersion(fenceBlobName(highest)).content());  
        }  
            // so withdrawing is a courtesy that saves that successor a retry, never a requirement.  
    /**  
            long highest = highestTerm(0);
     * token this produces is retained, which is what makes {@link #revertOwnership} able to distinguish a target that
        if (fenced) {
     */  
                        primaryTerm
     */
    private void deleteTermsBelow(long primaryTerm) throws IOException {
 * exception is a same-term relocation handoff. This holds on every takeover path: failover promotion, store and
            logger.info(
        try {
                    )
    private final Logger logger;
 * writer's object still existed, so a takeover's sweep - and the restore-point read behind it - can only come  
    synchronized long getSeq() {  
                    shardId.id(),
            fenced = true;
            this.indexUUID = indexUUID;
        throw fencedException(null);  
import java.util.HashSet;
import java.util.Objects;
    public synchronized void validateAndAdvance(long primaryTerm) throws IOException {
                // reachable legitimately only when the twin genuinely withdrew, and it buys nothing there - this copy  
        // success - so a "successful" sweep can leave a lower-term path standing. That copy still holds a valid token
        );
        return listTerms().stream().max(Long::compareTo).filter(t -> t > floor).orElse(floor);
     * <p>  
 * The fencing token is therefore this chain, not the primary term. Every acknowledged translog upload advances it  
 * <li><b>One writer at a time.</b> Any successful fence write invalidates every other holder's token. The
    /**  
                    Locale.ROOT,
                this.term = primaryTerm;
    }
                        "primary fenced by remote store: the acknowledgement path for term [%d] no longer exists to arbitrate for",
     * <li><b>List again.</b> A grant issued during our window supersedes ours: withdraw our own object and refuse, so  
    /** Withdraw our own acknowledgement path, so a superseded claim leaves nothing behind. */
    /**  
     */
            }
            return false;
        } catch (BlobVersionConflictException e) {
     * restore-point read behind it - can only come later, when this upload's metadata has already landed. The
                allocationId,  
    /**
 * and a zombie relocation source. On top of that, a successor deletes the superseded writer's object, and it is the  
            claim(primaryTerm);  
     */  
        seq = -1;  
     * instance is stale, not superseded. Asking "do I still hold my own object?" answers false for both cases and
            if (adoptOwnWriteIfItLanded(primaryTerm, attemptedSeq) == false) {
        assert primaryTerm != term || nextSeq > seq : "fence seq must advance: [" + seq + "] -> [" + nextSeq + "]";
            throw new TranslogFencedException(
        } catch (IOException e) {  
 * the metadata is still in flight, and an acknowledged operation lands in a metadata file no recovery will ever
        );  
import org.opensearch.common.logging.Loggers;
 * way, and a partitioned writer of the incarnation being replaced can only touch keys nothing will read again.</li>
     *         effectively completed and this copy must stand down. Standing down is not a fencing error.  
            );
            );
            content.length,
     * @return {@code true} when ownership was reclaimed, meaning the target never wrote and so never took over - this
     */
            if (versionToken.equals(current.versionToken()) == false) {
                && remote.term == primaryTerm
                        + " two shards resolved the same fence path",
            // copy resumes with the current chain rather than a stale one; if it cannot be resolved, rethrow - the
            // Index UUIDs, allocation ids and node ids are base64 UUIDs today, so this cannot fire; encoding a field  
                // Best effort: a successor deletes every lower-term path anyway, so a leftover is transient.
                );
        }  
 *
        this.versionToken = newToken;
        if (createdByThisCopy) {
     * winning a race - model-checked in {@code FenceTakeover.tla}.
    /**
 * legitimate equal-term takeovers; {@link #arbitrateSameTerm} settles those by CAS instead of by term.</li>  
     */  
            withdraw(primaryTerm, created);
            } catch (NoSuchFileException e) {  
 * term means sharing an object, so ordering between those two is the handoff protocol's job, not the fence's.
        deleteTermsBelow(primaryTerm);
     * Set for every fence instance whose arbitration must be authorized by RECORDED OWNERSHIP: the equal-term
}
        return exception;  
    // Visible for testing
 * remote-store recovery, and snapshot restore, including snapshot V2, where the restore point is downloaded when the
 * highest term first. That ordering matters because an object store cannot interpret primary terms, and the name is
            terms.add(termOf(blobName));  
        } catch (IOException e) {  
     * <li>A primary relocation target shares a term - and therefore an object - with a source that is still  
 * <ul>  
            );
        ShardId shardId,
                String.format(Locale.ROOT, "primary fenced by remote store: term [%d] superseded by term [%d]", primaryTerm, higher)  
                );
            }
        final long seq;  
            // Withdraw only a path this copy CREATED - see withdraw(). Either way the higher term's sweep removes it,
     * to claim that term's path, since it was never granted it - doing so would let it delete its own successor's
        final String nodeId;
            }  
     * Whether a strictly higher primary term now owns an acknowledgement path for this shard - that is, whether this
    }  
    private void withdraw(long primaryTerm, boolean createdByThisCopy) {  
 * translog is built. Once the previous writer's token is invalid, everything it acknowledged is already in the  
        return true;  
    private long term = -1;  
            try {
     * shared object last owns it and the other fails its next upload. Same-term ordering is the handoff protocol's  
        // and would keep acknowledging, so proceeding would put two terms on the write path at once. Refuse instead,  
        return adoptOwnWriteIfItLanded(primaryTerm, attemptedSeq, ownerAllocationId);  
                throw new TranslogFencedException(
            throw new TranslogFencedException(
     * took over from one that never wrote - the ambiguity the source and target cannot resolve between themselves.  
        final long attemptedSeq = seq + 1;
                logger.warn("Failed to withdraw the fence for superseded term [" + primaryTerm + "]", e);  
    // Visible for testing  
    private final boolean requireRecordedOwnership;  
    }
            fenced = true;
        String ownerAllocationId,
 * CAS after the metadata upload and before it acknowledges.</li>
    public boolean isSuperseded(long primaryTerm) throws IOException {
     * <li>An ordinary copy's translog instance performs the second of the two claims a takeover makes: the recovery seal  
        // FenceTakeover.tla draws the same distinction: VerifyClaim withdraws only IF wCreated, and the variable is
            // being fenced - failing a healthy primary on a network blip. Resolve it by reading who the object says  
     * arbitration loss rather than a race worth outlasting.
    private final String ownerAllocationId;
                remote.seq  
 * previous primary that is still running but has dropped out of the cluster's view loses its object at that moment,
 * The CAS is issued only <b>after</b> the immutable translog metadata upload has completed, and the upload is
 * <ul>
            if (tokens.length != 7 || CODEC_VERSION.equals(tokens[0]) == false) {
     * a successful CAS a proof of visibility: the fence object still existed, so a takeover's sweep - and the
     */  
                    shardId.getIndex().getUUID(),  
                    String.format(  
                String.format(
     * resets during recovery replace the translog, and so the fence, several times in quick succession - and such an  
                    primaryTerm,
     * higher-term writer's acknowledgement path. Determinism therefore follows from the key space rather than from
import org.opensearch.core.index.shard.ShardId;  
            try {
            primaryTerm,
            throw fencedException(e);
     */  
    /**  
     * without being on the acknowledgement path: publishing segment metadata, and garbage collection on either plane.  
            } catch (IOException e) {
            // unresolved, this copy would keep a stale token, and an aborted handoff's revert would then wrongly
     * @throws IOException on repository errors
        // One listing, two checks. Both matter, and the second is not belt-and-braces: a batch delete reports per-key  
            throw fencedException(null);
    /**  
        } catch (IOException e) {  
    private final BlobContainer blobContainer;  
 * repository's conditional writes are what provide this, so {@code RemoteFsTranslog#buildFence} refuses a repository  
    public RemoteStoreFence(BlobContainer blobContainer, String ownerAllocationId, String ownerNodeId, ShardId shardId) {
     * first call claims the path for {@code primaryTerm} (see {@link #claim}); every later call advances the chain with  
     * <p>  
     * during that window - and then serve from a restore point read before the twin's acknowledgements, losing them.
 * delete rather than the CAS that makes a higher-term takeover certain instead of a race - a CAS alone would only be
     * failover promotion, a store recovery, an in-place snapshot restore - must be able to take over a dead  
            // token would then be stale, and the next attempt's If-Match would fail and be indistinguishable from
                remote.describeOwner(),
                logger.info("Fence equal-term arbitration conflict on attempt [{}], retrying", attempt + 1);  
        this.seq = nextSeq;  
     * Deliberately a POSITIVE test for supersession rather than a test that this copy still holds its own object, and
     * and the node id is recorded alongside it for operators; both are advisory, since exclusion is  
    }
        logger.info("Fence ownership handed to allocation [{}] at term [{}]", targetAllocationId, primaryTerm);  
                remoteDescription,  
            // fence. Seeing a different term here is unexpected, so fail closed rather than claim a term this instance
 * from a snapshot restore, take the chain.</li>
     * a stale grant is self-limiting rather than able to displace the rightful owner.</li>
     * <ul>
            arbitrateSameTerm(primaryTerm);
