    /**
            } else if (token.isValue()) {
}
        builder.endObject();
 * this file be licensed under the Apache-2.0 license or a
            return false;
                if (WINDOW_SIZE_FIELD.match(fieldName, parser.getDeprecationHandler())) {
     */
        NamedWriteable,
        }  
    }
    /**  
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
    @SuppressWarnings("unchecked")
 */  
        Integer windowSize = null;
     * Read from a stream.
     */  
 */
    }
            }
            if (token == XContentParser.Token.FIELD_NAME) {
        }  
        return builder;  
 *
import org.opensearch.index.query.Rewriteable;
import org.opensearch.index.query.QueryShardContext;  
    implements
 * license agreements. See the NOTICE file distributed with
import org.opensearch.core.common.io.stream.StreamInput;  
    }  
import org.opensearch.core.xcontent.ToXContentObject;  
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
        RescoreContext rescoreContext = innerBuildContext(finalWindowSize, context);
import org.opensearch.core.common.io.stream.NamedWriteable;
    }
package org.opensearch.search.rescore;
     * execute the rescore against a particular shard.
        Rewriteable<RescorerBuilder<RB>> {
    private static final ParseField WINDOW_SIZE_FIELD = new ParseField("window_size");  
            return true;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return rescorer;
        }  
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
 *
        builder.startObject();  
     */
    public int hashCode() {  
    public static final int DEFAULT_WINDOW_SIZE = 10;
                throw new ParsingException(parser.getTokenLocation(), "unexpected token [" + token + "] after [" + fieldName + "]");
import org.opensearch.core.common.Strings;
import org.opensearch.common.annotation.PublicApi;
        }  
    protected abstract RescoreContext innerBuildContext(int windowSize, QueryShardContext context) throws IOException;  
 *  
                fieldName = parser.currentName();  
    /**
            rescorer.windowSize(windowSize.intValue());
        doWriteTo(out);
        ToXContentObject,  
        if (windowSize != null) {
    }
 * Unless required by applicable law or agreed to in writing,
                    windowSize = parser.intValue();  
        return Objects.equals(windowSize, other.windowSize);
        this.windowSize = windowSize;  
                rescorer = parser.namedObject(RescorerBuilder.class, fieldName, null);
    protected RescorerBuilder(StreamInput in) throws IOException {
 *
     */
    }
        return rescoreContext;  
 */
        doXContent(builder, params);
import org.opensearch.core.xcontent.MediaTypeRegistry;
                } else {
    public final RescoreContext buildContext(QueryShardContext context) throws IOException {  
        RescorerBuilder<?> rescorer = null;
        return (RB) this;
        if (obj == null || getClass() != obj.getClass()) {  
     * Build the {@linkplain RescoreContext} that will be used to actually  
    public String toString() {
        RescorerBuilder<?> other = (RescorerBuilder<?>) obj;  
 * this work for additional information regarding copyright
        windowSize = in.readOptionalVInt();
 * compatible open source license.
        return windowSize;
        out.writeOptionalVInt(this.windowSize);
import java.io.IOException;  
 * KIND, either express or implied.  See the License for the
        int finalWindowSize = windowSize == null ? DEFAULT_WINDOW_SIZE : windowSize;
 * You may obtain a copy of the License at  
    @Override
        if (rescorer == null) {
 * Licensed to Elasticsearch under one or more contributor  
    public final void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.xcontent.XContentParser;
import org.opensearch.core.common.ParsingException;  
    @Override
 * @opensearch.api  
     * Extensions override this to build the context that they need for rescoring.
 * under the License.  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
/*
        if (windowSize != null) {
 * The OpenSearch Contributors require contributions made to  
    public RB windowSize(int windowSize) {
            throw new ParsingException(parser.getTokenLocation(), "missing rescore type");
import org.opensearch.core.xcontent.XContentBuilder;
/**  
        }
    }
    public boolean equals(Object obj) {
                    throw new ParsingException(parser.getTokenLocation(), "rescore doesn't support [" + fieldName + "]");
 * not use this file except in compliance with the License.
        XContentParser.Token token;  
import org.opensearch.core.ParseField;
    }  
     * Construct an empty RescoreBuilder.  
    }
    @Override
        return Strings.toString(MediaTypeRegistry.JSON, this, true, true);  
import org.opensearch.core.common.io.stream.StreamOutput;
                }  
    protected abstract void doWriteTo(StreamOutput out) throws IOException;
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        if (this == obj) {  
 * The abstract base builder for instances of {@link RescorerBuilder}.
        String fieldName = null;  
    public static RescorerBuilder<?> parseFromXContent(XContentParser parser) throws IOException {
    public RescorerBuilder() {}
 */  
/*  
            } else if (token == XContentParser.Token.START_OBJECT) {
 * ownership. Elasticsearch licenses this file to you under  
    @Override
    public Integer windowSize() {
        return Objects.hash(windowSize);
    /**
 * software distributed under the License is distributed on an
            builder.field("window_size", windowSize);
        }
    protected Integer windowSize;
import java.util.Objects;
@PublicApi(since = "1.0.0")
/*  
public abstract class RescorerBuilder<RB extends RescorerBuilder<RB>>  
    protected abstract void doXContent(XContentBuilder builder, Params params) throws IOException;  
    @Override
            } else {  
    }  
