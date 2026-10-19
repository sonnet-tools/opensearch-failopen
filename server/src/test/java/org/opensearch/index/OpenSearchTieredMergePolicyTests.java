                public InfoStream getInfoStream() {
 *  
        policy.setDeletesPctAllowed(42);
        MergePolicy.MergeSpecification mergeSpecification = new OpenSearchTieredMergePolicy().findForcedDeletesMerges(  
            new SegmentInfos(Version.LATEST.major),
 * software distributed under the License is distributed on an
import org.apache.lucene.index.MergePolicy;
 * Modifications Copyright OpenSearch Contributors. See
    }  
        OpenSearchTieredMergePolicy policy = new OpenSearchTieredMergePolicy();  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.index.SegmentInfos;  
                public int numDeletesToMerge(SegmentCommitInfo info) {
 *
                }
import java.util.Collections;
 * specific language governing permissions and limitations
        policy.setSegmentsPerTier(42);
 * Licensed to Elasticsearch under one or more contributor  
        OpenSearchTieredMergePolicy policy = new OpenSearchTieredMergePolicy();  
                @Override  
    }
/*
                    return Collections.emptySet();
    public void testSetDeletesPctAllowed() {
 */  
import org.opensearch.test.OpenSearchTestCase;
public class OpenSearchTieredMergePolicyTests extends OpenSearchTestCase {
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(new TieredMergePolicy().getMaxMergedSegmentMB(), policy.regularMergePolicy.getMaxMergedSegmentMB(), 0d);
                public Set<SegmentCommitInfo> getMergingSegments() {
/*  
    public void testDefaults() {  
            }
 * this work for additional information regarding copyright
        OpenSearchTieredMergePolicy policy = new OpenSearchTieredMergePolicy();
        policy.setMaxMergeAtOnce(42);
        assertEquals(Long.MAX_VALUE / 1024.0 / 1024.0, policy.forcedMergePolicy.getMaxMergedSegmentMB(), 0d);  
        assertEquals(10 * 1024, policy.regularMergePolicy.getMaxMergedSegmentMB(), 0d);  
        assertEquals(42, policy.forcedMergePolicy.getFloorSegmentMB(), 0);
        OpenSearchTieredMergePolicy policy = new OpenSearchTieredMergePolicy();
                    return 0;
            new MergePolicy.MergeContext() {
                @Override
    public void testSetForceMergeDeletesPctAllowed() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * under the License.  
                    return InfoStream.NO_OUTPUT;  
        policy.setForceMergeDeletesPctAllowed(42);  
        OpenSearchTieredMergePolicy policy = new OpenSearchTieredMergePolicy();
                }  
package org.opensearch.index;
    }
import org.apache.lucene.util.Version;  
    }
 */  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
                }  
        );
                    return 0;
}
    }  
                }
    public void testSetFloorSegmentMB() {
import org.apache.lucene.util.InfoStream;
    }  
    public void testSetMaxMergedSegmentMB() {  
                @Override  
/*  
 * KIND, either express or implied.  See the License for the
        policy.setFloorSegmentMB(42);  
        assertEquals(42, policy.forcedMergePolicy.getForceMergeDeletesPctAllowed(), 0);
        assertEquals(Long.MAX_VALUE / 1024.0 / 1024.0, policy.forcedMergePolicy.getMaxMergedSegmentMB(), 0d);
 * The OpenSearch Contributors require contributions made to  
        assertEquals(42, policy.regularMergePolicy.getFloorSegmentMB(), 0);
 * compatible open source license.
    public void testFindDeleteMergesReturnsNullOnEmptySegmentInfos() throws IOException {
    }
        assertEquals(42, policy.regularMergePolicy.getMaxMergeAtOnce());
                @Override
                public int numDeletedDocs(SegmentCommitInfo info) {  
import org.apache.lucene.index.SegmentCommitInfo;
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
    public void testSetMaxMergeAtOnce() {
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
    }  
import org.apache.lucene.index.TieredMergePolicy;
        assertEquals(42, policy.regularMergePolicy.getSegmentsPerTier(), 0);
        assertNull(mergeSpecification);  
        OpenSearchTieredMergePolicy policy = new OpenSearchTieredMergePolicy();
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(42, policy.regularMergePolicy.getDeletesPctAllowed(), 0);
import java.io.IOException;  
import java.util.Set;
 */
        OpenSearchTieredMergePolicy policy = new OpenSearchTieredMergePolicy();  
 *
 * You may obtain a copy of the License at  
    public void testSetSegmentsPerTier() {
        policy.setMaxMergedSegmentMB(10 * 1024);
