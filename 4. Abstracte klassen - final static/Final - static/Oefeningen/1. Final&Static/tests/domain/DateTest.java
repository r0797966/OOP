package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Date;

public class DateTest
{
    private Date date;
    private Date dayInFebruariNonLeap;
    private Date februari29Leap;
    private Date lastdayInMarch;
    private Date lastdayInApril;

    @Before 
    public void setUp() {
        this.date = Date.createDMY( 1, 1, 2000 );
        dayInFebruariNonLeap = Date.createDMY(1, 2, 2001);
        februari29Leap = Date.createDMY(29, 2, 2000);
        lastdayInMarch = Date.createDMY(31, 3, 2000);
        lastdayInApril = Date.createDMY(30, 4, 2000);
    }
    
    //TEST CONSTRUCTOR
    @Test 
    public void test_Date_creates_date_for_valid_day_month_year_combinations() {
        date = new Date( 1, 1, 2000 );

        assertEquals( 1, date.getDay() );
        assertEquals( 1, date.getMonth() );
        assertEquals( 2000, date.getYear() );
        
        date = new Date( 29, 2, 2000 );

        assertEquals( 29, date.getDay() );
        assertEquals( 2, date.getMonth() );
        assertEquals( 2000, date.getYear() );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_Date_invalid_day_below_1_throws_exception() {
        new Date( 0, 12, 2001 );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_Date_invalid_day_above_31_throws_exception() {
        new Date( 32, 12, 2001 );
    }

    @Test(expected = IllegalArgumentException.class) 
    public void test_Date_invalid_day_februari_29_in_non_leap_year_throws_exception() {
        new Date( 29, 2, 2001 );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_Date_invalid_day_31_days_in_non_31_day_month_throws_exception() {
        new Date( 31, 4, 2001 );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_Date_invalid_month_below_1_throws_exception() {
        new Date( 1, 0, 2001 );
    }

    @Test(expected = IllegalArgumentException.class) 
    public void test_Date_invalid_month_above_12_throws_exception() {
        new Date( 1, 13, 2001 );
    }
    
    //TEST SETDAY
    /*@Test public void test_setDay_for_valid_day_sets_day() {
        date.setDay( 2 );
        assertEquals( 2, date.getDay() );
    }

    @Test(expected = IllegalArgumentException.class) 
    public void test_setDay_for_day_below_1_throws_exception() {
        date.setDay( 0 );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_setDay_for_day_above_31_throws_exception() {
        date.setDay( 32 );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_setDay_for_day_februari_29_in_non_leap_year_throws_exception() {
        dayInFebruariNonLeap.setDay( 29 );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_setDay_for_day_31_days_in_non_31_day_month_throws_exception() {
        lastdayInApril.setDay( 31 );
    }  
    
    //TEST SETMONTH
    @Test 
    public void test_setMonth_for_valid_month_sets_month() {
        date.setMonth( 2 );
        assertEquals( 2, date.getMonth() );
    }

    @Test(expected = IllegalArgumentException.class) 
    public void test_setMonth_for_month_below_1_throws_exception() {
        date.setMonth( 0 );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_setMonth_for_month_above_12_throws_exception() {
        date.setMonth( 13 );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_setMonth_small_month_in_date_with_31_days_throws_exception() {
    	lastdayInMarch.setMonth( 4 );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_setMonth_februari_in_date_with_more_than_29_days_throws_exception() {
        lastdayInMarch.setMonth( 2 );
    }
    
    //TEST SETYEAR
    @Test 
    public void test_setYear_for_valid_year_sets_year() {
        date.setYear( 2001 );
        assertEquals( 2001, date.getYear() );
    }

    @Test(expected = IllegalArgumentException.class) 
    public void test_setYear_for_non_leap_on_februari_29_throws_exception() {
        februari29Leap.setYear( 2003 );
    }
    */
    //TEST ISLEAPYEAR
    @Test 
    public void isLeapYear_returns_true_for_leap_years() {
    	int[] leapYears = new int[] { 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008 };
        for ( int leapYear :  leapYears)   {
            assertTrue( this.date.isLeapYear( leapYear ) );
        }
    }

    @Test 
    public void isLeapYear_returns_false_for_nonleap_years() {
    	int[] nonLeapYears =  new int[] { 1000, 1981, 1991, 1993, 1995, 2001, 2002, 2003, 2009, 2011, 2013 };
        for ( int leapYear : nonLeapYears ) {
            assertFalse( this.date.isLeapYear( leapYear ) );
        }
    }

    //TEST NUMBEROFDAYSINMONTH
    @Test 
    public void test_numberOfDaysInMonth_for_1_3_5_7_8_10_12_returns_31() {
    	int expected = 31;
    	assertEquals( expected, date.numberOfDaysInMonth( 1, 2000 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 3, 2000 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 5, 2000 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 7, 2000 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 8, 2000 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 10, 2000 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 12, 2000 ) );
    }
    
    @Test 
    public void test_numberOfDaysInMonth_for_4_6_9_11_returns_30() {
    	int expected = 30;
    	assertEquals( expected, date.numberOfDaysInMonth( 4, 2000 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 6, 2000 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 9, 2000 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 11, 2000 ) );
    }
    
    @Test 
    public void test_numberOfDaysInMonth_for_2_in_leapyear_returns_29() {
    	int expected = 29;
    	assertEquals( expected, date.numberOfDaysInMonth( 2, 2000 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 2, 2004 ) );
    }
    
    @Test 
    public void test_numberOfDaysInMonth_for_2_in_non_leapyear_returns_28() {
    	int expected = 28;
    	assertEquals( expected, date.numberOfDaysInMonth( 2, 2001 ) );
    	assertEquals( expected, date.numberOfDaysInMonth( 2, 1000 ) );
    } 	

    @Test(expected = IllegalArgumentException.class) 
    public void test_numberOfDaysInMonth_for_month_below_1_throws_exception() {
        date.numberOfDaysInMonth( 0, 2000 );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_numberOfDaysInMonth_for_month_above_12_throws_exception() {
        date.numberOfDaysInMonth( 13, 2000 );
    }

    @Test 
    public void test_isValidDate() {
        assertTrue( this.date.isValidDate( 1, 1, 2000 ) );
        assertTrue( this.date.isValidDate( 29, 2, 2000 ) );
        assertTrue( this.date.isValidDate( 31, 1, 2000 ) );
        assertTrue( this.date.isValidDate( 31, 3, 2000 ) );
        assertTrue( this.date.isValidDate( 31, 12, 2000 ) );

        assertFalse( this.date.isValidDate( 0, 1, 2001 ) ); // Wrong day
        assertFalse( this.date.isValidDate( 32, 1, 2001 ) ); // Wrong day
        assertFalse( this.date.isValidDate( 1, 0, 2001 ) ); // Wrong month
        assertFalse( this.date.isValidDate( 1, 13, 2001 ) ); // Wrong month
        assertFalse( this.date.isValidDate( 29, 2, 2001 ) ); // Not a leap year
    }

    @Test 
    public void test_comparisons() {
        checkComparison( 1, 1, 2000, 1, 1, 2001 );
        checkComparison( 1, 1, 2000, 1, 2, 2000 );
        checkComparison( 1, 1, 2000, 11, 1, 2000 );
        checkComparison( 31, 12, 2000, 1, 1, 2001 );
        checkComparison( 31, 1, 2000, 1, 2, 2000 );
        checkComparison( 1, 12, 2000, 1, 1, 2001 );
    }

    private void checkComparison( int day1, int month1, int year1, int day2, int month2, int year2 ) {
        Date date1 = new Date( day1, month1, year1 );
        Date date2 = new Date( day2, month2, year2 );

        assertTrue( date1.isBefore( date2 ) );
        assertFalse( date2.isBefore( date1 ) );
        assertFalse( date1.isAfter( date2 ) );
        assertTrue( date2.isAfter( date1 ) );
    }

    @Test(expected = IllegalArgumentException.class) 
    public void test_isBefore_for_null_throws_exception() {
        date.isBefore( null );
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void test_isAfter_for_null_throws_exception() {
        date.isBefore( null );
    }

    //TEST EQUALS
    @Test 
    public void test_equals_for_date_with_same_day_month_and_year_returns_true() {
        assertTrue( date.equals(new Date(1,1,2000)) );
    }
    
    @Test 
    public void test_equals_for_date_with_other_day_returns_false() {
        assertFalse( date.equals(new Date(2,1,2000)) );
    }
    
    @Test 
    public void test_equals_for_date_with_other_month_returns_false() {
    	assertFalse( date.equals(new Date(1,2,2000)) );
    }
    
    @Test 
    public void test_equals_for_date_with_other_year_returns_false() {
    	assertFalse( date.equals(new Date(1,1,2001)) );
    }
    
    @Test 
    public void test_equals_for_null_returns_false() {
    	assertFalse( date.equals(null) );
    }
    
    @Test 
    public void test_equals_for_non_date_returns_false() {
    	assertFalse( date.equals("") );
    }
    
    //TEST TOSTRING
    @Test 
    public void test_toString_returns_formatted_date() {
    	assertEquals("1/1/2000", date.toString() );
    }

    //TEST ADVANCESINGLEDAY
    @Test 
    public void test_advanceSingleDay_not_last_day_in_month_advances_day() {
        checkAdvanceSingleDay( 1, 1, 2000, 2, 1, 2000 );
        checkAdvanceSingleDay( 2, 1, 2000, 3, 1, 2000 );
    }

    @Test 
    public void test_advanceSingleDay_on_end_of_month_advances_month_sets_day_to_one() {
        checkAdvanceSingleDay( 31, 1, 2000, 1, 2, 2000 );
    }

    @Test 
    public void test_advanceSingleDay_on_end_of_leap_february() {
        checkAdvanceSingleDay( 28, 2, 2000, 29, 2, 2000 );
    }

    @Test 
    public void test_advanceSingleDay_on_end_of_nonleap_february() {
        checkAdvanceSingleDay( 28, 2, 2001, 1, 3, 2001 );
    }

    @Test 
    public void test_advanceSingleDay_on_30th_of_31_day_month() {
        checkAdvanceSingleDay( 30, 3, 2001, 31, 3, 2001 );
    }

    @Test 
    public void test_advanceSingleDay_on_30th_of_30_day_month() {
        checkAdvanceSingleDay( 30, 4, 2001, 1, 5, 2001 );
    }

    @Test public void test_advanceSingleDay_on_end_of_year() {
        checkAdvanceSingleDay( 31, 12, 2001, 1, 1, 2002 );
    }

    private void checkAdvanceSingleDay( int startDay, int startMonth, int startYear, int targetDay, int targetMonth, int targetYear ) {
        Date startDate = new Date( startDay, startMonth, startYear );
        Date targetDate = new Date( targetDay, targetMonth, targetYear );
        startDate.advanceSingleDay();
        assertEquals( targetDate, startDate );
    }

    //TEST GOBACKDAY
    @Test 
    public void test_goBackSingleDay_not_first_day_reverses_day() {
        checkGoBackSingleDay( 2, 1, 2000, 1, 1, 2000 );
    }

    @Test 
    public void test_goBackSingleDay_beginning_of_february() {
        checkGoBackSingleDay( 1, 2, 2000, 31, 1, 2000 );
    }

    @Test 
    public void test_goBackSingleDay_beginning_of_march_of_leap_year() {
        checkGoBackSingleDay( 1, 3, 2000, 29, 2, 2000 );
    }

    @Test 
    public void test_goBackSingleDay_beginning_of_march_of_nonleap_year() {
        checkGoBackSingleDay( 1, 3, 2001, 28, 2, 2001 );
    }

    @Test public void test_goBackSingleDay_beginning_of_april() {
        checkGoBackSingleDay( 1, 4, 2000, 31, 3, 2000 );
    }

    @Test public void test_goBackSingleDay_beginning_of_may() {
        checkGoBackSingleDay( 1, 5, 2000, 30, 4, 2000 );
    }

    @Test public void test_goBackSingleDay_beginning_of_year() {
        checkGoBackSingleDay( 1, 1, 2000, 31, 12, 1999 );
    }

    private void checkGoBackSingleDay( int startDay, int startMonth, int startYear, int targetDay, int targetMonth, int targetYear ) {
        Date startDate = new Date( startDay, startMonth, startYear );
        Date targetDate = new Date( targetDay, targetMonth, targetYear );
        startDate.goBackSingleDay();
        assertEquals( targetDate, startDate );
    }
}
