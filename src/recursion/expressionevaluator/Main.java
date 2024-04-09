package recursion.expressionevaluator;

interface ExpressionLike {
}

//Example  column > value  column is left, > is operator, value is right
class Expression implements ExpressionLike {
    String left, right;
    String operator;

    Expression(String left, String operator, String right) {
        this.left = left;
        this.right = right;
        this.operator = operator;
    }
}

//Example :- (column1 > vaue1) and (column2 < value2) and (column3 != value3)  here args = (column1 > vaue1),(column2 < vaue2),(column3 != vaue3)  operator = and
class ExpressionClause implements ExpressionLike {
    ExpressionLike[] args;
    String operator;

    ExpressionClause(ExpressionLike[] args, String operator) {
        this.args = args;
        this.operator = operator;
    }
}
