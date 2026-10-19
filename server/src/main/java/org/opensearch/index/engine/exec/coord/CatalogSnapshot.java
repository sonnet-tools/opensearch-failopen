        return generation;  
     * {@link LuceneVersionConverter#toLuceneOrLatest(long)} when a Lucene view is needed.  
        }
            return cached;
        out.writeLong(generation);
            return false;
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
     * @return the catalog snapshot ID
    public static final String CATALOG_SNAPSHOT_ID = "_id";  
    public Map<String, Collection<String>> getFilesByFormat() {
     * (legacy / BWC). The string is plugin-defined and MUST NOT be compared across formats.  
 *
     * @return the encoded long version, or {@code 0} if unknown  
            unmodifiable.put(entry.getKey(), Collections.unmodifiableSet(entry.getValue()));
        }
     * but the collection phase returns individual file names as keys.
    void markCommitted() {
     * Collects file sizes for all files in this catalog snapshot.  
    }
     *
     */
    boolean isCommitted() {
     * @return true if the snapshot ID matches the last committed snapshot ID
     */
     * Finds the {@link WriterFileSet} for the given data format whose {@code writerGeneration}
     *  
 * this file be licensed under the Apache-2.0 license or a
     */  
        };  
    }  
     */  
    /**
import org.opensearch.index.engine.exec.WriterFileSet;
 * Subclasses must implement {@link #closeInternal()} for resource cleanup and methods for  
    ) {
     * @param store the store to resolve file sizes from  
     * Total number of documents physically present in this snapshot.
        Map<String, String> lastCommitData,
                    try {
    public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.common.io.stream.Writeable;
        return allFileSizes;
     * Name of the top-level commit file, or {@code null} if not yet committed.
    /**  
            return false;
            @Override
import java.util.Set;  
                String formatName = entry.getKey();
     * @throws IOException if an I/O error occurs
            seg.segmentSort = indexSort;
     * Marks this snapshot as committed (persisted via flush).
    /**  
     *  
            return "unknown";
     * rather than broken down by internal sub-file format. This is a known limitation.
    /**
        return refCounter.tryIncRef();
     *   <li>{@link SegmentInfosCatalogSnapshot}: plain Lucene file names (e.g., {@code "_0.cfe"})</li>  
    /**  
            }
        for (Segment segment : getSegments()) {  
package org.opensearch.index.engine.exec.coord;
import java.util.Collections;
    /**
     */
     */  
    public Map<String, Long> collectFileSizesGroupedByExtension(Store store) {  
    protected CatalogSnapshot(StreamInput in) throws IOException {  
import org.opensearch.index.engine.exec.Segment;
     */
    public long getGeneration() {
     * @return live and deleted totals for the whole snapshot
import java.util.Collection;  
        }
    private static final Logger logger = LogManager.getLogger(CatalogSnapshot.class);
    boolean tryIncRef() {  
            seg.sizeInBytes = dfSeg.dfGroupedSearchableFiles().values().stream().mapToLong(WriterFileSet::getTotalSize).sum();  
 * compatible open source license.
     *
            }
     */  
     *  
 * when done. The manager handles all reference counting internally.</p>  
        return cached;  
            return candidate;
     */  
    public abstract long getMinSegmentFormatVersion();  
            return getId() == Long.parseLong(lastCommittedIdStr);
     */
    }
 * SPDX-License-Identifier: Apache-2.0
    public WriterFileSet findFileSet(String format, long writerGeneration) {
     * Builds a list of {@link org.opensearch.index.engine.Segment} from this catalog snapshot's segments.
     *       (e.g., {@code "parquet/data.parquet"}) for non-lucene files</li>
    public abstract Collection<WriterFileSet> getSearchableFiles(String dataFormat);
    public abstract void setUserData(Map<String, String> userData, boolean commitData);  
     * @param file the file name to inspect
import org.opensearch.core.common.io.stream.StreamInput;  
    public abstract Collection<String> getFiles(boolean includeSegmentsFile) throws IOException;  
    public abstract long getFormatVersionForFile(String file);
     */
        Map<String, Collection<String>> cached = this.filesByFormatCache;
     *
            }
     * Returns whether this snapshot was committed.
     * Creates a deep copy of this catalog snapshot. The cloned snapshot starts with a fresh reference count of 1.  
     *        {@link org.opensearch.index.engine.exec.LiveDocsSource#docCountsByGeneration};  
            @Override
                result.computeIfAbsent(entry.getKey(), k -> new HashSet<>()).addAll(entry.getValue().files());  
                    String dirFile = org.opensearch.index.store.FileMetadata.serialize(formatName, file);  
    public abstract long getLastWriterGeneration();  
        long liveDocs = 0L;
                    grouped.merge(extension, size, Long::sum);  
            protected void closeInternal() {  
     * Gets all data formats present in this catalog snapshot.
     * @return collection of file name strings ready for upload  
     * hash-full-file step when this is {@code null}.
        for (Segment dfSeg : getSegments()) {
    /**
            }  
            seg.delDocCount = (int) Math.min(deletedRows, Integer.MAX_VALUE);
    /**
    /**
     */
     * Key for storing catalog snapshot in user data.
     * {@link DataformatAwareCatalogSnapshot#setLastCommitInfo}, falling back to {@link #getGeneration()}.  
     * and {@link #closeInternal()} was invoked.  
     * Subclasses must ensure all mutable state is properly copied.
     *
     */  
    protected long version;  
import java.util.List;
        }
     */
     *        a segment absent from this map reports all of its rows live and none deleted
     * {@code major * 1_000_000 + minor * 1_000 + bugfix}. Returns {@code 0} to indicate
    }
import org.apache.logging.log4j.Logger;
     */  
import org.opensearch.common.util.concurrent.AbstractRefCounted;
                    String extension = extractExtension(file);
        }  
     */
    /**
     * Note: Compound files (e.g., Lucene .cfs) are reported under their physical extension  
    public abstract String getLastCommitFileName();
     */  
    }
     *  
     */
    protected CatalogSnapshot(String name, long generation, long version) {
 * The OpenSearch Contributors require contributions made to  
        result.sort(java.util.Comparator.comparingLong(org.opensearch.index.engine.Segment::getGeneration));
     * (cross-format comparison is not meaningful) or for empty catalogs.
import org.apache.lucene.search.Sort;  
     *  
                CatalogSnapshot.this.closeInternal();
        }  
     * (e.g., compound files show underlying format extensions in descriptions),
    }
     */
     * Rows physically present in the given catalog segment, taken from the first data format the
    /**
     */
        Map<String, Long> grouped = new HashMap<>();
                for (String file : entry.getValue().files()) {
        }
            long numRows = physicalRows(dfSeg);
     *
            } else {
     * (see {@link LuceneVersionConverter}). Returns {@code 0} for multi-format
     */
    protected static long physicalRows(Segment segment) {
            if (candidate.writerGeneration() != writerGeneration) continue;  
        try {  
                    } catch (java.io.IOException e) {
     *
    public boolean resolveIsCommitted(Map<String, String> lastCommitData) {
     * @return list of engine segments sorted by generation
     * <p>  
            }  
            if (liveRows > Integer.MAX_VALUE) {
        for (Map.Entry<String, Set<String>> entry : result.entrySet()) {
            long deletedRows = counts != null ? counts.deletedDocs() : 0L;  
     *
     * Each subclass formats names appropriately for its data format:
    public DocCounts aggregateDocCounts(Map<Long, DocCounts> docCountsByGeneration) {
                    }
     * Lazily computed cache of file names grouped by format. Computed once on first access
     * Key for storing last composite writer generation in user data.  
import java.util.HashMap;
    public abstract CatalogSnapshot clone();
     * Tries to increment the reference count. Returns {@code false} if the snapshot is already closed.
     * @param docCountsByGeneration per-generation live and deleted counts from
            }
        return null;  
    /**
     * @throws IOException in case of I/O error
     */  
 * accessing file metadata, segments, and user data.
    protected abstract void closeInternal();
     * @param includeSegmentsFile whether to include the segments file in the returned collection
        for (Segment segment : getSegments()) {
        String lastCommittedIdStr = lastCommitData.get(CATALOG_SNAPSHOT_ID);
        boolean isCommitted = resolveIsCommitted(lastCommitData);  
        Map<String, Long> allFileSizes = new java.util.HashMap<>();
import java.util.Map;
     * segment carries.
     *   <li>{@link DataformatAwareCatalogSnapshot}: serialized format-aware names
                        size = store.directory().fileLength(dirFile);  
    /**
    int refCount() {
     * Returns the current reference count.
     * Gets the last writer generation number.
                    }
        return getGeneration();  
     * Gets user-defined metadata associated with this catalog snapshot.
import java.util.HashSet;  
     * Returns the canonical file names for upload to remote store.  
    @Override
    boolean decRef() {
    public Map<String, Long> collectFileSizes(Store store) {
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {  
     * @return collection of WriterFileSet objects for the specified format
     */
    /**  
    public List<org.opensearch.index.engine.Segment> buildEngineSegments(
     * Note: The existing stats API groups these files by extension for display purposes  
    public abstract List<Segment> getSegments();
    /**
     */  
     *
    public abstract long getCommitDataFormatVersion();
    }  
     * and cached for the lifetime of this snapshot (segments are immutable after construction).  
                    String dirFile = org.opensearch.index.store.FileMetadata.serialize(formatName, file);
     * Gets all segments in this catalog snapshot.
     * Whether this snapshot has been committed (persisted via flush).
    private final AbstractRefCounted refCounter;
     * @param format           the data format name (e.g. {@code "parquet"})
     *
            seg.version = org.apache.lucene.util.Version.LATEST;  
        Sort indexSort,  
     * <p>
     *
        }  
     * @param lastCommitData commit data map from the committer
        return fileName.substring(lastDot + 1);  
        return grouped;
     * @param file the file name
     * Gets the unique identifier for this catalog snapshot.  
        return segment.dfGroupedSearchableFiles().values().stream().findFirst().map(WriterFileSet::numRows).orElse(0L);
     * @param lastCommitData commit data map from the committer  
            seg.committed = isCommitted;
            result.add(seg);
     */
     */
     * @return set of data format identifiers  
     * against the last committed snapshot ID stored in commit data.
    /**  
     * into a synthetic {@code SegmentInfos} or building a {@code ReplicationCheckpoint}.
    /**
    /**
                    long size;
        return refCounter.refCount();
    /**  
    private volatile boolean committed;
     * since segments are immutable after construction.  
    }  
import org.apache.logging.log4j.LogManager;
        for (Segment segment : getSegments()) {
        return committed;
    /**
    }  
    private static String extractExtension(String fileName) {
     * @param indexSort      the index sort, or null if unsorted
 * Uses an internal reference counter for safe concurrent access.
     * against the last committed snapshot ID stored in commit data.
     * @param store  the store to resolve file sizes from
    }  
        this.refCounter = new AbstractRefCounted(name) {
     */
     * @param dataFormat the data format identifier
     * </ul>  
        out.writeLong(version);
    private volatile Map<String, Collection<String>> filesByFormatCache;
                for (String file : entry.getValue().files()) {  
        this.generation = in.readLong();
     * @return the matching file set, or {@code null}  
    public long getVersion() {  
     * Resolves whether this snapshot has been committed by comparing its ID
    }
     */  
                CatalogSnapshot.this.closeInternal();  
                        logger.warn(() -> "Failed to read size for file [" + dirFile + "]; reporting 0", e);
    /**  
     * Package-private — only called by {@link IndexFileDeleter} and {@link CatalogSnapshotManager}.
     * Package-private — only called by {@link IndexFileDeleter} and {@link CatalogSnapshotManager}.  
     * Sums live and deleted document counts across this snapshot's segments.  
    public abstract long getId();
        this.version = version;  
    /**
    /**  
     * <p>
    /**
     * Returns the minimum segment format version as a long-encoded value (see
 */  
            }  
    /**
     *  
                }
    /**
        };
            }
     * @return serialized string
            // append-only index where nothing is ever hidden.
 * Abstract base class representing a snapshot of the catalog state at a specific point in time.  
    public long getLastCommitGeneration() {
     */
        cached = Collections.unmodifiableMap(unmodifiable);
            seg.search = true;
     * <p>
    /**
    public abstract Map<String, String> getUserData();  
            long liveRows = counts != null ? counts.liveDocs() : numRows;
     * "unknown / pre-versioning" (callers map this to {@link org.apache.lucene.util.Version#LATEST}).  
     */  
     *
    }
        this.version = in.readLong();
     * Returns the format-version string for the given file. Empty string means pre-versioning
     * @param userData map of user data key-value pairs  
        this.filesByFormatCache = cached;
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
     * @return a new {@link CatalogSnapshot} with the same logical state  
            protected void closeInternal() {
     * matches, or {@code null} if no segment carries a non-empty file set for that format/generation.
     */
     * Returns individual file names as keys, matching the existing stats API format.
 * <p><b>Important:</b> Do not call {@code incRef()}, {@code decRef()}, or {@code tryIncRef()} directly.  
            if (dfSeg.dfGroupedSearchableFiles().isEmpty()) {
        return new DocCounts(liveDocs, deletedDocs);
     * For {@code DataformatAwareCatalogSnapshot}, this is the generation set via
    /**
    /**
            // No liveness source for this segment: every row counts as live, matching an  
        } catch (NumberFormatException e) {
        return version;
                        size = 0L;  
     * @return the last writer generation
     * @param commitData whether this is commit-level user data
/*  
     * Retrieves searchable files for a specific data format.
            DocCounts counts = docCountsByGeneration.get(dfSeg.generation());
                liveDocs += physicalRows(segment);
    /**  
     * Package-private — managed by {@link IndexFileDeleter}.  
     * Returns the format-version for the given file as a long-encoded value.  
    public static final String CATALOG_SNAPSHOT_KEY = "_catalog_snapshot_";
import org.opensearch.core.common.io.stream.StreamOutput;
     */
     * @return list of Segment objects  
    /**
     * Sets user-defined metadata for this catalog snapshot.
        return result;
        Map<String, Collection<String>> unmodifiable = new HashMap<>();  
            org.opensearch.index.engine.Segment seg = new org.opensearch.index.engine.Segment("_" + Long.toHexString(dfSeg.generation()));  
    // Package-private ref counting — only accessible within exec.coord (i.e., CatalogSnapshotManager)
     */
     * @return map of user data key-value pairs
        for (Segment seg : getSegments()) {  
     * @throws IOException if an I/O error occurs  
                    try {
        if (cached != null) {  
     */
        List<org.opensearch.index.engine.Segment> result = new java.util.ArrayList<>(getSegments().size());
    }  
    public static final String LAST_COMPOSITE_WRITER_GEN_KEY = "_last_composite_writer_gen_";
            logger.warn("Invalid catalog snapshot ID in committed data: {}", lastCommittedIdStr);  
        if (lastDot == -1 || lastDot == fileName.length() - 1) {  
    }
        }
     * Decrements the reference count. Returns {@code true} if the count reached zero
     * @return the format version string  
@ExperimentalApi
     * All segments are marked as searchable. Committed state is determined by comparing this snapshot's ID  
        Map<String, Set<String>> result = new HashMap<>();  
     */
/**
    public abstract String serializeToString() throws IOException;
     *
     * {@link LuceneVersionConverter}). Returns {@code 0} for multi-format catalogs  
        }  
    public abstract Set<String> getDataFormats();
            DocCounts counts = docCountsByGeneration.get(segment.generation());
                logger.warn("Segment [{}] has {} live rows exceeding Integer.MAX_VALUE; clamping docCount", dfSeg.generation(), liveRows);
                liveDocs += counts.liveDocs();  
import org.opensearch.index.store.Store;  
        long deletedDocs = 0L;  
     * Constructs a CatalogSnapshot from a {@link StreamInput}.
    }
}
import java.io.IOException;
     */
    public abstract long getNumDocs();
    /**  
    /**  
     * Encoding is defined by {@link LuceneVersionConverter}:
     * assume any naming convention. {@code MetadataSnapshot.loadMetadata} skips the
     * Serializes this catalog snapshot to a string representation.  
                logger.warn("Segment [{}] has no searchable files; reporting 0 doc count", dfSeg.generation());
     * <ul>
     * catalogs or when no commit has landed yet. Callers decode via
        this.committed = true;  
     */  
     *
     * Returns all file names grouped by data format name. The result is computed once
                        allFileSizes.put(file, store.directory().fileLength(dirFile));  
    }
     * @return map of file extension to total size in bytes
     *
    }  
                    } catch (java.io.IOException e) {
     * @param writerGeneration the writer generation to match
        this.refCounter = new AbstractRefCounted("catalog_snapshot") {  
 * Use {@link org.opensearch.index.engine.exec.coord.CatalogSnapshotManager#acquireSnapshot()} to obtain
    }
    /**
     * Called when the reference count reaches zero. Subclasses should release any resources here.  
     * iteration over segments on every add/remove call.  
public abstract class CatalogSnapshot implements Writeable, Cloneable {  
 * a reference-counted handle, and close the returned {@link org.opensearch.common.concurrent.GatedCloseable}
     * Format-neutral: Lucene-backed snapshots use {@code segments_N} but callers must not  
    }
    protected final long generation;
        return refCounter.decRef();  
     *
                }
import org.opensearch.common.annotation.ExperimentalApi;
 */
    /**  
     * For {@code SegmentInfosCatalogSnapshot}, this is the Lucene generation from {@code SegmentInfos}.
        this.generation = generation;
        Map<Long, DocCounts> docCountsByGeneration
     * Used by {@code IndexFileDeleter} for ref-count bookkeeping, avoiding repeated
            if (counts == null) {  
    }  
    /**
     * Collects file sizes grouped by file extension in a single pass, avoiding an intermediate  
     * @return map of individual file names to their sizes
     * Returns the Lucene {@code segments_N} generation to use when serializing this snapshot
                deletedDocs += counts.deletedDocs();
            if (candidate == null || candidate.files().isEmpty()) continue;
        }
    /**
import org.opensearch.index.engine.exec.DocCounts;  
                        logger.warn(() -> "Failed to read size for file [" + dirFile + "]; reporting 0", e);
     * @return unmodifiable map of format name to unmodifiable set of file names
     * Returns the commit-time format version as a long-encoded value  
     * Key for storing catalog snapshot ID in user data.
        for (Segment segment : getSegments()) {
            seg.docCount = (int) Math.min(liveRows, Integer.MAX_VALUE);
 * Maintains versioned information about segments, files, and metadata for index operations.
                String formatName = entry.getKey();
        int lastDot = fileName.lastIndexOf('.');
     * per-file map. Sizes for files sharing the same extension are summed.
            WriterFileSet candidate = seg.dfGroupedSearchableFiles().get(format);
 *
        if (lastCommittedIdStr == null) {  
     * @param in the stream input to read from  
                        allFileSizes.put(file, 0L);  
