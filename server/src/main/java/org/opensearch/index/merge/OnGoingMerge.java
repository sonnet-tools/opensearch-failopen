package org.opensearch.index.merge;
 * You may obtain a copy of the License at  
import org.apache.lucene.index.SegmentCommitInfo;
 *
 * under the License.  
import java.util.List;
     * input total size.
 * not use this file except in compliance with the License.
 *  
    /**
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
 *
 * SPDX-License-Identifier: Apache-2.0
 *
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
     * The list of segments that are being merged.  
    }  
 * specific language governing permissions and limitations
    public long getTotalBytesSize() {
    public OnGoingMerge(MergePolicy.OneMerge merge) {
 * software distributed under the License is distributed on an
        this.oneMerge = merge;  
 */
 * GitHub history for details.
 * @opensearch.internal  
     */  
/*
/*  
    public String getId() {
 * license agreements. See the NOTICE file distributed with
    private final String id;
 * Unless required by applicable law or agreed to in writing,
        return oneMerge.totalBytesSize();
    public List<SegmentCommitInfo> getMergedSegments() {
 * Represents a single on going merge within an index.
    }  
    }
     * A unique id for the merge.
}
    private final MergePolicy.OneMerge oneMerge;
 * compatible open source license.
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
 * the Apache License, Version 2.0 (the "License"); you may
        return id;
     */
    /**
        this.id = Integer.toString(System.identityHashCode(merge));
public class OnGoingMerge {
     * Returns the total size in bytes of this merge. Note that this does not  
 */
/*  
 */  
        return oneMerge.segments;  
     */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import org.apache.lucene.index.MergePolicy;
/**  
 * ownership. Elasticsearch licenses this file to you under  
     * indicate the size of the merged segment, but the
