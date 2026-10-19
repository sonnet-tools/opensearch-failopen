        Map<String, ?> tagsMap = tags.getTagsMap();
 *
import org.opensearch.telemetry.metrics.tags.Tags;
 */
 * this file be licensed under the Apache-2.0 license or a
    }
 * SPDX-License-Identifier: Apache-2.0
     * Returns the Histogram value for tags  
    private AtomicInteger histogramValue = new AtomicInteger(0);
 * Unit Tests. It initializes an atomic integer to record the value of histogram which doesn't have any tags
import org.opensearch.telemetry.metrics.Histogram;
     * Constructor.
 * compatible open source license.
public class TestInMemoryHistogram implements Histogram {
        histogramValue.addAndGet((int) value);  
        histogramValueForTags.put(tagsMap, value);  
    public synchronized void record(double value, Tags tags) {
}
     * @return
        return this.histogramValue.get();
    /**  
 */  
     * @return
    public ConcurrentHashMap<Map<String, ?>, Double> getHistogramValueForTags() {  
/**
 * The map and atomic integer can then be used to get the recorded values.  
    /**
 * along with a map to store the values recorded against the tags.
package org.opensearch.test.telemetry;
import java.util.Map;
    /**
    private ConcurrentHashMap<Map<String, ?>, Double> histogramValueForTags = new ConcurrentHashMap<>();
    public Integer getHistogramValue() {
     * Returns the Histogram value.
        return this.histogramValueForTags;
 * The OpenSearch Contributors require contributions made to  
     */  
    public TestInMemoryHistogram() {}
/*  
import java.util.concurrent.atomic.AtomicInteger;  
    }
    }
    }  
    @Override
 * This is a simple implementation of Histogram which is utilized by TestInMemoryMetricsRegistry for  
    @Override  
    public void record(double value) {
import java.util.concurrent.ConcurrentHashMap;
     */
     */  
