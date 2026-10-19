 * @opensearch.internal
    @Override  
 */  
import java.io.IOException;
            throw new IllegalArgumentException("invalid token: " + parser.currentToken());
        // in this case the deserialized version is not displayed to a user, it's okay to simply use
 *
}
 * when the index is at least {@link #value} old
    public Result evaluate(final Stats stats) {
import org.opensearch.core.xcontent.XContentBuilder;
 * software distributed under the License is distributed on an
/*
import org.opensearch.common.unit.TimeValue;
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
        return builder.field(NAME, value.getStringRep());
 * Condition for index maximum age. Evaluates to <code>true</code>
 * GitHub history for details.
    @Override
 * not use this file except in compliance with the License.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * this work for additional information regarding copyright
public class MaxAgeCondition extends Condition<TimeValue> {  
package org.opensearch.action.admin.indices.rollover;
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
 * license agreements. See the NOTICE file distributed with
    }  
    }
    public static final String NAME = "max_age";
 * Unless required by applicable law or agreed to in writing,
    public MaxAgeCondition(TimeValue value) {  
 * compatible open source license.
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
        super(NAME);  
        out.writeLong(value.getMillis());
    @Override
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
        } else {
        if (parser.nextToken() == XContentParser.Token.VALUE_STRING) {
 * this file be licensed under the Apache-2.0 license or a
 * under the License.  
    }
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            return new MaxAgeCondition(TimeValue.parseTimeValue(parser.text(), NAME));  
 */
/**  
    public static MaxAgeCondition fromXContent(XContentParser parser) throws IOException {
 * KIND, either express or implied.  See the License for the
        // milliseconds regardless.
 */
        return NAME;  
 *
    }  
        // milliseconds. It's possible to lose precision if someone were to say, specify 50
    public MaxAgeCondition(StreamInput in) throws IOException {
        this.value = TimeValue.timeValueMillis(in.readLong());
    public String getWriteableName() {
 * The OpenSearch Contributors require contributions made to  
        // nanoseconds, however, in that case, their max age is indistinguishable from 0  
 *     http://www.apache.org/licenses/LICENSE-2.0
/*  
    }
    }
/*  
        // While we technically could serialize this with out.writeTimeValue(...), that would
        return new Result(this, this.value.getMillis() <= indexAge);
    @Override
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.io.stream.StreamInput;
        long indexAge = System.currentTimeMillis() - stats.indexCreated;  
 */  
        }  
        super(NAME);
        this.value = value;
 *  
 *  
 * ownership. Elasticsearch licenses this file to you under  
        // require doing the song and dance around backwards compatibility for this value. Since  
