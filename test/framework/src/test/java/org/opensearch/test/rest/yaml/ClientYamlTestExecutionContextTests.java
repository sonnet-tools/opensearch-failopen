                return version;  
                headersRef.set(headers);  
public class ClientYamlTestExecutionContextTests extends OpenSearchTestCase {
    }
import org.opensearch.test.VersionUtils;
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
            @Override
        assertNotEquals(headers, headersRef.get());
        context.stash().stashValue("bar", "foo2");
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("foo2", headersRef.get().get("foo"));  
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
                NodeSelector nodeSelector
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
 * under the License.  
 * specific language governing permissions and limitations
/*  
            }
        final Map<String, String> headers = new HashMap<>();  
import java.util.HashMap;  
 * The OpenSearch Contributors require contributions made to  
 */  
                Map<String, String> headers,  
 * GitHub history for details.
import org.opensearch.Version;
 */  
}  
 *  
                String apiName,  
 * this work for additional information regarding copyright
                HttpEntity entity,
 * license agreements. See the NOTICE file distributed with
import java.io.IOException;
import java.util.Map;
 * this file be licensed under the Apache-2.0 license or a
        final AtomicReference<Map<String, String>> headersRef = new AtomicReference<>();
package org.opensearch.test.rest.yaml;
 *
            ClientYamlTestResponse callApiInternal(
            public Version esVersion() {
            ) {
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
                Map<String, String> params,
    public void testHeadersSupportStashedValueReplacement() throws IOException {  
        context.callApi("test", Collections.emptyMap(), Collections.emptyList(), headers);
import org.apache.hc.core5.http.HttpEntity;
                return null;
        final ClientYamlTestExecutionContext context = new ClientYamlTestExecutionContext(null, randomBoolean()) {  
        assertNull(headersRef.get());
 *
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
/*
import java.util.concurrent.atomic.AtomicReference;
 */
        assertEquals("baz bar1", headersRef.get().get("foo1"));
        context.stash().stashValue("c", "bar1");
import org.opensearch.test.OpenSearchTestCase;
            @Override
        };
        headers.put("foo1", "baz ${c}");
        final Version version = VersionUtils.randomVersion(random());
import org.opensearch.client.NodeSelector;  
        headers.put("foo", "$bar");
import java.util.Collections;
        assertNotNull(headersRef.get());  
