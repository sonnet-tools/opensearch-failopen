 * Licensed to Elasticsearch under one or more contributor  
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
import org.mockito.Mockito;  
 *
 */
 * GitHub history for details.
        return new SearchRequestBuilder(client, SearchAction.INSTANCE);
        OpenSearchClient client = Mockito.mock(OpenSearchClient.class);
 * ownership. Elasticsearch licenses this file to you under  
    public void testSearchSourceBuilderToString() {
    }
 * The OpenSearch Contributors require contributions made to  
            equalTo(new SearchSourceBuilder().query(QueryBuilders.termQuery("field", "value")).toString())
}
/*
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.query.QueryBuilders;
package org.opensearch.action.search;
        searchRequestBuilder.setSource(new SearchSourceBuilder().query(QueryBuilders.termQuery("field", "value")));  
    }  
        String postToString = searchRequestBuilder.request().toString();
        String preToString = searchRequestBuilder.request().toString();
    }
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 *  
 * Unless required by applicable law or agreed to in writing,
/*  
        SearchRequestBuilder searchRequestBuilder = createBuilder().setSource(
            new SearchSourceBuilder().query(QueryBuilders.termQuery("field", "value"))  
        assertThat(searchRequestBuilder.toString(), equalTo(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()).toString()));
    private SearchRequestBuilder createBuilder() {  
 * under the License.  
    }  
        searchRequestBuilder.setQuery(QueryBuilders.matchAllQuery());  
        );
        assertThat(
    }
 * this work for additional information regarding copyright
        );  
import org.opensearch.test.OpenSearchTestCase;  
 */  
import static org.hamcrest.CoreMatchers.equalTo;
        assertThat(searchRequestBuilder.toString(), equalTo(new SearchSourceBuilder().toString()));
            searchRequestBuilder.toString(),
import org.opensearch.transport.client.OpenSearchClient;
        assertThat(  
    public void testThatToStringDoesntWipeRequestSource() {
        assertThat(preToString, equalTo(postToString));
 *
/*  
 * You may obtain a copy of the License at  
    public void testQueryBuilderQueryToString() {
        SearchRequestBuilder searchRequestBuilder = createBuilder();
public class SearchRequestBuilderTests extends OpenSearchTestCase {
    public void testEmptySourceToString() {
            equalTo(new SearchSourceBuilder().query(QueryBuilders.termQuery("field", "value")).toString())  
 */  
        );
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
        SearchRequestBuilder searchRequestBuilder = createBuilder();  
        SearchRequestBuilder searchRequestBuilder = createBuilder();
            searchRequestBuilder.toString(),
import org.opensearch.search.builder.SearchSourceBuilder;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
