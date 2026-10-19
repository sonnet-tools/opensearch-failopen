 *
            newRemoteInfo("http", null, "testuser", null).toString()  
        assertEquals("host=testhost port=12344 query={ \"foo\" : \"bar\" }", newRemoteInfo("http", null, null, null).toString());  
import org.opensearch.test.OpenSearchTestCase;  
package org.opensearch.index.reindex.remote;
            new BytesArray("{ \"foo\" : \"bar\" }"),
/*  
    }
        );
        );  
            "host=testhost port=12344 query={ \"foo\" : \"bar\" } username=testuser password=<<>>",  
 */  
            newRemoteInfo("https", "prxy", "testuser", "testpass").toString()  
            newRemoteInfo("https", null, "testuser", "testpass").toString()
}  
    public void testToString() {
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 * GitHub history for details.
        );
 */  
        );
import org.opensearch.core.common.bytes.BytesArray;
            newRemoteInfo("http", null, "testuser", "testpass").toString()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            RemoteInfo.DEFAULT_SOCKET_TIMEOUT,  
        assertEquals(
 * this file be licensed under the Apache-2.0 license or a
            "scheme=https host=testhost port=12344 query={ \"foo\" : \"bar\" } username=testuser password=<<>>",
        );
 * software distributed under the License is distributed on an
            scheme,
 */
/*  
 * not use this file except in compliance with the License.
        assertEquals(  
 *    http://www.apache.org/licenses/LICENSE-2.0
 *  
            "host=testhost port=12344 query={ \"foo\" : \"bar\" } username=testuser",
public class RemoteInfoTests extends OpenSearchTestCase {
            username,  
            12344,  
import org.opensearch.index.reindex.RemoteInfo;
 * KIND, either express or implied.  See the License for the
        return new RemoteInfo(  
 *
            "scheme=https host=testhost port=12344 pathPrefix=prxy query={ \"foo\" : \"bar\" } username=testuser password=<<>>",
 * specific language governing permissions and limitations
    private RemoteInfo newRemoteInfo(String scheme, String prefixPath, String username, String password) {
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(
/*
 * Unless required by applicable law or agreed to in writing,
            RemoteInfo.DEFAULT_CONNECT_TIMEOUT
            prefixPath,
        assertEquals(
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
            password,
            emptyMap(),
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
            "testhost",
import static java.util.Collections.emptyMap;
    }  
 * this work for additional information regarding copyright
