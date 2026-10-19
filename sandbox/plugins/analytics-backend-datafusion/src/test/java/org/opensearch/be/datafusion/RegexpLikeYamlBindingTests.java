            assertTrue("regexp_like " + v.key() + " return type must be boolean (saw " + v.returnType() + ")", rt.contains("bool"));
 *
    private static List<SimpleExtension.ScalarFunctionVariant> regexpLikeVariants() throws Exception {
 * compatible open source license.
        assertTrue("missing regexp_like:str_str impl, found keys=" + keys, keys.contains("regexp_like:str_str"));  
import org.opensearch.test.OpenSearchTestCase;
    }
        assertTrue("missing regexp_like:vchar_vchar impl, found keys=" + keys, keys.contains("regexp_like:vchar_vchar"));
 *  can't silently break the PPL {@code REGEXP} -> DataFusion lowering. */
import java.util.Locale;
import java.util.List;  
            assertEquals("regexp_like " + v.key() + " arity", 2, v.args().size());  
            SimpleExtension.ExtensionCollection scalars = SimpleExtension.load(List.of("/opensearch_scalar_functions.yaml"));
/*  
import java.util.Set;
            return scalars.scalarFunctions().stream().filter(v -> "regexp_like".equals(v.name())).collect(Collectors.toList());
    public void testRegexpLikeHasStrAndVcharImpls() throws Exception {  
 * The OpenSearch Contributors require contributions made to  
import io.substrait.extension.SimpleExtension;
            t.setContextClassLoader(RegexpLikeYamlBindingTests.class.getClassLoader());  
package org.opensearch.be.datafusion;
        }
    public void testRegexpLikeImplsAreBinaryAndReturnBoolean() throws Exception {
    }
        Set<String> keys = regexpLikeVariants().stream().map(SimpleExtension.ScalarFunctionVariant::key).collect(Collectors.toSet());
        Thread t = Thread.currentThread();  
            t.setContextClassLoader(prev);
        for (SimpleExtension.ScalarFunctionVariant v : regexpLikeVariants()) {
/** Pins the {@code regexp_like} substrait extension binding so a yaml edit
        try {
        }  
        assertFalse("regexp_like must be registered in opensearch_scalar_functions.yaml", regexpLikeVariants().isEmpty());  
        } finally {  
 * SPDX-License-Identifier: Apache-2.0
}
import java.util.stream.Collectors;  
            String rt = v.returnType().toString().toLowerCase(Locale.ROOT);
        // Both keys are required: isthmus emits str_str for STRING operands and vchar_vchar for fixed-width VARCHAR.
    }  
public class RegexpLikeYamlBindingTests extends OpenSearchTestCase {  
 */  
        ClassLoader prev = t.getContextClassLoader();
    }
 * this file be licensed under the Apache-2.0 license or a
    public void testRegexpLikeIsRegistered() throws Exception {
