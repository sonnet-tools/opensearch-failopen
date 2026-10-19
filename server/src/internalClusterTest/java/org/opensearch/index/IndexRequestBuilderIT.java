 * this work for additional information regarding copyright
import org.opensearch.core.common.bytes.BytesReference;
        Map<String, Object> map = new HashMap<>();
 * compatible open source license.
        SearchResponse searchResponse = client().prepareSearch("test").setQuery(QueryBuilders.termQuery("test_field", "foobar")).get();  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 */
import org.opensearch.action.index.IndexRequestBuilder;
        OpenSearchAssertions.assertHitCount(searchResponse, builders.length);
 * The OpenSearch Contributors require contributions made to  
public class IndexRequestBuilderIT extends OpenSearchIntegTestCase {
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
        indexRandom(true, builders);
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
    public void testSetSource() throws InterruptedException, ExecutionException {
 *
            assertThat(e.getMessage(), containsString("The number of object passed must be even but was [3]"));  
 * not use this file except in compliance with the License.
import static org.hamcrest.Matchers.containsString;
package org.opensearch.index;
import org.opensearch.test.hamcrest.OpenSearchAssertions;
            client().prepareIndex("test").setSource("{\"test_field\" : \"foobar\"}", MediaTypeRegistry.JSON),
 */  
/*  
            client().prepareIndex("test").setSource(new BytesArray("{\"test_field\" : \"foobar\"}"), MediaTypeRegistry.JSON),
        map.put("test_field", "foobar");
    public void testOddNumberOfSourceObjects() {
 * SPDX-License-Identifier: Apache-2.0
 * Modifications Copyright OpenSearch Contributors. See
        IndexRequestBuilder[] builders = new IndexRequestBuilder[] {  
        createIndex("test");  
            client().prepareIndex("test").setSource("test_field", "foobar", new Object());  
import org.opensearch.test.OpenSearchIntegTestCase;
 *
 * ownership. Elasticsearch licenses this file to you under  
            client().prepareIndex("test").setSource(map) };
 * license agreements. See the NOTICE file distributed with
 *  
import java.util.HashMap;
import org.opensearch.core.common.bytes.BytesArray;  
            client().prepareIndex("test")
import java.util.concurrent.ExecutionException;  
        }
            client().prepareIndex("test").setSource(new BytesArray("{\"test_field\" : \"foobar\"}"), MediaTypeRegistry.JSON),  
            fail("Expected IllegalArgumentException");
    }
    }
        } catch (IllegalArgumentException e) {
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
}  
 * You may obtain a copy of the License at  
import org.opensearch.action.search.SearchResponse;
        try {
                .setSource(BytesReference.toBytes(new BytesArray("{\"test_field\" : \"foobar\"}")), MediaTypeRegistry.JSON),  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
/*  
import org.opensearch.index.query.QueryBuilders;  
            client().prepareIndex("test").setSource("test_field", "foobar"),
import org.opensearch.core.xcontent.MediaTypeRegistry;
/*
