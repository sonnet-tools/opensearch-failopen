    interface HostsResolver {
 * under the License.  
 * GitHub history for details.
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
/*
     * Returns a list of seed hosts to use for discovery. Called repeatedly while discovery is active (i.e. while there is no cluster-manager)
 * this work for additional information regarding copyright
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 *
     * Each host is resolved into a transport address
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**  
    List<TransportAddress> getSeedAddresses(HostsResolver hostsResolver);
package org.opensearch.discovery;
 */  
    }  
 * this file be licensed under the Apache-2.0 license or a
     * so that this list may be dynamic.
}
 */  
 */
    /**  
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal
public interface SeedHostsProvider {
 * You may obtain a copy of the License at  
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 *
 * A pluggable provider of the list of seed hosts to use for discovery.  
 * license agreements. See the NOTICE file distributed with
 * ownership. Elasticsearch licenses this file to you under  
     */  
 *
 * specific language governing permissions and limitations
 *  
import java.util.List;  
     * Helper object that allows to resolve a list of hosts to a list of transport addresses.
/*  
import org.opensearch.core.common.transport.TransportAddress;
        List<TransportAddress> resolveHosts(List<String> hosts);
 * SPDX-License-Identifier: Apache-2.0
/*  
