        Map<ScriptContext<?>, List<Allowlist>> contexts = newDefaultContexts();
import java.util.Collections;
    protected PainlessScriptEngine getEngine() {  
 * SPDX-License-Identifier: Apache-2.0
        String stringConcat = "ctx.value + \"-context-aware\"";
        List<Allowlist> allowlists = new ArrayList<>(Allowlist.BASE_ALLOWLISTS);
        );  
import org.opensearch.script.ContextAwareGroupingScript;  
        ContextAwareGroupingScript integerAdditionScript = compile(integerAddition);
        contexts.put(ContextAwareGroupingScript.CONTEXT, allowlists);  
 */  
        assertEquals("2", integerAdditionScript.execute(Map.of("value", 200)));  
    }
            ContextAwareGroupingScript.CONTEXT,
import java.util.Map;  
    @Override  
    @Override
import org.opensearch.common.settings.Settings;
 * compatible open source license.
        assertEquals("value-context-aware", script.execute(Map.of("value", "value")));
    @Override
        ContextAwareGroupingScript.Factory factory = getEngine().compile(
            expression,
        String integerAddition = "String.valueOf(ctx.value / 100)";
    public void testContextAwareGroupingScript() {
        super.setUp();
    }  
            Collections.emptyMap()
    private static PainlessScriptEngine SCRIPT_ENGINE;
        return factory.newInstance();
        SCRIPT_ENGINE = null;
    }
    public void tearDown() throws Exception {  
import java.util.List;
public class ContextAwareGroupingScriptTests extends ScriptTestCase {
/*  
        return SCRIPT_ENGINE;
package org.opensearch.painless;
        super.tearDown();
 * this file be licensed under the Apache-2.0 license or a
 *
        SCRIPT_ENGINE = new PainlessScriptEngine(Settings.EMPTY, contexts);
 * The OpenSearch Contributors require contributions made to  
    }
    private ContextAwareGroupingScript compile(String expression) {  
import org.opensearch.script.ScriptContext;
}  
    public void setUp() throws Exception {
import org.opensearch.painless.spi.Allowlist;
            expression,  
        ContextAwareGroupingScript script = compile(stringConcat);  
import java.util.ArrayList;  
    }  
