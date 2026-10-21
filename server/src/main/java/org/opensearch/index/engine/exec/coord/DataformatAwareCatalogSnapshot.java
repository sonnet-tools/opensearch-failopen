    public String serializeToString() throws IOException {
        this.userData = Map.copyOf(userData);
        } catch (Exception e) {
    }
        this.lastCommitDataFormatVersion = commitDataFormatVersion;
        }
            WriterFileSet writerFileSet = segment.dfGroupedSearchableFiles().get(dataFormat);
            generation,
            return Base64.getEncoder().encodeToString(BytesReference.toBytes(out.bytes()));
import java.util.concurrent.atomic.AtomicBoolean;
        long lastWriterGeneration,
    @Override
    DataformatAwareCatalogSnapshot(StreamInput in, Function<String, String> directoryResolver) throws IOException {
    public final static long SERIALIZATION_VERSION_ONE = 1;
        return lastWriterGeneration;
    public String toString() {
     */
     * @throws IOException if the data is malformed or missing required fields
    public long getId() {
    DataformatAwareCatalogSnapshot(
            lastWriterGeneration,
        for (Segment segment : segments) {
     * @param generation the monotonically increasing generation number
     * @param version the schema version for serialization compatibility
     * Sets the commit file name and Lucene generation produced by the commit that persisted this snapshot.
                }
 * generation                   - Current tracking generation [This is always local to the catalog snapshot]
    DataformatAwareCatalogSnapshot(
            + userData
 * compatible open source license.
    public static DataformatAwareCatalogSnapshot deserializeFromString(String serializedData, Function<String, String> directoryResolver)
        return id;
     * @param directoryResolver function that maps a data format name to its directory path
            }
     * @param id the unique snapshot identifier
 *                                  Always local to the shard on which snapshot is created.
    private volatile Object replicatingCommitData;
    }
        if (map == null) {
            }
            throw new IOException("Cannot deserialize DataformatAwareCatalogSnapshot: input is null or empty");
     * @param directoryResolver function that maps a data format name to its directory path
    public List<Segment> getSegments() {
     */
    }
        long lastWriterGeneration,
        this.segments = Collections.unmodifiableList(segmentList);
    private volatile long lastCommitGeneration = -1;
    public synchronized String getLastCommitFileName() {
    /**
        this.userData = in.readMap(StreamInput::readString, StreamInput::readString);
            seg.writeTo(out);
     * @param commitFileName the segments_N filename (e.g., "segments_2")
            if (segFile != null) {
        out.writeVInt(segments.size());
    public Object getReplicatingCommitData() {
import org.opensearch.core.common.io.stream.BytesStreamInput;
    /**
 * Holds segments grouped by data format, supports searchable file lookups across formats,
import java.util.Base64;
    private final List<Segment> segments;
public class DataformatAwareCatalogSnapshot extends CatalogSnapshot {
        int segmentCount = in.readVInt();
import org.opensearch.index.engine.exec.WriterFileSet;
package org.opensearch.index.engine.exec.coord;
     * @param version the schema version for serialization compatibility
    }
    /**
    public void setUserData(Map<String, String> userData, boolean commitData) {
    }
     * Called by the engine after {@code Committer.commit()} or by the replica after
        return fileNames;
        }
        return "DataformatAwareCatalogSnapshot{"
            .sum();
            formats.addAll(segment.dfGroupedSearchableFiles().keySet());
     * the new {@code IndexWriter} opens on a valid commit with all Lucene segments visible.
    public void setReplicatingCommitData(Object replicatingCommitData) {
 * The OpenSearch Contributors require contributions made to
    }
        super("dataformat_aware_catalog_snapshot", generation, version);
        this.userData = Map.copyOf(userData);
    public synchronized void setLastCommitInfo(String commitFileName, long commitGeneration, long commitDataFormatVersion) {
     * {@code store.commitSegmentInfos()}.
    /**
    public long getMinSegmentFormatVersion() {
     * @param segments the list of segments in this snapshot
     * @param segments the list of segments in this snapshot
        long generation,
    }
        return lastCommitDataFormatVersion;
    /**
                String formatName = entry.getKey();
            throw new IOException("Failed to deserialize DataformatAwareCatalogSnapshot: " + e.getMessage(), e);
     *
    @Override
    }
            if (writerFileSet != null) {
    @Override
            }
        userData.remove(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY);
            + id
    @Override
        List<Segment> segments,
        }
        String serializedVersionValue = this.userData.remove(SERIALIZATION_VERSION_KEY);
 * version                      - If a catalog snapshot is build from another, this holds the version for that.
            + ", closed="
     * path can write a {@code segments_N} containing the real Lucene segment entries (not an
     * empty synthetic one). This guarantees that if the replica is later promoted to primary,
            + ", lastWriterGeneration="
        Map<String, String> userData,
    public long getNumDocs() {
        if (includeSegmentsFile) {
     * Returns the {@code segments_N} filename associated with this snapshot's Lucene commit,
    public final static long CURRENT_SERIALIZATION_VERSION = SERIALIZATION_VERSION_ONE;
            version,
     * @param userData user-defined metadata key-value pairs
import java.util.HashMap;
        }
 *                                  This is used to determine the
    private volatile Map<String, Long> fileToFormatVersion;
 */
        return result;
            + "id="
    /**
        this.lastCommitFileName = lastCommittedFileName;
            lastCommitFileName,
        return segments.stream()
        closed.set(true);
     *
    private volatile String lastCommitFileName;
        Map<String, Long> map = fileToFormatVersion;
    public long getCommitDataFormatVersion() {
     */
        this.lastWriterGeneration = lastWriterGeneration;
    public long getLastWriterGeneration() {
     * @param commitGeneration the Lucene generation of the commit
            map = buildFileToFormatVersionMap();
     * @param generation the monotonically increasing generation number
    private volatile long lastCommitDataFormatVersion = 0L;
        for (Segment seg : segments) {
        List<Segment> segments,
    @Override
    }
            + ", segments="
    }
        this.id = in.readLong();
        try {
    }
     * @param lastWriterGeneration the generation of the last writer that contributed to this snapshot
        long serializedVersion = SERIALIZATION_VERSION_ZERO;
    public long getFormatVersionForFile(String file) {
    }
        this.segments = Collections.unmodifiableList(new ArrayList<>(segments));
@ExperimentalApi
 * this file be licensed under the Apache-2.0 license or a
     * @throws IOException if an I/O error occurs
     * @param id the unique snapshot identifier
    private final static String SERIALIZATION_VERSION_KEY = "_serialization_version";
    }
import java.util.Set;
     * @param userData user-defined metadata key-value pairs
        return formats;
        Long v = map.get(file);
import org.opensearch.core.common.io.stream.StreamInput;
    }
     */
    @Override
import java.util.Collection;
     * or {@code null} if this snapshot has not yet been committed (e.g., refresh-only snapshots).
        long generation,
                result.add(writerFileSet);
            }
     * <p>Not serialized — only lives in memory during the replication cycle. Null on the
        return numDocs;
    // Long-encoded format version (see LuceneVersionConverter) that wrote the last commit.
        throws IOException {
        return closed.get();
        assert lastCommitGeneration >= 0 : "Before this is obtained, at least one snapshot should've been committed: " + this;
        List<String> fileNames = new ArrayList<>();
    @Override
     * @param lastCommittedFileName the segments_N file name from the most recent flush, or null
     */
    }
        long lastCommitDataFormatVersion
import java.util.Collections;
            fileToFormatVersion = map;
import java.io.IOException;
            .mapToLong(segment -> segment.dfGroupedSearchableFiles().values().stream().findFirst().map(WriterFileSet::numRows).orElse(0L))
    @Override
        this.lastCommitGeneration = lastCommitGeneration;
    public long getLastCommitGeneration() {
    private final long numDocs;
 * SPDX-License-Identifier: Apache-2.0
    }
            id,
 * and tracks snapshot metadata including user data and writer generation.
import java.util.HashSet;
                }
        return userData;
    // Kept as raw long so this class has no dependency on Lucene's Version type.
        return new DataformatAwareCatalogSnapshot(
        return v == null ? 0L : v;
     * @param serializedData the Base64 string produced by {@link #serializeToString()}
     */
            try (BytesStreamInput in = new BytesStreamInput(bytes)) {
import org.opensearch.core.common.bytes.BytesReference;
import java.util.function.Function;
        long version,
    public DataformatAwareCatalogSnapshot clone() {
    /**
    public Map<String, String> getUserData() {
     *
     */
        }
        super(in);
    // upload/recovery consumers; volatile ensures the latest commit is visible.
    private static long computeNumDocs(List<Segment> segments) {
            throw new IOException("Invalid segment count: " + segmentCount);
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
     * primary's own snapshots and on snapshots loaded from disk.
     *
     */
 * lastCommittedGeneration      - Generation of last committed file tracked for this catalog snapshot on local shard.
     * across refreshes and merges, which would otherwise create new snapshots without it.
        );
     * Constructs a new DataformatAwareCatalogSnapshot.
            serializedVersion = Long.parseLong(serializedVersionValue);
    private final AtomicBoolean closed = new AtomicBoolean(false);
    }
    @Override
            + segments
     * {@code numRows} from each segment's first available format.
/*
        for (Segment s : segments) {
    public Collection<WriterFileSet> getSearchableFiles(String dataFormat) {
     * Deserializes a {@link DataformatAwareCatalogSnapshot} from a Base64-encoded binary string.
     * @param commitDataFormatVersion the format version string that wrote this commit
            segmentList.add(new Segment(in, directoryResolver, serializedVersion));
import org.opensearch.common.annotation.ExperimentalApi;
     * Returns {@code true} if {@link #closeInternal()} has been invoked (ref count reached zero).
    /**
            + '}';
            for (WriterFileSet wfs : s.dfGroupedSearchableFiles().values()) {
        long id,
        Map<String, String> userData = new HashMap<>(this.userData);
        }
        this.id = id;
     * Returns the total document count, precomputed during construction by summing
        long id,
        // 0L means no commit has landed on this snapshot yet.
     * @param lastWriterGeneration the generation of the last writer that contributed to this snapshot
     */
    // Lazily built; racy construction is safe (idempotent result).
    ) {
    @Override
    @Override
        out.writeMap(userData, StreamOutput::writeString, StreamOutput::writeString);
        this.numDocs = computeNumDocs(this.segments);
        for (int i = 0; i < segmentCount; i++) {
    public void writeTo(StreamOutput out) throws IOException {
    @Override
     * available. Set by segment replication on the replica side so that the replica's commit
     *
    public boolean isClosed() {
    private Map<String, Long> buildFileToFormatVersionMap() {
        }
        return replicatingCommitData;
        return List.copyOf(segments);
/**
import org.opensearch.core.common.io.stream.StreamOutput;
    private Map<String, String> userData;
                    m.put(f, wfs.formatVersion());
        List<Segment> segmentList = new ArrayList<>(segmentCount);
import java.util.Map;
 * Concrete implementation of {@link CatalogSnapshot} for the composite multi-format engine.
        }
import java.util.ArrayList;
    }
        return lastCommitFileName;
    @Override
        this.lastCommitGeneration = commitGeneration;
    @Override
        this.lastCommitFileName = commitFileName;
        Map<String, String> userData
import org.opensearch.index.engine.exec.Segment;
            + closed
 * id                           - the unique id for this catalog snapshot. This should always increase.
    // Mutated via setCommitInfo after a flush from a different thread than
        return 0L;  // cross-format min is semantically meaningless
        long version,
                fileNames.add(segFile);
        }
        if (serializedData == null || serializedData.isEmpty()) {
            segments,
        this.lastWriterGeneration = in.readLong();
        List<WriterFileSet> result = new ArrayList<>();
        out.writeLong(id);
    }
     * This constructor ensures that the {@code segmentsFileName} from a prior flush is preserved
        out.writeLong(lastWriterGeneration);
        for (Segment segment : segments) {
                for (String file : entry.getValue().files()) {
    }
    }
        if (segmentCount < 0 || segmentCount > in.available()) {
}
            + ", userData="
        }
            userData,
     * @param in the stream input to read from
        return Map.copyOf(m);
        super.writeTo(out);
     *
     * This method is intended for testing only.
    private final long lastWriterGeneration;
        this.replicatingCommitData = replicatingCommitData;
     * Constructs a new DataformatAwareCatalogSnapshot carrying forward the last committed segments file name.
    ) {
            throw e;
        for (Segment segment : segments) {
        this(id, generation, version, segments, lastWriterGeneration, userData, null, -1, 0L);
        userData.put(SERIALIZATION_VERSION_KEY, Long.toString(CURRENT_SERIALIZATION_VERSION));
        long lastCommitGeneration,
            }
        String lastCommittedFileName,
    public Collection<String> getFiles(boolean includeSegmentsFile) throws IOException {
                for (String f : wfs.files()) {
        } catch (IOException e) {
        Map<String, Long> m = new HashMap<>();
     * Constructs a DataformatAwareCatalogSnapshot from a {@link StreamInput}.
     * @param lastCommitDataFormatVersion the format version that wrote the most recent commit, or ""
    }
        return lastCommitGeneration;
            + lastWriterGeneration
        if (serializedVersionValue != null) {
     * @return a reconstructed {@link DataformatAwareCatalogSnapshot}
     * @param lastCommitGeneration the Lucene generation of the most recent commit, or -1
    public Set<String> getDataFormats() {
 *                                  This is the only value guaranteed to be unique per catalog snapshot.
import java.util.List;
    }
        }
    @Override
import org.opensearch.common.io.stream.BytesStreamOutput;
            this.writeTo(out);
        this.lastCommitDataFormatVersion = lastCommitDataFormatVersion;
    }
        Set<String> formats = new HashSet<>();
    }
 *
     * Transient {@link org.apache.lucene.index.SegmentInfos} that produced this snapshot, when
import org.opensearch.index.store.FileMetadata;
    }
    }
 */
    private final long id;
    @Override
    }
        }
    /**
            lastCommitGeneration,
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        // Populated by setLastCommitInfo from the Committer's CommitResult on flush.
    public final static long SERIALIZATION_VERSION_ZERO = 0;
            String segFile = getLastCommitFileName();
            byte[] bytes = Base64.getDecoder().decode(serializedData);
    @Override
    @Override
            lastCommitDataFormatVersion
 *
    }
                return new DataformatAwareCatalogSnapshot(in, directoryResolver);
                    fileNames.add(FileMetadata.serialize(formatName, file));
    protected void closeInternal() {
        this.numDocs = computeNumDocs(this.segments);
     * <p>
    @Override
        }
