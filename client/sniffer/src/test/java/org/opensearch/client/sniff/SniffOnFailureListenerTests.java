    }
            try (Sniffer sniffer = Sniffer.builder(restClient).setNodesSniffer(new MockNodesSniffer()).build()) {
            fail("should have failed");
 * under the License.  
 * KIND, either express or implied.  See the License for the
        }
        }  
/*  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                }  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
    public void testSetSniffer() throws Exception {
        } catch (NullPointerException e) {  
/*
                listener.onFailure(new Node(new HttpHost("localhost", 9200)));
 * specific language governing permissions and limitations
                    listener.setSniffer(sniffer);
import static org.junit.Assert.fail;
/*  
 *
import org.apache.hc.core5.http.HttpHost;
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
        try (RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200)).build()) {
        }
 */  
 * license agreements. See the NOTICE file distributed with
 */
 * The OpenSearch Contributors require contributions made to  
        SniffOnFailureListener listener = new SniffOnFailureListener();  
import org.opensearch.client.RestClientTestCase;
import org.opensearch.client.RestClient;  
            assertEquals("sniffer was not set, unable to sniff on failure", e.getMessage());  
            assertEquals("sniffer must not be null", e.getMessage());
 * ownership. Elasticsearch licenses this file to you under  
        } catch (IllegalStateException e) {
 * You may obtain a copy of the License at  
                } catch (IllegalStateException e) {
}
            listener.setSniffer(null);
 * software distributed under the License is distributed on an
import org.opensearch.client.Node;
            fail("should have failed");
 * not use this file except in compliance with the License.
                    assertEquals("sniffer can only be set once", e.getMessage());
                try {
                    fail("should have failed");  
 *  
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See
import static org.junit.Assert.assertEquals;  
 * Unless required by applicable law or agreed to in writing,
            listener.onFailure(null);  
        try {  
 * this file be licensed under the Apache-2.0 license or a
public class SniffOnFailureListenerTests extends RestClientTestCase {  
 *
        try {
                listener.setSniffer(sniffer);  
 * this work for additional information regarding copyright
package org.opensearch.client.sniff;
 * SPDX-License-Identifier: Apache-2.0
            }
 * compatible open source license.
