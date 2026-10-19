    private List<String> scrollIds;
                        while ((token = parser.nextToken()) != XContentParser.Token.END_ARRAY) {
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                            addScrollId(parser.text());
    }
 * The OpenSearch Contributors require contributions made to  
    public void writeTo(StreamOutput out) throws IOException {
            XContentParser.Token token;  
            throw new IllegalArgumentException("Malformed content, must start with an object");
    public List<String> getScrollIds() {
    }
                } else {
        if (scrollIds == null) {  
import java.util.Arrays;  
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {  
                }
 * Modifications Copyright OpenSearch Contributors. See
        this.scrollIds = scrollIds;  
import org.opensearch.common.annotation.PublicApi;  
    public void scrollIds(List<String> scrollIds) {
        }
                            if (token.isValue() == false) {
                } else if ("scroll_id".equals(currentFieldName)) {
import java.util.List;
    public void fromXContent(XContentParser parser) throws IOException {
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
                        }  
 * Unless required by applicable law or agreed to in writing,
    }  
 * not use this file except in compliance with the License.
        if (scrollIds == null || scrollIds.isEmpty()) {  
 */  
        return validationException;  
 *
 * Transport request for clearing a search scroll  
 *
            builder.value(scrollId);  
    }
                        if (token.isValue() == false) {
            out.writeStringArray(scrollIds.toArray(new String[0]));  
@PublicApi(since = "1.0.0")
                    if (token == XContentParser.Token.START_ARRAY) {  
}  
    }
 * SPDX-License-Identifier: Apache-2.0
                            throw new IllegalArgumentException("scroll_id element should only contain scroll_id");  
 * You may obtain a copy of the License at  
            validationException = addValidationError("no scroll ids specified", validationException);
                                throw new IllegalArgumentException("scroll_id array element should only contain scroll_id");  
/*  
        super(in);  
 * the Apache License, Version 2.0 (the "License"); you may
        }  
        for (String scrollId : scrollIds) {
import org.opensearch.action.ActionRequest;
            scrollIds = new ArrayList<>();
                        addScrollId(parser.text());
        return builder;
/*
import static org.opensearch.action.ValidateActions.addValidationError;  
public class ClearScrollRequest extends ActionRequest implements ToXContentObject {
        scrollIds.add(scrollId);
        super.writeTo(out);
import java.io.IOException;
                    currentFieldName = parser.currentName();
import java.util.ArrayList;
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                    );
        builder.startArray("scroll_id");
        }
    public void addScrollId(String scrollId) {  
    public ActionRequestValidationException validate() {
            String currentFieldName = null;
    public ClearScrollRequest(StreamInput in) throws IOException {
 *
                        "Unknown parameter [" + currentFieldName + "] in request body or parameter is of the wrong type[" + token + "] "  
    }  
    }
        builder.startObject();  
    public void setScrollIds(List<String> scrollIds) {
        }
    public List<String> scrollIds() {
        return scrollIds;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 */
import org.opensearch.core.xcontent.ToXContentObject;  
                if (token == XContentParser.Token.FIELD_NAME) {  
/*  
        if (scrollIds == null) {
                    throw new IllegalArgumentException(
                    }  
 * @opensearch.api
        scrollIds = null;
 */  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
            out.writeVInt(0);
/**
        builder.endObject();  
        scrollIds = Arrays.asList(in.readStringArray());
        } else {
 * this work for additional information regarding copyright
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;
        ActionRequestValidationException validationException = null;
import org.opensearch.action.ActionRequestValidationException;
import org.opensearch.core.xcontent.XContentBuilder;
    }
                        }
 *  
package org.opensearch.action.search;
 * KIND, either express or implied.  See the License for the
                    } else {
 */  
    }
        } else {
    @Override  
    @Override  
 * compatible open source license.
    public ClearScrollRequest() {}  
import org.opensearch.core.common.io.stream.StreamOutput;
            }  
        }
 * under the License.  
        builder.endArray();
    }
        this.scrollIds = scrollIds;  
 * this file be licensed under the Apache-2.0 license or a
                            }
        return scrollIds;
import org.opensearch.core.xcontent.XContentParser;
