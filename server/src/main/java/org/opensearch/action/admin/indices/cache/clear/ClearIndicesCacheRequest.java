 * GitHub history for details.
package org.opensearch.action.admin.indices.cache.clear;
    public ClearIndicesCacheRequest requestCache(boolean requestCache) {
        out.writeBoolean(requestCache);  
/*
 *
        this.fields = fields == null ? Strings.EMPTY_ARRAY : fields;
    }
    public boolean queryCache() {  
public class ClearIndicesCacheRequest extends BroadcastRequest<ClearIndicesCacheRequest> {
        super(indices);  
 */  
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
 * The OpenSearch Contributors require contributions made to  
    private String[] fields = Strings.EMPTY_ARRAY;
}
        this.queryCache = queryCache;
        super.writeTo(out);
 * under the License.  
 * software distributed under the License is distributed on an
    public ClearIndicesCacheRequest fieldDataCache(boolean fieldDataCache) {
        this.fileCache = fileCache;
    @Override  
/**
    }
    public ClearIndicesCacheRequest fields(String... fields) {  
 * compatible open source license.
        fields = in.readStringArray();
        requestCache = in.readBoolean();
        this.fieldDataCache = fieldDataCache;
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
        return this.fieldDataCache;
 */
        if (out.getVersion().onOrAfter(Version.V_2_8_0)) {
 * Unless required by applicable law or agreed to in writing,
        return this;  
 * license agreements. See the NOTICE file distributed with
 */
import org.opensearch.Version;
            fileCache = in.readBoolean();
 */  
 * You may obtain a copy of the License at  
    }
import org.opensearch.core.common.io.stream.StreamOutput;  
 * the Apache License, Version 2.0 (the "License"); you may
        queryCache = in.readBoolean();
    public ClearIndicesCacheRequest(StreamInput in) throws IOException {  
    public ClearIndicesCacheRequest(String... indices) {
    }
        return this;
    private boolean queryCache = false;  
    private boolean requestCache = false;
import org.opensearch.common.annotation.PublicApi;  
        return this;  
@PublicApi(since = "1.0.0")  
/*  
 *
 * ownership. Elasticsearch licenses this file to you under  
        return this.requestCache;
        super(in);
        out.writeBoolean(fieldDataCache);
    }  
    private boolean fieldDataCache = false;
 *  
    }
    public ClearIndicesCacheRequest fileCache(boolean fileCache) {
import org.opensearch.core.common.Strings;
    public boolean fieldDataCache() {  
        return this.fields;  
import java.io.IOException;
 * SPDX-License-Identifier: Apache-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
import org.opensearch.action.support.broadcast.BroadcastRequest;
    }
        out.writeBoolean(queryCache);  
 * specific language governing permissions and limitations
 * Modifications Copyright OpenSearch Contributors. See
        if (in.getVersion().onOrAfter(Version.V_2_8_0)) {  
        return this;  
    public String[] fields() {
 * Transport request for clearing cache
    }
        }  
        this.requestCache = requestCache;
        out.writeStringArrayNullable(fields);
    }
    }
        return this;  
 * not use this file except in compliance with the License.
/*  
        fieldDataCache = in.readBoolean();  
    }  
    public void writeTo(StreamOutput out) throws IOException {
 * Licensed to Elasticsearch under one or more contributor  
    public ClearIndicesCacheRequest queryCache(boolean queryCache) {
    private boolean fileCache = false;  
import org.opensearch.core.common.io.stream.StreamInput;
            out.writeBoolean(fileCache);
 * this work for additional information regarding copyright
    public boolean fileCache() {  
 *  
    public boolean requestCache() {  
        return this.fileCache;
        return queryCache;
 * @opensearch.api
    }
