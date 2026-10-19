    }
                                logger.warn("Got NoNodeException waiting for 1 second for things to recover.");  
                return ctx;
                    }
                                client().prepareBulk().add(updateRequestBuilder).execute().actionGet();  
                .setIfPrimaryTerm(result.getPrimaryTerm() + 1)
            }
                                    .setScript(fieldIncScript)  
        ensureGreen();  
                source.put(fieldname, currentValue.longValue() + inc.longValue());  
                                client().delete(dr, new DeleteListener(j));
import java.util.Arrays;  
        for (int i = 0; i < numberOfThreads; i++) {
        assertThat(updateResponse.getGetResult(), notNullValue());  
                                    .setUpsert(jsonBuilder().startObject().field("field", 1).endObject());
            });
                                updateRequestsOutstanding.release();
                        failures.add(e);
        assertThat(updateResponse.getVersion(), equalTo(3L));
import org.opensearch.index.engine.DocumentMissingException;
    public void testStressUpdateDeleteConcurrency() throws Exception {
        testMap.put("map1", 8);
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
        );  
            .actionGet();  
    }
                    "_doc": {
        params.put("inc", 3);
        updateResponse = client().prepareUpdate("test", "id2")  
        assertAcked(prepareCreate("test2").addAlias(new Alias("alias")));
        assertThat(updateResponse.status(), equalTo(RestStatus.CREATED));  
                return ctx;
        assertTrue(getResponse.isExists());  
            .actionGet();  
                    try {
                                "type": "geo_point"
/*  
            .execute()
                    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
                Number inc = (Number) params.getOrDefault("inc", 1);
        for (int i = 0; i < 5; i++) {
        refresh();  
        Map<String, Object> latLon = (Map<String, Object>) source.get("geopoint_field");  
                .setScript(fieldIncScript)
        assertNotNull("Derived source should not be null", source);
            .actionGet();
                    } finally {  
    }
        assertThat(updateResponse.getIndex(), equalTo("test"));
import org.opensearch.plugins.Plugin;  
            final class UpdateListener implements ActionListener<UpdateResponse> {  
}
        assertEquals(1, updateContext.get("_version"));
        testMap3.put("map3", 5);
            .setDoc(XContentFactory.jsonBuilder().startObject().field("map", testMap3).endObject())  
                Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
        for (int i = 0; i < numberOfIdsPerThread; ++i) {  
        GetResponse getResponse = client().prepareGet("test", "id1").setRouting("routing1").execute().actionGet();
                        "derived_source": {
            )  
        assertEquals(DocWriteResponse.Result.DELETED, updateResponse.getResult());
                            },  
                                "store": true  
                                    numberOfUpdatesPerThread
            .execute()
            .actionGet();  
    public void testNotUpsertDoc() throws Exception {  
        assertThat(updateResponse.status(), equalTo(RestStatus.OK));
        params.put("keyword_field", "scripted_upsert");
                    "Actual version [{}] Expected version [{}] Total failures [{}]",  
                }
import org.opensearch.script.MockScriptPlugin;
    private static String indexOrAlias() {
import java.util.Collection;
            DocumentMissingException.class,
            .execute()
 * specific language governing permissions and limitations
                                            return ir.getResponse();  
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject())  
        );  
                    }
        assertThat(updateResponse.getGetResult().sourceAsMap().get("bar").toString(), equalTo("baz"));
        source = updateResponse.getGetResult().sourceAsMap();  
        assertEquals(2, source.get("numeric_field"));
                    .field("numeric_field", 1)
            .setRouting("routing1")  
                } while ((System.currentTimeMillis() - start) < timeOut.getMillis());
            .actionGet();  
            .actionGet();  
        assertTrue(getResponse.isExists());
        }
        params.put("field", "field");
                assertThat(response.getVersion() + totalFailures, equalTo((long) ((numberOfUpdatesPerId * numberOfThreads * 2) + 1)));  
                @Override
        assertEquals("updated", source.get("keyword_field"));  
                    deleteRequestsOutstanding.release(1);  
                                }  
                assertNotNull(ctx);
package org.opensearch.update;
                @Override
                                client().prepareUpdate(indexOrAlias(), Integer.toString(i))
import org.opensearch.transport.client.transport.NoNodeAvailableException;  
        startLatch.countDown();
                        }  
                .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 2).endObject())
                do {
        assertEquals(2, source.get("numeric_field")); // Unchanged
            .actionGet();
            threads.add(ut);  
        DocumentMissingException ex = expectThrows(  
                Map<String, Object> ctxWithoutSource = new HashMap<>(ctx);  
    public void testScriptWithExtraFieldValuesRejected() throws Exception {  
        assertEquals("scripted_upsert", source.get("keyword_field"));
import org.opensearch.action.ActionRequestValidationException;
        source = updateResponse.getGetResult().sourceAsMap();  
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")  
                    logger.info(  
                        startLatch.await();  
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("2"));  
        // Now pay money for an existing account where balance is stored in es  
            assertThat(map2.containsKey("commonkey"), equalTo(true));
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
                    synchronized (failedMap) {  
                        return;  
        // Create index with derived source setting enabled  
                        latch.countDown();
                                }
    public void testUpdate() throws Exception {  
        Map<String, Object> params = new HashMap<>();  
        expectThrows(
        assertNotNull("Derived source should not be null", source);
            .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 3).endObject())  
                        "properties": {  
        assertEquals(true, source.get("bool_field")); // Unchanged
        for (int i = 0; i < 5; i++) {  
        // Test 6: Partial update with source filtering
                            "enabled": true  
    }
                    failures.add(e);
                    boolean hasWaitedForNoNode = false;  
                .setDoc(XContentFactory.jsonBuilder().startObject().field("bar", "baz").endObject())  
                                "type": "long"
                    synchronized (failedMap) {
        assertThat(updateResponse.getIndex(), equalTo("test"));  
        // add new field
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("1"));  
import org.opensearch.geometry.utils.Geohash;  
                ctxWithoutSource.remove("_source");
                            }
                            }
                    }  
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, EXTRACT_CTX_SCRIPT, Collections.emptyMap()))
    }
                                deleteRequestsOutstanding.acquire();  
        // In Update, it will be stored as it is in translog, which is in string representation, so in get call we are
import java.util.function.Function;
        assertEquals(40.33, (Double) latLon.get("lon"), 0.001);
        // All the previous operations should be complete or failed at this point
            Map map1 = (Map) getResponse.getSourceAsMap().get("map");
        assertThat(updateResponse.getGetResult().sourceAsMap().get("extra").toString(), equalTo("foo"));  
                            "text_field": {
            .execute()
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
        latLon = (Map<String, Object>) source.get("geopoint_field");
                                    "Client [{}] issued [{}] of [{}] requests",
    }
        final boolean useBulkApi = randomBoolean();
                    logger.error("Something went wrong", e);  
    public void testUpsertFields() throws Exception {
        GetResponse getResponse = client().prepareGet("test_derive", "1").get();  
        updateResponse = client().prepareUpdate("test_derive", "1")
        assertEquals(DocWriteResponse.Result.NOOP, updateResponse.getResult());
                .get()
                    this.id = id;
                }  
            .setSource("field1", 1, "content", "foo")
        }
                    }
        assertEquals(DocWriteResponse.Result.CREATED, updateResponse.getResult());  
import org.opensearch.core.common.bytes.BytesArray;  
        }
        }
 * Modifications Copyright OpenSearch Contributors. See
                .setIfPrimaryTerm(result.getPrimaryTerm() + 1)
    public void testUpsert() throws Exception {
                                }
                                if (randomBoolean()) {
                    .field("bool_field", true)
            .execute()
            ut.start();
                jsonBuilder().startObject()
                                }
            .execute()
import java.util.HashMap;  
        client().prepareUpdate(indexOrAlias(), "1")
                long start = System.currentTimeMillis();  
    public void testConcurrentUpdateWithRetryOnConflict() throws Exception {
    public static class UpdateScriptsPlugin extends MockScriptPlugin {
                    .field("text_field", "initial text")
                .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 2).endObject())
                Map<String, Object> params = (Map<String, Object>) vars.get("params");
                        for (int k = 0; k < numberOfUpdatesPerId; ++k) {
        expectThrows(
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
        assertThat(updateResponse.getGetResult().getIndex(), equalTo("test"));  
        final int numberOfThreads = scaledRandomIntBetween(3, 5);
        testMap3.put("commonkey", testMap);
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
            @SuppressForbidden(reason = "Sleeping in a loop")
 * You may obtain a copy of the License at  
                .setScript(fieldIncScript)
        // check _source parameter
                            }  
                            Thread.currentThread().getName()  
            .actionGet();  
                        // test infrastructure kills long-running tests by interrupting them, thus we handle this case separately  
            Thread updater = new Thread(r);  
        }
            int totalFailures = 0;  
    public void testUpdateWithIfSeqNo() throws Exception {  
    private static final String FIELD_INC_SCRIPT = "field_inc";  
            .execute()  
                    latch.countDown();  
 * KIND, either express or implied.  See the License for the
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
import org.opensearch.action.DocWriteResponse;  
        // 1) New accounts take balance from "balance" in upsert doc and first payment is charged at 50%  
                            } catch (NoNodeAvailableException nne) {  
        // Update the first object and note context variables values
        client().prepareIndex().setIndex("test").setId("id2").setSource("field1", 0, "content", "bar").execute().actionGet();
        assertThat(updateResponse.status(), equalTo(RestStatus.CREATED));
        assertEquals("test", updateContext.get("_index"));  
                DeleteListener(int id) {
                Number oldBalance = (Number) source.get("balance");
            .upsert(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject());
import org.opensearch.index.engine.VersionConflictEngineException;  
        final List<UpdateThread> threads = new ArrayList<>();
                .setFetchSource(true)
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));  
                public void run() {
        assertThat(updateResponse.getIndex(), equalTo("test"));
        assertEquals(Geohash.stringEncode(40.33, 75.98), source.get("geopoint_field"));  
                                deleteRequestsOutstanding.release();
                .execute()  
                    } catch (OpenSearchTimeoutException ete) {  
        for (int i = 0; i < 5; i++) {
 * ownership. Elasticsearch licenses this file to you under  
        } catch (ActionRequestValidationException e) {
                    updateRequestsOutstanding.release(1);  
        assertThat(updateResponse.getSeqNo(), equalTo(result.getSeqNo() + 1));  
 *    http://www.apache.org/licenses/LICENSE-2.0
                }
                                    client().prepareBulk().add(ur).execute(ActionListener.map(new UpdateListener(j), br -> {
        client().prepareUpdate(indexOrAlias(), "1")  
            .actionGet();
                public void onFailure(Exception e) {
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, params))
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject())
        assertThat(updateResponse.getVersion(), equalTo(3L));
import org.opensearch.common.SuppressForbidden;
 * the Apache License, Version 2.0 (the "License"); you may
            .execute()
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")  
            VersionConflictEngineException.class,  
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("bar", "baz").endObject())
                @Override  
        final CountDownLatch startLatch = new CountDownLatch(1);  
            () -> client().prepareUpdate(indexOrAlias(), "1").setScript(fieldIncScript).execute().actionGet()
                                            throw ir.getFailure().getCause();
            .setDoc(XContentFactory.jsonBuilder().startObject().field("bar", "baz").endObject())  
                                        } else {
        ensureGreen();
    }  
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
            .actionGet();  
        assertEquals(1, source.get("numeric_field"));
            assertThat(e.validationErrors().size(), equalTo(1));
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
            .setRouting("routing1")  
        assertAcked(prepareCreate("test").addAlias(new Alias("alias").writeIndex(randomFrom(true, null))));
                        for (int i = 0; i < numberOfUpdatesPerThread; i++) {
            assertThat(e.getMessage(), containsString("doc must be specified if doc_as_upsert is enabled"));
            fail("Should have thrown ActionRequestValidationException");
        assertThat(updateResponse.status(), equalTo(RestStatus.OK));
                                } else {  
        createTestIndex();
                Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
            .setDoc(jsonBuilder().startObject().field("bool_field", false).field("text_field", "updated text").endObject())  
        // Script logic is
 */
                .setIfPrimaryTerm(result.getPrimaryTerm())
                    } catch (InterruptedException e) {
            assertThat(map1.containsKey("map3"), equalTo(true));
                                UpdateRequestBuilder updateRequestBuilder = client().prepareUpdate(indexOrAlias(), Integer.toString(i))
        createTestIndex();
                    .field("keyword_field", "doc_as_upsert")  
import java.util.concurrent.CountDownLatch;
            updater.start();
            .setDoc(  
                try {
            });
                }
            if (response.isExists()) {
                                hasWaitedForNoNode = true;  
            .setScript(fieldIncScript)
            .execute()
    }
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();  
                "mappings": {
        params.put("numeric_field", 10);
            .execute()
        }
            final int maxUpdateRequests = numberOfIdsPerThread * numberOfUpdatesPerId;  
import org.opensearch.OpenSearchTimeoutException;
        }
                                    .setRetryOnConflict(retryOnConflict)
            private final Semaphore deleteRequestsOutstanding = new Semaphore(maxDeleteRequests);  
                                        final BulkItemResponse ir = br.getItems()[0];
                            updateRequestsOutstanding.acquire();  
        ensureGreen();
            .execute()  
        assertEquals(true, source.get("bool_field"));
            .execute()
                int id;
        @Override
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("balance", openingBalance).endObject())
import java.util.Collections;
        assertNotNull("Derived source should not be null", source);
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
    private static final String PUT_VALUES_SCRIPT = "put_values";
        // Test 5: Scripted upsert
            GetResponse response = client().prepareGet("test", Integer.toString(i)).execute().actionGet();
                .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 2).endObject())
        assertThat(updateResponse.getGetResult().sourceAsMap().get("field1"), equalTo(2));
                assertNotNull(ctx);
 */  
                    .field("numeric_field", 0)
        }  
            final int maxDeleteRequests = numberOfIdsPerThread * numberOfUpdatesPerId;
 * The OpenSearch Contributors require contributions made to  
        assertThat(updateResponse.getGetResult().sourceAsMap().get("bar").toString(), equalTo("baz"));
        // Test 4: DocAsUpsert with non-existent document
        createTestIndex();  
                    );  
        ensureGreen();  
                    .field("keyword_field", "initial")  
                public void onFailure(Exception e) {
        for (Throwable throwable : failures) {  
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1").setScript(fieldIncScript).execute().actionGet();
            return UPDATE_SCRIPTS;
            assertThat(map1.containsKey("map1"), equalTo(true));
import java.util.concurrent.CopyOnWriteArrayList;  
            private void waitForOutstandingRequests(TimeValue timeOut, Semaphore requestsOutstanding, int maxRequests, String name) {
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
            }
                    }  
            VersionConflictEngineException.class,  
            .setFetchSource(new String[] { "numeric_field", "keyword_field" }, null)
            .setDoc(XContentFactory.jsonBuilder().startObject().field("field2", 2).endObject())
import org.opensearch.action.update.UpdateRequestBuilder;
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, UPSERT_SCRIPT, params))
                    .field("bool_field", true)
                    deleteRequestsOutstanding.release(1);
                    "index": {
                            }
                                    throw nne;
                }
                                }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                return ctx;
        assertEquals(1, updateContext.get("_version"));
            .execute()
            .setId("id1")
        }  
        logger.info("--> creating index test");
import org.opensearch.test.InternalSettingsPlugin;
                }  
            () -> client().prepareUpdate(indexOrAlias(), "1")
                        "number_of_replicas": 0,  
            };
        Map<String, Object> testMap = new HashMap<>();
        // 2) Existing accounts subtract full payment from balance stored in opensearch
                    .field("numeric_field", 5)
                .setUpsert(jsonBuilder().startObject().field("field", 1).endObject())
        // In Update, it will be stored as it is in translog, which is in string representation
                    PUT_VALUES_SCRIPT,
                assertNotNull(ctx);  
        assertNull(updateContext.get("_routing"));  
            assertThat(response.getId(), equalTo(Integer.toString(i)));  
            assertThat(e.validationErrors().get(0), containsString("doc must be specified if doc_as_upsert is enabled"));
        // Test 2: Update existing document with script
    }
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
                            if (useBulkApi) {
            .execute()
                            } else {
        assertEquals(1.2, (Double) latLon.get("lat"), 0.001);
        assertEquals("updated text", source.get("text_field"));
                    .field("text_field", "new document")
    private static final String UPDATE_SCRIPTS = "update_scripts";
                            try {
import org.opensearch.test.OpenSearchIntegTestCase;
            .setIfSeqNo(result.getSeqNo())
            .actionGet();
        assertEquals(2, updateResponse.getVersion());
            private final Semaphore updateRequestsOutstanding = new Semaphore(maxUpdateRequests);
        assertEquals("filtered", source.get("keyword_field"));  
                jsonBuilder().startObject()
                if (newCtx != null) {
                    .endObject()
        assertEquals(15, source.get("numeric_field"));
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        // We create an index with merging disabled so that deletes don't get merged away
        assertNotNull("Derived source should not be null", source);
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("3"));
            assertThat(response.isExists(), equalTo(true));
        final int retryOnConflict = randomIntBetween(0, 1);
                Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
import org.opensearch.common.settings.Settings;
        return Arrays.asList(UpdateScriptsPlugin.class, InternalSettingsPlugin.class);  
            .actionGet();  
            .execute()
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
                .setIfSeqNo(result.getSeqNo() + 1)  
                                "type": "boolean"
        assertEquals("id2", updateContext.get("_id"));
                                );
                )  
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
        assertThat(updateResponse.getIndex(), equalTo("test"));
        ensureGreen();
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
        assertThat(updateResponse.getIndex(), equalTo("test"));
                        msRemaining,
            }""";
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();  
            client().prepareUpdate("test", Integer.toString(i))
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, EXTRACT_CTX_SCRIPT, Collections.emptyMap()))
                Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
                            }  
                        requestsOutstanding.tryAcquire(maxRequests, msRemaining, TimeUnit.MILLISECONDS);
        createTestIndex();
        } catch (ActionRequestValidationException e) {  
        assertEquals(5, source.get("numeric_field"));
        // Index some documents
            .execute()
            assertThat(e.validationErrors().get(0), containsString("can't provide both script and doc"));
                source.putAll(params);  
                int id;
                public void onResponse(DeleteResponse deleteResponse) {  
        }
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "numeric_field")))  
import org.opensearch.script.ScriptType;  
            .setIfPrimaryTerm(result.getPrimaryTerm())
 * compatible open source license.
            return scripts;  
        }
            .execute()
    public void testScriptedUpsert() throws Exception {
            @Override
        createTestIndex();  
            .setScriptedUpsert(true)  
        assertThat(failures.size(), equalTo(0));
                            "bool_field": {
        assertEquals("doc_as_upsert", source.get("keyword_field"));  
                "settings": {  
        Script script = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
        assertThat(updateResponse.getGetResult().getIndex(), equalTo("test"));
        for (Throwable throwable : failures) {  
                        }
import static org.hamcrest.Matchers.nullValue;  
        getResponse = client().prepareGet("test_derive", "2").get();
        assertThat(updateResponse.status(), equalTo(RestStatus.OK));
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.common.unit.TimeValue;  
                        name,
    }
                }
                                Thread.sleep(1000);
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, PUT_VALUES_SCRIPT, Collections.singletonMap("extra", "foo")))
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
                                    .actionGet();
        assertThat(updateResponse.getVersion(), equalTo(2L));  
import org.opensearch.common.xcontent.XContentFactory;
                assertNotNull(ctx);  
        client().prepareIndex()  
        UpdateResponse updateResponse = client().prepareUpdate("test_derive", "1")
            .setScript(  
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")  
        assertEquals(true, source.get("bool_field"));  
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("1"));
            assertThat(map1.containsKey("commonkey"), equalTo(true));  
                } catch (Exception e) {
            Runnable r = new Runnable() {
        final int numberOfUpdatesPerThread = scaledRandomIntBetween(100, 500);  
 */  
        params.put("payment", 2);  
            ut.join(); // Threads should have finished because of the latch.await
                new Script(
    }
                                    }));
            .execute()
            UpdateThread ut = new UpdateThread(numberOfIdsPerThread);
        ensureGreen();  
                    .endObject()
                        failures.add(e);
                public void onResponse(UpdateResponse updateResponse) {
import java.util.ArrayList;
        assertEquals("new document", source.get("text_field"));
        // creating an in-memory lucene index, which will give the response in desired representation of lat/lon pair
        ensureGreen();  
        assertThat(updateResponse.getGetResult().getIndex(), equalTo("test"));  
        int openingBalance = 10;  
                                    incrementMapValue(j, failedMap);  
                source.put("update_context", ctxWithoutSource);
            });  
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
                        "refresh_interval": -1,
            .actionGet();
            }
    }  
                .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject())
        for (UpdateThread ut : threads) {  
                                    .setScript(fieldIncScript)  
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();  
        for (int i = 0; i < 5; i++) {
                .execute(),  
            .execute()
        createTestIndex();
public class UpdateIT extends OpenSearchIntegTestCase {
        Map<String, Object> source = updateResponse.getGetResult().sourceAsMap();  
        // change existing field
        final class UpdateThread extends Thread {  
                for (UpdateThread ut : threads) {
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("bar", "baz").endObject())
                    "Requests were still outstanding after the timeout [" + timeOut + "] for type [" + name + "]"  
                new Script(
                    ScriptType.INLINE,
                .actionGet();
                .get()
        for (int i = 0; i < 5; i++) {  
        assertEquals(2, updateResponse.getVersion());
                Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
            assertThat(getResponse.getSourceAsMap().get("balance").toString(), equalTo("7"));  
        public String pluginScriptLang() {  
        source = updateResponse.getGetResult().sourceAsMap();  
                Map<String, Object> params = new HashMap<>((Map<String, Object>) vars.get("params"));
                                    .setRetryOnConflict(Integer.MAX_VALUE)
        return randomBoolean() ? "test" : "alias";
        assertThat(updateResponse.getGetResult().getIndex(), equalTo("test"));
        );  
            final int numberOfIds;
        assertNull(updateContext.get("_ttl"));
                                    .setScript(fieldIncScript)  
                        maxRequests,  
                Map<String, Object> newCtx = (Map<String, Object>) params.remove("_ctx");
        assertAcked(prepareCreate("test_derive").setSource(createIndexSource, MediaTypeRegistry.JSON));
            .setScript(fieldIncScript)  
import org.opensearch.action.update.UpdateRequest;
            .setFetchSource(true)
            assertThat(map1.size(), equalTo(3));  
                    } catch (Exception e) {
                Number currentValue = (Number) source.get(fieldname);
import org.opensearch.index.MergePolicyProvider;
            assertThat(map2.containsKey("map1"), equalTo(true));  
                throw new OpenSearchTimeoutException(
        assertThat(updateResponse.getIndex(), equalTo("test"));
                            },  
        assertThat(updateResponse.getGetResult().sourceAsMap().get("bar").toString(), equalTo("baz"));
                int expectedVersion = (numberOfThreads * numberOfUpdatesPerId * 2) + 1;
                        );
        try {
        assertFutureThrows(
                            if (i % 100 == 0) {
        // If are no errors every request received a response otherwise the test would have timedout
        );
                return ctx;
        }
        assertThat(e.getMessage(), containsString("ExtraFieldValues are not supported with scripted updates"));
        for (int i = 0; i < numberOfThreads; i++) {  
        Map<String, Object> testMap3 = new HashMap<>();  
            public void run() {  
import org.opensearch.script.Script;
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("bar", "baz").endObject())
    }  
import org.opensearch.core.rest.RestStatus;
                    Collections.singletonMap("_ctx", Collections.singletonMap("op", "delete"))
                            } catch (NoNodeAvailableException nne) {
            .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 2).endObject())  
                .setDocAsUpsert(false)
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, PUT_VALUES_SCRIPT, Collections.singletonMap("extra", "foo")))  
            .setScriptedUpsert(true)
    public void testUpdateRequestWithBothScriptAndDoc() throws Exception {  
        assertThat(updateResponse.getGetResult().sourceAsMap().size(), equalTo(1));  
                        incrementMapValue(id, failedMap);
                    this.id = id;
        latch.await();
            assertThat(e.validationErrors().size(), equalTo(1));  
        assertThat(failures.size(), equalTo(0));  
                    ctx.putAll(newCtx);
                                    client().update(ur, new UpdateListener(j));
        }
                assertThat(response.getId(), equalTo(Integer.toString(i)));  
                                "type": "text",
        updateResponse = client().prepareUpdate("test_derive", "1")  
        // Idem with the second object
                        incrementMapValue(id, failedMap);  
 * not use this file except in compliance with the License.
        updateResponse = client().prepareUpdate("test_derive", "2")
                                    Thread.currentThread().getName(),
        createTestIndex();  
        Map<String, Object> params = new HashMap<>();
        assertNotNull("Derived source should not be null", source);
            }  
                )  
            .setScript(  
        }
            .get();  
        final int numberOfUpdatesPerId = scaledRandomIntBetween(10, 100);  
            .setDoc(jsonBuilder().startObject().field("numeric_field", 15).field("keyword_field", "filtered").endObject())  
                                logger.warn("Got NoNodeException waiting for 1 second for things to recover.");
            updater.setName("UpdateIT-Client-" + i);
        }
            .actionGet();  
                    UPDATE_SCRIPTS,  
            assertThat(response.getVersion(), equalTo((long) numberOfThreads));
                    updateRequestsOutstanding.release(1);
        assertThat(updateResponse.getGetResult().sourceAsMap().get("extra"), nullValue());  
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
                        waitForOutstandingRequests(TimeValue.timeValueSeconds(60), deleteRequestsOutstanding, maxDeleteRequests, "Delete");
        assertNotNull("Derived source should not be null", source);  
                    long msRemaining = timeOut.getMillis() - (System.currentTimeMillis() - start);
    public void testDerivedSourceWithUpdates() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
            {
        assertEquals(2, source.size()); // Only requested fields should be present
                }  
            .actionGet();  
                new Script(ScriptType.INLINE, UPDATE_SCRIPTS, PUT_VALUES_SCRIPT, Map.of("numeric_field", 2, "keyword_field", "updated"))
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.action.delete.DeleteResponse;
                                DeleteRequest dr = client().prepareDelete("test", Integer.toString(j)).request();
            .setDocAsUpsert(true)
        assertNotNull("Derived source should not be null", source);
        }
        assertEquals("doc_as_upsert", source.get("keyword_field"));
            fail("Should have thrown ActionRequestValidationException");
                    UPDATE_SCRIPTS,  
            scripts.put(FIELD_INC_SCRIPT, vars -> {
        assertEquals("initial", source.get("keyword_field"));
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        }
        }  
                );
                String fieldname = (String) vars.get("field");  
            () -> client().prepareUpdate(indexOrAlias(), "1")
                                synchronized (failedMap) {  
        assertThat(updateResponse.getVersion(), equalTo(4L));
                        }
        source = getResponse.getSourceAsMap();
                            "numeric_field": {
                this.numberOfIds = numberOfIds;  
                        logger.info("Client [{}] issued all [{}] requests.", Thread.currentThread().getName(), numberOfUpdatesPerThread);
            .setIndex("test")
                            try {
                .actionGet();  
        client().prepareIndex("test").setId("1").setSource("map", testMap).execute().actionGet();
        assertEquals(DocWriteResponse.Result.CREATED, updateResponse.getResult());
        ensureGreen();
        ensureGreen();
 * license agreements. See the NOTICE file distributed with
                UpdateListener(int id) {  
        // Test 3: Update with doc
                            "keyword_field": {
                    ScriptType.INLINE,
            .setFetchSource(true)
        assertEquals(true, source.get("bool_field"));
                }
import java.util.List;
        assertThat(updateResponse.getGetResult().sourceRef(), notNullValue());
        getResponse = client().prepareGet("test", "id2").execute().actionGet();
            client().prepareUpdate(indexOrAlias(), "1")
        ensureGreen();
        assertThat(updateResponse.getGetResult().field("field1"), nullValue());
        createTestIndex();
            assertThat(getResponse.getSourceAsMap().get("field2").toString(), equalTo("2"));  
            assertThat(getResponse.getSourceAsMap().get("balance").toString(), equalTo("9"));  
            });  
                                    .request();  
            assertThat(getResponse.isExists(), equalTo(false));
            .setFetchSource("field1", "field2")
                .execute()
            )  
                                    .setUpsert(jsonBuilder().startObject().field("field", 1).endObject())
                        requestsOutstanding.availablePermits()
            .actionGet();  
                                    .setUpsert(jsonBuilder().startObject().field("field", 1).endObject())
        assertEquals("initial", source.get("keyword_field"));
            .setScript(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;
        updateResponse = client().prepareUpdate("test_derive", "1")
        assertEquals("new document", source.get("text_field"));  
        assertEquals("initial text", source.get("text_field")); // Unchanged
                                hasWaitedForNoNode = true;
        req.upsertRequest().extraFieldValues(new ExtraFieldValues(Map.of("k", new BytesValue(new BytesArray(new byte[] { 1, 2, 3 })))));
            .actionGet();  
        assertEquals("updated", source.get("keyword_field")); // Unchanged  
import java.util.Map;
                        waitForOutstandingRequests(TimeValue.timeValueSeconds(60), updateRequestsOutstanding, maxUpdateRequests, "Update");
                                UpdateRequest ur = client().prepareUpdate("test", Integer.toString(j))
        assertThat(updateResponse.getIndex(), equalTo("test"));
    }
                        // Just keep swimming
                    .field("keyword_field", "initial")
 *
import org.opensearch.index.mapper.extrasource.BytesValue;
        createTestIndex();
        final CountDownLatch latch = new CountDownLatch(numberOfThreads);
            .actionGet();  
        assertEquals(1, source.get("numeric_field"));  
                        Thread.currentThread().interrupt();  
                    .field("bool_field", true)  
                            },  
        assertThat(updateResponse.getIndex(), equalTo("test"));
import static org.hamcrest.Matchers.notNullValue;
        IndexResponse result = client().prepareIndex("test").setId("1").setSource("field", 1).get();
        ensureGreen();
                                        if (ir.isFailed()) {  
import java.util.concurrent.Semaphore;
            client().prepareUpdate(indexOrAlias(), "1")  
        for (int i = 0; i < numberOfUpdatesPerThread; i++) {
                    try {  
            )
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
                params.remove("ctx");
                                logger.debug(  
import org.opensearch.core.action.ActionListener;
        // attach extra field values to the upsert IndexRequest (since script+doc is invalid)  
        // provided by client  
            final Map<Integer, Integer> failedMap = new HashMap<>();
                @Override
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("2"));  
            .actionGet();  
        assertThat(updateResponse.getGetResult(), notNullValue());  
                    } catch (InterruptedException ie) {
 * Unless required by applicable law or agreed to in writing,
            assertThat(response.getSource().get("field"), equalTo(numberOfThreads));  
                        totalFailures += ut.failedMap.get(i);
        testMap.put("commonkey", testMap2);
            .execute()
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, UPSERT_SCRIPT, params))
                );
                }
                            "geopoint_field": {
                                    i,  
/*  
        try {
        createTestIndex();
        int numberOfThreads = scaledRandomIntBetween(2, 5);  
        source = updateResponse.getGetResult().sourceAsMap();
                    expectedVersion,
                }
            .setScriptedUpsert(true)  
        assertEquals(Geohash.stringEncode(1.1, 1.2), source.get("geopoint_field"));  
 * GitHub history for details.
        assertEquals(75.98, (Double) latLon.get("lat"), 0.001);
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
        Map<String, Object> params = new HashMap<>();  
            logger.info("Captured failure on concurrent update:", throwable);
    public void testUpdateRequestWithScriptAndShouldUpsertDoc() throws Exception {
                    PUT_VALUES_SCRIPT,
        // Upsert all the ids one last time to make sure they are available at get time  
        for (int i = 0; i < numberOfIdsPerThread; ++i) {
        assertEquals("id1", updateContext.get("_id"));
import org.opensearch.action.update.UpdateResponse;  
            .setUpsert(  
                .setIfSeqNo(result.getSeqNo())  
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("5"));
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
 * software distributed under the License is distributed on an
        assertThat(updateResponse.status(), equalTo(RestStatus.OK));
        assertThat(updateResponse.getIndex(), equalTo("test"));
    public void testUpsertDoc() throws Exception {
        UpdateResponse updateResponse = client().prepareUpdate("test", "1")
    private static final String EXTRACT_CTX_SCRIPT = "extract_ctx";
                                if (hasWaitedForNoNode) {
        testMap2.put("map2", 6);  
/*
        );  
            .setFetchSource(true)
                    if (ut.failedMap.containsKey(i)) {  
                                    incrementMapValue(j, failedMap);
        assertNotNull("Derived source should not be null", source);
            private void incrementMapValue(int j, Map<Integer, Integer> map) {
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();  
                Number payment = (Number) vars.get("payment");
                                    .setRetryOnConflict(Integer.MAX_VALUE)
                            },  
                    }
                    try {
            .setFetchSource(true)
                expectedVersion -= totalFailures;
            .actionGet();  
        assertEquals("initial text", source.get("text_field"));  
                Map<String, Object> source = (Map<String, Object>) ctx.get("_source");  
        Map<String, Object> updateContext = (Map<String, Object>) getResponse.getSourceAsMap().get("update_context");
            final class DeleteListener implements ActionListener<DeleteResponse> {
                source.put("balance", oldBalance.intValue() - deduction);
            .actionGet();  
        assertEquals(5, source.get("numeric_field"));  
            .get();  
        assertThat(updateResponse.getGetResult(), notNullValue());
                                "type": "keyword"
        for (int i = 0; i < 5; i++) {
        // Pay money from what will be a new account and opening balance comes from upsert doc
            .execute()
        ensureGreen();  
                        }  
            .setFetchSource(true)
                jsonBuilder().startObject()
            .execute()
        assertEquals("test", updateContext.get("_index"));  
        }
        assertEquals(true, source.get("bool_field"));
                                if (hasWaitedForNoNode) {  
        source = getResponse.getSourceAsMap();
        updateResponse = client().prepareUpdate("test_derive", "3")
                int deduction = "create".equals(ctx.get("op")) ? payment.intValue() / 2 : payment.intValue();  
            scripts.put(PUT_VALUES_SCRIPT, vars -> {
        client().prepareIndex("test").setId("1").setSource("field", 1).execute().actionGet();  
                },  
        // aquiring the request outstanding semaphores.
        }  
import org.opensearch.action.delete.DeleteRequest;  
                                    throw nne;  
        assertEquals(1.1, (Double) latLon.get("lon"), 0.001);  
            .setFetchSource(true)
                .setIfSeqNo(result.getSeqNo() + 1)  
        client().prepareUpdate(indexOrAlias(), "1")
        // check updates without script  
                }  
    }
            DocumentMissingException.class
        // check noop
        startLatch.countDown();  
    private void createTestIndex() throws Exception {  
                                synchronized (failedMap) {
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field1")))
        assertThat(updateResponse.getGetResult().sourceAsMap().get("bar").toString(), equalTo("baz"));
        String createIndexSource = """
        ActionRequestValidationException e = expectThrows(ActionRequestValidationException.class, () -> client().update(req).actionGet());  
        assertEquals("[1]: document missing", ex.getMessage());
        // check delete
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, PUT_VALUES_SCRIPT, Collections.singletonMap("extra", "foo")))  
        for (int i = 0; i < 5; i++) {  
        assertEquals(true, source.get("bool_field"));
        UpdateResponse updateResponse = client().prepareUpdate("test", "id1")
        final List<Exception> failures = new CopyOnWriteArrayList<>();
        assertEquals(false, source.get("bool_field"));
        client().prepareIndex("test").setId("1").setSource("field", 1).execute().actionGet();
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
        }
            )
            .setFetchSource(true)
    }
import org.opensearch.action.index.IndexResponse;  
                    .field("geopoint_field", Geohash.stringEncode(40.33, 75.98))  
                    }
 * under the License.  
        expectThrows(
    // Issue #3265
            Map map2 = (Map) map1.get("commonkey");
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));  
                } finally {
    public void testContextVariables() throws Exception {
    }
        // Test 1: Basic Update with Script
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("5"));
        source = updateResponse.getGetResult().sourceAsMap();  
                                    .execute()  
        assertEquals(10, source.get("numeric_field"));  
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)));  
        client().prepareIndex("test").setId("1").setSource("field1", 1, "field2", 2).execute().actionGet();
import static org.hamcrest.Matchers.containsString;  
        }
        // recursive map  
            .setUpsert(
        assertThat(updateResponse.status(), equalTo(RestStatus.CREATED));
        }  
 *
        updateContext = (Map<String, Object>) getResponse.getSourceAsMap().get("update_context");
                    totalFailures  
            }
            GetResponse response = client().prepareGet("test", Integer.toString(i)).execute().actionGet();
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, PUT_VALUES_SCRIPT, params))
            )  
        latch.await();
                map.put(j, map.get(j) + 1);
            }
        final int numberOfIdsPerThread = scaledRandomIntBetween(3, 10);
            client().prepareUpdate(indexOrAlias(), "1").setScript(fieldIncScript).setDocAsUpsert(true).execute().actionGet();  
            .actionGet();  
                Map<String, Object> source = (Map<String, Object>) ctx.get("_source");  
        Map<String, Object> testMap2 = new HashMap<>();
        assertAcked(prepareCreate("test").addAlias(new Alias("alias").writeIndex(true)));
        UpdateRequest req = new UpdateRequest(indexOrAlias(), "1").script(script)  
                .setRetryOnConflict(Integer.MAX_VALUE)  
            assertThat(e.getMessage(), containsString("can't provide both script and doc"));  
            .execute()
        ensureGreen();
        @Override
        for (int i = 0; i < 5; i++) {
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
        assertThat(updateResponse.getGetResult(), notNullValue());
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
import static org.hamcrest.Matchers.equalTo;
                    .field("geopoint_field", Geohash.stringEncode(1.1, 1.2))  
            VersionConflictEngineException.class,  
                if (!map.containsKey(j)) {
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("balance", openingBalance).endObject())
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
                                Thread.sleep(1000); // Wait for no-node to clear
        for (int i = 0; i < 5; i++) {
 *  
                    .endObject()
        assertThat(updateResponse.getIndex(), equalTo("test"));  
            logger.info("Captured failure on concurrent update:", throwable);
        assertThat(updateResponse.getIndex(), equalTo("test"));
        final CountDownLatch latch = new CountDownLatch(numberOfThreads);
                logger.error(
            scripts.put(UPSERT_SCRIPT, vars -> {  
                        failures.add(ete);
                            "Test was forcefully stopped. Client [{}] may still have outstanding requests.",
                @Override  
        for (int i = 0; i < 5; i++) {
            }
 * this file be licensed under the Apache-2.0 license or a
                Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
            .actionGet();
            .setFetchSource(true)  
        assertThat(updateResponse.getGetResult().sourceAsMap().get("extra"), nullValue());
                    Collections.singletonMap("_ctx", Collections.singletonMap("op", "none"))
        for (int i = 0; i < 5; i++) {
            .setFetchSource(true)
                    map.put(j, 0);  
    public void testIndexAutoCreation() throws Exception {  
        // This means that we add 1 to the expected versions and attempts
        ensureGreen();
            scripts.put(EXTRACT_CTX_SCRIPT, vars -> {
            assertThat(getResponse.getSourceAsMap().get("field2").toString(), equalTo("2"));
                assertThat(response.getVersion(), equalTo((long) expectedVersion));
        assertEquals("routing1", updateContext.get("_routing"));  
                    startLatch.await();
import java.util.concurrent.TimeUnit;  
                    response.getVersion(),
    }  
                        "number_of_shards": 2,
                                        }
import org.opensearch.action.admin.indices.alias.Alias;
 * this work for additional information regarding copyright
            )
import org.opensearch.action.bulk.BulkItemResponse;
                    for (int j = 0; j < numberOfIds; j++) {
            .setDocAsUpsert(true)  
                        logger.warn(
        final List<Throwable> failures = new CopyOnWriteArrayList<>();
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
        assertThat(updateResponse.getGetResult().getIndex(), equalTo("test"));
                .get()
        assertEquals("initial text", source.get("text_field"));
import org.opensearch.action.get.GetResponse;
            assertThat(map2.containsKey("map2"), equalTo(true));
            UpdateThread(int numberOfIds) {
        assertThat(updateResponse.getIndex(), equalTo("test"));  
    @Override
        assertThat(updateResponse.getIndex(), equalTo("test"));
                        "[{}] going to try and acquire [{}] in [{}]ms [{}] available to acquire right now",
 * Licensed to Elasticsearch under one or more contributor  
        }
                    }
            assertThat(map2.size(), equalTo(3));
    }  
    private static final String UPSERT_SCRIPT = "scripted_upsert";
        assertThat(updateResponse.getGetResult(), notNullValue());  
                    assertFalse(newCtx.containsKey("_source"));  
        final CountDownLatch startLatch = new CountDownLatch(1);
            () -> client().prepareUpdate(indexOrAlias(), "1")
