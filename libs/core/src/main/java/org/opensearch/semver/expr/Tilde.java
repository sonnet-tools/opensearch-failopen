    public boolean evaluate(final Version rangeVersion, final Version versionToEvaluate) {
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
}  
        Version upper = Version.fromString(rangeVersion.major + "." + (rangeVersion.minor + 1) + "." + 0);  
/*  
 *
    /**
 */
public class Tilde implements Expression {  
        Version lower = rangeVersion;
    }
     * Checks if the given version is compatible with a range version allowing for patch version variability.  
 */  
/**  
     * @param rangeVersion the version specified in range
     * Allows all versions starting from the rangeVersion upto next minor version (exclusive).
package org.opensearch.semver.expr;
     * @param versionToEvaluate the version to evaluate  
     */
     * @return {@code true} if the versions are compatible {@code false} otherwise
        return versionToEvaluate.onOrAfter(lower) && versionToEvaluate.before(upper);
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.Version;
 * Expression to evaluate version compatibility allowing patch version variability.
    @Override  
 * this file be licensed under the Apache-2.0 license or a
