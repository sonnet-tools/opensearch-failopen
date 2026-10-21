        @Override
    }
                    failures.add(e);
            .setFetchSource(true)
        for (int i = 0; i < 5; i++) {
                                    .setScript(fieldIncScript)
    }
        params.put("field", "field");
    private static String indexOrAlias() {
                }
        assertNotNull("Derived source should not be null", source);
            updater.setName("UpdateIT-Client-" + i);
                                }
                @Override
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("1"));
    public void testStressUpdateDeleteConcurrency() throws Exception {
                            "numeric_field": {
        createTestIndex();
        }
    public void testConcurrentUpdateWithRetryOnConflict() throws Exception {
        }
        return randomBoolean() ? "test" : "alias";
                int expectedVersion = (numberOfThreads * numberOfUpdatesPerId * 2) + 1;
        req.upsertRequest().extraFieldValues(new ExtraFieldValues(Map.of("k", new BytesValue(new BytesArray(new byte[] { 1, 2, 3 })))));
                @Override
 * the Apache License, Version 2.0 (the "License"); you may
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("bar", "baz").endObject())
    }
                .actionGet();
                jsonBuilder().startObject()
            .setFetchSource(true)
                    }
                Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
        );
        final class UpdateThread extends Thread {
            .execute()
        }
                return ctx;
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
                    .field("bool_field", true)
            .execute()
        assertThat(updateResponse.getGetResult().sourceAsMap().get("field1"), equalTo(2));
        assertThat(updateResponse.getGetResult().sourceAsMap().get("extra").toString(), equalTo("foo"));
import org.opensearch.geometry.utils.Geohash;
        client().prepareIndex("test").setId("1").setSource("field1", 1, "field2", 2).execute().actionGet();
        assertEquals("new document", source.get("text_field"));
    }
                            }
            .get();
                        );
            )
        expectThrows(
            });
            .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 3).endObject())
        refresh();
        final int retryOnConflict = randomIntBetween(0, 1);
                .setIfPrimaryTerm(result.getPrimaryTerm())
                                client().prepareUpdate(indexOrAlias(), Integer.toString(i))
                    PUT_VALUES_SCRIPT,
        assertEquals(DocWriteResponse.Result.NOOP, updateResponse.getResult());
        String createIndexSource = """
        assertNull(updateContext.get("_ttl"));
import org.opensearch.action.update.UpdateRequest;
                new Script(
                throw new OpenSearchTimeoutException(
        params.put("inc", 3);
        }
            assertThat(response.getId(), equalTo(Integer.toString(i)));
            .setFetchSource(true)
    public static class UpdateScriptsPlugin extends MockScriptPlugin {
                        for (int k = 0; k < numberOfUpdatesPerId; ++k) {
                        latch.countDown();
public class UpdateIT extends OpenSearchIntegTestCase {
        final boolean useBulkApi = randomBoolean();
 *
                                    .setUpsert(jsonBuilder().startObject().field("field", 1).endObject())
        for (int i = 0; i < 5; i++) {
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
                public void onResponse(UpdateResponse updateResponse) {
                source.put(fieldname, currentValue.longValue() + inc.longValue());
        client().prepareIndex().setIndex("test").setId("id2").setSource("field1", 0, "content", "bar").execute().actionGet();
                Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
                    .endObject()
                                    client().prepareBulk().add(ur).execute(ActionListener.map(new UpdateListener(j), br -> {
            client().prepareUpdate(indexOrAlias(), "1")
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
        updateResponse = client().prepareUpdate("test", "id2")
        assertThat(updateResponse.getGetResult().getIndex(), equalTo("test"));
        );
            .setScriptedUpsert(true)
import org.opensearch.index.engine.DocumentMissingException;
                                        final BulkItemResponse ir = br.getItems()[0];
            public void run() {
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("1"));
        expectThrows(
                    } catch (InterruptedException e) {
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
                                    .setRetryOnConflict(Integer.MAX_VALUE)
        assertThat(e.getMessage(), containsString("ExtraFieldValues are not supported with scripted updates"));
import org.opensearch.core.common.bytes.BytesArray;
        int numberOfThreads = scaledRandomIntBetween(2, 5);
                }
        assertFutureThrows(
                @Override
                                }
                    ScriptType.INLINE,
                }
 */
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
                                    .request();
        assertEquals(1.1, (Double) latLon.get("lon"), 0.001);
            VersionConflictEngineException.class,
                .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 2).endObject())
        ensureGreen();
            UpdateThread ut = new UpdateThread(numberOfIdsPerThread);
        public String pluginScriptLang() {
                                    .execute()
                                    Thread.currentThread().getName(),
                    }
        assertEquals(2, source.size()); // Only requested fields should be present
        final CountDownLatch startLatch = new CountDownLatch(1);
            .setUpsert(
import org.opensearch.test.InternalSettingsPlugin;
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("2"));
        }
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, UPSERT_SCRIPT, params))
                )
                expectedVersion -= totalFailures;
        assertEquals("initial text", source.get("text_field"));
            .setScript(
            .execute()
            }""";
        createTestIndex();
        assertEquals("doc_as_upsert", source.get("keyword_field"));
        assertEquals(10, source.get("numeric_field"));
    public void testDerivedSourceWithUpdates() throws Exception {
            fail("Should have thrown ActionRequestValidationException");
        assertEquals(2, source.get("numeric_field"));
    }
                                    .setScript(fieldIncScript)
        assertThat(updateResponse.getGetResult(), notNullValue());
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
        }
        assertEquals(2, updateResponse.getVersion());
                            if (i % 100 == 0) {
        int openingBalance = 10;
        assertThat(failures.size(), equalTo(0));
                            },
            .execute()
                    synchronized (failedMap) {
            .execute()
                                    "Client [{}] issued [{}] of [{}] requests",
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("bar", "baz").endObject())
        assertAcked(prepareCreate("test2").addAlias(new Alias("alias")));
                Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
            }
                },
 *    http://www.apache.org/licenses/LICENSE-2.0
        startLatch.countDown();
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
                Map<String, Object> newCtx = (Map<String, Object>) params.remove("_ctx");
        source = getResponse.getSourceAsMap();
        }
                            } else {
    private static final String EXTRACT_CTX_SCRIPT = "extract_ctx";
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
import java.util.concurrent.TimeUnit;
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("balance", openingBalance).endObject())
        for (int i = 0; i < 5; i++) {
 * this work for additional information regarding copyright
                                }
        assertEquals(Geohash.stringEncode(40.33, 75.98), source.get("geopoint_field"));
        assertThat(updateResponse.getGetResult().getIndex(), equalTo("test"));
    // Issue #3265
                    logger.error("Something went wrong", e);
 * compatible open source license.
            .actionGet();
                            updateRequestsOutstanding.acquire();
        updateResponse = client().prepareUpdate("test_derive", "1")
        assertTrue(getResponse.isExists());
        params.put("numeric_field", 10);
                    } catch (OpenSearchTimeoutException ete) {
                            try {
        assertThat(updateResponse.getGetResult().field("field1"), nullValue());
                                DeleteRequest dr = client().prepareDelete("test", Integer.toString(j)).request();
                        waitForOutstandingRequests(TimeValue.timeValueSeconds(60), updateRequestsOutstanding, maxUpdateRequests, "Update");
            .get();
                return ctx;
        for (int i = 0; i < 5; i++) {
                .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 2).endObject())
        assertThat(updateResponse.status(), equalTo(RestStatus.CREATED));
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertThat(e.validationErrors().size(), equalTo(1));
                @Override
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
        assertEquals(1, updateContext.get("_version"));
            .execute()
                .setScript(fieldIncScript)
            Runnable r = new Runnable() {
import org.opensearch.action.update.UpdateResponse;
        }
        client().prepareIndex()
            .setRouting("routing1")
            .setId("id1")
        GetResponse getResponse = client().prepareGet("test_derive", "1").get();
            private void incrementMapValue(int j, Map<Integer, Integer> map) {
                        failures.add(ete);
                Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
                                    incrementMapValue(j, failedMap);
        // Test 4: DocAsUpsert with non-existent document
    }
        } catch (ActionRequestValidationException e) {
        assertEquals("[1]: document missing", ex.getMessage());
    public void testScriptedUpsert() throws Exception {
                    PUT_VALUES_SCRIPT,
                return ctx;
        ensureGreen();
                        failures.add(e);
                .setDocAsUpsert(false)
            final int maxDeleteRequests = numberOfIdsPerThread * numberOfUpdatesPerId;
                }
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
            .actionGet();
import static org.hamcrest.Matchers.equalTo;
    public void testNotUpsertDoc() throws Exception {
        // check _source parameter
                }
                source.put("update_context", ctxWithoutSource);
                                synchronized (failedMap) {
        assertThat(updateResponse.getIndex(), equalTo("test"));
                    "index": {
                    expectedVersion,
                                hasWaitedForNoNode = true;
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
                        "[{}] going to try and acquire [{}] in [{}]ms [{}] available to acquire right now",
        latch.await();
            assertThat(e.validationErrors().get(0), containsString("doc must be specified if doc_as_upsert is enabled"));
                .execute()
                        for (int i = 0; i < numberOfUpdatesPerThread; i++) {
            .execute()
                );
        assertThat(updateResponse.getGetResult(), notNullValue());
        DocumentMissingException ex = expectThrows(
            ut.join(); // Threads should have finished because of the latch.await
                public void onFailure(Exception e) {
            assertThat(getResponse.isExists(), equalTo(false));
                    .endObject()
        // Create index with derived source setting enabled
            .execute()
        final CountDownLatch latch = new CountDownLatch(numberOfThreads);
        assertThat(updateResponse.getVersion(), equalTo(3L));
    }
            .setSource("field1", 1, "content", "foo")
                            } catch (NoNodeAvailableException nne) {
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, PUT_VALUES_SCRIPT, Collections.singletonMap("extra", "foo")))
            return scripts;
        return Arrays.asList(UpdateScriptsPlugin.class, InternalSettingsPlugin.class);
        // Upsert all the ids one last time to make sure they are available at get time
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("5"));
    public void testUpdateRequestWithBothScriptAndDoc() throws Exception {
            DocumentMissingException.class,
import org.opensearch.action.ActionRequestValidationException;
                    logger.info(
import org.opensearch.script.MockScriptPlugin;
            assertThat(response.getVersion(), equalTo((long) numberOfThreads));
            .actionGet();
            () -> client().prepareUpdate(indexOrAlias(), "1")
                )
import java.util.Collections;
                                    throw nne;
            .execute()
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
    public void testUpsert() throws Exception {
        createTestIndex();
                            "text_field": {
            .actionGet();
                assertThat(response.getVersion() + totalFailures, equalTo((long) ((numberOfUpdatesPerId * numberOfThreads * 2) + 1)));
        client().prepareIndex("test").setId("1").setSource("field", 1).execute().actionGet();
                                "type": "text",
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject())
            scripts.put(UPSERT_SCRIPT, vars -> {
                                hasWaitedForNoNode = true;
        ensureGreen();
            .setDocAsUpsert(true)
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("2"));
        Map<String, Object> updateContext = (Map<String, Object>) getResponse.getSourceAsMap().get("update_context");
 * You may obtain a copy of the License at
        testMap3.put("map3", 5);
            assertThat(map2.containsKey("commonkey"), equalTo(true));
                    "Actual version [{}] Expected version [{}] Total failures [{}]",
                    deleteRequestsOutstanding.release(1);
                }
import org.opensearch.action.bulk.BulkItemResponse;
        }
    }
            assertThat(map2.containsKey("map1"), equalTo(true));
        assertAcked(prepareCreate("test_derive").setSource(createIndexSource, MediaTypeRegistry.JSON));
            private final Semaphore updateRequestsOutstanding = new Semaphore(maxUpdateRequests);
        for (int i = 0; i < 5; i++) {
        // add new field
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
import java.util.concurrent.CopyOnWriteArrayList;
                                            throw ir.getFailure().getCause();
        assertEquals(2, updateResponse.getVersion());
                assertThat(response.getVersion(), equalTo((long) expectedVersion));
        }
                        "properties": {
        );
                long start = System.currentTimeMillis();
                                        } else {
                            Thread.currentThread().getName()
            .execute()
                int deduction = "create".equals(ctx.get("op")) ? payment.intValue() / 2 : payment.intValue();
        // Pay money from what will be a new account and opening balance comes from upsert doc
        assertEquals("new document", source.get("text_field"));
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                                }
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
        assertThat(updateResponse.getIndex(), equalTo("test"));
 * The OpenSearch Contributors require contributions made to
                int id;
                    this.id = id;
import static org.hamcrest.Matchers.containsString;
    public void testScriptWithExtraFieldValuesRejected() throws Exception {
    }
        // Test 5: Scripted upsert
            .execute()
        assertThat(updateResponse.status(), equalTo(RestStatus.OK));
            .execute()
            )
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, UPSERT_SCRIPT, params))
        assertEquals(false, source.get("bool_field"));
                    totalFailures
            .actionGet();
            @SuppressForbidden(reason = "Sleeping in a loop")
                    "_doc": {
                        Thread.currentThread().interrupt();
        source = updateResponse.getGetResult().sourceAsMap();
                assertNotNull(ctx);
                "mappings": {
                .setRetryOnConflict(Integer.MAX_VALUE)
        client().prepareUpdate(indexOrAlias(), "1")
        Map<String, Object> testMap = new HashMap<>();
                    }
            assertThat(getResponse.getSourceAsMap().get("field2").toString(), equalTo("2"));
                                    throw nne;
        assertThat(updateResponse.getVersion(), equalTo(4L));
            .setDoc(jsonBuilder().startObject().field("numeric_field", 15).field("keyword_field", "filtered").endObject())
    private static final String UPSERT_SCRIPT = "scripted_upsert";
        for (int i = 0; i < 5; i++) {
        final int numberOfThreads = scaledRandomIntBetween(3, 5);
                            }
            .setDoc(XContentFactory.jsonBuilder().startObject().field("bar", "baz").endObject())
                            }
        ensureGreen();
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
            fail("Should have thrown ActionRequestValidationException");
                    .field("keyword_field", "doc_as_upsert")
        ensureGreen();
            if (response.isExists()) {
        ensureGreen();
        testMap.put("commonkey", testMap2);
    public void testUpdateWithIfSeqNo() throws Exception {
    }
            return UPDATE_SCRIPTS;
        assertThat(updateResponse.getGetResult().sourceAsMap().size(), equalTo(1));
        assertThat(updateResponse.getGetResult(), notNullValue());
    private void createTestIndex() throws Exception {
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
            .execute()
            .setFetchSource(new String[] { "numeric_field", "keyword_field" }, null)
                    } catch (Exception e) {
        assertEquals(true, source.get("bool_field"));
        // Test 1: Basic Update with Script
                                logger.warn("Got NoNodeException waiting for 1 second for things to recover.");
        assertThat(updateResponse.getGetResult(), notNullValue());
                                    numberOfUpdatesPerThread
                source.put("balance", oldBalance.intValue() - deduction);
                }
            VersionConflictEngineException.class,
    }
            private void waitForOutstandingRequests(TimeValue timeOut, Semaphore requestsOutstanding, int maxRequests, String name) {
                                );
        assertThat(failures.size(), equalTo(0));
            .actionGet();
        assertEquals("initial", source.get("keyword_field"));
        // creating an in-memory lucene index, which will give the response in desired representation of lat/lon pair
 * SPDX-License-Identifier: Apache-2.0
        testMap2.put("map2", 6);
        Map<String, Object> source = updateResponse.getGetResult().sourceAsMap();
        for (int i = 0; i < 5; i++) {
        for (Throwable throwable : failures) {
import org.opensearch.action.DocWriteResponse;
                        logger.warn(
        assertThat(updateResponse.getSeqNo(), equalTo(result.getSeqNo() + 1));
        assertEquals("updated text", source.get("text_field"));
            assertThat(e.validationErrors().get(0), containsString("can't provide both script and doc"));
        @Override
        // change existing field
import java.util.Collection;
        createTestIndex();
            .setDoc(jsonBuilder().startObject().field("bool_field", false).field("text_field", "updated text").endObject())
        assertEquals("test", updateContext.get("_index"));
                Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
            .actionGet();
                jsonBuilder().startObject()
                Map<String, Object> params = new HashMap<>((Map<String, Object>) vars.get("params"));
            .setScript(
                    UPDATE_SCRIPTS,
        assertEquals("scripted_upsert", source.get("keyword_field"));
                    }
        // aquiring the request outstanding semaphores.
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
                this.numberOfIds = numberOfIds;
            .setFetchSource(true)
import org.opensearch.core.rest.RestStatus;
        }
        assertThat(updateResponse.getIndex(), equalTo("test"));
                    .field("keyword_field", "initial")
                public void onFailure(Exception e) {
        );
        assertEquals("doc_as_upsert", source.get("keyword_field"));
                .setDoc(XContentFactory.jsonBuilder().startObject().field("bar", "baz").endObject())
        assertEquals(40.33, (Double) latLon.get("lon"), 0.001);
            .setIfPrimaryTerm(result.getPrimaryTerm())
        final List<Throwable> failures = new CopyOnWriteArrayList<>();
        assertThat(updateResponse.getGetResult().sourceAsMap().get("extra"), nullValue());
        // attach extra field values to the upsert IndexRequest (since script+doc is invalid)
                                    .setUpsert(jsonBuilder().startObject().field("field", 1).endObject())
            client().prepareUpdate("test", Integer.toString(i))
                    }
                        requestsOutstanding.tryAcquire(maxRequests, msRemaining, TimeUnit.MILLISECONDS);
            assertThat(map1.containsKey("map1"), equalTo(true));
        }
            assertThat(map1.containsKey("commonkey"), equalTo(true));
                return ctx;
        ensureGreen();
            assertThat(map1.size(), equalTo(3));
package org.opensearch.update;
            });
        updateResponse = client().prepareUpdate("test_derive", "2")
                do {
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, PUT_VALUES_SCRIPT, Collections.singletonMap("extra", "foo")))
        assertNotNull("Derived source should not be null", source);
                    }
        for (Throwable throwable : failures) {
        }
        final CountDownLatch startLatch = new CountDownLatch(1);
        assertEquals(true, source.get("bool_field"));
        createTestIndex();
            .actionGet();
            });
        assertEquals("routing1", updateContext.get("_routing"));
        // Test 6: Partial update with source filtering
            () -> client().prepareUpdate(indexOrAlias(), "1")
                        }
        try {
                } while ((System.currentTimeMillis() - start) < timeOut.getMillis());
                    .endObject()
            .setIndex("test")
        // Now pay money for an existing account where balance is stored in es
            .setDocAsUpsert(true)
        assertEquals(2, source.get("numeric_field")); // Unchanged
                Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
        assertEquals("updated", source.get("keyword_field"));
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(DocWriteResponse.Result.CREATED, updateResponse.getResult());
                params.remove("ctx");
            .execute()
            client().prepareUpdate(indexOrAlias(), "1").setScript(fieldIncScript).setDocAsUpsert(true).execute().actionGet();
        testMap.put("map1", 8);
                Number currentValue = (Number) source.get(fieldname);
        // Index some documents
                );
        assertEquals("initial", source.get("keyword_field"));
        UpdateRequest req = new UpdateRequest(indexOrAlias(), "1").script(script)
        assertThat(updateResponse.getGetResult().getIndex(), equalTo("test"));
        assertEquals(5, source.get("numeric_field"));
            assertThat(getResponse.getSourceAsMap().get("field2").toString(), equalTo("2"));
        assertEquals("id1", updateContext.get("_id"));
                }
import org.opensearch.test.OpenSearchIntegTestCase;
            }
        // In Update, it will be stored as it is in translog, which is in string representation
                    .field("geopoint_field", Geohash.stringEncode(40.33, 75.98))
                assertThat(response.getId(), equalTo(Integer.toString(i)));
    public void testUpdateRequestWithScriptAndShouldUpsertDoc() throws Exception {
                                deleteRequestsOutstanding.release();
                Map<String, Object> source = (Map<String, Object>) ctx.get("_source");
                                        }
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
                        requestsOutstanding.availablePermits()
                @Override
        assertTrue(getResponse.isExists());
            .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 2).endObject())
                                "type": "keyword"
            UpdateThread(int numberOfIds) {
        updateResponse = client().prepareUpdate("test_derive", "3")
        assertThat(updateResponse.getIndex(), equalTo("test"));
                    UPDATE_SCRIPTS,
            .execute()
        assertThat(updateResponse.status(), equalTo(RestStatus.CREATED));
                                UpdateRequest ur = client().prepareUpdate("test", Integer.toString(j))
        Map<String, Object> testMap3 = new HashMap<>();
        UpdateResponse updateResponse = client().prepareUpdate("test", "1")
            assertThat(e.validationErrors().size(), equalTo(1));
                                } else {
            scripts.put(PUT_VALUES_SCRIPT, vars -> {
        final CountDownLatch latch = new CountDownLatch(numberOfThreads);
            }
        latLon = (Map<String, Object>) source.get("geopoint_field");
    private static final String UPDATE_SCRIPTS = "update_scripts";
        latch.await();
        assertEquals(true, source.get("bool_field"));
    public void testUpsertDoc() throws Exception {
        assertThat(updateResponse.getIndex(), equalTo("test"));
        Map<String, Object> params = new HashMap<>();
                    this.id = id;
                            } catch (NoNodeAvailableException nne) {
                                Thread.sleep(1000); // Wait for no-node to clear
            .setIfSeqNo(result.getSeqNo())
 * license agreements. See the NOTICE file distributed with
                        waitForOutstandingRequests(TimeValue.timeValueSeconds(60), deleteRequestsOutstanding, maxDeleteRequests, "Delete");
                            "Test was forcefully stopped. Client [{}] may still have outstanding requests.",
            assertThat(e.getMessage(), containsString("doc must be specified if doc_as_upsert is enabled"));
            .setDoc(XContentFactory.jsonBuilder().startObject().field("map", testMap3).endObject())
                    );
        getResponse = client().prepareGet("test_derive", "2").get();
            {
                                "type": "boolean"
        source = updateResponse.getGetResult().sourceAsMap();
                    map.put(j, 0);
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
/*
        assertThat(updateResponse.status(), equalTo(RestStatus.OK));
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
            .setFetchSource(true)
                Number inc = (Number) params.getOrDefault("inc", 1);
        assertThat(updateResponse.status(), equalTo(RestStatus.OK));
                        msRemaining,
import org.opensearch.index.engine.VersionConflictEngineException;
        assertEquals("updated", source.get("keyword_field")); // Unchanged
                        return;
import org.opensearch.action.update.UpdateRequestBuilder;
                new Script(ScriptType.INLINE, UPDATE_SCRIPTS, PUT_VALUES_SCRIPT, Map.of("numeric_field", 2, "keyword_field", "updated"))
 *
                                "store": true
    @Override
            .setFetchSource(true)
        assertThat(updateResponse.getGetResult().sourceAsMap().get("bar").toString(), equalTo("baz"));
        }
                    boolean hasWaitedForNoNode = false;
                                    .actionGet();
    public void testUpdate() throws Exception {
            .actionGet();
                                    .setUpsert(jsonBuilder().startObject().field("field", 1).endObject());
        // recursive map
import java.util.List;
        createTestIndex();
        updateContext = (Map<String, Object>) getResponse.getSourceAsMap().get("update_context");
                    .field("bool_field", true)
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
                if (!map.containsKey(j)) {
                Map<String, Object> params = (Map<String, Object>) vars.get("params");
                        "number_of_replicas": 0,
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
                            },
                new Script(
        assertEquals("initial text", source.get("text_field"));
            )
            logger.info("Captured failure on concurrent update:", throwable);
            Map map2 = (Map) map1.get("commonkey");
                                }
        final List<UpdateThread> threads = new ArrayList<>();
        assertAcked(prepareCreate("test").setSettings(Settings.builder().put(MergePolicyProvider.INDEX_MERGE_ENABLED, false)));
        for (int i = 0; i < 5; i++) {
        // check updates without script
            assertThat(map2.containsKey("map2"), equalTo(true));
            });
                    if (ut.failedMap.containsKey(i)) {
        assertThat(updateResponse.getGetResult().sourceAsMap().get("bar").toString(), equalTo("baz"));
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
        for (UpdateThread ut : threads) {
            assertThat(e.getMessage(), containsString("can't provide both script and doc"));
import java.util.Arrays;
                public void run() {
 * Licensed to Elasticsearch under one or more contributor
        for (int i = 0; i < numberOfThreads; i++) {
        }
import org.opensearch.core.action.ActionListener;
            .actionGet();
            logger.info("Captured failure on concurrent update:", throwable);
            .execute()
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, EXTRACT_CTX_SCRIPT, Collections.emptyMap()))
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1").setScript(fieldIncScript).execute().actionGet();
                        }
                Map<String, Object> ctx = (Map<String, Object>) vars.get("ctx");
            () -> client().prepareUpdate(indexOrAlias(), "1")
                    .field("bool_field", true)
            .actionGet();
        UpdateResponse updateResponse = client().prepareUpdate("test_derive", "1")
        assertEquals("filtered", source.get("keyword_field"));
            DocumentMissingException.class
import java.util.HashMap;
                    ctx.putAll(newCtx);
        assertEquals(DocWriteResponse.Result.UPDATED, updateResponse.getResult());
                        maxRequests,
        // All the previous operations should be complete or failed at this point
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, PUT_VALUES_SCRIPT, Collections.singletonMap("extra", "foo")))
            assertThat(getResponse.getSourceAsMap().get("balance").toString(), equalTo("7"));
        source = updateResponse.getGetResult().sourceAsMap();
        assertThat(updateResponse.getIndex(), equalTo("test"));
            .setScript(fieldIncScript)
            .setDoc(XContentFactory.jsonBuilder().startObject().field("field2", 2).endObject())
            .actionGet();
                    deleteRequestsOutstanding.release(1);
                                logger.debug(
import static org.hamcrest.Matchers.nullValue;
            .execute()
                .execute(),
        assertEquals(Geohash.stringEncode(1.1, 1.2), source.get("geopoint_field"));
                assertNotNull(ctx);
        assertThat(updateResponse.status(), equalTo(RestStatus.OK));
            .setFetchSource(true)
        assertThat(updateResponse.getGetResult().sourceAsMap().get("extra"), nullValue());
                        // Just keep swimming
                    for (int j = 0; j < numberOfIds; j++) {
                .setScript(fieldIncScript)
        assertThat(updateResponse.getGetResult().sourceAsMap().get("bar").toString(), equalTo("baz"));
/*
                    try {
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject())
        assertEquals("initial text", source.get("text_field")); // Unchanged
                public void onResponse(DeleteResponse deleteResponse) {
                .setIfSeqNo(result.getSeqNo() + 1)
        ActionRequestValidationException e = expectThrows(ActionRequestValidationException.class, () -> client().update(req).actionGet());
        Map<String, Object> params = new HashMap<>();
                        incrementMapValue(id, failedMap);
            .execute()
            .actionGet();
        // In Update, it will be stored as it is in translog, which is in string representation, so in get call we are
            };
        client().prepareIndex("test").setId("1").setSource("map", testMap).execute().actionGet();
    private static final String PUT_VALUES_SCRIPT = "put_values";
            .actionGet();
        updateResponse = client().prepareUpdate(indexOrAlias(), "1")
                jsonBuilder().startObject()
                .setIfSeqNo(result.getSeqNo())
        updateResponse = client().prepareUpdate("test_derive", "1")
        ensureGreen();
        testMap3.put("commonkey", testMap);
                        "refresh_interval": -1,
            assertThat(getResponse.getSourceAsMap().get("balance").toString(), equalTo("9"));
        final int numberOfUpdatesPerId = scaledRandomIntBetween(10, 100);
        assertNotNull("Derived source should not be null", source);
                    } finally {
        final int numberOfIdsPerThread = scaledRandomIntBetween(3, 10);
        Map<String, Object> params = new HashMap<>();
        assertNotNull("Derived source should not be null", source);
                try {
                                    client().update(ur, new UpdateListener(j));
        startLatch.countDown();
import org.opensearch.transport.client.transport.NoNodeAvailableException;
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("3"));
            .actionGet();
            int totalFailures = 0;
    public void testUpsertFields() throws Exception {
                    Collections.singletonMap("_ctx", Collections.singletonMap("op", "none"))
    }
 * KIND, either express or implied.  See the License for the
            .setRouting("routing1")
            .setScript(
        // check noop
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("balance", openingBalance).endObject())
                            }
            .setUpsert(XContentFactory.jsonBuilder().startObject().field("bar", "baz").endObject())
        }
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
        assertEquals(1.2, (Double) latLon.get("lat"), 0.001);
        } catch (ActionRequestValidationException e) {
        // Test 2: Update existing document with script
import org.opensearch.common.settings.Settings;
                    assertFalse(newCtx.containsKey("_source"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                        "derived_source": {
                logger.error(
            .actionGet();
                .setIfSeqNo(result.getSeqNo() + 1)
import org.opensearch.plugins.Plugin;
import org.opensearch.action.get.GetResponse;
        assertThat(updateResponse.getIndex(), equalTo("test"));
            GetResponse response = client().prepareGet("test", Integer.toString(i)).execute().actionGet();
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "numeric_field")))
                }
            .setFetchSource(true)
            .setFetchSource("field1", "field2")
        assertNotNull("Derived source should not be null", source);
            @Override
        UpdateResponse updateResponse = client().prepareUpdate("test", "id1")
        ensureGreen();
            scripts.put(FIELD_INC_SCRIPT, vars -> {
        // Idem with the second object
        source = updateResponse.getGetResult().sourceAsMap();
                source.putAll(params);
        // We create an index with merging disabled so that deletes don't get merged away
        }
        createTestIndex();
                    .field("keyword_field", "initial")
            }
        // provided by client
import java.util.concurrent.Semaphore;
import java.util.Map;
                                logger.warn("Got NoNodeException waiting for 1 second for things to recover.");
            }
                                if (randomBoolean()) {
import org.opensearch.index.MergePolicyProvider;
        client().prepareUpdate(indexOrAlias(), "1")
            assertThat(response.isExists(), equalTo(true));
        assertEquals(1, updateContext.get("_version"));
        assertThat(updateResponse.getGetResult().getIndex(), equalTo("test"));
        }
                .actionGet();
        source = getResponse.getSourceAsMap();
            assertThat(map2.size(), equalTo(3));
}
                int id;
import org.opensearch.action.delete.DeleteRequest;
                .setUpsert(jsonBuilder().startObject().field("field", 1).endObject())
                                deleteRequestsOutstanding.acquire();
            .actionGet();
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
            .setDoc(
            .actionGet();
import org.opensearch.common.unit.TimeValue;
            final Map<Integer, Integer> failedMap = new HashMap<>();
                .get()
        getResponse = client().prepareGet("test", "id2").execute().actionGet();
 * under the License.
import org.opensearch.common.SuppressForbidden;
                    "Requests were still outstanding after the timeout [" + timeOut + "] for type [" + name + "]"
            VersionConflictEngineException.class,
                                client().delete(dr, new DeleteListener(j));
            .execute()
        assertNotNull("Derived source should not be null", source);
/*
                Number payment = (Number) vars.get("payment");
                        name,
        for (int i = 0; i < 5; i++) {
                                    .setRetryOnConflict(Integer.MAX_VALUE)
        // Update the first object and note context variables values
                                updateRequestsOutstanding.release();
    }
                }
                .setIfPrimaryTerm(result.getPrimaryTerm() + 1)
            .execute()
                .execute()
                if (newCtx != null) {
            final class UpdateListener implements ActionListener<UpdateResponse> {
 * ownership. Elasticsearch licenses this file to you under
                }
            .execute()
                .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 2).endObject())
                assertNotNull(ctx);
        try {
        createTestIndex();
            .actionGet();
        assertThat(updateResponse.getIndex(), equalTo("test"));
        ensureGreen();
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, EXTRACT_CTX_SCRIPT, Collections.emptyMap()))
            ut.start();
        for (int i = 0; i < numberOfThreads; i++) {
                            "keyword_field": {
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        for (int i = 0; i < numberOfIdsPerThread; ++i) {
import org.opensearch.OpenSearchTimeoutException;
    }
        logger.info("--> creating index test");
 * GitHub history for details.
 *
                    .field("geopoint_field", Geohash.stringEncode(1.1, 1.2))
        }
        assertThat(updateResponse.status(), equalTo(RestStatus.CREATED));
 */
                            },
import org.opensearch.action.delete.DeleteResponse;
            .setUpsert(
            assertThat(getResponse.getSourceAsMap().get("field").toString(), equalTo("5"));
            )
        // 2) Existing accounts subtract full payment from balance stored in opensearch
        assertNotNull("Derived source should not be null", source);
        assertNull(updateContext.get("_routing"));
            final int numberOfIds;
 */
                            "enabled": true
                .get()
                    Collections.singletonMap("_ctx", Collections.singletonMap("op", "delete"))
            assertThat(map1.containsKey("map3"), equalTo(true));
                                    incrementMapValue(j, failedMap);
        final List<Exception> failures = new CopyOnWriteArrayList<>();
        }
                        failures.add(e);
        }
        Script script = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
        assertThat(updateResponse.getVersion(), equalTo(2L));
        createTestIndex();
                } finally {
        assertThat(updateResponse.getGetResult().sourceAsMap().get("bar").toString(), equalTo("baz"));
            threads.add(ut);
                    latch.countDown();
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
 * specific language governing permissions and limitations
                } catch (Exception e) {
        ensureGreen();
                                    i,
                "settings": {
            client().prepareUpdate(indexOrAlias(), "1")
            scripts.put(EXTRACT_CTX_SCRIPT, vars -> {
        }
        assertEquals("id2", updateContext.get("_id"));
        assertThat(updateResponse.getGetResult().sourceRef(), notNullValue());
        );
            .upsert(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject());
        assertThat(updateResponse.getIndex(), equalTo("test"));
                assertNotNull(ctx);
            private final Semaphore deleteRequestsOutstanding = new Semaphore(maxDeleteRequests);
    public void testContextVariables() throws Exception {
        assertEquals(true, source.get("bool_field"));
import org.opensearch.action.admin.indices.alias.Alias;
        // Test 3: Update with doc
                                if (hasWaitedForNoNode) {
                Number oldBalance = (Number) source.get("balance");
                    long msRemaining = timeOut.getMillis() - (System.currentTimeMillis() - start);
        source = updateResponse.getGetResult().sourceAsMap();
                    .field("numeric_field", 1)
                                synchronized (failedMap) {
                    .field("text_field", "initial text")
import java.util.concurrent.CountDownLatch;
            )
        params.put("payment", 2);
                    startLatch.await();
            Map map1 = (Map) getResponse.getSourceAsMap().get("map");
        assertThat(updateResponse.getGetResult().getIndex(), equalTo("test"));
                    .field("numeric_field", 0)
        Script fieldIncScript = new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field"));
        assertEquals(5, source.get("numeric_field"));
            }
        assertNotNull("Derived source should not be null", source);
                        }
                Map<String, Object> ctxWithoutSource = new HashMap<>(ctx);
                    }
                    response.getVersion(),
        for (int i = 0; i < 5; i++) {
                                Thread.sleep(1000);
                UpdateListener(int id) {
            .actionGet();
                        logger.info("Client [{}] issued all [{}] requests.", Thread.currentThread().getName(), numberOfUpdatesPerThread);
            )
                .setIfPrimaryTerm(result.getPrimaryTerm() + 1)
            .setScriptedUpsert(true)
            final int maxUpdateRequests = numberOfIdsPerThread * numberOfUpdatesPerId;
                ctxWithoutSource.remove("_source");
        assertEquals(15, source.get("numeric_field"));
            final class DeleteListener implements ActionListener<DeleteResponse> {
                            try {
                            },
            GetResponse response = client().prepareGet("test", Integer.toString(i)).execute().actionGet();
        assertEquals(75.98, (Double) latLon.get("lat"), 0.001);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;
                            "bool_field": {
        assertThat(updateResponse.getIndex(), equalTo("test"));
        ensureGreen();
                            }
        assertAcked(prepareCreate("test").addAlias(new Alias("alias")));
                String fieldname = (String) vars.get("field");
import org.opensearch.index.mapper.extrasource.BytesValue;
        createTestIndex();
                }
                    } catch (InterruptedException ie) {
import static org.hamcrest.Matchers.notNullValue;
                map.put(j, map.get(j) + 1);
                            if (useBulkApi) {
                    }
        Map<String, Object> latLon = (Map<String, Object>) source.get("geopoint_field");
                                "type": "geo_point"
        Map<String, Object> testMap2 = new HashMap<>();
            .setScript(fieldIncScript)
                        }
                                    }));
        assertAcked(prepareCreate("test").addAlias(new Alias("alias").writeIndex(true)));
        assertThat(updateResponse.getVersion(), equalTo(3L));
        // This means that we add 1 to the expected versions and attempts
            .actionGet();
import org.opensearch.action.index.IndexResponse;
            assertThat(response.getSource().get("field"), equalTo(numberOfThreads));
        updateResponse = client().prepareUpdate("test_derive", "1")
                        startLatch.await();
import java.util.ArrayList;
            .setFetchSource(true)
                                client().prepareBulk().add(updateRequestBuilder).execute().actionGet();
    }
        assertEquals(DocWriteResponse.Result.CREATED, updateResponse.getResult());
                    synchronized (failedMap) {
                .setDoc(XContentFactory.jsonBuilder().startObject().field("field", 1).endObject())
                for (UpdateThread ut : threads) {
                                if (hasWaitedForNoNode) {
        params.put("keyword_field", "scripted_upsert");
                .get()
        assertThat(updateResponse.getIndex(), equalTo("test"));
        expectThrows(
            Thread updater = new Thread(r);
        for (int i = 0; i < 5; i++) {
import org.opensearch.common.xcontent.XContentFactory;
                DeleteListener(int id) {
        // Script logic is
        assertEquals(true, source.get("bool_field")); // Unchanged
import org.opensearch.script.Script;
    private static final String FIELD_INC_SCRIPT = "field_inc";
        // 1) New accounts take balance from "balance" in upsert doc and first payment is charged at 50%
                                    .setScript(fieldIncScript)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            .execute()
        UpdateResponse updateResponse = client().prepareUpdate(indexOrAlias(), "1")
        for (int i = 0; i < numberOfIdsPerThread; ++i) {
        }
        assertEquals(DocWriteResponse.Result.DELETED, updateResponse.getResult());
        assertEquals("test", updateContext.get("_index"));
        client().prepareUpdate(indexOrAlias(), "1")
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
                    .field("numeric_field", 5)
        assertThat(updateResponse.getGetResult(), notNullValue());
            updater.start();
                                "type": "long"
        // If are no errors every request received a response otherwise the test would have timedout
        assertThat(updateResponse.getIndex(), equalTo("test"));
        ensureGreen();
            .actionGet();
        GetResponse getResponse = client().prepareGet("test", "id1").setRouting("routing1").execute().actionGet();
                        totalFailures += ut.failedMap.get(i);
        assertEquals(1, source.get("numeric_field"));
            () -> client().prepareUpdate(indexOrAlias(), "1").setScript(fieldIncScript).execute().actionGet()
                    try {
 * this file be licensed under the Apache-2.0 license or a
                    .field("text_field", "new document")
                                UpdateRequestBuilder updateRequestBuilder = client().prepareUpdate(indexOrAlias(), Integer.toString(i))
        assertEquals(true, source.get("bool_field"));
    }
    }
        client().prepareIndex("test").setId("1").setSource("field", 1).execute().actionGet();
            .execute()
            .actionGet();
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, PUT_VALUES_SCRIPT, params))
                            "geopoint_field": {
        ensureGreen();
import java.util.function.Function;
                        "number_of_shards": 2,
                                    .setRetryOnConflict(retryOnConflict)
                    updateRequestsOutstanding.release(1);
        for (int i = 0; i < numberOfUpdatesPerThread; i++) {
            .setScriptedUpsert(true)
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, Collections.singletonMap("field", "field1")))
                    }
                                        if (ir.isFailed()) {
                        incrementMapValue(id, failedMap);
    }
import org.opensearch.script.ScriptType;
    }
            GetResponse getResponse = client().prepareGet("test", "1").execute().actionGet();
        }
        assertEquals(1, source.get("numeric_field"));
 * Unless required by applicable law or agreed to in writing,
        assertAcked(prepareCreate("test").addAlias(new Alias("alias").writeIndex(randomFrom(true, null))));
        // check delete
                    updateRequestsOutstanding.release(1);
            }
    public void testIndexAutoCreation() throws Exception {
                    ScriptType.INLINE,
                .setFetchSource(true)
            .setScript(new Script(ScriptType.INLINE, UPDATE_SCRIPTS, FIELD_INC_SCRIPT, params))
        final int numberOfUpdatesPerThread = scaledRandomIntBetween(100, 500);
        IndexResponse result = client().prepareIndex("test").setId("1").setSource("field", 1).get();
                    try {
                        // test infrastructure kills long-running tests by interrupting them, thus we handle this case separately
                                            return ir.getResponse();
        assertThat(updateResponse.getIndex(), equalTo("test"));
