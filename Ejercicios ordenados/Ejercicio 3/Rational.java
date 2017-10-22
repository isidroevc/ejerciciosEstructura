
public class Rational implements Rationalizable {
    // -Propiedades.
    private int numerator;
    private int denominator;

    // -Constructores.

    public Rational(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if(this.denominator < 0 ) {
            this.numerator *= -1;
            this.denominator *= -1;
        }
    }

    public Rational() {}


    // -Setters y getters.
    public  void setNumerator(int numerator){
        this.numerator = numerator;
    }
    public void setDenominator(int denominator){ 
        this.denominator = denominator; 
    }
    public int getNumerator(){  return this.numerator; }
    public int getDenominator() {return this.denominator;};

   // -Implementaciones de métodos de la interface Rationalizable.

    public Rational addition(Rational r) {
        int resultN; // numerator del resultado 
        int resultD;// denimnador del resultado
        int rN = r.getNumerator(); // -Numearador de r 
        int rD = r.getDenominator(); // - Denominador de r
        resultN = this.numerator * rD + this.denominator * rN;
        resultD = this.denominator * rD;
        
        return new Rational(resultN, resultD);
    }

    public Rational substraction(Rational r) {
        int resultN; // numerator del resultado 
        int resultD;// denimnador del resultado
        int rN = r.getNumerator(); // -Numearador de r 
        int rD = r.getDenominator(); // - Denominador de r
        resultN = this.numerator * rD - this.denominator * rN;
        resultD = this.denominator * rD;
        
        return new Rational(resultN, resultD);
    }

    public Rational multiplication(Rational r) {
        int resultN; // numerator del resultado 
        int resultD;// denimnador del resultado
        int rN = r.getNumerator(); // -Numearador de r 
        int rD = r.getDenominator(); // - Denominador de r
        resultN = this.numerator * rN;
        resultD = this.denominator * rD;
        
        return new Rational(resultN, resultD);
    }

    public Rational division(Rational r) {
        int resultN; // numerator del resultado 
        int resultD;// denimnador del resultado
        int rN = r.getNumerator(); // -Numearador de r 
        int rD = r.getDenominator(); // - Denominador de r
        resultN = this.numerator * rD;
        resultD = this.denominator * rN;
        
        return new Rational(resultN, resultD);
    }

    public Rational exponentiation(int e) {
        int resultD;
        int resultN;
        if(e >= 0){
            resultN = (int)Math.pow(this.numerator, e);
            resultD = (int)Math.pow(this.denominator, e);
        } else {
            resultD = (int)Math.pow(this.numerator, e);
            resultN = (int)Math.pow(this.denominator, e);
        }
        return new Rational(resultN, resultD);
    }
    public Rational negation(){
        return new Rational(-this.numerator, this.denominator);
    } 

    public boolean assignment() {
        return false;
    }

    public boolean lessEquals(Rational r) {
        double current = this.numerator /this.denominator;
        double rval = r.getNumerator() / r.getDenominator();
        return current <= rval;
    }
    @Override
    public boolean equals(Rational r) {
        double current = this.numerator /this.denominator;
        double rval = r.getNumerator() / r.getDenominator();
        return current == rval;
    }

    public boolean greaterEquals(Rational r){
        double current = this.numerator /this.denominator;
        double rval = r.getNumerator() / r.getDenominator();
        return current >= rval;
    }

    public boolean notEquals(Rational r) {
        return !this.equals(r);
    }
    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }
}