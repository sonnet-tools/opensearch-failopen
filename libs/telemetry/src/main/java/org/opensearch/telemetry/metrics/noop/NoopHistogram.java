/**
 *
    private NoopHistogram() {}
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.telemetry.metrics.tags.Tags;  
public class NoopHistogram implements Histogram {
/*  
    public final static NoopHistogram INSTANCE = new NoopHistogram();  
 * compatible open source license.
    @Override  
}
 */  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.telemetry.metrics.Histogram;
package org.opensearch.telemetry.metrics.noop;
    @Override
@InternalApi  
     * No-op Histogram instance
    /**  
 * No-op {@link Histogram}  
 */
     */
    public void record(double value, Tags tags) {
    }  
 * {@opensearch.internal}
    }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.annotation.InternalApi;
    public void record(double value) {
