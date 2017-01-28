
public class UseOrderedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedArray myArray=new OrderedArray(20);
		myArray.insert(new DataBaseRecord("smith","john",(float)2.7));
		myArray.insert(new DataBaseRecord("adams",15,(float)3.1));
		myArray.insert(new DataBaseRecord("morris",17,(float)3.3));
		
		//myArray.insert(1);
		//myArray.insert(900);
		myArray.printIt();
		//if(myArray.find(1)>=0)
		//	System.out.println("found 1");
		//else
		//	System.out.println("1 not there");
		
		//myArray.delete(900);
		//myArray.printIt();
	}
}
