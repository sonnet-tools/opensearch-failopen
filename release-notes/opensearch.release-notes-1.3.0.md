        it first tries acquire a lock to flush the new state under a mutex to disk. The
* __Restore Java 8 compatibility for build tools. (#2300)__
    * Delayed CodecService instantiation up to the shard initialization
    Signed-off-by: dblock
    I observed a test failure with the message
    [2]:
     Co-authored-by: Vacha &lt;vachshah@amazon.com&gt;
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
    immediately after creation. I found a few that did
    [Nick Knize](mailto:nknize@apache.org) - Thu, 6 Jan 2022 11:11:31 -0800
    * Fixing allocation filters to persist existing state on settings update
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    (cherry picked from commit e66ea2c4f3ec583f087a82d1ebfb6383b2f159c1)
     Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
* __Auto-increment next development iteration. (#1816) (#2164)__
    * Adding failureaccess since guava needs it.
     Signed-off-by: Robert Muir &lt;rmuir@apache.org&gt;
* __Adding 1.2.2 (#1731) (#1736)__
    * Adding assertion and unit test for operation type mismatch
    his previous work.
    [Matt Weber](mailto:matt@mattweber.org) - Tue, 18 Jan 2022 09:48:52 -0600
    * Refactored the EngineConfigFactory / IndexShard instantiation of the
     Signed-off-by: Rishikesh1159 &lt;rishireddy1159@gmail.com&gt;
* __Upgrading gson to 2.8.9 (#1541). (#1545)__
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Mon, 28 Feb 2022 15:59:57 -0600
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Refactor LegacyESVersion tests from Version tests (#1662) (#1663)__
    * Added support for patch JDK version, like 11.0.14+1
* __Rename field_masking_span to span_field_masking (#1606) (#1623)__
        same lock is used to cancel the publication on timeout. Below is the state of
     Signed-off-by: Rishikesh1159 &lt;rishireddy1159@gmail.com&gt;
    - Ensure GlobalBuildInfoPlugin.java use [SOURCE_DATE_EPOCH] when available
     Co-authored-by: Breno Faria &lt;breno.faria@intrafind.de&gt;
    value is still 128 and the max value is bounded by
     Signed-off-by: Vacha Shah &lt;vachshah@amazon.com&gt;
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Fri, 10 Dec 2021 15:36:19 -0500
    [Nicholas Walter Knize](mailto:nknize@apache.org) - Fri, 4 Feb 2022 18:29:46 -0600
    &#39;Attempted to append to non-started appender mock&#39; from an assertion in
* __Gradle clean failing after a failed gradle check, folders created by Docker under &#39;root&#39; user (#1726) (#1775)__
    * [Remove] Remaining Flavor Serialization (#1751)
* __Upgrading commons-codec in hdfs-fixture and cleaning up dependencies in repository-hdfs (#1603) (#1621)__
    (cherry picked from commit 343b82fe24525bbab01ef5a0d9bb8917068c71bf)
     Co-authored-by: Peng Huo &lt;penghuo@gmail.com&gt;
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Thu, 3 Mar 2022 13:49:40 -0500
    Shadow plugin is used for publishing jars
    connect/write/response/read timeouts
    (cherry picked from commit f0984eb409d44e8b68deb1c262bf81accc300acb)
    fail (because they share static state
    * Update junit to 4.13.1
     Signed-off-by: Bukhtawar Khan &lt;bukhtawa@amazon.com&gt;
    [github-actions[bot]](mailto:41898282+github-actions[bot]@users.noreply.github.com) - Tue, 8 Feb 2022 12:27:45 -0800
    [Andrew Ross](mailto:andrross@amazon.com) - Fri, 10 Dec 2021 16:35:18 -0500
    (cherry picked from commit 6b6f03368f49f5f8001d6d0ed85cd9af7bab76f6)
    Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    `Files::list` was returning the javaparser-core file first. I
     Signed-off-by: Bukhtawar Khan &lt;bukhtawa@amazon.com&gt;
    [announced](https://jfrog.com/blog/into-the-sunset-bintray-jcenter-gocenter-and-chartcenter/)
     Changes made by deleting the TestSettingsIT file and adding new lines in
    * Update bctls-fips to 1.0.12.2
* __Upgrading Jackson-Databind version (#1982) (#1987)__
     Signed-off-by: Matt Weber &lt;matt@mattweber.org&gt;
* __Add valuesField in PercentilesAggregationBuilder streamInput constructor (#2308) (#2389)__
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 23 Dec 2021 17:42:09 -0500
    with this
      * The publication of cluster state is time bound to 30s by a
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    (cherry picked from commit 9c679cbbfcf685e3865d2cf06b8f4e10c3082d49)
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    * Update bcpg-fips to 1.0.5.1
    * MapperService has to be passed in as null for EnginePlugins CodecService
    * Added tests cases and TODO items, addressing code review comments
     Co-authored-by: Joshua Palis &lt;jpalis@amazon.com&gt;
    * Fixing the --release flag usage for javac
    &lt;handalm@amazon.com&gt;
## Version 1.3.0 Release Notes
    (#2074)
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Tue, 18 Jan 2022 10:51:53 -0500
    [Marc Handalian](mailto:handalm@amazon.com) - Tue, 23 Nov 2021 21:41:59 -0500
    a method call signature
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
    then caused an unrelated test to
* __Update protobuf-java to 3.19.3 (#1945) (#1949)__
     Signed-off-by: Breno Faria &lt;breno.faria@intrafind.de&gt;
    targets
* __Start MockLogAppender before adding to static context (#1587) (#1659)__
     Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
* __[repository-azure] Update to the latest Azure Storage SDK v12, remove privileged runnable wrapper in favor of access helper (#1521) (#1538)__
    * adding braces to control flow statement
    * Fixing the --html5 flag usage for javadoc
* __Add regexp interval source (#1917) (#2069)__
    testClusterGreenAfterPartialRelocation
    (cherry picked from commit 1e5d98329eaa76d1aea19306242e6fa74b840b75)
    legacy yaml test and build scripts).
        publication since both of them share the same mutex. So leader will not step
    * spotless fix...
        the timeout scheduler meant to cancel the publication. So essentially if the
    * Adding deprecation logger tests
     This commit removes unnecessary serialization of unused flavor variable in
    * update junit to 4.13.2
    [Tianli Feng](mailto:ftl94@live.com) - Fri, 21 Jan 2022 08:52:05 -0800
* __Use try-with-resources with MockLogAppender (#1595) (#1784)__
     Signed-off-by: dblock &lt;dblock@amazon.com&gt;
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
     Co-authored-by: Rishikesh Pasham
     Co-authored-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
     Signed-off-by: Breno Faria &lt;breno.faria@intrafind.de&gt;
    Attempt to fix o.o.transport.netty4.OpenSearchLoggingHandlerIT fails w/ stack
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    (cherry picked from commit f13b951c7006700a9b8a8bb2cdecd67439bc1e86)
     Signed-off-by: Xue Zhou &lt;xuezhou@amazon.com&gt;
     Co-authored-by: Andrey Pleskach &lt;ples@aiven.io&gt;
     Signed-off-by: Xue Zhou &lt;xuezhou@amazon.com&gt;
    component. The version parameter is deprecated at parse time and a warning is
    * Fixing precommit violation
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
    Signed-off-by: Andrew Ross &lt;andrross@amazon.com&gt;
    each node and repeating the process until all shards are balanced.
    * Upgrading guava, commons-io and apache-ant dependencies.
     (cherry picked from commit e1fd4b75b4f888d8d486baceeb9fd6fe7df44416)
    * more conservative implementation of isSupportedBy
* __Fix java-version-checker source/target compatibility settings (#2354)__
* __Fixing org.opensearch.common.network.InetAddressesTests.testForStringIPv6WithScopeIdInput (#1913) (#1914)__
* __Fixing the --release flag usage for javac (#2343)__
    like a really easy mistake to make when writing a test or introduce when
* __Added logic to allow {dot} files on startup (#1437) (#1516)__
* __Enable RestHighLevel-Client to set parameter require_alias for bulk index and reindex requests (#1604)__
    [Matt Weber](mailto:matt@mattweber.org) - Mon, 17 Jan 2022 12:28:22 -0500
     Informative error messages related to empty index name.[Backport]
    [Nick Knize](mailto:nknize@apache.org) - Thu, 4 Nov 2021 14:46:57 -0500
     Signed-off-by: Rishikesh1159 &lt;rishireddy1159@gmail.com&gt;
    to ensure a proper legacy version is returned when major is
    Since shards from
    * Fix up imports
    hit that appender and cause an error, which
       Co-authored-by: Matt Weber &lt;matt@mattweber.org&gt;
    compatibility
    type that removed support for negative timestamps with sub-second
    `BooleanQuery.getMaxClauseCount()`.
    LastSuccessfulSettingsUpdate test
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Wed, 9 Mar 2022 10:17:33 -0500
* __MapperService has to be passed in as null for EnginePlugins CodecService constructor (#2177) (#2413)__
       error: warnings found and -Werror specified
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Add bwc version 1.2.4 (#1797)__
    * Restore Java 8 compatibility for build tools.
    field
     Signed-off-by: Matt Weber &lt;matt@mattweber.org&gt;
    [Rishikesh Pasham](mailto:62345295+Rishikesh1159@users.noreply.github.com) - Mon, 21 Feb 2022 10:56:00 -0800
    (#2048)
    [Sarat Vemulapalli](mailto:vemulapallisarat@gmail.com) - Wed, 2 Feb 2022 19:40:51 -0800
    BalancedShardsAllocator iterates over them in breadth first order picking 1
* __Better JDK-18 EA (and beyond) support of SecurityManager (#1750) (#1753)__
      Co-authored-by: Subhobrata Dey &lt;sbcd90@gmail.com&gt;
    metadata from V_1_3_0+
    care.
    (cherry picked from commit fb187eacc26487cd644f09091e462001d8839315)
    * Downgrade to JDK 11.
    failures  (#1149)
     Signed-off-by: Bukhtawar Khan &lt;bukhtawa@amazon.com&gt;
    Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
    However, a SHA file for javaparser-core also gets created in
    * Signed-off-by: Megha Sai Kavikondala &lt;kavmegha@amazon.com&gt;
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    * Handle shard over allocation during partial zone/rack or independent node
    [Breno Faria](mailto:breno.faria@intrafind.com) - Mon, 7 Mar 2022 11:46:54 -0500
     Signed-off-by: Bukhtawar Khan &lt;bukhtawa@amazon.com&gt;
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    `OpenSearchTestCase::after`. I believe this indicates that a
* __[plugin] repository-azure: add configuration settings for connect/write/response/read timeouts (#1789) (#1802)__
* __RestIntegTestTask fails because of missed log4j-core dependency (#1815) (#1818)__
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Timeout fix backport to 1.x (#1953)__
* __added config file to git issue template directory to disable blank issue creation (#2158) (#2249)__
    it did involve touching a lot of files. The changes here are purely structural
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Mon, 13 Dec 2021 16:11:25 -0800
    (cherry picked from commit 270c59f523acbb3af73ab56dbcfe754e619fdca9)
    [Megha Sai Kavikondala](mailto:kavmegha@amazon.com) - Thu, 11 Nov 2021 12:55:11 -0800
     Signed-off-by: Megha Sai Kavikondala &lt;kavmegha@amazon.com&gt;
     Add a regexp interval source provider so people can use regular
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
     Signed-off-by: Bukhtawar Khan &lt;bukhtawa@amazon.com&gt;
    refactoring a test. I&#39;ve made a change to use try-with-resources to
    a method call signature
    Security
    forcemerge to one segment before executing aggregation query.
    * Avoid logging duplicate deprecation warnings multiple times (#1660)
    Add and clarify some search plugin point documentation.
    LastSuccessfulSettingsUpdate test
    (which is named &#34;mock&#34;) was added as an appender to the
    * Made changes.
     Signed-off-by: Matt Weber &lt;matt@mattweber.org&gt;
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    * Removing unused import
     Signed-off-by: Rishikesh1159 &lt;rishireddy1159@gmail.com&gt;
    shard from
* __Add Factory to enable Lucene ConcatenateGraphFilter (#1278) (#2152) (#2219)__
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
    [github-actions[bot]](mailto:41898282+github-actions[bot]@users.noreply.github.com) - Mon, 7 Feb 2022 16:11:06 -0500
     Signed-off-by: Andrey Pleskach &lt;ples@aiven.io&gt;
    * Addressing code review comments
    to create a single token (or several tokens that have the same
    * Prevents . files from being returned as plugins
    Signed-off-by: Andrew Ross &lt;andrross@amazon.com&gt;
     Co-authored-by: Breno Faria &lt;breno.faria@intrafind.de&gt;
    * Rename field_masking_span to span_field_masking
  Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
     Signed-off-by: Ryan Bogan &lt;rbogan@amazon.com&gt;
    [Rabi Panda](mailto:adnapibar@gmail.com) - Thu, 24 Feb 2022 15:58:30 -0800
    (cherry picked from commit 62361ceafce4abb735567066d1c4865ca6d7136f)
* __Add hook to execute logic before Integ test task starts (#1969) (#1971)__
    Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Wed, 29 Dec 2021 11:28:51 -0600
* __Fix o.o.transport.netty4.OpenSearchLoggingHandlerIT stack overflow test failure (#1900) (#1906)__
     Signed-off-by: dblock &lt;dblock@amazon.com&gt;
    * Fixing failing RestResizeHandlerTests in 1.x
* __Add Version.V_1_2_5 constant__
    * Use https://github.com/gradle/wrapper-validation-action.
   Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    [Sarat Vemulapalli](mailto:vemulapallisarat@gmail.com) - Fri, 17 Dec 2021 15:51:12 -0800
    * [plugin] repository-azure is not working properly hangs on basic operations
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Wed, 29 Dec 2021 13:23:49 -0500
     Signed-off-by: Ashish Agrawal &lt;ashisagr@amazon.com&gt;
      denylist, in code commet and internal variable/method/class/package name.
* __Linked the formatting setting file (#1860) (#1961)__
* __Removing lingering transportclient (#1955) (#2088)__
      - get rid of unnecessary variable
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Mon, 6 Dec 2021 08:08:01 -0500
    Add support for setting the max expansions on a wildcard interval.
     Signed-off-by: Xue Zhou &lt;xuezhou@amazon.com&gt;
    cluster becomes red.
    [Tianli Feng](mailto:ftl94@live.com) - Wed, 12 Jan 2022 09:37:05 -0500
    * Stabilizing org.opensearch.cluster.routing.MovePrimaryFirstTests.test…
     Signed-off-by: Tianli Feng &lt;ftl94@live.com&gt;
* __Case Insensitive Support in Regexp Interval (#2237) (#2246)__
  * added comments to install plugins help non option argument ouput unit test
       Signed-off-by: Matt Weber &lt;matt@mattweber.org&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 16 Dec 2021 15:01:50 -0500
    [github-actions[bot]](mailto:41898282+github-actions[bot]@users.noreply.github.com) - Thu, 27 Jan 2022 12:24:34 -0800
    * Fix up imports
    [Bukhtawar Khan](mailto:bukhtawa@amazon.com) - Mon, 7 Feb 2022 12:48:03 -0500
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    efs/remotes/origin/1.3
    1x backport of #2237.  Add a `case_insensitive` flag to regexp interval source.
* __Added .gitattributes to manage end-of-line checks for Windows/*nix systems (#1638) (#1655)__
* __[Deprecate] Setting explicit version on analysis component (#1978) (#1985)__
  Signed-off-by: Andreas &lt;apre@gmx.at&gt;
    (cherry picked from commit cfc9ec292dea2169495deffe6d1e25b654e5e35e)
     The changes ensure that in the event of a partial zone failure, the surviving
* __Support unordered non-overlapping intervals (#2103) (#2172)__
    Co-authored-by:
    [Joshua Palis](mailto:jpalis@amazon.com) - Mon, 7 Mar 2022 15:24:56 -0500
    deprecated for removal in the next major release.
  * added additional information to plugin install help output
    [Rishikesh Pasham](mailto:62345295+Rishikesh1159@users.noreply.github.com) - Mon, 31 Jan 2022 10:48:13 -0600
    distribution scale, the slower the allocation becomes. This should be used with
     Co-authored-by: Daniel Doubrovkine (dB.) &lt;dblock@dblock.org&gt;
* __Updating .gitattributes for additional file types (#1727) (#1766)__
     Signed-off-by: Breno Faria &lt;breno.faria@intrafind.de&gt;
     Co-authored-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    Add the ability for plugin authors to add custom sort builders.
    [Andrew Ross](mailto:andrross@amazon.com) - Mon, 6 Dec 2021 16:45:49 -0500
     Co-authored-by: Jan Baudisch &lt;jan.baudisch.libri@gmail.com&gt;
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
     Co-authored-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
    [Vacha](mailto:vachshah@amazon.com) - Mon, 29 Nov 2021 14:48:33 -0500
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    On February 3 2021, JFrog
    [Nick Knize](mailto:nknize@apache.org) - Mon, 17 Jan 2022 12:27:56 -0500
* __Revert &#34;Upgrading Shadow plugin to 7.1.2 (#2033) (#2037)&#34; (#2047)__
    This reverts commit 93bd32b14270be0da8a6b5eef8eeabfce7eb2b58.
     Signed-off-by: Rishikesh1159 &lt;rishireddy1159@gmail.com&gt;
    Lucene 9 removes the ability to define an explicit version on an analysis
    creation.
     Signed-off-by: Rishikesh1159 &lt;rishireddy1159@gmail.com&gt;
    * Adding jackson-databind version using getProperty method
    Signed-off-by: dblock &lt;dblock@dblock.org&gt;
       warning: [options] To suppress warnings about obsolete options, use -Xlint:-options.
    don&#39;t believe
    [Xue Zhou](mailto:85715413+xuezhou25@users.noreply.github.com) - Mon, 29 Nov 2021 23:18:13 -0500
    [Suraj Singh](mailto:79435743+dreamer-89@users.noreply.github.com) - Thu, 20 Jan 2022 20:53:43 -0600
    * applying spotless fix
    Signed-off-by: Andrey Pleskach &lt;ples@aiven.io&gt;
    * Added logger (associated with shard) to CodecServiceConfig
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 23 Dec 2021 12:26:27 -0600
    * Adding more tests and review comments
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Tue, 15 Feb 2022 11:44:17 -0600
* __Reintroduce negative epoch_millis #1991 (#2232) (#2380)__
    * Fix up imports
    * Adding shards per node constraint for predictability to
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    fixture
* __Giving informative error messages for double slashes in API call URLs- [ BACKPORT-1.x ] (#1601)__
     Signed-off-by: Ashish Agrawal &lt;ashisagr@amazon.com&gt;
* __[1x] Deprecate index.merge.policy.max_merge_at_once_explicit (#1981) (#1984)__
    &gt; 3 (to support
     Signed-off-by: Bukhtawar Khan &lt;bukhtawa@amazon.com&gt;
     Workaround JDK 11 compiler bug (JDK-8209058) that only impacts test fixture
* __Remove Github DCO action since DCO runs via Github App now (#2317) (#2323)__
    * Reintroduce negative epoch_millis #1991
     Signed-off-by: Subhobrata Dey &lt;sbcd90@gmail.com&gt;
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    because
* __[Backport] Introduce FS Health HEALTHY threshold to fail stuck node (#1269)__
    and this upgrades Log4J dependency
     The change is to enable that ConcatenateGraphFilter by adding a Factory.
    [Sarat Vemulapalli](mailto:vemulapallisarat@gmail.com) - Tue, 4 Jan 2022 11:57:01 -0800
     Co-authored-by: Lukáš Vlček &lt;lukas.vlcek@aiven.io&gt;
  * added additional details on valid plugin ids and how to use plugin URLs
    * Backport Enabling Sort Optimization to make use of Lucene
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Fri, 3 Dec 2021 15:53:57 -0500
     Co-authored-by: Leonidas Spyropoulos &lt;artafinde@gmail.com&gt;
* __Upgrade dependency (#1571) (#1594)__
    Signed-off-by: Andrew Ross &lt;andrross@amazon.com&gt;
    [Andrew Ross](mailto:andrross@amazon.com) - Tue, 21 Dec 2021 20:03:11 -0800
    Signed-off-by: Abhinav Gupta &lt;abhng@amazon.com&gt;
    constructor
    * Ensures that only plugin directories are returned by findPluginDirs()
     Co-authored-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    efs/remotes/os_or/1.3
    This commit exposes Intervals.unorderedNoOverlaps (LUCENE-8828).
* __Upgrading Shadow plugin to 7.1.2 (#2033) (#2037)__
    [Nick Knize](mailto:nknize@apache.org) - Wed, 2 Feb 2022 11:48:00 -0600
    Signed-off-by: CEHENKLE &lt;henkle@amazon.com&gt;
    (cherry picked from commit 1f9517c4caee48eda6eee77f603d815af1fd7770)
    directory. For some reason, builds were failing on my machine
    [1]: https://reproducible-builds.org/
    testing is retained in the Version test class.
    input TokenStream is a graph).
    (cherry picked from commit 9e225dc9b85c4fc2d3d910846bd0da25bc6a40df)
* __Add support of SOCKS proxies for S3 repository (#2160) (#2316)__
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Fri, 14 Jan 2022 14:23:25 -0600
    overflow by
    if order is desc, missing_bucket at last. If
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Fri, 4 Mar 2022 13:49:01 -0500
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Mon, 7 Mar 2022 11:42:03 -0500
    eventually trigger a leader election.
     Signed-off-by: Bukhtawar Khan &lt;bukhtawa@amazon.com&gt;
     Signed-off-by: Bukhtawar Khan &lt;bukhtawa@amazon.com&gt;
    with the logger). Almost all usages of
* __Add &#39;key&#39; field to &#39;function_score&#39; query function definition in explanation response (#1711) (#2346)__
    * Added timeout to ensureGreen() for testClusterGreenAfterPartialRelocation
    * Use working-directory for gradle wrapper validation.
* __Prioritize primary shard movement during shard allocation (#1445) (#2079)__
    cause a logging statement to
    largely refactors the LegacyESVersion test logic from the OpenSearch Version
    * Fixes
* __[Backport 1.x] Override Default Distribution Download Url with Custom Distribution Url When User Passes a Url (#2191)__
     Co-authored-by: Andrey Pleskach &lt;ples@aiven.io&gt;
    This is
    &#34;cluster.routing.allocation.move.primary_first&#34;
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Fri, 17 Dec 2021 09:14:45 -0800
     Signed-off-by: Megha Sai Kavikondala &lt;kavmegha@amazon.com&gt;
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Sat, 15 Jan 2022 10:14:17 -0600
* __Moving DCO to workflows (#1458) (#1666)__
    [github-actions[bot]](mailto:41898282+github-actions[bot]@users.noreply.github.com) - Wed, 26 Jan 2022 17:42:45 -0600
* __Install plugin command help (#2193) (#2264)__
    - azure.client.*.proxy.username - Proxy user name
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
    [Matt Weber](mailto:matt@mattweber.org) - Wed, 26 Jan 2022 16:08:34 -0600
    Signed-off-by: Marc Handalian
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Tue, 1 Feb 2022 14:16:50 -0600
* __Replace exclusionary words whitelist and blacklist in the places that… (#2365)__
    code in the build itself.
    Signed-off-by: Lukáš Vlček &lt;lukas.vlcek@aiven.io&gt;
    * Using ConcurrentHashMap keySet
      ```
       warning: [options] target value 7 is obsolete and will be removed in a future release
     Signed-off-by: dblock &lt;dblock@amazon.com&gt;
* __Execution failed for task &#39;:test:fixtures:azure/s3/hdfs/gcs-fixture:composeDown&#39; (#1824) (#1825)__
  Signed-off-by: Joshua Palis &lt;jpalis@amazon.com&gt;
    * Addressing code review comments: renaming connectionXxx to connectXxx
* __Fix integration tests failure (#2067) (#2090)__
    (cherry picked from commit 1568407c362b2534366048379f1bd93f2d164d89)
* __Updatting Netty to 4.1.72.Final (#1831) (#1835)__
     Signed-off-by: Rishikesh1159 &lt;rishireddy1159@gmail.com&gt;
    relaxed the assertion to
    (cherry-pick from 0e95bb9dff976a9c7f9cdac63a92040043d029e2)
    [Andrew Ross](mailto:andrross@amazon.com) - Mon, 20 Dec 2021 19:35:36 -0600
    java
    java7:
* __Add proxy username and password settings for Azure repository (#2098) (#2108)__
* __Add staged version 1.1.1 (#1509)__
     Signed-off-by: Ryan Bogan &lt;rbogan@amazon.com&gt;
* __Ignore file order in test assertion (#1755) (#1782)__
* __add 1.2.5 to bwcVersions__
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Mon, 7 Mar 2022 13:07:41 -0500
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    * Addressing code review comments: adding timeout comment
* __Mapping update for “date_range” field type is not idempotent (#2094) (#2106)__
    Fixes some grammar and link typos found in TESTING.md.
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Wed, 19 Jan 2022 00:00:42 -0500
    [github-actions[bot]](mailto:41898282+github-actions[bot]@users.noreply.github.com) - Wed, 16 Feb 2022 14:46:35 -0500
    This unit test asserts that a SHA file for a groovy dependency gets
    TokenStream
    granularity. Thanks to Ryan Kophs (https://github.com/rkophs) for allowing me to use
* __Add version 1.2.3. (#1759)__
       Task :distribution:tools:java-version-checker:compileJava FAILED
    * Lower build requirement from Java 14+ to Java 11+
    Lucene has a ConcatenateGraphFilter that can concatenate tokens from a
     Signed-off-by: Ankit Kala &lt;ankikala@amazon.com&gt;
    * Making code more readable
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Wed, 2 Mar 2022 17:48:34 -0600
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Thu, 3 Mar 2022 14:23:05 -0500
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Thu, 3 Mar 2022 12:12:55 -0800
    FullClusterRestartSettingsUpgradeIT.java
* __Adding workflow to auto delete backport merged branches from backport workflow (#2050) (#2065)__
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Tue, 28 Dec 2021 17:08:37 -0500
* __Revert &#34;[Backport 1.x] Override Default Distribution Download Url with Custom Distribution Url When User Passes a Url (#2191)&#34; (#2243)__
    Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
    issued to the user through the deprecation logger.
    [github-actions[bot]](mailto:41898282+github-actions[bot]@users.noreply.github.com) - Sun, 30 Jan 2022 16:32:14 -0800
    (cherry picked from commit 27ed6fc82c7db7a3a741499f0dbd7722fa053f9d)
     This commit changes the flavor serialization check in Build from V_2_0_0 to
    Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    [Rabi Panda](mailto:adnapibar@gmail.com) - Thu, 23 Dec 2021 10:19:15 -0500
    * Fix up tests
    harder to introduce this particular test bug in the future. Unfortunately,
* __build: introduce support for reproducible builds (#1995) (#2038)__
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Mon, 6 Dec 2021 10:47:35 -0500
* __Upgrading bouncycastle to 1.70 (#1832) (#1834)__
* __Modernize and consolidate JDKs usage across all stages of the build. Use JDK-17 as bundled JDK distribution to run tests (#1922)__
    from source to binary code [1]. This can be done by:
    thirdPartyAudit task to pass
     Signed-off-by: Leonidas Spyropoulos &lt;artafinde@gmail.com&gt;
    excluded nodes were to go down the
    recommendation - https://blog.gradle.org/jcenter-shutdown
    * Suppress this warning explicitly for this module.
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    * Adding Spotless check to previous PR
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Wed, 8 Dec 2021 07:59:34 -0500
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Sat, 18 Dec 2021 11:33:16 -0800
     Fixes a regression introduced with Elasticsearch 7 regarding the date
     Signed-off-by: Bukhtawar Khan &lt;bukhtawa@amazon.com&gt;
    * Make source code compatible with Java 8.
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    the wire.
* __[Backport] Enabling Sort Optimization to make use of Lucene (#1989)__
    (cherry picked from commit 781156471a1827b1b66445f716c7567f714dda86)
    The default
    central artifacts repository.
     Signed-off-by: Tianli Feng &lt;ftl94@live.com&gt;
     Signed-off-by: Matt Weber &lt;matt@mattweber.org&gt;
    * Fix up tests
    * Added logic to allow {dot} files on startup
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Wed, 8 Dec 2021 11:45:55 -0500
    [Abhinav Gupta](mailto:guptabhi123@gmail.com) - Mon, 7 Feb 2022 13:33:27 -0500
    static logging context
     Signed-off-by: Robert Muir &lt;rmuir@apache.org&gt;
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
    (#2103 backport)
     Co-authored-by: Daniel Doubrovkine (dB.) &lt;dblock@dblock.org&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Tue, 14 Dec 2021 12:19:35 -0500
     Signed-off-by: Megha Sai Kavikondala &lt;kavmegha@amazon.com&gt;
     Signed-off-by: Tianli Feng &lt;ftl94@live.com&gt;
    [Sarat Vemulapalli](mailto:vemulapallisarat@gmail.com) - Tue, 4 Jan 2022 11:56:39 -0800
    * Disable warning around -source 7 -release 7 for java version checker
    * Adding assertion to ensure invariant
    [Vacha](mailto:vachshah@amazon.com) - Fri, 19 Nov 2021 16:52:38 -0500
    [Sarat Vemulapalli](mailto:vemulapallisarat@gmail.com) - Wed, 15 Dec 2021 14:16:16 -0500
* __Fixing typo in TESTING.md (#1849) (#1959)__
    build
    - Preserve the order in side the archives [2]
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Fri, 14 Jan 2022 12:38:18 -0600
* __Backport/backport 2048,2074 to 1.x (#2085)__
    settings:
    Signed-off-by: Marc Handalian
    Support for &#34;first&#34; and &#34;last&#34; parameters for missing bucket ordering in
* __Fixing allocation filters to persist existing state on settings update (#1718) (#1780)__
    [Joshua Palis](mailto:99766446+joshpalis@users.noreply.github.com) - Thu, 24 Feb 2022 15:34:24 -0800
    * Use the unified bouncycastle version for bcpkix-jdk15on in HDFS testing
      ```
    [Ankit Jain](mailto:jain.ankitk@gmail.com) - Fri, 11 Feb 2022 09:36:21 -0500
    that prioritizes the p of both
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    In preparation for removing all LegacyESVersion support by 3.0; this commit
    [Megha Sai Kavikondala](mailto:kavmegha@amazon.com) - Tue, 23 Nov 2021 13:34:31 -0500
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
    ensure that proper setup and teardown is done. This should make it much
    Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
* __Update FIPS API libraries of Bouncy Castle (#1853) (#1886)__
     Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
    (cherry picked from commit 6eb8f6f307567892bbabbe37aff7cd42be486df0)
    https://docs.gradle.org/current/userguide/working_with_files.html#sec:reproducible_archives
    (cherry picked from commit 6da253b8fff9a9d9cbbf65807efa7aeaddc9c9d3)
    nodes in the minority zone don&#39;t get overloaded with shards, this is governed
    &lt;handalm@amazon.com&gt;
* __[FEATURE] Add OPENSEARCH_JAVA_HOME env to override JAVA_HOME (#2040)__
    Add hook to execute custom logic before the integ test starts.
     Co-authored-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    * [Backport 1.x] Override Default Distribution Download Url with Custom
      - use fully-qualified name for lucene RegExp
        elect a new master.
    * Make bwc increments on X.Y and main branches.
    hardening test expectation patterns in regex patterns
    [Mau Bach Quang](mailto:quangmaubach@gmail.com) - Thu, 24 Feb 2022 10:49:31 -0800
* __Update to log4j 2.17.1 (#1820) (#1822)__
    Signed-off-by: Joshua Palis &lt;jpalis@amazon.com&gt;
     Signed-off-by: Suraj Singh &lt;surajrider@gmail.com&gt;
* __Add max_expansions option to wildcard interval (#1916) (#1979)__
    position if
    [Peng Huo](mailto:penghuo@gmail.com) - Tue, 15 Feb 2022 14:07:35 -0800
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Tue, 28 Dec 2021 17:57:26 -0500
    * more java14 -&gt; java11 cleanup
    (cherry picked from commit 9c9e218ae697b65e410304825cac81ccdf355e66)
     This will cause the leader stuck on IO during publication to step down and
    CodecService
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Wed, 2 Feb 2022 12:16:50 -0800
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
* __Support JDK 18 EA builds (#1714)__
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Wed, 16 Feb 2022 12:01:51 -0500
     Co-authored-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
     Co-authored-by: Vacha Shah &lt;vachshah@amazon.com&gt;
    * Rename field_masking_span to span_field_masking
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Sat, 29 Jan 2022 09:45:19 -0800
    the repository will only be read only and new package and versions are no
    Signed-off-by: Rishikesh Pasham &lt;rishireddy1159@gmail.com&gt;
    &lt;62345295+Rishikesh1159@users.noreply.github.com&gt;
    [Vacha Shah](mailto:vachshah@amazon.com) - Fri, 4 Mar 2022 10:06:11 -0500
    MockLogAppender
  * Replace the exclusionary word whitelist with allowlist, and blacklist with
     This change replaces JCenter with Maven Central as per the Gradle
  * fixed format violation
    red if the excluded
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Matt Weber](mailto:matt@mattweber.org) - Thu, 24 Feb 2022 15:58:09 -0600
  * edited opensearch-plugin install help output to include plugin URL
    MockLogAppender start it
    missing_order is &#34;first&#34; or
* __[1.x] Remove remaining Flavor Serialization (#1751) (#1757)__
    [Rishikesh Pasham](mailto:62345295+Rishikesh1159@users.noreply.github.com) - Fri, 3 Dec 2021 15:52:51 -0500
    * Move Gradle checks into OpenSearch repo.
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Thu, 3 Mar 2022 14:14:23 -0500
    Signed-off-by: Vacha Shah &lt;vachshah@amazon.com&gt;
    I previously added a helper that started a MockLogAppender to ensure it
    there are any ordering guarantees with that API, so I
          (cherry picked from commit b251d2b565b918708a1612ec16d1916122c7805d) Signed-off-by: Joshua Palis &lt;jpalis@amazon.com&gt;
     Signed-off-by: Tianli Feng &lt;ftl94@live.com&gt;
    org.opensearch.cluster.routing.MovePrimaryFirstTests.testClusterGreenAfterPartialRelocation
     Signed-off-by: Matt Weber &lt;matt@mattweber.org&gt;
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    for build.
    is consumed over
    * [Bug] Wait for outstanding requests to complete (#1925)
* __Update junit to 4.13.1 (#1837) (#1842)__
* __Update Netty to 4.1.73.Final (#1936) (#1937)__
    (cherry picked from commit 8ae0db5285963b8e3552ce106ef1368813dbc8b1)
    * Integration test that checks for settings upgrade  (#1482)
* __[BUG] Docker distribution builds are failing. Switching to http://vault.centos.org (#2024) (#2030)__
     Signed-off-by: Rishikesh1159 &lt;rishireddy1159@gmail.com&gt;
    * Backport Enabling Sort Optimization to make use of Lucene and small change in
    not and fixed those.
    shard1 is relocated first
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    Signed-off-by: Vacha Shah &lt;vachshah@amazon.com&gt;
* __added backport for 1.2.5 to 1.x branch (#2057)__
     This commit introduces a new setting
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Thu, 11 Nov 2021 14:05:47 -0800
    created.
     Signed-off-by: Peng Huo &lt;penghuo@gmail.com&gt;
    [github-actions[bot]](mailto:41898282+github-actions[bot]@users.noreply.github.com) - Wed, 2 Feb 2022 14:21:34 -0500
    [Ankit Jain](mailto:jain.ankitk@gmail.com) - Mon, 20 Dec 2021 18:31:53 -0500
    * Made changes.
    and some other test in the same JVM happened to
    composite aggregation.
    Signed-off-by: dblock &lt;dblock@dblock.org&gt;
     Signed-off-by: Vacha Shah &lt;vachshah@amazon.com&gt;
  * fixed unit test for plugin install help output by correctly identifying the
    [Vacha](mailto:vachshah@amazon.com) - Tue, 30 Nov 2021 17:17:21 -0500
    expressions
* __[BUG] Serialization bugs can cause node drops (#1885) (#1911)__
    Signed-off-by: Vacha Shah &lt;vachshah@amazon.com&gt;
* __[Backport 1.x] Avoid logging duplicate deprecation warnings multiple times (#2315)__
    This commit restructures InboundHandler to ensure all data
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Fri, 4 Mar 2022 15:21:54 -0500
    &lt;dblock@dblock.org&gt;
    the same
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    * Stabilizing
    the opposite case in RolloverIT.java where the appender was stopped
    nodes were to go down before relocating other shards. Note that
    [github-actions[bot]](mailto:41898282+github-actions[bot]@users.noreply.github.com) - Wed, 2 Feb 2022 21:05:15 -0500
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
     Signed-off-by: Tianli Feng &lt;ftl94@live.com&gt;
* __Update to log4j 2.17.0 (#1771) (#1773)__
    Signed-off-by: Matt Weber &lt;matt@mattweber.org&gt;
    * Fix up settings
     Co-authored-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
    * Updating .gitattributes for additional types
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Thu, 10 Feb 2022 13:48:38 -0500
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    * [BUG] Wait for outstanding requests to complete in LastSuccessfulSett…
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Downgrade to JDK 11. (#2301)__
    [2]
    [Matt Weber](mailto:matt@mattweber.org) - Fri, 18 Feb 2022 11:52:52 -0500
    [Jan Baudisch](mailto:jan.baudisch.de@gmail.com) - Tue, 23 Nov 2021 10:20:07 -0500
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Support first and last parameter for missing bucket ordering in composite aggregation (#1942) (#2049)__
      (cherry picked from commit b9420d8f70dfc168b9d44f736850af4ef7306a99)
* __Integration test that checks for settings upgrade  (#1482) (#1524)__
    * Avoid logging duplicate deprecation warnings multiple times
    Fixed integration tests failure on Linux with Kernel 5.16.x
    (cherry picked from commit 9224537704bb12980a129afb1e7b6ba6ab93680e)
    * [BUG] Wait for outstanding requests to complete in
* __Fixing soft deletes deprecation warning (#2339)__
    Signed-off-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
    Signed-off-by: Rabi Panda &lt;adnapibar@gmail.com&gt;
    V_1_3_0.
    * update SHA1 file
     Signed-off-by: Suraj Singh &lt;surajrider@gmail.com&gt;
    * Fix up check style
    by a skewness limit.
        leader considers itself to have failed. It stands down and starts trying to
    to leverage try-with-resources; no testing logic has been changed.
     Avoid use of -Werror -Xlint:all, which may change significantly across
    * Fix up tests
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
* __Make SortBuilders pluggable (#1856) (#1915)__
    test logic into an independent test class. This PR also updates
    [Ashish Agrawal](mailto:ashisagr@amazon.com) - Wed, 5 Jan 2022 08:15:56 -0500
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Thu, 10 Feb 2022 17:21:12 -0800
* __[plugin] repository-azure is not working properly hangs on basic operations (#1740)__
    - Make all archive tasks in gradle reproducible by ignoring timestamp on files
     Signed-off-by: dblock &lt;dblock@dblock.org&gt;
    indices, shards, replicas, and nodes. The larger the indices, replicas, and
    * Use JDK 11.0.14.1+1.
        down and effectively block the cluster from making progress.
    [Daniel Doubrovkine (dB.)](mailto:dblock@dblock.org) - Wed, 2 Mar 2022 13:37:23 -0500
     Signed-off-by: dblock &lt;dblock@amazon.com&gt;
    it upon
     Co-authored-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
    Signed-off-by: Sarat Vemulapalli &lt;vemulapallisarat@gmail.com&gt;
     Signed-off-by: Andrey Pleskach &lt;ples@aiven.io&gt;
        cluster.publish.timeout settings. If this time is reached before the new
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    By default, if order is asc, missing_bucket at first,
    * [plugin] repository-azure: add configuration settings for
    * Upgrading Jackson-Databind version
* __Another attempt to fix o.o.transport.netty4.OpenSearchLoggingHandlerIT fails w/ stack overflow (#2051) (#2055)__
    Signed-off-by: Jan Baudisch &lt;jan.baudisch.libri@gmail.com&gt;
    required for a workaround to enable the jacoco code coverage for Integ Tests.
     Signed-off-by: Breno Faria &lt;breno.faria@intrafind.de&gt;
    setting enabled performance of this change is a direct function of number
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
    [aponb](mailto:apre@gmx.at) - Mon, 7 Mar 2022 15:14:36 -0800
    max_merge_at_once_explicit is removed in lucene 9 so the index setting is
* __Lower build requirement from Java 14+ to Java 11+ (#940) (#1608)__
    * [BUG] Wait for outstanding requests to complete in
     Co-authored-by: Owais Kazi &lt;owaiskazi19@gmail.com&gt;
* __Expand SearchPlugin javadocs. (#1909) (#1923)__
    [Nick Knize](mailto:nknize@apache.org) - Wed, 2 Feb 2022 12:28:44 -0500
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Fri, 17 Dec 2021 16:08:30 -0500
* __Updated the url for docker distribution (#2325) (#2360)__
    * Auto-increment next development iteration.
     Signed-off-by: Suraj Singh &lt;surajrider@gmail.com&gt;
    [Marc Handalian](mailto:handalm@amazon.com) - Wed, 12 Jan 2022 17:03:42 -0800
* __Fix AssertionError message (#2044) (#2045)__
    * Adding test for filter settings update
    shard1 and shard2 first so the cluster does not become
     Changes made by deleting the TestSettingsIT file and adding new lines in
     Signed-off-by: Andrew Ross &lt;andrross@amazon.com&gt;
    running test in the same JVM could cause a logging failure. This seems
     Co-authored-by: Andrey Pleskach &lt;ples@aiven.io&gt;
    [Bukhtawar Khan](mailto:bukhtawa@amazon.com) - Mon, 7 Feb 2022 09:58:10 -0500
    FullClusterRestartSettingsUpgradeIT.java
    longer accepted on JCenter.  This means we should no longer use JCenter for our
    - azure.client.*.proxy.password - Proxy user password
        cluster state is committed, then the cluster state change is rejected and the
    [github-actions[bot]](mailto:41898282+github-actions[bot]@users.noreply.github.com) - Wed, 26 Jan 2022 17:41:33 -0600
    the shutdown of JCenter. Later on April 27 2021, an update was provided that
    * Signed-off-by: Megha Sai Kavikondala &lt;kavmegha@amazon.com&gt;
     Signed-off-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
    * Signed-off-by: Megha Sai Kavikondala &lt;kavmegha@amazon.com&gt;
    * Issue Description
    of
    [Ryan Bogan](mailto:10944539+ryanbogan@users.noreply.github.com) - Thu, 11 Nov 2021 11:02:03 -0800
     Signed-off-by: Tianli Feng &lt;ftl94@live.com&gt;
     Signed-off-by: Breno Faria &lt;breno.faria@intrafind.de&gt;
* __[Backport] Handle shard over allocation during partial zone/rack or independent … (#1268)__
      - register regexp interval in SearchModule
    warnings
    When some node or set of nodes is excluded (based on some cluster setting)
* __Support Gradle 7 (#1609) (#1622)__
    each node are picked randomly it&#39;s possible the p and r of
    * Exclude some API usage violations in the package com.google.protobuf for
     Signed-off-by: Ryan Bogan &lt;rbogan@amazon.com&gt;
    Reproducible builds is an initiative to create an independently-verifiable path
* __Fix flaky test case - string profiler via global ordinals (#2226) (#2313)__
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
     Note that bwc w/ legacy versions are still supported so some cross
     Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    before it was closed, therefore creating a race where a concurrently
          beginning og the non-option argument list
* __Upgrade to log4j 2.16.0 (#1721) (#1723)__
* __Add version 1.2.1. (#1701) (#1702)__
* __Upgrade to logj4 2.15.0 (#1705)__
    This reverts commit 8725061c15fac70a81d144ed2d79b09f5e1a2f7f.
    * Update SearchModuleTests.java
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    &#34;last&#34;, regardless order, missing_bucket is at first or last respectively.
    * change flavor version check to V_1_3_0
    Robert Muir &lt;rmuir@apache.org&gt;
    [SOURCE_DATE_EPOCH]: https://reproducible-builds.org/docs/source-date-epoch/
    individually.
    Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
    releases (new warnings could be added). Instead, just list the
    was never added to a Logger before it was started. I subsequently found
     Signed-off-by: dblock &lt;dblock@amazon.com&gt;
    * Fixes test failures
       warning: [options] source value 7 is obsolete and will be removed in a future release
* __Replace JCenter with Maven Central. (#1057) (#1892)__
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
    [Andriy Redko](mailto:andriy.redko@aiven.io) - Tue, 14 Dec 2021 06:47:00 -0500
    * Introduce FS Health HEALTHY threshold to fail stuck node (#1167)
     Signed-off-by: Peng Huo &lt;penghuo@gmail.com&gt;
* __Update bundled JDK distribution to 17.0.2+8 (#2007) (#2009)__
    * Update protobuf-java to 3.19.3
     Co-authored-by: CEHENKLE &lt;henkle@amazon.com&gt;
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
     Co-authored-by: Vacha &lt;vachshah@amazon.com&gt;
     Signed-off-by: Vacha &lt;vachshah@amazon.com&gt;
        flushing of cluster state is stuck on IO, so will the cancellation of the
* __Renaming Slave terminology to Replica in 1.x branch (backporting) (#1645)__
     Co-authored-by: Robert Muir &lt;rmuir@apache.org&gt;
     Signed-off-by: Robert Muir &lt;rmuir@apache.org&gt;
         There is a bug in leader that when it tries to publish the new cluster state
    not depend on ordering.
    [github-actions[bot]](mailto:41898282+github-actions[bot]@users.noreply.github.com) - Wed, 2 Feb 2022 14:52:31 -0800
     Co-authored-by: Ankit Jain &lt;jain.ankitk@gmail.com&gt;
     Signed-off-by: Nicholas Walter Knize &lt;nknize@apache.org&gt;
    * ./gradlew :build-tools:spotlessApply
    I also made a static helper in MockLogAppender to start
    inside of intervals queries.
    * Backport Enabling Sort Optimization to make use of Lucene
         Signed-off-by: Bukhtawar Khan &lt;bukhtawa@amazon.com&gt;
    leaving behind both p and r of shard2. If the
    * Add regexp interval source
     Signed-off-by: Megha Sai Kavikondala &lt;kavmegha@amazon.com&gt;
    * Updating test names
* __Intermittent java.lang.Exception: Suite timeout exceeded (&gt;= 1200000 msec) (#1827)__
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Fri, 11 Feb 2022 11:07:46 -0500
    (#1939)
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Wed, 2 Mar 2022 15:46:28 -0800
* __Adding shards per node constraint for predictability to testClusterGr… (#2110) (#2265)__
     Signed-off-by: Mau Bach Quang &lt;quangmaubach@gmail.com&gt;
     Signed-off-by: Vacha Shah &lt;vachshah@amazon.com&gt;
    Distribution Url When User Passes a Url
    * Backport Enabling Sort Optimization to make use of Lucene and small change in
* __Move Gradle wrapper and precommit checks into OpenSearch repo. (#1664) (#1678)__
    [Nicholas Walter Knize](mailto:nknize@apache.org) - Fri, 4 Feb 2022 18:29:35 -0600
    Version.fromString
     Signed-off-by: Ashish Agrawal &lt;ashisagr@amazon.com&gt;
    Added username/password proxy settings for Azure repository.
    Signed-off-by: Andriy Redko &lt;andriy.redko@aiven.io&gt;
* __Fixing .gitattributes for binary content, removing *.class files (#1717) (#1720)__
* __Revert &#34;Support Gradle 7 (#1609) (#1622)&#34; (#1657)__
    * Update bc-fips to 1.0.2.1
    [opensearch-trigger-bot[bot]](mailto:98922864+opensearch-trigger-bot[bot]@users.noreply.github.com) - Mon, 7 Mar 2022 11:52:46 -0500
     The java version checker triggers some default warnings because it
    (cherry picked from commit cdb42ad3013f67970def21e15c546c9c4fd08d6f)
