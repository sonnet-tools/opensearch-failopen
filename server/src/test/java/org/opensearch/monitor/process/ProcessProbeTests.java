import static org.hamcrest.Matchers.lessThan;
        assertNotNull(info);
    private final ProcessProbe probe = ProcessProbe.getInstance();  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // Open/Max files descriptors are not supported on Windows platforms
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
 */  
        ProcessStats.Mem mem = stats.getMem();
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.bootstrap.BootstrapInfo;
import static org.hamcrest.Matchers.anyOf;
 * GitHub history for details.
 * this work for additional information regarding copyright
        assertNotNull(stats);
        // CPU time can return -1 if the platform does not support this operation, let's see which platforms fail
        assertThat(mem.getTotalVirtual().getBytes(), greaterThan(0L));
        assertThat(stats.getTimestamp(), greaterThan(0L));
 * not use this file except in compliance with the License.
 * compatible open source license.
import static org.hamcrest.Matchers.allOf;  
 */  
/*
import static org.hamcrest.Matchers.greaterThan;  
 *  
        assertThat(cpu.getPercent(), anyOf(lessThan((short) 0), allOf(greaterThanOrEqualTo((short) 0), lessThanOrEqualTo((short) 100))));
 *
import static org.hamcrest.Matchers.lessThanOrEqualTo;  
 *    http://www.apache.org/licenses/LICENSE-2.0
public class ProcessProbeTests extends OpenSearchTestCase {
            assertThat(stats.getMaxFileDescriptors(), equalTo(-1L));
/*  
}  
/*  
        assertEquals(BootstrapInfo.isMemoryLocked(), info.isMlockall());
        // CPU percent can be negative if the system recent cpu usage is not available
        assertNotNull(cpu);
 * the Apache License, Version 2.0 (the "License"); you may
        // Committed total virtual memory can return -1 if not supported, let's see which platforms fail  
        long refreshInterval = randomNonNegativeLong();  
    }  
import static org.hamcrest.Matchers.equalTo;
import static org.opensearch.monitor.jvm.JvmInfo.jvmInfo;
            assertThat(stats.getOpenFileDescriptors(), equalTo(-1L));  
 *
        assertNotNull(mem);
        }
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(refreshInterval, info.getRefreshInterval());  
    public void testProcessStats() {
 * Unless required by applicable law or agreed to in writing,
        assertEquals(jvmInfo().pid(), info.getId());
        } else {
        ProcessInfo info = probe.processInfo(refreshInterval);
 * You may obtain a copy of the License at  
    public void testProcessInfo() {
    }
 * under the License.  
        if (Constants.WINDOWS) {
 * The OpenSearch Contributors require contributions made to  
            assertThat(stats.getMaxFileDescriptors(), greaterThan(0L));
        ProcessStats.Cpu cpu = stats.getCpu();
        assertThat(cpu.getTotal().millis(), greaterThan(0L));
 * ownership. Elasticsearch licenses this file to you under  
 */
package org.opensearch.monitor.process;
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
        ProcessStats stats = probe.processStats();  
            assertThat(stats.getOpenFileDescriptors(), greaterThan(0L));  
import org.apache.lucene.util.Constants;
import org.opensearch.test.OpenSearchTestCase;  
 * specific language governing permissions and limitations
