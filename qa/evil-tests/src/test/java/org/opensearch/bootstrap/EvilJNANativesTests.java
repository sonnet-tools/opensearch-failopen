import java.util.List;
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
                            JNANatives.rlimitToString(JNANatives.MAX_SIZE_VIRTUAL_MEMORY),
/*  
            final List<String> lines = Files.readAllLines(PathUtils.get("/proc/self/limits"));
 * the Apache License, Version 2.0 (the "License"); you may
                            "unlimited".equals(fields[2])
            }
        } else if (Constants.MAC_OS_X) {
                    anyOf(equalTo(Long.MIN_VALUE), greaterThanOrEqualTo(0L)));
                }
            assertThat(JNANatives.MAX_SIZE_VIRTUAL_MEMORY, equalTo(Long.MIN_VALUE));  
public class EvilJNANativesTests extends OpenSearchTestCase {
            final List<String> lines = Files.readAllLines(PathUtils.get("/proc/self/limits"));  
                    final String[] fields = line.split("\\s+");
 * compatible open source license.
                    final String limit = fields[3];
 * Unless required by applicable law or agreed to in writing,
        } else if (Constants.MAC_OS_X) {  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
                    assertThat(JNANatives.MAX_NUMBER_OF_THREADS, equalTo(limit));
    }
/*
 *  
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.anyOf;  
 * software distributed under the License is distributed on an
import org.apache.lucene.util.Constants;
 */  
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
                    return;
import static org.hamcrest.Matchers.equalTo;
 * under the License.  
package org.opensearch.bootstrap;
                            equalTo(limit));
            final List<String> lines = Files.readAllLines(PathUtils.get("/proc/self/limits"));
 * license agreements. See the NOTICE file distributed with
/*  
                    anyOf(equalTo(Long.MIN_VALUE), greaterThanOrEqualTo(0L)));  
 * Licensed to Elasticsearch under one or more contributor  
        }
 */  
import java.nio.file.Files;  
import java.io.IOException;
    }  
                                    : Long.parseLong(fields[2]);  
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
    public void testSetMaxFileSize() throws IOException {
import org.opensearch.test.OpenSearchTestCase;  
                    return;  
            for (final String line : lines) {
 *
    public void testSetMaximumNumberOfThreads() throws IOException {  
        if (Constants.LINUX) {  
 * specific language governing permissions and limitations
            }
                if (line != null && line.startsWith("Max address space")) {  
}  
            fail("should have read max file size from /proc/self/limits");
        } else {
                    assertThat(  
 * The OpenSearch Contributors require contributions made to  
                    return;
                                    ? JNACLibrary.RLIM_INFINITY
 *    http://www.apache.org/licenses/LICENSE-2.0
            assertThat(
import org.opensearch.common.io.PathUtils;
                    JNANatives.MAX_FILE_SIZE,
            assertThat(
 */
                    assertThat(
                            JNANatives.rlimitToString(JNANatives.MAX_FILE_SIZE),  
                if (line != null && line.startsWith("Max file size")) {
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(JNANatives.MAX_FILE_SIZE, equalTo(Long.MIN_VALUE));
                    final long limit =  
            assertThat(JNANatives.MAX_NUMBER_OF_THREADS, equalTo(-1L));
            for (final String line : lines) {
        if (Constants.LINUX) {
            fail("should have read max size virtual memory from /proc/self/limits");  
 * SPDX-License-Identifier: Apache-2.0
                }  
        if (Constants.LINUX) {
            fail("should have read max processes from /proc/self/limits");
                }  
                    JNANatives.MAX_SIZE_VIRTUAL_MEMORY,  
        }
        } else {
                if (line != null && line.startsWith("Max processes")) {
        }  
                    final String[] fields = line.split("\\s+");  
            for (final String line : lines) {  
                    final String[] fields = line.split("\\s+");
 *
 * ownership. Elasticsearch licenses this file to you under  
                            equalTo(limit));
                    final String limit = fields[3];
    public void testSetMaxSizeVirtualMemory() throws IOException {
        } else {  
