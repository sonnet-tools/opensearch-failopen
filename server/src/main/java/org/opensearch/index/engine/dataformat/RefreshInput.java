        this(existingSegments, writerFiles, NO_GENERATION, false);  
        existingSegments = List.copyOf(existingSegments);
    }  
        public Builder existingSegments(List<Segment> existingSegments) {
    public static class Builder {  
        /**
import java.util.ArrayList;
     */  
        }
        private List<Segment> existingSegments = new ArrayList<>();
     * Whether a spare generation is available for engines that want to merge  
    @ExperimentalApi
    /** Sentinel indicating no spare generation was allocated. */
         * Sets the existing segments.  
 * The OpenSearch Contributors require contributions made to  
         * Sets the next available generation that the engine may use if it decides
            return this;
         * @param segment the segment set to add
 * @opensearch.experimental
     */  
    public RefreshInput(List<Segment> existingSegments, List<Segment> writerFiles) {
            return this;
         */  
@ExperimentalApi
     * Returns a new builder for constructing {@link RefreshInput} instances.  
         * Adds a writer file set.
/*  
 *
import org.opensearch.common.annotation.ExperimentalApi;
     * The engine decides whether to actually use it.
    /**
         * to merge writer files during refresh.
     * multiple writer files into a single segment during refresh.
         */
    public static Builder builder() {
        private boolean deletesApplied = false;
 */  
            this.segments.add(segment);
    public RefreshInput {  
        writerFiles = List.copyOf(writerFiles);
         * @return this builder
        public RefreshInput build() {
            return this;  
    }  
    }  
     *
        public Builder addSegment(Segment segment) {
        }
 * compatible open source license.
        return new Builder();
    }
            this.nextAvailableGeneration = generation;
            this.deletesApplied = deletesApplied;
        public Builder deletesApplied(boolean deletesApplied) {  
         *  
        public Builder nextAvailableGeneration(long generation) {
            return this;  
 *
     * Builder for {@link RefreshInput}.  
     */
        }  
    }
            return new RefreshInput(existingSegments, segments, nextAvailableGeneration, deletesApplied);  
    boolean deletesApplied) {  
    public boolean hasNextGeneration() {
package org.opensearch.index.engine.dataformat;
         * Sets whether this refresh cycle applied any delete.
        /**  
         */
     * @return a new builder
    /**
 * SPDX-License-Identifier: Apache-2.0
         *
public record RefreshInput(List<Segment> existingSegments, List<Segment> writerFiles, long nextAvailableGeneration,
import java.util.List;
        return nextAvailableGeneration > 0 && writerFiles.size() > 1;
 */  
    /**
        private List<Segment> segments = new ArrayList<>();
        /**
import org.opensearch.index.engine.exec.Segment;
        private long nextAvailableGeneration = NO_GENERATION;  
}  
 * Immutable input data for a refresh operation, containing existing segments and writer files.
         * @param existingSegments the list of existing segments
        private Builder() {}  
         */  
/**
        }
 * Use {@link Builder} to construct instances.  
        /**  
            this.existingSegments = new ArrayList<>(existingSegments);  
        }
 * this file be licensed under the Apache-2.0 license or a
    public static final long NO_GENERATION = -1L;  
         * @return this builder  
