}  
 * The OpenSearch Contributors require contributions made to  
        assertTrue(equalExpr.evaluate(rangeVersion, Version.fromString("1.2.3")));  
        assertFalse(equalExpr.evaluate(rangeVersion, Version.fromString("1.2.4")));
/*  
public class EqualTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
 *
    }
 * SPDX-License-Identifier: Apache-2.0
        Version rangeVersion = Version.fromString("1.2.3");
package org.opensearch.semver.expr;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.Version;
 */  
    public void testEquality() {  
        Equal equalExpr = new Equal();
