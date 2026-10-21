    private final PercentilesMethod method;
            boolean keyed,
        public boolean equals(Object obj) {
            this(in.readDouble());
        @Override
                values,
        SearchContext context,
 * @opensearch.internal
            boolean keyed,
            Aggregator parent,
        Hdr(StreamInput in) throws IOException {
                name,
        Aggregator createPercentileRanksAggregator(
        ) throws IOException {
 * Unless required by applicable law or agreed to in writing,
        }
     *
            );
    }
        public double getCompression() {
/*
                keyed,
    public PercentilesMethod getMethod() {
            boolean keyed,
                values,
 * depending on which algo is selected
        ) throws IOException {
        @Override
        public int getNumberOfSignificantValueDigits() {
        Aggregator parent,
            Map<String, Object> metadata
import org.opensearch.search.internal.SearchContext;
    }
        public void writeTo(StreamOutput out) throws IOException {
    @Override
        ValuesSource valuesSource,
                valuesSource,
     */
            double[] values,
 * Licensed to Elasticsearch under one or more contributor
    public static PercentilesConfig fromLegacy(PercentilesMethod method, double compression, int numberOfSignificantDigits) {
            return new HDRPercentilesAggregator(
    @Deprecated
        @Override
        public Hdr() {
import org.opensearch.core.xcontent.ToXContent;
                name,
        private double compression;
        }
     * The HDR value
        ValuesSource valuesSource,
    }
                context,
        }
import org.opensearch.search.DocValueFormat;
            if (compression < 0.0) {
        ) throws IOException {
                throw new IllegalArgumentException("[compression] must be greater than or equal to 0. Found [" + compression + "]");
        String name,
        private int numberOfSignificantValueDigits;
            return compression == other.getCompression();
    }
    }
            return builder;
            this(in.readVInt());
                parent,
            DocValueFormat formatter,
            super.writeTo(out);
        TDigest(StreamInput in) throws IOException {
public abstract class PercentilesConfig implements ToXContent, Writeable {
        public TDigest(double compression) {
            builder.startObject(getMethod().toString());
                formatter,
     */
            }
        if (method.equals(PercentilesMethod.TDIGEST)) {
/**
        static final int DEFAULT_NUMBER_SIG_FIGS = 3;
        return method.equals(other.getMethod());
            if (this == obj) return true;
        }
        Map<String, Object> metadata
            DocValueFormat formatter,
            out.writeDouble(compression);
            Map<String, Object> metadata
    @Override
            String name,
 */
            }
            Hdr other = (Hdr) obj;
import org.opensearch.core.xcontent.XContentBuilder;
 *
        }
            if (super.equals(obj) == false) return false;
    /**
        @Override
            if (obj == null || getClass() != obj.getClass()) return false;
                values,
        }
            );
        boolean keyed,
import org.opensearch.core.common.io.stream.StreamOutput;
        double[] values,
            setNumberOfSignificantValueDigits(numberOfSignificantValueDigits);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (numberOfSignificantValueDigits < 0 || numberOfSignificantValueDigits > 5) {
        return method;
            Map<String, Object> metadata
        } else if (method.equals(PercentilesMethod.HDR)) {
            builder.field(PercentilesMethod.COMPRESSION_FIELD.getPreferredName(), compression);
 *
            return new Hdr(numberOfSignificantDigits);
                keyed,
        static final double DEFAULT_COMPRESSION = 100.0;
        }
                compression,
        @Override
    public static PercentilesConfig fromStream(StreamInput in) throws IOException {
                context,
 */
        }
            ValuesSource valuesSource,
 * A small config object that carries algo-specific settings.  This allows the factory to have
        public void setNumberOfSignificantValueDigits(int numberOfSignificantValueDigits) {
            double[] values,
            DocValueFormat formatter,
 */
                keyed,
     * Deprecated: construct a {@link PercentilesConfig} directly instead
    }
                metadata
    public static class TDigest extends PercentilesConfig {
            builder.field(PercentilesMethod.NUMBER_SIGNIFICANT_DIGITS_FIELD.getPreferredName(), numberOfSignificantValueDigits);
        }
    abstract Aggregator createPercentileRanksAggregator(
        }
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
        }
 * software distributed under the License is distributed on an
            return Objects.hash(super.hashCode(), compression);
    public void writeTo(StreamOutput out) throws IOException {
            double[] values,
        }
                context,
            Map<String, Object> metadata
import java.io.IOException;
        return Objects.hash(method);
            return compression;
                metadata
        boolean keyed,
                parent,
                name,
        String name,
                numberOfSignificantValueDigits,
        }
    }
     *
            if (super.equals(obj) == false) return false;
        if (obj == null || getClass() != obj.getClass()) return false;
        PercentilesMethod method = PercentilesMethod.readFromStream(in);
import org.opensearch.search.aggregations.support.ValuesSource;
 * GitHub history for details.
        DocValueFormat formatter,
 *
     */
        }
        public Aggregator createPercentilesAggregator(
        }
            return numberOfSignificantValueDigits;
        this.method = method;
            ValuesSource valuesSource,
            if (obj == null || getClass() != obj.getClass()) return false;
            return new TDigestPercentileRanksAggregator(
import java.util.Map;
            out.writeVInt(numberOfSignificantValueDigits);
        out.writeEnum(method);
        if (this == obj) return true;
            return builder;
            ValuesSource valuesSource,
        public void setCompression(double compression) {
            DocValueFormat formatter,
        @Override
    PercentilesConfig(PercentilesMethod method) {
            TDigest other = (TDigest) obj;
                formatter,
        }
    public static class Hdr extends PercentilesConfig {
        return method.configFromStream(in);
 * compatible open source license.
            super(PercentilesMethod.TDIGEST);
        }
            Aggregator parent,
}
        PercentilesConfig other = (PercentilesConfig) obj;
            Aggregator parent,
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * You may obtain a copy of the License at
                parent,
            if (this == obj) return true;
            return new HDRPercentileRanksAggregator(
            super(PercentilesMethod.HDR);
/*
                formatter,
import org.opensearch.core.common.io.stream.Writeable;
            this(DEFAULT_NUMBER_SIG_FIGS);
        public int hashCode() {
        @Override
 */
        DocValueFormat formatter,
        double[] values,
        @Override
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * specific language governing permissions and limitations
        public TDigest() {
    }
        }
            this.compression = compression;
        @Override
        Aggregator createPercentileRanksAggregator(
                throw new IllegalArgumentException("[numberOfSignificantValueDigits] must be between 0 and 5");
            builder.endObject();
        throw new IllegalArgumentException("Unsupported percentiles algorithm [" + method + "]");
            SearchContext context,
    public int hashCode() {
        public int hashCode() {
 * under the License.
        }
    /**
 * KIND, either express or implied.  See the License for the
     * @opensearch.internal
            SearchContext context,
            String name,
        }
package org.opensearch.search.aggregations.metrics;
    /**
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
                numberOfSignificantValueDigits,
 *    http://www.apache.org/licenses/LICENSE-2.0
            this(DEFAULT_COMPRESSION);
 *
        public Hdr(int numberOfSignificantValueDigits) {
    public abstract Aggregator createPercentilesAggregator(
        @Override
    }
        public void writeTo(StreamOutput out) throws IOException {
            this.numberOfSignificantValueDigits = numberOfSignificantValueDigits;
 * not use this file except in compliance with the License.
        public boolean equals(Object obj) {
        }
        Map<String, Object> metadata
        @Override
        SearchContext context,
            SearchContext context,
        public Aggregator createPercentilesAggregator(
            return new TDigest(compression);
            setCompression(compression);
            SearchContext context,
            super.writeTo(out);
 * The OpenSearch Contributors require contributions made to
                valuesSource,
        Aggregator parent,
 * Modifications Copyright OpenSearch Contributors. See
/*
        }
        ) throws IOException {
    @Override
 * a single unified constructor for both algos, but internally switch execution
import org.opensearch.search.aggregations.Aggregator;
                metadata
    public boolean equals(Object obj) {
     * The TDigest
            return new TDigestPercentilesAggregator(name, valuesSource, context, parent, values, compression, keyed, formatter, metadata);
            String name,
            Aggregator parent,
    ) throws IOException;
            ValuesSource valuesSource,
            boolean keyed,
 * the Apache License, Version 2.0 (the "License"); you may
            return numberOfSignificantValueDigits == other.getNumberOfSignificantValueDigits();
            );
            builder.endObject();
    ) throws IOException;
 * SPDX-License-Identifier: Apache-2.0
        }
import org.opensearch.core.common.io.stream.StreamInput;
            String name,
                valuesSource,
import java.util.Objects;
            return Objects.hash(super.hashCode(), numberOfSignificantValueDigits);
            double[] values,
     * @opensearch.internal
        @Override
            builder.startObject(getMethod().toString());
