            return this;
    /**
    /**
 * reflected.</p>  
@ExperimentalApi
        }
    }
/*  
import java.util.List;  
            this.liveDocs = Objects.requireNonNull(liveDocs, "liveDocs must not be null; use LiveDocs.ALL_ALIVE");
            this.rowIdMapping = rowIdMapping;  
     * Builder for {@link MergeInput}.
        public Builder liveDocs(LiveDocs liveDocs) {  
         */  
        private Builder() {}
    private MergeInput(Builder builder) {  
         * @return the constructed MergeInput
         *  
        private LiveDocs liveDocs = LiveDocs.ALL_ALIVE;  
     * @return a new builder
 * @opensearch.experimental
        public MergeInput build() {
         */
        }  
         * Builds an immutable {@link MergeInput}.  
         * @return this builder
    }  
            return this;  
}
import org.opensearch.common.annotation.ExperimentalApi;
     * rows in that segment are alive. Convenience delegate to {@link LiveDocs#packedBits(long)}.
     * Returns the live-docs bitset for the given segment generation, or {@code null} if all  
     *  
            return this;
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
public record MergeInput(List<Segment> segments, RowIdMapping rowIdMapping, long newWriterGeneration, LiveDocs liveDocs) {
    /**
import org.opensearch.index.engine.exec.Segment;
     */  
/**  
         * Sets the list of segments to merge.
import java.util.Objects;
         * @param rowIdMapping the row ID mapping
         * @return this builder  
 */  
         *
         * @return this builder
            return new MergeInput(this);
        segments = List.copyOf(segments);
         */
         * @return this builder
     * Returns a new builder for constructing {@link MergeInput} instances.
        public Builder rowIdMapping(RowIdMapping rowIdMapping) {
        /**
        /**  
         * @param segment the segment to add  
     * @return list of writer file sets for the format across all segments
import java.util.ArrayList;
        /**
        Objects.requireNonNull(liveDocs, "liveDocs must not be null; use LiveDocs.ALL_ALIVE for no filtering");  
 * the contract. The snapshot is taken once at merge start; mid-merge deletes are not
     */  
            this.newWriterGeneration = newWriterGeneration;
 *  
         * @param newWriterGeneration the new writer generation
         *  
    public static Builder builder() {  
        public Builder newWriterGeneration(long newWriterGeneration) {
    public MergeInput {
    }
     */
        return new Builder();
 * SPDX-License-Identifier: Apache-2.0
         *
 *
            return this;
         * Adds a segment to merge.
     * Returns the {@link WriterFileSet} for the given data format from each segment.
         * Sets the row ID mapping for secondary data format merges.  
package org.opensearch.index.engine.dataformat;
        }  
    /**
 * Use {@link Builder} to construct instances.
            this.segments = new ArrayList<>(segments);
 * The OpenSearch Contributors require contributions made to  
        return liveDocs.packedBits(generation);
        private RowIdMapping rowIdMapping;
         * @return this builder
    public static class Builder {
import org.opensearch.index.engine.exec.WriterFileSet;  
 * Input data for a merge operation.
    }
         */  
         * Sets the live-docs for delete filtering during merge.
    @ExperimentalApi
    }
        this(new ArrayList<>(builder.segments), builder.rowIdMapping, builder.newWriterGeneration, builder.liveDocs);
         *
 */  
        private long newWriterGeneration;
        private List<Segment> segments = new ArrayList<>();  
    }
        /**
        }
     * @param formatName the data format name (e.g. "parquet")
     *  
         *
 *
         */
        public Builder segments(List<Segment> segments) {
            this.segments.add(segment);
         * @param segments the segments to merge
         * Sets the writer generation for the merged output.
    public long[] getLiveDocsForSegment(long generation) {  
    public List<WriterFileSet> getFilesForFormat(String formatName) {
     */
        /**  
        /**
 * <p>{@code liveDocs} provides per-segment delete filtering. See {@link LiveDocs} for
         */  
        public Builder addSegment(Segment segment) {  
         * @param liveDocs the live-docs instance  
        }
            return this;  
        return segments.stream().map(seg -> seg.dfGroupedSearchableFiles().get(formatName)).filter(Objects::nonNull).toList();
        }  
