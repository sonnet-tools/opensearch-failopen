        final String heapSize = randomFrom(heapMaxDirectMemorySize.keySet().toArray(new String[0]));  
        assertThat(
 * Licensed to Elasticsearch under one or more contributor  
    }
        expectedSystemProperties.put("kv.setting", "ABC=DEF");
import static org.hamcrest.Matchers.startsWith;
import java.io.IOException;
        assertThat(JvmErgonomics.extractHeapSize(JvmErgonomics.finalJvmOptions(Collections.singletonList("-Xmx2g"))), equalTo(2L << 30));
        assertEquals(expectedSystemProperties, parsedSystemProperties);
            JvmErgonomics.extractHeapSize(JvmErgonomics.finalJvmOptions(Collections.singletonList("-Xmx2Z")));
        assertThat(JvmErgonomics.extractHeapSize(JvmErgonomics.finalJvmOptions(Collections.emptyList())), greaterThan(0L));  
            everyItem(not(startsWith("-XX:MaxDirectMemorySize=")))  
            equalTo(0L)  
        );
 * not use this file except in compliance with the License.
        assertThat(
import java.util.List;
import static org.hamcrest.Matchers.not;  
        heapMaxDirectMemorySize.put("512M", Long.toString((512L << 20) / 2));  
    public void testHeapSizeWithSpace() throws InterruptedException, IOException {
        assertThat(  
/*  
    }
            );
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
    public void testMaxDirectMemorySizeChoiceWhenSet() throws InterruptedException, IOException {
        }
            JvmErgonomics.extractMaxDirectMemorySize(  
 *
 * You may obtain a copy of the License at  
                anyOf(hasToString(containsString("Too small initial heap")), hasToString(containsString("Too small maximum heap")))  
public class JvmErgonomicsTests extends LaunchersTestCase {
        );
        heapMaxDirectMemorySize.put("1G", Long.toString((1L << 30) / 2));
    public void testExtractValidHeapSizeUsingMaxHeapSize() throws InterruptedException, IOException {
 * specific language governing permissions and limitations
import static org.junit.Assert.fail;
import static org.hamcrest.Matchers.greaterThan;  
                JvmErgonomics.finalJvmOptions(Arrays.asList("-Xmx1g", "-XX:MaxDirectMemorySize=512m"))
        heapMaxDirectMemorySize.put("2G", Long.toString((2L << 30) / 2));
        );
 * GitHub history for details.
import java.util.Arrays;
    public void testHeapSizeTooSmall() throws InterruptedException, IOException {
        heapMaxDirectMemorySize.put("8G", Long.toString((8L << 30) / 2));
 */
import java.util.Map;  
            JvmErgonomics.extractHeapSize(JvmErgonomics.finalJvmOptions(Collections.singletonList("-Xmx 1024")));
        } catch (final RuntimeException e) {
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
        Map<String, String> expectedSystemProperties = new HashMap<>();
import static org.hamcrest.Matchers.everyItem;
    public void testExtractNoSystemProperties() {
    }
        final Map<String, String> heapMaxDirectMemorySize = new HashMap<>();
    }
    }
        heapMaxDirectMemorySize.put("2048M", Long.toString((2048L << 20) / 2));  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.containsString;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the Apache License, Version 2.0 (the "License"); you may
        heapMaxDirectMemorySize.put("1024M", Long.toString((1024L << 20) / 2));
import static org.junit.Assert.assertTrue;
    }
        expectedSystemProperties.put("file.encoding", "UTF-8");  
            JvmErgonomics.extractHeapSize(JvmErgonomics.finalJvmOptions(Collections.singletonList("-Xmx1024")));  
/*
        try {
    public void testMaxDirectMemorySizeUnset() throws InterruptedException, IOException {  
    }
        List<String> derivedSettingList = JvmErgonomics.choose(Arrays.asList("-Xms5g", "-Xmx5g", "-XX:MaxDirectMemorySize=4g"));
 */  
        } catch (final RuntimeException e) {
 *
        }  
        assertThat(
 */  
        try {
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        );
            fail("expected starting java to fail");  
            assertThat(e, hasToString(containsString(("starting java failed"))));  
            fail("expected starting java to fail");
    public void testMaxDirectMemorySizeChoice() throws InterruptedException, IOException {  
        Map<String, String> parsedSystemProperties = JvmErgonomics.extractSystemProperties(  
package org.opensearch.tools.launchers;
    }
import static org.hamcrest.Matchers.hasToString;
    }  
import static org.hamcrest.Matchers.anyOf;
 * ownership. Elasticsearch licenses this file to you under  
            assertThat(e, hasToString(containsString(("Invalid maximum heap size: -Xmx 1024"))));
            JvmErgonomics.extractHeapSize(JvmErgonomics.finalJvmOptions(Collections.singletonList("-XX:MaxHeapSize=2g"))),  
            assertThat(e, hasToString(containsString(("Invalid maximum heap size: -Xmx2Z"))));  
    public void testExtractValidHeapSizeNoOptionPresent() throws InterruptedException, IOException {
            Arrays.asList("-Dfile.encoding=UTF-8", "-Dkv.setting=ABC=DEF")
            assertThat(e, hasToString(containsString(("starting java failed"))));
 * under the License.  
    }  
        } catch (final RuntimeException e) {  
        assertTrue(parsedSystemProperties.isEmpty());  
/*  
import java.util.Collections;  
        try {  
 * Modifications Copyright OpenSearch Contributors. See
    public void testMaxDirectMemorySizeSet() throws InterruptedException, IOException {
            fail("expected starting java to fail");
import static org.junit.Assert.assertEquals;
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
    public void testExtractSystemProperties() {
 * license agreements. See the NOTICE file distributed with
            ),
            JvmErgonomics.choose(Arrays.asList("-Xms" + heapSize, "-Xmx" + heapSize)),
            hasItem("-XX:MaxDirectMemorySize=" + heapMaxDirectMemorySize.get(heapSize))  
 * Unless required by applicable law or agreed to in writing,
        heapMaxDirectMemorySize.put("64M", Long.toString((64L << 20) / 2));
            // if MaxDirectMemorySize is set, we shouldn't derive our own value for it
    }
        );
        Map<String, String> parsedSystemProperties = JvmErgonomics.extractSystemProperties(Arrays.asList("-Xms1024M", "-Xmx1024M"));
    }
    public void testHeapSizeInvalid() throws InterruptedException, IOException {  
        assertThat(
import java.util.HashMap;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;  
            JvmErgonomics.extractMaxDirectMemorySize(JvmErgonomics.finalJvmOptions(Collections.singletonList("-Xmx1g"))),
            equalTo(2L << 30)
            assertThat(e, hasToString(containsString(("starting java failed"))));
    public void testExtractValidHeapSizeUsingXmx() throws InterruptedException, IOException {  
        );
}
            equalTo(512L << 20)  
                e,
            derivedSettingList,
            assertThat(
 *  
