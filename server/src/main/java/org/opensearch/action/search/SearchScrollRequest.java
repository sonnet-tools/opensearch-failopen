import static org.opensearch.action.ValidateActions.addValidationError;
                    );
    @Override
        }
import java.util.Map;
            }
 * this file be licensed under the Apache-2.0 license or a
        }
            return false;
        return scroll(new Scroll(keepAlive));
import org.opensearch.core.common.Strings;
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
package org.opensearch.action.search;
    }  
                } else if ("scroll".equals(currentFieldName) && token == XContentParser.Token.VALUE_STRING) {  
     * If set, will enable scrolling of the search request.
    }
        builder.endObject();
import org.opensearch.tasks.Task;
 * the Apache License, Version 2.0 (the "License"); you may
    /**  
 *
 * software distributed under the License is distributed on an
    }  
     * If set, will enable scrolling of the search request.
 */
    @Override  
    public String toString() {
 *  
            ParsedScrollId parsed = parseScrollId();
 * not use this file except in compliance with the License.
import org.opensearch.core.xcontent.XContentBuilder;
        return validationException;
    }
        return "SearchScrollRequest{" + "scrollId='" + scrollId + '\'' + ", scroll=" + scroll + '}';
            return orig == null || orig.length == 0 ? Strings.EMPTY_ARRAY : orig;  
        return this;
                if (token == XContentParser.Token.FIELD_NAME) {
        super.writeTo(out);
    }
        return Objects.equals(scrollId, that.scrollId) && Objects.equals(scroll, that.scroll);
        }
import org.opensearch.action.ActionRequest;
            validationException = addValidationError("scrollId is missing", validationException);
        if (scroll != null) {
    @Override
    public String[] originalIndicesOrEmpty() {
 * ownership. Elasticsearch licenses this file to you under  
    }  
        return parsedScrollId;
    public SearchScrollRequest scroll(String keepAlive) {
        return scroll(new Scroll(TimeValue.parseTimeValue(keepAlive, null, getClass().getSimpleName() + ".keepAlive")));
                    currentFieldName = parser.currentName();  
        ActionRequestValidationException validationException = null;  
        return this;  
     */
 * Licensed to Elasticsearch under one or more contributor  
    private String scrollId;
/*
    public SearchScrollRequest scroll(TimeValue keepAlive) {  
    /**  
 * @opensearch.api  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public SearchScrollRequest scroll(Scroll scroll) {
import org.opensearch.common.annotation.PublicApi;  
import org.opensearch.core.tasks.TaskId;
public class SearchScrollRequest extends ActionRequest implements ToXContentObject {  
 *
    private Scroll scroll;  
 */  
    }  
                    scrollId(parser.text());
import java.util.Objects;
    }
     */  
    /**
 * compatible open source license.
    private transient ParsedScrollId parsedScrollId;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
}
    }
 */
    }
        if (o == null || getClass() != o.getClass()) {  
    public void writeTo(StreamOutput out) throws IOException {
    public ParsedScrollId parseScrollId() {
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
    }
        this.scroll = scroll;
    public SearchScrollRequest scrollId(String scrollId) {
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
    }
        return "scrollId[" + scrollId + "], scroll[" + scroll + "]";
    }  
        scrollId = in.readString();
    @Override
        scroll = in.readOptionalWriteable(Scroll::new);  
import org.opensearch.core.common.io.stream.StreamInput;  
import org.opensearch.action.ActionRequestValidationException;
 */  
     * The scroll id used to scroll the search.
    public SearchScrollRequest(String scrollId) {
 * KIND, either express or implied.  See the License for the
            return Strings.EMPTY_ARRAY;
                    scroll(new Scroll(TimeValue.parseTimeValue(parser.text(), null, "scroll")));
    }
        return builder;  
        try {  
        SearchScrollRequest that = (SearchScrollRequest) o;  
     * If set, will enable scrolling of the search request for the specified timeout.
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
    @Override
     */  
        if (this == o) {  
    public SearchScrollRequest(StreamInput in) throws IOException {  
     * Parse a search scroll request from a request body provided through the REST layer.
            String[] orig = parsed == null ? null : parsed.getOriginalIndices();
        out.writeOptionalWriteable(scroll);
 *     http://www.apache.org/licenses/LICENSE-2.0
    public String scrollId() {
 *
                } else if ("scroll_id".equals(currentFieldName) && token == XContentParser.Token.VALUE_STRING) {
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {  
                }  
                } else {
            return true;
    }
import org.opensearch.search.Scroll;  
        super(in);
        } else {
 * Modifications Copyright OpenSearch Contributors. See
            XContentParser.Token token;
 * specific language governing permissions and limitations
/*  
    }
        out.writeString(scrollId);  
    public ActionRequestValidationException validate() {
import org.opensearch.common.unit.TimeValue;
    public Scroll scroll() {  
     */  
        }  
        return new SearchTask(id, type, action, this::getDescription, parentTaskId, headers);
    public int hashCode() {
import java.io.IOException;  
 * GitHub history for details.
    public String getDescription() {  
@PublicApi(since = "1.0.0")
     */  
 * SPDX-License-Identifier: Apache-2.0
/**  
    /**
        if (parsedScrollId == null && scrollId != null) {
     * If set, will enable scrolling of the search request for the specified timeout.
        if (scrollId == null) {
    /**  
    public void fromXContent(XContentParser parser) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
/*  
        }
        this.scrollId = scrollId;  
import org.opensearch.core.xcontent.ToXContentObject;  
     * Values that are already be set and are also found while parsing will be overridden.
import org.opensearch.core.common.io.stream.StreamOutput;
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
                        "Unknown parameter [" + currentFieldName + "] in request body or parameter is of the wrong type[" + token + "] "
            throw new IllegalArgumentException("Malformed content, must start with an object");  
     */
            parsedScrollId = TransportSearchHelper.parseScrollId(scrollId);  
    @Override  
    }
    }
    public boolean equals(Object o) {
    @Override
        return scrollId;
        builder.startObject();  
    /**
    @Override
        return Objects.hash(scrollId, scroll);  
                    throw new IllegalArgumentException(  
            builder.field("scroll", scroll.keepAlive().getStringRep());  
        builder.field("scroll_id", scrollId);
        this.scrollId = scrollId;  
        }  
        return scroll;
    }
        } catch (IllegalArgumentException e) {
        }
            String currentFieldName = null;  
    public SearchScrollRequest() {}  
 * Transport request for a search scroll
