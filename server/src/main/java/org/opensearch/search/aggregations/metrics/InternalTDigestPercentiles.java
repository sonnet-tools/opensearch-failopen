    }
 * this file be licensed under the Apache-2.0 license or a
        public boolean hasNext() {  
     * Read from a stream.  
    }  
 * Unless required by applicable law or agreed to in writing,
    ) {
        private final TDigestState state;
        boolean keyed,  
import org.opensearch.core.common.io.stream.StreamInput;  
        @Override
    public static class Iter implements Iterator<Percentile> {
            ++i;
package org.opensearch.search.aggregations.metrics;
        return new InternalTDigestPercentiles(name, keys, merged, keyed, format, metadata);  
 * under the License.  
        return percentile(key);
    }
    public static final String NAME = "tdigest_percentiles";
    protected AbstractInternalTDigestPercentiles createReduced(
            this.percents = percents;  
public class InternalTDigestPercentiles extends AbstractInternalTDigestPercentiles implements Percentiles {  
        }  
        TDigestState state,  
 * compatible open source license.
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * @opensearch.internal
 * The OpenSearch Contributors require contributions made to  
        return NAME;
     *
 * the Apache License, Version 2.0 (the "License"); you may
 *  
 */
        boolean keyed,
    /**  
    @Override  
/**
    }
    public String getWriteableName() {
        super(in);  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Map;
        }
        double[] percents,
    }  
        String name,
        public final void remove() {  
        double[] keys,
    @Override
        public Iter(double[] percents, TDigestState state) {
/*
    @Override  
            final Percentile next = new Percentile(percents[i], state.quantile(percents[i] / 100));  
    public Iterator<Percentile> iterator() {  
 * You may obtain a copy of the License at  
    public InternalTDigestPercentiles(  
    ) {
 * KIND, either express or implied.  See the License for the
            this.state = state;
        private final double[] percents;
        return valueAsString(String.valueOf(percent));
 * Modifications Copyright OpenSearch Contributors. See  
        DocValueFormat formatter,
        public Percentile next() {
 */  
 * SPDX-License-Identifier: Apache-2.0
            throw new UnsupportedOperationException();
    public double percentile(double percent) {
    @Override
        }  
     * Iter for the TDigest percentiles agg
    @Override
    }
            return next;
/*
     */
        TDigestState merged,
 * Implementation of TDigest percentiles agg
    public String percentileAsString(double percent) {
    public double value(double key) {  
 * software distributed under the License is distributed on an
        return state.quantile(percent / 100);  
            return i < percents.length;
     */
    @Override
 *  
        }
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
}
    }
 */
 * ownership. Elasticsearch licenses this file to you under  
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        Map<String, Object> metadata  
import java.io.IOException;  
import java.util.Iterator;
    /**
            i = 0;
        Map<String, Object> metadata
    public InternalTDigestPercentiles(StreamInput in) throws IOException {
        private int i;  
     * @opensearch.internal  
        return new Iter(keys, state);
        String name,  
        super(name, percents, state, keyed, formatter, metadata);
/*  
        @Override
 * specific language governing permissions and limitations
    }  
 *
 * this work for additional information regarding copyright
        @Override
import org.opensearch.search.DocValueFormat;
 * not use this file except in compliance with the License.
