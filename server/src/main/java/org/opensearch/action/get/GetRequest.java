 * Modifications Copyright OpenSearch Contributors. See
        refresh = in.readBoolean();
 * the Apache License, Version 2.0 (the "License"); you may
        this.id = id;
import org.opensearch.transport.client.Requests;
        return this.preference;
    }
 */
 * KIND, either express or implied.  See the License for the
import java.util.Objects;
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * not use this file except in compliance with the License.
        }
    public GetRequest(String index, String id) {
 * GitHub history for details.
    public GetRequest(String index) {
import org.opensearch.transport.client.Client;
        preference = in.readOptionalString();
    }
    public String preference() {
        super(index);
     *
    public GetRequest versionType(VersionType versionType) {
        return this;
        return this;
        id = in.readString();
     * Should a refresh be executed before this get operation causing the operation to
        return validationException;
        out.writeOptionalWriteable(fetchSourceContext);
        this.fetchSourceContext = context;
    private boolean refresh = false;
    }
            out.writeString(MapperService.SINGLE_MAPPING_NAME);
     * Controls the shard routing of the request. Using this value to hash the shard
 * <p>
import org.opensearch.action.ValidateActions;
import org.opensearch.common.annotation.PublicApi;
        out.writeOptionalStringArray(storedFields);
        return this.realtime;
 * Licensed to Elasticsearch under one or more contributor
/*
 * Unless required by applicable law or agreed to in writing,
    }
 *
     * Constructs a new get request against the specified index and document ID.
        out.writeString(id);
    @Override
    public GetRequest realtime(boolean realtime) {
        super.writeTo(out);
    boolean realtime = true;
     */
     * version exists and no changes happened on the doc since then.
    }
import org.opensearch.index.mapper.MapperService;
     */
    private VersionType versionType = VersionType.INTERNAL;
    /**
    public GetRequest preference(String preference) {
    @Override
     */
    private long version = Versions.MATCH_ANY;
    }
        this.refresh = refresh;
    public String index() {
    @Override
     */
    @Override
     * Sets the versioning type. Defaults to {@link org.opensearch.index.VersionType#INTERNAL}.
                "illegal version value [" + version + "] for version type [" + versionType.name() + "]",
 * this file be licensed under the Apache-2.0 license or a
 * The operation requires the {@link #index()}} and {@link #id(String)}
    private String routing;
public class GetRequest extends SingleShardRequest<GetRequest> implements RealtimeRequest, DocRequest {
import org.opensearch.index.VersionType;
        return version;
import org.opensearch.core.common.io.stream.StreamOutput;
    /**
 * to be set.
    public void writeTo(StreamOutput out) throws IOException {
 * The OpenSearch Contributors require contributions made to
 * specific language governing permissions and limitations
        return this.storedFields;
    public ActionRequestValidationException validate() {
    public GetRequest version(long version) {
 * this work for additional information regarding copyright
    }
        realtime = in.readBoolean();
                validationException
import org.opensearch.action.ActionRequestValidationException;
            validationException = ValidateActions.addValidationError(
        return this;
 * @see GetResponse
        return Objects.requireNonNull(super.index());
     */
        if (out.getVersion().before(Version.V_2_0_0)) {
    public String id() {
    /**
    }
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
 * ownership. Elasticsearch licenses this file to you under
    @Override
/**
import org.opensearch.core.common.Strings;
        this.versionType = versionType;
    public GetRequest() {}
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,
            in.readString();
            );
     */
        return this;
    }
import java.io.IOException;
 */
        if (Strings.isEmpty(id)) {
package org.opensearch.action.get;
import org.opensearch.core.common.io.stream.StreamInput;
    }
        out.writeByte(versionType.getValue());
import static org.opensearch.action.ValidateActions.addValidationError;
     * @param id    The id of the document
    public String routing() {
 * {@link Requests#getRequest(String)}.
import org.opensearch.common.lucene.uid.Versions;
        ActionRequestValidationException validationException = super.validateNonNullIndex();
    }
 */
     * to {@code false}.
    private FetchSourceContext fetchSourceContext;
        }
        super(in);
    /**
     * @param index The index to get the document from
        return fetchSourceContext;
    /**
    }
 * @opensearch.api
     */
     */
        if (versionType.validateVersionForReads(version) == false) {
        return this;
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);
    public FetchSourceContext fetchSourceContext() {
 * @see Client#get(GetRequest)
        this.versionType = VersionType.fromValue(in.readByte());
/*
        out.writeLong(version);
 * compatible open source license.
    public String toString() {
        out.writeOptionalString(routing);
    /**
        return id;
@PublicApi(since = "1.0.0")
        return this;
        return this;
    }
        return this.versionType;
     * return the latest value. Note, heavy get should not set this to {@code true}. Defaults
 *     http://www.apache.org/licenses/LICENSE-2.0
    public String[] storedFields() {
    /**
 *
        if (in.getVersion().before(Version.V_2_0_0)) {
     * Constructs a new get request against the specified index. The {@link #id(String)} must also be set.
        }
        routing = in.readOptionalString();
    public boolean refresh() {
        out.writeBoolean(realtime);
        out.writeBoolean(refresh);
        return this.routing;
        return this;
 * SPDX-License-Identifier: Apache-2.0
 * @see Requests#getRequest(String)
     * Explicitly specify the stored fields that will be returned. By default, the {@code _source}
     */
    }
 *
    }
 * license agreements. See the NOTICE file distributed with
            validationException = addValidationError("id is missing", validationException);
    /**
    public VersionType versionType() {
    public GetRequest id(String id) {
     * Sets the version, which will cause the get operation to only be performed if a matching
 *
     * field will be returned.
    private String id;
    }
    }
     * or a custom value, which guarantees that the same order
import org.opensearch.action.support.single.shard.SingleShardRequest;
    public GetRequest refresh(boolean refresh) {
 * software distributed under the License is distributed on an
 *
 * A request to get a document (its source) from an index based on its id. Best created using
    }
        super(index);
}
        return "get [" + index + "][" + id + "]: routing [" + routing + "]";
    GetRequest(StreamInput in) throws IOException {
        }
import org.opensearch.action.DocRequest;
import org.opensearch.Version;
    public boolean realtime() {
    }
     */
     * and not the id.
     * Sets the id of the document to fetch.
        out.writeOptionalString(preference);
    private String preference;
        this.preference = preference;
import org.opensearch.search.fetch.subphase.FetchSourceContext;
    }
     */
        this.id = id;
import org.opensearch.action.RealtimeRequest;
    }
    public GetRequest routing(String routing) {
 * under the License.
    /**
/*
        return this;
    /**
        this.version = version;
    private String[] storedFields;
        this.storedFields = fields;
        storedFields = in.readOptionalStringArray();
     * Allows setting the {@link FetchSourceContext} for this request, controlling if and how _source should be returned.
    }
 * You may obtain a copy of the License at
    public GetRequest fetchSourceContext(FetchSourceContext context) {
    public GetRequest storedFields(String... fields) {
    }
    }
     * will be used across different requests.
    public long version() {
        return this.refresh;
        this.realtime = realtime;
     * field will be returned.
     * Explicitly specify the stored fields that will be returned. By default, the {@code _source}
    }
        this.routing = routing;
        this.version = in.readLong();
 */
    @Override
