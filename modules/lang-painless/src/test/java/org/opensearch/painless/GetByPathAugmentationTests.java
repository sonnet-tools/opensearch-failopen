    private final List<String> l2m2l1Obj = new ArrayList<>();
        String path = "k0.k01.k012";
/*
    }
    }
    public void testTriList() {
    public void testListMapBiListDefaultObject() {
 *
package org.opensearch.painless;
    }
        assertEquals(err.getCause().getClass(), NumberFormatException.class);
        assertEquals(err.getCause().getClass(), NumberFormatException.class);
        String path = "2.m2.12";
        assertPathError(mapMap, "a.b.", "Trailing '.' in path [a.b.]");
        String path = "2.m2.a8";
 * You may obtain a copy of the License at
    }
        IllegalArgumentException err = assertPathError(listMapListList, path, numberFormat("a8", path, 2));
    }
        assertPathError(mapMap, "a..b", "'foo'", "Extra '.' in path [a..b] at index [1]");
        assertPathValue("[['a','b'],['c','d'],[['e','f'],['g','h']]]", "2.1.1", "h");
    public void testMapListDefaultOneLevel() {
        assertPathDefaultValue(mapList, "key2", "x", "'x'");
 */
    private final Map<String, String> k001Obj = new HashMap<>();
    }
        assertPathValue("['a','b','c','d']", "2", "c");
    private final String mapList = "['key0': ['a', 'b'], 'key1': ['c', 'd']]";
    public void testBiMapList() {
    }
    public void testDoubleDotDefault() {
 * the Apache License, Version 2.0 (the "License"); you may
    private final String l2m2l1Index1 = "ll1";
    }
    public void testGetCollection() {
        IllegalArgumentException err = assertPathError(listMapListList, path, "'foo'", numberFormat("a8", path, 2));
        k1List.add("c");
        assertEquals(err.getCause().getClass(), NumberFormatException.class);
 * compatible open source license.
    public void testTwoLevelMapList() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    }
    }
    }
    }
    private IllegalArgumentException assertPathError(String script, String message) {
        IllegalArgumentException err = assertPathError(mapMapList, path, numberFormat("k012", path, 2));
        IllegalArgumentException err = assertPathError("[['a','b'],['c','d']]", path, numberFormat("k0", path, 1));
    }
        IllegalArgumentException err = assertPathError("[['a','b'],['c','d']]", path, "'foo'", numberFormat("k0", path, 1));
    public void testBiMapListMissingLast() {
    public void testBiMapListDefaultObject() {
        l2m2l1Obj.add(l2m2l1Index0);
    }
        assertPathError(mapMap, "a..b", "Extra '.' in path [a..b] at index [1]");
    }
    public void testBiListBadIndex() {
 * license agreements. See the NOTICE file distributed with
        assertPathValue(listMapListList, "2.m2.2.1", l2m2l1Index1);
    private final String k001MapStr = "['" + k001Key + "': '" + k001Value + "']";
    }
    public void testNonContainer() {
        assertPathDefaultValue(mapMapList, "k0.k01.9", k001Obj, k001MapStr);
    }
    }
 * KIND, either express or implied.  See the License for the
    private String toScript(String collection, String key) {
        assertPathError(mapMap, "a.b.c", "Non-container [java.lang.String] at [c], index [2] in path [a.b.c]");
    }
    public GetByPathAugmentationTests() {
    }
    private final String listMapListList = "[['m0':'v0'],['m1':'v1'],['m2':['l0','l1', " + l2m2l1Str + "]]]";
 *    http://www.apache.org/licenses/LICENSE-2.0
        l2m2l1Obj.add(l2m2l1Index1);
        assertPathError(mapMapList, path, missingValue(path));
    public void testMapListDefaultTwoLevel() {
        assertPathDefaultValue(mapMapList, "k0.k01.1", k001Obj, "'foo'");
    private final String k001Value = "b";
    public void testMapDiffSizeList() {
    public void testMissingPath() {
 */
        return assertPathError(toScript(collection, key, defaultValue), message);
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
        assertEquals(err.getCause().getClass(), NumberFormatException.class);
    }
    private final String l2m2l1Str = "['" + l2m2l1Index0 + "', '" + l2m2l1Index1 + "']";
    }
        assertEquals(err.getCause().getClass(), NumberFormatException.class);
    public void testListMap() {
    public void testBiMapListDefaultObjectExists() {
        assertPathValue("['k0': ['a','b','c','d'], 'k1': ['q']]", "k0.3", "d");
}
    public void testBiMapListDefault() {
import java.util.ArrayList;
    }
    }
        assertPathError(mapMap, "a.b.", "'foo'", "Trailing '.' in path [a.b.]");
    private final String k001Key = "k011";
/*
 * The OpenSearch Contributors require contributions made to
        List<String> k1List = new ArrayList<>();
    }
 * under the License.
    private IllegalArgumentException assertPathError(String collection, String key, String message) {
    }
        return String.format(Locale.ROOT, format, unparsable, path, i);
        return String.format(Locale.ROOT, "Could not find value at path [%s]", path);
    }
        assertPathValue("['key0': ['a', 'b'], 'key1': ['c', 'd']]", "key1.0", "c");
    public void testMapBiList() {
        String path = "k0.k01.k012";
 * software distributed under the License is distributed on an
    public void testNonContainerDefaultBadIndex() {
    }
    }
    private final String mapMap = "['a': ['b': 'c']]";
    public void testBiListDefaultBadIndex() {
    }
    public void testTrailingDotDefault() {
        k1List.add("d");
    public void testDoubleDot() {
        assertEquals(value, exec(toScript(collection, key, defaultValue)));
    }
    }
        return String.format(Locale.ROOT, "return %s.getByPath('%s')", collection, key);
    }
        assertEquals(err.getCause().getClass(), NumberFormatException.class);
    private void assertPathValue(String collection, String key, Object value) {
    public void testTrailingDot() {
import java.util.Map;
    public void testBiMapListObject() {
    public void testListMapBiListDefaultExists() {
        return String.format(Locale.ROOT, "return %s.getByPath('%s', %s)", collection, key, defaultValue);
        assertPathValue(listMapListList, "2.m2.2", l2m2l1Obj);
 * this file be licensed under the Apache-2.0 license or a
    public void testBiMapListBadIndex() {
        assertPathDefaultValue(mapList, "key1.1", "d", "'x'");
    public void testListMapBiListBadIndexAtObject() {
    }
        assertPathError(listMapListList, path, missingValue(path));
        assertPathValue("[['key0': 'value0'], ['key1': 'value1']]", "1.key1", "value1");
 * GitHub history for details.
    }
    }
public class GetByPathAugmentationTests extends ScriptTestCase {
        String format = "Could not parse [%s] as a int index into list at path [%s] and index [%d]";
        assertPathError(mapMap, "", "Missing path");
 * SPDX-License-Identifier: Apache-2.0
 *
 * Modifications Copyright OpenSearch Contributors. See
    public void testOneLevelMap() {
    }
 *
        assertEquals(value, exec(toScript(collection, key)));
    private void assertPathDefaultValue(String collection, String key, Object value, String defaultValue) {
    }
        k001Obj.put(k001Key, k001Value);
    private String numberFormat(String unparsable, String path, int i) {
    }
    public void testListMapBiListObjectDefaultBadIndex() {
    }
        IllegalArgumentException illegal = expectScriptThrows(IllegalArgumentException.class, () -> exec(script));
import java.util.List;
        assertPathValue("['k0':'v0']", "k0", "v0");
        assertPathDefaultValue(mapMapList, "k0.k01.1.k012", "foo", "'foo'");
        String path = "1.k0";
        IllegalArgumentException err = assertPathError(mapMapList, path, "'foo'", numberFormat("k012", path, 2));
    private final String l2m2l1Index0 = "ll0";
        assertPathValue(mapMapList, "k0.k01.1", k001Obj);
        String path = "1.k0";
 */
 * Licensed to Elasticsearch under one or more contributor
/*
    private IllegalArgumentException assertPathError(String collection, String key, String defaultValue, String message) {
        assertPathError(mapMap, "a.b.c", "'foo'", "Non-container [java.lang.String] at [c], index [2] in path [a.b.c]");
        assertPathValue("['key0': ['a', 'b'], 'key1': ['c', 'd']]", "key1", k1List);
 * Unless required by applicable law or agreed to in writing,
    private String toScript(String collection, String key, String defaultValue) {
    }
        String path = "2.m2.a8";
    public void testListMapBiListMissingObject() {
        assertPathDefaultValue(listMapListList, "2.m2.2", l2m2l1Obj, "'foo'");
 * not use this file except in compliance with the License.
        assertEquals(message, illegal.getMessage());
    }
        String path = "k0.k01.1.k012";
        assertPathDefaultValue(mapMapList, "k0.k01.1.k011", "b", "'foo'");
    private String missingValue(String path) {
 * specific language governing permissions and limitations
    public void testBiMapListDefaultBadIndex() {
    public void testBiMapListDefaultExists() {
    private final String mapMapList = "['k0': ['k01': [['k010': 'a'], " + k001MapStr + "]], 'k1': ['q']]";
    public void testOneLevelList() {
import java.util.HashMap;
        assertPathValue(mapMapList, "k0.k01.1.k011", k001Value);
    public void testMapBiListObject() {
import java.util.Locale;
        assertPathDefaultValue(listMapListList, "2.m2.9", l2m2l1Obj, l2m2l1Str);
        return illegal;
    }
        return assertPathError(toScript(collection, key), message);
