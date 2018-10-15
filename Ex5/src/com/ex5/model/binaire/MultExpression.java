package com.ex5.model.binaire;

import com.ex5.model.Expression;
import com.ex5.model.unaire.ExpressionUnaire;
import com.ex5.model.unaire.IntExpression;

public class MultExpression extends ExpressionBinaire {
    
	public MultExpression() {
		super();
	}

	@Override
	public IntExpression compute(Expression opLeft, Expression opRight) {
		IntExpression result = new IntExpression();
		if(opLeft instanceof IntExpression && opRight instanceof IntExpression) {
			result.setInt(opLeft.getValue().getInt()*opRight.getValue().getInt());
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
			result.setInt(result.getInt()*temp.getInt());
		}
		return result;
	}

	@Override
	public IntExpression getValue() {
		return this.compute(opLeft, opRight);
	}
}
