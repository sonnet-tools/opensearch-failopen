     * The id of the document.
import org.opensearch.index.get.GetResult;
 * the Apache License, Version 2.0 (the "License"); you may
    public boolean equals(Object o) {
     * The source of the document if exists.
    /**
 * ownership. Elasticsearch licenses this file to you under
    }
import org.opensearch.core.xcontent.XContentParser;
     * doesn't know. But before returning the result it will check that enough information were
    /**
    /**
    }
    GetResponse(StreamInput in) throws IOException {
        return Objects.hash(getResult);
import org.opensearch.core.common.Strings;
    /**
 * @opensearch.api
    }
 */
 * The OpenSearch Contributors require contributions made to
        // a valid GetResponse instance. If it's not the case, we throw an
 *
        return getResult.getIndex();
    public String toString() {
    public static GetResponse fromXContent(XContentParser parser) throws IOException {
import java.util.Objects;
     * The version of the doc.
    }
    public int hashCode() {
            return true;
     * The source of the document (as a string).
 * Modifications Copyright OpenSearch Contributors. See
        if (o == null || getClass() != o.getClass()) {
    }
    }
 *     http://www.apache.org/licenses/LICENSE-2.0
     * The index the document was fetched from.
    }
        return new GetResponse(getResult);
    public String getId() {
    }
package org.opensearch.action.get;
    }
    }
     */
/*
    }
 * SPDX-License-Identifier: Apache-2.0
    public Iterator<DocumentField> iterator() {
    }
    /**
    @Override
        return getResult.getVersion();
        return getResult.sourceAsMap();
 * software distributed under the License is distributed on an
    /**
        }
 *
    /**
                String.format(Locale.ROOT, "Missing required fields [%s,%s]", GetResult._INDEX, GetResult._ID)
    @Override
     * of this method needs a way to figure out whether we got back a valid get response, which
        getResult.writeTo(out);
    /**
 */
    GetResult getResult;
     * For forward compatibility reason this method might not fail if it tries to parse a field it
        return getResult.internalSourceRef();
 * license agreements. See the NOTICE file distributed with
public class GetResponse extends ActionResponse implements Iterable<DocumentField>, ToXContentObject {
     * @throws IOException is an I/O exception occurs during the parsing
     * The source of the document (As a map).
        }
     * The primary term of the last primary that has changed this document, if found.
    public long getSeqNo() {
    /**
            return false;
    }
     * @deprecated Use {@link GetResponse#getSource()} instead
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
     */
     */
        return getResult.field(name);
import org.opensearch.common.annotation.PublicApi;
import java.io.IOException;
    @Override
/*
     */
        // exception so that callers know it and can handle it correctly.
import org.opensearch.core.common.io.stream.StreamOutput;
    public String getIndex() {
    }
    @Deprecated
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.xcontent.MediaTypeRegistry;
 * @see Client#get(GetRequest)
import org.opensearch.core.common.ParsingException;
        return Objects.equals(getResult, getResponse.getResult);
        this.getResult = getResult;
     * Is the source empty (not available) or not.
    }
import org.opensearch.core.common.io.stream.StreamInput;
     * The sequence number assigned to the last operation that has changed this document, if found.
    public DocumentField getField(String name) {
import org.opensearch.common.document.DocumentField;
        GetResult getResult = GetResult.fromXContent(parser);
     */
     *
                parser.getTokenLocation(),
import java.util.Map;
     * <p>
/*
 * not use this file except in compliance with the License.
        // At this stage we ensure that we parsed enough information to return
    public BytesReference getSourceInternal() {
 */
        return getResult.iterator();
    /**
    }
/**
 * Licensed to Elasticsearch under one or more contributor
    }
     */
    /**
    public Map<String, DocumentField> getFields() {
    public long getPrimaryTerm() {
 * this file be licensed under the Apache-2.0 license or a
     */
    }
@PublicApi(since = "1.0.0")
        GetResponse getResponse = (GetResponse) o;
import org.opensearch.core.common.bytes.BytesReference;
 * this work for additional information regarding copyright
 * under the License.
    public void writeTo(StreamOutput out) throws IOException {
        return getResult.toXContent(builder, params);
     * This method can be used to parse a {@link GetResponse} object when it has been printed out
     * can be done by catching ParsingException.
 *
        return getResult.source();
 *
        super(in);
import org.opensearch.core.action.ActionResponse;
    public String getSourceAsString() {
    public Map<String, Object> getSource() {
    }
 * @see GetRequest
        return getResult.isSourceEmpty();
     * otherwise. This is the case when we get a 404 back, which can be parsed as a normal
    @Override
            throw new ParsingException(
 * The response of a get action.
    public boolean isSourceEmpty() {
    /**
        if (this == o) {
import java.util.Locale;
        if (getResult.getIndex() == null && getResult.getId() == null) {
    }
        }
     */
        return getResult.isExists();
    /**
 *
    public GetResponse(GetResult getResult) {
        return Strings.toString(MediaTypeRegistry.JSON, this);
            );
     * as a xcontent using the {@link #toXContent(XContentBuilder, Params)} method.
 * GitHub history for details.
import org.opensearch.transport.client.Client;
        return getResult.getSeqNo();
        return getResult.sourceRef();
    public Map<String, Object> getSourceAsMap() throws OpenSearchParseException {
    public boolean isExists() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
}
     * Returns the internal source bytes, as they are returned without munging (for example,
        return getResult.sourceAsString();
    public byte[] getSourceAsBytes() {
     * parsed to return a valid {@link GetResponse} instance and throws a {@link ParsingException}
     */
     * might still be compressed).
import org.opensearch.core.xcontent.ToXContentObject;
 */
     * @param parser {@link XContentParser} to parse the response from
 * You may obtain a copy of the License at
 * compatible open source license.
    @Override
    public BytesReference getSourceAsBytesRef() {
     * Does the document exists.
import org.opensearch.OpenSearchParseException;
     * Returns bytes reference, also un compress the source if needed.
        return getResult.getPrimaryTerm();
     */
    /**
        return getResult.getFields();
        return getResult.getId();
        getResult = new GetResult(in);
     */
     * {@link GetResponse} with found set to false, or as an opensearch exception. The caller
     */
     */
 * Unless required by applicable law or agreed to in writing,
    public long getVersion() {
     * @return a {@link GetResponse}
        return getResult.getSource();
import org.opensearch.core.xcontent.XContentBuilder;
     */
    }
    }
    }
 * specific language governing permissions and limitations
import java.util.Iterator;
