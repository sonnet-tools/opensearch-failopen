        @Override
        // visible for testing
import org.opensearch.core.xcontent.DeprecationHandler;
    /**
        return parseTimeValue(get(setting), defaultValue, setting);
    public List<String> getAsList(String key, List<String> defaultValue) throws SettingsException {
                    map.put(prefix + key, innerMap);
            try (
                    .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, source)
     * Returns the setting value (as size) associated with the setting key. If it does not exists,
            ArrayList<Object> newValue = new ArrayList<>(maxIndex + 1);
    /** Returns the number of settings in this settings object. */
            if (key instanceof String) {
                        }
         * @param level The setting value
            Map<String, Object> replacements = new HashMap<>();
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
            settingPrefix = settingPrefix + ".";
         */
        }
                @Override
                        return k.substring(0, i);
            }
        return new Builder();
                        + ", new settings: "
                }
                    if (index >= 0) {
                final String theKey = prefix == null ? (String) key : prefix + key;
        }
                        } else {
         * Sets all the provided settings.
                // Check that the keys are still null now that we have acquired the lock
    static class DeprecationLoggerHolder {
    /**
         *
                throw e;
                                currentElement = null;
            @SuppressWarnings("unchecked")
        }
import java.util.Map;
         */
        private final String prefix;
            if (source.settings.containsKey(sourceKey) == false) {
                }
         * Builds a {@link Settings} (underlying uses {@link Settings}) based on everything
                    List<String> values = new ArrayList<>();
                parser.getTokenLocation().lineNumber,
         * @return The builder
        try {
         * <p>
            return size;
    /**
    /**
        public Set<String> getSettingNames() {
                    replacements.put(prefix + key, entry.getValue());
         */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    "malformed, expected end of settings but encountered additional content starting at line number: [{}], "
                                return false;
    public static Settings readOptionalSettingsFromStream(StreamInput in) throws IOException {
import java.util.Set;
    SecureSettings getSecureSettings() {
        }
         */
     */
                        isArray = false;
            PropertyPlaceholder propertyPlaceholder = new PropertyPlaceholder("${", "}", false);
         */
                }
     */
            // ensure we reached the end of the stream
        return sb.toString();
            }
 * Unless required by applicable law or agreed to in writing,
         * Sets the setting with the provided setting key and the float value.
                    if (parser.nextToken() == null) {
         */
         * @param values  The values
        public Builder put(String setting, long value, ByteSizeUnit sizeUnit) {
         * @return The builder
        /**
     * Writes an optional {@link Settings} to the stream. A {@code null} value is permitted.
            map.put(key, value);
        public SecureSettings getSecureSettings() {
         * Sets a setting with the provided setting key and value.
                    } else {
            return put(key, (String) null);
            return secureSettings.get();
            if (key instanceof String) {
        }
                entry.setValue(convertMapsToArrays(valMap));
         * Loads settings from a url that represents them using {@link #fromXContent(XContentParser)}
     */
                        throw new IllegalStateException(
            for (Map.Entry<String, Object> entry : settings.settings.entrySet()) {
     * The values associated with a setting key as an immutable list.
                    final String value = getenv.apply(placeholderName);
import org.opensearch.core.xcontent.NamedXContentRegistry;
            } else {
     * Counterpart to {@link #readOptionalSettingsFromStream(StreamInput)}.
     * @param defaultValue   The default value to use if no value is specified
        }
         * @param byteSizeValue The setting value
import java.util.Arrays;
            } catch (Exception e) {
        return getGroupsInternal(settingPrefix, ignoreNonGrouped);
                }
                entry.setValue(convertMapsToArrays(valMap));
                            map.remove(listKey);
import org.opensearch.common.logging.DeprecationLogger;
            } else {
        }
         *
    private final SecureSettings secureSettings;
                fromXContent(parser, keyBuilder, builder, allowNullValues);
     */
         * @param setting The setting key
            out.writeString(entry.getKey());
        new HashSet<>(Arrays.asList("settings_filter", "flat_settings"))
            Set<Entry<String, Object>> delegateSet = delegate.entrySet();
        }
     * The values associated with a setting key as an immutable list.
                }
        }
        public boolean containsKey(Object key) {
    }
                        .filter(keyPredicate)
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        Map<String, Object> map = new HashMap<>(2);
         *
                        + "column number: [{}]",
    public boolean equals(Object o) {
        private final Map<String, Object> delegate;
         * @return The builder
                }
    public static void writeOptionalSettingsToStream(Settings settings, StreamOutput out) throws IOException {
        }
 *
            }
                                    return false;
     * Returns the setting value associated with the setting key. If it does not exists,
            if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
        fromXContent(parser, currentKeyBuilder, innerBuilder, allowNullValues);
            return put(key, timeValue.getStringRep());
     * @return The setting value, {@code null} if it does not exists.
                        return this; // empty file
    /** The first level of setting names. This is constructed lazily in {@link #names()}. */
        String sValue = get(setting);
        }
                        .collect(Collectors.toSet());
                if (key.startsWith(prefix) == false && key.endsWith("*") == false && key.startsWith(ARCHIVED_SETTINGS_PREFIX) == false) {
    }
                XContentParser parser = mediaType.xContent()
    public boolean hasValue(String key) {
                builder.put(key, value.toString());
                public String resolvePlaceholder(String placeholderName) {
import org.opensearch.common.Booleans;
            writeSettingsToStream(settings, out);
        if (sValue == null) {
        /**
 * license agreements. See the NOTICE file distributed with
            while (iterator.hasNext()) {
            }
            return defaultValue;
    }
            );
                    // a null value obviously can't be replaced
    /**
        throws IOException {
        } catch (NumberFormatException e) {
     * the numbered format.
            } else if (commaDelimited) {
                        }
        private FilteredMap(Map<String, Object> delegate, Predicate<String> filter, String prefix) {
        } catch (NumberFormatException e) {
                String key = keyBuilder.toString();
     */
                                public Object setValue(Object value) {
    }
                    }
                public Iterator<Entry<String, Object>> iterator() {
         * @param settings the settings to set
        @Override
        /**
    public TimeValue getAsTime(String setting, TimeValue defaultValue) {
         */
     * Returns a new settings object that contains all setting of the current one filtered by the given settings key predicate.
        public Builder put(final String key, final TimeValue timeValue) {
        }
     * leading to a runtime failure (see {@link LogConfigurator#checkErrorListener()} ). The premature construction would come from any
        /** Return the current secure settings, or {@code null} if none have been set. */
 * Modifications Copyright OpenSearch Contributors. See
         * another setting already set on this builder.
        }
    /**
        return o == null ? null : o.toString();
        return innerBuilder.build();
            if (this.secureSettings.get() != null) {
    public Boolean getAsBoolean(String setting, Boolean defaultValue) {
        public Builder loadFromSource(String source, MediaType mediaType) {
        try {
     * Reads an optional {@link Settings} from the stream. Returns {@code null} if no settings were written.
        }
                        result.add(string.trim());
                    String key = keyBuilder.toString();
        } catch (Exception e) {
                                + prefix
                XContentParser.Token token = xContentParser.nextToken();
            return defaultValue;
     */
            }
                            final Entry<String, Object> current = this.currentElement;
    }
        return builder;
            } catch (IOException e) {
            return this;
        public Builder put(String key, Level level) {
        public Builder put(Settings settings) {
                public boolean shouldRemoveMissingPlaceholder(String placeholderName) {
            return Float.parseFloat(sValue);
                                public String getKey() {
        }
         * Removes the provided setting from the internal map holding the current list of settings.
        }
            }
        return Booleans.parseBoolean(get(setting), defaultValue);
            return this;
        }
        if (isArray && (maxIndex + 1) == map.size()) {
        final Object valueFromPrefix = settings.get(key);
    public boolean isEmpty() {
            put(setting, String.valueOf(value));
     */
        } else {
                                }
     */
                firstLevelNames.set(Collections.unmodifiableSet(names));
                    final ListIterator<String> li = ((List<String>) entry.getValue()).listIterator();
        }
        return fromXContent(parser, true, false);
        private final SetOnce<SecureSettings> secureSettings = new SetOnce<>();
            return filterSet;
            Settings groupSettings = prefixSettings.getByPrefix(groupName + ".");
                return putNull(key);
     * Returns the setting value associated with the setting key.
                // otherwise, the replace process resolved into removing it
                    }
        return Collections.unmodifiableList(result);
            return newValue;
                                }
         *
            }
    public List<String> getAsList(String key, List<String> defaultValue, Boolean commaDelimited) throws SettingsException {
            }
                if (obj == null) {
            if (lastToken != null) {
            if (isArray) {
import org.opensearch.common.SetOnce;
            Map<String, Object> innerMap = (Map<String, Object>) map.get(prefix + setting);
     * Returns the setting value (as size) associated with the setting key. Provided values can either be
                    String key = keyBuilder.toString();
        int prefixLength = setting.indexOf('.');
        }
    /**
         */
    /**
         * @return The builder
    }
                        + "column number: [{}]",
    }
     * {@link XContentParser.Token#START_OBJECT}.
            return replacePropertyPlaceholders(System::getenv);
 * ownership. Elasticsearch licenses this file to you under
            if (valueFromPrefix instanceof List) {
        /**
        PrefixedSecureSettings(SecureSettings delegate, String prefix, Predicate<String> keyPredicate) {
     */
            return this;
     *
    public static Builder builder() {
         *
     * returns the default value provided.
         * If a setting doesn't start with the prefix, the builder appends the prefix to such setting.
                parser.getTokenLocation().columnNumber
    public static class Builder {
        Builder builder = new Builder();
                public boolean shouldIgnoreMissing(String placeholderName) {
     * @return The setting list values
        String retVal = get(setting);
            }
                        list.add(parser.text()); // just use the string representation here
import org.opensearch.core.xcontent.ToXContentFragment;
        /**
        return new Settings(
        public Builder normalizePrefix(String prefix) {
                                throw new NoSuchElementException("make sure to call hasNext first");
        public Set<Entry<String, Object>> entrySet() {
        }
                        String value = get(listKey);
     * We have to lazy initialize the deprecation logger as otherwise a static logger here would be constructed before logging is configured
        }
                return loadFromSource(builder.toString(), builder.contentType());
                "null-valued setting found for key [{}] found at line number [{}], column number [{}]",
        /**
            this.addPrefix = s -> prefix + s;
                }
            } finally {
        /**
    /**
                try {
                                // we didn't find anything
        }
        Settings settings = SettingsFilter.filterSettings(params, this);
                } else {
                Map.Entry<String, Object> entry = iterator.next();
     * construct it.
    public List<String> getAsList(String key) throws SettingsException {
         * @param value The setting value
                @Override
        }
        /**
    @Override
                Map<String, Object> valMap = (Map<String, Object>) entry.getValue();
                    parser.getTokenLocation().columnNumber
        }
         * @return The builder
                // if the values exists and has length, we should maintain it in the map
        }
    }
        }
                } else {
                                if (numIterated == size) { // early terminate
    public static Settings readSettingsFromStream(StreamInput in) throws IOException {
                                    }
        }
import org.opensearch.core.common.settings.SecureString;
import org.opensearch.common.xcontent.XContentType;
        }
        }
            // NOTE: loadFromStream will close the input stream
import java.util.Iterator;
                throw new IllegalArgumentException("source key not found in the source settings");
    /**
    public Set<String> names() {
        }
         * Sets all the provided settings including secure settings
            Object existingValue = map.get(prefix + key);
                builder.putNull(key);
            processLegacyLists(map);
     * Parsers the generated xcontent from {@link Settings#toXContent(XContentBuilder, Params)} into a new Settings object.
        }
    }
     * It will also automatically load a comma separated list under the settingPrefix and merge with
     * Returns the setting value (as float) associated with the setting key. If it does not exists,
        }
                        private int numIterated;
                if (secureSettings != null) {
    @PublicApi(since = "1.0.0")
        if (o == null || getClass() != o.getClass()) return false;
        // we use a sorted map for consistent serialization when using getAsMap()
        for (Map.Entry<String, Object> entry : settings.entrySet()) {
        }
                    // try to parse the value as a list first
        public boolean isLoaded() {
        out.writeVInt(entries.size());
        if (!Strings.hasLength(settingPrefix)) {
         * set on this builder.
        Builder replacePropertyPlaceholders(Function<String, String> getenv) {
                return Optional.empty();
            return Integer.parseInt(sValue);
     * returns the default value provided.
                    if (map.containsKey(prefix)) {
     */
            return map;
        public Object get(Object key) {
        this.secureSettings = secureSettings;
            processSetting(map, "", entry.getKey(), entry.getValue());
     * Returns the setting value (as long) associated with the setting key. If it does not exists,
        }
         * Sets a path setting with the provided setting key and path.
                                while (iter.hasNext()) {
                    } else if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {
                                }
import java.util.Objects;
                    return delegate.get(theKey);
            put(setting, String.valueOf(value));
                XContentParser parser = mediaType.xContent()
            }
        /**
        }
                    for (String string : strings) {
    public Set<String> keySet() {
        public Builder putProperties(final Map<String, String> esSettings, final Function<String, String> keyFunction) {
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
    }
                put(fromXContent(parser, acceptNullValues, true));
            return settingNames.get();
                        list.add(parser.text());
         *
    }
         * @return The builder
                    } else {
            return this;
            } else {
    public Double getAsDouble(String setting, Double defaultValue) {
         * @param setting The setting key
        }
            } else if (parser.currentToken() == XContentParser.Token.START_ARRAY) {
                }
 * this file be licensed under the Apache-2.0 license or a
         */
         *
import java.util.function.UnaryOperator;
                Map.Entry<String, Object> entry = entryItr.next();
                                + map.get(prefix)
            return put(settings, true);
                            "settings builder can't contain values for ["
    /**
                mediaType = MediaTypeRegistry.JSON;
                if (filter.test(theKey)) {
         * @param copySecureSettings if <code>true</code> all settings including secure settings are copied.
        }
                } else if (parser.currentToken() == XContentParser.Token.VALUE_BOOLEAN) {
import org.opensearch.core.common.io.stream.StreamInput;
        }
    /**
         * @param setting The setting key
    }
         *
     */
                throw new IllegalArgumentException("unable to detect content type from resource name [" + resourceName + "]");
        }
    /**
        return firstLevelNames.get();
         * @return the {@link Optional} result of the parsing attempt
        return keys.get();
        public Builder loadFromPath(Path path) throws IOException {
                    ;
            }
        }
    public String get(String setting, String defaultValue) {
            return defaultValue;
        private final Predicate<String> filter;
         */
        for (Map.Entry<String, Object> entry : entries) {
         * @param value   The size value
        }
                size = Math.toIntExact(delegate.keySet().stream().filter(filter).count());
            return this.map.keySet();
         * @param key  The setting key
            }
                    }
                        final String settingValueRaw = li.next();
                while (!parser.isClosed() && (lastToken = parser.nextToken()) == null)
         * Sets the setting with the provided setting key and the boolean value.
                List<String> list = new ArrayList<>();
        /**
     * Counterpart to {@link #writeOptionalSettingsToStream(Settings, StreamOutput)}.
    }
import java.util.HashMap;
                    }
                @Override
         */
     * Retrieve the secure settings in these settings.
        if (valueFromPrefix != null) {
         */
    public Settings getByPrefix(String prefix) {
            } catch (IOException e) {
 * KIND, either express or implied.  See the License for the
                builder.field(entry.getKey(), entry.getValue());
        }
    public Long getAsLong(String setting, Long defaultValue) {
                                }
                    iterator.remove();
    public static Settings fromXContent(XContentParser parser) throws IOException {
                                @Override
                result.add(get(key).trim());
         *
         * @param setting The setting key
                    list.add(xContentParser.text());
        /**
         */
            // TODO: do this without a serialization round-trip
        /**
            throw new SettingsException("Failed to parse float setting [" + setting + "] with value [" + sValue + "]", e);
        /**
            return this;
                throw new OpenSearchGenerationException("Failed to generate [" + map + "]", e);
        return new Settings(
         */
         * Sets an enum setting with the provided setting key and enum instance.
            synchronized (keys) {
        public Builder put(final String setting, final long value, final TimeUnit timeUnit) {
    }
        public Builder copy(String key, String sourceKey, Settings source) {
        }
        if (in.readBoolean()) {
         */
         *
                builder.map(map);
                IOUtils.close(is);
    }
        }
        public Builder loadFromMap(Map<String, ?> map) {
                        throw new IllegalStateException("only value lists are allowed in serialized settings");
        return map;
     * <p>
            if (firstLevelNames.get() == null) {
    }
                key,
            return this;
         * @return The builder
        int numberOfSettings = in.readVInt();
import org.apache.logging.log4j.Level;
                }
                    if (optList.isPresent()) {
    }
            map.put(setting, new ArrayList<>(values));
        if (parser.currentToken() == null) {
                builder.putList(key, list);
            }
                }
import java.io.IOException;
        } else {
                validateValue(key, list, parser, allowNullValues);
     * the numbered format.
        }
         */
            this.filter = filter;
                }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
                    int index = Integer.parseInt(entry.getKey());
                }
     * returns the default value provided.
                                    assert size != -1 : "size was never set: " + numIterated + " vs. " + size;
        return builder.build();
     */
         * @return The builder
        public Builder put(String setting, double value) {
    // TODO We could use an FST internally to make things even faster and more compact
                    };
         *
    public static void writeSettingsToStream(Settings settings, StreamOutput out) throws IOException {
            return Settings.toString(map.remove(key));
                || parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {
            return Double.parseDouble(sValue);
            if (innerMap != null) {
    public int size() {
     */
        return settings.get(key) != null;
                throw new SettingsException("Failed to load settings from [" + source + "]", e);
                        String listKey = prefix + '.' + (counter++);
     * It will also automatically load a comma separated list under the settingPrefix and merge with
        private static Optional<List<String>> tryParseableStringToList(String parsableString) {
            }
        if (currentValue == null && allowNullValues == false) {
                        + secureSettings.getSettingNames()
                    Set<String> names = delegate.getSettingNames()
                newValue.add(obj);
         * @return The builder
                throw new IllegalStateException("Secure settings must already be loaded");
                    }
    public String get(String setting) {
         * Loads settings from a map.
    }
            }
        String sValue = get(setting);
            // fromXContent doesn't use named xcontent or deprecation.
                        maxIndex = Math.max(maxIndex, index);
                        .stream()
    public String toString() {
        StringBuilder currentKeyBuilder = new StringBuilder();
        return this.settings.isEmpty() && (secureSettings == null || secureSettings.getSettingNames().isEmpty());
                @SuppressWarnings("unchecked")
import java.util.stream.Collectors;
                    settingNames.set(Collections.unmodifiableSet(names));
            String[] array = map.keySet().toArray(new String[0]);
import java.util.Optional;
                    if (secureSettings == null) {
                    String value = parser.text();
        int maxIndex = -1;
            return delegate.getSHA256Digest(addPrefix.apply(setting));
    public ByteSizeValue getAsBytesSize(String setting, ByteSizeValue defaultValue) throws SettingsException {
                            };
                throw new OpenSearchParseException(
    private Map<String, Object> getAsStructuredMap() {
                mediaType = XContentType.YAML;
        public Builder copy(String key, Settings source) {
                        @Override
    /**
import org.opensearch.Version;
        public Builder replacePropertyPlaceholders() {
import org.opensearch.common.logging.LogConfigurator;
    private final SetOnce<Set<String>> keys = new SetOnce<>();
        public String get(String key) {
         * @param setting The setting key
         * @param setting The setting key
                    continue;
         * Sets the setting with the provided setting key and the size value.
            put(setting, new TimeValue(value, timeUnit));
    /**
            out.writeGenericValue(entry.getValue());
     * the numbered format.
            return Long.parseLong(sValue);
                    final Optional<List<String>> optList = tryParseableStringToList(value);
         * @param timeValue The setting timeValue
    public Map<String, Settings> getGroups(String settingPrefix) throws SettingsException {
            return false;
        }
            for (Map.Entry<String, Object> entry : settings.getAsStructuredMap().entrySet()) {
        public Builder loadFromStream(String resourceName, InputStream is, boolean acceptNullValues) throws IOException {
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, is)
    public ByteSizeValue getAsMemory(String setting, String defaultValue) throws SettingsException {
                return Optional.of(list);
         * @param value   The int value
     */
                keyBuilder.append('.');
    public Map<String, Settings> getGroups(String settingPrefix, boolean ignoreNonGrouped) throws SettingsException {
            ) {
    }
            AbstractSet<Entry<String, Object>> filterSet = new AbstractSet<Entry<String, Object>>() {
        public Builder putNull(String key) {
         * @param luceneVersion The setting value
}
        // we cache that size since we have to iterate the entire set
    /**
                if (entry.getValue() == null) {
                    String prefix = key.substring(0, key.lastIndexOf('.'));
                    return map;
     */
    /**
         * @return The builder
                }
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
        }
                    } else {
        if (sValue == null) {
        /**
                builder.field(entry.getKey(), entry.getValue());
            }
         * @param values  The values
     * A builder allowing to put different settings and then {@link #build()} an immutable
import java.util.stream.Stream;
                String[] strings = Strings.splitStringByCommaToArray(get(key));
            try {
                    XContentParserUtils.throwUnknownToken(parser.currentToken(), parser.getTokenLocation());
         * @param setting The setting key
            new FilteredMap(this.settings, predicate, null),
                }
        return getGroups(settingPrefix, false);
     *
                                + key
            return defaultValue;
         */
        }
                        private Entry<String, Object> currentElement;
        public Settings build() {
     */
                    processSetting(map, prefix + key + ".", rest, value);
 * under the License.
     * returns the default value provided.
            return put(key, byteSizeValue.getStringRep());
            } else {
         * Sets the setting with the provided setting key and the int value.
        }
            if (value instanceof List) {
     */
        static DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Settings.class);
                XContentParser xContentParser = MediaTypeRegistry.JSON.xContent()
         */
        /**
            groups.put(groupName, groupSettings);
                                + "]"
@PublicApi(since = "1.0.0")
            } else if (parser.currentToken() == XContentParser.Token.VALUE_STRING
                put(keyFunction.apply(key), esSetting.getValue());
        Settings that = (Settings) o;
     * returns the default value provided.
            return delegate.getString(addPrefix.apply(setting));
            String key = setting.substring(0, prefixLength);
         * @param value   The double value
    /**
     */
            }
         * Sets the setting with the provided setting key and the time value.
            return this;
                                        return true;
    }
     * @opensearch.internal
    }
            }
            synchronized (settingNames) {
         *
         *
        );
        public Builder put(String setting, float value) {
         * @param setting The setting key
import java.util.HashSet;
            ) {
            return copy(key, key, source);
        @Override
        if (validateEndOfStream) {
        try {
    public static final Set<String> FORMAT_PARAMS = Collections.unmodifiableSet(
    }
            return this;
    /**
            }
        @Override
    private static Settings fromXContent(XContentParser parser, boolean allowNullValues, boolean validateEndOfStream) throws IOException {
                    // fall back to "." notation
                    validateValue(key, value, parser, allowNullValues);
                String key = keyBuilder.toString();
import org.opensearch.core.xcontent.MediaTypeRegistry;
            this.keyPredicate = keyPredicate;
import org.opensearch.common.annotation.PublicApi;
                throw new OpenSearchParseException(
    public Float getAsFloat(String setting, Float defaultValue) {
            return this;
            } catch (OpenSearchParseException e) {
        }
            if (existingValue == null) {
            put(setting, String.valueOf(value));
         * Note: Loading from a path doesn't allow <code>null</code> values in the incoming xcontent
                                + "="
         * @return The builder
     */
                            }
 *
        }
                }
        }
         * Sets an lucene version setting with the provided setting key and lucene version instance.
         */
        } else {
            secureSettings == null ? null : new PrefixedSecureSettings(secureSettings, "", predicate)
        if (this == o) return true;
    public int hashCode() {
                    } else if (parser.currentToken() == XContentParser.Token.VALUE_BOOLEAN) {
                validateValue(key, null, parser, allowNullValues);
/*
        public void close() throws IOException {
     */
     * Returns the settings as delimited string.
                @Override
         * Sets the setting with the provided setting key and the double value.
            builder.startObject();
            return defaultValue;
         */
        }
                    return new Iterator<Entry<String, Object>>() {
    }
                );
                                    return current.getKey().substring(prefix.length());
    }
                }
                        public boolean hasNext() {
                        return Optional.empty();
                                @Override
                    int i = k.indexOf('.');
         *
        @Override
        }
        // this is safe to do since this map is only used with unmodifiable maps
    /**
import org.opensearch.common.util.io.IOUtils;
                }
                if (ignoreNonGrouped) {
            } else if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
            map.put(prefix + setting, value);
                    processSetting(innerMap, "", rest, value);
         *
    }
        public static final Settings EMPTY_SETTINGS = Settings.EMPTY;
import org.opensearch.core.common.unit.ByteSizeValue;
            ) {
                        // uniquify, since for legacy reasons the same setting name may exist in both
                String value = propertyPlaceholder.replacePlaceholders(Settings.toString(entry.getValue()), placeholderResolver);
            return builder.toString();
        } catch (NumberFormatException e) {
            while (entryItr.hasNext()) {
    }
import java.util.ListIterator;
        }
import org.opensearch.core.xcontent.XContentParser;
            }
        public int size() {
            if (value == null) {
        final int length = keyBuilder.length();
import java.util.NoSuchElementException;
            return Version.fromId(Integer.parseInt(sValue));
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
        }
        }
     */
            } else {
                                public Object getValue() {
        }
            return put(key, enumValue.toString());
        private final SetOnce<Set<String>> settingNames = new SetOnce<>();
                    Map<String, Object> innerMap = (Map<String, Object>) existingValue;
        /**
         * @param value   The boolean value
     * A settings that are filtered (and key is removed) with the specified prefix.
                Set<String> names = stream.map(k -> {
                ArrayList<String> list = new ArrayList<>();
            }
                        @Override
        private void processLegacyLists(Map<String, Object> map) {
                for (Map.Entry<String, Object> entry : innerMap.entrySet()) {
         * @param parsableString placeholder value to parse
 * Licensed to Elasticsearch under one or more contributor
        if (sValue == null) {
    }
 */
     */
                    e,
            } else if (value instanceof List) {
 * not use this file except in compliance with the License.
    }
     * returns the default value provided.
            try (
                }
     * Note this method requires the parser to either be positioned on a null token or on
         * @param key  The setting key
                );
                        li.set(settingValueResolved);
                            }
                }
                keyBuilder.setLength(length);
/**
        String sValue = get(setting);
     * @param commaDelimited Whether to try to parse a string as a comma-delimited value
                                + "] and ["
        }
         * Returns a setting value based on the setting key.
     *
        if (settings != null) {
                                    throw new UnsupportedOperationException();
     * @opensearch.internal
            put(setting, sizeUnit.toBytes(value) + "b");
    /**
import java.util.TreeMap;
                        keys.set(Collections.unmodifiableSet(stream.collect(Collectors.toSet())));
                    if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {
                setSecureSettings(settings.getSecureSettings());
                    parser.getTokenLocation().lineNumber,
                                @Override
import java.io.InputStream;
            Object value = in.readGenericValue();
                        entry.setValue(value);
            }
     * @return  The direct keys of this settings
                }
 */
     * Returns the setting value (as int) associated with the setting key. If it does not exists,
        }
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
        }
            return this;
         * @return The builder
            return Settings.toString(map.get(key));
                        + this.secureSettings.get().getSettingNames()
    private static String toString(Object o) {
     *
     * @param key  The setting key to load the list by
    }
                    return !placeholderName.startsWith("prompt.");
         */
                // It supposed to be a value, but we already have a map stored, need to convert this map to "." notation
                    "Secure settings already set. Existing settings: "
        synchronized (firstLevelNames) {
            if (secureSettings.isLoaded() == false) {
        if (sValue == null) {
            for (String key : array) {
/*
            return this;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
                }
         *
                        );
        return getAsList(key, Collections.emptyList());
     * Returns a parsed version.
                    return Optional.empty();
                        keys.set(settings.keySet());
            // fromXContent doesn't use named xcontent or deprecation.
            PropertyPlaceholder.PlaceholderResolver placeholderResolver = new PropertyPlaceholder.PlaceholderResolver() {
        }
            toXContent(builder, new MapParams(Collections.singletonMap("flat_settings", "true")));
import java.nio.file.Path;
            final MediaType mediaType;
        public SecureString getString(String setting) throws GeneralSecurityException {
                } else {
                        list.add(String.valueOf(parser.text()));
            }
            for (int i = 0; i <= maxIndex; i++) {
            return defaultVersion;
     * Returns {@code true} if this settings object contains no settings
         * Checks that all settings(except archived settings and wildcards) in the builder start with the specified prefix.
     */
        /**
        return toString(settings.get(setting));
    private static void fromXContent(XContentParser parser, StringBuilder keyBuilder, Settings.Builder builder, boolean allowNullValues)
                                + "="
    }
     * @param key The setting key to load the list by
    /**
            } catch (Exception e) {
        }
    );
                                    return current.getValue();
                        return value;
                    }
            put(setting, String.valueOf(value));
                    if (token != XContentParser.Token.VALUE_STRING) {
        public Builder put(String setting, long value) {
                        .map(removePrefix)
import org.opensearch.core.common.Strings;
            } else if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
                @Override
     * returns the default value provided.
        /**
            }
        String sValue = get(setting);
     * Returns the setting value (as double) associated with the setting key. If it does not exists,
        public Builder put(String setting, int value) {
                    }
     */
                    while (true) {
    private final SetOnce<Set<String>> firstLevelNames = new SetOnce<>();
            return this;
    }
    }
         * @param key   The setting key
        @Override
        try {
import org.opensearch.core.common.io.stream.StreamOutput;
                    parser.getTokenLocation().lineNumber,
        private final UnaryOperator<String> removePrefix;
        /**
import java.util.AbstractSet;
         * Sets the setting with the provided setting key and an array of values.
    /**
            }
        public Builder put(String setting, boolean value) {
            XContentParser.Token lastToken = null;
     */
     * If commaDelimited is true, it will automatically load a comma separated list under the settingPrefix and merge with
    public Version getAsVersion(String setting, Version defaultVersion) throws SettingsException {
                        + "] because of a missing '.'"
        return getAsList(key, defaultValue, true);
     * Returns group settings for the given setting prefix.
     * Setting names found in this Settings for both string and secure settings.
        return MemorySizeValue.parseBytesSizeValueOrHeapRatio(get(setting, defaultValue), setting);
                                        numIterated++;
     *
            } else if (resourceName.endsWith(".yml") || resourceName.endsWith(".yaml")) {
                        + settingPrefix
            }
        public String remove(String key) {
     * Returns the setting value (as boolean) associated with the setting key. If it does not exists,
     * Prefixed secure settings
        boolean isArray = true;
            throw new SettingsException("Failed to parse double setting [" + setting + "] with value [" + sValue + "]", e);
    public Integer getAsInt(String setting, Integer defaultValue) {
         * @param enumValue The setting value
            map.putAll(replacements);
            out.writeBoolean(true);
    private void processSetting(Map<String, Object> map, String prefix, String setting, Object value) {
     * @return The setting list values
        try {
                    if (value != null) {
            }
    }
            throw new SettingsException("Failed to parse version setting [" + setting + "] with value [" + sValue + "]", e);
        private int size = -1;
     * settings implementation. Use {@link Settings#builder()} in order to
                            }
        );
                    entryItr.remove();
                    return FilteredMap.this.size();
import java.security.GeneralSecurityException;
        if (result.isEmpty()) {
     * @return {@code true} if this settings object contains no settings
    }
            if (resourceName.endsWith(".json")) {
    /**
        /**
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, parsableString)
     * @param key The setting key to load the list by
     */
        StringBuilder sb = new StringBuilder();
 */
                        entry.setValue(optList.get());
         * @param key  The setting key
    }
         * @param key  The setting key
                            return new Entry<String, Object>() {
 * You may obtain a copy of the License at
         * Sets a null value for the given setting key
 * GitHub history for details.
         * Loads settings from a stream that represents them using {@link #fromXContent(XContentParser)}
     */
            return put(key, path.toString());
            }
         */
     * This is constructed lazily in {@link #keySet()}.
    }
                        public Entry<String, Object> next() {
     * @param setting The setting key
        /**
     */
                    }
import java.util.ArrayList;
                    return placeholderName.startsWith("prompt.");
                while ((token = xContentParser.nextToken()) != XContentParser.Token.END_ARRAY) {
                    builder.put(key, value);
        return Objects.equals(settings, that.settings);
                if (token != XContentParser.Token.START_ARRAY) {
        for (Map.Entry<String, Object> entry : settings.entrySet()) {
        }
        }
                            } else {
        return secureSettings;
     * Returns group settings for the given setting prefix.
            return this;
         * Tries to parse the placeholder value as a list (fe [], ["a", "b", "c"])
        }
            if (copySecureSettings && settings.getSecureSettings() != null) {
            throw new UncheckedIOException(e);
        // pkg private so it can only be accessed by local subclasses of SecureSetting
                    continue;
            if (entry.getValue() instanceof Map) {
                        final String settingValueResolved = propertyPlaceholder.replacePlaceholders(settingValueRaw, placeholderResolver);
            return put(key, luceneVersion.toString());
        public InputStream getFile(String setting) throws GeneralSecurityException {
    private static void validateValue(String key, Object currentValue, XContentParser parser, boolean allowNullValues) {
        @Override
        }
    }
        public Builder put(String key, Enum<?> enumValue) {
            remove(setting);
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
            };
     */
         * @param path The setting path
                    }
            processLegacyLists(settingsMap);
                keyBuilder.append(parser.currentName());
                String key = entry.getKey();
                if (existingValue instanceof Map) {
                }
         */
                final String key = esSetting.getKey();
                if (entry.getValue() instanceof List) {
    public Map<String, Settings> getAsGroups() throws SettingsException {
    /**
        public Set<String> keys() {
                return putList(key, (List) value);
            return null;
import static org.opensearch.core.common.unit.ByteSizeValue.parseBytesSizeValue;
import org.opensearch.core.xcontent.XContentParserUtils;
     * Returns the settings mapped to the given setting name.
import org.opensearch.core.common.unit.ByteSizeUnit;
                        Stream<String> stream = Stream.concat(settings.keySet().stream(), secureSettings.getSettingNames().stream());
                if (key.endsWith(".0")) { // let's only look at the head of the list and convert in order starting there.
     */
            final Object value = source.settings.get(sourceKey);
 * specific language governing permissions and limitations
        /**
 */
        // we use a sorted map for consistent serialization when using getAsMap()
package org.opensearch.common.settings;
            this.secureSettings.set(secureSettings);
            this.removePrefix = s -> s.substring(prefix.length());
         * Sets a byteSizeValue setting with the provided setting key and byteSizeValue.
     * Returns group settings for the given setting prefix.
 * the Apache License, Version 2.0 (the "License"); you may
    }
        private final UnaryOperator<String> addPrefix;
            }
import java.util.concurrent.TimeUnit;
            };
            return this;
            } else if (value == null) {
                    if (i < 0) {
        }
            out.writeBoolean(false);
                if (keys.get() == null) {
import static org.opensearch.common.settings.AbstractScopedSettings.ARCHIVED_SETTINGS_PREFIX;
import org.opensearch.OpenSearchGenerationException;
        String sValue = get(setting);
         * @return The builder
                throw new SettingsException(
                            values.add(value);
        @Override
            if (groupSettings.isEmpty()) {
         * Runs across all the settings set on this builder and
        }
         */
            Iterator<Map.Entry<String, Object>> entryItr = map.entrySet().iterator();
        }
     * The values associated with a setting key as an immutable list.
            }
                            if (currentElement == null && hasNext() == false) { // protect against no #hasNext call or not respecting it
         * Sets an level setting with the provided setting key and level instance.
                    // Something went wrong. Different format?
import java.util.function.Predicate;
        return getGroupsInternal("", false);
     * @return The setting list values
        } catch (NumberFormatException e) {
            if (entry.getValue() instanceof Map) {
                    }
                );
                            map.put(prefix, values);
         * Sets the setting with the provided setting key and a list of values.
     * {@link Setting} object constructed in, for example, {@link org.opensearch.env.Environment}.
 * The OpenSearch Contributors require contributions made to
                    parser.getTokenLocation().columnNumber
        private final Map<String, Object> map = new TreeMap<>();
                            break;
                    @SuppressWarnings("unchecked")
        /**
     * <p>
    }
                Map<String, Object> valMap = (Map<String, Object>) entry.getValue();
            new FilteredMap(this.settings, (k) -> k.startsWith(prefix), prefix),
                    } else {
    }
                    return delegate.containsKey(theKey);
        for (int i = 0; i < numberOfSettings; i++) {
        return null;
                throw new IllegalArgumentException(
                    while (li.hasNext()) {
            return this;
        }
            map.putAll(settingsMap);
            secureSettings == null ? null : new PrefixedSecureSettings(secureSettings, prefix, s -> s.startsWith(prefix))
    private final Map<String, Object> settings;
         * @return The builder
    }
        return Collections.unmodifiableMap(groups);
        if (settingPrefix.charAt(settingPrefix.length() - 1) != '.') {
        }
        /**
                    "Failed to get setting group for ["
import java.util.List;
 * software distributed under the License is distributed on an
    }
                                    if (filter.test((currentElement = iter.next()).getKey())) {
         */
        Builder innerBuilder = Settings.builder();
                                return true; // protect against calling hasNext twice
        @Override
            return putList(setting, Arrays.asList(values));
        private final Predicate<String> keyPredicate;
            String key = in.readString();
     *
    @Override
            throw new SettingsException("Failed to parse int setting [" + setting + "] with value [" + sValue + "]", e);
            return delegate.isLoaded();
/*
     * Returns the setting value (as time) associated with the setting key. If it does not exists,
                                return current;
    private static class PrefixedSecureSettings implements SecureSettings {
    }
        if (sValue == null) {
        public Builder setSecureSettings(SecureSettings secureSettings) {
            return loadFromStream(path.getFileName().toString(), Files.newInputStream(path), false);
         * @param value   The time value
        }
 *
    /** Returns the fully qualified setting names contained in this settings object. */
import org.opensearch.OpenSearchParseException;
        for (String groupName : prefixSettings.names()) {
                @SuppressWarnings("unchecked")
                }).collect(Collectors.toSet());
 * SPDX-License-Identifier: Apache-2.0
    }
         * Sets the setting with the provided setting key and the long value.
        } catch (IOException e) {
    /**
 * An immutable settings implementation.
                            if (currentElement != null) {
        }
                if (filter.test(theKey)) {
                    return Settings.toString(map.get(placeholderName));
import org.opensearch.common.unit.TimeValue;
     * @opensearch.api
            Map<String, Object> settingsMap = new HashMap<>(settings.settings);
    /**
public final class Settings implements ToXContentFragment {
            return delegate.getFile(addPrefix.apply(setting));
    }
         * @param value   The long value
            return put(key, level.toString());
                processSetting(newMap, "", rest, value);
                        + settingPrefix
    /**
    /**
 *
        private final SecureSettings delegate;
    public Settings getAsSettings(String setting) {
            return this;
            throw new IllegalArgumentException("illegal setting prefix " + settingPrefix);
     *
        Map<String, Settings> groups = new HashMap<>();
                        return k;
    @Override
        /**
            for (final Map.Entry<String, String> esSetting : esSettings.entrySet()) {
    public Settings filter(Predicate<String> predicate) {
                Stream<String> stream = settings.keySet().stream();
                throw new SettingsException("Failed to load settings from [" + resourceName + "]", e);
import static org.opensearch.common.unit.TimeValue.parseTimeValue;
                map.put(prefix + key, newMap);
                if (Strings.hasLength(value) == true) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(delimiter);
        }
import java.util.AbstractMap;
    }
        }
        public Builder put(String key, String value) {
    private Map<String, Settings> getGroupsInternal(String settingPrefix, boolean ignoreNonGrouped) throws SettingsException {
                builder.putList(key, (List<String>) value);
    private static final class FilteredMap extends AbstractMap<String, Object> {
 * this work for additional information regarding copyright
        return getByPrefix(setting + ".");
            }
        }
    }
            }
         */
    /**
        /**
            delegate.close();
                    // It supposed to be a map, but we already have a value stored, which is not a map
                    validateValue(key, parser.text(), parser, allowNullValues);
            if (size == -1) {
                }
         * @param key  The setting key
                        if (value == null) {
                    Iterator<Entry<String, Object>> iter = delegateSet.iterator();
        public Builder put(String key, Path path) {
        public Builder putList(String setting, List<String> values) {
                    stream = Stream.concat(stream, secureSettings.getSettingNames().stream());
                Object obj = map.get(Integer.toString(i));
        public Builder put(Settings settings, boolean copySecureSettings) {
        public Builder putList(String setting, String... values) {
            throw new OpenSearchParseException(
            this.delegate = delegate;
                if (parser.currentToken() == null) {
    }
        if (prefixLength == -1) {
                return put(key, Settings.toString(value));
        if (map.isEmpty()) {
        return parseBytesSizeValue(get(setting), defaultValue, setting);
        if (!params.paramAsBoolean("flat_settings", false)) {
    @Override
        /**
         */
         * @return The builder
        Settings prefixSettings = getByPrefix(settingPrefix);
                if (strings.length > 0) {
    /**
 * @opensearch.api
import org.opensearch.common.unit.MemorySizeValue;
                        }
        Set<Map.Entry<String, Object>> entries = settings.settings.entrySet();
        }
        this.settings = Collections.unmodifiableSortedMap(new TreeMap<>(settings));
import java.util.Collections;
        }
            try (
                builder.putNull(key);
        private Builder() {
            this.prefix = prefix;
        }
     * Returns <code>true</code> iff the given key has a value in this settings object
            }
            return readSettingsFromStream(in);
            put(setting, String.valueOf(value));
    }
    /**
        public Builder put(String setting, Version version) {
            put(setting, version.id);
import java.io.UncheckedIOException;
     * <p>
        return map;
        /**
                            this.currentElement = null;
                Map<String, Object> newMap = new HashMap<>(2);
import java.util.function.Function;
     * returns the default value provided.
 *     http://www.apache.org/licenses/LICENSE-2.0
                    builder.put(key, parser.booleanValue());
         * @param key  The setting key
                }
                    "malformed, expected end of settings but encountered additional content starting at line number: [{}], "
    private Object convertMapsToArrays(Map<String, Object> map) {
         */
                    continue;
        return retVal == null ? defaultValue : retVal;
         * replaces {@code ${...}} elements in each setting with
    public String toDelimitedString(char delimiter) {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    public static final Settings EMPTY = new Settings(Collections.emptyMap(), null);
        List<String> result = new ArrayList<>();
     */
        // pull settings to exclude secure settings in size()
        @Override
         * Sets a time value setting with the provided setting key and value.
                                + map.get(key)
            String rest = setting.substring(prefixLength + 1);
                if (settingNames.get() == null) {
 * compatible open source license.
                    // Bailout!
    /** The raw settings from the full key to raw string value. */
                    map.put(prefix + setting + "." + entry.getKey(), entry.getValue());
                }
import java.nio.file.Files;
        }
                    int counter = 0;
            builder.endObject();
                    } else {
     * Returns a builder to be used in order to build settings.
            return new Settings(map, secureSettings.get());
        public Builder put(final String key, final ByteSizeValue byteSizeValue) {
        return settings != null ? settings.hashCode() : 0;
                    }
        if (keys.get() == null) {
        return keySet().size();
         */
                final String theKey = prefix == null ? (String) key : prefix + key;
         * Loads settings from the actual string content that represents them using {@link #fromXContent(XContentParser)}
            throw new SettingsException("Failed to parse long setting [" + setting + "] with value [" + sValue + "]", e);
        }
    /**
     */
    private Settings(Map<String, Object> settings, SecureSettings secureSettings) {
                } catch (NumberFormatException ex) {
                    }
        }
                }
                                }
            return this;
         * @param setting The setting key
import org.opensearch.core.xcontent.XContentBuilder;
    }
    /** The secure settings storage associated with these settings. */
        /**
     * (eg. 12%). If it does not exists, parses the default value provided.
                    isArray = false;
     * absolute values (interpreted as a number of bytes), byte sizes (eg. 1mb) or percentage of the heap size
import org.opensearch.core.xcontent.MediaType;
        }
            parser.nextToken();
         * @param value   The float value
                public int size() {
                return Collections.unmodifiableList((List<String>) valueFromPrefix);
            } catch (Exception e) {
                this.put(fromXContent(parser, true, true));
        public Builder put(String key, org.apache.lucene.util.Version luceneVersion) {
                        + groupName
            this.delegate = delegate;
        public byte[] getSHA256Digest(String setting) throws GeneralSecurityException {
        }
     */
         * @return The builder
                );
                            if (prefix == null) {
                        + "] setting prefix and setting ["
