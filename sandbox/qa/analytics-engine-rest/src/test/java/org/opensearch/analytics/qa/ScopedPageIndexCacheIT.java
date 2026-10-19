        assertEquals("merge-test bulk1 errors", false, rb1.get("errors"));
     * delegation block-list (EQUALS is NOT blocked), {@code city = 'seattle'} on a keyword field is
     * group-by/projection list must still scan that column correctly.  
            // Total CI entries = 2 (one per index, different file paths).
     */
        assertPositive("P1 warm: CI hits", ciHits(stats()));
                s1.get("column_index_cache").get("size_limit_bytes").asLong() <= 8L);  
    }
     * the cache-limit consumer, so the large default scoped limits are live again on return.  
            + "}}";
        // ── Phase 4: DISABLED, listing path ───────────────────────────────
    // ── reusable assertion helpers ────────────────────────────────────────────
        assertZero("assertCacheEmpty: CI entries", ciEntries(s));  
        assertTrue("must have hits before clear", hitsBefore > 0);
        assertTrue(  
     * <p>This exercises the FIFO write lock under real concurrent key diversity.
     * page-index load (which would defeat the point of delegation and waste cache budget).  
        // Warm query — same query hits from both CI and OI caches.
     * Schema-drift scenario: a new field ({@code region}) is added in a second batch after the  
     * String keyword field predicate: {@code city = 'seattle'} hits the ColumnIndex because
        executePpl(ppl);  
        JsonNode cold = stats();
     * Set the total metadata-index cache budget to a handful of bytes so every entry is
            assertTrue(  
            executePpl(indexed);  
        clearAllCaches();
            + "\"settings\":{"
            assertEquals("CI memory_bytes must be 0", 0L,  
     */
        for (int i = 0; i < predicates.length; i++) {
            }
        String ppl = "source=" + INDEX_NAME + " | where age > 90 | stats count()";  
            + "},"
            if (cacheStats == null) {
                .append(",\"city\":\"").append(cities[i % cities.length])  
        assertZero("P3 disable: CI entries auto-cleared", ciEntries(p3));
            assertTrue("CI size_limit_bytes must be tiny (<= 8) under 8b budget",
        executePpl(indexedPpl);  
        assertPositive("warm CI hits for: " + ppl, ciHits(warm));
            String proj = "source=" + INDEX_NAME + " | fields name, score | head 10";  
        assertCacheEmpty();
        // page index via a different code path than the listing optimizer. Same hazard: the case()
                .append("{\"name\":\"user").append(i)
                executePpl(pplA2);
    @SuppressWarnings("unused")
        Request req = new Request("PUT", "/_cluster/settings");
        assertZero("P4 CI hits", ciHits(p4));
        clearAllCaches();
        JsonNode s1 = stats();
     * Run {@code ppl} a second time (cache already warm) and assert that both CI and OI hit.
     * initialized when setUp() runs (see existing IT comments in this package).
        JsonNode nodes = root.get("nodes");
            Request bulkReq = new Request("POST", "/" + INDEX_NAME + "/_bulk");
        assertPositive("P4 disabled listing: metadata populated", metaDisabledListing);
                "CI used_bytes=" + usedBytes + " must be <= size_limit_bytes=" + limit,
            String indexed = "source=" + INDEX_NAME + " | where match(city, 'seattle') and age > 50 | stats count()";
     *
        assertZero("P4 OI hits", oiHits(p4));
        executePpl(ppl);
        assertZero("delegated EQUALS: CI hits must be 0", ciHits(s));
            assertEquals("CI hits must remain 0 — nothing fits in 1b cache", 0L, ciHits(s2));
        // OI: 1 file × {col_0(name), score(col 2)} = 2 entries
        executePpl(listingPpl);  
public class ScopedPageIndexCacheIT extends AnalyticsRestTestCase {
        clearAllCaches();
        recreateIndex();
            clearAllCaches();  
    /**
        assertPositive("cold CI misses for: " + ppl, ciMisses(cold));
        assertPositive("P6 re-enabled: CI misses (scoped cache back)", ciMisses(p6));
        recreateIndex();
    /**  
        );
        assertEquals(msg, expected, oiEntries(stats()));  
                0L, ciEntries(s1));
                .append("\"}\n");
            assertTrue("OI size_limit_bytes must be tiny (<= 8) under 8b budget",
            + "  \"index.pluggable.dataformat\":\"composite\","
     * </pre>  
    private void setScopedPageIndexEnabled(boolean enabled) throws IOException {  
            "P4 disabled listing metadata >= enabled (page index retained): enabled="
        assertCacheEmpty();  
            + "},"
                com.fasterxml.jackson.databind.node.ObjectNode aggGroup = aggregate.has(group)
        executePpl(listingPpl);  
            + "  \"age\":{\"type\":\"integer\"},"
        assertExactCiEntries("numeric predicate: CI entries = 1 (file×col×rg)", 1L);  
        assertPositive("assertOnlyOiFills: OI misses > 0 for: " + ppl, oiMisses(s));
    private long ciHits(JsonNode s)          { return s.get("column_index_cache").get("hit_count").asLong(); }
            + "  \"number_of_shards\":1,\"number_of_replicas\":0,"
    }
            + "  \"index.composite.secondary_data_formats\":\"lucene\""  
     *   <li>The first batch's field ({@code age}) can still be queried correctly after the schema  
        Request bulk2 = new Request("POST", "/" + INDEX_NAME + "/_bulk");
                }  
        assertEquals("OI entries 0 after auto-clear on disable", 0L, oiEntries(stats()));
        try {
        JsonNode s = stats();
     * Run {@code ppl} and assert that ONLY the OffsetIndex fills: OI misses > 0 and CI misses == 0.
        // Batch 1: fields name, age, city — creates segment 1.
        // Provision a second index with the same schema.
            + "\"settings\":{"
            clearAllCaches();
        Request create = new Request("PUT", "/" + DYNAMIC_INDEX_NAME);
            + "  \"index.composite.secondary_data_formats\":\"lucene\""  
    }  
     * Asserts: OI misses > 0, CI misses == 0.  
        executePpl(listingPpl);
 * <ul>
        assertEquals("CI entries 0 after auto-clear on disable", 0L, ciEntries(stats()));
    private void clearAllCaches() throws IOException {  
        client().performRequest(req);  
        assertZero("P5 CI misses", ciMisses(p5));
    private void assertCacheFillsOnCold(String ppl) throws Exception {
     *
     * (column projection). Both CI and OI should accumulate misses on the cold run.  
        }
        // Be explicit that EQUALS is delegated to Lucene (this is also the cluster default).  
        client().performRequest(new Request("POST", CLEAR_ENDPOINT + "?column=true"));
            JsonNode warm = stats();
        bulk2.addParameter("refresh", "true");  
        health.addParameter("wait_for_status", "green");
        assertCacheEmpty();  
    private void assertScopedDisabled(String ppl) throws Exception {
        // Indexed path: match() routes through the Lucene-indexed executor, which wires the scoped
        assertZero("pure Lucene count: CI misses must be 0", ciMisses(s));  
     * <p>Flow per mode: delete → create → index → refresh → clearAllCaches() →
            try { client().performRequest(new Request("DELETE", "/" + INDEX_B)); } catch (Exception ignored) {}  
            bulkReq.setJsonEntity(bulk.toString());  
     * <p>Flow:
            assertEquals("OI hits must remain 0 — nothing fits in 1b cache", 0L, oiHits(s2));  
    protected boolean preserveClusterUponCompletion() {
        assertPositive("dynamic: metadata populated after region query", metaMemoryBytes(afterRegion));
        assertZero("assertOnlyOiFills: CI misses must be 0 for: " + ppl, ciMisses(s));  
    /** Set the total metadata-index cache budget (e.g. {@code "100b"}, {@code "500mb"}). */
    }  
            String pplA2 = "source=" + INDEX_NAME + " | where score > 75.0 | stats count()";
        }  
    private void assertOnlyOiFills(String ppl) throws Exception {
        int batchSize = 500;
        Request req = new Request("PUT", "/_cluster/settings");  
     * is present.  
        assertPositive("P2 warm indexed: CI or OI hits", p2warmHits);  
     * clearing must re-miss against the merged segment.
        assertEquals("CI hits 0 on indexed path disabled", 0L, ciHits(s2));
        assertPositive("dynamic: CI fills for new field region", ciMisses(afterRegion));
    // ── listing table path ────────────────────────────────────────────────────
        assertEquals("refresh must NOT fill CI cache", 0L, ciEntries(afterRefresh));  
        }
        assertEquals("refresh must NOT fill metadata cache", 0L, metaMemoryBytes(afterRefresh));
    }
        executePpl(ppl);
        // OI key = (file, col); the column set is {col 0} ∪ predicate ∪ projection. The
                ciAfterBoth >= 2);
     * Indexed path disabled: CI/OI = 0, metadata cache larger than enabled baseline.
     *  
        assertEquals("refresh must NOT fill metadata cache", 0L, metaMemoryBytes(afterRefresh));
        assertZero("P5 CI hits", ciHits(p5));  
        com.fasterxml.jackson.databind.node.ObjectNode aggregate = MAPPER.createObjectNode();
            "indexed disabled metadata >= enabled (page index retained): enabled="
     */
                .append("\",\"age\":").append(i % 100)  
            restoreCacheDefaults();
    public void testPureLuceneCountQueryProducesNoCacheActivity() throws Exception {
        create.setJsonEntity(body);  
    // ── refresh → merge lifecycle ─────────────────────────────────────────────  
        String[] cities = {"seattle", "portland", "denver", "austin", "boston"};  
     *   recreate → clear → assertCacheEmpty
            JsonNode s = stats();
        assertZero("P4 OI misses", oiMisses(p4));
        client().performRequest(req);  
            + " | stats count() as total, sum(case(age > 50, 1 else 0)) as old,"  
     * Phase 6 — RE-ENABLE  
import org.opensearch.client.Request;
                .append(",\"city\":\"").append(cities[i % cities.length])  
        }
        // budget), so it is taken as the MAX rather than summed — otherwise an N-node cluster  
                executePpl(pplB1);  
    }  
     * Delegated keyword-equality predicate produces NO scoped cache activity.
     * force-merge to one segment the pre-merge cache entries are stale; a fresh query after
     *  
        assertEquals("CI misses 0 on indexed path disabled", 0L, ciMisses(s2));  
     * Per-test setup via {@link AnalyticsRestTestCase#onBeforeQuery()} — this fires
        executePpl(listing);
        // CI: 2 files × age(col 1) × 1 RG each = 2 entries
        executePpl(indexed);
        } catch (Exception e) {  
            String pplB1 = "source=" + INDEX_B + " | where age > 60 | stats count()";  
    // ── index lifecycle helpers ───────────────────────────────────────────────  
                int id = batch * batchSize + i;  
        assertPositive("cold OI misses for: " + ppl, oiMisses(cold));  
        assertExactOiEntries("pre-merge: OI entries = 4 (2 files × {col_0,age})", 4L);
        JsonNode s1 = stats();  
        assertTrue("indexed warm: OI hits > 0", oiHits(warm) > 0);
        String agePpl = "source=" + DYNAMIC_INDEX_NAME + " | where age > 50 | stats count()";
     * <p>To make the measurements deterministic we query the cluster-wide stats endpoint
        long metaDisabled = metaMemoryBytes(s2);
        // OI: 2 files × {col_0(name), age(col 1)} = 4 entries  
    }
        recreateIndex();
        JsonNode s2 = stats();  
                    .append("\"}\n");  
        try {
        String body = "{"  
 *   <li>OI fills on projection-only queries; CI does NOT fill when there is no predicate.</li>
        // miss_count, entry_count, memory_bytes) accumulate across the cluster, so they are
     * OffsetIndex to locate the page offsets for the projected columns, but there is no predicate
            executePpl(pplA2);
     * Phase 5 — DISABLED, indexed path
     * scans the parquet file — meaning it never loads the parquet ColumnIndex. Blocking the
            + "  \"name\":{\"type\":\"keyword\"},"  
        assertEquals("CI hits reset to 0 after clear", 0L, ciHits(stats()));
    /**  
    public void testQueriesCorrectWithTinyCacheLimits() throws Exception {  
                    JsonNode value = groupNode.get(field);
        assertEquals("merge-test bulk2 errors", false, rb2.get("errors"));
        JsonNode cold = stats();
     * default, so a predicate like {@code city = 'seattle'} is answered by Lucene and never  
        // ── ENABLED baseline ──────────────────────────────────────────────  
 * <p>The cache is governed by the {@code datafusion.scoped_page_index.enabled} cluster setting.
    // ── indexed path (match() → Lucene + DataFusion) ──────────────────────────
        try {  
                JsonNode groupNode = cacheStats.get(group);  
    }
 *
            b1.append("{\"index\":{}}\n")
        // both metadata memory and CI entries must be 0 — refresh did not fill the cache.  
        String[] cities = {"seattle", "portland", "denver", "austin", "boston"};
        Request create = new Request("PUT", "/" + INDEX_NAME);  
    }  
            + "  \"index.pluggable.dataformat.enabled\":true,"  
        // run the cache-limit consumer, so the scoped limits are already live when this returns.  
     * neither the ColumnIndex nor the OffsetIndex scoped cache should record any hit, miss, or entry.  
     * predicate (e.g. {@code EQUALS}) forces the planner to leave it on the DataFusion/parquet
    /**  
        bulk1.setOptions(bulk1.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());  
     *   match() query → metadata larger than enabled, CI = 0, OI = 0
    /**
        }
        assertCacheFillsOnCold(ppl);
        String ppl = "source=" + INDEX_NAME + " | where score > 75.0 | stats count()";  
     * assertCacheEmpty() → query → measure.  
        executePpl(ppl);  
        clearAllCaches();
            batch2.append("{\"index\":{}}\n")  
        // ── Phase 2: ENABLED, indexed path ────────────────────────────────  
        executePpl(ppl);
     *   <li>The new field ({@code region}) fills the CI from the segment that carries it, even
     *  
            clearAllCaches();  
     *   assert CI entries = 0, OI entries = 0 immediately  
        }
        // CI: 1 merged file × age(col 1) × 1 RG = 1 entry (down from 2)  
    }
        long hitsBefore = ciHits(stats());  
                .append("{\"name\":\"user").append(i)
        // Batch 2 → refresh → segment 2.
     *   <li>Both indices must still return correct query results (cache is optional).</li>  
        arr.append(']');
            JsonNode s1 = stats();
        try { client().performRequest(new Request("DELETE", "/" + DYNAMIC_INDEX_NAME)); } catch (Exception ignored) {}  
        assertExactCiEntries("pre-merge: CI entries = 2 (2 files × age × rg)", 2L);
                s1.get("offset_index_cache").get("memory_bytes").asLong());  
        assertExactCiEntries("string predicate: CI entries = 1 (file×col×rg)", 1L);
        bulk2.setOptions(bulk2.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
     * </ul>
            clearAllCaches();  
            + "\"mappings\":{\"properties\":{"
    public void testRefreshThenMergeCacheRefillsAfterMerge() throws Exception {
     */  
     *   recreate → clear → assertCacheEmpty (refresh did NOT fill)  
 * compatible open source license.
        JsonNode p4 = stats();  
        assertCacheEmpty();  
        // city is a keyword field; equality would normally be delegated to Lucene and never
        assertTrue("indexed cold: OI misses > 0 (predicate col + col 0)", oiMisses(cold) > 0);
        assertCacheEmpty();
        assertZero("delegated EQUALS: OI entries must be 0", oiEntries(s));
            executePpl(pplB2);
     *   query → assert metadata populated AND larger than enabled baseline
        bulk1.setJsonEntity(batch1.toString());
            + "  \"number_of_shards\":1,\"number_of_replicas\":0,"
     * "provided output is too small for the decompressed data" (HTTP 500).
 * <p>Every test that needs clean measurements calls {@code recreateIndex()} (or a named variant),  
     * first segment already exists. Verifies that:
        assertPositive("warm OI hits for: " + ppl, oiHits(warm));  
    public void testDelegatedStringPredicateProducesNoOffsetIndexActivity() throws Exception {
    }
     *   <li>Batch 1 → refresh (segment 1)</li>  
     * schema is defined — the mapping is inferred from each batch.  
        clearAllCaches();
        setScopedPageIndexEnabled(false);  
    /**
                        long combined = "size_limit_bytes".equals(field)
        long metaDisabledListing = metaMemoryBytes(p4);
                        long prev = aggGroup.path(field).asLong(0L);
            arr.append('"').append(predicates[i]).append('"');  
            + "\"mappings\":{\"properties\":{"  
        executePpl(ppl);  
            metaDisabledIndexed >= metaEnabledListing
        assertZero("disabled CI hits run2: " + ppl, ciHits(s2));
        clearAllCaches();  
            // (Index B has different file path prefix so its entries survive.)
            + "},"
     * Each query groups by one column while a {@code case()} reads a different, non-projected one;
        for (String group : new String[]{"column_index_cache", "offset_index_cache"}) {
    /**
            boolean lastBatch = batch == (DOC_COUNT / batchSize - 1);  
        Map<String, Object> r2 = assertOkAndParse(client().performRequest(bulk2), "dynamic bulk2");
     */
 *       PageIndexPolicy::Optional.</li>
     * optimisation, not a correctness dependency. The parquet reader falls back to  
    /**
     * and {@code clearAllCaches()} broadcasts to every node so cleared sums are zero everywhere.
    /**
 * that any warming triggered by the refresh inside {@code recreateIndex()} is wiped out.
            // Pure Lucene count — must still work (does not touch CI/OI at all).  
    private void restoreCacheDefaults() throws IOException {
        assertPositive("pre-merge: CI misses across both segments", ciMisses(premerge));
        assertTrue("re-run after clear produces misses", ciMisses(stats()) > 0);
            throw new IOException("ScopedPageIndexCacheIT setup failed", e);
    private void setCacheTotalSize(String size) throws IOException {  
        String createBody = "{"  
                    client().performRequest(new Request("POST", "/" + INDEX_B + "/_refresh"));  
            assertTrue("cross-index: CI entries must be >= 2 after cold queries on both indices",
    /**
        executePpl(ppl);
        JsonNode root = MAPPER.readTree(EntityUtils.toString(response.getEntity()));
    public void testFullLifecycleEnabledDisabledReenabled() throws Exception {
     *  
        client().performRequest(fm);  
                + metaEnabledListing + " disabled=" + metaDisabledIndexed,  
            + "  \"city\":{\"type\":\"keyword\"}"
import org.apache.hc.core5.http.io.entity.EntityUtils;
     * OI key = (file, col) so expectedOi = files × projectionCols.
        assertZero("pure Lucene count: OI misses must be 0", oiMisses(s));
            long bHitsBefore = ciHits(stats());  
        // The predicate went to Lucene; parquet pages were never read.
        // 8b → CI limit 1b, OI limit 2b: tiny but non-zero, so every entry is larger and rejected.
        JsonNode warm = stats();  
     */
            assertPositive("OI misses must be > 0 with 1b limit", oiMisses(s1));  
        String[] cities = {"seattle", "portland", "denver", "austin", "boston"};  
            }
     * Delete, recreate, and bulk-index {@value #DOC_COUNT} documents with refresh=true.  
        // Start with a clean index that has NO data yet — we will drive two separate  
        Request health = new Request("GET", "/_cluster/health/" + DYNAMIC_INDEX_NAME);  
        // Query on new field region — only segment 2 carries it; CI must fill from that segment.  
    }  
        assertEquals(msg, expected, ciEntries(stats()));
        // OI: 1 file × {col_0(name), age(col 1)} = 2 entries (predicate ∪ projection ∪ {col_0})
            assertEquals("CI entry_count must be 0 (entries too large for 1b limit)",
        // aggregations read `age`/`score`, which are not in the group-by/projection list.  
        JsonNode afterRegion = stats();  
                .append(",\"score\":").append(50.0 + (i % 50))
     * Run {@code ppl} twice with scoped disabled (CI/OI = 0 each time).
     * <ul>  
    }
                bulk.append("{\"index\":{}}\n")
        assertPositive("post-merge: CI misses > 0 (forced re-miss after merge)", ciMisses(postmerge));  
        Response response = client().performRequest(
     *
            // Re-run all queries — they must not error even if the cache is empty.  
     * parquet segment with one row group (2000 rows well under the default 1M-row row-group limit), so:
        assertPositive("P5 disabled indexed: metadata populated", metaDisabledIndexed);  
        setScopedPageIndexEnabled(true);  
     *   <li>Force-merge to 1 segment</li>  
    private void assertCacheEmpty() throws Exception {  
        assertEquals("CI hits 0 with scoped disabled", 0L, ciHits(s2));
        clearAllCaches();
     *
        assertExactOiEntries("projection-only: OI entries = 3 (file×{col 0,name,score})", 3L);  
            new Request("GET", "/_plugins/_analytics_backend_datafusion/stats")
            // All accesses are misses since nothing is ever cached.
        long metaEnabledListing = metaMemoryBytes(p1cold);  
        client().performRequest(req);
    private long metaMemoryBytes(JsonNode s) { return s.get("metadata_cache").get("memory_bytes").asLong(); }
     *   <li>clearAllCaches → assertCacheEmpty (old entries gone)</li>
            }
                .append("\"}\n");
     *   <li>N projection cols → OI entries = N</li>
        String ppl = "source=" + INDEX_NAME + " | where age > 80 | fields age | stats count()";  
                + metaMemoryBytes(p6) + " disabled=" + metaDisabledListing,
            for (String field : new String[]{"hit_count", "miss_count", "entry_count", "memory_bytes", "size_limit_bytes", "hit_rate"}) {
        // ── Phase 3: DISABLE ──────────────────────────────────────────────
        // SUMMED. size_limit_bytes is a per-node capacity (every node configures the same
    public void testCacheContetionTwoIndicesOneTightBudget() throws Exception {
        // Clean up any leftovers from a prior run.
        assertPositive("CI+OI overlap: metadata populated", metaMemoryBytes(cold));
     *   <li>Listing path — numeric predicate keeps the scan on the listing/parquet path.</li>  
            + "  \"index.composite.primary_data_format\":\"parquet\","
     *   match() query again → hits increase  
                    }  
        executePpl(listingPpl);
        String[] regions = {"west", "east", "central"};
            + "  \"number_of_shards\":1,\"number_of_replicas\":0,"  
                            ? Math.max(prev, value.asLong())  
        assertTrue(
        // ── Phase 6: RE-ENABLE ────────────────────────────────────────────
        clearAllCaches();
     * <ol>
        bulk2.addParameter("refresh", "true");
        // ── DISABLED ─────────────────────────────────────────────────────
        // ── Phase 5: DISABLED, indexed path ───────────────────────────────
        assertZero("P4 before query: CI", ciEntries(stats()));
     *
            bulk.append("{\"index\":{}}\n")
                .append("\",\"age\":").append(i % 100)
        bulk2.setJsonEntity(b2.toString());  
        executePpl(ppl);
        assertZero("pure Lucene count: OI entries must be 0", oiEntries(s));
        bulk1.setJsonEntity(b1.toString());
    // ── filter = projection same columns (CI + OI overlap) ───────────────────
        provisionNamedIndex(INDEX_B);
        clearAllCaches();  
        // page-skip metric always reads col 0, so it is included even when not projected.  
        // Fresh query against the merged segment — must re-miss.  
        // Cold query — must fill CI and OI (misses) and populate metadata cache.  
                    .append("\",\"age\":").append(id % 100)  
     * Cold query fills CI with misses; warm repeat hits from cache.  
                .append("{\"name\":\"user").append(i)
        executePpl(ppl);  
        Request health = new Request("GET", "/_cluster/health/" + indexName);  
        String ppl = "source=" + INDEX_NAME + " | where match(city, 'seattle') | stats count()";  
    private long ciMisses(JsonNode s)        { return s.get("column_index_cache").get("miss_count").asLong(); }  
     * Force-merge lifecycle: two separate refresh cycles produce two segments. After a  
            // Second run — still all misses (nothing was cached from first run).
        setScopedPageIndexEnabled(true);
        req.setJsonEntity("{\"persistent\":{\"datafusion.metadata_index_cache.total_size\":null}}");
        Request bulkReq = new Request("POST", "/" + indexName + "/_bulk");  
     * Phase 2 — ENABLED, indexed path  (same data, same caches still live)
     * must not corrupt or evict entries from the other if the cache is sized
     *  
        health.addParameter("timeout", "30s");
    // ── stat accessor shorthands ──────────────────────────────────────────────  
        clearAllCaches();
        String ppl = "source=" + INDEX_NAME + " | where match(city, 'seattle') and age > 50 | stats count()";
        long p2coldActivity = ciMisses(p2cold) + oiMisses(p2cold) + ciHits(p2cold) + oiHits(p2cold);  
            + "  \"index.composite.secondary_data_formats\":\"lucene\""
                executePpl(pplA1);
    private static final ObjectMapper MAPPER = new ObjectMapper();  
            + " | where match(city, 'seattle') | stats count() as total,"
     */
        for (int i = 0; i < 500; i++) {
    private void clearColumnCaches() throws IOException {
     * so the parquet scan that fills the scoped CI/OI caches (process-global per JVM) and  
            JsonNode s2 = stats();
     * Listing path (numeric age predicate): refresh must NOT fill the scoped CI cache; only a
        JsonNode warm = stats();
            String pplB = "source=" + INDEX_B + " | where score > 75.0 | stats count()";
        Request bulk2 = new Request("POST", "/" + DYNAMIC_INDEX_NAME + "/_bulk");
        // CI: 1 file × age(col 1) × 1 RG = 1 entry  
        Map<String, Object> rb1 = assertOkAndParse(client().performRequest(bulk1), "merge-test bulk1");
    protected void onBeforeQuery() throws IOException {
     * Cold run produces CI/OI misses; warm repeat produces hits.  
        setLuceneBlockedPredicates();
     * <p>Queries must still return correct results — the cache is a performance
     * When the same column ({@code age}) is used in both a filter predicate and a projection,
            clearAllCaches();
    public void testListingPathColdMissThenWarmHit() throws Exception {
        try {
        setScopedPageIndexEnabled(true);
            cacheStats.fieldNames().forEachRemaining(group -> {
            + "  \"index.composite.secondary_data_formats\":\"lucene\""  
        JsonNode s2 = stats();  
            executePpl(pplB1);  
     * exactly the "reject everything" regime this test needs.  
     * to hold both comfortably.  
     *   <li>Indexed path — {@code match()} routes through the Lucene-indexed executor, which wires
            + "}}}";
        executePpl(agePpl);
        // Metadata is footer-only again (smaller than disabled).
            // Cold run on both indices.  
        assertPositive("dynamic batch1: CI fills for age", ciMisses(afterBatch1));
                .append("{\"name\":\"user").append(i)  
     * guaranteed to be rejected on insert (CI entry size = column_index_length bytes from the
            executePpl(pplA);
     *   <li>Query → CI misses > 0 (merged segment is a fresh miss)</li>
            JsonNode block = s.get(group);  
    private long oiHits(JsonNode s)          { return s.get("offset_index_cache").get("hit_count").asLong(); }
        JsonNode s2 = stats();  
            recreateIndex();
            clearAllCaches();
     * Numeric double field predicate: {@code score > 75.0} hits the ColumnIndex because
        StringBuilder b2 = new StringBuilder();
     * Cache sized to hold exactly one index's worth of entries (tight budget).
     * {@code city} is a keyword with string min/max statistics in the parquet ColumnIndex.  
     *   assert metadata still present (not cleared by disabling)
        Request req = new Request("PUT", "/_cluster/settings");  
        health.addParameter("wait_for_status", "green");
            executePpl(pplA1);
        // Listing path (mirrors api_metrics Q1/Q7): NO predicate, group by city, the case()  
        assertZero("P5 before query: metadata", metaMemoryBytes(stats()));
        assertExactOiEntries("string predicate: OI entries = 2 (file×{col_0,city})", 2L);  
        Request health = new Request("GET", "/_cluster/health/" + INDEX_NAME);
            + " | eval old_rate = round(old * 100.0 / total, 2)"
     * nor OI should be populated. No parquet IO means no page-index loading.
            + "  \"index.pluggable.dataformat.enabled\":true,"  
     *
     * contains computed fields like {@code CASE WHEN status = 200 ...} whose names are not file
        StringBuilder bulk = new StringBuilder();  
        // file columns, so the buggy name-based read-set inference dropped age/score and gave them  
                .append("\"}\n");
            + " sum(case(score > 75.0, 1 else 0)) as hi by city"
        assertEquals("OI entries 0 after auto-clear on disable", 0L, oiEntries(stats()));
     * Queries on INDEX_NAME and INDEX_B accumulate independent entries  
     *  
        assertCacheHitsOnWarm(ppl);  
        }
    private void assertExactCiEntries(String msg, long expected) throws Exception {
            batch1.append("{\"index\":{}}\n")  
        executePpl(indexedPpl);
        assertCacheEmpty();  
    }  
            assertNotNull(group + " block missing", block);
 * Integration tests for the scoped page-index cache (ColumnIndex + OffsetIndex).  
     * produces OI misses in addition to CI misses — even if no explicit {@code fields} clause
    }
        assertTrue(
            String pplA = "source=" + INDEX_NAME + " | where age > 80 | stats count()";  
        assertPositive("post-merge: metadata populated from merged segment", metaMemoryBytes(postmerge));
        for (int batch = 0; batch < DOC_COUNT / batchSize; batch++) {
     * <p>The test cluster runs with multiple nodes but the test index has a single shard,
    /**
        assertEquals("OI misses 0 with scoped disabled", 0L, oiMisses(s2));
        // ── ENABLED baseline ──────────────────────────────────────────────
                ciHits(warm) > hitsBefore);
            + "  \"index.pluggable.dataformat.enabled\":true,"  
        assertCacheEmpty();
        client().performRequest(req);
        // (region = 'west') scans parquet and fills the ColumnIndex instead of being
    public void testIndexedPathColdMissThenWarmHit() throws Exception {
        try { client().performRequest(new Request("DELETE", "/" + INDEX_B)); } catch (Exception ignored) {}  
     * </ul>  
        bulkReq.addParameter("refresh", "true");
        Request bulk1 = new Request("POST", "/" + DYNAMIC_INDEX_NAME + "/_bulk");  
        assertCacheHitsOnWarm(ppl);
        String ppl = "source=" + INDEX_NAME + " | where city = 'seattle' | stats count()";
            + "}}}";
 *
    private long oiMisses(JsonNode s)        { return s.get("offset_index_cache").get("miss_count").asLong(); }  
    // ── cache clear ───────────────────────────────────────────────────────────
     *   <li>clearAllCaches → assertCacheEmpty → query → assert CI fills across both segments</li>
            + "  \"name\":{\"type\":\"keyword\"},"
        recreateIndex();
        );  
        for (JsonNode node : nodes) {  
        String ppl = "source=" + INDEX_NAME + " | where city = 'seattle' | stats count()";
            setScopedPageIndexEnabled(true);
        // Batch 1 → refresh → segment 1.
        executePpl(ppl);  
 *   <li>Enabled: CI fills on cold query (misses), hits on warm repeat. Metadata cache is smaller
            // used_bytes must be 0 — nothing was stored.
        assertCacheEmpty();
        createReq.setJsonEntity(createBody);
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
     * parquet footer, always ≥ tens of bytes; OI entry size = offset_index_length, likewise).  
            long usedBytes = s.get("column_index_cache").get("memory_bytes").asLong();  
        bulk1.setOptions(bulk1.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());  
                if (i == 1) {
        assertPositive("cold metadata populated for: " + ppl, metaMemoryBytes(cold));
     * OI is keyed by (file, col) — same file+col on a repeat query is a guaranteed hit.  
        recreateIndex();
            + "  \"index.pluggable.dataformat\":\"composite\","
        } catch (Exception ignored) {  
    }
     *   recreate → clear → assertCacheEmpty  
    }
 *   <li>Schema-drift (new field added in a later segment) is handled: CI fills for the new field
        assertExactOiEntries("post-merge: OI entries = 2 (1 merged file × {col_0,age})", 2L);  
        executePpl(ppl);
    public void testCrossIndexCacheEntriesAreIndependent() throws Exception {
     * Restore the total metadata-index cache budget to the cluster default (null = derive from AC).
        // Create index with dynamic mapping (no explicit properties) and composite parquet format.
     * miss, {@code used_bytes} stays 0, {@code entry_count} stays 0.
        clearAllCaches();
            + "  \"index.pluggable.dataformat\":\"composite\","
        assertCacheFillsOnCold(ppl);
        req.setJsonEntity("{\"persistent\":{\"analytics.delegation.lucene.blocked_predicates\":null}}");
        assertOnlyOiFills(ppl);
                    if (value != null && value.isNumber()) {  
            // Each index contributes 1 CI entry (1 file × 1 pred col × 1 RG).
        }  
     * <p>With DOC_COUNT=2000 on a single shard and a single refresh the data lands in one
        Map<String, Object> rb2 = assertOkAndParse(client().performRequest(bulk2), "merge-test bulk2");  
        clearAllCaches();  
        // The old-field age query must still work correctly after schema drift.
                usedBytes <= limit
    }
     * {@code match(city, 'seattle') | stats count()} can be satisfied entirely by  
    }  
    }
                    client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_refresh"));
        // After batch 1 refresh: clear caches and verify age query fills CI.
     * (different file paths → different cache keys). Entries from one index
 *   <li>Explicit clear resets stats so the next query is a miss again.</li>
            metaMemoryBytes(p6) <= metaDisabledListing
            "disabled metadata >= enabled (page index retained): enabled="
     * "unset" and keeping the default multi-MB budget). So a 1-byte total would truncate both  
     * Block the given predicate functions from being delegated to the Lucene backend.  
        );  
    /**
        executePpl(ppl);  
            + "  \"score\":{\"type\":\"double\"},"
     * <p>This is the converse of {@link #testStringFieldFilterFillsColumnIndex}: with the default  
        assertZero("delegated EQUALS: OI misses must be 0", oiMisses(s));  
        assertEquals("dynamic bulk1 errors", false, r1.get("errors"));
        // Clear caches then verify query fills CI across both segments.  
                .append("\",\"age\":").append(i % 100)
        assertCacheEmpty();  
        // is {col 0, name, score} = 3 entries over 1 file.
     *   query → assert metadata populated, CI misses > 0
    /** Stats endpoint exposes column_index_cache and offset_index_cache with expected fields. */  
                + metaEnabled + " disabled=" + metaDisabled,
            bulkReq.setOptions(bulkReq.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        assertOkAndParse(client().performRequest(create), "create index");
        JsonNode p2cold = stats();
        } finally {  
                    : aggregate.putObject(group);  
            + " sum(case(age > 50, 1 else 0)) as old, sum(case(score > 75.0, 1 else 0)) as hi by city"  
            bulkReq.addParameter("refresh", lastBatch ? "true" : "false");
     *  
            if (i > 0) arr.append(',');
     *
    @Override
     * Run {@code ppl} cold (caches assumed empty by caller) and assert that both CI and OI fill.
        JsonNode warm = stats();
        assertZero("pure Lucene count: CI entries must be 0", ciEntries(s));  
     * When an entry's {@code size > limit} the Rust cache skips the insert — every access is a
                }
    }  
}  
     * <p>String fields (keyword/text) route their predicates to Lucene's inverted index by
        assertPositive("CI+OI overlap: OI misses > 0", oiMisses(cold));
            + "  \"index.pluggable.dataformat\":\"composite\","
                    ? (com.fasterxml.jackson.databind.node.ObjectNode) aggregate.get(group)
            restoreCacheDefaults();  
    }  
        assertEquals("OI misses 0 on indexed path disabled", 0L, oiMisses(s2));
        return aggregate;
     * </ul>  
        assertPositive("dynamic batch1: metadata populated", metaMemoryBytes(afterBatch1));  
        String indexed = "source=" + INDEX_NAME
        executePpl(ppl);
        }  
        String[] cities = {"seattle", "portland", "denver", "austin", "boston"};
        assertCacheEmpty();
     * intermittently observe an empty cache simply because the request landed on a node that
     * <p>CI key = (file, col, rg) so expectedCi = files × predicateCols × rowGroupsPerFile.
        assertPositive("P3 disable: metadata cache still present", metaMemoryBytes(p3));
        assertZero("disabled OI misses run1: " + ppl, oiMisses(s1));  
            assertPositive("CI misses must be > 0 with 1b limit", ciMisses(s1));
    }
        req.setJsonEntity("{\"persistent\":{\"datafusion.scoped_page_index.enabled\":" + enabled + "}}");
                .append(",\"city\":\"").append(cities[i % cities.length])  
        executePpl(ppl);
        }
        clearAllCaches();  
     */
        assertTrue("indexed cold: CI misses > 0", ciMisses(cold) > 0);  
        assertPositive("P1 cold: metadata populated", metaMemoryBytes(p1cold));
     * Lucene's inverted index without touching the parquet files, so neither CI
     */
                0L, oiEntries(s1));
    public void testListingPathDisabledMetadataCacheLarger() throws Exception {
            + "  \"score\":{\"type\":\"double\"},"  
            assertPositive("cross-index: B CI misses after full clear", ciMisses(stats()));  
     *   recreate → clear → assertCacheEmpty
     * integer truncation, and the native limit setters IGNORE a zero limit (treating it as
            + " | fields city, total, old_rate";  
                    .append(",\"city\":\"").append(cities[id % cities.length])
        executePpl(ppl);
     *   query → CI misses fill again (confirms scoped cache is back)
     */
        assertTrue("indexed enabled: metadata cache populated", metaEnabled > 0);  
        clearColumnCaches();  
        setLuceneBlockedPredicates("EQUALS");  
            executePpl(pplB); // ensure B is warm
            executePpl(proj);
        recreateIndex();
    /**
            b2.append("{\"index\":{}}\n")
    /**
     * <pre>
        health.addParameter("wait_for_status", "green");
import java.util.Map;  
        executePpl(agePpl);  
     * <ul>
        executePpl(listing); // warm: exercise the cached-OI path too
            restoreCacheDefaults();
    }
    /**  
 *
        }
        for (int i = 0; i < DOC_COUNT; i++) {
        String listing = "source=" + INDEX_NAME
        try { client().performRequest(new Request("DELETE", "/" + INDEX_NAME)); } catch (Exception ignored) {}
        assertNotNull("nodes block missing", nodes);  
        } finally {
import com.fasterxml.jackson.databind.ObjectMapper;
        // a placeholder OffsetIndex, corrupting the page read.
    /** Restore the Lucene delegation block-list to the cluster default (null clears the override). */
    // ── projection-only, no filter (OI only) ─────────────────────────────────  
            + "  \"city\":{\"type\":\"keyword\"}"  
        assertPositive("post-merge: OI misses > 0 (forced re-miss after merge)", oiMisses(postmerge));
        assertOkAndParse(client().performRequest(create), "create " + indexName);
     */  
        assertOkAndParse(client().performRequest(createReq), "merge-test: create index");
            // Projection-only — must work correctly.
/*  
    }
        // object with the same shape the accessor helpers expect. Counters (hit_count,  
 *       from the segment that carries it, and the old-field query continues to work.</li>
                + metaEnabledListing + " disabled=" + metaDisabledListing,
        String ppl = "source=" + INDEX_NAME + " | where age > 90 | stats count()";  
     *  
                });
            long limit = s.get("column_index_cache").get("size_limit_bytes").asLong();
        assertPositive("P1 cold: CI misses", ciMisses(p1cold));
    public void testStringFieldFilterFillsColumnIndex() throws Exception {  
 * then {@code clearAllCaches()}, then {@code assertCacheEmpty()} before measuring. This ensures
     * out of the scoped OffsetIndex and got a single-page placeholder. When the scan actually read  
            setCacheTotalSize("2kb");  
        assertExactOiEntries("numeric predicate: OI entries = 2 (file×{col_0,score})", 2L);
/**
        String body = "{"  
            }
            assertCacheEmpty();
        setLuceneBlockedPredicates("EQUALS");  
        bulk2.setJsonEntity(batch2.toString());
        super.tearDown();  
     * <ol>
        assertTrue(  
    }  
    /**
                s1.get("offset_index_cache").get("size_limit_bytes").asLong() <= 8L);
import com.fasterxml.jackson.databind.JsonNode;
        req.setJsonEntity("{\"persistent\":{\"analytics.delegation.lucene.blocked_predicates\":" + arr + "}}");
        JsonNode s = stats();
    }
        // Batch 2: adds NEW field region to every doc → creates segment 2 with schema drift.
        recreateIndex();
        Map<String, Object> r = assertOkAndParse(client().performRequest(bulkReq), "bulk " + indexName);
     * inside the test body lifecycle where {@link #client()} is guaranteed non-null.
            restoreLuceneBlockedPredicates();
        StringBuilder arr = new StringBuilder("[");  
            clearAllCaches();
 *   <li>Both CI and OI fill when the same column is filtered and projected.</li>  
    /** Explicit CI clear resets hit counter; next query is a miss again. */  
            + "  \"age\":{\"type\":\"integer\"},"
     * backend, which is what fills the scoped ColumnIndex cache. Pass an empty list to clear.  
        JsonNode cold = stats();
            + "}}}";
     *   <li>1 predicate col → CI entries = 1</li>
        // OI: 1 merged file × {col_0(name), age(col 1)} = 2 entries (down from 4)
    private JsonNode stats() throws Exception {  
        health.addParameter("timeout", "30s");  
    }  
        String ppl = "source=" + INDEX_NAME + " | fields name, score | head 100";  
            executePpl(listing);  
     */
    /**
    public void testStatsShapeHasBothCacheGroups() throws Exception {
        JsonNode p5 = stats();
     * Does NOT clear or assert metadata — the caller controls surrounding state.
            String pplB2 = "source=" + INDEX_B + " | where score > 60.0 | stats count()";
     *
        clearAllCaches();
    // ── low-level assertion utilities ─────────────────────────────────────────
                .append(",\"city\":\"").append(cities[i % cities.length])
        assertPositive("pre-merge: OI misses across both segments", oiMisses(premerge));
            // A typical CI entry for an integer column with 2000 rows is ~100-500 bytes.
     */
    }
            + "\"mappings\":{\"properties\":{"
     * Projection-only query with no filter: {@code fields name, score | head 100} requires the  
        clearAllCaches();  
        provisionNamedIndex(INDEX_B);
        // delegated to Lucene.
        JsonNode p1cold = stats();  
                // Interleave refreshes to create new segments.  
        executePpl(ppl);
        // region/city are keyword fields; block EQUALS so the keyword-equality predicate  
            + "  \"score\":{\"type\":\"double\"},"
        client().performRequest(health);
     * query should. Cold run produces CI misses; warm repeat produces CI hits.  
     *
        // OI: 1 file × {col_0(name), city(col 3)} = 2 entries
            // Correctness: cache must never exceed its limit.
            + "  \"city\":{\"type\":\"keyword\"}"  
     * that column, arrow decoded the whole chunk as one page and failed with
        // Force-merge to a single segment — old segment entries in the scoped cache are stale.  
            metaDisabledListing >= metaEnabledListing  
        // match() + count(*) — Lucene satisfies this without scanning parquet pages
     * <ul>
            metaDisabled >= metaEnabled  
        StringBuilder batch2 = new StringBuilder();  
            });
            // Warm run on both — both should hit.
        assertZero("pure Lucene count: OI hits must be 0", oiHits(s));
        // touch parquet. Block EQUALS so the predicate scans parquet and fills the ColumnIndex.
    /**  
        assertZero("disabled CI misses run1: " + ppl, ciMisses(s1));
     * Fetches DataFusion cache stats aggregated across <em>all</em> nodes in the cluster.  
        assertZero("P1 refresh: metadata", metaMemoryBytes(stats()));  
                .append("{\"name\":\"user").append(i)  
            + "  \"index.composite.primary_data_format\":\"parquet\","
            assertCacheEmpty();
        assertZero("P5 OI hits", oiHits(p5));
        assertTrue("enabled: CI must have activity", ciMisses(s1) + ciHits(s1) > 0);  
    }
     * from the projected output field <em>names</em>, but with expression push-down the projection  
        health.addParameter("timeout", "30s");  
    // ── string field filter (CI) ──────────────────────────────────────────────
        assertZero("pure Lucene count: CI hits must be 0", ciHits(s));
            // Indexed path — must also work correctly with evicted cache.  
 * </ul>
     * Using {@code setUp()} is unsafe here because {@code client()} may not yet be  
     */  
        assertCacheEmpty();  
        assertExactCiEntries("filter=projection: CI entries = 1 (age×file×rg)", 1L);
    // ── dynamic mapping — new field in second segment ─────────────────────────  
        JsonNode p2warm = stats();
            executePpl(indexed);
     * {@code score} carries numeric min/max statistics in the parquet ColumnIndex.
                executePpl(pplB2);
        assertTrue(  
            + "  \"index.composite.primary_data_format\":\"parquet\","
     *       though the first segment has no such column.</li>  
    public void tearDown() throws Exception {  
        // Refresh must NOT fill the scoped cache.
        clearAllCaches();
     */
        }
        for (int i = 500; i < 1000; i++) {
    }
    private void assertCacheHitsOnWarm(String ppl) throws Exception {
 *   <li>After a force-merge the pre-merge segment entries are gone; a fresh query re-misses.</li>  
        // refreshes ourselves so we get two distinct segments.
     * <p>OI is built for {@code predicate ∪ projection ∪ {col 0}}, so any predicate query
        assertCacheEmpty();  
 *       because page index entries are stripped and kept separately in the scoped cache.</li>  
        assertEquals("CI misses 0 with scoped disabled", 0L, ciMisses(s2));  
        executePpl(ppl);
            assertTrue("cross-index: CI hits must increase after warm queries on both indices",  
                .append(",\"city\":\"").append(cities[i % cities.length])  
     */
        JsonNode s = stats();  
        Request req = new Request("PUT", "/_cluster/settings");
            executePpl(listing);
        );
        assertZero("P6 before query: metadata", metaMemoryBytes(stats()));  
            // This forces eviction when both indices push entries concurrently.
                continue;  
        bulk2.setOptions(bulk2.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        assertEquals("dynamic bulk2 errors", false, r2.get("errors"));  
    private void provisionNamedIndex(String indexName) throws IOException {
    // ── stats shape ───────────────────────────────────────────────────────────
        long p2warmHits = ciHits(p2warm) + oiHits(p2warm);
        assertExactCiEntries("projection-only: CI entries = 0 (no predicate)", 0L);
        // The cluster-settings PUT is acknowledged only after every node has applied the update and
                .append("\"}\n");  
        executePpl(indexed); // warm  
    /**
            executePpl(pplB);
        setScopedPageIndexEnabled(false);  
                groupNode.fieldNames().forEachRemaining(field -> {
        // Warm query — hits from both CI and OI caches.  
                if (groupNode == null || !groupNode.isObject()) {
        Request bulk1 = new Request("POST", "/" + INDEX_NAME + "/_bulk");  
            // best-effort: don't mask the test failure
        executePpl(indexedPpl);  
    private static final String INDEX_B = "scoped_cache_it_b";
        assertZero("delegated EQUALS: CI entries must be 0", ciEntries(s));
     * the per-runtime metadata cache only happens on the node that hosts that shard. The
            + "  \"index.composite.primary_data_format\":\"parquet\","  
        // Clear caches before measuring new-field scenario.
 */  
        assertCacheEmpty();
            // Entries must be 0 — entries are too large to fit, so nothing is stored.  
     * number of segments.
 * Key invariants verified across the suite:  
    private void assertExactOiEntries(String msg, long expected) throws Exception {
            // Interleave queries on both indices — drives concurrent cache inserts + evictions.  
            StringBuilder bulk = new StringBuilder();
     * Phase 1 — ENABLED, listing path
        assertTrue("warm query must register OI hits", oiHits(warm) > 0);
            // small enough that no entry can ever fit.
        String ppl = "source=" + INDEX_NAME + " | where age > 90 | stats count()";
                    .append("{\"name\":\"user").append(id)
     * Aggregation whose {@code case(...)} expression reads a column that is NOT in the
        Map<String, Object> r1 = assertOkAndParse(client().performRequest(bulk1), "dynamic bulk1");
            String pplA1 = "source=" + INDEX_NAME + " | where age > 80 | stats count()";
        create.setJsonEntity(body);
                + metaEnabled + " disabled=" + metaDisabled,
        assertZero("delegated EQUALS: OI hits must be 0", oiHits(s));
            assertEquals("OI memory_bytes must be 0", 0L,
        executePpl("source=" + INDEX_NAME + " | where age > 50 | stats count()");
        assertCacheEmpty();
 */  
        bulk1.addParameter("refresh", "true");
     * Concurrent queries on INDEX_NAME and INDEX_B put the FIFO write lock under
        // Cold query — fills both CI and OI.
     *
     * FIFO drain path under concurrent inserts.  
     *   <li>Cache stats must be internally consistent (no phantom entries).</li>
            clearAllCaches();
        executePpl(regionPpl);
        // Wipe stale entries; the merged segment should not be in the cache.
    /**
        String indexedPpl = "source=" + INDEX_NAME + " | where match(city, 'seattle') and age > 50 | stats count()";
     * Listing path disabled: CI/OI = 0, metadata cache larger than enabled baseline.  
        assertTrue("enabled: metadata cache populated by query", metaEnabled > 0);
        // ── Phase 1: ENABLED, listing path ────────────────────────────────  
                .append("\",\"region\":\"").append(regions[i % regions.length])
    /**
        assertZero("P1 refresh: CI entries", ciEntries(stats()));
     * <p>The budget is set to approximately the size of CI entries for one index so
        assertZero("P3 disable: OI entries auto-cleared", oiEntries(p3));  
        assertZero("P4 before query: OI", oiEntries(stats()));  
    /**  
    private long oiEntries(JsonNode s)       { return s.get("offset_index_cache").get("entry_count").asLong(); }
     * the query must consult both the ColumnIndex (predicate push-down) and the OffsetIndex
        StringBuilder batch1 = new StringBuilder();  
            metaDisabled >= metaEnabled  
    private long ciEntries(JsonNode s)       { return s.get("column_index_cache").get("entry_count").asLong(); }
     */
    /**  
        Request create = new Request("PUT", "/" + indexName);
        assertPositive("pre-merge: metadata populated", metaMemoryBytes(premerge));  
            // Set a tight budget: ~500 bytes — enough for a handful of entries but not all.  
    private void setLuceneBlockedPredicates(String... predicates) throws IOException {
        // aggregations read `age`/`score` which are not otherwise projected. Projection push-down
                .append(",\"score\":").append(50.0 + (i % 50))
        );
        assertTrue("indexed disabled: metadata cache populated", metaDisabled > 0);
        setScopedPageIndexEnabled(true);
    /**
    @Override  
        executePpl(ppl);
    }
        setCacheTotalSize("8b");
        for (int i = 500; i < 1000; i++) {  
        assertZero("P4 before query: metadata", metaMemoryBytes(stats()));
        long metaEnabled = metaMemoryBytes(s1);
     *  
        // After setUp(): refresh must not have filled the scoped cache.
        // CI: 1 file × score(col 2) × 1 RG = 1 entry
    public void testFilterAndProjectionSameColumnFillsBothCaches() throws Exception {
    public void testCaseAggregationOnNonProjectedColumnIndexedPath() throws Exception {
            for (int i = 0; i < 3; i++) {
     * inserting B's entries forces eviction of A's (or vice versa) — exercising the
    // ── tiny cache limits — correctness under eviction pressure ──────────────
            Map<String, Object> r = assertOkAndParse(client().performRequest(bulkReq), "bulk batch " + batch);  
     *   <li>used_bytes must not exceed the limit (correctness under eviction).</li>
        assertTrue("cold query must register OI misses (predicate col + col 0)", oiMisses(cold) > 0);
        long metaEnabled = metaMemoryBytes(s1);
        );
     *       expands.</li>
     * Indexed path: refresh must NOT fill the scoped CI/OI cache; only a query should.
        assertZero("disabled OI hits run2: " + ppl, oiHits(s2));
     * <p>Two variants exercise both factory-install paths:
     */
        assertOkAndParse(client().performRequest(create), "create dynamic index");
     *       the scoped page index via a different code path ({@code collect_plan_column_names}).</li>
        assertEquals("refresh must NOT fill CI cache", 0L, ciEntries(afterRefresh));
    private void assertZero(String msg, long v)     { assertEquals(msg + " must be 0, got " + v, 0L, v); }
     * answered by Lucene's inverted index. The parquet file is never scanned for that predicate, so
            long hitsBefore = ciHits(cold);
                assertTrue(group + "." + field + " missing", block.has(field));  
        assertExactCiEntries("post-merge: CI entries = 1 (1 merged file × age × rg)", 1L);
     * <p>Same flow as the listing test: recreate → clear → assertCacheEmpty → query → measure.
                .append("\",\"age\":").append(i % 100)
                        aggGroup.put(field, combined);
        assertPositive("dynamic: age CI still fills after schema drift", ciMisses(afterAgeDrift));  
    // ── cross-index shared cache ──────────────────────────────────────────────  
            // size_limit_bytes must reflect the configured tiny per-cache limit (% of 8b),  
        assertTrue("cache_stats block missing on every node", aggregate.size() > 0);
        client().performRequest(health);
        setScopedPageIndexEnabled(true);  
        }
    private static final String CLEAR_ENDPOINT = "/_plugins/_analytics_backend_datafusion/cache/_clear";  
     * never ran the scan.
        assertTrue("disabled: metadata cache populated by query", metaDisabled > 0);
            for (int i = 0; i < batchSize; i++) {
        executePpl(ppl);  
        String createBody = "{"
        try { client().performRequest(new Request("DELETE", "/" + INDEX_NAME)); } catch (Exception ignored) {}
        assertTrue("cold query must register CI misses", ciMisses(cold) > 0);
        JsonNode afterRefresh = stats();
        fm.addParameter("max_num_segments", "1");
        // would report N× the configured limit.
        assertEquals(indexName + " bulk errors", false, r.get("errors"));
    /**
            // B's entries are fresh misses after the clear — that's expected and correct.
        executePpl(ppl);
        client().performRequest(new Request("POST", CLEAR_ENDPOINT));
        JsonNode s = stats();
            "P5 disabled indexed metadata >= enabled: enabled="
        // ── DISABLED ─────────────────────────────────────────────────────
            executePpl(pplA);  
    }
        Request health = new Request("GET", "/_cluster/health/" + INDEX_NAME);
    @Override  
        assertZero("assertCacheEmpty: metadata memory", metaMemoryBytes(s));
        assertZero("delegated EQUALS: CI misses must be 0", ciMisses(s));  
                    return;
        long metaDisabledIndexed = metaMemoryBytes(p5);
    private void restoreLuceneBlockedPredicates() throws IOException {  
            // Clearing index A's entries via prefix eviction must not affect index B.  
            executePpl(lucene);
            long ciAfterBoth = ciEntries(cold);  
        recreateIndex();
     * Cold query fills CI with misses; warm repeat hits from cache.
     */  
        assertCacheEmpty();  
     * <p>The budget is split across the sub-caches by fixed percentages (CI 13%, OI 34%) with
        assertEquals("OI hits 0 on indexed path disabled", 0L, oiHits(s2));
        String ppl = "source=" + INDEX_NAME + " | where match(city, 'seattle') and age > 50 | stats count()";  
     * contention while eviction fires. After all queries:  
    }
                    .append(",\"score\":").append(50.0 + (id % 50))
                .append("\"}\n");
     * </ol>
    /**
        Request createReq = new Request("PUT", "/" + INDEX_NAME);  
        bulk1.addParameter("refresh", "true");
        assertExactOiEntries("filter=projection: OI entries = 2 (file×{col_0(name),age})", 2L);  
            try { client().performRequest(new Request("DELETE", "/" + INDEX_B)); } catch (Exception ignored) {}
        assertTrue("indexed cold: metadata cache populated by query", metaMemoryBytes(cold) > 0);
        JsonNode afterBatch1 = stats();
            executePpl(pplB);
        StringBuilder b1 = new StringBuilder();  
    }
     * columns. The base column the CASE reads ({@code age}/{@code score} here) was therefore left
        clearAllCaches();
            // Result correctness: queries must return valid results regardless of eviction.
     * Every test that needs a clean state calls this explicitly.
            assertEquals("bulk batch " + batch + " errors", false, r.get("errors"));
            + "  \"index.pluggable.dataformat.enabled\":true,"
        JsonNode s1 = stats();
    private static final String INDEX_NAME = "scoped_cache_it";
    // ── pure Lucene path (no parquet scan) ───────────────────────────────────  
    }  
        // Here name/score are distinct keyword/double leaves (neither is col 0), so the set
     *  
     */
        setScopedPageIndexEnabled(false);  
 * SPDX-License-Identifier: Apache-2.0
        // Cold listing query.
        try { client().performRequest(new Request("DELETE", "/" + INDEX_B)); } catch (Exception ignored) {}  
    /** Provision a named parquet index with the same schema as the main test index. */
     * Two parquet indices share the same process-global CI/OI caches.
    public void testCaseAggregationOnNonProjectedColumnListingPath() throws Exception {
        clearAllCaches();
            // Listing path predicate — misses every time, never gets cached.
     *  
        bulkReq.setJsonEntity(bulk.toString());
     */
     * route a {@code _local} stats request to any node. Reading a single node's stats would  
        String ppl = "source=" + INDEX_NAME + " | where age > 80 | stats count()";
     *   <li>Batch 2 → refresh (segment 2)</li>
            + "  \"name\":{\"type\":\"keyword\"},"  
            assertEquals("OI entry_count must be 0 (entries too large for 1b limit)",  
        assertPositive("P2 cold indexed: CI/OI activity", p2coldActivity);
    // ── numeric field filter (CI) ─────────────────────────────────────────────
     *   match() query → CI/OI misses or hits recorded (cumulative)
        long metaDisabled = metaMemoryBytes(s2);
        String regionPpl = "source=" + DYNAMIC_INDEX_NAME + " | where region = 'west' | stats count()";
        client().performRequest(req);  
            String listing = "source=" + INDEX_NAME + " | where age > 90 | stats count()";  
        Request req = new Request("PUT", "/_cluster/settings");
     * so the ColumnIndex should NOT be consulted at all.
            JsonNode cold = stats();  
        clearAllCaches();  
        assertPositive("CI+OI overlap: CI misses > 0", ciMisses(cold));  
     * what the assertions want: cache activity is non-zero iff <em>some</em> node did the work,  
     */
        JsonNode afterAgeDrift = stats();
     *   assert CI = 0, OI = 0  
import java.io.IOException;
        String listingPpl = "source=" + INDEX_NAME + " | where age > 90 | stats count()";  
     * Phase 4 — DISABLED, listing path  
     *   query again → assert CI hits > 0 (warm)
     * OI → 8×34/100 = 2 bytes — both non-zero (honored) yet far below any real entry, which is
        assertTrue("cold query must populate metadata cache", metaMemoryBytes(cold) > 0);  
     * <p>Regression test for a scoped-OffsetIndex bug: the optimizer derived the scan's read set
        // Warm listing query.
                .append("\",\"age\":").append(i % 100)
    public void testIndexedPathDisabledMetadataCacheLarger() throws Exception {  
package org.opensearch.analytics.qa;
            );  
import org.opensearch.client.Response;  
     * Uses a dedicated index ({@value #DYNAMIC_INDEX_NAME}) with dynamic mapping so no explicit
     */
        executePpl(ppl);  
            executePpl(pplB); // should hit from re-populated B after cache clear
    }
        for (int i = 0; i < 500; i++) {
    public void testDynamicMappingNewFieldInSecondSegmentFillsCI() throws Exception {
        return true;
     * Assert that all scoped cache counters and metadata memory are zero (i.e. caches are empty).  
        clearAllCaches();
        health.addParameter("wait_for_status", "green");
        JsonNode afterRefresh = stats();  
        } finally {
        assertZero("P1 refresh: OI entries", oiEntries(stats()));
        // makes the scan project {city, CASE(age...), CASE(score...)} — the CASE fields are not
 *   <li>Toggle-off clears CI/OI caches immediately; metadata cache is unaffected.</li>  
            String lucene = "source=" + INDEX_NAME + " | where match(city, 'seattle') | stats count()";
     * For multi-segment scenarios (two separate refreshes before merge) multiply by the
            JsonNode cacheStats = node.get("cache_stats");
    // ── full enabled → disabled lifecycle loop ────────────────────────────────
        // CI: 1 file × city(col 3) × 1 RG = 1 entry  
        JsonNode p3 = stats();
            + "  \"age\":{\"type\":\"integer\"},"
     * Intended for projection-only queries that carry no predicate.  
     * Phase 3 — DISABLE  (auto-clear CI/OI)
     */  
        JsonNode postmerge = stats();
            "P6 re-enabled metadata must be <= disabled (page index stripped): enabled="  
        // Metadata cache is unaffected by the toggle.
            + "  \"number_of_shards\":1,\"number_of_replicas\":0,"
     * caches therefore live on one specific node, while the round-robin REST client may
     * The cluster-settings PUT is acknowledged only after every node has applied the update and run
        assertZero("assertCacheEmpty: OI entries", oiEntries(s));
     *
    /**
        JsonNode cold = stats();
     */
    /**  
        }
     */
        // Combine each cache group's fields across all nodes into a synthetic cache_stats
     * <p>Guards against a regression where a delegated string predicate still triggers a parquet
        assertPositive("P6 re-enabled: metadata populated", metaMemoryBytes(p6));  
        assertZero("P5 OI misses", oiMisses(p5));  
        executePpl(ppl);
     */
     * </ol>  
    }  
            assertTrue("CI misses must increase on second run", ciMisses(s2) > ciMisses(s1));
                            : prev + value.asLong();
        try {
     * shares to 0 and leave the real caches huge. We use 8 bytes instead: CI → 8×13/100 = 1 byte,
    public void testClearColumnIndexResetsToMiss() throws Exception {
    private void recreateIndex() throws IOException {  
    }  
    private static final int DOC_COUNT = 2000;
        assertTrue("indexed warm: CI hits > 0", ciHits(warm) > 0);  
        assertZero("P6 before query: CI", ciEntries(stats()));
    private void assertPositive(String msg, long v) { assertTrue(msg + " must be > 0, got " + v, v > 0); }
        assertEquals("OI hits 0 with scoped disabled", 0L, oiHits(s2));
        create.setJsonEntity(createBody);  
        JsonNode premerge = stats();  
     * (all nodes) and sum each cache counter across every node. Cluster-wide sums are exactly
    }  
        client().performRequest(health);  
        client().performRequest(health);  
            + "\"settings\":{"
     * {@code executePpl} asserts HTTP 200, so a decompression failure fails the test.
        assertZero("P4 CI misses", ciMisses(p4));  
    private static final String DYNAMIC_INDEX_NAME = "scoped_cache_dynamic_it";
        executePpl(ppl);
        JsonNode p6 = stats();
     * Full lifecycle covering listing + indexed paths through enabled → disabled → re-enabled:
        clearAllCaches();  
        assertEquals("refresh must NOT fill OI cache", 0L, oiEntries(afterRefresh));  
                s1.get("column_index_cache").get("memory_bytes").asLong());
            executePpl(pplA); // re-populates A  
     * loading page-index bytes fresh from the object store on every query.
     * Call this after {@link #clearAllCaches()} to confirm the clear took effect before measuring.
                .append(",\"score\":").append(50.0 + (i % 50))
            // Simulate an eviction for INDEX_NAME by clearing all and re-running only B.
        health.addParameter("timeout", "30s");
        assertEquals("CI entries 0 after auto-clear on disable", 0L, ciEntries(stats()));
        Request fm = new Request("POST", "/" + INDEX_NAME + "/_forcemerge");
     */
            + "\"settings\":{"
            + " | fields city, total, old, hi";
        req.setJsonEntity("{\"persistent\":{\"datafusion.metadata_index_cache.total_size\":\"" + size + "\"}}");
        bulkReq.setOptions(bulkReq.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());  
    public void testProjectionOnlyFillsOffsetIndexNotColumnIndex() throws Exception {
     *
    public void testNumericFieldFilterFillsColumnIndex() throws Exception {
 *   <li>Disabled: CI/OI stats = 0. Metadata cache is larger because page index is retained via
        // After recreateIndex() + clearAllCaches() in setUp():
        assertEquals("refresh must NOT fill OI cache", 0L, oiEntries(afterRefresh));
     * Assert exact entry count with an informative message.
        assertTrue("warm query must register CI hits", ciHits(warm) > 0);
        JsonNode s = stats();
