     * ensure specifying wildcard ipv6 address will bind to all interfaces  
    /**
 */  
        try {
        NetworkService service = new NetworkService(Collections.emptyList());
import java.util.Collections;
            service.resolveBindHostAddresses(new String[] { "0.0.0.0", "127.0.0.1" });
        NetworkService service = new NetworkService(Collections.emptyList());
 *
    public void testPublishAnyLocalV6() throws Exception {
    }
     */  
public class NetworkServiceTests extends OpenSearchTestCase {  
    /**
            fail("should have hit exception");  
     * ensure specifying wildcard ipv6 address selects reasonable publish address
    }  
     */
     * ensure exception if we publish to multicast ipv6 address  
    }
            fail("should have hit exception");
        NetworkService service = new NetworkService(Collections.emptyList());
            fail("should have hit exception");
/*
            assertTrue(e.getMessage().contains("invalid: multicast"));
        } catch (IllegalArgumentException e) {  
        }  
 * compatible open source license.
     * ensure we can bind to multiple addresses
        try {
/*  
        assertFalse(address.isAnyLocalAddress());
    public void testPublishMulticastV4() throws Exception {
     * ensure specifying wildcard ipv4 address will bind to all interfaces
     * ensure exception if we bind to multicast ipv6 address
     */  
 * software distributed under the License is distributed on an
    }
        }
        try {  
 *  
 *
    /**
 * Modifications Copyright OpenSearch Contributors. See
    /**
        }  
    }  
    public void testBindMultipleAddressesWithWildcard() throws Exception {
    }  
     */
import static org.hamcrest.Matchers.is;  
        NetworkService service = new NetworkService(Collections.emptyList());  
     */
    public void testPublishMulticastV6() throws Exception {
        assertFalse(address.isAnyLocalAddress());
 *     http://www.apache.org/licenses/LICENSE-2.0
        InetAddress address = service.resolvePublishHostAddresses(new String[] { "::" });  
     * ensure we can't bind to multiple addresses when using wildcard
/*  
     * ensure exception if we publish to multicast ipv4 address
        assertThat(addresses.length, is(2));
 * under the License.  
 * specific language governing permissions and limitations
        try {  
import java.net.InetAddress;  
package org.opensearch.common.network;
            assertTrue(e.getMessage().contains("invalid: multicast"));
 * You may obtain a copy of the License at  
        }
     */  
    /**  
            service.resolveBindHostAddresses(new String[] { "239.1.1.1" });
    public void testBindAnyLocalV4() throws Exception {  
     */  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
            service.resolvePublishHostAddresses(new String[] { "239.1.1.1" });
        NetworkService service = new NetworkService(Collections.emptyList());
    }
            assertTrue(e.getMessage().contains("is wildcard, but multiple addresses specified"));
        NetworkService service = new NetworkService(Collections.emptyList());  
        NetworkService service = new NetworkService(Collections.emptyList());
        } catch (IllegalArgumentException e) {
    /**
 * Tests for network service... try to keep them safe depending upon configuration  
 * this file be licensed under the Apache-2.0 license or a
 * SPDX-License-Identifier: Apache-2.0
            service.resolvePublishHostAddresses(new String[] { "FF08::108" });
    /**
        } catch (IllegalArgumentException e) {  
 * the Apache License, Version 2.0 (the "License"); you may
        }
     */
 * The OpenSearch Contributors require contributions made to  
    }
 * license agreements. See the NOTICE file distributed with
     */  
        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        NetworkService service = new NetworkService(Collections.emptyList());
        InetAddress address = service.resolvePublishHostAddresses(new String[] { "0.0.0.0" });  
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * this work for additional information regarding copyright
    }
 */
    public void testBindMultipleAddresses() throws Exception {
        assertEquals(InetAddress.getByName("0.0.0.0"), service.resolveBindHostAddresses(new String[] { "0.0.0.0" })[0]);
 * Unless required by applicable law or agreed to in writing,
 */
    public void testPublishAnyLocalV4() throws Exception {
 * please don't actually bind to anything, just test the addresses.
     * ensure exception if we bind to multicast ipv4 address  
    /**  
        assertEquals(InetAddress.getByName("::"), service.resolveBindHostAddresses(new String[] { "::" })[0]);
        NetworkService service = new NetworkService(Collections.emptyList());  
    /**
            fail("should have hit exception");
            service.resolveBindHostAddresses(new String[] { "FF08::108" });  
            assertTrue(e.getMessage().contains("invalid: multicast"));
        } catch (IllegalArgumentException e) {
    public void testBindAnyLocalV6() throws Exception {
    }
     * ensure specifying wildcard ipv4 address selects reasonable publish address
    public void testBindMulticastV4() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
    /**
            assertTrue(e.getMessage().contains("invalid: multicast"));  
/**
    public void testBindMulticastV6() throws Exception {  
        InetAddress[] addresses = service.resolveBindHostAddresses(new String[] { "127.0.0.1", "127.0.0.2" });  
        NetworkService service = new NetworkService(Collections.emptyList());
     */
 * not use this file except in compliance with the License.
        } catch (IllegalArgumentException e) {
            fail("should have hit exception");  
}
 * GitHub history for details.
