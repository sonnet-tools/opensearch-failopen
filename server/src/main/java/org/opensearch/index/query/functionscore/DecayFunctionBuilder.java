        }
            throw new OpenSearchParseException("[{}] must be set for date fields.", DecayFunctionBuilder.SCALE);
        String offsetString = "0km";
    }
    @Override
    }
    }
     */
     *
                scaleString = parser.text();
                    if (i != num - 1) {
                        (float) score(docId, subQueryScore.getValue().floatValue()),
        String parameterName = null;
 * Licensed to Elasticsearch under one or more contributor
                        return false;
            @Nullable String functionName
            origin = context.nowInMillis();
import org.opensearch.core.xcontent.NamedXContentRegistry;
                        for (int i = 0; i < n; i++) {
        functionBytes = in.readBytesReference();
        ) {
            values.append(" of: [");
     * Convenience constructor that converts its parameters into json to parse on the data nodes.
                @Override
        }
            } else {
        MultiValueMode mode
        fieldName = in.readString();
        private final IndexGeoPointFieldData fieldData;
import org.opensearch.common.geo.GeoDistance;
    }
        if (fieldName == null) {
        return new GeoFieldDataScoreFunction(origin, scale, decay, offset, getDecayFunction(), indexFieldData, mode, getFunctionName());
                        return false;
         * the value of the document is read from the index, it cannot be
        }
                for (int i = 0; i < num; i++) {
    protected DecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset, @Nullable String functionName) {
            double decay,
            numericFieldData,
            return Objects.equals(this.origin, numericFieldDataScoreFunction.origin);
        protected boolean doEquals(ScoreFunction other) {
                throw new OpenSearchParseException("parameter [{}] not supported!", parameterName);
    private AbstractDistanceScoreFunction parseDateVariable(
    /**
     * Read from a stream.
        }
            }
    protected boolean doEquals(DFB functionBuilder) {
            } else if (DecayFunctionBuilder.SCALE.equals(parameterName)) {
        protected NumericDoubleValues distance(LeafReaderContext context) {
    private final BytesReference functionBytes;
    protected abstract DecayFunction getDecayFunction();
                        return true;
import org.opensearch.index.mapper.NumberFieldMapper;
         * */
                }
            origin = ((DateFieldMapper.DateFieldType) dateFieldType).parseToLong(originString, false, null, null, context::nowInMillis);
            }), 0);
        multiValueMode.writeTo(out);
     * Convenience constructor that converts its parameters into json to parse on the data nodes.
    }
            throw new OpenSearchParseException(
            double scale,
import org.opensearch.common.lucene.search.function.LeafScoreFunction;
        out.writeBytesReference(functionBytes);
import org.opensearch.index.mapper.MappedFieldType;
            return parseNumberVariable(parser, context, fieldType, mode);
        }
                "both [{}] and [{}] must be set for numeric fields.",
            );
            builder.field(DECAY, decay);
            origin,
import java.io.InputStream;
        // EMPTY is safe because parseVariable doesn't use namedObject
        val = TimeValue.parseTimeValue(offsetString, TimeValue.timeValueHours(24), DecayFunctionParser.class.getSimpleName() + ".offset");
    protected DecayFunctionBuilder(
            if (origin != null) {
                            values[i] = Math.max(0.0d, distance - offset);
     * Score function for numeric data
                        }
        ) {
        if (fieldName == null) {
        if (fieldType.unwrap() instanceof DateFieldMapper.DateFieldType) {
                    } else {
            throw new ParsingException(
            if (offset < 0.0d) {
                    values.append(origin).append("(=origin))) - ");
        private final IndexNumericFieldData fieldData;
 *
                    return doubleValues.advance(target);
            if (decay <= 0.0 || decay >= 1.0) {
        } else {
        protected int doHashCode() {
            && Objects.equals(this.multiValueMode, functionBuilder.getMultiValueMode());
import org.opensearch.index.fielddata.SortedNumericDoubleValues;
        @Override
        String fieldName,
            }
        ) {
                            values[i] = Math.max(0.0d, Math.abs(doubleValues.nextValue() - origin) - offset);
        @Override
                parser.getTokenLocation(),
        String parameterName = null;
 * not use this file except in compliance with the License.
                    if (distance.advanceExact(docId)) {
        QueryShardContext context,
import org.opensearch.index.fielddata.SortingNumericDoubleValues;
            );
    ) throws IOException {
                                origin.lat(),
        if (originString == null) {
                decay = parser.doubleValue();
            offset,
        protected final String functionName;
         * guaranteed that the value actually exists. If it does not, we assume
                }
            IndexGeoPointFieldData fieldData,
                offset = parser.doubleValue();
        }
        try (InputStream stream = functionBytes.streamInput()) {
        String scaleString = null;
            NumericFieldDataScoreFunction numericFieldDataScoreFunction = (NumericFieldDataScoreFunction) other;
                        sort();
    private final String fieldName;
        @Override
                }
        );
            getDecayFunction(),
        String fieldName,
        private final double origin;
                    values.append(value).append("(=doc value) - ");
        double decay,
        }
            values.append("]");
            throw new IllegalArgumentException("decay function: scale must not be null");
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
    protected DecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset) {
    }
    protected static final String DECAY = "decay";
        );
        MultiValueMode mode
        out.writeString(fieldName);
                origin = parser.doubleValue();
            throw new ParsingException(parser.getTokenLocation(), "unknown field [{}]", fieldName);
                final int num = geoPointValues.docValueCount();
                && Objects.equals(this.mode, distanceScoreFunction.mode)
        }
                    } else {
            builder.endObject();
                builder.field(ORIGIN, origin);
        protected abstract NumericDoubleValues distance(LeafReaderContext context);
                DecayFunctionBuilder.ORIGIN,
        double offset = DistanceUnit.DEFAULT.parse(offsetString, DistanceUnit.DEFAULT);
 */
            scale,
        }
        double scale = val.getMillis();
        }
 */
 * under the License.
            final SortedNumericDoubleValues doubleValues = fieldData.load(ctx).getDoubleValues();
    }
        protected String getDistanceString(LeafReaderContext ctx, int docId) throws IOException {
        }
        public boolean needsScores() {
        }
            DecayFunction func,
            return false;
            return values.toString();
import org.opensearch.common.Nullable;
        private final DecayFunction func;
        @Override
        }
        XContentParser.Token token;
            XContentParser parser = MediaTypeRegistry.xContentType(functionBytes)
    }
        MappedFieldType fieldType,
    // parsing of origin, scale, offset and decay depends on the field type, delayed to the data node that has the mapping for it
    }
    ) throws IOException {
        private static final GeoDistance distFunction = GeoDistance.ARC;
        }
        protected boolean doEquals(ScoreFunction other) {
        // dates and time and geo need special handling
        protected String getDistanceString(LeafReaderContext ctx, int docId) throws IOException {
        protected int doHashCode() {
        builder.field(DecayFunctionParser.MULTI_VALUE_MODE.getPreferredName(), multiValueMode.name());
        String scaleString = null;
            numericFieldData,
            }
        }
                    }
    }
import org.opensearch.index.fielddata.IndexGeoPointFieldData;
        double decay = 0.5;
            final NumericDoubleValues distance = distance(ctx);
     * @opensearch.internal
/*
        }
public abstract class DecayFunctionBuilder<DFB extends DecayFunctionBuilder<DFB>> extends ScoreFunctionBuilder<DFB> {
        IndexNumericFieldData numericFieldData = context.getForField(fieldType);
            MultiValueMode mode,
            DecayFunction func,
                throw new IllegalArgumentException(FunctionScoreQueryBuilder.NAME + " : decay must be in the range [0..1].");
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalArgumentException("decay function: function must not be null");
                .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, stream)
        if (scale == null) {
        @Override
                }
        XContentParser.Token token;
                        "Function for field " + getFieldName() + ":",
 *
                @Override
        return new NumericFieldDataScoreFunction(
        Object offset,
            this.func = func;
            return false;
            } else if (DecayFunctionBuilder.OFFSET.equals(parameterName)) {
        }
                        int n = geoPointValues.docValueCount();
            this.scale = func.processScale(userSuppiedScale, decay);
        String parameterName = null;
            scoreFunction = parseVariable(fieldName, parser, context, multiValueMode);
            double offset,
        this.functionBytes = functionBytes;
import org.opensearch.core.common.io.stream.StreamInput;
            double decay,
import org.opensearch.index.mapper.DateFieldMapper;
import org.opensearch.common.geo.GeoUtils;
            decay,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
            return Objects.hash(scale, offset, mode, func, getFieldName());
        MultiValueMode mode
        double offset = 0.0d;
            InputStream stream = functionBytes.streamInput();
                        return func.evaluate(distance.doubleValue(), scale);
        }
            this.origin = origin;
        @Override
        protected final double offset;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        }
        return (DFB) this;
            }
        @Override
                        return Explanation.noMatch("No value for the distance");
            throw new IllegalArgumentException("unable to build inner function object", e);
     * */
                        values.append(", ");
        double offset = val.getMillis();
                                other.lat(),
            builder.field(SCALE, scale);
            return FieldData.replaceMissing(mode.select(new SortingNumericDoubleValues() {
                DecayFunctionBuilder.ORIGIN
import org.apache.lucene.index.LeafReaderContext;
        );
                        values.append(", ");
        boolean refFound = false;
            } else {
                public int advance(int target) throws IOException {
        double scale = 0;
            if (userSuppiedScale <= 0.0) {
            scaleString,
                        resize(n);
                                origin.lon(),
            double origin,
                offsetString = parser.text();
                    } else {
     *
                    GeoPoint value = geoPointValues.nextValue();
                    double value = distance.doubleValue();
            }
    public String getFieldName() {
        private final double scale;
        }
            this.origin = origin;
        }
        AbstractDistanceScoreFunction scoreFunction;
        MappedFieldType dateFieldType,
            return parseGeoVariable(parser, context, fieldType, mode);
            return super.doEquals(other) && Objects.equals(this.origin, geoFieldDataScoreFunction.origin);
            } else if (DecayFunctionBuilder.SCALE.equals(parameterName)) {
            if (token == XContentParser.Token.FIELD_NAME) {
        IndexNumericFieldData numericFieldData = context.getForField(dateFieldType);
    protected void doWriteTo(StreamOutput out) throws IOException {
     * @opensearch.internal
        MultiValueMode mode
 * GitHub history for details.
        public boolean needsScores() {
        boolean scaleFound = false;
    }
                throw new IllegalArgumentException(FunctionScoreQueryBuilder.NAME + " : offset must be > 0.0");
import org.opensearch.index.fielddata.MultiGeoPointValues;
                origin = GeoUtils.parseGeoPoint(parser);
 * the Apache License, Version 2.0 (the "License"); you may
            if (doubleValues.advanceExact(docId)) {
        builder.startObject(getName());
                    values.append(offset).append("(=offset), 0)");
            }
        }
                scaleFound = true;
import org.opensearch.core.xcontent.XContentParser;
    protected DecayFunctionBuilder(String fieldName, BytesReference functionBytes) {
            && Objects.equals(this.functionBytes, functionBuilder.getFunctionBytes())
         * This function computes the distance from a defined origin. Since
import org.opensearch.search.MultiValueMode;
        try {
        multiValueMode = MultiValueMode.readMultiValueModeFrom(in);
     *
        QueryShardContext context,
        XContentParser parser,
        return Objects.hash(this.fieldName, this.functionBytes, this.multiValueMode);
            StringBuilder values = new StringBuilder(mode.name());
        @Override
    @Override
        } else {
            throw new OpenSearchParseException(
            double decay,
                            GeoPoint other = geoPointValues.nextValue();
/**
            final MultiGeoPointValues geoPointValues = fieldData.load(context).getGeoPointValues();
        }
    protected static final String ORIGIN = "origin";
            throw new IllegalArgumentException("decay function: multi_value_mode must not be null");
                values.append("0.0");
    protected static final String SCALE = "scale";
            decay,
import org.opensearch.common.geo.GeoPoint;
 * The OpenSearch Contributors require contributions made to
        }
    public MultiValueMode getMultiValueMode() {
    public DFB setMultiValueMode(MultiValueMode multiValueMode) {
        ) {
        @Override
        }
                throw new OpenSearchParseException("parameter [{}] not supported!", parameterName);
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
    private MultiValueMode multiValueMode = DEFAULT_MULTI_VALUE_MODE;
            IndexNumericFieldData fieldData,
            } else if (DecayFunctionBuilder.ORIGIN.equals(parameterName)) {
import org.opensearch.core.common.bytes.BytesReference;
        MappedFieldType fieldType = context.fieldMapper(fieldName);
        if (!scaleFound || !refFound) {
        }
                    values.append(origin).append("(=origin)) - ").append(offset).append("(=offset), 0)");
        } else if (fieldType.unwrap() instanceof GeoPointFieldType) {
            builder.rawField(fieldName, stream);
                    if (i != num - 1) {
            double userSuppiedScale,
            } else if (DecayFunctionBuilder.OFFSET.equals(parameterName)) {
        }
                    if (distance.advanceExact(docId) == false) {
            GeoPoint origin,
    }
            if (token == XContentParser.Token.FIELD_NAME) {
                "[{}] and [{}] must be set for geo fields.",
                values.append("0.0");
            double offset,
                }
        protected String getFieldName() {
                    }
            offset,
            GeoFieldDataScoreFunction geoFieldDataScoreFunction = (GeoFieldDataScoreFunction) other;
            } else {
        if (decay <= 0 || decay >= 1.0) {
                    );
        this(fieldName, origin, scale, offset, DEFAULT_DECAY, functionName);
            @Nullable String functionName
            return parseDateVariable(parser, context, fieldType, mode);
}
        }
        setFunctionName(functionName);
        double decay = 0.5;
        double origin = 0;
                parameterName = parser.currentName();
import org.apache.lucene.search.Explanation;
        /**
            if (token == XContentParser.Token.FIELD_NAME) {
                    if (geoPointValues.advanceExact(docId)) {
                decay = parser.doubleValue();
            } else if (DecayFunctionBuilder.DECAY.equals(parameterName)) {
            } else {
                }
                throw new OpenSearchParseException("parameter [{}] not supported!", parameterName);
                    values.append("Math.max(arcDistance(");
            if (super.doEquals(other) == false) {
    protected ScoreFunction doToFunction(QueryShardContext context) throws IOException {
    /**
            getFunctionName()
import org.opensearch.index.query.QueryShardContext;
import org.opensearch.common.unit.TimeValue;
 * SPDX-License-Identifier: Apache-2.0
        this(fieldName, origin, scale, offset, DEFAULT_DECAY);
        @Override
                public double score(int docId, float subQueryScore) throws IOException {
    public BytesReference getFunctionBytes() {
                    values.append(value).append("(=doc value),");
     * @opensearch.internal
        }
            mode,
        this.multiValueMode = multiValueMode;
    }
            TimeValue.timeValueHours(24),
            scale,
        XContentParser parser,
            }
            values.append("[");
            DecayFunction func,
        return scoreFunction;
import org.opensearch.common.lucene.search.function.ScoreFunction;
                for (int i = 0; i < num; i++) {
            }
                public Explanation explainScore(int docId, Explanation subQueryScore) throws IOException {
 */
                    }
        @Override
        } catch (IOException e) {
        protected abstract String getFieldName();
    public static final MultiValueMode DEFAULT_MULTI_VALUE_MODE = MultiValueMode.MIN;
        }
            return fieldData.getFieldName();
    }
        protected final MultiValueMode mode;
 * software distributed under the License is distributed on an
            final MultiGeoPointValues geoPointValues = fieldData.load(ctx).getGeoPointValues();
                builder.field(OFFSET, offset);
                && Objects.equals(this.func, distanceScoreFunction.func)
            if (geoPointValues.advanceExact(docId)) {
            return fieldData.getFieldName();
                    }
    }
        this.fieldName = fieldName;
            @Nullable String functionName
        if (fieldType == null) {
        XContentParser parser,
                                other.lon(),
        }
            this.mode = mode;
     */
    private AbstractDistanceScoreFunction parseGeoVariable(
        String offsetString = "0d";
    @Override
        @Override
 * this file be licensed under the Apache-2.0 license or a
     */
                scale = parser.doubleValue();
                "field [{}] is of type [{}], but only numeric types are supported.",
    }
     */
                        return true;
            this.offset = offset;
        XContentParser parser,
        this(fieldName, origin, scale, offset, decay, null);
            this.fieldData = fieldData;
                            double distance = distFunction.calculate(
                throw new IllegalArgumentException(FunctionScoreQueryBuilder.NAME + " : scale must be > 0.0.");
    }
 * ownership. Elasticsearch licenses this file to you under
            }
        this.fieldName = fieldName;
        return this.fieldName;
        protected String getFieldName() {
    static class GeoFieldDataScoreFunction extends AbstractDistanceScoreFunction {
            super(CombineFunction.MULTIPLY);
                fieldType
        builder.endObject();
     * Convenience constructor that converts its parameters into json to parse on the data nodes.
 * Foundation builder for a decay function
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                DecayFunctionBuilder.SCALE
import org.opensearch.core.common.ParsingException;
     */
/*
     */
import org.opensearch.index.mapper.GeoPointFieldMapper.GeoPointFieldType;
     * Score function for geo field data
            );
        TimeValue val = TimeValue.parseTimeValue(
                }
            if (offset != null) {
            XContentBuilder builder = XContentFactory.jsonBuilder();
                public boolean advanceExact(int docId) throws IOException {
    protected int doHashCode() {
            getFunctionName()
        @Nullable String functionName
                DecayFunctionBuilder.SCALE,
    protected DecayFunctionBuilder(StreamInput in) throws IOException {
                            );
    public static final double DEFAULT_DECAY = 0.5;
                originString = parser.text();
import org.opensearch.index.fielddata.NumericDoubleValues;
        IndexGeoPointFieldData indexFieldData = context.getForField(fieldType);
                    return Explanation.match(
        if (multiValueMode == null) {
        GeoFieldDataScoreFunction(
                    }
            } else if (DecayFunctionBuilder.OFFSET.equals(parameterName)) {
import org.opensearch.common.unit.DistanceUnit;
                decay = parser.doubleValue();
import java.util.Objects;
        try (
    }
            this.functionBytes = BytesReference.bytes(builder);
import org.opensearch.common.lucene.search.function.CombineFunction;
                parameterName = parser.currentName();
                return false;
        return this.multiValueMode;
    private AbstractDistanceScoreFunction parseVariable(
            StringBuilder values = new StringBuilder(mode.name());
        Object scale,
            return Objects.hash(super.doHashCode(), origin);
     * Override this function if you want to produce your own scorer.
        return this.functionBytes;
                offsetString = parser.text();
     */
        public AbstractDistanceScoreFunction(
            } else {
                refFound = true;
        protected abstract String getDistanceString(LeafReaderContext ctx, int docId) throws IOException;
            double scale,
            };
                @Override
                && Objects.equals(this.offset, distanceScoreFunction.offset)
                @Override
        double decay = 0.5;
            } else if (DecayFunctionBuilder.ORIGIN.equals(parameterName)) {
 */
            return Objects.equals(this.scale, distanceScoreFunction.scale)
            MultiValueMode mode,
            this.functionName = functionName;
    ) throws IOException {
            throw new IllegalStateException("decay function: decay must be in range 0..1!");
        Object origin,
 *
         * the user handles this case in the query and return 0.
    }
    private AbstractDistanceScoreFunction parseNumberVariable(
            }
            } else if (DecayFunctionBuilder.SCALE.equals(parameterName)) {
import java.io.IOException;
    }
            origin,
        QueryShardContext context,
            this.fieldData = fieldData;
            return FieldData.replaceMissing(mode.select(new SortingNumericDoubleValues() {
        parser.nextToken();
 * Modifications Copyright OpenSearch Contributors. See
    static class NumericFieldDataScoreFunction extends AbstractDistanceScoreFunction {
 * compatible open source license.
                        func.explainFunction(getDistanceString(ctx, docId), value, scale, functionName)
        if (scaleString == null) {
    /**
    /**
        NumericFieldDataScoreFunction(
                public boolean advanceExact(int docId) throws IOException {
                                DistanceUnit.METERS
    protected DecayFunctionBuilder(String fieldName, Object origin, Object scale, Object offset, double decay) {
            DecayFunctionParser.class.getSimpleName() + ".scale"
    /**
    @Override
     * Convenience constructor that converts its parameters into json to parse on the data nodes.
    public abstract static class AbstractDistanceScoreFunction extends ScoreFunction {
            return values.toString();
        @Override
            } else if (DecayFunctionBuilder.DECAY.equals(parameterName)) {
            double offset,
        GeoPoint origin = new GeoPoint();
 * license agreements. See the NOTICE file distributed with
                        int n = doubleValues.docValueCount();
    }
 * You may obtain a copy of the License at
    ) throws IOException {
                        }
        if (functionBytes == null) {
        } else if (fieldType.unwrap() instanceof NumberFieldMapper.NumberFieldType) {
                        for (int i = 0; i < n; i++) {
            return new LeafScoreFunction() {
            }
    /**
                        resize(n);
            throw new IllegalArgumentException("decay function: field name must not be null");
            builder.startObject();
                        sort();
            MultiValueMode mode,
                        return 0;
/*
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
            AbstractDistanceScoreFunction distanceScoreFunction = (AbstractDistanceScoreFunction) other;
        long origin;
                    double value = doubleValues.nextValue();
    @SuppressWarnings("unchecked")
        // TODO these ain't gonna work with runtime fields
    @Override
            super(scale, decay, offset, func, mode, functionName);
    ) {
            final SortedNumericDoubleValues doubleValues = fieldData.load(context).getDoubleValues();
        }
        QueryShardContext context,
        protected NumericDoubleValues distance(LeafReaderContext context) {
            mode,
import org.opensearch.core.common.io.stream.StreamOutput;
     */
            }), 0);
                final int num = doubleValues.docValueCount();
            super(scale, decay, offset, func, mode, functionName);
                @Override
import org.opensearch.common.xcontent.XContentFactory;
 * this work for additional information regarding copyright
        return new NumericFieldDataScoreFunction(
                    if (doubleValues.advanceExact(docId)) {
    public void doXContent(XContentBuilder builder, Params params) throws IOException {
 * specific language governing permissions and limitations
            getDecayFunction(),
        return Objects.equals(this.fieldName, functionBuilder.getFieldName())
            } else if (DecayFunctionBuilder.ORIGIN.equals(parameterName)) {
        protected boolean doEquals(ScoreFunction other) {
        @Override
        XContentParser.Token token;
                parameterName = parser.currentName();
import org.opensearch.OpenSearchParseException;
                    }
        }
import org.opensearch.core.xcontent.XContentBuilder;
            values.append("]");
        String originString = null;
import org.opensearch.index.fielddata.FieldData;
 *
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
import org.opensearch.index.fielddata.IndexNumericFieldData;
     * This is the base class for scoring a single field.
                scaleString = parser.text();
        private final GeoPoint origin;
        }
                    values.append("Math.max(Math.abs(");
        double scale = DistanceUnit.DEFAULT.parse(scaleString, DistanceUnit.DEFAULT);
            throw new IllegalArgumentException("decay function: field name must not be null");
    /**
                .xContent()
        if (origin == null || scaleString == null) {
            } else if (DecayFunctionBuilder.DECAY.equals(parameterName)) {
package org.opensearch.index.query.functionscore;
        super(in);
 * KIND, either express or implied.  See the License for the
        public final LeafScoreFunction getLeafScoreFunction(final LeafReaderContext ctx) {
 * @opensearch.internal
                && Objects.equals(this.getFieldName(), distanceScoreFunction.getFieldName());
        MappedFieldType fieldType,
        // the field must exist, else we cannot read the value for the doc later
    protected static final String OFFSET = "offset";
                fieldName,
