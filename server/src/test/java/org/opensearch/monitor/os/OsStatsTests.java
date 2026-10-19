import org.opensearch.test.OpenSearchTestCase;  
 *
        long swapTotal = randomNonNegativeLong();
}
        OsStats osStats = new OsStats.Builder().timestamp(System.currentTimeMillis()).cpu(cpu).mem(mem).swap(swap).cgroup(cgroup).build();  
 * You may obtain a copy of the License at  
        OsStats.Swap swap = new OsStats.Swap(0, randomNonNegativeLong());
        long memTotal = randomNonNegativeLong();  
            randomAlphaOfLength(8),
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
/*  
            randomAlphaOfLength(8),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertEquals(osStats.getCgroup().getCpuCfsPeriodMicros(), deserializedOsStats.getCgroup().getCpuCfsPeriodMicros());  
import static org.hamcrest.Matchers.equalTo;
                assertEquals(osStats.getCpu().getPercent(), deserializedOsStats.getCpu().getPercent());  
 */
                assertEquals(osStats.getSwap().getFree(), deserializedOsStats.getSwap().getFree());
                OsStats deserializedOsStats = new OsStats(in);
            loadAverages[i] = randomDouble();  
                    deserializedOsStats.getCgroup().getCpuStat().getTimeThrottledNanos()  
            new OsStats.Cgroup.CpuStat(randomNonNegativeLong(), randomNonNegativeLong(), randomNonNegativeLong()),
 * ownership. Elasticsearch licenses this file to you under  
                assertEquals(
        }
 * specific language governing permissions and limitations
/*
            randomNonNegativeLong(),  
 * this work for additional information regarding copyright
                assertEquals(osStats.getCgroup().getCpuAcctControlGroup(), deserializedOsStats.getCgroup().getCpuAcctControlGroup());  
                    deserializedOsStats.getCgroup().getCpuStat().getNumberOfElapsedPeriods()
 * license agreements. See the NOTICE file distributed with
                assertEquals(osStats.getCgroup().getMemoryLimitInBytes(), deserializedOsStats.getCgroup().getMemoryLimitInBytes());
        OsStats.Swap swap = new OsStats.Swap(swapTotal, randomLongBetween(0, swapTotal));  
    public void testSerialization() throws IOException {
        OsStats.Mem mem = new OsStats.Mem(0, randomNonNegativeLong());  
                );
public class OsStatsTests extends OpenSearchTestCase {  
                assertEquals(osStats.getTimestamp(), deserializedOsStats.getTimestamp());
/*  
        );
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
    public void testGetUsedSwapWithZeroTotal() {
                assertEquals(osStats.getCgroup().getCpuControlGroup(), deserializedOsStats.getCgroup().getCpuControlGroup());
        assertThat(swap.getUsed().getBytes(), equalTo(0L));  
                    osStats.getCgroup().getCpuStat().getNumberOfTimesThrottled(),
        OsStats.Cpu cpu = new OsStats.Cpu(randomShort(), loadAverages);
                assertEquals(  
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(osStats.getMem().getFree(), deserializedOsStats.getMem().getFree());
                assertArrayEquals(osStats.getCpu().getLoadAverage(), deserializedOsStats.getCpu().getLoadAverage(), 0);
 */  
            randomNonNegativeLong(),
 * compatible open source license.
    }
            try (StreamInput in = out.bytes().streamInput()) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            Long.toString(randomNonNegativeLong())
            randomNonNegativeLong(),  
                assertEquals(osStats.getCgroup().getCpuAcctUsageNanos(), deserializedOsStats.getCgroup().getCpuAcctUsageNanos());
import org.opensearch.common.io.stream.BytesStreamOutput;
                assertEquals(osStats.getMem().getTotal(), deserializedOsStats.getMem().getTotal());  
                    deserializedOsStats.getCgroup().getCpuStat().getNumberOfTimesThrottled()
            Long.toString(randomNonNegativeLong()),  
        assertThat(mem.getUsed().getBytes(), equalTo(0L));
                assertEquals(osStats.getCgroup().getCpuCfsQuotaMicros(), deserializedOsStats.getCgroup().getCpuCfsQuotaMicros());
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.monitor.os;
 *
                    osStats.getCgroup().getCpuStat().getTimeThrottledNanos(),
                assertEquals(
            randomAlphaOfLength(8),
    }  
 * not use this file except in compliance with the License.
            }
        double loadAverages[] = new double[numLoadAverages];
        }
        int numLoadAverages = randomIntBetween(1, 5);  
 * Modifications Copyright OpenSearch Contributors. See
    }
                assertEquals(osStats.getSwap().getTotal(), deserializedOsStats.getSwap().getTotal());
                    osStats.getCgroup().getCpuStat().getNumberOfElapsedPeriods(),  
import org.opensearch.core.common.io.stream.StreamInput;
 */  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * KIND, either express or implied.  See the License for the
                );  
 * GitHub history for details.
    public void testGetUsedMemoryWithZeroTotal() {
                assertEquals(osStats.getCgroup().getMemoryUsageInBytes(), deserializedOsStats.getCgroup().getMemoryUsageInBytes());  
        for (int i = 0; i < loadAverages.length; i++) {
 *  
            osStats.writeTo(out);
        OsStats.Cgroup cgroup = new OsStats.Cgroup(
import java.io.IOException;
 * Unless required by applicable law or agreed to in writing,
                );
        OsStats.Mem mem = new OsStats.Mem(memTotal, randomLongBetween(0, memTotal));
