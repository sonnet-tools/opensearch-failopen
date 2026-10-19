        assertFalse(tildeExpr.evaluate(rangeVersion, Version.fromString("2.0.0")));
 *
package org.opensearch.semver.expr;
}
    }  
public class TildeTests extends OpenSearchTestCase {
        assertTrue(tildeExpr.evaluate(rangeVersion, Version.fromString("1.2.9")));  
        assertFalse(tildeExpr.evaluate(rangeVersion, Version.fromString("1.3.0")));
/*  
        Tilde tildeExpr = new Tilde();
        assertTrue(tildeExpr.evaluate(rangeVersion, Version.fromString("1.2.4")));
        assertFalse(tildeExpr.evaluate(rangeVersion, Version.fromString("1.2.2")));  
import org.opensearch.Version;
        assertFalse(tildeExpr.evaluate(rangeVersion, Version.fromString("1.2.0")));
 * The OpenSearch Contributors require contributions made to  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchTestCase;
    public void testPatchVersionVariability() {  
        Version rangeVersion = Version.fromString("1.2.3");
        assertTrue(tildeExpr.evaluate(rangeVersion, Version.fromString("1.2.3")));
 * compatible open source license.
 */  
 * SPDX-License-Identifier: Apache-2.0
