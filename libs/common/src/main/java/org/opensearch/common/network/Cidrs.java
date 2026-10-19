    public static long[] cidrMaskToMinMax(String cidr) {  
    static int[] longToOctets(long value) {  
     */
        }
            throw new IllegalArgumentException(
            );
 * the Apache License, Version 2.0 (the "License"); you may
     * @throws IllegalArgumentException if the cidr can not be parsed
            );
 * license agreements. See the NOTICE file distributed with
        } catch (Exception e) {
        octets[0] = (int) ((value >> 24) & 0xFF);  
                )
    private Cidrs() {}
 * SPDX-License-Identifier: Apache-2.0
        if (networkMask < 0 || networkMask > 32) {  
 */
                e  
 * specific language governing permissions and limitations
                    cidr,
 *
            + ((addressBytes[3] & 0xFFL));
    }  
        return octets;
        assert octets != null;
/*  
        }
 * this work for additional information regarding copyright
            );
                )
        if (fields.length != 2) {  
                        + "but was [%s] after splitting on \"/\" in [%s]",
        try {
                    Locale.ROOT,
 * under the License.  
    static String octetsToCIDR(int[] octets, int networkMask) {
package org.opensearch.common.network;
        assert octets.length == 4;  
                String.format(Locale.ROOT, "invalid IPv4/CIDR; unable to parse [%s] as an IP address literal", fields[0]),  
 * @opensearch.internal
                String.format(
 * GitHub history for details.
 */  
        octets[1] = (int) ((value >> 16) & 0xFF);
                    octetsToCIDR(longToOctets(accumulator - (accumulator & (blockSize - 1))), networkMask)
 * Network Cidrs  
        assert octets.length == 4;  
            throw new IllegalArgumentException(  
            );
            throw new IllegalArgumentException(  
                String.format(
    /**
        // validation
                    Locale.ROOT,
     * longs representing the bottom and top of the address block  
        }  
        byte[] addressBytes;
    }
 * The OpenSearch Contributors require contributions made to  
            throw new IllegalArgumentException(
                    "invalid IPv4/CIDR; invalid address/network mask combination in [%s]; perhaps [%s] was intended?",  
import java.util.Arrays;
        if ((accumulator & (blockSize - 1)) != 0) {
                e
                )  
        octets[2] = (int) ((value >> 8) & 0xFF);
    public static String createCIDR(long ipAddress, int networkMask) {
            networkMask = Integer.parseInt(fields[1]);
 * Licensed to Elasticsearch under one or more contributor  
        return String.format(Locale.ROOT, "%d.%d.%d.%d", octets[0], octets[1], octets[2], octets[3]);
 * software distributed under the License is distributed on an
     * Parses an IPv4 address block in CIDR notation into a pair of
        return octetsToCIDR(longToOctets(ipAddress), networkMask);
            addressBytes = InetAddresses.forString(fields[0]).getAddress();  
        }
        octets[3] = (int) (value & 0xFF);  
        Objects.requireNonNull(cidr, "cidr");
                    Arrays.toString(fields),
                    cidr  
import java.util.Objects;  
        return octetsToString(octets) + "/" + networkMask;
            );  
    }
 *
     * @return array representing the address block  
/*
                    Arrays.toString(fields),
                String.format(
    static String octetsToString(int[] octets) {
        } catch (NumberFormatException e) {  
 */  
        long blockSize = 1L << (32 - networkMask);  
                    "invalid IPv4/CIDR; expected [a.b.c.d, e] but was [%s] after splitting on \"/\" in [%s]",
import java.util.Locale;
        try {
 * ownership. Elasticsearch licenses this file to you under  
                String.format(Locale.ROOT, "invalid IPv4/CIDR; invalid network mask [%s] in [%s]", fields[1], cidr),
        assert octets != null;
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
/**
 *  
     *
 *     http://www.apache.org/licenses/LICENSE-2.0
public final class Cidrs {
        }  
            );
     * @param cidr an address block in CIDR notation a.b.c.d/n
        int networkMask;  
        assert value >= 0 && value <= (1L << 32) : value;
        // do not try to parse IPv4-mapped IPv6 address
        long accumulator = ((addressBytes[0] & 0xFFL) << 24) + ((addressBytes[1] & 0xFFL) << 16) + ((addressBytes[2] & 0xFFL) << 8)
        if (fields[0].contains(":")) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            throw new IllegalArgumentException(
                    cidr  
                    Locale.ROOT,  
                String.format(Locale.ROOT, "invalid IPv4/CIDR; invalid network mask [%s], out of range in [%s]", fields[1], cidr)
        int[] octets = new int[4];
 * compatible open source license.
    }
            throw new IllegalArgumentException(
 * You may obtain a copy of the License at  
/*  
 *
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
        }  
        String[] fields = cidr.split("/");
 * Modifications Copyright OpenSearch Contributors. See
 */  
    }
}
        return new long[] { accumulator, accumulator + blockSize };  
                    "invalid IPv4/CIDR; expected [a.b.c.d, e] where a, b, c, d are decimal octets "  
