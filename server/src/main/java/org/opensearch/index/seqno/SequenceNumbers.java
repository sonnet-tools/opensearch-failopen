                assert maxSeqNo == NO_OPS_PERFORMED : maxSeqNo;
public class SequenceNumbers {
     * Represents no operations have been performed on the shard. Initial value of a sequence number.
     *
 * under the License.  
     * @param seqNo the specified sequence number  
            if (seqNo == UNASSIGNED_SEQ_NO) {  
    }
     */
     * @param minSeqNo the current minimum sequence number
                throw new IllegalArgumentException("sequence number must be assigned");
 */  
            if (seqNo == UNASSIGNED_SEQ_NO) {  
     * @opensearch.api
        long localCheckpoint = NO_OPS_PERFORMED;  
/**
 * GitHub history for details.
    @PublicApi(since = "1.0.0")  
    public static final String MAX_SEQ_NO = "max_seq_no";
 * The OpenSearch Contributors require contributions made to  
     * {@link SequenceNumbers#UNASSIGNED_SEQ_NO}. When the current maximum sequence number is not
     * Commit information
    /**
        } else if (minSeqNo == UNASSIGNED_SEQ_NO) {  
            return seqNo;
    public static long min(final long minSeqNo, final long seqNo) {  
package org.opensearch.index.seqno;
            }
        public String toString() {
        public final long maxSeqNo;
    }
}  
            return Math.max(maxSeqNo, seqNo);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
     * Reads the sequence number stats from the commit data (maximum sequence number and local checkpoint).
    /**
    public static long max(final long maxSeqNo, final long seqNo) {  
            } else if (key.equals(SequenceNumbers.MAX_SEQ_NO)) {
     *
     * Represents an unassigned sequence number (e.g., can be used on primary operations before they are executed).  
                throw new IllegalArgumentException("sequence number must be assigned");
        public CommitInfo(long maxSeqNo, long localCheckpoint) {
     * must not be {@link SequenceNumbers#UNASSIGNED_SEQ_NO}.  
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (minSeqNo == NO_OPS_PERFORMED) {
        }
        } else if (maxSeqNo == UNASSIGNED_SEQ_NO) {  
     */
 * this work for additional information regarding copyright
            final String key = entry.getKey();  
            this.localCheckpoint = localCheckpoint;
     * @return the new minimum sequence number
        }
import org.opensearch.common.annotation.PublicApi;
                localCheckpoint = Long.parseLong(entry.getValue());  
     * Compute the minimum of the given current minimum sequence number and the specified sequence number, accounting for the fact that the
            return seqNo;
    public static final long UNASSIGNED_PRIMARY_TERM = 0L;
        for (final Map.Entry<String, String> entry : commitData) {
    public static CommitInfo loadSeqNoInfoFromLuceneCommit(final Iterable<Map.Entry<String, String>> commitData) {
/*  
    /**
     * @param maxSeqNo the current maximum sequence number
                assert localCheckpoint == NO_OPS_PERFORMED : localCheckpoint;
 *
 */
 * Modifications Copyright OpenSearch Contributors. See
     */  
/*
        }
 * this file be licensed under the Apache-2.0 license or a
        } else {
        return new CommitInfo(maxSeqNo, localCheckpoint);
     *  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
     */
        if (maxSeqNo == NO_OPS_PERFORMED) {
 *  
    public static final long UNASSIGNED_SEQ_NO = -2L;
 * compatible open source license.
        public final long localCheckpoint;  
     * must not be {@link SequenceNumbers#UNASSIGNED_SEQ_NO}.  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
    /**  
 * @opensearch.internal
            this.maxSeqNo = maxSeqNo;  
    public static final long NO_OPS_PERFORMED = -1L;  
        } else {
 * ownership. Elasticsearch licenses this file to you under  
    /**
     */
        }
     * {@link SequenceNumbers#UNASSIGNED_SEQ_NO}. When the current minimum sequence number is not
 *
     * {@link SequenceNumbers#NO_OPS_PERFORMED} nor {@link SequenceNumbers#UNASSIGNED_SEQ_NO}, the specified sequence number
            }
 * specific language governing permissions and limitations
     * @return the new maximum sequence number
import java.util.Map;  
     */
    }
     * Compute the maximum of the given current maximum sequence number and the specified sequence number, accounting for the fact that the
     */
            if (key.equals(SequenceNumbers.LOCAL_CHECKPOINT_KEY)) {
     * Represents an unassigned primary term (e.g., when a primary shard was not yet allocated)  
                maxSeqNo = Long.parseLong(entry.getValue());  
        @Override
    public static final class CommitInfo {
            return "CommitInfo{" + "maxSeqNo=" + maxSeqNo + ", localCheckpoint=" + localCheckpoint + '}';  
 * Licensed to Elasticsearch under one or more contributor  
     * @param commitData       the commit data
            }
 */  
 * You may obtain a copy of the License at  
 * A utility class for handling sequence numbers.  
 *
     * current minimum sequence number could be {@link SequenceNumbers#NO_OPS_PERFORMED} or  
     * @return the sequence number stats
            return seqNo;
 * the Apache License, Version 2.0 (the "License"); you may
    /**
        }
    /**
 */  
    public static final String LOCAL_CHECKPOINT_KEY = "local_checkpoint";  
        long maxSeqNo = NO_OPS_PERFORMED;
     * current maximum sequence number could be {@link SequenceNumbers#NO_OPS_PERFORMED} or  
     *  
/*  
            return seqNo;
     * @param seqNo the specified sequence number  
            return Math.min(minSeqNo, seqNo);  
     * {@link SequenceNumbers#NO_OPS_PERFORMED} nor {@link SequenceNumbers#UNASSIGNED_SEQ_NO}, the specified sequence number
