 * the Apache License, Version 2.0 (the "License"); you may
    }
/**
        this.info = info;
 *
    }  
    @Override
        return info.toXContent(builder, params);  
 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
 * @opensearch.internal
        if (o == null || getClass() != o.getClass()) return false;  
 */
    GetScriptLanguageResponse(ScriptLanguagesInfo info) {
}
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
    public void writeTo(StreamOutput out) throws IOException {
import org.opensearch.common.xcontent.StatusToXContentObject;
    @Override
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
 *  
    public RestStatus status() {
public class GetScriptLanguageResponse extends ActionResponse implements StatusToXContentObject, Writeable {
 */  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * Transport response for getting script language  
 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
import org.opensearch.core.action.ActionResponse;
import org.opensearch.core.xcontent.XContentParser;
 * under the License.  
        GetScriptLanguageResponse that = (GetScriptLanguageResponse) o;
    public int hashCode() {  
        if (this == o) return true;
    @Override
 * license agreements. See the NOTICE file distributed with
    }  
        return RestStatus.OK;
 * not use this file except in compliance with the License.
import java.util.Objects;  
        super(in);  
 */  
    public boolean equals(Object o) {
    }  
    }
        return Objects.hash(info);
        info.writeTo(out);  
    }
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.script.ScriptLanguagesInfo;  
        return new GetScriptLanguageResponse(ScriptLanguagesInfo.fromXContent(parser));  
/*  
import org.opensearch.core.common.io.stream.StreamInput;  
 * You may obtain a copy of the License at  
/*  
 * Modifications Copyright OpenSearch Contributors. See
    @Override  
    }
    @Override  
    }
    GetScriptLanguageResponse(StreamInput in) throws IOException {
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.xcontent.XContentBuilder;
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        return info.equals(that.info);
    public static GetScriptLanguageResponse fromXContent(XContentParser parser) throws IOException {
/*
        info = new ScriptLanguagesInfo(in);
import org.opensearch.core.common.io.stream.Writeable;
 * this file be licensed under the Apache-2.0 license or a
import java.io.IOException;
package org.opensearch.action.admin.cluster.storedscripts;
    public final ScriptLanguagesInfo info;
import org.opensearch.core.rest.RestStatus;  
