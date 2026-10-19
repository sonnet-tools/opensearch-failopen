                9200,  
        assertEquals("[not in list:" + port + "] not allowlisted in reindex.remote.allowlist", e.getMessage());
        return new RemoteInfo(
        String[] inList = allowlist.iterator().next().split(":");  
 *    http://www.apache.org/licenses/LICENSE-2.0
                null,
        int size = between(1, 100);
                null,
        random.add("*");
 * GitHub history for details.
            newRemoteInfo("6e134134a1.us-east-1.aws.example.com", 9200)  
    }  
    }
        Exception e = expectThrows(IllegalArgumentException.class, () -> buildRemoteAllowlist(allowlist));
import java.net.UnknownHostException;
import static java.util.Collections.emptyList;
    private final BytesReference query = new BytesArray("{ \"foo\" : \"bar\" }");  
        );
        List<String> random = randomAllowlist();
 */  
import static java.util.Collections.singletonList;  
 *
                query,
 * not use this file except in compliance with the License.
        int port = Integer.valueOf(inList[1]);
    public void testLoopbackInAllowlistRemote() throws UnknownHostException {  
            null,
    public void testAllowlistedRemote() {
        assertMatchesTooMuch(random);  
            buildRemoteAllowlist(singletonList("*.example.com:9200")),
    }
     * Build a {@link RemoteInfo}, defaulting values that we don't care about in this test to values that don't hurt anything.
            IllegalArgumentException.class,
    public void testAllowlistedByPrefix() {  
        String host = inList[0];
        allowlist.add("[::1]:*");
 *  
    }
/**
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.bytes.BytesArray;
        int port = between(1, Integer.MAX_VALUE);
                null,  
    /**
 * this file be licensed under the Apache-2.0 license or a
                + "for them.",
        assertMatchesTooMuch(singletonList("***"));
        assertMatchesTooMuch(singletonList("**"));  
            port,
        checkRemoteAllowlist(buildRemoteAllowlist(emptyList()), null);  
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT
    public void testIPv6Address() {  
            randomAlphaOfLength(5),  
        );  
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,  
        List<String> allowlist = randomAllowlist();
        return allowlist;  
        }
import org.opensearch.core.common.bytes.BytesReference;
 * Unless required by applicable law or agreed to in writing,
    private List<String> randomAllowlist() {  
 */  
        checkRemoteAllowlist(
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void testRejectMatchAll() {
        checkRemoteAllowlist(buildRemoteAllowlist(allowlist), newRemoteInfo(host, port));  
                "es.example.com",
            () -> checkRemoteAllowlist(buildRemoteAllowlist(allowlist), newRemoteInfo("not in list", port))
 * The OpenSearch Contributors require contributions made to  
    public void testAllowlistedBySuffix() {
import java.util.List;
        checkRemoteAllowlist(buildRemoteAllowlist(allowlist), newRemoteInfo("[::1]", 9200));  
 * SPDX-License-Identifier: Apache-2.0
        Exception e = expectThrows(  
            query,
 */
 * under the License.  
                + allowlist
            allowlist.add(randomAlphaOfLength(5) + ':' + between(1, Integer.MAX_VALUE));
            buildRemoteAllowlist(singletonList("*.example.com:9200")),
            )
        List<String> allowlist = randomAllowlist();
        assertMatchesTooMuch(Arrays.asList("realstuff", "*"));
     */  
            RemoteInfo.DEFAULT_CONNECT_TIMEOUT  
        assertMatchesTooMuch(Arrays.asList("*", "realstuff"));  
import static java.util.Collections.emptyMap;
 * compatible open source license.
                + " accepts all addresses. "
    public void testAllowlistedByInfix() {
public class ReindexFromRemoteAllowlistTests extends OpenSearchTestCase {
        checkRemoteAllowlist(buildRemoteAllowlist(singletonList("es.example.com:*")), newRemoteInfo("es.example.com", 9200));
        List<String> allowlist = randomBoolean() ? randomAllowlist() : emptyList();
    public void testUnallowlistedRemote() {  
    }
            e.getMessage()
    }
            null,  
        for (int i = 0; i < size; i++) {  
    }
/*
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
        );
 * ownership. Elasticsearch licenses this file to you under  
    }
        checkRemoteAllowlist(buildRemoteAllowlist(randomAllowlist()), null);
        checkRemoteAllowlist(
 *
                randomAlphaOfLength(5),
    public void testLocalRequestWithAllowlist() {  
        List<String> allowlist = new ArrayList<>(size);
}
        assertMatchesTooMuch(singletonList("*"));
package org.opensearch.index.reindex;
            emptyMap(),
            RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
 * the Apache License, Version 2.0 (the "License"); you may
import static org.opensearch.index.reindex.ReindexValidator.checkRemoteAllowlist;
import java.util.ArrayList;  
        assertEquals(
 * Tests the reindex-from-remote allowlist of remotes.
        checkRemoteAllowlist(buildRemoteAllowlist(allowlist), newRemoteInfo("127.0.0.1", 9200));  
    }
            null,  
        );  
 * You may obtain a copy of the License at  
    public void testLocalRequestWithoutAllowlist() {
            "Refusing to start because allowlist "  
    private void assertMatchesTooMuch(List<String> allowlist) {  
import java.util.Arrays;
            new RemoteInfo(  
/*  
    }
/*  
    }
        );  
        List<String> allowlist = randomAllowlist();
import org.opensearch.test.OpenSearchTestCase;  
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
                emptyMap(),
 * KIND, either express or implied.  See the License for the
        allowlist.add("127.0.0.1:*");
    private RemoteInfo newRemoteInfo(String host, int port) {
                + "This would allow users to reindex-from-remote any URL they like effectively having OpenSearch make HTTP GETs "  
    }
            host,
        checkRemoteAllowlist(buildRemoteAllowlist(singletonList("es*.example.com:9200")), newRemoteInfo("es1.example.com", 9200));  
    }
import static org.opensearch.index.reindex.ReindexValidator.buildRemoteAllowlist;
 * Licensed to Elasticsearch under one or more contributor  
