 * compatible open source license.
    }
        builder.field(MULTIVALUE_MODE_FIELD.getPreferredName(), multiValueMode);
    @Override
            this.multiValueMode = in.readEnum(MultiValueMode.class);
    protected MatrixStatsAggregatorFactory innerBuild(  
    }  
    }
        super(in);
        MatrixStatsAggregationBuilder clone,  
    public MatrixStatsAggregationBuilder(String name) {
    ) throws IOException {
    public String getType() {
        if (obj == null || getClass() != obj.getClass()) return false;
        this.multiValueMode = clone.multiValueMode;
import java.util.Objects;  
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
    @Override
        if (this == obj) return true;
    private MultiValueMode multiValueMode = MultiValueMode.AVG;
    public MatrixStatsAggregationBuilder(StreamInput in) throws IOException {
        super(name);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return new MatrixStatsAggregationBuilder(this, factoriesBuilder, metadata);
    }
        QueryShardContext queryShardContext,
 * software distributed under the License is distributed on an
        AggregatorFactories.Builder factoriesBuilder,
 */
 * not use this file except in compliance with the License.
    @Override  
 *  
/*
    /**
import org.opensearch.search.MultiValueMode;  
        super(clone, factoriesBuilder, metadata);
        return NAME;
    }  
 * The OpenSearch Contributors require contributions made to  
        }
 */
 *
import org.opensearch.search.aggregations.AggregatorFactories;
import java.util.Map;
    ) {  
/*
        if (in.getVersion().onOrAfter(Version.V_3_1_0)) {  
        return builder;  
        AggregatorFactory parent,  
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.Version;  
    }  
        Map<String, ValuesSourceConfig> configs,
 * Unless required by applicable law or agreed to in writing,
 */  
    protected AggregationBuilder shallowCopy(AggregatorFactories.Builder factoriesBuilder, Map<String, Object> metadata) {  
    public int hashCode() {  
public class MatrixStatsAggregationBuilder extends ArrayValuesSourceAggregationBuilder.LeafOnly<MatrixStatsAggregationBuilder> {
 * You may obtain a copy of the License at  
    }  
        return this;
        this.multiValueMode = multiValueMode;  
import org.opensearch.core.common.io.stream.StreamInput;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.query.QueryShardContext;
        AggregatorFactories.Builder subFactoriesBuilder
    }
import org.opensearch.search.aggregations.support.ValuesSourceConfig;
    public boolean equals(Object obj) {  
import org.opensearch.search.aggregations.support.ArrayValuesSourceAggregationBuilder;
        if (super.equals(obj) == false) return false;  
    }  
 * under the License.  
     * Read from a stream.
    @Override  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
    protected MatrixStatsAggregationBuilder(
import org.opensearch.core.xcontent.ToXContent;  
 * ownership. Elasticsearch licenses this file to you under  
        return new MatrixStatsAggregatorFactory(name, configs, multiValueMode, queryShardContext, parent, subFactoriesBuilder, metadata);  
    @Override
        return Objects.hash(super.hashCode(), multiValueMode);
import org.opensearch.core.common.io.stream.StreamOutput;
 * Modifications Copyright OpenSearch Contributors. See  
    public XContentBuilder doXContentBody(XContentBuilder builder, ToXContent.Params params) throws IOException {
            out.writeEnum(multiValueMode);
    }
        }
            this.multiValueMode = MultiValueMode.AVG;  
/*  
        MatrixStatsAggregationBuilder other = (MatrixStatsAggregationBuilder) obj;
    }
 * SPDX-License-Identifier: Apache-2.0
        } else {
 * license agreements. See the NOTICE file distributed with
package org.opensearch.search.aggregations.matrix.stats;
        return multiValueMode == other.multiValueMode;
        Map<String, Object> metadata
import org.opensearch.search.aggregations.AggregationBuilder;
        if (out.getVersion().onOrAfter(Version.V_3_1_0)) {  
    public MatrixStatsAggregationBuilder multiValueMode(MultiValueMode multiValueMode) {
import org.opensearch.search.aggregations.AggregatorFactory;  
    @Override
 *
        return this.multiValueMode;
 * this file be licensed under the Apache-2.0 license or a
    }  
    @Override
    public static final String NAME = "matrix_stats";  
    protected void innerWriteTo(StreamOutput out) throws IOException {
    public MultiValueMode multiValueMode() {
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 * this work for additional information regarding copyright
     */  
}  
