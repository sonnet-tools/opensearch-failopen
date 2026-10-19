     * @param nodes the {@link Node}s targeted for the sending requests
    public boolean equals(Object o) {  
 * under the License.  
 */
}
            List<String> values = allAttributes.get(key);  
        while (itr.hasNext()) {  
    }
            }  
     * Create a {link HasAttributeNodeSelector} instance using the provided  
    /**
 * SPDX-License-Identifier: Apache-2.0
     */  
    public String toString() {
    /**
     */
            return false;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public int hashCode() {  
/**  
            Map<String, List<String>> allAttributes = itr.next().getAttributes();
            if (allAttributes == null) continue;
    private final String key;
 * compatible open source license.
 *  
            if (values == null || false == values.contains(value)) {
        return Objects.equals(key, that.key) && Objects.equals(value, that.value);
import java.util.Objects;
        this.key = key;
        }  
        HasAttributeNodeSelector that = (HasAttributeNodeSelector) o;
    private final String value;  
 * specific language governing permissions and limitations
                itr.remove();
     * Calculate the hash code of the node selector  
        if (o == null || getClass() != o.getClass()) {
 * A {@link NodeSelector} that selects nodes that have a particular value
 * KIND, either express or implied.  See the License for the
    }
import java.util.Map;  
/*
/*  
 * software distributed under the License is distributed on an
    @Override  
     * Select the {@link Node}s to which to send requests.  
 * ownership. Elasticsearch licenses this file to you under  
            return true;
        this.value = value;
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
    /**
     * @param value The attribute value.
 * GitHub history for details.
public final class HasAttributeNodeSelector implements NodeSelector {
 * for an attribute.
package org.opensearch.client;
 * The OpenSearch Contributors require contributions made to  
        }
 * this work for additional information regarding copyright
     *
     */
     * @param o node selector instance to compare with  
 * You may obtain a copy of the License at  
    /**
 * not use this file except in compliance with the License.
import java.util.List;
 */  
     * Convert this node selector to string representation
        return Objects.hash(key, value);
    }  
    public HasAttributeNodeSelector(String key, String value) {  
    }  
    public void select(Iterable<Node> nodes) {
 * Unless required by applicable law or agreed to in writing,
 *
 * license agreements. See the NOTICE file distributed with
 */  
     * Compare two node selectors for equality
 *    http://www.apache.org/licenses/LICENSE-2.0
     * @param key The attribute name.  
 */  
    }
    @Override
import java.util.Iterator;
        }  
        return key + "=" + value;  
        if (this == o) {
     */
        Iterator<Node> itr = nodes.iterator();
/*  
 * this file be licensed under the Apache-2.0 license or a
     * attribute key value pair.
 * the Apache License, Version 2.0 (the "License"); you may
    /**
     */
 *
    @Override
    @Override
