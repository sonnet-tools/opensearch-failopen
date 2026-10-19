    public GreaterThanEqualToAssertion(XContentLocation loc, String field, Object expected) {
 * compatible open source license.
 */  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
package org.opensearch.test.rest.yaml.section;
 */
 * GitHub history for details.
        return parseOrderingAssertion(parser, Relation.GTE, GreaterThanEqualToAssertion::new);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
/*  
 * Represents a gte assert section:
 * Unless required by applicable law or agreed to in writing,
 * The OpenSearch Contributors require contributions made to  
    @Override
import org.opensearch.core.xcontent.XContentLocation;
        return "field [" + getField() + "] is not greater than or equal to [" + getExpectedValue() + "]";  
 * software distributed under the License is distributed on an
 * under the License.  
 *
/**  
    }
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    }
    }  
 *   - gte:     { fields._ttl: 0 }  
 * not use this file except in compliance with the License.
    public static GreaterThanEqualToAssertion parse(XContentParser parser) throws IOException {  
 * the Apache License, Version 2.0 (the "License"); you may
    protected String errorMessage() {
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.core.xcontent.XContentParser;
 * <p>
    @Override
 *  
import java.io.IOException;
 *     http://www.apache.org/licenses/LICENSE-2.0
    protected Relation relation() {  
        super(loc, field, expected);
 * specific language governing permissions and limitations
}
 * this work for additional information regarding copyright
        return Relation.GTE;
 *
public class GreaterThanEqualToAssertion extends OrderingAssertion {
 */  
 */
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
/*
