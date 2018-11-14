package com.ex5.variable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.ex5.model.Expression;
import com.ex5.model.binaire.ExpressionBinaire;
import com.ex5.model.binaire.MultExpression;
import com.ex5.model.binaire.PlusExpression;
import com.ex5.model.unaire.ExpressionUnaire;
import com.ex5.model.unaire.IntExpression;
import com.ex5.visitor.impl.VisitorImpl;

public class Machine extends VisitorImpl {
	
	Stack<Expression> pile;
	Map<VariableDefinition,ExpressionUnaire> association;
	List<VariableDefinition> definitions;

	public Machine() {
		this.pile = new Stack<Expression>();
		this.association = new HashMap<VariableDefinition,ExpressionUnaire>();
		this.definitions = new ArrayList<VariableDefinition>();
	}
	
	public void addMultToPile(MultExpression mExpr) {
		pile.push(mExpr.opLeft);
		pile.push(mExpr.opRight);
	}
	
	 public void initMachine(Programme programme) {
	   for(Element element : programme.getElements()) {
	     switch(element.getClass().getSimpleName()) {
	     case "VariableDefinition":
	       this.addToListDef((VariableDefinition) element);
	       this.association.put((VariableDefinition) element, new UnresolvedSymbol());
	       break;
	     case "Affectation":
	       ((Affectation) element).variableReference.setDefinition(this.getDefFromList(((Affectation) element).variableReference.variableDefinition.name));
	       ((Affectation) element).variableReference.getVariableDefinition().addListReference(((Affectation) element).variableReference);
	       break;
	     default:
	       break;
	     }
	   }
	 }
	
	public void addPlusToPile(PlusExpression pExpr) {
		pile.push(pExpr.opLeft);
		pile.push(pExpr.opRight);
	}
	
	public void addAssociation(VariableDefinition key,ExpressionUnaire value) {
		this.association.put(key, value);
		
	}
	
	public void addExprToPile(Expression expression) {
	  pile.push(expression);
	}
	
	public void addToListDef(VariableDefinition variableDefinition) {
	  this.definitions.add(variableDefinition);
	}
	
	public VariableDefinition getDefFromList(String name) {
	  for(VariableDefinition var : this.definitions) {
	    if(var.name.equals(name)) {
	      return var;
	    }
	  }
	  return null;
	}
	
	public void revertPile() {
	  Stack<Expression> tmp = new Stack<Expression>();
	  while(!this.pile.empty()) {
	    tmp.push(this.pile.pop());
   }
	  this.pile = tmp;
	}
	
	public void pushList(List<Element> elements) {
	  for(Element element : elements) {
	    switch(element.getClass().getSimpleName()) {
	    case "Affectation":
	      this.pile.push(((Affectation)element).variableReference);
	      if(((Affectation)element).expression.getClass().getSimpleName().equals("IntExpression")) {
	        this.pile.push(((Affectation)element).expression);
	      } else {
	        PlusExpression expr=(PlusExpression) ((Affectation)element).expression;
	        this.pile.push(expr);

	      }
	    }
	  }
	  this.revertPile();
	}
	
	public void computePile() {
	  while(!this.pile.empty()) {
      Expression expression = this.pile.pop();
      if(expression.getClass().getSimpleName().equals("VariableReference")) {
        VariableReference variableReference = ((VariableReference)expression);
        expression = this.pile.pop();
        if (expression.getClass().getSimpleName().equals("IntExpression")) {
          this.getDefFromList(variableReference.variableDefinition.name).addListReference(variableReference);
          this.association.put(this.getDefFromList(variableReference.variableDefinition.name), ((ExpressionUnaire)expression));
        } else {
          this.getDefFromList(variableReference.variableDefinition.name).addListReference(variableReference);
          if(expression.getClass().getSimpleName().equals("PlusExpression")) {
            PlusExpression plus = ((PlusExpression)expression);
            this.association.put(this.getDefFromList(variableReference.variableDefinition.name),this.computePlus(plus.opLeft, plus.opRight)); 
          }
        }
      }
        
	  }
	  System.out.println("Compute finish");
	  for(int i = 0; i < this.definitions.size(); i++) {
	    System.out.print(this.definitions.get(i).name+":=");
	    this.association.get(this.definitions.get(i)).accept(this);
	  }
  }
	
	public IntExpression computePlus(Expression opLeft, Expression opRight) {
    IntExpression result = new IntExpression();
    if(opLeft instanceof IntExpression && opRight instanceof IntExpression) {
      result.setInt(((IntExpression) opLeft).getInt()+((IntExpression) opRight).getInt());
    } else {
      IntExpression temp = new IntExpression();
      if (opLeft instanceof ExpressionBinaire) {
        ExpressionBinaire left = (ExpressionBinaire) opLeft;
        result = this.computePlus(left.opLeft, left.opRight);
      } else if(opLeft instanceof IntExpression) {
        result = (IntExpression) opLeft;
      } else {
        result.setInt(((IntExpression) this.association.get(this.getDefFromList(((VariableReference)opLeft).variableDefinition.name))).getInt());
      }
      if (opRight instanceof ExpressionBinaire) {
        ExpressionBinaire right = (ExpressionBinaire) opRight;
        temp = this.computePlus(right.opLeft, right.opRight);
      } else if(opRight instanceof IntExpression) {
        temp = (IntExpression) opRight;
      } else {
        result.setInt(((IntExpression) this.association.get(this.getDefFromList(((VariableReference)opRight).variableDefinition.name))).getInt());
      }
      result.setInt(result.getInt()+temp.getInt());
    }
    return result;
  }
	
}
