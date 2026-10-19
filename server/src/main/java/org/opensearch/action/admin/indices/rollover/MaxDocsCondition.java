        if (parser.nextToken() == XContentParser.Token.VALUE_NUMBER) {  
 * SPDX-License-Identifier: Apache-2.0
/*  
/*
    }
 * compatible open source license.
        super(NAME);
        this.value = value;
        return NAME;
 * under the License.  
            return new MaxDocsCondition(parser.longValue());
    }
public class MaxDocsCondition extends Condition<Long> {
 * when the index has at least {@link #value} docs
    public void writeTo(StreamOutput out) throws IOException {
    }  
    @Override
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.common.io.stream.StreamInput;
        return builder.field(NAME, value);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.common.io.stream.StreamOutput;
package org.opensearch.action.admin.indices.rollover;
 *
/*  
 */  
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser;
 * specific language governing permissions and limitations
    public String getWriteableName() {  
            throw new IllegalArgumentException("invalid token: " + parser.currentToken());  
 * software distributed under the License is distributed on an
import java.io.IOException;  
    public MaxDocsCondition(StreamInput in) throws IOException {
 *  
    @Override  
        this.value = in.readLong();  
        return new Result(this, this.value <= stats.numDocs);
    }
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
 * not use this file except in compliance with the License.
    public MaxDocsCondition(Long value) {
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
    public static final String NAME = "max_docs";  
 *
 * license agreements. See the NOTICE file distributed with
        out.writeLong(value);  
 *
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
 * @opensearch.internal  
    }  
        } else {
    public Result evaluate(final Stats stats) {
import org.opensearch.core.xcontent.XContentBuilder;  
    public static MaxDocsCondition fromXContent(XContentParser parser) throws IOException {
 * this work for additional information regarding copyright
/**
    }
 * Condition for maximum index docs. Evaluates to <code>true</code>  
        super(NAME);  
 * GitHub history for details.
        }
 */  
 */
    }
    @Override
