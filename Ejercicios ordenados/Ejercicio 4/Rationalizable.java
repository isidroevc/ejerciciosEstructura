
public interface Rationalizable {
    public Rational addition(Rational r);
    public Rational substraction(Rational r);
    public Rational multiplication(Rational r);
    public Rational division(Rational r);
    public Rational exponentiation(int e);
    public Rational negation();
    public boolean assignment();
    public boolean lessEquals(Rational r);
    public boolean greaterEquals(Rational r);
    public boolean equals(Rational r);
}  