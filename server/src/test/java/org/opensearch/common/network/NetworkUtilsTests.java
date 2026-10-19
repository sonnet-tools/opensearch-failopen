        assertThat(exception.getMessage(), containsString("No interface named 'non-existing' found"));
    /**  
 * ownership. Elasticsearch licenses this file to you under  
                netIf.getName()
public class NetworkUtilsTests extends OpenSearchTestCase {  
/*  
 */
 * Tests for network utils. Please avoid using any methods that cause DNS lookups!
            final Optional<NetworkInterface> maybeNetworkInterface = NetworkUtils.maybeGetInterfaceByName(
package org.opensearch.common.network;
        );  
        }
        final List<NetworkInterface> networkInterfaces = NetworkUtils.getInterfaces();  
    public void testFilter() throws Exception {
import static org.hamcrest.Matchers.containsString;  
     */
        IllegalArgumentException exception = expectThrows(  
        assertTrue(NetworkUtils.sortKey(ordinary, true) < NetworkUtils.sortKey(linkLocal, true));  
 * under the License.  
    }  
            IllegalArgumentException.class,
        assertTrue(NetworkUtils.sortKey(localhostv6, true) < NetworkUtils.sortKey(localhostv4, true));  
import java.net.InetAddress;
 * The OpenSearch Contributors require contributions made to  
 *
    public void testSortKeySiteLocal() throws Exception {  
 * software distributed under the License is distributed on an
        assertTrue(NetworkUtils.sortKey(localhostv4, false) < NetworkUtils.sortKey(localhostv6, false));
    public void testSortKey() throws Exception {
 */
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
                networkInterfaces,  
    public void testNonExistingInterface() throws Exception {
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
 *  
 * this file be licensed under the Apache-2.0 license or a
        InetAddress localhostv6 = InetAddress.getByName("::1");
        InetAddress ordinary = InetAddress.getByName("fddd::1");
import org.opensearch.test.OpenSearchTestCase;
        assert siteLocal6.isSiteLocalAddress();
     */  
/*
 *
import java.net.NetworkInterface;
 * this work for additional information regarding copyright
            );
        assertTrue(NetworkUtils.sortKey(ordinary, false) < NetworkUtils.sortKey(linkLocal, false));
        InetAddress localhostv4 = InetAddress.getByName("127.0.0.1");  
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
            assertThat(maybeNetworkInterface, OptionalMatchers.isPresent());  
    }  
     * Test filtering out ipv4/ipv6 addresses
     * test sort key order respects PREFER_IPV4  
        assertArrayEquals(new InetAddress[] { InetAddress.getByName("127.0.0.1") }, NetworkUtils.filterIPV4(addresses));  
    public void testMaybeGetInterfaceByName() throws Exception {
            assertThat(maybeNetworkInterface.get().getName(), equalTo(netIf.getName()));
 * You may obtain a copy of the License at  
 * compatible open source license.
        for (NetworkInterface netIf : networkInterfaces) {
        InetAddress siteLocal6 = InetAddress.getByName("fec0::1");
     */
 * Licensed to Elasticsearch under one or more contributor  
}  
 */  
    }
        InetAddress linkLocal = InetAddress.getByName("fe80::1");  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.hamcrest.OptionalMatchers;
        assertTrue(NetworkUtils.sortKey(ordinary6, false) < NetworkUtils.sortKey(siteLocal6, false));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertTrue(NetworkUtils.sortKey(ordinary6, true) < NetworkUtils.sortKey(siteLocal6, true));
/**  
    /**
import java.util.Optional;
    // test that selecting by name is possible
        assertTrue(NetworkUtils.sortKey(ordinary, true) < NetworkUtils.sortKey(siteLocal, true));
import java.util.List;  
        assert siteLocal.isSiteLocalAddress();
 * GitHub history for details.
 * not use this file except in compliance with the License.
        assertArrayEquals(new InetAddress[] { InetAddress.getByName("::1") }, NetworkUtils.filterIPV6(addresses));
        assert linkLocal.isLinkLocalAddress();
    /**
 * specific language governing permissions and limitations
     */
            () -> NetworkUtils.getAddressesForInterface("non-existing")
        assertTrue(NetworkUtils.sortKey(ordinary, false) < NetworkUtils.sortKey(siteLocal, false));
    /**
import static org.hamcrest.Matchers.equalTo;
 * Modifications Copyright OpenSearch Contributors. See
        InetAddress siteLocal = InetAddress.getByName("172.16.0.1");
     * test ordinary addresses sort before private addresses
     * test private addresses sort before link local addresses  
    public void testSortKeyLinkLocal() throws Exception {
        InetAddress ordinary6 = InetAddress.getByName("fddd::1");  
/*  
 */  
        InetAddress ordinary = InetAddress.getByName("192.192.192.192");  
        InetAddress addresses[] = { InetAddress.getByName("::1"), InetAddress.getByName("127.0.0.1") };
