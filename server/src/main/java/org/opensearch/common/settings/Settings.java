        public Builder put(String setting, long value, ByteSizeUnit sizeUnit) {
    /**
    /**
        fromXContent(parser, currentKeyBuilder, innerBuilder, allowNullValues);
    public Settings getByPrefix(String prefix) {
        return parseTimeValue(get(setting), defaultValue, setting);
        Builder replacePropertyPlaceholders(Function<String, String> getenv) {
                    };
            new FilteredMap(this.settings, predicate, null),
            if (valueFromPrefix instanceof List) {  
                }  
            out.writeGenericValue(entry.getValue());
import java.io.UncheckedIOException;
        /**
 * license agreements. See the NOTICE file distributed with
     *
                }
            } else if (commaDelimited) {
         * set on this builder.  
     * the numbered format.
                }  
        }  
         */
                                public Object setValue(Object value) {  
    /**  
import org.opensearch.core.common.unit.ByteSizeValue;
                throw new IllegalStateException("Secure settings must already be loaded");
         * @param byteSizeValue The setting value
            } catch (Exception e) {
            if (existingValue == null) {
        }
        return getAsList(key, defaultValue, true);  
    }  
     */  
    private final SecureSettings secureSettings;
                    List<String> values = new ArrayList<>();
        for (String groupName : prefixSettings.names()) {
                    } else {  
            for (final Map.Entry<String, String> esSetting : esSettings.entrySet()) {
            processLegacyLists(map);  
                } else {  
            return delegate.getFile(addPrefix.apply(setting));  
            if (copySecureSettings && settings.getSecureSettings() != null) {
                    XContentParserUtils.throwUnknownToken(parser.currentToken(), parser.getTokenLocation());
                Map<String, Object> valMap = (Map<String, Object>) entry.getValue();  
                    builder.put(key, value);
                        private int numIterated;
            writeSettingsToStream(settings, out);  
            }
        return map;
     * <p>
                mediaType = XContentType.YAML;  
        }
     * The values associated with a setting key as an immutable list.
import org.opensearch.OpenSearchParseException;  
            put(setting, String.valueOf(value));
        try {  
 *
                // It supposed to be a value, but we already have a map stored, need to convert this map to "." notation
         *
                                }  
         */
                    }
                if (strings.length > 0) {
        return null;
        // we cache that size since we have to iterate the entire set
            } else {
            };
        // pkg private so it can only be accessed by local subclasses of SecureSetting
                if (Strings.hasLength(value) == true) {
            return delegate.isLoaded();
            }
import org.apache.logging.log4j.Level;
        }  
         */  
            }
                        String value = get(listKey);
                        return k.substring(0, i);
        /**  
        /**
        /**
    private static class PrefixedSecureSettings implements SecureSettings {
                            map.remove(listKey);
                @SuppressWarnings("unchecked")
        } catch (NumberFormatException e) {
         * @return the {@link Optional} result of the parsing attempt
        } else {
                return Collections.unmodifiableList((List<String>) valueFromPrefix);
         * @param value The setting value
        public Builder putNull(String key) {  
        }
            throw new UncheckedIOException(e);
     */
        public Builder normalizePrefix(String prefix) {
    }
            }  
    }
            }
        // pull settings to exclude secure settings in size()  
    public ByteSizeValue getAsMemory(String setting, String defaultValue) throws SettingsException {  
                    stream = Stream.concat(stream, secureSettings.getSettingNames().stream());
    public Settings filter(Predicate<String> predicate) {  
        synchronized (firstLevelNames) {  
                final String key = esSetting.getKey();  
        public Set<String> getSettingNames() {  
         * @param settings the settings to set  
    private static String toString(Object o) {
            return new Settings(map, secureSettings.get());
         *
                                        return true;
                        .filter(keyPredicate)
    private static void validateValue(String key, Object currentValue, XContentParser parser, boolean allowNullValues) {
         * If a setting doesn't start with the prefix, the builder appends the prefix to such setting.
            final MediaType mediaType;
         *
         * @return The builder
        public Builder putList(String setting, List<String> values) {  
            }
                @Override
                    "malformed, expected end of settings but encountered additional content starting at line number: [{}], "
import java.util.Set;
            }  
            String rest = setting.substring(prefixLength + 1);  
                validateValue(key, list, parser, allowNullValues);  
        /**
        XContentParserUtils.ensureExpectedToken(XContentParser.Token.START_OBJECT, parser.currentToken(), parser);
            put(setting, String.valueOf(value));  
            throw new SettingsException("Failed to parse version setting [" + setting + "] with value [" + sValue + "]", e);
            PropertyPlaceholder.PlaceholderResolver placeholderResolver = new PropertyPlaceholder.PlaceholderResolver() {  
        return map;
        @Override  
         */
                Set<String> names = stream.map(k -> {  
     * Returns {@code true} if this settings object contains no settings
    public static Settings readOptionalSettingsFromStream(StreamInput in) throws IOException {
        public Builder replacePropertyPlaceholders() {
            map.put(key, value);
    }
     * Returns group settings for the given setting prefix.  
            }
    }
                }  
        }
         *
                }
@PublicApi(since = "1.0.0")
        @Override
                    String value = parser.text();  
import org.opensearch.common.annotation.PublicApi;
            this.addPrefix = s -> prefix + s;
import java.io.InputStream;
            this.prefix = prefix;
            this.secureSettings.set(secureSettings);
            return this;  
     * returns the default value provided.
/*
    private Map<String, Object> getAsStructuredMap() {  
     */
        private final Map<String, Object> map = new TreeMap<>();
                        + secureSettings.getSettingNames()
import org.opensearch.core.xcontent.XContentParser;  
            } else {
        }
import org.opensearch.core.xcontent.DeprecationHandler;  
    public int hashCode() {
         * @param enumValue The setting value
            return put(key, path.toString());
                builder.map(map);  
            }
            map.putAll(settingsMap);  
         * @param values  The values
        public Builder put(String setting, int value) {
        }  
                        entry.setValue(optList.get());  
        return getByPrefix(setting + ".");
        }
                        );  
    static class DeprecationLoggerHolder {  
        for (Map.Entry<String, Object> entry : settings.entrySet()) {
        List<String> result = new ArrayList<>();  
            return Version.fromId(Integer.parseInt(sValue));
                }
                if (filter.test(theKey)) {
     * @param setting The setting key
        }
         */
        }
                }
    public static Settings fromXContent(XContentParser parser) throws IOException {  
                );  
            if (key instanceof String) {  
            }  
import org.opensearch.core.common.Strings;  
     * construct it.  
            put(setting, String.valueOf(value));
                firstLevelNames.set(Collections.unmodifiableSet(names));
    public String toString() {  
            return null;  
        }
                    // Bailout!
     * leading to a runtime failure (see {@link LogConfigurator#checkErrorListener()} ). The premature construction would come from any
                            if (currentElement == null && hasNext() == false) { // protect against no #hasNext call or not respecting it  
         * Loads settings from a stream that represents them using {@link #fromXContent(XContentParser)}
        }  
            map.put(setting, new ArrayList<>(values));
     *
         * Sets an level setting with the provided setting key and level instance.  
        if (sValue == null) {  
                }
                                return true; // protect against calling hasNext twice
     * returns the default value provided.
     * It will also automatically load a comma separated list under the settingPrefix and merge with
                                public Object getValue() {
    private static Settings fromXContent(XContentParser parser, boolean allowNullValues, boolean validateEndOfStream) throws IOException {
     */  
        public InputStream getFile(String setting) throws GeneralSecurityException {
         *
            return this;
                            }  
                throw new IllegalArgumentException("unable to detect content type from resource name [" + resourceName + "]");
    }
    public Settings getAsSettings(String setting) {
        } catch (Exception e) {  
 */
        /**  
         */  
                put(keyFunction.apply(key), esSetting.getValue());
    /**
                validateValue(key, null, parser, allowNullValues);
        /**
         * @param key  The setting key
import org.opensearch.common.SetOnce;  
        );
import java.util.List;
        /**
        return new Settings(
        try {
                Map.Entry<String, Object> entry = iterator.next();
         * @param setting The setting key  
            } catch (Exception e) {  
    /**
        }
            if (secureSettings.isLoaded() == false) {  
        public void close() throws IOException {  
    public int size() {
                throw e;
                put(fromXContent(parser, acceptNullValues, true));
         * @param setting The setting key
public final class Settings implements ToXContentFragment {  
                final String theKey = prefix == null ? (String) key : prefix + key;
            groups.put(groupName, groupSettings);
                builder.putList(key, (List<String>) value);  
                        + settingPrefix
         */
                    list.add(xContentParser.text());  
    /** Returns the fully qualified setting names contained in this settings object. */
            return defaultValue;
         * Loads settings from a map.
        private final SetOnce<Set<String>> settingNames = new SetOnce<>();  
        /**  
        final int length = keyBuilder.length();
import org.opensearch.core.xcontent.MediaType;
 * under the License.  
            return defaultValue;
         * Builds a {@link Settings} (underlying uses {@link Settings}) based on everything
import java.util.Optional;
     * @param key  The setting key to load the list by  
                    return new Iterator<Entry<String, Object>>() {  
                                + "]"
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(delimiter);
import static org.opensearch.common.unit.TimeValue.parseTimeValue;  
        return getGroupsInternal("", false);
        }
        }
    private final SetOnce<Set<String>> firstLevelNames = new SetOnce<>();
/*  
    }
         * @param key   The setting key  
            remove(setting);
         * Sets an lucene version setting with the provided setting key and lucene version instance.
     *  
import org.opensearch.core.xcontent.MediaTypeRegistry;
         * @param setting The setting key
    /**
        }
        private FilteredMap(Map<String, Object> delegate, Predicate<String> filter, String prefix) {
        if (result.isEmpty()) {
                }).collect(Collectors.toSet());
        if (settingPrefix.charAt(settingPrefix.length() - 1) != '.') {
                                return false;  
                    }  
        }  
                    final Optional<List<String>> optList = tryParseableStringToList(value);
    public Set<String> keySet() {  
                return putNull(key);  
import org.opensearch.OpenSearchGenerationException;
            }
        }
    }
package org.opensearch.common.settings;
        }  
                                if (numIterated == size) { // early terminate  
            Object existingValue = map.get(prefix + key);
                    }
                    }  
        /**  
            return put(key, level.toString());
     * @param commaDelimited Whether to try to parse a string as a comma-delimited value
            return put(settings, true);
        return getGroupsInternal(settingPrefix, ignoreNonGrouped);
            this.delegate = delegate;
     * Returns the setting value (as double) associated with the setting key. If it does not exists,
            }
        } catch (NumberFormatException e) {
        if (in.readBoolean()) {
         * Note: Loading from a path doesn't allow <code>null</code> values in the incoming xcontent  
                Map.Entry<String, Object> entry = entryItr.next();
                        @Override
         *
     * Returns a builder to be used in order to build settings.
                    return !placeholderName.startsWith("prompt.");
    /** The first level of setting names. This is constructed lazily in {@link #names()}. */
         * Loads settings from a url that represents them using {@link #fromXContent(XContentParser)}
    public Double getAsDouble(String setting, Double defaultValue) {
         * @param setting The setting key
                        final String settingValueResolved = propertyPlaceholder.replacePlaceholders(settingValueRaw, placeholderResolver);
         * @param values  The values  
                @Override
         *  
    }
         * Sets a null value for the given setting key
            return loadFromStream(path.getFileName().toString(), Files.newInputStream(path), false);
                Map<String, Object> valMap = (Map<String, Object>) entry.getValue();
     * Note this method requires the parser to either be positioned on a null token or on  
                                    }
            }
                builder.putNull(key);
                                    return current.getKey().substring(prefix.length());  
                    "malformed, expected end of settings but encountered additional content starting at line number: [{}], "
     * Returns the setting value (as boolean) associated with the setting key. If it does not exists,
                result.add(get(key).trim());
import java.util.AbstractSet;
     */
     * Returns group settings for the given setting prefix.
        public Builder put(Settings settings, boolean copySecureSettings) {  
        String sValue = get(setting);  
            try (
        @Override  
        }
                }
    }  
    /**
                }  
     *  
        }  
                        throw new IllegalStateException(
            return put(key, byteSizeValue.getStringRep());  
            );
                        + groupName  
     * If commaDelimited is true, it will automatically load a comma separated list under the settingPrefix and merge with
                                currentElement = null;
                entry.setValue(convertMapsToArrays(valMap));
        }  
        return keys.get();  
            if (value instanceof List) {  
     * {@link Setting} object constructed in, for example, {@link org.opensearch.env.Environment}.
        public boolean isLoaded() {
                @SuppressWarnings("unchecked")
                    } else {
                Stream<String> stream = settings.keySet().stream();
        }
            Map<String, Object> innerMap = (Map<String, Object>) map.get(prefix + setting);
            Object value = in.readGenericValue();
    public Map<String, Settings> getGroups(String settingPrefix, boolean ignoreNonGrouped) throws SettingsException {  
            if (this.secureSettings.get() != null) {  
                            this.currentElement = null;
            };  
            return this;  
        } else {
import static org.opensearch.core.common.unit.ByteSizeValue.parseBytesSizeValue;
     * @return The setting list values  
            put(setting, String.valueOf(value));
 *     http://www.apache.org/licenses/LICENSE-2.0
                    if (map.containsKey(prefix)) {
        }
    /**  
         *  
            }
        String retVal = get(setting);
                        maxIndex = Math.max(maxIndex, index);
        @Override
import java.nio.file.Path;
     * @return The setting list values  
    public boolean equals(Object o) {
            XContentParser.Token lastToken = null;
            this.removePrefix = s -> s.substring(prefix.length());
            throw new SettingsException("Failed to parse long setting [" + setting + "] with value [" + sValue + "]", e);  
    /** Returns the number of settings in this settings object. */  
                Map<String, Object> newMap = new HashMap<>(2);  
        }
         */  
import java.util.Map;
                for (Map.Entry<String, Object> entry : innerMap.entrySet()) {
                                    assert size != -1 : "size was never set: " + numIterated + " vs. " + size;
         * @param value   The long value
                newValue.add(obj);
 *
        public boolean containsKey(Object key) {
import org.opensearch.core.common.io.stream.StreamOutput;
        if (o == null || getClass() != o.getClass()) return false;
        }
            return builder.toString();
        }
                    final String value = getenv.apply(placeholderName);  
         * Sets the setting with the provided setting key and the size value.
                this.put(fromXContent(parser, true, true));  
                                // we didn't find anything
                        }
                    processSetting(map, prefix + key + ".", rest, value);  
        return o == null ? null : o.toString();  
        private final Predicate<String> keyPredicate;
        String sValue = get(setting);
        Builder builder = new Builder();
        }
                @Override
            String key = setting.substring(0, prefixLength);
         *
         * @param value   The size value
            synchronized (keys) {
        }  
        }  
        StringBuilder sb = new StringBuilder();  
                public String resolvePlaceholder(String placeholderName) {
            if (isArray) {
 * this file be licensed under the Apache-2.0 license or a
                    // try to parse the value as a list first  
        public Builder put(String key, Path path) {
import java.util.concurrent.TimeUnit;
                    "Secure settings already set. Existing settings: "
            return delegate.getSHA256Digest(addPrefix.apply(setting));
                        private Entry<String, Object> currentElement;
    private void processSetting(Map<String, Object> map, String prefix, String setting, Object value) {
     * @opensearch.internal
 * You may obtain a copy of the License at  
                    parser.getTokenLocation().lineNumber,
            return secureSettings.get();
        return fromXContent(parser, true, false);
                    continue;
        public static final Settings EMPTY_SETTINGS = Settings.EMPTY;
                        list.add(String.valueOf(parser.text()));  
    }
     * the numbered format.  
    /**
         * Sets all the provided settings.
    // TODO We could use an FST internally to make things even faster and more compact  
        }  
         * @return The builder  
            Set<Entry<String, Object>> delegateSet = delegate.entrySet();
    public String toDelimitedString(char delimiter) {
            if (resourceName.endsWith(".json")) {  
                    } else if (parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {  
                    for (String string : strings) {
    public String get(String setting, String defaultValue) {
            for (int i = 0; i <= maxIndex; i++) {  
        if (valueFromPrefix != null) {
        }
            if (parser.currentToken() == XContentParser.Token.FIELD_NAME) {
                while ((token = xContentParser.nextToken()) != XContentParser.Token.END_ARRAY) {
    }  
                    iterator.remove();  
        if (map.isEmpty()) {
                String key = keyBuilder.toString();
     */
     * Returns <code>true</code> iff the given key has a value in this settings object
            this.filter = filter;  
     */
         * Sets the setting with the provided setting key and the time value.
            if (size == -1) {
    /**
        int numberOfSettings = in.readVInt();
                builder.field(entry.getKey(), entry.getValue());  
        return getAsList(key, Collections.emptyList());
    /**
                    // a null value obviously can't be replaced
                XContentParser parser = mediaType.xContent()  
    );
            if (source.settings.containsKey(sourceKey) == false) {
         */  
import static org.opensearch.common.settings.AbstractScopedSettings.ARCHIVED_SETTINGS_PREFIX;
        }
                        entry.setValue(value);
                    builder.put(key, parser.booleanValue());  
                    } else if (parser.currentToken() == XContentParser.Token.VALUE_BOOLEAN) {
    public List<String> getAsList(String key, List<String> defaultValue) throws SettingsException {
     */  
            throw new IllegalArgumentException("illegal setting prefix " + settingPrefix);
            return delegate.getString(addPrefix.apply(setting));
        private final String prefix;
            return this;  
        int prefixLength = setting.indexOf('.');
    public ByteSizeValue getAsBytesSize(String setting, ByteSizeValue defaultValue) throws SettingsException {  
            return Double.parseDouble(sValue);
    /** The secure settings storage associated with these settings. */
                            values.add(value);
import java.util.Objects;  
        new HashSet<>(Arrays.asList("settings_filter", "flat_settings"))
            this.keyPredicate = keyPredicate;  
                            };  
                    .createParser(NamedXContentRegistry.EMPTY, LoggingDeprecationHandler.INSTANCE, source)
        @Override
        out.writeVInt(entries.size());
    public static final Settings EMPTY = new Settings(Collections.emptyMap(), null);
                String key = keyBuilder.toString();  
    private static final class FilteredMap extends AbstractMap<String, Object> {
        }
            secureSettings == null ? null : new PrefixedSecureSettings(secureSettings, prefix, s -> s.startsWith(prefix))
     * @param key The setting key to load the list by
import java.util.HashSet;  
        private final UnaryOperator<String> addPrefix;  
     * Prefixed secure settings  
                    ;
        }
                        final String settingValueRaw = li.next();
                ArrayList<String> list = new ArrayList<>();
        if (parser.currentToken() == null) {
         * Sets a time value setting with the provided setting key and value.  
         * Returns a setting value based on the setting key.  
        public Builder put(String setting, double value) {
         */  
                );  
            return settingNames.get();
            } else if (value == null) {
        public Builder put(String key, Enum<?> enumValue) {
                        }  
                                + "="
        }
            if (lastToken != null) {  
            if (innerMap != null) {  
            if (firstLevelNames.get() == null) {
         */
            Settings groupSettings = prefixSettings.getByPrefix(groupName + ".");
        Settings settings = SettingsFilter.filterSettings(params, this);  
            try {  
                        list.add(parser.text());
         */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }
        /**  
    }
            } else if (parser.currentToken() == XContentParser.Token.START_ARRAY) {
     * Returns the setting value (as int) associated with the setting key. If it does not exists,  
                    if (parser.nextToken() == null) {
        /**
/**  
    }  
         * Checks that all settings(except archived settings and wildcards) in the builder start with the specified prefix.  
        public Builder put(Settings settings) {  
    public boolean hasValue(String key) {
    }
    }
                builder.field(entry.getKey(), entry.getValue());
        if (currentValue == null && allowNullValues == false) {
        if (!params.paramAsBoolean("flat_settings", false)) {
     * The values associated with a setting key as an immutable list.  
    public TimeValue getAsTime(String setting, TimeValue defaultValue) {
    @Override
                    map.put(prefix + key, innerMap);
            return this;
            String[] array = map.keySet().toArray(new String[0]);
         */
        public Builder put(final String key, final ByteSizeValue byteSizeValue) {
            } else {  
                    return map;
                    validateValue(key, parser.text(), parser, allowNullValues);
            return filterSet;
import java.util.TreeMap;  
                String key = entry.getKey();  
                size = Math.toIntExact(delegate.keySet().stream().filter(filter).count());
         * @return The builder
            // TODO: do this without a serialization round-trip
                // otherwise, the replace process resolved into removing it
         * @param value   The time value
                    } else {
import org.opensearch.common.unit.MemorySizeValue;
         * <p>
    }  
    }
    }
        /** Return the current secure settings, or {@code null} if none have been set. */  
    /**  
         * Sets the setting with the provided setting key and the boolean value.
         * another setting already set on this builder.  
                    entryItr.remove();
     * Returns the setting value (as float) associated with the setting key. If it does not exists,
            }  
            }  
    /**
                    // It supposed to be a map, but we already have a value stored, which is not a map
                    final ListIterator<String> li = ((List<String>) entry.getValue()).listIterator();
                public int size() {  
        }  
 */  
                }  
     * (eg. 12%). If it does not exists, parses the default value provided.
            AbstractSet<Entry<String, Object>> filterSet = new AbstractSet<Entry<String, Object>>() {  
        public Builder put(String setting, Version version) {
    public Map<String, Settings> getAsGroups() throws SettingsException {
            } catch (IOException e) {
import java.util.ListIterator;  
        public SecureSettings getSecureSettings() {
            } catch (Exception e) {
     */
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                // if the values exists and has length, we should maintain it in the map  
        /**  
                }  
    public static class Builder {
            }
         * Sets a byteSizeValue setting with the provided setting key and byteSizeValue.
        } else {
    public List<String> getAsList(String key, List<String> defaultValue, Boolean commaDelimited) throws SettingsException {
     * It will also automatically load a comma separated list under the settingPrefix and merge with  
            return replacePropertyPlaceholders(System::getenv);  
            return this;
                return loadFromSource(builder.toString(), builder.contentType());
    }
            } catch (OpenSearchParseException e) {  
        /**  
        if (isArray && (maxIndex + 1) == map.size()) {
 * Licensed to Elasticsearch under one or more contributor  
        private final SecureSettings delegate;
     */
        public Builder loadFromStream(String resourceName, InputStream is, boolean acceptNullValues) throws IOException {
            return defaultValue;  
        }  
        // visible for testing  
     * returns the default value provided.
    private static void fromXContent(XContentParser parser, StringBuilder keyBuilder, Settings.Builder builder, boolean allowNullValues)  
            processLegacyLists(settingsMap);
            out.writeString(entry.getKey());
     * Returns group settings for the given setting prefix.
     */
            return put(key, luceneVersion.toString());  
        if (sValue == null) {
    }
         */  
     * Writes an optional {@link Settings} to the stream. A {@code null} value is permitted.  
            try (
            @SuppressWarnings("unchecked")
    }
    /**
            Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();  
import java.io.IOException;  
                return putList(key, (List) value);
         * @param value   The double value
     * Counterpart to {@link #readOptionalSettingsFromStream(StreamInput)}.
         * @param setting The setting key  
     */  
                                @Override
        public Object get(Object key) {
        Settings prefixSettings = getByPrefix(settingPrefix);
                    while (true) {  
 * not use this file except in compliance with the License.
        private int size = -1;
         * Sets the setting with the provided setting key and the double value.
        public Settings build() {
     * We have to lazy initialize the deprecation logger as otherwise a static logger here would be constructed before logging is configured  
         * @param key  The setting key  
                    return Optional.empty();
import org.opensearch.common.Booleans;
                if (keys.get() == null) {
                }
            return this;  
     * Counterpart to {@link #writeOptionalSettingsToStream(Settings, StreamOutput)}.
    }  
     *
                            }
import java.util.Collections;
     */
            put(setting, new TimeValue(value, timeUnit));
         */
    }  
        } catch (IOException e) {  
                            final Entry<String, Object> current = this.currentElement;
                    processSetting(innerMap, "", rest, value);
         */
        // this is safe to do since this map is only used with unmodifiable maps  
            }  
        public Builder loadFromPath(Path path) throws IOException {
                String[] strings = Strings.splitStringByCommaToArray(get(key));  
            return map;
        }
         * replaces {@code ${...}} elements in each setting with
                                + map.get(prefix)  
         * @return The builder  
        public Builder put(String setting, boolean value) {
        String sValue = get(setting);
                }
        }  
            Iterator<Map.Entry<String, Object>> entryItr = map.entrySet().iterator();  
         * Runs across all the settings set on this builder and
        this.settings = Collections.unmodifiableSortedMap(new TreeMap<>(settings));  
     *
            return defaultValue;
import org.opensearch.core.common.io.stream.StreamInput;
        );  
        private Builder() {
                        + this.secureSettings.get().getSettingNames()  
        }
        if (!Strings.hasLength(settingPrefix)) {
            }
            } else if (value instanceof List) {
            return putList(setting, Arrays.asList(values));
import org.opensearch.common.logging.DeprecationLogger;
            return Settings.toString(map.remove(key));
    /**
        @Override
        @Override  
         */
     */
                throw new SettingsException("Failed to load settings from [" + resourceName + "]", e);  
        }
        return settings.get(key) != null;
        @Override  
     * A builder allowing to put different settings and then {@link #build()} an immutable
        private static Optional<List<String>> tryParseableStringToList(String parsableString) {  
        return sb.toString();
                if (token != XContentParser.Token.START_ARRAY) {
        Builder innerBuilder = Settings.builder();  
import java.util.NoSuchElementException;
            for (Map.Entry<String, Object> entry : settings.getAsStructuredMap().entrySet()) {
        }  
    private Settings(Map<String, Object> settings, SecureSettings secureSettings) {
            return Settings.toString(map.get(key));  
                            map.put(prefix, values);
                }  
         * @param path The setting path
        @Override
        }  
                parser.getTokenLocation().lineNumber,  
                } else if (parser.currentToken() == XContentParser.Token.VALUE_BOOLEAN) {  
        return Collections.unmodifiableList(result);
            return false;
         */  
        try {  
     * Retrieve the secure settings in these settings.
            ) {
         */  
        }  
 * SPDX-License-Identifier: Apache-2.0
                                }  
         * Sets a setting with the provided setting key and value.
                    return FilteredMap.this.size();
        Settings that = (Settings) o;  
        }
    }
                    continue;
    private final SetOnce<Set<String>> keys = new SetOnce<>();
    /**
        String sValue = get(setting);
    }
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, Object> map = new HashMap<>(2);
        return parseBytesSizeValue(get(setting), defaultValue, setting);
     */  
    }  
        }
                // Check that the keys are still null now that we have acquired the lock  
                                    if (filter.test((currentElement = iter.next()).getKey())) {
    }
                @Override  
        /**
}  
            PropertyPlaceholder propertyPlaceholder = new PropertyPlaceholder("${", "}", false);
            } else if (parser.currentToken() == XContentParser.Token.START_OBJECT) {
            builder.startObject();
            }  
         * @return The builder
            }  
    /** The raw settings from the full key to raw string value. */
import java.util.function.Predicate;  
        }
            secureSettings == null ? null : new PrefixedSecureSettings(secureSettings, "", predicate)  
                    e,
     * Returns the setting value associated with the setting key. If it does not exists,
     * @opensearch.api
            return this;
import java.util.stream.Stream;  
         * @param value   The int value
        String sValue = get(setting);  
        }
            }
                }
    /**  
    /**
                throw new SettingsException(
        }
         * @param copySecureSettings if <code>true</code> all settings including secure settings are copied.
            if (key instanceof String) {
            }
/*  
        } catch (NumberFormatException e) {  
                    validateValue(key, value, parser, allowNullValues);
                    String prefix = key.substring(0, key.lastIndexOf('.'));  
            map.put(prefix + setting, value);  
         * @param setting The setting key  
         * Sets the setting with the provided setting key and a list of values.  
     * Reads an optional {@link Settings} from the stream. Returns {@code null} if no settings were written.
     */
                                }
 * specific language governing permissions and limitations
            settingPrefix = settingPrefix + ".";
        public Set<Entry<String, Object>> entrySet() {
                    int counter = 0;
                    }  
        /**
                                + map.get(key)
            out.writeBoolean(false);
        }
     * absolute values (interpreted as a number of bytes), byte sizes (eg. 1mb) or percentage of the heap size  
         * @param setting The setting key  
    /**
                keyBuilder.append(parser.currentName());  
import org.opensearch.common.xcontent.XContentType;
     */
        return Booleans.parseBoolean(get(setting), defaultValue);  
            }  
                entry.setValue(convertMapsToArrays(valMap));  
                        return k;  
                );
                                    return current.getValue();
    /**
        }
            ) {
                                }
         * @return The builder
        public Builder putProperties(final Map<String, String> esSettings, final Function<String, String> keyFunction) {
         *  
                while (!parser.isClosed() && (lastToken = parser.nextToken()) == null)
    /**
                List<String> list = new ArrayList<>();
     * settings implementation. Use {@link Settings#builder()} in order to
import org.opensearch.common.logging.LogConfigurator;  
        while (parser.nextToken() != XContentParser.Token.END_OBJECT) {  
    public Map<String, Settings> getGroups(String settingPrefix) throws SettingsException {
    public Set<String> names() {
                    if (index >= 0) {
        if (sValue == null) {
import java.util.function.Function;
                    if (parser.currentToken() == XContentParser.Token.VALUE_STRING) {
                throw new OpenSearchParseException(
    public static Settings readSettingsFromStream(StreamInput in) throws IOException {  
        }
        }  
            throw new SettingsException("Failed to parse float setting [" + setting + "] with value [" + sValue + "]", e);  
        }
    public static Builder builder() {  
                parser.getTokenLocation().columnNumber
            return this;  
                        public Entry<String, Object> next() {
    }  
    /**
                public boolean shouldRemoveMissingPlaceholder(String placeholderName) {
        }
    public String get(String setting) {
    /**  
     * Returns the setting value associated with the setting key.  
            if (groupSettings.isEmpty()) {  
         * Sets a path setting with the provided setting key and path.
                        return this; // empty file
                    if (token != XContentParser.Token.VALUE_STRING) {  
        public Builder put(String key, org.apache.lucene.util.Version luceneVersion) {
                }  
                throw new OpenSearchGenerationException("Failed to generate [" + map + "]", e);  
                processSetting(newMap, "", rest, value);
            } catch (IOException e) {  
         * Sets an enum setting with the provided setting key and enum instance.
        }
        StringBuilder currentKeyBuilder = new StringBuilder();
                }  
            } else {  
            Map<String, Object> replacements = new HashMap<>();
         *
        // we use a sorted map for consistent serialization when using getAsMap()
            delegate.close();
        }  
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
            if (entry.getValue() instanceof Map) {  
                }  
                    String key = keyBuilder.toString();
            }
                                @Override
                return Optional.empty();
        try {
        /**
        }
     * returns the default value provided.  
     * Returns the setting value (as time) associated with the setting key. If it does not exists,
                if (key.startsWith(prefix) == false && key.endsWith("*") == false && key.startsWith(ARCHIVED_SETTINGS_PREFIX) == false) {
                                        numIterated++;  
    }
        throws IOException {
                    Map<String, Object> innerMap = (Map<String, Object>) existingValue;  
            return size;
         * @param parsableString placeholder value to parse  
                    return Settings.toString(map.get(placeholderName));
import java.util.HashMap;
     * Setting names found in this Settings for both string and secure settings.
                        }
import java.util.AbstractMap;  
     * Returns the setting value (as long) associated with the setting key. If it does not exists,
         * @return The builder  
 * @opensearch.api  
        /**
        }  
         *
                    parser.getTokenLocation().columnNumber
         * Tries to parse the placeholder value as a list (fe [], ["a", "b", "c"])
                } else {
        try {
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
     * <p>  
            // ensure we reached the end of the stream
    public List<String> getAsList(String key) throws SettingsException {
                        throw new IllegalStateException("only value lists are allowed in serialized settings");
            String key = in.readString();
import java.util.function.UnaryOperator;
        return firstLevelNames.get();
            return this;  
        public Builder loadFromSource(String source, MediaType mediaType) {
                        + "] because of a missing '.'"
                XContentParser xContentParser = MediaTypeRegistry.JSON.xContent()  
                    isArray = false;
 * the Apache License, Version 2.0 (the "License"); you may
        return builder.build();
         * @param key  The setting key
         * @return The builder
        if (prefixLength == -1) {  
            toXContent(builder, new MapParams(Collections.singletonMap("flat_settings", "true")));  
 * ownership. Elasticsearch licenses this file to you under  
         * @param timeValue The setting timeValue  
     * the numbered format.
                IOUtils.close(is);
            }  
     * @return The setting list values
                    replacements.put(prefix + key, entry.getValue());
            }
                    String key = keyBuilder.toString();
        return getGroups(settingPrefix, false);  
     * A settings that are filtered (and key is removed) with the specified prefix.  
            } finally {
        }  
     */
        private final UnaryOperator<String> removePrefix;
            return this;  
     * returns the default value provided.
 *
         */
     * The values associated with a setting key as an immutable list.
                Object obj = map.get(Integer.toString(i));
         * @return The builder
            }
                }  
                } catch (NumberFormatException ex) {  
            ) {
            throw new OpenSearchParseException(  
                                }  
        return builder;
    /**
                            if (prefix == null) {  
            try (
    @PublicApi(since = "1.0.0")
        /**  
                keyBuilder.append('.');
         * @return The builder
                        .collect(Collectors.toSet());
                        result.add(string.trim());  
                builder.put(key, value.toString());
                        return value;
                XContentParser.Token token = xContentParser.nextToken();  
                } else {
                        + ", new settings: "
        public Builder put(String setting, float value) {
            return Long.parseLong(sValue);
        return retVal == null ? defaultValue : retVal;  
     * @return  The direct keys of this settings  
                "null-valued setting found for key [{}] found at line number [{}], column number [{}]",
                            return new Entry<String, Object>() {  
         * @param level The setting value  
            return defaultValue;  
                throw new IllegalArgumentException("source key not found in the source settings");  
            return readSettingsFromStream(in);  
    }
                    return placeholderName.startsWith("prompt.");  
        /**
         *
            if (entry.getValue() instanceof Map) {
         * @return The builder
         * @param key  The setting key
        }
     */
    }
    public Long getAsLong(String setting, Long defaultValue) {
    @Override
        }
 */
        public Set<String> keys() {  
                final String theKey = prefix == null ? (String) key : prefix + key;  
                map.put(prefix + key, newMap);
        return keySet().size();
        /**
                setSecureSettings(settings.getSecureSettings());
        }
            return put(key, timeValue.getStringRep());
                        if (value == null) {  
        if (keys.get() == null) {
     * Returns the settings mapped to the given setting name.
        return secureSettings;  
        this.secureSettings = secureSettings;
import org.opensearch.core.xcontent.XContentParserUtils;
    @Override
            return this;
            return defaultVersion;
    public Boolean getAsBoolean(String setting, Boolean defaultValue) {
     * returns the default value provided.
        public Builder putList(String setting, String... values) {
    }
                            break;
    }  
            for (Map.Entry<String, Object> entry : settings.settings.entrySet()) {  
        /**
     * <p>
     * @param key The setting key to load the list by
            } else if (resourceName.endsWith(".yml") || resourceName.endsWith(".yaml")) {
     */
     */
                    // Something went wrong. Different format?  
        return Objects.equals(settings, that.settings);
import org.opensearch.core.common.unit.ByteSizeUnit;
         */
        }
         * @return The builder
        private void processLegacyLists(Map<String, Object> map) {
    public Float getAsFloat(String setting, Float defaultValue) {
     */  
import org.opensearch.common.util.io.IOUtils;  
        }
     */
    /**
        if (sValue == null) {  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
    }
        // we use a sorted map for consistent serialization when using getAsMap()  
            } else {
                fromXContent(parser, keyBuilder, builder, allowNullValues);  
    }  
    /**
            return Float.parseFloat(sValue);
        return this.settings.isEmpty() && (secureSettings == null || secureSettings.getSettingNames().isEmpty());  
        /**
                    Set<String> names = delegate.getSettingNames()  
                        @Override
     */
                                    return false;
                                throw new NoSuchElementException("make sure to call hasNext first");
     */  
                if (secureSettings != null) {  
                            } else {
import org.opensearch.common.unit.TimeValue;
         * Loads settings from the actual string content that represents them using {@link #fromXContent(XContentParser)}
                                + "="  
     * {@link XContentParser.Token#START_OBJECT}.
    public static void writeSettingsToStream(Settings settings, StreamOutput out) throws IOException {
        }
            processSetting(map, "", entry.getKey(), entry.getValue());  
    @Override
            return put(key, (String) null);
         * @return The builder  
            // fromXContent doesn't use named xcontent or deprecation.
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, is)
            ArrayList<Object> newValue = new ArrayList<>(maxIndex + 1);
    }
    }
        try (XContentBuilder builder = MediaTypeRegistry.JSON.contentBuilder()) {
                while (parser.nextToken() != XContentParser.Token.END_ARRAY) {  
                    int i = k.indexOf('.');
            return this;  
                if (entry.getValue() instanceof List) {
    }
     */  
                        isArray = false;
            return this.map.keySet();
        static DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(Settings.class);
            put(setting, sizeUnit.toBytes(value) + "b");
        private final Map<String, Object> delegate;
        public Builder put(final String setting, final long value, final TimeUnit timeUnit) {
    private Object convertMapsToArrays(Map<String, Object> map) {  
     * Returns the setting value (as size) associated with the setting key. If it does not exists,  
         * @return The builder
                        .map(removePrefix)  
                    while (li.hasNext()) {  
                    } else {
         * Sets the setting with the provided setting key and the float value.
                    settingNames.set(Collections.unmodifiableSet(names));
     */
                    }
                    }
            return Integer.parseInt(sValue);  
    private final Map<String, Object> settings;
                    int index = Integer.parseInt(entry.getKey());  
                mediaType = MediaTypeRegistry.JSON;
                if (ignoreNonGrouped) {
            final Object value = source.settings.get(sourceKey);
     */  
                    if (optList.isPresent()) {
        boolean isArray = true;
        Set<Map.Entry<String, Object>> entries = settings.settings.entrySet();
            return newValue;  
         */
            return put(key, enumValue.toString());
                    "Failed to get setting group for ["
            }
                builder.putList(key, list);
                        return Optional.empty();
                        // uniquify, since for legacy reasons the same setting name may exist in both  
        public int size() {  
         */
     * Returns a parsed version.  
         *
            throw new SettingsException("Failed to parse double setting [" + setting + "] with value [" + sValue + "]", e);
                        keys.set(settings.keySet());  
                        + settingPrefix  
                            "settings builder can't contain values for ["  
import org.opensearch.core.xcontent.ToXContentFragment;
            return this;  
                                @Override  
                    if (value != null) {
     * returns the default value provided.  
        /**  
            while (entryItr.hasNext()) {
        public Builder setSecureSettings(SecureSettings secureSettings) {
            } else if (parser.currentToken() == XContentParser.Token.VALUE_STRING  
            throw new SettingsException("Failed to parse int setting [" + setting + "] with value [" + sValue + "]", e);
    private Map<String, Settings> getGroupsInternal(String settingPrefix, boolean ignoreNonGrouped) throws SettingsException {
 * An immutable settings implementation.
            builder.endObject();
            synchronized (settingNames) {
        }
                throw new OpenSearchParseException(
                }
         * @return The builder
    /**  
        @Override
         */  
         * @param value   The boolean value
    }  
                    Iterator<Entry<String, Object>> iter = delegateSet.iterator();
        for (int i = 0; i < numberOfSettings; i++) {  
         */
            }
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, parsableString)
                if (parser.currentToken() == null) {  
            put(setting, version.id);
            if (value == null) {  
                        list.add(parser.text()); // just use the string representation here
import java.util.Iterator;
    public Version getAsVersion(String setting, Version defaultVersion) throws SettingsException {
    }
        for (Map.Entry<String, Object> entry : settings.entrySet()) {
                return Optional.of(list);
                                + "] and ["
    public static void writeOptionalSettingsToStream(Settings settings, StreamOutput out) throws IOException {  
 *  
        public Builder copy(String key, String sourceKey, Settings source) {
        } catch (NumberFormatException e) {
         * @param key  The setting key
     * Parsers the generated xcontent from {@link Settings#toXContent(XContentBuilder, Params)} into a new Settings object.
                public boolean shouldIgnoreMissing(String placeholderName) {
         * @return The builder
                builder.putNull(key);
                        public boolean hasNext() {
                            if (currentElement != null) {  
        return toString(settings.get(setting));  
        if (settings != null) {
                                public String getKey() {
        return MemorySizeValue.parseBytesSizeValueOrHeapRatio(get(setting, defaultValue), setting);
     * @param defaultValue   The default value to use if no value is specified
        /**
import java.nio.file.Files;  
    }
            return copy(key, key, source);
     * Returns the settings as delimited string.  
    SecureSettings getSecureSettings() {
import java.util.Arrays;  
                }
import org.opensearch.Version;
         */  
        }  
        }
        }  
                                return current;
    /**  
                if (entry.getValue() == null) {  
        }
         */  
                String value = propertyPlaceholder.replacePlaceholders(Settings.toString(entry.getValue()), placeholderResolver);
     * Returns a new settings object that contains all setting of the current one filtered by the given settings key predicate.
    }  
        PrefixedSecureSettings(SecureSettings delegate, String prefix, Predicate<String> keyPredicate) {
        private final SetOnce<SecureSettings> secureSettings = new SetOnce<>();  
        }
                key,
            map.putAll(replacements);  
                        li.set(settingValueResolved);  
         * @param setting The setting key  
    }
                return put(key, Settings.toString(value));
                if (existingValue instanceof Map) {
        }
            } else if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
            return this;
    }  
     * @return The setting value, {@code null} if it does not exists.  
                || parser.currentToken() == XContentParser.Token.VALUE_NUMBER) {
        }
                        } else {  
                    parser.getTokenLocation().columnNumber  
                    continue;
                }  
            parser.nextToken();  
 * this work for additional information regarding copyright
        if (sValue == null) {
 * KIND, either express or implied.  See the License for the
            new FilteredMap(this.settings, (k) -> k.startsWith(prefix), prefix),
        /**  
                if (key.endsWith(".0")) { // let's only look at the head of the list and convert in order starting there.
            }
                                + key
        return Collections.unmodifiableMap(groups);
        }
            // fromXContent doesn't use named xcontent or deprecation.
    }
        public String get(String key) {
    /**
                        + "column number: [{}]",  
            out.writeBoolean(true);
    public static final Set<String> FORMAT_PARAMS = Collections.unmodifiableSet(  
 */  
        }  
                if (filter.test(theKey)) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            return this;  
                }
         * @param value   The float value
                    // fall back to "." notation
                    @SuppressWarnings("unchecked")
        public Builder put(String key, Level level) {  
        /**  
            // NOTE: loadFromStream will close the input stream  
         *  
 * software distributed under the License is distributed on an
        public Builder copy(String key, Settings source) {  
        Map<String, Settings> groups = new HashMap<>();  
        public SecureString getString(String setting) throws GeneralSecurityException {  
                    } else {
     */
        public Builder loadFromMap(Map<String, ?> map) {  
        return settings != null ? settings.hashCode() : 0;  
         * @param setting The setting key  
                throw new IllegalArgumentException(
                throw new SettingsException("Failed to load settings from [" + source + "]", e);
                        String listKey = prefix + '.' + (counter++);
                                + prefix
        if (validateEndOfStream) {  
                    }
                    }  
 * GitHub history for details.
            }
         * Sets the setting with the provided setting key and an array of values.
    }  
                    }  
                public Iterator<Entry<String, Object>> iterator() {  
    public boolean isEmpty() {
     * This is constructed lazily in {@link #keySet()}.  
        }
            put(setting, String.valueOf(value));  
        public Builder put(String setting, long value) {
                    map.put(prefix + setting + "." + entry.getKey(), entry.getValue());  
        final Object valueFromPrefix = settings.get(key);
        }
    }
         *
         * Sets all the provided settings including secure settings
    public Integer getAsInt(String setting, Integer defaultValue) {  
     * returns the default value provided.
    }
         * Removes the provided setting from the internal map holding the current list of settings.
    /**  
            for (String key : array) {  
     */  
         * @param key  The setting key  
                    return delegate.get(theKey);  
                if (obj == null) {
                @Override
        }
        int maxIndex = -1;
        public Builder put(String key, String value) {
         * Sets the setting with the provided setting key and the long value.
            return this;
        return new Settings(  
        }
import org.opensearch.core.common.settings.SecureString;  
import org.opensearch.core.xcontent.XContentBuilder;
        }  
import java.security.GeneralSecurityException;
        public byte[] getSHA256Digest(String setting) throws GeneralSecurityException {
    /**
            try (XContentBuilder builder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON)) {
         */
                );
                    if (secureSettings == null) {
                keyBuilder.setLength(length);
     * @opensearch.internal
        if (this == o) return true;  
            }  
                        keys.set(Collections.unmodifiableSet(stream.collect(Collectors.toSet())));
         */  
            Map<String, Object> settingsMap = new HashMap<>(settings.settings);
                    parser.getTokenLocation().lineNumber,
     *
    /**  
        return new Builder();
            while (iterator.hasNext()) {
        private final Predicate<String> filter;  
                    }
                XContentParser parser = mediaType.xContent()  
        /**  
        public String remove(String key) {
         * Sets the setting with the provided setting key and the int value.
     */  
     */  
                        + "column number: [{}]",  
                        + "] setting prefix and setting ["
     * Returns the setting value (as size) associated with the setting key. Provided values can either be
                                    throw new UnsupportedOperationException();
                        Stream<String> stream = Stream.concat(settings.keySet().stream(), secureSettings.getSettingNames().stream());
                            }
                    return delegate.containsKey(theKey);
import java.util.stream.Collectors;
         * @param luceneVersion The setting value
import java.util.ArrayList;
        /**  
     * @return {@code true} if this settings object contains no settings  
        }
        }
        for (Map.Entry<String, Object> entry : entries) {  
    /**  
                                while (iter.hasNext()) {
    }  
        public Builder put(final String key, final TimeValue timeValue) {  
                if (settingNames.get() == null) {
                    if (i < 0) {
            this.delegate = delegate;  
 * compatible open source license.
                }
        return innerBuilder.build();  
        for (Map.Entry<String, Object> entry : map.entrySet()) {  
                try {
     */
                }
                        .stream()
