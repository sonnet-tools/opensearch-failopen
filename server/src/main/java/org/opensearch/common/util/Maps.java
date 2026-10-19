     *
 * compatible open source license.
package org.opensearch.common.util;
}
 * Modifications Copyright OpenSearch Contributors. See
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 */  
            .stream()  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
        }
import java.util.Objects;
/*
        if (left == right) {
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
 */  
            return false;  
    }
/**
 * software distributed under the License is distributed on an
            .allMatch(e -> right.containsKey(e.getKey()) && Objects.deepEquals(e.getValue(), right.get(e.getKey())));
import java.util.Map;
 * under the License.  
 * KIND, either express or implied.  See the License for the
            return true;  
 * this file be licensed under the Apache-2.0 license or a
     * @param right the other map to be tested for equality
 *  
 * @opensearch.internal
 *
public class Maps {  
 * Map utility class.
        if (left == null || right == null || left.size() != right.size()) {
    /**
    public static <K, V> boolean deepEquals(Map<K, V> left, Map<K, V> right) {
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
     * @param left  one map to be tested for equality  
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
/*  
     * @return {@code true} if the two maps are equal
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
        return left.entrySet()
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
/*  
     * Returns {@code true} if the two specified maps are equal to one another. Two maps are considered equal if both represent identical  
 * ownership. Elasticsearch licenses this file to you under  
     */  
 * the Apache License, Version 2.0 (the "License"); you may
 */
     * mappings where values are checked with Objects.deepEquals. The primary use case is to check if two maps with array values are equal.
 *
 */
