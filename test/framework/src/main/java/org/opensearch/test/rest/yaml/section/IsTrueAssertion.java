 */  
    private String errorMessage() {
    @Override  
 * SPDX-License-Identifier: Apache-2.0
import static org.junit.Assert.assertThat;
 * Represents an is_true assert section:
        assertThat(errorMessage, actualValue, notNullValue());
    }
    private static final Logger logger = LogManager.getLogger(IsTrueAssertion.class);  
    public IsTrueAssertion(XContentLocation location, String field) {
 *
 * the Apache License, Version 2.0 (the "License"); you may
 */
        assertThat(errorMessage, actualString, not(equalTo("0")));
import static org.hamcrest.Matchers.notNullValue;
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;
/*  
        String errorMessage = errorMessage();  
        assertThat(errorMessage, actualString, not(equalToIgnoringCase(Boolean.FALSE.toString())));
/**
public class IsTrueAssertion extends Assertion {
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
package org.opensearch.test.rest.yaml.section;
 * under the License.  
import org.opensearch.core.xcontent.XContentLocation;
 * specific language governing permissions and limitations
    }  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
        logger.trace("assert that [{}] has a true value (field [{}])", actualValue, getField());
/*
    public static IsTrueAssertion parse(XContentParser parser) throws IOException {
    protected void doAssert(Object actualValue, Object expectedValue) {
 *
 * Modifications Copyright OpenSearch Contributors. See  
import static org.hamcrest.Matchers.not;  
import org.opensearch.core.xcontent.XContentParser;  
 *  
import org.apache.logging.log4j.Logger;
/*
 * Licensed to Elasticsearch under one or more contributor  
 *
    }
        assertThat(errorMessage, actualString, not(equalTo("")));  
        super(location, field, true);  
 * not use this file except in compliance with the License.
    }
 */  
        return new IsTrueAssertion(parser.getTokenLocation(), ParserUtils.parseField(parser));  
 * GitHub history for details.
 * <p>  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this file be licensed under the Apache-2.0 license or a
        return "field [" + getField() + "] doesn't have a true value";  
}
import org.apache.logging.log4j.LogManager;  
 *   - is_true:  get.fields.bar
 * ownership. Elasticsearch licenses this file to you under  
        String actualString = actualValue.toString();
 * compatible open source license.
 * You may obtain a copy of the License at  
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.equalTo;
 */
 * Unless required by applicable law or agreed to in writing,
