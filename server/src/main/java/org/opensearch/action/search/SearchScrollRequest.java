 */
    public String toString() {
    @Override
    public boolean equals(Object o) {
                if (token == XContentParser.Token.FIELD_NAME) {
        } else {
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
 * Unless required by applicable law or agreed to in writing,
                } else if ("scroll".equals(currentFieldName) && token == XContentParser.Token.VALUE_STRING) {
    }
import org.opensearch.core.common.Strings;
            return orig == null || orig.length == 0 ? Strings.EMPTY_ARRAY : orig;
    }
    }
        if (this == o) {
        }
        } catch (IllegalArgumentException e) {
import static org.opensearch.action.ValidateActions.addValidationError;
    }
        if (scrollId == null) {
}
    }
 * Transport request for a search scroll
        out.writeOptionalWriteable(scroll);
     * If set, will enable scrolling of the search request for the specified timeout.
import java.util.Objects;
        this.scroll = scroll;
 *
                    currentFieldName = parser.currentName();
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
        if (o == null || getClass() != o.getClass()) {
    }
     */
        return this;
            return false;
            }
            throw new IllegalArgumentException("Malformed content, must start with an object");
@PublicApi(since = "1.0.0")
    private String scrollId;
                }
    }
        return scroll(new Scroll(keepAlive));
 * The OpenSearch Contributors require contributions made to
        return Objects.equals(scrollId, that.scrollId) && Objects.equals(scroll, that.scroll);
     * If set, will enable scrolling of the search request for the specified timeout.
     */
    }
import org.opensearch.core.tasks.TaskId;
            String[] orig = parsed == null ? null : parsed.getOriginalIndices();
 *
        this.scrollId = scrollId;
 * license agreements. See the NOTICE file distributed with
        }
    public void fromXContent(XContentParser parser) throws IOException {
     * If set, will enable scrolling of the search request.
    }
    public Scroll scroll() {
    public String scrollId() {
     * Parse a search scroll request from a request body provided through the REST layer.
        try {
import org.opensearch.core.xcontent.ToXContentObject;
    @Override
            builder.field("scroll", scroll.keepAlive().getStringRep());
 * Licensed to Elasticsearch under one or more contributor
            return true;
        return builder;
            ParsedScrollId parsed = parseScrollId();
        return "SearchScrollRequest{" + "scrollId='" + scrollId + '\'' + ", scroll=" + scroll + '}';
    /**
 * SPDX-License-Identifier: Apache-2.0
                    scrollId(parser.text());
import org.opensearch.search.Scroll;
        }
        ActionRequestValidationException validationException = null;
     * Values that are already be set and are also found while parsing will be overridden.
import org.opensearch.common.annotation.PublicApi;
 * the Apache License, Version 2.0 (the "License"); you may
        if (scroll != null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
        out.writeString(scrollId);
        builder.startObject();
                } else if ("scroll_id".equals(currentFieldName) && token == XContentParser.Token.VALUE_STRING) {
     * The scroll id used to scroll the search.
        }
    }
    @Override
        scrollId = in.readString();
    /**
                    scroll(new Scroll(TimeValue.parseTimeValue(parser.text(), null, "scroll")));
 * ownership. Elasticsearch licenses this file to you under
 */
    private transient ParsedScrollId parsedScrollId;
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
 * under the License.
    public SearchScrollRequest scroll(String keepAlive) {
                } else {
        SearchScrollRequest that = (SearchScrollRequest) o;
    @Override
        if (parsedScrollId == null && scrollId != null) {
    }
        return "scrollId[" + scrollId + "], scroll[" + scroll + "]";
import java.io.IOException;
     */
    /**
        return Objects.hash(scrollId, scroll);
 * compatible open source license.
        return scroll(new Scroll(TimeValue.parseTimeValue(keepAlive, null, getClass().getSimpleName() + ".keepAlive")));
        this.scrollId = scrollId;
     */
    public ActionRequestValidationException validate() {
 *
    public Task createTask(long id, String type, String action, TaskId parentTaskId, Map<String, String> headers) {
     * If set, will enable scrolling of the search request.
    }
        return validationException;
        return new SearchTask(id, type, action, this::getDescription, parentTaskId, headers);
 * Modifications Copyright OpenSearch Contributors. See
import java.util.Map;
                    );
import org.opensearch.common.unit.TimeValue;
import org.opensearch.core.xcontent.XContentBuilder;
    public ParsedScrollId parseScrollId() {
                        "Unknown parameter [" + currentFieldName + "] in request body or parameter is of the wrong type[" + token + "] "
    public void writeTo(StreamOutput out) throws IOException {
 * not use this file except in compliance with the License.
import org.opensearch.action.ActionRequestValidationException;
 * KIND, either express or implied.  See the License for the
        scroll = in.readOptionalWriteable(Scroll::new);
        builder.field("scroll_id", scrollId);
    @Override
 * GitHub history for details.
            return Strings.EMPTY_ARRAY;
import org.opensearch.tasks.Task;
    }
    @Override
                    throw new IllegalArgumentException(
        return scroll;
            String currentFieldName = null;
 * specific language governing permissions and limitations
/*
    public SearchScrollRequest scroll(TimeValue keepAlive) {
            XContentParser.Token token;
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
    public String[] originalIndicesOrEmpty() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentParser;
    /**
            validationException = addValidationError("scrollId is missing", validationException);
    @Override
 * @opensearch.api
        return this;
    public SearchScrollRequest scroll(Scroll scroll) {
    private Scroll scroll;
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
    public SearchScrollRequest(String scrollId) {
import org.opensearch.action.ActionRequest;
    }
        return parsedScrollId;
    public int hashCode() {
 */
/*
/*
import org.opensearch.core.common.io.stream.StreamInput;
    public SearchScrollRequest() {}
    }
/**
 * You may obtain a copy of the License at
 * this work for additional information regarding copyright
    }
    }
        super(in);
    public String getDescription() {
    /**
     */
package org.opensearch.action.search;
        }
        return scrollId;
public class SearchScrollRequest extends ActionRequest implements ToXContentObject {
 *
     */
    public SearchScrollRequest scrollId(String scrollId) {
    }
    public SearchScrollRequest(StreamInput in) throws IOException {
        builder.endObject();
    }
 */
            parsedScrollId = TransportSearchHelper.parseScrollId(scrollId);
        super.writeTo(out);
