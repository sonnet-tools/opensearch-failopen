        assertThat(cloneRequest.waitForNoRelocatingShards(), equalTo(originalRequest.waitForNoRelocatingShards()));
        }  
        {
        {  
            clusterHealthRequest.ensureNodeWeighedIn(true);
            ActionRequestValidationException e = clusterHealthRequest.validate();  
/*  
 * specific language governing permissions and limitations
        // null indices in ClusterHealthRequest is deserialized as empty string array
            clusterHealthRequest.local(true);
        }
        request.waitForActiveShards(randomIntBetween(0, 10));  
 * this file be licensed under the Apache-2.0 license or a
            }  
 * Licensed to Elasticsearch under one or more contributor  
 *
import org.opensearch.cluster.health.ClusterHealthStatus;  
            originalRequest.writeTo(out);
 */  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
        final ClusterHealthRequest cloneRequest;  
 * SPDX-License-Identifier: Apache-2.0
        }
 * not use this file except in compliance with the License.
import org.opensearch.test.OpenSearchTestCase;
    }
 * The OpenSearch Contributors require contributions made to  
            final String[] indices = new String[randomIntBetween(1, 10)];  
    public void testSerialize() throws Exception {
        final ClusterHealthRequest defaultRequest = new ClusterHealthRequest();  
 * Modifications Copyright OpenSearch Contributors. See
        request.waitForEvents(randomFrom(Priority.values()));
 *
            assertNull(e);
    }  
        request.waitForNoRelocatingShards(randomBoolean());
package org.opensearch.action.admin.cluster.health;
        return request;  
        final ClusterHealthRequest originalRequest = randomRequest();
            for (int i = 0; i < indices.length; i++) {
        if (randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
    private ClusterHealthRequest randomRequest() {  
import org.opensearch.common.Priority;
        assertThat(cloneRequest.waitForActiveShards(), equalTo(originalRequest.waitForActiveShards()));
 * under the License.  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
    }
        assertArrayEquals(expected != null ? expected : Strings.EMPTY_ARRAY, actual);
    private static void assertIndicesEquals(final String[] actual, final String[] expected) {  
            try (StreamInput in = out.bytes().streamInput()) {  
        assertThat(cloneRequest.waitForNodes(), equalTo(originalRequest.waitForNodes()));
import static org.hamcrest.core.IsEqual.equalTo;  
import java.util.Locale;
/*
        assertThat(cloneRequest.indicesOptions(), equalTo(originalRequest.indicesOptions()));
                indices[i] = randomAlphaOfLength(10).toLowerCase(Locale.ROOT);
import org.opensearch.action.ActionRequestValidationException;
    public void testRequestReturnsHiddenIndicesByDefault() {
            ActionRequestValidationException e = clusterHealthRequest.validate();
            clusterHealthRequest.ensureNodeWeighedIn(false);  
        assertThat(cloneRequest.waitForEvents(), equalTo(originalRequest.waitForEvents()));  
    }
        request.waitForNoInitializingShards(randomBoolean());
 * this work for additional information regarding copyright
        }  
        request.waitForNodes(randomFrom("", "<", "<=", ">", ">=") + between(0, 1000));  
 * license agreements. See the NOTICE file distributed with
        ClusterHealthRequest clusterHealthRequest = randomRequest();
 * You may obtain a copy of the License at  
        assertThat(cloneRequest.waitForStatus(), equalTo(originalRequest.waitForStatus()));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import org.opensearch.action.support.IndicesOptions;
 * software distributed under the License is distributed on an
            clusterHealthRequest.local(false);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.io.stream.StreamInput;
/*  
                cloneRequest = new ClusterHealthRequest(in);
 * KIND, either express or implied.  See the License for the
 */
        request.waitForStatus(randomFrom(ClusterHealthStatus.values()));
 *  
    public void testValidation() {
            request.indices(indices);
public class ClusterHealthRequestTests extends OpenSearchTestCase {
import org.opensearch.core.common.Strings;  
        ClusterHealthRequest request = new ClusterHealthRequest();
        assertIndicesEquals(cloneRequest.indices(), originalRequest.indices());
            }
 */  
            request.indicesOptions(IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean()));
    }  
        assertThat(cloneRequest.waitForNoInitializingShards(), equalTo(originalRequest.waitForNoInitializingShards()));  
            assertTrue(e.getMessage().contains("not a local request to ensure local node commissioned or weighed in"));
        assertTrue(defaultRequest.indicesOptions().expandWildcardsHidden());
        if (randomBoolean()) {  
            assertNotNull(e);
}
        }  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.common.io.stream.BytesStreamOutput;
