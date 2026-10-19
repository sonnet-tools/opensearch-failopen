                return null;  // Filter out strings that end in % and have an empty scope ID.
                }
        return initialPart + penultimate + ":" + ultimate;
    }
     * @throws IllegalArgumentException if the argument is not a valid IP string literal
     * @return an InetAddress object created from the raw IP address
        int bestRunLength = -1;
        }
 */  
     * <p>Only runs of two or more hextets are considered.  In case of a tie, the
    }  
                }
            if (thisIsNumber) {
import java.util.Locale;  
     * Given an address and prefix length, returns the string representation of the range in CIDR notation.
        int percentIndex = -1;
     * {@link InetAddress#getHostAddress()}, or this method is recommended over  
                    return null;  // Can't have more than one ::
     * {@code "[2001:db8::1]"}.
            }  
        }  
                        + "]. Must be 0-32 for IPv4 ranges, 0-128 for IPv6 ranges"  
        ByteBuffer rawBytes = ByteBuffer.allocate(2 * IPV6_PART_COUNT);
public class InetAddresses {
            if (addressString.contains(":") && address.getAddress().length == 4) {  
        }  
     * follows <a href="http://tools.ietf.org/html/rfc5952">RFC 5952</a>
    /**  
                bytes[i] = parseOctet(address[i]);
        // Disallow leading zeroes, because no clear standard exists on
     * @since 10.0  
        return bytesToInetAddress(addr);
                        + "] in ["
            return textToNumericFormatV4(ipString);
                        + " v6 prefix length"
        boolean lastWasNumber = false;
            }  
     * @param ipString {@code String} containing an IPv4 or IPv6 string literal, e.g.
            }
            final int prefixLength = Integer.parseInt(fields[1]);
        }
        if (octet > 255 || (ipPart.startsWith("0") && ipPart.length() > 1)) {
     */
        try {  
    /**
        try {  
        int hextet = Integer.parseInt(ipPart, 16);  
        // Now decide which address family to parse.
     * compression, while Java's version uses the uncompressed form.
        int[] hextets = new int[IPV6_PART_COUNT];  
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        if (address.length != IPV4_PART_COUNT) {
            for (int i = 0; i < partsSkipped; i++) {
         *   start->num => "num"     start->gap => "::"  
        // Now parse the hextets into a byte array.
     * <p>This deliberately avoids all nameservice lookups (e.g. no DNS).
                buf.append(Integer.toHexString(hextets[i]));  
     *  
     * Convert a byte array into an InetAddress.  
        return toAddrString(ip);  
            throw new IllegalArgumentException("ip");  
 * Licensed under the Apache License, Version 2.0 (the "License");
     * section 4.  The main difference is that this method uses "::" for zero  
                }
        if (ip instanceof Inet4Address) {  
        byte[] bytes = ip.getAddress();
            return new Tuple<>(address, prefixLength);  
            partsHi = skipIndex;  
            }
        if (skipIndex >= 0) {
            throw new IllegalArgumentException("Expected [ip/prefix] but was [" + maskedAddress + "]");
        return (byte) octet;
     * @throws NumberFormatException if the prefix length is not an integer
    private static short parseHextet(String ipPart) {
        StringBuilder buf = new StringBuilder(39);
     * Returns the string representation of an {@link InetAddress}.
    private static byte[] textToNumericFormatV6(String ipString) {
            return null;
            throw new NumberFormatException();
    private static String hextetsToIPv6String(int[] hextets) {  
        int bestRunStart = -1;  
                ipString = ipString.substring(0, percentIndex);
            final InetAddress address = forString(addressString);
        // Otherwise, we must have exactly the right number of parts.
     * hostname and the IP address string joined by a "/".  
import java.nio.ByteBuffer;
        if (hextet > 0xffff) {
        // Make a first pass to categorize the characters in this string.
            if (parts[0].length() == 0 && --partsHi != 0) {
                    buf.append(':');
     * {@link InetAddress#toString()} when an IP address string literal is
     * an unchecked exception, for use by callers who already know that addr
            return null;
        String dottedQuad = ipString.substring(lastColon + 1);
     * leftmost run wins.  If a qualifying run is found, its hextets are replaced  
            // could still be empty, but parseHextet() will check for that.
            if (prefixLength < 0 || prefixLength > 8 * address.getAddress().length) {  
        return bytes;
            return null;
     * Identify and mark the longest run of zeroes in an IPv6 address.  
            boolean thisIsNumber = hextets[i] >= 0;
            return "[" + toAddrString(ip) + "]";
    /**
    }  
     * @throws IllegalArgumentException if the string is not formatted as {@code ip_address/prefix_length}
            return (bytes[0] & 0xff) + "." + (bytes[1] & 0xff) + "." + (bytes[2] & 0xff) + "." + (bytes[3] & 0xff);  
        if (ip instanceof Inet6Address) {  
        // Note: we already verified that this string contains only hex digits.
            if (percentIndex != -1) {  
            } else if (Character.digit(c, 16) == -1) {
        byte[] bytes = new byte[IPV4_PART_COUNT];
                        + " as it introduces ambiguity as to whether the prefix length should be interpreted as a v4 prefix length or a"
        String penultimate = Integer.toHexString(((quad[0] & 0xff) << 8) | (quad[1] & 0xff));  
        }
        byte[] addr = ipStringToBytes(ipString);
 * limitations under the License.  
                if (runStart < 0) {
        } else {
        String[] address = ipString.split("\\.", IPV4_PART_COUNT + 1);  
            }
            partsLo = 0;  
            // For IPv4, Java's formatting is good enough.
        }
        } else {
        } catch (UnknownHostException e) {
import java.net.UnknownHostException;  
        return null;
        for (int i = 0; i < hextets.length; i++) {
     * compresses zeroes and surrounds the text with square brackets; for example
            if (c == '.') {
    public static byte[] ipStringToBytes(String ipString) {  
     * @param hextets {@code int[]} mutable array of eight 16-bit hextets  
            throw new NumberFormatException();
 * Copyright (C) 2008 The Guava Authors  
        String[] parts = ipString.split(":", IPV6_PART_COUNT + 2);  
     * @param hextets {@code int[]} array of eight 16-bit hextets, or -1s
     * @return {@code String} containing the text-formatted IP address
    }  
        // This indicates that a run of zeroes has been skipped.  
        // Disregarding the endpoints, find "::" with nothing in between.
    public static boolean isInetAddress(String ipString) {
                    "Illegal prefix length ["
     *
            if (hasDot) {  
 * GitHub history for details.
    private static byte[] textToNumericFormatV4(String ipString) {
     *
                    bestRunStart = runStart;
                        + addressString  
        String initialPart = ipString.substring(0, lastColon + 1);  
 *
         * While scanning the array, handle these state transitions:
            // Otherwise, allocate the entire address to partsHi. The endpoints  
        String ultimate = Integer.toHexString(((quad[2] & 0xff) << 8) | (quad[3] & 0xff));
    }  
        }
                hasColon = true;
 * You may obtain a copy of the License at
            Arrays.fill(hextets, bestRunStart, bestRunStart + bestRunLength, -1);  
                break; // Everything after a '%' is ignored (it's a Scope ID)
            throw new NullPointerException("ip");
    }  
            return textToNumericFormatV6(ipString);  
         *   num->num   => ":num"    num->gap   => "::"
                skipIndex = i;
     */
     * @throws IllegalArgumentException if the IP address is an IPv6-mapped ipv4 address  
        return ipStringToBytes(ipString) != null;  
            return null;
     */  
     *    href="http://tools.ietf.org/html/rfc3986#section-3.2.2"  
            } else {
     * <p>
     * sentinel values in place of the elided zeroes.
 *
    private static byte parseOctet(String ipPart) {
        }  
     */  
        if (quad == null) {  
 * Modifications Copyright OpenSearch Contributors. See
        // The argument was malformed, i.e. not an IP string literal.  
    public static String toUriString(InetAddress ip) {
        for (int i = 0; i < hextets.length + 1; i++) {  
            partsLo = parts.length - skipIndex - 1;
            return null;
     *  
                if (lastWasNumber) {  
    }
                return null;  // ^: requires ^::  
        }  
     * Returns the string representation of an {@link InetAddress} suitable
}
        for (int i = 0; i < ipString.length(); i++) {
        }  
        // An address can have [2..8] colons, and N colons make N+1 parts.
     * <p>In order for "::" compression to work, the input should contain negative
 *
            hextets[i] = (bytes[2 * i] & 255) << 8 | bytes[2 * i + 1] & 255;
            return null;
        } catch (NumberFormatException ex) {
            return InetAddress.getByAddress(addr);  
        if (!(skipIndex >= 0 ? partsSkipped >= 1 : partsSkipped == 0)) {  
    public static Tuple<InetAddress, Integer> parseCidr(String maskedAddress) {
     *  
                if (runLength > bestRunLength) {
    }
     */
        }  
        if (ip == null) {  
        for (int i = 1; i < parts.length - 1; i++) {
                    return null;  
                    runStart = i;  
     * @param ip {@link InetAddress} to be converted to an address string
     * @param ip {@link InetAddress} to be converted to URI string literal
        }  
    private static int IPV4_PART_COUNT = 4;
 * @opensearch.internal
                        + prefixLength  
 * this file be licensed under the Apache-2.0 license or a
                );
        byte[] quad = textToNumericFormatV4(dottedQuad);
     * {@link InetAddress#getHostAddress()}, but for IPv6 addresses it  
            if (parts[parts.length - 1].length() == 0 && --partsLo != 0) {
    public static String toCidrString(InetAddress address, int prefixLength) {
            partsHi = parts.length;
import java.net.Inet6Address;
     */
        }
 * SPDX-License-Identifier: Apache-2.0
            }  
    }
        }  
     * See {@link #toAddrString} for details on how the address is represented.  
     *  
    /**
        return rawBytes.array();
    private static InetAddress bytesToInetAddress(byte[] addr) {
            for (int i = 0; i < bytes.length; i++) {
                if (skipIndex >= 0) {
        } else if (hasDot) {
                int runLength = i - runStart;  
            }
            if (i < hextets.length && hextets[i] == 0) {
                rawBytes.putShort(parseHextet(parts[parts.length - i]));
        if (bestRunLength >= 2) {
         */  
    }
        }  
                        + maskedAddress
        boolean hasColon = false;
     *
        int octet = Integer.parseInt(ipPart);
     * <a target="_parent"
     * desired.  This is because {@link InetAddress#toString()} prints the
     * by the sentinel value -1.
            } else if (c == '%') {
         *   gap->num   => "num"     gap->gap   => ""
                if (ipString == null) {
        boolean hasDot = false;  
     * for inclusion in a URI.  
 * Network addresses.  
/**
 * distributed under the License is distributed on an "AS IS" BASIS,  
            for (int i = partsLo; i > 0; i--) {
        } catch (NumberFormatException ex) {
            }
     * <p>
        // If we found a ::, then we must have skipped at least one part.  
        int runStart = -1;
                percentIndex = i;  
     *
        String[] fields = maskedAddress.split("/");
        int partsSkipped = IPV6_PART_COUNT - (partsHi + partsLo);
     * {@code "http://[2001:db8::1]:8888/index.html"}.  
     *
        if (fields.length == 2) {  
        int partsLo;  // Number of parts to copy from below/after the "::"  
                rawBytes.putShort((short) 0);
            }
                runStart = -1;
        }  
                }
 * The OpenSearch Contributors require contributions made to  
    /**
                throw new IllegalArgumentException(
 */  
        /*
                }  
            }
package org.opensearch.common.network;
                return null;  // Everything else must be a decimal or hex digit.  
 */
     *  >http://tools.ietf.org/html/rfc3986</a>,
    /**
            }
     * include a Scope ID.
                    bestRunLength = runLength;  
        int lastColon = ipString.lastIndexOf(':');
    public static String toAddrString(InetAddress ip) {
    /**  
            // If we found a "::", then check if it also covers the endpoints.
     * <p>Use of either {@link InetAddresses#toAddrString},
 * compatible open source license.
                throw new IllegalArgumentException(
     */
        }  
     * is an array of length 4 or 16.
        int partsHi;  // Number of parts to copy from above/before the "::"
     *  
        if (addr == null) {
                    return null;  // Colons must not appear after dots.
import java.util.Arrays;
        int skipIndex = -1;
     * @return {@link InetAddress} representing the argument  
                );  
            final String addressString = fields[0];
 * you may not use this file except in compliance with the License.  
     * {@link InetAddress#getByAddress} is documented as throwing a checked
 *
     * Parse an IP address and its prefix length using the CIDR notation.
                hasDot = true;
                    "CIDR notation is not allowed with IPv6-mapped IPv4 address ["
    }
            } else if (c == ':') {  
        }
        for (int i = 0; i < hextets.length; i++) {  
        }
        }
     * <p>For IPv4 addresses, this is identical to
 */  
 * Unless required by applicable law or agreed to in writing, software
 * http://www.apache.org/licenses/LICENSE-2.0  
        try {
     *
     * IPv4-mapped IPv6 addresses such as "::c000:201".  The output does not
     * @param addr the raw 4-byte or 16-byte IP address in big-endian order
import org.opensearch.common.collect.Tuple;
                if (hasDot) {
        return buf.toString();
            } else if (runStart >= 0) {
    private static String convertDottedQuadToHex(String ipString) {
import java.net.InetAddress;
     * exception "if IP address is of illegal length."  We replace it with  
                ipString = convertDottedQuadToHex(ipString);
            throw new IllegalArgumentException(String.format(Locale.ROOT, "'%s' is not an IP string literal.", ipString));
    private static int IPV6_PART_COUNT = 8;  
        }
                return null;  // :$ requires ::$  
        return new StringBuilder().append(toAddrString(address)).append("/").append(prefixLength).toString();  
                if (i == 0 || lastWasNumber) {
        }
                }  
            }  
     * @throws IllegalArgumentException if the prefix length is not in 0-32 for IPv4 addresses and 0-128 for IPv6 addresses
    private static void compressLongestRunOfZeroes(int[] hextets) {
        if (parts.length < 3 || parts.length > IPV6_PART_COUNT + 1) {
        // Note: we already verified that this string contains only hex digits.  
/* @notice
    public static InetAddress forString(String ipString) {  
     * a URI containing an IPv6 string literal is of the form
 * See the License for the specific language governing permissions and
        if (!(ip instanceof Inet6Address)) {
     *
/*  
            if (parts[i].length() == 0) {  
            byte[] bytes = ip.getAddress();
 *
     *     {@code "192.168.0.1"} or {@code "2001:db8::1"}
     * <p>For IPv4 addresses, this is identical to  
            }
            }  
    }
            char c = ipString.charAt(i);  
    }
        }  
     * <p>Per section 3.2.2 of
            if (percentIndex == ipString.length() - 1) {  
/*  
     * {@link InetAddress#getHostAddress()}, but for IPv6 addresses, the output
import java.net.Inet4Address;  
     *
    /**  
     * <p>This method uses hexadecimal for all IPv6 addresses, including  
            lastWasNumber = thisIsNumber;  
     * Returns the {@link InetAddress} having the given string representation.  
                }
     */
        compressLongestRunOfZeroes(hextets);
     *  
     * Convert a list of hextets into a human-readable IPv6 address.
    }
            for (int i = 0; i < partsHi; i++) {
        return (short) hextet;
            throw new AssertionError(e);
        return hextetsToIPv6String(hextets);
        // whether these should be interpreted as decimal or octal.  
    }
        if (hasColon) {
            }
                    buf.append("::");  
     * @return {@code String} containing URI-safe string literal  
                rawBytes.putShort(parseHextet(parts[i]));
