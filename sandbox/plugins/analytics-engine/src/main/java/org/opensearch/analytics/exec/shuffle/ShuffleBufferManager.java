            return new ShuffleBuffer();
                return tail.hasNext();
            }
        if (!Files.isDirectory(queryDir)) {
            this.querySpillDir = spillRoot.resolve(safeSegment(queryId));
        /** Records a rejected/failed admission attempt against this buffer (observability). */
     * Spill files whose buffer-level {@code deleteSpillFiles} FAILED to delete (disk/IO error): their
     * {@code node_budget_percent} does NOT help two large shuffles coexist (it lowers per-query
     * Removes a buffer that was created/returned by {@link #getOrCreateBuffer}'s {@code computeIfAbsent}
     */
        // any admit that reserved bytes for this query did so under admitLock and released it before
                    } catch (IOException e) {
                return chunks;
                    @Override
     * prefix followed by its payload (see {@code SpilledSide.append}). The disk-budget accounting
                if (!Files.exists(path)) {
                n++;
     * under the same lock, so the byte accounting stays consistent (no admit/release interleaving can
            freed += spillBufferBothSides(buffer, side, targetBytes);
            if (Files.exists(p) == false) {
                    // spillToMakeRoom already released each spilled buffer's own currentBytes; here we
        ACCEPTED,
        // reservation; removeBuffer likewise can't be mid-release on one of these buffers. perQueryBytes
         * Appends the oldest in-memory chunks of {@code side} (length-prefixed) to that side's spill
            DataInputStream openForRead() throws IOException {
import java.util.ArrayList;
            buffer.addData(side, data);
                if (!tail.hasNext()) {
        private Path spillFilePath(String side) {
        /**
                }
         * the spilled phase. Reading past a corrupt/short frame surfaces an {@link UncheckedIOException}
                }
        // buffer also no longer accepts evictions, so it simply contributes nothing to `freed`. (codex
            // reclaimed.
        // and spilledTotalBytes is only ever incremented here (under admitLock) and decremented in
     * OOM. Invoked on EVERY terminal outcome of a query's data-node work — normal completion, error,
            String other = "left".equals(side) ? "right" : "left";
                List<byte[]> combined = new ArrayList<>(spilled.size() + inMemory.size());
            // (codex review round-3 SHOULD-FIX.)
        }
         * ({@code int length} big-endian, then {@code length} bytes), appended in arrival order.
                    return false;
        }
    }
                return null;
                out.write((len >>> 8) & 0xFF);
        int size = data == null ? 0 : data.length;
    /** True if {@code queryId} has a live (non-expired) tombstone. Lock-free; safe on the producer
                    rightSpill = new SpilledSide(spillFilePath("right"));
     * {@code clearForQuery}.
                    try {
    public ShuffleBufferAccess getOrCreate(String queryId, int targetStageId, int partitionIndex) {
                    Files.deleteIfExists(p);
        if (queryId == null) {
package org.opensearch.analytics.exec.shuffle;
            if (remaining <= 0) return false;
                }
                long diskBytes = len + SPILL_FRAME_HEADER_BYTES;
     * its buffers were cleared and would otherwise re-create a buffer (via {@link #tryAdmit} or
                // reserved in spillOldest — else cleanup under-releases by 4×chunkCount. (codex round-2.)
            for (var it = buffers.entrySet().iterator(); it.hasNext();) {
            /** Appends one length-prefixed chunk and flushes so it is durably readable at drain. */
                Files.createDirectories(path.getParent());
                }
                    swept.add(entry.getValue());
                checkCompletion("left");
                }
        int n = 0;
         * breach in {@link ShuffleBufferManager#tryAdmit} evicts this buffer's oldest chunks to a
                        + " side="
            }
            return expectedLeftSenders;
                        return it.hasNext();
        // in.
                // No spill for this side: just iterate the heap-resident tail, nothing to close.
                }
         * Set once a consumer begins draining this buffer (snapshotting the in-memory tail / opening
        /** True once a consumer has begun draining this buffer (see {@link #draining}). */
            // Snapshot the in-memory tail once (drain is single-threaded post awaitReady, but addData
                    in.readFully(chunk);
            // without clobbering the other side's.
        public List<byte[]> getRightData() {
                // Include the frame header so bytesOnDisk (released on cleanup) matches the framed size
         * mutated, so a snapshot of the in-memory tail taken under its monitor is stable.
        // Sweep + budget reclaim under admitLock so they're atomic with admission and removeBuffer:
         * it is still spilled whole (resident then drops below the budget). Throws a re-messaged
            }
     * delete failure would permanently inflate {@code spilledTotalBytes} → a false {@code spill.max_bytes}
     * call {@link #addData} concurrently (after the manager's {@link #tryAdmit} reserves budget);
        String k = key(queryId, targetStageId, partitionIndex);
                if (len > 0) {
                }
        if (removed > 0) {
     * best-effort. Called on every terminal from {@link #clearForQuery} after the per-buffer files
        private final CountDownLatch leftReady = new CountDownLatch(1);
            LOGGER.debug(new ParameterizedMessage("Failed to walk shuffle spill dir {} for query {}", queryDir, queryId), e);
            spilledTotalBytes.accumulateAndGet(size, (cur, b) -> Math.max(0, cur - b));
        // this sweep could acquire the lock, so the sweep observes (and reclaims) every such buffer +
                }
        // stores into a doomed buffer. The put is on a ConcurrentHashMap, NOT under admitLock; it is
            List<byte[]> list = "left".equals(side) ? leftData : rightData;
            return querySpillDir.resolve(spillKey + "-" + side + ".spill");
        }
                } else {
                // Snapshot the in-memory tail under its monitor — drain is single-threaded post
     * {@link #awaitReady} returns. Byte-budget enforcement lives in the enclosing manager, not here.
    }
        private final AtomicInteger leftDoneCount = new AtomicInteger();
                }
            if (spill == null) {
        // already draining — a retried/reordered admit landing post-drain — is skipped here too.)
         * what is still resident — never the already-released spilled bytes (no double-release).
        long freed = buffer.spillOldest(side, targetBytes);
     *       when other queries finish and release their buffers).</li>
                int len = chunk == null ? 0 : chunk.length;
import org.apache.logging.log4j.LogManager;
         * {@link #awaitReady}, so reading the whole file back into a list then concatenating is
    private void releaseSpillBytes(long size) {
                        if (orphanBytes != null) {
        // No lock needed for the ceiling check itself — admission already serializes via admitLock,
        /**
    private final AtomicLong spilledTotalBytes = new AtomicLong();
    }
     */
                    // Reserve disk budget BEFORE removing from memory — if the ceiling is hit we
        // attaches the spill identity (lazy — no file is opened until spillOldest fires), so a
         * LAZY drain: yields the side's chunks in arrival order WITHOUT holding the whole partition
        // ordered strictly after our store and its perQueryBytes.remove + buffers sweep releases
     * bytes here and store nothing instead of leaving a phantom orphan entry that never gets swept →
     * deterministic unit test of the cleanup (the live branch only fires in a narrow concurrent window).
        long now = System.nanoTime();
        if (size == 0) {
            return freed;
                    // If this path was an orphan (a buffer-level delete failed earlier and its bytes are
         * never spills a buffer that is concurrently draining. Without this, a late cross-partition
                releaseSpillBytes(bytes + (existing == null ? 0L : existing));
     * cross-side interleaving is irrelevant). MUST run under {@link #admitLock}.
        private final AtomicLong currentBytes = new AtomicLong();
                    // null and does nothing. (round-4 #2 / codex round-5 SHOULD-FIX #3.)
    private long spillToMakeRoom(ShuffleBuffer buffer, String queryId, int targetStageId, String side, long targetBytes) {
     * sender's bounded retry window ({@link ShuffleSenderRetry}), it FAILS rather than waiting
        private String spillKey; // <stageId>-<partition>
     * Admits {@code size} bytes for {@code (queryId,side)} against the node + per-query budgets, and
     * ({@link ShuffleSenderRetry}: 8 attempts, backoff capped at 5s, ≈ 6.4s of backoff + transport
    private long spillBufferBothSides(ShuffleBuffer buffer, String side, long targetBytes) {
                    // ceiling for later queries. Release the reserved-but-unwritten bytes here.
        }
         */
         */
                        }
                } catch (IOException e) {
            }
    /**
        // Map removal AND budget release happen together under admitLock so they're atomic with
                if (deleted) {
         * admit could spill a sibling whose drain iterator has already snapshotted its tail or closed
     * {@code Files.exists} check runs INSIDE the atomic {@code compute}, so if the sweep already removed
                    }
        }
    public long getTotalBytes() {
            buffer.enableSpill(this, spillDir, queryId, targetStageId, partitionIndex);
                    throw new UncheckedIOException("Failed to open shuffle spill file " + spillPath, e);
                    // release (the per-buffer release happens inside spillToMakeRoom).
                }
        // Collect swept buffers so their spill files can be deleted OUTSIDE admitLock (file I/O).
     * budget that no release would reclaim. While a query is tombstoned, admission drops the payload
     * tombstone is guaranteed present whenever a late RPC can still arrive. A COUNT-based FIFO cap
        }
        aborted.put(queryId, now + TOMBSTONE_TTL_NANOS);
            } else {
            removed.deleteSpillFiles();
                continue;
            // owned by the iterator and closed on close() / at clean EOF.
    private void releaseLocked(String queryId, long bytes) {
            return new ShuffleBuffer();
    public ShuffleBuffer getBuffer(String queryId, int targetStageId, int partitionIndex) {
            if ("left".equals(side)) {
         * per-query budgets); this method only stores after admission has reserved the bytes. The
         */
        }
                leftData.add(data);
                        } catch (EOFException eof) {
     *  as not-tombstoned and is reclaimed by the next {@code clearForQuery} purge. */
     * (re-messaged {@link ShuffleBufferExceededException}). All counter mutations on the spill path
     * with {@code admitLock} held — releases are serialized with admission and with each other so the
         * spill identity via {@link #enableSpill}. {@link #leftSpill} / {@link #rightSpill} are the
     * <ul>
         */
            beginDrain();
            }
                throw new IllegalStateException(
            }
/*
                    draining = true;
         * under the owner's {@code admitLock} (when an owner is wired) so the set is ordered against
                        + side
        public ShuffleBuffer() {}
     */
    private static final Logger LOGGER = LogManager.getLogger(ShuffleBufferManager.class);
     *
                    // Disk footprint includes the 4-byte frame header append() writes, so the on-disk
     * </ul>
    /**
     * Evicts oldest in-memory chunks of {@code side} (then the other side if {@code side} alone can't
        }
                if (expectedLeftSenders >= 0 && leftDoneCount.get() >= expectedLeftSenders) {
                // awaitReady, but addData uses a synchronizedList so honor its lock.
                    // permanent spilledTotalBytes leak that shrinks the node's effective spill
                }
            if (freed >= targetBytes) {
         * appended — reconstructing the full arrival sequence. Drain happens once per partition after
            if ("left".equals(side)) {
        }
                releaseLocked(queryId, removed.getCurrentBytes());
        /** Lazily opens (and remembers) the per-side spill file's append stream. */
        private void checkCompletion(String side) {
     *       This is the q17 case (one side wants ~7.4GB).</li>
            // must FAIL LOUD here rather than under-deliver. (codex round-5 BLOCKER #2.) Checked under
     * Default disabled ({@code Long.MAX_VALUE}) until wired from settings at plugin startup.
    private volatile Path spillDir = null;
        // A leaked .spill file (or subdir) is a disk leak — this mirrors the in-memory cleanup on
            return drainSideLazy(rightSpill, rightData);
        private static final class SpilledSide {
     * breach the PER-QUERY on-heap budget, {@link #tryAdmit} evicts oldest in-memory chunks of the
 *
            boolean closeAndDelete() {
                    buffer.recordRejected();
     * the buffer's in-memory lists and the caller releases the freed bytes from the budget counters
        // MISS the not-yet-visible put is still caught by the sweep (which can only enter admitLock
                this.spillPath = spill.path();
            // half-started drain.
                return path;
        List<ShuffleBuffer> swept = new ArrayList<>();
                return rightSpill;
        }
                this.expectedRightSenders = rightSenders;
    public boolean isSpillEnabled() {
 * over-provisioned {@code plugins.analytics.shuffle_partitions}), so partitionIndex must be part
        }
            SpillThenTailIterator(SpilledSide spill, List<byte[]> tail) {
         * {@link #readBack} runs once at drain after the buffer is fully populated. The append stream
        public int getLeftDoneCount() {
 * ({@code opensearch-olap/.../transport/ShuffleManager.java}). OLAP keys by (queryId, stageId)
        // exactly what we reserved. Safe. (The locked sweep — not the tombstone — is what reclaims
         */
                    byte[] c = readNextChunk();
                        return true;
            // and subtract it from the node total), so a cancelled/failed query's budget is fully
import java.nio.file.Files;
                    LOGGER.debug(new ParameterizedMessage("Failed to delete shuffle spill path {} for query {}", p, queryId), e);
     * stay under {@link #admitLock} (same accounting path as {@code releaseLocked}); the byte budget
                    // buffer to disk to make room for the incoming chunk, then store it. Spilling
            this.spillKey = stageId + "-" + partition;
         */
                currentBytes.accumulateAndGet(bytes, (cur, b) -> Math.max(0, cur - b));
         */
     * freed, and returns the bytes actually freed. MUST run with {@link #admitLock} held: it mutates
        //
     * {@code buffers.remove} would skip releasing its spill bytes (released only by
                        return c;
    }
     * Node-level on-heap shuffle budget and per-query footprints — the OOM-safety bound.
            }
    /**
     * -window tombstone within the 15s producer window, re-opening the recreate-and-leak race (codex
        // on a SINGLE tombstone read. Doing the buffer lookup lock-free (the old getOrCreateBuffer
        /**
                );
                // Cleared query: drop the payload, reserve nothing, store nothing. Ack rather than
    }
        // Double-check AFTER inserting: the tombstone-then-check above is not atomic with the
                    }
                    // nothing else resident (can't split), or (b) the footprint is held by same-stage
            }
     * {@code deleteSpillFiles}), so {@link #spilledTotalBytes} would stay permanently inflated → a false
        }
        // - If the put has NOT yet linearized: we miss it, reserve + store under admitLock, then
     * byte-identical to the no-spill path). Called at plugin startup and on dynamic updates.
        }
        return buffer;
    private static final long TOMBSTONE_TTL_NANOS = TimeUnit.SECONDS.toNanos(120);
            }
            AtomicLong q = perQueryBytes.remove(queryId);
    }
    /** Number of live (non-expired) tombstones. Test/observability hook for the TTL eviction. */
                    throw new NoSuchElementException();
            // Release the disk-budget reservation ONLY if the file was actually removed (or was never
            AtomicLong q = perQueryBytes.computeIfAbsent(queryId, k -> new AtomicLong());
            int size = data == null ? 0 : data.length;
 *
                        int len;
            }
            if (qProjected > perQueryMaxBytes) {
            }
            if (querySpillDir == null || targetBytes <= 0) {
                            releaseSpillBytes(orphanBytes);
        return freed;
                if (nextLoaded) {
        /** Node over budget but this query still fits its share — producer should back off + retry. */
            }
                evicted += len;
            return drainSide(leftSpill, leftData);
            LOGGER.debug("Cleared {} shuffle buffer(s) for query {} (freed budget)", removed, queryId);
            return null;
        public void senderDone(String side) {
                if (nextLoaded) {
        } catch (IOException e) {
    /**
                checkCompletion("left");
            return drainSideLazy(leftSpill, leftData);
                releaseLocked(queryId, removed.getCurrentBytes());
            return 0;
        }
import org.apache.logging.log4j.Logger;
        // release the lock. clearForQuery's sweep can only ENTER admitLock after we exit, so it is
            if (e.getValue() - now <= 0) {
        // single partition buffer may not hold enough resident bytes to cover the breach when the
                    // write failed, so they were never recorded in SpilledSide.bytesOnDisk() and the
     * {@code SpilledSide} is dropped, so the only record of how much is charged for that path lives
            return currentBytes.get();
                return false;
        // review round-4 BLOCKER #1: cross-partition spill could race a draining sibling.)
     * (e.g. a throwaway path) can't leave an orphaned file behind. A no-op when spill is disabled or
        // Opportunistically purge expired tombstones so the map is bounded by clear-rate × TTL rather
            }
            }
        Long expiry = aborted.get(queryId);
            this.owner = owner;
     * review: tombstoned-admit-budget-leak via eviction). TTL eviction is also self-bounding in memory
     */
                    owner.releaseSpillBytes(onDisk);
    }
                }
     * bytes from this buffer's own {@code currentBytes}. Returns the bytes freed from THIS buffer. Both
        }
     *   <li>{@link #nodeBudgetBytes} — hard ceiling on {@link #totalBytes} (all queries combined).
            long onDisk = spill.bytesOnDisk();
            final List<byte[]> tail;
            if (owner != null) {
                        + size
        }
        int removed = 0;
                    throw ShuffleBufferExceededException.forDiskCeiling(owner.getSpilledTotalBytes(), owner.spillMaxBytes);
                out.flush();
                    return true;
        /**
        public CloseableIterator<byte[]> drainRight() {
                    close();
         * (deframing the big-endian length prefix), then the heap-resident {@code tail}. Only ONE
        this.spillEnabled = enabled;
        // releaseSpillBytes (cleanup), so the read-modify-write is safe under the enclosing lock.
                removed = buffer;
         * touches any list/file, so {@code spillToMakeRoom} — which also runs under {@code admitLock} —
            if (!leftReady.await(remaining, TimeUnit.MILLISECONDS)) {
         * evicted; returns the bytes actually evicted (may be less than {@code targetBytes} if the
                        throw ShuffleBufferExceededException.forDiskCeiling(owner.getSpilledTotalBytes() + diskBytes, owner.spillMaxBytes);
                return inMemory;
                    long diskBytes = len + SPILL_FRAME_HEADER_BYTES;
        private SpilledSide leftSpill;
        // done before the locked sweep below so that a producer whose isTombstoned read happens to
        // own entry and return a throwaway, closing the recreate race. (codex review: tombstone race.)
        if (removed != null) {
            }
                        try {
                this.expectedLeftSenders = leftSenders;
     *       back off and retry, room frees when other queries finish);</li>
                    }
            } else {
            // Store under the lock so the buffer's currentBytes stays EXACTLY equal to its reserved
        // Delete this buffer's spill files (if any) OUTSIDE admitLock — file deletion is I/O and the
 *
        return queryId.replaceAll("[^A-Za-z0-9_.-]", "_");
                LOGGER.warn("Shuffle left side timed out: received {}/{} senders", leftDoneCount.get(), expectedLeftSenders);
        /**
         * in-memory tail is yielded. This is what lets an over-budget (spilled) partition drain
        return expiry != null && expiry - System.nanoTime() > 0;
            discardRacedBuffer(queryId, k, buffer);
            return rightDoneCount.get();
            if ("left".equals(side)) {
                // The file is already gone — a concurrent sweep beat our record. Release now; the
                    return c;
            private final Path spillPath;
    public int liveTombstoneCount() {
        @Override
                aborted.remove(e.getKey(), e.getValue());
        private volatile int expectedRightSenders = -1;
     * Idempotent and safe to call when no buffers exist for the query (the common non-shuffle case).
                        out.close();
        /**
                synchronized (owner.admitLock) {
        Path dir = spillDir;
                    public boolean hasNext() {
        synchronized (admitLock) {
         */
        }
            }
    }
            return false;
        // refreshes the expiry — harmless and keeps the window open if work is somehow still trickling
            if (isTombstoned(queryId)) {
                } else if (onDisk > 0) {
     *       {@code perQueryMaxBytes} (never fits — fail fast, non-retryable);</li>
    /**
import java.io.IOException;
        private ShuffleBufferManager owner;
                // frame header is disk-only, so it is intentionally excluded here.
                    nextChunk = null;
        }
    private volatile boolean spillEnabled = false;
     * (the prefix is never heap-resident), so {@code spillOldest}'s returned {@code evicted} stays raw.
     * large shuffles. Splitting node vs per-query into independent settings (so a node can admit
     * (the prior design) is unsafe: under a high query rate, N other clears can evict a still-in
            void append(byte[] chunk) throws IOException {
     * {@code maxBytes} is the hard node-wide disk ceiling (exceeding it fails the query). When
        // producer RPC racing after clearForQuery would otherwise leave an undrained buffer behind.
        }
    /**
            return false;
                if (in != null) {
                    return true;
    void discardRacedBuffer(String queryId, String k, ShuffleBuffer buffer) {
            Path path() {
        if (projected > spillMaxBytes) {
        // Tombstone the query FIRST (with a TTL expiry) so the COMMON case — a producer RPC racing in
    /**
    public static class ShuffleBuffer implements ShuffleBufferAccess {
                    // with node==perQuery the un-freed resident leaves no node headroom, so the admit
            }
        private final List<byte[]> rightData = Collections.synchronizedList(new ArrayList<>());
        }
            b.deleteSpillFiles();
     * shuffle queries can then each fit their per-query share yet jointly exceed the node budget: the
        private final CountDownLatch rightReady = new CountDownLatch(1);
    private final Map<String, Long> aborted = new ConcurrentHashMap<>();
     * {@link #spilledTotalBytes} bytes stay charged (the file still occupies disk), and the owning
                    chunk = list.get(0);
                key(queryId, targetStageId, partitionIndex),
         *
            private byte[] readNextChunk() {
     *       ({@link #perQueryBytes}). A query whose own shuffle exceeds this can never fit even on an
import java.util.concurrent.atomic.AtomicLong;
        // admission and with clearForQuery. Only the caller that actually removed the entry (a
            long bytesOnDisk() {
                    throw new ShuffleBufferExceededException(qProjected, perQueryMaxBytes);
     * indefinitely. This is an accepted trade-off: the engine's validated workload runs heavy shuffle
            try {
            if (spill == null) {
        private SpilledSide spillFor(String side) throws IOException {
    }
    }
     * spill files on demand. Throwaway buffers (the tombstone path) are created via the bare ctor and
             * Opens the spill file for sequential chunk-by-chunk reading. Closes the append stream
     * Removes every buffer belonging to {@code queryId} (all stages, all partitions on this node).
                List<byte[]> chunks = new ArrayList<>();
 * Per-node registry of shuffle buffers for hash-shuffle joins. One {@link ShuffleBuffer} per
            private boolean nextLoaded;
                    if (!owner.reserveSpillBytes(diskBytes)) {
        public void recordRejected() {
            /**
        }
                // buffer that admitted data carries real currentBytes.
}
        // is the single source of truth — we drop its entry and subtract WHATEVER REMAINS (already net
        // the EARLIER admits so the common case never stores into a doomed buffer.)
import org.opensearch.analytics.spi.ShuffleBufferRegistry;
     */
                            len = in.readInt();
            return evicted;
            } else {
        // call) BEFORE the locked re-check left a leak: getOrCreateBuffer could hand back an unstored
     *  observability + tests asserting per-query footprint cleanup, not just the node total. */
        private final AtomicInteger rightDoneCount = new AtomicInteger();
            private final Path path;
        /** Accepted; counters reserved and the chunk stored. */
        }
    public AdmitResult tryAdmit(String queryId, int targetStageId, int partitionIndex, String side, byte[] data) {
        // clearForQuery's removal sweep already passed it. clearForQuery sets the tombstone BEFORE
                return false;
         * as-is (byte-identical to the pre-spill path). With spill, the spilled chunks are read back
        });
                    } catch (EOFException eof) {
         * Each chunk is already a self-describing Arrow IPC stream, so the frame just needs to record
            freed += buffer.spillOldest(other, targetBytes - freed);
     * throwing — so the on-heap footprint stays bounded by the budget while the rest lives on disk.
     * separators or {@code ..}.
     * disabled, the per-query budget breach in {@link #tryAdmit} stays the fail-fast throw (behavior
         * IN-MEMORY-resident bytes, so a later {@link ShuffleBufferManager#removeBuffer} releases only
     */
                    }
         * every drain entry point, BEFORE any list snapshot or spill-file open. A throwaway buffer
            if (rightSenders >= 0) {
        public long getRejectedCount() {
            // Defensive: NEVER append data to a buffer a consumer has begun draining — the drain
import java.io.BufferedInputStream;
    }
         * side runs out of resident chunks). Oldest-first (front of the list) so reading the spill
        // than growing unbounded. Cheap: a weakly-consistent iteration over a small concurrent map,
        }
     * ceiling until JVM restart. (codex review round-4 SHOULD-FIX #2.)
            }
        // re-check would see a clean set and reserve bytes into that throwaway — which no removeBuffer
        // later releases only what's still resident (no double-release). (A receiving buffer that is
    public void removeBuffer(String queryId, int targetStageId, int partitionIndex) {
                    // Spilled phase exhausted — release the file handle and fall through to the tail.
     * observe a half-spilled state). Before each chunk is written, the node-wide disk ceiling
        return q == null ? 0L : q.get();
                    int len;
     * keyed {@code queryId → expiry nanoTime}. A producer RPC for a cancelled query can race in AFTER
                // sweep's own remove() saw no entry, so we own the release. Drop the map entry.
                    } catch (IOException e) {
        return nodeBudgetBytes;
            /** Reads one length-prefixed chunk, or {@code null} at clean EOF. */
            if (bytes > 0) {
                closeOut();
    private volatile long perQueryMaxBytes = Long.MAX_VALUE;
        return AdmitResult.ACCEPTED;
        String prefix = queryId + ":";
                return bytesOnDisk;
    /**
     *
            long remaining = timeoutMillis;
    }
        // sweeping, so any such late insert is guaranteed to observe the tombstone here — remove our
     *       When a chunk would push the node total past this AND the query itself still fits its
        }
            if (buffers.remove(k, buffer)) {
     * permanent {@code spilledTotalBytes} inflation. (codex round-5 SHOULD-FIX #3.)
    /** Outcome of {@link #tryAdmit}. */
     * concurrent dir-sweep that may delete the file between our failed delete and this record: the
            } else {
    /** True when disk spill is enabled (for observability/tests). */
            rejectedCount.incrementAndGet();
                if (freed > 0) {
            if (!rightReady.await(remaining, TimeUnit.MILLISECONDS)) {
                throw new UncheckedIOException("Failed to read back shuffle spill file " + spill.path(), e);
                // Big-endian 4-byte length prefix, then the chunk bytes.
        // the on-disk bytes it freed so the node-wide spill total is corrected; a leaked .spill file
        // after that producer's reserve+store exits it — see the no-leak proof in tryAdmit). The TTL
                    LOGGER.debug(new ParameterizedMessage("Failed to delete shuffle spill file {}", path), e);
        synchronized (admitLock) {
    /**
                }
     * and task cancellation — so the on-heap payload becomes collectible as soon as the query ends.
            if (leftSenders >= 0) {
        for (ShuffleBuffer b : swept) {
                    // The disk bytes for THIS chunk were reserved (reserveSpillBytes above) but the
     * Buffer resolution, check-and-reserve, and storage are ALL atomic under {@link #admitLock}.
             */
            if (q != null) {
import org.apache.logging.log4j.message.ParameterizedMessage;
    }
         * Lazy drain iterator: yields spilled chunks streamed one-at-a-time from {@code spill}'s file
                    if (c != null) {
        return freed;
    /**
            // counter would let later queries admit past spill.max_bytes — keep them charged instead.
            }
        return spilledTotalBytes.get();
                    }
             * disk — the caller then keeps the disk-budget bytes charged rather than over-releasing.
        // No-leak proof vs a concurrent clearForQuery (which does aborted.put on a ConcurrentHashMap,
    }
     * Tombstones for queries that have been {@link #clearForQuery cleared} (terminated / aborted),
        if (isTombstoned(queryId)) {
     *
             * or never existed (disk reclaimed); false if deletion failed and the file still occupies
                    public byte[] next() {
                    list.remove(0);
     * while the counter stays under the ceiling. The on-HEAP eviction target tracks only payload bytes
            return;
            leftSpill = closeAndDelete(leftSpill);
                long freed = q.getAndSet(0);
        return n;
        // compose without double-subtracting (codex review: shuffle-budget-double-release).
     */
        /**
        }
        if (q != null) {
            }
            // used a synchronizedList, so honor its monitor for safe publication).
            private final Iterator<byte[]> tail;
        // NEVER spill a buffer a consumer has begun draining: its drain may have already snapshotted the
            }
        }
            synchronized (inMemory) {
        Path queryDir = dir.resolve(safeSegment(queryId));
                    // returns REJECT_RETRY and the producer retries — succeeding once the draining
            ShuffleBuffer buffer = buffers.computeIfAbsent(
                    return chunk;
    }
 * <p>Ported from OLAP's {@code ShuffleManager}
            // bytes — removeBuffer then releases precisely what was reserved, with no transient skew.
            }
                    nextChunk = readNextChunk();
                    removed++;
            List<byte[]> readBack() throws IOException {
     * failure). Called from {@link ShuffleBuffer#spillOldest} before each chunk is written so the
        }
        if (freed >= targetBytes) {
         * Marks this buffer as draining so the spill path stops touching it. Flips {@link #draining}
                    spill.append(chunk);
            }
        }
            ShuffleBuffer sibling = e.getValue();
                if (out != null) {
         * per-side spill file under {@code <queryDir>} instead of failing fast. Idempotent.
         * bytes to the manager's node-wide spill budget. Best-effort, idempotent; called on every
        }
                draining = true;
         * in heap. Spilled chunks are streamed one-at-a-time from the file (the file handle lives in
        synchronized (admitLock) {
        orphanedSpillBytes.compute(path, (p, existing) -> {
            }
        return removed;
    /**
     * Disk-spill configuration (default OFF). When {@link #spillEnabled} is true and a chunk would
        return totalBytes.get();
    private static String key(String queryId, int targetStageId, int partitionIndex) {
     * </ul>
         * Returns the side's chunks in ARRIVAL order. With no spill, the in-memory list is returned
            // admitLock, the same lock beginDrain flips `draining` under, so this read can't race a
        void deleteSpillFiles() {
                    // truth = perQueryBytes). No buffer.releaseCurrentBytes here — that would double-
     * sides' chunks are read back in arrival order at drain (left/right drain into separate streams, so
            private void closeOut() {
        void enableSpill(ShuffleBufferManager owner, Path spillRoot, String queryId, int stageId, int partition) {
        // 2. The per-query budget is query-WIDE (q.get() across every partition on this node), but a
            }
            private DataInputStream in;          // null once the spilled phase is exhausted/closed
         */
     *  hot path. An expired tombstone (cleared > TTL ago, so no late RPC can still be in flight) reads
            }
                k -> newBuffer(queryId, targetStageId, partitionIndex)
     * then tracks ONLY the in-memory-resident bytes. {@link #spilledTotalBytes} is the node-wide
        public CloseableIterator<byte[]> drainLeft() {
                        + "This indicates a producer shipped data after its isLast (a close-ordering bug)."
            q.accumulateAndGet(bytes, (cur, b) -> Math.max(0, cur - b));
                        return null; // clean end of file
                    leftSpill = new SpilledSide(spillFilePath("left"));
        // stage are deliberately NOT touched — one could be draining. (round-3 BLOCKER #1.)
                        LOGGER.debug(new ParameterizedMessage("Failed to close shuffle spill stream {}", path), e);
                    orphanedSpillBytes.compute(p, (path, orphanBytes) -> {
                    @Override
import java.io.OutputStream;
                    // release the query + node aggregate for the grand total freed (single source of
         * the spill file for read). Flipped under the manager's {@code admitLock} BEFORE the drain
     * <p><b>Evicted by TTL, not count.</b> The protection a tombstone must provide is: outlive every
                    return null;
    /**
     * else many small chunks let real disk usage exceed {@link #spillMaxBytes} by {@code 4 × chunkCount}
     * without this the entries live for the JVM's lifetime and accumulate across queries → on-heap
import java.io.DataInputStream;
    private final Map<String, ShuffleBuffer> buffers = new ConcurrentHashMap<>();
     * Subtracts {@code bytes} from the node total and the query's per-query footprint. MUST be called
        return getOrCreateBuffer(queryId, targetStageId, partitionIndex);
        public int getExpectedRightSenders() {
                    }
        this.nodeBudgetBytes = nodeBudget;
        this.spillDir = directory;
                    while (true) {
            return expectedRightSenders;
         * <p>Runs once per side after {@link #awaitReady}; the buffer is fully populated and no longer
                    try {
        }
                try {
    }
        deleteQuerySpillDir(queryId);
        // first (a senderDone/isLast RPC can land before the first data chunk). newBuffer only
        // siblings too. Scoping to the same (queryId, stageId): buffers of a DIFFERENT (already-run)
        private volatile int expectedLeftSenders = -1;
     * <p>The shuffle consumer is buffer-all-then-drain, so a node's live shuffle byte[] is the SUM
        long freed = 0L;
            }
            if (spill == null) {
        private static final class SpillThenTailIterator implements CloseableIterator<byte[]> {
                    out.write(chunk);
    /**
     * Deletes the per-query spill subdir ({@code <spillDir>/<queryId>/}) and everything under it,
     */
        // EVERY terminal (success/fail/cancel). The buffers are already out of the map, so no admit
        }
     * {@link ShuffleBufferExceededException} naming the disk ceiling (the new terminal failure when
        }
     * target side to a per-(query,stage,partition,side) spill file under {@link #spillDir} instead of
         * spilled (and budget-released) those bytes. Keeps {@link #currentBytes} equal to the
     *   <li>returns {@link AdmitResult#REJECT_RETRY} if the NODE total would exceed
        // is a disk leak (mirrors the in-memory cleanup). Only the caller that actually removed the
        /**
     * RTTs ≈ 15s worst case). {@link #TOMBSTONE_TTL_NANOS} (120s) is an ~8× margin over that, so the
                // evicted tracks ON-HEAP bytes freed (the eviction target is the heap budget); the
     *
                bytesOnDisk += len + SPILL_FRAME_HEADER_BYTES;
     * remains, so the same bytes are never subtracted twice. Storage happens under admitLock in
                    return chunks;
        if (bytes <= 0) {
 * SPDX-License-Identifier: Apache-2.0
     * tryAdmit, so a buffer's {@code currentBytes} exactly equals its reserved bytes — removeBuffer
        /**
                }
            } catch (IOException e) {
            removed = buffers.remove(key(queryId, targetStageId, partitionIndex));
    private boolean reserveSpillBytes(long size) {
         */
     * are engine-generated UUID-like strings, but defensively strip anything that isn't an
                    // leave the chunk resident and fail (it's still safely in memory/accounted).
        @Override
                Map.Entry<String, ShuffleBuffer> entry = it.next();
                this.out = new BufferedOutputStream(Files.newOutputStream(path));
        // of any prior per-buffer removeBuffer decrements), so the same bytes are never subtracted
        // must outlive any late producer RPC (sender retry window ≈ 15s); 120s is an ~8× margin. A
        }
     * concurrent map's per-key atomicity suffices; expired entries are purged opportunistically in
    }
                        + " — the consumer already snapshotted this partition, so the chunk would be lost. "
         * Wires this buffer's spill identity (lazy — no file is opened here). Once set, a per-query
import java.util.List;
         * {@link ShuffleBufferExceededException} if the node-wide disk ceiling is hit or a write fails.
         * Closing it releases the spill-file stream; it is also closed automatically at clean EOF of
                tail = new ArrayList<>(inMemory);
        // NOT under admitLock, then sweeps + releases UNDER admitLock):
     * {@link #getOrCreateBuffer}) that no consumer will ever drain/remove → a fresh leak, AND reserve
                return new CloseableIterator<>() {
    public long getSpilledTotalBytes() {
                } catch (IOException e) {
    public long getPerQueryMaxBytes() {
 * this file be licensed under the Apache-2.0 license or a
                    // Hard: this query alone can't fit — waiting never helps. Fail fast, non-retryable.
        }
         *
            beginDrain();
    }
         * is buffered and flushed per chunk so a crash-free terminal can always read back the file.
    @Override
                }
import org.opensearch.analytics.spi.ShuffleBufferAccess;
         * Spill state. Null/disabled by default — a buffer only spills when the manager wires its
            }
                Iterator<byte[]> it = tail.iterator();
                    long freed = spillToMakeRoom(buffer, queryId, targetStageId, side, bytesToFree);
import java.util.Collections;
             * written (the side spilled nothing). The caller owns the returned stream and must close
import java.util.concurrent.ConcurrentHashMap;
import java.nio.file.Path;
     *   <li>returns {@link AdmitResult#ACCEPTED} otherwise (reserved + stored).</li>
        private void beginDrain() {
     */
     * that sum (N partitions each under the cap still OOM in aggregate), so admission is gated on:
                buffer.recordRejected();
        if (dir == null || queryId == null) {
     * node's spill files; hitting it (or a disk write I/O error) is the new terminal failure
     * are deleted, so even a buffer that was swept without its own {@code deleteSpillFiles} running
            return leftDoneCount.get();
            } else {
                // synchronizedList: lock the list for the size-check + remove(0) so a concurrent
    public long getQueryBytes(String queryId) {
                }
    public ShuffleBuffer getOrCreateBuffer(String queryId, int targetStageId, int partitionIndex) {
     */
                            break; // clean end of file
        public boolean awaitReady(long timeoutMillis) throws InterruptedException {
        public int getRightDoneCount() {
         * Deletes both sides' spill files (closing their streams first) and returns their on-disk
import java.util.NoSuchElementException;
     * Each {@link ShuffleBuffer} holds the query's shuffled payload as on-heap {@code byte[]} lists;
                out.write((len >>> 16) & 0xFF);
    private void deleteQuerySpillDir(String queryId) {
                buffer.recordRejected();
        void releaseCurrentBytes(long bytes) {
     * on-disk total can't silently grow past the ceiling.
                closeOut();
 * {@link #setBudgets}). The consumer calls {@link ShuffleBuffer#awaitReady} before draining.
    }
 * compatible open source license.
                    try {
    private final Object admitLock = new Object();
         * fragment (correctness over silent under-delivery).
         */
                try {
         * (codex review round-4 BLOCKER #1.) volatile so the spill path sees a set made under the lock.
        for (Map.Entry<String, ShuffleBuffer> e : buffers.entrySet()) {
     * counters can't drift. {@code perQueryBytes} is the single source of truth for a query's
                rightDoneCount.incrementAndGet();
                if (spillEnabled) {
                if (expectedRightSenders >= 0 && rightDoneCount.get() >= expectedRightSenders) {
    /**
                    });
                return 0L;
    /**
    // budget check and over-commit. Scope is the counter check+increment ONLY; storage and drain
                    public void close() {}
         * per-side on-disk files (lazily created on first spill). All spill state mutation happens
        for (var it = aborted.entrySet().iterator(); it.hasNext();) {
     * Configure hash-shuffle disk spill. {@code enabled} is the master switch; {@code directory} is
        // Create via newBuffer so the buffer is spill-capable regardless of WHICH path creates it
                synchronized (inMemory) {
    }
                    in = null;
     * capacity in lockstep, just failing oversized queries earlier) — the remediation is to serialize
        }
             * first so all buffered bytes are flushed. Returns {@code null} if no file was ever
                return null;
    }
         * single chunk is never split — if the oldest chunk alone is larger than {@code targetBytes}
         * file back in write order, then the in-memory tail, reconstructs ARRIVAL order at drain.
    private void recordOrphanedSpill(Path path, long bytes) {
        // Hand back an unstored throwaway so the write lands on a collectible object. (This path is
            @Override
            return new SpillThenTailIterator(spill, tail);
     * cover it) from {@code buffer} to its spill file until at least {@code targetBytes} have been
     * the file (its {@code remove(path)} returned null because we hadn't recorded yet), we release the
                    // If spill couldn't free enough — (a) a SINGLE chunk larger than the budget with
                    close();
                    this.in = spill.openForRead();  // may be null if nothing was written
                } catch (IOException e) {
     * {@link #spillMaxBytes} is checked; exceeding it — or any write I/O error — throws a re-messaged
                    SpilledSide spill = spillFor(side);
        // 0-byte buffer created here never touches disk. This must match tryAdmit's creation path,
                    rightReady.countDown();
            }
        // entry is already out of the map, so no admit/release can race it. deleteSpillFiles returns
            totalBytes.addAndGet(size);
    public enum AdmitResult {
                out.write((len >>> 24) & 0xFF);
        /**
     * exceeding it fails fast and non-retryably). Pass {@code Long.MAX_VALUE} to disable a bound.
     * just as its query was tombstoned, releasing BOTH its on-heap resident bytes and its on-disk spill
     * Records {@code bytes} charged for a spill file at {@code path} whose buffer-level delete FAILED,
         * <p>Called under the manager's {@code admitLock}; the manager releases the returned bytes
        ShuffleBuffer removed;
        totalBytes.accumulateAndGet(bytes, (cur, b) -> Math.max(0, cur - b));
                }
     * bytes under {@link #admitLock} — exactly like {@link #removeBuffer}. {@code computeIfAbsent} may
        // throwaway for a tombstoned query, the tombstone could then be evicted, and the locked
        long spillOldest(String side, long targetBytes) {
            }
                        + " bytes) admitted to an already-draining buffer "
            // The producer's two-phase close (DatafusionPartitionedSink: drain all data sends before
            // snapshotted the in-memory tail, so this chunk would be silently dropped (lost rows).
    // Admission (check-then-reserve) is serialized so concurrent producers can't both pass the
            }
         * chunk is in heap at a time during the spilled phase — that is the property that lets an
            return;
                    combined.addAll(inMemory);
            if (expiry - now > 0) {
     *
                }
        }
                // Release resident bytes — normally 0 (this is the isLast path), but a pre-existing
    /** Node-wide bytes currently written to spill files across all buffers (for observability/tests). */
                leftDoneCount.incrementAndGet();
                    "Shuffle data ("
            private byte[] nextChunk;            // one-chunk lookahead from the file
        }
            public void close() {
            }
                }
         * its append stream, dropping/duplicating rows or NPEing in {@code SpilledSide.append}.
         * from the budget counters (and this buffer's {@link #currentBytes}) under the same lock. A
                    @Override
        synchronized (admitLock) {
            remaining = deadline - System.currentTimeMillis();
                        nextLoaded = true;
     * of every buffer it holds across ALL queries/stages/partitions. A per-buffer cap can't bound
        /**
            q.addAndGet(size);
            }
                    Files.deleteIfExists(path);
                // only come from a prior incarnation that failed to clean up; start fresh.
/**
            // Release the whole query's reserved footprint in one shot (drop its perQueryBytes entry
             */
                }
        ShuffleBuffer buffer = new ShuffleBuffer();
                    // the largest single chunk). Case (b) is caught by the node-budget check just below:
                return tail.next();
        }
        assert Thread.holdsLock(admitLock) : "releaseLocked requires admitLock";
                closeOut();
        if (freed < targetBytes) {
            while (evicted < targetBytes) {
            }
            return draining;
                    // once. Use compute (not remove) so this is atomic vs a concurrent recordOrphanedSpill
         * Stores {@code data} on the named side and tracks this buffer's byte total. Admission /
        /**
import org.opensearch.analytics.spi.CloseableIterator;
            }
    }
                    // After eviction the query's resident footprint is q.get() (already decremented).
            // Conditional remove(k, buffer): only remove if k still maps to OUR buffer. A racing
            SpilledSide(Path path) throws IOException {
     * so {@link #deleteQuerySpillDir} can release them when it (re)deletes the file. Race-safe vs a
        // Resolve the buffer, reserve the bytes, AND store the chunk together under admitLock, keyed
        return true;
            );
                }
        if (spillEnabled && spillDir != null) {
    }
            return;
            // consistent — safe to remove through it; concurrent producer/consumer activity for a still
        return buffer;
                    // byte budget then tracks only the in-memory-resident bytes. Only the DISK ceiling
                out.write(len & 0xFF);
                    byte[] c = nextChunk;
         * file and removes them from the in-memory list until at least {@code targetBytes} have been
            return (existing == null ? 0L : existing) + bytes;
                    byte[] chunk = new byte[len];
                if (entry.getKey().startsWith(prefix)) {
    private final Map<String, AtomicLong> perQueryBytes = new ConcurrentHashMap<>();
        private static CloseableIterator<byte[]> drainSideLazy(SpilledSide spill, List<byte[]> inMemory) {
     */
     * (live tombstones ≈ clear-rate × TTL) and needs no separate ordering structure or lock — the
     * alphanumeric, dash, underscore or dot so a hostile / odd id can't escape {@link #spillDir} via
     * {@code nodeBudget == perQueryMax} (both = {@code node_budget_percent}% of heap). Two legitimate
                        + key(queryId, targetStageId, partitionIndex)
            });
        private SpilledSide rightSpill;
            currentBytes.addAndGet(size);
        }
    /** Bytes currently reserved for {@code queryId} (0 if no reservation / fully released). For
                    }
                byte[] chunk;
        }
        public void addData(String side, byte[] data) {
                        byte[] chunk = new byte[len];
            // Spilled: stream the file chunk-by-chunk, then the in-memory tail. The DataInputStream is
        // amortized across clears. (No separate timer/lock — per-key conditional remove is atomic.)
     */
            // written). If deletion fails (disk/IO error) the bytes still occupy disk, so dropping the
     * Configure the node-level shuffle budget. {@code nodeBudget} caps the total on-heap shuffle
                    long bytesToFree = qProjected - perQueryMaxBytes;
    }
 */
        if (bytes <= 0) {
        ShuffleBuffer removed = null;
                // Soft: node is momentarily full but this query fits its share — retry later.
 */
 * {@link #tryAdmit} gates each chunk against a node-level + per-query byte budget (see
 * The OpenSearch Contributors require contributions made to
     * first-class workload.
                    out = null;
     * {@link #spillMaxBytes}; false otherwise (caller turns that into the terminal disk-ceiling
    // stay outside the lock. Chunk arrival rate is modest (transport RPCs), so this is not hot.
            }
     * the root under which per-query spill subdirs are written ({@code <directory>/<queryId>/});
        private SpilledSide closeAndDelete(SpilledSide spill) {
                if (in != null) {
        }
         * its byte length to split the concatenation back apart on read.
            freed += spillBufferBothSides(sibling, side, targetBytes - freed);
        // computeIfAbsent, so a producer that read not-tombstoned can still insert a key AFTER
                };
     */
                LOGGER.warn("Shuffle right side timed out: received {}/{} senders", rightDoneCount.get(), expectedRightSenders);
            // -running query won't be cleared because only this query's terminal hook calls clearForQuery.
     * enabled, hands it the spill identity (root dir + key components) so it can lazily open per-side
     * spill is enabled).
                    // still charged), the dir sweep just reclaimed the disk — release those bytes exactly
        // repeat clearForQuery (the cancellation-listener backstop firing after normal cleanup)
            public boolean hasNext() {
     */
public class ShuffleBufferManager implements ShuffleBufferRegistry {
         * budget enforcement is owned by the enclosing {@link ShuffleBufferManager#tryAdmit} (node +
                    }
     * The consumer drains spilled chunks back (in arrival order) then the in-memory tail, preserving
        long projected = spilledTotalBytes.get() + size;
    /** Returns {@code size} bytes to the node-wide spill (disk) budget when a spill file is deleted. */
 * (queryId, targetStageId, partitionIndex).
        public void setExpectedSenders(int leftSenders, int rightSenders) {
                        return null; // drop the entry either way — the file is gone
                    // on the same path: whichever runs first removes the entry + releases; the other sees
     */
            }
        // a reservation made in the put-not-yet-visible window; the tombstone only short-circuits
    /**
    }
                this.path = path;
    public void setSpillConfig(boolean enabled, Path directory, long maxBytes) {
                try {
                List<byte[]> spilled = spill.readBack();
            removed.deleteSpillFiles(); // returns on-disk bytes to the node spill budget (I/O, off-lock)
        spilledTotalBytes.addAndGet(size);
     * Reserves {@code size} bytes of node-wide spill (disk) budget. Returns true if it fits under
        // expiry - now > 0 (not now < expiry) to be robust to nanoTime wraparound.
    /**
    private volatile long spillMaxBytes = Long.MAX_VALUE;
            boolean deleted = spill.closeAndDelete();
    }
        public long getCurrentBytes() {
        }
            private OutputStream out;
            // Iterate the entry set and remove matching entries. ConcurrentHashMap's iterator is weakly
        if (!buffer.isDraining()) {
import java.util.concurrent.atomic.AtomicInteger;
         *
            long qProjected = q.get() + size;
            if ("left".equals(side)) {
     * Spills {@code buffer}'s oldest resident chunks (the incoming {@code side} first, then the other
                    // terminal cleanup (which releases bytesOnDisk) would NOT reclaim them → a
     * Per-chunk on-disk framing overhead: each spilled chunk is written as a big-endian 4-byte length
     * several sub-node-budget queries at once) is the future fix if concurrent shuffle becomes a
        // can recreate the on-disk state for this (now tombstoned) query.
        AtomicLong q = perQueryBytes.get(queryId);
     * Sanitizes {@code queryId} into a single safe path segment for the spill subdir name. Query ids
            return rejectedCount.get();
    }
            if (removed != null) {
                        chunks.add(chunk);
            @Override
        }
 * @opensearch.internal
     * in deleting an orphaned path, it releases exactly those bytes (once) — otherwise a transient
                    // releases the evicted chunks' RESERVED bytes (totalBytes + perQueryBytes +
        this.spillMaxBytes = maxBytes;
            public byte[] next() {
            if (totalBytes.get() + size > nodeBudgetBytes) {
            if (sibling == buffer || sibling.isDraining() || !e.getKey().startsWith(stagePrefix)) {
                    releaseLocked(queryId, freed);
    private final AtomicLong totalBytes = new AtomicLong();
                    // (spill.max_bytes / a write I/O error) is terminal — re-messaged below.
     *       share, the producer is told to back off and RETRY (a soft, transient reject: room frees
                    // siblings that are already DRAINING and thus skipped by spillToMakeRoom — then this
         * this buffer (the sibling-spill loop skips {@code draining} buffers). Called at the head of
import java.util.concurrent.TimeUnit;
import java.util.Map;
        public List<byte[]> getLeftData() {
                        }
        // spillOldest releases the spilled bytes from THAT buffer's own currentBytes so removeBuffer
    }
        }
        // (beginDrain), which we hold here, so these reads can't race a half-started drain. A draining
            return drainSide(rightSpill, rightData);
                try (DataInputStream in = new DataInputStream(new BufferedInputStream(Files.newInputStream(path)))) {
     * ({@link #reserveSpillBytes}, {@code SpilledSide.bytesOnDisk}, release) must include this header,
                // addData (other side / other producer) can't shift indices under us.
    @Override
                    it.remove();
         * terminal (removeBuffer / clearForQuery). A leaked .spill file is a disk leak.
             * Reads every spilled chunk back, in write (= arrival) order, deframing on the length
     * the buffer-all contract. {@link #spillMaxBytes} is the hard disk ceiling across all of this
                        break;
                        return it.next();
                    int len = chunk == null ? 0 : chunk.length;
         * <p>Writes happen under the manager's {@code admitLock} (one writer at a time);
        }
 * stores accepted chunks. On-heap budget enforcement is owned by the MANAGER, not the buffer:
        }
                        in.readFully(chunk);
        // - If the put has linearized before our isTombstoned read: we see tombstoned, bail, reserve
                rightData.add(data);
                        len = in.readInt();
                        LOGGER.debug(new ParameterizedMessage("Failed to close shuffle spill read stream {}", spillPath), e);
     */
     * <p><b>Known limitation — concurrent-contention starvation.</b> The plugin wires
                    leftReady.countDown();
                    throw new UncheckedIOException("Failed to read back shuffle spill file " + spillPath, e);
    private ShuffleBuffer newBuffer(String queryId, int targetStageId, int partitionIndex) {
            rightSpill = closeAndDelete(rightSpill);
                }
        }
     * have returned a PRE-EXISTING buffer that already admitted data and SPILLED; a lock-free
         * over-budget partition drain through the consumer's bounded native channel without OOM.
                // CREATE + truncate: a stale file at this exact (query,stage,partition,side) path can
        }
     * Creates a stored buffer for {@code (queryId,targetStageId,partitionIndex)} and, when spill is
     * — on {@link AdmitResult#ACCEPTED} — stores {@code data} into the buffer and reserves the bytes.
                    if (nextChunk != null) {
                // REJECT_RETRY — the producer must not retry a cancelled query.
            private long bytesOnDisk;
         * One side's on-disk spill file: a sequence of length-prefixed Arrow-IPC chunks
        return spillEnabled;
                return AdmitResult.ACCEPTED;
            beginDrain();
            return AdmitResult.ACCEPTED; // nothing to store/reserve (isLast markers carry no data)
            // -1 means "leave unchanged"; allows per-side handlers to set their own count
    public void setBudgets(long nodeBudget, long perQueryMax) {
            // any isLast) makes this unreachable in the normal path, but a buggy/reordered late RPC
        if (size > 0) {
 *
                return AdmitResult.REJECT_RETRY;
    @Override
        // footprint is spread across sibling partitions of the SAME stage. Spill those (non-draining)
            /**
        // in-memory tail or opened the spill file for read, so mutating its lists/spill file here would
     *   <li>{@link #perQueryMaxBytes} — hard ceiling on a SINGLE query's footprint
     * queries one-at-a-time, and failing a contended query is strictly safer than risking a node OOM.
            if (owner != null) {
        this.perQueryMaxBytes = perQueryMax;
         * and deframed from the file (in write = arrival order) FIRST, then the in-memory tail is
    private static String safeSegment(String queryId) {
                    // sibling's removeBuffer frees its budget. Self-correcting, never over-commits heap
        }
     * never spill.
             * prefix. Closes the append stream first so all buffered bytes are flushed.
        /** Wait for both sides' senders to complete. Returns {@code false} on timeout. */
         * (drain/cleanup), so the per-side fields need no further synchronization.
        // entry cleans up — a second remove / a concurrent clearForQuery sweep sees null and skips.
     * releases precisely what was reserved. The max(0,...) floor is purely defensive.
         * under the manager's {@code admitLock} (spill) or after the buffer is out of the map
        // nothing. Safe.
        private Path querySpillDir;
                    }
        }
        // concurrent clearForQuery that already swept it, sees null and releases nothing. This is
                    if (list.isEmpty()) {
        ShuffleBuffer buffer = buffers.computeIfAbsent(k, kk -> newBuffer(queryId, targetStageId, partitionIndex));
        // 1. Spill the RECEIVING buffer first — its incoming-side chunks, then its other side. Each
                    nextLoaded = false;
     * bytes across ALL queries; {@code perQueryMax} caps any single query's footprint (a query
 * configurations where a single node hosts multiple partitions of the same stage (small clusters,
     *   <li>throws {@link ShuffleBufferExceededException} if the query's OWN footprint would exceed
    /**
        }
         */
                return leftSpill;
                    // (codex review BLOCKER: reserved-but-not-written disk-byte leak.)
import java.util.Iterator;
                    // chunk would push past perQueryMaxBytes. Case (a) is accepted (resident bounded by
                    // against a draining buffer. (codex review round-4 BLOCKER #1.)
                }
            long deadline = System.currentTimeMillis() + timeoutMillis;
 * because its dispatch assigns exactly one shuffle partition per node. analytics-engine supports
 * <p>Each {@link ShuffleBuffer} tracks per-side sender completion via {@code CountDownLatch}es and
                    // buffer.currentBytes) via the SAME releaseLocked accounting path removeBuffer
    private static final int SPILL_FRAME_HEADER_BYTES = Integer.BYTES;
                break;
        public int getExpectedLeftSenders() {
         * (correctness over silent under-delivery — matches the eager {@code drainSide}).
                    // total can't silently grow past the ceiling by 4×chunkCount. (codex round-2.)
                checkCompletion("right");
     * without reserving and {@code getOrCreateBuffer} hands back a NON-stored throwaway buffer.
     * one consumer thread drains via {@link #getLeftData} / {@link #getRightData} after
             * it. Used by the LAZY drain path so chunks are read one-at-a-time, never all-resident.
        if (isTombstoned(queryId)) {
                    owner.recordOrphanedSpill(spill.path(), onDisk);
import org.opensearch.analytics.spi.ShuffleBufferExceededException;
     * here. The per-query dir sweep ({@link #deleteQuerySpillDir}) consults this map: when it succeeds
            long evicted = 0L;
        for (Long expiry : aborted.values()) {
        // Delete spill files for every swept buffer + the per-query spill subdir, OUTSIDE admitLock.
                if (leftSpill == null) {
        // twice (codex review: shuffle-budget-double-release).
    }
        boolean isDraining() {
     * second keeps getting {@link AdmitResult#REJECT_RETRY} and, if its peer doesn't drain within the
                    // uses — perQueryBytes stays the single source of truth, no double-release. The
                }
             * Closes the append stream and deletes the spill file. Returns true if the file was deleted
                } catch (IOException e) {
        // /clearForQuery would ever release (codex review: tombstoned-admit-budget-leak via eviction).
            walk.sorted(Collections.reverseOrder()).forEach(p -> {
         * tracked {@link #currentBytes} is read at removal time to release the reservation.
    public int clearForQuery(String queryId) {
     * on-disk total, checked against {@link #spillMaxBytes}.
    private final Map<Path, Long> orphanedSpillBytes = new ConcurrentHashMap<>();
                try {
     * late producer RPC for that query. A late RPC's lifetime is bounded by the sender retry window
                return new DataInputStream(new BufferedInputStream(Files.newInputStream(path)));
        if (removed != null) {
            }
                        in.close();
                synchronized (list) {
                    owner.releaseSpillBytes(diskBytes);
                if (rightSpill == null) {
    public long getNodeBudgetBytes() {
            // Reverse order so children are deleted before their parent directory.
         * Subtracts {@code bytes} from this buffer's resident byte counter after the manager has
        // drop/duplicate rows or NPE in SpilledSide.append. `draining` is flipped under admitLock
            Map.Entry<String, Long> e = it.next();
            if (buffer.isDraining()) {
        buffer.releaseCurrentBytes(freed);
                }
        if (queryId == null) {
    private volatile long nodeBudgetBytes = Long.MAX_VALUE;
    private boolean isTombstoned(String queryId) {
            }
        // else a bare buffer created here would silently disable spill for that partition.
        // what makes per-buffer release (normal drain) and whole-query release (clearForQuery)
     * Per-partition shuffle buffer — a store + completion latches. Thread-safe: multiple senders
                if (in != null) {
        return buffers.get(key(queryId, targetStageId, partitionIndex));
            return true;
        private volatile boolean draining;
             */
            return;
         * acceptable. A spill read error surfaces as an {@link UncheckedIOException} that fails the
                try {
        private static List<byte[]> drainSide(SpilledSide spill, List<byte[]> inMemory) {
                } catch (IOException e) {
            }
                    // Spill enabled: instead of failing fast, evict oldest in-memory chunks of this
     * the subdir never existed.
        // after the clear (abort/cancel) — short-circuits in tryAdmit/getOrCreateBuffer and never
        long now = System.nanoTime();
                }
     *       idle node, so it fails FAST and NON-retryably ({@link ShuffleBufferExceededException}).
     * spill ceiling for later queries. (codex review round-3 BLOCKER #2.) Package-private for a
                if (!Files.exists(path)) {
            @Override
                combined.addAll(spilled);
        // the isLast/senderDone case — it creates a 0-byte buffer and reserves no budget.)
            // getOrCreateBuffer could have replaced the mapping; that thread then owns its buffer's
    /** Current total on-heap shuffle bytes reserved across all buffers (for observability/tests). */
        }
     */
            beginDrain();
import java.io.UncheckedIOException;
        }
        }
     * reservation; removeBuffer decrements it per drained buffer, clearForQuery removes whatever
        try (var walk = Files.walk(queryDir)) {
         * (no owner) just sets the flag. (codex review round-4 BLOCKER #1.)
            }
                }
     *       {@code nodeBudgetBytes} while the query still fits its share (transient contention —
                int len = chunk == null ? 0 : chunk.length;
                    }
import java.util.concurrent.CountDownLatch;
    /**
 * of the key — otherwise two partitions' left/right payloads and {@code isLast} markers would
        REJECT_RETRY
         * through the consumer's bounded native channel rather than re-materializing and OOMing.
            // cleanup, so we must not remove (and mis-account) it.
            }
                return combined;
     * @return the number of buffers removed (for logging / test assertions)
import java.io.BufferedOutputStream;
        return perQueryMaxBytes;
                checkCompletion("right");
     * <ul>
import java.io.EOFException;
        return queryId + ":" + targetStageId + ":" + partitionIndex;
            }
        }
        }
        AtomicLong q = perQueryBytes.get(queryId);
     * side) until at least {@code targetBytes} are freed or the buffer runs dry, releasing the spilled
        String stagePrefix = queryId + ":" + targetStageId + ":";
        }
     */
        private final List<byte[]> leftData = Collections.synchronizedList(new ArrayList<>());
            }
                    totalBytes.accumulateAndGet(freed, (cur, b) -> Math.max(0, cur - b));
 * land in the same buffer and the join would read cross-partition rows + see false completion.
        // non-null buffers.remove) releases its bytes — a second remove of the same key, or a
     */
        private final AtomicLong rejectedCount = new AtomicLong();
     * Because node and per-query budgets are currently the SAME value, lowering
        // If the query was already cleared (cancelled/terminated), do NOT repopulate the map — a late
         * {@code spillToMakeRoom}: once this returns, no concurrent or subsequent spill will evict from
                this.tail = tail.iterator();
            /**
         * the returned iterator and is released on {@link CloseableIterator#close()}), then the
