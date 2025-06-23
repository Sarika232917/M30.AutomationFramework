package Practise_advanceselenium;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderPractise {
	
	@Test(dataProvider="customerinfo")
	public void createCustomer(String name,int id)
	{
		System.out.println("Customer name is-"+name);
		System.out.println("Customer id is-"+id);

	}
	
	//to run same @Test with diff set/multiple set of data
	
	@DataProvider(name="customerinfo")
	public Object[][] getData()
	{
		//rows and column there are 3 data sets with 2 info each
		Object[][] data=new Object[3][2];
		
		//first set
		data[0][0]="sarika";
		data[0][1]=13;
		
		//second set
		data[1][0]="sharvi";
		data[1][1]=14;
				
		//third set
		data[2][0]="mayur";
		data[2][1]=15;
		return data;
	}
	}
