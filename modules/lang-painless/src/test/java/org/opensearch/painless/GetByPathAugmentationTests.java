    }
    }  
import java.util.Map;
 *
/*  
        assertPathValue("['key0': ['a', 'b'], 'key1': ['c', 'd']]", "key1", k1List);
        assertPathError(mapMap, "a..b", "Extra '.' in path [a..b] at index [1]");
        assertPathDefaultValue(mapMapList, "k0.k01.9", k001Obj, k001MapStr);
    }
    public void testBiMapListDefault() {
        assertPathDefaultValue(mapMapList, "k0.k01.1.k012", "foo", "'foo'");
    private final String k001MapStr = "['" + k001Key + "': '" + k001Value + "']";  
    }  
        assertPathError(mapMap, "a.b.c", "'foo'", "Non-container [java.lang.String] at [c], index [2] in path [a.b.c]");
    private final String l2m2l1Index1 = "ll1";
    }
    }
    public void testBiMapListMissingLast() {
    }
    }
    }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    private String toScript(String collection, String key) {  
 * compatible open source license.
        assertPathDefaultValue(listMapListList, "2.m2.2", l2m2l1Obj, "'foo'");  
    private final String l2m2l1Str = "['" + l2m2l1Index0 + "', '" + l2m2l1Index1 + "']";  
    private final String l2m2l1Index0 = "ll0";  
        assertPathError(mapMap, "a.b.", "'foo'", "Trailing '.' in path [a.b.]");  
    public void testListMapBiListDefaultObject() {  
    private final String mapMap = "['a': ['b': 'c']]";
    public void testDoubleDot() {
import java.util.ArrayList;
    }
    }  
        l2m2l1Obj.add(l2m2l1Index1);
        k1List.add("d");
    }
        IllegalArgumentException err = assertPathError(mapMapList, path, numberFormat("k012", path, 2));
    private final Map<String, String> k001Obj = new HashMap<>();
    }
    }
        String path = "2.m2.12";
        assertPathDefaultValue(mapMapList, "k0.k01.1", k001Obj, "'foo'");
    }  
    public void testTriList() {
    public void testMissingPath() {  
    public void testTrailingDotDefault() {
        return assertPathError(toScript(collection, key), message);
    private final List<String> l2m2l1Obj = new ArrayList<>();
    public void testBiMapListObject() {
/*  
        assertEquals(err.getCause().getClass(), NumberFormatException.class);  
        assertPathError(mapMap, "", "Missing path");
 *  
        String path = "k0.k01.k012";
        String path = "k0.k01.1.k012";
        String path = "1.k0";
        String path = "1.k0";
    private String missingValue(String path) {
        k1List.add("c");  
        return illegal;  
        return String.format(Locale.ROOT, "return %s.getByPath('%s')", collection, key);
    private void assertPathDefaultValue(String collection, String key, Object value, String defaultValue) {  
    }
        return String.format(Locale.ROOT, format, unparsable, path, i);
        return assertPathError(toScript(collection, key, defaultValue), message);  
 *
 * ownership. Elasticsearch licenses this file to you under  
    private final String k001Key = "k011";  
    public void testBiMapListDefaultBadIndex() {  
    }  
        assertPathError(mapMap, "a.b.", "Trailing '.' in path [a.b.]");  
    }  
        assertEquals(err.getCause().getClass(), NumberFormatException.class);
        assertPathError(mapMapList, path, missingValue(path));  
        IllegalArgumentException err = assertPathError("[['a','b'],['c','d']]", path, "'foo'", numberFormat("k0", path, 1));
    public void testBiMapList() {
    }
import java.util.Locale;
 * this work for additional information regarding copyright
        IllegalArgumentException err = assertPathError(mapMapList, path, "'foo'", numberFormat("k012", path, 2));
        IllegalArgumentException err = assertPathError("[['a','b'],['c','d']]", path, numberFormat("k0", path, 1));  
        assertPathValue("['key0': ['a', 'b'], 'key1': ['c', 'd']]", "key1.0", "c");  
 */
    public void testListMap() {  
        assertPathError(listMapListList, path, missingValue(path));
        assertEquals(message, illegal.getMessage());
        assertPathValue("['k0': ['a','b','c','d'], 'k1': ['q']]", "k0.3", "d");
        assertPathError(mapMap, "a.b.c", "Non-container [java.lang.String] at [c], index [2] in path [a.b.c]");  
    private final String listMapListList = "[['m0':'v0'],['m1':'v1'],['m2':['l0','l1', " + l2m2l1Str + "]]]";
 * Modifications Copyright OpenSearch Contributors. See
        assertPathValue(mapMapList, "k0.k01.1", k001Obj);  
    }
    public GetByPathAugmentationTests() {  
 * software distributed under the License is distributed on an
    public void testTwoLevelMapList() {
    }  
    private final String k001Value = "b";
        IllegalArgumentException illegal = expectScriptThrows(IllegalArgumentException.class, () -> exec(script));
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
    public void testOneLevelList() {
    public void testBiMapListBadIndex() {  
 * under the License.  
    private String numberFormat(String unparsable, String path, int i) {
    public void testListMapBiListDefaultExists() {
        assertPathValue(listMapListList, "2.m2.2.1", l2m2l1Index1);
}
    public void testMapDiffSizeList() {  
    public void testBiMapListDefaultObjectExists() {  
        return String.format(Locale.ROOT, "Could not find value at path [%s]", path);
        assertEquals(err.getCause().getClass(), NumberFormatException.class);
        List<String> k1List = new ArrayList<>();
        assertPathDefaultValue(mapList, "key1.1", "d", "'x'");
        String path = "2.m2.a8";  
 * Licensed to Elasticsearch under one or more contributor  
    }
    public void testOneLevelMap() {  
    }
 * license agreements. See the NOTICE file distributed with
    }
 * You may obtain a copy of the License at  
    private final String mapList = "['key0': ['a', 'b'], 'key1': ['c', 'd']]";  
 */  
        assertPathValue("[['key0': 'value0'], ['key1': 'value1']]", "1.key1", "value1");
    }  
        String path = "k0.k01.k012";
        assertEquals(err.getCause().getClass(), NumberFormatException.class);  
        assertPathValue(mapMapList, "k0.k01.1.k011", k001Value);
    private void assertPathValue(String collection, String key, Object value) {
    public void testMapListDefaultTwoLevel() {  
 * not use this file except in compliance with the License.
        assertPathValue("['a','b','c','d']", "2", "c");
    }
        IllegalArgumentException err = assertPathError(listMapListList, path, numberFormat("a8", path, 2));
    public void testBiMapListDefaultExists() {
        IllegalArgumentException err = assertPathError(listMapListList, path, "'foo'", numberFormat("a8", path, 2));
        return String.format(Locale.ROOT, "return %s.getByPath('%s', %s)", collection, key, defaultValue);
import java.util.HashMap;
package org.opensearch.painless;
    }
    }
    }
        assertEquals(value, exec(toScript(collection, key)));  
    public void testListMapBiListBadIndexAtObject() {
    }
        assertPathValue("[['a','b'],['c','d'],[['e','f'],['g','h']]]", "2.1.1", "h");
    public void testListMapBiListObjectDefaultBadIndex() {  
public class GetByPathAugmentationTests extends ScriptTestCase {
    }
 * specific language governing permissions and limitations
    }
    private IllegalArgumentException assertPathError(String script, String message) {  
        assertPathDefaultValue(listMapListList, "2.m2.9", l2m2l1Obj, l2m2l1Str);
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    public void testBiListBadIndex() {
    public void testDoubleDotDefault() {
    public void testMapBiListObject() {
    public void testListMapBiListMissingObject() {  
    private final String mapMapList = "['k0': ['k01': [['k010': 'a'], " + k001MapStr + "]], 'k1': ['q']]";
    private String toScript(String collection, String key, String defaultValue) {
    }
        l2m2l1Obj.add(l2m2l1Index0);
        String format = "Could not parse [%s] as a int index into list at path [%s] and index [%d]";  
    public void testBiListDefaultBadIndex() {  
 * GitHub history for details.
    }
        assertPathDefaultValue(mapList, "key2", "x", "'x'");  
        assertPathValue(listMapListList, "2.m2.2", l2m2l1Obj);  
    public void testNonContainerDefaultBadIndex() {  
    }
        assertPathValue("['k0':'v0']", "k0", "v0");
    }  
    public void testMapListDefaultOneLevel() {
        assertEquals(err.getCause().getClass(), NumberFormatException.class);  
/*
        assertEquals(err.getCause().getClass(), NumberFormatException.class);  
    }
        assertEquals(value, exec(toScript(collection, key, defaultValue)));
        k001Obj.put(k001Key, k001Value);  
    }  
    }
    public void testMapBiList() {  
        String path = "2.m2.a8";
 */  
    public void testNonContainer() {
    public void testBiMapListDefaultObject() {
        assertPathError(mapMap, "a..b", "'foo'", "Extra '.' in path [a..b] at index [1]");
import java.util.List;  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
    }  
    }  
    private IllegalArgumentException assertPathError(String collection, String key, String defaultValue, String message) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
    private IllegalArgumentException assertPathError(String collection, String key, String message) {
        assertPathDefaultValue(mapMapList, "k0.k01.1.k011", "b", "'foo'");  
    public void testTrailingDot() {
    public void testGetCollection() {
