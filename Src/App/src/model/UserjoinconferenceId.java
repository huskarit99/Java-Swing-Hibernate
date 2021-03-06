package model;
// Generated Jul 30, 2020 7:57:30 AM by Hibernate Tools 4.3.1



/**
 * UserjoinconferenceId generated by hbm2java
 */
public class UserjoinconferenceId  implements java.io.Serializable {


     private int conferenceId;
     private int userId;

    public UserjoinconferenceId() {
    }

    public UserjoinconferenceId(int conferenceId, int userId) {
       this.conferenceId = conferenceId;
       this.userId = userId;
    }
   
    public int getConferenceId() {
        return this.conferenceId;
    }
    
    public void setConferenceId(int conferenceId) {
        this.conferenceId = conferenceId;
    }
    public int getUserId() {
        return this.userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UserjoinconferenceId) ) return false;
		 UserjoinconferenceId castOther = ( UserjoinconferenceId ) other; 
         
		 return (this.getConferenceId()==castOther.getConferenceId())
 && (this.getUserId()==castOther.getUserId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getConferenceId();
         result = 37 * result + this.getUserId();
         return result;
   }   


}


