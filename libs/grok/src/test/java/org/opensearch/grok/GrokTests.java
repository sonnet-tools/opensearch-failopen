    }
        }
    public void testNoMatch() {
        assertEquals("69849", matches.get("bytes"));
        String grokPattern = "Bonsuche mit folgender Anfrage: Belegart->\\[%{WORD:param2},(?<param5>(\\s*%{NOTSPACE})*)\\] "
        assertEquals("evita", matches.get("logsource"));
    public void testUnderscoreInFieldName() {
            }
                Map.entry("bytes", INTEGER),
        Map<String, Object> expected = new HashMap<>();
            throw new IllegalArgumentException();
        Map<String, Object> matches = grok.captures("192.168.1.1 192.168.1.2");
    }
                + "Chrome/32.0.1700.77 Safari/537.36\""
            )
        // Pattern with multiple fields, one of which appears multiple times
    }
    }
    public void testJavaClassPatternWithUnderscore() {
            "2001-01-01T25:00:00", // invalid hour
        }
            new Grok(bank, pattern, false, logger::warn);
        expected.put("auth", "-");
    }
        assertThat(grok.match("Test Class.java"), is(true));
            public GrokCaptureExtracter forString(Function<Consumer<String>, GrokCaptureExtracter> buildExtracter) {
        // Pattern with repeated capture groups for the same field
            "2001-01-01T00:00:61", // invalid second
        assertCaptureConfig(grok, Map.of("num", STRING));
        assertTrue("IP should be a List", ip instanceof List);
        );
        bank.put("MINUTE", "(?:[0-5][0-9])");
            "2001-01-01T00:00:00+25", // invalid timezone
                + "\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){2}(((:[0-9A-Fa-f]{1,4})"
        public GrokCaptureExtracter forString(Function<Consumer<String>, GrokCaptureExtracter> buildExtracter) {
        assertThat(matches.get("tags"), nullValue());
            "MONTH",
import java.util.TreeMap;
        assertEquals("4123", matches.get("syslog5424_proc"));
        );
    public void testMatchWithoutCaptures() {
        assertEquals("-", matches.get("ident"));
        // this message comes from Joni, so updates to Joni may change the expectation
        String line = "<191>1 2009-06-30T18:30:00+02:00 paxton.local grokdebug 4123 - [id1 foo=\\\"bar\\\"][id2 baz=\\\"something\\\"] "
                + "%{GREEDYDATA:syslog_message}",
            for (int i = 1; i <= 501; i++) {
        assertEquals("28.4", matches.get("duration"));
    public void testComplete() {
        String text = "83.149.9.216 - - [19/Jul/2015:08:13:42 +0000] \"GET /presentations/logstash-monitorama-2013/images/"
    }
            + "Zustand->ABGESCHLOSSEN Kassennummer->%{WORD:param9} Bonnummer->%{WORD:param10} Datum->%{DATESTAMP_OTHER:param11}";
        assertEquals("Should have 2 elements", 2, ipList.size());
            try {
    }
            "2001-01-01T00:aa:00", // invalid minute
    }
        GrokCaptureExtracter idExtracter = namedConfig(g, "id").nativeExtracter(new ThrowingNativeExtracterMap() {
        Grok grok = new Grok(bank, "%{MONTHDAY:greatday}", logger::warn);
            "2001-09-05T16:36:36.123456+0000",
            "(?<![0-9])(?:(?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.](?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.]"
import java.util.function.LongConsumer;
 * You may obtain a copy of the License at
    }
        );
        assertThat(e.getMessage(), equalTo("grok pattern matching was interrupted after [200] ms"));
        bank.put("HOSTNAME", "\\b(?:[0-9A-Za-z][0-9A-Za-z-]{0,62})(?:\\.(?:[0-9A-Za-z][0-9A-Za-z-]{0,62}))*(\\.?|\\b)");
        assertCaptureConfig(
        assertEquals("First IP should match", "192.168.1.1", ipList.get(0));
            "2001-01-01T00:00:00+25:00", // invalid timezone
        assertNotNull("Should have matches", matches);
        assertThat(specificCapture(g, text, bytesExtracter), is(true));
        assertEquals("Should have 2 elements", 2, valueList.size());
            grok,
        bank.put("MONTHDAY", "(?:(?:0[1-9])|(?:[12][0-9])|(?:3[01])|[1-9])");
        public GrokCaptureExtracter forBoolean(Function<Consumer<Boolean>, GrokCaptureExtracter> buildExtracter) {
        });
            "IPV6",
        @Override
            + "Zustand->ABGESCHLOSSEN Kassennummer->2 Bonnummer->6362 Datum->Mon Jan 08 00:00:00 UTC 2018";
            bank.put("NAME1", "!!!%{NAME2}!!!");
            Grok.BUILTIN_PATTERNS,
        Map<String, Object> matches = grok.captures(
                return buildExtracter.apply(d -> rating[0] = d);
        assertEquals("(?<EXCITED_NAME_0>!!!(?<NAME_21>Tal)!!!) - (?<NAME_22>Tal)", g.toRegex(pattern));
            Thread t = new Thread(() -> {
        GrokCaptureExtracter logsourceExtracter = namedConfig(grok, "logsource").nativeExtracter(new ThrowingNativeExtracterMap() {
        bank.put("NUMBER", "(?:%{BASE10NUM})");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        long[] id = new long[1];
        assertThat(fromGrok, equalTo(new TreeMap<>(nameToType)));
            "2001-12-07T23:54:60.123456Z" // '60' second is a leap second.
        assertEquals(expected, actual);
    }
                }
                Map.entry("response", INTEGER),
        Map<String, Object> actual = grok.captures(text);
                + ":((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:)))(%.+)?"
        expected.put("clientip", "83.149.9.216");
        boolean[] status = new boolean[1];
        assertEquals("GET", matches.get("verb"));
            Grok.BUILTIN_PATTERNS,
        Map<String, String> bank = new HashMap<>();
        BiConsumer<Long, Runnable> scheduler = getLongRunnableBiConsumer();
}
            bank.put("NAME", "!!!%{NAME:name:int}!!!");
        assertGrokedField("@metadata");
            + "kibana-dashboard3.png HTTP/1.1\" 200 171717 \"http://semicomplete.com/presentations/logstash-monitorama-2013/\" "
import java.util.concurrent.atomic.AtomicReference;
 * KIND, either express or implied.  See the License for the
            "%{NUMBER:value:int} %{NUMBER:value:long}",
    public void testUnicodeSyslog() {
    }
        expected.put("EXCITED_NAME_0", "!!!Tal!!!");
        @Override
        Map<String, Object> matches = grok.captures(logLine);
            throw new IllegalArgumentException();
import static org.opensearch.grok.GrokCaptureType.FLOAT;
                + "SPF permerror (Junk encountered in record 'v=spf1 mx a:mail.domain.no ip4:192.168.0.4 �all'): Envelope-from: "
        });
            @Override
        @SuppressWarnings("unchecked")
            new Grok(bank, pattern, false, logger::warn);
        BiConsumer<Long, Runnable> scheduler = getLongRunnableBiConsumer();
                throw new AssertionError(e);
import java.util.function.DoubleConsumer;
        Map<String, Object> expected = new HashMap<>();
            });
    }
            true
        Map<String, Object> actual = g.captures(text);
        assertEquals("2009-06-30T18:30:00+02:00", matches.get("syslog5424_ts"));
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "value", logger::warn);
                Map.entry("syslog_program", STRING),
        bank.put("BASE10NUM", "(?<![0-9.+-])(?>[+-]?(?:(?:[0-9]+(?:\\.[0-9]+)?)|(?:\\.[0-9]+)))");
        });
        assertEquals("grokdebug", matches.get("syslog5424_app"));
            logger::warn,
            "2001-11-06T20:45:45-0000",
        // Input with a name and three IPs
        expected.put("id", 20000000000L);
            )
        );
        Map<String, String> bank = new HashMap<>();
        });
        assertNotNull("Should have matches", matches);
        @SuppressWarnings("unchecked")
        assertEquals("Second IP should match", "192.168.1.2", ipList.get(1));
        assertCaptureConfig(grok, Map.of("duration", STRING));
    }
    public void assertNonAsciiLetterInFieldName() {
        Map<String, Object> matches = grok.captures(line);
    public void testNilCoercedValues() {
            public GrokCaptureExtracter forDouble(java.util.function.Function<DoubleConsumer, GrokCaptureExtracter> buildExtracter) {
        assertGrokedField("meta-data");
import java.util.function.IntConsumer;
        Grok g = new Grok(bank, pattern, logger::warn);
import static org.hamcrest.Matchers.nullValue;
        assertEquals("Malformed pattern [NAME1][!!!%{NAME2!!!]", e.getMessage());
        });
                + "d\\d|[1-9]?\\d)){3}))|:))|(([0-9A-Fa-f]{1,4}:){3}(((:[0-9A-Fa-f]{1,4}){1,4})|((:[0-9A-Fa-f]{1,4}){0,2}:((25[0-5]|2[0-4]"
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{NUMBER:n:int}", logger::warn);
            });
            bank.put("NAME1", "!!!%{NAME2!!!");
        assertEquals("circular reference in pattern [NAME2][!!!%{NAME1}!!!] back to pattern [NAME1]", e.getMessage());
    }
            grok,
                Map.entry("syslog5424_sd", STRING),
    private GrokCaptureConfig namedConfig(Grok grok, String name) {
            String pattern = "%{NAME1}";
            bank.put("NAME4", "!!!%{NAME5}!!!");
    }
            "2001-01-01T00:00:-1", // invalid second
    public void testSyslog5424Line() {
            MatcherWatchdog.newInstance(10, 200, System::currentTimeMillis, scheduler),
                Map.entry("clientip", STRING),
        String pattern = "%{NUMBER:bytes:float} %{NUMBER:status} %{NUMBER}";
    public void testNumericCapturesCoercion() {
        );
        assertEquals("Third IP should match", "192.168.1.3", ipList.get(2));
import org.opensearch.grok.GrokCaptureConfig.NativeExtracterMap;
        assertCaptureConfig(grok, Map.of("duration", FLOAT));
    }
            new Grok(bank, pattern, false, logger::warn);
    }
            bank.put("NAME1", "!!!%{NAME2}!!!");
            }
            bank.put("NAME1", "!!!%{NAME2}!!!");
                Map.entry("facility", STRING),
        String line = "fancy 12-12-12 12:12:12";
        assertCaptureConfig(
        Map<String, Object> expected = new HashMap<>();
        bank.put("IPORHOST", "(?:%{IP}|%{HOSTNAME})");
            "2001-01-01T00:00:00+2500", // invalid timezone
        utf8 = "10 11 12".getBytes(StandardCharsets.UTF_8);
        expected.put("verb", "GET");
            "2001-01-01T01:60:00", // invalid minute
            "IPV4",
            Grok.BUILTIN_PATTERNS,
        bank.put(
        );
        public GrokCaptureExtracter forLong(Function<LongConsumer, GrokCaptureExtracter> buildExtracter) {
        assertEquals(
    public void testMinusInFieldName() {
            assertThat(grok.match(msg), is(true));
            Map<String, String> bank = new TreeMap<>();
        e = expectThrows(IllegalArgumentException.class, () -> {
            "<%{POSINT:syslog_pri}>%{SPACE}%{SYSLOGTIMESTAMP:syslog_timestamp} "
 * specific language governing permissions and limitations
        assertThat(captureBytes(grok, utf8, 0, utf8.length), equalTo(Map.of("n", 10)));
 * compatible open source license.
            return extracter.result();
        List<Object> valueList = (List<Object>) value;
        });
        assertThat(grok.match("Test_Class.class"), is(true));
        );
        run.set(false);
    public void testISO8601() {
        assertEquals("24/Jul/2014:05:35:37 +0530", matches.get("timestamp"));
        Grok g = new Grok(bank, pattern, false, logger::warn);
    }
 * The OpenSearch Contributors require contributions made to
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{WORD:" + fieldName + "}", logger::warn);
        e = expectThrows(IllegalArgumentException.class, () -> {
                Map.entry("syslog5424_ts", STRING),
        });
        String text = "12009.34 200 9032";
    private void assertCaptureConfig(Grok grok, Map<String, GrokCaptureType> nameToType) {
        assertEquals("-", matches.get("auth"));
        expected.put("bytes", 12009.34f);
        // Test that multiple captures with the same field name are collected into a list
            "2001-00-01T00:00:00", // invalid month
    }
            public GrokCaptureExtracter forLong(Function<LongConsumer, GrokCaptureExtracter> buildExtracter) {
            e.getMessage()
 * Modifications Copyright OpenSearch Contributors. See
    }
        );
                + "YaBrowser/13.12.1599.12785 Safari/537.36\"",
    }
        return (delay, command) -> {
        String text = "12009.34 20000000000 4820.092";
        assertThat(grok.captures("nomatch"), nullValue());
        Map<String, Object> expected = new HashMap<>();
        @Override
        return grok.match(utf8, 0, utf8.length, extracter);
        e = expectThrows(IllegalArgumentException.class, () -> {
        String[] logsource = new String[1];
            throw new IllegalArgumentException();
        assertThat(rating[0], equalTo(4820.092));
        assertCaptureConfig(g, Map.of("name", STRING, "status", BOOLEAN));
        GrokCaptureExtracter ratingExtracter = namedConfig(g, "rating").nativeExtracter(new ThrowingNativeExtracterMap() {
        Map<String, Object> matches = grok.captures(line);
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, ".*\\[.*%{SPACE}*\\].*", message::set);
        });
                Map.entry("referrer", STRING),
        });
        bank.put("BASE10NUM", "(?<![0-9.+-])(?>[+-]?(?:(?:[0-9]+(?:\\.[0-9]+)?)|(?:\\.[0-9]+)))");
        Map<String, String> bank = new HashMap<>();
            new Grok(bank, pattern, false, logger::warn);
            "2001-01-01Ta0:00:00", // invalid hour
            Map<String, String> bank = new HashMap<>();
            String pattern = "%{NAME1}";
        Map<String, Object> actual = g.captures(text);
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "^%{TIMESTAMP_ISO8601}$", logger::warn);
/*
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "test (N/A|%{BASE10NUM:duration}ms)", logger::warn);
 * GitHub history for details.
import java.util.HashMap;
                + "(?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])[.](?:[0-1]?[0-9]{1,2}|2[0-4][0-9]|25[0-5]))(?![0-9])"
    }
            throw new IllegalArgumentException();
                Map.entry("timestamp", STRING),
        assertGrokedField("metad[a]ta");
        for (GrokCaptureConfig config : grok.captureConfig()) {
        assertEquals(expected, actual);
        assertGrokedField(randomAlphaOfLengthBetween(1, 5));
        assertEquals(null, matches.get("syslog5424_msgid"));
                Map.entry("httpversion", STRING),
        Grok grok = new Grok(
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "(?<timestamp>%{DATE_EU} %{TIME})", logger::warn);
        assertThat(captureBytes(grok, utf8, 6, 2), equalTo(Map.of("n", 12)));
                Map.entry("message", STRING),
    }
        BiConsumer<Long, Runnable> scheduler = getLongRunnableBiConsumer();
            "\\b(?:Jan(?:uary|uar)?|Feb(?:ruary|ruar)?|M(?:a|ä)?r(?:ch|z)?|Apr(?:il)?|Ma(?:y|i)?|Jun(?:e|i)"
            String pattern = "%{NAME}";
        Map<String, Object> matches = grok.captures(line);
            bank.put("NAME1", "!!!%{NAME2}!!!");
        assertThat(captureBytes(grok, utf8, 0, 1), equalTo(Map.of("n", 1)));
        Exception e = expectThrows(IllegalArgumentException.class, () -> {
        assertCaptureConfig(g, Map.of("bytes", FLOAT, "status", STRING));
            logger::warn
        bank.put(
            String pattern = "%{NAME1}";
        Grok grok = new Grok(
        List<String> ipList = (List<String>) ipaddress;
    }
        Map<String, Object> matches = grok.captures("Server has IPs: 192.168.1.1, 192.168.1.2 and 192.168.1.3");
        assertGrokedField(randomIntBetween(0, 100) + randomAlphaOfLengthBetween(1, 5));
        assertEquals("First value should be an Integer", Integer.valueOf(123), valueList.get(0));
            public GrokCaptureExtracter forBoolean(Function<Consumer<Boolean>, GrokCaptureExtracter> buildExtracter) {
        GrokCaptureExtracter bytesExtracter = namedConfig(g, "bytes").nativeExtracter(new ThrowingNativeExtracterMap() {
            Map.ofEntries(
        assertEquals("/logs/access.log", matches.get("request"));
    }
                + "(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))|(:(((:[0-9A-Fa-f]{1,4}){1,7})|((:[0-9A-Fa-f]{1,4}){0,5}"
 * software distributed under the License is distributed on an
        expected.put("ident", "-");
        assertEquals("circular reference in pattern [NAME][!!!%{NAME:name:int}!!!]", e.getMessage());
        bank.put("QS", "(?>(?<!\\\\)(?>\"(?>\\\\.|[^\\\\\"]+)+\"|\"\"|(?>'(?>\\\\.|[^\\\\']+)+')|''|(?>`(?>\\\\.|[^\\\\`]+)+`)|``))");
            Map<String, String> bank = new TreeMap<>();
        assertThat(grok.captures("prefix_value"), equalTo(Map.of()));
                Map.entry("clientip", STRING),
        assertEquals(null, matches.get("duration"));
import java.util.concurrent.atomic.AtomicBoolean;
        Grok grok = new Grok(
        Grok grok = new Grok(bank, pattern, logger::warn);
        );
        }
        bank.put("SINGLEDIGIT", "[0-9]");
        Grok g = new Grok(Grok.BUILTIN_PATTERNS, pattern, logger::warn);
        assertCaptureConfig(grok, Map.of("foo", STRING));
        List<String> timeMessages = Arrays.asList(
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{WORD:unsuppo(r)ted}", logger::warn);
        Map<String, String> bank = new HashMap<>();
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{DATE_EU:stimestamp}", logger::warn);
        bank.put("SECOND", "(?:(?:[0-5]?[0-9]|60)(?:[:.,][0-9]+)?)");
        // Input with two different numbers
        assertEquals("Second value should be a Long", Long.valueOf(456), valueList.get(1));
            Map.ofEntries(
    public void testLogCallBack() {
    }
        bank.put("INT", "(?:[+-]?(?:[0-9]+))");
public class GrokTests extends OpenSearchTestCase {
        assertEquals(28.4f, matches.get("duration"));
        assertEquals(
        @Override
        assertCaptureConfig(
    public void testNumericCaptures() {
            "%{IP:ipaddress} %{IP:ipaddress}",
        Object ip = matches.get("ip");
    }
        String pattern = "%{WORD:name}=%{WORD:status:boolean}";
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "^%{TIMESTAMP_ISO8601}$", logger::warn);
 * under the License.
            new Grok(bank, pattern, false, logger::warn);
            Map.ofEntries(
    public void testNamedFieldsWithWholeTextMatch() {
                Map.entry("syslog_pid", STRING),
            assertThat(grok.match(msg), is(false));
        Map<String, Object> matches = grok.captures("line");
import static org.opensearch.grok.GrokCaptureType.STRING;
        assertGrokedField(randomAlphaOfLengthBetween(1, 5) + randomIntBetween(0, 100));
            bank.put("NAME1", "!!!%{NAME2:!!!");
import org.opensearch.test.OpenSearchTestCase;
        Grok g = new Grok(bank, pattern, logger::warn);
                Map.entry("timestamp", STRING),
        assertThat(bytes[0], equalTo(12009.34f));
        assertThat(specificCapture(g, text, statusExtracter), is(true));
        @Override
        Map<String, Object> matches = grok.captures(line);
        Map<String, Object> expected = new HashMap<>();
            throw new IllegalArgumentException();
 * not use this file except in compliance with the License.
        );
        assertEquals("[id1 foo=\\\"bar\\\"][id2 baz=\\\"something\\\"]", matches.get("syslog5424_sd"));
 * this file be licensed under the Apache-2.0 license or a
            bank.put("NAME", "!!!%{NAME}!!!");
    }
        bank.put("NUMBER", "(?:%{BASE10NUM})");
    public void testNoNamedCaptures() {
                Map.entry("syslog5424_app", STRING),
            )
    }
        String pattern = "%{EXCITED_NAME} - %{NAME}";
        for (String msg : timeMessages) {
            t.start();
            Grok.BUILTIN_PATTERNS,
                Map.entry("ident", STRING),
                Map.entry("timestamp8601", STRING)
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "test (N/A|%{BASE10NUM:duration:float}ms)", logger::warn);
        bank.put("BASE10NUM", "(?<![0-9.+-])(?>[+-]?(?:(?:[0-9]+(?:\\.[0-9]+)?)|(?:\\.[0-9]+)))");
            true
            }
            bank.put("NAME2", "!!!%{NAME3}!!!");
        assertEquals("Hello, syslog.", matches.get("syslog5424_msg"));
            grok,
            String pattern = "%{NAME1}";
        Map<String, GrokCaptureType> fromGrok = new TreeMap<>();
        );
    public void testMalformedPattern() {
            Map<String, String> bank = new TreeMap<>();
        GrokCaptureExtracter statusExtracter = namedConfig(g, "status").nativeExtracter(new ThrowingNativeExtracterMap() {
        String text = "active=true";
        assertCaptureConfig(
    public void testMultipleCapturesWithSameFieldName() {
        assertNotNull("Should have matches", matches);
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "(?<foo>\\w+)", logger::warn);
        expected.put("bytes", 12009.34f);
                Map.entry("verb", STRING)
            grokPattern,
 * Unless required by applicable law or agreed to in writing,
        AtomicReference<String> message = new AtomicReference<>();
import java.util.List;
    }
        assertThat(status[0], equalTo(true));
                Map.entry("referrer", STRING),
            "2001-01-32T00:00:00", // invalid day
            "2001-11-06T20:45:45.123456-0000",
        matches = grok.captures("test N/A");
                    command.run();
    }
        bank.put("NUMBER", "(?:%{BASE10NUM})");
        assertEquals("\"http://8rursodiol.enjin.com\"", matches.get("referrer"));
    }
            "2001-13-01T00:00:00", // invalid month
    public void testSimpleSyslogLine() {
        Map<String, Object> matches = grok.captures("test 28.4ms");
        assertCaptureConfig(g, Map.of("f", STRING));
    public void testNoMatchingPatternInDictionary() {
        expected.put("name", "active");
    public void testCircularReference() {
        assertEquals("Should have 3 IPs", 3, ipList.size());
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{COMBINEDAPACHELOG}", logger::warn);
                return buildExtracter.apply(l -> id[0] = l);
        });
    public void testGarbageTypeNameBecomesString() {
        expected.put("status", true);
        // Pattern with repeated capture groups for the same field with different types
        bank.put("EXCITED_NAME", "!!!%{NAME:name}!!!");
            new Grok(bank, pattern, false, logger::warn);
        assertThat(g.captures("12009.34"), equalTo(Map.of("f", "12009.34")));
    }
            "2001-01-01T00:00:00-25", // invalid timezone
        return null;
            Map.ofEntries(
        expected.put("response", 200);
            Map<String, String> bank = new HashMap<>();
                Map.entry("agent", STRING),
        assertEquals("postfix/smtpd", matches.get("program"));
            @Override
            Map.ofEntries(
        bank.put("WORD", "\\b\\w+\\b");
            String pattern = "%{NAME}";
import static org.hamcrest.Matchers.equalTo;
        bank.put("USER", "[a-zA-Z0-9._-]+");
        });
            new Grok(bank, pattern, false, logger::warn);
            e.getMessage()
        e = expectThrows(IllegalArgumentException.class, () -> {
        assertEquals(null, matches.get("duration"));
    public void testDatePattern() {
            String pattern = "%{NAME1}";
            "2001-01-01T00:00:00.123456",
    }
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{SYSLOG5424LINE}", logger::warn);
            "2001-01-01T0:00:00", // invalid hour
 *
        assertEquals("circular reference in pattern [NAME][!!!%{NAME:name}!!!]", e.getMessage());
        String logLine = "31.184.238.164 - - [24/Jul/2014:05:35:37 +0530] \"GET /logs/access.log HTTP/1.0\" 200 69849 "
 * license agreements. See the NOTICE file distributed with
        assertEquals(line, matches.get(fieldName));
        float[] bytes = new float[1];
 *
        );
        assertThat(captureBytes(grok, utf8, 0, 2), equalTo(Map.of("n", 10)));
        assertCaptureConfig(g, Map.of("EXCITED_NAME_0", STRING, "NAME_21", STRING, "NAME_22", STRING));
import static org.hamcrest.Matchers.is;
    public void assertSquareBracketInFieldName() {
                Map.entry("response", STRING),
                Map.entry("logsource", STRING),
            new Grok(bank, pattern, false, logger::warn);
            public GrokCaptureExtracter forFloat(Function<FloatConsumer, GrokCaptureExtracter> buildExtracter) {
        assertThat(matches.get("foo"), equalTo("hello"));
        assertThat(matches.get("stimestamp"), equalTo("11/01/01"));
        assertThat(matches.get("syslog_program"), equalTo("postfix/policy-spf"));
            + "HTTP/%{NUMBER:httpversion}\" %{NUMBER:response:int} (?:-|%{NUMBER:bytes:int}) %{QS:referrer} %{QS:agent}";
            "2001-01-01T00:00:aa", // invalid second
        );
            String pattern = "%{NAME1}";
        assertEquals("paxton.local", matches.get("syslog5424_host"));
        String line = "foo";
                Map.entry("pid", STRING),
                Map.entry("request", STRING),
                Map.entry("program", STRING),
        assertEquals("connect from camomile.cloud9.net[168.100.1.3]", matches.get("message"));
        assertEquals("Malformed pattern [NAME1][!!!%{NAME2:!!!]", e.getMessage());
        bank.put("DATA", ".*?");
        Grok grok = new Grok(
        );
            "2001-01-01T00:00:00+", // invalid timezone
    }
            Map<String, String> bank = new TreeMap<>();
            logger::warn,
            bank.put("NAME3", "!!!%{NAME4}!!!");
            bank.put("NAME", "!!!%{NAME:name}!!!");
 * Licensed to Elasticsearch under one or more contributor
 */
        String pattern = "%{IPORHOST:clientip} %{USER:ident} %{USER:auth} \\[%{HTTPDATE:timestamp}\\] \"%{WORD:verb} %{DATA:request} "
    public void testApacheLog() {
        assertEquals("31.184.238.164", matches.get("clientip"));
                + "%{SYSLOGHOST:syslog_hostname} %{PROG:syslog_program}(:?)(?:\\[%{GREEDYDATA:syslog_pid}\\])?(:?) "
    private static BiConsumer<Long, Runnable> getLongRunnableBiConsumer() {
            new Grok(bank, pattern, false, logger::warn);
            Map<String, String> bank = new HashMap<>();
                + "{1,5})"
        };
import java.util.Map;
        String pattern = "%{NUMBER:f:not_a_valid_type}";
                + "{1,2})|:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:)"
            t.start();
            } catch (InterruptedException e) {
    }
    }
        assertGrokedField(String.valueOf(randomIntBetween(0, 100)));
        byte[] utf8 = "10".getBytes(StandardCharsets.UTF_8);
                Map.entry("httpversion", STRING),
            "agent",
        e = expectThrows(IllegalArgumentException.class, () -> {
                }
 */
            "2001-01-00T00:00:00", // invalid day
            "2010-05-03T08:18:18+00:00",
    }
        e = expectThrows(IllegalArgumentException.class, () -> {
import java.util.function.Consumer;
            "2001-01-aT00:00:00", // invalid day
                Map.entry("syslog_pri", STRING),
    }
                Map.entry("priority", STRING),
            "2001-01-01T00:00:00",
            grok,
            "2001-12-07T23:54:54.123456Z",
        assertEquals("1713", matches.get("pid"));
                Map.entry("syslog5424_host", STRING),
        assertEquals("1", matches.get("syslog5424_ver"));
        Map<String, Object> matches = grok.captures("123 456");
    }
        expected.put("bytes", 171717);
import static org.opensearch.grok.GrokCaptureType.BOOLEAN;
        Map<String, Object> matches = grok.captures("test 28.4ms");
            } catch (InterruptedException e) {
    public void testUnsupportedBracketsInFieldName() {
                + "email@domain.no"
                Thread.sleep(delay);
        Map<String, Object> matches = grok.captures("hello world");
        expected.put("request", "/presentations/logstash-monitorama-2013/images/kibana-dashboard3.png");
        assertThat(id[0], equalTo(20000000000L));
        Object value = matches.get("value");
                Map.entry("verb", STRING)
            }
            "\"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/30.0.1599.12785 "
        );
        Object actual = g.captures(text);
        });
        assertThat(message.get(), containsString("regular expression has redundant nested repeat operator"));
            bank.put("NAME5", "!!!%{NAME1}!!!");
                Map.entry("syslog5424_pri", STRING),
            String pattern = "%{NAME1}";
            }
        String logLine = "Bonsuche mit folgender Anfrage: Belegart->[EINGESCHRAENKTER_VERKAUF, VERKAUF, NACHERFASSUNG] "
/*
        AtomicBoolean run = new AtomicBoolean(true); // to avoid a lingering thread when test has completed
        Map<String, String> bank = new HashMap<>();
        );
                Map.entry("request", STRING),
        }
        assertThat(grok.captures("12"), equalTo(expected));
                Map.entry("syslog5424_msgid", STRING),
        }
        );
    public void testDotInFieldName() {
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{JAVAFILE}", logger::warn);
        assertThat(specificCapture(g, text, ratingExtracter), is(true));
                + "{4}(((:[0-9A-Fa-f]{1,4}){1,3})|((:[0-9A-Fa-f]{1,4})?:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\"
        bank.put("HOUR", "(?:2[0123]|[01]?[0-9])");
            "<22>Jan  4 07:50:46 mailmaster postfix/policy-spf[9454]: : "
    private abstract class ThrowingNativeExtracterMap implements NativeExtracterMap<GrokCaptureExtracter> {
        assertGrokedField("[m]etadata");
                Map.entry("auth", STRING),
            }
        assertGrokedField("metadat[a]");
        assertEquals("circular reference in pattern [NAME2][!!!%{NAME2}!!!]", e.getMessage());
            + "Chrome/30.0.1599.12785 YaBrowser/13.12.1599.12785 Safari/537.36\" \"www.dlwindianrailways.com\"";
        Map<String, Object> matches = grok.captures("11/01/01");
import static org.opensearch.grok.GrokCaptureType.INTEGER;
                Map.entry("syslog5424_msg", STRING),
        assertGrokedField("meta_data");
            }
        assertCaptureConfig(grok, Map.of("stimestamp", STRING));
        assertNull(matches);
        expected.put("NAME_22", "Tal");
import java.util.Collections;
        assertGrokedField("meta.data");
                    command.run();
            "\"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) "
        assertCaptureConfig(grok, Map.of("timestamp", STRING));
                Map.entry("syslog5424_proc", STRING),
        assertThat(e.getMessage(), equalTo("Unable to find pattern [NOTFOUND] in Grok's pattern dictionary"));
        expected.put("num", "1");
                Map.entry("ident", STRING),
 * this work for additional information regarding copyright
        byte[] utf8 = str.getBytes(StandardCharsets.UTF_8);
            "2001-01-1aT00:00:00", // invalid day
            + "Hello, syslog.";
        assertThat(captureBytes(grok, utf8, 3, 2), equalTo(Map.of("n", 11)));
            "2001-09-05T16:36:36+0000",
        public GrokCaptureExtracter forDouble(Function<DoubleConsumer, GrokCaptureExtracter> buildExtracter) {
    public void testNilWithNoCoercion() {
        assertGrokedField("metädata");
        String pattern = "%{NUMBER:bytes:float} %{NUMBER:id:long} %{NUMBER:rating:double}";
        assertEquals(
        String line = "Mar 16 00:01:25 evita postfix/smtpd[1713]: connect from camomile.cloud9.net[168.100.1.3]";
        assertThat(logsource[0], equalTo("evita"));
import java.util.function.BiConsumer;
        assertEquals("Name should match", "Server", matches.get("name"));
        }
        if (grok.match(utf8, offset, length, extracter)) {
    }
        }
            + "\"Mozilla"
import static org.opensearch.grok.GrokCaptureType.DOUBLE;
            Object old = fromGrok.put(config.name(), config.type());
        expected.put(
    public void testExponentialExpressions() {
        assertTrue("Should be a List", value instanceof List);
        assertEquals("First IP should match", "192.168.1.1", ipList.get(0));
            MatcherWatchdog.newInstance(10, 200, System::currentTimeMillis, scheduler),
                Map.entry("syslog_timestamp", STRING)
        assertTrue("Should be a List", ipaddress instanceof List);
            "2001-01-01T00:00:00-2500", // invalid timezone
            Thread t = new Thread(() -> {
        assertThat(grok.captures("no_match"), nullValue());
                Map.entry("bytes", STRING),
    public void testBooleanCaptures() {
        Exception e = expectThrows(IllegalArgumentException.class, () -> {
        assertThat(matches.get("syslog_pri"), equalTo("22"));
        Grok grok = new Grok(
    public void testNotISO8601() {
        Grok g = new Grok(bank, pattern, logger::warn);
            "((([0-9A-Fa-f]{1,4}:){7}([0-9A-Fa-f]{1,4}|:))|(([0-9A-Fa-f]{1,4}:){6}(:[0-9A-Fa-f]{1,4}|((25[0-5]|2[0-4]"
 * the Apache License, Version 2.0 (the "License"); you may
        // Input with two different IP addresses
            Grok.BUILTIN_PATTERNS,
    public void testWithOniguramaNamedCaptures() {
            bank.put("NAME3", "!!!%{NAME1}!!!");
import java.util.Arrays;
            logger::warn
            Map<String, String> bank = new HashMap<>();
        expected.put("timestamp", "19/Jul/2015:08:13:42 +0000");
/*
        assertCaptureConfig(g, Map.of("bytes", FLOAT, "id", LONG, "rating", DOUBLE));
            Map<String, String> bank = new HashMap<>();
        }
        public GrokCaptureExtracter forInt(Function<IntConsumer, GrokCaptureExtracter> buildExtracter) {
    public void testCaputuresBytes() {
 *
        assertEquals(true, g.match(text));
        Map<String, Object> expected = new HashMap<>();
        Object ipaddress = matches.get("ipaddress");
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{JAVACLASS}", logger::warn);
        assertEquals("Mar 16 00:01:25", matches.get("timestamp"));
        assertEquals("circular reference in pattern [NAME][!!!%{NAME}!!!]", e.getMessage());
            String pattern = "%{NAME}";
    }
            bank.put("NAME2", "!!!%{NAME3}!!!");
            bank.put("NAME2", "!!!%{NAME2}!!!");
            @Override
        matches = grok.captures("test N/A");
            + "/5.0 (Macintosh; Intel Mac OS X 10_9_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/32.0.1700.77 Safari/537.36\"";
        assertEquals(expected, actual);
            "circular reference in pattern [NAME5][!!!%{NAME1}!!!] back to pattern [NAME1] " + "via patterns [NAME1=>NAME2=>NAME3=>NAME4]",
    public void testJavaFilePatternWithSpaces() {
            bank.put("NAME2", "!!!%{NAME1}!!!");
        grok.match("[foo]");
        bank.put("NAME", "Tal");
        assertEquals("12-12-12 12:12:12", matches.get("timestamp"));
        bank.put("BASE10NUM", "(?<![0-9.+-])(?>[+-]?(?:(?:[0-9]+(?:\\.[0-9]+)?)|(?:\\.[0-9]+)))");
            @Override
        AtomicBoolean run = new AtomicBoolean(true);
        for (String msg : timeMessages) {
    }
        e = expectThrows(IllegalArgumentException.class, () -> {
 * ownership. Elasticsearch licenses this file to you under
                bank.put("NAME" + i, "!!!%{NAME" + (i + 1) + "}!!!");
                return buildExtracter.apply(b -> status[0] = b);
            try {
            logger::warn,
        BiConsumer<Long, Runnable> scheduler = (delay, command) -> {
        );
        expected.put("referrer", "\"http://semicomplete.com/presentations/logstash-monitorama-2013/\"");
        Exception e = expectThrows(RuntimeException.class, () -> grok.captures(logLine));
        Grok grok = new Grok(bank, "%{SINGLEDIGIT:num}%{SINGLEDIGIT:num}", logger::warn);
            "2001-01-01T00:00:00-00:61" // invalid timezone
            }
                return buildExtracter.apply(str -> logsource[0] = str);
                if (run.get()) {
    }
    }
        expected.put("status", "200");
        Map<String, Object> actual = g.captures(text);
        assertThat(specificCapture(grok, line, logsourceExtracter), is(true));
        );
                + "?|Jul(?:y)?|Aug(?:ust)?|Sep(?:tember)?|O(?:c|k)?t(?:ober)?|Nov(?:ember)?|De(?:c|z)(?:ember)?)\\b"
        assertEquals("Second IP should match", "192.168.1.2", ipList.get(1));
        });
            assertThat("duplicates not allowed", old, nullValue());
        assertThat(grok.captures("value"), equalTo(Map.of()));
        assertCaptureConfig(grok, Map.of());
                Map.entry("syslog_message", STRING),
            MatcherWatchdog.newInstance(10, 200, System::currentTimeMillis, scheduler),
        String text = "wowza !!!Tal!!! - Tal";
            )
            "2004-07-04T12:27:27.123456-00:00",
            + "\"http://8rursodiol.enjin.com\" \"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) "
                Map.entry("syslog5424_ver", STRING)
            "2001-01-01T00:00:00A", // invalid timezone
import java.nio.charset.StandardCharsets;
        assertEquals("191", matches.get("syslog5424_pri"));
        }
        assertEquals("200", matches.get("response"));
        });
                return buildExtracter.apply(f -> bytes[0] = f);
            "2001-12-07T23:54:54Z",
                Map.entry("timestamp", STRING),
    public void testMultipleNamedCapturesWithSameName() {
        Grok grok = new Grok(Grok.BUILTIN_PATTERNS, "%{SYSLOGLINE}", logger::warn);
        List<String> timeMessages = Arrays.asList(
                + "|((:[0-9A-Fa-f]{1,4}){0,3}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3}))|:))"
        };
                + "\\d|1\\d\\d|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)){3})|:))|(([0-9A-Fa-f]{1,4}:){5}(((:[0-9A-Fa-f]{1,4})"
        bank.put("TIME", "(?!<[0-9])%{HOUR}:%{MINUTE}(?::%{SECOND})(?![0-9])");
                Map.entry("auth", STRING),
        return grok.captureConfig().stream().filter(i -> i.name().equals(name)).findFirst().get();
        expected.put("httpversion", "1.1");
        List<String> ipList = (List<String>) ip;
        @SuppressWarnings("unchecked")
        // Test a more complex pattern with multiple captures of the same field
            matches.get("agent")
            "%{WORD:name} has IPs: %{IP:ip}, %{IP:ip} and %{IP:ip}",
 *    http://www.apache.org/licenses/LICENSE-2.0
            "2010-05-03T08:18:18.123456+00:00",
        expected.put("rating", 4820.092);
 */
package org.opensearch.grok;
            true
            MatcherWatchdog.newInstance(10, 200, System::currentTimeMillis, scheduler),
    }
                + "|(([0-9A-Fa-f]{1,4}:){1}(((:[0-9A-Fa-f]{1,4}){1,6})|((:[0-9A-Fa-f]{1,4}){0,4}:((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)"
            "circular reference in pattern [NAME3][!!!%{NAME1}!!!] back to pattern [NAME1] via patterns [NAME1=>NAME2]",
        assertEquals(expected, actual);
        double[] rating = new double[1];
        Map<String, String> bank = new HashMap<>();
                Map.entry("syslog_hostname", STRING),
        e = expectThrows(IllegalArgumentException.class, () -> {
        @Override
import static org.opensearch.grok.GrokCaptureType.LONG;
import java.util.function.Function;
                if (run.get()) {
                throw new AssertionError(e);
    public void testAtInFieldName() {
    private boolean specificCapture(Grok grok, String str, GrokCaptureExtracter extracter) {
            "1974-03-02T04:09:09.123456",
    private Map<String, Object> captureBytes(Grok grok, byte[] utf8, int offset, int length) {
            "1974-03-02T04:09:09",
        bank.put("TEST", "hello world");
        assertCaptureConfig(grok, Map.of());
                Map.entry("rawrequest", STRING),
            throw new IllegalArgumentException();
        public GrokCaptureExtracter forFloat(Function<FloatConsumer, GrokCaptureExtracter> buildExtracter) {
        expected.put("NAME_21", "Tal");
        });
                Map.entry("agent", STRING),
            )
        Map<String, String> bank = new HashMap<>();
        assertEquals("Pattern references exceeded maximum depth of 500", e.getMessage());
            grok,
        );
            Map<String, String> bank = new TreeMap<>();
        bank.put(
        bank.put("MONTHDAY", "(?:(?:0[1-9])|(?:[12][0-9])|(?:3[01])|[1-9])");
        bank.put("IP", "(?:%{IPV6}|%{IPV4})");
        }
    public void testMultipleCapturesWithSameFieldNameInComplexPattern() {
        assertEquals("1.0", matches.get("httpversion"));
        bank.put("YEAR", "(?>\\d\\d){1,2}");
 * SPDX-License-Identifier: Apache-2.0
    public void testAlphanumericFieldName() {
        Exception e = expectThrows(IllegalArgumentException.class, () -> new Grok(Collections.emptyMap(), "%{NOTFOUND}", logger::warn));
        assertEquals(expected, actual);
        assertThat(specificCapture(g, text, idExtracter), is(true));
        assertEquals(null, matches.get("port"));
        bank.put("HTTPDATE", "%{MONTHDAY}/%{MONTH}/%{YEAR}:%{TIME} %{INT}");
        bank.put("NUMBER", "(?:%{BASE10NUM})");
            "2004-07-04T12:27:27-00:00",
                Thread.sleep(delay);
    private void assertGrokedField(String fieldName) {
    public void testMultipleCapturesWithSameFieldNameDifferentTypes() {
import static org.hamcrest.Matchers.containsString;
        assertCaptureConfig(
            new Grok(bank, pattern, false, logger::warn);
        GrokCaptureExtracter.MapExtracter extracter = new GrokCaptureExtracter.MapExtracter(grok.captureConfig());
