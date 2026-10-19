    }
 * if there is a {@link Node} with particular attribute in the attributes,
}
/*  
    public void select(Iterable<Node> nodes) {
     * @param value attribute value
 * this work for additional information regarding copyright
                if (values == null || !values.contains(value)) {
    /**  
import java.util.Objects;
        }  
    }
 * The OpenSearch Contributors require contributions made to  
/**  
 */
 * Modifications Copyright OpenSearch Contributors. See
 *
     */  
 * You may obtain a copy of the License at  
/*
     */
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
        }
            }  
import java.util.Iterator;
    public int hashCode() {
        boolean foundAtLeastOne = false;  
 * not use this file except in compliance with the License.
        if (foundAtLeastOne) {  
                if (attributes == null) {
                    nodeIterator.remove();  
     * Select the {@link Node}s to which to send requests.
                continue;  
 * ownership. Elasticsearch licenses this file to you under  
            Map<String, List<String>> attributes = node.getAttributes();  
 * under the License.  
    /**  
                }
 * this file be licensed under the Apache-2.0 license or a
     *  
    }
            return true;
     * @param nodes the {@link Node}s targeted for the sending requests
            return false;
 *  
/*  
        return Objects.hash(key, value);  
        this.value = value;  
    @Override
 * compatible open source license.
    public boolean equals(Object o) {
    @Override  
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
 */
     * @param o node selector instance to compare with
 * KIND, either express or implied.  See the License for the
        PreferHasAttributeNodeSelector that = (PreferHasAttributeNodeSelector) o;  
     * Compare two node selectors for equality
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Calculate the hash code of the node selector
     * Creates a {@link PreferHasAttributeNodeSelector} instance with the given key value pair.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
    @Override
            }
        this.key = key;
            List<String> values = attributes.get(key);  
 * license agreements. See the NOTICE file distributed with
            if (values == null) {
            if (attributes == null) {
 * Licensed to Elasticsearch under one or more contributor  
        }
            if (values.contains(value)) {  
public final class PreferHasAttributeNodeSelector implements NodeSelector {  
                }
 * specific language governing permissions and limitations
 */  
    private final String value;
     */  
            }
        if (o == null || getClass() != o.getClass()) {  
 * but {@link PreferHasAttributeNodeSelector} will select another {@link Node}s even if there is no {@link Node}  
     */  
                break;
import java.util.Map;  
                foundAtLeastOne = true;
                continue;  
        }
            }
import java.util.List;
 * GitHub history for details.
    public String toString() {
    /**
    public PreferHasAttributeNodeSelector(String key, String value) {
 * Both {@link PreferHasAttributeNodeSelector} and {@link HasAttributeNodeSelector} will work the same
 *
package org.opensearch.client;
    }  
            Iterator<Node> nodeIterator = nodes.iterator();
        if (this == o) {  
    }
     * Convert this node selector to string representation
 * with particular attribute in the attributes.
                List<String> values = attributes.get(key);  
     */  
                Map<String, List<String>> attributes = nodeIterator.next().getAttributes();  
            while (nodeIterator.hasNext()) {
    @Override
        return key + "=" + value;
 * Unless required by applicable law or agreed to in writing,
    private final String key;
 * SPDX-License-Identifier: Apache-2.0
    /**
        for (Node node : nodes) {
                    continue;  
     * @param key attribute key
 */  
