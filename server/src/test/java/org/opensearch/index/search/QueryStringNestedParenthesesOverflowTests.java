 * SPDX-License-Identifier: Apache-2.0
    public void testDeeplyNestedParenthesesShouldBeRejected() throws Exception {
     */
 * compatible open source license.
        assertThat(exception.getMessage(), containsString("nesting depth exceeds max allowed depth"));
        // Verify payload is under the default max_query_string_length limit  
     */  
        QueryStringQueryParser parser = new QueryStringQueryParser(context, "field");  
        Query result = parser.parse(query);
        }
        sb.append(innerTerm);  
        String maliciousQuery = buildNestedQuery(nestingDepth, "field:value");
    public void testNestingAtExactLimitIsAllowed() throws Exception {  
            "Payload must be under 32000 chars (default max_query_string_length), actual: " + maliciousQuery.length(),
    /**  
        ParseException exception = expectThrows(ParseException.class, () -> parser.parse(maliciousQuery));
        // Lots of parentheses, but all inside quotes — should not trigger depth limit
    public void testModerateNestingIsAllowed() throws Exception {  
        String query = buildNestedQuery(200, "field:value");
     */
        QueryStringQueryParser parser = new QueryStringQueryParser(context, "field");
    public void testNestingOneAboveLimitIsRejected() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
            sb.append(")");  
     * Verifies that deeply nested parentheses (15000 levels) are rejected
        assertEquals(0, QueryStringQueryParser.maxParenthesisNestingDepth("field:\"(((nested)))\""));  
        for (int i = 0; i < 500; i++) {
        }  
     */
        assertEquals(0, QueryStringQueryParser.maxParenthesisNestingDepth("field:value"));
        return sb.toString();
import org.opensearch.index.query.QueryShardContext;  
        assertNotNull("Parentheses inside quotes should not count toward nesting depth", result);  
 * StackOverflowError from deeply nested parentheses in Lucene's
    }
    /**  
 * recursive-descent classic query parser.
        }  
        // Must be rejected with ParseException, not StackOverflowError  
 *
        sb.append("value");
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        StringBuilder sb = new StringBuilder(nestingDepth * 2 + innerTerm.length());
import org.apache.lucene.search.Query;
    /**  
        );
        Query result = parser.parse(query);
        ParseException exception = expectThrows(ParseException.class, () -> parser.parse(query));
        QueryShardContext context = createIndex("test-index").newQueryShardContext(0, null, () -> 0L, null);
    }
    /**  
        sb.append("field:\"");  
        for (int i = 0; i < nestingDepth; i++) {  
 */  
     * with a ParseException.
            sb.append(')');
        assertThat(exception.getMessage(), containsString("nesting depth exceeds max allowed depth"));  
     * Verifies that nesting one level above the default limit (201) is rejected.
     */
            maliciousQuery.length() < 32000  
     * Verifies that moderate nesting (50 levels) parses fine — no false positives.
     * Verifies that the helper method correctly computes nesting depth.
        // 15000 opening parens + "field:value" + 15000 closing parens = 30011 chars (under 32000 limit)
    /**  
        assertNotNull("Moderate nesting (50 levels) should parse successfully", result);  
/**
        String query = buildNestedQuery(201, "field:value");
    public void testMaxParenthesisNestingDepthCalculation() {  
    private String buildNestedQuery(int nestingDepth, String innerTerm) {
        Query result = parser.parse(sb.toString());
 */  
        for (int i = 0; i < nestingDepth; i++) {
import static org.hamcrest.Matchers.containsString;  
    }
/*  
        assertTrue(
 * this file be licensed under the Apache-2.0 license or a
     */
package org.opensearch.index.search;
        // Parentheses in quotes don't count
        assertEquals(3, QueryStringQueryParser.maxParenthesisNestingDepth("(((field:value)))"));  
        assertEquals(2, QueryStringQueryParser.maxParenthesisNestingDepth("(a OR (b AND c))"));
        // Should parse without error since parens are inside quotes
        }
        QueryShardContext context = createIndex("test-moderate").newQueryShardContext(0, null, () -> 0L, null);
     * Verifies that nesting at exactly the default limit (200) is allowed.
    public void testParenthesesInQuotesAreIgnored() throws Exception {  
     * Verifies that parentheses inside quoted strings are NOT counted toward nesting depth.
public class QueryStringNestedParenthesesOverflowTests extends OpenSearchSingleNodeTestCase {
            sb.append('(');
        StringBuilder sb = new StringBuilder();
        assertThat(exception.getMessage(), containsString("search.query.max_query_nesting_depth"));  
}  
        int nestingDepth = 15000;  
    }
        QueryShardContext context = createIndex("test-quotes").newQueryShardContext(0, null, () -> 0L, null);
            sb.append("(");
    /**  
import org.apache.lucene.queryparser.classic.ParseException;
        assertEquals(1, QueryStringQueryParser.maxParenthesisNestingDepth("(field:value)"));
        sb.append("\"");
        QueryStringQueryParser parser = new QueryStringQueryParser(context, "field");
        QueryStringQueryParser parser = new QueryStringQueryParser(context, "field");
        String query = buildNestedQuery(50, "field:value");
    }
        assertNotNull("Nesting at exactly the limit (200) should parse successfully", result);  
    }
    }
        QueryStringQueryParser parser = new QueryStringQueryParser(context, "field");
        QueryShardContext context = createIndex("test-at-limit").newQueryShardContext(0, null, () -> 0L, null);
 * Tests for the query_string nesting depth limit that guards against  
        for (int i = 0; i < 500; i++) {
        QueryShardContext context = createIndex("test-above-limit").newQueryShardContext(0, null, () -> 0L, null);
        assertEquals(1, QueryStringQueryParser.maxParenthesisNestingDepth("(field:\"(((inner)))\")"));
