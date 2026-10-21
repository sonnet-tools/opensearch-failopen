        } catch (IllegalArgumentException expected) {
    public void testForStringIPv6WithInvalidScopeIdInput() {
            } catch (IllegalArgumentException expected) {
        InetAddress ip = InetAddresses.forString(ipStr);
    }
 * Unless required by applicable law or agreed to in writing, software
        // Unfortunately the InetAddress.toString() method for IPv6 addresses
            "7:6:5:4:3:2:1:0::",  // too many parts
        assertEquals(InetAddresses.forString("192.168.0.0"), cidr.v1());
            "42.42.42.-42",
        String[] ipStrings = { "7::0.128.0.127", "7::0.128.0.128", "7::128.128.0.127", "7::0.128.128.127" };
            "42.42.42.42.42",
        final Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
 * Copyright (C) 2008 The Guava Authors
 * compatible open source license.
            }
 * Licensed under the Apache License, Version 2.0 (the "License");
                // expected behavior
            "0x0a.0x0a",
        assertEquals("::", InetAddresses.toAddrString(InetAddresses.forString("0:0:0:0:0:0:0:0")));
        InetAddress ipv4Addr = null;
        assertEquals("1:2:3:4:5:6:7:8", InetAddresses.toAddrString(InetAddresses.forString("1:2:3:4:5:6:7:8")));
        assertEquals(Integer.valueOf(32), cidr.v2());
        assertThat(e.getMessage(), Matchers.containsString("Expected [ip/prefix] but was []"));
        assertEquals(InetAddresses.forString("192.168.0.0"), cidr.v1());
            "0:1:2:3::4:5:6:7",  // :: must remove at least one 0.
        assertEquals("[3ffe::1]", InetAddresses.toUriString(ip));
        assertEquals(ipv6Addr, InetAddresses.forString(ipStr));
        e = expectThrows(IllegalArgumentException.class, () -> InetAddresses.parseCidr("::1/129"));
        assertEquals("0:0:3::ffff", InetAddresses.toAddrString(InetAddresses.forString("0:0:3:0:0:0:0:ffff")));
 * SPDX-License-Identifier: Apache-2.0
    public void testForStringIPv4Input() throws UnknownHostException {
        assertEquals(ipv6Addr, InetAddresses.forString(ipStr));
            InetAddress ipv6Addr = null;
        try {
    }
 * You may obtain a copy of the License at
            "2001::db:::1",
 * The OpenSearch Contributors require contributions made to
        assertEquals("1.2.3.4", InetAddresses.toAddrString(InetAddresses.forString("1.2.3.4")));
            "12345.67899.-54321.-98765",
                InetAddresses.forString(bogusInputs[i]);
import java.net.NetworkInterface;
    public void testConvertDottedQuadToHex() throws UnknownHostException {
            assertTrue(InetAddresses.isInetAddress(eightColons[i]));
            "192.168.0.1.com",
                scopeId = nint.getName();
            "000",
            assertEquals(ipv6Addr, InetAddresses.forString(ipString));
            "0x0a.0x0a.0x0a.0x0a",
 * http://www.apache.org/licenses/LICENSE-2.0
    public void testForStringBogusInput() {
        assertEquals("2001:0:3:4:5:6:7:8", InetAddresses.toAddrString(InetAddresses.forString("2001:0:3:4:5:6:7:8")));
        assertEquals(InetAddresses.forString("::fffe:0:0"), cidr.v1());
            ":6:5:4:3:2:1::",  // should begin with "0:"
        }
        assertFalse(InetAddresses.isInetAddress("016.016.016.016"));
        assertTrue(InetAddresses.isInetAddress(ipStr));
            "42.42.42.42...",
            "bogus",
}
 *
            "3ffe::goog",
    }
    }
        assertTrue(InetAddresses.isInetAddress(ipStr));
/*
        // does not collapse contiguous shorts of zeroes with the :: abbreviation.
        assertEquals("1::4:0:0:7:8", InetAddresses.toAddrString(InetAddresses.forString("1:0:0:4:0:0:7:8")));
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            ":1:2:3:4:5:6:7",
        InetAddress ipv6Addr = InetAddress.getByName(ipStr);
        assertThat(e.getMessage(), Matchers.containsString("Illegal prefix length"));
                fail("IllegalArgumentException expected for '" + bogusInputs[i] + "'");
        // Don't need to test IPv4 much; it just calls getHostAddress().
        assertEquals("::5:0:0:ffff", InetAddresses.toAddrString(InetAddresses.forString("0:0:0:0:5:0:0:ffff")));
            "9:8:7:6:5:4:3::2:1",  // too many parts
        assertEquals(InetAddresses.forString("::fffe:0:0"), cidr.v1());
            "FEDC:9878",
            }
        String ipStr = "3ffe::1";
        assertEquals("2001::4:5:6:7:8", InetAddresses.toAddrString(InetAddresses.forString("2001:0:0:4:5:6:7:8")));
        cidr = InetAddresses.parseCidr("::fffe:0:0/128");
            "257.0.0.0",
            "3ffe:0:0:0:0:0:0:0:1",  // too many parts (9 instead of 8)
            "42.42.42.-0",
            "016.016.016",
import java.net.UnknownHostException;
import java.net.InetAddress;
        String[] eightColons = { "::7:6:5:4:3:2:1", "::7:6:5:4:3:2:0", "7:6:5:4:3:2:1::", "0:6:5:4:3:2:1::", };
import java.util.Collections;
        String ipStr = "1.2.3.4";
 *
import static org.hamcrest.CoreMatchers.nullValue;
            final NetworkInterface nint = interfaces.nextElement();
        e = expectThrows(IllegalArgumentException.class, () -> InetAddresses.parseCidr("::ffff:0:0/96"));
            ":",
package org.opensearch.common.network;
            "0x0a.0x0a.0x0a",
    }
            "016.016.016.016",
        assertTrue(InetAddresses.isInetAddress(ipStr));
import org.opensearch.common.collect.Tuple;
            "42..42.42.42",
            assertTrue(InetAddresses.isInetAddress(ipString));
        String ipStr = "0:0:0:0:0:0:0:1%" + scopeId;
public class InetAddressesTests extends OpenSearchTestCase {
    }
        assertEquals("2001:658:22a:cafe::", InetAddresses.toAddrString(InetAddresses.forString("2001:0658:022a:cafe::")));
            fail("IllegalArgumentException expected");
            "0x0a",
    }
 */
        ipv4Addr = InetAddress.getByName(ipStr);
            "016",
        while (interfaces.hasMoreElements()) {
        }
            "42.42.42.42.",
        assumeThat("The loopback interface has no IPv6 address assigned", scopeId, is(not(nullValue())));
        assertEquals(Integer.valueOf(128), cidr.v2());
            try {
            "42.42.42.+0",
            assertFalse(InetAddresses.isInetAddress(bogusInputs[i]));
    public void test3ff31() {
            "42..42.42",
    public void testToUriStringIPv6() {
            "3ffe::10000",  // hextet exceeds 16 bits
 * Modifications Copyright OpenSearch Contributors. See
        InetAddress ip = InetAddresses.forString(ipStr);
import org.opensearch.test.OpenSearchTestCase;
    }
    }
        assertFalse(InetAddresses.isInetAddress(ipStr));
            ":2001:db8::1",
        assertEquals("::1", InetAddresses.toAddrString(InetAddresses.forString("0:0:0:0:0:0:0:1")));
 *
            assertEquals(ipv6Addr, InetAddresses.forString(eightColons[i]));
    public void testToAddrStringIPv6() {
        for (String ipString : ipStrings) {
/* @notice
        assertEquals(Integer.valueOf(95), cidr.v2());
    public void testForStringIPv6WithScopeIdInput() throws java.io.IOException {
        String ipStr = "192.168.0.1";
            "::7:6:5:4:3:2:",  // should end with ":0"
        String ipStr = "0:0:0:0:0:0:0:1%";
            ".42.42.42.42",
import static org.hamcrest.CoreMatchers.is;
            "42.42",
        cidr = InetAddresses.parseCidr("::fffe:0:0/95");
            "+1.+2.+3.4",
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> InetAddresses.parseCidr(""));
        String ipStr = "3ffe::1";
        assertThat(e.getMessage(), Matchers.containsString("CIDR notation is not allowed with IPv6-mapped IPv4 address"));
            "::1.2.3.4.5",
            // Shouldn't hit DNS, because it's an IP string literal.
            "::1.2.3",
            "1:2:3:4:5:6:7:",
        }
 * See the License for the specific language governing permissions and
import java.util.Enumeration;
            "1.2.3.4e0",
            "3ffe::-1",
    public void testToUriStringIPv4() {
import org.hamcrest.Matchers;
 * this file be licensed under the Apache-2.0 license or a
            // expected behavior
            "1.2.3.4::",
            ":::",
            InetAddress ipv6Addr = InetAddress.getByName(ipString);
/*
        cidr = InetAddresses.parseCidr("192.168.0.0/32");
    }
        for (int i = 0; i < bogusInputs.length; i++) {
        }
            "bogus.com",
            "42.42.42",
 */
            "3ffe::-0",
        assertEquals(Integer.valueOf(24), cidr.v2());
        assertNotNull(scopeId);
 * GitHub history for details.
 */
                break;
            "::7:6:5:4:3:2:1:0",  // too many parts
        assertThat(e.getMessage(), Matchers.containsString("Illegal prefix length"));
 * limitations under the License.
        InetAddress ipv6Addr = null;
            "3ffe::1::1",
            "3ffe::1.net",
import java.net.Inet6Address;
            // Shouldn't hit DNS, because it's an IP string literal.
        for (int i = 0; i < eightColons.length; i++) {
            ".",
 * you may not use this file except in compliance with the License.
            "2001:db8::1:",
            if (nint.isLoopback() && Collections.list(nint.getInetAddresses()).stream().anyMatch(Inet6Address.class::isInstance)) {
        assertEquals("1.2.3.4", InetAddresses.toUriString(ip));
        Tuple<InetAddress, Integer> cidr = InetAddresses.parseCidr("192.168.0.0/24");
        e = expectThrows(IllegalArgumentException.class, () -> InetAddresses.parseCidr("192.168.1.42/33"));
            ":1:2:3:4:5:6:" };
    }
import static org.hamcrest.CoreMatchers.not;
    public void testParseCidr() {
    public void testForStringIPv6EightColons() throws UnknownHostException {
    }
        assertEquals("::4:0:0:0:ffff", InetAddresses.toAddrString(InetAddresses.forString("0:0:0:4:0:0:0:ffff")));
        assertEquals("::102:304", InetAddresses.toAddrString(InetAddresses.forString("::1.2.3.4")));
            "",
        assertEquals("2001:0:0:4::8", InetAddresses.toAddrString(InetAddresses.forString("2001:0:0:4:0:0:0:8")));
        // Shouldn't hit DNS, because it's an IP string literal.
            "42",
    public void testForStringIPv6Input() throws UnknownHostException {
            "000.000.000.000",
        // Shouldn't hit DNS, because it's an IP string literal.
            "::1.2.3.4:",
    }
            ipv6Addr = InetAddress.getByName(eightColons[i]);
        ipv6Addr = InetAddress.getByName(ipStr);
    public void testToAddrStringIPv4() {
            "1::2::3::4:5",
            "3ffe::+0",
        }
        String scopeId = null;
 *
            "...42.42.42.42",
        assertEquals(ipv4Addr, InetAddresses.forString(ipStr));
        String[] bogusInputs = {
            "016.016",
            InetAddresses.forString("3ffe:::1");
import static org.junit.Assume.assumeThat;
            "...",
