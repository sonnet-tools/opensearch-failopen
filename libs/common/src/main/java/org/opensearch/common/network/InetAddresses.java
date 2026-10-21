        if (!(ip instanceof Inet6Address)) {
                skipIndex = i;
     *
     * {@link InetAddress#getByAddress} is documented as throwing a checked
            return null;
     *
     */
        // The argument was malformed, i.e. not an IP string literal.
import java.nio.ByteBuffer;
import java.util.Locale;
package org.opensearch.common.network;
    public static InetAddress forString(String ipString) {
        int octet = Integer.parseInt(ipPart);
    private static byte parseOctet(String ipPart) {
        boolean hasDot = false;
     * Given an address and prefix length, returns the string representation of the range in CIDR notation.
     * <p>Per section 3.2.2 of
        if (hasColon) {
/*
            } else {
        }
     * IPv4-mapped IPv6 addresses such as "::c000:201".  The output does not
/*
     * <p>In order for "::" compression to work, the input should contain negative
                if (runStart < 0) {
    /**
        int[] hextets = new int[IPV6_PART_COUNT];
            }
                if (ipString == null) {
 */
    /**
            throw new IllegalArgumentException(String.format(Locale.ROOT, "'%s' is not an IP string literal.", ipString));
            }
            final int prefixLength = Integer.parseInt(fields[1]);
            return null;
    /**
                ipString = convertDottedQuadToHex(ipString);
        }
            partsLo = 0;
            } else if (Character.digit(c, 16) == -1) {
    private static byte[] textToNumericFormatV6(String ipString) {
     * sentinel values in place of the elided zeroes.
            if (prefixLength < 0 || prefixLength > 8 * address.getAddress().length) {
    private static short parseHextet(String ipPart) {
            }
     */
     */
                hasDot = true;
 * http://www.apache.org/licenses/LICENSE-2.0
        if (ip == null) {
        // If we found a ::, then we must have skipped at least one part.
        int percentIndex = -1;
    }
    /**
        }
        return hextetsToIPv6String(hextets);
        try {
        }
    }
     * leftmost run wins.  If a qualifying run is found, its hextets are replaced
        byte[] bytes = new byte[IPV4_PART_COUNT];
            }
        try {
        byte[] bytes = ip.getAddress();
 *
            } else if (c == ':') {
     * @throws NumberFormatException if the prefix length is not an integer
        }
        boolean hasColon = false;
    }
                }
                if (skipIndex >= 0) {
}
        }
        } catch (NumberFormatException ex) {
        // Now parse the hextets into a byte array.
            if (c == '.') {
        }
                );
     * @param ip {@link InetAddress} to be converted to URI string literal
         *   num->num   => ":num"    num->gap   => "::"
            return (bytes[0] & 0xff) + "." + (bytes[1] & 0xff) + "." + (bytes[2] & 0xff) + "." + (bytes[3] & 0xff);
    public static byte[] ipStringToBytes(String ipString) {
        // Note: we already verified that this string contains only hex digits.
                }
     * @throws IllegalArgumentException if the IP address is an IPv6-mapped ipv4 address
 * See the License for the specific language governing permissions and
        } else if (hasDot) {
                return null;  // :$ requires ::$
                    buf.append(':');
            return new Tuple<>(address, prefixLength);
            }
                    runStart = i;
     */
     */
        // This indicates that a run of zeroes has been skipped.
     * @throws IllegalArgumentException if the string is not formatted as {@code ip_address/prefix_length}
            throw new NullPointerException("ip");
        compressLongestRunOfZeroes(hextets);
     * @return {@code String} containing URI-safe string literal
                        + maskedAddress
            if (addressString.contains(":") && address.getAddress().length == 4) {
     * @return {@code String} containing the text-formatted IP address
            for (int i = 0; i < bytes.length; i++) {
        return rawBytes.array();
        if (octet > 255 || (ipPart.startsWith("0") && ipPart.length() > 1)) {
 *
    private static int IPV6_PART_COUNT = 8;
                rawBytes.putShort((short) 0);
                buf.append(Integer.toHexString(hextets[i]));
 * Unless required by applicable law or agreed to in writing, software
            boolean thisIsNumber = hextets[i] >= 0;
            partsLo = parts.length - skipIndex - 1;
        for (int i = 0; i < hextets.length; i++) {
     * <p>For IPv4 addresses, this is identical to
     * @param hextets {@code int[]} mutable array of eight 16-bit hextets
        // Note: we already verified that this string contains only hex digits.
        }
        if (addr == null) {
     *
     *
                if (runLength > bestRunLength) {
        int partsLo;  // Number of parts to copy from below/after the "::"
        }
     * {@link InetAddress#toString()} when an IP address string literal is
    }
    }
     * {@link InetAddress#getHostAddress()}, but for IPv6 addresses it
     *    href="http://tools.ietf.org/html/rfc3986#section-3.2.2"
        String[] fields = maskedAddress.split("/");
     *
        int skipIndex = -1;
            // For IPv4, Java's formatting is good enough.
            throw new NumberFormatException();
        }
            }
        if (ip instanceof Inet6Address) {
        String dottedQuad = ipString.substring(lastColon + 1);
    private static int IPV4_PART_COUNT = 4;
     * @throws IllegalArgumentException if the prefix length is not in 0-32 for IPv4 addresses and 0-128 for IPv6 addresses
     * @param ip {@link InetAddress} to be converted to an address string
        if (fields.length == 2) {
public class InetAddresses {
    }
        if (parts.length < 3 || parts.length > IPV6_PART_COUNT + 1) {
                rawBytes.putShort(parseHextet(parts[i]));
                ipString = ipString.substring(0, percentIndex);
        StringBuilder buf = new StringBuilder(39);
        }
        }
     *
        byte[] quad = textToNumericFormatV4(dottedQuad);
            if (thisIsNumber) {
                throw new IllegalArgumentException(
            return textToNumericFormatV6(ipString);
            for (int i = partsLo; i > 0; i--) {
            } else if (runStart >= 0) {
 * Modifications Copyright OpenSearch Contributors. See
                break; // Everything after a '%' is ignored (it's a Scope ID)
            hextets[i] = (bytes[2 * i] & 255) << 8 | bytes[2 * i + 1] & 255;
            char c = ipString.charAt(i);
         */
     */
                }
            final String addressString = fields[0];
        }
     * by the sentinel value -1.
        return null;
     * {@link InetAddress#getHostAddress()}, or this method is recommended over
                    return null;  // Colons must not appear after dots.
     * <p>
    }
 *
            }
            if (parts[i].length() == 0) {
            return null;
     * include a Scope ID.
                    return null;  // Can't have more than one ::
        return bytes;
        // Make a first pass to categorize the characters in this string.
            partsHi = skipIndex;
    public static Tuple<InetAddress, Integer> parseCidr(String maskedAddress) {
            }
            return null;
        ByteBuffer rawBytes = ByteBuffer.allocate(2 * IPV6_PART_COUNT);
 * Licensed under the Apache License, Version 2.0 (the "License");
        String ultimate = Integer.toHexString(((quad[2] & 0xff) << 8) | (quad[3] & 0xff));
        if (!(skipIndex >= 0 ? partsSkipped >= 1 : partsSkipped == 0)) {
     * <p>Use of either {@link InetAddresses#toAddrString},
                int runLength = i - runStart;
     * See {@link #toAddrString} for details on how the address is represented.
            throw new AssertionError(e);
                }
     * <p>For IPv4 addresses, this is identical to
     *  >http://tools.ietf.org/html/rfc3986</a>,
        String[] parts = ipString.split(":", IPV6_PART_COUNT + 2);
        String penultimate = Integer.toHexString(((quad[0] & 0xff) << 8) | (quad[1] & 0xff));
            throw new NumberFormatException();
    }
            }
     *
                    return null;
                if (i == 0 || lastWasNumber) {
                        + " v6 prefix length"
     * {@code "[2001:db8::1]"}.
import org.opensearch.common.collect.Tuple;
        }
 * Copyright (C) 2008 The Guava Authors
     * Parse an IP address and its prefix length using the CIDR notation.
 * @opensearch.internal
        return initialPart + penultimate + ":" + ultimate;
        return new StringBuilder().append(toAddrString(address)).append("/").append(prefixLength).toString();
        for (int i = 0; i < hextets.length + 1; i++) {
     * @param hextets {@code int[]} array of eight 16-bit hextets, or -1s
     * {@code "http://[2001:db8::1]:8888/index.html"}.
                percentIndex = i;
                        + addressString
    /**
            if (hasDot) {
            return textToNumericFormatV4(ipString);
                    bestRunStart = runStart;
        return (short) hextet;
    }
        int bestRunStart = -1;
     * compresses zeroes and surrounds the text with square brackets; for example
        int runStart = -1;
                }
 * distributed under the License is distributed on an "AS IS" BASIS,
                }
        // Otherwise, we must have exactly the right number of parts.
            return null;
     * @since 10.0
        if (quad == null) {
            if (parts[parts.length - 1].length() == 0 && --partsLo != 0) {
            if (percentIndex == ipString.length() - 1) {
        if (skipIndex >= 0) {
        int bestRunLength = -1;
    private static byte[] textToNumericFormatV4(String ipString) {
                }
        } else {
                    "Illegal prefix length ["
    private static InetAddress bytesToInetAddress(byte[] addr) {
     * <a target="_parent"
        }
     * is an array of length 4 or 16.
        // whether these should be interpreted as decimal or octal.
            return "[" + toAddrString(ip) + "]";
 * you may not use this file except in compliance with the License.
            // could still be empty, but parseHextet() will check for that.
        return (byte) octet;
     * @param addr the raw 4-byte or 16-byte IP address in big-endian order
     * desired.  This is because {@link InetAddress#toString()} prints the
     * a URI containing an IPv6 string literal is of the form
     * section 4.  The main difference is that this method uses "::" for zero
            for (int i = 0; i < partsHi; i++) {
                return null;  // Everything else must be a decimal or hex digit.
        if (hextet > 0xffff) {
         * While scanning the array, handle these state transitions:
            }
                hasColon = true;
        } catch (UnknownHostException e) {
    }
        return ipStringToBytes(ipString) != null;
     * Convert a list of hextets into a human-readable IPv6 address.
    }
         *   gap->num   => "num"     gap->gap   => ""
 * compatible open source license.
        boolean lastWasNumber = false;
     * Returns the {@link InetAddress} having the given string representation.
        return buf.toString();
        int lastColon = ipString.lastIndexOf(':');
            Arrays.fill(hextets, bestRunStart, bestRunStart + bestRunLength, -1);
    public static String toUriString(InetAddress ip) {
    private static String hextetsToIPv6String(int[] hextets) {
     * Returns the string representation of an {@link InetAddress} suitable
import java.net.Inet4Address;
        return toAddrString(ip);
        }
                bytes[i] = parseOctet(address[i]);
     * @return {@link InetAddress} representing the argument
import java.net.Inet6Address;
                        + "] in ["
     * @throws IllegalArgumentException if the argument is not a valid IP string literal
        } else {
         *   start->num => "num"     start->gap => "::"
        // Disallow leading zeroes, because no clear standard exists on
        // An address can have [2..8] colons, and N colons make N+1 parts.
            } else if (c == '%') {
                );
     * @return an InetAddress object created from the raw IP address
    public static String toAddrString(InetAddress ip) {
                rawBytes.putShort(parseHextet(parts[parts.length - i]));
        for (int i = 0; i < ipString.length(); i++) {
                if (hasDot) {
     * <p>This deliberately avoids all nameservice lookups (e.g. no DNS).
    /**
    }
/* @notice
 * You may obtain a copy of the License at
     *
        int hextet = Integer.parseInt(ipPart, 16);
            }
     * an unchecked exception, for use by callers who already know that addr
            for (int i = 0; i < partsSkipped; i++) {
        if (bestRunLength >= 2) {
     * <p>This method uses hexadecimal for all IPv6 addresses, including
            throw new IllegalArgumentException("ip");
     * hostname and the IP address string joined by a "/".
        } catch (NumberFormatException ex) {
        // Disregarding the endpoints, find "::" with nothing in between.
        for (int i = 0; i < hextets.length; i++) {
                    buf.append("::");
            lastWasNumber = thisIsNumber;
                        + "]. Must be 0-32 for IPv4 ranges, 0-128 for IPv6 ranges"
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * @param ipString {@code String} containing an IPv4 or IPv6 string literal, e.g.
     * follows <a href="http://tools.ietf.org/html/rfc5952">RFC 5952</a>
 * this file be licensed under the Apache-2.0 license or a
     * {@link InetAddress#getHostAddress()}, but for IPv6 addresses, the output
 */
    /**
     * Convert a byte array into an InetAddress.
     *
                        + prefixLength
     *
 *
    /**
     */
     * Identify and mark the longest run of zeroes in an IPv6 address.
        return bytesToInetAddress(addr);
/**
        try {
     *
                    "CIDR notation is not allowed with IPv6-mapped IPv4 address ["
        }
        if (ip instanceof Inet4Address) {
        }
                if (lastWasNumber) {
     * for inclusion in a URI.
            partsHi = parts.length;
 */
        for (int i = 1; i < parts.length - 1; i++) {
            }
            }
                        + " as it introduces ambiguity as to whether the prefix length should be interpreted as a v4 prefix length or a"
 * GitHub history for details.
            return InetAddress.getByAddress(addr);
     * Returns the string representation of an {@link InetAddress}.
            }
     * compression, while Java's version uses the uncompressed form.
            // Otherwise, allocate the entire address to partsHi. The endpoints
            return null;
            // If we found a "::", then check if it also covers the endpoints.
 * The OpenSearch Contributors require contributions made to
    }
            }
                return null;  // ^: requires ^::
        // Now decide which address family to parse.
    }
    }
     * <p>Only runs of two or more hextets are considered.  In case of a tie, the
    private static String convertDottedQuadToHex(String ipString) {
            if (percentIndex != -1) {
                throw new IllegalArgumentException(
     *
        }
            throw new IllegalArgumentException("Expected [ip/prefix] but was [" + maskedAddress + "]");
        String initialPart = ipString.substring(0, lastColon + 1);
        String[] address = ipString.split("\\.", IPV4_PART_COUNT + 1);
        if (address.length != IPV4_PART_COUNT) {
     *     {@code "192.168.0.1"} or {@code "2001:db8::1"}
        }
        int partsSkipped = IPV6_PART_COUNT - (partsHi + partsLo);
 * Network addresses.
     *
    public static boolean isInetAddress(String ipString) {
 */
    public static String toCidrString(InetAddress address, int prefixLength) {
        int partsHi;  // Number of parts to copy from above/before the "::"
            final InetAddress address = forString(addressString);
                runStart = -1;
import java.net.UnknownHostException;
            if (parts[0].length() == 0 && --partsHi != 0) {
        }
 * limitations under the License.
 *
import java.net.InetAddress;
        }
                return null;  // Filter out strings that end in % and have an empty scope ID.
        byte[] addr = ipStringToBytes(ipString);
import java.util.Arrays;
 * SPDX-License-Identifier: Apache-2.0
    private static void compressLongestRunOfZeroes(int[] hextets) {
     *
                    bestRunLength = runLength;
     * <p>
            byte[] bytes = ip.getAddress();
        /*
     */
        }
            if (i < hextets.length && hextets[i] == 0) {
     * exception "if IP address is of illegal length."  We replace it with
