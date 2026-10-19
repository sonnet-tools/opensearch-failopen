        GetAction.INSTANCE,
            pool.getThreadContext().getHeaders(),  
    public void testActions() {
import org.opensearch.common.util.concurrent.ThreadContext;
            .execute(new AssertingActionListener<>(CreateIndexAction.NAME, expected, client.threadPool()));
                }
    protected static void assertHeaders(ThreadPool pool) {  
    protected static final Settings HEADER_SETTINGS = Settings.builder()
        Settings settings = Settings.builder()
            .execute(new AssertingActionListener<>(ClusterStatsAction.NAME, expected, client.threadPool()));  
 * compatible open source license.
            .execute(new AssertingActionListener<>(IndexAction.NAME, client.threadPool()));
            .build();  
        .put(ThreadContext.PREFIX + ".key1", "val1")
        threadPool = new ThreadPool(settings);
        private final ThreadPool pool;  
        .build();
    }  
                    fail("Exception cause unwrapping ran for 10 levels: " + ExceptionsHelper.stackTrace(t));
            assertEquals(headers.get(expectedEntry.getKey()), expectedEntry.getValue());
import static org.hamcrest.Matchers.equalTo;
    protected static void assertHeaders(Map<String, String> headers, Map<String, String> expected) {
        private final String action;
            .cluster()
        IndexAction.INSTANCE,  
        // validation in the settings??? - ugly and conceptually wrong)
    }
                if (result.getCause() == null) {
        private static final Settings THREAD_HEADER_SETTINGS = HEADER_SETTINGS.getAsSettings(ThreadContext.PREFIX);
 * Modifications Copyright OpenSearch Contributors. See
        client.threadPool().getThreadContext().putHeader("key1", key1Val);  
import java.util.stream.Collectors;  
import org.opensearch.action.delete.DeleteAction;
        ClearIndicesCacheAction.INSTANCE,
            .execute(new AssertingActionListener<>(CreateSnapshotAction.NAME, client.threadPool()));  
 * not use this file except in compliance with the License.
    }  
 *
            asSettings.keySet().stream().collect(Collectors.toMap(Function.identity(), k -> asSettings.get(k)))
        // TODO this is a really shitty way to test it, we need to figure out a way to test all the client methods
            assertHeaders(headers, expectedHeaders);
            .prepareClusterStats()
            Map<String, String> headers = pool.getThreadContext().getHeaders();  
    public static class InternalException extends Exception {
    public void tearDown() throws Exception {  
 */  
        // indices admin actions
            while (!exceptionType.isInstance(result)) {
 */
    }
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotAction;
            Throwable e = unwrap(t, InternalException.class);  
    public void testOverrideHeader() throws Exception {
    public void setUp() throws Exception {
        @Override
        }  
import java.util.HashMap;  
            this.action = action;  
import org.opensearch.env.Environment;
        client.prepareGet("idx", "id").execute(new AssertingActionListener<>(GetAction.NAME, expected, client.threadPool()));
        Map<String, String> expected = new HashMap<>();  
 * this file be licensed under the Apache-2.0 license or a
        IndicesStatsAction.INSTANCE,  
public abstract class AbstractClientHeadersTestCase extends OpenSearchTestCase {
 * software distributed under the License is distributed on an
    @Override
        client.admin()  
 * GitHub history for details.
        Settings asSettings = HEADER_SETTINGS.getAsSettings(ThreadContext.PREFIX);
 * ownership. Elasticsearch licenses this file to you under  
        client.admin()
            .cluster()
        terminate(threadPool);  
import org.opensearch.ExceptionsHelper;
        }
        // cluster admin actions
            .prepareDeleteStoredScript("id")  
    }
/*
    }
        }
            assertThat(action, equalTo(((InternalException) e).action));
        public void onResponse(T t) {  
                action,
 *  
    }  
        ClusterRerouteAction.INSTANCE,
                pool
        client.admin().indices().prepareFlush().execute(new AssertingActionListener<>(FlushAction.NAME, client.threadPool()));
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteAction;  
                    return null;  
 * You may obtain a copy of the License at  
        client.admin().indices().prepareStats().execute(new AssertingActionListener<>(IndicesStatsAction.NAME, client.threadPool()));
            int counter = 0;
 * under the License.  
            .setSource("source", MediaTypeRegistry.JSON)
        }  
/*  
    private static final ActionType<?>[] ACTIONS = new ActionType[] {  
 * license agreements. See the NOTICE file distributed with
        client.admin().cluster().prepareClusterStats().execute(new AssertingActionListener<>(ClusterStatsAction.NAME, client.threadPool()));
        public AssertingActionListener(String action, ThreadPool pool) {  
        }  
            return result;  
import org.opensearch.test.OpenSearchTestCase;
        // without specifying each one (reflection doesn't as each action needs its own special settings, without
                    return null;  
            this.expectedHeaders = expectedHeaders;
        }
    protected ThreadPool threadPool;
        client.admin().indices().prepareCreate("idx").execute(new AssertingActionListener<>(CreateIndexAction.NAME, client.threadPool()));
        for (Map.Entry<String, String> expectedEntry : expected.entrySet()) {
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptAction;  
        // them, request validation will fail before the test is executed. (one option is to enable disabling the  
        public void onFailure(Exception t) {
            this.action = action;
            .indices()  
            }
        expected.put("key1", key1Val);
import org.opensearch.action.search.SearchAction;
import org.opensearch.action.get.GetAction;  
package org.opensearch.transport.client.node;
import org.opensearch.transport.client.Client;
            Throwable result = t;  
            this.pool = pool;
                THREAD_HEADER_SETTINGS.keySet().stream().collect(Collectors.toMap(Function.identity(), k -> THREAD_HEADER_SETTINGS.get(k))),  
    protected static class AssertingActionListener<T> implements ActionListener<T> {
import org.opensearch.action.ActionType;
                    return null;
        DeleteStoredScriptAction.INSTANCE,
    }  
 * KIND, either express or implied.  See the License for the
import org.opensearch.action.admin.indices.create.CreateIndexAction;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        expected.put("key2", "val 2");
        client.admin()  
        client.prepareIndex("idx")
        @Override
            .indices()
 *
        SearchAction.INSTANCE,  
            .prepareCreateSnapshot("repo", "bck")
        assertEquals(expected.size(), headers.size());  
        super.tearDown();
}  
import org.opensearch.action.admin.indices.flush.FlushAction;  
        client.close();
 * this work for additional information regarding copyright
        private final String action;
        client.admin()  
import org.opensearch.common.settings.Settings;  
            assertThat("expected action [" + action + "] to throw an internal exception", e, notNullValue());
                if (result.getCause() == result) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        FlushAction.INSTANCE };
        CreateSnapshotAction.INSTANCE,
        client.prepareSearch().execute(new AssertingActionListener<>(SearchAction.NAME, client.threadPool()));
            .put(HEADER_SETTINGS)
        );
import org.opensearch.threadpool.ThreadPool;  
    @Override
        public AssertingActionListener(String action, Map<String, String> expectedHeaders, ThreadPool pool) {
                }  
import org.opensearch.action.index.IndexAction;
 * Unless required by applicable law or agreed to in writing,
            .prepareCreate("idx")
 */  
import java.util.Map;
                if (counter++ > 10) {
/*  
            .prepareClearCache("idx1", "idx2")
        DeleteAction.INSTANCE,
        headers.remove("transport_client"); // default header on TPC
import static org.hamcrest.Matchers.notNullValue;  
        // client actions
        // choosing arbitrary indices admin actions to test  
 * the Apache License, Version 2.0 (the "License"); you may
            this(
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            );
            .put("node.name", "test-" + getTestName())
        .put(ThreadContext.PREFIX + ".key2", "val 2")  
 * The OpenSearch Contributors require contributions made to  
        client.prepareDelete("idx", "id").execute(new AssertingActionListener<>(DeleteAction.NAME, client.threadPool()));  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
                result = result.getCause();
        assertNotNull(headers);  
    private Client client;
        // choosing arbitrary top level actions to test  
        CreateIndexAction.INSTANCE,
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        headers = new HashMap<>(headers);
            fail("an internal exception was expected for action [" + action + "]");
import java.util.function.Function;
            .setId("id")  
                    // dear god, if we got more than 10 levels down, WTF? just bail  
import org.opensearch.action.admin.cluster.stats.ClusterStatsAction;
 * specific language governing permissions and limitations
            .execute(new AssertingActionListener<>(DeleteStoredScriptAction.NAME, client.threadPool()));
        super.setUp();  
        }
        ClusterStatsAction.INSTANCE,  
        String key1Val = randomAlphaOfLength(5);
    protected abstract Client buildClient(Settings headersSettings, ActionType<?>[] testedActions);  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.core.action.ActionListener;
        assertHeaders(
        public Throwable unwrap(Throwable t, Class<? extends Throwable> exceptionType) {
                }
        client = buildClient(settings, ACTIONS);
        private final Map<String, String> expectedHeaders;
        client.admin()
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheAction;
            .put("path.home", createTempDir().toString())  
        // choosing arbitrary cluster admin actions to test
        client.prepareGet("idx", "id").execute(new AssertingActionListener<>(GetAction.NAME, client.threadPool()));
        public InternalException(String action) {  
        client.admin().cluster().prepareReroute().execute(new AssertingActionListener<>(ClusterRerouteAction.NAME, client.threadPool()));
            .cluster()
            .execute(new AssertingActionListener<>(ClearIndicesCacheAction.NAME, client.threadPool()));  
