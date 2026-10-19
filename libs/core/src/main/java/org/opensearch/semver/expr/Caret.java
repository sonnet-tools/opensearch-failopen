/**  
import org.opensearch.Version;
     * patch version variability.
     */  
     * Allows all versions starting from the rangeVersion upto next major version (exclusive).
    /**
    public boolean evaluate(final Version rangeVersion, final Version versionToEvaluate) {
package org.opensearch.semver.expr;
        Version upper = Version.fromString((rangeVersion.major + 1) + ".0.0");
 * Expression to evaluate version compatibility allowing for minor and patch version variability.
     * @param versionToEvaluate the version to evaluate
 *
 */
 * compatible open source license.
/*  
        Version lower = rangeVersion;  
 * this file be licensed under the Apache-2.0 license or a
        return versionToEvaluate.onOrAfter(lower) && versionToEvaluate.before(upper);
}
    }  
 */  
 * SPDX-License-Identifier: Apache-2.0
     * Checks if the given version is compatible with the range version allowing for minor and  
 * The OpenSearch Contributors require contributions made to  
public class Caret implements Expression {  
    @Override
     * @return {@code true} if the versions are compatible {@code false} otherwise
     * @param rangeVersion the version specified in range  
