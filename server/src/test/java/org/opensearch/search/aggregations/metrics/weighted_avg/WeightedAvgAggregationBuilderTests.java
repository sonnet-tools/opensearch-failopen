public class WeightedAvgAggregationBuilderTests extends AbstractSerializingTestCase<WeightedAvgAggregationBuilder> {
import org.opensearch.search.aggregations.AggregatorFactories;  
    public void setupName() {  
import org.opensearch.common.settings.Settings;
 * Unless required by applicable law or agreed to in writing,
    @Override
 *
    }
}
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        assertSame(XContentParser.Token.START_OBJECT, parser.nextToken());  
        return aggregationBuilder;
 * GitHub history for details.
        aggregationName = randomAlphaOfLength(10);
    }
import org.opensearch.search.aggregations.support.MultiValuesSourceFieldConfig;
            .weight(weightConfig);  
 * SPDX-License-Identifier: Apache-2.0
 */  
 * Licensed to Elasticsearch under one or more contributor  
        return new NamedXContentRegistry(searchModule.getNamedXContents());
        return agg;
 */  
    @Override
    protected NamedXContentRegistry xContentRegistry() {
    String aggregationName;  
import org.opensearch.core.xcontent.XContentParser;
    protected WeightedAvgAggregationBuilder doParseInstance(XContentParser parser) throws IOException {
        AggregatorFactories.Builder parsed = AggregatorFactories.parseAggregators(parser);
 *
        assertNotNull(agg);  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(parsed.getPipelineAggregatorFactories(), hasSize(0));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
        return WeightedAvgAggregationBuilder::new;  
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
    protected Writeable.Reader<WeightedAvgAggregationBuilder> instanceReader() {
import org.opensearch.test.AbstractSerializingTestCase;  
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.search.aggregations.metrics.weighted_avg;
    @Before
 *  
    @Override
import java.io.IOException;  
        SearchModule searchModule = new SearchModule(Settings.EMPTY, Collections.emptyList());  
        MultiValuesSourceFieldConfig weightConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("weight_field").build();
import org.opensearch.search.SearchModule;
/*  
/*  
import java.util.Collections;
    @Override
    }
        WeightedAvgAggregationBuilder aggregationBuilder = new WeightedAvgAggregationBuilder(aggregationName).value(valueConfig)
/*
 * this work for additional information regarding copyright
 * compatible open source license.
        WeightedAvgAggregationBuilder agg = (WeightedAvgAggregationBuilder) parsed.getAggregatorFactories().iterator().next();
        assertThat(parsed.getAggregatorFactories(), hasSize(1));
    }
import org.opensearch.core.xcontent.NamedXContentRegistry;  
 * Modifications Copyright OpenSearch Contributors. See
        MultiValuesSourceFieldConfig valueConfig = new MultiValuesSourceFieldConfig.Builder().setFieldName("value_field").build();  
        assertNull(parser.nextToken());
    protected WeightedAvgAggregationBuilder createTestInstance() {
    }
import org.opensearch.search.aggregations.metrics.WeightedAvgAggregationBuilder;
import static org.hamcrest.Matchers.hasSize;  
import org.junit.Before;
 * not use this file except in compliance with the License.
 */
import org.opensearch.core.common.io.stream.Writeable;
