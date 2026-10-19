            analysisRegistry.buildTokenizerFactories(indexSettings),
     * generate a random TimeZone from the ones available in java.time
import org.apache.lucene.tests.util.LuceneTestCase.SuppressCodecs;  
import org.opensearch.common.util.MockBigArrays;
    static {
     */
    public void removeHeaderWarningAppender() {
        // methods failed, in which case threadContext might not have been
        }
    /**
    }  
     * Convenience method to assert warnings for settings deprecations and general deprecation warnings.
                            + "See the breaking changes documentation for the next major version."  
    public final void ensureCheckIndexPassed() {
     * a {@link Version} argument which will be used to write and read back the object.  
    @BeforeClass  
     * {@link XContentType}. Wraps the output into a new anonymous object according to the value returned
     */
        }
                    }
        T original,
            return new Statement() {
    public static int randomInt() {
                boolean allAssumption = true;
     */
        // In case you've forgotten your high-school studies, log10(x) / log10(y) == log y(x)  
        return things;
        int end = name.lastIndexOf('}');
    }
    );
    public static <T> List<T> randomList(int minListSize, int maxListSize, Supplier<T> valueConstructor) {
    @SuppressWarnings("unchecked")  
    public static <T> T randomFrom(Collection<T> collection) {
        return xContent.createParser(xContentRegistry(), LoggingDeprecationHandler.INSTANCE, data);
    }
        // some tests use MockTransportService to do network based testing. Yet, we run tests in multiple JVMs that means  
        T randomValue = null;
        // This is safe as long as we have fewer than 224 Gradle workers running in parallel  
            if (v4) {
        assertEquals(expected.length, actual.length);
    /** Return consistent index settings for the provided index version. */
     */
        for (String key : keys) {
            startAt = 0; // IDE
     */
                equalTo(0)
     * The {@link NamedWriteableRegistry} to use for this test. Subclasses should override and use liberally.
@TimeoutSuite(millis = 20 * TimeUnits.MINUTE)
                        k -> "["  
                String message = event.getMessage().getFormattedMessage();
    /**
        T original,
                terminated &= ThreadPool.terminate(service, 10, TimeUnit.SECONDS);  
                "Can\'t pick " + size + " random objects from a collection of " + collection.size() + " objects"  
     * Modify this random generator if a wider range for BigIntegers is necessary.
        // Log4j will write out status messages indicating problems with the Log4j usage to the status logger; we hook into this logger and
        }
    /**
    }
            Map<String, TokenFilterFactory> tokenFilter,  
 * ownership. Elasticsearch licenses this file to you under  
    @Before  
    }
            sum += sleepTimeInMillis;
     *  
    /**
    /**
            super(ASCII_SET);
        return copyNamedWriteable(original, namedWriteableRegistry, categoryClass, Version.CURRENT);
    protected final void assertWarnings(String... expectedWarnings) {
        return MockNioTransportPlugin.MOCK_NIO_TRANSPORT_NAME;  
                return reader.read(in);
    @BeforeClass  
    public static <T> T[] randomArray(int maxArraySize, IntFunction<T[]> arrayConstructor, Supplier<T> valueConstructor) {  
            }  
        public final Map<String, TokenFilterFactory> tokenFilter;  
        try {
        return random().nextDouble();
    protected final void allowedWarnings(String... allowedWarnings) {
import org.opensearch.common.io.PathUtils;  
        double result = 0.0;
        NamedWriteableRegistry namedWriteableRegistry,  
        public GeohashGenerator() {  
    /**  
    // Test facilities and facades for subclasses.
        }
                LoggingDeprecationHandler.INSTANCE,  
            .build();
        long timeInMillis = 1;
    }
        long maxTimeInMillis = TimeUnit.MILLISECONDS.convert(maxWaitTime, unit);
        public Statement apply(Statement base, Description description) {
    protected static final NamedWriteableRegistry DEFAULT_NAMED_WRITABLE_REGISTRY = new NamedWriteableRegistry(
 * compatible open source license.
     * to build IndexAnalyzers. This is only for testing since in production we only need the  
                    .map(
    "LuceneFixedGap",
    /**  
     * Creates an IndexAnalyzers with a single default analyzer  
        return randomFrom(formatNames).getSnakeCaseName();  
            ? RemoteStoreEnums.PathType.FIXED
                    } catch (IOException ioe) {
     * Create a new {@link XContentParser}.  
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
        List<String> javaZoneIds = new ArrayList<>(ZoneId.getAvailableZoneIds());
        final T[] array = arrayConstructor.apply(size);  
        }  
            }
                    }  
            .getSetting(remoteStoreIndex, IndexMetadata.SETTING_INDEX_UUID);
    "Lucene90",
        return generateRandomStringArray(maxArraySize, stringSize, allowNull, true);  
    ) throws IOException {
                 *
                nettyLoggedLeaks.clear();
import org.opensearch.index.analysis.AnalyzerScope;  
        long sum = 0;  
            final List<String> actualWarnings = threadContext.getResponseHeaders().get("Warning");
                        if (sd.getThrowable() != null) {
// we suppress pretty much all the lucene codecs for now, except asserting  
                : null
                targetList.add(value);  
 * SPDX-License-Identifier: Apache-2.0
    // so that all accesses are plumbed thru any mock wrappers
        }
import org.apache.logging.log4j.core.LogEvent;
    public static boolean terminate(ExecutorService... services) {
    public static BigInteger randomBigInteger() {  
        ToXContent.Params params,
    public static DateTimeZone randomDateTimeZone() {
                result = Double.longBitsToDouble(randomLong());
    }
     * @see #randomByte()
            .filter(s -> DateUtils.DEPRECATED_SHORT_TZ_IDS.contains(s) == false)
                byte[] ipv6 = new byte[16];
    }  
        while (sum + timeInMillis < maxTimeInMillis) {
                            pw.println("Throwable:");  
        return randomValueOtherThanMany(v -> Objects.equals(input, v), randomSupplier);
        long maxTimeInMillis = TimeUnit.MILLISECONDS.convert(maxWaitTime, unit);
    }
        BytesReference bytes = XContentHelper.toXContent(toXContent, xContentType, params, humanReadable);
                    + " unexpected warnings\nExpected: "
    "Memory",
        return absPaths;  
 * under the License.  
    "Compressing",
        @Override
        if (threadContext != null) {
        if (randomBoolean()) {
        return RandomizedTest.randomUnicodeOfCodepointLengthBetween(minCodePoints, maxCodePoints);  
 *  
        for (int i = 0; i < array.length; i++) {
        while ((elapsed = (System.nanoTime() - start)) < nanosecondsInMillisecond) {
        Writeable.Reader<T> reader,
import org.opensearch.index.analysis.AnalysisRegistry;
    public final void ensureAllSearchContextsReleased() throws Exception {
import org.opensearch.test.junit.listeners.LoggingListener;
        return createParser(xContentRegistry(), xContent, data);  
            Configurator.shutdown(context);
            public void append(LogEvent event) {  
            }  
     */
                "Found "  
     * as the first argument. In contrast to  
    private static boolean isUnusableLocale() {
    }
                List<String> filteredWarnings = new ArrayList<>(warnings);
                            + k
    /**
                        pw.print(sd.getLevel());
     */
            try {
    @SuppressForbidden(reason = "force log4j and netty sysprops")  
        return start + (startAt * 100);
            }
        } finally {  
            } else {
            try {  
        final Set<String> actualWarningValues = actualWarnings.stream()  
        );
import org.junit.internal.AssumptionViolatedException;
                );
                random().nextBytes(ipv6);
    public static Settings.Builder warmIndexSettings(Version version) {
     * use {@link OpenSearchTestCase#assertBusy(CheckedRunnable)} instead.  
    }
                    OpenSearchTestCase.this.afterIfFailed(errors);
    // mockdirectorywrappers currently set this boolean if checkindex fails  
     * @return the last value returned by <code>breakSupplier</code>  
                + "\nExpected: "
        // lifespan of the daemon this means that they can get larger than the allowed port range.
    /**
    }  
        this.headerWarningAppender = HeaderWarningAppender.createAppender("header_warning", null);
        JAVA_TIMEZONE_IDS = Collections.unmodifiableList(javaTZIds);
        return array;
    public static double randomDouble() {
    public static Class<? extends Plugin> getTestTransportPlugin() {  
                + Arrays.asList(expectedWarnings)  
        return true;
                    if (false == error instanceof AssumptionViolatedException) {
    }
        String[] array = new String[arraySize];
        // because after methods are still called in the event that before
     * lots of repeats. Make sure that the items properly implement equals and hashcode.
     * @param breakSupplier determines whether to return immediately or continue waiting.  
        // we override LTC behavior here: wrap even resources with mockfilesystems,
        return randomLong == Long.MIN_VALUE ? 0 : Math.abs(randomLong);
    private void assertWarnings(boolean stripXContentPosition, List<String> actualWarnings, String[] expectedWarnings) {
            throw e;
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {  
     * @param start          lower bound of interval to draw uniformly distributed random numbers from  
 *
            expectedWarnings.length,  
     * recursive shuffling behavior can be made by passing in the names of fields which  
        Requests.INDEX_CONTENT_TYPE = randomFrom(XContentType.values());  
    public static boolean inFipsJvm() {  
import org.opensearch.core.common.io.stream.Writeable;
import java.util.Collection;
import org.opensearch.transport.nio.MockNioTransportPlugin;
            HeaderWarning.setThreadContext(threadContext);  
import org.opensearch.core.xcontent.XContentBuilder;
                assertThat(  
    protected final void assertWarnings(boolean stripXContentPosition, String... expectedWarnings) {
                    empty()  
    /**  
import java.util.Locale;
        // Ephemeral ports on Linux start at 32768 so we modulo to make sure that we don't exceed that.
        return RandomizedTest.randomAsciiOfLengthBetween(minCodeUnits, maxCodeUnits);
            final long workerId = Long.valueOf(workerIdStr);  
    public static void setContentType() throws Exception {
     * result and we don't even expose it there.
import org.opensearch.common.util.concurrent.ThreadContext;
import org.opensearch.cluster.ClusterModule;  
        long sum = 0;  
    public static void restoreFileSystem() throws Exception {  
        // "clear" context by stashing current values and dropping the returned StoredContext  
    /**
        assert startAt >= 0 : "Unexpected test worker Id, resulting port range would be negative";
                        pw.print(":");
     * The port number starts at 0 and is reset after each test suite run.
import com.carrotsearch.randomizedtesting.rules.TestRuleAdapter;
        return type.path(pathInput, hashAlgorithm);
     */  
        DeprecatedMessage.resetDeprecatedMessageForTests();  
        // ensure no one changed the status logger level on us
     */
        private static final char[] ASCII_SET = "0123456789bcdefghjkmnpqrstuvwxyz".toCharArray();
    }  
        return randomTimeValue(0, 1000);
        TransportService.ensureClassloaded(); // ensure server streamables are registered
     * The exact opposite of {@link #rarely()}.  
                    statusData.add(data);  
    public static final String TEST_WORKER_SYS_PROPERTY = "org.gradle.test.worker";  
     *
    }
import java.net.InetAddress;
        long iterations = Math.max(Math.round(Math.log10(maxTimeInMillis) / Math.log10(2)), 1);
    }
            final BytesArray array = (BytesArray) data;  
     * internally should stay untouched.
    public static String randomRealisticUnicodeOfCodepointLength(int codePoints) {
import org.junit.Before;
        try {
        assertEquals(expected.getFileName(), actual.getFileName());  
        } catch (Exception e) {  
import org.opensearch.transport.client.Requests;  
    }
    /**
        public final Map<String, CharFilterFactory> charFilter;
     * Returns a random subset of values (including a potential empty list, or the full original list)  
    }
        Loggers.addAppender(leakLogger, leakAppender);
    // shuffle fields of objects in the list, but not the list itself
    private static final GeohashGenerator geohashGenerator = new GeohashGenerator();
     * Returns a unique port range for this JVM starting from the computed base port
 * software distributed under the License is distributed on an
        return actualWarnings.stream()
    protected static void checkStaticState(boolean afterClass) throws Exception {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
    public static String randomDateFormatterPattern() {  
        AnalysisModule analysisModule = new AnalysisModule(env, Arrays.asList(analysisPlugins));  
    public static String randomRealisticUnicodeOfLengthBetween(int minCodeUnits, int maxCodeUnits) {
        throws IOException {
import org.opensearch.common.xcontent.XContentType;
    public static TransportAddress buildNewFakeTransportAddress() {  
    }
    }  
                            final var messageSource = sd.getStackTraceElement();  
                while (result <= 0.0) {
    @AfterClass
    /** Pick a random object from the given array. The array must not be empty. */  
        throws IOException {
            }
    @AfterClass  
        }
        return result;
     */
     * Currently BigIntegers are only used for unsigned_long field type, where the max value is 2^64 - 1.
 */
                return true;  
        this.headerWarningAppender.start();  
import java.util.TimeZone;
import java.util.EnumSet;
        assertEquals(  
     * Called when a test fails, supplying the errors it generated. Not called when the test fails because assumptions are violated.
        for (int i = 0; i < numPaths; i++) {  
    }  
        return RandomPicks.randomFrom(random, collection);
public abstract class OpenSearchTestCase extends LuceneTestCase {
        Thread.sleep(Math.max(timeInMillis, 0));
    protected final XContentParser createParser(XContent xContent, String data) throws IOException {
    public static <T> T randomValueOtherThan(T input, Supplier<T> randomSupplier) {  
    @Rule
            .getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);  
    public static boolean waitUntil(BooleanSupplier breakSupplier, long maxWaitTime, TimeUnit unit) throws InterruptedException {  
     */  
     * Convenience method to assert same warnings for settings deprecations and general deprecation warnings
            HeaderWarning.removeThreadContext(threadContext);  
import static java.util.Collections.emptyMap;
        return randomFrom(random(), array);
     * {@link XContentType}. Wraps the output into a new anonymous object according to the value returned  
    }  
    // -----------------------------------------------------------------
    protected static int getBasePort(int start) {
        T original,  
    }
    }
import org.opensearch.common.time.FormatNames;
    /**  
    "CheapBastard",
    }  
        public TestAnalysis(
                targetMap.put(key, shuffleMap(valueMap, exceptFields));  
    }
    public static void clearAdditionalRoles() {
            this.threadContext = new ThreadContext(Settings.EMPTY);
import java.util.Collections;  
@LuceneTestCase.SuppressSysoutChecks(bugUrl = "we log a lot on purpose")
    /**  
     */
            result = randomDouble();
    }
        return elapsed;
                for (Throwable error : errors) {  
        List<T> tempList = new ArrayList<>(collection);  
    public static void setFileSystem() throws Exception {
                        break;  
    }
            codeBlock.run();
        return false;  
    }
    public static String randomPositiveTimeValue() {
        }
            try {
import org.opensearch.common.io.stream.BytesStreamOutput;
        Settings.Builder builder = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version);
            Thread.sleep(timeInMillis);
    /**
        List<T> list = new ArrayList<>();
import org.apache.logging.log4j.core.config.Configurator;
import java.time.ZoneId;
            try {
    public static final List<Exception> checkIndexFailures = new CopyOnWriteArrayList<>();
        // concurrent tests could claim port that another JVM just released and if that test tries to simulate a disconnect it might
        }  
    public static void restoreContentType() {
    protected final XContentBuilder shuffleXContent(XContentBuilder builder, String... exceptFieldNames) throws IOException {  
                            sd.getThrowable().printStackTrace(pw);
        System.setProperty("io.netty.leakDetection.level", "paranoid");  
import org.opensearch.bootstrap.BootstrapForTesting;
    private static final Collection<String> nettyLoggedLeaks = new ArrayList<>();
        Token token = parser.currentToken() == null ? parser.nextToken() : parser.currentToken();  
        return builder;
    protected NamedWriteableRegistry writableRegistry() {  
        return DateTimeZone.forID(randomFrom(JODA_TIMEZONE_IDS));  
            } catch (AssertionError e) {
    public static class GeohashGenerator extends CodepointSetGenerator {  
    public static final String TEST_WORKER_VM_ID;
            final Set<String> warningsNotExpected = Sets.difference(actualWarningValues, expectedWarnings);
        }
    "Lucene95",
        return getBasePort() + "-" + (getBasePort() + 99); // upper bound is inclusive
                return;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
    }  
    private ThreadContext threadContext;
                            ) == false
    // this must be a separate method from other ensure checks above so suite scoped integ tests can call...TODO: fix that
    /**
     * Create a "mock" script for use either with {@link MockScriptEngine} or anywhere where you need a script but don't really care about  
        public final Map<String, TokenizerFactory> tokenizer;
        return randomSubsetOf(randomInt(collection.size()), collection);  
    public static XContentBuilder shuffleXContent(XContentParser parser, boolean prettyPrint, String... exceptFieldNames)  
        assertSettingDeprecationsAndWarnings(Arrays.stream(settings).map(Setting::getKey).toArray(String[]::new), warnings);
    "LuceneVarGapFixedInterval",
            (out, value) -> out.writeNamedWriteable(value),
            }  
        }  
     */
import org.opensearch.transport.TransportService;
        Loggers.addAppender(LogManager.getLogger("org.opensearch.deprecation"), this.headerWarningAppender);
    }
        return waitUntil(breakSupplier, 10, TimeUnit.SECONDS);
import org.apache.logging.log4j.status.StatusLogger;  
    "FSTOrd50",  
                }
    "BlockTreeOrds",  
            }
import java.math.BigInteger;
    public String[] tmpPaths() {  
        return randomSubsetOf(size, list);
         * @param description annotated test description.
import org.opensearch.common.unit.TimeValue;  
        throws Exception {
        }
    /**
import java.lang.annotation.ElementType;  
     */  
        Set<T> things = new HashSet<>();
        List<AssertionError> failures = new ArrayList<>();  
    protected final BytesReference toShuffledXContent(
     */
                    .toList();
                "Attempting to run tests in an unusable locale in a FIPS JVM. Certificate expiration validation will fail, "
     * Usage: LockFeatureFlag("example.featureflag.setting.key.enabled")
     * by the {@link ToXContent#isFragment()} method returns. Shuffles the keys to make sure that parsing never relies on keys ordering.
                /* ensure that there are no status logger messages which would indicate a problem with our Log4j usage; we map the  
        try {  
                + actualWarnings.size()
import org.apache.logging.log4j.core.appender.AbstractAppender;
                assertThat(nettyLoggedLeaks, empty());  
            absPaths[i] = createTempDir().toAbsolutePath().toString();
     * Creates an TestAnalysis with all the default analyzers configured.
                        pw.print(sd.getMessage().getFormattedMessage());  
     */
import org.apache.logging.log4j.Level;
     * Returns a random BigInteger uniformly distributed over the range 0 to (2^64 - 1) inclusive  
                if (enableJodaDeprecationWarningsCheck() == false) {
                || Locale.getDefault().toLanguageTag().equals("ja-JP-u-ca-japanese-x-lvariant-JP")
            }  
                e.addSuppressed(failure);  
import org.opensearch.fips.FipsMode;
        return (short) random().nextInt();
            value = value.subtract(Numbers.MAX_UNSIGNED_LONG_VALUE);  
        return suiteFailureMarker;  
        Client client,
        } else {
     * //TODO remove once joda is not supported  
        ToXContent.Params params,  
    public static long randomLong() {
            } else {
        assertBusy(() -> MockSearchService.assertNoInFlightContext());  
            assertThat(
    protected final void assertSettingDeprecationsAndWarnings(final Setting<?>[] settings, final String... warnings) {  
    }
        }  
    /**
     * An alias for {@link #randomIntBetween(int, int)}.  
    /**
            xContentBuilder = xContentBuilder.prettyPrint();
        });
     * empty if the object that is streamed doesn't contain any {@link NamedWriteable} objects itself.
     */
    }
    public static double randomDoubleBetween(double start, double end, boolean lowerInclusive) {
                failures.add(e);
import org.apache.logging.log4j.status.StatusData;
    ) throws IOException {  
        return new BigInteger(64, random());
    public Path getDataPath(String relativePath) {  
    @Override
 * this work for additional information regarding copyright
     */
    public NodeEnvironment newNodeEnvironment(Settings settings) throws IOException {  
        if (start < 0) return "";
        }
        return random().nextFloat();
            consumer.accept(value);
        }
            @Override
            // formula below does not work with very large doubles
    }
     * @return a <code>int</code> between <code>0</code> and <code>Integer.MAX_VALUE</code> (inclusive) chosen uniformly at random.
     * Returns size random values
     */
        ) {  
        );
            throw new RuntimeException("resource not found: " + relativePath, e);
            .indexUUID(indexUUID)
    protected IndexAnalyzers createDefaultIndexAnalyzers() {
    /**
            String flagKey = annotation.value();
    }
    public static Settings.Builder remoteIndexSettings(Version version) {
                    filteredWarnings = filterJodaDeprecationWarnings(filteredWarnings);  
    "FST50",
    protected final XContentParser createParser(XContentBuilder builder) throws IOException {
                return;  
        return targetMap;
    }  
     */
    public static void ensureSupportedLocale() {
        }
     */
                    .filter(  
        return FipsMode.CHECK.isFipsEnabled();
            .basePath(basePath)
            .collect(Collectors.toSet());
    public static void assertBusy(CheckedRunnable<Exception> codeBlock) throws Exception {  
        XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(parser.contentType());
    protected PersistedStateRegistry persistedStateRegistry() {
        return copyWriteable(original, namedWriteableRegistry, reader, Version.CURRENT);  
            .put(settings)  
        return new IndexAnalyzers(  
     * Create a copy of an original {@link NamedWriteable} object by running it through a {@link BytesStreamOutput} and
    }
import java.io.IOException;
    /**
    @Rule
    public static void assertBusy(CheckedRunnable<Exception> codeBlock, long maxWaitTime, TimeUnit unit) throws Exception {
    }
     * Same as {@link #copyNamedWriteable(NamedWriteable, NamedWriteableRegistry, Class)} but also allows to provide
    // -----------------------------------------------------------------  
        final int size = randomIntBetween(minListSize, maxListSize);  
import java.util.stream.Stream;
                    try (final StringWriter sw = new StringWriter(); final PrintWriter pw = new PrintWriter(sw)) {
import org.opensearch.common.joda.JodaDeprecationPatterns;  
import org.opensearch.test.junit.listeners.ReproduceInfoPrinter;
     */
                    + "switching to English. See: https://github.com/bcgit/bc-java/issues/405"  
 *     http://www.apache.org/licenses/LICENSE-2.0
    // setup mock filesystems for this test run. we change PathUtils  
        } catch (AssertionError e) {
        return randomTimeValue(lower, upper, TIME_SUFFIXES);  
            try (XContentBuilder builder = shuffleXContent(parser, rarely(), exceptFieldNames)) {  
    public static boolean waitUntil(BooleanSupplier breakSupplier) throws InterruptedException {  
        int start = name.indexOf('{');  
            LockFeatureFlag annotation = description.getAnnotation(LockFeatureFlag.class);  
    public static int randomInt(int max) {
        protected void afterAlways(List<Throwable> errors) throws Throwable {  
            .stream()  
    public static void assertArrayEquals(StackTraceElement expected[], StackTraceElement actual[]) {
        }
        JAVA_ZONE_IDS = Collections.unmodifiableList(javaZoneIds);  
    /**
import org.opensearch.cluster.coordination.PersistedStateRegistry;
import org.junit.runner.Description;
    /**  
                synchronized (statusData) {
     * helper to get a random value in a certain range that's different from the input
    }
     * Currently BigIntegers are only used for unsigned_long field type, where the max value is 2^64 - 1.
                            .contains("No Root logger was configured, creating default ERROR-level Root logger") == false  
    public static String randomTimeValue(int lower, int upper, String... suffixes) {
    }
     */
        for (ExecutorService service : services) {
            Collections.singletonMap("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())),
    /**
    }
                        if (sd.getStackTraceElement() != null) {
        Settings indexSettings = Settings.builder().put(settings).put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
     * was used by the test and the test didn't assert on it using {@link #assertWarnings(String...)}.
        Settings build = buildEnvSettings(settings);
    protected static <T> T copyInstance(
            .index(remoteStoreIndex)
 * Modifications Copyright OpenSearch Contributors. See  
    }  
     * an alias to {@link #scaledRandomIntBetween(int, int)}.
        }
     */
            this.indexAnalyzers = indexAnalyzers;
        // because some code is buggy when it comes to multiple nio.2 filesystems
    /**
            }
    }
        return uniCodeStr.replaceAll("\\p{Cc}", toReplaceWith);
            List<Object> shuffledList = shuffleList(parser.listOrderedMap(), new HashSet<>(Arrays.asList(exceptFieldNames)));
import org.opensearch.core.xcontent.XContentParser;  
        byte[] bytes = new byte[size];
                    synchronized (nettyLoggedLeaks) {  
        return RandomNumbers.randomIntBetween(random(), min, max);
    /** A random integer from 0..max (inclusive). */
                    + expectedWarnings  
            throw new IllegalStateException("unable to check warning headers if the test is not set to do so");
            IndexAnalyzers indexAnalyzers,
        return list;
     * @see #scaledRandomIntBetween(int, int)
                ? RemoteStoreEnums.PathHashAlgorithm.valueOf(remoteCustomData.get(RemoteStoreEnums.PathHashAlgorithm.NAME))  
    protected static int getBasePort() {
     * specified maximum wait time has elapsed. If at all possible, use  
    }
            throw new IllegalStateException("unable to check warning headers if the test is not set to do so");
    }
     * a {@link Version} argument which will be used to write and read back the object.
                        nettyLoggedLeaks.add(message);
     * Create a new {@link XContentParser}.
     * helper to randomly perform on <code>consumer</code> with <code>value</code>
            if (value instanceof Map && exceptFields.contains(key) == false) {
    }  
import org.opensearch.core.common.io.stream.StreamInput;
import java.util.List;
            throw new AssertionError();  
            throw e;  
            leakAppender.stop();
    /**
     * Create a copy of an original {@link Writeable} object by running it through a {@link BytesStreamOutput} and
    }  
import org.opensearch.common.logging.Loggers;
        }
        // use a non-default base port otherwise some cluster in this JVM might reuse a port
            resetDeprecationLogger();  
    @Retention(RetentionPolicy.RUNTIME)
            .prepareGetSettings(remoteStoreIndex)  
            }
        Version version
    }  
    }
    public static int between(int min, int max) {
     * @param breakSupplier determines whether to return immediately or continue waiting.
            // busy spin  
     * iteration count. This method is effectively
                codeBlock.run();  
     * still need to do internally e.g. in bwc serialization and in the extract() method
    }
        return new NodeEnvironment(build, TestEnvironment.newEnvironment(build));
        assertEquals(expected.isNativeMethod(), actual.isNativeMethod());
    public static <T> Set<T> randomUnique(Supplier<T> supplier, int targetCount) {  
    @After
     * by the {@link ToXContent#isFragment()} method returns. Shuffles the keys to make sure that parsing never relies on keys ordering.
        }
    }
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
    }
        }));
import org.opensearch.core.xcontent.XContent;  
            Object value = map.get(key);  
    /** Pick a random object from the given collection. */
        if (afterClass) {  
        NamedWriteableRegistry namedWriteableRegistry,  
    public static Script mockScript(String id) {  
    }
    }  
    }
import java.util.Set;  
     * Runs the code block for 10 seconds waiting for no assertion to trip.
        String shardId,
            : RemoteStoreEnums.PathType.valueOf(remoteCustomData.get(RemoteStoreEnums.PathType.NAME));  
     * {@link OpenSearchTestCase#assertBusy(CheckedRunnable)} instead.
        synchronized (statusData) {
import org.opensearch.common.logging.HeaderWarningAppender;  
                            pw.println("Source:");
        String fixedPrefix
     */
import java.util.stream.Collectors;  
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey());
        // appropriate test  
        RemoteStoreEnums.DataType dataType,
     * Returns a "scaled" random number between min and max (inclusive).
        return "[" + name.substring(start + 1, end) + "] ";
    /**
}
        Requests.CONTENT_TYPE = randomFrom(XContentType.values());
        List<String> keys = new ArrayList<>(map.keySet());
            .map(s -> HeaderWarning.extractWarningValueFromWarningHeader(s, stripXContentPosition))
                }
        );
    }  
         * Wrap base test case with an  
    protected static final List<String> JAVA_ZONE_IDS;  
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
import org.apache.logging.log4j.core.LoggerContext;  
        return new PersistedStateRegistry();
    private String getTestParamsForLogging() {
        return xContent.createParser(xContentRegistry(), LoggingDeprecationHandler.INSTANCE, data);  
import static org.opensearch.core.common.util.CollectionUtils.arrayAsArrayList;  
        }
import org.apache.lucene.tests.util.TestRuleMarkFailure;
    private void resetDeprecationLogger() {
     * @param unit the unit of tie for <code>maxWaitTime</code>
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
                .map(s -> HeaderWarning.extractWarningValueFromWarningHeader(s, true))  
        return randomValue;  
        System.setProperty("log4j.shutdownHookEnabled", "false");
import java.util.function.IntFunction;  
        try {
    public static void assertBusyWithFixedSleepTime(CheckedRunnable<Exception> codeBlock, TimeValue maxWaitTime, TimeValue sleepTime)
     *
                    }
        return random().nextInt();
                 * Filter out known Log4j 2.25+ initialization message about default root logger  
    public static int randomNonNegativeInt() {
        ToXContent toXContent,
        return randomFrom(random(), collection);
@ThreadLeakFilters(filters = { BouncyCastleThreadFilter.class, ArrowAllocationLoggerThreadFilter.class })  
                + "\nActual: "
                assertWarnings(stripXContentPosition, filteredWarnings, expectedWarnings);
        boolean humanReadable,
    /**
        long sum = 0;
    /**
import java.util.HashSet;
 * Unless required by applicable law or agreed to in writing,
     */
        return Settings.builder()
    /**  
    "Lucene99" })  
    /**  
import java.util.LinkedHashMap;  
import org.opensearch.index.analysis.CharFilterFactory;
                    filteredStatusData.stream().map(status -> status.getMessage().getFormattedMessage()).collect(Collectors.toList()),
                public void evaluate() throws Throwable {
                e.addSuppressed(failure);
     *  
                return BytesReference.bytes(builder);
        PathUtilsForTesting.teardown();
    }  
        RemoteStorePathStrategy.ShardDataPathInput pathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()  
                    }
            if (errors != null && errors.isEmpty() == false) {
     * The {@link PersistedStateRegistry} to use for this test. Subclasses should override and use liberally.
    ) throws IOException {
     * Runs the code block for the provided interval, waiting for no assertions to trip.
    private List<String> filterJodaDeprecationWarnings(List<String> actualWarnings) {
    // -----------------------------------------------------------------  
                        )  
    public static long randomNonNegativeLong() {
            Map<String, CharFilterFactory> charFilter
    }  
    @SuppressWarnings("unchecked")
        return value;  
            }
                random().nextBytes(ipv4);
 * KIND, either express or implied.  See the License for the
                        }
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)  
        }  
    public static TestRuleMarkFailure getSuiteFailureMarker() {
                        return sw.toString();  
                return;
            analysisRegistry.build(indexSettings),  
 * The OpenSearch Contributors require contributions made to  
        }  
     * @param allowEmpty Whether the returned array may be empty (have zero elements)  
    /** called after a test is finished, but only if successful */  
                Arrays.stream(settings)
     */  
        NamedWriteableRegistry namedWriteableRegistry,
import org.opensearch.common.util.set.Sets;
        }
     * Create a new {@link XContentParser}.
    "LuceneVarGapDocFreqInterval",  
        Thread.sleep(Math.max(timeInMillis, 0));
    "Lucene94",  
        /**
        if (isUnusableLocale()) {
        assertNull("Thread context initialized twice", threadContext);  
            if (warnings != null) {  
    }  
            version
        }  
    /**
                e.addSuppressed(failure);  
            randomValue = randomSupplier.get();
        return RandomNumbers.randomLongBetween(random(), min, max);
import org.opensearch.index.analysis.TokenizerFactory;
import org.opensearch.common.settings.Settings;  
     */  
        Collections.shuffle(tempList, random());
 *
        timeInMillis = maxTimeInMillis - sum;  
     * Recursively goes through inner objects and also shuffles them. Exceptions for this
import static org.hamcrest.Matchers.hasItem;
        final int numPaths = TestUtil.nextInt(random(), 1, 3);
 * the Apache License, Version 2.0 (the "License"); you may
        // WEEKYEAR should be used instead of WEEK_YEAR
        // Check that there are no unaccounted warning headers. These should be checked with {@link #assertWarnings(String...)} in the
/*
            for (AssertionError failure : failures) {  
            ).toArray(String[]::new)  
     * @return the last value returned by <code>breakSupplier</code>  
        }
import org.opensearch.core.xcontent.XContentHelper;
    }  
            Logger logger = LogManager.getLogger(OpenSearchTestCase.class);  
    /**
import org.opensearch.plugins.AnalysisPlugin;
     *
        leakAppender.start();  
     * Create a new {@link XContentParser}.
    public static int randomIntBetween(int min, int max) {  
    }
        return random().nextBoolean();
    }  
    // Suite and test case setup/cleanup.
    private void ensureNoWarnings() {
import java.util.function.Consumer;
        };
    }
    /**
     * are not logged again.  
     * Reset the deprecation logger by clearing the current thread context.  
    }
     * @throws InterruptedException if any sleep calls were interrupted.
                .map(HeaderWarning::escapeAndEncode)
 */  
        @Override
        assertEquals(expected.getClassName(), actual.getClassName());
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering;  
import org.opensearch.threadpool.ThreadPool;  
            }
import org.junit.rules.RuleChain;  
        // ensure that the status logger is set to the warn level so we do not miss any warnings with our Log4j usage  
                    + warningsNotExpected.size()
            "Expected "
    public static String randomRealisticUnicodeOfLength(int codeUnits) {
        if (enableWarningsCheck()) {
        BlobPath basePath,
                || Locale.getDefault().toLanguageTag().equals("th-TH-u-nu-thai-x-lvariant-TH"));  
/**  
    private static final AtomicInteger portGenerator = new AtomicInteger();
    public static Settings.Builder settings(Version version) {  
        return xContent.createParser(xContentRegistry(), LoggingDeprecationHandler.INSTANCE, data);
    }  
    }
import org.opensearch.env.Environment;
import java.util.concurrent.atomic.AtomicInteger;
    }
        final int size = randomIntBetween(minArraySize, maxArraySize);
    protected boolean enableJodaDeprecationWarningsCheck() {
        // be smart enough to re-connect depending on what is tested. To reduce the risk, since this is very hard to debug we use
                targetMap.put(key, value);
        return replaceUnicodeControlCharacters(uniCodeStr, " ");
        /*
    }  
     */  
                array.length()  
        StatusLogger.getLogger().registerListener(new StatusConsoleListener(Level.WARN) {
    public static float randomFloat() {  
        return createTestAnalysis(IndexSettingsModule.newIndexSettings(index, indexSettings), nodeSettings, analysisPlugins);  
            Thread.sleep(sleepTimeInMillis);  
 */
    }
        String remoteStoreIndex,  
import org.opensearch.common.util.FeatureFlags;
            OpenSearchTestCase.this.afterIfSuccessful();
    ) throws IOException {
        logger.info("{}before test", getTestParamsForLogging());
            } finally {
 * Base testcase for randomized unit testing with OpenSearch
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;  
    protected final XContentParser createParser(XContent xContent, BytesReference data) throws IOException {
        }
                return base;
        LinkedHashMap<String, Object> targetMap = new LinkedHashMap<>();  
import org.opensearch.cluster.ClusterState;
    }
 * specific language governing permissions and limitations
     * @see #scaledRandomIntBetween(int, int)
    }  
        return RandomizedTest.scaledRandomIntBetween(min, max);
     * Randomly shuffles the fields inside objects parsed using the {@link XContentParser} passed in.
    protected static final List<String> JAVA_TIMEZONE_IDS;
        if (data instanceof BytesArray) {
    }
        );  
     * @param lowerInclusive whether or not to include lower end of the interval
     * A random long number between min (inclusive) and max (inclusive).
    }  
    }
        // a different default port range per JVM unless the incoming settings override it  
     * Randomly shuffles the fields inside objects in the {@link XContentBuilder} passed in.
    @AfterClass
    ) throws IOException {  
        NamedWriteableRegistry namedWriteableRegistry,
     * Returns a random BigInteger uniformly distributed over the range 0 to (2^64 - 1) inclusive
    protected boolean enableWarningsCheck() {
     */
            Map<String, TokenizerFactory> tokenizer,
    // -----------------------------------------------------------------
        return randomInt == Integer.MIN_VALUE ? 0 : Math.abs(randomInt);  
            logger.warn(
    /**
        return RandomizedTest.randomRealisticUnicodeOfCodepointLengthBetween(minCodePoints, maxCodePoints);
     */
        if (start == -Double.MAX_VALUE || end == Double.MAX_VALUE) {
        assertWarnings(
    /**  
    @Before  
     * @throws InterruptedException if any sleep calls were interrupted.
     * @return a random bigInteger in the range [0 ; 2^64 - 1]
                 * StatusData instances to Strings as otherwise their toString output is useless
     * Periodically execute the supplied function until it returns true, or a timeout
        for (int i = 0; i < size; i++) {  
    @Target({ ElementType.METHOD })
import static org.hamcrest.Matchers.empty;
import java.util.concurrent.TimeUnit;
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
        return createParser(builder.contentType().xContent(), BytesReference.bytes(builder));
import com.carrotsearch.randomizedtesting.annotations.Listeners;
                            k -> k.contains(  
        try (XContentParser parser = createParser(mediaType.xContent(), bytes)) {
        // "clear" the deprecated message set for the next tests to run independently.
            }
import org.junit.BeforeClass;  
import java.lang.annotation.RetentionPolicy;
import org.opensearch.indices.analysis.AnalysisModule;
            array[i] = valueConstructor.get();
        return RandomizedTest.randomUnicodeOfCodepointLength(codePoints);
     * generate a random TimeZone from the ones available in java.util
        long sleepTimeInMillis = sleepTime.millis();
    }
    }
        } finally {
        if (workerIdStr == null) {
    public static <T> T randomFrom(List<T> list) {
            .fixedPrefix(fixedPrefix)  
    /**
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            }  
        if (this.headerWarningAppender != null) {  
        if (enableWarningsCheck() == false) {  
        ClusterState state = client.admin().cluster().prepareState().execute().actionGet().getState();  
    }
            output.setVersion(version);
     * Generate a random valid date formatter pattern.
            actualWarnings.size()
import com.carrotsearch.randomizedtesting.RandomizedTest;  
     * Returns the bytes that represent the XContent output of the provided {@link ToXContent} object, using the provided  
        return RandomPicks.randomFrom(random, array);
            );
 * You may obtain a copy of the License at  
    public static long randomLongBetween(long min, long max) {
    public static <T extends NamedWriteable> T copyNamedWriteable(
            } else {
    "Lucene90",
            result = Double.longBitsToDouble(randomLong());  
import java.lang.annotation.Retention;
        }
        long nanosecondsInMillisecond = TimeUnit.NANOSECONDS.convert(ms, TimeUnit.MILLISECONDS);
                array.array(),
    }
    }
    public static String randomUnicodeOfCodepointLengthBetween(int minCodePoints, int maxCodePoints) {
    }  
    }
            return shuffleXContent(parser, builder.isPrettyPrint(), exceptFieldNames);
    }
    protected static long spinForAtLeastNMilliseconds(final long ms) {  
    "Lucene50",
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        T original,  
     * @see RandomizedTest#scaledRandomIntBetween(int, int)
                codeBlock.run();
        assertThat(StatusLogger.getLogger().getLevel(), equalTo(Level.WARN));  
        portGenerator.set(0);  
        return copyInstance(
    public static class AnnotatedFeatureFlagRule implements TestRule {
    }  
                            pw.println(messageSource.getFileName() + "@" + messageSource.getLineNumber());
        }
import org.opensearch.common.util.MockPageCacheRecycler;  
import java.lang.annotation.Target;  
    public static byte randomByte() {
    public static <T> T randomValueOtherThanMany(Predicate<T> input, Supplier<T> randomSupplier) {
        String... exceptFieldNames  
        setTestSysProps();  
import org.opensearch.index.analysis.IndexAnalyzers;
                Arrays.stream(warnings)
            } else {  
        try (XContentParser parser = createParser(builder)) {
        assertEquals(expected.getMethodName(), actual.getMethodName());
        );
            things.add(supplier.get());
import org.opensearch.index.IndexModule;  
     * helper to get a random value in a certain range that's different from the input
        return ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
    public @interface LockFeatureFlag {  
import org.apache.logging.log4j.core.Appender;
        }  
            return xContentBuilder.value(shuffledList);  
    }
     * Returns a double value in the interval [start, end) if lowerInclusive is  
        return builder;
                }  
        }
import org.opensearch.cluster.metadata.IndexMetadata;  
    }
import org.opensearch.common.settings.Setting;
            for (Exception failure : checkIndexFailures) {
                    + "\nActual: "
    /**
                + expectedWarnings.length
    // TODO: decide on one set of naming for between/scaledBetween and remove others
import org.opensearch.search.MockSearchService;  
import java.util.function.BooleanSupplier;  
        assertWarnings(true, expectedWarnings);
            return null;
    }  
    }
            }
            .collect(Collectors.toList());
        }
     */  
import org.opensearch.index.remote.RemoteStorePathStrategy;
                        allAssumption = false;
         * observe the passage of time.
    "MockRandom",
                            + "] setting was deprecated in OpenSearch and will be removed in a future release! "
    /**
                    )
 */
import org.opensearch.script.MockScriptEngine;  
        T original,  
        Collections.shuffle(keys, random());
        return MockNioTransportPlugin.class;
        threadContext.stashContext();
    protected NamedXContentRegistry xContentRegistry() {
                    ),
import org.opensearch.core.xcontent.MediaType;
import org.apache.logging.log4j.Logger;  
        Collections.sort(javaZoneIds);
    }
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
 * GitHub history for details.
import java.util.concurrent.ExecutorService;  
        } while (input.test(randomValue));
import org.opensearch.core.common.bytes.BytesReference;  
                        }  
    protected final BytesReference toShuffledXContent(  
    }  
    public static void resetPortCounter() {
    }
    protected final XContentParser createParser(NamedXContentRegistry namedXContentRegistry, XContent xContent, BytesReference data)  
    protected static final List<String> JODA_TIMEZONE_IDS;
     */
        }  
    }
        );
    }
        return inFipsJvm()  
            } catch (AssertionError e) {  
            );
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope;
        return new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
@LuceneTestCase.SuppressReproduceLine
    }  
    public final void before() {
                array.offset(),
        return spinForAtLeastNMilliseconds(1);  
        return newNodeEnvironment(Settings.EMPTY);
    public RuleChain failureAndSuccessEvents = RuleChain.outerRule(new TestRuleAdapter() {
     * @param maxWaitTime the maximum amount of time to wait
                assertThat("unexpected warning headers", filteredWarnings, empty());  
         * @param base test case to execute.
    private static final long AWAIT_BUSY_THRESHOLD = 1000L;
        Requests.CONTENT_TYPE = XContentType.SMILE;
        return bytes;  
            } else if (value instanceof List && exceptFields.contains(key) == false) {
    }
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
        return random().nextLong();
    public static BigInteger randomUnsignedLong() {
    // Allows distinguishing between parallel test processes  
 * license agreements. See the NOTICE file distributed with
        return randomValueOtherThanMany(id -> JODA_TIMEZONE_IDS.contains(id) == false, () -> randomFrom(zoneIds));  
        if (allowNull && random().nextBoolean()) {  
    public static boolean terminate(ThreadPool threadPool) {  
     */  
    }  
import java.nio.file.Path;
    protected final Logger logger = LogManager.getLogger(getClass());  
        return new TransportAddress(TransportAddress.META_ADDRESS, portGenerator.incrementAndGet());
    }
import java.util.concurrent.CopyOnWriteArrayList;
        return copyInstance(original, namedWriteableRegistry, (out, value) -> value.writeTo(out), reader, version);
    public static void assertEquals(StackTraceElement expected, StackTraceElement actual) {  
    }
    public static String[] generateRandomStringArray(int maxArraySize, int stringSize, boolean allowNull) {
     */
            resetDeprecationLogger();
            namedWriteableRegistry,
                        .collect(Collectors.toList());
     * reading it in again using a provided {@link Writeable.Reader}.  
     *
import org.opensearch.index.remote.RemoteStoreEnums;  
    }
    ) throws IOException {  
            if (service != null) {
        // replace control characters (https://stackoverflow.com/questions/3438854/replace-unicode-control-characters/)  
import org.opensearch.env.TestEnvironment;
     */
@ThreadLeakLingering(linger = 5000) // 5 sec lingering
        Appender leakAppender = new AbstractAppender(leakLoggerName, null, PatternLayout.newBuilder().withPattern("%m").build()) {
     * Periodically execute the supplied function until it returns true, or until the
        Version version
        for (int i = 0; i < arraySize; i++) {
        List<String> javaTZIds = Arrays.asList(TimeZone.getAvailableIDs());  
     * reading it in again using a provided {@link Writeable.Reader}. The stream that is wrapped around the {@link StreamInput}  
            analysisRegistry.buildCharFilterFactories(indexSettings)  
import org.junit.Rule;
     * Generates a new transport address using {@link TransportAddress#META_ADDRESS} with an incrementing port number.  
     */  
        assertNotNull("no warnings, expected: " + Arrays.asList(expectedWarnings), actualWarnings);
        System.setProperty("log4j2.disable.jmx", "true");  
/*  
    }
                byte[] ipv4 = new byte[4];  
            final List<String> warnings = threadContext.getResponseHeaders().get("Warning");
        XContentType xContentType,  
        return builder;  
            @Override  
            final List<String> actualWarnings = threadContext.getResponseHeaders().get("Warning");
        String indexUUID = client.admin()
        checkIndexFailures.clear();
        ClusterModule.getNamedWriteables()
    public static String getPortRange() {
     */
        TEST_WORKER_VM_ID = System.getProperty(TEST_WORKER_SYS_PROPERTY, DEFAULT_TEST_WORKER_ID);
                }
        String leakLoggerName = "io.netty.util.ResourceLeakDetector";
    protected void afterIfSuccessful() throws Exception {}
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
        while (sum <= maxTimeInMillis) {
    }
            .dataCategory(dataCategory)
    /** Pick a random object from the given array. The array must not be empty. */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * Create a new {@link XContentParser}.  
    public static String randomTimeValue(int lower, int upper) {
            list.add(valueConstructor.get());  
    public void tearDown() throws Exception {
        Map<String, String> remoteCustomData = state.metadata()
        StatusLogger.getLogger().setLevel(Level.WARN);
        long start = System.nanoTime();  
        if (token == Token.START_ARRAY) {
        return getBasePort(10300);  
            .dataType(dataType)
    ) {  
    public static TestAnalysis createTestAnalysis(IndexSettings indexSettings, Settings nodeSettings, AnalysisPlugin... analysisPlugins)  
        }  
    // After 1s, we stop growing the sleep interval exponentially and just sleep 1s until maxWaitTime
import org.opensearch.common.logging.HeaderWarning;
    /**  
import org.apache.logging.log4j.core.layout.PatternLayout;  
     * because they cannot be converted back to DateTimeZone which we currently
    public Settings buildEnvSettings(Settings settings) {
        RemoteStoreEnums.DataCategory dataCategory,  
import java.io.PrintWriter;
package org.opensearch.test;
        List<Object> targetList = new ArrayList<>();
    }
    }  
            Locale.setDefault(Locale.ENGLISH);
     * Flag returned to previous value on test exit.
    public static <T> List<T> randomList(int maxListSize, Supplier<T> valueConstructor) {
    /** Returns the suite failure marker: internal use only! */
     * its contents.
            final Set<String> actualWarningValues = actualWarnings.stream()
        return RandomizedTest.randomAsciiOfLength(codeUnits);  
     *
import java.io.StringWriter;
    private static List<Object> shuffleList(List<Object> list, Set<String> exceptFields) {  
    }
    public static ZoneId randomZone() {
    public static TimeZone randomTimeZone() {  
    }
        Class<T> categoryClass
// assertingcodec is the winner for a codec here: it finds bugs and gives clear exceptions.
                namedXContentRegistry,
    private static void setTestSysProps() {
import org.opensearch.cluster.node.DiscoveryNode;
    /** Compares two stack traces, ignoring module (which is not yet serialized) */  
        return targetList;  
            new HashSet<>(Arrays.asList(exceptFieldNames))
            if (breakSupplier.getAsBoolean()) {
                targetList.add(shuffleMap(valueMap, exceptFields));
     */
        Writeable.Reader<T> reader,  
    }  
        return terminated;  
            if (actualWarnings == null) {
        Collections.sort(javaTZIds);
    }  
            if (actualWarnings != null && enableJodaDeprecationWarningsCheck() == false) {
        for (Object value : list) {
    public static String randomAlphaOfLength(int codeUnits) {
        boolean terminated = true;  
     * Returns a "scaled" number of iterations for loops which can have a variable  
            }
     */
        RemoteStoreEnums.PathType type = Objects.isNull(remoteCustomData)
    }
                }
        return DEFAULT_NAMED_X_CONTENT_REGISTRY;  
    }
    }
            startAt = (int) Math.floorMod(workerId - 1, 223L) + 1;
        public final IndexAnalyzers indexAnalyzers;
     */
import java.util.function.Function;
     * internally should stay untouched.
    /**
                 */
        while (value.compareTo(Numbers.MAX_UNSIGNED_LONG_VALUE) == 1) {
            assertThat(actualWarningValues, hasItem(HeaderWarning.escapeAndEncode(msg)));
                .collect(Collectors.toSet());
    /**  
            throw new IllegalArgumentException("sleepTime is more than the maxWaitTime");  
    }
        BytesReference bytes = XContentHelper.toXContent(toXContent, mediaType, params, humanReadable);
import org.opensearch.common.Numbers;  
        do {  
                targetList.add(shuffleList((List) value, exceptFields));
    public void setHeaderWarningAppender() {
            bytes[i] = randomByte();
    public static <T> List<T> randomSubsetOf(int size, Collection<T> collection) {  
    private static String randomJodaAndJavaSupportedTimezone(List<String> zoneIds) {
import java.util.function.Supplier;
        if (end < 0) return "";  
        assertEquals(expected.getLineNumber(), actual.getLineNumber());
        for (int i = 0; i < expected.length; i++) {  
     * potentially need to use a {@link NamedWriteableRegistry}, so this needs to be provided too (although it can be
     * The {@link NamedXContentRegistry} to use for this test. Subclasses should override and use liberally.  
            this.charFilter = charFilter;
                }
     * is reached. This version uses a timeout of 10 seconds. If at all possible,
                };
    /**  
    @Before  
     */
     * Returns the bytes that represent the XContent output of the provided {@link ToXContent} object, using the provided
    }
        Class<T> categoryClass,
    public static <T extends Writeable> T copyWriteable(
        Writeable.Reader<T> reader
            }
    public static int scaledRandomIntBetween(int min, int max) {  
        try {
    /**
     * @param warnings other expected general deprecation warnings
    /**  
            assertEquals(expected[i], actual[i]);
    public static int iterations(int min, int max) {
    public static final class TestAnalysis {  
    public static <T> T randomFrom(Random random, Collection<T> collection) {  
@ThreadLeakScope(Scope.SUITE)
            writer.write(output, original);
        MockBigArrays.ensureAllArraysAreReleased();  
import org.opensearch.index.IndexSettings;
        if (checkIndexFailures.isEmpty() == false) {  
        ToXContent toXContent,
     */  
    @Deprecated  
        BigInteger value = randomBigInteger().abs();  
        int randomInt = randomInt();
                return BytesReference.bytes(builder);
     * return URL encoded paths if the parent path contains spaces or other
     */
            final AssertionError e = new AssertionError("at least one shard failed CheckIndex");
                    result = randomDouble();
            this.tokenizer = tokenizer;  
        }
        return RandomizedTest.randomInt(max);  
        return (byte) random().nextInt();
        // initialized  
    /** MockFSDirectoryService sets this: */  
            MockPageCacheRecycler.ensureAllPagesAreReleased();
    }
    });  
        long timeInMillis = 1;
import java.util.ArrayList;  
    }
import java.io.InputStream;  
     */  
import java.util.Objects;
        int arraySize = randomIntBetween(allowEmpty ? 0 : 1, maxArraySize);  
        assertTrue("Found duplicate warnings logged", actualWarnings == null);
    /**  
    public static byte[] randomByteArrayOfLength(int size) {
        MediaType mediaType,
        return ZoneId.of(randomJodaAndJavaSupportedTimezone(JAVA_ZONE_IDS));
import com.carrotsearch.randomizedtesting.generators.CodepointSetGenerator;
 * not use this file except in compliance with the License.
    public static <T> T[] randomArray(int minArraySize, int maxArraySize, IntFunction<T[]> arrayConstructor, Supplier<T> valueConstructor) {
     */
        }
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey());  
    }  
    /**
    /**
    }  
        }
import org.opensearch.transport.client.Client;
        // filter out joda timezones that are deprecated for the java time migration
    public static String randomUnicodeOfLengthBetween(int minCodeUnits, int maxCodeUnits) {  
    private static final List<StatusData> statusData = new ArrayList<>();
    public final void resetCheckIndexStatus() throws Exception {
        Logger leakLogger = LogManager.getLogger(leakLoggerName);  
            }
        Settings.Builder builder = Settings.builder()
        }
    }
        return randomIntBetween(lower, upper) + randomFrom(suffixes);
        final int startAt;  
        return TimeZone.getTimeZone(randomJodaAndJavaSupportedTimezone(JAVA_TIMEZONE_IDS));
import org.apache.logging.log4j.LogManager;
     * This cute helper class just holds all analysis building blocks that are used
    public static LinkedHashMap<String, Object> shuffleMap(LinkedHashMap<String, Object> map, Set<String> exceptFields) {
        String name = getTestName();
import org.opensearch.core.common.io.stream.NamedWriteable;
    }  
     * @return a random bigInteger in the range [0 ; 2^64 - 1]  
        int maxTries = targetCount * 10;
                    + actualWarningValues,
        }  
     */  
    }
            while (result < start || result > end || Double.isNaN(result)) {
            array[i] = RandomStrings.randomAsciiOfLength(random(), stringSize);  
        // Enable Netty leak detection and monitor logger for logged leak errors
     * Recursively goes through inner objects and also shuffles them. Exceptions for this
    protected final void assertSettingDeprecationsAndWarnings(final String[] settings, final String... warnings) {
            } finally {
        } catch (AssertionError e) {
            }
        if (enableWarningsCheck() == false) {  
    }
            Stream.concat(  
        NamedWriteableRegistry namedWriteableRegistry,
     */
    public static TestAnalysis createTestAnalysis(Index index, Settings nodeSettings, Settings settings, AnalysisPlugin... analysisPlugins)  
    /**
        throws IOException {
        } finally {
    protected static InetAddress randomIp(boolean v4) {  
        try (BytesStreamOutput output = new BytesStreamOutput()) {  
                final Function<StatusData, String> statusToString = (sd) -> {
                targetMap.put(key, shuffleList((List) value, exceptFields));
        return createTestAnalysis(index, nodeSettings, settings, analysisPlugins);  
     * Returns a {@link Path} pointing to the class path relative resource given
        throws IOException {
                        throw new RuntimeException(ioe);
    /**
         * Force at least ms milliseconds to elapse, but ensure the clock has enough resolution to  
    }
        return randomList(0, maxListSize, valueConstructor);
        ensureCheckIndexPassed();
        }
            }  
        final String workerIdStr = System.getProperty(OpenSearchTestCase.TEST_WORKER_SYS_PROPERTY);
                List<StatusData> filteredStatusData = statusData.stream()
     * Allow the given warnings, but don't require their presence.  
                        base.evaluate();  
                return InetAddress.getByAddress(ipv4);
            this.tokenFilter = tokenFilter;
import org.opensearch.Version;
                                "no-jdk distributions that do not bundle a JDK are deprecated and will be removed in a future release"
        ensureAllSearchContextsReleased();  
/*
     * A random integer from <code>min</code> to <code>max</code> (inclusive).
    }
     */
     * Modify this random generator if a wider range for BigIntegers is necessary.  
     */
                return things;
            emptyMap()  
    public static String randomUnicodeOfCodepointLength(int codePoints) {  
                        .filter(
            ensureNoWarnings();
        checkStaticState(false);
    public static final String DEFAULT_TEST_WORKER_ID = "--not-gradle--";
@Listeners({ ReproduceInfoPrinter.class, LoggingListener.class })  
        }  
    public static <T> void maybeSet(Consumer<T> consumer, T value) {  
        try (XContentParser parser = createParser(xContentType.xContent(), bytes)) {  
        // assert that no such messages were written out as these would indicate a problem with our logging configuration  
     * recursive shuffling behavior can be made by passing in the names of fields which  
    // TODO: can we do this cleaner???
            if (lowerInclusive == false) {  
        List<String> jodaTZIds = DateTimeZone.getAvailableIDs()
import org.junit.runners.model.Statement;  
     * Enables and make a flag immutable for the duration of the test case.  
            original,  
    public static String getTestTransportType() {
        return RandomizedTest.randomUnicodeOfLength(codeUnits);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        List<T> list = arrayAsArrayList(values);
    /** Compares two stack trace elements, ignoring module (which is not yet serialized) */
        return new TestAnalysis(
    }
     * Helper method to create a byte array of a given length populated with random byte values  
    public static String randomGeohash(int minPrecision, int maxPrecision) {
    // randomize content type for request builders
        if (prettyPrint) {  
    /**
            }  
    /**
    /** Pick a random object from the given list. */
        String... exceptFieldNames
     *  
    /** Pick a random object from the given collection. */  
        }
        protected void afterIfSuccessful() throws Throwable {
            LoggerContext context = (LoggerContext) LogManager.getContext(false);  
 * Licensed to Elasticsearch under one or more contributor  
            try (XContentBuilder builder = shuffleXContent(parser, rarely(), exceptFieldNames)) {
        return RandomizedTest.randomUnicodeOfLengthBetween(minCodeUnits, maxCodeUnits);
        super.tearDown();  
import org.apache.lucene.tests.util.TestUtil;
            // we adjust the gradle worker id with mod so as to not go over the ephemoral port ranges, but gradle continually
    public static String randomUnicodeOfLength(int codeUnits) {
import org.opensearch.env.NodeEnvironment;  
                if (false == allAssumption) {  
    public static boolean frequently() {
            if (annotation == null) {
        Environment env = TestEnvironment.newEnvironment(nodeSettings);
            }
            ? remoteCustomData.containsKey(RemoteStoreEnums.PathHashAlgorithm.NAME)
            return xContent.createParser(
            assert workerId >= 1 : "Non positive gradle worker id: " + workerIdStr;
    @AfterClass
    /**  
            sum += timeInMillis;  
import org.opensearch.core.xcontent.ToXContent;
        for (int i = 0; i < iterations; i++) {
            resetDeprecationLogger();
     * Creates an TestAnalysis with all the default analyzers configured.
        }  
    public static String replaceUnicodeControlCharacters(String uniCodeStr, String toReplaceWith) {
     * Define LockFeatureFlag annotation for unit tests.
        // we need a sorted map for reproducibility, as we are going to shuffle its keys and write XContent back
        return breakSupplier.getAsBoolean();
    public static String randomRealisticUnicodeOfCodepointLengthBetween(int minCodePoints, int maxCodePoints) {  
    }
    /**
        return tempList.subList(0, size);
    public static <T> T randomFrom(Random random, T... array) {  
    }
import org.junit.rules.TestRule;
    /**  
import org.opensearch.common.SuppressForbidden;
     */  
        }
import org.opensearch.core.xcontent.XContentParser.Token;
     */
    protected final XContentParser createParser(XContent xContent, byte[] data) throws IOException {
     * @param allowNull Whether the returned array may be null
import reactor.core.scheduler.Schedulers;  
     * Creates an TestAnalysis with all the default analyzers configured.
                return InetAddress.getByAddress(ipv6);  
            timeInMillis = Math.min(AWAIT_BUSY_THRESHOLD, timeInMillis * 2);
        for (int i = 0; i < size; i++) {
     */
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5)
        }
        return geohashGenerator.ofStringLength(random(), minPrecision, maxPrecision);
                    try (FeatureFlags.TestUtils.FlagWriteLock ignored = new FeatureFlags.TestUtils.FlagWriteLock(flagKey)) {
    public static <T extends NamedWriteable> T copyNamedWriteable(
        Settings.Builder builder = Settings.builder()  
        }  
        try {  
        return array;
                            .getFormattedMessage()
    }
        return new Script(ScriptType.INLINE, MockScriptEngine.NAME, id, emptyMap());
        return randomIntBetween(min, max);
        return xContentBuilder.map(shuffledMap);
        JODA_TIMEZONE_IDS = Collections.unmodifiableList(jodaTZIds);
    }
     */
        Map<String, Object> shuffledMap = shuffleMap(  
            Loggers.removeAppender(LogManager.getLogger("org.opensearch.deprecation"), this.headerWarningAppender);
            .shardId(shardId)  
                    filteredWarnings = filteredWarnings.stream()
            in -> in.readNamedWriteable(categoryClass),  
    /**  
            .build();  
    }
        Version version  
import org.opensearch.common.blobstore.BlobPath;
     * Runs the code block for the provided max wait time and sleeping for fixed sleep time, waiting for no assertions to trip.
    public static <T> List<T> randomSubsetOf(int size, T... values) {  
            );
    "Direct",  
    public static boolean randomBoolean() {  
     * @deprecated use {@link #toShuffledXContent(ToXContent, MediaType, ToXContent.Params, boolean, String...)} instead
    }  
import org.opensearch.plugins.Plugin;
    }
        return randomArray(0, maxArraySize, arrayConstructor, valueConstructor);
        }  
    public static TestAnalysis createTestAnalysis(Index index, Settings settings, AnalysisPlugin... analysisPlugins) throws IOException {
    @After  
import org.joda.time.DateTimeZone;
        EnumSet<FormatNames> formatNames = EnumSet.complementOf(EnumSet.of(FormatNames.WEEK_YEAR));
    }  
            && (Locale.getDefault().toLanguageTag().equals("th-TH")
        boolean humanReadable,
        synchronized (nettyLoggedLeaks) {
import java.net.UnknownHostException;  
        Schedulers.shutdownNow();
    }
    }
    "TestBloomFilteredLucenePostings",
    public static String[] generateRandomStringArray(int maxArraySize, int stringSize, boolean allowNull, boolean allowEmpty) {
        Writeable.Writer<T> writer,
        return RandomizedTest.randomRealisticUnicodeOfCodepointLength(codePoints);
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            }
                if (JvmInfo.jvmInfo().getBundledJdk() == false) {
    }
        try {  
            throw new IllegalArgumentException(
    private HeaderWarningAppender headerWarningAppender;
            };  
import org.opensearch.common.io.PathUtilsForTesting;
        String value();
            : null;
    @Override  
import org.junit.After;  
        ClusterModule.getNamedXWriteables()
        for (int t = 0; t < maxTries; t++) {  
     * @return a <code>long</code> between <code>0</code> and <code>Long.MAX_VALUE</code> (inclusive) chosen uniformly at random.  
                // we clear the list so that status data from other tests do not interfere with tests within the same JVM  
            result = result * end + (1.0 - result) * start;
    /** Returns a random number of temporary paths. */
import org.opensearch.core.common.bytes.BytesArray;
    );  
                if (Level.ERROR.equals(event.getLevel()) && message.contains("LEAK:")) {
import org.apache.lucene.tests.util.TimeUnits;  
    protected void afterIfFailed(List<Throwable> errors) {}
    /**  
     * We need to exclude time zones not supported by joda (like SystemV* timezones)  
        }
        return randomTimeValue(1, 1000);
                }
    "SimpleText",  
    }
            Set<String> expectedWarnings = new HashSet<>(Arrays.asList(allowedWarnings));  
         */  
    /**
import org.opensearch.common.CheckedRunnable;
     */  
    static {
    public AnnotatedFeatureFlagRule flagLockRule = new AnnotatedFeatureFlagRule();
    /**
                    filteredStatusData.stream().map(statusToString::apply).collect(Collectors.joining("\r\n")),
            .filter(m -> m.contains(JodaDeprecationPatterns.USE_NEW_FORMAT_SPECIFIERS) == false)  
import org.opensearch.script.Script;
        timeInMillis = maxTimeInMillis - sum;
import org.opensearch.common.logging.DeprecatedMessage;
            .get()
                List<String> filteredWarnings = filterJodaDeprecationWarnings(actualWarnings);  
    public static BlobPath getShardLevelBlobPath(
        if (size > collection.size()) {
            (LinkedHashMap<String, Object>) parser.mapOrdered(),
        logger.info("{}after test", getTestParamsForLogging());
        DiscoveryNode.setAdditionalRoles(Collections.emptySet());  
    private static final NamedXContentRegistry DEFAULT_NAMED_X_CONTENT_REGISTRY = new NamedXContentRegistry(  
            // increases this value, so the mod can eventually become zero, thus we shift on both sides by 1
import org.opensearch.monitor.jvm.JvmInfo;  
        if (sleepTimeInMillis > maxTimeInMillis) {
    private static final String[] TIME_SUFFIXES = new String[] { "d", "h", "ms", "s", "m", "micros", "nanos" };
import org.opensearch.core.xcontent.NamedXContentRegistry;
            .collect(Collectors.toList());  
     * non-standard characters.  
        return xContent.createParser(namedXContentRegistry, LoggingDeprecationHandler.INSTANCE, data.streamInput());  
    }  
import org.apache.logging.log4j.status.StatusConsoleListener;
        return RandomizedTest.randomRealisticUnicodeOfLength(codeUnits);  
            } else {  
                statusData.clear();
        // shutdown hook so that when the test JVM exits, logging is shutdown too  
        long randomLong = randomLong();  
        List<AssertionError> failures = new ArrayList<>();
            threadContext = null;
    public final void after() throws Exception {
    public static String replaceUnicodeControlCharacters(String uniCodeStr) {
                in.setVersion(version);
    @BeforeClass  
    }
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
     */  
    }
    public static <T> T randomFrom(T... array) {
                assertNull("unexpected warning headers", warnings);
    }
    public NodeEnvironment newNodeEnvironment() throws IOException {  
import static org.hamcrest.Matchers.equalTo;  
                        status -> status.getMessage()
    /**  
        @Override  
        }
    ) throws IOException {
     * @param maxArraySize The maximum number of elements in the random array  
     * Whether or not we check after each test whether it has left warnings behind. That happens if any deprecated feature or syntax
            for (AssertionError failure : failures) {
    }
    }
import java.util.Map;  
         */
    public static <T> List<T> randomSubsetOf(Collection<T> collection) {
     *
    }
     */  
                @Override  
            sum += timeInMillis;  
import java.util.Random;
        return scaledRandomIntBetween(min, max);
        long maxTimeInMillis = maxWaitTime.millis();  
        } catch (UnknownHostException e) {
    }  
    protected static long spinForAtLeastOneMillisecond() {
        for (String msg : expectedWarnings) {  
     * Returns size random values
                }  
            }
     * Create a new {@link XContentParser}.
            throw e;
            return PathUtils.get(getClass().getResource(relativePath).toURI()).toAbsolutePath().normalize();
            .sorted()
        return !rarely();  
        RemoteStoreEnums.PathHashAlgorithm hashAlgorithm = Objects.nonNull(remoteCustomData)
    protected final void assertNoDeprecationWarnings() {
            super.afterAlways(errors);
import org.opensearch.core.common.transport.TransportAddress;  
@SuppressCodecs({
import org.opensearch.index.analysis.TokenFilterFactory;
import org.opensearch.index.analysis.NamedAnalyzer;  
     */
     * @param stringSize The length of each String in the array
            this.headerWarningAppender = null;
    /**
        final List<String> actualWarnings = threadContext.getResponseHeaders().get("Warning");  
            }  
import org.apache.lucene.tests.util.LuceneTestCase;
        // We rely on Gradle implementation details here, the worker IDs are long values incremented by one for the  
            .indices()
                + actualWarnings,
    // TODO: replace frequently() with usually()
            timeInMillis *= 2;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
            );
    }  
    }  
import java.util.Arrays;
    /**
     */
 * this file be licensed under the Apache-2.0 license or a
     * Builds a set of unique items. Usually you'll get the requested count but you might get less than that number if the supplier returns  
    protected final XContentParser createParser(XContent xContent, InputStream data) throws IOException {  
import java.util.function.Predicate;
        // (e.g. FileSystemUtils, and likely some tests)  
    // separate method so that this can be checked again after suite scoped cluster is shut down
                warningsNotExpected.size(),  
     * generate a random DateTimeZone from the ones available in joda library  
            analysisRegistry.buildTokenFilterFactories(indexSettings),
                LinkedHashMap<String, Object> valueMap = (LinkedHashMap<String, Object>) value;
    public static String randomAlphaOfLengthBetween(int minCodeUnits, int maxCodeUnits) {
        Requests.INDEX_CONTENT_TYPE = MediaTypeRegistry.JSON;  
     * Same as {@link #copyWriteable(Writeable, NamedWriteableRegistry, Writeable.Reader)} but also allows to provide
            Thread.sleep(timeInMillis);
    }
     * <code>getClass().getResource(...).getFile()</code> this method will not
     */  
        AnalysisRegistry analysisRegistry = analysisModule.getAnalysisRegistry();
     * @param end            upper bound
        } else {  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;  
     * @param settings the settings that are expected to be deprecated  
     */  
    }
            if (things.size() == targetCount) {
        // See also: https://github.com/elastic/elasticsearch/issues/44134
    public static String randomTimeValue() {  
        // Oh well, we didn't get enough unique things. It'll be ok.  
    public static short randomShort() {  
    }  
    /**
        BootstrapForTesting.ensureInitialized();
    }
    }
import org.opensearch.core.index.Index;
                assertWarnings(stripXContentPosition, actualWarnings, expectedWarnings);  
    }  
                failures.add(e);  
            public void log(StatusData data) {
import org.junit.AfterClass;
    }
            codeBlock.run();  
import org.opensearch.script.ScriptType;
        long elapsed;
        return RandomPicks.randomFrom(random(), list);  
     * set to true, (start, end) otherwise.
        assertBusy(codeBlock, 10, TimeUnit.SECONDS);
                    // unit tests do not run with the bundled JDK, if there are warnings we need to filter the no-jdk deprecation warning  
     */  
            if (value instanceof Map) {  
        PathUtilsForTesting.setup();
import org.opensearch.common.time.DateUtils;
        // We check threadContext != null rather than enableWarningsCheck()  
        final String[] absPaths = new String[numPaths];
    public static <T extends Writeable> T copyWriteable(
        }
     */  
        return RandomizedTest.randomRealisticUnicodeOfLengthBetween(minCodeUnits, maxCodeUnits);
        }
            } else if (value instanceof List) {  
                + " warnings but found "  
                LinkedHashMap<String, Object> valueMap = (LinkedHashMap<String, Object>) value;
            emptyMap(),
