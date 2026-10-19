         * in heap. Spilled chunks are streamed one-at-a-time from the file (the file handle lives in
        /**
            buffer.addData(side, data);  
                        + " — the consumer already snapshotted this partition, so the chunk would be lost. "
import org.opensearch.analytics.spi.ShuffleBufferRegistry;
        private final AtomicInteger leftDoneCount = new AtomicInteger();
        long now = System.nanoTime();
        // siblings too. Scoping to the same (queryId, stageId): buffers of a DIFFERENT (already-run)  
                    }  
                List<byte[]> combined = new ArrayList<>(spilled.size() + inMemory.size());  
        /** Lazily opens (and remembers) the per-side spill file's append stream. */
                // buffer that admitted data carries real currentBytes.
import org.opensearch.analytics.spi.CloseableIterator;
    }
        return buffer;
                releaseSpillBytes(bytes + (existing == null ? 0L : existing));  
            if (totalBytes.get() + size > nodeBudgetBytes) {  
            }  
                    // chunk would push past perQueryMaxBytes. Case (a) is accepted (resident bounded by  
            private boolean nextLoaded;
        // producer RPC racing after clearForQuery would otherwise leave an undrained buffer behind.  
            removed.deleteSpillFiles(); // returns on-disk bytes to the node spill budget (I/O, off-lock)
        // No lock needed for the ceiling check itself — admission already serializes via admitLock,
        }
     * (re-messaged {@link ShuffleBufferExceededException}). All counter mutations on the spill path
 * stores accepted chunks. On-heap budget enforcement is owned by the MANAGER, not the buffer:
import java.util.concurrent.TimeUnit;
        // non-null buffers.remove) releases its bytes — a second remove of the same key, or a
            if (removed != null) {
             * prefix. Closes the append stream first so all buffered bytes are flushed.
     * Removes a buffer that was created/returned by {@link #getOrCreateBuffer}'s {@code computeIfAbsent}
                removed = buffer;  
                throw new IllegalStateException(  
import java.util.concurrent.ConcurrentHashMap;  
         * ({@code int length} big-endian, then {@code length} bytes), appended in arrival order.
                } catch (IOException e) {
            }
     * @return the number of buffers removed (for logging / test assertions)  
        }  
 * ({@code opensearch-olap/.../transport/ShuffleManager.java}). OLAP keys by (queryId, stageId)
                    throw ShuffleBufferExceededException.forDiskCeiling(owner.getSpilledTotalBytes(), owner.spillMaxBytes);
        // concurrent clearForQuery that already swept it, sees null and releases nothing. This is
        for (Long expiry : aborted.values()) {  
        void deleteSpillFiles() {
            }
    }  
            return AdmitResult.ACCEPTED; // nothing to store/reserve (isLast markers carry no data)
                    public boolean hasNext() {  
        ShuffleBuffer removed = null;  
                }
    private void releaseLocked(String queryId, long bytes) {
             * Closes the append stream and deletes the spill file. Returns true if the file was deleted
            // owned by the iterator and closed on close() / at clean EOF.
     * without reserving and {@code getOrCreateBuffer} hands back a NON-stored throwaway buffer.
            if (bytes > 0) {
     * Default disabled ({@code Long.MAX_VALUE}) until wired from settings at plugin startup.
    public long getQueryBytes(String queryId) {  
        if (removed != null) {
         * Returns the side's chunks in ARRIVAL order. With no spill, the in-memory list is returned
 * compatible open source license.
                    } catch (EOFException eof) {  
                }
    public AdmitResult tryAdmit(String queryId, int targetStageId, int partitionIndex, String side, byte[] data) {
        }  
import org.opensearch.analytics.spi.ShuffleBufferExceededException;  
                    Files.deleteIfExists(path);
    }
                return AdmitResult.ACCEPTED;  
         * (drain/cleanup), so the per-side fields need no further synchronization.
    /** Node-wide bytes currently written to spill files across all buffers (for observability/tests). */
        // first (a senderDone/isLast RPC can land before the first data chunk). newBuffer only
     * target side to a per-(query,stage,partition,side) spill file under {@link #spillDir} instead of
        Path dir = spillDir;
        // stage are deliberately NOT touched — one could be draining. (round-3 BLOCKER #1.)
         * touches any list/file, so {@code spillToMakeRoom} — which also runs under {@code admitLock} —  
 * SPDX-License-Identifier: Apache-2.0
            rejectedCount.incrementAndGet();
     * with {@code admitLock} held — releases are serialized with admission and with each other so the  
        // exactly what we reserved. Safe. (The locked sweep — not the tombstone — is what reclaims
    }  
    public int liveTombstoneCount() {  
                    list.remove(0);
            } else {
                        + "This indicates a producer shipped data after its isLast (a close-ordering bug)."
                        return c;
                }
     * </ul>
            /** Appends one length-prefixed chunk and flushes so it is durably readable at drain. */
        }
        if (queryId == null) {
         * spill identity via {@link #enableSpill}. {@link #leftSpill} / {@link #rightSpill} are the
        // Double-check AFTER inserting: the tombstone-then-check above is not atomic with the
        // can recreate the on-disk state for this (now tombstoned) query.
        int removed = 0;
            if (qProjected > perQueryMaxBytes) {
    /**
         * appended — reconstructing the full arrival sequence. Drain happens once per partition after
            }
     * on-disk total can't silently grow past the ceiling.
     *       ({@link #perQueryBytes}). A query whose own shuffle exceeds this can never fit even on an
        if (size == 0) {  
     * throwing — so the on-heap footprint stays bounded by the budget while the rest lives on disk.  
                // sweep's own remove() saw no entry, so we own the release. Drop the map entry.
        if (queryId == null) {
        }
        orphanedSpillBytes.compute(path, (p, existing) -> {
                return bytesOnDisk;  
                    rightSpill = new SpilledSide(spillFilePath("right"));
            /**  
         * Wires this buffer's spill identity (lazy — no file is opened here). Once set, a per-query
         * file back in write order, then the in-memory tail, reconstructs ARRIVAL order at drain.
         * evicted; returns the bytes actually evicted (may be less than {@code targetBytes} if the  
                    buffer.recordRejected();
            rightSpill = closeAndDelete(rightSpill);  
     * bytes across ALL queries; {@code perQueryMax} caps any single query's footprint (a query
                    }
                if (!tail.hasNext()) {  
            private final Path path;
                    // nothing else resident (can't split), or (b) the footprint is held by same-stage
                this.expectedLeftSenders = leftSenders;
        private final AtomicLong currentBytes = new AtomicLong();
         * through the consumer's bounded native channel rather than re-materializing and OOMing.
                Map.Entry<String, ShuffleBuffer> entry = it.next();
         */
                    swept.add(entry.getValue());
 * over-provisioned {@code plugins.analytics.shuffle_partitions}), so partitionIndex must be part
        this.spillEnabled = enabled;  
        if (spillEnabled && spillDir != null) {
     * under the same lock, so the byte accounting stays consistent (no admit/release interleaving can  
            return false;  
                buffer.recordRejected();
     * have returned a PRE-EXISTING buffer that already admitted data and SPILLED; a lock-free
    private final AtomicLong totalBytes = new AtomicLong();
     * {@code Files.exists} check runs INSIDE the atomic {@code compute}, so if the sweep already removed
                this.path = path;
 * {@link #setBudgets}). The consumer calls {@link ShuffleBuffer#awaitReady} before draining.  
                    // Hard: this query alone can't fit — waiting never helps. Fail fast, non-retryable.
     *   <li>returns {@link AdmitResult#ACCEPTED} otherwise (reserved + stored).</li>  
            b.deleteSpillFiles();
         * is buffered and flushed per chunk so a crash-free terminal can always read back the file.
    public void setBudgets(long nodeBudget, long perQueryMax) {
            private final Iterator<byte[]> tail;
     * in deleting an orphaned path, it releases exactly those bytes (once) — otherwise a transient
     *  hot path. An expired tombstone (cleared > TTL ago, so no late RPC can still be in flight) reads
            private byte[] nextChunk;            // one-chunk lookahead from the file  
                try {  
                    // the largest single chunk). Case (b) is caught by the node-budget check just below:
    }
                try {
                if (len > 0) {
        // else a bare buffer created here would silently disable spill for that partition.
                    // on the same path: whichever runs first removes the entry + releases; the other sees  
    /** True when disk spill is enabled (for observability/tests). */
                    // Spilled phase exhausted — release the file handle and fall through to the tail.  
        // 0-byte buffer created here never touches disk. This must match tryAdmit's creation path,
                    combined.addAll(inMemory);
                rightData.add(data);
import java.io.DataInputStream;
                        + key(queryId, targetStageId, partitionIndex)
    /**
            ShuffleBuffer sibling = e.getValue();
         * its append stream, dropping/duplicating rows or NPEing in {@code SpilledSide.append}.  
         * bytes to the manager's node-wide spill budget. Best-effort, idempotent; called on every
            }  
            if (spill == null) {
                checkCompletion("left");
         * Closing it releases the spill-file stream; it is also closed automatically at clean EOF of
             * or never existed (disk reclaimed); false if deletion failed and the file still occupies
            // Reverse order so children are deleted before their parent directory.
                    // ceiling for later queries. Release the reserved-but-unwritten bytes here.
            }
        }
                combined.addAll(spilled);
                if (leftSpill == null) {
        // Delete spill files for every swept buffer + the per-query spill subdir, OUTSIDE admitLock.
    private static final Logger LOGGER = LogManager.getLogger(ShuffleBufferManager.class);  
        void enableSpill(ShuffleBufferManager owner, Path spillRoot, String queryId, int stageId, int partition) {  
        private final AtomicInteger rightDoneCount = new AtomicInteger();  
    /** Outcome of {@link #tryAdmit}. */  
                    nextLoaded = false;
            long bytesOnDisk() {
         * Stores {@code data} on the named side and tracks this buffer's byte total. Admission /
     */
            }  
            } else {  
     * Each {@link ShuffleBuffer} holds the query's shuffled payload as on-heap {@code byte[]} lists;  
            return leftDoneCount.get();
                }
            q.addAndGet(size);  
        return spilledTotalBytes.get();  
                List<byte[]> chunks = new ArrayList<>();  
            return false;  
                    try {
     * (live tombstones ≈ clear-rate × TTL) and needs no separate ordering structure or lock — the  
     * {@code maxBytes} is the hard node-wide disk ceiling (exceeding it fails the query). When
    /** Bytes currently reserved for {@code queryId} (0 if no reservation / fully released). For
    }
        // later releases only what's still resident (no double-release). (A receiving buffer that is
         * the returned iterator and is released on {@link CloseableIterator#close()}), then the
    // Admission (check-then-reserve) is serialized so concurrent producers can't both pass the
                n++;
    public boolean isSpillEnabled() {  
                try {
        private void beginDrain() {
            q.accumulateAndGet(bytes, (cur, b) -> Math.max(0, cur - b));  
        return q == null ? 0L : q.get();
                if (!Files.exists(path)) {
            if (!leftReady.await(remaining, TimeUnit.MILLISECONDS)) {
         * <p>Called under the manager's {@code admitLock}; the manager releases the returned bytes
                synchronized (inMemory) {
                bytesOnDisk += len + SPILL_FRAME_HEADER_BYTES;
     * enabled, hands it the spill identity (root dir + key components) so it can lazily open per-side
                    public void close() {}
        for (ShuffleBuffer b : swept) {  
     * second keeps getting {@link AdmitResult#REJECT_RETRY} and, if its peer doesn't drain within the
            beginDrain();
}
    private static final int SPILL_FRAME_HEADER_BYTES = Integer.BYTES;  
         * Deletes both sides' spill files (closing their streams first) and returns their on-disk  
                out.write(len & 0xFF);  
     * Spill files whose buffer-level {@code deleteSpillFiles} FAILED to delete (disk/IO error): their  
        synchronized (admitLock) {
        // and spilledTotalBytes is only ever incremented here (under admitLock) and decremented in
        @Override
 * this file be licensed under the Apache-2.0 license or a
        }
        // after the clear (abort/cancel) — short-circuits in tryAdmit/getOrCreateBuffer and never
         * this buffer (the sibling-spill loop skips {@code draining} buffers). Called at the head of  
     * (the prior design) is unsafe: under a high query rate, N other clears can evict a still-in  
     * Disk-spill configuration (default OFF). When {@link #spillEnabled} is true and a chunk would  
        long projected = spilledTotalBytes.get() + size;
                int len = chunk == null ? 0 : chunk.length;  
                        byte[] chunk = new byte[len];  
         * from the budget counters (and this buffer's {@link #currentBytes}) under the same lock. A
            DataInputStream openForRead() throws IOException {
        private static final class SpilledSide {
                    return true;  
        // drop/duplicate rows or NPE in SpilledSide.append. `draining` is flipped under admitLock  
                    }
                checkCompletion("right");  
     * while the counter stays under the ceiling. The on-HEAP eviction target tracks only payload bytes  
     */
            if (Files.exists(p) == false) {  
                    LOGGER.debug(new ParameterizedMessage("Failed to delete shuffle spill file {}", path), e);
                return AdmitResult.REJECT_RETRY;  
                    long freed = spillToMakeRoom(buffer, queryId, targetStageId, side, bytesToFree);
        }  
            }  
    }
                    byte[] c = nextChunk;  
                    throw new NoSuchElementException();
             * Reads every spilled chunk back, in write (= arrival) order, deframing on the length
        // Collect swept buffers so their spill files can be deleted OUTSIDE admitLock (file I/O).  
            // Release the disk-budget reservation ONLY if the file was actually removed (or was never
                closeOut();
        long freed = buffer.spillOldest(side, targetBytes);  
            LOGGER.debug("Cleared {} shuffle buffer(s) for query {} (freed budget)", removed, queryId);
    private long spillToMakeRoom(ShuffleBuffer buffer, String queryId, int targetStageId, String side, long targetBytes) {  
    public ShuffleBuffer getOrCreateBuffer(String queryId, int targetStageId, int partitionIndex) {
                this.tail = tail.iterator();
     *
     * capacity in lockstep, just failing oversized queries earlier) — the remediation is to serialize
                releaseLocked(queryId, removed.getCurrentBytes());  
                    removed++;  
     *   <li>returns {@link AdmitResult#REJECT_RETRY} if the NODE total would exceed  
                    }
            // Snapshot the in-memory tail once (drain is single-threaded post awaitReady, but addData
     */  
     */
            final List<byte[]> tail;  
            // written). If deletion fails (disk/IO error) the bytes still occupy disk, so dropping the  
        }
        if (!buffer.isDraining()) {  
        public boolean awaitReady(long timeoutMillis) throws InterruptedException {
            }
    public void removeBuffer(String queryId, int targetStageId, int partitionIndex) {
                }  
                this.expectedRightSenders = rightSenders;
        }  
     * {@code clearForQuery}.
        public int getExpectedLeftSenders() {
                this.spillPath = spill.path();
     * -window tombstone within the 15s producer window, re-opening the recreate-and-leak race (codex
        // MISS the not-yet-visible put is still caught by the sweep (which can only enter admitLock
                    });
     * {@code deleteSpillFiles}), so {@link #spilledTotalBytes} would stay permanently inflated → a false
        for (var it = aborted.entrySet().iterator(); it.hasNext();) {
        return spillEnabled;
                if (out != null) {
     * <ul>
                    orphanedSpillBytes.compute(p, (path, orphanBytes) -> {
        ShuffleBuffer removed;
                }
        this.spillDir = directory;
                    try {
                }
            } else {  
        private final List<byte[]> rightData = Collections.synchronizedList(new ArrayList<>());
     * bytes from this buffer's own {@code currentBytes}. Returns the bytes freed from THIS buffer. Both
                return tail.hasNext();  
                }
    }
     * without this the entries live for the JVM's lifetime and accumulate across queries → on-heap
                return rightSpill;  
import org.apache.logging.log4j.Logger;
                // Soft: node is momentarily full but this query fits its share — retry later.
     * RTTs ≈ 15s worst case). {@link #TOMBSTONE_TTL_NANOS} (120s) is an ~8× margin over that, so the
        if (bytes <= 0) {  
            List<byte[]> readBack() throws IOException {
                    return true;
            return null;
                aborted.remove(e.getKey(), e.getValue());
        // the isLast/senderDone case — it creates a 0-byte buffer and reserves no budget.)
     */
        if (q != null) {
            } else {  
                    // (codex review BLOCKER: reserved-but-not-written disk-byte leak.)
            long qProjected = q.get() + size;  
                checkCompletion("left");
    /**
        public void recordRejected() {  
     * {@link #spilledTotalBytes} bytes stay charged (the file still occupies disk), and the owning
     * The consumer drains spilled chunks back (in arrival order) then the in-memory tail, preserving
     */
         */  
            // -1 means "leave unchanged"; allows per-side handlers to set their own count
            walk.sorted(Collections.reverseOrder()).forEach(p -> {  
        private volatile boolean draining;  
        private final AtomicLong rejectedCount = new AtomicLong();  
    /**  
                }  
        // attaches the spill identity (lazy — no file is opened until spillOldest fires), so a  
                    // buffer to disk to make room for the incoming chunk, then store it. Spilling
        private SpilledSide closeAndDelete(SpilledSide spill) {  
            Map.Entry<String, Long> e = it.next();
        // expiry - now > 0 (not now < expiry) to be robust to nanoTime wraparound.  
        AtomicLong q = perQueryBytes.get(queryId);
        public long getRejectedCount() {
        /**
        spilledTotalBytes.addAndGet(size);
        ShuffleBuffer buffer = buffers.computeIfAbsent(k, kk -> newBuffer(queryId, targetStageId, partitionIndex));  
     * are engine-generated UUID-like strings, but defensively strip anything that isn't an
                        + side  
            Path path() {  
            // Release the whole query's reserved footprint in one shot (drop its perQueryBytes entry  
         * Subtracts {@code bytes} from this buffer's resident byte counter after the manager has
                }
     * releases precisely what was reserved. The max(0,...) floor is purely defensive.
        return true;  
            return new ShuffleBuffer();
                    long bytesToFree = qProjected - perQueryMaxBytes;
                Iterator<byte[]> it = tail.iterator();  
    /** True if {@code queryId} has a live (non-expired) tombstone. Lock-free; safe on the producer
        }
            return currentBytes.get();
        } catch (IOException e) {  
             */  
     *       This is the q17 case (one side wants ~7.4GB).</li>  
import java.util.concurrent.CountDownLatch;
            if ("left".equals(side)) {
     * never spill.  
    private final Object admitLock = new Object();
                if (nextLoaded) {  
            if (isTombstoned(queryId)) {  
        synchronized (admitLock) {  
     * indefinitely. This is an accepted trade-off: the engine's validated workload runs heavy shuffle  
            });
     * alphanumeric, dash, underscore or dot so a hostile / odd id can't escape {@link #spillDir} via
                leftDoneCount.incrementAndGet();
     * <p>The shuffle consumer is buffer-all-then-drain, so a node's live shuffle byte[] is the SUM
import java.util.concurrent.atomic.AtomicLong;
     * ({@link #reserveSpillBytes}, {@code SpilledSide.bytesOnDisk}, release) must include this header,
     * prefix followed by its payload (see {@code SpilledSide.append}). The disk-budget accounting  
                    close();
            if ("left".equals(side)) {
     * deterministic unit test of the cleanup (the live branch only fires in a narrow concurrent window).  
 *
                    }  
import org.apache.logging.log4j.LogManager;
        // - If the put has linearized before our isTombstoned read: we see tombstoned, bail, reserve  
            }
            ShuffleBuffer buffer = buffers.computeIfAbsent(
            long deadline = System.currentTimeMillis() + timeoutMillis;
 * land in the same buffer and the join would read cross-partition rows + see false completion.
            }  
import java.util.Iterator;
        // sweeping, so any such late insert is guaranteed to observe the tombstone here — remove our
        }  
        // compose without double-subtracting (codex review: shuffle-budget-double-release).
            return new SpillThenTailIterator(spill, tail);  
            }
 */  
            LOGGER.debug(new ParameterizedMessage("Failed to walk shuffle spill dir {} for query {}", queryDir, queryId), e);
                synchronized (list) {
        }
                return false;  
            int size = data == null ? 0 : data.length;
        // nothing. Safe.
     * cover it) from {@code buffer} to its spill file until at least {@code targetBytes} have been  
                // Release resident bytes — normally 0 (this is the isLast path), but a pre-existing
            }
        /** Wait for both sides' senders to complete. Returns {@code false} on timeout. */  
     */
import java.nio.file.Files;
            // (codex review round-3 SHOULD-FIX.)
        if (dir == null || queryId == null) {  
        }
    /**
                    out = null;
    }
            return drainSide(leftSpill, leftData);  
         * Appends the oldest in-memory chunks of {@code side} (length-prefixed) to that side's spill
     * Removes every buffer belonging to {@code queryId} (all stages, all partitions on this node).
                } catch (IOException e) {
        private final List<byte[]> leftData = Collections.synchronizedList(new ArrayList<>());  
                    if (nextChunk != null) {
        buffer.releaseCurrentBytes(freed);
                        int len;  
    @Override  
            if (freed >= targetBytes) {
        if (freed < targetBytes) {
                // evicted tracks ON-HEAP bytes freed (the eviction target is the heap budget); the  
        synchronized (admitLock) {  
package org.opensearch.analytics.exec.shuffle;
                out.write((len >>> 16) & 0xFF);
            if ("left".equals(side)) {  
import java.util.Collections;
            // -running query won't be cleared because only this query's terminal hook calls clearForQuery.  
            if (rightSenders >= 0) {
    }  
     */
                        + " bytes) admitted to an already-draining buffer "  
        }  
import java.nio.file.Path;
     */  
        }
                currentBytes.accumulateAndGet(bytes, (cur, b) -> Math.max(0, cur - b));
            remaining = deadline - System.currentTimeMillis();
        /**  
            // used a synchronizedList, so honor its monitor for safe publication).
         * the spill file for read). Flipped under the manager's {@code admitLock} BEFORE the drain
        return removed;
                            releaseSpillBytes(orphanBytes);
            }
         * what is still resident — never the already-released spilled bytes (no double-release).
            }
                    // releases the evicted chunks' RESERVED bytes (totalBytes + perQueryBytes +
                LOGGER.warn("Shuffle left side timed out: received {}/{} senders", leftDoneCount.get(), expectedLeftSenders);
            this.spillKey = stageId + "-" + partition;  
    public long getPerQueryMaxBytes() {
     * spill ceiling for later queries. (codex review round-3 BLOCKER #2.) Package-private for a
    }  
        }
         * spilled (and budget-released) those bytes. Keeps {@link #currentBytes} equal to the
                        return it.next();  
     * Sanitizes {@code queryId} into a single safe path segment for the spill subdir name. Query ids  
         * the spilled phase. Reading past a corrupt/short frame surfaces an {@link UncheckedIOException}
     * and task cancellation — so the on-heap payload becomes collectible as soon as the query ends.  
                        chunks.add(chunk);
                    nextChunk = readNextChunk();
            }
                    // uses — perQueryBytes stays the single source of truth, no double-release. The
                Files.createDirectories(path.getParent());
                if (nextLoaded) {
                this.out = new BufferedOutputStream(Files.newOutputStream(path));
        // NOT under admitLock, then sweeps + releases UNDER admitLock):
 */  
                    // spillToMakeRoom already released each spilled buffer's own currentBytes; here we  
                    // sibling's removeBuffer frees its budget. Self-correcting, never over-commits heap
        return perQueryMaxBytes;
        // release the lock. clearForQuery's sweep can only ENTER admitLock after we exit, so it is  
                    int len = chunk == null ? 0 : chunk.length;
         * under the owner's {@code admitLock} (when an owner is wired) so the set is ordered against
                        break;
            private void closeOut() {
    /**
     * the buffer-all contract. {@link #spillMaxBytes} is the hard disk ceiling across all of this
     * stay under {@link #admitLock} (same accounting path as {@code releaseLocked}); the byte budget
        public void setExpectedSenders(int leftSenders, int rightSenders) {  
         */  
        // than growing unbounded. Cheap: a weakly-consistent iteration over a small concurrent map,
        try (var walk = Files.walk(queryDir)) {
         * its byte length to split the concatenation back apart on read.
        }
            // getOrCreateBuffer could have replaced the mapping; that thread then owns its buffer's  
                    if (c != null) {
            for (var it = buffers.entrySet().iterator(); it.hasNext();) {
            freed += spillBufferBothSides(sibling, side, targetBytes - freed);
                // frame header is disk-only, so it is intentionally excluded here.
            totalBytes.addAndGet(size);
                    }  
                }  
            return;
        if (freed >= targetBytes) {  
                if (spillEnabled) {
        }  
     *  observability + tests asserting per-query footprint cleanup, not just the node total. */
        // already draining — a retried/reordered admit landing post-drain — is skipped here too.)
/*  
 *  
            this.owner = owner;
                out.flush();
     * the file (its {@code remove(path)} returned null because we hadn't recorded yet), we release the  
        REJECT_RETRY
    private long spillBufferBothSides(ShuffleBuffer buffer, String side, long targetBytes) {
            spilledTotalBytes.accumulateAndGet(size, (cur, b) -> Math.max(0, cur - b));  
            leftSpill = closeAndDelete(leftSpill);
     *  
        }  
        // releaseSpillBytes (cleanup), so the read-modify-write is safe under the enclosing lock.  
        private static List<byte[]> drainSide(SpilledSide spill, List<byte[]> inMemory) {  
            boolean closeAndDelete() {
        public long getCurrentBytes() {
            long remaining = timeoutMillis;  
                // Snapshot the in-memory tail under its monitor — drain is single-threaded post
     * <p><b>Evicted by TTL, not count.</b> The protection a tombstone must provide is: outlive every
     * Admits {@code size} bytes for {@code (queryId,side)} against the node + per-query budgets, and  
     * best-effort. Called on every terminal from {@link #clearForQuery} after the per-buffer files
        /** Node over budget but this query still fits its share — producer should back off + retry. */
                    this.in = spill.openForRead();  // may be null if nothing was written
                }
                        + " side="
     * disabled, the per-query budget breach in {@link #tryAdmit} stays the fail-fast throw (behavior
        synchronized (admitLock) {
                );  
    @Override
     * Reserves {@code size} bytes of node-wide spill (disk) budget. Returns true if it fits under
            if (querySpillDir == null || targetBytes <= 0) {
                    nextChunk = null;
            return 0;
     * large shuffles. Splitting node vs per-query into independent settings (so a node can admit
     * </ul>
     * delete failure would permanently inflate {@code spilledTotalBytes} → a false {@code spill.max_bytes}
            freed += buffer.spillOldest(other, targetBytes - freed);  
     * <p><b>Known limitation — concurrent-contention starvation.</b> The plugin wires
     * late producer RPC for that query. A late RPC's lifetime is bounded by the sender retry window
        /** Accepted; counters reserved and the chunk stored. */
    @Override
        // - If the put has NOT yet linearized: we miss it, reserve + store under admitLock, then
     * (e.g. a throwaway path) can't leave an orphaned file behind. A no-op when spill is disabled or
    private volatile long spillMaxBytes = Long.MAX_VALUE;
                List<byte[]> spilled = spill.readBack();
                    // once. Use compute (not remove) so this is atomic vs a concurrent recordOrphanedSpill
                    SpilledSide spill = spillFor(side);  
        // this sweep could acquire the lock, so the sweep observes (and reclaims) every such buffer +
                k -> newBuffer(queryId, targetStageId, partitionIndex)
        // buffer also no longer accepts evictions, so it simply contributes nothing to `freed`. (codex
        public int getLeftDoneCount() {  
        }  
                    // permanent spilledTotalBytes leak that shrinks the node's effective spill  
        // admission and with clearForQuery. Only the caller that actually removed the entry (a  
            while (evicted < targetBytes) {
        }
                        } catch (EOFException eof) {  
            // Iterate the entry set and remove matching entries. ConcurrentHashMap's iterator is weakly
                    }
    }
             */  
                            len = in.readInt();
                    // with node==perQuery the un-freed resident leaves no node headroom, so the admit
                    // Spill enabled: instead of failing fast, evict oldest in-memory chunks of this  
            if (q != null) {
        return getOrCreateBuffer(queryId, targetStageId, partitionIndex);  
            return drainSideLazy(leftSpill, leftData);
        public int getExpectedRightSenders() {
     * OOM. Invoked on EVERY terminal outcome of a query's data-node work — normal completion, error,
        assert Thread.holdsLock(admitLock) : "releaseLocked requires admitLock";
                    // write failed, so they were never recorded in SpilledSide.bytesOnDisk() and the
            try {
            // Defensive: NEVER append data to a buffer a consumer has begun draining — the drain  
     * the root under which per-query spill subdirs are written ({@code <directory>/<queryId>/});  
            removed = buffers.remove(key(queryId, targetStageId, partitionIndex));
     * {@link #getOrCreateBuffer}) that no consumer will ever drain/remove → a fresh leak, AND reserve  
        public CloseableIterator<byte[]> drainRight() {  
     * ({@link ShuffleSenderRetry}: 8 attempts, backoff capped at 5s, ≈ 6.4s of backoff + transport  
        // spillOldest releases the spilled bytes from THAT buffer's own currentBytes so removeBuffer  
            return true;
    // stay outside the lock. Chunk arrival rate is modest (transport RPCs), so this is not hot.  
                        return null; // clean end of file
         * single chunk is never split — if the oldest chunk alone is larger than {@code targetBytes}  
    /**  
                    leftSpill = new SpilledSide(spillFilePath("left"));
            // reclaimed.
        if (!Files.isDirectory(queryDir)) {
         * budget enforcement is owned by the enclosing {@link ShuffleBufferManager#tryAdmit} (node +  
    }
                } else if (onDisk > 0) {
            if (remaining <= 0) return false;  
            // bytes — removeBuffer then releases precisely what was reserved, with no transient skew.
                } catch (IOException e) {
                }
                continue;  
                    throw new ShuffleBufferExceededException(qProjected, perQueryMaxBytes);  
                long diskBytes = len + SPILL_FRAME_HEADER_BYTES;
         * never spills a buffer that is concurrently draining. Without this, a late cross-partition
     *       when other queries finish and release their buffers).</li>
            return querySpillDir.resolve(spillKey + "-" + side + ".spill");
        // stores into a doomed buffer. The put is on a ConcurrentHashMap, NOT under admitLock; it is  
                    owner.recordOrphanedSpill(spill.path(), onDisk);
        // NEVER spill a buffer a consumer has begun draining: its drain may have already snapshotted the
            }
                    @Override
    private final AtomicLong spilledTotalBytes = new AtomicLong();  
                    // If this path was an orphan (a buffer-level delete failed earlier and its bytes are  
     * tryAdmit, so a buffer's {@code currentBytes} exactly equals its reserved bytes — removeBuffer
        // is a disk leak (mirrors the in-memory cleanup). Only the caller that actually removed the  
        /** Records a rejected/failed admission attempt against this buffer (observability). */
                }
    }  
                    // release (the per-buffer release happens inside spillToMakeRoom).  
        // call) BEFORE the locked re-check left a leak: getOrCreateBuffer could hand back an unstored
        Long expiry = aborted.get(queryId);
        // Sweep + budget reclaim under admitLock so they're atomic with admission and removeBuffer:
        // single partition buffer may not hold enough resident bytes to cover the breach when the
        /**
        return queryId + ":" + targetStageId + ":" + partitionIndex;
     *       idle node, so it fails FAST and NON-retryably ({@link ShuffleBufferExceededException}).
     * several sub-node-budget queries at once) is the future fix if concurrent shuffle becomes a  
                    in = null;
     * reservation; removeBuffer decrements it per drained buffer, clearForQuery removes whatever
                };
        // any admit that reserved bytes for this query did so under admitLock and released it before  
        // the EARLIER admits so the common case never stores into a doomed buffer.)
    private boolean isTombstoned(String queryId) {
                        if (orphanBytes != null) {  
         * breach in {@link ShuffleBufferManager#tryAdmit} evicts this buffer's oldest chunks to a  
        private static CloseableIterator<byte[]> drainSideLazy(SpilledSide spill, List<byte[]> inMemory) {  
        private SpilledSide rightSpill;
     * sender's bounded retry window ({@link ShuffleSenderRetry}), it FAILS rather than waiting
                        len = in.readInt();
    /**
         */  
     * of every buffer it holds across ALL queries/stages/partitions. A per-buffer cap can't bound
import java.io.UncheckedIOException;  
        // entry is already out of the map, so no admit/release can race it. deleteSpillFiles returns
            }
                    throw new UncheckedIOException("Failed to read back shuffle spill file " + spillPath, e);
                    // leave the chunk resident and fail (it's still safely in memory/accounted).  
        }
         * tracked {@link #currentBytes} is read at removal time to release the reservation.
                        throw ShuffleBufferExceededException.forDiskCeiling(owner.getSpilledTotalBytes() + diskBytes, owner.spillMaxBytes);
     * Subtracts {@code bytes} from the node total and the query's per-query footprint. MUST be called
        }
        }
            currentBytes.addAndGet(size);  
     * shuffle queries can then each fit their per-query share yet jointly exceed the node budget: the  
    private final Map<String, ShuffleBuffer> buffers = new ConcurrentHashMap<>();
                }
        totalBytes.accumulateAndGet(bytes, (cur, b) -> Math.max(0, cur - b));  
            long evicted = 0L;  
         * (codex review round-4 BLOCKER #1.) volatile so the spill path sees a set made under the lock.
        }  
        }
                closeOut();  
                    close();
                    // against a draining buffer. (codex review round-4 BLOCKER #1.)
                    // total can't silently grow past the ceiling by 4×chunkCount. (codex round-2.)  
        // own entry and return a throwaway, closing the recreate race. (codex review: tombstone race.)
            public byte[] next() {
     * counters can't drift. {@code perQueryBytes} is the single source of truth for a query's
         * terminal (removeBuffer / clearForQuery). A leaked .spill file is a disk leak.
            return rightDoneCount.get();
        }
        // review round-4 BLOCKER #1: cross-partition spill could race a draining sibling.)  
                    // truth = perQueryBytes). No buffer.releaseCurrentBytes here — that would double-
    /** Number of live (non-expired) tombstones. Test/observability hook for the TTL eviction. */
                return leftSpill;
    }
    private volatile Path spillDir = null;
                    // terminal cleanup (which releases bytesOnDisk) would NOT reclaim them → a
        }
     * here. The per-query dir sweep ({@link #deleteQuerySpillDir}) consults this map: when it succeeds  
     * spill is enabled).
                        try {
            }
         * under the manager's {@code admitLock} (spill) or after the buffer is out of the map  
         */
     *   <li>{@link #perQueryMaxBytes} — hard ceiling on a SINGLE query's footprint  
         */
            // cleanup, so we must not remove (and mis-account) it.
        // /clearForQuery would ever release (codex review: tombstoned-admit-budget-leak via eviction).
            }
        aborted.put(queryId, now + TOMBSTONE_TTL_NANOS);  
             * it. Used by the LAZY drain path so chunks are read one-at-a-time, never all-resident.
            }
                long freed = q.getAndSet(0);
        }  
    // budget check and over-commit. Scope is the counter check+increment ONLY; storage and drain
            String other = "left".equals(side) ? "right" : "left";
                out.write((len >>> 8) & 0xFF);
     * the buffer's in-memory lists and the caller releases the freed bytes from the budget counters
         * per-side spill file under {@code <queryDir>} instead of failing fast. Idempotent.
        return freed;  
            long onDisk = spill.bytesOnDisk();
                }
                    leftReady.countDown();  
         * every drain entry point, BEFORE any list snapshot or spill-file open. A throwaway buffer
    public long getSpilledTotalBytes() {
        /**  
            return;
            removed.deleteSpillFiles();  
     * {@code SpilledSide} is dropped, so the only record of how much is charged for that path lives
         * acceptable. A spill read error surfaces as an {@link UncheckedIOException} that fails the  
    private ShuffleBuffer newBuffer(String queryId, int targetStageId, int partitionIndex) {
     */
            );
                return new CloseableIterator<>() {
     * keyed {@code queryId → expiry nanoTime}. A producer RPC for a cancelled query can race in AFTER
    /**
                    return false;  
        int n = 0;
        // reservation; removeBuffer likewise can't be mid-release on one of these buffers. perQueryBytes
    }
        String k = key(queryId, targetStageId, partitionIndex);  
        // (beginDrain), which we hold here, so these reads can't race a half-started drain. A draining
            if (buffer.isDraining()) {
            if (owner != null) {
                leftData.add(data);
            freed += spillBufferBothSides(buffer, side, targetBytes);
                    // buffer.currentBytes) via the SAME releaseLocked accounting path removeBuffer  
                    throw new UncheckedIOException("Failed to open shuffle spill file " + spillPath, e);  
    private void releaseSpillBytes(long size) {
            return (existing == null ? 0L : existing) + bytes;  
         */
        // footprint is spread across sibling partitions of the SAME stage. Spill those (non-draining)
                }  
            // admitLock, the same lock beginDrain flips `draining` under, so this read can't race a
    public long getTotalBytes() {  
        // Hand back an unstored throwaway so the write lands on a collectible object. (This path is
    }
        private SpilledSide leftSpill;  
    }  
        // after that producer's reserve+store exits it — see the no-leak proof in tryAdmit). The TTL  
        // computeIfAbsent, so a producer that read not-tombstoned can still insert a key AFTER
         * mutated, so a snapshot of the in-memory tail taken under its monitor is stable.
                synchronized (owner.admitLock) {  
                // Include the frame header so bytesOnDisk (released on cleanup) matches the framed size
        if (bytes <= 0) {
                    owner.releaseSpillBytes(onDisk);  
         * IN-MEMORY-resident bytes, so a later {@link ShuffleBufferManager#removeBuffer} releases only  
        deleteQuerySpillDir(queryId);  
     */
            beginDrain();
            }  
            // Spilled: stream the file chunk-by-chunk, then the in-memory tail. The DataInputStream is
    }
                    long diskBytes = len + SPILL_FRAME_HEADER_BYTES;
        }
     * Idempotent and safe to call when no buffers exist for the query (the common non-shuffle case).
     * Spills {@code buffer}'s oldest resident chunks (the incoming {@code side} first, then the other
     * call {@link #addData} concurrently (after the manager's {@link #tryAdmit} reserves budget);
                        nextLoaded = true;  
 * @opensearch.internal
    void discardRacedBuffer(String queryId, String k, ShuffleBuffer buffer) {
                }
        this.nodeBudgetBytes = nodeBudget;  
                    // If spill couldn't free enough — (a) a SINGLE chunk larger than the budget with  
         * as-is (byte-identical to the pre-spill path). With spill, the spilled chunks are read back
    }
            }
                        in.readFully(chunk);
                checkCompletion("right");
    /** Current total on-heap shuffle bytes reserved across all buffers (for observability/tests). */
     * observe a half-spilled state). Before each chunk is written, the node-wide disk ceiling
        // EVERY terminal (success/fail/cancel). The buffers are already out of the map, so no admit
            // and subtract it from the node total), so a cancelled/failed query's budget is fully
        // 2. The per-query budget is query-WIDE (q.get() across every partition on this node), but a  
    private volatile long perQueryMaxBytes = Long.MAX_VALUE;
        // If the query was already cleared (cancelled/terminated), do NOT repopulate the map — a late
        public ShuffleBuffer() {}
        public List<byte[]> getLeftData() {
        }
                }  
     *       {@code perQueryMaxBytes} (never fits — fail fast, non-retryable);</li>
                draining = true;
            return expectedLeftSenders;
            }  
                LOGGER.warn("Shuffle right side timed out: received {}/{} senders", rightDoneCount.get(), expectedRightSenders);
     * then tracks ONLY the in-memory-resident bytes. {@link #spilledTotalBytes} is the node-wide  
            return;
            boolean deleted = spill.closeAndDelete();  
                    } catch (IOException e) {
     * cross-side interleaving is irrelevant). MUST run under {@link #admitLock}.  
     * side) until at least {@code targetBytes} are freed or the buffer runs dry, releasing the spilled  
                    @Override
                if (in != null) {
                        return it.hasNext();
                    // null and does nothing. (round-4 #2 / codex round-5 SHOULD-FIX #3.)
            }  
        Path queryDir = dir.resolve(safeSegment(queryId));  
        // clearForQuery's removal sweep already passed it. clearForQuery sets the tombstone BEFORE  
            }
        private ShuffleBufferManager owner;  
         * {@link ShuffleBufferExceededException} if the node-wide disk ceiling is hit or a write fails.
             * first so all buffered bytes are flushed. Returns {@code null} if no file was ever  
                }
     * Deletes the per-query spill subdir ({@code <spillDir>/<queryId>/}) and everything under it,
        public CloseableIterator<byte[]> drainLeft() {  
     * {@code nodeBudget == perQueryMax} (both = {@code node_budget_percent}% of heap). Two legitimate
/**  
     * so {@link #deleteQuerySpillDir} can release them when it (re)deletes the file. Race-safe vs a  
import java.util.List;  
                // CREATE + truncate: a stale file at this exact (query,stage,partition,side) path can  
     * {@link #awaitReady} returns. Byte-budget enforcement lives in the enclosing manager, not here.  
            return new ShuffleBuffer();
    /**
        return buffer;
     * {@link ShuffleBufferExceededException} naming the disk ceiling (the new terminal failure when  
            if (e.getValue() - now <= 0) {  
            return rejectedCount.get();  
        private Path querySpillDir;
                break;
     * byte-identical to the no-spill path). Called at plugin startup and on dynamic updates.  
         * Set once a consumer begins draining this buffer (snapshotting the in-memory tail / opening
        private Path spillFilePath(String side) {
    private static final long TOMBSTONE_TTL_NANOS = TimeUnit.SECONDS.toNanos(120);
     * permanent {@code spilledTotalBytes} inflation. (codex round-5 SHOULD-FIX #3.)
        int size = data == null ? 0 : data.length;
            }
        if (isTombstoned(queryId)) {  
        // 1. Spill the RECEIVING buffer first — its incoming-side chunks, then its other side. Each
                } catch (IOException e) {  
     */  
                    // (spill.max_bytes / a write I/O error) is terminal — re-messaged below.  
    /**  
                        LOGGER.debug(new ParameterizedMessage("Failed to close shuffle spill stream {}", path), e);  
                    }
            private byte[] readNextChunk() {
         * Each chunk is already a self-describing Arrow IPC stream, so the frame just needs to record  
             */
     * {@link #spillMaxBytes}; false otherwise (caller turns that into the terminal disk-ceiling
        AtomicLong q = perQueryBytes.get(queryId);
     * concurrent map's per-key atomicity suffices; expired entries are purged opportunistically in
    /**
                // awaitReady, but addData uses a synchronizedList so honor its lock.  
     * freed, and returns the bytes actually freed. MUST run with {@link #admitLock} held: it mutates
 * Per-node registry of shuffle buffers for hash-shuffle joins. One {@link ShuffleBuffer} per
                if (expectedRightSenders >= 0 && rightDoneCount.get() >= expectedRightSenders) {  
 * of the key — otherwise two partitions' left/right payloads and {@code isLast} markers would  
                return inMemory;
     * budget that no release would reclaim. While a query is tombstoned, admission drops the payload
        }
            beginDrain();
     * that sum (N partitions each under the cap still OOM in aggregate), so admission is gated on:  
        long freed = 0L;
        String stagePrefix = queryId + ":" + targetStageId + ":";
     * — on {@link AdmitResult#ACCEPTED} — stores {@code data} into the buffer and reserves the bytes.
            }  
                }  
         *
        }  
                return new DataInputStream(new BufferedInputStream(Files.newInputStream(path)));  
            }  
            public boolean hasNext() {
        }  
import org.apache.logging.log4j.message.ParameterizedMessage;  
            /**
     *   <li>throws {@link ShuffleBufferExceededException} if the query's OWN footprint would exceed
        long now = System.nanoTime();
                }
    public enum AdmitResult {
        private volatile int expectedRightSenders = -1;
     * spill files on demand. Throwaway buffers (the tombstone path) are created via the bare ctor and
        // twice (codex review: shuffle-budget-double-release).
     * node's spill files; hitting it (or a disk write I/O error) is the new terminal failure  
            if (spill == null) {
    public int clearForQuery(String queryId) {  
     * Creates a stored buffer for {@code (queryId,targetStageId,partitionIndex)} and, when spill is  
        }
     * bytes here and store nothing instead of leaving a phantom orphan entry that never gets swept →
        // on a SINGLE tombstone read. Doing the buffer lookup lock-free (the old getOrCreateBuffer
    /**
            return expectedRightSenders;  
                // addData (other side / other producer) can't shift indices under us.
        ShuffleBuffer buffer = new ShuffleBuffer();  
                    // The disk bytes for THIS chunk were reserved (reserveSpillBytes above) but the  
        }  
     * Tombstones for queries that have been {@link #clearForQuery cleared} (terminated / aborted),  
        }  
        public void senderDone(String side) {
            }  
            if (sibling == buffer || sibling.isDraining() || !e.getKey().startsWith(stagePrefix)) {
                try {
                    } catch (IOException e) {
            }
        }
     * breach the PER-QUERY on-heap budget, {@link #tryAdmit} evicts oldest in-memory chunks of the
         * <p>Writes happen under the manager's {@code admitLock} (one writer at a time);  
            // half-started drain.  
        this.spillMaxBytes = maxBytes;
             * disk — the caller then keeps the disk-budget bytes charged rather than over-releasing.  
                return null;
     * are deleted, so even a buffer that was swept without its own {@code deleteSpillFiles} running  
            }
        // No-leak proof vs a concurrent clearForQuery (which does aborted.put on a ConcurrentHashMap,
    private static String safeSegment(String queryId) {
            return evicted;
                    }
    private volatile boolean spillEnabled = false;  
    public long getNodeBudgetBytes() {  
     * <ul>  
                // No spill for this side: just iterate the heap-resident tail, nothing to close.
     * one consumer thread drains via {@link #getLeftData} / {@link #getRightData} after
    private volatile long nodeBudgetBytes = Long.MAX_VALUE;  
     * {@link #spillMaxBytes} is checked; exceeding it — or any write I/O error — throws a re-messaged
    /**
            /** Reads one length-prefixed chunk, or {@code null} at clean EOF. */  
     * review: tombstoned-admit-budget-leak via eviction). TTL eviction is also self-bounding in memory
        if (removed != null) {  
        // Tombstone the query FIRST (with a TTL expiry) so the COMMON case — a producer RPC racing in
         * chunk is in heap at a time during the spilled phase — that is the property that lets an
                } catch (IOException e) {
        /**  
            }
        String prefix = queryId + ":";
    private static String key(String queryId, int targetStageId, int partitionIndex) {
    }
import java.util.concurrent.atomic.AtomicInteger;  
     * its buffers were cleared and would otherwise re-create a buffer (via {@link #tryAdmit} or
     * separators or {@code ..}.  
                try (DataInputStream in = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
            discardRacedBuffer(queryId, k, buffer);
        }
     * (the prefix is never heap-resident), so {@code spillOldest}'s returned {@code evicted} stays raw.
                    chunk = list.get(0);  
         * admit could spill a sibling whose drain iterator has already snapshotted its tail or closed
                if (rightSpill == null) {  
        /**
     * Node-level on-heap shuffle budget and per-query footprints — the OOM-safety bound.
        }
                if (in != null) {  
                if (deleted) {
         * over-budget partition drain through the consumer's bounded native channel without OOM.  
     * remains, so the same bytes are never subtracted twice. Storage happens under admitLock in  
     * tombstone is guaranteed present whenever a late RPC can still arrive. A COUNT-based FIFO cap
        ACCEPTED,  
         * file and removes them from the in-memory list until at least {@code targetBytes} have been
                } else {  
        // must outlive any late producer RPC (sender retry window ≈ 15s); 120s is an ~8× margin. A
                    // still charged), the dir sweep just reclaimed the disk — release those bytes exactly
                        LOGGER.debug(new ParameterizedMessage("Failed to close shuffle spill read stream {}", spillPath), e);
        // A leaked .spill file (or subdir) is a disk leak — this mirrors the in-memory cleanup on  
            if ("left".equals(side)) {  
            }
                // synchronizedList: lock the list for the size-check + remove(0) so a concurrent  
                return chunks;
                return false;  
     */
         */
                }
     * exceeding it fails fast and non-retryably). Pass {@code Long.MAX_VALUE} to disable a bound.  
        }  
        }  
                }
     */
        List<ShuffleBuffer> swept = new ArrayList<>();
import org.opensearch.analytics.spi.ShuffleBufferAccess;
                        + size
                        return true;
        // done before the locked sweep below so that a producer whose isTombstoned read happens to
    /**
     * Per-partition shuffle buffer — a store + completion latches. Thread-safe: multiple senders  
        private static final class SpillThenTailIterator implements CloseableIterator<byte[]> {
        // what makes per-buffer release (normal drain) and whole-query release (clearForQuery)  
                    byte[] chunk = new byte[len];  
            @Override  
                if (in != null) {
                    @Override  
        // throwaway for a tombstoned query, the tombstone could then be evicted, and the locked  
         * Lazy drain iterator: yields spilled chunks streamed one-at-a-time from {@code spill}'s file  
     *       share, the producer is told to back off and RETRY (a soft, transient reject: room frees
         * <p>Runs once per side after {@link #awaitReady}; the buffer is fully populated and no longer  
        private final CountDownLatch rightReady = new CountDownLatch(1);
                    Files.deleteIfExists(p);
                    if (list.isEmpty()) {  
        public int getRightDoneCount() {
                    return c;  
            }
                    // After eviction the query's resident footprint is q.get() (already decremented).
         * side runs out of resident chunks). Oldest-first (front of the list) so reading the spill
                    while (true) {
            List<byte[]> list = "left".equals(side) ? leftData : rightData;
                        }
        /**
        // re-check would see a clean set and reserve bytes into that throwaway — which no removeBuffer
     * Records {@code bytes} charged for a spill file at {@code path} whose buffer-level delete FAILED,
                    try {  
        }
        }
import java.io.EOFException;  
                // REJECT_RETRY — the producer must not retry a cancelled query.
    }
        }
        // in.
        /**  
        // is the single source of truth — we drop its entry and subtract WHATEVER REMAINS (already net  
            private final Path spillPath;
                            break; // clean end of file
                return combined;
             * written (the side spilled nothing). The caller owns the returned stream and must close
     * {@code buffers.remove} would skip releasing its spill bytes (released only by  
                    return chunk;
            } catch (IOException e) {
            // without clobbering the other side's.
                    out.write(chunk);
        // the on-disk bytes it freed so the node-wide spill total is corrected; a leaked .spill file
        // refreshes the expiry — harmless and keeps the window open if work is somehow still trickling  
                    in.readFully(chunk);
        }
                    }  
    private final Map<Path, Long> orphanedSpillBytes = new ConcurrentHashMap<>();
         */  
                tail = new ArrayList<>(inMemory);
             * Opens the spill file for sequential chunk-by-chunk reading. Closes the append stream
     * Configure hash-shuffle disk spill. {@code enabled} is the master switch; {@code directory} is
                // The file is already gone — a concurrent sweep beat our record. Release now; the
         * per-query budgets); this method only stores after admission has reserved the bytes. The
        private String spillKey; // <stageId>-<partition>
    public void setSpillConfig(boolean enabled, Path directory, long maxBytes) {
     * failure). Called from {@link ShuffleBuffer#spillOldest} before each chunk is written so the  
     * the subdir never existed.
         * in-memory tail is yielded. This is what lets an over-budget (spilled) partition drain  
        private void checkCompletion(String side) {  
    }
import java.util.Map;
                    // Reserve disk budget BEFORE removing from memory — if the ceiling is hit we
     * bytes under {@link #admitLock} — exactly like {@link #removeBuffer}. {@code computeIfAbsent} may
        return buffers.get(key(queryId, targetStageId, partitionIndex));  
    }
        return freed;
    /**
    public static class ShuffleBuffer implements ShuffleBufferAccess {
     */
import java.io.OutputStream;
                        }
                buffer.recordRejected();
     *       When a chunk would push the node total past this AND the query itself still fits its  
                    draining = true;
            if (expiry - now > 0) {
            return drainSideLazy(rightSpill, rightData);
                return 0L;  
            // snapshotted the in-memory tail, so this chunk would be silently dropped (lost rows).
                int len = chunk == null ? 0 : chunk.length;
        if (size > 0) {
     */
         * LAZY drain: yields the side's chunks in arrival order WITHOUT holding the whole partition  
                key(queryId, targetStageId, partitionIndex),  
        public List<byte[]> getRightData() {  
                // Cleared query: drop the payload, reserve nothing, store nothing. Ack rather than
        private final CountDownLatch leftReady = new CountDownLatch(1);  
                return null;
            // consistent — safe to remove through it; concurrent producer/consumer activity for a still
    private void deleteQuerySpillDir(String queryId) {
            if (spill == null) {
            if (!rightReady.await(remaining, TimeUnit.MILLISECONDS)) {
                    totalBytes.accumulateAndGet(freed, (cur, b) -> Math.max(0, cur - b));
         * Marks this buffer as draining so the spill path stops touching it. Flips {@link #draining}  
                    it.remove();
     * Buffer resolution, check-and-reserve, and storage are ALL atomic under {@link #admitLock}.
        // entry cleans up — a second remove / a concurrent clearForQuery sweep sees null and skips.
     *   <li>{@link #nodeBudgetBytes} — hard ceiling on {@link #totalBytes} (all queries combined).
            // Store under the lock so the buffer's currentBytes stays EXACTLY equal to its reserved
            }  
                if (expectedLeftSenders >= 0 && leftDoneCount.get() >= expectedLeftSenders) {
 * because its dispatch assigns exactly one shuffle partition per node. analytics-engine supports  
        long spillOldest(String side, long targetBytes) {
                if (entry.getKey().startsWith(prefix)) {  
        // Opportunistically purge expired tombstones so the map is bounded by clear-rate × TTL rather
        });
     * just as its query was tombstoned, releasing BOTH its on-heap resident bytes and its on-disk spill  
import java.util.NoSuchElementException;
            return freed;
 * (queryId, targetStageId, partitionIndex).
 * configurations where a single node hosts multiple partitions of the same stage (small clusters,
         * fragment (correctness over silent under-delivery).
            // any isLast) makes this unreachable in the normal path, but a buggy/reordered late RPC  
                    public byte[] next() {
     * Configure the node-level shuffle budget. {@code nodeBudget} caps the total on-heap shuffle
            }  
import java.io.BufferedOutputStream;
            AtomicLong q = perQueryBytes.computeIfAbsent(queryId, k -> new AtomicLong());
                    byte[] c = readNextChunk();  
     */  
         */
        }  
         * {@link #readBack} runs once at drain after the buffer is fully populated. The append stream
                    return chunks;
        // a reservation made in the put-not-yet-visible window; the tombstone only short-circuits  
                }
public class ShuffleBufferManager implements ShuffleBufferRegistry {
     * ceiling until JVM restart. (codex review round-4 SHOULD-FIX #2.)  
                out.write((len >>> 24) & 0xFF);  
     * Per-chunk on-disk framing overhead: each spilled chunk is written as a big-endian 4-byte length
            @Override
         *
                // reserved in spillOldest — else cleanup under-releases by 4×chunkCount. (codex round-2.)  
            return drainSide(rightSpill, rightData);
import java.io.IOException;
     *       {@code nodeBudgetBytes} while the query still fits its share (transient contention —
        return totalBytes.get();
         * (correctness over silent under-delivery — matches the eager {@code drainSide}).  
        // in-memory tail or opened the spill file for read, so mutating its lists/spill file here would
            this.querySpillDir = spillRoot.resolve(safeSegment(queryId));
            void append(byte[] chunk) throws IOException {  
    /**
                    // release the query + node aggregate for the grand total freed (single source of
        /**  
     * concurrent dir-sweep that may delete the file between our failed delete and this record: the
    }  
            if (leftSenders >= 0) {  
        /** True once a consumer has begun draining this buffer (see {@link #draining}). */
                        in.close();  
                if (freed > 0) {  
                byte[] chunk;
                        out.close();
        return AdmitResult.ACCEPTED;
            private long bytesOnDisk;
                return tail.next();  
        return nodeBudgetBytes;
            } else {
        }
     *       back off and retry, room frees when other queries finish);</li>
        if (projected > spillMaxBytes) {
                    // byte budget then tracks only the in-memory-resident bytes. Only the DISK ceiling
            // Conditional remove(k, buffer): only remove if k still maps to OUR buffer. A racing
 * {@link #tryAdmit} gates each chunk against a node-level + per-query byte budget (see
         * (deframing the big-endian length prefix), then the heap-resident {@code tail}. Only ONE
                    if (!owner.reserveSpillBytes(diskBytes)) {
    /**
        // ordered strictly after our store and its perQueryBytes.remove + buffers sweep releases
            beginDrain();
         * One side's on-disk spill file: a sequence of length-prefixed Arrow-IPC chunks
import java.util.ArrayList;  
        void releaseCurrentBytes(long bytes) {  
         */
     * Because node and per-query budgets are currently the SAME value, lowering
    private void recordOrphanedSpill(Path path, long bytes) {
                    LOGGER.debug(new ParameterizedMessage("Failed to delete shuffle spill path {} for query {}", p, queryId), e);  
                    int len;  
    }  
        @Override
        return queryId.replaceAll("[^A-Za-z0-9_.-]", "_");  
         * and deframed from the file (in write = arrival order) FIRST, then the in-memory tail is  
                }
        return n;
        boolean isDraining() {  
         * Spill state. Null/disabled by default — a buffer only spills when the manager wires its  
                    owner.releaseSpillBytes(diskBytes);  
        /**
                    rightReady.countDown();
                releaseLocked(queryId, removed.getCurrentBytes());  
            private OutputStream out;  
    public ShuffleBuffer getBuffer(String queryId, int targetStageId, int partitionIndex) {
        // amortized across clears. (No separate timer/lock — per-key conditional remove is atomic.)  
                // Big-endian 4-byte length prefix, then the chunk bytes.
     * on-disk total, checked against {@link #spillMaxBytes}.
        /**
 *
            AtomicLong q = perQueryBytes.remove(queryId);  
            }  
    }
         *  
                    releaseLocked(queryId, freed);
     * queries one-at-a-time, and failing a contended query is strictly safer than risking a node OOM.
        }
                return path;
 * The OpenSearch Contributors require contributions made to  
        // repeat clearForQuery (the cancellation-listener backstop firing after normal cleanup)
        }  
            buffer.enableSpill(this, spillDir, queryId, targetStageId, partitionIndex);
        // Map removal AND budget release happen together under admitLock so they're atomic with
        public void addData(String side, byte[] data) {
            }
        //  
        }
            // The producer's two-phase close (DatafusionPartitionedSink: drain all data sends before
                try {
    }  
                    // returns REJECT_RETRY and the producer retries — succeeding once the draining  
            if (buffers.remove(k, buffer)) {
            SpillThenTailIterator(SpilledSide spill, List<byte[]> tail) {  
         * {@code spillToMakeRoom}: once this returns, no concurrent or subsequent spill will evict from
 * <p>Ported from OLAP's {@code ShuffleManager}
        // Create via newBuffer so the buffer is spill-capable regardless of WHICH path creates it
            public void close() {  
                if (!Files.exists(path)) {  
     *
                    "Shuffle data ("
        private volatile int expectedLeftSenders = -1;
        // of any prior per-buffer removeBuffer decrements), so the same bytes are never subtracted
                throw new UncheckedIOException("Failed to read back shuffle spill file " + spill.path(), e);  
                    return null;
            }  
    /**
    }
        this.perQueryMaxBytes = perQueryMax;
         * per-side on-disk files (lazily created on first spill). All spill state mutation happens
        if (isTombstoned(queryId)) {  
    /** Returns {@code size} bytes to the node-wide spill (disk) budget when a spill file is deleted. */  
            private DataInputStream in;          // null once the spilled phase is exhausted/closed  
     * Evicts oldest in-memory chunks of {@code side} (then the other side if {@code side} alone can't
     *  
     *  as not-tombstoned and is reclaimed by the next {@code clearForQuery} purge. */  
        private SpilledSide spillFor(String side) throws IOException {
                        return null; // drop the entry either way — the file is gone  
        }
        if (removed > 0) {
     */
            }
     */  
     * else many small chunks let real disk usage exceed {@link #spillMaxBytes} by {@code 4 × chunkCount}
            synchronized (inMemory) {
     * sides' chunks are read back in arrival order at drain (left/right drain into separate streams, so
        }
        // Delete this buffer's spill files (if any) OUTSIDE admitLock — file deletion is I/O and the  
                }
                rightDoneCount.incrementAndGet();
        }
    public ShuffleBufferAccess getOrCreate(String queryId, int targetStageId, int partitionIndex) {
            }
     * first-class workload.
        }
            // counter would let later queries admit past spill.max_bytes — keep them charged instead.
            // must FAIL LOUD here rather than under-deliver. (codex round-5 BLOCKER #2.) Checked under
            }  
                closeOut();
 *
    private final Map<String, AtomicLong> perQueryBytes = new ConcurrentHashMap<>();  
                // only come from a prior incarnation that failed to clean up; start fresh.
         * it is still spilled whole (resident then drops below the budget). Throws a re-messaged
     * {@code node_budget_percent} does NOT help two large shuffles coexist (it lowers per-query  
            if (owner != null) {
        for (Map.Entry<String, ShuffleBuffer> e : buffers.entrySet()) {  
 * <p>Each {@link ShuffleBuffer} tracks per-side sender completion via {@code CountDownLatch}es and  
            }
     *  
        return expiry != null && expiry - System.nanoTime() > 0;
                evicted += len;
        }
            return;  
         */  
            return draining;
                    // Disk footprint includes the 4-byte frame header append() writes, so the on-disk
                    spill.append(chunk);
    private boolean reserveSpillBytes(long size) {  
            /**  
            @Override
    private final Map<String, Long> aborted = new ConcurrentHashMap<>();
                    // siblings that are already DRAINING and thus skipped by spillToMakeRoom — then this
import java.io.BufferedInputStream;  
        // Resolve the buffer, reserve the bytes, AND store the chunk together under admitLock, keyed  
         * {@link #awaitReady}, so reading the whole file back into a list then concatenating is
         * (no owner) just sets the flag. (codex review round-4 BLOCKER #1.)
            SpilledSide(Path path) throws IOException {  
