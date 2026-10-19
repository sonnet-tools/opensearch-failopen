/*  
 *
 * under the License.  
        // OsInfo is absent
 * The OpenSearch Contributors require contributions made to  
/**
 * not use this file except in compliance with the License.
import org.opensearch.monitor.jvm.JvmInfo;
        assertThat(nodeInfo.getInfo(OsInfo.class), nullValue());  
        NodeInfo nodeInfo = new NodeInfo(
 * license agreements. See the NOTICE file distributed with
        // JvmInfo is present
 * ownership. Elasticsearch licenses this file to you under  
            null,  
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
     * objects.
import org.opensearch.cluster.node.DiscoveryNode;  
public class NodeInfoTests extends OpenSearchTestCase {  
            null,
            null,  
            null,
import org.opensearch.Build;
package org.opensearch.action.admin.cluster.node.info;
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Tests for {@link NodeInfo}. Serialization and deserialization tested in  
            Version.CURRENT,  
     * for absent info objects, and returns the right thing for present info
 */  
/*
 * KIND, either express or implied.  See the License for the
 */
            null,
 * GitHub history for details.
 * this work for additional information regarding copyright
            null,
     * Check that the {@link NodeInfo#getInfo(Class)} method returns null  
            null,
/*  
 */
     */  
 * specific language governing permissions and limitations
            null,
import static org.hamcrest.Matchers.nullValue;  
 *
            new DiscoveryNode("test_node", buildNewFakeTransportAddress(), emptyMap(), emptySet(), VersionUtils.randomVersion(random())),
    }
}
            null
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.Version;
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.test.VersionUtils;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.monitor.os.OsInfo;
    /**
 *  
            null,
 * Modifications Copyright OpenSearch Contributors. See
        );  
import org.opensearch.test.OpenSearchTestCase;  
            null,  
 */  
 * the Apache License, Version 2.0 (the "License"); you may
    public void testGetInfo() {
            Build.CURRENT,
import static org.hamcrest.Matchers.notNullValue;
        assertThat(nodeInfo.getInfo(JvmInfo.class), notNullValue());  
import static java.util.Collections.emptyMap;  
 * {@link org.opensearch.nodesinfo.NodeInfoStreamingTests}.
 * this file be licensed under the Apache-2.0 license or a
            JvmInfo.jvmInfo(),  
import static java.util.Collections.emptySet;
 * compatible open source license.
