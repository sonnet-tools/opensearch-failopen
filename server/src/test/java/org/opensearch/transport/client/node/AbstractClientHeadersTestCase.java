        public AssertingActionListener(String action, Map<String, String> expectedHeaders, ThreadPool pool) {
 * this work for additional information regarding copyright
        headers = new HashMap<>(headers);
import static org.hamcrest.Matchers.equalTo;
 *
import org.opensearch.action.get.GetAction;
                result = result.getCause();
        CreateIndexAction.INSTANCE,
                if (counter++ > 10) {
        }
            Throwable e = unwrap(t, InternalException.class);
        client.prepareGet("idx", "id").execute(new AssertingActionListener<>(GetAction.NAME, expected, client.threadPool()));
        super.setUp();
import org.opensearch.action.admin.indices.stats.IndicesStatsAction;
        String key1Val = randomAlphaOfLength(5);
            .prepareClearCache("idx1", "idx2")
            this.action = action;
    protected static void assertHeaders(Map<String, String> headers, Map<String, String> expected) {
                if (result.getCause() == result) {
                }
        client.admin()
 *
    protected static void assertHeaders(ThreadPool pool) {
        client.close();
 * compatible open source license.
            pool.getThreadContext().getHeaders(),
        client.admin()
import java.util.Map;
            .cluster()
        public void onFailure(Exception t) {
            assertThat("expected action [" + action + "] to throw an internal exception", e, notNullValue());
            .indices()
    protected static final Settings HEADER_SETTINGS = Settings.builder()
    @Override
            .prepareCreate("idx")
        }
import org.opensearch.threadpool.ThreadPool;
/*
            assertHeaders(headers, expectedHeaders);
            .execute(new AssertingActionListener<>(ClearIndicesCacheAction.NAME, client.threadPool()));
            return result;
                }
            .cluster()
        DeleteStoredScriptAction.INSTANCE,
    public void testActions() {
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toString())
 *
import org.opensearch.action.admin.indices.flush.FlushAction;
        public Throwable unwrap(Throwable t, Class<? extends Throwable> exceptionType) {
            .execute(new AssertingActionListener<>(CreateSnapshotAction.NAME, client.threadPool()));
    protected ThreadPool threadPool;
        }
        private static final Settings THREAD_HEADER_SETTINGS = HEADER_SETTINGS.getAsSettings(ThreadContext.PREFIX);
        client.admin()
        threadPool = new ThreadPool(settings);
/*
            .setSource("source", MediaTypeRegistry.JSON)
            .put(HEADER_SETTINGS)
public abstract class AbstractClientHeadersTestCase extends OpenSearchTestCase {
        assertEquals(expected.size(), headers.size());
import org.opensearch.action.admin.cluster.reroute.ClusterRerouteAction;
            this.pool = pool;
        client.admin().indices().prepareStats().execute(new AssertingActionListener<>(IndicesStatsAction.NAME, client.threadPool()));
        client = buildClient(settings, ACTIONS);
import org.opensearch.action.admin.cluster.snapshots.create.CreateSnapshotAction;
            this.expectedHeaders = expectedHeaders;
        client.admin()
        // without specifying each one (reflection doesn't as each action needs its own special settings, without
        FlushAction.INSTANCE };
            assertThat(action, equalTo(((InternalException) e).action));
import static org.hamcrest.Matchers.notNullValue;
                    return null;
            .execute(new AssertingActionListener<>(DeleteStoredScriptAction.NAME, client.threadPool()));
        }
 * Modifications Copyright OpenSearch Contributors. See
    protected static class AssertingActionListener<T> implements ActionListener<T> {
                pool
        CreateSnapshotAction.INSTANCE,
    }
            this(
        assertNotNull(headers);
 * The OpenSearch Contributors require contributions made to
    public void setUp() throws Exception {
        @Override
import org.opensearch.action.admin.cluster.stats.ClusterStatsAction;
import java.util.HashMap;
            .setId("id")
            .execute(new AssertingActionListener<>(CreateIndexAction.NAME, expected, client.threadPool()));
 * this file be licensed under the Apache-2.0 license or a
        // choosing arbitrary cluster admin actions to test
        }
        Settings asSettings = HEADER_SETTINGS.getAsSettings(ThreadContext.PREFIX);
    }
        for (Map.Entry<String, String> expectedEntry : expected.entrySet()) {
                action,
        // client actions
        client.prepareIndex("idx")
        public InternalException(String action) {
import org.opensearch.common.settings.Settings;
        headers.remove("transport_client"); // default header on TPC
        Settings settings = Settings.builder()
        Map<String, String> expected = new HashMap<>();
            .prepareDeleteStoredScript("id")
package org.opensearch.transport.client.node;
 * You may obtain a copy of the License at
                }
        expected.put("key2", "val 2");
 * SPDX-License-Identifier: Apache-2.0
        client.prepareDelete("idx", "id").execute(new AssertingActionListener<>(DeleteAction.NAME, client.threadPool()));
 */
            this.action = action;
import org.opensearch.action.index.IndexAction;
 * Unless required by applicable law or agreed to in writing,
import java.util.function.Function;
import org.opensearch.ExceptionsHelper;
    }
        // cluster admin actions
import org.opensearch.action.ActionType;
        ClearIndicesCacheAction.INSTANCE,
            }
 * not use this file except in compliance with the License.
        private final Map<String, String> expectedHeaders;
        expected.put("key1", key1Val);
        SearchAction.INSTANCE,
        // them, request validation will fail before the test is executed. (one option is to enable disabling the
import java.util.stream.Collectors;
        IndexAction.INSTANCE,
        DeleteAction.INSTANCE,
                    fail("Exception cause unwrapping ran for 10 levels: " + ExceptionsHelper.stackTrace(t));
 * KIND, either express or implied.  See the License for the
            asSettings.keySet().stream().collect(Collectors.toMap(Function.identity(), k -> asSettings.get(k)))
                if (result.getCause() == null) {
            Map<String, String> headers = pool.getThreadContext().getHeaders();
            .put("node.name", "test-" + getTestName())
                    return null;
                    // dear god, if we got more than 10 levels down, WTF? just bail
import org.opensearch.action.admin.indices.cache.clear.ClearIndicesCacheAction;
        ClusterStatsAction.INSTANCE,
        terminate(threadPool);
import org.opensearch.common.util.concurrent.ThreadContext;
        // indices admin actions
                THREAD_HEADER_SETTINGS.keySet().stream().collect(Collectors.toMap(Function.identity(), k -> THREAD_HEADER_SETTINGS.get(k))),
}
    }
import org.opensearch.test.OpenSearchTestCase;
            .prepareClusterStats()
        client.admin().cluster().prepareReroute().execute(new AssertingActionListener<>(ClusterRerouteAction.NAME, client.threadPool()));
        client.admin().indices().prepareFlush().execute(new AssertingActionListener<>(FlushAction.NAME, client.threadPool()));
        // validation in the settings??? - ugly and conceptually wrong)
 * ownership. Elasticsearch licenses this file to you under
        }
        .build();
    }
    public static class InternalException extends Exception {
 */
        // choosing arbitrary top level actions to test
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
import org.opensearch.action.admin.indices.create.CreateIndexAction;
        client.admin().cluster().prepareClusterStats().execute(new AssertingActionListener<>(ClusterStatsAction.NAME, client.threadPool()));
        client.threadPool().getThreadContext().putHeader("key1", key1Val);
import org.opensearch.core.action.ActionListener;
    public void testOverrideHeader() throws Exception {
        client.prepareGet("idx", "id").execute(new AssertingActionListener<>(GetAction.NAME, client.threadPool()));
        ClusterRerouteAction.INSTANCE,
            fail("an internal exception was expected for action [" + action + "]");
            .execute(new AssertingActionListener<>(IndexAction.NAME, client.threadPool()));
import org.opensearch.action.admin.cluster.storedscripts.DeleteStoredScriptAction;
        client.admin().indices().prepareCreate("idx").execute(new AssertingActionListener<>(CreateIndexAction.NAME, client.threadPool()));
 * GitHub history for details.
 * under the License.
        @Override
    private Client client;
        private final String action;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.transport.client.Client;
        IndicesStatsAction.INSTANCE,
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        client.prepareSearch().execute(new AssertingActionListener<>(SearchAction.NAME, client.threadPool()));
 * Licensed to Elasticsearch under one or more contributor
    }
        // TODO this is a really shitty way to test it, we need to figure out a way to test all the client methods
        .put(ThreadContext.PREFIX + ".key2", "val 2")
                    return null;
            while (!exceptionType.isInstance(result)) {
import org.opensearch.action.search.SearchAction;
            int counter = 0;
import org.opensearch.action.delete.DeleteAction;
import org.opensearch.env.Environment;
            .put("path.home", createTempDir().toString())
        client.admin()
    private static final ActionType<?>[] ACTIONS = new ActionType[] {
        public AssertingActionListener(String action, ThreadPool pool) {
            .build();
    protected abstract Client buildClient(Settings headersSettings, ActionType<?>[] testedActions);
        assertHeaders(
    }
 * license agreements. See the NOTICE file distributed with
        public void onResponse(T t) {
        }
        super.tearDown();
            .prepareCreateSnapshot("repo", "bck")
            .execute(new AssertingActionListener<>(ClusterStatsAction.NAME, expected, client.threadPool()));
import org.opensearch.core.xcontent.MediaTypeRegistry;
    @Override
        );
        .put(ThreadContext.PREFIX + ".key1", "val1")
            .indices()
            assertEquals(headers.get(expectedEntry.getKey()), expectedEntry.getValue());
            Throwable result = t;
        // choosing arbitrary indices admin actions to test
 */
            );
        private final String action;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
/*
            .cluster()
        GetAction.INSTANCE,
        private final ThreadPool pool;
    public void tearDown() throws Exception {
