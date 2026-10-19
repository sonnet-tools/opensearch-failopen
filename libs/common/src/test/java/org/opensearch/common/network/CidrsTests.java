        );
        }
            try {
            )
    public void testSplittingSlash() {
        for (String test : cases) {  
 * You may obtain a copy of the License at  
    }
            } catch (IllegalArgumentException e) {
        cases.add("256.0.0.0/8"); // first octet out of range
        cases.add(  
            long address = randomLongInIPv4Range() & ~mask;
                fail("expected invalid network mask");
        for (String test : cases) {  
            } catch (IllegalArgumentException e) {
                assertThat(e, hasToString(containsString("as an IP address literal")));  
        cases.add("-1.0.0.0/8"); // first octet out of range
            )
            try {
            assertArrayEquals(test.v1(), test.v2(), actual);
    }  
        cases.add("abc.0.0.0/8"); // octet that can not be parsed  
        cases.add("1.2.3.4/32/32");
    public void testInvalidSpecificNetworkMaskCases() {
 * license agreements. See the NOTICE file distributed with
 * Unless required by applicable law or agreed to in writing,
    private long randomLongInIPv4Range() {
 * Modifications Copyright OpenSearch Contributors. See
        cases.add("1.2.3.4");
            }
        }
        cases.add("1../32");  
        cases.add("/32");  
/*
import java.util.List;
        } catch (NullPointerException e) {  
                assertThat(e, hasToString(containsString("expected [a.b.c.d, e]")));
}
            long[] actual = Cidrs.cidrMaskToMinMax(test.v1());
 * the Apache License, Version 2.0 (the "License"); you may
/*  
    public void testSplittingDot() {
import java.util.ArrayList;
    public void testInvalidCombinations() {
            try {  
    public void testRandomValidCombinations() {
        cases.add("128.128.128.128/33"); // network mask out of range
 * KIND, either express or implied.  See the License for the
    public void testValidCombinations() {  
                Cidrs.cidrMaskToMinMax(test);
        cases.add("/");
        cases.add("192.168.1.0/16"); // invalid because third octet is not zero
        for (String test : cases) {
        int value = 1;  
            }  
        }
 */  
                fail("expected IllegalArgumentException after splitting");
            cases.add(Cidrs.octetsToCIDR(Cidrs.longToOctets(value), 32 - i - 1));
                assertThat(test, e, hasToString(containsString("invalid address/network mask combination")));
        try {  
            // assert the resulting block has the right size  
 * GitHub history for details.
        }  
        List<String> cases = new ArrayList<>();  
 * this work for additional information regarding copyright
        cases.add("128.128.128.128/abc"); // network mask that can not be parsed  
        cases.add("128.128.-1.0/24"); // third octet out of range  
        cases.add(new Tuple<>("192.168.0.0/24", new long[] { (192L << 24) + (168 << 16), (192L << 24) + (168 << 16) + (1 << 8) }));
            new Tuple<>(
            }
        cases.add("255.255.256.0/24"); // third octet out of range
                assertThat(e, hasToString(containsString("splitting on \"/\"")));
    }
                assertThat(e, hasToString(containsString("network mask")));
        List<String> cases = new ArrayList<>();
        for (Tuple<String, Integer> test : cases) {
                assertEquals(test, (i << 16) + (1L << (32 - mask)), actual[1]);  
        cases.add(new Tuple<>("128.0.0.0/1", new long[] { 128L << 24, (128L << 24) + (1L << 31) })); // edge case  
            long mask = (1L << (32 - networkMask)) - 1;  
        cases.add("192.168.0.1/24"); // invalid because fourth octet is not zero
    }
    public void testValidSpecificCases() {  
                long[] actual = Cidrs.cidrMaskToMinMax(test);
 * software distributed under the License is distributed on an
                Cidrs.cidrMaskToMinMax(test);  
        cases.add("1.../32");
        cases.add("192.1.0.0/8"); // invalid because second octet is not zero  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            cases.add(new Tuple<>(Cidrs.octetsToCIDR(Cidrs.longToOctets(address), networkMask), networkMask));
    }  
public class CidrsTests extends OpenSearchTestCase {
 */  
                "192.168.1.1/32",
                fail("expected invalid address");  
    }
                assertNotNull(test, actual);  
            } catch (IllegalArgumentException e) {  
            int networkMask = randomIntBetween(0, 32);
        cases.add("128.128.128.128/-1"); // network mask out of range
        for (Tuple<String, long[]> test : cases) {  
        cases.add(new Tuple<>("0.0.0.0/0", new long[] { 0, 1L << 32 })); // edge case
            assertEquals(test.v1(), 2, actual.length);
                fail("expected IllegalArgumentException after splitting");
            new Tuple<>(
                assertEquals(test, 2, actual.length);
 * compatible open source license.
        }
        for (long i = 0; i < (1 << 16); i++) {
 *
        cases.add("255.256.0.0/16"); // second octet out of range  
/*  
 * SPDX-License-Identifier: Apache-2.0
            try {  
 * not use this file except in compliance with the License.
        }  
        List<Tuple<String, long[]>> cases = new ArrayList<>();
                assertThat(e, hasToString(containsString("as an IP address literal")));
            try {
 */
                fail("expected invalid combination");  
        List<Tuple<String, Integer>> cases = new ArrayList<>();
            Cidrs.cidrMaskToMinMax(null);
                String test = octetsString + "/" + mask;
import static org.hamcrest.Matchers.hasToString;
        }
        ); // edge case
 * under the License.  
        cases.add("1/32");
        cases.add("128.128.128.-1/32"); // fourth octet out of range
                assertThat(e, hasToString(containsString("unable to parse")));  
            }  
            value <<= 1;  
                Cidrs.cidrMaskToMinMax(test);
 * Licensed to Elasticsearch under one or more contributor  
        cases.add("128.-1.0.0/16"); // second octet out of range
            fail("expected NullPointerException");
 * ownership. Elasticsearch licenses this file to you under  
                Cidrs.cidrMaskToMinMax(test);
            assertEquals(test.v1(), 1L << (32 - test.v2()), actual[1] - actual[0]);
    public void testInvalidSpecificOctetCases() {  
        List<String> cases = new ArrayList<>();
                new long[] { (192L << 24) + (168L << 16) + (1L << 8) + 1L, (192L << 24) + (168L << 16) + (1L << 8) + 1L + 1 }  
 *  
 * The OpenSearch Contributors require contributions made to  
            } catch (IllegalArgumentException e) {  
            for (int mask = 16; mask <= 32; mask++) {  
        return randomLong() & 0x00000000FFFFFFFFL;  
 * specific language governing permissions and limitations
        }  
            }
        }
            } catch (IllegalArgumentException e) {
            String octetsString = Cidrs.octetsToString(Cidrs.longToOctets(i << 16));
        cases.add(new Tuple<>("0.0.0.0/1", new long[] { 0, 1L << 31 })); // edge case
        cases.add("1.2.3.4.5/32");
        List<String> cases = new ArrayList<>();  
            assertThat(e, hasToString(containsString("cidr")));
 * this file be licensed under the Apache-2.0 license or a
    }  
        cases.add("128.0.0.0/0"); // invalid because first octet is not zero
        List<String> cases = new ArrayList<>();  
        }  
        cases.add(  
        cases.add("255.255.255.256/32"); // fourth octet out of range
        for (int i = 0; i < 31; i++) {
            assertNotNull(test.v1(), actual);
import org.opensearch.common.collect.Tuple;
        for (int i = 0; i < randomIntBetween(1, 1024); i++) {
        cases.add("1./32");
        cases.add("1.2.3/32");  
        }
                assertThat(e, hasToString(containsString("unable to parse")));
        // create cases that have a bit set outside of the network mask
                assertEquals(test, i << 16, actual[0]);
    }
 *
        cases.add("1.2.3.4/");  
package org.opensearch.common.network;
                new long[] { (192L << 24) + (168 << 16) + (128 << 8), (192L << 24) + (168 << 16) + (128 << 8) + (1 << 15) }  
import static org.hamcrest.Matchers.containsString;
import org.opensearch.test.OpenSearchTestCase;
    public void testNullCidr() {
        // random number of strings with valid octets and valid network masks  
        for (String test : cases) {
                Cidrs.cidrMaskToMinMax(test);
    }
            long[] actual = Cidrs.cidrMaskToMinMax(test.v1());  
    }  
                "192.168.128.0/17",
 *     http://www.apache.org/licenses/LICENSE-2.0
        for (String test : cases) {
