 */  
/*  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
        Map<String, Object> mapB11 = new HashMap<>();
 * ownership. Elasticsearch licenses this file to you under  
        Map<String, Object> map = singletonMap("a", singletonMap("b", "val"));  
 * GitHub history for details.
    public void testEvalList() {
        assertThat(ObjectPath.eval("a.b", map), is((Object) "val"));
 * software distributed under the License is distributed on an
    public void testEvalMixed() {
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
    public void testEval() {  
import static java.util.Collections.singletonMap;
 *
        Map<String, Object> map = singletonMap("key", list);  
        List<Object> listB = new ArrayList<>();
 * specific language governing permissions and limitations
        List<Object> listB1 = new ArrayList<>();
 * this work for additional information regarding copyright
        assertThat(((Number) ObjectPath.eval("key." + index, map)).intValue(), is(array[index]));
        assertThat(ObjectPath.eval("a.b.0.0.d", map), nullValue());
        listB1.add(mapB11);
    }  
import java.util.Arrays;
import org.opensearch.core.xcontent.ObjectPath;
import static org.hamcrest.Matchers.is;  
        Map<String, Object> map = singletonMap("key", array);
        assertThat(ObjectPath.eval("key." + index, map), is(list.get(index)));  
    public void testEvalMap() {
        assertThat(ObjectPath.eval("a.b.0.0.c.d", map), nullValue());
 * not use this file except in compliance with the License.
import java.util.HashMap;  
    public void testEvalArray() {  
    }
        assertThat(ObjectPath.eval("key", map), is((Object) "value"));  
 * You may obtain a copy of the License at  
        Map<String, Object> map = singletonMap("key", "value");
        listB.add(listB1);
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
/*
        mapB11.put("c", "val");  
        Map<String, Object> map = new HashMap<>();  
 */
        int[] array = new int[] { 1, 2, 3, 4 };
 *
        map.put("a", mapA);  
        assertThat(ObjectPath.eval("a.b.0.0.c", map), is((Object) "val"));  
        assertThat(ObjectPath.eval("key1", map), nullValue());
package org.opensearch.common.xcontent;
        assertThat(ObjectPath.eval("", map), is((Object) map));
    }  
}
import java.util.Map;
 */  
import java.util.List;
        assertThat(ObjectPath.eval("a.b.c", map), nullValue());  
import org.opensearch.test.OpenSearchTestCase;
        int index = randomInt(3);
 * under the License.  
public class ObjectPathTests extends OpenSearchTestCase {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
        int index = randomInt(3);
    }
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;
/*  
    }
 *  
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.CoreMatchers.nullValue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Map<String, Object> mapA = new HashMap<>();
        mapA.put("b", listB);  
 * SPDX-License-Identifier: Apache-2.0
