
package primeprinterrefactor;

public class PrimePrinter {
    private static final int numberOfPrimes = 1000;
    
    public static void main(String[] args) {
        PrimePrinterHelper primePrinterHelper = new PrimePrinterHelper();
        int primes[] = primePrinterHelper.generatePrimes();
        primePrinterHelper.printNumbers(primes, numberOfPrimes);
    }
}

class PrimePrinterHelper{

    private int numberOfPrimes = 1000;
    private int linesPerPage = 50;
    private int columns = 4;
    private int ordmax = 30;
    private int primes[] = new int[numberOfPrimes + 1];
    private int pagenumber;
    private int pageoffset;
    private int rowoffset;
    private int column;
    private int candidate;
    private int primeIndex;
    private boolean possiblyPrime;
    private int ord;
    private int square;
    private int n;
    private int multiples[] = new int[ordmax + 1];

    public int[] generatePrimes(){

        candidate = 1;
        primeIndex = 1;
        primes[1] = 2;
        ord = 2;
        square = 9;
        while (primeIndex < numberOfPrimes) {
            do {
                candidate += 2;
                if (candidate == square) {
                    ord++;
                    square = primes[ord] * primes[ord];
                    multiples[ord - 1] = candidate;
                }
                n = 2;
                possiblyPrime = true;
                while (n < ord && possiblyPrime) {
                    while (multiples[n] < candidate)
                        multiples[n] += primes[n] + primes[n];
                    if (multiples[n] == candidate)
                        possiblyPrime = false;
                    n++;
                }
            } while (!possiblyPrime);
            primeIndex++;
            primes[primeIndex] = candidate;
        }
        return primes;
    }

    public void printNumbers(int numbers[], int numberOfNumbers) {
        new NumberPrinter(linesPerPage, columns).print(numbers, numberOfNumbers);
    }  
}
