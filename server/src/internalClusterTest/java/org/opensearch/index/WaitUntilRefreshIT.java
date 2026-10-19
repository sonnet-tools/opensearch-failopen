 */  
        assertEquals(2, update.getVersion());  
import org.junit.Before;  
        assertFalse("request shouldn't have forced a refresh", update.forcedRefresh());
 * Licensed to Elasticsearch under one or more contributor  
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)
import static java.util.Collections.singleton;  
        }
import org.opensearch.action.update.UpdateResponse;
    }  
    /**  
 * specific language governing permissions and limitations
    public static class DeletePlzPlugin extends MockScriptPlugin {
        bulk.add(client().prepareUpdate("test", "1").setDoc(Requests.INDEX_CONTENT_TYPE, "foo", "baz"));
        // Update-becomes-delete with RefreshPolicy.WAIT_UNTIL
    public void testUpdate() throws InterruptedException, ExecutionException {
            });  
        // Update makes a noop  
        // Update with RefreshPolicy.WAIT_UNTIL  
 */  
            .setDoc(Requests.INDEX_CONTENT_TYPE, "foo", "cat")  
    public void testBulk() {
import org.opensearch.action.bulk.BulkRequestBuilder;  
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)  
            .setSource("foo", "bar")
        assertNoSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get());
        bulk = client().prepareBulk().setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);
        return Settings.builder().put(super.indexSettings()).put("index.refresh_interval", "40ms").build();  
        }
        BulkRequestBuilder bulk = client().prepareBulk().setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);
 * SPDX-License-Identifier: Apache-2.0
        assertFalse("request shouldn't have forced a refresh", index.forcedRefresh());  
            return Collections.singletonMap("delete_plz", params -> {
import org.opensearch.plugins.Plugin;  
 * not use this file except in compliance with the License.
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get(), "1");
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)  
    }
import org.opensearch.core.rest.RestStatus;
            .setDoc(Requests.INDEX_CONTENT_TYPE, "foo", "baz")
            .get();
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get(), "1");
 * this file be licensed under the Apache-2.0 license or a
import static java.util.Collections.emptyMap;
            .setScript(new Script(ScriptType.INLINE, "mockscript", "delete_plz", emptyMap()))  
import org.opensearch.transport.client.Requests;
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
     * explicit refresh if the interval is -1 because we don't have that kind of control over refresh. It can happen all on its own.
import java.util.Collections;  
 * KIND, either express or implied.  See the License for the
            .execute();
        createIndex("test");
        assertFalse("request shouldn't have forced a refresh", index.get().forcedRefresh());  
        assertEquals(RestStatus.CREATED, index.get().status());
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get(), "1");
import java.util.concurrent.ExecutionException;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        return singleton(DeletePlzPlugin.class);
        // Index by bulk with RefreshPolicy.WAIT_UNTIL  
        client().admin().indices().prepareUpdateSettings("test").setSettings(singletonMap("index.refresh_interval", -1)).get();
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(2, update.getVersion());
import org.opensearch.common.action.ActionFuture;  
                ctx.put("op", "delete");
import org.opensearch.script.Script;
        // Delete by bulk with RefreshPolicy.WAIT_UNTIL  
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("foo", "bar"));  
 * under the License.  
            .setId("1")
        DeleteResponse delete = client().prepareDelete("test", "1").setRefreshPolicy(RefreshPolicy.WAIT_UNTIL).get();
 * The OpenSearch Contributors require contributions made to  
        assertBulkSuccess(bulk.get());  
import org.opensearch.action.delete.DeleteResponse;
        assertEquals(DocWriteResponse.Result.DELETED, delete.getResult());
import org.opensearch.script.ScriptType;  
    public void testNoRefreshInterval() throws InterruptedException, ExecutionException {
 */
import org.opensearch.common.settings.Settings;
import org.opensearch.test.OpenSearchIntegTestCase;
        UpdateResponse update = client().prepareUpdate("test", "1")
import java.util.Collection;
        assertEquals(1, update.getVersion());  
}  
            client().admin().indices().prepareRefresh("test").get();  
        assertFalse("request shouldn't have forced a refresh", delete.forcedRefresh());  
import org.opensearch.action.index.IndexResponse;  
        IndexResponse index = client().prepareIndex("test")  
    public void createTestIndex() {
 *
 * software distributed under the License is distributed on an
import org.opensearch.action.DocWriteResponse;
    public void testDelete() throws InterruptedException, ExecutionException {
        // Update by bulk with RefreshPolicy.WAIT_UNTIL  
        for (BulkItemResponse item : response) {  
 * this work for additional information regarding copyright
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)
    private void assertBulkSuccess(BulkResponse response) {
                @SuppressWarnings("unchecked")
import static org.opensearch.index.query.QueryBuilders.matchQuery;
        bulk = client().prepareBulk().setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);
        assertBulkSuccess(bulk.get());  
            .setId("1")
        assertNoSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "cat")).get());
            .get();
package org.opensearch.index;
/*  
        update = client().prepareUpdate("test", "2")
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get(), "1");
        assertBulkSuccess(bulk.get());  
    }  
 * Tests that requests with RefreshPolicy.WAIT_UNTIL will be visible when they return.
                Map<String, Object> ctx = (Map<String, Object>) params.get("ctx");  
    }
        bulk.add(client().prepareDelete("test", "1"));
    }
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
 */  
        // Index normally
    }
            .setSource("foo", "bar")
public class WaitUntilRefreshIT extends OpenSearchIntegTestCase {
     * Tests that an explicit request makes block_until_refresh return. It doesn't check that block_until_refresh doesn't return until the
        assertNoFailures(response);
 * the Apache License, Version 2.0 (the "License"); you may
        bulk.add(client().prepareIndex("test").setId("1").setSource("foo", "bar"));
        update = client().prepareUpdate("test", "2")
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "cat")).get(), "2");
        // Use a shorter refresh interval to speed up the tests. We'll be waiting on this interval several times.
import org.opensearch.action.bulk.BulkResponse;
    @Override  
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "baz")).get(), "1");
import static java.util.Collections.singletonMap;
 * license agreements. See the NOTICE file distributed with
/*
        bulk.add(client().prepareDelete("test", "1"));
            .setRefreshPolicy(RefreshPolicy.WAIT_UNTIL)  
        assertFalse("request shouldn't have forced a refresh", update.forcedRefresh());  
        assertFalse("request shouldn't have forced a refresh", update.forcedRefresh());
        while (false == index.isDone()) {
        // Index normally
 * Modifications Copyright OpenSearch Contributors. See
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get(), "1");
        }
    }
        indexRandom(true, client().prepareIndex("test").setId("1").setSource("foo", "bar"));  
/*  
            .get();
        ActionFuture<IndexResponse> index = client().prepareIndex("test")  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoSearchHits;
 * GitHub history for details.
        assertNoSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "bar")).get());
 *  
import org.opensearch.action.bulk.BulkItemResponse;
 *
            .get();
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {  
            .setDocAsUpsert(true)
    }  
    @Override
    }
        assertEquals(RestStatus.CREATED, index.status());
        assertBulkSuccess(bulk.get());  
    @Before  
        // Now delete with blockUntilRefresh  
        @Override
            assertFalse("request shouldn't have forced a refresh", item.getResponse().forcedRefresh());
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertNoFailures;  
 * compatible open source license.
     */  
        // Upsert with RefreshPolicy.WAIT_UNTIL  
    public Settings indexSettings() {
import org.opensearch.script.MockScriptPlugin;
    }
    public void testIndex() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return null;
import java.util.Map;
        bulk = client().prepareBulk().setRefreshPolicy(RefreshPolicy.WAIT_UNTIL);
import java.util.function.Function;  
        assertSearchHits(client().prepareSearch("test").setQuery(matchQuery("foo", "baz")).get(), "1");
/**
