                            compositeValuesSourceConfig.reverseMul()
    }
 * license agreements. See the NOTICE file distributed with
    public TermsValuesSourceBuilder(String name) {
                            compositeValuesSourceConfig.missingOrder(),
                            return new UnsignedLongValuesSource(
/*
 *
                        ValuesSource.Bytes vs = (ValuesSource.Bytes) compositeValuesSourceConfig.valuesSource();
public class TermsValuesSourceBuilder extends CompositeValuesSourceBuilder<TermsValuesSourceBuilder> {
                                compositeValuesSourceConfig.format(),
                return new CompositeValuesSourceConfig(
                                bigArrays,
                                compositeValuesSourceConfig.missingOrder(),
    @Override
import java.util.List;
import java.util.function.LongUnaryOperator;
 * A {@link CompositeValuesSourceBuilder} that builds a {@link ValuesSource} from a {@link Script} or
                                compositeValuesSourceConfig.reverseMul()
                                size,
            String name,
    }
                            bigArrays,
 *
                            addRequestCircuitBreakerBytes,
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;
                                rounding,
import org.apache.lucene.index.IndexReader;
            REGISTRY_KEY,
    static final ValuesSourceRegistry.RegistryKey<TermsCompositeSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
                    docValueFormat = DocValueFormat.RAW;
                                compositeValuesSourceConfig.missingBucket(),
        );
import org.apache.lucene.index.DirectoryReader;
    public String type() {
        TermsCompositeSupplier.class
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
import org.opensearch.core.xcontent.ObjectParser;
                    if (valuesSourceConfig.hasGlobalOrdinals() && reader instanceof DirectoryReader) {
                            compositeValuesSourceConfig.fieldType(),
                                bigArrays,
                valuesSourceConfig.fieldType(),
    static {
                name,
            MissingOrder missingOrder,
 */
import org.opensearch.search.sort.SortOrder;
 * Licensed to Elasticsearch under one or more contributor
        builder.register(
import org.opensearch.search.aggregations.support.ValuesSource;
                hasScript,
                                compositeValuesSourceConfig.format(),
                final DocValueFormat docValueFormat;
            boolean hasScript, // probably redundant with the config, but currently we check this two different ways...
                    order,
            false
                            vs::globalOrdinalsValues,
/**
                    BigArrays bigArrays,
import org.opensearch.search.DocValueFormat;
                            size,
            List.of(CoreValuesSourceType.BYTES, CoreValuesSourceType.IP),
                    }
    }
        return TYPE;
 *    http://www.apache.org/licenses/LICENSE-2.0
                                vs::doubleValues,
                                compositeValuesSourceConfig.reverseMul()
     */
        super(name);
                                compositeValuesSourceConfig.fieldType(),
import java.util.function.LongConsumer;
                        );
                            vs::bytesValues,
     * @opensearch.internal
            .getAggregator(REGISTRY_KEY, config)
                order,
 */
                    valuesSourceConfig.getValuesSource(),
 * compatible open source license.
        return PARSER.parse(parser, new TermsValuesSourceBuilder(name), null);
                );
 * this file be licensed under the Apache-2.0 license or a
        );
 * under the License.
    static final String TYPE = "terms";
        TYPE,
import java.io.IOException;
 * You may obtain a copy of the License at
                            return new LongValuesSource(
    @FunctionalInterface
 */
                    LongConsumer addRequestCircuitBreakerBytes,
                    int size,
import org.opensearch.index.query.QueryShardContext;
    public interface TermsCompositeSupplier {
                            compositeValuesSourceConfig.missingOrder(),
    static TermsValuesSourceBuilder parse(String name, XContentParser parser) throws IOException {
    }
                            final LongUnaryOperator rounding;
        super(in);
                            compositeValuesSourceConfig.missingBucket(),
 * specific language governing permissions and limitations
                                compositeValuesSourceConfig.missingBucket(),
 * Modifications Copyright OpenSearch Contributors. See
                        IndexReader reader,
                                size,
    @Override
                            compositeValuesSourceConfig.format(),
            REGISTRY_KEY,
                valuesSourceConfig.format(),
                    missingOrder,
            List.of(CoreValuesSourceType.DATE, CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN),
                    docValueFormat,
            },
 * GitHub history for details.
                    docValueFormat = valuesSourceConfig.format();
    }
                    hasScript,
                    // defaults to the raw format on date fields (preserve timestamp as longs).
package org.opensearch.search.aggregations.bucket.composite;
    protected void doXContentBody(XContentBuilder builder, Params params) throws IOException {}
    protected TermsValuesSourceBuilder(StreamInput in) throws IOException {
                    valuesSourceConfig.fieldType(),
 * not use this file except in compliance with the License.
                            );
                                compositeValuesSourceConfig.missingOrder(),
                        ValuesSource.Bytes.WithOrdinals vs = (ValuesSource.Bytes.WithOrdinals) compositeValuesSourceConfig.valuesSource();
    @Override
 * KIND, either express or implied.  See the License for the
                            );
                            rounding = LongUnaryOperator.identity();
            (valuesSourceConfig, name, hasScript, format, missingBucket, missingOrder, order) -> {
                                bigArrays,
                        final ValuesSource.Numeric vs = (ValuesSource.Numeric) compositeValuesSourceConfig.valuesSource();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                compositeValuesSourceConfig.missingOrder(),
                if (format == null && valuesSourceConfig.valueSourceType() == CoreValuesSourceType.DATE) {
                valuesSourceConfig.getValuesSource(),
                        } else if (vs.isBigInteger()) {
                                compositeValuesSourceConfig.reverseMul()
import org.opensearch.core.common.io.stream.StreamInput;
                                compositeValuesSourceConfig.fieldType(),
                } else {
                        }
                            size,
                            compositeValuesSourceConfig.format(),
 *
                }
                    (
 * a field name.
                missingBucket,
    }
import org.opensearch.common.util.BigArrays;
                (
            String format,
                            compositeValuesSourceConfig.missingBucket(),
                            );
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
                        int size,
        return queryShardContext.getValuesSourceRegistry()
            false
/*
                        } else {
     *
                            bigArrays,
    );
 * software distributed under the License is distributed on an
 * @opensearch.internal
                        return new BinaryValuesSource(
import org.opensearch.core.common.io.stream.StreamOutput;
        CompositeValuesSourceParserHelper.declareValuesSourceFields(PARSER);
    }
    protected void innerWriteTo(StreamOutput out) throws IOException {}
import org.opensearch.core.xcontent.XContentParser;
                missingOrder,
    }
     * Composite supplier for terms
 * this work for additional information regarding copyright
    @Override
                                compositeValuesSourceConfig.missingBucket(),
    protected CompositeValuesSourceConfig innerBuild(QueryShardContext queryShardContext, ValuesSourceConfig config) throws IOException {
    /**
                                vs::longValues,
    private static final ObjectParser<TermsValuesSourceBuilder, Void> PARSER;
                                compositeValuesSourceConfig.fieldType(),
                }
import org.opensearch.search.aggregations.support.ValuesSourceType;
                                vs::longValues,
            .apply(config, name, script() != null, format(), missingBucket(), missingOrder(), order());
            boolean missingBucket,
    @Override
                                size,
                                compositeValuesSourceConfig.format(),
 * The OpenSearch Contributors require contributions made to
                        if (vs.isFloatingPoint()) {
                            compositeValuesSourceConfig.fieldType(),
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
/*
                        );
                    } else {
            ValuesSourceConfig config,
                        LongConsumer addRequestCircuitBreakerBytes,
        );
        PARSER = new ObjectParser<>(TermsValuesSourceBuilder.TYPE);
        return CoreValuesSourceType.BYTES;
 * the Apache License, Version 2.0 (the "License"); you may
 *
                        CompositeValuesSourceConfig compositeValuesSourceConfig) -> {
                            return new DoubleValuesSource(
                    missingBucket,
    }
                    IndexReader reader,
        builder.register(
 */
                        return new GlobalOrdinalValuesSource(
import org.opensearch.script.Script;
                        BigArrays bigArrays,
                            compositeValuesSourceConfig.reverseMul()
            ),
    static void register(ValuesSourceRegistry.Builder builder) {
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.core.xcontent.XContentBuilder;
 * SPDX-License-Identifier: Apache-2.0
        CompositeValuesSourceConfig apply(
                    CompositeValuesSourceConfig compositeValuesSourceConfig) -> {
}
            (valuesSourceConfig, name, hasScript, format, missingBucket, missingOrder, order) -> new CompositeValuesSourceConfig(
    protected ValuesSourceType getDefaultValuesSourceType() {
                    }
                    name,
            SortOrder order
