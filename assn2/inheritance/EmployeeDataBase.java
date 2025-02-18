package com.assn2.inheritance;



public class EmployeeDataBase implements Hr,Senior,SuperSenior,MidLevel{
	
	     static String[] watsoDepartment={"IT","SALES","COMMUNITY_SUPPORT"};
	     static String[] rapidSoftDepartment={"IT","MARKETING","PRODUCTION"};

	     static String[] rapidSoftEmployee={"Anil Kumar Pradhan","Manoranjan Sahu","Subham Mohanty","Abinash Sahoo"};
	     static String[] watsooEmployee={"Abhisekh Tripathy","Satya PAnada","Rohit Sahu"};
	     static String[] seniorEmployee={"Ashis das","Harihar Samal","Mahatma Gandhi"};

	    public String[] getDepartmentDetails(String compName){
	        if(compName.equalsIgnoreCase("watsoo")){
	            return watsoDepartment;
	        }
	        else if (compName.equalsIgnoreCase("rapidSoft")) {
	            return rapidSoftDepartment;
	            
	        }
	        else{
	            System.out.println("Invalid Entry");
	            return new String[0];
	        }
	        
			
			

	    }
	    public String[] getUserByCompanyName(String compName){
	        if(compName.equalsIgnoreCase("watsoo")){
	            return watsooEmployee;
	        }
	        else if (compName.equalsIgnoreCase("rapidSoft")) {
	            return rapidSoftEmployee;
	            
	        }
	        else{
	            System.out.println("Invalid Entry");
	            return new String[0];
	        }
			

	    }
	    public String getCompanyDetails(String companyName){
	        if(companyName.equalsIgnoreCase("RAPIDSOFT")){
	            System.out.println("Welcom To RapidSoft Technologies");
	        }
	        else if(companyName.equalsIgnoreCase("WATSOO")){
	            System.out.println("Welcome To Watsoo");
	        }
	        else{
	            System.out.println("Invalid Input");
	        }
			return null;
	    }
	    public String getEmployeeByName(String userName){
	    	boolean flag=false;
	    	for(String user:rapidSoftEmployee) {
	    		if(user.equalsIgnoreCase(userName)) {
	    			System.out.println("RapidSoft Technologies");
	    		    flag=true;
	    		}
	    	}
	    	for(String user:watsooEmployee) {
	    		if(user.equalsIgnoreCase(userName)) {
	    			System.out.println("Watsoo Technologies");
	    		    flag=true;
	    		}
	    	}
	        if(flag==false) {
	        	System.out.println("Invalid entry");
	        }
	        return null;
	    }
	    public String[] getSeniorDetails(){
	        return seniorEmployee;
	    }
	
		@Override
		public String learningDetails() {
			// TODO Auto-generated method stub
			System.out.println("Learning Details Sent To Your E-Mail");
			return null;
		}
		@Override
		public String getSeniorDetails(String seniorName) {
			// TODO Auto-generated method stub
			boolean flag1=false;
			for(String user:seniorEmployee) {
	    		if(user.equalsIgnoreCase(seniorName)) {
	    			System.out.println("found");
	    			flag1=true;
	    		
	    		}  	
	    
		    }
			if(flag1==false) {
	    		System.out.println("Not Found");
	    	}
		return null;
	    
	}
}


