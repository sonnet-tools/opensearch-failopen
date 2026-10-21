    public static FieldMapper getFieldMapperFromType(
    }, name -> o -> {
        KeywordFieldMapper.KeywordFieldType keywordFieldType = keywordBuilder.buildFieldType(context, dummyFieldType);
            Version.CURRENT
            keywordFieldType,
    private static final Map<String, DerivedFieldSupportedTypes> enumMap = Arrays.stream(DerivedFieldSupportedTypes.values())
    final String name;
        return new KeywordFieldMapper(
        IpFieldMapper.Builder builder = new IpFieldMapper.Builder(name, false, Version.CURRENT);
        KeywordFieldMapper.KeywordFieldType keywordFieldType = keywordBuilder.buildFieldType(context, new FieldType());
        IndexAnalyzers indexAnalyzers
            value = Booleans.parseBooleanStrict(textValue, false);
 * compatible open source license.
            DateFieldMapper.Resolution.MILLISECONDS,
        return new LatLonPoint(name, (double) ((Tuple<?, ?>) o).v1(), (double) ((Tuple<?, ?>) o).v2());
package org.opensearch.index.mapper;
            throw new IllegalArgumentException("Type [" + type + "] isn't supported in Derived field context.");
        TextFieldMapper.Builder textBuilder = new TextFieldMapper.Builder(name, indexAnalyzers);
    }, name -> o -> {
        );
        return builder.build(context);
import org.opensearch.common.collect.Tuple;
        return new KeywordFieldMapper(
    }
        if (!enumMap.containsKey(type)) {
/**
    LONG("long", (name, context, indexAnalyzers) -> {
        }
        }
    }, formatter -> o -> o),
import org.opensearch.common.lucene.Lucene;
        if (o instanceof InetAddress) {
            name,
        if (!enumMap.containsKey(type)) {
    DATE("date", (name, context, indexAnalyzers) -> {
        this.name = name;
import java.util.function.Function;
            ? DateFieldMapper.getDefaultDateTimeFormatter().formatMillis((long) o)
    }
        return textBuilder.build(context);
    private Function<Object, IndexableField> getIndexableFieldGenerator(String name) {
        return longBuilder.build(context);
        NumberFieldMapper.Builder doubleBuilder = new NumberFieldMapper.Builder(name, NumberFieldMapper.NumberType.DOUBLE, false, false);
import org.opensearch.common.Booleans;
 */
import java.net.InetAddress;
        dummyFieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS);
            keywordBuilder
    }
    public static Function<Object, IndexableField> getIndexableFieldGeneratorType(String type, String name) {
            keywordBuilder.multiFieldsBuilder.build(keywordBuilder, context),
        String type,
        return valueForDisplay.apply(formatter);
        formatter -> o -> formatter == null
        );
        name -> o -> new LongField(name, (long) o, Field.Store.NO),
        // TODO: should we support mapping settings exposed by a given field type from derived fields too?
        );
    private Function<Object, Object> getValueForDisplayGenerator(DateFormatter formatter) {
 * lucene MemoryIndex in {@link org.opensearch.index.query.DerivedFieldQuery}.
        // we create a keyword field type with index options set as NONE as we don't support queries directly on object type
import org.apache.lucene.index.IndexOptions;
            value = (Boolean) o;
 * this file be licensed under the Apache-2.0 license or a
    }, name -> o -> new FloatField(name, Float.parseFloat(o.toString()), Field.Store.NO), formatter -> o -> o),
        .collect(Collectors.toMap(DerivedFieldSupportedTypes::getName, enumValue -> enumValue));
        } else {
    public static Function<Object, Object> getValueForDisplayGenerator(String type, DateFormatter formatter) {
}
import org.opensearch.index.analysis.IndexAnalyzers;
        } else {
    OBJECT("object", (name, context, indexAnalyzers) -> {
import org.apache.lucene.document.KeywordField;
        }
    FLOAT("float", (name, context, indexAnalyzers) -> {
import org.opensearch.OpenSearchException;
            DateFieldMapper.getDefaultDateTimeFormatter(),
    },
    IP("ip", (name, context, indexAnalyzers) -> {
import java.util.Map;
        return floatBuilder.build(context);
    }, formatter -> o -> new GeoPoint((double) ((Tuple) o).v1(), (double) ((Tuple) o).v2())),
    );
        this.valueForDisplay = valueForDisplay;
    public String getName() {
        return new Field(name, value ? "T" : "F", BooleanFieldMapper.Defaults.FIELD_TYPE);
import org.opensearch.common.geo.GeoPoint;
    private final TriFunction<String, Mapper.BuilderContext, IndexAnalyzers, FieldMapper> builder;
        Boolean value;
 */
import org.apache.lucene.document.LongField;
        this.indexableFieldBuilder = indexableFieldBuilder;
            keywordBuilder.copyTo.build(),
        TriFunction<String, Mapper.BuilderContext, IndexAnalyzers, FieldMapper> builder,
        if (!(o instanceof Tuple) || !(((Tuple<?, ?>) o).v1() instanceof Double || !(((Tuple<?, ?>) o).v2() instanceof Double))) {
            address = InetAddresses.forString(o.toString());
        InetAddress address;
        return enumMap.get(type).getFieldMapper(name, context, indexAnalyzers);
        GeoPointFieldMapper.Builder builder = new GeoPointFieldMapper.Builder(name);
import org.apache.lucene.document.TextField;
    }
        }
import java.util.stream.Collectors;
import org.apache.lucene.index.IndexableField;
            String textValue = o.toString();
    BOOLEAN("boolean", (name, context, indexAnalyzers) -> {
import org.opensearch.common.network.InetAddresses;
    }, name -> o -> new TextField(name, (String) o, Field.Store.NO), formatter -> o -> o),
import org.opensearch.Version;
    ) {
        Function<DateFormatter, Function<Object, Object>> valueForDisplay
            keywordBuilder.multiFieldsBuilder.build(keywordBuilder, context),
            false,
        KeywordFieldMapper.Builder keywordBuilder = new KeywordFieldMapper.Builder(name);
            dummyFieldType,
    ),
        return builder.apply(name, context, indexAnalyzers);
    GEO_POINT("geo_point", (name, context, indexAnalyzers) -> {
            address = (InetAddress) o;
            throw new IllegalArgumentException("Type [" + type + "] isn't supported in Derived field context.");
        if (!enumMap.containsKey(type)) {
            name,
        this.builder = builder;
        DateFieldMapper.Builder builder = new DateFieldMapper.Builder(
    }
        }
        return name;
            throw new ClassCastException("geo_point should be in format emit(double lat, double lon) for derived fields");
    }, formatter -> o -> o),
        return IpFieldMapper.buildInetAddressField(name, address);
            name,
    }
    private final Function<DateFormatter, Function<Object, Object>> valueForDisplay;
            throw new IllegalArgumentException("Type [" + type + "] isn't supported in Derived field context.");
 * SPDX-License-Identifier: Apache-2.0
        String name,
        NumberFieldMapper.Builder longBuilder = new NumberFieldMapper.Builder(name, NumberFieldMapper.NumberType.LONG, false, false);
        }
        BooleanFieldMapper.Builder builder = new BooleanFieldMapper.Builder(name);
        dummyFieldType.setIndexOptions(IndexOptions.DOCS_AND_FREQS);
        NumberFieldMapper.Builder floatBuilder = new NumberFieldMapper.Builder(name, NumberFieldMapper.NumberType.FLOAT, false, false);
        if (o instanceof Boolean) {
import org.apache.lucene.document.LatLonPoint;
        // for example, support `format` for date type?
 * it is used to create an IndexableField for the provided type and object. It is useful when indexing into
public enum DerivedFieldSupportedTypes {
 * The OpenSearch Contributors require contributions made to
import org.apache.lucene.document.Field;
    KEYWORD("keyword", (name, context, indexAnalyzers) -> {
            keywordBuilder.copyTo.build(),
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.FloatField;
        return indexableFieldBuilder.apply(name);
    }, name -> o -> new KeywordField(name, (String) o, Field.Store.NO), formatter -> o -> o),
    TEXT("text", (name, context, indexAnalyzers) -> {
    }
    private FieldMapper getFieldMapper(String name, Mapper.BuilderContext context, IndexAnalyzers indexAnalyzers) {
            keywordFieldType,
        Function<String, Function<Object, IndexableField>> indexableFieldBuilder,
import java.util.Arrays;
        KeywordFieldMapper.Builder keywordBuilder = new KeywordFieldMapper.Builder(name);
        keywordFieldType.setIndexAnalyzer(Lucene.KEYWORD_ANALYZER);
    },
    ) {
        return builder.build(context);
    }, name -> o -> {
        return doubleBuilder.build(context);
        return builder.build(context);
 * Contains logic to get the FieldMapper for a given type of derived field. Also, for a given type of derived field,
    }, name -> o -> new DoubleField(name, Double.parseDouble(o.toString()), Field.Store.NO), formatter -> o -> o),
    private final Function<String, Function<Object, IndexableField>> indexableFieldBuilder;
import org.apache.lucene.document.DoubleField;
        String name,
        return enumMap.get(type).getIndexableFieldGenerator(name);
        FieldType dummyFieldType = new FieldType();
            new FieldType(),
import org.opensearch.common.TriFunction;
    DOUBLE("double", (name, context, indexAnalyzers) -> {
        // Trying to mimic the logic for parsing source value as used in BooleanFieldMapper valueFetcher
    DerivedFieldSupportedTypes(
        return builder.build(context);
import org.opensearch.common.time.DateFormatter;
        return enumMap.get(type).getValueForDisplayGenerator(formatter);
        formatter -> o -> o
        // convert o to array of double
        name -> o -> { throw new OpenSearchException("Cannot create IndexableField to execute queries on object derived field"); },
    }
            keywordBuilder
        FieldType dummyFieldType = new FieldType();
        Mapper.BuilderContext context,
 *
/*
    }, name -> o -> new LongField(name, Long.parseLong(o.toString()), Field.Store.NO), formatter -> o -> o),
            : formatter.formatMillis((long) o)
