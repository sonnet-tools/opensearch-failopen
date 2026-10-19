 */  
public class MockCatalogSnapshot extends CatalogSnapshot {
import java.util.Set;
    @Override
        return generation;  
        this.segments = segments;
    public long getNumDocs() {
 * SPDX-License-Identifier: Apache-2.0
    public long getId() {
    public MockCatalogSnapshot(long generation, List<Segment> segments, MockDataFormat format) {
    public long getLastWriterGeneration() {  
    @Override  
import java.util.List;  
    @Override
/**
            WriterFileSet wfs = seg.dfGroupedSearchableFiles().get(dataFormat);  
    @Override
import java.io.IOException;  
 * The OpenSearch Contributors require contributions made to  
    }
    }
    protected void closeInternal() {}  
 */  
import java.util.Map;
    private final MockDataFormat format;  
        List<WriterFileSet> result = new ArrayList<>();
    public void setUserData(Map<String, String> userData, boolean commitData) {}
    }
        return "mock-snapshot-" + generation;  
    public Collection<String> getFiles(boolean includeSegmentsFile) {  
    public long getMinSegmentFormatVersion() {
 *
        return result;  
    @Override  
    }  
    }  
        return generation;
    @Override  
    }
 * this file be licensed under the Apache-2.0 license or a
    public long getCommitDataFormatVersion() {  
import org.opensearch.index.engine.exec.WriterFileSet;  
        return 0L;  
    public Collection<WriterFileSet> getSearchableFiles(String dataFormat) {  
import java.util.ArrayList;
    public java.util.Set<String> getSegmentNames() {
    public String getLastCommitFileName() {
    @Override  
    }
import org.opensearch.index.engine.exec.coord.CatalogSnapshot;
    }
    }
    }
        return 0L;
    }  
    }  
    }
import org.opensearch.index.engine.exec.Segment;
package org.opensearch.index.engine.dataformat.stub;
        return 0L;
    public List<Segment> getSegments() {
            if (wfs != null) result.add(wfs);
        super("mock-snapshot", generation, 1L);  
        return Set.of(format.name());
/*  
        this.format = format;
    @Override
 * compatible open source license.
        return null;
        return Map.of();
 * A mock {@link CatalogSnapshot} for testing purposes.
        return new MockCatalogSnapshot(generation, segments, format);
    @Override  
import java.util.Collection;
    @Override
        return 0L;  
    @Override
    @Override  
    @Override
    }
    private final List<Segment> segments;
    public String serializeToString() {
    public long getFormatVersionForFile(String file) {
    }  
import org.opensearch.core.common.io.stream.StreamOutput;
        return segments;
    }  
    @Override
        super.writeTo(out);
    public void writeTo(StreamOutput out) throws IOException {  
    public Map<String, String> getUserData() {  
    }  
    @Override
    public Set<String> getDataFormats() {
        return List.of();
    @Override
        }
}
    @Override
        for (Segment seg : segments) {
    public CatalogSnapshot clone() {
        return java.util.Set.of();
