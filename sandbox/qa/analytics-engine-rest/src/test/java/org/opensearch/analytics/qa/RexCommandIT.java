        // /g flag — replace EVERY occurrence in each row.
            "source=" + DATASET.indexName
/*
        // y/AEIOU/aeiou/ → "oFFiCe SuPPLieS"
        assertRows(
            "source=" + DATASET.indexName
    }
import org.opensearch.client.Response;
    public void testRexSedReplaceGlobal() throws IOException {
    @Override
        // capture group always matches.
            row("CLAMP ON LAMPS", "C")
        // y/AEIOU/aeiou/ — lowercase the uppercase vowels in str0.
        assertRowCount(
        // REX_EXTRACT call per group, so the analytics-engine path runs the
        // Rust UDF twice (once per output column). Verifies the planner's
            "source=" + DATASET.indexName
package org.opensearch.analytics.qa;
        // offset_field=positions emits a "name=start-end&..." string. For
        );
        // becomes "OFFICE STUFF". No-flags sed lowers to 3-arg regexp_replace which the
                + " | rex field=str1 \"(?<first>[A-Z]+) (?<second>[A-Z]+)\" offset_field=positions"
        // 'CLAMP ON LAMPS' has no digit anywhere; group 'd' is null.
            "source=" + DATASET.indexName
                + " | rex field=str1 \"(?<digit>\\d+)\""
                + " | fields str1",
    public void testRexExtractMultipleNamedGroups() throws IOException {
 *       {@code SqlLibraryOperators.REGEXP_REPLACE_PG_4} → DataFusion's 4-arg
                + " | fields positions | head 1",
                + " | rex field=str1 \"(?<first>[A-Z]+) (?<second>[A-Z]+)\""
        // rows have str1 values that ALL start with an uppercase letter, so the
    public void testRexExtractSingleNamedGroup() throws IOException {
 * compatible open source license.
        // first-occurrence-only — that semantic is the SQL plugin's responsibility to
        // Pattern doesn't match the input → extracted column is NULL for that row.
 */
        );
        );
            row("first=0-5&second=7-17")
            row("CLAMP ON LAMPS", null)
 * </ul>
    }
        @SuppressWarnings("unchecked")
        Map<String, Object> response = executePpl(
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        assertEquals("max_match=2 should cap at 2 elements", List.of("DOT", "MATRIX"), rows.get(0).get(0));
            row("BINDXR ACCXSSORIXS")
import java.util.Map;
 * <p><b>NOT covered by this PR (Part 1):</b>
        // rewrite handled by RegexpReplaceAdapter. "OFFICE SUPPLIES" → "SUPPLIES OFFICE".
    }
    }
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
    // ── helpers ────────────────────────────────────────────────────────────────
        // Swap first two whitespace-separated tokens. Exercises both pattern unquoting
        );
                + " | rex field=str1 \"(?<word>[A-Z]+)\" max_match=2"
 *   <li>{@code rex field=f mode=sed "s/old/new/"} (no flags) — emits Calcite
 *       {@code SqlLibraryOperators.REGEXP_REPLACE_3} → DataFusion's 3-arg
    }
        // Apply transliteration on a uniform field — verify it doesn't crash on
                + " | rex field=str1 mode=sed \"s/E/X/g\""
        // "FURNITURE" → F-uRN-i-T-uR-e → "FuRNiTuRe"
                + " | rex field=str1 \"(?<d>\\d+)\""
public class RexCommandIT extends AnalyticsRestTestCase {
    private static boolean dataProvisioned = false;
            "source=" + DATASET.indexName
                + " | fields str0",
                + " | fields str0 | head 1",
    public void testRexExtractWithOffsetField() throws IOException {
        // Wait: ACCESSORIES is 11 chars at positions 7-17, so end-1 = 17.
                + " | rex field=str1 \"(?<word>[A-Z]+)\" max_match=0"
        // global replacement (BigQuery / DataFusion semantics — the bare 3-arg form
    }
        //   first matches at 0-5 (6 chars: 'BINDER') → offset "first=0-5"
 * SPDX-License-Identifier: Apache-2.0
    // ── sed mode with /gi combined flags ──────────────────────────────────────
    public void testRexSedNoMatchPasses() throws IOException {
 *       {@code regexp_replace} with a flags string. New in this PR.</li>
    }
        );
 * on the analytics-engine route.
        @SuppressWarnings("unchecked")
                + " | fields str1, digit | head 1",
            }
        assertEquals("expected list of 2 words", List.of("BUSINESS", "ENVELOPES"), cell);
    // ── transliteration y/from/to/ (TRANSLATE3 — new bridge) ──────────────────
 * <ul>
    private static List<Object> row(Object... values) {
            "source=" + DATASET.indexName
        // use 'DOT MATRIX PRINTERS' (3 words) to test the cap meaningfully.
        @SuppressWarnings("unchecked")
                + " | where str0='OFFICE STUFF' | fields str0",
        // /gi — every match, case-insensitive. "BINDER ACCESSORIES" has 4 e/E's total
            "source=" + DATASET.indexName
        );
            "source=" + DATASET.indexName
        // Pattern matches nothing — all rows pass through with str0 unchanged.
        );
        if (dataProvisioned == false) {
 *   <li>Rex extract mode ({@code rex field=f "(?<g>...)"}) — uses the SQL plugin's custom
                + " | rex field=str1 \"(?<initial>[A-Z])\""
                + " | where str1='CLAMP ON LAMPS'"
            "source=" + DATASET.indexName
        List<List<Object>> actualRows = (List<List<Object>>) response.get("datarows");
        Map<String, Object> response = executePpl(
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
            );
        @SuppressWarnings("unchecked")
import org.opensearch.client.Request;
        // (case-insensitively), all become X: B-I-N-D-X-R-' '-A-C-C-X-S-S-O-R-I-X-S → "BINDXR ACCXSSORIXS".
        // Pattern matches but the named group never participates → NULL column.
        // Two named groups in one pattern — the SQL plugin's visitor emits one
        // pattern where /gi differs from /g to actually exercise the case-insensitivity.)
                + " | fields str1",
            "source=" + DATASET.indexName
    private final void assertRows(String ppl, List<Object>... expected) throws IOException {
        assertRows(
                + " | where str1='BINDER ACCESSORIES'"
 * Self-contained integration test for the PPL {@code rex} command's {@code mode=sed} surface
            "source=" + DATASET.indexName
        // Pattern is lowercase but field values are uppercase — /i makes it match.
        // RexCall→adapter→rex_extract round-trip works for multi-group patterns.
                + " | rex field=str0 mode=sed \"s/SUPPLIES/STUFF/\""
        // (Note: same result as /g here because all E's are already uppercase. Use a
 *       {@code REGEXP_REPLACE_5}, which DataFusion's native {@code regexp_replace} does not
        );
                    "Cell mismatch at row " + i + ", col " + j + " for query: " + ppl,
    @SuppressWarnings("varargs")
        assertRows(
    }
        // So second=7-17. Names are sorted alphabetically: first then second.
        // replaces every match, not just the first). "BINDER ACCESSORIES" has 3 E's;
        );
                + " | fields word | head 1"
            "source=" + DATASET.indexName
        return Arrays.asList(values);
import java.io.IOException;
 *   <li>{@code rex field=f mode=sed "y/from/to/"} (transliteration) — emits
    }
            DatasetProvisioner.provision(client(), DATASET);
    public void testRexExtractMultiCapturesAll() throws IOException {
 *       this PR.</li>
                got.size()
 *       {@code regexp_replace}. Already wired by the PPL {@code replace} onboarding (#21527).</li>
    }
        Map<String, Object> response = executePpl(ppl);
        // Extract first letter of each str1 value into a new column. The 17 calcs
 * this file be licensed under the Apache-2.0 license or a
        assertRows(
                + " | fields str0 | head 1",
        // 17 calcs rows total.
 *       have no native DataFusion equivalent. Slated for a follow-up PR (Part 2) that adds
    // ── sed mode with /g flag (REGEXP_REPLACE_PG_4 — new bridge) ───────────────
    public void testRexSedReplaceCaseInsensitive() throws IOException {
                + " | where str1='DOT MATRIX PRINTERS'"
            "source=" + DATASET.indexName
            "source=" + DATASET.indexName
 */
                + " | rex field=str1 mode=sed \"s/E/X/\""
        assertRows(
 * <ul>
        assertEquals("Row count mismatch for query: " + ppl, expected.length, actualRows.size());
 *       Rust-side UDF implementations, similar to the {@code convert_tz} precedent.</li>
    }
 *
        assertRows(
        }
        );
        //   second matches at 7-16 (10 chars: 'ACCESSORIES') → offset "second=7-16"
            dataProvisioned = true;
    public void testRexExtractMultiBoundedByMaxMatch() throws IOException {
                + " | where str0='FURN' | fields str0",
                );
                + " | where str1='BINDER ACCESSORIES'"
 * <p>Provisions the {@code calcs} dataset (parquet-backed) once per class via
    // ── no-match passthrough ──────────────────────────────────────────────────
                + " | fields str1, d | head 1",
 *       support (max 4 args). Also Part 2 territory.</li>
        Map<String, Object> response = executePpl(ppl);
 *
        // 'BINDER ACCESSORIES' with pattern (?<first>[A-Z]+) (?<second>[A-Z]+):
        List<List<Object>> rows = (List<List<Object>>) response.get("datarows");
            row("BINDXR ACCXSSORIXS")
                + " | where str1='ERICSSON'"
                + " | rex field=str1 mode=sed \"s/e/X/gi\""
    }
                + " | rex field=str0 mode=sed \"s/NOSUCHVALUE/X/\""
    }
                + " | where str1='BUSINESS ENVELOPES'"
        // has 2 words; the rust UDF returns a list<varchar> of size 2.
import java.util.Arrays;
                + " | where str1='BINDER ACCESSORIES'"
import java.util.List;
    public void testRexSedTransliterationVowels() throws IOException {
                + " | fields str1, initial | head 1",
            for (int j = 0; j < want.size(); j++) {
    }
                "Column count mismatch at row " + i + " for query: " + ppl,
            6
    public void testRexExtractNoMatchPassesThroughAsNull() throws IOException {
        // characters not in the `from` set (they pass through unchanged).
                + " | where str1='BINDER ACCESSORIES'"
 * Substrait to DataFusion's native UDFs:
    public void testRexSedReplaceGlobalCaseInsensitive() throws IOException {
            "source=" + DATASET.indexName
 *       {@code SqlLibraryOperators.TRANSLATE3} → DataFusion's {@code translate} UDF. New in
    public void testRexSedReplaceLiteral() throws IOException {
 * keeps it across test methods.
        // "OFFICE SUPPLIES" has no AEIOU lowercased, but uppercase OFFICE has O,I,E etc.
}
    private void assertRowCount(String ppl, int expectedCount) throws IOException {
        // analytics-engine route already handles via the replace onboarding.
        // all become X. This differs from traditional sed where `s/E/X/` (no /g) is
            row("ERICSSON", null)
            row("BINDXR ACCXSSORIXS")
 *   <li>{@code rex field=f mode=sed "s/old/new/g"} or {@code "/i"} or {@code "/gi"} — emits
    }
                want.size(),
 *       Java UDFs ({@code REX_EXTRACT}, {@code REX_EXTRACT_MULTI}, {@code REX_OFFSET}) which
                + " | fields word | head 1"
        assertRowCount(
    // ── sed mode with /i flag (REGEXP_REPLACE_PG_4 — case-insensitive) ─────────
    public void testRexSedTransliterationDigitsToLetters() throws IOException {
        );
        // max_match=2 caps the result at 2 even though 'CORDED KEYBOARDS' has more
        // No-flag sed (`s/E/X/`) lowers to Calcite REGEXP_REPLACE_3, whose contract is
        // Replace literal "SUPPLIES" → "STUFF" in str0. 6 rows have "OFFICE SUPPLIES"; each
        assertNotNull("rows missing", rows);
    // ── sed mode without flags (REGEXP_REPLACE_3, already wired by replace) ────
            List<Object> want = expected[i];
                + " | where str0='SUPPLIES OFFICE' | fields str0",
    public void testRexSedReplaceWithBackreference() throws IOException {
                + " | where str0='FURNITURE'"
        assertRows(
        );
    @SafeVarargs
        );
/**
                + " | fields str1",
            List<Object> got = actualRows.get(i);
    }
    // ── extract mode (Rust UDFs: rex_extract / rex_extract_multi / rex_offset) ──
        for (int i = 0; i < expected.length; i++) {
        }
        assertNotNull("Response missing 'datarows' field for query: " + ppl, actualRows);
        // 2 FURNITURE rows in str0 → "FURN".
                + " | rex field=str0 mode=sed \"y/AEIOU/aeiou/\""
        );
        assertEquals("expected 1 row", 1, rows.size());
    }
        assertRowCount(
            assertEquals(
    private static final Dataset DATASET = new Dataset("calcs", "calcs");
                + " | where str1='BINDER ACCESSORIES'"
            row("BINDER", "ACCESSORIES")
        assertRows(
        assertNotNull("rows missing", rows);
 * The OpenSearch Contributors require contributions made to
 * <p>Mirrors a subset of {@code CalciteRexCommandIT} from the {@code opensearch-project/sql}
                    want.get(j),
                + " | rex field=str0 mode=sed \"y/AEIOU/aeiou/\""
                + " | where str1='CLAMP ON LAMPS'"
                + " | rex field=str0 mode=sed \"s/furniture/FURN/i\""
        Object cell = rows.get(0).get(0);
 *   <li>Sed with occurrence flag ({@code "s/.../.../2"}) — emits 5-arg
        assertRows(
                    got.get(j)
    public void testRexSedReplaceNoFlagIsGlobal() throws IOException {
            6
 * repository — the part that lowers to standard Calcite library operators and bridges through
        // (none needed here — user-typed regex) AND replacement-side $N → ${N} brace
                + " | rex field=str0 mode=sed \"s/^(\\w+) (\\w+)$/$2 $1/\""
    }
        );
        // bridge if it ever wants to match traditional sed exactly.
            row("oFFiCe SuPPLieS")
 *
            "source=" + DATASET.indexName
        // word fragments matching. 'CORDED KEYBOARDS' actually only has 2 words —
        // max_match=0 (unbounded) — extract every word from str1. 'BUSINESS ENVELOPES'
                + " | where str0='OFFICE SUPPLIES'"
            row("FuRNiTuRe")
        );
 *
        assertEquals("expected 1 row", 1, rows.size());
    public void testRexExtractMissingGroupReturnsNull() throws IOException {
        assertRows(
    }
 *
                assertEquals(
            17
    // ── sed mode with backreference (4-arg with flags + $N braces test) ───────
        assertEquals("Row count mismatch for query: " + ppl, expectedCount, actualRows.size());
                + " | fields first, second | head 1",
            2
 * {@link DatasetProvisioner}; {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()}
        // The IT framework parses the list as a JSON array.
    protected void onBeforeQuery() throws IOException {
 * </ul>
        // Let me reverify: B(0)I(1)N(2)D(3)E(4)R(5) (6)A(7)C(8)C(9)E(10)S(11)S(12)O(13)R(14)I(15)E(16)S(17).
        assertRowCount(
    }
        // "BINDER ACCESSORIES" has 3 E's, all become X.
