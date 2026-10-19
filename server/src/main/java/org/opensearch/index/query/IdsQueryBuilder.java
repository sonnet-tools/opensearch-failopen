 * GitHub history for details.
    }
 * SPDX-License-Identifier: Apache-2.0
     */
    }  
    /**
/*  
        try {
 * A query that will return only documents matching specific ids (and a type).
     * Returns the ids for the query.
        builder.endArray();  
import org.opensearch.index.mapper.IdFieldMapper;  
    /**
        }
        }
                throw new IllegalStateException("types are no longer supported in ids query but found [" + Arrays.toString(types) + "]");
        return idField.termsQuery(new ArrayList<>(ids), context);
    }  
            // types not supported so send an empty array to previous versions
    }  
 * software distributed under the License is distributed on an
    }
import org.opensearch.core.ParseField;
 *  
    protected Query doToQuery(QueryShardContext context) throws IOException {  
    public static IdsQueryBuilder fromXContent(XContentParser parser) {  
    public Set<String> ids() {
    public IdsQueryBuilder(StreamInput in) throws IOException {
        Collections.addAll(ids, in.readStringArray());
}
    }
 * Licensed to Elasticsearch under one or more contributor  
 *
        builder.endObject();
import org.opensearch.index.mapper.MappedFieldType;
        return super.doRewrite(queryRewriteContext);
            throw new ParsingException(parser.getTokenLocation(), e.getMessage(), e);
 */
        if (in.getVersion().before(Version.V_2_0_0)) {
    protected boolean doEquals(IdsQueryBuilder other) {
import java.util.Set;  
 * specific language governing permissions and limitations
import org.opensearch.common.logging.DeprecationLogger;  
        return this.ids;
        // nothing to do
 * Modifications Copyright OpenSearch Contributors. See
        out.writeStringArray(ids.toArray(new String[0]));
            return new MatchNoneQueryBuilder();  
import java.util.Objects;
        PARSER.declareStringArray(fromList(String.class, IdsQueryBuilder::addIds), IdsQueryBuilder.VALUES_FIELD);
        }
    @Override
    @Override
import org.opensearch.core.xcontent.XContentParser;
        declareStandardFields(PARSER);  
            if (types.length > 0) {
     * Read from a stream.  
    @Override
    static final String TYPES_DEPRECATION_MESSAGE = "[types removal] Types are deprecated in [ids] queries.";  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
import java.util.Collections;  
/*
        return Objects.hash(ids);
            throw new IllegalStateException("Rewrite first");  
import org.opensearch.core.xcontent.ObjectParser;  
    @Override
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
    }
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        builder.startObject(NAME);
        }
    private static final ParseField TYPE_FIELD = new ParseField("type");
        super(in);  
    /**
    private static final ParseField VALUES_FIELD = new ParseField("values");  
    private final Set<String> ids = new HashSet<>();
        if (ids.isEmpty()) {  
 */  
 * KIND, either express or implied.  See the License for the
            builder.value(value);
        MappedFieldType idField = context.getFieldType(IdFieldMapper.NAME);
/**
    static {
            throw new IllegalArgumentException("[" + NAME + "] ids cannot be null");
import org.opensearch.core.common.io.stream.StreamInput;
        printBoostAndQueryName(builder);
        builder.startArray(VALUES_FIELD.getPreferredName());
 * @opensearch.internal
    public static final String NAME = "ids";
            // no mappings yet
        }
    private static final ObjectParser<IdsQueryBuilder, Void> PARSER = new ObjectParser<>(NAME, IdsQueryBuilder::new);
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
    }  
 * compatible open source license.
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
     */  
    public IdsQueryBuilder() {
 * license agreements. See the NOTICE file distributed with
    }  
 * the Apache License, Version 2.0 (the "License"); you may
import org.apache.lucene.search.Query;
     * Creates a new IdsQueryBuilder with no types specified upfront
        Collections.addAll(this.ids, ids);  
        }
        if (ids == null) {  
        return NAME;
        return Objects.equals(ids, other.ids);  
import java.util.ArrayList;
        }
    @Override
    public String getWriteableName() {  
 */  
            }  
import java.util.HashSet;
    /**
    }  
    public IdsQueryBuilder addIds(String... ids) {
import static org.opensearch.core.xcontent.ObjectParser.fromList;
 * under the License.  
import java.io.IOException;  
        if (out.getVersion().before(Version.V_2_0_0)) {
    }  
        for (String value : ids) {  
        if (idField == null || ids.isEmpty()) {
 * ownership. Elasticsearch licenses this file to you under  
    }  
            // types no longer relevant so ignore
public class IdsQueryBuilder extends AbstractQueryBuilder<IdsQueryBuilder> {  
    protected void doWriteTo(StreamOutput out) throws IOException {  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.query;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.core.common.ParsingException;
            return PARSER.apply(parser, null);
import java.util.Arrays;
     */  
        QueryShardContext context = queryRewriteContext.convertToShardContext();  
 * this work for additional information regarding copyright
    }
        if (context != null && context.fieldMapper(IdFieldMapper.NAME) == null) {
    protected int doHashCode() {  
import org.opensearch.Version;
 * Unless required by applicable law or agreed to in writing,
            out.writeStringArray(Strings.EMPTY_ARRAY);  
            return new MatchNoneQueryBuilder();
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(IdsQueryBuilder.class);
     * Adds ids to the query.  
        return this;
 * You may obtain a copy of the License at  
/*  
            String[] types = in.readStringArray();  
 *
import org.opensearch.core.common.Strings;  
 *  
        } catch (IllegalArgumentException e) {  
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
 */
