import org.opensearch.test.OpenSearchTestCase;  
 * this file be licensed under the Apache-2.0 license or a
/*  
    public void testSerialization() throws Exception {  
import org.opensearch.action.support.IndicesOptions;
import org.opensearch.common.io.stream.BytesStreamOutput;  
            assertThat(deserializedCSRequest.blocks(), equalTo(clusterStateRequest.blocks()));  
 *
            () -> clusterStateRequest.waitForMetadataVersion(randomLongBetween(Long.MIN_VALUE, 0))  
            ClusterStateRequest deserializedCSRequest = new ClusterStateRequest(streamInput);
    private static void assertOptionsMatch(IndicesOptions in, IndicesOptions out) {
            clusterStateRequest.writeTo(output);  
import org.opensearch.core.common.io.stream.StreamInput;
 */
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
public class ClusterStateRequestTests extends OpenSearchTestCase {
        }
            assertThat(deserializedCSRequest.metadata(), equalTo(clusterStateRequest.metadata()));
import org.opensearch.common.unit.TimeValue;
import static org.hamcrest.CoreMatchers.equalTo;  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
                .metadata(randomBoolean())  
        assertThat(in.expandWildcardsClosed(), equalTo(out.expandWildcardsClosed()));
package org.opensearch.action.admin.cluster.state;
/*  
 */  
                random(),
 * Unless required by applicable law or agreed to in writing,
                .nodes(randomBoolean())
            streamInput.setVersion(testVersion);  
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(deserializedCSRequest.indices(), equalTo(clusterStateRequest.indices()));
                Version.CURRENT.minimumCompatibilityVersion(),
        assertThat(in.expandWildcardsOpen(), equalTo(out.expandWildcardsOpen()));
/**
        assertThat(in.allowNoIndices(), equalTo(out.allowNoIndices()));  
 */  
                .blocks(randomBoolean())
}
        assertThat(in.ignoreUnavailable(), equalTo(out.ignoreUnavailable()));  
 * Unit tests for the {@link ClusterStateRequest}.  
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.VersionUtils;
            ClusterStateRequest clusterStateRequest = new ClusterStateRequest().routingTable(randomBoolean())
        ClusterStateRequest clusterStateRequest = new ClusterStateRequest();  
            if (randomBoolean()) {  
            StreamInput streamInput = output.bytes().streamInput();
 * compatible open source license.
    }  
 * Modifications Copyright OpenSearch Contributors. See
    }  
            Version testVersion = VersionUtils.randomVersionBetween(  
 */
 * ownership. Elasticsearch licenses this file to you under  
 *
                .indicesOptions(indicesOptions);
        );
            );
 * the Apache License, Version 2.0 (the "License"); you may
                clusterStateRequest.waitForTimeout(new TimeValue(randomNonNegativeLong()));
            IllegalArgumentException.class,
    }
 * GitHub history for details.
                .indices("testindex", "testindex2")  
            BytesStreamOutput output = new BytesStreamOutput();
        clusterStateRequest.waitForMetadataVersion(randomLongBetween(1, Long.MAX_VALUE));
/*
            assertOptionsMatch(deserializedCSRequest.indicesOptions(), clusterStateRequest.indicesOptions());
            if (randomBoolean()) {  
                Version.CURRENT  
            }
 * under the License.  
 * The OpenSearch Contributors require contributions made to  
            assertThat(deserializedCSRequest.routingTable(), equalTo(clusterStateRequest.routingTable()));  
                clusterStateRequest.waitForMetadataVersion(randomLongBetween(1, Long.MAX_VALUE));
 * license agreements. See the NOTICE file distributed with
        for (int i = 0; i < iterations; i++) {
            assertThat(deserializedCSRequest.waitForMetadataVersion(), equalTo(clusterStateRequest.waitForMetadataVersion()));  
        expectThrows(
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            IndicesOptions indicesOptions = IndicesOptions.fromOptions(randomBoolean(), randomBoolean(), randomBoolean(), randomBoolean());
 *  
 * specific language governing permissions and limitations
            assertThat(deserializedCSRequest.waitForTimeout(), equalTo(clusterStateRequest.waitForTimeout()));
 * this work for additional information regarding copyright
    public void testWaitForMetadataVersion() {
            assertThat(deserializedCSRequest.nodes(), equalTo(clusterStateRequest.nodes()));
        int iterations = randomIntBetween(5, 20);
            output.setVersion(testVersion);
import org.opensearch.Version;
