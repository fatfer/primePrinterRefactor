
package primeprinterrefactor;

public class NumberPrinter {
    private int linesPerPage;
    private int columns;
    private int[] numbers;
    private int numberOfNumbers;

    public NumberPrinter(int linesPerPage, int columns, int[] numbers, int numberOfNumbers){
        this.linesPerPage = linesPerPage;
        this.columns = columns;
        this.numbers = numbers;
        this.numberOfNumbers = numberOfNumbers;
    }

    public void invoke(){
        int pagenumber = 1;
        int pageoffset = 1;
        while (pageoffset <= numberOfNumbers) {
            System.out.println("The First " + numberOfNumbers +
                    " Prime Numbers --- Page " + pagenumber);
            System.out.println("");
            for (int rowoffset = pageoffset; rowoffset <= pageoffset + linesPerPage-1; rowoffset++){
                for (int column = 0; column <= columns-1;column++)
                    if (rowoffset + column * linesPerPage <= numberOfNumbers)
                        System.out.format("%10d", numbers[rowoffset + column * linesPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            pagenumber++;
            pageoffset += linesPerPage * columns;
        }
    }
}
