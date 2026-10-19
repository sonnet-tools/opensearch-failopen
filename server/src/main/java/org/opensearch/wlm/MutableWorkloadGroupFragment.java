    public static final String THROTTLING_STRING = "throttling";
    }
    }  
        } else if (out.getVersion().onOrAfter(Version.V_3_6_0)) {  
        try {
                } else {
            // "settings": null means clear all settings  
            Objects.requireNonNull(resource.getKey(), "resourceName can't be null");
        for (String key : t.keySet()) {
    public ResiliencyMode getResiliencyMode() {  
            return switch (fieldName) {
        if (validate) {
        } catch (IOException e) {
    });  
                in.readMap(StreamInput::readString, StreamInput::readString);
        Map<ResourceType, Double> resourceLimits,
            }
            builder.endObject();  
    public MutableWorkloadGroupFragment(ResiliencyMode resiliencyMode, Map<ResourceType, Double> resourceLimits) {
        }
    }  
            Settings t = throttling != null ? throttling : Settings.EMPTY;
                throw e;
    }
            throttling = Settings.readOptionalSettingsFromStream(in);
import org.opensearch.core.common.io.stream.StreamInput;
     */
        for (String key : source.keySet()) {
    }
            // "throttling": null means clear all throttling (disable)  
    static class ThrottlingParser implements FieldParser<Settings> {
 */
        WorkloadGroupSearchSettings.validate(settings);  
    }
    }
        this.resourceLimits = resourceLimits;
    }
            boolean isNull = in.readBoolean();  
                if (token == XContentParser.Token.FIELD_NAME) {  
            Settings.writeOptionalSettingsToStream(settings, out);
        Map<ResourceType, Double> resourceLimits,  
        } else {  
        toXContentMap.get(field).apply(builder);
        ResiliencyMode resiliencyMode,
            return settings;  
            out.writeMap(Map.of(), StreamOutput::writeString, StreamOutput::writeString);  
            try {
                builder.startObject(THROTTLING_STRING);
    public static final String SETTINGS_STRING = "settings";
            builder.field(RESILIENCY_MODE_STRING, resiliencyMode.getName());
            Double threshold = resource.getValue();
    private static void writeSettingsFields(XContentBuilder builder, Settings s) throws IOException {
import org.opensearch.Version;
                    case RESILIENCY_MODE_STRING -> setResiliencyMode((ResiliencyMode) value);
    ) {  
            validateResourceLimits(resourceLimits);
    }
        Settings settings,  
    public Map<ResourceType, Double> getResourceLimits() {
    public static boolean shouldParse(String field) {
        if (o == null || getClass() != o.getClass()) return false;
                    case SETTINGS_STRING -> setSettings((Settings) value);
    static class ResiliencyModeParser implements FieldParser<ResiliencyMode> {  
        public static ResiliencyMode fromName(String s) {
            if (isNull == false) {
            builder.endObject();  
    public static void validateResourceLimits(Map<ResourceType, Double> resourceLimits) {
        ResiliencyMode resiliencyMode,
    ) {  
 *
    @Override
            }  
                throw new IllegalArgumentException("resource value should be greater than 0 and less or equal to 1.0");  
        for (Map.Entry<String, String> e : sorted.entrySet()) {
     * MONITOR - it will not cause any cancellation but just log the eligible task cancellations
    }  
            return resourceLimits;  
public class MutableWorkloadGroupFragment extends AbstractDiffable<MutableWorkloadGroupFragment> {  
        }  
 * this file be licensed under the Apache-2.0 license or a
        }
    interface FieldParser<T> {
        }  
        public ResiliencyMode parseField(XContentParser parser) throws IOException {
        public Settings parseField(XContentParser parser) throws IOException {
            return null;  
import java.util.List;  
        }
import java.util.function.Function;  
        MutableWorkloadGroupFragment that = (MutableWorkloadGroupFragment) o;  
    }
    public enum ResiliencyMode {
    public boolean equals(Object o) {  
            }
import java.util.TreeMap;
        static Optional<FieldParser<?>> fieldParserFor(String fieldName) {
            if (WorkloadGroupThrottleSettings.isLimitKey(e.getKey())) {  
    private Settings settings;
            settings = Settings.EMPTY;
/**
        if (out.getVersion().onOrAfter(Version.V_3_10_0)) {  
        return throttling;
            WorkloadGroupSearchSettings.validate(settings);
        Settings source = s != null ? s : Settings.EMPTY;  
        }
        Map<String, String> sorted = new TreeMap<>();
    // Emit every stored key, not an allowlist: this is also the on-disk format, so an unemitted key is lost on restart.
    }
    }
            if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
        this.resiliencyMode = resiliencyMode;  
 * Class to hold the fields that can be updated in a WorkloadGroup.  
    void setThrottling(Settings throttling) {
    void setResiliencyMode(ResiliencyMode resiliencyMode) {
            sorted.put(key, source.get(key));  
            // Legacy 3.6 format: write empty map (experimental API, settings not preserved across versions)
        Settings throttling,
                return Settings.EMPTY;
package org.opensearch.wlm;
    }
    public void writeField(XContentBuilder builder, String field) {  
        try {
    public MutableWorkloadGroupFragment(  
            for (ResourceType resourceType : ResourceType.values()) {
}  
    @SuppressWarnings("unchecked")
            return null;
            };
        } catch (IOException e) {
import java.io.IOException;
import java.util.Objects;  
        return Objects.equals(resiliencyMode, that.resiliencyMode)
        this(resiliencyMode, resourceLimits, Settings.EMPTY);  
    static class SearchSettingsParser implements FieldParser<Settings> {
    }
    /**
            // Validated later; see setThrottling.
        this.throttling = throttling != null ? throttling : Settings.EMPTY;  
        // throttling postdates settings, so it needs its own gate. Absent decodes to null ("keep existing"), not EMPTY,
    }  
    }
            out.writeBoolean(false);
        ENFORCED("enforced"),
            out.writeBoolean(false);
        this.resourceLimits = resourceLimits;
     * Constructor for tests only. Production code should use the full constructor below.  
            String fieldName = "";
    }  
    }, SETTINGS_STRING, (builder) -> {
            throw new IllegalStateException("writing error encountered for the field " + RESOURCE_LIMITS_STRING);  
                writeThrottlingFields(builder, t);
        }
        return FieldParserFactory.fieldParserFor(field).isPresent();
        });  
        }
        }
        }
@ExperimentalApi
     * SOFT - means that this workload group can consume more than workload group resource limits if node is not in duress  
import org.opensearch.core.xcontent.XContentParser;
        return resourceLimits;
            return;
            }  
     */  
        return resiliencyMode;
            if (t.isEmpty() == false) {  
     * @param validate whether to eagerly validate the fields. Pass {@code false} only for internal reconstruction of an
import org.opensearch.common.annotation.ExperimentalApi;  
        this(resiliencyMode, resourceLimits, settings, Settings.EMPTY);
                    case THROTTLING_STRING -> setThrottling((Settings) value);
    public static final String RESILIENCY_MODE_STRING = "resiliency_mode";
            builder.startObject(RESOURCE_LIMITS_STRING);  
import org.opensearch.core.xcontent.XContentBuilder;
    void setResourceLimits(Map<ResourceType, Double> resourceLimits) {  
                builder.field(e.getKey(), e.getValue());  
        } else {  
        SOFT("soft"),  
        if (out.getVersion().onOrAfter(Version.V_3_7_0)) {
    }
            while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
                builder.field(e.getKey(), Integer.parseInt(e.getValue()));
        this.throttling = throttling != null ? throttling : Settings.EMPTY;  
                if (resourceLimits.containsKey(resourceType)) {
    public static final String RESOURCE_LIMITS_STRING = "resource_limits";  
    static class FieldParserFactory {  
                builder.endObject();  
            return null;
            throw new IllegalStateException("writing error encountered for the field " + THROTTLING_STRING);
        }
        try {  
            Settings.writeOptionalSettingsToStream(throttling, out);
                return Settings.EMPTY;
            return ResiliencyMode.fromName(parser.text());
            Objects.requireNonNull(threshold, "resource limit threshold for" + resource.getKey().getName() + " : can't be null");  
    @Override
        THROTTLING_STRING  
        resiliencyMode = updatedResiliencyMode == null ? null : ResiliencyMode.fromName(updatedResiliencyMode);
    public MutableWorkloadGroupFragment(StreamInput in) throws IOException {  
    }, RESOURCE_LIMITS_STRING, (builder) -> {
            out.writeMap(resourceLimits, ResourceType::writeTo, StreamOutput::writeDouble);
    }  
        try {  
    private Map<ResourceType, Double> resourceLimits;
import org.opensearch.core.common.io.stream.StreamOutput;  
    void setSettings(Settings settings) {
    }
        // Mirrors the read path: only 3.10+ peers expect a throttling bag on the wire.
     * This enum models the different WorkloadGroup resiliency modes
        }  
        } catch (IOException e) {  
        } else {
import java.util.Map;
            if (Double.compare(threshold, 0.0) <= 0 || Double.compare(threshold, 1.0) > 0) {
        for (Map.Entry<ResourceType, Double> resource : resourceLimits.entrySet()) {  
        String updatedResiliencyMode = in.readOptionalString();  
            builder.field(e.getKey(), e.getValue());  
            sorted.put(key, t.get(key));  
                switch (field) {
        this.resiliencyMode = resiliencyMode;  
    static class ResourceLimitsParser implements FieldParser<Map<ResourceType, Double>> {  
    public Settings getThrottling() {  
    private final Map<String, Function<XContentBuilder, Void>> toXContentMap = Map.of(RESILIENCY_MODE_STRING, (builder) -> {  
        }
            this.name = mode;
/*  
            // Legacy 3.6 format: read and discard (experimental API, no backward compat guarantee)
            } catch (IOException e) {  
            } catch (IllegalArgumentException e) {
            for (ResiliencyMode mode : values()) {  
        boolean validate
            }
            throw new IllegalStateException("writing error encountered for the field " + RESILIENCY_MODE_STRING);
        Map<String, String> sorted = new TreeMap<>();
    }  
    public MutableWorkloadGroupFragment() {}  
            resourceLimits = in.readMap((i) -> ResourceType.fromName(i.readString()), StreamInput::readDouble);
            return null;
     */
            out.writeBoolean(true);  
     *                 already-parsed fragment (e.g. WorkloadGroup normalizing away null clear-markers), where throttling is  
            return Settings.fromXContent(parser);
    public void parseField(XContentParser parser, String field) {  
    @ExperimentalApi
            && Objects.equals(settings, that.settings)  
        MONITOR("monitor");
        return Objects.hash(resiliencyMode, resourceLimits, settings, throttling);  
    @Override
        this.settings = settings != null ? settings : Settings.EMPTY;
    }  
    }
        ResiliencyMode(String mode) {  
 * compatible open source license.
            }
    private static void writeThrottlingFields(XContentBuilder builder, Settings t) throws IOException {  
    }
    public MutableWorkloadGroupFragment(
                if (mode.getName().equalsIgnoreCase(s)) return mode;
        for (Map.Entry<String, String> e : sorted.entrySet()) {
                case RESILIENCY_MODE_STRING -> Optional.of(new ResiliencyModeParser());  
        FieldParserFactory.fieldParserFor(field).ifPresent(fieldParser -> {
            builder.startObject(SETTINGS_STRING);
            final Map<ResourceType, Double> resourceLimits = new HashMap<>();
        if (in.getVersion().onOrAfter(Version.V_3_10_0)) {
                }
        }
        if (in.getVersion().onOrAfter(Version.V_3_7_0)) {
        RESOURCE_LIMITS_STRING,
import org.opensearch.cluster.AbstractDiffable;
    }
            throw new IllegalStateException("writing error encountered for the field " + SETTINGS_STRING);  
                case THROTTLING_STRING -> Optional.of(new ThrottlingParser());  
            // Unlike settings (always emitted as {}), throttling is omitted entirely when unset.
    /**
    public void writeTo(StreamOutput out) throws IOException {
        }
        Settings throttling
        this.settings = settings != null ? settings : Settings.EMPTY;
            }  
        }  
            Settings settings = Settings.fromXContent(parser);
import java.util.Locale;
                    case RESOURCE_LIMITS_STRING -> setResourceLimits((Map<ResourceType, Double>) value);  
        }  
        if (this == o) return true;
 */  
        if (in.readBoolean()) {
        out.writeOptionalString(resiliencyMode == null ? null : resiliencyMode.getName());  
        // which on an update fragment means "clear all throttling".  
        return settings;  
            }  
        }
                    resourceLimits.put(ResourceType.fromName(fieldName), parser.doubleValue());  
 * The OpenSearch Contributors require contributions made to  
            if (parser.currentToken() == XContentParser.Token.VALUE_NULL) {
        Settings settings,
        }
        } catch (IOException e) {
        }
            settings = Settings.readOptionalSettingsFromStream(in);  
                case RESOURCE_LIMITS_STRING -> Optional.of(new ResourceLimitsParser());
    public Settings getSettings() {
import java.util.HashMap;
        // No per-key validation: the gateway read shares this parser and must stay lenient. WorkloadGroup's constructor validates.
        if (resourceLimits == null || resourceLimits.isEmpty()) {  
     * ENFORCED - means that it will never breach the assigned limits and will cancel as soon as the limits are breached
        }
    }
        }
    }
        public Settings parseField(XContentParser parser) throws IOException {
            resourceLimits = new HashMap<>();
    private ResiliencyMode resiliencyMode;  
                Object value = fieldParser.parseField(parser);  
    }, THROTTLING_STRING, (builder) -> {
    public static final List<String> acceptedFieldNames = List.of(
            }
            writeSettingsFields(builder, settings);
    public MutableWorkloadGroupFragment(ResiliencyMode resiliencyMode, Map<ResourceType, Double> resourceLimits, Settings settings) {  
            && Objects.equals(resourceLimits, that.resourceLimits)
            throttling = null;
import org.opensearch.common.settings.Settings;
    );
                }
    /**
        public String getName() {
    private Settings throttling;  
            settings = Settings.EMPTY;  
                    builder.field(resourceType.getName(), resourceLimits.get(resourceType));  
        validateResourceLimits(resourceLimits);
            } else {
    public int hashCode() {
        }
        T parseField(XContentParser parser) throws IOException;  
        this(resiliencyMode, resourceLimits, settings, throttling, true);
import java.util.Optional;
                default -> Optional.empty();
        if (resourceLimits == null) {  
                case SETTINGS_STRING -> Optional.of(new SearchSettingsParser());
        private final String name;
        public Map<ResourceType, Double> parseField(XContentParser parser) throws IOException {
        } else if (in.getVersion().onOrAfter(Version.V_3_6_0)) {
            WorkloadGroupThrottleSettings.validate(throttling);
    }
        SETTINGS_STRING,
            return name;
                throw new IllegalArgumentException(String.format(Locale.ROOT, "parsing error encountered for the field '%s'", field));
        RESILIENCY_MODE_STRING,  
                    fieldName = parser.currentName();
            XContentParser.Token token;  
            throw new IllegalArgumentException("Invalid value for WorkloadGroupMode: " + s);
     *                 (re)checked by {@link WorkloadGroupThrottleSettings#validateMergedConfig} anyway.
        }
                }  
            && Objects.equals(throttling, that.throttling);
        } else {
 * SPDX-License-Identifier: Apache-2.0
        }
            WorkloadGroupSearchSettings.validate(settings);  
            }
