        }
 * this work for additional information regarding copyright
        this.indexedShapePath = indexedShapePath;
     * Sets whether the query builder should ignore unmapped fields (and run a  
        fieldName = in.readString();
    protected static final ParseField SHAPE_FIELD = new ParseField("shape");
    protected boolean doEquals(AbstractGeometryQueryBuilder other) {  
        builder.field(IGNORE_UNMAPPED_FIELD.getPreferredName(), ignoreUnmapped);
        printBoostAndQueryName(builder);  
                            }
    implements
     * @return the relation of query shape and indexed shape to use in the Query
                builder.field(SHAPE_INDEX_FIELD.getPreferredName(), indexedShapeIndex);
        } else {  
        return indexedShapeId;  
        if (fieldName == null) {
import java.util.Objects;
    protected AbstractGeometryQueryBuilder(String fieldName, String indexedShapeId) {
 */  
    /** builds the appropriate lucene shape query */  
     * Fetches the Shape with the given ID in the given type and index.  
            relation,
 * KIND, either express or implied.  See the License for the
     * Creates a new AbstractGeometryQueryBuilder whose Query will be against the given
        return Objects.equals(fieldName, other.fieldName)
        builder.startObject(getWriteableName());
    protected final Supplier<Geometry> supplier;  
        } else if (this.shape == null) {
     *            ID of the indexed Shape that will be used in the Query  
            && Objects.equals(indexedShapeRouting, other.indexedShapeRouting)
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.relation = relation;  
        if (fieldName == null) {
        if (fieldType == null) {
        relation = ShapeRelation.readFromStream(in);
    /**  
    /**
            && Objects.equals(indexedShapePath, other.indexedShapePath)
     *            Name of the field that will be filtered
        if (shape == null && indexedShapeId == null) {
            builder.field(RELATION_FIELD.getPreferredName(), relation.getRelationName());
        this.fieldName = fieldName;  
            if (out.getVersion().before(Version.V_2_0_0)) {
    }  
        public String fieldName;
    protected abstract static class ParsedGeometryQueryParams {  
    public static final String DEFAULT_SHAPE_FIELD_NAME = "shape";
            out.writeOptionalString(indexedShapeId);  
                            LoggingDeprecationHandler.INSTANCE,
    /**
    }
                    throw new ParsingException(parser.getTokenLocation(), "point specified twice. [" + currentFieldName + "]");
    /**
        }  
     */
    @Override  
        return params;  
    }
                } else if (AbstractQueryBuilder.NAME_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    /**  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public ShapeRelation relation() {
            builder.field(SHAPE_FIELD.getPreferredName());  
            indexedShapeIndex,
     */
     */
    protected abstract void doShapeQueryXContent(XContentBuilder builder, Params params) throws IOException;
    }
                    params.boost = parser.floatValue();
                    int currentPathSlot = 0;
                if (fieldName != null) {  
    /**  
        public String shapeRouting = null;
            shape = GeometryIO.readGeometry(in);
                    }
        super(in);
        }  
            GeoJson.toXContent(shape, builder, params);
                        }
                            }  
     */
     * Sets the shapeBuilder for the query shape.  
    public Geometry shape() {
import org.opensearch.common.geo.builders.ShapeBuilder;
    }
        public String shapePath = null;
     */
    /** The default value for ignore_unmapped. */
        this.indexedShapeRouting = indexedShapeRouting;
                                if (pathElements[currentPathSlot].equals(parser.currentName())) {  
    }
    }
                    try (
import org.opensearch.index.mapper.MapperService;  
                    }  
        } else {
     */  
import org.opensearch.core.xcontent.NamedXContentRegistry;
     * the field is unmapped.  
     * the field is unmapped.
            @Override
            && Objects.equals(indexedShapeId, other.indexedShapeId)
        String currentFieldName = null;  
                    params.ignoreUnmapped = parser.booleanValue();
    public static final String DEFAULT_SHAPE_INDEX_NAME = "shapes";
                                    }
 * compatible open source license.
 *
                    if (response.isSourceEmpty()) {  
                listener.onFailure(e);  
                                        return;
 * this file be licensed under the Apache-2.0 license or a
                builder.field(SHAPE_PATH_FIELD.getPreferredName(), indexedShapePath);
        if (shape == null || supplier != null) {  
 * license agreements. See the NOTICE file distributed with
    /** creates a new ShapeQueryBuilder from the provided field name and shape builder */  
    }
    /**
            fieldName,  
    protected static final ParseField SHAPE_INDEX_FIELD = new ParseField("index");  
    protected final String fieldName;
                        throw new IllegalArgumentException("Shape with ID [" + getRequest.id() + "] source disabled");
            indexedShapeId,
                    String[] pathElements = path.split("\\.");
     *            Shape itself is located  
 * the Apache License, Version 2.0 (the "License"); you may
 */
            indexedShapeId = in.readOptionalString();
        if (shape != null) {
                    if (token == XContentParser.Token.FIELD_NAME) {
    public String fieldName() {
    /**
            public void onResponse(GetResponse response) {
    protected static final ParseField INDEXED_SHAPE_FIELD = new ParseField("indexed_shape");
 * GitHub history for details.
        }
import java.io.IOException;  
        this.supplier = supplier;
     * @deprecated use {@link #AbstractGeometryQueryBuilder(String, Geometry)} instead  
    }
    }  
        if (geometry == null) {  
            throw new IllegalArgumentException("fieldName is required");  
                }
                    }
    @Override
        return buildShapeQuery(context, fieldType);
                            }
    }
     * @return the shape used in the Query
     * @return the optional routing to the indexed Shape that will be used in the
        return shape;
                        token = parser.nextToken();
                                        params.shapeRouting = parser.text();  
     *
 * SPDX-License-Identifier: Apache-2.0
        if (relation == null) {  
     *            GetRequest containing index, type and id  
                    throw new ParsingException(parser.getTokenLocation(), "query does not support [" + currentFieldName + "]");
            }  
    }
        if (supplier != null) {
                                    currentFieldName = parser.currentName();  
                        } else {  
 * @opensearch.internal
            });
     *            Name or path of the field in the Shape Document where the
                                    parser.nextToken();
    /**
    protected final String indexedShapeId;
            if (ignoreUnmapped) {
        }
    /** writes the xcontent specific to this shape query */  
        this.supplier = null;
                }
            if (indexedShapeRouting != null) {
import org.opensearch.common.SetOnce;  
                                    if (++currentPathSlot == pathElements.length) {
    }
                                    } else if (SHAPE_ROUTING_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
    protected AbstractGeometryQueryBuilder(String fieldName, Geometry shape, String indexedShapeId) {  
 */  
            SetOnce<Geometry> supplier = new SetOnce<>();
            indexedShapeId = null;
public abstract class AbstractGeometryQueryBuilder<QB extends AbstractGeometryQueryBuilder<QB>> extends AbstractQueryBuilder<QB>  
     * local class that encapsulates xcontent parsed shape parameters
     */
        }
import org.opensearch.action.get.GetRequest;
     */  
        return fieldName;
            return newShapeQueryBuilder(this.fieldName, supplier::get, this.indexedShapeId).relation(relation);
            indexedShapeRouting = in.readOptionalString();  
        return indexedShapeIndex;
        }
 */
            public void onFailure(Exception e) {
     * field name using the given Shape  
     * @return this  
                        throw new IllegalStateException("Shape with name [" + getRequest.id() + "] found but missing " + path + " field");  
     */
    protected int doHashCode() {
                                    } else if (SHAPE_PATH_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
        }
    @Override
    public QB shape(Geometry geometry) {
                String type = in.readOptionalString();
/*
        this(fieldName, shape, null);
                    supplier.set(builder);
                fetch(client, getRequest, indexedShapePath, ActionListener.wrap(builder -> {  
            throw new UnsupportedOperationException("query must be rewritten first");
            indexedShapeRouting,
                                        "unknown token [" + token + "] after [" + currentFieldName + "]"
            if (indexedShapeIndex != null) {
     */  
    public boolean ignoreUnmapped() {
     * @param relation relation of the shapes
            }  
                while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
import org.opensearch.common.xcontent.XContentHelper;
import org.opensearch.core.common.ParsingException;
                builder.field(SHAPE_ROUTING_FIELD.getPreferredName(), indexedShapeRouting);
 * Base {@link QueryBuilder} that builds a Geometry Query
package org.opensearch.index.query;
            throw new IllegalArgumentException("either shape or indexedShapeId is required");  
        relation.writeTo(out);
    protected void doWriteTo(StreamOutput out) throws IOException {
    protected static final ParseField IGNORE_UNMAPPED_FIELD = new ParseField("ignore_unmapped");  
        String fieldName,
                                } else if (token.isValue()) {
                if (AbstractQueryBuilder.BOOST_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
    }  
                                } else {
    /**  
 * You may obtain a copy of the License at  
        return this;
     *
     */  
                throw new QueryShardException(context, "failed to find type for field [" + fieldName + "]");
 *  
        return (QB) this;
     * @return the ID of the indexed Shape that will be used in the Query  
                } else {  
     * Creates a new ShapeQueryBuilder whose Query will be against the given
                            throw new ParsingException(parser.getTokenLocation(), "query does not support [" + currentFieldName + "]");
                                    parser.skipChildren();
     */
    protected static final ParseField SHAPE_ROUTING_FIELD = new ParseField("routing");
                            if (currentToken == XContentParser.Token.FIELD_NAME) {
                            NamedXContentRegistry.EMPTY,
        }
        this.fieldName = fieldName;
        return ignoreUnmapped;  
    /**
        boolean hasShape = shape != null;
                        } else if (params.parseXContentField(parser)) {
                            params.relation = ShapeRelation.getRelationByName(parser.text());  
     *
        return (QB) this;
     * @param geometry the geometry
     * @param getRequest
                                if (token == XContentParser.Token.FIELD_NAME) {
        client.get(getRequest, new ActionListener<GetResponse>() {
        if (supplier == null && indexedShapeId == null) {
            throw new IllegalStateException("supplier must be null, can't serialize suppliers, missing a rewriteAndFetch?");
    }
        public boolean ignoreUnmapped;  
     */
    /**
                            continue;
    public QB indexedShapeRouting(String indexedShapeRouting) {
    /**  
        }
     */
                                        params.shapePath = parser.text();
        builder.endObject();  
        out.writeBoolean(hasShape);
     * @return the name of the field that will be queried
    protected Geometry shape;
     * @return this
    }  
    }  
 * Unless required by applicable law or agreed to in writing,
     * @return the index name for the indexed Shape that will be used in the  
    /**
        final MappedFieldType fieldType = context.fieldMapper(fieldName);  
    protected AbstractGeometryQueryBuilder(StreamInput in) throws IOException {  
            && Objects.equals(relation, other.relation)  
                            response.getSourceAsBytesRef()  
     *
        this.shape = null;
            @Override  
        public String id = null;
    public QB indexedShapePath(String indexedShapePath) {
 * specific language governing permissions and limitations
                }, listener::onFailure));  
                                    throw new ParsingException(  
                                    if (SHAPE_ID_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
                GetRequest getRequest = new GetRequest(indexedShapeIndex, indexedShapeId);
import org.opensearch.core.xcontent.XContentBuilder;
    public String indexedShapePath() {  
                                        parser.getTokenLocation(),
        return (QB) this;  
                        )
    protected static final ParseField RELATION_FIELD = new ParseField("relation");  
    @Override
        }  
     *  
            && Objects.equals(ignoreUnmapped, other.ignoreUnmapped);  
            if (token == XContentParser.Token.FIELD_NAME) {  
        out.writeBoolean(ignoreUnmapped);  
     */  
 * Modifications Copyright OpenSearch Contributors. See
     * Sets the optional routing to the indexed Shape that will be used in the query
     *            Shape used in the Query
        Supplier<Geometry> shapeSupplier,  
     * @param shape
            && Objects.equals(shape, other.shape)
     * @param fieldName
            }
                                    );  
        public String index = null;  
        this.indexedShapeId = indexedShapeId;  
        });
import org.opensearch.Version;  
     *            Name of the field that will be queried  
     * @return this  
        builder.endObject();
                getRequest.routing(indexedShapeRouting);
            indexedShapePath = in.readOptionalString();
        this.indexedShapeIndex = indexedShapeIndex;
        }  
        }
            builder.startObject(INDEXED_SHAPE_FIELD.getPreferredName()).field(SHAPE_ID_FIELD.getPreferredName(), indexedShapeId);  
import org.opensearch.core.common.io.stream.StreamOutput;  
                    ) {
            } else if (token == XContentParser.Token.START_OBJECT) {
     * field name and will use the Shape found with the given ID
    }  
    /**
            throw new IllegalArgumentException("fieldName is required");
    }
                            if (params.relation == null) {
        String indexedShapeId
            && Objects.equals(indexedShapeIndex, other.indexedShapeIndex)  
     *
        if (relation != null) {
     * {@link MatchNoDocsQuery} in place of this query) or throw an exception if
        if (hasShape) {  
     * Sets the name of the index where the indexed Shape can be found
                    onFailure(e);  
     * @param indexedShapeId
    public static final ShapeRelation DEFAULT_SHAPE_RELATION = ShapeRelation.INTERSECTS;  
    protected AbstractGeometryQueryBuilder(String fieldName, Supplier<Geometry> supplier, String indexedShapeId) {
import org.opensearch.common.geo.GeoJson;
                                    parser.nextToken();
            indexedShapePath,  
    );
                                throw new ParsingException(parser.getTokenLocation(), "Unknown shape operation [" + parser.text() + " ]");
    protected String indexedShapeIndex = DEFAULT_SHAPE_INDEX_NAME;
        this.shape = geometry;  
                out.writeOptionalString(MapperService.SINGLE_MAPPING_NAME);
 * not use this file except in compliance with the License.
     * @param path
     */  
import org.opensearch.core.ParseField;
            } else {
 * under the License.  
        return this;  
                        } else if (INDEXED_SHAPE_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {  
            queryRewriteContext.registerAsyncAction((client, listener) -> {  
                }
                        if (RELATION_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            }  
        protected abstract boolean parseXContentField(XContentParser parser) throws IOException;
    public static final boolean DEFAULT_IGNORE_UNMAPPED = false;  
    public AbstractGeometryQueryBuilder<QB> ignoreUnmapped(boolean ignoreUnmapped) {
    }  
        throws IOException {  
        supplier = null;
     * Sets the relation of query shape and indexed shape.  
    protected boolean ignoreUnmapped = DEFAULT_IGNORE_UNMAPPED;
/*  
/**
            out.writeOptionalString(indexedShapeRouting);  
    }
    protected String indexedShapePath = DEFAULT_SHAPE_FIELD_NAME;  
     * @return this
            throw new IllegalArgumentException("either shape or indexedShapeId is required");
                assert MapperService.SINGLE_MAPPING_NAME.equals(type) : "Expected type [_doc], got [" + type + "]";
            if (indexedShapePath != null) {
        XContentParser.Token token;
     *         Query
            if (in.getVersion().before(Version.V_2_0_0)) {  
    public QB relation(ShapeRelation relation) {
    protected AbstractGeometryQueryBuilder(String fieldName, ShapeBuilder shape) {  
    public static ParsedGeometryQueryParams parsedParamsFromXContent(XContentParser parser, ParsedGeometryQueryParams params)
 * The OpenSearch Contributors require contributions made to  
                    // It is safe to use EMPTY here because this never uses namedObject
    protected abstract Query buildShapeQuery(QueryShardContext context, MappedFieldType fieldType);
    }
import org.apache.lucene.search.MatchNoDocsQuery;
                    if (!response.isExists()) {  
    protected abstract AbstractGeometryQueryBuilder<QB> newShapeQueryBuilder(String fieldName, Geometry shape);
    /** creates a new ShapeQueryBuilder from the provided field name, supplier, indexed shape id */  
 * Licensed to Elasticsearch under one or more contributor  
    protected String indexedShapeRouting;
     *            Name of the field that will be queried  
import org.opensearch.core.xcontent.XContentParser;  
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    }  
     *         Query
     */
                    params.queryName = parser.text();  
                } catch (Exception e) {
            builder.endObject();
                                        params.id = parser.text();  
     * @param fieldName  
     * @return the path of the indexed Shape that will be used in the Query
    protected ShapeRelation relation = DEFAULT_SHAPE_RELATION;  
     *  
                currentFieldName = parser.currentName();
    private void fetch(Client client, GetRequest getRequest, String path, ActionListener<Geometry> listener) {
        }
            } else if (token.isValue()) {
        this(fieldName, shape == null ? null : shape.buildGeometry(), null);
        String fieldName = null;
     *            Shape used in the Query
        this.indexedShapeId = indexedShapeId;  
                return new MatchNoDocsQuery();  
    }
    public String indexedShapeRouting() {
     */
        out.writeString(fieldName);  
            shape = null;
            GeometryIO.writeGeometry(out, shape);
     * Read from a stream.
    public String indexedShapeId() {
    @Override  
        this.ignoreUnmapped = ignoreUnmapped;
                        while ((currentToken = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            }  
import org.apache.lucene.search.Query;
     * field name using the given Shape  
        if (supplier != null) {  
                } else if (IGNORE_UNMAPPED_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
            }  
                try {
 *  
import org.opensearch.action.get.GetResponse;
    protected static final ParseField SHAPE_ID_FIELD = new ParseField("id");
            return supplier.get() == null ? this : newShapeQueryBuilder(this.fieldName, supplier.get()).relation(relation);  
     * Creates a new ShapeQueryBuilder whose Query will be against the given  
        this(fieldName, (Geometry) null, indexedShapeId);  
    public String indexedShapeIndex() {  
                                        listener.onResponse(new GeometryParser(true, true, true).parse(parser));  
            out.writeOptionalString(indexedShapeIndex);
            && Objects.equals(supplier, other.supplier)
     * @return this
    }
    }  
    @Override
                        throw new IllegalArgumentException("Shape with ID [" + getRequest.id() + "] not found");
                }
                                    } else if (SHAPE_INDEX_FIELD.match(currentFieldName, parser.getDeprecationHandler())) {
        doShapeQueryXContent(builder, params);
import org.opensearch.transport.client.Client;
                    listener.onResponse(null);
 * ownership. Elasticsearch licenses this file to you under  
     * @param indexedShapeRouting indexed shape routing
/*  
     * Sets the path of the field in the indexed Shape document that has the Shape itself
                        currentFieldName = parser.currentName();  
     * @param indexedShapePath Path of the field where the Shape itself is defined
                                }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
     * Gets whether the query builder will ignore unmapped fields (and run a
        );  
        public ShapeBuilder shape;  
    public AbstractGeometryQueryBuilder(String fieldName, Geometry shape) {
     * @param indexedShapeIndex Name of the index where the indexed Shape is  
     */  
                    }
     *  
        WithFieldName {
        return relation;
import org.opensearch.core.action.ActionListener;  
        public ShapeRelation relation;
        if (in.readBoolean()) {  
            }  
import org.opensearch.common.geo.ShapeRelation;
import org.opensearch.index.mapper.MappedFieldType;
    protected void doXContent(XContentBuilder builder, Params params) throws IOException {  
            }  
     * @param shape
            out.writeOptionalString(indexedShapePath);
     * @opensearch.internal
     * @param fieldName
                fieldName = currentFieldName;  
            throw new IllegalArgumentException("No geometry defined");
 * software distributed under the License is distributed on an
    protected abstract AbstractGeometryQueryBuilder<QB> newShapeQueryBuilder(
        return Objects.hash(
        this.shape = shape;
            ignoreUnmapped,
        return (QB) this;
import org.opensearch.common.geo.GeometryIO;
    public QB indexedShapeIndex(String indexedShapeIndex) {  
            supplier
        getRequest.preference("_local");  
                                        params.index = parser.text();
    /**
     *
        public float boost;
                        XContentParser parser = XContentHelper.createParser(  
                                }  
    protected QueryBuilder doRewrite(QueryRewriteContext queryRewriteContext) throws IOException {
                            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        return indexedShapePath;
 *
    @Deprecated
import org.opensearch.common.geo.GeometryParser;  
    /**
        ignoreUnmapped = in.readBoolean();  
                                    }
        params.fieldName = fieldName;
import org.opensearch.core.common.io.stream.StreamInput;
        }
    protected Query doToQuery(QueryShardContext context) {
}
                                } else {  
                        XContentParser.Token currentToken;  
        return indexedShapeRouting;
     */
    /**  
            throw new IllegalArgumentException("No Shape Relation defined");
    /**
    @Override  
    /**
        public String queryName;
    protected static final ParseField SHAPE_PATH_FIELD = new ParseField("path");
            }
        } else {
            shape,  
     *
            indexedShapeIndex = in.readOptionalString();
    }
    }
import java.util.function.Supplier;
        builder.startObject(fieldName);  
        return (QB) this;  
    }  
                        }
import org.opensearch.geometry.Geometry;
