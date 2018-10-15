package com.ex5.model.binaire;

import com.ex5.model.Expression;
import com.ex5.model.unaire.IntExpression;

public class PlusExpression extends ExpressionBinaire {
	    
		public PlusExpression() {
			super();
		}

		@Override
		public IntExpression compute(Expression opLeft, Expression opRight) {
			IntExpression result = new IntExpression();
			result.setInt(opLeft.getValue().getInt()+opRight.getValue().getInt());
			return result;
		}
		
		@Override
		public IntExpression getValue() {
			return this.compute(opLeft, opRight);
		}
}
