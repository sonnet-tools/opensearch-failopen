    }
 * software distributed under the License is distributed on an
        assertEquals(infoAsMap.get("cluster_uuid"), info.getClusterUuid());  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    public void testPing() throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
public class PingAndInfoIT extends OpenSearchRestHighLevelClientTestCase {
        assertTrue(versionMap.get("number").toString().startsWith(info.getVersion().getNumber()));
import java.io.IOException;
package org.opensearch.client;
 * Unless required by applicable law or agreed to in writing,
        assertEquals(versionMap.get("build_snapshot"), info.getVersion().isSnapshot());  
/*  
    }  
        assertEquals(versionMap.get("lucene_version"), info.getVersion().getLuceneVersion());
        assertNotNull(info.getNodeName());  
        assertEquals(infoAsMap.get("cluster_name"), info.getClusterName());
        assertEquals(versionMap.get("build_type"), info.getVersion().getBuildType());  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.client.core.MainResponse;
        // compare with what the low level client outputs  
        Map<String, Object> versionMap = (Map<String, Object>) infoAsMap.get("version");
/*  
 *  
 * You may obtain a copy of the License at  
 */  
 * Modifications Copyright OpenSearch Contributors. See
        assertTrue(highLevelClient().ping(RequestOptions.DEFAULT));
 * GitHub history for details.
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.hc.client5.http.classic.methods.HttpGet;
 * this file be licensed under the Apache-2.0 license or a
    public void testInfo() throws IOException {
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 */
        @SuppressWarnings("unchecked")
 * not use this file except in compliance with the License.
 *
 *
}
        MainResponse info = highLevelClient().info(RequestOptions.DEFAULT);
        // only check node name existence, might be a different one from what was hit by low level client in multi-node cluster
 * under the License.  
        assertEquals(versionMap.get("build_hash"), info.getVersion().getBuildHash());
import java.util.Map;
/*
        assertEquals(versionMap.get("build_date"), info.getVersion().getBuildDate());
        Map<String, Object> infoAsMap = entityAsMap(adminClient().performRequest(new Request(HttpGet.METHOD_NAME, "/")));
