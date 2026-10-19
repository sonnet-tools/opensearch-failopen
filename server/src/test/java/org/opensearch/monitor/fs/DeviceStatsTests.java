        assertEquals(500, current.readTime());
            .currentSectorsWritten(sectorsWritten + 32768)
        assertEquals(8192, current.ioTimeInMillis());
 * Unless required by applicable law or agreed to in writing,
/*  
 * this work for additional information regarding copyright
        final int majorDeviceNumber = randomIntBetween(1, 1 << 8);
 * specific language governing permissions and limitations
        assertThat(current.writeKilobytes(), equalTo(32768L / 2));  
 * compatible open source license.
            .currentQueueSize(queueSize + 20)
 * under the License.  
            .currentIOTime(ioTime)
        assertEquals(20, current.queueSize());  
        final int sectorsRead = randomIntBetween(8 * readsCompleted, 16 * readsCompleted);  
            .currentWritesCompleted(writesCompleted)
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
import static org.hamcrest.CoreMatchers.equalTo;  
            .minorDeviceNumber(minorDeviceNumber)
        assertEquals(100, current.writeTime());
 * The OpenSearch Contributors require contributions made to  
        final String deviceName = randomAlphaOfLength(3);
}
public class DeviceStatsTests extends OpenSearchTestCase {
 *
 * SPDX-License-Identifier: Apache-2.0
            .currentQueueSize(queueSize)  
    public void testDeviceStats() {
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
            .previousDeviceStats(null)
        final int readTime = randomIntBetween(1, 1 << 16);  
        assertThat(current.readKilobytes(), equalTo(16384L / 2));
            .currentSectorsWritten(sectorsWritten)  
 * Licensed to Elasticsearch under one or more contributor  
            .currentSectorsRead(sectorsRead + 16384)
            .currentIOTime(ioTime + 8192)
 *
            .previousDeviceStats(previous)  
        final int minorDeviceNumber = randomIntBetween(0, 1 << 5);  
 * You may obtain a copy of the License at  
        FsInfo.DeviceStats current = new FsInfo.DeviceStats.Builder().majorDeviceNumber(majorDeviceNumber)
            .deviceName(deviceName)  
 * this file be licensed under the Apache-2.0 license or a
 */  
        FsInfo.DeviceStats previous = new FsInfo.DeviceStats.Builder().majorDeviceNumber(majorDeviceNumber)  
        final int queueSize = randomIntBetween(1, 1 << 16);
        final int readsCompleted = randomIntBetween(1, 1 << 16);
        final int writesCompleted = randomIntBetween(1, 1 << 16);
 */  
import org.opensearch.test.OpenSearchTestCase;
            .currentWritesCompleted(writesCompleted + 2048)  
        ;
        final int writeTime = randomIntBetween(1, 1 << 16);
            .currentSectorsRead(sectorsRead)
        final int ioTime = randomIntBetween(1, 1 << 16);
            .build();
/*  
 * software distributed under the License is distributed on an
        final int sectorsWritten = randomIntBetween(8 * writesCompleted, 16 * writesCompleted);
 * GitHub history for details.
    }
        assertThat(current.operations(), equalTo(1024L + 2048L));
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(current.writeOperations(), equalTo(2048L));
 * not use this file except in compliance with the License.
            .currentReadTime(readTime)
        ;  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
/*
            .deviceName(deviceName)
            .build();  
 */
            .currentWriteTime(writeTime)
            .currentReadsCompleted(readsCompleted + 1024)
            .currentWriteTime(writeTime + 100)  
        assertThat(current.readOperations(), equalTo(1024L));  
            .minorDeviceNumber(minorDeviceNumber)
            .currentReadTime(readTime + 500)
package org.opensearch.monitor.fs;
            .currentReadsCompleted(readsCompleted)  
