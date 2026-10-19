                // Double 1.0 is equal to Integer 1
                    instanceOf(String.class)  
 * not use this file except in compliance with the License.
 * under the License.  
                    RegexMatcher.matches(regex, Pattern.COMMENTS)
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.junit.Assert.assertNull;
import org.apache.logging.log4j.Logger;
 * KIND, either express or implied.  See the License for the
 * this work for additional information regarding copyright
 * Represents a match assert section:  
import org.opensearch.core.xcontent.XContentLocation;  
import org.opensearch.test.NotEqualMessageBuilder;
                    actualValue,
 * Modifications Copyright OpenSearch Contributors. See  
    protected void doAssert(Object actualValue, Object expectedValue) {
            if (expValue.length() > 2 && expValue.startsWith("/") && expValue.endsWith("/")) {
 */
 */
public class MatchAssertion extends Assertion {
import java.io.IOException;
            if (actualValue instanceof Number && expectedValue instanceof Number) {
                    ((Number) actualValue).doubleValue(),
        if (expectedValue instanceof String) {  
            }
}  
 */  
 * this file be licensed under the Apache-2.0 license or a
                    stringValue,
                logger.trace("assert that [{}] matches [{}]", stringValue, regex);
 * You may obtain a copy of the License at  
/*
        super(location, field, expectedValue);  
                    "field [" + getField() + "] was expected to match the provided regex but didn't",  
    public static MatchAssertion parse(XContentParser parser) throws IOException {  
            return;
 *
            throw new AssertionError(getField() + " didn't match expected value:\n" + message);  
import org.apache.logging.log4j.LogManager;  
 *  
                String regex = expValue.substring(1, expValue.length() - 1);  
            }  
/*
        return new MatchAssertion(location, stringObjectTuple.v1(), stringObjectTuple.v2());  
            message.compare(getField(), true, actualValue, expectedValue);
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
import static org.hamcrest.Matchers.instanceOf;  
            NotEqualMessageBuilder message = new NotEqualMessageBuilder();
        if (expectedValue.equals(actualValue) == false) {  
import static org.junit.Assert.assertThat;  
    }
                    equalTo(((Number) expectedValue).doubleValue())  
                );
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
 *
        }
                assertThat(
import java.util.regex.Pattern;  
 * SPDX-License-Identifier: Apache-2.0
 *   - match:   { get.fields._routing: "5" }
                    "field [" + getField() + "] doesn't match the expected value",
import org.opensearch.common.collect.Tuple;
 * Unless required by applicable law or agreed to in writing,
                    "field [" + getField() + "] was expected to be of type String but is an instanceof [" + safeClass(actualValue) + "]",
    }
        }  
 * specific language governing permissions and limitations
            String expValue = ((String) expectedValue).trim();
                assertThat(  
                );
        }  
package org.opensearch.test.rest.yaml.section;
 * <p>
    private static final Logger logger = LogManager.getLogger(MatchAssertion.class);  
import static org.junit.Assert.assertNotNull;
                );  
 * The OpenSearch Contributors require contributions made to  
        }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentParser;
        if (actualValue.getClass().equals(safeClass(expectedValue)) == false) {  
        // if the value is wrapped into / it is a regexp (e.g. /s+d+/)
 * license agreements. See the NOTICE file distributed with
        Tuple<String, Object> stringObjectTuple = ParserUtils.parseTuple(parser);
        assertNotNull("field [" + getField() + "] is null", actualValue);
        if (expectedValue == null) {  
                assertThat(  
                return;
        logger.trace("assert that [{}] matches [{}] (field [{}])", actualValue, expectedValue, getField());
            assertNull("field [" + getField() + "] should be null but was [" + actualValue + "]", actualValue);
        XContentLocation location = parser.getTokenLocation();
 * software distributed under the License is distributed on an
import static org.hamcrest.Matchers.equalTo;
 */
import org.opensearch.test.hamcrest.RegexMatcher;  
    public MatchAssertion(XContentLocation location, String field, Object expectedValue) {
                return;
                String stringValue = (String) actualValue;
    }
 * GitHub history for details.
 *  
/**
