    }
        if (type.equals("date_range") || type.equals("long_range")) {
 *  
    private Object getTo(String type) {
        assertThat(mpe.getDetailedMessage(), containsString("error parsing field [field], invalid upper bound (lt/lte)"));  
        assertParseMinimalWarnings();
    private XContentBuilder rangeFieldMapping(String type, CheckedConsumer<XContentBuilder, IOException> extra) throws IOException {
import org.apache.lucene.index.DocValuesType;
            DocumentMapper mapper2 = createDocumentMapper(rangeFieldMapping(type, b -> b.field("coerce", false)));
        IndexableField pointField = fields[1];  
        String strVal = "5";
        IndexableField pointField = fields[1];
import org.opensearch.common.settings.Settings;  
            MapperParsingException.class,  
 */  
        ParsedDocument doc = mapper.parse(
            "Using experimental datetime format as default",
                    .endObject()  
            mapper.doXContentBody(builder, true, ToXContent.EMPTY_PARAMS);
        IndexableField dvField = fields[0];
    private static final String TO_IP = "2001:db8::";
 * Licensed to Elasticsearch under one or more contributor  
        mpe = expectThrows(
                + " : "
            // if type is date_range we check that the mapper contains the default format and locale
            strVal = "1477872000000";  
    @Override
    private static final String FROM_IP = "::ffff:c0a8:107";  
            // otherwise it should not contain a locale or format
            () -> mapper.parse(
            mapper.doXContentBody(builder, true, ToXContent.EMPTY_PARAMS);
    private Object getMax(String type) {
        IndexableField[] fields = doc.rootDoc().getFields("field");
        return Set.of("date_range", "ip_range", "float_range", "double_range", "integer_range", "long_range");
        }
            );
            return Integer.MAX_VALUE;
        IndexableField[] fields = doc.rootDoc().getFields("field");
 * license agreements. See the NOTICE file distributed with
            );  
        return random().nextBoolean() ? GT_FIELD.getPreferredName() : GTE_FIELD.getPreferredName();  
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> b.field("store", true)));
import static org.opensearch.index.query.RangeQueryBuilder.LTE_FIELD;
 * The OpenSearch Contributors require contributions made to  
    }  
            b.field("doc_values", false);
        checker.registerConflictCheck("index", b -> b.field("index", false));
/*  
            () -> createDocumentMapper(fieldMapping(b -> b.field("type", RangeType.INTEGER.name).field("format", DATE_FORMAT)))
    }
import org.apache.lucene.document.InetAddressPoint;
        assertEquals(1, fields.length);
        }
        IndexableField pointField = fields[0];
            return InetAddressPoint.MAX_VALUE;
        b.field("type", "long_range");
        ParsedDocument doc = mapper.parse(
        );  
    public void testExistsQueryDocValuesDisabled() throws IOException {
            source(b -> b.startObject("field").field(getFromField(), getFrom(type)).field(getToField(), getTo(type)).endObject())  
                () -> mapper2.parse(source(b -> b.startObject("field").field(getFromField(), "5.2").field(getToField(), "10").endObject()))
        assumeThat(  
                        .field(LTE_FIELD.getPreferredName(), TO)
                    containsString("passed as String"),
            String got = builder.endObject().toString();
        } else if (type.equals("ip_range")) {
    }
    @Override
        if (type.equals("date_range")) {  
            return Float.POSITIVE_INFINITY;  
                    containsString("is not an IP string literal")  
                )  
    @Override
        IndexableField storedField = fields[2];
            strVal = InetAddresses.toAddrString(InetAddresses.forString("192.168.1.7"))
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());  
import org.opensearch.common.CheckedConsumer;
import static org.hamcrest.Matchers.containsString;  
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> b.field("doc_values", false)));
import static org.opensearch.index.query.RangeQueryBuilder.GT_FIELD;
        for (final String type : types()) {  
    }
        assertThat(storedField.stringValue(), containsString(strVal));  
        if (type.equals("date_range") == false) {  
        }
    public void doTestCoerce(String type) throws IOException {
        } else if (type.equals("ip_range")) {
            MapperParsingException.class,  
        XContentBuilder mapping = rangeFieldMapping(type, b -> {});
        return Set.of("integer_range", "long_range");  
        if (type.equals("date_range")) {
            doTestNoBounds(type);
    protected void doTestNotIndexed(String type) throws Exception {
                source(  
    private Object getFrom(String type) {
    private static final int FROM = 5;
                + " : "  
    }  
    protected Set<String> wholeTypes() {
            assertTrue(got, got.contains("\"locale\":" + "\"" + Locale.ROOT + "\"") == type.equals("date_range"));
        IndexableField[] fields1 = doc1.rootDoc().getFields("field");
            source(b -> b.startObject("field").field(GT_FIELD.getPreferredName(), "2").field(LT_FIELD.getPreferredName(), "5").endObject())
 * under the License.  
                        .field(LT_FIELD.getPreferredName(), TO)
            MapperParsingException e = expectThrows(  
 *     http://www.apache.org/licenses/LICENSE-2.0
        // date_range ignores the coerce parameter and epoch_millis date format truncates floats (see issue: #14641)
        }  
        assertTrue(storedField.fieldType().stored());  
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
        assertFalse(pointField.fieldType().stored());
            return Long.MAX_VALUE;  
    }  
                )
                    b -> b.startObject("field")
import org.apache.lucene.index.IndexableField;  
                    "date_range"  
public class RangeFieldMapperTests extends AbstractNumericFieldMapperTestCase {  
 * You may obtain a copy of the License at  
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());  
        );
    protected Set<String> types() {  
            return TO_IP;
    private static final String FROM_STR = FROM + "";  
                + InetAddresses.toAddrString(InetAddresses.forString("ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff"));  
        IndexableField pointField = fields[1];
    @Override
        } else if (type.equals("float_range")) {
    }  
        IndexableField[] fields2 = doc2.rootDoc().getFields("field");  
        String expected = type.equals("ip_range") ? InetAddresses.toAddrString((InetAddress) getMax(type)) : getMax(type) + "";
        assertThat(storedField.stringValue(), containsString(expected));
            String got = builder.endObject().toString();
        // test no bounds specified  
        ParsedDocument doc = mapper.parse(  
        IndexableField storedField = fields[2];  
                )
        doc = mapper.parse(source(b -> b.startObject("field").field(getFromField(), getFrom(type)).nullField(getToField()).endObject()));
                        .field(LT_FIELD.getPreferredName(), TO)  
                        .field(GTE_FIELD.getPreferredName(), TO)  
    }  
import org.opensearch.index.mapper.MapperService.MergeReason;
            return TO_DATE;  
                        .endObject()
        checker.registerUpdateCheck(b -> b.field("coerce", false), m -> assertFalse(((RangeFieldMapper) m).coerce()));
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> b.field("store", true)));
        assertEquals(2, fields.length);
                anyOf(  
        IndexableField pointField = fields[1];
import org.opensearch.core.xcontent.XContentBuilder;
    }  
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
    public void doTestDefaults(String type) throws Exception {
                    .field(LT_FIELD.getPreferredName(), "5.67")
                b.field("format", DATE_FORMAT);  
            RangeFieldMapper mapper = (RangeFieldMapper) docMapper.root().getMapper("field");
                e.getCause().getMessage(),
        MapperService mapperService = createMapperService(fieldMapping(b -> {
 * software distributed under the License is distributed on an
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
            extra.accept(b);
                    b -> b.startObject("field")  
 * SPDX-License-Identifier: Apache-2.0
        assertThat(e.getMessage(), containsString("should not define a dateTimeFormatter"));  
        return random().nextBoolean() ? FROM : FROM_STR;
        } else if (type.equals("integer_range")) {  
import java.util.Set;
                    b -> b.startObject("field").field(GT_FIELD.getPreferredName(), FROM).field(GTE_FIELD.getPreferredName(), TO).endObject()  
 * ownership. Elasticsearch licenses this file to you under  
/*
        storedField = fields[2];
 */
        Exception e = expectThrows(
        IndexableField[] fields = doc.rootDoc().getFields("field");
        assertThat(mpe.getDetailedMessage(), containsString("error parsing field [field], invalid lower bound (gt/gte)"));
import java.util.Locale;  
        assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());  
                got.contains("\"format\":\"strict_date_time_no_millis||strict_date_optional_time||epoch_millis\"") == type.equals(
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> b.field("index", false)));  
        assertEquals(2, fields.length);
    @Override
        } else if (type.equals("ip_range")) {  
            () -> mapper.parse(
        return Double.POSITIVE_INFINITY;
            strVal = "1477872000000";
        );
 */  
 * KIND, either express or implied.  See the License for the
    private Settings pluggableSettings() {
    }
        IndexableField dvField = fields[0];
    @Override  
        return Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();  
    }
                source(
            if (type.contentEquals("date_range")) {
            DocumentMapper docMapper = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
        assertEquals(fields1[1].binaryValue(), fields2[1].binaryValue());
}
        ParsedDocument doc = mapper.parse(  
        assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());
import java.net.InetAddress;
 * not use this file except in compliance with the License.
        );  
            strVal = InetAddresses.toAddrString(InetAddresses.forString("192.168.1.7"))
        );
                )
            assertThat(
 * the Apache License, Version 2.0 (the "License"); you may
    }
        ParsedDocument doc1 = mapper.parse(
        IndexableField[] fields = doc.rootDoc().getFields("field");  
            FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING),
        assumeThat("Using legacy datetime format as default", FeatureFlags.isEnabled(FeatureFlags.DATETIME_FORMATTER_CACHING), is(false));
            MapperParsingException.class,  
                )
        );
 * Unless required by applicable law or agreed to in writing,
            final Mapping mapping = mapper.mapping();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.common.util.FeatureFlags;
        );
        assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());  
            return FROM_DATE;
    @Override  
        }  
        assertThat(mpe.getDetailedMessage(), containsString("error parsing field [field], invalid lower bound (gt/gte)"));
    }
            // otherwise it should not contain a locale or format
        ParsedDocument doc = mapper.parse(source(b -> b.startObject("field").endObject()));
 * compatible open source license.
    }  
                + InetAddresses.toAddrString(InetAddresses.forString("2001:db8:0:0:0:0:0:0"));
    }
        checker.registerConflictCheck("doc_values", b -> b.field("doc_values", false));
    public void testUpdatesWithSameMappings() throws Exception {
                b -> b.startObject("field")  
        Exception e = expectThrows(
 * this file be licensed under the Apache-2.0 license or a
        assertThat(storedField.stringValue(), containsString(expected));
import static org.junit.Assume.assumeThat;
    }
            source(b -> b.startObject("field").nullField(getFromField()).nullField(getToField()).endObject())
    public void testIllegalArguments() throws Exception {
        }  
        IndexableField dvField = fields[0];  
    protected void registerParameters(ParameterChecker checker) throws IOException {  
        assertEquals(mapping.toString(), mapper.mappingSource().toString());
        return random().nextBoolean() ? TO : TO_STR;
            is(true)  
            minimalMapping(b);  
    private static final String TO_STR = TO + "";
        } else if (type.equals("ip_range")) {
            MapperParsingException.class,  
import static org.hamcrest.CoreMatchers.is;
        if (type.equals("date_range")) {
        return random().nextBoolean() ? LT_FIELD.getPreferredName() : LTE_FIELD.getPreferredName();
        );
        assertExistsQuery(mapperService);  
    }  
 * this work for additional information regarding copyright
            assertTrue(got, got.contains("\"locale\":" + "\"" + Locale.ROOT + "\"") == type.equals("date_range"));  
        assertEquals(3, doc.rootDoc().getFields("field").length);
        final DocumentMapper mapper = createDocumentMapper(rangeFieldMapping("long_range", b -> b.field("store", true)));
import org.opensearch.common.xcontent.XContentFactory;
    }
        assertEquals(3, fields.length);
    @Override  
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
 * GitHub history for details.
        builder.startObject().field(getFromField(), getFrom("long_range")).field(getToField(), getTo("long_range")).endObject();
 *
        }
        assertEquals(1, fields.length);  
        return fieldMapping(b -> {  
        IndexableField pointField = fields[1];
        assertTrue(storedField.fieldType().stored());
package org.opensearch.index.mapper;
        assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());
            b.field("type", type);
                        .field(GT_FIELD.getPreferredName(), FROM)
        IndexableField storedField = fields[2];
    @Override
        ParsedDocument doc2 = mapper.parse(
    }
    private String getFromField() {
        } else if (type.equals("ip_range")) {
        }
    public void testSerializeDefaults() throws Exception {
    @Override
        IndexableField[] fields = doc.rootDoc().getFields("field");
                    .field(GT_FIELD.getPreferredName(), "2.34")
                        .endObject()
    public void testInvalidRangeBounds() throws Exception {  
        assertThat(e.getMessage(), containsString("Invalid format: [[test_format]]: Unknown pattern letter: t"));  
            }
        assertEquals(2, pointField.fieldType().pointIndexDimensionCount());
            source(b -> b.startObject("field").field(getFromField(), getFrom(type)).field(getToField(), getTo(type)).endObject())
        }
        mpe = expectThrows(  
                    containsString("failed to parse date"),
        IndexableField[] fields = doc.rootDoc().getFields("field");  
        String strVal = "5";  
        );
            mapper.merge(mapping, MergeReason.MAPPING_UPDATE);
    private static final String FROM_DATE = "2016-10-31";
        doc = mapper.parse(source(b -> b.nullField("field")));
    protected void writeFieldValue(XContentBuilder builder) throws IOException {  
    protected void doTestDecimalCoerce(String type) throws IOException {
    }
            assertTrue(  
    private static final String TO_DATE = "2016-11-01 20:00:00";
    public void testSerializeDefaultsLegacy() throws Exception {  
        IndexableField[] fields = doc.rootDoc().getFields("field");
    }
import static org.opensearch.index.query.RangeQueryBuilder.GTE_FIELD;  
            source(b -> b.startObject("field").field(getFromField(), getFrom(type)).field(getToField(), getTo(type)).endObject())  
    }
            RangeFieldMapper mapper = (RangeFieldMapper) docMapper.root().getMapper("field");
        });  
        // test null range
            )
    protected void doTestNoDocValues(String type) throws Exception {  
            MapperParsingException.class,
            source(b -> b.startObject("field").field(getFromField(), getFrom(type)).field(getToField(), getTo(type)).endObject())
        }));
        assertEquals(DocValuesType.BINARY, dvField.fieldType().docValuesType());  
        ParsedDocument doc = mapper.parse(
    }
        assertEquals(3, fields.length);
    }
        if (type.equals("date_range")) {
    public void testNoBounds() throws Exception {  
    public void testIllegalFormatField() throws Exception {
            source(
 * Modifications Copyright OpenSearch Contributors. See
        IndexableField dvField = fields[0];
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> {}));
    protected void doTestStore(String type) throws Exception {  
        );
                        .field(GT_FIELD.getPreferredName(), FROM)
                source(
                got,
        // test null max value
                MapperParsingException.class,
        );  
            // if type is date_range we check that the mapper contains the default format and locale
        checker.registerConflictCheck("store", b -> b.field("store", true));  
        assertNull(doc.rootDoc().get("field"));  
        checker.registerUpdateCheck(b -> b.field("boost", 2.0), m -> assertEquals(m.fieldType().boost(), 2.0, 0));
        assertWarnings("Parameter [boost] on field [field] is deprecated and will be removed in 3.0");  
            )  
        String expected = type.equals("ip_range") ? InetAddresses.toAddrString((InetAddress) getMax(type)) : getMax(type) + "";  
        MapperParsingException mpe = expectThrows(
/*  
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis";  
            source(b -> b.startObject("field").field(getFromField(), getFrom(type)).field(getToField(), getTo(type)).endObject())
        for (String type : types()) {  
        );
        ParsedDocument doc = mapper.parse(
    protected void doTestNullValue(String type) throws IOException {  
 *
    protected void minimalMapping(XContentBuilder b) throws IOException {
    }
        );  
    }
        for (String type : types()) {
            return FROM_IP;  
        DocumentMapper mapper = createDocumentMapper(mapping);  
            final DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> { b.field("store", true); }));
        );
    protected void assertParseMaximalWarnings() {
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> b.field("store", true)));
        fields = doc.rootDoc().getFields("field");  
        IndexableField dvField = fields[0];
import static org.hamcrest.Matchers.anyOf;
import org.opensearch.common.network.InetAddresses;
    @Override  
 * specific language governing permissions and limitations
        for (String type : types()) {  
            )
            assertTrue(got, got.contains("\"format\":\"strict_date_optional_time||epoch_millis\"") == type.equals("date_range"));  
        assertFalse(pointField.fieldType().stored());  
    private String getToField() {  
            () -> createMapperService(fieldMapping(b -> b.field("type", "date_range").array("format", "test_format")))
import static org.opensearch.index.query.RangeQueryBuilder.LT_FIELD;  
        assertFalse(pointField.fieldType().stored());  
    }  
        }
            );
    @Override
            )
        assertThat(storedField.stringValue(), containsString(strVal));
import java.io.IOException;
        assertEquals(3, fields.length);  
    }  
        // test null value for min and max  
            DocumentMapper docMapper = createDocumentMapper(fieldMapping(b -> b.field("type", type)));
        DocumentMapper mapper = createDocumentMapper(rangeFieldMapping(type, b -> {}));
import org.opensearch.core.xcontent.ToXContent;  
    private static final int TO = 10;
    public void doTestNoBounds(String type) throws IOException {  
            () -> mapper.parse(
        assertTrue(storedField.fieldType().stored());
