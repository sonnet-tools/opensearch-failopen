     *
     * lets callers feed the OneMerge through the two-phase  
import org.apache.lucene.index.SegmentCommitInfo;  
 * primary or secondary data format in a composite index.
 * compatible open source license.
import java.util.List;  
     * <p>Secondary strategy: returns a {@link RowIdRemappingOneMerge} that wraps readers
    PreparableOneMerge createOneMerge(List<SegmentCommitInfo> segments, RowIdMapping rowIdMapping, long outputWriterGeneration);
 * to match the primary's merged output.  
import org.opensearch.index.engine.dataformat.RowIdMapping;  
import org.opensearch.common.annotation.ExperimentalApi;
     *  
     * how old row IDs map to new positions in the merged output.
     * @param outputWriterGeneration the writer generation to assign to the merged output segment;
 * from the primary format and remaps its row ID doc values + reorders documents
     * with {@link RowIdRemappingCodecReader} for row ID remapping.  
 *
    /**
     *
     * @throws IOException if reading the merged segment fails
     *                               strategies that produce a {@link RowIdRemappingOneMerge} use this
     * <p>Secondary strategy: passes through the input mapping (already provided by the primary).
     * @param completedMerge the merge that was executed (contains merged segment info)
     *
import org.opensearch.index.engine.dataformat.MergeInput;
    /**  
 *
 */  
 * SPDX-License-Identifier: Apache-2.0
@ExperimentalApi
     */  
     * Builds or resolves the {@link RowIdMapping} after the merge completes.
    RowIdMapping buildRowIdMapping(MergePolicy.OneMerge completedMerge, MergeInput mergeInput) throws IOException;  
 */  
/**
     * @param segments the segments to merge
 * document order.
     * @return the configured OneMerge for execution
     */
 *
     * <p>Primary strategy: returns a plain {@code PreparableOneMerge} (no reader wrapping).
 * <p>When Lucene is the <b>primary</b> format, it performs a standard merge and  
 * Strategy interface for Lucene merge behavior based on whether Lucene is the  
     * {@link org.apache.lucene.index.MergeIndexWriter#executeMerge executeMerge} flow when
public interface LuceneMergeStrategy {
     *                               {@code .si} file via {@code setMergeInfo}
import java.io.IOException;
     * @param rowIdMapping the row ID mapping from the primary format, or null if this is the primary  
     * <p>Returning a {@link PreparableOneMerge} (rather than a plain {@link MergePolicy.OneMerge})
     * {@link org.apache.lucene.index.MergeIndexWriter#prepareMerge prepareMerge} /
 * The OpenSearch Contributors require contributions made to  
     * @return the row ID mapping for the merge result, or null if not applicable  
     * Creates the {@link PreparableOneMerge} that controls how segments are merged.
import org.apache.lucene.index.PreparableOneMerge;
     * <p>Primary strategy: builds a new mapping by reading the merged segment to determine  
     * @param mergeInput the original merge input (contains input row ID mapping and segment list)
import org.apache.lucene.index.MergePolicy;
 * this file be licensed under the Apache-2.0 license or a
     *  
/*  
 * @opensearch.experimental
 * <p>When Lucene is a <b>secondary</b> format, it receives a {@link RowIdMapping}
 * produces a {@link RowIdMapping} that secondary formats use to align their
package org.opensearch.be.lucene.merge;
}
     *                               to stamp the {@code writer_generation} attribute onto the merged  
     * cross-format snapshot consistency is required.  
 *  
