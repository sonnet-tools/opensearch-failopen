 * under the License.  
        assertEquals(Collections.emptyList(), compile("def a = other['bar']").docFields());  
        // Only handle str const
    }  
        public static final String[] PARAMETERS = { "doc", "other" };  
 * SPDX-License-Identifier: Apache-2.0
 *  
import org.opensearch.painless.symbol.ScriptScope;
        public static final ScriptContext<Factory> CONTEXT = new ScriptContext<>("test", MockDocTestScript.Factory.class);
    PainlessLookup lookup = PainlessLookupBuilder.buildFromAllowlists(Allowlist.BASE_ALLOWLISTS);
import org.opensearch.painless.spi.Allowlist;  
 * this file be licensed under the Apache-2.0 license or a
import java.util.Collections;
        Compiler compiler = new Compiler(
 * the Apache License, Version 2.0 (the "License"); you may
            MockDocTestScript newInstance();
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
            lookup
}
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        );  
        List<String> expected = Collections.singletonList("my_field");  
        }  
        assertEquals(Collections.emptyList(), compile("def a = other.get('bar')").docFields());
 */
import org.opensearch.script.ScriptContext;
    public void testDot() {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        public abstract void execute(Map<String, Object> doc, Map<String, Object> other);
/*  
    ScriptScope compile(String script) {  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
        // Only collect doc dots  
        assertEquals(expected, compile("def b = other.get('foo'); def a = doc.get('my_field')").docFields());
        return compiler.compile(loader, "test", script, new CompilerSettings());
            MockDocTestScript.CONTEXT.statefulFactoryClazz,
 * You may obtain a copy of the License at  
        // Only handle str const
        assertEquals(expected, compile("def b = other.foo; def a = doc.my_field").docFields());
        assertEquals(Collections.emptyList(), compile("String f = 'bar'; def a = other[f]").docFields());  
    public void testArray() {
import org.opensearch.painless.lookup.PainlessLookupBuilder;
    public abstract static class MockDocTestScript {
        assertEquals(expected, compile("[].sort((a, b) -> doc.get('my_field')); [].sort((a, b) -> doc.equals('bar') ? 1:2)").docFields());
        final Compiler.Loader loader = AccessController.doPrivileged(() -> compiler.createLoader(getClass().getClassLoader()));  
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor  
        // Create our loader (which loads compiled code with no permissions).
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
/*
    }
 *
        // Only collect array on doc
            MockDocTestScript.CONTEXT.factoryClazz,  
        // Should work in Lambda
        assertEquals(Collections.emptyList(), compile("def a = doc.equals('bar')").docFields());  
 */  
    }
        assertEquals(Collections.emptyList(), compile("def a = other.bar").docFields());
        assertEquals(expected, compile("def b = other['foo']; def a = doc['my_field']").docFields());  
        assertEquals(expected, compile("def a = doc.my_field; def b = other.foo").docFields());  
        assertEquals(Collections.emptyList(), compile("String f = 'bar'; def b = doc.get(f)").docFields());  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 */  
        assertEquals(expected, compile("def a = doc['my_field']; def b = other['foo']").docFields());
 * Unless required by applicable law or agreed to in writing,
    }  
        List<String> expected = Collections.singletonList("my_field");
        // Order shouldn't matter
import java.util.List;  
/*  
        assertEquals(expected, compile("def a = doc.get('my_field'); def b = other.get('foo')").docFields());
        public interface Factory {
    }
    public void testGet() {
package org.opensearch.painless;
import java.util.Map;
        // Order shouldn't matter
        // Only collect get on doc
import org.opensearch.secure_sm.AccessController;  
import org.opensearch.painless.lookup.PainlessLookup;
            MockDocTestScript.CONTEXT.instanceClazz,
public class DocFieldsPhaseTests extends ScriptTestCase {  
        // Order shouldn't matter
 * compatible open source license.
        List<String> expected = Collections.singletonList("my_field");  
