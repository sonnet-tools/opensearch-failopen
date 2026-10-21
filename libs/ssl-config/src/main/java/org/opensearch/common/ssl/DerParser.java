import java.io.IOException;
         * -------------------------------------------------
         * </p>
    }
    private static final int OBJECT_OID = 0x06;
                    sb.append('2');
    private static final int INTEGER = 0x02;
        }
         *     The first byte in DER encoding is made of following fields:
         *
        int n = derInputStream.read(bytes);
        if (tag == -1) {
    private InputStream derInputStream;
            this.tag = tag;
            }
            this.value = value;
import java.io.ByteArrayInputStream;
         *
 * Modifications Copyright OpenSearch Contributors. See
         * @param length Length of the field
         * </ul>
            if (type != DerParser.OBJECT_OID) {
        /**
        protected final int tag;
 */
            sb.append(HEX_DIGITS[b >> 4 & 0xf]).append(HEX_DIGITS[b & 0xf]);
            switch (value[0] / 40) {
         * @return BigInteger
                    value[0] -= 80;
            return new DerParser(value);
  distributed under the License is distributed on an "AS IS" BASIS,
        if (n < length) {
                    break;
        byte[] bytes = new byte[num];
    }
            }
            for (int i = 0; i < length; i++) {
        if (n < num) throw new IOException("Invalid DER: length too short");
            return (tag & DerParser.CONSTRUCTED) == DerParser.CONSTRUCTED;
    private static final int ISO646_STRING = 0x1A;
    private static final int IA5_STRING = 0x16;
         * <li>Class: Universal, Application, Context or Private
    private static final int GRAPHIC_STRING = 0x19;
     * Decode the length of the field. Can only support length
        }
 */
        this.derInputStream = new ByteArrayInputStream(bytes);
         * constructed or primitive entity.
    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();
     * @return The length as integer
     */
            StringBuilder sb = new StringBuilder(64);
  Unless required by applicable law or agreed to in writing, software
}
     *
 * The OpenSearch Contributors require contributions made to
        int n = derInputStream.read(value);
        public String getString() throws IOException {
    private static final int PRINTABLE_STRING = 0x13;
                    sb.append('.');
        return sb.toString();
     * </li>
    private static String toHexString(byte[] bytes) {
     * </li>
                case DerParser.UTF8_STRING:
            throw new IOException("Invalid DER: stream too short, missing tag");
                case DerParser.IA5_STRING:
    DerParser(byte[] bytes) {
        /**
                case DerParser.VIDEOTEX_STRING:
         * @param value  Encoded octet string for the field.
            );
     * only handle integers.
        }
      http://www.apache.org/licenses/LICENSE-2.0
            throw new IOException(
        if (i >= 0xFF || num > 4) throw new IOException("Invalid DER: length field too big (" + i + ")"); //$NON-NLS-2$
        int length = getLength();
  you may not use this file except in compliance with the License.
    /**
            return type;
        public int getLength() {
import java.io.InputStream;
         * -------------------------------------------------
        int tag = derInputStream.read();
 * compatible open source license.
        protected final int type;
     * <p>
     * </p>
                    break;
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * <li>Long form. Two to 127 octets (only 4 is supported here).
                case DerParser.ISO646_STRING:
  Licensed under the Apache License, Version 2.0 (the "License");
        public DerParser getParser() throws IOException {
     *          In BER/DER encoding, length can be encoded in 2 forms:
        public BigInteger getInteger() throws IOException {
                oidPart = (oidPart << 7) + (value[i] & 0x7F);
        // force us into allocating a very large array
     * encoding up to 4 octets.
  Copyright (c) 1998-2010 AOL Inc.
import java.math.BigInteger;
        public int getType() {
                    break;
                    sb.append(oidPart);
     * </ul>
  You may obtain a copy of the License at
/* @notice
     */
                    return toHexString(value);
    private int getLength() throws IOException {
        for (int i = 0; i < bytes.length; i++) {
         * <ul>
        StringBuilder sb = new StringBuilder(2 * bytes.length);
         * -------------------------------------------------
            return new BigInteger(value);
                    break;
 * main/java/org/apache/jmeter/protocol/oauth/sampler/PrivateKeyReader.java
                case DerParser.NUMERIC_STRING:
            return length;
        // A single byte short length
 */
        protected final int length;
/*
         */
                    oidPart = 0;
 * <p>
                default:
        Asn1Object(int tag, int length, byte[] value) {
    // Tag and data types
        // We can't handle length longer than 4 bytes
    private int maxAsnObjectLength;
            String encoding;
                "Invalid DER: stream too short, missing value. " + "Could only read " + n + " out of " + length + " bytes"
        if (length > maxAsnObjectLength) {
         * @param tag    Tag or Identifier
 * GitHub history for details.
    static class Asn1Object {
                    sb.append('1');
                    value[0] -= 40;
    private static final int VIDEOTEX_STRING = 0x15;
            return sb.toString();
            int oidPart = 0;
        /**
                    // octet string is basically a byte array
        return new BigInteger(1, bytes).intValue();
        this.maxAsnObjectLength = bytes.length;
            }
        }
    private static final int BMP_STRING = 0x1E;
    }
     * <li>Short form. One octet. Bit 8 has value "0" and bits 7-1
            byte b = bytes[i];
        }
        }
     * <ul>
                default:
                "Invalid DER: size of ASN.1 object to be parsed appears to be larger than the size of the key file " + "itself."
         * Construct a ASN.1 TLV. The TLV could be either a
        }
            this.length = length;
                    encoding = "ISO-8859-1"; //$NON-NLS-1$
final class DerParser {
        public String getOid() throws IOException {
                case DerParser.GENERAL_STRING:
                throw new IOException("Ivalid DER: object is not object OID");
     *
/*
  See the License for the specific language governing permissions and
  limitations under the License.
                case 1:
        return new Asn1Object(tag, length, value);
     * @author zhang
     * give the length.
                }
    /**
        if ((i & ~0x7F) == 0) return i;
        public byte[] getValue() {
            if (!isConstructed()) throw new IOException("Invalid DER: can't parse primitive entity"); //$NON-NLS-1$
         * <p>
        Objects.requireNonNull(bytes);
                    sb.append('0');
         * |  Class    | CF  |     +      Type             |
         * <li>CF: Constructed flag. If 1, the field is constructed.
        public boolean isConstructed() {
/**
     * Bit 8 of first octet has value "1" and bits 7-1 give the
            throw new IOException(
        // getLength() can return any 32 bit integer, so ensure that a corrupted encoding won't
                    throw new IOException("Invalid DER: can't handle UCS-4 string"); //$NON-NLS-1$
 * A bare-minimum ASN.1 DER decoder, just having enough functions to
                    throw new IOException("Invalid DER: object is not a string"); //$NON-NLS-1$
            this.type = tag & 0x1F;
        }
            }
        byte[] value = new byte[length];
    private static final int OCTET_STRING = 0x04;
 *
            );
                if ((value[i] & 0x80) == 0) {
    // Constructed Flag
    private static final int UTF8_STRING = 0x0C;
    }
                    encoding = "UTF-16BE"; //$NON-NLS-1$
         * <pre>
    private static final int GENERAL_STRING = 0x1B;
            switch (type) {
package org.opensearch.common.ssl;
    }
 * SPDX-License-Identifier: Apache-2.0
                    break;
                case DerParser.UNIVERSAL_STRING:
         * </pre>
        int i = derInputStream.read();
         */
                case DerParser.BMP_STRING:
                case DerParser.PRINTABLE_STRING:
            return new String(value, encoding);
        }
 * decode PKCS#1 private keys in order to remain JCE/JVM agnostic.
     * octets give the length, base 256, most significant digit first.
        }
        }
            if (type != DerParser.INTEGER) throw new IOException("Invalid DER: object is not integer"); //$NON-NLS-1$
     * number of additional length octets. Second and following
    private static final int UNIVERSAL_STRING = 0x1C;
         * For constructed field, return a parser for its content.
    private static final int NUMERIC_STRING = 0x12;
 */
                case DerParser.GRAPHIC_STRING:
                    break;
         * |Bit 8|Bit 7|Bit 6|Bit 5|Bit 4|Bit 3|Bit 2|Bit 1|
                case 0:
                    encoding = "UTF-8"; //$NON-NLS-1$
        protected final byte[] value;
    Asn1Object readAsn1Object() throws IOException {
     * An ASN.1 TLV. The object is not parsed. It can
         * <li>Type: This is actually called tag in ASN.1. It
        }
 * this file be licensed under the Apache-2.0 license or a
         */
         * Get the value as integer
        }
    private static final int CONSTRUCTED = 0x20;
import java.util.Objects;
         *
                case DerParser.OCTET_STRING:
        if (i == -1) throw new IOException("Invalid DER: length missing");
 * Based on https://github.com/groovenauts/jmeter_oauth_plugin/blob/master/jmeter/src/
         * @return A parser for the construct.
         * indicates data type (Integer, String) or a construct
            return value;
        int num = i & 0x7F;
         * (sequence, choice, set).
