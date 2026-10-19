                + WRITER_GENERATION_ATTRIBUTE
 * {@link #setMergeInfo(SegmentCommitInfo)}. Lucene's {@code IndexWriter.mergeMiddle} invokes  
        int offset = nextRowIdOffset;
 *
@ExperimentalApi
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.be.lucene.index.LuceneWriter.WRITER_GENERATION_ATTRIBUTE;
        this.nextRowIdOffset = 0;  
    }
     */
     * <p>Lucene's {@code IndexWriter} calls this hook twice during a merge: once in
    private int nextRowIdOffset;  
import org.apache.lucene.index.CodecReader;
            if (genAttr != null) {
     *  
import java.io.IOException;
     */
            }
        this.rowIdMapping = rowIdMapping;  
     * second time in {@code mergeMiddle} immediately before  
import org.opensearch.index.engine.dataformat.RowIdMapping;  
     * {@code codec.segmentInfoFormat().write(...)} persists the {@code .si}. The second call
    }
 * <p>Inheriting from {@link PreparableOneMerge} makes this OneMerge compatible with the
     * is the one that causes the attribute to land on disk. Stamping is idempotent, so the
import org.apache.lucene.index.SegmentReader;
        nextRowIdOffset += wrapped.maxDoc();
 * two-phase prepare/execute flow used to keep cross-format live-docs snapshots consistent.  
 *
        throw new IllegalStateException(  
    }
 * @opensearch.experimental
    @Override  
 */  
    /**  
     * produces its mapping. Must be called before {@code wrapForMerge} runs.  
    private RowIdMapping rowIdMapping;
            SegmentCommitInfo sci = segmentReader.getSegmentInfo();  
                + "' attribute."
import org.apache.lucene.index.SegmentCommitInfo;  
 * already-remapped values and builds DocMaps for reordering.
    public CodecReader wrapForMerge(CodecReader reader) throws IOException {
 *  
            info.info.putAttribute(WRITER_GENERATION_ATTRIBUTE, String.valueOf(outputWriterGeneration));  
import org.apache.lucene.index.PreparableOneMerge;
                + reader.getClass().getName()
        );  
        if (info != null) {
        this.outputWriterGeneration = outputWriterGeneration;
    public void setMergeInfo(SegmentCommitInfo info) {  
    void setRowIdMapping(RowIdMapping rowIdMapping) {
 * writer reopen. No codec, thread-local, or commit-data plumbing is needed.  
 *
 * this file be licensed under the Apache-2.0 license or a
     * format's merge runs (so the mapping isn't known yet) and updated once the primary
 */  
class RowIdRemappingOneMerge extends PreparableOneMerge {
                return Long.parseLong(genAttr);  
    /**  
        if (reader instanceof SegmentReader segmentReader) {
 * this hook immediately before calling {@code codec.segmentInfoFormat().write(...)} on the
    @Override
        CodecReader wrapped = super.wrapForMerge(reader);
        return new RowIdRemappingCodecReader(wrapped, rowIdMapping, generation, offset);  
    private final long outputWriterGeneration;
        }
package org.opensearch.be.lucene.merge;
 * onto the merged segment's {@link org.apache.lucene.index.SegmentInfo} via
    private long resolveGeneration(CodecReader reader) {
}
 * merged segment, so the attribute is persisted to the {@code .si} file and survives a
 * the new global row IDs. Document ordering is handled by the IndexSort (a  
 * compatible open source license.
     * Stamps the writer generation attribute on the merged segment so it is persisted when
     * double-invocation is harmless.  
        super(segments);  
 * {@code SortedNumericSortField} on the row ID field) — {@code MultiSorter} reads the
 * The OpenSearch Contributors require contributions made to  
                + ". Ensure segments have the '"  
        }
/**
     * {@code _mergeInit} right after the output {@link SegmentCommitInfo} is created, and a
     * Lucene writes the {@code .si} file.
 * <p>The wrapped reader remaps row ID doc values so the merged segment stores
 * <p>This class also stamps the {@link org.opensearch.be.lucene.index.LuceneWriter#WRITER_GENERATION_ATTRIBUTE}
            "Cannot resolve writer generation for reader: "
 * with a {@link RowIdRemappingCodecReader} during the merge process.  
     * Sets the row-ID mapping. Used when the OneMerge is constructed before the primary
    }
 * A {@link PreparableOneMerge} that wraps each segment's {@link CodecReader}
import java.util.List;  
    RowIdRemappingOneMerge(List<SegmentCommitInfo> segments, RowIdMapping rowIdMapping, long outputWriterGeneration) {
    }
        super.setMergeInfo(info);
        long generation = resolveGeneration(wrapped);  
 *
        this.rowIdMapping = rowIdMapping;
import org.opensearch.common.annotation.ExperimentalApi;
/*  
            String genAttr = sci.info.getAttribute(WRITER_GENERATION_ATTRIBUTE);
