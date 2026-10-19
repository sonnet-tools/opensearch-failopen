        }
                return true;
import org.opensearch.core.common.Strings;
        }  
        builder.field(INDEX_FIELD.getPreferredName(), key.getIndex());
        private final String index;
            if (obj == null || getClass() != obj.getClass()) {
            return Objects.equals(index, other.index) && Objects.equals(docId, other.docId);
        }  
 * Represents a document (specified by its _index/_id) and its corresponding rating
    static class DocumentKey {
    private static final ConstructingObjectParser<RatedDocument, Void> PARSER = new ConstructingObjectParser<>(
    static final ParseField RATING_FIELD = new ParseField("rating");
    }
        DocumentKey(String index, String docId) {  
 * Modifications Copyright OpenSearch Contributors. See
        public String toString() {
 * </pre>
        PARSER.declareString(ConstructingObjectParser.constructorArg(), INDEX_FIELD);
    }  
        }  
    );
    static final ParseField INDEX_FIELD = new ParseField("_index");  
    }  
 * license agreements. See the NOTICE file distributed with
}  
            return "{\"_index\":\"" + index + "\",\"_id\":\"" + docId + "\"}";  
            if (Strings.isNullOrEmpty(docId)) {
            return Objects.hash(index, docId);
 */
            DocumentKey other = (DocumentKey) obj;
    }
        out.writeString(key.getDocId());  
        String getIndex() {  
    }
        builder.startObject();
 *    http://www.apache.org/licenses/LICENSE-2.0
                throw new IllegalArgumentException("DocId must be set for each rated document");
    private final DocumentKey key;
        if (obj == null || getClass() != obj.getClass()) {
            }  
    }
            }  
    public void writeTo(StreamOutput out) throws IOException {
        @Override
    public String getIndex() {  
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 *  
 * }
    public DocumentKey getKey() {
    @Override  
 * with respect to a specific search query.
 * The json structure of this element in a request:
 * under the License.  
        this.key = new DocumentKey(index, id);
 *   "_id": "doc1",
    }  
/*
        }  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), DOC_ID_FIELD);  
import org.opensearch.core.common.io.stream.StreamOutput;
        return Objects.hash(key, rating);
     */  
    @Override  
    public RatedDocument(String index, String id, int rating) {
        return Strings.toString(MediaTypeRegistry.JSON, this);
 * not use this file except in compliance with the License.
import java.io.IOException;  
        return rating;  
 */
    static RatedDocument fromXContent(XContentParser parser) {
        return key.getIndex();
     * a joint document key consisting of the documents index and id
            return index;
    public final int hashCode() {  
    }
    }
 * this file be licensed under the Apache-2.0 license or a
    public final boolean equals(Object obj) {  
            if (Strings.isNullOrEmpty(index)) {
        if (this == obj) {
        "rated_document",  
    private final int rating;
 * {  
import java.util.Objects;
    public String toString() {
 * GitHub history for details.
 *   "_index": "my_index",
/*  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
            return true;
            if (this == obj) {
 * ownership. Elasticsearch licenses this file to you under  
        a -> new RatedDocument((String) a[0], (String) a[1], (Integer) a[2])
 * You may obtain a copy of the License at  
import org.opensearch.core.ParseField;
import org.opensearch.core.xcontent.ToXContentObject;
            return false;
        out.writeVInt(rating);
 * Licensed to Elasticsearch under one or more contributor  
                throw new IllegalArgumentException("Index must be set for each rated document");
    }  
    }
        this.rating = in.readVInt();
import org.opensearch.core.xcontent.XContentParser;
        builder.field(RATING_FIELD.getPreferredName(), rating);
    }  
        public final boolean equals(Object obj) {  
        @Override
package org.opensearch.index.rankeval;
 * the Apache License, Version 2.0 (the "License"); you may
        builder.field(DOC_ID_FIELD.getPreferredName(), key.getDocId());  
    RatedDocument(StreamInput in) throws IOException {  
    @Override
 * The OpenSearch Contributors require contributions made to  
/**  
 *  
 *
 * specific language governing permissions and limitations
    static final ParseField DOC_ID_FIELD = new ParseField("_id");
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        private final String docId;  
            }  
    public String getDocID() {
    static {
 * compatible open source license.
    @Override
 *
 *   "rating": 0  
            this.index = index;
    @Override
        public final int hashCode() {  
        }
        this.rating = rating;  
        return Objects.equals(key, other.key) && Objects.equals(rating, other.rating);
import org.opensearch.core.xcontent.MediaTypeRegistry;
        RatedDocument other = (RatedDocument) obj;
public class RatedDocument implements Writeable, ToXContentObject {
import org.opensearch.core.common.io.stream.Writeable;
 * software distributed under the License is distributed on an
        String getDocId() {
    }
 * SPDX-License-Identifier: Apache-2.0
    }
    /**
 * KIND, either express or implied.  See the License for the
        return this.key;  
/*  
        builder.endObject();
        return PARSER.apply(parser, null);
    public int getRating() {
        @Override
        return builder;  
        return key.getDocId();
        this.key = new DocumentKey(in.readString(), in.readString());
        }
        PARSER.declareInt(ConstructingObjectParser.constructorArg(), RATING_FIELD);
import org.opensearch.core.common.io.stream.StreamInput;  
            this.docId = docId;  
 * this work for additional information regarding copyright
            }  
import org.opensearch.core.xcontent.XContentBuilder;  
            return docId;
 * <p>  
 * <pre>
                return false;
 */  
        out.writeString(key.getIndex());
 * Unless required by applicable law or agreed to in writing,
