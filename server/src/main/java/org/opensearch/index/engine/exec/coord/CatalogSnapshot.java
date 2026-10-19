     */
    public Map<String, Collection<String>> getFilesByFormat() {
            long liveRows = counts != null ? counts.liveDocs() : numRows;
     *
        out.writeLong(version);
    }
 */
     * into a synthetic {@code SegmentInfos} or building a {@code ReplicationCheckpoint}.
    public abstract String getLastCommitFileName();
     * Package-private — only called by {@link IndexFileDeleter} and {@link CatalogSnapshotManager}.
    /**
     * iteration over segments on every add/remove call.
    public Map<String, Long> collectFileSizesGroupedByExtension(Store store) {
import java.util.HashMap;
     * Resolves whether this snapshot has been committed by comparing its ID
        return refCounter.tryIncRef();
     * All segments are marked as searchable. Committed state is determined by comparing this snapshot's ID
     */
     * @param userData map of user data key-value pairs
    private final AbstractRefCounted refCounter;
    /**
     * Format-neutral: Lucene-backed snapshots use {@code segments_N} but callers must not
import org.opensearch.common.annotation.ExperimentalApi;
                liveDocs += physicalRows(segment);
     * @param dataFormat the data format identifier
        return null;
        long deletedDocs = 0L;
                    String dirFile = org.opensearch.index.store.FileMetadata.serialize(formatName, file);
            }
                    String dirFile = org.opensearch.index.store.FileMetadata.serialize(formatName, file);
     */
    /**
     * @param format           the data format name (e.g. {@code "parquet"})
 * Maintains versioned information about segments, files, and metadata for index operations.
    /**
    public long getGeneration() {
        for (Segment segment : getSegments()) {
        if (lastDot == -1 || lastDot == fileName.length() - 1) {
import org.opensearch.core.common.io.stream.Writeable;
     * {@code major * 1_000_000 + minor * 1_000 + bugfix}. Returns {@code 0} to indicate
    protected final long generation;
     * Called when the reference count reaches zero. Subclasses should release any resources here.
    public abstract long getMinSegmentFormatVersion();
    public abstract void setUserData(Map<String, String> userData, boolean commitData);
     * <p>
                        logger.warn(() -> "Failed to read size for file [" + dirFile + "]; reporting 0", e);
        Map<String, Collection<String>> cached = this.filesByFormatCache;
    /**
     * against the last committed snapshot ID stored in commit data.
     * @return the catalog snapshot ID
    public Map<String, Long> collectFileSizes(Store store) {
     * Returns whether this snapshot was committed.
     * @return true if the snapshot ID matches the last committed snapshot ID
     * Returns the current reference count.
     *        a segment absent from this map reports all of its rows live and none deleted
            // append-only index where nothing is ever hidden.
        Sort indexSort,
     * @param commitData whether this is commit-level user data
    protected abstract void closeInternal();
     * @return map of user data key-value pairs
     * @return collection of WriterFileSet objects for the specified format
        Map<String, Long> allFileSizes = new java.util.HashMap<>();
            } else {
     * Gets the unique identifier for this catalog snapshot.
     * Package-private — only called by {@link IndexFileDeleter} and {@link CatalogSnapshotManager}.
        }
    }
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
            DocCounts counts = docCountsByGeneration.get(segment.generation());
        boolean isCommitted = resolveIsCommitted(lastCommitData);
        return getGeneration();
     */
}
            // No liveness source for this segment: every row counts as live, matching an
     */
    public void writeTo(StreamOutput out) throws IOException {
        }
            unmodifiable.put(entry.getKey(), Collections.unmodifiableSet(entry.getValue()));
            return false;
     * @throws IOException in case of I/O error
    /**
    boolean tryIncRef() {
            return getId() == Long.parseLong(lastCommittedIdStr);
     * "unknown / pre-versioning" (callers map this to {@link org.apache.lucene.util.Version#LATEST}).
 * compatible open source license.
     * against the last committed snapshot ID stored in commit data.
     *
                        allFileSizes.put(file, store.directory().fileLength(dirFile));
import org.opensearch.index.store.Store;
     */
    public long getLastCommitGeneration() {
     * @param includeSegmentsFile whether to include the segments file in the returned collection
import org.opensearch.core.common.io.stream.StreamInput;
     * Key for storing catalog snapshot in user data.
        this.committed = true;
    public static final String CATALOG_SNAPSHOT_KEY = "_catalog_snapshot_";
    public DocCounts aggregateDocCounts(Map<Long, DocCounts> docCountsByGeneration) {
    }
     */
 * Subclasses must implement {@link #closeInternal()} for resource cleanup and methods for
     * For {@code SegmentInfosCatalogSnapshot}, this is the Lucene generation from {@code SegmentInfos}.
     * Package-private — managed by {@link IndexFileDeleter}.
     *
     * Each subclass formats names appropriately for its data format:
     * and {@link #closeInternal()} was invoked.
     * @param docCountsByGeneration per-generation live and deleted counts from
    /**
     * hash-full-file step when this is {@code null}.
    /**
    public abstract List<Segment> getSegments();
    }
            protected void closeInternal() {
     * @return map of individual file names to their sizes
        long liveDocs = 0L;
                liveDocs += counts.liveDocs();
     * Returns the canonical file names for upload to remote store.
    // Package-private ref counting — only accessible within exec.coord (i.e., CatalogSnapshotManager)
     *
    /**
    /**
     * Gets all data formats present in this catalog snapshot.
    boolean isCommitted() {
    public abstract long getId();
            }
 * a reference-counted handle, and close the returned {@link org.opensearch.common.concurrent.GatedCloseable}
 * when done. The manager handles all reference counting internally.</p>
/*
     * @param store the store to resolve file sizes from
     * assume any naming convention. {@code MetadataSnapshot.loadMetadata} skips the
                    grouped.merge(extension, size, Long::sum);
        }
     * rather than broken down by internal sub-file format. This is a known limitation.
     *
            return false;
        }
            seg.version = org.apache.lucene.util.Version.LATEST;
            }
     * matches, or {@code null} if no segment carries a non-empty file set for that format/generation.
            seg.search = true;
    private static String extractExtension(String fileName) {
    /**
        this.generation = in.readLong();
            }
            return candidate;
        }
     * Subclasses must ensure all mutable state is properly copied.
@ExperimentalApi
            seg.sizeInBytes = dfSeg.dfGroupedSearchableFiles().values().stream().mapToLong(WriterFileSet::getTotalSize).sum();
     *
    /**
                        allFileSizes.put(file, 0L);
     */
     * Whether this snapshot has been committed (persisted via flush).
    boolean decRef() {
     *
     * Key for storing catalog snapshot ID in user data.
                String formatName = entry.getKey();
    /**
     *
        try {
     * @throws IOException if an I/O error occurs
     * @return set of data format identifiers
import org.apache.lucene.search.Sort;
    }
    @Override
                    } catch (java.io.IOException e) {
            if (dfSeg.dfGroupedSearchableFiles().isEmpty()) {
import org.opensearch.index.engine.exec.Segment;
     */
            WriterFileSet candidate = seg.dfGroupedSearchableFiles().get(format);
    public abstract long getLastWriterGeneration();
            result.add(seg);
                        size = store.directory().fileLength(dirFile);
     * Sets user-defined metadata for this catalog snapshot.
     * @param in the stream input to read from
    /**
     * @return unmodifiable map of format name to unmodifiable set of file names
    /**
    }
                String formatName = entry.getKey();
 * Use {@link org.opensearch.index.engine.exec.coord.CatalogSnapshotManager#acquireSnapshot()} to obtain
     * Returns all file names grouped by data format name. The result is computed once
        };
            seg.committed = isCommitted;
     */
     * catalogs or when no commit has landed yet. Callers decode via
     *   <li>{@link SegmentInfosCatalogSnapshot}: plain Lucene file names (e.g., {@code "_0.cfe"})</li>
    /**
        for (Segment dfSeg : getSegments()) {
    /**
    /**
    /**
     * @return the format version string
        List<org.opensearch.index.engine.Segment> result = new java.util.ArrayList<>(getSegments().size());
     * <p>
                }
                    }
     */
     * @return the matching file set, or {@code null}
     * Used by {@code IndexFileDeleter} for ref-count bookkeeping, avoiding repeated
     */
 */
        return version;
     * Constructs a CatalogSnapshot from a {@link StreamInput}.
     * Note: Compound files (e.g., Lucene .cfs) are reported under their physical extension
     * Returns the commit-time format version as a long-encoded value
     * @param indexSort      the index sort, or null if unsorted
    public abstract CatalogSnapshot clone();
                    } catch (java.io.IOException e) {
     * @return list of engine segments sorted by generation
                    }
    }
     *
        }
import java.util.Map;
import java.util.Collection;
    /**
     * @return live and deleted totals for the whole snapshot
     * </ul>
     * For {@code DataformatAwareCatalogSnapshot}, this is the generation set via
     * Builds a list of {@link org.opensearch.index.engine.Segment} from this catalog snapshot's segments.
     *
    protected static long physicalRows(Segment segment) {
 * Abstract base class representing a snapshot of the catalog state at a specific point in time.
     *
                        logger.warn(() -> "Failed to read size for file [" + dirFile + "]; reporting 0", e);
     * {@link LuceneVersionConverter#toLuceneOrLatest(long)} when a Lucene view is needed.
     * segment carries.
     * (e.g., compound files show underlying format extensions in descriptions),
    public static final String CATALOG_SNAPSHOT_ID = "_id";
     * @return collection of file name strings ready for upload
        return generation;
 * Uses an internal reference counter for safe concurrent access.
import java.util.List;
     * Encoding is defined by {@link LuceneVersionConverter}:
        return new DocCounts(liveDocs, deletedDocs);
        Map<String, Long> grouped = new HashMap<>();
     * @return the last writer generation
     */
     * Name of the top-level commit file, or {@code null} if not yet committed.
            @Override
     * @return list of Segment objects
import java.util.HashSet;
     */
        }
     */
        Map<Long, DocCounts> docCountsByGeneration
/**
            if (counts == null) {
            long numRows = physicalRows(dfSeg);
     * <p>
    /**
            seg.delDocCount = (int) Math.min(deletedRows, Integer.MAX_VALUE);
            seg.docCount = (int) Math.min(liveRows, Integer.MAX_VALUE);
     *
    }
                CatalogSnapshot.this.closeInternal();
    }
    /**
     *
    /**
     * (cross-format comparison is not meaningful) or for empty catalogs.
     *
     * Lazily computed cache of file names grouped by format. Computed once on first access
        } catch (NumberFormatException e) {
     */
        for (Segment seg : getSegments()) {
    /**
     * Rows physically present in the given catalog segment, taken from the first data format the
    }
    private volatile boolean committed;
     * @return serialized string
    public abstract long getFormatVersionForFile(String file);
        return allFileSizes;
        Map<String, Collection<String>> unmodifiable = new HashMap<>();
        return refCounter.decRef();
        if (lastCommittedIdStr == null) {
        cached = Collections.unmodifiableMap(unmodifiable);
            }
        return committed;
    void markCommitted() {
        String lastCommittedIdStr = lastCommitData.get(CATALOG_SNAPSHOT_ID);
    public List<org.opensearch.index.engine.Segment> buildEngineSegments(
            if (liveRows > Integer.MAX_VALUE) {
            return cached;
        for (Segment segment : getSegments()) {
        this.refCounter = new AbstractRefCounted(name) {
                }
     *   <li>{@link DataformatAwareCatalogSnapshot}: serialized format-aware names
                deletedDocs += counts.deletedDocs();
    private static final Logger logger = LogManager.getLogger(CatalogSnapshot.class);
     */
import org.opensearch.index.engine.exec.DocCounts;
        }
 * <p><b>Important:</b> Do not call {@code incRef()}, {@code decRef()}, or {@code tryIncRef()} directly.
    public abstract Collection<WriterFileSet> getSearchableFiles(String dataFormat);
 * accessing file metadata, segments, and user data.
    /**
            long deletedRows = counts != null ? counts.deletedDocs() : 0L;
import org.opensearch.core.common.io.stream.StreamOutput;
    }
     * Tries to increment the reference count. Returns {@code false} if the snapshot is already closed.
     * (see {@link LuceneVersionConverter}). Returns {@code 0} for multi-format
     * {@link LuceneVersionConverter}). Returns {@code 0} for multi-format catalogs
     * @return a new {@link CatalogSnapshot} with the same logical state
    /**
    }
    ) {
                for (String file : entry.getValue().files()) {
package org.opensearch.index.engine.exec.coord;
            seg.segmentSort = indexSort;
    public abstract Collection<String> getFiles(boolean includeSegmentsFile) throws IOException;
    /**
    public abstract Map<String, String> getUserData();
    public long getVersion() {
     * @param writerGeneration the writer generation to match
        }
    public abstract long getNumDocs();
     *
import java.util.Set;
    /**
    public abstract String serializeToString() throws IOException;
    /**
            if (candidate.writerGeneration() != writerGeneration) continue;
     */
     */
    public abstract long getCommitDataFormatVersion();
     * Serializes this catalog snapshot to a string representation.
    /**
            }
     * Marks this snapshot as committed (persisted via flush).
     * Returns the format-version string for the given file. Empty string means pre-versioning
    }
    }
            protected void closeInternal() {
    /**
     */
     * Gets user-defined metadata associated with this catalog snapshot.
public abstract class CatalogSnapshot implements Writeable, Cloneable {
     * @param lastCommitData commit data map from the committer
        Map<String, String> lastCommitData,
            org.opensearch.index.engine.Segment seg = new org.opensearch.index.engine.Segment("_" + Long.toHexString(dfSeg.generation()));
     */
     */
 * SPDX-License-Identifier: Apache-2.0
     * Creates a deep copy of this catalog snapshot. The cloned snapshot starts with a fresh reference count of 1.
        }
     */
     * Collects file sizes for all files in this catalog snapshot.
     */
     * Gets all segments in this catalog snapshot.
     */
     */
     * but the collection phase returns individual file names as keys.
            if (candidate == null || candidate.files().isEmpty()) continue;
    public boolean resolveIsCommitted(Map<String, String> lastCommitData) {
     * and cached for the lifetime of this snapshot (segments are immutable after construction).
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
     *
     */
    }
     */
     */
        for (Segment segment : getSegments()) {
    }
                    long size;
        return segment.dfGroupedSearchableFiles().values().stream().findFirst().map(WriterFileSet::numRows).orElse(0L);
     * since segments are immutable after construction.
        result.sort(java.util.Comparator.comparingLong(org.opensearch.index.engine.Segment::getGeneration));
     *
import java.util.Collections;
            }
    }
     * @param store  the store to resolve file sizes from
        this.version = version;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.engine.exec.WriterFileSet;
     * @param file the file name
    protected CatalogSnapshot(StreamInput in) throws IOException {
        };
            }
                    String extension = extractExtension(file);
     * Decrements the reference count. Returns {@code true} if the count reached zero
                        size = 0L;
     *
    }
        }
    protected long version;
            return "unknown";
     * per-file map. Sizes for files sharing the same extension are summed.
     *
     */
import org.apache.logging.log4j.LogManager;
     * Total number of documents physically present in this snapshot.
import java.io.IOException;
    /**
     */
     * Note: The existing stats API groups these files by extension for display purposes
        this.filesByFormatCache = cached;
     */
        return refCounter.refCount();
    public WriterFileSet findFileSet(String format, long writerGeneration) {
     * Sums live and deleted document counts across this snapshot's segments.
        out.writeLong(generation);
     */
    public abstract Set<String> getDataFormats();
    private volatile Map<String, Collection<String>> filesByFormatCache;
     * Returns individual file names as keys, matching the existing stats API format.
     * Retrieves searchable files for a specific data format.
                CatalogSnapshot.this.closeInternal();
                logger.warn("Segment [{}] has {} live rows exceeding Integer.MAX_VALUE; clamping docCount", dfSeg.generation(), liveRows);
        for (Map.Entry<String, Set<String>> entry : result.entrySet()) {
    protected CatalogSnapshot(String name, long generation, long version) {
     *        {@link org.opensearch.index.engine.exec.LiveDocsSource#docCountsByGeneration};
                    try {
        return cached;
    /**
        this.generation = generation;
            logger.warn("Invalid catalog snapshot ID in committed data: {}", lastCommittedIdStr);
     * (legacy / BWC). The string is plugin-defined and MUST NOT be compared across formats.
                    try {
    /**
     * @param lastCommitData commit data map from the committer
     * <p>
     * {@link DataformatAwareCatalogSnapshot#setLastCommitInfo}, falling back to {@link #getGeneration()}.
     *
     * Returns the Lucene {@code segments_N} generation to use when serializing this snapshot
    /**
     */
        if (cached != null) {
        for (Segment segment : getSegments()) {
        int lastDot = fileName.lastIndexOf('.');
     * <ul>
     */
        return grouped;
 *
                for (String file : entry.getValue().files()) {
     * Finds the {@link WriterFileSet} for the given data format whose {@code writerGeneration}
     *
        this.version = in.readLong();
    }
                result.computeIfAbsent(entry.getKey(), k -> new HashSet<>()).addAll(entry.getValue().files());
    /**
     * Returns the minimum segment format version as a long-encoded value (see
 * The OpenSearch Contributors require contributions made to
     */
        this.refCounter = new AbstractRefCounted("catalog_snapshot") {
     * Key for storing last composite writer generation in user data.
        return fileName.substring(lastDot + 1);
     * Collects file sizes grouped by file extension in a single pass, avoiding an intermediate
     * @throws IOException if an I/O error occurs
     * @return the encoded long version, or {@code 0} if unknown
     *       (e.g., {@code "parquet/data.parquet"}) for non-lucene files</li>
    int refCount() {
import org.opensearch.common.util.concurrent.AbstractRefCounted;
    }
            DocCounts counts = docCountsByGeneration.get(dfSeg.generation());
     */
     * Returns the format-version for the given file as a long-encoded value.
        Map<String, Set<String>> result = new HashMap<>();
     * @param file the file name to inspect
    /**
 *
        return result;
     * Gets the last writer generation number.
            @Override
                logger.warn("Segment [{}] has no searchable files; reporting 0 doc count", dfSeg.generation());
     * @return map of file extension to total size in bytes
import org.apache.logging.log4j.Logger;
    public static final String LAST_COMPOSITE_WRITER_GEN_KEY = "_last_composite_writer_gen_";
