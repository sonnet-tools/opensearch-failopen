package org.opensearch.client;
/*  
import org.opensearch.action.search.SearchRequest;
        BulkResponse bulkResponse = execute(request, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);
            new IndexRequest().id("2") // will take global index  
        Iterable<SearchHit> hits = searchAll(new SearchRequest("index").routing("1"));  
        assertThat(hits, containsInAnyOrder(hasId("1"), hasId("2")));
 * this work for additional information regarding copyright
            containsInAnyOrder(
        request.pipeline("globalId");
        request.add(new IndexRequest("index").id("1").source(MediaTypeRegistry.JSON, "field", "bulk1"));
import static org.hamcrest.Matchers.containsInAnyOrder;  
        createFieldAddingPipleine("globalId", "fieldXYZ", "valueXYZ");
        request.routing("globalRouting");  
 * KIND, either express or implied.  See the License for the
        request.add(new IndexRequest("test").id("1").source(MediaTypeRegistry.JSON, "field", "bulk1"));
        Iterable<SearchHit> hits = searchAll("test");
        );
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        return bulkResponse;
import org.opensearch.action.bulk.BulkRequest;
        BulkRequest request = new BulkRequest((String) null);  
        assertThat(hits, everyItem(hasIndex("global_index")));
                .source(MediaTypeRegistry.JSON, "field", "bulk2")
        assertThat(emptyHits, is(emptyIterable()));
        request.add(new IndexRequest("index").id("1").source(MediaTypeRegistry.JSON, "field", "bulk1"));
        createIndexWithMultipleShards("index");
        assertThat(hits, containsInAnyOrder(hasId("1"), hasId("2")));
    public void testIndexGlobalAndPerRequest() throws IOException {
 * specific language governing permissions and limitations
        BulkRequest request = new BulkRequest();  
        assertThat(hits, everyItem(hasProperty(fieldFromSource("fieldXYZ"), nullValue())));
    }
import static org.hamcrest.Matchers.emptyIterable;
    public void testGlobalIndex() throws IOException {
 * software distributed under the License is distributed on an
    public void testMixPipelineOnRequestAndGlobal() throws IOException {
        request.add(new IndexRequest("test").id("1").source(MediaTypeRegistry.JSON, "field", "bulk1").setPipeline("perIndexId"));  
 * The OpenSearch Contributors require contributions made to  
        bulk(request);
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.both;
 * SPDX-License-Identifier: Apache-2.0
    }  
        Iterable<SearchHit> emptyHits = searchAll(new SearchRequest("index").routing("xxx"));  
 */
 * GitHub history for details.
        );
import static org.hamcrest.Matchers.equalTo;
 *
        assertThat(hits, everyItem(hasProperty(fieldFromSource("someNewField"), equalTo("someValue"))));  
        // tag::bulk-request-mix-pipeline  
        request.add(new IndexRequest("test").id("1")
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.  
        request.add(new IndexRequest().id("1").source(MediaTypeRegistry.JSON, "field", "bulk1"));
import static org.hamcrest.Matchers.everyItem;  
import java.io.IOException;
                both(hasId("2")).and(hasProperty(fieldFromSource("fieldXYZ"), equalTo("valueXYZ")))  
}
import java.util.function.Function;  
 * Modifications Copyright OpenSearch Contributors. See
        request.add(new IndexRequest("test").id("2")
        assertThat(hits, everyItem(hasProperty(fieldFromSource("fieldNameXYZ"), equalTo("valueXYZ"))));  
        request.pipeline("globalId");
        request.add(new IndexRequest("test").id("2").source(MediaTypeRegistry.JSON, "field", "bulk2").setPipeline("perIndexId"));
 * You may obtain a copy of the License at  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
        request.add(new IndexRequest("local_index").id("1").source(MediaTypeRegistry.JSON, "field", "bulk1"));
import org.opensearch.action.index.IndexRequest;  
        request.add(new IndexRequest("index").id("2").routing("localRouting").source(MediaTypeRegistry.JSON, "field", "bulk1"));
    }  
        return (response) -> (T) response.getSourceAsMap().get(fieldName);  
        Iterable<SearchHit> hits = searchAll(new SearchRequest("index").routing("globalRouting", "localRouting"));  
        assertThat(hits, containsInAnyOrder(hasId("1"), hasId("2")));
        request.add(new IndexRequest().id("2").source(MediaTypeRegistry.JSON, "field", "bulk2"));
 */  
    private static <T> Function<SearchHit, T> fieldFromSource(String fieldName) {
    @SuppressWarnings("unchecked")
        bulk(request);
    public void testPipelineOnRequestOverridesGlobalPipeline() throws IOException {  
        assertFalse(bulkResponse.hasFailures());  
/*
 * Licensed to Elasticsearch under one or more contributor  
    public void testGlobalRouting() throws IOException {
        createFieldAddingPipleine("perIndexId", "someNewField", "someValue");
            .source(MediaTypeRegistry.JSON, "field", "bulk1")
    @SuppressWarnings("unchecked")
    }
        Iterable<SearchHit> hits = searchAll("test");
        request.pipeline("xyz");  
        assertThat(
 *  
/*  
        // global pipeline was not applied
        bulk(request);
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.nullValue;
        Iterable<SearchHit> hits = searchAll("test");
        request.add(new IndexRequest("index").id("2").source(MediaTypeRegistry.JSON, "field", "bulk1"));
        BulkRequest request = new BulkRequest((String) null);
 * the Apache License, Version 2.0 (the "License"); you may
            .source(MediaTypeRegistry.JSON, "field", "bulk2")); // <2>  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasProperty;
    }
        BulkRequest request = new BulkRequest("global_index");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .setPipeline("perIndexId")); // <1>  
    }
        request.add(new IndexRequest("test").id("2").source(MediaTypeRegistry.JSON, "field", "bulk2"));
        createFieldAddingPipleine("xyz", "fieldNameXYZ", "valueXYZ");
        // end::bulk-request-mix-pipeline
        createFieldAddingPipleine("perIndexId", "someNewField", "someValue");
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasIndex;  
                both(hasId("1")).and(hasProperty(fieldFromSource("someNewField"), equalTo("someValue"))),
        assertThat(hits, containsInAnyOrder(both(hasId("1")).and(hasIndex("local_index")), both(hasId("2")).and(hasIndex("global_index"))));
        bulk(request);
        bulk(request);
        Iterable<SearchHit> hits = searchAll("global_index");  
            )
    }
    public void testGlobalPipelineOnBulkRequest() throws IOException {  
        BulkRequest request = new BulkRequest("global_index");  
        BulkRequest request = new BulkRequest();
    }
import org.opensearch.action.bulk.BulkResponse;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        bulk(request);
        createFieldAddingPipleine("globalId", "fieldXYZ", "valueXYZ");  
            hits,  
    public void testMixLocalAndGlobalRouting() throws IOException {
        bulk(request);  
        request.routing("1");  
        request.add(
 *
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
    private BulkResponse bulk(BulkRequest request) throws IOException {
import org.opensearch.search.SearchHit;  
public class BulkRequestWithGlobalParametersIT extends OpenSearchRestHighLevelClientTestCase {
        Iterable<SearchHit> hits = searchAll("local_index", "global_index");  
    }
        BulkRequest request = new BulkRequest();
 */  
