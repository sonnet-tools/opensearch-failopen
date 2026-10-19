            pluginCompatibilityRange,
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> newPluginsService(settings));
        Path pluginDir = createTempDir();
            public TooManyParametersPlugin(Settings settings, Path configPath, Object object) {
        assertThat(e.getCause().getMessage(), containsString("Level"));  
            final IllegalStateException e = expectThrows(IllegalStateException.class, () -> newPluginsService(settings, pluginClass));  
                .build();  
        PluginsService.Bundle bundle4 = new PluginsService.Bundle(info4, pluginDir);
            "desc",  
            "1.0",  
        }
 *
            "1.0",  
import java.util.zip.ZipInputStream;
                ),
    public static class AdditionalSettingsPlugin1 extends Plugin {  
                        + "] of type ["
        PluginInfo info4 = new PluginInfo(
        PluginsService service = newPluginsService(settings, AdditionalSettingsPlugin1.class, FilterablePlugin.class);
            null,  
        assertThat(
        );
        IllegalStateException e = expectThrows(  
            "plugin2",
                "1.0.0",
        assertThat(e.getMessage(), containsString("Could not load plugin descriptor for plugin directory [plugin-missing-descriptor]"));
                "version",
            exception,  
        );  
                System.getProperty("java.specification.version"),  
            "java.version",
            false
            Collections.singletonList(
import org.opensearch.test.MockLogAppender;
import org.hamcrest.Matchers;
            () -> PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, new HashMap<>())
            Version.CURRENT,
            "test.DummyPlugin"
            e,
        } catch (IllegalArgumentException e) {
            Version.CURRENT.toString(),  
            "1000000",
 * this file be licensed under the Apache-2.0 license or a
        transitiveDeps.put("dep2", Collections.singleton(dupJar.toUri().toURL()));
        assertNotNull(deps);
            .build();  
        Path depDir = createTempDir();
            Version.fromString("1.0.0"),
        Map<String, Set<URL>> transitiveDeps = new HashMap<>();
            Collections.singletonList("common"),
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> PluginsService.verifyCompatibility(info));
        // This should not throw an exception - shared transitive dependencies are allowed
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> PluginsService.sortBundles(bundles));
        Set<URL> deps = transitiveDeps.get("myplugin");
            "Plugin1",  
        assertThat(exception, hasToString(containsString("Unable to load plugin class [DummyClass]")));
    }  
                    "signature of constructor for extension ["
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginsService.verifyCompatibility(info));
        Path homeDir = createTempDir();  
                            entry = in.getNextEntry();
        }  
        IllegalStateException e = expectThrows(
        PluginInfo info1 = new PluginInfo("myplugin", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
        TestPlugin plugin = new TestPlugin();
                        + PluginsServiceTests.class.getClassLoader()  
        Path pluginJar = pluginDir.resolve("plugin.jar");
            "base-plugin,other-plugin"  
    }
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.NIOFS.getSettingsKey())  
        Path dep2Dir = createTempDir();  
        });
        }
                        + "] must be either () or ("
        assertTrue(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("=1.0.0"), Version.fromString("1.0.0")));
        PluginInfo info4 = new PluginInfo("other", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
    }
            "desc",
        );  
            System.getProperty("java.specification.version"),
            "version",
        Set<PluginsService.Bundle> bundles = new LinkedHashSet<>(); // control iteration order
                        + "])"
 * ownership. Elasticsearch licenses this file to you under  
        Path pluginDir = createTempDir();
                containsString(
            fake,
        Path pluginDir = createTempDir();
            TwoParametersFirstIncorrectType.class,
                                byte[] buffer = new byte[10 * 1024];
        RuntimeException exception = expectThrows(RuntimeException.class, () -> newPluginsService(settings));
    }
            "1.0",
            "Plugin 1",
            hasToString(
            "desc",
        Files.createFile(removing);
            "description",  
            "name",
            plugin3Dir,
    }  
        );
                )
            Collections.emptyList(),
        Path otherDir = createTempDir();
        });
        );
        }
        PluginInfo info1 = new PluginInfo(  
            "classname",
        assertNotNull(deps);
        assertThat(sortedBundles, Matchers.contains(bundle1, bundle4, bundle2, bundle3));
        IllegalStateException e = expectThrows(
    }
                    relativePath = relativePath.replace("/" + clazz.getSimpleName(), "$" + clazz.getSimpleName());  
        Map<String, Set<URL>> transitiveDeps = new HashMap<>();
                            }  
    }  
                "name",
            );
                }  
        }  
            "name",  
            "1.0",
            "my_plugin",
        PluginsService.Bundle bundle1 = new PluginsService.Bundle(info1, pluginDir);  
                    // copy from dir, and use a different canonical path to not conflict with test classpath  
        assertThat(extensiblePlugin.extensions, hasSize(0));
    public void testJarHellDuplicateCodebaseWithDep() throws Exception {  
        TestPlugin plugin = new TestPlugin();
            "1.0.0",
                containsString(  
                        + "] of type ["  
    public static class DummyClass2 {}
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
import java.io.IOException;
        );  
        );
        assertThat(((TestExtension2) extensiblePlugin.extensions.get(1)).plugin, sameInstance(testPlugin));
import java.util.zip.ZipOutputStream;  
        Path pluginsDir = tempDir.resolve("plugins");
        Path pluginsDir = homeDir.resolve("plugins");
        assertThat(  
    }
            "version",
                containsString(
        public Settings additionalSettings() {  
            false  
        Path dep2Jar = dep2Dir.resolve("dep2.jar");
            "extended.plugins",
            "fake",
            )  
        PluginInfo info2 = new PluginInfo("bar", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
import static org.hamcrest.Matchers.notNullValue;
            Version.CURRENT,
 * KIND, either express or implied.  See the License for the
        assertFalse(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("~1.0.1"), Version.fromString("1.0.0")));  
            );
        PluginInfo info = new PluginInfo("foo", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
    }
            "1.0",
            TestPlugin.class.getName()  
    }
                Tuple.tuple(
            "1.8",  
        final IllegalStateException e = expectThrows(  
            "desc",  
        assertTrue(basePluginDependents.v2().isEmpty());  
            "FakePlugin",  
            .put("my.setting", "test")
        );  
            }  
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.NIOFS.getSettingsKey())
import java.util.HashMap;
        PluginTestUtil.writePluginProperties(
                "test.DummyPlugin"
        Settings settings = Settings.builder()  
            Version.CURRENT.toString(),
                )
            "1.0",
    public void testFilterPlugins() {
            "opensearch.version",
                    out.putNextEntry(new ZipEntry("test/" + clazz.getSimpleName() + ".class"));
            "opensearch.version",  
        final Path hidden = home.resolve("plugins").resolve(".hidden");
            @SuppressWarnings("unused")  
        Path pluginDir = createTempDir();
            "plugin3",  
@LuceneTestCase.SuppressFileSystems(value = "ExtrasFS")
            Files.createFile(testFile);
        PluginTestUtil.writePluginProperties(  
                    // copy from jar, exactly as is
    public static class ThrowingConstructorExtension implements TestExtensionPoint {
            "nonextensible",
            "desc",
            hasToString(
            PluginsService.createExtension(ThrowingConstructorExtension.class, TestExtensionPoint.class, plugin);
            Arrays.asList("dep1", "dep2"),
        );
    }
        assertThat(otherPluginDependents.v1(), containsInAnyOrder("plugin2", "plugin3"));  
    }  
                    "no unique public constructor for extension ["
import org.opensearch.env.Environment;
            "1.8",
            "1.0",
        try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("non-extensible-plugin.jar")) {
            public MultiplePublicConstructorsPlugin() {
            "name",
        Map<String, Set<URL>> transitiveDeps = new HashMap<>();
        Path pluginDir = createTempDir();  
    public void testPluginFromParentClassLoader() throws IOException {  
            "opensearch.version",  
            hasToString(  
        );  
        final Settings settings = Settings.builder().put("path.home", pathHome).put("plugin.mandatory", "fake").build();
            .put("plugin.mandatory", "org.opensearch.plugins.PluginsServiceTests$FakePlugin")
    }
        Path plugin3Dir = pluginsDir.resolve("plugin3");  
        }  
        final Path plugins = pathHome.resolve("plugins");
    }
                        + "]"  
                .put("foo.bar", "1")
            "my_plugin",
        bundles.add(bundle2);
            "myplugin",
        final String expected = String.format(
    public void testExistingPluginMissingDescriptor() throws Exception {  
                        + "] of type ["
        Path pluginDir = createTempDir();  
        final Settings settings = Settings.builder()  
            () -> newPluginsService(settings, MultiplePublicConstructorsPlugin.class)
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> newPluginsService(settings));
            e,
    public void testAdditionalSettings() {
        // This test opens a child classloader, reading a jar under the test temp  
            .put("path.home", createTempDir())
        Files.createDirectories(pluginsDir);
        PluginInfo info1 = new PluginInfo("grandparent", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
    public void testMultipleExtensionConstructors() {  
        );
            IllegalStateException.class,
        assertEquals("failed to load plugin myplugin due to jar hell", e.getMessage());  
            "java.version",  
            "MyPlugin",
            "java.version",
                        + TestPlugin.class.getName()  
            false
            "Plugin 3",
            assertThat(PluginsService.findPluginDirs(plugins), containsInAnyOrder(fake));  
        bundles.add(bundle2);  
        assertFalse(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("1.0.0"), Version.fromString("1.0.1")));
                        + TestExtensionPoint.class.getName()
        try (MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(LogManager.getLogger(PluginsService.class))) {
            @SuppressWarnings("unused")
 *  
        assertThat(e.getMessage(), containsString("was built for OpenSearch version "));
            "version",  
        final Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();  
        );
            Collections.singletonList("dep"),  
            "test.DummyPlugin"
            public TwoParametersSecondIncorrectType(Settings settings, Object object) {
                "1.8",
        makeJar(dep1Jar, DummyClass2.class);
    public interface TestExtensionPoint {}  
            Collections.singletonList("dep"),
        assertThat(e.getMessage(), containsString("was built for OpenSearch version 1.0.0"));
            "1.8",  
            "1.0",
        public ThrowingConstructorExtension() {  
        }
    public void testTooManyParametersExtensionConstructors() {  
        bundles.add(bundle4);  
            "desc",  
        assertTrue(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("1.0.0"), Version.fromString("1.0.0")));
        assertEquals("Missing plugin [dne], dependency of [foo]", e.getMessage());
        bundles.add(new PluginsService.Bundle(info4, pluginDir));
            "opensearch.version",  
            Files.copy(jar, mypluginDir.resolve("plugin.jar"));
            try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("dummy-plugin.jar")) {
        Set<URL> deps = transitiveDeps.get("myplugin");  
            }
        assertThat(deps, containsInAnyOrder(pluginJar.toUri().toURL(), dep1Jar.toUri().toURL(), dep2Jar.toUri().toURL()));
        Settings settings = Settings.builder()
            public MultiplePublicConstructorsPlugin(final Settings settings) {
            }  
        public Plugin plugin;
            "whatever",
            "myplugin",
            final Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
import java.lang.reflect.InvocationTargetException;  
        // Incompatible plugin and core versions
                    "Non-plugin file located in the plugins folder with the following name: [.DS_Store]"
                        + "] must be either () or ("
            )  
            "opensearch.version",
        PluginsService.Bundle bundle2 = new PluginsService.Bundle(info2, pluginDir);
        PluginsService.Bundle bundle = new PluginsService.Bundle(info, pluginDir);
        extensiblePlugin = new TestExtensiblePlugin();  
        // does not override pre existing settings  
            "MyPlugin",  
        }
    private PluginInfo getPluginInfoWithWithSemverRange(String semverRange) {
    }
            null,
            )
        final Path plugins = pathHome.resolve("plugins");  
import org.opensearch.common.io.PathUtils;
                String relativePath = clazz.getCanonicalName().replaceAll("\\.", "/") + ".class";  
        makeJar(depJar, DummyClass1.class);  
            "1.8",
                                break;
        PluginInfo info = new PluginInfo(
            fake,
        assertThat(sortedBundles, Matchers.contains(bundle1, bundle2));  
            e,
        assertThat(e.getCause().getMessage(), containsString("jar hell!"));
            "nonextensible",  
    public static class AdditionalSettingsPlugin2 extends Plugin {
import org.apache.logging.log4j.Level;
                "MyPlugin",  
        TestExtensiblePlugin extensiblePlugin = new TestExtensiblePlugin();
    public static class TestExtension1 implements TestExtensionPoint {}
            System.getProperty("java.specification.version"),  
                "opensearch.version",  
        IllegalArgumentException e = expectThrows(  
            plugin2Dir,
        class TestExtension implements TestExtensionPoint {
        assertEquals(FilterablePlugin.class, scriptPlugins.get(0).getClass());
        // dir (a dummy plugin). Classloaders are closed by GC, so when test teardown
import org.apache.logging.log4j.LogManager;
        }
            false
            "myplugin",
                    extensiblePlugin
import org.apache.lucene.tests.util.LuceneTestCase;  
        );  
            "false"
        }
            throw new IllegalArgumentException("test constructor failure");
            "1.0",
    }
            plugin1Dir,  
        Map<String, Set<URL>> transitiveDeps = new HashMap<>();  
        PluginsService.Bundle bundle3 = new PluginsService.Bundle(info3, pluginDir);
        assertThat(e, hasToString(containsString("no unique public constructor")));
        Path mypluginDir = pluginsDir.resolve("myplugin");  
            Locale.ROOT,  
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
        TestPlugin plugin = new TestPlugin();
            fake,  
    public void testExistingMandatoryClasspathPlugin() {
            @SuppressWarnings("unused")
        public Settings additionalSettings() {
        );
            expectThrows(UnsupportedOperationException.class, () -> extensions.add(new TestExtension1()));  
import org.opensearch.index.IndexModule;  
        );  
        Files.createDirectories(fake);
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
        PluginTestUtil.writePluginProperties(
            "fake",
                }
            () -> newPluginsService(settings, NoPublicConstructorPlugin.class)
                Path codebase = PathUtils.get(clazz.getProtectionDomain().getCodeSource().getLocation().toURI());  
            PluginTestUtil.writePluginProperties(
            "bar",
    }
            )
 * software distributed under the License is distributed on an
            () -> PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveDeps)
            Collections.singletonList("common"),
import java.util.Locale;
            TooManyParametersPlugin.class,
        class OneParameterIncorrectType extends Plugin {
import org.opensearch.test.OpenSearchTestCase;  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
        PluginInfo info1 = new PluginInfo("foo", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
        PluginInfo info1 = new PluginInfo(  
        Path pluginJar = pluginDir.resolve("plugin.jar");
        assertEquals("1", newSettings.get("foo.bar")); // added setting exists
        }
        }  
            hasToString(
        TestPlugin plugin = new TestPlugin();
        }
        );  
    public void testJarHellDuplicateClassWithCore() throws Exception {
            )  
            }
        assertTrue(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("~1.0.0"), Version.fromString("1.0.0")));  
            this.plugin = plugin;
            "1.0.0",
            "1.0",  
        class TestExtension implements TestExtensionPoint {  
    public void testSortBundlesCycleSelfReference() throws Exception {
    public static class DummyClass3 {}
        PluginsService.Bundle bundle2 = new PluginsService.Bundle(info2, pluginDir);
        PluginsService.Bundle bundle2 = new PluginsService.Bundle(info2, pluginDir);  
                out.closeEntry();
            );  
                        + TestExtension.class.getName()  
            }  
            Version.CURRENT,  
        transitiveDeps.put("dep1", Collections.singleton(dep1Jar.toUri().toURL()));
            "1.0",  
        Set<PluginsService.Bundle> bundles = new LinkedHashSet<>(); // control iteration order  
            nonextensibleDir,
            System.getProperty("java.specification.version"),
        assertFalse(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("=1.0.0"), Version.fromString("1.0.1")));
 * the Apache License, Version 2.0 (the "License"); you may
            false  
        return new PluginsService(settings, null, TestEnvironment.newEnvironment(settings).pluginsDir(), Arrays.asList(classpathPlugins));
        final Path fake = plugins.resolve("fake");  
        Path tempDir = createTempDir();  
import static org.hamcrest.Matchers.instanceOf;  
 * this work for additional information regarding copyright
            null,
            String msg = e.getMessage();
            mockLogAppender.addExpectation(  
        );  
            "1.8",
            "classname",  
        PluginInfo info3 = new PluginInfo(
                    new PluginInfo("extensible", null, null, Version.CURRENT, null, null, Collections.emptyList(), false),
        });
        IllegalStateException e = expectThrows(
            // verify unmodifiable.
        PluginsService.verifyCompatibility(info);  
    }
 * GitHub history for details.
            () -> PluginsService.sortBundles(Collections.singleton(bundle))
        assertTrue(nonExistentDependents.v1().isEmpty());
        PluginsService.loadExtensions(  
            "desc",
        assertThat(extensiblePlugin.extensions.get(1), instanceOf(TestExtension2.class));  
                "java.version",
 * license agreements. See the NOTICE file distributed with
            "desc",
            public TwoParametersFirstIncorrectType(Object object, Path configPath) {
            TwoParametersSecondIncorrectType.class,  
                        + TestExtensionPoint.class.getName()
        final Path home = createTempDir();
        assertTrue(otherPluginDependents.v2().isEmpty());
                "foo",
            "myplugin",  
            "classname",
        transitiveDeps.put("dep", Collections.singleton(dupJar.toUri().toURL()));
        );  
    }
            Version.CURRENT,
            "description",
                if (codebase.toString().endsWith(".jar")) {
        assertThat(extensiblePlugin.extensions.get(0), instanceOf(TestExtension1.class));
        );  
        Files.createFile(fake.resolve("plugin.jar"));
            "classname",
            "MyPlugin",  
            "MyPlugin",
            "description",  
        final Path home = createTempDir();
import java.util.Collections;  
            )
        Files.createDirectories(hidden);
        PluginInfo info2 = new PluginInfo(
            System.getProperty("java.specification.version"),  
        }
        );  
            e,
        assertThat(e.getCause().getMessage(), containsString("jar hell!"));
            mypluginDir,
            @SuppressWarnings("unused")  
            "desc",
 */
            final Path home = createTempDir();
        );
            }
            new SemverRange(  
                        + TestExtensionPoint.class.getName()
    }
        Path pluginDir = createTempDir();
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);  
        PluginTestUtil.writePluginProperties(
            () -> PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveDeps)
    public void testNoExtensionConstructors() {
            @SuppressWarnings("unused")  
        assertEquals("failed to load plugin myplugin due to jar hell", e.getMessage());
    }
            "version",
        Map<String, Set<URL>> transitiveDeps = new HashMap<>();  
                    "[.test] warning",
                    "Plugin [fake] must reference a class loader local Plugin class ["  
                VersionUtils.getVersion(Version.CURRENT.major, Version.CURRENT.minor, (byte) (Version.CURRENT.revision + 1)),
                        ZipEntry entry = in.getNextEntry();
            "desc",
            "classname",
        Path pluginDir = createTempDir();
        makeJar(pluginJar, Level.class);  
    static PluginsService newPluginsService(Settings settings, Class<? extends Plugin>... classpathPlugins) {
                Tuple.tuple(
                        + "] of type ["
        List<SemverRange> pluginCompatibilityRange = List.of(new SemverRange(Version.CURRENT, SemverRange.RangeOperator.TILDE));  
            hasToString(  
            mockLogAppender.assertAllExpectationsMatched();  
    public static class TestPlugin extends Plugin {}
            OneParameterIncorrectType.class
            Version.CURRENT,  
            final Path fake = plugins.resolve("fake");  
        assertThat(e.getCause().getMessage(), containsString("jar hell! duplicate codebases with extended plugin"));
    public void testSortBundlesMissingOptionalDep() throws Exception {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            false  
            Version.CURRENT.toString(),
            mockLogAppender.assertAllExpectationsMatched();
    }  
        assertTrue(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("~1.0.1"), Version.fromString("1.0.2")));
        @Override
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
        transitiveDeps.put("dep2", Collections.singleton(dep2Jar.toUri().toURL()));
        final Path removing = home.resolve("plugins").resolve(".removing-fake");  
                                int read = in.read(buffer);  
    public void testPluginLoadFailure() throws IOException {
        bundles.add(new PluginsService.Bundle(info3, pluginDir));  
                        + TestExtensionPoint.class.getName()
        makeJar(pluginJar, DummyClass1.class);
        assertThat(extensiblePlugin.extensions, notNullValue());  
        );
        assertThat(e.getCause().getMessage(), containsString("jar hell!"));
    }
            "description",
        // occurs the jar is deleted while the classloader is still open. However, on
    }
            @SuppressWarnings("unused")
        try (ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(jarFile))) {
            false
            .put("my.setting", "test")
                            in.closeEntry();
            PluginInfo info = new PluginInfo(  
    public void testHiddenDirectories() throws IOException {
        makeJar(dep2Jar, DummyClass2.class);
        PluginInfo info3 = new PluginInfo(
                        + TestPlugin.class.getName()
import java.net.URL;
            false
                "classname",
            "version",
        PluginInfo info1 = new PluginInfo("dep", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
        PluginsService service = newPluginsService(settings, AdditionalSettingsPlugin1.class, AdditionalSettingsPlugin2.class);  
            assertTrue(msg, msg.contains("plugin [" + AdditionalSettingsPlugin1.class.getName()));
            .build();  
            fake,  
        assertEquals("Cycle found in plugin dependencies: foo -> foo", e.getMessage());
            "description",
            "whatever",
            "1.8",
            "fake",
        // Verify the transitive URLs were correctly populated  
        final Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
            false
        }
            "has.native.controller",
            Path pluginDir = createTempDir();
            extensions = loader.loadExtensions(TestExtensionPoint.class);
            "fake",
        final Path pathHome = createTempDir();
                )
            private NoPublicConstructorPlugin() {
            "java.version",  
            );  
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.MMAPFS.getSettingsKey())
        }  
            "my_plugin",
        final Path fake = plugins.resolve("fake");
        Path pluginDir = createTempDir();  
        assumeFalse("windows deletion behavior is asinine", Constants.WINDOWS);
                    testPlugin
        Path pluginDir = createTempDir();  
            "desc",
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
            "MyPlugin",
        newPluginsService(settings);  
    public static class BadSingleParameterConstructorExtension implements TestExtensionPoint {  
            IllegalStateException.class,  
    public void testLoadPluginWithNoPublicConstructor() {
import static org.hamcrest.Matchers.hasSize;
        );  
    }  
    }  
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {  
        final Settings settings = Settings.builder().put("path.home", pathHome).put("plugin.mandatory", "fake").build();
    public void testAdditionalSettingsClash() {
            "my_plugin",
        }  
                )
            pluginCompatibilityRange,  
            "1.0.0",
        Path dep1Dir = createTempDir();  
            "1.0",  
            false
            "java.version",
        Set<PluginsService.Bundle> bundles = new LinkedHashSet<>(); // control iteration order  
        PluginsService.loadExtensions(
        assertEquals("test", newSettings.get("my.setting")); // previous settings still exist
        );
            "name",
            "bar",
        }
                        while (entry != null) {  
        assertThat(sortedBundles, Matchers.contains(bundle1, bundle2, bundle3));
        transitiveDeps.put("dep1", Collections.singleton(dep1Jar.toUri().toURL()));
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
        makeJar(pluginJar, DummyClass1.class);  
            "version",
import java.util.List;  
        try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("dummy-plugin.jar")) {
        assertThat(e.getCause(), instanceOf(InvocationTargetException.class));
            Collections.emptyList(),
        );
            "1.0",
    public void testStartupWithRemovingMarker() throws IOException {  
            () -> PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveDeps)
        final Settings settings = Settings.builder().put("path.home", pathHome).put("plugin.mandatory", "fake").build();  
        final Path home = createTempDir();
            "java.version",
            public TestExtension() {}  
 * under the License.  
    public void testLoadPluginWithMultiplePublicConstructors() {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {  
public class PluginsServiceTests extends OpenSearchTestCase {
                "desc",
        Path pluginJar = pluginDir.resolve("plugin.jar");
                                    read = in.read(buffer);  
            mockLogAppender.addExpectation(  
            IllegalStateException.class,
                        + TestPlugin.class.getName()  
            Version.CURRENT,
                                }
        Tuple<List<String>, List<String>> basePluginDependents = PluginsService.findPluginsByDependency(pluginsDir, "base-plugin");
            "other-plugin"
    }  
        assertThat(basePluginDependents.v1(), containsInAnyOrder("plugin1", "plugin2"));
            assertTrue(msg, msg.contains("Cannot have additional setting [foo.bar]"));  
            PluginsService.createExtension(TestExtension.class, TestExtensionPoint.class, plugin);
            "1.0",
        public TestExtension2(TestPlugin plugin) {
        class MultiplePublicConstructorsPlugin extends Plugin {
            }
                "1.0",  
    public void testExistingMandatoryInstalledPlugin() throws IOException {  
        PluginsService service = newPluginsService(settings, AdditionalSettingsPlugin1.class);
 * Unless required by applicable law or agreed to in writing,
        final Path pathHome = createTempDir();  
        );
        PluginInfo info = new PluginInfo(  
            false
            "plugin1",
        );
            assert extensions == null;  
        assertThat(e.getMessage(), containsString("my_plugin requires Java"));
            return Settings.builder().put("foo.bar", "2").build();
                )
        Path pluginDir = createTempDir();  
            "description",
            "DummyClass"
    public void testFindPluginDirs() throws Exception {
    public void testSortBundlesNoDeps() throws Exception {
            "1.0",  
    }  
            "java.version",  
                        + ThrowingConstructorExtension.class.getName()  
            "description",  
        bundles.add(bundle1);
                    new PluginInfo("test", null, null, Version.CURRENT, null, null, Collections.singletonList("extensible"), false),  
            "description",
        assertThat(e.getCause().getCause(), hasToString(containsString("test constructor failure")));  
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())  
import static org.hamcrest.Matchers.containsString;  
        assertThat(e, hasToString(containsString(expected)));  
    public void testFindPluginsByDependency() throws Exception {
            false
import static org.hamcrest.Matchers.hasToString;
import org.apache.lucene.util.Constants;
        assertEquals("failed to load plugin myplugin due to jar hell", e.getMessage());  
                    out.putNextEntry(new ZipEntry(relativePath));  
        );  
            Version.CURRENT,
 * The OpenSearch Contributors require contributions made to  
            IllegalStateException.class,
            Version.CURRENT,
            PluginsService.createExtension(BadSingleParameterConstructorExtension.class, TestExtensionPoint.class, plugin);  
    public static class FilterablePlugin extends Plugin implements ScriptPlugin {}
        public BadSingleParameterConstructorExtension(String bad) {}
            () -> PluginsService.sortBundles(Collections.singleton(bundle))
            false  
import java.util.Arrays;
        assertThat(extensiblePlugin.extensions, hasSize(2));
            "foo",
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
            System.getProperty("java.specification.version"),  
    }
        final Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
            "MyPlugin",
            assertTrue(msg, msg.contains("plugin [" + AdditionalSettingsPlugin2.class.getName()));
    }
            "MyPlugin",  
            "1.8",  
        // Compatible plugin and core versions
        PluginTestUtil.writePluginProperties(
    public void testThrowingConstructor() {
            "1.8",
        // Version.CURRENT is behind by one with respect to patch version in the range
            "MyPlugin",
        assertThat(  
                    Level.WARN,
            IllegalArgumentException.class,
                new MockLogAppender.SeenEventExpectation(
    }
        bundles.add(bundle2);  
            "1.0",  
    }  
            "description",
        }
            "opensearch.version",
        transitiveDeps.put("dep1", Collections.singleton(dupJar.toUri().toURL()));  
        );  
        Tuple<List<String>, List<String>> otherPluginDependents = PluginsService.findPluginsByDependency(pluginsDir, "other-plugin");
            IllegalStateException.class,
        class TwoParametersSecondIncorrectType extends Plugin {
    }
    }
            "baz",  
        assertThat(sortedBundles, Matchers.contains(bundle));
        bundles.add(new PluginsService.Bundle(info, pluginDir));
        TestPlugin plugin = new TestPlugin();
                )
        assertEquals("failed to load plugin myplugin due to jar hell", e.getMessage());  
            "found file [%s] from a failed attempt to remove the plugin [fake]; execute [opensearch-plugin remove fake]",
        Path pluginJar = pluginDir.resolve("plugin.jar");  
import org.opensearch.common.collect.Tuple;
            "version",
            false
            "myplugin",
package org.opensearch.plugins;
            "desc",  
        Tuple<List<String>, List<String>> nonExistentDependents = PluginsService.findPluginsByDependency(pluginsDir, "non-existent");  
                        + BadSingleParameterConstructorExtension.class.getName()
 * specific language governing permissions and limitations
    public void testIncompatibleOpenSearchVersion() throws Exception {
    public void testExtensiblePlugin() {
        try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("dummy-plugin.jar")) {  
import java.nio.file.Path;  
            private TestExtension() {}
    }
            "opensearch.version",
        TestPlugin testPlugin = new TestPlugin();
        PluginsService.Bundle bundle1 = new PluginsService.Bundle(info1, pluginDir);
            "MyPlugin",
import java.util.Collection;
                        + TestExtension.class.getName()  
    private static class TestExtensiblePlugin extends Plugin implements ExtensiblePlugin {
        PluginInfo info = new PluginInfo(  
    public void testSortBundlesSingle() throws Exception {
        PluginTestUtil.writePluginProperties(
        // need a jar file of core dep, use log4j here  
 *
        assertThat(
        assertEquals("Cycle found in plugin dependencies: foo -> bar -> baz -> foo", e.getMessage());
        public TooManyParametersConstructorExtension(String bad) {}
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginsService.verifyCompatibility(info));
            hasToString(  
            "1.0.0",  
        final Path fake = plugins.resolve("fake");
            "classname",
                        + ")"  
        );
        assertFalse(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("~1.0.0"), Version.fromString("1.1.0")));
            Collections.emptyList(),  
    public void testIncompatibleOpenSearchVersionRange() {  
                "description",  
        final Collection<Class<? extends Plugin>> classes = Arrays.asList(  
        Path pluginJar = pluginDir.resolve("plugin.jar");
/*  
    }  
            "FakePlugin",
            Path testFile = plugins.resolve(".DS_Store");
            false
        private List<TestExtensionPoint> extensions;
            Version.CURRENT.toString(),  
        @Override
            "1.8",  
        PluginInfo info1 = new PluginInfo(
        PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveDeps);
        return new PluginInfo(  
    public void testSortBundlesCommonDep() throws Exception {
        );  
        PluginsService.Bundle bundle1 = new PluginsService.Bundle(info1, pluginDir);
import java.util.LinkedHashSet;
                Version.CURRENT,
            "extended.plugins",
 */  
        transitiveDeps.put("dep2", Collections.singleton(dep2Jar.toUri().toURL()));
    public void testSortBundlesMissingRequiredDep() throws Exception {
            PluginsService.createExtension(TestExtension.class, TestExtensionPoint.class, plugin);
        }
import org.opensearch.env.TestEnvironment;
 * not use this file except in compliance with the License.
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> newPluginsService(settings));
                        + "]"  
        final Path plugins = createTempDir();  
        PluginInfo info = new PluginInfo("foo", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Arrays.asList("bar", "other"), false);
        assertThat(e.getCause().getCause(), instanceOf(IllegalArgumentException.class));
            Collections.singletonList("dep"),
    public static class TooManyParametersConstructorExtension implements TestExtensionPoint {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
            }  
                Files.copy(jar, fake.resolve("plugin.jar"));  
            "1.8",
        // windows, files cannot be deleted when they are still open by a process.  
            Collections.singletonList("baz"),
import org.opensearch.common.bootstrap.JarHell;  
        makeJar(dep1Jar, DummyClass2.class);
        public FakePlugin() {  
            return Settings.builder()  
        assertThat(e, hasToString(containsString("no public constructor")));
            "description",  
        makeJar(pluginJar, DummyClass1.class);
import java.util.Set;  
        );
    public void testPluginCompatibilityWithSemverRange() {  
            IllegalStateException.class,  
        makeJar(dep2Jar, DummyClass3.class);
    }
            "description",
        final Path plugins = pathHome.resolve("plugins");
            Collections.emptyList(),
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), homeDir).build();
            Collections.emptyList(),
    }
    }  
        final String expected = "Could not load plugin descriptor for plugin directory [.hidden]";
    void makeJar(Path jarFile, Class... classes) throws Exception {  
        PluginsService.Bundle bundle = new PluginsService.Bundle(info, pluginDir);
    }  
import java.nio.file.Files;
            IllegalStateException.class,  
    }  
        final Path pathHome = createTempDir();
            "1.0",  
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
            "desc",
        );  
        final IllegalStateException e = expectThrows(  
        );  
            PluginsService.createExtension(TooManyParametersConstructorExtension.class, TestExtensionPoint.class, plugin);  
        assertEquals(IndexModule.Type.NIOFS.getSettingsKey(), newSettings.get(IndexModule.INDEX_STORE_TYPE_SETTING.getKey()));
        );
            "classname",
            "1.8",
            "name",
    }
                        + "]"  
            "extended.plugins",  
            "1.8",  
        Path dep2Jar = dep2Dir.resolve("dep2.jar");
            "Plugin2",
            false
            List.of(SemverRange.fromString(semverRange)),
        PluginInfo info3 = new PluginInfo("baz", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
        public void loadExtensions(ExtensionLoader loader) {
                    Level.INFO,
                Version.CURRENT.toString(),
        for (Class<? extends Plugin> pluginClass : classes) {  
import static org.hamcrest.Matchers.sameInstance;
        assertThat(
                    // static inner class of this test
            "opensearch.version",
    public static class FakePlugin extends Plugin {
            "Plugin 2",  
            "name",  
                    extensiblePlugin  
                } else {
            assertThat(e, hasToString(containsString("no public constructor of correct signature")));
            Version.CURRENT,
                Tuple.tuple(
        PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveDeps);
        assertTrue(nonExistentDependents.v2().isEmpty());
        // occurs the jar is deleted while the classloader is still open. However, on  
            Version.CURRENT.toString(),
    }
        bundles.add(bundle3);  
        assertTrue(exception.getCause() instanceof ClassNotFoundException);  
            "desc",
        });
        newPluginsService(settings, FakePlugin.class);
            "1.0",
            "version",  
import static org.hamcrest.Matchers.containsInAnyOrder;
            }
        makeJar(pluginJar, DummyClass1.class);
            service.updatedSettings();
                containsString(  
        final Path fake = home.resolve("plugins").resolve("fake");  
            "test.NonExtensiblePlugin"
            "1.8",
                    "Missing optional plugin [dne], dependency of [foo]. Some features of this plugin may not function without the dependencies being installed."
        assumeFalse("windows deletion behavior is asinine", Constants.WINDOWS);
            Collections.singletonList("grandparent"),
            "1.0",  
    // Note: testing dup codebase with core is difficult because it requires a symlink, but we have mock filesystems and security manager  
                containsString(
        transitiveDeps.put("dep", Collections.singleton(depJar.toUri().toURL()));
            )  
        Path dupJar = otherDir.resolve("dup.jar");  
            "FakePlugin",  
 */  
    }
    public void testLoadPluginWithNoPublicConstructorOfCorrectSignature() {
                    "[.test] info",
                                    out.write(buffer, 0, read);
            System.getProperty("java.specification.version"),
        );  
            )
                "description",
    public void testCompatibleOpenSearchVersionRange() {
        Path dep1Jar = dep1Dir.resolve("dep1.jar");
            "MyPlugin",  
        });
        final Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
        class TwoParametersFirstIncorrectType extends Plugin {
        bundles.add(bundle3);  
        assertEquals("Plugin [myplugin] cannot extend non-extensible plugin [nonextensible]", e.getMessage());
                        + "), not ("
                        + ")"
import java.io.InputStream;
            removing
            "base-plugin"
        ); // set a class defined outside the bundle (in parent class-loader of plugin)
            "name",
            Files.copy(jar, nonextensibleDir.resolve("plugin.jar"));
        bundles.add(bundle1);  
        Path dep2Dir = createTempDir();  
        @SuppressWarnings("unchecked")  
                        }  
            "1.0.0",
                    }
        PluginTestUtil.writePluginProperties(
                        + TooManyParametersConstructorExtension.class.getName()
            Version.CURRENT.toString(),
    public void testSortBundlesCycle() throws Exception {
            "1.0.0",  
    public static class TestExtension2 implements TestExtensionPoint {
            Files.copy(jar, fake.resolve("plugin.jar"));
        assertThat(e.getCause().getMessage(), containsString("DummyClass1"));
            Arrays.asList("dep1", "dep2"),
                Collections.singletonList("dne;optional=true"),
            "classname",  
        Path plugin2Dir = pluginsDir.resolve("plugin2");
        Path dep1Jar = dep1Dir.resolve("dep1.jar");
            Version.CURRENT,
    }
                        + String.class.getName()
            Collections.singletonList("foo"),  
            "1.8",
        PluginTestUtil.writePluginProperties(  
        PluginsService.Bundle bundle = new PluginsService.Bundle(info, pluginDir);
            Version.CURRENT.toString(),
            "fake",  
        ); // This class is not present in Path, hence plugin loading will throw ClassNotFoundException
        Path dep1Dir = createTempDir();  
import org.opensearch.semver.SemverRange;
    }  
                containsString(
        assertThat(e, hasToString(containsString(expected)));
        assertThat(extensiblePlugin.extensions, notNullValue());  
        makeJar(dupJar, DummyClass2.class);
        final Path home = createTempDir();
    }
}
            "classname",  
    public void testNonExtensibleDep() throws Exception {
 * Licensed to Elasticsearch under one or more contributor  
    public void testJarHellDuplicateClassAcrossDeps() throws Exception {
                    new PluginInfo("extensible", null, null, Version.CURRENT, null, null, Collections.emptyList(), false),  
            "desc",
        List<PluginsService.Bundle> sortedBundles = PluginsService.sortBundles(bundles);
        @Override
            "FakePlugin",  
    public void testJarHellDuplicateClassWithDep() throws Exception {  
            .build();
            "description",  
                    "signature of constructor for extension ["
        List<PluginsService.Bundle> sortedBundles = PluginsService.sortBundles(bundles);
            Version.CURRENT,
import java.util.Map;
            public TestExtension(TestPlugin plugin) {
        // This test opens a child classloader, reading a jar under the test temp
        try {
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    }  
        try (MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(LogManager.getLogger(PluginsService.class))) {
                    "failed to create extension ["
        // dir (a dummy plugin). Classloaders are closed by GC, so when test teardown
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {  
    }
                                while (read != -1) {
                        + TestExtensionPoint.class.getName()
        Path pluginsDir = createTempDir();
            "java.version",
            PluginsService.sortBundles(Collections.singleton(bundle));
                            if (entry.getName().equals(relativePath)) {
        Path plugin1Dir = pluginsDir.resolve("plugin1");
            "my_plugin",  
        );  
            "name",  
            "1.8",
    public void testSortBundlesAlreadyOrdered() throws Exception {
            "myplugin",  
        class NoPublicConstructorPlugin extends Plugin {
        );
                    "no public constructor for extension ["
        makeJar(dupJar);  
            "1.8",
            "Fake",  
                SemverRange.RangeOperator.TILDE
                fake,
/*
    public void testJarHellTransitiveMap() throws Exception {
    public static class DummyClass1 {}  
import org.opensearch.common.settings.Settings;  
        assertThat(
            "desc",
import org.opensearch.Version;
            }
                false
        assertThat(deps, containsInAnyOrder(pluginJar.toUri().toURL(), dupJar.toUri().toURL()));  
        Path pluginDir = createTempDir();  
            fail("Expected exception when building updated settings");  
        }
    }  
            "MyPlugin",  
            "common",
                )
                    "org.opensearch.plugins.PluginsService",  
                    "org.opensearch.plugins.PluginsService",  
        List<SemverRange> pluginCompatibilityRange = List.of(
                )  
                )  
            "FakePlugin",
        PluginInfo info = new PluginInfo("foo", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.singletonList("dne"), false);
            "opensearch.version",  
        );
        }
            Arrays.asList("dep1", "dep2"),  
        Path dupJar = pluginDir.resolve("dup.jar");
            e,
        // windows, files cannot be deleted when they are still open by a process.
        class TooManyParametersPlugin extends Plugin {
            Version.CURRENT,  
import org.opensearch.test.VersionUtils;
        List<PluginsService.Bundle> sortedBundles = PluginsService.sortBundles(Collections.singleton(bundle));  
        List<ScriptPlugin> scriptPlugins = service.filterPlugins(ScriptPlugin.class);
            PluginsService.Bundle bundle = new PluginsService.Bundle(info, pluginDir);
            )  
            "myplugin",  
        PluginInfo info1 = new PluginInfo(  
                )
                if (relativePath.contains(PluginsServiceTests.class.getSimpleName())) {
        bundles.add(new PluginsService.Bundle(info2, pluginDir));
        Path pluginDir = createTempDir();
            "Plugin3",
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> PluginsService.getPluginBundles(pluginsDir));  
            "1.8",
    public void testIncompatibleJavaVersion() throws Exception {
        PluginInfo info2 = new PluginInfo(  
        Path depJar = depDir.resolve("dep.jar");
        PluginInfo info2 = new PluginInfo(
        List<PluginsService.Bundle> sortedBundles = PluginsService.sortBundles(bundles);
            Arrays.asList(  
                    try (ZipInputStream in = new ZipInputStream(Files.newInputStream(codebase))) {
        bundles.add(bundle1);  
        Settings newSettings = service.updatedSettings();  
            "1.8",
        PluginInfo info = new PluginInfo("foo", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.singletonList("foo"), false);
/*  
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> newPluginsService(settings));
            Version.CURRENT.toString(),
    public void testJarHellDuplicateCodebaseAcrossDeps() throws Exception {
        IllegalStateException e = expectThrows(  
                new MockLogAppender.SeenEventExpectation(
                    Files.copy(codebase.resolve(relativePath), out);
    }
        Path nonextensibleDir = pluginsDir.resolve("nonextensible");  
        assertEquals(1, scriptPlugins.size());  
    }  
        Set<PluginsService.Bundle> bundles = new LinkedHashSet<>(); // control iteration order, so we get know the beginning of the cycle  
                        + "] of type ["  
            Version.CURRENT.toString(),
        PluginInfo info = new PluginInfo(
        );
            "name",
                "fake",  
        );  
        PluginInfo info1 = new PluginInfo(  
                        + "] (class loader ["
            "version",
        assertThat(e.getCause().getMessage(), containsString("DummyClass2"));
        PluginTestUtil.writePluginProperties(
        Files.createDirectory(pluginsDir.resolve("plugin-missing-descriptor"));
        );  
            public OneParameterIncorrectType(Object object) {
    public void testBadSingleParameterConstructor() {  
        PluginsService.Bundle bundle3 = new PluginsService.Bundle(info3, pluginDir);
 * You may obtain a copy of the License at  
import java.util.zip.ZipEntry;
            "extended.plugins",
            for (Class clazz : classes) {
            "java.version",
