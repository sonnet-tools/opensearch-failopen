        assertEquals(40, intValue(nowInRows));
            .indices()
     * Creates the composite index (Lucene secondary for {@code _id} resolution) with auto-refresh
 *
     * Composite index that accepts custom document ids, so a document can be re-indexed and its
        // deliberately no refresh -- the document is still in the live version map
            .prepareCreate(INDEX)
package org.opensearch.composite;
        VersionConflictEngineException ex = expectThrows(
                Settings.builder()
        assertEquals(2L, unconditional.getVersion());
        createUpdatableManualRefreshIndex();
 * path (GET after refresh) under active indexing and interleaved refreshes.
    }
/*
     * Controls, so the enforcement above cannot be satisfied by rejecting everything: the current
    private static final String INDEX = "dfae_getbyid";
     * different version — so the condition was not merely unenforced, it was invisible.
    public void testGetWithStaleVersionAfterRefreshConflicts() {
            .setMapping("name", "type=keyword", "value", "type=integer")
    private IndexResponse indexDoc(String name, int value) {
import org.opensearch.action.index.IndexResponse;
    /**
        refreshIndex(INDEX);
     * <p>Exercised through the transport layer on purpose: the parsing above sits outside the
 * End-to-end get-by-id coverage for the hot {@link org.opensearch.index.engine.DataFormatAwareEngine}:
        // Unrefreshed id -> version-map path (realtime found), absent from rows (non-realtime not found).
    public void testGetWithUnsatisfiableExternalGteVersionAfterRefreshConflicts() {
    }
        );
        assertEquals(2L, indexDocWithId("v3", "second", 2).getVersion());
        assertTrue("realtime get must find the unrefreshed doc", realtime.isExists());
import org.opensearch.index.VersionType;
        createUpdatableManualRefreshIndex();
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        String docId = indexResponse.getId();
import org.opensearch.common.settings.Settings;
        assertTrue("after refresh id must be found via rows", nowInRows.isExists());
        assertEquals(2, intValue(resp));
        GetResponse realtime = client().prepareGet(INDEX, docId).setRealtime(true).get();
    private void createManualRefreshIndex() {
import org.opensearch.action.get.GetResponse;
    }
 */
    private void createUpdatableManualRefreshIndex() {
        List<String> ids = indexDocs(INDEX, 25, 1);
        // First batch then refresh -> these live in rows.
        assertEquals(RestStatus.CREATED, indexResponse.status());
        // After refresh the doc is materialized into parquet rows; non-realtime GET resolves via the row path.
        VersionConflictEngineException stale = expectThrows(
        GetResponse nonRealtime = client().prepareGet(INDEX, docId).setRealtime(false).get();
     */
    }
 * The OpenSearch Contributors require contributions made to
     * refreshed out of the live version map.
    /** The same precondition on an external version type must be enforced on the segment path. */
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(unconditional.isExists());
 * exercises both the in-memory version-map path (realtime GET before refresh) and the parquet row
        client().admin().indices().prepareUpdateSettings(INDEX).setSettings(Settings.builder().put("index.refresh_interval", -1)).get();
     * engine. The version-map branch checks it inline; the segment fall-through used to skip the
        GetResponse matched = client().prepareGet(INDEX, "v3").setVersion(2L).get();
                    .put("index.composite.primary_data_format", "parquet")
            () -> client().prepareGet(INDEX, "v4").setVersion(1L).setRealtime(true).get()
     * on either tier is distinguishable.
        assertTrue("unrefreshed id must be found realtime via version map", unrefreshedRealtime.isExists());
        GetResponse nowInRows = client().prepareGet(INDEX, ids.get(39)).setRealtime(false).get();
     * engine, so an engine-level test cannot cover it.
            () -> client().prepareGet(INDEX, "v1").setVersion(1L).get()
        assertEquals("doc_10", refreshed.getSourceAsMap().get("name"));
        assertTrue(matched.isExists());
     * The version-map tier already enforced this; kept as the before/after contrast so a regression
     */
        assertEquals(2, intValue(matched));
        createUpdatableManualRefreshIndex();
        refreshIndex(INDEX);
    }
            .get();
     *
        GetResponse unconditional = client().prepareGet(INDEX, "v3").get();
        // Refreshed id -> row path.
        assertTrue("post-refresh get must find the doc via rows", resp.isExists());
            VersionConflictEngineException.class,
        assertEquals(2L, indexDocWithId("v2", "second", 2).getVersion());
 * compatible open source license.
    /**
     * version is served after a refresh, and a GET carrying no version at all is untouched.
        assertEquals(2L, matched.getVersion());
        assertEquals(2L, indexDocWithId("v4", "second", 2).getVersion());
        assertEquals(1L, realtime.getVersion());
            VersionConflictEngineException.class,
        refreshIndex(INDEX);
import org.opensearch.index.engine.VersionConflictEngineException;
        refreshIndex(INDEX);
        assertEquals("doc_1", realtime.getSourceAsMap().get("name"));
        createUpdatableManualRefreshIndex();
    }
 * SPDX-License-Identifier: Apache-2.0
        // Second batch, NOT refreshed -> these live only in the version map.
 */
        GetResponse resp = client().prepareGet(INDEX, docId).setRealtime(false).get();
            () -> client().prepareGet(INDEX, "v1").setVersion(99L).get()
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        createManualRefreshIndex();
            )
    /** Indexes under an explicit id so successive calls advance {@code _version}. */
    }
        assertFalse("unrefreshed id must be absent from rows", client().prepareGet(INDEX, "40").setRealtime(false).get().isExists());
     * on, which rejects custom ids outright.
    private IndexResponse indexDocWithId(String id, String name, int value) {
        IndexResponse indexResponse = indexDoc("doc_2", 2);
        assertTrue("expected a version conflict, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
        assertEquals(10, intValue(refreshed));
                    .put("index.pluggable.dataformat.enabled", true)
        assertEquals(1, intValue(realtime));
    }
                    .putList("index.composite.secondary_data_formats", "lucene")
        return ((Number) r.getSourceAsMap().get("value")).intValue();
     */
        VersionConflictEngineException ex = expectThrows(
    private static int intValue(GetResponse r) {
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
import java.util.List;
/**
     *
import org.opensearch.test.OpenSearchIntegTestCase;
        refreshIndex(INDEX);
        ids.addAll(indexDocs(INDEX, 25, 26));
                    .put("index.pluggable.dataformat", "composite")
        assertEquals("doc_2", resp.getSourceAsMap().get("name"));
        assertEquals(1L, indexDocWithId("v1", "first", 1).getVersion());
        assertEquals(2, intValue(unconditional));
     * {@code ShardGetService} threads them into {@code Engine.Get}, so the precondition reaches the
    /**
            VersionConflictEngineException.class,
        );
        assertEquals(1L, resp.getVersion());
        String docId = indexResponse.getId();
        ensureGreen(INDEX);
     * check and return the <em>current</em> document with a 200 for a request that named a
        client().admin()
        createManualRefreshIndex();
    }
     * disabled so the version-map vs row paths stay deterministic across the refresh boundary.
     * {@code _version} advanced. {@code createCompositeIndex} leaves {@code append_only.enabled}
        assertEquals(1L, indexDocWithId("v4", "first", 1).getVersion());
    public void testGetHitsRowsAfterRefresh() {
     */
     * <p>{@code RestGetAction} parses {@code version} and {@code version_type} and
        assertTrue("expected a version conflict, got: " + future.getMessage(), future.getMessage().contains("version conflict"));
    public void testGetWithCurrentVersionAfterRefreshSucceeds() {
    }
        // Realtime GET resolves from the in-memory version map (translog-backed) before any refresh.
        assertTrue("refreshed id must be found via rows", refreshed.isExists());
        assertEquals(2L, indexDocWithId("v1", "second", 2).getVersion());
            .setSettings(
        return client().prepareIndex().setIndex(INDEX).setId(id).setSource("name", name, "value", value).get();
    /**
        assertTrue("expected a version conflict, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
            VersionConflictEngineException.class,
     */
    public void testGetWithStaleVersionBeforeRefreshConflicts() {
        createCompositeIndex(INDEX); // withLuceneSecondary = true
    public void testRealtimeGetHitsVersionMapBeforeRefresh() {
        IndexResponse indexResponse = indexDoc("doc_1", 1);
        assertFalse("non-realtime get must not see the unrefreshed doc", nonRealtime.isExists());
        assertEquals("doc_40", unrefreshedRealtime.getSourceAsMap().get("name"));
        return client().prepareIndex().setIndex(INDEX).setSource("name", name, "value", value).get();
        GetResponse refreshed = client().prepareGet(INDEX, ids.get(9)).setRealtime(false).get();
     * A GET naming an explicit {@code version} must be rejected once the document has been
    /**
                    .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)
import org.opensearch.core.rest.RestStatus;
        assertEquals(RestStatus.CREATED, indexResponse.status());
    }
        // After a second refresh the previously-unrefreshed id resolves via rows too.
        );
        createManualRefreshIndex();
public class DataFormatAwareGetByIdIT extends AbstractCompositeEngineIT {
        GetResponse unrefreshedRealtime = client().prepareGet(INDEX, ids.get(39)).setRealtime(true).get();
}
        refreshIndex(INDEX);
import org.opensearch.cluster.metadata.IndexMetadata;
        // Non-realtime GET only sees refreshed (row) data -> not found yet, proving rows are still empty.
            () -> client().prepareGet(INDEX, "v2").setVersion(1L).setVersionType(VersionType.EXTERNAL_GTE).get()
        assertEquals(1L, indexDocWithId("v2", "first", 1).getVersion());
        );
        // A version ahead of the stored one must conflict too, not be silently served.
        assertEquals(1L, indexDocWithId("v3", "first", 1).getVersion());
        VersionConflictEngineException future = expectThrows(
    }
        assertTrue("expected a version conflict, got: " + stale.getMessage(), stale.getMessage().contains("version conflict"));
                    .put("index.refresh_interval", -1)
    public void testActiveIndexingWithInterleavedRefreshes() {
