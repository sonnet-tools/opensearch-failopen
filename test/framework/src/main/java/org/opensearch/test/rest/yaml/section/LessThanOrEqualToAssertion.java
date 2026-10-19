    }
    protected String errorMessage() {
 * not use this file except in compliance with the License.
 */  
    public static LessThanOrEqualToAssertion parse(XContentParser parser) throws IOException {  
 */  
import org.opensearch.core.xcontent.XContentParser;
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
/*  
 *  
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
 * Represents a lte assert section:
    @Override
public class LessThanOrEqualToAssertion extends OrderingAssertion {
 *
/*  
        return "field [" + getField() + "] is not less than or equal to [" + getExpectedValue() + "]";  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *   - lte:     { fields._ttl: 0 }  
 * specific language governing permissions and limitations
    }  
 * compatible open source license.
 * GitHub history for details.
    @Override
 * under the License.  
 * You may obtain a copy of the License at  
 * The OpenSearch Contributors require contributions made to  
 * <p>
 *
    }
    public LessThanOrEqualToAssertion(XContentLocation loc, String field, Object expected) {
 * Unless required by applicable law or agreed to in writing,
    protected Relation relation() {  
 * software distributed under the License is distributed on an
        super(loc, field, expected);
}
/**  
 */
    }
/*
 * KIND, either express or implied.  See the License for the
package org.opensearch.test.rest.yaml.section;
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.XContentLocation;
 * this file be licensed under the Apache-2.0 license or a
 */
import java.io.IOException;
        return Relation.LTE;
        return parseOrderingAssertion(parser, Relation.LTE, LessThanOrEqualToAssertion::new);
