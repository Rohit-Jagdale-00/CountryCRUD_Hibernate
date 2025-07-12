package app;

import java.util.List;
import java.util.Scanner;

import entity.CountryEntity;
import entity.RegionsEntity;
import service.CountryService;
import service.RegionService;

public class Main {

	public static void main(String[] args) {

		CountryService cservice = new CountryService();
		RegionService rservice = new RegionService();

		RegionsEntity region= new RegionsEntity();
		CountryEntity country=new CountryEntity();
		while(true) {
		Scanner sc=new Scanner(System.in);
		System.out.println("\n1. Add Region");
		System.out.println("2. Update Region");
		System.out.println("3. Delete Region");
		System.out.println("4. All Regions");
		System.out.println("5. Add Country");
		System.out.println("6. Update Country");
		System.out.println("7. Delete Country");
		System.out.println("8. View Countries");
		System.out.println("9. Exit");
		System.out.println("\nEnter your choice :");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter region name :");String regname=sc.nextLine();
			region.setRegion_name(regname);
			rservice.saveRegions(region);
			break;
		
		case 2:
			System.out.println("Enter a id to update ");int id=sc.nextInt();
			System.out.println("Enter a new region name :");String reg=sc.nextLine();
			rservice.updateRegion(id, reg);
			break;
		case 3:
			System.out.println("Enter id to delete :");int id1=sc.nextInt();
			 rservice.deleteRegion(id1);
			 break;
		case 4:
		   List<RegionsEntity> re=rservice.getAllRegions();
		   for(RegionsEntity r: re ) {
			System.out.println(r.getRegion_id()+" | "+r.getRegion_name());
		}
		   break;
		case 5:
			System.out.println("Enter country id :");String conid=sc.nextLine();
		    country.setCountry_id(conid);
		    System.out.println("Enter country name :");String conname=sc.nextLine();
		    country.setCountry_name(conname);
		    System.out.println("Enter region id :");int regid=sc.nextInt();
		    country.setRegion_id(regid);
		    break;
		    
		case 6:
			System.out.println("Enter country id :");String conid1=sc.nextLine();
			System.out.println("Enter a country name :");String conname1=sc.nextLine();
			cservice.updateCountry(conid1, conname1);
			break;
	
		case 7:
			System.out.println("Enter country id to delete :"); String conid2=sc.nextLine();
			cservice.deleteCountry(conid2);
			break;
			
		case 8:
			List<CountryEntity> con=cservice.getAllCountries();
			for(CountryEntity e: con ) {
				System.out.println(e.getCountry_id()+" | "+e.getRegion_id()+" | "+e.getCountry_name());
			}
			break;
		case 9:System.out.println("Exiting....");break;
		default:System.out.println("Invalid choice enter again");
		}
	}
}
}
