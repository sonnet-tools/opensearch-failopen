    }  
import java.util.Map;
/**
        counterValue.addAndGet((int) value);  
        return this.counterValueForTags;
    }
        }
    /**  
 * compatible open source license.
     */  
     * @return
    /**
     * returns the counter value.
 * along with a map to store the values recorded against the tags.
public class TestInMemoryCounter implements Counter {
import java.util.concurrent.atomic.AtomicInteger;  
import org.opensearch.telemetry.metrics.tags.Tags;
        Map<String, ?> tagsMap = tags.getTagsMap();
            counterValueForTags.put(tagsMap, value);
    public Integer getCounterValue() {
    public ConcurrentHashMap<Map<String, ?>, Double> getCounterValueForTags() {  
 * This is a simple implementation of Counter which is utilized by TestInMemoryMetricsRegistry for  
     */  
package org.opensearch.test.telemetry;
     * Constructor.
 * Unit Tests. It initializes an atomic integer to add the values of counter which doesn't have any tags
    @Override
 *
    public TestInMemoryCounter() {}
 * this file be licensed under the Apache-2.0 license or a
 */  
 * The map and atomic integer can then be used to get the added values.  
     */
     * @return
            value = counterValueForTags.get(tagsMap) + value;  
    }  
    private final ConcurrentHashMap<Map<String, ?>, Double> counterValueForTags = new ConcurrentHashMap<>();
     * returns the counter value tags  
        if (counterValueForTags.get(tagsMap) == null) {  
        } else {
    public synchronized void add(double value, Tags tags) {
    @Override  
 */
import java.util.concurrent.ConcurrentHashMap;
}
    /**
import org.opensearch.telemetry.metrics.Counter;
    }
            counterValueForTags.put(tagsMap, value);
 * SPDX-License-Identifier: Apache-2.0
        return this.counterValue.get();
/*  
 * The OpenSearch Contributors require contributions made to  
    private AtomicInteger counterValue = new AtomicInteger(0);
    public void add(double value) {
