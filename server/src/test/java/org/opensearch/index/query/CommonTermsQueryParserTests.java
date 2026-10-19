}  
 * license agreements. See the NOTICE file distributed with
 *  
 * compatible open source license.
        assertNotNull(response);  
 * specific language governing permissions and limitations
 * under the License.  
        final String index = "test-index";  
        CommonTermsQueryBuilder commonTermsQueryBuilder = new CommonTermsQueryBuilder("name", "the").queryName("query-name");
/*  
import org.opensearch.action.search.SearchResponse;
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 *
 * Unless required by applicable law or agreed to in writing,
/*  
        // the named query parses to null; we are testing this does not cause a NullPointerException  
package org.opensearch.index.query;
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchSingleNodeTestCase;
 * ownership. Elasticsearch licenses this file to you under  
 */
        assertEquals(response.getHits().getHits().length, 0);
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
        SearchResponse response = client().prepareSearch(index).setQuery(commonTermsQueryBuilder).execute().actionGet();
/*
    public void testWhenParsedQueryIsNullNoNullPointerExceptionIsThrown() {
    }
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
        ensureGreen();
 * Licensed to Elasticsearch under one or more contributor  
 *
public class CommonTermsQueryParserTests extends OpenSearchSingleNodeTestCase {
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        client().admin().indices().prepareCreate(index).setMapping("name", "type=text,analyzer=stop").execute().actionGet();
