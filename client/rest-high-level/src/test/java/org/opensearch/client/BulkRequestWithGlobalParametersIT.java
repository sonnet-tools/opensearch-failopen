        request.add(new IndexRequest().id("1").source(MediaTypeRegistry.JSON, "field", "bulk1"));
    }
    }
 * Unless required by applicable law or agreed to in writing,
 *
        );
        assertThat(hits, containsInAnyOrder(hasId("1"), hasId("2")));
                both(hasId("2")).and(hasProperty(fieldFromSource("fieldXYZ"), equalTo("valueXYZ")))
        request.add(new IndexRequest("index").id("2").routing("localRouting").source(MediaTypeRegistry.JSON, "field", "bulk1"));
/*
 * You may obtain a copy of the License at
        bulk(request);
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
        createIndexWithMultipleShards("index");
import static org.hamcrest.Matchers.both;
                both(hasId("1")).and(hasProperty(fieldFromSource("someNewField"), equalTo("someValue"))),
        bulk(request);
import static org.hamcrest.Matchers.containsInAnyOrder;
        );
import org.opensearch.core.xcontent.MediaTypeRegistry;
        request.routing("1");
            containsInAnyOrder(
            hits,
    }
        request.add(new IndexRequest("test").id("2")
        return bulkResponse;
        assertThat(hits, everyItem(hasProperty(fieldFromSource("fieldXYZ"), nullValue())));
        Iterable<SearchHit> hits = searchAll("test");
            new IndexRequest().id("2") // will take global index
        assertFalse(bulkResponse.hasFailures());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasId;
        Iterable<SearchHit> hits = searchAll("test");
        BulkRequest request = new BulkRequest((String) null);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
import java.util.function.Function;
import org.opensearch.action.bulk.BulkRequest;
        request.pipeline("xyz");
        request.add(new IndexRequest().id("2").source(MediaTypeRegistry.JSON, "field", "bulk2"));
    public void testIndexGlobalAndPerRequest() throws IOException {
        bulk(request);
import org.opensearch.action.index.IndexRequest;
import static org.hamcrest.Matchers.emptyIterable;
                .source(MediaTypeRegistry.JSON, "field", "bulk2")
            .source(MediaTypeRegistry.JSON, "field", "bulk1")
 * compatible open source license.
    public void testGlobalIndex() throws IOException {
 */
        bulk(request);
        Iterable<SearchHit> hits = searchAll(new SearchRequest("index").routing("1"));
        request.routing("globalRouting");
 */
/*
        request.add(new IndexRequest("index").id("2").source(MediaTypeRegistry.JSON, "field", "bulk1"));
        Iterable<SearchHit> hits = searchAll("global_index");
        request.add(new IndexRequest("test").id("1").source(MediaTypeRegistry.JSON, "field", "bulk1"));
        // end::bulk-request-mix-pipeline
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.is;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        assertThat(
 */
        createFieldAddingPipleine("globalId", "fieldXYZ", "valueXYZ");
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasProperty;
        createFieldAddingPipleine("xyz", "fieldNameXYZ", "valueXYZ");
    public void testMixPipelineOnRequestAndGlobal() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        request.add(new IndexRequest("test").id("2").source(MediaTypeRegistry.JSON, "field", "bulk2"));
    public void testGlobalPipelineOnBulkRequest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("index").id("1").source(MediaTypeRegistry.JSON, "field", "bulk1"));
    }
    }
        assertThat(hits, containsInAnyOrder(both(hasId("1")).and(hasIndex("local_index")), both(hasId("2")).and(hasIndex("global_index"))));
        BulkRequest request = new BulkRequest("global_index");
        request.add(new IndexRequest("test").id("1").source(MediaTypeRegistry.JSON, "field", "bulk1").setPipeline("perIndexId"));
import static org.hamcrest.Matchers.nullValue;
    private static <T> Function<SearchHit, T> fieldFromSource(String fieldName) {
        // global pipeline was not applied
        request.add(new IndexRequest("test").id("2").source(MediaTypeRegistry.JSON, "field", "bulk2").setPipeline("perIndexId"));
        Iterable<SearchHit> emptyHits = searchAll(new SearchRequest("index").routing("xxx"));
        return (response) -> (T) response.getSourceAsMap().get(fieldName);
        assertThat(hits, everyItem(hasProperty(fieldFromSource("someNewField"), equalTo("someValue"))));
import static org.hamcrest.Matchers.everyItem;
 * ownership. Elasticsearch licenses this file to you under
        assertThat(hits, everyItem(hasIndex("global_index")));
        assertThat(hits, containsInAnyOrder(hasId("1"), hasId("2")));
        createFieldAddingPipleine("perIndexId", "someNewField", "someValue");
        createFieldAddingPipleine("globalId", "fieldXYZ", "valueXYZ");
        request.add(new IndexRequest("local_index").id("1").source(MediaTypeRegistry.JSON, "field", "bulk1"));
        request.add(new IndexRequest("index").id("1").source(MediaTypeRegistry.JSON, "field", "bulk1"));
        // tag::bulk-request-mix-pipeline
        Iterable<SearchHit> hits = searchAll("test");
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("test").id("1")
        BulkRequest request = new BulkRequest((String) null);
import static org.hamcrest.Matchers.equalTo;
 * Licensed to Elasticsearch under one or more contributor
    }
        BulkRequest request = new BulkRequest();
            .setPipeline("perIndexId")); // <1>
        bulk(request);
 * SPDX-License-Identifier: Apache-2.0
 * under the License.
            .source(MediaTypeRegistry.JSON, "field", "bulk2")); // <2>
            )
import org.opensearch.search.SearchHit;
package org.opensearch.client;
        bulk(request);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.hasIndex;
        request.pipeline("globalId");
 * the Apache License, Version 2.0 (the "License"); you may
        request.pipeline("globalId");
 * software distributed under the License is distributed on an
        assertThat(hits, containsInAnyOrder(hasId("1"), hasId("2")));
        BulkRequest request = new BulkRequest("global_index");
 * The OpenSearch Contributors require contributions made to
        createFieldAddingPipleine("perIndexId", "someNewField", "someValue");
    public void testPipelineOnRequestOverridesGlobalPipeline() throws IOException {
    public void testMixLocalAndGlobalRouting() throws IOException {
        BulkResponse bulkResponse = execute(request, highLevelClient()::bulk, highLevelClient()::bulkAsync, RequestOptions.DEFAULT);
/*
        Iterable<SearchHit> hits = searchAll("local_index", "global_index");
    }
        assertThat(hits, everyItem(hasProperty(fieldFromSource("fieldNameXYZ"), equalTo("valueXYZ"))));
import java.io.IOException;
        request.add(
}
 * this work for additional information regarding copyright
        assertThat(emptyHits, is(emptyIterable()));
import org.opensearch.action.bulk.BulkResponse;
public class BulkRequestWithGlobalParametersIT extends OpenSearchRestHighLevelClientTestCase {
 * GitHub history for details.
 *
import org.opensearch.action.search.SearchRequest;
        bulk(request);
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    public void testGlobalRouting() throws IOException {
        Iterable<SearchHit> hits = searchAll(new SearchRequest("index").routing("globalRouting", "localRouting"));
    @SuppressWarnings("unchecked")
    @SuppressWarnings("unchecked")
    private BulkResponse bulk(BulkRequest request) throws IOException {
