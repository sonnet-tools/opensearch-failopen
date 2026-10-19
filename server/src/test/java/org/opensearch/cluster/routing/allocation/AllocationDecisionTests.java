        assertEquals(AllocationDecision.NO_VALID_SHARD_COPY, decisions[6]);  
import org.opensearch.common.io.stream.BytesStreamOutput;  
        AllocationDecision[] decisions = AllocationDecision.values();
        allocationDecision.writeTo(output);
    }
        assertEquals(7, AllocationDecision.NO_ATTEMPT.ordinal());  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(AllocationDecision.WORSE_BALANCE, decisions[3]);  
 *
package org.opensearch.cluster.routing.allocation;
        } else if (allocationStatus == AllocationStatus.DELAYED_ALLOCATION) {
        assertEquals(6, AllocationDecision.NO_VALID_SHARD_COPY.ordinal());
    /**
 */
        assertEquals(AllocationDecision.AWAITING_INFO, decisions[4]);
        assertEquals(allocationDecision, AllocationDecision.readFrom(output.bytes().streamInput()));  
    public void testSerialization() throws IOException {
        assertEquals(3, AllocationDecision.WORSE_BALANCE.ordinal());
        assertEquals(5, AllocationDecision.ALLOCATION_DELAYED.ordinal());
        AllocationDecision expected = type == Type.NO ? AllocationDecision.NO
 * The OpenSearch Contributors require contributions made to  
        assertEquals(AllocationDecision.NO_ATTEMPT, decisions[7]);
 * license agreements. See the NOTICE file distributed with
            expected = AllocationDecision.ALLOCATION_DELAYED;  
 * You may obtain a copy of the License at  
        AllocationDecision expected;
import org.opensearch.cluster.routing.allocation.decider.Decision.Type;
        AllocationDecision allocationDecision = AllocationDecision.fromDecisionType(type);  
 */  
        assertEquals(0, AllocationDecision.YES.ordinal());
        } else {
 * this file be licensed under the Apache-2.0 license or a
     * See {@link AbstractAllocationDecision#getNodeDecisions()}.
    }
/*  
        } else if (allocationStatus == AllocationStatus.NO_ATTEMPT) {  
    public void testFromDecisionType() {
            expected = AllocationDecision.NO_ATTEMPT;
}
 * specific language governing permissions and limitations
        assertEquals(AllocationDecision.YES, decisions[0]);  
     * Tests getting a {@link AllocationDecision} from {@link AllocationStatus}.
 * not use this file except in compliance with the License.
/*  
            expected = AllocationDecision.AWAITING_INFO;
     * Tests serialization and deserialization.  
        AllocationStatus allocationStatus = rarely() ? null : randomFrom(AllocationStatus.values());
        assertEquals(expected, allocationDecision);
        assertEquals(AllocationDecision.NO, decisions[2]);
            expected = AllocationDecision.THROTTLED;
import org.opensearch.cluster.routing.UnassignedInfo.AllocationStatus;
            expected = AllocationDecision.NO;  
        assertEquals(1, AllocationDecision.THROTTLED.ordinal());  
 * Licensed to Elasticsearch under one or more contributor  
    public void testFromAllocationStatus() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    public void testValuesOrder() {
import java.io.IOException;  
        Arrays.sort(decisions);
            : AllocationDecision.YES;  
        assertEquals(4, AllocationDecision.AWAITING_INFO.ordinal());  
        } else if (allocationStatus == AllocationStatus.NO_VALID_SHARD_COPY) {
        AllocationDecision allocationDecision = randomFrom(AllocationDecision.values());  
        if (allocationStatus == null) {
import java.util.Arrays;
 * Tests for the {@link AllocationDecision} enum.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
 *  
import org.opensearch.test.OpenSearchTestCase;
/*
     */  
 */  
            : type == Type.THROTTLE ? AllocationDecision.THROTTLED
        assertEquals(2, AllocationDecision.NO.ordinal());
    /**
public class AllocationDecisionTests extends OpenSearchTestCase {  
        } else if (allocationStatus == AllocationStatus.DECIDERS_THROTTLED) {
        assertEquals(expected, allocationDecision);
        }
        AllocationDecision allocationDecision = AllocationDecision.fromAllocationStatus(allocationStatus);  
        assertEquals(AllocationDecision.THROTTLED, decisions[1]);
     */  
            expected = AllocationDecision.NO_VALID_SHARD_COPY;
        assertEquals(AllocationDecision.ALLOCATION_DELAYED, decisions[5]);
    }
        BytesStreamOutput output = new BytesStreamOutput();
 * under the License.  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
     */  
 * compatible open source license.
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
     */
            expected = AllocationDecision.YES;  
        } else if (allocationStatus == AllocationStatus.FETCHING_SHARD_DATA) {  
 */
        Type type = randomFrom(Type.values());
    /**  
    }  
    /**
     * Tests the order of values in the enum, because we depend on the natural enum sort order for sorting node decisions.
     * Tests getting a {@link AllocationDecision} from {@link Type}.
/**  
