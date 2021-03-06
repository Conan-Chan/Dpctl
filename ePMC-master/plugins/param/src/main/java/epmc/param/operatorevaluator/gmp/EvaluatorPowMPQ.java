/****************************************************************************

    ePMC - an extensible probabilistic model checker
    Copyright (C) 2017

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.

 *****************************************************************************/

package epmc.param.operatorevaluator.gmp;

import epmc.operator.Operator;
import epmc.operator.OperatorPow;
import epmc.param.value.gmp.GMP;
import epmc.param.value.gmp.TypeMPQ;
import epmc.param.value.gmp.ValueMPQ;
import epmc.param.value.rational.TypeRational;
import epmc.value.OperatorEvaluator;
import epmc.value.Type;
import epmc.value.TypeInteger;
import epmc.value.Value;
import epmc.value.ValueInteger;
import epmc.value.operatorevaluator.OperatorEvaluatorSimpleBuilder;

public final class EvaluatorPowMPQ implements OperatorEvaluator {
    public final static class Builder implements OperatorEvaluatorSimpleBuilder {
        private boolean built;
        private Operator operator;
        private Type[] types;

        @Override
        public void setOperator(Operator operator) {
            assert !built;
            this.operator = operator;
        }

        @Override
        public void setTypes(Type[] types) {
            assert !built;
            this.types = types;
        }

        @Override
        public OperatorEvaluator build() {
            assert !built;
            assert operator != null;
            assert types != null;
            for (Type type : types) {
                assert type != null;
            }
            built = true;
            if (operator != OperatorPow.POW) {
                return null;
            }
            if (types.length != 2) {
                return null;
            }
            if (!TypeMPQ.is(types[0])) {
                return null;
            }
            if (!TypeInteger.is(types[1])) {
                return null;
            }
            return new EvaluatorPowMPQ(this);
        }
    }

    private EvaluatorPowMPQ(Builder builder) {
    }

    @Override
    public Type resultType() {
        return TypeRational.get();
    }

    @Override
    public void apply(Value result, Value... operands) {
        assert result != null;
        assert operands != null;
        for (Value operand : operands) {
            assert operand != null;
        }
        ValueMPQ operand1 = ValueMPQ.as(operands[0]);
        ValueInteger operand2 = ValueInteger.as(operands[1]);
        ValueMPQ resultRat = ValueMPQ.as(result);
        GMP.gmp_util_mpq_pow(resultRat.getContent(),
                operand1.getContent(), operand2.getInt());
    }
}
