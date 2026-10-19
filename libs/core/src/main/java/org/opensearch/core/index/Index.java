    private final String name;  
 * not use this file except in compliance with the License.
        return INDEX_PARSER.parse(parser, null).build();
     * which is useful as more and more things use the uuid rather  
 *    http://www.apache.org/licenses/LICENSE-2.0
     */
     */
     *  
 * SPDX-License-Identifier: Apache-2.0
        out.writeString(name);  
    private static final class Builder {  
        return result;  
 *
 * @opensearch.api
import org.opensearch.common.annotation.PublicApi;
    }
 * Modifications Copyright OpenSearch Contributors. See
            this.uuid = uuid;  
    public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
    }
 * the Apache License, Version 2.0 (the "License"); you may
/**  
 * specific language governing permissions and limitations
import org.opensearch.core.common.Strings;  
    }
     * If both uuid are {@link Strings#UNKNOWN_UUID_VALUE} then only the name is compared.  
     * @return the name of the index.
     *
 *  
import org.opensearch.core.common.io.stream.StreamOutput;
     * @return the unique identifier of the index. "_na_" if {@link Strings#UNKNOWN_UUID_VALUE}.
 * A value class representing the basic required properties of an OpenSearch index.
     * Checks if this index is the same as another index by comparing the name and unique identifier.
    /**
 * license agreements. See the NOTICE file distributed with
     */
import java.util.Objects;
     *
     * @return {@code "[name/uuid]"} or {@code "[name]"}  
        }  
/*  
     * @param name the name of the index  
    /**  
import org.opensearch.core.xcontent.XContentParser;
        private String uuid;
    /**
 * Unless required by applicable law or agreed to in writing,
        if (Strings.UNKNOWN_UUID_VALUE.equals(uuid)) {
 * You may obtain a copy of the License at  
    private static final ObjectParser<Builder, Void> INDEX_PARSER = new ObjectParser<>("index", Builder::new);  
    /**
        public void name(final String name) {
        this.name = in.readString();  
/*  
/*
    }
     *  
     * Creates a new Index instance with name and unique identifier
        builder.field(INDEX_UUID_KEY, uuid);
     * @opensearch.internal
            return new Index(name, uuid);
    }
        public Index build() {  
     */
        this.uuid = Objects.requireNonNull(uuid);  
    public Index(StreamInput in) throws IOException {
        result = 31 * result + uuid.hashCode();
     * Returns either the name and unique identifier of the index
        }  
    @Override
     * @throws NullPointerException if either name or uuid are null
     * If we have a uuid we put it in the toString so it'll show up in logs
import org.opensearch.core.xcontent.ToXContentObject;
    /**  
     * @throws IOException if an error occurs while reading from the stream
    public static final String UNKNOWN_INDEX_NAME = "_unknown_";
    public String toString() {  
package org.opensearch.core.index;
            return "[" + name + "]";
 *
        }
     * Reads the name and unique identifier from the stream.
    }
 */  
 * this file be licensed under the Apache-2.0 license or a
     * @see #writeTo(StreamOutput)  
            return true;
 */
 * under the License.  
        this.name = Objects.requireNonNull(name);
    public int hashCode() {  
     *  
     * Gets the unique identifier of the index.
 */  
    }  
            this.name = name;
        Index index1 = (Index) o;
     * @param o the index to compare to
        out.writeString(uuid);
     * or only the name if the uuid is {@link Strings#UNKNOWN_UUID_VALUE}.  
import org.opensearch.core.xcontent.XContentBuilder;  
     * Gets the name of the index.
 * GitHub history for details.
    public static final Index[] EMPTY_ARRAY = new Index[0];
        INDEX_PARSER.declareString(Builder::uuid, new ParseField(INDEX_UUID_KEY));  
import org.opensearch.core.common.io.stream.StreamInput;
    public static Index fromXContent(final XContentParser parser) throws IOException {  
    }
    /**
    }
     *
import java.io.IOException;  
    private static final String INDEX_UUID_KEY = "index_uuid";
    public String getName() {  
import org.opensearch.core.xcontent.ObjectParser;
     */  
     * Creates a new Index instance from a {@link StreamInput}.
        }  
     */
    public boolean equals(Object o) {  
     *
 * The OpenSearch Contributors require contributions made to  
    public String getUUID() {  
     * Builder for Index objects.  Used by ObjectParser instances only.
    @Override
        INDEX_PARSER.declareString(Builder::name, new ParseField(INDEX_NAME_KEY));
        }
}
        }  
    @Override
    }
        return uuid;
    }
     * than the name as the lookup key for the index.
    @Override
 * <p>
        private String name;
     *  
    }  
    static {
     * <p>
        builder.startObject();  
    private final String uuid;
import org.opensearch.core.ParseField;
        if (this == o) {
        return builder.endObject();  
    @Override
    private static final String INDEX_NAME_KEY = "index_name";  
        this.uuid = in.readString();
 * ownership. Elasticsearch licenses this file to you under  
        return this.name;
    public void writeTo(final StreamOutput out) throws IOException {
 * compatible open source license.
@PublicApi(since = "1.0.0")
 * software distributed under the License is distributed on an
 */  
     * @param uuid the unique identifier of the index
     */
 * (This class is immutable.)  
 * this work for additional information regarding copyright
 *
    /** Writes the name and unique identifier to the {@link StreamOutput}  
public class Index implements Writeable, ToXContentObject {
     */  
        if (o == null || getClass() != o.getClass()) {
        return uuid.equals(index1.uuid) && name.equals(index1.name); // allow for _na_ uuid
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return "[" + name + "/" + uuid + "]";
    /**
     * @param out The stream to write to
        int result = name.hashCode();
     * @return true if the name and unique identifier are the same, false otherwise.  
    public Index(String name, String uuid) {
import org.opensearch.core.common.io.stream.Writeable;  
            return false;
        builder.field(INDEX_NAME_KEY, name);
        public void uuid(final String uuid) {
 * KIND, either express or implied.  See the License for the
     * @param in the stream to read from
