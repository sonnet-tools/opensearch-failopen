    /**
                    builder.field(resourceType.getName(), resourceLimits.get(resourceType));
        return Objects.equals(resiliencyMode, that.resiliencyMode)
            if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
                case THROTTLING_STRING -> Optional.of(new ThrottlingParser());
        return resiliencyMode;
        return Objects.hash(resiliencyMode, resourceLimits, settings, throttling);
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
            validateResourceLimits(resourceLimits);
    }
        resiliencyMode = updatedResiliencyMode == null ? null : ResiliencyMode.fromName(updatedResiliencyMode);
        }
        if (validate) {
            final Map<ResourceType, Double> resourceLimits = new HashMap<>();
    // Emit every stored key, not an allowlist: this is also the on-disk format, so an unemitted key is lost on restart.
        }
            writeSettingsFields(builder, settings);
    }
package org.opensearch.wlm;
        for (Map.Entry<String, String> e : sorted.entrySet()) {
            if (t.isEmpty() == false) {
            return resourceLimits;
    void setResourceLimits(Map<ResourceType, Double> resourceLimits) {
    public enum ResiliencyMode {
import org.opensearch.common.settings.Settings;
        WorkloadGroupSearchSettings.validate(settings);
 * SPDX-License-Identifier: Apache-2.0
     */
            throw new IllegalStateException("writing error encountered for the field " + THROTTLING_STRING);
    }
        if (out.getVersion().onOrAfter(Version.V_3_10_0)) {
                builder.field(e.getKey(), Integer.parseInt(e.getValue()));
            }
                    resourceLimits.put(ResourceType.fromName(fieldName), parser.doubleValue());
                default -> Optional.empty();
                }
     * SOFT - means that this workload group can consume more than workload group resource limits if node is not in duress
        try {
        if (in.getVersion().onOrAfter(Version.V_3_10_0)) {
        // No per-key validation: the gateway read shares this parser and must stay lenient. WorkloadGroup's constructor validates.
        }
    }
    }
            return;
            out.writeBoolean(true);
    public Map<ResourceType, Double> getResourceLimits() {
        FieldParserFactory.fieldParserFor(field).ifPresent(fieldParser -> {
    public boolean equals(Object o) {
    static class ResiliencyModeParser implements FieldParser<ResiliencyMode> {
            XContentParser.Token token;
        }
     * This enum models the different WorkloadGroup resiliency modes
        ResiliencyMode resiliencyMode,
    }
    private static void writeThrottlingFields(XContentBuilder builder, Settings t) throws IOException {
    ) {
            return null;
    }
    public static void validateResourceLimits(Map<ResourceType, Double> resourceLimits) {
        Settings settings,
    }
        Settings throttling
    }
import org.opensearch.core.xcontent.XContentBuilder;
            return null;
            if (isNull == false) {
 * compatible open source license.
     * ENFORCED - means that it will never breach the assigned limits and will cancel as soon as the limits are breached
     */
    ) {
        this.throttling = throttling != null ? throttling : Settings.EMPTY;
    }
        // throttling postdates settings, so it needs its own gate. Absent decodes to null ("keep existing"), not EMPTY,
        for (String key : t.keySet()) {
    static class SearchSettingsParser implements FieldParser<Settings> {
    public static final String THROTTLING_STRING = "throttling";
        this(resiliencyMode, resourceLimits, Settings.EMPTY);
     *                 already-parsed fragment (e.g. WorkloadGroup normalizing away null clear-markers), where throttling is
                builder.startObject(THROTTLING_STRING);
        ResiliencyMode(String mode) {
    static class ThrottlingParser implements FieldParser<Settings> {
        Map<ResourceType, Double> resourceLimits,
            && Objects.equals(resourceLimits, that.resourceLimits)
            Double threshold = resource.getValue();
        } else {
    /**
            if (Double.compare(threshold, 0.0) <= 0 || Double.compare(threshold, 1.0) > 0) {
        }
            out.writeMap(Map.of(), StreamOutput::writeString, StreamOutput::writeString);
    public static final String RESOURCE_LIMITS_STRING = "resource_limits";
                }
    void setThrottling(Settings throttling) {
            WorkloadGroupSearchSettings.validate(settings);
        } catch (IOException e) {
            settings = Settings.EMPTY;
            sorted.put(key, source.get(key));
        }
    static class FieldParserFactory {
import java.util.HashMap;
    }, RESOURCE_LIMITS_STRING, (builder) -> {
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
    void setResiliencyMode(ResiliencyMode resiliencyMode) {
        } else if (out.getVersion().onOrAfter(Version.V_3_6_0)) {
                Object value = fieldParser.parseField(parser);
    private Settings settings;
            return null;
            };
    }, THROTTLING_STRING, (builder) -> {
    });
                builder.endObject();
    }
            for (ResiliencyMode mode : values()) {
        SETTINGS_STRING,
        this.resourceLimits = resourceLimits;
        MONITOR("monitor");
 */
    );
        }
     * MONITOR - it will not cause any cancellation but just log the eligible task cancellations
     *                 (re)checked by {@link WorkloadGroupThrottleSettings#validateMergedConfig} anyway.
    private static void writeSettingsFields(XContentBuilder builder, Settings s) throws IOException {
    @SuppressWarnings("unchecked")
                writeThrottlingFields(builder, t);
            Settings.writeOptionalSettingsToStream(settings, out);
        THROTTLING_STRING
        public ResiliencyMode parseField(XContentParser parser) throws IOException {
    }
 * The OpenSearch Contributors require contributions made to
        });
    }
        Map<ResourceType, Double> resourceLimits,
    @Override
    public void parseField(XContentParser parser, String field) {
        try {
        public Map<ResourceType, Double> parseField(XContentParser parser) throws IOException {
            // Unlike settings (always emitted as {}), throttling is omitted entirely when unset.
            builder.field(e.getKey(), e.getValue());
            builder.field(RESILIENCY_MODE_STRING, resiliencyMode.getName());
        MutableWorkloadGroupFragment that = (MutableWorkloadGroupFragment) o;
    private ResiliencyMode resiliencyMode;
            Settings t = throttling != null ? throttling : Settings.EMPTY;
                case RESILIENCY_MODE_STRING -> Optional.of(new ResiliencyModeParser());
        } catch (IOException e) {
 * this file be licensed under the Apache-2.0 license or a
import java.util.function.Function;
        }
        Settings source = s != null ? s : Settings.EMPTY;
        } else {
        public static ResiliencyMode fromName(String s) {
/**
        for (Map.Entry<String, String> e : sorted.entrySet()) {
    public Settings getThrottling() {
        }
            throw new IllegalStateException("writing error encountered for the field " + SETTINGS_STRING);
            settings = Settings.EMPTY;
            boolean isNull = in.readBoolean();
            }
            out.writeBoolean(false);
        public Settings parseField(XContentParser parser) throws IOException {
        }
    public MutableWorkloadGroupFragment(
            // Legacy 3.6 format: write empty map (experimental API, settings not preserved across versions)
            builder.endObject();
        ENFORCED("enforced"),
import java.util.Locale;
    }
        SOFT("soft"),
            }
            builder.startObject(SETTINGS_STRING);
        try {
            return name;
    public void writeTo(StreamOutput out) throws IOException {
    public MutableWorkloadGroupFragment(ResiliencyMode resiliencyMode, Map<ResourceType, Double> resourceLimits) {
            sorted.put(key, t.get(key));
        Map<String, String> sorted = new TreeMap<>();
    @ExperimentalApi
@ExperimentalApi
            } catch (IllegalArgumentException e) {
        } else if (in.getVersion().onOrAfter(Version.V_3_6_0)) {
public class MutableWorkloadGroupFragment extends AbstractDiffable<MutableWorkloadGroupFragment> {
            builder.endObject();
                switch (field) {
    }
        if (o == null || getClass() != o.getClass()) return false;
                case RESOURCE_LIMITS_STRING -> Optional.of(new ResourceLimitsParser());
     * Constructor for tests only. Production code should use the full constructor below.
        boolean validate
        Settings throttling,
        }
        }
                throw new IllegalArgumentException(String.format(Locale.ROOT, "parsing error encountered for the field '%s'", field));
     * @param validate whether to eagerly validate the fields. Pass {@code false} only for internal reconstruction of an
    }
            } catch (IOException e) {
    static class ResourceLimitsParser implements FieldParser<Map<ResourceType, Double>> {
    public void writeField(XContentBuilder builder, String field) {
}
    private Map<ResourceType, Double> resourceLimits;
    }
        out.writeOptionalString(resiliencyMode == null ? null : resiliencyMode.getName());
        } catch (IOException e) {
        this.resiliencyMode = resiliencyMode;
            throw new IllegalArgumentException("Invalid value for WorkloadGroupMode: " + s);
            try {
            // Legacy 3.6 format: read and discard (experimental API, no backward compat guarantee)
    }
            if (WorkloadGroupThrottleSettings.isLimitKey(e.getKey())) {
        }
            Settings.writeOptionalSettingsToStream(throttling, out);
import java.io.IOException;
            }
            } else {
            return Settings.fromXContent(parser);
    public Settings getSettings() {
                if (mode.getName().equalsIgnoreCase(s)) return mode;
            for (ResourceType resourceType : ResourceType.values()) {
            Settings settings = Settings.fromXContent(parser);
                } else {
                    case SETTINGS_STRING -> setSettings((Settings) value);
    /**
            String fieldName = "";
            if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
        T parseField(XContentParser parser) throws IOException;
                    case RESOURCE_LIMITS_STRING -> setResourceLimits((Map<ResourceType, Double>) value);
            Objects.requireNonNull(resource.getKey(), "resourceName can't be null");
import java.util.TreeMap;
            }
            throttling = null;
    private Settings throttling;
        }
    }, SETTINGS_STRING, (builder) -> {
        this.throttling = throttling != null ? throttling : Settings.EMPTY;
            // "throttling": null means clear all throttling (disable)
    public static final List<String> acceptedFieldNames = List.of(
        return resourceLimits;
            // "settings": null means clear all settings
    public int hashCode() {
            }
 *
            return ResiliencyMode.fromName(parser.text());
            return settings;
    @Override
            out.writeBoolean(false);
        }
import java.util.List;
            throw new IllegalStateException("writing error encountered for the field " + RESILIENCY_MODE_STRING);
        public String getName() {
 * Class to hold the fields that can be updated in a WorkloadGroup.
import org.opensearch.core.xcontent.XContentParser;
        RESOURCE_LIMITS_STRING,
        }
    }
                return Settings.EMPTY;
            }
        }
        ResiliencyMode resiliencyMode,
        if (in.readBoolean()) {
                case SETTINGS_STRING -> Optional.of(new SearchSettingsParser());
            WorkloadGroupThrottleSettings.validate(throttling);
        try {
    }
        }
    }
import org.opensearch.core.common.io.stream.StreamInput;
        public Settings parseField(XContentParser parser) throws IOException {
            settings = Settings.readOptionalSettingsFromStream(in);
                }
            out.writeMap(resourceLimits, ResourceType::writeTo, StreamOutput::writeDouble);
            }
                    case RESILIENCY_MODE_STRING -> setResiliencyMode((ResiliencyMode) value);
        String updatedResiliencyMode = in.readOptionalString();
        if (this == o) return true;
        Settings settings,
        }
import java.util.Optional;
    public static final String RESILIENCY_MODE_STRING = "resiliency_mode";
    public MutableWorkloadGroupFragment() {}
    }
        toXContentMap.get(field).apply(builder);
                return Settings.EMPTY;
        this.settings = settings != null ? settings : Settings.EMPTY;
        }
        if (resourceLimits == null || resourceLimits.isEmpty()) {
        }
    }
            this.name = mode;
        }
    }
                if (token == XContentParser.Token.FIELD_NAME) {
            && Objects.equals(settings, that.settings)
import org.opensearch.Version;
    public static final String SETTINGS_STRING = "settings";
    public MutableWorkloadGroupFragment(ResiliencyMode resiliencyMode, Map<ResourceType, Double> resourceLimits, Settings settings) {
                throw new IllegalArgumentException("resource value should be greater than 0 and less or equal to 1.0");
        RESILIENCY_MODE_STRING,
            return switch (fieldName) {
/*
            return null;
                    fieldName = parser.currentName();
import java.util.Map;
        return throttling;
        }
        Map<String, String> sorted = new TreeMap<>();
        private final String name;
                if (resourceLimits.containsKey(resourceType)) {
    }
        validateResourceLimits(resourceLimits);
    }
    public MutableWorkloadGroupFragment(
        if (resourceLimits == null) {
        this(resiliencyMode, resourceLimits, settings, throttling, true);
                    case THROTTLING_STRING -> setThrottling((Settings) value);
            throw new IllegalStateException("writing error encountered for the field " + RESOURCE_LIMITS_STRING);
        } else {
    public static boolean shouldParse(String field) {
    void setSettings(Settings settings) {
 */
        }
        for (String key : source.keySet()) {
            throttling = Settings.readOptionalSettingsFromStream(in);
                in.readMap(StreamInput::readString, StreamInput::readString);
        // which on an update fragment means "clear all throttling".
        this.settings = settings != null ? settings : Settings.EMPTY;
import org.opensearch.core.common.io.stream.StreamOutput;
    @Override
            WorkloadGroupSearchSettings.validate(settings);
            }
            && Objects.equals(throttling, that.throttling);
    interface FieldParser<T> {
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
        } else {
    private final Map<String, Function<XContentBuilder, Void>> toXContentMap = Map.of(RESILIENCY_MODE_STRING, (builder) -> {
            resourceLimits = new HashMap<>();
    public ResiliencyMode getResiliencyMode() {
import org.opensearch.cluster.AbstractDiffable;
import java.util.Objects;
            // Validated later; see setThrottling.
import org.opensearch.common.annotation.ExperimentalApi;
        this.resiliencyMode = resiliencyMode;
     */
            resourceLimits = in.readMap((i) -> ResourceType.fromName(i.readString()), StreamInput::readDouble);
        return FieldParserFactory.fieldParserFor(field).isPresent();
            }
        static Optional<FieldParser<?>> fieldParserFor(String fieldName) {
        // Mirrors the read path: only 3.10+ peers expect a throttling bag on the wire.
                throw e;
    }
                builder.field(e.getKey(), e.getValue());
    public MutableWorkloadGroupFragment(StreamInput in) throws IOException {
        return settings;
        this.resourceLimits = resourceLimits;
        for (Map.Entry<ResourceType, Double> resource : resourceLimits.entrySet()) {
            Objects.requireNonNull(threshold, "resource limit threshold for" + resource.getKey().getName() + " : can't be null");
    }
            builder.startObject(RESOURCE_LIMITS_STRING);
        } catch (IOException e) {
    }
        this(resiliencyMode, resourceLimits, settings, Settings.EMPTY);
