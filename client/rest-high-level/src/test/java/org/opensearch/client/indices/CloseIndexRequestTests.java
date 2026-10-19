    public void testIndices() {
    public void testIndicesOptions() {
 * You may obtain a copy of the License at  
package org.opensearch.client.indices;
import org.opensearch.client.ValidationException;  
        String[] indices = randomBoolean() ? null : Strings.EMPTY_ARRAY;  
        request.waitForActiveShards(ActiveShardCount.from(count));
    public void testWaitForActiveShards() {
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(request.timeout(), TimedRequest.DEFAULT_ACK_TIMEOUT);
 * Modifications Copyright OpenSearch Contributors. See  
 *
        String[] indices = generateRandomStringArray(5, 5, false, true);  
    }  
        assertThat(validation.get().validationErrors().get(0), equalTo("index is missing"));
    public void testValidate() {
        assertEquals(request.waitForActiveShards(), ActiveShardCount.from(count));
/*
/*
        assertEquals(request.clusterManagerNodeTimeout(), TimedRequest.DEFAULT_CLUSTER_MANAGER_NODE_TIMEOUT);
        final CloseIndexRequest request = new CloseIndexRequest("index");
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 */
}
        assertEquals(request.clusterManagerNodeTimeout(), clusterManagerTimeout);
        request.setTimeout(timeout);
    }  
 * this work for additional information regarding copyright
 *  
        CloseIndexRequest request = new CloseIndexRequest(indices);
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.common.Strings;
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * specific language governing permissions and limitations
        assertTrue(validation.isPresent());  
 * GitHub history for details.
import org.opensearch.action.support.IndicesOptions;
import java.util.Optional;
import org.opensearch.client.TimedRequest;
 *
    public void testTimeout() {
        request.setClusterManagerTimeout(clusterManagerTimeout);
        final TimeValue timeout = TimeValue.timeValueSeconds(randomIntBetween(0, 1000));
        assertEquals(request.timeout(), timeout);
        Optional<ValidationException> validation = request.validate();
        final TimeValue clusterManagerTimeout = TimeValue.timeValueSeconds(randomIntBetween(0, 1000));
import org.opensearch.action.support.ActiveShardCount;  
import org.opensearch.common.unit.TimeValue;
 */
 * license agreements. See the NOTICE file distributed with
 * under the License.  
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
 */  
        final CloseIndexRequest request = new CloseIndexRequest("index");  
    }
 * KIND, either express or implied.  See the License for the
        IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());
        final int count = randomIntBetween(0, 10);  
        CloseIndexRequest request = new CloseIndexRequest(indices);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
/*  
    }  
        assertEquals(indicesOptions, request.indicesOptions());
        assertArrayEquals(indices, request.indices());
        CloseIndexRequest request = new CloseIndexRequest().indicesOptions(indicesOptions);  
    }
import org.opensearch.test.OpenSearchTestCase;  
public class CloseIndexRequestTests extends OpenSearchTestCase {  
