    public void testSortBundlesSingle() throws Exception {
            plugin2Dir,
            nonextensibleDir,
        }
            "name",
        final String expected = "Could not load plugin descriptor for plugin directory [.hidden]";
            Path testFile = plugins.resolve(".DS_Store");
                VersionUtils.getVersion(Version.CURRENT.major, Version.CURRENT.minor, (byte) (Version.CURRENT.revision + 1)),
 *
        assertEquals("failed to load plugin myplugin due to jar hell", e.getMessage());
        );
            "desc",
        PluginTestUtil.writePluginProperties(
            .put("my.setting", "test")
                System.getProperty("java.specification.version"),
    private static class TestExtensiblePlugin extends Plugin implements ExtensiblePlugin {
        final Path pathHome = createTempDir();
import org.opensearch.common.collect.Tuple;
                }
        PluginsService service = newPluginsService(settings, AdditionalSettingsPlugin1.class);
        );
                Version.CURRENT,
    }
        );
            "1.0",
        PluginsService service = newPluginsService(settings, AdditionalSettingsPlugin1.class, AdditionalSettingsPlugin2.class);
    }
        transitiveDeps.put("dep", Collections.singleton(depJar.toUri().toURL()));
            "other-plugin"
                containsString(
        }
import java.util.LinkedHashSet;
        public FakePlugin() {
        for (Class<? extends Plugin> pluginClass : classes) {
        try (ZipOutputStream out = new ZipOutputStream(Files.newOutputStream(jarFile))) {
                containsString(
        assertFalse(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("~1.0.0"), Version.fromString("1.1.0")));
        assertEquals(FilterablePlugin.class, scriptPlugins.get(0).getClass());
/*
        @SuppressWarnings("unchecked")
 *
            hasToString(
            assertThat(e, hasToString(containsString("no public constructor of correct signature")));
                        + "] (class loader ["
            Version.CURRENT,
        }
            System.getProperty("java.specification.version"),
        }
            }
            "whatever",
                            if (entry.getName().equals(relativePath)) {
                        + TestExtensionPoint.class.getName()
            "bar",
            System.getProperty("java.specification.version"),
    public static class BadSingleParameterConstructorExtension implements TestExtensionPoint {
        Path pluginDir = createTempDir();
                                int read = in.read(buffer);
            TwoParametersSecondIncorrectType.class,
    }
    private PluginInfo getPluginInfoWithWithSemverRange(String semverRange) {
        }
            PluginsService.createExtension(ThrowingConstructorExtension.class, TestExtensionPoint.class, plugin);
                    Files.copy(codebase.resolve(relativePath), out);
            "classname",
            plugin3Dir,
    public void testNoExtensionConstructors() {
        // This should not throw an exception - shared transitive dependencies are allowed
/*
    public void testJarHellDuplicateClassWithDep() throws Exception {
                Tuple.tuple(
 * You may obtain a copy of the License at
    static PluginsService newPluginsService(Settings settings, Class<? extends Plugin>... classpathPlugins) {
        );
 *
        // This test opens a child classloader, reading a jar under the test temp
        final Settings settings = Settings.builder().put("path.home", pathHome).put("plugin.mandatory", "fake").build();
            Arrays.asList("dep1", "dep2"),
            "name",
                    // static inner class of this test
        PluginTestUtil.writePluginProperties(
            exception,
        final String expected = String.format(
        Path pluginDir = createTempDir();
            hasToString(
        transitiveDeps.put("dep1", Collections.singleton(dupJar.toUri().toURL()));
    public void testSortBundlesAlreadyOrdered() throws Exception {
        makeJar(dep1Jar, DummyClass2.class);
            false
        Files.createDirectory(pluginsDir.resolve("plugin-missing-descriptor"));
            "version",
    }
        );
        }
    public void testSortBundlesCycle() throws Exception {
import java.util.Locale;
            "my_plugin",
            TooManyParametersPlugin.class,
                    // copy from jar, exactly as is
        assertThat(e.getCause().getMessage(), containsString("Level"));
    public static class DummyClass3 {}
        }
        ); // This class is not present in Path, hence plugin loading will throw ClassNotFoundException
        assertThat(
            TestPlugin.class.getName()
        PluginsService.Bundle bundle2 = new PluginsService.Bundle(info2, pluginDir);
            mypluginDir,
            extensions = loader.loadExtensions(TestExtensionPoint.class);
        @Override
        bundles.add(bundle2);
                    "signature of constructor for extension ["
import java.net.URL;
            false
 * compatible open source license.
        // occurs the jar is deleted while the classloader is still open. However, on
        Path homeDir = createTempDir();
            mockLogAppender.addExpectation(
        @Override
            fake,
            public TestExtension() {}
            false
            "Plugin 3",
            "plugin2",
            "desc",
    public void testHiddenDirectories() throws IOException {
        );
    public void testJarHellDuplicateCodebaseWithDep() throws Exception {
            "1.0",
        TestExtensiblePlugin extensiblePlugin = new TestExtensiblePlugin();
        Path pluginJar = pluginDir.resolve("plugin.jar");
 */
                    "Missing optional plugin [dne], dependency of [foo]. Some features of this plugin may not function without the dependencies being installed."
            "plugin1",
            "1.0.0",
            Files.copy(jar, nonextensibleDir.resolve("plugin.jar"));
    public void testSortBundlesCycleSelfReference() throws Exception {
            "1.8",
        bundles.add(bundle3);
        PluginTestUtil.writePluginProperties(
        );
        TestPlugin plugin = new TestPlugin();
                )
                "1.0",
        assertThat(
                    testPlugin
        assertThat(
        assertThat(sortedBundles, Matchers.contains(bundle1, bundle2));
            fail("Expected exception when building updated settings");
    }
        // windows, files cannot be deleted when they are still open by a process.
    public static class TestExtension2 implements TestExtensionPoint {
        });
            "1.8",
            "version",
            Version.CURRENT,
        PluginsService.Bundle bundle3 = new PluginsService.Bundle(info3, pluginDir);
            "version",
                        + PluginsServiceTests.class.getClassLoader()
        PluginInfo info1 = new PluginInfo(
            "1.8",
        class TestExtension implements TestExtensionPoint {
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> newPluginsService(settings));
            "desc",
        PluginInfo info = new PluginInfo("foo", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.singletonList("foo"), false);
                )
            "1.8",
        final Path removing = home.resolve("plugins").resolve(".removing-fake");
            assertTrue(msg, msg.contains("Cannot have additional setting [foo.bar]"));
            "myplugin",
        try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("dummy-plugin.jar")) {
        }
        );
            "classname",
            "1.0",
        IllegalStateException e = expectThrows(
        PluginInfo info3 = new PluginInfo(
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.NIOFS.getSettingsKey())
        assertThat(extensiblePlugin.extensions, notNullValue());
            "MyPlugin",
        makeJar(dep2Jar, DummyClass3.class);
            "Plugin1",
        makeJar(dupJar, DummyClass2.class);
    public static class AdditionalSettingsPlugin1 extends Plugin {
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
            "description",
            )
    }
    public static class DummyClass1 {}
            "1.0.0",
 *    http://www.apache.org/licenses/LICENSE-2.0
            return Settings.builder()
                        + "])"
        );
            PluginsService.sortBundles(Collections.singleton(bundle));
            "description",
    }
            "classname",
        Files.createFile(fake.resolve("plugin.jar"));
    }
            this.plugin = plugin;
                    "Plugin [fake] must reference a class loader local Plugin class ["
        final Path fake = home.resolve("plugins").resolve("fake");
                )
                    Level.INFO,
            String msg = e.getMessage();
                )
            "foo",
        );
        Path plugin3Dir = pluginsDir.resolve("plugin3");
        PluginInfo info4 = new PluginInfo("other", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
        assertThat(e, hasToString(containsString(expected)));
            mockLogAppender.addExpectation(
            "fake",
    // Note: testing dup codebase with core is difficult because it requires a symlink, but we have mock filesystems and security manager
            "java.version",
        makeJar(pluginJar, Level.class);
        }
                )
        PluginsService.loadExtensions(
        PluginInfo info2 = new PluginInfo(
        IllegalStateException e = expectThrows(
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> PluginsService.getPluginBundles(pluginsDir));
        Path dep2Jar = dep2Dir.resolve("dep2.jar");
            "opensearch.version",
        makeJar(dupJar);
    }
            "1.8",
        public TooManyParametersConstructorExtension(String bad) {}
        makeJar(pluginJar, DummyClass1.class);
            false
            "desc",
                        + "]"
            "1.0",
        bundles.add(new PluginsService.Bundle(info2, pluginDir));
        // dir (a dummy plugin). Classloaders are closed by GC, so when test teardown
    public void testNonExtensibleDep() throws Exception {
                "1.0.0",
        bundles.add(bundle4);
            .build();
            Collections.singletonList("dep"),
        );
import org.opensearch.env.Environment;
        try (MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(LogManager.getLogger(PluginsService.class))) {
        Path pluginJar = pluginDir.resolve("plugin.jar");
            "base-plugin"
        final Settings settings = Settings.builder()
            )
            assertThat(PluginsService.findPluginDirs(plugins), containsInAnyOrder(fake));
        transitiveDeps.put("dep", Collections.singleton(dupJar.toUri().toURL()));
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> newPluginsService(settings));
        assertTrue(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("~1.0.1"), Version.fromString("1.0.2")));
            Version.CURRENT,
import org.opensearch.Version;
        Tuple<List<String>, List<String>> otherPluginDependents = PluginsService.findPluginsByDependency(pluginsDir, "other-plugin");
import org.hamcrest.Matchers;
        Path pluginDir = createTempDir();
        Set<URL> deps = transitiveDeps.get("myplugin");
            "MyPlugin",
                        ZipEntry entry = in.getNextEntry();
            "my_plugin",
    }
            )
            false
        Path pluginDir = createTempDir();
        );
        Set<PluginsService.Bundle> bundles = new LinkedHashSet<>(); // control iteration order
        Path otherDir = createTempDir();
import java.util.Collections;
        );
                if (relativePath.contains(PluginsServiceTests.class.getSimpleName())) {
        assertThat(e.getCause().getCause(), hasToString(containsString("test constructor failure")));
    public void testMultipleExtensionConstructors() {
            Files.copy(jar, fake.resolve("plugin.jar"));
        assertThat(e.getMessage(), containsString("was built for OpenSearch version "));
            "description",
        PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveDeps);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            @SuppressWarnings("unused")
            IllegalStateException.class,
                        + TestExtension.class.getName()
            "description",
        // This test opens a child classloader, reading a jar under the test temp
        Files.createDirectories(pluginsDir);
        RuntimeException exception = expectThrows(RuntimeException.class, () -> newPluginsService(settings));
    }
        );
        Set<URL> deps = transitiveDeps.get("myplugin");
        assertEquals("1", newSettings.get("foo.bar")); // added setting exists
                    "org.opensearch.plugins.PluginsService",
        final Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
        try {
                        }
        // need a jar file of core dep, use log4j here
            "1.8",
            "name",
            assertTrue(msg, msg.contains("plugin [" + AdditionalSettingsPlugin2.class.getName()));
        // Incompatible plugin and core versions
    public interface TestExtensionPoint {}
                containsString(
            Arrays.asList("dep1", "dep2"),
    public void testExistingPluginMissingDescriptor() throws Exception {
        PluginInfo info3 = new PluginInfo("baz", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
        List<PluginsService.Bundle> sortedBundles = PluginsService.sortBundles(bundles);
import org.opensearch.env.TestEnvironment;
            "1.8",
        final Path fake = plugins.resolve("fake");
            IllegalStateException.class,
            "name",
            "found file [%s] from a failed attempt to remove the plugin [fake]; execute [opensearch-plugin remove fake]",
        Path pluginsDir = tempDir.resolve("plugins");
            PluginsService.Bundle bundle = new PluginsService.Bundle(info, pluginDir);
            "1.8",
            )
        assertThat(extensiblePlugin.extensions.get(0), instanceOf(TestExtension1.class));
    public void testCompatibleOpenSearchVersionRange() {
                            entry = in.getNextEntry();
            "1.0",
            );
        transitiveDeps.put("dep2", Collections.singleton(dep2Jar.toUri().toURL()));
        assertEquals("test", newSettings.get("my.setting")); // previous settings still exist
            final IllegalStateException e = expectThrows(IllegalStateException.class, () -> newPluginsService(settings, pluginClass));
        Path dep2Jar = dep2Dir.resolve("dep2.jar");
        IllegalStateException exception = expectThrows(IllegalStateException.class, () -> newPluginsService(settings));
            "Plugin 1",
            "1.0.0",
import java.io.IOException;
    public void testIncompatibleOpenSearchVersionRange() {
        Files.createDirectories(hidden);
    public void testLoadPluginWithNoPublicConstructor() {
        PluginInfo info2 = new PluginInfo(
        final Path plugins = pathHome.resolve("plugins");
        );
            "desc",
        }
        }
                        + "] of type ["
        );
                String relativePath = clazz.getCanonicalName().replaceAll("\\.", "/") + ".class";
            )
        Path pluginDir = createTempDir();
        final Path fake = plugins.resolve("fake");
                "description",
        final Path pathHome = createTempDir();
        TestPlugin plugin = new TestPlugin();
        List<SemverRange> pluginCompatibilityRange = List.of(new SemverRange(Version.CURRENT, SemverRange.RangeOperator.TILDE));
 * this work for additional information regarding copyright
        TestPlugin plugin = new TestPlugin();
                        + TestExtensionPoint.class.getName()
    public void testSortBundlesNoDeps() throws Exception {
            final Path home = createTempDir();
        Map<String, Set<URL>> transitiveDeps = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor
        PluginInfo info1 = new PluginInfo("myplugin", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
        Settings newSettings = service.updatedSettings();
        assertThat(extensiblePlugin.extensions, hasSize(2));
            "false"
            "MyPlugin",
        assertTrue(otherPluginDependents.v2().isEmpty());
        extensiblePlugin = new TestExtensiblePlugin();
                            }
                        + "] must be either () or ("
import java.nio.file.Files;
        );
                        + "] of type ["
            "version",
    }
        IllegalStateException e = expectThrows(
            "whatever",
            IllegalArgumentException.class,
            "myplugin",
            "desc",
            "opensearch.version",
        final Path home = createTempDir();
        class OneParameterIncorrectType extends Plugin {
        PluginsService.verifyCompatibility(info);
            Collections.singletonList("baz"),
        }
import java.util.zip.ZipEntry;
        PluginInfo info1 = new PluginInfo(
        assertThat(otherPluginDependents.v1(), containsInAnyOrder("plugin2", "plugin3"));
        assertEquals("failed to load plugin myplugin due to jar hell", e.getMessage());
            .build();
 * under the License.
            Collections.singletonList("dep"),
        assertThat(deps, containsInAnyOrder(pluginJar.toUri().toURL(), dep1Jar.toUri().toURL(), dep2Jar.toUri().toURL()));
            Version.CURRENT,
 * GitHub history for details.
import static org.hamcrest.Matchers.hasSize;
            Version.CURRENT,
            "classname",
                    // copy from dir, and use a different canonical path to not conflict with test classpath
        // does not override pre existing settings
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
            "1.8",
    public void testExistingMandatoryClasspathPlugin() {
            Version.CURRENT.toString(),
            "FakePlugin",
        ); // set a class defined outside the bundle (in parent class-loader of plugin)
            Version.CURRENT,
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> newPluginsService(settings));
            mockLogAppender.assertAllExpectationsMatched();
import java.lang.reflect.InvocationTargetException;
            "desc",
            "java.version",
        Set<PluginsService.Bundle> bundles = new LinkedHashSet<>(); // control iteration order
            "opensearch.version",
                        + "]"
            Files.copy(jar, mypluginDir.resolve("plugin.jar"));
            "1.0",
            "description",
        );
            @SuppressWarnings("unused")
        class TestExtension implements TestExtensionPoint {
        assertNotNull(deps);
        assertFalse(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("=1.0.0"), Version.fromString("1.0.1")));
        Path depJar = depDir.resolve("dep.jar");
            Version.CURRENT.toString(),
        final Path plugins = pathHome.resolve("plugins");
                    out.putNextEntry(new ZipEntry("test/" + clazz.getSimpleName() + ".class"));
            "1.8",
            () -> PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, new HashMap<>())
        final Collection<Class<? extends Plugin>> classes = Arrays.asList(
    }
        });
 */
import static org.hamcrest.Matchers.containsInAnyOrder;
            Version.CURRENT,
        assertThat(e.getMessage(), containsString("my_plugin requires Java"));
                        while (entry != null) {
    }
            service.updatedSettings();
            "name",
    public static class AdditionalSettingsPlugin2 extends Plugin {
                        + String.class.getName()
        );
    public void testPluginFromParentClassLoader() throws IOException {
                "java.version",
            Version.fromString("1.0.0"),
import java.util.List;
                                    out.write(buffer, 0, read);
            "nonextensible",
        Path pluginDir = createTempDir();
        assumeFalse("windows deletion behavior is asinine", Constants.WINDOWS);
            @SuppressWarnings("unused")
        class MultiplePublicConstructorsPlugin extends Plugin {
            "description",
                Collections.singletonList("dne;optional=true"),
            "my_plugin",
                    extensiblePlugin
        assertThat(
    }
        assertThat(e.getMessage(), containsString("was built for OpenSearch version 1.0.0"));
        try (MockLogAppender mockLogAppender = MockLogAppender.createForLoggers(LogManager.getLogger(PluginsService.class))) {
                "opensearch.version",
            "opensearch.version",
            Arrays.asList("dep1", "dep2"),
        transitiveDeps.put("dep1", Collections.singleton(dep1Jar.toUri().toURL()));
                                byte[] buffer = new byte[10 * 1024];
            "myplugin",
    }
                false
        Path plugin2Dir = pluginsDir.resolve("plugin2");
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
            "name",
        PluginsService.Bundle bundle = new PluginsService.Bundle(info, pluginDir);
        assertThat(e.getCause().getMessage(), containsString("jar hell!"));
        final Path pathHome = createTempDir();
                        + "] of type ["
    }
                containsString(
            false
        // Compatible plugin and core versions
                )
            IllegalStateException.class,
        public BadSingleParameterConstructorExtension(String bad) {}
    public static class TooManyParametersConstructorExtension implements TestExtensionPoint {
        assertTrue(basePluginDependents.v2().isEmpty());
                )
        assertThat(extensiblePlugin.extensions, hasSize(0));
        PluginInfo info2 = new PluginInfo("bar", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
        List<ScriptPlugin> scriptPlugins = service.filterPlugins(ScriptPlugin.class);
        class TwoParametersSecondIncorrectType extends Plugin {
    }
                        + "] of type ["
            "myplugin",
            "java.version",
            "MyPlugin",
                "fake",
        List<PluginsService.Bundle> sortedBundles = PluginsService.sortBundles(bundles);
            () -> PluginsService.sortBundles(Collections.singleton(bundle))
                if (codebase.toString().endsWith(".jar")) {
        }
            @SuppressWarnings("unused")
        PluginTestUtil.writePluginProperties(
        final Path home = createTempDir();
            Version.CURRENT,
    public void testSortBundlesMissingOptionalDep() throws Exception {
            private NoPublicConstructorPlugin() {
            public TwoParametersFirstIncorrectType(Object object, Path configPath) {
    public void testExistingMandatoryInstalledPlugin() throws IOException {
            "plugin3",
        assertThat(extensiblePlugin.extensions.get(1), instanceOf(TestExtension2.class));
        );
import static org.hamcrest.Matchers.instanceOf;
            "java.version",
            )
        assertThat(e, hasToString(containsString(expected)));
            Collections.emptyList(),
        PluginInfo info1 = new PluginInfo(
            }
            "classname",
        PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveDeps);
import java.util.Arrays;
        assertFalse(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("~1.0.1"), Version.fromString("1.0.0")));
                    relativePath = relativePath.replace("/" + clazz.getSimpleName(), "$" + clazz.getSimpleName());
import org.opensearch.index.IndexModule;
        TestPlugin plugin = new TestPlugin();
            "name",
            Version.CURRENT.toString(),
        );
        bundles.add(bundle2);
            "extended.plugins",
import static org.hamcrest.Matchers.hasToString;
        }
            () -> newPluginsService(settings, NoPublicConstructorPlugin.class)
            "classname",
import java.nio.file.Path;
/*
            "fake",
                ),
            "MyPlugin",
            "desc",
            "fake",
 * SPDX-License-Identifier: Apache-2.0
                containsString(
@LuceneTestCase.SuppressFileSystems(value = "ExtrasFS")
                "version",
            hasToString(
        assertTrue(exception.getCause() instanceof ClassNotFoundException);
            Version.CURRENT.toString(),
            }
import org.apache.lucene.tests.util.LuceneTestCase;
    public void testLoadPluginWithMultiplePublicConstructors() {
                fake,
            Collections.singletonList("foo"),
        assertThat(sortedBundles, Matchers.contains(bundle1, bundle4, bundle2, bundle3));
        PluginsService service = newPluginsService(settings, AdditionalSettingsPlugin1.class, FilterablePlugin.class);
        PluginTestUtil.writePluginProperties(
            "test.DummyPlugin"
                        + "), not ("
        // dir (a dummy plugin). Classloaders are closed by GC, so when test teardown
                "test.DummyPlugin"
            IllegalStateException.class,
                Files.copy(jar, fake.resolve("plugin.jar"));
        assertThat(e.getCause().getMessage(), containsString("DummyClass2"));
                        + ThrowingConstructorExtension.class.getName()
            }
        }
    public void testExtensiblePlugin() {
            () -> newPluginsService(settings, MultiplePublicConstructorsPlugin.class)
    }
    public void testFindPluginsByDependency() throws Exception {
        Path pluginDir = createTempDir();
            "version",
        PluginInfo info = new PluginInfo("foo", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
                    "signature of constructor for extension ["
            false
            false
        Path pluginDir = createTempDir();
            "1.0",
            Version.CURRENT,
            "1.0",
        Path pluginDir = createTempDir();
            pluginCompatibilityRange,
import org.apache.logging.log4j.Level;
                "name",
        PluginTestUtil.writePluginProperties(
            "has.native.controller",
            PluginsService.createExtension(TooManyParametersConstructorExtension.class, TestExtensionPoint.class, plugin);
            "java.version",
    public static class TestExtension1 implements TestExtensionPoint {}
    public static class FilterablePlugin extends Plugin implements ScriptPlugin {}
            Path pluginDir = createTempDir();
            "description",
        // occurs the jar is deleted while the classloader is still open. However, on
public class PluginsServiceTests extends OpenSearchTestCase {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
            "1.8",
        public void loadExtensions(ExtensionLoader loader) {
        // Version.CURRENT is behind by one with respect to patch version in the range
            "java.version",
                    "org.opensearch.plugins.PluginsService",
            private TestExtension() {}
                    try (ZipInputStream in = new ZipInputStream(Files.newInputStream(codebase))) {
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), homeDir).build();
            "test.NonExtensiblePlugin"
    }
            () -> PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveDeps)
                "description",
        public ThrowingConstructorExtension() {
            "MyPlugin",
            .put("my.setting", "test")
            "MyPlugin",
    }
 * specific language governing permissions and limitations
import org.apache.logging.log4j.LogManager;
        final IllegalStateException e = expectThrows(
        PluginInfo info2 = new PluginInfo(
        assertNotNull(deps);
            }
        Path dep1Dir = createTempDir();
        assertEquals("failed to load plugin myplugin due to jar hell", e.getMessage());
        PluginsService.Bundle bundle1 = new PluginsService.Bundle(info1, pluginDir);
                        + ")"
        assertEquals("Cycle found in plugin dependencies: foo -> foo", e.getMessage());
            plugin1Dir,
            final Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
                Path codebase = PathUtils.get(clazz.getProtectionDomain().getCodeSource().getLocation().toURI());
        );
        Path pluginDir = createTempDir();
        Path nonextensibleDir = pluginsDir.resolve("nonextensible");
        transitiveDeps.put("dep2", Collections.singleton(dep2Jar.toUri().toURL()));
        );
    }
            "extended.plugins",
            "1.0",
        );
                        + BadSingleParameterConstructorExtension.class.getName()
            fake,
        assertThat(sortedBundles, Matchers.contains(bundle));
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
            TwoParametersFirstIncorrectType.class,
            IllegalStateException.class,
            "FakePlugin",
            Version.CURRENT.toString(),
    public void testSortBundlesCommonDep() throws Exception {
            Version.CURRENT,
            Version.CURRENT.toString(),
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> PluginsService.sortBundles(bundles));
                                while (read != -1) {
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
        private List<TestExtensionPoint> extensions;
            fake,
        public Settings additionalSettings() {
        final Path plugins = pathHome.resolve("plugins");
            "1.0",
    public void testJarHellDuplicateClassAcrossDeps() throws Exception {
            "opensearch.version",
            hasToString(
            "description",
        );
            final Path fake = plugins.resolve("fake");
                "1.8",
        List<PluginsService.Bundle> sortedBundles = PluginsService.sortBundles(bundles);
    }
    }
            "Plugin3",
        assertThat(sortedBundles, Matchers.contains(bundle1, bundle2, bundle3));
            "nonextensible",
        );
        PluginTestUtil.writePluginProperties(
            )
        Path depDir = createTempDir();
            "1.8",
            "classname",
            "base-plugin,other-plugin"
        Tuple<List<String>, List<String>> basePluginDependents = PluginsService.findPluginsByDependency(pluginsDir, "base-plugin");
            pluginCompatibilityRange,
import java.util.zip.ZipOutputStream;
            expectThrows(UnsupportedOperationException.class, () -> extensions.add(new TestExtension1()));
        );
                )
        assertThat(e.getMessage(), containsString("Could not load plugin descriptor for plugin directory [plugin-missing-descriptor]"));
        bundles.add(bundle1);
            // verify unmodifiable.
            Collections.singletonList("common"),
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir())
            return Settings.builder().put("foo.bar", "2").build();
        );
        @Override
            System.getProperty("java.specification.version"),
            "1.8",
        bundles.add(new PluginsService.Bundle(info3, pluginDir));
        final Path home = createTempDir();
            PluginsService.createExtension(BadSingleParameterConstructorExtension.class, TestExtensionPoint.class, plugin);
            () -> PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveDeps)
            );
            "version",
        // windows, files cannot be deleted when they are still open by a process.
                }
    }
            System.getProperty("java.specification.version"),
                    "[.test] warning",
            System.getProperty("java.specification.version"),
    }
import static org.hamcrest.Matchers.notNullValue;
        assertThat(e.getCause(), instanceOf(InvocationTargetException.class));
            )
import org.opensearch.semver.SemverRange;
            "my_plugin",
            "1000000",
            "classname",
        final Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
    }
    }
            "1.0",
                    "no public constructor for extension ["
        Path mypluginDir = pluginsDir.resolve("myplugin");
        newPluginsService(settings);
import java.util.Set;
            public TooManyParametersPlugin(Settings settings, Path configPath, Object object) {
        assertFalse(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("1.0.0"), Version.fromString("1.0.1")));
        assertEquals("Missing plugin [dne], dependency of [foo]", e.getMessage());
        Path pluginJar = pluginDir.resolve("plugin.jar");
        assertThat(((TestExtension2) extensiblePlugin.extensions.get(1)).plugin, sameInstance(testPlugin));
            "description",
            }
            "DummyClass"
        });
    public void testAdditionalSettingsClash() {
        PluginInfo info = new PluginInfo(
import org.opensearch.test.MockLogAppender;
        assertThat(e.getCause().getMessage(), containsString("jar hell!"));
            false
        );
    void makeJar(Path jarFile, Class... classes) throws Exception {
            Collections.emptyList(),
        bundles.add(new PluginsService.Bundle(info4, pluginDir));
import java.util.zip.ZipInputStream;
            "fake",
            public MultiplePublicConstructorsPlugin() {
            "1.0.0",
    public void testSortBundlesMissingRequiredDep() throws Exception {
            "baz",
                        + "]"
        PluginsService.Bundle bundle2 = new PluginsService.Bundle(info2, pluginDir);
        Settings settings = Settings.builder()
            public OneParameterIncorrectType(Object object) {
            "myplugin",
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
    }
 * license agreements. See the NOTICE file distributed with
            "test.DummyPlugin"
        assertThat(e, hasToString(containsString("no unique public constructor")));
            "1.8",
        public Plugin plugin;
            List.of(SemverRange.fromString(semverRange)),
            "version",
        Files.createDirectories(fake);
                containsString(
            );
        PluginInfo info1 = new PluginInfo(
        final Settings settings = Settings.builder().put("path.home", pathHome).put("plugin.mandatory", "fake").build();
            assertTrue(msg, msg.contains("plugin [" + AdditionalSettingsPlugin1.class.getName()));
        assertThat(e.getCause().getCause(), instanceOf(IllegalArgumentException.class));
        makeJar(dep1Jar, DummyClass2.class);
                } else {
            "desc",
        makeJar(pluginJar, DummyClass1.class);
        );
        );
        assertTrue(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("=1.0.0"), Version.fromString("1.0.0")));
        class TooManyParametersPlugin extends Plugin {
import static org.hamcrest.Matchers.containsString;
            null,
        List<PluginsService.Bundle> sortedBundles = PluginsService.sortBundles(Collections.singleton(bundle));
                "foo",
            e,
            false
            @SuppressWarnings("unused")
            "FakePlugin",
            "desc",
            "fake",
            Files.createFile(testFile);
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> PluginsService.verifyCompatibility(info));
            "1.0",
            "java.version",
        );
 * software distributed under the License is distributed on an
        assertTrue(nonExistentDependents.v2().isEmpty());
        // Verify the transitive URLs were correctly populated
                    "no unique public constructor for extension ["
        PluginInfo info3 = new PluginInfo(
            "Plugin2",
            null,
        Path plugin1Dir = pluginsDir.resolve("plugin1");
        PluginInfo info1 = new PluginInfo("grandparent", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
            "MyPlugin",
 */
            "1.8",
        );
        }
            false
        try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("non-extensible-plugin.jar")) {
                    new PluginInfo("test", null, null, Version.CURRENT, null, null, Collections.singletonList("extensible"), false),
                    "failed to create extension ["
                .put("foo.bar", "1")
        }
    public void testFilterPlugins() {
        }
                    new PluginInfo("extensible", null, null, Version.CURRENT, null, null, Collections.emptyList(), false),
        bundles.add(bundle1);
        final Path home = createTempDir();
    }
        assertThat(exception, hasToString(containsString("Unable to load plugin class [DummyClass]")));
    public static class DummyClass2 {}
        Set<PluginsService.Bundle> bundles = new LinkedHashSet<>(); // control iteration order, so we get know the beginning of the cycle
        IllegalArgumentException e = expectThrows(
    }
        PluginInfo info = new PluginInfo(
        IllegalStateException e = expectThrows(
        transitiveDeps.put("dep2", Collections.singleton(dupJar.toUri().toURL()));
                                    read = in.read(buffer);
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginsService.verifyCompatibility(info));
    }
        }
                out.closeEntry();
            System.getProperty("java.specification.version"),
        final Path hidden = home.resolve("plugins").resolve(".hidden");
            }
        transitiveDeps.put("dep1", Collections.singleton(dep1Jar.toUri().toURL()));
        Path dep1Jar = dep1Dir.resolve("dep1.jar");
                                break;
        PluginsService.Bundle bundle1 = new PluginsService.Bundle(info1, pluginDir);
            "1.0.0",
            Collections.emptyList(),
    }
            "1.8",
    public void testAdditionalSettings() {
        bundles.add(bundle1);
            .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.NIOFS.getSettingsKey())
            "extended.plugins",
            false
        });
    public static class ThrowingConstructorExtension implements TestExtensionPoint {
            Collections.emptyList(),
                    }
            public MultiplePublicConstructorsPlugin(final Settings settings) {
                        + TestPlugin.class.getName()
                Version.CURRENT.toString(),
    }
    }
            removing
            "1.0",
            fake,
            try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("dummy-plugin.jar")) {
            PluginTestUtil.writePluginProperties(
        assertEquals("Plugin [myplugin] cannot extend non-extensible plugin [nonextensible]", e.getMessage());
                )
    }
            IllegalStateException.class,
                        + TestExtensionPoint.class.getName()
        return new PluginInfo(
        PluginTestUtil.writePluginProperties(
            "desc",
        Path tempDir = createTempDir();
 * The OpenSearch Contributors require contributions made to
        IllegalStateException e = expectThrows(
                        + ")"
        bundles.add(bundle3);
            e,
        }
        assertThat(
            false
import org.opensearch.common.io.PathUtils;
                        + TooManyParametersConstructorExtension.class.getName()
                Tuple.tuple(
        );
        assertTrue(nonExistentDependents.v1().isEmpty());
            "my_plugin",
                        + TestExtensionPoint.class.getName()
        Files.createFile(removing);
            throw new IllegalArgumentException("test constructor failure");
        Path dep1Jar = dep1Dir.resolve("dep1.jar");
        PluginInfo info = new PluginInfo("foo", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.singletonList("dne"), false);
            "desc",
        assertThat(e.getCause().getMessage(), containsString("DummyClass1"));
            false
        Path dupJar = otherDir.resolve("dup.jar");
            new SemverRange(
            "desc",
        bundles.add(bundle2);
            "name",
        class TwoParametersFirstIncorrectType extends Plugin {
            "FakePlugin",
            .put("path.home", createTempDir())
    public void testLoadPluginWithNoPublicConstructorOfCorrectSignature() {
        );
        Path pluginsDir = createTempDir();
            PluginsService.createExtension(TestExtension.class, TestExtensionPoint.class, plugin);
            "version",
        );
        TestPlugin testPlugin = new TestPlugin();
        Path dep1Dir = createTempDir();
        public TestExtension2(TestPlugin plugin) {
    }
        }
            "opensearch.version",
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
        assertThat(e.getCause().getMessage(), containsString("jar hell!"));
    }
            )
        PluginsService.Bundle bundle = new PluginsService.Bundle(info, pluginDir);
            "desc",
                new MockLogAppender.SeenEventExpectation(
                    new PluginInfo("extensible", null, null, Version.CURRENT, null, null, Collections.emptyList(), false),
        try (InputStream jar = PluginsServiceTests.class.getResourceAsStream("dummy-plugin.jar")) {
            assert extensions == null;
            Collections.singletonList("grandparent"),
        PluginsService.Bundle bundle3 = new PluginsService.Bundle(info3, pluginDir);
            "1.0.0",
            OneParameterIncorrectType.class
            e,
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> PluginsService.verifyCompatibility(info));
        PluginInfo info1 = new PluginInfo(
            }
            Collections.singletonList(
            "1.8",
        PluginsService.loadExtensions(
            "1.0",
            @SuppressWarnings("unused")
            "Plugin 2",
            "desc",
        Path pluginDir = createTempDir();
    }
        Map<String, Set<URL>> transitiveDeps = new HashMap<>();
        assertThat(
                    "[.test] info",
                .put(IndexModule.INDEX_STORE_TYPE_SETTING.getKey(), IndexModule.Type.MMAPFS.getSettingsKey())
            "extended.plugins",
            Collections.emptyList(),
        TestPlugin plugin = new TestPlugin();
        makeJar(dep2Jar, DummyClass2.class);
            e,
    public static class FakePlugin extends Plugin {
            "version",
    }
        Path dep2Dir = createTempDir();
        assertTrue(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("~1.0.0"), Version.fromString("1.0.0")));
    }
        PluginInfo info1 = new PluginInfo("dep", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
        final IllegalStateException e = expectThrows(
        assertEquals("Cycle found in plugin dependencies: foo -> bar -> baz -> foo", e.getMessage());
        final Path plugins = createTempDir();
                        + "] must be either () or ("
            () -> PluginsService.sortBundles(Collections.singleton(bundle))
            }
                new MockLogAppender.SeenEventExpectation(
    public void testPluginCompatibilityWithSemverRange() {
                Tuple.tuple(
    public void testJarHellDuplicateCodebaseAcrossDeps() throws Exception {
import org.opensearch.test.OpenSearchTestCase;
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
        assertEquals(1, scriptPlugins.size());
        assumeFalse("windows deletion behavior is asinine", Constants.WINDOWS);
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.plugins;
            .put("plugin.mandatory", "org.opensearch.plugins.PluginsServiceTests$FakePlugin")
            "1.0",
                    out.putNextEntry(new ZipEntry(relativePath));
            public TestExtension(TestPlugin plugin) {
                        + TestPlugin.class.getName()
            "java.version",
        Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
                "MyPlugin",
        List<SemverRange> pluginCompatibilityRange = List.of(
        return new PluginsService(settings, null, TestEnvironment.newEnvironment(settings).pluginsDir(), Arrays.asList(classpathPlugins));
        PluginInfo info = new PluginInfo(
        Path pluginJar = pluginDir.resolve("plugin.jar");
            "opensearch.version",
        bundles.add(new PluginsService.Bundle(info, pluginDir));
        Path dupJar = pluginDir.resolve("dup.jar");
        Map<String, Set<URL>> transitiveDeps = new HashMap<>();
        assertTrue(PluginsService.isPluginVersionCompatible(getPluginInfoWithWithSemverRange("1.0.0"), Version.fromString("1.0.0")));
            false
            "common",
        makeJar(pluginJar, DummyClass1.class);
            "1.8",
            "1.0",
    }
    public void testBadSingleParameterConstructor() {
                            in.closeEntry();
import org.apache.lucene.util.Constants;
            mockLogAppender.assertAllExpectationsMatched();
        Settings settings = Settings.builder()
    public void testIncompatibleOpenSearchVersion() throws Exception {
            Version.CURRENT,
            "classname",
            Locale.ROOT,
                        + TestPlugin.class.getName()
    }
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
        assertEquals(IndexModule.Type.NIOFS.getSettingsKey(), newSettings.get(IndexModule.INDEX_STORE_TYPE_SETTING.getKey()));
        final Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
        PluginsService.Bundle bundle1 = new PluginsService.Bundle(info1, pluginDir);
            Version.CURRENT.toString(),
            for (Class clazz : classes) {
                        + "] of type ["
        );
    }
 * not use this file except in compliance with the License.
            "opensearch.version",
        );
        Map<String, Set<URL>> transitiveDeps = new HashMap<>();
        PluginInfo info4 = new PluginInfo(
    public static class TestPlugin extends Plugin {}
        assertThat(basePluginDependents.v1(), containsInAnyOrder("plugin1", "plugin2"));
        class NoPublicConstructorPlugin extends Plugin {
            "desc",
import static org.hamcrest.Matchers.sameInstance;
        assertEquals("failed to load plugin myplugin due to jar hell", e.getMessage());
    public void testStartupWithRemovingMarker() throws IOException {
            "myplugin",
    public void testTooManyParametersExtensionConstructors() {
    }
        );
        Map<String, Set<URL>> transitiveDeps = new HashMap<>();
        IllegalStateException e = expectThrows(IllegalStateException.class, () -> {
            "description",
                )
            "MyPlugin",
        public Settings additionalSettings() {
            "Fake",
        PluginInfo info = new PluginInfo("foo", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Arrays.asList("bar", "other"), false);
 * Unless required by applicable law or agreed to in writing,
            Collections.singletonList("dep"),
    public void testThrowingConstructor() {
            Arrays.asList(
    }
    public void testPluginLoadFailure() throws IOException {
                        + TestExtension.class.getName()
import java.util.Map;
        final Path fake = plugins.resolve("fake");
    public void testJarHellDuplicateClassWithCore() throws Exception {
    }
                    Level.WARN,
        Path pluginJar = pluginDir.resolve("plugin.jar");
        PluginTestUtil.writePluginProperties(
        PluginInfo info = new PluginInfo(
            Collections.singletonList("common"),
                    extensiblePlugin
import java.io.InputStream;
        newPluginsService(settings, FakePlugin.class);
import org.opensearch.common.bootstrap.JarHell;
        }
 * this file be licensed under the Apache-2.0 license or a
            }
        PluginsService.Bundle bundle4 = new PluginsService.Bundle(info4, pluginDir);
        Set<PluginsService.Bundle> bundles = new LinkedHashSet<>(); // control iteration order
            "description",
    public void testIncompatibleJavaVersion() throws Exception {
        PluginsService.Bundle bundle = new PluginsService.Bundle(info1, pluginDir);
            e,
    }
        );
                        + TestExtensionPoint.class.getName()
        assertThat(e.getCause().getMessage(), containsString("jar hell! duplicate codebases with extended plugin"));
            Version.CURRENT.toString(),
            "1.0",
        final Settings settings = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), home).build();
            IllegalStateException.class,
            "MyPlugin",
            "bar",
            public TwoParametersSecondIncorrectType(Settings settings, Object object) {
            hasToString(
                SemverRange.RangeOperator.TILDE
            "FakePlugin",
import java.util.Collection;
            "name",
import org.opensearch.test.VersionUtils;
            PluginInfo info = new PluginInfo(
        } catch (IllegalArgumentException e) {
        Path pluginsDir = homeDir.resolve("plugins");
            "1.0",
    }
        PluginsService.Bundle bundle = new PluginsService.Bundle(info, pluginDir);
        assertThat(e, hasToString(containsString("no public constructor")));
                "classname",
        });
    }
                "desc",
        );
import java.util.HashMap;
 * KIND, either express or implied.  See the License for the
        PluginInfo info1 = new PluginInfo("foo", "desc", "1.0", Version.CURRENT, "1.8", "MyPlugin", Collections.emptyList(), false);
            hasToString(
    public void testFindPluginDirs() throws Exception {
            "1.0",
    public void testJarHellTransitiveMap() throws Exception {
        Tuple<List<String>, List<String>> nonExistentDependents = PluginsService.findPluginsByDependency(pluginsDir, "non-existent");
 * Modifications Copyright OpenSearch Contributors. See
        PluginsService.Bundle bundle2 = new PluginsService.Bundle(info2, pluginDir);
            () -> PluginsService.checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveDeps)
        final Settings settings = Settings.builder().put("path.home", pathHome).put("plugin.mandatory", "fake").build();
            Version.CURRENT.toString(),
            PluginsService.createExtension(TestExtension.class, TestExtensionPoint.class, plugin);
            "MyPlugin",
    }
            );
        Path pluginDir = createTempDir();
                .build();
        makeJar(depJar, DummyClass1.class);
        );
            "java.version",
        assertThat(extensiblePlugin.extensions, notNullValue());
    }
                    "Non-plugin file located in the plugins folder with the following name: [.DS_Store]"
        makeJar(pluginJar, DummyClass1.class);
}
            .build();
            "opensearch.version",
            "myplugin",
            Version.CURRENT,
import org.opensearch.common.settings.Settings;
                                }
            "description",
        assertThat(deps, containsInAnyOrder(pluginJar.toUri().toURL(), dupJar.toUri().toURL()));
 * the Apache License, Version 2.0 (the "License"); you may
        Path pluginDir = createTempDir();
            null,
        Path dep2Dir = createTempDir();
            false
