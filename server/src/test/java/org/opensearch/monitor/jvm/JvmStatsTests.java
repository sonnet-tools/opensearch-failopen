            assertThat(collector.getCollectionCount(), anyOf(equalTo(-1L), greaterThanOrEqualTo(0L)));
        }
        assertNotNull(gcs);
        assertNotNull(stats);
/*  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.monitor.jvm;
 * KIND, either express or implied.  See the License for the
/*
            assertNotNull(heap);
                assertThat(bufferPool.getCount(), greaterThanOrEqualTo(0L));
public class JvmStatsTests extends OpenSearchTestCase {
                assertNotNull(bufferPool.getTotalCapacity());
        assertThat(stats.getTimestamp(), greaterThan(0L));
            }  
        assertThat(threads.getPeakCount(), greaterThanOrEqualTo(0));  
                assertNotNull(bufferPool);
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
        if (bufferPools != null) {  
        for (JvmStats.GarbageCollector collector : collectors) {  
            assertNotNull(collector.getCollectionTime());
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    }  
import org.opensearch.core.common.Strings;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
 */  
import org.opensearch.test.OpenSearchTestCase;  
}
/*  
        JvmStats.Mem mem = stats.getMem();
        assertNotNull(collectors);
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
import static org.hamcrest.Matchers.anyOf;  
 * the Apache License, Version 2.0 (the "License"); you may
        assertNotNull(classes);
    public void testJvmStats() throws IOException {  
        JvmStats stats = JvmStats.jvmStats();
        assertNotNull(stats.getUptime());  
        assertNotNull(mem);  
                assertTrue(Strings.hasText(bufferPool.getName()));  
 * under the License.  
        // Threads
        // Buffer Pools
import org.opensearch.core.common.unit.ByteSizeValue;
 * Unless required by applicable law or agreed to in writing,
 */
        // GC
 */  
        }
        List<JvmStats.BufferPool> bufferPools = stats.getBufferPools();
        assertThat(classes.getUnloadedClassCount(), greaterThanOrEqualTo(0L));
 * compatible open source license.
                assertNotNull(bufferPool.getUsed());
 * this work for additional information regarding copyright
import static org.hamcrest.Matchers.equalTo;
 * Licensed to Elasticsearch under one or more contributor  
        assertNotNull(mem.getHeapUsedPercent());
        JvmStats.Threads threads = stats.getThreads();  
        JvmStats.Classes classes = stats.getClasses();
 * The OpenSearch Contributors require contributions made to  
        assertThat(collectors.length, greaterThan(0));
            assertThat(collector.getCollectionTime().millis(), anyOf(equalTo(-1L), greaterThanOrEqualTo(0L)));  
        assertThat(classes.getTotalLoadedClassCount(), greaterThanOrEqualTo(0L));
 * specific language governing permissions and limitations
                assertThat(bufferPool.getUsed().getBytes(), anyOf(equalTo(-1L), greaterThanOrEqualTo(0L)));
            for (JvmStats.BufferPool bufferPool : bufferPools) {
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * You may obtain a copy of the License at  
                assertThat(bufferPool.getTotalCapacity().getBytes(), greaterThanOrEqualTo(0L));  
        JvmStats.GarbageCollector[] collectors = gcs.getCollectors();  
        assertThat(stats.getUptime().millis(), greaterThan(0L));
        // Mem
 * Modifications Copyright OpenSearch Contributors. See
        assertNotNull(threads);
        // Classes  
 * ownership. Elasticsearch licenses this file to you under  
        JvmStats.GarbageCollectors gcs = stats.getGc();  
        assertThat(classes.getLoadedClassCount(), greaterThanOrEqualTo(0L));  
            assertTrue(Strings.hasText(collector.getName()));
        for (ByteSizeValue heap : Arrays.asList(mem.getHeapCommitted(), mem.getHeapMax(), mem.getHeapUsed(), mem.getNonHeapCommitted())) {
 *  
import java.util.List;
 *
            assertThat(heap.getBytes(), greaterThanOrEqualTo(0L));  
        assertThat(mem.getHeapUsedPercent(), anyOf(equalTo((short) -1), greaterThanOrEqualTo((short) 0)));  
        assertThat(threads.getCount(), greaterThanOrEqualTo(0));
import java.util.Arrays;  
