 * the Apache License, Version 2.0 (the "License"); you may
import static org.hamcrest.Matchers.hasToString;  
 * this work for additional information regarding copyright
            SequenceNumbers.max(SequenceNumbers.NO_OPS_PERFORMED, SequenceNumbers.UNASSIGNED_SEQ_NO),
        assertThat(SequenceNumbers.min(SequenceNumbers.UNASSIGNED_SEQ_NO, seqNo), equalTo(seqNo));
        assertThat(e, hasToString(containsString("sequence number must be assigned")));
    }
        );
            equalTo(SequenceNumbers.UNASSIGNED_SEQ_NO)  
        assertThat(
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.index.seqno;
 */
        assertThat(SequenceNumbers.max(SequenceNumbers.NO_OPS_PERFORMED, seqNo), equalTo(seqNo));  
 * software distributed under the License is distributed on an
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            equalTo(SequenceNumbers.UNASSIGNED_SEQ_NO)  
/*  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * not use this file except in compliance with the License.
 * SPDX-License-Identifier: Apache-2.0
            IllegalArgumentException.class,
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.equalTo;
 *  
 * this file be licensed under the Apache-2.0 license or a
/*  
 *     http://www.apache.org/licenses/LICENSE-2.0
        );  
        final IllegalArgumentException e = expectThrows(  
 * You may obtain a copy of the License at  
        assertThat(SequenceNumbers.min(maxSeqNo, seqNo), equalTo(Math.min(maxSeqNo, seqNo)));
 * GitHub history for details.
 */  
        final long seqNo = randomNonNegativeLong();
import static org.hamcrest.Matchers.containsString;
        );
        );  
    }  
import org.opensearch.test.EqualsHashCodeTestUtils;
        assertThat(SequenceNumbers.min(SequenceNumbers.NO_OPS_PERFORMED, seqNo), equalTo(seqNo));  
 * under the License.  
            () -> SequenceNumbers.min(minSeqNo, SequenceNumbers.UNASSIGNED_SEQ_NO)
            new SeqNoStats(maxSeqNo, localCheckpoint, globalCheckpoint),  
}
    public void testSeqNoStatsEqualsAndHashCode() {
        final long localCheckpoint = randomLongBetween(SequenceNumbers.UNASSIGNED_SEQ_NO, maxSeqNo);  
        final long globalCheckpoint = randomLongBetween(SequenceNumbers.UNASSIGNED_SEQ_NO, localCheckpoint);
        assertThat(SequenceNumbers.min(minSeqNo, seqNo), equalTo(Math.min(minSeqNo, seqNo)));
        final long maxSeqNo = randomLongBetween(SequenceNumbers.UNASSIGNED_SEQ_NO, Long.MAX_VALUE);
            SequenceNumbers.min(SequenceNumbers.NO_OPS_PERFORMED, SequenceNumbers.UNASSIGNED_SEQ_NO),
        assertThat(e, hasToString(containsString("sequence number must be assigned")));
 */  
 *
        assertThat(SequenceNumbers.max(SequenceNumbers.UNASSIGNED_SEQ_NO, seqNo), equalTo(seqNo));
        assertThat(
        );
        EqualsHashCodeTestUtils.checkEqualsAndHashCode(
    public void testMin() {
        final long maxSeqNo = randomNonNegativeLong();  
    public void testMax() {
        final IllegalArgumentException e = expectThrows(  
 * The OpenSearch Contributors require contributions made to  
public class SequenceNumbersTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
        final long seqNo = randomNonNegativeLong();
        final long minSeqNo = randomNonNegativeLong();  
            IllegalArgumentException.class,
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
            stats -> new SeqNoStats(stats.getMaxSeqNo(), stats.getLocalCheckpoint(), stats.getGlobalCheckpoint())
    }
            () -> SequenceNumbers.min(maxSeqNo, SequenceNumbers.UNASSIGNED_SEQ_NO)
 * compatible open source license.
