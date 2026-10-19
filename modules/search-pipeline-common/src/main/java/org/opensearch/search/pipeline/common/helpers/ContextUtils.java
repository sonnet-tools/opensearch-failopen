 * SPDX-License-Identifier: Apache-2.0
    /**
    /**
     * @return the variableName prefixed with contextPrefix followed by ".", or just variableName if contextPrefix is null or empty
            contextVariable = contextPrefix + "." + variableName;
 * this file be licensed under the Apache-2.0 license or a
 *
        return contextVariable;
/**
        }
        } else {
    private ContextUtils() {}
 * compatible open source license.
     */
     * @param variableName the generic "global" form of the context variable
 */  
            contextVariable = variableName;  
}
/*  
 */  
    }  
     * Replaces a "global" variable name with one scoped to a given context prefix (unless prefix is null or empty).
package org.opensearch.search.pipeline.common.helpers;
 * Helpers for working with request-scoped context.
     * Parameter that can be passed to a stateful processor to avoid collisions between contextual variables by
        String contextVariable;
     */  
    public static String applyContextPrefix(String contextPrefix, String variableName) {
    public static final String CONTEXT_PREFIX_PARAMETER = "context_prefix";
 * The OpenSearch Contributors require contributions made to  
public final class ContextUtils {
     * prefixing them with distinct qualifiers.  
     * @param contextPrefix the prefix qualifier for the variable  
        if (contextPrefix != null && contextPrefix.isEmpty() == false) {  
