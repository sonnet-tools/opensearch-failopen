            IDAndVersion x = idVersions[index];
            .setId("id")  
        createIndex("test");
 */
                    sb.append(" index=");  
        assertRequestBuilderThrows(  
    public void testCompareAndSet() {
        assertThat(indexResponse.getVersion(), equalTo(12L));
        for (int i = 0; i < 10; i++) {  
        final long startTime = System.nanoTime();
        if (failed) {  
                    sb.append(indexResponse.getIndex());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        for (int i = 0; i < 10; i++) {
import org.apache.lucene.tests.util.TestUtil;  
                                } catch (VersionConflictEngineException vcee) {  
            VersionConflictEngineException.class
            .setId("1")
            SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setVersion(true).execute().actionGet();
            .actionGet();  
import org.opensearch.cluster.metadata.IndexMetadata;
            };
            VersionConflictEngineException.class
        assertFutureThrows(  
            threads[i].start();
        createIndex("test");
            .setSource("field1", "value1_1")  
        );
            client().prepareIndex("test")  
                .setVersion(13)
        client().admin().indices().prepareFlush().execute().actionGet();
            assertThat(searchResponse.getHits().getAt(0).getVersion(), equalTo(2L));
                    sb.append(" created=");  
        );  
        client().prepareDelete("test", "id").setVersion(11).setVersionType(VersionType.EXTERNAL).execute().actionGet();
            .execute()
import org.opensearch.common.SuppressForbidden;  
                }
        newSettings.put("index.gc_deletes", -1);  
        for (int i = 0; i < threads.length; i++) {  
            }
            IDAndVersion idVersion = truth.get(id);
        assertRequestBuilderThrows(
        indexResponse = client().prepareIndex("test")  
        // Delete with a higher version deletes all versions up to the given one.
        assertFutureThrows(
        );
            }  
            client().prepareDelete("test", "1").setVersion(2).setVersionType(VersionType.EXTERNAL).execute(),
            VersionConflictEngineException.class
                ids = new IDSource() {
                throw new AssertionError();  
            .prepareUpdateSettings("test")
        IndexResponse indexResponse = client().prepareIndex("test")
        // Delete with a higher or equal version deletes all versions up to the given one.  
        // Index a doc:  
        createIndex("test");  
                break;
            .actionGet();
        createIndex("test");
            VersionConflictEngineException.class
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        indexResponse = client().prepareIndex("test")
            .setVersionType(VersionType.INTERNAL)
import java.util.Random;  
            .get();  
            .actionGet();  
                    )  
            sb.append(versionConflict);  
                    sb.append(indexResponse.getResult() == DocWriteResponse.Result.CREATED);
                };  
            refresh();  
        ensureGreen();
            .setSource("field", "value3")
        public ActionResponse response;  
    public void testGCDeletesZero() throws Exception {  
        final Random random = random();
                .setId("1")
        }
        }
            .setVersionType(VersionType.EXTERNAL)
                            }
                                        .setId(id)
                                try {  
            // Force refresh so the add is sometimes visible in the searcher:
        // Shuffle
            client().prepareDelete("test", "1").setIfSeqNo(1).setIfPrimaryTerm(2),
            .setVersion(Versions.MATCH_DELETED)  
            .setId("1")
        assertRequestBuilderThrows(  
            .actionGet();  
            VersionConflictEngineException.class  
            .setVersionType(VersionType.EXTERNAL)
        }
        }
                            if (threadRandom.nextInt(100) == 7) {  
        // Real-time get should reflect delete even though index.gc_deletes is 0:  
        client().admin().indices().prepareRefresh().execute().actionGet();
        // case system is busy:
            idVersions[i].version = version;
        createIndex("test");
        String idPrefix;  
            .add(client().prepareIndex("test").setId("1").setSource("field1", "value1_1"))  
        client().admin().indices().prepareUpdateSettings("test").setSettings(newSettings).execute().actionGet();
        client().prepareDelete("test", "id2").setVersion(11).setVersionType(VersionType.EXTERNAL).execute().actionGet();  
        IndexResponse indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_1").execute().actionGet();  
                    int upto;
            assertThat(client().prepareGet("test", "1").execute().actionGet().getVersion(), equalTo(2L));
            .actionGet();
        }  
            .setVersionType(VersionType.EXTERNAL)
            .execute()  
        final IDAndVersion[] idVersions = new IDAndVersion[TestUtil.nextInt(random, numIDs / 2, numIDs * (TEST_NIGHTLY ? 8 : 2))];
        createIndex("test");
        if (randomBoolean()) {
                .setSource("field1", "value1_1")
            .setSource("field1", "value1_1")
        for (IDAndVersion idVersion : idVersions) {
            client().prepareDelete("test", "1").setIfSeqNo(10).setIfPrimaryTerm(1),  
            client().prepareDelete("test", "1").setIfSeqNo(3).setIfPrimaryTerm(12),  
                            }
        client().admin().indices().prepareUpdateSettings("test").setSettings(newSettings).execute().actionGet();
            int index = random.nextInt(i + 1);
    public void testCompareAndSetInitialDelete() throws Exception {
        int numIDs;
        assertRequestBuilderThrows(
                truth.put(idVersions[i].id, idVersions[i]);
            logger.debug("--> use id prefix {}", idPrefix);
                break;
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());  
    }
                        return Long.toString(random.nextLong() & 0x3ffffffffffffffL, radix);
            .setSource("field1", "value1_2")
            .execute()
                    }
        deleteResponse = client().prepareDelete("test", "1").setVersion(18).setVersionType(VersionType.EXTERNAL_GTE).execute().actionGet();
                                    idVersion.response = client().prepareIndex("test")
            .actionGet();
import org.opensearch.action.get.GetResponse;
            .setVersionType(VersionType.EXTERNAL)
        }
        indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_2").setIfSeqNo(0).setIfPrimaryTerm(1).get();
        assertFutureThrows(  
        assertThat("doc should have been deleted", client().prepareGet("test", "id").execute().actionGet().getVersion(), equalTo(-1L));  
            .setVersionType(VersionType.EXTERNAL_GTE)  
        }
                .setVersionType(VersionType.EXTERNAL)
                            int index = upto.getAndIncrement();
            sb.append(threadID);  
            .execute()  
                    sb.append(" version=");
        assertThat(indexResponse.getPrimaryTerm(), equalTo(1L));
            if (actualVersion != expected) {  
    }
        IndexResponse indexResponse = client().prepareIndex("test")
        // search without versioning
                                        .setVersionType(VersionType.EXTERNAL)
            .setVersion(17)
            if (response != null) {
            fail("wrong versions for some IDs");  
        // this should conflict with the delete command transaction which told us that the object was deleted at version 17.
                idVersion.delete,  
                        throw new RuntimeException(e);
                        startingGun.await();
        );
    // Poached from Lucene's TestIDVersionPostingsFormat:  
                .execute(),  
import org.opensearch.common.lucene.uid.Versions;
        // TODO: This behavior breaks rest api returning http status 201
                if (response instanceof DeleteResponse) {
            VersionConflictEngineException.class
import java.util.Map;
import org.opensearch.action.delete.DeleteResponse;
            assertThat(searchResponse.getHits().getAt(0).getSeqNo(), equalTo(1L));  
            .setSource("field1", "value1_2")
            .setVersionType(VersionType.INTERNAL)
            .setSource("field", "value4")
                    sb.append(" response:");
        }
        );  
                truth.get(idVersion.id) == idVersion
                    sb.append(indexResponse.getId());  
                    DeleteResponse deleteResponse = (DeleteResponse) response;  
        try {  
        boolean failed = false;
        assertThat(deleteResponse.getPrimaryTerm(), equalTo(1L));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;
            StringBuilder sb = new StringBuilder();
                    sb.append(" id=");
                    public String next() {
        client().prepareIndex("test")
                    } catch (Exception e) {  
                .execute(),
            long expected;
            .execute()
 * You may obtain a copy of the License at  
        while (idsSet.size() < numIDs) {  
        assertThat(indexResponse.getSeqNo(), equalTo(1L));
                    sb.append(" id=");
        assertThat(deleteResponse.getVersion(), equalTo(20L));
            .setSource("field", "value2")
                    @Override
        DeleteResponse deleteResponse = client().prepareDelete("test", "1")  
        // Real-time get should reflect delete:
    public void testExternalGTE() throws Exception {
        ensureGreen();
        }  
 * this file be licensed under the Apache-2.0 license or a
        indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_2").setIfSeqNo(0L).setIfPrimaryTerm(1).get();
    private IDSource getRandomIDs() {  
                                    idVersion.response = client().prepareDelete("test", id)
        for (int i = 0; i < 10; i++) {
        internalCluster().ensureAtLeastNumDataNodes(2);
        // Make sure that the next delete will be GC. Note we do it on the index settings so it will be cleaned up
 * license agreements. See the NOTICE file distributed with
                    .contains(
package org.opensearch.versioning;
        @Override
        }
                                flush();
                failed = true;
    }
        assertThat(indexResponse.getVersion(), equalTo(1L));
            }  
    public void testRequireUnitsOnUpdateSettings() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
                            IDAndVersion idVersion = idVersions[index];
            // expected
                                    idVersion.versionConflict = true;  
            long actualVersion = client().prepareGet("test", id).execute().actionGet().getVersion();
            sb.append(" indexFinishTime=");  
        long version = 0;  
                    sb.append(deleteResponse.getResult() == DocWriteResponse.Result.DELETED);  
                // zero-pad random long  
            client().prepareIndex("test")
                };  
        IndexResponse doc2 = client().prepareIndex("test")  
        // search with versioning
        Set<String> idsSet = new HashSet<>();
                                logger.trace("--> {}: TEST: flush done at {}", threadID, System.nanoTime() - startTime);  
            client().prepareDelete("test", "1").setIfSeqNo(1).setIfPrimaryTerm(2),
        public String id;
        assertThat(doc2.getVersion(), equalTo(1L));
        assertFutureThrows(  
        final CountDownLatch startingGun = new CountDownLatch(1);  
            .setVersionType(VersionType.EXTERNAL)
        }  
        for (int i = 0; i < 10; i++) {  
        indexResponse = client().prepareIndex("test")  
                } else {
            // 20% of the time we delete:
        // deleting with a lower version fails.
        createIndex("test");  
                            // TODO: sometimes use bulk:
        }  
 * this work for additional information regarding copyright
            .setId("1")
        ensureGreen();  
    }
        assertThat(indexResponse.getVersion(), equalTo(12L));  
            .setVersionType(VersionType.EXTERNAL)
        IndexResponse doc3 = client().prepareIndex("test")  
            } else {
        ensureGreen("test");
        ensureGreen();  
            .setSource("field1", "value1_1")
                        final Random threadRandom = random();
                logger.info("--> use sequential ids");
        // We test deletes, but can't rely on wall-clock delete GC:
            VersionConflictEngineException.class  
        assertThat(deleteResponse.getVersion(), equalTo(18L));
        client().admin()
            .setSource("foo", "bar")
                            idVersion.indexStartTime = System.nanoTime() - startTime;  
import java.util.concurrent.CountDownLatch;
        createIndex("test");  
            .actionGet();  
            assertThat(searchResponse.getHits().getAt(0).getVersion(), equalTo(Versions.NOT_FOUND));
        final Map<String, IDAndVersion> truth = new HashMap<>();
                            } else {
                    sb.append(" found=");
/*
            .execute()
                    }
                            if (threadRandom.nextInt(100) == 7) {
                // Save highest version per id:  
                    @Override
            idVersions[i] = new IDAndVersion();
            .setVersion(14)  
                .setId("1")
                logger.info("--> use random long ids");
                            String id = idVersion.id;
        assertThat(deleteResponse.getVersion(), equalTo(18L));
            case 4:
                    try {
                };  
                            }
            }
        public boolean delete;  
            .execute()
        // Generate random IDs:
            .execute()
                    final int radix = TestUtil.nextInt(random, Character.MIN_RADIX, Character.MAX_RADIX);  
        for (int i = 0; i < 10; i++) {
            .execute()
            threads[i] = new Thread() {
            .setSettings(Settings.builder().put("index.number_of_shards", 1))
        assertRequestBuilderThrows(
            refresh();  
        // Index a doc:
        }  
        assertThat("doc should have been deleted", client().prepareGet("test", "id").execute().actionGet().getVersion(), equalTo(-1L));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
        // TODO: test non-aborting exceptions (Rob suggested field where positions overflow)  
                                        .setVersionType(VersionType.EXTERNAL)  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;  
                    @Override  
        client().prepareDelete("test", "id").setVersion(11).setVersionType(VersionType.EXTERNAL).execute().actionGet();
            .get();
        );
        DeleteResponse deleteResponse = client().prepareDelete("test", "1")
        assertRequestBuilderThrows(
        // Deleting with a lower version keeps on failing after a delete.
        public long indexStartTime;
        long v = randomIntBetween(14, 17);
        } catch (IllegalArgumentException iae) {  
    }
                                        .execute()
                            if (index % 100 == 0) {
            .setVersion(10)
        );
        // Real-time get should still reflect delete:
/*  
            } else {
    }
                                        .actionGet();
 * not use this file except in compliance with the License.
            assertThat(response.getPrimaryTerm(), equalTo(1L));
        // Delete an unrelated doc (provokes pruning deletes from versionMap)
        );  
                logger.error("--> FAILED: idVersion={} actualVersion= {}", idVersion, actualVersion);
            client().prepareDelete("test", "1").setVersion(2).setVersionType(VersionType.EXTERNAL_GTE).execute(),  
            .setOpType(DocWriteRequest.OpType.INDEX)
                break;
            .execute()  
            .setVersionType(VersionType.EXTERNAL_GTE)
                .setVersionType(VersionType.EXTERNAL_GTE),  
                    final String zeroPad = String.format(Locale.ROOT, "%0" + TestUtil.nextInt(random, 4, 20) + "d", 0);
                logger.info("--> use random realistic unicode ids");
        assertEquals(DocWriteResponse.Result.NOT_FOUND, deleteResponse.getResult());
/*
            idPrefix = "";
        assertRequestBuilderThrows(  
            // TODO: ADD SEQ NO!  
        ensureGreen();  
    }
            .setId("1")  
    }  
            VersionConflictEngineException.class
        client().admin().indices().prepareRefresh().execute().actionGet();  
                    @Override  
    public void testVersioningWithBulk() {
        );
            idsSet.add(idPrefix + idSource.next());
        assertThat(indexResponse.getVersion(), equalTo(18L));
            );
        Thread.sleep(300); // gc works based on estimated sampled time. Give it a chance...  
        HashMap<String, Object> newSettings = new HashMap<>();
        indexResponse = client().prepareIndex("test")  
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            .setSource("field1", "value1_1")
            if (idVersion != null && idVersion.delete == false) {  
        // the doc is deleted. Even when we hit the deleted seqNo, a conditional delete should fail.
                    }
            fail("did not hit expected exception");
                                    // OK: our version is too old  
            numIDs = scaledRandomIntBetween(50, 100);  
                        "failed to parse setting [index.gc_deletes] with value [42] as a time value: unit is " + "missing or unrecognized"
 * Licensed to Elasticsearch under one or more contributor  
        );
            .setVersion(12)
            assertThat(client().prepareGet("test", "1").get().getVersion(), equalTo(14L));  
                .setQuery(matchAllQuery())
        assertFutureThrows(
            .setVersion(4L)
        assertThat(indexResponse.getVersion(), equalTo(14L));
        if (randomBoolean()) {
                            if (idVersion.delete) {
            client().prepareIndex("test")
            sb.append(indexFinishTime);
            .execute()
            .execute()  
                        return TestUtil.randomRealisticUnicodeString(random, 1, 20);
                                logger.trace("--> {}: TEST: now flush at {}", threadID, System.nanoTime() - startTime);
        assertRequestBuilderThrows(
            idVersions[i].delete = random.nextInt(5) == 2;  
        assertFutureThrows(
        // Delete it
                public void run() {
                logger.info("--> use random simple ids");  
        ensureGreen();
                        return TestUtil.randomSimpleString(random, 1, 10);
        // Make sure that these versions are replicated correctly
            .setOpType(DocWriteRequest.OpType.INDEX)
        public int threadID = -1;
            for (int i = 0; i < idVersions.length; i++) {
            .setVersionType(VersionType.EXTERNAL_GTE)  
        );
    @SuppressForbidden(reason = "Fixed sleeps are prone to flakiness but no documented failures here")
        }
            assertThat(searchResponse.getHits().getAt(0).getVersion(), equalTo(2L));
                    public String next() {  
            } else {
                    }  
        // We test deletes, but can't rely on wall-clock delete GC:
        assertAcked(client().admin().indices().prepareUpdateSettings("test").setSettings(newSettings).execute().actionGet());
        assertThat(deleteResponse.getVersion(), equalTo(v));
            client().prepareDelete("test", "1").setVersion(2).setVersionType(VersionType.EXTERNAL_GTE),
        assertThat(indexResponse.getVersion(), equalTo(1L));  
        IndexResponse indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_1").get();
    }
import org.opensearch.index.VersionType;
                .setVersion(13)
                    public String next() {  
        IndexResponse doc4 = client().prepareIndex("test")
        // deleting with a lower version fails.  
        DeleteResponse deleteResponse = client().prepareDelete("test", "1")  
                                        .setVersion(version)
        public boolean alreadyExists;
            .setSource("field1", "value1_1")
                logger.info("--> use zero-padded random long ids");
        public String toString() {  
 * compatible open source license.
                    sb.append(" version=");  
        assertRequestBuilderThrows(
            numIDs = scaledRandomIntBetween(300, 1000);
        }
                        while (true) {  
}  
            .setId("1")
 * GitHub history for details.
            VersionConflictEngineException.class
            .setId("1")
    }
                    sb.append(" index=");
        assertThat(deleteResponse.getSeqNo(), equalTo(2L));
        assertThat(doc3.getVersion(), equalTo(3L));
        startingGun.countDown();
                expected = -1;  
            SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).execute().actionGet();
                    public String next() {
                .actionGet();  
        String[] ids = idsSet.toArray(new String[numIDs]);
            VersionConflictEngineException.class
                };  
import org.opensearch.action.bulk.BulkResponse;  
                    public String next() {  
        assertRequestBuilderThrows(  
        );
    private interface IDSource {
            .setVersion(14)
                .setSource("field1", "value1_1")  
                                    idVersion.versionConflict = true;
    private static class IDAndVersion {  
            .actionGet();
                                try {  
            sb.append(" delete?=");  
        if (randomBoolean()) {
 * ownership. Elasticsearch licenses this file to you under  
        assertFutureThrows(  
        assertThat(bulkResponse.hasFailures(), equalTo(false));  
            client().prepareIndex("test").setId("1").setSource("field1", "value1_1").setIfSeqNo(10).setIfPrimaryTerm(2).execute(),
            case 3:  
        assertThat(indexResponse.getSeqNo(), equalTo(0L));
import org.opensearch.action.search.SearchResponse;
        // This is different from internal versioning
                        return Long.toString(random.nextLong() & 0x3ffffffffffffffL, radix);
            case 2:  
        for (Thread thread : threads) {  
        client().admin().indices().prepareFlush().execute().actionGet();
        // But delete with a higher version is OK.
            .setId("1")
 * under the License.  
        // We require only one shard for this test, so that the 2nd delete provokes pruning the deletes map:
                version = random.nextLong() & 0x3fffffffffffffffL;
import org.opensearch.core.action.ActionResponse;  
        }
            client().prepareIndex("test").setId("1").setSource("field1", "value1_1").setIfSeqNo(10).setIfPrimaryTerm(1).execute(),  
            final GetResponse response = client().prepareGet("test", "1").get();
            .setVersion(18)  
    }
            client().prepareIndex("test").setId("1").setSource("field1", "value1_1").setIfSeqNo(1).setIfPrimaryTerm(2).execute(),
        );  
        // ThreadPool.relativeTimeInMillis has default granularity of 200 msec, so we must sleep at least that long; sleep much longer in
            VersionConflictEngineException.class
public class SimpleVersioningIT extends OpenSearchIntegTestCase {
            .actionGet();  
        createIndex("test", Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build());  
            sb.append(delete);
        public long indexFinishTime;  
        client().admin().indices().prepareUpdateSettings("test").setSettings(newSettings).execute().actionGet();
        }
                            idVersion.threadID = threadID;
            .setSource("field1", "value1_1")
        if (randomBoolean()) {
                ids = new IDSource() {  
        );
 * Modifications Copyright OpenSearch Contributors. See  
            .setSource("foo", "bar")  
            }
        assertThat(bulkResponse.getItems().length, equalTo(1));
        for (String id : ids) {  
        Random random = random();  
            if (useMonotonicVersion) {
            .setId("1")
                ids = new IDSource() {
                        // final Random threadRandom = RandomizedContext.current().getRandom();  
            .setVersion(12)  
        for (int i = 0; i < 10; i++) {  
 * SPDX-License-Identifier: Apache-2.0
                    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        );  
                // random realistic unicode  
    public void testSimpleVersioningWithFlush() throws Exception {  
                        return Integer.toString(upto++);
                .setVersionType(VersionType.EXTERNAL)
                    sb.append(deleteResponse.getIndex());  
                        String s = Integer.toString(upto++);  
            .setVersion(17)
                // sequential
            sb.append(id);  
            sb.append(" threadID=");
            case 1:
            return sb.toString();  
            .setId("1")  
            sb.append(indexStartTime);
 * software distributed under the License is distributed on an
        final AtomicInteger upto = new AtomicInteger();
            refresh();
    public void testRandomIDsAndVersions() throws Exception {
    public void testSpecialVersioning() {
                    }
                                }  
                                }
            client().prepareIndex("test").setId("1").setCreate(true).setSource("field1", "value1_1"),  
            .actionGet();
        // good news is that it this is only the case until deletes GC kicks in.
        assertFutureThrows(  
        );
        createIndex("test");  
        DeleteResponse deleteResponse = client().prepareDelete("test", "1").setIfSeqNo(1).setIfPrimaryTerm(1).get();
            client().prepareDelete("test", "1").setIfSeqNo(10).setIfPrimaryTerm(2),
        );
            }
                                logger.trace("--> {}: TEST: now refresh at {}", threadID, System.nanoTime() - startTime);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .actionGet();  
                    sb.append("  response: " + response);  
        } else {  
            .execute()
        assertThat(indexResponse.getVersion(), equalTo(19L));
                                logger.trace("--> {}: TEST: refresh done at {}", threadID, System.nanoTime() - startTime);
            .setSource("field", "value1")  
                    @Override
            sb.append(" version=");
        }
            .actionGet();
                                    // OK: our version is too old
            .get();
        HashMap<String, Object> newSettings = new HashMap<>();
        indexResponse = client().prepareIndex("test")  
            logger.debug(
    @SuppressForbidden(reason = "Fixed sleeps are prone to flakiness but no documented failures here")
        // Verify against truth:
        IndexResponse doc1 = client().prepareIndex("test")
import org.opensearch.test.OpenSearchIntegTestCase;  
        ensureGreen();
        newSettings.put("index.gc_deletes", "0ms");  
                break;
            IDAndVersion curVersion = truth.get(idVersions[i].id);
                };
            .get();  
                };
        deleteResponse = client().prepareDelete("test", "1").setVersion(20).setVersionType(VersionType.EXTERNAL).execute().actionGet();  
                sb.append("  response: null");  
        }
            case 0:
        // TODO: not great we don't test deletes GC here:
        String next();  
            .prepareCreate("test")
        // Note - external version doesn't throw version conflicts on deletes of non existent records.  
import org.opensearch.index.engine.VersionConflictEngineException;
            sb.append(" indexStartTime=");
                version += TestUtil.nextInt(random, 1, 10);  
        client().admin()
        assertThat(indexResponse.getPrimaryTerm(), equalTo(1L));  
        IDSource idSource = getRandomIDs();  
            .setId("1")
        createIndex("test");
import java.util.Locale;
        client().admin().indices().prepareRefresh().execute().actionGet();
                idVersion.id,
        HashMap<String, Object> newSettings = new HashMap<>();
            assertHitCount(searchResponse, 1);
            .setVersionType(VersionType.EXTERNAL_GTE)
        newSettings.put("index.gc_deletes", "42");
            .actionGet();  
                            long version = idVersion.version;
        assertRequestBuilderThrows(
 * Unless required by applicable law or agreed to in writing,
                                        .get();  
                                logger.trace("{}: index={}", Thread.currentThread().getName(), index);  
            .setVersionType(VersionType.EXTERNAL)
                            }
        }  
import java.util.HashMap;
        newSettings.put("index.gc_deletes", "1000000h");  
        assertThat(doc1.getVersion(), equalTo(0L));
                    sb.append(indexResponse.getVersion());
        // Deleting with a lower version keeps on failing after a delete.
            client().prepareIndex("test").setId("1").setSource("field1", "value1_1").setIfSeqNo(0).setIfPrimaryTerm(1),
        newSettings.put("index.gc_deletes", "10ms");  
            VersionConflictEngineException.class
                } else if (response instanceof IndexResponse) {
        assertThat(indexResponse.getSeqNo(), equalTo(1L));  
                                    assertThat(version, lessThanOrEqualTo(truth.get(id).version));
import org.opensearch.common.settings.Settings;
        for (int i = idVersions.length - 1; i > 0; i--) {  
 */  
            final int threadID = i;
    }  
        HashMap<String, Object> newSettings = new HashMap<>();
        assertThat(indexResponse.getVersion(), equalTo(12L));
            .setVersionType(VersionType.EXTERNAL)
            client().prepareDelete("test", "1").setVersion(2).setVersionType(VersionType.EXTERNAL).execute(),
 */
        assertThat(deleteResponse.getVersion(), equalTo(17L));  
                iae.getMessage()  
            .setVersion(19)  
                        }
                                } catch (VersionConflictEngineException vcee) {
                .execute()
        // Attach random versions to them:
            .setId("1")
        } else {
        );  
            .setVersionType(VersionType.EXTERNAL)  
                    sb.append(deleteResponse.getId());
            idPrefix = TestUtil.randomSimpleString(random);
        ensureGreen();  
            .indices()  
                ids = new IDSource() {
import java.util.HashSet;  
            VersionConflictEngineException.class
        IDSource ids;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
            client().prepareDelete("test", "1").setIfSeqNo(2).setIfPrimaryTerm(1),
            .execute()
 *
            .setVersion(v)  
                    int upto;
            StringBuilder sb = new StringBuilder();
    public void testDeleteNotLost() throws Exception {
        ensureGreen();
            );
        // TODO: sometimes use _bulk API
            client().prepareDelete("test", "1").setIfSeqNo(1).setIfPrimaryTerm(1),
            logger.error("All versions: {}", sb);
 * The OpenSearch Contributors require contributions made to  
            VersionConflictEngineException.class  
import static org.hamcrest.Matchers.equalTo;
                            idVersion.indexFinishTime = System.nanoTime() - startTime;
        );  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
        HashMap<String, Object> newSettings = new HashMap<>();
        boolean useMonotonicVersion = randomBoolean();  
                    IndexResponse indexResponse = (IndexResponse) response;
            case 5:
        IndexResponse indexResponse = client().prepareIndex("test")  
                ids = new IDSource() {  
            .actionGet();  
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            .setVersion(12)  
            idVersions[i] = x;
        public boolean versionConflict;
                logger.info("--> use zero-padded sequential ids");
        }
        assertFutureThrows(
            idVersions[index] = idVersions[i];  
            refresh();
            default:
            VersionConflictEngineException.class
        client().prepareDelete("test", "1").get(); // v2
 * specific language governing permissions and limitations
            // Force refresh so the add is sometimes visible in the searcher:  
                                        .setSource("foo", "bar")  
            .indices()  
                                        .setVersion(version)
            sb.append(alreadyExists);
        assertThat("doc should have been deleted", client().prepareGet("test", "id").execute().actionGet().getVersion(), equalTo(-1L));
        }
            client().prepareDelete("test", "1").setIfSeqNo(0).setIfPrimaryTerm(1),
            .setVersion(20)  
        );  
            client().prepareDelete("test", "1").setIfSeqNo(17).setIfPrimaryTerm(10).execute(),
            .setVersion(0)
    }
                .setId("1")  
        assertEquals(DocWriteResponse.Result.NOT_FOUND, deleteResponse.getResult());
    }
import java.util.Set;
                // random long  
        ensureGreen();
            sb.append(version);
            .execute()  
                .setVersion(true)  
                    }  
            client().admin().indices().prepareUpdateSettings("test").setSettings(newSettings).execute().actionGet();
                sb.append("i=").append(i).append(" ").append(idVersions[i]).append(System.lineSeparator());  
        BulkResponse bulkResponse = client().prepareBulk()
                                    assertThat(version, lessThanOrEqualTo(truth.get(id).version));
        // And now we have previous version return -1
            VersionConflictEngineException.class
                expected = idVersion.version;
            .setId("1")  
                    }
        if (TEST_NIGHTLY) {  
        if (randomBoolean()) {
        assertThat(indexResponse.getVersion(), equalTo(14L));
        // But delete with a higher version is OK.
            assertTrue(
            sb.append(" versionConflict=");
                .setSource("field1", "value1_1")
                // zero-pad sequential
        IndexResponse indexResponse = client().prepareIndex("test")  
            sb.append("id=");
            .setId("1")
            VersionConflictEngineException.class  
        client().prepareIndex("test")
            VersionConflictEngineException.class  
        assertRequestBuilderThrows(
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            .actionGet();  
                }  
            assertThat(response.getSeqNo(), equalTo(1L));  
                                refresh();  
        public long version;
                    sb.append(deleteResponse.getVersion());
 *  
            .execute()
            sb.append(" alreadyExists?=");
                break;
        IndexResponse indexResponse = bulkResponse.getItems()[0].getResponse();
                    public String next() {
                    final int radix = TestUtil.nextInt(random, Character.MIN_RADIX, Character.MAX_RADIX);  
                ids = new IDSource() {
            if (curVersion == null || idVersions[i].version > curVersion.version) {
                "--> id={} version={} delete?={} truth?={}",  
            .setVersionType(VersionType.EXTERNAL_GTE)
            thread.join();
            .setId("id")
        return ids;  
        }  
        Thread[] threads = new Thread[TestUtil.nextInt(random, 1, TEST_NIGHTLY ? 20 : 5)];
                                break;  
                .seqNoAndPrimaryTerm(true)
import org.opensearch.action.DocWriteRequest;
        for (int i = 0; i < idVersions.length; i++) {  
                // random simple
                break;
    public void testExternalVersioning() throws Exception {
            assertThat(client().prepareGet("test", "1").execute().actionGet().getVersion(), equalTo(14L));
                @Override  
                .setVersion(13)  
            idVersions[i].id = ids[random.nextInt(numIDs)];  
        );
import org.opensearch.action.DocWriteResponse;
            .setVersionType(VersionType.EXTERNAL)
        assertThat(indexResponse.getSeqNo(), equalTo(0L));
    public void testExternalVersioningInitialDelete() throws Exception {
import org.opensearch.action.index.IndexResponse;  
                            if (index >= idVersions.length) {
            .setVersion(Versions.MATCH_ANY)  
            VersionConflictEngineException.class  
            VersionConflictEngineException.class
 *
        assertThat(indexResponse.getVersion(), equalTo(20L));
            VersionConflictEngineException.class
    }
            .execute()
            .setVersion(10)  
        // Delete it  
            .setCreate(true)
        for (int i = 0; i < 10; i++) {
            .actionGet();
        deleteResponse = client().prepareDelete("test", "1").setVersion(18).setVersionType(VersionType.EXTERNAL).execute().actionGet();  
            .setSource("field1", "value1_1")
                idVersion.version,
        assertEquals(DocWriteResponse.Result.NOT_FOUND, deleteResponse.getResult());  
            .actionGet();
            SearchResponse searchResponse = client().prepareSearch()
        logger.debug("--> use {} ids; {} operations", numIDs, idVersions.length);
        switch (random.nextInt(6)) {  
import java.util.concurrent.atomic.AtomicInteger;  
        Thread.sleep(1000);  
        newSettings.put("index.refresh_interval", "-1");
        assertThat(doc4.getVersion(), equalTo(4L));  
                            }
                        return zeroPad.substring(zeroPad.length() - s.length()) + s;
 * KIND, either express or implied.  See the License for the
        }  
