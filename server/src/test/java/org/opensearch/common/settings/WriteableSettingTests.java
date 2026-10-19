            Setting.boolSetting("boolSetting", (Setting<Boolean>) settingMap.get(SettingType.Boolean), Property.NodeScope, Property.Dynamic)
        assertEquals(2, props.size());
        assertEquals(2, props.size());
            SettingType.TimeValue,
    }
                Property.NodeScope,  
                assertEquals("versionSettingBase", setting.getKey());
                assertEquals(2, props.size());
import org.junit.Before;  
                Property.Dynamic  
                Property.Dynamic
        assertEquals(new ByteSizeValue(10, ByteSizeUnit.KB), (ByteSizeValue) setting.getDefault(Settings.EMPTY));
        assertEquals(2, props.size());
        assertTrue(props.contains(Property.Dynamic));  
        assertEquals(6, (int) setting.getDefault(Settings.EMPTY));
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        assertEquals("boolSettingBase", setting.getKey());
                props = setting.getProperties();  
    // These settings have a fallback setting instead of a default  
                Property.Dynamic
                (Setting<Double>) settingMap.get(SettingType.Double),
        setting = (Setting<ByteSizeValue>) wsfb.getSetting();  
                assertTrue(props.contains(Property.NodeScope));  
                assertEquals(SettingType.Boolean, wsIn.getType());  
                WriteableSetting wsIn = new WriteableSetting(in);  
        assertEquals("intSetting", setting.getKey());
        props = setting.getProperties();
                assertFalse(setting.getDefault(Settings.EMPTY));  
        assertEquals(6, (int) setting.getDefault(Settings.EMPTY));
        assertEquals("simpleString", setting.getKey());
        assertEquals(SettingType.Long, wsfb.getType());  
    private final Map<SettingType, Setting<?>> settingWithFallbackMap = new EnumMap<>(SettingType.class);
                assertEquals("floatSetting", setting.getKey());  
        }  
        }
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        }  
        EnumSet<Property> props = setting.getProperties();  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
    public void testLongSetting() throws IOException {  
    @SuppressWarnings("unchecked")
import org.opensearch.common.io.stream.BytesStreamOutput;
                setting = (Setting<TimeValue>) wsIn.getSetting();
        assertTrue(props.contains(Property.NodeScope));  
        setting = (Setting<TimeValue>) wsfb.getSetting();
                props = setting.getProperties();
            Setting.doubleSetting(
    @SuppressWarnings("unchecked")
        assertTrue(props.contains(Property.Dynamic));  
 *
                props = setting.getProperties();
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.TimeValue));
        assertEquals(SettingType.Float, wsfb.getType());
        assertEquals("foo", (String) setting.getDefault(Settings.EMPTY));  
        assertEquals(SettingType.Float, ws.getType());  
                WriteableSetting wsIn = new WriteableSetting(in);
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.String));
                assertEquals(2, props.size());
        }
                WriteableSetting wsIn = new WriteableSetting(in);
            out.flush();
                assertTrue(props.contains(Property.Dynamic));
        assertEquals(SettingType.String, ws.getType());
        super.setUp();  
        assertTrue(props.contains(Property.NodeScope));
        );
                assertTrue(props.contains(Property.NodeScope));  
        props = setting.getProperties();  
                assertEquals(6.2f, (Float) setting.getDefault(Settings.EMPTY), Float.MIN_NORMAL);
        assertEquals(SettingType.Integer, wsfb.getType());
    @SuppressWarnings("unchecked")  
        assertEquals(SettingType.TimeValue, wsfb.getType());
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Double));  
        );
                setting = (Setting<Version>) wsIn.getSetting();  
        assertEquals(SettingType.Boolean, ws.getType());
            out.flush();  
            Setting.byteSizeSetting("byteSizeSettingBase", new ByteSizeValue(10, ByteSizeUnit.KB), Property.NodeScope, Property.Dynamic)
        assertEquals(2, props.size());  
        EnumSet<Property> props = setting.getProperties();
        try (BytesStreamOutput out = new BytesStreamOutput()) {
/*  
                assertEquals(2, props.size());
                WriteableSetting wsIn = new WriteableSetting(in);  
        settingWithFallbackMap.put(
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.TimeValue));  
                assertTrue(props.contains(Property.Dynamic));
        assertEquals(6.2f, (float) setting.getDefault(Settings.EMPTY), Float.MIN_NORMAL);
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.common.settings.WriteableSetting.SettingType;  
            )
        );  
                assertTrue(props.contains(Property.NodeScope));
                assertTrue(props.contains(Property.Dynamic));
                assertEquals(SettingType.Float, wsIn.getType());
        settingMap.put(SettingType.Double, Setting.doubleSetting("doubleSettingBase", 42.2d, Property.NodeScope, Property.Dynamic));
                assertEquals(SettingType.Double, wsIn.getType());
            )
            }
        assertEquals(2, props.size());
            Setting.simpleString("simpleString", (Setting<String>) settingMap.get(SettingType.String), Property.NodeScope, Property.Dynamic)
        props = setting.getProperties();  
        assertEquals("floatSettingBase", setting.getKey());
                assertEquals(SettingType.ByteSizeValue, wsIn.getType());
                assertTrue(props.contains(Property.NodeScope));  
            out.flush();
                assertEquals(2, props.size());  
        assertEquals("longSettingBase", setting.getKey());
        assertEquals(SettingType.ByteSizeValue, wsfb.getType());
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.Integer));
                assertEquals(42.2d, (double) setting.getDefault(Settings.EMPTY), Double.MIN_NORMAL);
            SettingType.ByteSizeValue,
        EnumSet<Property> props = setting.getProperties();
                assertTrue(props.contains(Property.Dynamic));
                props = setting.getProperties();  
                assertTrue(props.contains(Property.NodeScope));
            out.flush();
        assertTrue(props.contains(Property.NodeScope));
            ws.writeTo(out);  
                assertEquals("longSetting", setting.getKey());
        assertTrue(props.contains(Property.NodeScope));
        }
                WriteableSetting wsIn = new WriteableSetting(in);
        assertEquals("doubleSetting", setting.getKey());
                WriteableSetting wsIn = new WriteableSetting(in);
        settingWithFallbackMap.put(
        assertTrue(props.contains(Property.Dynamic));
        setting = (Setting<Float>) wsfb.getSetting();
        );  
    public void testTimeValueSetting() throws IOException {
                assertEquals("timeSetting", setting.getKey());  
            SettingType.Version,
                props = setting.getProperties();
    @SuppressWarnings("unchecked")
        assertEquals("foo", (String) setting.getDefault(Settings.EMPTY));
    @SuppressWarnings("unchecked")
        setting = (Setting<Long>) wsfb.getSetting();
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.String));
                assertEquals("boolSetting", setting.getKey());
                props = setting.getProperties();
        Setting<Long> setting = (Setting<Long>) ws.getSetting();  
        assertFalse(setting.getDefault(Settings.EMPTY));  
                assertEquals(SettingType.String, wsIn.getType());  
                setting = (Setting<ByteSizeValue>) wsIn.getSetting();  
        settingMap.put(SettingType.Float, Setting.floatSetting("floatSettingBase", 6.2f, Property.NodeScope, Property.Dynamic));
        }  
import org.opensearch.core.common.unit.ByteSizeValue;
            SettingType.String,
                assertEquals(Version.CURRENT, (Version) setting.getDefault(Settings.EMPTY));
        assertTrue(props.contains(Property.NodeScope));
        assertEquals(SettingType.Double, ws.getType());
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            Setting.longSetting("longSetting", (Setting<Long>) settingMap.get(SettingType.Long), Property.NodeScope, Property.Dynamic)  
        );
            }
        assertTrue(props.contains(Property.NodeScope));
    }
            SettingType.Long,
        assertEquals("timeSetting", setting.getKey());  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {  
        settingWithFallbackMap.put(  
                setting = (Setting<Double>) wsIn.getSetting();  
        // No fallback for versionSetting
        assertEquals("longSetting", setting.getKey());
        assertEquals(SettingType.TimeValue, ws.getType());  
    }  
    }
                assertTrue(props.contains(Property.NodeScope));
        assertEquals(42L, (long) setting.getDefault(Settings.EMPTY));  
                setting = (Setting<Boolean>) wsIn.getSetting();
    // These settings have a default value and null fallback
        assertTrue(props.contains(Property.NodeScope));
                assertEquals("byteSizeSetting", setting.getKey());
    public void testStringSetting() throws IOException {  
        assertEquals("byteSizeSettingBase", setting.getKey());  
import org.opensearch.common.unit.TimeValue;  
            SettingType.ByteSizeValue,  
        assertEquals("boolSetting", setting.getKey());
                assertEquals(2, props.size());
        }
        setting = (Setting<Double>) wsfb.getSetting();  
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Version));
        assertEquals(2, props.size());
                assertTrue(props.contains(Property.Dynamic));  
            }
                assertEquals("simpleString", setting.getKey());
                WriteableSetting wsIn = new WriteableSetting(in);  
        EnumSet<Property> props = setting.getProperties();  
            SettingType.Integer,
                assertEquals(2, props.size());  
        Setting<Integer> setting = (Setting<Integer>) ws.getSetting();
                assertEquals(SettingType.Integer, wsIn.getType());
            out.flush();
        EnumSet<Property> props = setting.getProperties();
 * SPDX-License-Identifier: Apache-2.0
                assertTrue(props.contains(Property.Dynamic));
            wsfb.writeTo(out);
        Setting<String> setting = (Setting<String>) ws.getSetting();  
    }
        props = setting.getProperties();
        assertEquals(SettingType.String, wsfb.getType());  
        assertTrue(props.contains(Property.Dynamic));
        Setting<Boolean> setting = (Setting<Boolean>) ws.getSetting();  
                (Setting<ByteSizeValue>) settingMap.get(SettingType.ByteSizeValue),
            Setting.timeSetting("timeSettingBase", new TimeValue(5, TimeUnit.MILLISECONDS), Property.NodeScope, Property.Dynamic)  
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.ByteSizeValue));  
        assertEquals(2, props.size());  
        assertTrue(props.contains(Property.NodeScope));
                props = setting.getProperties();  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {  
                setting = (Setting<String>) wsIn.getSetting();
        EnumSet<Property> props = setting.getProperties();  
            Setting.versionSetting("versionSettingBase", Version.CURRENT, Property.NodeScope, Property.Dynamic)
import java.util.concurrent.TimeUnit;  
    }  
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        settingWithFallbackMap.put(
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.Boolean));
    @SuppressWarnings("unchecked")
        assertTrue(props.contains(Property.Dynamic));  
    public void testByteSizeValueSetting() throws IOException {
        );
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
import static org.opensearch.common.settings.Setting.Property;
                "timeSetting",
            out.flush();
                assertEquals(SettingType.TimeValue, wsIn.getType());
        assertEquals("doubleSettingBase", setting.getKey());  
        assertFalse(setting.getDefault(Settings.EMPTY));
                assertTrue(props.contains(Property.Dynamic));  
                Property.NodeScope,  
        assertEquals(2, props.size());
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
        assertTrue(props.contains(Property.NodeScope));
import java.util.Map;
        settingMap.put(  
 */  
        }
    }
            Setting.intSetting("intSetting", (Setting<Integer>) settingMap.get(SettingType.Integer), Property.NodeScope, Property.Dynamic)
            wsfb.writeTo(out);
import java.util.EnumSet;
        assertTrue(props.contains(Property.Dynamic));  
        Setting<Float> setting = (Setting<Float>) ws.getSetting();
        assertTrue(props.contains(Property.NodeScope));  
        assertEquals(2, props.size());
            wsfb.writeTo(out);
            }
}
        Setting<ByteSizeValue> setting = (Setting<ByteSizeValue>) ws.getSetting();
            )
    @SuppressWarnings("unchecked")
        settingWithFallbackMap.put(  
        assertEquals(SettingType.Long, ws.getType());
            wsfb.writeTo(out);  
        assertTrue(props.contains(Property.NodeScope));  
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Boolean));
        );  
        setting = (Setting<Boolean>) wsfb.getSetting();
        assertTrue(props.contains(Property.Dynamic));
                (Setting<TimeValue>) settingMap.get(SettingType.TimeValue),
        try (BytesStreamOutput out = new BytesStreamOutput()) {
        );  
    @SuppressWarnings("unchecked")
    public void setup() throws Exception {
    @Before
        assertEquals(42L, (long) setting.getDefault(Settings.EMPTY));
        assertTrue(props.contains(Property.NodeScope));
    }  
                "doubleSetting",  
                assertEquals(SettingType.Version, wsIn.getType());
        Setting<TimeValue> setting = (Setting<TimeValue>) ws.getSetting();
        props = setting.getProperties();
    public void testVersionSetting() throws IOException {  
        EnumSet<Property> props = setting.getProperties();
            wsfb.writeTo(out);  
                assertTrue(props.contains(Property.NodeScope));
        assertEquals(new TimeValue(5, TimeUnit.MILLISECONDS), (TimeValue) setting.getDefault(Settings.EMPTY));
import java.io.IOException;
                setting = (Setting<Integer>) wsIn.getSetting();  
                assertTrue(props.contains(Property.NodeScope));
        assertEquals(6.2f, (float) setting.getDefault(Settings.EMPTY), Float.MIN_NORMAL);  
        assertTrue(props.contains(Property.NodeScope));
        settingMap.put(SettingType.Boolean, Setting.boolSetting("boolSettingBase", false, Property.NodeScope, Property.Dynamic));
        assertEquals("timeSettingBase", setting.getKey());
            Setting.floatSetting("floatSetting", (Setting<Float>) settingMap.get(SettingType.Float), Property.NodeScope, Property.Dynamic)
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(new TimeValue(5, TimeUnit.MILLISECONDS), (TimeValue) setting.getDefault(Settings.EMPTY));  
        );
        assertTrue(props.contains(Property.Dynamic));  
                assertEquals(42L, (long) setting.getDefault(Settings.EMPTY));  
        assertTrue(props.contains(Property.NodeScope));  
        assertEquals(2, props.size());  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
            wsfb.writeTo(out);
            SettingType.Float,  
        EnumSet<Property> props = setting.getProperties();  
        assertEquals(2, props.size());
                setting = (Setting<Long>) wsIn.getSetting();
public class WriteableSettingTests extends OpenSearchTestCase {
    @SuppressWarnings("unchecked")  
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.Long));
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
                Property.NodeScope,
        settingMap.put(SettingType.String, Setting.simpleString("simpleStringBase", "foo", Property.NodeScope, Property.Dynamic));  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {
                WriteableSetting wsIn = new WriteableSetting(in);
 * The OpenSearch Contributors require contributions made to  
            }
        assertEquals("intSettingBase", setting.getKey());  
                assertEquals(2, props.size());
        assertEquals("floatSetting", setting.getKey());  
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Integer));  
        assertEquals(SettingType.Integer, ws.getType());
                assertEquals(SettingType.Long, wsIn.getType());  
        Setting<Double> setting = (Setting<Double>) ws.getSetting();
        assertTrue(props.contains(Property.NodeScope));  
            wsfb.writeTo(out);  
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.ByteSizeValue));
        }
        assertTrue(props.contains(Property.Dynamic));
    }  
        assertEquals(SettingType.Version, ws.getType());
                assertEquals(new TimeValue(5, TimeUnit.MILLISECONDS), (TimeValue) setting.getDefault(Settings.EMPTY));
            SettingType.Double,
                props = setting.getProperties();
            }
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Float));
        assertEquals("versionSettingBase", setting.getKey());
            wsfb.writeTo(out);
                assertEquals(6, (int) setting.getDefault(Settings.EMPTY));
        assertEquals(42.2d, (double) setting.getDefault(Settings.EMPTY), Double.MIN_NORMAL);
                assertEquals(new ByteSizeValue(10, ByteSizeUnit.KB), (ByteSizeValue) setting.getDefault(Settings.EMPTY));
package org.opensearch.common.settings;
        assertEquals(SettingType.ByteSizeValue, ws.getType());
        settingWithFallbackMap.put(  
        settingMap.put(
        settingMap.put(
        assertEquals(2, props.size());
        props = setting.getProperties();  
import java.util.EnumMap;  
            out.flush();
        assertEquals(2, props.size());
import org.opensearch.Version;
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.Float));  
import org.opensearch.core.common.io.stream.BytesStreamInput;
        assertEquals(2, props.size());
        try (BytesStreamOutput out = new BytesStreamOutput()) {
                "byteSizeSetting",
        props = setting.getProperties();
        WriteableSetting ws = new WriteableSetting(settingMap.get(SettingType.Long));
        assertEquals(42.2d, (double) setting.getDefault(Settings.EMPTY), Double.MIN_NORMAL);
                assertTrue(props.contains(Property.Dynamic));  
        assertTrue(props.contains(Property.Dynamic));
            out.flush();  
        WriteableSetting wsfb = new WriteableSetting(settingWithFallbackMap.get(SettingType.Double));
        EnumSet<Property> props = setting.getProperties();
        assertTrue(props.contains(Property.Dynamic));  
        assertTrue(props.contains(Property.Dynamic));
        assertEquals(SettingType.Boolean, wsfb.getType());  
        assertEquals(SettingType.Double, wsfb.getType());
import org.opensearch.core.common.unit.ByteSizeUnit;  
            try (BytesStreamInput in = new BytesStreamInput(BytesReference.toBytes(out.bytes()))) {  
            Setting.byteSizeSetting(  
            out.flush();
        assertEquals(new ByteSizeValue(10, ByteSizeUnit.KB), (ByteSizeValue) setting.getDefault(Settings.EMPTY));
                assertEquals("foo", (String) setting.getDefault(Settings.EMPTY));  
            Setting.timeSetting(  
        assertTrue(props.contains(Property.Dynamic));  
        settingWithFallbackMap.put(
        );  
                assertTrue(props.contains(Property.NodeScope));
        assertEquals(2, props.size());  
        try (BytesStreamOutput out = new BytesStreamOutput()) {  
        settingMap.put(SettingType.Long, Setting.longSetting("longSettingBase", 42L, Property.NodeScope, Property.Dynamic));  
    @SuppressWarnings("unchecked")  
    public void testFloatSetting() throws IOException {
        assertTrue(props.contains(Property.Dynamic));
                assertEquals("doubleSetting", setting.getKey());
    public void testDoubleSetting() throws IOException {
        setting = (Setting<Integer>) wsfb.getSetting();  
        assertTrue(props.contains(Property.Dynamic));
    private final Map<SettingType, Setting<?>> settingMap = new EnumMap<>(SettingType.class);
            }  
        );
            SettingType.Boolean,  
        assertEquals(2, props.size());  
        assertEquals("byteSizeSetting", setting.getKey());
    }  
        assertTrue(props.contains(Property.NodeScope));
        props = setting.getProperties();
    public void testIntegerSetting() throws IOException {
                WriteableSetting wsIn = new WriteableSetting(in);  
        setting = (Setting<String>) wsfb.getSetting();
                setting = (Setting<Float>) wsIn.getSetting();
 * compatible open source license.
        try (BytesStreamOutput out = new BytesStreamOutput()) {
            }  
        assertTrue(props.contains(Property.Dynamic));
                assertEquals(2, props.size());
                props = setting.getProperties();  
            }
        settingWithFallbackMap.put(
        assertEquals("simpleStringBase", setting.getKey());
        assertEquals(2, props.size());
                assertEquals(2, props.size());
            SettingType.TimeValue,
        assertEquals(Version.CURRENT, (Version) setting.getDefault(Settings.EMPTY));
                assertTrue(props.contains(Property.Dynamic));  
        Setting<Version> setting = (Setting<Version>) ws.getSetting();  
        assertTrue(props.contains(Property.NodeScope));
import org.opensearch.test.OpenSearchTestCase;
    public void testBooleanSetting() throws IOException {  
        assertTrue(props.contains(Property.Dynamic));
        settingMap.put(SettingType.Integer, Setting.intSetting("intSettingBase", 6, Property.NodeScope, Property.Dynamic));
                assertEquals("intSetting", setting.getKey());
