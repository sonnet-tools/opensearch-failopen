    @SuppressWarnings("unchecked")
        }
    @SuppressWarnings("unchecked")
        assertEquals(SettingType.String, wsfb.getType());
        assertTrue(props.contains(Property.Dynamic));
        assertEquals(2, props.size());
            SettingType.TimeValue,
        assertTrue(props.contains(Property.NodeScope));
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.TimeValue));
}
        settingMap.put(SettingType.Boolean, Setting.boolSetting("boolSettingBase", false, Property.NodeScope, Property.Dynamic));
                assertEquals(2, props.size());
            Setting.byteSizeSetting("byteSizeSettingBase", new ByteSizeValue(10, ByteSizeUnit.KB), Property.NodeScope, Property.Dynamic)
                assertEquals(SettingType.String, wsIn.getType());
            SettingType.TimeValue,
    @SuppressWarnings("unchecked")
        assertEquals(2, props.size());
/*
            SettingType.Double,
        props = setting.getProperties();
                Property.Dynamic
        }
        setting = (Setting<ByteSizeValue>) wsfb.getSetting();
        assertEquals(SettingType.Long, wsfb.getType());
        }
        assertEquals(2, props.size());
        assertTrue(props.contains(Property.Dynamic));
                assertEquals(42L, (long) setting.getDefault(Settings.EMPTY));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertTrue(props.contains(Property.NodeScope));
                setting = (Setting<Long>) wsIn.getSetting();
        assertTrue(props.contains(Property.Dynamic));
            Setting.timeSetting(
        assertEquals(SettingType.Boolean, ws.getType());
                assertEquals(2, props.size());
        assertTrue(props.contains(Property.Dynamic));
                assertEquals(new TimeValue(5, TimeUnit.MILLISECONDS), (TimeValue) setting.getDefault(Settings.EMPTY));
            out.flush();
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        );
        settingMap.put(
                assertTrue(props.contains(Property.NodeScope));
        assertEquals("boolSettingBase", setting.getKey());
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        assertEquals(SettingType.Long, ws.getType());
            Setting.longSetting("longSetting", (Setting<Long>) settingMap.get(SettingType.Long), Property.NodeScope, Property.Dynamic)
        setting = (Setting<Boolean>) wsfb.getSetting();
        assertEquals(2, props.size());
        assertEquals(2, props.size());
        settingMap.put(SettingType.String, Setting.simpleString("simpleStringBase", "foo", Property.NodeScope, Property.Dynamic));
            out.flush();
        Setting<Integer> setting = (Setting<Integer>) ws.getSetting();
                assertTrue(props.contains(Property.NodeScope));
                assertTrue(props.contains(Property.Dynamic));
            out.flush();
        assertEquals(Version.CURRENT, (Version) setting.getDefault(Settings.EMPTY));
        EnumSet<Property> props = setting.getProperties();
            }
                assertEquals("byteSizeSetting", setting.getKey());
            SettingType.ByteSizeValue,
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
                props = setting.getProperties();
    public void testTimeValueSetting() throws IOException {
            out.flush();
        }
            }
            }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.TimeValue));
        );
        settingMap.put(SettingType.Float, Setting.floatSetting("floatSettingBase", 6.2f, Property.NodeScope, Property.Dynamic));
                assertTrue(props.contains(Property.NodeScope));
    @SuppressWarnings("unchecked")
                assertTrue(props.contains(Property.NodeScope));
                (Setting<TimeValue>) settingMap.get(SettingType.TimeValue),
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Integer));
                assertEquals(42.2d, (double) setting.getDefault(Settings.EMPTY), Double.MIN_NORMAL);
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                setting = (Setting<Version>) wsIn.getSetting();
        assertTrue(props.contains(Property.Dynamic));
        assertEquals(SettingType.Float, wsfb.getType());
        );
                props = setting.getProperties();
            }
                assertEquals("foo", (String) setting.getDefault(Settings.EMPTY));
            wsfb.writeTo(out);
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.Double));
        settingWithFallbackMap.put(
        assertEquals(new ByteSizeValue(10, ByteSizeUnit.KB), (ByteSizeValue) setting.getDefault(Settings.EMPTY));
        setting = (Setting<String>) wsfb.getSetting();
import org.opensearch.common.io.stream.BytesStreamOutput;
        assertEquals(new ByteSizeValue(10, ByteSizeUnit.KB), (ByteSizeValue) setting.getDefault(Settings.EMPTY));
        assertTrue(props.contains(Property.NodeScope));
    @SuppressWarnings("unchecked")
                assertTrue(props.contains(Property.Dynamic));
            ws.writeTo(out);
        settingMap.put(SettingType.Long, Setting.longSetting("longSettingBase", 42L, Property.NodeScope, Property.Dynamic));
                assertTrue(props.contains(Property.Dynamic));
        assertTrue(props.contains(Property.Dynamic));
    }
    public void testVersionSetting() throws IOException {
        assertTrue(props.contains(Property.Dynamic));
        settingWithFallbackMap.put(
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.Long));
        assertEquals(2, props.size());
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        Setting<Float> setting = (Setting<Float>) ws.getSetting();
import java.util.EnumMap;
        EnumSet<Property> props = setting.getProperties();
            Setting.simpleString("simpleString", (Setting<String>) settingMap.get(SettingType.String), Property.NodeScope, Property.Dynamic)
                WriteableSetting wsIn = new WriteableSetting(in);
                props = setting.getProperties();
                assertEquals(2, props.size());
    // These settings have a fallback setting instead of a default
            SettingType.String,
        Setting<Boolean> setting = (Setting<Boolean>) ws.getSetting();
    public void testByteSizeValueSetting() throws IOException {
        EnumSet<Property> props = setting.getProperties();
        assertTrue(props.contains(Property.NodeScope));
        );
                WriteableSetting wsIn = new WriteableSetting(in);
        EnumSet<Property> props = setting.getProperties();
        EnumSet<Property> props = setting.getProperties();
        assertEquals(2, props.size());
            out.flush();
                Property.Dynamic
import org.opensearch.test.OpenSearchTestCase;
            SettingType.Long,
        assertEquals("doubleSetting", setting.getKey());
                assertEquals(2, props.size());
                assertEquals(new ByteSizeValue(10, ByteSizeUnit.KB), (ByteSizeValue) setting.getDefault(Settings.EMPTY));
        Setting<TimeValue> setting = (Setting<TimeValue>) ws.getSetting();
    public void testStringSetting() throws IOException {
        // No fallback for versionSetting
import org.opensearch.core.common.bytes.BytesReference;
        props = setting.getProperties();
        assertEquals("foo", (String) setting.getDefault(Settings.EMPTY));
        assertEquals(2, props.size());
    @SuppressWarnings("unchecked")
        assertEquals(SettingType.Version, ws.getType());
import java.io.IOException;
            Setting.timeSetting("timeSettingBase", new TimeValue(5, TimeUnit.MILLISECONDS), Property.NodeScope, Property.Dynamic)
    @Before
        assertTrue(props.contains(Property.NodeScope));
                setting = (Setting<Float>) wsIn.getSetting();
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.Integer));
                WriteableSetting wsIn = new WriteableSetting(in);
        assertEquals(42L, (long) setting.getDefault(Settings.EMPTY));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        assertEquals(2, props.size());
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.Boolean));
            }
        assertTrue(props.contains(Property.Dynamic));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
import java.util.Map;
                setting = (Setting<TimeValue>) wsIn.getSetting();
        assertEquals("byteSizeSetting", setting.getKey());
        assertEquals(new TimeValue(5, TimeUnit.MILLISECONDS), (TimeValue) setting.getDefault(Settings.EMPTY));
    }
        assertEquals(SettingType.ByteSizeValue, wsfb.getType());
        }
                props = setting.getProperties();
        settingWithFallbackMap.put(
        assertEquals(6.2f, (float) setting.getDefault(Settings.EMPTY), Float.MIN_NORMAL);
        assertFalse(setting.getDefault(Settings.EMPTY));
        assertTrue(props.contains(Property.NodeScope));
import org.opensearch.core.common.unit.ByteSizeUnit;
        settingMap.put(
        assertTrue(props.contains(Property.Dynamic));
        assertEquals("longSettingBase", setting.getKey());
        assertTrue(props.contains(Property.Dynamic));
    public void setup() throws Exception {
        settingWithFallbackMap.put(
    @SuppressWarnings("unchecked")
                assertEquals("versionSettingBase", setting.getKey());
                assertEquals(SettingType.Version, wsIn.getType());
                assertTrue(props.contains(Property.NodeScope));
                WriteableSetting wsIn = new WriteableSetting(in);
                assertEquals(SettingType.Boolean, wsIn.getType());
        Setting<String> setting = (Setting<String>) ws.getSetting();
        props = setting.getProperties();
    }
                WriteableSetting wsIn = new WriteableSetting(in);
        assertEquals(new TimeValue(5, TimeUnit.MILLISECONDS), (TimeValue) setting.getDefault(Settings.EMPTY));
    public void testIntegerSetting() throws IOException {
                setting = (Setting<String>) wsIn.getSetting();
            }
                props = setting.getProperties();
                assertEquals(SettingType.Integer, wsIn.getType());
        assertTrue(props.contains(Property.Dynamic));
import static org.opensearch.common.settings.Setting.Property;
        setting = (Setting<Integer>) wsfb.getSetting();
            out.flush();
            Setting.boolSetting("boolSetting", (Setting<Boolean>) settingMap.get(SettingType.Boolean), Property.NodeScope, Property.Dynamic)
        settingWithFallbackMap.put(
        super.setUp();
        assertTrue(props.contains(Property.NodeScope));
        props = setting.getProperties();
        );
                assertEquals(2, props.size());
    @SuppressWarnings("unchecked")
                assertTrue(props.contains(Property.Dynamic));
import static org.opensearch.common.settings.WriteableSetting.SettingType;
                assertTrue(props.contains(Property.Dynamic));
                (Setting<ByteSizeValue>) settingMap.get(SettingType.ByteSizeValue),
 * compatible open source license.
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
                assertEquals(SettingType.ByteSizeValue, wsIn.getType());
        assertEquals("byteSizeSettingBase", setting.getKey());
    private final Map<SettingType, Setting<?>> settingMap = new EnumMap<>(SettingType.class);
        assertEquals(2, props.size());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        setting = (Setting<Double>) wsfb.getSetting();
        assertTrue(props.contains(Property.NodeScope));
        assertEquals("simpleStringBase", setting.getKey());
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.Float));
    // These settings have a default value and null fallback
                props = setting.getProperties();
import org.opensearch.Version;
        assertTrue(props.contains(Property.Dynamic));
        assertEquals(6, (int) setting.getDefault(Settings.EMPTY));
        assertEquals(6.2f, (float) setting.getDefault(Settings.EMPTY), Float.MIN_NORMAL);
            }
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(2, props.size());
        props = setting.getProperties();
                assertEquals(SettingType.Float, wsIn.getType());
        assertTrue(props.contains(Property.Dynamic));
                assertEquals(6, (int) setting.getDefault(Settings.EMPTY));
        );
            wsfb.writeTo(out);
        settingWithFallbackMap.put(
        assertTrue(props.contains(Property.NodeScope));
                assertEquals(Version.CURRENT, (Version) setting.getDefault(Settings.EMPTY));
        assertEquals(2, props.size());
    }
                assertEquals(SettingType.Double, wsIn.getType());
                WriteableSetting wsIn = new WriteableSetting(in);
                assertTrue(props.contains(Property.NodeScope));
                WriteableSetting wsIn = new WriteableSetting(in);
            out.flush();
                assertTrue(props.contains(Property.NodeScope));
        assertEquals(42.2d, (double) setting.getDefault(Settings.EMPTY), Double.MIN_NORMAL);
        setting = (Setting<Float>) wsfb.getSetting();
        EnumSet<Property> props = setting.getProperties();
        assertTrue(props.contains(Property.NodeScope));
        assertTrue(props.contains(Property.NodeScope));
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        );
import java.util.EnumSet;
            )
    @SuppressWarnings("unchecked")
    public void testDoubleSetting() throws IOException {
                (Setting<Double>) settingMap.get(SettingType.Double),
            Setting.intSetting("intSetting", (Setting<Integer>) settingMap.get(SettingType.Integer), Property.NodeScope, Property.Dynamic)
        props = setting.getProperties();
                assertFalse(setting.getDefault(Settings.EMPTY));
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            Setting.versionSetting("versionSettingBase", Version.CURRENT, Property.NodeScope, Property.Dynamic)
        assertEquals(42.2d, (double) setting.getDefault(Settings.EMPTY), Double.MIN_NORMAL);
    public void testFloatSetting() throws IOException {
            wsfb.writeTo(out);
            )
        assertEquals(2, props.size());
            SettingType.Version,
        );
        settingWithFallbackMap.put(
                assertEquals(6.2f, (Float) setting.getDefault(Settings.EMPTY), Float.MIN_NORMAL);
                assertEquals(SettingType.Long, wsIn.getType());
        assertEquals(SettingType.ByteSizeValue, ws.getType());
    }
                assertTrue(props.contains(Property.Dynamic));
                Property.Dynamic
        assertEquals("doubleSettingBase", setting.getKey());
        assertEquals(SettingType.Integer, wsfb.getType());
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Float));
            wsfb.writeTo(out);
            }
        assertEquals(SettingType.Float, ws.getType());
                assertEquals(2, props.size());
            wsfb.writeTo(out);
import org.opensearch.common.unit.TimeValue;
    }
        assertTrue(props.contains(Property.NodeScope));
        assertTrue(props.contains(Property.Dynamic));
                Property.NodeScope,
package org.opensearch.common.settings;
        setting = (Setting<TimeValue>) wsfb.getSetting();
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        assertTrue(props.contains(Property.NodeScope));
                "doubleSetting",
        assertEquals("boolSetting", setting.getKey());
                assertEquals("timeSetting", setting.getKey());
        Setting<Double> setting = (Setting<Double>) ws.getSetting();
        assertEquals("timeSettingBase", setting.getKey());
public class WriteableSettingTests extends OpenSearchTestCase {
    public void testBooleanSetting() throws IOException {
            SettingType.Integer,
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            Setting.floatSetting("floatSetting", (Setting<Float>) settingMap.get(SettingType.Float), Property.NodeScope, Property.Dynamic)
import org.opensearch.core.common.io.stream.BytesStreamInput;
        EnumSet<Property> props = setting.getProperties();
                Property.NodeScope,
        assertEquals("intSettingBase", setting.getKey());
    }
        assertEquals(SettingType.String, ws.getType());
                Property.NodeScope,
        EnumSet<Property> props = setting.getProperties();
    }
                setting = (Setting<Boolean>) wsIn.getSetting();
                setting = (Setting<Double>) wsIn.getSetting();
                setting = (Setting<Integer>) wsIn.getSetting();
        assertEquals(2, props.size());
        assertEquals(2, props.size());
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.ByteSizeValue));
        assertTrue(props.contains(Property.NodeScope));
            Setting.byteSizeSetting(
        assertEquals("simpleString", setting.getKey());
 *
        settingWithFallbackMap.put(
        assertEquals("foo", (String) setting.getDefault(Settings.EMPTY));
        setting = (Setting<Long>) wsfb.getSetting();
                assertTrue(props.contains(Property.Dynamic));
        );
        assertEquals(SettingType.Integer, ws.getType());
            out.flush();
        );
            Setting.doubleSetting(
                assertEquals(2, props.size());
                assertEquals(2, props.size());
            SettingType.Float,
                "timeSetting",
                assertTrue(props.contains(Property.Dynamic));
import java.util.concurrent.TimeUnit;
        }
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.common.unit.ByteSizeValue;
                assertTrue(props.contains(Property.Dynamic));
            SettingType.ByteSizeValue,
        EnumSet<Property> props = setting.getProperties();
        props = setting.getProperties();
        assertTrue(props.contains(Property.NodeScope));
    }
        assertEquals(6, (int) setting.getDefault(Settings.EMPTY));
        assertEquals(2, props.size());
    private final Map<SettingType, Setting<?>> settingWithFallbackMap = new EnumMap<>(SettingType.class);
        assertEquals(42L, (long) setting.getDefault(Settings.EMPTY));
        Setting<Version> setting = (Setting<Version>) ws.getSetting();
        assertEquals("intSetting", setting.getKey());
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
                assertEquals("intSetting", setting.getKey());
                props = setting.getProperties();
    public void testLongSetting() throws IOException {
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Version));
        assertEquals(2, props.size());
        assertEquals(SettingType.Boolean, wsfb.getType());
                assertEquals("simpleString", setting.getKey());
                props = setting.getProperties();
        assertEquals("timeSetting", setting.getKey());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            out.flush();
        assertEquals("floatSetting", setting.getKey());
            wsfb.writeTo(out);
        assertTrue(props.contains(Property.Dynamic));
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Double));
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.ByteSizeValue));
 * The OpenSearch Contributors require contributions made to
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Boolean));
 */
        assertEquals("versionSettingBase", setting.getKey());
        assertEquals(SettingType.TimeValue, wsfb.getType());
                "byteSizeSetting",
                setting = (Setting<ByteSizeValue>) wsIn.getSetting();
    }
        assertTrue(props.contains(Property.Dynamic));
        assertFalse(setting.getDefault(Settings.EMPTY));
        settingMap.put(SettingType.Double, Setting.doubleSetting("doubleSettingBase", 42.2d, Property.NodeScope, Property.Dynamic));
    @SuppressWarnings("unchecked")
        assertEquals(SettingType.Double, wsfb.getType());
                assertEquals("longSetting", setting.getKey());
        );
            SettingType.Boolean,
        assertEquals("floatSettingBase", setting.getKey());
            }
        props = setting.getProperties();
        }
import org.junit.Before;
                WriteableSetting wsIn = new WriteableSetting(in);
            wsfb.writeTo(out);
        settingMap.put(
                assertEquals("floatSetting", setting.getKey());
            )
            wsfb.writeTo(out);
        }
        }
        assertEquals(2, props.size());
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.String));
                WriteableSetting wsIn = new WriteableSetting(in);
        assertTrue(props.contains(Property.Dynamic));
                assertEquals(SettingType.TimeValue, wsIn.getType());
        assertEquals(SettingType.TimeValue, ws.getType());
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.String));
                assertEquals("boolSetting", setting.getKey());
        assertEquals(SettingType.Double, ws.getType());
                props = setting.getProperties();
                assertTrue(props.contains(Property.NodeScope));
                assertTrue(props.contains(Property.NodeScope));
        Setting<Long> setting = (Setting<Long>) ws.getSetting();
        assertEquals("longSetting", setting.getKey());
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Long));
                assertEquals("doubleSetting", setting.getKey());
        assertTrue(props.contains(Property.NodeScope));
        Setting<ByteSizeValue> setting = (Setting<ByteSizeValue>) ws.getSetting();
        settingMap.put(SettingType.Integer, Setting.intSetting("intSettingBase", 6, Property.NodeScope, Property.Dynamic));
        assertTrue(props.contains(Property.NodeScope));
