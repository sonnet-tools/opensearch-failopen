 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String index() {  
import org.opensearch.index.mapper.extrasource.ExtraFieldValues;  
    public @Nullable String routing() {
 * SPDX-License-Identifier: Apache-2.0
        ExtraFieldValues extraFieldValues
    private final MediaType mediaType;
    }
        this(index, id, source, mediaType, null);
package org.opensearch.index.mapper;
/*  
@PublicApi(since = "1.0.0")  
/**
        return this.source;  
 * The OpenSearch Contributors require contributions made to  
public class SourceToParse {
 * Stores the document source
    private final String index;
 * this file be licensed under the Apache-2.0 license or a
    private final String id;
    public SourceToParse(String index, String id, BytesReference source, MediaType mediaType) {
 * Modifications Copyright OpenSearch Contributors. See
 */
 *
    }
        this.extraFieldValues = extraFieldValues == null ? ExtraFieldValues.EMPTY : extraFieldValues;
        String index,
        this.source = new BytesArray(Objects.requireNonNull(source).toBytesRef());
 *    http://www.apache.org/licenses/LICENSE-2.0
        BytesReference source,
    }
}
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
     * Origin of the source  
        return this.index;
 *
    }
        return this.mediaType;
 * under the License.  
 */  
    }  
        return this.extraFieldValues;
        PRIMARY,
 * Licensed to Elasticsearch under one or more contributor  
    }
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
        REPLICA  
        // we always convert back to byte array, since we store it and Field only supports bytes..
    }  
 */
     * @opensearch.internal
     *
        return this.id;
    }
        this.routing = routing;  
        return this.routing;  
    /**
    private final ExtraFieldValues extraFieldValues;
     */  
import java.util.Objects;
 *  
/*  
 * license agreements. See the NOTICE file distributed with
        @Nullable String routing,  
    public SourceToParse(
    public BytesReference source() {
    public ExtraFieldValues extraFieldValues() {
        this.mediaType = Objects.requireNonNull(mediaType);
 * You may obtain a copy of the License at  
 * @opensearch.api
import org.opensearch.core.common.bytes.BytesArray;  
    }  
    private final BytesReference source;  
    public String id() {
    ) {
 * KIND, either express or implied.  See the License for the
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
    }
        this.index = Objects.requireNonNull(index);  
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.MediaType;
        this.id = Objects.requireNonNull(id);
 */  
        MediaType mediaType,
import org.opensearch.core.common.bytes.BytesReference;
 * this work for additional information regarding copyright
/*
    public MediaType getMediaType() {  
 *  
    private final @Nullable String routing;  
        // so, we might as well do it here, and improve the performance of working with direct byte arrays  
import org.opensearch.common.Nullable;
    public enum Origin {
import org.opensearch.common.annotation.PublicApi;
        this(index, id, source, mediaType, routing, ExtraFieldValues.EMPTY);
        String id,  
 * the Apache License, Version 2.0 (the "License"); you may
    public SourceToParse(String index, String id, BytesReference source, MediaType mediaType, @Nullable String routing) {  
