    }
                final CloseIndexRequest deserializedRequest;
            final CloseIndexRequest deserializedRequest;
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (randomBoolean()) {  
 * ownership. Elasticsearch licenses this file to you under  
    }
        }
import org.opensearch.action.support.IndicesOptions;  
 *  
import org.opensearch.core.common.io.stream.StreamInput;
                try (StreamInput in = out.bytes().streamInput()) {
import org.opensearch.test.VersionUtils;
            assertEquals(request.timeout(), deserializedRequest.timeout());  
        }
            assertEquals(request.clusterManagerNodeTimeout(), deserializedRequest.clusterManagerNodeTimeout());
        final CloseIndexRequest request = randomRequest();
            request.waitForActiveShards(
 */
            assertEquals(request.getParentTask(), deserializedRequest.getParentTask());  
import org.opensearch.Version;
public class CloseIndexRequestTests extends OpenSearchTestCase {
 * Modifications Copyright OpenSearch Contributors. See
        }
                assertEquals(sample.indicesOptions(), deserializedRequest.indicesOptions());
        if (randomBoolean()) {  
                    deserializedRequest = new CloseIndexRequest(in);
        CloseIndexRequest request = new CloseIndexRequest();
/*
                out.setVersion(version);
                    assertEquals(request.timeout(), in.readTimeValue());
            request.clusterManagerNodeTimeout(randomPositiveTimeValue());
                    assertArrayEquals(request.indices(), in.readStringArray());  
            final CloseIndexRequest sample = randomRequest();
            }
    }  
        }
    public void testBwcSerialization() throws Exception {  
            request.writeTo(out);  
 *
                sample.getParentTask().writeTo(out);  
 *
/*  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    private CloseIndexRequest randomRequest() {
import org.opensearch.action.support.ActiveShardCount;
import org.opensearch.test.OpenSearchTestCase;
 * The OpenSearch Contributors require contributions made to  
                    in.setVersion(out.getVersion());
                    assertEquals(request.indicesOptions(), indicesOptions);
        }
                sample.waitForActiveShards().writeTo(out);
                    assertEquals(request.waitForActiveShards(), ActiveShardCount.readFrom(in));  
 * compatible open source license.
            try (StreamInput in = out.bytes().streamInput()) {  
                assertEquals(sample.clusterManagerNodeTimeout(), deserializedRequest.clusterManagerNodeTimeout());
                try (StreamInput in = out.bytes().streamInput()) {
            );  
            assertArrayEquals(request.indices(), deserializedRequest.indices());
            }  
            final CloseIndexRequest request = randomRequest();
            request.indicesOptions(
 * Unless required by applicable law or agreed to in writing,
                out.writeStringArray(sample.indices());  
package org.opensearch.action.admin.indices.close;
        if (randomBoolean()) {  
        }
        if (randomBoolean()) {
 * GitHub history for details.
                    in.setVersion(version);  
import org.opensearch.common.io.stream.BytesStreamOutput;
 * under the License.  
                request.writeTo(out);
 * Licensed to Elasticsearch under one or more contributor  
 */  
            try (BytesStreamOutput out = new BytesStreamOutput()) {
                deserializedRequest = new CloseIndexRequest(in);
        return request;
 * the Apache License, Version 2.0 (the "License"); you may
                assertEquals(sample.waitForActiveShards(), deserializedRequest.waitForActiveShards());
    public void testSerialization() throws Exception {  
                sample.indicesOptions().writeIndicesOptions(out);
                    assertEquals(request.getParentTask(), TaskId.readFromStream(in));  
                    assertEquals(request.clusterManagerNodeTimeout(), in.readTimeValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
 * license agreements. See the NOTICE file distributed with
 * software distributed under the License is distributed on an
/*  
                assertArrayEquals(sample.indices(), deserializedRequest.indices());  
            request.timeout(randomPositiveTimeValue());
                IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())  
            request.setParentTask(randomAlphaOfLength(5), randomNonNegativeLong());
                    final IndicesOptions indicesOptions = IndicesOptions.readIndicesOptions(in);
                }
            );
                out.writeTimeValue(sample.timeout());
                }
 * You may obtain a copy of the License at  
 * this work for additional information regarding copyright
                assertEquals(sample.getParentTask(), deserializedRequest.getParentTask());  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
                out.setVersion(VersionUtils.randomCompatibleVersion(random(), Version.CURRENT));
            final Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                randomFrom(ActiveShardCount.DEFAULT, ActiveShardCount.NONE, ActiveShardCount.ONE, ActiveShardCount.ALL)
            try (BytesStreamOutput out = new BytesStreamOutput()) {  
            }
        {
            assertEquals(request.indicesOptions(), deserializedRequest.indicesOptions());
 * specific language governing permissions and limitations
}
            assertEquals(request.waitForActiveShards(), deserializedRequest.waitForActiveShards());
import org.opensearch.core.tasks.TaskId;  
        {
                assertEquals(sample.timeout(), deserializedRequest.timeout());
        if (randomBoolean()) {  
        }  
                out.writeTimeValue(sample.clusterManagerNodeTimeout());
 */  
        request.indices(generateRandomStringArray(10, 5, false, false));  
