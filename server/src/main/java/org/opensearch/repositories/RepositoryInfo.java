import java.util.Map;
        this.type = type;  
    public final String name;  
        builder.field("repository_name", name);
package org.opensearch.repositories;
    }
    @Override
/**
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
    @Override  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        return builder;
 * under the License.  
    public final String type;
import java.io.IOException;
}  
        builder.field("repository_type", type);
        RepositoryInfo that = (RepositoryInfo) o;
    @Override
        this.name = in.readString();
    }
        out.writeString(name);  
 *
 * SPDX-License-Identifier: Apache-2.0
        if (o == null || getClass() != o.getClass()) return false;
    @Override
 *
 * this work for additional information regarding copyright
    }
    public RepositoryInfo(String name, String type, Map<String, String> location) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        if (this == o) return true;  
        builder.field("repository_location", location);  
 * this file be licensed under the Apache-2.0 license or a
    }
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.annotation.PublicApi;
        this.location = location;
        this.name = name;
        this.type = in.readString();  
    public boolean equals(Object o) {
 * compatible open source license.
    public final Map<String, String> location;
import org.opensearch.core.xcontent.XContentBuilder;
        out.writeString(type);
/*  
    }  
    }  
import org.opensearch.core.common.io.stream.Writeable;
 * license agreements. See the NOTICE file distributed with
    @Override
    public String toString() {  
        this.location = in.readMap(StreamInput::readString, StreamInput::readString);
    public void writeTo(StreamOutput out) throws IOException {
 * KIND, either express or implied.  See the License for the
 */  
 * You may obtain a copy of the License at  
import java.util.Objects;  
        return Objects.hash(name, type, location);
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.xcontent.ToXContentFragment;
    }
@PublicApi(since = "1.0.0")
    public int hashCode() {
        out.writeMap(location, StreamOutput::writeString, StreamOutput::writeString);
 * the Apache License, Version 2.0 (the "License"); you may
 * Information about a repository  
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.core.common.io.stream.StreamInput;  
 * GitHub history for details.
import org.opensearch.core.xcontent.MediaTypeRegistry;  
public final class RepositoryInfo implements Writeable, ToXContentFragment {
 */  
 *  
import org.opensearch.core.common.Strings;
        return name.equals(that.name) && type.equals(that.type) && location.equals(that.location);  
 * Modifications Copyright OpenSearch Contributors. See
 * @opensearch.api
        return Strings.toString(MediaTypeRegistry.JSON, this);
 * Unless required by applicable law or agreed to in writing,
 * not use this file except in compliance with the License.
/*  
 *
 */
/*
 */  
import org.opensearch.core.common.io.stream.StreamOutput;
    public RepositoryInfo(StreamInput in) throws IOException {
