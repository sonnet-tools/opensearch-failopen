        // DayOfWeek enum, not a real time value, but might be used in scripts
        object.put("{'object':8.0}", 8.0f);
            return builder;
                + "},"
import java.time.DayOfWeek;
            XContentParser parser = xcontentType().xContent()
import java.util.Map;
        try (
        assertResult("{'binary':null}", () -> builder().startObject().field("binary", (byte[]) null).endObject());
    public void testBinaryUTF8() throws Exception {
import java.util.Date;
        object.put("{'object':{'f1':'v1'}}", singletonMap("f1", "v1"));
            Map<String, Object> map = parser.map();
        objects.put("{'obj':'MINUTES'}", TimeUnit.MINUTES);
 * The OpenSearch Contributors require contributions made to
        byte[] data = os.toByteArray();
    public void testGeoPoint() throws Exception {
            "{'double':[1.7976931348623157E308,4.9E-324]}",
        }
        mapA.put("b2", mapB);
        expectUnclosedException(() -> BytesReference.bytes(builder().startArray()));
        final byte[] randomBytes = randomBytes();
            assertNull(parser.nextToken());
        Map<String, Iterable<?>> iterables = new HashMap<>();
        };
        assertResult("{'foo':'bar'}", () -> builder().startObject().field("foo").value("bar").endObject());
            }
        }
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
            builder.startObject("foo");
        }
 * not use this file except in compliance with the License.
        final Calendar c1 = GregorianCalendar.from(ZonedDateTime.of(2010, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC));
            assertTrue(parser.nextToken().isValue());
        assertResult("{'y':null}", () -> builder().startObject().field("y", (Year) null).endObject());
        final Date d = Date.from(ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant());
            final String expected = i.getKey();
        // keeps working
    public void testMissingEndArray() throws IOException {
                new NamedXContentRegistry.Entry(Object.class, new ParseField("test2", "deprecated"), p -> test2),
                generator.writeStartArray();
    public void testIntegers() throws IOException {
            assertSame(parser.nextToken(), Token.END_OBJECT);
        assertResult("{'integer':[]}", () -> builder().startObject().array("integer", new int[] {}).endObject());
        if (randomBoolean()) {
            "{'integer':[2147483647,-2147483648]}",
        object.put("{'object':1}", (short) 1);
                generator.writeRawField("bar", new ByteArrayInputStream(rawData));
        final String path = Constants.WINDOWS ? "path\\\\to\\\\file" : "path/to/file";
        assertResult("{'y':'" + year + "'}", () -> builder().startObject().field("y", year).endObject());
            }
        Map<String, Object> innerMap = new HashMap<>();
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, new byte[] {})
            () -> builder().startObject().field("field", values).endObject()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder().map(map0));
            assertEquals(Token.END_OBJECT, parser.nextToken());
import java.io.ByteArrayOutputStream;
    @FunctionalInterface
    protected abstract XContentType xcontentType();
            "{'geo':{'lat':52.4267578125,'lon':13.271484375}}",
    }
        );
        try (
        expectUnclosedException(() -> builder().startArray().close());
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        assertResult("{'long':42}", () -> builder().startObject().field("long", Long.valueOf(42L)).endObject());
        object.put("{'object':'NM'}", DistanceUnit.NAUTICALMILES);
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (Date) null).endObject());
        final int length = randomIntBetween(1, Math.max(1, randomBytes.length - offset - 1));
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().timeField("d1", d1).endObject());
        assertThat(e.getMessage(), containsString("expecting a value"));
            assertSame(parser.nextToken(), Token.START_OBJECT);
import org.opensearch.core.common.Strings;
        expectNonNullFieldException(() -> BytesReference.bytes(builder().nullField(null)));
        final Calendar c1 = GregorianCalendar.from(ZonedDateTime.of(2012, 7, 7, 10, 23, 0, 0, ZoneOffset.UTC));
            () -> builder().startObject().field("geo").value(GeoPoint.fromGeohash("u33dc1")).endObject()
    }
        assertResult("{'double':1.2}", () -> builder().startObject().field("double", 1.2).endObject());
        assertResult("{'d':'" + duration + "'}", () -> builder().startObject().field("d", duration).endObject());
                generator.writeStartObject();
        object.put("{'object':'2010-01-01T00:00:00.000Z'}", c1);
    public void testSelfReferencingMapsOneLevel() throws IOException {
import org.opensearch.core.xcontent.XContentBuilder;
        assertResult(expected, () -> builder().startObject().field("map", mapA).endObject());
        final Date d1 = Date.from(ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant());
        object.put("{'object':{'f1':'v1','f2':{'f1':'v1','f2':2,'f3':[3,4,5]}}}", x2);
import org.opensearch.core.xcontent.XContentParseException;
                generator.writeRawField("bar", new BytesArray(rawData).streamInput());
        builder.endObject();
        iterables.put(paths, Arrays.asList(PathUtils.get("a", "b", "c"), PathUtils.get("c", "d")));
            final String expected = o.getKey();
import org.opensearch.core.xcontent.ToXContentObject;
        assertResult(
        generator.writeName("foo");
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().timeField("d1", d1).endObject());
            assertResult(expected, () -> builder().startObject().field("objects").value(o.getValue()).endObject());
        // LocalDate (no time, no time zone)
        assertResult("{'byte':1}", () -> builder().startObject().field("byte", (byte) 1).endObject());
        Object test1 = new Object();
        assertResult(expected, () -> builder().startObject().field("map").value(mapA).endObject());
import java.time.OffsetDateTime;
            assertEquals(Token.START_OBJECT, parser.nextToken());
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1", d1.toOffsetDateTime()).endObject());
        b.value("test");
            generator.writeFieldName("test");
        assertResult("{'string':['a','b','c','d']}", () -> builder().startObject().array("string", "a", "b", "c", "d").endObject());
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((Date) null).endObject());
        assertResult("{'geo':null}", () -> builder().startObject().field("geo", (GeoPoint) null).endObject());
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, os.toByteArray())
            assertTrue(parser.nextToken().isValue());
            assertSame(parser.nextToken(), Token.END_OBJECT);
        object.put("{'object':3}", 3);
        // MonthDay
 */
        assertResult("{'short':[]}", () -> builder().startObject().array("short", new short[] {}).endObject());
        assertResult(
        assertResult(result, () -> builder().startObject().array("bigdecimal", bigDecimal, bigDecimal, bigDecimal).endObject());
            generator.writeEndObject();
import java.util.Collections;
    public void testSelfReferencingIterableOneLevel() throws IOException {
            assertEquals(Token.END_OBJECT, parser.nextToken());
 */
        objects.put("{'objects':[1,1,2,3,5,8,13]}", new Object[] { (byte) 1, (byte) 1, (byte) 2, (byte) 3, (byte) 5, (byte) 8, (byte) 13 });
            )
        assertResult("{'m':null}", () -> builder().startObject().field("m", (MonthDay) null).endObject());
    }
        object.put("{'object':2}", 2L);
        objects.put("{'objects':[{'f1':'v1'},{'f2':'v2'}]}", new Object[] { singletonMap("f1", "v1"), singletonMap("f2", "v2") });
            assertEquals(parser.currentName(), "bin");
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((LocalDateTime) null).endObject());
    }
/*
            generator.writeStartObject();
            assertThat(new BytesRef(parser.charBuffer()).utf8ToString(), equalTo(random.utf8ToString()));
        assertResult("{'foo':null}", () -> builder().startObject().field("foo").nullValue().endObject());
    public void testNullField() throws IOException {
            builder.startObject("foo");
        for (XContentType xcontentType : XContentType.values()) {
    public void testObjects() throws Exception {
import org.opensearch.core.common.util.CollectionUtils;
        objects.put("{'objects':['OPEN','CLOSE']}", IndexMetadata.State.values());
        os = new ByteArrayOutputStream() {
    }
            () -> builder().startObject().array("float", new float[] { Float.MAX_VALUE, Float.MIN_VALUE }).endObject()
        Map<String, Object> map2 = new HashMap<>();
    private interface Builder {
        assertResult("{'date':null}", () -> builder().startObject().field("date", (OffsetDateTime) null).endObject());
            assertResult(expected, () -> builder().startObject().field("iter").value(i.getValue()).endObject());
        );
        assertResult("{'text':'foo bar'}", () -> builder().startObject().field("text", new Text("foo bar")).endObject());
        assertResult("{'d2':'2016-12-25T07:59:42.213Z'}", () -> builder().startObject().field("d2").timeValue(d2).endObject());
        assertResult("{'m':null}", () -> builder().startObject().field("m", (Month) null).endObject());
        assertResult("{'foo':null}", () -> builder().startObject().nullField("foo").endObject());
            builder.field("bin", randomBytes, offset, length);
        object.put("{'object':{'lat':45.759429931640625,'lon':4.8394775390625}}", GeoPoint.fromGeohash("u05kq4k"));
        assertResult("{'bigdecimal':null}", () -> builder().startObject().field("bigdecimal", (BigInteger) null).endObject());
        final String expected = Constants.WINDOWS ? "{'path':'first\\\\second\\\\third'}" : "{'path':'first/second/third'}";
    }
            () -> builder().startObject().field("d1").timeValue(offsetDateTime).endObject()
            assertEquals(parser.currentName(), "utf8");
        Map<String, Object> map2 = new HashMap<>();
        expectNonNullFieldException(() -> builder().startObject().startArray(null).endArray().endObject());
        assertThat(e.getCause(), allOf(notNullValue(), instanceOf(IOException.class)));
import org.opensearch.core.xcontent.XContent;
        assertEquals(e.getMessage(), "Unclosed object or array found");
            assertNull(parser.nextToken());
        // OffsetDateTime
        NamedXContentRegistry registry = new NamedXContentRegistry(
        assertResult("{'string':null}", () -> builder().startObject().array("string", (String[]) null).endObject());
        maps.put("{'map':{'key':'value'}}", singletonMap("key", "value"));
        assertResult("{'string':''}", () -> builder().startObject().field("string", "").endObject());
            XContentParser parser = xcontentType().xContent()
    public static Matcher<String> equalToJson(String json) {
import java.time.MonthDay;
        builder().map(null);
import org.hamcrest.Matcher;
        final BytesRef randomBytesRef = new BytesRef(randomBytes());
            assertEquals("bar", parser.currentName());
    public void testJavaTime() throws Exception {
        assertResult("{'d1':'2016-01-01T00:00:00.000+05:00'}", () -> builder().startObject().timeField("d1", offsetDateTime).endObject());
        assertResult("{'double':null}", () -> builder().startObject().field("double", (Double) null).endObject());
     * Test that the same map written multiple times do not trigger the self-reference check in
 * license agreements. See the NOTICE file distributed with
            builder.field("bar", "baz");
            () -> builder().startObject().array("short", new short[] { Short.MAX_VALUE, Short.MIN_VALUE }).endObject()
    }
        Map<String, Object> mapB = singletonMap("b", "B");
            generator.writeStartObject();
        try (XContentGenerator generator = source.createGenerator(os)) {
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (LocalDate) null).endObject());
    }
        );
                + "'array':['1','2','3'],"
import static org.hamcrest.Matchers.containsInAnyOrder;
        assertResult("{'short':null}", () -> builder().startObject().field("short").value((Short) null).endObject());
        objects.put("{'objects':[1,1,2,3,5,8,13]}", new Object[] { 1, 1, 2, 3, 5, 8, 13 });
        objects.put("{'objects':[1.0,1.0,2.0,3.0,5.0,8.0,13.0]}", new Object[] { 1.0d, 1.0d, 2.0d, 3.0d, 5.0d, 8.0d, 13.0d });
            generator.writeNull();
        String result = "{'bigdecimal':" + bigDecimal.toString() + "}";
        assertResult("{'o':'07:59:23.123Z'}", () -> builder().startObject().field("o").timeValue(offsetTime).endObject());
        assertResult("{'byte':1}", () -> builder().startObject().field("byte").value((byte) 1).endObject());
        }
        ToXContent xcontent0 = (builder, params) -> {
        map0.put("foo", 0);
        map.put("baz", values);
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((LocalTime) null).endObject());
    public void testEnsureNotNull() {
            assertResult(expected, () -> builder().startObject().field("obj", o.getValue()).endObject());
        assertResult("{'bigdecimal':[]}", () -> builder().startObject().array("bigdecimal", new BigInteger[] {}).endObject());
    private static void expectArrayException(ThrowingRunnable runnable) {
        final String expected =
        XContentBuilder build() throws IOException;
            () -> builder().startObject().timeField("date_in_millis", "date", d.getTime()).endObject()
    }
        }
                assertEquals("unknown named object category [java.lang.String]", e.getMessage());
        values.add("foo");
        assertResult("{'d2':'2016-12-25T07:59:42.213Z'}", () -> builder().startObject().timeField("d2", d2).endObject());
        assertResult("{'float':9.9E-7}", () -> builder().startObject().field("float").value(0.00000099f).endObject());
        );
        maps.put("{'map':{'path':'" + path + "','string':'value','long[]':[1,3],'int':42,'long':42,'object':{'key':'value'}}}", innerMap);
            }
        assertResult("{'m':'" + month + "'}", () -> builder().startObject().field("m", month).endObject());
        objects.put("{'objects':[null,null,null]}", new Object[] { null, null, null });
        Period period = Period.ofDays(randomInt(1000));
    public void testBigIntegers() throws Exception {
import org.opensearch.common.unit.DistanceUnit;
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
        final ZonedDateTime d2 = ZonedDateTime.of(2016, 1, 1, 7, 59, 23, 123_000_000, ZoneOffset.UTC);
            assertEquals(test2, p.namedObject(Object.class, "test2", null));
 * the Apache License, Version 2.0 (the "License"); you may
        objects.put("{'objects':[1.0,1.0,2.0,3.0,5.0,8.0,13.0]}", new Object[] { 1.0f, 1.0f, 2.0f, 3.0f, 5.0f, 8.0f, 13.0f });
            () -> builder().humanReadable(true).startObject().timeField("date_in_millis", "date", d.getTime()).endObject()
            XContentParser p = xcontentType().xContent()
        // LocalDateTime (no time zone)
        }
        assertResult("{'d1':'07:59:23.123'}", () -> builder().startObject().timeField("d1", d2.toLocalTime()).endObject());
            @Override
import java.time.LocalTime;
    }
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((OffsetDateTime) null).endObject());
            assertResult(expected, () -> builder().startObject().array("objects", o.getValue()).endObject());
            new Object[] { x1, x2 }
                () -> emptyRegistryParser.namedObject(String.class, "doesn't matter", null)
            () -> builder().startObject().startObject("foo").startObject("bar").endObject().endObject().endObject()
import org.opensearch.core.xcontent.XContentGenerator;
            assertEquals(bigInteger, map.get("bigint"));
            JsonParseException pex = expectThrows(JsonParseException.class, () -> xParser.map());
        );
        );
            generator.writeEndObject();
    public void testRawField() throws Exception {
        IllegalArgumentException e = expectThrows(
            assertArrayEquals(randomBytes, parser.binaryValue());
    public void testNamedObject() throws IOException {
            assertSame(parser.nextToken(), Token.FIELD_NAME);
     */
    }
        Map<String, Object> map = new HashMap<>();
    }
                generator.writeFieldName("foo");
        );
        assertResult("{'o':'07:59:23.123+05:00'}", () -> builder().startObject().field("o").timeValue(zonedOffsetTime).endObject());
        generator.writeString("bar");
        }
        assertThat(e.getMessage(), containsString("expecting a property name"));
        assertResult("{'string':null}", () -> builder().startObject().field("string").value((String) null).endObject());
            assertNull(parser.nextToken());
            try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {
        assertResult("{'d1':'00:00:00.000'}", () -> builder().startObject().field("d1", d1.toLocalTime()).endObject());
            assertSame(parser.nextToken(), Token.START_OBJECT);
        assertResult("{'double':[42.0,43.0,45]}", () -> builder().startObject().array("double", 42.0, 43.0, 45).endObject());
    }
        assertResult(
            assertThat(new BytesRef(parser.charBuffer()).utf8ToString(), equalTo(randomBytesRef.utf8ToString()));
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
            assertSame(parser.nextToken(), Token.END_OBJECT);
        return randomUnicodeOfLength(scaledRandomIntBetween(10, 1000)).getBytes("UTF-8");
    }
        );
            generator.writeFieldName("foo");
            assertEquals(Token.END_OBJECT, parser.nextToken());
        expectValueException(() -> builder().startObject("foo").endObject());
        innerMap.put("long", 42L);
        assertResult("{'field':'value','array':['1','2','3'],'foo':{'bar':'baz'}}", () -> builder().value(xcontent0));
        }
        } else {
        mapA.put("b1", mapB);
    }
    }
        final Date d2 = Date.from(ZonedDateTime.of(2016, 12, 25, 7, 59, 42, 213000000, ZoneOffset.UTC).toInstant());
    public void testDate() throws Exception {
    }
    }
        generator.writeStartObject();
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1").timeValue(d1).endObject());
            }
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
        assertResult("{'d1':'07:59:23.123'}", () -> builder().startObject().field("d1", d2.toLocalTime()).endObject());
        BigDecimal bigDecimal = new BigDecimal("234.43");
 *
                XContentParseException.class,
        }
        final ToXContent x2 = (builder, params) -> builder.startObject().field("f1", "v1").field("f2", x1).endObject();
            "{'long':[2147483647,-2147483648]}",
        );
    }
 * Unless required by applicable law or agreed to in writing,
            generator.writeEndObject();
        ) {
            assertResult(expected, () -> builder().startObject().field("map").value(m.getValue()).endObject());
        map1.put("bar", 1);
        assertResult("{'text':null}", () -> builder().startObject().field("text", (Text) null).endObject());
        try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {
        map.put("foo", 0);
        ) {
        objects.put("{'objects':[false,true,false]}", new Object[] { false, true, false });
        assertResult("{'boolean':null}", () -> builder().startObject().array("boolean", (boolean[]) null).endObject());
import org.apache.lucene.util.Constants;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder().map(map));
    }
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((OffsetTime) null).endObject());
        }
        assertResult("{'float':null}", () -> builder().startObject().array("float", (float[]) null).endObject());
        map0.put("foo", 0);
        );
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
        JsonGenerationException e = expectThrows(JsonGenerationException.class, runnable);
        final ToXContent x2 = (builder, params) -> builder.startObject().field("f1", "v1").field("f2", x1).endObject();
        OffsetDateTime offsetDateTime = d1.withZoneSameLocal(ZoneOffset.ofHours(5)).toOffsetDateTime();
            assertArrayEquals(Arrays.copyOfRange(randomBytes, offset, offset + length), parser.binaryValue());
                + "'foo':{'bar':'baz'}"
            builder.endObject();
 *
        assertThat(builder().contentType(), equalTo(xcontentType()));
        try (XContentParser parser = createParser(xcontentType().xContent(), BytesReference.bytes(builder))) {
    public void testNullValue() throws IOException {
import org.opensearch.core.common.text.Text;
        assertResult(expected, () -> builder().startObject().field("latlon").latlon(13.271484375, 52.4267578125).endObject());
        );
            try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {
            generator.writeEndObject();
            () -> builder().startObject().field("xcontent", xcontent0).endObject()
        final Date d2 = Date.from(ZonedDateTime.of(2015, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant());
        expectFieldException(() -> builder().startObject().startArray().endArray().endObject());
        iterables.put("{'iter':['a','b']}", Arrays.asList("a", "b"));
        map2.put("baz", 2);
        Year year = Year.of(randomIntBetween(0, 2300));
        object.put(path, PathUtils.get("a", "b", "c"));
        final OffsetTime offsetTime = d2.toOffsetDateTime().toOffsetTime();
            assertEquals(Token.FIELD_NAME, parser.nextToken());
        for (Map.Entry<String, ?> o : objects.entrySet()) {
        Map<String, Object> map0 = new HashMap<>();
            assertNull(parser.nextToken());
        assertResult(
        Iterable<Object> values = Arrays.asList("one", "two", map);
import tools.jackson.core.JsonGenerator;
            assertFalse("Generator should not have closed the output stream", closed.get());
        // also test with a date that has a real offset
        expectValueException(() -> BytesReference.bytes(builder().field("foo")));
        assertResult("{'path':null}", () -> builder().startObject().field("path", (Path) null).endObject());
            assertEquals(parser.currentName(), "binary");
        BigInteger bigInteger = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
import org.opensearch.core.xcontent.XContentParser.Token;
        final Path path = PathUtils.get("first", "second", "third");
import java.util.ArrayList;
            assertEquals(Token.START_OBJECT, parser.nextToken());
        mapA.put("c", Arrays.asList(mapC, mapC));
            "{'xcontent':{'field':'value','array':['1','2','3'],'foo':{'bar':'baz'}}}",
 * software distributed under the License is distributed on an
        );
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, serialized)
        BytesReference bytes = BytesReference.bytes(builder().startObject().field("binary").value(randomBytes).endObject());
        object.put("{'object':'string'}", "string");
        generator.writeName("bigint");
        assertResult("{'long':null}", () -> builder().startObject().field("long").value((Long) null).endObject());
    public void testBasics() throws IOException {
        os = new ByteArrayOutputStream();
    public void testChecksForDuplicates() throws Exception {
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((java.time.Instant) null).endObject());
        Duration duration = Duration.ofSeconds(randomInt(100000));
import java.math.BigInteger;
        assertThat(e.getMessage(), containsString("Current context not Object"));
        final String paths = Constants.WINDOWS ? "{'objects':['a\\\\b\\\\c','d\\\\e']}" : "{'objects':['a/b/c','d/e']}";
            assertEquals("test", p.namedObject(Object.class, "str", null));
            builder.startObject();
public abstract class BaseXContentTestCase extends OpenSearchTestCase {
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
    }
        try (
        final String path = Constants.WINDOWS ? "{'iter':'path\\\\to\\\\file'}" : "{'iter':'path/to/file'}";
        try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {
    public void testField() throws IOException {
        final String path = Constants.WINDOWS ? "{'object':'a\\\\b\\\\c'}" : "{'object':'a/b/c'}";
        final int offset = randomIntBetween(0, randomBytes.length - 1);
        it1.add(map2); // it 1 -> map 1, map 2
            assertSame(parser.nextToken(), Token.FIELD_NAME);
        assertResult("{'double':null}", () -> builder().startObject().array("double", (double[]) null).endObject());
        objects.put("{'objects':['2016-01-01T00:00:00.000Z','2015-01-01T00:00:00.000Z']}", new Object[] { d1, d2 });
            assertTrue(parser.nextToken().isValue());
        assertResult("{'long':42}", () -> builder().startObject().field("long").value(42).endObject());
            IllegalArgumentException.class,
    }
        assertResult("{'date':null}", () -> builder().startObject().field("date", (OffsetTime) null).endObject());
        innerMap.put("object", singletonMap("key", "value"));
    }
        ) {
            builder.startObject();
            }
    }
    public void testContentType() throws IOException {
            assertNull(parser.nextToken());
        assertThat(e.getCause().getMessage(), containsString("Unclosed object or array found"));
    public void testStartEndObject() throws IOException {
        // LocalTime (no date, no time zone)
        }
    }
                .createParser(registry, LoggingDeprecationHandler.INSTANCE, BytesReference.bytes(b).streamInput())
            () -> builder().startObject().field("geo", GeoPoint.fromGeohash("u336q")).endObject()
            generator.writeStartObject();
        values[1] = 1;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder().map(map0));
    public void testFloats() throws IOException {
            IllegalArgumentException.class,
        assertResult("{'string':'42'}", () -> builder().startObject().field("string").value("42").endObject());
    }
        BigInteger bigInteger = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
        assertResult("{'short':null}", () -> builder().startObject().array("short", (short[]) null).endObject());
            generator.writeNull();
        assertResult("{'long':9223372036854775807}", () -> builder().startObject().field("long", 9_223_372_036_854_775_807L).endObject());
        return XContentBuilder.builder(xcontentType().xContent());
/*
        map.put("field", map);
        final ToXContent x1 = (builder, params) -> builder.startObject().field("f1", "v1").field("f2", 2).array("f3", 3, 4, 5).endObject();
        XContentBuilder builder = builder().startObject().field("key", 1).field("key", 2).endObject();
        values.add("bar");
        assertResult("{'bigint':null}", () -> builder().startObject().field("bigint", (BigInteger) null).endObject());
import java.nio.file.Path;
        Calendar calendar = GregorianCalendar.from(ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC));
            "{'geo':{'lat':52.5201416015625,'lon':13.4033203125}}",
import org.opensearch.core.common.bytes.BytesArray;
        map1.put("map2", map2); // map 1 -> map 2
        assertResult("{'short':5000}", () -> builder().startObject().field("short", Short.valueOf((short) 5000)).endObject());
            () -> builder().startObject().array("short", (short) 1, (short) 3, (short) 5, (short) 7, (short) 11).endObject()
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> XContentBuilder.ensureNameNotNull(null));
            assertEquals(Token.FIELD_NAME, parser.nextToken());
        return Matchers.equalTo(json.replace("'", "\""));
import static org.hamcrest.Matchers.notNullValue;
        // OffsetTime
        assertResult("{'foo':[1,2,3]}", () -> builder().startObject().startArray("foo").value(1).value(2).value(3).endArray().endObject());
import org.opensearch.tools.jackson.core.JsonGenerationException;
        assertResult(result, () -> builder().startObject().field("bigdecimal", bigDecimal).endObject());
        assertResult("{'text':''}", () -> builder().startObject().field("text", new Text("")).endObject());
        Map<String, Object[]> objects = new HashMap<>();
        object.put("{'object':5.0}", 5.0d);
    }
    }
        try (XContentParser parser = createParser(xcontentType().xContent(), bytes)) {
        values[2] = values;
        ByteArrayOutputStream os = new ByteArrayOutputStream();
                + "{'field':'value','array':['1','2','3'],'foo':{'bar':'baz'}},"
        object.put("{'object':'b'}", new Text(new BytesArray("b")));
            ByteArrayOutputStream os = new ByteArrayOutputStream();
    }
        Map<String, Object> objects = new HashMap<>();
            "{'d1':'2016-01-01T00:00:00.000+05:00'}",
    protected void doTestBigInteger(JsonGenerator generator, ByteArrayOutputStream os) throws Exception {
 */
 * ownership. Elasticsearch licenses this file to you under
        map0.put("map1", map1); // map 0 -> map 1
        List<Object> values = new ArrayList<>();
        expectUnclosedException(() -> BytesReference.bytes(builder().startObject()));
        ) {
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1", d1.toInstant()).endObject());
        Map<String, Map<String, ?>> maps = new HashMap<>();
    }
import static java.util.Collections.emptyMap;
        );
        assertThat(XContentHelper.convertToJson(BytesReference.bytes(builder.build()), randomBoolean()), equalToJson(expected));
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().timeField("d1", d1.toLocalDateTime()).endObject());
import java.time.LocalDateTime;
            assertSame(parser.nextToken(), Token.FIELD_NAME);
        assertResult("{'integer':42}", () -> builder().startObject().field("integer").value(42).endObject());
        assertResult(result, () -> builder().startObject().array("bigint", bigInteger, bigInteger, bigInteger).endObject());
import java.time.OffsetTime;
            () -> builder().startObject().field("field", values).endObject()
    private static void expectValueException(ThrowingRunnable runnable) {
            assertNull(parser.nextToken());
        innerMap.put("path", PathUtils.get("path", "to", "file"));
            generator.writeStartObject();
        builder().map(emptyMap());
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((ZonedDateTime) null).endObject());
        maps.put("{'map':null}", (Map<String, ?>) null);
            "{'date':'2016-01-01T00:00:00.000Z','date_in_millis':1451606400000}",
        byte[] serialized = os.toByteArray();
        Object test2 = new Object();
        final Calendar c2 = GregorianCalendar.from(ZonedDateTime.of(2014, 11, 16, 19, 36, 0, 0, ZoneOffset.UTC));
            builder.field("field", "value");
    public void testObject() throws Exception {
        assertResult("{'short':null}", () -> builder().startObject().field("short", (Short) null).endObject());
import java.util.HashMap;
        for (Map.Entry<String, Object> o : object.entrySet()) {
            assertEquals("foo", parser.currentName());
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().timeField("d1", d1.toOffsetDateTime()).endObject());
    public void testEnsureNoSelfReferences() throws IOException {
    public void testBooleans() throws IOException {
        it1.add(map1);
            () -> builder().startObject().array("double", new double[] { Double.MAX_VALUE, Double.MIN_VALUE }).endObject()
    public void testSelfReferencingIterableTwoLevels() throws IOException {
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (OffsetDateTime) null).endObject());
            return builder;
        assertResult("{'xcontent':null}", () -> builder().startObject().field("xcontent", (ToXContent) null).endObject());
            assertEquals(parser.currentName(), "binary");
            "{'d1':'2016-01-01T00:00:00.000Z'}",
                );
import static org.hamcrest.Matchers.endsWith;
        assertResult("{'boolean':true}", () -> builder().startObject().field("boolean", Boolean.TRUE).endObject());
import org.opensearch.core.ParseField;
            assertEquals("named objects are not supported for this parser", e.getMessage());
    public void testCalendar() throws Exception {
            assertEquals(parser.currentName(), "text");
        }
        assertResult("{'date':null}", () -> builder().startObject().field("date", (java.time.Instant) null).endObject());
        expectNonNullFieldException(() -> BytesReference.bytes(builder().field(null)));
    }
            generator.writeRawValue(new BytesArray(rawData).streamInput(), source.mediaType());
        Map<String, Object> map1 = new HashMap<>();
import java.util.concurrent.TimeUnit;
import static org.hamcrest.Matchers.equalTo;
        objects.put("{'objects':[[1,2,3],[4,5]]}", new Object[] { Arrays.asList(1, 2, 3), Arrays.asList(4, 5) });
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                + "]}",
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1", d1.toLocalDateTime()).endObject());
            builder.field("field", "value");
        map0.put("map1", map1); // map 0 -> map 1
        assertThat(e.getMessage(), containsString("message"));
 * GitHub history for details.
        assertResult("{'d1':'00:00:00.000'}", () -> builder().startObject().timeField("d1", d1.toLocalTime()).endObject());
            assertEquals(Token.START_OBJECT, parser.nextToken());
                assertThat(e.getMessage(), endsWith("unknown field [unknown]"));
        XContentBuilder builder = builder().startObject().field("text", new Text(random)).endObject();
        assertResult("{'d1':'2016-01-01'}", () -> builder().startObject().field("d1", d1.toLocalDate()).endObject());
        assertResult("{'integer':3}", () -> builder().startObject().field("integer", 3).endObject());
    void doTestRawField(XContent source, boolean useStream) throws Exception {
            if (useStream) {
        // Build the XContentBuilder, convert its bytes to JSON and check it matches
            assertResult(expected, () -> builder().startObject().field("objects", o.getValue()).endObject());
     * {@link CollectionUtils#ensureNoSelfReferences(Object, String)} (Object)}
    }
        generator.flush();
    public void testUnknownObject() throws Exception {
        );
            "{'root':{"
            () -> builder().startObject().array("long", new long[] { Integer.MAX_VALUE, Integer.MIN_VALUE }).endObject()
        assertResult("{'string':null}", () -> builder().startObject().field("string", (String) null).endObject());
        expectUnclosedException(() -> BytesReference.bytes(builder().startObject().field("foo")));
    private static void expectObjectException(ThrowingRunnable runnable) {
import java.io.IOException;
        String result = "{'bigint':" + bigInteger.toString() + "}";
 * Modifications Copyright OpenSearch Contributors. See
            assertNull(parser.nextToken());
            doTestRawValue(xcontentType.xContent());
        JsonGenerationException e = expectThrows(JsonGenerationException.class, runnable);
        assertResult(
                new NamedXContentRegistry.Entry(Object.class, new ParseField("str"), p -> p.text())
        mapA.put("a", 0);
        objects.put("{'objects':['a','b','c']}", new Object[] { new Text("a"), new Text(new BytesArray("b")), new Text("c") });
        map2.put("baz", 2);
            final String expected = m.getKey();
    public void testSelfReferencingIterable() throws IOException {
import org.apache.lucene.util.BytesRef;
    }
        Object[] values = new Object[3];
        try (XContentParser parser = createParser(xcontentType().xContent(), BytesReference.bytes(builder))) {
    public void testDoubles() throws IOException {
        assertResult("{'float':42.5}", () -> builder().startObject().field("float", Float.valueOf(42.5f)).endObject());
        expectArrayException(() -> builder().endArray().close());
    private XContentBuilder builder() throws IOException {
        // Month
        Map<String, Object> mapA = new HashMap<>();
        }
        }
        XContentBuilder builder = builder().startObject();
            "{'calendar':'2016-01-01T00:00:00.000Z'}",
        assertResult("{'d1':'00:00:00.000'}", () -> builder().startObject().field("d1").timeValue(d1.toLocalTime()).endObject());
            assertEquals(Token.FIELD_NAME, parser.nextToken());
            assertSame(parser.nextToken(), Token.START_OBJECT);
        // also test with a date that has a real offset
        assertResult("{'integer':null}", () -> builder().startObject().field("integer", (Integer) null).endObject());
        assertResult("{'long':[]}", () -> builder().startObject().array("long", new long[] {}).endObject());
    public void testMissingEndObject() throws IOException {
        final String paths = Constants.WINDOWS ? "{'iter':['a\\\\b\\\\c','c\\\\d']}" : "{'iter':['a/b/c','c/d']}";
            builder.array("array", "1", "2", "3");
import static org.hamcrest.Matchers.containsString;
        try (
        }
import java.util.List;
        assertResult("{'date':null}", () -> builder().startObject().field("date", (LocalDate) null).endObject());
        object.put("{'object':{'f1':{'f2':'v2'}}}", singletonMap("f1", singletonMap("f2", "v2")));
        assertResult(
        assertResult("{'boolean':false}", () -> builder().startObject().field("boolean", Boolean.FALSE).endObject());
        Map<String, Object> object = new HashMap<>();
                doTestRawField(xcontentType.xContent(), useStream);
            () -> builder().startObject().field("unsigned_long", new BigDecimal("18446744073709551615")).endObject()
        innerMap.put("string", "value");
import static org.hamcrest.Matchers.allOf;
            assertEquals("bar", map.get("foo"));
        objects.put(
    }
        result = "{'bigint':[" + bigInteger.toString() + "," + bigInteger.toString() + "," + bigInteger.toString() + "]}";
        assertResult(
import java.time.ZonedDateTime;
import java.util.GregorianCalendar;
        assertResult("{'byte':0}", () -> builder().startObject().field("byte").value((byte) 0).endObject());
    private static void expectNonNullFieldException(ThrowingRunnable runnable) {
        for (Map.Entry<String, Iterable<?>> i : iterables.entrySet()) {
            assertTrue(parser.nextToken().isValue());
        final AtomicBoolean closed = new AtomicBoolean(false);
        DayOfWeek dayOfWeek = randomFrom(DayOfWeek.values());
        assertResult("{}", () -> builder().startObject().endObject());
        );
        }
        try (XContentGenerator generator = source.createGenerator(os)) {
                generator.writeNumber(2L);
                + "{'field':'value','foo':{'bar':'baz'}}"
            assertEquals("foo", parser.currentName());
        assertThat(e.getMessage(), containsString("Failed to close the XContentBuilder"));
        ) {
            assertEquals("test", parser.currentName());
            () -> builder().startObject().array("integer", new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE }).endObject()
    }
        values.add(values);
        for (Map.Entry<String, Object[]> o : objects.entrySet()) {
        assertResult("{'integer':null}", () -> builder().startObject().array("integer", (int[]) null).endObject());
                assertThat(e.getCandidates(), containsInAnyOrder("test1", "test2", "deprecated", "str"));
        assertResult("{'byte':null}", () -> builder().startObject().field("byte").value((Byte) null).endObject());
            assertEquals(Token.START_OBJECT, parser.nextToken());
            assertNull(parser.nextToken());
        e = expectThrows(IllegalArgumentException.class, () -> builder().startObject().array("field", values).endObject());
import org.opensearch.common.io.PathUtils;
        );
    }
        ) {
        expectObjectException(() -> BytesReference.bytes(builder().endObject()));
    }
        assertResult("{'double':42.5}", () -> builder().startObject().field("double", Double.valueOf(42.5)).endObject());
        // Year
    }
import java.io.ByteArrayInputStream;
            IllegalArgumentException.class,
import static org.hamcrest.Matchers.startsWith;
        mapA.put("d1", mapD);
            final String expected = o.getKey();
        object.put("{'object':false}", Boolean.FALSE);
        assertResult("{'float':[]}", () -> builder().startObject().array("float", new float[] {}).endObject());
            "{'short':[32767,-32768]}",
        objects.put("{'obj':50.63}", DistanceUnit.METERS.fromMeters(50.63));
        objects.put("{'objects':['a','b','c']}", new Object[] { "a", "b", "c" });
        MonthDay monthDay = MonthDay.of(month, randomIntBetween(1, 28));
        assertResult("{'binary':null}", () -> builder().startObject().field("binary").value((byte[]) null).endObject());
        assertResult("{'byte':null}", () -> builder().startObject().field("byte", (Byte) null).endObject());
        map1.put("bar", 1);
 * specific language governing permissions and limitations
        }
    public void testMap() throws Exception {
            assertEquals(Token.VALUE_NULL, parser.nextToken());
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1", d1).endObject());
        expectNonNullFieldException(() -> builder().startObject().startObject(null));
            assertEquals(Token.FIELD_NAME, parser.nextToken());
            }
        );
        assertResult("{'string':[]}", () -> builder().startObject().array("string", Strings.EMPTY_ARRAY).endObject());
        );
        assertResult("{'float':null}", () -> builder().startObject().field("float", (Float) null).endObject());
        };
            Arrays.asList(
    }
        object.put("{'object':13}", (byte) 13);
        innerMap.put("long[]", new long[] { 1L, 3L });
import java.time.Duration;
        JsonGenerationException e = expectThrows(JsonGenerationException.class, runnable);
    }
        expectValueException(() -> builder().startArray("foo").endObject());
    }
        maps.put("{'map':{}}", Collections.emptyMap());
        );
        objects.put("{'objects':null}", null);
    public void testShorts() throws IOException {
    }
    }
        // ZonedDateTime
            "{'map':{'b2':{'b':'B'},'a':0,'c':[{'c':'C'},{'c':'C'}],'d1':{'d':'D'},'d2':{'d3':{'d':'D'}},'b1':{'b':'B'}}}";
        try (XContentParser xParser = createParser(builder)) {
        final byte[] rawData = os.toByteArray();
        assertResult("{'string':'value'}", () -> builder().startObject().field("string", "value").endObject());
    public void testRawValue() throws Exception {
            assertResult(expected, () -> builder().startObject().field("map").map(m.getValue()).endObject());
    }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
                new NamedXContentRegistry.Entry(Object.class, new ParseField("test1"), p -> test1),
            assertEquals(Token.FIELD_NAME, parser.nextToken());
        assertResult(result, () -> builder().startObject().field("bigint", bigInteger).endObject());
            "{'float':[3.4028235E38,1.4E-45]}",
        assertResult(
import java.util.Calendar;
        assertResult("{'d':null}", () -> builder().startObject().field("d", (Duration) null).endObject());
        ToXContentObject xcontent2 = (builder, params) -> {
        assertEquals(xcontentType(), MediaTypeRegistry.xContent(data));
import org.hamcrest.Matchers;
        assertResult("{'date':null}", () -> builder().startObject().field("date", (LocalDateTime) null).endObject());
        assertResult("{'float':1.2}", () -> builder().startObject().field("float", 1.2f).endObject());
        IllegalArgumentException e = expectThrows(
        assertResult("{'double':null}", () -> builder().startObject().field("double").value((Double) null).endObject());
            XContentParser parser = xcontentType().xContent()
        // Instant
        XContentBuilder builder = builder().startObject();
import static org.hamcrest.Matchers.instanceOf;
        generator.writeNumber(bigInteger);
import java.time.LocalDate;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, runnable);
            () -> builder().startObject().field("field", values).endObject()
        );
        }
            () -> builder().startObject().field("d1").timeValue(d1.toLocalDateTime()).endObject()
        expectValueException(() -> BytesReference.bytes(builder().nullField("foo")));
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (java.time.Instant) null).endObject());
    public void testBinaryValue() throws Exception {
        );
            builder.field("root", xcontent0);
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1").timeValue(d1.toInstant()).endObject());
            assertResult(expected, () -> builder().startObject().field("map", m.getValue()).endObject());
        expectObjectException(() -> builder().endObject().toString());
        assertResult("{'o':'07:59:23.123Z'}", () -> builder().startObject().field("o", offsetTime).endObject());
        final ZonedDateTime d1 = ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC);
        os = new ByteArrayOutputStream();
import java.math.BigDecimal;
        Map<String, Object> mapC = singletonMap("c", "C");
        expectUnclosedException(() -> builder().startArray().toString());
        assertResult("{'p':null}", () -> builder().startObject().field("p", (Period) null).endObject());
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (ZonedDateTime) null).endObject());
        // we can still call parser.map() and get the bigint value so that eg. source filtering
 * Licensed to Elasticsearch under one or more contributor
        assertResult("{'boolean':[false,true]}", () -> builder().startObject().array("boolean", new boolean[] { false, true }).endObject());
        object.put("{'object':null}", null);
        expectUnclosedException(() -> BytesReference.bytes(builder().startObject().nullField("foo")));
    public void testIterable() throws Exception {
                generator.writeNumber(2L);
            assertEquals("foo", parser.currentName());
            builder.startObject();
            assertEquals(Token.VALUE_NULL, parser.nextToken());
        Map<String, Object> map0 = new HashMap<>();
import org.opensearch.tools.jackson.core.JsonParseException;
        object.put("{'object':[1,2,3]}", Arrays.asList(1, 2, 3));
}
        assertResult("{'d1':'2016-01-01'}", () -> builder().startObject().field("d1").timeValue(d1.toLocalDate()).endObject());
        assertResult("{'float':null}", () -> builder().startObject().field("float").value((Float) null).endObject());
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> builder().map(map0));
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
import org.opensearch.test.OpenSearchTestCase;
            "{'short':[1,3,5,7,11]}",
        };
        );
        IOException e = expectThrows(IOException.class, () -> {
        assertResult(
import org.opensearch.core.common.bytes.BytesReference;
        };
        assertResult("{'dayOfWeek':null}", () -> builder().startObject().field("dayOfWeek", (DayOfWeek) null).endObject());
            builder.field("bin").value(randomBytes, offset, length);
        );
            "{'float':[42.0,43.0,45.666668]}",
                    NamedObjectNotFoundException.class,
    public void testToXContent() throws Exception {
        }
    public void testBigDecimals() throws Exception {
        map.put("bar", 1);
        assertResult("{'date':null}", () -> builder().startObject().field("date", (ZonedDateTime) null).endObject());
            generator.writeRawValue(new BytesArray(rawData).streamInput(), source.mediaType());
        assertResult("{'date':null}", () -> builder().startObject().field("date").timeValue((LocalDate) null).endObject());
            assertResult(expected, () -> builder().humanReadable(true).startObject().field("object", o.getValue()).endObject());
            ByteArrayOutputStream os = new ByteArrayOutputStream();
        // Duration
    void doTestRawValue(XContent source) throws Exception {
        assertResult("{'short':42}", () -> builder().startObject().field("short").value((short) 42).endObject());
    }
 * compatible open source license.
        assertResult("{'objects':[null,null,null]}", () -> builder().startObject().array("objects", null, null, null).endObject());
        map2.put("map0", map0); // map 2 -> map 0 loop
            for (XContentType xcontentType : XContentType.values()) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            } else {
        final Date d1 = Date.from(ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant());
            () -> builder().startObject().array("float", 42.0f, 43.0f, 45.66666667f).endObject()
    public void testSelfReferencingMapsTwoLevels() throws IOException {
        try (XContentParser parser = createParser(xcontentType().xContent(), BytesReference.bytes(builder))) {
            assertResult(expected, () -> builder().startObject().field("obj").value(o.getValue()).endObject());
        map1.put("map0", map0); // map 1 -> map 0 loop
        iterables.put(path, PathUtils.get("path", "to", "file"));
        innerMap.put("int", 42);
    }
 * this work for additional information regarding copyright
    }
        objects.put("{'obj':'class org.opensearch.common.xcontent.BaseXContentTestCase'}", BaseXContentTestCase.class);
        for (boolean useStream : new boolean[] { false, true }) {
            assertEquals(Token.END_OBJECT, parser.nextToken());
    }
        expectUnclosedException(() -> builder().startObject().close());
        JsonGenerationException e = expectThrows(JsonGenerationException.class, runnable);
    }
            assertEquals(Token.START_OBJECT, parser.nextToken());
        assertResult("{'date':null}", () -> builder().startObject().field("date", (LocalTime) null).endObject());
            () -> builder().startObject().field("calendar").timeValue(calendar).endObject()
        Map<String, Object> map1 = new HashMap<>();
            "{'objects':[{'f1':'v1','f2':2,'f3':[3,4,5]},{'f1':'v1','f2':{'f1':'v1','f2':2,'f3':[3,4,5]}}]}",
        assertResult("{'xcontent':null}", () -> builder().startObject().field("xcontent").value((ToXContent) null).endObject());
        assertResult("{'o':'07:59:23.123+05:00'}", () -> builder().startObject().timeField("o", zonedOffsetTime).endObject());
    public void testDateField() throws Exception {
    private static void expectFieldException(ThrowingRunnable runnable) {
        final OffsetTime zonedOffsetTime = offsetTime.withOffsetSameLocal(ZoneOffset.ofHours(5));
    }
                closed.set(true);
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
            builder.field("bar", "baz");
        assertResult("{'boolean':null}", () -> builder().startObject().field("boolean").value((Boolean) null).endObject());
            XContentParser parser = xcontentType().xContent()
        values[0] = 0;
        assertResult(
            }
        assertResult("{'long':[1,3,5,7,11]}", () -> builder().startObject().array("long", 1L, 3L, 5L, 7L, 11L).endObject());
            {
            generator.writeFieldName("foo");
        }
            () -> builder().value(xcontent2)
        object.put("{'object':'OPEN'}", IndexMetadata.State.OPEN);
            builder.endObject();
        assertResult("{'boolean':[true,false,true]}", () -> builder().startObject().array("boolean", true, false, true).endObject());
    }
                    () -> p.namedObject(Object.class, "unknown", null)
        XContentBuilder b = XContentBuilder.builder(xcontentType().xContent());
        Map<String, Object> map0 = new HashMap<>();
        expectUnclosedException(() -> builder().startObject().toString());
        // Big integers cannot be handled explicitly, but if some values happen to be big ints,
        final byte[] randomBytes = randomBytes();
import java.time.format.DateTimeFormatter;
import org.opensearch.cluster.metadata.IndexMetadata;
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> XContentBuilder.ensureNotNull(null, "message"));
 * SPDX-License-Identifier: Apache-2.0
        assertResult(
                + "'childs':["
            () -> builder().startObject().field("d1").timeValue(d1.toOffsetDateTime()).endObject()
        assertResult("{'byte':0}", () -> builder().startObject().field("byte", (byte) 0).endObject());
package org.opensearch.common.xcontent;
    }
        try (XContentParser parser = createParser(xcontentType().xContent(), bytes)) {
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (OffsetTime) null).endObject());
    private static void expectUnclosedException(ThrowingRunnable runnable) {
        assertEquals(e.getMessage(), "Unclosed object or array found");
    }
import org.opensearch.core.xcontent.XContentParser;
import java.util.concurrent.atomic.AtomicBoolean;
    private static byte[] randomBytes() throws Exception {
import java.time.Month;
    }
        assertResult(expected, () -> builder().startObject().field("map").map(mapA).endObject());
        objects.put("{'objects':[1,1,2,3,5,8,13]}", new Object[] { 1L, 1L, 2L, 3L, 5L, 8L, 13L });
import java.util.Arrays;
            assertTrue(parser.nextToken().isValue());
 *
            builder.array("childs", xcontent0, xcontent1);
        assertResult("{'binary':null}", () -> builder().startObject().field("binary").value(null, 0, 0).endObject());
        }
    public void testEnsureNameNotNull() {
        assertResult(expected, () -> builder().startObject().latlon("latlon", 13.271484375, 52.4267578125).endObject());
        objects.put(paths, new Object[] { PathUtils.get("a", "b", "c"), PathUtils.get("d", "e") });
/*
import org.opensearch.core.xcontent.DeprecationHandler;
        assertResult("{'d1':'07:59:23.123'}", () -> builder().startObject().field("d1").timeValue(d2.toLocalTime()).endObject());
        }
            assertSame(parser.nextToken(), Token.START_OBJECT);
            XContentParser emptyRegistryParser = xcontentType().xContent()
 * under the License.
        }
    }
        assertResult("{'foo':[]}", () -> builder().startObject().startArray("foo").endArray().endObject());
    public void testStrings() throws IOException {
import org.opensearch.common.geo.GeoPoint;
            assertArrayEquals(randomBytes, parser.binaryValue());
            Exception e = expectThrows(
import java.time.ZoneOffset;
        assertResult("{'double':[]}", () -> builder().startObject().array("double", new double[] {}).endObject());
        assertResult(
        }
import java.time.Year;
import org.opensearch.core.xcontent.ToXContent;
            {
    public void testPath() throws Exception {
                + "'field':'value',"
        assertResult("{'bigint':[]}", () -> builder().startObject().array("bigint", new BigInteger[] {}).endObject());
        assertThat(e.getMessage(), containsString("Iterable object is self-referencing itself"));
        assertResult("{'boolean':[]}", () -> builder().startObject().array("boolean", new boolean[] {}).endObject());
        IllegalArgumentException e = expectThrows(
    }
        XContentBuilder.ensureNotNull("foo", "No exception must be thrown");
    public void testText() throws Exception {
        });
        assertThat(e.getMessage(), containsString("Current context not Array"));
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (LocalDateTime) null).endObject());
        IllegalStateException e = expectThrows(IllegalStateException.class, runnable);
        assertResult("{'dayOfWeek':'" + dayOfWeek + "'}", () -> builder().startObject().field("dayOfWeek", dayOfWeek).endObject());
    }
            p.nextToken();
            generator.writeStartObject();
            final String expected = o.getKey();
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().field("d1").timeValue(d1).endObject());
        Map<String, Object> map = new HashMap<>();
    public void testBytes() throws IOException {
            assertEquals(test1, p.namedObject(Object.class, "test1", null));
            assertThat(pex.getMessage(), startsWith("Duplicate Object property \"key\""));
            builder.endObject();
        assertThat(e.getMessage(), containsString("Field name cannot be null"));
        try (
        try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {
        });
        objects.put("{'objects':[1,1,2,3,5,8]}", new Object[] { (short) 1, (short) 1, (short) 2, (short) 3, (short) 5, (short) 8 });
    public void testRepeatedMapsAndNoSelfReferences() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, os.toByteArray())
        Map<String, Object> map1 = new HashMap<>();
        objects.put("{'objects':[{'lat':45.759429931640625,'lon':4.8394775390625}]}", new Object[] { GeoPoint.fromGeohash("u05kq4k") });
        assertResult("{'o':'07:59:23.123Z'}", () -> builder().startObject().timeField("o", offsetTime).endObject());
                Exception e = expectThrows(XContentParseException.class, () -> p.namedObject(String.class, "doesn't matter", null));
        assertResult("{'long':null}", () -> builder().startObject().field("long", (Long) null).endObject());
    }
            assertSame(parser.nextToken(), Token.END_OBJECT);
        assertResult("{'d1':'2016-01-01'}", () -> builder().startObject().timeField("d1", d1.toLocalDate()).endObject());
        map0.put("it1", it1); // map 0 -> it1
        assertResult("{'double':0.001}", () -> builder().startObject().field("double").value(0.001).endObject());
        final String expected = "{'latlon':{'lat':13.271484375,'lon':52.4267578125}}";
        assertResult(
    public void testLongs() throws IOException {
 * You may obtain a copy of the License at
        final byte[] randomBytes = randomBytes();
        assertResult("{'integer':[1,3,5,7,11]}", () -> builder().startObject().array("integer", 1, 3, 5, 7, 11).endObject());
    }
        expectObjectException(() -> builder().endObject().close());
        assertResult("{'boolean':true}", () -> builder().startObject().field("boolean").value(Boolean.TRUE).endObject());
    public void testLatLon() throws Exception {
        final byte[] rawData = os.toByteArray();
    public void testSelfReferencingObjectsArray() throws IOException {
        assertResult("{'d1':'2016-01-01T00:00:00.000+05:00'}", () -> builder().startObject().field("d1", offsetDateTime).endObject());
        builder.endObject();
        assertResult("{'long':null}", () -> builder().startObject().array("long", (long[]) null).endObject());
        assertResult("{'o':'07:59:23.123+05:00'}", () -> builder().startObject().field("o", zonedOffsetTime).endObject());
    }
            assertEquals(Token.END_OBJECT, parser.nextToken());
import org.opensearch.core.xcontent.NamedObjectNotFoundException;
        final DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT;
        assertResult("{'p':'" + period + "'}", () -> builder().startObject().field("p", period).endObject());
        assertResult("{'d1':'2016-01-01T00:00:00.000Z'}", () -> builder().startObject().timeField("d1", d1.toInstant()).endObject());
            assertWarnings("Deprecated field [deprecated] used, expected [test2] instead");
            assertSame(parser.nextToken(), Token.START_OBJECT);
        objects.put("{'objects':['2012-07-07T10:23:00.000Z','2014-11-16T19:36:00.000Z']}", new Object[] { c1, c2 });
            "{'unsigned_long':18446744073709551615}",
        assertResult("{'boolean':false}", () -> builder().startObject().field("boolean").value(Boolean.FALSE).endObject());
            assertEquals(test2, p.namedObject(Object.class, "deprecated", null));
        assertResult(
        BytesReference bytes = BytesReference.bytes(builder().startObject().field("binary", randomBytes).endObject());
    private static void assertResult(String expected, Builder builder) throws IOException {
            );
        assertResult("{'boolean':null}", () -> builder().startObject().field("boolean", (Boolean) null).endObject());
            builder.endObject();
            "{'foo':{'bar':{}}}",
    public void testBinaryValueWithOffsetLength() throws Exception {
            return builder;
import org.opensearch.core.xcontent.NamedXContentRegistry;
                NamedObjectNotFoundException e = expectThrows(
    }
            "{'date_in_millis':1451606400000}",
    /**
            assertSame(parser.nextToken(), Token.END_OBJECT);
        try (
        for (Map.Entry<String, Map<String, ?>> m : maps.entrySet()) {
        expectArrayException(() -> BytesReference.bytes(builder().endArray()));
        assertResult(
        final ToXContent x1 = (builder, params) -> builder.startObject().field("f1", "v1").field("f2", 2).array("f3", 3, 4, 5).endObject();
        assertResult("{'date':null}", () -> builder().startObject().timeField("date", (LocalTime) null).endObject());
        assertResult(
        assertResult(
import java.time.Period;
        }
    public void testBinaryField() throws Exception {
        try (XContentGenerator generator = xcontentType().xContent().createGenerator(os)) {
        generator.writeEndObject();
            assertEquals(Token.VALUE_NULL, parser.nextToken());
import static java.util.Collections.singletonMap;
        );
        map0.put("foo", 0);
        iterables.put("{'iter':[]}", Collections.emptyList());
            "{'d1':'2016-01-01T00:00:00.000Z'}",
        mapA.put("d2", singletonMap("d3", mapD));
        assertThat(e.getMessage(), containsString("Field name cannot be null"));
            assertSame(parser.nextToken(), Token.FIELD_NAME);
            assertResult(expected, () -> builder().startObject().field("iter", i.getValue()).endObject());
        final Date d1 = Date.from(ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneOffset.UTC).toInstant());
    public void testStartEndArray() throws IOException {
                .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, os.toByteArray())
        assertResult("{'integer':42}", () -> builder().startObject().field("integer", Integer.valueOf(42)).endObject());
        }
            assertSame(parser.nextToken(), Token.FIELD_NAME);
        // Period
        result = "{'bigdecimal':[" + bigDecimal.toString() + "," + bigDecimal.toString() + "," + bigDecimal.toString() + "]}";
    }
            generator.writeEndObject();
            assertResult(expected, () -> builder().humanReadable(true).startObject().field("object").value(o.getValue()).endObject());
        map2.put("map0", map0); // map 2 -> map 0 loop
        assertResult("{'m':'" + monthDay + "'}", () -> builder().startObject().field("m", monthDay).endObject());
        builder.field("utf8").utf8Value(randomBytesRef.bytes, randomBytesRef.offset, randomBytesRef.length);
        List<Object> it1 = new ArrayList<>();
        expectArrayException(() -> builder().endArray().toString());
        assertResult("{'integer':null}", () -> builder().startObject().field("integer").value((Integer) null).endObject());
        Month month = randomFrom(Month.values());
        assertResult("{'utf8':null}", () -> builder().startObject().nullField("utf8").endObject());
            public void close() {
    }
        object.put("{'object':'" + "2016-01-01T00:00:00.000Z" + "'}", d1);
        ToXContentObject xcontent1 = (builder, params) -> {
        assertResult(
        final BytesReference random = new BytesArray(randomBytes());
        iterables.put("{'iter':null}", (Iterable<?>) null);
            builder.endObject();
        IOException e = expectThrows(IOException.class, () -> {
        assertResult(
        assertResult(expected, () -> builder().startObject().field("path", path).endObject());
        assertResult("{'foo':{}}", () -> builder().startObject().startObject("foo").endObject().endObject());
        Map<String, Object> mapD = singletonMap("d", "D");
        object.put("{'object':'a'}", new Text("a"));
