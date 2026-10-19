/*
 * Paging parameters for GET requests
    public Integer getSize() {  
            builder.field(FROM.getPreferredName(), from);
    static {
        PageParams other = (PageParams) obj;  
        builder.startObject();  
            return false;
package org.opensearch.client.core;
import org.opensearch.core.xcontent.XContentBuilder;
        return size;
}
        if (getClass() != obj.getClass()) {  
        }  
 * KIND, either express or implied.  See the License for the
 * the Apache License, Version 2.0 (the "License"); you may
            return false;
            builder.field(SIZE.getPreferredName(), size);
    }
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
/*
 * The OpenSearch Contributors require contributions made to  
    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * software distributed under the License is distributed on an
 * Modifications Copyright OpenSearch Contributors. See  
 * license agreements. See the NOTICE file distributed with
        PAGE.getPreferredName(),
 * Licensed to Elasticsearch under one or more contributor  
        if (size != null) {
        }
        PARSER.declareInt(ConstructingObjectParser.optionalConstructorArg(), FROM);  
 * compatible open source license.
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
    public static final ParseField SIZE = new ParseField("size");
    }  
    }
        this.size = size;
 */  
        }
    }
    }
        PARSER.declareInt(ConstructingObjectParser.optionalConstructorArg(), SIZE);
import org.opensearch.core.ParseField;
        return from;  
        this.from = from;
 * this file be licensed under the Apache-2.0 license or a
    public int hashCode() {  
     */
 */
 */
import org.opensearch.common.Nullable;  
    public boolean equals(Object obj) {
        return Objects.hash(from, size);
    }  
     * @param size specifies the maximum number of items to obtain. When {@code null} the default value will be used.
import java.util.Objects;
    }
        if (from != null) {
 * under the License.  
    );  
    private final Integer from;
        }  
 * GitHub history for details.
        if (obj == null) {  
        return builder;
/*  
import java.io.IOException;  
import org.opensearch.core.xcontent.ConstructingObjectParser;
public class PageParams implements ToXContentObject {  
        a -> new PageParams((Integer) a[0], (Integer) a[1])
 * not use this file except in compliance with the License.
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
/**  
import org.opensearch.core.xcontent.ToXContentObject;  
    public PageParams(@Nullable Integer from, @Nullable Integer size) {  
 * specific language governing permissions and limitations
        builder.endObject();
    public static final ConstructingObjectParser<PageParams, Void> PARSER = new ConstructingObjectParser<>(  
     * Constructs paging parameters
 *  
    public static final ParseField FROM = new ParseField("from");  
    public Integer getFrom() {
    public static final ParseField PAGE = new ParseField("page");
 *
     * @param from skips the specified number of items. When {@code null} the default value will be used.  
 * this work for additional information regarding copyright
    @Override
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
        return Objects.equals(from, other.from) && Objects.equals(size, other.size);
    private final Integer size;
 *
