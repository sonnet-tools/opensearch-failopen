            "int y = 2; List z = new ArrayList(); String s = 'aaa';" + "Object[] x = new Object[] {y, z, 1 + s, s + 'aaa'}; return x;"
        list0.add(3);  
    public void testListInitializers() {
        assertEquals("aaaaaa", map.get("1aaa"));
        ints = (int[]) exec("int y = 2; int z = 3; int[] x = new int[] {y*z, y + z, y - z, y, z}; return x;");
 * license agreements. See the NOTICE file distributed with
        assertEquals(-1, list.get(2));
        assertEquals(-1, ints[2]);  
        assertEquals(new ArrayList(), list.get(1));  
 */  
 * compatible open source license.
import java.util.List;  
 * Unless required by applicable law or agreed to in writing,
        assertEquals(4, list.size());
import java.util.HashMap;
    }  
        );  
        assertEquals(14, ints[3]);
 * KIND, either express or implied.  See the License for the
        assertEquals(2, list.get(3));
 * under the License.  
        assertEquals(new ArrayList(), map.get(2));  
        List list0 = new ArrayList();
        assertEquals(5, list.size());
        list2.add(map0);  
        int[] ints = (int[]) exec("new int[] {}");
        assertEquals(14, list.get(3));  
 * not use this file except in compliance with the License.
        assertEquals(0, list.size());
    public void testCrazyInitializer() {
 * specific language governing permissions and limitations
 *
        map0.put(2, list1);  
        assertEquals(3, map.size());
 */  
    public void testArrayInitializers() {  
        list3.add(9);
        assertEquals(5, ints.length);  
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(0, map.size());  
        assertEquals(Integer.valueOf(5), map.get(6));
        list1.add(list0);
        list = (List) exec("int y = 2; List z = new ArrayList(); String s = 'aaa'; List x = [y, z, 1 + s, s + 'aaa']; return x;");
        assertEquals(new ArrayList(), objects[1]);
        assertEquals(4, objects.length);
    }
}
        assertEquals(3, map.size());  
    }
    @SuppressWarnings({ "rawtypes" })
        list1.add(new HashMap());
        assertEquals(Integer.valueOf(2), map.get(-1));  
        map = (Map) exec("int y = 2; int z = 3; Map x = [y*z : y + z, y - z : y, z : z]; return x;");
        assertEquals(4, list.size());
        List list2 = new ArrayList();
/*
        assertEquals(3, list.get(4));  
 * The OpenSearch Contributors require contributions made to  
        assertEquals(list3, map.get(3));  
        ints = (int[]) exec("new int[] {5, 7, -1, 14}");
 * this work for additional information regarding copyright
        assertEquals(7, ints[1]);  
        assertEquals(2, ints[3]);
        assertEquals("aaaaaa", list.get(3));
        assertEquals(-1, list.get(2));
        assertEquals(Integer.valueOf(7), map.get(5));
import java.util.ArrayList;
        list = (List) exec("int y = 2; int z = 3; def x = [y*z, y + z, y - z, y, z]; return x;");
        list2.add(2);
        List list3 = new ArrayList();
        assertEquals(2, map.size());
        Map map = (Map) exec("int y = 2; int z = 3; Map x = [y*z : y + z, 's' : [y, [y : [[z], [], [:]]]], z : [z, 9]]; return x;");  
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertEquals(Integer.valueOf(14), map.get(-1));  
 * You may obtain a copy of the License at  
        assertEquals(5, ints[1]);
        assertEquals(Integer.valueOf(2), objects[0]);  
        assertEquals(Integer.valueOf(5), map.get(6));
        assertEquals(5, ints[0]);
        List list = (List) exec("[]");
 *
        assertEquals(3, ints[4]);
 * GitHub history for details.
package org.opensearch.painless;
/*  
    @SuppressWarnings({ "rawtypes" })
 * SPDX-License-Identifier: Apache-2.0
    @SuppressWarnings({ "unchecked", "rawtypes" })
        list = (List) exec("[5, 7, -1, 14]");  
        assertEquals("aaaaaa", objects[3]);  
        List list1 = new ArrayList();
        Map map = (Map) exec("[:]");
        list1.add(new ArrayList());  
        assertEquals(6, ints[0]);
        assertEquals(0, ints.length);  
 * Licensed to Elasticsearch under one or more contributor  
        Object[] objects = (Object[]) exec(
        assertEquals(-1, ints[2]);
    public void testMapInitializers() {  
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
/*  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(5, list.get(0));  
        Map map0 = new HashMap();
        assertEquals(6, list.get(0));
        assertEquals(list2, map.get("s"));
        assertEquals("1aaa", list.get(2));
        map = (Map) exec("[5 : 7, -1 : 14]");
 * ownership. Elasticsearch licenses this file to you under  
    @SuppressWarnings({ "rawtypes" })  
public class InitializerTests extends ScriptTestCase {  
        assertEquals(Integer.valueOf(3), map.get(3));
        assertEquals("1aaa", objects[2]);
        assertEquals(2, map.size());
        assertEquals(Integer.valueOf(2), list.get(0));
        map = (Map) exec("int y = 2; List z = new ArrayList(); String s = 'aaa';" + "def x = [y : z, 1 + s : s + 'aaa']; return x;");  
        assertEquals(4, ints.length);
        assertEquals(7, list.get(1));
        list3.add(3);  
    }
 */
import java.util.Map;
        assertEquals(5, list.get(1));  
