package com.ex5.model.binaire;

import com.ex5.model.Expression;
import com.ex5.model.unaire.IntExpression;
import com.ex5.visitor.Visitor;

public class PlusExpression extends ExpressionBinaire {
	    
		public PlusExpression() {
			super();
		}

		@Override
		public IntExpression compute(Expression opLeft, Expression opRight) {
			IntExpression result = new IntExpression();
			if(opLeft instanceof IntExpression && opRight instanceof IntExpression) {
				result.setInt(opLeft.getValue().getInt()/opRight.getValue().getInt());
			} else {
				IntExpression temp = new IntExpression();
				if (opLeft instanceof ExpressionBinaire) {
					ExpressionBinaire left = (ExpressionBinaire) opLeft;
					result = this.compute(left.opLeft, left.opRight);
				} else {
					result = (IntExpression) opLeft;
				}
				if (opRight instanceof ExpressionBinaire) {
					ExpressionBinaire right = (ExpressionBinaire) opRight;
					temp = this.compute(right.opLeft, right.opRight);
				} else {
					temp = (IntExpression) opRight;
				}
				result.setInt(result.getInt()/temp.getInt());
			}
			return result;
		}
		
		@Override
		public IntExpression getValue() {
			return this.compute(opLeft, opRight);
		}

		@Override
		public void accept(Visitor v) {
			v.visitPlus(this);
		}

		@Override
		public String toString() {
			return "PlusExpression [opLeft=" + opLeft + ", opRight=" + opRight + "]";
		}
}
