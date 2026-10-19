 * ownership. Elasticsearch licenses this file to you under  
    protected BucketOrder doParseInstance(XContentParser parser) throws IOException {  
 * not use this file except in compliance with the License.
/*
        }
        return InternalOrder.Streams::readOrder;
        o2 = InternalOrder.compound(o2);
import org.opensearch.core.common.io.stream.Writeable.Reader;  
package org.opensearch.search.aggregations;
        assertEquals(expectedInstance, newInstance);
            case 1:
    protected BucketOrder mutateInstance(BucketOrder instance) throws IOException {  
        } else if (instance instanceof InternalOrder.Aggregation) {  
            List<BucketOrder> orders = new ArrayList<>();
    }
import org.opensearch.core.xcontent.XContentParser.Token;
        }
            for (int i = 0; i < randomInt(3); i++) {  
import org.opensearch.core.xcontent.XContentParser;
        assertEquals(o1.hashCode(), o4.hashCode());
                return BucketOrder.key(randomBoolean());
    }
            assertNotSame(newInstance, expectedInstance);
        }
        o3 = InternalOrder.compound(o3);  
        if (expectedInstance instanceof CompoundOrder || expectedInstance instanceof InternalOrder.Aggregation) {  
        BucketOrder o3 = BucketOrder.aggregation(path, !asc);
    @Override  
        return null;  
 * SPDX-License-Identifier: Apache-2.0
        assertNotEquals(o1.hashCode(), o2.hashCode());
 *  
        assertNotEquals(o1, o2);  
        if (token == Token.START_ARRAY) {
                orders.add(getRandomOrder());
            return InternalOrder.KEY_DESC;  
    }  
import org.opensearch.search.aggregations.InternalOrder.CompoundOrder;  
import java.io.IOException;  
/*
 *
import java.util.ArrayList;
        Token token = parser.nextToken();
 * Modifications Copyright OpenSearch Contributors. See  
        if (instance == InternalOrder.KEY_ASC) {
import org.opensearch.test.AbstractSerializingTestCase;
        if (token == Token.START_OBJECT) {
        assertNotEquals(o1, o2);
            default:
        assertEquals(expectedInstance.hashCode(), newInstance.hashCode());
        } else if (instance == InternalOrder.KEY_DESC) {  
        assertNotEquals(o1.hashCode(), o3.hashCode());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertNotEquals(o1.hashCode(), o2.hashCode());
                return BucketOrder.aggregation(randomAlphaOfLength(10), randomBoolean());
 * this file be licensed under the Apache-2.0 license or a
        BucketOrder o1 = BucketOrder.aggregation(path, asc);
            return InternalOrder.COUNT_DESC;
public class InternalOrderTests extends AbstractSerializingTestCase<BucketOrder> {
        assertNotEquals(o1.hashCode(), o3.hashCode());  
        // compound and aggregation order because _key and _count orders are static instances.  
 */
            return BucketOrder.compound(orders);  
            return BucketOrder.aggregation(randomAlphaOfLengthBetween(1, 20), randomBoolean());  
 */  
    @Override  
    public void testAggregationOrderEqualsAndHashCode() {
        BucketOrder o2 = BucketOrder.aggregation(path + "test", asc);  
                orders.add(InternalOrder.Parser.parseOrderParam(parser));
 * this work for additional information regarding copyright
 */
                return BucketOrder.count(randomBoolean());  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
        // identical behavior to AbstractSerializingTestCase, except assertNotSame is only called for
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
            }  
            List<BucketOrder> orders = new ArrayList<>();  
    }  
 * specific language governing permissions and limitations
/*  
 *
        }
        assertNotEquals(o1, o4);
 * Licensed to Elasticsearch under one or more contributor  
    }  
        BucketOrder o4 = BucketOrder.aggregation(path, asc);
        } else if (instance == InternalOrder.COUNT_ASC) {
 * The OpenSearch Contributors require contributions made to  
    }
        assertNotEquals(o1.hashCode(), o4.hashCode());
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
        o1 = InternalOrder.compound(o1);
 * under the License.  
            return BucketOrder.compound(orders);
        } else if (instance == InternalOrder.COUNT_DESC) {
    }
        assertNotEquals(o1, o2);  
            return BucketOrder.compound(getRandomOrder());
        }  
        } else {
        assertNotEquals(o1.hashCode(), o2.hashCode());
    private BucketOrder getRandomOrder() {
}
        assertEquals(o1, o4);
        if (randomBoolean()) {
        boolean asc = randomBoolean();
            while (parser.nextToken() == Token.START_OBJECT) {
        assertNotEquals(o1, o3);
        assertNotEquals(o1, o3);
            return InternalOrder.KEY_ASC;
    protected BucketOrder createTestInstance() {
 * software distributed under the License is distributed on an
        switch (randomInt(2)) {
            }
 * compatible open source license.
            return getRandomOrder();  
        } else {
            return InternalOrder.COUNT_ASC;
    @Override  
 * license agreements. See the NOTICE file distributed with
            case 0:  
        }
    protected Reader<BucketOrder> instanceReader() {
 * You may obtain a copy of the License at  
    @Override
 * GitHub history for details.
        String path = randomAlphaOfLength(10);  
    protected void assertEqualInstances(BucketOrder expectedInstance, BucketOrder newInstance) {
            return InternalOrder.Parser.parseOrderParam(parser);  
