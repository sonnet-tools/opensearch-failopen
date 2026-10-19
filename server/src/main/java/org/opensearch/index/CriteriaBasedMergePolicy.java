}  
    ) throws IOException {
     * @param infos the total set of segments in the index
            if (segments.size() > 1) {
     */  
        for (SegmentCommitInfo si : segmentInfos) {  
     * @param segmentsToMerge contains the specific SegmentInfo instances that must be merged away.
import org.opensearch.common.CheckedFunction;  
        SegmentInfos segmentInfos,
     * @param segmentInfos the total set of segments in the index (while preparing the commit)
    public MergeSpecification findFullFlushMerges(MergeTrigger mergeTrigger, SegmentInfos segmentInfos, MergeContext mergeContext)
package org.opensearch.index;
        MergeSpecification spec = null;
     * @throws IOException  
        SegmentInfos segmentInfos,  
                    if (spec == null) {
/**
        CheckedFunction<SegmentInfos, MergeSpecification, IOException> mergeFinderFunction  
    ) throws IOException {
import org.apache.lucene.index.SegmentCommitInfo;
     *
                    }
    /**  
        MergeContext mergeContext,
                        spec = new MergeSpecification();  
            final String dwptGroupNumber = si.info.getAttribute(CriteriaBasedCodec.BUCKET_NAME);
 *
import java.util.ArrayList;
     * @param mergeContext the MergeContext to find the merges on
    public MergeSpecification findMerges(MergeTrigger mergeTrigger, SegmentInfos infos, MergeContext mergeContext) throws IOException {
import java.util.HashMap;
import org.opensearch.index.codec.CriteriaBasedCodec;
     * Merges the segments belonging to same group
                if (delegateSpec != null) {
     * @param mergeTrigger the event that triggered the merge (COMMIT or GET_READER).
     * @param segmentInfos the total set of segments in the index  
    private MergeSpecification findMergesInternal(  
        return findMergesInternal(infos, mergeContext, newSIS -> in.findMerges(mergeTrigger, newSIS, mergeContext));  
/*  
        final Set<SegmentCommitInfo> merging = mergeContext.getMergingSegments();  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;  
    }
import org.apache.lucene.index.MergeTrigger;  
     * @throws IOException
        final Map<String, List<SegmentCommitInfo>> commitInfos = new HashMap<>();
    public MergeSpecification findForcedDeletesMerges(SegmentInfos segmentInfos, MergeContext mergeContext) throws IOException {  
                segments.forEach(newSIS::add);
    @Override
 */
            List<SegmentCommitInfo> segments = entry.getValue();
        for (Map.Entry<String, List<SegmentCommitInfo>> entry : commitInfos.entrySet()) {  
            }  
     */
        }  
 * The OpenSearch Contributors require contributions made to  
     * @return
            newSIS -> in.findForcedMerges(newSIS, maxSegmentCount, segmentsToMerge, mergeContext)
        return findMergesInternal(segmentInfos, mergeContext, newSIS -> in.findFullFlushMerges(mergeTrigger, newSIS, mergeContext));
    /**
    }
 * compatible open source license.
     * @param mergeContext the IndexWriter to find the merges on  
    }
        int maxSegmentCount,
     * @return
                    spec.merges.addAll(delegateSpec.merges);
     * Merges segment belonging to same group to expunge deletes.
                continue;
import java.io.IOException;  
        Map<SegmentCommitInfo, Boolean> segmentsToMerge,
import org.apache.lucene.index.FilterMergePolicy;
        MergeContext mergeContext  
    }
     *  
            }
     * Force merges segments belonging to same group.
     *
     */  
     * @throws IOException
        super(in);
     * @param mergeTrigger the event that triggered the merge
import java.util.Map;
            commitInfos.computeIfAbsent(dwptGroupNumber, k -> new ArrayList<>()).add(si);
     * @return
     *  
    public MergeSpecification findForcedMerges(
import org.apache.lucene.index.MergePolicy;
            if (merging.contains(si)) {
     * @param mergeContext the MergeContext to find the merges on.  
public class CriteriaBasedMergePolicy extends FilterMergePolicy {  
    }
            mergeContext,
        return findMergesInternal(
    /**
 * SPDX-License-Identifier: Apache-2.0
     */  
     * @param maxSegmentCount requested maximum number of segments in the index
    }
        this.in = in;  
     * @return
        return spec;
            segmentInfos,  
        return findMergesInternal(segmentInfos, mergeContext, newSIS -> in.findForcedDeletesMerges(newSIS, mergeContext));
    @Override
 *
        );  
    public CriteriaBasedMergePolicy(MergePolicy in) {
import java.util.Set;
                final MergeSpecification delegateSpec = mergeFinderFunction.apply(newSIS);  
    protected final MergePolicy in;
 * to same bucket.  
        }
                final SegmentInfos newSIS = new SegmentInfos(segmentInfos.getIndexCreatedVersionMajor());  
import org.apache.lucene.index.SegmentInfos;
    @Override
        throws IOException {  
    /**  
     * @param segmentInfos the total set of segments in the index  
 */  
 * Wrapper merge policy which is used for context aware enabled indices. This merge policy merges segments that belongs
     * Identifies merges that we want to execute (synchronously) on commit
                }  
     * @param mergeContext the MergeContext to find the merges on  
     * @throws IOException
    @Override
