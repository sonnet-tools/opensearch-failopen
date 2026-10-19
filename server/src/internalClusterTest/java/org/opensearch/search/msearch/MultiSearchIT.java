        refresh();  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFirstHit;
        client().prepareIndex("test").setId("2").setSource("field", "yyy").get();
        createIndex("test");
/*  
        if (randomBoolean()) {  
        }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
        for (MultiSearchResponse.Item item : response) {
            .get();  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
        }
 * compatible open source license.
        assertHitCount(response.getResponses()[1].getResponse(), 1L);
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.core.xcontent.MediaTypeRegistry;  
 * Modifications Copyright OpenSearch Contributors. See
        }  
            request.add(client().prepareSearch("test"));
import static org.hamcrest.Matchers.equalTo;  
import org.opensearch.action.search.MultiSearchResponse;
    }
/*
package org.opensearch.search.msearch;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 */  
        client().prepareIndex("test").setId("1").setSource("field", "xxx").get();
            assertHitCount(item.getResponse(), numDocs);
        }
        return Arrays.asList(
            .add(client().prepareSearch("test").setQuery(QueryBuilders.termQuery("field", "xxx")))  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        assertFirstHit(response.getResponses()[1].getResponse(), hasId("2"));
        super(staticSettings);
        ensureGreen();  
 * GitHub history for details.
 * under the License.  
        assertHitCount(response.getResponses()[2].getResponse(), 2L);
        assertFirstHit(response.getResponses()[0].getResponse(), hasId("1"));  
        indexRandomForConcurrentSearch("test");
    @ParametersFactory
        for (int i = 0; i < numSearchRequests; i++) {  
        assertHitCount(response.getResponses()[0].getResponse(), 1L);  
 * The OpenSearch Contributors require contributions made to  
        MultiSearchResponse response = client().multiSearch(request).actionGet();
            .add(client().prepareSearch("test").setQuery(QueryBuilders.termQuery("field", "yyy")))
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
        int numSearchRequests = randomIntBetween(1, 64);
        MultiSearchResponse response = client().prepareMultiSearch()
        refresh();
 * this file be licensed under the Apache-2.0 license or a
        MultiSearchRequest request = new MultiSearchRequest();
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        );
 * Unless required by applicable law or agreed to in writing,
        for (MultiSearchResponse.Item item : response) {  
        }  
 * ownership. Elasticsearch licenses this file to you under  
            .add(client().prepareSearch("test").setQuery(QueryBuilders.matchAllQuery()))
    public void testSimpleMultiSearch() throws InterruptedException {
 * software distributed under the License is distributed on an
    }  
        for (int i = 0; i < numDocs; i++) {
    }
import org.opensearch.common.settings.Settings;
    public static Collection<Object[]> parameters() {  
public class MultiSearchIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
        assertThat(response.getResponses().length, equalTo(3));
    public MultiSearchIT(Settings staticSettings) {
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
 *  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        int numDocs = randomIntBetween(0, 16);  
import org.opensearch.action.search.MultiSearchRequest;  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
            assertNoFailures(item.getResponse());
 */
    public void testSimpleMultiSearchMoreRequests() throws InterruptedException {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
 */  
            request.maxConcurrentSearchRequests(randomIntBetween(1, numSearchRequests));
}  
 *
 * not use this file except in compliance with the License.
            assertNoFailures(item.getResponse());  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
            client().prepareIndex("test").setId(Integer.toString(i)).setSource("{}", MediaTypeRegistry.JSON).get();
 * this work for additional information regarding copyright
        indexRandomForConcurrentSearch("test");
import org.opensearch.index.query.QueryBuilders;
        assertThat(response.getResponses().length, equalTo(numSearchRequests));
        createIndex("test");
 *
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collection;
import java.util.Arrays;
