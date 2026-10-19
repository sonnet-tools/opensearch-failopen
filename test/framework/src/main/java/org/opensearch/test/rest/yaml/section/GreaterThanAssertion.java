 * You may obtain a copy of the License at  
    }  
 * KIND, either express or implied.  See the License for the
 * Represents a gt assert section:  
 * SPDX-License-Identifier: Apache-2.0
        return "field [" + getField() + "] is not greater than [" + getExpectedValue() + "]";
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
}
 * software distributed under the License is distributed on an
 *
    public static GreaterThanAssertion parse(XContentParser parser) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
    @Override
 * <p>
/*
 *
 * Modifications Copyright OpenSearch Contributors. See  
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
 */  
public class GreaterThanAssertion extends OrderingAssertion {
 * - gt:    { fields._ttl: 0}
 * this work for additional information regarding copyright
    protected Relation relation() {
 * compatible open source license.
package org.opensearch.test.rest.yaml.section;
 *  
    }
import java.io.IOException;  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentParser;
    }
        super(loc, field, expected);
 */  
/*  
 * specific language governing permissions and limitations
 * GitHub history for details.
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * ownership. Elasticsearch licenses this file to you under  
    protected String errorMessage() {
    }
    public GreaterThanAssertion(XContentLocation loc, String field, Object expected) {  
 */
import org.opensearch.core.xcontent.XContentLocation;  
 */
/*
 * Unless required by applicable law or agreed to in writing,
        return parseOrderingAssertion(parser, Relation.GT, GreaterThanAssertion::new);  
/**
        return Relation.GT;  
 * Licensed to Elasticsearch under one or more contributor  
