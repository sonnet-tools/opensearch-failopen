    );  
    public HistogramValuesSourceBuilder interval(double interval) {
            (valuesSourceConfig, interval, name, hasScript, format, missingBucket, missingOrder, order) -> {
        if (super.equals(obj) == false) return false;  
    static final String TYPE = "histogram";
        if (this == obj) return true;
                        CompositeValuesSourceConfig compositeValuesSourceConfig) -> {
 * using the provided interval.
            .getAggregator(REGISTRY_KEY, config)  
/*  
                            compositeValuesSourceConfig.missingBucket(),  
     **/
                        final ValuesSource.Numeric numericValuesSource = (ValuesSource.Numeric) compositeValuesSourceConfig.valuesSource();  
    static {  
                            compositeValuesSourceConfig.missingOrder(),
        PARSER = new ObjectParser<>(HistogramValuesSourceBuilder.TYPE);
                    missingOrder,
    public HistogramValuesSourceBuilder(String name) {
     * Sets the interval on this source.  
    protected void innerWriteTo(StreamOutput out) throws IOException {  
        if (obj == null || getClass() != obj.getClass()) return false;
    }
/*
 */  
                    (  
    /**
        );  
    protected ValuesSourceType getDefaultValuesSourceType() {
    }
    /**
 */  
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    private static final ObjectParser<HistogramValuesSourceBuilder, Void> PARSER;
import org.opensearch.core.xcontent.XContentBuilder;  
                    order,
        builder.register(
    @Override
 *  
        CompositeValuesSourceConfig apply(
import java.util.List;
 */
    }
    @Override
/**  
            throw new IllegalArgumentException("[interval] must be greater than 0 for [histogram] source");
                    vs,  
     * Returns the interval that is set on this source
import org.opensearch.search.sort.SortOrder;
    @Override
     *  
 * The OpenSearch Contributors require contributions made to  
    protected HistogramValuesSourceBuilder(StreamInput in) throws IOException {  
    }
import org.opensearch.core.common.io.stream.StreamInput;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    static HistogramValuesSourceBuilder parse(String name, XContentParser parser) throws IOException {  
    protected void doXContentBody(XContentBuilder builder, Params params) throws IOException {
        return interval;
        this.interval = interval;  
import java.util.function.LongConsumer;
}  
    public boolean equals(Object obj) {  
            ValuesSourceConfig config,  
import java.util.Objects;  
 * @opensearch.internal
    }  
            String format,
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 *
        if (interval <= 0) {  
        return TYPE;
                final HistogramValuesSource vs = new HistogramValuesSource(numeric, interval);
import org.opensearch.index.query.QueryShardContext;  
                            size,
                return new CompositeValuesSourceConfig(  
        }
 * A {@link CompositeValuesSourceBuilder} that builds a {@link HistogramValuesSource} from another numeric values source
                        BigArrays bigArrays,
 */
    }
import org.opensearch.core.xcontent.ObjectParser;
            SortOrder order
                            compositeValuesSourceConfig.fieldType(),  
        builder.field(Histogram.INTERVAL_FIELD.getPreferredName(), interval);  
import org.opensearch.core.common.io.stream.StreamOutput;
            boolean missingBucket,
    }  
    }
                        IndexReader reader,
                    valuesSourceConfig.format(),
            List.of(CoreValuesSourceType.DATE, CoreValuesSourceType.NUMERIC),
 * SPDX-License-Identifier: Apache-2.0
                            numericValuesSource::doubleValues,
    public int hashCode() {
                    name,
import org.opensearch.search.aggregations.support.ValuesSource;
        return Objects.equals(interval, other.interval);
            false
                        int size,  
                        return new DoubleValuesSource(
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
 *  
    }
                        LongConsumer addRequestCircuitBreakerBytes,
    public double interval() {
import org.opensearch.search.aggregations.support.ValuesSourceType;
    }
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;  
        return Objects.hash(super.hashCode(), interval);
    /**
    private double interval = 0;  
                    hasScript,
                            compositeValuesSourceConfig.reverseMul()  
    }
    @FunctionalInterface  
            String name,
    @Override
        CompositeValuesSourceParserHelper.declareValuesSourceFields(PARSER);  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search.aggregations.bucket.composite;
        PARSER.declareDouble(HistogramValuesSourceBuilder::interval, Histogram.INTERVAL_FIELD);
        super(in);
        HistogramValuesSourceBuilder other = (HistogramValuesSourceBuilder) obj;
     * @opensearch.internal
public class HistogramValuesSourceBuilder extends CompositeValuesSourceBuilder<HistogramValuesSourceBuilder> {  
                        );
    }  
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.IndexReader;
                    }
                final MappedFieldType fieldType = valuesSourceConfig.fieldType();
    public interface HistogramCompositeSupplier {
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.aggregations.bucket.histogram.Histogram;
        return this;
                            compositeValuesSourceConfig.format(),
 * compatible open source license.
/*  
 * Unless required by applicable law or agreed to in writing,
    public String type() {  
                ValuesSource.Numeric numeric = (ValuesSource.Numeric) valuesSourceConfig.getValuesSource();  
                );  
     * Composite histogram supplier
 * GitHub history for details.
    }  
    public static void register(ValuesSourceRegistry.Builder builder) {
    }
                            bigArrays,
            double interval,
import org.opensearch.index.mapper.MappedFieldType;
            MissingOrder missingOrder,  
        HistogramCompositeSupplier.class
import java.io.IOException;
     **/  
    protected CompositeValuesSourceConfig innerBuild(QueryShardContext queryShardContext, ValuesSourceConfig config) throws IOException {
            REGISTRY_KEY,  
 * specific language governing permissions and limitations
            boolean hasScript, // probably redundant with the config, but currently we check this two different ways...  
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
        return PARSER.parse(parser, new HistogramValuesSourceBuilder(name), null);
import org.opensearch.search.aggregations.support.CoreValuesSourceType;  
 *
        );
    @Override  
        return CoreValuesSourceType.NUMERIC;  
        super(name);  
                    fieldType,
            .apply(config, interval, name, script() != null, format(), missingBucket(), missingOrder(), order());
            },
 * not use this file except in compliance with the License.
     */
    }  
 * ownership. Elasticsearch licenses this file to you under  
        out.writeDouble(interval);
import org.opensearch.common.util.BigArrays;
import org.opensearch.core.xcontent.XContentParser;
    @Override
        TYPE,
        return queryShardContext.getValuesSourceRegistry()
                    missingBucket,  
    static final ValuesSourceRegistry.RegistryKey<HistogramCompositeSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(  
        this.interval = in.readDouble();
