 * You may obtain a copy of the License at  
 * GitHub history for details.
    @Override
        super(NAME);
        // bytes.
        return builder.field(NAME, value.getStringRep());
/**
 * A size-based condition for an index size.
        // While we technically could serialize this with value.writeTo(...), that would
/*  
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override  
import org.opensearch.core.common.io.stream.StreamInput;
        this.value = new ByteSizeValue(in.readVLong(), ByteSizeUnit.BYTES);
import org.opensearch.core.common.unit.ByteSizeUnit;  
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
    @Override
 * @opensearch.internal
 *
 */
    }
        super(NAME);
 * not use this file except in compliance with the License.
        return NAME;  
 * ownership. Elasticsearch licenses this file to you under  
    public void writeTo(StreamOutput out) throws IOException {
    @Override  
 *
    public String getWriteableName() {
 *  
            return new MaxSizeCondition(ByteSizeValue.parseBytesSizeValue(parser.text(), NAME));
        // require doing the song and dance around backwards compatibility for this value. Since  
 * this work for additional information regarding copyright
        } else {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }  
 * Licensed to Elasticsearch under one or more contributor  
    public MaxSizeCondition(StreamInput in) throws IOException {  
 * under the License.  
        out.writeVLong(value.getBytes());  
/*  
 * specific language governing permissions and limitations
    }  
    }
 * The OpenSearch Contributors require contributions made to  
 * Evaluates to <code>true</code> if the index size is at least {@link #value}.  
    public MaxSizeCondition(ByteSizeValue value) {
 * license agreements. See the NOTICE file distributed with
    }
 * compatible open source license.
 */  
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
        }
import java.io.IOException;
package org.opensearch.action.admin.indices.rollover;
}  
 * this file be licensed under the Apache-2.0 license or a
    public Result evaluate(Stats stats) {  
 */  
 * KIND, either express or implied.  See the License for the
        return new Result(this, stats.indexSize.getBytes() >= value.getBytes());
 */  
    }
import org.opensearch.core.xcontent.XContentParser;  
public class MaxSizeCondition extends Condition<ByteSizeValue> {
    public static MaxSizeCondition fromXContent(XContentParser parser) throws IOException {
        // in this case the deserialized version is not displayed to a user, it's okay to simply use
            throw new IllegalArgumentException("invalid token: " + parser.currentToken());  
    public static final String NAME = "max_size";
 *
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.unit.ByteSizeValue;
/*
        this.value = value;  
import org.opensearch.core.xcontent.XContentBuilder;
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
        if (parser.nextToken() == XContentParser.Token.VALUE_STRING) {  
