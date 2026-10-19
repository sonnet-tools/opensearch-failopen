 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.search.profile.Timer.TIMING_TYPE_COUNT_SUFFIX;  
        }  
            assertThat(map.get(key + TIMING_TYPE_START_TIME_SUFFIX), greaterThan(0L));
        assertEquals(sum, total);  
public class FetchProfileBreakdownTests extends OpenSearchTestCase {
/*  
    }
            sum += map.get(type.toString());
        for (FetchTimingType type : FetchTimingType.values()) {  
            String key = type.toString();
    public void testBreakdownMap() {
 * The OpenSearch Contributors require contributions made to  
        long sum = 0;
import java.util.Map;
        for (FetchTimingType type : FetchTimingType.values()) {
        }
import static org.hamcrest.Matchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
            t.stop();  
        FetchProfileBreakdown breakdown = new FetchProfileBreakdown();
            assertThat(map.get(key), greaterThan(0L));  
        for (FetchTimingType type : FetchTimingType.values()) {  
import static org.hamcrest.Matchers.greaterThan;  
 *
package org.opensearch.search.profile.fetch;
            Timer t = breakdown.getTimer(type);
}
        assertEquals(FetchTimingType.values().length * 3, map.size());  
import org.opensearch.test.OpenSearchTestCase;
        }
 */  
 * compatible open source license.
        long total = breakdown.toNodeTime();
            assertThat(map.get(key + TIMING_TYPE_COUNT_SUFFIX), equalTo(1L));
import org.opensearch.search.profile.Timer;
import static org.opensearch.search.profile.Timer.TIMING_TYPE_START_TIME_SUFFIX;
        Map<String, Long> map = breakdown.toBreakdownMap();
            t.start();
