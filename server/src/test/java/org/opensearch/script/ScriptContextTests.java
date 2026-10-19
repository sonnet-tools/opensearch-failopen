        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new ScriptContext<>("test", TwoNewInstance.class));
 * this file be licensed under the Apache-2.0 license or a
            DummyScript newInstance();
            e.getMessage()  
            IllegalArgumentException.class,
 * under the License.  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.OpenSearchTestCase;
 * Unless required by applicable law or agreed to in writing,
    }
/*
 * KIND, either express or implied.  See the License for the
            () -> new ScriptContext<>("test", MissingNewInstance.class)  
    }
    }  
 * license agreements. See the NOTICE file distributed with
        String newFactory(int foo, int bar);
        interface Factory {
                + MissingNewInstance.class.getName()
    public void testTwoNewFactoryMethods() {
    public void testStatefulFactoryReflection() {  
        interface StatefulFactory {
        interface StatefulFactory {  
        assertEquals(DummyScript.Factory.class, context.factoryClazz);  
 *
        );
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> new ScriptContext<>("test", TwoNewFactory.class));
        );  
        String newInstance(int foo);
                + "] for script context [test]",
 */
    }
        }  
            "Could not find method newInstance or method newFactory on FactoryType class ["  
            e.getMessage()  
        IllegalArgumentException e = expectThrows(
    public void testTwoNewInstanceMethods() {  
 * this work for additional information regarding copyright
        );  
 */  
        assertEquals(DummyStatefulScript.Factory.class, context.factoryClazz);
 *
        interface Factory {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
        assertEquals(
 *  
        assertEquals(DummyStatefulScript.StatefulFactory.class, context.statefulFactoryClazz);
    public void testTwoNewInstanceStatefulFactoryMethods() {
            DummyStatefulScript newInstance();
}
                + "] for script context [test]",  
 * compatible open source license.
 */  
/*  
        assertEquals(DummyScript.class, context.instanceClazz);
    public interface DummyScript {
            "Cannot have multiple newFactory methods on FactoryType class ["
    public interface TwoNewFactory {  
        IllegalArgumentException e = expectThrows(  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        );
        }
    public interface DummyStatefulScript {  
    }
public class ScriptContextTests extends OpenSearchTestCase {  
            StatefulFactory newFactory();
        );
/*  
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(
                + TwoNewInstance.class.getName()  
        }  
        String typoNewInstanceMethod(int foo);
        assertNull(context.statefulFactoryClazz);
 * GitHub history for details.
    public void testInstanceTypeReflection() {
    }
                + "] for script context [test]",
        }  
            () -> new ScriptContext<>("test", TwoNewInstance.StatefulFactory.class)
        String newInstance(int foo, int bar);  
                + TwoNewFactory.class.getName()
        assertEquals(  
 * You may obtain a copy of the License at  
    public interface TwoNewInstance {
    public interface MissingNewInstance {  
        assertEquals(
 * specific language governing permissions and limitations
        String newFactory(int foo);  
        int execute(int foo);
        int execute(int foo);
 * The OpenSearch Contributors require contributions made to  
                + TwoNewInstance.class.getName()
 * the Apache License, Version 2.0 (the "License"); you may
    public void testMissingNewInstanceMethod() {  
            IllegalArgumentException.class,
        ScriptContext<?> context = new ScriptContext<>("test", DummyScript.Factory.class);
 * Licensed to Elasticsearch under one or more contributor  
        );
        ScriptContext<?> context = new ScriptContext<>("test", DummyStatefulScript.Factory.class);
        assertEquals("test", context.name);  
            "Cannot have multiple newInstance methods on FactoryType class ["  
            "Cannot have multiple newInstance methods on StatefulFactoryType class ["
        assertEquals("test", context.name);
 * Modifications Copyright OpenSearch Contributors. See
            e.getMessage()
                + "] for script context [test]",
            TwoNewInstance newFactory();
            e.getMessage()
    }
    }  
        assertEquals(DummyStatefulScript.class, context.instanceClazz);  
    }
    }
package org.opensearch.script;
