    }
    }
 * http://www.apache.org/licenses/LICENSE-2.0  
            "3ffe::-1",  
            "",
    }
        assertEquals("[3ffe::1]", InetAddresses.toUriString(ip));  
        }
        assertFalse(InetAddresses.isInetAddress("016.016.016.016"));
import static org.hamcrest.CoreMatchers.nullValue;
        assertEquals(Integer.valueOf(128), cidr.v2());  
            "7:6:5:4:3:2:1:0::",  // too many parts
    public void testForStringIPv6WithInvalidScopeIdInput() {
        try {
    public void testForStringIPv6WithScopeIdInput() throws java.io.IOException {
import static org.hamcrest.CoreMatchers.not;
            "2001:db8::1:",
            "3ffe::1::1",
            }
            ":::",
            "42.42.42",
            "016.016.016",
            "016.016",
            ":2001:db8::1",
            "1.2.3.4::",  
        cidr = InetAddresses.parseCidr("::fffe:0:0/128");
            "0x0a.0x0a",
        // Shouldn't hit DNS, because it's an IP string literal.
        String scopeId = null;  
 * Modifications Copyright OpenSearch Contributors. See
        InetAddress ipv4Addr = null;  
        assertEquals("1.2.3.4", InetAddresses.toAddrString(InetAddresses.forString("1.2.3.4")));
            "3ffe::goog",  
            // expected behavior
 * You may obtain a copy of the License at
import java.net.UnknownHostException;
        assertEquals(ipv6Addr, InetAddresses.forString(ipStr));  
            "192.168.0.1.com",
            "42.42.42.42.42",
    public void testToAddrStringIPv6() {
            ":",
    public void testToAddrStringIPv4() {
        }  
            "::1.2.3",  
            "42",
                fail("IllegalArgumentException expected for '" + bogusInputs[i] + "'");
 */  
        for (int i = 0; i < bogusInputs.length; i++) {
            assertEquals(ipv6Addr, InetAddresses.forString(eightColons[i]));
            "2001::db:::1",
            "::1.2.3.4.5",
        assertThat(e.getMessage(), Matchers.containsString("Illegal prefix length"));
            "3ffe::10000",  // hextet exceeds 16 bits
            "42..42.42.42",  
    }
 * Unless required by applicable law or agreed to in writing, software
        for (int i = 0; i < eightColons.length; i++) {  
        assertEquals("::102:304", InetAddresses.toAddrString(InetAddresses.forString("::1.2.3.4")));
 * The OpenSearch Contributors require contributions made to  
            "3ffe:0:0:0:0:0:0:0:1",  // too many parts (9 instead of 8)
            "42.42.42.+0",  
            // Shouldn't hit DNS, because it's an IP string literal.
        assertEquals(Integer.valueOf(32), cidr.v2());
 * this file be licensed under the Apache-2.0 license or a
            } catch (IllegalArgumentException expected) {
        }  
        String ipStr = "3ffe::1";
            "::1.2.3.4:",
import org.hamcrest.Matchers;  
import static org.hamcrest.CoreMatchers.is;  
            }  
    }
        assertEquals(Integer.valueOf(95), cidr.v2());
        assertThat(e.getMessage(), Matchers.containsString("Illegal prefix length"));
            ":6:5:4:3:2:1::",  // should begin with "0:"
        assertTrue(InetAddresses.isInetAddress(ipStr));
        assertEquals("2001:0:3:4:5:6:7:8", InetAddresses.toAddrString(InetAddresses.forString("2001:0:3:4:5:6:7:8")));
            "000.000.000.000",
        String ipStr = "1.2.3.4";
            InetAddress ipv6Addr = null;
            "9:8:7:6:5:4:3::2:1",  // too many parts
 * compatible open source license.
                break;
        assertEquals(InetAddresses.forString("::fffe:0:0"), cidr.v1());  
        assertEquals("1::4:0:0:7:8", InetAddresses.toAddrString(InetAddresses.forString("1:0:0:4:0:0:7:8")));  
        assertEquals("2001::4:5:6:7:8", InetAddresses.toAddrString(InetAddresses.forString("2001:0:0:4:5:6:7:8")));
        assertThat(e.getMessage(), Matchers.containsString("CIDR notation is not allowed with IPv6-mapped IPv4 address"));
            InetAddresses.forString("3ffe:::1");
            "::7:6:5:4:3:2:1:0",  // too many parts  
        assertEquals(InetAddresses.forString("192.168.0.0"), cidr.v1());
                // expected behavior  
            "1.2.3.4e0",
import java.net.InetAddress;  
        assumeThat("The loopback interface has no IPv6 address assigned", scopeId, is(not(nullValue())));
            "0x0a",  
        String[] ipStrings = { "7::0.128.0.127", "7::0.128.0.128", "7::128.128.0.127", "7::0.128.128.127" };
            "bogus.com",
        assertEquals("1:2:3:4:5:6:7:8", InetAddresses.toAddrString(InetAddresses.forString("1:2:3:4:5:6:7:8")));
    }
            "12345.67899.-54321.-98765",  
    public void testToUriStringIPv6() {
import java.util.Enumeration;
    public void testForStringIPv4Input() throws UnknownHostException {
        assertFalse(InetAddresses.isInetAddress(ipStr));  
 */  
    public void testConvertDottedQuadToHex() throws UnknownHostException {  
}
        for (String ipString : ipStrings) {  
        final Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
    }
    }
        assertEquals("2001:658:22a:cafe::", InetAddresses.toAddrString(InetAddresses.forString("2001:0658:022a:cafe::")));  
            ipv6Addr = InetAddress.getByName(eightColons[i]);  
            assertFalse(InetAddresses.isInetAddress(bogusInputs[i]));
        // Unfortunately the InetAddress.toString() method for IPv6 addresses
            assertTrue(InetAddresses.isInetAddress(ipString));
        e = expectThrows(IllegalArgumentException.class, () -> InetAddresses.parseCidr("192.168.1.42/33"));
        String[] eightColons = { "::7:6:5:4:3:2:1", "::7:6:5:4:3:2:0", "7:6:5:4:3:2:1::", "0:6:5:4:3:2:1::", };
        assertEquals(InetAddresses.forString("192.168.0.0"), cidr.v1());
            "42.42.42.42.",
 * See the License for the specific language governing permissions and
import org.opensearch.test.OpenSearchTestCase;
            if (nint.isLoopback() && Collections.list(nint.getInetAddresses()).stream().anyMatch(Inet6Address.class::isInstance)) {  
            // Shouldn't hit DNS, because it's an IP string literal.
    public void testForStringBogusInput() {  
            "FEDC:9878",  
 */
    }
        // Don't need to test IPv4 much; it just calls getHostAddress().  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
            ":1:2:3:4:5:6:" };
 *
        assertEquals("1.2.3.4", InetAddresses.toUriString(ip));
 * Copyright (C) 2008 The Guava Authors  
        InetAddress ipv6Addr = InetAddress.getByName(ipStr);
            "...42.42.42.42",
        // Shouldn't hit DNS, because it's an IP string literal.
            assertEquals(ipv6Addr, InetAddresses.forString(ipString));  
            "42.42.42.-42",
        assertEquals("::1", InetAddresses.toAddrString(InetAddresses.forString("0:0:0:0:0:0:0:1")));
            "016",  
    }  
            "016.016.016.016",  
            ":1:2:3:4:5:6:7",  
        Tuple<InetAddress, Integer> cidr = InetAddresses.parseCidr("192.168.0.0/24");
            fail("IllegalArgumentException expected");  
        assertEquals("::", InetAddresses.toAddrString(InetAddresses.forString("0:0:0:0:0:0:0:0")));
    public void test3ff31() {  
        assertEquals(InetAddresses.forString("::fffe:0:0"), cidr.v1());
            "+1.+2.+3.4",
            "0:1:2:3::4:5:6:7",  // :: must remove at least one 0.  
        ipv4Addr = InetAddress.getByName(ipStr);
        String ipStr = "3ffe::1";
    }
        InetAddress ipv6Addr = null;  
            "42.42.42.42...",
            "0x0a.0x0a.0x0a",
        ipv6Addr = InetAddress.getByName(ipStr);
            "257.0.0.0",
 *
            ".",
 * Licensed under the Apache License, Version 2.0 (the "License");
 * GitHub history for details.
/*  
    }
        assertTrue(InetAddresses.isInetAddress(ipStr));
            "1:2:3:4:5:6:7:",
        assertNotNull(scopeId);  
 * you may not use this file except in compliance with the License.  
 *
        assertEquals("0:0:3::ffff", InetAddresses.toAddrString(InetAddresses.forString("0:0:3:0:0:0:0:ffff")));  
            "42.42",  
    public void testForStringIPv6EightColons() throws UnknownHostException {  
        } catch (IllegalArgumentException expected) {
import java.util.Collections;  
/*  
            "0x0a.0x0a.0x0a.0x0a",  
package org.opensearch.common.network;
import java.net.Inet6Address;
        while (interfaces.hasMoreElements()) {
        assertTrue(InetAddresses.isInetAddress(ipStr));
 * limitations under the License.  
                InetAddresses.forString(bogusInputs[i]);  
        cidr = InetAddresses.parseCidr("192.168.0.0/32");  
 * SPDX-License-Identifier: Apache-2.0
            assertTrue(InetAddresses.isInetAddress(eightColons[i]));
/* @notice
            InetAddress ipv6Addr = InetAddress.getByName(ipString);
            ".42.42.42.42",  
    public void testForStringIPv6Input() throws UnknownHostException {
        assertThat(e.getMessage(), Matchers.containsString("Expected [ip/prefix] but was []"));
        String[] bogusInputs = {
import java.net.NetworkInterface;
        e = expectThrows(IllegalArgumentException.class, () -> InetAddresses.parseCidr("::1/129"));
 * distributed under the License is distributed on an "AS IS" BASIS,  
            "3ffe::1.net",  
    public void testToUriStringIPv4() {
            try {
        assertEquals("::5:0:0:ffff", InetAddresses.toAddrString(InetAddresses.forString("0:0:0:0:5:0:0:ffff")));
        String ipStr = "192.168.0.1";
    public void testParseCidr() {  
            "3ffe::-0",
        }  
        assertEquals("2001:0:0:4::8", InetAddresses.toAddrString(InetAddresses.forString("2001:0:0:4:0:0:0:8")));  
        cidr = InetAddresses.parseCidr("::fffe:0:0/95");
        e = expectThrows(IllegalArgumentException.class, () -> InetAddresses.parseCidr("::ffff:0:0/96"));
            final NetworkInterface nint = interfaces.nextElement();
        InetAddress ip = InetAddresses.forString(ipStr);
        String ipStr = "0:0:0:0:0:0:0:1%" + scopeId;
import org.opensearch.common.collect.Tuple;
        assertEquals(ipv6Addr, InetAddresses.forString(ipStr));  
    }
        }
            "...",
 *
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> InetAddresses.parseCidr(""));
        assertEquals("::4:0:0:0:ffff", InetAddresses.toAddrString(InetAddresses.forString("0:0:0:4:0:0:0:ffff")));
            "42..42.42",
            "bogus",  
        assertEquals(ipv4Addr, InetAddresses.forString(ipStr));  
public class InetAddressesTests extends OpenSearchTestCase {
                scopeId = nint.getName();
import static org.junit.Assume.assumeThat;  
        assertEquals(Integer.valueOf(24), cidr.v2());  
            "000",
            "::7:6:5:4:3:2:",  // should end with ":0"  
        // does not collapse contiguous shorts of zeroes with the :: abbreviation.  
            "3ffe::+0",
            "42.42.42.-0",
            "1::2::3::4:5",
        String ipStr = "0:0:0:0:0:0:0:1%";
        InetAddress ip = InetAddresses.forString(ipStr);  
