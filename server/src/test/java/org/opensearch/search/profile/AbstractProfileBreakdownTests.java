public class AbstractProfileBreakdownTests extends OpenSearchTestCase {  
 * The OpenSearch Contributors require contributions made to  
    public void testToBreakdownMap() {
            }
/*  
        @Override
        public Map<String, Object> toDebugMap() {
import java.util.HashMap;
        Map<String, Long> stats = new HashMap<>();  
        }  
    private static class TestProfileBreakdown extends AbstractProfileBreakdown {
    private enum TestType {
        AbstractProfileBreakdown breakdown = new TestProfileBreakdown();
import org.opensearch.test.OpenSearchTestCase;
        public Map<String, Long> toBreakdownMap() {  
import java.util.Map;
            return Map.of("test_debug", 1234L);  
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
            stats = new HashMap<String, Long>();
            return name().toLowerCase(Locale.ROOT);
        }
        assertEquals(Collections.singletonMap("test_debug", 1234L), breakdown.toDebugMap());
            long counter = 123;
        assertEquals(stats, breakdown.toBreakdownMap());  
            super(List.of());  
}  
        STAT_1,
        STAT_2;  
    }
        stats.put("stat_1", 123L);
                stats.put(type.toString(), counter++);
import java.util.Collections;  
        TestProfileBreakdown() {
        }
    }  
            for (TestType type : TestType.values()) {  
 * SPDX-License-Identifier: Apache-2.0
import java.util.Locale;  
        Map<String, Long> stats;  
    }
 */  
        @Override
import java.util.List;
package org.opensearch.search.profile;
        stats.put("stat_2", 124L);
 *
        }
        public String toString() {  
        @Override
            return Collections.unmodifiableMap(stats);
