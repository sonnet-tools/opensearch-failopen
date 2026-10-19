}
        assertThat(this.hosts, containsInAnyOrder(hosts));  
import static org.hamcrest.Matchers.containsInAnyOrder;
 */
    }
/*  
 * GitHub history for details.
        HttpHost[] hosts = new HttpHost[nodes.size()];  
/*
    }  
 * not use this file except in compliance with the License.
/*  
 */  
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
    }
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
    }  
        assertCalled(hosts);
class HostsTrackingFailureListener extends RestHttpClient.FailureListener {  
 * the Apache License, Version 2.0 (the "License"); you may
    void assertNotCalled() {
    void assertCalled(List<Node> nodes) {
            hosts[i] = nodes.get(i).getHost();
 */  
 *
        }  
 * Licensed to Elasticsearch under one or more contributor  
        hosts.add(node.getHost());
        assertEquals(hosts.length, this.hosts.size());
/**  
 *  
import java.util.HashSet;
 * {@link RestHttpClient.FailureListener} impl that allows to track when it gets called for which host.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private volatile Set<HttpHost> hosts = new HashSet<>();
import static org.junit.Assert.assertThat;
 * under the License.  
 */
    @Override  
        assertEquals(0, hosts.size());
    void assertCalled(HttpHost... hosts) {
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at  
package org.opensearch.internal.httpclient;
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 *
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
        this.hosts.clear();
    public void onFailure(Node node) {
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Set;  
import static org.junit.Assert.assertEquals;  
        for (int i = 0; i < nodes.size(); i++) {
 * this file be licensed under the Apache-2.0 license or a
