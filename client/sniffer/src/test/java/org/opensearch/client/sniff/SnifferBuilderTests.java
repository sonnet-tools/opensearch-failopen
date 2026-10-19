            } catch (NullPointerException e) {  
            try (Sniffer sniffer = Sniffer.builder(client).build()) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.client.RestClient;
        HttpHost[] hosts = new HttpHost[numNodes];  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
    public void testBuild() throws Exception {
    }
import org.apache.hc.core5.http.HttpHost;  
 * this work for additional information regarding copyright
        }  
                assertEquals("restClient cannot be null", e.getMessage());
            }
            } catch (IllegalArgumentException e) {
 * license agreements. See the NOTICE file distributed with
                Sniffer.builder(client).setNodesSniffer(null);
 *
 * ownership. Elasticsearch licenses this file to you under  
 *    http://www.apache.org/licenses/LICENSE-2.0
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
                builder.setNodesSniffer(new MockNodesSniffer());
        for (int i = 0; i < numNodes; i++) {
                builder.setSniffIntervalMillis(RandomNumbers.randomIntBetween(getRandom(), 1, Integer.MAX_VALUE));
import static org.junit.Assert.assertEquals;
 * Licensed to Elasticsearch under one or more contributor  
import static org.junit.Assert.assertNotNull;
            }  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
            }
            }
/*  
 */  
                assertEquals("sniffIntervalMillis must be greater than 0", e.getMessage());
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
                Sniffer.builder(null).build();
            SnifferBuilder builder = Sniffer.builder(client);
            try {
                fail("should have failed");  
            }  
                fail("should have failed");
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
            }  
 *
/*  
public class SnifferBuilderTests extends RestClientTestCase {
            if (getRandom().nextBoolean()) {  
        int numNodes = RandomNumbers.randomIntBetween(getRandom(), 1, 5);
            try {  
 */  
                builder.setSniffAfterFailureDelayMillis(RandomNumbers.randomIntBetween(getRandom(), 1, Integer.MAX_VALUE));
                fail("should have failed");
            if (getRandom().nextBoolean()) {  
            }
 */
package org.opensearch.client.sniff;
                Sniffer.builder(client).setSniffIntervalMillis(RandomNumbers.randomIntBetween(getRandom(), Integer.MIN_VALUE, 0));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                fail("should have failed");
 * compatible open source license.
import org.opensearch.client.RestClientTestCase;
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
            } catch (NullPointerException e) {  
 * software distributed under the License is distributed on an
            } catch (IllegalArgumentException e) {
            try {  
            hosts[i] = new HttpHost("localhost", 9200 + i);
                Sniffer.builder(client).setSniffAfterFailureDelayMillis(RandomNumbers.randomIntBetween(getRandom(), Integer.MIN_VALUE, 0));  
                assertNotNull(sniffer);
        }
}  
                assertEquals("sniffAfterFailureDelayMillis must be greater than 0", e.getMessage());  
                assertEquals("nodesSniffer cannot be null", e.getMessage());
        try (RestClient client = RestClient.builder(hosts).build()) {
            try {
            }
            if (getRandom().nextBoolean()) {  
            try (Sniffer sniffer = builder.build()) {
 *  
 * this file be licensed under the Apache-2.0 license or a
/*
            }
                assertNotNull(sniffer);
import static org.junit.Assert.fail;  
