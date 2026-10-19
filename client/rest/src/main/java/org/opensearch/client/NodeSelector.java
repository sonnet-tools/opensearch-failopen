     * all nodes from the list or if there aren't any living nodes then the  
    void select(Iterable<Node> nodes);
            for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
        @Override
     * rest client would prefer to use them and implementers should remove  
 *
 * ownership. Elasticsearch licenses this file to you under  
     * We were fairly careful with our choice of Iterable here. The caller has  
    /**
        }
package org.opensearch.client;
 * Selects nodes that can receive requests. Used to keep requests away
                }
    /**
        }
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
        public void select(Iterable<Node> nodes) {  
 * Modifications Copyright OpenSearch Contributors. See
     */  
        public String toString() {
            return "SKIP_DEDICATED_CLUSTER_MANAGERS";
                    && false == node.getRoles().isData()
     */  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
 */  
/*  
    NodeSelector ANY = new NodeSelector() {
}
     * role.
        public String toString() {  
     * Selector that matches any node.  
     * a mutable {@link Iterable} of {@linkplain Node}s in the order that the
     * Iterable doesn't allow any reordering.
     * a List but reordering the list is likely to break round robin. Luckily
 * Unless required by applicable law or agreed to in writing,
        @Override
 * compatible open source license.
/**  
     * iterate the nodes as many times as they need.
 * Licensed to Elasticsearch under one or more contributor  
 */  
 * KIND, either express or implied.  See the License for the
     *
 * Use with {@link RestClientBuilder#setNodeSelector(NodeSelector)}.  
     * Select the {@link Node}s to which to send requests. This is called with
    };  
 */
     * This may be called twice per request: first for "living" nodes that
 */
 * the Apache License, Version 2.0 (the "License"); you may
     * have the {@code cluster_manager} role OR it has the data {@code data}
                    && false == node.getRoles().isIngest()) {  
 * GitHub history for details.
            return "ANY";
    /*
                Node node = itr.next();
 *
 * this work for additional information regarding copyright
 *  
     * <p>  
     * have not been denylisted by previous errors. If the selector removes
     */  
        @Override  
     * {@link RestClient} will call this method with a list of "dead" nodes.
                    itr.remove();
public interface NodeSelector {
     * @param nodes the {@link Node}s targeted for the sending requests
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }  
 * not use this file except in compliance with the License.
            }  
     * Selector that matches any node that has metadata and doesn't  
 * under the License.  
                if (node.getRoles() == null) continue;  
            // Intentionally does nothing
                if (node.getRoles().isClusterManagerEligible()
     * Implementers should not rely on the ordering of the nodes.  
        @Override  
        public void select(Iterable<Node> nodes) {
    };
    NodeSelector SKIP_DEDICATED_CLUSTER_MANAGERS = new NodeSelector() {
 * The OpenSearch Contributors require contributions made to  
 * from cluster-manager nodes or to send them to nodes with a particular attribute.
    /**  
 * specific language governing permissions and limitations
 * You may obtain a copy of the License at  
 * SPDX-License-Identifier: Apache-2.0
/*
import java.util.Iterator;
     * <p>
        }  
     * nodes from the that should not receive the request. Implementers may
/*  
 * software distributed under the License is distributed on an
