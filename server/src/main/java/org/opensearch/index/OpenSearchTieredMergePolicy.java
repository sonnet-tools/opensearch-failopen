    }
        return forcedMergePolicy.findForcedMerges(infos, maxSegmentCount, segmentsToMerge, mergeContext);
        forcedMergePolicy.setMaxMergedSegmentMB(Double.POSITIVE_INFINITY); // unlimited
        regularMergePolicy.setSegmentsPerTier(segmentsPerTier);
    OpenSearchTieredMergePolicy() {  
    final TieredMergePolicy regularMergePolicy;  
/*  
        return regularMergePolicy.getMaxMergedSegmentMB();
    }
    }
import org.apache.lucene.index.TieredMergePolicy;
    @Override
 *
 * {@link TieredMergePolicy#setMaxMergedSegmentMB(double)} on forced merges, but DOES respect it on only_expunge_deletes.
    final TieredMergePolicy forcedMergePolicy;
    }
        regularMergePolicy.setMaxMergeAtOnce(maxMergeAtOnce);
    public void setDeletesPctAllowed(double deletesPctAllowed) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
        return regularMergePolicy.getSegmentsPerTier();
 * You may obtain a copy of the License at  
    public double getDeletesPctAllowed() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.SegmentInfos;  
    public void setSegmentsPerTier(double segmentsPerTier) {
 * GitHub history for details.
 * See https://issues.apache.org/jira/browse/LUCENE-7976.  
/**  
package org.opensearch.index;
 */  
        return regularMergePolicy.getMaxMergeAtOnce();
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
    }
    public void setMaxMergeAtOnce(int maxMergeAtOnce) {
        int maxSegmentCount,
    }
    public int getMaxMergeAtOnce() {  
        regularMergePolicy.setDeletesPctAllowed(deletesPctAllowed);
 *
    }
        Map<SegmentCommitInfo, Boolean> segmentsToMerge,
 * specific language governing permissions and limitations
        regularMergePolicy.setFloorSegmentMB(mbFrac);
        regularMergePolicy = (TieredMergePolicy) in;
/*
 *    http://www.apache.org/licenses/LICENSE-2.0
    public double getMaxMergedSegmentMB() {  
        return regularMergePolicy.getDeletesPctAllowed();
        MergeContext mergeContext  
import java.io.IOException;  
import java.util.Map;
    }
        forcedMergePolicy.setForceMergeDeletesPctAllowed(forceMergeDeletesPctAllowed);  
        forcedMergePolicy.setMaxMergeAtOnce(maxMergeAtOnce);  
    public double getForceMergeDeletesPctAllowed() {  
 */  
 * this file be licensed under the Apache-2.0 license or a
    public double getFloorSegmentMB() {  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
    }
    }
 * @opensearch.internal
 * Licensed to Elasticsearch under one or more contributor  
    // only setter that must NOT delegate to the forced merge policy
        return regularMergePolicy.getFloorSegmentMB();
    }  
        forcedMergePolicy.setSegmentsPerTier(segmentsPerTier);  
    public void setFloorSegmentMB(double mbFrac) {
        return regularMergePolicy.findForcedDeletesMerges(infos, mergeContext);
    }
 * Modifications Copyright OpenSearch Contributors. See
    @Override
 */  
    public MergeSpecification findForcedDeletesMerges(SegmentInfos infos, MergeContext mergeContext) throws IOException {  
        forcedMergePolicy = new TieredMergePolicy();  
 * Unless required by applicable law or agreed to in writing,
 * Wrapper around {@link TieredMergePolicy} which doesn't respect
        SegmentInfos infos,  
 * under the License.  
 *
        regularMergePolicy.setMaxMergedSegmentMB(mbFrac);  
 * KIND, either express or implied.  See the License for the
    public void setForceMergeDeletesPctAllowed(double forceMergeDeletesPctAllowed) {
import org.apache.lucene.index.FilterMergePolicy;
/*  
        return regularMergePolicy.getForceMergeDeletesPctAllowed();
    }
}  
        super(new TieredMergePolicy());
        regularMergePolicy.setForceMergeDeletesPctAllowed(forceMergeDeletesPctAllowed);
    }
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
        forcedMergePolicy.setFloorSegmentMB(mbFrac);  
    ) throws IOException {
 *  
 * not use this file except in compliance with the License.
        forcedMergePolicy.setDeletesPctAllowed(deletesPctAllowed);  
    public MergeSpecification findForcedMerges(
final class OpenSearchTieredMergePolicy extends FilterMergePolicy {
    public double getSegmentsPerTier() {  
    public void setMaxMergedSegmentMB(double mbFrac) {
 */
import org.apache.lucene.index.SegmentCommitInfo;
 * SPDX-License-Identifier: Apache-2.0
