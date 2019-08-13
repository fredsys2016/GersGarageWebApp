package garage.com.webapp;

public class Status {

	private String available ;
	private String booked;
	private String inService;
	private String fixedComplete;
	private String collected;
	private String unrepairableScrapped;
	
	public Status()
	{
		this.available="Available";
		this.booked="Booked";
		this.inService="In_Service";
		this.fixedComplete="Fixed/Complete";
		this.collected="Collected";
		this.unrepairableScrapped="Unrepairable/Scrapped";
	}
	
	public String Available()
	{return this.available;}
	public String Booked()
	{return this.booked;}
	public String InService()
	{return this.inService;}
	public String FixedComplete()
	{return this.fixedComplete;}
	public String Collected()
	{return this.collected;}
	public String UnrepairableScrapped()
	{return this.unrepairableScrapped;}
	
	
	
	
	
}
