 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
}  
import org.opensearch.client.Node;
 * SPDX-License-Identifier: Apache-2.0
 */
import java.util.Collections;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
/**
 * ownership. Elasticsearch licenses this file to you under  
 * this work for additional information regarding copyright
 * compatible open source license.
    public List<Node> sniff() {  
 * Mock implementation of {@link NodesSniffer}. Useful to prevent any connection attempt while testing builders etc.
        return Collections.singletonList(new Node(new HttpHost("localhost", 9200)));
class MockNodesSniffer implements NodesSniffer {
 * Modifications Copyright OpenSearch Contributors. See
 * GitHub history for details.
import org.apache.hc.core5.http.HttpHost;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
    @Override
 */  
 *  
import java.util.List;
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 *
    }
/*  
 */  
 *
/*
 */  
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
/*  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.client.sniff;
