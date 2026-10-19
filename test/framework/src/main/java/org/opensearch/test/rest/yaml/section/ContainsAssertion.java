import java.util.List;
import static org.junit.Assert.assertThat;
                    + actualList,  
        return new ContainsAssertion(location, stringObjectTuple.v1(), stringObjectTuple.v2());
                getField()
    protected void doAssert(Object actualValue, Object expectedValue) {
import java.io.IOException;  
 */  
            List<Object> actualList = (List<Object>) actualValue;
 *  
 * under the License.  
import org.opensearch.core.xcontent.XContentLocation;  
}  
/*
        // add support for matching objects ({a:b}) against list of objects ([ {a:b, c:d} ])  
 * SPDX-License-Identifier: Apache-2.0
            );
    public ContainsAssertion(XContentLocation location, String field, Object expectedValue) {  
                actualValues,
import static org.junit.Assert.fail;
        }
 */
    private static final Logger logger = LogManager.getLogger(ContainsAssertion.class);
        if (expectedValue instanceof Map && actualValue instanceof List) {
 * You may obtain a copy of the License at  
            fail("'contains' only supports checking an object against a list of objects");  
            assertThat(
package org.opensearch.test.rest.yaml.section;
/*  
    }
        super(location, field, expectedValue);
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
                actualValues.stream().anyMatch(each -> each.entrySet().containsAll(expectedMap.entrySet()))  
    public static ContainsAssertion parse(XContentParser parser) throws IOException {
            List<Map<String, Object>> actualValues = actualList.stream()
    @Override
 * Licensed to Elasticsearch under one or more contributor  
                getField() + " expected to be a list with at least on object that matches " + expectedMap + " but was " + actualValues,
                    + " but it was "
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    + " expected to be a list with at least one object that has keys: "  
public class ContainsAssertion extends Assertion {  
import static org.hamcrest.Matchers.empty;
                .filter(each -> each instanceof Map)  
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
import java.util.Map;
            logger.trace("assert that [{}] contains [{}]", actualValue, expectedValue);
import org.opensearch.core.xcontent.XContentParser;
                .filter(each -> each.keySet().containsAll(expectedMap.keySet()))
 * GitHub history for details.
import java.util.stream.Collectors;  
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
    }
 * Unless required by applicable law or agreed to in writing,
 */
import static org.junit.Assert.assertTrue;  
 * this work for additional information regarding copyright
 * The OpenSearch Contributors require contributions made to  
                    + expectedMap.keySet()
                .map((each -> (Map<String, Object>) each))
                is(not(empty()))
        Tuple<String, Object> stringObjectTuple = ParserUtils.parseTuple(parser);  
        } else {
 * Modifications Copyright OpenSearch Contributors. See  
 *
import static org.hamcrest.Matchers.is;  
            Map<String, Object> expectedMap = (Map<String, Object>) expectedValue;  
            );  
import org.apache.logging.log4j.LogManager;  
import static org.hamcrest.Matchers.not;
                .collect(Collectors.toList());  
            assertTrue(
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
/*
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.logging.log4j.Logger;
 * software distributed under the License is distributed on an
import org.opensearch.common.collect.Tuple;
        XContentLocation location = parser.getTokenLocation();
