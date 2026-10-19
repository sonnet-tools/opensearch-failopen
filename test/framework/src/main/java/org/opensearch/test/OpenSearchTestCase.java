        public TestAnalysis(
                assertThat(
    ) throws IOException {
/*
        return createTestAnalysis(index, nodeSettings, settings, analysisPlugins);
    /**
     * a {@link Version} argument which will be used to write and read back the object.
    }
                LinkedHashMap<String, Object> valueMap = (LinkedHashMap<String, Object>) value;
     */
        Version version
    }
        assertEquals(expected.getMethodName(), actual.getMethodName());
        return new BigInteger(64, random());
    private static final NamedXContentRegistry DEFAULT_NAMED_X_CONTENT_REGISTRY = new NamedXContentRegistry(
     * Reset the deprecation logger by clearing the current thread context.
    public static final String TEST_WORKER_SYS_PROPERTY = "org.gradle.test.worker";
            if (things.size() == targetCount) {
    }
     * Creates an TestAnalysis with all the default analyzers configured.
    }
     * @return a random bigInteger in the range [0 ; 2^64 - 1]
        if (sleepTimeInMillis > maxTimeInMillis) {
        @Override
        if (workerIdStr == null) {
     * @param lowerInclusive whether or not to include lower end of the interval
import org.opensearch.core.common.bytes.BytesArray;
    }
        }
                        .collect(Collectors.toList());
        return RandomizedTest.randomUnicodeOfCodepointLength(codePoints);
import org.opensearch.transport.nio.MockNioTransportPlugin;
     * Create a new {@link XContentParser}.
            // busy spin
    private void resetDeprecationLogger() {
    }
                codeBlock.run();
     */
        XContentType xContentType,
            && (Locale.getDefault().toLanguageTag().equals("th-TH")
    private ThreadContext threadContext;
        T randomValue = null;
                    if (false == error instanceof AssumptionViolatedException) {
    @Retention(RetentionPolicy.RUNTIME)
    "FST50",
        return elapsed;
    }
        threadContext.stashContext();
    "LuceneVarGapFixedInterval",
    "SimpleText",
                                "no-jdk distributions that do not bundle a JDK are deprecated and will be removed in a future release"
    protected static final List<String> JAVA_ZONE_IDS;
        }
        return xContent.createParser(xContentRegistry(), LoggingDeprecationHandler.INSTANCE, data);
     * an alias to {@link #scaledRandomIntBetween(int, int)}.
    /**
        ClusterModule.getNamedWriteables()
 *
    }
            actualWarnings.size()
    /**
    protected static long spinForAtLeastOneMillisecond() {
        }
     * Called when a test fails, supplying the errors it generated. Not called when the test fails because assumptions are violated.
                        throw new RuntimeException(ioe);
        // (e.g. FileSystemUtils, and likely some tests)
    }
            assertEquals(expected[i], actual[i]);
        return terminated;
    public static DateTimeZone randomDateTimeZone() {
                    filteredStatusData.stream().map(status -> status.getMessage().getFormattedMessage()).collect(Collectors.toList()),
    }
                statusData.clear();
        final int numPaths = TestUtil.nextInt(random(), 1, 3);
        try {
    public static boolean inFipsJvm() {
            final List<String> actualWarnings = threadContext.getResponseHeaders().get("Warning");
        protected void afterAlways(List<Throwable> errors) throws Throwable {
            @Override
     * Recursively goes through inner objects and also shuffles them. Exceptions for this
            (out, value) -> out.writeNamedWriteable(value),
    }
    }
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey());
    protected final void assertSettingDeprecationsAndWarnings(final Setting<?>[] settings, final String... warnings) {
        long start = System.nanoTime();
        try (XContentParser parser = createParser(builder)) {
    }
        T original,
        return targetList;
        assertEquals(expected.getClassName(), actual.getClassName());
        if (end < 0) return "";
import java.util.concurrent.CopyOnWriteArrayList;
    }
     * Runs the code block for the provided interval, waiting for no assertions to trip.
                        break;
            in -> in.readNamedWriteable(categoryClass),
            };
    /** A random integer from 0..max (inclusive). */
import org.opensearch.plugins.AnalysisPlugin;
        ensureAllSearchContextsReleased();
     * @param breakSupplier determines whether to return immediately or continue waiting.
        return randomValue;
        }
            try {
        return RandomNumbers.randomIntBetween(random(), min, max);
     * by the {@link ToXContent#isFragment()} method returns. Shuffles the keys to make sure that parsing never relies on keys ordering.
    public static <T> List<T> randomSubsetOf(int size, T... values) {
        // ensure no one changed the status logger level on us
    /** MockFSDirectoryService sets this: */
    }
                return InetAddress.getByAddress(ipv6);
                 * StatusData instances to Strings as otherwise their toString output is useless
        return random().nextBoolean();
    }
                // we clear the list so that status data from other tests do not interfere with tests within the same JVM
    public final void before() {
    /**
                return true;
    ) throws IOException {
    }
        do {
    }
        boolean humanReadable,
     *
    }
                        }
            if (v4) {
import java.util.EnumSet;
            } finally {
    /** Returns a random number of temporary paths. */
        if (token == Token.START_ARRAY) {
     * <code>getClass().getResource(...).getFile()</code> this method will not
    @Rule
     * {@link OpenSearchTestCase#assertBusy(CheckedRunnable)} instead.
                codeBlock.run();
        String... exceptFieldNames
        }
    public static Script mockScript(String id) {
        final String workerIdStr = System.getProperty(OpenSearchTestCase.TEST_WORKER_SYS_PROPERTY);
        // because some code is buggy when it comes to multiple nio.2 filesystems
    @Override
     * @deprecated use {@link #toShuffledXContent(ToXContent, MediaType, ToXContent.Params, boolean, String...)} instead
    }
        System.setProperty("log4j.shutdownHookEnabled", "false");
    public static String replaceUnicodeControlCharacters(String uniCodeStr) {
            .collect(Collectors.toList());
            while (result < start || result > end || Double.isNaN(result)) {
    public static String randomUnicodeOfCodepointLength(int codePoints) {
            } else {
    /**
        BootstrapForTesting.ensureInitialized();
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            new HashSet<>(Arrays.asList(exceptFieldNames))
    ) throws IOException {
            try (StreamInput in = new NamedWriteableAwareStreamInput(output.bytes().streamInput(), namedWriteableRegistry)) {
    public static int scaledRandomIntBetween(int min, int max) {
    }
    static {
     */
     * internally should stay untouched.
     */
        try {
     * Builds a set of unique items. Usually you'll get the requested count but you might get less than that number if the supplier returns
     * non-standard characters.
                    statusData.add(data);
        try {
    }
    }
    }
    protected final void assertSettingDeprecationsAndWarnings(final String[] settings, final String... warnings) {
        );
    public static <T> List<T> randomSubsetOf(Collection<T> collection) {
    }
    private static List<Object> shuffleList(List<Object> list, Set<String> exceptFields) {
    protected void afterIfSuccessful() throws Exception {}
        portGenerator.set(0);
    }
import org.opensearch.env.NodeEnvironment;
    public static String getPortRange() {
        return (short) random().nextInt();
    public static Class<? extends Plugin> getTestTransportPlugin() {
import org.opensearch.common.util.set.Sets;
        Appender leakAppender = new AbstractAppender(leakLoggerName, null, PatternLayout.newBuilder().withPattern("%m").build()) {
        Settings indexSettings = Settings.builder().put(settings).put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT).build();
        return xContentBuilder.map(shuffledMap);
        }));
        String fixedPrefix
        return type.path(pathInput, hashAlgorithm);
import org.opensearch.plugins.Plugin;
                + expectedWarnings.length
                }
                if (JvmInfo.jvmInfo().getBundledJdk() == false) {
    /**
        return (byte) random().nextInt();
        // Oh well, we didn't get enough unique things. It'll be ok.
            logger.warn(
    }
     * helper to get a random value in a certain range that's different from the input
     * are not logged again.
     */
    public static String randomUnicodeOfCodepointLengthBetween(int minCodePoints, int maxCodePoints) {
    }
            Thread.sleep(sleepTimeInMillis);
            .map(s -> HeaderWarning.extractWarningValueFromWarningHeader(s, stripXContentPosition))
import org.opensearch.index.analysis.CharFilterFactory;
                    )
            } else {
    }
import org.opensearch.transport.TransportService;
            .filter(s -> DateUtils.DEPRECATED_SHORT_TZ_IDS.contains(s) == false)
    public static int randomInt() {
import java.util.Map;
        Schedulers.shutdownNow();
    private static final Collection<String> nettyLoggedLeaks = new ArrayList<>();
        return RandomPicks.randomFrom(random, array);
        List<AssertionError> failures = new ArrayList<>();
     */
 * Unless required by applicable law or agreed to in writing,
    }
        long sleepTimeInMillis = sleepTime.millis();
            } finally {
    protected final void assertNoDeprecationWarnings() {
    // Allows distinguishing between parallel test processes
                    + "\nActual: "
            result = Double.longBitsToDouble(randomLong());
        // be smart enough to re-connect depending on what is tested. To reduce the risk, since this is very hard to debug we use
                    OpenSearchTestCase.this.afterIfFailed(errors);
    /**
import org.opensearch.Version;
        JAVA_TIMEZONE_IDS = Collections.unmodifiableList(javaTZIds);
                    // unit tests do not run with the bundled JDK, if there are warnings we need to filter the no-jdk deprecation warning
     * Returns a random subset of values (including a potential empty list, or the full original list)
            LoggerContext context = (LoggerContext) LogManager.getContext(false);
     * A random long number between min (inclusive) and max (inclusive).
        return new NamedWriteableRegistry(ClusterModule.getNamedWriteables());
        return new PersistedStateRegistry();
import org.apache.logging.log4j.core.appender.AbstractAppender;
    public static boolean terminate(ExecutorService... services) {
     * Modify this random generator if a wider range for BigIntegers is necessary.
        try {
     * helper to randomly perform on <code>consumer</code> with <code>value</code>
import org.opensearch.core.xcontent.XContentHelper;
    public static boolean frequently() {
    protected final XContentParser createParser(XContent xContent, InputStream data) throws IOException {
            ).toArray(String[]::new)
import org.opensearch.common.Numbers;
        String value();
        return builder;
        return getBasePort() + "-" + (getBasePort() + 99); // upper bound is inclusive
        return RandomizedTest.randomUnicodeOfCodepointLengthBetween(minCodePoints, maxCodePoints);
        }
     * result and we don't even expose it there.
        TEST_WORKER_VM_ID = System.getProperty(TEST_WORKER_SYS_PROPERTY, DEFAULT_TEST_WORKER_ID);
     * helper to get a random value in a certain range that's different from the input
            timeInMillis = Math.min(AWAIT_BUSY_THRESHOLD, timeInMillis * 2);
     * generate a random TimeZone from the ones available in java.util
        int end = name.lastIndexOf('}');
        Map<String, Object> shuffledMap = shuffleMap(
import org.opensearch.common.logging.HeaderWarningAppender;
        if (enableWarningsCheck() == false) {
        } finally {
                .collect(Collectors.toSet());
            resetDeprecationLogger();
     * @return the last value returned by <code>breakSupplier</code>
    /**
            }
import org.opensearch.cluster.coordination.PersistedStateRegistry;
    @Before
     * @param breakSupplier determines whether to return immediately or continue waiting.
     */
                random().nextBytes(ipv4);
            final Set<String> actualWarningValues = actualWarnings.stream()
    /**
    @Override
 */
    public static XContentBuilder shuffleXContent(XContentParser parser, boolean prettyPrint, String... exceptFieldNames)
    }
        return targetMap;
    }
import org.junit.After;
         * @param description annotated test description.
        }
            for (AssertionError failure : failures) {
    @Before
    public static <T> Set<T> randomUnique(Supplier<T> supplier, int targetCount) {
import org.opensearch.core.common.io.stream.StreamInput;
    }
        return false;
                    }
    }
            startAt = 0; // IDE
 * The OpenSearch Contributors require contributions made to
        }
        int randomInt = randomInt();
        return randomFrom(formatNames).getSnakeCaseName();
    }
    public static Settings.Builder warmIndexSettings(Version version) {
        final T[] array = arrayConstructor.apply(size);
            this.tokenFilter = tokenFilter;
import java.util.TimeZone;
     * Define LockFeatureFlag annotation for unit tests.
        timeInMillis = maxTimeInMillis - sum;
            }
            namedWriteableRegistry,
import static org.hamcrest.Matchers.equalTo;
        if (this.headerWarningAppender != null) {
        // appropriate test
    private void assertWarnings(boolean stripXContentPosition, List<String> actualWarnings, String[] expectedWarnings) {
    }
    }
                return;
import org.opensearch.common.settings.Settings;
    }
    protected static int getBasePort() {
        }
            }
        protected void afterIfSuccessful() throws Throwable {
import org.opensearch.common.util.FeatureFlags;
     * generate a random DateTimeZone from the ones available in joda library
                        pw.print(":");
                targetList.add(value);
    public static <T> T randomFrom(List<T> list) {
        ToXContent.Params params,
        return RandomizedTest.randomInt(max);
        Writeable.Reader<T> reader,
                    + actualWarningValues,
    }
                terminated &= ThreadPool.terminate(service, 10, TimeUnit.SECONDS);
import java.util.HashSet;
        this.headerWarningAppender = HeaderWarningAppender.createAppender("header_warning", null);
    private void ensureNoWarnings() {
    }
                byte[] ipv6 = new byte[16];
    // this must be a separate method from other ensure checks above so suite scoped integ tests can call...TODO: fix that
import org.opensearch.core.common.io.stream.Writeable;
        JAVA_ZONE_IDS = Collections.unmodifiableList(javaZoneIds);
    /**
        try {
     */
        return absPaths;
        return randomIntBetween(min, max);
    public static String randomRealisticUnicodeOfCodepointLengthBetween(int minCodePoints, int maxCodePoints) {
    @BeforeClass
     */
    public static byte[] randomByteArrayOfLength(int size) {
import org.apache.lucene.tests.util.TestUtil;
        // some tests use MockTransportService to do network based testing. Yet, we run tests in multiple JVMs that means
    public static void restoreFileSystem() throws Exception {
        BytesReference bytes = XContentHelper.toXContent(toXContent, mediaType, params, humanReadable);
 * this work for additional information regarding copyright
     * Create a new {@link XContentParser}.
        long sum = 0;
        for (Object value : list) {
     */
                        allAssumption = false;
    ) {
    public static void setFileSystem() throws Exception {
     */
    }
        // In case you've forgotten your high-school studies, log10(x) / log10(y) == log y(x)
        RemoteStoreEnums.PathType type = Objects.isNull(remoteCustomData)
        }
        Settings.Builder builder = Settings.builder()
package org.opensearch.test;
     * Returns the bytes that represent the XContent output of the provided {@link ToXContent} object, using the provided
     * recursive shuffling behavior can be made by passing in the names of fields which
        return RandomizedTest.randomAsciiOfLengthBetween(minCodeUnits, maxCodeUnits);
    protected final XContentParser createParser(NamedXContentRegistry namedXContentRegistry, XContent xContent, BytesReference data)
import org.opensearch.index.analysis.AnalysisRegistry;
        // "clear" context by stashing current values and dropping the returned StoredContext
        return createParser(xContentRegistry(), xContent, data);
import org.opensearch.core.index.Index;
     * @param allowNull Whether the returned array may be null
        }
        long elapsed;
        RemoteStoreEnums.PathHashAlgorithm hashAlgorithm = Objects.nonNull(remoteCustomData)
                            + "See the breaking changes documentation for the next major version."
                    filteredWarnings = filterJodaDeprecationWarnings(filteredWarnings);
import org.apache.logging.log4j.core.layout.PatternLayout;
// we suppress pretty much all the lucene codecs for now, except asserting
    }
    private static boolean isUnusableLocale() {
                @Override
    public static boolean terminate(ThreadPool threadPool) {
import org.apache.lucene.tests.util.TestRuleMarkFailure;
 *
            LockFeatureFlag annotation = description.getAnnotation(LockFeatureFlag.class);
        Environment env = TestEnvironment.newEnvironment(nodeSettings);
     * @return a <code>long</code> between <code>0</code> and <code>Long.MAX_VALUE</code> (inclusive) chosen uniformly at random.
    }
            throw new IllegalArgumentException("sleepTime is more than the maxWaitTime");
        return actualWarnings.stream()
            sum += timeInMillis;
     * @param allowEmpty Whether the returned array may be empty (have zero elements)
     * @see #scaledRandomIntBetween(int, int)
        final int startAt;
    }
     * @return a random bigInteger in the range [0 ; 2^64 - 1]
        return "[" + name.substring(start + 1, end) + "] ";
    }
            consumer.accept(value);
        }
    }
    /**
        return copyNamedWriteable(original, namedWriteableRegistry, categoryClass, Version.CURRENT);
import org.apache.logging.log4j.core.config.Configurator;
     * @throws InterruptedException if any sleep calls were interrupted.
        for (int i = 0; i < size; i++) {
     */
            }
    }
import java.util.Random;
import org.opensearch.cluster.node.DiscoveryNode;
            );
         */
    }
            .index(remoteStoreIndex)
    protected static final NamedWriteableRegistry DEFAULT_NAMED_WRITABLE_REGISTRY = new NamedWriteableRegistry(
        }
    }
    /**
        for (int i = 0; i < arraySize; i++) {
        return RandomPicks.randomFrom(random(), list);
import java.util.ArrayList;
    "Lucene90",
        try {
            .indices()
        return getBasePort(10300);
    protected final Logger logger = LogManager.getLogger(getClass());
 * license agreements. See the NOTICE file distributed with
    public static class GeohashGenerator extends CodepointSetGenerator {
    public static void ensureSupportedLocale() {
            }
        for (ExecutorService service : services) {
import org.apache.lucene.tests.util.LuceneTestCase.SuppressCodecs;
import org.opensearch.env.TestEnvironment;
            .filter(m -> m.contains(JodaDeprecationPatterns.USE_NEW_FORMAT_SPECIFIERS) == false)
                failures.add(e);
     * Recursively goes through inner objects and also shuffles them. Exceptions for this
            sum += timeInMillis;
        );
        long timeInMillis = 1;
import org.opensearch.core.xcontent.MediaType;
        // because after methods are still called in the event that before
    protected final XContentParser createParser(XContentBuilder builder) throws IOException {
    @Before
        }
    }
import org.opensearch.index.analysis.TokenFilterFactory;
    /**
        DeprecatedMessage.resetDeprecatedMessageForTests();
            throw new AssertionError();
     * Currently BigIntegers are only used for unsigned_long field type, where the max value is 2^64 - 1.
            this.threadContext = new ThreadContext(Settings.EMPTY);
            } else {
     */
    /**
    /**
import org.opensearch.common.logging.Loggers;
        Requests.INDEX_CONTENT_TYPE = MediaTypeRegistry.JSON;
     * use {@link OpenSearchTestCase#assertBusy(CheckedRunnable)} instead.
            for (Exception failure : checkIndexFailures) {
                        if (sd.getStackTraceElement() != null) {
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
            super.afterAlways(errors);
                        base.evaluate();
     */
                nettyLoggedLeaks.clear();
    public static Settings.Builder remoteIndexSettings(Version version) {
import org.opensearch.core.common.io.stream.NamedWriteableAwareStreamInput;
            try {
                String message = event.getMessage().getFormattedMessage();
            .collect(Collectors.toList());
            writer.write(output, original);
        while ((elapsed = (System.nanoTime() - start)) < nanosecondsInMillisecond) {
                        if (sd.getThrowable() != null) {
     * Same as {@link #copyWriteable(Writeable, NamedWriteableRegistry, Writeable.Reader)} but also allows to provide
    }
        public final Map<String, TokenizerFactory> tokenizer;
    public static class AnnotatedFeatureFlagRule implements TestRule {
        assertEquals(expected.isNativeMethod(), actual.isNativeMethod());
        JODA_TIMEZONE_IDS = Collections.unmodifiableList(jodaTZIds);
    "CheapBastard",
        Writeable.Reader<T> reader,
    @BeforeClass
    protected NamedXContentRegistry xContentRegistry() {
    public void setHeaderWarningAppender() {
        BytesReference bytes = XContentHelper.toXContent(toXContent, xContentType, params, humanReadable);
            sum += sleepTimeInMillis;
    /**
    public static String randomPositiveTimeValue() {
    public static final List<Exception> checkIndexFailures = new CopyOnWriteArrayList<>();
        checkStaticState(false);
        Requests.INDEX_CONTENT_TYPE = randomFrom(XContentType.values());
            analysisRegistry.build(indexSettings),
import com.carrotsearch.randomizedtesting.generators.RandomStrings;
import org.opensearch.common.io.stream.BytesStreamOutput;
    /**
 */
    }
    ) throws IOException {
import org.junit.rules.TestRule;
     * The exact opposite of {@link #rarely()}.
        for (int i = 0; i < size; i++) {
    /**
import org.opensearch.core.common.io.stream.NamedWriteable;
    }
 * this file be licensed under the Apache-2.0 license or a
        return new IndexAnalyzers(
        }
import org.opensearch.env.Environment;
        return replaceUnicodeControlCharacters(uniCodeStr, " ");
     * set to true, (start, end) otherwise.
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.common.joda.JodaDeprecationPatterns;
            "Expected "
        }
    }
        return RandomizedTest.scaledRandomIntBetween(min, max);
    public static String randomUnicodeOfLengthBetween(int minCodeUnits, int maxCodeUnits) {
        int maxTries = targetCount * 10;
import java.util.Set;
import org.opensearch.common.blobstore.BlobPath;
    /**
    }
import org.opensearch.bootstrap.BootstrapForTesting;
import com.carrotsearch.randomizedtesting.RandomizedTest;
import org.opensearch.common.io.PathUtils;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
        /**
     */
    "Lucene90",
        assertEquals(expected.length, actual.length);
    public static <T> T randomFrom(Random random, Collection<T> collection) {
        if (threadContext != null) {
        Settings nodeSettings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
        for (int i = 0; i < expected.length; i++) {
import org.opensearch.common.logging.HeaderWarning;
        // we need a sorted map for reproducibility, as we are going to shuffle its keys and write XContent back
    }
    }
@ThreadLeakScope(Scope.SUITE)
import java.io.IOException;
        logger.info("{}before test", getTestParamsForLogging());
    }
            ensureNoWarnings();
     * Generates a new transport address using {@link TransportAddress#META_ADDRESS} with an incrementing port number.
import org.opensearch.common.util.MockPageCacheRecycler;
    public static void assertBusy(CheckedRunnable<Exception> codeBlock) throws Exception {
     */
    public static BigInteger randomUnsignedLong() {
    public static String randomTimeValue() {
    public static <T> T randomValueOtherThan(T input, Supplier<T> randomSupplier) {
import java.util.stream.Collectors;
            throw e;
import java.net.UnknownHostException;
            assertThat(actualWarningValues, hasItem(HeaderWarning.escapeAndEncode(msg)));
            if (value instanceof Map && exceptFields.contains(key) == false) {
import java.util.LinkedHashMap;
        public Statement apply(Statement base, Description description) {
        ensureCheckIndexPassed();
        return scaledRandomIntBetween(min, max);
                || Locale.getDefault().toLanguageTag().equals("ja-JP-u-ca-japanese-x-lvariant-JP")
    }
import org.apache.logging.log4j.Logger;
        return !rarely();
            HeaderWarning.setThreadContext(threadContext);
                + "\nExpected: "
    }
        assertEquals(expected.getFileName(), actual.getFileName());
    public static String randomGeohash(int minPrecision, int maxPrecision) {
    }
            throw e;
                e.addSuppressed(failure);
    "Lucene50",
    /**
     */
        // methods failed, in which case threadContext might not have been
     * @param stringSize The length of each String in the array
        List<T> list = new ArrayList<>();
    @Rule
     * Flag returned to previous value on test exit.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.NamedXContentRegistry;
        };
     * generate a random TimeZone from the ones available in java.time
import java.io.StringWriter;
    public static <T> List<T> randomList(int minListSize, int maxListSize, Supplier<T> valueConstructor) {
                assertWarnings(stripXContentPosition, filteredWarnings, expectedWarnings);
                }
                    .toList();
// assertingcodec is the winner for a codec here: it finds bugs and gives clear exceptions.
    public final void after() throws Exception {
                warningsNotExpected.size(),
    // TODO: decide on one set of naming for between/scaledBetween and remove others
     */
     */
     *
        public final Map<String, TokenFilterFactory> tokenFilter;
     */
                    try (final StringWriter sw = new StringWriter(); final PrintWriter pw = new PrintWriter(sw)) {
            .dataCategory(dataCategory)
    public Path getDataPath(String relativePath) {
        return createTestAnalysis(IndexSettingsModule.newIndexSettings(index, indexSettings), nodeSettings, analysisPlugins);
     * as the first argument. In contrast to
                LoggingDeprecationHandler.INSTANCE,
    }
                targetList.add(shuffleMap(valueMap, exceptFields));
        Collections.sort(javaTZIds);
            expectedWarnings.length,
        ToXContent toXContent,
            } else if (value instanceof List) {
        assertWarnings(
            final List<String> warnings = threadContext.getResponseHeaders().get("Warning");
        long maxTimeInMillis = maxWaitTime.millis();
        BlobPath basePath,
        throws Exception {
     *
    public static double randomDoubleBetween(double start, double end, boolean lowerInclusive) {
    }
                public void evaluate() throws Throwable {
     *
            this.indexAnalyzers = indexAnalyzers;
     * Randomly shuffles the fields inside objects in the {@link XContentBuilder} passed in.
import org.opensearch.index.analysis.TokenizerFactory;
                array.array(),
        Logger leakLogger = LogManager.getLogger(leakLoggerName);
/**
    "Direct",
        );
    }
import java.util.List;
                return;
/*
                            final var messageSource = sd.getStackTraceElement();
import java.io.InputStream;
        }
        System.setProperty("io.netty.leakDetection.level", "paranoid");
import org.opensearch.index.IndexModule;
        private static final char[] ASCII_SET = "0123456789bcdefghjkmnpqrstuvwxyz".toCharArray();
    "Lucene95",
                    synchronized (nettyLoggedLeaks) {
     * is reached. This version uses a timeout of 10 seconds. If at all possible,
                            pw.println("Source:");
        Settings.Builder builder = Settings.builder()
    );
                 */
     */
    @SuppressForbidden(reason = "force log4j and netty sysprops")
     * Periodically execute the supplied function until it returns true, or until the
            list.add(valueConstructor.get());
    }
     * Returns a "scaled" number of iterations for loops which can have a variable
        } else {
        }
    public @interface LockFeatureFlag {
        Collections.sort(javaZoneIds);
        List<Object> targetList = new ArrayList<>();
import org.opensearch.core.common.bytes.BytesReference;
                            + k
        assertTrue("Found duplicate warnings logged", actualWarnings == null);
                            .contains("No Root logger was configured, creating default ERROR-level Root logger") == false
     * Creates an IndexAnalyzers with a single default analyzer
        synchronized (statusData) {
                        pw.print(sd.getLevel());
     */
        return random().nextFloat();
                targetMap.put(key, shuffleList((List) value, exceptFields));
import java.math.BigInteger;
                            pw.println(messageSource.getFileName() + "@" + messageSource.getLineNumber());
        StatusLogger.getLogger().setLevel(Level.WARN);
    }
        String leakLoggerName = "io.netty.util.ResourceLeakDetector";
     * Returns size random values
            }
        // Enable Netty leak detection and monitor logger for logged leak errors
        return random().nextDouble();
            } else {
            final AssertionError e = new AssertionError("at least one shard failed CheckIndex");
        }
            Stream.concat(
    /**
    public static int randomIntBetween(int min, int max) {
import java.util.function.IntFunction;
    public static void assertEquals(StackTraceElement expected, StackTraceElement actual) {
        Thread.sleep(Math.max(timeInMillis, 0));
        boolean humanReadable,
        AnalysisModule analysisModule = new AnalysisModule(env, Arrays.asList(analysisPlugins));
            startAt = (int) Math.floorMod(workerId - 1, 223L) + 1;
        RemoteStorePathStrategy.ShardDataPathInput pathInput = RemoteStorePathStrategy.ShardDataPathInput.builder()
                assertWarnings(stripXContentPosition, actualWarnings, expectedWarnings);
        // See also: https://github.com/elastic/elasticsearch/issues/44134
     */
     * Returns a unique port range for this JVM starting from the computed base port
        }
        return geohashGenerator.ofStringLength(random(), minPrecision, maxPrecision);
import org.junit.Rule;
    private HeaderWarningAppender headerWarningAppender;
    public static byte randomByte() {
import com.carrotsearch.randomizedtesting.annotations.Listeners;
    }
        Collections.shuffle(keys, random());
        int arraySize = randomIntBetween(allowEmpty ? 0 : 1, maxArraySize);
            Map<String, TokenFilterFactory> tokenFilter,
                }
     * Create a copy of an original {@link NamedWriteable} object by running it through a {@link BytesStreamOutput} and
     * This cute helper class just holds all analysis building blocks that are used
        return array;
        return uniCodeStr.replaceAll("\\p{Cc}", toReplaceWith);
    @AfterClass
     */
                    try (FeatureFlags.TestUtils.FlagWriteLock ignored = new FeatureFlags.TestUtils.FlagWriteLock(flagKey)) {
     * Create a new {@link XContentParser}.
        return randomTimeValue(lower, upper, TIME_SUFFIXES);
    /** Pick a random object from the given collection. */
     * Helper method to create a byte array of a given length populated with random byte values
    }
    @Target({ ElementType.METHOD })
                Arrays.stream(settings)
     * Returns a random BigInteger uniformly distributed over the range 0 to (2^64 - 1) inclusive
            }
    /**
            return null;
    public static int randomNonNegativeInt() {
    "Lucene94",
        }
    }
    @SuppressWarnings("unchecked")
            return new Statement() {
    });
        byte[] bytes = new byte[size];
    }
import org.junit.rules.RuleChain;
            }
            } catch (AssertionError e) {
    protected boolean enableWarningsCheck() {
                 *
     */
                assertNull("unexpected warning headers", warnings);
    /**
        // concurrent tests could claim port that another JVM just released and if that test tries to simulate a disconnect it might
        return DateTimeZone.forID(randomFrom(JODA_TIMEZONE_IDS));
        return RandomizedTest.randomRealisticUnicodeOfCodepointLengthBetween(minCodePoints, maxCodePoints);
                byte[] ipv4 = new byte[4];
    // Suite and test case setup/cleanup.
        return MockNioTransportPlugin.class;
        Settings.Builder builder = Settings.builder().put(IndexMetadata.SETTING_VERSION_CREATED, version);
        } while (input.test(randomValue));
            final Set<String> warningsNotExpected = Sets.difference(actualWarningValues, expectedWarnings);
        String indexUUID = client.admin()
    public static String randomAlphaOfLength(int codeUnits) {
    protected final void allowedWarnings(String... allowedWarnings) {
        return new NodeEnvironment(build, TestEnvironment.newEnvironment(build));
        return inFipsJvm()
        long nanosecondsInMillisecond = TimeUnit.NANOSECONDS.convert(ms, TimeUnit.MILLISECONDS);
import org.joda.time.DateTimeZone;
     */
    public static int iterations(int min, int max) {
        return RandomizedTest.randomUnicodeOfLength(codeUnits);
     */
        // initialized
        // ensure that the status logger is set to the warn level so we do not miss any warnings with our Log4j usage
                }
            .indexUUID(indexUUID)
    }
    public static boolean waitUntil(BooleanSupplier breakSupplier) throws InterruptedException {
        }
     * reading it in again using a provided {@link Writeable.Reader}. The stream that is wrapped around the {@link StreamInput}
     * @param start          lower bound of interval to draw uniformly distributed random numbers from
     * still need to do internally e.g. in bwc serialization and in the extract() method
        }
    protected final BytesReference toShuffledXContent(
        if (enableWarningsCheck() == false) {
        }
    protected static final List<String> JODA_TIMEZONE_IDS;
        NamedWriteableRegistry namedWriteableRegistry,
        if (prettyPrint) {
import org.opensearch.common.time.DateUtils;
        return copyWriteable(original, namedWriteableRegistry, reader, Version.CURRENT);
    protected final BytesReference toShuffledXContent(
            }
import java.util.Locale;
    }
import com.carrotsearch.randomizedtesting.rules.TestRuleAdapter;
        Version version
                Arrays.stream(warnings)
    }
            codeBlock.run();
            .collect(Collectors.toSet());
    /** Returns the suite failure marker: internal use only! */
        List<String> keys = new ArrayList<>(map.keySet());
                    ),
    public static String randomDateFormatterPattern() {
     * @param unit the unit of tie for <code>maxWaitTime</code>
     */
        for (int i = 0; i < numPaths; i++) {
        try (XContentParser parser = createParser(xContentType.xContent(), bytes)) {
import org.apache.logging.log4j.core.Appender;
     * Runs the code block for 10 seconds waiting for no assertion to trip.
    }
    /**
        public final IndexAnalyzers indexAnalyzers;
    }
        long sum = 0;
        return spinForAtLeastNMilliseconds(1);
     */
    protected final XContentBuilder shuffleXContent(XContentBuilder builder, String... exceptFieldNames) throws IOException {
    // so that all accesses are plumbed thru any mock wrappers
        throws IOException {
            return PathUtils.get(getClass().getResource(relativePath).toURI()).toAbsolutePath().normalize();
        Requests.CONTENT_TYPE = XContentType.SMILE;
            try (XContentBuilder builder = shuffleXContent(parser, rarely(), exceptFieldNames)) {
        return xContent.createParser(xContentRegistry(), LoggingDeprecationHandler.INSTANCE, data);
    }
    /**
        return bytes;
        T original,
    public static TestAnalysis createTestAnalysis(Index index, Settings settings, AnalysisPlugin... analysisPlugins) throws IOException {
        }
        return value;
            codeBlock.run();
        }
            }
    }
    public static <T extends Writeable> T copyWriteable(
        System.setProperty("log4j2.disable.jmx", "true");
    public static String[] generateRandomStringArray(int maxArraySize, int stringSize, boolean allowNull) {
                synchronized (statusData) {
        return randomTimeValue(0, 1000);
    "Compressing",
                    }
    }
    }
     * Whether or not we check after each test whether it has left warnings behind. That happens if any deprecated feature or syntax
     * internally should stay untouched.
                }
    public static String randomRealisticUnicodeOfCodepointLength(int codePoints) {
import org.opensearch.common.settings.Setting;
import org.opensearch.cluster.ClusterState;
        if (enableWarningsCheck()) {
        final String[] absPaths = new String[numPaths];
    public static void assertBusyWithFixedSleepTime(CheckedRunnable<Exception> codeBlock, TimeValue maxWaitTime, TimeValue sleepTime)
        Loggers.addAppender(LogManager.getLogger("org.opensearch.deprecation"), this.headerWarningAppender);
                || Locale.getDefault().toLanguageTag().equals("th-TH-u-nu-thai-x-lvariant-TH"));
            }
            } catch (AssertionError e) {
    private List<String> filterJodaDeprecationWarnings(List<String> actualWarnings) {
    /**
    /**
            leakAppender.stop();
    public static TestAnalysis createTestAnalysis(IndexSettings indexSettings, Settings nodeSettings, AnalysisPlugin... analysisPlugins)
     * iteration count. This method is effectively
    public static String replaceUnicodeControlCharacters(String uniCodeStr, String toReplaceWith) {
     */
    }
import org.opensearch.core.xcontent.XContent;
    }
        long maxTimeInMillis = TimeUnit.MILLISECONDS.convert(maxWaitTime, unit);
        if (allowNull && random().nextBoolean()) {
    }
    }
import org.apache.logging.log4j.status.StatusLogger;
    }
import static org.hamcrest.Matchers.hasItem;
     * Convenience method to assert warnings for settings deprecations and general deprecation warnings.
        }
    public static String randomTimeValue(int lower, int upper) {
        Thread.sleep(Math.max(timeInMillis, 0));
            } else {
        assertNull("Thread context initialized twice", threadContext);
        return RandomizedTest.randomAsciiOfLength(codeUnits);
import java.util.function.Consumer;
    );
        long timeInMillis = 1;
    /**
            array[i] = RandomStrings.randomAsciiOfLength(random(), stringSize);
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
     * Randomly shuffles the fields inside objects parsed using the {@link XContentParser} passed in.
     * Currently BigIntegers are only used for unsigned_long field type, where the max value is 2^64 - 1.
                    + "switching to English. See: https://github.com/bcgit/bc-java/issues/405"
     * @see RandomizedTest#scaledRandomIntBetween(int, int)
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                        }
import org.opensearch.test.junit.listeners.LoggingListener;
     * The {@link NamedXContentRegistry} to use for this test. Subclasses should override and use liberally.
    // After 1s, we stop growing the sleep interval exponentially and just sleep 1s until maxWaitTime
                "Can\'t pick " + size + " random objects from a collection of " + collection.size() + " objects"
            );
                return BytesReference.bytes(builder);
            .put(IndexModule.IS_WARM_INDEX_SETTING.getKey(), true)
    public static String[] generateRandomStringArray(int maxArraySize, int stringSize, boolean allowNull, boolean allowEmpty) {
     * @param settings the settings that are expected to be deprecated
            .sorted()
                array.length()
     */
            }
    protected void afterIfFailed(List<Throwable> errors) {}
    // -----------------------------------------------------------------
    /**
    }
        Collections.shuffle(tempList, random());
            Logger logger = LogManager.getLogger(OpenSearchTestCase.class);
        // shutdown hook so that when the test JVM exits, logging is shutdown too
     * Modify this random generator if a wider range for BigIntegers is necessary.
            return shuffleXContent(parser, builder.isPrettyPrint(), exceptFieldNames);
    public static <T> List<T> randomSubsetOf(int size, Collection<T> collection) {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.script.ScriptType;
     * by the {@link ToXContent#isFragment()} method returns. Shuffles the keys to make sure that parsing never relies on keys ordering.
    public static float randomFloat() {
            throw new IllegalArgumentException(
        // We rely on Gradle implementation details here, the worker IDs are long values incremented by one for the
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope.Scope;
import org.opensearch.core.xcontent.XContentParser.Token;
    }
import org.opensearch.index.analysis.NamedAnalyzer;
     */
     */
        ) {
        return DEFAULT_NAMED_X_CONTENT_REGISTRY;
    }
import org.opensearch.transport.client.Client;
            Configurator.shutdown(context);
    /**
    public static TestRuleMarkFailure getSuiteFailureMarker() {
import java.util.function.Supplier;
    /**
    @After
     */
    public static Settings.Builder settings(Version version) {
            final List<String> actualWarnings = threadContext.getResponseHeaders().get("Warning");
        String remoteStoreIndex,
 * Base testcase for randomized unit testing with OpenSearch
    }
import org.opensearch.index.IndexSettings;
        long randomLong = randomLong();
                            .getFormattedMessage()
import org.opensearch.script.Script;
    "MockRandom",
            try {
    // TODO: replace frequently() with usually()
                + actualWarnings.size()
        timeInMillis = maxTimeInMillis - sum;
     * @see #scaledRandomIntBetween(int, int)
     * @throws InterruptedException if any sleep calls were interrupted.
    }
        });
        StatusLogger.getLogger().registerListener(new StatusConsoleListener(Level.WARN) {
    }
        // replace control characters (https://stackoverflow.com/questions/3438854/replace-unicode-control-characters/)
}
 * not use this file except in compliance with the License.
        return randomLong == Long.MIN_VALUE ? 0 : Math.abs(randomLong);
        for (String key : keys) {
            result = result * end + (1.0 - result) * start;
     */
     */
     */
     * Convenience method to assert same warnings for settings deprecations and general deprecation warnings
            Map<String, TokenizerFactory> tokenizer,
    }
        return MockNioTransportPlugin.MOCK_NIO_TRANSPORT_NAME;
import org.opensearch.threadpool.ThreadPool;
        ToXContent toXContent,
        // assert that no such messages were written out as these would indicate a problem with our logging configuration
            );
    }
        return RandomizedTest.randomRealisticUnicodeOfLength(codeUnits);
            threadContext = null;
     * @param maxWaitTime the maximum amount of time to wait
    public static String randomAlphaOfLengthBetween(int minCodeUnits, int maxCodeUnits) {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
 * specific language governing permissions and limitations
            try (XContentBuilder builder = shuffleXContent(parser, rarely(), exceptFieldNames)) {
                "Attempting to run tests in an unusable locale in a FIPS JVM. Certificate expiration validation will fail, "
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /** Compares two stack traces, ignoring module (which is not yet serialized) */
                        status -> status.getMessage()
                targetMap.put(key, shuffleMap(valueMap, exceptFields));
    protected static int getBasePort(int start) {
    }
        }
    public static void clearAdditionalRoles() {
     * was used by the test and the test didn't assert on it using {@link #assertWarnings(String...)}.
import org.opensearch.common.util.concurrent.ThreadContext;
        long sum = 0;
        );
    public static String randomRealisticUnicodeOfLength(int codeUnits) {
        @Override
        } catch (Exception e) {
     */
import org.junit.runner.Description;
                List<String> filteredWarnings = filterJodaDeprecationWarnings(actualWarnings);
            }
     */
import java.util.function.BooleanSupplier;
                        )
import org.junit.runners.model.Statement;
     */
            String flagKey = annotation.value();
        }
            throw new RuntimeException("resource not found: " + relativePath, e);
import org.opensearch.transport.client.Requests;
        }
    }
/*
            Thread.sleep(timeInMillis);
     */
     * Allow the given warnings, but don't require their presence.
    protected boolean enableJodaDeprecationWarningsCheck() {
     * Returns a double value in the interval [start, end) if lowerInclusive is
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
                assertThat("unexpected warning headers", filteredWarnings, empty());
    ) throws IOException {
            throw new IllegalStateException("unable to check warning headers if the test is not set to do so");
    public static <T> List<T> randomList(int maxListSize, Supplier<T> valueConstructor) {
            MockPageCacheRecycler.ensureAllPagesAreReleased();
         */
@ThreadLeakLingering(linger = 5000) // 5 sec lingering
    protected static void checkStaticState(boolean afterClass) throws Exception {
        throws IOException {
    }
                        return sw.toString();
    }
     */
     * Creates an TestAnalysis with all the default analyzers configured.
            analysisRegistry.buildCharFilterFactories(indexSettings)
    public AnnotatedFeatureFlagRule flagLockRule = new AnnotatedFeatureFlagRule();
        @Override
        return RandomizedTest.randomRealisticUnicodeOfCodepointLength(codePoints);
import org.opensearch.fips.FipsMode;
        return Settings.builder()
    /**
    public final void resetCheckIndexStatus() throws Exception {
            final long workerId = Long.valueOf(workerIdStr);
    }
                while (result <= 0.0) {
    }
    /**
    /**
     * return URL encoded paths if the parent path contains spaces or other
     * reading it in again using a provided {@link Writeable.Reader}.
     * @param maxArraySize The maximum number of elements in the random array
    public static ZoneId randomZone() {
    /**
    }
        return ThreadPool.terminate(threadPool, 10, TimeUnit.SECONDS);
        T original,
        return TimeZone.getTimeZone(randomJodaAndJavaSupportedTimezone(JAVA_TIMEZONE_IDS));
        NamedWriteableRegistry namedWriteableRegistry,
    /**
     */
            .prepareGetSettings(remoteStoreIndex)
    }
     * potentially need to use a {@link NamedWriteableRegistry}, so this needs to be provided too (although it can be
            }
     */
    public String[] tmpPaths() {
                if (Level.ERROR.equals(event.getLevel()) && message.contains("LEAK:")) {
    /**
    public static BigInteger randomBigInteger() {
            emptyMap(),
     */
     * lots of repeats. Make sure that the items properly implement equals and hashcode.
        return randomList(0, maxListSize, valueConstructor);
        return new TestAnalysis(
        try {
            throw e;
     */
    public static void resetPortCounter() {
            this.tokenizer = tokenizer;
import org.opensearch.core.common.transport.TransportAddress;
                LinkedHashMap<String, Object> valueMap = (LinkedHashMap<String, Object>) value;
        PathUtilsForTesting.setup();
            randomValue = randomSupplier.get();
                }
    protected final XContentParser createParser(XContent xContent, BytesReference data) throws IOException {
    /** Pick a random object from the given collection. */
import org.apache.logging.log4j.status.StatusConsoleListener;
        }
            Object value = map.get(key);
    }
        } catch (AssertionError e) {
    public static <T> T[] randomArray(int maxArraySize, IntFunction<T[]> arrayConstructor, Supplier<T> valueConstructor) {
 */
    }
    @SuppressWarnings("unchecked")
    private static final GeohashGenerator geohashGenerator = new GeohashGenerator();
            Locale.setDefault(Locale.ENGLISH);
    public static <T extends NamedWriteable> T copyNamedWriteable(
    /**
    private static String randomJodaAndJavaSupportedTimezone(List<String> zoneIds) {
    "TestBloomFilteredLucenePostings",
        }
    private static void setTestSysProps() {
    public static <T> T randomValueOtherThanMany(Predicate<T> input, Supplier<T> randomSupplier) {
     */
    public static <T> T[] randomArray(int minArraySize, int maxArraySize, IntFunction<T[]> arrayConstructor, Supplier<T> valueConstructor) {
    /**
                array.offset(),
     * The {@link PersistedStateRegistry} to use for this test. Subclasses should override and use liberally.
         * observe the passage of time.
            if (actualWarnings != null && enableJodaDeprecationWarningsCheck() == false) {
        MediaType mediaType,
import java.nio.file.Path;
import org.opensearch.search.MockSearchService;
            public void log(StatusData data) {
    ) throws IOException {
     *
            .get()
        ClusterState state = client.admin().cluster().prepareState().execute().actionGet().getState();
        String... exceptFieldNames
                            sd.getThrowable().printStackTrace(pw);
 * under the License.
    protected IndexAnalyzers createDefaultIndexAnalyzers() {
                    result = randomDouble();
        this.headerWarningAppender.start();
                .map(s -> HeaderWarning.extractWarningValueFromWarningHeader(s, true))
        Loggers.addAppender(leakLogger, leakAppender);
        return randomValueOtherThanMany(id -> JODA_TIMEZONE_IDS.contains(id) == false, () -> randomFrom(zoneIds));
import org.opensearch.common.logging.DeprecatedMessage;
    public static BlobPath getShardLevelBlobPath(
        return builder;
import org.opensearch.common.SuppressForbidden;
        // Check that there are no unaccounted warning headers. These should be checked with {@link #assertWarnings(String...)} in the
        return randomArray(0, maxArraySize, arrayConstructor, valueConstructor);
    // -----------------------------------------------------------------
    public static void assertArrayEquals(StackTraceElement expected[], StackTraceElement actual[]) {
    }
    @AfterClass
        }
    /**
import static org.opensearch.core.common.util.CollectionUtils.arrayAsArrayList;
    "Lucene99" })
    }
        Settings build = buildEnvSettings(settings);
                List<StatusData> filteredStatusData = statusData.stream()
import org.junit.BeforeClass;
import org.opensearch.script.MockScriptEngine;
                    } catch (IOException ioe) {
                    filteredWarnings = filteredWarnings.stream()
        }
    }
    private static final List<StatusData> statusData = new ArrayList<>();
     * @return a <code>int</code> between <code>0</code> and <code>Integer.MAX_VALUE</code> (inclusive) chosen uniformly at random.
    public static long randomLong() {
        if (data instanceof BytesArray) {
            if (warnings != null) {
        Set<T> things = new HashSet<>();
        return copyInstance(original, namedWriteableRegistry, (out, value) -> value.writeTo(out), reader, version);
        return FipsMode.CHECK.isFipsEnabled();
    @BeforeClass
                result = Double.longBitsToDouble(randomLong());
        return randomFrom(random(), collection);
        return RandomizedTest.randomUnicodeOfLengthBetween(minCodeUnits, maxCodeUnits);
        if (isUnusableLocale()) {
import java.util.function.Function;
        List<String> javaTZIds = Arrays.asList(TimeZone.getAvailableIDs());
        return xContent.createParser(xContentRegistry(), LoggingDeprecationHandler.INSTANCE, data);
        return RandomPicks.randomFrom(random, collection);
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.REMOTE_SNAPSHOT.getSettingsKey());
            analysisRegistry.buildTokenFilterFactories(indexSettings),
     * Create a new {@link XContentParser}.
        Map<String, String> remoteCustomData = state.metadata()
                        k -> "["
    }
            things.add(supplier.get());
    public void tearDown() throws Exception {
        RemoteStoreEnums.DataType dataType,
     * specified maximum wait time has elapsed. If at all possible, use
                boolean allAssumption = true;
                    filteredStatusData.stream().map(statusToString::apply).collect(Collectors.joining("\r\n")),
     */
        }
    }
     * {@link XContentType}. Wraps the output into a new anonymous object according to the value returned
import org.opensearch.index.analysis.IndexAnalyzers;
import org.opensearch.common.util.MockBigArrays;
            .fixedPrefix(fixedPrefix)
            return xContentBuilder.value(shuffledList);
        return randomTimeValue(1, 1000);
import org.opensearch.test.junit.listeners.ReproduceInfoPrinter;
        assertWarnings(true, expectedWarnings);
    /** called after a test is finished, but only if successful */
                in.setVersion(version);
            : RemoteStoreEnums.PathType.valueOf(remoteCustomData.get(RemoteStoreEnums.PathType.NAME));
        return result;
        super.tearDown();
        T original,
     */
        // we override LTC behavior here: wrap even resources with mockfilesystems,
            Set<String> expectedWarnings = new HashSet<>(Arrays.asList(allowedWarnings));
        Class<T> categoryClass,
import java.util.Collections;
     */
    }
    /**
    }
     *
    }
            }
            }
        return suiteFailureMarker;
        for (int i = 0; i < array.length; i++) {
                    + expectedWarnings
        }
                    .map(
import static org.opensearch.index.store.remote.filecache.FileCacheSettings.DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING;
            .stream()
     * Same as {@link #copyNamedWriteable(NamedWriteable, NamedWriteableRegistry, Class)} but also allows to provide
            Thread.sleep(timeInMillis);
            .put(settings)
        ToXContent.Params params,
     * Returns a "scaled" random number between min and max (inclusive).
     * Create a new {@link XContentParser}.
    }
        List<T> tempList = new ArrayList<>(collection);
     */
     */
    public static String randomTimeValue(int lower, int upper, String... suffixes) {
                + "\nActual: "
                .map(HeaderWarning::escapeAndEncode)
    public static TransportAddress buildNewFakeTransportAddress() {
    public static void setContentType() throws Exception {
    }
        RemoteStoreEnums.DataCategory dataCategory,
    protected NamedWriteableRegistry writableRegistry() {
            // formula below does not work with very large doubles
    }
            public void append(LogEvent event) {
    public static int randomInt(int max) {
        // "clear" the deprecated message set for the next tests to run independently.
        return random().nextLong();
                    + warningsNotExpected.size()
import org.opensearch.index.analysis.AnalyzerScope;
            Collections.singletonMap("default", new NamedAnalyzer("default", AnalyzerScope.INDEX, new StandardAnalyzer())),
    "Memory",
     * because they cannot be converted back to DateTimeZone which we currently
            }
 *     http://www.apache.org/licenses/LICENSE-2.0
     * A random integer from <code>min</code> to <code>max</code> (inclusive).
                + actualWarnings,
     * @param end            upper bound
import reactor.core.scheduler.Schedulers;
                random().nextBytes(ipv6);
        try (BytesStreamOutput output = new BytesStreamOutput()) {
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
    }
                }
                    }
                 * Filter out known Log4j 2.25+ initialization message about default root logger
import org.opensearch.core.xcontent.ToXContent;
                return BytesReference.bytes(builder);
            if (breakSupplier.getAsBoolean()) {
                assertThat(nettyLoggedLeaks, empty());
    public NodeEnvironment newNodeEnvironment() throws IOException {
     */
    // -----------------------------------------------------------------
            }
            .getSetting(remoteStoreIndex, IndexMetadata.SETTING_INDEX_UUID);
        return ZoneId.of(randomJodaAndJavaSupportedTimezone(JAVA_ZONE_IDS));
            return xContent.createParser(
            .dataType(dataType)
                targetMap.put(key, value);
    /**
    /**
    public static final class TestAnalysis {
        return createParser(builder.contentType().xContent(), BytesReference.bytes(builder));
    }
                e.addSuppressed(failure);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            resetDeprecationLogger();
import org.opensearch.core.xcontent.XContentParser;
    /**
                targetList.add(shuffleList((List) value, exceptFields));
        for (String msg : expectedWarnings) {
        // WEEKYEAR should be used instead of WEEK_YEAR
        assertNotNull("no warnings, expected: " + Arrays.asList(expectedWarnings), actualWarnings);
 * SPDX-License-Identifier: Apache-2.0
import java.lang.annotation.Target;
    }
@LuceneTestCase.SuppressReproduceLine
    }
    }
 * software distributed under the License is distributed on an
     * @param warnings other expected general deprecation warnings
import java.lang.annotation.Retention;
    }
        // lifespan of the daemon this means that they can get larger than the allowed port range.
            result = randomDouble();
                        pw.print(sd.getMessage().getFormattedMessage());
                            k -> k.contains(
        public GeohashGenerator() {
                return things;
import java.util.Collection;
        PathUtilsForTesting.teardown();
     */
        }
    public void removeHeaderWarningAppender() {
    /**
    public NodeEnvironment newNodeEnvironment(Settings settings) throws IOException {
    }
        List<String> jodaTZIds = DateTimeZone.getAvailableIDs()
    @AfterClass
        assertThat(StatusLogger.getLogger().getLevel(), equalTo(Level.WARN));
    }
    public static double randomDouble() {
                return;
         * @param base test case to execute.
import org.opensearch.core.xcontent.MediaTypeRegistry;
        return new TransportAddress(TransportAddress.META_ADDRESS, portGenerator.incrementAndGet());
@SuppressCodecs({
import java.util.concurrent.ExecutorService;
            throw new IllegalStateException("unable to check warning headers if the test is not set to do so");
            .put(IndexMetadata.SETTING_VERSION_CREATED, version)
    /**
import java.util.Objects;
            this.charFilter = charFilter;
                List<String> filteredWarnings = new ArrayList<>(warnings);
                for (Throwable error : errors) {
        assertSettingDeprecationsAndWarnings(Arrays.stream(settings).map(Setting::getKey).toArray(String[]::new), warnings);
import org.apache.logging.log4j.core.LogEvent;
    }
            this.headerWarningAppender = null;
        return things;
            (LinkedHashMap<String, Object>) parser.mapOrdered(),
                }
    "BlockTreeOrds",
     *
    /**
    @After
                };
    public RuleChain failureAndSuccessEvents = RuleChain.outerRule(new TestRuleAdapter() {
    public static final String DEFAULT_TEST_WORKER_ID = "--not-gradle--";
        while (sum <= maxTimeInMillis) {
                return reader.read(in);
    /** Pick a random object from the given list. */
     */
    }
 *
        T original,
        NamedWriteableRegistry namedWriteableRegistry,
        long maxTimeInMillis = TimeUnit.MILLISECONDS.convert(maxWaitTime, unit);
            // increases this value, so the mod can eventually become zero, thus we shift on both sides by 1
        // filter out joda timezones that are deprecated for the java time migration
    }
        return randomSubsetOf(size, list);
            // we adjust the gradle worker id with mod so as to not go over the ephemoral port ranges, but gradle continually
    }
import org.apache.logging.log4j.status.StatusData;
            assertThat(
     */
        }
    /**
import org.opensearch.index.remote.RemoteStorePathStrategy;
        double result = 0.0;
                return InetAddress.getByAddress(ipv4);
        }
        NamedWriteableRegistry namedWriteableRegistry,
     */
    public static int between(int min, int max) {
         * Wrap base test case with an
            .build();
    }
        for (int t = 0; t < maxTries; t++) {
                );
        List<String> javaZoneIds = new ArrayList<>(ZoneId.getAvailableZoneIds());
        } finally {
@Listeners({ ReproduceInfoPrinter.class, LoggingListener.class })
            assert workerId >= 1 : "Non positive gradle worker id: " + workerIdStr;
    /**
        return RandomNumbers.randomLongBetween(random(), min, max);
                ? RemoteStoreEnums.PathHashAlgorithm.valueOf(remoteCustomData.get(RemoteStoreEnums.PathHashAlgorithm.NAME))
            if (actualWarnings == null) {
    /** Return consistent index settings for the provided index version. */
        }
        throws IOException {
        // We check threadContext != null rather than enableWarningsCheck()
                            ) == false
    "LuceneVarGapDocFreqInterval",
        } catch (UnknownHostException e) {
    private String getTestParamsForLogging() {
    protected final XContentParser createParser(XContent xContent, String data) throws IOException {
                    }
        assertEquals(
     * Create a new {@link XContentParser}.
     * Usage: LockFeatureFlag("example.featureflag.setting.key.enabled")
        final List<String> actualWarnings = threadContext.getResponseHeaders().get("Warning");
import org.apache.lucene.tests.util.LuceneTestCase;
import org.junit.internal.AssumptionViolatedException;
     * its contents.
        return start + (startAt * 100);
     *
                e.addSuppressed(failure);
            if (lowerInclusive == false) {
    public static String getTestTransportType() {
     * //TODO remove once joda is not supported
                equalTo(0)
            bytes[i] = randomByte();
    /**
     * Returns the bytes that represent the XContent output of the provided {@link ToXContent} object, using the provided
        MockBigArrays.ensureAllArraysAreReleased();
    /**
     * @return the last value returned by <code>breakSupplier</code>
        throws IOException {
    /**
     */
        }
    /**
    // shuffle fields of objects in the list, but not the list itself
        TransportService.ensureClassloaded(); // ensure server streamables are registered
    }
        DiscoveryNode.setAdditionalRoles(Collections.emptySet());
        Class<T> categoryClass
    /** Pick a random object from the given array. The array must not be empty. */
                + Arrays.asList(expectedWarnings)
import org.junit.Before;
        public final Map<String, CharFilterFactory> charFilter;
                            pw.println("Throwable:");
    }
            Map<String, CharFilterFactory> charFilter
import org.opensearch.common.unit.TimeValue;
import java.util.stream.Stream;
    public static TimeZone randomTimeZone() {
                    + " unexpected warnings\nExpected: "
    public static String randomUnicodeOfLength(int codeUnits) {
     * Returns a {@link Path} pointing to the class path relative resource given
    ) throws IOException {
        int start = name.indexOf('{');
            }
    public static <T> void maybeSet(Consumer<T> consumer, T value) {
    public static void assertBusy(CheckedRunnable<Exception> codeBlock, long maxWaitTime, TimeUnit unit) throws Exception {
    public static short randomShort() {
     * to build IndexAnalyzers. This is only for testing since in production we only need the
    protected final XContentParser createParser(XContent xContent, byte[] data) throws IOException {
        return randomValueOtherThanMany(v -> Objects.equals(input, v), randomSupplier);
     * Returns a random BigInteger uniformly distributed over the range 0 to (2^64 - 1) inclusive
        assert startAt >= 0 : "Unexpected test worker Id, resulting port range would be negative";
        while (value.compareTo(Numbers.MAX_UNSIGNED_LONG_VALUE) == 1) {
        return generateRandomStringArray(maxArraySize, stringSize, allowNull, true);
    }
        ClusterModule.getNamedXWriteables()
            timeInMillis *= 2;
        return newNodeEnvironment(Settings.EMPTY);
    /**
        for (int i = 0; i < iterations; i++) {
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
    }
import java.util.Arrays;
    public static long randomLongBetween(long min, long max) {
        if (start < 0) return "";
        assertBusy(() -> MockSearchService.assertNoInFlightContext());
import org.opensearch.monitor.jvm.JvmInfo;
import java.util.concurrent.atomic.AtomicInteger;
@TimeoutSuite(millis = 20 * TimeUnits.MINUTE)
        }
     * a {@link Version} argument which will be used to write and read back the object.
                    empty()
    }
     *
            xContentBuilder = xContentBuilder.prettyPrint();
    }
            final BytesArray array = (BytesArray) data;
                if (enableJodaDeprecationWarningsCheck() == false) {
        }
    "FSTOrd50",
    @Deprecated
                        .filter(
        EnumSet<FormatNames> formatNames = EnumSet.complementOf(EnumSet.of(FormatNames.WEEK_YEAR));
    public static <T extends Writeable> T copyWriteable(
    public static LinkedHashMap<String, Object> shuffleMap(LinkedHashMap<String, Object> map, Set<String> exceptFields) {
            : null;
    }
        String[] array = new String[arraySize];
        Token token = parser.currentToken() == null ? parser.nextToken() : parser.currentToken();
import static java.util.Collections.emptyMap;
    // TODO: can we do this cleaner???
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakLingering;
     */
import org.opensearch.common.io.PathUtilsForTesting;
        return randomInt == Integer.MIN_VALUE ? 0 : Math.abs(randomInt);
 * Licensed to Elasticsearch under one or more contributor
        if (start == -Double.MAX_VALUE || end == Double.MAX_VALUE) {
        } catch (AssertionError e) {
        String shardId,
    /**
        return list;
    }
    protected final void assertWarnings(boolean stripXContentPosition, String... expectedWarnings) {
import org.opensearch.core.xcontent.XContentBuilder;
    }
     */
        long iterations = Math.max(Math.round(Math.log10(maxTimeInMillis) / Math.log10(2)), 1);
    private static final String[] TIME_SUFFIXES = new String[] { "d", "h", "ms", "s", "m", "micros", "nanos" };
@ThreadLeakFilters(filters = { BouncyCastleThreadFilter.class, ArrowAllocationLoggerThreadFilter.class })
                return base;
    static {
    public Settings buildEnvSettings(Settings settings) {
        final int size = randomIntBetween(minListSize, maxListSize);
    }
        return randomIntBetween(lower, upper) + randomFrom(suffixes);
            output.setVersion(version);
    public static TestAnalysis createTestAnalysis(Index index, Settings nodeSettings, Settings settings, AnalysisPlugin... analysisPlugins)
import com.carrotsearch.randomizedtesting.annotations.TimeoutSuite;
    public static final String TEST_WORKER_VM_ID;
    }
        if (randomBoolean()) {
    protected final void assertWarnings(String... expectedWarnings) {
    public static long randomNonNegativeLong() {
        NamedWriteableRegistry namedWriteableRegistry,
            .build();
        if (size > collection.size()) {
    public static void restoreContentType() {
            .basePath(basePath)
     * @see #randomByte()
            value = value.subtract(Numbers.MAX_UNSIGNED_LONG_VALUE);
    }
     * Create a copy of an original {@link Writeable} object by running it through a {@link BytesStreamOutput} and
        }
        List<AssertionError> failures = new ArrayList<>();
            List<Object> shuffledList = shuffleList(parser.listOrderedMap(), new HashSet<>(Arrays.asList(exceptFieldNames)));
            }
     * Create a "mock" script for use either with {@link MockScriptEngine} or anywhere where you need a script but don't really care about
    }
import java.lang.annotation.ElementType;
            }
    /**
        return true;
        }
    public final void ensureCheckIndexPassed() {
    // randomize content type for request builders
    public static <T> T randomFrom(Collection<T> collection) {
import org.opensearch.common.time.FormatNames;
                            + "] setting was deprecated in OpenSearch and will be removed in a future release! "
        return builder;
        if (afterClass) {
            ? remoteCustomData.containsKey(RemoteStoreEnums.PathHashAlgorithm.NAME)
            } else if (value instanceof List && exceptFields.contains(key) == false) {
import static org.hamcrest.Matchers.empty;
import org.apache.lucene.tests.util.TimeUnits;
            version
        Requests.CONTENT_TYPE = randomFrom(XContentType.values());
                /* ensure that there are no status logger messages which would indicate a problem with our Log4j usage; we map the
            );
        }
            @Override
            try {
     * The {@link NamedWriteableRegistry} to use for this test. Subclasses should override and use liberally.
        boolean terminated = true;
import java.lang.annotation.RetentionPolicy;
    protected PersistedStateRegistry persistedStateRegistry() {
    }
                : null
        // Ephemeral ports on Linux start at 32768 so we modulo to make sure that we don't exceed that.
        final int size = randomIntBetween(minArraySize, maxArraySize);
            original,
    /**
        assertEquals(expected.getLineNumber(), actual.getLineNumber());
        return waitUntil(breakSupplier, 10, TimeUnit.SECONDS);
    public static <T extends NamedWriteable> T copyNamedWriteable(
        assertBusy(codeBlock, 10, TimeUnit.SECONDS);
import org.junit.AfterClass;
        }
import java.time.ZoneId;
 */
    /**
    public static boolean randomBoolean() {
        }
            array[i] = valueConstructor.get();
    /** Pick a random object from the given array. The array must not be empty. */
     * recursive shuffling behavior can be made by passing in the names of fields which
            ? RemoteStoreEnums.PathType.FIXED
                + " warnings but found "
    }
    }
        }
    protected static final List<String> JAVA_TIMEZONE_IDS;
            OpenSearchTestCase.this.afterIfSuccessful();
    /** Compares two stack trace elements, ignoring module (which is not yet serialized) */
     * {@link XContentType}. Wraps the output into a new anonymous object according to the value returned
        );
     */
import org.opensearch.common.CheckedRunnable;
    protected static long spinForAtLeastNMilliseconds(final long ms) {
import java.net.InetAddress;
     */
     * Runs the code block for the provided max wait time and sleeping for fixed sleep time, waiting for no assertions to trip.
            for (AssertionError failure : failures) {
 * You may obtain a copy of the License at
     * Returns size random values
import java.util.concurrent.TimeUnit;
        Writeable.Writer<T> writer,
            IndexAnalyzers indexAnalyzers,
                namedXContentRegistry,
        logger.info("{}after test", getTestParamsForLogging());
    // -----------------------------------------------------------------
        } else {
        List<T> list = arrayAsArrayList(values);
    /**
         * Force at least ms milliseconds to elapse, but ensure the clock has enough resolution to
            }
    private static final AtomicInteger portGenerator = new AtomicInteger();
        while (sum + timeInMillis < maxTimeInMillis) {
    /**
     * Enables and make a flag immutable for the duration of the test case.
            }
    /**
    public static String randomRealisticUnicodeOfLengthBetween(int minCodeUnits, int maxCodeUnits) {
    }
        return tempList.subList(0, size);
    // Test facilities and facades for subclasses.
    protected static InetAddress randomIp(boolean v4) {
            if (errors != null && errors.isEmpty() == false) {
    }
import org.opensearch.cluster.ClusterModule;
    }
     * Generate a random valid date formatter pattern.
        leakAppender.start();
        return array;
     */
            analysisRegistry.buildTokenizerFactories(indexSettings),
    public static <T> T randomFrom(T... array) {
import org.apache.logging.log4j.core.LoggerContext;
        return randomFrom(random(), array);
     * Creates an TestAnalysis with all the default analyzers configured.
 * GitHub history for details.
     * The port number starts at 0 and is reset after each test suite run.
        }
        Writeable.Reader<T> reader
        XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(parser.contentType());
    // separate method so that this can be checked again after suite scoped cluster is shut down
import java.util.function.Predicate;
        return copyInstance(
        try (XContentParser parser = createParser(mediaType.xContent(), bytes)) {
                "Found "
        synchronized (nettyLoggedLeaks) {
    @AfterClass
@LuceneTestCase.SuppressSysoutChecks(bugUrl = "we log a lot on purpose")
        Client client,
public abstract class OpenSearchTestCase extends LuceneTestCase {
        if (checkIndexFailures.isEmpty() == false) {
        final Set<String> actualWarningValues = actualWarnings.stream()
        return RandomizedTest.randomRealisticUnicodeOfLengthBetween(minCodeUnits, maxCodeUnits);
        setTestSysProps();
    }
    }
    public static boolean waitUntil(BooleanSupplier breakSupplier, long maxWaitTime, TimeUnit unit) throws InterruptedException {
        return new Script(ScriptType.INLINE, MockScriptEngine.NAME, id, emptyMap());
import org.apache.logging.log4j.Level;
     * Periodically execute the supplied function until it returns true, or a timeout
import com.carrotsearch.randomizedtesting.generators.RandomNumbers;
    "LuceneFixedGap",
        return randomSubsetOf(randomInt(collection.size()), collection);
 * compatible open source license.
        /*
        String name = getTestName();
        checkIndexFailures.clear();
            .shardId(shardId)
    }
    public final void ensureAllSearchContextsReleased() throws Exception {
    /**
        // use a non-default base port otherwise some cluster in this JVM might reuse a port
     * empty if the object that is streamed doesn't contain any {@link NamedWriteable} objects itself.
        }
 * ownership. Elasticsearch licenses this file to you under
        AnalysisRegistry analysisRegistry = analysisModule.getAnalysisRegistry();
            HeaderWarning.removeThreadContext(threadContext);
        BigInteger value = randomBigInteger().abs();
        Version version
import java.io.PrintWriter;
import com.carrotsearch.randomizedtesting.generators.CodepointSetGenerator;
     * An alias for {@link #randomIntBetween(int, int)}.
                failures.add(e);
    /**
import org.opensearch.cluster.metadata.IndexMetadata;
    }
            emptyMap()
import org.opensearch.indices.analysis.AnalysisModule;
            super(ASCII_SET);
     * We need to exclude time zones not supported by joda (like SystemV* timezones)
        // This is safe as long as we have fewer than 224 Gradle workers running in parallel
        );
            absPaths[i] = createTempDir().toAbsolutePath().toString();
    protected static <T> T copyInstance(
        return random().nextInt();
        // a different default port range per JVM unless the incoming settings override it
                        nettyLoggedLeaks.add(message);
                if (false == allAssumption) {
    // setup mock filesystems for this test run. we change PathUtils
    private static final long AWAIT_BUSY_THRESHOLD = 1000L;
import org.apache.logging.log4j.LogManager;
            .put(DATA_TO_FILE_CACHE_SIZE_RATIO_SETTING.getKey(), 5)
        LinkedHashMap<String, Object> targetMap = new LinkedHashMap<>();
            if (value instanceof Map) {
            }
 * KIND, either express or implied.  See the License for the
            if (annotation == null) {
                    .filter(
        return breakSupplier.getAsBoolean();
    }
            }
                final Function<StatusData, String> statusToString = (sd) -> {
        // Log4j will write out status messages indicating problems with the Log4j usage to the status logger; we hook into this logger and
    }
            .getCustomData(IndexMetadata.REMOTE_STORE_CUSTOM_KEY);
            resetDeprecationLogger();
            if (service != null) {
            Loggers.removeAppender(LogManager.getLogger("org.opensearch.deprecation"), this.headerWarningAppender);
    public static <T> T randomFrom(Random random, T... array) {
        } finally {
        return xContent.createParser(namedXContentRegistry, LoggingDeprecationHandler.INSTANCE, data.streamInput());
import org.opensearch.index.remote.RemoteStoreEnums;
    // mockdirectorywrappers currently set this boolean if checkindex fails
