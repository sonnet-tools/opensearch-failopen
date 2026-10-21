        List<String> mandatoryPlugins = MANDATORY_SETTING.get(settings);
import org.opensearch.action.admin.cluster.node.info.PluginsAndModules;
                        "Cannot have additional setting ["
     * @param rootPath the path where the plugins are installed
     */
        logger.info("PluginService:onIndexModule index:" + indexModule.getIndex());
        List<Tuple<PluginInfo, Plugin>> pluginsLoaded = new ArrayList<>();
    ) {
            throw new IllegalStateException("failed to load plugin class [" + pluginClass.getName() + "]", e);
 * Licensed to Elasticsearch under one or more contributor
    }
        /*
        Map<String, Bundle> bundles,
            if (maybeFeature.isPresent()) {
    }
            "(org.opensearch.common.settings.Settings)",
                pluginsList.add(pluginInfo);
import java.util.ArrayList;
            Bundle depBundle = bundles.get(dependency);
        Set<Bundle> bundles = getPluginBundles(pluginsDir);
                        + "] must reference a class loader local Plugin class ["
}
        final List<String> pluginsNames = new ArrayList<>();
        this.configPath = configPath;
import org.opensearch.threadpool.ExecutorBuilder;
            }
public class PluginsService implements ReportingService<PluginsAndModules> {
        if (constructor.getParameterCount() > 1) {
        Map<String, String> foundSettings = new HashMap<>();
        }
    /**
        }
        Map<String, Bundle> namedBundles = bundles.stream().collect(Collectors.toMap(b -> b.plugin.getName(), Function.identity()));
                    continue;
        if (mandatoryPlugins.isEmpty() == false) {
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
                        + "])"
            Locale.ROOT,
            }
    public List<Setting<?>> getPluginSettings() {
    /**
                    + " but version "
                return (Plugin) constructor.newInstance(settings, configPath);
        String name = bundle.plugin.getName();
            final Plugin plugin = loadBundle(bundle, loaded, libLoaders);
        // depend on internal implementation classes of the plugin they extend.
        List<Module> modules = new ArrayList<>();
    private static <T> List<? extends T> createExtensions(Class<T> extensionPointType, Plugin plugin) {
        final Settings.Builder builder = Settings.builder();
     * Extracts all installed plugin directories from the provided {@code rootPath}.
/*
            ClassLoader extLoader = libLoaders.getOrDefault(extendedPluginName, extendedPlugin.getClass().getClassLoader());
        if (constructors.length > 1) {
    }
        final ArrayList<ExecutorBuilder<?>> builders = new ArrayList<>();
            info = PluginInfo.readFromProperties(plugin);
            throw new IllegalStateException(signatureMessage(pluginClass));
                    if ("lib".equals(plugin.getFileName().toString()) && Files.isDirectory(plugin)) {
    }
        return plugins;
                    if (bundle.plugin.isExtendedPluginOptional(extendedPlugin)) {
        for (SemverRange range : pluginInfo.getOpenSearchVersionRanges()) {
                final Path removing = iterator.next();
                    p -> new PluginInfo(
            builder.put(TransportSettings.FEATURE_PREFIX + "." + feature, true);
                            libUrls.add(url);
                    URL url = jar.toRealPath().toUri().toURL();
                for (Path plugin : stream) {
                        + pluginClass.getClassLoader()
    }
        return modules;
                    }
        if (dependencyStack.contains(name)) {
        Path candidateDir,
                );
            if (loader != pluginClass.getClassLoader()) {
        // create a child to load the plugin in this bundle
        }
        } finally {
                        pluginsNames.add(bundle.plugin.getName());
import org.opensearch.common.settings.Settings;
        List<Tuple<PluginInfo, Plugin>> loaded = loadBundles(seenBundles);
    }
        final Map<String, String> features = new TreeMap<>();
        }
    private static void loadExtensionsForPlugin(ExtensiblePlugin extensiblePlugin, List<Plugin> extendingPlugins) {
                throw new IllegalStateException(
     */
            + " must be either () or ("
 * You may obtain a copy of the License at
            "(org.opensearch.common.settings.Settings,java.nio.file.Path)",
import java.util.stream.Collectors;
import org.opensearch.core.common.Strings;
        PluginInfo candidateInfo,
                "Plugin ["
     *
        Map<String, Plugin> loaded = new HashMap<>();
import org.opensearch.index.IndexModule;
            extendedLoaders.add(extLoader);
        }
    // package-private for test visibility
            }
     */
        extensiblePlugin.loadExtensions(extensionLoader);
            }
            if (!missingPlugins.isEmpty()) {
        for (String extendedPluginName : bundle.plugin.getExtendedPlugins()) {
        if (constructors.length > 1) {
    static List<Bundle> sortBundles(Set<Bundle> bundles) {
    private Plugin loadBundle(Bundle bundle, Map<String, Plugin> loaded, Map<String, ClassLoader> libLoaders) {
    private List<Tuple<PluginInfo, Plugin>> loadBundles(Set<Bundle> bundles) {
                assert pluginUrls != null : "transitive urls should have already been set for " + extendedPlugin;
    private static final Logger logger = LogManager.getLogger(PluginsService.class);
    /** Get bundles for plugins installed in the given plugins directory. */
            public <T> List<T> loadExtensions(Class<T> extensionPointType) {
     * This sort is stable, so that if two plugins do not have any interdependency,
        if (constructor.getParameterCount() > 2) {
        if (!isPluginVersionCompatible(info, Version.CURRENT)) {
 * Unless required by applicable law or agreed to in writing,
                        + name
        }
        // first we load plugins that are on the classpath. this is for tests
                Class<? extends Plugin> pluginClazz = (Class<? extends Plugin>) Class.forName(pluginInfo.getClassname());
    // package-private for test visibility
            }
                    }
        Collection<Class<? extends Plugin>> classpathPlugins
            );
import java.util.Objects;
        return true;
    @SuppressWarnings("removal")
            try {
            if (iterator.hasNext()) {
                    throw new IllegalArgumentException(
                }
                JarHell.checkJarHell(urls, logger::debug); // check jarhell as we add each extended plugin's urls
                features.put(feature, plugin.v1().getName());
        for (PluginInfo pluginInfo : classpathPlugins) {
            Set<URL> urls = new HashSet<>();
        Set<URL> classpath,
                }
                loadExtensionsForPlugin(
 */
        );
        LinkedHashSet<Bundle> sortedBundles,
        Path modulesDirectory,
        Map<String, Set<URL>> transitiveUrls = new HashMap<>();
            Thread.currentThread().setContextClassLoader(cl);
            );
            // opensearch-plugin installs shared library jars there when a plugin zip
            }
        public int hashCode() {
    public static void verifyCompatibility(PluginInfo info) {
    }
            }
                            + "This is expected when extended plugins share common ancestors.",
            // check we don't have conflicting codebases with core
        }
    public static Tuple<List<String>, List<String>> findPluginsByDependency(Path pluginsDir, String pluginName) throws IOException {
    public PluginsAndModules info() {
        }
            plugin.v2().onIndexModule(indexModule);
        }
        logPluginInfo(info.getModuleInfos(), "module", logger);
        // Used for testing
        } catch (final IOException e) {
    // the plugin cli does it, but we do it again, in case users mess with jar files manually
            Class<? extends T> extensionClass = classIterator.next();
            builders.addAll(plugin.v2().getExecutorBuilders(settings));
    static void loadExtensions(List<Tuple<PluginInfo, Plugin>> plugins) {
            addSortedBundle(bundle, namedBundles, sortedBundles, dependencyStack);
                logger.info("loaded " + type + " [" + name + "]");
            }
                    + Version.CURRENT
            );
                        p.getName(),
        final Set<Bundle> bundles = new HashSet<>();
                if (intersection.isEmpty() == false) {
/*
            );
            throw new IllegalStateException("no unique public " + extensionConstructorMessage(extensionClass, extensionPointType));
        final Constructor<T> constructor = constructors[0];
            for (final String name : pluginInfos.stream().map(PluginInfo::getName).sorted().collect(Collectors.toList())) {
        }
import org.apache.lucene.codecs.KnnVectorsFormat;
    }
            Bundle bundle = (Bundle) o;
        }
import static org.opensearch.core.util.FileSystemUtils.isAccessibleDirectory;
        if (modulesDirectory != null) {
        Constructor<T>[] constructors = (Constructor<T>[]) extensionClass.getConstructors();
        }
                    missingPlugins.add(mandatoryPlugin);
        public boolean equals(Object o) {
        ClassLoader parentLoader = PluginLoaderIndirection.createLoader(getClass().getClassLoader(), extendedLoaders);
        return info;
                if (logger.isTraceEnabled()) {
        }
     * <p>
        List<PluginInfo> modulesList = new ArrayList<>();
                Path sharedLibDir = dir.getParent().resolve("lib").resolve(dir.getFileName());
                        false
        }
        return new Tuple<>(requiredBy, optionallyExtendedBy);
 *
        return plugins.stream().flatMap(p -> p.v2().getSettings().stream()).collect(Collectors.toList());
            // and initialize them appropriately.
    private final Settings settings;
        if (bundles.add(bundle) == false) {
         * Check for the existence of a marker file that indicates any plugins are in a garbage state from a failed attempt to remove the
        };
            loaded.put(name, plugin);
            for (String extendedPlugin : bundle.plugin.getExtendedPlugins()) {
 * this file be licensed under the Apache-2.0 license or a
    }
        return plugins.stream().filter(x -> type.isAssignableFrom(x.v2().getClass())).map(p -> ((T) p.v2())).collect(Collectors.toList());
                if (extendedPlugin.equals(pluginName)) {
        for (final String feature : features.keySet()) {
        final Set<String> seen = new HashSet<>();
                final String message = String.format(
    /** Get bundles for plugins installed in the given modules directory. */
                    }
     * Constructs a new PluginService
    public <T> List<T> filterPlugins(Class<T> type) {
            if (constructor.getParameterCount() == 0) {
                List<T> result = new ArrayList<>();
        final PluginInfo info;
                    throw new IllegalArgumentException("Missing plugin [" + dependency + "], dependency of [" + name + "]");
        }
                            + "], already added in plugin ["
                    + "] was built for OpenSearch version "
                    throw new IllegalArgumentException(message);
                e
            }
                }
                    );
 * ownership. Elasticsearch licenses this file to you under
import java.util.Map;
        LinkedHashSet<String> dependencyStack
                        Collections.emptyList(),
                if (oldPlugin != null) {
                msg.append(s);
                e
            Plugin extendedPlugin = loaded.get(extendedPluginName);
            try {
        pluginsLoaded.addAll(loaded);
 *
                throw new IllegalStateException(signatureMessage(pluginClass));
        return builder.put(this.settings).build();
            // gather urls for jar files in the plugin directory
    public List<ExecutorBuilder<?>> getExecutorBuilders(Settings settings) {
    @Override
            });
            throw new IllegalStateException("no public constructor for [" + pluginClass.getName() + "]");
        return builders;
        for (Tuple<PluginInfo, Plugin> plugin : plugins) {
                Set<URL> intersection = new HashSet<>(urls);
import org.opensearch.lucene.util.SPIClassIterator;
        assert pluginInfos != null;
        for (Tuple<PluginInfo, Plugin> plugin : plugins) {
            try (DirectoryStream<Path> jarStream = Files.newDirectoryStream(dir, "*.jar")) {
        List<String> optionallyExtendedBy = new ArrayList<>();
        if (sortedBundles.contains(bundle)) {
import org.apache.lucene.codecs.Codec;
                    logger.trace("plugin loaded from classpath [{}]", pluginInfo);
        // Core version must satisfy the semver range in plugin info
                                throw new IllegalStateException("duplicate codebase: " + url);
        Map<String, List<Plugin>> extendingPluginsByName = plugins.stream()
 * compatible open source license.
        }
            }
        List<Tuple<PluginInfo, Plugin>> plugins = new ArrayList<>();
        Property.NodeScope
                        continue;
        Set<Bundle> seenBundles = new LinkedHashSet<>();
                        pluginsList.add(bundle.plugin);
                    result.addAll(createExtensions(extensionPointType, extendingPlugin));
        List<ClassLoader> extendedLoaders = new ArrayList<>();
     */
            this.libUrls = Collections.unmodifiableSet(libUrls);
                        "Plugin [{}] extends multiple plugins/modules that share common dependencies: {}. "
    public Settings updatedSettings() {
        "plugin.mandatory",
        }
        // collect lib-only loaders of extended plugins as parents.
        } catch (Throwable t) {
                    plugins.add(plugin);
            // that have dependencies with their own SPI endpoints have a chance to load
        return Collections.unmodifiableList(plugins);
                    for (final Bundle bundle : plugins) {
    }
                    "Plugin ["
    }
     * This method must be called after the new classloader has been created to
    // jar-hell check the bundle against the parent classloader and extended plugins
    /**
import java.nio.file.DirectoryStream;
            dependencyStack.forEach(s -> {
            throw new OpenSearchException("Unable to load plugin class [" + className + "]", t);
            throw new IllegalStateException("failed to load plugin " + bundle.plugin.getName() + " due to jar hell", e);
     *         and v2() is the list of plugins with optional dependencies
            if (o == null || getClass() != o.getClass()) return false;
 */
     */
                }
                    + " is running"
                        + "] (class loader ["
import java.util.function.Function;
                }
            throw new IllegalArgumentException(
                    if (seen.add(plugin.getFileName().toString()) == false) {
        final Constructor<?> constructor = constructors[0];
 * KIND, either express or implied.  See the License for the
     * @param settings The settings of the system
        }
        // reload SPI with any new services from the plugin
                continue;
            Set<String> missingPlugins = new HashSet<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    /**
     *
            return Class.forName(className, false, loader).asSubclass(Plugin.class);
 * license agreements. See the NOTICE file distributed with
                        "1.8",
 *
        for (String dependency : bundle.plugin.getExtendedPlugins()) {
        @Override
import org.opensearch.Version;
            } else if (constructor.getParameterCount() == 1 && parameterTypes[0] == Settings.class) {
    /**
                            URL url = jar.toRealPath().toUri().toURL();
                    + constructor.getParameterTypes()[0].getName()
        }
 * the Apache License, Version 2.0 (the "License"); you may
                    // normalize with toRealPath to get symlinks out of our hair
                    Strings.collectionToDelimitedString(pluginsNames, ", ")
    static class Bundle {
                intersection = new HashSet<>(bundle.urls);
                pluginsLoaded.add(new Tuple<>(pluginInfo, plugin));
    /**
     * @param settings The settings of the system
    private static <T> String extensionConstructorMessage(Class<? extends T> extensionClass, Class<T> extensionPointType) {
                    final String message = String.format(
            logger.debug("Loading plugin [" + name + "]...");
    private static Bundle readPluginBundle(final Set<Bundle> bundles, final Path plugin, String type) throws IOException {
                        "duplicate feature [%s] in plugin [%s], already added in [%s]",
            throw new IllegalStateException(
        if (constructors.length == 0) {
        String name = bundle.plugin.getName();
    }
     * @param pluginsDirectory The directory plugins exist in, or null if plugins should not be loaded from the filesystem
        );
    public static void checkJarHellForPlugin(
    private static void addSortedBundle(
        }
                            "Non-plugin file located in the plugins folder with the following name: [" + plugin.getFileName() + "]"
        ClassLoader loader = URLClassLoader.newInstance(bundle.urls.toArray(new URL[0]), parentLoader);
                    Strings.collectionToDelimitedString(missingPlugins, ", "),
     * Get information about plugins and modules
            JarHell.checkJarHell(urls, logger::debug); // check jarhell of each extended plugin against this plugin
                String oldPlugin = foundSettings.put(setting, plugin.v1().getName());
import org.apache.logging.log4j.LogManager;
        final List<Path> plugins = new ArrayList<>();
            } else {
        return new ArrayList<>(sortedBundles);
                    continue;
        for (final Path plugin : findPluginDirs(directory)) {
            } else if (constructor.getParameterCount() == 0) {
        for (Bundle bundle : bundles) {
            throw new IllegalStateException("external test module [" + plugin.getFileName() + "] found in non-snapshot build");
        try {
                }
    public static boolean isPluginVersionCompatible(final PluginInfo pluginInfo, final Version coreVersion) {
    public Collection<Class<? extends LifecycleComponent>> getGuiceServiceClasses() {
                    )
        ExtensiblePlugin.ExtensionLoader extensionLoader = new ExtensiblePlugin.ExtensionLoader() {
    /**
            throw new IllegalStateException(
    static Set<Bundle> getPluginBundles(final Path pluginsDirectory) throws IOException {
        }
                    // skip the reserved lib/ subdirectory used for shared library jars
     * Reloads all Lucene SPI implementations using the new classloader.
        }
 * under the License.
                Plugin plugin = loadPlugin(pluginClazz, settings, configPath);
                }
        List<Class<? extends LifecycleComponent>> services = new ArrayList<>();
            JarHell.checkJarHell(union, logger::debug);
            logger.info("no " + type + "s loaded");
            final Bundle bundle = readPluginBundle(bundles, plugin, type);
    ) throws Exception {
     * @throws IllegalStateException if a dependency cycle is found
     * Return the given bundles, sorted in dependency loading order.
        Map<String, ClassLoader> libLoaders = new HashMap<>();
            Set<URL> union = new HashSet<>(classpath);
                        p.getName(),
import org.opensearch.common.bootstrap.JarHell;
            StringBuilder msg = new StringBuilder("Cycle found in plugin dependencies: ");
            "()"
 * GitHub history for details.
        // not the full implementation classloader, so extending plugins cannot accidentally
import org.opensearch.core.service.ReportingService;
                logger.error("Failed to load classpath plugin: " + pluginInfo.getClassname());
/**
        Path pluginsDirectory,
 * The OpenSearch Contributors require contributions made to
        JarHell.checkJavaVersion(info.getName(), info.getJavaVersion());
            }
                        );
        if (type.equals("module") && info.getName().startsWith("test-") && Build.CURRENT.isSnapshot() == false) {
        for (Bundle bundle : bundles) {
            throw new IllegalStateException("no public " + extensionConstructorMessage(extensionClass, extensionPointType));
    public static void checkForFailedPluginRemovals(final Path pluginsDirectory) throws IOException {
        if (constructor.getParameterCount() == 1 && constructor.getParameterTypes()[0] != plugin.getClass()) {
     * Constructs a new PluginService
        }
    }
        PostingsFormat.reloadPostingsFormats(loader);
        } catch (Exception e) {
            if (depBundle == null) {
import java.util.Set;
        final Class[] parameterTypes = constructor.getParameterTypes();
            pluginsDirectory,
        List<String> requiredBy = new ArrayList<>();
import java.util.Locale;
        }
                final String message = String.format(
            transitiveUrls.put(bundle.plugin.getName(), urls);
            }
    private static Set<Bundle> findBundles(final Path directory, String type) throws IOException {
                    "missing mandatory plugins [%s], found plugins [%s]",
                return (Plugin) constructor.newInstance();
import org.opensearch.common.settings.Setting;
    public List<String> getPluginSettingsFilter() {
import org.opensearch.common.lifecycle.LifecycleComponent;
            } else {
            }
                    logger.info(
                        "jar hell! duplicate codebases with extended plugin [" + extendedPlugin + "]: " + intersection
        } catch (ReflectiveOperationException e) {
    }
            return Objects.hash(plugin);
                seenBundles.addAll(modules);
            // also gather jars from plugins/lib/<plugin_name>/ if it exists.
    }
    public Collection<Module> createGuiceModules() {
                    } else {
    );
        }
        // we don't log jars in lib/ we really shouldn't log modules,
    ) {
        // invariant: any plugins this plugin bundle extends have already been added to transitiveUrls
            return plugin;
            }
            if (intersection.isEmpty() == false) {
    static Set<Bundle> getModuleBundles(Path modulesDirectory) throws IOException {
/*
            clazz.getName(),
            ClassLoader libParent = PluginLoaderIndirection.createLoader(getClass().getClassLoader(), extendedLoaders);
        List<String> exts = bundle.plugin.getExtendedPlugins();
        return "signature of "
import java.util.HashMap;
        }
        SPIClassIterator<T> classIterator = SPIClassIterator.get(extensionPointType, plugin.getClass().getClassLoader());
                    );
        }
                }
        Path configPath,
        dependencyStack.remove(name);
        }
                )
    @SuppressWarnings("unchecked")
            if (dir.getParent() != null) {
            // check we don't have conflicting classes
        return bundle;
        // but for now: just be transparent so we can debug any potential issues
                // TODO: remove this leniency, but tests bogusly rely on it
         * plugin.
                        plugin.v1().getName(),
                return constructor.newInstance(plugin);
                            }
     * @return a Tuple where v1() is the list of plugins with required dependencies,
            return Objects.equals(plugin, bundle.plugin);
    }
            // contains a top-level lib/ directory.
            "no public constructor of correct signature for [%s]; must be [%s], [%s], or [%s]",
 * software distributed under the License is distributed on an
        }
            Class<? extends Plugin> pluginClass = loadPluginClass(bundle.plugin.getClassname(), loader);
            Set<URL> intersection = new HashSet<>(classpath);
            + extensionConstructorMessage(extensionClass, extensionPointType)
            } catch (IOException ex) {
        return extensions;
            throw new IllegalStateException(msg.toString());
        for (final Tuple<PluginInfo, Plugin> plugin : plugins) {
        // load modules
                if (bundle.plugin.isExtendedPluginOptional(extendedPlugin)) {
            if (!range.isSatisfiedBy(coreVersion)) {
    }
                        dependency,
        }
    }
                return false;
 */
    }
            Thread.currentThread().setContextClassLoader(loader);
            + plugin.getClass().getName()
            try {
            if (ExtensiblePlugin.class.isInstance(extendedPlugin) == false) {
                }
                    name
    // searches subdirectories under the given directory for plugin directories
        if (constructors.length == 0) {
 * Modifications Copyright OpenSearch Contributors. See
                    );
            } catch (IOException ex) {
import org.opensearch.Build;
        try {
            }
        KnnVectorsFormat.reloadKnnVectorsFormat(loader);
     * Finds plugins that depend on the given plugin.
                throw new IllegalStateException("Unable to initialize plugins", ex);
        Codec.reloadCodecs(loader);
    static void reloadLuceneSPI(ClassLoader loader) {
     * We keep around a list of plugins and modules
                    }
        if (pluginsDirectory != null) {
import java.util.LinkedHashSet;
                    Locale.ROOT,
     * Verify the given plugin is compatible with the current OpenSearch installation.
import java.util.Optional;
                final String name = fileName.substring(1 + fileName.indexOf("-"));
                );
                            if (urls.add(url) == false) {
                    + ", not ("
     */
                        throw new IllegalStateException("duplicate plugin: " + plugin);
        this.info = new PluginsAndModules(pluginsList, modulesList);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
            plugins.add(new Tuple<>(bundle.plugin, plugin));
        // noinspection unchecked
     * @param classpathPlugins Plugins that exist in the classpath which should be loaded
import java.util.Collection;
    // get a bundle for a single plugin dir
                            + plugin.v1().getName()
        logPluginInfo(info.getPluginInfos(), "plugin", logger);
    private static <T> String extensionSignatureMessage(Class<? extends T> extensionClass, Class<T> extensionPointType, Plugin plugin) {
        // now, find all the ones that are in plugins/
                    }
            }
        try {
        if (bundle.libUrls.isEmpty() == false) {
                intersection.retainAll(pluginUrls);
        Map<String, Set<URL>> transitiveUrls = new HashMap<>();
        bundles.addAll(getModuleBundles(modulesDir));
        reloadLuceneSPI(loader);
            classpathPlugins.stream()
    public PluginsService(
                    seenBundles.addAll(plugins);
                if (intersection.isEmpty() == false) {
        Collection<PluginInfo> classpathPlugins
                    + info.getOpenSearchVersionRangesString()
                "failed to create extension [" + extensionClass.getName() + "] of type [" + extensionPointType.getName() + "]",
                }
        for (Tuple<PluginInfo, Plugin> pluginTuple : plugins) {
                        requiredBy.add(bundle.plugin.getName());
    }
    }
                return (Plugin) constructor.newInstance(settings);
        }
    // add the given bundle to the sorted bundles, first adding dependencies
        // if this plugin has lib jars, build a scoped classloader containing only those jars
    }
            throw new IllegalStateException(
        }
    }
        // do NOT change the order of these method calls!
        for (Bundle bundle : sortedBundles) {
                    throw new IllegalStateException(
            + ")";
                }
    }
        LogManager.getLogger(PluginsService.class).trace("--- adding [{}] [{}]", type, plugin.toAbsolutePath());
import org.apache.logging.log4j.Logger;
                        throw new IllegalStateException("duplicate codebase: " + url);
        } else {
        return bundles;
    private Class<? extends Plugin> loadPluginClass(String className, ClassLoader loader) {
            final Logger logger = LogManager.getLogger(JarHell.class);
                    );
package org.opensearch.plugins;
                extensionSignatureMessage(extensionClass, extensionPointType, plugin)
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(pluginsDirectory, ".removing-*")) {
                for (Plugin extendingPlugin : extendingPlugins) {
                if (!pluginsNames.contains(mandatoryPlugin) && !missingPlugins.contains(mandatoryPlugin)) {
        for (Tuple<PluginInfo, Plugin> plugin : plugins) {
        Bundle(PluginInfo plugin, Path dir) throws IOException {
 * specific language governing permissions and limitations
                        bundle.plugin.getName(),
            checkBundleJarHell(classpath, bundle, transitiveUrls);
            throw new IllegalStateException("duplicate " + type + ": " + info);
     *
import java.util.List;
        sortedBundles.add(bundle);
                }
    static <T> T createExtension(Class<? extends T> extensionClass, Class<T> extensionPointType, Plugin plugin) {
        bundles.add(new Bundle(candidateInfo, candidateDir));
        List<T> extensions = new ArrayList<>();
        }
        // we need to build a List of plugins for checking mandatory plugins
     * register the services for use.
            if (pluginTuple.v2() instanceof ExtensiblePlugin extensiblePlugin) {
                    try (DirectoryStream<Path> jarStream = Files.newDirectoryStream(sharedLibDir, "*.jar")) {
        /** URLs from {@code plugins/lib/<name>/} only — the public API surface exposed to extending plugins. */
                            + "]"
        }
            final Optional<String> maybeFeature = plugin.v2().getFeature();
                throw new IllegalStateException("Unable to initialize modules", ex);
            extensions.add(createExtension(extensionClass, extensionPointType, plugin));
import org.opensearch.common.inject.Module;
                if (bundle.plugin.isExtendedPluginOptional(dependency)) {
    /**
    }
                        }
     * @param modulesDirectory The directory modules exist in, or null if modules should not be loaded from the filesystem
                    checkForFailedPluginRemovals(pluginsDirectory);
        }
        }
    }
            modules.addAll(plugin.v2().createGuiceModules());
                        intersection
            }
        Path modulesDir
    // pkg private for tests
        return findBundles(pluginsDirectory, "plugin");
        for (Tuple<PluginInfo, Plugin> plugin : plugins) {
                msg.append(" -> ");
    public static List<Path> findPluginDirs(final Path rootPath) throws IOException {
                    if (plugin.getFileName().toString().startsWith(".") && !Files.isDirectory(plugin)) {
        }
        return String.format(
        @Override
                    Set<Bundle> plugins = getPluginBundles(pluginsDirectory);
import java.util.TreeMap;
import java.net.URL;
                        null,
    public PluginsService(
import java.util.HashSet;
        final Bundle bundle = new Bundle(info, plugin);
        }
    // a "bundle" is a group of jars in a single classloader
import java.lang.reflect.Constructor;
    }
 *
        // so that plugins extending this one see only the public API surface
                urls.addAll(pluginUrls);
                    extendingPluginsByName.getOrDefault(pluginTuple.v1().getName(), Collections.emptyList())
                    removing,
                // extended plugin is optional and is not installed
    }
    }
                if (isAccessibleDirectory(pluginsDirectory, logger)) {
                for (Bundle bundle : modules) {
                return Collections.unmodifiableList(result);
import org.apache.lucene.codecs.DocValuesFormat;
            services.addAll(plugin.v2().getGuiceServiceClasses());
     * their relative order from iteration of the provided set will not change.
                        features.get(feature)
                        feature,
import org.opensearch.OpenSearchException;
     */
    private final Path configPath;
            Set<URL> libUrls = new LinkedHashSet<>();
                    logger.info(
 * SPDX-License-Identifier: Apache-2.0
            }
        return services;
            .collect(Collectors.groupingBy(Tuple::v1, Collectors.mapping(Tuple::v2, Collectors.toList())));
    }
     * @return a list of all plugin paths installed in the {@code rootPath}
import java.nio.file.Path;
        this(
            final Iterator<Path> iterator = stream.iterator();
    public static final Setting<List<String>> MANDATORY_SETTING = Setting.listSetting(
     */
import org.opensearch.common.collect.Tuple;
                    extensiblePlugin,
        Path pluginsDir,
import java.net.URLClassLoader;
            return;
        loadExtensions(pluginsLoaded);
                    "found file [%s] from a failed attempt to remove the plugin [%s]; execute [opensearch-plugin remove %2$s]",
        return plugins.stream().flatMap(p -> p.v2().getSettingsFilter().stream()).collect(Collectors.toList());
 * not use this file except in compliance with the License.
            }
                            + setting
        this.settings = settings;
     * @param pluginsDir the plugins directory
        } catch (final ReflectiveOperationException e) {
                            + oldPlugin
                throw new IllegalStateException("Plugin [" + name + "] cannot extend non-extensible plugin [" + extendedPluginName + "]");
            bundles.add(bundle);
            for (String mandatoryPlugin : mandatoryPlugins) {
                );
            throw new IllegalStateException(extensionSignatureMessage(extensionClass, extensionPointType, plugin));
        if (pluginInfos.isEmpty()) {
     * @param pluginsDirectory The directory plugins exist in, or null if plugins should not be loaded from the filesystem
                }
            throw new IllegalStateException("no unique public constructor for [" + pluginClass.getName() + "]");
 * this work for additional information regarding copyright
        LinkedHashSet<Bundle> sortedBundles = new LinkedHashSet<>();
    }
        List<Bundle> sortedBundles = sortBundles(bundles);
        final Constructor<?>[] constructors = pluginClass.getConstructors();
    public void onIndexModule(IndexModule indexModule) {
     */
        Collections.emptyList(),
import java.util.Iterator;
                        logger.warn(
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(rootPath)) {
        }
        try {
                intersection.retainAll(pluginUrls);
        }
                        continue;
            }
            checkBundleJarHell(JarHell.parseClassPath(), bundle, transitiveUrls);
            assert extendedPlugin != null;
                if (Files.isDirectory(sharedLibDir)) {
                final String feature = maybeFeature.get();
                for (Path jar : jarStream) {
    /** Returns all classes injected into guice by plugins which extend {@link LifecycleComponent}. */
 */
            if (constructor.getParameterCount() == 2 && parameterTypes[0] == Settings.class && parameterTypes[1] == Path.class) {
        }
    }
            modulesDirectory,
            null,
        final PluginInfo plugin;
            // Set context class loader to plugin's class loader so that plugins
        Settings settings,
        }
        }
                    + info.getName()
                        name
            }
            intersection.retainAll(bundle.urls);
    }
                throw new IllegalStateException("jar hell! duplicate codebases between plugin and core: " + intersection);
 * @opensearch.internal
    }
            // prefer the lib-only classloader if the extended plugin has one; fall back to its full classloader
                .map(
            if (extendedPlugin == null && bundle.plugin.isExtendedPluginOptional(extendedPluginName)) {
import org.opensearch.transport.TransportSettings;
                throw new IllegalStateException(message);
                Set<URL> pluginUrls = transitiveUrls.get(extendedPlugin);
                            + "Some features of this plugin may not function without the dependencies being installed.",
                pluginsNames.add(pluginInfo.getName());
     * @param pluginName the plugin name to find dependents for
                    }
                        for (Path jar : jarStream) {
            Plugin plugin = loadPlugin(pluginClass, settings, configPath);
         */
        DocValuesFormat.reloadDocValuesFormats(loader);
                    Locale.ROOT,
                "Could not load plugin descriptor for " + type + " directory [" + plugin.getFileName() + "]",
                return constructor.newInstance();
    private final PluginsAndModules info;
            settings,
    static void checkBundleJarHell(Set<URL> classpath, Bundle bundle, Map<String, Set<URL>> transitiveUrls) {
 * Service responsible for loading plugins and modules (internal and external)
                throw new IllegalStateException(message);
                } else {
    ) {
            }
import java.util.Collections;
            Set<URL> urls = new LinkedHashSet<>();
import java.io.IOException;
            }
import org.opensearch.semver.SemverRange;
                        + bundle.plugin.getClassname()
                    modulesList.add(bundle.plugin);
            addSortedBundle(depBundle, bundles, sortedBundles, dependencyStack);
import org.apache.lucene.codecs.PostingsFormat;
                final String fileName = removing.getFileName().toString();
            msg.append(name);
            if (this == o) return true;
        }
        return findBundles(modulesDirectory, "module");
        Function.identity(),
                .collect(Collectors.toList())
    private final List<Tuple<PluginInfo, Plugin>> plugins;
            }
            builder.put(settings);
        return "constructor for extension [" + extensionClass.getName() + "] of type [" + extensionPointType.getName() + "]";
            @Override
                            + "in plugin ["
                        Locale.ROOT,
                    + ")"
        }
        this.plugins = Collections.unmodifiableList(pluginsLoaded);
                );
            } catch (ClassNotFoundException e) {
            this.plugin = Objects.requireNonNull(plugin);
        List<PluginInfo> pluginsList = new ArrayList<>();
        // Checking expected plugins
            union.addAll(bundle.urls);
                            + "] "
            // already added this plugin, via a dependency
            for (String extendedPlugin : exts) {
                }
import org.opensearch.common.settings.Setting.Property;
    /**
                        "classpath plugin",
    private static void logPluginInfo(final List<PluginInfo> pluginInfos, final String type, final Logger logger) {
        final Set<URL> urls;
                Set<Bundle> modules = getModuleBundles(modulesDirectory);
        List<Bundle> sortedBundles = sortBundles(bundles);
                        Version.CURRENT,
        try {
     * @param modulesDirectory The directory modules exist in, or null if modules should not be loaded from the filesystem
        final Set<URL> libUrls;
        Settings settings,
                        "NA",
        Bundle bundle,
import java.nio.file.Files;
                }
        Path pluginsDirectory,
            urls.addAll(bundle.urls);
        Path modulesDirectory,
                if (features.containsKey(feature)) {
                        "Missing optional plugin [{}], dependency of [{}]. "
            Settings settings = plugin.v2().additionalSettings();
        while (classIterator.hasNext()) {
    private String signatureMessage(final Class<? extends Plugin> clazz) {
        // tracks a lib-only classloader per plugin name, used as the parent for extending plugins
                    }
        // this exposes only the SPI jars (plugins/lib/<name>/) of each extended plugin,
                        optionallyExtendedBy.add(bundle.plugin.getName());
        Set<Bundle> bundles = new HashSet<>(getPluginBundles(pluginsDir));
        try {
        for (Bundle bundle : sortedBundles) {
            for (String setting : settings.keySet()) {
                    );
        // Codecs:
            assert sortedBundles.contains(depBundle);
        LinkedHashSet<String> dependencyStack = new LinkedHashSet<>();
    }
    private Plugin loadPlugin(Class<? extends Plugin> pluginClass, Settings settings, Path configPath) {
            libLoaders.put(name, URLClassLoader.newInstance(bundle.libUrls.toArray(new URL[0]), libParent));
        dependencyStack.add(name);
        if (Files.exists(rootPath)) {
     * @throws IOException if an I/O exception occurred reading the directories
            .flatMap(t -> t.v1().getExtendedPlugins().stream().map(extendedPlugin -> Tuple.tuple(extendedPlugin, t.v2())))
    }
    }
        verifyCompatibility(bundle.plugin);
                    if (urls.add(url) == false) {
     * @param classpathPlugins Plugins that exist in the classpath which should be loaded
            this.urls = Objects.requireNonNull(urls);
