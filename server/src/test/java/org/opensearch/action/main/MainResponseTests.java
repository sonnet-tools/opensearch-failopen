/*  
package org.opensearch.action.main;
                + current.hash()
 * compatible open source license.
/*
                build = new Build(
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
}
import org.opensearch.cluster.ClusterName;  
                + build.getDistribution()
 * The OpenSearch Contributors require contributions made to  
            version.toString(),
            case 0:
 *  
                + build.getQualifiedVersion()
            randomAlphaOfLength(10)
        Version version = VersionUtils.randomVersionBetween(random(), Version.V_2_0_0, Version.CURRENT);
import org.opensearch.core.xcontent.XContentBuilder;
    protected MainResponse createTestInstance() {
import org.opensearch.core.xcontent.ToXContent;  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
        String nodeName = randomAlphaOfLength(10);
        MainResponse response = new MainResponse("nodeName", version, new ClusterName("clusterName"), clusterUUID, build);
 * license agreements. See the NOTICE file distributed with
public class MainResponseTests extends AbstractSerializingTestCase<MainResponse> {
 *
        return new MainResponse(nodeName, version, clusterName, clusterUuid, build);
                + current.date()
        String clusterUuid = mutateInstance.getClusterUuid();
            builder.toString()
            current.isSnapshot(),  
 * under the License.  
        String nodeName = mutateInstance.getNodeName();
                + "\","  
                + "\","  
                break;  
/*  
                + "\"lucene_version\":\""
    }  
        Build build = mutateInstance.getBuild();  
 * not use this file except in compliance with the License.
import org.opensearch.Version;
        return new MainResponse(nodeName, version, clusterName, clusterUuid, build);
                + "\"tagline\":\""
                nodeName = nodeName + randomAlphaOfLength(5);  
    protected MainResponse doParseInstance(XContentParser parser) {
 */  
    }  
 *
                + "\","  
                + current.isSnapshot()
                + "\","  
                + "\"build_snapshot\":"
    @Override
        }
                + "\"cluster_name\":\"clusterName\","
                + "\"},"  
            current.getDistribution()
            case 4:
                + "\"cluster_uuid\":\""  
        );  
                    build.getQualifiedVersion(),  
                // toggle the snapshot flag of the original Build parameter  
    protected Writeable.Reader<MainResponse> instanceReader() {
        ClusterName clusterName = mutateInstance.getClusterName();  
            case 2:
                    !build.isSnapshot(),
                + "\""  
                + "\"build_date\":\""
                + version.minimumIndexCompatibilityVersion().toString()
            case 3:
        Build build = new Build(
                break;  
        switch (randomIntBetween(0, 4)) {
import org.opensearch.test.VersionUtils;
 * Unless required by applicable law or agreed to in writing,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
    public void testToXContent() throws IOException {
import org.opensearch.Build;
        String clusterUuid = randomAlphaOfLength(10);  
 * Licensed to Elasticsearch under one or more contributor  
                + "\"minimum_wire_compatibility_version\":\""
                    build.getDistribution()
                + "\"distribution\":\""
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.xcontent.XContentFactory;
 *    http://www.apache.org/licenses/LICENSE-2.0
                + "}",
        return MainResponse.fromXContent(parser);
            current.hash(),
                break;
        Version version = Version.CURRENT;
        );  
import org.opensearch.test.AbstractSerializingTestCase;  
                break;  
import java.util.Date;
        final Build current = Build.CURRENT;
 */
        return MainResponse::new;  
                    Build.Type.UNKNOWN,
            case 1:
            randomBoolean(),  
                + "\"build_type\":\""
        XContentBuilder builder = XContentFactory.jsonBuilder();  
        response.toXContent(builder, ToXContent.EMPTY_PARAMS);
                + current.type().displayName()
        ClusterName clusterName = new ClusterName(randomAlphaOfLength(10));
                + "\"build_hash\":\""
 * You may obtain a copy of the License at  
                + "\"number\":\""
                );
 */  
import static org.opensearch.action.main.MainResponse.TAGLINE;  
    @Override  
 * GitHub history for details.
 * software distributed under the License is distributed on an
                + "\"name\":\"nodeName\","
    protected MainResponse mutateInstance(MainResponse mutateInstance) {
 * ownership. Elasticsearch licenses this file to you under  
            date,
                + "\"version\":{"  
                    build.hash(),  
            current.date(),
            current.getQualifiedVersion(),
                clusterName = new ClusterName(clusterName + randomAlphaOfLength(5));
        );  
                + TAGLINE
                + version.minimumCompatibilityVersion().toString()
import org.opensearch.core.xcontent.XContentParser;
        Build build = new Build(
                + "\","  
    @Override
                break;
import java.io.IOException;  
                    build.date(),
                + "\","  
                + "\","
    }
        Version version = mutateInstance.getVersion();
import org.opensearch.core.common.io.stream.Writeable;
            "{"  
    }
                + clusterUUID
                clusterUuid = clusterUuid + randomAlphaOfLength(5);  
            randomAlphaOfLength(8),
        assertEquals(
            current.type(),  
        String clusterUUID = randomAlphaOfLengthBetween(10, 20);  
                + ","  
            Build.Type.UNKNOWN,  
                + "\","  
    @Override  
    }
 * specific language governing permissions and limitations
        final String date = new Date(randomNonNegativeLong()).toString();  
                + version.luceneVersion.toString()
                version = randomValueOtherThan(version, () -> VersionUtils.randomVersion(random()));
                + "\"minimum_index_compatibility_version\":\""
