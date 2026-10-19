import org.opensearch.core.xcontent.XContentLocation;  
    }  
    public static LessThanAssertion parse(XContentParser parser) throws IOException {  
 * Represents a lt assert section:  
 * GitHub history for details.
 * compatible open source license.
 * <p>
    protected String errorMessage() {
 * Modifications Copyright OpenSearch Contributors. See  
 * this file be licensed under the Apache-2.0 license or a
 *
    protected Relation relation() {  
 *  - lt:    { fields._ttl: 20000}
 * You may obtain a copy of the License at  
public class LessThanAssertion extends OrderingAssertion {
 */
 */
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
 * ownership. Elasticsearch licenses this file to you under  
/*  
        super(loc, field, expected);
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 *  
 * this work for additional information regarding copyright
 */
    public LessThanAssertion(XContentLocation loc, String field, Object expected) {
}
 *     http://www.apache.org/licenses/LICENSE-2.0
/*
 *
/**
    @Override
    }
 */  
    }
 * under the License.  
 * license agreements. See the NOTICE file distributed with
    }
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        return Relation.LT;
import org.opensearch.core.xcontent.XContentParser;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor  
        return "field [" + getField() + "] is not less than [" + getExpectedValue() + "]";  
package org.opensearch.test.rest.yaml.section;
 * specific language governing permissions and limitations
    @Override
 *  
        return parseOrderingAssertion(parser, Relation.LT, LessThanAssertion::new);
/*
 * The OpenSearch Contributors require contributions made to  
