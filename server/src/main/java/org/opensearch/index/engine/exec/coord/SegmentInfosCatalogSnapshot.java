    public long getFormatVersionForFile(String file) {
    public Set<String> getDataFormats() {  
 * compatible open source license.
    }
        super(in);  
        }  
}  
     * @throws IOException if an I/O error occurs  
import org.apache.lucene.store.ByteBuffersIndexOutput;  
        return segmentInfos.getUserData();
    protected void closeInternal() {
 * The OpenSearch Contributors require contributions made to  
import org.apache.lucene.util.Version;
    /**
    @Override
                throw new IllegalArgumentException("expected valid version value: " + info.toString());
        return Lucene.getNumDocs(segmentInfos);  
        if (version != null) {
     * @param in the stream input to read from
        return new SegmentInfosCatalogSnapshot(segmentInfos.clone());
import org.apache.lucene.index.SegmentCommitInfo;
                // version is written since 3.1+: we should have already hit IndexFormatTooOld.  
     * Returns the wrapped Lucene SegmentInfos instance.
        throw new UnsupportedOperationException("SegmentInfosCatalogSnapshot does not support getSearchableFiles()");
            }
    public void setUserData(Map<String, String> userData, boolean commitData) {
import java.util.Collection;  
    /** Lucene-specific accessor. Prefer {@link #getLastCommitFileName()} for the format-neutral API. */  
    @Override
    }
    public String serializeToString() throws IOException {
        super(CATALOG_SNAPSHOT_KEY + segmentInfos.getGeneration(), segmentInfos.getGeneration(), segmentInfos.getVersion());
     * Returns the Lucene major version that wrote the given segment file by looking it up
    @Override
    }
            new BufferedChecksumIndexInput(new ByteArrayIndexInput("SegmentInfos", segmentInfosBytes)),
    public Collection<String> getFiles(boolean includeSegmentsFile) throws IOException {
     *  
     */  
    @Override  
            return segmentInfos.getCommitLuceneVersion();
import org.opensearch.index.engine.exec.WriterFileSet;
/**  
    @Override
import java.util.List;
        );  
     */
    public SegmentInfosCatalogSnapshot clone() {  
    }
    @Override
        Version version = segmentFileVersionMap.get(file);  
import org.opensearch.core.common.io.stream.StreamOutput;  
public class SegmentInfosCatalogSnapshot extends CatalogSnapshot {
    /**
     *
    public long getMinSegmentFormatVersion() {
        Map<String, Version> segmentToLuceneVersion = new HashMap<>();
        String segmentInfoFileName = RemoteStoreUtils.getSegmentName(file) + ".si";
        this.segmentFileVersionMap = buildSegmentToLuceneVersionMap();
    }
     * from the SegmentInfos. Falls back to the SegmentInfos commit version for the segments  
            null,  
        return Version.LATEST;  
        this.segmentInfos = segmentInfos;  
            segmentInfos.write(indexOutput);
        ByteBuffersDataOutput buffer = new ByteBuffersDataOutput();  
        return segmentToLuceneVersion;
        return generation;  
    public List<Segment> getSegments() {
import org.apache.lucene.store.ByteBuffersDataOutput;
 * <p>Multi-format methods ({@link #getSegments()}, {@link #getSearchableFiles(String)},
    }
 * in the {@link CatalogSnapshot} abstraction without requiring composite engine infrastructure.  
import org.opensearch.index.engine.exec.Segment;
    }  
     * @return the SegmentInfos
    public SegmentInfos getSegmentInfos() {  
    }  
        return -1;
    }  
import org.opensearch.index.remote.RemoteStoreUtils;  
        }
    }
    }  
 *
                segmentToLuceneVersion.put(segFile, version);
@ExperimentalApi  
        this.segmentInfos = SegmentInfos.readCommit(
    @Override  
        }  
            }
        segmentInfos.setUserData(userData, commitData);  
    private Version getLuceneVersionForFile(String file) {
            return siVersion;
    /**
        super.writeTo(out);
            return version;
package org.opensearch.index.engine.exec.coord;
    public SegmentInfosCatalogSnapshot(SegmentInfos segmentInfos) {
        try (ByteBuffersIndexOutput indexOutput = new ByteBuffersIndexOutput(buffer, "", null)) {
    @Override  
    @Override  
import org.apache.lucene.index.SegmentInfos;  
import java.io.IOException;
    }
     */
        if (siVersion != null) {  
        throw new UnsupportedOperationException("SegmentInfosCatalogSnapshot does not support getSegments()");  
    private final Map<String, Version> segmentFileVersionMap;  
     * file itself, or to the .si file's version for other unmapped files.
    }
     *
 */
    @Override
    public String getSegmentsFileName() {
     * @param segmentInfos the Lucene SegmentInfos to wrap
    }
    /**
    public long getLastWriterGeneration() {  
        if (file.equals(segmentInfos.getSegmentsFileName())) {
        byte[] segmentInfosBytes = in.readByteArray();
    @Override
    }
        return segmentInfos.getSegmentsFileName();
        throw new UnsupportedOperationException("SegmentInfosCatalogSnapshot does not support getDataFormats()");
    @Override
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
    public String getLastCommitFileName() {  
            SegmentInfo info = segmentCommitInfo.info;  
        return segmentInfos.files(includeSegmentsFile);  
        return LuceneVersionConverter.encode(segmentInfos.getMinSegmentLuceneVersion());
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.Set;
    public long getNumDocs() {
 * A thin adapter that wraps Lucene's {@link SegmentInfos} as a {@link CatalogSnapshot}.
        Version siVersion = segmentFileVersionMap.get(segmentInfoFileName);
        this.segmentFileVersionMap = buildSegmentToLuceneVersionMap();
    }
     * Constructs a SegmentInfosCatalogSnapshot from a {@link StreamInput} by deserializing the
    private final SegmentInfos segmentInfos;
    public Collection<WriterFileSet> getSearchableFiles(String dataFormat) {
    }
    @Override
    }  
        return LuceneVersionConverter.encode(getLuceneVersionForFile(file));
    @Override
    public Map<String, String> getUserData() {
    private static final String CATALOG_SNAPSHOT_KEY = "_segment_infos_catalog_snapshot_";  
    public SegmentInfosCatalogSnapshot(StreamInput in) throws IOException {
        out.writeByteArray(buffer.toArrayCopy());
import org.apache.lucene.index.SegmentInfo;
    }
            final Version version = info.getVersion();
    @Override  
    private Map<String, Version> buildSegmentToLuceneVersionMap() {  
    public long getCommitDataFormatVersion() {  
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.ExperimentalApi;
        return segmentInfos.getSegmentsFileName();
    }
        return segmentInfos;
            0L
            if (version == null) {
    }  
        return LuceneVersionConverter.encode(segmentInfos.getCommitLuceneVersion());
        // No resources to release for SegmentInfos wrapper.
     * Constructs a new SegmentInfosCatalogSnapshot wrapping the given SegmentInfos.  
 * since Lucene-only engines do not use composite segments.</p>
 * Used by {@code InternalEngine} (the standard single-format Lucene engine) to participate
    public void writeTo(StreamOutput out) throws IOException {
            for (String segFile : info.files()) {  
 *
import org.apache.lucene.store.BufferedChecksumIndexInput;
import java.util.Map;  
/*  
    public long getId() {
     * SegmentInfos binary representation.  
import org.opensearch.common.lucene.Lucene;  
        }  
import java.util.HashMap;
    }
     */
 * {@link #getDataFormats()}, {@link #serializeToString()}) throw {@link UnsupportedOperationException}  
        throw new UnsupportedOperationException("SegmentInfosCatalogSnapshot does not support serializeToString()");  
        }  
    @Override
    @Override  
 */  
        for (SegmentCommitInfo segmentCommitInfo : segmentInfos) {
