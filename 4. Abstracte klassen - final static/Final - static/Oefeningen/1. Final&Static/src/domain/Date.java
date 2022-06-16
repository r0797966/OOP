package domain;

public final class Date {
    private final int day;
    private final int month;
    private final int year;

    public static Date createDMY(int day, int month, int year){return new Date(day, month, year);}

    public static Date createMDY(int month, int day, int year){return new Date(month, day, year);}

    public Date( int day, int month, int year ) throws IllegalArgumentException {
        if ( !isValidDate( day, month, year ) ) {
            throw new IllegalArgumentException("Invalid day-month-year combination.");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    /*private void setDate( int day, int month, int year ) throws IllegalArgumentException {
        if ( !isValidDate( day, month, year ) ) {
        	throw new IllegalArgumentException("Invalid day-month-year combination.");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public void setYear( int year ) throws IllegalArgumentException {
    	setDate( this.day, this.month, year );
    }

    public void setMonth( int month ) throws IllegalArgumentException {
    	setDate( this.day, month, this.year );
    }

    public void setDay( int day ) throws IllegalArgumentException {
    	setDate( day, this.month, this.year );
    }*/
    
    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }
    
    public boolean isLeapYear( int year ) {
    	boolean isLeapYear = false;
    	if( year%4 == 0 ){
        	if(! (year%100 == 0 && year%400 != 0)){
        		isLeapYear = true;
        	}
    	}
        return isLeapYear;
    }
    
    public boolean isValidDate( int day, int month, int year ) {
        return month >= 1 && 
        		month <= 12 && 
        		day >= 1 && 
        		day <= numberOfDaysInMonth( month, year );
    }  

    public int numberOfDaysInMonth( int month, int year ) throws IllegalArgumentException {
    	if(month < 1 || month > 12){
    		throw new IllegalArgumentException("Invalid month.");
    	}
    	int nrOfDays = 31;
        switch ( month ) {
	        case 1:
	        case 3:
	        case 5:
	        case 7:
	        case 8:
	        case 10:
	        case 12:
	            break;	
	        case 2:
	        	nrOfDays = isLeapYear( year ) ? 29 : 28;
	        	break;	
	        case 4:
	        case 6:
	        case 9:
	        case 11:
	        	nrOfDays = 30;
	        	break;
        }
        return nrOfDays;
    }

    public boolean isBefore( Date otherDate ) {
        if ( otherDate == null ) {
            throw new IllegalArgumentException("Invalid date.");
        }
        boolean isBefore = false;
        if ( getYear() < otherDate.getYear() ) {
        	isBefore = true;
        } else if ( getYear() == otherDate.getYear() ) {
            if ( getMonth() < otherDate.getMonth() ) {
            	isBefore = true;
            } else if ( getMonth() == otherDate.getMonth() ) {
            	isBefore = getDay() < otherDate.getDay();
            }
        }
        return isBefore;        
    }

    public boolean isAfter( Date otherDate ) {
        if ( otherDate == null ) {
            throw new IllegalArgumentException("Invalid date.");
        }
        return otherDate.isBefore( this );        
    }

    public Date advanceSingleDay() {
        Date date;
        if ( getDay() == numberOfDaysInMonth( getMonth(), getYear() ) ) {
            if ( getMonth() == 12 ) {
                date = new Date(1, 1, getYear() + 1);
                //setDate( 1, 1, getYear() + 1 );
            } else {
                date = new Date(1, getMonth() + 1, getYear());
            	//setDate( 1, getMonth() + 1, getYear() );
            }
        } else {
            date = new Date(getDay() + 1, getMonth(), getYear());
        	//setDate( getDay() + 1, getMonth() , getYear() );
        }
        return date;
    }
    
    public Date goBackSingleDay()  {
        Date date;
        if ( getDay() == 1 ) {
            if ( getMonth() == 1 ) {
                date = new Date(31, 12, getYear() - 1);
            	//setDate( 31, 12, getYear() - 1 );
            } else {
            	int nrOfDays =  numberOfDaysInMonth( getMonth() - 1, getYear() );
                date = new Date(nrOfDays, getMonth() - 1, getYear());
            	//setDate( nrOfDays , getMonth() - 1, getYear() );
            }
        } else {
            date = new Date(getDay() - 1, getMonth(), getYear());
        	//setDate( getDay() - 1 , getMonth(), getYear() );
        }
        return date;
    }
    
    @Override 
    public boolean equals( Object object ) {
    	boolean same = false;
        if ( object instanceof Date ) {
            Date otherDate = (Date) object;
            if(getDay() == otherDate.getDay() &&
            		getMonth() == otherDate.getMonth() &&
            		getYear() == otherDate.getYear()){
            	same = true;
            }
        }
        return same;
    }
    
    @Override 
    public String toString(){
    	String output = getDay()+"/"+getMonth()+"/"+getYear();
    	return output;
    }
}
