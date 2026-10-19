### Don't
cd fcml*
## Running Microbenchmarks
* Fix the CPU frequency to avoid Turbo Boost from kicking in and skewing your results. On Linux you can use `cpufreq-set` and the
`MemoryStatsBenchmark`, you can use `--args`:
end the class name of a benchmark with `Benchmark`. To have JMH execute a benchmark, annotate the respective methods with `@Benchmark`.
* Ensure that the system executing your microbenchmarks has as little load as possible. Shutdown every process that can cause unnecessary
make
# OpenSearch Microbenchmark Suite
Microbenchmarks are intended to spot performance regressions in performance-critical components.
on 2020-08-01:
If you want to run a specific benchmark class like, say,
## Adding Microbenchmarks
    * Add `-prof gc` to the options to check whether the garbage collector runs during a microbenchmarks and skews
```
directory. It will build all microbenchmarks, execute them and print
  `performance` CPU governor.
* Vary the problem input size with `@Param`.
tar xf fcml*
### Do
Disassembling is fun! Maybe not always useful, but always fun! Generally, you'll want to install `perf` and FCML's `hsdis`.
* Avoid CPU migrations by pinning your benchmarks to specific CPU cores. On Linux you can use `taskset`.
## Getting Started
The microbenchmark suite is also handy for ad-hoc microbenchmarks but please remove them again before merging your PR.
inside the `'`s is important. Without it parameters are sometimes sent to
## Purpose
Before adding a new microbenchmark, make yourself familiar with the JMH API. You can check our existing microbenchmarks and also the
because we have no control over the JVM running the benchmarks.
sudo cp .libs/libhsdis.so.0.0.0 /usr/lib/jvm/java-14-adoptopenjdk/lib/hsdis-amd64.so
Just run `gradlew -p benchmarks run` from the project root
gradlew -p benchmarks run --args ' MemoryStatsBenchmark'
## Disassembling
```
* Blindly believe the numbers that your microbenchmark produces but verify them by measuring e.g. with `-prof perfasm`.
gradlew -p benchmarks run --args ' MemoryStatsBenchmark -jvmArgs "-XX:+UnlockDiagnosticVMOptions -XX:CompileCommand=print,*.yourMethodName -XX:PrintAssemblyOptions=intel"
To get realistic results, you should exercise care when running benchmarks. Here are a few tips:
[JMH samples](http://hg.openjdk.java.net/code-tools/jmh/file/tip/jmh-samples/src/main/java/org/openjdk/jmh/samples/).
   your results. If so, try to force a GC between runs (`-gc true`) but watch out for the caveats.
```
wget https://github.com/swojtasiak/fcml-lib/releases/download/v1.2.2/fcml-1.2.2.tar.gz
## Tips and Best Practices
If you want `perf` to find the hot methods for you then do add `-prof:perfasm`.
```
`perf` is generally available via `apg-get install perf` or `pacman -S perf`. FCML is a little more involved. This worked
cd example/hsdis
* Have your benchmarks peer-reviewed.
./configure
make
```
* Run more threads than your number of CPU cores (in case you run multi-threaded microbenchmarks).
gradle.
* Ensure to run enough warmup iterations to get the benchmark into a stable state. If you are unsure, don't change the defaults.
the result.
If you want to disassemble a single method do something like this:
* Use the integrated profilers in JMH to dig deeper if benchmark results to not match your hypotheses:
* Look only at the `Score` column and ignore `Error`. Instead take countermeasures to keep `Error` low / variance explainable.
  runtime jitter. Watch the `Error` column in the benchmark results to see the run-to-run variance.
Running via an IDE is not supported as the results are meaningless
```
This directory contains the microbenchmark suite of OpenSearch. It relies on [JMH](http://openjdk.java.net/projects/code-tools/jmh/).
In contrast to tests, the actual name of the benchmark class is not relevant to JMH. However, stick to the naming convention and
    * Add `-prof perf` or `-prof perfasm` (both only available on Linux) to see hotspots.
Everything in the `'` gets sent on the command line to JMH. The leading ` `
