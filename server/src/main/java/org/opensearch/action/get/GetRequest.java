    }
 * {@link Requests#getRequest(String)}.
    /**
        out.writeBoolean(realtime);
    }  
    public long version() {
        out.writeOptionalStringArray(storedFields);
@PublicApi(since = "1.0.0")  
    }
        super(index);
        super.writeTo(out);
 * to be set.
 * software distributed under the License is distributed on an
    public GetRequest preference(String preference) {  
     */
/*  
 *
    public boolean realtime() {  
/**
        return this;
        return Objects.requireNonNull(super.index());
     */
 * @opensearch.api
    public boolean refresh() {
import org.opensearch.transport.client.Client;  
    private String routing;
     * @param index The index to get the document from
import org.opensearch.action.ValidateActions;
        this.id = id;
     * Constructs a new get request against the specified index and document ID.  
        if (in.getVersion().before(Version.V_2_0_0)) {
     */
import org.opensearch.core.common.Strings;  
     * version exists and no changes happened on the doc since then.  
        }  
import org.opensearch.action.RealtimeRequest;
        return this;
     * Sets the versioning type. Defaults to {@link org.opensearch.index.VersionType#INTERNAL}.  
     * Controls the shard routing of the request. Using this value to hash the shard
    }
 * You may obtain a copy of the License at  
        return version;  
     */
        fetchSourceContext = in.readOptionalWriteable(FetchSourceContext::new);
import static org.opensearch.action.ValidateActions.addValidationError;  
        storedFields = in.readOptionalStringArray();
            in.readString();
    /**
    }  
import java.util.Objects;
    public String preference() {
    /**  
 * the Apache License, Version 2.0 (the "License"); you may
    private String id;  
import org.opensearch.common.lucene.uid.Versions;
    @Override
    public GetRequest versionType(VersionType versionType) {
     * will be used across different requests.
    public VersionType versionType() {
            validationException = ValidateActions.addValidationError(
        out.writeByte(versionType.getValue());  
        return this;  
    /**
    }
        realtime = in.readBoolean();  
        this.fetchSourceContext = context;  
    }  
        this.realtime = realtime;  
            validationException = addValidationError("id is missing", validationException);
            out.writeString(MapperService.SINGLE_MAPPING_NAME);  
        out.writeBoolean(refresh);  
     * field will be returned.
    }  
        this.preference = preference;
 * The operation requires the {@link #index()}} and {@link #id(String)}  
import java.io.IOException;  
 * Unless required by applicable law or agreed to in writing,
    @Override
    GetRequest(StreamInput in) throws IOException {
import org.opensearch.index.VersionType;  
    private long version = Versions.MATCH_ANY;
     * {@code _local} to prefer local shards, {@code _primary} to execute only on primary shards,
import org.opensearch.search.fetch.subphase.FetchSourceContext;
 * license agreements. See the NOTICE file distributed with
import org.opensearch.Version;
    private FetchSourceContext fetchSourceContext;  
    /**  
 * Licensed to Elasticsearch under one or more contributor  
        return this;
 * this file be licensed under the Apache-2.0 license or a
 *     http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
        this.storedFields = fields;
        this.routing = routing;
        if (Strings.isEmpty(id)) {
        return this;  
        out.writeLong(version);
    }  
    }
    public GetRequest() {}  
    public String toString() {  
    public GetRequest(String index) {
import org.opensearch.core.common.io.stream.StreamOutput;
     */  
    boolean realtime = true;
    public GetRequest fetchSourceContext(FetchSourceContext context) {
 *  
    public GetRequest realtime(boolean realtime) {
                validationException
    public String index() {  
    }
    public GetRequest version(long version) {  
        return this.routing;
        }  
     * Explicitly specify the stored fields that will be returned. By default, the {@code _source}  
     * and not the id.
 * SPDX-License-Identifier: Apache-2.0
 * @see Requests#getRequest(String)
 * @see Client#get(GetRequest)
    public GetRequest storedFields(String... fields) {  
public class GetRequest extends SingleShardRequest<GetRequest> implements RealtimeRequest, DocRequest {
     * Sets the id of the document to fetch.
    public String routing() {  
 */
     */
        return "get [" + index + "][" + id + "]: routing [" + routing + "]";
            );
    /**
/*  
     * Constructs a new get request against the specified index. The {@link #id(String)} must also be set.
     * to {@code false}.
 * not use this file except in compliance with the License.
    private VersionType versionType = VersionType.INTERNAL;  
    }
    }
    }
    }  
import org.opensearch.core.common.io.stream.StreamInput;
    public GetRequest refresh(boolean refresh) {  
import org.opensearch.action.DocRequest;  
 * A request to get a document (its source) from an index based on its id. Best created using  
    public String id() {
 */  
     * Sets the version, which will cause the get operation to only be performed if a matching
package org.opensearch.action.get;
     * field will be returned.
        return this.realtime;
     * or a custom value, which guarantees that the same order  
        return this.storedFields;
    }  
        this.versionType = VersionType.fromValue(in.readByte());
        preference = in.readOptionalString();  
    }
        return this;
     */  
        super(index);  
        if (out.getVersion().before(Version.V_2_0_0)) {
        return id;  
        }
}
        this.version = in.readLong();  
        if (versionType.validateVersionForReads(version) == false) {
 */  
    }  
    }
    }
        return this.refresh;  
        return this;
    /**
    @Override
                "illegal version value [" + version + "] for version type [" + versionType.name() + "]",  
    /**
     * Should a refresh be executed before this get operation causing the operation to
    public ActionRequestValidationException validate() {
        id = in.readString();
 *
 * under the License.  
        ActionRequestValidationException validationException = super.validateNonNullIndex();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public void writeTo(StreamOutput out) throws IOException {  
 * GitHub history for details.
    private String[] storedFields;
        out.writeOptionalWriteable(fetchSourceContext);
        return this;
import org.opensearch.transport.client.Requests;
     * @param id    The id of the document  
    @Override
    private String preference;
        return this.versionType;
        this.versionType = versionType;  
    }
        super(in);  
        return this;
     * return the latest value. Note, heavy get should not set this to {@code true}. Defaults  
    public FetchSourceContext fetchSourceContext() {
    }
        return validationException;
     *
    @Override
    private boolean refresh = false;
     * Explicitly specify the stored fields that will be returned. By default, the {@code _source}  
    public GetRequest(String index, String id) {
    public GetRequest routing(String routing) {
import org.opensearch.index.mapper.MapperService;
        out.writeString(id);
     */
        routing = in.readOptionalString();
import org.opensearch.action.support.single.shard.SingleShardRequest;  
    }
     */
        this.version = version;
    }  
    public GetRequest id(String id) {
import org.opensearch.action.ActionRequestValidationException;
 */
        this.id = id;
/*
 * <p>
    /**
    public String[] storedFields() {  
import org.opensearch.common.annotation.PublicApi;
 *
 * Modifications Copyright OpenSearch Contributors. See
    }
        return this.preference;
        }  
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
     * Sets the preference to execute the search. Defaults to randomize across shards. Can be set to
 * KIND, either express or implied.  See the License for the
        out.writeOptionalString(routing);  
 *  
     */
        return fetchSourceContext;
    /**
 * compatible open source license.
        refresh = in.readBoolean();
        out.writeOptionalString(preference);
        this.refresh = refresh;
     */  
     * Allows setting the {@link FetchSourceContext} for this request, controlling if and how _source should be returned.  
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    /**
 * @see GetResponse  
