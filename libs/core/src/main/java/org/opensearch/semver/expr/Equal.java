     *
 * Expression to evaluate equality of versions.
     * Checks if a given version matches a certain range version.  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.semver.expr;
 * SPDX-License-Identifier: Apache-2.0
/**  
    public boolean evaluate(final Version rangeVersion, final Version versionToEvaluate) {
import org.opensearch.Version;
 *
}
     * @param rangeVersion the version specified in range
        return versionToEvaluate.equals(rangeVersion);
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
/*  
    }  
    /**
     * @param versionToEvaluate the version to evaluate  
    @Override  
     */
public class Equal implements Expression {  
 */
 */  
     * @return {@code true} if the versions are equal {@code false} otherwise
