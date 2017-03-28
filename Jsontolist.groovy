import groovy.json.JsonSlurper

class ToList{

	 static def list=[];									//list to add all the category of json file

	 public void build_to_list(Object jsonroot){    		// method to build the list where jsonroot is the root object .

			if(jsonroot==null)					
				return;
			int len=jsonroot.size();

			for(int i=0;i<len;i++){							//search the path value for each child
				build_to_list(jsonroot[i].children);		//recursively search the path value 
				list.add(jsonroot[i].path);					//add the path value to the list

			}

	}


	public static void main(String[] feel){


		def inputFile = new File("input.txt") 							    // take input in json format from jsoninput.txt

		def InputJSON = new JsonSlurper().parseText(inputFile.text)   		//parses the json input

		ToList obj=new ToList();

		obj.build_to_list(InputJSON);
		
		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));   //writes the output in a text file 
		out.print(list.reverse())
		System.setOut(out);
		

		}
}