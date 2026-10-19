/**
 * @opensearch.experimental
public class PrimaryLuceneMergeStrategy implements LuceneMergeStrategy {
 * The OpenSearch Contributors require contributions made to  
 * order with the merged output.  
 *  
 *
import org.apache.lucene.index.SegmentCommitInfo;  
 * compatible open source license.
    }
import org.opensearch.index.engine.dataformat.RowIdMapping;  
 * this file be licensed under the Apache-2.0 license or a
        throw new UnsupportedOperationException("Primary Lucene merge strategy is not yet implemented");  
    public RowIdMapping buildRowIdMapping(MergePolicy.OneMerge completedMerge, MergeInput mergeInput) {
    @Override  
 * SPDX-License-Identifier: Apache-2.0
 * determine how documents from each source generation were reordered.  
import org.apache.lucene.index.PreparableOneMerge;
    public PreparableOneMerge createOneMerge(List<SegmentCommitInfo> segments, RowIdMapping rowIdMapping, long outputWriterGeneration) {
import java.util.List;
 * <p>As the primary format, Lucene performs a standard merge (no row ID remapping on input)
 */  
 */  
        throw new UnsupportedOperationException("Primary Lucene merge strategy is not yet implemented");
import org.apache.lucene.index.MergePolicy;
 * and produces a {@link RowIdMapping} that secondary formats use to align their document
    }  
 *
import org.opensearch.common.annotation.ExperimentalApi;
 * <p>The mapping is built after the merge completes by reading the merged segment to
    @Override
 *
package org.opensearch.be.lucene.merge;
 * Merge strategy for when Lucene is the <b>primary</b> data format in a composite index.
/*  
@ExperimentalApi
import org.opensearch.index.engine.dataformat.MergeInput;
}
