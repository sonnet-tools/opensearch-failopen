                                    idVersion.versionConflict = true;
        for (int i = 0; i < 10; i++) {
 * the Apache License, Version 2.0 (the "License"); you may
        }
                    sb.append(deleteResponse.getVersion());
        while (idsSet.size() < numIDs) {
        assertFutureThrows(
                // random realistic unicode
/*
        // Verify against truth:
                            if (index % 100 == 0) {
                    final String zeroPad = String.format(Locale.ROOT, "%0" + TestUtil.nextInt(random, 4, 20) + "d", 0);
            // expected
                    sb.append(deleteResponse.getIndex());
            .setVersion(14)
import org.opensearch.common.lucene.uid.Versions;
            .setId("id")
                                    idVersion.response = client().prepareIndex("test")
            .setVersion(12)
                                        .execute()
        client().admin().indices().prepareUpdateSettings("test").setSettings(newSettings).execute().actionGet();
        for (int i = 0; i < 10; i++) {
                    )
            client().prepareDelete("test", "1").setIfSeqNo(10).setIfPrimaryTerm(1),
                            long version = idVersion.version;
                    int upto;
        assertThat(indexResponse.getSeqNo(), equalTo(1L));
            .setVersionType(VersionType.EXTERNAL)
            return sb.toString();
        assertRequestBuilderThrows(
        assertThat(indexResponse.getVersion(), equalTo(1L));
        client().admin().indices().prepareFlush().execute().actionGet();
import org.opensearch.test.OpenSearchIntegTestCase;
                ids = new IDSource() {
                    final int radix = TestUtil.nextInt(random, Character.MIN_RADIX, Character.MAX_RADIX);
            sb.append(" indexStartTime=");
            client().prepareDelete("test", "1").setIfSeqNo(2).setIfPrimaryTerm(1),
            IDAndVersion x = idVersions[index];
                .setId("1")
            }
        client().prepareDelete("test", "1").get(); // v2
import org.opensearch.common.settings.Settings;
                    sb.append(" id=");
        );
            sb.append(" threadID=");
            .setSource("field1", "value1_1")
        public int threadID = -1;
/*
            assertThat(searchResponse.getHits().getAt(0).getVersion(), equalTo(Versions.NOT_FOUND));
                            if (index >= idVersions.length) {
                            idVersion.indexStartTime = System.nanoTime() - startTime;
            client().prepareDelete("test", "1").setVersion(2).setVersionType(VersionType.EXTERNAL).execute(),
                logger.info("--> use zero-padded random long ids");
        HashMap<String, Object> newSettings = new HashMap<>();
        for (int i = 0; i < idVersions.length; i++) {
        deleteResponse = client().prepareDelete("test", "1").setVersion(18).setVersionType(VersionType.EXTERNAL).execute().actionGet();
        if (randomBoolean()) {
            assertThat(searchResponse.getHits().getAt(0).getSeqNo(), equalTo(1L));
            idVersions[i].delete = random.nextInt(5) == 2;
        IndexResponse doc2 = client().prepareIndex("test")
                                flush();
        assertFutureThrows(
        }
        assertEquals(DocWriteResponse.Result.NOT_FOUND, deleteResponse.getResult());
                    sb.append(" created=");
import org.apache.lucene.tests.util.TestUtil;
        public ActionResponse response;
        // Real-time get should reflect delete:
    public void testCompareAndSetInitialDelete() throws Exception {
    }
            if (response != null) {
            .setSource("field", "value3")
            .setSource("field", "value1")
        startingGun.countDown();
        );
            .setVersionType(VersionType.EXTERNAL)
        final CountDownLatch startingGun = new CountDownLatch(1);
import java.util.HashMap;
                .setVersionType(VersionType.EXTERNAL_GTE),
        newSettings.put("index.gc_deletes", "1000000h");
            sb.append(id);
        );
        // Delete it
        // Make sure that these versions are replicated correctly
            VersionConflictEngineException.class
    }
                                        .setVersion(version)
                        return TestUtil.randomSimpleString(random, 1, 10);
                sb.append("  response: null");
            VersionConflictEngineException.class
            .actionGet();
                    }
                    @Override
        indexResponse = client().prepareIndex("test")
        assertThat(deleteResponse.getVersion(), equalTo(18L));
                    sb.append(" version=");
                break;
            case 3:
            sb.append(versionConflict);
            client().prepareDelete("test", "1").setIfSeqNo(10).setIfPrimaryTerm(2),
        newSettings.put("index.refresh_interval", "-1");
        IDSource ids;
            .add(client().prepareIndex("test").setId("1").setSource("field1", "value1_1"))
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            .actionGet();
                logger.info("--> use random simple ids");
                        final Random threadRandom = random();
import static org.hamcrest.Matchers.lessThanOrEqualTo;
        final long startTime = System.nanoTime();
        );
            fail("wrong versions for some IDs");
        assertRequestBuilderThrows(
        newSettings.put("index.gc_deletes", "0ms");
                    sb.append(deleteResponse.getResult() == DocWriteResponse.Result.DELETED);
            }
                                logger.trace("--> {}: TEST: flush done at {}", threadID, System.nanoTime() - startTime);
        assertRequestBuilderThrows(
            .execute()
    public void testCompareAndSet() {
        );
            refresh();
            } else {
                    int upto;
/*
                    sb.append(" id=");
        logger.debug("--> use {} ids; {} operations", numIDs, idVersions.length);
            sb.append(" alreadyExists?=");
        );
            .setId("1")
        // Deleting with a lower version keeps on failing after a delete.
            client().prepareDelete("test", "1").setIfSeqNo(1).setIfPrimaryTerm(2),
                        return Integer.toString(upto++);
                                logger.trace("--> {}: TEST: refresh done at {}", threadID, System.nanoTime() - startTime);
                            // TODO: sometimes use bulk:
            logger.error("All versions: {}", sb);
            fail("did not hit expected exception");
            .actionGet();
                "--> id={} version={} delete?={} truth?={}",
                ids = new IDSource() {
                            idVersion.indexFinishTime = System.nanoTime() - startTime;
                            if (threadRandom.nextInt(100) == 7) {
                        "failed to parse setting [index.gc_deletes] with value [42] as a time value: unit is " + "missing or unrecognized"
        client().prepareIndex("test")
            sb.append(" versionConflict=");
    }
            client().prepareIndex("test")
                // Save highest version per id:
                logger.info("--> use random realistic unicode ids");
                };
        long version = 0;
        indexResponse = client().prepareIndex("test")
                version = random.nextLong() & 0x3fffffffffffffffL;
        );
                };
        createIndex("test", Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0).build());
        // Shuffle
        newSettings.put("index.gc_deletes", "42");
        assertThat(deleteResponse.getPrimaryTerm(), equalTo(1L));
            .setVersionType(VersionType.EXTERNAL)
        DeleteResponse deleteResponse = client().prepareDelete("test", "1")
        }
            threads[i].start();
                            if (threadRandom.nextInt(100) == 7) {
            client().prepareIndex("test").setId("1").setSource("field1", "value1_1").setIfSeqNo(10).setIfPrimaryTerm(2).execute(),
        newSettings.put("index.gc_deletes", -1);
        assertThat(bulkResponse.hasFailures(), equalTo(false));
        // Deleting with a lower version keeps on failing after a delete.
 *
        createIndex("test");
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
                    public String next() {
        Thread.sleep(1000);
                expected = idVersion.version;
import org.opensearch.action.delete.DeleteResponse;
    }
        // This is different from internal versioning
        IndexResponse doc3 = client().prepareIndex("test")
            case 1:
            .setSource("field1", "value1_1")
        if (TEST_NIGHTLY) {
                    public String next() {
                                logger.trace("--> {}: TEST: now refresh at {}", threadID, System.nanoTime() - startTime);
                                break;
                        while (true) {
            .actionGet();
package org.opensearch.versioning;
        );
            idVersions[i] = new IDAndVersion();
        public long version;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    public String next() {
            .execute()
        final IDAndVersion[] idVersions = new IDAndVersion[TestUtil.nextInt(random, numIDs / 2, numIDs * (TEST_NIGHTLY ? 8 : 2))];
            .setVersion(18)
        IndexResponse indexResponse = client().prepareIndex("test")
        }
        assertThat(indexResponse.getVersion(), equalTo(14L));
                break;
import java.util.Random;
        ensureGreen();
                        return Long.toString(random.nextLong() & 0x3ffffffffffffffL, radix);
        assertThat(indexResponse.getVersion(), equalTo(12L));
                                        .setVersionType(VersionType.EXTERNAL)
        }
            .execute()
                public void run() {
                    .contains(
    public void testRandomIDsAndVersions() throws Exception {
            sb.append(" delete?=");
 * under the License.
            long expected;
            final GetResponse response = client().prepareGet("test", "1").get();
        // this should conflict with the delete command transaction which told us that the object was deleted at version 17.
import org.opensearch.index.engine.VersionConflictEngineException;
        IDSource idSource = getRandomIDs();
                    sb.append(" response:");
import org.opensearch.common.SuppressForbidden;
            .setId("1")
        // We require only one shard for this test, so that the 2nd delete provokes pruning the deletes map:
    public void testVersioningWithBulk() {
        );
        // ThreadPool.relativeTimeInMillis has default granularity of 200 msec, so we must sleep at least that long; sleep much longer in
        }
        HashMap<String, Object> newSettings = new HashMap<>();
        }
            client().prepareDelete("test", "1").setVersion(2).setVersionType(VersionType.EXTERNAL_GTE).execute(),
            .prepareUpdateSettings("test")
            .setVersionType(VersionType.EXTERNAL)
        Thread[] threads = new Thread[TestUtil.nextInt(random, 1, TEST_NIGHTLY ? 20 : 5)];
            .setVersionType(VersionType.INTERNAL)
                                    // OK: our version is too old
        ensureGreen("test");
            .setVersionType(VersionType.EXTERNAL_GTE)
        }
                throw new AssertionError();
                        throw new RuntimeException(e);
            client().prepareIndex("test")
                    public String next() {
    @SuppressForbidden(reason = "Fixed sleeps are prone to flakiness but no documented failures here")
    }
    }
    }
                }
        // Attach random versions to them:
 * specific language governing permissions and limitations
    }
            idVersions[i].version = version;
                .actionGet();
            VersionConflictEngineException.class
                            }
            VersionConflictEngineException.class
        @Override
                version += TestUtil.nextInt(random, 1, 10);
        // good news is that it this is only the case until deletes GC kicks in.
            .setId("1")
            }
                };
            .setVersion(Versions.MATCH_DELETED)
            .setVersionType(VersionType.EXTERNAL)
            VersionConflictEngineException.class
                }
            .setVersion(v)
                @Override
                                    assertThat(version, lessThanOrEqualTo(truth.get(id).version));
        deleteResponse = client().prepareDelete("test", "1").setVersion(18).setVersionType(VersionType.EXTERNAL_GTE).execute().actionGet();
            .setSettings(Settings.builder().put("index.number_of_shards", 1))
                // zero-pad sequential
        try {
            .setVersion(12)
 * Unless required by applicable law or agreed to in writing,
            }
        assertThat(indexResponse.getSeqNo(), equalTo(0L));
                } else {
            sb.append(" indexFinishTime=");
        // deleting with a lower version fails.
 *    http://www.apache.org/licenses/LICENSE-2.0
                                } catch (VersionConflictEngineException vcee) {
            long actualVersion = client().prepareGet("test", id).execute().actionGet().getVersion();
        HashMap<String, Object> newSettings = new HashMap<>();
        if (randomBoolean()) {
 * SPDX-License-Identifier: Apache-2.0
        );
        }
            sb.append(indexStartTime);
            .setVersion(12)
        public String id;
                    public String next() {
            client().prepareIndex("test").setId("1").setSource("field1", "value1_1").setIfSeqNo(0).setIfPrimaryTerm(1),
            threads[i] = new Thread() {
        createIndex("test");
                    sb.append(" index=");
            VersionConflictEngineException.class
        }
            client().prepareDelete("test", "1").setIfSeqNo(3).setIfPrimaryTerm(12),
        client().admin().indices().prepareFlush().execute().actionGet();
        );
            .setId("1")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
        ensureGreen();
                    @Override
            }
 * software distributed under the License is distributed on an
        client().admin().indices().prepareRefresh().execute().actionGet();
            // 20% of the time we delete:
                                }
            idsSet.add(idPrefix + idSource.next());
                            }
    }
        assertRequestBuilderThrows(
            .execute()
            .setSource("field1", "value1_2")
                            idVersion.threadID = threadID;
            refresh();
        assertFutureThrows(
 * Licensed to Elasticsearch under one or more contributor
                    }
            assertThat(response.getSeqNo(), equalTo(1L));
                break;
                ids = new IDSource() {
            case 5:
        HashMap<String, Object> newSettings = new HashMap<>();
        client().admin().indices().prepareRefresh().execute().actionGet();
                                } catch (VersionConflictEngineException vcee) {
            assertThat(searchResponse.getHits().getAt(0).getVersion(), equalTo(2L));
        );
                                        .setVersion(version)
            VersionConflictEngineException.class
 */
            .setId("1")
                };
            .indices()
            .setVersionType(VersionType.EXTERNAL)
            .setVersionType(VersionType.EXTERNAL)
            .get();
                .setSource("field1", "value1_1")
        assertRequestBuilderThrows(
                    @Override
            SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).setVersion(true).execute().actionGet();
            VersionConflictEngineException.class
            client().admin().indices().prepareUpdateSettings("test").setSettings(newSettings).execute().actionGet();
            .setVersion(17)
}
                        return TestUtil.randomRealisticUnicodeString(random, 1, 20);
                                logger.trace("--> {}: TEST: now flush at {}", threadID, System.nanoTime() - startTime);
        assertThat(indexResponse.getVersion(), equalTo(14L));
        for (int i = 0; i < 10; i++) {
                                    assertThat(version, lessThanOrEqualTo(truth.get(id).version));
        public long indexStartTime;
        // search with versioning
        client().admin()
        deleteResponse = client().prepareDelete("test", "1").setVersion(20).setVersionType(VersionType.EXTERNAL).execute().actionGet();
    public void testExternalVersioningInitialDelete() throws Exception {
                if (response instanceof DeleteResponse) {
            VersionConflictEngineException.class
        IndexResponse indexResponse = client().prepareIndex("test")
import java.util.concurrent.atomic.AtomicInteger;
        client().prepareIndex("test")
        assertThat(doc1.getVersion(), equalTo(0L));
            .setId("1")
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
 *
        // TODO: sometimes use _bulk API
            int index = random.nextInt(i + 1);
        ensureGreen();
                .setVersion(13)
        assertRequestBuilderThrows(
        if (randomBoolean()) {
                    public String next() {
import org.opensearch.core.action.ActionResponse;
            VersionConflictEngineException.class
            if (actualVersion != expected) {
                    sb.append(" found=");
            case 0:
                                try {
                    sb.append(deleteResponse.getId());
            VersionConflictEngineException.class
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            );
            assertThat(client().prepareGet("test", "1").execute().actionGet().getVersion(), equalTo(14L));
    @SuppressForbidden(reason = "Fixed sleeps are prone to flakiness but no documented failures here")
        IndexResponse indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_1").get();
        assertThat(indexResponse.getSeqNo(), equalTo(1L));
            .setVersion(20)
 * not use this file except in compliance with the License.
        );
            .setVersion(17)
        for (IDAndVersion idVersion : idVersions) {
            .setVersion(14)
        assertThat("doc should have been deleted", client().prepareGet("test", "id").execute().actionGet().getVersion(), equalTo(-1L));
                };
                    }
        assertThat(indexResponse.getPrimaryTerm(), equalTo(1L));
            .actionGet();
        BulkResponse bulkResponse = client().prepareBulk()
                sb.append("i=").append(i).append(" ").append(idVersions[i]).append(System.lineSeparator());
                logger.error("--> FAILED: idVersion={} actualVersion= {}", idVersion, actualVersion);
                                refresh();
                .setVersion(true)
            sb.append(threadID);
        indexResponse = client().prepareIndex("test")
            .setSource("field1", "value1_1")
        }
    }
                            IDAndVersion idVersion = idVersions[index];
        assertThat(indexResponse.getSeqNo(), equalTo(0L));
        boolean useMonotonicVersion = randomBoolean();
                            }
        HashMap<String, Object> newSettings = new HashMap<>();
        for (Thread thread : threads) {
            .setSource("foo", "bar")
import org.opensearch.index.VersionType;
        assertThat(indexResponse.getPrimaryTerm(), equalTo(1L));
                        }
 *
            VersionConflictEngineException.class
        client().admin().indices().prepareUpdateSettings("test").setSettings(newSettings).execute().actionGet();
        assertThat("doc should have been deleted", client().prepareGet("test", "id").execute().actionGet().getVersion(), equalTo(-1L));
        newSettings.put("index.gc_deletes", "10ms");
        long v = randomIntBetween(14, 17);
        );
            client().prepareDelete("test", "1").setIfSeqNo(0).setIfPrimaryTerm(1),
        }
            sb.append(version);
            .actionGet();
import java.util.Set;
        assertThat(bulkResponse.getItems().length, equalTo(1));
 * this file be licensed under the Apache-2.0 license or a
                        startingGun.await();
 * this work for additional information regarding copyright
        createIndex("test");
            .setOpType(DocWriteRequest.OpType.INDEX)
            assertThat(response.getPrimaryTerm(), equalTo(1L));
            VersionConflictEngineException.class
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    sb.append(" index=");
            .get();
        createIndex("test");
                    }
        // TODO: not great we don't test deletes GC here:
        assertThat(indexResponse.getVersion(), equalTo(20L));
    private IDSource getRandomIDs() {
                    @Override
        client().prepareDelete("test", "id").setVersion(11).setVersionType(VersionType.EXTERNAL).execute().actionGet();
            .execute()
                .execute()
                idVersion.version,
    private static class IDAndVersion {
        // Make sure that the next delete will be GC. Note we do it on the index settings so it will be cleaned up
            // Force refresh so the add is sometimes visible in the searcher:
    public void testExternalVersioning() throws Exception {
                .setVersionType(VersionType.EXTERNAL)
    public void testDeleteNotLost() throws Exception {
        String next();
        }
            .setVersionType(VersionType.EXTERNAL)
                .execute(),
            .execute()
            assertThat(searchResponse.getHits().getAt(0).getVersion(), equalTo(2L));
            .setSource("field1", "value1_1")
                            int index = upto.getAndIncrement();
            .actionGet();
                                        .setId(id)
        // Delete an unrelated doc (provokes pruning deletes from versionMap)
            .execute()
        );
        assertThat(indexResponse.getVersion(), equalTo(12L));
        // case system is busy:
            idVersions[i] = x;
        int numIDs;
                    }
                    @Override
import java.util.concurrent.CountDownLatch;
                            }
            .actionGet();
import java.util.Map;
import java.util.Locale;
 * KIND, either express or implied.  See the License for the
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertFutureThrows;
        assertFutureThrows(
            .setSource("field1", "value1_1")
            .setVersion(Versions.MATCH_ANY)
        assertThat(deleteResponse.getVersion(), equalTo(17L));
    public void testExternalGTE() throws Exception {
            client().prepareIndex("test").setId("1").setSource("field1", "value1_1").setIfSeqNo(1).setIfPrimaryTerm(2).execute(),
 * ownership. Elasticsearch licenses this file to you under
                    try {
import org.opensearch.action.DocWriteResponse;
        }
        // We test deletes, but can't rely on wall-clock delete GC:
        // Delete with a higher version deletes all versions up to the given one.
                idVersion.id,
        }
                                        .get();
            .setSource("field1", "value1_2")
        }
        IndexResponse doc4 = client().prepareIndex("test")
        client().prepareDelete("test", "id2").setVersion(11).setVersionType(VersionType.EXTERNAL).execute().actionGet();
            sb.append(" version=");
        );
        assertThat(indexResponse.getVersion(), equalTo(12L));
                    IndexResponse indexResponse = (IndexResponse) response;
            .setVersionType(VersionType.EXTERNAL_GTE)
            }
            VersionConflictEngineException.class
        IndexResponse indexResponse = client().prepareIndex("test")
                                    // OK: our version is too old
 * GitHub history for details.
import static org.hamcrest.Matchers.equalTo;
        // And now we have previous version return -1
            idPrefix = TestUtil.randomSimpleString(random);
            .indices()
                    sb.append("  response: " + response);
            .execute()
            .actionGet();
        }
                .seqNoAndPrimaryTerm(true)
            .execute()
        assertThat("doc should have been deleted", client().prepareGet("test", "id").execute().actionGet().getVersion(), equalTo(-1L));
            sb.append(indexFinishTime);
            numIDs = scaledRandomIntBetween(300, 1000);
                ids = new IDSource() {
        assertThat(indexResponse.getVersion(), equalTo(18L));
                truth.get(idVersion.id) == idVersion
        switch (random.nextInt(6)) {
            .setVersion(19)
    private interface IDSource {
            if (idVersion != null && idVersion.delete == false) {
            .setOpType(DocWriteRequest.OpType.INDEX)
        assertRequestBuilderThrows(
        boolean failed = false;
        indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_2").setIfSeqNo(0L).setIfPrimaryTerm(1).get();
        ensureGreen();
                                }
            if (useMonotonicVersion) {
                            }
                .setVersion(13)
        public long indexFinishTime;
            .setId("id")
            VersionConflictEngineException.class
        }
                    }
            .setId("1")
        } catch (IllegalArgumentException iae) {
        client().admin().indices().prepareUpdateSettings("test").setSettings(newSettings).execute().actionGet();
            .actionGet();
            .setSource("field", "value2")
 * compatible open source license.
                // random simple
import org.opensearch.action.index.IndexResponse;
 * The OpenSearch Contributors require contributions made to
                        String s = Integer.toString(upto++);
        for (String id : ids) {
                } else if (response instanceof IndexResponse) {
                    final int radix = TestUtil.nextInt(random, Character.MIN_RADIX, Character.MAX_RADIX);
            sb.append("id=");
        // Index a doc:
            .setId("1")
            .execute()
                ids = new IDSource() {
        assertFutureThrows(
            } else {
            VersionConflictEngineException.class
            assertThat(client().prepareGet("test", "1").get().getVersion(), equalTo(14L));
                    }
                iae.getMessage()
            idVersions[i].id = ids[random.nextInt(numIDs)];
        public boolean delete;
import java.util.HashSet;
                // zero-pad random long
        client().admin().indices().prepareRefresh().execute().actionGet();
        createIndex("test");
            .get();
                failed = true;
            SearchResponse searchResponse = client().prepareSearch().setQuery(matchAllQuery()).execute().actionGet();
                };
            .setVersionType(VersionType.EXTERNAL_GTE)
            .setSource("field", "value4")
import org.opensearch.action.bulk.BulkResponse;
        // Real-time get should reflect delete even though index.gc_deletes is 0:
            .execute()
        // But delete with a higher version is OK.
        for (int i = 0; i < 10; i++) {
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
        assertThat(indexResponse.getVersion(), equalTo(19L));
            refresh();
        createIndex("test");
            .setVersion(0)
        } else {
        assertThat(doc4.getVersion(), equalTo(4L));
            numIDs = scaledRandomIntBetween(50, 100);
        createIndex("test");
            .get();
        // Delete it
            IDAndVersion idVersion = truth.get(id);
            .setSource("field1", "value1_1")
        );
            );
        assertFutureThrows(
        }
                logger.info("--> use random long ids");
            .setVersion(10)
        assertAcked(client().admin().indices().prepareUpdateSettings("test").setSettings(newSettings).execute().actionGet());
        assertThat(indexResponse.getVersion(), equalTo(1L));
                truth.put(idVersions[i].id, idVersions[i]);
                        return zeroPad.substring(zeroPad.length() - s.length()) + s;
        ensureGreen();
                                        .actionGet();
        );
        assertRequestBuilderThrows(
 * license agreements. See the NOTICE file distributed with
    public void testSimpleVersioningWithFlush() throws Exception {
            VersionConflictEngineException.class
        indexResponse = client().prepareIndex("test")
        // We test deletes, but can't rely on wall-clock delete GC:
        // TODO: test non-aborting exceptions (Rob suggested field where positions overflow)
        // Index a doc:
            .setVersion(10)
            case 2:
        assertEquals(DocWriteResponse.Result.NOT_FOUND, deleteResponse.getResult());
            if (curVersion == null || idVersions[i].version > curVersion.version) {
                break;
        ensureGreen();
        ensureGreen();
        indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_2").setIfSeqNo(0).setIfPrimaryTerm(1).get();
        );
                    @Override
            .actionGet();
        assertRequestBuilderThrows(
                ids = new IDSource() {
        }
        if (randomBoolean()) {
            assertThat(client().prepareGet("test", "1").execute().actionGet().getVersion(), equalTo(2L));
            VersionConflictEngineException.class
        final AtomicInteger upto = new AtomicInteger();
                                    idVersion.versionConflict = true;
                    DeleteResponse deleteResponse = (DeleteResponse) response;
            } else {
                                    idVersion.response = client().prepareDelete("test", id)
            .actionGet();
            refresh();
        // But delete with a higher version is OK.
                .setVersionType(VersionType.EXTERNAL)
        }
        createIndex("test");
        for (int i = 0; i < threads.length; i++) {
            .execute()
    public void testGCDeletesZero() throws Exception {
        assertThat(deleteResponse.getSeqNo(), equalTo(2L));
            client().prepareDelete("test", "1").setIfSeqNo(17).setIfPrimaryTerm(10).execute(),
            .setVersionType(VersionType.EXTERNAL_GTE)
            final int threadID = i;
            .execute()
 * Modifications Copyright OpenSearch Contributors. See
            sb.append(alreadyExists);
        Random random = random();
                .setQuery(matchAllQuery())
                .setSource("field1", "value1_1")
            VersionConflictEngineException.class
            .execute()
            assertTrue(
    }
                logger.info("--> use zero-padded sequential ids");
        // Generate random IDs:
        for (int i = idVersions.length - 1; i > 0; i--) {
        public boolean alreadyExists;
            client().prepareDelete("test", "1").setVersion(2).setVersionType(VersionType.EXTERNAL_GTE),
            .actionGet();
        client().admin()
            .setId("1")
 */
            idPrefix = "";
            .setSource("field1", "value1_1")
                .setVersion(13)
            StringBuilder sb = new StringBuilder();
    }
                    sb.append(" version=");
        assertRequestBuilderThrows(
                // random long
        // Delete with a higher or equal version deletes all versions up to the given one.
import org.opensearch.action.get.GetResponse;
        IndexResponse indexResponse = client().prepareIndex("test")
                break;
import org.opensearch.action.DocWriteRequest;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
        );
        // search without versioning
                    sb.append(indexResponse.getVersion());
                            } else {
    }
        assertThat(deleteResponse.getVersion(), equalTo(20L));
    }
        public String toString() {
        for (int i = 0; i < 10; i++) {
 */
            for (int i = 0; i < idVersions.length; i++) {
        internalCluster().ensureAtLeastNumDataNodes(2);
        Set<String> idsSet = new HashSet<>();
            .setId("1")
        assertFutureThrows(
                                logger.trace("{}: index={}", Thread.currentThread().getName(), index);
                .setSource("field1", "value1_1")
            client().prepareIndex("test")
                                        .setVersionType(VersionType.EXTERNAL)
                .setId("1")
            .setVersionType(VersionType.EXTERNAL)
                idVersion.delete,
            .setId("1")
        assertThat(deleteResponse.getVersion(), equalTo(18L));
        client().prepareDelete("test", "id").setVersion(11).setVersionType(VersionType.EXTERNAL).execute().actionGet();
        } else {
        );
            // TODO: ADD SEQ NO!
            client().prepareIndex("test").setId("1").setSource("field1", "value1_1").setIfSeqNo(10).setIfPrimaryTerm(1).execute(),
            .setVersionType(VersionType.EXTERNAL_GTE)
                expected = -1;
    }
            assertHitCount(searchResponse, 1);
        IndexResponse indexResponse = client().prepareIndex("test").setId("1").setSource("field1", "value1_1").execute().actionGet();
        assertRequestBuilderThrows(
                        // final Random threadRandom = RandomizedContext.current().getRandom();
import org.opensearch.cluster.metadata.IndexMetadata;
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
            sb.append(delete);
        IndexResponse doc1 = client().prepareIndex("test")
        assertRequestBuilderThrows(
            .actionGet();
        final Map<String, IDAndVersion> truth = new HashMap<>();
        ensureGreen();
            .actionGet();
        for (int i = 0; i < 10; i++) {
        assertThat(doc2.getVersion(), equalTo(1L));
    public void testSpecialVersioning() {
    // Poached from Lucene's TestIDVersionPostingsFormat:
import org.opensearch.action.search.SearchResponse;
        String idPrefix;
        }
        createIndex("test");
        Thread.sleep(300); // gc works based on estimated sampled time. Give it a chance...
                .execute(),
        String[] ids = idsSet.toArray(new String[numIDs]);
            client().prepareIndex("test").setId("1").setCreate(true).setSource("field1", "value1_1"),
        return ids;
            VersionConflictEngineException.class
        }
        assertThat(deleteResponse.getVersion(), equalTo(v));
                                        .setSource("foo", "bar")
            };
    public void testRequireUnitsOnUpdateSettings() throws Exception {
            VersionConflictEngineException.class
                // sequential
        public boolean versionConflict;
        ensureGreen();
                    sb.append(indexResponse.getIndex());
        }
        assertFutureThrows(
        assertThat(doc3.getVersion(), equalTo(3L));
            client().prepareDelete("test", "1").setIfSeqNo(1).setIfPrimaryTerm(1),
            .actionGet();
            .execute()
        createIndex("test");
                    sb.append(indexResponse.getResult() == DocWriteResponse.Result.CREATED);
                    sb.append(indexResponse.getId());
            .setCreate(true)
            logger.debug("--> use id prefix {}", idPrefix);
            .setVersionType(VersionType.EXTERNAL)
            .execute()
public class SimpleVersioningIT extends OpenSearchIntegTestCase {
            .setId("1")
        // Real-time get should still reflect delete:
        ensureGreen();
        IndexResponse indexResponse = bulkResponse.getItems()[0].getResponse();
        DeleteResponse deleteResponse = client().prepareDelete("test", "1")
            .execute()
            StringBuilder sb = new StringBuilder();
                break;
        DeleteResponse deleteResponse = client().prepareDelete("test", "1").setIfSeqNo(1).setIfPrimaryTerm(1).get();
        // the doc is deleted. Even when we hit the deleted seqNo, a conditional delete should fail.
        assertEquals(DocWriteResponse.Result.NOT_FOUND, deleteResponse.getResult());
            .actionGet();
        final Random random = random();
            case 4:
                .setId("1")
        for (int i = 0; i < 10; i++) {
            SearchResponse searchResponse = client().prepareSearch()
                            String id = idVersion.id;
            .setSource("foo", "bar")
        if (failed) {
        DeleteResponse deleteResponse = client().prepareDelete("test", "1")
        // deleting with a lower version fails.
            .setVersionType(VersionType.INTERNAL)
                        return Long.toString(random.nextLong() & 0x3ffffffffffffffL, radix);
            thread.join();
            logger.debug(
            idVersions[index] = idVersions[i];
            // Force refresh so the add is sometimes visible in the searcher:
            .setId("1")
                            if (idVersion.delete) {
            client().prepareDelete("test", "1").setVersion(2).setVersionType(VersionType.EXTERNAL).execute(),
            IDAndVersion curVersion = truth.get(idVersions[i].id);
                                try {
        assertFutureThrows(
            default:
                    } catch (Exception e) {
            .setVersion(4L)
        if (randomBoolean()) {
        // TODO: This behavior breaks rest api returning http status 201
 * You may obtain a copy of the License at
        // Note - external version doesn't throw version conflicts on deletes of non existent records.
            client().prepareDelete("test", "1").setIfSeqNo(1).setIfPrimaryTerm(2),
                logger.info("--> use sequential ids");
            .prepareCreate("test")
        indexResponse = client().prepareIndex("test")
