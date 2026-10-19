 * Unless required by applicable law or agreed to in writing,
        );  
                "localhost",
import org.opensearch.client.RestClientBuilderTestCase;
 * under the License.  
        RemoteInfo remoteInfo = new RemoteInfo(
        }
            RemoteInfo.DEFAULT_CONNECT_TIMEOUT
                null,  
                    i++;
            try {  
        return new ReindexSslConfig(environment.settings(), environment, resourceWatcher);
            client.close();
import org.opensearch.watcher.ResourceWatcherService;  
import static org.hamcrest.Matchers.hasSize;  
 *
import org.opensearch.common.settings.Settings;  
        } finally {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            long taskId = randomLong();  
            );
/*  
 * this file be licensed under the Apache-2.0 license or a
                emptyMap(),
                RemoteInfo.DEFAULT_SOCKET_TIMEOUT,  
package org.opensearch.index.reindex;
 * license agreements. See the NOTICE file distributed with
}
public class ReindexFromRemoteBuildRestClientTests extends RestClientBuilderTestCase {  
 */  
import static java.util.Collections.synchronizedList;
import static java.util.Collections.emptyMap;
 *
                "https",
    }
    private final BytesReference matchAll = new BytesArray(new MatchAllQueryBuilder().toString());
import java.util.HashMap;  
 */
 * Modifications Copyright OpenSearch Contributors. See
            null,
import org.opensearch.core.common.bytes.BytesArray;
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
                9200,  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertHeaders(client, headers);
        for (int i = 0; i < numHeaders; ++i) {
 * compatible open source license.
            headers.put("header" + i, Integer.toString(i));
 * Licensed to Elasticsearch under one or more contributor  
    private ReindexSslConfig sslConfig() {
            matchAll,  
        Map<String, String> headers = new HashMap<>();
                client.close();
            List<Thread> threads = synchronizedList(new ArrayList<>());
                    assertEquals("es-client-" + taskId + "-" + i, thread.getName());
                int i = 0;
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
import org.opensearch.core.common.bytes.BytesReference;
import org.opensearch.index.query.MatchAllQueryBuilder;
            9200,
    public void testHeaders() throws Exception {
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
        long taskId = randomLong();
 * software distributed under the License is distributed on an
            null,
            }  
        for (final String path : new String[] { "", null, "/", "path" }) {
 * not use this file except in compliance with the License.
 */  
    }  
                path,
        final ResourceWatcherService resourceWatcher = mock(ResourceWatcherService.class);
            RemoteInfo remoteInfo = new RemoteInfo(  
/*  
 * SPDX-License-Identifier: Apache-2.0
        final Environment environment = TestEnvironment.newEnvironment(Settings.builder().put("path.home", createTempDir()).build());  
 * KIND, either express or implied.  See the License for the
            } finally {
            null,
            "localhost",  
        try {
                null,
            RemoteInfo.DEFAULT_SOCKET_TIMEOUT,
                }  
            RestClient client = Reindexer.buildRestClient(remoteInfo, sslConfig(), taskId, threads);
 *  
import java.util.List;
/*
                RemoteInfo.DEFAULT_CONNECT_TIMEOUT
        }  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
        int numHeaders = randomIntBetween(1, 5);  
            headers,  
        List<Thread> threads = synchronizedList(new ArrayList<>());
            "https",
                for (Thread thread : threads) {  
import org.opensearch.env.TestEnvironment;
import org.opensearch.env.Environment;  
        RestClient client = Reindexer.buildRestClient(remoteInfo, sslConfig(), taskId, threads);  
                assertBusy(() -> assertThat(threads, hasSize(2)));
 * this work for additional information regarding copyright
import org.opensearch.client.RestClient;
 * GitHub history for details.
    }  
                matchAll,
    public void testBuildRestClient() throws Exception {
