    }
        // analytics-engine route already handles via the replace onboarding.
            17  
 */
        // all become X. This differs from traditional sed where `s/E/X/` (no /g) is
        // y/AEIOU/aeiou/ → "oFFiCe SuPPLieS"
        // /g flag — replace EVERY occurrence in each row.
    }
            "source=" + DATASET.indexName
        Object cell = rows.get(0).get(0);
 *   <li>Rex extract mode ({@code rex field=f "(?<g>...)"}) — uses the SQL plugin's custom
    }
                + " | fields str1, initial | head 1",
        // offset_field=positions emits a "name=start-end&..." string. For  
 *
                + " | where str1='CLAMP ON LAMPS'"  
                + " | where str1='BINDER ACCESSORIES'"  
        Map<String, Object> response = executePpl(
        );
    public void testRexExtractMultiCapturesAll() throws IOException {  
    // ── extract mode (Rust UDFs: rex_extract / rex_extract_multi / rex_offset) ──
            row("BINDER", "ACCESSORIES")
        for (int i = 0; i < expected.length; i++) {
        assertEquals("expected list of 2 words", List.of("BUSINESS", "ENVELOPES"), cell);  
            row("CLAMP ON LAMPS", "C")  
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
        return Arrays.asList(values);  
    }
        }
    public void testRexSedReplaceGlobalCaseInsensitive() throws IOException {
        // No-flag sed (`s/E/X/`) lowers to Calcite REGEXP_REPLACE_3, whose contract is
                + " | where str0='SUPPLIES OFFICE' | fields str0",  
 * SPDX-License-Identifier: Apache-2.0
        );
        );  
        Map<String, Object> response = executePpl(
                + " | fields str1",
                got.size()
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
        @SuppressWarnings("unchecked")  
    }
 *   <li>{@code rex field=f mode=sed "s/old/new/g"} or {@code "/i"} or {@code "/gi"} — emits
 * Self-contained integration test for the PPL {@code rex} command's {@code mode=sed} surface
        @SuppressWarnings("unchecked")
                + " | fields str1, d | head 1",
/**
        assertRows(  
    public void testRexExtractMissingGroupReturnsNull() throws IOException {  
        // bridge if it ever wants to match traditional sed exactly.
                + " | fields str1, digit | head 1",
        // So second=7-17. Names are sorted alphabetically: first then second.  
 *       {@code REGEXP_REPLACE_5}, which DataFusion's native {@code regexp_replace} does not
        // Pattern is lowercase but field values are uppercase — /i makes it match.
 *       {@code SqlLibraryOperators.REGEXP_REPLACE_PG_4} → DataFusion's 4-arg
            "source=" + DATASET.indexName
                "Column count mismatch at row " + i + " for query: " + ppl,
    // ── transliteration y/from/to/ (TRANSLATE3 — new bridge) ──────────────────
        assertRows(
        assertRows(  
        // pattern where /gi differs from /g to actually exercise the case-insensitivity.)
                + " | rex field=str1 \"(?<first>[A-Z]+) (?<second>[A-Z]+)\""  
        assertNotNull("rows missing", rows);  
                + " | where str0='FURN' | fields str0",  
 * this file be licensed under the Apache-2.0 license or a
        // replaces every match, not just the first). "BINDER ACCESSORIES" has 3 E's;
            row("BINDXR ACCXSSORIXS")  
        // (none needed here — user-typed regex) AND replacement-side $N → ${N} brace
        assertEquals("expected 1 row", 1, rows.size());
        // Replace literal "SUPPLIES" → "STUFF" in str0. 6 rows have "OFFICE SUPPLIES"; each
 * <p><b>NOT covered by this PR (Part 1):</b>  
    public void testRexSedReplaceNoFlagIsGlobal() throws IOException {
                + " | fields word | head 1"
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
                + " | where str1='BINDER ACCESSORIES'"
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}  
            row("first=0-5&second=7-17")  
    }
        // has 2 words; the rust UDF returns a list<varchar> of size 2.
            "source=" + DATASET.indexName
        // "BINDER ACCESSORIES" has 3 E's, all become X.  
 *       have no native DataFusion equivalent. Slated for a follow-up PR (Part 2) that adds
                + " | fields word | head 1"
        // word fragments matching. 'CORDED KEYBOARDS' actually only has 2 words —
 *       {@code SqlLibraryOperators.TRANSLATE3} → DataFusion's {@code translate} UDF. New in
        // (Note: same result as /g here because all E's are already uppercase. Use a
        // use 'DOT MATRIX PRINTERS' (3 words) to test the cap meaningfully.  
                    want.get(j),  
        // Let me reverify: B(0)I(1)N(2)D(3)E(4)R(5) (6)A(7)C(8)C(9)E(10)S(11)S(12)O(13)R(14)I(15)E(16)S(17).
    private static boolean dataProvisioned = false;
        );
    }  
            for (int j = 0; j < want.size(); j++) {  
                + " | where str1='BINDER ACCESSORIES'"
    public void testRexExtractMultipleNamedGroups() throws IOException {
        // Pattern matches nothing — all rows pass through with str0 unchanged.  
 *
import java.util.Arrays;  
        Map<String, Object> response = executePpl(ppl);
            );
                + " | rex field=str0 mode=sed \"s/SUPPLIES/STUFF/\""
    protected void onBeforeQuery() throws IOException {
    public void testRexExtractNoMatchPassesThroughAsNull() throws IOException {
    // ── helpers ────────────────────────────────────────────────────────────────  
 * <ul>
import java.util.List;
                + " | fields str0 | head 1",
                + " | where str1='ERICSSON'"
            "source=" + DATASET.indexName
        // Pattern matches but the named group never participates → NULL column.
 * repository — the part that lowers to standard Calcite library operators and bridges through  
    // ── no-match passthrough ──────────────────────────────────────────────────  
        // first-occurrence-only — that semantic is the SQL plugin's responsibility to  
            DatasetProvisioner.provision(client(), DATASET);  
            "source=" + DATASET.indexName
            dataProvisioned = true;
                + " | rex field=str1 \"(?<first>[A-Z]+) (?<second>[A-Z]+)\" offset_field=positions"
                want.size(),  
        // Two named groups in one pattern — the SQL plugin's visitor emits one
        // 17 calcs rows total.
        );
        // rows have str1 values that ALL start with an uppercase letter, so the
        // y/AEIOU/aeiou/ — lowercase the uppercase vowels in str0.
 *       this PR.</li>  
        assertNotNull("rows missing", rows);  
                + " | where str1='CLAMP ON LAMPS'"
        assertRowCount(
    @SuppressWarnings("varargs")  
    // ── sed mode with /gi combined flags ──────────────────────────────────────
    public void testRexSedReplaceGlobal() throws IOException {
            List<Object> got = actualRows.get(i);  
            "source=" + DATASET.indexName  
                + " | fields str1",
        // max_match=0 (unbounded) — extract every word from str1. 'BUSINESS ENVELOPES'
 *       support (max 4 args). Also Part 2 territory.</li>
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
                + " | rex field=str1 mode=sed \"s/E/X/\""
                + " | rex field=str0 mode=sed \"s/NOSUCHVALUE/X/\""
            row("BINDXR ACCXSSORIXS")
 * keeps it across test methods.
        );  
    }  
        // capture group always matches.  
        assertEquals("Row count mismatch for query: " + ppl, expectedCount, actualRows.size());
            List<Object> want = expected[i];
 * Substrait to DataFusion's native UDFs:
        // 'BINDER ACCESSORIES' with pattern (?<first>[A-Z]+) (?<second>[A-Z]+):
                assertEquals(
        @SuppressWarnings("unchecked")
            "source=" + DATASET.indexName  
        // characters not in the `from` set (they pass through unchanged).  
                + " | rex field=str0 mode=sed \"y/AEIOU/aeiou/\""
        assertRows(  
        );  
package org.opensearch.analytics.qa;
        assertEquals("max_match=2 should cap at 2 elements", List.of("DOT", "MATRIX"), rows.get(0).get(0));
 * compatible open source license.
    // ── sed mode with /i flag (REGEXP_REPLACE_PG_4 — case-insensitive) ─────────
                + " | where str1='BINDER ACCESSORIES'"
 *   <li>{@code rex field=f mode=sed "y/from/to/"} (transliteration) — emits
import org.opensearch.client.Response;  
        //   first matches at 0-5 (6 chars: 'BINDER') → offset "first=0-5"
        );
            "source=" + DATASET.indexName
 * <ul>  
    }
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());  
                + " | where str1='DOT MATRIX PRINTERS'"  
    }
        // max_match=2 caps the result at 2 even though 'CORDED KEYBOARDS' has more
 *       {@code regexp_replace}. Already wired by the PPL {@code replace} onboarding (#21527).</li>  
 *       {@code regexp_replace} with a flags string. New in this PR.</li>  
                + " | rex field=str1 \"(?<d>\\d+)\""  
            row("CLAMP ON LAMPS", null)
 *       Rust-side UDF implementations, similar to the {@code convert_tz} precedent.</li>
            row("FuRNiTuRe")  
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
    public void testRexExtractMultiBoundedByMaxMatch() throws IOException {  
        );  
        // Apply transliteration on a uniform field — verify it doesn't crash on
            }  
    @SafeVarargs
        // Rust UDF twice (once per output column). Verifies the planner's
                + " | rex field=str1 \"(?<word>[A-Z]+)\" max_match=2"
 * <p>Mirrors a subset of {@code CalciteRexCommandIT} from the {@code opensearch-project/sql}
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");  
        );  
    }
        // "OFFICE SUPPLIES" has no AEIOU lowercased, but uppercase OFFICE has O,I,E etc.
                + " | rex field=str1 \"(?<digit>\\d+)\""  
        // Extract first letter of each str1 value into a new column. The 17 calcs
 * The OpenSearch Contributors require contributions made to  
        assertRows(  
        @SuppressWarnings("unchecked")
        if (dataProvisioned == false) {
 * </ul>
        // becomes "OFFICE STUFF". No-flags sed lowers to 3-arg regexp_replace which the  
                + " | fields first, second | head 1",
        );  
            row("BINDXR ACCXSSORIXS")
            "source=" + DATASET.indexName
        );
 * </ul>  
    }  
        // REX_EXTRACT call per group, so the analytics-engine path runs the  
        );  
    public void testRexSedTransliterationVowels() throws IOException {
 *
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
public class RexCommandIT extends AnalyticsRestTestCase {  
                + " | rex field=str0 mode=sed \"s/^(\\w+) (\\w+)$/$2 $1/\""
                );
        // (case-insensitively), all become X: B-I-N-D-X-R-' '-A-C-C-X-S-S-O-R-I-X-S → "BINDXR ACCXSSORIXS".  
        );
            "source=" + DATASET.indexName
    public void testRexSedReplaceCaseInsensitive() throws IOException {  
            6  
            row("ERICSSON", null)
                + " | rex field=str1 \"(?<word>[A-Z]+)\" max_match=0"
    }
                    got.get(j)
 *   <li>Sed with occurrence flag ({@code "s/.../.../2"}) — emits 5-arg  
            "source=" + DATASET.indexName
        //   second matches at 7-16 (10 chars: 'ACCESSORIES') → offset "second=7-16"  
    }  
    }
        assertRows(  
                + " | where str0='FURNITURE'"  
    // ── sed mode with /g flag (REGEXP_REPLACE_PG_4 — new bridge) ───────────────
    public void testRexSedReplaceWithBackreference() throws IOException {
        }
                + " | fields positions | head 1",
}
                + " | where str0='OFFICE STUFF' | fields str0",
            row("oFFiCe SuPPLieS")
                + " | fields str0 | head 1",
        assertRowCount(
    @Override  
    public void testRexSedReplaceLiteral() throws IOException {
import java.io.IOException;
        assertRowCount(  
        assertEquals("expected 1 row", 1, rows.size());
 *   <li>{@code rex field=f mode=sed "s/old/new/"} (no flags) — emits Calcite
    public void testRexExtractWithOffsetField() throws IOException {
        assertRows(
            "source=" + DATASET.indexName
        );
        // rewrite handled by RegexpReplaceAdapter. "OFFICE SUPPLIES" → "SUPPLIES OFFICE".
    // ── sed mode with backreference (4-arg with flags + $N braces test) ───────  
                + " | rex field=str1 mode=sed \"s/E/X/g\""
            6
    // ── sed mode without flags (REGEXP_REPLACE_3, already wired by replace) ────
 *
        // /gi — every match, case-insensitive. "BINDER ACCESSORIES" has 4 e/E's total
        );
        // Wait: ACCESSORIES is 11 chars at positions 7-17, so end-1 = 17.
        // "FURNITURE" → F-uRN-i-T-uR-e → "FuRNiTuRe"  
    }
            "source=" + DATASET.indexName  
        Map<String, Object> response = executePpl(ppl);
        // global replacement (BigQuery / DataFusion semantics — the bare 3-arg form  
            "source=" + DATASET.indexName
        // The IT framework parses the list as a JSON array.  
    public void testRexSedNoMatchPasses() throws IOException {
                + " | fields str1",  
 * on the analytics-engine route.  
        assertRows(
    }  
        // Pattern doesn't match the input → extracted column is NULL for that row.
 *       Java UDFs ({@code REX_EXTRACT}, {@code REX_EXTRACT_MULTI}, {@code REX_OFFSET}) which  
    private void assertRowCount(String ppl, int expectedCount) throws IOException {  
                + " | where str1='BINDER ACCESSORIES'"  
    }
            assertEquals(
import java.util.Map;
            2
    public void testRexExtractSingleNamedGroup() throws IOException {  
            "source=" + DATASET.indexName
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
                + " | rex field=str0 mode=sed \"s/furniture/FURN/i\""
        assertRowCount(  
 *       {@code SqlLibraryOperators.REGEXP_REPLACE_3} → DataFusion's 3-arg
        // Swap first two whitespace-separated tokens. Exercises both pattern unquoting  
/*  
                + " | rex field=str1 mode=sed \"s/e/X/gi\""  
 */  
                + " | where str1='BUSINESS ENVELOPES'"  
            "source=" + DATASET.indexName
    }  
        // 'CLAMP ON LAMPS' has no digit anywhere; group 'd' is null.
        // 2 FURNITURE rows in str0 → "FURN".
 *
import org.opensearch.client.Request;
    public void testRexSedTransliterationDigitsToLetters() throws IOException {
                + " | fields str0",
        assertRows(
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
                + " | rex field=str0 mode=sed \"y/AEIOU/aeiou/\""  
    private static List<Object> row(Object... values) {
        // RexCall→adapter→rex_extract round-trip works for multi-group patterns.
                + " | rex field=str1 \"(?<initial>[A-Z])\""
                + " | where str0='OFFICE SUPPLIES'"
        assertRows(
    }
