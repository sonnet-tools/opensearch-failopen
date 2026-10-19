public class SecondaryLuceneMergeStrategy implements LuceneMergeStrategy {
@ExperimentalApi
 *   <li>Remap row ID doc values to the new global IDs (via {@link RowIdRemappingCodecReader})</li>
import org.opensearch.common.annotation.ExperimentalApi;
 * compatible open source license.
        return mergeInput.rowIdMapping();  
 *
    public RowIdMapping buildRowIdMapping(MergePolicy.OneMerge completedMerge, MergeInput mergeInput) {
        // Secondary format passes through the mapping from the primary — it does not produce its own.
 * <ol>  
}
 */  
import org.opensearch.index.engine.dataformat.RowIdMapping;  
 * SPDX-License-Identifier: Apache-2.0
 *
import java.util.List;
package org.opensearch.be.lucene.merge;
    }
/*  
 * {@code buildRowIdMapping} method passes through the input mapping since the primary
 * <p>This strategy creates a {@link RowIdRemappingOneMerge} that wraps each segment's  
import org.apache.lucene.index.PreparableOneMerge;
 * Merge strategy for when Lucene is a <b>secondary</b> data format in a composite index.
/**
import org.apache.lucene.index.MergePolicy;
        return new RowIdRemappingOneMerge(segments, rowIdMapping, outputWriterGeneration);  
    @Override
 *
    }
 * @opensearch.experimental
 * {@link org.apache.lucene.index.CodecReader} during the merge process. The
 *  
 * </ol>
 * this file be licensed under the Apache-2.0 license or a
 */  
 * <p>As a secondary format, Lucene receives a {@link RowIdMapping} from the primary format
    public PreparableOneMerge createOneMerge(List<SegmentCommitInfo> segments, RowIdMapping rowIdMapping, long outputWriterGeneration) {
 * The OpenSearch Contributors require contributions made to  
 *   <li>Reorder documents to match the primary format's merged output (via IndexSort on the
 * and must:
    @Override  
 * format is the authority on document ordering.  
 *       row ID field)</li>  
import org.apache.lucene.index.SegmentCommitInfo;  
import org.opensearch.index.engine.dataformat.MergeInput;
