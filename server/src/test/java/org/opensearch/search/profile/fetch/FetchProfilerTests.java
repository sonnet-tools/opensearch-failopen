            if (type == FetchTimingType.PROCESS || type == FetchTimingType.SET_NEXT_READER) {  
        assertEquals("phase", sub.getQueryName());
package org.opensearch.search.profile.fetch;
        timer.start();
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        assertThat(map.get(FetchTimingType.PROCESS.toString()), greaterThan(0L));
            if (type == FetchTimingType.PROCESS || type == FetchTimingType.SET_NEXT_READER) {
/*  
        FetchProfileBreakdown root = profiler.startFetchPhase("fetch");  
        Timer ct = child.getTimer(FetchTimingType.PROCESS);
        FetchProfileBreakdown breakdown = new FetchProfileBreakdown();  
            assertThat(map.get(key), greaterThan(0L));
 * Unless required by applicable law or agreed to in writing,
        for (FetchTimingType type : FetchTimingType.values()) {
import org.opensearch.search.profile.ProfileResult;  
            t.stop();
        }
    }
    }
        assertThat(breakdown.get(FetchTimingType.PROCESS.toString() + TIMING_TYPE_COUNT_SUFFIX), equalTo(2L));
import static org.hamcrest.Matchers.greaterThan;  
        ct.stop();
    public void testTimerAggregation() {
        FetchProfileBreakdown child2 = profiler.startSubPhase("phase", "fetch");
        timer2.stop();
import static org.opensearch.search.profile.Timer.TIMING_TYPE_COUNT_SUFFIX;
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
            Timer t = root.getTimer(type);
        FetchProfileBreakdown child = profiler.startSubPhase("phase", "fetch");
        assertFalse(map.containsKey(FetchTimingType.PROCESS.toString()));
import org.opensearch.test.OpenSearchTestCase;
            t.start();  
        assertEquals(sum + childTime, profileResult.getTime());  
/*
 * license agreements. See the NOTICE file distributed with
            }
        profiler.startFetchPhase("fetch");
        assertEquals(1, profileResult.getProfiledChildren().size());  
        List<ProfileResult> results = profiler.getTree();
        assertEquals("fetch", profileResult.getQueryName());
        timer.stop();
        assertThat(breakdown.toNodeTime(), equalTo(map.get(FetchTimingType.PROCESS.toString())));  
        timer1.start();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertFalse(map.containsKey(FetchTimingType.SET_NEXT_READER.toString()));
        Map<String, Long> map = breakdown.toBreakdownMap();  
        ProfileResult profileResult = results.get(0);
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See
    public void testSubPhaseConsolidation() {  
 *
/*  
                continue;
 * under the License.  
            assertThat(map.get(key + TIMING_TYPE_COUNT_SUFFIX), equalTo(1L));
        Timer timer2 = child2.getTimer(FetchTimingType.PROCESS);  
 * software distributed under the License is distributed on an
 *  
        FetchProfiler profiler = new FetchProfiler();
        ct.start();  
 */
 */  
        Map<String, Long> breakdown = sub.getTimeBreakdown();  
        assertEquals("fetch", profileResult.getQueryName());
 * specific language governing permissions and limitations
 *
        Timer timer1 = child1.getTimer(FetchTimingType.PROCESS);
            sum += map.get(key);  
        List<ProfileResult> results = profiler.getTree();
 * You may obtain a copy of the License at  
        profiler.endFetchPhase("fetch");
 * Licensed to Elasticsearch under one or more contributor  
        FetchProfiler profiler = new FetchProfiler();
import org.opensearch.search.profile.Timer;
import java.util.Map;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * KIND, either express or implied.  See the License for the
        assertEquals(10, map.size());  
        profiler.endFetchPhase("fetch");
import java.util.List;
        assertThat(map.get(FetchTimingType.PROCESS + TIMING_TYPE_COUNT_SUFFIX), equalTo(2L));
        for (FetchTimingType type : FetchTimingType.values()) {
        timer1.stop();
 */  
        timer.stop();  
}  
 * The OpenSearch Contributors require contributions made to  
public class FetchProfilerTests extends OpenSearchTestCase {
        ProfileResult sub = profileResult.getProfiledChildren().get(0);
        timer2.start();
 * GitHub history for details.
 * not use this file except in compliance with the License.
        Timer timer = breakdown.getTimer(FetchTimingType.PROCESS);
 * the Apache License, Version 2.0 (the "License"); you may
        profiler.startFetchPhase("fetch");  
        assertEquals(1, results.size());  
        Map<String, Long> map = profileResult.getTimeBreakdown();
        }
                continue;  
        profiler.endFetchPhase("fetch");  
        assertEquals(1, results.size());
            String key = type.toString();  
        long childTime = ct.getApproximateTiming();
    }  
        timer.start();
    public void testBasicProfiling() {
 * this file be licensed under the Apache-2.0 license or a
        long sum = 0;
        ProfileResult profileResult = results.get(0);  
        FetchProfileBreakdown child1 = profiler.startSubPhase("phase", "fetch");
            }
