const fs = require('fs');
const path = require('path');

const ids = (k) => Array.from({ length: k }, (_, i) => i + 1); // 1..k

const typeParams = (k) => {
  const a = [];
  for (let i = 1; i <= k; i++) a.push(`T${i}`);
  a.push('R');
  return a.join(', ');
};

const funcType = (k) => `(${Array.from({ length: k }, (_, i) => `T${i + 1}`).join(', ')}) -> Kind<F, R>`;

// flatMapN: f: (T1..Tn) -> Kind<F, R>
function flatMapFn(n) {
  const kindArgs = ids(n).map((i) => `t${i}: Kind<F, T${i}>`).join(', ');
  const fArg = `f: ${funcType(n)}`;
  const lamVars = ids(n).map((i) => `a${i}`).join(', ');

  let body = `f(${lamVars})`;
  for (let i = n; i >= 1; i--) {
    body = `flatMap({ a${i} -> ${body} }, t${i})`;
  }

  return `fun <${typeParams(n)}> flatMap${n}(${kindArgs}, ${fArg}): Kind<F, R>
    = ${body}`;
}

const indent = (str, pad) => str.split('\n').map((l) => pad + l).join('\n');
const pad4 = (s) => indent(s, '    ');

let flatMapBlock = [];
for (let n = 2; n <= 22; n++) flatMapBlock.push(flatMapFn(n));

const monad = `package kato

interface Monad<F : TypeAccessor<Unary>> : Applicative<F>
{
    fun <T1, T2> flatMap(f: (T1) -> Kind<F, T2>, t1: Kind<F, T1>): Kind<F, T2>

    // region flatMapN

    // flatMap1 from Monad interface.

${pad4(flatMapBlock.join('\n\n'))}

    // endregion
}
`;

fs.writeFileSync(path.join(__dirname, '..', 'src/main/kotlin/kato/Monad.kt'), monad);

console.log(`Monad.kt: ${flatMapBlock.length} flatMapN (flatMap2..flatMap22)`);
