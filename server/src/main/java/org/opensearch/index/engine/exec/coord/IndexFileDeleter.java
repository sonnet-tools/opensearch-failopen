        for (Map.Entry<String, Set<String>> entry : pendingDeletes.entrySet()) {
                    );
        this.fileDeleter = fileDeleter;
                } catch (IOException e) {
     */
        // Filter out files that were re-referenced since decRefFiles ran
                } catch (IOException e) {
    }
            }
                    safeToDelete.put(formatName, stillDead);
 *   <li>{@link #removeFileReferences} is called when a CatalogSnapshot's refCount reaches 0</li>
     * Scans format directories for files not tracked by any snapshot and deletes them.
            }
                if (refCount.incrementAndGet() == 1) {
    }
 *   <li>Readers (incRef on acquire, decRef on close)</li>
@ExperimentalApi
    private final CommitFileManager commitFileManager;
                    assert (formatRefs == null || formatRefs.containsKey(file) == false) : "File ["
                }
import java.util.ArrayList;
     */
                Set<String> currentPending = pendingDeletes.get(formatName);
import java.io.IOException;
     */
    private final List<CatalogSnapshot> committedSnapshots;
            committedSnapshots.add(committedSnapshot);
        ShardPath shardPath,
        deleteOrphanedFiles(shardPath);
 */
    private final CatalogSnapshotDeletionPolicy deletionPolicy;
    private final FileDeleter fileDeleter;
import java.util.concurrent.atomic.AtomicInteger;
     * Ref count bookkeeping is done under the lock; actual I/O (commit deletion,
                        + " This should never happen — once a segment file's ref count reaches 0, no new snapshot should reference it.";
            logger.debug("Snapshot [gen={}] deleted, unreferenced file cleanup performed", snapshot.getGeneration());
     * Visible for testing.
import org.apache.logging.log4j.Logger;
            cs.markCommitted();
            }
import org.opensearch.index.engine.exec.FilesListener;
                committedSnapshots.remove(old);
    private final Consumer<CatalogSnapshot> onSnapshotDeletedCallback;
        List<CatalogSnapshot> toDelete;
import java.util.Set;
        Map<String, Collection<String>> filesToDelete = new HashMap<>();
            }
                        e
            if (toDelete.isEmpty() == false) {
     */
    /**
                    AtomicInteger refCount = formatRefs.get(file);
        for (Map.Entry<String, Collection<String>> entry : segregated.entrySet()) {
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
                        + "] in format ["
    /**
        List<CatalogSnapshot> toDelete = deletionPolicy.onInit(committedSnapshots);
                committedSnapshots.remove(old);
                        allDeleted.computeIfAbsent(formatName, k -> new HashSet<>()).add(file);
        Map<String, Collection<String>> allDeleted = new HashMap<>();
     * Returns a string representation of this IndexFileDeleter.
            try {
            }
            FilesListener listener = filesListeners.get(entry.getKey());
    /**
    }
                    currentPending.retainAll(stillFailed);
import java.util.HashMap;
            String formatName = entry.getKey();
 * compatible open source license.
            for (String file : entry.getValue()) {
                    logger.warn(() -> new ParameterizedMessage("Retry delete failed for [{}] in format [{}]", file, formatName), e);
                    }
        }
        return copy;
     * Returns a snapshot of the current pending deletes map.
                        () -> fileDeleter.deleteFiles(Map.of(formatName, files))
     * Used after releasing a snapshot hold — the policy may now allow
        synchronized (this) {
            notifyFilesDeleted(successfullyDeleted);
        }
        }
            toDelete = deletionPolicy.onCommit(committedSnapshots);
            if (fileDeleter != null) {
        return cleanUpsPerformed.get();
 * @opensearch.experimental
            }
                    logger.warn(
        CommitFileManager commitFileManager,
        for (CatalogSnapshot cs : initialCommittedSnapshots) {
            if (formatRefs != null) {
                            pendingDeletes.computeIfAbsent(formatName, k -> new HashSet<>()).addAll(failedForFormat);
    private void notifyFilesAdded(Map<String, Collection<String>> newFilesByFormat) throws IOException {
                throw new IllegalStateException("Committed snapshot [gen=" + cs.getGeneration() + "] is already closed");
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
}
                    }
        retryPendingDeletes();
                        toDelete.add(file);
        Map<String, Collection<String>> successfullyDeleted = new HashMap<>();
     * Called once during construction to clean up after a crash between ref-count
    }
    public synchronized boolean hasPendingDeletes() {
    /**
     * blocking concurrent {@link #addFileReferences} and {@link #onCommit} calls.
                    if (refCount != null && refCount.decrementAndGet() == 0) {
     * file deletion, listener notification) is performed outside the lock to avoid
        // needs to read segment files that are about to be deleted.
import java.util.HashSet;
 * Tracks per-format file reference counts and coordinates file deletion
        assert Thread.holdsLock(this);
            notifyFilesDeleted(allDeleted);
        synchronized (this) {
                        }
    }
        }
        Consumer<CatalogSnapshot> onSnapshotDeletedCallback
            for (CatalogSnapshot old : toDelete) {
                Map<String, AtomicInteger> formatRefs = fileRefCounts.get(formatName);
     */
    /**
 */
            committedSnapshots.remove(old);
     * Returns true if there are files awaiting deletion retry.
        }
                else firstException.addSuppressed(e);
        CatalogSnapshotDeletionPolicy deletionPolicy,
    /**
                    );
     * path ({@link #onCommit}, {@link #revisitPolicy}, or init). Allows the owning
                synchronized (this) {
                        () -> fileDeleter.deleteFiles(Map.of(formatName, List.of(file)))
        Map<String, Collection<String>> filesToDelete;
 * </ul>
        for (Map.Entry<String, Collection<String>> entry : segregated.entrySet()) {
                newFiles.put(formatName, added);
 *
 * for pluggable engines. Analogous to Lucene's internal IndexFileDeleter
    // ---- Internal ----
            decRefAndMaybeDelete(old);
    public void incrementCleanUpsPerformed() {
            decRefAndMaybeDelete(old);
        }
    private void executeDeletesWithRetry(Map<String, Collection<String>> filesByFormat) throws IOException {
        for (Map.Entry<String, Collection<String>> entry : safeToDelete.entrySet()) {
 * </ul>
    }
        }
 * <ul>
        if (orphans.isEmpty() == false) {
                }
            Exception firstException = null;
                        () -> new ParameterizedMessage("Failed to delete files for format [{}], adding to pending deletes", formatName),
 * The OpenSearch Contributors require contributions made to
    // ---- Deletion with pending-delete tracking ----
        Map<String, FilesListener> filesListeners,
        FileDeleter fileDeleter,
            if (pendingDeletes.isEmpty()) {
            knownFilesByFormat.put(entry.getKey(), new HashSet<>(entry.getValue().keySet()));
                        + file
     * Called when a CatalogSnapshot is created.
            synchronized (this) {
    public IndexFileDeleter(
     * a file between {@link #decRefFiles} and this call. Files that fail to delete are added
                        + "] in format ["
    /**
        synchronized (this) {
        // because deleteCommit may call DirectoryReader.listCommits() which
        Map<String, Collection<String>> segregated = snapshot.getFilesByFormat();
 * this file be licensed under the Apache-2.0 license or a
    ) throws IOException {
            }
     */
            Collection<String> toDelete = new HashSet<>();
     * filesystem locks.
import java.util.function.Consumer;
     * Visible for testing.
        this(deletionPolicy, fileDeleter, filesListeners, initialCommittedSnapshots, shardPath, commitFileManager, s -> {});
                        pendingDeletes.computeIfAbsent(formatName, k -> new HashSet<>()).addAll(files);
                    } else {
        if (commitFileManager != null && snapshot.isCommitted()) {
 *   <li>The manager (holds one ref as "latest", releases on refresh)</li>
    private void notifyFilesDeleted(Map<String, Collection<String>> deletedFilesByFormat) throws IOException {
    private final Map<String, Map<String, AtomicInteger>> fileRefCounts;
                    Collection<String> failedForFormat = failed.getOrDefault(formatName, Set.of());
                        + "] is pending deletion but has a live ref count."
     * Returns the number of unreferenced file cleanup operations performed.
            } catch (Exception e) {
                listener.onFilesAdded(entry.getValue());
                    if (formatRefs == null || formatRefs.containsKey(file) == false) {
            for (Map.Entry<String, Collection<String>> entry : filesByFormat.entrySet()) {
 * SPDX-License-Identifier: Apache-2.0
    }
import org.apache.logging.log4j.LogManager;
            }
                    }
 *   <li>Commits (incRef on commit, decRef when deletion policy deletes the commit)</li>
                this.removeFileReferences(snapshot);
    private final Map<String, FilesListener> filesListeners;
            executeDeletesWithRetry(filesToDelete);
        List<CatalogSnapshot> initialCommittedSnapshots,
            decRefAndMaybeDelete(old);
                AtomicInteger refCount = formatRefs.computeIfAbsent(file, k -> new AtomicInteger(0));
    public void retryPendingDeletes() throws IOException {
     */
    /**
        CatalogSnapshotDeletionPolicy deletionPolicy,
                for (String file : entry.getValue()) {
    }
                }
            for (CatalogSnapshot old : toDelete) {
            FilesListener listener = filesListeners.get(entry.getKey());
    }
     * Increments the merge failure cleanup counter. Called when a merge fails
        // No synchronization needed — `this` hasn't escaped the constructor yet.
            Set<String> stillFailed = new HashSet<>();
                    }
    public void removeFileReferences(CatalogSnapshot snapshot) throws IOException {
     * Callback invoked when a CatalogSnapshot's refCount reaches 0 via the deletion policy
     * from {@code acquireSnapshotForCommit()} — this method does not incRef again.
        Map<String, Collection<String>> newFiles = new HashMap<>();
        List<CatalogSnapshot> initialCommittedSnapshots,
            for (Map.Entry<String, Set<String>> entry : pendingDeletes.entrySet()) {
    // ---- Policy revisit ----
        Map<String, Set<String>> copy = new HashMap<>();
                String formatName = entry.getKey();
                filesToDelete.put(formatName, toDelete);
import java.util.Map;
        for (Map.Entry<String, Collection<String>> entry : newFilesByFormat.entrySet()) {
/*
    }
        ShardPath shardPath,
            this.committedSnapshots.add(cs);
            }
import java.util.Collection;
                    if (failed.getOrDefault(formatName, Set.of()).contains(file)) {
import org.opensearch.index.engine.exec.FileDeleter;
        synchronized (this) {
                if (firstException == null) firstException = e;
            }
                snapshot.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
    /**
     * Decrements ref counts for its files and deletes files that hit 0.
                try {
        }
                        + "] was pending deletion but is being re-referenced."
 *   <li>{@link #addFileReferences} is called when a CatalogSnapshot is created</li>
        Map<String, Set<String>> snapshot;
                        synchronized (this) {
    }
            try {
    /**
     * Re-runs the deletion policy against the current committed snapshots list.
            }
import org.opensearch.secure_sm.AccessController;
    }
        for (Map.Entry<String, Map<String, AtomicInteger>> entry : fileRefCounts.entrySet()) {
            if (listener != null) {
    }
        FileDeleter fileDeleter,
            }
                if (stillDead.isEmpty() == false) {
            }
            String formatName = entry.getKey();
     * or {@link #retryPendingDeletes} call.
            executeDeletesWithRetry(orphans);
        this.onSnapshotDeletedCallback = onSnapshotDeletedCallback;
        for (CatalogSnapshot old : toDelete) {
                    added.add(file);
    public IndexFileDeleter(
                    }
        this.pendingDeletes = new HashMap<>();
                for (String file : entry.getValue()) {
 *
     * Files that were dereferenced (ref count hit 0) but whose physical deletion
                        stillFailed.add(file);
    public synchronized Map<String, Collection<String>> addFileReferences(CatalogSnapshot snapshot) throws IOException {
                    stillFailed.add(file);
    /**
        List<CatalogSnapshot> toDelete;
            filesToDelete = decRefFiles(snapshot);
            }
     * deletion of commits it previously protected.
        Map<String, FilesListener> filesListeners,
                    if (currentPending.isEmpty()) {
        this.filesListeners = filesListeners;
    synchronized Map<String, Set<String>> getPendingDeletes() {
public class IndexFileDeleter {
            Set<String> files = entry.getValue();
    public long getCleanUpsPerformed() {
 * <p>
                }
            }
                if (currentPending != null) {
     * and its output files are cleaned up.
/**
                    );
    }
            Map<String, AtomicInteger> formatRefs = fileRefCounts.computeIfAbsent(formatName, k -> new HashMap<>());
import org.opensearch.common.annotation.ExperimentalApi;
                    succeeded.removeAll(failedForFormat);
                }
        // Delete the commit point (segments_N) BEFORE deleting data files,
     */
    /**
            Map<String, AtomicInteger> formatRefs = fileRefCounts.get(formatName);
     */
     * @return files whose ref count went from 0 to 1 (newly visible), grouped by format name
     * Can be called periodically or after operations that may have released
            commitFileManager.deleteCommit(snapshot);
        if (filesToDelete.isEmpty() == false) {
     */
     */
                        pendingDeletes.remove(formatName);
package org.opensearch.index.engine.exec.coord;
     * Attempts to delete files. Before deleting, re-checks under the lock that each file
        }
        Map<String, Collection<String>> orphans = OrphanFileScanner.findOrphans(shardPath, knownFilesByFormat, commitFileManager);
    private void deleteOrphanedFiles(ShardPath shardPath) throws IOException {
     * failed. Retried on the next {@link #removeFileReferences}, {@link #revisitPolicy},
     * is still unreferenced — a concurrent {@link #addFileReferences} may have re-referenced
    /**
        for (Map.Entry<String, Set<String>> entry : snapshot.entrySet()) {
     */
    public void revisitPolicy() throws IOException {
import org.opensearch.index.shard.ShardPath;
                return;
                        + formatName
    }
                    }
     * {@link CatalogSnapshotManager} to perform cleanup (e.g., removing from its map,
            }
        }
        }
                listener.onFilesDeleted(entry.getValue());
            if (listener != null) {
            } catch (IOException e) {
        Map<String, Collection<String>> safeToDelete = new HashMap<>();
        }
    private final Map<String, Set<String>> pendingDeletes;
        }
 * <p>
        }
        if (successfullyDeleted.isEmpty() == false) {
                throw new RuntimeException("Failed to clean up snapshot [gen=" + snapshot.getGeneration() + "]", firstException);
        for (CatalogSnapshot old : toDelete) {
        }
 * but driven by {@link CatalogSnapshot} lifecycle instead of Lucene commits.
import org.opensearch.index.engine.exec.CommitFileManager;
import org.apache.logging.log4j.message.ParameterizedMessage;
     * Retries deletion of files that failed to delete on a previous attempt.
                    Map<String, AtomicInteger> formatRefs = fileRefCounts.get(formatName);
        return "IndexFileDeleter{fileRefCounts=" + fileRefCounts + ", committedSnapshots=" + committedSnapshots.size() + "}";
        for (CatalogSnapshot old : toDelete) {
                    Collection<String> succeeded = new HashSet<>(files);
            Collection<String> added = new HashSet<>();
     * Called when a CatalogSnapshot's refCount reaches 0.
        cleanUpsPerformed.incrementAndGet();
    private final AtomicLong cleanUpsPerformed = new AtomicLong(0);
        }
                        + " This should never happen — once a segment file's ref count reaches 0, no new snapshot should reference it.";
                    if (succeeded.isEmpty() == false) {
                }
    // ---- Commit path ----
            for (String file : files) {
        }
        this.fileRefCounts = new HashMap<>();
            // Take a snapshot of pending deletes to process outside the lock
            }
        Map<String, Collection<String>> segregated = snapshot.getFilesByFormat();
                    synchronized (this) {
        for (Map.Entry<String, Collection<String>> entry : deletedFilesByFormat.entrySet()) {
                firstException = e;
            copy.put(entry.getKey(), new HashSet<>(entry.getValue()));
        CommitFileManager commitFileManager
    public String toString() {
                    assert pendingDeletes.getOrDefault(formatName, Set.of()).contains(file) == false : "File ["
    private static final Logger logger = LogManager.getLogger(IndexFileDeleter.class);
                try {
    ) throws IOException {
     * A CatalogSnapshot has been committed (flushed). The commit ref is the incRef
        }
        if (snapshot.decRef()) {
            toDelete = deletionPolicy.onCommit(committedSnapshots);
     * to {@link #pendingDeletes} for retry. Successfully deleted files trigger listener notification.
     * Snapshots the policy wants to delete get their commit ref decRef'd,
    private Map<String, Collection<String>> decRefFiles(CatalogSnapshot snapshot) {
    @Override
        }
        if (allDeleted.isEmpty() == false) {
    }
    /**
                }
                        + formatName
            if (cs.tryIncRef() == false) {
        }
                    Map<String, Collection<String>> failed = AccessController.doPrivilegedChecked(
                }
                        + file
        return filesToDelete;
     *
            String formatName = entry.getKey();
            snapshot = new HashMap<>();
                // Assert: a file in pendingDeletes must not be re-referenced
            if (firstException != null) {
        // Also retry any previously failed deletes
        }
                        successfullyDeleted.put(formatName, succeeded);
            if (added.isEmpty() == false) {
        return newFiles;
    // ---- File ref counting ----
        notifyFilesAdded(newFiles);
    }
    void decRefAndMaybeDelete(CatalogSnapshot snapshot) {
     * Adds to the committed list, then delegates to the deletion policy.
                    if (failedForFormat.isEmpty() == false) {
     * notifying lifecycle listeners to close readers).
    public void onCommit(CatalogSnapshot committedSnapshot) throws IOException {
        synchronized (this) {
 * <ul>
        }
        this.committedSnapshots = new ArrayList<>();
        this.deletionPolicy = deletionPolicy;
     */
                    }
     * decrement and physical deletion.
            addFileReferences(cs);
        Map<String, Set<String>> knownFilesByFormat = new HashMap<>();
 * CatalogSnapshot refCount is managed by:
     * Increments ref counts for all its files.
                Collection<String> stillDead = new HashSet<>();
 * File ref counts are managed at the CatalogSnapshot level:
                        formatRefs.remove(file);
                onSnapshotDeletedCallback.accept(snapshot);
            Collection<String> files = entry.getValue();
     */
                    Map<String, Collection<String>> failed = AccessController.doPrivilegedChecked(
     * <p>
        this.commitFileManager = commitFileManager;
            }
        return pendingDeletes.isEmpty() == false;
            String formatName = entry.getKey();
                        stillDead.add(file);
    }
     * which may trigger removeFileReferences when their refCount reaches 0.
