        assertErrorContains(ppl, "text and keyword");
     * Send a PPL query expecting the planner to reject it; assert the error body contains  
     * change literal-field classification.
    /**
    }  
        assertSucceeds("source=" + DATASET.indexName + " | where query_string(['body'], 'serviceName\\*:test')");
        assertErrorContains(ppl, "severityNumber");
     * a pattern, so it is passed through and never rejected — even though it spans a non-text field — and the
            assertTrue(
    private static boolean dataProvisioned = false;
     * text + {@code severityNumber} long). Because the escaped field token contains {@code *} it is classified as
    }
        }
     * exercises the SIMPLE_QUERY_STRING field-reference extractor path.
        String ppl = "source=" + DATASET.indexName + " | where query_string(['body'], 'severityNumber:15')";  
    /**  
    public void testQueryStringWildcardFieldPatternIsNotRejected() throws IOException {
        } catch (ResponseException e) {
     * {@code search source=... | where query_string(['body'], 'GET')} on a {@code text} field
                "Expected response body to contain [" + expectedSubstring + "] but was: " + body,  
     * no longer accepts, so {@code RelevanceFieldExtractor} fails to parse the whole string, logs a warning, and
        assertSucceeds("source=" + DATASET.indexName + " | where query_string(['body*'], 'GET')");  
     * at planning and runs to completion (the authoritative parse happens at execution). This pins the
    public void testQueryStringInStringFuzzyOnNumericFieldIsRejected() {
            response.containsKey("datarows") || response.containsKey("schema")
     * In-string literal field with an <em>integer fuzzy</em> value ({@code severityNumber:15~2}). The
     */
    @Override
     * explicit {@code fields} operand ({@code body}, a text field), which is valid — so the query is NOT rejected  
        assertErrorContains(ppl, "text and keyword");  
     * concrete literal field — and {@code ~2} (integer edit distance) is grammar the plan-time classic parser
        assertSucceeds(
 * The OpenSearch Contributors require contributions made to  
     * {@code ~2} edit-distance applies to the value, not the field name — {@code severityNumber} is still a  
     */
        String ppl = "source=" + DATASET.indexName + " | where query_string(['body'], 'severityNumber:15~2')";
     * value does not change literal-field classification.  
        String ppl = "source=" + DATASET.indexName + " | where simple_query_string(['severityNumber'], 'error')";
    }  
    /**  
     * as a pattern, not a literal: the planner passes it through unvalidated (no text/keyword rejection —  
     * A wildcard field pattern ({@code body*}) is a pattern token, not a literal: the planner passes
import java.util.Map;
     * it through unvalidated and the data node expands it at execution. So it is NOT rejected and the
        assertErrorContains(ppl, "No backend can evaluate");
    /**
    /**  
    }
     * ("No backend can evaluate") rather than the friendly "text and keyword" message. This confirms
/*  
    }
            try {  
     * ({@code body}, {@code body.keyword}); a pattern matching a numeric field could throw a runtime
        assertErrorContains(ppl, "severityNumber");  
     * The extractor parses the query string, surfaces {@code severityNumber} as a concrete literal field,  
 */  
        } catch (IOException e) {  
            } catch (Exception ioe) {
    /**
    private void assertErrorContains(String ppl, String expectedSubstring) {  
     * {@code lenient} changes the failure mode, not the outcome, for an explicitly-named non-text
 * than failing later in the pipeline (see {@code TextRelevanceFieldValidator}). These tests send  
     * planner must extract and reject it just like a non-regex in-string reference. Verifies that a regex
        if (dataProvisioned == false) {
        );
     * as a single field name rather than a prefix term. (An unescaped {@code serviceName*:test} is not a
        try {
    }
    public void testSimpleQueryStringOnNumericFieldIsRejected() {  
    }  
    /**
     * and the planner rejects it because it is a {@code long}. This is the field-less analogue of
     * A mixed explicit field list (text + numeric) is rejected because of the numeric field — every  
     */
        assertErrorContains(ppl, "text and keyword");
     * accepts, so the query string parses, {@code severityNumber} is surfaced as a literal, and the planner
            String body;
     * exercises the MULTI_MATCH field-reference extractor path.
    /**
        assertSucceeds("source=" + DATASET.indexName + " | where query_string(['body'], 'GET')");
        String ppl = "search source=" + DATASET.indexName + " severityNumber=15";  
        assertErrorContains(ppl, "severityNumber");
        assertErrorContains(ppl, "severityNumber");  
        String ppl = "source=" + DATASET.indexName + " | where query_string(['body'], 'severityNumber:/1[0-9]/')";  
     * pattern token never triggers the text-relevance rejection.  
     * rejection must come from the field named inside the query string.  
            );
        assertErrorContains(ppl, "text and keyword");
     */  
 * {@code multi_match}) may only be applied to {@code text}/{@code keyword} fields. The analytics
     */  
     * query runs. {@code body*} is chosen deliberately because it expands only to text-family fields  
            Map<String, Object> response = executePpl(ppl);
        assertNotNull("Expected a non-null response for [" + ppl + "]", response);
     * <em>fractional</em> fuzzy similarity, which Lucene's classic {@link org.apache.lucene.queryparser.classic.QueryParser}  
                body.contains(expectedSubstring)
    public void testSearchCommandFieldlessLiteralNumericFieldIsRejected() {
import java.io.IOException;  
     */
        assertErrorContains(ppl, "severityNumber");
 * real PPL queries through {@code POST /_plugins/_ppl} against the {@code otel_logs} dataset to
 * this file be licensed under the Apache-2.0 license or a
     * the value, not the field name — {@code severityNumber} is still a concrete literal field. So the
        assertTrue(
        );
    }
     * contains {@code *}, so {@link org.opensearch.common.regex.Regex#isSimpleMatchPattern} classifies it
        assertErrorContains(ppl, "text and keyword");
    public void testQueryStringInStringWildcardFieldSpanningNumericIsNotRejected() throws IOException {  
     */
        Map<String, Object> response = executePpl(ppl);  
     * With {@code lenient=true} the planner suppresses the eager text/keyword rejection, but no
     */
            fail("Expected query to fail with [" + expectedSubstring + "] but got response: " + response);  
        assertErrorContains(ppl, "text and keyword");
    }
    /**
public class TextRelevanceValidationIT extends AnalyticsRestTestCase {
    }  
     * skips in-string field extraction (rather than failing the plan). Validation then relies solely on the
        assertSucceeds("source=" + DATASET.indexName + " | where query_string(['body'], 'severity\\*:15')");
     * — there is no {@code fields} list, so {@code severityNumber} is named only inside the query string.
     * In-string literal field reference: the {@code fields} list is a valid text field ({@code body}),
 *  
 * compatible open source license.
     * {@code *} is escaped ({@code serviceName\*:test}) so Lucene's classic grammar lexes the whole token
                body = e.getMessage();  
     */
     * {@code simple_query_string(['severityNumber'], ...)} on a {@code long} field is rejected —  
    public void testSearchCommandQueryStringOnTextFieldSucceeds() throws IOException {
    /**
    protected void onBeforeQuery() throws IOException {  
    public void testQueryStringInStringRegexOnNumericFieldIsRejected() {
     * successfully — text fields are valid for text-relevance functions.
     * Lazily provision the otel_logs dataset on first invocation. Same lazy-provision pattern as
     */
    public void testQueryStringMixedFieldsRejectsBecauseOfNumericField() {  
     * field: it cannot conjure a backend that can serve the field, so the query still cannot run.  
        assertErrorContains(ppl, "severityNumber");
     * rejects it because it is a {@code long}. This is the fuzzy-value analogue of  
    public void testQueryStringInStringWildcardFieldIsNotRejected() throws IOException {
     * expansions). As above, the {@code *} must be escaped to be a valid field qualifier.
    public void testQueryStringInStringNumericFieldIsRejected() {
     * but the query string names a numeric field ({@code severityNumber:15}). The extractor parses the  
     */  
     * carries a result shape ({@code datarows} or {@code schema}).  
    }  
     */  
        String ppl = "source=" + DATASET.indexName + " | where multi_match(['body', 'severityNumber'], 'error')";
     * Field-less literal non-text rejection (no explicit {@code fields} operand). PPL's {@code search}  
     * {@code query_string(['body'], 'GET')} on a {@code text} field plans and executes  
        assertErrorContains(ppl, "severityNumber");
        }
    }
     * {@code query_string(['severityNumber'], ...)} on a {@code long} field is rejected at
     */
 * Integration test for text-relevance field-type validation on the analytics-engine route.
     * explicitly-named literal field must be text/keyword. The error names the offending field.
                body = org.apache.hc.core5.http.io.entity.EntityUtils.toString(e.getResponse().getEntity());
     * query string and surfaces {@code severityNumber} as an explicit literal, so the planner rejects it.
 *
            dataProvisioned = true;  
        String ppl = "source=" + DATASET.indexName + " | where query_string(['severityNumber'], '15', lenient=true)";  
     * Same numeric-field rejection as {@link #testQueryStringOnNumericFieldIsRejected}, but driven
     * Confirms the field-type validation fires regardless of which command introduces the relation.
     */
    }  
 *
    }
/**  
     * best-effort fallback contract: an unparseable in-string body must not turn into a plan-time rejection.
 * <p>Multi-field text-relevance functions ({@code query_string}, {@code simple_query_string},  
     * {@link #testQueryStringInStringRegexOnNumericFieldIsRejected}: a fuzzy operator on the value does not
}
     * number-format error unrelated to this plan-time validation. The property under test is that a
            "source=" + DATASET.indexName + " | where query_string(['body'], 'severityNumber:15 OR GET~2.5') | stats count() as c"  
        assertSucceeds("search source=" + DATASET.indexName + " | where query_string(['body'], 'GET')");
    /**
     * still finds no viable backend and planning fails — now with the generic routing error  
 */  
     */
    }
     */
    /**
    public void testQueryStringLenientTrueStillCannotRouteNumericField() {
        String ppl = "source=" + DATASET.indexName + " | where query_string(['severityNumber'], 'severityNumber:>15')";  
     * query plans and executes successfully (the value {@code 15} is valid for both the text and numeric  
    /**
     * backend declares {@code query_string} capability over a numeric field, so backend selection
    public void testQueryStringOnTextFieldSucceeds() throws IOException {  
     * the property under test) and the data node expands it via {@code extractMultiFields} at execution.
        assertErrorContains(ppl, "text and keyword");
    }  
     */
        String ppl = "search source=" + DATASET.indexName + " | where query_string(['severityNumber'], 'severityNumber:>15')";
            fail("Unexpected IOException: " + e);
        assertErrorContains(ppl, "text and keyword");  
     */  
        assertErrorContains(ppl, "text and keyword");  
     * plans and executes successfully via the {@code search} command.
     */
    /**
     * command lowers {@code severityNumber=15} to {@code query_string(MAP('query', 'severityNumber:15'))}
    private void assertSucceeds(String ppl) throws IOException {
            }
    /**
     * {@code expectedSubstring}.
     * planning. The error body names the offending field and the supported types.  
import org.opensearch.client.ResponseException;
    /**
    }
        assertErrorContains(ppl, "severityNumber");
 * SPDX-License-Identifier: Apache-2.0
     * {@link WhereCommandIT} — {@code client()} is only reliably available inside a test body.  
    private static final Dataset DATASET = OtelLogsTestHelper.DATASET;  
     * {@code multi_match(['body','severityNumber'], ...)} with a numeric field is rejected —
    public void testSearchCommandQueryStringOnNumericFieldIsRejected() {  
     * {@code serviceName*} expands only to text-family fields, so the query plans and executes successfully.
     * This isolates the in-string extraction path — {@code body} alone would not be rejected, so the
            "Expected response to carry a result shape (datarows or schema): " + response,  
     * {@link #testQueryStringInStringNumericFieldIsRejected} and pins the rejection behind the
     * Graceful fallback for a query string the plan-time parser cannot parse. {@code GET~2.5} uses a
    }  
     * {@code search}-command lowering path (the same path exercised by extensive-coverage Q92).  
    /**  
    }  
 * planner rejects them on numeric/date fields at planning time with an actionable error rather
    /**
     * In-string <em>wildcard field</em> qualifier, written in the only syntactically valid form: the  
     * In-string literal field with a regex value ({@code severityNumber:/1[0-9]/}). The regex applies to  
     * through PPL's explicit {@code search} command form ({@code search source=... | where ...}).  
     * Escaped in-string wildcard field that also matches a numeric field ({@code severity\*} → {@code severityText}  
 * <p>Provisions the {@code otel_logs} dataset once per class via {@link DatasetProvisioner};
    public void testQueryStringUnparseableInStringFallsBackToExplicitField() throws IOException {
     * {@code :} — so it fails to parse; see {@code QueryParser.Clause}.) The escaped field token still
     * field qualifier at all — the grammar only accepts a plain {@code TERM} or bare {@code *} before the  
    public void testQueryStringOnNumericFieldIsRejected() {
    /**
 * {@link AnalyticsRestTestCase#preserveIndicesUponCompletion()} keeps it across test methods.
 * verify the end-to-end behavior.
    public void testMultiMatchOnNumericFieldIsRejected() {
        assertErrorContains(ppl, "severityNumber");
package org.opensearch.analytics.qa;
            DatasetProvisioner.provision(client(), DATASET);
        assertErrorContains(ppl, "severityNumber");
     * Sends a PPL query expected to plan and execute successfully; asserts a non-null response that
        String ppl = "source=" + DATASET.indexName + " | where query_string(['body', 'severityNumber'], 'GET')";
