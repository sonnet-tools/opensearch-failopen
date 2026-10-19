/*  
        assertEquals(b1, b2);
 * specific language governing permissions and limitations
            if (randomBoolean()) {
        assertEquals(b1, b2);
                    int prefixLength;
                    factory.addRange(key, NetworkAddress.format(randomIp(v4)), NetworkAddress.format(randomIp(v4)));
        b2 = new IpRangeAggregationBuilder("foo");
            }  
                    factory.addMaskRange(key, NetworkAddress.format(randomIp(v4)) + "/" + prefixLength);
    public void testMask() {  
/*
        b2.addRange("bar", "0.0.0.0", "::1:0:0:0");
                        prefixLength = randomInt(32);  
        }
            }  
        b2.addRange("bar", "fe80::", "fe80:0:0:1::");
        for (int i = 0; i < numRanges; i++) {
}
            factory.missing(NetworkAddress.format(randomIp(randomBoolean())));
        b1.addMaskRange("bar", "::/0");  
    @Override
 */
        b1 = new IpRangeAggregationBuilder("foo");
            factory.keyed(randomBoolean());
            switch (randomInt(3)) {
 * the Apache License, Version 2.0 (the "License"); you may
        b2.addRange("bar", "192.168.0.0", "192.168.0.2");
        factory.field(IP_FIELD_NAME);
                case 0:
                    } else {
        b1.addMaskRange("bar", "192.168.10.12/16");  
                        prefixLength = randomInt(128);
public class IpRangeTests extends BaseAggregationTestCase<IpRangeAggregationBuilder> {
        b1 = new IpRangeAggregationBuilder("foo");
package org.opensearch.search.aggregations.bucket;
                    fail();
        b1 = new IpRangeAggregationBuilder("foo");
import org.opensearch.search.aggregations.bucket.range.IpRangeAggregationBuilder;  
 *  
                    if (v4) {
 * under the License.  
        b2 = new IpRangeAggregationBuilder("foo");
import org.opensearch.search.aggregations.BaseAggregationTestCase;
 *
        int numRanges = randomIntBetween(1, 10);  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        b2.addRange("bar", "192.168.0.0", "192.169.0.0");
        b1.addMaskRange("bar", "fe80::821f:2ff:fe4a:c5bd/64");  
        if (randomBoolean()) {  
                    factory.addUnboundedFrom(key, NetworkAddress.format(randomIp(randomBoolean())));
        return factory;  
    }
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
                case 2:  
        }
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        b1 = new IpRangeAggregationBuilder("foo");
        assertEquals(b1, b2);
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
                    v4 = randomBoolean();
        b1.addMaskRange("bar", "::/16");  
        b2.addRange("bar", null, null);
        b2 = new IpRangeAggregationBuilder("foo");
    protected IpRangeAggregationBuilder createTestAggregatorBuilder() {
        IpRangeAggregationBuilder b1 = new IpRangeAggregationBuilder("foo");
                key = randomAlphaOfLengthBetween(1, 20);
 * You may obtain a copy of the License at  
 * GitHub history for details.
                    break;  
 *
                    break;
                default:
                    boolean v4 = randomBoolean();  
                    break;
                case 3:  
 * compatible open source license.
        b2 = new IpRangeAggregationBuilder("foo");
                case 1:  
        IpRangeAggregationBuilder factory = new IpRangeAggregationBuilder(randomAlphaOfLengthBetween(3, 10));
import org.opensearch.common.network.NetworkAddress;
 * this work for additional information regarding copyright
                    }  
 * Licensed to Elasticsearch under one or more contributor  
        IpRangeAggregationBuilder b2 = new IpRangeAggregationBuilder("foo");
        assertEquals(b1, b2);
 * Unless required by applicable law or agreed to in writing,
        b1 = new IpRangeAggregationBuilder("foo");
/*  
 */  
        assertEquals(b1, b2);
        assertEquals(b1, b2);
 * Modifications Copyright OpenSearch Contributors. See
        b1.addMaskRange("bar", "192.168.0.0/31");  
 * The OpenSearch Contributors require contributions made to  
        b1.addMaskRange("bar", "0.0.0.0/0");  
                    factory.addUnboundedTo(key, NetworkAddress.format(randomIp(randomBoolean())));
 * SPDX-License-Identifier: Apache-2.0
        if (randomBoolean()) {  
            String key = null;  
        b2 = new IpRangeAggregationBuilder("foo");
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
        b2.addRange("bar", null, "1::");
                    break;
