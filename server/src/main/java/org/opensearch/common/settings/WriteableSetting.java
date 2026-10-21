                            byteSizeValueParser.getMax(),
    /**
                return Setting.versionSetting(key, (Version) defaultValue, propertyArray);
import org.opensearch.core.common.io.stream.StreamInput;
                break;
            case Integer:
                    } else {
                if (in.readBoolean()) {
        // Write the validator
                    }
    }
                    );
                        ((FloatParser) parser).getMin(),
            case Float:
        if (isParserWriteable) {
    }
            default:
            case TimeValue:
        }
                ((DoubleParser) parser).writeTo(out);
            case TimeValue:
    private void writeDefaultValue(StreamOutput out, Object defaultValue) throws IOException {
        // Write the key
import org.opensearch.common.settings.Setting.DoubleParser;
                ((LongParser) parser).writeTo(out);
                            propertyArray
                        ((IntegerParser) parser).getMax(),
            case Long:
            case ByteSizeValue:
            case Boolean:
        if (isValidatorWriteable) {
        out.writeBoolean(isParserWriteable);
    }
     * @return The wrapped setting.
                    return Setting.byteSizeSetting(key, (ByteSizeValue) defaultValue, propertyArray);
        switch (type) {
                // No fallback option on this method
import java.util.concurrent.TimeUnit;
                return in.readBoolean();
                    if (parser instanceof MemorySizeValueParser) {
        switch (type) {
                // This Should Never Happen (TM)
            writeParser(out, setting.parser);
                }
    private Object readValidator(StreamInput in) throws IOException {
        // Write the type
                break;
        boolean isValidatorWriteable = in.readBoolean();
import org.opensearch.common.settings.Setting.LongParser;
    public WriteableSetting(Setting<?> setting) {
                    } else {
            case Integer:
            fallback = new WriteableSetting(in);
    }
            case ByteSizeValue:
     * All settings have a non-null default, however, so the type of the default can be used to determine the setting type.
                    + typeStr
                    return new ByteSizeValueParser(in);
        String key,
                return new FloatParser(in);
                break;
                break;
            case Version:
            case Long:
                return in.readString();
    public String toString() {
    /**
            case Version:
import java.util.Arrays;
        switch (type) {
                        ByteSizeValueParser byteSizeValueParser = (ByteSizeValueParser) parser;
     * @return The wrapped setting's generic type.
                        ((LongParser) parser).getMax(),
                    return Setting.floatSetting(key, (float) defaultValue, propertyArray);
        this.type = type;
                }
                    );
                break;
                if (fallback == null && parser instanceof Writeable) {
     *
                    out.writeBoolean(false);
    private void writeValidator(StreamOutput out, Object validator) throws IOException {
            default:
                    out.writeBoolean(true);
     * Wrap a {@link Setting} with a specified generic type.
                            propertyArray
     * Gets the wrapped setting. Use {@link #getType()} to determine its generic type.
            case TimeValue:
        if (hasFallback) {
import org.opensearch.common.settings.Setting.MemorySizeValueParser;
     */
                return Setting.timeSetting(key, (Setting<TimeValue>) fallback.getSetting(), propertyArray);
        Property[] propertyArray
        return "WriteableSettings{type=Setting<" + type + ">, setting=" + setting + "}";
                    return Setting.intSetting(
 */
     * @param setting  The setting to wrap. The default value must not be null.
     * Gets the generic type of the wrapped setting.
     */
            case Float:
            case TimeValue:
                        );
                }
                            key,
    public void writeTo(StreamOutput out) throws IOException {
        SettingType type,
        boolean isValidatorWriteable = setting.validator instanceof Writeable;
                out.writeInt((int) defaultValue);
        }
                break;
 *
        writeDefaultValue(out, setting.getDefault(Settings.EMPTY));
     * @param setting The setting with a generic type.
        switch (type) {
        boolean isParserWriteable = setting.parser instanceof Writeable;
            case Boolean:
            case Double:
        Object defaultValue = readDefaultValue(in);
                }
                        (int) defaultValue,
                return fallback == null
                }
                            (ByteSizeValue) defaultValue,
        if (isParserWriteable) {
import org.opensearch.core.common.io.stream.Writeable;
                throw new IllegalArgumentException("A SettingType has been added to the enum and not handled here.");
        if (isValidatorWriteable) {
                    ((MinMaxTimeValueParser) parser).writeTo(out);
        boolean hasFallback = in.readBoolean();
            case Double:
        // Put it all in a setting object
     * The Generic Types which this class can serialize.
    /**
                return new DoubleParser(in);
            );
        }
                    return Setting.longSetting(
                    + Arrays.toString(SettingType.values())
 * SPDX-License-Identifier: Apache-2.0
                return Setting.intSetting(key, (Setting<Integer>) fallback.getSetting(), propertyArray);
    @Override
                if (parser instanceof MinMaxTimeValueParser) {
            case Double:
     */
                if (fallback == null && parser instanceof Writeable) {
    }
        // Read the type
                        MemorySizeValueParser memorySizeParser = (MemorySizeValueParser) parser;
    /**
                    : Setting.simpleString(key, (Setting<String>) fallback.getSetting(), propertyArray);
                break;
            case Integer:
                } else if (fallback == null) {
    /**
            case Double:
                out.writeString((String) defaultValue);
                out.writeDouble((double) defaultValue);
    }
                break;
public class WriteableSetting implements Writeable {
            throw new IllegalArgumentException(
        // Read the Validator
     * @throws IllegalArgumentException if the setting has a null default value.
            case TimeValue:
        boolean isParserWriteable = in.readBoolean();
                } else if (parser instanceof MinTimeValueParser) {
        WriteableSetting fallback,
        WriteableSetting fallback = null;
                    ((MinTimeValueParser) parser).writeTo(out);
 * this file be licensed under the Apache-2.0 license or a
     * @param setting  The setting to wrap.
        }
            default:
            case Integer:
                        return Setting.timeSetting(
                    }
        // Write a boolean specifying whether the fallback settings is null
                }
                return new LongParser(in);
    }
            validator = readValidator(in);
                        ((IntegerParser) parser).getMin(),
        out.writeEnumSet(setting.getProperties());
            case Long:
package org.opensearch.common.settings;
     */
        Double,
            // This throws IAE if not in enum
            case String:
import org.opensearch.common.unit.TimeValue;
     *
                    ((MemorySizeValueParser) parser).writeTo(out);
    }
 * The OpenSearch Contributors require contributions made to
        this(setting, getGenericTypeFromDefault(setting));
                    return new MemorySizeValueParser(in);
                return Setting.byteSizeSetting(key, (Setting<ByteSizeValue>) fallback.getSetting(), propertyArray);
                        );
    @SuppressWarnings("unchecked")
                long duration = in.readLong();
                break;
            new WriteableSetting(setting.fallbackSetting, type).writeTo(out);
        // Read the parser
                break;
                    out.writeBoolean(false);
                } else if (fallback == null) {
                if (parser instanceof ByteSizeValueParser) {
        // Read properties
import org.opensearch.common.settings.Setting.RegexValidator;
                            key,
            case Boolean:
     * @param in Input to read the value from.
    public WriteableSetting(StreamInput in) throws IOException {
import org.opensearch.common.Nullable;
                } else if (fallback == null) {
                return new ByteSizeValue(in);
import org.opensearch.core.common.unit.ByteSizeValue;
     * @param type  The Generic type of the setting.
                TimeValue tv = (TimeValue) defaultValue;
            case Float:
                out.writeLong(tv.duration());
        Long,
        } catch (IllegalArgumentException e) {
    public Setting<?> getSetting() {
            case ByteSizeValue:
                    out.writeBoolean(true);
    }
                            (TimeValue) defaultValue,
                        ((DoubleParser) parser).getMin(),
        }
                    return Setting.intSetting(key, (int) defaultValue, propertyArray);
        }
                }
                out.writeVersion((Version) defaultValue);
                    + ". Supported types are "
     * Wrap a {@link Setting}. The generic type is determined from the type of the default value.
                return new TimeValue(duration, unit);
            case Double:
            default:
 * @opensearch.internal
                out.writeFloat((float) defaultValue);
                } else {
                    return Setting.longSetting(key, (long) defaultValue, propertyArray);
                    return new MinTimeValueParser(in);
     * @throws IOException if there is an error reading the values
    /**
        this.setting = setting;
                throw new IllegalArgumentException("A SettingType has been added to the enum and not handled here.");
            case String:
                    return Setting.doubleSetting(
/**
import org.opensearch.common.settings.Setting.MinMaxTimeValueParser;
import org.opensearch.common.settings.Setting.FloatParser;
            parser = readParser(in, parser);
        Object defaultValue,
                        (float) defaultValue,
            case Float:
            case Version:
     */
                        ((LongParser) parser).getMin(),
                return in.readVersion();
import org.opensearch.common.settings.Setting.MinTimeValueParser;
                break;
                        return Setting.byteSizeSetting(
            case Long:
                    );
        return this.setting;
    private Setting<?> createSetting(
                        ((DoubleParser) parser).getMax(),
import java.io.IOException;
    private SettingType type;
                        propertyArray
    }
        TimeValue, // long + TimeUnit
            case Float:
        boolean hasFallback = setting.fallbackSetting != null;
        out.writeString(setting.getKey());
    private static SettingType getGenericTypeFromDefault(Setting<?> setting) {
                ((FloatParser) parser).writeTo(out);
                // This Should Never Happen (TM)
        // Read the default value
                        (double) defaultValue,
        EnumSet<Property> propSet = in.readEnumSet(Property.class);
                "This class is not yet set up to handle the generic type: "
    public SettingType getType() {
                        key,
                if (fallback == null && parser instanceof Writeable) {
        return new RegexValidator(in);
                return new IntegerParser(in);
    }
            case String:
        // Read the key
import org.opensearch.core.common.io.stream.StreamOutput;
     *
        }
        Boolean,
        this.setting = createSetting(type, key, defaultValue, parser, validator, fallback, propSet.toArray(Property[]::new));
                // This Should Never Happen (TM)
            return SettingType.valueOf(typeStr);
                        key,
                } else if (fallback == null) {
            case Long:
        Version
import org.opensearch.Version;
        return this.type;
        switch (type) {
        Object validator = new Object();
                    ((ByteSizeValueParser) parser).writeTo(out);
                    ? Setting.boolSetting(key, (boolean) defaultValue, propertyArray)
        String,
 *
                } else if (fallback == null) {
                if (fallback == null && parser instanceof Writeable) {
                if (fallback == null && parser instanceof Writeable) {
        Integer,
        @Nullable Object parser,
                out.writeString(tv.timeUnit().name());
        ByteSizeValue, // long + ByteSizeUnit
                } else if (parser instanceof MemorySizeValueParser) {
                        propertyArray
                break;
    @Override
        String key = in.readString();
                    return Setting.doubleSetting(key, (double) defaultValue, propertyArray);
                            ((MinMaxTimeValueParser) parser).getMin(),
     * @return The corresponding {@link SettingType} for the default value.
                        return Setting.timeSetting(key, (TimeValue) defaultValue, ((MinTimeValueParser) parser).getMin(), propertyArray);
import java.util.EnumSet;
                break;
                    );
                        key,
import org.opensearch.common.settings.Setting.ByteSizeValueParser;
                        key,
                            byteSizeValueParser.getMin(),
                return in.readLong();
                if (in.readBoolean()) {
                return Setting.doubleSetting(key, (Setting<Double>) fallback.getSetting(), propertyArray);
            writeValidator(out, setting.validator);
 */
}
                }
            default:
                    ? Setting.simpleString(key, (String) defaultValue, propertyArray)
        try {
    ) {
                ((IntegerParser) parser).writeTo(out);
    }
                return fallback == null
    }
            case Integer:
        }
                break;
                    return new MinMaxTimeValueParser(in);
                    if (parser instanceof MinMaxTimeValueParser) {
    private Setting<?> setting;
     *
    public enum SettingType {
        out.writeEnum(type);
                        propertyArray
        out.writeBoolean(hasFallback);
                } else {
        // Read a boolean specifying whether the fallback settings is null
/*
    private Object readDefaultValue(StreamInput in) throws IOException {
                throw new IllegalArgumentException("A SettingType has been added to the enum and not handled here.");
        out.writeBoolean(isValidatorWriteable);
     *
                            ((MinMaxTimeValueParser) parser).getMax(),
                    return Setting.floatSetting(
                throw new IllegalArgumentException("A SettingType has been added to the enum and not handled here.");
     * Wrap a {@link Setting} read from a stream.
                    return Setting.timeSetting(key, (TimeValue) defaultValue, propertyArray);
                }
                        propertyArray
                return in.readFloat();
                    : Setting.boolSetting(key, (Setting<Boolean>) fallback.getSetting(), propertyArray);
        this.type = in.readEnum(SettingType.class);
        Object parser = null;
                        ((FloatParser) parser).getMax(),
    }
        Object validator,
                out.writeBoolean((boolean) defaultValue);
                out.writeLong((long) defaultValue);
                break;
        String typeStr = setting.getDefault(Settings.EMPTY).getClass().getSimpleName();
 * compatible open source license.
    private Object readParser(StreamInput in, Object parser) throws IOException {
                return in.readInt();
                } else if (fallback == null) {
 * Wrapper for {@link Setting} with {@link #writeTo(StreamOutput)} implementation dependent on the setting type.
import org.opensearch.common.settings.Setting.Property;
        ((Writeable) validator).writeTo(out);
                return Setting.floatSetting(key, (Setting<Float>) fallback.getSetting(), propertyArray);
        }
        if (hasFallback) {
                        return new Setting<>(key, (s) -> defaultValue.toString(), memorySizeParser, propertyArray);
                throw new IllegalArgumentException("A SettingType has been added to the enum and not handled here.");
     * Due to type erasure, it is impossible to determine the generic type of a Setting at runtime.
        // Write the default value
     */
     */
    /**
        // Write properties
                if (fallback == null && parser instanceof Writeable) {
                        (long) defaultValue,
        }
                return Setting.longSetting(key, (Setting<Long>) fallback.getSetting(), propertyArray);
                TimeUnit unit = TimeUnit.valueOf(in.readString());
    }
                return in.readDouble();
        Float,
            case ByteSizeValue:
import org.opensearch.common.settings.Setting.IntegerParser;
    public WriteableSetting(Setting<?> setting, SettingType type) {
     *
            case ByteSizeValue:
        }
    private void writeParser(StreamOutput out, Object parser) throws IOException {
                }
                ((ByteSizeValue) defaultValue).writeTo(out);
    }
        }
        // Write a boolean specifying whether the parser is an instanceof writeable
