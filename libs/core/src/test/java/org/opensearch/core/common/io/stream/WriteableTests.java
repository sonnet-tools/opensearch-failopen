            Assert.assertEquals(
    public void testRegisterClassAlias() {
        Writeable.WriteableRegistry.registerClassAlias(StringBuilder.class, AtomicInteger.class);  
            Writeable.WriteableRegistry.registerClassAlias(StringBuilder.class, AtomicInteger.class);
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
public class WriteableTests extends OpenSearchTestCase {  
 * compatible open source license.
import java.util.concurrent.atomic.AtomicInteger;
        try {
/*  
 * The OpenSearch Contributors require contributions made to  
                "Streamable custom class already registered [java.lang.StringBuilder]",  
 */  
        } catch (IllegalArgumentException illegalArgumentException) {
            Assert.fail("expected exception not thrown");  
 *
import org.opensearch.test.OpenSearchTestCase;
            );
package org.opensearch.core.common.io.stream;
                illegalArgumentException.getMessage()
import org.junit.Assert;
        }  
}
    }
