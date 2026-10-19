        assertTrue("unrefreshed id must be found realtime via version map", unrefreshedRealtime.isExists());  
        VersionConflictEngineException ex = expectThrows(
        return client().prepareIndex().setIndex(INDEX).setSource("name", name, "value", value).get();
        GetResponse unrefreshedRealtime = client().prepareGet(INDEX, ids.get(39)).setRealtime(true).get();
    }  
        // After a second refresh the previously-unrefreshed id resolves via rows too.
        createUpdatableManualRefreshIndex();  
                    .put(IndexMetadata.INDEX_APPEND_ONLY_ENABLED_SETTING.getKey(), false)
    /**
        assertEquals(1, intValue(realtime));
        assertEquals(1L, resp.getVersion());  
        refreshIndex(INDEX);  
     */
     * disabled so the version-map vs row paths stay deterministic across the refresh boundary.  
     * Composite index that accepts custom document ids, so a document can be re-indexed and its
        GetResponse realtime = client().prepareGet(INDEX, docId).setRealtime(true).get();
        assertEquals(2L, matched.getVersion());
        assertEquals(1L, realtime.getVersion());  
                    .putList("index.composite.secondary_data_formats", "lucene")
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
        createUpdatableManualRefreshIndex();
package org.opensearch.composite;
        assertTrue("refreshed id must be found via rows", refreshed.isExists());  
    }  
                    .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    /**
        assertEquals(1L, indexDocWithId("v4", "first", 1).getVersion());  
        createUpdatableManualRefreshIndex();  
        // Realtime GET resolves from the in-memory version map (translog-backed) before any refresh.  
     * {@code ShardGetService} threads them into {@code Engine.Get}, so the precondition reaches the
        assertTrue("realtime get must find the unrefreshed doc", realtime.isExists());
        createUpdatableManualRefreshIndex();
    }
        VersionConflictEngineException stale = expectThrows(
        refreshIndex(INDEX);
    /**
        assertEquals(1L, indexDocWithId("v2", "first", 1).getVersion());
        assertEquals("doc_2", resp.getSourceAsMap().get("name"));
        createManualRefreshIndex();  
     * refreshed out of the live version map.
     * engine. The version-map branch checks it inline; the segment fall-through used to skip the  
        assertEquals(RestStatus.CREATED, indexResponse.status());
        createManualRefreshIndex();  
    }  
     * <p>Exercised through the transport layer on purpose: the parsing above sits outside the
        ensureGreen(INDEX);
        GetResponse refreshed = client().prepareGet(INDEX, ids.get(9)).setRealtime(false).get();
        );  
        assertTrue("expected a version conflict, got: " + future.getMessage(), future.getMessage().contains("version conflict"));
        assertTrue(matched.isExists());
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
        assertTrue("expected a version conflict, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
        assertEquals(2L, indexDocWithId("v1", "second", 2).getVersion());
        assertEquals(2L, indexDocWithId("v3", "second", 2).getVersion());  
    /**  
        // After refresh the doc is materialized into parquet rows; non-realtime GET resolves via the row path.  
            .indices()
                Settings.builder()
    }  
            .get();  
                    .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)  
    /** Indexes under an explicit id so successive calls advance {@code _version}. */
        assertEquals("doc_10", refreshed.getSourceAsMap().get("name"));
     * Creates the composite index (Lucene secondary for {@code _id} resolution) with auto-refresh
            () -> client().prepareGet(INDEX, "v2").setVersion(1L).setVersionType(VersionType.EXTERNAL_GTE).get()
    private IndexResponse indexDocWithId(String id, String name, int value) {
import java.util.List;
     */
     */
        GetResponse unconditional = client().prepareGet(INDEX, "v3").get();
    }
        VersionConflictEngineException future = expectThrows(  
 *
    public void testGetWithStaleVersionAfterRefreshConflicts() {
                    .put("index.pluggable.dataformat", "composite")
            () -> client().prepareGet(INDEX, "v1").setVersion(1L).get()
        String docId = indexResponse.getId();
        return ((Number) r.getSourceAsMap().get("value")).intValue();  
    }
import org.opensearch.common.settings.Settings;
        client().admin()  
            .prepareCreate(INDEX)
        GetResponse nonRealtime = client().prepareGet(INDEX, docId).setRealtime(false).get();  
/**  
        IndexResponse indexResponse = indexDoc("doc_1", 1);
 * compatible open source license.
        assertFalse("non-realtime get must not see the unrefreshed doc", nonRealtime.isExists());
                    .put("index.composite.primary_data_format", "parquet")  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(10, intValue(refreshed));
import org.opensearch.test.OpenSearchIntegTestCase;
        assertEquals("doc_1", realtime.getSourceAsMap().get("name"));
    public void testGetWithStaleVersionBeforeRefreshConflicts() {  
        assertEquals(2L, indexDocWithId("v2", "second", 2).getVersion());  
 * End-to-end get-by-id coverage for the hot {@link org.opensearch.index.engine.DataFormatAwareEngine}:
 * path (GET after refresh) under active indexing and interleaved refreshes.  
            .setMapping("name", "type=keyword", "value", "type=integer")
        assertEquals(2L, unconditional.getVersion());
     * on either tier is distinguishable.
}
        createCompositeIndex(INDEX); // withLuceneSecondary = true  
     *  
    }
        refreshIndex(INDEX);
import org.opensearch.core.rest.RestStatus;
    private static final String INDEX = "dfae_getbyid";
        assertTrue("after refresh id must be found via rows", nowInRows.isExists());
        // Refreshed id -> row path.
        assertEquals(2L, indexDocWithId("v4", "second", 2).getVersion());
        GetResponse resp = client().prepareGet(INDEX, docId).setRealtime(false).get();
    private void createManualRefreshIndex() {
public class DataFormatAwareGetByIdIT extends AbstractCompositeEngineIT {  
import org.opensearch.action.index.IndexResponse;
        IndexResponse indexResponse = indexDoc("doc_2", 2);
    public void testGetHitsRowsAfterRefresh() {
    public void testRealtimeGetHitsVersionMapBeforeRefresh() {
     * engine, so an engine-level test cannot cover it.
        refreshIndex(INDEX);  
            )
     * {@code _version} advanced. {@code createCompositeIndex} leaves {@code append_only.enabled}
import org.opensearch.index.VersionType;  
     * on, which rejects custom ids outright.  
 * SPDX-License-Identifier: Apache-2.0
        refreshIndex(INDEX);
        assertTrue("expected a version conflict, got: " + stale.getMessage(), stale.getMessage().contains("version conflict"));  
     * version is served after a refresh, and a GET carrying no version at all is untouched.  
     *  
     * Controls, so the enforcement above cannot be satisfied by rejecting everything: the current
    /** The same precondition on an external version type must be enforced on the segment path. */
     * A GET naming an explicit {@code version} must be rejected once the document has been
        assertEquals(RestStatus.CREATED, indexResponse.status());
        assertEquals("doc_40", unrefreshedRealtime.getSourceAsMap().get("name"));
    }  
        // deliberately no refresh -- the document is still in the live version map
    }  
        client().admin().indices().prepareUpdateSettings(INDEX).setSettings(Settings.builder().put("index.refresh_interval", -1)).get();
            VersionConflictEngineException.class,
        return client().prepareIndex().setIndex(INDEX).setId(id).setSource("name", name, "value", value).get();  
import org.opensearch.action.get.GetResponse;
        // First batch then refresh -> these live in rows.
        assertFalse("unrefreshed id must be absent from rows", client().prepareGet(INDEX, "40").setRealtime(false).get().isExists());
                    .put("index.refresh_interval", -1)  
        assertEquals(2, intValue(resp));
        // Non-realtime GET only sees refreshed (row) data -> not found yet, proving rows are still empty.
     * <p>{@code RestGetAction} parses {@code version} and {@code version_type} and
        assertEquals(1L, indexDocWithId("v3", "first", 1).getVersion());
        List<String> ids = indexDocs(INDEX, 25, 1);
        GetResponse matched = client().prepareGet(INDEX, "v3").setVersion(2L).get();  
    private void createUpdatableManualRefreshIndex() {
 */  
 * The OpenSearch Contributors require contributions made to  
        VersionConflictEngineException ex = expectThrows(  
    public void testGetWithCurrentVersionAfterRefreshSucceeds() {
     * different version — so the condition was not merely unenforced, it was invisible.
            VersionConflictEngineException.class,
        // Unrefreshed id -> version-map path (realtime found), absent from rows (non-realtime not found).
                    .put("index.pluggable.dataformat.enabled", true)
        assertEquals(2, intValue(matched));  
            .setSettings(  
        // A version ahead of the stored one must conflict too, not be silently served.
 */
        assertTrue("expected a version conflict, got: " + ex.getMessage(), ex.getMessage().contains("version conflict"));
        refreshIndex(INDEX);  
        assertEquals(1L, indexDocWithId("v1", "first", 1).getVersion());
        assertEquals(40, intValue(nowInRows));
/*  
        String docId = indexResponse.getId();  
    private static int intValue(GetResponse r) {
    public void testActiveIndexingWithInterleavedRefreshes() {
        );  
            VersionConflictEngineException.class,  
        assertEquals(2, intValue(unconditional));
            VersionConflictEngineException.class,
        GetResponse nowInRows = client().prepareGet(INDEX, ids.get(39)).setRealtime(false).get();  
     */  
     */
    /**  
        createManualRefreshIndex();  
        // Second batch, NOT refreshed -> these live only in the version map.
    public void testGetWithUnsatisfiableExternalGteVersionAfterRefreshConflicts() {
    }
import org.opensearch.index.engine.VersionConflictEngineException;
    private IndexResponse indexDoc(String name, int value) {
        );
     * check and return the <em>current</em> document with a 200 for a request that named a
        ids.addAll(indexDocs(INDEX, 25, 26));
 * exercises both the in-memory version-map path (realtime GET before refresh) and the parquet row
     * The version-map tier already enforced this; kept as the before/after contrast so a regression  
        assertTrue(unconditional.isExists());  
            () -> client().prepareGet(INDEX, "v1").setVersion(99L).get()
        );
        assertTrue("post-refresh get must find the doc via rows", resp.isExists());
            () -> client().prepareGet(INDEX, "v4").setVersion(1L).setRealtime(true).get()  
