import org.opensearch.action.ActionRequestValidationException;
        assertSame(indicesOptions, request.indicesOptions());
        searchRequest.indicesOptions(indicesOptions);
        assertThat(e.getMessage(), containsString("query is missing"));  
        ActionRequestValidationException e = deleteByQueryRequest.validate();  
        deleteByQueryRequest.indices("*");
    protected void extraForSliceAssertions(DeleteByQueryRequest original, DeleteByQueryRequest forSliced) {  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.IndicesOptions;  
 * ownership. Elasticsearch licenses this file to you under  
            assertEquals(newIndices[i], request.getSearchRequest().indices()[i]);  
    }
 * this file be licensed under the Apache-2.0 license or a
        int numNewIndices = between(1, 100);
import org.opensearch.action.search.SearchRequest;
    }
        SearchRequest searchRequest = new SearchRequest(indices);
        }  
        while ((token = parser.nextToken()) != null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
        DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest(searchRequest);  
        return newRequest();  
    @Override  
    @Override
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
import static org.hamcrest.Matchers.nullValue;  
    public void testValidateGivenNoQuery() {
        for (int i = 0; i < numNewIndices; i++) {
 * SPDX-License-Identifier: Apache-2.0
 *  
        SearchRequest searchRequest = new SearchRequest();
    }
    protected boolean supportsUnknownFields() {  
        DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest(searchRequest);
        int numIndices = between(1, 100);
    @Override
        return false;
        }
 * license agreements. See the NOTICE file distributed with
    @Override
        for (int i = 0; i < numNewIndices; i++) {
        for (int i = 0; i < numNewIndices; i++) {
        ActionRequestValidationException e = deleteByQueryRequest.validate();  
}  
 * Licensed to Elasticsearch under one or more contributor  
        request.indices(newIndices);
import static org.hamcrest.Matchers.containsString;  
    }  
    // TODO: Implement standard to/from x-content parsing tests
        // Nothing else to randomize
    }
/*
 * not use this file except in compliance with the License.
package org.opensearch.index.reindex;
/*  
    }  
    }
        DeleteByQueryRequest request = new DeleteByQueryRequest(searchRequest);  
        XContentParser.Token token;
        searchRequest.source().query(QueryBuilders.matchAllQuery());
 *
    @Override
 */
        SearchRequest searchRequest = new SearchRequest();
import static org.hamcrest.Matchers.not;
import java.io.IOException;
        assertThat(e, is(not(nullValue())));
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
        for (int i = 0; i < numIndices; i++) {
 * software distributed under the License is distributed on an
            assertEquals(newIndices[i], request.indices()[i]);  
        String[] newIndices = new String[numNewIndices];  
 * compatible open source license.
 * Modifications Copyright OpenSearch Contributors. See
public class DeleteByQueryRequestTests extends AbstractBulkByScrollRequestTestCase<DeleteByQueryRequest> {  
        }
        }  
    @Override
        return newRequest();
    protected DeleteByQueryRequest newRequest() {
 * specific language governing permissions and limitations
        }
        assertSame(request.indicesOptions(), request.getSearchRequest().indicesOptions());  
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
    protected void assertEqualInstances(DeleteByQueryRequest expectedInstance, DeleteByQueryRequest newInstance) {}
import org.opensearch.index.query.QueryBuilders;
 * under the License.  
/*  
 * You may obtain a copy of the License at  
            assertEquals(indices[i], request.indices()[i]);
import static org.hamcrest.Matchers.is;
 * KIND, either express or implied.  See the License for the
    protected DeleteByQueryRequest createTestInstance() {
        assertThat(e, is(nullValue()));
        for (int i = 0; i < numIndices; i++) {
        deleteByQueryRequest.indices("*");  
            indices[i] = randomSimpleString(random(), 1, 30);
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());  
    }
    protected void extraRandomizationForSlice(DeleteByQueryRequest original) {
 *
 * this work for additional information regarding copyright
            newIndices[i] = randomSimpleString(random(), 1, 30);
    public void testValidateGivenValid() {  
    public void testDeleteteByQueryRequestImplementsIndicesRequestReplaceable() {
        return new DeleteByQueryRequest(new SearchRequest(randomAlphaOfLength(5)));  
import org.opensearch.core.xcontent.XContentParser;
        // No extra assertions needed
        String[] indices = new String[numIndices];  
    }  
    @Override  
    protected DeleteByQueryRequest doParseInstance(XContentParser parser) throws IOException {
