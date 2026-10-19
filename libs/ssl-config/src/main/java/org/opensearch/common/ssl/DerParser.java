                oidPart = (oidPart << 7) + (value[i] & 0x7F);  
                    sb.append('1');
}
                default:
        this.derInputStream = new ByteArrayInputStream(bytes);  
    static class Asn1Object {
        }  
            }
            if (!isConstructed()) throw new IOException("Invalid DER: can't parse primitive entity"); //$NON-NLS-1$
        byte[] bytes = new byte[num];  
        /**
 * compatible open source license.
        protected final int length;
        public byte[] getValue() {  
            byte b = bytes[i];
         * -------------------------------------------------
        }
        int n = derInputStream.read(bytes);
        /**
         * @param tag    Tag or Identifier
    private static final int UTF8_STRING = 0x0C;
                    sb.append('0');
import java.io.IOException;  
            this.length = length;  
     */  
         * @param value  Encoded octet string for the field.
    }  
import java.util.Objects;  
 */
        }
    private static final char[] HEX_DIGITS = "0123456789abcdef".toCharArray();  
 * A bare-minimum ASN.1 DER decoder, just having enough functions to  
        }
 */
         * <li>Type: This is actually called tag in ASN.1. It  
         * -------------------------------------------------  
                default:
                    encoding = "UTF-16BE"; //$NON-NLS-1$
     * </li>  
            return value;
     * <ul>
        if (n < num) throw new IOException("Invalid DER: length too short");
                    throw new IOException("Invalid DER: object is not a string"); //$NON-NLS-1$  
        int i = derInputStream.read();
        // force us into allocating a very large array
                    // octet string is basically a byte array  
                case DerParser.PRINTABLE_STRING:  
    DerParser(byte[] bytes) {
    private static final int BMP_STRING = 0x1E;  
                    encoding = "ISO-8859-1"; //$NON-NLS-1$  
  Unless required by applicable law or agreed to in writing, software
    private int maxAsnObjectLength;  
     * octets give the length, base 256, most significant digit first.
                case DerParser.VIDEOTEX_STRING:
    }
            for (int i = 0; i < length; i++) {
 * GitHub history for details.  
        protected final byte[] value;
            }
        if (tag == -1) {  
 * <p>
    private static final int OBJECT_OID = 0x06;
/* @notice
         * (sequence, choice, set).
        if (i >= 0xFF || num > 4) throw new IOException("Invalid DER: length field too big (" + i + ")"); //$NON-NLS-2$
                    break;
         * @param length Length of the field  
         * |Bit 8|Bit 7|Bit 6|Bit 5|Bit 4|Bit 3|Bit 2|Bit 1|
        Objects.requireNonNull(bytes);  
            }  
            sb.append(HEX_DIGITS[b >> 4 & 0xf]).append(HEX_DIGITS[b & 0xf]);
     * encoding up to 4 octets.  
     * <li>Short form. One octet. Bit 8 has value "0" and bits 7-1
package org.opensearch.common.ssl;  
    private static final int VIDEOTEX_STRING = 0x15;
     * @author zhang
     * </li>
    private int getLength() throws IOException {
        }  
         * indicates data type (Integer, String) or a construct
  You may obtain a copy of the License at
                if ((value[i] & 0x80) == 0) {
     * <li>Long form. Two to 127 octets (only 4 is supported here).
 * main/java/org/apache/jmeter/protocol/oauth/sampler/PrivateKeyReader.java
    private static final int IA5_STRING = 0x16;
    private static final int INTEGER = 0x02;
     * <p>
            this.type = tag & 0x1F;
                    sb.append('2');  
                    break;  
                    encoding = "UTF-8"; //$NON-NLS-1$
    private static final int NUMERIC_STRING = 0x12;
        public String getString() throws IOException {  
        Asn1Object(int tag, int length, byte[] value) {  
 */
    private InputStream derInputStream;
            String encoding;
    private static final int CONSTRUCTED = 0x20;
         *
            return type;
         * For constructed field, return a parser for its content.  
    }
  See the License for the specific language governing permissions and
        public boolean isConstructed() {
                case DerParser.UNIVERSAL_STRING:
        StringBuilder sb = new StringBuilder(2 * bytes.length);
         * </p>
  distributed under the License is distributed on an "AS IS" BASIS,  
            if (type != DerParser.OBJECT_OID) {
  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        if (length > maxAsnObjectLength) {  
  you may not use this file except in compliance with the License.  
    /**
                case DerParser.GENERAL_STRING:
     */
            throw new IOException(
         * |  Class    | CF  |     +      Type             |  
                    sb.append('.');
        this.maxAsnObjectLength = bytes.length;
     * number of additional length octets. Second and following
                    return toHexString(value);
                    break;
         * -------------------------------------------------
            switch (type) {
            return (tag & DerParser.CONSTRUCTED) == DerParser.CONSTRUCTED;
        public int getLength() {
         */
        protected final int type;  
        }
                    throw new IOException("Invalid DER: can't handle UCS-4 string"); //$NON-NLS-1$  
            StringBuilder sb = new StringBuilder(64);
        // A single byte short length
                    break;
            if (type != DerParser.INTEGER) throw new IOException("Invalid DER: object is not integer"); //$NON-NLS-1$
                "Invalid DER: stream too short, missing value. " + "Could only read " + n + " out of " + length + " bytes"  
                case DerParser.OCTET_STRING:
        int length = getLength();  
 */  
         * Get the value as integer
 *
         * @return A parser for the construct.
/**
        }
            );
                    break;  
        if (i == -1) throw new IOException("Invalid DER: length missing");
     * Decode the length of the field. Can only support length
                    oidPart = 0;
                }
         * <li>CF: Constructed flag. If 1, the field is constructed.
         * </pre>
         * constructed or primitive entity.
                case DerParser.ISO646_STRING:
import java.io.ByteArrayInputStream;
    }
                    value[0] -= 40;  
                case DerParser.UTF8_STRING:
         * <ul>  
        }  
    private static final int UNIVERSAL_STRING = 0x1C;
    private static final int PRINTABLE_STRING = 0x13;  
        byte[] value = new byte[length];
                throw new IOException("Ivalid DER: object is not object OID");  
         * <pre>
 * The OpenSearch Contributors require contributions made to  
            switch (value[0] / 40) {  
    // Constructed Flag
        }
/*
 * SPDX-License-Identifier: Apache-2.0
     * only handle integers.  
            );  
  Copyright (c) 1998-2010 AOL Inc.  
        int n = derInputStream.read(value);  
     * @return The length as integer  
        int num = i & 0x7F;
    // Tag and data types
         */  
     * give the length.  
    /**
 * Based on https://github.com/groovenauts/jmeter_oauth_plugin/blob/master/jmeter/src/  
    private static final int ISO646_STRING = 0x1A;
                case 0:
            int oidPart = 0;
 * this file be licensed under the Apache-2.0 license or a
                case 1:
    }
        }
         */
    private static final int GRAPHIC_STRING = 0x19;  
                case DerParser.NUMERIC_STRING:
            return new DerParser(value);
        int tag = derInputStream.read();
      http://www.apache.org/licenses/LICENSE-2.0  
        protected final int tag;  
        public int getType() {
    private static final int GENERAL_STRING = 0x1B;
        /**
                "Invalid DER: size of ASN.1 object to be parsed appears to be larger than the size of the key file " + "itself."
            return new BigInteger(value);  
            return sb.toString();
        return sb.toString();
     * </p>  
                    sb.append(oidPart);  
     *
        if (n < length) {
        return new Asn1Object(tag, length, value);  
        for (int i = 0; i < bytes.length; i++) {  
        public String getOid() throws IOException {  
        }
            return length;  
            throw new IOException("Invalid DER: stream too short, missing tag");
    private static String toHexString(byte[] bytes) {
                case DerParser.IA5_STRING:
        // getLength() can return any 32 bit integer, so ensure that a corrupted encoding won't
                case DerParser.BMP_STRING:  
            this.tag = tag;
final class DerParser {  
        }
         *  
        }  
        public DerParser getParser() throws IOException {
            return new String(value, encoding);  
  limitations under the License.  
        return new BigInteger(1, bytes).intValue();
            }  
import java.math.BigInteger;
        if ((i & ~0x7F) == 0) return i;
                case DerParser.GRAPHIC_STRING:  
     * Bit 8 of first octet has value "1" and bits 7-1 give the  
            this.value = value;
         * Construct a ASN.1 TLV. The TLV could be either a  
        // We can't handle length longer than 4 bytes  
         * <li>Class: Universal, Application, Context or Private
  Licensed under the Apache License, Version 2.0 (the "License");
 * Modifications Copyright OpenSearch Contributors. See
         *
     * An ASN.1 TLV. The object is not parsed. It can
         * @return BigInteger
     *
 * decode PKCS#1 private keys in order to remain JCE/JVM agnostic.
/*  
         * </ul>  
                    value[0] -= 80;
            throw new IOException(
                    break;
import java.io.InputStream;
    private static final int OCTET_STRING = 0x04;  
        public BigInteger getInteger() throws IOException {  
         *     The first byte in DER encoding is made of following fields:  
         * <p>
     * </ul>
     *          In BER/DER encoding, length can be encoded in 2 forms:
    Asn1Object readAsn1Object() throws IOException {
