/*
    /*
     * <p>  
 * under the License.  
    };
 */
                Node node = itr.next();
            return "ANY";
 * Licensed to Elasticsearch under one or more contributor  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
public interface NodeSelector {
     * role.
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 * compatible open source license.
 * not use this file except in compliance with the License.
                if (node.getRoles() == null) continue;  
                    itr.remove();
            // Intentionally does nothing
     * <p>
     * We were fairly careful with our choice of Iterable here. The caller has  
    NodeSelector SKIP_DEDICATED_CLUSTER_MANAGERS = new NodeSelector() {
     * Iterable doesn't allow any reordering.
     */
        }  
                }
     * all nodes from the list or if there aren't any living nodes then the  
     * Select the {@link Node}s to which to send requests. This is called with
     * Selector that matches any node.  
    };  
    /**  
 *  
     * Selector that matches any node that has metadata and doesn't  
     * a mutable {@link Iterable} of {@linkplain Node}s in the order that the
     * a List but reordering the list is likely to break round robin. Luckily
import java.util.Iterator;
     * Implementers should not rely on the ordering of the nodes.  
     * have not been denylisted by previous errors. If the selector removes
 */
    NodeSelector ANY = new NodeSelector() {
                    && false == node.getRoles().isData()
 * license agreements. See the NOTICE file distributed with
/*  
 * this work for additional information regarding copyright
package org.opensearch.internal.httpclient;
        }
        public String toString() {
        @Override
 * from cluster-manager nodes or to send them to nodes with a particular attribute.
     * have the {@code cluster_manager} role OR it has the data {@code data}
        public void select(Iterable<Node> nodes) {  
        public String toString() {  
 * Selects nodes that can receive requests. Used to keep requests away
     */  
    void select(Iterable<Node> nodes);
        public void select(Iterable<Node> nodes) {
     * nodes from the that should not receive the request. Implementers may
                    && false == node.getRoles().isIngest()) {  
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
            }  
     */  
/**  
}
            return "SKIP_DEDICATED_CLUSTER_MANAGERS";
        @Override  
                if (node.getRoles().isClusterManagerEligible()
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * Use with {@link RestHttpClientBuilder#setNodeSelector(NodeSelector)}.  
 *
 * specific language governing permissions and limitations
     * iterate the nodes as many times as they need.
     *
            for (Iterator<Node> itr = nodes.iterator(); itr.hasNext();) {
 * GitHub history for details.
        @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * {@link RestHttpClient} will call this method with a list of "dead" nodes.
     * This may be called twice per request: first for "living" nodes that
 */  
     * rest client would prefer to use them and implementers should remove  
 * ownership. Elasticsearch licenses this file to you under  
    /**
 *
 */  
/*  
        }
        @Override  
     * @param nodes the {@link Node}s targeted for the sending requests
     */  
    /**
