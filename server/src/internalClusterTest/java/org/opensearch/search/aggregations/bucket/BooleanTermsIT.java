                    break;  
package org.opensearch.search.aggregations.bucket;
    static int numSingleTrues, numSingleFalses, numMultiTrues, numMultiFalses;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
 *  
                    break;
        final int numDocs = randomInt(5);  
                    numMultiFalses++;  
 * under the License.  
                    multiValue = new boolean[] { true };
 * license agreements. See the NOTICE file distributed with
        assertThat(terms, notNullValue());
    public BooleanTermsIT(Settings dynamicSettings) {
 * specific language governing permissions and limitations
                    jsonBuilder().startObject()
        final int bucketCount = numSingleFalses > 0 && numSingleTrues > 0 ? 2 : numSingleFalses + numSingleTrues > 0 ? 1 : 0;  
        if (numMultiTrues == 0) {  
                    break;
        }  
            assertEquals("false", bucket.getKeyAsString());  
public class BooleanTermsIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {  
                    multiValue = new boolean[0];  
            )
    }
        assertSearchResponse(response);  
        assertThat(terms.getName(), equalTo("terms"));
        return Arrays.asList(
 * The OpenSearch Contributors require contributions made to  
    public void setupSuiteScopeCluster() throws Exception {
import static org.hamcrest.core.IsNull.notNullValue;  
        if (numSingleTrues == 0) {
    public static Collection<Object[]> parameters() {  
/*
 * You may obtain a copy of the License at  
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
            assertEquals(numMultiTrues, bucket.getDocCount());
            .addAggregation(terms("terms").field(MULTI_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))  
        final int bucketCount = numMultiFalses > 0 && numMultiTrues > 0 ? 2 : numMultiFalses + numMultiTrues > 0 ? 1 : 0;
            assertEquals("true", bucket.getKeyAsString());  
        Terms terms = response.getAggregations().get("terms");  
@OpenSearchIntegTestCase.SuiteScopeTestCase
                );  
        }  
        } else {
import org.opensearch.action.index.IndexRequestBuilder;
                default:  
            assertEquals(numSingleTrues, bucket.getDocCount());
            final boolean singleValue = randomBoolean();  
    public void testUnmapped() throws Exception {  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final String SINGLE_VALUED_FIELD_NAME = "b_value";
            assertEquals("true", bucket.getKeyAsString());
                        .field(SINGLE_VALUED_FIELD_NAME, singleValue)  
import java.util.Arrays;
        Terms terms = response.getAggregations().get("terms");  
                    throw new AssertionError();
    }
import static org.hamcrest.Matchers.equalTo;
            assertNull(bucket);
 * ownership. Elasticsearch licenses this file to you under  
 *
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
        }
        assertThat(terms.getName(), equalTo("terms"));
                case 0:
            assertNotNull(bucket);  
 * compatible open source license.
            assertEquals(numSingleFalses, bucket.getDocCount());
 * SPDX-License-Identifier: Apache-2.0
            .addAggregation(
            if (singleValue) {
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
 * this file be licensed under the Apache-2.0 license or a
        } else {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        );
            assertNull(bucket);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
    }  
        if (numMultiFalses == 0) {  
            assertEquals("false", bucket.getKeyAsString());
/*
            switch (randomInt(3)) {
    }
                        .endObject()
        super(dynamicSettings);
                numSingleFalses++;
/*  
        bucket = terms.getBucketByKey("true");  
        bucket = terms.getBucketByKey("true");
    @Override
        }
        assertThat(terms, notNullValue());
            assertNull(bucket);
        Terms terms = response.getAggregations().get("terms");
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
        assertThat(terms.getName(), equalTo("terms"));
        indexRandom(true, builders);
 *    http://www.apache.org/licenses/LICENSE-2.0
            final boolean[] multiValue;  
        ensureSearchable();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                    break;
                case 3:
            .get();
    public void testMultiValueField() throws Exception {
                    numMultiTrues++;  
            .addAggregation(terms("terms").field(SINGLE_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))
 * the Apache License, Version 2.0 (the "License"); you may
                    multiValue = new boolean[] { false, true };
    }  
            }
        Terms.Bucket bucket = terms.getBucketByKey("false");  
 * KIND, either express or implied.  See the License for the
        if (numSingleFalses == 0) {
import static org.opensearch.search.aggregations.AggregationBuilders.terms;  
        } else {  
 */
 * Licensed to Elasticsearch under one or more contributor  
            .get();
import org.opensearch.action.search.SearchResponse;  
        assertThat(terms.getBuckets().size(), equalTo(0));  
 *
        createIndex("idx");  
        assertSearchResponse(response);
                case 2:  
                    numMultiFalses++;
        Terms.Bucket bucket = terms.getBucketByKey("false");
            } else {  
        SearchResponse response = client().prepareSearch("idx_unmapped")
                .setSource(
        createIndex("idx_unmapped");
            }
 * GitHub history for details.
            .get();
 * Unless required by applicable law or agreed to in writing,
        assertThat(terms, notNullValue());  
 * software distributed under the License is distributed on an
                terms("terms").field(SINGLE_VALUED_FIELD_NAME).size(between(1, 5)).collectMode(randomFrom(SubAggCollectionMode.values()))  
 * not use this file except in compliance with the License.
        }
 */  
import org.opensearch.common.settings.Settings;
                    multiValue = new boolean[] { false };
    public void testSingleValueField() throws Exception {
                case 1:
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
        SearchResponse response = client().prepareSearch("idx")
                    numMultiTrues++;
 * this work for additional information regarding copyright
            assertEquals(numMultiFalses, bucket.getDocCount());
import org.opensearch.search.aggregations.bucket.terms.Terms;  
        } else {  
        assertSearchResponse(response);
        SearchResponse response = client().prepareSearch("idx")  
 */
                numSingleTrues++;
import org.opensearch.test.OpenSearchIntegTestCase;
    private static final String MULTI_VALUED_FIELD_NAME = "b_values";  
 * Modifications Copyright OpenSearch Contributors. See  
import java.util.Collection;
}
            assertNotNull(bucket);
            assertNull(bucket);
        for (int i = 0; i < builders.length; i++) {
        assertThat(terms.getBuckets().size(), equalTo(bucketCount));  
                        .array(MULTI_VALUED_FIELD_NAME, multiValue)
    @ParametersFactory
            assertNotNull(bucket);  
        assertThat(terms.getBuckets().size(), equalTo(bucketCount));
            builders[i] = client().prepareIndex("idx")  
            assertNotNull(bucket);
