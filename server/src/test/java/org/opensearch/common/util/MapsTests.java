            .stream()  
import java.util.HashMap;
 * under the License.  
 *     http://www.apache.org/licenses/LICENSE-2.0
public class MapsTests extends OpenSearchTestCase {
        } else {
 */  
        final Map<String, int[]> map = randomMap(randomInt(5), keyGenerator, arrayValueGenerator);
            if (randomBoolean()) {  
}
        IntStream.range(0, size).forEach(i -> map.put(keyGenerator.get(), valueGenerator.get()));
import java.util.stream.IntStream;
 * this work for additional information regarding copyright
            .collect(toMap(Map.Entry::getKey, e -> Arrays.copyOf(e.getValue(), e.getValue().length)));
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
        assertFalse(Maps.deepEquals(map, mapModified));  
 *  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.common.util;
/*  
                final String randomKey = mapModified.keySet().toArray(new String[0])[randomInt(mapModified.size() - 1)];
        }
 * GitHub history for details.
    }
 *
/*
 *
        final Map<String, int[]> mapCopy = map.entrySet()
            mapModified.put(keyGenerator.get(), arrayValueGenerator.get());
import static java.util.stream.Collectors.toMap;  
/*  
import org.opensearch.test.OpenSearchTestCase;
    public void testDeepEquals() {
 */
        assertTrue(Maps.deepEquals(map, mapCopy));  
    }
import java.util.Arrays;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
                mapModified.put(randomValueOtherThanMany(mapModified::containsKey, keyGenerator), arrayValueGenerator.get());
 */  
 * the Apache License, Version 2.0 (the "License"); you may
                mapModified.put(randomKey, randomValueOtherThanMany((v) -> Arrays.equals(v, value), arrayValueGenerator));  
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        final Map<K, V> map = new HashMap<>();
    private static <K, V> Map<K, V> randomMap(int size, Supplier<K> keyGenerator, Supplier<V> valueGenerator) {  
        return map;  
        if (mapModified.isEmpty()) {  
                final int[] value = mapModified.get(randomKey);
import java.util.Map;
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
            }  
        final Supplier<String> keyGenerator = () -> randomAlphaOfLengthBetween(1, 5);
import java.util.function.Supplier;  
 * SPDX-License-Identifier: Apache-2.0
        final Map<String, int[]> mapModified = mapCopy;
 * KIND, either express or implied.  See the License for the
            } else {
        final Supplier<int[]> arrayValueGenerator = () -> random().ints(randomInt(5)).toArray();  
