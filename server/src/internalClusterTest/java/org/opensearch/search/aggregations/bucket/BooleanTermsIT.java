        } else {
                .setSource(
        );
                    jsonBuilder().startObject()
            assertEquals(numSingleTrues, bucket.getDocCount());
                    numMultiFalses++;
 * You may obtain a copy of the License at
        Terms terms = response.getAggregations().get("terms");
                numSingleFalses++;
        assertThat(terms, notNullValue());
    public BooleanTermsIT(Settings dynamicSettings) {
        assertSearchResponse(response);
                    break;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 */
        Terms.Bucket bucket = terms.getBucketByKey("false");
                );
 *
        assertThat(terms.getName(), equalTo("terms"));
        final int bucketCount = numMultiFalses > 0 && numMultiTrues > 0 ? 2 : numMultiFalses + numMultiTrues > 0 ? 1 : 0;
package org.opensearch.search.aggregations.bucket;
    }
import org.opensearch.common.settings.Settings;
        }
        }
        SearchResponse response = client().prepareSearch("idx")
            assertEquals("true", bucket.getKeyAsString());
        bucket = terms.getBucketByKey("true");
            assertEquals(numSingleFalses, bucket.getDocCount());
                    multiValue = new boolean[0];
                    throw new AssertionError();
        final int bucketCount = numSingleFalses > 0 && numSingleTrues > 0 ? 2 : numSingleFalses + numSingleTrues > 0 ? 1 : 0;
                        .endObject()
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        } else {
    static int numSingleTrues, numSingleFalses, numMultiTrues, numMultiFalses;
        indexRandom(true, builders);
    public void setupSuiteScopeCluster() throws Exception {
                case 3:
    private static final String SINGLE_VALUED_FIELD_NAME = "b_value";
        } else {
        SearchResponse response = client().prepareSearch("idx_unmapped")
    }
    @Override
        IndexRequestBuilder[] builders = new IndexRequestBuilder[numDocs];
 * under the License.
        Terms terms = response.getAggregations().get("terms");
        assertThat(terms.getBuckets().size(), equalTo(bucketCount));
    }
public class BooleanTermsIT extends ParameterizedDynamicSettingsOpenSearchIntegTestCase {
                    break;
        Terms.Bucket bucket = terms.getBucketByKey("false");
                    numMultiTrues++;
        }
        Terms terms = response.getAggregations().get("terms");
 * GitHub history for details.
            final boolean[] multiValue;
import org.opensearch.search.aggregations.bucket.terms.Terms;
import org.opensearch.test.ParameterizedDynamicSettingsOpenSearchIntegTestCase;
import static org.hamcrest.Matchers.equalTo;
                case 0:
 * The OpenSearch Contributors require contributions made to
 * software distributed under the License is distributed on an
        }
        assertThat(terms.getName(), equalTo("terms"));
                numSingleTrues++;
 * this work for additional information regarding copyright
 * Modifications Copyright OpenSearch Contributors. See
            )
    public void testUnmapped() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
 */
            .addAggregation(
    }
        if (numSingleFalses == 0) {
    @ParametersFactory
        assertThat(terms.getBuckets().size(), equalTo(0));
            assertEquals("true", bucket.getKeyAsString());
    public void testSingleValueField() throws Exception {
import java.util.Arrays;
                        .array(MULTI_VALUED_FIELD_NAME, multiValue)
            builders[i] = client().prepareIndex("idx")
                default:
            .get();
 * SPDX-License-Identifier: Apache-2.0
        bucket = terms.getBucketByKey("true");
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under
        ensureSearchable();
/*
 */
}
            switch (randomInt(3)) {
            } else {
                case 2:
                    numMultiTrues++;
        assertThat(terms.getName(), equalTo("terms"));
 * Unless required by applicable law or agreed to in writing,
        createIndex("idx_unmapped");
 *    http://www.apache.org/licenses/LICENSE-2.0
    private static final String MULTI_VALUED_FIELD_NAME = "b_values";
import org.opensearch.action.search.SearchResponse;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
            assertNotNull(bucket);
        } else {
import org.opensearch.action.index.IndexRequestBuilder;
            }
            .addAggregation(terms("terms").field(SINGLE_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))
            assertNotNull(bucket);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        if (numMultiTrues == 0) {
        if (numSingleTrues == 0) {
        return Arrays.asList(
            final boolean singleValue = randomBoolean();
            assertEquals(numMultiTrues, bucket.getDocCount());
                terms("terms").field(SINGLE_VALUED_FIELD_NAME).size(between(1, 5)).collectMode(randomFrom(SubAggCollectionMode.values()))
        super(dynamicSettings);
            }
import org.opensearch.test.OpenSearchIntegTestCase;
                case 1:
 * Licensed to Elasticsearch under one or more contributor
                    break;
            assertNull(bucket);
/*
 *
 * license agreements. See the NOTICE file distributed with
                    multiValue = new boolean[] { false };
        SearchResponse response = client().prepareSearch("idx")
import static org.opensearch.search.aggregations.AggregationBuilders.terms;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
                        .field(SINGLE_VALUED_FIELD_NAME, singleValue)
            assertNotNull(bucket);
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
/*
                    break;
        assertSearchResponse(response);
 * compatible open source license.
            assertEquals(numMultiFalses, bucket.getDocCount());
            assertNull(bucket);
        }
            .get();
    }
    }
 *
                    multiValue = new boolean[] { false, true };
        assertSearchResponse(response);
    public static Collection<Object[]> parameters() {
        assertThat(terms, notNullValue());
        assertThat(terms.getBuckets().size(), equalTo(bucketCount));
            .get();
        createIndex("idx");
 * not use this file except in compliance with the License.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
            assertNull(bucket);
@OpenSearchIntegTestCase.SuiteScopeTestCase
            .addAggregation(terms("terms").field(MULTI_VALUED_FIELD_NAME).collectMode(randomFrom(SubAggCollectionMode.values())))
import static org.hamcrest.core.IsNull.notNullValue;
            assertNotNull(bucket);
import org.opensearch.search.aggregations.Aggregator.SubAggCollectionMode;
import java.util.Collection;
    public void testMultiValueField() throws Exception {
        final int numDocs = randomInt(5);
            assertNull(bucket);
            if (singleValue) {
        assertThat(terms, notNullValue());
                    numMultiFalses++;
            assertEquals("false", bucket.getKeyAsString());
        for (int i = 0; i < builders.length; i++) {
                    multiValue = new boolean[] { true };
        if (numMultiFalses == 0) {
            assertEquals("false", bucket.getKeyAsString());
