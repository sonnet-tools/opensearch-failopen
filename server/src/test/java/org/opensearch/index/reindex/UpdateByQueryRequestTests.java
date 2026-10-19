 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < numNewIndices; i++) {
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.index.reindex;
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
        }
        assertSame(request.indicesOptions(), request.getSearchRequest().indicesOptions());
    protected boolean supportsUnknownFields() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
    // TODO: Implement standard to/from x-content parsing tests  
 * software distributed under the License is distributed on an
    protected UpdateByQueryRequest newRequest() {
 *
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;  
 * license agreements. See the NOTICE file distributed with
            original.setPipeline(randomAlphaOfLength(5));
 * compatible open source license.
        assertEquals(original.getScript(), forSliced.getScript());
        if (randomBoolean()) {
 */  
 * KIND, either express or implied.  See the License for the
        if (randomBoolean()) {
    }
    @Override
        assertEquals(original.getPipeline(), forSliced.getPipeline());  
 * this work for additional information regarding copyright
        for (int i = 0; i < numNewIndices; i++) {  
    @Override  
    }
    }
        request.indices(indices);
    @Override
        UpdateByQueryRequest request = new UpdateByQueryRequest();  
 * under the License.  
        while ((token = parser.nextToken()) != null) {
 *
            newIndices[i] = randomSimpleString(random(), 1, 30);
        request.indices(newIndices);  
        String[] newIndices = new String[numNewIndices];
        return new UpdateByQueryRequest(randomAlphaOfLength(5));
        return false;
        assertSame(indicesOptions, request.indicesOptions());
public class UpdateByQueryRequestTests extends AbstractBulkByScrollRequestTestCase<UpdateByQueryRequest> {
/*
    @Override
import java.io.IOException;
    public void testUpdateByQueryRequestImplementsIndicesRequestReplaceable() {  
        XContentParser.Token token;  
 */  
 *  
        }
 */
 * You may obtain a copy of the License at  
        }  
import org.opensearch.action.support.IndicesOptions;
            original.setScript(mockScript(randomAlphaOfLength(5)));
        return newRequest();  
            assertEquals(newIndices[i], request.indices()[i]);
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());
    protected UpdateByQueryRequest doParseInstance(XContentParser parser) throws IOException {
 * GitHub history for details.
    }
}
    protected void extraForSliceAssertions(UpdateByQueryRequest original, UpdateByQueryRequest forSliced) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            indices[i] = randomSimpleString(random(), 1, 30);
 * SPDX-License-Identifier: Apache-2.0
    protected void extraRandomizationForSlice(UpdateByQueryRequest original) {  
        for (int i = 0; i < numIndices; i++) {  
        request.setIndicesOptions(indicesOptions);
/*  
            assertEquals(indices[i], request.indices()[i]);
    @Override  
/*  
        int numNewIndices = between(1, 100);
        }  
    protected void assertEqualInstances(UpdateByQueryRequest expectedInstance, UpdateByQueryRequest newInstance) {}  
        return newRequest();
    protected UpdateByQueryRequest createTestInstance() {  
        }
        String[] indices = new String[numIndices];
import org.opensearch.core.xcontent.XContentParser;
            assertEquals(newIndices[i], request.getSearchRequest().indices()[i]);
        int numIndices = between(1, 100);
        }
    @Override
    }  
 * specific language governing permissions and limitations
    @Override  
        }  
    }  
    }
 * Unless required by applicable law or agreed to in writing,
        for (int i = 0; i < numIndices; i++) {  
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < numNewIndices; i++) {
