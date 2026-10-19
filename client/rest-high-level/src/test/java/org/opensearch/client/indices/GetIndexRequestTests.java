 *
    public void testLocal() {
    public void testIndicesOptions() {
        Feature[] features = new Feature[numFeature];  
        boolean local = randomBoolean();  
        GetIndexRequest request = new GetIndexRequest(indices);  
 * software distributed under the License is distributed on an
            features[i] = randomFrom(GetIndexRequest.DEFAULT_FEATURES);
 * under the License.  
    }  
    public void testFeatures() {
 * compatible open source license.
        GetIndexRequest request = new GetIndexRequest().addFeatures(features);
        }  
 */  
        GetIndexRequest request = new GetIndexRequest().indicesOptions(indicesOptions);
 */  
 *
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    public void testIncludeDefaults() {
        GetIndexRequest request = new GetIndexRequest().humanReadable(humanReadable);
 * Unless required by applicable law or agreed to in writing,
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());  
package org.opensearch.client.indices;
        int numFeature = randomIntBetween(0, 3);
        GetIndexRequest request = new GetIndexRequest().local(local);
 * Modifications Copyright OpenSearch Contributors. See
        boolean humanReadable = randomBoolean();  
    public void testHumanReadable() {
 *  
 * KIND, either express or implied.  See the License for the
        GetIndexRequest request = new GetIndexRequest().includeDefaults(includeDefaults);
        String[] indices = generateRandomStringArray(5, 5, false, true);
}
    }  
    public void testIndices() {
 * specific language governing permissions and limitations
import org.opensearch.client.indices.GetIndexRequest.Feature;
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
import org.opensearch.test.OpenSearchTestCase;  
    }  
/*  
 * GitHub history for details.
 * You may obtain a copy of the License at  
        assertEquals(includeDefaults, request.includeDefaults());
        for (int i = 0; i < numFeature; i++) {
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        boolean includeDefaults = randomBoolean();  
        assertEquals(local, request.local());
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(indicesOptions, request.indicesOptions());
/*
    }  
        assertArrayEquals(features, request.features());
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.opensearch.action.support.IndicesOptions;
/*  
 */
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals(humanReadable, request.humanReadable());
 * not use this file except in compliance with the License.
public class GetIndexRequestTests extends OpenSearchTestCase {
        assertArrayEquals(indices, request.indices());
