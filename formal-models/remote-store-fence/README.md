Three requirements make these hold, and how load-bearing each one is was **measured** by relaxing it
#### The fence is claimed twice, and re-adoption requires recorded ownership
appointments, partitioned-writer acknowledgements, claim races, relocation handoff and abort,
TLA+ models of the object-store-backed primary fencing protocol
deductive proof for unbounded parameters. A TLAPS proof of mutual exclusion and no-acked-write-loss
| **restore point** | The latest translog metadata a recovering copy replays from. |
tla/FenceSegmentFlow.tla        the segment flow as a second path needing the fence, plus GC
| `FenceAutoRestore.tla` | the auto-restore trigger for a primary with no surviving copy: node-left is a view change, the departed writer keeps running, and the fence — not the trigger — is what makes that safe; `FENCED = FALSE` (the ungated trigger) is refuted in a 7-state `NoAckedWriteLoss` counterexample; the operator's `_remotestore/_restore` is modeled as the same mutation under its weaker only-unassigned guard, racing the trigger and the rejoin; the node-left grace window (`index.unassigned.node_left.delayed_timeout`) gates the trigger but not the operator API nor the rejoin, with its expiry weakly fair (`DelayedAllocationService`'s promise); health is modeled RED-until-started (never overstating availability) | 3 writers, 2 nodes, 3 ops, 4 terms | 165,936 |
id, and the re-adoption is refused unless the path still records it. This is the same
README.md                       this file: terms, the invariants, what is proved, how to run it
**Exhaustive model checking with TLC** over bounded models, with a complete state graph in every
is used:
| **partitioned writer** | A previous primary that has dropped out of the cluster's view but can still reach the object store. The case this protocol exists for. |
trusts, so obtaining it means fetching a GitHub release asset. Doing that and verifying a pinned
gone: whatever it listed is either still in the store or already fetched. **OwnerNeverReadUnsealed**
**Action properties** — hold across every transition:
|---|---|
Four modules, each modeling the protocol **as implemented**:
| **superseded** | A strictly higher term now holds the fence, so this copy has to stop touching shared state. |
the acknowledged write survives.
— so a late revert cannot displace a target that already acknowledged.
| `FenceTakeover.tla` | cross-term takeover: is a higher-term victory deterministic, and is the window between the seal claim and the translog's re-adoption safe? | 4 writers, 4 terms, 3 ops, symmetry | 4,460,896 |
**HydrationIntegrity** — the copy that owns the fence must never find a file it still needs already
Everything below leans on these, so they are worth pinning down first.
2. **No acked write loss.** The one that matters most. Once the owner has
> Every count here is TLC's **final** summary. Do not read the first `distinct states found` in TLC's
*sufficient*: what the property needs is **at least one** of them, not both. The reason is visible in
   orphan metadata file names operations that were never acknowledged. The
| **fence** | The small mutable object that records who currently holds the right to acknowledge writes. |
from it, so remote state is read on both the translog flow and the segment flow, and both need the fence.
Determinism is stated as safety, which is what makes it exhaustively checkable:
path on its first upload (`ReAdoptList`/`ReAdoptTake`). An equal-term twin may appear and arbitrate
They are licensed by the necessity result above rather than by luck: relaxing the publication gate
via an inductive invariant is the natural follow-up if that is wanted.
The implementation keeps both regardless, for reasons the model cannot express rather than any it
State, for the seal-ordering module, which abstracts the acknowledgement
| `RemoteStoreFence.tla` | seal ordering and acked-write loss | 3 writers, 3 terms, 3 ops | 19,846 |
  smaller only because that module checks *liveness*, whose cost dominates state count.
The re-adoption is authorized by **recorded ownership**: the seal recorded this copy's allocation
never match.
which is what `NoAckedWriteLoss` asserts.
   `∀w : (state(w) = fresh ∧ term(w) > F.term) ⇝ (F.term ≥ term(w) ∨ state(w) = fenced)`
These follow from five protocol rules:
Relocation happens at a constant term, so source and target share one object and term-scoping says
gate is evaluated once at the top of a sync that then runs for some time, so a copy can publish after
and a restore point `restore(w)` read from the store; and a global set
The fencing token is the CAS chain — the object's version token, or ETag —
reference set. Modelling retention would turn this into a *bound* — safe while the source publishes
2. Corroborate it against **upstream's own published checksum**, a distribution package, or a fetch
| **Both** ownership checks | `HydrationIntegrity` **violated** |
The asymmetry between the two failure directions is what makes the fail-open publish defensible, which
is discarded once the claim returns; the translog restore point is then read holding **no live
so a brand-new incarnation can still take over a dead incumbent's path, whose recorded owner it can
the failure trace — one copy performs both the publish and the prune, so gating either action breaks
the two, and the sweep still runs. The module explores that ordering rather than assuming it away;
`∀w : state(w) = fenced ⇒ fencedBy(w) ≥ term(w)`
over `PEER` — so it hydrates segments **without sealing**, while its same-term source keeps publishing
token** (state `read` in the module); and the shard's own translog instance re-adopts the same-term
  issuance, and at most one active primary per shard — and is otherwise
| **control flow** | The path carrying decisions about *who may write*. The fence object is the only thing on it. |
   it from there rather than from a third-party release URL.
the object store order grants it cannot interpret — while performing no I/O itself.
- **5 writers exceeds this machine**, not the protocol. The run was still exploring with ~18M
Step 3 is where a checksum belongs, enforced by whatever guards that storage. This build takes the jar
## The invariants
   reproduces that refuted design and TLC exhibits the trace in a
those paths gone.
   after the metadata PUT completed — restores the invariant by
   CAS can win against the incumbent's object *before* a takeover's sweep
## Running
TLC ships in `tla2tools.jar`, which is not on Maven Central or any registry this build already
**NoSpuriousFencing** — an aborted handoff must not fence a healthy source:
  models only through the `Appoint*` actions.
- **Seal ordering** was verified at 4 writers / 4 terms / 4 ops out of band: 3,691,705 distinct
  uninvolved (*no cluster-manager synchronization*). It appears in the
The guard's necessity was **measured** rather than assumed, in the same way as the segment-flow
and reads its restore point; an equal-term twin arbitrates the chain over and acknowledges a write;
jar, comparing it against a number written here would establish nothing: if they vetted it the check
becoming superseded. Both are states the model forbids.
Verifying the artifact is the caller's job, and belongs where the jar is obtained rather than where it
incumbent is hydrating for exactly this reason.
`held(w)`, a lifecycle state in `{unborn, fresh, sealed, active, fenced}`
   (`SEQUENCED` selects the write-side ordering): issued concurrently, the
Without a jar the tasks fail with instructions. Individual modules run as `:formal-models:tlcRemoteStoreFence`, `tlcFenceTakeover`, `tlcFenceHandoff`, `tlcFenceSegmentFlow`.
**Liveness** — under weak fairness of the claimant's read and CAS:
   store, which can be a strict *superset* of `acked`: a fenced writer's
```
fewer than N times during the target's hydration — which is a rate argument rather than a guarantee.
by talking to each other.
different resources — the refresh listener for segments, `trimUnreferencedReaders` for the translog.
nothing about them. The source still owns the chain and has drained its uploads, so it performs the
| **sweep** | The delete step of a claim — removing every acknowledgement path below your own term. |
- ownership fields are advisory, and the token chain is the only authority
| `FenceHandoff.tla` | equal-term relocation handoff, retried relocation, concurrent higher-term takeover, target loss | 4 ops, 3 attempts | 591 |
first copy is fenced at the re-adoption instead, fails its shard, and recovers at a higher term —
|---|---|
| **CAS** | Compare-and-swap: a write the store accepts only if the object's current version is the one you present, and refuses otherwise. S3 `If-Match`, GCS generations, Azure ETags. Presenting no version means "only if absent". |
3. **Ack attribution.** `⋃_w ackedBy(w) = acked`, and the `ackedBy(w)` are
tests `fenceTerm > wTerm[w]`, so an **equal-term** copy is never superseded and both ownership gates
restore point read before the twin's acknowledgement, which is thereby lost. With the guard, the
So seal-before-read is needed on its own, but the two ownership checks are each individually
recovery seal claims through a *throwaway* fence instance (`RemoteFsTranslog#sealFence`) whose token
| Term | What it means |
transfer, applied uniformly to every translog instance. Only the seal itself arbitrates unguarded,
| **orphan** | A metadata file that a fenced writer published but never acknowledged. Harmless, but it accumulates. |
**not** sound with liveness properties in general.
| **fencing token** | Whatever a writer has to present to prove it may still write. Here that is the current CAS token. |
  (*the owner is advisory*);
it is given and does not pretend to have verified it.
is the ordering twin, asserting that an owner never read remote state before it owned the fence.
   point — the acknowledged operation is then in no successor's restore
   Put another way: nothing a superseded writer acknowledged lands after
## Layout
together with the symmetric **TargetAcksAreDurable** — `ackedBy(target) ≠ ∅ ⇒ state(source) ≠ resumed`
tla/RemoteStoreFence.tla        seal ordering and acked-write loss
   (`SEQUENCED = TRUE`).
  behaviour. Confirmed exactly: 4 writers at `MaxTerm` 4, 5 and 8 each explore the *identical*
  third-party binary. Supplementary verification of a design spec is not worth that blast radius,
ownership transfer itself as its last act before handing off, and keeps the resulting token. The
object, a claim-object escalation scheme, and a target-claims handoff — were each refuted by TLC and
  states from 8,200,777 generated, 0 left on queue, all properties holding. The committed bound is
`FenceSegmentFlow.tla` appoints only at `HighestIssuedTerm + 1`, so every copy in it is either the
1. Obtain `tla2tools.jar` from the TLA+ project's own release channel.
## What is proved, and how
```
it warns against. Because the caller supplies the
and collecting. **The fence does not protect that case**, and nothing here claims it does.
Each run explores its **complete** state graph — 0 states left on queue — so nothing is missed
Issuing a grant does not revoke the incumbent — revocation happens when the successor takes the
  (*seal before restore*), and that ordering on its own is what makes (2)
is redundant, and if they did not, this repository's digest cannot help.
### Vetting the jar
  since each appointment consumes one unborn writer, so `MaxTerm ≥ |Writers|` adds no reachable
- A checksum pinned in the **same change** that introduces the download only proves the bytes are
| `FenceSegmentFlow.tla` | the segment flow as a second path needing the fence, plus garbage collection | 3 writers, 3 files, 3 terms | 20,008 |
`sealRemoteStoreFenceBeforeRestore` exempts `PEER` recovery, and a primary relocation target recovers
TLC shows *"only the highest granted term may acknowledge"* is false of any correct protocol.
   pairwise disjoint — every ack belongs to exactly one writer.
```bash
- a takeover claims the chain **before** reading its restore point
### Cross-term takeover — `FenceTakeover.tla`
What protects it is metadata **retention**, not the fence: `deleteStaleSegmentsAsync` keeps the last N
# Remote Store Fence — formal specification
authority — it issues the term, the term names the key, and create-if-absent plus name ordering let
vouch for itself, and a disclaimed pin sitting in the repository invites exactly the false confidence
  was reported violated at any bound.
   `|{ w : state(w) ∈ {sealed, active} ∧ held(w) = F.token }| ≤ 1`
  4,460,896 distinct states (9,616,026 generated, 0 left on queue, depth 38), all clean.
symmetric in `Writers` and only invariants are checked. It gives roughly a 6× reduction, and it is
One deliberate code-faithfulness point: `DeleteLowerPaths` is guarded on having taken the path
`state(source) = fenced ⇒ ackedBy(target) ≠ ∅`
| Ownership check on segment metadata publication, alone | no violation |
### The segment flow and GC — `FenceSegmentFlow.tla`
within these bounds. Larger bounds were probed out of band:
1. **Mutual exclusion.** At most one live writer holds the current token,
is the practical value of the "either one alone suffices" measurement.
implementation's publish path **fails open** — an unreadable fence reports "not superseded" — and the
over, so the source stands down. The object store settles an ambiguity the two copies cannot settle
points in the real shard lifecycle; and in the code the two guards sit on different paths guarding
tla/*.cfg                       one TLC configuration per module
the chain over *during* that tokenless hydration window — the module admits appointments while the
### On the bounds
TLA_TOOLS_JAR=/path/to/tla2tools.jar ./gradlew :formal-models:modelCheck
### One property deliberately not asserted
That is defence in depth, not redundancy the model endorsed.
| Module | Question | Bound | States |
token: success means the target never wrote, so the source resumes; failure means the target took
| **CAS chain** | The succession of version tokens one fence object passes through. A successful write must present the current token and hands back the next, so links cannot be skipped — holding the current token *is* ownership, and a writer that misses one can never rejoin. Defined in full on `RemoteStoreFence`. |
   always permitted; that direction is load-bearing. What `visible` cannot
(`RemoteStoreFence.java`, PR #22774 / RFC #22768). One mutable
it is safe because destructive acts stay strictly below the sweeper's own term, and both twins want
The two shard-data paths are named separately throughout rather than lumped together as "the data
tla/FenceTakeover.tla           cross-term takeover determinism
writers `w ∈ W`, each with an appointed term `term(w)`, a held token
3. Mirror the vetted jar into artifact storage the project already trusts, and have any CI job take
`:formal-models:check` does nothing, and the tasks fail closed unless a jar is passed explicitly.
the first copy's unguarded re-adoption *steals the chain back* and serves as the live owner from a
acknowledgement path — so there is always a window where the previous owner still acknowledges
and never out-raced by a lower-term incumbent:
   contain is metadata still in flight, and that gap is why the module
> output: that is a mid-run `Progress(...)` line and varies run to run, understating the total.
collection gated nothing prunes to a moved set.
something to fold in here at the cost of the cross-term result.
8. **A higher term prevails.**
listed but not yet fetched. That was measured, not assumed.
It matters because the code does reach the segment flow at an equal term.
   invariant is a `⊆`, so surfacing a never-acknowledged operation is
flow", because they are fenced by different means — a CAS on the translog flow, an ownership check on
4. **Owner/term agreement.** `F.owner ≠ ⊥ ⇒ F.term = term(F.owner)`
metadata files and everything they reference, whereas `Gc` in the model prunes to the single latest
   while the metadata lands only *after* the takeover read its restore
|---|---|---|---|
- a claimant below the fence term is refused, an equal or higher one may
  states queued when it was stopped. That is a resource limit and *not* a violation: no invariant
- **Takeover saturates in `MaxTerm`.** With N writers the failover chain can reach at most term N,
`fence__<term>` object per primary term, written only by compare-and-swap.
tla/FenceAutoRestore.tla        the zero-replica auto-restore trigger over the fence
tla/FenceHandoff.tla            equal-term relocation handoff
A shard publishes segment metadata as well as translog metadata, and a recovering copy hydrates
SHA-256 afterwards would not be good enough:
| **seal**, or **claim** | Take the fence over at your own term: create your own key, then delete every lower-term key. |
owner or **strictly** superseded. That bound is load-bearing rather than incidental: `Superseded(w)`
segment publication and collection, and restore-point reads is checked. This is not a TLAPS
| **hydration** | Downloading the segment files named by the latest segment metadata. |
   and that writer is the recorded owner.
   splits the acknowledgement into a metadata PUT, a fence CAS and a join
Model checking is **opt-in, and the build downloads nothing.** Supply `tla2tools.jar` yourself:
and not the primary term itself.
- cluster coordination contributes exactly two properties — monotonic term
| Ownership check on GC, alone | no violation |
   read its restore point, every acknowledged operation is either in that
**Safety** — holds in every reachable state:
`Refresh` and `Gc` both require `~Superseded(w)`, which presumes the check is accurate. The
gates: relax it — let the re-adoption take over whatever token the path carries, which is what the
   happens-before and is what `RemoteStoreFence.cfg` checks
| **translog flow** | Translog files and their metadata — the acknowledgement path, gated directly by the fence CAS. |
   from a different network and host.
term, so a lower-term writer cannot touch a higher-term writer's acknowledgement path. Determinism
5. **Term monotonicity.** `□[F.term' ≥ F.term]_vars`
the source publishes a second reference set and then collects, deleting a file the equal-term copy had
code did before the guard — and TLC violates `NoAckedWriteLoss` with a 17-state trace. A copy seals
are not kept as live configurations.
   `F.owner ≠ ⊥ ∧ hasRead(F.owner) ⇒ acked ⊆ restore(F.owner) ∪ ackedBy(F.owner)`
```
  and it also broke air-gapped builds.
   13-state counterexample; the shipped ordering — the CAS is issued only
`acked` of acknowledged operations, attributed by `ackedBy(w)`.
### What the segment flow does not cover
6. **Seq monotonicity.** `□[F.token' > F.token ⇒ F.seq' = F.seq + 1]_vars`
path as a single CAS register: a fence `F = (token, term, seq, owner)`;
proved. `Gc(w)` requires `wState = "active"`, so the model cannot represent collection at other
### Why it is not part of `check`
target is authorized by **recorded ownership**. On abort the source attempts a revert with that
the segment flow — so which one is meant always matters.
That belongs in a module of its own alongside `FenceHandoff.tla`, and is an open follow-up rather than
> `registerTlcTask` matches the final summary and fails the build if any states are left on queue.
- an ack is a successful CAS on the chain (*the chain gates the ack*);
  hold;
Symmetry reduction (`SYMMETRY Symm`) is used only on `FenceTakeover`, where the specification is
recorded-ownership mechanism the relocation target uses to defer adoption until the source's
Alternative designs evaluated and refuted along the way — a single shared acknowledgement-path
**NoHigherTermDefeat** — a copy may only ever be defeated by a term at least as high as its own,
comes from the key space rather than from winning a race. Cluster coordination supplies the
### On the gates being checked, not assumed
against the model rather than argued. The answer is not uniform:
# or
There is **deliberately no pinned checksum**. A digest recorded by whoever added the reference cannot
7. **Fenced is terminal.** `□[∀w : state(w) = fenced ⇒ state'(w) = fenced]_vars`
   point, ever. Setting the module's `SEQUENCED` constant to `FALSE`
| **segment flow** | Segment files and their metadata — what a recovering copy hydrates from, gated by an ownership check rather than a CAS. |
   restore point or was acknowledged by the owner itself.
### Relocation handoff — `FenceHandoff.tla`
the chain. With publication gated the reference set cannot move under a hydrating owner; with
Until that vetting happens, the exposure is limited by design: nothing is downloaded,
- Wired into `check`, every CI environment running `./gradlew check` would pull an unmanaged
always pass for it. Adding an equal-term actor makes `HydrationIntegrity` itself false in 11 states —
| Requirement relaxed | Result |
  self-consistent. It cannot establish that the URL, the release asset, or the digest are the
   the restore point its successor serves from. The seal-ordering module
(`wTook`), **not** on still holding its current token, because the implementation sweeps straight
after its successor was appointed. That window is exactly what seal-before-restore makes safe,
  **Writers, not terms, is the scaling dimension.**
The implementation claims the fence **twice** per takeover, and the module models both claims. The
This holds because a writer's only destructive act is deleting objects **strictly below** its own
  claim, and the CAS settles concurrent claimants (*the term never
after its create/arbitration without re-verifying possession. A twin may take the path over between
  upstream project's — all three need corroborating out of band, by a person.
| **acknowledgement path** | The per-term fence object a writer advances on every ack. Deleting it is what stops a stale writer. |
| Seal before read, back to the old code order — hydrate segments, then seal | `OwnerNeverReadUnsealed` **violated** |
./gradlew :formal-models:modelCheck -PtlaToolsJar=/path/to/tla2tools.jar
  regresses*);
   sets `restore(w) = visible` — the metadata that has *landed* in the
*alone* yields no violation, because collection is gated — and the collection paths **fail closed**.
case and 0 states left on queue; see *On the bounds* below. Every reachable interleaving of
## Terms
