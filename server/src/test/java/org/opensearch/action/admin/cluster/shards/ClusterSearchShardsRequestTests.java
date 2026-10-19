 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        }
 * Unless required by applicable law or agreed to in writing,
        try (BytesStreamOutput out = new BytesStreamOutput()) {
 * under the License.  
import org.opensearch.test.VersionUtils;  
            );
 * software distributed under the License is distributed on an
                in.setVersion(version);  
    }
 * license agreements. See the NOTICE file distributed with
 * GitHub history for details.
 */
 * SPDX-License-Identifier: Apache-2.0
            request.writeTo(out);
    public void testIndicesMustNotBeNull() {
            int numRoutings = randomIntBetween(1, 3);
 */  
        ClusterSearchShardsRequest request = new ClusterSearchShardsRequest();
        expectThrows(NullPointerException.class, () -> request.indices(new String[] { "index1", null, "index3" }));  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
}
            String[] routings = new String[numRoutings];  
import org.opensearch.Version;
import org.opensearch.action.support.IndicesOptions;
        expectThrows(NullPointerException.class, () -> request.indices((String[]) null));
        assertNotNull(request.indices());  
            int numIndices = randomIntBetween(1, 5);
 *
 * Licensed to Elasticsearch under one or more contributor  
    }
            request.routing(routings);
 * The OpenSearch Contributors require contributions made to  
        }
public class ClusterSearchShardsRequestTests extends OpenSearchTestCase {
                assertEquals(request.preference(), deserialized.preference());
 *  
        ClusterSearchShardsRequest request = new ClusterSearchShardsRequest();
        if (randomBoolean()) {  
        Version version = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
                assertArrayEquals(request.indices(), deserialized.indices());
                indices[i] = randomAlphaOfLengthBetween(3, 10);
            String[] indices = new String[numIndices];
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
import org.opensearch.common.io.stream.BytesStreamOutput;  
 * KIND, either express or implied.  See the License for the
package org.opensearch.action.admin.cluster.shards;
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
        }
        if (randomBoolean()) {
        }  
        if (randomBoolean()) {
import org.opensearch.core.common.io.stream.StreamInput;
                assertEquals(request.routing(), deserialized.routing());
        }  
                IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean())
        if (randomBoolean()) {
    public void testSerialization() throws Exception {
                assertEquals(request.indicesOptions(), deserialized.indicesOptions());  
        expectThrows(NullPointerException.class, () -> request.indices((String) null));
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
/*  
import org.opensearch.test.OpenSearchTestCase;
            request.indices(indices);  
            for (int i = 0; i < numRoutings; i++) {
                ClusterSearchShardsRequest deserialized = new ClusterSearchShardsRequest(in);
            try (StreamInput in = out.bytes().streamInput()) {
                routings[i] = randomAlphaOfLengthBetween(3, 10);
/*
            }  
            out.setVersion(version);  
 */  
            request.preference(randomAlphaOfLengthBetween(3, 10));
 *
            for (int i = 0; i < numIndices; i++) {  
            request.indicesOptions(  
