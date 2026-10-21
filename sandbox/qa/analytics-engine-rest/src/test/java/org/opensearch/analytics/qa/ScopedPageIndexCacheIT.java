        assertEquals("CI hits reset to 0 after clear", 0L, ciHits(stats()));
        try { client().performRequest(new Request("DELETE", "/" + INDEX_B)); } catch (Exception ignored) {}
        assertPositive("pre-merge: CI misses across both segments", ciMisses(premerge));
    private void assertOnlyOiFills(String ppl) throws Exception {
    // ── filter = projection same columns (CI + OI overlap) ───────────────────
        client().performRequest(fm);
            String lucene = "source=" + INDEX_NAME + " | where match(city, 'seattle') | stats count()";
    protected void onBeforeQuery() throws IOException {
                + metaMemoryBytes(p6) + " disabled=" + metaDisabledListing,
        executePpl(ppl);
        // Clean up any leftovers from a prior run.
        assertZero("disabled CI misses run1: " + ppl, ciMisses(s1));
     */
     *
        assertEquals("CI entries 0 after auto-clear on disable", 0L, ciEntries(stats()));
     * "unset" and keeping the default multi-MB budget). So a 1-byte total would truncate both
        assertEquals("refresh must NOT fill CI cache", 0L, ciEntries(afterRefresh));
     */
    // ── indexed path (match() → Lucene + DataFusion) ──────────────────────────
                + metaEnabled + " disabled=" + metaDisabled,
     * Block the given predicate functions from being delegated to the Lucene backend.
            + "\"mappings\":{\"properties\":{"
 * SPDX-License-Identifier: Apache-2.0
            + "}}}";
        recreateIndex();
     * loading page-index bytes fresh from the object store on every query.
     * OffsetIndex to locate the page offsets for the projected columns, but there is no predicate
    // ── cross-index shared cache ──────────────────────────────────────────────
            + "  \"index.composite.primary_data_format\":\"parquet\","
        // is {col 0, name, score} = 3 entries over 1 file.
     *   <li>Listing path — numeric predicate keeps the scan on the listing/parquet path.</li>
     * <ul>
     *
     * (all nodes) and sum each cache counter across every node. Cluster-wide sums are exactly
    private void provisionNamedIndex(String indexName) throws IOException {
        assertEquals("refresh must NOT fill OI cache", 0L, oiEntries(afterRefresh));
            + "  \"index.composite.primary_data_format\":\"parquet\","
        JsonNode s = stats();
        Request create = new Request("PUT", "/" + DYNAMIC_INDEX_NAME);
        bulk1.setJsonEntity(b1.toString());
    /**
        clearAllCaches();
        setLuceneBlockedPredicates("EQUALS");
        Request createReq = new Request("PUT", "/" + INDEX_NAME);
            // A typical CI entry for an integer column with 2000 rows is ~100-500 bytes.
                .append("\"}\n");
            assertEquals("CI hits must remain 0 — nothing fits in 1b cache", 0L, ciHits(s2));
            + "\"settings\":{"
                usedBytes <= limit
        try { client().performRequest(new Request("DELETE", "/" + INDEX_NAME)); } catch (Exception ignored) {}
            // Second run — still all misses (nothing was cached from first run).
        executePpl(indexed); // warm
        assertPositive("warm OI hits for: " + ppl, oiHits(warm));
    }
            assertEquals("OI entry_count must be 0 (entries too large for 1b limit)",
        executePpl(ppl);
    // ── reusable assertion helpers ────────────────────────────────────────────
        Request fm = new Request("POST", "/" + INDEX_NAME + "/_forcemerge");
            metaDisabledIndexed >= metaEnabledListing
/*
    }
    }
    private long ciMisses(JsonNode s)        { return s.get("column_index_cache").get("miss_count").asLong(); }
            + "}}";
     */
        JsonNode s = stats();
 *
    }
        assertZero("P3 disable: CI entries auto-cleared", ciEntries(p3));
        assertZero("delegated EQUALS: OI entries must be 0", oiEntries(s));
            clearAllCaches();
    public void testDelegatedStringPredicateProducesNoOffsetIndexActivity() throws Exception {
        String ppl = "source=" + INDEX_NAME + " | where city = 'seattle' | stats count()";
        assertTrue("cold query must register OI misses (predicate col + col 0)", oiMisses(cold) > 0);
            executePpl(pplB); // should hit from re-populated B after cache clear
            + "  \"number_of_shards\":1,\"number_of_replicas\":0,"
            // Each index contributes 1 CI entry (1 file × 1 pred col × 1 RG).
        bulk2.setOptions(bulk2.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
            + "  \"age\":{\"type\":\"integer\"},"
        assertTrue("indexed cold: CI misses > 0", ciMisses(cold) > 0);
     *   <li>N projection cols → OI entries = N</li>
     *
                            ? Math.max(prev, value.asLong())
public class ScopedPageIndexCacheIT extends AnalyticsRestTestCase {
    }
     * String keyword field predicate: {@code city = 'seattle'} hits the ColumnIndex because
        assertZero("P4 CI misses", ciMisses(p4));
     */
        health.addParameter("wait_for_status", "green");
     * <p>With DOC_COUNT=2000 on a single shard and a single refresh the data lands in one
    private long oiEntries(JsonNode s)       { return s.get("offset_index_cache").get("entry_count").asLong(); }
        executePpl(listingPpl);
        assertEquals("CI hits 0 on indexed path disabled", 0L, ciHits(s2));
            if (i > 0) arr.append(',');
     * <p>The budget is split across the sub-caches by fixed percentages (CI 13%, OI 34%) with
 * <ul>
            setScopedPageIndexEnabled(true);
                    .append("\",\"age\":").append(id % 100)
            + "  \"index.pluggable.dataformat\":\"composite\","
        Map<String, Object> r1 = assertOkAndParse(client().performRequest(bulk1), "dynamic bulk1");
        long metaEnabledListing = metaMemoryBytes(p1cold);
     * For multi-segment scenarios (two separate refreshes before merge) multiply by the
        assertCacheFillsOnCold(ppl);
        JsonNode s1 = stats();
            long limit = s.get("column_index_cache").get("size_limit_bytes").asLong();
            batch1.append("{\"index\":{}}\n")
                .append(",\"city\":\"").append(cities[i % cities.length])
        // After batch 1 refresh: clear caches and verify age query fills CI.
    private void assertPositive(String msg, long v) { assertTrue(msg + " must be > 0, got " + v, v > 0); }
        long metaDisabledListing = metaMemoryBytes(p4);
     */
        assertTrue(
     */
        executePpl(ppl);
     * When an entry's {@code size > limit} the Rust cache skips the insert — every access is a
package org.opensearch.analytics.qa;
 * that any warming triggered by the refresh inside {@code recreateIndex()} is wiped out.
        // aggregations read `age`/`score`, which are not in the group-by/projection list.
            String listing = "source=" + INDEX_NAME + " | where age > 90 | stats count()";
        assertTrue("cold query must populate metadata cache", metaMemoryBytes(cold) > 0);
            + "  \"index.composite.secondary_data_formats\":\"lucene\""
        );
     * <ol>
        health.addParameter("timeout", "30s");
        JsonNode afterRefresh = stats();
     */
        Request bulk1 = new Request("POST", "/" + INDEX_NAME + "/_bulk");
        );
            clearAllCaches();
        // run the cache-limit consumer, so the scoped limits are already live when this returns.
        long p2coldActivity = ciMisses(p2cold) + oiMisses(p2cold) + ciHits(p2cold) + oiHits(p2cold);
        assertNotNull("nodes block missing", nodes);
     */
        bulk2.setJsonEntity(b2.toString());
        // Provision a second index with the same schema.
    /** Stats endpoint exposes column_index_cache and offset_index_cache with expected fields. */
                if (i == 1) {
            long ciAfterBoth = ciEntries(cold);
        assertCacheEmpty();
        assertExactOiEntries("post-merge: OI entries = 2 (1 merged file × {col_0,age})", 2L);
    public void tearDown() throws Exception {
        JsonNode afterBatch1 = stats();
        // ── Phase 2: ENABLED, indexed path ────────────────────────────────
        client().performRequest(req);
            + "  \"index.pluggable.dataformat\":\"composite\","
        assertTrue("re-run after clear produces misses", ciMisses(stats()) > 0);
        provisionNamedIndex(INDEX_B);
     * first segment already exists. Verifies that:
        String indexed = "source=" + INDEX_NAME
     *
    }
        setScopedPageIndexEnabled(true);
    /**
    public void testProjectionOnlyFillsOffsetIndexNotColumnIndex() throws Exception {
        assertZero("delegated EQUALS: OI hits must be 0", oiHits(s));
     */
     * When the same column ({@code age}) is used in both a filter predicate and a projection,
    /**
        assertEquals(msg, expected, ciEntries(stats()));
        // refreshes ourselves so we get two distinct segments.
            + "  \"name\":{\"type\":\"keyword\"},"
        assertZero("P1 refresh: metadata", metaMemoryBytes(stats()));
import org.opensearch.client.Response;
        String[] cities = {"seattle", "portland", "denver", "austin", "boston"};
        String body = "{"
        );
 * compatible open source license.
     * Run {@code ppl} and assert that ONLY the OffsetIndex fills: OI misses > 0 and CI misses == 0.
     * from the projected output field <em>names</em>, but with expression push-down the projection
    }
        assertEquals("refresh must NOT fill CI cache", 0L, ciEntries(afterRefresh));
    }
        assertTrue("cold query must register CI misses", ciMisses(cold) > 0);
    private void recreateIndex() throws IOException {
        // CI: 1 file × city(col 3) × 1 RG = 1 entry
        }
        String ppl = "source=" + INDEX_NAME + " | where age > 90 | stats count()";
        assertOkAndParse(client().performRequest(create), "create " + indexName);
        // ── ENABLED baseline ──────────────────────────────────────────────
        JsonNode warm = stats();
        String ppl = "source=" + INDEX_NAME + " | where age > 80 | fields age | stats count()";
        // both metadata memory and CI entries must be 0 — refresh did not fill the cache.
            assertPositive("OI misses must be > 0 with 1b limit", oiMisses(s1));
            + "  \"number_of_shards\":1,\"number_of_replicas\":0,"
        health.addParameter("timeout", "30s");
            assertTrue("CI misses must increase on second run", ciMisses(s2) > ciMisses(s1));
     *   <li>The new field ({@code region}) fills the CI from the segment that carries it, even
     * </ol>
        com.fasterxml.jackson.databind.node.ObjectNode aggregate = MAPPER.createObjectNode();
     * Numeric double field predicate: {@code score > 75.0} hits the ColumnIndex because
        assertOkAndParse(client().performRequest(createReq), "merge-test: create index");
                "CI used_bytes=" + usedBytes + " must be <= size_limit_bytes=" + limit,
            + " | fields city, total, old, hi";
        client().performRequest(health);
            + "  \"number_of_shards\":1,\"number_of_replicas\":0,"
            recreateIndex();
        // page index via a different code path than the listing optimizer. Same hazard: the case()
        }
     *   recreate → clear → assertCacheEmpty
        setLuceneBlockedPredicates();
            // Result correctness: queries must return valid results regardless of eviction.
            + "}}}";
     *
    }
     * Phase 5 — DISABLED, indexed path
        assertPositive("post-merge: metadata populated from merged segment", metaMemoryBytes(postmerge));
        String ppl = "source=" + INDEX_NAME + " | fields name, score | head 100";
     * intermittently observe an empty cache simply because the request landed on a node that
            + "  \"index.pluggable.dataformat.enabled\":true,"
 * </ul>
                executePpl(pplB2);
     * Intended for projection-only queries that carry no predicate.
        executePpl(listingPpl);
        assertZero("assertOnlyOiFills: CI misses must be 0 for: " + ppl, ciMisses(s));
            + "\"mappings\":{\"properties\":{"
            executePpl(indexed);
        health.addParameter("wait_for_status", "green");
            // size_limit_bytes must reflect the configured tiny per-cache limit (% of 8b),
        clearAllCaches();
            metaMemoryBytes(p6) <= metaDisabledListing
        bulkReq.setJsonEntity(bulk.toString());
     * Phase 4 — DISABLED, listing path
            + "  \"name\":{\"type\":\"keyword\"},"
            + "  \"number_of_shards\":1,\"number_of_replicas\":0,"
            + "\"settings\":{"
        assertOnlyOiFills(ppl);
/**
        setScopedPageIndexEnabled(false);
        // After setUp(): refresh must not have filled the scoped cache.
            // Projection-only — must work correctly.
        Request bulk1 = new Request("POST", "/" + DYNAMIC_INDEX_NAME + "/_bulk");
        clearAllCaches();
        assertZero("disabled OI misses run1: " + ppl, oiMisses(s1));
    }
        // Listing path (mirrors api_metrics Q1/Q7): NO predicate, group by city, the case()
        Map<String, Object> rb1 = assertOkAndParse(client().performRequest(bulk1), "merge-test bulk1");
            bulk.append("{\"index\":{}}\n")
     *
     *
            assertTrue(
        // CI: 1 file × score(col 2) × 1 RG = 1 entry
        assertPositive("P5 disabled indexed: metadata populated", metaDisabledIndexed);
            executePpl(pplB1);
        StringBuilder arr = new StringBuilder("[");
        // Be explicit that EQUALS is delegated to Lucene (this is also the cluster default).
            assertCacheEmpty();
        assertPositive("P3 disable: metadata cache still present", metaMemoryBytes(p3));
        // miss_count, entry_count, memory_bytes) accumulate across the cluster, so they are
     *
     */
        assertCacheEmpty();
     * Set the total metadata-index cache budget to a handful of bytes so every entry is
            + " sum(case(score > 75.0, 1 else 0)) as hi by city"
        assertEquals("refresh must NOT fill metadata cache", 0L, metaMemoryBytes(afterRefresh));
            // (Index B has different file path prefix so its entries survive.)
     *   <li>Indexed path — {@code match()} routes through the Lucene-indexed executor, which wires
        assertPositive("dynamic: CI fills for new field region", ciMisses(afterRegion));
    public void testCaseAggregationOnNonProjectedColumnListingPath() throws Exception {
                s1.get("offset_index_cache").get("memory_bytes").asLong());
import com.fasterxml.jackson.databind.ObjectMapper;
    // ── listing table path ────────────────────────────────────────────────────
        } finally {
        assertEquals(indexName + " bulk errors", false, r.get("errors"));
        req.setJsonEntity("{\"persistent\":{\"datafusion.metadata_index_cache.total_size\":null}}");
    /**
        assertEquals("OI misses 0 with scoped disabled", 0L, oiMisses(s2));
    /** Restore the Lucene delegation block-list to the cluster default (null clears the override). */
        bulkReq.addParameter("refresh", "true");
    private void clearColumnCaches() throws IOException {
            + "\"settings\":{"
                    }
     * OI is keyed by (file, col) — same file+col on a repeat query is a guaranteed hit.
    public void testStringFieldFilterFillsColumnIndex() throws Exception {
        // Force-merge to a single segment — old segment entries in the scoped cache are stale.
     * Cache sized to hold exactly one index's worth of entries (tight budget).
        assertZero("assertCacheEmpty: CI entries", ciEntries(s));
        String ppl = "source=" + INDEX_NAME + " | where match(city, 'seattle') and age > 50 | stats count()";
    private JsonNode stats() throws Exception {
        assertTrue("warm query must register OI hits", oiHits(warm) > 0);
     */
        executePpl(agePpl);
        // (region = 'west') scans parquet and fills the ColumnIndex instead of being
    private void setLuceneBlockedPredicates(String... predicates) throws IOException {
        JsonNode afterAgeDrift = stats();
     * </pre>
     * Does NOT clear or assert metadata — the caller controls surrounding state.
        assertOkAndParse(client().performRequest(create), "create index");
        // The cluster-settings PUT is acknowledged only after every node has applied the update and
            + "},"
        String ppl = "source=" + INDEX_NAME + " | where match(city, 'seattle') | stats count()";
     * Phase 6 — RE-ENABLE
     * Assert that all scoped cache counters and metadata memory are zero (i.e. caches are empty).
        try {
    /**
        Request create = new Request("PUT", "/" + indexName);
    private void assertExactOiEntries(String msg, long expected) throws Exception {
        assertExactCiEntries("pre-merge: CI entries = 2 (2 files × age × rg)", 2L);
     * force-merge to one segment the pre-merge cache entries are stale; a fresh query after
        }
        assertTrue(
 * The OpenSearch Contributors require contributions made to
        assertExactOiEntries("pre-merge: OI entries = 4 (2 files × {col_0,age})", 4L);
    /**
        // budget), so it is taken as the MAX rather than summed — otherwise an N-node cluster
    private void setScopedPageIndexEnabled(boolean enabled) throws IOException {
     */
        assertCacheEmpty();
        assertCacheEmpty();
        assertTrue("indexed enabled: metadata cache populated", metaEnabled > 0);
        assertPositive("CI+OI overlap: CI misses > 0", ciMisses(cold));
     *   <li>Batch 2 → refresh (segment 2)</li>
            executePpl(pplB2);
                    .append("{\"name\":\"user").append(id)
        clearAllCaches();
    /**
 *       because page index entries are stripped and kept separately in the scoped cache.</li>
    public void testRefreshThenMergeCacheRefillsAfterMerge() throws Exception {
        assertZero("P5 CI hits", ciHits(p5));
        // ── Phase 3: DISABLE ──────────────────────────────────────────────
                    .append(",\"score\":").append(50.0 + (id % 50))
        client().performRequest(health);
        assertPositive("P1 cold: metadata populated", metaMemoryBytes(p1cold));
    private static final String INDEX_NAME = "scoped_cache_it";
        assertCacheEmpty();
    // ── string field filter (CI) ──────────────────────────────────────────────
        // ── Phase 5: DISABLED, indexed path ───────────────────────────────
                    return;
        String agePpl = "source=" + DYNAMIC_INDEX_NAME + " | where age > 50 | stats count()";
        // delegated to Lucene.
            metaDisabled >= metaEnabled
        Request health = new Request("GET", "/_cluster/health/" + INDEX_NAME);
        create.setJsonEntity(createBody);
     *   assert CI = 0, OI = 0
        // Cold query — fills both CI and OI.
        // a placeholder OffsetIndex, corrupting the page read.
        clearAllCaches();
            metaDisabled >= metaEnabled
    private void setCacheTotalSize(String size) throws IOException {
            + "  \"city\":{\"type\":\"keyword\"}"
            boolean lastBatch = batch == (DOC_COUNT / batchSize - 1);
        assertCacheHitsOnWarm(ppl);
    }
     */
        assertExactCiEntries("filter=projection: CI entries = 1 (age×file×rg)", 1L);
     * Restore the total metadata-index cache budget to the cluster default (null = derive from AC).
            metaDisabledListing >= metaEnabledListing
        JsonNode cold = stats();
        JsonNode p5 = stats();
     * parquet segment with one row group (2000 rows well under the default 1M-row row-group limit), so:
        assertPositive("P1 warm: CI hits", ciHits(stats()));
        for (int i = 0; i < 500; i++) {
    // ── refresh → merge lifecycle ─────────────────────────────────────────────
        }
            + " | where match(city, 'seattle') | stats count() as total,"
     * Projection-only query with no filter: {@code fields name, score | head 100} requires the
        String regionPpl = "source=" + DYNAMIC_INDEX_NAME + " | where region = 'west' | stats count()";
            clearAllCaches();
        // Wipe stale entries; the merged segment should not be in the cache.
    public void testFilterAndProjectionSameColumnFillsBothCaches() throws Exception {
        JsonNode s2 = stats();
                .append("{\"name\":\"user").append(i)
    /**
        assertEquals("OI hits 0 on indexed path disabled", 0L, oiHits(s2));
     * Every test that needs a clean state calls this explicitly.
        assertCacheEmpty();
    private long oiHits(JsonNode s)          { return s.get("offset_index_cache").get("hit_count").asLong(); }
            batch2.append("{\"index\":{}}\n")
            // best-effort: don't mask the test failure
        executePpl(ppl);
                    if (value != null && value.isNumber()) {
            + "  \"index.composite.primary_data_format\":\"parquet\","
    }
            bulkReq.addParameter("refresh", lastBatch ? "true" : "false");
     *   recreate → clear → assertCacheEmpty
        assertTrue("warm query must register CI hits", ciHits(warm) > 0);
    public void testListingPathColdMissThenWarmHit() throws Exception {
     * Full lifecycle covering listing + indexed paths through enabled → disabled → re-enabled:
    /** Provision a named parquet index with the same schema as the main test index. */
        // ── Phase 1: ENABLED, listing path ────────────────────────────────
        assertPositive("cold OI misses for: " + ppl, oiMisses(cold));
        clearAllCaches();
     * <ol>
            // Warm run on both — both should hit.
        executePpl(ppl);
     *
            assertTrue("OI size_limit_bytes must be tiny (<= 8) under 8b budget",
        }
            restoreLuceneBlockedPredicates();
        executePpl(ppl);
            String pplA1 = "source=" + INDEX_NAME + " | where age > 80 | stats count()";
        executePpl(ppl);
                .append(",\"city\":\"").append(cities[i % cities.length])
        assertZero("delegated EQUALS: CI entries must be 0", ciEntries(s));
                        aggGroup.put(field, combined);
        String createBody = "{"
     *   recreate → clear → assertCacheEmpty (refresh did NOT fill)
            assertEquals("OI memory_bytes must be 0", 0L,
     *   query → CI misses fill again (confirms scoped cache is back)
    /** Explicit CI clear resets hit counter; next query is a miss again. */
        executePpl(ppl);
     * {@code city} is a keyword with string min/max statistics in the parquet ColumnIndex.
     * route a {@code _local} stats request to any node. Reading a single node's stats would
                s1.get("column_index_cache").get("size_limit_bytes").asLong() <= 8L);
     *   query → assert metadata populated, CI misses > 0
    /**
            "P4 disabled listing metadata >= enabled (page index retained): enabled="
                continue;
     * optimisation, not a correctness dependency. The parquet reader falls back to
     *       expands.</li>
            restoreCacheDefaults();
                .append("{\"name\":\"user").append(i)
            String pplB2 = "source=" + INDEX_B + " | where score > 60.0 | stats count()";
        try {
    }
        assertZero("P4 CI hits", ciHits(p4));
        // Fresh query against the merged segment — must re-miss.
            // This forces eviction when both indices push entries concurrently.
                + metaEnabled + " disabled=" + metaDisabled,
        executePpl(ppl);
        assertCacheEmpty();
        assertPositive("cold CI misses for: " + ppl, ciMisses(cold));
     * <ul>
     * schema is defined — the mapping is inferred from each batch.
        recreateIndex();
        Request bulk2 = new Request("POST", "/" + INDEX_NAME + "/_bulk");
        for (int i = 0; i < 500; i++) {
 * Key invariants verified across the suite:
        String body = "{"
        req.setJsonEntity("{\"persistent\":{\"analytics.delegation.lucene.blocked_predicates\":" + arr + "}}");
        JsonNode warm = stats();
        executePpl(ppl);
     *   <li>Force-merge to 1 segment</li>
     * Listing path (numeric age predicate): refresh must NOT fill the scoped CI cache; only a
     * OI → 8×34/100 = 2 bytes — both non-zero (honored) yet far below any real entry, which is
            "P5 disabled indexed metadata >= enabled: enabled="
 *   <li>After a force-merge the pre-merge segment entries are gone; a fresh query re-misses.</li>
            b1.append("{\"index\":{}}\n")
        assertZero("P3 disable: OI entries auto-cleared", oiEntries(p3));
            JsonNode warm = stats();
                        long combined = "size_limit_bytes".equals(field)
        clearColumnCaches();
     * Asserts: OI misses > 0, CI misses == 0.
                .append(",\"city\":\"").append(cities[i % cities.length])
     */
    // ── tiny cache limits — correctness under eviction pressure ──────────────
        long hitsBefore = ciHits(stats());
        StringBuilder b1 = new StringBuilder();
     *
        }
    public void testCrossIndexCacheEntriesAreIndependent() throws Exception {
     */
        // aggregations read `age`/`score` which are not otherwise projected. Projection push-down
     *
     * Cold query fills CI with misses; warm repeat hits from cache.
    /**
            clearAllCaches();
            executePpl(indexed);
                .append("\"}\n");
     *   <li>clearAllCaches → assertCacheEmpty → query → assert CI fills across both segments</li>
            String proj = "source=" + INDEX_NAME + " | fields name, score | head 10";
    }
     * Phase 1 — ENABLED, listing path
    @Override
                }
 *   <li>Both CI and OI fill when the same column is filtered and projected.</li>
     * Delegated keyword-equality predicate produces NO scoped cache activity.
                    .append(",\"city\":\"").append(cities[id % cities.length])
        // Clear caches before measuring new-field scenario.
        long metaEnabled = metaMemoryBytes(s1);
    /**
        assertEquals("dynamic bulk2 errors", false, r2.get("errors"));
        for (int i = 0; i < DOC_COUNT; i++) {
     *
            assertEquals("OI hits must remain 0 — nothing fits in 1b cache", 0L, oiHits(s2));
            assertTrue("cross-index: CI hits must increase after warm queries on both indices",
        for (int i = 0; i < predicates.length; i++) {
        assertZero("assertCacheEmpty: OI entries", oiEntries(s));
            // used_bytes must be 0 — nothing was stored.
    /**
        assertEquals("OI misses 0 on indexed path disabled", 0L, oiMisses(s2));
        assertPositive("warm CI hits for: " + ppl, ciHits(warm));
    }
     * Cold run produces CI/OI misses; warm repeat produces hits.
        assertCacheEmpty();
        for (int i = 500; i < 1000; i++) {
        executePpl(listing); // warm: exercise the cached-OI path too
    /**
    // ── cache clear ───────────────────────────────────────────────────────────
        assertEquals(msg, expected, oiEntries(stats()));
                int id = batch * batchSize + i;
     * Call this after {@link #clearAllCaches()} to confirm the clear took effect before measuring.
            StringBuilder bulk = new StringBuilder();
        clearAllCaches();
    // ── numeric field filter (CI) ─────────────────────────────────────────────
        // OI: 2 files × {col_0(name), age(col 1)} = 4 entries
     * <p>CI key = (file, col, rg) so expectedCi = files × predicateCols × rowGroupsPerFile.
        // Here name/score are distinct keyword/double leaves (neither is col 0), so the set
        executePpl(indexedPpl);
     * <p>Queries must still return correct results — the cache is a performance
 *       from the segment that carries it, and the old-field query continues to work.</li>
        executePpl(listingPpl);
            + "  \"score\":{\"type\":\"double\"},"
            "indexed disabled metadata >= enabled (page index retained): enabled="
        String listingPpl = "source=" + INDEX_NAME + " | where age > 90 | stats count()";
        assertExactOiEntries("filter=projection: OI entries = 2 (file×{col_0(name),age})", 2L);
 *       PageIndexPolicy::Optional.</li>
            String indexed = "source=" + INDEX_NAME + " | where match(city, 'seattle') and age > 50 | stats count()";
                }
     * Phase 2 — ENABLED, indexed path  (same data, same caches still live)
        assertPositive("P1 cold: CI misses", ciMisses(p1cold));
    }
        assertZero("disabled CI hits run2: " + ppl, ciHits(s2));
        JsonNode s = stats();
                assertTrue(group + "." + field + " missing", block.has(field));
     * is present.
        // CI: 1 file × age(col 1) × 1 RG = 1 entry
        bulk1.addParameter("refresh", "true");
    private void clearAllCaches() throws IOException {
                .append("{\"name\":\"user").append(i)
        // OI: 1 merged file × {col_0(name), age(col 1)} = 2 entries (down from 4)
        // makes the scan project {city, CASE(age...), CASE(score...)} — the CASE fields are not
        // Indexed path: match() routes through the Lucene-indexed executor, which wires the scoped
            executePpl(pplA); // re-populates A
        recreateIndex();
     *
            assertEquals("bulk batch " + batch + " errors", false, r.get("errors"));
        assertEquals("OI entries 0 after auto-clear on disable", 0L, oiEntries(stats()));
        String[] cities = {"seattle", "portland", "denver", "austin", "boston"};
                executePpl(pplB1);
        }
    private long ciEntries(JsonNode s)       { return s.get("column_index_cache").get("entry_count").asLong(); }
                .append("\"}\n");
        // Warm query — hits from both CI and OI caches.
            + "  \"index.pluggable.dataformat.enabled\":true,"
        assertZero("pure Lucene count: CI entries must be 0", ciEntries(s));
        client().performRequest(req);
        assertZero("P5 OI misses", oiMisses(p5));
        long metaEnabled = metaMemoryBytes(s1);
            "P6 re-enabled metadata must be <= disabled (page index stripped): enabled="
    private void assertCacheFillsOnCold(String ppl) throws Exception {
        assertTrue("indexed cold: OI misses > 0 (predicate col + col 0)", oiMisses(cold) > 0);
        clearAllCaches();
        String indexedPpl = "source=" + INDEX_NAME + " | where match(city, 'seattle') and age > 50 | stats count()";
     * <p>Same flow as the listing test: recreate → clear → assertCacheEmpty → query → measure.
        // file columns, so the buggy name-based read-set inference dropped age/score and gave them
            + "  \"city\":{\"type\":\"keyword\"}"
        assertPositive("dynamic batch1: metadata populated", metaMemoryBytes(afterBatch1));
        } catch (Exception ignored) {
            restoreCacheDefaults();
        assertCacheEmpty();
     *
            + "  \"city\":{\"type\":\"keyword\"}"
        JsonNode p2warm = stats();
     * the per-runtime metadata cache only happens on the node that hosts that shard. The
     */
     * <p>This is the converse of {@link #testStringFieldFilterFillsColumnIndex}: with the default
            }
            + "  \"index.pluggable.dataformat.enabled\":true,"
        executePpl(ppl);
        StringBuilder bulk = new StringBuilder();
    }
    }
            executePpl(pplB);
     *   query again → assert CI hits > 0 (warm)
        assertZero("P5 OI hits", oiHits(p5));
                    client().performRequest(new Request("POST", "/" + INDEX_B + "/_refresh"));
            assertTrue("cross-index: CI entries must be >= 2 after cold queries on both indices",
     * <ul>
        client().performRequest(new Request("POST", CLEAR_ENDPOINT));
}
        // OI: 1 file × {col_0(name), age(col 1)} = 2 entries (predicate ∪ projection ∪ {col_0})
     * what the assertions want: cache activity is non-zero iff <em>some</em> node did the work,
            + "}}}";
            String pplB1 = "source=" + INDEX_B + " | where age > 60 | stats count()";
     * Indexed path: refresh must NOT fill the scoped CI/OI cache; only a query should.
        } catch (Exception e) {
     */
            throw new IOException("ScopedPageIndexCacheIT setup failed", e);
     */
 *
    }
        executePpl(listing);
        client().performRequest(health);
                    client().performRequest(new Request("POST", "/" + INDEX_NAME + "/_refresh"));
        super.tearDown();
 * this file be licensed under the Apache-2.0 license or a
     * scans the parquet file — meaning it never loads the parquet ColumnIndex. Blocking the
        clearAllCaches();
     * never ran the scan.
        create.setJsonEntity(body);
        assertZero("P4 before query: CI", ciEntries(stats()));
     */
        assertExactOiEntries("string predicate: OI entries = 2 (file×{col_0,city})", 2L);
        recreateIndex();
        bulk1.setOptions(bulk1.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
     */
     * nor OI should be populated. No parquet IO means no page-index loading.
        Request req = new Request("PUT", "/_cluster/settings");
    private long oiMisses(JsonNode s)        { return s.get("offset_index_cache").get("miss_count").asLong(); }
        health.addParameter("timeout", "30s");
            long bHitsBefore = ciHits(stats());
        assertCacheEmpty();
        Map<String, Object> rb2 = assertOkAndParse(client().performRequest(bulk2), "merge-test bulk2");
                .append(",\"score\":").append(50.0 + (i % 50))
        assertEquals("refresh must NOT fill OI cache", 0L, oiEntries(afterRefresh));
     * page-index load (which would defeat the point of delegation and waste cache budget).
        Request health = new Request("GET", "/_cluster/health/" + indexName);
        assertExactOiEntries("projection-only: OI entries = 3 (file×{col 0,name,score})", 3L);
        try { client().performRequest(new Request("DELETE", "/" + INDEX_NAME)); } catch (Exception ignored) {}
            + "\"settings\":{"
            cacheStats.fieldNames().forEachRemaining(group -> {
 *   <li>Schema-drift (new field added in a later segment) is handled: CI fills for the new field
        long p2warmHits = ciHits(p2warm) + oiHits(p2warm);
        JsonNode p2cold = stats();
        assertTrue("indexed warm: OI hits > 0", oiHits(warm) > 0);
        assertCacheHitsOnWarm(ppl);
    // ── projection-only, no filter (OI only) ─────────────────────────────────
    private long metaMemoryBytes(JsonNode s) { return s.get("metadata_cache").get("memory_bytes").asLong(); }
            executePpl(pplB); // ensure B is warm
    private long ciHits(JsonNode s)          { return s.get("column_index_cache").get("hit_count").asLong(); }
            executePpl(pplA1);
        String ppl = "source=" + INDEX_NAME + " | where age > 80 | stats count()";
            clearAllCaches();
     * Fetches DataFusion cache stats aggregated across <em>all</em> nodes in the cluster.
     * Delete, recreate, and bulk-index {@value #DOC_COUNT} documents with refresh=true.
        // match() + count(*) — Lucene satisfies this without scanning parquet pages
        health.addParameter("wait_for_status", "green");
                executePpl(pplA1);
            long usedBytes = s.get("column_index_cache").get("memory_bytes").asLong();
import org.opensearch.client.Request;
        try {
     * that column, arrow decoded the whole chunk as one page and failed with
        client().performRequest(health);
        JsonNode afterRegion = stats();
            + "  \"index.composite.secondary_data_formats\":\"lucene\""
                .append("\",\"age\":").append(i % 100)
    private void assertScopedDisabled(String ppl) throws Exception {
    public void testNumericFieldFilterFillsColumnIndex() throws Exception {
        assertZero("P4 OI misses", oiMisses(p4));
        JsonNode cold = stats();
     * <p>Guards against a regression where a delegated string predicate still triggers a parquet
 *   <li>Explicit clear resets stats so the next query is a miss again.</li>
        // CI: 1 merged file × age(col 1) × 1 RG = 1 entry (down from 2)
 * <p>Every test that needs clean measurements calls {@code recreateIndex()} (or a named variant),
        assertTrue("must have hits before clear", hitsBefore > 0);
        // OI: 1 file × {col_0(name), score(col 2)} = 2 entries
     * Phase 3 — DISABLE  (auto-clear CI/OI)
     *   assert metadata still present (not cleared by disabling)
        assertExactCiEntries("numeric predicate: CI entries = 1 (file×col×rg)", 1L);
    private static final String CLEAR_ENDPOINT = "/_plugins/_analytics_backend_datafusion/cache/_clear";
                if (groupNode == null || !groupNode.isObject()) {
        // city is a keyword field; equality would normally be delegated to Lucene and never
        // ── Phase 4: DISABLED, listing path ───────────────────────────────
        // OI: 1 file × {col_0(name), city(col 3)} = 2 entries
        assertPositive("assertOnlyOiFills: OI misses > 0 for: " + ppl, oiMisses(s));
        executePpl(ppl);
        return aggregate;
        assertTrue("enabled: CI must have activity", ciMisses(s1) + ciHits(s1) > 0);
            restoreCacheDefaults();
            JsonNode s1 = stats();
        long metaDisabled = metaMemoryBytes(s2);
    /**
     * Concurrent queries on INDEX_NAME and INDEX_B put the FIFO write lock under
     */
        assertCacheFillsOnCold(ppl);
        assertTrue(
            if (cacheStats == null) {
     *   <li>Batch 1 → refresh (segment 1)</li>
        // Query on new field region — only segment 2 carries it; CI must fill from that segment.
        assertTrue(
     *
     * shares to 0 and leave the real caches huge. We use 8 bytes instead: CI → 8×13/100 = 1 byte,
                .append("\",\"age\":").append(i % 100)
        assertExactCiEntries("projection-only: CI entries = 0 (no predicate)", 0L);
    }
            assertPositive("cross-index: B CI misses after full clear", ciMisses(stats()));
    }
        Request req = new Request("PUT", "/_cluster/settings");
            executePpl(pplA);
    public void testCacheContetionTwoIndicesOneTightBudget() throws Exception {
        assertExactCiEntries("string predicate: CI entries = 1 (file×col×rg)", 1L);
        assertExactOiEntries("numeric predicate: OI entries = 2 (file×{col_0,score})", 2L);
        JsonNode p3 = stats();
     */
     *
        assertZero("pure Lucene count: OI misses must be 0", oiMisses(s));
                JsonNode groupNode = cacheStats.get(group);
        clearAllCaches();
        Request health = new Request("GET", "/_cluster/health/" + DYNAMIC_INDEX_NAME);
            assertEquals("CI entry_count must be 0 (entries too large for 1b limit)",
                + metaEnabledListing + " disabled=" + metaDisabledIndexed,
        String listing = "source=" + INDEX_NAME
 *   <li>Enabled: CI fills on cold query (misses), hits on warm repeat. Metadata cache is smaller
            + "  \"age\":{\"type\":\"integer\"},"
     *   <li>The first batch's field ({@code age}) can still be queried correctly after the schema
            // All accesses are misses since nothing is ever cached.
        // CI: 2 files × age(col 1) × 1 RG each = 2 entries
        assertEquals("OI entries 0 after auto-clear on disable", 0L, oiEntries(stats()));
        bulkReq.setOptions(bulkReq.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        }
        client().performRequest(new Request("POST", CLEAR_ENDPOINT + "?column=true"));
        StringBuilder batch2 = new StringBuilder();
    public void testPureLuceneCountQueryProducesNoCacheActivity() throws Exception {
 * then {@code clearAllCaches()}, then {@code assertCacheEmpty()} before measuring. This ensures
        // ── ENABLED baseline ──────────────────────────────────────────────
    public void testFullLifecycleEnabledDisabledReenabled() throws Exception {
        }
        bulk2.addParameter("refresh", "true");
 */
 */
            for (int i = 0; i < 3; i++) {
    private void assertZero(String msg, long v)     { assertEquals(msg + " must be 0, got " + v, 0L, v); }
            + "},"
    protected boolean preserveClusterUponCompletion() {
        try { client().performRequest(new Request("DELETE", "/" + INDEX_B)); } catch (Exception ignored) {}
        assertPositive("pre-merge: OI misses across both segments", oiMisses(premerge));
     * integer truncation, and the native limit setters IGNORE a zero limit (treating it as
        assertEquals("merge-test bulk2 errors", false, rb2.get("errors"));
            assertTrue("CI size_limit_bytes must be tiny (<= 8) under 8b budget",
    /**
        assertTrue("enabled: metadata cache populated by query", metaEnabled > 0);
        assertPositive("dynamic batch1: CI fills for age", ciMisses(afterBatch1));
        executePpl(ppl);
        String[] cities = {"seattle", "portland", "denver", "austin", "boston"};
        assertCacheEmpty();
        }
            // Interleave queries on both indices — drives concurrent cache inserts + evictions.
 *   <li>Toggle-off clears CI/OI caches immediately; metadata cache is unaffected.</li>
        setScopedPageIndexEnabled(true);
     * OI key = (file, col) so expectedOi = files × projectionCols.
 *
            + "  \"index.pluggable.dataformat\":\"composite\","
     *   <li>clearAllCaches → assertCacheEmpty (old entries gone)</li>
        arr.append(']');
                .append("\"}\n");
     *   <li>Query → CI misses > 0 (merged segment is a fresh miss)</li>
        assertPositive("post-merge: OI misses > 0 (forced re-miss after merge)", oiMisses(postmerge));
        executePpl(ppl);
     * exactly the "reject everything" regime this test needs.
                });
        JsonNode s = stats();
        StringBuilder batch1 = new StringBuilder();
            assertPositive("CI misses must be > 0 with 1b limit", ciMisses(s1));
     * </ul>
        clearAllCaches();
        assertPositive("dynamic: age CI still fills after schema drift", ciMisses(afterAgeDrift));
            clearAllCaches();
        // The predicate went to Lucene; parquet pages were never read.
     * the cache-limit consumer, so the large default scoped limits are live again on return.
     * {@code executePpl} asserts HTTP 200, so a decompression failure fails the test.
     * inserting B's entries forces eviction of A's (or vice versa) — exercising the
        fm.addParameter("max_num_segments", "1");
     * (different file paths → different cache keys). Entries from one index
     * so the parquet scan that fills the scoped CI/OI caches (process-global per JVM) and
            executePpl(pplA);
     * <p>To make the measurements deterministic we query the cluster-wide stats endpoint
import com.fasterxml.jackson.databind.JsonNode;
     * Two parquet indices share the same process-global CI/OI caches.
        provisionNamedIndex(INDEX_B);
    /**
        executePpl("source=" + INDEX_NAME + " | where age > 50 | stats count()");
    public void testCaseAggregationOnNonProjectedColumnIndexedPath() throws Exception {
     * Each query groups by one column while a {@code case()} reads a different, non-projected one;
     * so the ColumnIndex should NOT be consulted at all.
            Request bulkReq = new Request("POST", "/" + INDEX_NAME + "/_bulk");
     * Run {@code ppl} a second time (cache already warm) and assert that both CI and OI hit.
        assertZero("delegated EQUALS: CI hits must be 0", ciHits(s));
     * contention while eviction fires. After all queries:
        assertPositive("cold metadata populated for: " + ppl, metaMemoryBytes(cold));
    }
     *   match() query → CI/OI misses or hits recorded (cumulative)
        try {
        JsonNode p6 = stats();
            JsonNode cold = stats();
        for (JsonNode node : nodes) {
        recreateIndex();
        assertEquals("refresh must NOT fill metadata cache", 0L, metaMemoryBytes(afterRefresh));
        Request health = new Request("GET", "/_cluster/health/" + INDEX_NAME);
        // touch parquet. Block EQUALS so the predicate scans parquet and fills the ColumnIndex.
                bulk.append("{\"index\":{}}\n")
     * initialized when setUp() runs (see existing IT comments in this package).
    }
    private static final String INDEX_B = "scoped_cache_it_b";
import java.util.Map;
        Request req = new Request("PUT", "/_cluster/settings");
        // Cold listing query.
                s1.get("column_index_cache").get("memory_bytes").asLong());
        assertOkAndParse(client().performRequest(create), "create dynamic index");
    }
        // Batch 2: adds NEW field region to every doc → creates segment 2 with schema drift.
        client().performRequest(req);
    }
    /**
            String pplB = "source=" + INDEX_B + " | where score > 75.0 | stats count()";
    public void testQueriesCorrectWithTinyCacheLimits() throws Exception {
    }
            assertEquals("CI memory_bytes must be 0", 0L,
     * must not corrupt or evict entries from the other if the cache is sized
        clearAllCaches();
     * inside the test body lifecycle where {@link #client()} is guaranteed non-null.
            try { client().performRequest(new Request("DELETE", "/" + INDEX_B)); } catch (Exception ignored) {}
     * contains computed fields like {@code CASE WHEN status = 200 ...} whose names are not file
     */
     * delegation block-list (EQUALS is NOT blocked), {@code city = 'seattle'} on a keyword field is
        // Batch 1 → refresh → segment 1.
     */
     *   recreate → clear → assertCacheEmpty
     * produces OI misses in addition to CI misses — even if no explicit {@code fields} clause
        setScopedPageIndexEnabled(false);
     * </ul>
     * and {@code clearAllCaches()} broadcasts to every node so cleared sums are zero everywhere.
     * Lucene's inverted index without touching the parquet files, so neither CI
            for (int i = 0; i < batchSize; i++) {
    private void restoreLuceneBlockedPredicates() throws IOException {
     * default, so a predicate like {@code city = 'seattle'} is answered by Lucene and never
        assertZero("delegated EQUALS: OI misses must be 0", oiMisses(s));
                .append("\",\"age\":").append(i % 100)
        } finally {
            setCacheTotalSize("2kb");
        // ── Phase 6: RE-ENABLE ────────────────────────────────────────────
    private void assertCacheEmpty() throws Exception {
    /**
    }
                groupNode.fieldNames().forEachRemaining(field -> {
        Map<String, Object> r = assertOkAndParse(client().performRequest(bulkReq), "bulk " + indexName);
            + "},"
        JsonNode root = MAPPER.readTree(EntityUtils.toString(response.getEntity()));
        executePpl(indexedPpl);
    public void testStatsShapeHasBothCacheGroups() throws Exception {
        bulk2.addParameter("refresh", "true");
     * <p>The test cluster runs with multiple nodes but the test index has a single shard,
        clearAllCaches();
            + " | fields city, total, old_rate";
    }
        assertEquals("CI misses 0 with scoped disabled", 0L, ciMisses(s2));
     * <p>String fields (keyword/text) route their predicates to Lucene's inverted index by
        // 8b → CI limit 1b, OI limit 2b: tiny but non-zero, so every entry is larger and rejected.
                    : aggregate.putObject(group);
            executePpl(listing);
     *   assert CI entries = 0, OI entries = 0 immediately
     * Schema-drift scenario: a new field ({@code region}) is added in a second batch after the
    /**
        assertZero("P4 before query: OI", oiEntries(stats()));
     * Force-merge lifecycle: two separate refresh cycles produce two segments. After a
        return true;
        JsonNode cold = stats();
        executePpl(ppl);
        assertZero("pure Lucene count: OI entries must be 0", oiEntries(s));
            }
                0L, oiEntries(s1));
     * number of segments.
    private static final String DYNAMIC_INDEX_NAME = "scoped_cache_dynamic_it";
        // Metadata is footer-only again (smaller than disabled).
    /**
        assertEquals("dynamic bulk1 errors", false, r1.get("errors"));
        clearAllCaches();
            arr.append('"').append(predicates[i]).append('"');
     * </ul>
    }
        clearAllCaches();
            // Re-run all queries — they must not error even if the cache is empty.
    // ── full enabled → disabled lifecycle loop ────────────────────────────────
        // Warm query — same query hits from both CI and OI caches.
            + "  \"index.pluggable.dataformat\":\"composite\","
        executePpl(ppl);
        try { client().performRequest(new Request("DELETE", "/" + DYNAMIC_INDEX_NAME)); } catch (Exception ignored) {}
        bulk1.setJsonEntity(batch1.toString());
            + "  \"index.composite.secondary_data_formats\":\"lucene\""
     * Assert exact entry count with an informative message.
                .append(",\"score\":").append(50.0 + (i % 50))
        assertCacheEmpty();
     * caches therefore live on one specific node, while the round-robin REST client may
    // ── pure Lucene path (no parquet scan) ───────────────────────────────────
     * to hold both comfortably.
     * predicate (e.g. {@code EQUALS}) forces the planner to leave it on the DataFusion/parquet
     * "provided output is too small for the decompressed data" (HTTP 500).
        clearAllCaches();
     */
        executePpl(ppl);
            // B's entries are fresh misses after the clear — that's expected and correct.
            // Cold run on both indices.
        assertZero("P1 refresh: CI entries", ciEntries(stats()));
                + metaEnabledListing + " disabled=" + metaDisabledListing,
            + "  \"score\":{\"type\":\"double\"},"
        executePpl(indexedPpl);
            + "  \"name\":{\"type\":\"keyword\"},"
    /**
        bulk1.addParameter("refresh", "true");
        String[] regions = {"west", "east", "central"};
        int batchSize = 500;
        assertTrue("cache_stats block missing on every node", aggregate.size() > 0);
                .append("{\"name\":\"user").append(i)
     * The cluster-settings PUT is acknowledged only after every node has applied the update and run
        );
        assertZero("pure Lucene count: OI hits must be 0", oiHits(s));
 * <p>The cache is governed by the {@code datafusion.scoped_page_index.enabled} cluster setting.
     * group-by/projection list must still scan that column correctly.
     * Uses a dedicated index ({@value #DYNAMIC_INDEX_NAME}) with dynamic mapping so no explicit
        assertCacheEmpty();
        client().performRequest(req);
        // ── DISABLED ─────────────────────────────────────────────────────
        JsonNode s2 = stats();
        assertZero("delegated EQUALS: CI misses must be 0", ciMisses(s));
                            : prev + value.asLong();
                    .append("\"}\n");
            + " | eval old_rate = round(old * 100.0 / total, 2)"
     *
        assertCacheEmpty();
        assertTrue("disabled: metadata cache populated by query", metaDisabled > 0);
        client().performRequest(req);
     */
        JsonNode p4 = stats();
                .append("\",\"age\":").append(i % 100)
            // Correctness: cache must never exceed its limit.
        bulk1.setOptions(bulk1.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
            Map<String, Object> r = assertOkAndParse(client().performRequest(bulkReq), "bulk batch " + batch);
            // Entries must be 0 — entries are too large to fit, so nothing is stored.
     * the query must consult both the ColumnIndex (predicate push-down) and the OffsetIndex
     * parquet footer, always ≥ tens of bytes; OI entry size = offset_index_length, likewise).
                executePpl(pplA2);
        // page-skip metric always reads col 0, so it is included even when not projected.
     * query should. Cold run produces CI misses; warm repeat produces CI hits.
        // ── DISABLED ─────────────────────────────────────────────────────
        Request req = new Request("PUT", "/_cluster/settings");
                ciHits(warm) > hitsBefore);
            clearAllCaches();
        clearAllCaches();
     * Aggregation whose {@code case(...)} expression reads a column that is NOT in the
     * {@code match(city, 'seattle') | stats count()} can be satisfied entirely by
            }
     * </ol>
        assertZero("pure Lucene count: CI hits must be 0", ciHits(s));
        createReq.setJsonEntity(createBody);
                .append("\"}\n");
     *
    public void testIndexedPathColdMissThenWarmHit() throws Exception {
    }
            executePpl(listing);
        String ppl = "source=" + INDEX_NAME + " | where score > 75.0 | stats count()";
        String[] cities = {"seattle", "portland", "denver", "austin", "boston"};
        executePpl(ppl);
            + "  \"index.pluggable.dataformat.enabled\":true,"
        for (String group : new String[]{"column_index_cache", "offset_index_cache"}) {
    /**
    }
            // small enough that no entry can ever fit.
     * out of the scoped OffsetIndex and got a single-page placeholder. When the scan actually read
    @Override
     * Queries on INDEX_NAME and INDEX_B accumulate independent entries
    public void testDynamicMappingNewFieldInSecondSegmentFillsCI() throws Exception {
            b2.append("{\"index\":{}}\n")
        assertCacheEmpty();
     * answered by Lucene's inverted index. The parquet file is never scanned for that predicate, so
        assertZero("P4 before query: metadata", metaMemoryBytes(stats()));
     *
        assertZero("P5 CI misses", ciMisses(p5));
    public void testClearColumnIndexResetsToMiss() throws Exception {
     * FIFO drain path under concurrent inserts.
     *   <li>1 predicate col → CI entries = 1</li>
        // region/city are keyword fields; block EQUALS so the keyword-equality predicate
        clearAllCaches();
     * Run {@code ppl} twice with scoped disabled (CI/OI = 0 each time).
        String ppl = "source=" + INDEX_NAME + " | where match(city, 'seattle') and age > 50 | stats count()";
        clearAllCaches();
        executePpl(agePpl);
        assertZero("assertCacheEmpty: metadata memory", metaMemoryBytes(s));
        assertEquals("CI hits 0 with scoped disabled", 0L, ciHits(s2));
            assertNotNull(group + " block missing", block);
        assertPositive("pre-merge: metadata populated", metaMemoryBytes(premerge));
     * <p>OI is built for {@code predicate ∪ projection ∪ {col 0}}, so any predicate query
        String ppl = "source=" + INDEX_NAME + " | where age > 90 | stats count()";
            // Indexed path — must also work correctly with evicted cache.
        assertPositive("P4 disabled listing: metadata populated", metaDisabledListing);
        } finally {
        // The old-field age query must still work correctly after schema drift.
        setScopedPageIndexEnabled(true);
     *       the scoped page index via a different code path ({@code collect_plan_column_names}).</li>
        assertPositive("CI+OI overlap: metadata populated", metaMemoryBytes(cold));
        recreateIndex();
     *   <li>Both indices must still return correct query results (cache is optional).</li>
        assertPositive("CI+OI overlap: OI misses > 0", oiMisses(cold));
     * <p>This exercises the FIFO write lock under real concurrent key diversity.
    // ── stat accessor shorthands ──────────────────────────────────────────────
        executePpl(regionPpl);
    /**
        executePpl(ppl);
 * Integration tests for the scoped page-index cache (ColumnIndex + OffsetIndex).
        assertEquals("CI entries 0 after auto-clear on disable", 0L, ciEntries(stats()));
            executePpl(lucene);
     * backend, which is what fills the scoped ColumnIndex cache. Pass an empty list to clear.
        JsonNode postmerge = stats();
        create.setJsonEntity(body);
                // Interleave refreshes to create new segments.
        JsonNode s = stats();
            bulkReq.setOptions(bulkReq.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
        executePpl(ppl);
        JsonNode afterRefresh = stats();
     * Using {@code setUp()} is unsafe here because {@code client()} may not yet be
     *   match() query again → hits increase
        // SUMMED. size_limit_bytes is a per-node capacity (every node configures the same
        Request req = new Request("PUT", "/_cluster/settings");
    private void assertExactCiEntries(String msg, long expected) throws Exception {
    @SuppressWarnings("unused")
            executePpl(pplB);
                s1.get("offset_index_cache").get("size_limit_bytes").asLong() <= 8L);
     *       though the first segment has no such column.</li>
                .append(",\"city\":\"").append(cities[i % cities.length])
        // Refresh must NOT fill the scoped cache.
     * Cold query fills CI with misses; warm repeat hits from cache.
     * assertCacheEmpty() → query → measure.
            }
    private static final int DOC_COUNT = 2000;
     *   match() query → metadata larger than enabled, CI = 0, OI = 0
     * guaranteed to be rejected on insert (CI entry size = column_index_length bytes from the
            String pplA = "source=" + INDEX_NAME + " | where age > 80 | stats count()";
    }
        // Batch 1: fields name, age, city — creates segment 1.
        // would report N× the configured limit.
     *   query → assert metadata populated AND larger than enabled baseline
     * <p>The budget is set to approximately the size of CI entries for one index so
     * (column projection). Both CI and OI should accumulate misses on the cold run.
     */
    }
            // Set a tight budget: ~500 bytes — enough for a handful of entries but not all.
            // Listing path predicate — misses every time, never gets cached.
            + "  \"age\":{\"type\":\"integer\"},"
            for (String field : new String[]{"hit_count", "miss_count", "entry_count", "memory_bytes", "size_limit_bytes", "hit_rate"}) {
     * Indexed path disabled: CI/OI = 0, metadata cache larger than enabled baseline.
        executePpl(listingPpl);
        Request create = new Request("PUT", "/" + INDEX_NAME);
            assertCacheEmpty();
            JsonNode s2 = stats();
        req.setJsonEntity("{\"persistent\":{\"datafusion.metadata_index_cache.total_size\":\"" + size + "\"}}");
     * {@code score} carries numeric min/max statistics in the parquet ColumnIndex.
     * clearing must re-miss against the merged segment.
        clearAllCaches();
        JsonNode p1cold = stats();
        setScopedPageIndexEnabled(true);
            executePpl(proj);
     * <p>Flow:
        StringBuilder b2 = new StringBuilder();
        assertEquals("CI misses 0 on indexed path disabled", 0L, ciMisses(s2));
        assertPositive("P6 re-enabled: CI misses (scoped cache back)", ciMisses(p6));
     * Run {@code ppl} cold (caches assumed empty by caller) and assert that both CI and OI fill.
        String ppl = "source=" + INDEX_NAME + " | where age > 90 | stats count()";
    }
            + " | stats count() as total, sum(case(age > 50, 1 else 0)) as old,"
    }
    // ── low-level assertion utilities ─────────────────────────────────────────
            );
        setLuceneBlockedPredicates("EQUALS");
        executePpl(ppl);
        Request bulk2 = new Request("POST", "/" + DYNAMIC_INDEX_NAME + "/_bulk");
     *   <li>used_bytes must not exceed the limit (correctness under eviction).</li>
        assertTrue("indexed cold: metadata cache populated by query", metaMemoryBytes(cold) > 0);
        JsonNode warm = stats();
        JsonNode s1 = stats();
    }
            long hitsBefore = ciHits(cold);
            executePpl(pplA2);
                        long prev = aggGroup.path(field).asLong(0L);
    @Override
    }
            + "\"mappings\":{\"properties\":{"
    private static final ObjectMapper MAPPER = new ObjectMapper();
                .append("\",\"age\":").append(i % 100)
        // object with the same shape the accessor helpers expect. Counters (hit_count,
        req.setJsonEntity("{\"persistent\":{\"analytics.delegation.lucene.blocked_predicates\":null}}");
        // Metadata cache is unaffected by the toggle.
        for (int i = 500; i < 1000; i++) {
        health.addParameter("timeout", "30s");
            // Simulate an eviction for INDEX_NAME by clearing all and re-running only B.
        recreateIndex();
        // Create index with dynamic mapping (no explicit properties) and composite parquet format.
     *
                .append(",\"score\":").append(50.0 + (i % 50))
        assertPositive("P6 re-enabled: metadata populated", metaMemoryBytes(p6));
     *   <li>Cache stats must be internally consistent (no phantom entries).</li>
        assertZero("P1 refresh: OI entries", oiEntries(stats()));
     * <p>Flow per mode: delete → create → index → refresh → clearAllCaches() →
     * neither the ColumnIndex nor the OffsetIndex scoped cache should record any hit, miss, or entry.
        assertPositive("post-merge: CI misses > 0 (forced re-miss after merge)", ciMisses(postmerge));
                0L, ciEntries(s1));
        setScopedPageIndexEnabled(true);
        assertPositive("P2 cold indexed: CI/OI activity", p2coldActivity);
        long metaDisabled = metaMemoryBytes(s2);
        JsonNode premerge = stats();
        assertExactCiEntries("post-merge: CI entries = 1 (1 merged file × age × rg)", 1L);
        // Batch 2 → refresh → segment 2.
import java.io.IOException;
            + "  \"score\":{\"type\":\"double\"},"
     * columns. The base column the CASE reads ({@code age}/{@code score} here) was therefore left
     * Per-test setup via {@link AnalyticsRestTestCase#onBeforeQuery()} — this fires
        String ppl = "source=" + INDEX_NAME + " | where city = 'seattle' | stats count()";
    /** Set the total metadata-index cache budget (e.g. {@code "100b"}, {@code "500mb"}). */
        JsonNode s1 = stats();
            JsonNode s = stats();
            // Total CI entries = 2 (one per index, different file paths).
            String pplA2 = "source=" + INDEX_NAME + " | where score > 75.0 | stats count()";
        }
            + "  \"index.composite.primary_data_format\":\"parquet\","
            new Request("GET", "/_plugins/_analytics_backend_datafusion/stats")
        // Start with a clean index that has NO data yet — we will drive two separate
        String createBody = "{"
        setScopedPageIndexEnabled(false);
        assertZero("P6 before query: metadata", metaMemoryBytes(stats()));
        for (int batch = 0; batch < DOC_COUNT / batchSize; batch++) {
    private void assertCacheHitsOnWarm(String ppl) throws Exception {
        assertPositive("dynamic: metadata populated after region query", metaMemoryBytes(afterRegion));
    }
        }
    private void restoreCacheDefaults() throws IOException {
        // Combine each cache group's fields across all nodes into a synthetic cache_stats
    /**
    // ── dynamic mapping — new field in second segment ─────────────────────────
     */
        }
        bulk2.setOptions(bulk2.getOptions().toBuilder().addHeader("Content-Type", "application/x-ndjson").build());
                    JsonNode value = groupNode.get(field);
        executePpl(indexed);
     *
        recreateIndex();
            JsonNode cacheStats = node.get("cache_stats");
        assertPositive("P2 warm indexed: CI or OI hits", p2warmHits);
        setCacheTotalSize("8b");
        req.setJsonEntity("{\"persistent\":{\"datafusion.scoped_page_index.enabled\":" + enabled + "}}");
            bulkReq.setJsonEntity(bulk.toString());
        executePpl(ppl);
    /**
 *   <li>Disabled: CI/OI stats = 0. Metadata cache is larger because page index is retained via
            + " sum(case(age > 50, 1 else 0)) as old, sum(case(score > 75.0, 1 else 0)) as hi by city"
        bulk2.setJsonEntity(batch2.toString());
                .append("\",\"region\":\"").append(regions[i % regions.length])
    public void testIndexedPathDisabledMetadataCacheLarger() throws Exception {
     * miss, {@code used_bytes} stays 0, {@code entry_count} stays 0.
                .append(",\"city\":\"").append(cities[i % cities.length])
     *
        Request bulkReq = new Request("POST", "/" + indexName + "/_bulk");
    /**
        health.addParameter("wait_for_status", "green");
        JsonNode nodes = root.get("nodes");
        long metaDisabledIndexed = metaMemoryBytes(p5);
        );
            + "  \"index.composite.secondary_data_formats\":\"lucene\""
            // Clearing index A's entries via prefix eviction must not affect index B.
    /**
            // Pure Lucene count — must still work (does not touch CI/OI at all).
        assertEquals("merge-test bulk1 errors", false, rb1.get("errors"));
    }
        Map<String, Object> r2 = assertOkAndParse(client().performRequest(bulk2), "dynamic bulk2");
                    ? (com.fasterxml.jackson.databind.node.ObjectNode) aggregate.get(group)
        assertZero("P6 before query: CI", ciEntries(stats()));
        }
        // OI key = (file, col); the column set is {col 0} ∪ predicate ∪ projection. The
        // After recreateIndex() + clearAllCaches() in setUp():
     * <pre>
     * <p>Two variants exercise both factory-install paths:
        clearAllCaches();
                com.fasterxml.jackson.databind.node.ObjectNode aggGroup = aggregate.has(group)
                .append("{\"name\":\"user").append(i)
        assertTrue("indexed disabled: metadata cache populated", metaDisabled > 0);
        assertZero("P5 before query: metadata", metaMemoryBytes(stats()));
 *   <li>OI fills on projection-only queries; CI does NOT fill when there is no predicate.</li>
    /**
            "disabled metadata >= enabled (page index retained): enabled="
        // Cold query — must fill CI and OI (misses) and populate metadata cache.
    // ── index lifecycle helpers ───────────────────────────────────────────────
    }
     * Listing path disabled: CI/OI = 0, metadata cache larger than enabled baseline.
        // Warm listing query.
     * <p>Regression test for a scoped-OffsetIndex bug: the optimizer derived the scan's read set
        // Clear caches then verify query fills CI across both segments.
        assertZero("P4 OI hits", oiHits(p4));
        assertTrue("indexed warm: CI hits > 0", ciHits(warm) > 0);
                ciAfterBoth >= 2);
        JsonNode cold = stats();
        Response response = client().performRequest(
        assertEquals("OI hits 0 with scoped disabled", 0L, oiHits(s2));
            JsonNode block = s.get(group);
        try {
        executePpl(ppl);
     *
    // ── stats shape ───────────────────────────────────────────────────────────
        JsonNode s2 = stats();
            clearAllCaches();
        assertZero("disabled OI hits run2: " + ppl, oiHits(s2));
import org.apache.hc.core5.http.io.entity.EntityUtils;
        assertZero("pure Lucene count: CI misses must be 0", ciMisses(s));
        );
    public void testListingPathDisabledMetadataCacheLarger() throws Exception {
            });
            try { client().performRequest(new Request("DELETE", "/" + INDEX_B)); } catch (Exception ignored) {}
        assertTrue(
