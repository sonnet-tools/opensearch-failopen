    @Override
    }
    static final String TYPE = "histogram";
 * GitHub history for details.
        PARSER = new ObjectParser<>(HistogramValuesSourceBuilder.TYPE);
 * the Apache License, Version 2.0 (the "License"); you may
        );
    protected CompositeValuesSourceConfig innerBuild(QueryShardContext queryShardContext, ValuesSourceConfig config) throws IOException {
/**
                        CompositeValuesSourceConfig compositeValuesSourceConfig) -> {
                            bigArrays,
                        IndexReader reader,
 *
    }
    public HistogramValuesSourceBuilder interval(double interval) {
    }
     * Composite histogram supplier
                    missingBucket,
 * Modifications Copyright OpenSearch Contributors. See
    }
        return queryShardContext.getValuesSourceRegistry()
                    vs,
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;
 * ownership. Elasticsearch licenses this file to you under
 *
import org.apache.lucene.index.IndexReader;
    static {
    }
    /**
import java.util.List;
     * Returns the interval that is set on this source
    protected void doXContentBody(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        this.interval = in.readDouble();
            .getAggregator(REGISTRY_KEY, config)
                    valuesSourceConfig.format(),
                        int size,
     * Sets the interval on this source.
            boolean missingBucket,
    }
                    }
    public interface HistogramCompositeSupplier {
     * @opensearch.internal
 */
                            compositeValuesSourceConfig.missingBucket(),
        if (super.equals(obj) == false) return false;
    }
 * SPDX-License-Identifier: Apache-2.0
    @Override
 * A {@link CompositeValuesSourceBuilder} that builds a {@link HistogramValuesSource} from another numeric values source
    @FunctionalInterface
    }
        return PARSER.parse(parser, new HistogramValuesSourceBuilder(name), null);
    }
}
 * Unless required by applicable law or agreed to in writing,
        TYPE,
     */
 */
/*
    public String type() {
        PARSER.declareDouble(HistogramValuesSourceBuilder::interval, Histogram.INTERVAL_FIELD);
    @Override
    private static final ObjectParser<HistogramValuesSourceBuilder, Void> PARSER;
 * You may obtain a copy of the License at
    @Override
        out.writeDouble(interval);
import org.opensearch.search.sort.SortOrder;
                            numericValuesSource::doubleValues,
 * this file be licensed under the Apache-2.0 license or a
        CompositeValuesSourceParserHelper.declareValuesSourceFields(PARSER);
        );
        super(name);
     **/
 * software distributed under the License is distributed on an
        return interval;
        builder.register(
        if (obj == null || getClass() != obj.getClass()) return false;
import java.io.IOException;
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
    private double interval = 0;
 * using the provided interval.
            .apply(config, interval, name, script() != null, format(), missingBucket(), missingOrder(), order());
                final HistogramValuesSource vs = new HistogramValuesSource(numeric, interval);
    @Override
                    order,
        HistogramCompositeSupplier.class
    @Override
        CompositeValuesSourceConfig apply(
 */
package org.opensearch.search.aggregations.bucket.composite;
                    hasScript,
    }
    static final ValuesSourceRegistry.RegistryKey<HistogramCompositeSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
            MissingOrder missingOrder,
                return new CompositeValuesSourceConfig(
 * specific language governing permissions and limitations
        return Objects.hash(super.hashCode(), interval);
 * this work for additional information regarding copyright
 */
    /**
        if (interval <= 0) {
    protected ValuesSourceType getDefaultValuesSourceType() {
 * compatible open source license.
            SortOrder order
    public double interval() {
import java.util.Objects;
                        BigArrays bigArrays,
 * @opensearch.internal
                    fieldType,
/*
    }
        builder.field(Histogram.INTERVAL_FIELD.getPreferredName(), interval);
 * not use this file except in compliance with the License.
                            compositeValuesSourceConfig.format(),
                    missingOrder,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.search.aggregations.support.ValuesSourceType;
/*
import java.util.function.LongConsumer;
            boolean hasScript, // probably redundant with the config, but currently we check this two different ways...
        return Objects.equals(interval, other.interval);
public class HistogramValuesSourceBuilder extends CompositeValuesSourceBuilder<HistogramValuesSourceBuilder> {
    }
                            compositeValuesSourceConfig.fieldType(),
    }
                        LongConsumer addRequestCircuitBreakerBytes,
 * The OpenSearch Contributors require contributions made to
            double interval,
 * license agreements. See the NOTICE file distributed with
        }
            String format,
                final MappedFieldType fieldType = valuesSourceConfig.fieldType();
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                ValuesSource.Numeric numeric = (ValuesSource.Numeric) valuesSourceConfig.getValuesSource();
        return TYPE;
import org.opensearch.index.mapper.MappedFieldType;
                    name,
    public static void register(ValuesSourceRegistry.Builder builder) {
            (valuesSourceConfig, interval, name, hasScript, format, missingBucket, missingOrder, order) -> {
 * under the License.
            REGISTRY_KEY,
    @Override
import org.opensearch.common.util.BigArrays;
            false
                        return new DoubleValuesSource(
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
 * KIND, either express or implied.  See the License for the
        if (this == obj) return true;
            },
 * Licensed to Elasticsearch under one or more contributor
    static HistogramValuesSourceBuilder parse(String name, XContentParser parser) throws IOException {
        super(in);
        return CoreValuesSourceType.NUMERIC;
    public int hashCode() {
                            compositeValuesSourceConfig.missingOrder(),
    protected void innerWriteTo(StreamOutput out) throws IOException {
 *
 *
            List.of(CoreValuesSourceType.DATE, CoreValuesSourceType.NUMERIC),
                );
                        );
    protected HistogramValuesSourceBuilder(StreamInput in) throws IOException {
        this.interval = interval;
     **/
    );
    }
            throw new IllegalArgumentException("[interval] must be greater than 0 for [histogram] source");
    public HistogramValuesSourceBuilder(String name) {
     *
import org.opensearch.core.xcontent.ObjectParser;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.search.aggregations.support.ValuesSource;
            ValuesSourceConfig config,
    /**
import org.opensearch.index.query.QueryShardContext;
                    (
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        return this;
            String name,
    }
    public boolean equals(Object obj) {
                            compositeValuesSourceConfig.reverseMul()
                            size,
        HistogramValuesSourceBuilder other = (HistogramValuesSourceBuilder) obj;
                        final ValuesSource.Numeric numericValuesSource = (ValuesSource.Numeric) compositeValuesSourceConfig.valuesSource();
