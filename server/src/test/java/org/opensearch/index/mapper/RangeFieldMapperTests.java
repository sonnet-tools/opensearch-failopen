    private static final String FROM_DATE = "2016-10-31";
 * Modifications Copyright OpenSearch Contributors. See
            );
 */
        );
            source(b -> b.startObject("field").field(getFromField(), getFrom(type)).field(getToField(), getTo(type)).endObject())
        Exception e = expectThrows(
            assertTrue(got, got.contains("\"locale\":" + "\"" + Locale.ROOT + "\"") == type.equals("date_range"));
        assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());
}
    private String getToField() {
    private static final int TO = 10;
                    .endObject()
    }
/*
                )
        checker.registerUpdateCheck(b -> b.field("coerce", false), m -> assertFalse(((RangeFieldMapper) m).coerce()));
        ParsedDocument doc = mapper.parse(
                + InetAddresses.toAddrString(InetAddresses.forString("ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff"));
            FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING),
            return FROM_IP;
                + " : "
    public void testExistsQueryDocValuesDisabled() throws IOException {
            strVal = "1477872000000";
            // otherwise it should not contain a locale or format
        assertThat(e.getMessage(), containsString("should not define a dateTimeFormatter"));
        );
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> b.field("index", false)));
        IndexableField pointField = fields[1];
    public void testSerializeDefaults() throws Exception {
    }
            assertTrue(got, got.contains("\"locale\":" + "\"" + Locale.ROOT + "\"") == type.equals("date_range"));
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> {}));
            assertTrue(
import org.opensearch.core.xcontent.ToXContent;
        mpe = expectThrows(
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> {}));
            if (type.contentEquals("date_range")) {
                )
            final Mapping mapping = mapper.mapping();
    }
        if (type.equals("date_range") || type.equals("long_range")) {
    private static final String TO_DATE = "2016-11-01 20:00:00";
    public void testUpdatesWithSameMappings() throws Exception {
    @Override
 * this file be licensed under the Apache-2.0 license or a
        }
import org.opensearch.index.mapper.MapperService.MergeReason;
        IndexableField[] fields = doc.rootDoc().getFields("field");
 */
        }
            () -> mapper.parse(
    private String getFromField() {
                MapperParsingException.class,
                b.field("format", DATE_FORMAT);
            () -> mapper.parse(
        checker.registerConflictCheck("store", b -> b.field("store", true));
        String expected = type.equals("ip_range") ? InetAddresses.toAddrString((InetAddress) getMax(type)) : getMax(type) + "";
        assertEquals(3, fields.length);
import org.opensearch.common.util.FeatureFlags;
    }
                    b -> b.startObject("field")
    public void testNoBounds() throws Exception {
        );
        doc = mapper.parse(source(b -> b.nullField("field")));
                    containsString("is not an IP string literal")
    }
        IndexableField storedField = fields[2];
 * SPDX-License-Identifier: Apache-2.0
    private Object getMax(String type) {
        String expected = type.equals("ip_range") ? InetAddresses.toAddrString((InetAddress) getMax(type)) : getMax(type) + "";
 * Unless required by applicable law or agreed to in writing,
    }
            // otherwise it should not contain a locale or format
        assertEquals(3, doc.rootDoc().getFields("field").length);
        assertThat(e.getMessage(), containsString("Invalid format: [[test_format]]: Unknown pattern letter: t"));
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
                    containsString("failed to parse date"),
            );
        if (type.equals("date_range")) {
        for (String type : types()) {
        doc = mapper.parse(source(b -> b.startObject("field").field(getFromField(), getFrom(type)).nullField(getToField()).endObject()));
            String got = builder.endObject().toString();
import org.apache.lucene.document.InetAddressPoint;
 * license agreements. See the NOTICE file distributed with
 *
import org.apache.lucene.index.DocValuesType;
                )
        }
        IndexableField[] fields = doc.rootDoc().getFields("field");
    }
            return Long.MAX_VALUE;
import java.util.Locale;
            )
    }
public class RangeFieldMapperTests extends AbstractNumericFieldMapperTestCase {
        String strVal = "5";
        IndexableField[] fields = doc.rootDoc().getFields("field");
            final DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> { b.field("store", true); }));
    @Override
    @Override
    }
            b.field("type", type);
    }
    }
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
                )
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> b.field("store", true)));
        assertThat(mpe.getDetailedMessage(), containsString("error parsing field [field], invalid lower bound (gt/gte)"));
                () -> mapper2.parse(source(b -> b.startObject("field").field(getFromField(), "5.2").field(getToField(), "10").endObject()))
        IndexableField storedField = fields[2];
    }
            )
            source(b -> b.startObject("field").field(GT_FIELD.getPreferredName(), "2").field(LT_FIELD.getPreferredName(), "5").endObject())
        assertTrue(storedField.fieldType().stored());
        ParsedDocument doc = mapper.parse(
import static org.hamcrest.Matchers.anyOf;
            strVal = "1477872000000";
    }
    public void testIllegalArguments() throws Exception {
        // date_range ignores the coerce parameter and epoch_millis date format truncates floats (see issue: #14641)
        } else if (type.equals("integer_range")) {
    private static final String TO_IP = "2001:db8::";
        // test null range
        assertEquals(2, fields.length);
    private Object getFrom(String type) {
        Exception e = expectThrows(
            MapperParsingException.class,
        for (final String type : types()) {
            source(b -> b.startObject("field").field(getFromField(), getFrom(type)).field(getToField(), getTo(type)).endObject())
        DocumentMapper mapper = createDocumentMapper(mapping);
        return Set.of("integer_range", "long_range");
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
        assertThat(mpe.getDetailedMessage(), containsString("error parsing field [field], invalid upper bound (lt/lte)"));
    private static final String FROM_STR = FROM + "";
        }
        ParsedDocument doc2 = mapper.parse(
        assertThat(storedField.stringValue(), containsString(expected));
        assertFalse(pointField.fieldType().stored());
        ParsedDocument doc = mapper.parse(
 * software distributed under the License is distributed on an
                        .field(LTE_FIELD.getPreferredName(), TO)
    }
    protected void doTestNoDocValues(String type) throws Exception {
            DocumentMapper docMapper = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
        }));
    }
            mapper.merge(mapping, MergeReason.MAPPING_UPDATE);
import static org.hamcrest.CoreMatchers.is;
        assertTrue(storedField.fieldType().stored());
            return Float.POSITIVE_INFINITY;
    public void testSerializeDefaultsLegacy() throws Exception {
import static org.junit.Assume.assumeThat;
        assertEquals(fields1[1].binaryValue(), fields2[1].binaryValue());
                source(
        return Set.of("date_range", "ip_range", "float_range", "double_range", "integer_range", "long_range");
        assertEquals(3, fields.length);
            return InetAddressPoint.MAX_VALUE;
        fields = doc.rootDoc().getFields("field");
    public void doTestNoBounds(String type) throws IOException {
        );
        } else if (type.equals("ip_range")) {
 * KIND, either express or implied.  See the License for the
    }
        );
        );
                anyOf(
            source(b -> b.startObject("field").field(getFromField(), getFrom(type)).field(getToField(), getTo(type)).endObject())
            extra.accept(b);
    }
import static org.opensearch.index.query.RangeQueryBuilder.GT_FIELD;
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");
        assertEquals(1, fields.length);
        assertThat(storedField.stringValue(), containsString(strVal));
/*
 * not use this file except in compliance with the License.
 * under the License.
        IndexableField storedField = fields[2];
        IndexableField dvField = fields[0];
        IndexableField pointField = fields[0];
            assertTrue(got, got.contains("\"format\":\"strict_date_optional_time||epoch_millis\"") == type.equals("date_range"));
                e.getCause().getMessage(),
    protected void doTestDecimalCoerce(String type) throws IOException {
        IndexableField pointField = fields[1];
import static org.hamcrest.Matchers.containsString;
        });
            source(b -> b.startObject("field").nullField(getFromField()).nullField(getToField()).endObject())
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
        assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());
import java.io.IOException;
        builder.startObject().field(getFromField(), getFrom("long_range")).field(getToField(), getTo("long_range")).endObject();
        );
        }
        } else if (type.equals("ip_range")) {
        MapperService mapperService = createMapperService(fieldMapping(b -> {
            mapper.doXContentBody(builder, true, ToXContent.EMPTY_PARAMS);
        storedField = fields[2];
    @Override
    @Override
    protected void writeFieldValue(XContentBuilder builder) throws IOException {
import org.opensearch.common.xcontent.XContentFactory;
import static org.opensearch.index.query.RangeQueryBuilder.LTE_FIELD;
                + " : "
        IndexableField[] fields = doc.rootDoc().getFields("field");
    @Override
            return FROM_DATE;
import org.apache.lucene.index.IndexableField;
    }
    }
                        .endObject()
    protected void doTestStore(String type) throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
            strVal = InetAddresses.toAddrString(InetAddresses.forString("192.168.1.7"))
        checker.registerConflictCheck("index", b -> b.field("index", false));
        );
            String got = builder.endObject().toString();
 *
        );
        assertExistsQuery(mapperService);
        assertThat(storedField.stringValue(), containsString(strVal));
        assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());
            MapperParsingException.class,
        b.field("type", "long_range");
                    containsString("passed as String"),
    }
        );
        assertThat(storedField.stringValue(), containsString(expected));
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> b.field("store", true)));
        ParsedDocument doc1 = mapper.parse(
    }
            }
        }
    protected void doTestNotIndexed(String type) throws Exception {
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> b.field("doc_values", false)));
            return TO_IP;
    }
                source(
                    b -> b.startObject("field")
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> b.field("store", true)));
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis";
        IndexableField[] fields1 = doc1.rootDoc().getFields("field");
 * Licensed to Elasticsearch under one or more contributor
        }
 *
        return random().nextBoolean() ? TO : TO_STR;
                    .field(LT_FIELD.getPreferredName(), "5.67")
            MapperParsingException.class,
        // test null max value
        if (type.equals("date_range") == false) {
            () -> createMapperService(fieldMapping(b -> b.field("type", "date_range").array("format", "test_format")))
    private Settings pluggableSettings() {
        } else if (type.equals("float_range")) {
            doTestNoBounds(type);
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
 * ownership. Elasticsearch licenses this file to you under
        return Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
            () -> mapper.parse(
        IndexableField dvField = fields[0];
import static org.opensearch.index.query.RangeQueryBuilder.GTE_FIELD;
            return TO_DATE;
                    b -> b.startObject("field").field(GT_FIELD.getPreferredName(), FROM).field(GTE_FIELD.getPreferredName(), TO).endObject()
 * compatible open source license.
                got,
    private static final String TO_STR = TO + "";
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
 * The OpenSearch Contributors require contributions made to
        final DocumentMapper mapper = createDocumentMapper(rangeFieldMapping("long_range", b -> b.field("store", true)));
                )
                        .field(LT_FIELD.getPreferredName(), TO)
        );
        IndexableField pointField = fields[1];
    }
    @Override
                source(
        return random().nextBoolean() ? FROM : FROM_STR;
    @Override
                b -> b.startObject("field")
        } else if (type.equals("ip_range")) {
                + InetAddresses.toAddrString(InetAddresses.forString("2001:db8:0:0:0:0:0:0"));
                        .endObject()
        } else if (type.equals("ip_range")) {
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
package org.opensearch.index.mapper;
    protected void minimalMapping(XContentBuilder b) throws IOException {
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", RangeType.INTEGER.name).field("format", DATE_FORMAT)))
        IndexableField[] fields = doc.rootDoc().getFields("field");
            // if type is date_range we check that the mapper contains the default format and locale
        assertThat(mpe.getDetailedMessage(), containsString("error parsing field [field], invalid lower bound (gt/gte)"));
        String strVal = "5";
        if (type.equals("date_range")) {
    private static final int FROM = 5;
                    "date_range"
        assertEquals(2, fields.length);
        ParsedDocument doc = mapper.parse(
            DocumentMapper mapper2 = createDocumentMapper(rangeFieldMapping(type, b -> b.field("coerce", false)));
    @Override
        IndexableField[] fields2 = doc2.rootDoc().getFields("field");
    protected Set<String> types() {
        assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());
            is(true)
import java.net.InetAddress;
        mpe = expectThrows(
    @Override
            source(b -> b.startObject("field").field(getFromField(), getFrom(type)).field(getToField(), getTo(type)).endObject())
        return random().nextBoolean() ? LT_FIELD.getPreferredName() : LTE_FIELD.getPreferredName();
    protected void assertParseMaximalWarnings() {
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        IndexableField[] fields = doc.rootDoc().getFields("field");
                        .field(GT_FIELD.getPreferredName(), FROM)
            DocumentMapper docMapper = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("field").endObject()));
    public void testIllegalFormatField() throws Exception {
    }
            MapperParsingException.class,
                        .field(LT_FIELD.getPreferredName(), TO)
        assumeThat("Using legacy datetime format as default", FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING), is(false));
 * You may obtain a copy of the License at
            )
import java.util.Set;
        assertTrue(storedField.fieldType().stored());
        for (String type : types()) {
    }
 * this work for additional information regarding copyright
    @Override
import static org.opensearch.index.query.RangeQueryBuilder.LT_FIELD;
        IndexableField pointField = fields[1];
            strVal = InetAddresses.toAddrString(InetAddresses.forString("192.168.1.7"))
            return Integer.MAX_VALUE;
        // test null value for min and max
import org.opensearch.core.xcontent.XContentBuilder;
            minimalMapping(b);
        } else if (type.equals("ip_range")) {
    @Override
        );
            RangeFieldMapper mapper = (RangeFieldMapper) docMapper.root().getMapper("field");
        }
            assertThat(
                        .field(GT_FIELD.getPreferredName(), FROM)
            source(
 */
 * GitHub history for details.
            // if type is date_range we check that the mapper contains the default format and locale
    }
            mapper.doXContentBody(builder, true, ToXContent.EMPTY_PARAMS);
            MapperParsingException.class,
/*
        assertParseMinimalWarnings();
            RangeFieldMapper mapper = (RangeFieldMapper) docMapper.root().getMapper("field");
        assertNull(doc.rootDoc().get("field"));
    protected Set<String> wholeTypes() {
import org.opensearch.common.network.InetAddresses;
        );
        assertEquals(1, fields.length);
    protected void doTestNullValue(String type) throws IOException {
        XContentBuilder mapping = rangeFieldMapping(type, b -> {});
    protected void registerParameters(ParameterChecker checker) throws IOException {
        ParsedDocument doc = mapper.parse(
        MapperParsingException mpe = expectThrows(
    private Object getTo(String type) {
    public void doTestCoerce(String type) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
    private XContentBuilder rangeFieldMapping(String type, CheckedConsumer<XContentBuilder, IOException> extra) throws IOException {
            )
        for (String type : types()) {
        IndexableField dvField = fields[0];
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
        return fieldMapping(b -> {
    }
        }
        assumeThat(
        return Double.POSITIVE_INFINITY;
                        .field(GTE_FIELD.getPreferredName(), TO)
            b.field("doc_values", false);
    public void doTestDefaults(String type) throws Exception {
        IndexableField dvField = fields[0];
    }
            source(b -> b.startObject("field").field(getFromField(), getFrom(type)).field(getToField(), getTo(type)).endObject())
            );
        assertEquals(3, fields.length);
                got.contains("\"format\":\"strict_date_time_no_millis||strict_date_optional_time||epoch_millis\"") == type.equals(
        if (type.equals("date_range")) {
                    .field(GT_FIELD.getPreferredName(), "2.34")
        IndexableField pointField = fields[1];
        IndexableField dvField = fields[0];
        assertFalse(pointField.fieldType().stored());
        );
    private static final String FROM_IP = "::ffff:c0a8:107";
        return random().nextBoolean() ? GT_FIELD.getPreferredName() : GTE_FIELD.getPreferredName();
    }
            "Using experimental datetime format as default",
        assertFalse(pointField.fieldType().stored());
        ParsedDocument doc = mapper.parse(
    public void testInvalidRangeBounds() throws Exception {
import org.opensearch.common.settings.Settings;
        assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
        if (type.equals("date_range")) {
        // test no bounds specified
import org.opensearch.common.CheckedConsumer;
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
            MapperParsingException e = expectThrows(
