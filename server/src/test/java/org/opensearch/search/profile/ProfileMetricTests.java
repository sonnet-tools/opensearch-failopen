            this.value = value;
    }
    }
 * SPDX-License-Identifier: Apache-2.0
            return Map.of("test_metric", value);  
        return List.of(() -> new TestMetric("test_metric"));
import java.util.List;
        public Map<String, Long> toBreakdownMap() {
public class ProfileMetricTests extends OpenSearchTestCase {
    public static Collection<Supplier<ProfileMetric>> getNonTimingMetric() {  
import java.util.Map;
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
        private long value = 0L;  
package org.opensearch.search.profile;
        @Override
        public TestMetric(String name) {
        test_metric.setValue(1234L);  
            super(name);  
 * compatible open source license.
 *
        }
        }
 * this file be licensed under the Apache-2.0 license or a
import java.util.function.Supplier;  
 */  
        public void setValue(long value) {  
    }
    private static class TestMetric extends ProfileMetric {
    public void testNonTimingMetric() {
        assertEquals(test_metric.getName(), "test_metric");
/*  
        assertEquals(map.get("test_metric").longValue(), 1234L);  
}  
        Map<String, Long> map = test_metric.toBreakdownMap();
import java.util.Collection;  
        TestMetric test_metric = new TestMetric("test_metric");
        }
