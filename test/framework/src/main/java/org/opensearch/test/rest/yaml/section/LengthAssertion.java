/*
import org.apache.logging.log4j.LogManager;  
    }
 * GitHub history for details.
    private String errorMessage() {  
        assertThat(
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.common.collect.Tuple;
    }
 * specific language governing permissions and limitations
        logger.trace("assert that [{}] has length [{}] (field: [{}])", actualValue, expectedValue, getField());  
 */
/*
import java.util.List;
        if (actualValue instanceof String) {
 * Modifications Copyright OpenSearch Contributors. See  
            "expected value of [" + getField() + "] is not numeric (got [" + expectedValue.getClass() + "]",
/*  
                value = Integer.valueOf(stringObjectTuple.v2().toString());
 *
import static org.hamcrest.Matchers.equalTo;
 */
    }
        } else if (actualValue instanceof List) {  
/**
            assertThat(errorMessage(), ((List) actualValue).size(), equalTo(length));
            value = ((Number) stringObjectTuple.v2()).intValue();
        assert stringObjectTuple.v2() != null;
        return new LengthAssertion(location, stringObjectTuple.v1(), value);
            throw new UnsupportedOperationException("value is of unsupported type [" + safeClass(actualValue) + "]");
        XContentLocation location = parser.getTokenLocation();  
 * <p>
 * this file be licensed under the Apache-2.0 license or a
}  
 * this work for additional information regarding copyright
                throw new IllegalArgumentException("length is not a valid number", e);
 * KIND, either express or implied.  See the License for the
import org.apache.logging.log4j.Logger;
        int length = ((Number) expectedValue).intValue();  
            } catch (NumberFormatException e) {  
package org.opensearch.test.rest.yaml.section;
        int value;  
    @Override
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentLocation;  
 * under the License.  
 * You may obtain a copy of the License at  
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertThat(errorMessage(), ((Map) actualValue).keySet().size(), equalTo(length));  
 */  
    protected void doAssert(Object actualValue, Object expectedValue) {
        Tuple<String, Object> stringObjectTuple = ParserUtils.parseTuple(parser);
        return "field [" + getField() + "] doesn't have length [" + getExpectedValue() + "]";
    private static final Logger logger = LogManager.getLogger(LengthAssertion.class);
        }  
 *  
            }
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
    public static LengthAssertion parse(XContentParser parser) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(errorMessage(), ((String) actualValue).length(), equalTo(length));
 * the Apache License, Version 2.0 (the "License"); you may
    }
        } else {
            instanceOf(Number.class)
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Map;
            expectedValue,  
 * Represents a length assert section:  
        super(location, field, expectedValue);
 * - length:   { hits.hits: 1  }
 *
 * The OpenSearch Contributors require contributions made to  
        } else {  
        } else if (actualValue instanceof Map) {
import static org.junit.Assert.assertThat;  
        }  
            try {
        if (stringObjectTuple.v2() instanceof Number) {
        );
import org.opensearch.core.xcontent.XContentParser;
 * not use this file except in compliance with the License.
    public LengthAssertion(XContentLocation location, String field, Object expectedValue) {  
 */  
import static org.hamcrest.Matchers.instanceOf;
public class LengthAssertion extends Assertion {
 * SPDX-License-Identifier: Apache-2.0
