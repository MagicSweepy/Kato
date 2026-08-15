const fs = require('fs');
const path = require('path');

const typeParams = (k) => {
  const a = [];
  for (let i = 1; i <= k; i++) a.push(`T${i}`);
  a.push('R');
  return a.join(', ');
};
const funcType = (k) => `(${Array.from({ length: k }, (_, i) => `T${i + 1}`).join(', ')}) -> R`;
const ids = (k) => Array.from({ length: k }, (_, i) => i + 1); // 1..k

// curryN: (T1..Tk) -> R  =>  (T1..Tn) -> ((T(n+1)..Tk) -> R)
function curryFn(k, n) {
  const suffix = n === 1 ? '' : String(n);
  const outer = ids(n);
  const inner = ids(k - n).map((i) => n + i);
  const outerT = `(${outer.map((i) => `T${i}`).join(', ')})`;
  const innerT = `(${inner.map((i) => `T${i}`).join(', ')}) -> R`;
  const outerLam = outer.map((i) => `t${i}: T${i}`).join(', ');
  const innerLam = inner.map((i) => `t${i}: T${i}`).join(', ');
  const callArgs = ids(k).map((i) => `t${i}`).join(', ');
  return `fun <${typeParams(k)}> (${funcType(k)}).curry${suffix}(): ${outerT} -> (${innerT})
    = { ${outerLam} -> { ${innerLam} -> invoke(${callArgs}) } }`;
}

// uncurryN: (T1..Tn) -> ((T(n+1)..Tk) -> R)  =>  (T1..Tk) -> R
function uncurryFn(k, n) {
  const suffix = n === 1 ? '' : String(n);
  const outer = ids(n);
  const inner = ids(k - n).map((i) => n + i);
  const recv = `(${outer.map((i) => `T${i}`).join(', ')}) -> ((${inner.map((i) => `T${i}`).join(', ')}) -> R)`;
  const lam = [...outer, ...inner].map((i) => `t${i}: T${i}`).join(', ');
  const outerArgs = outer.map((i) => `t${i}`).join(', ');
  const innerArgs = inner.map((i) => `t${i}`).join(', ');
  return `fun <${typeParams(k)}> (${recv}).uncurry${suffix}(): ${funcType(k)}
    = { ${lam} -> invoke(${outerArgs})(${innerArgs}) }`;
}

// apN: apN reuses ap(N-1) after applying the first arg
function apFn(n) {
  const kindArgs = ids(n).map((i) => `f${i}: Kind<F, T${i}>`).join(', ');
  const tail = ids(n - 1).map((i) => `f${i + 1}`).join(', ');
  const body = n === 2
    ? 'ap(ap(map({ it.curry() }, ff), f1), f2)'
    : `ap${n - 1}(ap(map({ it.curry() }, ff), f1), ${tail})`;
  return `fun <${typeParams(n)}> ap${n}(ff: Kind<F, ${funcType(n)}>, ${kindArgs}): Kind<F, R>
    = ${body}`;
}

// mapN: curried overload delegates via uncurry; tupled overload curries then ap(N-1)
function mapFn(n) {
  const kindArgs = ids(n).map((i) => `f${i}: Kind<F, T${i}>`).join(', ');
  const fArgs = ids(n).map((i) => `f${i}`).join(', ');
  const curriedT = `(T1) -> ((${ids(n - 1).map((i) => `T${i + 1}`).join(', ')}) -> R)`;
  const sigC = `fun <${typeParams(n)}> map${n}(${kindArgs}, f: ${curriedT}): Kind<F, R>
    = map${n}(${fArgs}, f.uncurry())`;
  const tail = ids(n - 1).map((i) => `f${i + 1}`).join(', ');
  const bodyT = n === 2
    ? 'ap(map(f.curry(), f1), f2)'
    : `ap${n - 1}(map(f.curry(), f1), ${tail})`;
  const sigT = `fun <${typeParams(n)}> map${n}(${kindArgs}, f: ${funcType(n)}): Kind<F, R>
    = ${bodyT}`;
  return [sigC, sigT];
}

// liftN: thin wrapper over apN
function liftFn(n) {
  const retT = `(${ids(n).map((i) => `Kind<F, T${i}>`).join(', ')}) -> Kind<F, R>`;
  const lam = ids(n).map((i) => `f${i}`).join(', ');
  return `fun <${typeParams(n)}> lift${n}(ff: Kind<F, ${funcType(n)}>): ${retT}
    = { ${lam} -> ap${n}(ff, ${lam}) }`;
}

const indent = (str, pad) => str.split('\n').map((l) => pad + l).join('\n');

let curryBlock = [];
let uncurryBlock = [];
for (let k = 2; k <= 22; k++) {
  for (let n = 1; n <= k - 1; n++) {
    curryBlock.push(curryFn(k, n));
    uncurryBlock.push(uncurryFn(k, n));
  }
}
const functionExt = `package kato

// region curryN

${curryBlock.join('\n\n')}

// endregion

// region uncurryN

${uncurryBlock.join('\n\n')}

// endregion
`;

const pad4 = (s) => indent(s, '    ');
let mapBlock = [];
for (let n = 2; n <= 22; n++) mapBlock.push(...mapFn(n));
let apBlock = [];
for (let n = 2; n <= 22; n++) apBlock.push(apFn(n));
let liftBlock = [];
for (let n = 2; n <= 22; n++) liftBlock.push(liftFn(n));

const applicative = `package kato

interface Applicative<F : TypeAccessor<Unary>> : Functor<F>
{
    fun <T1> of(t1: T1?): Kind<F, T1>

    fun <T1, T2> lift(ff: Kind<F, (T1) -> T2>): (Kind<F, T1>) -> Kind<F, T2>

    fun <T1, T2> ap(ff: Kind<F, (T1) -> T2>, f1: Kind<F, T1>): Kind<F, T2> = lift(ff)(f1)

    fun <T1, T2> ap(f: (T1) -> T2, f1: Kind<F, T1>) = map(f, f1)

    // region mapN

    // map1 from Functor interface.

${pad4(mapBlock.join('\n\n'))}

    // endregion

    // region apN

${pad4(apBlock.join('\n\n'))}

    // endregion

    // region liftN

${pad4(liftBlock.join('\n\n'))}

    // endregion
}
`;

fs.writeFileSync(path.join(__dirname, 'src/main/kotlin/kato/FunctionExt.kt'), functionExt);
fs.writeFileSync(path.join(__dirname, 'src/main/kotlin/kato/Applicative.kt'), applicative);

console.log(`FunctionExt.kt: ${curryBlock.length + uncurryBlock.length} functions`);
console.log(`Applicative.kt: ${mapBlock.length} mapN + ${apBlock.length} apN + ${liftBlock.length} liftN`);