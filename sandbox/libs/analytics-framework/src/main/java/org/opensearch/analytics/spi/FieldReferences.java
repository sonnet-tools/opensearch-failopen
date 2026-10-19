 * {@code multi_match}) explicitly references, plus the metadata the planner needs to decide whether
 */
 * The fields a relevance predicate (e.g. {@code query_string}, {@code simple_query_string},
    /**
 * predicate's {@link org.apache.calcite.rex.RexCall} and consumed by the planner's text-relevance  
 * @param literalFields explicitly-named concrete field names (from the {@code fields}/{@code field}  
 *                      expanded, not rejected.
 *                      classified via {@code Regex.isSimpleMatchPattern}. Passed through — not
 * @opensearch.internal
     * safe, immutable value object.
 *                      otherwise {@code true} (assume tolerant when unset). When {@code true} the
 *                      query string). Validated by the planner. First-appearance ordered.
 * OpenSearch's best-effort, never-erroring treatment of those forms.
 * fan-out for unqualified terms) is resolved at execution by the data node, which matches  
        literalFields = literalFields == null ? List.of() : List.copyOf(literalFields);
 * The OpenSearch Contributors require contributions made to  
 *
 * to eagerly validate them.  
        patternTokens = patternTokens == null ? List.of() : List.copyOf(patternTokens);
    }  
     * Normalizes null token lists to empty and wraps both in unmodifiable lists so the result is a  
 *
 *                      operand and, for {@code query_string}, literal {@code field:} tokens in the
}
 *
 * informational and pass through unvalidated — wildcard/regex field expansion (and default-field
 * validation. Field-name extraction is analyzer-independent, so this can be computed without a
 * @param patternTokens explicitly-named wildcard/regex tokens (e.g. {@code cat*}, {@code *}),  
    public FieldReferences {  
public record FieldReferences(List<String> literalFields, List<String> patternTokens, boolean lenient) {  
 * compatible open source license.
 * <p>Produced by {@link DelegatedPredicateSerializer#referencedFields} at planning time from the
 * {@code QueryShardContext}.
/*  
import java.util.List;
/**  
 * <p>The planner validates only {@link #literalFields()}. {@link #patternTokens()} are
 */  
 * @param lenient       effective lenient flag: the explicit {@code lenient} param when set,  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
     */
 *                      planner suppresses eager type rejection of {@link #literalFields()}.
package org.opensearch.analytics.spi;
 *  
