 */  
 * and {@link MergePolicy#findForcedDeletesMerges}. This allows time-based indices, that usually have the eldest documents
import java.util.Comparator;
 * under the License.  
    }  
     */
    public MergeSpecification findForcedDeletesMerges(SegmentInfos segmentInfos, MergeContext mergeContext) throws IOException {
 */
import org.apache.lucene.index.FilterMergePolicy;
            } else {
                }
                @Override  
 *
            List<SegmentCommitInfo> newInfos = interleaveList(new ArrayList<>(toWrap.segments));
                    info.info.addDiagnostics(Map.of(SHUFFLE_MERGE_KEY, ""));
            newMergeSpec.add(new OneMerge(newInfos) {
                    newInfos.add(leftInfo);
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
 */  
 * this file be licensed under the Apache-2.0 license or a
                @Override
/**
        if (mergeSpec == null) {
import org.opensearch.common.lucene.Lucene;
                    return toWrap.wrapForMerge(reader);
 * first, to be efficient at finding the most recent documents too.
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
 */  
        int left = 0;
    ) throws IOException {  
/*  
 *
        }
                    newInfos.add(rightInfo);
 * A {@link FilterMergePolicy} that interleaves eldest and newest segments picked by {@link MergePolicy#findForcedMerges}  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
import org.apache.lucene.index.LeafReader;  
    public MergeSpecification findForcedMerges(
                newInfos.add(infos.get(left));  
/*  
        List<SegmentCommitInfo> newInfos = new ArrayList<>(infos.size());
                } else {
 * Modifications Copyright OpenSearch Contributors. See
                }
 *  
            if (left == right) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.List;
import java.util.Map;  
    // and then interleave them to colocate oldest and most recent segments together.  
        int maxSegmentCount,  
    }
    private List<SegmentCommitInfo> interleaveList(List<SegmentCommitInfo> infos) throws IOException {
                SegmentCommitInfo rightInfo = infos.get(right);
                    newInfos.add(leftInfo);  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
    // Return a new list that sort segments of the original one by name (older first)
 * GitHub history for details.
/*
import org.apache.lucene.index.SegmentReader;
    @Override
            return null;  
        for (OneMerge toWrap : mergeSpec.merges) {  
                public void setMergeInfo(SegmentCommitInfo info) {  
    }
    public static boolean isInterleavedSegment(LeafReader reader) {
package org.opensearch.index.engine;
    }
        Collections.sort(infos, Comparator.comparing(a -> a.info.name));  
import org.apache.lucene.index.SegmentCommitInfo;
 * software distributed under the License is distributed on an
import java.util.Collections;  
        return newMergeSpec;
import java.io.IOException;
                    super.setMergeInfo(info);  
        Map<SegmentCommitInfo, Boolean> segmentsToMerge,
 * not use this file except in compliance with the License.
        return wrap(in.findForcedMerges(segmentInfos, maxSegmentCount, segmentsToMerge, mergeContext));
        return segReader.getSegmentInfo().info.getDiagnostics().containsKey(SHUFFLE_MERGE_KEY);
                if (leftInfo.sizeInBytes() < rightInfo.sizeInBytes()) {
import org.apache.lucene.index.CodecReader;
                }  
                    // record that this segment was merged with interleaved segments
        while (left <= right) {  
        SegmentInfos segmentInfos,
    public ShuffleForcedMergePolicy(MergePolicy in) {
import java.util.ArrayList;
 * license agreements. See the NOTICE file distributed with
        MergeSpecification newMergeSpec = new MergeSpecification();
    }
}
            }
    private static final String SHUFFLE_MERGE_KEY = "opensearch.shuffle_merge";
public class ShuffleForcedMergePolicy extends FilterMergePolicy {
import org.apache.lucene.index.MergePolicy;
            });
        int right = infos.size() - 1;
                // smaller segment first  
import org.apache.lucene.index.SegmentInfos;  
    private MergeSpecification wrap(MergeSpecification mergeSpec) throws IOException {
                    newInfos.add(rightInfo);  
        return wrap(in.findForcedDeletesMerges(segmentInfos, mergeContext));  
 * Unless required by applicable law or agreed to in writing,
 * this work for additional information regarding copyright
    }  
 * KIND, either express or implied.  See the License for the
        return newInfos;  
        }
        }  
    @Override  
 * specific language governing permissions and limitations
            right--;
                public CodecReader wrapForMerge(CodecReader reader) throws IOException {
        super(in);
        MergeContext mergeContext
     * Return <code>true</code> if the provided reader was merged with interleaved segments.  
        SegmentReader segReader = Lucene.segmentReader(reader);  
            SegmentCommitInfo leftInfo = infos.get(left);
            left++;  
 * ownership. Elasticsearch licenses this file to you under  
