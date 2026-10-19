                            compositeValuesSourceConfig.format(),
                                compositeValuesSourceConfig.fieldType(),  
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
                            addRequestCircuitBreakerBytes,
     * @opensearch.internal
                        final ValuesSource.Numeric vs = (ValuesSource.Numeric) compositeValuesSourceConfig.valuesSource();
                        } else {
                                compositeValuesSourceConfig.format(),
    );  
 * specific language governing permissions and limitations
                            bigArrays,
                    docValueFormat,
 *  
                        );
                                compositeValuesSourceConfig.fieldType(),
                    LongConsumer addRequestCircuitBreakerBytes,
 * this work for additional information regarding copyright
    }
                            compositeValuesSourceConfig.fieldType(),  
                                rounding,  
    }
    protected ValuesSourceType getDefaultValuesSourceType() {
 * software distributed under the License is distributed on an
                                compositeValuesSourceConfig.missingBucket(),  
                    valuesSourceConfig.getValuesSource(),
                            compositeValuesSourceConfig.format(),
                } else {
                            return new UnsignedLongValuesSource(
    }
                            compositeValuesSourceConfig.reverseMul()  
            List.of(CoreValuesSourceType.BYTES, CoreValuesSourceType.IP),
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.script.Script;
                            vs::bytesValues,
                hasScript,
                name,
        builder.register(  
 */
            String format,
                    docValueFormat = valuesSourceConfig.format();
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
                                compositeValuesSourceConfig.missingBucket(),
    static TermsValuesSourceBuilder parse(String name, XContentParser parser) throws IOException {
    static void register(ValuesSourceRegistry.Builder builder) {
 * Modifications Copyright OpenSearch Contributors. See
 */  
                            rounding = LongUnaryOperator.identity();
            boolean missingBucket,
                    docValueFormat = DocValueFormat.RAW;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                                compositeValuesSourceConfig.missingBucket(),  
                    CompositeValuesSourceConfig compositeValuesSourceConfig) -> {
        );
 *
                    hasScript,  
                        }
                                bigArrays,
                    if (valuesSourceConfig.hasGlobalOrdinals() && reader instanceof DirectoryReader) {
            REGISTRY_KEY,
import org.opensearch.core.xcontent.XContentBuilder;
                                vs::longValues,
        builder.register(
            ),
        );  
import org.opensearch.search.sort.SortOrder;  
                            );  
                        int size,
    private static final ObjectParser<TermsValuesSourceBuilder, Void> PARSER;
                        ValuesSource.Bytes vs = (ValuesSource.Bytes) compositeValuesSourceConfig.valuesSource();
                order,
import org.opensearch.search.aggregations.bucket.missing.MissingOrder;  
            .apply(config, name, script() != null, format(), missingBucket(), missingOrder(), order());  
        super(in);
 *
        super(name);
 * under the License.  
import org.opensearch.search.aggregations.support.ValuesSource;
 * not use this file except in compliance with the License.
                            compositeValuesSourceConfig.missingOrder(),  
 * The OpenSearch Contributors require contributions made to  
                final DocValueFormat docValueFormat;  
    public String type() {  
                    order,  
        PARSER = new ObjectParser<>(TermsValuesSourceBuilder.TYPE);
/*
                );
                                compositeValuesSourceConfig.missingOrder(),
/**
                            size,
            false  
                valuesSourceConfig.fieldType(),
    public TermsValuesSourceBuilder(String name) {  
    }  
                    } else {
        TYPE,
                            );
                    missingBucket,
import org.opensearch.index.query.QueryShardContext;  
 * Licensed to Elasticsearch under one or more contributor  
 */  
     *
                            compositeValuesSourceConfig.reverseMul()
 * SPDX-License-Identifier: Apache-2.0
                            bigArrays,
            (valuesSourceConfig, name, hasScript, format, missingBucket, missingOrder, order) -> {
        return TYPE;
                missingOrder,
                        return new BinaryValuesSource(  
        TermsCompositeSupplier.class
                    IndexReader reader,
                if (format == null && valuesSourceConfig.valueSourceType() == CoreValuesSourceType.DATE) {
        CompositeValuesSourceConfig apply(  
                                compositeValuesSourceConfig.format(),
                    }  
            .getAggregator(REGISTRY_KEY, config)
                    BigArrays bigArrays,
            List.of(CoreValuesSourceType.DATE, CoreValuesSourceType.NUMERIC, CoreValuesSourceType.BOOLEAN),
        );
                                compositeValuesSourceConfig.missingOrder(),
import java.util.function.LongUnaryOperator;
    }
                    // defaults to the raw format on date fields (preserve timestamp as longs).
                        LongConsumer addRequestCircuitBreakerBytes,
                                bigArrays,
 * @opensearch.internal
                        if (vs.isFloatingPoint()) {  
 * Unless required by applicable law or agreed to in writing,
    @Override
import java.util.List;  
                                compositeValuesSourceConfig.missingOrder(),  
    @Override
                                compositeValuesSourceConfig.fieldType(),  
                        CompositeValuesSourceConfig compositeValuesSourceConfig) -> {  
                        ValuesSource.Bytes.WithOrdinals vs = (ValuesSource.Bytes.WithOrdinals) compositeValuesSourceConfig.valuesSource();
 * GitHub history for details.
                valuesSourceConfig.getValuesSource(),  
                valuesSourceConfig.format(),
import org.opensearch.core.common.io.stream.StreamOutput;
    protected void innerWriteTo(StreamOutput out) throws IOException {}  
            REGISTRY_KEY,  
    static final String TYPE = "terms";
                                bigArrays,  
                }  
    protected CompositeValuesSourceConfig innerBuild(QueryShardContext queryShardContext, ValuesSourceConfig config) throws IOException {  
                            );
 * A {@link CompositeValuesSourceBuilder} that builds a {@link ValuesSource} from a {@link Script} or
import org.opensearch.core.xcontent.XContentParser;
            (valuesSourceConfig, name, hasScript, format, missingBucket, missingOrder, order) -> new CompositeValuesSourceConfig(  
            ValuesSourceConfig config,
    @Override  
    }  
                        IndexReader reader,  
            SortOrder order
import org.opensearch.core.xcontent.ObjectParser;  
                            size,
                                vs::longValues,
            boolean hasScript, // probably redundant with the config, but currently we check this two different ways...  
    protected void doXContentBody(XContentBuilder builder, Params params) throws IOException {}  
     * Composite supplier for terms  
                (  
                            compositeValuesSourceConfig.missingOrder(),
                                size,
                            vs::globalOrdinalsValues,  
                                compositeValuesSourceConfig.reverseMul()  
                            return new DoubleValuesSource(
                            return new LongValuesSource(
import org.opensearch.search.DocValueFormat;
import java.util.function.LongConsumer;
        return PARSER.parse(parser, new TermsValuesSourceBuilder(name), null);  
                                compositeValuesSourceConfig.format(),
    @Override
                            compositeValuesSourceConfig.missingBucket(),
import org.opensearch.search.aggregations.support.ValuesSourceConfig;  
 * compatible open source license.
                    }
import org.opensearch.search.aggregations.support.ValuesSourceType;
    public interface TermsCompositeSupplier {
    }  
    static final ValuesSourceRegistry.RegistryKey<TermsCompositeSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(  
    }
                        BigArrays bigArrays,
        return CoreValuesSourceType.BYTES;
            false
                missingBucket,  
    static {  
public class TermsValuesSourceBuilder extends CompositeValuesSourceBuilder<TermsValuesSourceBuilder> {
import org.opensearch.common.util.BigArrays;  
/*  
                    missingOrder,
package org.opensearch.search.aggregations.bucket.composite;
 * this file be licensed under the Apache-2.0 license or a
                                size,
 * KIND, either express or implied.  See the License for the
     */  
 * the Apache License, Version 2.0 (the "License"); you may
                            compositeValuesSourceConfig.missingBucket(),  
 * ownership. Elasticsearch licenses this file to you under  
            MissingOrder missingOrder,  
                    name,
    /**
                return new CompositeValuesSourceConfig(
    protected TermsValuesSourceBuilder(StreamInput in) throws IOException {
 * a field name.  
                            final LongUnaryOperator rounding;  
 *
                                compositeValuesSourceConfig.reverseMul()
                                compositeValuesSourceConfig.reverseMul()  
 */  
 * license agreements. See the NOTICE file distributed with
                }  
                                vs::doubleValues,
                        } else if (vs.isBigInteger()) {  
/*  
    @Override
    @FunctionalInterface
                                size,
                        );  
            },
                    int size,  
        CompositeValuesSourceParserHelper.declareValuesSourceFields(PARSER);
}
            String name,
    }  
        return queryShardContext.getValuesSourceRegistry()
import org.apache.lucene.index.IndexReader;
                        return new GlobalOrdinalValuesSource(  
                    (
                    valuesSourceConfig.fieldType(),  
import org.opensearch.core.common.io.stream.StreamInput;
                            compositeValuesSourceConfig.fieldType(),
import java.io.IOException;
 * You may obtain a copy of the License at  
import org.apache.lucene.index.DirectoryReader;
