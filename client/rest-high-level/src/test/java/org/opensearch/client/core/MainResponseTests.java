 *    http://www.apache.org/licenses/LICENSE-2.0
    @Override
public class MainResponseTests extends AbstractResponseTestCase<org.opensearch.action.main.MainResponse, MainResponse> {
        assertThat(serverTestInstance.getBuild().hash(), equalTo(clientInstance.getVersion().getBuildHash()));  
import java.util.Date;
        final String date = new Date(randomNonNegativeLong()).toString();
package org.opensearch.client.core;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 */
import org.opensearch.client.AbstractResponseTestCase;  
 */  
        assertThat(serverTestInstance.getVersion().toString(), equalTo(clientInstance.getVersion().getNumber()));
            serverTestInstance.getVersion().minimumIndexCompatibilityVersion().toString(),  
        assertThat(  
 * software distributed under the License is distributed on an
        Version version = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT);
 * under the License.  
import org.opensearch.Version;
import org.opensearch.test.VersionUtils;
        assertThat(serverTestInstance.getClusterUuid(), equalTo(clientInstance.getClusterUuid()));  
import org.opensearch.cluster.ClusterName;
 * The OpenSearch Contributors require contributions made to  
        return new org.opensearch.action.main.MainResponse(nodeName, version, clusterName, clusterUuid, build);
        assertThat(serverTestInstance.getBuild().date(), equalTo(clientInstance.getVersion().getBuildDate()));
 *
/*
 * You may obtain a copy of the License at  
    }
    }
            serverTestInstance.getVersion().minimumCompatibilityVersion().toString(),
 */  
    @Override  
        );  
 * GitHub history for details.
        assertThat(serverTestInstance.getVersion().luceneVersion.toString(), equalTo(clientInstance.getVersion().getLuceneVersion()));
import org.opensearch.Build;
        assertThat(serverTestInstance.getClusterName().value(), equalTo(clientInstance.getClusterName()));
        assertThat(serverTestInstance.getNodeName(), equalTo(clientInstance.getNodeName()));
        Build build = new Build(Build.Type.UNKNOWN, randomAlphaOfLength(8), date, randomBoolean(), version.toString(), DISTRIBUTION);  
import org.opensearch.core.xcontent.XContentParser;  
        ClusterName clusterName = new ClusterName(randomAlphaOfLength(10));
 * compatible open source license.
            equalTo(clientInstance.getVersion().getMinimumWireCompatibilityVersion())
 * the Apache License, Version 2.0 (the "License"); you may
/*  
        String nodeName = randomAlphaOfLength(10);  
import org.opensearch.common.xcontent.XContentType;
 * KIND, either express or implied.  See the License for the
 *
import static org.hamcrest.Matchers.equalTo;  
    @Override
 *  
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;  
}
    protected org.opensearch.action.main.MainResponse createServerTestInstance(XContentType xContentType) {  
/*  
        assertThat(
 * not use this file except in compliance with the License.
    }
            equalTo(clientInstance.getVersion().getMinimumIndexCompatibilityVersion())
        return MainResponse.fromXContent(parser);  
    protected void assertInstances(org.opensearch.action.main.MainResponse serverTestInstance, MainResponse clientInstance) {
        );
    protected MainResponse doParseToClientInstance(XContentParser parser) throws IOException {
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
        assertThat(serverTestInstance.getBuild().type().displayName(), equalTo(clientInstance.getVersion().getBuildType()));  
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * this work for additional information regarding copyright
        String clusterUuid = randomAlphaOfLength(10);
    private static String DISTRIBUTION = "opensearch";  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
