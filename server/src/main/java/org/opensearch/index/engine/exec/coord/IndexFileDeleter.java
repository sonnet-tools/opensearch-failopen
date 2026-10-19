                    );
                }
     * Visible for testing.  
                        + formatName  
        Map<String, Collection<String>> segregated = snapshot.getFilesByFormat();
                    AtomicInteger refCount = formatRefs.get(file);
    public void revisitPolicy() throws IOException {
                    if (refCount != null && refCount.decrementAndGet() == 0) {  
            }  
                firstException = e;
    /**
import java.util.Collection;
        }  
        return copy;
            toDelete = deletionPolicy.onCommit(committedSnapshots);
                    stillFailed.add(file);
        }
    ) throws IOException {
        Map<String, Collection<String>> newFiles = new HashMap<>();
                    added.add(file);
 *
            snapshot = new HashMap<>();
            }
                    }  
        return cleanUpsPerformed.get();  
 * compatible open source license.
            Set<String> stillFailed = new HashSet<>();
        this.filesListeners = filesListeners;
        synchronized (this) {  
import java.util.HashSet;
                    }  
                    succeeded.removeAll(failedForFormat);
        for (CatalogSnapshot old : toDelete) {  
 *
     */  
                        + file
import org.opensearch.common.annotation.ExperimentalApi;
                        + "] is pending deletion but has a live ref count."
     */  
        }
                }  
import org.opensearch.index.engine.exec.FilesListener;
import java.util.ArrayList;
}
     * Retries deletion of files that failed to delete on a previous attempt.  
     */  
     * which may trigger removeFileReferences when their refCount reaches 0.
    }  
    /**
     * and its output files are cleaned up.
        }
        Map<String, FilesListener> filesListeners,  
            if (listener != null) {
     * failed. Retried on the next {@link #removeFileReferences}, {@link #revisitPolicy},
    public synchronized boolean hasPendingDeletes() {  
    }
                }
                throw new RuntimeException("Failed to clean up snapshot [gen=" + snapshot.getGeneration() + "]", firstException);
        assert Thread.holdsLock(this);  
/**  
                if (currentPending != null) {  
    /**
    private final Consumer<CatalogSnapshot> onSnapshotDeletedCallback;
import org.opensearch.secure_sm.AccessController;
                        synchronized (this) {
        List<CatalogSnapshot> toDelete = deletionPolicy.onInit(committedSnapshots);  
     * path ({@link #onCommit}, {@link #revisitPolicy}, or init). Allows the owning  
                } catch (IOException e) {
 *   <li>The manager (holds one ref as "latest", releases on refresh)</li>
                    currentPending.retainAll(stillFailed);
/*  
    /**
 * File ref counts are managed at the CatalogSnapshot level:
    // ---- Policy revisit ----  
 *   <li>{@link #removeFileReferences} is called when a CatalogSnapshot's refCount reaches 0</li>
        }
            String formatName = entry.getKey();
            if (firstException != null) {  
     * deletion of commits it previously protected.
     * Scans format directories for files not tracked by any snapshot and deletes them.
     *
            }  
        List<CatalogSnapshot> initialCommittedSnapshots,  
    }
            for (String file : entry.getValue()) {
                        stillFailed.add(file);
    /**
                Collection<String> stillDead = new HashSet<>();
import org.opensearch.index.engine.exec.CommitFileManager;  
     * Increments ref counts for all its files.
    private void notifyFilesDeleted(Map<String, Collection<String>> deletedFilesByFormat) throws IOException {
    }
        this.fileDeleter = fileDeleter;  
     * Decrements ref counts for its files and deletes files that hit 0.  
                    safeToDelete.put(formatName, stillDead);
        }  
                        + " This should never happen — once a segment file's ref count reaches 0, no new snapshot should reference it.";
import java.util.List;
                } catch (IOException e) {
     */  
     * Ref count bookkeeping is done under the lock; actual I/O (commit deletion,
                if (stillDead.isEmpty() == false) {
 *   <li>Commits (incRef on commit, decRef when deletion policy deletes the commit)</li>  
@ExperimentalApi
            } catch (Exception e) {  
package org.opensearch.index.engine.exec.coord;
                listener.onFilesAdded(entry.getValue());
        }  
    public IndexFileDeleter(
            if (toDelete.isEmpty() == false) {  
            }
     * or {@link #retryPendingDeletes} call.
     */
     * Used after releasing a snapshot hold — the policy may now allow
    /**
                    Map<String, Collection<String>> failed = AccessController.doPrivilegedChecked(  
    /**
            }  
        // Delete the commit point (segments_N) BEFORE deleting data files,
    private final Map<String, FilesListener> filesListeners;
        }
        Map<String, Collection<String>> orphans = OrphanFileScanner.findOrphans(shardPath, knownFilesByFormat, commitFileManager);
                    assert (formatRefs == null || formatRefs.containsKey(file) == false) : "File ["
            for (Map.Entry<String, Collection<String>> entry : filesByFormat.entrySet()) {
            Collection<String> added = new HashSet<>();
                        + "] in format ["
     * Increments the merge failure cleanup counter. Called when a merge fails
            try {
import org.opensearch.index.engine.exec.FileDeleter;
     * decrement and physical deletion.
                committedSnapshots.remove(old);  
    }
            Collection<String> toDelete = new HashSet<>();  
import java.util.Set;
     * notifying lifecycle listeners to close readers).
                        () -> fileDeleter.deleteFiles(Map.of(formatName, List.of(file)))
        synchronized (this) {  
     */
        notifyFilesAdded(newFiles);  
        }  
                for (String file : entry.getValue()) {
        Map<String, Collection<String>> filesToDelete = new HashMap<>();
        // No synchronization needed — `this` hasn't escaped the constructor yet.
            commitFileManager.deleteCommit(snapshot);  
        synchronized (this) {
    }
            decRefAndMaybeDelete(old);  
        for (Map.Entry<String, Collection<String>> entry : deletedFilesByFormat.entrySet()) {
    public void removeFileReferences(CatalogSnapshot snapshot) throws IOException {  
                    } else {
     */
        this.commitFileManager = commitFileManager;
                            pendingDeletes.computeIfAbsent(formatName, k -> new HashSet<>()).addAll(failedForFormat);  
    }  
        deleteOrphanedFiles(shardPath);  
    /**  
                    }
        }
                    Collection<String> failedForFormat = failed.getOrDefault(formatName, Set.of());  
import org.opensearch.index.engine.exec.CatalogSnapshotDeletionPolicy;
 * this file be licensed under the Apache-2.0 license or a
     * from {@code acquireSnapshotForCommit()} — this method does not incRef again.
 * <ul>  
     * Returns a snapshot of the current pending deletes map.
     * blocking concurrent {@link #addFileReferences} and {@link #onCommit} calls.
        return pendingDeletes.isEmpty() == false;
            cs.markCommitted();  
     * Returns the number of unreferenced file cleanup operations performed.  
        }  
        for (Map.Entry<String, Collection<String>> entry : segregated.entrySet()) {  
                    }
     */
                return;
            for (Map.Entry<String, Set<String>> entry : pendingDeletes.entrySet()) {  
     */
                committedSnapshots.remove(old);  
     * Can be called periodically or after operations that may have released
import java.io.IOException;  
    private final Map<String, Set<String>> pendingDeletes;
    public synchronized Map<String, Collection<String>> addFileReferences(CatalogSnapshot snapshot) throws IOException {
                    );
     * Returns a string representation of this IndexFileDeleter.
                        e
    }
     * Called when a CatalogSnapshot is created.  
        FileDeleter fileDeleter,
                        + file
 */  
 * <ul>  
        if (snapshot.decRef()) {
    }
            }  
     * a file between {@link #decRefFiles} and this call. Files that fail to delete are added  
        Map<String, Collection<String>> allDeleted = new HashMap<>();
                else firstException.addSuppressed(e);
        ShardPath shardPath,
        // because deleteCommit may call DirectoryReader.listCommits() which  
        Map<String, Collection<String>> filesToDelete;
 * <p>
            }
                    Collection<String> succeeded = new HashSet<>(files);  
    /**
    private void executeDeletesWithRetry(Map<String, Collection<String>> filesByFormat) throws IOException {  
     */
     */
    }
    /**  
            executeDeletesWithRetry(orphans);
                        + "] was pending deletion but is being re-referenced."
        // Filter out files that were re-referenced since decRefFiles ran
    /**
     */  
        }
    public void onCommit(CatalogSnapshot committedSnapshot) throws IOException {  
        Map<String, Collection<String>> segregated = snapshot.getFilesByFormat();  
            }
        Map<String, Set<String>> copy = new HashMap<>();  
                    if (currentPending.isEmpty()) {
    }
import org.apache.logging.log4j.Logger;
        CommitFileManager commitFileManager,
            addFileReferences(cs);
    // ---- File ref counting ----  
                synchronized (this) {
                    }
        List<CatalogSnapshot> toDelete;
    // ---- Commit path ----  
        return "IndexFileDeleter{fileRefCounts=" + fileRefCounts + ", committedSnapshots=" + committedSnapshots.size() + "}";  
     * A CatalogSnapshot has been committed (flushed). The commit ref is the incRef  
            // Take a snapshot of pending deletes to process outside the lock
    /**
                    Map<String, Collection<String>> failed = AccessController.doPrivilegedChecked(  
    private final AtomicLong cleanUpsPerformed = new AtomicLong(0);
            Set<String> files = entry.getValue();
            committedSnapshots.remove(old);
            synchronized (this) {
            notifyFilesDeleted(allDeleted);  
            toDelete = deletionPolicy.onCommit(committedSnapshots);
        ShardPath shardPath,
    }
                if (refCount.incrementAndGet() == 1) {
            String formatName = entry.getKey();
     * is still unreferenced — a concurrent {@link #addFileReferences} may have re-referenced
 * for pluggable engines. Analogous to Lucene's internal IndexFileDeleter
    }  
    private final CatalogSnapshotDeletionPolicy deletionPolicy;
            copy.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
 * Tracks per-format file reference counts and coordinates file deletion
 */
import java.util.concurrent.atomic.AtomicLong;  
                        toDelete.add(file);
            FilesListener listener = filesListeners.get(entry.getKey());  
    private void deleteOrphanedFiles(ShardPath shardPath) throws IOException {  
     * Called once during construction to clean up after a crash between ref-count  
                        formatRefs.remove(file);
        }
    private final List<CatalogSnapshot> committedSnapshots;
    }  
        }
            }
            notifyFilesDeleted(successfullyDeleted);
            committedSnapshots.add(committedSnapshot);  
            }  
            String formatName = entry.getKey();
            try {  
            }
import java.util.concurrent.atomic.AtomicInteger;
                }  
                        () -> fileDeleter.deleteFiles(Map.of(formatName, files))
                    if (succeeded.isEmpty() == false) {
    }
     * Re-runs the deletion policy against the current committed snapshots list.  
                        successfullyDeleted.put(formatName, succeeded);  
                    if (failed.getOrDefault(formatName, Set.of()).contains(file)) {  
                newFiles.put(formatName, added);  
        for (CatalogSnapshot old : toDelete) {
                this.removeFileReferences(snapshot);
 * @opensearch.experimental  
    private void notifyFilesAdded(Map<String, Collection<String>> newFilesByFormat) throws IOException {
            logger.debug("Snapshot [gen={}] deleted, unreferenced file cleanup performed", snapshot.getGeneration());  
 *   <li>{@link #addFileReferences} is called when a CatalogSnapshot is created</li>
            }
        if (commitFileManager != null && snapshot.isCommitted()) {
            }
    public IndexFileDeleter(  
    }
     * Files that were dereferenced (ref count hit 0) but whose physical deletion  
        this.deletionPolicy = deletionPolicy;
        retryPendingDeletes();  
                    );  
        }
            FilesListener listener = filesListeners.get(entry.getKey());  
     * Callback invoked when a CatalogSnapshot's refCount reaches 0 via the deletion policy
                Map<String, AtomicInteger> formatRefs = fileRefCounts.get(formatName);  
            executeDeletesWithRetry(filesToDelete);  
                    logger.warn(() -> new ParameterizedMessage("Retry delete failed for [{}] in format [{}]", file, formatName), e);  
    public long getCleanUpsPerformed() {
        for (Map.Entry<String, Map<String, AtomicInteger>> entry : fileRefCounts.entrySet()) {
 * <p>
    // ---- Deletion with pending-delete tracking ----
                }
                    if (failedForFormat.isEmpty() == false) {
                filesToDelete.put(formatName, toDelete);
        FileDeleter fileDeleter,
     * {@link CatalogSnapshotManager} to perform cleanup (e.g., removing from its map,
                // Assert: a file in pendingDeletes must not be re-referenced
        CatalogSnapshotDeletionPolicy deletionPolicy,
        cleanUpsPerformed.incrementAndGet();
            Map<String, AtomicInteger> formatRefs = fileRefCounts.computeIfAbsent(formatName, k -> new HashMap<>());  
            Exception firstException = null;  
import org.opensearch.index.shard.ShardPath;  
 * </ul>
                    logger.warn(  
     * filesystem locks.
                        () -> new ParameterizedMessage("Failed to delete files for format [{}], adding to pending deletes", formatName),
                try {
 * CatalogSnapshot refCount is managed by:
            }
     * file deletion, listener notification) is performed outside the lock to avoid  
                    synchronized (this) {
    public String toString() {
        }
     */  
        CommitFileManager commitFileManager  
     * to {@link #pendingDeletes} for retry. Successfully deleted files trigger listener notification.
                AtomicInteger refCount = formatRefs.computeIfAbsent(file, k -> new AtomicInteger(0));  
    void decRefAndMaybeDelete(CatalogSnapshot snapshot) {
        Consumer<CatalogSnapshot> onSnapshotDeletedCallback  
        if (allDeleted.isEmpty() == false) {
                    }
    synchronized Map<String, Set<String>> getPendingDeletes() {
            for (CatalogSnapshot old : toDelete) {
        return newFiles;
        Map<String, Set<String>> snapshot;
                Set<String> currentPending = pendingDeletes.get(formatName);
        for (Map.Entry<String, Set<String>> entry : snapshot.entrySet()) {
            decRefAndMaybeDelete(old);
        Map<String, Set<String>> knownFilesByFormat = new HashMap<>();
            if (added.isEmpty() == false) {
        return filesToDelete;
        if (successfullyDeleted.isEmpty() == false) {
                String formatName = entry.getKey();
                        stillDead.add(file);
            for (CatalogSnapshot old : toDelete) {
     * Returns true if there are files awaiting deletion retry.  
            if (pendingDeletes.isEmpty()) {
    private final FileDeleter fileDeleter;  
        synchronized (this) {
    ) throws IOException {
        for (CatalogSnapshot old : toDelete) {
                }
                        pendingDeletes.computeIfAbsent(formatName, k -> new HashSet<>()).addAll(files);
        // needs to read segment files that are about to be deleted.
        Map<String, Collection<String>> successfullyDeleted = new HashMap<>();  
        for (CatalogSnapshot cs : initialCommittedSnapshots) {
 *   <li>Readers (incRef on acquire, decRef on close)</li>
public class IndexFileDeleter {  
        }
        Map<String, Collection<String>> safeToDelete = new HashMap<>();
                        }
            Collection<String> files = entry.getValue();  
    @Override
    public void incrementCleanUpsPerformed() {
     * Visible for testing.
        this(deletionPolicy, fileDeleter, filesListeners, initialCommittedSnapshots, shardPath, commitFileManager, s -> {});
     * Adds to the committed list, then delegates to the deletion policy.
        Map<String, FilesListener> filesListeners,
            this.committedSnapshots.add(cs);
                    if (formatRefs == null || formatRefs.containsKey(file) == false) {  
        this.pendingDeletes = new HashMap<>();
                for (String file : entry.getValue()) {
    private final Map<String, Map<String, AtomicInteger>> fileRefCounts;
        for (Map.Entry<String, Set<String>> entry : pendingDeletes.entrySet()) {
                    Map<String, AtomicInteger> formatRefs = fileRefCounts.get(formatName);  
     * Attempts to delete files. Before deleting, re-checks under the lock that each file
            filesToDelete = decRefFiles(snapshot);  
     * @return files whose ref count went from 0 to 1 (newly visible), grouped by format name  
                throw new IllegalStateException("Committed snapshot [gen=" + cs.getGeneration() + "] is already closed");
            knownFilesByFormat.put(entry.getKey(), new HashSet<>(entry.getValue().keySet()));  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.message.ParameterizedMessage;  
                onSnapshotDeletedCallback.accept(snapshot);
                        pendingDeletes.remove(formatName);  
                        allDeleted.computeIfAbsent(formatName, k -> new HashSet<>()).add(file);  
            } catch (IOException e) {
        if (filesToDelete.isEmpty() == false) {
    }
    /**
            }
                }  
        for (Map.Entry<String, Collection<String>> entry : newFilesByFormat.entrySet()) {
            Map<String, AtomicInteger> formatRefs = fileRefCounts.get(formatName);
        if (orphans.isEmpty() == false) {  
        synchronized (this) {  
    public void retryPendingDeletes() throws IOException {
            String formatName = entry.getKey();  
    }
            }
 * The OpenSearch Contributors require contributions made to  
                }
            }
            if (listener != null) {
                listener.onFilesDeleted(entry.getValue());
        this.fileRefCounts = new HashMap<>();
                    }
    private final CommitFileManager commitFileManager;  
            if (formatRefs != null) {  
        for (Map.Entry<String, Collection<String>> entry : safeToDelete.entrySet()) {
            }
        }
     * <p>
        }  
        List<CatalogSnapshot> initialCommittedSnapshots,
    private static final Logger logger = LogManager.getLogger(IndexFileDeleter.class);
        for (Map.Entry<String, Collection<String>> entry : segregated.entrySet()) {
        this.committedSnapshots = new ArrayList<>();  
        CatalogSnapshotDeletionPolicy deletionPolicy,  
                try {
                    assert pendingDeletes.getOrDefault(formatName, Set.of()).contains(file) == false : "File ["  
        this.onSnapshotDeletedCallback = onSnapshotDeletedCallback;  
import org.apache.logging.log4j.LogManager;
        }
import java.util.Map;  
                if (firstException == null) firstException = e;  
            decRefAndMaybeDelete(old);
     * Called when a CatalogSnapshot's refCount reaches 0.
                snapshot.put(entry.getKey(), new HashSet<>(entry.getValue()));
import java.util.HashMap;  
                        + formatName
        }
        // Also retry any previously failed deletes
        List<CatalogSnapshot> toDelete;
            for (String file : files) {  
    /**
        }  
    // ---- Internal ----  
                        + "] in format ["  
     * Snapshots the policy wants to delete get their commit ref decRef'd,  
 * </ul>  
            if (fileDeleter != null) {
    private Map<String, Collection<String>> decRefFiles(CatalogSnapshot snapshot) {
            if (cs.tryIncRef() == false) {  
                        + " This should never happen — once a segment file's ref count reaches 0, no new snapshot should reference it.";  
 * but driven by {@link CatalogSnapshot} lifecycle instead of Lucene commits.  
import java.util.function.Consumer;
     */
