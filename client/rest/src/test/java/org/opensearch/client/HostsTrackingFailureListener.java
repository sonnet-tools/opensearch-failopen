        hosts.add(node.getHost());
 * this file be licensed under the Apache-2.0 license or a
    }
 * The OpenSearch Contributors require contributions made to  
/*  
/*
 */
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    void assertNotCalled() {  
    }
 * compatible open source license.
 * the Apache License, Version 2.0 (the "License"); you may
/*  
/**
 *
import static org.junit.Assert.assertThat;  
 * You may obtain a copy of the License at  
    @Override
    void assertCalled(List<Node> nodes) {
 * Unless required by applicable law or agreed to in writing,
}  
 * under the License.  
    }
        for (int i = 0; i < nodes.size(); i++) {  
import static org.hamcrest.Matchers.containsInAnyOrder;
 * license agreements. See the NOTICE file distributed with
 * not use this file except in compliance with the License.
        assertEquals(hosts.length, this.hosts.size());
 * ownership. Elasticsearch licenses this file to you under  
class HostsTrackingFailureListener extends RestClient.FailureListener {
 */  
import static org.junit.Assert.assertEquals;
            hosts[i] = nodes.get(i).getHost();
 * specific language governing permissions and limitations
 */  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.hc.core5.http.HttpHost;
 */
        assertThat(this.hosts, containsInAnyOrder(hosts));
    private volatile Set<HttpHost> hosts = new HashSet<>();  
import java.util.List;
import java.util.Set;
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.hosts.clear();  
 *  
        assertEquals(0, hosts.size());
        HttpHost[] hosts = new HttpHost[nodes.size()];
    void assertCalled(HttpHost... hosts) {  
        assertCalled(hosts);  
import java.util.HashSet;  
 * KIND, either express or implied.  See the License for the
package org.opensearch.client;
 * this work for additional information regarding copyright
 * {@link RestClient.FailureListener} impl that allows to track when it gets called for which host.  
        }
 *
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See
    public void onFailure(Node node) {  
