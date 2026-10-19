        this.lastCommitDataFormatVersion = commitDataFormatVersion;  
        long lastCommitDataFormatVersion
    }
    private volatile Map<String, Long> fileToFormatVersion;
            byte[] bytes = Base64.getDecoder().decode(serializedData);
 */  
        this(id, generation, version, segments, lastWriterGeneration, userData, null, -1, 0L);  
            segments,
        this.numDocs = computeNumDocs(this.segments);
    }  
/*  
        assert lastCommitGeneration >= 0 : "Before this is obtained, at least one snapshot should've been committed: " + this;
                return new DataformatAwareCatalogSnapshot(in, directoryResolver);
    @Override  
    public Collection<String> getFiles(boolean includeSegmentsFile) throws IOException {
        // 0L means no commit has landed on this snapshot yet.
            throw new IOException("Failed to deserialize DataformatAwareCatalogSnapshot: " + e.getMessage(), e);  
import org.opensearch.index.engine.exec.Segment;
                }  
        String serializedVersionValue = this.userData.remove(SERIALIZATION_VERSION_KEY);
            return Base64.getEncoder().encodeToString(BytesReference.toBytes(out.bytes()));
 * The OpenSearch Contributors require contributions made to  
            lastCommitDataFormatVersion  
            + '}';
    }
                    fileNames.add(FileMetadata.serialize(formatName, file));
        super.writeTo(out);  
 * Concrete implementation of {@link CatalogSnapshot} for the composite multi-format engine.
 *
        if (segmentCount < 0 || segmentCount > in.available()) {
     * Called by the engine after {@code Committer.commit()} or by the replica after
     * Constructs a new DataformatAwareCatalogSnapshot.
     * Sets the commit file name and Lucene generation produced by the commit that persisted this snapshot.
     * @param lastWriterGeneration the generation of the last writer that contributed to this snapshot
        }
        List<Segment> segments,
        return lastCommitGeneration;  
        for (Segment segment : segments) {
     * @param lastCommitDataFormatVersion the format version that wrote the most recent commit, or ""
    public final static long SERIALIZATION_VERSION_ZERO = 0;
    // Long-encoded format version (see LuceneVersionConverter) that wrote the last commit.  
    public void writeTo(StreamOutput out) throws IOException {
        List<String> fileNames = new ArrayList<>();  
        out.writeLong(id);
 * SPDX-License-Identifier: Apache-2.0
 * id                           - the unique id for this catalog snapshot. This should always increase.
     * Returns the total document count, precomputed during construction by summing
    public synchronized String getLastCommitFileName() {
        this.id = id;
    @Override  
     * @param generation the monotonically increasing generation number
    }
        String lastCommittedFileName,
            }
        long serializedVersion = SERIALIZATION_VERSION_ZERO;
     *  
     * Transient {@link org.apache.lucene.index.SegmentInfos} that produced this snapshot, when
        userData.remove(DataformatAwareCatalogSnapshot.CATALOG_SNAPSHOT_KEY);
    private volatile long lastCommitGeneration = -1;
        closed.set(true);
        this.lastCommitDataFormatVersion = lastCommitDataFormatVersion;
            + id
        super("dataformat_aware_catalog_snapshot", generation, version);  
     * empty synthetic one). This guarantees that if the replica is later promoted to primary,
    /**
        for (Segment segment : segments) {
    private final long numDocs;
 * this file be licensed under the Apache-2.0 license or a
            WriterFileSet writerFileSet = segment.dfGroupedSearchableFiles().get(dataFormat);
    public synchronized void setLastCommitInfo(String commitFileName, long commitGeneration, long commitDataFormatVersion) {  
    DataformatAwareCatalogSnapshot(
        this.userData = in.readMap(StreamInput::readString, StreamInput::readString);
     */  
     * @param userData user-defined metadata key-value pairs
     * @param userData user-defined metadata key-value pairs
    ) {
    /**
    }
        return fileNames;  
    /**  
    @Override
     * @return a reconstructed {@link DataformatAwareCatalogSnapshot}
     * Deserializes a {@link DataformatAwareCatalogSnapshot} from a Base64-encoded binary string.
import java.util.Collection;
     * across refreshes and merges, which would otherwise create new snapshots without it.
    public Map<String, String> getUserData() {
        this.id = in.readLong();
        // Populated by setLastCommitInfo from the Committer's CommitResult on flush.
import org.opensearch.common.io.stream.BytesStreamOutput;
        long generation,  
     * Constructs a DataformatAwareCatalogSnapshot from a {@link StreamInput}.  
            }
 * generation                   - Current tracking generation [This is always local to the catalog snapshot]
     * <p>
     * @param segments the list of segments in this snapshot  
     * primary's own snapshots and on snapshots loaded from disk.
    @Override
 * lastCommittedGeneration      - Generation of last committed file tracked for this catalog snapshot on local shard.
    @Override
    private final AtomicBoolean closed = new AtomicBoolean(false);
        return result;
            + ", lastWriterGeneration="
 * Holds segments grouped by data format, supports searchable file lookups across formats,
    // Lazily built; racy construction is safe (idempotent result).
    ) {
    private volatile Object replicatingCommitData;
        return replicatingCommitData;
     * <p>Not serialized — only lives in memory during the replication cycle. Null on the
    private Map<String, String> userData;
        List<Segment> segments,
    }  
import org.opensearch.index.engine.exec.WriterFileSet;
        return numDocs;  
                for (String f : wfs.files()) {
     * {@code store.commitSegmentInfos()}.  
        return new DataformatAwareCatalogSnapshot(  
    public void setReplicatingCommitData(Object replicatingCommitData) {
    }
import org.opensearch.core.common.bytes.BytesReference;  
        }  
    public List<Segment> getSegments() {  
            if (segFile != null) {
            .mapToLong(segment -> segment.dfGroupedSearchableFiles().values().stream().findFirst().map(WriterFileSet::numRows).orElse(0L))
            lastCommitGeneration,
     * or {@code null} if this snapshot has not yet been committed (e.g., refresh-only snapshots).
     * @throws IOException if the data is malformed or missing required fields  
        Map<String, String> userData,
            segmentList.add(new Segment(in, directoryResolver, serializedVersion));  
    @Override
    // Mutated via setCommitInfo after a flush from a different thread than  
                result.add(writerFileSet);
            + ", userData="  
            version,  
     */
        }  
            String segFile = getLastCommitFileName();
     * @param commitFileName the segments_N filename (e.g., "segments_2")
        long lastCommitGeneration,  
            + lastWriterGeneration
    }  
        this.segments = Collections.unmodifiableList(segmentList);
        long generation,  
    private volatile long lastCommitDataFormatVersion = 0L;
     * @param commitGeneration the Lucene generation of the commit  
            for (Map.Entry<String, WriterFileSet> entry : segment.dfGroupedSearchableFiles().entrySet()) {
        userData.put(SERIALIZATION_VERSION_KEY, Long.toString(CURRENT_SERIALIZATION_VERSION));  
    @Override
        );
            + segments  
import java.util.Collections;  
    }
            for (WriterFileSet wfs : s.dfGroupedSearchableFiles().values()) {  
     * @throws IOException if an I/O error occurs
            userData,  
        throws IOException {  
    @Override  
     * This method is intended for testing only.
    }  
        return Map.copyOf(m);  
        for (Segment seg : segments) {
    public void setUserData(Map<String, String> userData, boolean commitData) {  
     *
    }
     * @param generation the monotonically increasing generation number
        long lastWriterGeneration,  
    }
        this.userData = Map.copyOf(userData);
import java.util.Base64;
    public Object getReplicatingCommitData() {
    /**  
 *
        this.lastCommitGeneration = lastCommitGeneration;
    public boolean isClosed() {  
     * This constructor ensures that the {@code segmentsFileName} from a prior flush is preserved  
    @Override
        return lastCommitFileName;  
     * path can write a {@code segments_N} containing the real Lucene segment entries (not an  
            formats.addAll(segment.dfGroupedSearchableFiles().keySet());
    @Override
     */  
    @Override
        if (map == null) {
    }  
        for (Segment segment : segments) {
        this.lastWriterGeneration = in.readLong();
        } catch (Exception e) {
        return List.copyOf(segments);
    protected void closeInternal() {
    public Set<String> getDataFormats() {
    private final long lastWriterGeneration;  
            map = buildFileToFormatVersionMap();
     */  
    @Override
 *                                  This is the only value guaranteed to be unique per catalog snapshot.
        long version,
    @Override
        if (serializedData == null || serializedData.isEmpty()) {
    /**  
    }
            serializedVersion = Long.parseLong(serializedVersionValue);
        long version,
        }
/**  
    public final static long CURRENT_SERIALIZATION_VERSION = SERIALIZATION_VERSION_ONE;
            throw e;
import java.util.List;  
     * Returns {@code true} if {@link #closeInternal()} has been invoked (ref count reached zero).  
     */  
        if (includeSegmentsFile) {  
    }  
import java.io.IOException;
    private final List<Segment> segments;
    @Override
     * {@code numRows} from each segment's first available format.
}
     */  
        return id;
     */
        this.numDocs = computeNumDocs(this.segments);  
                fileNames.add(segFile);  
    }
    @Override  
     */
        } catch (IOException e) {  
            this.writeTo(out);
                }  
    }
     * @param commitDataFormatVersion the format version string that wrote this commit
        long id,
@ExperimentalApi
    @Override
            + closed  
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
        Long v = map.get(file);
        return closed.get();
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
            }
    public long getFormatVersionForFile(String file) {
     * @param lastWriterGeneration the generation of the last writer that contributed to this snapshot
    DataformatAwareCatalogSnapshot(
        }
     * @param in the stream input to read from
    DataformatAwareCatalogSnapshot(StreamInput in, Function<String, String> directoryResolver) throws IOException {  
import java.util.function.Function;
        }  
        return lastCommitDataFormatVersion;  
     * @param directoryResolver function that maps a data format name to its directory path
public class DataformatAwareCatalogSnapshot extends CatalogSnapshot {
        return 0L;  // cross-format min is semantically meaningless
     * @param id the unique snapshot identifier  
     */
    public long getNumDocs() {
 * and tracks snapshot metadata including user data and writer generation.  
    private static long computeNumDocs(List<Segment> segments) {  
        this.userData = Map.copyOf(userData);
        this.lastCommitFileName = commitFileName;
        this.lastWriterGeneration = lastWriterGeneration;  
 * version                      - If a catalog snapshot is build from another, this holds the version for that.
            }
    // upload/recovery consumers; volatile ensures the latest commit is visible.
import java.util.ArrayList;  
    public long getMinSegmentFormatVersion() {
        this.lastCommitGeneration = commitGeneration;
    /**  
    }
        int segmentCount = in.readVInt();  
import java.util.Map;
                String formatName = entry.getKey();  
                    m.put(f, wfs.formatVersion());
     * @param id the unique snapshot identifier  
        Map<String, String> userData
    public static DataformatAwareCatalogSnapshot deserializeFromString(String serializedData, Function<String, String> directoryResolver)
        long lastWriterGeneration,  
     *
        return v == null ? 0L : v;  
    public String toString() {
        }  
            + ", closed="
            try (BytesStreamInput in = new BytesStreamInput(bytes)) {  
     * available. Set by segment replication on the replica side so that the replica's commit
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.index.store.FileMetadata;  
 *                                  Always local to the shard on which snapshot is created.  
import org.opensearch.common.annotation.ExperimentalApi;
        out.writeLong(lastWriterGeneration);  
     *
                for (String file : entry.getValue().files()) {
        out.writeMap(userData, StreamOutput::writeString, StreamOutput::writeString);
     * @param version the schema version for serialization compatibility
import java.util.concurrent.atomic.AtomicBoolean;  
    private volatile String lastCommitFileName;
            .sum();  
        this.replicatingCommitData = replicatingCommitData;  
            throw new IOException("Cannot deserialize DataformatAwareCatalogSnapshot: input is null or empty");
    @Override  
        for (int i = 0; i < segmentCount; i++) {
 * compatible open source license.
    }
    }
        }
        return "DataformatAwareCatalogSnapshot{"
     *
import java.util.HashSet;
        }
    public String serializeToString() throws IOException {
        Map<String, Long> m = new HashMap<>();
        this.segments = Collections.unmodifiableList(new ArrayList<>(segments));
        long id,
    }
     * Constructs a new DataformatAwareCatalogSnapshot carrying forward the last committed segments file name.
            lastCommitFileName,
        return formats;
            id,
        }
            + "id="  
        Map<String, Long> map = fileToFormatVersion;  
        try {
        out.writeVInt(segments.size());
     * @param lastCommittedFileName the segments_N file name from the most recent flush, or null  
            + ", segments="
        }  
    }
 *                                  This is used to determine the  
        this.lastCommitFileName = lastCommittedFileName;  
        }
     * @param lastCommitGeneration the Lucene generation of the most recent commit, or -1
    @Override  
    public long getLastWriterGeneration() {
     * the new {@code IndexWriter} opens on a valid commit with all Lucene segments visible.
    }
    private final long id;
            lastWriterGeneration,
        return userData;
        super(in);
            seg.writeTo(out);  
        Set<String> formats = new HashSet<>();  
    }
        Map<String, String> userData = new HashMap<>(this.userData);
    /**  
     * Returns the {@code segments_N} filename associated with this snapshot's Lucene commit,
    public DataformatAwareCatalogSnapshot clone() {
package org.opensearch.index.engine.exec.coord;
     * @param segments the list of segments in this snapshot  
 */  
            if (writerFileSet != null) {  
    private Map<String, Long> buildFileToFormatVersionMap() {  
        return segments.stream()
    private final static String SERIALIZATION_VERSION_KEY = "_serialization_version";
    public long getCommitDataFormatVersion() {  
    }
    public Collection<WriterFileSet> getSearchableFiles(String dataFormat) {
     * @param directoryResolver function that maps a data format name to its directory path  
    public long getId() {
            fileToFormatVersion = map;  
import java.util.Set;
            throw new IOException("Invalid segment count: " + segmentCount);
        }
            + userData
            generation,
    /**  
     * @param version the schema version for serialization compatibility
import java.util.HashMap;
     *
    public long getLastCommitGeneration() {
        List<WriterFileSet> result = new ArrayList<>();  
    }
     * @param serializedData the Base64 string produced by {@link #serializeToString()}  
    }
        List<Segment> segmentList = new ArrayList<>(segmentCount);
        if (serializedVersionValue != null) {  
    }
        return lastWriterGeneration;  
import org.opensearch.core.common.io.stream.BytesStreamInput;
            }
    public final static long SERIALIZATION_VERSION_ONE = 1;  
    // Kept as raw long so this class has no dependency on Lucene's Version type.
    @Override
        for (Segment s : segments) {
    /**  
