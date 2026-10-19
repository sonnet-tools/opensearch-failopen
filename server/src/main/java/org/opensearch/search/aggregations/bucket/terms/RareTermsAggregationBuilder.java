        return precision;
    private static final int MAX_MAX_DOC_COUNT = 100;  
public class RareTermsAggregationBuilder extends ValuesSourceAggregationBuilder<RareTermsAggregationBuilder> {
        if (maxDocCount <= 0) {
        RareTermsAggregationBuilder other = (RareTermsAggregationBuilder) obj;
    }
 * GitHub history for details.
    protected boolean serializeTargetValueType(Version version) {
    }
    @Override
            );
        // TODO review: what size cap should we put on this?  
        PARSER.declareDouble(RareTermsAggregationBuilder::setPrecision, PRECISION);
import org.opensearch.core.ParseField;
    }
     */  
 * Modifications Copyright OpenSearch Contributors. See  
     * Set the maximum document count terms should have in order to appear in  
    public BucketCardinality bucketCardinality() {  
                    + "] must be greater than 0. Found ["
        );
import java.io.IOException;
    private int maxDocCount = 1;
     */
            config,
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {
        maxDocCount = in.readVInt();  
    }  
        if (this == obj) return true;
        out.writeOptionalWriteable(includeExclude);
     * since we use a "scaling" cuckoo filter which adds more filters as required, and the overall
 * You may obtain a copy of the License at  
     */
    ) {  
    public RareTermsAggregationBuilder maxDocCount(long maxDocCount) {  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.ObjectParser;
/*
 * Unless required by applicable law or agreed to in writing,
    private static final ParseField PRECISION = new ParseField("precision");
    /**  
        PARSER.declareLong(RareTermsAggregationBuilder::maxDocCount, MAX_DOC_COUNT_FIELD_NAME);
    protected ValuesSourceRegistry.RegistryKey<?> getRegistryKey() {
 * this work for additional information regarding copyright
import org.opensearch.search.aggregations.support.ValuesSourceType;  
 * license agreements. See the NOTICE file distributed with
        }
    }
 * KIND, either express or implied.  See the License for the
        out.writeVInt(maxDocCount);
        return includeExclude;
     * more compact filters.  The default is 0.01
    ) throws IOException {
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
        RareTermsAggregatorSupplier.class  
    }
 *
        return Objects.hash(super.hashCode(), includeExclude, maxDocCount, precision);  
    }
     * Get terms to include and exclude from the aggregation results
    }
 * Aggregation Builder for rare_terms agg
    protected XContentBuilder doXContentBody(XContentBuilder builder, Params params) throws IOException {
        if (includeExclude != null) {
import org.opensearch.Version;  
    private RareTermsAggregationBuilder(
     */  
/*  
    public static void registerAggregators(ValuesSourceRegistry.Builder builder) {
    public boolean equals(Object obj) {
    }
    @Override
import org.opensearch.search.aggregations.AggregatorFactory;  
                    + "] in ["
import org.opensearch.index.query.QueryShardContext;  
 *  
        if (maxDocCount > MAX_MAX_DOC_COUNT) {
        QueryShardContext queryShardContext,  
    public static final String NAME = "rare_terms";  
        return NAME;
    public RareTermsAggregationBuilder(StreamInput in) throws IOException {  
    }
    private double precision = 0.001;
        ValuesSourceConfig config,
import org.opensearch.core.xcontent.XContentBuilder;
    public double getPrecision() {
                "["  
        Map<String, Object> metadata
import org.opensearch.core.common.io.stream.StreamInput;
        AggregatorFactory parent,
 * the Apache License, Version 2.0 (the "License"); you may
     */  
/**  
     * This value does, however, affect the overall space usage of the filter.  Coarser precisions provide
                    + MAX_DOC_COUNT_FIELD_NAME.getPreferredName()
            IncludeExclude::parseExclude,  
    }
    }
        this.includeExclude = clone.includeExclude;
            ObjectParser.ValueType.STRING_ARRAY
        AggregatorFactories.Builder subFactoriesBuilder  
 * not use this file except in compliance with the License.
    }  
     * Set terms to include and exclude from the aggregation results
    }  
            ObjectParser.ValueType.OBJECT_ARRAY_OR_STRING
 */
    }
    @Override
    protected void innerWriteTo(StreamOutput out) throws IOException {  
import org.opensearch.search.aggregations.support.ValuesSourceRegistry;
    }  
    public int hashCode() {
        return new RareTermsAggregationBuilder(this, factoriesBuilder, metadata);  
                    + maxDocCount  
            (b, v) -> b.includeExclude(IncludeExclude.merge(b.includeExclude(), v)),
import org.opensearch.search.aggregations.support.ValuesSourceAggregationBuilder;
import org.opensearch.search.aggregations.support.ValuesSourceAggregatorFactory;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.search.aggregations.AggregationBuilder;
            includeExclude.toXContent(builder, params);  
import org.opensearch.core.common.io.stream.StreamOutput;  
    public RareTermsAggregationBuilder includeExclude(IncludeExclude includeExclude) {
        RareTermsAggregationBuilder clone,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
    private static final ParseField MAX_DOC_COUNT_FIELD_NAME = new ParseField("max_doc_count");  
}
        return builder;
        builder.field(MAX_DOC_COUNT_FIELD_NAME.getPreferredName(), maxDocCount);
    @Override
        return CoreValuesSourceType.BYTES;
    /**
        this.maxDocCount = (int) maxDocCount;  
        this.precision = precision;
        RareTermsAggregationBuilder::new  
import org.opensearch.search.aggregations.AggregatorFactories;
 * @opensearch.internal  
    protected ValuesSourceType defaultValueSourceType() {  
        PARSER.declareField(
    }  
import java.util.Map;  
    static {
            parent,
 *    http://www.apache.org/licenses/LICENSE-2.0
        return Objects.equals(includeExclude, other.includeExclude)  
    }  
 * software distributed under the License is distributed on an
 * compatible open source license.
     * <p>  
        if (obj == null || getClass() != obj.getClass()) return false;  
    );
        }
    public RareTermsAggregationBuilder(String name) {
        super(clone, factoriesBuilder, metadata);
            subFactoriesBuilder,
                "[" + MAX_DOC_COUNT_FIELD_NAME.getPreferredName() + "] must be smaller" + "than " + MAX_MAX_DOC_COUNT + "in [" + name + "]"  
     * Set's the false-positive rate for individual cuckoo filters.  Does not dictate the overall fpp rate  
 * Licensed to Elasticsearch under one or more contributor  
     * error rate grows differently than individual filters
        this.includeExclude = includeExclude;
 */  
        RareTermsAggregatorFactory.registerAggregators(builder);  
        return REGISTRY_KEY;  
        builder.field(PRECISION.getPreferredName(), precision);  
 */
 * this file be licensed under the Apache-2.0 license or a
            metadata,  
                    + name
 *
     * the response.
        );  
package org.opensearch.search.aggregations.bucket.terms;
 *
    }  
    @Override  
        }
     */
    /**
    public static final ObjectParser<RareTermsAggregationBuilder, String> PARSER = ObjectParser.fromBuilder(
    @Override  
    private IncludeExclude includeExclude = null;  
        if (super.equals(obj) == false) return false;
        return true;
/*
import org.opensearch.search.aggregations.support.CoreValuesSourceType;
    }
    @Override
    /**
            IncludeExclude.EXCLUDE_FIELD,
            );
    @Override
    public IncludeExclude includeExclude() {  
    @Override
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException(
            (b, v) -> b.includeExclude(IncludeExclude.merge(v, b.includeExclude())),
            precision
    public String getType() {  
import java.util.Objects;
            IncludeExclude.INCLUDE_FIELD,  
    }  
    );
     * Get the current false positive rate for individual cuckoo filters.
    public static final ValuesSourceRegistry.RegistryKey<RareTermsAggregatorSupplier> REGISTRY_KEY = new ValuesSourceRegistry.RegistryKey<>(
    public void setPrecision(double precision) {
    @Override
            name,  
        );  
        includeExclude = in.readOptionalWriteable(IncludeExclude::new);
            throw new IllegalArgumentException("[precision] must be greater than 0.00001");  
        return this;
            includeExclude,
 */
        super(name);
        super(in);
            && Objects.equals(precision, other.precision);
        AggregatorFactories.Builder factoriesBuilder,
            && Objects.equals(maxDocCount, other.maxDocCount)
            queryShardContext,  
        return new RareTermsAggregatorFactory(
                    + "]"  
        NAME,
 * under the License.  
        NAME,
            maxDocCount,
     * Read from a stream.
        return this;  
        if (precision < 0.00001) {
        return BucketCardinality.MANY;
        ValuesSourceAggregationBuilder.declareFields(PARSER, true, true, false);  
    protected ValuesSourceAggregatorFactory innerBuild(
    /**
        }
    /**  
            throw new IllegalArgumentException(
        PARSER.declareField(  
            IncludeExclude::parseInclude,
