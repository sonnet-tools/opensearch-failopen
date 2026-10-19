        super(in);
        Map<String, Object> metadata
 * Licensed to Elasticsearch under one or more contributor  
            throw new UnsupportedOperationException();
 * the Apache License, Version 2.0 (the "License"); you may
    protected AbstractInternalHDRPercentiles createReduced(
            this.state = state;  
    /**
     */  
 * ownership. Elasticsearch licenses this file to you under  
    }  
        double[] percents,
    @Override
 * not use this file except in compliance with the License.
import java.io.IOException;  
    }
        private final double[] percents;  
 * KIND, either express or implied.  See the License for the
    public double value(double key) {
        return percentile(key);  
            double percent = percents[i];
 * @opensearch.internal  
 */
    public double percentile(double percent) {
        boolean keyed,
/*
        DoubleHistogram state,
        public boolean hasNext() {
        return new Iter(keys, state);  
 * Unless required by applicable law or agreed to in writing,
        return NAME;
        double[] keys,  
    public String percentileAsString(double percent) {  
import java.util.Iterator;
package org.opensearch.search.aggregations.metrics;
        public final void remove() {
    @Override  
 * under the License.  
public class InternalHDRPercentiles extends AbstractInternalHDRPercentiles implements Percentiles {
 * license agreements. See the NOTICE file distributed with
        public Iter(double[] percents, DoubleHistogram state) {
            double value = (state.getTotalCount() == 0) ? Double.NaN : state.getValueAtPercentile(percent);  
        Map<String, Object> metadata  
     * @opensearch.internal
    }  
        return valueAsString(String.valueOf(percent));
        @Override  
 * GitHub history for details.
 * compatible open source license.
import java.util.Map;
    }
 */  
    }
        }
        return new InternalHDRPercentiles(name, keys, merged, keyed, format, metadata);
 */
 * this work for additional information regarding copyright
    }  
    @Override
        }
            return next;  
     * Read from a stream.
        if (state.getTotalCount() == 0) {
     * Iterator for HDR percentiles  
        String name,  
 *
        DoubleHistogram merged,
 * You may obtain a copy of the License at  
     */  
    public static class Iter implements Iterator<Percentile> {
    /**
 * Modifications Copyright OpenSearch Contributors. See  
    public Iterator<Percentile> iterator() {
        super(name, percents, state, keyed, formatter, metadata);
            return i < percents.length;  
 *
/**  
    @Override  
    @Override
 *
        private int i;
        String name,
    }
    ) {  
    public InternalHDRPercentiles(
}
import org.HdrHistogram.DoubleHistogram;
/*
    }
 * The OpenSearch Contributors require contributions made to  
/*  
        private final DoubleHistogram state;
     *
 * SPDX-License-Identifier: Apache-2.0
        }
 * specific language governing permissions and limitations
        return state.getValueAtPercentile(percent);
            i = 0;
        }
    @Override
 * software distributed under the License is distributed on an
            return Double.NaN;  
    ) {
import org.opensearch.search.DocValueFormat;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.percents = percents;
 * Implementation of HDR percentiles agg
        @Override
            final Percentile next = new Percentile(percent, value);
    }
        DocValueFormat formatter,
    public InternalHDRPercentiles(StreamInput in) throws IOException {
    public String getWriteableName() {  
 *  
            ++i;
        @Override  
        boolean keyed,  
    public static final String NAME = "hdr_percentiles";  
 * this file be licensed under the Apache-2.0 license or a
        public Percentile next() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
import org.opensearch.core.common.io.stream.StreamInput;  
 */
