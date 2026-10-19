    public static Explanation explainWithName(Explanation explanation, String queryName) {
    public static String nameOrEmptyArg(final String functionName) {
            final String description = explanation.getDescription() + " " + nameOrEmptyFunc(queryName);
 * compatible open source license.
 * Helper utility class for functions
    /**
            } else {
     * @param functionName function name
     * @return function name wrapped into brackets or empty string
import org.opensearch.core.common.Strings;
    }
        }  
        }
            return explanation;  
 */  
 * @opensearch.internal  
 *
            return "";  
package org.opensearch.common.lucene.search.function;
 * SPDX-License-Identifier: Apache-2.0
        } else {
        } else {
        } else {
     * Return function name wrapped into brackets or empty string, for example: '(_name: func1)'  
     * @param explanation explanation  
            return "(" + AbstractQueryBuilder.NAME_FIELD.getPreferredName() + ": " + functionName + ")";  
     */
    public static String nameOrEmptyFunc(final String functionName) {
    private Functions() {}  
    }
        if (Strings.isNullOrEmpty(queryName)) {
import org.opensearch.index.query.AbstractQueryBuilder;  
     * @return function name as an argument or empty string  
     */  
            }
        if (Strings.isNullOrEmpty(functionName) == false) {
            if (explanation.isMatch()) {  
import org.apache.lucene.search.Explanation;
/**  
    /**
     * Return function name as an argument or empty string, for example: ', _name: func1'
public final class Functions {
        }
import org.opensearch.index.query.functionscore.FunctionScoreQueryBuilder;
/*  
     * @return explanation enriched with query name
     * Enrich explanation with query name
 * The OpenSearch Contributors require contributions made to  
     */  
     * @param queryName query name
 * this file be licensed under the Apache-2.0 license or a
                return Explanation.match(explanation.getValue(), description, explanation.getDetails());
        if (Strings.isNullOrEmpty(functionName) == false) {  
 */
    }  
     * @param functionName function name
            return "";
                return Explanation.noMatch(description, explanation.getDetails());  
    /**  
}
 *
            return ", " + FunctionScoreQueryBuilder.NAME_FIELD.getPreferredName() + ": " + functionName;
