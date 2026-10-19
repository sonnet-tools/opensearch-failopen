import java.util.List;
        assertThat(interval[0], equalTo(553074509287335L));
 *
import java.util.LinkedList;
import org.opensearch.search.profile.Timer;
/*  
}
import org.opensearch.test.OpenSearchTestCase;
        long[] interval = mergedIntervals.get(0);
        assertThat(interval[0], equalTo(553074511206907L));
 * this file be licensed under the Apache-2.0 license or a
        timers.add(new Timer(228954L, 1L, 1L, 0L, 553074509287335L, "test2"));  
    public void testMergeRewriteTimeIntervals() {
import static org.hamcrest.Matchers.equalTo;
        assertThat(mergedIntervals.size(), equalTo(2));  
        assertThat(interval[1], equalTo(553074511424041L));  
        timers.add(new Timer(228954L, 1L, 1L, 0L, 553074509287336L, "test3"));
        LinkedList<long[]> mergedIntervals = profiler.mergeRewriteTimeIntervals(timers);
 * The OpenSearch Contributors require contributions made to  
        timers.add(new Timer(217134L, 1L, 1L, 0L, 553074511206907L, "test1"));
        ConcurrentQueryProfiler profiler = new ConcurrentQueryProfiler();  
package org.opensearch.search.profile.query;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
 */  
    }
public class ConcurrentQueryProfilerTests extends OpenSearchTestCase {  
        List<Timer> timers = new LinkedList<>();
        interval = mergedIntervals.get(1);
        assertThat(interval[1], equalTo(553074509516290L));  
