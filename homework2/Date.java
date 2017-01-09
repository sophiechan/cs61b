/* Date.java */
package homework2;

class Date {
  private int month;
  private int year;
  private int day;

  /* Put your private data fields here. */

  /** Constructs a date with the given month, day and year.   If the date is
   *  not valid, the entire program will halt with an error message.
   *  @param month is a month, numbered in the range 1...12.
   *  @param day is between 1 and the number of days in the given month.
   *  @param year is the year in question, with no digits omitted.
   */
  public Date(int month, int day, int year) {
    if (isValidDate(month,day,year)){
      this.month = month;
      this.day = day;
      this.year = year;
    } else {
      System.exit(0);
    }

  }

  /** Constructs a Date object corresponding to the given string.
   *  @param s should be a string of the form "month/day/year" where month must
   *  be one or two digits, day must be one or two digits, and year must be
   *  between 1 and 4 digits.  If s does not match these requirements or is not
   *  a valid date, the program halts with an error message.
   */
  public Date(String s) {
    String[] mdy = s.split("/");
    month = Integer.parseInt(mdy[0]);//why we an change the this here but can not in the Date constructor?
    day = Integer.parseInt(mdy[1]);
    year = Integer.parseInt(mdy[2]);
    if (!isValidDate(month,day,year)){
      System.exit(0);
    }

  }

  /** Checks whether the given year is a leap year.
   *  @return true if and only if the input year is a leap year.
   */
  public static boolean isLeapYear(int year) {
    if (year % 400 == 0){
      return true;
    } else if (year % 100 == 0){
      return false;
    } else if (year % 4 == 0){
      return true;
    } else {
      return false;
    }
  }

  /** Returns the number of days in a given month.
   *  @param month is a month, numbered in the range 1...12.
   *  @param year is the year in question, with no digits omitted.
   *  @return the number of days in the given month.
   */
  public static int daysInMonth(int month, int year) {
    if ((month == 1) || (month == 3) ||(month == 5) ||(month == 7) ||(month == 8) ||(month == 10)
            ||(month == 12)){
      return 31;
    } else if ((month == 4) ||(month == 6) ||(month == 9) ||(month == 11)){
      return 30;
    } else if (isLeapYear(year)){
      return 29;
    } else {
      return 28;
    }
  }

  /** Checks whether the given date is valid.
   *  @return true if and only if month/day/year constitute a valid date.
   *
   *  Years prior to A.D. 1 are NOT valid.
   */
  public static boolean isValidDate(int month, int day, int year) {
    if (year < 1){
      return false;
    } else if ((month < 1) || (month > 12)){
      return false;
    } else if ((day < 1) || (day > daysInMonth(month,year))){
      return false;
    } else {
      return true;
    }
  }

  /** Returns a string representation of this date in the form month/day/year.
   *  The month, day, and year are printed in full as integers; for example,
   *  12/7/2006 or 3/21/407.
   *  @return a String representation of this date.
   */
  public String toString() {
    String month;
    String day;
    String year;
    String date;
    month = Integer.toString(this.month);
    day = Integer.toString(this.day);
    year = Integer.toString(this.year);
    date = month + "/" + day + "/" + year;
    return date;
  }

  /** Determines whether this Date is before the Date d.
   *  @return true if and only if this Date is before d. 
   */
  public boolean isBefore(Date d) {
    if (this.year < d.year){
      return true;
    } else if ((this.year == d.year) && (this.month < d.month)){
      return true;
    } else {
      return ((this.year == d.year) && (this.month == d.month) && (this.day < d.day));
    }

  }

  /** Determines whether this Date is after the Date d.
   *  @return true if and only if this Date is after d. 
   */
  public boolean isAfter(Date d) {
    if (this.year > d.year){
      return true;
    } else if ((this.year == d.year) && (this.month > d.month)){
      return true;
    } else {
      return ((this.year == d.year) && (this.month == d.month) && (this.day > d.day));
    }
  }

  /** Returns the number of this Date in the year.
   *  @return a number n in the range 1...366, inclusive, such that this Date
   *  is the nth day of its year.  (366 is only used for December 31 in a leap
   *  year.)
   */
  public int dayInYear() {
    int days = this.day;
    int m = this.month;
    for (; m >= 2; m--){
      days += daysInMonth(m-1,this.year);
    }
    return days;
  }

  /** Determines the difference in days between d and this Date.  For example,
   *  if this Date is 12/15/1997 and d is 12/14/1997, the difference is 1.
   *  If this Date occurs before d, the result is negative.
   *  @return the difference in days between d and this date.
   */
  public int difference(Date d) {
    int days = 0;
    int y = 0;
    if (this.year == d.year) {
      days = this.dayInYear() - d.dayInYear();
    } else if (this.year > d.year) {
      for (y = d.year; y < this.year; y++) {
        int leapInt = (isLeapYear(y)) ? 1 : 0;
        int planeInt = (isLeapYear(y)) ? 0 : 1;
        days += 366 * leapInt + 365 * planeInt;
      }
      days += this.dayInYear() - d.dayInYear();

    } else {
      for (y = this.year; y < d.year; y++) {
        int leapInt = (isLeapYear(y)) ? 1 : 0;
        int planeInt = (isLeapYear(y)) ? 0 : 1;
        days += 366 * leapInt + 365 * planeInt;
      }
      days += d.dayInYear() - this.dayInYear();
      days = -days;
    }
    return days;
  }

  public static void main(String[] argv) {
    System.out.println("\nTesting constructors.");
    Date d1 = new Date(1, 1, 1);
    System.out.println("Date should be 1/1/1: " + d1);
    d1 = new Date("2/4/2");
    System.out.println("Date should be 2/4/2: " + d1);
    d1 = new Date("2/29/2000");
    System.out.println("Date should be 2/29/2000: " + d1);
    d1 = new Date("2/29/1904");
    System.out.println("Date should be 2/29/1904: " + d1);

    d1 = new Date(12, 31, 1975);
    System.out.println("Date should be 12/31/1975: " + d1);
    Date d2 = new Date("1/1/1976");
    System.out.println("Date should be 1/1/1976: " + d2);
    Date d3 = new Date("1/2/1976");
    System.out.println("Date should be 1/2/1976: " + d3);

    Date d4 = new Date("2/27/1977");
    Date d5 = new Date("8/31/2110");

    /* I recommend you write code to test the isLeapYear function! */

    System.out.println("\nTesting before and after.");
    System.out.println(d2 + " after " + d1 + " should be true: " + 
                       d2.isAfter(d1));
    System.out.println(d3 + " after " + d2 + " should be true: " + 
                       d3.isAfter(d2));
    System.out.println(d1 + " after " + d1 + " should be false: " + 
                       d1.isAfter(d1));
    System.out.println(d1 + " after " + d2 + " should be false: " + 
                       d1.isAfter(d2));
    System.out.println(d2 + " after " + d3 + " should be false: " + 
                       d2.isAfter(d3));

    System.out.println(d1 + " before " + d2 + " should be true: " + 
                       d1.isBefore(d2));
    System.out.println(d2 + " before " + d3 + " should be true: " + 
                       d2.isBefore(d3));
    System.out.println(d1 + " before " + d1 + " should be false: " + 
                       d1.isBefore(d1));
    System.out.println(d2 + " before " + d1 + " should be false: " + 
                       d2.isBefore(d1));
    System.out.println(d3 + " before " + d2 + " should be false: " + 
                       d3.isBefore(d2));

    System.out.println("\nTesting difference.");
    System.out.println(d1 + " - " + d1  + " should be 0: " + 
                       d1.difference(d1));
    System.out.println(d2 + " - " + d1  + " should be 1: " + 
                       d2.difference(d1));
    System.out.println(d3 + " - " + d1  + " should be 2: " + 
                       d3.difference(d1));
    System.out.println(d3 + " - " + d4  + " should be -422: " + 
                       d3.difference(d4));
    System.out.println(d5 + " - " + d4  + " should be 48762: " + 
                       d5.difference(d4));
  }
}
