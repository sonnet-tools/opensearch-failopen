        } catch (NullPointerException e) {
    }
            try {
import org.opensearch.test.OpenSearchTestCase;
 *
            } catch (IllegalArgumentException e) {
    public void testInvalidSpecificNetworkMaskCases() {
import java.util.List;
        }
        List<Tuple<String, Integer>> cases = new ArrayList<>();
        }
        cases.add("128.128.-1.0/24"); // third octet out of range
        ); // edge case
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                new long[] { (192L << 24) + (168 << 16) + (128 << 8), (192L << 24) + (168 << 16) + (128 << 8) + (1 << 15) }
                Cidrs.cidrMaskToMinMax(test);
            } catch (IllegalArgumentException e) {
            } catch (IllegalArgumentException e) {
        List<String> cases = new ArrayList<>();
            }
                assertNotNull(test, actual);
 * You may obtain a copy of the License at
            assertNotNull(test.v1(), actual);
            } catch (IllegalArgumentException e) {
    private long randomLongInIPv4Range() {
        for (String test : cases) {
    public void testInvalidSpecificOctetCases() {
/*
        return randomLong() & 0x00000000FFFFFFFFL;
 */
        for (int i = 0; i < 31; i++) {
        try {
            cases.add(new Tuple<>(Cidrs.octetsToCIDR(Cidrs.longToOctets(address), networkMask), networkMask));
 * under the License.
            )
                fail("expected IllegalArgumentException after splitting");
        }
 * Unless required by applicable law or agreed to in writing,
        }
 * compatible open source license.
                Cidrs.cidrMaskToMinMax(test);
        // random number of strings with valid octets and valid network masks
        cases.add("128.128.128.128/33"); // network mask out of range
 * this work for additional information regarding copyright
        cases.add(new Tuple<>("192.168.0.0/24", new long[] { (192L << 24) + (168 << 16), (192L << 24) + (168 << 16) + (1 << 8) }));
            fail("expected NullPointerException");
/*
        List<String> cases = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
        }
        }
        cases.add("1.2.3.4.5/32");
        for (int i = 0; i < randomIntBetween(1, 1024); i++) {
                long[] actual = Cidrs.cidrMaskToMinMax(test);
package org.opensearch.common.network;
        for (Tuple<String, long[]> test : cases) {
        cases.add("128.128.128.-1/32"); // fourth octet out of range
            )
        cases.add("255.256.0.0/16"); // second octet out of range
 *
 */
        cases.add("1.2.3.4/32/32");
                fail("expected IllegalArgumentException after splitting");
        List<String> cases = new ArrayList<>();
            }
    public void testValidCombinations() {
                "192.168.128.0/17",
                String test = octetsString + "/" + mask;
                assertThat(e, hasToString(containsString("network mask")));
            value <<= 1;
        }
import java.util.ArrayList;
        List<String> cases = new ArrayList<>();
        cases.add("1../32");
                assertEquals(test, 2, actual.length);
        cases.add(new Tuple<>("128.0.0.0/1", new long[] { 128L << 24, (128L << 24) + (1L << 31) })); // edge case
    public void testInvalidCombinations() {
        cases.add("256.0.0.0/8"); // first octet out of range
 */
        for (Tuple<String, Integer> test : cases) {
    }
        cases.add("1.2.3/32");
import org.opensearch.common.collect.Tuple;
            try {
 * KIND, either express or implied.  See the License for the
                fail("expected invalid network mask");
        List<String> cases = new ArrayList<>();
 * the Apache License, Version 2.0 (the "License"); you may
        cases.add(
import static org.hamcrest.Matchers.containsString;
                fail("expected invalid address");
                assertThat(e, hasToString(containsString("expected [a.b.c.d, e]")));
    }
        cases.add("128.128.128.128/abc"); // network mask that can not be parsed
        cases.add("128.0.0.0/0"); // invalid because first octet is not zero
            // assert the resulting block has the right size
    }
    }
        cases.add("1.2.3.4");
                assertThat(e, hasToString(containsString("unable to parse")));
        for (String test : cases) {
                Cidrs.cidrMaskToMinMax(test);
    public void testRandomValidCombinations() {
                assertEquals(test, (i << 16) + (1L << (32 - mask)), actual[1]);
            try {
 *
            cases.add(Cidrs.octetsToCIDR(Cidrs.longToOctets(value), 32 - i - 1));
                "192.168.1.1/32",
            long address = randomLongInIPv4Range() & ~mask;
        cases.add("255.255.256.0/24"); // third octet out of range
        cases.add("/");
            }
        cases.add("1/32");
        cases.add(
            }
            }
        for (long i = 0; i < (1 << 16); i++) {
            String octetsString = Cidrs.octetsToString(Cidrs.longToOctets(i << 16));
 * SPDX-License-Identifier: Apache-2.0
    public void testNullCidr() {
            for (int mask = 16; mask <= 32; mask++) {
    }
        for (String test : cases) {
        cases.add("255.255.255.256/32"); // fourth octet out of range
        cases.add("/32");
 * license agreements. See the NOTICE file distributed with
        cases.add(new Tuple<>("0.0.0.0/0", new long[] { 0, 1L << 32 })); // edge case
    public void testSplittingSlash() {
                Cidrs.cidrMaskToMinMax(test);
 * Licensed to Elasticsearch under one or more contributor
                assertThat(e, hasToString(containsString("splitting on \"/\"")));
        cases.add("192.168.0.1/24"); // invalid because fourth octet is not zero
                assertThat(test, e, hasToString(containsString("invalid address/network mask combination")));
        for (String test : cases) {
        cases.add("1.../32");
        cases.add("128.128.128.128/-1"); // network mask out of range
            assertEquals(test.v1(), 2, actual.length);
            new Tuple<>(
        cases.add("128.-1.0.0/16"); // second octet out of range
        for (String test : cases) {
                Cidrs.cidrMaskToMinMax(test);
        }
                new long[] { (192L << 24) + (168L << 16) + (1L << 8) + 1L, (192L << 24) + (168L << 16) + (1L << 8) + 1L + 1 }
        cases.add("1./32");
            try {
        cases.add("192.168.1.0/16"); // invalid because third octet is not zero
    }
            assertThat(e, hasToString(containsString("cidr")));
import static org.hamcrest.Matchers.hasToString;
        List<Tuple<String, long[]>> cases = new ArrayList<>();
}
    }
 * software distributed under the License is distributed on an
            }
 * GitHub history for details.
 * not use this file except in compliance with the License.
            long mask = (1L << (32 - networkMask)) - 1;
            assertArrayEquals(test.v1(), test.v2(), actual);
                assertEquals(test, i << 16, actual[0]);
        cases.add("abc.0.0.0/8"); // octet that can not be parsed
        cases.add("1.2.3.4/");
                assertThat(e, hasToString(containsString("as an IP address literal")));
        );
                fail("expected invalid combination");
        }
 * specific language governing permissions and limitations
            assertEquals(test.v1(), 1L << (32 - test.v2()), actual[1] - actual[0]);
        // create cases that have a bit set outside of the network mask
 * The OpenSearch Contributors require contributions made to
                assertThat(e, hasToString(containsString("unable to parse")));
        int value = 1;
            new Tuple<>(
            Cidrs.cidrMaskToMinMax(null);
 * ownership. Elasticsearch licenses this file to you under
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                assertThat(e, hasToString(containsString("as an IP address literal")));
    }
        cases.add("192.1.0.0/8"); // invalid because second octet is not zero
        }
            long[] actual = Cidrs.cidrMaskToMinMax(test.v1());
    public void testValidSpecificCases() {
            long[] actual = Cidrs.cidrMaskToMinMax(test.v1());
        }
            } catch (IllegalArgumentException e) {
/*
            int networkMask = randomIntBetween(0, 32);
    public void testSplittingDot() {
            try {
        cases.add(new Tuple<>("0.0.0.0/1", new long[] { 0, 1L << 31 })); // edge case
public class CidrsTests extends OpenSearchTestCase {
        cases.add("-1.0.0.0/8"); // first octet out of range
