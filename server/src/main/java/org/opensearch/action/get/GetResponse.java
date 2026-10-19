        if (o == null || getClass() != o.getClass()) {
    }  
        // a valid GetResponse instance. If it's not the case, we throw an
     * as a xcontent using the {@link #toXContent(XContentBuilder, Params)} method.
    public Map<String, Object> getSourceAsMap() throws OpenSearchParseException {  
    }
     */  
    /**
    /**  
 */  
        GetResult getResult = GetResult.fromXContent(parser);
    }
     * The source of the document (As a map).
     *
     * doesn't know. But before returning the result it will check that enough information were
     * @deprecated Use {@link GetResponse#getSource()} instead
 * The OpenSearch Contributors require contributions made to  
    }  
import org.opensearch.common.annotation.PublicApi;
    /**  
    public int hashCode() {  
     * The source of the document (as a string).  
                String.format(Locale.ROOT, "Missing required fields [%s,%s]", GetResult._INDEX, GetResult._ID)  
     * Does the document exists.
     */
 * software distributed under the License is distributed on an
        return getResult.getFields();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.action.ActionResponse;
/*  
import java.io.IOException;
    }  
        getResult.writeTo(out);
package org.opensearch.action.get;
 * GitHub history for details.
        return getResult.getSeqNo();
        return getResult.field(name);
    @Override  
    public String getId() {
        return getResult.getVersion();
     */
    /**
    @Override
import java.util.Locale;
        if (getResult.getIndex() == null && getResult.getId() == null) {  
public class GetResponse extends ActionResponse implements Iterable<DocumentField>, ToXContentObject {
    public static GetResponse fromXContent(XContentParser parser) throws IOException {  
     * {@link GetResponse} with found set to false, or as an opensearch exception. The caller
        return getResult.source();
     */  
    }
            throw new ParsingException(
     */
    }
            return true;
        return Objects.equals(getResult, getResponse.getResult);
    public String toString() {
                parser.getTokenLocation(),
    /**
    public Iterator<DocumentField> iterator() {
     */
/*  
        return getResult.isSourceEmpty();
 *
    /**  
 * @see Client#get(GetRequest)  
import org.opensearch.core.xcontent.XContentBuilder;  
 * this work for additional information regarding copyright
    }
     */
import java.util.Iterator;  
import java.util.Map;
        return getResult.getId();  
import org.opensearch.common.document.DocumentField;  
    }
     */
     * Is the source empty (not available) or not.
    }  
import org.opensearch.core.common.io.stream.StreamOutput;  
     * can be done by catching ParsingException.  
     * @param parser {@link XContentParser} to parse the response from
/**
        super(in);
    @Deprecated
 *
        return getResult.getPrimaryTerm();  
            );
    public boolean isExists() {  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.common.bytes.BytesReference;
        if (this == o) {
    public long getPrimaryTerm() {
    }
    public DocumentField getField(String name) {  
 */  
}
        return new GetResponse(getResult);  
    /**  
     */  
     */
     * The sequence number assigned to the last operation that has changed this document, if found.
    /**  
     * Returns the internal source bytes, as they are returned without munging (for example,
    GetResult getResult;
    }
    GetResponse(StreamInput in) throws IOException {  
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  
    }
    }  
    public byte[] getSourceAsBytes() {  
 * Modifications Copyright OpenSearch Contributors. See
     * The id of the document.  
        return getResult.toXContent(builder, params);
        }  
import org.opensearch.core.xcontent.MediaTypeRegistry;
        GetResponse getResponse = (GetResponse) o;
    /**
 *
        return Objects.hash(getResult);
     */  
    }  
     */
     * This method can be used to parse a {@link GetResponse} object when it has been printed out  
     */
        return getResult.internalSourceRef();  
 * @opensearch.api
 * compatible open source license.
        return getResult.getSource();
import org.opensearch.core.xcontent.XContentParser;
 * Licensed to Elasticsearch under one or more contributor  
     */
    @Override
import java.util.Objects;  
        return getResult.sourceAsString();  
 * SPDX-License-Identifier: Apache-2.0
 * The response of a get action.  
@PublicApi(since = "1.0.0")
        }
    public String getSourceAsString() {
     * The primary term of the last primary that has changed this document, if found.  
    @Override  
    public String getIndex() {
import org.opensearch.core.common.io.stream.StreamInput;
     * of this method needs a way to figure out whether we got back a valid get response, which
    public BytesReference getSourceInternal() {
 */
    public Map<String, Object> getSource() {
    }  
 *
     * For forward compatibility reason this method might not fail if it tries to parse a field it  
import org.opensearch.core.common.Strings;  
        return getResult.iterator();  
    public boolean isSourceEmpty() {
    }  
    @Override
        return getResult.sourceAsMap();
     * The index the document was fetched from.
    }
    }
        // At this stage we ensure that we parsed enough information to return  
        return getResult.isExists();
        getResult = new GetResult(in);
 * this file be licensed under the Apache-2.0 license or a
 * @see GetRequest
 */  
    public long getSeqNo() {
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
     * might still be compressed).  
 * Unless required by applicable law or agreed to in writing,
    }
    }
import org.opensearch.transport.client.Client;  
    public GetResponse(GetResult getResult) {
 * ownership. Elasticsearch licenses this file to you under  
    }
 * license agreements. See the NOTICE file distributed with
    }
    /**
import org.opensearch.index.get.GetResult;
     * otherwise. This is the case when we get a 404 back, which can be parsed as a normal  
 * not use this file except in compliance with the License.
        return Strings.toString(MediaTypeRegistry.JSON, this);  
    /**
        return getResult.sourceRef();
    /**
     * The source of the document if exists.
 * You may obtain a copy of the License at  
 * under the License.  
     * Returns bytes reference, also un compress the source if needed.
/*
     * parsed to return a valid {@link GetResponse} instance and throws a {@link ParsingException}
    public void writeTo(StreamOutput out) throws IOException {
 * specific language governing permissions and limitations
import org.opensearch.OpenSearchParseException;
    /**
    /**
     * <p>
 * KIND, either express or implied.  See the License for the
    public BytesReference getSourceAsBytesRef() {  
        this.getResult = getResult;  
import org.opensearch.core.common.ParsingException;
     * @return a {@link GetResponse}  
        return getResult.getIndex();
     * The version of the doc.
     * @throws IOException is an I/O exception occurs during the parsing
            return false;
        // exception so that callers know it and can handle it correctly.
    }
        }  
    public long getVersion() {  
    public Map<String, DocumentField> getFields() {
import org.opensearch.core.xcontent.ToXContentObject;
    public boolean equals(Object o) {  
