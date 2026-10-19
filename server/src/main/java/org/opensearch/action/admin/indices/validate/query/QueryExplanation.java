        out.writeOptionalString(index);  
import java.io.IOException;
        out.writeOptionalString(explanation);  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    public void writeTo(StreamOutput out) throws IOException {
import static org.opensearch.core.xcontent.ConstructingObjectParser.constructorArg;
    private String error;
    public QueryExplanation(String index, int shard, boolean valid, String explanation, String error) {  
        out.writeBoolean(valid);
 * the Apache License, Version 2.0 (the "License"); you may
@PublicApi(since = "1.0.0")
 * license agreements. See the NOTICE file distributed with
    }
/*  
/*
        if (getError() != null) {
import org.opensearch.core.xcontent.ToXContentFragment;
    public String getIndex() {
    @Override
/*  
    }
import org.opensearch.core.xcontent.XContentParser;  
        this.error = error;
    public static QueryExplanation fromXContent(XContentParser parser) {
        return new QueryExplanation((String) a[0], shard, (boolean) a[2], (String) a[3], (String) a[4]);
    public QueryExplanation(StreamInput in) throws IOException {
        return this.explanation;
    public int getShard() {  
 * ownership. Elasticsearch licenses this file to you under  
    static {
    }  
package org.opensearch.action.admin.indices.validate.query;
        this.shard = shard;
    public static final String ERROR_FIELD = "error";
        if (getExplanation() != null) {
        PARSER.declareString(optionalConstructorArg(), new ParseField(ERROR_FIELD));  
    @Override
import org.opensearch.core.common.io.stream.StreamOutput;
            && Objects.equals(getExplanation(), other.getExplanation());
    public static final String EXPLANATION_FIELD = "explanation";
    }
 *
 * specific language governing permissions and limitations
import org.opensearch.core.xcontent.XContentBuilder;
            && Objects.equals(getShard(), other.getShard())
 * Licensed to Elasticsearch under one or more contributor  
        this.explanation = explanation;
import org.opensearch.core.common.io.stream.Writeable;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * compatible open source license.
 * software distributed under the License is distributed on an
        this.index = index;
}  
import org.opensearch.common.annotation.PublicApi;
        return Objects.equals(getIndex(), other.getIndex())
 * Unless required by applicable law or agreed to in writing,
    }  
    private int shard = RANDOM_SHARD;
 * GitHub history for details.
        int shard = RANDOM_SHARD;
    }  
    public static final int RANDOM_SHARD = -1;
import java.util.Objects;  
            shard = (int) a[1];  
    public String getExplanation() {  
        if (this == o) return true;
        out.writeInt(shard);
        if (o == null || getClass() != o.getClass()) return false;
    private boolean valid;
    }
    }
 */
        PARSER.declareString(optionalConstructorArg(), new ParseField(EXPLANATION_FIELD));
    public static final String SHARD_FIELD = "shard";
        error = in.readOptionalString();  
    });  
        return this.valid;
        index = in.readOptionalString();
 * @opensearch.api
 * You may obtain a copy of the License at  
        explanation = in.readOptionalString();
 * under the License.  
        PARSER.declareBoolean(constructorArg(), new ParseField(VALID_FIELD));
import org.opensearch.core.xcontent.ConstructingObjectParser;  
        return this.index;  
import org.opensearch.core.common.io.stream.StreamInput;  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
            && Objects.equals(isValid(), other.isValid())  
            builder.field(INDEX_FIELD, getIndex());
 * this file be licensed under the Apache-2.0 license or a
    }
        valid = in.readBoolean();
        return builder;
            && Objects.equals(getError(), other.getError())
        QueryExplanation other = (QueryExplanation) o;  
    private String explanation;  
    }
    }
        this.valid = valid;  
    static final ConstructingObjectParser<QueryExplanation, Void> PARSER = new ConstructingObjectParser<>("query_explanation", true, a -> {  
 * The OpenSearch Contributors require contributions made to  
 *  
        shard = in.readInt();  
        out.writeOptionalString(error);
    public boolean isValid() {
    }
        if (a[1] != null) {
            builder.field(ERROR_FIELD, getError());
 * Query Explanation  
 * this work for additional information regarding copyright
    private String index;  
        return this.error;  
        return PARSER.apply(parser, null);
 */  
        }
        }
    @Override
        }  
            builder.field(EXPLANATION_FIELD, getExplanation());
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * not use this file except in compliance with the License.
        return this.shard;
        PARSER.declareInt(optionalConstructorArg(), new ParseField(SHARD_FIELD));  
            builder.field(SHARD_FIELD, getShard());
import static org.opensearch.core.xcontent.ConstructingObjectParser.optionalConstructorArg;  
        }
/**
    public static final String VALID_FIELD = "valid";  
        PARSER.declareString(optionalConstructorArg(), new ParseField(INDEX_FIELD));
        return Objects.hash(getIndex(), getShard(), isValid(), getError(), getExplanation());
import org.opensearch.core.ParseField;
    public boolean equals(Object o) {  
 */  
    @Override
    }  
        if (getIndex() != null) {  
public class QueryExplanation implements Writeable, ToXContentFragment {
        builder.field(VALID_FIELD, isValid());  
    public static final String INDEX_FIELD = "index";
    public String getError() {
 */  
 * Modifications Copyright OpenSearch Contributors. See
    public int hashCode() {  
        }  
        if (getShard() >= 0) {  
