

//OurGroup.java



import java.util.Vector;



public class OurGroup {



     private Vector<String> groupMembers;

     public OurGroup()

     {

          groupMembers = new Vector<String>();

          groupMembers.add("Stan Smith");

          groupMembers.add("Bart Simpson");

          groupMembers.add("Brandon Bell"); //PUT YOUR NAME HERE
	
          groupMembers.add("Adam Bell"); 
          
          groupMembers.add("Meng Zhang");
      }

     public Vector<String> getGroupMembers () {

          return groupMembers;

     }



}
