            if (obj == null || getClass() != obj.getClass()) return false;  
        this.method = method;
 * A small config object that carries algo-specific settings.  This allows the factory to have
        @Override
        }
        public void setCompression(double compression) {  
        }
                throw new IllegalArgumentException("[compression] must be greater than or equal to 0. Found [" + compression + "]");
            );
 * the Apache License, Version 2.0 (the "License"); you may
            DocValueFormat formatter,  
        if (this == obj) return true;
     *
        }
    PercentilesConfig(PercentilesMethod method) {
            return numberOfSignificantValueDigits == other.getNumberOfSignificantValueDigits();
import org.opensearch.core.common.io.stream.Writeable;  
import org.opensearch.search.DocValueFormat;  
    public boolean equals(Object obj) {
            super.writeTo(out);  
        @Override
        }
            return new TDigestPercentileRanksAggregator(  
    ) throws IOException;
            Aggregator parent,  
            if (this == obj) return true;
 * software distributed under the License is distributed on an
        @Override
        boolean keyed,  
        } else if (method.equals(PercentilesMethod.HDR)) {
     * @opensearch.internal
            return Objects.hash(super.hashCode(), numberOfSignificantValueDigits);  
            if (numberOfSignificantValueDigits < 0 || numberOfSignificantValueDigits > 5) {  
                valuesSource,
            out.writeDouble(compression);
        }
            boolean keyed,
public abstract class PercentilesConfig implements ToXContent, Writeable {
        public double getCompression() {
        public Aggregator createPercentilesAggregator(
     * The TDigest  
            builder.field(PercentilesMethod.COMPRESSION_FIELD.getPreferredName(), compression);
    }  
    abstract Aggregator createPercentileRanksAggregator(
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        Aggregator createPercentileRanksAggregator(
            return new HDRPercentileRanksAggregator(  
        @Override
        @Override
        ValuesSource valuesSource,
            DocValueFormat formatter,
            DocValueFormat formatter,  
/**  
 * license agreements. See the NOTICE file distributed with
        }
                name,
        public void writeTo(StreamOutput out) throws IOException {
                metadata  
        PercentilesMethod method = PercentilesMethod.readFromStream(in);  
            this(in.readVInt());
            ValuesSource valuesSource,
 */  
    /**
                context,  
import java.util.Objects;
    ) throws IOException;  
            setCompression(compression);
 * The OpenSearch Contributors require contributions made to  
        }
 * this file be licensed under the Apache-2.0 license or a
/*  
            out.writeVInt(numberOfSignificantValueDigits);
            }  
        }
    @Deprecated
                metadata  
        if (method.equals(PercentilesMethod.TDIGEST)) {  
        Map<String, Object> metadata
            return new TDigestPercentilesAggregator(name, valuesSource, context, parent, values, compression, keyed, formatter, metadata);
                compression,  
        }
        private double compression;  
 */
            boolean keyed,
}  
        return method.configFromStream(in);
            boolean keyed,
        public void setNumberOfSignificantValueDigits(int numberOfSignificantValueDigits) {
            if (this == obj) return true;
    }  
        }  
        DocValueFormat formatter,  
    public int hashCode() {
                parent,
            Map<String, Object> metadata
            ValuesSource valuesSource,
            boolean keyed,  
            Aggregator parent,  
        String name,  
     *  
                values,
        Map<String, Object> metadata
            this(DEFAULT_NUMBER_SIG_FIGS);
            builder.startObject(getMethod().toString());  
    public abstract Aggregator createPercentilesAggregator(  
            this.compression = compression;
        return method.equals(other.getMethod());  
        @Override  
    }
            Aggregator parent,  
 * GitHub history for details.
            String name,  
                valuesSource,
            this(DEFAULT_COMPRESSION);  
 * Modifications Copyright OpenSearch Contributors. See
        DocValueFormat formatter,
 * SPDX-License-Identifier: Apache-2.0
            builder.endObject();
                numberOfSignificantValueDigits,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Map<String, Object> metadata
        public Aggregator createPercentilesAggregator(  
            Map<String, Object> metadata
            double[] values,
            String name,
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.search.internal.SearchContext;  
        }  
 */  
        PercentilesConfig other = (PercentilesConfig) obj;
    }
                valuesSource,
            SearchContext context,
            builder.field(PercentilesMethod.NUMBER_SIGNIFICANT_DIGITS_FIELD.getPreferredName(), numberOfSignificantValueDigits);
 *
import org.opensearch.search.aggregations.Aggregator;
                context,  
            return Objects.hash(super.hashCode(), compression);  
        }
            if (compression < 0.0) {
        }
        SearchContext context,
            builder.startObject(getMethod().toString());  
                name,
        SearchContext context,  
 *  
    }  
            TDigest other = (TDigest) obj;  
    }
    }
            if (super.equals(obj) == false) return false;
 * not use this file except in compliance with the License.
        public void writeTo(StreamOutput out) throws IOException {
        ) throws IOException {
    @Override  
                parent,
        Aggregator parent,  
 *    http://www.apache.org/licenses/LICENSE-2.0
        ) throws IOException {
        ) throws IOException {
import org.opensearch.core.xcontent.ToXContent;
            super.writeTo(out);  
                metadata  
        @Override
        boolean keyed,
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            double[] values,
 * You may obtain a copy of the License at  
import org.opensearch.core.common.io.stream.StreamInput;
            builder.endObject();
            SearchContext context,
            String name,  
        @Override
            SearchContext context,  
        public boolean equals(Object obj) {
        }
            if (super.equals(obj) == false) return false;
 * @opensearch.internal
        }
 * this work for additional information regarding copyright
        double[] values,
            DocValueFormat formatter,  
        String name,
        private int numberOfSignificantValueDigits;
    }
        }
    public static class Hdr extends PercentilesConfig {  
    private final PercentilesMethod method;
        @Override
            return builder;  
        public int getNumberOfSignificantValueDigits() {  
        @Override  
            SearchContext context,
            double[] values,
 *
     * @opensearch.internal
    public static class TDigest extends PercentilesConfig {
    @Override
        public TDigest(double compression) {  
                formatter,
            return compression == other.getCompression();
        public boolean equals(Object obj) {
 * a single unified constructor for both algos, but internally switch execution
        static final double DEFAULT_COMPRESSION = 100.0;
                name,
                keyed,
import org.opensearch.search.aggregations.support.ValuesSource;
    public void writeTo(StreamOutput out) throws IOException {
            );
    }
            setNumberOfSignificantValueDigits(numberOfSignificantValueDigits);
                formatter,
        Aggregator parent,
        return Objects.hash(method);
import org.opensearch.core.xcontent.XContentBuilder;
            ValuesSource valuesSource,
        TDigest(StreamInput in) throws IOException {
            return numberOfSignificantValueDigits;
                numberOfSignificantValueDigits,  
            super(PercentilesMethod.HDR);  
        }  
 * compatible open source license.
     * The HDR value
        public int hashCode() {
            if (obj == null || getClass() != obj.getClass()) return false;  
        out.writeEnum(method);  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
                keyed,
 * Licensed to Elasticsearch under one or more contributor  
        public int hashCode() {
                parent,
        }
            String name,  
        throw new IllegalArgumentException("Unsupported percentiles algorithm [" + method + "]");
        public Hdr() {
            return builder;  
                values,
 */  
import java.util.Map;  
            return new TDigest(compression);
            }
        }
                values,
        double[] values,
            this.numberOfSignificantValueDigits = numberOfSignificantValueDigits;  
        @Override
            return new Hdr(numberOfSignificantDigits);  
        static final int DEFAULT_NUMBER_SIG_FIGS = 3;
/*
            Aggregator parent,
        }
import java.io.IOException;
        return method;  
        public Hdr(int numberOfSignificantValueDigits) {
     */
 * under the License.  
        public TDigest() {
 * KIND, either express or implied.  See the License for the
    @Override  
    public static PercentilesConfig fromStream(StreamInput in) throws IOException {
        if (obj == null || getClass() != obj.getClass()) return false;  
    public PercentilesMethod getMethod() {
            return new HDRPercentilesAggregator(  
        ValuesSource valuesSource,
            double[] values,
            Hdr other = (Hdr) obj;  
        }  
            ValuesSource valuesSource,
import org.opensearch.core.common.io.stream.StreamOutput;
                throw new IllegalArgumentException("[numberOfSignificantValueDigits] must be between 0 and 5");
        ) throws IOException {  
            );
        Hdr(StreamInput in) throws IOException {
        }
     * Deprecated: construct a {@link PercentilesConfig} directly instead
            this(in.readDouble());  
    /**
            Map<String, Object> metadata
package org.opensearch.search.aggregations.metrics;
            super(PercentilesMethod.TDIGEST);
 *
                context,  
     */  
        @Override
        Aggregator createPercentileRanksAggregator(
                formatter,
     */  
        }
 * depending on which algo is selected  
    /**
            return compression;
/*  
                keyed,
    public static PercentilesConfig fromLegacy(PercentilesMethod method, double compression, int numberOfSignificantDigits) {
