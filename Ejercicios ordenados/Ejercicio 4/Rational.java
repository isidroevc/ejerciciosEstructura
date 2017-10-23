
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
        simplificarR(numerator, denominator);
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

    /*public void simplificarI(){
        int n,d,signo,r;
        // valores absolutos
        n=Math.abs(numerator);
        d=Math.abs(denominator);
        // casos de numerador y denominador
        if(numerator!=0 && denominator==0) // si es infinito
            numerator=1;
        else if(numerator==0 && denominator!=0) // si es 0
            denominator=1;
        else if(numerator!=0 && denominator!=0){ // fracción
            signo=denominator/d; // signo de la fracción
            while(n%d != 0){
                r=n%d;
                n=d;
                d=r; // d se vuelve mcd
            }
            numerator=signo*(numerator/d);
            denominator=signo*(denominator/d);
        }
    }*/
    public void simplificarR(int n,int d){
        int absN,absD,signo,mcd;
        
        absN=Math.abs(n);
        absD=Math.abs(d);
        
        if(n!=0 && d==0)
            numerator=1;
        else if(n==0 && d!=0)
            denominator=1;
        else if(n!=0 && d!=0){
            signo=d/absD;
            mcd=mcd(absN,absD);
            numerator=signo*(n/mcd);
            denominator=signo*(d/mcd);
        }
    }
    
    public int mcd(int n,int d){
        if(d==0)
            return n;
        else
            return mcd(d,n%d);
    }
}