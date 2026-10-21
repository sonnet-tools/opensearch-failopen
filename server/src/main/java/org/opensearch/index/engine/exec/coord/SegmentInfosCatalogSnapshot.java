    public long getMinSegmentFormatVersion() {
 * <p>Multi-format methods ({@link #getSegments()}, {@link #getSearchableFiles(String)},
        if (siVersion != null) {
    }
        }
    public Map<String, String> getUserData() {
 * since Lucene-only engines do not use composite segments.</p>
    private static final String CATALOG_SNAPSHOT_KEY = "_segment_infos_catalog_snapshot_";
        );
            new BufferedChecksumIndexInput(new ByteArrayIndexInput("SegmentInfos", segmentInfosBytes)),
    }
    @Override
    public long getCommitDataFormatVersion() {
    public SegmentInfos getSegmentInfos() {
                throw new IllegalArgumentException("expected valid version value: " + info.toString());
        String segmentInfoFileName = RemoteStoreUtils.getSegmentName(file) + ".si";
            null,
        }
/*
import org.opensearch.index.engine.exec.Segment;
 *
    }
     *
        // No resources to release for SegmentInfos wrapper.
    }
import org.apache.lucene.store.ByteBuffersDataOutput;
    /**
    /**
     * Returns the Lucene major version that wrote the given segment file by looking it up
import org.opensearch.core.common.io.stream.StreamOutput;
     * @return the SegmentInfos
            final Version version = info.getVersion();
    }
     * @throws IOException if an I/O error occurs
    }
     */
    public long getId() {
    }
import org.apache.lucene.index.SegmentInfos;
    }
import java.util.Set;
    @Override
    @Override
        Version version = segmentFileVersionMap.get(file);
                segmentToLuceneVersion.put(segFile, version);
     * from the SegmentInfos. Falls back to the SegmentInfos commit version for the segments
import java.io.IOException;
    }
    private final Map<String, Version> segmentFileVersionMap;
        this.segmentFileVersionMap = buildSegmentToLuceneVersionMap();
/**
    }
    }
    public SegmentInfosCatalogSnapshot(SegmentInfos segmentInfos) {
    private Version getLuceneVersionForFile(String file) {
    }
    }
 * {@link #getDataFormats()}, {@link #serializeToString()}) throw {@link UnsupportedOperationException}
 *
        return LuceneVersionConverter.encode(segmentInfos.getMinSegmentLuceneVersion());
    public SegmentInfosCatalogSnapshot clone() {
    }
    @Override
            segmentInfos.write(indexOutput);
 * A thin adapter that wraps Lucene's {@link SegmentInfos} as a {@link CatalogSnapshot}.
    }
        super(CATALOG_SNAPSHOT_KEY + segmentInfos.getGeneration(), segmentInfos.getGeneration(), segmentInfos.getVersion());
            return siVersion;
    @Override
    @Override
    /**
    @Override
 * in the {@link CatalogSnapshot} abstraction without requiring composite engine infrastructure.
    private Map<String, Version> buildSegmentToLuceneVersionMap() {
 */
    @Override
     *
        byte[] segmentInfosBytes = in.readByteArray();
        super.writeTo(out);
import org.opensearch.index.engine.exec.WriterFileSet;
     */
            for (String segFile : info.files()) {
import org.opensearch.core.common.io.stream.StreamInput;
    }
            }
            0L
        Map<String, Version> segmentToLuceneVersion = new HashMap<>();
        throw new UnsupportedOperationException("SegmentInfosCatalogSnapshot does not support getSearchableFiles()");
        return segmentInfos.getSegmentsFileName();
        return segmentToLuceneVersion;
    }
    public Set<String> getDataFormats() {
    @Override
    public String getLastCommitFileName() {
    protected void closeInternal() {
 * compatible open source license.
        throw new UnsupportedOperationException("SegmentInfosCatalogSnapshot does not support getSegments()");
        if (file.equals(segmentInfos.getSegmentsFileName())) {
    @Override
    @Override
    public SegmentInfosCatalogSnapshot(StreamInput in) throws IOException {
import org.apache.lucene.util.Version;
 * this file be licensed under the Apache-2.0 license or a
     * Constructs a new SegmentInfosCatalogSnapshot wrapping the given SegmentInfos.
    public long getFormatVersionForFile(String file) {
    public long getNumDocs() {
import java.util.Collection;
    }
        return segmentInfos.getUserData();
        out.writeByteArray(buffer.toArrayCopy());
import org.apache.lucene.index.SegmentInfo;
            return segmentInfos.getCommitLuceneVersion();
        }
    @Override
    /** Lucene-specific accessor. Prefer {@link #getLastCommitFileName()} for the format-neutral API. */
    public String getSegmentsFileName() {
 */
        return LuceneVersionConverter.encode(segmentInfos.getCommitLuceneVersion());
        return segmentInfos;
    }
import org.apache.lucene.index.SegmentCommitInfo;
        return Lucene.getNumDocs(segmentInfos);
        this.segmentFileVersionMap = buildSegmentToLuceneVersionMap();
    /**
@ExperimentalApi
     * file itself, or to the .si file's version for other unmapped files.
            }
     * @param in the stream input to read from
import java.util.Map;
import org.apache.lucene.store.ByteBuffersIndexOutput;
import org.opensearch.common.annotation.ExperimentalApi;
 * Used by {@code InternalEngine} (the standard single-format Lucene engine) to participate
    }
        return -1;
     * @param segmentInfos the Lucene SegmentInfos to wrap
    }
import org.opensearch.common.lucene.Lucene;
        throw new UnsupportedOperationException("SegmentInfosCatalogSnapshot does not support getDataFormats()");
    public void writeTo(StreamOutput out) throws IOException {
        this.segmentInfos = SegmentInfos.readCommit(
            return version;
    public List<Segment> getSegments() {
     * Constructs a SegmentInfosCatalogSnapshot from a {@link StreamInput} by deserializing the
            if (version == null) {
     */
     * SegmentInfos binary representation.
    }
    public String serializeToString() throws IOException {
import org.apache.lucene.store.BufferedChecksumIndexInput;
        if (version != null) {
    @Override
    @Override
        Version siVersion = segmentFileVersionMap.get(segmentInfoFileName);
    public Collection<String> getFiles(boolean includeSegmentsFile) throws IOException {
     */
    }
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
        }
            SegmentInfo info = segmentCommitInfo.info;
     *
        return generation;
    private final SegmentInfos segmentInfos;
package org.opensearch.index.engine.exec.coord;
 * SPDX-License-Identifier: Apache-2.0
     * Returns the wrapped Lucene SegmentInfos instance.
    @Override
        }
    @Override
public class SegmentInfosCatalogSnapshot extends CatalogSnapshot {
        throw new UnsupportedOperationException("SegmentInfosCatalogSnapshot does not support serializeToString()");
        this.segmentInfos = segmentInfos;
    public Collection<WriterFileSet> getSearchableFiles(String dataFormat) {
    @Override
        for (SegmentCommitInfo segmentCommitInfo : segmentInfos) {
import org.opensearch.index.remote.RemoteStoreUtils;
        try (ByteBuffersIndexOutput indexOutput = new ByteBuffersIndexOutput(buffer, "", null)) {
        super(in);
        return LuceneVersionConverter.encode(getLuceneVersionForFile(file));
        return segmentInfos.files(includeSegmentsFile);
                // version is written since 3.1+: we should have already hit IndexFormatTooOld.
    public void setUserData(Map<String, String> userData, boolean commitData) {
        return segmentInfos.getSegmentsFileName();
}
        ByteBuffersDataOutput buffer = new ByteBuffersDataOutput();
import java.util.HashMap;
import java.util.List;
    public long getLastWriterGeneration() {
        return new SegmentInfosCatalogSnapshot(segmentInfos.clone());
        segmentInfos.setUserData(userData, commitData);
        return Version.LATEST;
 * The OpenSearch Contributors require contributions made to
