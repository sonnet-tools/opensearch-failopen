 * compatible open source license.
        assertThat(errorMessage(), actualString, anyOf(equalTo(""), equalToIgnoringCase(Boolean.FALSE.toString()), equalTo("0")));
 * <p>
import org.apache.logging.log4j.Logger;
import org.opensearch.core.xcontent.XContentLocation;
 * Unless required by applicable law or agreed to in writing,
    private String errorMessage() {
 */
import static org.hamcrest.Matchers.equalToIgnoringCase;  
    }  
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
/**  
 *
 */
import java.io.IOException;
import org.opensearch.core.xcontent.XContentParser;  
        super(location, field, false);
        String actualString = actualValue.toString();
package org.opensearch.test.rest.yaml.section;
/*  
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
}
public class IsFalseAssertion extends Assertion {  
import static org.hamcrest.Matchers.equalTo;
    }  
 *   - is_false:  get.fields.bar  
import org.apache.logging.log4j.LogManager;  
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
    public IsFalseAssertion(XContentLocation location, String field) {
 *
 * Modifications Copyright OpenSearch Contributors. See  
 *  
    private static final Logger logger = LogManager.getLogger(IsFalseAssertion.class);
 * You may obtain a copy of the License at  
        }
 * ownership. Elasticsearch licenses this file to you under  
import static org.hamcrest.Matchers.anyOf;
        if (actualValue == null) {  
/*
    protected void doAssert(Object actualValue, Object expectedValue) {  
/*
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    }  
 * under the License.  
    @Override
    }
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
            return;
 * SPDX-License-Identifier: Apache-2.0
 *
 * Represents an is_false assert section:
 * Licensed to Elasticsearch under one or more contributor  
        logger.trace("assert that [{}] doesn't have a true value (field: [{}])", actualValue, getField());
        return new IsFalseAssertion(parser.getTokenLocation(), ParserUtils.parseField(parser));
 * the Apache License, Version 2.0 (the "License"); you may
        return "field [" + getField() + "] has a true value but it shouldn't";  
    public static IsFalseAssertion parse(XContentParser parser) throws IOException {
import static org.junit.Assert.assertThat;
