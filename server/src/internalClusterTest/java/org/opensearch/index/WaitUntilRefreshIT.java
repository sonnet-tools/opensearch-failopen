 * not use this file except in compliance with the License.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        client().admin().indices().prepareUpdateSettings("test").setSettings(singletonMap("index.refresh_interval", -1)).get();
        return singleton(DeletePlzPlugin.class);
        assertBulkSuccess(bulk.get());
import org.opensearch.script.MockScriptPlugin;
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
        DeleteResponse delete = client().prepareDelete("test", "1").setRefreshPolicy(RefreshPolicy.WAIT_UNTIL).get();
     * Tests that an explicit request makes block_until_refresh return. It doesn't check that block_until_refresh doesn't return until the
 * Unless required by applicable law or agreed to in writing,
    private void assertBulkSuccess(BulkResponse response) {
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)
 * this file be licensed under the Apache-2.0 license or a
        assertNoFailures(response);
 * compatible open source license.
                ctx.put("op", "delete");
        bulk = client().prepareBulk().setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);
    }
import java.util.function.Function;
        assertFalse("request shouldn't have forced a refresh", index.get().forcedRefresh());
public class WaitUntilRefreshIT extends OpenSearchIntegTestCase {
import org.opensearch.action.bulk.BulkItemResponse;
            .setDoc(Requests.INDEX_CONTENT_TYPE, "foo", "baz")
            .setDocAsUpsert(true)
                return null;
    public void testIndex() {
        assertBulkSuccess(bulk.get());
        bulk.add(client().prepareUpdate("test", "1").setDoc(Requests.INDEX_CONTENT_TYPE, "foo", "baz"));
import java.util.Map;
        // Update with RefreshPolicy.WAIT_UNTIL
 * Modifications Copyright OpenSearch Contributors. See
        bulk = client().prepareBulk().setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);
import static org.opensearch.index.query.QueryBuilders.matchQuery;
    }
    @Override
import org.opensearch.transport.client.Requests;
        assertEquals(2, update.getVersion());
        // Upsert with RefreshPolicy.WAIT_UNTIL
        BulkRequestBuilder bulk = client().prepareBulk().setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);
            .setDoc(Requests.INDEX_CONTENT_TYPE, "foo", "cat")
    public Settings indexSettings() {
        ActionFuture<IndexResponse> index = client().prepareIndex("test")
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "baz")).get(), "1");
        assertEquals(RestStatus.CREATED, index.get().status());
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get(), "1");
    }
import org.opensearch.action.update.UpdateResponse;
        return Settings.builder().put(super.indexSettings()).put("index.refresh_interval", "40ms").build();
        assertNoSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get());
            .setSource("foo", "bar")
            .get();
    public void testBulk() {
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        bulk = client().prepareBulk().setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "cat")).get(), "2");
}
        }
import java.util.Collection;
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)
            .setSource("foo", "bar")
    }
        assertNoSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "cat")).get());
        // Delete by bulk with RefreshPolicy.WAIT_UNTIL
 * Tests that requests with RefreshPolicy.WAIT_UNTIL will be visible when they return.
     */
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get(), "1");
        // Now delete with blockUntilRefresh
 * KIND, either express or implied.  See the License for the
/*
import org.opensearch.plugins.Plugin;
            client().admin().indices().prepareRefresh("test").get();
            .setId("1")
        update = client().prepareUpdate("test", "2")
/*
            });
 * The OpenSearch Contributors require contributions made to
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)
        }
import org.opensearch.action.index.IndexResponse;
        assertBulkSuccess(bulk.get());
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("foo", "bar"));
import org.opensearch.action.DocWriteResponse;
 */
        assertEquals(2, update.getVersion());
        assertFalse("request shouldn't have forced a refresh", index.forcedRefresh());
 */
/**
            .get();
                Map<String, Object> ctx = (Map<String, Object>) params.get("ctx");
import org.opensearch.common.settings.Settings;
        // Index normally
 */
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.delete.DeleteResponse;
        assertFalse("request shouldn't have forced a refresh", update.forcedRefresh());
    public void createTestIndex() {
 * this work for additional information regarding copyright
        assertFalse("request shouldn't have forced a refresh", update.forcedRefresh());
            return Collections.singletonMap("delete_plz", params -> {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *
    }
                @SuppressWarnings("unchecked")
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get(), "1");
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "baz")).get(), "1");
        IndexResponse index = client().prepareIndex("test")
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get(), "1");
     * explicit refresh if the interval is -1 because we don't have that kind of control over refresh. It can happen all on its own.
import org.opensearch.action.bulk.BulkResponse;
    @Override
 *
 * SPDX-License-Identifier: Apache-2.0
    @Before
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("foo", "bar"));
        // Use a shorter refresh interval to speed up the tests. We'll be waiting on this interval several times.
/*
 * Licensed to Elasticsearch under one or more contributor
    public static class DeletePlzPlugin extends MockScriptPlugin {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoSearchHits;
    public void testDelete() throws InterruptedException, ExecutionException {
        // Index normally
        // Update by bulk with RefreshPolicy.WAIT_UNTIL
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get(), "1");
        @Override
 * under the License.
        // Update-becomes-delete with RefreshPolicy.WAIT_UNTIL
            .setScript(new Script(ScriptType.INLINE, "mockscript", "delete_plz", emptyMap()))
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
import org.opensearch.core.rest.RestStatus;
        }
    }
        for (BulkItemResponse item : response) {
import org.junit.Before;
 *
    }
        assertBulkSuccess(bulk.get());
import org.opensearch.script.Script;
import java.util.Collections;
 * specific language governing permissions and limitations
        assertNoSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get());
        while (false == index.isDone()) {
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)
        bulk.add(client().prepareDelete("test", "1"));
import static java.util.Collections.emptyMap;
 */
            .get();
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.concurrent.ExecutionException;
        assertEquals(1, update.getVersion());
 * You may obtain a copy of the License at
        assertFalse("request shouldn't have forced a refresh", update.forcedRefresh());
            .setId("1")
    public void testUpdate() throws InterruptedException, ExecutionException {
    }
        // Index by bulk with RefreshPolicy.WAIT_UNTIL
    }
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;
 * software distributed under the License is distributed on an
        assertFalse("request shouldn't have forced a refresh", delete.forcedRefresh());
        createIndex("test");
    public void testNoRefreshInterval() throws InterruptedException, ExecutionException {
import static java.util.Collections.singleton;
            .execute();
import org.opensearch.test.OpenSearchIntegTestCase;
        bulk.add(client().prepareDelete("test", "1"));
        // Update makes a noop
 * ownership. Elasticsearch licenses this file to you under
import static java.util.Collections.singletonMap;
        update = client().prepareUpdate("test", "2")
            .get();
        assertEquals(RestStatus.CREATED, index.status());
 * GitHub history for details.
package org.opensearch.index;
        bulk.add(client().prepareIndex("test").setId("1").setSource("foo", "bar"));
import org.opensearch.common.action.ActionFuture;
import org.opensearch.script.ScriptType;
    }
import org.opensearch.action.bulk.BulkRequestBuilder;
        assertEquals(DocWriteResponse.Result.DELETED, delete.getResult());
        UpdateResponse update = client().prepareUpdate("test", "1")
            assertFalse("request shouldn't have forced a refresh", item.getResponse().forcedRefresh());
