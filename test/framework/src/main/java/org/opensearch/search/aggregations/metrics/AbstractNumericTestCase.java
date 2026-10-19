 * Unless required by applicable law or agreed to in writing,
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        // buckets computed.. the empty bucket is the one associated with key "1". then each test will have
    public void testMultiValuedFieldWithValueScriptWithParams() throws Exception {}
 * under the License.  
    }  
        );
 *
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        createIndex("idx_unmapped");
    @Override
        }  
    public static Collection<Object[]> parameters() {  
    }  
    public void testSingleValuedField() throws Exception {}  
    public void testUnmapped() throws Exception {}
        for (int i = 0; i < numDocs; i++) { // TODO randomize the size and the params in here?  
    public void testSingleValuedFieldWithValueScript() throws Exception {}  
 */  
    public void testSingleValuedFieldPartiallyUnmapped() throws Exception {}
 * Licensed to Elasticsearch under one or more contributor  
    @ParametersFactory
/*
    public void testOrderByEmptyAggregation() throws Exception {}  
        ensureSearchable();
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
    public void testScriptMultiValued() throws Exception {}
    public AbstractNumericTestCase(Settings staticSettings) {
 * Modifications Copyright OpenSearch Contributors. See  
                            .startArray("values")
        builders = new ArrayList<>();
                client().prepareIndex("idx")
 * specific language governing permissions and limitations
    public void testScriptSingleValuedWithParams() throws Exception {}  
}
    public void testMultiValuedFieldWithValueScript() throws Exception {}  
                            .field("value", i + 1)  
        minValue = 1;  
    public void testSingleValuedFieldGetProperty() throws Exception {}
        return Arrays.asList(
                            .value(i + 2)
            builders.add(
public abstract class AbstractNumericTestCase extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
        indexRandom(true, builders);
 * SPDX-License-Identifier: Apache-2.0
import java.util.ArrayList;
        prepareCreate("empty_bucket_idx").setMapping("value", "type=integer").execute().actionGet();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
 * The OpenSearch Contributors require contributions made to  
    public void testSingleValuedFieldWithValueScriptWithParams() throws Exception {}
        maxValue = numDocs;
import org.opensearch.action.index.IndexRequestBuilder;
 * ownership. Elasticsearch licenses this file to you under  
                    .setId(String.valueOf(i))  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
    public void testScriptSingleValued() throws Exception {}
 * GitHub history for details.
    public void testMultiValuedField() throws Exception {}
        indexRandom(true, builders);
/*  
        for (int i = 0; i < 2; i++) {  
    public void testEmptyAggregation() throws Exception {}
        // two docs {value: 0} and {value : 2}, then building a histogram agg with interval 1 and with empty
/*
        // to check that this bucket exists with the appropriate sub aggregations.  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        maxValues = numDocs + 2;  
 * this file be licensed under the Apache-2.0 license or a
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final int numDocs = 10;
package org.opensearch.search.aggregations.metrics;
                            .value(i + 3)  
@OpenSearchIntegTestCase.SuiteScopeTestCase  
 * software distributed under the License is distributed on an
                    )  
import org.opensearch.test.OpenSearchIntegTestCase;
                            .endArray()
 * the Apache License, Version 2.0 (the "License"); you may
    }
            );
import java.util.Arrays;
import org.opensearch.common.settings.Settings;  
        }
                    .setSource(
        minValues = 2;
 *  
                client().prepareIndex("empty_bucket_idx")
 *
    public void testScriptMultiValuedWithParams() throws Exception {}
 * license agreements. See the NOTICE file distributed with
            );
                        jsonBuilder().startObject()
 * KIND, either express or implied.  See the License for the
                    .setId(String.valueOf(i))  
        // creating an index to test the empty buckets functionality. The way it works is by indexing  
import java.util.Collection;  
        super(staticSettings);
    public void setupSuiteScopeCluster() throws Exception {
                    .setSource(jsonBuilder().startObject().field("value", i * 2).endObject())
 * compatible open source license.
 */
            builders.add(
 * You may obtain a copy of the License at  
        createIndex("idx");  
                            .endObject()
    protected static long minValue, maxValue, minValues, maxValues;
        List<IndexRequestBuilder> builders = new ArrayList<>();  
import java.util.List;
 * not use this file except in compliance with the License.
