     */
 * SPDX-License-Identifier: Apache-2.0
    public MergeSpecification findForcedMerges(
                if (spec.merges.size() == MAX_CONCURRENT_UPGRADE_MERGES) {
    @Override
 */  
            // has a chance to decide what to do (e.g. collapse the segments to satisfy maxSegmentCount)  
 * the fact or on the opposite to remove them.  
        org.apache.lucene.util.Version cur = Version.CURRENT.luceneVersion;
                    return spec;
 */  
    public MergePolicy getDelegate() {
            // Always upgrade segment if Lucene's major version is too old
            // also upgrade:  
package org.opensearch.index.shard;
        int maxSegmentCount,
 * specific language governing permissions and limitations
import org.apache.logging.log4j.LogManager;
    }
            // Only set this once there are 0 segments needing upgrading, because when we return a  
    private boolean shouldUpgrade(SegmentCommitInfo info) {
                    // hit our max upgrades, so return the spec. we will get a cascaded call to continue.  
 */
            // fall through, so when we don't have any segments to upgrade, the delegate policy
import org.opensearch.Version;
            }
                return spec;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return false;
    private volatile boolean upgradeOnlyAncientSegments;  
}
        Map<SegmentCommitInfo, Boolean> segmentsToMerge,
            MergeSpecification spec = new MergeSpecification();
    /** @param delegate the merge policy to wrap */
 * compatible open source license.
        org.apache.lucene.util.Version old = info.info.getVersion();  
                    spec.add(new OneMerge(Collections.singletonList(info)));  
 * Licensed to Elasticsearch under one or more contributor  
 * @opensearch.internal
 * Unless required by applicable law or agreed to in writing,
     * with older versions. This will apply to the next call to
        return in;
    private volatile boolean upgradeInProgress;  
import org.apache.lucene.index.SegmentInfos;
 * It can be useful to use the background merging process to upgrade segments,
                }  
    // True if the next merge request should do segment upgrades:
    private static final int MAX_CONCURRENT_UPGRADE_MERGES = 5;
import org.apache.lucene.index.SegmentCommitInfo;  
 * for example when we perform internal changes that imply different index  
    public OpenSearchMergePolicy(MergePolicy delegate) {
import org.apache.logging.log4j.Logger;
     * {@link IndexWriter#forceMerge} that is handled by this {@link MergePolicy}, as well as  
            upgradeInProgress = false;  
 */  
                    // for now we just assume every minor upgrade has a new format.
    ) throws IOException {
 * A {@link MergePolicy} that upgrades segments and can upgrade merges.  
    private static final Logger logger = LogManager.getLogger(OpenSearchMergePolicy.class);  
public final class OpenSearchMergePolicy extends FilterMergePolicy {
            // If it's only a minor version difference, and we are not upgrading only ancient segments,
     * When <code>upgrade</code> is true, running a force merge will upgrade any segments written
        SegmentInfos segmentInfos,  
        // Version matches, or segment is not ancient and we are only upgrading ancient segments:  
 * ownership. Elasticsearch licenses this file to you under  
                }
                // TODO: we could check IndexWriter.getMergingSegments and avoid adding merges that IW will just reject?  
import org.apache.lucene.index.IndexWriter;
 *
    }
    /**  
                    // TODO: Use IndexUpgradeMergePolicy instead. We should be comparing codecs,  
    // True if the next merge request should only upgrade ancient (an older Lucene major version than current) segments;
    /** return the wrapped merge policy */  
import java.util.Map;  
            // spec, IndexWriter may (silently!) reject that merge if some of the segments we asked
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * license agreements. See the NOTICE file distributed with
        if (upgradeOnlyAncientSegments == false && cur.minor > old.minor) {
 * not use this file except in compliance with the License.
    }  
        super(delegate);  
/*  
        this.upgradeInProgress = upgrade;
        // Something seriously wrong if this trips:  
 * under the License.  
        }
 * Modifications Copyright OpenSearch Contributors. See
 * imagine using this merge policy to be able to add doc values to fields after
/**
        assert old.major <= cur.major;
import org.apache.lucene.index.FilterMergePolicy;  
 * <p>
     * cascading calls made by {@link IndexWriter}.
 * be stored as payloads to numeric doc values.  
        }  
 *
import org.apache.lucene.index.MergePolicy;
 * the Apache License, Version 2.0 (the "License"); you may
        }
 *  
        if (cur.major > old.major) {  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
            // We must have less than our max upgrade merges, so the next return will be our last in upgrading mode.  
            for (SegmentCommitInfo info : segmentInfos) {
 * GitHub history for details.
    }
            if (spec.merges.isEmpty() == false) {
 * this work for additional information regarding copyright
            return true;
                logger.debug("Returning {} merges for end of upgrade", spec.merges.size());
                if (shouldUpgrade(info)) {
        this.upgradeOnlyAncientSegments = onlyAncientSegments;
                    logger.debug("Returning {} merges for upgrade", spec.merges.size());
            // to be merged were already being (naturally) merged:
            return true;
import java.io.IOException;
/*
 * <p>
    }  
                    logger.debug("Adding segment {} to be upgraded", info.info.name);
import java.util.Collections;
        MergeContext mergeContext  
 * options or when a user modifies his mapping in non-breaking ways: we could
        return super.findForcedMerges(segmentInfos, maxSegmentCount, segmentsToMerge, mergeContext);  
 * For now, this {@link MergePolicy} takes care of moving versions that used to
            }
 * this file be licensed under the Apache-2.0 license or a
    public void setUpgradeInProgress(boolean upgrade, boolean onlyAncientSegments) {  
 * software distributed under the License is distributed on an
        if (upgradeInProgress) {  
/*  
