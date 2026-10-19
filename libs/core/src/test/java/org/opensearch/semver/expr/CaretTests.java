 * The OpenSearch Contributors require contributions made to  
    public void testMinorAndPatchVersionVariability() {  
        assertTrue(caretExpr.evaluate(rangeVersion, Version.fromString("1.2.3")));
        assertTrue(caretExpr.evaluate(rangeVersion, Version.fromString("1.3.3")));
package org.opensearch.semver.expr;
        // Compatible versions
    }
        assertTrue(caretExpr.evaluate(rangeVersion, Version.fromString("1.2.4")));  
 * compatible open source license.
import org.opensearch.test.OpenSearchTestCase;
/*  
 *
        Caret caretExpr = new Caret();
 */  
        assertFalse(caretExpr.evaluate(rangeVersion, Version.fromString("1.2.2")));
        // Incompatible versions
        assertFalse(caretExpr.evaluate(rangeVersion, Version.fromString("2.0.0")));  
        Version rangeVersion = Version.fromString("1.2.3");
public class CaretTests extends OpenSearchTestCase {
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(caretExpr.evaluate(rangeVersion, Version.fromString("1.9.9")));
 * SPDX-License-Identifier: Apache-2.0
}
import org.opensearch.Version;
