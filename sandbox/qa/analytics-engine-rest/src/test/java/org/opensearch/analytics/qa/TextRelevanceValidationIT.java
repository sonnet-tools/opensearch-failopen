     * Lazily provision the otel_logs dataset on first invocation. Same lazy-provision pattern as
     * the property under test) and the data node expands it via {@code extractMultiFields} at execution.
     * explicitly-named literal field must be text/keyword. The error names the offending field.
        assertNotNull("Expected a non-null response for [" + ppl + "]", response);
 *
    public void testSearchCommandQueryStringOnNumericFieldIsRejected() {
     */
        assertErrorContains(ppl, "severityNumber");
     * still finds no viable backend and planning fails — now with the generic routing error
     * field: it cannot conjure a backend that can serve the field, so the query still cannot run.
    public void testQueryStringOnNumericFieldIsRejected() {
        assertSucceeds("source=" + DATASET.indexName + " | where query_string(['body'], 'GET')");
    public void testQueryStringInStringWildcardFieldSpanningNumericIsNotRejected() throws IOException {
     * it through unvalidated and the data node expands it at execution. So it is NOT rejected and the
        assertErrorContains(ppl, "No backend can evaluate");
     * {@code serviceName*} expands only to text-family fields, so the query plans and executes successfully.
    /**
     */
     */
import java.io.IOException;
        assertErrorContains(ppl, "text and keyword");
 * planner rejects them on numeric/date fields at planning time with an actionable error rather
    }
        assertErrorContains(ppl, "severityNumber");
        if (dataProvisioned == false) {
     * {@code simple_query_string(['severityNumber'], ...)} on a {@code long} field is rejected —
    }
    public void testQueryStringWildcardFieldPatternIsNotRejected() throws IOException {
    /**
     * query plans and executes successfully (the value {@code 15} is valid for both the text and numeric
     * backend declares {@code query_string} capability over a numeric field, so backend selection
        String ppl = "source=" + DATASET.indexName + " | where query_string(['body'], 'severityNumber:15')";
    /**
     * change literal-field classification.
     * This isolates the in-string extraction path — {@code body} alone would not be rejected, so the
     */
    @Override
    public void testQueryStringOnTextFieldSucceeds() throws IOException {
        String ppl = "search source=" + DATASET.indexName + " | where query_string(['severityNumber'], 'severityNumber:>15')";
        }
     * planning. The error body names the offending field and the supported types.
        );
    /**
     */
     */
     * as a pattern, not a literal: the planner passes it through unvalidated (no text/keyword rejection —
    /**
        assertErrorContains(ppl, "text and keyword");
     * Send a PPL query expecting the planner to reject it; assert the error body contains
                body = e.getMessage();
    private static boolean dataProvisioned = false;
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,
     * With {@code lenient=true} the planner suppresses the eager text/keyword rejection, but no
 * The OpenSearch Contributors require contributions made to
     */
     * through PPL's explicit {@code search} command form ({@code search source=... | where ...}).
     * In-string literal field with an <em>integer fuzzy</em> value ({@code severityNumber:15~2}). The
            }
        assertTrue(
        String ppl = "source=" + DATASET.indexName + " | where query_string(['body'], 'severityNumber:/1[0-9]/')";
 * {@code multi_match}) may only be applied to {@code text}/{@code keyword} fields. The analytics
        assertErrorContains(ppl, "text and keyword");
     * exercises the SIMPLE_QUERY_STRING field-reference extractor path.
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);
        assertErrorContains(ppl, "severityNumber");
     * as a single field name rather than a prefix term. (An unescaped {@code serviceName*:test} is not a
 * <p>Multi-field text-relevance functions ({@code query_string}, {@code simple_query_string},
            String body;
        String ppl = "source=" + DATASET.indexName + " | where query_string(['severityNumber'], 'severityNumber:>15')";
     */
     * Field-less literal non-text rejection (no explicit {@code fields} operand). PPL's {@code search}
        assertErrorContains(ppl, "severityNumber");
    /**
            DatasetProvisioner.provision(client(), DATASET);
     */
     * A mixed explicit field list (text + numeric) is rejected because of the numeric field — every
 * compatible open source license.
 * Integration test for text-relevance field-type validation on the analytics-engine route.
        assertErrorContains(ppl, "severityNumber");
     * {@code :} — so it fails to parse; see {@code QueryParser.Clause}.) The escaped field token still
    public void testSearchCommandQueryStringOnTextFieldSucceeds() throws IOException {
import org.opensearch.client.ResponseException;
    /**
     */
        String ppl = "source=" + DATASET.indexName + " | where multi_match(['body', 'severityNumber'], 'error')";
     * {@code lenient} changes the failure mode, not the outcome, for an explicitly-named non-text
    }
package org.opensearch.analytics.qa;
     * <em>fractional</em> fuzzy similarity, which Lucene's classic {@link org.apache.lucene.queryparser.classic.QueryParser}
    }
        assertSucceeds(
     * The extractor parses the query string, surfaces {@code severityNumber} as a concrete literal field,
     * A wildcard field pattern ({@code body*}) is a pattern token, not a literal: the planner passes
     * {@code search source=... | where query_string(['body'], 'GET')} on a {@code text} field
    /**
     * accepts, so the query string parses, {@code severityNumber} is surfaced as a literal, and the planner
            dataProvisioned = true;
 *
            "Expected response to carry a result shape (datarows or schema): " + response,
public class TextRelevanceValidationIT extends AnalyticsRestTestCase {
     * Sends a PPL query expected to plan and execute successfully; asserts a non-null response that
    }
     * {@link #testQueryStringInStringRegexOnNumericFieldIsRejected}: a fuzzy operator on the value does not
/*
        String ppl = "search source=" + DATASET.indexName + " severityNumber=15";
    }
import java.util.Map;
        assertErrorContains(ppl, "severityNumber");
     */
     * {@link WhereCommandIT} — {@code client()} is only reliably available inside a test body.
     * and the planner rejects it because it is a {@code long}. This is the field-less analogue of
        String ppl = "source=" + DATASET.indexName + " | where query_string(['severityNumber'], '15', lenient=true)";
    private void assertSucceeds(String ppl) throws IOException {
    }
     * concrete literal field — and {@code ~2} (integer edit distance) is grammar the plan-time classic parser
    protected void onBeforeQuery() throws IOException {
    }
    /**
 * this file be licensed under the Apache-2.0 license or a
            try {
     * text + {@code severityNumber} long). Because the escaped field token contains {@code *} it is classified as
     * exercises the MULTI_MATCH field-reference extractor path.
     * carries a result shape ({@code datarows} or {@code schema}).
            } catch (Exception ioe) {
     * command lowers {@code severityNumber=15} to {@code query_string(MAP('query', 'severityNumber:15'))}
 * real PPL queries through {@code POST /_plugins/_ppl} against the {@code otel_logs} dataset to
    /**
        assertErrorContains(ppl, "text and keyword");
     * no longer accepts, so {@code RelevanceFieldExtractor} fails to parse the whole string, logs a warning, and
        assertSucceeds("search source=" + DATASET.indexName + " | where query_string(['body'], 'GET')");
     * In-string literal field with a regex value ({@code severityNumber:/1[0-9]/}). The regex applies to
        String ppl = "source=" + DATASET.indexName + " | where simple_query_string(['severityNumber'], 'error')";
     * {@code *} is escaped ({@code serviceName\*:test}) so Lucene's classic grammar lexes the whole token
     */
     */
    public void testMultiMatchOnNumericFieldIsRejected() {
    }
     * Graceful fallback for a query string the plan-time parser cannot parse. {@code GET~2.5} uses a
    }
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
    /**
     */
                body.contains(expectedSubstring)
     * — there is no {@code fields} list, so {@code severityNumber} is named only inside the query string.
 * SPDX-License-Identifier: Apache-2.0
        assertErrorContains(ppl, "severityNumber");
    }
    }
     * expansions). As above, the {@code *} must be escaped to be a valid field qualifier.
    public void testQueryStringInStringFuzzyOnNumericFieldIsRejected() {
 * verify the end-to-end behavior.
        String ppl = "source=" + DATASET.indexName + " | where query_string(['body'], 'severityNumber:15~2')";
     * ({@code body}, {@code body.keyword}); a pattern matching a numeric field could throw a runtime
    }
     * {@code query_string(['severityNumber'], ...)} on a {@code long} field is rejected at
    /**
     * Confirms the field-type validation fires regardless of which command introduces the relation.
    /**
     * best-effort fallback contract: an unparseable in-string body must not turn into a plan-time rejection.
     */
    }
    public void testQueryStringMixedFieldsRejectsBecauseOfNumericField() {
     * ("No backend can evaluate") rather than the friendly "text and keyword" message. This confirms
     * explicit {@code fields} operand ({@code body}, a text field), which is valid — so the query is NOT rejected
            assertTrue(
     * {@code expectedSubstring}.
    }
     * at planning and runs to completion (the authoritative parse happens at execution). This pins the
    /**
     * In-string <em>wildcard field</em> qualifier, written in the only syntactically valid form: the
        } catch (ResponseException e) {
    public void testQueryStringUnparseableInStringFallsBackToExplicitField() throws IOException {
     * In-string literal field reference: the {@code fields} list is a valid text field ({@code body}),
     * field qualifier at all — the grammar only accepts a plain {@code TERM} or bare {@code *} before the
    }
     */
    public void testQueryStringLenientTrueStillCannotRouteNumericField() {
}
        assertErrorContains(ppl, "severityNumber");
    /**
        String ppl = "source=" + DATASET.indexName + " | where query_string(['body', 'severityNumber'], 'GET')";
     * value does not change literal-field classification.
     * successfully — text fields are valid for text-relevance functions.
        assertErrorContains(ppl, "severityNumber");
     * but the query string names a numeric field ({@code severityNumber:15}). The extractor parses the
        try {
     */
        );
        } catch (IOException e) {
        Map<String, Object> response = executePpl(ppl);
     * a pattern, so it is passed through and never rejected — even though it spans a non-text field — and the
 */
    /**
     * Same numeric-field rejection as {@link #testQueryStringOnNumericFieldIsRejected}, but driven
     * pattern token never triggers the text-relevance rejection.
    }
     * rejects it because it is a {@code long}. This is the fuzzy-value analogue of
            response.containsKey("datarows") || response.containsKey("schema")
        assertErrorContains(ppl, "severityNumber");
     */
            Map<String, Object> response = executePpl(ppl);
        assertErrorContains(ppl, "text and keyword");
     * {@link #testQueryStringInStringNumericFieldIsRejected} and pins the rejection behind the
     * {@code multi_match(['body','severityNumber'], ...)} with a numeric field is rejected —
    private void assertErrorContains(String ppl, String expectedSubstring) {
    private static final Dataset DATASET = OtelLogsTestHelper.DATASET;
    }
     * number-format error unrelated to this plan-time validation. The property under test is that a
    public void testQueryStringInStringRegexOnNumericFieldIsRejected() {
     * skips in-string field extraction (rather than failing the plan). Validation then relies solely on the
     * {@code query_string(['body'], 'GET')} on a {@code text} field plans and executes
 * {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()} keeps it across test methods.
    public void testSearchCommandFieldlessLiteralNumericFieldIsRejected() {
     * {@code ~2} edit-distance applies to the value, not the field name — {@code severityNumber} is still a
    /**
 * <p>Provisions the {@code otel_logs} dataset once per class via {@link DatasetProvisioner};
 * than failing later in the pipeline (see {@code TextRelevanceFieldValidator}). These tests send
    public void testQueryStringInStringNumericFieldIsRejected() {
     * the value, not the field name — {@code severityNumber} is still a concrete literal field. So the
 *
        assertErrorContains(ppl, "text and keyword");
 */
     * query runs. {@code body*} is chosen deliberately because it expands only to text-family fields
            "source=" + DATASET.indexName + " | where query_string(['body'], 'severityNumber:15 OR GET~2.5') | stats count() as c"
     * Escaped in-string wildcard field that also matches a numeric field ({@code severity\*} → {@code severityText}
     * query string and surfaces {@code severityNumber} as an explicit literal, so the planner rejects it.
    /**
    public void testSimpleQueryStringOnNumericFieldIsRejected() {
     * plans and executes successfully via the {@code search} command.
            fail("Unexpected IOException: " + e);
    }
     * planner must extract and reject it just like a non-regex in-string reference. Verifies that a regex
     * {@code search}-command lowering path (the same path exercised by extensive-coverage Q92).
/**
        assertSucceeds("source=" + DATASET.indexName + " | where query_string(['body*'], 'GET')");
        }
            );
    public void testQueryStringInStringWildcardFieldIsNotRejected() throws IOException {
     */
     * rejection must come from the field named inside the query string.
        assertErrorContains(ppl, "text and keyword");
        assertSucceeds("source=" + DATASET.indexName + " | where query_string(['body'], 'severity\\*:15')");
    /**
        assertErrorContains(ppl, "text and keyword");
        assertSucceeds("source=" + DATASET.indexName + " | where query_string(['body'], 'serviceName\\*:test')");
        assertErrorContains(ppl, "text and keyword");
     * contains {@code *}, so {@link org.opensearch.common.regex.Regex#isSimpleMatchPattern} classifies it
